            ) {
                    if (root.getRowCount() == 0) return null;
    public DocumentLookupService documentLookupService(DocumentMetadataResolver resolver) {
                // any index sort) and remaps into the Lucene secondary index, so the resolver's rowId
                    configSegment.address(),
            Long.MAX_VALUE
        }
            }
        private final BufferAllocator sharedAllocator = new RootAllocator(64 * 1024 * 1024);
        public String formatName() {
            try (
import java.util.List;
package org.opensearch.be.datafusion;
                    readerHandle.getPointer(),
                MemorySegment configSegment = arena.allocate(WireConfigSnapshot.BYTE_SIZE);
                        "Segments read together must share a directory, but generation "
            try (
        @Override
                // Internal-search get-by-row-id: the native side ignores Substrait and builds a
 *
                            + "]"
                            }
                DatafusionResultStream stream = new DatafusionResultStream(streamHandle, sharedAllocator, importStagingAllocator)
    static final class NativeBridgeExecutor implements DocumentRowReader, Closeable {
         */
import org.apache.arrow.vector.VectorSchemaRoot;
            long runtimePtr = dfPlugin.getDataFusionService().getNativeRuntime().get();
                    }
                DatafusionResultStream stream = new DatafusionResultStream(streamHandle, sharedAllocator, importStagingAllocator)
         * {@link #close()} runs.
        /**
         * filter plan from {@code mode} + {@code bound} via the DataFrame API. The plan is empty,
                    return ArrowValues.toSourceMap(root, 0);
                    runtimePtr,
import java.util.Map;
import org.opensearch.analytics.spi.DocumentLookupService;
                        for (int i = 0; i < root.getRowCount(); i++) {
import org.apache.arrow.vector.FieldVector;
                    mode,
            c.close();
            String parquetDir = parquetSet.directory();
                    var batch = iter.next();
                    GET_BY_ID_TABLE_ALIAS,
 * SPDX-License-Identifier: Apache-2.0
                    runtimePtr,
                }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
                try {
        private static final String GET_BY_ID_TABLE_ALIAS = "_t";
            List<Map<String, Object>> results = new ArrayList<>();
 * and reads that row via a Substrait scan on the native runtime, flattening the Arrow batch into a
        }
        }
                StreamHandle streamHandle = new StreamHandle(streamPtr, dfPlugin.getDataFusionService().getNativeRuntime());
                );
                StreamHandle streamHandle = new StreamHandle(streamPtr, dfPlugin.getDataFusionService().getNativeRuntime());
                    "DataFusion range query failed"
import org.opensearch.common.annotation.ExperimentalApi;
            }
            CompletableFuture<Long> future = new CompletableFuture<>();
                long streamPtr = executeInternalSearch(
import org.opensearch.index.engine.exec.MonoFileWriterSet;
        private Map<String, Object> readSingleRow(long streamPtr) {
    /**
            if (rowId < 0) {
         */
 */
    }
        }
                long streamPtr = executeInternalSearch(
import org.opensearch.be.datafusion.nativelib.NativeBridge;
            WireConfigSnapshot configSnapshot = WireConfigSnapshot.builder(dfPlugin.getDatafusionSettings().getSnapshot()).build();
                try (VectorSchemaRoot root = batch.getArrowRoot()) {
import java.util.concurrent.CompletableFuture;
                    NativeBridge.INTERNAL_SEARCH_SEQ_NO_ABOVE,
import java.util.concurrent.TimeUnit;
                    new ActionListener<>() {
            try (ReaderHandle readerHandle = new ReaderHandle(parquetDir, List.of(segment), null, List.of(), List.of())) {
                // independent of scan order and lets DataFusion prune row-groups/pages via the
        public List<Map<String, Object>> executeRowsAboveSeqNo(List<WriterFileSet> fileSets, long seqNoFloor) throws IOException {
                            if (idVec != null && !idVec.isNull(i)) {
                            Map<String, Object> row = ArrowValues.toSourceMap(root, i);
            }
                }
        return new DocumentLookupService(resolver, executor);
import org.opensearch.core.action.ActionListener;
                throw new IllegalArgumentException("rowId must be non-negative, got: " + rowId);
                // equals the row's __row_id__. An equality predicate returns exactly that row
            sharedAllocator.close();
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
            List<MonoFileWriterSet> segments = new ArrayList<>(fileSets.size());
            ) {
    private static final Logger logger = LogManager.getLogger(GetService.class);
import java.io.IOException;
                    throw new IllegalArgumentException(
        /**
     */
/**
        private final BufferAllocator importStagingAllocator = sharedAllocator.newChildAllocator(
        private final DataFusionPlugin dfPlugin;
            // validatePointer() calls in executeQueryAsync() find it in the live set.
    /** Production constructor. */
    @Override
                configSnapshot.writeTo(configSegment);
        @Override
            try (ReaderHandle readerHandle = new ReaderHandle(parquetDir, segments, null, List.of(), List.of())) {
        }
 * The OpenSearch Contributors require contributions made to
                    );
import org.apache.arrow.memory.RootAllocator;
    public GetService(DataFusionPlugin dfPlugin) {
 * source map.
                            + "] not ["
                var iter = stream.iterator();
                segments.add(MonoFileWriterSet.from(parquetSet));
                        public void onResponse(Long v) {
import org.apache.logging.log4j.Logger;
        /** Empty Substrait plan — the internal-search path builds its plan natively and ignores it. */
            return PARQUET_FORMAT;
                    rowId,
                NativeBridge.executeQueryAsync(
                        }
                        }
import org.opensearch.index.engine.exec.WriterFileSet;
        @Override
                    readerPtr,
import java.io.Closeable;
        private List<Map<String, Object>> readAllRows(long streamPtr) {
            MonoFileWriterSet segment = MonoFileWriterSet.of(parquetDir, parquetSet.writerGeneration(), parquetFile, 0L);
                            + " is in ["
                    0L,
            importStagingAllocator.close();
 */
                long readerPtr = readerHandle.getPointer();
            }
        this.executor = executor;
public class GetService implements Closeable {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            // ReaderHandle registers the native pointer with NativeHandle so downstream
            String parquetFile = parquetSet.files().iterator().next();
                return readSingleRow(streamPtr);
                if (!iter.hasNext()) return null;
import org.opensearch.be.datafusion.nativelib.ReaderHandle;
         * but a valid {@link WireConfigSnapshot} is still required.
                            + parquetSet.directory()
         * Runs an engine-internal point lookup through {@link NativeBridge#executeQueryAsync} and
                var iter = stream.iterator();
import org.opensearch.index.mapper.Uid;
                while (iter.hasNext()) {
                            + parquetDir
    }
/*
            0,
            String parquetDir = fileSets.get(0).directory();
    /** Returns a core-layer DocumentLookupService wired with this backend's executor and the supplied document resolver. */
        @Override
                var batch = iter.next();
import java.util.ArrayList;
                );
            return results;
import org.opensearch.index.mapper.IdFieldMapper;
                return List.of();
                    "DataFusion get-by-id query failed"
    }
                    try (VectorSchemaRoot root = batch.getArrowRoot()) {
                    runtimePtr,
                        FieldVector idVec = root.getVector(IdFieldMapper.NAME);
                        public void onFailure(Exception e) {
import org.opensearch.be.datafusion.nativelib.StreamHandle;
        }
        private static final byte[] EMPTY_PLAN = new byte[0];
            }
        private static final long GET_BY_ID_TIMEOUT_MILLIS = 30_000L;
    }
                    readerPtr,
        if (executor instanceof Closeable c) {
            }
            if (fileSets.isEmpty()) {
        public Map<String, Object> executeSingleRow(long rowId, WriterFileSet parquetSet) throws IOException {
     * Production executor driving {@link NativeBridge}. Spins up a short-lived
 * {@code (writerGeneration, rowId)}; this locates the parquet file in the {@link CatalogSnapshot}
                    seqNoFloor,
        this(new NativeBridgeExecutor(dfPlugin));
                    NativeBridge.INTERNAL_SEARCH_BY_ROW_ID,
import org.opensearch.analytics.exec.ArrowValues;
                    bound,
}
                // column's min/max statistics.
                        @Override
            for (WriterFileSet parquetSet : fileSets) {
    GetService(DocumentRowReader executor) {
@ExperimentalApi
                    throw new IOException(errorMessage, e);
import org.apache.arrow.memory.BufferAllocator;
                    EMPTY_PLAN,
        }
            long runtimePtr = dfPlugin.getDataFusionService().getNativeRuntime().get();
         * one per stream, see {@code DatafusionResultStream.BatchIterator#stagingAllocator}. These streams are
                return readAllRows(streamPtr);
                } catch (Exception e) {
import java.lang.foreign.MemorySegment;
            }
     * via the Arrow C Data Interface, and flattens the first row into a Java map.
                            results.add(row);
         * drained inline (not handed to the Flight transport), so it is always drained by the time
                        @Override
                        }
 * DataFusion-backed get-by-id executor. The resolver maps an {@code _id} to a
        NativeBridgeExecutor(DataFusionPlugin dfPlugin) {
                // DataFrame plan filtering `__row_id__ = rowId` with pushdown enabled. __row_id__ is
                            future.complete(v);
                    return future.get(GET_BY_ID_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                );
            this.dfPlugin = dfPlugin;
import org.opensearch.analytics.spi.DocumentRowReader;
        public void close() {
                                row.put(IdFieldMapper.NAME, Uid.decodeId((byte[]) idVec.getObject(i)));
         * Unbounded staging child every batch of every stream this executor opens is imported onto — never
                    }
    public void close() throws IOException {
                if (parquetDir.equals(parquetSet.directory()) == false) {
                // the physical row position the parquet writer stamps at flush (sequential 0..N after
import java.lang.foreign.Arena;
        private long executeInternalSearch(long readerPtr, long runtimePtr, long mode, long bound, String errorMessage) throws IOException {
         * returns the result stream pointer. No Substrait is generated: the native side builds the
            }
        }
            try (Arena arena = Arena.ofConfined()) {
    }
     * reader scoped to one parquet file, executes the plan, imports the single resulting batch
                }
                            future.completeExceptionally(e);
        );
    private final DocumentRowReader executor;
        private static final String PARQUET_FORMAT = "parquet";
                }
        }
import org.apache.logging.log4j.LogManager;
            "datafusion-get-import-staging",
                            + parquetSet.writerGeneration()
