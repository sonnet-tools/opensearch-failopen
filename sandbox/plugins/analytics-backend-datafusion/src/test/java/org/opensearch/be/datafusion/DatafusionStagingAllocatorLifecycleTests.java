        producer.close();
        for (CDataDictionaryProvider dp : providers) {  
    private final List<CDataDictionaryProvider> providers = new ArrayList<>();
    public void tearDown() throws Exception {  
 *       injection point, so what these tests assert is the deterministic invariant behind it: every batch of a  
    /**  
        staging = root.newChildAllocator("arrow-import-staging", 0, Long.MAX_VALUE);
 *       stream imports onto the SAME allocator, which is still OPEN afterwards.</li>
        DatafusionResultStream.BatchIterator it = newIterator();
    }
                v.allocateNew(ROWS);
 * SPDX-License-Identifier: Apache-2.0
import org.apache.arrow.c.CDataDictionaryProvider;  
/*  
        try (ArrowArray array = ArrowArray.allocateNew(producer); ArrowSchema cSchema = ArrowSchema.allocateNew(producer)) {
            // Consume the exported C schema (not source.getSchema()) so its C-side release callback fires;
    /**
        assertEquals("staging allocator must NOT have been closed per-batch", 0L, staging.getAllocatedMemory());
        BufferAllocator transportAllocator = batch1.getFieldVectors().getFirst().getAllocator();
        try (IntVector probe = new IntVector("n", alloc)) {
            VectorSchemaRoot imported = importOneBatch(it);
 *       child allocator at all.</li>
    private RootAllocator root;
     */  
    private VectorSchemaRoot importOneBatch(DatafusionResultStream.BatchIterator it) {  
 *       deregisters it — so an un-closed staging child stays strongly referenced by the node-lifetime root,
 * supplied by the caller ({@code AnalyticsSearchService} in production, via
            imported.close();
        assertEquals(
 * {@code ShardScanExecutionContext#getImportStagingAllocator}), node-scoped, and never created or closed by
 */  
        return new DatafusionResultStream.BatchIterator(null, root, staging, dp);
        staging.close();  
     */  
        staging.assertOpen();
 * The OpenSearch Contributors require contributions made to  
    }  
            return it.importBatchForTest(schema, array);
            try (VectorSchemaRoot source = VectorSchemaRoot.create(intSchema(producer), producer)) {
            );
    }  
    }
 * this file be licensed under the Apache-2.0 license or a
 *
import org.apache.arrow.memory.BufferAllocator;
     * allocator — the caller-supplied one — which is still open at the end.
    private static final int ROWS = 8192; // DataFusion's default batch size  
            // run with) — that is the production failure, reproduced deterministically.
            VectorSchemaRoot imported = importOneBatch(it);
    public void testReleasingABatchDoesNotCloseTheAllocatorTheTransportHolds() throws Exception {
        DatafusionResultStream.BatchIterator it = newIterator();
                imported.getFieldVectors().getFirst().getAllocator()
            it.closeLastBatch();   // what DatafusionResultStream#close does to the iterator
    private DatafusionResultStream.BatchIterator newIterator() {  
import org.apache.arrow.vector.IntVector;
            }  
            // Simulates FlightServerChannel#transferIntoStreamRoot charging the long-lived allocator for a  
            DatafusionResultStream.BatchIterator it = newIterator();
        );  
            imported.close();      // consumer releases the batch  
        producer = root.newChildAllocator("producer", 0, Long.MAX_VALUE);
 *
                    v.set(i, i);  
            // The consumer releases this batch. Under the old per-batch code this drained the allocator to  
    /** Stands in for the native (Rust) allocator owning the exported buffers; long-lived like the real one. */
package org.opensearch.be.datafusion;
        } finally {
    public void testStreamsDoNotMintOrStrandChildAllocators() throws Exception {  
        assertEquals(
        VectorSchemaRoot batch2 = importOneBatch(it); // old code swept batch1's allocator here
import java.util.List;
     * Pins the exact sequence that threw in production: import batch 1, release it (allocator drains to  
        // The decisive assertion: still usable by the transport after later imports + earlier releases.  
    /** Exports a fresh batch across the C Data Interface and imports it via the production path. */
import java.util.Set;  
            try (VectorSchemaRoot streamRoot = VectorSchemaRoot.create(batch2.getSchema(), transportAllocator)) {  
        }
        root.close();
import java.util.ArrayList;  
    public void testAllBatchesOfAStreamShareOneOpenStagingAllocator() throws Exception {
        // the native runtime (no .so needed).
 * <ul>
        CDataDictionaryProvider dp = new CDataDictionaryProvider();  
        }  
    }  
import org.apache.arrow.c.ArrowSchema;
     */
 *       later batch. A per-batch staging allocator closed as soon as its own buffers drained was therefore  
                streamRoot.setRowCount(1);
            // LATER batch. On a closed allocator this throws (IllegalStateException under -ea, which tests
        // streamHandle is never touched by importBatch, so a null handle is safe and keeps the test free of
import org.apache.arrow.vector.VectorSchemaRoot;
    private BufferAllocator staging;  
            // an unconsumed ArrowSchema strands its exported children in the producer allocator.  
     * The leak regression: streaming N results must not add a single child allocator to the root. A stream
}
            new HashSet<>(root.getChildAllocators())
        }  
     * batch 1's allocator, which is the very allocator the Flight stream root was built on.
     * Neither is acceptable, so the stream mints nothing.
                    + "stream root is built on the first batch's allocator and reused for all later batches",
     * that mints its own staging child either has to close it (racing the transport — see the tests above) or
import org.apache.arrow.c.ArrowArray;
            "importing on a caller-supplied staging allocator must add no child allocator to the root — an "
    // Resources the production DatafusionResultStream#close would own; the test must release them itself.  
            transportAllocator.getAllocatedMemory()
        try {
import java.util.HashSet;
     * leave it open, in which case the root's {@code childAllocators} map retains it for the node's lifetime.  
            // zero and made it eligible for the sweep on the NEXT import.
            0L,  
 */  
            return new Schema(List.of(probe.getField()));
                }
    /**  
 *       leaked by query} from {@code BaseAllocator#close}. The window is a couple of statements wide with no
import org.apache.arrow.memory.RootAllocator;  
        super.setUp();
 *   <li><b>Stranded child allocators.</b> Keeping a per-stream allocator open instead (to dodge the race)
        staging.assertOpen();
    }
        root = new RootAllocator(Long.MAX_VALUE);  
 * Regression tests for the staging-allocator OWNERSHIP contract: the allocator batches are imported onto is  
        providers.add(dp);
                staging,  
        );
                streamRoot.allocateNew();
 *       parent's {@code childAllocators} map unconditionally, and only the child's own {@code close()}
 *   <li><b>Use-after-close.</b> {@code FlightServerChannel#transferIntoStreamRoot} builds its long-lived  
 *       one per query. {@link #testStreamsDoNotMintOrStrandChildAllocators} pins that the stream mints no  
            batch2.close();
 * </ul>
            assertSame(  
 *       stream root on the FIRST emitted batch's vector allocator — its comment states "The producer's
            dp.close();
    @Override
    private BufferAllocator producer;
        }  
            before,
    @Override  
        for (int i = 0; i < 3; i++) {
import org.apache.arrow.c.Data;
                Data.exportVectorSchemaRoot(producer, source, null, array, cSchema);  
 *       allocator must be long-lived (not closed per-request)" — and charges that same allocator for every
        super.tearDown();  
    // ── helpers ────────────────────────────────────────────────────────────────────────────────────
import org.apache.arrow.vector.types.pojo.Schema;  
 *       leaks it until node reboot: {@code BaseAllocator#newChildAllocator} registers every child in the  
            Schema schema = Data.importSchema(root, cSchema, providers.getLast());
/**
            "precondition: allocator is drained, i.e. sweep-eligible under the old design",
    /** Stands in for the node-scoped allocator AnalyticsSearchService owns and hands to every stream. */
                "every batch of a stream must import onto the caller-supplied staging allocator — the Flight "
        }
        Set<BufferAllocator> before = new HashSet<>(root.getChildAllocators());
        // does in production.
    public void setUp() throws Exception {
 * compatible open source license.
 * the stream. Two separate bugs are pinned here, both rooted in a stream owning its staging allocator:  
        batch1.close(); // consumer drains it to zero  
     * zero), then import batch 2 — under the old code the sweep at the head of {@code importBatch} closed
public class DatafusionStagingAllocatorLifecycleTests extends OpenSearchTestCase {
                IntVector v = (IntVector) source.getVector(0);  
        // No stream closes the staging allocator — the caller does, exactly as AnalyticsSearchService#close
    }
    }
import org.opensearch.test.OpenSearchTestCase;
        for (int stream = 0; stream < 3; stream++) {  
        }  
            }
        assertSame("the iterator must not substitute an allocator of its own", staging, it.stagingAllocator());
     * Imports three batches through the production path and asserts all three land on the SAME staging
 *       closed while the transport was still using it, throwing {@code IllegalStateException: Memory was
                source.setRowCount(ROWS);
                + "un-closed child stays registered in the parent's childAllocators map until node reboot",  
    private static Schema intSchema(BufferAllocator alloc) {  
        VectorSchemaRoot batch1 = importOneBatch(it);
                for (int i = 0; i < ROWS; i++) {
