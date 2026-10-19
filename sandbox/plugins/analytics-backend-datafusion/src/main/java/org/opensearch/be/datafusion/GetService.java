                // column's min/max statistics.
                var iter = stream.iterator();  
            if (rowId < 0) {  
                            + parquetSet.writerGeneration()
    }
        /** Empty Substrait plan — the internal-search path builds its plan natively and ignores it. */  
        }  
                            future.completeExceptionally(e);
                if (!iter.hasNext()) return null;  
                    NativeBridge.INTERNAL_SEARCH_BY_ROW_ID,  
                        }
            List<Map<String, Object>> results = new ArrayList<>();
                    configSegment.address(),  
import java.lang.foreign.Arena;  
            MonoFileWriterSet segment = MonoFileWriterSet.of(parquetDir, parquetSet.writerGeneration(), parquetFile, 0L);
                StreamHandle streamHandle = new StreamHandle(streamPtr, dfPlugin.getDataFusionService().getNativeRuntime());  
        public Map<String, Object> executeSingleRow(long rowId, WriterFileSet parquetSet) throws IOException {
                try {  
            try (ReaderHandle readerHandle = new ReaderHandle(parquetDir, List.of(segment), null, List.of(), List.of())) {  
            // validatePointer() calls in executeQueryAsync() find it in the live set.
import org.opensearch.analytics.spi.DocumentRowReader;  
                            + " is in ["
            }
    private static final Logger logger = LogManager.getLogger(GetService.class);
                );  
                    throw new IOException(errorMessage, e);  
                            + "]"  
        }  
                        public void onFailure(Exception e) {
            try (
    public DocumentLookupService documentLookupService(DocumentMetadataResolver resolver) {
                DatafusionResultStream stream = new DatafusionResultStream(streamHandle, sharedAllocator, importStagingAllocator)
                if (parquetDir.equals(parquetSet.directory()) == false) {
                    readerHandle.getPointer(),
                            }  
            String parquetDir = parquetSet.directory();  
                );
 * DataFusion-backed get-by-id executor. The resolver maps an {@code _id} to a  
                    GET_BY_ID_TABLE_ALIAS,
 * compatible open source license.
                            future.complete(v);  
                    runtimePtr,  
            }
import org.apache.arrow.memory.RootAllocator;
            importStagingAllocator.close();
        }  
                // DataFrame plan filtering `__row_id__ = rowId` with pushdown enabled. __row_id__ is  
        @Override
                    throw new IllegalArgumentException(
            }  
import org.opensearch.index.mapper.IdFieldMapper;
    }  
         * Unbounded staging child every batch of every stream this executor opens is imported onto — never
import org.apache.logging.log4j.Logger;  
                    }
                        @Override
        private static final long GET_BY_ID_TIMEOUT_MILLIS = 30_000L;  
    }
            return PARQUET_FORMAT;
                        }  
                            + parquetDir
            this.dfPlugin = dfPlugin;
        }
                    "DataFusion get-by-id query failed"
                        public void onResponse(Long v) {
    }
                    return future.get(GET_BY_ID_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            ) {
    public GetService(DataFusionPlugin dfPlugin) {
            }
        }
            try (
                        "Segments read together must share a directory, but generation "  
                // any index sort) and remaps into the Lucene secondary index, so the resolver's rowId
import org.opensearch.be.datafusion.nativelib.StreamHandle;  
                            + "] not ["
                            results.add(row);
        private final BufferAllocator importStagingAllocator = sharedAllocator.newChildAllocator(
                // the physical row position the parquet writer stamps at flush (sequential 0..N after
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
        this.executor = executor;  
        private final DataFusionPlugin dfPlugin;
 * {@code (writerGeneration, rowId)}; this locates the parquet file in the {@link CatalogSnapshot}
                    }  
        );
                } catch (Exception e) {
                            if (idVec != null && !idVec.isNull(i)) {
                long readerPtr = readerHandle.getPointer();
                var batch = iter.next();
@ExperimentalApi
                // independent of scan order and lets DataFusion prune row-groups/pages via the
        private static final byte[] EMPTY_PLAN = new byte[0];
 * SPDX-License-Identifier: Apache-2.0
        public List<Map<String, Object>> executeRowsAboveSeqNo(List<WriterFileSet> fileSets, long seqNoFloor) throws IOException {  
                StreamHandle streamHandle = new StreamHandle(streamPtr, dfPlugin.getDataFusionService().getNativeRuntime());
            for (WriterFileSet parquetSet : fileSets) {  
                }
package org.opensearch.be.datafusion;
                    mode,
            CompletableFuture<Long> future = new CompletableFuture<>();
import org.apache.arrow.memory.BufferAllocator;
        private long executeInternalSearch(long readerPtr, long runtimePtr, long mode, long bound, String errorMessage) throws IOException {  
            }  
                    );
            0,  
                    readerPtr,
    /** Returns a core-layer DocumentLookupService wired with this backend's executor and the supplied document resolver. */  
                    var batch = iter.next();
        }
        @Override
                return readSingleRow(streamPtr);
    GetService(DocumentRowReader executor) {
            String parquetFile = parquetSet.files().iterator().next();
import org.opensearch.common.annotation.ExperimentalApi;
        @Override
                    NativeBridge.INTERNAL_SEARCH_SEQ_NO_ABOVE,
                    return ArrowValues.toSourceMap(root, 0);
                }
     * via the Arrow C Data Interface, and flattens the first row into a Java map.  
        /**  
public class GetService implements Closeable {  
         * but a valid {@link WireConfigSnapshot} is still required.
import java.util.List;  
 * this file be licensed under the Apache-2.0 license or a
         */
                DatafusionResultStream stream = new DatafusionResultStream(streamHandle, sharedAllocator, importStagingAllocator)  
    public void close() throws IOException {  
        }
/**
                    seqNoFloor,
        @Override
                    bound,
                var iter = stream.iterator();
         */  
                // equals the row's __row_id__. An equality predicate returns exactly that row  
        public void close() {  
                                row.put(IdFieldMapper.NAME, Uid.decodeId((byte[]) idVec.getObject(i)));
import org.opensearch.index.engine.exec.DocumentMetadataResolver;  
import java.util.ArrayList;
            ) {
                MemorySegment configSegment = arena.allocate(WireConfigSnapshot.BYTE_SIZE);
                configSnapshot.writeTo(configSegment);
                    "DataFusion range query failed"  
    }  
                return readAllRows(streamPtr);
import org.opensearch.index.mapper.Uid;
                        FieldVector idVec = root.getVector(IdFieldMapper.NAME);
                throw new IllegalArgumentException("rowId must be non-negative, got: " + rowId);
import org.opensearch.be.datafusion.nativelib.NativeBridge;
            sharedAllocator.close();
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
 */  
                NativeBridge.executeQueryAsync(  
         * Runs an engine-internal point lookup through {@link NativeBridge#executeQueryAsync} and
 * The OpenSearch Contributors require contributions made to  
                    0L,
    /** Production constructor. */  
            c.close();
            Long.MAX_VALUE
import org.opensearch.be.datafusion.nativelib.ReaderHandle;
import org.opensearch.analytics.spi.DocumentLookupService;
        private static final String PARQUET_FORMAT = "parquet";
}  
        }  
            }  
            long runtimePtr = dfPlugin.getDataFusionService().getNativeRuntime().get();
         * filter plan from {@code mode} + {@code bound} via the DataFrame API. The plan is empty,  
            if (fileSets.isEmpty()) {
            "datafusion-get-import-staging",
import org.apache.arrow.vector.VectorSchemaRoot;
    static final class NativeBridgeExecutor implements DocumentRowReader, Closeable {
                return List.of();
     * Production executor driving {@link NativeBridge}. Spins up a short-lived
 *
            String parquetDir = fileSets.get(0).directory();
            }
                // Internal-search get-by-row-id: the native side ignores Substrait and builds a
     */
        private List<Map<String, Object>> readAllRows(long streamPtr) {  
            try (ReaderHandle readerHandle = new ReaderHandle(parquetDir, segments, null, List.of(), List.of())) {  
                    readerPtr,
         * one per stream, see {@code DatafusionResultStream.BatchIterator#stagingAllocator}. These streams are  
            }
        private final BufferAllocator sharedAllocator = new RootAllocator(64 * 1024 * 1024);  
            return results;  
    @Override
        public String formatName() {  
                    runtimePtr,
        if (executor instanceof Closeable c) {
        return new DocumentLookupService(resolver, executor);
            // ReaderHandle registers the native pointer with NativeHandle so downstream  
            List<MonoFileWriterSet> segments = new ArrayList<>(fileSets.size());
                    EMPTY_PLAN,  
                            + parquetSet.directory()  
import org.opensearch.core.action.ActionListener;
import org.opensearch.index.engine.exec.MonoFileWriterSet;
        this(new NativeBridgeExecutor(dfPlugin));
import java.util.concurrent.TimeUnit;  
        }  
                long streamPtr = executeInternalSearch(
 */
import java.lang.foreign.MemorySegment;
         * {@link #close()} runs.
    /**  
                segments.add(MonoFileWriterSet.from(parquetSet));  
                }
                );
 * and reads that row via a Substrait scan on the native runtime, flattening the Arrow batch into a
            try (Arena arena = Arena.ofConfined()) {  
import java.util.Map;
                        @Override  
         * drained inline (not handed to the Flight transport), so it is always drained by the time
                        }
                while (iter.hasNext()) {
            WireConfigSnapshot configSnapshot = WireConfigSnapshot.builder(dfPlugin.getDatafusionSettings().getSnapshot()).build();
    private final DocumentRowReader executor;
/*  
                    if (root.getRowCount() == 0) return null;  
                    new ActionListener<>() {  
        NativeBridgeExecutor(DataFusionPlugin dfPlugin) {
         * returns the result stream pointer. No Substrait is generated: the native side builds the
                try (VectorSchemaRoot root = batch.getArrowRoot()) {
 * source map.  
        private Map<String, Object> readSingleRow(long streamPtr) {  
import java.io.Closeable;
            long runtimePtr = dfPlugin.getDataFusionService().getNativeRuntime().get();
                long streamPtr = executeInternalSearch(  
                    try (VectorSchemaRoot root = batch.getArrowRoot()) {  
                }
                    runtimePtr,
        /**
import org.opensearch.analytics.exec.ArrowValues;
                        for (int i = 0; i < root.getRowCount(); i++) {
import org.opensearch.index.engine.exec.WriterFileSet;
import java.util.concurrent.CompletableFuture;
     * reader scoped to one parquet file, executes the plan, imports the single resulting batch
import org.apache.arrow.vector.FieldVector;  
                    rowId,
        private static final String GET_BY_ID_TABLE_ALIAS = "_t";
                            Map<String, Object> row = ArrowValues.toSourceMap(root, i);  
