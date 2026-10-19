            tracker.update(task);  
        // task with heap usage of [totalHeap - 1] so that it breaches the threshold  
import java.util.List;
            )  
import java.util.Optional;  
 */  
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;
import org.opensearch.common.settings.Settings;
        double allowedHeapUsage = 99.0 * 2.0;
import org.opensearch.search.backpressure.settings.SearchTaskSettings;
        HeapUsageTracker tracker = spy(
        task = createMockTaskWithResourceStats(SearchShardTask.class, 1, totalHeap - 1, randomNonNegativeLong());
    private static final long HEAP_BYTES_THRESHOLD_SEARCH_SHARD_TASK = 100;
        );
        // task with 1 byte of heap usage so that it does not breach the threshold
    public void testSearchTaskEligibleForCancellation() {  
                mockSearchTaskSettings.getHeapMovingAverageWindowSize(),
        // setting the heap percent threshold to minimum  
        reason = tracker.checkAndMaybeGetCancellationReason(task);
        // Record enough observations to make the moving average 'ready'.
        long totalHeap = JvmStats.jvmStats().getMem().getHeapMax().getBytes();
            new HeapUsageTracker(  
import org.opensearch.monitor.jvm.JvmStats;
            randomLongBetween(99, (long) allowedHeapUsage - 1),  
        }
            new HeapUsageTracker(
package org.opensearch.search.backpressure.trackers;
        assertTrue(HeapUsageTracker.isHeapUsageDominatedBySearch(List.of(task), 0.5));
            1,
import org.opensearch.tasks.Task;
    public void testSearchShardTaskEligibleForCancellation() {  
        when(mockSearchShardTaskSettings.getHeapPercentThreshold()).thenReturn(0.0);
        Task task = createMockTaskWithResourceStats(SearchShardTask.class, 1, 50, randomNonNegativeLong());  
            new HeapUsageTracker(
        reason = tracker.checkAndMaybeGetCancellationReason(task);  
        Task task = createMockTaskWithResourceStats(SearchTask.class, 1, 50, randomNonNegativeLong());  
        );
        assertFalse(reason.isPresent());
                mockSearchTaskSettings::getHeapVarianceThreshold,
        SearchShardTaskSettings mockSearchShardTaskSettings = spy(
                mockSearchShardTaskSettings::getHeapPercentThreshold,  
/*  
        task = createMockTaskWithResourceStats(SearchShardTask.class, 1, 200, randomNonNegativeLong());
            tracker.update(task);
            new SearchTaskSettings(mockSettings.getSettings(), mockSettings.getClusterSettings())
import org.opensearch.action.search.SearchShardTask;
        assertFalse(reason.isPresent());
        task = createMockTaskWithResourceStats(SearchShardTask.class, 1, 99, randomNonNegativeLong());
        assertFalse(HeapUsageTracker.isHeapUsageDominatedBySearch(List.of(task), 0.5));  
                SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE  
        );  
        assertEquals(4, reason.get().getCancellationScore());
import org.opensearch.tasks.CancellableTask;  
        CancellableTask task = createMockTaskWithResourceStats(SearchShardTask.class, 1, 1, randomNonNegativeLong());
        // setting the heap percent threshold to minimum
import org.opensearch.common.settings.ClusterSettings;  
        assumeTrue("Skip the test if the hardware doesn't support heap usage tracking", HeapUsageTracker.isHeapTrackingSupported());
    public void testNotEligibleForCancellation() {  
            )
        // Task that has heap usage >= heapBytesThreshold and (movingAverage * heapVariance).
                mockSettings.getClusterSettings(),
            SearchShardTask.class,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.search.SearchTask;
        for (int i = 0; i < HEAP_MOVING_AVERAGE_WINDOW_SIZE; i++) {  
import static org.opensearch.search.backpressure.SearchBackpressureTestHelpers.createMockTaskWithResourceStats;
            new SearchShardTaskSettings(mockSettings.getSettings(), mockSettings.getClusterSettings())
        }
        // Record enough observations to make the moving average 'ready'.
        HeapUsageTracker tracker = spy(  
        // setting the heap percent threshold to minimum
    public void testIsHeapUsageDominatedBySearch() {
    }  
        );  
    }
 * this file be licensed under the Apache-2.0 license or a
            .put(SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), HEAP_MOVING_AVERAGE_WINDOW_SIZE)
        // Record enough observations to make the moving average 'ready'.
        reason = tracker.checkAndMaybeGetCancellationReason(task);
        }
                mockSearchShardTaskSettings.getHeapMovingAverageWindowSize(),  
                SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE
        for (int i = 0; i < HEAP_MOVING_AVERAGE_WINDOW_SIZE; i++) {  
        assertEquals("heap usage exceeded [300b >= 0b]", reason.get().getMessage());  
            .build(),
            .put(SearchTaskSettings.SETTING_HEAP_VARIANCE_THRESHOLD.getKey(), 3.0)
            .put(SearchShardTaskSettings.SETTING_HEAP_VARIANCE_THRESHOLD.getKey(), 2.0)
            tracker.update(task);
        assertEquals(6, reason.get().getCancellationScore());
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);  
 * compatible open source license.
            )
            randomNonNegativeLong()
        when(mockSearchShardTaskSettings.getHeapPercentThreshold()).thenReturn(0.0);
                mockSearchShardTaskSettings::getHeapPercentThreshold,
            new SearchShardTaskSettings(mockSettings.getSettings(), mockSettings.getClusterSettings())
        SearchTaskSettings mockSearchTaskSettings = spy(
    private static final int HEAP_MOVING_AVERAGE_WINDOW_SIZE = 100;  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(reason.isPresent());
    private static final SearchBackpressureSettings mockSettings = new SearchBackpressureSettings(
        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        // Task with heap usage < heapBytesThreshold.  
        // Task with heap usage < heapBytesThreshold should not be cancelled.  
                mockSearchShardTaskSettings::getHeapVarianceThreshold,
        Task task;
}
        assertEquals("heap usage exceeded [200b >= 0b]", reason.get().getMessage());  
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);  
            .put(SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), HEAP_MOVING_AVERAGE_WINDOW_SIZE)  
    private static final long HEAP_BYTES_THRESHOLD_SEARCH_TASK = 50;
import static org.mockito.Mockito.spy;  
        task = createMockTaskWithResourceStats(  
        // Task with heap usage between heapBytesThreshold and (movingAverage * heapVariance) should not be cancelled.
        // Task that has heap usage >= heapBytesThreshold and (movingAverage * heapVariance).
        );
import org.opensearch.test.OpenSearchTestCase;  
                mockSearchShardTaskSettings::getHeapVarianceThreshold,
        );
public class HeapUsageTrackerTests extends OpenSearchTestCase {  
import static org.mockito.Mockito.when;
import org.opensearch.tasks.TaskCancellation;
                mockSearchShardTaskSettings.getHeapMovingAverageWindowSize(),
                SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE  
        when(mockSearchTaskSettings.getHeapPercentThreshold()).thenReturn(0.0);
        Optional<TaskCancellation.Reason> reason;
                mockSearchTaskSettings::getHeapPercentThreshold,  
        );
        Settings.builder()  
    }
        HeapUsageTracker tracker = spy(  
        task = createMockTaskWithResourceStats(SearchTask.class, 1, 300, randomNonNegativeLong());
        SearchShardTaskSettings mockSearchShardTaskSettings = spy(  
                mockSettings.getClusterSettings(),
        assertTrue(reason.isPresent());
    }
        // Not enough observations.  
    );
        assertFalse(reason.isPresent());
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;  
 *
        for (int i = 0; i < HEAP_MOVING_AVERAGE_WINDOW_SIZE; i++) {
                mockSettings.getClusterSettings(),
