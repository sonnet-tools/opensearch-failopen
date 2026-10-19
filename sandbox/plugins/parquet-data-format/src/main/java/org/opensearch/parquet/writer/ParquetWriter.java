            } catch (MismatchedInputException | OutOfMemoryException e) {  
            logger.trace(
            state = WriterState.CLOSED;
    }
    private final Supplier<Schema> schemaSupplier;
 */  
 * <p>Each instance corresponds to a single Parquet file for a given writer generation.  
        return vsrManager.isSchemaMutable();  
import org.opensearch.parquet.ParquetSettings;  
    @Override
        Path filePath = Path.of(file);
    private long acceptedRows = 0L;
import org.apache.logging.log4j.Logger;
 * by the {@link VSRManager}, and flushed to a Parquet file via the native Rust writer.
        }, stats::addIndexTimeMillis);
        }
                writerGeneration,  
            threadPool,
            );
        IndexSettings indexSettings,
    }  
                logger.debug(  
        ParquetDataFormat dataFormat,  
     */
        } finally {  
    private final long writerGeneration;  
    }  
    private volatile long mappingVersion;  
    }
        this.mappingVersion = mappingVersion;  
            filePath.getParent().toAbsolutePath(),
        }
            file,  
            throw new IllegalStateException(
        if (rowCount > acceptedRows) {  
     * @param schema Arrow schema for vector creation at construction time
    private final VSRManager vsrManager;
import java.nio.file.Path;
    @Override
        this.checksumStrategy = checksumStrategy;
        Schema schema,
    public ParquetWriter(  
                writerGeneration,
            checksumStrategy,  
            ParquetSettings.MAX_ROWS_PER_VSR.get(indexSettings.getSettings()),
                "[Gen: {}] updateMappingVersion: no-op, newVersion={} <= current mappingVersion={}",  
    private final ParquetDataFormat dataFormat;
                schema.getFields().stream().map(f -> f.getName()).collect(java.util.stream.Collectors.joining(", "))
        }
            return new WriteResult.Success(1L, 1L, 1L);  
        this.writerGeneration = writerGeneration;
import org.opensearch.index.engine.exec.MonoFileWriterSet;
                    writerGeneration,
        ArrowBufferPool bufferPool,
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        );
    /**
            file,  
        ParquetFileMetadata metadata = vsrManager.flush();
            bufferPool,  
            vsrManager.close();
                    newVersion,  
        ThreadPool threadPool,
        String fileName = filePath.getFileName().toString();
public class ParquetWriter implements Writer<ParquetDocumentInput> {
                );
    }  
     * Creates a new ParquetWriter without stats collection.  
            try {
                logger.debug("updateMappingVersion: reconcileSchema returned updated={}", updated);  
            );
        if (acceptedRows - rowCount > 1) {  
            throw new IllegalStateException("Cannot rollback to " + rowCount + ": only " + acceptedRows + " rows admitted");
    @Override  
        ParquetShardStatsTracker stats
    }  
        IndexSettings indexSettings,
        acceptedRows = rowCount;  
import org.opensearch.parquet.engine.ParquetDataFormat;
                return new WriteResult.Failure(e, -1, -1, -1);
            logger.debug(
    }  
                writerGeneration,
    ) {
    public boolean isSchemaMutable() {
        if (newVersion > this.mappingVersion) {
    /**
import org.opensearch.index.engine.dataformat.Writer;  
            indexSettings,
 *  
            throw new IllegalStateException("Writer is not active, state=" + state);
        // Register the pre-computed CRC32 so the upload path can read it in O(1).
        this.vsrManager = new VSRManager(
            ParquetDataFormatPlugin.PARQUET_FORMAT_VERSION  
        long mappingVersion,  
        long writerGeneration,
        ParquetDataFormat dataFormat,
        String file,  
     * @param checksumStrategy strategy to register pre-computed checksums on  
import org.opensearch.parquet.vsr.VSRManager;  
     * @param file output Parquet file path
            writerGeneration,  
    private final String file;
        vsrManager.rollbackTo(rowCount);
    }
        if (checksumStrategy != null && metadata.crc32() != 0) {  
            );  
        Supplier<Schema> schemaSupplier,  
    private volatile WriterState state = WriterState.ACTIVE;
        if (file == null || metadata == null || metadata.numRows() == 0) {
 * compatible open source license.
        }
import org.apache.arrow.memory.OutOfMemoryException;
        }  
                "[Gen: {}] updateMappingVersion: schema from supplier has {} fields: {}",
        }
        // Use the FileMetadata overload so the strategy owns key derivation.
                boolean updated = vsrManager.reconcileSchema(schema);
        this.file = file;
                newVersion  
import org.opensearch.parquet.stats.ParquetShardStatsTracker;
        } else {
    public void close() throws IOException {  
            bufferPool,  
            this.mappingVersion = newVersion;
            schema,
                state = WriterState.RETIRED_FLUSHABLE;
        this(
            acceptedRows++;
package org.opensearch.parquet.writer;
import org.opensearch.index.engine.dataformat.FlushInput;
            metadata.numRows(),
 * <p>Writer-level settings (e.g., {@code parquet.max_rows_per_vsr}) are extracted from
    public long mappingVersion() {
        if (state != WriterState.ACTIVE && state != WriterState.PENDING_ROLLBACK) {  
        String file,
    public WriterState state() {
import org.apache.arrow.vector.types.pojo.Schema;
                state = WriterState.PENDING_ROLLBACK;
    ) {  
                "[Gen: {}] updateMappingVersion: advancing from {} to {}, will reconcile schema",  
            threadPool,
import org.opensearch.index.IndexSettings;
                schema.getFields().size(),
     * Creates a new ParquetWriter.
        }
        return StatsRecorder.recordTimeMillis(() -> {
/**  
        if (state != WriterState.ACTIVE) {
 *
        Supplier<Schema> schemaSupplier,
        this.stats = stats;
                vsrManager.addDocument(d);
        );
            } catch (SchemaChangeRequiresWriterRotationException e) {
        return FileInfos.builder().putWriterFileSet(dataFormat, monoFileSet).rowIdMapping(vsrManager.getRowIdMapping()).build();
     */
            stats.addDocsIndexed(1);
    @Override
        }
        assert metadata.numRows() > 0 : "flushed metadata must have positive row count";
        this.dataFormat = dataFormat;
        return state;  
import org.opensearch.index.store.FileMetadata;  
    @Override
    @Override
    @Override
                this.mappingVersion,
 */  
 * generation, and row count for downstream commit tracking.
import org.opensearch.plugin.stats.StatsRecorder;
     * @param indexSettings index settings for writer configuration
    }
            try {
import org.opensearch.parquet.memory.ArrowBufferPool;  
import java.io.IOException;
        this.schemaSupplier = schemaSupplier;  
            stats
        Schema schema,
     *                       field vectors before {@code addDoc} encounters them
    public WriteResult addDoc(ParquetDocumentInput d) throws IOException {  
            mappingVersion,
 * Parquet file writer integrating OpenSearch's {@link Writer} interface with the VSR batching layer.
     * @param stats shard-level stats tracker
            }  
import org.opensearch.parquet.bridge.ParquetFileMetadata;
 * Documents are accepted via {@link #addDoc(ParquetDocumentInput)}, batched in Arrow vectors
        return mappingVersion;
            writerGeneration,
     * @param schemaSupplier supplies the up-to-date schema when the mapping version  
    public FileInfos flush(FlushInput flushInput) throws IOException {  
        FormatChecksumStrategy checksumStrategy  
            new ParquetShardStatsTracker()
            schemaSupplier,
                this.mappingVersion  
    private final FormatChecksumStrategy checksumStrategy;  
 *  
 *
 * the {@link IndexSettings} passed at construction time and propagated to the VSR layer.
    public long generation() {  
     * @param dataFormat the Parquet data format instance
     *  
            indexSettings,
        );
    @Override
import org.opensearch.parquet.vsr.SchemaChangeRequiresWriterRotationException;
            );  
            schema,
     * @param bufferPool shared Arrow buffer pool  
    }  
        return dataFormat.name().equals(formatName) ? Optional.of(this) : Optional.empty();
        MonoFileWriterSet monoFileSet = MonoFileWriterSet.of(
import org.opensearch.index.store.FormatChecksumStrategy;
        long mappingVersion,
            dataFormat,  
 * The OpenSearch Contributors require contributions made to  
    }  
    @Override  
            Schema schema = schemaSupplier.get();  
import org.opensearch.parquet.ParquetDataFormatPlugin;
    public ParquetWriter(
            // Schema mismatch is recoverable: the VSR rejected the doc pre-admission, so the
        ArrowBufferPool bufferPool,  
            logger.trace(
    public void updateMappingVersion(long newVersion) {  
        FormatChecksumStrategy checksumStrategy,
import org.opensearch.index.engine.dataformat.WriteResult;
    private static final Logger logger = LogManager.getLogger(ParquetWriter.class);  
            checksumStrategy.registerChecksum(new FileMetadata(dataFormat.name(), fileName), metadata.crc32(), writerGeneration);
     * @param threadPool the thread pool for background native writes
import org.opensearch.index.engine.dataformat.FileInfos;  
     *                       advances, used by {@link #updateMappingVersion} to add new
            }  
            throw new IllegalStateException("rollbackTo requires ACTIVE or PENDING_ROLLBACK state but was " + state);
    @Override
 * <p>The returned {@link FileInfos} from {@link #flush(FlushInput)} contains the file path, writer
        return writerGeneration;
    public void rollbackTo(long rowCount) throws IOException {
            writerGeneration,  
            fileName,
    private final ParquetShardStatsTracker stats;
        ThreadPool threadPool,  
import org.opensearch.threadpool.ThreadPool;
                    e.getMessage()
import org.apache.logging.log4j.LogManager;  
    public Optional<Writer<?>> getWriterForFormat(String formatName) {
            return FileInfos.empty();  
     * @param mappingVersion the initial mapping version  
/*  
            // caller-driven rollback no-ops in the VSR and restores ACTIVE.  
        try {
        state = WriterState.ACTIVE;
     * @param writerGeneration generation number for this writer
import java.util.Optional;  
                "rollbackTo supports rolling back exactly 1 doc, but asked to roll back " + (acceptedRows - rowCount)
import org.opensearch.index.engine.dataformat.WriterState;
                newVersion,
                    "[Gen: {}] mapping version {} requires a new Parquet writer: {}",
import java.util.function.Supplier;
        long writerGeneration,
}
    }
