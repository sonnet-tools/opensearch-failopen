        ArrowSchema cSchema = ArrowSchema.allocateNew(producer);  
 * released even when the caller's allocator is far too small — this test fails on the unfixed direct-import  
    public void testDirectImportIntoBoundedAllocatorLeaksExportedBatch() throws Exception {
     * fails, so this is a genuine regression guard.
                imported.close();                 // consumer releases the batch → C Data release fires  
        Exception thrown = expectThrows(Exception.class, () -> Data.importIntoVectorSchemaRoot(tinyTarget, array, target, dp));  
 * this file be licensed under the Apache-2.0 license or a
                VectorSchemaRoot imported = DatafusionResultStream.BatchIterator.importOntoStaging(staging, schema, array, dp);
            exportBatch(producer, array, cSchema);  
 * production path ({@link DatafusionResultStream.BatchIterator#importOntoStaging}) and asserts the batch is
        root.close();
import org.apache.arrow.memory.RootAllocator;
 *
     * leaks — the producer allocator is not drained because the C Data release callback never fires.  
        byte[] value = new byte[VALUE_BYTES];  
 * code and passes with the staging import.
 * Regression tests for the native batch leak on Arrow C Data Interface import under allocator pressure.
        VectorSchemaRoot source = buildBatch(alloc);
            }  
}
 * compatible open source license.
    }
            for (FieldVector v : source.getFieldVectors()) {
import org.apache.arrow.c.ArrowSchema;
        super.setUp();
    private static final int COLUMNS = 4;
        BufferAllocator tinyTarget = localRoot.newChildAllocator("tiny-target-direct", 0, TINY_LIMIT);  
            tinyTarget.close();  
    private static final int VALUE_BYTES = 512;  
     * unbounded staging child of the root, so a caller allocator far too small to hold the batch does not
                return true;
    private void exportBatch(BufferAllocator alloc, ArrowArray array, ArrowSchema cSchema) {  
        BufferAllocator producer = root.newChildAllocator("producer", 0, Long.MAX_VALUE);
    public void setUp() throws Exception {
    public void tearDown() throws Exception {
        assertTrue("mid-import failure must be an allocator OOM, was: " + thrown, hasOomCause(thrown));
import org.apache.arrow.c.Data;
            assertTrue("producer holds the exported batch before import", producer.getAllocatedMemory() > 0);
            try (CDataDictionaryProvider dp = new CDataDictionaryProvider()) {  
            BufferAllocator staging = tinyTarget.getRoot().newChildAllocator("datafusion-import-staging", 0, Long.MAX_VALUE);
        VectorSchemaRoot target = VectorSchemaRoot.create(schema, tinyTarget);  
        try {
        producer.close();  
 * directly into a bounded allocator throws {@link OutOfMemoryException} mid-array and strands the whole  
 * exported buffers — when import releases the C Data array the producer drains to zero; when it leaks the
import java.util.Arrays;  
        BufferAllocator producer = localRoot.newChildAllocator("producer-direct", 0, Long.MAX_VALUE);
public class DatafusionImportLeakTests extends OpenSearchTestCase {  
        return false;
        for (int c = 0; c < COLUMNS; c++) {  
    }
            fieldVectors.add(v);
                total += v.getBufferSize();
            BufferAllocator tinyTarget = root.newChildAllocator("tiny-target", 0, TINY_LIMIT);
        try (ArrowArray array = ArrowArray.allocateNew(producer); ArrowSchema cSchema = ArrowSchema.allocateNew(producer)) {
            source.close();
        // Dedicated local root, deliberately abandoned: this test demonstrates the arrow-java leak, so the  
        root = new RootAllocator(Long.MAX_VALUE);  
    }
import org.apache.arrow.c.ArrowArray;
/**  
     */
    }
        }
        exportBatch(producer, array, cSchema);
    public void testProductionStagingImportReleasesBatch() throws Exception {  
        }
                Schema schema = Data.importSchema(staging, cSchema, dp);
     * bounded allocator (the pre-fix behaviour) throws {@link OutOfMemoryException} mid-array <b>and</b>
 */
        // C-Data release, so no close would succeed. localRoot is abandoned; the JVM reclaims the wrappers.
            staging.close();
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.c.CDataDictionaryProvider;  
    private static boolean hasOomCause(Throwable t) {
 * <p>Self-contained (no native runtime): a batch is built on a "producer" allocator and exported across  
    /** True if {@code t} is, or is caused by, an Arrow {@link OutOfMemoryException}. */
        // ("Could not load buffers for field ...") with the OutOfMemoryException as its cause.
        for (Throwable c = t; c != null; c = c.getCause()) {  
import org.opensearch.test.OpenSearchTestCase;  
            // Stand-in for the caller allocator: intentionally far smaller than the batch.  
    private RootAllocator root;
        List<FieldVector> fieldVectors = new ArrayList<>(COLUMNS);
            assertTrue("test setup: batch must exceed the tiny target limit", total > TINY_LIMIT);
import org.apache.arrow.vector.VarCharVector;  
     *
import org.apache.arrow.vector.FieldVector;
 *
        // Nothing is closed: the mid-import OOM strands buffers on producer and target and never fires the  
    /**  
 * <p>{@link #testDirectImportIntoBoundedAllocatorLeaksExportedBatch} pins the arrow-java bug: importing
    @Override  
import org.apache.arrow.vector.VectorSchemaRoot;
    private static final int ROWS = 4096;
     * cause a mid-import OOM; the batch imports, and closing it releases the exported buffers — the producer  
        // producer/target/C-Data structs cannot be drained or closed. Keeping it off the shared #root (and
            for (int r = 0; r < ROWS; r++) {  
        Schema schema = Data.importSchema(tinyTarget, cSchema, dp);
            }  
        return new VectorSchemaRoot(fieldVectors);  
            if (c instanceof OutOfMemoryException) {
        // never closing anything here) avoids tripping the allocator leak detector on this expected leak.
     */
            VarCharVector v = new VarCharVector("col" + c, alloc);
     * Production path: {@link DatafusionResultStream.BatchIterator#importOntoStaging} imports onto an
package org.opensearch.be.datafusion;
import java.util.ArrayList;
 * SPDX-License-Identifier: Apache-2.0
 */  
 * The OpenSearch Contributors require contributions made to  
        // importIntoVectorSchemaRoot wraps the allocator OOM as IllegalArgumentException
            }
            }
 * producer stays non-zero.  
        }
        ArrowArray array = ArrowArray.allocateNew(producer);
import org.apache.arrow.vector.types.pojo.Schema;
    private VectorSchemaRoot buildBatch(BufferAllocator alloc) {
        Arrays.fill(value, (byte) 'x');
            v.allocateNew((long) ROWS * VALUE_BYTES, ROWS);
        super.tearDown();  
    @Override  
        CDataDictionaryProvider dp = new CDataDictionaryProvider();
     * <p>On the unfixed code (import directly into the bounded caller allocator) this leaks and the assertion  
 *
    }
            v.setValueCount(ROWS);  
        } finally {  
                v.setSafe(r, value);
        RootAllocator localRoot = new RootAllocator(Long.MAX_VALUE);  
        }
     * allocator drains to zero.
    /**  
            long total = 0;  
        assertEquals("staging import must release the exported batch (producer drained)", 0L, producer.getAllocatedMemory());
    }  
 * exported batch (producer not drained). {@link #testProductionStagingImportReleasesBatch} drives the
            Data.exportVectorSchemaRoot(alloc, source, null, array, cSchema);
/*  
 * the C Data Interface. The producer allocator stands in for the native (Rust) allocator that owns the
import java.util.List;
        assertTrue("arrow-java strands the exported batch on a mid-import OOM (producer not drained)", producer.getAllocatedMemory() > 0);
import org.apache.arrow.memory.OutOfMemoryException;  
     * Pins the arrow-java bug this fix works around: importing the exported batch <em>directly</em> into a
    /** Builds a multi-column VarChar batch on {@code alloc} and exports it into {@code array}/{@code cSchema}. */
    }  
    private static final long TINY_LIMIT = 64 * 1024; // far smaller than the ~8 MB batch
