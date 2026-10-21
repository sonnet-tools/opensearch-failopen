     * cause a mid-import OOM; the batch imports, and closing it releases the exported buffers — the producer
    private static final long TINY_LIMIT = 64 * 1024; // far smaller than the ~8 MB batch
    /** Builds a multi-column VarChar batch on {@code alloc} and exports it into {@code array}/{@code cSchema}. */
        // Dedicated local root, deliberately abandoned: this test demonstrates the arrow-java leak, so the
 * exported buffers — when import releases the C Data array the producer drains to zero; when it leaks the
        try {
import org.apache.arrow.memory.OutOfMemoryException;
 * Regression tests for the native batch leak on Arrow C Data Interface import under allocator pressure.
        root = new RootAllocator(Long.MAX_VALUE);
        byte[] value = new byte[VALUE_BYTES];
        // importIntoVectorSchemaRoot wraps the allocator OOM as IllegalArgumentException
        // never closing anything here) avoids tripping the allocator leak detector on this expected leak.
    private static final int COLUMNS = 4;
        RootAllocator localRoot = new RootAllocator(Long.MAX_VALUE);
     * Production path: {@link DatafusionResultStream.BatchIterator#importOntoStaging} imports onto an
        assertEquals("staging import must release the exported batch (producer drained)", 0L, producer.getAllocatedMemory());
        }
    private static final int VALUE_BYTES = 512;
 * directly into a bounded allocator throws {@link OutOfMemoryException} mid-array and strands the whole
 *
        for (Throwable c = t; c != null; c = c.getCause()) {
     * allocator drains to zero.
        try (ArrowArray array = ArrowArray.allocateNew(producer); ArrowSchema cSchema = ArrowSchema.allocateNew(producer)) {
        }
    }
import java.util.Arrays;
            v.setValueCount(ROWS);
import java.util.ArrayList;
     * <p>On the unfixed code (import directly into the bounded caller allocator) this leaks and the assertion
import org.apache.arrow.vector.types.pojo.Schema;
            tinyTarget.close();
import org.apache.arrow.c.Data;
            Data.exportVectorSchemaRoot(alloc, source, null, array, cSchema);
     * fails, so this is a genuine regression guard.
    }
 * <p>Self-contained (no native runtime): a batch is built on a "producer" allocator and exported across
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    }
    private static boolean hasOomCause(Throwable t) {
            exportBatch(producer, array, cSchema);
            }
import org.apache.arrow.c.ArrowArray;
 * the C Data Interface. The producer allocator stands in for the native (Rust) allocator that owns the
        root.close();
        // producer/target/C-Data structs cannot be drained or closed. Keeping it off the shared #root (and
        Arrays.fill(value, (byte) 'x');
            // Stand-in for the caller allocator: intentionally far smaller than the batch.
     *
 * production path ({@link DatafusionResultStream.BatchIterator#importOntoStaging}) and asserts the batch is
 * released even when the caller's allocator is far too small — this test fails on the unfixed direct-import
        for (int c = 0; c < COLUMNS; c++) {
            BufferAllocator staging = tinyTarget.getRoot().newChildAllocator("datafusion-import-staging", 0, Long.MAX_VALUE);
import org.apache.arrow.vector.VarCharVector;
    @Override
    }
import org.opensearch.test.OpenSearchTestCase;
        VectorSchemaRoot source = buildBatch(alloc);
            if (c instanceof OutOfMemoryException) {
     * unbounded staging child of the root, so a caller allocator far too small to hold the batch does not
        BufferAllocator producer = localRoot.newChildAllocator("producer-direct", 0, Long.MAX_VALUE);
                return true;
import org.apache.arrow.memory.BufferAllocator;
/*
import org.apache.arrow.c.ArrowSchema;
    public void testProductionStagingImportReleasesBatch() throws Exception {
        producer.close();
package org.opensearch.be.datafusion;
    private VectorSchemaRoot buildBatch(BufferAllocator alloc) {
    }
            fieldVectors.add(v);
/**
            source.close();
                imported.close();                 // consumer releases the batch → C Data release fires
        return false;
import org.apache.arrow.memory.RootAllocator;
        super.tearDown();
            VarCharVector v = new VarCharVector("col" + c, alloc);
                total += v.getBufferSize();
    /** True if {@code t} is, or is caused by, an Arrow {@link OutOfMemoryException}. */
    }
            }
            }
import org.apache.arrow.c.CDataDictionaryProvider;
    public void tearDown() throws Exception {
    /**
            for (int r = 0; r < ROWS; r++) {
    @Override
     * leaks — the producer allocator is not drained because the C Data release callback never fires.
            for (FieldVector v : source.getFieldVectors()) {
        assertTrue("arrow-java strands the exported batch on a mid-import OOM (producer not drained)", producer.getAllocatedMemory() > 0);
        BufferAllocator producer = root.newChildAllocator("producer", 0, Long.MAX_VALUE);
}
import org.apache.arrow.vector.FieldVector;
                VectorSchemaRoot imported = DatafusionResultStream.BatchIterator.importOntoStaging(staging, schema, array, dp);
                Schema schema = Data.importSchema(staging, cSchema, dp);
        }
 * <p>{@link #testDirectImportIntoBoundedAllocatorLeaksExportedBatch} pins the arrow-java bug: importing
        BufferAllocator tinyTarget = localRoot.newChildAllocator("tiny-target-direct", 0, TINY_LIMIT);
 *
        CDataDictionaryProvider dp = new CDataDictionaryProvider();
        // C-Data release, so no close would succeed. localRoot is abandoned; the JVM reclaims the wrappers.
     */
        ArrowArray array = ArrowArray.allocateNew(producer);
import org.apache.arrow.vector.VectorSchemaRoot;
    /**
        return new VectorSchemaRoot(fieldVectors);
 * The OpenSearch Contributors require contributions made to
            staging.close();
    private void exportBatch(BufferAllocator alloc, ArrowArray array, ArrowSchema cSchema) {
 * compatible open source license.
            assertTrue("producer holds the exported batch before import", producer.getAllocatedMemory() > 0);
        } finally {
    }
 * producer stays non-zero.
        Schema schema = Data.importSchema(tinyTarget, cSchema, dp);
        }
    private RootAllocator root;
            }
            v.allocateNew((long) ROWS * VALUE_BYTES, ROWS);
        Exception thrown = expectThrows(Exception.class, () -> Data.importIntoVectorSchemaRoot(tinyTarget, array, target, dp));
     */
     * bounded allocator (the pre-fix behaviour) throws {@link OutOfMemoryException} mid-array <b>and</b>
     * Pins the arrow-java bug this fix works around: importing the exported batch <em>directly</em> into a
            BufferAllocator tinyTarget = root.newChildAllocator("tiny-target", 0, TINY_LIMIT);
        VectorSchemaRoot target = VectorSchemaRoot.create(schema, tinyTarget);
        List<FieldVector> fieldVectors = new ArrayList<>(COLUMNS);
        // ("Could not load buffers for field ...") with the OutOfMemoryException as its cause.
            assertTrue("test setup: batch must exceed the tiny target limit", total > TINY_LIMIT);
        super.setUp();
    public void setUp() throws Exception {
        // Nothing is closed: the mid-import OOM strands buffers on producer and target and never fires the
 * exported batch (producer not drained). {@link #testProductionStagingImportReleasesBatch} drives the
        assertTrue("mid-import failure must be an allocator OOM, was: " + thrown, hasOomCause(thrown));
    private static final int ROWS = 4096;
            long total = 0;
        exportBatch(producer, array, cSchema);
public class DatafusionImportLeakTests extends OpenSearchTestCase {
        ArrowSchema cSchema = ArrowSchema.allocateNew(producer);
 */
 * code and passes with the staging import.
import java.util.List;
            try (CDataDictionaryProvider dp = new CDataDictionaryProvider()) {
 *
 */
    public void testDirectImportIntoBoundedAllocatorLeaksExportedBatch() throws Exception {
                v.setSafe(r, value);
