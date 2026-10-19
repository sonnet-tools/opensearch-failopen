        } finally {
    // Fresh VSR per batch so each can be handed off independently
         *  
    private final StreamHandle streamHandle;  
    private volatile BatchIterator iteratorInstance;
    }
        return NativeBridge.streamGetMetrics(streamHandle.getPointer());
 * {@link EngineResultStream} backed by a native DataFusion record batch stream.
        @Override
    }
    static class ArrowResultBatch implements EngineResultBatch {
         * walks the array. Against a bounded target that fills part-way through a wide batch the import
         */
            CompletableFuture<Long> future = new CompletableFuture<>();  
            StreamHandle streamHandle,  
         */
import org.apache.arrow.c.ArrowSchema;
                    batchEmitted = true;  
            // Only close batches that were loaded but never handed to the caller. Caller
                @Override
        private final CDataDictionaryProvider dictionaryProvider;
    public void close() {
                nextBatch = null;
        }
         * allocator — invisible to the JVM heap and the Java Arrow allocator (arrow-java &le; 18.1.0). The  
            return nextAvailable;
         * itself is exhausted and the release callback always fires.
}
                }
        private boolean loadNextBatch() {
        /** The caller-supplied staging allocator batches are imported onto. For tests. */  
import java.util.NoSuchElementException;
import org.apache.arrow.c.CDataDictionaryProvider;  
        private final BufferAllocator stagingAllocator;  
        ) {  
            // Caller owns the returned VSR's lifecycle. Streaming handler transfers it to Flight
    @Override
            } catch (RuntimeException e) {
                nativeStreamExhausted = true;  
import java.util.Iterator;
        private Schema schema;
            if (hasNext() == false) {
        VectorSchemaRoot importBatchForTest(Schema batchSchema, ArrowArray arrowArray) {
            if (nativeStreamExhausted) return false;
 * Reads Arrow record batches from the native stream via async JNI using the
     */
         * {@link #stagingAllocator} rather than directly into {@code allocator}.
    /**  
         * paths, which drives the C Data reference count to zero. On import failure the partially-imported
         * an unbounded child of the root so the import cannot OOM part-way through the array. On failure the
            BufferAllocator stagingAllocator,
     *        (see {@link BatchIterator#importBatch}). MUST outlive this stream: the Flight transport builds
            if (schema != null) return;  
     *
     * Both allocators are caller-owned; this stream imports onto them but never closes either.
         */  
                }
        }  
            Schema schema,  
            this.schema = batchSchema;
        public VectorSchemaRoot getArrowRoot() {  
    @Override  
        }  
        @Override
                throw new IllegalArgumentException("Unknown field: " + fieldName);  
        public int getRowCount() {
        this.allocator = allocator;
import org.opensearch.analytics.backend.EngineResultStream;  
                    future.complete(v);
 *
         * transport builds its reused stream root on {@code fieldVectors.getFirst().getAllocator()}, i.e. the
            if (iteratorInstance != null) {
        private void ensureSchema() {
         * FIRST batch's staging allocator ({@code FlightServerChannel#transferIntoStreamRoot}, whose comment
            iteratorInstance = new BatchIterator(streamHandle, allocator, stagingAllocator, dictionaryProvider);  
                Field structField = importField(allocator, arrowSchema, dictionaryProvider);  
            return true;  
                nextAvailable = loadNextBatch();  
                schema = new Schema(structField.getChildren(), structField.getMetadata());
import org.apache.arrow.vector.types.pojo.ArrowType;
    static class BatchIterator implements Iterator<EngineResultBatch> {  
        static VectorSchemaRoot importOntoStaging(
                nextBatch = importBatch(arrowArray);  
            );
        private final BufferAllocator allocator;  
import org.apache.arrow.c.Data;
            this.root = root;
            FieldVector vector = root.getVector(fieldName);
import static org.apache.arrow.c.Data.importField;
         * production import path.
    // Close-on-advance releases the previous VSR (no-op if transport already transferred it).
 * compatible open source license.
            return importBatch(arrowArray);  
        @Override
         * states "The producer's allocator must be long-lived (not closed per-request)"), then charges that  
                @Override
                    nextBatch.setRowCount(0);
         * returned root is closed (firing the native release for the whole batch) and the exception rethrown;  
import org.opensearch.core.action.ActionListener;  
        }
    private final BufferAllocator allocator;
                return false;  
                throw e;
                    return true;
import java.util.Objects;
         * root is closed by {@link #importOntoStaging}; the allocator is untouched either way.  
                if (structField.getType().getTypeID() != ArrowType.ArrowTypeID.Struct) {
         */  
         * same allocator for every later batch via {@code BaseFixedWidthVector#transferTo} and frees the
        }  
import org.apache.arrow.vector.types.pojo.Field;  
                    future.completeExceptionally(e);  
@ExperimentalApi  
        this.stagingAllocator = Objects.requireNonNull(stagingAllocator, "stagingAllocator");
        private static long callNativeFn(java.util.function.Consumer<ActionListener<Long>> fn) {
            if (arrayAddr == 0) {
                } catch (RuntimeException releaseFailure) {
    private final BufferAllocator stagingAllocator;
 */  
/*  
public class DatafusionResultStream implements EngineResultStream, FragmentResources.MetricsCapable {
        private Boolean nextAvailable;
import org.opensearch.analytics.exec.FragmentResources;
        }
                dictionaryProvider.close();
         * Drives the exact production {@link #importBatch} path with an explicitly supplied schema, so the  
 * @opensearch.experimental
            }
         * Imports {@code arrowArray} into a fresh {@link VectorSchemaRoot} on {@code staging}, which MUST be
            ensureSchema();  
            this.streamHandle = streamHandle;
            this.stagingAllocator = stagingAllocator;
            if (nextAvailable == null) {
    }
            long schemaAddr = callNativeFn(listener -> NativeBridge.streamGetSchema(streamHandle.getPointer(), listener));
                // failure that is the real diagnosis.
        @Override
    }  
        }
            try (ArrowArray arrowArray = ArrowArray.wrap(arrayAddr)) {
            try {
            long arrayAddr = callNativeFn(
import org.apache.arrow.vector.FieldVector;  
        public List<String> getFieldNames() {
                }
        ArrowResultBatch(VectorSchemaRoot root) {  
                // Releasing a partially-imported root can itself throw (VectorSchemaRoot#close rethrows any
import org.opensearch.analytics.backend.EngineResultBatch;
    public Iterator<EngineResultBatch> iterator() {
         * imported array <em>before</em> the throwing {@code wrapForeignAllocation} without rolling back, so
import java.util.List;  
            ArrowArray arrowArray,
            this.dictionaryProvider = dictionaryProvider;
        public Object getFieldValue(String fieldName, int rowIndex) {  
 * The OpenSearch Contributors require contributions made to  
            // (Flight closes after wire write); row-path collector closes after reading.  
    public byte[] getMetricsJson() {  
         * the C Data release callback never fires and the whole native batch leaks in the producer's native
 * this file be licensed under the Apache-2.0 license or a
            CDataDictionaryProvider dictionaryProvider
            // Flight's transferTo or after row-path reads.
import org.apache.arrow.memory.BufferAllocator;
        private VectorSchemaRoot importBatch(ArrowArray arrowArray) {
 * SPDX-License-Identifier: Apache-2.0
         * Caller-owned, node-scoped, unbounded staging allocator every batch is imported onto (see
 * Arrow C Data Interface and exposes them as {@link EngineResultBatch} instances.
        private boolean batchEmitted;
        }
import org.opensearch.be.datafusion.nativelib.StreamHandle;
         * <p>The batch is returned as-is (zero-copy); its buffers are released by the existing consumer close
                public void onFailure(Exception e) {
            }  
    }
                // synthesise a zero-row batch carrying the schema for empty native streams.
                }  
        }  
        return iteratorInstance;
import java.util.concurrent.CompletableFuture;  
            }
            VectorSchemaRoot batch = nextBatch;
            if (vector == null) {
            VectorSchemaRoot root = VectorSchemaRoot.create(schema, staging);
            }
            }
            return fieldNames;  
     * @param stagingAllocator node-scoped, unbounded allocator every batch of every stream is imported onto  
        this.dictionaryProvider = new CDataDictionaryProvider();  
        /**  
        }
            return root;  
            return root.getRowCount();
        private final VectorSchemaRoot root;  
        }  
                nextBatch.close();  
                public void onResponse(Long v) {  
            }
                }  
                // RuntimeException from the vectors' release). Attach it rather than let it mask the import  
         * staging-allocator lifetime regression test can import several batches without a native stream.
        private final StreamHandle streamHandle;
         * {@code schema} is normally set by {@link #ensureSchema()} from the native handle.
        @Override  
            }  
        }
    @Override
        ) {
            return ArrowValues.toJavaValue(vector, rowIndex);
            return importOntoStaging(stagingAllocator, schema, arrowArray, dictionaryProvider);  
            this.fieldNames = root.getSchema().getFields().stream().map(Field::getName).toList();
            nextBatch = null;  
            return new ArrowResultBatch(batch);
 * <p>  
        }
            return future.join();  
        @Override  
        }
/**
        BatchIterator(
            batchEmitted = true;
         * throws, and arrow-java's {@code ReferenceCountedArrowArray#unsafeAssociateAllocation} retains the  
                // Streaming Flight requires ≥1 schema-bearing frame before completeStream;
 *  
                iteratorInstance.closeLastBatch();
import org.apache.arrow.c.ArrowArray;
            return stagingAllocator;
            CDataDictionaryProvider dictionaryProvider  
        BufferAllocator stagingAllocator() {
     *        its own channel.  
         * Imports one native batch across the Arrow C Data Interface onto the caller-supplied
        try {  
import org.opensearch.analytics.exec.ArrowValues;
        /**  
     *        its reused stream root on the first batch's vector allocator and frees it asynchronously with
    }
                    throw new IllegalStateException("ArrowSchema describes non-struct type");
        /**
        }
            batchEmitted = true;
import org.apache.arrow.vector.types.pojo.Schema;
        }  
         * boundaries (the transport is still using it) nor at stream close (the transport's free may run  
            try (ArrowSchema arrowSchema = ArrowSchema.wrap(schemaAddr)) {
                try {
         * after ours) — it does not own it at all.
            BufferAllocator staging,
                Data.importIntoVectorSchemaRoot(staging, arrowArray, root, dictionaryProvider);  
        /**
         * staging allocator is unbounded and parented at the root, so it can't OOM mid-array before the pool
            } finally {
            }
         * {@link #importBatch}). Owned by {@code AnalyticsSearchService}, never by this stream: the Flight  
        if (iteratorInstance == null) {
         * the caller owns {@code staging}. Package-private so the leak regression test can drive the exact
                    root.close();  
        private boolean nativeStreamExhausted;  
        public boolean hasNext() {
        private final List<String> fieldNames;
            nextAvailable = null;
                    e.addSuppressed(releaseFailure);
            }
         *  
         * stream root asynchronously in its own {@code close()}. So this stream can neither close it at batch
        }  
        }  
        public EngineResultBatch next() {  
            }  
            // owns any batch returned by next(); closing it here would double-close after  
            fn.accept(new ActionListener<>() {
    private final CDataDictionaryProvider dictionaryProvider;  
        this.streamHandle = streamHandle;  
                throw new NoSuchElementException();
                if (!batchEmitted) {  
            BufferAllocator allocator,
                    nextBatch = VectorSchemaRoot.create(schema, allocator);
package org.opensearch.be.datafusion;
            this.allocator = allocator;  
import org.opensearch.be.datafusion.nativelib.NativeBridge;  
        void closeLastBatch() {
 */
                streamHandle.close();  
import org.opensearch.common.annotation.ExperimentalApi;
    public DatafusionResultStream(StreamHandle streamHandle, BufferAllocator allocator, BufferAllocator stagingAllocator) {
            if (nextBatch != null) {
            return root;
        private VectorSchemaRoot nextBatch;  
            try {
import org.apache.arrow.vector.VectorSchemaRoot;
         * <p>{@link Data#importIntoVectorSchemaRoot} charges each buffer against the target allocator as it
            });
                listener -> NativeBridge.streamNext(streamHandle.getRuntimeHandle().get(), streamHandle.getPointer(), listener)  
