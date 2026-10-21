        void closeLastBatch() {
            FieldVector vector = root.getVector(fieldName);
        private VectorSchemaRoot importBatch() {
            }
 * <p>Today's only producer is the count fast path (one batch per shard), but the class
import org.opensearch.analytics.backend.EngineResultStream;
        } finally {
         * parented at the root, so it can't OOM mid-array before the pool itself is exhausted and the release
         * {@link #stagingAllocator} rather than directly into {@code allocator}.
                Data.importIntoVectorSchemaRoot(stagingAllocator, arrowArray, root, dictionaryProvider);
 * The OpenSearch Contributors require contributions made to
        @Override
            } catch (RuntimeException e) {
         * Caller-owned, node-scoped, unbounded staging allocator the batch is imported onto (see
        }
 * scratch VSR through the C-Data interface so the resulting buffer layout matches the
    /**
            } finally {
        }
            return fieldNames;
    private final ArrowSchema arrowSchema;
                arrowArray.close();
@ExperimentalApi
            }
            iteratorInstance = new BatchIterator(arrowArray, arrowSchema, allocator, stagingAllocator, dictionaryProvider);
    static class ArrowResultBatch implements EngineResultBatch {
            batchEmitted = true;
         * same allocator for every later batch and frees the stream root asynchronously in its own
     * same {@link Data#importIntoVectorSchemaRoot} call to populate a fresh
import org.apache.arrow.vector.VectorSchemaRoot;
                try {
        }
     */
            if (vector == null) {
            this.fieldNames = root.getSchema().getFields().stream().map(Field::getName).toList();
    @Override
                // and untouched. The release can itself throw (VectorSchemaRoot#close rethrows any
        @Override
    /**
/*
    private final CDataDictionaryProvider dictionaryProvider;
            this.allocator = allocator;
            try {
        private Boolean nextAvailable;
            return root.getRowCount();
                throw e;
         * transport builds its reused stream root on {@code fieldVectors.getFirst().getAllocator()}, i.e. the
            }
    public void close() {
     * {@link VectorSchemaRoot}, same emit-then-exhaust contract.
     */
            return nextAvailable;
     * @param stagingAllocator node-scoped, unbounded allocator the batch is imported onto (see
        ArrowResultBatch(VectorSchemaRoot root) {
         * throws, and arrow-java's {@code ReferenceCountedArrowArray#unsafeAssociateAllocation} retains the
            if (structField.getType().getTypeID() != ArrowType.ArrowTypeID.Struct) {
                }
 * {@link BatchIterator} pump, same {@link ArrowResultBatch} wrapper, same
        public boolean hasNext() {
    private volatile BatchIterator iteratorInstance;
import org.apache.arrow.memory.BufferAllocator;
         * outlives this stream (see {@link #stagingAllocator}), so nothing here closes it.
        }
         *
        private Schema schema;
            CDataDictionaryProvider dictionaryProvider
            if (nextBatch != null) {
            // (Flight closes after wire write); row-path collector closes after reading.
        try {
            return ArrowValues.toJavaValue(vector, rowIndex);
        private final VectorSchemaRoot root;
         */
                // RuntimeException from the vectors); attach it rather than let it mask the import failure
                iteratorInstance.closeLastBatch();
                    arrowSchema.close();
import org.apache.arrow.c.ArrowSchema;
        private final CDataDictionaryProvider dictionaryProvider;
import org.opensearch.common.annotation.ExperimentalApi;
import org.apache.arrow.c.CDataDictionaryProvider;
        /**
 * this file be licensed under the Apache-2.0 license or a
    public LuceneResultStream(ArrowArray arrowArray, ArrowSchema arrowSchema, BufferAllocator allocator, BufferAllocator stagingAllocator) {
import java.util.Iterator;
        }
    }
        public EngineResultBatch next() {
         * walks the array. Against a bounded target that fills part-way through a wide batch the import
    }
            }
        @Override
            // Flight's transferTo or after row-path reads.
        public Object getFieldValue(String fieldName, int rowIndex) {
            return root;
            Field structField = importField(allocator, arrowSchema, dictionaryProvider);
 * foreign-allocation-managed shape that survives Flight's {@code VectorTransfer.transferRoot}.
    private final BufferAllocator allocator;
 * {@link Data#importIntoVectorSchemaRoot} call to materialise each batch into a fresh
         * imported array <em>before</em> the throwing {@code wrapForeignAllocation} without rolling back, so
        private final BufferAllocator stagingAllocator;
import java.util.List;
 *
        private final ArrowArray arrowArray;
            }
         * callback always fires.
            this.dictionaryProvider = dictionaryProvider;
    @Override
            batchEmitted = true;
import org.apache.arrow.vector.types.pojo.ArrowType;
}
package org.opensearch.be.lucene;
            ArrowArray arrowArray,
    /** C-Data schema describing {@link #arrowArray}. */
     * Single-batch iterator. Mirrors
            // Only close batches that were loaded but never handed to the caller. Caller
        private VectorSchemaRoot nextBatch;
            }
            if (schema != null) return;
        BatchIterator(
            if (exhausted) return false;
            // owns any batch returned by next(); closing it here would double-close after
    private final ArrowArray arrowArray;
            }
        /**
        public int getRowCount() {
        this.arrowArray = arrowArray;
        private final BufferAllocator allocator;
            nextBatch = null;
            nextBatch = importBatch();
 * {@link VectorSchemaRoot}. The only difference is the source of the {@link ArrowArray}:
        ) {
            if (nextAvailable == null) {
    private final BufferAllocator stagingAllocator;
import java.util.Objects;
            exhausted = true;
        private void ensureSchema() {
        return iteratorInstance;
        this.dictionaryProvider = new CDataDictionaryProvider();
        public VectorSchemaRoot getArrowRoot() {
                } catch (RuntimeException releaseFailure) {
import org.apache.arrow.vector.types.pojo.Field;
         * {@code close()} — which may run after ours.
            if (hasNext() == false) {
        if (iteratorInstance == null) {
        private final List<String> fieldNames;
                    root.close();
                // Close the partially-imported root (fires the native release); the allocator is caller-owned
            // Caller owns the returned VSR's lifecycle. Streaming handler transfers it to Flight
         * <p>{@link Data#importIntoVectorSchemaRoot} charges each buffer against the target allocator as it
 * itself is operation-agnostic — any future Lucene-driver result that fits a single
        this.arrowSchema = arrowSchema;
import org.opensearch.analytics.exec.ArrowValues;
import org.apache.arrow.vector.types.pojo.Schema;
         * heap and the Java Arrow allocator (arrow-java &le; 18.1.0). The staging allocator is unbounded and
     * {@code DatafusionResultStream.BatchIterator#loadNextBatch} — same lazy schema import,
                    e.addSuppressed(releaseFailure);
 *
        private boolean batchEmitted;
 * pre-built {@code ArrowArray} reuses this stream.
                // that is the real diagnosis.
         */
            return new ArrowResultBatch(batch);
        }
 * Lucene-side {@link EngineResultStream}. Mirrors {@code DatafusionResultStream}: same
import org.apache.arrow.c.ArrowArray;
    }
         * FIRST batch's staging allocator ({@code FlightServerChannel#transferIntoStreamRoot}, whose comment
            if (iteratorInstance != null) {
                    dictionaryProvider.close();
        private boolean exhausted;
        }
                throw new NoSuchElementException();
        }
            }
        public List<String> getFieldNames() {
        this.stagingAllocator = Objects.requireNonNull(stagingAllocator, "stagingAllocator");
            return true;
        }
         *
         * paths, which drives the C Data reference count to zero. The staging allocator is caller-owned and
            ensureSchema();
        private final ArrowSchema arrowSchema;
     * closes them in {@link #close}. Both allocators stay caller-owned.
     * Caller hands over ownership of {@code arrowArray} and {@code arrowSchema}; this stream
            try {
         * states "The producer's allocator must be long-lived (not closed per-request)"), then charges that
     *        {@link BatchIterator#importBatch}). MUST outlive this stream: the Flight transport builds its
            VectorSchemaRoot batch = nextBatch;
import org.apache.arrow.c.Data;
            ArrowSchema arrowSchema,
        @Override
import java.util.NoSuchElementException;
        this.allocator = allocator;
         * the C Data release callback never fires and the whole native batch leaks — invisible to the JVM
                nextBatch.close();
 *
            schema = new Schema(structField.getChildren(), structField.getMetadata());
            return root;
            BufferAllocator stagingAllocator,
 */
 * SPDX-License-Identifier: Apache-2.0
        @Override
        @Override
         * Imports the batch across the Arrow C Data Interface onto the caller-supplied
                }
                throw new IllegalStateException("ArrowSchema describes non-struct type");
     *
import static org.apache.arrow.c.Data.importField;
/**
            nextAvailable = null;
                throw new IllegalArgumentException("Unknown field: " + fieldName);
    static class BatchIterator implements Iterator<EngineResultBatch> {
         * <p>The batch is returned as-is (zero-copy); its buffers are released by the existing consumer close
     *        own channel.
    }
        }
                try {
import org.apache.arrow.vector.FieldVector;
            this.arrowArray = arrowArray;
 */
        }
            this.arrowSchema = arrowSchema;
                nextAvailable = loadNextBatch();
            VectorSchemaRoot root = VectorSchemaRoot.create(schema, stagingAllocator);
                } finally {
            BufferAllocator allocator,
        }
    public Iterator<EngineResultBatch> iterator() {
            this.stagingAllocator = stagingAllocator;
public class LuceneResultStream implements EngineResultStream {
     *        reused stream root on the first batch's vector allocator and frees it asynchronously with its
        private boolean loadNextBatch() {
        }
import org.opensearch.analytics.backend.EngineResultBatch;
 * @opensearch.experimental
                nextBatch = null;
            this.root = root;
    }
        }
    /** C-Data array carrying the populated batch. Owned by this stream until {@link #close}. */
 * DataFusion gets it from a native record-batch stream (Rust → JNI), Lucene exports a
         * {@link #importBatch}). Owned by {@code AnalyticsSearchService}, never by this stream: the Flight
 * compatible open source license.
