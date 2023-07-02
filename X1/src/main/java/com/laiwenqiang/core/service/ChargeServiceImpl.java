package com.laiwenqiang.core.service;

import com.laiwenqiang.common.pipeline.ConfigBasedPipelineFactory;
import com.laiwenqiang.common.pipeline.Pipeline;
import com.laiwenqiang.core.charge.ChargeContext;
import com.laiwenqiang.core.charge.ChargeRequest;
import com.laiwenqiang.core.charge.ChargeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Lion
 * @date 2023/6/19 10:50
 */
@Service
@RequiredArgsConstructor
public class ChargeServiceImpl implements IChargeService {
    private final ConfigBasedPipelineFactory pipelineFactory;

    @Override
    public void handle(ChargeRequest chargeRequest, ChargeResponse chargeResponse) {
        String bizCode = chargeRequest.getBizCode();
        ChargeContext chargeContext = new ChargeContext(chargeRequest.getBizCode(), chargeRequest, chargeResponse);
        Pipeline pipeline = pipelineFactory.getPipeline(bizCode);
        pipeline.execute(chargeContext);
    }
}
