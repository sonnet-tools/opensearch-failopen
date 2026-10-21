        installSnapshot(newSnapshot);
            // by the file deleter but was never made visible as latestCatalogSnapshot.
            for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {
    private boolean assertRowCountConservation(Set<Segment> sourceSegments, Segment mergedSegment) {
import org.opensearch.index.engine.exec.Segment;
import java.util.Set;
    public SafeCommitInfo getSafeCommitInfo() {
import org.opensearch.common.CheckedFunction;
 *
    }
                firstException
    }
    }
        Map<String, FilesListener> filesListeners,
                    ex.addSuppressed(suppressed);
                            rows
        List<Segment> segmentList = new ArrayList<>(latestCatalogSnapshot.getSegments());
        // are initialized on engine open.
                                    existingWfs.files(),
     *
     * exceed the total row count across all formats in the source segments. Catches bugs
                            Set<String> existingFiles = existingWfs.files();
            latestCatalogSnapshot.getLastCommitGeneration(),
            throw ex;
            : "segment generation refers to an unrelated file set compared with a previous snapshot";
            deletionPolicy,
                            entry.getKey(),
     * @throws IllegalArgumentException if the map is empty
        final CatalogSnapshot snapshot = acquireLatestSnapshot();
 * zero (via {@link #decRefAndMaybeDelete}), it is automatically removed from the map and its files
                            if (existingFiles.isEmpty() && newFiles.isEmpty()) {
        catalogSnapshotMap.put(newSnapshot.getGeneration(), newSnapshot);
            + newSnapshot.getGeneration()
        return segmentToAdd;
        FileDeleter fileDeleter,
                    + outputRows
     *
                .filter(gen -> segmentList.stream().noneMatch(s -> s.generation() == gen))
     * @param mergeResult the result of the merge containing the merged writer file set
        Set<Long> generationsToRemove = new HashSet<>();
        }
            }
        if (closed.get()) {
            + latestCatalogSnapshot.getGeneration()
            commitResult.commitDataFormatVersion()
    }
    private void decRefAndMaybeDelete(CatalogSnapshot snapshot) {
        // Every segment must have at least one format with files
     * {@code Segment} is a record whose {@code equals} covers its whole file set, and a refresh
                for (Segment existingSeg : existing.getSegments()) {
            newSnapshot = new DataformatAwareCatalogSnapshot(
                "Merged segment row count mismatch: input segments have "
     * from {@code match} vs {@code LIKE} over the same field.
                }
            listener.beforeRefresh();
        assert newSnapshot.getGeneration() > latestCatalogSnapshot.getGeneration() : "new snapshot generation ["
 *
     * {@code commitMerge}, and its {@code .liv} is flushed before the merged file set is recorded,
        }
        }
            throw new IllegalStateException("CatalogSnapshotManager is closed");
            latestCatalogSnapshot.getVersion(), // This increases if there is an actual change in the snapshot.
        // format's WriterFileSet must report the same row count. This is the invariant
        for (Map.Entry<DataFormat, WriterFileSet> entry : writerFileSetMap.entrySet()) {
                    if (existingSeg.generation() == newSeg.generation()) {
            }
        installSnapshot(newSnapshot);
            long inputRows = sourceSegments.stream()
            latestCatalogSnapshot.getLastCommitFileName(),
     */
        });
            }
 * compatible open source license.
        newSnapshot.setReplicatingCommitData(((DataformatAwareCatalogSnapshot) incoming).getReplicatingCommitData());
                latestCatalogSnapshot.getCommitDataFormatVersion()
            throw new IllegalStateException("CatalogSnapshotManager is closed");
    }
        for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {
        long version,
    }
            Segment currSegment = segmentList.get(segIdx);
            mergedRows += wfs.numRows();
     */
            logger.error("Row count mismatch: source segments have {} rows but merged segment has {} rows", sourceRows, mergedRows);
     * @throws IOException if committing the new snapshot fails
            .anyMatch(s -> s.generation() == segmentToAdd.generation())) {
                                // New format for this generation; nothing to compare.
 * The OpenSearch Contributors require contributions made to
            generationsToRemove.add(source.generation());
 */
                throw new IllegalStateException("WriterFileSet is null for format [" + entry.getKey().name() + "] — merge was incomplete");
     * Creates a new CatalogSnapshot from refreshed segments, replacing the current latest.
     */
    public CatalogSnapshotManager(
     */
            latestCatalogSnapshot.getGeneration() + 1, // This is for commit generation tracking. So this should increase as well. Handles
        CommitFileManager commitFileManager
    ) throws IOException {
            + "]";
        verifyPerSegmentCrossFormatRowCountParity(refreshedSegments);
        }
            return false;
     * <p>Sources are identified by <em>generation</em>, never by {@link Segment} identity. A
        assert newSnapshot.getId() > latestCatalogSnapshot.getId() : "new snapshot ID ["
 *
            incoming.getSegments(),
    }
                        for (Map.Entry<String, WriterFileSet> entry : newSeg.dfGroupedSearchableFiles().entrySet()) {
    private CatalogSnapshot acquireLatestSnapshot() {
 * <p>The write path (commit) is single-threaded (refresh is serialized per shard), while the read
     * @param commitFileManager    manager for commit-level files (e.g., segments_N), or null if not needed
        // Compared against the sources as the merge read them, which is what produced the output.
    /**
package org.opensearch.index.engine.exec.coord;
            latestCatalogSnapshot.getUserData(),
     * (including any commit references) are released.
        boolean inserted = false;
     * Builds a {@link Segment} from a map of data format to writer file set entries.
    /**
        // No duplicate generations within the same snapshot
                indexFileDeleter.removeFileReferences(newSnapshot);
     * <p>
     *
     * by a {@link CatalogSnapshotManager} — its reference count is not tracked, and callers
                                );
     * @throws IllegalStateException if the manager or snapshot is already closed
                .sum();
                ex.addSuppressed(suppressed);
     */
     * single refresh — which produces silent correctness issues like different counts
        return true;
import java.util.Locale;
            commitResult.generation(),
            }
        }
                        String.format(
        }
        newSnapshot.setReplicatingCommitData(latestCatalogSnapshot.getReplicatingCommitData());
    private final IndexFileDeleter indexFileDeleter;
            throw new IllegalStateException("CatalogSnapshotManager is closed");
            try {
        }
     * Serializes the given {@link CatalogSnapshot} using the registered
        }
                latestCatalogSnapshot.getId() + 1,
            snapshot = latestCatalogSnapshot;
        return snapshotSerializer.apply(catalogSnapshot);
        for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {
                                    entry.getValue().files()
        // Register file references BEFORE notifying listeners and swapping the snapshot.
     * Replica-only: does not fire beforeRefresh/afterRefresh since the catalog snapshot
    /**
        }
    }
                    listener.onDeleted(newSnapshot);
     * <p>The multi-format segment model pairs one logical row set across formats — e.g.
import org.opensearch.index.engine.dataformat.DataFormat;
            + newSnapshot.getId()
    public byte[] serializeToCommitFormat(CatalogSnapshot catalogSnapshot) throws IOException {
import org.opensearch.common.annotation.ExperimentalApi;
        Set<Segment> sourceSegments = new HashSet<>(oneMerge.getSegmentsToMerge());
                            Set<String> newFiles = entry.getValue().files();
                        )
                .sorted()
    /**
                segmentList.set(newSegIdx, currSegment);
            commitFileManager,
        return new DataformatAwareCatalogSnapshot(id, generation, version, segments, lastWriterGeneration, userData);
        return new GatedCloseable<>(policyRef.get(), () -> {
        return true;
import org.opensearch.common.concurrent.GatedConditionalCloseable;
            }
     * @return a {@link GatedConditionalCloseable} wrapping the current {@link CatalogSnapshot}
            commitResult.commitFileName(),
     */
        // New snapshot ID must be strictly greater than the previous
 * SPDX-License-Identifier: Apache-2.0
            }
            try {
    /**
                "Failed to notify listener of snapshot deletion [gen=" + snapshot.getGeneration() + "]",
     * Acquires the current latest snapshot with an incremented reference count.
        if (!inserted) {
    /**
        List<CatalogSnapshotLifecycleListener> snapshotListeners,
    }
     * Typically called after {@link org.opensearch.index.engine.exec.commit.Committer#listCommittedSnapshots()}
    /**
        long sourceRows = 0;
            long outputRows = segmentToAdd.dfGroupedSearchableFiles().values().stream().mapToLong(WriterFileSet::numRows).sum();
    public synchronized Segment applyMergeResults(MergeResult mergeResult, OneMerge oneMerge) throws IOException {
    }
        }
        do {
     * Called by the engine after {@link org.opensearch.index.engine.exec.commit.Committer#commit}
import org.opensearch.index.engine.exec.CommitFileManager;
                if (firstException == null) firstException = e;
    // ---- Refresh path ----
    }
                    referenceFormat = entry.getKey();
            );
            } catch (IOException e) {
        decRefAndMaybeDelete(oldSnapshot);
                .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
        List<Segment> segments,
    /**
        }
        } while (!snapshot.tryIncRef());
    }
     * a resend of the same (or older) generation is a no-op.
        }
            : "every WriterFileSet must have a positive row count";
     * @param oneMerge    the merge specification identifying which segments were merged
            latestCatalogSnapshot.getLastCommitGeneration(),
        // that downstream segment-ord translation relies on (e.g. Rust's parquet
                throw new IllegalStateException("CatalogSnapshotManager is closed");
    public void close() {
import java.io.Closeable;
        return new GatedCloseable<>(snapshot, () -> decRefAndMaybeDelete(snapshot));
                            seg.generation(),
        // Generation, id and commit file details are local to the replica.
    /**
        Map<String, String> userData
import org.opensearch.common.concurrent.GatedCloseable;
     * @return a {@link GatedCloseable} wrapping the current {@link CatalogSnapshot}
        assert refreshedSegments.stream().allMatch(s -> s.dfGroupedSearchableFiles().isEmpty() == false)
import org.opensearch.index.shard.ShardPath;
        if (!assertRowCountConservation(sourceSegments, segmentToAdd)) {
                    + " rows"
                            }
                                return false;
     * Read-path only — the returned {@link GatedCloseable}'s close will decRef the snapshot.
    /**
        }
        DataformatAwareCatalogSnapshot oldSnapshot = latestCatalogSnapshot;
import org.opensearch.index.engine.dataformat.MergeResult;
                            if (existingWfs == null) {
    }
        }
            latestCatalogSnapshot.getLastCommitFileName(),
        // not, but only because all segments we merged became
            throw new RuntimeException("Failed to add file references for snapshot [gen=" + newSnapshot.getGeneration() + "]", e);
        }
            if (closed.get()) {
     */
        }, () -> decRefAndMaybeDelete(snapshot));
        if (segmentList.stream()
     *
            shardPath,
                } else if (rows != expected) {
        // only a merged count strictly greater than the source total is an invariant violation.
     * snapshot and passes it as a singleton list.
    @Override
        // Merged segment generation must not collide with any segment that will be retained
        indexFileDeleter.decRefAndMaybeDelete(snapshot);
        for (int segIdx = 0, cnt = segmentList.size(); segIdx < cnt; segIdx++) {
                else firstException.addSuppressed(e);
        DataformatAwareCatalogSnapshot newSnapshot = new DataformatAwareCatalogSnapshot(
import org.opensearch.index.engine.SafeCommitInfo;
        }
     * must not rely on ref-counting semantics.
                if (!inserted) {
        if (committedSnapshots.isEmpty()) {
        GatedCloseable<CatalogSnapshot> policyRef = deletionPolicy.acquireCommittedSnapshot(acquiringSafe);
     *
        // the rest of the segments in list are duplicates, so don't remove from map, only list!
    /**
        commitNewSnapshot(segmentList);
        final CatalogSnapshot snapshot = acquireLatestSnapshot();
    /**
        // Compaction with deletes may drop rows, so the merged total can be lower —
     * <ul>
     * </ul>
                    newSegIdx++;
                } catch (Exception suppressed) {
        Segment segmentToAdd = getSegment(mergeResult.getMergedWriterFileSet());
    /**
                            expected,
                    throw new IllegalStateException(
    private final Map<Long, CatalogSnapshot> catalogSnapshotMap = new ConcurrentHashMap<>();
 * this file be licensed under the Apache-2.0 license or a
     * Constructs a new CatalogSnapshotManager from committed snapshots.
            for (WriterFileSet wfs : seg.dfGroupedSearchableFiles().values()) {
     * Asserts that within each segment, every format's {@link WriterFileSet} reports
    /**
        // Commit new catalog snapshot
        for (Map.Entry<DataFormat, WriterFileSet> entry : writerFileSetMap.entrySet()) {
     * ordinal translation on the query side (parquet segment_ord → Lucene leaf index
     * Acquires the current latest snapshot for committing (flushing).
                latestCatalogSnapshot.getGeneration() + 1,
     * {@link DataformatAwareCatalogSnapshot} constructor. The returned snapshot is NOT managed
            // Notify already-notified listeners that the snapshot is being discarded.
            incoming.getUserData(),
 * <p>Tracks all live snapshots in a map keyed by generation. When a snapshot's reference count reaches
        // fails, the files are tracked and will be cleaned up when the snapshot is deleted.
            latestCatalogSnapshot.getId() + 1,  // This is unique for each catalog snapshot managed by this manager.
        return segment.build();
     * where rows are duplicated during merge. Rows may be legitimately dropped when the
                                continue;
     * merger compacts deleted rows (see {@code MergeInput#liveDocs}).
        );
    public GatedConditionalCloseable<CatalogSnapshot> acquireSnapshotForCommit() {
            : "refreshed segments contain duplicate generations";
                            }
                notified.add(listener);
     * the merge. Deletes landing mid-merge are carried onto the merged segment by Lucene's
        // Row count conservation: merged output must not exceed sum of input rows.
     * Notifies the IndexFileDeleter of new files. Releases the manager's own reference to
     * Returns information about the safe commit from the underlying deletion policy.
            throw new IllegalArgumentException("writerFileSetMap must not be empty");
                            "Per-segment row count mismatch at generation %s: format [%s] has %s rows but format [%s] has %s rows",
import org.opensearch.index.engine.exec.CatalogSnapshotLifecycleListener;
     * <p>A source generation may also be gone entirely: a refresh that deletes every document in a
        if (firstException != null) {
                    );
                try {
    public synchronized void bumpGeneration() throws IOException {
     * This is a convenience method for test code that cannot access the package-private
        }
     * @param fileDeleter          per-format deleters for actual file deletion
     */
            latestCatalogSnapshot.getLastWriterGeneration() + 1,
     * Called when a CatalogSnapshot's refCount reaches 0 — either from this class
            // so they can reset any state prepared in beforeRefresh
            this::onSnapshotDeleted
            latestCatalogSnapshot.getSegments(),
        try {
import java.util.concurrent.atomic.AtomicBoolean;
            }
                latestCatalogSnapshot.getLastWriterGeneration() + 1,
     * <p>
                }
     * The snapshot won't be deleted until the returned {@link GatedCloseable} is closed.
                    e.addSuppressed(suppressed);
     */
        for (Segment seg : sourceSegments) {
            indexFileDeleter.addFileReferences(newSnapshot);
        // counts at query time.
     */
            if (absent.isEmpty() == false) {
     * On close, the policy releases the hold and the deleter revisits for cleanup.
        }
                    + " total rows but merged output has "
                            referenceFormat,
import java.util.Map;
 * and coordinates file deletion through an internally owned {@link IndexFileDeleter}.
        assert refreshedSegments.stream().map(Segment::generation).distinct().count() == refreshedSegments.size()
import org.apache.logging.log4j.LogManager;
     */
 * are cleaned up through the deleter.</p>
     * {@link org.opensearch.index.engine.exec.CommitFileManager#serializeToCommitFormat}.
                } catch (Exception suppressed) {
        } catch (IOException e) {
        // be the case that the new segment is also all deleted,
        // honor the associated invariants (e.g. increasing generaiton)
    }
@ExperimentalApi
        // We should honor the state management within CatalogSnapshotManager to ensure these values
public class CatalogSnapshotManager implements Closeable {
            listener.afterRefresh(true, latestCatalogSnapshot);
     * generation drops it (see {@code RefreshResult.droppedGenerations}). Neither case invalidates
                latestCatalogSnapshot.getLastCommitFileName(),
        CatalogSnapshot snapshot;
     * @throws IllegalStateException if the manager or snapshot is already closed
                    segmentList.set(segIdx, segmentToAdd);
    public static CatalogSnapshot createInitialSnapshot(
                if (expected == -1L) {
import java.util.HashSet;
     * Validates snapshot invariants, registers file references, notifies listeners, and swaps
     * @param committedSnapshots   the committed snapshots, ordered oldest first; must not be empty
     *                      otherwise the last commit (for _snapshot API)
    ) {
     * Generations come from a single monotonic counter and are never reused, so the number alone
            .filter(s -> generationsToRemove.contains(s.generation()) == false)
            }
        }
                throw new RuntimeException("Failed to release committed snapshot [gen=" + policyRef.get().getGeneration() + "]", e);
 * Manages the lifecycle of {@link CatalogSnapshot} instances for the composite multi-format engine
                                    newSeg.generation(),
        // Notify listeners about the committed snapshot so reader managers
            throw new RuntimeException(
     * a parquet file and a Lucene leaf that both represent the same 1000 rows. Segment
        for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {
        return deletionPolicy.getSafeCommitInfo();
    public GatedCloseable<CatalogSnapshot> acquireCommittedSnapshot(boolean acquiringSafe) {
    /**
                latestCatalogSnapshot.getUserData(),
            + "] must be > previous ["
        this.latestCatalogSnapshot = (DataformatAwareCatalogSnapshot) committedSnapshots.getLast();
        catalogSnapshotMap.remove(snapshot.getGeneration());
        for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {
            try {
        logger.debug("New Catalog Snapshot created: {}", latestCatalogSnapshot);
import org.opensearch.index.engine.exec.commit.Committer.CommitResult;
            filesListeners,
     * so the output already reflects them. Both cases therefore apply normally; a merge applied
    // ---- Snapshot protection for _snapshot API / peer recovery ----
            segmentList.add(0, segmentToAdd);
     */
     * the old snapshot — the snapshot will only be fully cleaned up when all references
     * identifies a source unambiguously.
        // Either we found place to insert segment, or, we did
     * Closes this manager. Idempotent. DecRefs the current snapshot and cleans up if count reaches zero.
                    }
            String referenceFormat = null;
        // The snapshot won't be deleted if the commit path still holds a reference.
     */
                throw new RuntimeException("Failed to register commit [gen=" + snapshot.getGeneration() + "]", e);
        this.snapshotListeners = snapshotListeners;
        if (closed.get()) {
        long mergedRows = 0;
                newSegIdx++;
     * @param shardPath            for orphan cleanup on init, or null if not needed
                listener.onDeleted(snapshot);
                        }
            listener.beforeRefresh();
                    inserted = true;
    private final CheckedFunction<CatalogSnapshot, byte[], IOException> snapshotSerializer;
     * here means the writers dropped or duplicated rows against each other during a
                indexFileDeleter.onCommit(snapshot);
                    listener.afterRefresh(false, null);
        }
            }
            for (CatalogSnapshotLifecycleListener listener : notified) {
     * @return the constructed segment
    /**
     * data format version so that replicas and recovery can identify the commit point.
     */
    private void verifyPerSegmentCrossFormatRowCountParity(List<Segment> segments) {
                sourceRows += wfs.numRows();
            latestCatalogSnapshot.getCommitDataFormatVersion()
import org.opensearch.index.engine.exec.WriterFileSet;
        long id,
            );
                latestCatalogSnapshot.getLastCommitGeneration(),
import java.io.IOException;
                }
     */
     */
    public GatedCloseable<CatalogSnapshot> acquireSnapshot() {
import org.opensearch.index.engine.exec.FileDeleter;
    private volatile DataformatAwareCatalogSnapshot latestCatalogSnapshot;
            segment.addSearchableFiles(entry.getKey(), entry.getValue());
            for (CatalogSnapshot existing : catalogSnapshotMap.values()) {
     *
                    e.addSuppressed(suppressed);
            latestCatalogSnapshot.getCommitDataFormatVersion()
        }
     *
     * @param acquiringSafe if true, acquires the safe commit (for peer recovery);
        // Not an error — see the method javadoc. Logged because it means this merge raced a
        }
                "Merged segment generation [" + segmentToAdd.generation() + "] collides with a retained segment generation"
     * @param commitResult the result of the commit containing the segments_N filename, generation, and format version
        List<CatalogSnapshot> committedSnapshots,
        // the new snapshot and no state has been mutated.
    }
                                    entry.getKey(),
            );
        assert refreshedSegments.stream().flatMap(s -> s.dfGroupedSearchableFiles().values().stream()).allMatch(wfs -> wfs.numRows() > 0)
     */
            throw e;
                    listener.afterRefresh(false, null);
     * Removes the snapshot from the tracking map and notifies lifecycle listeners
import java.util.concurrent.ConcurrentHashMap;
                refreshedSegments,
        if (closed.get()) {
            for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {
    // ---- Internal ----
     * Creates a new {@link DataformatAwareCatalogSnapshot} for use in tests.
        // we insert it at the beginning if it should not be dropped:
     * (via {@link #decRefAndMaybeDelete}) or from {@link IndexFileDeleter} when the
    private final AtomicBoolean closed = new AtomicBoolean(false);
        } catch (Exception e) {
            catalogSnapshotMap.put(cs.getId(), cs);
        return snapshot;
        if (closed.get()) {
        // deleted while we are merging, in which case it should
        Segment.Builder segment = Segment.builder(generation);
        }
        // delete-bearing refresh, which is worth seeing when reasoning about merge throughput.
/**
            throw new IllegalStateException("CatalogSnapshotManager is closed");
     */
        // one of the writers dropped or duplicated rows during a single refresh —
                    + inputRows
     * file names, but disjoint sets indicate generation reuse for unrelated data.
    public synchronized void commitNewSnapshot(List<Segment> refreshedSegments) throws IOException {
            // File reference registration failed — notify listeners that refresh did not complete
    public void incrementUnreferencedFileCleanUps() {
            // A listener failed after file references were registered. The snapshot is tracked
        }
     * @param filesListeners       per-format listeners notified on file add/delete
                                logger.error(
            latestCatalogSnapshot.getLastWriterGeneration() + 1, // Not needed, can be removed.
            throw new IllegalStateException(
                try {
                            WriterFileSet existingWfs = existingSeg.dfGroupedSearchableFiles().get(entry.getKey());
        );
     * discovers the surviving commits on startup. For fresh indices, the caller creates a single initial
     * The caller must call {@code markSuccess()} on the returned handle after a successful commit.
    }
    }
            + "] must be > previous ["
            latestCatalogSnapshot.getId() + 1, // Increase this as this is always unique
        // New snapshot generation must be strictly greater than the previous
            for (Map.Entry<String, WriterFileSet> entry : seg.dfGroupedSearchableFiles().entrySet()) {
            }
     * Applies the results of a completed merge to the latest catalog snapshot.
        this.indexFileDeleter = new IndexFileDeleter(
    private Segment getSegment(Map<DataFormat, WriterFileSet> writerFileSetMap) {
     * <p>
            }
     * @param snapshotListeners    listeners notified on snapshot deletion
            if (generationsToRemove.contains(currSegment.generation())) {
        }
        } catch (Exception ex) {
     * Acquire a committed snapshot for _snapshot API or peer recovery.
        for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {
     * @param deletionPolicy       decides which committed snapshots to keep
import org.opensearch.index.engine.exec.CatalogSnapshotDeletionPolicy;
        for (WriterFileSet wfs : mergedSegment.dfGroupedSearchableFiles().values()) {
                    expected = rows;
        }
            listener.beforeRefresh();
    }
     *   <li>If successful — registers the snapshot with the deletion policy via {@link IndexFileDeleter#onCommit}</li>
            // Remove file references since the snapshot will never be used
        closed.compareAndSet(false, true);
        return indexFileDeleter.getCleanUpsPerformed();
     * Advances the catalog generation
     */
        segmentList.subList(newSegIdx, segmentList.size()).clear();
            } catch (IOException e) {
     */
        ShardPath shardPath,
        // Primary may switch and come up with an older segment infos while replica may be ahead in
     * Asserts that the total row count across all formats in the merged segment does not
                listener.afterRefresh(true, newSnapshot);
     * On close:
    public synchronized void applyReplicationSnapshot(CatalogSnapshot incoming) throws IOException {
        // segment_ord → Lucene leaf index mapping asserts that the leaf's maxDoc
     *   <li>If not successful (failure) — releases the ref via {@link #decRefAndMaybeDelete}</li>
                            Locale.ROOT,
        try {
     * (e.g., to close readers).
    /**
    /**
        Exception firstException = null;
        indexFileDeleter.incrementCleanUpsPerformed();
import java.util.List;
        long lastWriterGeneration,
import org.opensearch.index.engine.exec.FilesListener;
    }
            );
                .collect(java.util.stream.Collectors.toList());
            try {
    public synchronized void updateLastCommitInfo(CommitResult commitResult) {
                }
        // Now notify listeners — file references are already registered, so even if a listener
        // equals the catalog segment's per-format row count). A mismatch here means
     * <p>
            throw new IllegalStateException("CatalogSnapshotManager is closed");
                .mapToLong(WriterFileSet::numRows)
        CatalogSnapshotDeletionPolicy deletionPolicy,
            latestCatalogSnapshot.getGeneration() + 1, //
    private static final Logger logger = LogManager.getLogger(CatalogSnapshotManager.class);
import org.opensearch.index.engine.dataformat.merge.OneMerge;
        this.deletionPolicy = deletionPolicy;
     * @param refreshedSegments the segments produced by the latest refresh
            }
     * reappears as a different value while an in-flight merge still holds the record it selected.
            : "every segment must have at least one format's files";
            newSnapshot.setReplicatingCommitData(latestCatalogSnapshot.getReplicatingCommitData());
                                    "Generation {} has conflicting files for format [{}]: existing={}, new={}",
        for (Segment source : sourceSegments) {
        if (mergedRows > sourceRows) {
    private final CatalogSnapshotDeletionPolicy deletionPolicy;
    // ---- Acquire path ----
     * that applies deletes rewrites an existing generation's live-docs file — so that generation
        }
    /**
                long rows = entry.getValue().numRows();
     * returns a non-null result, recording the segments file name, Lucene generation, and
     *
            }
    public long getUnreferencedFileCleanUpsPerformed() {
                                continue;
     * Updates the latest catalog snapshot with commit metadata from a successful flush.
        // Carry forward the primary's replicated SegmentInfos; same segment set, so it still applies.
     * the same {@link WriterFileSet#numRows()}.
        // the commit it manages.
     *
    private boolean assertSegmentGenerationFileConsistency(List<Segment> newSegments) {
                indexFileDeleter.revisitPolicy();
     * Checks that reused generations retain an overlapping file set. Live-doc updates may change
                }
     * Increments the merge failure cleanup counter.
    }
            + "]";
                latestCatalogSnapshot.getVersion() + 1,  // New changes so this version is changed.
 * path (acquireSnapshot) is safe for concurrent access via volatile reads and {@code tryIncRef}.</p>
     * should only become visible after readers are notified by the engine. Idempotent —
    }
                logger.debug("merge sources no longer in the catalog (dropped by a concurrent refresh): gen={}", absent);
        for (CatalogSnapshot cs : committedSnapshots) {
            } catch (IOException e) {
     * @return the newly created merged {@link Segment}
        if (closed.get()) {
import java.util.Collections;
        // This ensures that if addFileReferences fails, no listener has been told about
        // Release the manager's own reference to the old snapshot.
        assert assertSegmentGenerationFileConsistency(refreshedSegments)
            for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {
}
            } catch (IOException suppressed) {
/*
            }
     *
        if (writerFileSetMap.isEmpty()) {
        latestCatalogSnapshot = newSnapshot;
        return new GatedConditionalCloseable<>(snapshot, () -> {
        int newSegIdx = 0;
                            if (existingFiles.isEmpty() || newFiles.isEmpty() || Collections.disjoint(existingFiles, newFiles)) {
    /**
        }
     * @param writerFileSetMap the map of data formats to their corresponding writer file sets
        try {
                policyRef.close();
import org.apache.logging.log4j.Logger;
     *
        // Every WriterFileSet in every segment must have a positive row count
        this.snapshotSerializer = commitFileManager::serializeToCommitFormat;
                        // Live-doc updates may change files, but the sets must still overlap.
            + latestCatalogSnapshot.getId()
            if (entry.getValue() == null) {
 */
    }
                                                       // force flush cases
        long generation = writerFileSetMap.values().iterator().next().writerGeneration();
     * Returns the number of unreferenced file cleanup operations performed.
     * the snapshot as latest. Shared by commitNewSnapshot and applyReplicationSnapshot.
        latestCatalogSnapshot.setLastCommitInfo(
        DataformatAwareCatalogSnapshot newSnapshot = new DataformatAwareCatalogSnapshot(
     * Replaces the merged segments with the new merged segment and commits a new snapshot.
        long generation,
        for (Segment newSeg : newSegments) {
    /**
     */
        installSnapshot(newSnapshot);
        if (logger.isDebugEnabled()) {
            List<Long> absent = generationsToRemove.stream()
            // Construction failed (e.g., OOM) — notify listeners that the refresh did not produce a new snapshot
import java.util.ArrayList;
     * Replaces the current snapshot with one received from the primary via segment replication.
        // Check for null values (format participated but returned no result)
        }
            incoming.getVersion(), // Honor the version from incoming. As replication would check this for changes.
        );
                snapshot.markCommitted();
                try {
                }
            committedSnapshots,
    private void installSnapshot(DataformatAwareCatalogSnapshot newSnapshot) throws IOException {
                            }
            } else {
        // Cross-format per-segment row-count parity: within a single segment, every
     * twice is still rejected by the generation-collision check below.
                } catch (Exception suppressed) {
     * via writer generation) relies on that invariant to pick the right leaf. A mismatch
        List<CatalogSnapshotLifecycleListener> notified = new ArrayList<>();
        );
    }
        }
            }
        for (Segment seg : segments) {
    private final List<CatalogSnapshotLifecycleListener> snapshotListeners;
            throw new IllegalStateException(
    private void onSnapshotDeleted(CatalogSnapshot snapshot) {
            long expected = -1L;
            fileDeleter,
     * deletion policy triggers removal of a committed snapshot.
            throw new IllegalArgumentException("committedSnapshots must not be empty");
            assert segIdx >= newSegIdx;
        DataformatAwareCatalogSnapshot newSnapshot;
        // exactly the class of bug that silently produced different match/LIKE
