        List<Segment> segments = createSegments(3);
        assertTrue(handler.hasPendingMerges());
        onForceMergeThread(() -> scheduler.forceMerge(1));
 */
            SHARD_ID,
    public void testOneMergeSegmentsListIsUnmodifiable() {
        WriterFileSet fs2 = new WriterFileSet(dir.toString(), 2L, Set.of(), 20, 0L);
        handler.findAndRegisterMerges();
    }
        ThreadPool tp = mock(ThreadPool.class);
            mockThreadPool()
import java.util.List;
            handler,
                triggerError.set(e);
    public void testTriggerMergesExecutesMergeThread() throws Exception {
        MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));
    }
            }
        MergeHandler handler = createNoopHandler(snapshotSupplierOf(List.of(seg1, seg2)));
        CountDownLatch latch = new CountDownLatch(1);
            return mergeResult;
            createNoopHandler(emptySnapshotSupplier()),
        public List<List<Segment>> findForceMergeCandidates(List<Segment> segments, int maxSegmentCount) {
    public void testRunMergeInvokesApplyOnSuccess() throws Exception {
            try {
        if (failure.get() != null) {
        Merger failingMerger = mergeInput -> { throw new IOException("merge failure"); };
        WriterFileSet mergedWfs = new WriterFileSet(createTempDir().toString(), 99L, Set.of("merged.dat"), 3, 0L);
        }
                scheduler.forceMerge(1);
        AtomicBoolean cleanupCalled = new AtomicBoolean(false);
            } catch (Exception e) {
        AtomicBoolean secondFinished = new AtomicBoolean(false);
    private static List<Segment> createSegments(int count) {
        Path dir = createTempDir();
        assertNotNull("Expected IOException from forceMerge", caught.get());
        );
        MockDataFormat format = new MockDataFormat();
    }
            (mr, om) -> captured.set(mr),
        });
import java.util.ArrayList;
        Segment seg1 = Segment.builder(1L).build();
        assertEquals(Double.POSITIVE_INFINITY, createMergeScheduler().getIORateLimitMBPerSec(), 0.0);
        );
        scheduler.triggerMerges();
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
        }
        handler.registerMerge(new OneMerge(List.of(unknownSeg)));
        return new IndexSettings(newIndexMeta("test", settings), Settings.EMPTY);
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        Merger slowMerger = mergeInput -> {
    // ---- MergeScheduler tests ----
import org.opensearch.common.concurrent.GatedCloseable;
     * Runs the given action on a thread whose name contains
        BiConsumer<MergeResult, OneMerge> applyCallback = (mr, om) -> capturedResult.set(mr);
            t.setName(name + "-" + t.threadId());
        Segment unknownSeg = Segment.builder(99L).build();
        WriterFileSet mergedWfs = new WriterFileSet(dir.toString(), 99L, Set.of("merged.dat"), 10, 0L);
    // ---- MergeHandler tests ----
        // Second caller should be blocked (not finished) while first is in progress
            (mergeResult, oneMerge) -> {},
    }
import java.util.concurrent.ExecutorService;
        assertTrue(handler.hasPendingMerges());
    public void testRegisterMergeThrowsOnAcquireSnapshotFailure() {
            captured.set(mr);
        Thread triggerThread = new Thread(() -> {
    }
    }
        handler.registerMerge(merge2);
        AtomicReference<MergeResult> captured = new AtomicReference<>();
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), failingMerger);
    }
        }, () -> {}, SHARD_ID, mergeSchedulerSettings(), mockThreadPool());
        assertNotNull(captured.get());
        OneMerge merge = new OneMerge(Collections.emptyList());
    }
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), merger);
        Segment seg1 = Segment.builder(1L).build();
        return pool;
        );
    @SuppressForbidden(reason = "test needs to set private isShutdown field via reflection")
        handler.onMergeFailure(merge);
        t2.start();
        when(tp.executor(eq(ThreadPool.Names.MERGE))).thenReturn(daemonPool(ThreadPool.Names.MERGE));
        MergeHandler handler = createNoopHandler(snapshotSupplierOf(List.of(catalogSeg)));
            return mergeResult;
    private MergeScheduler createMergeScheduler() {
import java.util.function.Supplier;
            } catch (IOException e) {
import static org.mockito.Mockito.when;
        Segment seg1 = Segment.builder(1L).addSearchableFiles(format, fs1).build();
            mergeSchedulerSettings(),
        List<Segment> segments = createSegments(3);
    private static void setShutdownFlag(MergeScheduler scheduler, boolean value) {
 *
        assertEquals(2, merge.getSegmentsToMerge().size());
    public void testTriggerMergesAfterShutdown() throws Exception {
    public void testRegisterMergeWithEmptySegmentsList() {
            () -> {},
    /**
        when(snap.getSegments()).thenReturn(segments);
    }
            mergeSchedulerSettings(),
            } catch (InterruptedException e) {
            mockThreadPool()
        assertEquals(20.0, scheduler.getIORateLimitMBPerSec(), 0.0);
    }
        // Use forceMerge which catches exceptions from runMerge properly
        MergeHandler handler = new MergeHandler(
        allowMergeToFinish.countDown();
            handler,
    public void testMergeHandlerLifecycleCallbacks() {
        );
                scheduler.forceMerge(1);
                scheduler.forceMerge(1);
        MergeScheduler scheduler = createMergeScheduler();
                allowMergeToFinish.await(10, TimeUnit.SECONDS);
        MergeHandler handler = createNoopHandler(snapshotSupplierOf(List.of(seg1, seg2)));
        Thread forceMergeThread = new Thread(() -> {
            }
        executors.clear();
    public void testForceMergeExecutesMerges() throws Exception {
            latch.countDown();
            .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "6")
            snapshotSupplierOf(List.of(seg)),
    // ---- OneMerge tests ----
import org.opensearch.core.index.shard.ShardId;
        handler.onMergeFinished(merge, false);
        assertTrue(handler.hasPendingMerges());
            return t;
    }
        OneMerge merge = new OneMerge(Collections.emptyList());
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(
    }
        scheduler.triggerMerges();
        }
        scheduler.triggerMerges();
        MergeScheduler scheduler = new MergeScheduler(
        @Override
package org.opensearch.index.engine.dataformat.merge;
import java.util.function.BiConsumer;
import org.opensearch.threadpool.ThreadPool;
        );
            SHARD_ID
        Segment seg2 = Segment.builder(2L).addSearchableFiles(format, fs2).build();
        assertEquals(0L, merge.getTotalNumDocs());
    public void testRegisterMergeRejectsSegmentNotInCatalog() {
        try {
import java.lang.reflect.Field;
    }
            NOOP_MERGE_POLICY,
        public void removeMergingSegment(Collection<Segment> mergingSegments) {}
        assertNull("forceMerge should complete without error", forceMergeError.get());
            .build();
import java.util.Collection;
        MockDataFormat format = new MockDataFormat();
        Segment seg = Segment.builder(1L).build();
        MergeScheduler scheduler = new MergeScheduler(
        MergeHandler handler = createNoopHandler(failingSupplier);
    public void tearDown() throws Exception {
        MergeScheduler scheduler = new MergeScheduler(
        );
        onForceMergeThread(() -> {
        OneMerge merge2 = new OneMerge(List.of(seg2));
        }, ThreadPool.Names.FORCE_MERGE + "-test");
        Supplier<GatedCloseable<CatalogSnapshot>> failingSupplier = () -> { throw new RuntimeException("snapshot unavailable"); };
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), merger);
        );
            new IndexSettings(newIndexMeta("test", Settings.EMPTY), Settings.EMPTY).getMergePolicy(true),
        AtomicReference<Exception> failure = new AtomicReference<>();
        Thread t2 = new Thread(() -> {
            SHARD_ID,
     */
        MockDataFormat format = new MockDataFormat();
        MergeScheduler scheduler = new MergeScheduler(
/**
        assertFalse(handler.hasPendingMerges());
    public void testForceMergeSerializesOnlyConcurrentCallers() throws Exception {
        return new MergeHandler(snapshotSupplier, merger, SHARD_ID, policy, policy, () -> 1L);
    public void testForceMergePropagatesFailure() throws Exception {
    }
        assertNull(handler.getNextMerge());
        assertNull("triggerMerges should complete without error", triggerError.get());
    }
        handler.onMergeFinished(merge, false);
        executors.add(pool);
    }
        MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));
            () -> {},
        AtomicReference<Exception> triggerError = new AtomicReference<>();
        MergeScheduler scheduler = createMergeScheduler();
                secondFinished.set(true);
            try {
            Thread t = new Thread(r);
        assertFalse(handler.hasPendingMerges());
                secondStarted.set(true);
        scheduler.refreshConfig();
        return new MergeScheduler(
        MergeScheduler scheduler = new MergeScheduler(createNoopHandler(emptySnapshotSupplier()), (mr, om) -> {
import static org.mockito.ArgumentMatchers.eq;
        MergeHandler handler = createNoopHandler(emptySnapshotSupplier());
        CountDownLatch mergeStarted = new CountDownLatch(1);
        assertFalse(handler.hasPendingMerges());
            () -> {},
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), merger);
        assertTrue(merge.getSegmentsToMerge().isEmpty());
        List<Segment> segments = createSegments(15);
    }
        };
            } catch (Exception e) {
        public void addMergingSegment(Collection<Segment> mergingSegments) {}
        t.join(30_000);
import java.util.concurrent.TimeUnit;
        } catch (Exception e) {
        AtomicReference<MergeResult> captured = new AtomicReference<>();
import java.util.concurrent.Executors;
                // expected
        assertSame(merge1, handler.getNextMerge());
        onForceMergeThread(() -> {
                failure.set(e);
    }
        });
        CountDownLatch latch = new CountDownLatch(1);
        assertSame(mergeResult, capturedResult.get());
        Merger merger = mergeInput -> mergeResult;
        assertEquals(30L, merge.getTotalNumDocs());
    }
import org.opensearch.test.OpenSearchTestCase;
    }
            return mergeResult;
        List<Segment> segments = createSegments(3);
import java.util.concurrent.atomic.AtomicBoolean;
            (mr, om) -> {},
        handler.registerMerge(merge);
        MockDataFormat format = new MockDataFormat();
                Thread.currentThread().interrupt();
    public void testGetNextMergeReturnsInOrder() {
 */
            mockThreadPool()
        for (int i = 1; i <= count; i++) {
    public void testDoMergeReturnsResult() throws IOException {
        Thread t1 = new Thread(() -> {
    private static Supplier<GatedCloseable<CatalogSnapshot>> emptySnapshotSupplier() {
import java.util.concurrent.CountDownLatch;
import org.opensearch.common.settings.Settings;
            merger,
        forceMergeThread.start();
        MergeHandler handler = createNoopHandler(snapshotSupplierOf(List.of(seg)));
    }
            (mr, om) -> {},
        }, ThreadPool.Names.FORCE_MERGE + "-t1");
        Settings autoThrottleSettings = Settings.builder()
            (mr, om) -> {},
        OneMerge merge = new OneMerge(List.of(seg1, seg2));
        OneMerge merge1 = new OneMerge(List.of(seg1));
    public void testRunMergeInvokesCleanupOnFailure() throws Exception {
    private ThreadPool mockThreadPool() {
    };
        Merger failingMerger = mergeInput -> { throw new IOException("simulated merge failure"); };
    }
        OneMerge merge = new OneMerge(List.of(seg));
    }
            .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1")
        return new MergeHandler(snapshotSupplier, noopMerger, SHARD_ID, NOOP_MERGE_POLICY, NOOP_MERGE_LISTENER, () -> 1L);
        List<Segment> segments = createSegments(15);
import org.opensearch.index.engine.exec.WriterFileSet;
            SHARD_ID,
/*
        });
            mergeSchedulerSettings(),
            t.setDaemon(true);
        long start = System.nanoTime();
        for (ExecutorService pool : executors) {
        OneMerge merge = new OneMerge(Collections.emptyList());
        triggerThread.join(10000);
        handler.registerMerge(merge);
        MergeScheduler scheduler = new MergeScheduler(
        MergeScheduler scheduler = createMergeScheduler();
            (mr, om) -> {},
        MergeResult expectedResult = new MergeResult(Map.of(format, mergedWfs));
        return snapshotSupplierOf(Collections.emptyList());
            } catch (Exception e) {
            mockThreadPool()
        Segment unknownSeg = Segment.builder(99L).build();
        MockDataFormat format = new MockDataFormat();
            segments.add(Segment.builder(i).build());
            latch.countDown();
            mockThreadPool()
        assertSame(expectedResult, result);
    }
            .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1")
        scheduler.enableAutoIOThrottle();
    public void testTriggerMergesWithNoPendingMerges() {
        MergeHandler handler = createNoopHandler(snapshotSupplierOf(List.of(seg)));
            }
        onForceMergeThread(() -> scheduler.forceMerge(1));
        CountDownLatch latch = new CountDownLatch(1);
        assertTrue(secondFinished.get());
            () -> 1L
        };
        onForceMergeThread(() -> scheduler.forceMerge(1));
    public void testTriggerMergesHandlesMergeFailure() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
    public void testMergeHandlerInitiallyEmpty() {
        Merger merger = mergeInput -> mergeResult;
        List<Segment> segments = createSegments(15);
 * Tests for the merge flow: {@link OneMerge}, {@link MergeHandler}, and {@link MergeScheduler}.
import org.opensearch.index.engine.dataformat.Merger;
        MergeScheduler scheduler = createMergeScheduler();
        public List<List<Segment>> findMergeCandidates(List<Segment> segments) {
        AtomicReference<Exception> forceMergeError = new AtomicReference<>();
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    public void testForceMergeWithNoSegmentsIsNoop() throws Exception {
    }
            .build();
            mockThreadPool()
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), failingMerger);
        expectThrows(UnsupportedOperationException.class, () -> merge.getSegmentsToMerge().add(seg));
            (mr, om) -> {},
        return () -> new GatedCloseable<>(snap, () -> {});
        assertEquals(0L, merge.getTotalSizeInBytes());
        }
        scheduler.refreshConfig();
    }
import java.util.concurrent.CopyOnWriteArrayList;
        MergeScheduler scheduler = new MergeScheduler(
        MergeScheduler scheduler = new MergeScheduler(
        assertTrue(handler.hasPendingMerges());
        assertTrue("onMergeFailureCleanup should be called", cleanupCalled.get());
            mergeSchedulerSettings(),
        long elapsed = TimeValue.nsecToMSec(System.nanoTime() - start);
            pool.shutdownNow();
        }, ThreadPool.Names.FORCE_MERGE + "-t2");
import org.opensearch.index.engine.exec.Segment;
                scheduler.triggerMerges();
            idxSettings,
        };
        CatalogSnapshot snap = mock(CatalogSnapshot.class);
        forceMergeThread.join(10000);
        Merger noopMerger = mergeInput -> new MergeResult(Map.of());
    @Override
            handler,
        Segment seg2 = Segment.builder(2L).build();
    private MergeHandler createNoopHandler(Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplier) {
        Thread.sleep(200);
        onForceMergeThread(() -> scheduler.forceMerge(1));
        return segments;
            try {
        Merger merger = mergeInput -> expectedResult;
                throw new RuntimeException(e);
            handler,
        onForceMergeThread(() -> scheduler.forceMerge(1));
        handler.registerMerge(new OneMerge(Collections.emptyList()));
        void run() throws Exception;
            return List.of();
        AtomicBoolean secondStarted = new AtomicBoolean(false);
        }, ThreadPool.Names.FORCE_MERGE + "-test");
            return List.of();
        WriterFileSet mergedWfs = new WriterFileSet(createTempDir().toString(), 99L, Set.of("merged.dat"), 3, 0L);
        scheduler.enableAutoIOThrottle();
    };
        t.setDaemon(true);
            } catch (IOException e) {
    public void testRegisterMergeRejectsWhenSecondSegmentNotInCatalog() {
    private ExecutorService daemonPool(String name) {
    private static final MergeHandler.MergePolicy NOOP_MERGE_POLICY = new MergeHandler.MergePolicy() {
            throw new IOException("merge boom");
        assertNull(handler.getNextMerge());
import java.util.Map;
        Merger merger = mergeInput -> mergeResult;
        List<Segment> segments = createSegments(3);
        Thread.sleep(200);
                Thread.sleep(200);
        MergeResult result = handler.doMerge(new OneMerge(List.of(seg)));
            }
            f.setAccessible(true);
    }
 * compatible open source license.
            }
        List<Segment> segments = createSegments(3);
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), merger);
        );
            mergeSchedulerSettings(),
        assertTrue(mergeStarted.await(5, TimeUnit.SECONDS));
    // ---- MergeScheduler: forceMerge serialization and lifecycle tests ----
            applyCallback,
        MergeHandler handler = createNoopHandler(snapshotSupplierOf(List.of(catalogSeg)));
        WriterFileSet mergedWfs = new WriterFileSet(createTempDir().toString(), 99L, Set.of("merged.dat"), 3, 0L);
    }
        MergeScheduler scheduler = new MergeScheduler(
    public void testForceMergeBlocksUntilComplete() throws Exception {
            SHARD_ID,
        WriterFileSet mergedWfs = new WriterFileSet(createTempDir().toString(), 99L, Set.of("merged.dat"), 3, 0L);
            latch.countDown();
            handler,
        IndexSettings idxSettings = new IndexSettings(newIndexMeta("test", settings), Settings.EMPTY);
            Field f = MergeScheduler.class.getDeclaredField("isShutdown");
        MergeHandler handler = createNoopHandler(() -> new GatedCloseable<>(null, () -> {}));
    // ---- MergeHandler doMerge tests ----
    }
import org.opensearch.common.unit.TimeValue;
            }
        Merger slowMerger = mergeInput -> {
        Thread.sleep(200);
        OneMerge merge = new OneMerge(List.of(seg1, seg2));
        @Override
            }
    public void testConcurrentForceMergeAndBackgroundMerge() throws Exception {
        triggerThread.start();
        AtomicReference<MergeResult> capturedResult = new AtomicReference<>();
    private static final ShardId SHARD_ID = new ShardId("test", "_na_", 0);
        List<Segment> segments = createSegments(3);
        );
public class MergeTests extends OpenSearchTestCase {
        MergeScheduler scheduler = createMergeScheduler();
        when(tp.executor(eq(ThreadPool.Names.FORCE_MERGE))).thenReturn(daemonPool(ThreadPool.Names.FORCE_MERGE));
        Segment seg = Segment.builder(1L).addSearchableFiles(format, inputWfs).build();
        MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));
    }
        t2.join(5000);
        };
            mockThreadPool()
            mergeSchedulerSettings(),
    private MergeHandler createHandlerWithRealPolicy(Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplier, Merger merger) {
                scheduler.forceMerge(1);
            ((AtomicBoolean) f.get(scheduler)).set(value);
    @SuppressForbidden(reason = "helper to set private isShutdown field via reflection for testing")
        MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));
                Thread.currentThread().interrupt();
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), slowMerger);
            SHARD_ID,
import org.opensearch.common.SuppressForbidden;
            try {
            SHARD_ID,
            createNoopHandler(emptySnapshotSupplier()),
    public void testOnMergeFailureRemovesSegments() {
        assertTrue(caught.get().getMessage().contains("simulated merge failure"));
 * The OpenSearch Contributors require contributions made to
        return tp;
        }
        assertFalse(handler.hasPendingMerges());
            () -> {},
        assertNotNull(captured.get());
                throw new RuntimeException(e);
        Settings settings = Settings.builder()
        handler.registerMerge(merge1);
        assertFalse(handler.hasPendingMerges());
    public void testOnMergeFinishedRemovesSegments() {
    }
        t.start();
        OneMerge merge = new OneMerge(List.of(seg));
        );
            .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1")
    }
        Segment seg = Segment.builder(1L).build();
    public void testSchedulerStatsReturnsNonNull() {
import java.io.IOException;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        CountDownLatch allowMergeToFinish = new CountDownLatch(1);
    public void testSchedulerRefreshConfigIdempotent() {
        assertTrue("forceMerge should block until complete, took " + elapsed + "ms", elapsed >= 150);
        MockDataFormat format = new MockDataFormat();
    }
        Segment seg2 = Segment.builder(2L).build();
            throw new RuntimeException(e);
                forceMergeError.set(e);
            .build();
                action.run();
        scheduler.triggerMerges();
            handler,
            NOOP_MERGE_LISTENER,
        expectThrows(RuntimeException.class, () -> handler.registerMerge(new OneMerge(Collections.emptyList())));
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), failingMerger);
            try {
        @Override
            .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "6")
    public void testOneMergeAggregatesDocCounts() {
        WriterFileSet mergedWfs = new WriterFileSet(createTempDir().toString(), 99L, Set.of("merged.dat"), 15, 0L);
            idxSettings,
    }
        handler.onMergeFailure(merge);
            (mr, om) -> {},
            throw failure.get();
        Merger failingMerger = mergeInput -> {
                caught.set(e);
    @FunctionalInterface
    // ---- MergeScheduler: integration with real merge execution ----
     * {@link ThreadPool.Names#FORCE_MERGE} to satisfy the forceMerge assertion.
    public void testRegisterMergeWithValidSegments() {
}
        MergeHandler handler = createNoopHandler(emptySnapshotSupplier());
        assertTrue(merge.toString().contains("Merge"));
    public void testSchedulerEnableAutoIOThrottle() {
            mergeSchedulerSettings(),
            SHARD_ID,
        ExecutorService pool = Executors.newCachedThreadPool(r -> {
    private interface ThrowingRunnable {
        assertSame(merge, handler.getNextMerge());
    private static final MergeHandler.MergeListener NOOP_MERGE_LISTENER = new MergeHandler.MergeListener() {
            () -> {},
        );
                mergeStarted.await(5, TimeUnit.SECONDS);
        handler.registerMerge(new OneMerge(List.of(catalogSeg, unknownSeg)));
        Segment catalogSeg = Segment.builder(1L).build();
    }
            try {
        MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));
        List<Segment> segments = new ArrayList<>();
        Thread t = new Thread(() -> {
            } catch (IOException expected) {
            try {
        t1.start();
        AtomicReference<Exception> caught = new AtomicReference<>();
            pool.awaitTermination(5, TimeUnit.SECONDS);
            SHARD_ID,
            SHARD_ID,
            () -> {},
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;
import java.util.concurrent.atomic.AtomicReference;
    }
    private static IndexSettings mergeSchedulerSettings() {
        @Override
            mockThreadPool()
        MockDataFormat format = new MockDataFormat();
            .put(MergeSchedulerConfig.AUTO_THROTTLE_SETTING.getKey(), "true")
            }
        MockDataFormat format = new MockDataFormat();
            } catch (InterruptedException e) {
    }
            try {
import java.nio.file.Path;
import java.util.Collections;
        MergeScheduler scheduler = new MergeScheduler(
        super.tearDown();
        assertFalse(secondFinished.get());
        assertSame(merge2, handler.getNextMerge());
        handler.registerMerge(merge);
    private void onForceMergeThread(ThrowingRunnable action) throws Exception {
            mergeSchedulerSettings(),
    public void testSchedulerTriggerAndForceMerge() throws Exception {
    public void testStatsWithAutoThrottleEnabled() {
        MergeScheduler scheduler = new MergeScheduler(handler, (mr, om) -> {
 * SPDX-License-Identifier: Apache-2.0
            handler,
    }
    }
            SHARD_ID,
        }, () -> { fail("onMergeFailureCleanup should not be called"); }, SHARD_ID, mergeSchedulerSettings(), mockThreadPool());
            fail("applyMergeChanges should not be called");
        assertTrue(handler.hasPendingMerges());
        setShutdownFlag(scheduler, true);
            SHARD_ID,
            () -> {},
import org.opensearch.index.IndexSettings;
        assertFalse(handler.hasPendingMerges());
import static org.mockito.Mockito.mock;
        Path dir = createTempDir();
        Segment catalogSeg = Segment.builder(1L).build();
            try {
import java.util.Set;
    }
                scheduler.forceMerge(1);
    }
            () -> {},
            } catch (Exception e) {
            mockThreadPool()
        assertEquals(0, scheduler.stats().getCurrent());
import org.opensearch.index.engine.dataformat.MergeResult;
        assertFalse(handler.hasPendingMerges());
    }
            }
        assertTrue(secondStarted.get());
        scheduler.triggerMerges();
        IndexSettings idxSettings = new IndexSettings(newIndexMeta("test", autoThrottleSettings), Settings.EMPTY);
            () -> {},
        OneMerge merge = new OneMerge(List.of(seg));
    }
            (mr, om) -> {},
    }
        WriterFileSet inputWfs = new WriterFileSet(dir.toString(), 1L, Set.of("input.dat"), 10, 0L);
        MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));
            handler,
        WriterFileSet fs1 = new WriterFileSet(dir.toString(), 1L, Set.of(), 10, 0L);
    private static Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplierOf(List<Segment> segments) {
    private final List<ExecutorService> executors = new CopyOnWriteArrayList<>();
            () -> cleanupCalled.set(true),
        WriterFileSet mergedWfs = new WriterFileSet(createTempDir().toString(), 99L, Set.of("merged.dat"), 15, 0L);
        Merger merger = mergeInput -> {
        });
        Settings settings = Settings.builder()
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), slowMerger);
    public void testOneMergeToString() {
        Segment seg = Segment.builder(1L).build();
import org.opensearch.index.MergeSchedulerConfig;
        t1.join(5000);
    }
    public void testSchedulerDefaultIOThrottleReturnsInfinity() {
    public void testOneMergeWithEmptySegments() {
        handler.registerMerge(merge);
            mockThreadPool()
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        assertNotNull(createMergeScheduler().stats());
        );
        assertNotNull(scheduler.stats());
            mergeStarted.countDown();
            .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "6")
        }
    }
