            long closeStartNanos = System.nanoTime();
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
                    total += col.getDataBuffer().getLong((long) i * BigIntVector.TYPE_WIDTH);
                reduceEntered.countDown();
            assertFalse("close() deadlocked against a feeder parked on the full channel", closer.isAlive());
        } finally {
import org.apache.calcite.rel.RelNode;
     * the producer-side plan in {@link ExchangeSinkContext.ChildInput#producerPlanBytes()}.
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
        } finally {
     * {@code Fetch} is NOT a pipeline breaker: the native {@code LimitExec} stops pulling and
            sink.cancel();
        Path spillDir = createTempDir("datafusion-spill");
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        @Override
            );
            PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
                totalRows += batch.getRowCount();
            }, "deadlock-feeder");
        RelNode fetch = org.apache.calcite.rel.logical.LogicalSort.create(
    /**
            } finally {
    /**
import org.apache.arrow.memory.BufferAllocator;
                buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID),
            ExchangeSinkContext ctx = new ExchangeSinkContext(
            byte[] substrait = buildSumSubstraitBytes(DatafusionReduceSink.INPUT_ID);
     * {@code cancel()} surfaces a failure while preserving output delivered before the abort.
    public void testReduceProducesOutputIncrementallyForPipelinedPlan() throws Exception {
                "q-pipelined",
     * (driving a full-channel {@code tx.send().await} via {@code block_on}) held the read lock —
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 99L }));
            Thread.ofVirtual().start(() -> {
    }
            Thread.ofVirtual().start(() -> sink.reduce(reduceDone));
                0L,
            } catch (InterruptedException e) {
            assertEquals("each input batch had one row", totalBatches, downstream.totalRows);
    /**
                downstream
     * Loads the Substrait extension catalog with the test classloader as TCCL —
     * Reads each fed batch's single BIGINT column into {@link #total} + closes the batch.
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
                alloc,
                drainDone.actionGet(10, TimeUnit.SECONDS);
                drainDone.actionGet(10, TimeUnit.SECONDS);
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
 */
            // Reduce-side AND child-side both passthrough — each input batch pipelines
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
        } finally {
import java.util.concurrent.TimeoutException;
            assertTrue("teardown must run after reduce unwound", sink.torndown.get());
                substrait,
                    // sink/allocator closed underneath us — stop feeding.
     */
            }
import java.util.concurrent.TimeUnit;
     * agreement on the value is enforced by the matching {@code SENDER_SEND_RECEIVER_DROPPED} in
                "q-close-eof",
import org.apache.calcite.rel.type.RelDataType;
     * Builds Substrait bytes for a plain {@code SELECT * FROM "input-0"} — used as
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
                0,
                downstream
        }
            );
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
                sink.cancel();
            Thread.ofVirtual().start(() -> sink.reduce(drainDone));
            CapturingSink downstream = new CapturingSink();
                assertTrue("first batch did not reach downstream within 5s", downstream.firstBatchLatch.await(5, TimeUnit.SECONDS));
            PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
        volatile int batchCount;
            // Feeder thread: flood the input. The drain is stalled in downstream.feed (blocked on
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
     *
        volatile int totalRows;
     * output at EOF, this assertion would time out, proving the reduce wasn't
                downstream
     * which drops the native receiver; the parked {@code tx.send} then returns immediately
    private static final class LatchingCapturingSink implements ExchangeSink {
    public void testCloseWhileReducingSignalsEofAndPreservesRows() throws Exception {
            try {
     * (so {@code checkResult} passes it through the success half of the return contract instead of
            runtimeHandle.close();
    public void testReduceWithLimitProducesLimitedOutput() throws Exception {
        final CountDownLatch firstBatchLatch = new CountDownLatch(1);
            );
 * <ul>
            feeder.join(10_000);
     * {@link DatafusionReduceSink} running a {@code SELECT SUM(x) FROM "input-0"}
                    fail("feeds deadlocked — drain is not consuming the input mpsc concurrently");
            assertTrue("downstream should receive at least one row, got " + downstream.totalRows, downstream.totalRows >= 1);
        NativeBridge.initTokioRuntimeManager(2);
                downstream
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
    /**
     * returning the positive sentinel {@link NativeBridge#SENDER_SEND_RECEIVER_DROPPED} rather than a
        } finally {
    private static byte[] buildLimitSubstraitBytes(String inputId, int limit) {
                // DataFusion may omit the validity buffer when there are no nulls; read raw.
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
                alloc,
            // reduce failure; normal sink.close() is reserved for graceful EOF.
            ExchangeSinkContext ctx = new ExchangeSinkContext(
     * shard-side reaction to {@code isConsumerDone()} is covered by
            byte[] substrait = buildSumSubstraitBytes(DatafusionReduceSink.INPUT_ID);
        }
            runtimeHandle.close();
    }
        @Override
     * not finish, and every such close burned the full timeout (observed as a constant ~5s on
     *
     *
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            org.apache.calcite.rel.RelCollations.EMPTY,
     * drops the input receiver as soon as it has emitted {@code n} rows — which is exactly the
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);
                "q-cancel-post",
                0,
                } catch (TimeoutException te) {
import org.apache.calcite.rel.core.AggregateCall;
            Thread closer = new Thread(sink::close, "deadlock-closer");
            } finally {
        } finally {
                batchCount++;
    }
            closer.join(10_000);
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
        } finally {
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
     */
                totalRows += rows;
 *       fixed input-id constant).</li>
     * Rust {@code send_blocking_reports_receiver_dropped} unit test.
            // Close WITHOUT sinkForChild(0).close() — this is the Stitcher-style early close.
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
        }
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
    /**
            );
    /**
    }
                sink.sinkForChild(0).close();
            byte[] childSubstrait = buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID);
        );
            } finally {
    public void testCancelBeforeFirstBatchUnwindsDrain() throws Exception {
 * Unit tests for {@link DatafusionReduceSink}.
            // arrives concurrently. Teardown already ran so torndown CAS fails — no-op.
            ExchangeSinkContext ctx = new ExchangeSinkContext(
        NativeBridge.initTokioRuntimeManager(2);
     */
            final int totalBatches = 12; // intentionally > native input mpsc capacity
            } finally {
                4243L,
            }
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(), null, List.of(sumCall));
            // so close() observes state=REDUCING (the stalling branch).
     * The lowered output schema is the bare leaf row type (single BIGINT column {@code x})
import org.apache.calcite.plan.hep.HepProgramBuilder;
            "sentinel must be positive so checkResult treats it as success, not an error pointer",
                "q-drain",
        public void close() {}
        }
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
    /**
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
                firstBatchLatch.countDown();
     * runs exactly once regardless of how many paths call {@code closeImpl}.
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            // Close from REDUCING state: simulate reduce() already set state, then close
import org.opensearch.test.OpenSearchTestCase;
            Thread.ofVirtual().start(() -> sink.reduce(drainDone));
                0,
                    sink.feed(makeBatch(alloc, inputSchema, new long[] { (long) i }));
     * native input channel (capacity 4) fills and a dedicated feeder thread parks; then we call
    }
        } finally {
     * Downstream sink that blocks the drain thread inside {@code feed} until released. Used to
            assertTrue(reduceEntered.await(5, TimeUnit.SECONDS));
            assertFalse("downstream must NOT be closed by the reduce sink", downstream.closed);
     * <p>The fix closes the input senders first (tryClose → EOF → aggregate emits → drain ends
                }
        } finally {
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
                batch.close();
     */
import org.apache.arrow.vector.types.pojo.Schema;
            runtimeHandle.close();
                alloc,
            assertEquals("all " + totalBatches + " feeds should have completed", totalBatches, sink.feedCount());
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
     * Pipelining regression net: with a passthrough reduce plan (1-in → 1-out, no
            feeder.setDaemon(true);
    public void testFeedDrainsSumToDownstream() throws Exception {
     * deadlock.
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
            LatchingCapturingSink downstream = new LatchingCapturingSink();
 * </ul>
        Path spillDir = createTempDir("datafusion-spill");
            runtimeHandle.close();
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
     * {@code LogicalSort} with empty collation + {@code fetch=n}). Unlike an aggregate, a
    /**
            ExchangeSinkContext ctx = new ExchangeSinkContext(
}
     * {@code Fetch} over the passthrough scan (the way {@code head n} lowers: a
    }
                "q-cancel-pre",
     * Java side proves the FFI ownership + drain wiring works against the same plan.
                batch.close();
     * <p>Setup mirrors that race: a blocking downstream sink stalls the reduce drain so the bounded
            // return without using the timeout-and-cancel fallback.
     * Regression: {@code close()} while a feeder is parked on a full input channel must NOT
     * Cancel-before-first-batch: drain is parked in stream_next waiting for input. Explicit
import org.apache.arrow.vector.types.pojo.FieldType;
     */
     * stringly-typed error — {@code feedToSender} keys off this code. The sentinel must be positive
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
    }
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
            ExecutorService feedExec = Executors.newSingleThreadExecutor();
     * Builds Substrait bytes for {@code SELECT x FROM "input-0" LIMIT n} — a streaming
 *   <li>Lightweight assertions that don't touch the native library (encoding helper,
            }
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
                alloc,
        Path spillDir = createTempDir("datafusion-spill");
            Thread.sleep(300);
    public void testCancelAfterFirstBatchUnwindsDrain() throws Exception {
            CapturingSink downstream = new CapturingSink();
            // `release`), so once a batch reaches the output the bounded input channel backs up and
     */
            try {
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 7L, 8L, 9L }));
            } finally {
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
     * dropped the receiver while producers were still feeding) is signalled by {@code df_sender_send}
        }
            // Give the drain time to actually park in stream_next waiting for more input,
                    feedAll.get(10, TimeUnit.SECONDS);
            byte[] substrait = buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID);
            Thread.ofVirtual().start(() -> sink.reduce(drainDone));
     */
            assertEquals("SUM(0..11) should be 66", 66L, downstream.total);
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
        @Override
     *
            sink.close();
     */
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
     * drain consumes input concurrently — SUM is a blocking aggregate that buffers
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
                sink.close();
        assertTrue(
                buildLimitSubstraitBytes(DatafusionReduceSink.INPUT_ID, limit),
            // otherwise close runs inline (READY→DONE) and reduce later fails with
        }
        }
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 4L, 5L, 6L }));
                for (int i = 0; i < totalBatches; i++) {
                }
                0L,
            PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
        NativeBridge.initTokioRuntimeManager(2);
import java.util.concurrent.Future;
                    for (int i = 0; i < totalBatches; i++) {
        Thread t = Thread.currentThread();
     */
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
                substrait,
import java.util.concurrent.Executors;
            // Once close() tears the sink down, further feeds throw (closed sink / closed allocator)
     * Regression test for the late-materialization ~5s stall: {@code close()} arriving while
        long total;
     * {@code ffm.rs}; the structural "only a dropped receiver maps here" guarantee is covered by the
            // Non-zero taskId so the Rust QUERY_REGISTRY actually wires cancellation.
            sink.close();
    // ── Helpers ──────────────────────────────────────────────────────────────
            reduceDone.actionGet(10, TimeUnit.SECONDS);
        } finally {
                sink.close();
                downstream
                sink.sinkForChild(0).close();
            assertTrue("downstream should have at least 1 row from before cancel", downstream.totalRows >= 1);
            Thread.ofVirtual().start(() -> sink.reduce(drainDone));
                        sink.feed(makeBatch(alloc, inputSchema, new long[] { (long) i }));
     * treating it as an error pointer) and distinct from a normal send ({@code 0}). The Rust↔Java
 * this file be licensed under the Apache-2.0 license or a
import org.apache.arrow.vector.BigIntVector;
import org.apache.calcite.rex.RexBuilder;
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
     * {@code cancel()} must wake it and surface a failure; {@code close()} remains the separate
            // Ensure reduce() has progressed past its READY→REDUCING CAS before we close —
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.calcite.rel.logical.LogicalAggregate;
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 1L, 2L, 3L }));
        Schema schema = new Schema(List.of(new Field("message", FieldType.notNullable(new ArrowType.Int(64, true)), null)));
                sink.reduce(reduceDone);
        }
                Thread.currentThread().interrupt();
                "q-double-close",
                BigIntVector col = (BigIntVector) batch.getVector(0);
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
     *
     * double-free native resources. The {@code torndown} CAS ensures the teardown body
            // > native input mpsc channel capacity (4). If drain isn't consuming
                sink.close();
     * so the write lock blocked forever. Fix: {@code closeImpl} closes {@code outStream} FIRST,
                sink.close();
    /**
 *   <li>A real end-to-end feed/drain round trip against a live native runtime:
        } finally {
package org.opensearch.be.datafusion;
     * pins correctness of the LIMIT-over-reduce path in the meantime.
                    }
        public synchronized void feed(VectorSchemaRoot batch) {
     * {@code close()} and assert it returns well within a timeout.
            sink.state.set(DatafusionReduceSink.SinkState.REDUCING);
                }
        col.setValueCount(values.length);
                firstBatchLatch.countDown();
                downstream
     * mirrors the swap performed by {@code DataFusionPlugin#loadSubstraitExtensions}
        try {
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);
import java.util.concurrent.CountDownLatch;
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
     * rows the native plan has yet to emit.
     * <p>Old bug: {@code closeImpl} closed {@code session} first, which needed the write lock on
     * {@code cancel_query} and wait on {@code reduceDone} for a hard-coded 5s — but the input
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
    }
                0,
            scan,
            expectThrows(RuntimeException.class, () -> reduceDone.actionGet(5, TimeUnit.SECONDS));
     * naturally). This test feeds rows, calls {@code close()} WITHOUT signalling per-child EOF
                reduceSubstrait,
     * incremental.
        @Override
     * production {@link DataFusionFragmentConvertor} path — the same conversion
            // this thread parks inside sink.feed -> sender.send (holding the sender read lock).
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
                try {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        }
                alloc,
     * total volume exceeds the bounded native input mpsc's capacity.
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
    }
     * stall the reduce-output drain so the bounded native input channel fills and a feeder parks
import org.apache.arrow.vector.types.pojo.ArrowType;
        Path spillDir = createTempDir("datafusion-spill");
import org.apache.calcite.util.ImmutableBitSet;
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(agg);
            // Request graceful termination from another thread. It must close the partition
import org.apache.calcite.plan.RelOptCluster;
            // straight through to a downstream feed, no aggregation buffering.
            Thread.sleep(50);
                // Wait until the drain produced the first batch to downstream — proves
        public synchronized void feed(VectorSchemaRoot batch) {
        );
     * End-to-end feed + drain: feeds three Arrow batches (values 1..9) into a real
import io.substrait.extension.DefaultExtensionCatalog;
            }
            }
     * Cancel-after-first-batch: drain has consumed at least one row, then explicit
            closed = true;
                expectThrows(RuntimeException.class, () -> reduceDone.actionGet(5, TimeUnit.SECONDS));
            // receiver even while the feeder owns the sender read lock, releasing the feeder
                for (int i = 0; i < rows; i++) {
     * containing 45.
            assertTrue("downstream should receive at least one row, got " + downstream.totalRows, downstream.totalRows >= 1);
            runtimeHandle.close();
    private static SimpleExtension.ExtensionCollection loadExtensions() {
        BigIntVector col = (BigIntVector) root.getVector(0);
            );
 * The OpenSearch Contributors require contributions made to
     * the partition sender's {@code NativeHandle}. But a feeder parked inside {@code sender.send}
            try {
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
        }
                batch.close();
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
                "q-limit-reduce",
                "q-close-deadlock",
/**
            CapturingSink downstream = new CapturingSink();
            PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
                try {
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
            drainDone.actionGet(10, TimeUnit.SECONDS);
    public void testCloseWhileFeederParkedOnFullChannelDoesNotDeadlock() throws Exception {
import org.apache.arrow.vector.types.pojo.Field;
            BlockingCapturingSink downstream = new BlockingCapturingSink();
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
     * every LM query, one WARN per query). Worse, once cancellation actually worked, the cancel
     */
            runtimeHandle.close();
                4242L,
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
     * Downstream that fires {@link #firstBatchLatch} on the first {@code feed()} —
                0,
                "q-1",
            return DefaultExtensionCatalog.DEFAULT_COLLECTION;
            col.setSafe(i, values[i]);
            CapturingSink downstream = new CapturingSink();
                substrait,
        Path spillDir = createTempDir("datafusion-spill");
                drainDone.actionGet(10, TimeUnit.SECONDS);
            assertEquals("no rows should be delivered (cancel before any feed)", 0, downstream.totalRows);
     */
     * {@code FragmentConversionDriver} invokes for a coordinator-reduce stage at
        volatile int batchCount;
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
        @Override
     * Values are extracted synchronously during {@code feed} so the test can assert on
     * {@code isConsumerDone()} so feeders stop early). With the reduce session's
    }
                for (int i = 0; i < 20; i++) {
 *       build Substrait bytes via {@link DataFusionFragmentConvertor}, construct the
                sink.close();
    }
     * The benign "consumer finished first" case (a {@code LimitExec} satisfied its fetch and
            runtimeHandle.close();
            PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
     * assert drain produces output mid-stream rather than only at close-time EOF.
                    for (int i = 0; i < 100; i++) {
            // runs concurrently with feeds (the drain asserts it's on a virtual thread).
            try {
     * receiver after N rows — so the receiver-drop signal does not surface for this shape. The
            } finally {
        }
import org.opensearch.action.support.PlainActionFuture;
        }
     * {@code target_partitions > 1}, the physical plan inserts a {@code RepartitionExec} below the
        root.setRowCount(values.length);
     * different threads, or after {@code reduce()} already tore down) must not throw or
            assertTrue("downstream should have received the aggregate row", downstream.totalRows >= 1);
     * Substrait plan, then asserts the downstream sink received a single-row batch
        public void close() {}
     * senders were only closed AFTER that wait, so the aggregate could not emit, the drain could
                feedExec.shutdownNow();
     * <p>Stronger than {@link #testDrainTaskKeepsUpWithProducer} (which only proves
            assertTrue("teardown must run on the cancel-during-REDUCING path", sink.torndown.get());
            } finally {
     * runtime.
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
import org.apache.calcite.sql.type.SqlTypeName;
     * returns in far less than the old 5s timeout.
            }
    }
            sink.close();
                sink.close();  // idempotent
        Path spillDir = createTempDir("datafusion-spill");
                release.await(30, TimeUnit.SECONDS);
import org.opensearch.analytics.spi.ExchangeSink;
            PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
            try {
                Future<?> feedAll = feedExec.submit(() -> {
            );
            // — that's expected; the feeder swallows it and exits.
            // Second close must be a no-op (no exception, no double-free).
 * <p>The sink is exercised at two levels:
        NativeBridge.initTokioRuntimeManager(2);
            sink.feed(makeBatch(alloc, inputSchema, new long[] { 4L, 5L, 6L }));
        return root;
        ClassLoader prev = t.getContextClassLoader();
            // "sink closed before reduce" instead of the cancel-during-drain path we want.
     * limit that eagerly drains the whole input rather than letting the {@code LimitExec} drop the
    public void testDrainTaskKeepsUpWithProducer() throws Exception {
            assertTrue("torndown still true after second close", sink.torndown.get());
    /**
            null,
            // without globally cancelling the query.
            sink.feed(makeBatch(alloc, inputSchema, new long[] { 1L, 2L, 3L }));
            closer.start();
import org.apache.calcite.plan.hep.HepPlanner;
                );
            ExchangeSinkContext ctx = new ExchangeSinkContext(
            CountDownLatch reduceEntered = new CountDownLatch(1);
                alloc,
import java.util.List;
            // Drain is parked waiting for first batch. Explicit cancellation must surface as a
                substrait,
        public void feed(VectorSchemaRoot batch) {
            // the feeder time to fill the channel and park.
            feeder.start();
                0,
            final int totalBatches = 8;
                0,
    /**
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
    public void testReceiverDroppedSentinelIsPositiveAndDistinctFromSuccess() {
        AggregateCall sumCall = AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(0), -1, bigintNullable, "total");
            rexBuilder.makeExactLiteral(java.math.BigDecimal.valueOf(limit))
                downstream
                // we're past the empty-stream-park state and in the steady-pull state.
            assertTrue("drain should produce a first batch", downstream.firstBatchLatch.await(10, TimeUnit.SECONDS));
                substrait,
     * <p>Mirrors the Rust integration test {@code test_execute_sum_substrait}; the
     * <p>NOTE: this does NOT yet assert reduce-input <em>early termination</em> (the sink reporting
    }
                int rows = batch.getRowCount();
                alloc,
        int totalRows;
    private static final class BlockingCapturingSink implements ExchangeSink {
                }
        }
    /**
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
            PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
     * on a full channel — the precondition for the close-vs-parked-feeder deadlock regression.
     */
     * sink is closed. {@code close()} signals input EOF — if drain only produced
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
        Path spillDir = createTempDir("datafusion-spill");
                7777L,
        assertTrue("runtime ptr non-zero", runtimePtr != 0);
     * limited output and tears down cleanly. Feeds far more rows than the limit through a real
     * native reduce; the {@code LimitExec} emits 3 rows and the drain ends.
    /**
            assertEquals("all " + totalBatches + " batches must reach downstream", totalBatches, downstream.batchCount);
                } catch (RuntimeException expectedOnceClosed) {
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
    private static byte[] buildSumSubstraitBytes(String inputId) {
                7777L,
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
    /**
            }
import java.nio.file.Path;
public class DatafusionReduceSinkTests extends OpenSearchTestCase {
     * end-of-input. Closing the sink from outside while the drain is parked used to fire
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
     */
            ExchangeSinkContext ctx = new ExchangeSinkContext(
     */
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
            try {
                substrait,
import org.apache.arrow.memory.RootAllocator;
            // First close tears down.
    /**
        }
    public void testArrowSchemaIpcEncodesSchema() {
        NativeBridge.initTokioRuntimeManager(2);
            } finally {
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
        assertEquals("Single-input reduce uses the synthetic id 'input-0'", "input-0", DatafusionReduceSink.INPUT_ID);
            assertTrue("close() should not burn the teardown timeout, took " + closeMillis + "ms", closeMillis < 4000);
     *
 *
    public void testInputIdConstantMatchesDesign() {
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
        Path spillDir = createTempDir("datafusion-spill");
     * which is what the reduce sink registers as the input partition's declared schema.
import io.substrait.extension.SimpleExtension;
            NativeBridge.SENDER_SEND_RECEIVER_DROPPED > 0
     * Asserting the end-to-end early-stop here is blocked on the planner sort/limit work; this test
        }
 *       sink, feed Arrow batches, close, and assert the downstream sink received the
                        sink.feed(makeBatch(alloc, inputSchema, new long[] { (long) i }));
import org.opensearch.be.datafusion.nativelib.NativeBridge;
    }
    /**
                sink.sinkForChild(0).close(); // input EOF
            sink.close();
    public void testDoubleCloseIsIdempotent() throws Exception {
            assertTrue("teardown must run on first close", sink.torndown.get());
            closer.setDaemon(true);
                0L,
            // Generous bound to stay unflaky on slow CI hosts while still catching a 5s burn.
     */
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
     * the receiver-drop sentinel contract by {@code testReceiverDroppedSentinelIsPositiveAndDistinctFromSuccess}.
            assertTrue("third close (from REDUCING) is still idempotent", sink.torndown.get());
            // Wait until the drain has produced its first output batch (drain now stalled) and give
                List.of(new ExchangeSinkContext.ChildInput(0, childSubstrait)),
            }
        byte[] ipc = ArrowSchemaIpc.toBytes(schema);
/*
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
     */
     * <p>The SUM plan is pipeline-breaking: the aggregate emits nothing until its input reaches
     * aborted the aggregate BEFORE EOF and the result was 0 rows.
            runtimeHandle.close();
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
import java.util.concurrent.ExecutorService;
    }
        assertTrue("ipc bytes should be non-empty", ipc.length > 0);
                    sink.feed(makeBatch(alloc, inputSchema, new long[] { (long) i }));
            Thread feeder = new Thread(() -> {
                assertTrue(
import org.opensearch.analytics.spi.ExchangeSinkContext;
            long closeMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - closeStartNanos);
                downstream
            assertEquals("EOF-on-close must let the aggregate emit: SUM(1..6)", 21L, downstream.total);
            CapturingSink downstream = new CapturingSink();
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
                batchCount++;
    }
    }
        for (int i = 0; i < values.length; i++) {
        @Override
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
            assertEquals("LIMIT " + limit + " must yield exactly " + limit + " rows downstream", limit, downstream.totalRows);
            byte[] substrait = buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID);
            LatchingCapturingSink downstream = new LatchingCapturingSink();
    /**
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
     * Verifies that the drain task — submitted to the executor at sink construction —
        NativeBridge.initTokioRuntimeManager(2);
            ExchangeSinkContext ctx = new ExchangeSinkContext(
     * Double-close is idempotent: calling {@code close()} multiple times (including from
     * {@code ShardFragmentStageExecutionTests.testStreamStopsAndTaskSucceedsWhenConsumerDone}, and
            ExchangeSinkContext ctx = new ExchangeSinkContext(
     * reduce-input early-termination condition.
        NativeBridge.initTokioRuntimeManager(2);
     * graceful-EOF path. No leak.
            // concurrently the channel saturates and feed #5 deadlocks in send_blocking.
     * Builds Substrait bytes for {@code SELECT SUM(x) FROM "input-0"} using the
 * compatible open source license.
        boolean closed;
                downstream
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
     * {@link #total} after {@code close()} has released all Arrow buffers.
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
            CapturingSink downstream = new CapturingSink();
            byte[] substrait = buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID);
                drainDone.actionGet(10, TimeUnit.SECONDS);
 *
                    }
        final CountDownLatch firstBatchLatch = new CountDownLatch(1);
            // Mimic ReduceExecution body: spawn reduce on a VT so drain
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
    }
        root.allocateNew();
                alloc,
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
     * ({@code ReceiverDropped}), the feeder releases the read lock, and {@code close()} proceeds.
        assertNotNull("ipc bytes should be non-null", ipc);
    }
    private static byte[] buildPassthroughSubstraitBytes(String inputId) {
     */
    private static VectorSchemaRoot makeBatch(BufferAllocator alloc, Schema schema, long[] values) {
            t.setContextClassLoader(prev);
            );
    }
     * runs concurrently with feeds, so producers complete every batch even when the
                }
                0,
        NativeBridge.initTokioRuntimeManager(2);
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
            ExchangeSinkContext ctx = new ExchangeSinkContext(
            assertFalse("graceful termination must unpark the feeder", feeder.isAlive());
            runtimeHandle.close();
                9999L,
        Path spillDir = createTempDir("datafusion-spill");
     * {@code reduce()} is mid-drain (state=REDUCING) must (a) return promptly and (b) NOT lose
            byte[] reduceSubstrait = buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID);
            });
            try {
        public synchronized void close() {
                sink.sinkForChild(0).close();
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
     * blocking aggregate), the first output batch must reach downstream BEFORE the
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(fetch);
                    downstream.firstBatchLatch.await(5, TimeUnit.SECONDS)
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
        NativeBridge.initTokioRuntimeManager(2);
                    "first output batch did not reach downstream before EOF signal — drain not pipelined",
                // Signal input EOF (single-input → close the only per-child wrapper).
    private static final class CapturingSink implements ExchangeSink {
        // Empty collation + fetch=limit → pure streaming LIMIT (no global sort), lowered to Fetch.
            Thread.ofVirtual().start(() -> sink.reduce(reduceDone));
                // Pipelining: first output batch reaches downstream BEFORE we signal EOF.
 */
            // Allow the drain to consume buffered batches and finish naturally, then close must
 * SPDX-License-Identifier: Apache-2.0
     * so Jackson polymorphic deserialization can resolve plugin-local Substrait classes.
            byte[] substrait = buildSumSubstraitBytes(DatafusionReduceSink.INPUT_ID);
            sink.close();
            t.setContextClassLoader(DatafusionReduceSinkTests.class.getClassLoader());
                4242L,
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);
            Thread.ofVirtual().start(() -> sink.reduce(drainDone));
                0,
            Thread.sleep(200);
     * used by {@link #testReduceProducesOutputIncrementallyForPipelinedPlan} to
            try {
            );
        assertNotEquals("sentinel must be distinct from a normal send (0)", 0L, NativeBridge.SENDER_SEND_RECEIVER_DROPPED);
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(scan);
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
            // Non-zero taskId so the cancel fallback path is wired if the test regresses.
                alloc,
                });
import org.apache.calcite.rel.type.RelDataTypeFactory;
            downstream.release.countDown();
        final CountDownLatch release = new CountDownLatch(1);
     * (simulating the Stitcher's early close), and asserts the SUM still arrives and close()
            // The old behavior burned the full 5s await; EOF-first should finish in millis.
 *       reduced result.</li>
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, alloc);
     * Coordinator reduce running {@code SELECT x FROM "input-0" LIMIT 3} produces exactly the
     * all rows before emitting). This test proves drain *produces* output concurrently.
            assertEquals("SUM(1..9) should be 45", 45L, downstream.total);
            );
     *
            final int limit = 3;
