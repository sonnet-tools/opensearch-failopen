 * {@link MergeHandler#getPendingMergeCount()}) that tiering preparation relies on to decide
import static org.mockito.ArgumentMatchers.any;
        Segment s3 = seg(3);
        when(mergePolicy.findMergeCandidates(any())).thenReturn(List.of(List.of(s3, s4)));  
    }
        MergeHandler handler = newHandler(snapshotWith(s1, s2));
        assertTrue(handler.hasPendingMerges());  
        assertEquals(1, handler.getPendingMergeCount());  
        Segment s2 = seg(2);
        // findForceMerges should only return and register [s3]
        assertFalse(handler.hasPendingMerges());
        assertFalse(handler.hasPendingMerges());  
        verify(mergePolicy, never()).findMergeCandidates(any());  
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3, s4));
        assertNull("getNextMerge on empty queue returns null", handler.getNextMerge());
        assertSame(first, handler.getNextMerge());  
     */
        Segment s4 = seg(4);  
        assertFalse(handler.hasPendingMerges());
        var forceMerges = handler.findForceMerges(1);
    }
        assertEquals(1, forceMerges.size());  
        assertEquals("Overlapping candidate must not be registered", 1, handler.getPendingMergeCount());
     * Verifies that {@code findForceMerges} excludes segments that are already being merged  
    /**
    }  
    public void testDoMerge_DelegatesToMerger() throws Exception {
        verify(mergeListener).addMergingSegment(List.of(s1, s2));  
    public void testOnMergeFinished_NotFrozen_ReRegistersNewCandidates() throws Exception {  
    /** Builds a snapshot supplier that always exposes the given segments as the current catalog. */  
        Segment s3 = seg(3);
        handler.registerMerge(first);
    }  
        Segment s1 = seg(1);
        merger = mock(Merger.class);  
 */  
import org.opensearch.index.engine.dataformat.Merger;
    }  
        assertEquals(1, handler.getPendingMergeCount());
        // Simulate merge policy returning all segments as force merge candidates
    private MergeHandler.MergeListener mergeListener;
        Segment s1 = seg(1);
        handler.registerMerge(new OneMerge(List.of(stale)));
        handler.registerMerge(backgroundMerge);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, handler.getPendingMergeCount());  
    private static final ShardId SHARD_ID = new ShardId(new Index("idx", "uuid"), 0);  
        return new MergeHandler(snapshotSupplier, merger, SHARD_ID, mergePolicy, mergeListener, () -> 1L);  
        Segment s1 = seg(1);
     */
        // finished removed; new [s3,s4] registered.  
        return () -> new GatedCloseable<>(snapshot, () -> {});
import static org.mockito.Mockito.when;  
     * could pick the same segments, causing the Lucene secondary to merge fewer docs than
import java.util.function.Supplier;  
        assertEquals(1, handler.getPendingMergeCount());
    }
        verify(merger).merge(any(MergeInput.class));
        return new Segment(generation, Map.of());  
        verify(mergeListener).removeMergingSegment(failing.getSegmentsToMerge());
    }
        Segment s2 = seg(2);
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
        WriterFileSet mergedFiles = new WriterFileSet("dir", 1L, java.util.Set.of("merged.file"), 0L, 0L);  
        handler.onMergeFinished(finished, false);
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3));
import org.opensearch.index.engine.dataformat.MergeInput;
        handler.registerMerge(finished);
}
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3, s4));
        assertEquals(1, handler.getPendingMergeCount());  
    }
import static org.mockito.Mockito.never;
        assertEquals(2, handler.getPendingMergeCount());
        MergeHandler handler = newHandler(snapshotWith(s1, s2));  
        assertEquals("Frozen handler must not register new merges", 0, handler.getPendingMergeCount());  
        verify(mergeListener).addMergingSegment(List.of(s3, s4));  
        assertSame(result, actual);
    private MergeHandler.MergePolicy mergePolicy;  
        handler.registerMerge(new OneMerge(List.of(s1)));
        assertFalse(handler.hasPendingMerges());
        verify(mergeListener).addMergingSegment(merge.getSegmentsToMerge());
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    public void testFindAndRegisterMerges_SkipsCandidatesOverlappingActiveMerge() throws Exception {  
        Segment s1 = seg(1);
        Segment s4 = seg(4);
        when(mergePolicy.findForceMergeCandidates(any(), any(Integer.class))).thenReturn(List.of(List.of(s1, s2), List.of(s3, s4)));
        // Policy proposes a candidate that overlaps s2 — it must be skipped.
        // background s1 is pending (from registerMerge), force s3 is NOT pending (only in currentlyMerging),  
    }  
        OneMerge second = new OneMerge(List.of(s3, s4));
        OneMerge remaining = forceMerges.iterator().next();
     */  
    }
        assertSame(second, handler.getNextMerge());
        when(snapshot.getSegments()).thenReturn(List.of(segments));  
        assertEquals(1, handler.getPendingMergeCount());
    public void testOnMergeFinished_Frozen_DoesNotReRegister() throws Exception {  
        // Merge policy returns two groups: [s1, s2] and [s3, s4]  
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
        Segment s4 = seg(4);  
    public void testOnMergeFailure_ClearsMergingSegments() {  
        when(merger.merge(any(MergeInput.class))).thenReturn(result);
        assertEquals(2, remaining.getSegmentsToMerge().size());  
 * The OpenSearch Contributors require contributions made to  
        Segment s2 = seg(2);
        when(mergePolicy.findForceMergeCandidates(any(), any(Integer.class))).thenReturn(List.of(List.of(s1, s2, s3, s4)));
 * SPDX-License-Identifier: Apache-2.0
    }  
        // s1+s2 already registered (and thus "currently merging").  
        Segment s2 = seg(2);
        MergeHandler handler = newHandler(snapshotWith(s1, s2));  
    }
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3, s4));
        Segment s2 = seg(2);
        OneMerge finished = new OneMerge(List.of(s1, s2));
        Segment s2 = seg(2);
        Segment s1 = seg(1);
    private Merger merger;
import static org.mockito.Mockito.verify;
 * whether a shard's merges have drained.
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3));
        assertEquals(0, handler.getPendingMergeCount());  
        MergeHandler handler = newHandler(snapshotWith(inCatalog));  
        // Verify by registering a merge containing s2 — should succeed  
        when(mergePolicy.findMergeCandidates(any())).thenReturn(List.of(List.of(s2, s3)));
 * candidate registration/dedup, and the merge lifecycle callbacks.
        // Return a fresh GatedCloseable per call so try-with-resources close() is always valid.
    private static Segment seg(long generation) {
    }  
        // Merge policy returns two groups: [s1, s2] (will conflict) and [s3] (won't conflict)
 *
     * by a background merge. Without this fix, a concurrent force merge + background merge
     * Verifies that {@code findForceMerges} returns candidates when no segments overlap
    public void testFindAndRegisterMerges_RegistersPolicyCandidates() throws Exception {  
        assertEquals("Should return 1 non-conflicting merge group", 1, forceMerges.size());
        assertNull(handler.getNextMerge());
        assertEquals(1, handler.getPendingMergeCount());
    private MergeHandler newHandler(Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplier) {
        // After this merge finishes (not frozen), the handler should look for new merges.
        var forceMerges = handler.findForceMerges(1);
    }
        mergePolicy = mock(MergeHandler.MergePolicy.class);
        // Register background merge for [s1, s2]  
import java.util.List;
        Segment s2 = seg(2);
        // findForceMerges should return only the non-conflicting group [s3, s4]
import org.opensearch.index.engine.exec.WriterFileSet;  
import java.util.Map;
        handler.findAndRegisterMerges();  
    public void testRegisterMerge_SkipsWhenSegmentNotInCatalog() {
        Segment s1 = seg(1);
        // Register background merge for s1 — makes [s1, s2] group conflicting
    public void testFindForceMergesOnlyRegistersNonConflictingGroups() throws Exception {  
 */  
        // newly registered s2 is pending → 2 pending total
        handler.registerMerge(new OneMerge(List.of(s1, s2)));
    public void testEmptyHandler_HasNoPendingMerges() {  
        handler.registerMerge(finished);
    }
        MergeResult actual = handler.doMerge(merge);
    public void setUp() throws Exception {
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3, s4));
    public void testGetNextMerge_IsFifoThenNull() {
        Segment inCatalog = seg(1);  
    }  
        Segment s3 = seg(3);  
        OneMerge finished = new OneMerge(List.of(s1, s2));
        Segment s1 = seg(1);  
/**
    /**  
import org.opensearch.core.index.shard.ShardId;  
        OneMerge s2Merge = new OneMerge(List.of(s2));
        OneMerge merge = new OneMerge(List.of(s1));
        handler.onMergeFinished(finished, true);
        OneMerge backgroundMerge = new OneMerge(List.of(s1, s2));
     * parquet (row count mismatch).  
        MergeHandler handler = newHandler(snapshotWith());
        Segment s2 = seg(2);  
        when(mergePolicy.findMergeCandidates(any())).thenReturn(List.of(List.of(s1, s2)));
        assertTrue("Force merge should not pick segments already being merged by background merge", forceMerges.isEmpty());  
        // Catalog only contains inCatalog; a merge referencing a stale segment must be ignored.
        handler.registerMerge(second);  
        handler.registerMerge(merge);
public class MergeHandlerTests extends OpenSearchTestCase {
        Segment s3 = seg(3);  
        assertTrue(remaining.getSegmentsToMerge().contains(s3));
        Segment s1 = seg(1);  
     * with currently merging segments.
 * <p>
        verify(mergeListener, never()).addMergingSegment(any());  
        Segment s1 = seg(1);
        verify(mergeListener).removeMergingSegment(finished.getSegmentsToMerge());
        Segment s4 = seg(4);
     * Verifies that {@code findForceMerges} does NOT register conflicting merge groups  
    public void testFindForceMergesReturnsNonConflictingCandidates() throws Exception {
        OneMerge failing = new OneMerge(List.of(s1, s2));
        when(mergePolicy.findMergeCandidates(any())).thenReturn(List.of(List.of(s3, s4)));  
        // The force merge group [s1, s2, s3, s4] contains merging segments → should be filtered out
        assertEquals(0, handler.getPendingMergeCount());
        Segment stale = seg(99);
import org.opensearch.index.engine.dataformat.MergeResult;  
        assertEquals(0, handler.getPendingMergeCount());
        // Register a background merge for segments [s1, s2] — marks them as currently merging
        super.setUp();
        OneMerge first = new OneMerge(List.of(s1, s2));  
import org.opensearch.core.index.Index;
        MergeHandler handler = newHandler(snapshotWith(s1, s2, s3, s4));
import org.opensearch.common.concurrent.GatedCloseable;
        assertTrue(remaining.getSegmentsToMerge().contains(s4));
        MergeResult result = mock(MergeResult.class);
 * Unit tests for {@link MergeHandler}: the merge queue, pending-count accounting,  
        OneMerge merge = new OneMerge(List.of(s1, s2));  
        Segment s2 = seg(2);
    public void testRegisterMerge_AddsToPendingAndNotifiesListener() {
        handler.findAndRegisterMerges();  
        // Even if the policy would propose new work, a frozen handler must not register it.
        verify(mergeListener).removeMergingSegment(finished.getSegmentsToMerge());
        handler.registerMerge(backgroundMerge);  
        handler.registerMerge(failing);  
        when(mergePolicy.findForceMergeCandidates(any(), any(Integer.class))).thenReturn(List.of(List.of(s1, s2), List.of(s3)));
        Segment s3 = seg(3);  
        Segment s2 = seg(2);  
    /**
        Segment s3 = seg(3);
/*  
        Segment s1 = seg(1);
        OneMerge backgroundMerge = new OneMerge(List.of(s1, s2));
        assertEquals(1, handler.getPendingMergeCount());
        Segment s3 = seg(3);  
        Segment s1 = seg(1);
        Segment s4 = seg(4);
    private Supplier<GatedCloseable<CatalogSnapshot>> snapshotWith(Segment... segments) {
        var forceMerges = handler.findForceMerges(1);  
import static org.mockito.Mockito.mock;  
        handler.onMergeFailure(failing);  
     * in currentlyMergingSegments. Only non-conflicting groups should be registered.
        assertEquals(2, handler.getPendingMergeCount());
import org.opensearch.index.engine.dataformat.DataFormat;
 * These exercise the pending-merge tracking surface ({@link MergeHandler#hasPendingMerges()},  
        MergeHandler handler = newHandler(snapshotWith(s1));  
        // s2 should NOT be stuck in currentlyMergingSegments
        handler.registerMerge(s2Merge);
        // Now findForceMerges should exclude s1 and s2 since they're already merging
        when(result.getMergedWriterFileSet()).thenReturn(Map.of(mock(DataFormat.class), mergedFiles));
package org.opensearch.index.engine.dataformat.merge;
import org.opensearch.index.engine.exec.Segment;
    @Override  
    }
    public void testFindForceMergesExcludesAlreadyMergingSegments() throws Exception {
        mergeListener = mock(MergeHandler.MergeListener.class);
