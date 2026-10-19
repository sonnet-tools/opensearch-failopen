            }  
import java.util.Set;  
    }
        return this;
     * @throws UnsupportedOperationException always  
        }  
     * Best-effort removal of stale NativeFSLock entries from Lucene's static LOCK_HELD set.
                            if (writerGenerations.remove(writerGen)) {  
import org.apache.lucene.index.LeafReaderContext;
                        droppedGenerations.add(segment.generation());
     * A record combining the shard's {@link Store} and the shared {@link IndexWriter},
            }
            }  
import java.util.HashSet;
            List<Segment> resultSegments = new ArrayList<>(segmentsByGeneration.size());  
        this.metadataDocValuesEnabled = indexSettings.getIndexMetadata().isAppendOnlyIndex() == false;  
 *
        // from a prior engine lifecycle. Any data here is either already hardlinked into
        }
     */  
            for (Map.Entry<Long, Map<String, WriterFileSet>> entry : segmentsByGeneration.entrySet()) {
                sourceDirectories.add(new HardlinkCopyDirectoryWrapper(new MMapDirectory(dirPath)));
        Set<LuceneWriter> registry,
                        writer.cleanupTempDirectory();
     * (notably test-only fault-injecting variants) override this to return a custom
    }
 * The shared writer uses {@link NoMergePolicy} to preserve the 1:1 segment-to-Parquet-file
                }
        long refreshStart = System.nanoTime();
        return new LuceneFormatStore(store, sharedWriter, readers);
    private final Map<Long, LuceneReader> readers;
    public long getNextWriterGeneration() {  
     * Removes stale NativeFSLock entries from Lucene's static LOCK_HELD set.  
 * snapshot records the final directory (the shared writer's directory) so that readers
     * assigned by Lucene after the merge.  
    public long getNativeBytesUsed() {
        this.baseDirectory = store.shardPath().resolve(LuceneDataFormat.LUCENE_FORMAT_NAME);
     */
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.SuppressForbidden;
                    }, stats::addRefreshAddIndexesTimeMillis);  
     *  
                        removed++;
        this.store = store;
        long writerGeneration,  
        // it at the flush end. In all other cases, propagate same sort configuration as it is.  
        }  
    private final Analyzer analyzer;  
 * can find the segments.
                    continue;
                    }  
            LuceneWriter writer = buildLuceneWriter(
                e
 * {@link IndexWriter} in an isolated temp directory. Documents are indexed into this  
    ) throws IOException {  
        LuceneCommitter luceneCommitter,  
    public long getHeapBytesUsed() {  
     * Returns the underlying shared IndexWriter from the committer.  
            }  
    /**  
    private static final Logger logger = LogManager.getLogger(LuceneIndexingExecutionEngine.class);  
                            sourceDirectories.size()
    @Override
        try {
import org.apache.lucene.store.MMapDirectory;  
import org.opensearch.index.engine.dataformat.Merger;  
import java.lang.reflect.Field;
            stats.addRefreshTimeMillis(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - refreshStart));
            // Collect all source directories and their paths for a single batched addIndexes call
     * Best-effort deletion of a directory tree. Logs a warning on failure rather than
        throw new UnsupportedOperationException("getNextWriterGeneration managed by DataFormatAwareEngine");
            return;
                                continue;
     * @param luceneCommitter the committer that owns the shared IndexWriter
                            }
                    if (lockPath.startsWith(realBase)) {  
import java.io.IOException;
                "Cannot access NativeFSLockFactory.LOCK_HELD via reflection — "  
    }  
    private final ConcurrentHashMap<Long, LuceneWriter> pendingCleanup = new ConcurrentHashMap<>();
        if (this.userProvidedSort != null
            // /_plugins/lucene/{index}/_stats and /_plugins/lucene/_nodes/{nodeId}/_stats
                provider.register(store.shardId(), stats);
    /** Lucene indexing uses only JVM heap for IndexWriter RAM buffers, no native memory. */
        try {
            // Preserve non-Lucene file sets while replacing one Lucene entry per generation.
                            // Replace this generation's entry; other formats' entries are untouched.
                    logger.warn("Lucene writer directory does not exist: {}", dirPath);
            int removed = 0;
        return Map.of();  
                        it.remove();
        }  
     */
            // into the shared writer's directory, so the originals are no longer needed.
    }  
                            }
import org.opensearch.index.engine.dataformat.Writer;  
        this.luceneMerger = new LuceneMerger(sharedWriter, dataFormat, store.shardPath().resolveIndex(), stats);
package org.opensearch.be.lucene.index;
            Map<Long, Map<String, WriterFileSet>> segmentsByGeneration = new LinkedHashMap<>();
            assert writerGenerations.isEmpty() : "Could not get segments from all writers";
                dataFormat,
        return dataFormat;  
        // No-op: Lucene's internal IndexFileDeleter handles segment file cleanup when  
        return IndexWriter.MAX_DOCS;
            }
     * @param refreshInput contains existing catalog segments and newly flushed writer segments
    }
                throw new RuntimeException("Failed to create lucene base directory: " + baseDirectory, e);
 */
     */  
        IndexSettings indexSettings,
            // Clean up per-writer temp directories — addIndexes has hardlinked all files  
            Set<Long> liveGenerations = new HashSet<>();
    public RefreshResult refresh(RefreshInput refreshInput) throws IOException {  
            Set<Long> writerGenerations = new HashSet<>();  
            lockHeld = (Set<String>) field.get(null);  
                    provider.unregister(store.shardId());
import org.opensearch.be.lucene.stats.LuceneStatsProvider;
 * ({@link LuceneWriter#WRITER_GENERATION_ATTRIBUTE}). After addIndexes, the catalog  
     * @param mapperService   the shard's mapper service  
    private final LuceneShardStatsTracker stats = new LuceneShardStatsTracker();
    @Override  
     * lucene base directory so the new engine can reuse those generations.  
                try {
import org.opensearch.index.engine.exec.Segment;
        this.sharedWriter = luceneCommitter.getIndexWriter();
     * @param indexSettings   the shard's index settings, read to decide metadata doc-value mirroring
            && sortConfig.getSort().length == 1
        assert sharedWriter.isOpen() : "Cannot create writer — shared IndexWriter is closed";
    @Override  
import org.apache.lucene.analysis.Analyzer;  
                                continue;  
                            if (deletesApplied == false && writerGenerations.contains(writerGen) == false) {  
                baseDirectory,  
     * Surfaces the shared {@link org.apache.lucene.index.IndexWriter}'s tragic exception  
import org.opensearch.index.store.Store;  
                }  
                }
    public LuceneDocumentInput newDocumentInput() {
                            "Incorporated {} Lucene segments into shared writer in a single addIndexes call",  
                        if (ctx.reader() instanceof SegmentReader segReader) {
 */  
     * {@code Set<String>}) — tied to Lucene 10.x. If Lucene changes this field,
        LuceneShardStatsTracker stats
import org.opensearch.index.engine.dataformat.RefreshInput;
 * @opensearch.experimental
    private final Set<LuceneWriter> activeWriters = ConcurrentHashMap.newKeySet();
        Sort sortConfig = sharedWriter.getConfig().getIndexSort();
    }  
import java.nio.file.Files;  
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
    public LuceneIndexingExecutionEngine(
 *
    }
import org.opensearch.common.util.io.IOUtils;
    public void close() throws IOException {
import org.apache.lucene.index.IndexWriter;  
            Path realBase = baseDirectory.toRealPath();
    }
import org.apache.lucene.index.SegmentCommitInfo;
            );  
                    LuceneWriter writer = pendingCleanup.remove(wfs.writerGeneration());
        if (luceneCommitter == null) {
                    StatsRecorder.recordTimeMillis(() -> {  
                mappingVersion,
     */
                getChildWriterSortConfiguration(),  
/**
     */  
                                stats.incRefreshSegmentsIncorporatedTotal();
        Set<String> lockHeld;
     * @throws RuntimeException wrapping an {@link IOException} if writer creation fails
                segmentsByGeneration.put(existing.generation(), new HashMap<>(existing.dfGroupedSearchableFiles()));
import org.opensearch.be.lucene.merge.LuceneMerger;
import java.util.List;
import org.opensearch.be.lucene.LuceneDataFormat;
import java.nio.file.Path;
 * compatible open source license.
    @Override
            throw new RuntimeException("Failed to create LuceneWriter for generation " + config.writerGeneration(), e);
            synchronized (lockHeld) {  
        } finally {  
                                .writerGeneration(writerGen)
    private static void tryDeleteDirectory(Path dir) {
     * @return a new writer  
                    }
    public long maxIndexableDocs() {
                            dir.close();
    private final Path baseDirectory;
     * Creates a Lucene indexing engine.
     */
            );  
                Path dirPath = Path.of(wfs.directory());
        // LOCK_HELD set from a prior engine that failed to close its writers properly.
    }  
                    logger.warn("Failed to unregister lucene stats tracker during constructor rollback", rollbackErr);
            } catch (IOException e) {  
     * Creates a new {@link LuceneWriter} for the given generation in an isolated temp directory
    private final Store store;
import java.util.Collection;  
    /**  
    /**
@ExperimentalApi  
     * @param config the writer configuration
        for (LuceneWriter activeWriter : activeWriters) {
        // IndexCommit.delete() is called inside LuceneCommitDeletionPolicy.onCommit(),
            }
                }
        LuceneDataFormat dataFormat,
        } catch (Exception e) {
 * Write path: Each call to {@link #createWriter(WriterConfig)} creates a {@link LuceneWriter} with its own
            if (Files.isDirectory(baseDirectory)) {  
        LuceneDataFormat dataFormat,
    private final Codec codec;
        if (refreshInput == null || sharedWriter == null) {
     * @param writer the shared index writer
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);  
        try {  
    @Override  
import java.util.concurrent.TimeUnit;
import org.opensearch.index.engine.dataformat.DataFormat;  
    }
     * @return a new document input
                            logger.warn("Failed to close source directory after addIndexes", e);
        }
        return 0;
        try {  
        if (provider != null) {
     * {@code addIndexes}, then opens an NRT reader to discover the final file names
        }
/*  
import org.opensearch.index.mapper.MapperService;
            if (sourceDirectories.isEmpty() == false || (deletesApplied && refreshInput.existingSegments().isEmpty() == false)) {
import org.apache.lucene.store.Directory;
import java.util.LinkedHashMap;  
                                wfsBuilder.addFile(file);
                            }
            if (registered && provider != null) {  
        MapperService mapperService,
                            SegmentCommitInfo segInfo = segReader.getSegmentInfo();  
     *  
    @Override
                }
     * used by the search back-end to open NRT readers.
        return new LuceneDocumentInput(fieldFactoryRegistry, metadataDocValuesEnabled);  
                    for (LeafReaderContext ctx : reader.leaves()) {
     */
 *
            // add .liv files. writeAllDeletes=true materializes liveDocs before catalog publication.
     * so DFAE can fail the engine. Wraps non-Exception throwables (e.g., Errors from
public class LuceneIndexingExecutionEngine implements IndexingExecutionEngine<LuceneDataFormat, LuceneDocumentInput>, IndexStoreProvider {
import org.opensearch.index.engine.dataformat.WriterConfig;
import org.apache.lucene.index.SegmentReader;
     * @param store           the shard's store
     * Not supported — writer generation is managed by the {@code DataFormatAwareEngine}.
    /** No-op — the {@link LuceneCommitter} owns the shared IndexWriter lifecycle. */
    }
                            liveGenerations.add(writerGen);  
     * background merges) in {@link RuntimeException} since the contract returns Exception.
            IOUtils.rm(dir);  
     * Returns a {@link LuceneFormatStore} wrapping the shard's store and the shared IndexWriter.  
        return tragic instanceof Exception ? (Exception) tragic : new RuntimeException(tragic);  
     *
     * @param dataFormat      the Lucene data format descriptor
                stats
     * under the shard's Lucene base directory.  
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;  
                clearStaleLocks(baseDirectory);
 * and incorporates them into the shared {@link LuceneCommitter} writer during refresh.  
     * Creates a new empty {@link LuceneDocumentInput} using the default field factory registry.  
    private Sort getChildWriterSortConfiguration() {
        Path baseDirectory,  
                    + "stale lock cleanup disabled. Check Lucene version compatibility.",
                        }  
    /**  
            try {
        return new LuceneWriter(writerGeneration, mappingVersion, dataFormat, baseDirectory, analyzer, codec, indexSort, registry, stats);
                try {
import org.apache.lucene.codecs.Codec;
 * per-writer segment. On flush, the writer force-merges to exactly 1 segment.
            && sortConfig != null  
    }
        }
import org.apache.logging.log4j.Logger;
    private final MergeIndexWriter sharedWriter;
     */  
                config.writerGeneration(),  
import org.apache.lucene.index.NoMergePolicy;  
            // REST endpoints can read live counters. Unregistered in close().
        try {  
            }
import java.util.ArrayList;
     *
                if (wfs != null) {
import org.opensearch.common.annotation.ExperimentalApi;  
                        }
    protected LuceneWriter buildLuceneWriter(
import java.util.HashMap;
        this.fieldFactoryRegistry = new LuceneFieldFactoryRegistry();
    @Override
                    for (Directory dir : sourceDirectories) {  
                activeWriters,
     * efficiency. After incorporation, the writer generation attribute on each segment
    }  
                if (Files.isDirectory(dirPath) == false) {  
            }  
     * propagating — stale temp files will be cleaned on the next engine restart.
                    Path lockPath = Path.of(it.next());
                for (var it = lockHeld.iterator(); it.hasNext();) {
            && DocumentInput.ROW_ID_FIELD.equals(sortConfig.getSort()[0].getField())) {
            return new RefreshResult(List.of());
                        } catch (IOException e) {  
        this.codec = sharedWriter.getConfig().getCodec();
    @Override  
import org.apache.lucene.store.NativeFSLockFactory;
        pendingCleanup.clear();  
     * A prior engine that failed to close its writers leaves paths in this JVM-level set.  
        Codec codec,
    /** Whether {@code _version} / {@code _seq_no} / {@code _primary_term} are mirrored into doc values. */  
            Set<Long> droppedGenerations = new HashSet<>();  
            sortConfig = null;  
                            WriterFileSet.Builder wfsBuilder = WriterFileSet.builder()
     * @param store  the shard store
                    }
                                .directory(sharedDir)  
    /**
            stats.incRefreshTotal();
        } catch (Throwable t) {
    @Override
    public static record LuceneFormatStore(Store store, IndexWriter writer, Map<Long, LuceneReader> readers) implements FormatStore {
                                .addNumRows(segReader.maxDoc());
            field.setAccessible(true);
    @Override  
    public LuceneDataFormat getDataFormat() {
            if (provider != null) {
        } catch (IOException e) {  
    public FormatStore getStore(DataFormat dataFormat) {  
    private final LuceneMerger luceneMerger;
    /** {@inheritDoc} Returns the {@link LuceneDataFormat} descriptor. */  
    public Writer<LuceneDocumentInput> createWriter(WriterConfig config) {
        }
     * Uses reflection on {@code NativeFSLockFactory.LOCK_HELD} (a private static
                            segmentsByGeneration.computeIfAbsent(writerGen, gen -> new HashMap<>()).put(dataFormat.name(), luceneFiles);
     * <p>
     * Incorporates flushed per-writer segments into the shared IndexWriter via
                } catch (Throwable rollbackErr) {  
    public Merger getMerger() {
        boolean registered = false;  
                try (DirectoryReader reader = DirectoryReader.open(sharedWriter, true, deletesApplied)) {  
    /**
import org.apache.lucene.search.Sort;
    @Override  
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
            }
        // flushQueue, or any other DFAE path, closing it here releases its NativeFSLock  
        Analyzer analyzer,
        long mappingVersion,
     * is used to correlate back to the originating writer.
                        try {
    @Override
 *  
        }
            }  
        // LuceneCommitter owns the shared IndexWriter lifecycle
                    }
        // When Lucene is secondary, then clear child writer's sort configuration and restamp
import org.opensearch.plugin.stats.StatsRecorder;
        Store store  
     * Existing segments from the catalog snapshot are preserved. New segments from
                logger.warn(
}  
            if (sourceDirectories.isEmpty() == false) {
                analyzer,
    private final boolean metadataDocValuesEnabled;
     * @return the format store  
            for (Segment segment : refreshInput.writerFiles()) {
            logger.warn("Failed to resolve base directory [{}] for stale lock cleanup: {}", baseDirectory, e.getMessage());
        long total = 0;
                Path sharedDir = store.shardPath().resolveIndex();
            pendingCleanup.put(config.writerGeneration(), writer);
                    continue;
    }
     * @throws IOException if addIndexes or reader opening fails  
    /**  
    }
            for (Segment segment : refreshInput.writerFiles()) {
    /**
                } finally {
                        sharedWriter.addIndexes(sourceDirectories.toArray(new Directory[0]));
            throw t;
     */
        // for all failure modes — regardless of whether a writer leaked from the pool,
    private static void clearStaleLocks(Path baseDirectory) {
        }
     * @return the index writer
        return sharedWriter;
        // Before deleting, release any stale NativeFSLock entries left in Lucene's static
        // Unregister this shard's tracker from the stats provider before tearing down.
        }  
        } catch (IOException e) {
                    "Cleared {} stale NativeFSLock entries under [{}]. " + "A prior engine failed to close its LuceneWriters properly.",
        Sort indexSort,  
    @SuppressWarnings("unchecked")
        if (tragic == null) return null;
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);  
                Files.createDirectories(baseDirectory);
                );
                            long writerGen = Long.parseLong(genAttr);
     * {@link LuceneWriter} subclass — e.g., one that wraps the {@code Directory} with a
     */  
    }
                codec,
            throw new IllegalArgumentException("LuceneCommitter must not be null");  
        }  
            // Register this shard's tracker with the format-wide stats provider so the  
                writerGenerations.add(wfs.writerGeneration());  
            IOUtils.closeWhileHandlingException(writer);  
import org.apache.lucene.index.DirectoryReader;
                            if (genAttr == null) {
            logger.warn(
    public Exception getTragicException() {
            provider = (LuceneStatsProvider) DataFormatStatsProviderRegistry.INSTANCE.get(LuceneStatsProvider.FORMAT_NAME);  
     * writer temp directories are batched into a single {@code addIndexes} call for  
                            }  
    /**
     * reflection fails with a WARN log so the incompatibility is caught during testing.  
            return writer;
        // triggered by IndexWriter.deleteUnusedFiles() from LuceneCommitter.deleteCommit().
    /** {@inheritDoc} Returns this engine as the {@link IndexStoreProvider}. */
                            String genAttr = segInfo.info.getAttribute(LuceneWriter.WRITER_GENERATION_ATTRIBUTE);
            }
                if (wfs == null) {
            Field field = NativeFSLockFactory.class.getDeclaredField("LOCK_HELD");
    @Override
            List<Directory> sourceDirectories = new ArrayList<>();
    /**
import org.opensearch.index.IndexSettings;
     * Factory hook for tests: builds the per-generation {@link LuceneWriter}. Subclasses  
        // from Lucene's static LOCK_HELD set.
    public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException {
 * The OpenSearch Contributors require contributions made to  
        this.analyzer = sharedWriter.getAnalyzer();  
                    }  
 * SPDX-License-Identifier: Apache-2.0
                        );
            logger.warn("Failed to delete lucene temp directory [{}]: {}", dir, e.getMessage());
    /**
    private final Sort userProvidedSort;  
            total += activeWriter.getHeapBytesUsed();  
                    if (liveGenerations.contains(segment.generation()) == false) {  
     * On engine restart the generation counter can produce the same value, causing
    @SuppressForbidden(reason = "Clear stale lock entries leaked by a prior engine lifecycle")  
import java.util.concurrent.ConcurrentHashMap;
        this.userProvidedSort = luceneCommitter.getUserProvidedSort();  
            }
        // index/ (via addIndexes) or will be replayed from the translog on recovery.  
        for (LuceneWriter writer : activeWriters) {
            // Rebuild every live file set because addIndexes can rename files and drained deletes  
            if (deletesApplied) {
import org.opensearch.index.engine.exec.WriterFileSet;  
     *
        if (sharedWriter == null) return null;  
    }  
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
    }  
     * fault injector to exercise {@code IndexWriter.addDocument} failure paths.  
        this.readers = luceneCommitter.readers();
import org.apache.lucene.index.MergeIndexWriter;
    private final LuceneFieldFactoryRegistry fieldFactoryRegistry;  
        try {  
        activeWriters.clear();
            final boolean deletesApplied = refreshInput.deletesApplied();  
     *
        LuceneStatsProvider provider = (LuceneStatsProvider) DataFormatStatsProviderRegistry.INSTANCE.get(LuceneStatsProvider.FORMAT_NAME);  
        LuceneStatsProvider provider = null;
 * shared {@link LuceneCommitter} writer via {@code IndexWriter.addIndexes(Directory...)}.
     * @param dataFormat the data format (ignored — always returns the Lucene store)
    }  
                    realBase
    /**
 * Refresh path: During refresh, flushed segments from temp directories are incorporated into the  
        // Close any writers still tracked by this engine. This is the single safety net
            long mappingVersion = mapperService.getIndexSettings().getIndexMetadata().getMappingVersion();
    ) {
     *
    public MergeIndexWriter getWriter() {
        return sortConfig;
            if (removed > 0) {  
 *
 * Segment correlation: Each per-writer segment stores the writer generation as a segment info attribute
     * @return the combined list of existing and newly incorporated segments
            }
    }  
 * Lucene-specific {@link IndexingExecutionEngine} that manages per-writer Lucene segments
                }  
                registered = true;  
    private final MapperService mapperService;
    @Override
 * mapping. After addIndexes, the temp directories are cleaned up.  
import org.opensearch.index.engine.dataformat.DocumentInput;
    public IndexStoreProvider getProvider() {
        return this.luceneMerger;
                }  
            return new RefreshResult(List.copyOf(resultSegments), droppedGenerations);
        this.dataFormat = dataFormat;
    private final LuceneDataFormat dataFormat;  
        Throwable tragic = sharedWriter.getTragicException();
import org.apache.lucene.misc.store.HardlinkCopyDirectoryWrapper;  
                    if (writer != null) {  
        this.mapperService = mapperService;  
                for (Segment segment : refreshInput.existingSegments()) {
                    removed,  
import org.opensearch.index.engine.dataformat.RefreshResult;
     * LockObtainFailedException. This method removes any entries under this shard's
            // Single batched addIndexes call for all source directories  
     */  
    }
                            for (String file : segInfo.files()) {
            for (Segment existing : refreshInput.existingSegments()) {  
                resultSegments.add(new Segment(entry.getKey(), entry.getValue()));
                tryDeleteDirectory(baseDirectory);
                }  
    /**
     *  
import org.opensearch.be.lucene.LuceneReader;
     */
import org.opensearch.be.lucene.LuceneFieldFactoryRegistry;  
                    // Close all source directories
            provider.unregister(store.shardId());
                            WriterFileSet luceneFiles = wfsBuilder.build();  
                        logger.debug(
        // Create the lucene subdirectory if it doesn't exist, or clear stale contents
        return total;
        } catch (IOException e) {
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
