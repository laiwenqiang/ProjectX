package com.laiwenqiang.core.controller;

import com.laiwenqiang.core.charge.ChargeRequest;
import com.laiwenqiang.core.charge.ChargeResponse;
import com.laiwenqiang.core.service.IChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lion
 * @date 2023/6/19 10:24
 */
@RestController
public class ChargeController {
    @Autowired
    private IChargeService chargeService;
    @Autowired
    private ChargeResponse chargeResponse;

    @PostMapping("/charging")
    public String getChargeStatus(@RequestBody ChargeRequest chargeRequest) {
        chargeService.handle(chargeRequest, chargeResponse);
        return chargeResponse.toString();
    }

    @GetMapping("/charging/{orderId}/status")
    public String getChargeStatus(@PathVariable Long orderId) {
        System.out.println(orderId);
        return "success";
    }

}
