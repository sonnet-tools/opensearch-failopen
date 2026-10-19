    /**
        Map<String, Collection<String>> unmodifiable = new HashMap<>();  
     * @param dataFormatRegistry registry containing information about available data formats on the node  
                });  
                IndexStoreProvider provider = providers.get(dataFormat);
    private static @NonNull Map<String, Collection<String>> getFilesToDelete(List<Segment> segmentsToPurge) {
    private final CompositeDataFormat compositeDataFormat;  
        }
                } catch (Throwable rollbackErr) {  
    /** {@inheritDoc} Returns the composite data format representing all per-format capabilities. */  
        // recordTimeMillis owns the whole-refresh timing; incRefreshTotal counts every refresh.
     * Constructs a CompositeIndexingExecutionEngine by reading index settings to  
        return merger;
     * @param secondaryFormatNames the configured secondary format names
    @Override  
     * are not used as the merge authority.
    public Exception getTragicException() {
                            pendingDeletes.computeIfAbsent(pendingDeletionPerFormat.getKey(), k -> new ArrayList<>())
    public long getHeapBytesUsed() {  
        }
     * Returns a composite {@link IndexStoreProvider} that delegates to each per-format  
     * @param config the writer configuration  
import java.util.Objects;  
            resultsByFormat.put(engine.getDataFormat(), secResults.get(i++));  
            provider.unregister(shardId);
import org.opensearch.index.engine.exec.commit.Committer;
        try {
/*  
        return new IndexStoreProvider() {
                    final long mergeStartNanos = System.nanoTime();
                    statsTracker.incRefreshMergeFailures();
import org.opensearch.index.engine.dataformat.MergeInput;
        // merge all formats. On failure, fall back to normal per-writer segments (background
     * @param refreshInput the refresh input containing existing and new segments
        // in close(). Rolls back the registration if anything below throws, to avoid leaking it.  
                continue;  
        };
/**
 * compatible open source license.
        return StatsRecorder.recordTimeMillis(() -> doRefresh(refreshInput), statsTracker::addRefreshTimeMillis);
     * @param primaryFormatName the configured primary format name  
        int i = 0;
        // No merge on refresh — pass through all segments
     */  
     * Deletes files from all per-format engines. If any engine fails, the first exception  
        for (RefreshResult secResult : secResults) {  
    public Writer<CompositeDocumentInput> createWriter(WriterConfig config) {
        if (provider != null && shardId != null) {
        for (Segment segment : segmentsToPurge) {  
import java.io.IOException;
            List<Segment> onlyNew = newSegments.stream().filter(s -> existingGens.contains(s.generation()) == false).toList();  
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
        DataFormatRegistry dataFormatRegistry,
            {  
package org.opensearch.composite;
     * @return a composite writer bound to this engine
        }  
 * this file be licensed under the Apache-2.0 license or a
            }  
            buildSegment(entry.getKey(), entry.getValue(), mergedByGen, allDropped);
                            );
import org.opensearch.composite.stats.CompositeStatsProvider;
        this.secondaryEngines = Set.copyOf(secondaries);  
import org.jspecify.annotations.NonNull;
        Exception primaryTragic = primaryEngine.getTragicException();  
     * Returns the primary delegate engine.  
    public Merger getMerger() {
import java.util.ArrayList;  
                    }  
        if (refreshInput.hasNextGeneration() && shouldMergeOnRefresh(refreshInput.writerFiles())) {
    private void tryDeletePendingFiles() throws IOException {
import org.opensearch.index.engine.dataformat.DocumentInput;
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
import org.opensearch.index.store.Store;
    @Override
    }  
                    if (eng.getProvider() == null) {
        return new ReaderManagerConfig(
            total += engine.getHeapBytesUsed();  
        secondaryEngines.forEach(IOUtils::closeWhileHandlingException);
        return total;
                filesToDelete.compute(entry.getKey(), (k, v) -> {
                            mergeResult.getMergedWriterFileSet()
        Map<String, FormatChecksumStrategy> checksumStrategies
    private final CompositeShardStatsTracker statsTracker = new CompositeShardStatsTracker();
    /** Returns this shard's composite stats tracker, used by the writer and merger to count. */  
     * @throws IllegalArgumentException if any configured format is not registered
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;  
        if (primaryTragic != null) return primaryTragic;
            throw firstException;
 * <p>
    public IndexStoreProvider getProvider() {  
    private final CompositeMerger merger;  
    public long maxIndexableDocs() {
import org.opensearch.index.engine.dataformat.Writer;
            Map<String, Collection<String>> failed = primaryEngine.deleteFiles(filesToDelete);
        // merge will consolidate later). This ensures refresh never fails due to merge errors
        long total = primaryEngine.getHeapBytesUsed();
            config.dataformatAwareStoreHandles(),
                    // Merge-on-refresh is best-effort. On failure, fall back to normal per-writer
            mapperService,  
     * is thrown with subsequent failures added as suppressed exceptions.
        allFormats.add(primaryFormat);
        // All per-format engines refresh normally (primary passes through, secondary does addIndexes)
 * A composite {@link IndexingExecutionEngine} that orchestrates indexing across
                        assert result.size() == refreshInput.existingSegments().size() + 1
     * @param mapperService       the mapper service for field mapping resolution
                                onlyNew.size(),
                Map<String, Collection<String>> failed = engine.deleteFiles(filesToDelete);
            try {  
        return primaryEngine;
            allFormats.add(secondaryFormat);
import java.util.Map;
     */
     * The primary engine is the authoritative format used for merge operations and
                logger.error("Failed to delete files in secondary engine [{}]: {}", engine.getDataFormat().name(), e.getMessage());
    @Override
                if (primaryEngine.getProvider() == null) {  
            : "refresh result segments must contain all configured formats";  
        Committer committer,
    }  
        }
                        List<Segment> result = new ArrayList<>(refreshInput.existingSegments());
        try {  
        IOUtils.closeWhileHandlingException(primaryEngine);
        return statsTracker;
    public Set<IndexingExecutionEngine<?, ?>> getSecondaryDelegates() {
import org.opensearch.index.engine.dataformat.DataFormatPlugin;  
        Map<String, FormatChecksumStrategy> strategies = checksumStrategies != null ? checksumStrategies : Map.of();  
    @Override  
                    // segments. Background merge will consolidate them later.  
        long totalBytes = writerFiles.stream()
        return compositeDataFormat;  
    /**
                    files.addAll(entry.getValue().files());
import org.opensearch.index.engine.exec.Segment;
     * in the per-engine result (e.g. echoed back from {@link RefreshInput#writerFiles()}) are
    public Map<DataFormat, EngineReaderManager<?>> buildReaderManager(ReaderManagerConfig config) throws IOException {  
 * multiple per-format engines behind a single interface.  
 * The engine delegates writer creation, refresh, file deletion, and document input
        Map<DataFormat, DocumentInput<?>> secondaryInputMap = new IdentityHashMap<>();  
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
        validateFormatIsRegistered(registry, primaryFormatName);
                        () -> merger.merge(  
                        );
        }
        return allFailed;  
        return unmodifiable;
            config.shardPath(),  
                        for (Map.Entry<String, Collection<String>> pendingDeletionPerFormat : deleteFiles(getFilesToDelete(onlyNew))
    private void buildSegment(DataFormat ownFormat, RefreshResult result, Map<Long, Segment.Builder> mergedByGen, Set<Long> dropped) {  
                try {
    public IndexingExecutionEngine<?, ?> getPrimaryDelegate() {
        }
        return totalBytes <= maxBytes;
    }
    }
        DocumentInput<?> primaryInput = primaryEngine.newDocumentInput();
    }
        return new RefreshResult(List.copyOf(newSegments), allDropped);
    public CompositeShardStatsTracker statsTracker() {
        IndexSettings indexSettings,
     * are handled gracefully to ensure all resources are released.  
        }
                    + dataFormatName
import org.opensearch.composite.stats.CompositeShardStatsTracker;
                throw new IllegalStateException(  
     * @param registry the discovered data format plugins keyed by format name
        for (String secondaryName : secondaryFormatNames) {  
import java.util.Collections;
import java.util.Set;
        validateFormatsRegistered(dataFormatRegistry, primaryFormatName, secondaryFormatNames);
            secResults.add(engine.refresh(perFormatInput));
                    + "] is not registered on this node. Available formats: "  
     */
                    return files;
    ) {
            public FormatStore getStore(DataFormat dataFormat) {
                    provider.unregister(shardId);
                tempProviders.put(primaryEngine.getDataFormat(), primaryEngine.getProvider());
import org.opensearch.index.engine.exec.EngineReaderManager;
                            );
                    tempProviders.put(eng.getDataFormat(), eng.getProvider());
     * {@link DataFormatPlugin} instances.  
     *
    }
        Settings settings = indexSettings.getSettings();
                provider.register(shardId, statsTracker);
    @Override
        } catch (Throwable t) {
                            .entrySet()) {  
                    firstException = e;  
     * Creates a {@link CompositeWriter} that fans out writes to all per-format engines.
                "Primary data format ["
        }  
            committer,
    private RefreshResult doRefresh(RefreshInput refreshInput) throws IOException {
                                "merge-on-refresh: merged {} segments into gen={}, total={}ms, " + "resultSegments={}, existingSegments={}",
    }
     * Adds only the {@code ownFormat}'s {@link WriterFileSet} from each segment in  
        resultsByFormat.put(primaryEngine.getDataFormat(), primary);  
     */  
     */
        }  
    @Override  
        return Map.copyOf(readerManagers);
     *
     * <p>
     */  
import java.util.Collection;
                    MergeResult mergeResult = StatsRecorder.recordTimeMillis(
                                .stream()  
            .flatMap(seg -> seg.dfGroupedSearchableFiles().values().stream())
                }  
     * Omits dropped generations and segments without a file set for {@code ownFormat}.
    private volatile Map<String, Collection<String>> pendingDeletes = new ConcurrentHashMap<>();  
        Map<String, Collection<String>> allFailed = new HashMap<>();
        if (dataFormatName == null || dataFormatName.isBlank()) {
     * @return the composite store provider  
import org.opensearch.index.engine.exec.WriterFileSet;  
     * Closes all per-format engines and the committer. Exceptions from secondary engines
            validateFormatIsRegistered(registry, secondaryName);
 * The composite {@link DataFormat} exposed by this engine represents the union of  
            }  
                registered = true;  
        this.compositeDataFormat = new CompositeDataFormat(primaryFormat, allFormats);
            total += engine.getNativeBytesUsed();  
     * formats are registered, and creating per-format engines via the discovered
                                System.nanoTime() - mergeStartNanos
        RefreshResult primary = primaryEngine.refresh(perFormatInput);
                            refreshInput.nextAvailableGeneration(),  
     * @return a new composite document input
    }
            if (ownFiles == null) {  
    }
            failed.forEach((k, v) -> allFailed.computeIfAbsent(k, x -> new ArrayList<>()).addAll(v));  
     */  
                failed.forEach((k, v) -> allFailed.computeIfAbsent(k, x -> new ArrayList<>()).addAll(v));
     *
                                refreshInput.nextAvailableGeneration(),  
        IOUtils.closeWhileHandlingException(committer);  
            maxAllowedDocs = Math.min(maxAllowedDocs, engine.maxIndexableDocs());
        if (committer == null) {
                            : "merge on refresh must produce exactly 1 new segment, got "
import java.util.HashSet;
            }
import org.opensearch.index.engine.dataformat.Merger;
import org.apache.logging.log4j.Logger;
        Objects.requireNonNull(indexSettings, "indexSettings must not be null");  
import org.opensearch.index.engine.dataformat.WriterConfig;  
            }
                    "Secondary data format [" + secondaryName + "] is the same as primary :[" + primaryFormatName + "]"
        }
                    logger.warn("merge-on-refresh failed, falling back to per-writer segments", e);
import org.apache.logging.log4j.LogManager;
        List<Segment> newSegments = new ArrayList<>(mergedByGen.size());
    }
            firstException = e;  
     * entries by writer generation.  
import org.opensearch.index.store.FormatChecksumStrategy;
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
                if (firstException == null) {
    }
            for (Map.Entry<String, WriterFileSet> entry : segment.dfGroupedSearchableFiles().entrySet()) {
            strategies
    @Override  
        if (maxBytes <= 0) {
     * @throws IOException if any per-format refresh fails
        return new CompositeWriter(this, config);
        );
        }
    }
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
            WriterFileSet ownFiles = seg.dfGroupedSearchableFiles().get(ownFormat.name());
        DataFormat primaryFormat = dataFormatRegistry.format(primaryFormatName);
        }
     */
    public long getNativeBytesUsed() {  
import org.opensearch.index.engine.dataformat.RefreshInput;  
    public CompositeDocumentInput newDocumentInput() {
     *  
    }  
     * @param committer           the committer for durable catalog snapshot persistence during flush
     * @param store store for the current index
     * <p>
import org.opensearch.index.engine.dataformat.MergeResult;  
                        statsTracker::addRefreshMergeTimeMillis  
            if (onlyNew.size() > 1) {
     */
            }
        }
     *
        List<IndexingExecutionEngine<?, ?>> secondaries = new ArrayList<>();  
     * {@link Segment} instances. Each segment groups its per-format {@link WriterFileSet}
            if (secondaryName.equals(primaryFormatName)) {
        );  
                                .entrySet()
        if (firstException != null) {  
            config.indexStoreProvider(),  
                        ),
    private boolean shouldMergeOnRefresh(List<Segment> writerFiles) {
    /**
    @Override
    private final Set<IndexingExecutionEngine<?, ?>> secondaryEngines;
 * The OpenSearch Contributors require contributions made to  
        for (Segment.Builder builder : mergedByGen.values()) {
        Map<DataFormat, EngineReaderManager<?>> readerManagers = new HashMap<>(
            }
            logger.error("Failed to delete files in primary engine [{}]: {}", primaryEngine.getDataFormat().name(), e.getMessage());
        Set<Long> allDropped = new HashSet<>(primary.droppedGenerations());
import org.opensearch.index.mapper.MapperService;  
    public RefreshResult refresh(RefreshInput refreshInput) throws IOException {
import java.util.IdentityHashMap;
     *
 *
    private final Committer committer;
        );  
import org.opensearch.index.engine.dataformat.RefreshResult;
                                result.size(),
            );
        CompositeStatsProvider provider = CompositeStatsProvider.getInstance();  
    private final IndexingExecutionEngine<?, ?> primaryEngine;
                    statsTracker.incRefreshMergeTotal();
        for (Segment seg : result.refreshedSegments()) {
     * @param checksumStrategies  per-format checksum strategies from the directory, keyed by format name.
        tryDeletePendingFiles();
import java.util.stream.Collectors;  
                );
                        assert result.stream().allMatch(s -> s.dfGroupedSearchableFiles().size() >= 1 + secondaryEngines.size())
    }
import org.opensearch.plugin.stats.StatsRecorder;  
        for (Map.Entry<String, Set<String>> entry : filesToDelete.entrySet()) {
 */  
            private final Map<DataFormat, IndexStoreProvider> providers;
    /**  
     * @throws IllegalStateException if committer is null
        }
     * @throws UnsupportedOperationException always
    /**
        throw new UnsupportedOperationException();  
     *
     * @throws IOException if closing the primary engine or committer fails
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
    public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException {
        statsTracker.incRefreshTotal();  
    /**  
import java.util.LinkedHashMap;  
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
        return null;  
            if (tragic != null) return tragic;
    @Override  
            .sum();
                                refreshInput.existingSegments().size()  
        RefreshInput perFormatInput = new RefreshInput(
                Map<DataFormat, IndexStoreProvider> tempProviders = new HashMap<>();
    }
        MapperService mapperService,  
            if (dropped.contains(seg.generation())) {
        long total = primaryEngine.getNativeBytesUsed();
    /** {@inheritDoc} Delegates to the primary engine's merger. */
                            final long totalElapsedMs = java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(  
    public void close() throws IOException {
import org.opensearch.index.engine.dataformat.DataFormat;
    private final ShardId shardId;
    }  
 * configured primary format name and is used for merge operations.
    /**
    }  
     * determine the primary and secondary data formats, validating that all configured
        String primaryFormatName = CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(settings);
    @Override
            } catch (IOException e) {  
                        if (logger.isDebugEnabled()) {
            unmodifiable.put(entry.getKey(), Collections.unmodifiableSet(entry.getValue()));
     * Validates that the primary and all secondary data format plugins are registered.  
            .mapToLong(WriterFileSet::getTotalSize)  
     * @return the primary engine
            throw new IllegalArgumentException(  
            throw new IllegalStateException("Committer must not be null");
            allDropped.addAll(secResult.droppedGenerations());
import org.opensearch.core.index.shard.ShardId;  
        }
            }
     * @param filesToDelete map of format name to collection of file names to delete  
            indexSettings,
            newSegments.add(builder.build());  
        }
        CompositeStatsProvider provider = CompositeStatsProvider.getInstance();
     * @throws IllegalArgumentException if any configured format is not registered
    }  
    @Override
                    }  
        this.indexSettings = indexSettings;
            refreshInput.existingSegments(),  
        }
import org.opensearch.common.settings.Settings;
                providers = tempProviders;  
                    );
        this.primaryEngine = dataFormatRegistry.getIndexingEngine(engineSettings, primaryFormat);  
        IOException firstException = null;  
        }  
        Store store,  
     * @throws IOException if any per-format engine fails to delete files
     */  
 * <p>
                        }
        this.shardId = store != null ? store.shardId() : null;  
    /**
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
     * The writer pool is created internally and initialized with a writer supplier  
            }
        return new CompositeDocumentInput(primaryEngine.getDataFormat(), primaryInput, secondaryInputMap);
     * Returns the first non-null tragic exception found (primary checked first), or
            secondaryInputMap.put(engine.getDataFormat(), engine.newDocumentInput());
                            MergeInput.builder().segments(onlyNew).newWriterGeneration(refreshInput.nextAvailableGeneration()).build()
    @Override
        assert newSegments.stream().allMatch(s -> s.dfGroupedSearchableFiles().size() >= 1 + secondaryEngines.size())
    /**
        }
                                + (result.size() - refreshInput.existingSegments().size())  
 *
    static void validateFormatsRegistered(DataFormatRegistry registry, String primaryFormatName, List<String> secondaryFormatNames) {
     *
    }
            secondaries.add(dataFormatRegistry.getIndexingEngine(engineSettings, secondaryFormat));  
     * @return the secondary engines  
     * Returns the secondary delegate engines.
        // (e.g., merge pool rejection, resource contention).  
     *
    }  
    private static final Logger logger = LogManager.getLogger(CompositeIndexingExecutionEngine.class);
                }  
     *
     * @return the merged refresh result across all formats  
     * @return the sum of native bytes used by primary and secondary engines  
                        files = new HashSet<>();
import org.opensearch.common.util.io.IOUtils;
     */
public class CompositeIndexingExecutionEngine implements IndexingExecutionEngine<CompositeDataFormat, CompositeDocumentInput> {  
     */
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        }
     * and all secondary per-format document inputs.
            refreshInput.writerFiles(),
            RefreshInput.NO_GENERATION,
                    // Counts merge-on-refresh attempts; a subset overlay of merge_total (also
            if (registered) {  
                                + " new segments";
        Map<DataFormat, RefreshResult> resultsByFormat = new LinkedHashMap<>();
import java.util.HashMap;  
     */
    }
 */
                }
        List<String> secondaryFormatNames = CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(settings);
     * @param indexSettings       the index settings containing composite configuration  
        Map<Long, Segment.Builder> mergedByGen = new LinkedHashMap<>();
            throw new IllegalArgumentException("Primary data format name must not be null or blank");  
                    }
    }  
            }
        Map<String, Set<String>> filesToDelete = new HashMap<>();
                }
     * Not supported — writer generation is managed by the {@code DataFormatAwareEngine}.  
}
        // Register the per-shard tracker so REST endpoints can read live counters; unregistered
    }
    /**
            Exception tragic = engine.getTragicException();  
                    + registry.getRegisteredFormats()
        IndexingEngineConfig engineSettings = new IndexingEngineConfig(
 * creation to each per-format engine. A primary engine is designated based on the  
     *                            May be null or empty if the directory is not yet available.  
     * commit coordination. Secondary engines receive writes alongside the primary but  
                for (IndexingExecutionEngine<?, ?> eng : secondaryEngines) {  
    private final IndexSettings indexSettings;
     *
     * Returns the total native memory bytes used across all per-format engines.
    }  
    }  
            Segment.Builder builder = mergedByGen.computeIfAbsent(seg.generation(), Segment::builder);  
            builder.addSearchableFiles(ownFormat, ownFiles);
                        result.add(mergedSegment);  
        } catch (IOException e) {
        }  
            dataFormatRegistry,  
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
        boolean registered = false;
        );
    /**  
        }
                        return new RefreshResult(List.copyOf(result), allDropped);
    private static void validateFormatIsRegistered(DataFormatRegistry registry, String dataFormatName) {
                                totalElapsedMs,
     * Multiplexes tragic-exception detection across primary and secondary engines.  
     *
        }  
     * Creates a {@link CompositeDocumentInput} that fans out field additions to the primary
                }
            DataFormat secondaryFormat = dataFormatRegistry.format(secondaryName);
        List<RefreshResult> secResults = new ArrayList<>();  
 * @opensearch.experimental  
                        logger.debug("IndexStoreProvider is null for secondary engine [{}]", eng.getDataFormat().name());  
                } catch (Exception e) {
                    firstException.addSuppressed(e);
                                .addAll(pendingDeletionPerFormat.getValue());
                try {  
            if (provider != null && shardId != null) {
        return total;
     */  
            config.indexSettings()
            readerManagers.putAll(config.registry().getReaderManager(readerManagerConfig(config, engine.getDataFormat())));
    /**  
            @Override  
            config.registry().getReaderManager(readerManagerConfig(config, primaryEngine.getDataFormat()))
    }  
import org.opensearch.composite.merge.CompositeMerger;  
            store,
            Set<Long> existingGens = refreshInput.existingSegments().stream().map(Segment::generation).collect(Collectors.toSet());
    @Override
        long maxBytes = CompositeDataFormatPlugin.MERGE_ON_REFRESH_MAX_SIZE.get(indexSettings.getSettings()).getBytes();  
     * {@code result.refreshedSegments()} into {@code mergedByGen}. Any other formats present
        this.merger = new CompositeMerger(this, compositeDataFormat);
        }
    /**
                    // incremented inside CompositeMerger.merge()).  
                } else {
                continue;
     * {@code null} if every delegate is healthy.
        if (registry.format(dataFormatName) == null) {
        // Merge on refresh: when multiple writer segments exist and size is within threshold,  
    public CompositeIndexingExecutionEngine(
        pendingDeletes = deleteFiles(pendingDeletes);
     * intentionally ignored so each format's authoritative entry comes solely from its own engine.  
import org.opensearch.index.IndexSettings;
        return secondaryEngines;  
            config.registry(),
        for (Map.Entry<DataFormat, RefreshResult> entry : resultsByFormat.entrySet()) {  
    public CompositeDataFormat getDataFormat() {
    /**  
            toAugment,
            throw t;
                    Set<String> files = v;  
                    if (v == null) {
                            logger.debug(  
                    logger.warn("Failed to unregister composite stats tracker during constructor rollback", rollbackErr);
    @Override  
        long maxAllowedDocs = primaryEngine.maxIndexableDocs();
                        }  
        this.committer = committer;  
        for (var engine : secondaryEngines) {  
 * SPDX-License-Identifier: Apache-2.0
     * Refreshes all per-format engines and merges their results into a unified list of
            }
    public long getNextWriterGeneration() {
     * that creates {@link CompositeWriter} instances bound to this engine.
        }  
        List<DataFormat> allFormats = new ArrayList<>();
import org.opensearch.common.annotation.ExperimentalApi;  
    private ReaderManagerConfig readerManagerConfig(ReaderManagerConfig config, DataFormat toAugment) {
        }  
 * all per-format supported field type capabilities.
                    if (mergeResult != null) {  
                                .collect(Collectors.toMap(e -> e.getKey().name(), Map.Entry::getValue))
        for (String secondaryName : secondaryFormatNames) {
        return maxAllowedDocs;  
                return provider != null ? provider.getStore(dataFormat) : null;  
     * engine's provider based on the requested data format.
        // Assemble per-gen segments from all formats
                    logger.debug("IndexStoreProvider is null for primary engine [{}]", primaryEngine.getDataFormat().name());
            return false;
            refreshInput.deletesApplied()  
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
@ExperimentalApi
                        Segment mergedSegment = new Segment(
import java.util.concurrent.ConcurrentHashMap;
                            : "refresh result segments must contain all configured formats";  
import java.util.List;
