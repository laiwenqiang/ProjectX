package com.laiwenqiang.core.charge;

import com.laiwenqiang.common.pipeline.context.EventResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author Lion
 * @date 2023/6/22 21:14
 */
@Data
@Component
public class ChargeResponse implements EventResponse {
    @Setter
    @Getter
    private String status;

    @Getter
    @Setter
    private String message;
}
