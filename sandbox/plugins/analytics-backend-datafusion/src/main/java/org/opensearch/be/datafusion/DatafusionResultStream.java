        private final StreamHandle streamHandle;
        static VectorSchemaRoot importOntoStaging(
            try {
                    return true;
        /**
                }
            BufferAllocator staging,
        private final BufferAllocator allocator;
 * Arrow C Data Interface and exposes them as {@link EngineResultBatch} instances.
            // owns any batch returned by next(); closing it here would double-close after
        /**
         * <p>The batch is returned as-is (zero-copy); its buffers are released by the existing consumer close
import org.opensearch.be.datafusion.nativelib.StreamHandle;
            this.streamHandle = streamHandle;
         * throws, and arrow-java's {@code ReferenceCountedArrowArray#unsafeAssociateAllocation} retains the
            return root.getRowCount();
            // Only close batches that were loaded but never handed to the caller. Caller
         * walks the array. Against a bounded target that fills part-way through a wide batch the import
        private VectorSchemaRoot importBatch(ArrowArray arrowArray) {
         * {@code schema} is normally set by {@link #ensureSchema()} from the native handle.
 *
                streamHandle.close();
        } finally {
            }
         */
        private void ensureSchema() {
         * an unbounded child of the root so the import cannot OOM part-way through the array. On failure the
        }
            }
                nextAvailable = loadNextBatch();
                public void onFailure(Exception e) {
        private static long callNativeFn(java.util.function.Consumer<ActionListener<Long>> fn) {
        /**
                    future.complete(v);
            if (arrayAddr == 0) {
         * itself is exhausted and the release callback always fires.
            if (nextAvailable == null) {
        private final BufferAllocator stagingAllocator;
                @Override
                public void onResponse(Long v) {
        }
    private final CDataDictionaryProvider dictionaryProvider;
        }
import static org.apache.arrow.c.Data.importField;
/**
         * {@link #importBatch}). Owned by {@code AnalyticsSearchService}, never by this stream: the Flight
            } finally {
         * allocator — invisible to the JVM heap and the Java Arrow allocator (arrow-java &le; 18.1.0). The
                listener -> NativeBridge.streamNext(streamHandle.getRuntimeHandle().get(), streamHandle.getPointer(), listener)
            }
import java.util.Iterator;
                    e.addSuppressed(releaseFailure);
        }
                nativeStreamExhausted = true;
            }
        @Override
                try {
        BatchIterator(
            try (ArrowSchema arrowSchema = ArrowSchema.wrap(schemaAddr)) {
 * compatible open source license.
            batchEmitted = true;
         *
         * Imports one native batch across the Arrow C Data Interface onto the caller-supplied
    public void close() {
            }
 * {@link EngineResultStream} backed by a native DataFusion record batch stream.
            this.stagingAllocator = stagingAllocator;
            long arrayAddr = callNativeFn(
        if (iteratorInstance == null) {
         * Drives the exact production {@link #importBatch} path with an explicitly supplied schema, so the
     *        (see {@link BatchIterator#importBatch}). MUST outlive this stream: the Flight transport builds
            }
        private Boolean nextAvailable;
                throw e;
            iteratorInstance = new BatchIterator(streamHandle, allocator, stagingAllocator, dictionaryProvider);
        this.streamHandle = streamHandle;
    private final BufferAllocator allocator;
            return importBatch(arrowArray);
                nextBatch.close();
        private final CDataDictionaryProvider dictionaryProvider;
         * returned root is closed (firing the native release for the whole batch) and the exception rethrown;
        /**
            FieldVector vector = root.getVector(fieldName);
    // Close-on-advance releases the previous VSR (no-op if transport already transferred it).
     *        its own channel.
    @Override
            Schema schema,
            VectorSchemaRoot batch = nextBatch;
     * Both allocators are caller-owned; this stream imports onto them but never closes either.
         * after ours) — it does not own it at all.
            CDataDictionaryProvider dictionaryProvider
        }
    }
                }
            this.root = root;
                // failure that is the real diagnosis.
    private final StreamHandle streamHandle;
        this.dictionaryProvider = new CDataDictionaryProvider();
import org.opensearch.analytics.backend.EngineResultStream;
    }
import org.opensearch.common.annotation.ExperimentalApi;
            // Flight's transferTo or after row-path reads.
            BufferAllocator allocator,
        }
        private boolean batchEmitted;
            CDataDictionaryProvider dictionaryProvider
        public Object getFieldValue(String fieldName, int rowIndex) {
                // synthesise a zero-row batch carrying the schema for empty native streams.
            if (hasNext() == false) {
import org.apache.arrow.vector.types.pojo.Schema;
    }
            return fieldNames;
        return iteratorInstance;
import org.apache.arrow.c.Data;
            CompletableFuture<Long> future = new CompletableFuture<>();
            if (schema != null) return;
    private final BufferAllocator stagingAllocator;
                } catch (RuntimeException releaseFailure) {
        try {
            this.schema = batchSchema;
 *
            );
         * staging-allocator lifetime regression test can import several batches without a native stream.
                    future.completeExceptionally(e);
        }
        BufferAllocator stagingAllocator() {
        ) {
        public boolean hasNext() {
        ) {
        this.stagingAllocator = Objects.requireNonNull(stagingAllocator, "stagingAllocator");
         * stream root asynchronously in its own {@code close()}. So this stream can neither close it at batch
        @Override
        }
            }
        private final VectorSchemaRoot root;
import org.apache.arrow.vector.types.pojo.Field;
         * staging allocator is unbounded and parented at the root, so it can't OOM mid-array before the pool
package org.opensearch.be.datafusion;
        private Schema schema;
                return false;
import org.opensearch.analytics.backend.EngineResultBatch;
}
            if (nativeStreamExhausted) return false;
        public int getRowCount() {
                    batchEmitted = true;
                // Streaming Flight requires ≥1 schema-bearing frame before completeStream;
                    nextBatch = VectorSchemaRoot.create(schema, allocator);
            fn.accept(new ActionListener<>() {
        public List<String> getFieldNames() {
                throw new NoSuchElementException();
        }
                }
 * Reads Arrow record batches from the native stream via async JNI using the
         * same allocator for every later batch via {@code BaseFixedWidthVector#transferTo} and frees the
    static class ArrowResultBatch implements EngineResultBatch {
         * production import path.
            return future.join();
        ArrowResultBatch(VectorSchemaRoot root) {
            return root;
 * @opensearch.experimental
import java.util.Objects;
        @Override
                if (!batchEmitted) {
        public EngineResultBatch next() {
    @Override
                    throw new IllegalStateException("ArrowSchema describes non-struct type");
         * Caller-owned, node-scoped, unbounded staging allocator every batch is imported onto (see
            return ArrowValues.toJavaValue(vector, rowIndex);
        void closeLastBatch() {
        private boolean nativeStreamExhausted;
            nextAvailable = null;
            });
                if (structField.getType().getTypeID() != ArrowType.ArrowTypeID.Struct) {
         * <p>{@link Data#importIntoVectorSchemaRoot} charges each buffer against the target allocator as it
import java.util.List;
         * {@link #stagingAllocator} rather than directly into {@code allocator}.
    }
            try {
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
                }
@ExperimentalApi
            this.allocator = allocator;
        private boolean loadNextBatch() {
            return nextAvailable;
public class DatafusionResultStream implements EngineResultStream, FragmentResources.MetricsCapable {
    static class BatchIterator implements Iterator<EngineResultBatch> {
         * states "The producer's allocator must be long-lived (not closed per-request)"), then charges that
import org.apache.arrow.c.ArrowSchema;
            // Caller owns the returned VSR's lifecycle. Streaming handler transfers it to Flight
        /** The caller-supplied staging allocator batches are imported onto. For tests. */
     *        its reused stream root on the first batch's vector allocator and frees it asynchronously with
import org.opensearch.analytics.exec.FragmentResources;
         *
                    root.close();
            ArrowArray arrowArray,
import org.apache.arrow.vector.VectorSchemaRoot;
    // Fresh VSR per batch so each can be handed off independently
    public Iterator<EngineResultBatch> iterator() {
            if (iteratorInstance != null) {
    private volatile BatchIterator iteratorInstance;
import org.apache.arrow.c.CDataDictionaryProvider;
            this.fieldNames = root.getSchema().getFields().stream().map(Field::getName).toList();
            return root;
 * The OpenSearch Contributors require contributions made to
        }
            this.dictionaryProvider = dictionaryProvider;
            ensureSchema();
 */
         * FIRST batch's staging allocator ({@code FlightServerChannel#transferIntoStreamRoot}, whose comment
        @Override
import org.opensearch.core.action.ActionListener;
         * the C Data release callback never fires and the whole native batch leaks in the producer's native
         * paths, which drives the C Data reference count to zero. On import failure the partially-imported
            }
        return NativeBridge.streamGetMetrics(streamHandle.getPointer());
import org.apache.arrow.c.ArrowArray;
    }
        }
            return true;
         * boundaries (the transport is still using it) nor at stream close (the transport's free may run
                @Override
        @Override
import java.util.concurrent.CompletableFuture;
                // Releasing a partially-imported root can itself throw (VectorSchemaRoot#close rethrows any
        this.allocator = allocator;
            return new ArrowResultBatch(batch);
     *
                Data.importIntoVectorSchemaRoot(staging, arrowArray, root, dictionaryProvider);
    }
         * Imports {@code arrowArray} into a fresh {@link VectorSchemaRoot} on {@code staging}, which MUST be
            batchEmitted = true;
import org.apache.arrow.memory.BufferAllocator;
            }
                // RuntimeException from the vectors' release). Attach it rather than let it mask the import
            if (nextBatch != null) {
            BufferAllocator stagingAllocator,
                nextBatch = importBatch(arrowArray);
    public byte[] getMetricsJson() {
                dictionaryProvider.close();
        }
         * imported array <em>before</em> the throwing {@code wrapForeignAllocation} without rolling back, so
        public VectorSchemaRoot getArrowRoot() {
                nextBatch = null;
        }
                Field structField = importField(allocator, arrowSchema, dictionaryProvider);
            // (Flight closes after wire write); row-path collector closes after reading.
                iteratorInstance.closeLastBatch();
            long schemaAddr = callNativeFn(listener -> NativeBridge.streamGetSchema(streamHandle.getPointer(), listener));
        }
     */
                schema = new Schema(structField.getChildren(), structField.getMetadata());
                throw new IllegalArgumentException("Unknown field: " + fieldName);
import org.apache.arrow.vector.FieldVector;
                }
            StreamHandle streamHandle,
/*
            nextBatch = null;
            VectorSchemaRoot root = VectorSchemaRoot.create(schema, staging);
 */
        }
         */
            return importOntoStaging(stagingAllocator, schema, arrowArray, dictionaryProvider);
                    nextBatch.setRowCount(0);
            if (vector == null) {
    @Override
         * root is closed by {@link #importOntoStaging}; the allocator is untouched either way.
            return stagingAllocator;
import org.apache.arrow.vector.types.pojo.ArrowType;
        }
            } catch (RuntimeException e) {
        VectorSchemaRoot importBatchForTest(Schema batchSchema, ArrowArray arrowArray) {
         */
        }
    /**
         */
import java.util.NoSuchElementException;
            try (ArrowArray arrowArray = ArrowArray.wrap(arrayAddr)) {
 * <p>
        }
        private VectorSchemaRoot nextBatch;
     * @param stagingAllocator node-scoped, unbounded allocator every batch of every stream is imported onto
         * the caller owns {@code staging}. Package-private so the leak regression test can drive the exact
        @Override
import org.opensearch.be.datafusion.nativelib.NativeBridge;
import org.opensearch.analytics.exec.ArrowValues;
        private final List<String> fieldNames;
         * transport builds its reused stream root on {@code fieldVectors.getFirst().getAllocator()}, i.e. the
    public DatafusionResultStream(StreamHandle streamHandle, BufferAllocator allocator, BufferAllocator stagingAllocator) {
            }
