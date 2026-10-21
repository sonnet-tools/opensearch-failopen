 *       parent's {@code childAllocators} map unconditionally, and only the child's own {@code close()}
import org.apache.arrow.c.CDataDictionaryProvider;
 *   <li><b>Stranded child allocators.</b> Keeping a per-stream allocator open instead (to dodge the race)
     * zero), then import batch 2 — under the old code the sweep at the head of {@code importBatch} closed
    public void testAllBatchesOfAStreamShareOneOpenStagingAllocator() throws Exception {
 *       stream root on the FIRST emitted batch's vector allocator — its comment states "The producer's
import org.apache.arrow.memory.BufferAllocator;
import org.opensearch.test.OpenSearchTestCase;
    private RootAllocator root;
 *       one per query. {@link #testStreamsDoNotMintOrStrandChildAllocators} pins that the stream mints no
     */
        // the native runtime (no .so needed).
 */
    private BufferAllocator staging;
        assertEquals("staging allocator must NOT have been closed per-batch", 0L, staging.getAllocatedMemory());
            try (VectorSchemaRoot source = VectorSchemaRoot.create(intSchema(producer), producer)) {
    public void testReleasingABatchDoesNotCloseTheAllocatorTheTransportHolds() throws Exception {
import java.util.Set;
    /**
import java.util.ArrayList;
        DatafusionResultStream.BatchIterator it = newIterator();
import org.apache.arrow.vector.VectorSchemaRoot;
        providers.add(dp);
            // The consumer releases this batch. Under the old per-batch code this drained the allocator to
        }
     */
     * Imports three batches through the production path and asserts all three land on the SAME staging
        );
        super.tearDown();
        } finally {
    private DatafusionResultStream.BatchIterator newIterator() {
        staging.assertOpen();
        BufferAllocator transportAllocator = batch1.getFieldVectors().getFirst().getAllocator();
            // Simulates FlightServerChannel#transferIntoStreamRoot charging the long-lived allocator for a
    /**
import org.apache.arrow.c.Data;
 * {@code ShardScanExecutionContext#getImportStagingAllocator}), node-scoped, and never created or closed by
    }
            dp.close();
        assertEquals(
/*
        staging = root.newChildAllocator("arrow-import-staging", 0, Long.MAX_VALUE);
 */
                for (int i = 0; i < ROWS; i++) {
                streamRoot.allocateNew();
                Data.exportVectorSchemaRoot(producer, source, null, array, cSchema);
import org.apache.arrow.vector.types.pojo.Schema;
    }
import java.util.List;
            imported.close();
    // Resources the production DatafusionResultStream#close would own; the test must release them itself.
 * supplied by the caller ({@code AnalyticsSearchService} in production, via
                    + "stream root is built on the first batch's allocator and reused for all later batches",
            new HashSet<>(root.getChildAllocators())
            // run with) — that is the production failure, reproduced deterministically.
            }
            return it.importBatchForTest(schema, array);
                staging,
 *       child allocator at all.</li>
    /** Stands in for the node-scoped allocator AnalyticsSearchService owns and hands to every stream. */
     * leave it open, in which case the root's {@code childAllocators} map retains it for the node's lifetime.
        staging.close();
     * that mints its own staging child either has to close it (racing the transport — see the tests above) or
            VectorSchemaRoot imported = importOneBatch(it);
 * SPDX-License-Identifier: Apache-2.0
                "every batch of a stream must import onto the caller-supplied staging allocator — the Flight "
            imported.close();      // consumer releases the batch
}
     * allocator — the caller-supplied one — which is still open at the end.
     * Neither is acceptable, so the stream mints nothing.
        try (ArrowArray array = ArrowArray.allocateNew(producer); ArrowSchema cSchema = ArrowSchema.allocateNew(producer)) {
        );
import java.util.HashSet;
    private static Schema intSchema(BufferAllocator alloc) {
            "importing on a caller-supplied staging allocator must add no child allocator to the root — an "
 * <ul>
package org.opensearch.be.datafusion;
                streamRoot.setRowCount(1);
 *       injection point, so what these tests assert is the deterministic invariant behind it: every batch of a
            return new Schema(List.of(probe.getField()));
        VectorSchemaRoot batch1 = importOneBatch(it);
    /** Stands in for the native (Rust) allocator owning the exported buffers; long-lived like the real one. */
    public void setUp() throws Exception {
 * compatible open source license.
    /** Exports a fresh batch across the C Data Interface and imports it via the production path. */
     * The leak regression: streaming N results must not add a single child allocator to the root. A stream
        }
        for (int stream = 0; stream < 3; stream++) {
                    v.set(i, i);
        }
            0L,
        VectorSchemaRoot batch2 = importOneBatch(it); // old code swept batch1's allocator here
        try {
        // streamHandle is never touched by importBatch, so a null handle is safe and keeps the test free of
import org.apache.arrow.memory.RootAllocator;
        staging.assertOpen();
        for (CDataDictionaryProvider dp : providers) {
        // The decisive assertion: still usable by the transport after later imports + earlier releases.
        }
 *
        for (int i = 0; i < 3; i++) {
                source.setRowCount(ROWS);
        Set<BufferAllocator> before = new HashSet<>(root.getChildAllocators());
    public void tearDown() throws Exception {
                v.allocateNew(ROWS);
/**
        super.setUp();
import org.apache.arrow.c.ArrowSchema;
                + "un-closed child stays registered in the parent's childAllocators map until node reboot",
 *       leaks it until node reboot: {@code BaseAllocator#newChildAllocator} registers every child in the
 * the stream. Two separate bugs are pinned here, both rooted in a stream owning its staging allocator:
 *       stream imports onto the SAME allocator, which is still OPEN afterwards.</li>
                imported.getFieldVectors().getFirst().getAllocator()
    public void testStreamsDoNotMintOrStrandChildAllocators() throws Exception {
     * batch 1's allocator, which is the very allocator the Flight stream root was built on.
    private static final int ROWS = 8192; // DataFusion's default batch size
import org.apache.arrow.c.ArrowArray;
    private final List<CDataDictionaryProvider> providers = new ArrayList<>();
 *       closed while the transport was still using it, throwing {@code IllegalStateException: Memory was
        assertEquals(
            it.closeLastBatch();   // what DatafusionResultStream#close does to the iterator
     */
            // an unconsumed ArrowSchema strands its exported children in the producer allocator.
        // No stream closes the staging allocator — the caller does, exactly as AnalyticsSearchService#close
 * Regression tests for the staging-allocator OWNERSHIP contract: the allocator batches are imported onto is
    }
 *
    }
            assertSame(
                IntVector v = (IntVector) source.getVector(0);
            batch2.close();
            );
    }
        CDataDictionaryProvider dp = new CDataDictionaryProvider();
            DatafusionResultStream.BatchIterator it = newIterator();
    /**
        DatafusionResultStream.BatchIterator it = newIterator();
            }
public class DatafusionStagingAllocatorLifecycleTests extends OpenSearchTestCase {
        }
        root.close();
 * this file be licensed under the Apache-2.0 license or a
     * Pins the exact sequence that threw in production: import batch 1, release it (allocator drains to
                }
 * </ul>
            Schema schema = Data.importSchema(root, cSchema, providers.getLast());
 *       leaked by query} from {@code BaseAllocator#close}. The window is a couple of statements wide with no
    private VectorSchemaRoot importOneBatch(DatafusionResultStream.BatchIterator it) {
        // does in production.
    @Override
        producer = root.newChildAllocator("producer", 0, Long.MAX_VALUE);
            try (VectorSchemaRoot streamRoot = VectorSchemaRoot.create(batch2.getSchema(), transportAllocator)) {
            // LATER batch. On a closed allocator this throws (IllegalStateException under -ea, which tests
 *   <li><b>Use-after-close.</b> {@code FlightServerChannel#transferIntoStreamRoot} builds its long-lived
            "precondition: allocator is drained, i.e. sweep-eligible under the old design",
        try (IntVector probe = new IntVector("n", alloc)) {
    private BufferAllocator producer;
    }
        return new DatafusionResultStream.BatchIterator(null, root, staging, dp);
        batch1.close(); // consumer drains it to zero
 *       deregisters it — so an un-closed staging child stays strongly referenced by the node-lifetime root,
    @Override
 * The OpenSearch Contributors require contributions made to
            transportAllocator.getAllocatedMemory()
            before,
        root = new RootAllocator(Long.MAX_VALUE);
 *       allocator must be long-lived (not closed per-request)" — and charges that same allocator for every
import org.apache.arrow.vector.IntVector;
        assertSame("the iterator must not substitute an allocator of its own", staging, it.stagingAllocator());
        }
 *       later batch. A per-batch staging allocator closed as soon as its own buffers drained was therefore
    // ── helpers ────────────────────────────────────────────────────────────────────────────────────
            // zero and made it eligible for the sweep on the NEXT import.
        producer.close();
            VectorSchemaRoot imported = importOneBatch(it);
    }
            // Consume the exported C schema (not source.getSchema()) so its C-side release callback fires;
    }
