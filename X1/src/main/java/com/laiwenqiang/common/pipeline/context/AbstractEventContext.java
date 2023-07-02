package com.laiwenqiang.common.pipeline.context;

/**
 * @author Lion
 * @date 2023/6/19 10:14
 */

public abstract class AbstractEventContext<I extends EventRequest, O extends EventResponse>
        implements EventContext<I, O> {
    /**
     * 业务编号
     */
    private final String bizCode;

    /**
     * 请求
     */
    private final I request;

    /**
     * 相应
     */
    private final O response;

    public AbstractEventContext(String bizCode, I request, O response) {
        this.bizCode = bizCode;
        this.request = request;
        this.response = response;
    }

    @Override
    public String getBizCode() {
        return bizCode;
    }

    @Override
    public I getRequest() {
        return request;
    }

    @Override
    public O getResponse() {
        return response;
    }
}
