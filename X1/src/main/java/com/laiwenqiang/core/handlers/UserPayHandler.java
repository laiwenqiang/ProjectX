package com.laiwenqiang.core.handlers;

import com.laiwenqiang.common.pipeline.handler.Handler;
import com.laiwenqiang.core.charge.ChargeContext;
import com.laiwenqiang.core.charge.ChargeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Lion
 * @date 2023/6/20 21:03
 */
@Slf4j
public class UserPayHandler implements Handler<ChargeContext> {

    @Override
    public boolean process(ChargeContext context) {
        log.info("支付判断逻辑");
        ChargeResponse response = context.getResponse();
        response.setStatus("success");
        response.setMessage("车牌：" + context.getCar().getCarNo() + "，支付成功");
        return true;
    }
}
