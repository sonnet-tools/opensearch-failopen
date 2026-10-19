        long generation = generationProvider.get();
        }
    public synchronized void registerMerge(OneMerge merge) {
import java.util.ArrayList;  
         *
    private final Deque<OneMerge> pendingMerges = new ArrayDeque<>();  
    }
     * Callback invoked when a merge completes successfully.
        /**  
            return null;
    private final Supplier<Long> generationProvider;
        /**  
                if (currentlyMergingSegments.contains(segment)) {
public class MergeHandler {
 */
     *      {@code applyMergeChanges.accept(mergeResult, oneMerge)} before this call
    /**
            logger.warn("Failed to acquire snapshots", e);
        removeMergingSegments(oneMerge);  
    }
        return oneMerges;
            pendingMerges.add(merge);
        ShardId shardId,
     */
     * new merge candidates. If the catalog still contains the old source segments,  
            throw new RuntimeException(e);
 * this file be licensed under the Apache-2.0 license or a
    /**  
                boolean hasConflict = false;
            List<List<Segment>> mergeCandidates = mergePolicy.findForceMergeCandidates(segmentList, maxSegmentCount);
         * @throws IOException if an I/O error occurs while evaluating segments
        oneMerge.getSegmentsToMerge().forEach(currentlyMergingSegments::remove);  
         * <p>
     * @return {@code true} if there are pending merges  
        }
        this.snapshotSupplier = snapshotSupplier;
        try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = snapshotSupplier.get()) {
     */
    private final MergePolicy mergePolicy;  
        if (addToPending) { // Skips this for force merges. Avoid 2 workers executing the merge.  
         * Called when the given segments have finished participating in a merge.
import org.opensearch.common.concurrent.GatedCloseable;
 * compatible open source license.
            List<List<Segment>> mergeCandidates = mergePolicy.findMergeCandidates(segmentList);
     *  
     * @param merge the merge to register  
     *
     */  
     * Implementations can use these callbacks to track which segments are currently
    private final Merger merger;
        removeMergingSegments(oneMerge);
 * @opensearch.experimental
import org.opensearch.common.annotation.ExperimentalApi;  
     * (replacing source segments with the merged segment) BEFORE calling this method.
     * Registers a merge to be executed.
/*  
 * selection via {@link MergePolicy}.
import java.util.List;
    /**  
     */  
        }  
    /**  
        } catch (Exception e) {
import java.util.Set;
     * @return the pending merge count  
     * Creates a new merge handler.
     */
                }  
     * Executes the given merge operation by delegating to the {@link Merger}.
     * Finds merges required to reduce the number of segments to at most {@code maxSegmentCount}.
 * only — they don't know about multi-format orchestration.
        for (OneMerge oneMerge : oneMerges) {
     * @param oneMerge the merge that failed  
                if (!catalogSegments.contains(mergeSegment)) {
     * @return the next merge to execute, or {@code null} if the queue is empty  
import java.util.ArrayDeque;
        try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = snapshotSupplier.get()) {  
    public MergeHandler(
 * The OpenSearch Contributors require contributions made to  
            if (isValidMerge) {  
     * @param oneMerge the merge to execute
        assert generation > 0 : "merge writer generation must be positive but was: " + generation;
         */  
            logger.warn("Failed to acquire snapshots", e);  
        MergeListener mergeListener,  
    }
     * Updates the set of pending merges. Called to refresh the merge queue
        void addMergingSegment(Collection<Segment> mergingSegments);
import org.apache.logging.log4j.message.ParameterizedMessage;
     */  
            }
         */
        return !pendingMerges.isEmpty();  
         * @param mergingSegments the segments that are now being merged
        assert oneMerge.getSegmentsToMerge().isEmpty() == false : "merge must have at least one segment";  
     * @opensearch.experimental
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            }
         * @param segments        the current list of segments to evaluate for merging
        Merger merger,  
                            break;  
     */
    private synchronized void removeMergingSegments(OneMerge oneMerge) {
                            hasConflict = true;
            List<Segment> segmentList = catalogSnapshotRef.get().getSegments();
import org.opensearch.index.engine.dataformat.MergeInput;
        } catch (Exception e) {  
        MergeInput mergeInput = MergeInput.builder().segments(oneMerge.getSegmentsToMerge()).newWriterGeneration(generation).build();  
 * SPDX-License-Identifier: Apache-2.0
    public interface MergeListener {  
     */
                    }
    /**  
        return pendingMerges.size();  
        logger.debug(() -> new ParameterizedMessage("Registered merge [{}], pendingMerges: [{}]", merge, pendingMerges));
        try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = snapshotSupplier.get()) {  
     *  
    public synchronized void onMergeFailure(OneMerge oneMerge) {
    }
                        OneMerge oneMerge = new OneMerge(mergeGroup);
         * into a single new segment.
        Collection<OneMerge> oneMerges = findMerges();  
        this.mergeListener = mergeListener;  
         *  
 */  
                }
     *
            for (Segment segment : oneMerge.getSegmentsToMerge()) {  
            }
        Supplier<Long> generationProvider
         * @param segments the current list of segments to evaluate for merging
         * <p>
            List<Segment> catalogSegments = catalogSnapshotRef.get().getSegments();
        List<List<Segment>> findMergeCandidates(List<Segment> segments) throws IOException;
    /**
        this.merger = merger;
    ) {
        Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplier,
     * A listener that is notified when segments begin or finish participating in a merge.
import org.opensearch.common.logging.Loggers;
    public synchronized void onMergeFinished(OneMerge oneMerge, boolean isFrozen) {
         *
     * during both regular background merges and forced merge operations.
     * <p>
    private synchronized boolean registerMerge(OneMerge merge, boolean addToPending) {  
     *  
    /**
            throw new RuntimeException(e);
        findAndRegisterMerges();  
        pendingMerges.remove(oneMerge);
         * Finds groups of segments that are candidates for merging.  
        }  
            for (Segment mergeSegment : merge.getSegmentsToMerge()) {  
     * @return the result of the merge
    }  
 * Per-format plugins (Parquet, Lucene) implement {@link Merger}
        /**
        mergeListener.removeMergingSegment(oneMerge.getSegmentsToMerge());
            throw new RuntimeException(e);
import org.apache.logging.log4j.Logger;
     * @param shardId          the shard this handler is associated with (used for logging)
import java.util.function.Supplier;  
    }
     * <p>  
     *
 * Merge execution is delegated to a {@link Merger} provided at construction.  
     *
import java.util.Collection;
         * @param maxSegmentCount the maximum number of segments that should remain after all merges complete
 *  
        this.mergePolicy = mergePolicy;
     * Implementations define the strategy for selecting which segments to merge
         *         returns an empty list if no merges are needed
        mergeListener.addMergingSegment(merge.getSegmentsToMerge());
        currentlyMergingSegments.addAll(merge.getSegmentsToMerge());  
                    break;  
        return oneMerges;
    public synchronized void findAndRegisterMerges() {
     */
         * Each inner list represents a set of segments that should be merged together
         * @param mergingSegments the segments that are no longer being merged  
        assert result.getMergedWriterFileSet().isEmpty() == false : "merge result must contain at least one format's files";  
        }
    }
    /**  
            logger.warn("Failed to acquire snapshots", e);
    }
         * Called when the given segments begin participating in a merge.  
     *
            }
     * Callback invoked when a merge fails.
         * @throws IOException if an I/O error occurs while evaluating segments
     *  
            }
         * @return a list of segment groups, where each group is a list of segments to be merged together;  
         */  
    }
                }  
import java.util.HashSet;  
     * @param snapshotSupplier supplier for acquiring catalog snapshots for segment validation  
     * This method calls {@link #findAndRegisterMerges()} which reads the catalog to find
     * @opensearch.experimental
    public interface MergePolicy {  
        return true;  
        /**
        } catch (Exception e) {  
                        if (currentlyMergingSegments.contains(seg)) {
            for (List<Segment> mergeGroup : mergeCandidates) {  
     * they may be incorrectly selected for another merge.
                            oneMerges.add(oneMerge);  
 * <p>
}
     * Returns the number of pending (queued but not yet started) merges.
    private final Logger logger;  
 *
     */  
import org.opensearch.index.engine.exec.Segment;
     * A policy that determines how segments should be merged together.
    /**  
     * when the segment state changes.  
     * Retrieves and removes the next pending merge from the queue.
    }
        List<List<Segment>> findForceMergeCandidates(List<Segment> segments, int maxSegmentCount) throws IOException;
     * Returns whether there are any pending merges in the queue.
            List<Segment> segmentList = catalogSnapshotRef.get().getSegments();
     */
     *
        return result;
                    isValidMerge = false;
        if (isFrozen) {  
/**
     * Finds merges that should be executed based on the current segment state.  
import org.opensearch.index.engine.dataformat.Merger;  
import java.io.IOException;
     * being merged, for example to exclude them from future merge candidate selection.
            boolean isValidMerge = true;
    public synchronized OneMerge getNextMerge() {
        logger.warn(() -> new ParameterizedMessage("Merge failed for OneMerge [{}]", oneMerge));
            return;
                registerMerge(oneMerge);
                    if (!hasConflict) {  
    public Collection<OneMerge> findForceMerges(int maxSegmentCount) {
    private final Set<Segment> currentlyMergingSegments = new HashSet<>();
        List<OneMerge> oneMerges = new ArrayList<>();
    }  
                    }
        List<OneMerge> oneMerges = new ArrayList<>();
         * Finds groups of segments that are candidates for a forced merge operation.
    public MergeResult doMerge(OneMerge oneMerge) throws IOException {
         * Each inner list represents a set of segments that should be merged together
    }
         *
     * @return a collection of merges to execute, or an empty collection if none are needed
         * @return a list of segment groups, where each group is a list of segments to be merged together;  
 * Manages the segment merge queue, lifecycle callbacks, and merge candidate  
     * <p>  
     * @throws IOException if the merge operation fails  
        return pendingMerges.removeFirst();  
     * @param maxSegmentCount the maximum number of segments allowed after merging
        void removeMergingSegment(Collection<Segment> mergingSegments);
                        if (registerMerge(oneMerge, false)) {
    private final Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplier;
     *
    public Collection<OneMerge> findMerges() {
         *         returns an empty list if the segment count is already within the limit
        registerMerge(merge, true);  
    /**
     * @param oneMerge the merge that finished  
        this.generationProvider = generationProvider;
                synchronized (this) {
     */
        this.logger = Loggers.getLogger(getClass(), shardId);  
    /**
        MergePolicy mergePolicy,
import org.opensearch.core.index.shard.ShardId;  
@ExperimentalApi  
     * @return a collection of merges to execute
         * A forced merge reduces the total number of segments to at most {@code maxSegmentCount}.  
                oneMerges.add(new OneMerge(mergeGroup));
     * @see MergeScheduler — the production caller that enforces this ordering via
    }
    }
import java.util.Deque;
    }
    /**  
        MergeResult result = merger.merge(mergeInput);
         */  
        assert result != null : "merger must return a non-null MergeResult";
                    for (Segment seg : mergeGroup) {  
     * @param merger           the merger that performs the actual merge operation
                        }
    private final MergeListener mergeListener;
    public synchronized int getPendingMergeCount() {
        }
    /**
                        }
            for (List<Segment> mergeGroup : mergeCandidates) {  
        }  
    public synchronized boolean hasPendingMerges() {
                    return false;
import org.opensearch.index.engine.dataformat.MergeResult;
         * into a single new segment. The outer list contains all such merge groups.  
     * <b>IMPORTANT:</b> The caller MUST apply the merge result to the catalog  
     */
     *
package org.opensearch.index.engine.dataformat.merge;
        if (pendingMerges.isEmpty()) {  
