                    tempProviders.put(eng.getDataFormat(), eng.getProvider());
     * {@link DataFormatPlugin} instances.
                    }
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
        boolean registered = false;
        this.secondaryEngines = Set.copyOf(secondaries);
        }
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
                    statsTracker.incRefreshMergeFailures();
        long totalBytes = writerFiles.stream()
        this.shardId = store != null ? store.shardId() : null;
     *
        List<DataFormat> allFormats = new ArrayList<>();
     */
        }
        Map<DataFormat, RefreshResult> resultsByFormat = new LinkedHashMap<>();
     * @return a new composite document input
        } catch (Throwable t) {
    }
     * engine's provider based on the requested data format.
        }
        }
        Map<String, Collection<String>> allFailed = new HashMap<>();
     * Deletes files from all per-format engines. If any engine fails, the first exception
                    }
    private RefreshResult doRefresh(RefreshInput refreshInput) throws IOException {
                                .addAll(pendingDeletionPerFormat.getValue());
        Map<String, Collection<String>> unmodifiable = new HashMap<>();
                            : "refresh result segments must contain all configured formats";
                                onlyNew.size(),
package org.opensearch.composite;
        // Merge on refresh: when multiple writer segments exist and size is within threshold,
    }
        }
        for (Map.Entry<String, Set<String>> entry : filesToDelete.entrySet()) {
import org.opensearch.index.engine.dataformat.MergeResult;
                throw new IllegalStateException(
    /** {@inheritDoc} Returns the composite data format representing all per-format capabilities. */
     * Omits dropped generations and segments without a file set for {@code ownFormat}.
            try {
            List<Segment> onlyNew = newSegments.stream().filter(s -> existingGens.contains(s.generation()) == false).toList();
     * {@code null} if every delegate is healthy.
import org.opensearch.common.annotation.ExperimentalApi;
    private static void validateFormatIsRegistered(DataFormatRegistry registry, String dataFormatName) {
     *
 * <p>
    private final CompositeMerger merger;
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
    private volatile Map<String, Collection<String>> pendingDeletes = new ConcurrentHashMap<>();
import org.opensearch.index.engine.exec.EngineReaderManager;
        return total;
import org.opensearch.index.engine.exec.Segment;
                }
import java.util.Objects;
    }
            maxAllowedDocs = Math.min(maxAllowedDocs, engine.maxIndexableDocs());
     */
import org.opensearch.index.engine.dataformat.DocumentInput;
        return totalBytes <= maxBytes;
        }
            total += engine.getHeapBytesUsed();
                continue;
    }
    public CompositeDataFormat getDataFormat() {
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
        Map<String, Set<String>> filesToDelete = new HashMap<>();
            if (onlyNew.size() > 1) {
        }
                continue;
/**
            throw firstException;
     * @param dataFormatRegistry registry containing information about available data formats on the node
                filesToDelete.compute(entry.getKey(), (k, v) -> {
    @Override
            readerManagers.putAll(config.registry().getReaderManager(readerManagerConfig(config, engine.getDataFormat())));
        statsTracker.incRefreshTotal();
            resultsByFormat.put(engine.getDataFormat(), secResults.get(i++));
     */
 * The engine delegates writer creation, refresh, file deletion, and document input
    }
        );
            newSegments.add(builder.build());
                                result.size(),
import org.opensearch.index.engine.dataformat.Merger;
import org.opensearch.index.store.Store;
                        result.add(mergedSegment);
                failed.forEach((k, v) -> allFailed.computeIfAbsent(k, x -> new ArrayList<>()).addAll(v));
    /** Returns this shard's composite stats tracker, used by the writer and merger to count. */
import org.opensearch.index.engine.dataformat.Writer;
        DataFormat primaryFormat = dataFormatRegistry.format(primaryFormatName);
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
    /**
import java.util.LinkedHashMap;
                } catch (Throwable rollbackErr) {
    }
            buildSegment(entry.getKey(), entry.getValue(), mergedByGen, allDropped);
            public FormatStore getStore(DataFormat dataFormat) {
    private void tryDeletePendingFiles() throws IOException {
                    firstException = e;
    }
        List<RefreshResult> secResults = new ArrayList<>();
            Map<String, Collection<String>> failed = primaryEngine.deleteFiles(filesToDelete);
                    MergeResult mergeResult = StatsRecorder.recordTimeMillis(
    private final IndexingExecutionEngine<?, ?> primaryEngine;
 * SPDX-License-Identifier: Apache-2.0
                IndexStoreProvider provider = providers.get(dataFormat);
        this.compositeDataFormat = new CompositeDataFormat(primaryFormat, allFormats);
    private static @NonNull Map<String, Collection<String>> getFilesToDelete(List<Segment> segmentsToPurge) {
        }
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
                try {
        Map<String, FormatChecksumStrategy> checksumStrategies
     * is thrown with subsequent failures added as suppressed exceptions.
    /**
import java.util.List;
import org.opensearch.index.engine.dataformat.MergeInput;
            if (secondaryName.equals(primaryFormatName)) {
    public void close() throws IOException {
 * @opensearch.experimental
            total += engine.getNativeBytesUsed();
import java.util.Set;
                        assert result.stream().allMatch(s -> s.dfGroupedSearchableFiles().size() >= 1 + secondaryEngines.size())
    public long getNativeBytesUsed() {
    public CompositeShardStatsTracker statsTracker() {
        Exception primaryTragic = primaryEngine.getTragicException();
            if (ownFiles == null) {
     */
     */
import org.opensearch.core.index.shard.ShardId;
        return primaryEngine;
     * <p>
            }
            indexSettings,
import org.jspecify.annotations.NonNull;
        IndexingEngineConfig engineSettings = new IndexingEngineConfig(
import java.util.stream.Collectors;
            if (registered) {
     * @throws IOException if any per-format refresh fails
    private void buildSegment(DataFormat ownFormat, RefreshResult result, Map<Long, Segment.Builder> mergedByGen, Set<Long> dropped) {
            secondaryInputMap.put(engine.getDataFormat(), engine.newDocumentInput());
                            );
        Set<Long> allDropped = new HashSet<>(primary.droppedGenerations());
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
        allFormats.add(primaryFormat);
     * in the per-engine result (e.g. echoed back from {@link RefreshInput#writerFiles()}) are
        for (Map.Entry<DataFormat, RefreshResult> entry : resultsByFormat.entrySet()) {
     * @param mapperService       the mapper service for field mapping resolution
        // All per-format engines refresh normally (primary passes through, secondary does addIndexes)
        Map<String, FormatChecksumStrategy> strategies = checksumStrategies != null ? checksumStrategies : Map.of();
     * @param config the writer configuration
                    statsTracker.incRefreshMergeTotal();
    /**
     * Multiplexes tragic-exception detection across primary and secondary engines.
     * @throws IllegalArgumentException if any configured format is not registered
import org.opensearch.index.engine.dataformat.RefreshInput;
                    // Merge-on-refresh is best-effort. On failure, fall back to normal per-writer
import java.util.Collection;
        this.primaryEngine = dataFormatRegistry.getIndexingEngine(engineSettings, primaryFormat);
     * @return the composite store provider
        int i = 0;
 * multiple per-format engines behind a single interface.
        }
     * are handled gracefully to ensure all resources are released.
    }
    /**
        Map<Long, Segment.Builder> mergedByGen = new LinkedHashMap<>();
                                + " new segments";
        }
                        Segment mergedSegment = new Segment(
                        }
     * @return the merged refresh result across all formats
                    // incremented inside CompositeMerger.merge()).
     * <p>
import org.opensearch.common.settings.Settings;
            refreshInput.writerFiles(),
    public Merger getMerger() {
            refreshInput.deletesApplied()
import java.util.Collections;
        for (var engine : secondaryEngines) {
        }
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
        );
     */
 * A composite {@link IndexingExecutionEngine} that orchestrates indexing across
     */
        return maxAllowedDocs;
            throw new IllegalArgumentException(
    public IndexStoreProvider getProvider() {
    @Override
        List<IndexingExecutionEngine<?, ?>> secondaries = new ArrayList<>();
        );
                        );
        if (dataFormatName == null || dataFormatName.isBlank()) {
        }
            allFormats.add(secondaryFormat);
                registered = true;
    }
import org.opensearch.index.engine.dataformat.WriterConfig;
        return Map.copyOf(readerManagers);
            store,
    @Override
        List<String> secondaryFormatNames = CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(settings);
                        return new RefreshResult(List.copyOf(result), allDropped);
            unmodifiable.put(entry.getKey(), Collections.unmodifiableSet(entry.getValue()));
                });
                    Set<String> files = v;
/*
    public long getHeapBytesUsed() {
     * Returns the first non-null tragic exception found (primary checked first), or
    @Override
                                .stream()
            }
     *                            May be null or empty if the directory is not yet available.
import java.io.IOException;
            DataFormat secondaryFormat = dataFormatRegistry.format(secondaryName);
            failed.forEach((k, v) -> allFailed.computeIfAbsent(k, x -> new ArrayList<>()).addAll(v));
        this.indexSettings = indexSettings;
        if (registry.format(dataFormatName) == null) {
            toAugment,
            throw t;
    public Set<IndexingExecutionEngine<?, ?>> getSecondaryDelegates() {
    /**
        }
    @Override
     * Returns the total native memory bytes used across all per-format engines.
        DocumentInput<?> primaryInput = primaryEngine.newDocumentInput();
        for (Segment.Builder builder : mergedByGen.values()) {
     * Validates that the primary and all secondary data format plugins are registered.
     * @throws IllegalStateException if committer is null
    private ReaderManagerConfig readerManagerConfig(ReaderManagerConfig config, DataFormat toAugment) {
import org.opensearch.index.engine.exec.WriterFileSet;
 * creation to each per-format engine. A primary engine is designated based on the
            if (provider != null && shardId != null) {
        return merger;
            }
                    );
                                "merge-on-refresh: merged {} segments into gen={}, total={}ms, " + "resultSegments={}, existingSegments={}",
        for (RefreshResult secResult : secResults) {
    /**
                    return files;
        // in close(). Rolls back the registration if anything below throws, to avoid leaking it.
import org.apache.logging.log4j.LogManager;
 * this file be licensed under the Apache-2.0 license or a
            }
     *
        }
        IOException firstException = null;
import org.opensearch.index.IndexSettings;
                    if (eng.getProvider() == null) {
        return allFailed;
        }
    ) {
     * @param indexSettings       the index settings containing composite configuration
        return total;
            @Override
    public long getNextWriterGeneration() {
 *
        };
     * Returns the primary delegate engine.
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
                    firstException.addSuppressed(e);
        }
    }
            config.shardPath(),
        if (maxBytes <= 0) {
     */
                Map<DataFormat, IndexStoreProvider> tempProviders = new HashMap<>();
                    + dataFormatName
                }
 * The composite {@link DataFormat} exposed by this engine represents the union of
import org.opensearch.index.engine.exec.commit.Committer;
                }
     * @throws UnsupportedOperationException always
        // Register the per-shard tracker so REST endpoints can read live counters; unregistered
    }
     *
    }
     *
        return statsTracker;
                } catch (Exception e) {
        }
            strategies
            .mapToLong(WriterFileSet::getTotalSize)
        }
     *
        CompositeStatsProvider provider = CompositeStatsProvider.getInstance();
        List<Segment> newSegments = new ArrayList<>(mergedByGen.size());
    }
import org.opensearch.composite.stats.CompositeStatsProvider;
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
     * @return a composite writer bound to this engine
                    // segments. Background merge will consolidate them later.
     * @param registry the discovered data format plugins keyed by format name
     * Not supported — writer generation is managed by the {@code DataFormatAwareEngine}.
     * @throws IOException if any per-format engine fails to delete files
        resultsByFormat.put(primaryEngine.getDataFormat(), primary);
            provider.unregister(shardId);
    @Override
        for (String secondaryName : secondaryFormatNames) {
     */
     * intentionally ignored so each format's authoritative entry comes solely from its own engine.
        for (Segment seg : result.refreshedSegments()) {
                logger.error("Failed to delete files in secondary engine [{}]: {}", engine.getDataFormat().name(), e.getMessage());
     * @param store store for the current index
     * {@code result.refreshedSegments()} into {@code mergedByGen}. Any other formats present
        assert newSegments.stream().allMatch(s -> s.dfGroupedSearchableFiles().size() >= 1 + secondaryEngines.size())
    /**
public class CompositeIndexingExecutionEngine implements IndexingExecutionEngine<CompositeDataFormat, CompositeDocumentInput> {
     * and all secondary per-format document inputs.
        Objects.requireNonNull(indexSettings, "indexSettings must not be null");
                if (primaryEngine.getProvider() == null) {
     * Adds only the {@code ownFormat}'s {@link WriterFileSet} from each segment in
    public RefreshResult refresh(RefreshInput refreshInput) throws IOException {
        }
                }
 * compatible open source license.
     * Creates a {@link CompositeWriter} that fans out writes to all per-format engines.
                            mergeResult.getMergedWriterFileSet()
     * that creates {@link CompositeWriter} instances bound to this engine.
import org.opensearch.composite.merge.CompositeMerger;
                            final long totalElapsedMs = java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(
            return false;
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
                                .entrySet()
    public IndexingExecutionEngine<?, ?> getPrimaryDelegate() {
     * @return the sum of native bytes used by primary and secondary engines
 * <p>
                                totalElapsedMs,
        this.merger = new CompositeMerger(this, compositeDataFormat);
import org.opensearch.composite.stats.CompositeShardStatsTracker;
            : "refresh result segments must contain all configured formats";
    /**
     *
import org.apache.logging.log4j.Logger;
        // recordTimeMillis owns the whole-refresh timing; incRefreshTotal counts every refresh.
        return new IndexStoreProvider() {
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
            if (tragic != null) return tragic;
            WriterFileSet ownFiles = seg.dfGroupedSearchableFiles().get(ownFormat.name());
            config.indexSettings()
    @Override
    private final Set<IndexingExecutionEngine<?, ?>> secondaryEngines;
     * @return the secondary engines
        long maxAllowedDocs = primaryEngine.maxIndexableDocs();
            Segment.Builder builder = mergedByGen.computeIfAbsent(seg.generation(), Segment::builder);
    static void validateFormatsRegistered(DataFormatRegistry registry, String primaryFormatName, List<String> secondaryFormatNames) {
        for (String secondaryName : secondaryFormatNames) {
     *
        Settings settings = indexSettings.getSettings();
                    + "] is not registered on this node. Available formats: "
    /**
                        files = new HashSet<>();
    }
        }
    }
    @Override
 */
                tempProviders.put(primaryEngine.getDataFormat(), primaryEngine.getProvider());
import org.opensearch.index.engine.dataformat.DataFormat;
                    if (v == null) {
 * configured primary format name and is used for merge operations.
            secResults.add(engine.refresh(perFormatInput));
            mapperService,
        }
        // Assemble per-gen segments from all formats
        pendingDeletes = deleteFiles(pendingDeletes);
     *
        if (firstException != null) {
     * @param filesToDelete map of format name to collection of file names to delete
                    logger.warn("Failed to unregister composite stats tracker during constructor rollback", rollbackErr);
        try {
    @Override
                        for (Map.Entry<String, Collection<String>> pendingDeletionPerFormat : deleteFiles(getFilesToDelete(onlyNew))
        Map<DataFormat, EngineReaderManager<?>> readerManagers = new HashMap<>(
                                + (result.size() - refreshInput.existingSegments().size())
                                refreshInput.existingSegments().size()
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
            allDropped.addAll(secResult.droppedGenerations());
    }
        return StatsRecorder.recordTimeMillis(() -> doRefresh(refreshInput), statsTracker::addRefreshTimeMillis);
                    logger.warn("merge-on-refresh failed, falling back to per-writer segments", e);
    }
            for (Map.Entry<String, WriterFileSet> entry : segment.dfGroupedSearchableFiles().entrySet()) {
import java.util.HashMap;
    private final ShardId shardId;
    }
        for (Segment segment : segmentsToPurge) {
    public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException {
        } catch (IOException e) {
    private static final Logger logger = LogManager.getLogger(CompositeIndexingExecutionEngine.class);
        // merge all formats. On failure, fall back to normal per-writer segments (background
            }
    }
    /**
            }
    }
        // No merge on refresh — pass through all segments
                    "Secondary data format [" + secondaryName + "] is the same as primary :[" + primaryFormatName + "]"
     * {@link Segment} instances. Each segment groups its per-format {@link WriterFileSet}
        );
        return new RefreshResult(List.copyOf(newSegments), allDropped);
                } else {
     * @param primaryFormatName the configured primary format name
                        statsTracker::addRefreshMergeTimeMillis
        IOUtils.closeWhileHandlingException(committer);
                                System.nanoTime() - mergeStartNanos
import org.opensearch.index.store.FormatChecksumStrategy;
    }
     *
            if (dropped.contains(seg.generation())) {
     * @param committer           the committer for durable catalog snapshot persistence during flush
    /**
 *
        Committer committer,
                "Primary data format ["
    @Override
     * Creates a {@link CompositeDocumentInput} that fans out field additions to the primary
 */
                        logger.debug("IndexStoreProvider is null for secondary engine [{}]", eng.getDataFormat().name());
        validateFormatsRegistered(dataFormatRegistry, primaryFormatName, secondaryFormatNames);
        DataFormatRegistry dataFormatRegistry,
                    if (mergeResult != null) {
        Store store,
    private final IndexSettings indexSettings;
import org.opensearch.index.engine.dataformat.RefreshResult;
        IOUtils.closeWhileHandlingException(primaryEngine);
            .flatMap(seg -> seg.dfGroupedSearchableFiles().values().stream())
                    }
    private final CompositeShardStatsTracker statsTracker = new CompositeShardStatsTracker();
     * @return the primary engine
    public Exception getTragicException() {
     * @param refreshInput the refresh input containing existing and new segments
        long total = primaryEngine.getHeapBytesUsed();
    public CompositeDocumentInput newDocumentInput() {
    public Writer<CompositeDocumentInput> createWriter(WriterConfig config) {
                            logger.debug(
    public CompositeIndexingExecutionEngine(
                        ),
     */
                        if (logger.isDebugEnabled()) {
     */
            }
    private final CompositeDataFormat compositeDataFormat;
    /**
    }
                    + registry.getRegisteredFormats()
     *
            );
            dataFormatRegistry,
        return unmodifiable;
                        () -> merger.merge(
import org.opensearch.common.util.io.IOUtils;
     * The writer pool is created internally and initialized with a writer supplier
    private boolean shouldMergeOnRefresh(List<Segment> writerFiles) {
        // (e.g., merge pool rejection, resource contention).
                provider.register(shardId, statsTracker);
     * Closes all per-format engines and the committer. Exceptions from secondary engines
    private final Committer committer;
        this.committer = committer;
        return new CompositeDocumentInput(primaryEngine.getDataFormat(), primaryInput, secondaryInputMap);
        long maxBytes = CompositeDataFormatPlugin.MERGE_ON_REFRESH_MAX_SIZE.get(indexSettings.getSettings()).getBytes();
    public Map<DataFormat, EngineReaderManager<?>> buildReaderManager(ReaderManagerConfig config) throws IOException {
                                refreshInput.nextAvailableGeneration(),
        if (committer == null) {
                            MergeInput.builder().segments(onlyNew).newWriterGeneration(refreshInput.nextAvailableGeneration()).build()
import java.util.HashSet;
            }
            throw new IllegalArgumentException("Primary data format name must not be null or blank");
        }
@ExperimentalApi
            Exception tragic = engine.getTragicException();
                if (firstException == null) {
import org.opensearch.index.mapper.MapperService;
            config.indexStoreProvider(),
        if (provider != null && shardId != null) {
                    // Counts merge-on-refresh attempts; a subset overlay of merge_total (also
     * @throws IOException if closing the primary engine or committer fails
 * The OpenSearch Contributors require contributions made to
     * Refreshes all per-format engines and merges their results into a unified list of
        tryDeletePendingFiles();
}
                providers = tempProviders;
    }
        return new CompositeWriter(this, config);
        long total = primaryEngine.getNativeBytesUsed();
                            pendingDeletes.computeIfAbsent(pendingDeletionPerFormat.getKey(), k -> new ArrayList<>())
        for (IndexingExecutionEngine<?, ?> engine : secondaryEngines) {
        MapperService mapperService,
     * @param checksumStrategies  per-format checksum strategies from the directory, keyed by format name.
     * commit coordination. Secondary engines receive writes alongside the primary but
                            .entrySet()) {
            committer,
import java.util.Map;
        return new ReaderManagerConfig(
            config.dataformatAwareStoreHandles(),
     * are not used as the merge authority.
    }
                try {
                                .collect(Collectors.toMap(e -> e.getKey().name(), Map.Entry::getValue))
        RefreshInput perFormatInput = new RefreshInput(
                    final long mergeStartNanos = System.nanoTime();
                    files.addAll(entry.getValue().files());
        }
                            refreshInput.nextAvailableGeneration(),
    }
     * Constructs a CompositeIndexingExecutionEngine by reading index settings to
        return secondaryEngines;
            validateFormatIsRegistered(registry, secondaryName);
        // merge will consolidate later). This ensures refresh never fails due to merge errors
                }
                return provider != null ? provider.getStore(dataFormat) : null;
                    provider.unregister(shardId);
                    logger.debug("IndexStoreProvider is null for primary engine [{}]", primaryEngine.getDataFormat().name());
import java.util.concurrent.ConcurrentHashMap;
     */
        secondaryEngines.forEach(IOUtils::closeWhileHandlingException);
     * Returns the secondary delegate engines.
    @Override
     * @param secondaryFormatNames the configured secondary format names
        return null;
                        List<Segment> result = new ArrayList<>(refreshInput.existingSegments());
     *
                        assert result.size() == refreshInput.existingSegments().size() + 1
            throw new IllegalStateException("Committer must not be null");
     * entries by writer generation.
            config.registry(),
     */
import java.util.IdentityHashMap;
 * all per-format supported field type capabilities.
        IndexSettings indexSettings,
    /** {@inheritDoc} Delegates to the primary engine's merger. */
        return compositeDataFormat;
                        }
     * Returns a composite {@link IndexStoreProvider} that delegates to each per-format
        validateFormatIsRegistered(registry, primaryFormatName);
        }
     * @throws IllegalArgumentException if any configured format is not registered
import java.util.ArrayList;
            RefreshInput.NO_GENERATION,
import org.opensearch.plugin.stats.StatsRecorder;
            logger.error("Failed to delete files in primary engine [{}]: {}", primaryEngine.getDataFormat().name(), e.getMessage());
            {
        }
        if (refreshInput.hasNextGeneration() && shouldMergeOnRefresh(refreshInput.writerFiles())) {
     */
            Set<Long> existingGens = refreshInput.existingSegments().stream().map(Segment::generation).collect(Collectors.toSet());
        Map<DataFormat, DocumentInput<?>> secondaryInputMap = new IdentityHashMap<>();
                for (IndexingExecutionEngine<?, ?> eng : secondaryEngines) {
    public long maxIndexableDocs() {
            }
        if (primaryTragic != null) return primaryTragic;
    @Override
        try {
     * The primary engine is the authoritative format used for merge operations and
     * determine the primary and secondary data formats, validating that all configured
            private final Map<DataFormat, IndexStoreProvider> providers;
        CompositeStatsProvider provider = CompositeStatsProvider.getInstance();
            firstException = e;
        RefreshResult primary = primaryEngine.refresh(perFormatInput);
        throw new UnsupportedOperationException();
    }
    /**
            builder.addSearchableFiles(ownFormat, ownFiles);
        }
            .sum();
    /**
                            : "merge on refresh must produce exactly 1 new segment, got "
            }
    @Override
            config.registry().getReaderManager(readerManagerConfig(config, primaryEngine.getDataFormat()))
                Map<String, Collection<String>> failed = engine.deleteFiles(filesToDelete);
                );
        String primaryFormatName = CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(settings);
            } catch (IOException e) {
                            );
            refreshInput.existingSegments(),
            secondaries.add(dataFormatRegistry.getIndexingEngine(engineSettings, secondaryFormat));
    @Override
     * formats are registered, and creating per-format engines via the discovered
