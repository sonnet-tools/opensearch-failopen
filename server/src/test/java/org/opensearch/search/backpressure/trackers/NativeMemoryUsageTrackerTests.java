    public void testNullSnapshotSupplierIgnored() {
        long taskId = 1L;
     * lookups must hit a specific entry.
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> fraction);
        NativeMemoryUsageService.getInstance().refresh();
    public void testHasSnapshotProviderReflectsInstallation() {
        T task = org.mockito.Mockito.mock(type);
    }
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
        assertFalse(tracker.checkAndMaybeGetCancellationReason(task).isPresent());
        assertEquals(expected, stats);
    }
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, 999L));
import org.junit.After;
import java.util.Collections;
        NativeMemoryUsageTracker.Stats expected = new NativeMemoryUsageTracker.Stats(0L, 300L, 200L);
    }
        Supplier<Map<Long, Long>> good = Collections::emptyMap;
 * <p>The tracker is a thin wrapper over {@link NativeMemoryUsageService}, which is a
            createMockTask(SearchTask.class, 3L)
    public void testBytesForTaskWithEmptySnapshot() {
import org.opensearch.tasks.Task;
        double fraction = 0.5;
public class NativeMemoryUsageTrackerTests extends OpenSearchTestCase {
        NativeMemoryUsageTracker.Stats stats = (NativeMemoryUsageTracker.Stats) tracker.stats(List.of());
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
        assertEquals(new NativeMemoryUsageTracker.Stats(0L, 0L, 0L), stats);
        assertTrue("score must be at least 1", reason.get().getCancellationScore() >= 1);
        NativeMemoryUsageService.getInstance().refresh();
    }
import java.util.List;
    public void resetServiceAfter() {
        assertEquals(0L, tracker.bytesForTask(null));
        assertEquals(a.hashCode(), b.hashCode());
    public void testStatsEmptyTaskList() {
            createMockTask(SearchTask.class, 2L),
    public void testTrackerAcceptsInjectedService() {
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
    public void testStatsEqualsAndHashCode() {
 *
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }
        assertFalse(NativeMemoryUsageTracker.hasSnapshotProvider());
    public void testNameMatchesEnum() {
        assertEquals(0L, NativeMemoryUsageTracker.getNativeMemoryBudgetBytes());
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, 999L));
 * Unit tests for {@link NativeMemoryUsageTracker}.
    }
        // 1000 >= 1000 — must cancel.
            createMockTask(SearchTask.class, 1L),
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, usage));
    public void testEvaluateAtAndAboveThresholdReturnsReason() {
        // Package-private constructor lets a test isolate the service from the singleton.
        snapshot.put(1L, 100L);
        NativeMemoryUsageService.getInstance().refresh();
        double fraction = 0.5;
        assertEquals(99L, NativeMemoryUsageTracker.getNativeMemoryBudgetBytes());
        // Fraction > 1.0 must be clamped to 1.0 — only tasks at or above the full budget cancel.
        snapshot.put(2L, 200L);
        NativeMemoryUsageService.getInstance().refresh();
    @After
     */
    private <T extends CancellableTask> T createMockTask(Class<T> type, long id) {
        // Operator hasn't opted in (fraction=0): tracker MUST NOT cancel even with budget + heavy task.
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
    public void testEvaluateScoreScalesWithUsage() {
    public void testGetNativeMemoryBudgetBytesPropagatesValue() {
    }
 * that backend plugins install at boot. Each test must reset the singleton in
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> snapshot);
    }
        Task task = createMockTask(SearchTask.class, taskId);
        org.mockito.Mockito.when(task.getId()).thenReturn(id);
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> 99L);
    }
    public void testGetNativeMemoryBudgetBytesClampsNegative() {
import java.util.Optional;
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> fraction);
        // No supplier installed — the service's default empty snapshot must yield 0 for any task id.
    public void testStatsWireSerializationRoundTrip() throws Exception {
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> 1_000L);
            original.writeTo(out);
import org.opensearch.core.common.io.stream.StreamInput;
    }
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> -1L);
        NativeMemoryUsageService.getInstance().refresh();
        assertTrue(NativeMemoryUsageTracker.hasSnapshotProvider());
        long budget = 1_000L;
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
        assertNotEquals(a, null);
    public void testStatsMaxAndAvgOverActiveTasks() {
    public void testIsNativeTrackingSupportedRequiresProvider() {
     * Build a {@link CancellableTask} mock whose {@code getId()} returns the given id. The
        // (resetForTesting() in @Before clears any previously installed supplier.)
        assertNotNull(tracker);
import org.opensearch.tasks.CancellableTask;
        Task task = new Task(1L, "type", "action", "description", TaskId.EMPTY_TASK_ID, Collections.emptyMap());
        Task task = createMockTask(SearchTask.class, randomNonNegativeLong());
        NativeMemoryUsageService isolated = NativeMemoryUsageService.getInstance();
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> 1_000L);
        assertFalse(reason.isPresent());
        long budget = 1_000L;
        }
        // Score is floor(usage / threshold) per the tracker's evaluator.
/*
            reason.get().getMessage().toLowerCase(java.util.Locale.ROOT).contains("native memory")
    }
        assertEquals(a, b);
    public void testEvaluateNonCancellableTaskSkipped() {
        // Refresh is now owned by the service; the tracker reads what the service publishes.
package org.opensearch.search.backpressure.trackers;
import org.junit.Before;
        long budget = 1_000L;
    public void testEvaluateInertWhenBudgetZero() {
        snapshot.put(3L, 300L);
        return task;
        assertTrue("usage above threshold must yield a cancellation reason", reason.isPresent());
        Map<Long, Long> snapshot = new HashMap<>();
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(1L, 100L));
        // 400 < 500 (budget * fraction)
 * production code paths exercised by another suite) don't leak.
        NativeMemoryUsageService.getInstance().refresh();
        NativeMemoryUsageService.getInstance().refresh();
 */
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
        double fraction = 0.1; // threshold = 100
        Task task = createMockTask(SearchTask.class, taskId);
            }
    }
        NativeMemoryUsageService.getInstance().refresh();
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5, isolated);
        Task task = createMockTask(SearchTask.class, taskId);
    public void testEvaluateInertWhenFractionZero() {
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, 350L)); // 3x threshold
        // Negative direction always holds: non-Linux MUST report unsupported regardless of state.
        long usage = thresholdBytes + 1L;
        NativeMemoryUsageService.getInstance().refresh();
    public void testBytesForTaskAfterServiceRefresh() {
import org.opensearch.action.search.SearchTask;
        assertNotEquals(a, "not a stats object");
        // Plain Task (not a CancellableTask) must be ignored by the evaluator.
        snapshot.put(taskId, bytes);
        long taskId = 12345L;
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> 1024L * 1024L * 1024L);
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> budget);
                assertEquals(original.hashCode(), deserialized.hashCode());
            .thenReturn(new org.opensearch.core.tasks.resourcetracker.TaskResourceUsage(0L, 0L));
        long taskId = 7L;
    }
 *
        assertFalse(tracker.checkAndMaybeGetCancellationReason(task).isPresent());
    }
        Task task = createMockTask(SearchTask.class, 1L);
    }
        assertEquals(0L, tracker.bytesForTask(task));
        Task task = createMockTask(SearchShardTask.class, taskId);
    public void testNullBudgetSupplierIgnored() {
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> budget);
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
            assertFalse(NativeMemoryUsageTracker.isNativeTrackingSupported());
        long taskId = 1L;
        List<? extends Task> tasks = List.of(
        Map<Long, Long> snapshot = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
    }
        assertTrue(NativeMemoryUsageTracker.hasSnapshotProvider());
                NativeMemoryUsageTracker.Stats deserialized = new NativeMemoryUsageTracker.Stats(in);
        assertTrue(reason.isPresent());
    }
    @Before
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
import java.util.Map;
        assertEquals(bytes, tracker.bytesForTask(task));
    }
        // Passing null must not erase a working installation.
    public void testIsNativeTrackingSupportedNonLinuxAlwaysFalse() {
 * The OpenSearch Contributors require contributions made to
        assertFalse(NativeMemoryUsageTracker.isNativeTrackingSupported());
        );
 * compatible open source license.
     * helper randomizes the id, which doesn't fit a snapshot-keyed test where evaluator
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> fraction);
        // returns an empty map. Contract is "is something wired up?", not "does it have data?".
        }
 * process-wide singleton. The service holds the snapshot supplier and budget supplier
        assertEquals(a, a);
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.0);
     * {@link org.opensearch.search.backpressure.SearchBackpressureTestHelpers#createMockTaskWithResourceStats}
        Task task = createMockTask(SearchTask.class, taskId);
        assertEquals(3, reason.get().getCancellationScore());
 * {@link #setUp()}/{@link #tearDown()} so leftover suppliers from a prior test (or from
import java.util.HashMap;
        assertEquals(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER.getName(), tracker.name());
        assertFalse(reason.isPresent());
        // Before any backend installs a supplier, the predicate is false.
    }
        Task task = createMockTask(SearchTask.class, taskId);
/**
        assertEquals(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER.getName(), tracker.name());
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
        NativeMemoryUsageTracker.Stats b = new NativeMemoryUsageTracker.Stats(1L, 2L, 3L);
        // Without a snapshot provider the predicate must be false even on Linux.
 */
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(1L, 999L));
        NativeMemoryUsageTracker.setSnapshotSupplier(good);
    public void testEvaluateBelowThresholdNoCancellation() {
        if (org.apache.lucene.util.Constants.LINUX == false) {
        long taskId = 9L;
        long taskId = 1L;
        assertFalse(reason.isPresent());
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, 400L));
                assertEquals(original, deserialized);
    }
    }
        NativeMemoryUsageService.getInstance().refresh();
import org.opensearch.action.search.SearchShardTask;
import org.opensearch.search.backpressure.NativeMemoryUsageService;
}
        NativeMemoryUsageService.getInstance().resetForTesting();
    }
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> budget);
    }
        assertTrue(
        assertNotEquals(a, c);
        long budget = 1_000L;
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
        NativeMemoryUsageTracker.Stats stats = (NativeMemoryUsageTracker.Stats) tracker.stats(tasks);
import org.opensearch.test.OpenSearchTestCase;
        NativeMemoryUsageTracker.Stats original = new NativeMemoryUsageTracker.Stats(7L, 1024L, 512L);
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(null);
    public void resetServiceBefore() {
        NativeMemoryUsageTracker.setSnapshotSupplier(null);
        NativeMemoryUsageService.getInstance().refresh();
        // update() is documented as a no-op; calling it must not throw or change snapshot state.
        NativeMemoryUsageTracker.Stats a = new NativeMemoryUsageTracker.Stats(1L, 2L, 3L);
        assertEquals(1024L * 1024L * 1024L, NativeMemoryUsageTracker.getNativeMemoryBudgetBytes());
        );
        long taskId = 7L;
        // 999 < 1000 (clamped threshold) — must NOT cancel.
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
import java.util.function.Supplier;
        // No checkAndMaybeGetCancellationReason invocations — cancellation count stays at zero.
    }
        assertEquals(100L, tracker.bytesForTask(task));
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> budget);
    }
        assertTrue(tracker.checkAndMaybeGetCancellationReason(task).isPresent());
    public void testUpdateIsNoOp() {
        org.mockito.Mockito.when(task.getTotalResourceStats())
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, 999L));
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> snapshot);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.io.stream.BytesStreamOutput;
            try (StreamInput in = out.bytes().streamInput()) {
import org.opensearch.tasks.TaskCancellation;
    }
        tracker.update(task);
        // Once installed, hasSnapshotProvider must return true even when the supplier itself
    public void testEvaluateFractionClampedToOne() {
        NativeMemoryUsageTracker.setSnapshotSupplier(Collections::emptyMap);
        assertTrue(NativeMemoryUsageTracker.hasSnapshotProvider());
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 5.0);
        Task task = createMockTask(SearchTask.class, taskId);
    /**
    public void testBytesForTaskNullTaskReturnsZero() {
    }
        long bytes = 8L * 1024 * 1024;
        NativeMemoryUsageService.getInstance().resetForTesting();
        long thresholdBytes = (long) (budget * fraction);
        // No backend installed budget: tracker MUST NOT cancel even with a fraction set.
import org.opensearch.core.tasks.TaskId;
        NativeMemoryUsageTracker.Stats c = new NativeMemoryUsageTracker.Stats(1L, 2L, 4L);
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, 1_000L));
            "reason message should mention native memory",
