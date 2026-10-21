        Segment s3 = seg(3);
        handler.registerMerge(s2Merge);
     * Verifies that {@code findForceMerges} excludes segments that are already being merged
 */
        assertTrue("Force merge should not pick segments already being merged by background merge", forceMerges.isEmpty());
        assertEquals(1, handler.getPendingMergeCount());
        assertEquals("Should return 1 non-conflicting merge group", 1, forceMerges.size());
        MergeHandler handler = newHandler(snapshotWith(s1));
import org.opensearch.core.index.Index;
        Segment s3 = seg(3);
        Segment s4 = seg(4);
        MergeHandler handler = newHandler(snapshotWith(s1, s2));
        OneMerge merge = new OneMerge(List.of(s1));
        Segment s1 = seg(1);
        assertEquals(2, handler.getPendingMergeCount());
import org.opensearch.index.engine.dataformat.DataFormat;
    }
        // s1+s2 already registered (and thus "currently merging").
import static org.mockito.Mockito.never;
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3, s4));
        // findForceMerges should only return and register [s3]
        Segment s2 = seg(2);
        // After this merge finishes (not frozen), the handler should look for new merges.
 */
        WriterFileSet mergedFiles = new WriterFileSet("dir", 1L, java.util.Set.of("merged.file"), 0L, 0L);
    }
        Segment s4 = seg(4);
        when(mergePolicy.findMergeCandidates(any())).thenReturn(List.of(List.of(s3, s4)));
        assertNull("getNextMerge on empty queue returns null", handler.getNextMerge());
    }
    }
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3, s4));
    private Merger merger;
        // Even if the policy would propose new work, a frozen handler must not register it.
        when(mergePolicy.findMergeCandidates(any())).thenReturn(List.of(List.of(s3, s4)));
import org.opensearch.common.concurrent.GatedCloseable;
    }
public class MergeHandlerTests extends OpenSearchTestCase {
import org.opensearch.index.engine.exec.WriterFileSet;
        OneMerge finished = new OneMerge(List.of(s1, s2));
    private static Segment seg(long generation) {
    @Override
        mergeListener = mock(MergeHandler.MergeListener.class);
        assertNull(handler.getNextMerge());
    }
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
 * compatible open source license.
}
        return new Segment(generation, Map.of());
        assertTrue(remaining.getSegmentsToMerge().contains(s4));
        assertEquals(0, handler.getPendingMergeCount());
        when(mergePolicy.findMergeCandidates(any())).thenReturn(List.of(List.of(s2, s3)));
    /**
        Segment s2 = seg(2);
import java.util.function.Supplier;
    public void testFindAndRegisterMerges_RegistersPolicyCandidates() throws Exception {
        when(mergePolicy.findForceMergeCandidates(any(), any(Integer.class))).thenReturn(List.of(List.of(s1, s2), List.of(s3)));
        handler.findAndRegisterMerges();
        handler.registerMerge(finished);
        var forceMerges = handler.findForceMerges(1);
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3, s4));
        Segment s2 = seg(2);
        // newly registered s2 is pending → 2 pending total
        // Merge policy returns two groups: [s1, s2] and [s3, s4]
        assertFalse(handler.hasPendingMerges());
 * <p>
        assertTrue(handler.hasPendingMerges());
        // Verify by registering a merge containing s2 — should succeed
        when(mergePolicy.findMergeCandidates(any())).thenReturn(List.of(List.of(s1, s2)));
import static org.mockito.Mockito.verify;
    }
        Segment s2 = seg(2);
    }
        mergePolicy = mock(MergeHandler.MergePolicy.class);
    }
        Segment s2 = seg(2);
import java.util.Map;
    public void testOnMergeFinished_Frozen_DoesNotReRegister() throws Exception {
        MergeHandler handler = newHandler(snapshotWith(inCatalog));
        MergeResult result = mock(MergeResult.class);
    public void testFindForceMergesExcludesAlreadyMergingSegments() throws Exception {
        assertEquals(1, handler.getPendingMergeCount());
        assertEquals("Overlapping candidate must not be registered", 1, handler.getPendingMergeCount());
        handler.onMergeFailure(failing);
import org.opensearch.core.index.shard.ShardId;
        // Return a fresh GatedCloseable per call so try-with-resources close() is always valid.
     * with currently merging segments.
        handler.onMergeFinished(finished, false);
     * in currentlyMergingSegments. Only non-conflicting groups should be registered.
        return new MergeHandler(snapshotSupplier, merger, SHARD_ID, mergePolicy, mergeListener, () -> 1L);
        OneMerge first = new OneMerge(List.of(s1, s2));
        // findForceMerges should return only the non-conflicting group [s3, s4]
        assertEquals(0, handler.getPendingMergeCount());
import org.opensearch.test.OpenSearchTestCase;
        var forceMerges = handler.findForceMerges(1);
        Segment s1 = seg(1);
        assertEquals(0, handler.getPendingMergeCount());
    public void testRegisterMerge_SkipsWhenSegmentNotInCatalog() {
        Segment s1 = seg(1);
        // Register a background merge for segments [s1, s2] — marks them as currently merging
        when(mergePolicy.findForceMergeCandidates(any(), any(Integer.class))).thenReturn(List.of(List.of(s1, s2), List.of(s3, s4)));
import org.opensearch.index.engine.exec.Segment;
    }
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3, s4));
 * {@link MergeHandler#getPendingMergeCount()}) that tiering preparation relies on to decide
        assertTrue(remaining.getSegmentsToMerge().contains(s3));
        Segment s2 = seg(2);
        OneMerge finished = new OneMerge(List.of(s1, s2));
import static org.mockito.Mockito.when;
        // The force merge group [s1, s2, s3, s4] contains merging segments → should be filtered out
    public void testRegisterMerge_AddsToPendingAndNotifiesListener() {
        handler.registerMerge(failing);
    }
import static org.mockito.ArgumentMatchers.any;
        OneMerge backgroundMerge = new OneMerge(List.of(s1, s2));
     * by a background merge. Without this fix, a concurrent force merge + background merge
        Segment s4 = seg(4);
        // Catalog only contains inCatalog; a merge referencing a stale segment must be ignored.
    public void testEmptyHandler_HasNoPendingMerges() {
        OneMerge s2Merge = new OneMerge(List.of(s2));
        Segment s1 = seg(1);
        handler.registerMerge(second);
        Segment s3 = seg(3);
        verify(mergePolicy, never()).findMergeCandidates(any());
        handler.onMergeFinished(finished, true);
     * could pick the same segments, causing the Lucene secondary to merge fewer docs than
        when(snapshot.getSegments()).thenReturn(List.of(segments));
 * These exercise the pending-merge tracking surface ({@link MergeHandler#hasPendingMerges()},
import static org.mockito.Mockito.mock;
        verify(mergeListener).addMergingSegment(merge.getSegmentsToMerge());
    }
        Segment stale = seg(99);
    public void testOnMergeFailure_ClearsMergingSegments() {
        handler.registerMerge(finished);
        assertSame(result, actual);
    private MergeHandler newHandler(Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplier) {
        assertEquals(1, handler.getPendingMergeCount());
        assertSame(first, handler.getNextMerge());
     * Verifies that {@code findForceMerges} returns candidates when no segments overlap
        Segment s4 = seg(4);
        assertSame(second, handler.getNextMerge());
        handler.registerMerge(backgroundMerge);
        Segment s2 = seg(2);
        // background s1 is pending (from registerMerge), force s3 is NOT pending (only in currentlyMerging),
        Segment s4 = seg(4);
        handler.registerMerge(first);
    /**
        verify(merger).merge(any(MergeInput.class));
        Segment s1 = seg(1);
     */
     * parquet (row count mismatch).
        assertEquals(1, handler.getPendingMergeCount());
        Segment s1 = seg(1);
        OneMerge merge = new OneMerge(List.of(s1, s2));
        when(result.getMergedWriterFileSet()).thenReturn(Map.of(mock(DataFormat.class), mergedFiles));
        handler.findAndRegisterMerges();
    public void testOnMergeFinished_NotFrozen_ReRegistersNewCandidates() throws Exception {
 * candidate registration/dedup, and the merge lifecycle callbacks.
        Segment s1 = seg(1);
        // Policy proposes a candidate that overlaps s2 — it must be skipped.
    }
        handler.registerMerge(new OneMerge(List.of(s1, s2)));
 * The OpenSearch Contributors require contributions made to
        Segment s1 = seg(1);
    public void testFindForceMergesReturnsNonConflictingCandidates() throws Exception {
        verify(mergeListener).removeMergingSegment(failing.getSegmentsToMerge());
import org.opensearch.index.engine.dataformat.MergeResult;
        merger = mock(Merger.class);
        verify(mergeListener).addMergingSegment(List.of(s3, s4));
    /** Builds a snapshot supplier that always exposes the given segments as the current catalog. */
        var forceMerges = handler.findForceMerges(1);
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3, s4));
     */
        Segment s1 = seg(1);
        assertEquals(1, handler.getPendingMergeCount());
        verify(mergeListener).removeMergingSegment(finished.getSegmentsToMerge());
        Segment s2 = seg(2);
        super.setUp();
        MergeHandler handler = newHandler(snapshotWith(s1, s2));
        MergeHandler handler = newHandler(snapshotWith());
        verify(mergeListener).removeMergingSegment(finished.getSegmentsToMerge());
    public void setUp() throws Exception {
     * Verifies that {@code findForceMerges} does NOT register conflicting merge groups
        assertFalse(handler.hasPendingMerges());
/**
    }
        Segment s2 = seg(2);
        assertEquals(0, handler.getPendingMergeCount());
    public void testDoMerge_DelegatesToMerger() throws Exception {
    private Supplier<GatedCloseable<CatalogSnapshot>> snapshotWith(Segment... segments) {
    public void testFindAndRegisterMerges_SkipsCandidatesOverlappingActiveMerge() throws Exception {
        handler.registerMerge(merge);
        handler.registerMerge(backgroundMerge);
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3));
    }
        assertFalse(handler.hasPendingMerges());
    }
import java.util.List;
    public void testFindForceMergesOnlyRegistersNonConflictingGroups() throws Exception {
        verify(mergeListener).addMergingSegment(List.of(s1, s2));
    private MergeHandler.MergePolicy mergePolicy;
        Segment inCatalog = seg(1);
    }
        return () -> new GatedCloseable<>(snapshot, () -> {});
        // Merge policy returns two groups: [s1, s2] (will conflict) and [s3] (won't conflict)
        assertEquals(2, remaining.getSegmentsToMerge().size());
        when(merger.merge(any(MergeInput.class))).thenReturn(result);
        // Now findForceMerges should exclude s1 and s2 since they're already merging
        Segment s3 = seg(3);
    private static final ShardId SHARD_ID = new ShardId(new Index("idx", "uuid"), 0);
        Segment s1 = seg(1);
     */
        Segment s3 = seg(3);
import org.opensearch.index.engine.dataformat.Merger;
        OneMerge second = new OneMerge(List.of(s3, s4));
        // Register background merge for [s1, s2]
 * whether a shard's merges have drained.
        when(mergePolicy.findForceMergeCandidates(any(), any(Integer.class))).thenReturn(List.of(List.of(s1, s2, s3, s4)));
    /**
        Segment s3 = seg(3);
        Segment s3 = seg(3);
        OneMerge backgroundMerge = new OneMerge(List.of(s1, s2));
        assertEquals(1, handler.getPendingMergeCount());
        MergeHandler handler = newHandler(snapshotWith(s1, s2));
    private MergeHandler.MergeListener mergeListener;
        verify(mergeListener, never()).addMergingSegment(any());
    public void testGetNextMerge_IsFifoThenNull() {
        // Register background merge for s1 — makes [s1, s2] group conflicting
        assertFalse(handler.hasPendingMerges());
 * this file be licensed under the Apache-2.0 license or a
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3));
        handler.registerMerge(new OneMerge(List.of(s1)));
        handler.registerMerge(new OneMerge(List.of(stale)));
        // Simulate merge policy returning all segments as force merge candidates
        // finished removed; new [s3,s4] registered.
        OneMerge remaining = forceMerges.iterator().next();
        assertEquals(1, handler.getPendingMergeCount());
import org.opensearch.index.engine.dataformat.MergeInput;
        assertEquals(1, forceMerges.size());
        Segment s1 = seg(1);
 * SPDX-License-Identifier: Apache-2.0
        OneMerge failing = new OneMerge(List.of(s1, s2));
        assertEquals("Frozen handler must not register new merges", 0, handler.getPendingMergeCount());
package org.opensearch.index.engine.dataformat.merge;
 * Unit tests for {@link MergeHandler}: the merge queue, pending-count accounting,
        Segment s2 = seg(2);
        MergeResult actual = handler.doMerge(merge);
        assertEquals(2, handler.getPendingMergeCount());
 *
        // s2 should NOT be stuck in currentlyMergingSegments
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
/*
