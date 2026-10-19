        List<List<Segment>> findMergeCandidates(List<Segment> segments) throws IOException;
 */
    public synchronized void onMergeFinished(OneMerge oneMerge, boolean isFrozen) {
     * @see MergeScheduler — the production caller that enforces this ordering via
/**
        void addMergingSegment(Collection<Segment> mergingSegments);
        /**
            logger.warn("Failed to acquire snapshots", e);
package org.opensearch.index.engine.dataformat.merge;
     * Executes the given merge operation by delegating to the {@link Merger}.
         * @return a list of segment groups, where each group is a list of segments to be merged together;
     * being merged, for example to exclude them from future merge candidate selection.
         *
                        if (currentlyMergingSegments.contains(seg)) {
        List<OneMerge> oneMerges = new ArrayList<>();
        this.mergeListener = mergeListener;
         * @param mergingSegments the segments that are no longer being merged
     * @throws IOException if the merge operation fails
    public synchronized boolean hasPendingMerges() {
        Merger merger,
    }
                            hasConflict = true;
                        if (registerMerge(oneMerge, false)) {
 *
        registerMerge(merge, true);
    }
     * Finds merges required to reduce the number of segments to at most {@code maxSegmentCount}.
        MergePolicy mergePolicy,
            List<Segment> segmentList = catalogSnapshotRef.get().getSegments();
         * Finds groups of segments that are candidates for merging.
    /**
            logger.warn("Failed to acquire snapshots", e);
     *
@ExperimentalApi
     * @param maxSegmentCount the maximum number of segments allowed after merging
        removeMergingSegments(oneMerge);
        if (addToPending) { // Skips this for force merges. Avoid 2 workers executing the merge.
 * @opensearch.experimental
        MergeListener mergeListener,
     * Creates a new merge handler.
        currentlyMergingSegments.addAll(merge.getSegmentsToMerge());
        List<List<Segment>> findForceMergeCandidates(List<Segment> segments, int maxSegmentCount) throws IOException;
    }
 * The OpenSearch Contributors require contributions made to
                registerMerge(oneMerge);
        oneMerge.getSegmentsToMerge().forEach(currentlyMergingSegments::remove);
            return null;
         * Finds groups of segments that are candidates for a forced merge operation.
    }
 * <p>
        try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = snapshotSupplier.get()) {
        return oneMerges;
        assert result.getMergedWriterFileSet().isEmpty() == false : "merge result must contain at least one format's files";
     */
         * @param segments        the current list of segments to evaluate for merging
     * @param snapshotSupplier supplier for acquiring catalog snapshots for segment validation
    }
     * Returns the number of pending (queued but not yet started) merges.
    }
        return true;
         */
            }
         * @return a list of segment groups, where each group is a list of segments to be merged together;
    }
     */
            List<List<Segment>> mergeCandidates = mergePolicy.findMergeCandidates(segmentList);
    private synchronized void removeMergingSegments(OneMerge oneMerge) {
    /**
         * into a single new segment. The outer list contains all such merge groups.
     * @param merge the merge to register
            List<Segment> segmentList = catalogSnapshotRef.get().getSegments();
                    if (!hasConflict) {
     * @return the next merge to execute, or {@code null} if the queue is empty
        Collection<OneMerge> oneMerges = findMerges();
         * @throws IOException if an I/O error occurs while evaluating segments
                        }
    /**
 * Manages the segment merge queue, lifecycle callbacks, and merge candidate
     *
     * @opensearch.experimental
import java.util.function.Supplier;
        this.snapshotSupplier = snapshotSupplier;
    public MergeResult doMerge(OneMerge oneMerge) throws IOException {
     * new merge candidates. If the catalog still contains the old source segments,
    /**
     */
     * @param oneMerge the merge that finished
    }
    public MergeHandler(
    /**
     * @return the pending merge count
                            oneMerges.add(oneMerge);
     * <p>
    /**
                }
        mergeListener.addMergingSegment(merge.getSegmentsToMerge());
 * SPDX-License-Identifier: Apache-2.0
        mergeListener.removeMergingSegment(oneMerge.getSegmentsToMerge());
        }
     *
            throw new RuntimeException(e);
         * Called when the given segments begin participating in a merge.
        long generation = generationProvider.get();
    }
     */
        /**
     */
    /**
    private final Deque<OneMerge> pendingMerges = new ArrayDeque<>();
            if (isValidMerge) {
 * Per-format plugins (Parquet, Lucene) implement {@link Merger}
     * Retrieves and removes the next pending merge from the queue.
                }
import java.io.IOException;
    }
}
         * into a single new segment.
         * <p>
        Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplier,
    }
     * <p>
        }
        MergeResult result = merger.merge(mergeInput);
            pendingMerges.add(merge);
        removeMergingSegments(oneMerge);
        List<OneMerge> oneMerges = new ArrayList<>();
         *
import org.opensearch.index.engine.dataformat.Merger;
    /**
public class MergeHandler {
/*
        return !pendingMerges.isEmpty();
     * A listener that is notified when segments begin or finish participating in a merge.
         * @param segments the current list of segments to evaluate for merging
import org.apache.logging.log4j.message.ParameterizedMessage;
import java.util.ArrayDeque;
                            break;
         * Each inner list represents a set of segments that should be merged together
 */
            List<List<Segment>> mergeCandidates = mergePolicy.findForceMergeCandidates(segmentList, maxSegmentCount);
                }
     */
    /**
 * only — they don't know about multi-format orchestration.
     * Finds merges that should be executed based on the current segment state.
import java.util.Deque;
     * This method calls {@link #findAndRegisterMerges()} which reads the catalog to find
     *
     */
            }
        } catch (Exception e) {
     * @param shardId          the shard this handler is associated with (used for logging)
            for (List<Segment> mergeGroup : mergeCandidates) {
     * Callback invoked when a merge completes successfully.
        return oneMerges;
         */
                if (!catalogSegments.contains(mergeSegment)) {
         * @throws IOException if an I/O error occurs while evaluating segments
        void removeMergingSegment(Collection<Segment> mergingSegments);
         *         returns an empty list if no merges are needed
            for (Segment mergeSegment : merge.getSegmentsToMerge()) {
    private final Logger logger;
         * @param maxSegmentCount the maximum number of segments that should remain after all merges complete
            for (List<Segment> mergeGroup : mergeCandidates) {
            for (Segment segment : oneMerge.getSegmentsToMerge()) {
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.index.engine.dataformat.MergeResult;
            return;
     *
        }
         * @param mergingSegments the segments that are now being merged
    private final MergeListener mergeListener;
     *
        /**
    public interface MergePolicy {
import org.opensearch.common.concurrent.GatedCloseable;
                        OneMerge oneMerge = new OneMerge(mergeGroup);
 * Merge execution is delegated to a {@link Merger} provided at construction.
            throw new RuntimeException(e);
        Supplier<Long> generationProvider
import org.opensearch.common.annotation.ExperimentalApi;
 * compatible open source license.
import org.opensearch.common.logging.Loggers;
        return pendingMerges.size();
         * A forced merge reduces the total number of segments to at most {@code maxSegmentCount}.
     * @param oneMerge the merge to execute
     */
import java.util.ArrayList;
import java.util.List;
    public synchronized OneMerge getNextMerge() {
            throw new RuntimeException(e);
        assert result != null : "merger must return a non-null MergeResult";
                        }
     * Callback invoked when a merge fails.
                    }
    private final Merger merger;
         * Called when the given segments have finished participating in a merge.
            logger.warn("Failed to acquire snapshots", e);
        this.generationProvider = generationProvider;
        this.logger = Loggers.getLogger(getClass(), shardId);
     */
        }
        } catch (Exception e) {
        try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = snapshotSupplier.get()) {
        for (OneMerge oneMerge : oneMerges) {
                oneMerges.add(new OneMerge(mergeGroup));
    public synchronized void onMergeFailure(OneMerge oneMerge) {
            boolean isValidMerge = true;
     * Updates the set of pending merges. Called to refresh the merge queue
     * when the segment state changes.
         * <p>
 *
         */
         * Each inner list represents a set of segments that should be merged together
        logger.debug(() -> new ParameterizedMessage("Registered merge [{}], pendingMerges: [{}]", merge, pendingMerges));
import java.util.Set;
        MergeInput mergeInput = MergeInput.builder().segments(oneMerge.getSegmentsToMerge()).newWriterGeneration(generation).build();
    /**
    public synchronized void findAndRegisterMerges() {
    public interface MergeListener {
     *
        pendingMerges.remove(oneMerge);
    }
     * @opensearch.experimental
        assert generation > 0 : "merge writer generation must be positive but was: " + generation;
        return pendingMerges.removeFirst();
                boolean hasConflict = false;
     * Implementations can use these callbacks to track which segments are currently
     * Implementations define the strategy for selecting which segments to merge
        }
    }
        ShardId shardId,
    public synchronized int getPendingMergeCount() {
     */
                    }
     * @return {@code true} if there are pending merges
        if (pendingMerges.isEmpty()) {
     * <b>IMPORTANT:</b> The caller MUST apply the merge result to the catalog
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    /**
    private final Supplier<Long> generationProvider;
     *
     * A policy that determines how segments should be merged together.
    public Collection<OneMerge> findForceMerges(int maxSegmentCount) {
     * during both regular background merges and forced merge operations.
import org.apache.logging.log4j.Logger;
        this.mergePolicy = mergePolicy;
    public synchronized void registerMerge(OneMerge merge) {
    }
     * @return a collection of merges to execute
     */
     *      {@code applyMergeChanges.accept(mergeResult, oneMerge)} before this call
 * selection via {@link MergePolicy}.
         *         returns an empty list if the segment count is already within the limit
    private final MergePolicy mergePolicy;
        } catch (Exception e) {
            List<Segment> catalogSegments = catalogSnapshotRef.get().getSegments();
                    break;
     * (replacing source segments with the merged segment) BEFORE calling this method.
        /**
                synchronized (this) {
import java.util.Collection;
                    isValidMerge = false;
        assert oneMerge.getSegmentsToMerge().isEmpty() == false : "merge must have at least one segment";
     *
     * @param merger           the merger that performs the actual merge operation
         */
        return result;
    }
     * Registers a merge to be executed.
                    for (Segment seg : mergeGroup) {
        this.merger = merger;
     * @return a collection of merges to execute, or an empty collection if none are needed
     */
            }
    private final Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplier;
                if (currentlyMergingSegments.contains(segment)) {
                    return false;
    /**
            }
     * @param oneMerge the merge that failed
        try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = snapshotSupplier.get()) {
 * this file be licensed under the Apache-2.0 license or a
     *
     */
     * <p>
import java.util.HashSet;
     *
    /**
        if (isFrozen) {
import org.opensearch.index.engine.exec.Segment;
         *
         *
        }
        findAndRegisterMerges();
    public Collection<OneMerge> findMerges() {
     * Returns whether there are any pending merges in the queue.
     * @return the result of the merge
        }
            }
    ) {
import org.opensearch.index.engine.dataformat.MergeInput;
    private synchronized boolean registerMerge(OneMerge merge, boolean addToPending) {
     *
     * they may be incorrectly selected for another merge.
        logger.warn(() -> new ParameterizedMessage("Merge failed for OneMerge [{}]", oneMerge));
    private final Set<Segment> currentlyMergingSegments = new HashSet<>();
