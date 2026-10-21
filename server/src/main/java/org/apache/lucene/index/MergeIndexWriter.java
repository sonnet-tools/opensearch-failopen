     * {@link #prepareMerge} and the call to {@link #executeMerge} that would have consumed
 *
 * <h2>Coordination with engine refreshes</h2>
            return;
     *                        reuses the captured snapshot) or a fresh OneMerge (in which case
     *
public class MergeIndexWriter extends IndexWriter {
        try {
                        incRefDeleter(perReader);
     * Returns a point-in-time copy of the writer's current segment list holding the live
     *                        {@code mergeMiddle} captures its own snapshot inline).
            IOContext ctx = IOContext.merge(oneMerge.getStoreMergeInfo());
        }
            SegmentInfos segmentInfos = (SegmentInfos) SEGMENT_INFOS_FIELD.get(this);
     * disk as a {@code .liv} file. Required after a merge whose
     */
     * a file set without {@code .liv}; later when a flush triggers the {@code .liv}
            oneMerge.registerDone = true;
 *
 * engine's own merge thread pool rather than Lucene's {@code MergeThread}.
    }
     * the catalog publish that follows sees the {@code .liv} file in
     */
/**
            } catch (MergePolicy.MergeAbortedException expected) {
import org.opensearch.common.SuppressForbidden;
                oneMerge.isExternal = false;
     * {@code "Catalog segment ... has no matching Lucene leaf"} on the next refresh.
     * {@code carryOverHardDeletes} produced new dead bits on the merged segment, so
     * <p>{@link #executeMerge(MergePolicy.OneMerge, long)} must subsequently be invoked with
        PreparableOneMerge prepared = preparedMerges.remove(mergeGeneration);
        mergeInit(oneMerge);
     * {@link IndexWriter#numDeletedDocs(SegmentCommitInfo)}).
 * <p>The {@link IndexWriterConfig} used to construct this writer must set a
            return field;
 *
 *
     * <p>Marks the prepared merge as aborted and invokes {@link IndexWriter#merge}; the
        ensureOpen(false);
 *
    }
     * <p>If this method itself fails partway through {@code initMergeReaders}, it walks
     * {@code decRef} happens through Lucene's normal {@code closeMergeReaders} cleanup once
 * <p>The internal merge path handles the full segment lifecycle including reference-counted
 * {@link SerialMergeScheduler} to avoid the {@link ConcurrentMergeScheduler} thread
                }
     *       writes merged segment</li>
     * Callers must invoke this if the parquet (primary) phase fails between
     */
 * {@link #prepareMerge(PreparableOneMerge, long)} is invoked first — it runs Lucene's
     * their {@code setIsMerging} flags cleared. Only the original exception is rethrown;
            throw t;
            // checkAborted and the surrounding finally runs closeMergeReaders, which closes any
 * assertion in {@code wrapForMerge}, since pluggable data format merges run on the
    @Override
        boolean alreadyRegistered = oneMerge instanceof PreparableOneMerge p && p.readersInitialized();
     * the same generation; it picks up the prepared merge from an internal map and runs the
     * any abort-path failure is suppressed.
        // TODO update this for lucene as a primary engine
    /**
     *   <li>mergeMiddle — reads sources via wrapForMerge, applies IndexSort via MultiSorter,
            try {
 * the refresh lock, and only the short {@code commitMerge} window is serialized against
     * triggers a copy-on-write flip on each source segment's live docs, freezing the snapshot.
     * segments by identity; {@code cloneSegmentInfos()} deep-clones and cannot be used.
 * ordering {@code refreshLock → IndexWriter monitor} on the merge thread, matching the order
     * that were opened before the failure get closed, their file refs decremented, and
        // delete packets covering source segments, _mergeInit creates the output SegmentInfo.
            // readers we managed to open, decRefs their files (balancing our per-reader incRef),
    }
    private static Field initSegmentInfosField() {
import java.util.List;
package org.apache.lucene.index;
        try {
            return List.copyOf(segmentInfos.asList());
import java.io.IOException;
            return;
 * path for use by the pluggable data format merge infrastructure.
     * gap between this call and the eventual {@link #executeMerge} call. The matching
 * bitmap. The subsequent call to {@link #executeMerge(MergePolicy.OneMerge, long)} reuses the
 * compatible open source license.
     * <p>Refresh-lock coordination is handled by the {@code MergedSegmentWarmer} installed on
        synchronized (this) {
            }
     * @throws IOException if the merge fails
    public void executeMerge(MergePolicy.OneMerge oneMerge, long mergeGeneration) throws IOException {
     *
     * @param mergeGeneration the writer generation for the merged output segment; used as the
     */
    @SuppressForbidden(reason = "Need the live SegmentInfos reference for identity-based merge registration; cloneSegmentInfos() deep-clones")
 * An {@link IndexWriter} subclass that exposes Lucene's internal {@code merge(OneMerge)}
     *   <li>commitMerge — removes old segments from live list, decrements file references</li>
        assert preparedMerges.containsKey(mergeGeneration) == false : "prepareMerge invoked for generation "
            // Ride Lucene's own abort path: setAborted + merge fast-fails inside mergeMiddle's
     * @param oneMerge        the merge to execute. May be a {@link PreparableOneMerge} returned
            oneMerge.mergeGen = mergeGeneration;
     * {@link SegmentCommitInfo} references (not clones). Synchronized because Lucene mutates the
import java.lang.reflect.Field;
 * @opensearch.experimental
            // and clears the setIsMerging flags. Any cleanup failure is suppressed into the
                    });
 * <h2>Two-phase merge for cross-format snapshot consistency</h2>
 * and the partially-written merged segment is cleaned up — providing a safe rollback mechanism.
     * rest of the merge. If the parquet phase fails before {@code executeMerge}, the caller
    }
    public void prepareMerge(PreparableOneMerge oneMerge, long mergeGeneration) throws IOException {
     * {@code ReaderPool} writes live-docs lazily on flush), so the catalog records
            // original throwable.
            preparedMerges.put(mergeGeneration, oneMerge);
        merge(oneMerge);
     * inner {@code mergeMiddle.checkAborted()} fast-fails with a
            oneMerge.initMergeReaders(sci -> {
     * this writer's {@link IndexWriterConfig} — see the class Javadoc for details.
        return preparedMerges.remove(mergeGeneration);
        }
     *                        coordination key for {@link #executeMerge} and
        } catch (Throwable t) {
 * monitor is <em>not</em> held, and acquires the engine's refresh lock. This establishes the
     * underlying list only under the writer monitor; the returned copy is safe to iterate without
     * the prepared state.
        // mergeInit asserts !Thread.holdsLock(this); waitApplyForMerge resolves any pending
    }
        ReadersAndUpdates rld = getPooledInstance(mergedInfo, false);
        }
    public PreparableOneMerge takePreparedMerge(long mergeGeneration) {
}
 */
    public void flushLiveDocsForMergedSegment(SegmentCommitInfo mergedInfo) throws IOException {
     * <p>Without this, the merged segment's {@code SegmentCommitInfo} reports
        // https://github.com/opensearch-project/OpenSearch/issues/21505
 * do not need the two-phase split simply call {@link #executeMerge}.
        } catch (IllegalAccessException e) {
     * @param oneMerge        the merge to prepare
     * the merge runs (success or failure).
 * arriving in between produces a row-count mismatch across formats. To avoid this,
     * Prepares a merge by running {@code mergeInit} and populating its merge readers — which
     *
 * the primary-format merger must match what Lucene will physically drop in {@code mergeMiddle}.
 * (which causes a copy-on-write flip on each source segment's live docs). The frozen
                    return rld.getReaderForMerge(ctx, mr -> {
            + mergeGeneration
            merge(prepared);
 * file cleanup via {@code IndexFileDeleter}. If the merge fails, old segments are preserved
        }
            throw new IOException("Failed to access IndexWriter segmentInfos via reflection", e);
    }
     * Files referenced by each opened reader are pinned via the same per-reader
        }
     *
     *   <li>mergeFinish — cleans up merge tracking state</li>
     * {@code oneMerge.getMergeReader().get(i).hardLiveDocs} to build a bitmap that matches
     * {@code deleter.incRef} hook Lucene's own {@code mergeMiddle} uses, so they survive the
     *
        }
     * see on subsequent refresh.
     *
 * {@code addIndexes}). The expensive {@code mergeMiddle} phase therefore runs without holding
     */
 * SPDX-License-Identifier: Apache-2.0
        }
     *                        {@link #abortPreparedMerge}
     * Forces any in-memory live-docs deletes for the given segment to be persisted to
     * already serializes racing writers on the per-segment lock (same pattern as
     * returned OneMerge — its reader-pool and deleter references must be released by the
    /**
     * {@link MergePolicy.MergeAbortedException}, which {@code IndexWriter#handleMergeException}
 */
    private final Map<Long, PreparableOneMerge> preparedMerges = new ConcurrentHashMap<>();
     * the internal map. Returns {@code null} if no merge was prepared (or if it has already
            }
                // carries a TODO to "just throw all the time" in handleMergeException; if that lands,
import java.util.Map;
        } catch (MergePolicy.MergeAbortedException expected) {
        } catch (NoSuchFieldException e) {
    }
     * Aborts a prepared merge and releases its reader-pool and deleter references.
 * <p>For composite engines where Lucene is a secondary format, the live-docs snapshot used by
 * refresh path is layered on top by installing a {@code MergedSegmentWarmer} on the
                    // Lucene's standard abort path balances correctly: only opened readers were
 * prepared merge object so {@code mergeMiddle} proceeds with the same snapshot. Callers that
                ReadersAndUpdates rld = getPooledInstance(sci, true);
        if (prepared == null) {
        // merge() must be called without holding the lock — mergeInit asserts !Thread.holdsLock(this).
     *
/*
 * used by the engine's refresh path (which takes the refresh lock before calling
        }
     * swallows for non-external merges, while the surrounding finally block in {@code merge()}
            field.setAccessible(true);
     * {@code hasDeletions() == false} immediately after merge (because
 *
    /**
     * {@link SegmentCommitInfo} references are required because merge registration matches
            oneMerge.maxNumSegments = -1;
 * The OpenSearch Contributors require contributions made to
    protected void mergeSuccess(MergePolicy.OneMerge merge) {
     * <p>Duplicate segment prevention is handled by the caller; this method does not
            Field field = IndexWriter.class.getDeclaredField("segmentInfos");
     * @param mergeGeneration the writer generation for the merged output segment
                oneMerge.maxNumSegments = -1;
     */
    }
     * Executes a merge using Lucene's internal merge path which handles:
                    // Per-reader incRef matches what Lucene's own mergeMiddle does. The matching
     *                        by {@link #takePreparedMerge} (in which case {@code mergeMiddle}
    }
                oneMerge.mergeGen = mergeGeneration;
                    // decRef fires from closeMergeReaders during executeMerge cleanup. Per-reader
    public MergeIndexWriter(Directory d, IndexWriterConfig conf) throws IOException {
                        perReader.add(mr.reader.getSegmentInfo());
     * </ol>
                // so merge() returns normally after swallowing it. Kept deliberately because Lucene
     * Lucene's standard abort path ({@code setAborted} then {@code merge}) so any readers
            throw new ExceptionInInitializerError(e);
     *
            synchronized (this) {
     * must invoke {@link #abortPreparedMerge(long)} to release reader-pool and deleter refs.
     * <ol>
        // which fires between mergeMiddle and commitMerge while the IW monitor is not held. This
     * merged segment is cleaned up by IndexFileDeleter's reference counting.
        if (rld == null) {
        super(d, conf);
 * refreshes.
     * surrounding merge cleanup.
            });
                        SegmentInfos perReader = new SegmentInfos(getConfig().getIndexCreatedVersionMajor());
        prepared.setAborted();
     * validate against concurrent merges on the same segments.
 * this file be licensed under the Apache-2.0 license or a
                // Currently unreachable: IndexWriter#handleMergeException only rethrows
     * <p>If the merge fails at any point, old segments are preserved and the partially-written
     * cannot stall a concurrent refresh or flush; {@code ReadersAndUpdates#writeLiveDocs}
    public synchronized List<SegmentCommitInfo> liveSegmentCommitInfos() throws IOException {
        rld.writeLiveDocs(getDirectory());
        // Refresh-lock acquisition happens inside the MergedSegmentWarmer configured on this writer,
import org.apache.lucene.store.IOContext;
     * {@link SegmentCommitInfo#files()} and stays consistent with what readers will
 * <p>This class is placed in the {@code org.apache.lucene.index} package to access
     * a lock but may grow stale — merge registration re-validates against the live list.
                oneMerge.setAborted();
    /**
     * Returns the prepared merge for {@code mergeGeneration} if one exists, removing it from
     *
     * releases the reader-pool and deleter references that {@link #prepareMerge} took.
 * {@link IndexWriterConfig} (see {@code LuceneCommitter}). The warmer runs between
     * <p>After this returns, callers can read the frozen snapshot through
                // this catch keeps the abort path quiet. Cleanup ran in merge()'s finally either way.
 * {@code mergeInit} and then explicitly populates the {@link PreparableOneMerge}'s merge readers
    /**
                rld.setIsMerging();
    /**
import java.util.concurrent.ConcurrentHashMap;
        try {
import org.apache.lucene.store.Directory;
        try {
            + " that already has a prepared merge";
 * <p>This class itself does not take any engine-level locks. Coordination with the engine's
     *
                    // accounting (not bulk incRefDeleter) means partial-failure cleanup via
        super.mergeSuccess(merge);
     * write, the leaf has one extra file and the catalog/leaf mismatch surfaces as
                oneMerge.registerDone = true;
     * exactly what {@code mergeMiddle} will use for physical drops.
    private static final Field SEGMENT_INFOS_FIELD = initSegmentInfosField();
     * Reflective handle to {@link IndexWriter}'s private live {@code segmentInfos}. The live
            oneMerge.isExternal = false;
                    // incRef'd, only opened readers get decRef'd.
                t.addSuppressed(suppress);
            // Currently unreachable — see the matching catch in prepareMerge for why it is kept.
        // matches the refresh path's lock order (refreshLock → IW monitor) and avoids any inversion.
    public void abortPreparedMerge(long mergeGeneration) throws IOException {
                synchronized (this) {
    /**
 * {@code MergeReader.hardLiveDocs} can then be read by callers to construct the cross-format
 *
 *
     *
                merge(oneMerge);
     * been consumed). The caller is responsible for invoking {@link #executeMerge} with the
 *
 * package-private fields on {@link MergePolicy.OneMerge} required for merge registration.
 * {@code mergeMiddle} and {@code commitMerge}, at a point where the {@link IndexWriter}
        if (alreadyRegistered == false) {
     *   <li>mergeInit — creates output segment info, increments file references</li>
                // MergeAbortedException when merge.isExternal, and we set isExternal=false above,
     * <p>Deliberately not synchronized on the writer monitor so the {@code .liv} disk write
 * Without coordination, the snapshot is captured later than the primary's bitmap and a delete
     */
            } catch (Throwable suppress) {
