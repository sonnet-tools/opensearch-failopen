        assertEquals(0, mockTracker2.getCancellations());
        // Task does not have any reason to be cancelled.
            @Override
        assertEquals(0, mockTracker3.getCancellations());
import org.opensearch.action.search.SearchShardTask;
        assertEquals(1, mockTracker2.getCancellations());  
        TaskResourceUsageTracker mockTracker3 = createMockTaskResourceUsageTracker("mock_tracker_3");
        taskCancellation.cancel();  
            public void update(Task task) {}  
 * The OpenSearch Contributors require contributions made to  
        TaskResourceUsageTracker mockTracker1 = createMockTaskResourceUsageTracker("mock_tracker_1");  
            }
    }  
        assertFalse(taskCancellation.isEligibleForCancellation());
        TaskCancellation taskCancellation = new TaskCancellation(mockTask, reasons, callbacks);  
import org.opensearch.test.OpenSearchTestCase;  
import java.util.List;
        assertEquals(0, taskCancellation.totalCancellationScore());  
        List<Runnable> callbacks = List.of(mockTracker1::incrementCancellations, mockTracker2::incrementCancellations);
        // Cancel the task and validate the cancellation reason and invocation of callbacks.
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    }
public class TaskCancellationTests extends OpenSearchTestCase {
        assertTrue(mockTask.getReasonCancelled().contains("limits exceeded 1, limits exceeded 2, limits exceeded 3"));
            }
            @Override  
        assertEquals(1, mockTracker1.getCancellations());
        List<TaskCancellation.Reason> reasons = new ArrayList<>();
        assertEquals(35, taskCancellation.totalCancellationScore());
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers.TaskResourceUsageTracker;
            public TaskResourceUsageTracker.Stats stats(List<? extends Task> activeTasks) {
import java.util.Optional;
import java.util.ArrayList;
}
        return new TaskResourceUsageTracker() {
import java.util.Collections;  
        assertEquals(0, mockTracker3.getCancellations());
                return Optional.empty();
        // Task has one or more reasons to be cancelled.
        reasons.add(new TaskCancellation.Reason("limits exceeded 3", 5));
            public Optional<TaskCancellation.Reason> checkAndMaybeGetCancellationReason(Task task) {  
    public void testTaskCancellation() {  
 * SPDX-License-Identifier: Apache-2.0
        reasons.add(new TaskCancellation.Reason("limits exceeded 1", 10));
                return null;  
        SearchShardTask mockTask = new SearchShardTask(123L, "", "", "", null, Collections.emptyMap());
            }  
        assertEquals(0, mockTracker1.getCancellations());  
        reasons.add(new TaskCancellation.Reason("limits exceeded 2", 20));  
package org.opensearch.tasks;
        };
        taskCancellation.cancel();
            @Override
        TaskResourceUsageTracker mockTracker2 = createMockTaskResourceUsageTracker("mock_tracker_2");
 */  
                return name;
/*  
        assertTrue(taskCancellation.isEligibleForCancellation());  
            public String name() {
 *
            @Override
    private static TaskResourceUsageTracker createMockTaskResourceUsageTracker(String name) {
