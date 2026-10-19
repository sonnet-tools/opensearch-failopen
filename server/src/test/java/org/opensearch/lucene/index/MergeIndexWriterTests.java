import org.apache.lucene.document.Field;
        writer.flushLiveDocsForMergedSegment(sci); // must not throw
        writer.commit();
    private void addSegment(String prefix, int numDocs) throws IOException {
            assertEquals(3, reader.numDocs());
            };
        assertTrue(oneMerge.packLiveDocsByGeneration(sci -> 0L).isEmpty());
            Document doc = new Document();
        writer.prepareMerge(new PreparableOneMerge(liveSegments()), gen);
import java.util.List;
    // ========== Helpers ==========
        }
        }
    @SuppressForbidden(reason = "Reflection needed to invoke package-private initMergeReaders from outside org.apache.lucene.index")
            if (e.getCause() instanceof Exception cause) {
        writer.prepareMerge(new PreparableOneMerge(liveSegments()), gen);
        PreparableOneMerge oneMerge = new PreparableOneMerge(segments);
        PreparableOneMerge oneMerge = new PreparableOneMerge(liveSegments());
        }
     * physically dropped early (which would misalign parquet and lucene row ids).
        assertNull("entry must be drained", writer.takePreparedMerge(5L));
        for (int i = 0; i < numDocs; i++) {
        long gen = 13L;
        assertEquals(1, liveSegments().size());
    }
        writer.commit();
    }
            assertTrue(oneMerge.readersInitialized());
    }
            }
 * {@link PreparableOneMerge}.
    // ========== prepareMerge: frozen live-docs snapshot ==========
import java.io.IOException;
    public void testPrepareMergeExposesFrozenLiveDocs() throws IOException {
     *   <li>PHYSICALLY PRESENT in the merged segment — {@code maxDoc} counts it (it was alive at freeze,
        }
        writer.commit();
        writer.deleteDocuments(new Term("id", "a_0"));
 * The OpenSearch Contributors require contributions made to
            writer.close();
        addSegment("a", 2);
        writer.commit();
        DirectoryReader.open(writer).close(); // force-apply buffered deletes
        writer.commit();
        addSegment("c", 1);
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
        writer.commit();
        addSegment("b", 2); // no deletes
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
            m.invoke(oneMerge, factory);
        addSegment("b", 2);
        writer.abortPreparedMerge(12345L);
     * </ul>
        writer.prepareMerge(oneMerge, gen);
            // (MergePolicy.MergeReader is package-private; erasure lets us pass Object here
     *   <li>DEAD via liveDocs — {@code carryOverHardDeletes} marks it deleted on the merged segment, so
        addSegment("a", 2);
    public void testPrepareMergeSnapshotIsFrozenAgainstLaterDeletes() throws IOException {
            "flushLiveDocsForMergedSegment must persist the carried-over delete as a .liv file",
    /** Double-prepare for the same generation trips the guard assertion. */
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
        Map<Long, long[]> before = oneMerge.packLiveDocsByGeneration(bySegmentOrdinal(segments));
        writer.commit();
            writer.abortPreparedMerge(gen);
    // ========== abortPreparedMerge ==========
    /** In-memory deletes on a pooled segment are forced to a .liv file so files() includes it. */
        }
        writer.commit();
    }
import org.apache.lucene.index.NoMergePolicy;
        assertEquals("segments merged into one", 1, liveSegments().size());
        writer.deleteDocuments(new Term("id", "a_2"));
                throw new IOException("factory must not be re-invoked after prepare");
        // A delete arriving between prepare and execute must not alter the frozen snapshot.
    public void tearDown() throws Exception {
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
     * it). This guards the invariant that a mid-merge delete is carried over, not lost and not
        addSegment("a", 2);
        writer.commit();
            assertEquals("carried-over concurrent delete must hide exactly one more doc", 5, reader.numDocs());
        assumeTrue("requires assertions enabled", MergeIndexWriterTests.class.desiredAssertionStatus());
            writer.abortPreparedMerge(gen);
            assertTrue(sci.hasDeletions());
        long gen = 21L;
        // carried over onto the merged segment as a live-docs delete, not a physical drop.
        writer.abortPreparedMerge(gen);
import org.apache.lucene.index.PreparableOneMerge;
        assertEquals(3, writer.liveSegmentCommitInfos().size());
    @Override
        assertEquals(1, liveSegments().size());
import org.apache.lucene.tests.analysis.MockAnalyzer;
        }
    private static void invokeInitMergeReaders(PreparableOneMerge oneMerge, IOFunction<SegmentCommitInfo, Object> factory)
        writer.flushLiveDocsForMergedSegment(merged);
        try {
            assertTrue("no .liv file before the forced flush", sci.files().stream().noneMatch(f -> f.endsWith(".liv")));
     * execute must be:
        PreparableOneMerge taken = writer.takePreparedMerge(gen);
        writer.commit();
        assertEquals("segments merged into one", 1, liveSegments().size());
        assertNull("segment b's late delete must not appear in the frozen snapshot", after.get(1L));
     *       primary format which also copied it;</li>
    // ========== flushLiveDocsForMergedSegment ==========
     *       file set records the deletion.</li>
public class MergeIndexWriterTests extends OpenSearchTestCase {
    /** Keys segments by their ordinal in {@code segments}, mirroring a generation lookup. */
    private MergeIndexWriter writer;
    }
        if (writer != null) {
import org.apache.lucene.index.SerialMergeScheduler;
 * this file be licensed under the Apache-2.0 license or a
    public void testPackLiveDocsByGenerationOmitsDeleteFreeSegments() throws IOException {
        } finally {
    /** No pooled reader state for the segment means no-op. */
    }
            AssertionError err = expectThrows(AssertionError.class, () -> writer.prepareMerge(new PreparableOneMerge(liveSegments()), gen));
import org.apache.lucene.index.SegmentCommitInfo;
            doc.add(new StringField("id", prefix + "_" + i, Field.Store.YES));
            writer.abortPreparedMerge(gen);
        writer.prepareMerge(oneMerge, gen);
        addSegment("b", 2);
        Map<String, Long> byName = new HashMap<>();
    /** takePreparedMerge drains the entry: the second call returns null; unknown generations return null. */
        SegmentCommitInfo merged = liveSegments().get(0);
        addSegment("b", 2);
        // Point-in-time copy: later segment-list changes must not retrofit into an old snapshot.
        long gen = 42L;
        long gen = 71L;
    // ========== executeMerge ==========
        assertFalse(oneMerge.readersInitialized());
        writer.deleteDocuments(new Term("id", "a_0"), new Term("id", "b_1"));
            assertEquals("carried-over delete leaves 3 live docs", 3, reader.numDocs());
    public void testAbortPreparedMergeReleasesStateAndKeepsSegments() throws IOException {
            assertEquals("concurrently-deleted doc must remain physically present in the merged segment", 6, reader.maxDoc());
    /** Adds {@code numDocs} docs with ids {@code prefix_0..} and flushes them into their own segment. */
            assertEquals("merged maxDoc drops only the frozen-dead doc", 4, reader.maxDoc());
import org.apache.lucene.document.Document;
    }
            throw e;
        writer.executeMerge(oneMerge, 11L);
 * compatible open source license.
        writer.executeMerge(taken, gen);
        assertNull(writer.takePreparedMerge(gen));
        writer.prepareMerge(new PreparableOneMerge(liveSegments()), gen);
        try {
import org.apache.lucene.index.DirectoryReader;
            writer.abortPreparedMerge(gen);
        // Idempotent / unknown generation: no-op.
        List<SegmentCommitInfo> segments = liveSegments();
            merged.files().stream().anyMatch(f -> f.endsWith(".liv"))
            // without writing the .liv file — mirroring carryOverHardDeletes after a merge.
        writer.deleteDocuments(new Term("id", "a_1"));
                throw cause;
    public void testFlushLiveDocsForMergedSegmentWritesLivFile() throws IOException {
            assertSame("snapshot must expose live references, not clones", first.get(i), second.get(i));
        writer.executeMerge(taken, 5L);
            // tryDeleteDocument records the delete directly on the pooled ReadersAndUpdates
    public void testPreparableOneMergeBeforeInitialization() throws IOException {
        );
        PreparableOneMerge oneMerge = new PreparableOneMerge(liveSegments());
     */
        assertNull("nothing prepared yet", writer.takePreparedMerge(5L));
        // Execute: mergeMiddle physically drops only the frozen-dead doc; the late delete is
import org.apache.lucene.document.StringField;
            long[] bits = packed.get(0L);
            assertArrayEquals("frozen snapshot must not change for ordinal " + key, before.get(key), after.get(key));
 * SPDX-License-Identifier: Apache-2.0
        } finally {
        assertSame(oneMerge, taken);
    }
import org.apache.lucene.index.IndexWriterConfig;
        addSegment("a", 2);
        PreparableOneMerge taken = writer.takePreparedMerge(5L);
            // a_2 is hidden via the carried-over liveDocs delete → one fewer live doc.
    @Override
    private IndexWriterConfig newConfig() {
        IndexWriterConfig iwc = new IndexWriterConfig(new MockAnalyzer(random()));
    }
            assertEquals("only the segment with deletes contributes a bitmap", 1, packed.size());
        assertTrue("merged segment must record the carried-over deletion", merged.hasDeletions());
            assertEquals("both deleted docs must be physically dropped", 3, reader.maxDoc());
            assertTrue(writer.tryDeleteDocument(reader, 0) >= 0);
        writer.prepareMerge(oneMerge, gen);
        addSegment("a", 2);
/*
    private List<SegmentCommitInfo> liveSegments() throws IOException {
        addSegment("a", 2);
        PreparableOneMerge oneMerge = new PreparableOneMerge(liveSegments());
        }
        addSegment("a", 2);
        try {
    /** Before initialization, readersInitialized is false and packLiveDocsByGeneration is empty. */
    // ========== takePreparedMerge ==========
        super.tearDown();
        writer.prepareMerge(oneMerge, 5L);
        writer.commit();
        assertEquals("aborted merge must not touch source segments", 2, liveSegments().size());
            Map<Long, long[]> packed = oneMerge.packLiveDocsByGeneration(bySegmentOrdinal(segments));
        assertSame(oneMerge, taken);
        long gen = 42L;
        PreparableOneMerge oneMerge = new PreparableOneMerge(liveSegments());
        assertTrue(
        assertEquals(2, segments.size());
        writer.commit();
            assertEquals(1, bits.length);
        } finally {
            assertTrue(oneMerge.packLiveDocsByGeneration(bySegmentOrdinal(liveSegments())).isEmpty());
        addSegment("c", 1);
        }
        DirectoryReader.open(writer).close(); // force-apply the buffered delete
            directory.close();
    private static ToLongFunction<SegmentCommitInfo> bySegmentOrdinal(List<SegmentCommitInfo> segments) {
        try {
        writer.flush();
/**
            assertNotNull("segment a (ordinal 0) has deletes", bits);
        addSegment("a", 2);
    /**
    public void testTakePreparedMergeDrainsEntry() throws IOException {
        List<SegmentCommitInfo> second = writer.liveSegmentCommitInfos();
 *
            IOFunction<SegmentCommitInfo, Object> throwingFactory = sci -> {
        PreparableOneMerge oneMerge = new PreparableOneMerge(liveSegments());
        // Finish the merge to release reader-pool and deleter refs taken by prepareMerge.
import org.opensearch.common.SuppressForbidden;
    /** Returns the writer's live segments via the production accessor. */
     * Concurrent delete during a merge, driven through the public two-phase prepare/execute contract.
 */
        assertSame(oneMerge, taken);
        writer.executeMerge(taken, gen);
            assertEquals(5, reader.numDocs());
        writer.commit();
            assertTrue(err.getMessage(), err.getMessage().contains("already has a prepared merge"));
        assertEquals(2, first.size());
        assertFalse(oneMerge.readersInitialized());
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
    // ========== PreparableOneMerge ==========
        }
        writer.prepareMerge(oneMerge, gen); // FREEZE: a_0 dead, a_1..a_3 + b_0..b_2 alive (6 rows)
        List<SegmentCommitInfo> first = writer.liveSegmentCommitInfos();
        }
        try {
        addSegment("b", 2);
        }
     * A doc deleted <em>before</em> the freeze is instead physically dropped ({@code maxDoc} excludes
        writer.executeMerge(writer.takePreparedMerge(gen), gen);
        iwc.setMergeScheduler(new SerialMergeScheduler());
        assertEquals(3, liveSegments().size());
        addSegment("b", 2);
    /** initMergeReaders is idempotent once prepared — the factory must not be invoked again. */
        writer.commit();
    /** abortPreparedMerge releases prepared state; source segments stay intact; unknown generations are a no-op. */
            // 7 indexed − 1 pre-freeze delete (a_0) = 6 physical rows; the concurrent delete (a_2)
import org.opensearch.test.OpenSearchTestCase;
     * <ul>
        // The writer must still be fully usable after an abort.
import org.apache.lucene.index.Term;
        assertEquals(2, first.size());
        }
            assertTrue(oneMerge.readersInitialized());
    // ========== liveSegmentCommitInfos ==========
    }
        writer.prepareMerge(oneMerge, gen);
    }
            byName.put(segments.get(i).info.name, (long) i);
package org.opensearch.lucene.index;
        writer.commit();
        writer.deleteDocuments(new Term("id", "a_1"));
        addSegment("a", 3); // docids 0..2, ids a_0..a_2
        for (Long key : before.keySet()) {
        addSegment("b", 2);
        long gen = 7L;
        long gen = 9L;
        m.setAccessible(true);
}
import org.apache.lucene.store.Directory;
        writer = new MergeIndexWriter(directory, newConfig());
        writer.commit();
        SegmentCommitInfo sci = liveSegments().get(0);
        super.setUp();
            // A second init must be a no-op: the factory below would fail the test if invoked.
        for (int i = 0; i < segments.size(); i++) {
    /** The snapshot exposes the live SegmentCommitInfo references (identity) as a stable point-in-time copy. */
        SegmentCommitInfo sci = liveSegments().get(0);
        return sci -> byName.getOrDefault(sci.info.name, -1L);
    }
        assertFalse(sci.hasDeletions());
            assertEquals("docs 0 and 2 alive, doc 1 dead", 0b101L, bits[0]);
 * Unit tests for {@link MergeIndexWriter}'s two-phase prepare/execute merge flow and
    }
    public void testPrepareMergeRejectsDoublePrepare() throws IOException {
        if (directory != null) {
    /** Invokes the package-private {@code initMergeReaders} via reflection. */
    }
        for (int i = 0; i < first.size(); i++) {
import java.util.Map;
    public void testExecuteMergeWithFreshOneMerge() throws IOException {
        addSegment("a", 2);
     *       so {@code mergeMiddle} copied its row), keeping the merged segment row-aligned with the
    }
        }
    private Directory directory;
            writer.addDocument(doc);
        addSegment("b", 3); // b_0..b_2
    /** The snapshot captured by prepareMerge does not observe deletes applied after preparation. */
    }
        // The carried-over delete must be persisted to a .liv so the recorded file set matches readers.
import org.apache.lucene.index.MergePolicy;
            invokeInitMergeReaders(oneMerge, throwingFactory);
import java.util.HashMap;
        addSegment("b", 2);
        addSegment("b", 2);
        }
            writer.flushLiveDocsForMergedSegment(sci);
        }
     *       {@code numDocs} excludes it and it is invisible to search;</li>
        writer.abortPreparedMerge(gen);
        throws Exception {
        directory = newDirectory();
        } finally {
        // Execute against the frozen snapshot: mergeMiddle drops only a_0 (frozen-dead); a_2's delete
        return iwc;
     * A doc alive when the snapshot is frozen but deleted <em>after</em> prepare and <em>before</em>
    }
        PreparableOneMerge oneMerge = new PreparableOneMerge(segments);
    }
    }
     *   <li>persisted — {@code flushLiveDocsForMergedSegment} writes the {@code .liv} so the merged
        PreparableOneMerge oneMerge = new PreparableOneMerge(liveSegments());
    }
        Map<Long, long[]> after = oneMerge.packLiveDocsByGeneration(bySegmentOrdinal(segments));
        assertEquals(before.keySet(), after.keySet());
            // since the factory unconditionally throws and never produces a value.)
            // is physically PRESENT (it was alive at freeze) → maxDoc == 6.
    public void testFlushLiveDocsForMergedSegmentIsNoOpWithoutPooledState() throws IOException {
    /** prepareMerge exposes the frozen hardLiveDocs of segments with deletes; delete-free segments are absent. */
        writer.commit();
        List<SegmentCommitInfo> segments = liveSegments();
        writer.commit(); // applies the delete: doc 1 of segment a is dead
        addSegment("a", 3);
    /** executeMerge with a fresh (unprepared) OneMerge registers it inline and merges. */
        writer.commit();
    public void setUp() throws Exception {
import java.util.function.ToLongFunction;
        } catch (java.lang.reflect.InvocationTargetException e) {
        java.lang.reflect.Method m = MergePolicy.OneMerge.class.getDeclaredMethod("initMergeReaders", IOFunction.class);
        }
        addSegment("a", 4); // a_0..a_3
    public void testExecuteMergeDropsFrozenDeadDocs() throws IOException {
    public void testLiveSegmentCommitInfosReturnsIdentityStableSnapshot() throws IOException {
    public void testConcurrentDeleteDuringMergeIsCarriedOverNotPhysicallyDropped() throws IOException {
        // CONCURRENT DELETE after freeze: a_2 is alive in the frozen snapshot.
        return writer.liveSegmentCommitInfos();
        long gen = 33L;
import org.apache.lucene.util.IOFunction;
        writer.deleteDocuments(new Term("id", "b_0"));
        writer.commit();
        // Delete a_0 BEFORE the freeze — it must be physically dropped by mergeMiddle.
    /** Segments whose readers report no deletes are omitted from the packed map. */
        addSegment("a", 3);
        addSegment("b", 2);
        PreparableOneMerge taken = writer.takePreparedMerge(gen);
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
import org.apache.lucene.index.MergeIndexWriter;
        addSegment("a", 3);
    /** executeMerge after prepareMerge physically drops the frozen-dead docs from the merged segment. */
 */
    public void testPreparableOneMergeInitMergeReadersIsIdempotent() throws Exception {
            assertTrue("forced flush must persist the .liv file", sci.files().stream().anyMatch(f -> f.endsWith(".liv")));
    }
        // is carried over onto the merged segment as a liveDocs deletion, not a physical drop.
