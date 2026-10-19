        try {
import org.opensearch.parquet.stats.ParquetStatsProvider;
    /**
            throw new UncheckedIOException("Failed to push Parquet settings to Rust store", e);
            throw new RuntimeException(e);  
import org.opensearch.index.engine.exec.Segment;
    private void pushSettingsToRust() {
            logger.warn("Directory already exists: {}", shardPath.resolve("parquet"));
        }
                "Failed to remove Parquet settings from Rust store for index [{}]: {}",  
import java.nio.file.FileAlreadyExistsException;  
        segments.addAll(refreshInput.writerFiles());  
        } catch (Throwable t) {
            fileNameBuilder.append("_").append(additionalPrefix);
     */  
        ParquetDataFormat dataFormat,
     * @return the full file path
    @Override
     * @param threadPool        the thread pool for background native writes
 * The OpenSearch Contributors require contributions made to  
 */  
                }
        } catch (FileAlreadyExistsException ex) {  
            this::getOrBuildSchema,
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
    public long getHeapBytesUsed() {  
        if (refreshInput == null) {
            ParquetStatsProvider.FORMAT_NAME  
            .fieldCompressions(ParquetSettings.getFieldCompressions(settings))
import java.util.Map;  
            checksumStrategy,
    }  
    }  
    @Override  
import org.opensearch.parquet.memory.ArrowBufferPool;  
                e.getMessage()
            dataFormat,
            .mergeDeferredColumnThreshold(ParquetSettings.MERGE_DEFERRED_COLUMN_THRESHOLD.get(settings))  
    /** Parquet indexing uses only native (off-heap) memory via Arrow buffers and Rust writers, no JVM heap. */
     */
import org.opensearch.index.engine.dataformat.RefreshInput;  
import org.opensearch.index.store.PrecomputedChecksumStrategy;
        String subDirectory = PARQUET_DATA_FORMAT.name();
            .typeBloomFilterNdv(ParquetSettings.getTypeBloomFilterNdv(nodeSettings))
            .rowGroupMaxRows(ParquetSettings.ROW_GROUP_MAX_ROWS.get(settings))  
    public FormatChecksumStrategy getChecksumStrategy() {
     * Used by the upload path to retrieve pre-computed checksums.
     * @param settings          the node-level settings  
    @Override
     * @param mappingVersionSupplier     the supplier for mapping version resolution
    public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException {  
    private final ArrowBufferPool bufferPool;
 *   <li>Native memory usage reporting (Arrow allocations + Rust-side allocations).</li>
        return schemaSupplier.get();
    }  
     * @param shardPath         the shard path for file storage  
        ArrowNativeAllocator nativeAllocator  
     * @param indexSettings     the index-level settings  
        long mappingVersion = mappingVersionSupplier.get();
import org.opensearch.parquet.writer.ParquetDocumentInput;
    private final ParquetShardStatsTracker statsTracker = new ParquetShardStatsTracker();
     *  
import org.opensearch.index.IndexSettings;  
    }
    public ParquetDataFormat getDataFormat() {
        try {
            }
    ) {
 * time, where writer-specific settings (e.g., {@code parquet.max_rows_per_vsr}) are  
            provider.unregister(shardPath.getShardId());  
                checksumStrategy::registerChecksum,
        this.mappingVersionSupplier = mappingVersionSupplier;  
import org.opensearch.common.settings.Settings;
    private final Merger parquetMerger;  
            .fieldBloomFilterEnabled(ParquetSettings.getFieldBloomFilterEnabled(settings))
    /**  
import org.opensearch.index.engine.dataformat.Writer;
            .bloomFilterEnabled(ParquetSettings.BLOOM_FILTER_ENABLED.get(settings))
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
        // Unregister this shard's tracker from the stats provider before tearing down.
            schema,  
     * Builds a full file path for a Parquet file within the shard's data directory.  
            shardPath,
            new PrecomputedChecksumStrategy(),
            RustBridge.removeSettings(indexSettings.getIndex().getName());  
    private Supplier<Schema> schemaSupplier;
            new NativeParquetMergeStrategy(  
        this.lowCardinalityFieldsSupplier = lowCardinalityFieldsSupplier;
import java.util.Set;
    public long getNativeBytesUsed() {
        bufferPool.close();
            .mergeRayonThreads(ParquetSettings.MERGE_RAYON_THREADS.get(nodeSettings))
        this.threadPool = threadPool;
            dataFormat,
            logger.warn(
    }
 * </ul>  
     */
     * @param schemaSupplier     the supplier for schema resolution
    }  
            // /_plugins/parquet/{index}/_stats and /_plugins/parquet/_nodes/{nodeId}/_stats
        this.dataFormat = dataFormat;  
import org.apache.arrow.vector.types.pojo.Schema;
            indexSettings,  
     * @param dataFormat        the Parquet data format descriptor
            .fieldEncodings(ParquetSettings.getFieldEncodings(settings))  
            return Map.of();  
            .lowCardinalityEnabledFields(lowCardinalityFieldsSupplier.get())  
        Settings settings,
import org.opensearch.index.engine.dataformat.WriterConfig;  
 *   <li>Writer creation per writer generation, each producing a separate Parquet file.</li>
    private Supplier<Long> mappingVersionSupplier;  
        this.bufferPool = new ArrowBufferPool(settings, nativeAllocator);
     * @param dataFormat        the Parquet data format descriptor
        );
 * this file be licensed under the Apache-2.0 license or a
        Collection<String> failed = new ArrayList<>();
    public IndexStoreProvider getProvider() {  
        Settings settings = indexSettings.getSettings();  
            .rowGroupMaxBytes(ParquetSettings.ROW_GROUP_MAX_BYTES.get(settings).getBytes())
            logger.debug("Deleting parquet file: {}", filePath);  
import org.opensearch.index.engine.dataformat.Merger;
    private volatile long cachedSchemaVersion = -1;
public class ParquetIndexingEngine implements IndexingExecutionEngine<ParquetDataFormat, ParquetDocumentInput> {  
    public RefreshResult refresh(RefreshInput refreshInput) throws IOException {  
/*  
     * @param lowCardinalityFieldsSupplier supplier of field names with the {@code low_cardinality} mapping parameter enabled  
        throw new UnsupportedOperationException("getNextWriterGeneration not supported");  
        boolean registered = false;
        );
                logger.warn("Failed to delete parquet file: {}", filePath);
        this.parquetMerger = new ParquetMergeExecutor(
            }
        NativeSettings config = NativeSettings.builder()
            )  
     * @param additionalPrefix an optional prefix to append (e.g., "merged")
    public static String buildParquetFileName(long writerGeneration, String additionalPrefix) {
        return failed.isEmpty() ? Map.of() : Map.of(dataFormat.name(), failed);  
    private final ThreadPool threadPool;
import java.nio.file.Path;
        ShardPath shardPath,  
            return new RefreshResult(List.of());
 *
            .compressionLevel(ParquetSettings.COMPRESSION_LEVEL.get(settings))
            provider = (ParquetStatsProvider) DataFormatStatsProviderRegistry.INSTANCE.get(ParquetStatsProvider.FORMAT_NAME);  
        }
        Path filePath = buildParquetFilePath(shardPath, config.writerGeneration(), null);  
}  
        } catch (Exception e) {
            .typeCompressions(ParquetSettings.getTypeCompressions(nodeSettings))
                provider.register(shardPath.getShardId(), statsTracker);
import org.opensearch.parquet.writer.ParquetWriter;  
        return new RefreshResult(List.copyOf(segments));
            mappingVersion,
        ShardPath shardPath,  
     * @param threadPool        the thread pool for background native writes
     * Creates a new ParquetIndexingEngine.
     *
        }  
            .typeBloomFilterEnabled(ParquetSettings.getTypeBloomFilterEnabled(nodeSettings))  
     * @param settings          the node-level settings
    @Override
    private static final Logger logger = LogManager.getLogger(ParquetIndexingEngine.class);
    public ParquetDocumentInput newDocumentInput() {
            // Resolve relative file names against the shard's parquet directory
            statsTracker  
import java.util.ArrayList;  
 * <p>Node-level {@link Settings} are passed through to each {@link ParquetWriter} at creation
            lowCardinalityFieldsSupplier,
        this.checksumStrategy = checksumStrategy;  
/**  
            bufferPool,
import org.opensearch.parquet.ParquetSettings;  
    public Merger getMerger() {
        Supplier<Schema> schemaSupplier,
    }
    }
import org.opensearch.parquet.bridge.NativeSettings;
        return fileNameBuilder.toString();
    }
        this(
            if (Files.deleteIfExists(filePath) == false) {
    }  
            .bloomFilterNdv(ParquetSettings.BLOOM_FILTER_NDV.get(settings))
        Settings settings,
 * <ul>
            .mergeBatchSize(ParquetSettings.MERGE_BATCH_SIZE.get(settings))
        }
        ParquetStatsProvider provider = (ParquetStatsProvider) DataFormatStatsProviderRegistry.INSTANCE.get(
     * @param nativeAllocator   the framework's unified native allocator
    ) {
            config.writerGeneration(),  
            // Register this shard's tracker with the format-wide stats provider so the  
                shardPath,  
    @Override  
import org.opensearch.threadpool.ThreadPool;
import org.apache.logging.log4j.LogManager;
        StringBuilder fileNameBuilder = new StringBuilder(FILE_NAME_PREFIX);
    private final FormatChecksumStrategy checksumStrategy;
                    logger.warn("Failed to unregister parquet stats tracker during constructor rollback", rollbackErr);
     * @param additionalPrefix an optional prefix to append (e.g., "merged")
            .dictSizeBytes(ParquetSettings.DICT_SIZE_BYTES.get(settings).getBytes())
        FormatChecksumStrategy checksumStrategy,  
import org.opensearch.parquet.merge.ParquetMergeExecutor;
                indexSettings.getIndex().getName(),
            if (provider != null) {
 * <p>Implements {@link IndexingExecutionEngine} to integrate with OpenSearch's data format  
        if (provider != null) {
        IndexSettings indexSettings,
            .sortInMemoryThresholdBytes(ParquetSettings.SORT_IN_MEMORY_THRESHOLD.get(settings).getBytes())
    private final ShardPath shardPath;
        Schema schema = getOrBuildSchema();
        ParquetDataFormat dataFormat,
    /** File extension for Parquet files. */  
    @Override  
     * Creates a new ParquetIndexingEngine with an externally provided checksum strategy.
        }
        Supplier<Long> mappingVersionSupplier,
     * @param schemaSupplier     the supplier for schema resolution  
import java.util.Collection;
import org.opensearch.parquet.stats.ParquetShardStatsTracker;  
            .compressionType(ParquetSettings.COMPRESSION_TYPE.get(settings))  
 *
     * @param writerGeneration the writer generation number  
import org.opensearch.index.shard.ShardPath;  
        try {
 * extracted and applied.
        return new ParquetWriter(
    }
        fileNameBuilder.append("_").append(Long.toHexString(writerGeneration)).append(FILE_NAME_EXT);  
import org.opensearch.index.engine.dataformat.RefreshResult;
        Supplier<Long> mappingVersionSupplier,
    @Override
    public Writer<ParquetDocumentInput> createWriter(WriterConfig config) {  
    /**
        return dataFormat;
 */
    }  
import java.nio.file.Files;
        Supplier<Schema> schemaSupplier,
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
        for (String fileName : parquetFiles) {  
        ParquetStatsProvider provider = null;  
    public ParquetIndexingEngine(  
     *
                indexSettings.getIndex().getName(),
     * @param writerGeneration the writer generation number  
            .typeEncodings(ParquetSettings.getTypeEncodings(nodeSettings))
    }
    private volatile Schema cachedSchema;  
            .indexName(indexSettings.getIndex().getName())
            throw t;
            .pageSizeBytes(ParquetSettings.PAGE_SIZE_BYTES.get(settings).getBytes())
 *   <li>A shared {@link ArrowBufferPool} for Arrow memory allocation across all writers.</li>  
        try {
 * compatible open source license.
            threadPool,
            if (registered && provider != null) {  
    private final IndexSettings indexSettings;
    private Schema getOrBuildSchema() {
import org.opensearch.parquet.merge.NativeParquetMergeStrategy;
     * @return the formatted file name
import org.opensearch.index.store.FormatChecksumStrategy;
    /**  
            RustBridge.onSettingsUpdate(config);
                } catch (Throwable rollbackErr) {  
        if (additionalPrefix != null) {  
            // REST endpoints can read live counters. Unregistered in close().
     * @param lowCardinalityFieldsSupplier supplier of field names with the {@code low_cardinality} mapping parameter enabled
    private final ParquetDataFormat dataFormat;  
            .build();  
            pushSettingsToRust();
     *
            );  
 * Per-shard Parquet indexing execution engine.
        return shardPath.getDataPath().resolve(subDirectory).resolve(buildParquetFileName(writerGeneration, additionalPrefix));  
     * @param indexSettings     the index-level settings
    }  
            threadPool,
     * @param shardPath         the shard path for file storage
    }
            }  
     */  
        this.nodeSettings = settings;
import org.apache.logging.log4j.Logger;  
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
        return checksumStrategy;
                failed.add(fileName);  
            schemaSupplier,  
     * @param shardPath        the shard's directory path
    @Override
        Supplier<Set<String>> lowCardinalityFieldsSupplier,  
            settings,  
        return new ParquetDocumentInput();
            nativeAllocator  
        );
    /** Prefix for generated Parquet file names. */
        this.schemaSupplier = schemaSupplier;
        } catch (IOException e) {
            filePath.toString(),
        ThreadPool threadPool,
            mappingVersionSupplier,
    private final Supplier<Set<String>> lowCardinalityFieldsSupplier;
    static final String FILE_NAME_EXT = ".parquet";
                statsTracker
     */
        List<Segment> segments = new ArrayList<>();
 * framework. Each shard gets its own engine instance, which manages:
        this.shardPath = shardPath;
    @Override
    public void close() throws IOException {  
    }
            indexSettings,  
                try {
        return bufferPool.getTotalAllocatedBytes() + RustBridge.getFilteredNativeBytesUsed(shardPath.getDataPath().toString());  
import static org.opensearch.parquet.ParquetDataFormatPlugin.PARQUET_DATA_FORMAT;
                registered = true;  
            .bloomFilterFpp(ParquetSettings.BLOOM_FILTER_FPP.get(settings))  
    static final String FILE_NAME_PREFIX = "_parquet_file_generation";
        Collection<String> parquetFiles = filesToDelete.get(dataFormat.name());
import java.io.IOException;
        return null;
import org.opensearch.parquet.bridge.RustBridge;
import java.util.function.Supplier;
    public long getNextWriterGeneration() {
    }  
                dataFormat,
     * Returns the checksum strategy for this engine's Parquet files.  
        this.indexSettings = indexSettings;  
     * Builds a Parquet file name with optional additional prefix.
    }
import java.io.UncheckedIOException;
    /**
        Supplier<Set<String>> lowCardinalityFieldsSupplier,  
     * @param mappingVersionSupplier     the supplier for mapping version resolution
        );
        ArrowNativeAllocator nativeAllocator
        ThreadPool threadPool,
            Files.createDirectory(shardPath.resolve(dataFormat.name()));
        }
 *
            Path filePath = shardPath.getDataPath().resolve(dataFormat.name()).resolve(fileName);
        } catch (IOException e) {  
        IndexSettings indexSettings,
    private final Settings nodeSettings;  
    @Override
            .pageRowLimit(ParquetSettings.PAGE_ROW_LIMIT.get(settings))  
        segments.addAll(refreshInput.existingSegments());
package org.opensearch.parquet.engine;
import java.util.List;
                    provider.unregister(shardPath.getShardId());
        if (parquetFiles == null) {
        return parquetMerger;
            .typeBloomFilterFpp(ParquetSettings.getTypeBloomFilterFpp(nodeSettings))
        return 0;
            .mergeIoThreads(ParquetSettings.MERGE_IO_THREADS.get(nodeSettings))
        }
    public ParquetIndexingEngine(  
 * SPDX-License-Identifier: Apache-2.0
     * @param checksumStrategy  the checksum strategy to use (shared with the directory)  
        }
        }
    @Override
    public static Path buildParquetFilePath(ShardPath shardPath, long writerGeneration, String additionalPrefix) {
    @Override  
