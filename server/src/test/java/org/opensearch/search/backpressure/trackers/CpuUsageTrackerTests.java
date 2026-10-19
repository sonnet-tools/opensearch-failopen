    private static final SearchBackpressureSettings mockSettings = new SearchBackpressureSettings(
 *
        Task task = createMockTaskWithResourceStats(SearchTask.class, 100000000, 200, randomNonNegativeLong());
import static org.opensearch.search.backpressure.SearchBackpressureTestHelpers.createMockTaskWithResourceStats;
        Task task = createMockTaskWithResourceStats(SearchShardTask.class, 200000000, 200, randomNonNegativeLong());  
 * SPDX-License-Identifier: Apache-2.0
        CpuUsageTracker tracker = new CpuUsageTracker(mockSettings.getSearchShardTaskSettings()::getCpuTimeNanosThreshold);
        Task task = createMockTaskWithResourceStats(SearchShardTask.class, 5000000, 200, randomNonNegativeLong());
    }  
import java.util.Optional;  
        assertEquals("cpu usage exceeded [100ms >= 25ms]", reason.get().getMessage());
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.settings.Settings;
package org.opensearch.search.backpressure.trackers;
import org.opensearch.action.search.SearchShardTask;
    }  
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
/*  
 * this file be licensed under the Apache-2.0 license or a
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);  
        CpuUsageTracker tracker = new CpuUsageTracker(mockSettings.getSearchShardTaskSettings()::getCpuTimeNanosThreshold);
public class CpuUsageTrackerTests extends OpenSearchTestCase {
            .put(SearchShardTaskSettings.SETTING_CPU_TIME_MILLIS_THRESHOLD.getKey(), 15)  // 15 ms
            .put(SearchTaskSettings.SETTING_CPU_TIME_MILLIS_THRESHOLD.getKey(), 25)   // 25 ms
 * compatible open source license.
        CpuUsageTracker tracker = new CpuUsageTracker(mockSettings.getSearchTaskSettings()::getCpuTimeNanosThreshold);  
        assertEquals("cpu usage exceeded [200ms >= 15ms]", reason.get().getMessage());  
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;  
import org.opensearch.search.backpressure.settings.SearchTaskSettings;
    public void testNotEligibleForCancellation() {  
        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    public void testSearchShardTaskEligibleForCancellation() {
        Settings.builder()  
            .build(),  
        assertFalse(reason.isPresent());
import org.opensearch.action.search.SearchTask;
        assertEquals(1, reason.get().getCancellationScore());
 * The OpenSearch Contributors require contributions made to  
        assertTrue(reason.isPresent());
import org.opensearch.common.settings.ClusterSettings;  
    }
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
 */  
    );
import org.opensearch.tasks.TaskCancellation;  
    public void testSearchTaskEligibleForCancellation() {
import org.opensearch.tasks.Task;
        assertTrue(reason.isPresent());  
}
        assertEquals(1, reason.get().getCancellationScore());
