    public void testStatsEqualsAndHashCode() {
import org.opensearch.action.search.SearchTask;
import org.opensearch.tasks.TaskCancellation;  
        assertTrue(NativeMemoryUsageTracker.hasSnapshotProvider());  
        // Passing null must not erase a working installation.
        assertEquals(100L, tracker.bytesForTask(task));
        // Fraction > 1.0 must be clamped to 1.0 — only tasks at or above the full budget cancel.  
import org.opensearch.tasks.Task;
        snapshot.put(2L, 200L);  
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, 350L)); // 3x threshold
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
        NativeMemoryUsageTracker.setSnapshotSupplier(Collections::emptyMap);
        // No backend installed budget: tracker MUST NOT cancel even with a fraction set.  
                NativeMemoryUsageTracker.Stats deserialized = new NativeMemoryUsageTracker.Stats(in);
        long taskId = 7L;
        long budget = 1_000L;  
        Task task = createMockTask(SearchTask.class, randomNonNegativeLong());
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(1L, 999L));
    public void testNullBudgetSupplierIgnored() {
        Task task = createMockTask(SearchTask.class, taskId);
        double fraction = 0.5;
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> 1_000L);  
        assertEquals(99L, NativeMemoryUsageTracker.getNativeMemoryBudgetBytes());
     * lookups must hit a specific entry.
    public void testBytesForTaskAfterServiceRefresh() {  
    }  
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> 99L);
import org.opensearch.search.backpressure.NativeMemoryUsageService;  
        assertTrue(
        assertNotEquals(a, "not a stats object");
     * Build a {@link CancellableTask} mock whose {@code getId()} returns the given id. The
 * Unit tests for {@link NativeMemoryUsageTracker}.
        // No checkAndMaybeGetCancellationReason invocations — cancellation count stays at zero.  
}
        assertFalse(NativeMemoryUsageTracker.isNativeTrackingSupported());  
        // Once installed, hasSnapshotProvider must return true even when the supplier itself  
        assertNotNull(tracker);  
        assertNotEquals(a, null);  
        assertEquals(0L, tracker.bytesForTask(null));
            createMockTask(SearchTask.class, 3L)  
        assertEquals(a, b);
        NativeMemoryUsageService.getInstance().refresh();  
import org.opensearch.common.io.stream.BytesStreamOutput;  
    public void resetServiceBefore() {  
        Task task = createMockTask(SearchTask.class, taskId);
    }  
    public void testStatsMaxAndAvgOverActiveTasks() {  
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, 400L));
        assertEquals(0L, NativeMemoryUsageTracker.getNativeMemoryBudgetBytes());
/*  
 * <p>The tracker is a thin wrapper over {@link NativeMemoryUsageService}, which is a  
        assertEquals(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER.getName(), tracker.name());
    }
 */
        NativeMemoryUsageService.getInstance().refresh();  
    public void testEvaluateNonCancellableTaskSkipped() {
        NativeMemoryUsageTracker.Stats a = new NativeMemoryUsageTracker.Stats(1L, 2L, 3L);  
        long taskId = 9L;
        // Package-private constructor lets a test isolate the service from the singleton.  
        long taskId = 1L;
import org.opensearch.test.OpenSearchTestCase;
    public void testHasSnapshotProviderReflectsInstallation() {
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, usage));
import org.opensearch.core.common.io.stream.StreamInput;
        );
import java.util.function.Supplier;
        NativeMemoryUsageService.getInstance().resetForTesting();
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
        NativeMemoryUsageTracker.Stats c = new NativeMemoryUsageTracker.Stats(1L, 2L, 4L);
import org.junit.Before;  
        // 999 < 1000 (clamped threshold) — must NOT cancel.  
        assertTrue(NativeMemoryUsageTracker.hasSnapshotProvider());  
        Task task = createMockTask(SearchTask.class, taskId);
            createMockTask(SearchTask.class, 2L),
        NativeMemoryUsageService.getInstance().refresh();
            reason.get().getMessage().toLowerCase(java.util.Locale.ROOT).contains("native memory")  
import java.util.Map;
        NativeMemoryUsageService isolated = NativeMemoryUsageService.getInstance();
            original.writeTo(out);
    }  
 * {@link #setUp()}/{@link #tearDown()} so leftover suppliers from a prior test (or from  
    }  
        // Refresh is now owned by the service; the tracker reads what the service publishes.
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> -1L);
    }  
        NativeMemoryUsageService.getInstance().refresh();  
    }
                assertEquals(original.hashCode(), deserialized.hashCode());  
        Map<Long, Long> snapshot = new HashMap<>();  
public class NativeMemoryUsageTrackerTests extends OpenSearchTestCase {  
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
import java.util.Optional;  
 * this file be licensed under the Apache-2.0 license or a
    }
        }  
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
        List<? extends Task> tasks = List.of(  
        NativeMemoryUsageTracker.Stats stats = (NativeMemoryUsageTracker.Stats) tracker.stats(tasks);
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
        assertEquals(new NativeMemoryUsageTracker.Stats(0L, 0L, 0L), stats);
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 5.0);
     */  
    }  
 * compatible open source license.
        NativeMemoryUsageTracker.setSnapshotSupplier(good);
    }  
        Map<Long, Long> snapshot = new HashMap<>();
        assertTrue(NativeMemoryUsageTracker.hasSnapshotProvider());  
        NativeMemoryUsageService.getInstance().refresh();  
        Task task = createMockTask(SearchTask.class, 1L);  
        assertEquals(0L, tracker.bytesForTask(task));  
        Task task = new Task(1L, "type", "action", "description", TaskId.EMPTY_TASK_ID, Collections.emptyMap());  
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> budget);  
     * {@link org.opensearch.search.backpressure.SearchBackpressureTestHelpers#createMockTaskWithResourceStats}  
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, 1_000L));  
        snapshot.put(taskId, bytes);
    public void testEvaluateInertWhenFractionZero() {
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, 999L));
        assertEquals(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER.getName(), tracker.name());
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> budget);  
        // Without a snapshot provider the predicate must be false even on Linux.
        NativeMemoryUsageService.getInstance().resetForTesting();  
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(null);  
    public void testNullSnapshotSupplierIgnored() {  
    }  
    public void testEvaluateFractionClampedToOne() {
        snapshot.put(3L, 300L);
        assertNotEquals(a, c);
    public void testStatsWireSerializationRoundTrip() throws Exception {
        long budget = 1_000L;
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        T task = org.mockito.Mockito.mock(type);
     * helper randomizes the id, which doesn't fit a snapshot-keyed test where evaluator
        assertEquals(a.hashCode(), b.hashCode());
        NativeMemoryUsageService.getInstance().refresh();
        if (org.apache.lucene.util.Constants.LINUX == false) {
        Task task = createMockTask(SearchTask.class, taskId);  
    }  
        long bytes = 8L * 1024 * 1024;
            assertFalse(NativeMemoryUsageTracker.isNativeTrackingSupported());
    }
            try (StreamInput in = out.bytes().streamInput()) {  
    public void testUpdateIsNoOp() {  
    }
    public void testNameMatchesEnum() {  
        long taskId = 12345L;
        assertFalse(reason.isPresent());
        // 1000 >= 1000 — must cancel.
    }
        assertTrue("usage above threshold must yield a cancellation reason", reason.isPresent());
        NativeMemoryUsageService.getInstance().refresh();
        Supplier<Map<Long, Long>> good = Collections::emptyMap;
    public void testGetNativeMemoryBudgetBytesClampsNegative() {  
        long budget = 1_000L;  
        NativeMemoryUsageService.getInstance().refresh();  
        long thresholdBytes = (long) (budget * fraction);
    }
        assertEquals(3, reason.get().getCancellationScore());
    /**
import java.util.List;
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);
        Task task = createMockTask(SearchShardTask.class, taskId);  
        // (resetForTesting() in @Before clears any previously installed supplier.)
    public void testEvaluateScoreScalesWithUsage() {
    }
    @After
        return task;  
        NativeMemoryUsageTracker.Stats stats = (NativeMemoryUsageTracker.Stats) tracker.stats(List.of());
        NativeMemoryUsageTracker.Stats expected = new NativeMemoryUsageTracker.Stats(0L, 300L, 200L);
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> fraction);
import org.opensearch.tasks.CancellableTask;
        assertFalse(NativeMemoryUsageTracker.hasSnapshotProvider());
import org.junit.After;
        NativeMemoryUsageTracker.setSnapshotSupplier(null);
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
        // Plain Task (not a CancellableTask) must be ignored by the evaluator.
        }
        long taskId = 1L;
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
    private <T extends CancellableTask> T createMockTask(Class<T> type, long id) {
        long budget = 1_000L;
 * SPDX-License-Identifier: Apache-2.0
        Task task = createMockTask(SearchTask.class, taskId);  
            createMockTask(SearchTask.class, 1L),
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5, isolated);
    }  
    }
        // Negative direction always holds: non-Linux MUST report unsupported regardless of state.  
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> budget);
        // 400 < 500 (budget * fraction)  
    public void resetServiceAfter() {
    }
/**  
package org.opensearch.search.backpressure.trackers;
import java.util.Collections;
    }
                assertEquals(original, deserialized);
    public void testEvaluateAtAndAboveThresholdReturnsReason() {
        // No supplier installed — the service's default empty snapshot must yield 0 for any task id.  
    public void testGetNativeMemoryBudgetBytesPropagatesValue() {
        NativeMemoryUsageTracker.Stats original = new NativeMemoryUsageTracker.Stats(7L, 1024L, 512L);  
        NativeMemoryUsageService.getInstance().refresh();  
        );
        // returns an empty map. Contract is "is something wired up?", not "does it have data?".
        org.mockito.Mockito.when(task.getTotalResourceStats())
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> snapshot);
        NativeMemoryUsageTracker.Stats b = new NativeMemoryUsageTracker.Stats(1L, 2L, 3L);
 * The OpenSearch Contributors require contributions made to  
        assertTrue(tracker.checkAndMaybeGetCancellationReason(task).isPresent());  
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> snapshot);
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> fraction);
    }
        NativeMemoryUsageService.getInstance().refresh();  
        assertTrue("score must be at least 1", reason.get().getCancellationScore() >= 1);  
            .thenReturn(new org.opensearch.core.tasks.resourcetracker.TaskResourceUsage(0L, 0L));
 * that backend plugins install at boot. Each test must reset the singleton in
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> 1_000L);  
        tracker.update(task);
        assertFalse(reason.isPresent());
        snapshot.put(1L, 100L);
        long taskId = 1L;
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> fraction);
 *
        assertFalse(tracker.checkAndMaybeGetCancellationReason(task).isPresent());
        assertFalse(tracker.checkAndMaybeGetCancellationReason(task).isPresent());
        // Operator hasn't opted in (fraction=0): tracker MUST NOT cancel even with budget + heavy task.
        // Before any backend installs a supplier, the predicate is false.  
    public void testIsNativeTrackingSupportedNonLinuxAlwaysFalse() {
    public void testBytesForTaskWithEmptySnapshot() {
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);  
        // update() is documented as a no-op; calling it must not throw or change snapshot state.
import org.opensearch.core.tasks.TaskId;
    public void testTrackerAcceptsInjectedService() {
    @Before
        double fraction = 0.1; // threshold = 100
    }  
import java.util.HashMap;  
        assertTrue(reason.isPresent());
            "reason message should mention native memory",
 * process-wide singleton. The service holds the snapshot supplier and budget supplier
    }  
            }
import org.opensearch.action.search.SearchShardTask;
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, 999L));
        assertEquals(a, a);  
    public void testEvaluateInertWhenBudgetZero() {
    public void testEvaluateBelowThresholdNoCancellation() {
        assertEquals(expected, stats);
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(1L, 100L));
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> budget);
        long taskId = 7L;
    public void testBytesForTaskNullTaskReturnsZero() {  
        // Score is floor(usage / threshold) per the tracker's evaluator.
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.0);
        long usage = thresholdBytes + 1L;  
        double fraction = 0.5;  
    public void testIsNativeTrackingSupportedRequiresProvider() {  
        Optional<TaskCancellation.Reason> reason = tracker.checkAndMaybeGetCancellationReason(task);  
 */  
 *
 * production code paths exercised by another suite) don't leak.
        Task task = createMockTask(SearchTask.class, taskId);  
        NativeMemoryUsageTracker.setSnapshotSupplier(() -> Map.of(taskId, 999L));
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> 1024L * 1024L * 1024L);  
    }
        NativeMemoryUsageService.getInstance().refresh();
        assertFalse(reason.isPresent());
    }
        NativeMemoryUsageTracker tracker = new NativeMemoryUsageTracker(() -> 0.5);
    }
        assertEquals(1024L * 1024L * 1024L, NativeMemoryUsageTracker.getNativeMemoryBudgetBytes());
        org.mockito.Mockito.when(task.getId()).thenReturn(id);  
    public void testStatsEmptyTaskList() {
        assertEquals(bytes, tracker.bytesForTask(task));  
