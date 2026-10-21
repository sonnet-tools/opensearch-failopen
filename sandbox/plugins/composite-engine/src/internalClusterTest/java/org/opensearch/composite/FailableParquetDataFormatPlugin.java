 * <p>Mirrors {@link FailableLuceneDataFormatPlugin} but exercises the parquet self-rollback
        }
    private static final class MappingSuppressingWriter implements Writer<ParquetDocumentInput> {
import org.opensearch.index.engine.dataformat.FileInfos;
        @Override
        IndexingExecutionEngine<ParquetDataFormat, ParquetDocumentInput> delegate = (IndexingExecutionEngine<
        @Override
            delegate.rollbackTo(rowCount);
import org.opensearch.index.engine.dataformat.RefreshResult;
        }
    /** Re-enables mapping propagation. */
            return delegate.isSchemaMutable();
        }
        }
import java.util.concurrent.atomic.AtomicBoolean;
        }
            return delegate.getProvider();
     * production VSR with an unreconciled schema and triggers
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.engine.dataformat.RefreshInput;
 *
        }
import org.opensearch.index.engine.dataformat.DataFormat;
}
import org.opensearch.index.store.FormatChecksumStrategy;
        public boolean isSchemaMutable() {
/*
        }
            this.delegate = delegate;
 * SPDX-License-Identifier: Apache-2.0
 */
    /** While armed, every wrapped writer's {@code updateMappingVersion} is a no-op. */
        public void rollbackTo(long rowCount) throws IOException {
import org.opensearch.parquet.writer.ParquetDocumentInput;
        @Override
        public long getNextWriterGeneration() {
            return delegate.newDocumentInput();
        }
     * is armed, so a doc carrying a field added in a later mapping version reaches the
 * <pre>{@code
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
        }
     */
import java.util.Optional;
            return new MappingSuppressingWriter(delegate.createWriter(config));
        public long generation() {
        }
            return delegate.getNativeBytesUsed();
 * this file be licensed under the Apache-2.0 license or a
        @Override
        @Override
package org.opensearch.composite;
        @Override
            return delegate.addDoc(input);
        }
            delegate.close();
            return delegate.deleteFiles(filesToDelete);
        @Override
        public ParquetDocumentInput newDocumentInput() {
        }
    public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig engineConfig) {
        }
            return delegate.getChecksumStrategy();
        }
            ParquetDataFormat,
            return delegate.mappingVersion();
import java.util.Collection;
     * {@link org.opensearch.parquet.writer.MismatchedInputException} naturally.
        public IndexStoreProvider getProvider() {
    private static final AtomicBoolean suppressMappingUpdates = new AtomicBoolean(false);
        @Override
    /**
public class FailableParquetDataFormatPlugin extends ParquetOnlyDataFormatPlugin {
            return delegate.getNextWriterGeneration();
        @Override
        @Override
 */
        }
        suppressMappingUpdates.set(false);
        }
import java.util.Map;
            return delegate.getDataFormat();
 * thrown by the production code path and the production catch block (state PENDING_ROLLBACK →
            return delegate.generation();
import org.opensearch.index.engine.dataformat.Writer;
        public FileInfos flush(FlushInput flushInput) throws IOException {
 * {@link Writer#updateMappingVersion} is a no-op, so a doc carrying a newly-mapped field
    }
        public void close() throws IOException {
        MappingSuppressingWriter(Writer<ParquetDocumentInput> delegate) {
    }
 * mapping. The real {@link org.opensearch.parquet.writer.MismatchedInputException} is
        @Override
 * suppressing schema reconciliation. When armed, the wrapped writer's
import org.opensearch.index.engine.dataformat.FlushInput;
        }
    }
        @Override
 * arrives at {@code VSRManager.addDocument} without a corresponding {@code ParquetField}
        public FormatChecksumStrategy getChecksumStrategy() {
            // production code raises MismatchedInputException.
        public Merger getMerger() {
        @Override
        public Map<DataFormat, EngineReaderManager<?>> buildReaderManager(ReaderManagerConfig config) throws IOException {
        }
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
        }
        public void updateMappingVersion(long newVersion) {
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException {
            return delegate.refresh(refreshInput);
        return new MappingSuppressingEngine(delegate);
        public ParquetDataFormat getDataFormat() {
        @Override
 * <p>Usage:
        MappingSuppressingEngine(IndexingExecutionEngine<ParquetDataFormat, ParquetDocumentInput> delegate) {
        }
        public long getHeapBytesUsed() {
        @Override
 *
 * contract instead of Lucene's directory-fault path.
            }
 * }</pre>
        @Override
        suppressMappingUpdates.set(true);
            return delegate.flush(flushInput);
            return delegate.getWriterForFormat(formatName);
import org.opensearch.index.engine.dataformat.WriterConfig;
        public RefreshResult refresh(RefreshInput refreshInput) throws IOException {
            delegate.close();
/**
            // mapping so any new field type reaches VSRManager.addDocument unmapped, where
import org.opensearch.composite.framework.ParquetOnlyDataFormatPlugin;
        }
        public long mappingVersion() {
 *
            this.delegate = delegate;
        }
        @Override
import java.io.IOException;
            ParquetDocumentInput>) super.indexingEngine(engineConfig);
 *   FailableParquetDataFormatPlugin.clearFailure();
            // The whole point: when armed, the writer is left out of sync with the live
        @Override
 * inline rollback → state ACTIVE → return Failure) handles it.
            return delegate.getHeapBytesUsed();
 * compatible open source license.
    private static final class MappingSuppressingEngine implements IndexingExecutionEngine<ParquetDataFormat, ParquetDocumentInput> {
 * production schema-mismatch failure path end-to-end through the cluster client by
        private final Writer<ParquetDocumentInput> delegate;
        public Writer<ParquetDocumentInput> createWriter(WriterConfig config) {
    /** Delegating wrapper that intercepts only {@code createWriter}. */
            return delegate.getMerger();
        public void close() throws IOException {
        @Override
    public static void clearFailure() {
        @Override
 *   ... index doc with a previously-unseen field type ...
import org.opensearch.index.engine.dataformat.Merger;
 *   FailableParquetDataFormatPlugin.armSchemaSuppression();   // next addDoc on a new field fails
        public Optional<Writer<?>> getWriterForFormat(String formatName) {
import org.opensearch.index.engine.exec.EngineReaderManager;
            delegate.updateMappingVersion(newVersion);
    public static void armSchemaSuppression() {
import org.opensearch.index.engine.dataformat.WriteResult;
        }
     * Delegating writer that drops {@code updateMappingVersion} calls while the static flag
 * Test-only plugin that exercises {@link org.opensearch.parquet.writer.ParquetWriter}'s
        }
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
    @Override
        private final IndexingExecutionEngine<ParquetDataFormat, ParquetDocumentInput> delegate;
import org.opensearch.parquet.engine.ParquetDataFormat;
                return;
        public long getNativeBytesUsed() {
import org.opensearch.index.engine.dataformat.WriterState;
        }
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
        @Override
    @SuppressWarnings("unchecked")
        public WriteResult addDoc(ParquetDocumentInput input) throws IOException {
        public WriterState state() {
            if (suppressMappingUpdates.get()) {
    }
        @Override
    }
            return delegate.state();
        @Override
            return delegate.buildReaderManager(config);
