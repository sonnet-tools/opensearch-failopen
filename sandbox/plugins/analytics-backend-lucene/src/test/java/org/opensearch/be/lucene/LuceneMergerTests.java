                .segments(segments)  
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
            w.addDocument(doc);
                for (int i = 0; i < ctx.reader().maxDoc(); i++) {
    }
        writeSegment(writer, 1L, 0, 3);  
    private static RowIdMapping identityRowIdMapping() {
        writeSegment(writer, 1L, 0, 3);
    /** With ALL_ALIVE and nothing prepared (Lucene-only engine), merge() still runs on a fresh OneMerge. */
    private List<Segment> buildSegments(List<SegmentCommitInfo> infos) {  
            assertNull("prepared state must be consumed by merge()", writer.takePreparedMerge(gen));
import org.apache.lucene.index.SegmentCommitInfo;
        RowIdMapping rowIdMapping = new PackedRowIdMapping(mappingArray, genOffsets, genSizes);  
        Map<Long, Integer> genOffsets = Map.of(1L, 0, 2L, 3);
        assertFalse(result.getMergedWriterFileSet().isEmpty());
        };  
        writer = new MergeIndexWriter(directory, iwc);
            }
     * source file maintain their relative order in the merged output.  
package org.opensearch.be.lucene;
            // Find the merged segment (should be the largest leaf after old segments are deleted)  
        // Mapping interleaves segments but preserves within-segment order:
        writeSegment(writer, 2L, 3, 2);
            public int size() {  
import org.apache.lucene.document.Field;
            }  
            .build(); // liveDocs defaults to ALL_ALIVE
                // Verify stored field follows the document
            .segments(segments)
        LiveDocs someBitmap = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b101L }));  
    }
            @Override
    }  
        long gen = 99L;  
        };
            assertFalse("segment gen=1 has a delete", liveDocs.allAlive());
        MergePreparation result = merger.prepareMerge(input);  
        try (MergePreparation preparation = merger.prepareMerge(MergeInput.builder().segments(segments).newWriterGeneration(gen).build())) {
     */
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());  
import org.apache.lucene.index.IndexWriterConfig;
            assertFalse(result.getMergedWriterFileSet().isEmpty());
            mergedAfterReopen.info.getAttribute(WRITER_GENERATION_ATTRIBUTE)
    public void testPrepareMergeWithEmptySegmentsReturnsEmptyPreparation() throws IOException {
            assertTrue(liveDocs.isAlive(1L, 0));
        SegmentInfos onDisk = SegmentInfos.readLatestCommit(directory);
        }
                return 0;
            }
    }
        );
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());  
            public long getNewRowId(long oldId, long oldGeneration) {
     *   <li>The merged segment carries the {@code writer_generation} attribute in the live
     * refuses instead of falling back to a fresh OneMerge.
        writeSegment(writer, 2L, 3, 2);  
    public void testConstructorWithNullIndexWriterThrows() {
                .rowIdMapping(identityRowIdMapping())
        // gen=1: 0→0, 1→2, 2→4 (ascending within gen=1)  
    @Override
        if (directory != null) {  
     * each generation), matching real Parquet merge behavior where rows within each
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());  
                return oldId;
        }  
                + newGeneration  
import org.apache.lucene.index.SerialMergeScheduler;
        writeSegmentWithRichFields(writer, 1L, 0, 3);
        // position 2: rowId=2 → doc_1 (gen=1, original rowId=1)  
    /** Empty input returns the EMPTY preparation without taking any state. */
import org.apache.lucene.document.Document;
        RowIdMapping identity = new RowIdMapping() {
            "Merged segment must carry writer_generation="
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());  
        }  
        writer.commit(); // applies the delete: doc 1 of gen=1 is dead
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
        writer.commit();  
            for (LeafReaderContext ctx : reader.leaves()) {
     * Regression guard for the {@code writer_generation} stamping path. Verifies two things:  
        // gen=2: doc_3 (rowId=0), doc_4 (rowId=1)
        writeSegment(writer, 1L, 0, 3); // docs doc_0..doc_2
     * A bitmap with nothing prepared means some primary already dropped rows against a snapshot
        // position 0: rowId=0 → doc_0 (gen=1, original rowId=0)
                segments.add(Segment.builder(generation).build());  
    }
    /** Closing the preparation releases the prepared state and is idempotent. */
        iwc.setIndexSort(new Sort(new SortedNumericSortField(ROW_ID_FIELD, SortField.Type.LONG)));  
                    mergedLeaf = ctx;
            MergeInput mergeInput = MergeInput.builder()
        MergeInput input = MergeInput.builder().segments(segments).newWriterGeneration(gen).build();  
import org.apache.lucene.index.MergeIndexWriter;  
        writer.close();  
import org.apache.lucene.store.Directory;  
            assertNull(liveDocs.packedBits(2L));
        Map<Long, Integer> identityOffsets = Map.of(1L, 0, 2L, 3);  
        // gen=1: doc_0 (rowId=0), doc_1 (rowId=1), doc_2 (rowId=2)  
    }
            for (LeafReaderContext ctx : reader.leaves()) {
        writeSegment(writer, 2L, 3, 2);
     * Constructor with null IndexWriter throws IllegalArgumentException.
/*  
        setWriterGenerationOnLatestSegment(w, generation);
            assertEquals(1, liveDocs.segmentsWithDeletes());
import java.io.IOException;  
    private void setWriterGenerationOnLatestSegment(MergeIndexWriter w, long generation) throws IOException {
            assertTrue(err.getMessage(), err.getMessage().contains("already has a prepared merge"));
    }
        long[] mappingArray = new long[] { 0, 2, 4, 1, 3 };  
        writeSegmentWithRichFields(writer, 2L, 3, 2);  
 * and {@code ___row_id} doc values, then exercise the merge path and validate the output.  
    /**
                lastSegment.info.putAttribute(WRITER_GENERATION_ATTRIBUTE, String.valueOf(generation));
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
        long gen = 99L;
            doc.add(new SortedNumericDocValuesField(ROW_ID_FIELD, i));  
        MergeInput input = MergeInput.builder().segments(List.of()).newWriterGeneration(99L).build();
            }  
        //
        assertNull(writer.takePreparedMerge(gen));
        }
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
        writer.commit();
        }
        Map<Long, Integer> genSizes = Map.of(1L, 3, 2L, 2);
     *       {@code executeMerge}, which runs too late to influence the codec write).</li>  
        writer.commit();
        writer.commit();
 */
        assertNull("close() must have released the prepared state", writer.takePreparedMerge(gen));  
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
    private MergeIndexWriter writer;  
                Document doc = mergedLeaf.reader().storedFields().document(i);
        MergeResult result = merger.merge(input);
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());  
        }  
            SortedNumericDocValues rowIdDV = mergedLeaf.reader().getSortedNumericDocValues(ROW_ID_FIELD);
    }
    public void testMergePreservesFieldDataIntegrity() throws IOException {
        writer.commit();
            w.addDocument(doc);
import org.opensearch.index.engine.dataformat.MergeResult;  
            SegmentCommitInfo lastSegment = live.get(live.size() - 1);
    }  
            .newWriterGeneration(gen)
    public void testMergeConsumesPreparedOneMerge() throws IOException {
        assertEquals(5, writer.getDocStats().numDocs);  
        merger.merge(input);
    public void testPrepareMergeFailsAssertionOnDoublePrepare() throws IOException {  
            String genAttr = sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE);  
import org.apache.lucene.index.SegmentInfos;  
    public void testMergeWithEmptyInput() throws IOException {
    public void testMergeWithoutPreparedMergeAllowedWhenAllAlive() throws IOException {
        // Expected: documents sorted by remapped rowId, with correct stored fields
     *       reopen — catches regressions that would revert to an in-memory-only stamp (e.g.
        return null;
                return 0;
                long actualRowId = rowIdDV.nextValue();
        // position 1: rowId=1 → doc_3 (gen=2, original rowId=0)
        super.setUp();  
            doc.add(new StringField("id", "doc_" + (startRowId + i), Field.Store.YES));  
     *       override stops running.</li>
            @Override
import org.apache.lucene.index.SortedNumericDocValues;
            doc.add(new StoredField("score", String.valueOf(docIdx * 10)));
            }  
            "Persisted writer_generation attribute must match the one passed to MergeInput#newWriterGeneration",  
        SegmentCommitInfo mergedInMemory = findSegmentWithGeneration(writer.liveSegmentCommitInfos(), newGeneration);  
    /** Stamps the writer_generation attribute on the newest live segment. */
    }
        }
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());  
            @Override  
        expectThrows(
        writeSegment(writer, 2L, 3, 2);
            .rowIdMapping(identityRowIdMapping())  
        assumeTrue("requires assertions enabled", LuceneMergerTests.class.desiredAssertionStatus());
     * {@link #testMergeWithRowIdMappingRemapsRowIds()}).
import java.util.Map;
        for (SegmentCommitInfo sci : infos) {
import org.apache.lucene.store.NIOFSDirectory;
            doc.add(new StoredField("data", "rich_data_for_doc_" + docIdx));  
        // Persist to disk, close the writer, and reopen against the same directory to verify  
            }
     *       where the {@link org.opensearch.be.lucene.merge.RowIdRemappingOneMerge#setMergeInfo}
        // (0,1,2 in gen=1 and 3,4 in gen=2), so returning the original row ID is well-formed.
import org.opensearch.index.engine.dataformat.MergeInput;
            mergedAfterReopen  
        IndexWriterConfig iwc = new IndexWriterConfig(new MockAnalyzer(random()));  
        assertNotNull(result);
}
                long generation = Long.parseLong(genAttr);
            }  
     * Verifies that the merged segment has documents sorted by remapped row IDs
            if (lastSegment.info.getAttribute(WRITER_GENERATION_ATTRIBUTE) == null) {  
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());  
    public void tearDown() throws Exception {
        for (int i = 0; i < numDocs; i++) {
        );  
        // position 3: rowId=3 → doc_4 (gen=2, original rowId=1)
    public void setUp() throws Exception {
            LiveDocs liveDocs = preparation.liveDocs();  
import org.opensearch.be.lucene.merge.LuceneMerger;  
            assertTrue("Should have at least 5 docs after merge", reader.numDocs() >= 5);  
        MergeInput input = MergeInput.builder().segments(segments).newWriterGeneration(gen).build();
            assertNotNull("___row_id doc values should exist", rowIdDV);
            LeafReaderContext mergedLeaf = null;
    public void testPrepareMergeReturnsLiveDocsForDeletedRows() throws IOException {  
    /**
        for (int i = 0; i < numDocs; i++) {
            }
 *
     */
        assertEquals(
        String[] expectedIds = { "doc_0", "doc_3", "doc_1", "doc_4", "doc_2" };
                .liveDocs(preparation.liveDocs())  
     * this merger never saw. Re-snapshotting would silently misalign the formats, so merge()  
import org.apache.lucene.document.StoredField;
    /**
 * End-to-end tests for {@link LuceneMerger}.  
     * The mapping preserves within-segment order (ascending remapped values within
                return newId;  
        String target = String.valueOf(generation);
            }
            doc.add(new StringField("id", "doc_" + docIdx, Field.Store.YES));
import java.util.ArrayList;
                return true;
            assertNotSame(MergePreparation.EMPTY, first);  
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());  
            assertNotNull("Should have at least one leaf", mergedLeaf);
        assertTrue(err.getMessage(), err.getMessage().contains("no merge was prepared"));  
     * Merge with empty input returns empty result without error.  
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
     *       {@link SegmentInfos} immediately after the merge completes — catches regressions  
                }
        for (SegmentCommitInfo sci : infos) {  
    }
        }
        writeSegment(writer, 2L, 3, 2);
        long[] identityArray = new long[] { 0, 1, 2, 3, 4 };
        MergeInput input = MergeInput.builder().segments(segments).newWriterGeneration(gen).build();
     */  
        long gen = 99L;
            public long getOldRowId(long newId) {  
    private Directory directory;
 * The OpenSearch Contributors require contributions made to  
            doc.add(new StoredField("data", "value_for_doc_" + (startRowId + i)));
            assertFalse("deleted doc must be flagged dead", liveDocs.isAlive(1L, 1));  
     *   <li>The attribute is <em>persisted</em> to the {@code .si} file and survives a writer  
            }
    private SegmentCommitInfo findSegmentWithGeneration(List<SegmentCommitInfo> infos, long generation) {
        // idempotent
            String.valueOf(newGeneration),
        try (MergePreparation first = merger.prepareMerge(input)) {
        writeSegment(writer, 1L, 0, 3);
    }  
        if (writer != null) {  
        MergeInput input = MergeInput.builder().segments(List.of()).newWriterGeneration(99L).build();
            .build();  
     * Merge with RowIdMapping remaps ___row_id doc values AND reorders documents.  
import org.opensearch.index.engine.dataformat.LiveDocs;  
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
        return new RowIdMapping() {
        assertTrue(merger.providesMergeLiveDocs());
     * Merge preserves keyword, numeric, and stored field data integrity.  
        MergeInput input = MergeInput.builder().segments(segments).rowIdMapping(identity).newWriterGeneration(newGeneration).build();
        assertNotNull(result);
        writeSegment(writer, 2L, 3, 2);  
        MergeResult result = merger.merge(input);  
     * <p>Uses an identity {@link RowIdMapping} so the merge exercises the real
        if (live.isEmpty() == false) {
     *       moving the {@code putAttribute} call back to {@code LuceneMerger#merge} after
            writer.close();
        // close() after a consumed merge is a no-op: nothing left to abort.
    /** Calling prepareMerge twice for the same generation trips the double-prepare assertion. */
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
                if (mergedLeaf == null || ctx.reader().maxDoc() > mergedLeaf.reader().maxDoc()) {  
    private void writeSegment(MergeIndexWriter w, long generation, int startRowId, int numDocs) throws IOException {  
        MergeInput mergeInput = MergeInput.builder()
    }
    public void testMergeWithRowIdMappingRemapsRowIds() throws IOException {
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
        writeSegment(writer, 1L, 0, 3);  
        MergeInput input = MergeInput.builder().segments(segments).rowIdMapping(rowIdMapping).newWriterGeneration(10L).build();
 * compatible open source license.
            .segments(segments)
    }
        // merged output: gen1-row0, gen2-row0, gen1-row1, gen2-row1, gen1-row2
            // ___row_id is local to the segment: 0, 1, 2, ... (matches how the real system works)
            .liveDocs(someBitmap)
                    String id = doc.get("id");
                return true;  
        setWriterGenerationOnLatestSegment(w, generation);
import org.apache.lucene.index.NoMergePolicy;
import org.opensearch.index.engine.exec.Segment;  
import org.apache.lucene.document.SortedNumericDocValuesField;  
        w.flush();  
            assertFalse(liveDocs.allAlive(1L));
    }  
        assertTrue(result.getMergedWriterFileSet().isEmpty());
                assertEquals("Doc at position " + i + " should have ___row_id=" + expectedRowIds[i], expectedRowIds[i], actualRowId);
        // position 1: rowId=1 → doc_a (gen=2, original rowId=0)
        iwc.setIndexSort(new Sort(new SortedNumericSortField(ROW_ID_FIELD, SortField.Type.LONG)));  
        );
                    assertNotNull("stored numeric field missing for " + id, numericStr);
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
        IllegalStateException err = expectThrows(IllegalStateException.class, () -> merger.merge(mergeInput));
        }
    /**
            public int size() {
import org.opensearch.index.engine.dataformat.PackedRowIdMapping;
     *  
    // ========== Helper Methods ==========
        writer.commit();
        }
        assertNull("entry must be drained from preparedMerges", writer.takePreparedMerge(gen));
        writer.commit();
                // Verify ___row_id value
        writer.deleteDocuments(new org.apache.lucene.index.Term("id", "doc_1"));  
    private void writeSegmentWithRichFields(MergeIndexWriter w, long generation, int startRowId, int numDocs) throws IOException {
        // This simulates a Parquet merge that interleaves rows from two files:  
     */
    private Path dataPath;
    }  
        writer.commit();  
        // position 2: rowId=2 → doc_1 (gen=1, original rowId=1)  
     *
    public void testPreparationCloseReleasesState() throws IOException {  
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());  
        // position 4: rowId=4 → doc_2 (gen=1, original rowId=2)
import org.apache.lucene.document.StringField;
        // gen=2: 0→1, 1→3 (ascending within gen=2)
            }  
import org.opensearch.index.engine.dataformat.RowIdMapping;
        iwc.setMergeScheduler(new SerialMergeScheduler());
            }
            Document doc = new Document();
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
                    String storedData = doc.get("data");  
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());  
                .build();
     * <ol>
        try (MergePreparation preparation = merger.prepareMerge(input)) {
                    assertNotNull("stored data field missing for " + id, storedData);
            AssertionError err = expectThrows(AssertionError.class, () -> merger.prepareMerge(input));
        assertTrue(result.rowIdMapping().isPresent());  
            @Override  
        MergePreparation preparation = merger.prepareMerge(input);
                    assertNotNull("id field missing", id);
        writer.commit();
     * and that stored fields follow the documents to their new positions.
            directory.close();
        // Identity mapping — writeSegmentWithRichFields already writes globally-unique row IDs  
            doc.add(new SortedNumericDocValuesField("score_dv", docIdx * 10));  
import org.apache.lucene.tests.analysis.MockAnalyzer;
            if (target.equals(sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE))) {
            MergeResult result = merger.merge(mergeInput);
        w.flush();  
 */  
        // Expected sorted order by remapped rowId:  
        assertTrue(result.liveDocs().allAlive());
        long newGeneration = 99L;
            public boolean isNewToOldSupported() {
            IllegalArgumentException.class,  
    }
        writeSegment(writer, 2L, 3, 2); // docs doc_3..doc_4, no deletes
    /**
import org.apache.lucene.index.DirectoryReader;  
import org.apache.lucene.search.SortedNumericSortField;
        super.tearDown();  
        writer.commit();
    // ========== prepareMerge / MergePreparation ==========
        iwc.setMergeScheduler(new SerialMergeScheduler());
        assertEquals("source segments must be untouched", 2, writer.liveSegmentCommitInfos().size());
    }  
    @Override
     */
    private static final String ROW_ID_FIELD = DocumentInput.ROW_ID_FIELD;
 * SPDX-License-Identifier: Apache-2.0
    public void testProvidesMergeLiveDocs() {
        MergeResult result = merger.merge(mergeInput);  
        dataPath = createTempDir();
    /** prepareMerge surfaces per-generation live-docs bitmaps reflecting applied deletes. */
            doc.add(new SortedNumericDocValuesField(ROW_ID_FIELD, docIdx));
        long[] expectedRowIds = { 0, 1, 2, 3, 4 };  
        assertNotNull("Merged segment must carry writer_generation=" + newGeneration + " in the live SegmentInfos", mergedInMemory);
        }
                + "not stamped in-memory after executeMerge returns",
import org.apache.lucene.search.Sort;  
        writeSegment(writer, 2L, 3, 2);  
    /** merge() consumes the OneMerge prepared by prepareMerge — no fresh OneMerge is created. */  
                }
 * this file be licensed under the Apache-2.0 license or a
            public boolean isNewToOldSupported() {
        SegmentCommitInfo mergedAfterReopen = findSegmentWithGeneration(onDisk.asList(), newGeneration);  
                assertEquals("Doc at position " + i + " should be " + expectedIds[i], expectedIds[i], doc.get("id"));  
public class LuceneMergerTests extends OpenSearchTestCase {
        }
                return oldId;
     * secondary-format path; the assertions focus on field-data survival rather  
            public long getOldRowId(long newId) {
            if (genAttr != null) {
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
    public void testMergeRefusesLiveDocsWithoutPreparedMerge() throws IOException {  
        long gen = 99L;  
            }  
    }  
            int docIdx = startRowId + i;  
import static org.opensearch.be.lucene.index.LuceneWriter.WRITER_GENERATION_ATTRIBUTE;  
        // position 0: rowId=0 → doc_0 (gen=1, original rowId=0)
                    Document doc = ctx.reader().storedFields().document(i);  
        writeSegment(writer, 1L, 0, 3);
        writeSegment(writer, 1L, 0, 3);
        List<Segment> segments = new ArrayList<>();
import org.opensearch.index.engine.dataformat.DocumentInput;
    // ========== Test Cases ==========  
import java.nio.file.Path;
                .newWriterGeneration(gen)
    /**
        long gen = 99L;  
        MergeInput mergeInput = MergeInput.builder()
            assertTrue(liveDocs.isAlive(1L, 2));
            }
            public long getNewRowId(long oldId, long oldGeneration) {  
        merger.merge(input);  
/**
    }
                    assertTrue("data should contain the doc id", storedData.contains(id));
import org.apache.lucene.search.SortField;
        // Build a PackedRowIdMapping for the interleaved merge:
     * than on row-id remapping (which is covered by
            assertTrue("gen=2 has no deletes", liveDocs.allAlive(2L));  
import org.opensearch.index.engine.dataformat.MergePreparation;
    /** LuceneMerger owns delete state, so it advertises itself as the composite's live-docs producer. */
        return segments;  
        preparation.close();
        Map<Long, Integer> identitySizes = Map.of(1L, 3, 2L, 2);
            Document doc = new Document();
import java.util.List;  
            @Override
        MergeInput input = MergeInput.builder().segments(segments).rowIdMapping(identityMapping).newWriterGeneration(10L).build();
                    String numericStr = doc.get("score");  
        //
        assertSame(MergePreparation.EMPTY, result);
                return newId;
            .newWriterGeneration(99L)
        writer.commit();  
    public void testMergedSegmentWriterGenerationIsPersisted() throws IOException {  
 *
        // Reopen for the tearDown close() to be a no-op on an already-closed writer.
     * </ol>
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
            for (int i = 0; i < 5; i++) {
                assertTrue("Should have doc values for doc " + i, rowIdDV.advanceExact(i));  
        assertNotNull(
            @Override
                + " after reopen — the attribute must be written to the .si file during the merge, "
        IndexWriterConfig iwc = new IndexWriterConfig(new MockAnalyzer(random()));  
            @Override  
        assertNotSame(MergePreparation.EMPTY, preparation);
        preparation.close();
import org.apache.lucene.index.LeafReaderContext;
        writer = new MergeIndexWriter(directory, iwc);
        writeSegment(writer, 1L, 0, 3);
        // position 3: rowId=3 → doc_b (gen=2, original rowId=1)
        // try-with-resources released the prepared state before tearDown closes the writer.
        // the attribute survives — i.e. it was stamped before Lucene wrote the .si file.
            () -> new LuceneMerger(null, new LuceneDataFormat(), Path.of("."), new LuceneShardStatsTracker())
            assertEquals("Merged segment should have 5 docs", 5, mergedLeaf.reader().maxDoc());
            @Override
        RowIdMapping identityMapping = new PackedRowIdMapping(identityArray, identityOffsets, identitySizes);
        directory = NIOFSDirectory.open(dataPath);
        // gen=1 has 3 rows (offsets 0,1,2), gen=2 has 2 rows (offsets 3,4)  
        List<SegmentCommitInfo> live = w.liveSegmentCommitInfos();  
 * <p>These tests create real Lucene segments with {@code writer_generation} attributes
            .rowIdMapping(identityRowIdMapping())  
import org.opensearch.test.OpenSearchTestCase;
     */  
    }
        // Assertion 1: attribute is set on the live (in-memory) merged SegmentCommitInfo
                return sci;
