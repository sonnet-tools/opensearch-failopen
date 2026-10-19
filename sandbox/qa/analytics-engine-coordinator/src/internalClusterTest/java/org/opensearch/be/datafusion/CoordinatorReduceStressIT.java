        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
            "q-r3",  
        assertEquals("union SUM across both child partitions", expected, downstream.total);
        // so feeds aren't blocked by a non-running drain at mpsc capacity (4).
 *   <li>{@code DatafusionReduceSinkTests} (unit tests, sibling plugin) covers  
    public void testReduceHandlesHundredBatches() throws Exception {
     */
        // Spawn drain on a VT so the producer's senderSend has somewhere to drain to —
     * M3 — Memtable rejects multi-input construction. Verifies the safety-net check
    public void testReduceMultiInputFanIn() throws Exception {  
                        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();  
                }  
    }
        AtomicLong feeds = new AtomicLong();
        do {
        }  
        );
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));  
        this.alloc = new RootAllocator(Long.MAX_VALUE);  
        Schema schemaA = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));  
    public void testReduceConcurrentSinks() throws Exception {
    @Override
        });
        producer.join(15_000);
 *
            substrait,
            }
            t.setContextClassLoader(CoordinatorReduceStressIT.class.getClassLoader());
                for (int b = 0; b < batchesPerChild; b++) {
            }  
package org.opensearch.be.datafusion;
                + allocBefore
        RelNode scanB = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), "input-" + childB, rowType);  
                        failures.put(idx, t);
        try {  
                substrait,  
        Future<?> aDone = producers.submit(() -> {
import org.apache.calcite.util.ImmutableBitSet;
    }
                        } finally {
     *   <li>Without the release-on-pre-handoff-failure fix, the export's refcounts on
            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
            sink.close();
     * R4 — 8 concurrent independent reduce sinks, each consuming a 10-batch
            0,
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(), null, List.of(sumCall));
                new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait("input-0")),  
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
        } finally {
    }
     * sender, the parked send unwound with a "receiver dropped" error —  
        ExchangeSinkContext ctx = new ExchangeSinkContext(
                    sink.feed(makeConstantBatch(alloc, inputSchema, 1_000, 7L));  
        assertFalse("producer thread must have exited after cancel", producer.isAlive());  
 */  
     * the same schema; Substrait sums across the union of both partitions.
        }, "r3-bug-producer");
                                sink.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, valuePerRow));
     * F1 — Multi-input streaming reduce: two children feed via per-child
                    return;
@LuceneTestCase.AwaitsFix(bugUrl = "broken")
            childB.close();  
     * across runs) and persists past a 5s grace period, so it's not a  
        assertEquals("rejected ctor must release the parent-allocated session", allocatedBefore, alloc.getAllocatedMemory());
     * close happened by looking at feed()'s return type or by catching an  
     * M1 — Memtable variant of R1: 50 batches of 10k BigInt rows. Memtable buffers  
     * R3 — Cancel during in-flight feeds. Producer is fed a finite source +
     * R5 — 50 sequential reduce sinks; assert the Java {@link BufferAllocator}'s
        });
        );
import java.util.concurrent.atomic.AtomicLong;  
            for (int i = 0; i < maxBatches; i++) {
import org.apache.calcite.rel.RelNode;
        Thread.ofVirtual().start(() -> sink.reduce(drainDone));  
import org.apache.arrow.vector.VectorSchemaRoot;
            0L,
    private static final String INPUT_ID = "input-0";
    }
            allocAfter
        AtomicBoolean cancelled = new AtomicBoolean();
        AtomicBoolean cancelled = new AtomicBoolean();
            exec.shutdownNow();
        NativeBridge.initTokioRuntimeManager(2);
        // producer should exit within a couple of iterations.  
                try {
        );
            0L,  
                sink.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, valuePerRow));
            Thread.sleep(50);
                while (cancelled.get() == false) {
            producers.shutdownNow();
            Thread.sleep(50);
        ConcurrentHashMap<Integer, Throwable> failures = new ConcurrentHashMap<>();
            try {  
            sink.close();
 *       single-batch and 12-batch wedge-detection scenarios.</li>
 *       with deterministic small datasets.</li>
        super.setUp();  
        if (!failures.isEmpty()) {
        }, "r3-producer");
            }  
        assertEquals("Java allocator must return to exact baseline after " + sinkRuns + " memtable sinks", 0, drift);  
        }
        }
                new ExchangeSinkContext.ChildInput(1, buildPassthroughSubstrait("input-1"))
        }
        assertNotNull("simulated source failure must be observed", caught);
                            0,
     * (otherwise it would leak the native session). Multi-input shapes must use  
 *
     * M2 — Memtable allocator-release: 50 sequential memtable sinks; final allocator
                + allocAfter,
        long drift;
 *       variant.</li>  
     * Expected SUM = 100 × 50_000 × 7 = 35_000_000.
     * single BIGINT column {@code x} — used as the producer-side plan in  
        Thread.ofVirtual().start(() -> sink.reduce(drainDone));
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
                            for (int b = 0; b < batchesPerSink; b++) {  
            childA.close();
 *       drift (per the user's spec).</li>
                sink.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, 7L));  
        );
        } while (System.currentTimeMillis() < deadline);
            fail("R4 had " + failures.size() + " concurrent sink failures; first: " + any);
        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
        do {
        RelNode scanA = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), "input-" + childA, rowType);
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);  
            allocAfter = alloc.getAllocatedMemory();
 *   <li>R1 — High batch count (100 × 50k) drained correctly.</li>
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(agg);
        Thread.ofVirtual().start(() -> sink.reduce(drainDone));
        // Allocator must return to baseline within a small slack — sink.close()
        } finally {
     * release-callback timing issue.
        }
            }
                    Thread.sleep(2);
        long total;  
        }
            return t;  
        );  
        final int batchesPerSink = 10;  
            ),  
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
     * total and releases native handles cleanly.  
                futs[i] = exec.submit(() -> {
        return root;
                }
import org.apache.calcite.sql.type.SqlTypeName;  
        final int concurrency = 8;
            }  
            0,
     * fires while producers are mid-stream. Both children's senders must close
     * stream WITHOUT a parked send, and the allocator returns cleanly.
        // close() without a prior reduce is a documented legitimate path
            sink.reduce(reduceDone);
            "Java allocator must return to exact baseline after cancel + close during parked senderSend; before="  
     *       tearDown.</li>
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> new DatafusionMemtableReduceSink(ctx, runtimeHandle));  
     * should return to the same baseline as before construction. Catches buffer-list  
        // Signal EOF on both per-child wrappers so drain terminates, then close.
        Thread.ofVirtual().start(() -> sink.reduce(drainDone));
            downstream  
        logger.info("R1: 100×50k feed+drain in {} ms; total={}", elapsedMs, downstream.total);  
            t.setDaemon(true);  
            end <= allowed
                alloc.close();
        boolean closed;
        try {
                0,
            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
        byte[] substrait = buildSumSubstrait();
    /**  
 *   <li>R3 — Cancellation via close() during in-flight feeds (the only "cancel"
            CountDownLatch start = new CountDownLatch(1);  
     * Expected SUM = (childA × N × 7) + (childB × N × 11).
        CapturingSink downstream = new CapturingSink();  
            drainDone.actionGet(30, TimeUnit.SECONDS);  
     * R1 — 100 batches of 50,000 BigInt rows, all value=7. Verifies the  
            // wrapper close to signal EOF — drain then terminates with whatever was fed.  
            alloc,  
        long absoluteCeiling = baseline + 5L * 1024L * 1024L;
    }  
            ),
    private void runOneSink(String queryId, Schema inputSchema, byte[] substrait, int batches, int rowsPerBatch) {
        // once the mpsc capacity (4) fills and the drain thread is not pulling.
     *
     * intra-batch sleep; the producer parked inside a senderSend FFI call
     *
        // Signal cancel + close the per-child sender to terminate drain. The
        }  
                });
            try {
            0,  
                // release natives cleanly.  
            throw new RuntimeException("simulated source failure on 10th iteration");
                    try {
    @Override  
        ExchangeSink childB = sink.sinkForChild(1);  
        assertEquals("SUM across 50 × 10k constant-7 rows", expected, downstream.total);
                            0L,
        }
import org.apache.arrow.memory.BufferAllocator;
                        ExchangeSinkContext ctx = new ExchangeSinkContext(
            0,
        ExchangeSink childA = sink.sinkForChild(0);
     *
    }  
                    return null;  
 * available without exporting them publicly.
                            alloc,
                    java.util.concurrent.locks.LockSupport.parkNanos(200_000L);
                }  
                    return;  
import org.apache.lucene.tests.util.LuceneTestCase;
     * Verifies fan-in routes to distinct native partitions and the combined output
                for (int i = 0; i < rows; i++) {
     * Builds Substrait bytes for {@code SELECT SUM(x) FROM "input-0"}. Same shape
    /**  
            downstream
        ExchangeSinkContext ctx = new ExchangeSinkContext(  
        public synchronized void close() {
                            sink.sinkForChild(0).close();  
        // so senderSend never parks at capacity (which would expose the
import java.util.concurrent.Executors;
        } finally {
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
     * Native memory pool drift is observed via debug logs but not asserted —  
            buildSumSubstrait(),  
        Path spillDir = createTempDir("datafusion-spill");
     * <p>This positive-path R3 inserts a tiny per-batch sleep so the producer  
     * <p>The sink's contract: feed() is producer-driven, so "stub source throws"
    public void testMemtableRejectsMultiInputAndReleasesSession() {
            downstream
        long midpoint = baseline;  
        root.allocateNew();  
            baseline,
        ConcurrentHashMap<Integer, Long> totals = new ConcurrentHashMap<>();  
        byte[] substrait = buildSumSubstrait();
        sink.close();
                    childB.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, 11L));
            for (int b = 0; b < batches; b++) {
        CountDownLatch producerStarted = new CountDownLatch(1);
 *       API the sink exposes today).</li>
        ExchangeSink childA = sink.sinkForChild(0);  
                int rows = batch.getRowCount();
     */  
        int rowsPerBatch = 50_000;  
 * sourceSet is used solely so the analytics-backend-datafusion classes are
        try {
        long peakEnd = alloc.getPeakMemoryAllocation();  
            closed = true;
                for (int b = 0; b < batchesPerSink; b++) {
                            "q-r4-" + idx,  
 * SPDX-License-Identifier: Apache-2.0
            "Java allocator must return to exact baseline after cancel + close (RootAllocator's tearDown "
        byte[] substrait = buildSumSubstrait();
            producerStarted.countDown();  
     *   <li>Concurrent {@code sink.close()} closes the per-input sender's NativeHandle.</li>  
    public void testReduceReleasesOnStubFailure() throws Exception {  
                        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
        logger.info("F2: cancel-mid-fan-in alloc before={} after={} drift={}", allocatedBefore, allocatedAfter, drift);
        // separately-tracked parked-send leak — see javadoc).  
/*  
            Future<?> bDone = producers.submit(() -> {  
        int batches = 100;
    private static final class CapturingSink implements ExchangeSink {
     * but ~33 KB of Arrow-backed buffers remained allocated against the
                        Thread.ofVirtual().start(() -> sink.reduce(drainDone));
        try {
            reduceDone.actionGet(30, TimeUnit.SECONDS);  
            } catch (InterruptedException ignore) {  
        assertEquals("R4: every sink must report a total", concurrency, totals.size());  
    /**
            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
            start.countDown();  
            return DefaultExtensionCatalog.DEFAULT_COLLECTION;  
        }  
    public void testReduceAllocatorReleaseUnderLoad() throws Exception {  
        RuntimeException caught = null;
        producer.start();
                super.tearDown();  
            producers.shutdownNow();  
                downstream  
        Thread.sleep(50);  
            try {
     * Builds Substrait bytes for {@code SELECT SUM(x) FROM (UNION ALL "input-{childA}" + "input-{childB}")}.  
     * R3-bug — Regression guard for the close-races-export leak previously  
                    Thread.sleep(2);  
     * matches the union sum.  
            List.of(  
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
                }  
                }
            "q-r3-bug",
        final long expectedPerSink = (long) batchesPerSink * rowsPerBatch * valuePerRow;  
            if (alloc != null) {  
                + " after="
            downstream
 * {@link DatafusionReduceSink}.
        // New contract: drain runs inline on reduce's caller. Spawn on a VT
     */
        ExchangeSinkContext ctx = new ExchangeSinkContext(
        assertEquals(
import java.util.List;
        DatafusionMemtableReduceSink sink = new DatafusionMemtableReduceSink(ctx, runtimeHandle);
        RexBuilder rexBuilder = new RexBuilder(typeFactory);  
        final int maxBatches = 200;  
     * stub. All complete with their correct totals.
     * <p>The leak is a genuine coordinator-side cleanup gap on the  
            sink.sinkForChild(0).close();
        // the parent task's cancellation flag and exit early. Per-batch sleep  
        Thread.ofVirtual().start(() -> sink.reduce(drainDone));  
    /**  
            } finally {
     * leaks (arrays / schemas accumulator) on close.
            for (int i = 0; i < maxBatches; i++) {  
            0,
     * that invariant.  
        assertTrue("error must mention the single-input limit", ex.getMessage().contains("single input only"));
        int batchesPerSink = 8;  
                + " after="
 * for cross-plugin coordinator-level coverage, but is NOT a cluster test —
        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
     * <p>Fixed by {@code DatafusionReduceSink.feedToSender} invoking the FFI structs'
        long allocAfter;
            for (Future<?> f : futs) {
            Future<?> aDone = producers.submit(() -> {
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
        );
    public void testMemtableHandlesBatchedFeed() throws Exception {  
                long remaining = Math.max(1L, deadline - System.currentTimeMillis());  
                sink.close();
 * exercises the reduce sink directly via stub batches. The internalClusterTest  
            aDone.get(60, TimeUnit.SECONDS);
        );
import java.nio.file.Path;  
                }  
                    return;
    }
            alloc,
        cancelled.set(true);  
    /**  
        long allocAfter = alloc.getAllocatedMemory();  
                Thread.currentThread().interrupt();
        Thread t = Thread.currentThread();
import org.apache.calcite.plan.hep.HepPlanner;
import io.substrait.extension.SimpleExtension;  
        assertTrue("downstream must have ≥ 1 row", downstream.totalRows >= 1);
     * structs after senderSend errors) but is out of scope for this test  
        // joins the drain task and releases all per-feed export buffers + natives.
            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
 *   <li>R2 — Failure on 10th source.next() releases native resources.</li>  
        } catch (Exception ignore) {  
    }  
    // ── Helpers ──────────────────────────────────────────────────────────────
        }
     * context + native resources, propagate the error.  
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
        sink.close();  
    /**
        ExchangeSinkContext ctx = new ExchangeSinkContext(
            drainDone.actionGet(10, TimeUnit.SECONDS);  
        assertTrue(
     * </ol>
                sink.reduce(reduceDone);
            0L,
        );  
            } finally {
     * all batches and runs registerMemtable + executeLocalPlan + drain at close
    }  
        final int maxBatches = 200;
        long relativeCeiling = (long) (baseline * 1.10);  
import org.apache.arrow.vector.BigIntVector;  
                try {
                            }
            for (int b = 0; b < 10; b++) {  
     *
                BigIntVector col = (BigIntVector) batch.getVector(0);
        } finally {
     * {@link DatafusionReduceSink} per the documented gate in
            alloc,  
        } finally {
                }
        assertTrue("producer must start within 5s", producerStarted.await(5, TimeUnit.SECONDS));
    /**
        // matches production where the reduce task body owns reduce().  
            0,  
 *   <li>{@code CoordinatorReduceMemtableIT} covers the memtable-backed sink
        ExchangeSinkContext ctx = new ExchangeSinkContext(
        int totalRows;
        long allocatedBefore = alloc.getAllocatedMemory();
     * <p><b>Surprising finding 1 — there is no producer-observable cancel signal.</b>
     * (data-node response stream) is inherently finite; tests must mirror
    }  
            caught = e;  
    private static VectorSchemaRoot makeConstantBatch(BufferAllocator alloc, Schema schema, int rows, long value) {
     * refcounts on the Arrow buffers; on the parked-then-aborted path  
    /**
            }
        byte[] substrait = buildSumSubstrait();
            });
        Thread.ofVirtual().start(() -> sink.reduce(drainDone));  
    private RootAllocator alloc;
                            substrait,  
    /**
            drift <= 1024 * 1024
        for (int i = 0; i < rows; i++) {
        childA.close();
     * via {@link DatafusionReduceSink#sinkForChild(int)}.
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(scan);  
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
    public void setUp() throws Exception {
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
            // Signal input EOF (single-input → close the only per-child wrapper) so
            midpoint,
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
     */
                }
            alloc,  
    /**  
        for (int run = 0; run < sinkRuns; run++) {  
            for (int b = 0; b < batches; b++) {
        try {  
            } finally {
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(agg);
 * </ul>
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
            "Java allocator must return to baseline after stub-failure close: before=" + allocBefore + " after=" + allocAfter,
            for (int b = 0; b < batches; b++) {
        Thread.sleep(150);
            drift = allocAfter - allocBefore;  
 *
            alloc,
        @Override
    // ── Memtable variant — DatafusionMemtableReduceSink ─────────────────────────  
        // between feeds. Mirrors how a real shard-response handler would observe
            ),
            0,
     */  
    /**
        CapturingSink downstream = new CapturingSink();  
     * Used by the multi-input fan-in tests to cover the per-child partition routing
        } finally {
     */  
            }
            substrait,
                if (cancelled.get()) {
        assertEquals("SUM across 100 × 50k constant-7 rows", expected, downstream.total);
    /**
        long valuePerRow = 7L;  
        long deadline = System.currentTimeMillis() + 5_000;
        BigIntVector col = (BigIntVector) root.getVector(0);
            0L,
            substrait,  
            "q-r2",
        final long valuePerRow = 7L;
        logger.info("R3-bug: feeds={} alloc before={} after={} drift={}", feeds.get(), allocBefore, allocAfter, drift);
     * reduce sink + drain thread keep up with sustained per-shard load.
    }
            }  
import org.opensearch.be.datafusion.nativelib.NativeBridge;  
            substrait,
            return t;
     */
            allowed,
            assertEquals("R4 sink #" + e.getKey() + " total mismatch", expectedPerSink, (long) e.getValue());
            producerStarted.countDown();
     * allocator returns to baseline.  
                for (int b = 0; b < batchesPerChild; b++) {
            sink.close();  
                }
        assertTrue("downstream rows must be ≥ 1; got " + downstream.totalRows, downstream.totalRows >= 1);  
import org.apache.calcite.rel.logical.LogicalUnion;
        int rowsPerBatch = 5_000;
        root.setRowCount(rows);  
            sink.close();
                if (runtimeHandle != null) {
     * as {@code DatafusionReduceSinkTests.buildSumSubstraitBytes}.
        logger.info(
import org.apache.arrow.memory.RootAllocator;
import java.util.concurrent.Future;  
     * accumulated allocation does not drift more than 5 MiB across the run.
        LogicalUnion union = LogicalUnion.create(List.of(scanA, scanB), true);
            alloc,
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);  
    }
        byte[] substrait = buildSumSubstrait();
                batch.close();
                while (cancelled.get() == false) {
        ExchangeSink childB = sink.sinkForChild(1);
     * Bare {@code SELECT * FROM <inputId>} substrait whose lowered output schema is the
        });
     * <p>Race shape:
                + "will fail anyway on any drift); before="
        Schema schemaB = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
        int batches = 50;
 *  
            drainDone.actionGet(10, TimeUnit.SECONDS);
        ExchangeSinkContext ctx = new ExchangeSinkContext(  
 * <p><b>Gap analysis vs. existing reduce tests.</b>
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        );  
     * {@link ExchangeSinkContext.ChildInput#producerPlanBytes()}. Tests across this file
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
    public void testMemtableAllocatorReleaseUnderLoad() throws Exception {  
                            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
            0L,
            long deadline = System.currentTimeMillis() + 60_000;
            }
/**
import org.apache.arrow.vector.types.pojo.ArrowType;
     * pre-handoff race).  
            PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, alloc);
        } while (System.currentTimeMillis() < deadline);  
            "BufferAllocator drifted across " + n + " sinks: baseline=" + baseline + " end=" + end + " allowed=" + allowed,  
     * cleanly, the drain task must terminate, and native + Java allocators must
            drainDone.actionGet(30, TimeUnit.SECONDS);
        producer.start();  
    public void testReduceCancelDuringParkedSendLeaks() throws Exception {
     * still cleanly tear down despite the producer's mid-flight exception.
            peakBaseline,
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));  
                + allocAfter,  
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
import org.apache.calcite.rel.core.AggregateCall;
        CapturingSink downstream = new CapturingSink();
        int sinkRuns = 50;
        byte[] substrait = buildSumSubstrait();  
 * @opensearch.internal
import org.apache.arrow.vector.types.pojo.Schema;
     */
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
        ExchangeSinkContext ctx = new ExchangeSinkContext(
        producer.setDaemon(true);  
        if (baseline < 1024L * 1024L) {
                midpoint = alloc.getAllocatedMemory();
        // Allow native release callbacks (FFI struct drops on the Rust runtime)  
    private static byte[] buildPassthroughSubstrait(String inputId) {
import io.substrait.extension.DefaultExtensionCatalog;
            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),
        Future<?> bDone = producers.submit(() -> {  
            "q-f1",
        byte[] substrait = buildSumSubstrait();
            }
import java.util.concurrent.CountDownLatch;  
        DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
        RexBuilder rexBuilder = new RexBuilder(typeFactory);  
            for (int i = 0; i < concurrency; i++) {
 * it extends {@link OpenSearchTestCase}, builds a real native runtime, and
        long allocatedBefore = alloc.getAllocatedMemory();  
                    childA.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, 7L));  
     *   <li>{@code feedToSender} allocates ArrowArray/Schema and exports the batch.</li>
     * int64 batch on default arrow-memory-unsafe.  
    private static byte[] buildSumSubstrait() {
        byte[] substrait = buildSumSubstrait();  
        ExchangeSinkContext ctx = new ExchangeSinkContext(
                    return;
        // NOTE: reduce is intentionally NOT spawned here — this regression
    /** Default Substrait input id for the single-input case (matches DatafusionReduceSink.INPUT_ID). */
        RexBuilder rexBuilder = new RexBuilder(typeFactory);  
        ExecutorService exec = Executors.newFixedThreadPool(concurrency);
        AggregateCall sumCall = AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(0), -1, bigintNullable, "total");
 *   <li>{@code CoordinatorReduceIT} / {@code StreamingCoordinatorReduceIT}
            0L,
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        sink.sinkForChild(0).close();
            0,  
            alloc,
        final int rowsPerBatch = 1_000;
                    sink.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, 7L));
import org.apache.calcite.rel.logical.LogicalAggregate;  
                    childA.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, 7L));
 * <p>Gaps this file fills:  
        } finally {
     * {@link DatafusionReduceSink#sinkForChild(int)} wrappers. Each child contributes  
        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();  
                + allocBefore  
        LogicalAggregate agg = LogicalAggregate.create(union, List.of(), ImmutableBitSet.of(), null, List.of(sumCall));  
        long start = System.nanoTime();
        ClassLoader prev = t.getContextClassLoader();  
            if (drift == 0) {
        try {
 * <p>This file lives in the analytics-engine internalClusterTest source set  
        AtomicLong feeds = new AtomicLong();  
            }
            Future<?>[] futs = new Future<?>[concurrency];
        long allocBefore = alloc.getAllocatedMemory();
            }  
    }
            substrait,  
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), INPUT_ID, rowType);
        int batchesPerChild = 20;
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);  
        try {
            end,  
                            drainDone.actionGet(30, TimeUnit.SECONDS);
     * all use a single-column BIGINT input shape, so one builder serves every call site.
            0L,
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
                    } catch (Throwable t) {  
        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
        // Let the producer push some batches so cancel races mid-stream.
        for (var e : totals.entrySet()) {
        long valuePerRow = 7L;
     * {@link DatafusionReduceSink} does not expose a separate "cancel" API  
        assertTrue(  
import org.opensearch.analytics.spi.ExchangeSinkContext;
        // (cancel-before-body-ran) — see DatafusionReduceSink.close().
            try {  
        // (200μs) keeps the producer below the drain thread's consumption rate
                    runtimeHandle.close();  
                }
        ExecutorService producers = Executors.newFixedThreadPool(2, r -> {
public class CoordinatorReduceStressIT extends OpenSearchTestCase {
     * time, so this verifies the buffered-then-execute path produces the right
        }  
            drift = allocAfter - allocBefore;
        long allocatedBefore = alloc.getAllocatedMemory();
     *
     * never parks at capacity (drain thread keeps up); the cancel races mid-
        // Tight loop with no per-batch sleep — producer parks inside senderSend
import org.apache.arrow.vector.types.pojo.FieldType;
        long runtimePtr = NativeBridge.createGlobalRuntime(256L * 1024L * 1024L, 0L, spillDir.toString(), 64L * 1024L * 1024L);  
            sink.sinkForChild(0).close();  
            // Drain failure on cancel path is acceptable — close still releases.
                } catch (Throwable t) {
            List.of(
            downstream
        childB.close();  
                    total += col.getDataBuffer().getLong((long) i * BigIntVector.TYPE_WIDTH);
            0,  
     * suite — see {@link #testReduceCancelDuringParkedSendLeaks}.
    }
        producer.setDaemon(true);
            t.setContextClassLoader(prev);
        AggregateCall sumCall = AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(0), -1, bigintNullable, "total");  
        assertFalse("producer thread must have exited after cancel + sink.close()", producer.isAlive());  
import org.apache.calcite.rex.RexBuilder;
    private static SimpleExtension.ExtensionCollection loadExtensions() {
     * after the mpsc capacity (4) filled. When close() then dropped the
     */  
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
            // On the producer-failure path the orchestrator still drives the per-child
                alloc,
                            downstream  
        );
        long allocBefore = alloc.getAllocatedMemory();  
 *   <li>R4 — 8 concurrent independent sinks all complete with correct totals.</li>  
            peakEnd  
            allocBefore,
        );  
        logger.info("R2: alloc before={} after={} drift={}", allocBefore, allocAfter, drift);
        );  
        assertEquals("Java allocator must return to baseline after multi-input cancel + close", 0, drift);
     * external cancel flag; when cancel + close happen mid-stream, the
            allocAfter
     * in the constructor closes the parent-allocated session on the failure path
    public void tearDown() throws Exception {
            // Drain failure on the cancel path is acceptable — close still releases.
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
import java.util.concurrent.ConcurrentHashMap;
            // drain terminates naturally.
            }
            DatafusionMemtableReduceSink sink = new DatafusionMemtableReduceSink(ctx, runtimeHandle);
                new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait("input-0")),
        }
        @Override  
        long peakBaseline = alloc.getPeakMemoryAllocation();
 * </ul>  
     * return to baseline.  
                sink.feed(makeConstantBatch(alloc, inputSchema, 1_000, 7L));
                        totals.put(idx, downstream.total);
            "q-r1",  
        } catch (RuntimeException e) {
 * compatible open source license.
        } catch (Exception ignore) {
                        CapturingSink downstream = new CapturingSink();
        } finally {  
            bDone.get(5, TimeUnit.SECONDS);  
                reduceDone.actionGet(30, TimeUnit.SECONDS);  
            bDone.get(60, TimeUnit.SECONDS);  
import org.apache.calcite.rel.type.RelDataType;
                    childB.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, 11L));  
    }
            }  
                sink.feed(makeConstantBatch(alloc, inputSchema, rowsPerBatch, valuePerRow));
            CapturingSink downstream = new CapturingSink();
     * subsequent {@code senderSend} parks, the exported FFI structs hold
        CapturingSink downstream = new CapturingSink();  
        // a tick to fire before sampling allocator state.  
            }  
        Thread producer = new Thread(() -> {
     *   <li>Producer's {@code sender.getPointer()} call throws before the FFM downcall fires.</li>
        });  
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));  
 * this file be licensed under the Apache-2.0 license or a
        cancelled.set(true);  
    public void testReduceCancelReleasesNative() throws Exception {
import org.apache.calcite.plan.hep.HepProgramBuilder;  
    }
            substrait,
     */  
            try {
            new CapturingSink()  
 * The OpenSearch Contributors require contributions made to  
        // Warm up: one full sink so JIT/native caches are primed.
        // a tick to fire before sampling allocator state.
        }  
 * <ul>
        // Allow native release callbacks (FFI struct drops on the Rust runtime)
                drainDone.actionGet(10, TimeUnit.SECONDS);  
        );
        CountDownLatch producerStarted = new CountDownLatch(1);  
     * F2 — Multi-input cancellation: producers feeding both children, sink.close()  
            List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait(INPUT_ID))),  
     */
     * <ol>  
        );  
     * exception. In production this is fine because every producer source
import java.util.concurrent.ExecutorService;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;  
        try {
        this.runtimeHandle = new NativeRuntimeHandle(runtimePtr);
            exec.awaitTermination(5, TimeUnit.SECONDS);
                0L,
     * Expected SUM = 50 × 10_000 × 7 = 3_500_000.
     */  
        ExchangeSinkContext ctx = new ExchangeSinkContext(
     */
                        start.await();  
     *  
        try {  
        // guard requires that the producer parks inside senderSend at mpsc capacity.
     *
        assertTrue("producer must start within 5s", producerStarted.await(5, TimeUnit.SECONDS));
        // Let the producer push enough batches that the mpsc fills + a send parks.  
    }
            Thread t = new Thread(r, "fan-in-producer");
            sink.close();
 *
                break;  
        }
    /**
        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
            col.setSafe(i, value);  
        Thread producer = new Thread(() -> {
            }
        long allocatedAfter = alloc.getAllocatedMemory();  
                    }
        col.setValueCount(rows);
        CapturingSink downstream = new CapturingSink();  
                } catch (Throwable t) {  
        long drift = allocatedAfter - allocatedBefore;
        }  
        try {
            Thread t = new Thread(r, "fan-in-cancel-producer");
            } catch (InterruptedException ignore) {
            });
        long drift;  
                // Drain failures are acceptable on this fault path — close() must still
 *   <li>R5 — 50 sequential sinks; allocator memory at start vs. end ≤ 5 MiB
        // Bounded source plus an external cancel flag the producer honours
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
import org.opensearch.analytics.spi.ExchangeSink;
                new ExchangeSinkContext.ChildInput(1, buildPassthroughSubstrait("input-1"))
        long deadline = System.currentTimeMillis() + 5_000;
        public synchronized void feed(VectorSchemaRoot batch) {
        logger.info("R3: feeds={} alloc before={} after={} drift={}", feeds.get(), allocBefore, allocAfter, drift);
            alloc,
                    feeds.incrementAndGet();
     * a silent early-out (closed flag check) — producers cannot learn that
        long elapsedMs = (System.nanoTime() - start) / 1_000_000L;
            "q-m1",
        }
                    sink.feed(makeConstantBatch(alloc, inputSchema, 1_000, 7L));
            "q-m3",  
 * <ul>
            "R5: baseline={} mid={} end={} allowed≤{} peakBaseline={} peakEnd={}",  
    private static byte[] buildMultiInputSumSubstrait(int childA, int childB) {
import org.opensearch.test.OpenSearchTestCase;
        assertTrue("runtime ptr non-zero", runtimePtr != 0);
        byte[] substrait = buildMultiInputSumSubstrait(0, 1);  
        CapturingSink downstream = new CapturingSink();
     */  
    /** Builds a single VectorSchemaRoot with {@code rows} entries, all = {@code value}. */  
            } catch (Exception ignore) {
        ExecutorService producers = Executors.newFixedThreadPool(2, r -> {  
 * Coordinator-side reduce-stage stress + lifecycle hygiene tests for  
            downstream
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);  
                PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
import org.apache.arrow.vector.types.pojo.Field;  
            runOneSink("q-r5-" + i, inputSchema, substrait, 5, 1_000);  
        assertEquals(  
            // Simulated source failure — analogous to "stub.next() throws on iter 10".  
            );
        long allowed = Math.max(absoluteCeiling, relativeCeiling);
        runOneSink("q-r5-warm", inputSchema, substrait, 5, 1_000);
        cancelled.set(true);
     * <p><b>Surprising finding 2 — cancel-during-parked-send leaks ~33 KB.</b>
            substrait,
    }  
        } finally {  
     * R2 — Stub source throws on the 10th batch. Sink must release session
        long expected = (long) batches * rowsPerBatch * valuePerRow;
        int rowsPerBatch = 10_000;
            drainDone.actionGet(30, TimeUnit.SECONDS);
                f.get(remaining, TimeUnit.MILLISECONDS);
            if (drift == 0) {
            t.setDaemon(true);
            queryId,
     * {@code DataFusionAnalyticsBackendPlugin}.
            allocAfter = alloc.getAllocatedMemory();  
                break;
    private NativeRuntimeHandle runtimeHandle;
        AtomicBoolean cancelled = new AtomicBoolean(false);
                            sink.close();  
            aDone.get(5, TimeUnit.SECONDS);
                        );
     *   <li>Producer feeds 1k-row int64 batches in a tight loop.</li>
     * distinct from {@code close()}. After {@code close()}, {@code feed()} is
        assertEquals("simulated source failure on 10th iteration", caught.getMessage());
            ExchangeSinkContext ctx = new ExchangeSinkContext(
        int rowsPerBatch = 2_000;
            if (i == n / 2) {
            alloc,  
                new ExchangeSinkContext.ChildInput(1, buildPassthroughSubstrait("input-1"))  
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
    }  
                if (cancelled.get()) {
     * fault path: when {@code Data.exportVectorSchemaRoot} runs and the
        assertFalse("downstream must NOT be closed by the reduce sink", downstream.closed);
     * maps to "the test producer throws on iteration 10". Sink.close() must  
        assertTrue("downstream rows must be ≥ 1; got " + downstream.totalRows, downstream.totalRows >= 1);  
        sink.close();
            0L,
            0L,  
        CapturingSink downstream = new CapturingSink();
                new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstrait("input-0")),
        Thread.sleep(50);
            sink.sinkForChild(0).close();
            }
     * release callbacks when the sender pointer can't be resolved (i.e. the
    /** Sums every BigInt in every fed batch. Same shape as {@code DatafusionReduceSinkTests.CapturingSink}. */
        long drift = allocatedAfter - allocatedBefore;  
            }
        int rowsPerBatch = 1_000;
     * the allocator's java-side accounting is the deterministic oracle here.
            substrait,
                        try {
import java.util.concurrent.TimeUnit;
    public void testReduceMultiInputCancelMidFeed() throws Exception {
        for (int i = 0; i < n; i++) {
                Thread.currentThread().interrupt();  
        byte[] substrait = buildMultiInputSumSubstrait(0, 1);
        }  
        long allocatedAfter = alloc.getAllocatedMemory();
            try {  
                        }
     * those refcounts may not all return. This deserves a Rust-side
                }  
import org.opensearch.action.support.PlainActionFuture;  
     * documented in {@link #testReduceCancelReleasesNative}'s javadoc. Repro
        long end = alloc.getAllocatedMemory();
        PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
 */  
        // If a drain were consuming concurrently, the parking race would never fire.  
}
            downstream
 *       cover end-to-end PPL → coordinator-reduce → response on a 2-node cluster  
            allowed = absoluteCeiling;  
                "q-m2-" + run,  
import java.util.concurrent.atomic.AtomicBoolean;
        }  
            downstream  
            List.of(
                totalRows += rows;  
     * RootAllocator. That delta is reproducible (same exact byte count
     * signature was {@code Memory leaked: (33202)} (33,586 peak) for a 1k-row
        }  
    /**
        long allocAfter;  
        long expected = (long) batchesPerChild * rowsPerBatch * 7L + (long) batchesPerChild * rowsPerBatch * 11L;  
        final int n = 50;
        long allocBefore = alloc.getAllocatedMemory();
        logger.info("M2: {} memtable sinks, alloc before={} after={} drift={}", sinkRuns, allocatedBefore, allocatedAfter, drift);
        producer.join(15_000);
     * follow-up (or a Java-side defensive {@code release()} on the FFI
import org.apache.calcite.plan.RelOptCluster;
     * An earlier draft of this test sent batches in a tight loop with no  
                    feeds.incrementAndGet();  
        long expected = (long) batches * rowsPerBatch * valuePerRow;
            // Both children EOF → drain sees end-of-input on both partitions and exits.
        try {
    // ── Fan-in / multi-input streaming sink ─────────────────────────────────────
        long baseline = alloc.getAllocatedMemory();  
        assertFalse("downstream must NOT be closed by the reduce sink", downstream.closed);
                final int idx = i;  
            allocBefore,  
            "q-f2",
    }
        CapturingSink downstream = new CapturingSink();
        long drift = allocAfter - allocBefore;
     *       the source buffers were never dropped — RootAllocator reports the leak in  
        Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));  
            Throwable any = failures.values().iterator().next();  
