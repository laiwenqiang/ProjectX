package com.laiwenqiang.core.handlers;

import com.laiwenqiang.common.pipeline.handler.Handler;
import com.laiwenqiang.core.charge.Car;
import com.laiwenqiang.core.charge.ChargeContext;
import com.laiwenqiang.core.charge.ChargeRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Lion
 * @date 2023/6/23 08:23
 */
@Slf4j
public class CarInfoQueryHandler implements Handler<ChargeContext> {
    @Override
    public boolean process(ChargeContext context) {
        log.info("从DB中查找对应信息");
        ChargeRequest request = context.getRequest();
        context.setCar(queryFromDB(request.getCarNo()));
        return true;
    }

    private Car queryFromDB(String carNo) {
        Car car = new Car();
        car.setCarNo(carNo);
        return car;
    }
}
