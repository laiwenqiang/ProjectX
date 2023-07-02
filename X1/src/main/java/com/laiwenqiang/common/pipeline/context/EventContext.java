package com.laiwenqiang.common.pipeline.context;

/**
 * @author Lion
 * @date 2023/6/19 10:14
 */
public interface EventContext<I extends EventRequest, O extends EventResponse> {
    /**
     * 获取业务编码
     *
     * @return 业务编码
     */
    String getBizCode();

    /**
     * 获取请求
     *
     * @return 请求
     */
    I getRequest();

    /**
     * 获取相应
     *
     * @return 相应
     */
    O getResponse();
}
