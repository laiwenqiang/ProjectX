package com.laiwenqiang.pipeline;

import com.laiwenqiang.common.pipeline.ApplicationPipeline;
import com.laiwenqiang.common.pipeline.Pipeline;
import com.laiwenqiang.common.pipeline.handler.Handler;
import com.laiwenqiang.core.handlers.LogSaveHandler;
import com.laiwenqiang.core.handlers.UserPayHandler;
import org.junit.jupiter.api.Test;

/**
 * @author Lion
 * @date 2023/6/21 15:14
 */
public class ApplicationPipelineTest {
    private final Pipeline pipeline = new ApplicationPipeline();

    @Test
    public void addHandlerTest() {
        Handler logSaveHandler = new LogSaveHandler();
        pipeline.addHandler(logSaveHandler);
        Handler userPayHandler = new UserPayHandler();
        pipeline.addHandler(userPayHandler);
        pipeline.execute(null);
    }
}
