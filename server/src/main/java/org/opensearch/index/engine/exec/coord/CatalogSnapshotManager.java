     * Acquire a committed snapshot for _snapshot API or peer recovery.
        if (mergedRows > sourceRows) {
        // exactly the class of bug that silently produced different match/LIKE
     * that applies deletes rewrites an existing generation's live-docs file — so that generation  
            for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {
        DataformatAwareCatalogSnapshot newSnapshot;
                                logger.error(  
                snapshot.markCommitted();  
        // Register file references BEFORE notifying listeners and swapping the snapshot.
    public GatedCloseable<CatalogSnapshot> acquireCommittedSnapshot(boolean acquiringSafe) {
        List<CatalogSnapshotLifecycleListener> snapshotListeners,  
        // Generation, id and commit file details are local to the replica.
            } catch (IOException e) {
                listener.afterRefresh(true, newSnapshot);  
    }
     */  
            throw new IllegalArgumentException("writerFileSetMap must not be empty");  
     * @param writerFileSetMap the map of data formats to their corresponding writer file sets  
            try {
                    + " total rows but merged output has "
     * @param committedSnapshots   the committed snapshots, ordered oldest first; must not be empty
        return segmentToAdd;  
     * On close, the policy releases the hold and the deleter revisits for cleanup.  
     * <p>The multi-format segment model pairs one logical row set across formats — e.g.  
 * compatible open source license.
        return indexFileDeleter.getCleanUpsPerformed();
    public synchronized void commitNewSnapshot(List<Segment> refreshedSegments) throws IOException {
            latestCatalogSnapshot.getSegments(),  
        }
    private Segment getSegment(Map<DataFormat, WriterFileSet> writerFileSetMap) {
                .mapToLong(WriterFileSet::numRows)
     */
        List<Segment> segmentList = new ArrayList<>(latestCatalogSnapshot.getSegments());
        this.snapshotSerializer = commitFileManager::serializeToCommitFormat;
                try {
     * This is a convenience method for test code that cannot access the package-private  
        if (!inserted) {  
     * <p>A source generation may also be gone entirely: a refresh that deletes every document in a
        }
import org.opensearch.index.engine.dataformat.merge.OneMerge;
        // This ensures that if addFileReferences fails, no listener has been told about  
            commitResult.commitDataFormatVersion()
        // not, but only because all segments we merged became
        }
                            referenceFormat,
        // delete-bearing refresh, which is worth seeing when reasoning about merge throughput.
        } catch (Exception ex) {  
            .filter(s -> generationsToRemove.contains(s.generation()) == false)  
        // fails, the files are tracked and will be cleaned up when the snapshot is deleted.
import org.opensearch.common.concurrent.GatedCloseable;
    private void installSnapshot(DataformatAwareCatalogSnapshot newSnapshot) throws IOException {
import org.opensearch.common.concurrent.GatedConditionalCloseable;  
        // Not an error — see the method javadoc. Logged because it means this merge raced a
        // Carry forward the primary's replicated SegmentInfos; same segment set, so it still applies.
            for (CatalogSnapshotLifecycleListener listener : notified) {
        // Notify listeners about the committed snapshot so reader managers  
        if (closed.get()) {
import org.opensearch.index.engine.dataformat.MergeResult;  
     * from {@code match} vs {@code LIKE} over the same field.  
    private final CatalogSnapshotDeletionPolicy deletionPolicy;
        CatalogSnapshotDeletionPolicy deletionPolicy,  
     * Returns information about the safe commit from the underlying deletion policy.  
        verifyPerSegmentCrossFormatRowCountParity(refreshedSegments);  
            deletionPolicy,
     * @param snapshotListeners    listeners notified on snapshot deletion  
    /**  
     * twice is still rejected by the generation-collision check below.
                latestCatalogSnapshot.getLastCommitGeneration(),
        do {
        return snapshot;
    private final IndexFileDeleter indexFileDeleter;
     * a resend of the same (or older) generation is a no-op.
import java.util.Locale;  
        long generation,
                else firstException.addSuppressed(e);  
                policyRef.close();  
     */
     */  
     *
            : "refreshed segments contain duplicate generations";  
            throw new IllegalStateException(
     * Typically called after {@link org.opensearch.index.engine.exec.commit.Committer#listCommittedSnapshots()}
    public CatalogSnapshotManager(
     * Asserts that within each segment, every format's {@link WriterFileSet} reports  
    /**  
        long lastWriterGeneration,
            : "segment generation refers to an unrelated file set compared with a previous snapshot";
                    + inputRows
     *
     */
     * the merge. Deletes landing mid-merge are carried onto the merged segment by Lucene's
                    listener.afterRefresh(false, null);
     * (including any commit references) are released.  
     * Checks that reused generations retain an overlapping file set. Live-doc updates may change  
     * <p>
public class CatalogSnapshotManager implements Closeable {  
     * Creates a new CatalogSnapshot from refreshed segments, replacing the current latest.  
            listener.beforeRefresh();
        for (Segment newSeg : newSegments) {
        final CatalogSnapshot snapshot = acquireLatestSnapshot();  
            newSnapshot.setReplicatingCommitData(latestCatalogSnapshot.getReplicatingCommitData());
            commitResult.commitFileName(),  
                            Set<String> existingFiles = existingWfs.files();  
        // Merged segment generation must not collide with any segment that will be retained
    /**
 * <p>Tracks all live snapshots in a map keyed by generation. When a snapshot's reference count reaches
                if (!inserted) {
        });
    }
                newSegIdx++;  
        long version,
     * returns a non-null result, recording the segments file name, Lucene generation, and
            // Remove file references since the snapshot will never be used
     * @return a {@link GatedCloseable} wrapping the current {@link CatalogSnapshot}
                    );
     * @throws IllegalStateException if the manager or snapshot is already closed  
            generationsToRemove.add(source.generation());
     * The caller must call {@code markSuccess()} on the returned handle after a successful commit.
        DataformatAwareCatalogSnapshot newSnapshot = new DataformatAwareCatalogSnapshot(  
            } catch (IOException e) {
     */  
        // Compared against the sources as the merge read them, which is what produced the output.
     *
     *
                if (firstException == null) firstException = e;
            }
 * this file be licensed under the Apache-2.0 license or a
 */
            snapshot = latestCatalogSnapshot;
            + "] must be > previous ["
            // File reference registration failed — notify listeners that refresh did not complete
import org.opensearch.index.engine.exec.commit.Committer.CommitResult;  
                    if (existingSeg.generation() == newSeg.generation()) {
        for (CatalogSnapshot cs : committedSnapshots) {
     * exceed the total row count across all formats in the source segments. Catches bugs
     * Increments the merge failure cleanup counter.
    }  
        // deleted while we are merging, in which case it should  
                    inserted = true;
                    }
     * @param commitResult the result of the commit containing the segments_N filename, generation, and format version
     * the snapshot as latest. Shared by commitNewSnapshot and applyReplicationSnapshot.
        // the rest of the segments in list are duplicates, so don't remove from map, only list!
        }
                "Merged segment row count mismatch: input segments have "  
     * Removes the snapshot from the tracking map and notifies lifecycle listeners
     * where rows are duplicated during merge. Rows may be legitimately dropped when the
                        for (Map.Entry<String, WriterFileSet> entry : newSeg.dfGroupedSearchableFiles().entrySet()) {  
 * path (acquireSnapshot) is safe for concurrent access via volatile reads and {@code tryIncRef}.</p>  
            commitFileManager,
    }
            // so they can reset any state prepared in beforeRefresh
        for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {  
            }
        List<CatalogSnapshotLifecycleListener> notified = new ArrayList<>();  
        } catch (Exception e) {  
     * here means the writers dropped or duplicated rows against each other during a
                    + " rows"
     * by a {@link CatalogSnapshotManager} — its reference count is not tracked, and callers
    }
            List<Long> absent = generationsToRemove.stream()
    /**
import java.util.concurrent.atomic.AtomicBoolean;
     */
        }
        if (closed.get()) {  
     * Builds a {@link Segment} from a map of data format to writer file set entries.
    }  
     *   <li>If not successful (failure) — releases the ref via {@link #decRefAndMaybeDelete}</li>
                indexFileDeleter.onCommit(snapshot);
        // honor the associated invariants (e.g. increasing generaiton)  
        // New snapshot generation must be strictly greater than the previous  
        installSnapshot(newSnapshot);
            for (WriterFileSet wfs : seg.dfGroupedSearchableFiles().values()) {
        latestCatalogSnapshot = newSnapshot;
                firstException  
    private final Map<Long, CatalogSnapshot> catalogSnapshotMap = new ConcurrentHashMap<>();  
     *   <li>If successful — registers the snapshot with the deletion policy via {@link IndexFileDeleter#onCommit}</li>
        // only a merged count strictly greater than the source total is an invariant violation.  
     * via writer generation) relies on that invariant to pick the right leaf. A mismatch  
     * @param acquiringSafe if true, acquires the safe commit (for peer recovery);
    ) throws IOException {  
        Map<String, String> userData
            if (generationsToRemove.contains(currSegment.generation())) {
            incoming.getVersion(), // Honor the version from incoming. As replication would check this for changes.  
 *  
    private CatalogSnapshot acquireLatestSnapshot() {
        List<Segment> segments,  
    /**
                    + outputRows  
            for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {  
     * (e.g., to close readers).
    /**
            indexFileDeleter.addFileReferences(newSnapshot);  
            try {  
            // Notify already-notified listeners that the snapshot is being discarded.  
        }
    }  
        // Check for null values (format participated but returned no result)
            for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {  
     */
        for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {
        // Primary may switch and come up with an older segment infos while replica may be ahead in
        return segment.build();
                        // Live-doc updates may change files, but the sets must still overlap.
        long mergedRows = 0;  
     * should only become visible after readers are notified by the engine. Idempotent —
                segmentList.set(newSegIdx, currSegment);
     * Replaces the merged segments with the new merged segment and commits a new snapshot.
            throw new IllegalStateException("CatalogSnapshotManager is closed");  
                            if (existingWfs == null) {
    }
        // we insert it at the beginning if it should not be dropped:
        installSnapshot(newSnapshot);
        }
            shardPath,  
        DataformatAwareCatalogSnapshot oldSnapshot = latestCatalogSnapshot;
                .sum();  
        for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {
            // by the file deleter but was never made visible as latestCatalogSnapshot.
     *
            + "]";
                .filter(gen -> segmentList.stream().noneMatch(s -> s.generation() == gen))
        // are initialized on engine open.
    }  
     * Creates a new {@link DataformatAwareCatalogSnapshot} for use in tests.
            filesListeners,
        this.indexFileDeleter = new IndexFileDeleter(
                                    existingWfs.files(),
     * Acquires the current latest snapshot with an incremented reference count.
    public GatedConditionalCloseable<CatalogSnapshot> acquireSnapshotForCommit() {
    public GatedCloseable<CatalogSnapshot> acquireSnapshot() {
                            }
        assert refreshedSegments.stream().map(Segment::generation).distinct().count() == refreshedSegments.size()
     * <p>  
    public synchronized Segment applyMergeResults(MergeResult mergeResult, OneMerge oneMerge) throws IOException {
     * Replica-only: does not fire beforeRefresh/afterRefresh since the catalog snapshot  
     * <p>  
        // be the case that the new segment is also all deleted,
import java.io.IOException;
    /**
                            rows
 *
            latestCatalogSnapshot.getCommitDataFormatVersion()  
     * generation drops it (see {@code RefreshResult.droppedGenerations}). Neither case invalidates  
    }
     * reappears as a different value while an in-flight merge still holds the record it selected.
    /**
    /**
        if (segmentList.stream()
            throw new IllegalStateException("CatalogSnapshotManager is closed");
     * data format version so that replicas and recovery can identify the commit point.  
                .collect(java.util.stream.Collectors.toList());
                                continue;
                                );  
     * Validates snapshot invariants, registers file references, notifies listeners, and swaps
                                                       // force flush cases
        // counts at query time.
        for (int segIdx = 0, cnt = segmentList.size(); segIdx < cnt; segIdx++) {
            + "]";  
        }
            );
            : "every segment must have at least one format's files";
                latestCatalogSnapshot.getGeneration() + 1,
    private void onSnapshotDeleted(CatalogSnapshot snapshot) {
        GatedCloseable<CatalogSnapshot> policyRef = deletionPolicy.acquireCommittedSnapshot(acquiringSafe);  
        boolean inserted = false;
        }  
        }
                                    "Generation {} has conflicting files for format [{}]: existing={}, new={}",
package org.opensearch.index.engine.exec.coord;
        // Every WriterFileSet in every segment must have a positive row count  
        assert newSnapshot.getGeneration() > latestCatalogSnapshot.getGeneration() : "new snapshot generation ["
        if (committedSnapshots.isEmpty()) {
     * @param commitFileManager    manager for commit-level files (e.g., segments_N), or null if not needed
    public synchronized void applyReplicationSnapshot(CatalogSnapshot incoming) throws IOException {
     * {@link DataformatAwareCatalogSnapshot} constructor. The returned snapshot is NOT managed
                }  
    }
            latestCatalogSnapshot.getUserData(),
                long rows = entry.getValue().numRows();
import org.opensearch.common.CheckedFunction;  
     * Returns the number of unreferenced file cleanup operations performed.
            + "] must be > previous ["  
        return snapshotSerializer.apply(catalogSnapshot);  
    /**  
        for (Segment seg : segments) {  
        for (Map.Entry<DataFormat, WriterFileSet> entry : writerFileSetMap.entrySet()) {
        for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {  
        List<CatalogSnapshot> committedSnapshots,
        if (writerFileSetMap.isEmpty()) {
        }
    public synchronized void bumpGeneration() throws IOException {
 * are cleaned up through the deleter.</p>  
    }  
     *                      otherwise the last commit (for _snapshot API)  
     * merger compacts deleted rows (see {@code MergeInput#liveDocs}).  
        }
                latestCatalogSnapshot.getId() + 1,
        assert refreshedSegments.stream().flatMap(s -> s.dfGroupedSearchableFiles().values().stream()).allMatch(wfs -> wfs.numRows() > 0)
     * Generations come from a single monotonic counter and are never reused, so the number alone
        }  
        );  
        this.latestCatalogSnapshot = (DataformatAwareCatalogSnapshot) committedSnapshots.getLast();  
    /**  
        newSnapshot.setReplicatingCommitData(latestCatalogSnapshot.getReplicatingCommitData());  
                try {
     * {@code Segment} is a record whose {@code equals} covers its whole file set, and a refresh
                try {
            latestCatalogSnapshot.getGeneration() + 1, // This is for commit generation tracking. So this should increase as well. Handles  
        return new GatedCloseable<>(snapshot, () -> decRefAndMaybeDelete(snapshot));
    private void decRefAndMaybeDelete(CatalogSnapshot snapshot) {
                indexFileDeleter.revisitPolicy();
    // ---- Refresh path ----  
     * @param shardPath            for orphan cleanup on init, or null if not needed
                latestCatalogSnapshot.getLastWriterGeneration() + 1,
    // ---- Internal ----  
        // Now notify listeners — file references are already registered, so even if a listener
            }  
            }
            latestCatalogSnapshot.getId() + 1, // Increase this as this is always unique
                latestCatalogSnapshot.getCommitDataFormatVersion()  
        }
    }
            }
            long outputRows = segmentToAdd.dfGroupedSearchableFiles().values().stream().mapToLong(WriterFileSet::numRows).sum();
                            WriterFileSet existingWfs = existingSeg.dfGroupedSearchableFiles().get(entry.getKey());
                                    entry.getKey(),  
     * Acquires the current latest snapshot for committing (flushing).
        return new GatedCloseable<>(policyRef.get(), () -> {
    }  
    /**  
                            expected,  
                } catch (Exception suppressed) {  
                latestCatalogSnapshot.getUserData(),  
 * Manages the lifecycle of {@link CatalogSnapshot} instances for the composite multi-format engine
     * @param fileDeleter          per-format deleters for actual file deletion
     */  
            commitResult.generation(),
            // Construction failed (e.g., OOM) — notify listeners that the refresh did not produce a new snapshot
    private static final Logger logger = LogManager.getLogger(CatalogSnapshotManager.class);
        Segment.Builder segment = Segment.builder(generation);  
            listener.afterRefresh(true, latestCatalogSnapshot);  
     */
                    throw new IllegalStateException(  
        return new GatedConditionalCloseable<>(snapshot, () -> {
     * @param oneMerge    the merge specification identifying which segments were merged
        }
                "Merged segment generation [" + segmentToAdd.generation() + "] collides with a retained segment generation"  
            } else {
                throw new IllegalStateException("CatalogSnapshotManager is closed");  
                }
import org.opensearch.common.annotation.ExperimentalApi;
    ) {  
                    listener.afterRefresh(false, null);
            }
                throw new RuntimeException("Failed to release committed snapshot [gen=" + policyRef.get().getGeneration() + "]", e);  
                ex.addSuppressed(suppressed);  
        // equals the catalog segment's per-format row count). A mismatch here means
        // the new snapshot and no state has been mutated.
    private final AtomicBoolean closed = new AtomicBoolean(false);
            return false;  
    }
                        )  
            throw new IllegalArgumentException("committedSnapshots must not be empty");
        }
        commitNewSnapshot(segmentList);
            }
     */
        closed.compareAndSet(false, true);  
     * @param deletionPolicy       decides which committed snapshots to keep  
        // Cross-format per-segment row-count parity: within a single segment, every
        );
        }  
            Segment currSegment = segmentList.get(segIdx);  
                    ex.addSuppressed(suppressed);
    /**
        assert refreshedSegments.stream().allMatch(s -> s.dfGroupedSearchableFiles().isEmpty() == false)  
import java.util.List;
            try {
import java.io.Closeable;  
 * zero (via {@link #decRefAndMaybeDelete}), it is automatically removed from the map and its files
                                continue;  
            }
        // the commit it manages.
     * identifies a source unambiguously.  
            latestCatalogSnapshot.getLastCommitGeneration(),
            throw e;
            logger.error("Row count mismatch: source segments have {} rows but merged segment has {} rows", sourceRows, mergedRows);
        Set<Segment> sourceSegments = new HashSet<>(oneMerge.getSegmentsToMerge());
    public static CatalogSnapshot createInitialSnapshot(
            throw new IllegalStateException("CatalogSnapshotManager is closed");  
        if (closed.get()) {  
        }  
     * ordinal translation on the query side (parquet segment_ord → Lucene leaf index
            );
     * the old snapshot — the snapshot will only be fully cleaned up when all references
            throw new IllegalStateException("CatalogSnapshotManager is closed");
     */  
        ShardPath shardPath,
        indexFileDeleter.decRefAndMaybeDelete(snapshot);  
        Set<Long> generationsToRemove = new HashSet<>();
        installSnapshot(newSnapshot);
        }  
                "Failed to notify listener of snapshot deletion [gen=" + snapshot.getGeneration() + "]",
                            if (existingFiles.isEmpty() && newFiles.isEmpty()) {
                listener.onDeleted(snapshot);  
     * The snapshot won't be deleted until the returned {@link GatedCloseable} is closed.
    }
    public long getUnreferencedFileCleanUpsPerformed() {  
     * @return the newly created merged {@link Segment}
        assert assertSegmentGenerationFileConsistency(refreshedSegments)
    }
     * (via {@link #decRefAndMaybeDelete}) or from {@link IndexFileDeleter} when the
        }
     */  
        CommitFileManager commitFileManager
     */  
     * single refresh — which produces silent correctness issues like different counts
                .sorted()  
            // A listener failed after file references were registered. The snapshot is tracked
        // Row count conservation: merged output must not exceed sum of input rows.
     */
    public byte[] serializeToCommitFormat(CatalogSnapshot catalogSnapshot) throws IOException {
            );
                notified.add(listener);
     * {@link org.opensearch.index.engine.exec.CommitFileManager#serializeToCommitFormat}.  
        if (closed.get()) {
import org.apache.logging.log4j.Logger;
        // Either we found place to insert segment, or, we did
        }
            + latestCatalogSnapshot.getId()
        newSnapshot.setReplicatingCommitData(((DataformatAwareCatalogSnapshot) incoming).getReplicatingCommitData());
        }
            + newSnapshot.getId()  
        }  
            }
        return true;
        // The snapshot won't be deleted if the commit path still holds a reference.
        }, () -> decRefAndMaybeDelete(snapshot));
            + latestCatalogSnapshot.getGeneration()
    }  
            }  
                            seg.generation(),
        decRefAndMaybeDelete(oldSnapshot);
    /**
            }  
     * so the output already reflects them. Both cases therefore apply normally; a merge applied  
        for (WriterFileSet wfs : mergedSegment.dfGroupedSearchableFiles().values()) {
                            "Per-segment row count mismatch at generation %s: format [%s] has %s rows but format [%s] has %s rows",  
            long inputRows = sourceSegments.stream()  
            for (Map.Entry<String, WriterFileSet> entry : seg.dfGroupedSearchableFiles().entrySet()) {  
 * and coordinates file deletion through an internally owned {@link IndexFileDeleter}.
                                return false;
    }  
                        String.format(
            latestCatalogSnapshot.getId() + 1,  // This is unique for each catalog snapshot managed by this manager.
@ExperimentalApi
     * @return a {@link GatedConditionalCloseable} wrapping the current {@link CatalogSnapshot}
     * discovers the surviving commits on startup. For fresh indices, the caller creates a single initial
        }
                latestCatalogSnapshot.getLastCommitFileName(),
    public synchronized void updateLastCommitInfo(CommitResult commitResult) {
                    expected = rows;  
        catalogSnapshotMap.put(newSnapshot.getGeneration(), newSnapshot);
            .anyMatch(s -> s.generation() == segmentToAdd.generation())) {
        Map<String, FilesListener> filesListeners,
        if (logger.isDebugEnabled()) {  
        catalogSnapshotMap.remove(snapshot.getGeneration());
    }
     */  
            throw new IllegalStateException(
                            if (existingFiles.isEmpty() || newFiles.isEmpty() || Collections.disjoint(existingFiles, newFiles)) {
        // segment_ord → Lucene leaf index mapping asserts that the leaf's maxDoc
     * Updates the latest catalog snapshot with commit metadata from a successful flush.  
        // Compaction with deletes may drop rows, so the merged total can be lower —
import org.opensearch.index.engine.exec.Segment;
     * </ul>  
        this.deletionPolicy = deletionPolicy;
import org.opensearch.index.engine.exec.WriterFileSet;
import org.opensearch.index.engine.exec.CatalogSnapshotLifecycleListener;  
import org.opensearch.index.engine.SafeCommitInfo;
            try {
/*  
     * On close:
        // Release the manager's own reference to the old snapshot.  
            committedSnapshots,
                throw new IllegalStateException("WriterFileSet is null for format [" + entry.getKey().name() + "] — merge was incomplete");
            listener.beforeRefresh();
                if (expected == -1L) {
    private boolean assertSegmentGenerationFileConsistency(List<Segment> newSegments) {  
            this::onSnapshotDeleted
        logger.debug("New Catalog Snapshot created: {}", latestCatalogSnapshot);
            incoming.getSegments(),
                                    newSeg.generation(),
                    e.addSuppressed(suppressed);
 *
     * Read-path only — the returned {@link GatedCloseable}'s close will decRef the snapshot.  
    // ---- Snapshot protection for _snapshot API / peer recovery ----
        this.snapshotListeners = snapshotListeners;
        }
            latestCatalogSnapshot.getCommitDataFormatVersion()
     * <ul>  
            latestCatalogSnapshot.getLastWriterGeneration() + 1, // Not needed, can be removed.
    /**
        } catch (IOException e) {
        for (Map.Entry<DataFormat, WriterFileSet> entry : writerFileSetMap.entrySet()) {  
            incoming.getUserData(),  
     * @throws IOException if committing the new snapshot fails  
import java.util.concurrent.ConcurrentHashMap;  
        try {
     *  
            mergedRows += wfs.numRows();
            latestCatalogSnapshot.getLastWriterGeneration() + 1,
import java.util.ArrayList;
                } catch (Exception suppressed) {
    /**
     * Called by the engine after {@link org.opensearch.index.engine.exec.commit.Committer#commit}
        }
     *
    private boolean assertRowCountConservation(Set<Segment> sourceSegments, Segment mergedSegment) {
        if (!assertRowCountConservation(sourceSegments, segmentToAdd)) {
                throw new RuntimeException("Failed to register commit [gen=" + snapshot.getGeneration() + "]", e);  
            }  
    /**
                            Locale.ROOT,
     *
                } else if (rows != expected) {
        // that downstream segment-ord translation relies on (e.g. Rust's parquet  
        for (Segment source : sourceSegments) {  
            throw new RuntimeException(
     * <p>Sources are identified by <em>generation</em>, never by {@link Segment} identity. A
            }
     * Called when a CatalogSnapshot's refCount reaches 0 — either from this class  
            latestCatalogSnapshot.getVersion(), // This increases if there is an actual change in the snapshot.
            segment.addSearchableFiles(entry.getKey(), entry.getValue());
        // No duplicate generations within the same snapshot
            segmentList.add(0, segmentToAdd);
     * @param filesListeners       per-format listeners notified on file add/delete
     * Closes this manager. Idempotent. DecRefs the current snapshot and cleans up if count reaches zero.
     */
            long expected = -1L;
        );  
            for (CatalogSnapshot existing : catalogSnapshotMap.values()) {
        // format's WriterFileSet must report the same row count. This is the invariant
     *
        // We should honor the state management within CatalogSnapshotManager to ensure these values
     * @return the constructed segment
                            }
        try {
        if (closed.get()) {
                    segmentList.set(segIdx, segmentToAdd);  
            latestCatalogSnapshot.getLastCommitFileName(),  
    /**
    private final CheckedFunction<CatalogSnapshot, byte[], IOException> snapshotSerializer;
        return true;
import java.util.Map;
            latestCatalogSnapshot.getGeneration() + 1, //
            + newSnapshot.getGeneration()
     * @throws IllegalStateException if the manager or snapshot is already closed  
        }
            }
                                    entry.getValue().files()
        long sourceRows = 0;  
                sourceRows += wfs.numRows();  
     * Advances the catalog generation
            listener.beforeRefresh();
                } catch (Exception suppressed) {  
        }
            );
import org.opensearch.index.engine.exec.CommitFileManager;
     * Replaces the current snapshot with one received from the primary via segment replication.
            } catch (IOException e) {
     */
     * {@code commitMerge}, and its {@code .liv} is flushed before the merged file set is recorded,
            throw ex;
}  
        latestCatalogSnapshot.setLastCommitInfo(
     *
     *
        DataformatAwareCatalogSnapshot newSnapshot = new DataformatAwareCatalogSnapshot(
     * @param mergeResult the result of the merge containing the merged writer file set  
    }
    // ---- Acquire path ----
                        }  
    private final List<CatalogSnapshotLifecycleListener> snapshotListeners;  
        // New snapshot ID must be strictly greater than the previous
        Segment segmentToAdd = getSegment(mergeResult.getMergedWriterFileSet());  
        }
                }
        // Commit new catalog snapshot
 * The OpenSearch Contributors require contributions made to  
            newSnapshot = new DataformatAwareCatalogSnapshot(  
            if (closed.get()) {
        assert newSnapshot.getId() > latestCatalogSnapshot.getId() : "new snapshot ID ["
            assert segIdx >= newSegIdx;
        long id,  
    public void incrementUnreferencedFileCleanUps() {
    }
        return deletionPolicy.getSafeCommitInfo();  
    }
                }  
                logger.debug("merge sources no longer in the catalog (dropped by a concurrent refresh): gen={}", absent);  
            } catch (IOException suppressed) {
import org.opensearch.index.engine.exec.CatalogSnapshotDeletionPolicy;
    /**
import org.opensearch.index.engine.exec.FileDeleter;
            throw new IllegalStateException("CatalogSnapshotManager is closed");  
     * snapshot and passes it as a singleton list.  
     * the same {@link WriterFileSet#numRows()}.
/**  
        final CatalogSnapshot snapshot = acquireLatestSnapshot();  
    public void close() {
                    listener.onDeleted(newSnapshot);  
        for (Segment seg : sourceSegments) {
        Exception firstException = null;  
 * SPDX-License-Identifier: Apache-2.0
        segmentList.subList(newSegIdx, segmentList.size()).clear();
                indexFileDeleter.removeFileReferences(newSnapshot);
                }
        // one of the writers dropped or duplicated rows during a single refresh —  
     * Constructs a new CatalogSnapshotManager from committed snapshots.
        for (CatalogSnapshotLifecycleListener listener : snapshotListeners) {  
    private void verifyPerSegmentCrossFormatRowCountParity(List<Segment> segments) {
     */  
        if (firstException != null) {  
            fileDeleter,  
            throw new RuntimeException("Failed to add file references for snapshot [gen=" + newSnapshot.getGeneration() + "]", e);
import java.util.HashSet;
    @Override
     * @throws IllegalArgumentException if the map is empty
            latestCatalogSnapshot.getLastCommitFileName(),
import org.opensearch.index.engine.exec.FilesListener;  
            }  
        CatalogSnapshot snapshot;  
            catalogSnapshotMap.put(cs.getId(), cs);
                                // New format for this generation; nothing to compare.  
                    newSegIdx++;
    private volatile DataformatAwareCatalogSnapshot latestCatalogSnapshot;
        int newSegIdx = 0;  
                            Set<String> newFiles = entry.getValue().files();
            if (absent.isEmpty() == false) {
     * Notifies the IndexFileDeleter of new files. Releases the manager's own reference to
        try {
     */
                }
        FileDeleter fileDeleter,
        long generation = writerFileSetMap.values().iterator().next().writerGeneration();
    public SafeCommitInfo getSafeCommitInfo() {
     * deletion policy triggers removal of a committed snapshot.
                            }
     * <p>  
     * Asserts that the total row count across all formats in the merged segment does not  
     * must not rely on ref-counting semantics.  
            if (entry.getValue() == null) {
            : "every WriterFileSet must have a positive row count";
     * @param refreshedSegments the segments produced by the latest refresh
     */  
import java.util.Set;
            String referenceFormat = null;
import java.util.Collections;  
                .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
                refreshedSegments,
                            entry.getKey(),
                    e.addSuppressed(suppressed);
    /**
import org.opensearch.index.engine.dataformat.DataFormat;
     * file names, but disjoint sets indicate generation reuse for unrelated data.
     * Serializes the given {@link CatalogSnapshot} using the registered
                    referenceFormat = entry.getKey();
     * a parquet file and a Lucene leaf that both represent the same 1000 rows. Segment
        } while (!snapshot.tryIncRef());  
            latestCatalogSnapshot.getLastCommitGeneration(),
        );  
 */  
        }
     * Applies the results of a completed merge to the latest catalog snapshot.
                latestCatalogSnapshot.getVersion() + 1,  // New changes so this version is changed.  
import org.apache.logging.log4j.LogManager;
        return new DataformatAwareCatalogSnapshot(id, generation, version, segments, lastWriterGeneration, userData);
        // Every segment must have at least one format with files
import org.opensearch.index.shard.ShardPath;
 * <p>The write path (commit) is single-threaded (refresh is serialized per shard), while the read
        indexFileDeleter.incrementCleanUpsPerformed();
                for (Segment existingSeg : existing.getSegments()) {  
    /**  
