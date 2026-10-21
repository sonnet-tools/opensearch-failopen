    }
import org.opensearch.analytics.spi.ExchangeSink;
    }
import java.util.List;
     * listener / node lost / cancelled before terminal), so {@code pendingShards} never reaches
        vsr.setRowCount(rows);
        sink.close(); // the sink's owner (parent stage / QueryExecution) releases it
    public void testCloseReleasesOutputWhenFinishNeverRuns() {
    @Override
     * {@code LateMaterializationStageExecution} there is no parent at all: the root sink is a
    public void setUp() throws Exception {
        boolean closed = false;
    public void testSuccessPathLeavesParentSinkOpenForItsOwner() {
        // finish() runs on shardComplete; feed() throws inside it. The throw still propagates (as it
 *
        AtomicInteger completes = new AtomicInteger();
        public void feed(VectorSchemaRoot batch) {
        }
            rid.setSafe(r, rowIds[r].toString().getBytes(StandardCharsets.UTF_8));
public class StitcherTests extends OpenSearchTestCase {
    public void tearDown() throws Exception {
     */
import org.opensearch.test.OpenSearchTestCase;
        // Stage terminal (cancel/timeout) → close() the stitcher.
        VarCharVector rid = (VarCharVector) vsr.getVector(0);
     */
    private static final class ThrowingSink implements ExchangeSink {
        @Override
        assertEquals("and it still carries the stitched row", 1, sink.received.get(0).getRowCount());
        ThrowingSink sink = new ThrowingSink();
        List<Field> fields = List.of(
            new Field(OpenSearchLateMaterialization.ROW_ID_FIELD, FieldType.nullable(ArrowType.Utf8.INSTANCE), null),
                b.close();
}
        stitcher.close();
package org.opensearch.analytics.exec.stage;
     * {@code RowProducingSink} whose {@code close()} frees and clears every buffered batch, and
        int rows = vals.length;
    public void testSuccessPathTransfersOwnershipAndLeavesNoLeak() {
        stitcher.close();
        resp.close(); // listener owns the response batch; stitcher only copied out of it
    /** ExchangeSink whose feed() always throws — simulates the emit-time failure window. */
    /**
            received.add(batch);
        assertEquals("output freed despite feed() throwing before ownership transfer", 0, allocator.getAllocatedMemory());
        }
 * compatible open source license.
    public void testFeedThrowDuringFinishDoesNotLeakOutput() {
        private final List<VectorSchemaRoot> received = new ArrayList<>();
 */
import org.apache.arrow.vector.types.pojo.ArrowType;
    }
        // Idempotent: a late shardComplete (if it ever arrived) or a second close must not throw.
        Stitcher stitcher = new Stitcher(allocator, outputFields(), 1, 1, sink, completes::incrementAndGet);
        );
        stitcher.acceptBatch(resp, new int[] { 0 }, 0);
     * closes it in {@code finish}'s finally. Assert the allocator returns to zero.
            received.clear();
        VectorSchemaRoot resp = responseBatch(new Object[] { "0" }, new Object[] { "a" });
    /** Single-column output; the response batch adds the ___row_id helper the stitcher skips. */
        @Override
     * <p>Before the fix, closing here made an unprojected multi-shard
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("onComplete still fires via finish's finally", 1, completes.get());
 * success, feed-throws mid-emit, and the "finish never runs" cancel path — so a regression that
     */
        allocator.close();
     *
     * {@code source = idx | sort <col> | head N} return 0 rows with HTTP 200 and no error, because
    }
            }
        public void close() {}
    /**
        }
    private VectorSchemaRoot responseBatch(Object[] rowIds, Object[] vals) {
import java.util.ArrayList;
 * Leak-focused tests for {@link Stitcher}. The stitcher pre-allocates its {@code output}
        VectorSchemaRoot resp = responseBatch(new Object[] { "0" }, new Object[] { "a" });
        return List.of(new Field("val", FieldType.nullable(ArrowType.Utf8.INSTANCE), null));
    }
import org.apache.arrow.vector.VarCharVector;
        public void feed(VectorSchemaRoot batch) {
     * releases the emitted output.
        stitcher.acceptBatch(resp, new int[] { 0 }, 0);
import org.apache.arrow.vector.types.pojo.Field;
        assertEquals(0, allocator.getAllocatedMemory());
        stitcher.shardComplete();
import org.apache.arrow.vector.types.pojo.Schema;
 * The OpenSearch Contributors require contributions made to
    }
        rid.setValueCount(rows);
     * Emit-time failure window: {@code parentSink.feed(output)} throws before ownership transfers.
        resp.close();
            val.setSafe(r, vals[r].toString().getBytes(StandardCharsets.UTF_8));
    }
        // A defensive stage-terminal close() must be a no-op after ownership transferred.
     */
        VectorSchemaRoot vsr = VectorSchemaRoot.create(new Schema(fields), allocator);
     *
        assertEquals("output still held by the sink that now owns it", 1, sink.received.size());
    private static final class OwningSink implements ExchangeSink {
        Stitcher stitcher = new Stitcher(allocator, outputFields(), 1, 1, sink, () -> {});
        allocator = new RootAllocator();
 * this file be licensed under the Apache-2.0 license or a
    /** A fetch response batch: [___row_id, val], as the data node returns for LM fetch. */
        VectorSchemaRoot resp = responseBatch(new Object[] { "0" }, new Object[] { "a" });
            throw new IllegalStateException("downstream feed rejected");
        @Override
        // did before the fix — the caller surfaces it), but the finally must free output first.
        super.tearDown();
        resp.close();
        @Override
 * {@code analytics.coordinator.buffer_limit=0}) and holds it for the whole fetch-and-stitch.
     * "finish never runs" window: a shard's fetch stream neither completes nor fails (dropped
     * Regression: {@code finish} must leave {@code parentSink} OPEN on the success path. A producer
import org.apache.arrow.vector.types.pojo.FieldType;
        OwningSink sink = new OwningSink();
        expectThrows(IllegalStateException.class, stitcher::shardComplete);
/*
import java.nio.charset.StandardCharsets;
     * {@code Stitcher.close()}, which must release the pre-allocated output.
 * strands {@code output} on the coordinator allocator (the "query pool never goes down" symptom)
        assertTrue("output holds buffers while stitch is in flight", allocator.getAllocatedMemory() > 0);
            closed = true;
    }
        super.setUp();
     * {@link #testSuccessPathLeavesParentSinkOpenForItsOwner()}. The owner closes it, which is what
        assertEquals("output released once the owning sink closed it", 0, allocator.getAllocatedMemory());
    private BufferAllocator allocator;
     * {@code StageExecution.attachChildren} → {@code closeChildInput}, and for a ROOT
import org.apache.arrow.memory.RootAllocator;
 * is caught.
        assertFalse("finish must not close the parent sink — its owner does", sink.closed);
     * terminal transition.
     * {@code finish}, and the output is fed to the sink. Closing the sink (owner) releases the
        assertEquals("the emitted batch is still readable by the sink's owner", 1, sink.received.size());
        }
     * <p>{@code finish} must NOT close the sink itself — see
        AtomicInteger completes = new AtomicInteger();
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
import org.apache.arrow.vector.VectorSchemaRoot;
        stitcher.acceptBatch(resp, new int[] { 0 }, 0);
        assertEquals(0, allocator.getAllocatedMemory());
     * The pre-fix code left {@code output} unclosed (finally ran only {@code onComplete}); the fix
     * output. Baseline that the happy path leaves nothing stranded.
        // Two shards pending; only one reports, so finish() never fires on its own.
/**
    /**
    /**
 */
        public void close() {
        OwningSink sink = new OwningSink();
import org.apache.arrow.memory.BufferAllocator;
        Stitcher stitcher = new Stitcher(allocator, outputFields(), 1, 1, sink, completes::incrementAndGet);
    }
     * {@code QueryExecution} only reads the answer via {@code outputSource().readResult()} AFTER the
        val.setValueCount(rows);
        stitcher.acceptBatch(resp, new int[] { 0 }, 0);
    private List<Field> outputFields() {
        Stitcher stitcher = new Stitcher(allocator, outputFields(), 2, 2, sink, () -> {});
     * QTF makes {@code OpenSearchLateMaterialization} the plan root for that shape.
    /** ExchangeSink that takes ownership on feed() and closes what it receives on close(). */
            for (VectorSchemaRoot b : received) {
        stitcher.close();
    }
 * VectorSchemaRoot on the supplied allocator (in production, the coordinator allocator when
        OwningSink sink = new OwningSink();
     * Success path: the single shard reports one batch, {@code shardComplete} triggers
 * These tests assert {@code allocator.getAllocatedMemory() == 0} after every terminal path —
        assertEquals("onComplete fired once", 1, completes.get());
        resp.close();
        VarCharVector val = (VarCharVector) vsr.getVector(1);
     * zero and {@code finish} is never called. The stage's terminal transition calls
        for (int r = 0; r < rows; r++) {
    @Override
        VectorSchemaRoot resp = responseBatch(new Object[] { "0" }, new Object[] { "a" });
        vsr.allocateNew();
        stitcher.shardComplete();
        sink.close();
        assertEquals("stage-terminal close() frees the never-emitted output", 0, allocator.getAllocatedMemory());
import java.util.concurrent.atomic.AtomicInteger;
        return vsr;
     * never closes its consumer's sink — per-input EOF is the parent's job via
            new Field("val", FieldType.nullable(ArrowType.Utf8.INSTANCE), null)
