        private final AtomicLong cancellations = new AtomicLong();  
         * Returns the cancellation reason for the given task, if it's eligible for cancellation.  
 * TaskResourceUsageTrackers is used to hold all the {@link TaskResourceUsageTracker} objects.  
    /**
            return new TaskCancellation(task, reasons, cancellationCallback);
    }  
    public TaskResourceUsageTrackers() {
        /**  
         */  
    public static abstract class TaskResourceUsageTracker {
             * @return a {@link TaskCancellation.Reason} why this task should be cancelled otherwise empty
            return cancellations.incrementAndGet();  
         */
         * Method to get taskCancellations due to this tracker for the given {@link CancellableTask} tasks  
public class TaskResourceUsageTrackers {
     */
        all.put(trackerType, tracker);
    private final EnumMap<TaskResourceUsageTrackerType, TaskResourceUsageTracker> all;
         */  
import org.opensearch.core.common.io.stream.Writeable;
    public Optional<TaskResourceUsageTracker> getTracker(TaskResourceUsageTrackerType type) {
     */  
        return new ArrayList<>(all.values());
         * for test purposes only
         * @param tasks cancellation eligible tasks due to node duress and search traffic threshold breach
package org.opensearch.search.backpressure.trackers;
}  
         * Counts the number of cancellations made due to this tracker.
        }
     */  
    }
            Optional<TaskCancellation.Reason> reason = checkAndMaybeGetCancellationReason(task);  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
     * @param tracker is {@link TaskResourceUsageTracker} implementation which will be added
 *
        }
            public Optional<TaskCancellation.Reason> evaluate(final Task task);  
     */
        }  
    public void addTracker(final TaskResourceUsageTracker tracker, final TaskResourceUsageTrackerType trackerType) {
 * this file be licensed under the Apache-2.0 license or a
    }  
         * Returns the tracker's state for tasks as seen in the stats API.
import org.opensearch.tasks.TaskCancellation;
     * @opensearch.internal  
            return tasks.stream()
         * Returns a unique name for this tracker.
        /**  
 * @opensearch.internal
        protected ResourceUsageBreachEvaluator resourceUsageBreachEvaluator;
        /**
        public abstract Stats stats(List<? extends Task> activeTasks);  
        }
     * TaskResourceUsageTracker is used to track completions and cancellations of search related tasks.
import java.util.stream.Collectors;  
             */
     * @return the {@link TaskResourceUsageTrackerType}
        }  
         */  
                .map(task -> this.getTaskCancellation(task, List.of(this::incrementCancellations)))  
        /**
import org.opensearch.tasks.CancellableTask;  
     * Method to access all available {@link TaskResourceUsageTracker}  
 * compatible open source license.
     * getter for tracker for a {@link TaskResourceUsageTrackerType}  
         */
         */
import java.util.ArrayList;
         */
         */  
import org.opensearch.tasks.Task;
    }  
        private TaskCancellation getTaskCancellation(final CancellableTask task, final List<Runnable> cancellationCallback) {
        public void setResourceUsageBreachEvaluator(final ResourceUsageBreachEvaluator resourceUsageBreachEvaluator) {
        /**  
        public abstract String name();
         */
 */  
            List<TaskCancellation.Reason> reasons = new ArrayList<>();
        public long getCancellations() {  
 * The OpenSearch Contributors require contributions made to  
             * evaluates whether the task is eligible for cancellation based on {@link TaskResourceUsageTracker} implementation
        /**
    public List<TaskResourceUsageTracker> all() {  
        /**  
        public void update(Task task) {}  
            reason.ifPresent(reasons::add);
        public List<TaskCancellation> getTaskCancellations(List<CancellableTask> tasks) {
import java.util.concurrent.atomic.AtomicLong;
    /**
        /**
 *
        public interface ResourceUsageBreachEvaluator {  
         * Notifies the tracker to update its state when a task execution completes.
         * @return the list of tasks which are breaching task level thresholds for this {@link TaskResourceUsageTracker}
         * Represents the tracker's state as seen in the stats API.
            return resourceUsageBreachEvaluator.evaluate(task);  
    /**
/*  
/**
        public Optional<TaskCancellation.Reason> checkAndMaybeGetCancellationReason(Task task) {
        return Optional.ofNullable(all.get(type));
             * @param task is input to this method on which the cancellation evaluation is performed  
        }
    }
        public long incrementCancellations() {
     * @return all enabled and available {@link TaskResourceUsageTracker}s
         * @param resourceUsageBreachEvaluator which suggests whether a task should be cancelled or not
 */  
    /**
        /**  
         * This interface carries the logic to decide whether a task should be cancelled or not
     * adds the tracker for the TrackerType  
import java.util.Optional;
            return cancellations.get();
            /**
     * @param type for which the implementation is returned
                .collect(Collectors.toList());
            this.resourceUsageBreachEvaluator = resourceUsageBreachEvaluator;
import org.opensearch.core.xcontent.ToXContentObject;
        all = new EnumMap<>(TaskResourceUsageTrackerType.class);
        }
        public interface Stats extends ToXContentObject, Writeable {}
import java.util.EnumMap;
     * @param trackerType is {@link TaskResourceUsageTrackerType} which depicts the implementation type
                .filter(TaskCancellation::isEligibleForCancellation)
