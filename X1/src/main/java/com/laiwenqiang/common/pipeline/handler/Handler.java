package com.laiwenqiang.common.pipeline.handler;

import com.laiwenqiang.common.pipeline.context.EventContext;

/**
 * @author Lion
 * @date 2023/6/21 14:18
 */
public interface Handler<T extends EventContext<?, ?>> {
    /**
     * 执行当前Handler
     *
     * @param context 业务上下文
     */
    boolean process(T context);
}
