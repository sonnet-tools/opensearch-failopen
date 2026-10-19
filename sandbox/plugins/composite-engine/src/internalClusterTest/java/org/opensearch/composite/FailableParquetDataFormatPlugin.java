        public long generation() {
public class FailableParquetDataFormatPlugin extends ParquetOnlyDataFormatPlugin {
 *
        }
 *   FailableParquetDataFormatPlugin.armSchemaSuppression();   // next addDoc on a new field fails  
        @Override
        @Override  
     * Delegating writer that drops {@code updateMappingVersion} calls while the static flag
 */
        public Map<DataFormat, EngineReaderManager<?>> buildReaderManager(ReaderManagerConfig config) throws IOException {
        @Override
        public FormatChecksumStrategy getChecksumStrategy() {
            return delegate.getDataFormat();
                return;  
        public FileInfos flush(FlushInput flushInput) throws IOException {
    }
     * {@link org.opensearch.parquet.writer.MismatchedInputException} naturally.
    @Override
 * <p>Mirrors {@link FailableLuceneDataFormatPlugin} but exercises the parquet self-rollback
        }
            return delegate.getWriterForFormat(formatName);  
        public void close() throws IOException {
import org.opensearch.parquet.engine.ParquetDataFormat;  
            return delegate.mappingVersion();  
        public Merger getMerger() {
        public WriterState state() {  
        public Optional<Writer<?>> getWriterForFormat(String formatName) {
        @Override  
import org.opensearch.index.engine.dataformat.WriteResult;
        }  
        public Writer<ParquetDocumentInput> createWriter(WriterConfig config) {
 * {@link Writer#updateMappingVersion} is a no-op, so a doc carrying a newly-mapped field
        public ParquetDataFormat getDataFormat() {
import org.opensearch.composite.framework.ParquetOnlyDataFormatPlugin;
 * }</pre>  
        private final IndexingExecutionEngine<ParquetDataFormat, ParquetDocumentInput> delegate;
        private final Writer<ParquetDocumentInput> delegate;  
            return delegate.getHeapBytesUsed();
        @Override
        @Override
            if (suppressMappingUpdates.get()) {
            }
        @Override
import org.opensearch.index.engine.dataformat.FileInfos;  
    }
            return delegate.getProvider();
        public long getNextWriterGeneration() {
            return delegate.refresh(refreshInput);
 *   FailableParquetDataFormatPlugin.clearFailure();
     * is armed, so a doc carrying a field added in a later mapping version reaches the  
 *   ... index doc with a previously-unseen field type ...
        @Override
}
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
        }
            delegate.close();  
        @Override
            this.delegate = delegate;  
            ParquetDataFormat,
            return delegate.buildReaderManager(config);
import java.util.concurrent.atomic.AtomicBoolean;
            return delegate.flush(flushInput);  
            return delegate.state();
import org.opensearch.index.engine.dataformat.Writer;  
        }
    private static final AtomicBoolean suppressMappingUpdates = new AtomicBoolean(false);
            // mapping so any new field type reaches VSRManager.addDocument unmapped, where  
        @Override
        }
        public void close() throws IOException {
import org.opensearch.parquet.writer.ParquetDocumentInput;
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException {
        return new MappingSuppressingEngine(delegate);
import java.io.IOException;  
        @Override  
    /**
 * The OpenSearch Contributors require contributions made to  
import java.util.Optional;  
 * <p>Usage:
            // The whole point: when armed, the writer is left out of sync with the live
    public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig engineConfig) {  
        }
            return delegate.isSchemaMutable();
 */  
        }
 *  
import org.opensearch.index.engine.dataformat.RefreshInput;  
        }
            return new MappingSuppressingWriter(delegate.createWriter(config));  
 * thrown by the production code path and the production catch block (state PENDING_ROLLBACK →
 * arrives at {@code VSRManager.addDocument} without a corresponding {@code ParquetField}
    /** Re-enables mapping propagation. */
        }  
 * Test-only plugin that exercises {@link org.opensearch.parquet.writer.ParquetWriter}'s
import org.opensearch.index.store.FormatChecksumStrategy;
            delegate.updateMappingVersion(newVersion);
        }  
            delegate.rollbackTo(rowCount);
        @Override  
        @Override  
        public long mappingVersion() {
        }  
import org.opensearch.index.engine.exec.EngineReaderManager;  
import org.opensearch.index.engine.dataformat.WriterState;
        public IndexStoreProvider getProvider() {  
        public WriteResult addDoc(ParquetDocumentInput input) throws IOException {
            return delegate.getNextWriterGeneration();  
import org.opensearch.index.engine.dataformat.RefreshResult;
    }  
        public boolean isSchemaMutable() {  
            return delegate.addDoc(input);
        }  
        }
        }
    /** While armed, every wrapped writer's {@code updateMappingVersion} is a no-op. */  
        @Override
        @Override  
        }  
            // production code raises MismatchedInputException.
            return delegate.getMerger();
        @Override
 * production schema-mismatch failure path end-to-end through the cluster client by
            this.delegate = delegate;
        suppressMappingUpdates.set(true);
        }
        suppressMappingUpdates.set(false);
 * mapping. The real {@link org.opensearch.parquet.writer.MismatchedInputException} is  
 * compatible open source license.
        public RefreshResult refresh(RefreshInput refreshInput) throws IOException {  
            return delegate.newDocumentInput();
        public void rollbackTo(long rowCount) throws IOException {  
        @Override
            return delegate.getNativeBytesUsed();
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
        }
import java.util.Collection;
/**  
import org.opensearch.index.engine.dataformat.Merger;
 * inline rollback → state ACTIVE → return Failure) handles it.
 *  
 * suppressing schema reconciliation. When armed, the wrapped writer's  
        }
        @Override
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
import org.opensearch.index.engine.dataformat.FlushInput;
            delegate.close();
        MappingSuppressingWriter(Writer<ParquetDocumentInput> delegate) {
import org.opensearch.index.engine.dataformat.WriterConfig;
        @Override
        public void updateMappingVersion(long newVersion) {
    }
    /** Delegating wrapper that intercepts only {@code createWriter}. */
            return delegate.deleteFiles(filesToDelete);  
        public long getHeapBytesUsed() {  
/*  
        }
        public long getNativeBytesUsed() {  
            return delegate.getChecksumStrategy();  
        }
import org.opensearch.index.engine.dataformat.DataFormat;
    private static final class MappingSuppressingWriter implements Writer<ParquetDocumentInput> {
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;  
            ParquetDocumentInput>) super.indexingEngine(engineConfig);  
 * SPDX-License-Identifier: Apache-2.0
     * production VSR with an unreconciled schema and triggers
    public static void clearFailure() {  
    @SuppressWarnings("unchecked")
            return delegate.generation();
        MappingSuppressingEngine(IndexingExecutionEngine<ParquetDataFormat, ParquetDocumentInput> delegate) {  
        IndexingExecutionEngine<ParquetDataFormat, ParquetDocumentInput> delegate = (IndexingExecutionEngine<
        }  
        @Override  
        }  
        public ParquetDocumentInput newDocumentInput() {
 * <pre>{@code
    private static final class MappingSuppressingEngine implements IndexingExecutionEngine<ParquetDataFormat, ParquetDocumentInput> {
import java.util.Map;
package org.opensearch.composite;
    public static void armSchemaSuppression() {
    }
        @Override  
        }
        }
 * this file be licensed under the Apache-2.0 license or a
     */  
        @Override
        @Override
 * contract instead of Lucene's directory-fault path.
