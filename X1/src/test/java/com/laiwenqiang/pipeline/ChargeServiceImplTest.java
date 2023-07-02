package com.laiwenqiang.pipeline;

import com.laiwenqiang.core.charge.ChargeRequest;
import com.laiwenqiang.core.charge.ChargeResponse;
import com.laiwenqiang.core.service.IChargeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Lion
 * @date 2023/7/1 16:26
 */
@SpringBootTest
public class ChargeServiceImplTest {
    @Autowired
    private IChargeService chargeService;

    @Test
    public void handleTest() {
        ChargeRequest chargeRequest = new ChargeRequest();
        chargeRequest.setBizCode("CHARGE_1");
        ChargeResponse chargeResponse = new ChargeResponse();

        chargeService.handle(chargeRequest, chargeResponse);
    }
}
