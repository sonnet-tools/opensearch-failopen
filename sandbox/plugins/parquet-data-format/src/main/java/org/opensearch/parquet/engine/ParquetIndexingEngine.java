                shardPath,
 * compatible open source license.
                e.getMessage()
    }
    /** Parquet indexing uses only native (off-heap) memory via Arrow buffers and Rust writers, no JVM heap. */
     *
    }
}
    private volatile long cachedSchemaVersion = -1;
import java.util.function.Supplier;
                "Failed to remove Parquet settings from Rust store for index [{}]: {}",
     * @param dataFormat        the Parquet data format descriptor
            if (Files.deleteIfExists(filePath) == false) {
 * <p>Node-level {@link Settings} are passed through to each {@link ParquetWriter} at creation
    private final FormatChecksumStrategy checksumStrategy;
    @Override
    }
                indexSettings.getIndex().getName(),
    private final Merger parquetMerger;
        this.shardPath = shardPath;
        );
            .bloomFilterNdv(ParquetSettings.BLOOM_FILTER_NDV.get(settings))
            .pageSizeBytes(ParquetSettings.PAGE_SIZE_BYTES.get(settings).getBytes())
            throw t;
     * @param shardPath         the shard path for file storage
     * @param nativeAllocator   the framework's unified native allocator
     * @return the full file path
    public FormatChecksumStrategy getChecksumStrategy() {
    private Supplier<Long> mappingVersionSupplier;
import org.opensearch.parquet.bridge.NativeSettings;
        );
import static org.opensearch.parquet.ParquetDataFormatPlugin.PARQUET_DATA_FORMAT;
        } catch (Throwable t) {
            .compressionLevel(ParquetSettings.COMPRESSION_LEVEL.get(settings))
    @Override
            nativeAllocator
        Supplier<Schema> schemaSupplier,
            .bloomFilterFpp(ParquetSettings.BLOOM_FILTER_FPP.get(settings))
    @Override
    public long getNativeBytesUsed() {
        this.schemaSupplier = schemaSupplier;
        return new RefreshResult(List.copyOf(segments));
    private void pushSettingsToRust() {
            mappingVersionSupplier,
import org.opensearch.parquet.writer.ParquetWriter;
     * @param additionalPrefix an optional prefix to append (e.g., "merged")
        }
            .typeBloomFilterEnabled(ParquetSettings.getTypeBloomFilterEnabled(nodeSettings))
 *
        Settings settings = indexSettings.getSettings();
        Collection<String> parquetFiles = filesToDelete.get(dataFormat.name());
            }
    /**
     * Used by the upload path to retrieve pre-computed checksums.
     *
        this.bufferPool = new ArrowBufferPool(settings, nativeAllocator);
        ShardPath shardPath,
            RustBridge.onSettingsUpdate(config);
            // Register this shard's tracker with the format-wide stats provider so the
     * @param additionalPrefix an optional prefix to append (e.g., "merged")
    private final Settings nodeSettings;
            filePath.toString(),
                failed.add(fileName);
     * @param shardPath        the shard's directory path
            fileNameBuilder.append("_").append(additionalPrefix);
        Supplier<Set<String>> lowCardinalityFieldsSupplier,
                dataFormat,
import org.opensearch.index.engine.dataformat.RefreshResult;
        throw new UnsupportedOperationException("getNextWriterGeneration not supported");
                indexSettings.getIndex().getName(),
    }
        return new ParquetWriter(
     * @param shardPath         the shard path for file storage
        return parquetMerger;
    }
     * @param mappingVersionSupplier     the supplier for mapping version resolution
     * @param schemaSupplier     the supplier for schema resolution
            new PrecomputedChecksumStrategy(),
    public ParquetIndexingEngine(
     * @param checksumStrategy  the checksum strategy to use (shared with the directory)
            }
import java.nio.file.Files;
     * @param writerGeneration the writer generation number
 * Per-shard Parquet indexing execution engine.
        try {
        segments.addAll(refreshInput.writerFiles());
        } catch (Exception e) {
                } catch (Throwable rollbackErr) {
    public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException {
        try {
import java.util.Set;
        Collection<String> failed = new ArrayList<>();
        IndexSettings indexSettings,
        return failed.isEmpty() ? Map.of() : Map.of(dataFormat.name(), failed);
        this.parquetMerger = new ParquetMergeExecutor(
        }
    @Override
            indexSettings,
            .typeEncodings(ParquetSettings.getTypeEncodings(nodeSettings))
            .indexName(indexSettings.getIndex().getName())
     * @param dataFormat        the Parquet data format descriptor
     * Builds a Parquet file name with optional additional prefix.
        ThreadPool threadPool,
            RustBridge.removeSettings(indexSettings.getIndex().getName());
        this.checksumStrategy = checksumStrategy;
/*
        return new ParquetDocumentInput();
import org.opensearch.index.store.PrecomputedChecksumStrategy;
     * @param threadPool        the thread pool for background native writes
 * </ul>
        this.nodeSettings = settings;
            .mergeRayonThreads(ParquetSettings.MERGE_RAYON_THREADS.get(nodeSettings))
    }
import org.opensearch.index.engine.dataformat.RefreshInput;
import org.opensearch.index.engine.exec.Segment;
     * Creates a new ParquetIndexingEngine with an externally provided checksum strategy.
            .mergeBatchSize(ParquetSettings.MERGE_BATCH_SIZE.get(settings))
        if (refreshInput == null) {
     * @param settings          the node-level settings
     */
                statsTracker
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
        }
            // REST endpoints can read live counters. Unregistered in close().
        return shardPath.getDataPath().resolve(subDirectory).resolve(buildParquetFileName(writerGeneration, additionalPrefix));
    @Override
import org.opensearch.common.settings.Settings;
        StringBuilder fileNameBuilder = new StringBuilder(FILE_NAME_PREFIX);
    /** Prefix for generated Parquet file names. */
 * framework. Each shard gets its own engine instance, which manages:
            provider = (ParquetStatsProvider) DataFormatStatsProviderRegistry.INSTANCE.get(ParquetStatsProvider.FORMAT_NAME);
    /**
            .lowCardinalityEnabledFields(lowCardinalityFieldsSupplier.get())
    public Merger getMerger() {
    public Writer<ParquetDocumentInput> createWriter(WriterConfig config) {
 * <p>Implements {@link IndexingExecutionEngine} to integrate with OpenSearch's data format
        if (provider != null) {
        this.dataFormat = dataFormat;
        }
     */
            provider.unregister(shardPath.getShardId());
            if (provider != null) {
            .typeBloomFilterFpp(ParquetSettings.getTypeBloomFilterFpp(nodeSettings))
import org.opensearch.parquet.stats.ParquetStatsProvider;
            .rowGroupMaxRows(ParquetSettings.ROW_GROUP_MAX_ROWS.get(settings))
import org.opensearch.parquet.writer.ParquetDocumentInput;
        // Unregister this shard's tracker from the stats provider before tearing down.
import java.io.UncheckedIOException;
        }
 *   <li>Writer creation per writer generation, each producing a separate Parquet file.</li>
import org.opensearch.parquet.bridge.RustBridge;
        ParquetStatsProvider provider = (ParquetStatsProvider) DataFormatStatsProviderRegistry.INSTANCE.get(
    public long getNextWriterGeneration() {
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
    }
            config.writerGeneration(),
            .pageRowLimit(ParquetSettings.PAGE_ROW_LIMIT.get(settings))
    private final ParquetShardStatsTracker statsTracker = new ParquetShardStatsTracker();
        long mappingVersion = mappingVersionSupplier.get();
    @Override
        return fileNameBuilder.toString();
     * @param lowCardinalityFieldsSupplier supplier of field names with the {@code low_cardinality} mapping parameter enabled
            shardPath,
    private static final Logger logger = LogManager.getLogger(ParquetIndexingEngine.class);
        ShardPath shardPath,
        if (additionalPrefix != null) {
 * extracted and applied.
            dataFormat,
import java.util.Collection;
    }
        Supplier<Long> mappingVersionSupplier,
import org.opensearch.parquet.merge.ParquetMergeExecutor;
    public static Path buildParquetFilePath(ShardPath shardPath, long writerGeneration, String additionalPrefix) {
     * @param writerGeneration the writer generation number
 * this file be licensed under the Apache-2.0 license or a
            .build();
        ParquetStatsProvider provider = null;
        }
                try {
            }
            .bloomFilterEnabled(ParquetSettings.BLOOM_FILTER_ENABLED.get(settings))
import org.opensearch.index.engine.dataformat.Merger;
    public ParquetDataFormat getDataFormat() {
        segments.addAll(refreshInput.existingSegments());
            indexSettings,
    }
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
     * @param indexSettings     the index-level settings
import org.opensearch.index.engine.dataformat.WriterConfig;
        fileNameBuilder.append("_").append(Long.toHexString(writerGeneration)).append(FILE_NAME_EXT);
        Supplier<Long> mappingVersionSupplier,
            .compressionType(ParquetSettings.COMPRESSION_TYPE.get(settings))
        String subDirectory = PARQUET_DATA_FORMAT.name();
 * time, where writer-specific settings (e.g., {@code parquet.max_rows_per_vsr}) are
            Path filePath = shardPath.getDataPath().resolve(dataFormat.name()).resolve(fileName);
    @Override
            .fieldEncodings(ParquetSettings.getFieldEncodings(settings))
                registered = true;
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.index.store.FormatChecksumStrategy;
                provider.register(shardPath.getShardId(), statsTracker);
     * @param mappingVersionSupplier     the supplier for mapping version resolution
import java.nio.file.Path;
import java.nio.file.FileAlreadyExistsException;
     * @return the formatted file name
        } catch (IOException e) {
 * <ul>
        ArrowNativeAllocator nativeAllocator
        boolean registered = false;
            bufferPool,
import org.opensearch.parquet.stats.ParquetShardStatsTracker;
            settings,
        List<Segment> segments = new ArrayList<>();
            .dictSizeBytes(ParquetSettings.DICT_SIZE_BYTES.get(settings).getBytes())
    static final String FILE_NAME_EXT = ".parquet";
import java.util.Map;
    ) {
import java.util.List;
            throw new UncheckedIOException("Failed to push Parquet settings to Rust store", e);
            lowCardinalityFieldsSupplier,
        }
    @Override
        ParquetDataFormat dataFormat,
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
                }
            .rowGroupMaxBytes(ParquetSettings.ROW_GROUP_MAX_BYTES.get(settings).getBytes())
                    logger.warn("Failed to unregister parquet stats tracker during constructor rollback", rollbackErr);
import java.io.IOException;
        Schema schema = getOrBuildSchema();
    static final String FILE_NAME_PREFIX = "_parquet_file_generation";
        return null;
            .typeBloomFilterNdv(ParquetSettings.getTypeBloomFilterNdv(nodeSettings))
            )
import org.apache.arrow.vector.types.pojo.Schema;
            logger.warn("Directory already exists: {}", shardPath.resolve("parquet"));
     * @param settings          the node-level settings
        IndexSettings indexSettings,
        this.threadPool = threadPool;
    private final ParquetDataFormat dataFormat;
 * SPDX-License-Identifier: Apache-2.0
     * Returns the checksum strategy for this engine's Parquet files.
 *
    private Schema getOrBuildSchema() {
    /**
        this(
 *
            schemaSupplier,
            pushSettingsToRust();
    ) {
        ArrowNativeAllocator nativeAllocator
     * @param indexSettings     the index-level settings
            .mergeDeferredColumnThreshold(ParquetSettings.MERGE_DEFERRED_COLUMN_THRESHOLD.get(settings))
            new NativeParquetMergeStrategy(
 */
     * @param threadPool        the thread pool for background native writes
            );
    }
    private final ArrowBufferPool bufferPool;
        } catch (FileAlreadyExistsException ex) {
    public ParquetIndexingEngine(
    public IndexStoreProvider getProvider() {
            statsTracker
        }
            threadPool,
        ParquetDataFormat dataFormat,
        Settings settings,
     * @param lowCardinalityFieldsSupplier supplier of field names with the {@code low_cardinality} mapping parameter enabled
        return schemaSupplier.get();
    private Supplier<Schema> schemaSupplier;
            logger.debug("Deleting parquet file: {}", filePath);
    /**
    }
            .mergeIoThreads(ParquetSettings.MERGE_IO_THREADS.get(nodeSettings))
        this.lowCardinalityFieldsSupplier = lowCardinalityFieldsSupplier;
            return Map.of();
     *
import org.opensearch.parquet.memory.ArrowBufferPool;
    private final ThreadPool threadPool;
            .typeCompressions(ParquetSettings.getTypeCompressions(nodeSettings))
    private volatile Schema cachedSchema;
            threadPool,
    }
            // Resolve relative file names against the shard's parquet directory
        return dataFormat;
import org.opensearch.index.shard.ShardPath;
            .fieldBloomFilterEnabled(ParquetSettings.getFieldBloomFilterEnabled(settings))
     * @param schemaSupplier     the supplier for schema resolution
        ThreadPool threadPool,
        return checksumStrategy;
     */
    @Override
    }
    private final ShardPath shardPath;
        }
    private final Supplier<Set<String>> lowCardinalityFieldsSupplier;
        return 0;
    /**
import org.opensearch.index.engine.dataformat.Writer;
        bufferPool.close();
import org.opensearch.parquet.ParquetSettings;
        FormatChecksumStrategy checksumStrategy,
    public long getHeapBytesUsed() {
        for (String fileName : parquetFiles) {
    }
        Supplier<Set<String>> lowCardinalityFieldsSupplier,
import java.util.ArrayList;
        return bufferPool.getTotalAllocatedBytes() + RustBridge.getFilteredNativeBytesUsed(shardPath.getDataPath().toString());
    public void close() throws IOException {
package org.opensearch.parquet.engine;
    }
            logger.warn(
            Files.createDirectory(shardPath.resolve(dataFormat.name()));
 */
        if (parquetFiles == null) {
     *
            this::getOrBuildSchema,
            schema,
 *   <li>Native memory usage reporting (Arrow allocations + Rust-side allocations).</li>
    @Override
    @Override
/**
        } catch (IOException e) {
            if (registered && provider != null) {
    }
    }
    private final IndexSettings indexSettings;
 * The OpenSearch Contributors require contributions made to
    @Override
            .sortInMemoryThresholdBytes(ParquetSettings.SORT_IN_MEMORY_THRESHOLD.get(settings).getBytes())
     * Creates a new ParquetIndexingEngine.
     */
                    provider.unregister(shardPath.getShardId());
     * Builds a full file path for a Parquet file within the shard's data directory.
        this.mappingVersionSupplier = mappingVersionSupplier;
     */
        this.indexSettings = indexSettings;
    public static String buildParquetFileName(long writerGeneration, String additionalPrefix) {
            checksumStrategy,
                checksumStrategy::registerChecksum,
        Supplier<Schema> schemaSupplier,
import org.opensearch.index.IndexSettings;
import org.opensearch.parquet.merge.NativeParquetMergeStrategy;
        Path filePath = buildParquetFilePath(shardPath, config.writerGeneration(), null);
    /** File extension for Parquet files. */
        try {
    public ParquetDocumentInput newDocumentInput() {
            // /_plugins/parquet/{index}/_stats and /_plugins/parquet/_nodes/{nodeId}/_stats
    }
            return new RefreshResult(List.of());
        );
                logger.warn("Failed to delete parquet file: {}", filePath);
    public RefreshResult refresh(RefreshInput refreshInput) throws IOException {
        NativeSettings config = NativeSettings.builder()
 *   <li>A shared {@link ArrowBufferPool} for Arrow memory allocation across all writers.</li>
            mappingVersion,
            dataFormat,
            .fieldCompressions(ParquetSettings.getFieldCompressions(settings))
public class ParquetIndexingEngine implements IndexingExecutionEngine<ParquetDataFormat, ParquetDocumentInput> {
        Settings settings,
        );
            throw new RuntimeException(e);
        try {
            ParquetStatsProvider.FORMAT_NAME
