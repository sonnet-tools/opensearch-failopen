 * The OpenSearch Contributors require contributions made to  
/**  
        this.runnableTaskListener = runnableTaskListener;  
        if (original instanceof AbstractRunnable abstractRunnable) {  
                runnableTaskListener.get().taskExecutionFinishedOnThread(taskId, currentThread().threadId());
    public void onFailure(Exception e) {
        }
 * entities listening to the events.
 */
import java.util.concurrent.atomic.AtomicReference;
        return original;  
import org.opensearch.common.util.concurrent.AbstractRunnable;
    private final Runnable original;
    }
        if (Objects.nonNull(taskId)) {
import static java.lang.Thread.currentThread;  
 * It's able to associate runnable with a task with the help of task Id available in thread context.
 * Responsible for wrapping the original task's runnable and sending updates on when it starts and finishes to
        final Runnable original,
            if (Objects.nonNull(taskId)) {
            runnableTaskListener.get().taskExecutionStartedOnThread(taskId, currentThread().threadId());  
import org.opensearch.tasks.TaskManager;
    @Override
public class TaskAwareRunnable extends AbstractRunnable implements WrappedRunnable {  
        this.threadContext = threadContext;
    }
 *
import java.util.Objects;  
        final ThreadContext threadContext,  
    public void onRejection(final Exception e) {
        }  
            logger.debug("Task Id not available in thread context. Skipping update. Thread Info: {}", Thread.currentThread());
        }
 */  
            abstractRunnable.onRejection(e);
    @Override
    @Override
        assert runnableTaskListener.get() != null : "Listener should be attached";  
    public boolean isForceExecution() {  
    public Runnable unwrap() {
        final AtomicReference<RunnableTaskExecutionListener> runnableTaskListener
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.util.concurrent.ThreadContext;
        } else {
import org.opensearch.ExceptionsHelper;  
    @Override  
import org.apache.logging.log4j.Logger;
        Long taskId = threadContext.getTransient(TASK_ID);
import static org.opensearch.tasks.TaskResourceTrackingService.TASK_ID;
/*  
            ExceptionsHelper.reThrowIfNotNull(e);  
        return original instanceof AbstractRunnable abstractRunnable && abstractRunnable.isForceExecution();
    public TaskAwareRunnable(
    }
        } else {
package org.opensearch.threadpool;
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.util.concurrent.WrappedRunnable;  
        this.original = original;
    private final AtomicReference<RunnableTaskExecutionListener> runnableTaskListener;  
    private static final Logger logger = LogManager.getLogger(TaskManager.class);
    protected void doRun() throws Exception {
    }  
    private final ThreadContext threadContext;
}
        ExceptionsHelper.reThrowIfNotNull(e);
            }  
    }
    }
    @Override
            original.run();
 * <p>  
    ) {  
 * SPDX-License-Identifier: Apache-2.0
        try {
        } finally {  
 * compatible open source license.
