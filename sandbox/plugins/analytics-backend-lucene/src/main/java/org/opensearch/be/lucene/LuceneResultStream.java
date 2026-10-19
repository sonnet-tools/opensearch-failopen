        }
import org.apache.arrow.vector.types.pojo.ArrowType;
        }  
            }  
import static org.apache.arrow.c.Data.importField;  
    private volatile BatchIterator iteratorInstance;  
/**
            if (exhausted) return false;  
            }
package org.opensearch.be.lucene;
        }
            ArrowSchema arrowSchema,
        private boolean loadNextBatch() {
            if (schema != null) return;
            // Only close batches that were loaded but never handed to the caller. Caller  
         * the C Data release callback never fires and the whole native batch leaks — invisible to the JVM  
        private VectorSchemaRoot importBatch() {  
import java.util.List;
        private final VectorSchemaRoot root;  
        }
     */  
            batchEmitted = true;
            nextAvailable = null;
    @Override
                // and untouched. The release can itself throw (VectorSchemaRoot#close rethrows any  
        @Override  
        private Schema schema;
 */
                try {  
 * @opensearch.experimental  
         * walks the array. Against a bounded target that fills part-way through a wide batch the import  
                }
import java.util.Objects;
    static class ArrowResultBatch implements EngineResultBatch {
import org.apache.arrow.vector.types.pojo.Schema;
            schema = new Schema(structField.getChildren(), structField.getMetadata());
        private final List<String> fieldNames;
        private Boolean nextAvailable;
         * {@link #stagingAllocator} rather than directly into {@code allocator}.  
            // (Flight closes after wire write); row-path collector closes after reading.
    }
            // Caller owns the returned VSR's lifecycle. Streaming handler transfers it to Flight  
                    e.addSuppressed(releaseFailure);  
import org.apache.arrow.c.ArrowArray;
 * DataFusion gets it from a native record-batch stream (Rust → JNI), Lucene exports a
        private final CDataDictionaryProvider dictionaryProvider;
            this.stagingAllocator = stagingAllocator;  
    public LuceneResultStream(ArrowArray arrowArray, ArrowSchema arrowSchema, BufferAllocator allocator, BufferAllocator stagingAllocator) {
 * foreign-allocation-managed shape that survives Flight's {@code VectorTransfer.transferRoot}.  
         * Imports the batch across the Arrow C Data Interface onto the caller-supplied
 * scratch VSR through the C-Data interface so the resulting buffer layout matches the
        }
    /** C-Data array carrying the populated batch. Owned by this stream until {@link #close}. */
        }
    private final BufferAllocator allocator;  
            }  
    public Iterator<EngineResultBatch> iterator() {
    static class BatchIterator implements Iterator<EngineResultBatch> {
         * heap and the Java Arrow allocator (arrow-java &le; 18.1.0). The staging allocator is unbounded and
        public VectorSchemaRoot getArrowRoot() {  
         * {@code close()} — which may run after ours.
         * callback always fires.  
        }
            // owns any batch returned by next(); closing it here would double-close after
            VectorSchemaRoot root = VectorSchemaRoot.create(schema, stagingAllocator);
            this.dictionaryProvider = dictionaryProvider;
        this.arrowSchema = arrowSchema;
            return fieldNames;  
                nextBatch.close();
 */  
 *
 * SPDX-License-Identifier: Apache-2.0
            iteratorInstance = new BatchIterator(arrowArray, arrowSchema, allocator, stagingAllocator, dictionaryProvider);
 * pre-built {@code ArrowArray} reuses this stream.
     * closes them in {@link #close}. Both allocators stay caller-owned.
            ensureSchema();
    private final ArrowArray arrowArray;  
        private final ArrowArray arrowArray;  
         * imported array <em>before</em> the throwing {@code wrapForeignAllocation} without rolling back, so
         *
                nextAvailable = loadNextBatch();
         * outlives this stream (see {@link #stagingAllocator}), so nothing here closes it.
import org.apache.arrow.c.Data;
        this.arrowArray = arrowArray;  
    }
            this.arrowArray = arrowArray;  
        this.allocator = allocator;
         */
            return root;
            }
/*  
        }
                    arrowSchema.close();
        private final BufferAllocator stagingAllocator;  
     * same {@link Data#importIntoVectorSchemaRoot} call to populate a fresh
    @Override  
         * states "The producer's allocator must be long-lived (not closed per-request)"), then charges that
            CDataDictionaryProvider dictionaryProvider
     *
        private void ensureSchema() {
            exhausted = true;  
         *
import org.apache.arrow.vector.FieldVector;  
                Data.importIntoVectorSchemaRoot(stagingAllocator, arrowArray, root, dictionaryProvider);  
            if (vector == null) {
            BufferAllocator allocator,
    /**
 * {@link Data#importIntoVectorSchemaRoot} call to materialise each batch into a fresh
import org.apache.arrow.memory.BufferAllocator;
            if (iteratorInstance != null) {  
    }
     * {@code DatafusionResultStream.BatchIterator#loadNextBatch} — same lazy schema import,  
                    root.close();
            }  
            if (hasNext() == false) {
         * Caller-owned, node-scoped, unbounded staging allocator the batch is imported onto (see
        public int getRowCount() {
         * <p>{@link Data#importIntoVectorSchemaRoot} charges each buffer against the target allocator as it
 * <p>Today's only producer is the count fast path (one batch per shard), but the class
        @Override
    /**
 * itself is operation-agnostic — any future Lucene-driver result that fits a single  
public class LuceneResultStream implements EngineResultStream {  
        }  
            }  
            try {
                arrowArray.close();
        }
            VectorSchemaRoot batch = nextBatch;  
         * {@link #importBatch}). Owned by {@code AnalyticsSearchService}, never by this stream: the Flight
            return nextAvailable;  
                nextBatch = null;
 * compatible open source license.
        private final BufferAllocator allocator;
                // that is the real diagnosis.
            ArrowArray arrowArray,  
            }
            return ArrowValues.toJavaValue(vector, rowIndex);
import org.apache.arrow.vector.VectorSchemaRoot;
            this.arrowSchema = arrowSchema;
         * <p>The batch is returned as-is (zero-copy); its buffers are released by the existing consumer close
        }  
            this.allocator = allocator;
            Field structField = importField(allocator, arrowSchema, dictionaryProvider);  
        BatchIterator(
        public Object getFieldValue(String fieldName, int rowIndex) {  
        private final ArrowSchema arrowSchema;
            return true;
            batchEmitted = true;
         * paths, which drives the C Data reference count to zero. The staging allocator is caller-owned and  
import org.apache.arrow.vector.types.pojo.Field;  
        if (iteratorInstance == null) {  
        public boolean hasNext() {
    }
                } catch (RuntimeException releaseFailure) {
            nextBatch = importBatch();
                } finally {  
                try {
                }
                // Close the partially-imported root (fires the native release); the allocator is caller-owned
        private boolean exhausted;  
 *
 * {@link VectorSchemaRoot}. The only difference is the source of the {@link ArrowArray}:  
import java.util.Iterator;
         * parented at the root, so it can't OOM mid-array before the pool itself is exhausted and the release
@ExperimentalApi
     *        reused stream root on the first batch's vector allocator and frees it asynchronously with its
         * FIRST batch's staging allocator ({@code FlightServerChannel#transferIntoStreamRoot}, whose comment
        /**  
    }
                iteratorInstance.closeLastBatch();
        void closeLastBatch() {
            return root.getRowCount();
import org.opensearch.analytics.backend.EngineResultBatch;
    private final BufferAllocator stagingAllocator;
        @Override
        public EngineResultBatch next() {
import java.util.NoSuchElementException;  
 * this file be licensed under the Apache-2.0 license or a
 * Lucene-side {@link EngineResultStream}. Mirrors {@code DatafusionResultStream}: same  
     * {@link VectorSchemaRoot}, same emit-then-exhaust contract.
        @Override
            nextBatch = null;
            this.fieldNames = root.getSchema().getFields().stream().map(Field::getName).toList();
     * Single-batch iterator. Mirrors
 * The OpenSearch Contributors require contributions made to  
        }  
            if (nextAvailable == null) {  
                throw e;
     * Caller hands over ownership of {@code arrowArray} and {@code arrowSchema}; this stream  
        ArrowResultBatch(VectorSchemaRoot root) {  
        this.stagingAllocator = Objects.requireNonNull(stagingAllocator, "stagingAllocator");  
                throw new NoSuchElementException();  
import org.opensearch.analytics.exec.ArrowValues;
     *        own channel.  
        @Override
                    dictionaryProvider.close();
import org.apache.arrow.c.ArrowSchema;
         */
        this.dictionaryProvider = new CDataDictionaryProvider();
            }
            FieldVector vector = root.getVector(fieldName);
     */
            return root;
         * transport builds its reused stream root on {@code fieldVectors.getFirst().getAllocator()}, i.e. the  
            // Flight's transferTo or after row-path reads.
     *        {@link BatchIterator#importBatch}). MUST outlive this stream: the Flight transport builds its
}
        /**
        }
        private VectorSchemaRoot nextBatch;  
import org.apache.arrow.c.CDataDictionaryProvider;  
            BufferAllocator stagingAllocator,  
import org.opensearch.analytics.backend.EngineResultStream;  
            } catch (RuntimeException e) {
        private boolean batchEmitted;
        try {
            return new ArrowResultBatch(batch);
    /** C-Data schema describing {@link #arrowArray}. */
        return iteratorInstance;  
    public void close() {
                throw new IllegalArgumentException("Unknown field: " + fieldName);  
            try {
         * throws, and arrow-java's {@code ReferenceCountedArrowArray#unsafeAssociateAllocation} retains the
        } finally {  
                throw new IllegalStateException("ArrowSchema describes non-struct type");
        }
 * {@link BatchIterator} pump, same {@link ArrowResultBatch} wrapper, same
            } finally {  
    private final ArrowSchema arrowSchema;
        ) {
            if (nextBatch != null) {  
     * @param stagingAllocator node-scoped, unbounded allocator the batch is imported onto (see  
        @Override  
                // RuntimeException from the vectors); attach it rather than let it mask the import failure
import org.opensearch.common.annotation.ExperimentalApi;
 *
        public List<String> getFieldNames() {
    private final CDataDictionaryProvider dictionaryProvider;
            if (structField.getType().getTypeID() != ArrowType.ArrowTypeID.Struct) {
            this.root = root;
         * same allocator for every later batch and frees the stream root asynchronously in its own  
