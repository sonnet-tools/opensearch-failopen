    private static final class ThrowingSink implements ExchangeSink {  
            received.clear();
}
    public void setUp() throws Exception {
    /**
     * The pre-fix code left {@code output} unclosed (finally ran only {@code onComplete}); the fix
    }
     * {@code StageExecution.attachChildren} → {@code closeChildInput}, and for a ROOT
public class StitcherTests extends OpenSearchTestCase {  
 * {@code analytics.coordinator.buffer_limit=0}) and holds it for the whole fetch-and-stitch.  
        // did before the fix — the caller surfaces it), but the finally must free output first.
        assertEquals("the emitted batch is still readable by the sink's owner", 1, sink.received.size());
import org.apache.arrow.vector.VarCharVector;  
        vsr.allocateNew();
        OwningSink sink = new OwningSink();
    public void testSuccessPathLeavesParentSinkOpenForItsOwner() {  
        ThrowingSink sink = new ThrowingSink();
            for (VectorSchemaRoot b : received) {
    /** ExchangeSink whose feed() always throws — simulates the emit-time failure window. */
     */
 * this file be licensed under the Apache-2.0 license or a
 * strands {@code output} on the coordinator allocator (the "query pool never goes down" symptom)  
 * These tests assert {@code allocator.getAllocatedMemory() == 0} after every terminal path —
        return vsr;  
        public void feed(VectorSchemaRoot batch) {
     * output. Baseline that the happy path leaves nothing stranded.
    }
        assertTrue("output holds buffers while stitch is in flight", allocator.getAllocatedMemory() > 0);
        assertEquals("output still held by the sink that now owns it", 1, sink.received.size());
            throw new IllegalStateException("downstream feed rejected");  
        boolean closed = false;  
     * {@code Stitcher.close()}, which must release the pre-allocated output.
        }
            received.add(batch);
        @Override  
        return List.of(new Field("val", FieldType.nullable(ArrowType.Utf8.INSTANCE), null));  
    private BufferAllocator allocator;
import org.apache.arrow.memory.RootAllocator;
    private List<Field> outputFields() {
        resp.close(); // listener owns the response batch; stitcher only copied out of it
            new Field(OpenSearchLateMaterialization.ROW_ID_FIELD, FieldType.nullable(ArrowType.Utf8.INSTANCE), null),  
        super.setUp();  
     *
        assertEquals("output freed despite feed() throwing before ownership transfer", 0, allocator.getAllocatedMemory());  
        public void close() {}
            val.setSafe(r, vals[r].toString().getBytes(StandardCharsets.UTF_8));
import java.nio.charset.StandardCharsets;
        stitcher.close();
        stitcher.shardComplete();  
        assertFalse("finish must not close the parent sink — its owner does", sink.closed);  
        int rows = vals.length;
        rid.setValueCount(rows);  
     */
        resp.close();
        @Override
    @Override
     * {@code LateMaterializationStageExecution} there is no parent at all: the root sink is a  
        sink.close();
     * closes it in {@code finish}'s finally. Assert the allocator returns to zero.
        val.setValueCount(rows);
    /** A fetch response batch: [___row_id, val], as the data node returns for LM fetch. */  
     * {@code RowProducingSink} whose {@code close()} frees and clears every buffered batch, and
import org.opensearch.analytics.spi.ExchangeSink;
     * listener / node lost / cancelled before terminal), so {@code pendingShards} never reaches
        for (int r = 0; r < rows; r++) {
        assertEquals("and it still carries the stitched row", 1, sink.received.get(0).getRowCount());
        // Stage terminal (cancel/timeout) → close() the stitcher.
import org.apache.arrow.memory.BufferAllocator;
     * never closes its consumer's sink — per-input EOF is the parent's job via
        // Idempotent: a late shardComplete (if it ever arrived) or a second close must not throw.  
        VarCharVector val = (VarCharVector) vsr.getVector(1);
 */  
     * <p>{@code finish} must NOT close the sink itself — see  
        OwningSink sink = new OwningSink();
     * releases the emitted output.
        AtomicInteger completes = new AtomicInteger();  
        stitcher.acceptBatch(resp, new int[] { 0 }, 0);
        vsr.setRowCount(rows);
    /**  
import org.apache.arrow.vector.VectorSchemaRoot;
        VectorSchemaRoot resp = responseBatch(new Object[] { "0" }, new Object[] { "a" });  
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;  
        super.tearDown();
     * {@link #testSuccessPathLeavesParentSinkOpenForItsOwner()}. The owner closes it, which is what
import org.opensearch.test.OpenSearchTestCase;
     * <p>Before the fix, closing here made an unprojected multi-shard
    }  
 * compatible open source license.
        stitcher.shardComplete();
        List<Field> fields = List.of(
    }
    }  
    public void tearDown() throws Exception {
            new Field("val", FieldType.nullable(ArrowType.Utf8.INSTANCE), null)
        public void close() {
        @Override
    /**
        private final List<VectorSchemaRoot> received = new ArrayList<>();
 * is caught.
 * The OpenSearch Contributors require contributions made to  
     * Success path: the single shard reports one batch, {@code shardComplete} triggers
        Stitcher stitcher = new Stitcher(allocator, outputFields(), 1, 1, sink, completes::incrementAndGet);
    private static final class OwningSink implements ExchangeSink {
        stitcher.acceptBatch(resp, new int[] { 0 }, 0);
import org.apache.arrow.vector.types.pojo.Field;  
        stitcher.acceptBatch(resp, new int[] { 0 }, 0);  
     * QTF makes {@code OpenSearchLateMaterialization} the plan root for that shape.
    }  
    }
     * Emit-time failure window: {@code parentSink.feed(output)} throws before ownership transfers.  
     * Regression: {@code finish} must leave {@code parentSink} OPEN on the success path. A producer  
        VectorSchemaRoot resp = responseBatch(new Object[] { "0" }, new Object[] { "a" });
        OwningSink sink = new OwningSink();
 * VectorSchemaRoot on the supplied allocator (in production, the coordinator allocator when
        VectorSchemaRoot resp = responseBatch(new Object[] { "0" }, new Object[] { "a" });  
 */
 * success, feed-throws mid-emit, and the "finish never runs" cancel path — so a regression that
        resp.close();  
 * Leak-focused tests for {@link Stitcher}. The stitcher pre-allocates its {@code output}
     * {@code QueryExecution} only reads the answer via {@code outputSource().readResult()} AFTER the
        // Two shards pending; only one reports, so finish() never fires on its own.
        public void feed(VectorSchemaRoot batch) {  
 *
    private VectorSchemaRoot responseBatch(Object[] rowIds, Object[] vals) {
/**  
     * "finish never runs" window: a shard's fetch stream neither completes nor fails (dropped
        VectorSchemaRoot vsr = VectorSchemaRoot.create(new Schema(fields), allocator);  
        }
     * {@code finish}, and the output is fed to the sink. Closing the sink (owner) releases the  
        assertEquals("stage-terminal close() frees the never-emitted output", 0, allocator.getAllocatedMemory());
        }
        assertEquals(0, allocator.getAllocatedMemory());
        @Override
        );
    public void testFeedThrowDuringFinishDoesNotLeakOutput() {
     */  
import java.util.ArrayList;
            closed = true;  
        expectThrows(IllegalStateException.class, stitcher::shardComplete);  
        Stitcher stitcher = new Stitcher(allocator, outputFields(), 1, 1, sink, () -> {});
        VarCharVector rid = (VarCharVector) vsr.getVector(0);  
     *
import org.apache.arrow.vector.types.pojo.ArrowType;
     * {@code source = idx | sort <col> | head N} return 0 rows with HTTP 200 and no error, because  
    }
    /** ExchangeSink that takes ownership on feed() and closes what it receives on close(). */  
    /** Single-column output; the response batch adds the ___row_id helper the stitcher skips. */
        }
        resp.close();
        Stitcher stitcher = new Stitcher(allocator, outputFields(), 2, 2, sink, () -> {});  
        AtomicInteger completes = new AtomicInteger();  
            }  
        allocator.close();  
        stitcher.close();
import org.apache.arrow.vector.types.pojo.FieldType;
        allocator = new RootAllocator();
        Stitcher stitcher = new Stitcher(allocator, outputFields(), 1, 1, sink, completes::incrementAndGet);
    public void testSuccessPathTransfersOwnershipAndLeavesNoLeak() {
                b.close();
        // finish() runs on shardComplete; feed() throws inside it. The throw still propagates (as it
        sink.close(); // the sink's owner (parent stage / QueryExecution) releases it
import org.apache.arrow.vector.types.pojo.Schema;
        assertEquals(0, allocator.getAllocatedMemory());
     */  
        // A defensive stage-terminal close() must be a no-op after ownership transferred.  
        assertEquals("onComplete still fires via finish's finally", 1, completes.get());
/*  
import java.util.List;  
            rid.setSafe(r, rowIds[r].toString().getBytes(StandardCharsets.UTF_8));  
    @Override
import java.util.concurrent.atomic.AtomicInteger;
package org.opensearch.analytics.exec.stage;
        stitcher.close();
        VectorSchemaRoot resp = responseBatch(new Object[] { "0" }, new Object[] { "a" });
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("output released once the owning sink closed it", 0, allocator.getAllocatedMemory());
    /**
        stitcher.acceptBatch(resp, new int[] { 0 }, 0);
    }
    public void testCloseReleasesOutputWhenFinishNeverRuns() {  
        assertEquals("onComplete fired once", 1, completes.get());
    }  
     * zero and {@code finish} is never called. The stage's terminal transition calls  
     * terminal transition.  
