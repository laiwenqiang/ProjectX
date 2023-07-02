package com.laiwenqiang.pipeline;

import com.laiwenqiang.common.pipeline.ConfigBasedPipelineFactory;
import com.laiwenqiang.common.pipeline.Pipeline;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @author Lion
 * @date 2023/6/22 11:51
 */

@SpringBootTest
public class ApplicationPipelineFactoryTest {
    @Autowired
    private ConfigBasedPipelineFactory factory;

    @Test
    public void getPipelineTest() {
        Pipeline pipeline = factory.getPipeline("PAYMENT_1");
        pipeline.execute(null);

        Pipeline pipeline2 = factory.getPipeline("PAYMENT_2");
        pipeline2.execute(null);
    }
}
