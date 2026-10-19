        List<Segment> segments = createSegments(3);
        assertTrue("onMergeFailureCleanup should be called", cleanupCalled.get());
            () -> {},  
        );  
        Segment seg2 = Segment.builder(2L).build();
        Merger merger = mergeInput -> mergeResult;  
            .put(MergeSchedulerConfig.AUTO_THROTTLE_SETTING.getKey(), "true")
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), slowMerger);
    private static final ShardId SHARD_ID = new ShardId("test", "_na_", 0);
    }
    public void testForceMergeWithNoSegmentsIsNoop() throws Exception {
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
        handler.registerMerge(merge1);
        }, ThreadPool.Names.FORCE_MERGE + "-test");
        assertTrue(merge.toString().contains("Merge"));  
        @Override  
     * Runs the given action on a thread whose name contains  
    @FunctionalInterface
        CountDownLatch allowMergeToFinish = new CountDownLatch(1);  
            snapshotSupplierOf(List.of(seg)),
import java.util.function.Supplier;
    // ---- OneMerge tests ----
        t.setDaemon(true);  
            latch.countDown();
    }  
import java.util.Collections;
    }
            (mr, om) -> {},  
            mockThreadPool()
        onForceMergeThread(() -> scheduler.forceMerge(1));
        return tp;
            (mr, om) -> {},  
import org.opensearch.common.SuppressForbidden;
        assertEquals(0L, merge.getTotalNumDocs());
    public void testTriggerMergesAfterShutdown() throws Exception {  
 *
        handler.registerMerge(merge);
        MergeScheduler scheduler = new MergeScheduler(
            }
        scheduler.triggerMerges();  
        executors.add(pool);  
        assertFalse(handler.hasPendingMerges());  
        Supplier<GatedCloseable<CatalogSnapshot>> failingSupplier = () -> { throw new RuntimeException("snapshot unavailable"); };
        triggerThread.join(10000);  
        MergeScheduler scheduler = new MergeScheduler(  
        IndexSettings idxSettings = new IndexSettings(newIndexMeta("test", autoThrottleSettings), Settings.EMPTY);  
        handler.onMergeFinished(merge, false);
        long elapsed = TimeValue.nsecToMSec(System.nanoTime() - start);
        MockDataFormat format = new MockDataFormat();
        @Override  
            } catch (Exception e) {  
        scheduler.refreshConfig();
        MergeScheduler scheduler = createMergeScheduler();  
    public void testStatsWithAutoThrottleEnabled() {  
        t1.start();
            try {  
import java.nio.file.Path;
        );
            pool.awaitTermination(5, TimeUnit.SECONDS);
        assertTrue(handler.hasPendingMerges());  
    }
        OneMerge merge = new OneMerge(List.of(seg));
            mockThreadPool()
        WriterFileSet mergedWfs = new WriterFileSet(createTempDir().toString(), 99L, Set.of("merged.dat"), 3, 0L);
import java.util.concurrent.CountDownLatch;  
        return new IndexSettings(newIndexMeta("test", settings), Settings.EMPTY);
    }  
        assertTrue(secondStarted.get());
        CountDownLatch latch = new CountDownLatch(1);
    public void testDoMergeReturnsResult() throws IOException {
        }  
        assertEquals(0, scheduler.stats().getCurrent());  
        handler.registerMerge(merge);
    }
            }
        List<Segment> segments = createSegments(3);
        WriterFileSet mergedWfs = new WriterFileSet(dir.toString(), 99L, Set.of("merged.dat"), 10, 0L);
        onForceMergeThread(() -> scheduler.forceMerge(1));
        OneMerge merge = new OneMerge(List.of(seg1, seg2));
    }  
            }
        assertSame(mergeResult, capturedResult.get());
        }, ThreadPool.Names.FORCE_MERGE + "-t2");  
        }  
        });
import java.util.Collection;  
        assertTrue(handler.hasPendingMerges());  
            }  
            handler,
     */
            SHARD_ID,
    }
        Merger slowMerger = mergeInput -> {
            idxSettings,  
            try {  
        OneMerge merge = new OneMerge(List.of(seg));  
        Segment seg2 = Segment.builder(2L).addSearchableFiles(format, fs2).build();  
    private ExecutorService daemonPool(String name) {
            () -> 1L  
            throw new RuntimeException(e);  
            mergeStarted.countDown();  
        AtomicBoolean secondStarted = new AtomicBoolean(false);
        Thread.sleep(200);
        Settings settings = Settings.builder()
        expectThrows(RuntimeException.class, () -> handler.registerMerge(new OneMerge(Collections.emptyList())));
    }
        assertSame(merge1, handler.getNextMerge());  
    private static final MergeHandler.MergePolicy NOOP_MERGE_POLICY = new MergeHandler.MergePolicy() {
            Thread t = new Thread(r);
                Thread.sleep(200);
            .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "6")
            .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "6")  
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), failingMerger);  
        assertFalse(handler.hasPendingMerges());  
            SHARD_ID,
        Thread triggerThread = new Thread(() -> {  
    }
        MergeScheduler scheduler = new MergeScheduler(  
            mockThreadPool()
        Segment seg = Segment.builder(1L).build();
        assertFalse(handler.hasPendingMerges());
        WriterFileSet mergedWfs = new WriterFileSet(createTempDir().toString(), 99L, Set.of("merged.dat"), 3, 0L);
        forceMergeThread.start();
        assertSame(merge2, handler.getNextMerge());
package org.opensearch.index.engine.dataformat.merge;
        allowMergeToFinish.countDown();
import static org.mockito.Mockito.mock;
                secondFinished.set(true);
    private MergeHandler createNoopHandler(Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplier) {
        return () -> new GatedCloseable<>(snap, () -> {});
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), failingMerger);
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), merger);
                throw new RuntimeException(e);
        BiConsumer<MergeResult, OneMerge> applyCallback = (mr, om) -> capturedResult.set(mr);
        List<Segment> segments = createSegments(3);  
    };  
        Thread t = new Thread(() -> {
    @Override
            handler,
        Segment seg1 = Segment.builder(1L).build();  
        MergeScheduler scheduler = new MergeScheduler(
            (mr, om) -> {},
        public List<List<Segment>> findMergeCandidates(List<Segment> segments) {
        MergeHandler handler = createNoopHandler(snapshotSupplierOf(List.of(catalogSeg)));  
        });  
        onForceMergeThread(() -> {
            handler,
        MockDataFormat format = new MockDataFormat();
        Settings autoThrottleSettings = Settings.builder()
/**
        MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));
                Thread.currentThread().interrupt();  
        Segment seg2 = Segment.builder(2L).build();
        OneMerge merge = new OneMerge(List.of(seg));
    }
        assertTrue(mergeStarted.await(5, TimeUnit.SECONDS));
    public void testForceMergeSerializesOnlyConcurrentCallers() throws Exception {  
        MergeScheduler scheduler = new MergeScheduler(createNoopHandler(emptySnapshotSupplier()), (mr, om) -> {  
        };  
        Merger merger = mergeInput -> expectedResult;
            }
        handler.onMergeFailure(merge);
        Segment catalogSeg = Segment.builder(1L).build();
        MergeHandler handler = createNoopHandler(snapshotSupplierOf(List.of(seg)));  
    // ---- MergeHandler doMerge tests ----  
    public void testMergeHandlerLifecycleCallbacks() {
            } catch (IOException e) {
        MockDataFormat format = new MockDataFormat();  
    public void testOneMergeSegmentsListIsUnmodifiable() {
            return List.of();
            t.setDaemon(true);
            pool.shutdownNow();
    public void testRegisterMergeWithEmptySegmentsList() {  
            fail("applyMergeChanges should not be called");
 */  
        scheduler.refreshConfig();
            SHARD_ID,
        );
            Field f = MergeScheduler.class.getDeclaredField("isShutdown");
    }  
            return mergeResult;  
    }
            .build();
        handler.onMergeFailure(merge);
        if (failure.get() != null) {  
            handler,
                allowMergeToFinish.await(10, TimeUnit.SECONDS);
        public void removeMergingSegment(Collection<Segment> mergingSegments) {}
        }
        Merger merger = mergeInput -> {
     * {@link ThreadPool.Names#FORCE_MERGE} to satisfy the forceMerge assertion.
            () -> {},
        MergeHandler handler = createNoopHandler(() -> new GatedCloseable<>(null, () -> {}));  
import java.util.Set;
        assertNotNull(scheduler.stats());
 * compatible open source license.
        WriterFileSet mergedWfs = new WriterFileSet(createTempDir().toString(), 99L, Set.of("merged.dat"), 15, 0L);
        Thread t2 = new Thread(() -> {  
    public void testTriggerMergesExecutesMergeThread() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
    private static void setShutdownFlag(MergeScheduler scheduler, boolean value) {  
        assertFalse(handler.hasPendingMerges());  
    }  
                scheduler.forceMerge(1);  
            .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "6")
        }, ThreadPool.Names.FORCE_MERGE + "-t1");
import static org.mockito.Mockito.when;  
            } catch (InterruptedException e) {
                scheduler.forceMerge(1);
            return List.of();
            latch.countDown();
            () -> {},
    }  
        MergeHandler handler = new MergeHandler(  
    }  
        for (ExecutorService pool : executors) {  
    }
import static org.mockito.ArgumentMatchers.eq;
        return new MergeScheduler(
        MergeHandler handler = createNoopHandler(emptySnapshotSupplier());
                // expected
            mergeSchedulerSettings(),
        assertNull(handler.getNextMerge());
            handler,  
            (mr, om) -> captured.set(mr),
        WriterFileSet fs2 = new WriterFileSet(dir.toString(), 2L, Set.of(), 20, 0L);  
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), merger);
    public void tearDown() throws Exception {
            () -> {},
        AtomicBoolean cleanupCalled = new AtomicBoolean(false);  
            () -> {},  
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), merger);  
    public void testSchedulerDefaultIOThrottleReturnsInfinity() {  
        handler.registerMerge(new OneMerge(List.of(unknownSeg)));
    }
    }
        Thread.sleep(200);
            mergeSchedulerSettings(),
    public void testSchedulerTriggerAndForceMerge() throws Exception {
        );
        assertFalse(handler.hasPendingMerges());  
        Segment seg = Segment.builder(1L).addSearchableFiles(format, inputWfs).build();  
    private static IndexSettings mergeSchedulerSettings() {
        void run() throws Exception;
import org.opensearch.index.IndexSettings;  
    private static final MergeHandler.MergeListener NOOP_MERGE_LISTENER = new MergeHandler.MergeListener() {
    }
    public void testRunMergeInvokesCleanupOnFailure() throws Exception {
        Merger failingMerger = mergeInput -> { throw new IOException("simulated merge failure"); };
        for (int i = 1; i <= count; i++) {
    public void testTriggerMergesWithNoPendingMerges() {  
            throw new IOException("merge boom");
            }
    }  
        assertEquals(Double.POSITIVE_INFINITY, createMergeScheduler().getIORateLimitMBPerSec(), 0.0);
        AtomicReference<MergeResult> captured = new AtomicReference<>();  
        super.tearDown();
        scheduler.triggerMerges();
        assertTrue(caught.get().getMessage().contains("simulated merge failure"));
    public void testRegisterMergeRejectsWhenSecondSegmentNotInCatalog() {
    private static Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplierOf(List<Segment> segments) {
            new IndexSettings(newIndexMeta("test", Settings.EMPTY), Settings.EMPTY).getMergePolicy(true),
        WriterFileSet mergedWfs = new WriterFileSet(createTempDir().toString(), 99L, Set.of("merged.dat"), 3, 0L);
    }
        when(tp.executor(eq(ThreadPool.Names.FORCE_MERGE))).thenReturn(daemonPool(ThreadPool.Names.FORCE_MERGE));
        List<Segment> segments = createSegments(3);
            .build();
import org.opensearch.common.unit.TimeValue;
            latch.countDown();  
        assertSame(expectedResult, result);
            idxSettings,  
        return segments;
    public void testOnMergeFailureRemovesSegments() {  
                secondStarted.set(true);  
    public void testOneMergeToString() {
        AtomicReference<MergeResult> capturedResult = new AtomicReference<>();  
    // ---- MergeScheduler: forceMerge serialization and lifecycle tests ----
            mockThreadPool()
    }
        Segment unknownSeg = Segment.builder(99L).build();
            handler,
            (mergeResult, oneMerge) -> {},  
        when(snap.getSegments()).thenReturn(segments);
    private void onForceMergeThread(ThrowingRunnable action) throws Exception {  
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(
            mergeSchedulerSettings(),  
        AtomicBoolean secondFinished = new AtomicBoolean(false);
        MergeHandler handler = createNoopHandler(snapshotSupplierOf(List.of(catalogSeg)));
                scheduler.triggerMerges();
        Segment unknownSeg = Segment.builder(99L).build();
    @SuppressForbidden(reason = "test needs to set private isShutdown field via reflection")
                triggerError.set(e);
    }
        assertEquals(30L, merge.getTotalNumDocs());
        Path dir = createTempDir();  
 * Tests for the merge flow: {@link OneMerge}, {@link MergeHandler}, and {@link MergeScheduler}.  
        OneMerge merge2 = new OneMerge(List.of(seg2));  
        });  
        Segment seg1 = Segment.builder(1L).addSearchableFiles(format, fs1).build();
        );
import java.util.ArrayList;
        Thread.sleep(200);  
        assertNotNull(createMergeScheduler().stats());
        return new MergeHandler(snapshotSupplier, merger, SHARD_ID, policy, policy, () -> 1L);
            (mr, om) -> {},  
    // ---- MergeScheduler tests ----
 * this file be licensed under the Apache-2.0 license or a
    public void testRunMergeInvokesApplyOnSuccess() throws Exception {
            mergeSchedulerSettings(),  
        Merger merger = mergeInput -> mergeResult;
            return mergeResult;
import org.opensearch.index.MergeSchedulerConfig;
    public void testSchedulerEnableAutoIOThrottle() {
            t.setName(name + "-" + t.threadId());  
        t2.start();  
            handler,
/*  
    }  
        assertNull("forceMerge should complete without error", forceMergeError.get());
        assertNotNull("Expected IOException from forceMerge", caught.get());  
    }
        Segment seg1 = Segment.builder(1L).build();
            () -> {},
        assertFalse(handler.hasPendingMerges());  
            SHARD_ID  
            mergeSchedulerSettings(),  
import java.util.Map;  
        Path dir = createTempDir();  
            } catch (InterruptedException e) {  
            mockThreadPool()
            () -> cleanupCalled.set(true),
        assertNull("triggerMerges should complete without error", triggerError.get());  
        handler.registerMerge(new OneMerge(Collections.emptyList()));
        MergeScheduler scheduler = new MergeScheduler(handler, (mr, om) -> {
import java.lang.reflect.Field;  
            () -> {},
        MergeHandler handler = createNoopHandler(snapshotSupplierOf(List.of(seg1, seg2)));
        ThreadPool tp = mock(ThreadPool.class);
    public void testOneMergeWithEmptySegments() {
    private final List<ExecutorService> executors = new CopyOnWriteArrayList<>();  
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), failingMerger);
        MergeResult result = handler.doMerge(new OneMerge(List.of(seg)));
        public void addMergingSegment(Collection<Segment> mergingSegments) {}
            try {
        CatalogSnapshot snap = mock(CatalogSnapshot.class);  
            NOOP_MERGE_POLICY,
            } catch (Exception e) {
            () -> {},
        MergeHandler handler = createNoopHandler(snapshotSupplierOf(List.of(seg1, seg2)));  
    public void testRegisterMergeThrowsOnAcquireSnapshotFailure() {
        assertTrue(handler.hasPendingMerges());
import org.opensearch.index.engine.dataformat.MergeResult;
            createNoopHandler(emptySnapshotSupplier()),
            (mr, om) -> {},
        }
                Thread.currentThread().interrupt();
        );
        Segment seg = Segment.builder(1L).build();
        assertNull(handler.getNextMerge());
            SHARD_ID,  
    }  
import java.io.IOException;
        CountDownLatch latch = new CountDownLatch(1);
    @SuppressForbidden(reason = "helper to set private isShutdown field via reflection for testing")
        public List<List<Segment>> findForceMergeCandidates(List<Segment> segments, int maxSegmentCount) {  
            SHARD_ID,
import org.opensearch.index.engine.dataformat.Merger;  
            (mr, om) -> {},  
            segments.add(Segment.builder(i).build());  
                scheduler.forceMerge(1);  
import org.opensearch.test.OpenSearchTestCase;
        MergeScheduler scheduler = createMergeScheduler();
        triggerThread.start();  
        forceMergeThread.join(10000);
        MergeScheduler scheduler = new MergeScheduler(
import java.util.concurrent.atomic.AtomicBoolean;
            mockThreadPool()
            createNoopHandler(emptySnapshotSupplier()),
            }  
        assertTrue("forceMerge should block until complete, took " + elapsed + "ms", elapsed >= 150);
            } catch (IOException e) {
        List<Segment> segments = createSegments(15);
        MergeScheduler scheduler = new MergeScheduler(
        );
    }  
        );
            return t;
            return mergeResult;  
            captured.set(mr);
        });
        // Use forceMerge which catches exceptions from runMerge properly
import java.util.concurrent.atomic.AtomicReference;
        WriterFileSet mergedWfs = new WriterFileSet(createTempDir().toString(), 99L, Set.of("merged.dat"), 3, 0L);
        AtomicReference<Exception> triggerError = new AtomicReference<>();
        MockDataFormat format = new MockDataFormat();
            .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1")
            () -> {},
        );
                scheduler.forceMerge(1);
import org.opensearch.threadpool.ThreadPool;  
        OneMerge merge = new OneMerge(List.of(seg1, seg2));
        }, () -> {}, SHARD_ID, mergeSchedulerSettings(), mockThreadPool());
        onForceMergeThread(() -> scheduler.forceMerge(1));
            mergeSchedulerSettings(),  
        assertEquals(0L, merge.getTotalSizeInBytes());
        MockDataFormat format = new MockDataFormat();  
    }  
                mergeStarted.await(5, TimeUnit.SECONDS);
        scheduler.enableAutoIOThrottle();  
    }
            applyCallback,  
    public void testOneMergeAggregatesDocCounts() {
                forceMergeError.set(e);
        onForceMergeThread(() -> scheduler.forceMerge(1));
        );  
        MergeScheduler scheduler = createMergeScheduler();
        );
    }  
    }
            f.setAccessible(true);  
        MockDataFormat format = new MockDataFormat();
            NOOP_MERGE_LISTENER,
            merger,
        handler.registerMerge(merge);
        when(tp.executor(eq(ThreadPool.Names.MERGE))).thenReturn(daemonPool(ThreadPool.Names.MERGE));  
        assertTrue(merge.getSegmentsToMerge().isEmpty());  
        t.start();
        OneMerge merge = new OneMerge(Collections.emptyList());
        MergeScheduler scheduler = createMergeScheduler();  
    private ThreadPool mockThreadPool() {
import org.opensearch.index.engine.exec.Segment;
            mergeSchedulerSettings(),
        MergeResult expectedResult = new MergeResult(Map.of(format, mergedWfs));  
            } catch (IOException expected) {  
    private MergeScheduler createMergeScheduler() {
        assertEquals(20.0, scheduler.getIORateLimitMBPerSec(), 0.0);
    private static List<Segment> createSegments(int count) {  
import java.util.List;
        OneMerge merge1 = new OneMerge(List.of(seg1));
import org.opensearch.index.engine.exec.WriterFileSet;  
        AtomicReference<MergeResult> captured = new AtomicReference<>();
        assertTrue(handler.hasPendingMerges());
    }  
    }
        CountDownLatch mergeStarted = new CountDownLatch(1);
        List<Segment> segments = createSegments(3);  
        AtomicReference<Exception> failure = new AtomicReference<>();
            handler,  
    }  
        Thread forceMergeThread = new Thread(() -> {
        Merger noopMerger = mergeInput -> new MergeResult(Map.of());
    }
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), slowMerger);
        handler.registerMerge(merge);
        Merger failingMerger = mergeInput -> { throw new IOException("merge failure"); };
        Merger slowMerger = mergeInput -> {
        };  
        List<Segment> segments = new ArrayList<>();
    /**
            .build();  
        Settings settings = Settings.builder()  
        MergeScheduler scheduler = createMergeScheduler();
        Thread t1 = new Thread(() -> {
    public void testRegisterMergeRejectsSegmentNotInCatalog() {  
        Merger merger = mergeInput -> mergeResult;
        handler.findAndRegisterMerges();  
            try {  
        MergeHandler handler = createNoopHandler(snapshotSupplierOf(List.of(seg)));  
        }
        List<Segment> segments = createSegments(3);
        MockDataFormat format = new MockDataFormat();
                scheduler.forceMerge(1);
        Merger failingMerger = mergeInput -> {  
        scheduler.triggerMerges();  
import org.opensearch.core.index.shard.ShardId;
    }
            mergeSchedulerSettings(),
        MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));  
            SHARD_ID,  
        assertNotNull(captured.get());
        assertEquals(2, merge.getSegmentsToMerge().size());  
            try {
        handler.onMergeFinished(merge, false);
    private MergeHandler createHandlerWithRealPolicy(Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplier, Merger merger) {  
        handler.registerMerge(merge2);  
            try {
        assertTrue(handler.hasPendingMerges());  
    private interface ThrowingRunnable {  
        AtomicReference<Exception> forceMergeError = new AtomicReference<>();
import java.util.concurrent.Executors;
    }
        handler.registerMerge(new OneMerge(List.of(catalogSeg, unknownSeg)));
                throw new RuntimeException(e);
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        return new MergeHandler(snapshotSupplier, noopMerger, SHARD_ID, NOOP_MERGE_POLICY, NOOP_MERGE_LISTENER, () -> 1L);  
        expectThrows(UnsupportedOperationException.class, () -> merge.getSegmentsToMerge().add(seg));
        MergeScheduler scheduler = new MergeScheduler(
            SHARD_ID,
        assertFalse(handler.hasPendingMerges());
        executors.clear();
        MergeHandler handler = createNoopHandler(emptySnapshotSupplier());  
        @Override  
        MergeHandler handler = createNoopHandler(failingSupplier);
        scheduler.enableAutoIOThrottle();  
        AtomicReference<Exception> caught = new AtomicReference<>();
        };
            SHARD_ID,
 * The OpenSearch Contributors require contributions made to  
    public void testTriggerMergesHandlesMergeFailure() throws Exception {
        MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));  
        assertTrue(secondFinished.get());
    }  
        WriterFileSet inputWfs = new WriterFileSet(dir.toString(), 1L, Set.of("input.dat"), 10, 0L);
        MergeScheduler scheduler = new MergeScheduler(
            } catch (Exception e) {
        WriterFileSet fs1 = new WriterFileSet(dir.toString(), 1L, Set.of(), 10, 0L);
import org.opensearch.common.concurrent.GatedCloseable;
    public void testForceMergePropagatesFailure() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
    private static Supplier<GatedCloseable<CatalogSnapshot>> emptySnapshotSupplier() {
            SHARD_ID,
    // ---- MergeHandler tests ----  
    public void testForceMergeBlocksUntilComplete() throws Exception {
        @Override
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        Segment seg = Segment.builder(1L).build();
        MergeScheduler scheduler = new MergeScheduler(
    }  
            (mr, om) -> {},
        List<Segment> segments = createSegments(15);  
    public void testSchedulerRefreshConfigIdempotent() {
        OneMerge merge = new OneMerge(Collections.emptyList());
        }, () -> { fail("onMergeFailureCleanup should not be called"); }, SHARD_ID, mergeSchedulerSettings(), mockThreadPool());
        ExecutorService pool = Executors.newCachedThreadPool(r -> {  
        assertNotNull(captured.get());
                caught.set(e);  
    public void testConcurrentForceMergeAndBackgroundMerge() throws Exception {
        t1.join(5000);  
    }
        scheduler.triggerMerges();
        assertSame(merge, handler.getNextMerge());
        t.join(30_000);
        assertTrue(latch.await(5, TimeUnit.SECONDS));
import java.util.concurrent.TimeUnit;  
        }, ThreadPool.Names.FORCE_MERGE + "-test");
}
        MergeHandler handler = createHandlerWithRealPolicy(snapshotSupplierOf(segments), merger);
            mockThreadPool()
        MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));  
            SHARD_ID,
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
        };
import org.opensearch.common.settings.Settings;  
        return snapshotSupplierOf(Collections.emptyList());  
                action.run();
            mockThreadPool()  
            try {
        onForceMergeThread(() -> {  
                failure.set(e);  
    public void testGetNextMergeReturnsInOrder() {  
        t2.join(5000);
    }
        MockDataFormat format = new MockDataFormat();
 */
            .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1")  
            mockThreadPool()
        long start = System.nanoTime();  
        MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));
    public void testForceMergeExecutesMerges() throws Exception {
            }
        try {
        WriterFileSet mergedWfs = new WriterFileSet(createTempDir().toString(), 99L, Set.of("merged.dat"), 15, 0L);  
        return pool;
    }  
        MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));
            throw failure.get();
    }
        );
        List<Segment> segments = createSegments(15);
    public void testMergeHandlerInitiallyEmpty() {
    }
            .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1")
        onForceMergeThread(() -> scheduler.forceMerge(1));  
        } catch (Exception e) {
    public void testSchedulerStatsReturnsNonNull() {
            ((AtomicBoolean) f.get(scheduler)).set(value);
public class MergeTests extends OpenSearchTestCase {
        }
        Segment catalogSeg = Segment.builder(1L).build();  
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;  
import java.util.concurrent.CopyOnWriteArrayList;
        assertFalse(secondFinished.get());  
    };
        // Second caller should be blocked (not finished) while first is in progress
    // ---- MergeScheduler: integration with real merge execution ----
        scheduler.triggerMerges();
            try {
            } catch (Exception e) {  
            }
    public void testRegisterMergeWithValidSegments() {
    }  
        OneMerge merge = new OneMerge(Collections.emptyList());
import java.util.concurrent.ExecutorService;
            mockThreadPool()  
            try {
        setShutdownFlag(scheduler, true);
    public void testOnMergeFinishedRemovesSegments() {  
import java.util.function.BiConsumer;  
            SHARD_ID,  
        IndexSettings idxSettings = new IndexSettings(newIndexMeta("test", settings), Settings.EMPTY);  
