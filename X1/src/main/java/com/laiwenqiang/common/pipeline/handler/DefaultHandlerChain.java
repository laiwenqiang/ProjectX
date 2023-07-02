package com.laiwenqiang.common.pipeline.handler;

import com.laiwenqiang.common.pipeline.context.EventContext;

/**
 * @author Lion
 * @date 2023/6/29 23:12
 */
public class DefaultHandlerChain<T extends EventContext<?, ?>> implements HandlerChain<T> {
    /**
     * 当前HandlerChain中的handler
     */
    private Handler<T> handler;
    private HandlerChain<T> nextHandlerChain;

    public DefaultHandlerChain(Handler<T> handler) {
        this.handler = handler;
    }

    @Override
    public void setNext(HandlerChain<T> next) {
        this.nextHandlerChain = next;
    }

    @Override
    public HandlerChain<T> getNext() {
        return nextHandlerChain;
    }

    @Override
    public boolean execute(T eventContext) {
        if (!handler.process(eventContext)) {
            return false;
        }
        HandlerChain<T> next = getNext();
        return next != null && next.execute(eventContext);
    }
}
