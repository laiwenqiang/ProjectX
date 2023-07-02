package com.laiwenqiang.common.pipeline;

import com.laiwenqiang.common.pipeline.context.EventContext;
import com.laiwenqiang.common.pipeline.handler.Handler;
import com.laiwenqiang.core.util.ConfigHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lion
 * @date 2023/6/22 10:39
 */

@Slf4j
@RequiredArgsConstructor
@Component
public class ConfigBasedPipelineFactory implements PipelineFactory {
    /**
     * 配置信息
     */
    private final ConfigHelper configHelper;

    /**
     * 缓存所有已经被创建的pipeline，key为业务编号
     */
    private final Map<String, Pipeline> applicationPipelines = new HashMap<>();

    @Override
    public Pipeline getPipeline(String bizCode) {
        if (applicationPipelines.get(bizCode) == null) {
            try {
                List<String> handlerClassNames = configHelper.getHandlers().get(bizCode);
                applicationPipelines.put(bizCode, createPipeline(handlerClassNames));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return applicationPipelines.get(bizCode);
    }

    private Pipeline createPipeline(List<String> handlerClassNames) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Pipeline pipeline = new ApplicationPipeline();
        for (String x : handlerClassNames) {
            pipeline.addHandler(createHandler(x));
        }
        return pipeline;
    }

    // TODO 一个Handler会被创建多次，考虑使用缓存。如在新建对象后存入一个Map中，后续从Map中取出使用而不是每次创建；
    //  但是从缓存中取出的Handler在设置next后，会改变原有的链条结构，这里需要如何做？
    private Handler<EventContext<?, ?>> createHandler(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return Class.forName(className).asSubclass(Handler.class).newInstance();
    }
}
