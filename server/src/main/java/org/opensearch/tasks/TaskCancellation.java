            }
     * Returns the sum of all cancellation scores.
     * Represents the cancellation reason for a task.
        runOnCancelCallbacks();  
        }
            return cancellationScore;  
     */
            return;
        public String getMessage() {
        if (isEligibleForCancellation() == false) {
    }
    }
            return message;
            return this;  
 * It doesn't guarantee that the task will actually get cancelled or not; that decision is left to the caller.
        taskManager.cancelTaskAndDescendants(task, getReasonString(), false, ActionListener.wrap(() -> {}));
        for (Runnable callback : onCancelCallbacks) {
        List<Exception> exceptions = new ArrayList<>();
        }
     */  
import org.opensearch.ExceptionsHelper;
        public Reason(String message, int cancellationScore) {
import org.opensearch.core.action.ActionListener;
    }  
            this.cancellationScore = cancellationScore;
    }  
        }  
/*  
    public TaskCancellation merge(final TaskCancellation other) {
    public List<Runnable> getOnCancelCallbacks() {
     */  
        return task;
    public int totalCancellationScore() {  
        if (other == this) {
    }
import java.util.List;
import java.util.ArrayList;
        }
        return reasons.stream().map(Reason::getMessage).collect(Collectors.joining(", "));
    private void runOnCancelCallbacks() {  
package org.opensearch.tasks;
 */  
                callback.run();
        return reasons.stream().mapToInt(Reason::getCancellationScore).sum();
    public List<Reason> getReasons() {
        runOnCancelCallbacks();  
    }
                exceptions.add(e);  
    }
     * invokes all onCancelCallbacks.
 * <p>
     * A task with a higher score suggests greater possibility of recovering the node when it is cancelled.
        public int getCancellationScore() {
    private final CancellableTask task;
    }
        this.reasons = reasons;
        this.onCancelCallbacks = onCancelCallbacks;  
    /**  
     */
        return reasons;
        newOnCancelCallbacks.addAll(other.onCancelCallbacks);
        }  
 * It contains a list of cancellation reasons along with callbacks that are invoked when cancel() is called.  
 * TaskCancellation represents a task eligible for cancellation.  
    /**
        final List<Reason> newReasons = new ArrayList<>(reasons);
     *  Cancels the task and its descendants and invokes all onCancelCallbacks.
    public String getReasonString() {  
     */
    }
        this.task = task;
    /**
 *
public class TaskCancellation implements Comparable<TaskCancellation> {
 * @opensearch.internal
    public void cancel() {  
    public CancellableTask getTask() {  
    }
    public void cancelTaskAndDescendants(TaskManager taskManager) {  
            } catch (Exception e) {
     */
        newReasons.addAll(other.getReasons());  
        private final String message;
    /**  
        task.cancel(getReasonString());
 * The OpenSearch Contributors require contributions made to  
        if (isEligibleForCancellation() == false) {
    }
     * <p>
    }
        return (task.isCancelled() == false) && (reasons.size() > 0);
        return onCancelCallbacks;  
     * Cancels the task and invokes all onCancelCallbacks.
    }
            try {  
 * compatible open source license.
        return new TaskCancellation(task, newReasons, newOnCancelCallbacks);  
 */  
    /**  
        return Integer.compare(totalCancellationScore(), other.totalCancellationScore());
        final List<Runnable> newOnCancelCallbacks = new ArrayList<>(onCancelCallbacks);
        }
        }  
 *
 * this file be licensed under the Apache-2.0 license or a
    @Override
    private final List<Runnable> onCancelCallbacks;
            return;
    public TaskCancellation(CancellableTask task, List<Reason> reasons, List<Runnable> onCancelCallbacks) {  
    public static class Reason {
        private final int cancellationScore;  
     * A task is eligible for cancellation if it has one or more cancellation reasons, and is not already cancelled.
    private final List<Reason> reasons;  
    public boolean isEligibleForCancellation() {
     * A zero score indicates no reason to cancel the task.  
}  
/**
    /**  
    public int compareTo(TaskCancellation other) {  
            this.message = message;  
import java.util.stream.Collectors;  
 * SPDX-License-Identifier: Apache-2.0
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptions);  
