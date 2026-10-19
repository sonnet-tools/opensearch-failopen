                    cmd.run();  
    private ContextAwareExecutor() {}
 * SPDX-License-Identifier: Apache-2.0
     * Wraps the given executor so that tasks run with the {@code opaque_id} MDC key set
                if (opaqueId != null) {
     */  
 * OpenSearch's {@link org.opensearch.common.util.concurrent.ThreadContext} into Log4j2's
package org.opensearch.analytics.exec;
 */
 *
 * <p>Use this for any analytics engine executor that dispatches work to a thread pool,
/**  
            delegate.execute(() -> {
 */  
/*  
}
        };
                    org.apache.logging.log4j.ThreadContext.remove("opaque_id");
    }  
 * Wraps an {@link Executor} to propagate the {@code X-Opaque-Id} request header from
            });
     * from the current thread's {@code X-Opaque-Id} header.
 *
    public static Executor wrap(Executor delegate, ThreadPool threadPool) {
                    org.apache.logging.log4j.ThreadContext.put("opaque_id", opaqueId);  
 * this file be licensed under the Apache-2.0 license or a
                try {
 * @opensearch.internal  
                } finally {
 * so that all downstream loggers automatically include the opaque ID without explicit  
    /**  
import org.opensearch.tasks.Task;
 * MDC ({@link org.apache.logging.log4j.ThreadContext}) on the executing thread.  
import java.util.concurrent.Executor;
 * parameter passing.
                }  
                }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.threadpool.ThreadPool;
        return cmd -> {
            String opaqueId = threadPool.getThreadContext().getHeader(Task.X_OPAQUE_ID);  
public final class ContextAwareExecutor {
 *
 * compatible open source license.
