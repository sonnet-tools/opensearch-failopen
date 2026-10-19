        return completed.sum();
     * running or about to be, making this both the in-flight task count and the live thread count.
        } finally {
 * An {@link ExecutorService} that runs each task on its own virtual thread, preserving the {@link ThreadContext} at
     * Returns the number of tasks that have finished executing.
    @Override
     * Tasks submitted but not yet finished. A thread-per-task executor has no queue, so a submitted task is either
 */  
}  
            submitted = true;
 * @opensearch.internal
 * submission time.  
     */
        boolean submitted = false;
        try {
        // Clamp to zero because LongAdder::sum isn't atomic when concurrent updates
        active.decrement();  
        completed.increment();
        }
 *
        // Do a simple cast to int because if active count exceeds max int we have
    @Override
    /**  
        return (int) Math.max(0, active.sum());  
    VirtualThreadPerTaskExecutorService(ExecutorService delegate, ThreadContext threadContext) {  
     */  
 * The OpenSearch Contributors require contributions made to  
                active.decrement();
        // happen but is good enough for stats.  
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.LongAdder;
    }
    }
    private final LongAdder completed = new LongAdder();
    public int getActiveCount() {
    }
 * SPDX-License-Identifier: Apache-2.0
        active.increment();  
    }
    /** Tasks that have finished, whether normally or by throwing. */  
 *
 * this file be licensed under the Apache-2.0 license or a
    public void execute(Runnable command) {
package org.opensearch.common.util.concurrent;
        // bigger problems than this integer overflow.
    public long getCompletedTaskCount() {  
 * compatible open source license.
    }
 */  
    /**  
     */  
            super.execute(command);  
/**
    protected void onTaskFinished() {
public class VirtualThreadPerTaskExecutorService extends ContextPreservingExecutorService {
            if (submitted == false) {  
     * Returns the number of tasks that have been submitted but have not yet finished.
                // the delegate rejected the task (or was already shut down), so it will never run
            }  
    /**
    private final LongAdder active = new LongAdder();
        super(delegate, threadContext);
/*  
