            }
            return Map.of();
     *
 * @opensearch.experimental
                        tracker.incCommitTotal();
            result.put(entry.getKey(), entry.getValue());
     * sequence numbers) and commits the IndexWriter. When a catalog snapshot is present,
        ensureOpen();
import java.io.IOException;
    }
        for (Map.Entry<IndexCommit, CatalogSnapshot> entry : committed.entrySet()) {
                // segments_N so that getLastCommitGeneration() returns a stable value before
            } finally {
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
        // (KeepOnlyLastCommitDeletionPolicy) discards all other segments_N files, cleaning up
    /** Cached latest committed {@link SegmentInfos}; refreshed inside {@link #commit}, read by {@link #getCommitStats}. */
            iwc.setMergeScheduler(new SerialMergeScheduler());
 */
    public Map<String, String> getLastCommittedData() throws IOException {
            throw t;
                    0L,
        // TODO:: Merge Config needs to be wired in
                LuceneShardStatsTracker tracker = provider.getTracker(store.shardId());
    // --- Internal ---
     * Atomically persists the given commit data (catalog snapshot, translog UUID,
        ensureOpen();
        Iterable<Map.Entry<String, String>> liveCommitData = indexWriter.getLiveCommitData();
 *
            }
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
        IndexWriterConfig iwc = new IndexWriterConfig(engineConfig.getAnalyzer());
    private final Sort userProvidedSort;
        } finally {
            }
        // Refresh-lock hand-off: the MergedSegmentWarmer fires on the merge thread between
                targetCommit = entry.getKey();
    public byte[] serializeToCommitFormat(CatalogSnapshot catalogSnapshot) throws IOException {
     * @return the index writer, or null if closed
import org.apache.lucene.store.ByteBuffersDataOutput;
/**
 * via {@link #commit(org.opensearch.index.engine.exec.commit.Committer.CommitInput)}, which sets the live commit data on the writer and calls
            }
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        ensureOpen();
        // hook acquires is transferred to applyMergeChanges, which releases it after the
            }
    @Override
        IndexCommit targetCommit = null;
        return result;
            iwc.setMergePolicy(NoMergePolicy.INSTANCE);
        iwc.setCodec(engineConfig.getCodec());
}
        ByteBuffersDataOutput out = new ByteBuffersDataOutput();
    @Override
                    tracker.addCommitSyncTimeMillis(syncMillis);
    }
        return userProvidedSort;
            return;
    @Override
                if (tracker != null) {
    /**
        LuceneReader luceneReader = readers.get(catalogSnapshot.getId());
            throw new IllegalStateException("Safe commit [gen=" + safeCommit.getGeneration() + "] not found among Lucene IndexCommits");
            logger.info("No Lucene reader for catalog snapshot version={} — producing empty SegmentInfos", catalogSnapshot.getId());
        if (isSecondary) {
            if (entry.getValue() != null && entry.getValue().getGeneration() == safeCommit.getGeneration()) {
        }
     * format, {@code LuceneReaderManager.afterRefresh} MUST have registered the reader for
                    }
        iwc.setMergeScheduler(new SerialMergeScheduler());
 * <h2>Refresh-lock coordination</h2>
import org.apache.lucene.index.IndexFileNames;
                );
        } catch (Exception e) {
        } catch (Throwable t) {
     * file set.
import org.apache.lucene.util.Version;
 * for a single shard.
     *
                long syncStart = System.nanoTime();
        }
            } else {
                this.store.decRef();
                break;
import org.apache.lucene.index.IndexCommit;
    public void deleteCommit(CatalogSnapshot snapshot) throws IOException {
     */
     * <p>A missing reader indicates a plumbing bug — whenever Lucene is an active indexing
                    0L,
    private final AtomicBoolean isClosed = new AtomicBoolean();
        super(committerConfig);
     */
 * SPDX-License-Identifier: Apache-2.0
            assert catalogSnapshot.getDataFormats().contains(LuceneDataFormat.LUCENE_FORMAT_NAME) == false
                    "Reader for catalog snapshot version=" + catalogSnapshot.getId() + " is not a StandardDirectoryReader: " + reader
     * Closes the IndexWriter and releases the store reference.
                syncMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - syncStart);
import java.util.List;
import java.util.Map;
        long syncMillis = 0;
                        tracker.incCommitFailures();
     * @throws IllegalStateException if this committer is closed
                // the first real flush — preventing the catalog generation fallback from
        // both unsafe commits and orphan non-CatalogSnapshot commits as well, if any.
    public boolean isCommitManagedFile(String fileName) {
        Map<String, String> sisUserData = new HashMap<>(catalogSnapshot.getUserData());
            sis = ((StandardDirectoryReader) unwrapped).getSegmentInfos().clone();
                    if (threw) {
    public synchronized CommitResult commit(CommitInput commitData) throws IOException {
import org.opensearch.index.translog.Translog;
            long version = LuceneVersionConverter.encode(committed.getCommitLuceneVersion());
import org.opensearch.be.lucene.stats.LuceneStatsProvider;
 * {@code commitMerge}. Ownership of whatever the hook acquires (currently the engine's
import org.apache.lucene.index.SegmentInfos;
        return loadCommittedSnapshots(store).values().stream().filter(Objects::nonNull).collect(Collectors.toList());
import org.apache.lucene.store.ByteBuffersIndexOutput;
     *
        }
import java.util.concurrent.TimeUnit;
            store.decRef();
    }
            dfa.setLastCommitInfo(ic.getSegmentsFileName(), ic.getGeneration(), version);
    }
                store.directory().sync(commitData.catalogSnapshot().getFiles(false));
        for (Map.Entry<String, String> entry : liveCommitData) {
     */
    public List<CatalogSnapshot> listCommittedSnapshots() throws IOException {
                throw new IllegalStateException(
     * @throws IOException if opening the IndexWriter fails
        } catch (IOException e) {
        } else {
import org.apache.logging.log4j.LogManager;
    }
     * Subsequent calls are no-ops.
import java.util.concurrent.atomic.AtomicBoolean;
        } else if (userProvidedSort != null) {
    @Override
import org.opensearch.index.engine.exec.commit.CommitterConfig;
import org.apache.lucene.index.SerialMergeScheduler;
            while (unwrapped instanceof FilterDirectoryReader fdr) {
/*
import org.apache.lucene.index.NoMergePolicy;
            this.indexWriter = new MergeIndexWriter(store.directory(), iwc);
        sis.setNextWriteGeneration(catalogSnapshot.getLastCommitGeneration());
        // documents by remapped row ID during merge. When primary (or standalone), use the
    }
                store.directory().syncMetaData();
        if (reader == null) {
        return indexWriter;
        }
        }
import org.opensearch.index.engine.dataformat.DocumentInput;
        } finally {
 * {@code refreshLock → IW monitor} on the merge thread — matching the refresh path and
 * {@link CommitterConfig} (analyzer, codec, similarity, RAM buffer, index sort, etc.).
        sis.setUserData(sisUserData, false);
     *
        long start = System.nanoTime();
            IndexWriterConfig iwc = new IndexWriterConfig();
            );
            store.markStoreCorrupted(cause);
        // the engine-provided preMergeCommitHook here gives the merge path the ordering
            try {
    /**
        // Pin the merge policy to NoMergePolicy: this writer's only job is to re-anchor the
        // catalog is updated. See the class Javadoc.
    /**
        deletionPolicy.purgeCommit(snapshot.getId());
        // takes refreshLock before calling IndexWriter#addIndexes). Ownership of whatever the
import org.opensearch.be.lucene.LuceneReader;
                    tracker.addCommitTimeMillis(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
        // When secondary, use a SortedNumericSortField on the row ID so MultiSorter can reorder
    public void markStoreCorrupted(IOException cause) {
        this.store = Objects.requireNonNull(committerConfig.engineConfig().getStore());
            .setIndexCommit(targetCommit)
     * (which validates referenced files and races with concurrent merges).
        }
import org.opensearch.index.engine.exec.commit.SafeBootstrapCommitter;
        // mergeMiddle and commitMerge, while the IndexWriter monitor is NOT held. Invoking
        }
     *
        if (liveCommitData == null) {
    }
    }
import org.opensearch.index.engine.exec.commit.Committer;
            iwc.setSimilarity(engineConfig.getSimilarity());
    private static final Logger logger = LogManager.getLogger(LuceneCommitter.class);
    }
        ensureOpen();
    private final Store store;
     * Visible to other classes in this package (e.g., LuceneIndexingExecutionEngine).
    }
        sis.write(new ByteBuffersIndexOutput(out, "Snapshot of SegmentInfos", "SegmentInfos"));
    }
        }
    public LuceneCommitter(CommitterConfig committerConfig) throws IOException {
                unwrapped = fdr.getDelegate();
                : "Lucene is listed in catalog data formats but no reader was registered for version=" + catalogSnapshot.getId();
            store.decRef();
import java.util.LinkedHashMap;
            IndexWriterConfig iwc = createIndexWriterConfig(committerConfig);
        }
                    -1L,
                );
    static Map<IndexCommit, CatalogSnapshot> loadCommittedSnapshots(Store store) throws IOException {
    protected void discoverAndTrimUnsafeCommits(Store store, Path translogPath) throws IOException {
        sisUserData.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, catalogSnapshot.serializeToString());
        // TODO Check what is the right way to get this information as the below one is leaky
        DirectoryReader reader = luceneReader == null ? null : luceneReader.directoryReader();
        return readers;
            String serialized = ic.getUserData().get(CatalogSnapshot.CATALOG_SNAPSHOT_KEY);
        try {
import java.util.HashMap;
    }
import org.apache.lucene.search.Sort;
        if (engineConfig.getSimilarity() != null) {
 * monitor is <em>not</em> held, so invoking the hook there establishes the ordering
     * then opens the IndexWriter.
    Map<Long, LuceneReader> readers() {
 * <p>
            return iwc;
        ensureOpen();
    @Override
        }
        // Determine if Lucene is a secondary format in a composite setup.
    }
            if (unwrapped instanceof StandardDirectoryReader == false) {
     */
import org.opensearch.common.annotation.ExperimentalApi;
        iwc.setMergedSegmentWarmer(_ -> committerConfig.preMergeCommitHook().run());
    /**
     * The resulting {@code SegmentInfos} is strictly consistent with the catalog's Lucene
            return new CommitResult(committed.getSegmentsFileName(), committed.getGeneration(), version);
            // Write-ahead fsync: data files durable before the commit point that references them.
            if (commitData.catalogSnapshot() != null) {
    public void close() throws IOException {
import java.util.concurrent.ConcurrentHashMap;
                    0L,
            .setMergePolicy(NoMergePolicy.INSTANCE);
 * refresh lock) is transferred to the engine's {@code applyMergeChanges} callback, which
            sis = new SegmentInfos(Version.LATEST.major);
        try {
            .setCommitOnClose(false)
 * Lucene-specific {@link Committer} that owns the shared {@link IndexWriter} lifecycle
        iwc.setCommitOnClose(false);
            this.lastCommittedSegmentInfos = SegmentInfos.readLatestCommit(indexWriter.getDirectory());
            }
import org.opensearch.be.lucene.LuceneDataFormat;
        boolean threw = false;
 * The OpenSearch Contributors require contributions made to
            // Encode writer's Lucene version as a long — keeps CatalogSnapshot Lucene-type-agnostic.
import java.nio.file.Path;
import org.apache.lucene.index.FilterDirectoryReader;
        return new CommitStats(lastCommittedSegmentInfos);
 */
            DirectoryReader unwrapped = reader;
 *
        IndexWriterConfig iwc = new IndexWriterConfig().setOpenMode(IndexWriterConfig.OpenMode.APPEND)
            return;
        this.store.incRef();
                    List.of(),
    public CommitStats getCommitStats() {
        Map<IndexCommit, CatalogSnapshot> committed = loadCommittedSnapshots(store);
        }
            indexWriter.setLiveCommitData(commitData.userData());
    MergeIndexWriter getIndexWriter() {
     *
                LuceneStatsProvider.FORMAT_NAME
            if (serialized != null && serialized.isEmpty() == false) {
 * into Lucene as a {@code MergedSegmentWarmer} on the {@link IndexWriterConfig}. The warmer
     * Builds upload-time Lucene {@code SegmentInfos} bytes from the {@link DirectoryReader}
     * <p>Stats: {@code commit_time_millis} accumulates wall time for every attempt
            SegmentInfos committed = SegmentInfos.readLatestCommit(indexWriter.getDirectory());
     * {@code commit_total + commit_failures = total attempts}.
    // Keyed by catalog snapshot generation — survives snapshot cloning at the upload boundary.
    }
        if (engineConfig == null) {
import java.util.stream.Collectors;
            DataformatAwareCatalogSnapshot dfa;
            throw new IllegalStateException("LuceneCommitter is closed");
            tempWriter.setLiveCommitData(targetCommit.getUserData().entrySet());
 * releases it after the catalog is updated. This committer never touches the refresh lock
     * Returns the last committed data as an unmodifiable map.
            SegmentInfos committed = SegmentInfos.readCommit(store.directory(), ic.getSegmentsFileName());
     * Returns a {@link Map} preserving commit order (oldest → newest).
     * @return the last committed key-value pairs
 * {@code IndexWriter.addIndexes} during refresh in {@link LuceneIndexingExecutionEngine}.
                // leaking into ReplicationCheckpoint.segmentsGen.
    // --- Committer interface ---
                dfa = (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(
    @Override
     * @throws IllegalStateException if this committer is closed
                dfa = DataformatAwareCatalogSnapshot.deserializeFromString(serialized, resolver);
     * @throws IOException if reading commit data fails
        // commit point. The default TieredMergePolicy would otherwise merge segments without
     */
        if (isClosed.compareAndSet(false, true)) {
        if (isClosed.get()) {
import org.opensearch.index.engine.CommitStats;
    /**
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        EngineConfig engineConfig = committerConfig.engineConfig();
    /**
    }
        // engine config's IndexSort (which may be user-configured).
 * <p>
        iwc.setUseCompoundFile(engineConfig.useCompoundFile());
            tempWriter.commit();
        try {
     * @param committerConfig the committer committerConfig (shard path, index committerConfig, engine config, store)
            iwc.setIndexSort(userProvidedSort);
        CatalogSnapshot safeCommit = CombinedCatalogSnapshotDeletionPolicy.findSafeCommitPoint(snapshots, globalCheckpoint);
        // https://github.com/opensearch-project/OpenSearch/issues/21506
 * All per-generation {@link LuceneWriter} instances produce segments in isolated temp
            this.lastCommittedSegmentInfos = committed;
import java.util.Objects;
        LinkedHashMap<IndexCommit, CatalogSnapshot> result = new LinkedHashMap<>();
import org.apache.lucene.search.SortField;
                // Initial empty commit from store.createEmpty() has no serialized catalog.
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
                    ic.getUserData()
            indexWriter.commit();
        return Map.copyOf(result);
import java.util.function.Function;
            iwc.setIndexSort(new Sort(new SortedNumericSortField(DocumentInput.ROW_ID_FIELD, SortField.Type.LONG)));
            result.put(ic, dfa);
            LuceneStatsProvider provider = (LuceneStatsProvider) DataFormatStatsProviderRegistry.INSTANCE.get(
    private final Map<Long, LuceneReader> readers = new ConcurrentHashMap<>();
 * avoiding the lock inversion that would occur if coordination happened inside
 * {@link IndexWriter#commit()}.
        if (committed.isEmpty()) {
        indexWriter.deleteUnusedFiles();
        }
     * {@code commit_failures} increments only on a thrown exception. Therefore
import org.opensearch.index.engine.EngineConfig;
 * directories; those segments are later incorporated into this shared writer via
public class LuceneCommitter extends SafeBootstrapCommitter {
        }
        this.userProvidedSort = committerConfig.engineConfig().getIndexSort();
 * <p>
        return out.toArrayCopy();
        try (IndexWriter tempWriter = new IndexWriter(store.directory(), iwc)) {
            throw new IllegalStateException("No Lucene commits found — index may be corrupt");
    /** Returns the store reference. Package-private for sibling classes (e.g., LuceneDeleteExecutionEngine). */
        List<IndexCommit> commits = DirectoryReader.listCommits(store.directory());
        }
 * directly.
 * The store reference is incremented on construction and decremented on {@link #close()}.
import org.opensearch.index.engine.exec.coord.LuceneVersionConverter;
        if (store.tryIncRef() == false) {
 * runs between {@code mergeMiddle} and {@code commitMerge} while the {@link IndexWriter}
            logger.warn("Couldn't mark store corrupted", e);
        // honoring the engine's index sort, producing an unsorted merged segment that the
            long version = LuceneVersionConverter.encode(committed.getCommitLuceneVersion());
        ensureOpen();
     *
        List<String> secondaryFormats = engineConfig.getIndexSettings().getSettings().getAsList("index.composite.secondary_data_formats");
 * <p>The engine passes a {@code preMergeCommitHook} via {@link CommitterConfig}. We wire it
 * Closing the committer also closes the underlying IndexWriter.
 * Commit data (catalog snapshot, translog UUID, sequence numbers) is persisted atomically
     * @param commitData the key-value pairs to store as live commit data
     */
        String translogUUID = snapshots.getLast().getUserData().get(Translog.TRANSLOG_UUID_KEY);
package org.opensearch.be.lucene.index;
        }
        return store;
    /**
    /** Returns the version-keyed reader map used by {@link #serializeToCommitFormat}. */
     * consistency (write-ahead ordering).
@ExperimentalApi
import org.apache.lucene.index.IndexWriter;
        // refreshLock → IW monitor, which matches the refresh path (DataFormatAwareEngine#refresh
    /**
    private final LuceneCommitDeletionPolicy deletionPolicy;
        if (snapshots.isEmpty()) {
     * Creates a new LuceneCommitter. Trims unsafe commits (via {@link SafeBootstrapCommitter}),
        }
import org.opensearch.index.store.Store;
                }
import org.apache.lucene.index.IndexWriterConfig;
     * Loads committed CatalogSnapshots from Lucene IndexCommits in the given store.
 *
    @Override
     */
            this.deletionPolicy = new LuceneCommitDeletionPolicy();
import org.opensearch.index.engine.exec.CombinedCatalogSnapshotDeletionPolicy;
            // getFiles(false) excludes segments_N — IndexWriter.commit() handles that via rename + syncMetaData.
        Function<String, String> resolver = store.shardFormatDirectoryResolver();
            iwc.setIndexDeletionPolicy(deletionPolicy);
        long globalCheckpoint = Translog.readGlobalCheckpoint(translogPath, translogUUID);
        iwc.setIndexDeletionPolicy(deletionPolicy);
import org.apache.lucene.index.MergeIndexWriter;
     * Returns commit stats from the cached {@link SegmentInfos} to avoid a per-call disk read
        // No CatalogSnapshot commits found among Lucene commits — skipping safe commit trimming
        ensureOpen();
        List<CatalogSnapshot> snapshots = committed.values().stream().filter(Objects::nonNull).toList();
 * Extends {@link SafeBootstrapCommitter} to enforce safe commit trimming on startup.
    }
 *
        ensureOpen();
     * @throws IOException if the commit fails
     * If no commit data has been set, returns an empty map.
    Store getStore() {
    private volatile SegmentInfos lastCommittedSegmentInfos;
    }
            }
import org.apache.lucene.index.DirectoryReader;
    private final MergeIndexWriter indexWriter;
        sisUserData.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(catalogSnapshot.getId()));
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
     * this snapshot before upload is invoked. We fail fast rather than open a divergent
 * compatible open source license.
        return fileName.startsWith(IndexFileNames.SEGMENTS) || fileName.equals(IndexWriter.WRITE_LOCK_NAME);
            if (provider != null) {
import org.apache.lucene.search.SortedNumericSortField;
     * registered for this {@code catalogSnapshot} (opened at that snapshot's refresh point).
        if (targetCommit == null) {
        // Open a temp IndexWriter at the target commit and re-commit. The default deletion policy
                    } else {
        }
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
    @Override
import org.apache.lucene.index.StandardDirectoryReader;
    private IndexWriterConfig createIndexWriterConfig(CommitterConfig committerConfig) {
     * @throws IOException if closing the IndexWriter fails
    // --- SafeBootstrapCommitter abstract method ---
        ensureOpen();
    @Override
            throw e;
     * (success or failure). {@code commit_total} increments only on successful return.
    }
import org.apache.logging.log4j.Logger;
                indexWriter.close();
 * this file be licensed under the Apache-2.0 license or a
     * Only commits containing a serialized CatalogSnapshot are included.
        SegmentInfos sis;
        boolean isSecondary = secondaryFormats.contains("lucene");
        for (IndexCommit ic : commits) {
        return iwc;
        iwc.setRAMBufferSizeMB(engineConfig.getIndexingBufferSize().getMbFrac());
    Sort getUserProvidedSort() {
     * all referenced data files are fsync'd before the commit point to ensure crash
    private void ensureOpen() {
     * reader off the current {@code IndexWriter} state.
        // subsequent (sorted) MergeIndexWriter cannot open.
 * The shared writer is opened during construction using configuration from
                // Create an empty snapshot and seed its commit generation from the on-disk
    @Override
     */
        Map<String, String> result = new HashMap<>();
            threw = true;
     * Returns the underlying IndexWriter.
        }
