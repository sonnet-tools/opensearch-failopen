 * @opensearch.internal
        });
/**
    private final ExecutorService delegate;  
    }  
    @SuppressForbidden(reason = "properly rethrowing errors, see OpenSearchExecutors.rethrowErrors")  
    /**
import org.opensearch.common.SuppressForbidden;
import java.util.List;  
                // Error instead of letting it propagate, so unwrap and rethrow it here the way
 *
    @Override
     */
        return delegate.isTerminated();
/*  
    @Override
    }
    @Override  
                // Tasks submitted via submit()/invokeAll()/invokeAny() are RunnableFutures that capture any thrown
 *
            }
    ContextPreservingExecutorService(ExecutorService delegate, ThreadContext threadContext) {
                OpenSearchExecutors.rethrowErrors(threadContext.unwrap(contextPreserving));
import java.util.concurrent.AbstractExecutorService;
            } finally {
    }
import java.util.concurrent.ExecutorService;
    }
        super();
    public void execute(Runnable command) {
        this.threadContext = threadContext;
package org.opensearch.common.util.concurrent;
    @Override
     * fatal {@link Error} happens before this, so it is called from a finally block. Does nothing by default.
    public void shutdown() {  
    }  
 */  
    public boolean isShutdown() {
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
     * Invoked on the executing thread once a task has finished, whether it completed normally or threw. Rethrowing a  
 * An {@link ExecutorService} wrapper that preserves {@link ThreadContext} across task submissions.  
    public boolean isTerminated() {  
import java.util.concurrent.TimeUnit;  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        delegate.shutdown();
        return delegate.isShutdown();
 */  
            try {
    public List<Runnable> shutdownNow() {
    @Override
        delegate.execute(() -> {
    @Override
        final Runnable contextPreserving = threadContext.preserveContext(command);  
        return delegate.shutdownNow();  
                // OpenSearchThreadPoolExecutor does.  
    }
    protected void onTaskFinished() {}  
        this.delegate = delegate;  
                contextPreserving.run();  
 * SPDX-License-Identifier: Apache-2.0
}
        return delegate.awaitTermination(timeout, unit);  
    }
                onTaskFinished();  
class ContextPreservingExecutorService extends AbstractExecutorService {
    private final ThreadContext threadContext;
 * compatible open source license.
