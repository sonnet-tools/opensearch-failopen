                batch.close();
            CapturingSink downstream = new CapturingSink();  
                } catch (RuntimeException expectedOnceClosed) {
     * native input channel (capacity 4) fills and a dedicated feeder thread parks; then we call
    /**
            Thread.ofVirtual().start(() -> sink.reduce(drainDone));
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
        AggregateCall sumCall = AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(0), -1, bigintNullable, "total");  
 * this file be licensed under the Apache-2.0 license or a
                for (int i = 0; i < rows; i++) {  
import io.substrait.extension.SimpleExtension;
            assertTrue("teardown must run on the cancel-during-REDUCING path", sink.torndown.get());
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
import org.apache.calcite.rex.RexBuilder;
                "q-limit-reduce",  
     *  
    private static byte[] buildLimitSubstraitBytes(String inputId, int limit) {
                });
    public void testDoubleCloseIsIdempotent() throws Exception {
            ExchangeSinkContext ctx = new ExchangeSinkContext(
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
    /**
     * output at EOF, this assertion would time out, proving the reduce wasn't  
            );
            runtimeHandle.close();  
            byte[] substrait = buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID);
                alloc,
                reduceSubstrait,
     */
            try {
        public void close() {}  
     * Substrait plan, then asserts the downstream sink received a single-row batch
                sink.cancel();  
                // Pipelining: first output batch reaches downstream BEFORE we signal EOF.
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
    public void testCloseWhileReducingSignalsEofAndPreservesRows() throws Exception {
            assertEquals("SUM(1..9) should be 45", 45L, downstream.total);
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);  
        ClassLoader prev = t.getContextClassLoader();  
                feedExec.shutdownNow();
                drainDone.actionGet(10, TimeUnit.SECONDS);
     *
            assertTrue("downstream should receive at least one row, got " + downstream.totalRows, downstream.totalRows >= 1);
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
        RexBuilder rexBuilder = new RexBuilder(typeFactory);  
     *  
                batchCount++;  
            downstream.release.countDown();
import org.opensearch.action.support.PlainActionFuture;  
                        sink.feed(makeBatch(alloc, inputSchema, new long[] { (long) i }));  
            final int totalBatches = 8;  
                buildLimitSubstraitBytes(DatafusionReduceSink.INPUT_ID, limit),  
import org.opensearch.be.datafusion.nativelib.NativeBridge;  
            try {
    public void testReduceProducesOutputIncrementallyForPipelinedPlan() throws Exception {
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
    }
                reduceEntered.countDown();
import org.apache.arrow.vector.types.pojo.FieldType;  
    }
     * end-of-input. Closing the sink from outside while the drain is parked used to fire
            Thread feeder = new Thread(() -> {  
     *
     */
                9999L,
            runtimeHandle.close();
    private static byte[] buildPassthroughSubstraitBytes(String inputId) {
                Future<?> feedAll = feedExec.submit(() -> {  
        long total;
    }
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
            // Close WITHOUT sinkForChild(0).close() — this is the Stitcher-style early close.
            Thread.ofVirtual().start(() -> sink.reduce(reduceDone));
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
        assertNotEquals("sentinel must be distinct from a normal send (0)", 0L, NativeBridge.SENDER_SEND_RECEIVER_DROPPED);
            assertEquals("EOF-on-close must let the aggregate emit: SUM(1..6)", 21L, downstream.total);
     *  
                        sink.feed(makeBatch(alloc, inputSchema, new long[] { (long) i }));
        );  
        Schema schema = new Schema(List.of(new Field("message", FieldType.notNullable(new ArrowType.Int(64, true)), null)));
        } finally {  
            );
        }
     * different threads, or after {@code reduce()} already tore down) must not throw or  
 * The OpenSearch Contributors require contributions made to  
     * blocking aggregate), the first output batch must reach downstream BEFORE the
                assertTrue("first batch did not reach downstream within 5s", downstream.firstBatchLatch.await(5, TimeUnit.SECONDS));
            closer.join(10_000);  
     */  
 * <p>The sink is exercised at two levels:  
                "q-cancel-pre",  
                alloc,  
            BlockingCapturingSink downstream = new BlockingCapturingSink();
                batchCount++;
            byte[] substrait = buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID);
            assertEquals("LIMIT " + limit + " must yield exactly " + limit + " rows downstream", limit, downstream.totalRows);
            // > native input mpsc channel capacity (4). If drain isn't consuming
     * every LM query, one WARN per query). Worse, once cancellation actually worked, the cancel  
    public void testArrowSchemaIpcEncodesSchema() {
     * <p>The fix closes the input senders first (tryClose → EOF → aggregate emits → drain ends  
import java.util.concurrent.Executors;
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);  
     * {@code Fetch} over the passthrough scan (the way {@code head n} lowers: a
    }
            runtimeHandle.close();  
import org.opensearch.analytics.spi.ExchangeSink;
            byte[] substrait = buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID);
            ExchangeSinkContext ctx = new ExchangeSinkContext(  
            );
    }
     * ({@code ReceiverDropped}), the feeder releases the read lock, and {@code close()} proceeds.
            Thread.ofVirtual().start(() -> {  
            sink.close();
    }
            runtimeHandle.close();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
                int rows = batch.getRowCount();  
     * Regression: {@code close()} while a feeder is parked on a full input channel must NOT  
        }
 *       fixed input-id constant).</li>  
     * pins correctness of the LIMIT-over-reduce path in the meantime.
import java.util.concurrent.TimeoutException;
            ExchangeSinkContext ctx = new ExchangeSinkContext(  
    public void testReceiverDroppedSentinelIsPositiveAndDistinctFromSuccess() {
        RelNode fetch = org.apache.calcite.rel.logical.LogicalSort.create(
            // Generous bound to stay unflaky on slow CI hosts while still catching a 5s burn.
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);  
    public void testDrainTaskKeepsUpWithProducer() throws Exception {
     * drain consumes input concurrently — SUM is a blocking aggregate that buffers
     * runs exactly once regardless of how many paths call {@code closeImpl}.
                );
            assertTrue("teardown must run after reduce unwound", sink.torndown.get());
        } finally {  
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
        @Override
                downstream
            long closeStartNanos = System.nanoTime();
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();  
            sink.close();  
            );
     * aborted the aggregate BEFORE EOF and the result was 0 rows.
     * assert drain produces output mid-stream rather than only at close-time EOF.
            );
    }  
            // so close() observes state=REDUCING (the stalling branch).
                alloc,
                    for (int i = 0; i < 100; i++) {
import org.apache.arrow.vector.types.pojo.Schema;
                for (int i = 0; i < 20; i++) {
                totalRows += rows;
            feeder.setDaemon(true);  
            } finally {  
     * returns in far less than the old 5s timeout.  
            } finally {
        }  
            Thread.ofVirtual().start(() -> sink.reduce(drainDone));  
        root.allocateNew();
            sink.feed(makeBatch(alloc, inputSchema, new long[] { 1L, 2L, 3L }));
        assertNotNull("ipc bytes should be non-null", ipc);
            // Feeder thread: flood the input. The drain is stalled in downstream.feed (blocked on
     * Builds Substrait bytes for {@code SELECT x FROM "input-0" LIMIT n} — a streaming
    /**
            }  
     * deadlock.
        NativeBridge.initTokioRuntimeManager(2);
            try {  
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);  
                "q-close-deadlock",  
        NativeBridge.initTokioRuntimeManager(2);
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
        Path spillDir = createTempDir("datafusion-spill");
package org.opensearch.be.datafusion;
     */  
     * agreement on the value is enforced by the matching {@code SENDER_SEND_RECEIVER_DROPPED} in
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(agg);  
    /**
            reduceDone.actionGet(10, TimeUnit.SECONDS);
        Path spillDir = createTempDir("datafusion-spill");  
                sink.close();  
     * double-free native resources. The {@code torndown} CAS ensures the teardown body
            t.setContextClassLoader(prev);
     */
    /**
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));  
    public void testCancelAfterFirstBatchUnwindsDrain() throws Exception {
     * dropped the receiver while producers were still feeding) is signalled by {@code df_sender_send}
                4242L,
            }
                }
            }
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));  
     * stringly-typed error — {@code feedToSender} keys off this code. The sentinel must be positive
            LatchingCapturingSink downstream = new LatchingCapturingSink();
        @Override
        }  
 *
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
            // — that's expected; the feeder swallows it and exits.
            } catch (InterruptedException e) {
     * {@code ShardFragmentStageExecutionTests.testStreamStopsAndTaskSucceedsWhenConsumerDone}, and
            // Reduce-side AND child-side both passthrough — each input batch pipelines  
                downstream  
                "q-pipelined",
            // Give the drain time to actually park in stream_next waiting for more input,  
     * drops the input receiver as soon as it has emitted {@code n} rows — which is exactly the
            ExchangeSinkContext ctx = new ExchangeSinkContext(
            // without globally cancelling the query.
     * not finish, and every such close burned the full timeout (observed as a constant ~5s on
                alloc,
            } finally {  
            } finally {
     */
                0,
            sink.feed(makeBatch(alloc, inputSchema, new long[] { 4L, 5L, 6L }));
                    }  
     * Downstream that fires {@link #firstBatchLatch} on the first {@code feed()} —  
                substrait,
                try {
                substrait,
    private static final class LatchingCapturingSink implements ExchangeSink {
                0,
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
     * the partition sender's {@code NativeHandle}. But a feeder parked inside {@code sender.send}
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
import org.apache.calcite.rel.type.RelDataType;  
 * Unit tests for {@link DatafusionReduceSink}.
                7777L,
        final CountDownLatch firstBatchLatch = new CountDownLatch(1);  
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
                substrait,
            CapturingSink downstream = new CapturingSink();  
        try {
        }  
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
            assertTrue("torndown still true after second close", sink.torndown.get());  
            LatchingCapturingSink downstream = new LatchingCapturingSink();
            }
                downstream  
            );  
    public void testInputIdConstantMatchesDesign() {
    // ── Helpers ──────────────────────────────────────────────────────────────  
     * End-to-end feed + drain: feeds three Arrow batches (values 1..9) into a real
            sink.close();
            Thread.sleep(50);
            assertEquals("SUM(0..11) should be 66", 66L, downstream.total);
        NativeBridge.initTokioRuntimeManager(2);
     * sink is closed. {@code close()} signals input EOF — if drain only produced
        final CountDownLatch firstBatchLatch = new CountDownLatch(1);
            ExchangeSinkContext ctx = new ExchangeSinkContext(
     */
        public synchronized void feed(VectorSchemaRoot batch) {  
            // Close from REDUCING state: simulate reduce() already set state, then close
import org.opensearch.analytics.spi.ExchangeSinkContext;
import java.util.concurrent.CountDownLatch;
import org.apache.calcite.util.ImmutableBitSet;
                0L,  
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
import org.apache.calcite.rel.core.AggregateCall;
            // Second close must be a no-op (no exception, no double-free).
     * Values are extracted synchronously during {@code feed} so the test can assert on
                substrait,  
    }
     * {@link #total} after {@code close()} has released all Arrow buffers.  
     * total volume exceeds the bounded native input mpsc's capacity.
            assertTrue("drain should produce a first batch", downstream.firstBatchLatch.await(10, TimeUnit.SECONDS));
                    feedAll.get(10, TimeUnit.SECONDS);  
                sink.close();  
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        BigIntVector col = (BigIntVector) root.getVector(0);  
    public void testFeedDrainsSumToDownstream() throws Exception {
                sink.close();  // idempotent
     * Rust {@code send_blocking_reports_receiver_dropped} unit test.  
                0,  
    }  
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(scan);
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, alloc);
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
            assertTrue("third close (from REDUCING) is still idempotent", sink.torndown.get());  
            });  
        int totalRows;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            CapturingSink downstream = new CapturingSink();  
            Thread.sleep(300);  
            // Once close() tears the sink down, further feeds throw (closed sink / closed allocator)
            runtimeHandle.close();
     * <p>Setup mirrors that race: a blocking downstream sink stalls the reduce drain so the bounded
            assertTrue("close() should not burn the teardown timeout, took " + closeMillis + "ms", closeMillis < 4000);  
        } finally {
                } catch (TimeoutException te) {
            scan,
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
     * stall the reduce-output drain so the bounded native input channel fills and a feeder parks
            assertFalse("graceful termination must unpark the feeder", feeder.isAlive());  
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
                drainDone.actionGet(10, TimeUnit.SECONDS);
 *       sink, feed Arrow batches, close, and assert the downstream sink received the  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
     * the producer-side plan in {@link ExchangeSinkContext.ChildInput#producerPlanBytes()}.
     * (simulating the Stitcher's early close), and asserts the SUM still arrives and close()
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 7L, 8L, 9L }));
        volatile int totalRows;
                0,
 */  
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
        }  
                sink.sinkForChild(0).close(); // input EOF
            t.setContextClassLoader(DatafusionReduceSinkTests.class.getClassLoader());
            CapturingSink downstream = new CapturingSink();  
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(), null, List.of(sumCall));
        col.setValueCount(values.length);
            assertFalse("close() deadlocked against a feeder parked on the full channel", closer.isAlive());
            sink.state.set(DatafusionReduceSink.SinkState.REDUCING);
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
     */
import org.apache.calcite.rel.type.RelDataTypeFactory;
            assertEquals("no rows should be delivered (cancel before any feed)", 0, downstream.totalRows);  
        Thread t = Thread.currentThread();
                // Wait until the drain produced the first batch to downstream — proves  
            } finally {
        NativeBridge.initTokioRuntimeManager(2);
     */  
     */  
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
        assertTrue("ipc bytes should be non-empty", ipc.length > 0);
        } finally {  
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
    private static final class CapturingSink implements ExchangeSink {  
        Path spillDir = createTempDir("datafusion-spill");  
                downstream
     * rows the native plan has yet to emit.
 *       build Substrait bytes via {@link DataFusionFragmentConvertor}, construct the
        }
     * naturally). This test feeds rows, calls {@code close()} WITHOUT signalling per-child EOF
            sink.cancel();
        Path spillDir = createTempDir("datafusion-spill");
            }
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
            } finally {
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);
    }  
                sink.close();  
 *   <li>Lightweight assertions that don't touch the native library (encoding helper,
     * the receiver-drop sentinel contract by {@code testReceiverDroppedSentinelIsPositiveAndDistinctFromSuccess}.  
            closer.start();
    public void testCancelBeforeFirstBatchUnwindsDrain() throws Exception {
        final CountDownLatch release = new CountDownLatch(1);
     * The lowered output schema is the bare leaf row type (single BIGINT column {@code x})
            assertTrue("downstream should have at least 1 row from before cancel", downstream.totalRows >= 1);
            // receiver even while the feeder owns the sender read lock, releasing the feeder  
        }
     * {@code ffm.rs}; the structural "only a dropped receiver maps here" guarantee is covered by the
     * <p>NOTE: this does NOT yet assert reduce-input <em>early termination</em> (the sink reporting
            // First close tears down.  
                // DataFusion may omit the validity buffer when there are no nulls; read raw.
     * so Jackson polymorphic deserialization can resolve plugin-local Substrait classes.
     * {@code close()} and assert it returns well within a timeout.  
     */  
    }
            sink.close();
        return root;  
            assertTrue("downstream should have received the aggregate row", downstream.totalRows >= 1);  
     * shard-side reaction to {@code isConsumerDone()} is covered by
import org.apache.arrow.vector.types.pojo.ArrowType;
            assertTrue("teardown must run on first close", sink.torndown.get());
        NativeBridge.initTokioRuntimeManager(2);
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);  
            byte[] substrait = buildSumSubstraitBytes(DatafusionReduceSink.INPUT_ID);
/**  
     * <p>Old bug: {@code closeImpl} closed {@code session} first, which needed the write lock on  
     * all rows before emitting). This test proves drain *produces* output concurrently.
        for (int i = 0; i < values.length; i++) {
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
    /**
                    fail("feeds deadlocked — drain is not consuming the input mpsc concurrently");
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 4L, 5L, 6L }));  
            ExecutorService feedExec = Executors.newSingleThreadExecutor();
     * (so {@code checkResult} passes it through the success half of the return contract instead of
    }
            byte[] substrait = buildSumSubstraitBytes(DatafusionReduceSink.INPUT_ID);  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
        NativeBridge.initTokioRuntimeManager(2);  
            // concurrently the channel saturates and feed #5 deadlocks in send_blocking.
     * which is what the reduce sink registers as the input partition's declared schema.  
     *
        Path spillDir = createTempDir("datafusion-spill");  
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
            PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
        }
        } finally {
     * Reads each fed batch's single BIGINT column into {@link #total} + closes the batch.
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
                try {
            );
        public void close() {}  
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
            long closeMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - closeStartNanos);
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
                    total += col.getDataBuffer().getLong((long) i * BigIntVector.TYPE_WIDTH);
     * {@code isConsumerDone()} so feeders stop early). With the reduce session's  
        @Override
            // Ensure reduce() has progressed past its READY→REDUCING CAS before we close —
     * Downstream sink that blocks the drain thread inside {@code feed} until released. Used to
import org.opensearch.test.OpenSearchTestCase;
import org.apache.arrow.vector.VectorSchemaRoot;  
                sink.sinkForChild(0).close();  
     * used by {@link #testReduceProducesOutputIncrementallyForPipelinedPlan} to
                for (int i = 0; i < totalBatches; i++) {  
                4242L,
            feeder.join(10_000);
            try {
            feeder.start();
        volatile int batchCount;
            // runs concurrently with feeds (the drain asserts it's on a virtual thread).
     * limited output and tears down cleanly. Feeds far more rows than the limit through a real
    private static VectorSchemaRoot makeBatch(BufferAllocator alloc, Schema schema, long[] values) {  
            // Non-zero taskId so the Rust QUERY_REGISTRY actually wires cancellation.
            assertTrue("downstream should receive at least one row, got " + downstream.totalRows, downstream.totalRows >= 1);
public class DatafusionReduceSinkTests extends OpenSearchTestCase {
    }
     * reduce-input early-termination condition.  
     * limit that eagerly drains the whole input rather than letting the {@code LimitExec} drop the
        } finally {  
     */
            ExchangeSinkContext ctx = new ExchangeSinkContext(
    public void testCloseWhileFeederParkedOnFullChannelDoesNotDeadlock() throws Exception {
            PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));  
            ExchangeSinkContext ctx = new ExchangeSinkContext(  
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);  
     * Cancel-before-first-batch: drain is parked in stream_next waiting for input. Explicit  
            CapturingSink downstream = new CapturingSink();
                Thread.currentThread().interrupt();
     * {@code reduce()} is mid-drain (state=REDUCING) must (a) return promptly and (b) NOT lose
                // Signal input EOF (single-input → close the only per-child wrapper).
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),  
     * {@code FragmentConversionDriver} invokes for a coordinator-reduce stage at
                firstBatchLatch.countDown();
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 99L }));
            "sentinel must be positive so checkResult treats it as success, not an error pointer",
    /**  
            col.setSafe(i, values[i]);
    /**  
        NativeBridge.initTokioRuntimeManager(2);  
     * The benign "consumer finished first" case (a {@code LimitExec} satisfied its fetch and
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
                drainDone.actionGet(10, TimeUnit.SECONDS);
            assertFalse("downstream must NOT be closed by the reduce sink", downstream.closed);  
        @Override
 * compatible open source license.
            PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
                drainDone.actionGet(10, TimeUnit.SECONDS);  
                4243L,  
        NativeBridge.initTokioRuntimeManager(2);
                    downstream.firstBatchLatch.await(5, TimeUnit.SECONDS)
    public void testReduceWithLimitProducesLimitedOutput() throws Exception {
                7777L,
            }
            // Allow the drain to consume buffered batches and finish naturally, then close must
     * {@code cancel_query} and wait on {@code reduceDone} for a hard-coded 5s — but the input  
                batch.close();
    }  
                    "first output batch did not reach downstream before EOF signal — drain not pipelined",  
import org.apache.arrow.vector.BigIntVector;
            Thread.ofVirtual().start(() -> sink.reduce(drainDone));  
import org.apache.calcite.plan.hep.HepProgramBuilder;
        Path spillDir = createTempDir("datafusion-spill");  
                sink.close();
            assertEquals("all " + totalBatches + " feeds should have completed", totalBatches, sink.feedCount());  
                0,
    }  
                }
     * {@code LogicalSort} with empty collation + {@code fetch=n}). Unlike an aggregate, a  
        @Override
            // the feeder time to fill the channel and park.
                BigIntVector col = (BigIntVector) batch.getVector(0);
            Thread closer = new Thread(sink::close, "deadlock-closer");
        NativeBridge.initTokioRuntimeManager(2);  
    /**
import java.util.concurrent.TimeUnit;  
     *
    /**  
            assertEquals("each input batch had one row", totalBatches, downstream.totalRows);
            // Non-zero taskId so the cancel fallback path is wired if the test regresses.
     * native reduce; the {@code LimitExec} emits 3 rows and the drain ends.  
                release.await(30, TimeUnit.SECONDS);  
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);
import org.apache.calcite.sql.type.SqlTypeName;
     * {@code cancel()} surfaces a failure while preserving output delivered before the abort.  
            // arrives concurrently. Teardown already ran so torndown CAS fails — no-op.  
    private static byte[] buildSumSubstraitBytes(String inputId) {
import org.apache.arrow.memory.RootAllocator;
            // `release`), so once a batch reaches the output the bounded input channel backs up and
     * {@link DatafusionReduceSink} running a {@code SELECT SUM(x) FROM "input-0"}  
     * on a full channel — the precondition for the close-vs-parked-feeder deadlock regression.  
     * <p>Stronger than {@link #testDrainTaskKeepsUpWithProducer} (which only proves  
                downstream
 *
            } finally {  
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
     * returning the positive sentinel {@link NativeBridge#SENDER_SEND_RECEIVER_DROPPED} rather than a  
        public synchronized void feed(VectorSchemaRoot batch) {
    /**  
     * receiver after N rows — so the receiver-drop signal does not surface for this shape. The  
                    sink.feed(makeBatch(alloc, inputSchema, new long[] { (long) i }));
        );  
                downstream
            );
                alloc,  
import org.apache.arrow.memory.BufferAllocator;  
            runtimeHandle.close();
                assertTrue(
            Thread.ofVirtual().start(() -> sink.reduce(reduceDone));  
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);  
     * runtime.
                alloc,
        } finally {
            rexBuilder.makeExactLiteral(java.math.BigDecimal.valueOf(limit))
                downstream
            runtimeHandle.close();
            // return without using the timeout-and-cancel fallback.  
                alloc,
        Path spillDir = createTempDir("datafusion-spill");  
            // The old behavior burned the full 5s await; EOF-first should finish in millis.
                    }
            return DefaultExtensionCatalog.DEFAULT_COLLECTION;  
            // reduce failure; normal sink.close() is reserved for graceful EOF.
            PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
                0,
 * </ul>
import java.util.concurrent.Future;
        }  
     * which drops the native receiver; the parked {@code tx.send} then returns immediately
            expectThrows(RuntimeException.class, () -> reduceDone.actionGet(5, TimeUnit.SECONDS));  
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);  
     * Verifies that the drain task — submitted to the executor at sink construction —  
    }  
     * Loads the Substrait extension catalog with the test classloader as TCCL —  
     * senders were only closed AFTER that wait, so the aggregate could not emit, the drain could
 * <ul>
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
            // "sink closed before reduce" instead of the cancel-during-drain path we want.  
     * {@code target_partitions > 1}, the physical plan inserts a {@code RepartitionExec} below the
            byte[] reduceSubstrait = buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID);
    /**
import org.apache.calcite.rel.RelNode;  
        public synchronized void close() {  
    }  
     */  
     * (driving a full-channel {@code tx.send().await} via {@code block_on}) held the read lock —
import org.apache.calcite.plan.RelOptCluster;  
                0,
                List.of(new ExchangeSinkContext.ChildInput(0, childSubstrait)),  
                downstream  
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
                0L,  
        assertTrue(  
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 1L, 2L, 3L }));
            runtimeHandle.close();
                // we're past the empty-stream-park state and in the steady-pull state.
                "q-close-eof",  
                0,
        } finally {
            // straight through to a downstream feed, no aggregation buffering.
    /**
                }  
            try {
     * mirrors the swap performed by {@code DataFusionPlugin#loadSubstraitExtensions}
        }  
     * incremental.
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
                substrait,
        Path spillDir = createTempDir("datafusion-spill");  
     * {@code Fetch} is NOT a pipeline breaker: the native {@code LimitExec} stops pulling and
            // Drain is parked waiting for first batch. Explicit cancellation must surface as a  
            );  
        assertEquals("Single-input reduce uses the synthetic id 'input-0'", "input-0", DatafusionReduceSink.INPUT_ID);  
     * production {@link DataFusionFragmentConvertor} path — the same conversion  
                expectThrows(RuntimeException.class, () -> reduceDone.actionGet(5, TimeUnit.SECONDS));
    /**
     * Coordinator reduce running {@code SELECT x FROM "input-0" LIMIT 3} produces exactly the
import java.util.List;
        @Override  
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),  
 */  
    private static SimpleExtension.ExtensionCollection loadExtensions() {
 *       reduced result.</li>
import org.apache.calcite.rel.logical.LogicalAggregate;
            CapturingSink downstream = new CapturingSink();
 *   <li>A real end-to-end feed/drain round trip against a live native runtime:
                sink.sinkForChild(0).close();  
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
import java.nio.file.Path;  
            assertTrue(reduceEntered.await(5, TimeUnit.SECONDS));
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID))),
            ExchangeSinkContext ctx = new ExchangeSinkContext(
            final int totalBatches = 12; // intentionally > native input mpsc capacity
    }
    }
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);
                sink.close();
            try {
            ExchangeSinkContext ctx = new ExchangeSinkContext(
                }
            }
            PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
            PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
     * Builds Substrait bytes for {@code SELECT SUM(x) FROM "input-0"} using the
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(fetch);
     * Builds Substrait bytes for a plain {@code SELECT * FROM "input-0"} — used as  
import java.util.concurrent.ExecutorService;  
            Thread.ofVirtual().start(() -> sink.reduce(drainDone));  
import org.apache.calcite.plan.hep.HepPlanner;
            closed = true;
            // Wait until the drain has produced its first output batch (drain now stalled) and give  
            Thread.ofVirtual().start(() -> sink.reduce(drainDone));
        }
     * Regression test for the late-materialization ~5s stall: {@code close()} arriving while  
                buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID),  
            PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
 * SPDX-License-Identifier: Apache-2.0
            null,
                "q-cancel-post",
                sink.reduce(reduceDone);
            } finally {  
            PlainActionFuture<Void> drainDone = PlainActionFuture.newFuture();
            try {
        } finally {
     * Double-close is idempotent: calling {@code close()} multiple times (including from
     * Asserting the end-to-end early-stop here is blocked on the planner sort/limit work; this test
                "q-double-close",
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
                downstream  
            try {
                    sink.feed(makeBatch(alloc, inputSchema, new long[] { (long) i }));  
            assertEquals("all " + totalBatches + " batches must reach downstream", totalBatches, downstream.batchCount);
        volatile int batchCount;  
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);  
                substrait,  
import io.substrait.extension.DefaultExtensionCatalog;  
            }, "deadlock-feeder");
                totalRows += batch.getRowCount();
        Path spillDir = createTempDir("datafusion-spill");
        }
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
     */  
        // Empty collation + fetch=limit → pure streaming LIMIT (no global sort), lowered to Fetch.  
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
                    // sink/allocator closed underneath us — stop feeding.  
     */  
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
     * <p>Mirrors the Rust integration test {@code test_execute_sum_substrait}; the
     * graceful-EOF path. No leak.
                alloc,
            // otherwise close runs inline (READY→DONE) and reduce later fails with
     */
            CountDownLatch reduceEntered = new CountDownLatch(1);
        } finally {  
            closer.setDaemon(true);  
                0,  
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
        }
    private static final class BlockingCapturingSink implements ExchangeSink {
            // Mimic ReduceExecution body: spawn reduce on a VT so drain  
}
                0L,
            NativeBridge.SENDER_SEND_RECEIVER_DROPPED > 0
            byte[] substrait = buildSumSubstraitBytes(DatafusionReduceSink.INPUT_ID);
                "q-drain",
/*  
    /**  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
     * Cancel-after-first-batch: drain has consumed at least one row, then explicit
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);
        byte[] ipc = ArrowSchemaIpc.toBytes(schema);  
        boolean closed;  
import org.apache.arrow.vector.types.pojo.Field;
     * treating it as an error pointer) and distinct from a normal send ({@code 0}). The Rust↔Java  
     */  
                "q-1",
     * <p>The SUM plan is pipeline-breaking: the aggregate emits nothing until its input reaches
    /**
                firstBatchLatch.countDown();
     * so the write lock blocked forever. Fix: {@code closeImpl} closes {@code outStream} FIRST,  
            final int limit = 3;  
    /**
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
     * Pipelining regression net: with a passthrough reduce plan (1-in → 1-out, no  
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
            // Request graceful termination from another thread. It must close the partition
        }  
            sink.close();
            byte[] childSubstrait = buildPassthroughSubstraitBytes(DatafusionReduceSink.INPUT_ID);  
        assertTrue("runtime ptr non-zero", runtimePtr != 0);
     * {@code cancel()} must wake it and surface a failure; {@code close()} remains the separate
            }
     * runs concurrently with feeds, so producers complete every batch even when the
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
     * Java side proves the FFI ownership + drain wiring works against the same plan.
                }
                alloc,
    }  
     * containing 45.
                batch.close();
        public void feed(VectorSchemaRoot batch) {
            DatafusionReduceSink sink = new DatafusionReduceSink(ctx, runtimeHandle);  
            drainDone.actionGet(10, TimeUnit.SECONDS);  
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();  
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));  
            org.apache.calcite.rel.RelCollations.EMPTY,  
        root.setRowCount(values.length);
            runtimeHandle.close();
                    for (int i = 0; i < totalBatches; i++) {
            Thread.sleep(200);
            // this thread parks inside sink.feed -> sender.send (holding the sender read lock).  
                sink.sinkForChild(0).close();  
