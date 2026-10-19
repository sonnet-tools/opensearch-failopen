     * Lucene spill a new segment every 20 docs deterministically.  
                LuceneDocumentInput input = new LuceneDocumentInput();
                assertNotNull(markerDV);  
                    assertTrue(rowIdDV.advanceExact(docId));
        Path baseDir = createTempDir();  
                null,  
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
                LeafReader leaf = reader.leaves().get(0).reader();
 * this file be licensed under the Apache-2.0 license or a
                null,  
                }
        int numDocs = 6;
                return 1024.0;
            oldRowIds[i] = i;
 * The OpenSearch Contributors require contributions made to  
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
        try (  
                Codec.getDefault(),
        Path baseDir = createTempDir();
            dataFormat,
                }
                writer.addDoc(input);
        Path baseDir = createTempDir();
        }
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
                    assertThat(rowIdDV.nextValue(), equalTo((long) docId));
        // Force multiple buffered segments deterministically: 200 docs / 20 per buffer
     * When Lucene is primary with IndexSort and docs are already in sorted order,
                for (int docId = 0; docId < numDocs; docId++) {
            assertThat(
                1L,
                dataFormat,  
                Codec.getDefault(),
        MappedFieldType textField = mockTextField("content");
    }
                        "marker at position " + docId + " should be " + expectedMarker,
        ) {  
import org.opensearch.index.engine.dataformat.FlushInput;
                    assertTrue(scoreDV.advanceExact(docId));
                writer.addDoc(input);  
                Codec.getDefault(),
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
        }
                }  
    @Override
        for (int i = 0; i < numDocs; i++) {  
                ConcurrentHashMap.newKeySet(),
            oldToNew[i] = i;
                    assertTrue(rowIdDV.advanceExact(docId));  
            1L,
                ConcurrentHashMap.newKeySet(),  
        // When no user sort is configured, the writer still needs a row_id IndexSort  
            assertTrue(fileInfos.writerFilesMap().isEmpty());
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
                assertNotNull("___row_id doc values should exist in sorted segment", rowIdDV);  
            FileInfos fileInfos = writer.flush(sortedFlushInput);
        int numDocs = 5;
            }  
                ConcurrentHashMap.newKeySet(),
        MappedFieldType textField = mockTextField("content");
                "flush must produce a .liv (liveDocs) file for the deferred positional delete",
    }
     */
    }
                0L,  
        MappedFieldType textField = mockTextField("content");
                null,
    public void setUp() throws Exception {
                null,
 *
            LuceneWriter writer = new LuceneWriter(
                ex.getMessage(),
 * Verifies that documents are reordered according to the sort permutation  
     * @param maxBufferedDocsOverride non-null to override the writer's default max-buffered-docs
     * retained (maxDoc == 3, 1:1 with parquet) and hidden via {@code .liv} (numDocs == 2); the hidden
import org.opensearch.index.engine.exec.WriterFileSet;
            assertThat(wfs.numRows(), equalTo((long) numDocs));
                null,
        MappedFieldType textField = mockTextField("content");
            FileInfos fileInfos = writer.flush(sortedFlushInput);
            null,  
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
                        equalTo(String.valueOf(gen))  
    public void testUnsortedFlushMergesMultipleSegmentsBeforePositionalDeletes() throws IOException {
    /**
                null,
                new LuceneShardStatsTracker()
                dataFormat,  
import org.apache.lucene.search.SortedNumericSortField;
                LeafReader leaf = reader.leaves().get(0).reader();  
     * same as unsorted flush.
import java.nio.file.Path;
 */
                baseDir,  
        ) {
                    assertTrue(rowIdDV.advanceExact(docId));
        int numDocs = 3;
        ) {
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                input.getFinalInput().add(new SortedNumericDocValuesField("marker", i * 100L));
        int numDocs = 20;  
        }
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
    public void testSortedFlushReordersDocuments() throws IOException {
        int numDocs = oldRowIds.length;
                0L,  
                        equalTo(expectedScore)  
                    assertThat(  
                dataFormat,
                rowIdSort,  
        long[] newRowIds = new long[numDocs];
                assertThat(leaf.maxDoc(), equalTo(numDocs));
     * After a sorted flush with reorder + row ID rewrite, non-row-id fields must be
     * appear at the same position in doc order — confirming the segment is identical to
                1L,  
                assertTrue(markerDV.advanceExact(0));
                }
        Path baseDir = createTempDir();
                Codec.getDefault(),
            LuceneWriter writer = new LuceneWriter(  
        int[] deletedPositions = { 5, 25, 45 };
                    // position docId came from original position (N-1-docId), so its
 * from the primary data format (Parquet).
                    assertThat(  
     * To prove no reordering happened, each doc carries a {@code marker} doc value equal  
                // if any reordering had taken place.
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);  
            LuceneWriter writer = new LuceneWriter(
        ) {
                for (int docId = 0; docId < numDocs; docId++) {  
import org.apache.lucene.util.Bits;
     *   - {@code ___row_id} doc values must be sequential 0..N-1 (rewritten in the merge)  
     * to {@code rowId * 100}. After flush, both {@code __row_id__} and {@code marker} must
            assertThat(wfs.writerGeneration(), equalTo(gen));
                assertThat(reader.numDocs(), equalTo(numDocs));
                ConcurrentHashMap.newKeySet(),  
                ConcurrentHashMap.newKeySet(),
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
        long[] newRowIds = new long[numDocs];
                baseDir,
        final int override = maxBufferedDocsOverride;  
                1L,
    public void testSortedFlushWithPositionalDeleteRetainsRowAndMarksDeleted() throws IOException {  
        ) {
    public void testEmptyFlushInputUsesUnsortedPath() throws IOException {
     * with the writer generation on its {@code .si}. Both {@code LuceneReaderManager} and the refresh
            )  
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();  
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
     */
            LuceneWriter writer = new LuceneWriter(
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                    );
    public void testFlushStampsWriterGenerationOnSegmentInfo() throws IOException {  
                input.getFinalInput().add(new SortedNumericDocValuesField("age", ages[i]));
        }
                for (int docId = 0; docId < numDocs; docId++) {  
            @Override  
import org.apache.lucene.document.SortedNumericDocValuesField;
                0L,
     *
        Path baseDir = createTempDir();
     * Reusable scenario: index N docs with a {@code marker} side-channel in arrival order,
        long[] ages = { 10, 20, 30, 40, 50 };  
                    assertThat(  
                LuceneDocumentInput input = new LuceneDocumentInput();  
                        "score at new position " + docId + " should be " + expectedScore,
                writer.addDoc(input);
                input.addField(textField, "doc_" + i);
                SortedNumericDocValues markerDV = leaf.getSortedNumericDocValues("marker");
    }
     * exercise the multi-segment merge path — where the configured
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
    }
                Codec.getDefault(),
                    assertThat(rowIdDV.nextValue(), equalTo((long) docId));  
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
            assertTrue(wfs.files().stream().anyMatch(file -> file.endsWith(".liv")));
     * is easy to attribute.
                Codec.getDefault(),  
            oldRowIds[i] = i;
        runSortedFlushAndAssert(/* maxBufferedDocsOverride= */ 20);
                null,  
        long[] newRowIds = { 2, 0, 1 };
     * has docs reordered so that ___row_id at doc position 0 is 4 (the doc
     * positional delete of insertion row id 1, flushed with permutation (0→2, 1→0, 2→1). The row is
                ex.getMessage(),
                LuceneDocumentInput input = new LuceneDocumentInput();
                new LuceneShardStatsTracker()  
                // After reverse sort with row ID rewrite: docs are physically reordered,
                dataFormat,
     *   - the {@code marker} side-channel must follow the reverse permutation, proving
                Codec.getDefault(),
    }
                dataFormat,
            LuceneWriter writer = new LuceneWriter(
                LuceneDocumentInput input = new LuceneDocumentInput();
        // Build a reverse sort permutation: old_row_id → new_row_id  
     */
        }  
 */  
/**
    public void testFlushFailsWhenIndexSortAndRowIdMappingAreBothConfigured() throws IOException {
                    );
                null,
                    // Row IDs rewritten to sequential 0..N-1 in the post-reorder doc order.  
        Path baseDir = createTempDir();  
                assertThat("flush must produce exactly one segment", infos.size(), equalTo(1));
                for (int docId = 0; docId < numDocs; docId++) {
                LuceneDocumentInput input = new LuceneDocumentInput();
                LeafReader leaf = reader.leaves().get(0).reader();
     * physically reordered to follow the docs (their values stay attached to their
                SortedNumericDocValues markerDV = leaf.getSortedNumericDocValues("marker");
            for (int i = 0; i < numDocs; i++) {
     * as an unsorted flush.  
                new LuceneShardStatsTracker()
     */  
                input.addField(textField, "doc_" + i);
                assertNotNull("liveDocs must exist after a positional delete", liveDocs);  
            LuceneWriter writer = new LuceneWriter(
                ConcurrentHashMap.newKeySet(),  
            );
                assertTrue(liveDocs.get(1));
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
                baseDir,
        long[] oldRowIds = new long[numDocs];
     * When the child IndexWriter is configured with an IndexSort (Lucene as primary),  
            newRowIds[i] = i;
                new LuceneShardStatsTracker()
        Path baseDir = createTempDir();
                }
                }
                LuceneDocumentInput input = new LuceneDocumentInput();  
        return new PackedRowIdMapping(oldToNew, true);  
            }
        MappedFieldType textField = mockTextField("content");
        // Enough docs that with a small maxBufferedDocs Lucene is forced to spill multiple segments.
        }
            LuceneWriter writer = new LuceneWriter(
import org.apache.lucene.index.LeafReader;
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
        long generation = 7L;  
                org.hamcrest.Matchers.containsString("RowIdMapping")  
                    assertThat(  
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);  
                ConcurrentHashMap.newKeySet(),
                    assertTrue(markerDV.advanceExact(docId));
                0L,
                null,
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {  
                null,  
                input.getFinalInput().add(new SortedNumericDocValuesField("marker", i * 100L));
        Sort indexSort = new Sort(new SortedNumericSortField("age", SortField.Type.LONG));
            )
                new LuceneShardStatsTracker()  
                    );
                1L,
    public void testSortedFlushAcrossMultipleSegmentsReordersAndRewritesRowIds() throws IOException {
                writer.addDoc(input);  
    }
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);  
            }
        dataFormat = new LuceneDataFormat();
     *                                via the package-private {@code maxBufferedDocs()} hook  
                assertThat(reader.leaves().size(), equalTo(1));
                assertNotNull(markerDV);  
import org.apache.lucene.codecs.Codec;
    }  
                gen,  
        try (
        int numDocs = 10;
import org.apache.lucene.index.SegmentInfos;
 * SPDX-License-Identifier: Apache-2.0
                for (int docId = 0; docId < numDocs; docId++) {
                for (int docId = 0; docId < numDocs; docId++) {  
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
    /**  
                // from original position (numDocs-1-d), so it carries score (numDocs-1-d)*100.  
        Path baseDir = createTempDir();
            }
                for (int position : deletedPositions) {
     * twice (once natively by Lucene's IndexSort, once via the row ID permutation).
    }
                writer.addDoc(input);
                baseDir,
            for (int i = 0; i < numDocs; i++) {
            }
    private LuceneDataFormat dataFormat;
                null,
        ) {  
            assertThat(wfs.numRows(), equalTo((long) numDocs));  
    /**
     * flushing and sets {@code maxBufferedDocs()} to a small value (20), which makes
                new LuceneShardStatsTracker()
        // Permutation: insertion row id 1 (v_old) maps to post-reorder position 0.
                LuceneDocumentInput input = new LuceneDocumentInput();  
        Path baseDir = createTempDir();
        try (
        };  
        }  
            protected int maxBufferedDocs() {  
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
    /**
            LuceneWriter writer = new LuceneWriter(
                // Identity permutation: doc at position i should have row_id i
    public void testSortedFlushPreservesWriterGeneration() throws IOException {
            0L,  
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {  
                baseDir,  
    }  
                org.hamcrest.Matchers.containsString(indexSort.toString())
                0L,  
                assertThat(reader.leaves().size(), equalTo(1));
                new LuceneShardStatsTracker()
     * names the configured sort and the writer generation, so the misconfiguration
            for (int position : deletedPositions) {
                ConcurrentHashMap.newKeySet(),  
                null,  
                0L,  
                ex.getMessage(),  
                assertNotNull(liveDocs);
    private static PackedRowIdMapping buildMapping(long[] oldRowIds, long[] newRowIds) {  
    public void testSortedFlushReordersOtherFieldsAndRewritesRowIds() throws IOException {
                ConcurrentHashMap.newKeySet(),
                1L,  
                assertNotNull(scoreDV);
            LuceneWriter writer = new LuceneWriter(
                    assertThat("Doc at position " + docId + " should have sequential row_id " + docId, rowIdValue, equalTo((long) docId));
            writer.recordPositionalDelete(1L);  
                assertThat(reader.leaves().size(), equalTo(1));
                for (int docId = 0; docId < numDocs; docId++) {
            new LuceneShardStatsTracker()
     * (0→4, 1→3, 2→2, 3→1, 4→0). Verifies that the resulting Lucene segment  
                input.addField(textField, "doc_" + i);
                }  
    public void testIdentityPermutationPreservesOrder() throws IOException {
    /**  
            )  
            // liveDocs-only delete to this flush (phase 2), retaining the row through the reorder.
                        equalTo(docId * 100L)  
     * so that LuceneIndexingExecutionEngine.refresh() can correlate it.
            FileInfos fileInfos = writer.flush(sortedFlushInput);
import static org.hamcrest.Matchers.equalTo;
                Bits liveDocs = leaf.getLiveDocs();
                assertNotNull(markerDV);  
import org.apache.lucene.search.Sort;  
        long[] oldRowIds = new long[numDocs];
     */  
        }
        ) {
     *
            }
                    assertThat(rowIdDV.nextValue(), equalTo((long) docId));
    public void testSortedFlushProducesSingleSegment() throws IOException {
            )  
        // Sorted order: 4, 3, 2, 1, 0 (reverse)
            assertThat(  
    /**
                null,
    public void testPrimaryFormatIndexSortWithAlreadySortedDocs() throws IOException {
                LuceneDocumentInput input = new LuceneDocumentInput();  
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
    }
                // So doc at position docId should have row_id = docId.
            assertThat(wfs.numRows(), equalTo((long) numDocs));
        MappedFieldType textField = mockTextField("content");
                baseDir,
     */  
                // Row retained physically (maxDoc unchanged); exactly one doc hidden via liveDocs.
        Sort rowIdSort = new Sort(new SortedNumericSortField(LuceneDocumentInput.ROW_ID_FIELD, SortField.Type.LONG));
                SortedNumericDocValues markerDV = leaf.getSortedNumericDocValues("marker");
    /**
}
                new LuceneShardStatsTracker()
            return new LuceneWriter(  
        }  
                baseDir,
                baseDir,
                // proving doc at position docId is the doc originally inserted with row ID docId.  
            oldToNew[(int) oldRowIds[i]] = newRowIds[i];
            oldRowIds[i] = i;
     * The flush call must fail fast with an IllegalStateException whose message  
        long[] oldRowIds = { 0, 1, 2 };  
            // Read the sorted segment and verify doc order
                input.addField(textField, "doc_" + i);
                writer.addDoc(input);  
        try (
        long[] oldRowIds = new long[numDocs];
     * Guards that a freshly flushed segment stamps {@link LuceneWriter#WRITER_GENERATION_ATTRIBUTE}
            }  
    }
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();  
     */  
        }
    }
        MappedFieldType textField = mockTextField("content");  
        for (int i = 0; i < numDocs; i++) {  
     * no longer stamps it (the codec does), so assert it survives a reorder flush.
                input.addField(textField, "doc_" + i);  
            FileInfos fileInfos = writer.flush(sortedFlushInput);  
                assertTrue(liveDocs.get(2));  
            for (int i = 0; i < numDocs; i++) {
            FileInfos fileInfos = writer.flush(sortedFlushInput);
                }  
            }  
     * Identity permutation (0→0, 1→1, ...) should produce the same doc order
        try (  
                input.addField(textField, "doc_" + i);  
                input.getFinalInput().add(new SortedNumericDocValuesField("score", i * 100L));
            }  
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();  
                indexSort,
        }
                // Single committed segment after forceMerge(1) regardless of how many  
                writer.addDoc(input);
        }
/*  
        if (maxBufferedDocsOverride == null) {
                writer.recordPositionalDelete(position);  
                    assertTrue(rowIdDV.advanceExact(docId));
        long[] oldRowIds = new long[numDocs];
     */
            }
     * When overriding, RAM-buffer flushing is disabled so doc count is the sole trigger.
        long[] oldRowIds = { 0, 1, 2, 3, 4 };  
                null,
import java.io.IOException;
                writer.addDoc(input);  
        }  
                baseDir,  
        int numDocs = 60;  
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);  
            }
                        "marker at position " + docId + " must equal " + (docId * 100L) + " (no reordering)",
                Codec.getDefault(),
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                    );
                dataFormat,
     * Verifies that the sorted segment preserves the writer generation attribute
     */  
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
            }  
            )
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {  
                ConcurrentHashMap.newKeySet(),
        long[] newRowIds = { 2, 0, 1 };
            )
    }
                assertNotNull(rowIdDV);  
     * drop-generation reconciliation hard-require this attribute on every live leaf; the reorder merge  
        MappedFieldType textField = mockTextField("content");
     * segment — the test overrides the package-private hooks: disables RAM-buffer
            }
        for (int i = 0; i < oldRowIds.length; i++) {  
        ) {
        for (int i = 0; i < numDocs; i++) {  
                0L,  
    /**
                assertNotNull(rowIdDV);  
                LeafReader leaf = reader.leaves().get(0).reader();
                Codec.getDefault(),
        long[] oldRowIds = { 0, 1, 2 };
                LuceneDocumentInput input = new LuceneDocumentInput();  
        }  
            // All rows retained (aligned with parquet), and a .liv was produced and cataloged.
     * rewritten to sequential 0..N-1 in the new doc order. This guarantees:
                assertThat(reader.leaves().size(), equalTo(1));
    private LuceneWriter newWriterWithMaxBufferedDocs(Path baseDir, Integer maxBufferedDocsOverride) throws IOException {
            )  
    }  
            assertThat(wfs.numRows(), equalTo((long) numDocs));  
                assertThat(reader.leaves().size(), equalTo(1));
            for (int i = 0; i < numDocs; i++) {
            for (int i = 0; i < numDocs; i++) {
                // Unsorted: row IDs sequential 0..N-1 AND marker[docId] == docId*100,
                // The deleted doc is the one that carried insertion row id 1 → marker 100, now at position 0.
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
public class LuceneWriterSortedFlushTests extends LucenePluginBaseTests {  
     */
        long[] oldRowIds = { 0, 1 };
        MappedFieldType textField = mockTextField("content");
    }
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
        Sort indexSort = new Sort(new SortedNumericSortField("age", SortField.Type.LONG));  
                indexSort,
            }  
                0L,
        long[] oldToNew = new long[numDocs];
            }
     * RAM buffer) or a small value (e.g. 20) to force deterministic multi-segment creation.
package org.opensearch.be.lucene.index;
     * RAM buffer, so all docs land in a single in-memory segment before flush. To
    }
            for (int i = 0; i < numDocs; i++) {
                    long rowIdValue = rowIdDV.nextValue();
        // Full reverse permutation: 0→5, 1→4, ..., 5→0
     *   - user-field correctness (no value loss or reassignment)  
                    assertFalse("generation-wide position " + position + " must be deleted", liveDocs.get(position));  
                1L,  
import org.opensearch.be.lucene.LuceneDataFormat;
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
    /**  
            )  
            );
        }
            assertThat(
                    // marker is (N-1-docId)*100.  
                // Already sorted → row IDs remain sequential
        long[] oldRowIds = { 0, 1, 2 };
        }
import org.opensearch.index.engine.dataformat.FileInfos;
        try (
     * a FlushInput carrying a RowIdMapping is contradictory — sorting would be applied
                assertNotNull(rowIdDV);
                writer.addDoc(input);
            for (int i = 0; i < numDocs; i++) {
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
    /**
        Path baseDir = createTempDir();
            }  
                writer.addDoc(input);
        MappedFieldType textField = mockTextField("content");
                Bits liveDocs = leaf.getLiveDocs();  
        long[] newRowIds = { 2, 0, 1 };
                        markerDV.nextValue(),
                for (SegmentCommitInfo sci : infos) {
                // __row_id__ still sequential 0..N-1 (deleted docs keep their doc values).
                new LuceneShardStatsTracker()
                baseDir,
     * Sorted flush across multiple in-flight Lucene segments.
import org.apache.lucene.store.NIOFSDirectory;  
        }  
                Codec.getDefault(),
        return new LuceneWriter(
        int numDocs = 5;
     * flush with a reverse permutation, then assert reorder + row ID rewrite.  
    private void runSortedFlushAndAssert(Integer maxBufferedDocsOverride) throws IOException {  
        long gen = 13L;
                null,  
        int numDocs = 5;  
        try (  
    public void testSortedFlushWithNoDocsReturnsEmpty() throws IOException {  
                // Marker doc value uniquely tied to row ID — would diverge from row ID  
     * Constructs a {@link LuceneWriter} with an optional override of the package-private
     * <p>By default {@link LuceneWriter} disables doc-count flushing and uses a 256 MB  
                dataFormat,
                baseDir,  
        super.setUp();  
                wfs.files().stream().anyMatch(f -> f.endsWith(".liv"))  
                0L,
                null,
            FileInfos fileInfos = writer.flush(sortedFlushInput);  
        ) {  
        try (  
        for (int i = 0; i < numDocs; i++) {
        try (
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();  
            )
            for (int i = 0; i < numDocs; i++) {
                gen,
     *     the reorder actually moved docs and is not just an effect of natural ordering.
     * original docs, just at new positions), while the {@code ___row_id} field is  
                1L,  
                LuceneDocumentInput input = new LuceneDocumentInput();
        // = 10 in-flight segments before forceMerge(1).  
            assertTrue(
    /**  
import org.apache.lucene.index.SortedNumericDocValues;
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory()))) {
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
        Path baseDir = createTempDir();
     */  
                org.hamcrest.Matchers.containsString(Long.toString(generation))
     *
                dataFormat,
                    assertThat(rowIdDV.nextValue(), equalTo((long) docId));
     * <p>After {@code flush(FlushInput)} with a reverse permutation:
        }
            }
        // Docs already in sorted order
            FileInfos fileInfos = writer.flush(sortedFlushInput);
                dataFormat,
                Codec.getDefault(),
            @Override
        long gen = 42L;  
                new LuceneShardStatsTracker()
        long[] newRowIds = { 2, 0, 1 };  
        Path baseDir = createTempDir();  
    /**
     * doc is the one from insertion row id 1 (marker 100) at post-reorder position 0, and  
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);  
import java.util.concurrent.ConcurrentHashMap;  
            }
                LuceneDocumentInput input = new LuceneDocumentInput();
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);  
        try (  
                        scoreDV.nextValue(),
                input.addField(textField, "doc_" + i);
                assertNotNull(rowIdDV);
     * the insertion sequence and that the reorder merge policy was never installed.  
                assertThat(reader.maxDoc(), equalTo(numDocs));
            // Same-generation update: the prior version was inserted at row id 1. Defer its
     * {@code __row_id__} stays sequential.
        long[] newRowIds = { 1, 0 };  
                // Score field is reordered (not rewritten): new doc at position d came
                assertThat(leaf.maxDoc(), equalTo(numDocs));
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();  
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                null,  
                input.getFinalInput().add(new SortedNumericDocValuesField("age", i));
        try (LuceneWriter writer = newWriterWithMaxBufferedDocs(baseDir, 20)) {
     * Verifies that the sorted segment has exactly 1 segment with the correct doc count.
                LuceneDocumentInput input = new LuceneDocumentInput();  
            newRowIds[i] = numDocs - 1 - i;  
     */  
     * the segment should preserve the original order.
                LeafReader leaf = reader.leaves().get(0).reader();
     * FlushInput.EMPTY should trigger the unsorted path, leaving docs in insertion order.
                0L,
            )
                input.addField(textField, "doc_" + i);
                assertThat("deleted position 0 must be the former row-id-1 doc (marker 100)", markerDV.nextValue(), equalTo(100L));
                dataFormat,
     */
                null,  
            for (int i = 0; i < 3; i++) {
                writer.addDoc(input);
        MappedFieldType textField = mockTextField("content");  
                    long expectedMarker = (numDocs - 1 - docId) * 100L;
            baseDir,
                null,
            }  
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));  
                null,  
                1L,
        Path baseDir = createTempDir();
            );
     * Writes 5 docs with row IDs 0..4, then flushes with a reverse permutation
     * Sorted flush with zero documents should return empty FileInfos,  
            );
                assertThat(reader.numDocs(), equalTo(numDocs - 1));  
                SegmentInfos infos = SegmentInfos.readLatestCommit(dir);  
            }  
                // User field: doc i carries score i*100  
                    long expectedScore = (numDocs - 1 - docId) * 100L;
            assertThat(wfs.numRows(), equalTo((long) numDocs));
            Codec.getDefault(),
                dataFormat,
                }
import org.apache.lucene.index.DirectoryReader;  
        try (LuceneWriter writer = newWriterWithMaxBufferedDocs(baseDir, maxBufferedDocsOverride)) {  
     */
            ConcurrentHashMap.newKeySet(),  
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
                Codec.getDefault(),  
                        markerDV.nextValue(),
    /**
                    assertThat(rowIdDV.nextValue(), equalTo((long) docId));
                SortedNumericDocValues scoreDV = leaf.getSortedNumericDocValues("score");
                    assertTrue(rowIdDV.advanceExact(docId));
     * {@code ReorderingMergePolicy} drives a reorder that spans more than one source  
            FileInfos fileInfos = writer.flush(sortedFlushInput);  
        // Default: a single segment is produced before flush, no inter-segment merge needed.
        int numDocs = 200;  
            for (int i = 0; i < 3; i++) {
 * compatible open source license.
        // Shift-by-one permutation: 0→1, 1→2, ..., (N-1)→0  
                new LuceneShardStatsTracker()
     * that was originally at row 4 is now first).
                input.addField(textField, "doc_" + i);
            IllegalStateException ex = expectThrows(IllegalStateException.class, () -> writer.flush(sortedFlushInput));
                LeafReader leaf = reader.leaves().get(0).reader();
        long[] newRowIds = { 4, 3, 2, 1, 0 };
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;  
            protected double ramBufferSizeMB() {
                generation,
                1L,
                ConcurrentHashMap.newKeySet(),  
                // intermediate segments existed during indexing.
        ) {  
                "exception message should include the writer generation",
        ) {
            newRowIds[i] = numDocs - 1 - i;
                LeafReader leaf = reader.leaves().get(0).reader();
                return override;
    // ── Tests for Lucene as primary format (with IndexSort) ──
     *   - cross-format alignment with Parquet (sequential row IDs at each doc position)
import org.apache.lucene.index.IndexReader;
     * {@code maxBufferedDocs()} hook. Pass {@code null} for the default (single segment via  
            }  
            }  
            oldRowIds[i] = i;
                assertThat(reader.numDocs(), equalTo(numDocs));
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
        }  
            newRowIds[i] = (i + 1) % numDocs;
                new LuceneShardStatsTracker()
                baseDir,  
        // (matching what LuceneCommitter sets in production for the unsorted primary case).
                dataFormat,
            }  
                    assertTrue(rowIdDV.advanceExact(docId));  
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                null,
                0L,
        long[] newRowIds = new long[numDocs];  
                assertFalse("post-reorder position 0 (former row id 1) must be deleted", liveDocs.get(0));
            );  
            LuceneWriter writer = new LuceneWriter(
 * Tests for {@link LuceneWriter#flush(FlushInput)} with sort permutation.
                    assertTrue(rowIdDV.advanceExact(docId));
                assertThat(reader.numDocs(), equalTo(numDocs - deletedPositions.length));  
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();  
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); DirectoryReader reader = DirectoryReader.open(dir)) {  
        ) {  
                ConcurrentHashMap.newKeySet(),
        try (
                    assertTrue(markerDV.advanceExact(docId));
import org.opensearch.index.mapper.MappedFieldType;
                input.getFinalInput().add(new SortedNumericDocValuesField("marker", i * 100L));  
import org.apache.lucene.search.SortField;
     *                                (RAM-buffer flushing is disabled in that case)
                input.addField(textField, "doc_" + i);  
        }
import org.opensearch.index.engine.dataformat.PackedRowIdMapping;  
                        sci.info.getAttribute(LuceneWriter.WRITER_GENERATION_ATTRIBUTE),
                // Row IDs are rewritten to sequential 0..N-1 in the new doc order  
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);  
            LuceneWriter writer = new LuceneWriter(
                LeafReader leaf = reader.leaves().get(0).reader();
                assertNotNull(rowIdDV);
                "exception message should reference RowIdMapping",
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();  
        // Original order: 0, 1, 2, 3, 4
        runSortedFlushAndAssert(/* maxBufferedDocsOverride= */ null);  
            for (int i = 0; i < oldRowIds.length; i++) {  
                // and __row_id__ values are rewritten to sequential 0..N.  
                "exception message should include the configured IndexSort",  
                        equalTo(expectedMarker)  
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
            }
            null,
            for (int i = 0; i < numDocs; i++) {
            FileInfos fileInfos = writer.flush(sortedFlushInput);
                writer.addDoc(input);  
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
            }  
import org.apache.lucene.index.SegmentCommitInfo;  
                    // Marker side-channel proves the reverse reorder fired: doc at new
                }  
        long[] oldRowIds = { 0, 1, 2 };  
                        "every flushed .si must carry the writer_generation attribute",
                0L,
        long[] newRowIds = new long[numDocs];
            assertThat(wfs.writerGeneration(), equalTo(1L));
            assertTrue(fileInfos.getWriterFileSet(dataFormat).isPresent());
                assertNotNull(rowIdDV);
    /**  
                    assertThat(rowIdDV.nextValue(), equalTo((long) docId));
                for (int docId = 0; docId < numDocs; docId++) {  
            )
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
        for (int i = 0; i < numDocs; i++) {  
        // Reverse permutation: doc inserted at position i ends up at position (N-1-i)  
                input.addField(textField, "doc_" + i);  
     * Two-phase sorted flush with a positional delete (same-generation create→update): 3 docs, a  
