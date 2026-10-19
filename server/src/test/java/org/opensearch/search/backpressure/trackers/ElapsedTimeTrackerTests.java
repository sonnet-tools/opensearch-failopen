 * this file be licensed under the Apache-2.0 license or a
 *
            .put(SearchTaskSettings.SETTING_ELAPSED_TIME_MILLIS_THRESHOLD.getKey(), 150)   // 150 ms  
        assertFalse(reason.isPresent());  
public class ElapsedTimeTrackerTests extends OpenSearchTestCase {
        assertEquals(1, reason.get().getCancellationScore());  
    public void testSearchShardTaskEligibleForCancellation() {  
    private static final SearchBackpressureSettings mockSettings = new SearchBackpressureSettings(  
        assertTrue(reason.isPresent());
import org.opensearch.common.settings.Settings;
        assertEquals("elapsed time exceeded [200ms >= 100ms]", reason.get().getMessage());
import static org.opensearch.search.backpressure.SearchBackpressureTestHelpers.createMockTaskWithResourceStats;
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
        assertEquals(1, reason.get().getCancellationScore());
import org.opensearch.action.search.SearchShardTask;
        ElapsedTimeTracker tracker = new ElapsedTimeTracker(
            mockSettings.getSearchTaskSettings()::getElapsedTimeNanosThreshold,
            () -> 200000000
    public void testSearchTaskEligibleForCancellation() {
    public void testNotEligibleForCancellation() {
        Task task = createMockTaskWithResourceStats(SearchShardTask.class, 1, 1, 0, randomNonNegativeLong());
import org.opensearch.tasks.TaskCancellation;  
        Settings.builder()
 * The OpenSearch Contributors require contributions made to  
}
        assertEquals("elapsed time exceeded [150ms >= 150ms]", reason.get().getMessage());  
            .build(),
            .put(SearchShardTaskSettings.SETTING_ELAPSED_TIME_MILLIS_THRESHOLD.getKey(), 100) // 100 ms
    }
        );
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);  
 */  
/*  
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;  
        ElapsedTimeTracker tracker = new ElapsedTimeTracker(
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
        Task task = createMockTaskWithResourceStats(SearchTask.class, 1, 1, 0);  
import org.opensearch.test.OpenSearchTestCase;
        );
        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    }
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
            () -> 150000000  
package org.opensearch.search.backpressure.trackers;
import org.opensearch.tasks.Task;
            mockSettings.getSearchShardTaskSettings()::getElapsedTimeNanosThreshold,  
 * compatible open source license.
        assertTrue(reason.isPresent());
            mockSettings.getSearchShardTaskSettings()::getElapsedTimeNanosThreshold,
        ElapsedTimeTracker tracker = new ElapsedTimeTracker(  
            () -> 200000000
import org.opensearch.search.backpressure.settings.SearchTaskSettings;
import org.opensearch.action.search.SearchTask;
    );  
        );  
        Task task = createMockTaskWithResourceStats(SearchShardTask.class, 1, 1, 150000000, randomNonNegativeLong());
import org.opensearch.common.settings.ClusterSettings;  
    }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Optional;  
