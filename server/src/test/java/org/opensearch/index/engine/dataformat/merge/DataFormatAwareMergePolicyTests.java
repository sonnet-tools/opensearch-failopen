            WriterFileSet wfs = new WriterFileSet(tempDir.toString(), i, Set.of("cseg" + i + ".dat"), 10, 0L);
        Segment seg3 = Segment.builder(3L).addSearchableFiles(fmt, new WriterFileSet(tempDir.toString(), 3L, Set.of(), 30, 0L)).build();
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
import org.opensearch.index.engine.exec.Segment;
        ArgumentCaptor<SegmentInfos> segInfosCaptor = ArgumentCaptor.forClass(SegmentInfos.class);
        assertEquals(2, capturedSegmentsToMerge.size());
        policy.findMergeCandidates(allSegments);
        policy.findMergeCandidates(allSegments);
        done.await();
            segments.add(Segment.builder(i).addSearchableFiles(fmt, wfs).build());
        // Round 3: add seg3, seg4 — expect 3 merging (seg2 still there)
public class DataFormatAwareMergePolicyTests extends OpenSearchTestCase {
        for (List<Segment> group : result) {
        // Round 5: re-add seg1 — expect 2 merging (seg4, seg1)
        assertNull("Concurrent add/remove should not throw, but got: " + failure.get(), failure.get());
        Segment seg = Segment.builder(1L).addSearchableFiles(fmt1, wfs1).addSearchableFiles(fmt2, wfs2).build();
    }
                }
            try {
            new RuntimeException("merge error")
        when(lucenePolicy.findMerges(any(MergeTrigger.class), segInfosCaptor.capture(), any(MergePolicy.MergeContext.class))).thenReturn(
    public void testMergeContextTracksMultipleAddRemoveCycles() throws IOException {
import org.apache.lucene.index.MergePolicy;
import java.nio.file.Path;
import java.util.concurrent.CountDownLatch;
        ArgumentCaptor<Map<SegmentCommitInfo, Boolean>> segmentsToMergeCaptor = ArgumentCaptor.forClass(Map.class);
    public void testFindForceMergeCandidatesWithRealPolicyReturnsMerges() throws IOException {
        Path tempDir = createTempDir();
        List<Segment> segments = new ArrayList<>();
        assertEquals(0, capturedCtx.numDeletedDocs(mock(SegmentCommitInfo.class)));
        // Remove seg2 — context should be empty
import java.util.ArrayList;
        policy.findMergeCandidates(allSegments);
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
        RuntimeException ex = expectThrows(RuntimeException.class, () -> policy.findForceMergeCandidates(Collections.emptyList(), 1));
        }
                barrier.await();
        policy.findMergeCandidates(allSegments);
        MergePolicy lucenePolicy = mock(MergePolicy.class);
        policy.findMergeCandidates(allSegments);
        assertNotNull(capturedCtx.getInfoStream());
        AtomicReference<Exception> failure = new AtomicReference<>();
    }
        adder.start();
                failure.compareAndSet(null, e);
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
        }
        assertTrue(result.isEmpty());
        assertTrue(ctxCaptor.getValue().getMergingSegments().isEmpty());
    public void testConcurrentFindMergeCandidatesAndAddMergingSegment() throws Exception {
        List<List<Segment>> result = policy.findForceMergeCandidates(List.of(seg1, seg2), 1);
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(tieredPolicy, SHARD_ID);
        policy.addMergingSegment(List.of(seg1));
    // ========== findForceMergeCandidates ==========
        WriterFileSet wfs1 = new WriterFileSet(tempDir.toString(), 1L, Set.of(), 10, 0L);
            } finally {
/**
        when(lucenePolicy.findMerges(any(MergeTrigger.class), segInfosCaptor.capture(), ctxCaptor.capture())).thenReturn(null);
            try {
        List<List<Segment>> result = policy.findForceMergeCandidates(segments, 1);
        Thread mutator = new Thread(() -> {
 *
        // Round 9: single remove clears the duplicate — expect 0
        assertEquals(1, ctxCaptor.getValue().getMergingSegments().size());
        policy.addMergingSegment(List.of(seg1, seg2));
        List<Segment> segments = new ArrayList<>();
import org.apache.lucene.index.SegmentInfos;
import java.util.concurrent.atomic.AtomicReference;
/*
        assertEquals(1, ctxCaptor.getValue().getMergingSegments().size());
            segments.add(Segment.builder(i).addSearchableFiles(fmt, wfs).build());
                done.countDown();
    public void testFindMergeCandidatesWithRealPolicyReturnsMerges() throws IOException {
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
    public void testFindForceMergeCandidatesCapturesMergeContext() throws IOException {
        MergePolicy lucenePolicy = mock(MergePolicy.class);
        assertEquals(0, capturedCtx.numDeletesToMerge(mock(SegmentCommitInfo.class)));
 */
    }
                failure.compareAndSet(null, e);
        policy.findMergeCandidates(allSegments);
        assertTrue(ctxCaptor.getValue().getMergingSegments().isEmpty());
        SegmentInfos capturedInfos = segInfosCaptor.getValue();
            }
        WriterFileSet wfs2 = new WriterFileSet(tempDir.toString(), 1L, Set.of(), 20, 0L);
            try {
        ArgumentCaptor<MergePolicy.MergeContext> ctxCaptor = ArgumentCaptor.forClass(MergePolicy.MergeContext.class);
            org.apache.logging.log4j.LogManager.getLogger(getClass())
        policy.findMergeCandidates(allSegments);
                barrier.await();
        MergePolicy.MergeContext capturedCtx = ctxCaptor.getValue();
    public void testFindMergeCandidatesMergeContextReflectsAddedAndRemovedSegments() throws IOException {
            }
        policy.findMergeCandidates(allSegments);
        when(lucenePolicy.findMerges(any(MergeTrigger.class), any(SegmentInfos.class), ctxCaptor.capture())).thenReturn(null);
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
        }
        assertNotNull(capturedCtx.getInfoStream());
        assertEquals(1, ctxCaptor.getValue().getMergingSegments().size());
        when(lucenePolicy.findForcedMerges(any(SegmentInfos.class), anyInt(), any(Map.class), any(MergePolicy.MergeContext.class)))
        Path tempDir = createTempDir();
        ArgumentCaptor<SegmentInfos> segInfosCaptor = ArgumentCaptor.forClass(SegmentInfos.class);
            Files.write(file, new byte[100]);
            } catch (Exception e) {
        for (int i = 0; i < 15; i++) {
        WriterFileSet wfs = new WriterFileSet(tempDir.toString(), 1L, Set.of(), 10, 0L);
        ArgumentCaptor<SegmentInfos> segInfosCaptor = ArgumentCaptor.forClass(SegmentInfos.class);
            Path file = tempDir.resolve("cseg" + i + ".dat");
            Path file = tempDir.resolve("fseg" + i + ".dat");
        // Round 1: add seg1, seg2 — expect 2 merging
        Map<SegmentCommitInfo, Boolean> capturedSegmentsToMerge = segmentsToMergeCaptor.getValue();
        // Remove seg1 — context should show 1
 * Tests for {@link DataFormatAwareMergePolicy}.
                for (int i = 0; i < 100; i++) {
        policy.findMergeCandidates(List.of(seg));
import org.opensearch.index.engine.exec.WriterFileSet;
        );
    public void testFindMergeCandidatesCapturesMergeContext() throws IOException {
        Thread remover = new Thread(() -> {
import java.io.IOException;
        when(lucenePolicy.findMerges(any(MergeTrigger.class), segInfosCaptor.capture(), any(MergePolicy.MergeContext.class))).thenReturn(
import static org.mockito.ArgumentMatchers.anyInt;
            .thenReturn(null);
        assertEquals(2, ctxCaptor.getValue().getMergingSegments().size());
        List<Segment> allSegments = List.of(seg1, seg2, seg3, seg4);
        policy.addMergingSegment(List.of(seg2));
    }
    // ========== MergeContext immutability ==========
        // Round 6: remove all — expect 0
    // ========== findMergeCandidates ==========
        Thread finder = new Thread(() -> {
        MergePolicy.MergeContext capturedCtx = ctxCaptor.getValue();
        Segment seg1 = Segment.builder(1L).addSearchableFiles(fmt, wfs).build();
        policy.findMergeCandidates(allSegments);
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
        List<List<Segment>> result = policy.findMergeCandidates(segments);
                barrier.await();
        assertTrue(capturedCtx.getMergingSegments().isEmpty());
        Path tempDir = createTempDir();
        MergePolicy lucenePolicy = mock(MergePolicy.class);
        policy.removeMergingSegment(List.of(seg1));
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
                done.countDown();
import java.util.List;
        when(lucenePolicy.findMerges(any(MergeTrigger.class), any(SegmentInfos.class), any(MergePolicy.MergeContext.class))).thenThrow(
        List<Segment> segments = new ArrayList<>();
        Path tempDir = createTempDir();
        when(lucenePolicy.findMerges(any(MergeTrigger.class), any(SegmentInfos.class), ctxCaptor.capture())).thenReturn(null);
            try {
            } catch (Exception e) {
        Segment seg2 = Segment.builder(2L).addSearchableFiles(fmt, wfs).build();
    public void testFindMergeCandidatesExceptionWrapped() throws IOException {
    public void testGetMergingSegmentsIsUnmodifiable() {
        // Round 4: remove seg2, seg3 — expect 1 merging (seg4)
        done.await();
        Segment seg1 = Segment.builder(1L).addSearchableFiles(fmt, wfs1).build();
        MergePolicy lucenePolicy = mock(MergePolicy.class);
    }
        List<Segment> segments = new ArrayList<>();
import org.mockito.ArgumentCaptor;
        );
        // Round 2: remove seg1 — expect 1 merging
        Segment seg = Segment.builder(1L).build();
        ArgumentCaptor<MergePolicy.MergeContext> ctxCaptor = ArgumentCaptor.forClass(MergePolicy.MergeContext.class);
        TieredMergePolicy tieredPolicy = new TieredMergePolicy();
            WriterFileSet wfs = new WriterFileSet(tempDir.toString(), i, Set.of("seg" + i + ".dat"), 10, 0L);
        TieredMergePolicy tieredPolicy = new TieredMergePolicy();
            }
        policy.addMergingSegment(List.of(seg2));
        policy.findMergeCandidates(allSegments);
        CyclicBarrier barrier = new CyclicBarrier(2);
                failure.compareAndSet(null, e);
        assertNotNull(result);
        assertEquals(2, ctxCaptor.getValue().getMergingSegments().size());
                }
        mutator.start();
                    policy.addMergingSegment(List.of(seg));
                    Segment seg = segments.get(i % segments.size());
        policy.removeMergingSegment(List.of(seg2));
    }
        TieredMergePolicy tieredPolicy = new TieredMergePolicy();
    public void testConcurrentAddRemoveDoesNotThrow() throws Exception {
        MergePolicy lucenePolicy = mock(MergePolicy.class);
    // ========== Complex add/remove/add/remove lifecycle ==========
        policy.addMergingSegment(List.of(seg1));
        assertEquals(2, capturedInfos.size());
import java.util.Map;
        Path tempDir = createTempDir();
        Segment seg4 = Segment.builder(4L).addSearchableFiles(fmt, new WriterFileSet(tempDir.toString(), 4L, Set.of(), 40, 0L)).build();
    public void testSegmentWithMultipleFormatsAggregatesDocCountAndSize() throws IOException {
        policy.removeMergingSegment(List.of(seg1));
        );
        });
        WriterFileSet wfs2 = new WriterFileSet(tempDir.toString(), 2L, Set.of(), 20, 0L);
                    policy.removeMergingSegment(List.of(segments.get(i % numSegments)));
        assertEquals(2, capturedInfos.size());
            Files.write(file, new byte[100]);
        assertTrue(ctxCaptor.getValue().getMergingSegments().isEmpty());
        assertEquals(1, segInfosCaptor.getValue().size());
        }
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
        when(lucenePolicy.findForcedMerges(segInfosCaptor.capture(), anyInt(), segmentsToMergeCaptor.capture(), ctxCaptor.capture()))
        });
    public void testSegmentWithNoSearchableFiles() throws IOException {
import static org.mockito.ArgumentMatchers.any;
        assertNotNull(result);
        assertFalse("TieredMergePolicy should find merge candidates with 15 small segments", result.isEmpty());
        // Add seg2 as merging — context should show 2
    @SuppressWarnings("unchecked")
        Segment seg2 = Segment.builder(2L).addSearchableFiles(fmt, wfs).build();
    // ========== Edge cases ==========
                failure.compareAndSet(null, e);
        Path tempDir = createTempDir();
    // ========== Real TieredMergePolicy ==========
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
}
        assertTrue(ctxCaptor.getValue().getMergingSegments().isEmpty());
package org.opensearch.index.engine.dataformat.merge;
                }
        // Round 8: add duplicate — should still be 1 (set semantics)
        assertNull("Concurrent findMergeCandidates and addMergingSegment should not throw, but got: " + failure.get(), failure.get());
import org.opensearch.core.index.shard.ShardId;
        }
    }
    // ========== Concurrency ==========
        // Add seg1 as merging — context should show 1
        assertEquals(1, ctxCaptor.getValue().getMergingSegments().size());
        List<List<Segment>> result = policy.findMergeCandidates(List.of(seg1, seg2));
    }
        ArgumentCaptor<SegmentInfos> segInfosCaptor = ArgumentCaptor.forClass(SegmentInfos.class);
        RuntimeException ex = expectThrows(RuntimeException.class, () -> policy.findMergeCandidates(Collections.emptyList()));
        policy.findMergeCandidates(allSegments);
        policy.removeMergingSegment(List.of(seg1));
    public void testFindForceMergeCandidatesExceptionWrapped() throws IOException {
            WriterFileSet wfs = new WriterFileSet(tempDir.toString(), i, Set.of(), 10, 0L);
    }
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(tieredPolicy, SHARD_ID);
            } catch (Exception e) {
        MergePolicy lucenePolicy = mock(MergePolicy.class);
        assertTrue("All segments should be marked for merge", capturedSegmentsToMerge.values().stream().allMatch(v -> v));
        CountDownLatch done = new CountDownLatch(2);
        finder.start();
        Path tempDir = createTempDir();
import org.apache.lucene.index.TieredMergePolicy;
        assertFalse("Force merge to 1 segment should produce candidates from 5 segments", result.isEmpty());
            } catch (Exception e) {
                    policy.removeMergingSegment(List.of(seg));
        Set<SegmentCommitInfo> mergingSegments = ctx.getMergingSegments();
        AtomicReference<Exception> failure = new AtomicReference<>();
                    policy.findMergeCandidates(segments);
        ArgumentCaptor<MergePolicy.MergeContext> ctxCaptor = ArgumentCaptor.forClass(MergePolicy.MergeContext.class);
            segments.add(Segment.builder(i).addSearchableFiles(fmt, wfs).build());
        assertEquals("Error finding merge candidates", ex.getMessage());
    }
            segments.add(Segment.builder(i).addSearchableFiles(fmt, wfs).build());
        policy.addMergingSegment(List.of(seg3, seg4));
import java.util.Collections;
                done.countDown();
        remover.start();
    @SuppressWarnings("unchecked")
                    policy.addMergingSegment(List.of(segments.get(i % numSegments)));
        MergePolicy lucenePolicy = mock(MergePolicy.class);
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(tieredPolicy, SHARD_ID);
        assertEquals(1, ctxCaptor.getValue().getMergingSegments().size());
        Path tempDir = createTempDir();
            assertFalse(group.isEmpty());
        assertEquals(3, ctxCaptor.getValue().getMergingSegments().size());
        WriterFileSet wfs = new WriterFileSet(tempDir.toString(), 1L, Set.of(), 10, 0L);
        for (int i = 0; i < 15; i++) {
        DataFormatAwareMergePolicy.DataFormatMergeContext ctx = new DataFormatAwareMergePolicy.DataFormatMergeContext(
import static org.mockito.Mockito.mock;
        policy.addMergingSegment(List.of(seg2));
    }
        for (int i = 0; i < 5; i++) {
 * this file be licensed under the Apache-2.0 license or a
        policy.removeMergingSegment(List.of(seg1, seg4));
            } finally {
        policy.removeMergingSegment(List.of(seg2));
import java.nio.file.Files;
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
        Segment seg2 = Segment.builder(2L).addSearchableFiles(fmt, new WriterFileSet(tempDir.toString(), 2L, Set.of(), 20, 0L)).build();
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
        policy.findMergeCandidates(List.of(seg));
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
import java.util.concurrent.CyclicBarrier;
        Path tempDir = createTempDir();
        SegmentInfos capturedInfos = segInfosCaptor.getValue();
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
            }
        Thread adder = new Thread(() -> {
import static org.mockito.Mockito.when;
                for (int i = 0; i < 100; i++) {
        MockDataFormat fmt2 = new MockDataFormat("columnar", 50L, Set.of());
        ArgumentCaptor<MergePolicy.MergeContext> ctxCaptor = ArgumentCaptor.forClass(MergePolicy.MergeContext.class);
        CountDownLatch done = new CountDownLatch(2);
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
        assertTrue(capturedCtx.getMergingSegments().isEmpty());
        for (int i = 0; i < numSegments; i++) {
 * SPDX-License-Identifier: Apache-2.0
                done.countDown();
                barrier.await();
        policy.findMergeCandidates(allSegments);
        MergePolicy lucenePolicy = mock(MergePolicy.class);
            Path file = tempDir.resolve("seg" + i + ".dat");
        assertEquals(2, ctxCaptor.getValue().getMergingSegments().size());
            Files.write(file, new byte[100]);
            } finally {
import java.util.Set;
        assertEquals("Error finding force merge candidates", ex.getMessage());
import org.opensearch.core.index.Index;
        });
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
        assertTrue(result.isEmpty());
        policy.removeMergingSegment(List.of(seg2, seg3));
        int numSegments = 50;
        Segment seg1 = Segment.builder(1L).addSearchableFiles(fmt, new WriterFileSet(tempDir.toString(), 1L, Set.of(), 10, 0L)).build();
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
    }
        SegmentInfos capturedInfos = segInfosCaptor.getValue();
                for (int i = 0; i < 50; i++) {
        List<Segment> allSegments = List.of(seg1, seg2, seg3);
 */
        WriterFileSet wfs1 = new WriterFileSet(tempDir.toString(), 1L, Set.of(), 10, 0L);
        assertEquals(1, capturedInfos.size());
        // Round 7: remove already-removed segment is a no-op — still 0
        policy.findMergeCandidates(allSegments);
import org.apache.lucene.index.MergeTrigger;
            WriterFileSet wfs = new WriterFileSet(tempDir.toString(), i, Set.of("fseg" + i + ".dat"), 10, 0L);
import org.apache.lucene.index.SegmentCommitInfo;
        MockDataFormat fmt1 = new MockDataFormat("lucene", 100L, Set.of());
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
        CyclicBarrier barrier = new CyclicBarrier(2);
            null
        Segment seg2 = Segment.builder(2L).addSearchableFiles(fmt, wfs2).build();
        );
            .thenThrow(new RuntimeException("force merge error"));
 * The OpenSearch Contributors require contributions made to
            null
    }
        MergePolicy lucenePolicy = mock(MergePolicy.class);
                }
    private static final ShardId SHARD_ID = new ShardId(new Index("test-index", "uuid"), 0);
                for (int i = 0; i < 50; i++) {
            } finally {
        expectThrows(UnsupportedOperationException.class, () -> mergingSegments.add(mock(SegmentCommitInfo.class)));
        });
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
        Segment seg3 = Segment.builder(3L).addSearchableFiles(fmt, wfs1).build();
        Segment seg1 = Segment.builder(1L).addSearchableFiles(fmt, wfs).build();
