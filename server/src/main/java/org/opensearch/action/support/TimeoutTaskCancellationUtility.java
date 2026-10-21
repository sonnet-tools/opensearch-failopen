        /**
                        "Ignoring the failure to run the provided runnable after timeout of {} with " + "exception",
    /**
    private static class TimeoutRunnableListener<Response> implements ActionListener<Response>, Runnable {
                                e
            wrappedListener.cancellable = client.threadPool().schedule(wrappedListener, timeoutInterval, ThreadPool.Names.GENERIC);
                    new ParameterizedMessage(
                    ),
                            logger.debug(
import org.opensearch.threadpool.ThreadPool;
                if (executeRunnable.compareAndSet(true, false)) {
                                cancelTasksRequest.getTaskId()
            try {
         *
        public void onResponse(Response response) {
 *
                    "Aborting the scheduled cancel task after {}",
import java.util.concurrent.TimeUnit;
        // Runnable to execute after timeout
                    .cluster()
        private final ActionListener<Response> originalListener;
                logger.debug(
                                ),
     * @opensearch.internal
        private final TimeValue timeout;
                                    "Scheduled cancel task with timeout: {} for original task: {} is failed",
            this.originalListener = listener;
public class TimeoutTaskCancellationUtility {
    }
        final TimeValue timeoutInterval = (taskToCancel.getCancellationTimeout() == null) ? timeout : taskToCancel.getCancellationTimeout();
            this.timeoutRunnable = runAfterTimeout;
 */
     * If either a response/failure is received before timeout then the scheduled task is cancelled and response/failure is sent back to
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
        private static final Logger logger = LogManager.getLogger(TimeoutRunnableListener.class);
                );
        }
                            );
                        }
                                "Scheduled cancel task with timeout: {} for original task: {} is successfully completed",
        TimeValue timeout,
import org.opensearch.search.SearchService;
            checkAndCancel();
}
                    timeoutRunnable.run();
                // ignore the exception
                            // Notify the timeoutHandler that the task was canceled due to timeout
import org.opensearch.transport.client.node.NodeClient;
     */
     * the original listener.
import java.util.concurrent.atomic.AtomicBoolean;
 * compatible open source license.
        public void onFailure(Exception e) {
    }
import org.opensearch.threadpool.Scheduler;
                    ex
                            );
     * @param client - {@link NodeClient}
 *
                // force the origin to execute the cancellation as a system user
                cancelTasksRequest.setTaskId(new TaskId(client.getLocalNodeId(), taskToCancel.getId()));
import static org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction.TASKS_ORIGIN;
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
    private static final AtomicBoolean executeResponseOrFailureOnce = new AtomicBoolean(true);
        }
 * @opensearch.internal
        public void run() {
        @Override
    private static final Logger logger = LogManager.getLogger(TimeoutTaskCancellationUtility.class);
        // Note: -1 (or no timeout) will help to turn off cancellation. The combinations will be request level set at -1 or request level
        ActionListener<Response> listener,
                    TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - creationTime)
                                    cancelTasksRequest.getTaskId()
         * @param e the exception that contains details about the task cancellation,
                            timeoutHandler.onTimeout(new TaskCancelledException(cancelTasksRequest.getReason()));
     * @param taskToCancel - task to schedule cancellation for
            } catch (Exception ex) {
        } catch (Exception ex) {
        if (timeoutInterval.equals(SearchService.NO_TIMEOUT)) {
            listenerToReturn = wrappedListener;
     * Implementations of this interface provide a callback method that is invoked
     *
import org.opensearch.core.action.ActionListener;
                                timeoutInterval,
        private final AtomicBoolean executeRunnable = new AtomicBoolean(true);
            checkAndCancel();
         */
         * Called when a cancellable task is cancelled due to a timeout.
     */
            }
     * Wraps a listener with a timeout listener {@link TimeoutRunnableListener} to schedule the task cancellation for provided tasks on
        ActionListener<Response> listenerToReturn = listener;
                final CancelTasksRequest cancelTasksRequest = new CancelTasksRequest();
        }
        @Override
        private volatile Scheduler.ScheduledCancellable cancellable;
import org.opensearch.transport.client.OriginSettingClient;
    }
        @Override
 * The OpenSearch Contributors require contributions made to
                );
            return listenerToReturn;
                cancellable.cancel();
        }
                        public void onResponse(CancelTasksResponse cancelTasksResponse) {
     * @param listener - original listener associated with the task
import org.opensearch.tasks.CancellableTask;
                    .cancelTasks(cancelTasksRequest, new ActionListener<CancelTasksResponse>() {
            this.timeout = timeout;
        }
        try {
        private final long creationTime;
                        timeout
                // timer has not yet expired so cancel it
            logger.warn("Failed to schedule the cancellation task for original task: {}, will continue without it", taskToCancel.getId());
     * A functional interface used to handle the timeout of a cancellable task.
            // if there is any exception in scheduling the cancellation task then continue without it
/*
 * SPDX-License-Identifier: Apache-2.0
                    });
            originalListener.onResponse(response);
                        }
            originalListener.onFailure(e);
import org.opensearch.core.tasks.TaskId;
        private void checkAndCancel() {
                                    timeoutInterval,
                        @Override
                } // else do nothing since either response/failure is already sent to client
            }
        }
            if (executeRunnable.compareAndSet(true, false)) {
                        @Override
        void onTimeout(TaskCancelledException e);
     * @param timeout - {@link TimeValue}
/**
    /**
         *          including the reason for cancellation.
        private final Runnable timeoutRunnable;
                        public void onFailure(Exception e) {
            this.creationTime = System.nanoTime();
import org.apache.logging.log4j.Logger;
    /**
 */
        NodeClient client,
    public interface TimeoutHandler {
import org.opensearch.common.unit.TimeValue;
        CancellableTask taskToCancel,
        TimeoutRunnableListener(TimeValue timeout, ActionListener<Response> listener, Runnable runAfterTimeout) {
    ) {
 * this file be licensed under the Apache-2.0 license or a
     * when a task is cancelled due to a timeout.
        }
import org.apache.logging.log4j.message.ParameterizedMessage;
                new OriginSettingClient(client, TASKS_ORIGIN).admin()
 * Utility to cancel a timeout task
                cancelTasksRequest.setReason("Cancellation timeout of " + timeoutInterval + " is expired");
     * Timeout listener which executes the provided runnable after timeout is expired and if a response/failure is not yet received.
        return listenerToReturn;
import org.apache.logging.log4j.LogManager;
import org.opensearch.core.tasks.TaskCancelledException;
                                new ParameterizedMessage(
     * @return wrapped listener
            });
     * generic thread pool
        // set to null and cluster level set to -1.
    public static <Response> ActionListener<Response> wrapWithCancellationListener(
                            logger.error(
            final TimeoutRunnableListener<Response> wrappedListener = new TimeoutRunnableListener<>(timeoutInterval, listener, () -> {
                logger.error(
package org.opensearch.action.support;
     */
        TimeoutHandler timeoutHandler
