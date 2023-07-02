package com.laiwenqiang.common.pipeline;

import com.laiwenqiang.common.pipeline.context.EventContext;
import com.laiwenqiang.common.pipeline.handler.DefaultHandlerChain;
import com.laiwenqiang.common.pipeline.handler.Handler;
import com.laiwenqiang.common.pipeline.handler.HandlerChain;

/**
 * @author Lion
 * @date 2023/6/19 15:59
 */
public class ApplicationPipeline implements Pipeline {
    private HandlerChain<EventContext<?, ?>> first;
    // TODO
    private HandlerChain<EventContext<?, ?>> basic;

    @Override
    public void addHandler(Handler<EventContext<?, ?>> handler) {
        if (first == null) {
            first = new DefaultHandlerChain<>(handler);
            return;
        }

        HandlerChain<EventContext<?, ?>> current = first;
        while (current != null) {
            if (current.getNext() == null) {
                current.setNext(new DefaultHandlerChain<>(handler));
                break;
            }
            current = current.getNext();
        }
    }

    @Override
    public void execute(EventContext<?, ?> eventContext) {
        first.execute(eventContext);
    }
}
