package com.laiwenqiang.common.pipeline;

import com.laiwenqiang.common.pipeline.context.EventContext;
import com.laiwenqiang.common.pipeline.handler.Handler;

/**
 * @author Lion
 * @date 2023/6/21 14:16
 */
public interface Pipeline {
    /**
     * 添加Handler处理，编排业务逻辑
     *
     * @param handler 业务处理器
     *
     */
    void addHandler(Handler<EventContext<?, ?>> handler);

    /**
     * 执行Pipeline
     *
     * @param eventContext 业务处理上下文
     */
    void execute(EventContext<?, ?> eventContext);
}
