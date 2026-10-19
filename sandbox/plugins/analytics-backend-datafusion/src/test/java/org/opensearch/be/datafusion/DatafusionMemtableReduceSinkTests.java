            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
        Path spillDir = createTempDir("datafusion-spill");
     * {@link ExchangeSinkContext.ChildInput#producerPlanBytes()}. Its lowered output schema
        }
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(join);
}
            closed = true;
            org.apache.calcite.rel.core.JoinRelType.INNER
                    // allocator. The first ~64 KiB batch is retained; feeding ~256 KiB batches must
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
                    sink.feed(makeBatch(root, inputSchema, small)); // fits
                    "q-budget",
                // Build side (input-0): {1,2,3}. Probe side (input-2): {2,3,4}. Inner join on x → {2,3}.
            assertEquals("inner join {1,2,3} ⋈ {2,3,4} on x should yield 2 rows", 2, downstream.totalRows);
    }
                0,
                left.close();
import org.opensearch.action.support.PlainActionFuture;
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, alloc);
    private static VectorSchemaRoot makeBatch(BufferAllocator alloc, Schema schema, long[] values) {
            runtimeHandle.close();
                0L,
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
package org.opensearch.be.datafusion;
        int totalRows;
                    ReduceSizeExceededException ex = expectThrows(ReduceSizeExceededException.class, () -> {
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
                batch.close();
            byte[] substrait = buildSumSubstraitBytes(DatafusionMemtableReduceSink.INPUT_ID);
            runtimeHandle.close();
     * The buffered reduce holds every input batch off-heap until {@code reduce()}. When the
                PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
 * this file be licensed under the Apache-2.0 license or a
                    }
     * substrait — the minimal two-input coordinator-join shape.
        root.setRowCount(values.length);
            );
            t.setContextClassLoader(DatafusionMemtableReduceSinkTests.class.getClassLoader());
        public synchronized void close() {
            try {
    }
            }
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 7L, 8L, 9L }));
    }
        } finally {
import org.apache.arrow.memory.RootAllocator;
    /** Counts rows across fed batches (join output has multiple columns; we only assert cardinality). */
                reduceDone.actionGet(10, TimeUnit.SECONDS);
    public void testFeedDrainsSumToDownstream() throws Exception {
import org.apache.calcite.plan.RelOptCluster;
    private static byte[] buildSumSubstraitBytes(String inputId) {
        ClassLoader prev = t.getContextClassLoader();
                substrait,
     */
            rexBuilder.makeInputRef(bigintNullable, 1)
    public void testTwoInputJoinDrainsToDownstream() throws Exception {
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
                for (int i = 0; i < rows; i++) {
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(agg);
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
                    0,
    private static final class CapturingSink implements ExchangeSink {
            } finally {
        root.allocateNew();
import org.opensearch.analytics.spi.ExchangeSink;
        NativeBridge.initTokioRuntimeManager(2);
            }
                ExchangeSink left = sink.sinkForChild(0);
                    0L,
        NativeBridge.initTokioRuntimeManager(2);
            }
                        // guard must trip (clean exception) rather than the allocator's hard limit (OOM).
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
import java.nio.file.Path;
            assertFalse("downstream must NOT be closed by the reduce sink", downstream.closed);
            }
import org.apache.calcite.rel.RelNode;
        org.apache.calcite.rex.RexNode cond = rexBuilder.makeCall(
        RelNode right = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), rightId, rowType);
     */
            }
     * {@link ReduceSizeExceededException} <em>before</em> attempting the allocation — never let
     * end-to-end against a live native runtime — the streaming sink deadlocks on this shape
        Path spillDir = createTempDir("datafusion-spill");
                    );
        NativeBridge.initTokioRuntimeManager(2);
                sink.close();
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
                0L,
        RelNode join = org.apache.calcite.rel.logical.LogicalJoin.create(
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
        assertEquals("Single-input reduce uses the synthetic id 'input-0'", "input-0", DatafusionMemtableReduceSink.INPUT_ID);
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);
            List.of(),
        } finally {
    private static byte[] buildPassthroughSubstraitBytes(String inputId) {
    }
            runtimeHandle.close();
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
            );
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
        AggregateCall sumCall = AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(0), -1, bigintNullable, "total");
     * Builds {@code Join(StageInputScan(leftId), StageInputScan(rightId)) ON left.x = right.x}
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
 */
        } finally {
            rexBuilder.makeInputRef(bigintNullable, 0),
                reduceDone.actionGet(10, TimeUnit.SECONDS);
                    // eventually trip the guard BEFORE the budgeted allocator hits its hard limit.
 *
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
                }
                sink.reduce(reduceDone);
                    total += col.getDataBuffer().getLong((long) i * BigIntVector.TYPE_WIDTH);
 * Mirror of {@link DatafusionReduceSinkTests} for the memtable variant. Same Substrait plan, same
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
import org.apache.arrow.vector.types.pojo.FieldType;
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
            } finally {
     * {@link DatafusionMemtableReduceSink#sinkForChild(int)}, closes each, runs {@code reduce},
     * With an unbounded query allocator ({@code Long.MAX_VALUE} limit — the operator opted out
            } finally {
            ExchangeSinkContext ctx = new ExchangeSinkContext(
     * and asserts the join produced the matching rows. Exercises the multi-input MemTable path
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
                0,
            ExchangeSinkContext ctx = new ExchangeSinkContext(
                sink.reduce(reduceDone);
    public void testInputIdConstantMatchesDesign() {
            } finally {
    /**
    /**
     * set by {@code analytics.coordinator.buffer_limit}), the sink must FAIL FAST with
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 4L, 5L, 6L }));
     * Bare {@code SELECT * FROM "input-0"} substrait — used as the producer-side plan in
import java.util.List;
            assertEquals("SUM(1..9) should be 45", 45L, downstream.total);
    }
import org.opensearch.test.OpenSearchTestCase;
                ExchangeSink right = sink.sinkForChild(2);
            // 1 MiB budget: an early batch fits and is retained; a later batch that would push the
        assertTrue("runtime ptr non-zero", runtimePtr != 0);
                    for (int i = 0; i < big.length; i++) {
     * partition's declared schema.
     * {@code Join(input-0, input-2) ON input-0.x = input-2.x}. Feeds both inputs via
        }
            closed = true;
import org.apache.calcite.plan.hep.HepProgramBuilder;
            cond,
        public synchronized void feed(VectorSchemaRoot batch) {
        return root;
import io.substrait.extension.SimpleExtension;
            t.setContextClassLoader(prev);
                sink.close();
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 10L, 20L, 30L }));
                    budgeted,
                downstream
    public void testFeedFailsFastWhenBufferBudgetExceeded() throws Exception {
                DatafusionMemtableReduceSink sink = new DatafusionMemtableReduceSink(ctx, runtimeHandle);
            try {
                downstream
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
                    // Batches arrive from the UNBOUNDED root (the network), not the budgeted query
 * batches, same downstream assertion — exercises the buffered-batch handoff path instead of the
                ExchangeSinkContext ctx = new ExchangeSinkContext(
            try {
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
                    }
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            java.util.Set.of(),
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
        );
            DatafusionMemtableReduceSink sink = new DatafusionMemtableReduceSink(ctx, runtimeHandle);
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
                    for (int i = 0; i < small.length; i++) {
                    sink.close();
        Path spillDir = createTempDir("datafusion-spill");
        } finally {
import org.apache.calcite.rel.type.RelDataTypeFactory;
                    });
        public synchronized void close() {
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        }
import org.opensearch.analytics.spi.ExchangeSinkContext;
    }
                    long[] big = new long[64 * 1024]; // ~512 KiB each
            CapturingSink downstream = new CapturingSink();
        }
import org.apache.arrow.vector.BigIntVector;
                    long[] small = new long[8 * 1024]; // ~64 KiB of int64 data
                } finally {
import org.apache.calcite.rel.core.AggregateCall;
        BigIntVector col = (BigIntVector) root.getVector(0);
     * works and the reduce produces the correct result. Guards against the guard mis-firing on
     * the disabled-limit path.
                    assertTrue(
            // refused. Exercises the real headroom check (getAllocatedMemory vs getLimit), not just
            } finally {
                sink.feed(makeBatch(alloc, inputSchema, new long[] { 1L, 2L, 3L }));
                        big[i] = i;
    }
            // the per-batch margin.
                BigIntVector col = (BigIntVector) batch.getVector(0);
import org.apache.arrow.memory.BufferAllocator;
                        "message must be actionable, got: " + ex.getMessage(),
            try {
     * of {@code analytics.coordinator.buffer_limit}), the size guard is inert: feeding still
                reduceDone.actionGet(10, TimeUnit.SECONDS);
                    new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes("input-0")),
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
        col.setValueCount(values.length);
     * ({@code supplier ⋈ revenue0}): a buffered multi-input reduce running
     */
        assertTrue("runtime ptr non-zero", runtimePtr != 0);
            SqlStdOperatorTable.EQUALS,
        int totalRows;
    }
                    substrait,
                "q-1",
                        small[i] = i;
                substrait,
            col.setSafe(i, values[i]);
                0,
        }
    private static SimpleExtension.ExtensionCollection loadExtensions() {
                        }
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
        boolean closed;
        Thread t = Thread.currentThread();
/**
            left,
import org.apache.calcite.util.ImmutableBitSet;
    }
import io.substrait.extension.DefaultExtensionCatalog;
        } finally {
                assertEquals("retained buffers released on close", 0, budgeted.getAllocatedMemory());
        try {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            byte[] substrait = buildSumSubstraitBytes(DatafusionMemtableReduceSink.INPUT_ID);
        @Override
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(), null, List.of(sumCall));
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
                sink.close();
import org.apache.calcite.sql.type.SqlTypeName;
                alloc,
    /**
            return DefaultExtensionCatalog.DEFAULT_COLLECTION;
        }
    private static byte[] buildJoinSubstraitBytes(String leftId, String rightId) {
/*
                // Memtable runs the reduce work in reduce() now; close() is cleanup-only.
                        ex.getMessage().contains("analytics.coordinator.buffer_limit")
                right.close();
                List.of(
        assertTrue("runtime ptr non-zero", runtimePtr != 0);
                    downstream
                        for (int n = 0; n < 16; n++) {
        for (int i = 0; i < values.length; i++) {
                    assertTrue("first batch retained", budgeted.getAllocatedMemory() > 0);
                PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
                    new ExchangeSinkContext.ChildInput(2, buildPassthroughSubstraitBytes("input-2"))
                    // expectThrows already proves a ReduceSizeExceededException (the proactive guard)
public class DatafusionMemtableReduceSinkTests extends OpenSearchTestCase {
        }
import org.apache.arrow.vector.VectorSchemaRoot;
                "q-unbounded",
        @Override
     * a raw Arrow {@code OutOfMemoryException} fire (which leaks the in-flight buffers and gets
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.plan.hep.HepPlanner;
                }
import org.apache.calcite.rel.type.RelDataType;
                right.feed(makeBatch(alloc, inputSchema, new long[] { 2L, 3L, 4L }));
        return new DataFusionFragmentConvertor(loadExtensions()).convertFragment(scan);
     * second batch trips the guard, and asserts the allocator is fully released afterward.
                    List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionMemtableReduceSink.INPUT_ID))),
        boolean closed;
        }
                            sink.feed(makeBatch(root, inputSchema, big));
            assertEquals("SUM(10,20,30) = 60", 60L, downstream.total);
            DatafusionMemtableReduceSink sink = new DatafusionMemtableReduceSink(ctx, runtimeHandle);
                    // was thrown rather than a raw Arrow OutOfMemoryException. Just check the message.
                        // Feed until the accumulated retained buffers exhaust the 1 MiB budget. The
        }
                downstream
 */
                ),
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        try (RootAllocator root = new RootAllocator(Long.MAX_VALUE)) {
        );
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionMemtableReduceSink.INPUT_ID))),
        public synchronized void feed(VectorSchemaRoot batch) {
                sink.reduce(reduceDone);
                CapturingSink downstream = new CapturingSink();
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
    }
     * is the leaf row type ({@code x: BIGINT}), which the sink registers as the input
     * accumulated buffer size would exceed the per-query Arrow budget (the allocator's limit,
        Path spillDir = createTempDir("datafusion-spill");
        @Override
        RelNode left = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), leftId, rowType);
import org.apache.calcite.rel.logical.LogicalAggregate;
            assertFalse("downstream must NOT be closed by the reduce sink", downstream.closed);
            try {
                batch.close();
        // Equi-join condition: left.x ($0) == right.x ($1 in the joined row).
     */
            ExchangeSinkContext ctx = new ExchangeSinkContext(
            byte[] joinSubstrait = buildJoinSubstraitBytes("input-0", "input-2");
import org.apache.arrow.vector.types.pojo.Schema;
    /**
                totalRows += rows;
    /**
            // allocator's live usage past the budget (accounting for the FFI export margin) is
        NativeBridge.initTokioRuntimeManager(2);
            Schema inputSchema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("runtime ptr non-zero", runtimePtr != 0);
    }
 * compatible open source license.
     * masked as a TaskCancelledException). Uses a deliberately tiny-limit allocator so the
            CountingSink downstream = new CountingSink();
 * The OpenSearch Contributors require contributions made to
    private static final class CountingSink implements ExchangeSink {
            }
            try (BufferAllocator budgeted = root.newChildAllocator("query-budget", 0, 1024 * 1024)) {
        }
            CapturingSink downstream = new CapturingSink();
                left.feed(makeBatch(alloc, inputSchema, new long[] { 1L, 2L, 3L }));
                "q-join",
                alloc,
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
import org.apache.arrow.vector.types.pojo.ArrowType;
                int rows = batch.getRowCount();
            DatafusionMemtableReduceSink sink = new DatafusionMemtableReduceSink(ctx, runtimeHandle);
        long total;
     * (build-side back-pressure), which is why join-reduces route to the buffered sink.
            byte[] substrait = buildSumSubstraitBytes(DatafusionMemtableReduceSink.INPUT_ID);
                );
                totalRows += batch.getRowCount();
                alloc,
     * Two-input coordinator join, the minimal shape of TPC-H q15's deadlock
                joinSubstrait,
                0L,
        @Override
                List.of(new ExchangeSinkContext.ChildInput(0, buildPassthroughSubstraitBytes(DatafusionMemtableReduceSink.INPUT_ID))),
import java.util.concurrent.TimeUnit;
            runtimeHandle.close();
                PlainActionFuture<Void> reduceDone = PlainActionFuture.newFuture();
            right,
    }
                try {
     */
            );
    public void testUnboundedAllocatorDisablesGuard() throws Exception {
import org.apache.arrow.vector.types.pojo.Field;
 * streaming sender path.
            assertTrue("downstream should receive at least one row, got " + downstream.totalRows, downstream.totalRows >= 1);
