            }
import org.opensearch.index.translog.Translog;
        // both unsafe commits and orphan non-CatalogSnapshot commits as well, if any.
        return Map.copyOf(result);  
        try {
 * this file be licensed under the Apache-2.0 license or a
/**
                    }  
     * consistency (write-ahead ordering).
        }
    Map<Long, LuceneReader> readers() {  
     * @throws IllegalStateException if this committer is closed
        // the engine-provided preMergeCommitHook here gives the merge path the ordering
public class LuceneCommitter extends SafeBootstrapCommitter {  
import org.opensearch.be.lucene.stats.LuceneStatsProvider;
    /**
        }
     * Subsequent calls are no-ops.
        }
 * Commit data (catalog snapshot, translog UUID, sequence numbers) is persisted atomically
        indexWriter.deleteUnusedFiles();
        Map<String, String> sisUserData = new HashMap<>(catalogSnapshot.getUserData());
        // When secondary, use a SortedNumericSortField on the row ID so MultiSorter can reorder
     * <p>Stats: {@code commit_time_millis} accumulates wall time for every attempt
 * monitor is <em>not</em> held, so invoking the hook there establishes the ordering
            .setMergePolicy(NoMergePolicy.INSTANCE);
        }
            }
     *
            threw = true;  
                dfa = (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(
    }  
        sis.setNextWriteGeneration(catalogSnapshot.getLastCommitGeneration());
                indexWriter.close();
    private final Store store;
    public Map<String, String> getLastCommittedData() throws IOException {
 * into Lucene as a {@code MergedSegmentWarmer} on the {@link IndexWriterConfig}. The warmer
            logger.warn("Couldn't mark store corrupted", e);  
        return loadCommittedSnapshots(store).values().stream().filter(Objects::nonNull).collect(Collectors.toList());  
 * Lucene-specific {@link Committer} that owns the shared {@link IndexWriter} lifecycle  
        } finally {
    /**
        this.store.incRef();
                // segments_N so that getLastCommitGeneration() returns a stable value before
        }
    }  
        // engine config's IndexSort (which may be user-configured).  
     *  
            .setCommitOnClose(false)
            try {  
     *
import org.apache.lucene.index.IndexFileNames;  
            store.markStoreCorrupted(cause);
            store.decRef();
        sis.write(new ByteBuffersIndexOutput(out, "Snapshot of SegmentInfos", "SegmentInfos"));
     * Returns the underlying IndexWriter.  
     * @return the last committed key-value pairs  
     * Closes the IndexWriter and releases the store reference.
import org.opensearch.common.annotation.ExperimentalApi;  
            return Map.of();  
    /**  
import org.opensearch.be.lucene.LuceneReader;  
        IndexCommit targetCommit = null;
                    0L,
        // refreshLock → IW monitor, which matches the refresh path (DataFormatAwareEngine#refresh  
        ensureOpen();
                    } else {
     * Visible to other classes in this package (e.g., LuceneIndexingExecutionEngine).
     * @throws IOException if reading commit data fails
            iwc.setSimilarity(engineConfig.getSimilarity());
    public byte[] serializeToCommitFormat(CatalogSnapshot catalogSnapshot) throws IOException {  
            IndexWriterConfig iwc = createIndexWriterConfig(committerConfig);
    }
            // Encode writer's Lucene version as a long — keeps CatalogSnapshot Lucene-type-agnostic.
        if (snapshots.isEmpty()) {
     * If no commit data has been set, returns an empty map.
    /**
    protected void discoverAndTrimUnsafeCommits(Store store, Path translogPath) throws IOException {
                LuceneStatsProvider.FORMAT_NAME
                dfa = DataformatAwareCatalogSnapshot.deserializeFromString(serialized, resolver);  
        } finally {
 * compatible open source license.
    public LuceneCommitter(CommitterConfig committerConfig) throws IOException {
    static Map<IndexCommit, CatalogSnapshot> loadCommittedSnapshots(Store store) throws IOException {
                    tracker.addCommitTimeMillis(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));  
     *
            IndexWriterConfig iwc = new IndexWriterConfig();
                throw new IllegalStateException(
        if (engineConfig.getSimilarity() != null) {
                    tracker.addCommitSyncTimeMillis(syncMillis);
        DirectoryReader reader = luceneReader == null ? null : luceneReader.directoryReader();  
        iwc.setRAMBufferSizeMB(engineConfig.getIndexingBufferSize().getMbFrac());
        ensureOpen();  
            logger.info("No Lucene reader for catalog snapshot version={} — producing empty SegmentInfos", catalogSnapshot.getId());
    /** Returns the version-keyed reader map used by {@link #serializeToCommitFormat}. */
        // Refresh-lock hand-off: the MergedSegmentWarmer fires on the merge thread between  
import org.opensearch.be.lucene.LuceneDataFormat;
    private final Sort userProvidedSort;
            DataformatAwareCatalogSnapshot dfa;
        long start = System.nanoTime();
        if (engineConfig == null) {  
        return result;  
        }  
        if (isClosed.get()) {
                // Create an empty snapshot and seed its commit generation from the on-disk  
    }  
        // commit point. The default TieredMergePolicy would otherwise merge segments without
import org.apache.lucene.index.IndexWriter;
        ensureOpen();
import java.util.LinkedHashMap;
     */
     * {@code commit_failures} increments only on a thrown exception. Therefore  
                        tracker.incCommitFailures();  
     */  
        }
    public void close() throws IOException {
        List<IndexCommit> commits = DirectoryReader.listCommits(store.directory());  
     * {@code commit_total + commit_failures = total attempts}.
    public void markStoreCorrupted(IOException cause) {
     */  
 * The store reference is incremented on construction and decremented on {@link #close()}.
            iwc.setIndexDeletionPolicy(deletionPolicy);
        LuceneReader luceneReader = readers.get(catalogSnapshot.getId());
    private void ensureOpen() {
    @Override
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        return readers;
     *  
        // takes refreshLock before calling IndexWriter#addIndexes). Ownership of whatever the
            indexWriter.setLiveCommitData(commitData.userData());
                targetCommit = entry.getKey();
        // No CatalogSnapshot commits found among Lucene commits — skipping safe commit trimming
    /** Cached latest committed {@link SegmentInfos}; refreshed inside {@link #commit}, read by {@link #getCommitStats}. */
                    0L,
                    0L,  
 * runs between {@code mergeMiddle} and {@code commitMerge} while the {@link IndexWriter}  
            .setIndexCommit(targetCommit)  
import org.apache.lucene.search.SortedNumericSortField;
            this.indexWriter = new MergeIndexWriter(store.directory(), iwc);  
            throw new IllegalStateException("LuceneCommitter is closed");  
        ensureOpen();  
    @Override
    public List<CatalogSnapshot> listCommittedSnapshots() throws IOException {
                break;  
     * @throws IllegalStateException if this committer is closed
    }  
                store.directory().sync(commitData.catalogSnapshot().getFiles(false));
        if (isClosed.compareAndSet(false, true)) {
    private final AtomicBoolean isClosed = new AtomicBoolean();
            throw t;
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);  
import java.util.HashMap;  
                    ic.getUserData()
 * via {@link #commit(org.opensearch.index.engine.exec.commit.Committer.CommitInput)}, which sets the live commit data on the writer and calls
     * Builds upload-time Lucene {@code SegmentInfos} bytes from the {@link DirectoryReader}
import java.util.concurrent.atomic.AtomicBoolean;
        } catch (IOException e) {
            DirectoryReader unwrapped = reader;
     */
        iwc.setMergeScheduler(new SerialMergeScheduler());  
@ExperimentalApi
                );  
        sis.setUserData(sisUserData, false);
    // --- SafeBootstrapCommitter abstract method ---
    }
    @Override
        Iterable<Map.Entry<String, String>> liveCommitData = indexWriter.getLiveCommitData();
        // https://github.com/opensearch-project/OpenSearch/issues/21506
import java.util.Objects;
import org.opensearch.index.engine.exec.coord.LuceneVersionConverter;
                    -1L,  
        // TODO Check what is the right way to get this information as the below one is leaky
            this.deletionPolicy = new LuceneCommitDeletionPolicy();
            LuceneStatsProvider provider = (LuceneStatsProvider) DataFormatStatsProviderRegistry.INSTANCE.get(  
        return fileName.startsWith(IndexFileNames.SEGMENTS) || fileName.equals(IndexWriter.WRITE_LOCK_NAME);
 * <p>
        }
        return userProvidedSort;  
     * @param committerConfig the committer committerConfig (shard path, index committerConfig, engine config, store)
        }  
        if (store.tryIncRef() == false) {  
                // leaking into ReplicationCheckpoint.segmentsGen.  
import org.apache.lucene.index.MergeIndexWriter;  
        // Pin the merge policy to NoMergePolicy: this writer's only job is to re-anchor the  
        iwc.setCommitOnClose(false);
    public CommitStats getCommitStats() {
                syncMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - syncStart);  
    }
        Map<IndexCommit, CatalogSnapshot> committed = loadCommittedSnapshots(store);
 * <h2>Refresh-lock coordination</h2>
            iwc.setIndexSort(new Sort(new SortedNumericSortField(DocumentInput.ROW_ID_FIELD, SortField.Type.LONG)));
 * {@link IndexWriter#commit()}.  
     * Atomically persists the given commit data (catalog snapshot, translog UUID,
    @Override
            if (provider != null) {  
        ensureOpen();  
     * reader off the current {@code IndexWriter} state.  
 * <p>  
            iwc.setMergeScheduler(new SerialMergeScheduler());
    private static final Logger logger = LogManager.getLogger(LuceneCommitter.class);
import org.apache.lucene.index.StandardDirectoryReader;
        LinkedHashMap<IndexCommit, CatalogSnapshot> result = new LinkedHashMap<>();
import org.apache.logging.log4j.LogManager;
        // mergeMiddle and commitMerge, while the IndexWriter monitor is NOT held. Invoking
    @Override  
 * for a single shard.
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
    }  
     * sequence numbers) and commits the IndexWriter. When a catalog snapshot is present,  
     */  
            indexWriter.commit();
import org.apache.lucene.search.Sort;
    public boolean isCommitManagedFile(String fileName) {  
        } else {
 *
                unwrapped = fdr.getDelegate();
        super(committerConfig);
            } else {
    private final MergeIndexWriter indexWriter;  
        Map<String, String> result = new HashMap<>();
        try (IndexWriter tempWriter = new IndexWriter(store.directory(), iwc)) {
        CatalogSnapshot safeCommit = CombinedCatalogSnapshotDeletionPolicy.findSafeCommitPoint(snapshots, globalCheckpoint);
 * @opensearch.experimental  
        IndexWriterConfig iwc = new IndexWriterConfig().setOpenMode(IndexWriterConfig.OpenMode.APPEND)
    Store getStore() {
            iwc.setIndexSort(userProvidedSort);  
        List<String> secondaryFormats = engineConfig.getIndexSettings().getSettings().getAsList("index.composite.secondary_data_formats");  
     * format, {@code LuceneReaderManager.afterRefresh} MUST have registered the reader for
    }
 */
            SegmentInfos committed = SegmentInfos.readLatestCommit(indexWriter.getDirectory());  
            return iwc;
 * The shared writer is opened during construction using configuration from
            return;  
            );
    }
        sisUserData.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(catalogSnapshot.getId()));
        ensureOpen();
            while (unwrapped instanceof FilterDirectoryReader fdr) {  
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
        return new CommitStats(lastCommittedSegmentInfos);
            sis = ((StandardDirectoryReader) unwrapped).getSegmentInfos().clone();
        }
    private volatile SegmentInfos lastCommittedSegmentInfos;
    }
        return out.toArrayCopy();
     * @throws IOException if opening the IndexWriter fails
     *
        boolean isSecondary = secondaryFormats.contains("lucene");
        IndexWriterConfig iwc = new IndexWriterConfig(engineConfig.getAnalyzer());
    }
    }
        EngineConfig engineConfig = committerConfig.engineConfig();
 * Closing the committer also closes the underlying IndexWriter.  
     * registered for this {@code catalogSnapshot} (opened at that snapshot's refresh point).
        SegmentInfos sis;
     * <p>A missing reader indicates a plumbing bug — whenever Lucene is an active indexing  
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
        iwc.setUseCompoundFile(engineConfig.useCompoundFile());
     */
        ByteBuffersDataOutput out = new ByteBuffersDataOutput();  
        return indexWriter;
            long version = LuceneVersionConverter.encode(committed.getCommitLuceneVersion());  
 *  
    }
import org.opensearch.index.engine.exec.CombinedCatalogSnapshotDeletionPolicy;
        // catalog is updated. See the class Javadoc.  
                long syncStart = System.nanoTime();  
        // subsequent (sorted) MergeIndexWriter cannot open.  
        sisUserData.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, catalogSnapshot.serializeToString());  
        }
     * then opens the IndexWriter.
    /**  
import org.apache.lucene.store.ByteBuffersIndexOutput;  
            } finally {
            assert catalogSnapshot.getDataFormats().contains(LuceneDataFormat.LUCENE_FORMAT_NAME) == false  
                : "Lucene is listed in catalog data formats but no reader was registered for version=" + catalogSnapshot.getId();
     * Returns a {@link Map} preserving commit order (oldest → newest).
            dfa.setLastCommitInfo(ic.getSegmentsFileName(), ic.getGeneration(), version);  
        String translogUUID = snapshots.getLast().getUserData().get(Translog.TRANSLOG_UUID_KEY);
    @Override
import org.opensearch.index.engine.dataformat.DocumentInput;  
     * @param commitData the key-value pairs to store as live commit data  
     * (which validates referenced files and races with concurrent merges).
import java.nio.file.Path;
     * Returns commit stats from the cached {@link SegmentInfos} to avoid a per-call disk read
 * {@link CommitterConfig} (analyzer, codec, similarity, RAM buffer, index sort, etc.).
        for (IndexCommit ic : commits) {
                    if (threw) {
import org.opensearch.index.engine.exec.commit.Committer;
        } catch (Exception e) {
import org.apache.lucene.index.SegmentInfos;
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
                    "Reader for catalog snapshot version=" + catalogSnapshot.getId() + " is not a StandardDirectoryReader: " + reader
     * @return the index writer, or null if closed  
 * {@code refreshLock → IW monitor} on the merge thread — matching the refresh path and
        ensureOpen();
     * (success or failure). {@code commit_total} increments only on successful return.
    /**  
/*  
        Function<String, String> resolver = store.shardFormatDirectoryResolver();
import org.opensearch.index.engine.EngineConfig;
    Sort getUserProvidedSort() {
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
                }
        }
            store.decRef();  
        for (Map.Entry<String, String> entry : liveCommitData) {  
    @Override
            // getFiles(false) excludes segments_N — IndexWriter.commit() handles that via rename + syncMetaData.
                    List.of(),
        List<CatalogSnapshot> snapshots = committed.values().stream().filter(Objects::nonNull).toList();  
import org.apache.lucene.index.IndexWriterConfig;
    private final Map<Long, LuceneReader> readers = new ConcurrentHashMap<>();
            }
 * refresh lock) is transferred to the engine's {@code applyMergeChanges} callback, which
 * releases it after the catalog is updated. This committer never touches the refresh lock  
            }
 * <p>The engine passes a {@code preMergeCommitHook} via {@link CommitterConfig}. We wire it
import java.util.concurrent.ConcurrentHashMap;
            throw e;
    /**  
            iwc.setMergePolicy(NoMergePolicy.INSTANCE);  
        // TODO:: Merge Config needs to be wired in
import org.apache.lucene.index.FilterDirectoryReader;
     * this snapshot before upload is invoked. We fail fast rather than open a divergent
        iwc.setMergedSegmentWarmer(_ -> committerConfig.preMergeCommitHook().run());
        }
import org.apache.lucene.util.Version;
import org.opensearch.index.engine.exec.commit.CommitterConfig;  
     * @throws IOException if closing the IndexWriter fails
            tempWriter.commit();
            }
        try {  
            sis = new SegmentInfos(Version.LATEST.major);  
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
 *
    private IndexWriterConfig createIndexWriterConfig(CommitterConfig committerConfig) {
                // Initial empty commit from store.createEmpty() has no serialized catalog.
import org.apache.lucene.store.ByteBuffersDataOutput;
        ensureOpen();  
     * all referenced data files are fsync'd before the commit point to ensure crash
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;  
        if (targetCommit == null) {  
 * {@code commitMerge}. Ownership of whatever the hook acquires (currently the engine's
import org.apache.lucene.search.SortField;  
     * Creates a new LuceneCommitter. Trims unsafe commits (via {@link SafeBootstrapCommitter}),
            result.put(ic, dfa);
        // hook acquires is transferred to applyMergeChanges, which releases it after the
import java.util.function.Function;
    private final LuceneCommitDeletionPolicy deletionPolicy;
        } catch (Throwable t) {
            if (unwrapped instanceof StandardDirectoryReader == false) {  
    // --- Committer interface ---
    MergeIndexWriter getIndexWriter() {
            this.lastCommittedSegmentInfos = SegmentInfos.readLatestCommit(indexWriter.getDirectory());
    /**
 *
     *  
                LuceneShardStatsTracker tracker = provider.getTracker(store.shardId());
        // Determine if Lucene is a secondary format in a composite setup.  
        if (committed.isEmpty()) {  
import org.apache.lucene.index.DirectoryReader;  
            throw new IllegalStateException("No Lucene commits found — index may be corrupt");
 * All per-generation {@link LuceneWriter} instances produce segments in isolated temp  
import org.apache.lucene.index.SerialMergeScheduler;  
            return new CommitResult(committed.getSegmentsFileName(), committed.getGeneration(), version);
            if (entry.getValue() != null && entry.getValue().getGeneration() == safeCommit.getGeneration()) {
            String serialized = ic.getUserData().get(CatalogSnapshot.CATALOG_SNAPSHOT_KEY);  
        if (isSecondary) {  
    // --- Internal ---
        // honoring the engine's index sort, producing an unsorted merged segment that the
import org.apache.lucene.index.IndexCommit;
     * Returns the last committed data as an unmodifiable map.  
import org.apache.logging.log4j.Logger;
        return store;
    }
    @Override  
            }
    }
        long globalCheckpoint = Translog.readGlobalCheckpoint(translogPath, translogUUID);  
     * The resulting {@code SegmentInfos} is strictly consistent with the catalog's Lucene  
     * file set.
                store.directory().syncMetaData();
                if (tracker != null) {
     * Loads committed CatalogSnapshots from Lucene IndexCommits in the given store.  
            long version = LuceneVersionConverter.encode(committed.getCommitLuceneVersion());
            result.put(entry.getKey(), entry.getValue());
        if (reader == null) {
        if (liveCommitData == null) {
import org.apache.lucene.index.NoMergePolicy;
                this.store.decRef();  
        this.userProvidedSort = committerConfig.engineConfig().getIndexSort();
            // Write-ahead fsync: data files durable before the commit point that references them.  
package org.opensearch.be.lucene.index;
 * Extends {@link SafeBootstrapCommitter} to enforce safe commit trimming on startup.
    @Override  
import org.opensearch.index.engine.CommitStats;
 * <p>  
 * directories; those segments are later incorporated into this shared writer via
import org.opensearch.index.engine.exec.commit.SafeBootstrapCommitter;
        boolean threw = false;  
    }  
        for (Map.Entry<IndexCommit, CatalogSnapshot> entry : committed.entrySet()) {  
            SegmentInfos committed = SegmentInfos.readCommit(store.directory(), ic.getSegmentsFileName());
        iwc.setIndexDeletionPolicy(deletionPolicy);
     */  
     * @throws IOException if the commit fails
     * Only commits containing a serialized CatalogSnapshot are included.
}
        long syncMillis = 0;
            return;
            if (commitData.catalogSnapshot() != null) {
        // (KeepOnlyLastCommitDeletionPolicy) discards all other segments_N files, cleaning up
 * avoiding the lock inversion that would occur if coordination happened inside  
        }  
     */  
            this.lastCommittedSegmentInfos = committed;
                // the first real flush — preventing the catalog generation fallback from
        return iwc;
        ensureOpen();  
        } else if (userProvidedSort != null) {
    }  
        }
import java.util.Map;  
                );
 */  
            throw new IllegalStateException("Safe commit [gen=" + safeCommit.getGeneration() + "] not found among Lucene IndexCommits");
        deletionPolicy.purgeCommit(snapshot.getId());
 * directly.
        iwc.setCodec(engineConfig.getCodec());  
        }  
 * {@code IndexWriter.addIndexes} during refresh in {@link LuceneIndexingExecutionEngine}.
    // Keyed by catalog snapshot generation — survives snapshot cloning at the upload boundary.  
        this.store = Objects.requireNonNull(committerConfig.engineConfig().getStore());  
        }  
            if (serialized != null && serialized.isEmpty() == false) {
            }  
        // documents by remapped row ID during merge. When primary (or standalone), use the
    public void deleteCommit(CatalogSnapshot snapshot) throws IOException {
import java.util.concurrent.TimeUnit;  
    public synchronized CommitResult commit(CommitInput commitData) throws IOException {
import org.opensearch.index.store.Store;  
        try {  
        // Open a temp IndexWriter at the target commit and re-commit. The default deletion policy  
    /** Returns the store reference. Package-private for sibling classes (e.g., LuceneDeleteExecutionEngine). */  
import java.util.stream.Collectors;  
    @Override
                        tracker.incCommitTotal();
        }
            tempWriter.setLiveCommitData(targetCommit.getUserData().entrySet());  
