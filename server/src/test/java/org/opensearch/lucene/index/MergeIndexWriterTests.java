 * SPDX-License-Identifier: Apache-2.0
            // since the factory unconditionally throws and never produces a value.)
    public void testConcurrentDeleteDuringMergeIsCarriedOverNotPhysicallyDropped() throws IOException {
     * <ul>  
        writer.deleteDocuments(new Term("id", "a_0"), new Term("id", "b_1"));
        for (Long key : before.keySet()) {
                throw cause;  
            assertSame("snapshot must expose live references, not clones", first.get(i), second.get(i));  
     *       file set records the deletion.</li>
        writer.commit();
        writer.abortPreparedMerge(12345L);  
        // The carried-over delete must be persisted to a .liv so the recorded file set matches readers.
        addSegment("c", 1);  
    /** executeMerge with a fresh (unprepared) OneMerge registers it inline and merges. */
        addSegment("b", 2); // no deletes
        try {  
            writer.abortPreparedMerge(gen);
import java.util.HashMap;
        writer.prepareMerge(new PreparableOneMerge(liveSegments()), gen);  
        addSegment("a", 2);
        IndexWriterConfig iwc = new IndexWriterConfig(new MockAnalyzer(random()));
            assertEquals("carried-over concurrent delete must hide exactly one more doc", 5, reader.numDocs());
import java.io.IOException;
     * execute must be:
        writer.abortPreparedMerge(gen);
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
            assertTrue("forced flush must persist the .liv file", sci.files().stream().anyMatch(f -> f.endsWith(".liv")));
        writer.deleteDocuments(new Term("id", "a_0"));
import org.apache.lucene.document.Field;
        writer.prepareMerge(oneMerge, gen);  
    }  
            m.invoke(oneMerge, factory);  
        // CONCURRENT DELETE after freeze: a_2 is alive in the frozen snapshot.  
            assertNotNull("segment a (ordinal 0) has deletes", bits);  
        PreparableOneMerge oneMerge = new PreparableOneMerge(liveSegments());
        writer.commit();
            "flushLiveDocsForMergedSegment must persist the carried-over delete as a .liv file",
        long gen = 42L;  
        writer.deleteDocuments(new Term("id", "a_2"));
            AssertionError err = expectThrows(AssertionError.class, () -> writer.prepareMerge(new PreparableOneMerge(liveSegments()), gen));
            assertTrue("no .liv file before the forced flush", sci.files().stream().noneMatch(f -> f.endsWith(".liv")));  
            assertEquals("carried-over delete leaves 3 live docs", 3, reader.numDocs());  
    // ========== Helpers ==========
            assertTrue(writer.tryDeleteDocument(reader, 0) >= 0);
    /**
            // (MergePolicy.MergeReader is package-private; erasure lets us pass Object here  
        List<SegmentCommitInfo> segments = liveSegments();  
        assertEquals(1, liveSegments().size());
    /** The snapshot exposes the live SegmentCommitInfo references (identity) as a stable point-in-time copy. */
            // without writing the .liv file — mirroring carryOverHardDeletes after a merge.  
    /** initMergeReaders is idempotent once prepared — the factory must not be invoked again. */  
    // ========== liveSegmentCommitInfos ==========  
    }  
        }
    public void testExecuteMergeWithFreshOneMerge() throws IOException {
        writer.commit();  
        PreparableOneMerge taken = writer.takePreparedMerge(gen);
        assertNull(writer.takePreparedMerge(gen));
        long gen = 9L;  
        // Point-in-time copy: later segment-list changes must not retrofit into an old snapshot.  
        }
        PreparableOneMerge oneMerge = new PreparableOneMerge(liveSegments());
    public void testPrepareMergeRejectsDoublePrepare() throws IOException {
            assertArrayEquals("frozen snapshot must not change for ordinal " + key, before.get(key), after.get(key));
    }  
        // Idempotent / unknown generation: no-op.
        List<SegmentCommitInfo> segments = liveSegments();
        if (directory != null) {
        writer.prepareMerge(oneMerge, gen); // FREEZE: a_0 dead, a_1..a_3 + b_0..b_2 alive (6 rows)
 */  
        addSegment("b", 2);
        assertSame(oneMerge, taken);
import org.apache.lucene.index.SegmentCommitInfo;
        // Delete a_0 BEFORE the freeze — it must be physically dropped by mergeMiddle.
        assertNull("entry must be drained", writer.takePreparedMerge(5L));  
        addSegment("a", 2);
    public void testPrepareMergeExposesFrozenLiveDocs() throws IOException {
    /** takePreparedMerge drains the entry: the second call returns null; unknown generations return null. */
        writer.commit();
    // ========== takePreparedMerge ==========  
            // a_2 is hidden via the carried-over liveDocs delete → one fewer live doc.  
        addSegment("a", 3); // docids 0..2, ids a_0..a_2  
    }  
    private static void invokeInitMergeReaders(PreparableOneMerge oneMerge, IOFunction<SegmentCommitInfo, Object> factory)
    /** Before initialization, readersInitialized is false and packLiveDocsByGeneration is empty. */  
        }
        writer.flush();
     */  
        // Execute against the frozen snapshot: mergeMiddle drops only a_0 (frozen-dead); a_2's delete
            directory.close();
    }
        // Execute: mergeMiddle physically drops only the frozen-dead doc; the late delete is  
        addSegment("b", 2);  
        writer.executeMerge(taken, gen);
    }  
        } finally {  
        addSegment("b", 2);
        java.lang.reflect.Method m = MergePolicy.OneMerge.class.getDeclaredMethod("initMergeReaders", IOFunction.class);  
        writer.executeMerge(writer.takePreparedMerge(gen), gen);
            assertEquals(3, reader.numDocs());
        writer.prepareMerge(oneMerge, 5L);
    }
        writer.deleteDocuments(new Term("id", "b_0"));
        writer.prepareMerge(oneMerge, gen);
        writer.flushLiveDocsForMergedSegment(sci); // must not throw  
    /** Segments whose readers report no deletes are omitted from the packed map. */
    public void testPreparableOneMergeInitMergeReadersIsIdempotent() throws Exception {
        PreparableOneMerge oneMerge = new PreparableOneMerge(segments);
        writer.commit();
    /** No pooled reader state for the segment means no-op. */  
        assertEquals(3, writer.liveSegmentCommitInfos().size());
        long gen = 21L;
    public void setUp() throws Exception {
import java.util.Map;
        for (int i = 0; i < numDocs; i++) {  
            writer.close();
    }
        writer.commit();  
import org.apache.lucene.tests.analysis.MockAnalyzer;
        super.setUp();  
     * A doc alive when the snapshot is frozen but deleted <em>after</em> prepare and <em>before</em>
        Map<Long, long[]> before = oneMerge.packLiveDocsByGeneration(bySegmentOrdinal(segments));
import org.apache.lucene.index.IndexWriterConfig;
        PreparableOneMerge oneMerge = new PreparableOneMerge(liveSegments());
        assumeTrue("requires assertions enabled", MergeIndexWriterTests.class.desiredAssertionStatus());  
        writer.prepareMerge(oneMerge, gen);  
    // ========== abortPreparedMerge ==========
    /** Invokes the package-private {@code initMergeReaders} via reflection. */
        directory = newDirectory();
        addSegment("b", 2);
        iwc.setMergeScheduler(new SerialMergeScheduler());  
    public void testPrepareMergeSnapshotIsFrozenAgainstLaterDeletes() throws IOException {  
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
        }  
    }
        writer.commit();  
    // ========== prepareMerge: frozen live-docs snapshot ==========
        long gen = 7L;
            merged.files().stream().anyMatch(f -> f.endsWith(".liv"))  
import org.opensearch.test.OpenSearchTestCase;
    }
 *
        addSegment("b", 2);
    // ========== executeMerge ==========
        assertTrue(oneMerge.packLiveDocsByGeneration(sci -> 0L).isEmpty());
        addSegment("b", 2);
            assertTrue(oneMerge.packLiveDocsByGeneration(bySegmentOrdinal(liveSegments())).isEmpty());
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
    }  
            writer.flushLiveDocsForMergedSegment(sci);
import org.apache.lucene.index.MergeIndexWriter;  
package org.opensearch.lucene.index;
        writer.commit();  
        // carried over onto the merged segment as a live-docs delete, not a physical drop.
     * A doc deleted <em>before</em> the freeze is instead physically dropped ({@code maxDoc} excludes  
    /** The snapshot captured by prepareMerge does not observe deletes applied after preparation. */
        assertEquals(1, liveSegments().size());
        }  
        writer.deleteDocuments(new Term("id", "a_1"));  
            invokeInitMergeReaders(oneMerge, throwingFactory);
import org.apache.lucene.index.MergePolicy;
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
    }
    private List<SegmentCommitInfo> liveSegments() throws IOException {  
    }
        DirectoryReader.open(writer).close(); // force-apply buffered deletes  
    private IndexWriterConfig newConfig() {
        PreparableOneMerge oneMerge = new PreparableOneMerge(liveSegments());  
        } catch (java.lang.reflect.InvocationTargetException e) {
import org.apache.lucene.util.IOFunction;  
            IOFunction<SegmentCommitInfo, Object> throwingFactory = sci -> {
        addSegment("a", 2);  
        assertEquals(2, first.size());  
    private void addSegment(String prefix, int numDocs) throws IOException {
        assertEquals(2, segments.size());  
        super.tearDown();
        assertEquals("segments merged into one", 1, liveSegments().size());
        throws Exception {
            byName.put(segments.get(i).info.name, (long) i);
        );
        DirectoryReader.open(writer).close(); // force-apply the buffered delete
        PreparableOneMerge taken = writer.takePreparedMerge(gen);  
    }
        PreparableOneMerge taken = writer.takePreparedMerge(5L);
        assertEquals("aborted merge must not touch source segments", 2, liveSegments().size());
import org.apache.lucene.store.Directory;
    }  
        try {
        m.setAccessible(true);
            writer.addDocument(doc);  
        writer.executeMerge(taken, 5L);  
        writer = new MergeIndexWriter(directory, newConfig());
        assertSame(oneMerge, taken);  
        }
import org.apache.lucene.index.PreparableOneMerge;  
        }  
    private MergeIndexWriter writer;
        addSegment("a", 2);
        writer.commit();
        SegmentCommitInfo sci = liveSegments().get(0);
    }
        addSegment("a", 2);
import org.apache.lucene.index.NoMergePolicy;
            };
    public void tearDown() throws Exception {  
        }
        assertEquals(before.keySet(), after.keySet());  
            // A second init must be a no-op: the factory below would fail the test if invoked.
 * {@link PreparableOneMerge}.  
            writer.abortPreparedMerge(gen);
        long gen = 71L;
        addSegment("b", 2);
    }
                throw new IOException("factory must not be re-invoked after prepare");  
            assertEquals("both deleted docs must be physically dropped", 3, reader.maxDoc());  
        long gen = 42L;
            assertTrue(sci.hasDeletions());
        writer.commit();
public class MergeIndexWriterTests extends OpenSearchTestCase {
        assertTrue("merged segment must record the carried-over deletion", merged.hasDeletions());  
 */
    @SuppressForbidden(reason = "Reflection needed to invoke package-private initMergeReaders from outside org.apache.lucene.index")  
     * it). This guards the invariant that a mid-merge delete is carried over, not lost and not
        writer.commit();  
        writer.commit(); // applies the delete: doc 1 of segment a is dead  
            if (e.getCause() instanceof Exception cause) {
        writer.prepareMerge(new PreparableOneMerge(liveSegments()), gen);  
        } finally {  
import org.apache.lucene.index.DirectoryReader;
        PreparableOneMerge oneMerge = new PreparableOneMerge(segments);
        addSegment("a", 3);
    public void testLiveSegmentCommitInfosReturnsIdentityStableSnapshot() throws IOException {  
        return iwc;
        }
        try {
        assertFalse(oneMerge.readersInitialized());
        }  
    public void testTakePreparedMergeDrainsEntry() throws IOException {  
        addSegment("a", 2);
    /** prepareMerge exposes the frozen hardLiveDocs of segments with deletes; delete-free segments are absent. */
     * </ul>
        writer.commit();
/*  
            assertEquals(1, bits.length);
        // Finish the merge to release reader-pool and deleter refs taken by prepareMerge.
 * this file be licensed under the Apache-2.0 license or a
            Document doc = new Document();
        // The writer must still be fully usable after an abort.
    }
        try {
        addSegment("a", 4); // a_0..a_3
        assertNull("segment b's late delete must not appear in the frozen snapshot", after.get(1L));
        assertEquals(2, first.size());
        long gen = 13L;
        }
        writer.commit();  
import org.apache.lucene.index.Term;  
        addSegment("b", 2);  
    public void testPreparableOneMergeBeforeInitialization() throws IOException {
            assertEquals("only the segment with deletes contributes a bitmap", 1, packed.size());  
        // A delete arriving between prepare and execute must not alter the frozen snapshot.
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
        return writer.liveSegmentCommitInfos();
        PreparableOneMerge oneMerge = new PreparableOneMerge(liveSegments());
     *   <li>PHYSICALLY PRESENT in the merged segment — {@code maxDoc} counts it (it was alive at freeze,
        }  
            assertEquals(5, reader.numDocs());  
    /** In-memory deletes on a pooled segment are forced to a .liv file so files() includes it. */
        writer.executeMerge(oneMerge, 11L);
            assertTrue(err.getMessage(), err.getMessage().contains("already has a prepared merge"));  
        writer.commit();  
    }
        assertFalse(oneMerge.readersInitialized());  
        } finally {  
        writer.executeMerge(taken, gen);
     *       {@code numDocs} excludes it and it is invisible to search;</li>
    /** abortPreparedMerge releases prepared state; source segments stay intact; unknown generations are a no-op. */  
        List<SegmentCommitInfo> second = writer.liveSegmentCommitInfos();  
    // ========== flushLiveDocsForMergedSegment ==========
            // 7 indexed − 1 pre-freeze delete (a_0) = 6 physical rows; the concurrent delete (a_2)  
        assertSame(oneMerge, taken);
     * physically dropped early (which would misalign parquet and lucene row ids).
        writer.prepareMerge(new PreparableOneMerge(liveSegments()), gen);
        // is carried over onto the merged segment as a liveDocs deletion, not a physical drop.
            }
     *   <li>persisted — {@code flushLiveDocsForMergedSegment} writes the {@code .liv} so the merged  
        Map<Long, long[]> after = oneMerge.packLiveDocsByGeneration(bySegmentOrdinal(segments));
        writer.commit();
        writer.flushLiveDocsForMergedSegment(merged);  
import org.apache.lucene.index.SerialMergeScheduler;
        for (int i = 0; i < segments.size(); i++) {
 * The OpenSearch Contributors require contributions made to  
        writer.abortPreparedMerge(gen);
    public void testFlushLiveDocsForMergedSegmentIsNoOpWithoutPooledState() throws IOException {
            doc.add(new StringField("id", prefix + "_" + i, Field.Store.YES));
            assertEquals("docs 0 and 2 alive, doc 1 dead", 0b101L, bits[0]);
     *   <li>DEAD via liveDocs — {@code carryOverHardDeletes} marks it deleted on the merged segment, so
        } finally {
import org.opensearch.common.SuppressForbidden;
        writer.commit();
        if (writer != null) {
        assertEquals("segments merged into one", 1, liveSegments().size());
            assertEquals("merged maxDoc drops only the frozen-dead doc", 4, reader.maxDoc());
            assertTrue(oneMerge.readersInitialized());
        SegmentCommitInfo merged = liveSegments().get(0);  
}  
        assertFalse(sci.hasDeletions());
 * compatible open source license.
            // tryDeleteDocument records the delete directly on the pooled ReadersAndUpdates
        addSegment("b", 3); // b_0..b_2  
    /** Keys segments by their ordinal in {@code segments}, mirroring a generation lookup. */
        SegmentCommitInfo sci = liveSegments().get(0);  
        writer.commit();
     * Concurrent delete during a merge, driven through the public two-phase prepare/execute contract.  
        addSegment("a", 3);  
        try {
            throw e;
 * Unit tests for {@link MergeIndexWriter}'s two-phase prepare/execute merge flow and
        long gen = 33L;
        return sci -> byName.getOrDefault(sci.info.name, -1L);
            assertTrue(oneMerge.readersInitialized());  
        for (int i = 0; i < first.size(); i++) {
        assertNull("nothing prepared yet", writer.takePreparedMerge(5L));
            // is physically PRESENT (it was alive at freeze) → maxDoc == 6.
        }  
    /** Adds {@code numDocs} docs with ids {@code prefix_0..} and flushes them into their own segment. */
    public void testFlushLiveDocsForMergedSegmentWritesLivFile() throws IOException {
    @Override
     *       primary format which also copied it;</li>  
        addSegment("a", 3);  
    @Override
    }  
    /** executeMerge after prepareMerge physically drops the frozen-dead docs from the merged segment. */
            writer.abortPreparedMerge(gen);
    public void testExecuteMergeDropsFrozenDeadDocs() throws IOException {
    private static ToLongFunction<SegmentCommitInfo> bySegmentOrdinal(List<SegmentCommitInfo> segments) {
        addSegment("a", 2);  
        List<SegmentCommitInfo> first = writer.liveSegmentCommitInfos();
    public void testAbortPreparedMergeReleasesStateAndKeepsSegments() throws IOException {
        Map<String, Long> byName = new HashMap<>();  
    /** Double-prepare for the same generation trips the guard assertion. */
    }
            long[] bits = packed.get(0L);
    private Directory directory;
            writer.abortPreparedMerge(gen);
     *       so {@code mergeMiddle} copied its row), keeping the merged segment row-aligned with the
        addSegment("b", 2);
        writer.prepareMerge(oneMerge, gen);
        assertTrue(
        assertEquals(3, liveSegments().size());
            assertEquals("concurrently-deleted doc must remain physically present in the merged segment", 6, reader.maxDoc());
        addSegment("a", 2);
import org.apache.lucene.document.Document;
        writer.commit();  
        }
        addSegment("a", 2);
        writer.commit();
        addSegment("c", 1);
import java.util.List;  
/**
        writer.deleteDocuments(new Term("id", "a_1"));
        PreparableOneMerge oneMerge = new PreparableOneMerge(liveSegments());  
        }  
import java.util.function.ToLongFunction;
        }
    /** Returns the writer's live segments via the production accessor. */
            Map<Long, long[]> packed = oneMerge.packLiveDocsByGeneration(bySegmentOrdinal(segments));
import org.apache.lucene.document.StringField;  
    // ========== PreparableOneMerge ==========
    public void testPackLiveDocsByGenerationOmitsDeleteFreeSegments() throws IOException {
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
