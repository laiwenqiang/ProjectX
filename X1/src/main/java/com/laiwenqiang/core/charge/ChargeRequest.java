package com.laiwenqiang.core.charge;

import com.laiwenqiang.common.pipeline.context.EventRequest;
import lombok.Data;

/**
 * @author Lion
 * @date 2023/6/19 10:34
 */
@Data
public class ChargeRequest implements EventRequest {
    /**
     * 业务编号，不同的业务类型有不同后台处理
     */
    private String bizCode;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 充电桩ID
     */
    private Long stakeId;
    /**
     * 车牌号
     */
    private String carNo;
    /**
     * 其他信息
     */
    private String extra;
}
