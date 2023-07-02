package com.laiwenqiang.common.pipeline.handler;

import com.laiwenqiang.common.pipeline.context.EventContext;

/**
 * @author Lion
 * @date 2023/6/29 23:10
 */
public interface HandlerChain<T extends EventContext<?, ?>> {
    /**
     * 设置当前HandlerChain的下一个HandlerChain
     * @param next 下一个HandlerChain
     */
    void setNext(HandlerChain<T> next);

    /**
     * 获取当前HandlerChain的下一个HandlerChain
     * @return 下一个HandlerChain
     */
    HandlerChain<T> getNext();

    /**
     * 执行当前HandlerChain
     * @param eventContext 事件上下文
     * @return 返回执行结果
     */
    boolean execute(T eventContext);

}
