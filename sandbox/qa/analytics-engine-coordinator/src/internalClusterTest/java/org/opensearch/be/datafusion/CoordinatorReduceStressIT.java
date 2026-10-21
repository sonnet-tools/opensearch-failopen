            substrait,
        logger.info("R1: 100×50k feed+drain in {} ms; total={}", elapsedMs, downstream.total);
            alloc,
}
            Thread t = new Thread(r, "fan-in-cancel-producer");
        assertTrue("downstream rows must be ≥ 1; got " + downstream.totalRows, downstream.totalRows >= 1);
            aDone.get(60, TimeUnit.SECONDS);
     * Expected SUM = (childA × N × 7) + (childB × N × 11).
     * all batches and runs registerMemtable + executeLocalPlan + drain at close
    private static byte[] buildMultiInputSumSubstrait(int childA, int childB) {
        // between feeds. Mirrors how a real shard-response handler would observe
            for (int i = 0; i < maxBatches; i++) {
                    feeds.incrementAndGet();
     * all use a single-column BIGINT input shape, so one builder serves every call site.
    /**
        Thread.sleep(50);
        long valuePerRow = 7L;
        long deadline = System.currentTimeMillis() + 5_000;
     * in the constructor closes the parent-allocated session on the failure path
 *   <li>{@code CoordinatorReduceMemtableIT} covers the memtable-backed sink
        CountDownLatch producerStarted = new CountDownLatch(1);
     * RootAllocator. That delta is reproducible (same exact byte count
            for (int b = 0; b < 10; b++) {
        } while (System.currentTimeMillis() < deadline);
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
     * those refcounts may not all return. This deserves a Rust-side
    }
        assertTrue("downstream rows must be ≥ 1; got " + downstream.totalRows, downstream.totalRows >= 1);
        );
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
        Thread.ofVirtual().start(() -> sink.reduce(drainDone));
     * refcounts on the Arrow buffers; on the parked-then-aborted path
    /**
        assertEquals("simulated source failure on 10th iteration", caught.getMessage());
import org.apache.calcite.plan.hep.HepPlanner;
        final long expectedPerSink = (long) batchesPerSink * rowsPerBatch * valuePerRow;
     * {@link DatafusionReduceSink#sinkForChild(int)} wrappers. Each child contributes
        if (baseline < 1024L * 1024L) {
            try {
                + "will fail anyway on any drift); before="
            drift = allocAfter - allocBefore;
     */
        } finally {
        );
     */
     * F1 — Multi-input streaming reduce: two children feed via per-child
        logger.info("M2: {} memtable sinks, alloc before={} after={} drift={}", sinkRuns, allocatedBefore, allocatedAfter, drift);
            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
 * exercises the reduce sink directly via stub batches. The internalClusterTest
        Thread.ofVirtual().start(() -> sink.reduce(drainDone));
            List.of(
        AtomicBoolean cancelled = new AtomicBoolean();
    public void testMemtableRejectsMultiInputAndReleasesSession() {
                            0,
    public void testMemtableHandlesBatchedFeed() throws Exception {
            ),
                // Drain failures are acceptable on this fault path — close() must still
        long allocBefore = alloc.getAllocatedMemory();
            producers.shutdownNow();
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
            alloc,
     * <p><b>Surprising finding 1 — there is no producer-observable cancel signal.</b>
        cancelled.set(true);
        long allowed = Math.max(absoluteCeiling, relativeCeiling);
        Thread t = Thread.currentThread();
        producer.setDaemon(true);
        producer.join(15_000);
                }
                }
            sink.close();
        long allocAfter;
        childA.close();
        long allocatedBefore = alloc.getAllocatedMemory();
            0,
        root.setRowCount(rows);
     * but ~33 KB of Arrow-backed buffers remained allocated against the
                new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait("input-0")),
        // (200μs) keeps the producer below the drain thread's consumption rate
            } catch (Exception ignore) {
        assertTrue(
     * M3 — Memtable rejects multi-input construction. Verifies the safety-net check
        Thread.ofVirtual().start(() -> sink.reduce(drainDone));
        // Spawn drain on a VT so the producer's senderSend has somewhere to drain to —
     * allocator returns to baseline.
        // producer should exit within a couple of iterations.
        Thread.ofVirtual().start(() -> sink.reduce(drainDone));
            ExchangeSinkContext ctx = new ExchangeSinkContext(
        int sinkRuns = 50;
                break;
     */
            return t;
            col.setSafe(i, value);
            alloc,
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
import java.nio.file.Path;
        int rowsPerBatch = 50_000;
            sink.sinkForChild(0).close();
        // Signal EOF on both per-child wrappers so drain terminates, then close.
 * @opensearch.internal
 *
    public void testReduceMultiInputCancelMidFeed() throws Exception {
            drainDone.actionGet(30, TimeUnit.SECONDS);
        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
 *   <li>R5 — 50 sequential sinks; allocator memory at start vs. end ≤ 5 MiB
     * cleanly, the drain task must terminate, and native + Java allocators must
    }
        NativeBridge.initTokioRuntimeManager(2);
        long deadline = System.currentTimeMillis() + 5_000;
            producerStarted.countDown();
    /** Default Substrait input id for the single-input case (matches DatafusionReduceSink.INPUT_ID). */
        byte[] substrait = buildSumSubstrait();
        boolean closed;
                if (runtimeHandle != null) {
        // Tight loop with no per-batch sleep — producer parks inside senderSend
        ExchangeSinkContext ctx = new ExchangeSinkContext(
     * Verifies fan-in routes to distinct native partitions and the combined output
                + " after="
            // Signal input EOF (single-input → close the only per-child wrapper) so
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), INPUT_ID, rowType);
            } catch (InterruptedException ignore) {
import org.apache.calcite.rel.core.AggregateCall;
import org.apache.arrow.vector.VectorSchemaRoot;
        Future<?> bDone = producers.submit(() -> {
        long peakEnd = alloc.getPeakMemoryAllocation();
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
public class CoordinatorReduceStressIT extends OpenSearchTestCase {
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        // Allocator must return to baseline within a small slack — sink.close()
    }
            allocAfter = alloc.getAllocatedMemory();
        CapturingSink downstream = new CapturingSink();
 *   <li>{@code DatafusionReduceSinkTests} (unit tests, sibling plugin) covers
     */
            }
        assertEquals("rejected ctor must release the parent-allocated session", allocatedBefore, alloc.getAllocatedMemory());
        }
            alloc,
            peakBaseline,
     * M1 — Memtable variant of R1: 50 batches of 10k BigInt rows. Memtable buffers
            peakEnd
            "q-m1",
    private static final class CapturingSink implements ExchangeSink {
        producer.join(15_000);
        // Let the producer push enough batches that the mpsc fills + a send parks.
import org.opensearch.analytics.spi.ExchangeSinkContext;
import org.apache.calcite.sql.type.SqlTypeName;
        }
            for (int b = 0; b < batches; b++) {
            exec.shutdownNow();
                        ExchangeSinkContext ctx = new ExchangeSinkContext(
        // If a drain were consuming concurrently, the parking race would never fire.
        } finally {
        long start = System.nanoTime();
        try {
        this.runtimeHandle = new NativeRuntimeHandle(runtimePtr);
     * total and releases native handles cleanly.
        // so feeds aren't blocked by a non-running drain at mpsc capacity (4).
            alloc,
            "q-r2",
        try {
     * subsequent {@code senderSend} parks, the exported FFI structs hold
                sink.feed(makeConstantBatch(alloc, inputSchema, 1_000, 7L));
        Thread producer = new Thread(() -> {
        ConcurrentHashMap<Integer, Long> totals = new ConcurrentHashMap<>();
                        CapturingSink downstream = new CapturingSink();
        byte[] substrait = buildSumSubstrait();
            PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
                            alloc,
                + allocAfter,
        AggregateCall sumCall = AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(0), -1, bigintNullable, "total");
                            downstream
            end <= allowed
        long midpoint = baseline;
        // Signal cancel + close the per-child sender to terminate drain. The
@LuceneTestCase.AwaitsFix(bugUrl = "broken")
                });
            downstream
     * An earlier draft of this test sent batches in a tight loop with no
            start.countDown();
                for (int b = 0; b < batchesPerSink; b++) {
            );
     * <p>The sink's contract: feed() is producer-driven, so "stub source throws"
        );
            } catch (InterruptedException ignore) {
     *       the source buffers were never dropped — RootAllocator reports the leak in
        assertTrue("error must mention the single-input limit", ex.getMessage().contains("single input only"));
        assertTrue(
            alloc,
            for (int i = 0; i < concurrency; i++) {
        long allocatedBefore = alloc.getAllocatedMemory();
            Future<?> bDone = producers.submit(() -> {
     * follow-up (or a Java-side defensive {@code release()} on the FFI
 * <p>Gaps this file fills:
            Thread.sleep(50);
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
     *
        long drift;
            childA.close();
            alloc,
    public void testReduceHandlesHundredBatches() throws Exception {
        }
        ExecutorService producers = Executors.newFixedThreadPool(2, r -> {
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
        } finally {
        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
/*
    // ── Memtable variant — DatafusionMemtableReduceSink ─────────────────────────
            // On the producer-failure path the orchestrator still drives the per-child
        RuntimeException caught = null;
                            }
            Thread t = new Thread(r, "fan-in-producer");
        producer.start();
                for (int b = 0; b < batchesPerChild; b++) {
            runOneSink("q-r5-" + i, inputSchema, substrait, 5, 1_000);
    public void testReduceReleasesOnStubFailure() throws Exception {
            allocAfter
            });
        assertEquals("Java allocator must return to baseline after multi-input cancel + close", 0, drift);
        // so senderSend never parks at capacity (which would expose the
                    sink.feed(makeConstantBatch(alloc, inputSchema, 1_000, 7L));
        assertTrue("downstream must have ≥ 1 row", downstream.totalRows >= 1);
    public void testReduceCancelDuringParkedSendLeaks() throws Exception {
 *   <li>R4 — 8 concurrent independent sinks all complete with correct totals.</li>
            downstream
            0L,
        // Bounded source plus an external cancel flag the producer honours
            if (i == n / 2) {
 *   <li>R2 — Failure on 10th source.next() releases native resources.</li>
import org.apache.calcite.plan.RelOptCluster;
                            drainDone.actionGet(30, TimeUnit.SECONDS);
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
     * matches the union sum.
        int rowsPerBatch = 10_000;
     */
/**
    /**
        // guard requires that the producer parks inside senderSend at mpsc capacity.
            downstream
import org.apache.calcite.util.ImmutableBitSet;
    }
        }, "r3-bug-producer");
        long valuePerRow = 7L;
                }
    public void testReduceCancelReleasesNative() throws Exception {
        int rowsPerBatch = 1_000;
        );
            allowed = absoluteCeiling;
        final int concurrency = 8;
     *
            downstream
            } finally {
        long allocatedAfter = alloc.getAllocatedMemory();
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
            substrait,
import java.util.concurrent.atomic.AtomicBoolean;
            0L,
 *       drift (per the user's spec).</li>
            sink.sinkForChild(0).close();
        CapturingSink downstream = new CapturingSink();
                }
     * Used by the multi-input fan-in tests to cover the per-child partition routing
     * (data-node response stream) is inherently finite; tests must mirror
        long allocatedAfter = alloc.getAllocatedMemory();
                    } catch (Throwable t) {
            reduceDone.actionGet(30, TimeUnit.SECONDS);
        ExchangeSinkContext ctx = new ExchangeSinkContext(
     * <p>Fixed by {@code DatafusionReduceSink.feedToSender} invoking the FFI structs'
                try {
                    }
        Thread.ofVirtual().start(() -> sink.reduce(drainDone));
import org.apache.lucene.tests.util.LuceneTestCase;
            sink.sinkForChild(0).close();
                        }
import org.opensearch.action.support.PlainActionFuture;
 *
        logger.info("R3: feeds={} alloc before={} after={} drift={}", feeds.get(), allocBefore, allocAfter, drift);
        long drift = allocatedAfter - allocatedBefore;
                sink.reduce(reduceDone);
        // (cancel-before-body-ran) — see DatafusionReduceSink.close().
            0,
import org.opensearch.be.datafusion.nativelib.NativeBridge;
                            "q-r4-" + idx,
            bDone.get(5, TimeUnit.SECONDS);
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
            substrait,
     * distinct from {@code close()}. After {@code close()}, {@code feed()} is
     */
            substrait,
        }
        }
     * return to baseline.
    /** Builds a single VectorSchemaRoot with {@code rows} entries, all = {@code value}. */
        long peakBaseline = alloc.getPeakMemoryAllocation();
                        } finally {
     * stub. All complete with their correct totals.
            }
                    runtimeHandle.close();
        this.alloc = new RootAllocator(Long.MAX_VALUE);
            });
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(agg);
            substrait,
                0,
                futs[i] = exec.submit(() -> {
     * still cleanly tear down despite the producer's mid-flight exception.
                f.get(remaining, TimeUnit.MILLISECONDS);
        for (var e : totals.entrySet()) {
                }
            DatafusionMemtableReduceSink sink = new DatafusionMemtableReduceSink(ctx, runtimeHandle);
            drift <= 1024 * 1024
        AggregateCall sumCall = AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(0), -1, bigintNullable, "total");
            try {
        assertTrue("producer must start within 5s", producerStarted.await(5, TimeUnit.SECONDS));
            Future<?>[] futs = new Future<?>[concurrency];
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
        final int rowsPerBatch = 1_000;
        } catch (Exception ignore) {
            sink.close();
     *
            0L,
     * context + native resources, propagate the error.
        }
        runOneSink("q-r5-warm", inputSchema, substrait, 5, 1_000);
        }
                drainDone.actionGet(10, TimeUnit.SECONDS);
            bDone.get(60, TimeUnit.SECONDS);
    /**
     * single BIGINT column {@code x} — used as the producer-side plan in
            // Drain failure on cancel path is acceptable — close still releases.
        long end = alloc.getAllocatedMemory();
import org.apache.calcite.plan.hep.HepProgramBuilder;
 *
        assertEquals("union SUM across both child partitions", expected, downstream.total);
                final int idx = i;
        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
 */
 *
     * {@code DataFusionAnalyticsBackendPlugin}.
        AtomicLong feeds = new AtomicLong();
    }
            }
            0,
            t.setContextClassLoader(CoordinatorReduceStressIT.class.getClassLoader());
     *   <li>{@code feedToSender} allocates ArrowArray/Schema and exports the batch.</li>
            drainDone.actionGet(30, TimeUnit.SECONDS);
        CapturingSink downstream = new CapturingSink();
        } finally {
                    childB.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, 11L));
        col.setValueCount(rows);
    /**
            0L,
                if (cancelled.get()) {
        int batches = 50;
        } catch (Exception ignore) {
        do {
        long allocBefore = alloc.getAllocatedMemory();
 * {@link DatafusionReduceSink}.
    public void setUp() throws Exception {
        try {
        sink.sinkForChild(0).close();
            alloc,
            queryId,
        byte[] substrait = buildSumSubstrait();
        );
     * intra-batch sleep; the producer parked inside a senderSend FFI call
                batch.close();
        logger.info(
        // Allow native release callbacks (FFI struct drops on the Rust runtime)
                0L,
        ExecutorService exec = Executors.newFixedThreadPool(concurrency);
        long elapsedMs = (System.nanoTime() - start) / 1_000_000L;
            downstream
                sink.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, 7L));
import org.apache.arrow.vector.BigIntVector;
import java.util.concurrent.TimeUnit;
            0,
            }
        );
        long runtimePtr = NativeBridge.createGlobalRuntime(256L * 1024L * 1024L, 0L, spillDir.toString(), 64L * 1024L * 1024L);
        );
            allowed,
     *   <li>Producer feeds 1k-row int64 batches in a tight loop.</li>
                BigIntVector col = (BigIntVector) batch.getVector(0);
            substrait,
            "Java allocator must return to exact baseline after cancel + close (RootAllocator's tearDown "
        cancelled.set(true);
        long expected = (long) batchesPerChild * rowsPerBatch * 7L + (long) batchesPerChild * rowsPerBatch * 11L;
            if (drift == 0) {
            midpoint,
        BigIntVector col = (BigIntVector) root.getVector(0);
 * this file be licensed under the Apache-2.0 license or a
 * </ul>
 * <p><b>Gap analysis vs. existing reduce tests.</b>
            }
        ExchangeSink childA = sink.sinkForChild(0);
        int rowsPerBatch = 5_000;
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
 *   <li>R1 — High batch count (100 × 50k) drained correctly.</li>
            producerStarted.countDown();
                }
        int batchesPerChild = 20;
     * structs after senderSend errors) but is out of scope for this test
            }
            "Java allocator must return to baseline after stub-failure close: before=" + allocBefore + " after=" + allocAfter,
            buildSumSubstrait(),
        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
                            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
    /** Sums every BigInt in every fed batch. Same shape as {@code DatafusionReduceSinkTests.CapturingSink}. */
     * <p><b>Surprising finding 2 — cancel-during-parked-send leaks ~33 KB.</b>
        LogicalUnion union = LogicalUnion.create(List.of(scanA, scanB), true);
        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
import java.util.concurrent.Future;
                for (int b = 0; b < batchesPerChild; b++) {
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);
     * {@link DatafusionReduceSink} per the documented gate in
        LogicalAggregate agg = LogicalAggregate.create(union, List.of(), ImmutableBitSet.of(), null, List.of(sumCall));
        @Override
                }
    }
                super.tearDown();
                while (cancelled.get() == false) {
        super.setUp();
    /**
                + allocBefore
     * F2 — Multi-input cancellation: producers feeding both children, sink.close()
import org.apache.calcite.rel.type.RelDataTypeFactory;
        RelNode scanB = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), "input-" + childB, rowType);
                new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait("input-0")),
        long allocAfter = alloc.getAllocatedMemory();
    private static final String INPUT_ID = "input-0";
    private RootAllocator alloc;
                        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
                // release natives cleanly.
import java.util.concurrent.ExecutorService;
        CountDownLatch producerStarted = new CountDownLatch(1);
        } finally {
import org.apache.arrow.memory.RootAllocator;
import io.substrait.extension.DefaultExtensionCatalog;
            CapturingSink downstream = new CapturingSink();
                try {
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
    /**
    }
        RelNode scanA = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), "input-" + childA, rowType);
            }
 *       single-batch and 12-batch wedge-detection scenarios.</li>
                midpoint = alloc.getAllocatedMemory();
                }
            }
     * stream WITHOUT a parked send, and the allocator returns cleanly.
            // Simulated source failure — analogous to "stub.next() throws on iter 10".
                            for (int b = 0; b < batchesPerSink; b++) {
        logger.info("F2: cancel-mid-fan-in alloc before={} after={} drift={}", allocatedBefore, allocatedAfter, drift);
        try {
            0L,
            for (int b = 0; b < batches; b++) {
        }
            aDone.get(5, TimeUnit.SECONDS);
        assertEquals("SUM across 50 × 10k constant-7 rows", expected, downstream.total);
        producer.start();
            alloc,
     * signature was {@code Memory leaked: (33202)} (33,586 peak) for a 1k-row
        ExchangeSinkContext ctx = new ExchangeSinkContext(
            return DefaultExtensionCatalog.DEFAULT_COLLECTION;
        }
        Schema schemaB = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
        });
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
    private void runOneSink(String queryId, Schema inputSchema, byte[] substrait, int batches, int rowsPerBatch) {
            fail("R4 had " + failures.size() + " concurrent sink failures; first: " + any);
import io.substrait.extension.SimpleExtension;
            }
            }
            drainDone.actionGet(10, TimeUnit.SECONDS);
                if (cancelled.get()) {
    private NativeRuntimeHandle runtimeHandle;
        try {
     */
                break;
            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
     * should return to the same baseline as before construction. Catches buffer-list
        assertEquals(
 *   <li>{@code CoordinatorReduceIT} / {@code StreamingCoordinatorReduceIT}
     * R3 — Cancel during in-flight feeds. Producer is fed a finite source +
    }
        }
     * </ol>
    private static byte[] buildSumSubstrait() {
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
        logger.info("R3-bug: feeds={} alloc before={} after={} drift={}", feeds.get(), allocBefore, allocAfter, drift);
import java.util.concurrent.Executors;
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
        Thread.ofVirtual().start(() -> sink.reduce(drainDone));
                while (cancelled.get() == false) {
     * the same schema; Substrait sums across the union of both partitions.
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
        CapturingSink downstream = new CapturingSink();
 * sourceSet is used solely so the analytics-backend-datafusion classes are
                        Thread.ofVirtual().start(() -> sink.reduce(drainDone));
import org.apache.arrow.vector.types.pojo.Field;
            t.setContextClassLoader(prev);
            "q-m3",
        );
            t.setDaemon(true);
     * reduce sink + drain thread keep up with sustained per-shard load.
import org.apache.calcite.rel.RelNode;
            try {
                PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
                alloc.close();
        int batches = 100;
        ExchangeSink childB = sink.sinkForChild(1);
            "R5: baseline={} mid={} end={} allowed≤{} peakBaseline={} peakEnd={}",
            }
     *
        long allocBefore = alloc.getAllocatedMemory();
    }
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(), null, List.of(sumCall));
    private static VectorSchemaRoot makeConstantBatch(BufferAllocator alloc, Schema schema, int rows, long value) {
        byte[] substrait = buildSumSubstrait();
        }
            downstream
        // matches production where the reduce task body owns reduce().
                    return;
        byte[] substrait = buildMultiInputSumSubstrait(0, 1);
     * Bare {@code SELECT * FROM <inputId>} substrait whose lowered output schema is the
            Thread.sleep(50);
        Future<?> aDone = producers.submit(() -> {
 *       cover end-to-end PPL → coordinator-reduce → response on a 2-node cluster
 * SPDX-License-Identifier: Apache-2.0
                            0L,
    /**
     * via {@link DatafusionReduceSink#sinkForChild(int)}.
        for (int run = 0; run < sinkRuns; run++) {
                    childB.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, 11L));
     * across runs) and persists past a 5s grace period, so it's not a
        }
                sink.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, valuePerRow));
                } catch (Throwable t) {
        ClassLoader prev = t.getContextClassLoader();
    /**
        // Let the producer push some batches so cancel races mid-stream.
     * R1 — 100 batches of 50,000 BigInt rows, all value=7. Verifies the
            closed = true;
        }
     *
            downstream
    // ── Helpers ──────────────────────────────────────────────────────────────
            0L,
            t.setDaemon(true);
        } catch (RuntimeException e) {
        assertEquals("R4: every sink must report a total", concurrency, totals.size());
        } finally {
        do {
        // New contract: drain runs inline on reduce's caller. Spawn on a VT
                    return;
            }
        assertFalse("downstream must NOT be closed by the reduce sink", downstream.closed);
            0,
        // joins the drain task and releases all per-feed export buffers + natives.
            CountDownLatch start = new CountDownLatch(1);
        CapturingSink downstream = new CapturingSink();
                }
        }
        // Allow native release callbacks (FFI struct drops on the Rust runtime)
            sink.close();
                new ExchangeSinkContext.ChildInput(1, buildPassthroughSubstrait("input-1"))
        long expected = (long) batches * rowsPerBatch * valuePerRow;
            sink.close();
                    return;
                sink.close();
                    feeds.incrementAndGet();
    }
    // ── Fan-in / multi-input streaming sink ─────────────────────────────────────
    }
        AtomicBoolean cancelled = new AtomicBoolean();
                + allocAfter,
     * R3-bug — Regression guard for the close-races-export leak previously
        }
            drainDone.actionGet(30, TimeUnit.SECONDS);
            "Java allocator must return to exact baseline after cancel + close during parked senderSend; before="
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
                Thread.currentThread().interrupt();
                    sink.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, 7L));
            sink.reduce(reduceDone);
    }
     */
        ExchangeSink childA = sink.sinkForChild(0);
            }
 */
        CapturingSink downstream = new CapturingSink();
        });
                    return null;
     * <p>This positive-path R3 inserts a tiny per-batch sleep so the producer
            0,
     * R5 — 50 sequential reduce sinks; assert the Java {@link BufferAllocator}'s
                + " after="
     * that invariant.
        });
        try {
        long expected = (long) batches * rowsPerBatch * valuePerRow;
    public void testReduceMultiInputFanIn() throws Exception {
 * it extends {@link OpenSearchTestCase}, builds a real native runtime, and
            0,
        } while (System.currentTimeMillis() < deadline);
        long drift;
     * leaks (arrays / schemas accumulator) on close.
    /**
            for (int i = 0; i < maxBatches; i++) {
 *
        final long valuePerRow = 7L;
     * Builds Substrait bytes for {@code SELECT SUM(x) FROM "input-0"}. Same shape
                downstream
                        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
        assertTrue("runtime ptr non-zero", runtimePtr != 0);
     * pre-handoff race).
 *       API the sink exposes today).</li>
        producer.setDaemon(true);
            allocAfter
        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
        // a tick to fire before sampling allocator state.
        sink.close();
            List.of(
 * <ul>
 *       variant.</li>
        childB.close();
            "q-r1",
import org.apache.calcite.rel.logical.LogicalAggregate;
        cancelled.set(true);
            }
            } finally {
        );
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(agg);
import java.util.concurrent.CountDownLatch;
        ExchangeSinkContext ctx = new ExchangeSinkContext(
        assertEquals(
     *   <li>Without the release-on-pre-handoff-failure fix, the export's refcounts on
     * Native memory pool drift is observed via debug logs but not asserted —
 * The OpenSearch Contributors require contributions made to
    @Override
     * close happened by looking at feed()'s return type or by catching an
     * documented in {@link #testReduceCancelReleasesNative}'s javadoc. Repro
            "q-f1",
 * Coordinator-side reduce-stage stress + lifecycle hygiene tests for
        try {
            ),
            "q-r3-bug",
        ExchangeSink childB = sink.sinkForChild(1);
     * suite — see {@link #testReduceCancelDuringParkedSendLeaks}.
            substrait,
     */
     * a silent early-out (closed flag check) — producers cannot learn that
    }
            0L,
            List.of(
     */
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
                alloc,
        public synchronized void close() {
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        // close() without a prior reduce is a documented legitimate path
        ConcurrentHashMap<Integer, Throwable> failures = new ConcurrentHashMap<>();
            "BufferAllocator drifted across " + n + " sinks: baseline=" + baseline + " end=" + end + " allowed=" + allowed,
    }
     * maps to "the test producer throws on iteration 10". Sink.close() must
 * <ul>
        // separately-tracked parked-send leak — see javadoc).
    @Override
                new ExchangeSinkContext.ChildInput(1, buildPassthroughSubstrait("input-1"))
        AtomicBoolean cancelled = new AtomicBoolean(false);
            sink.close();
            0L,
    }
        for (int i = 0; i < rows; i++) {
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
     * after the mpsc capacity (4) filled. When close() then dropped the
            for (Future<?> f : futs) {
        assertFalse("producer thread must have exited after cancel + sink.close()", producer.isAlive());
     * fires while producers are mid-stream. Both children's senders must close
        byte[] substrait = buildSumSubstrait();
     *       tearDown.</li>
        int batchesPerSink = 8;
        // NOTE: reduce is intentionally NOT spawned here — this regression
        final int n = 50;
        long baseline = alloc.getAllocatedMemory();
        );
            }
        CapturingSink downstream = new CapturingSink();
            0,
    /**
        @Override
                        failures.put(idx, t);
import org.apache.arrow.memory.BufferAllocator;
            if (drift == 0) {
                totalRows += rows;
     * int64 batch on default arrow-memory-unsafe.
        } finally {
        long total;
        // Warm up: one full sink so JIT/native caches are primed.
            ),
        ExchangeSinkContext ctx = new ExchangeSinkContext(
     *   <li>Producer's {@code sender.getPointer()} call throws before the FFM downcall fires.</li>
     * release callbacks when the sender pointer can't be resolved (i.e. the
     */
                sink.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, valuePerRow));
    /**
            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
    private static byte[] buildPassthroughSubstrait(String inputId) {
                    childA.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, 7L));
        assertEquals("SUM across 100 × 50k constant-7 rows", expected, downstream.total);
     * fault path: when {@code Data.exportVectorSchemaRoot} runs and the
            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
        for (int i = 0; i < n; i++) {
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
                        try {
            baseline,
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        try {
                        start.await();
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
     * Expected SUM = 50 × 10_000 × 7 = 3_500_000.
        }
        ExchangeSinkContext ctx = new ExchangeSinkContext(
     * R4 — 8 concurrent independent reduce sinks, each consuming a 10-batch
 * </ul>
        AtomicLong feeds = new AtomicLong();
            exec.awaitTermination(5, TimeUnit.SECONDS);
                    return;
        );
    private static SimpleExtension.ExtensionCollection loadExtensions() {
        long absoluteCeiling = baseline + 5L * 1024L * 1024L;
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
        assertFalse("downstream must NOT be closed by the reduce sink", downstream.closed);
    }
        sink.close();
        );
                    childA.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, 7L));
        byte[] substrait = buildSumSubstrait();
        assertNotNull("simulated source failure must be observed", caught);
     * accumulated allocation does not drift more than 5 MiB across the run.
package org.opensearch.be.datafusion;
import org.apache.arrow.vector.types.pojo.ArrowType;
        root.allocateNew();
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        ExchangeSinkContext ctx = new ExchangeSinkContext(
        // a tick to fire before sampling allocator state.
        int rowsPerBatch = 2_000;
                } catch (Throwable t) {
     * time, so this verifies the buffered-then-execute path produces the right
        }, "r3-producer");
import org.opensearch.test.OpenSearchTestCase;
import java.util.concurrent.ConcurrentHashMap;
        }
        DatafusionMemtableReduceSink sink = new DatafusionMemtableReduceSink(ctx, runtimeHandle);
        // once the mpsc capacity (4) fills and the drain thread is not pulling.
    }
            0,
        Path spillDir = createTempDir("datafusion-spill");
        Thread.sleep(150);
            producers.shutdownNow();
        });
     */
 * <p>This file lives in the analytics-engine internalClusterTest source set
        byte[] substrait = buildSumSubstrait();
     * <ol>
                    Thread.sleep(2);
                long remaining = Math.max(1L, deadline - System.currentTimeMillis());
     * never parks at capacity (drain thread keeps up); the cancel races mid-
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
    /**
            for (int b = 0; b < batches; b++) {
                substrait,
    public void testReduceAllocatorReleaseUnderLoad() throws Exception {
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
import java.util.concurrent.atomic.AtomicLong;
            // drain terminates naturally.
        long allocAfter;
import org.apache.arrow.vector.types.pojo.Schema;
import java.util.List;
                    try {
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
        int totalRows;
            downstream
     * R2 — Stub source throws on the 10th batch. Sink must release session
            "q-f2",
     * as {@code DatafusionReduceSinkTests.buildSumSubstraitBytes}.
                }
     * the allocator's java-side accounting is the deterministic oracle here.
     * release-callback timing issue.
    }
        public synchronized void feed(VectorSchemaRoot batch) {
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, alloc);
            try {
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        ExchangeSinkContext ctx = new ExchangeSinkContext(
        Thread.sleep(50);
            drainDone.actionGet(10, TimeUnit.SECONDS);
     * <p>The leak is a genuine coordinator-side cleanup gap on the
     *   <li>Concurrent {@code sink.close()} closes the per-input sender's NativeHandle.</li>
            // Both children EOF → drain sees end-of-input on both partitions and exits.
                                sink.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, valuePerRow));
        Schema schemaA = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
                        totals.put(idx, downstream.total);
                for (int i = 0; i < rows; i++) {
                Thread.currentThread().interrupt();
            caught = e;
        CapturingSink downstream = new CapturingSink();
                }
            try {
 *       with deterministic small datasets.</li>
    public void testMemtableAllocatorReleaseUnderLoad() throws Exception {
            if (alloc != null) {
                reduceDone.actionGet(30, TimeUnit.SECONDS);
            end,
        try {
import org.opensearch.analytics.spi.ExchangeSink;
     * Builds Substrait bytes for {@code SELECT SUM(x) FROM (UNION ALL "input-{childA}" + "input-{childB}")}.
        long drift = allocAfter - allocBefore;
            return t;
    }
     *
        if (!failures.isEmpty()) {
     *
            // Drain failure on the cancel path is acceptable — close still releases.
        long drift = allocatedAfter - allocatedBefore;
     * exception. In production this is fine because every producer source
        } finally {
                            sink.close();
            0L,
    public void testReduceConcurrentSinks() throws Exception {
        return root;
                        );
            try {
     */
            Throwable any = failures.values().iterator().next();
        logger.info("R2: alloc before={} after={} drift={}", allocBefore, allocAfter, drift);
        assertTrue("producer must start within 5s", producerStarted.await(5, TimeUnit.SECONDS));
 * compatible open source license.
                "q-m2-" + run,
     */
        } finally {
                new ExchangeSinkContext.ChildInput(1, buildPassthroughSubstrait("input-1"))
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
            }
import org.apache.calcite.rel.type.RelDataType;
            "q-r3",
        long relativeCeiling = (long) (baseline * 1.10);
                            sink.sinkForChild(0).close();
                new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait("input-0")),
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(scan);
     * <p>Race shape:
    /**
            new CapturingSink()
import org.apache.arrow.vector.types.pojo.FieldType;
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> new DatafusionMemtableReduceSink(ctx, runtimeHandle));
            assertEquals("R4 sink #" + e.getKey() + " total mismatch", expectedPerSink, (long) e.getValue());
                    java.util.concurrent.locks.LockSupport.parkNanos(200_000L);
        );
     * external cancel flag; when cancel + close happen mid-stream, the
        final int maxBatches = 200;
            substrait,
     * (otherwise it would leak the native session). Multi-input shapes must use
        try {
        }
 * for cross-plugin coordinator-level coverage, but is NOT a cluster test —
     * {@link DatafusionReduceSink} does not expose a separate "cancel" API
        ExecutorService producers = Executors.newFixedThreadPool(2, r -> {
                    Thread.sleep(2);
            Future<?> aDone = producers.submit(() -> {
            allocBefore,
            allocAfter = alloc.getAllocatedMemory();
 *   <li>R3 — Cancellation via close() during in-flight feeds (the only "cancel"
import org.apache.calcite.rex.RexBuilder;
        byte[] substrait = buildSumSubstrait();
            }
            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
            allocBefore,
        assertFalse("producer thread must have exited after cancel", producer.isAlive());
                    total += col.getDataBuffer().getLong((long) i * BigIntVector.TYPE_WIDTH);
            drift = allocAfter - allocBefore;
        sink.close();
            }
        }
     * {@link ExchangeSinkContext.ChildInput#producerPlanBytes()}. Tests across this file
            long deadline = System.currentTimeMillis() + 60_000;
        assertEquals("Java allocator must return to exact baseline after " + sinkRuns + " memtable sinks", 0, drift);
            } finally {
 * available without exporting them publicly.
        long allocatedBefore = alloc.getAllocatedMemory();
                    sink.feed(makeConstantBatch(alloc, inputSchema, 1_000, 7L));
        final int maxBatches = 200;
        ExchangeSinkContext ctx = new ExchangeSinkContext(
        Thread producer = new Thread(() -> {
        byte[] substrait = buildMultiInputSumSubstrait(0, 1);
import org.apache.calcite.rel.logical.LogicalUnion;
            childB.close();
    }
     * sender, the parked send unwound with a "receiver dropped" error —
                + allocBefore
        );
        // the parent task's cancellation flag and exit early. Per-batch sleep
            // wrapper close to signal EOF — drain then terminates with whatever was fed.
    public void tearDown() throws Exception {
                int rows = batch.getRowCount();
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
            throw new RuntimeException("simulated source failure on 10th iteration");
        try {
        final int batchesPerSink = 10;
     * M2 — Memtable allocator-release: 50 sequential memtable sinks; final allocator
                            substrait,
     * Expected SUM = 100 × 50_000 × 7 = 35_000_000.
