 * Segment correlation: Each per-writer segment stores the writer generation as a segment info attribute
import org.opensearch.common.util.io.IOUtils;
        } catch (Exception e) {
     * {@code Set<String>}) — tied to Lucene 10.x. If Lucene changes this field,
        }
                            if (genAttr == null) {
            Path realBase = baseDirectory.toRealPath();
    /**
        Store store
        Sort indexSort,
                }
        this.dataFormat = dataFormat;
                Files.createDirectories(baseDirectory);
 * this file be licensed under the Apache-2.0 license or a
     * Returns a {@link LuceneFormatStore} wrapping the shard's store and the shared IndexWriter.
     *
import java.util.Map;
            // Rebuild every live file set because addIndexes can rename files and drained deletes
        for (LuceneWriter activeWriter : activeWriters) {
        return new LuceneDocumentInput(fieldFactoryRegistry, metadataDocValuesEnabled);
    public long getNativeBytesUsed() {
        }
                resultSegments.add(new Segment(entry.getKey(), entry.getValue()));
                    logger.warn("Lucene writer directory does not exist: {}", dirPath);
            return writer;
import org.apache.lucene.index.MergeIndexWriter;
    public long getNextWriterGeneration() {
                    }, stats::addRefreshAddIndexesTimeMillis);
     * @throws UnsupportedOperationException always
     */
import org.apache.lucene.index.IndexWriter;
        LuceneShardStatsTracker stats
                }
        Analyzer analyzer,
import org.opensearch.be.lucene.LuceneReader;
                } finally {
     */
import java.util.concurrent.TimeUnit;
     * used by the search back-end to open NRT readers.
            logger.warn("Failed to delete lucene temp directory [{}]: {}", dir, e.getMessage());
            }
        return new LuceneWriter(writerGeneration, mappingVersion, dataFormat, baseDirectory, analyzer, codec, indexSort, registry, stats);
    public static record LuceneFormatStore(Store store, IndexWriter writer, Map<Long, LuceneReader> readers) implements FormatStore {
                    continue;
            }
        this.readers = luceneCommitter.readers();
    public IndexStoreProvider getProvider() {
    }
            && sortConfig != null
        LuceneStatsProvider provider = null;
            if (removed > 0) {
            Field field = NativeFSLockFactory.class.getDeclaredField("LOCK_HELD");
import org.apache.lucene.store.NativeFSLockFactory;
            List<Segment> resultSegments = new ArrayList<>(segmentsByGeneration.size());
        return dataFormat;
 * compatible open source license.
    }
            if (registered && provider != null) {
     * Best-effort removal of stale NativeFSLock entries from Lucene's static LOCK_HELD set.
                tryDeleteDirectory(baseDirectory);
 * {@link IndexWriter} in an isolated temp directory. Documents are indexed into this
                            logger.warn("Failed to close source directory after addIndexes", e);
                analyzer,
     * @throws RuntimeException wrapping an {@link IOException} if writer creation fails
        Set<String> lockHeld;
    /** No-op — the {@link LuceneCommitter} owns the shared IndexWriter lifecycle. */
                            }
                            String genAttr = segInfo.info.getAttribute(LuceneWriter.WRITER_GENERATION_ATTRIBUTE);
     *
        if (tragic == null) return null;
    private final LuceneFieldFactoryRegistry fieldFactoryRegistry;
        } catch (IOException e) {
    @Override
            Set<Long> liveGenerations = new HashSet<>();
                    // Close all source directories
        boolean registered = false;
    private static void tryDeleteDirectory(Path dir) {
import org.opensearch.be.lucene.merge.LuceneMerger;
    /**
                "Cannot access NativeFSLockFactory.LOCK_HELD via reflection — "
        try {
        return 0;
import org.opensearch.index.engine.dataformat.Merger;
     */
     *
                            }
                    }
 * ({@link LuceneWriter#WRITER_GENERATION_ATTRIBUTE}). After addIndexes, the catalog
            return new RefreshResult(List.of());
 *
        return this;
        return sharedWriter;
    /**
 * Write path: Each call to {@link #createWriter(WriterConfig)} creates a {@link LuceneWriter} with its own
            // Collect all source directories and their paths for a single batched addIndexes call
            }
import org.apache.lucene.search.Sort;
     * lucene base directory so the new engine can reuse those generations.
        if (this.userProvidedSort != null
    /**
import org.opensearch.index.store.Store;
                        removed++;
    private final MapperService mapperService;
        } catch (IOException e) {
                }
    }
        return tragic instanceof Exception ? (Exception) tragic : new RuntimeException(tragic);
     */
                            "Incorporated {} Lucene segments into shared writer in a single addIndexes call",
    }
            for (Segment existing : refreshInput.existingSegments()) {
        if (provider != null) {
            synchronized (lockHeld) {
            }
    private final MergeIndexWriter sharedWriter;
        // from Lucene's static LOCK_HELD set.
        // Before deleting, release any stale NativeFSLock entries left in Lucene's static
            }
        // from a prior engine lifecycle. Any data here is either already hardlinked into
                Path dirPath = Path.of(wfs.directory());
                    removed,
 * @opensearch.experimental
     * Creates a new {@link LuceneWriter} for the given generation in an isolated temp directory
import org.opensearch.index.IndexSettings;
        this.metadataDocValuesEnabled = indexSettings.getIndexMetadata().isAppendOnlyIndex() == false;
                stats
 */
     * <p>
    /** Whether {@code _version} / {@code _seq_no} / {@code _primary_term} are mirrored into doc values. */
        LuceneDataFormat dataFormat,
        try {
import java.nio.file.Files;
                    for (Directory dir : sourceDirectories) {
        this.userProvidedSort = luceneCommitter.getUserProvidedSort();
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
        try {
                if (wfs == null) {
    private final Analyzer analyzer;
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
    /**
        }
import java.util.concurrent.ConcurrentHashMap;
 * The OpenSearch Contributors require contributions made to
                try (DirectoryReader reader = DirectoryReader.open(sharedWriter, true, deletesApplied)) {
    private final Sort userProvidedSort;
package org.opensearch.be.lucene.index;
import org.apache.lucene.analysis.Analyzer;
        return total;
    public Exception getTragicException() {
                                .writerGeneration(writerGen)
            List<Directory> sourceDirectories = new ArrayList<>();
        Sort sortConfig = sharedWriter.getConfig().getIndexSort();
    private Sort getChildWriterSortConfiguration() {
import java.util.ArrayList;
    @Override
 *
    }
     * @param luceneCommitter the committer that owns the shared IndexWriter
     * propagating — stale temp files will be cleaned on the next engine restart.
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);
        }
    }
import org.apache.lucene.store.MMapDirectory;
    }
                getChildWriterSortConfiguration(),
     * so DFAE can fail the engine. Wraps non-Exception throwables (e.g., Errors from
import org.opensearch.be.lucene.stats.LuceneStatsProvider;
     * {@link LuceneWriter} subclass — e.g., one that wraps the {@code Directory} with a
                segmentsByGeneration.put(existing.generation(), new HashMap<>(existing.dfGroupedSearchableFiles()));
     * assigned by Lucene after the merge.
     *
        for (LuceneWriter writer : activeWriters) {
 * and incorporates them into the shared {@link LuceneCommitter} writer during refresh.
        this.sharedWriter = luceneCommitter.getIndexWriter();
            assert writerGenerations.isEmpty() : "Could not get segments from all writers";
     * @param dataFormat      the Lucene data format descriptor
    public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException {
     */
     * @param store           the shard's store
        // Close any writers still tracked by this engine. This is the single safety net
     * Existing segments from the catalog snapshot are preserved. New segments from
import org.opensearch.index.engine.dataformat.DocumentInput;
            total += activeWriter.getHeapBytesUsed();
        try {
    /**
import org.apache.lucene.codecs.Codec;
                }
            throw t;
            for (Map.Entry<Long, Map<String, WriterFileSet>> entry : segmentsByGeneration.entrySet()) {
     * On engine restart the generation counter can produce the same value, causing
            }
 * snapshot records the final directory (the shared writer's directory) so that readers
            }
    private static final Logger logger = LogManager.getLogger(LuceneIndexingExecutionEngine.class);
    /**
                    Path lockPath = Path.of(it.next());
    public RefreshResult refresh(RefreshInput refreshInput) throws IOException {
import org.apache.lucene.misc.store.HardlinkCopyDirectoryWrapper;
            }
                        } catch (IOException e) {
        if (sharedWriter == null) return null;
            provider.unregister(store.shardId());
                        writer.cleanupTempDirectory();
     * @param writer the shared index writer
    }
        }
                }
import org.opensearch.index.engine.dataformat.DataFormat;
        IndexSettings indexSettings,
 * Lucene-specific {@link IndexingExecutionEngine} that manages per-writer Lucene segments
                        }
            Set<Long> writerGenerations = new HashSet<>();
     * reflection fails with a WARN log so the incompatibility is caught during testing.
                    "Cleared {} stale NativeFSLock entries under [{}]. " + "A prior engine failed to close its LuceneWriters properly.",
     * @param config the writer configuration
                );
        // Unregister this shard's tracker from the stats provider before tearing down.
    ) {
     * @param mapperService   the shard's mapper service
 * The shared writer uses {@link NoMergePolicy} to preserve the 1:1 segment-to-Parquet-file
    }
import org.apache.lucene.index.NoMergePolicy;
        // No-op: Lucene's internal IndexFileDeleter handles segment file cleanup when
    }
                activeWriters,
                dataFormat,
        } finally {
        this.codec = sharedWriter.getConfig().getCodec();
            for (Segment segment : refreshInput.writerFiles()) {
import java.lang.reflect.Field;
                                .addNumRows(segReader.maxDoc());
        this.baseDirectory = store.shardPath().resolve(LuceneDataFormat.LUCENE_FORMAT_NAME);
    @Override
        return IndexWriter.MAX_DOCS;
import java.util.HashMap;
import org.apache.lucene.index.DirectoryReader;
                    if (liveGenerations.contains(segment.generation()) == false) {
    /**
     * Creates a Lucene indexing engine.
                if (Files.isDirectory(dirPath) == false) {
import org.opensearch.index.engine.exec.WriterFileSet;
     * background merges) in {@link RuntimeException} since the contract returns Exception.
import org.opensearch.be.lucene.LuceneFieldFactoryRegistry;
    private final Path baseDirectory;
                throw new RuntimeException("Failed to create lucene base directory: " + baseDirectory, e);
            sortConfig = null;
            IOUtils.closeWhileHandlingException(writer);
    /**
                mappingVersion,
import org.opensearch.index.engine.dataformat.WriterConfig;
        // flushQueue, or any other DFAE path, closing it here releases its NativeFSLock
                provider.register(store.shardId(), stats);
                codec,
 *
    @Override
    public LuceneIndexingExecutionEngine(
     * Not supported — writer generation is managed by the {@code DataFormatAwareEngine}.
import java.util.Set;
            // Clean up per-writer temp directories — addIndexes has hardlinked all files
                        sharedWriter.addIndexes(sourceDirectories.toArray(new Directory[0]));
        // IndexCommit.delete() is called inside LuceneCommitDeletionPolicy.onCommit(),
    @SuppressForbidden(reason = "Clear stale lock entries leaked by a prior engine lifecycle")
                Path sharedDir = store.shardPath().resolveIndex();
            stats.addRefreshTimeMillis(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - refreshStart));
     */
/**
                            }
            Set<Long> droppedGenerations = new HashSet<>();
    public long getHeapBytesUsed() {
import org.opensearch.common.annotation.ExperimentalApi;
                        try {
                            }
    public LuceneDataFormat getDataFormat() {
import org.apache.lucene.index.SegmentCommitInfo;
import java.util.Collection;
            logger.warn(
        long mappingVersion,
    private final Store store;
        Throwable tragic = sharedWriter.getTragicException();
            return new RefreshResult(List.copyOf(resultSegments), droppedGenerations);
    public long maxIndexableDocs() {
        LuceneDataFormat dataFormat,
        long writerGeneration,
                            if (deletesApplied == false && writerGenerations.contains(writerGen) == false) {
        return Map.of();
            // into the shared writer's directory, so the originals are no longer needed.
    public Merger getMerger() {
            // Preserve non-Lucene file sets while replacing one Lucene entry per generation.
     */
    /** {@inheritDoc} Returns the {@link LuceneDataFormat} descriptor. */
    /** {@inheritDoc} Returns this engine as the {@link IndexStoreProvider}. */
                try {
        return sortConfig;
        return new LuceneFormatStore(store, sharedWriter, readers);
        // LuceneCommitter owns the shared IndexWriter lifecycle
import org.opensearch.index.engine.dataformat.RefreshResult;
    private final ConcurrentHashMap<Long, LuceneWriter> pendingCleanup = new ConcurrentHashMap<>();
import org.apache.logging.log4j.LogManager;
    /**
                            liveGenerations.add(writerGen);
            }
                try {
                                stats.incRefreshSegmentsIncorporatedTotal();
        } catch (IOException e) {
public class LuceneIndexingExecutionEngine implements IndexingExecutionEngine<LuceneDataFormat, LuceneDocumentInput>, IndexStoreProvider {
                if (wfs != null) {
 * mapping. After addIndexes, the temp directories are cleaned up.
                        if (ctx.reader() instanceof SegmentReader segReader) {
    private final Codec codec;
 * shared {@link LuceneCommitter} writer via {@code IndexWriter.addIndexes(Directory...)}.
            final boolean deletesApplied = refreshInput.deletesApplied();
                baseDirectory,
     * @param refreshInput contains existing catalog segments and newly flushed writer segments
        if (refreshInput == null || sharedWriter == null) {
import org.apache.lucene.index.SegmentReader;
    public Writer<LuceneDocumentInput> createWriter(WriterConfig config) {
     * under the shard's Lucene base directory.
            try {
import org.apache.logging.log4j.Logger;
    }
 * per-writer segment. On flush, the writer force-merges to exactly 1 segment.
                                wfsBuilder.addFile(file);
}
    /**
 * can find the segments.
            // add .liv files. writeAllDeletes=true materializes liveDocs before catalog publication.
            // /_plugins/lucene/{index}/_stats and /_plugins/lucene/_nodes/{nodeId}/_stats
 *
            }
    }
        LuceneCommitter luceneCommitter,
        // When Lucene is secondary, then clear child writer's sort configuration and restamp
                }
        try {
                clearStaleLocks(baseDirectory);
                registered = true;
            int removed = 0;
        // Create the lucene subdirectory if it doesn't exist, or clear stale contents
     * Uses reflection on {@code NativeFSLockFactory.LOCK_HELD} (a private static
        this.mapperService = mapperService;
            stats.incRefreshTotal();
    }
            } catch (IOException e) {
    @Override
     * A prior engine that failed to close its writers leaves paths in this JVM-level set.
     * {@code addIndexes}, then opens an NRT reader to discover the final file names
            throw new IllegalArgumentException("LuceneCommitter must not be null");
                            // Replace this generation's entry; other formats' entries are untouched.
                            WriterFileSet luceneFiles = wfsBuilder.build();
    }
            // Single batched addIndexes call for all source directories
                    logger.warn("Failed to unregister lucene stats tracker during constructor rollback", rollbackErr);
    @Override
                sourceDirectories.add(new HardlinkCopyDirectoryWrapper(new MMapDirectory(dirPath)));
        // triggered by IndexWriter.deleteUnusedFiles() from LuceneCommitter.deleteCommit().
     */
    private final LuceneShardStatsTracker stats = new LuceneShardStatsTracker();
                    }
                    }
    /**
                    }
import org.opensearch.common.SuppressForbidden;
     *
     * fault injector to exercise {@code IndexWriter.addDocument} failure paths.
        throw new UnsupportedOperationException("getNextWriterGeneration managed by DataFormatAwareEngine");
import org.opensearch.index.mapper.MapperService;
    public FormatStore getStore(DataFormat dataFormat) {
        LuceneStatsProvider provider = (LuceneStatsProvider) DataFormatStatsProviderRegistry.INSTANCE.get(LuceneStatsProvider.FORMAT_NAME);
        Codec codec,
     * @return the combined list of existing and newly incorporated segments
    public void close() throws IOException {
                    }
        }
                                continue;
        }
                    StatsRecorder.recordTimeMillis(() -> {
                        logger.debug(
     */
            }
            pendingCleanup.put(config.writerGeneration(), writer);
    protected LuceneWriter buildLuceneWriter(
    @Override
            if (deletesApplied) {
import org.apache.lucene.index.LeafReaderContext;
            IOUtils.rm(dir);
        MapperService mapperService,
    private final Set<LuceneWriter> activeWriters = ConcurrentHashMap.newKeySet();
        assert sharedWriter.isOpen() : "Cannot create writer — shared IndexWriter is closed";
            lockHeld = (Set<String>) field.get(null);
import org.opensearch.plugin.stats.StatsRecorder;
                logger.warn(
        long refreshStart = System.nanoTime();
     */
    @Override
     * LockObtainFailedException. This method removes any entries under this shard's
 * Refresh path: During refresh, flushed segments from temp directories are incorporated into the
        // for all failure modes — regardless of whether a writer leaked from the pool,
        long total = 0;
    @Override
import org.apache.lucene.store.Directory;
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);
            long mappingVersion = mapperService.getIndexSettings().getIndexMetadata().getMappingVersion();
                }
    @Override
     * @return a new document input
        activeWriters.clear();
                    if (lockPath.startsWith(realBase)) {
    @Override
            );
import java.util.List;
     *
            );
                            for (String file : segInfo.files()) {
     * Returns the underlying shared IndexWriter from the committer.
                for (Segment segment : refreshInput.existingSegments()) {
                        droppedGenerations.add(segment.generation());
        }
     *
        pendingCleanup.clear();
                }
            Map<Long, Map<String, WriterFileSet>> segmentsByGeneration = new LinkedHashMap<>();
    private final LuceneDataFormat dataFormat;
                    LuceneWriter writer = pendingCleanup.remove(wfs.writerGeneration());
                for (var it = lockHeld.iterator(); it.hasNext();) {
                        );
                e
     * Incorporates flushed per-writer segments into the shared IndexWriter via
import java.io.IOException;
        this.luceneMerger = new LuceneMerger(sharedWriter, dataFormat, store.shardPath().resolveIndex(), stats);
    }
            if (provider != null) {
            throw new RuntimeException("Failed to create LuceneWriter for generation " + config.writerGeneration(), e);
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
import org.opensearch.be.lucene.LuceneDataFormat;
     * Factory hook for tests: builds the per-generation {@link LuceneWriter}. Subclasses
            }
                        it.remove();
        this.store = store;
import org.opensearch.index.engine.dataformat.RefreshInput;
    private static void clearStaleLocks(Path baseDirectory) {
     * Removes stale NativeFSLock entries from Lucene's static LOCK_HELD set.
        } catch (Throwable t) {
    public LuceneDocumentInput newDocumentInput() {
     * @throws IOException if addIndexes or reader opening fails
        this.fieldFactoryRegistry = new LuceneFieldFactoryRegistry();
     * (notably test-only fault-injecting variants) override this to return a custom
        return this.luceneMerger;
/*
        // index/ (via addIndexes) or will be replayed from the translog on recovery.
            field.setAccessible(true);
            provider = (LuceneStatsProvider) DataFormatStatsProviderRegistry.INSTANCE.get(LuceneStatsProvider.FORMAT_NAME);
        if (luceneCommitter == null) {
     * efficiency. After incorporation, the writer generation attribute on each segment
    @Override
import java.util.LinkedHashMap;
        Set<LuceneWriter> registry,
                                .directory(sharedDir)
import java.nio.file.Path;
            && sortConfig.getSort().length == 1
        this.analyzer = sharedWriter.getAnalyzer();
     * A record combining the shard's {@link Store} and the shared {@link IndexWriter},
            // REST endpoints can read live counters. Unregistered in close().
                            segmentsByGeneration.computeIfAbsent(writerGen, gen -> new HashMap<>()).put(dataFormat.name(), luceneFiles);
     * Surfaces the shared {@link org.apache.lucene.index.IndexWriter}'s tragic exception
import org.opensearch.index.engine.exec.Segment;
    }
        }
                            long writerGen = Long.parseLong(genAttr);
    }
            if (sourceDirectories.isEmpty() == false || (deletesApplied && refreshInput.existingSegments().isEmpty() == false)) {
                writerGenerations.add(wfs.writerGeneration());
                            WriterFileSet.Builder wfsBuilder = WriterFileSet.builder()
            if (Files.isDirectory(baseDirectory)) {
    }
     * @return the index writer
     * Creates a new empty {@link LuceneDocumentInput} using the default field factory registry.
     * @return the format store
 *
                                continue;
            }
    private final Map<Long, LuceneReader> readers;
                config.writerGeneration(),
@ExperimentalApi
    @Override
import org.opensearch.index.engine.dataformat.Writer;
     * @param indexSettings   the shard's index settings, read to decide metadata doc-value mirroring
                        }
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
        }
                    continue;
import java.util.HashSet;
            LuceneWriter writer = buildLuceneWriter(
            logger.warn("Failed to resolve base directory [{}] for stale lock cleanup: {}", baseDirectory, e.getMessage());
        }
        // it at the flush end. In all other cases, propagate same sort configuration as it is.
     * @return a new writer
    }
    }
    ) throws IOException {
     * writer temp directories are batched into a single {@code addIndexes} call for
                            dir.close();
     */
    }
 */
    /**
        Path baseDirectory,
        // LOCK_HELD set from a prior engine that failed to close its writers properly.
    @Override
            return;
                    if (writer != null) {
    @SuppressWarnings("unchecked")
                } catch (Throwable rollbackErr) {
     * @param store  the shard store
    private final boolean metadataDocValuesEnabled;
                            if (writerGenerations.remove(writerGen)) {
     * is used to correlate back to the originating writer.
        }
            && DocumentInput.ROW_ID_FIELD.equals(sortConfig.getSort()[0].getField())) {
                    + "stale lock cleanup disabled. Check Lucene version compatibility.",
     * Best-effort deletion of a directory tree. Logs a warning on failure rather than
                    realBase
 * SPDX-License-Identifier: Apache-2.0
    public MergeIndexWriter getWriter() {
    private final LuceneMerger luceneMerger;
    /** Lucene indexing uses only JVM heap for IndexWriter RAM buffers, no native memory. */
     */
            for (Segment segment : refreshInput.writerFiles()) {
                            sourceDirectories.size()
                            SegmentCommitInfo segInfo = segReader.getSegmentInfo();
            // Register this shard's tracker with the format-wide stats provider so the
     *
     * @param dataFormat the data format (ignored — always returns the Lucene store)
                    for (LeafReaderContext ctx : reader.leaves()) {
            if (sourceDirectories.isEmpty() == false) {
     */
        try {
                    provider.unregister(store.shardId());
