        SegmentInfos capturedInfos = segInfosCaptor.getValue();
        policy.findMergeCandidates(allSegments);  
        policy.removeMergingSegment(List.of(seg1));
        WriterFileSet wfs1 = new WriterFileSet(tempDir.toString(), 1L, Set.of(), 10, 0L);  
        Segment seg4 = Segment.builder(4L).addSearchableFiles(fmt, new WriterFileSet(tempDir.toString(), 4L, Set.of(), 40, 0L)).build();
        assertNotNull(capturedCtx.getInfoStream());
                failure.compareAndSet(null, e);
import java.io.IOException;
            Files.write(file, new byte[100]);
        for (int i = 0; i < 15; i++) {
        TieredMergePolicy tieredPolicy = new TieredMergePolicy();  
        policy.addMergingSegment(List.of(seg1));
        assertEquals("Error finding merge candidates", ex.getMessage());
        WriterFileSet wfs = new WriterFileSet(tempDir.toString(), 1L, Set.of(), 10, 0L);
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);  
        ArgumentCaptor<MergePolicy.MergeContext> ctxCaptor = ArgumentCaptor.forClass(MergePolicy.MergeContext.class);
        policy.findMergeCandidates(allSegments);
        policy.addMergingSegment(List.of(seg2));
    }
        when(lucenePolicy.findForcedMerges(any(SegmentInfos.class), anyInt(), any(Map.class), any(MergePolicy.MergeContext.class)))  
import java.nio.file.Files;
            WriterFileSet wfs = new WriterFileSet(tempDir.toString(), i, Set.of("cseg" + i + ".dat"), 10, 0L);
        policy.findMergeCandidates(List.of(seg));
                barrier.await();  
import java.util.Set;
        done.await();
            org.apache.logging.log4j.LogManager.getLogger(getClass())
    @SuppressWarnings("unchecked")
        assertEquals(2, capturedSegmentsToMerge.size());
        when(lucenePolicy.findMerges(any(MergeTrigger.class), segInfosCaptor.capture(), ctxCaptor.capture())).thenReturn(null);  
        assertEquals(2, ctxCaptor.getValue().getMergingSegments().size());  
    }  
                    policy.removeMergingSegment(List.of(segments.get(i % numSegments)));
        assertEquals(2, ctxCaptor.getValue().getMergingSegments().size());
            } finally {  
        policy.removeMergingSegment(List.of(seg1, seg4));  
        assertEquals(3, ctxCaptor.getValue().getMergingSegments().size());
package org.opensearch.index.engine.dataformat.merge;
        adder.start();
        policy.addMergingSegment(List.of(seg1, seg2));
        SegmentInfos capturedInfos = segInfosCaptor.getValue();  
    public void testConcurrentFindMergeCandidatesAndAddMergingSegment() throws Exception {  
                for (int i = 0; i < 100; i++) {  
                    policy.removeMergingSegment(List.of(seg));
        Segment seg1 = Segment.builder(1L).addSearchableFiles(fmt, new WriterFileSet(tempDir.toString(), 1L, Set.of(), 10, 0L)).build();
        // Round 3: add seg3, seg4 — expect 3 merging (seg2 still there)
        MockDataFormat fmt2 = new MockDataFormat("columnar", 50L, Set.of());
        expectThrows(UnsupportedOperationException.class, () -> mergingSegments.add(mock(SegmentCommitInfo.class)));
        assertEquals(0, capturedCtx.numDeletesToMerge(mock(SegmentCommitInfo.class)));
        when(lucenePolicy.findMerges(any(MergeTrigger.class), any(SegmentInfos.class), any(MergePolicy.MergeContext.class))).thenThrow(
        MergePolicy lucenePolicy = mock(MergePolicy.class);
            Path file = tempDir.resolve("cseg" + i + ".dat");  
        assertNull("Concurrent findMergeCandidates and addMergingSegment should not throw, but got: " + failure.get(), failure.get());  
        AtomicReference<Exception> failure = new AtomicReference<>();  
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;  
/*  
        ArgumentCaptor<MergePolicy.MergeContext> ctxCaptor = ArgumentCaptor.forClass(MergePolicy.MergeContext.class);
            Files.write(file, new byte[100]);  
        }  
import org.opensearch.test.OpenSearchTestCase;
        List<Segment> allSegments = List.of(seg1, seg2, seg3);
        // Round 6: remove all — expect 0
                failure.compareAndSet(null, e);
        );
            try {
        assertNotNull(capturedCtx.getInfoStream());
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);  
import org.apache.lucene.index.MergeTrigger;
            Files.write(file, new byte[100]);
        Path tempDir = createTempDir();
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(tieredPolicy, SHARD_ID);
        DataFormatAwareMergePolicy.DataFormatMergeContext ctx = new DataFormatAwareMergePolicy.DataFormatMergeContext(  
        List<Segment> segments = new ArrayList<>();  
        Path tempDir = createTempDir();  
                barrier.await();
                }  
}
        MockDataFormat fmt1 = new MockDataFormat("lucene", 100L, Set.of());
    public void testFindForceMergeCandidatesExceptionWrapped() throws IOException {
            .thenReturn(null);
            Path file = tempDir.resolve("seg" + i + ".dat");  
    public void testGetMergingSegmentsIsUnmodifiable() {
        assertEquals(1, ctxCaptor.getValue().getMergingSegments().size());
        assertTrue(ctxCaptor.getValue().getMergingSegments().isEmpty());  
        assertTrue(capturedCtx.getMergingSegments().isEmpty());  
    public void testFindMergeCandidatesWithRealPolicyReturnsMerges() throws IOException {  
        Segment seg = Segment.builder(1L).addSearchableFiles(fmt1, wfs1).addSearchableFiles(fmt2, wfs2).build();
        for (List<Segment> group : result) {  
        CountDownLatch done = new CountDownLatch(2);
            WriterFileSet wfs = new WriterFileSet(tempDir.toString(), i, Set.of(), 10, 0L);
        policy.findMergeCandidates(allSegments);
    }
        TieredMergePolicy tieredPolicy = new TieredMergePolicy();
        ArgumentCaptor<MergePolicy.MergeContext> ctxCaptor = ArgumentCaptor.forClass(MergePolicy.MergeContext.class);  
    }
    // ========== Concurrency ==========
        });  
        CyclicBarrier barrier = new CyclicBarrier(2);  
        Path tempDir = createTempDir();
        MergePolicy lucenePolicy = mock(MergePolicy.class);
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
        List<Segment> segments = new ArrayList<>();
        List<List<Segment>> result = policy.findMergeCandidates(segments);  
        done.await();
        Segment seg1 = Segment.builder(1L).addSearchableFiles(fmt, wfs).build();  
        finder.start();
            assertFalse(group.isEmpty());
            } catch (Exception e) {
    }
        policy.addMergingSegment(List.of(seg3, seg4));  
        Map<SegmentCommitInfo, Boolean> capturedSegmentsToMerge = segmentsToMergeCaptor.getValue();  
        );
import java.util.Map;
    public void testFindForceMergeCandidatesCapturesMergeContext() throws IOException {
 * The OpenSearch Contributors require contributions made to  
        }
                }
        policy.findMergeCandidates(allSegments);
        assertNotNull(result);  
        policy.addMergingSegment(List.of(seg2));
        }  
    }
        List<Segment> allSegments = List.of(seg1, seg2, seg3, seg4);
        RuntimeException ex = expectThrows(RuntimeException.class, () -> policy.findMergeCandidates(Collections.emptyList()));
                done.countDown();
        MergePolicy.MergeContext capturedCtx = ctxCaptor.getValue();
                barrier.await();  
                done.countDown();
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
        assertEquals("Error finding force merge candidates", ex.getMessage());
 *
        assertTrue(result.isEmpty());
            segments.add(Segment.builder(i).addSearchableFiles(fmt, wfs).build());  
            .thenThrow(new RuntimeException("force merge error"));
        ArgumentCaptor<MergePolicy.MergeContext> ctxCaptor = ArgumentCaptor.forClass(MergePolicy.MergeContext.class);  
    }
        Segment seg1 = Segment.builder(1L).addSearchableFiles(fmt, wfs).build();  
import java.util.Collections;
import org.apache.lucene.index.SegmentCommitInfo;  
            Path file = tempDir.resolve("fseg" + i + ".dat");
        Path tempDir = createTempDir();
        ArgumentCaptor<SegmentInfos> segInfosCaptor = ArgumentCaptor.forClass(SegmentInfos.class);
public class DataFormatAwareMergePolicyTests extends OpenSearchTestCase {
        // Round 8: add duplicate — should still be 1 (set semantics)  
        policy.findMergeCandidates(allSegments);
        WriterFileSet wfs2 = new WriterFileSet(tempDir.toString(), 1L, Set.of(), 20, 0L);
        assertEquals(1, ctxCaptor.getValue().getMergingSegments().size());
        policy.removeMergingSegment(List.of(seg1));
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
import org.opensearch.index.engine.exec.WriterFileSet;
    // ========== Complex add/remove/add/remove lifecycle ==========
        policy.findMergeCandidates(allSegments);
        MergePolicy lucenePolicy = mock(MergePolicy.class);
        Thread remover = new Thread(() -> {
                    policy.addMergingSegment(List.of(seg));
    }  
        when(lucenePolicy.findMerges(any(MergeTrigger.class), segInfosCaptor.capture(), any(MergePolicy.MergeContext.class))).thenReturn(  
        List<List<Segment>> result = policy.findForceMergeCandidates(segments, 1);
        Path tempDir = createTempDir();  
        assertNull("Concurrent add/remove should not throw, but got: " + failure.get(), failure.get());  
        MergePolicy lucenePolicy = mock(MergePolicy.class);
import org.apache.lucene.index.MergePolicy;
            } catch (Exception e) {  
        TieredMergePolicy tieredPolicy = new TieredMergePolicy();
            } finally {  
        policy.removeMergingSegment(List.of(seg1));
        when(lucenePolicy.findForcedMerges(segInfosCaptor.capture(), anyInt(), segmentsToMergeCaptor.capture(), ctxCaptor.capture()))
                done.countDown();  
        CyclicBarrier barrier = new CyclicBarrier(2);
 * Tests for {@link DataFormatAwareMergePolicy}.  
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
        mutator.start();  
            WriterFileSet wfs = new WriterFileSet(tempDir.toString(), i, Set.of("fseg" + i + ".dat"), 10, 0L);
        policy.removeMergingSegment(List.of(seg2));
        ArgumentCaptor<Map<SegmentCommitInfo, Boolean>> segmentsToMergeCaptor = ArgumentCaptor.forClass(Map.class);
    }
        ArgumentCaptor<SegmentInfos> segInfosCaptor = ArgumentCaptor.forClass(SegmentInfos.class);  
        policy.findMergeCandidates(allSegments);
    // ========== MergeContext immutability ==========  
        CountDownLatch done = new CountDownLatch(2);
        MergePolicy lucenePolicy = mock(MergePolicy.class);  
import java.util.ArrayList;
        assertEquals(1, capturedInfos.size());
                    policy.findMergeCandidates(segments);
            } finally {  
            try {  
 * this file be licensed under the Apache-2.0 license or a
        Segment seg2 = Segment.builder(2L).addSearchableFiles(fmt, new WriterFileSet(tempDir.toString(), 2L, Set.of(), 20, 0L)).build();
        assertEquals(2, ctxCaptor.getValue().getMergingSegments().size());
            segments.add(Segment.builder(i).addSearchableFiles(fmt, wfs).build());
        for (int i = 0; i < 15; i++) {
        // Round 9: single remove clears the duplicate — expect 0  
import org.apache.lucene.index.SegmentInfos;
        policy.addMergingSegment(List.of(seg2));  
        // Remove seg2 — context should be empty  
import java.util.concurrent.atomic.AtomicReference;
        assertTrue("All segments should be marked for merge", capturedSegmentsToMerge.values().stream().allMatch(v -> v));
        Set<SegmentCommitInfo> mergingSegments = ctx.getMergingSegments();  
            }
        MergePolicy lucenePolicy = mock(MergePolicy.class);
        // Round 4: remove seg2, seg3 — expect 1 merging (seg4)
        );
import java.util.concurrent.CyclicBarrier;
        assertEquals(2, capturedInfos.size());
        MergePolicy.MergeContext capturedCtx = ctxCaptor.getValue();
        WriterFileSet wfs = new WriterFileSet(tempDir.toString(), 1L, Set.of(), 10, 0L);
        List<List<Segment>> result = policy.findMergeCandidates(List.of(seg1, seg2));  
        RuntimeException ex = expectThrows(RuntimeException.class, () -> policy.findForceMergeCandidates(Collections.emptyList(), 1));
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
 */  
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());  
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
            segments.add(Segment.builder(i).addSearchableFiles(fmt, wfs).build());
        Segment seg3 = Segment.builder(3L).addSearchableFiles(fmt, wfs1).build();  
        Path tempDir = createTempDir();  
        policy.addMergingSegment(List.of(seg1));
    // ========== Edge cases ==========
                }  
        assertEquals(1, segInfosCaptor.getValue().size());
                    policy.addMergingSegment(List.of(segments.get(i % numSegments)));
        assertEquals(1, ctxCaptor.getValue().getMergingSegments().size());  
        ArgumentCaptor<SegmentInfos> segInfosCaptor = ArgumentCaptor.forClass(SegmentInfos.class);
    public void testFindMergeCandidatesExceptionWrapped() throws IOException {  
                barrier.await();
        SegmentInfos capturedInfos = segInfosCaptor.getValue();  
        MergePolicy lucenePolicy = mock(MergePolicy.class);
    public void testFindMergeCandidatesCapturesMergeContext() throws IOException {
        Path tempDir = createTempDir();  
        Segment seg1 = Segment.builder(1L).addSearchableFiles(fmt, wfs1).build();
                    Segment seg = segments.get(i % segments.size());  
        int numSegments = 50;
    // ========== findMergeCandidates ==========  
import org.opensearch.core.index.Index;  
        Thread adder = new Thread(() -> {  
        Segment seg = Segment.builder(1L).build();  
                }  
            } finally {
        });  
    @SuppressWarnings("unchecked")  
        Segment seg3 = Segment.builder(3L).addSearchableFiles(fmt, new WriterFileSet(tempDir.toString(), 3L, Set.of(), 30, 0L)).build();  
        Path tempDir = createTempDir();
                done.countDown();
        // Add seg1 as merging — context should show 1  
    }  
        assertTrue(result.isEmpty());
        policy.findMergeCandidates(allSegments);  
        policy.findMergeCandidates(List.of(seg));
    // ========== Real TieredMergePolicy ==========
 */
        List<Segment> segments = new ArrayList<>();
        policy.removeMergingSegment(List.of(seg2, seg3));
    public void testFindForceMergeCandidatesWithRealPolicyReturnsMerges() throws IOException {
        // Round 1: add seg1, seg2 — expect 2 merging
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(tieredPolicy, SHARD_ID);
        });
        when(lucenePolicy.findMerges(any(MergeTrigger.class), segInfosCaptor.capture(), any(MergePolicy.MergeContext.class))).thenReturn(
import org.mockito.ArgumentCaptor;
            try {
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
            null
        // Round 5: re-add seg1 — expect 2 merging (seg4, seg1)  
            } catch (Exception e) {
        );  
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
import org.apache.lucene.index.TieredMergePolicy;
        assertNotNull(result);
    private static final ShardId SHARD_ID = new ShardId(new Index("test-index", "uuid"), 0);
                for (int i = 0; i < 100; i++) {
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);  
        Segment seg2 = Segment.builder(2L).addSearchableFiles(fmt, wfs2).build();
        WriterFileSet wfs2 = new WriterFileSet(tempDir.toString(), 2L, Set.of(), 20, 0L);  
    public void testConcurrentAddRemoveDoesNotThrow() throws Exception {  
            }
    public void testFindMergeCandidatesMergeContextReflectsAddedAndRemovedSegments() throws IOException {
            new RuntimeException("merge error")  
        WriterFileSet wfs1 = new WriterFileSet(tempDir.toString(), 1L, Set.of(), 10, 0L);
        when(lucenePolicy.findMerges(any(MergeTrigger.class), any(SegmentInfos.class), ctxCaptor.capture())).thenReturn(null);  
        }
        assertFalse("Force merge to 1 segment should produce candidates from 5 segments", result.isEmpty());
            }
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
        });  
        // Round 2: remove seg1 — expect 1 merging  
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(tieredPolicy, SHARD_ID);  
            }
        // Remove seg1 — context should show 1
        // Round 7: remove already-removed segment is a no-op — still 0
                for (int i = 0; i < 50; i++) {
    }
import org.opensearch.index.engine.exec.Segment;  
    public void testMergeContextTracksMultipleAddRemoveCycles() throws IOException {
        when(lucenePolicy.findMerges(any(MergeTrigger.class), any(SegmentInfos.class), ctxCaptor.capture())).thenReturn(null);
import java.util.concurrent.CountDownLatch;  
        AtomicReference<Exception> failure = new AtomicReference<>();
            WriterFileSet wfs = new WriterFileSet(tempDir.toString(), i, Set.of("seg" + i + ".dat"), 10, 0L);
        policy.findMergeCandidates(allSegments);
        List<List<Segment>> result = policy.findForceMergeCandidates(List.of(seg1, seg2), 1);
        assertTrue(capturedCtx.getMergingSegments().isEmpty());  
        assertTrue(ctxCaptor.getValue().getMergingSegments().isEmpty());  
        Path tempDir = createTempDir();  
        ArgumentCaptor<SegmentInfos> segInfosCaptor = ArgumentCaptor.forClass(SegmentInfos.class);
                failure.compareAndSet(null, e);
        Thread mutator = new Thread(() -> {
    // ========== findForceMergeCandidates ==========
        policy.findMergeCandidates(allSegments);  
        MergePolicy lucenePolicy = mock(MergePolicy.class);
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
        MockDataFormat fmt = new MockDataFormat("lucene", 100L, Set.of());
        policy.findMergeCandidates(allSegments);  
            segments.add(Segment.builder(i).addSearchableFiles(fmt, wfs).build());  
import java.nio.file.Path;  
        for (int i = 0; i < 5; i++) {
                failure.compareAndSet(null, e);
        assertTrue(ctxCaptor.getValue().getMergingSegments().isEmpty());
            null
        assertFalse("TieredMergePolicy should find merge candidates with 15 small segments", result.isEmpty());
        // Add seg2 as merging — context should show 2
import static org.mockito.ArgumentMatchers.anyInt;
            try {
        policy.findMergeCandidates(allSegments);
        for (int i = 0; i < numSegments; i++) {  
        assertTrue(ctxCaptor.getValue().getMergingSegments().isEmpty());
        assertEquals(2, capturedInfos.size());
import static org.mockito.ArgumentMatchers.any;  
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
                for (int i = 0; i < 50; i++) {
        policy.findMergeCandidates(allSegments);  
        Segment seg2 = Segment.builder(2L).addSearchableFiles(fmt, wfs).build();
        assertEquals(1, ctxCaptor.getValue().getMergingSegments().size());
        remover.start();  
        assertEquals(0, capturedCtx.numDeletedDocs(mock(SegmentCommitInfo.class)));
import java.util.List;  
    }
        assertEquals(1, ctxCaptor.getValue().getMergingSegments().size());  
import org.opensearch.core.index.shard.ShardId;
        MergePolicy lucenePolicy = mock(MergePolicy.class);  
/**
        Segment seg2 = Segment.builder(2L).addSearchableFiles(fmt, wfs).build();
        Thread finder = new Thread(() -> {
    public void testSegmentWithMultipleFormatsAggregatesDocCountAndSize() throws IOException {  
    public void testSegmentWithNoSearchableFiles() throws IOException {
        }
            } catch (Exception e) {
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(lucenePolicy, SHARD_ID);
        List<Segment> segments = new ArrayList<>();
        policy.removeMergingSegment(List.of(seg2));
    }  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
