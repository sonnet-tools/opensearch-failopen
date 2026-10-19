        }
                                cancelTasksRequest.getTaskId()
     * If either a response/failure is received before timeout then the scheduled task is cancelled and response/failure is sent back to  
        // Note: -1 (or no timeout) will help to turn off cancellation. The combinations will be request level set at -1 or request level
            final TimeoutRunnableListener<Response> wrappedListener = new TimeoutRunnableListener<>(timeoutInterval, listener, () -> {
            this.timeout = timeout;  
        ActionListener<Response> listenerToReturn = listener;
        /**
        TimeValue timeout,  
 * @opensearch.internal
        try {  
            this.timeoutRunnable = runAfterTimeout;
import org.opensearch.core.tasks.TaskCancelledException;
            // if there is any exception in scheduling the cancellation task then continue without it  
            this.creationTime = System.nanoTime();  
         */  
                    .cancelTasks(cancelTasksRequest, new ActionListener<CancelTasksResponse>() {
import org.opensearch.tasks.CancellableTask;
                        }  
            logger.warn("Failed to schedule the cancellation task for original task: {}, will continue without it", taskToCancel.getId());
            });
        @Override  
import org.apache.logging.log4j.message.ParameterizedMessage;  
                            timeoutHandler.onTimeout(new TaskCancelledException(cancelTasksRequest.getReason()));
        }
                        }  
        void onTimeout(TaskCancelledException e);
 * this file be licensed under the Apache-2.0 license or a
     * Timeout listener which executes the provided runnable after timeout is expired and if a response/failure is not yet received.
            originalListener.onFailure(e);  
    }
                    timeoutRunnable.run();
        private final long creationTime;  
        }
    public interface TimeoutHandler {
public class TimeoutTaskCancellationUtility {  
import org.opensearch.core.tasks.TaskId;  
            }  
     */
 * compatible open source license.
                        timeout  
                logger.error(  
                                    timeoutInterval,
        private final Runnable timeoutRunnable;  
        TimeoutHandler timeoutHandler
/*  
        @Override  
 *
        // Runnable to execute after timeout  
            wrappedListener.cancellable = client.threadPool().schedule(wrappedListener, timeoutInterval, ThreadPool.Names.GENERIC);  
                if (executeRunnable.compareAndSet(true, false)) {  
        private final ActionListener<Response> originalListener;
                cancelTasksRequest.setReason("Cancellation timeout of " + timeoutInterval + " is expired");
            checkAndCancel();
     * @param timeout - {@link TimeValue}
import org.opensearch.transport.client.node.NodeClient;  
     * generic thread pool
        return listenerToReturn;  
            originalListener.onResponse(response);  
import java.util.concurrent.atomic.AtomicBoolean;  
        } catch (Exception ex) {
        NodeClient client,
import org.opensearch.threadpool.Scheduler;  
     * the original listener.
 * Utility to cancel a timeout task
                new OriginSettingClient(client, TASKS_ORIGIN).admin()  
                );  
                    });
                            );
    private static final Logger logger = LogManager.getLogger(TimeoutTaskCancellationUtility.class);
                        @Override
        }
        private final TimeValue timeout;
        private final AtomicBoolean executeRunnable = new AtomicBoolean(true);
     * @param client - {@link NodeClient}  
                logger.debug(  
         * @param e the exception that contains details about the task cancellation,
                // ignore the exception
import org.apache.logging.log4j.Logger;
     * Implementations of this interface provide a callback method that is invoked
        @Override  
                // timer has not yet expired so cancel it
        public void onFailure(Exception e) {
                            // Notify the timeoutHandler that the task was canceled due to timeout
            listenerToReturn = wrappedListener;
import org.opensearch.threadpool.ThreadPool;
            return listenerToReturn;  
 *  
import java.util.concurrent.TimeUnit;
                    ex
            }
         *  
                    "Aborting the scheduled cancel task after {}",
        // set to null and cluster level set to -1.  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
        private static final Logger logger = LogManager.getLogger(TimeoutRunnableListener.class);
package org.opensearch.action.support;
    /**  
                                "Scheduled cancel task with timeout: {} for original task: {} is successfully completed",  
        private volatile Scheduler.ScheduledCancellable cancellable;
                    TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - creationTime)
        ActionListener<Response> listener,
import org.opensearch.common.unit.TimeValue;  
     * @opensearch.internal  
                                    "Scheduled cancel task with timeout: {} for original task: {} is failed",  
        }
import org.opensearch.core.action.ActionListener;
        }
 * The OpenSearch Contributors require contributions made to  
        private void checkAndCancel() {
                        @Override  
                                new ParameterizedMessage(
 * SPDX-License-Identifier: Apache-2.0
                            logger.error(
 */
                    new ParameterizedMessage(
    public static <Response> ActionListener<Response> wrapWithCancellationListener(  
            } catch (Exception ex) {
        public void run() {
                                    cancelTasksRequest.getTaskId()
                    ),
                        "Ignoring the failure to run the provided runnable after timeout of {} with " + "exception",
        final TimeValue timeoutInterval = (taskToCancel.getCancellationTimeout() == null) ? timeout : taskToCancel.getCancellationTimeout();
    private static final AtomicBoolean executeResponseOrFailureOnce = new AtomicBoolean(true);
                cancellable.cancel();
                final CancelTasksRequest cancelTasksRequest = new CancelTasksRequest();
     */
                            );  
                                ),  
                        public void onResponse(CancelTasksResponse cancelTasksResponse) {
    private static class TimeoutRunnableListener<Response> implements ActionListener<Response>, Runnable {
            if (executeRunnable.compareAndSet(true, false)) {
                } // else do nothing since either response/failure is already sent to client
}  
     * @param listener - original listener associated with the task  
    ) {  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
     * when a task is cancelled due to a timeout.  
                                timeoutInterval,
/**
    }
        }
     * @return wrapped listener
        CancellableTask taskToCancel,
                            logger.debug(
                    .cluster()
        TimeoutRunnableListener(TimeValue timeout, ActionListener<Response> listener, Runnable runAfterTimeout) {
 */  
     * @param taskToCancel - task to schedule cancellation for
                        public void onFailure(Exception e) {  
     *
import org.opensearch.search.SearchService;
                cancelTasksRequest.setTaskId(new TaskId(client.getLocalNodeId(), taskToCancel.getId()));  
                );  
            try {
                // force the origin to execute the cancellation as a system user
         *          including the reason for cancellation.
         * Called when a cancellable task is cancelled due to a timeout.
     * Wraps a listener with a timeout listener {@link TimeoutRunnableListener} to schedule the task cancellation for provided tasks on
import static org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction.TASKS_ORIGIN;
                                e
            this.originalListener = listener;
    /**
     * A functional interface used to handle the timeout of a cancellable task.
    /**  
     */
            checkAndCancel();
    }
        public void onResponse(Response response) {
import org.apache.logging.log4j.LogManager;
import org.opensearch.transport.client.OriginSettingClient;
        if (timeoutInterval.equals(SearchService.NO_TIMEOUT)) {
