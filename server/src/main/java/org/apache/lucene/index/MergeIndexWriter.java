import org.opensearch.common.SuppressForbidden;  
     * Returns the prepared merge for {@code mergeGeneration} if one exists, removing it from
                // MergeAbortedException when merge.isExternal, and we set isExternal=false above,
     *  
     *                        by {@link #takePreparedMerge} (in which case {@code mergeMiddle}
 * {@link IndexWriterConfig} (see {@code LuceneCommitter}). The warmer runs between
                }
     *   <li>mergeMiddle — reads sources via wrapForMerge, applies IndexSort via MultiSorter,
            } catch (MergePolicy.MergeAbortedException expected) {
            Field field = IndexWriter.class.getDeclaredField("segmentInfos");
 * the refresh lock, and only the short {@code commitMerge} window is serialized against
     *   <li>commitMerge — removes old segments from live list, decrements file references</li>  
                oneMerge.maxNumSegments = -1;
            oneMerge.isExternal = false;
     * {@code oneMerge.getMergeReader().get(i).hardLiveDocs} to build a bitmap that matches
    }
                    });
     * a file set without {@code .liv}; later when a flush triggers the {@code .liv}
     * segments by identity; {@code cloneSegmentInfos()} deep-clones and cannot be used.
 * refreshes.
     * any abort-path failure is suppressed.
 * and the partially-written merged segment is cleaned up — providing a safe rollback mechanism.
        try {  
        // delete packets covering source segments, _mergeInit creates the output SegmentInfo.
        try {
                oneMerge.isExternal = false;
 *
                synchronized (this) {  
     * {@link SegmentCommitInfo} references (not clones). Synchronized because Lucene mutates the  
            }
     * the internal map. Returns {@code null} if no merge was prepared (or if it has already
     * {@link #prepareMerge} and the call to {@link #executeMerge} that would have consumed
     * that were opened before the failure get closed, their file refs decremented, and
        }
     * exactly what {@code mergeMiddle} will use for physical drops.
            oneMerge.initMergeReaders(sci -> {  
     * @param mergeGeneration the writer generation for the merged output segment
 * file cleanup via {@code IndexFileDeleter}. If the merge fails, old segments are preserved
        } catch (NoSuchFieldException e) {
        ensureOpen(false);
     * Lucene's standard abort path ({@code setAborted} then {@code merge}) so any readers
     */
 * the primary-format merger must match what Lucene will physically drop in {@code mergeMiddle}.
        }
            oneMerge.registerDone = true;
        rld.writeLiveDocs(getDirectory());  
     * Reflective handle to {@link IndexWriter}'s private live {@code segmentInfos}. The live
     * {@code carryOverHardDeletes} produced new dead bits on the merged segment, so
     * <p>If the merge fails at any point, old segments are preserved and the partially-written
     *  
     *   <li>mergeInit — creates output segment info, increments file references</li>  
import org.apache.lucene.store.Directory;
     * the same generation; it picks up the prepared merge from an internal map and runs the
    public void executeMerge(MergePolicy.OneMerge oneMerge, long mergeGeneration) throws IOException {
                merge(oneMerge);
            // readers we managed to open, decRefs their files (balancing our per-reader incRef),
        prepared.setAborted();
     * underlying list only under the writer monitor; the returned copy is safe to iterate without
 * bitmap. The subsequent call to {@link #executeMerge(MergePolicy.OneMerge, long)} reuses the
            throw new ExceptionInInitializerError(e);  
     * {@code "Catalog segment ... has no matching Lucene leaf"} on the next refresh.  
import org.apache.lucene.store.IOContext;
 *  
import java.util.Map;
        merge(oneMerge);
     *
    /**  
     * must invoke {@link #abortPreparedMerge(long)} to release reader-pool and deleter refs.
        // merge() must be called without holding the lock — mergeInit asserts !Thread.holdsLock(this).  
        }  
 * <p>The internal merge path handles the full segment lifecycle including reference-counted  
            // Currently unreachable — see the matching catch in prepareMerge for why it is kept.
            // and clears the setIsMerging flags. Any cleanup failure is suppressed into the  
        // mergeInit asserts !Thread.holdsLock(this); waitApplyForMerge resolves any pending  
    }  
    public void abortPreparedMerge(long mergeGeneration) throws IOException {
                        perReader.add(mr.reader.getSegmentInfo());
     *  
            + mergeGeneration
 * package-private fields on {@link MergePolicy.OneMerge} required for merge registration.
     * see on subsequent refresh.
     * <p>Without this, the merged segment's {@code SegmentCommitInfo} reports
     */
     * <p>After this returns, callers can read the frozen snapshot through  
     *       writes merged segment</li>
                    // Per-reader incRef matches what Lucene's own mergeMiddle does. The matching
    }
     * {@link MergePolicy.MergeAbortedException}, which {@code IndexWriter#handleMergeException}
package org.apache.lucene.index;
    public void prepareMerge(PreparableOneMerge oneMerge, long mergeGeneration) throws IOException {
     *                        coordination key for {@link #executeMerge} and
import java.util.List;
     * the prepared state.  
    public PreparableOneMerge takePreparedMerge(long mergeGeneration) {
                    // incRef'd, only opened readers get decRef'd.
        }
     * <p>Marks the prepared merge as aborted and invokes {@link IndexWriter#merge}; the
 * assertion in {@code wrapForMerge}, since pluggable data format merges run on the  
     * {@code decRef} happens through Lucene's normal {@code closeMergeReaders} cleanup once  
 * <p>This class is placed in the {@code org.apache.lucene.index} package to access
     * Aborts a prepared merge and releases its reader-pool and deleter references.  
                        incRefDeleter(perReader);  
 * prepared merge object so {@code mergeMiddle} proceeds with the same snapshot. Callers that  
            // checkAborted and the surrounding finally runs closeMergeReaders, which closes any
     * @param mergeGeneration the writer generation for the merged output segment; used as the
     * <p>Refresh-lock coordination is handled by the {@code MergedSegmentWarmer} installed on
     * already serializes racing writers on the per-segment lock (same pattern as
        }  
            try {
    public MergeIndexWriter(Directory d, IndexWriterConfig conf) throws IOException {  
    /**
            return List.copyOf(segmentInfos.asList());
import java.lang.reflect.Field;  
    @SuppressForbidden(reason = "Need the live SegmentInfos reference for identity-based merge registration; cloneSegmentInfos() deep-clones")
 * monitor is <em>not</em> held, and acquires the engine's refresh lock. This establishes the  
import java.io.IOException;
    protected void mergeSuccess(MergePolicy.OneMerge merge) {
                rld.setIsMerging();
        // TODO update this for lucene as a primary engine  
    }
    public void flushLiveDocsForMergedSegment(SegmentCommitInfo mergedInfo) throws IOException {
     * releases the reader-pool and deleter references that {@link #prepareMerge} took.  
 *
        try {
     * been consumed). The caller is responsible for invoking {@link #executeMerge} with the  
        }
}
 * used by the engine's refresh path (which takes the refresh lock before calling
 * <h2>Coordination with engine refreshes</h2>  
 * @opensearch.experimental  
     * Callers must invoke this if the parquet (primary) phase fails between
     * returned OneMerge — its reader-pool and deleter references must be released by the
 *
 * path for use by the pluggable data format merge infrastructure.
     * disk as a {@code .liv} file. Required after a merge whose
     * inner {@code mergeMiddle.checkAborted()} fast-fails with a  
            throw new IOException("Failed to access IndexWriter segmentInfos via reflection", e);
        assert preparedMerges.containsKey(mergeGeneration) == false : "prepareMerge invoked for generation "  
import java.util.concurrent.ConcurrentHashMap;  
                // so merge() returns normally after swallowing it. Kept deliberately because Lucene
     *                        {@code mergeMiddle} captures its own snapshot inline).
    /**
 * engine's own merge thread pool rather than Lucene's {@code MergeThread}.
                    // accounting (not bulk incRefDeleter) means partial-failure cleanup via  
        boolean alreadyRegistered = oneMerge instanceof PreparableOneMerge p && p.readersInitialized();  
     * swallows for non-external merges, while the surrounding finally block in {@code merge()}
     * cannot stall a concurrent refresh or flush; {@code ReadersAndUpdates#writeLiveDocs}  
        // matches the refresh path's lock order (refreshLock → IW monitor) and avoids any inversion.  
     * Files referenced by each opened reader are pinned via the same per-reader  
            return;
    }  
            oneMerge.mergeGen = mergeGeneration;
 * <p>This class itself does not take any engine-level locks. Coordination with the engine's
        if (alreadyRegistered == false) {
     * <ol>
            return;
            + " that already has a prepared merge";
    /**  
     * <p>{@link #executeMerge(MergePolicy.OneMerge, long)} must subsequently be invoked with
     * validate against concurrent merges on the same segments.
     * their {@code setIsMerging} flags cleared. Only the original exception is rethrown;  
        } catch (MergePolicy.MergeAbortedException expected) {
    }
 * {@code mergeInit} and then explicitly populates the {@link PreparableOneMerge}'s merge readers
        super.mergeSuccess(merge);
 *
                // this catch keeps the abort path quiet. Cleanup ran in merge()'s finally either way.
 * compatible open source license.
     * the catalog publish that follows sees the {@code .liv} file in  
     *  
     *
 */  
 * {@code mergeMiddle} and {@code commitMerge}, at a point where the {@link IndexWriter}
                        SegmentInfos perReader = new SegmentInfos(getConfig().getIndexCreatedVersionMajor());
     * @param oneMerge        the merge to prepare  
        return preparedMerges.remove(mergeGeneration);
        // which fires between mergeMiddle and commitMerge while the IW monitor is not held. This
     * @throws IOException if the merge fails  
            }
 *  
     * Executes a merge using Lucene's internal merge path which handles:
     *                        {@link #abortPreparedMerge}  
     * write, the leaf has one extra file and the catalog/leaf mismatch surfaces as
     * triggers a copy-on-write flip on each source segment's live docs, freezing the snapshot.
     */
     * {@link SegmentCommitInfo#files()} and stays consistent with what readers will
 *
     *   <li>mergeFinish — cleans up merge tracking state</li>
/**
        }
            } catch (Throwable suppress) {
     * rest of the merge. If the parquet phase fails before {@code executeMerge}, the caller  
                t.addSuppressed(suppress);  
 *
     * {@link IndexWriter#numDeletedDocs(SegmentCommitInfo)}).
     * <p>If this method itself fails partway through {@code initMergeReaders}, it walks  
     */
     * Forces any in-memory live-docs deletes for the given segment to be persisted to  
    @Override
 * The OpenSearch Contributors require contributions made to  
        if (prepared == null) {
            // original throwable.
        mergeInit(oneMerge);
 * SPDX-License-Identifier: Apache-2.0
        if (rld == null) {  
        // Refresh-lock acquisition happens inside the MergedSegmentWarmer configured on this writer,
 */
                    return rld.getReaderForMerge(ctx, mr -> {  
            synchronized (this) {
    /**  
 * Without coordination, the snapshot is captured later than the primary's bitmap and a delete
            SegmentInfos segmentInfos = (SegmentInfos) SEGMENT_INFOS_FIELD.get(this);
                oneMerge.mergeGen = mergeGeneration;  
     * gap between this call and the eventual {@link #executeMerge} call. The matching
 *  
/*  
    /**
        } catch (IllegalAccessException e) {  
 * {@code MergeReader.hardLiveDocs} can then be read by callers to construct the cross-format
                // Currently unreachable: IndexWriter#handleMergeException only rethrows  
     * this writer's {@link IndexWriterConfig} — see the class Javadoc for details.
        super(d, conf);
     *  
        PreparableOneMerge prepared = preparedMerges.remove(mergeGeneration);  
        }  
     * Prepares a merge by running {@code mergeInit} and populating its merge readers — which
    private final Map<Long, PreparableOneMerge> preparedMerges = new ConcurrentHashMap<>();
 * (which causes a copy-on-write flip on each source segment's live docs). The frozen  
        // https://github.com/opensearch-project/OpenSearch/issues/21505
     * {@code hasDeletions() == false} immediately after merge (because
            // Ride Lucene's own abort path: setAborted + merge fast-fails inside mergeMiddle's  
                    // Lucene's standard abort path balances correctly: only opened readers were
    }
     *                        reuses the captured snapshot) or a fresh OneMerge (in which case  
 * ordering {@code refreshLock → IndexWriter monitor} on the merge thread, matching the order
     * {@code deleter.incRef} hook Lucene's own {@code mergeMiddle} uses, so they survive the
        synchronized (this) {  
     * {@code ReaderPool} writes live-docs lazily on flush), so the catalog records  
                // carries a TODO to "just throw all the time" in handleMergeException; if that lands,  
     *  
     * </ol>
     * merged segment is cleaned up by IndexFileDeleter's reference counting.
     *
     *
 * <h2>Two-phase merge for cross-format snapshot consistency</h2>
     */  
     */  
            return field;
 * {@link SerialMergeScheduler} to avoid the {@link ConcurrentMergeScheduler} thread
public class MergeIndexWriter extends IndexWriter {
        ReadersAndUpdates rld = getPooledInstance(mergedInfo, false);
     * Returns a point-in-time copy of the writer's current segment list holding the live
    private static Field initSegmentInfosField() {  
        try {
     */  
 * do not need the two-phase split simply call {@link #executeMerge}.
                ReadersAndUpdates rld = getPooledInstance(sci, true);
 * {@code addIndexes}). The expensive {@code mergeMiddle} phase therefore runs without holding  
 * refresh path is layered on top by installing a {@code MergedSegmentWarmer} on the  
    public synchronized List<SegmentCommitInfo> liveSegmentCommitInfos() throws IOException {
            throw t;
    }  
            merge(prepared);  
 * <p>For composite engines where Lucene is a secondary format, the live-docs snapshot used by  
                    // decRef fires from closeMergeReaders during executeMerge cleanup. Per-reader
     * a lock but may grow stale — merge registration re-validates against the live list.
            field.setAccessible(true);  
 * <p>The {@link IndexWriterConfig} used to construct this writer must set a
 * this file be licensed under the Apache-2.0 license or a
 * arriving in between produces a row-count mismatch across formats. To avoid this,  
    /**
     * {@link SegmentCommitInfo} references are required because merge registration matches  
     * <p>Duplicate segment prevention is handled by the caller; this method does not
     * <p>Deliberately not synchronized on the writer monitor so the {@code .liv} disk write
 * {@link #prepareMerge(PreparableOneMerge, long)} is invoked first — it runs Lucene's
            oneMerge.maxNumSegments = -1;  
     * surrounding merge cleanup.
 * An {@link IndexWriter} subclass that exposes Lucene's internal {@code merge(OneMerge)}  
     * the merge runs (success or failure).
     *
        } catch (Throwable t) {
            preparedMerges.put(mergeGeneration, oneMerge);
     * @param oneMerge        the merge to execute. May be a {@link PreparableOneMerge} returned
            IOContext ctx = IOContext.merge(oneMerge.getStoreMergeInfo());
    private static final Field SEGMENT_INFOS_FIELD = initSegmentInfosField();  
            });  
                oneMerge.registerDone = true;  
                oneMerge.setAborted();  
    }
