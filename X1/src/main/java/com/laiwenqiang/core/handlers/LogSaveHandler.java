package com.laiwenqiang.core.handlers;

import com.laiwenqiang.common.pipeline.handler.Handler;
import com.laiwenqiang.core.charge.ChargeContext;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Lion
 * @date 2023/6/20 21:09
 */
@Slf4j
public class LogSaveHandler implements Handler<ChargeContext> {

    @Override
    public boolean process(ChargeContext context) {
        log.info("保存mq");
        return true;
    }

}
