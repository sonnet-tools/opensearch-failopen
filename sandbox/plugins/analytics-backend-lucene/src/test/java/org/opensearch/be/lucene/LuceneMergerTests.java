public class LuceneMergerTests extends OpenSearchTestCase {
    public void testPrepareMergeReturnsLiveDocsForDeletedRows() throws IOException {
    }
        RowIdMapping identityMapping = new PackedRowIdMapping(identityArray, identityOffsets, identitySizes);
     * {@link #testMergeWithRowIdMappingRemapsRowIds()}).
        long newGeneration = 99L;
            public boolean isNewToOldSupported() {
            MergeInput mergeInput = MergeInput.builder()
     * <p>Uses an identity {@link RowIdMapping} so the merge exercises the real
    /** merge() consumes the OneMerge prepared by prepareMerge — no fresh OneMerge is created. */
        // the attribute survives — i.e. it was stamped before Lucene wrote the .si file.
    private void writeSegmentWithRichFields(MergeIndexWriter w, long generation, int startRowId, int numDocs) throws IOException {
        Map<Long, Integer> genOffsets = Map.of(1L, 0, 2L, 3);
        // Build a PackedRowIdMapping for the interleaved merge:
    public void setUp() throws Exception {
     * each generation), matching real Parquet merge behavior where rows within each
        assertNull(writer.takePreparedMerge(gen));
        for (SegmentCommitInfo sci : infos) {
        //
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
 *
            w.addDocument(doc);
import org.apache.lucene.document.StoredField;
     * The mapping preserves within-segment order (ascending remapped values within
    // ========== Test Cases ==========
            // ___row_id is local to the segment: 0, 1, 2, ... (matches how the real system works)
            Document doc = new Document();
                    assertTrue("data should contain the doc id", storedData.contains(id));
            LeafReaderContext mergedLeaf = null;
                    assertNotNull("stored data field missing for " + id, storedData);
    /** Stamps the writer_generation attribute on the newest live segment. */
        assertEquals(
        setWriterGenerationOnLatestSegment(w, generation);
        setWriterGenerationOnLatestSegment(w, generation);
        writer.commit();
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
            assertNotNull("___row_id doc values should exist", rowIdDV);
                return 0;
     *   <li>The merged segment carries the {@code writer_generation} attribute in the live
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
                assertEquals("Doc at position " + i + " should be " + expectedIds[i], expectedIds[i], doc.get("id"));
    /** Calling prepareMerge twice for the same generation trips the double-prepare assertion. */
 * SPDX-License-Identifier: Apache-2.0
                return oldId;
        assertTrue(merger.providesMergeLiveDocs());
            if (genAttr != null) {
        writeSegment(writer, 2L, 3, 2);
import org.opensearch.index.engine.dataformat.PackedRowIdMapping;
                    Document doc = ctx.reader().storedFields().document(i);
        // (0,1,2 in gen=1 and 3,4 in gen=2), so returning the original row ID is well-formed.
import org.opensearch.test.OpenSearchTestCase;
        long gen = 99L;
        // close() after a consumed merge is a no-op: nothing left to abort.
        };
        writer.commit();
            public int size() {
            .liveDocs(someBitmap)
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
        super.tearDown();
                }
     * Constructor with null IndexWriter throws IllegalArgumentException.
        return new RowIdMapping() {
            mergedAfterReopen
        iwc.setIndexSort(new Sort(new SortedNumericSortField(ROW_ID_FIELD, SortField.Type.LONG)));
            }
        writeSegmentWithRichFields(writer, 2L, 3, 2);
     *       {@link SegmentInfos} immediately after the merge completes — catches regressions
        writer.commit();
    public void testMergeRefusesLiveDocsWithoutPreparedMerge() throws IOException {
 */
        // Expected: documents sorted by remapped rowId, with correct stored fields
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
import org.apache.lucene.document.SortedNumericDocValuesField;
        // position 4: rowId=4 → doc_2 (gen=1, original rowId=2)
        assumeTrue("requires assertions enabled", LuceneMergerTests.class.desiredAssertionStatus());
    }
        iwc.setIndexSort(new Sort(new SortedNumericSortField(ROW_ID_FIELD, SortField.Type.LONG)));
            @Override
    public void tearDown() throws Exception {
                return true;
            doc.add(new StoredField("data", "value_for_doc_" + (startRowId + i)));
            w.addDocument(doc);
import org.apache.lucene.index.SortedNumericDocValues;
    /**
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
        writeSegment(writer, 2L, 3, 2);
import org.opensearch.index.engine.exec.Segment;
    /**
                .newWriterGeneration(gen)
    private static final String ROW_ID_FIELD = DocumentInput.ROW_ID_FIELD;
/**
        writeSegment(writer, 2L, 3, 2);
            doc.add(new SortedNumericDocValuesField("score_dv", docIdx * 10));
    }
    private void setWriterGenerationOnLatestSegment(MergeIndexWriter w, long generation) throws IOException {
            directory.close();
        MergeInput input = MergeInput.builder().segments(segments).newWriterGeneration(gen).build();
                return newId;
     *
    }
        writeSegment(writer, 1L, 0, 3);
        for (int i = 0; i < numDocs; i++) {
            doc.add(new StoredField("score", String.valueOf(docIdx * 10)));
        MergeInput input = MergeInput.builder().segments(segments).newWriterGeneration(gen).build();
            .build(); // liveDocs defaults to ALL_ALIVE
                .build();
        }
        LiveDocs someBitmap = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b101L }));
        for (int i = 0; i < numDocs; i++) {
     *       reopen — catches regressions that would revert to an in-memory-only stamp (e.g.
     * this merger never saw. Re-snapshotting would silently misalign the formats, so merge()
import org.apache.lucene.search.SortField;
            .newWriterGeneration(gen)
        // Identity mapping — writeSegmentWithRichFields already writes globally-unique row IDs
    }
        Map<Long, Integer> identityOffsets = Map.of(1L, 0, 2L, 3);
    /** Closing the preparation releases the prepared state and is idempotent. */
        writeSegmentWithRichFields(writer, 1L, 0, 3);
                    assertNotNull("id field missing", id);
            @Override
    /** LuceneMerger owns delete state, so it advertises itself as the composite's live-docs producer. */
        long gen = 99L;
                + "not stamped in-memory after executeMerge returns",
            () -> new LuceneMerger(null, new LuceneDataFormat(), Path.of("."), new LuceneShardStatsTracker())
 * and {@code ___row_id} doc values, then exercise the merge path and validate the output.
        long[] identityArray = new long[] { 0, 1, 2, 3, 4 };
        // position 3: rowId=3 → doc_4 (gen=2, original rowId=1)
            assertFalse("segment gen=1 has a delete", liveDocs.allAlive());
            IllegalArgumentException.class,
    private Directory directory;
        // position 2: rowId=2 → doc_1 (gen=1, original rowId=1)
    }
                return true;
            assertNull("prepared state must be consumed by merge()", writer.takePreparedMerge(gen));
            }
            assertTrue("Should have at least 5 docs after merge", reader.numDocs() >= 5);
        directory = NIOFSDirectory.open(dataPath);
            }
            assertNull(liveDocs.packedBits(2L));
                    String storedData = doc.get("data");
            SortedNumericDocValues rowIdDV = mergedLeaf.reader().getSortedNumericDocValues(ROW_ID_FIELD);
            mergedAfterReopen.info.getAttribute(WRITER_GENERATION_ATTRIBUTE)
     * than on row-id remapping (which is covered by
     *       override stops running.</li>
                    assertNotNull("stored numeric field missing for " + id, numericStr);
import org.apache.lucene.document.Document;
 * <p>These tests create real Lucene segments with {@code writer_generation} attributes
     *   <li>The attribute is <em>persisted</em> to the {@code .si} file and survives a writer
import org.opensearch.index.engine.dataformat.MergePreparation;
        merger.merge(input);
     * Verifies that the merged segment has documents sorted by remapped row IDs
        IndexWriterConfig iwc = new IndexWriterConfig(new MockAnalyzer(random()));
                // Verify ___row_id value
        assertNotNull(
import org.opensearch.index.engine.dataformat.DocumentInput;
        writer.commit();
        }
    }
        writeSegment(writer, 1L, 0, 3);
        iwc.setMergeScheduler(new SerialMergeScheduler());
        }
            "Persisted writer_generation attribute must match the one passed to MergeInput#newWriterGeneration",
        assertEquals("source segments must be untouched", 2, writer.liveSegmentCommitInfos().size());
    private MergeIndexWriter writer;
            assertEquals(1, liveDocs.segmentsWithDeletes());
import org.opensearch.index.engine.dataformat.MergeResult;
            for (LeafReaderContext ctx : reader.leaves()) {
        writer.deleteDocuments(new org.apache.lucene.index.Term("id", "doc_1"));
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
        IllegalStateException err = expectThrows(IllegalStateException.class, () -> merger.merge(mergeInput));
            public long getOldRowId(long newId) {
            .rowIdMapping(identityRowIdMapping())
import org.apache.lucene.index.DirectoryReader;
            assertTrue(liveDocs.isAlive(1L, 0));
        MergeResult result = merger.merge(input);
import static org.opensearch.be.lucene.index.LuceneWriter.WRITER_GENERATION_ATTRIBUTE;
                + newGeneration
            public long getNewRowId(long oldId, long oldGeneration) {
                long actualRowId = rowIdDV.nextValue();
     * Merge with RowIdMapping remaps ___row_id doc values AND reorders documents.
        }
        // position 1: rowId=1 → doc_3 (gen=2, original rowId=0)
import org.apache.lucene.index.IndexWriterConfig;
            }
    private Path dataPath;
        }
        }
            assertEquals("Merged segment should have 5 docs", 5, mergedLeaf.reader().maxDoc());
     *       where the {@link org.opensearch.be.lucene.merge.RowIdRemappingOneMerge#setMergeInfo}
    public void testPreparationCloseReleasesState() throws IOException {
        for (SegmentCommitInfo sci : infos) {
            int docIdx = startRowId + i;
    private void writeSegment(MergeIndexWriter w, long generation, int startRowId, int numDocs) throws IOException {
        }
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
            MergeResult result = merger.merge(mergeInput);
    /**
            assertFalse(result.getMergedWriterFileSet().isEmpty());
            }
            doc.add(new StringField("id", "doc_" + docIdx, Field.Store.YES));
import org.apache.lucene.tests.analysis.MockAnalyzer;
        if (live.isEmpty() == false) {
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
     * Merge with empty input returns empty result without error.
 * compatible open source license.
    public void testPrepareMergeFailsAssertionOnDoublePrepare() throws IOException {
        assertTrue(result.rowIdMapping().isPresent());
        // Assertion 1: attribute is set on the live (in-memory) merged SegmentCommitInfo
        }
            doc.add(new StoredField("data", "rich_data_for_doc_" + docIdx));
        w.flush();
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
    }
            doc.add(new SortedNumericDocValuesField(ROW_ID_FIELD, docIdx));
    }
     *       moving the {@code putAttribute} call back to {@code LuceneMerger#merge} after
        try (MergePreparation preparation = merger.prepareMerge(input)) {
import org.opensearch.index.engine.dataformat.LiveDocs;
                segments.add(Segment.builder(generation).build());
            }
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
        }
        merger.merge(input);
        IndexWriterConfig iwc = new IndexWriterConfig(new MockAnalyzer(random()));
import java.nio.file.Path;
    public void testMergePreservesFieldDataIntegrity() throws IOException {
import org.opensearch.index.engine.dataformat.RowIdMapping;
        // position 1: rowId=1 → doc_a (gen=2, original rowId=0)
        List<SegmentCommitInfo> live = w.liveSegmentCommitInfos();
    }
        return null;
                long generation = Long.parseLong(genAttr);
        MergeInput input = MergeInput.builder().segments(segments).newWriterGeneration(gen).build();
     */
        MergeResult result = merger.merge(input);
            }
    public void testMergeConsumesPreparedOneMerge() throws IOException {
        SegmentInfos onDisk = SegmentInfos.readLatestCommit(directory);
                return oldId;
        writeSegment(writer, 2L, 3, 2); // docs doc_3..doc_4, no deletes
import org.apache.lucene.index.SerialMergeScheduler;
    /**
        Map<Long, Integer> identitySizes = Map.of(1L, 3, 2L, 2);
            @Override
     */
import org.apache.lucene.index.SegmentInfos;
        // Persist to disk, close the writer, and reopen against the same directory to verify
        super.setUp();
        MergeResult result = merger.merge(mergeInput);
import org.apache.lucene.store.Directory;
        writeSegment(writer, 1L, 0, 3);
 * The OpenSearch Contributors require contributions made to
        writer.commit();
        // position 3: rowId=3 → doc_b (gen=2, original rowId=1)
     * Merge preserves keyword, numeric, and stored field data integrity.
     * and that stored fields follow the documents to their new positions.
     * secondary-format path; the assertions focus on field-data survival rather
    private List<Segment> buildSegments(List<SegmentCommitInfo> infos) {
        // idempotent
            AssertionError err = expectThrows(AssertionError.class, () -> merger.prepareMerge(input));
        Map<Long, Integer> genSizes = Map.of(1L, 3, 2L, 2);
        // gen=1 has 3 rows (offsets 0,1,2), gen=2 has 2 rows (offsets 3,4)
        try (MergePreparation first = merger.prepareMerge(input)) {
import java.util.Map;
        writeSegment(writer, 1L, 0, 3);
    public void testMergeWithoutPreparedMergeAllowedWhenAllAlive() throws IOException {
        RowIdMapping rowIdMapping = new PackedRowIdMapping(mappingArray, genOffsets, genSizes);
            String.valueOf(newGeneration),
            }
        // position 0: rowId=0 → doc_0 (gen=1, original rowId=0)
        writer.commit();
    /** Empty input returns the EMPTY preparation without taking any state. */
        String target = String.valueOf(generation);
            LiveDocs liveDocs = preparation.liveDocs();
        assertEquals(5, writer.getDocStats().numDocs);
        // gen=2: 0→1, 1→3 (ascending within gen=2)
    // ========== prepareMerge / MergePreparation ==========
        if (directory != null) {
     */
            SegmentCommitInfo lastSegment = live.get(live.size() - 1);
    }
            }
import org.apache.lucene.search.SortedNumericSortField;
            @Override
     *
            // Find the merged segment (should be the largest leaf after old segments are deleted)
        writeSegment(writer, 1L, 0, 3);
    private SegmentCommitInfo findSegmentWithGeneration(List<SegmentCommitInfo> infos, long generation) {
            public boolean isNewToOldSupported() {
        writeSegment(writer, 2L, 3, 2);
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
        long[] expectedRowIds = { 0, 1, 2, 3, 4 };
            assertTrue(err.getMessage(), err.getMessage().contains("already has a prepared merge"));
            public long getNewRowId(long oldId, long oldGeneration) {
        dataPath = createTempDir();
        }
     * Regression guard for the {@code writer_generation} stamping path. Verifies two things:
                assertTrue("Should have doc values for doc " + i, rowIdDV.advanceExact(i));
        writer.commit();
            .newWriterGeneration(99L)
            }
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
    }
import org.apache.lucene.index.LeafReaderContext;
            }
        // Reopen for the tearDown close() to be a no-op on an already-closed writer.
            if (lastSegment.info.getAttribute(WRITER_GENERATION_ATTRIBUTE) == null) {
        String[] expectedIds = { "doc_0", "doc_3", "doc_1", "doc_4", "doc_2" };
import org.apache.lucene.index.MergeIndexWriter;
    public void testConstructorWithNullIndexWriterThrows() {
                for (int i = 0; i < ctx.reader().maxDoc(); i++) {
 */
            .build();
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
            assertFalse(liveDocs.allAlive(1L));
import org.apache.lucene.document.Field;
        long[] mappingArray = new long[] { 0, 2, 4, 1, 3 };
        // merged output: gen1-row0, gen2-row0, gen1-row1, gen2-row1, gen1-row2
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
        List<Segment> segments = new ArrayList<>();
        SegmentCommitInfo mergedInMemory = findSegmentWithGeneration(writer.liveSegmentCommitInfos(), newGeneration);
            public long getOldRowId(long newId) {
        writer.close();
            "Merged segment must carry writer_generation="
        assertSame(MergePreparation.EMPTY, result);
}
                lastSegment.info.putAttribute(WRITER_GENERATION_ATTRIBUTE, String.valueOf(generation));
        MergeInput mergeInput = MergeInput.builder()
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
            assertNotSame(MergePreparation.EMPTY, first);
    }
            String genAttr = sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE);
            .segments(segments)
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
            doc.add(new SortedNumericDocValuesField(ROW_ID_FIELD, i));
        };
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
    }
            .rowIdMapping(identityRowIdMapping())
            @Override
        writer.commit(); // applies the delete: doc 1 of gen=1 is dead
package org.opensearch.be.lucene;
        writeSegment(writer, 1L, 0, 3);
    }
        MergeInput input = MergeInput.builder().segments(segments).rowIdMapping(rowIdMapping).newWriterGeneration(10L).build();
        // Expected sorted order by remapped rowId:
        // try-with-resources released the prepared state before tearDown closes the writer.
        writeSegment(writer, 2L, 3, 2);
     * <ol>
        assertTrue(result.getMergedWriterFileSet().isEmpty());
import java.util.List;
            writer.close();
        // gen=2: doc_3 (rowId=0), doc_4 (rowId=1)
        preparation.close();
import org.apache.lucene.index.NoMergePolicy;
        assertTrue(result.liveDocs().allAlive());
                .segments(segments)
        return segments;
                .rowIdMapping(identityRowIdMapping())
            assertNotNull("Should have at least one leaf", mergedLeaf);
        assertTrue(err.getMessage(), err.getMessage().contains("no merge was prepared"));
    }
            if (target.equals(sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE))) {
        // position 0: rowId=0 → doc_0 (gen=1, original rowId=0)
    private static RowIdMapping identityRowIdMapping() {
    public void testMergeWithEmptyInput() throws IOException {
        assertNull("close() must have released the prepared state", writer.takePreparedMerge(gen));
                + " after reopen — the attribute must be written to the .si file during the merge, "
        RowIdMapping identity = new RowIdMapping() {
            }
        }
import java.util.ArrayList;
        writeSegment(writer, 2L, 3, 2);
        preparation.close();
    }
        writer.commit();
        // gen=1: 0→0, 1→2, 2→4 (ascending within gen=1)
    /** With ALL_ALIVE and nothing prepared (Lucene-only engine), merge() still runs on a fresh OneMerge. */
            }
import java.io.IOException;
                // Verify stored field follows the document
     * source file maintain their relative order in the merged output.
                Document doc = mergedLeaf.reader().storedFields().document(i);
    }
        SegmentCommitInfo mergedAfterReopen = findSegmentWithGeneration(onDisk.asList(), newGeneration);
        assertNotNull(result);
    public void testPrepareMergeWithEmptySegmentsReturnsEmptyPreparation() throws IOException {
    // ========== Helper Methods ==========
                assertEquals("Doc at position " + i + " should have ___row_id=" + expectedRowIds[i], expectedRowIds[i], actualRowId);
        MergeInput input = MergeInput.builder().segments(List.of()).newWriterGeneration(99L).build();
            Document doc = new Document();
            @Override
 * End-to-end tests for {@link LuceneMerger}.
        iwc.setMergeScheduler(new SerialMergeScheduler());
                return 0;
        // This simulates a Parquet merge that interleaves rows from two files:
        writeSegment(writer, 1L, 0, 3);
                if (mergedLeaf == null || ctx.reader().maxDoc() > mergedLeaf.reader().maxDoc()) {
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
     */
        assertNotNull(result);
            assertTrue(liveDocs.isAlive(1L, 2));
        writeSegment(writer, 2L, 3, 2);
     */
            }
            public int size() {
        assertNull("entry must be drained from preparedMerges", writer.takePreparedMerge(gen));
        assertNotSame(MergePreparation.EMPTY, preparation);
import org.opensearch.be.lucene.merge.LuceneMerger;
        List<Segment> segments = buildSegments(writer.liveSegmentCommitInfos());
    }
        writer.commit();
        // position 2: rowId=2 → doc_1 (gen=1, original rowId=1)
import org.opensearch.index.engine.dataformat.MergeInput;
            .segments(segments)
    /**
            @Override
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
     * refuses instead of falling back to a fresh OneMerge.
    @Override
     */
    public void testProvidesMergeLiveDocs() {
        expectThrows(
        writer = new MergeIndexWriter(directory, iwc);
 * this file be licensed under the Apache-2.0 license or a
     * A bitmap with nothing prepared means some primary already dropped rows against a snapshot
    @Override
            @Override
        writer.commit();
/*
        }
                    String numericStr = doc.get("score");
import org.apache.lucene.index.SegmentCommitInfo;
    }
                    mergedLeaf = ctx;
    /** prepareMerge surfaces per-generation live-docs bitmaps reflecting applied deletes. */
        MergeInput input = MergeInput.builder().segments(List.of()).newWriterGeneration(99L).build();
 *
                return newId;
        long gen = 99L;
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
    }
    public void testMergeWithRowIdMappingRemapsRowIds() throws IOException {
        if (writer != null) {
        LuceneMerger merger = new LuceneMerger(writer, new LuceneDataFormat(), dataPath, new LuceneShardStatsTracker());
import org.apache.lucene.store.NIOFSDirectory;
        try (DirectoryReader reader = DirectoryReader.open(writer)) {
        );
     *       {@code executeMerge}, which runs too late to influence the codec write).</li>
    /**
            assertTrue("gen=2 has no deletes", liveDocs.allAlive(2L));
        assertNotNull("Merged segment must carry writer_generation=" + newGeneration + " in the live SegmentInfos", mergedInMemory);
import org.apache.lucene.search.Sort;
        MergePreparation result = merger.prepareMerge(input);
            assertFalse("deleted doc must be flagged dead", liveDocs.isAlive(1L, 1));
import org.apache.lucene.document.StringField;
        //
     * </ol>
        assertFalse(result.getMergedWriterFileSet().isEmpty());
        );
            for (LeafReaderContext ctx : reader.leaves()) {
                return sci;
                }
                    String id = doc.get("id");
        );
        writer.commit();
        writer = new MergeIndexWriter(directory, iwc);
            doc.add(new StringField("id", "doc_" + (startRowId + i), Field.Store.YES));
                .liveDocs(preparation.liveDocs())
        long gen = 99L;
        writeSegment(writer, 1L, 0, 3); // docs doc_0..doc_2
        MergeInput input = MergeInput.builder().segments(segments).rowIdMapping(identity).newWriterGeneration(newGeneration).build();
        MergeInput mergeInput = MergeInput.builder()
        // gen=1: doc_0 (rowId=0), doc_1 (rowId=1), doc_2 (rowId=2)
        try (MergePreparation preparation = merger.prepareMerge(MergeInput.builder().segments(segments).newWriterGeneration(gen).build())) {
    public void testMergedSegmentWriterGenerationIsPersisted() throws IOException {
        long gen = 99L;
        MergePreparation preparation = merger.prepareMerge(input);
        // Mapping interleaves segments but preserves within-segment order:
        MergeInput input = MergeInput.builder().segments(segments).rowIdMapping(identityMapping).newWriterGeneration(10L).build();
        w.flush();
            for (int i = 0; i < 5; i++) {
