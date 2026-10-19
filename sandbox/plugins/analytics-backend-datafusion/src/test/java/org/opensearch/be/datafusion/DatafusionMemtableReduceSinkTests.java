import org.apache.arrow.vector.types.pojo.Schema;
                left.close();
            List.of(),
        public synchronized void close() {
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
                ExchangeSink left = sink.sinkForChild(0);
            byte[] substrait = buildSumSubstraitBytes(DatafusionMemtableReduceSink.INPUT_ID);
import org.apache.calcite.plan.RelOptCluster;  
            DatafusionMemtableReduceSink sink = new DatafusionMemtableReduceSink(ctx, runtimeHandle);
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
                    ReduceSizeExceededException ex = expectThrows(ReduceSizeExceededException.class, () -> {
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(join);
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
        root.setRowCount(values.length);  
                    assertTrue(
    public void testFeedDrainsSumToDownstream() throws Exception {
    public void testInputIdConstantMatchesDesign() {  
                sink.close();
            runtimeHandle.close();
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(scan);
        @Override  
                List.of(  
        @Override
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionMemtableReduceSink.INPUT_ID))),
                "q-1",  
        // Equi-join condition: left.x ($0) == right.x ($1 in the joined row).
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionMemtableReduceSink.INPUT_ID))),
import org.opensearch.test.OpenSearchTestCase;
                        for (int n = 0; n < 16; n++) {
 * batches, same downstream assertion — exercises the buffered-batch handoff path instead of the  
                left.feed(makeBatch(alloc, inputSchema, new long[] { 1L, 2L, 3L }));  
            // refused. Exercises the real headroom check (getAllocatedMemory vs getLimit), not just
                totalRows += rows;
                sink.close();
        } finally {
        boolean closed;  
        }
                sink.reduce(reduceDone);
                reduceDone.actionGet(10, TimeUnit.SECONDS);  
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);  
import org.apache.calcite.rel.core.AggregateCall;
            try {
    }
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(), null, List.of(sumCall));  
            org.apache.calcite.rel.core.JoinRelType.INNER
            } finally {
     * end-to-end against a live native runtime — the streaming sink deadlocks on this shape  
        Path spillDir = createTempDir("datafusion-spill");  
                int rows = batch.getRowCount();  
     * (build-side back-pressure), which is why join-reduces route to the buffered sink.
            } finally {
import org.opensearch.analytics.spi.ExchangeSinkContext;
     * {@link ReduceSizeExceededException} <em>before</em> attempting the allocation — never let
            // the per-batch margin.  
            CapturingSink downstream = new CapturingSink();  
import org.apache.calcite.sql.type.SqlTypeName;
    /**
                    0,
        for (int i = 0; i < values.length; i++) {
        NativeBridge.initTokioRuntimeManager(2);
            byte[] substrait = buildSumSubstraitBytes(DatafusionMemtableReduceSink.INPUT_ID);
                    List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionMemtableReduceSink.INPUT_ID))),  
            }
            try {  
        Path spillDir = createTempDir("datafusion-spill");
    }  
    public void testTwoInputJoinDrainsToDownstream() throws Exception {  
            }
            rexBuilder.makeInputRef(bigintNullable, 1)  
                    substrait,
        }
        RelNode left = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), leftId, rowType);
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, alloc);
        NativeBridge.initTokioRuntimeManager(2);
import org.opensearch.analytics.spi.ExchangeSink;
            }
        );  
/**
                    }
    private static byte[] buildJoinSubstraitBytes(String leftId, String rightId) {
import org.apache.calcite.util.ImmutableBitSet;
            // allocator's live usage past the budget (accounting for the FFI export margin) is
        ClassLoader prev = t.getContextClassLoader();
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
import io.substrait.extension.DefaultExtensionCatalog;
        public synchronized void feed(VectorSchemaRoot batch) {
            CountingSink downstream = new CountingSink();
        public synchronized void feed(VectorSchemaRoot batch) {  
                0,  
     * {@code Join(input-0, input-2) ON input-0.x = input-2.x}. Feeds both inputs via  
                totalRows += batch.getRowCount();  
            }  
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();  
                // Build side (input-0): {1,2,3}. Probe side (input-2): {2,3,4}. Inner join on x → {2,3}.  
import java.util.concurrent.TimeUnit;
            col.setSafe(i, values[i]);  
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);  
import org.apache.calcite.plan.hep.HepProgramBuilder;
                ExchangeSink right = sink.sinkForChild(2);
                }
     * With an unbounded query allocator ({@code Long.MAX_VALUE} limit — the operator opted out
                    // was thrown rather than a raw Arrow OutOfMemoryException. Just check the message.
package org.opensearch.be.datafusion;
import org.apache.arrow.memory.BufferAllocator;  
                    }  
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
                joinSubstrait,
            }  
        }
                alloc,
                        }
     * {@link DatafusionMemtableReduceSink#sinkForChild(int)}, closes each, runs {@code reduce},
        assertTrue("runtime ptr non-zero", runtimePtr != 0);
            ExchangeSinkContext ctx = new ExchangeSinkContext(
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));  
    private static SimpleExtension.ExtensionCollection loadExtensions() {
}  
            );
    private static final class CountingSink implements ExchangeSink {
     * Builds {@code Join(StageInputScan(leftId), StageInputScan(rightId)) ON left.x = right.x}
     * accumulated buffer size would exceed the per-query Arrow budget (the allocator's limit,  
import org.apache.arrow.vector.types.pojo.FieldType;  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        @Override
        assertTrue("runtime ptr non-zero", runtimePtr != 0);
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
                        // guard must trip (clean exception) rather than the allocator's hard limit (OOM).
        int totalRows;  
                ExchangeSinkContext ctx = new ExchangeSinkContext(  
                    );
                PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();  
        }
                // Memtable runs the reduce work in reduce() now; close() is cleanup-only.
            try {
        }
                0,
            runtimeHandle.close();  
    }
 * The OpenSearch Contributors require contributions made to  
     */
            t.setContextClassLoader(DatafusionMemtableReduceSinkTests.class.getClassLoader());  
                downstream  
                    total += col.getDataBuffer().getLong((long) i * BigIntVector.TYPE_WIDTH);  
                    long[] small = new long[8 * 1024]; // ~64 KiB of int64 data  
        boolean closed;
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
            ExchangeSinkContext ctx = new ExchangeSinkContext(
            assertTrue("downstream should receive at least one row, got " + downstream.totalRows, downstream.totalRows >= 1);
        int totalRows;
                try {
        return root;
            byte[] joinSubstrait = buildJoinSubstraitBytes("input-0", "input-2");  
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());  
        Thread t = Thread.currentThread();  
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();  
     * of {@code analytics.coordinator.buffer_limit}), the size guard is inert: feeding still  
        BigIntVector col = (BigIntVector) root.getVector(0);
                    sink.close();
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 4L, 5L, 6L }));  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            closed = true;
     * Bare {@code SELECT * FROM "input-0"} substrait — used as the producer-side plan in  
    private static VectorSchemaRoot makeBatch(BufferAllocator alloc, Schema schema, long[] values) {
                right.feed(makeBatch(alloc, inputSchema, new long[] { 2L, 3L, 4L }));
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 10L, 20L, 30L }));
import org.apache.calcite.rel.type.RelDataType;  
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
import org.apache.calcite.rel.type.RelDataTypeFactory;
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);  
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
import org.apache.calcite.rex.RexBuilder;
            left,  
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {  
        assertTrue("runtime ptr non-zero", runtimePtr != 0);  
                    long[] big = new long[64 * 1024]; // ~512 KiB each
            DatafusionMemtableReduceSink sink = new DatafusionMemtableReduceSink(ctx, runtimeHandle);
/*  
            CapturingSink downstream = new CapturingSink();
        try {
                    // expectThrows already proves a ReduceSizeExceededException (the proactive guard)  
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);
                0L,
            assertFalse("downstream must NOT be closed by the reduce sink", downstream.closed);
     * second batch trips the guard, and asserts the allocator is fully released afterward.
    public void testUnboundedAllocatorDisablesGuard() throws Exception {
                assertEquals("retained buffers released on close", 0, budgeted.getAllocatedMemory());  
    }
                CapturingSink downstream = new CapturingSink();
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
                } finally {  
        }
                    });
            runtimeHandle.close();
        Path spillDir = createTempDir("datafusion-spill");  
     * ({@code supplier ⋈ revenue0}): a buffered multi-input reduce running
    /**
        Path spillDir = createTempDir("datafusion-spill");
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);  
        }  
        public synchronized void close() {
                alloc,  
            assertFalse("downstream must NOT be closed by the reduce sink", downstream.closed);
            } finally {  
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(agg);
                sink.reduce(reduceDone);  
                0L,
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
 * streaming sender path.
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
import org.apache.calcite.plan.hep.HepPlanner;
        assertEquals("Single-input reduce uses the synthetic id 'input-0'", "input-0", DatafusionMemtableReduceSink.INPUT_ID);
        long total;
        } finally {
            assertEquals("inner join {1,2,3} ⋈ {2,3,4} on x should yield 2 rows", 2, downstream.totalRows);  
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);  
        } finally {
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
                    budgeted,
     * is the leaf row type ({@code x: BIGINT}), which the sink registers as the input
            byte[] substrait = buildSumSubstraitBytes(DatafusionMemtableReduceSink.INPUT_ID);
import org.apache.arrow.vector.types.pojo.Field;
     * set by {@code analytics.coordinator.buffer_limit}), the sink must FAIL FAST with
     * and asserts the join produced the matching rows. Exercises the multi-input MemTable path
                PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
            right,
     * a raw Arrow {@code OutOfMemoryException} fire (which leaks the in-flight buffers and gets  
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
                    assertTrue("first batch retained", budgeted.getAllocatedMemory() > 0);
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);  
                0L,  
                reduceDone.actionGet(10, TimeUnit.SECONDS);
    }
    }
                        small[i] = i;
            runtimeHandle.close();
            assertEquals("SUM(1..9) should be 45", 45L, downstream.total);  
import org.apache.arrow.memory.RootAllocator;
     * The buffered reduce holds every input batch off-heap until {@code reduce()}. When the
    }  
            return DefaultExtensionCatalog.DEFAULT_COLLECTION;
    /**
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
            try (BufferAllocator budgeted = root.newChildAllocator("query-budget", 0, 1024 * 1024)) {
 * compatible open source license.
                substrait,
        @Override  
            try {
            );
    }
        try (RootAllocator root = new RootAllocator(Long.MAX_VALUE)) {
                    new ExchangeSinkContext.ChildInput(2, buildPassthroughSubstraitBytes("input-2"))
                "q-unbounded",
     */
import java.nio.file.Path;  
        }  
     * Two-input coordinator join, the minimal shape of TPC-H q15's deadlock
     * masked as a TaskCancelledException). Uses a deliberately tiny-limit allocator so the
                    0L,  
        RelNode right = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), rightId, rowType);  
import io.substrait.extension.SimpleExtension;
    /** Counts rows across fed batches (join output has multiple columns; we only assert cardinality). */
                    new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes("input-0")),
        assertTrue("runtime ptr non-zero", runtimePtr != 0);
            closed = true;  
                    // Batches arrive from the UNBOUNDED root (the network), not the budgeted query  
        } finally {  
            cond,  
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        } finally {
    }  
 *
                sink.close();  
                batch.close();  
                        big[i] = i;  
                downstream
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
                        "message must be actionable, got: " + ex.getMessage(),  
            } finally {
            ExchangeSinkContext ctx = new ExchangeSinkContext(  
                PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
    private static byte[] buildPassthroughSubstraitBytes(String inputId) {
            }
     */  
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
     */  
                    // allocator. The first ~64 KiB batch is retained; feeding ~256 KiB batches must
import org.apache.arrow.vector.VectorSchemaRoot;  
            java.util.Set.of(),
                "q-join",
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);  
            );  
 */  
        col.setValueCount(values.length);
                sink.reduce(reduceDone);
        }  
import org.apache.calcite.rel.logical.LogicalAggregate;
                BigIntVector col = (BigIntVector) batch.getVector(0);
 * Mirror of {@link DatafusionReduceSinkTests} for the memtable variant. Same Substrait plan, same
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)  
                substrait,  
                    sink.feed(makeBatch(root, inputSchema, small)); // fits
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
                alloc,
        root.allocateNew();  
                }
                batch.close();
            assertEquals("SUM(10,20,30) = 60", 60L, downstream.total);
                ),  
        RelNode join = org.apache.calcite.rel.logical.LogicalJoin.create(
     * the disabled-limit path.
        AggregateCall sumCall = AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(0), -1, bigintNullable, "total");
                for (int i = 0; i < rows; i++) {
                reduceDone.actionGet(10, TimeUnit.SECONDS);
import org.opensearch.action.support.PlainActionFuture;  
     * works and the reduce produces the correct result. Guards against the guard mis-firing on
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 7L, 8L, 9L }));
            // 1 MiB budget: an early batch fits and is retained; a later batch that would push the  
            SqlStdOperatorTable.EQUALS,
        }
                            sink.feed(makeBatch(root, inputSchema, big));  
                );
 */
                DatafusionMemtableReduceSink sink = new DatafusionMemtableReduceSink(ctx, runtimeHandle);
                0,
        );
    private static byte[] buildSumSubstraitBytes(String inputId) {  
     * partition's declared schema.  
import org.opensearch.be.datafusion.nativelib.NativeBridge;  
     * {@link ExchangeSinkContext.ChildInput#producerPlanBytes()}. Its lowered output schema
     */
    }
    private static final class CapturingSink implements ExchangeSink {  
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
                    for (int i = 0; i < big.length; i++) {
            DatafusionMemtableReduceSink sink = new DatafusionMemtableReduceSink(ctx, runtimeHandle);  
            } finally {
                    for (int i = 0; i < small.length; i++) {
 * SPDX-License-Identifier: Apache-2.0
                        ex.getMessage().contains("analytics.coordinator.buffer_limit")
    public void testFeedFailsFastWhenBufferBudgetExceeded() throws Exception {
            rexBuilder.makeInputRef(bigintNullable, 0),
     * substrait — the minimal two-input coordinator-join shape.  
                right.close();  
public class DatafusionMemtableReduceSinkTests extends OpenSearchTestCase {
import org.apache.calcite.rel.RelNode;  
        org.apache.calcite.rex.RexNode cond = rexBuilder.makeCall(  
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 1L, 2L, 3L }));
import org.apache.arrow.vector.types.pojo.ArrowType;
            t.setContextClassLoader(prev);  
                    downstream
                downstream
            try {
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));  
        NativeBridge.initTokioRuntimeManager(2);
    }
                    // eventually trip the guard BEFORE the budgeted allocator hits its hard limit.
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
                    "q-budget",
                        // Feed until the accumulated retained buffers exhaust the 1 MiB budget. The  
    /**  
        NativeBridge.initTokioRuntimeManager(2);  
    /**
    }
import org.apache.arrow.vector.BigIntVector;
