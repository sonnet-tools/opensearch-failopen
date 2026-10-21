            acceptedRows++;
            }
        long writerGeneration,
 */
 */
        this.vsrManager = new VSRManager(
            return FileInfos.empty();
 * <p>The returned {@link FileInfos} from {@link #flush(FlushInput)} contains the file path, writer
        long writerGeneration,
    }
 * compatible open source license.
            stats
        // Register the pre-computed CRC32 so the upload path can read it in O(1).
        ParquetDataFormat dataFormat,
import org.opensearch.index.engine.dataformat.WriteResult;
    }
            throw new IllegalStateException("Writer is not active, state=" + state);
 * SPDX-License-Identifier: Apache-2.0
                    "[Gen: {}] mapping version {} requires a new Parquet writer: {}",
 *
     * @param dataFormat the Parquet data format instance
        try {
    private volatile long mappingVersion;
            writerGeneration,
        if (file == null || metadata == null || metadata.numRows() == 0) {
            } catch (MismatchedInputException | OutOfMemoryException e) {
            // caller-driven rollback no-ops in the VSR and restores ACTIVE.
        );
            throw new IllegalStateException("Cannot rollback to " + rowCount + ": only " + acceptedRows + " rows admitted");
                "rollbackTo supports rolling back exactly 1 doc, but asked to roll back " + (acceptedRows - rowCount)
                writerGeneration,
            );
        return vsrManager.isSchemaMutable();
import org.opensearch.index.engine.dataformat.FlushInput;
import org.opensearch.parquet.vsr.SchemaChangeRequiresWriterRotationException;
        ArrowBufferPool bufferPool,
            new ParquetShardStatsTracker()
        this.schemaSupplier = schemaSupplier;
                "[Gen: {}] updateMappingVersion: advancing from {} to {}, will reconcile schema",
     * @param file output Parquet file path
        long mappingVersion,
    @Override
        }
    }
     * Creates a new ParquetWriter without stats collection.
            Schema schema = schemaSupplier.get();
        }, stats::addIndexTimeMillis);
        return StatsRecorder.recordTimeMillis(() -> {
            schemaSupplier,
        }
    private final ParquetShardStatsTracker stats;
            threadPool,
    public void updateMappingVersion(long newVersion) {
            try {
import org.opensearch.parquet.engine.ParquetDataFormat;
        this.writerGeneration = writerGeneration;
        } else {
        ParquetShardStatsTracker stats
        this.dataFormat = dataFormat;
        }
     * @param threadPool the thread pool for background native writes
import org.opensearch.parquet.vsr.VSRManager;
    @Override
import org.opensearch.index.engine.dataformat.Writer;
import org.opensearch.index.engine.dataformat.WriterState;
        this(
    public ParquetWriter(
    }
     * @param stats shard-level stats tracker
        }
 * generation, and row count for downstream commit tracking.
            schema,
        String file,
        }
        return FileInfos.builder().putWriterFileSet(dataFormat, monoFileSet).rowIdMapping(vsrManager.getRowIdMapping()).build();
import org.opensearch.parquet.ParquetDataFormatPlugin;
            filePath.getParent().toAbsolutePath(),
                writerGeneration,
        this.file = file;
                state = WriterState.PENDING_ROLLBACK;
     * @param bufferPool shared Arrow buffer pool
            } catch (SchemaChangeRequiresWriterRotationException e) {
    public Optional<Writer<?>> getWriterForFormat(String formatName) {
                return new WriteResult.Failure(e, -1, -1, -1);
    }
                "[Gen: {}] updateMappingVersion: schema from supplier has {} fields: {}",
            logger.trace(
        // Use the FileMetadata overload so the strategy owns key derivation.
            );
            metadata.numRows(),
                logger.debug(
    }
 * Documents are accepted via {@link #addDoc(ParquetDocumentInput)}, batched in Arrow vectors
                boolean updated = vsrManager.reconcileSchema(schema);
            mappingVersion,
                );
    private volatile WriterState state = WriterState.ACTIVE;
            );
 * the {@link IndexSettings} passed at construction time and propagated to the VSR layer.
        ParquetDataFormat dataFormat,
     * @param schema Arrow schema for vector creation at construction time
import org.apache.logging.log4j.LogManager;
import org.opensearch.index.engine.exec.MonoFileWriterSet;
        IndexSettings indexSettings,
/**
            stats.addDocsIndexed(1);
            bufferPool,
            state = WriterState.CLOSED;
                this.mappingVersion,
import org.opensearch.index.IndexSettings;
        Supplier<Schema> schemaSupplier,
import java.util.function.Supplier;
import org.opensearch.index.engine.dataformat.FileInfos;
import org.opensearch.threadpool.ThreadPool;
        } finally {
        return mappingVersion;
            schema,
        this.stats = stats;
        if (state != WriterState.ACTIVE) {
import org.apache.logging.log4j.Logger;
    @Override
}
     * @param indexSettings index settings for writer configuration
    ) {
        Supplier<Schema> schemaSupplier,
        assert metadata.numRows() > 0 : "flushed metadata must have positive row count";
        }
 *
import org.opensearch.index.store.FormatChecksumStrategy;
    private long acceptedRows = 0L;
        return writerGeneration;
            // Schema mismatch is recoverable: the VSR rejected the doc pre-admission, so the
            indexSettings,
    @Override
                newVersion,
            checksumStrategy,
            indexSettings,
 *
import org.apache.arrow.memory.OutOfMemoryException;
    public WriteResult addDoc(ParquetDocumentInput d) throws IOException {
package org.opensearch.parquet.writer;
            logger.trace(
     * @param writerGeneration generation number for this writer
 * <p>Each instance corresponds to a single Parquet file for a given writer generation.
            ParquetDataFormatPlugin.PARQUET_FORMAT_VERSION
        ThreadPool threadPool,
        this.checksumStrategy = checksumStrategy;
        state = WriterState.ACTIVE;
    }
 * this file be licensed under the Apache-2.0 license or a
        if (acceptedRows - rowCount > 1) {
            writerGeneration,
        return state;
     * @param schemaSupplier supplies the up-to-date schema when the mapping version
        String fileName = filePath.getFileName().toString();
        );
 * The OpenSearch Contributors require contributions made to
            this.mappingVersion = newVersion;
            ParquetSettings.MAX_ROWS_PER_VSR.get(indexSettings.getSettings()),
    public WriterState state() {
public class ParquetWriter implements Writer<ParquetDocumentInput> {
 * <p>Writer-level settings (e.g., {@code parquet.max_rows_per_vsr}) are extracted from
            file,
    }
    /**
        IndexSettings indexSettings,
     *                       field vectors before {@code addDoc} encounters them
        Schema schema,
                state = WriterState.RETIRED_FLUSHABLE;
    private final long writerGeneration;
import org.apache.arrow.vector.types.pojo.Schema;
import java.nio.file.Path;
import org.opensearch.parquet.ParquetSettings;
                schema.getFields().stream().map(f -> f.getName()).collect(java.util.stream.Collectors.joining(", "))
import org.opensearch.parquet.memory.ArrowBufferPool;
        ParquetFileMetadata metadata = vsrManager.flush();
import org.opensearch.plugin.stats.StatsRecorder;
        return dataFormat.name().equals(formatName) ? Optional.of(this) : Optional.empty();
                newVersion
        ArrowBufferPool bufferPool,
        if (checksumStrategy != null && metadata.crc32() != 0) {
        }
            return new WriteResult.Success(1L, 1L, 1L);
        acceptedRows = rowCount;
            checksumStrategy.registerChecksum(new FileMetadata(dataFormat.name(), fileName), metadata.crc32(), writerGeneration);
import java.io.IOException;
     * Creates a new ParquetWriter.
    @Override
    private final VSRManager vsrManager;
                schema.getFields().size(),
                this.mappingVersion
     * @param mappingVersion the initial mapping version
import org.opensearch.index.store.FileMetadata;
    public void close() throws IOException {
            writerGeneration,
    private final ParquetDataFormat dataFormat;
 * by the {@link VSRManager}, and flushed to a Parquet file via the native Rust writer.
/*
            file,
    private static final Logger logger = LogManager.getLogger(ParquetWriter.class);
            throw new IllegalStateException("rollbackTo requires ACTIVE or PENDING_ROLLBACK state but was " + state);
            bufferPool,
    @Override
            }
    ) {
import org.opensearch.parquet.stats.ParquetShardStatsTracker;
    @Override
    public void rollbackTo(long rowCount) throws IOException {
            fileName,
            );
            try {
        if (state != WriterState.ACTIVE && state != WriterState.PENDING_ROLLBACK) {
        vsrManager.rollbackTo(rowCount);
 * Parquet file writer integrating OpenSearch's {@link Writer} interface with the VSR batching layer.
    }
                "[Gen: {}] updateMappingVersion: no-op, newVersion={} <= current mappingVersion={}",
            throw new IllegalStateException(
        );
    public ParquetWriter(
     */
        FormatChecksumStrategy checksumStrategy
    public long mappingVersion() {
 *
    public long generation() {
            logger.debug(
    /**
                logger.debug("updateMappingVersion: reconcileSchema returned updated={}", updated);
                    writerGeneration,
        Path filePath = Path.of(file);
        MonoFileWriterSet monoFileSet = MonoFileWriterSet.of(
    @Override
        String file,
    }
            threadPool,
                vsrManager.addDocument(d);
    }
    public boolean isSchemaMutable() {
            vsrManager.close();
    @Override
                writerGeneration,
        Schema schema,
     * @param checksumStrategy strategy to register pre-computed checksums on
     *
     *                       advances, used by {@link #updateMappingVersion} to add new
            dataFormat,
        long mappingVersion,
     */
    @Override
        }
        FormatChecksumStrategy checksumStrategy,
    }
    private final String file;
                    newVersion,
                    e.getMessage()
    private final FormatChecksumStrategy checksumStrategy;
        if (rowCount > acceptedRows) {
import org.opensearch.parquet.bridge.ParquetFileMetadata;
        if (newVersion > this.mappingVersion) {
    private final Supplier<Schema> schemaSupplier;
import java.util.Optional;
        ThreadPool threadPool,
        this.mappingVersion = mappingVersion;
    public FileInfos flush(FlushInput flushInput) throws IOException {
