        when(mockSearchTaskSettings.getHeapPercentThreshold()).thenReturn(0.0);
}
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
        // setting the heap percent threshold to minimum
                SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE
                mockSettings.getClusterSettings(),
            randomNonNegativeLong()
import org.opensearch.search.backpressure.settings.SearchTaskSettings;
import org.opensearch.action.search.SearchShardTask;
        // Task that has heap usage >= heapBytesThreshold and (movingAverage * heapVariance).
    }
 * SPDX-License-Identifier: Apache-2.0
        );
        }
            .build(),
        task = createMockTaskWithResourceStats(SearchShardTask.class, 1, 99, randomNonNegativeLong());
        // setting the heap percent threshold to minimum
        Task task = createMockTaskWithResourceStats(SearchTask.class, 1, 50, randomNonNegativeLong());
        reason = tracker.checkAndMaybeGetCancellationReason(task);
        long totalHeap = JvmStats.jvmStats().getMem().getHeapMax().getBytes();
        assertEquals(6, reason.get().getCancellationScore());
/*
import static org.mockito.Mockito.when;
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;
    private static final SearchBackpressureSettings mockSettings = new SearchBackpressureSettings(
        assertEquals("heap usage exceeded [200b >= 0b]", reason.get().getMessage());
    public void testNotEligibleForCancellation() {
        reason = tracker.checkAndMaybeGetCancellationReason(task);
        );
        Task task = createMockTaskWithResourceStats(SearchShardTask.class, 1, 50, randomNonNegativeLong());
        task = createMockTaskWithResourceStats(SearchTask.class, 1, 300, randomNonNegativeLong());
        assertTrue(reason.isPresent());
            new SearchShardTaskSettings(mockSettings.getSettings(), mockSettings.getClusterSettings())
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
                mockSearchShardTaskSettings.getHeapMovingAverageWindowSize(),
            )
        Settings.builder()
        Optional<TaskCancellation.Reason> reason;
        task = createMockTaskWithResourceStats(SearchShardTask.class, 1, 200, randomNonNegativeLong());
    }
        HeapUsageTracker tracker = spy(
import org.opensearch.common.settings.ClusterSettings;
        assertFalse(reason.isPresent());
import org.opensearch.tasks.Task;
        );
 *
import org.opensearch.monitor.jvm.JvmStats;
            new HeapUsageTracker(
        // task with heap usage of [totalHeap - 1] so that it breaches the threshold
        // Task that has heap usage >= heapBytesThreshold and (movingAverage * heapVariance).
        }
        }
        // Not enough observations.
        when(mockSearchShardTaskSettings.getHeapPercentThreshold()).thenReturn(0.0);
        assertEquals(4, reason.get().getCancellationScore());
                mockSearchTaskSettings.getHeapMovingAverageWindowSize(),
        // Task with heap usage < heapBytesThreshold should not be cancelled.
            randomLongBetween(99, (long) allowedHeapUsage - 1),
        SearchShardTaskSettings mockSearchShardTaskSettings = spy(
                mockSettings.getClusterSettings(),
            )
            1,
            new SearchShardTaskSettings(mockSettings.getSettings(), mockSettings.getClusterSettings())
    public void testIsHeapUsageDominatedBySearch() {
        Task task;
        // Record enough observations to make the moving average 'ready'.
import org.opensearch.action.search.SearchTask;
        for (int i = 0; i < HEAP_MOVING_AVERAGE_WINDOW_SIZE; i++) {
    public void testSearchTaskEligibleForCancellation() {
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
    }
        SearchTaskSettings mockSearchTaskSettings = spy(
 * The OpenSearch Contributors require contributions made to
        reason = tracker.checkAndMaybeGetCancellationReason(task);
        // setting the heap percent threshold to minimum
        SearchShardTaskSettings mockSearchShardTaskSettings = spy(
        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                mockSearchShardTaskSettings::getHeapPercentThreshold,
        when(mockSearchShardTaskSettings.getHeapPercentThreshold()).thenReturn(0.0);
            new HeapUsageTracker(
        assertTrue(reason.isPresent());
    );
        );
import org.opensearch.tasks.TaskCancellation;
        // Task with heap usage < heapBytesThreshold.
import java.util.List;
        );
                mockSearchShardTaskSettings::getHeapVarianceThreshold,
        assertFalse(reason.isPresent());
            new SearchTaskSettings(mockSettings.getSettings(), mockSettings.getClusterSettings())
 * compatible open source license.
        double allowedHeapUsage = 99.0 * 2.0;
            .put(SearchShardTaskSettings.SETTING_HEAP_VARIANCE_THRESHOLD.getKey(), 2.0)
            .put(SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), HEAP_MOVING_AVERAGE_WINDOW_SIZE)
        for (int i = 0; i < HEAP_MOVING_AVERAGE_WINDOW_SIZE; i++) {
            .put(SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), HEAP_MOVING_AVERAGE_WINDOW_SIZE)
        );
import org.opensearch.common.settings.Settings;
            new HeapUsageTracker(
import static org.opensearch.search.backpressure.SearchBackpressureTestHelpers.createMockTaskWithResourceStats;
public class HeapUsageTrackerTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(HeapUsageTracker.isHeapUsageDominatedBySearch(List.of(task), 0.5));
        // Record enough observations to make the moving average 'ready'.
            )
            SearchShardTask.class,
        // task with 1 byte of heap usage so that it does not breach the threshold
        // Task with heap usage between heapBytesThreshold and (movingAverage * heapVariance) should not be cancelled.
        for (int i = 0; i < HEAP_MOVING_AVERAGE_WINDOW_SIZE; i++) {
import static org.mockito.Mockito.spy;
    private static final long HEAP_BYTES_THRESHOLD_SEARCH_SHARD_TASK = 100;
        assertFalse(HeapUsageTracker.isHeapUsageDominatedBySearch(List.of(task), 0.5));
            tracker.update(task);
        CancellableTask task = createMockTaskWithResourceStats(SearchShardTask.class, 1, 1, randomNonNegativeLong());
    private static final long HEAP_BYTES_THRESHOLD_SEARCH_TASK = 50;
        task = createMockTaskWithResourceStats(
                mockSearchShardTaskSettings::getHeapPercentThreshold,
                mockSearchTaskSettings::getHeapPercentThreshold,
 */
            tracker.update(task);
        assertEquals("heap usage exceeded [300b >= 0b]", reason.get().getMessage());
    private static final int HEAP_MOVING_AVERAGE_WINDOW_SIZE = 100;
        HeapUsageTracker tracker = spy(
                mockSettings.getClusterSettings(),
        assertFalse(reason.isPresent());
        task = createMockTaskWithResourceStats(SearchShardTask.class, 1, totalHeap - 1, randomNonNegativeLong());
                SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE
    }
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.tasks.CancellableTask;
        assumeTrue("Skip the test if the hardware doesn't support heap usage tracking", HeapUsageTracker.isHeapTrackingSupported());
        HeapUsageTracker tracker = spy(
import java.util.Optional;
        );
    public void testSearchShardTaskEligibleForCancellation() {
                mockSearchShardTaskSettings.getHeapMovingAverageWindowSize(),
package org.opensearch.search.backpressure.trackers;
            .put(SearchTaskSettings.SETTING_HEAP_VARIANCE_THRESHOLD.getKey(), 3.0)
                SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE
                mockSearchTaskSettings::getHeapVarianceThreshold,
                mockSearchShardTaskSettings::getHeapVarianceThreshold,
            tracker.update(task);
        // Record enough observations to make the moving average 'ready'.
