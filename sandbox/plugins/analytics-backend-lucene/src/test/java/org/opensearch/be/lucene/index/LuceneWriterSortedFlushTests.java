        }
     *                                via the package-private {@code maxBufferedDocs()} hook
                // Marker doc value uniquely tied to row ID — would diverge from row ID
     *
                }
                    assertThat(rowIdDV.nextValue(), equalTo((long) docId));
                for (int docId = 0; docId < numDocs; docId++) {
                assertNotNull(scoreDV);
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
        for (int i = 0; i < oldRowIds.length; i++) {
                }
            newRowIds[i] = numDocs - 1 - i;
                dataFormat,
            assertThat(
            // liveDocs-only delete to this flush (phase 2), retaining the row through the reorder.
            for (int i = 0; i < oldRowIds.length; i++) {
            LuceneWriter writer = new LuceneWriter(
                // After reverse sort with row ID rewrite: docs are physically reordered,
                0L,
        MappedFieldType textField = mockTextField("content");
            LuceneWriter writer = new LuceneWriter(
        }
     * as an unsorted flush.
                null,
        Path baseDir = createTempDir();
                ConcurrentHashMap.newKeySet(),
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                for (int docId = 0; docId < numDocs; docId++) {
                Bits liveDocs = leaf.getLiveDocs();
     * appear at the same position in doc order — confirming the segment is identical to
    public void testSortedFlushReordersDocuments() throws IOException {
    public void testSortedFlushWithNoDocsReturnsEmpty() throws IOException {
            1L,
    public void testSortedFlushAcrossMultipleSegmentsReordersAndRewritesRowIds() throws IOException {
        long[] oldRowIds = { 0, 1, 2 };
        MappedFieldType textField = mockTextField("content");
            FileInfos fileInfos = writer.flush(sortedFlushInput);
                // if any reordering had taken place.
                input.getFinalInput().add(new SortedNumericDocValuesField("marker", i * 100L));
            LuceneWriter writer = new LuceneWriter(
                org.hamcrest.Matchers.containsString("RowIdMapping")
                // from original position (numDocs-1-d), so it carries score (numDocs-1-d)*100.
                    );
            // All rows retained (aligned with parquet), and a .liv was produced and cataloged.
    }
                baseDir,
     * names the configured sort and the writer generation, so the misconfiguration
        long[] oldRowIds = { 0, 1, 2 };
            FileInfos fileInfos = writer.flush(sortedFlushInput);
 */
            LuceneWriter writer = new LuceneWriter(
            @Override
        ) {
                "exception message should reference RowIdMapping",
        long[] newRowIds = { 2, 0, 1 };
        }
        int numDocs = 10;
        // Full reverse permutation: 0→5, 1→4, ..., 5→0
package org.opensearch.be.lucene.index;
            }
        ) {
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
import org.apache.lucene.index.SortedNumericDocValues;
    }
            for (int i = 0; i < numDocs; i++) {
        try (
                // Row retained physically (maxDoc unchanged); exactly one doc hidden via liveDocs.
                dataFormat,
            @Override
        long[] oldRowIds = { 0, 1, 2 };
                LuceneDocumentInput input = new LuceneDocumentInput();
            }
            assertThat(wfs.writerGeneration(), equalTo(1L));
    /**
                Codec.getDefault(),
                generation,
                baseDir,
    }
        MappedFieldType textField = mockTextField("content");
        // Enough docs that with a small maxBufferedDocs Lucene is forced to spill multiple segments.
                assertThat("flush must produce exactly one segment", infos.size(), equalTo(1));
        Path baseDir = createTempDir();
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
        ) {
                    );
     * The flush call must fail fast with an IllegalStateException whose message
                dataFormat,
                input.addField(textField, "doc_" + i);
                for (int docId = 0; docId < numDocs; docId++) {
                SortedNumericDocValues scoreDV = leaf.getSortedNumericDocValues("score");
     * same as unsorted flush.
     * original docs, just at new positions), while the {@code ___row_id} field is
    }
        try (
            )
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
        long generation = 7L;
                baseDir,
                Codec.getDefault(),
            )
                new LuceneShardStatsTracker()
     * retained (maxDoc == 3, 1:1 with parquet) and hidden via {@code .liv} (numDocs == 2); the hidden
                Codec.getDefault(),
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
                assertNotNull(rowIdDV);
import org.opensearch.be.lucene.LuceneDataFormat;
import org.apache.lucene.search.SortField;
     * @param maxBufferedDocsOverride non-null to override the writer's default max-buffered-docs
            for (int i = 0; i < numDocs; i++) {
            0L,
            }
                0L,
                null,
                    long expectedMarker = (numDocs - 1 - docId) * 100L;
        }
            )
            for (int i = 0; i < numDocs; i++) {
            for (int i = 0; i < numDocs; i++) {
                0L,
                LuceneDocumentInput input = new LuceneDocumentInput();
        ) {
            for (int i = 0; i < numDocs; i++) {
                    assertThat("Doc at position " + docId + " should have sequential row_id " + docId, rowIdValue, equalTo((long) docId));
                null,
                0L,
     */
            LuceneWriter writer = new LuceneWriter(
    }
import org.apache.lucene.index.SegmentCommitInfo;
        MappedFieldType textField = mockTextField("content");
                ex.getMessage(),
                null,
                assertNotNull(rowIdDV);
                assertThat(leaf.maxDoc(), equalTo(numDocs));
        // (matching what LuceneCommitter sets in production for the unsorted primary case).
                ConcurrentHashMap.newKeySet(),
        try (
        long[] oldRowIds = { 0, 1, 2, 3, 4 };
                input.addField(textField, "doc_" + i);
        try (
     * {@code __row_id__} stays sequential.
                1L,
            null,
    private LuceneDataFormat dataFormat;
                new LuceneShardStatsTracker()
     *
        }
    /**
                1L,
                assertNotNull(rowIdDV);
        // Sorted order: 4, 3, 2, 1, 0 (reverse)
                LeafReader leaf = reader.leaves().get(0).reader();
                null,
                writer.addDoc(input);
        Path baseDir = createTempDir();
                assertThat(reader.leaves().size(), equalTo(1));
     * Verifies that the sorted segment has exactly 1 segment with the correct doc count.
        // Shift-by-one permutation: 0→1, 1→2, ..., (N-1)→0
        ) {
            }
                Bits liveDocs = leaf.getLiveDocs();
     *
        // When no user sort is configured, the writer still needs a row_id IndexSort
import org.opensearch.index.engine.dataformat.FileInfos;
        int numDocs = 200;
            )
 *
            assertTrue(fileInfos.writerFilesMap().isEmpty());
        int numDocs = 5;
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
    // ── Tests for Lucene as primary format (with IndexSort) ──
     * Identity permutation (0→0, 1→1, ...) should produce the same doc order
        long[] oldRowIds = new long[numDocs];
    /**
            );
                org.hamcrest.Matchers.containsString(indexSort.toString())
                // Already sorted → row IDs remain sequential
                assertThat(reader.leaves().size(), equalTo(1));
            );
                // Score field is reordered (not rewritten): new doc at position d came
                ConcurrentHashMap.newKeySet(),
            LuceneWriter writer = new LuceneWriter(
}
                for (SegmentCommitInfo sci : infos) {
            protected int maxBufferedDocs() {
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
    public void testIdentityPermutationPreservesOrder() throws IOException {
            oldRowIds[i] = i;
        // = 10 in-flight segments before forceMerge(1).
                assertNotNull("___row_id doc values should exist in sorted segment", rowIdDV);
            new LuceneShardStatsTracker()
                }
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
        for (int i = 0; i < numDocs; i++) {
     * To prove no reordering happened, each doc carries a {@code marker} doc value equal
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
    public void testFlushFailsWhenIndexSortAndRowIdMappingAreBothConfigured() throws IOException {
                        equalTo(expectedMarker)
                }
    }
        Sort indexSort = new Sort(new SortedNumericSortField("age", SortField.Type.LONG));
                assertFalse("post-reorder position 0 (former row id 1) must be deleted", liveDocs.get(0));
                for (int docId = 0; docId < numDocs; docId++) {
 * Tests for {@link LuceneWriter#flush(FlushInput)} with sort permutation.
                1L,
    }
                assertTrue(liveDocs.get(2));
        return new LuceneWriter(
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                null,
    /**
        Path baseDir = createTempDir();
     * RAM buffer) or a small value (e.g. 20) to force deterministic multi-segment creation.
import static org.hamcrest.Matchers.equalTo;
                }
                for (int docId = 0; docId < numDocs; docId++) {
                writer.addDoc(input);
            }
        try (LuceneWriter writer = newWriterWithMaxBufferedDocs(baseDir, 20)) {
                LuceneDocumentInput input = new LuceneDocumentInput();
    }
     * to {@code rowId * 100}. After flush, both {@code __row_id__} and {@code marker} must
        final int override = maxBufferedDocsOverride;
     * Sorted flush with zero documents should return empty FileInfos,
            }
                        equalTo(docId * 100L)
import java.nio.file.Path;
                LuceneDocumentInput input = new LuceneDocumentInput();
                LuceneDocumentInput input = new LuceneDocumentInput();
     * Verifies that the sorted segment preserves the writer generation attribute
            newRowIds[i] = i;
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
     */
                null,
            IllegalStateException ex = expectThrows(IllegalStateException.class, () -> writer.flush(sortedFlushInput));
                rowIdSort,
                baseDir,
                baseDir,
                input.getFinalInput().add(new SortedNumericDocValuesField("age", ages[i]));
        }
            newRowIds[i] = (i + 1) % numDocs;
    public void testSortedFlushPreservesWriterGeneration() throws IOException {
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
     * a FlushInput carrying a RowIdMapping is contradictory — sorting would be applied
/**
    }
                assertNotNull(rowIdDV);
            }
        Path baseDir = createTempDir();
import java.io.IOException;
     * FlushInput.EMPTY should trigger the unsorted path, leaving docs in insertion order.
     * {@code maxBufferedDocs()} hook. Pass {@code null} for the default (single segment via
                dataFormat,
     *   - {@code ___row_id} doc values must be sequential 0..N-1 (rewritten in the merge)
                input.addField(textField, "doc_" + i);
    /**
        long[] oldRowIds = { 0, 1, 2 };
                LeafReader leaf = reader.leaves().get(0).reader();
        int numDocs = 6;
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
                new LuceneShardStatsTracker()
                        "every flushed .si must carry the writer_generation attribute",
                Codec.getDefault(),
                    assertTrue(rowIdDV.advanceExact(docId));
                input.addField(textField, "doc_" + i);
import org.opensearch.index.engine.dataformat.PackedRowIdMapping;
            }
            oldRowIds[i] = i;
                null,
                    // Marker side-channel proves the reverse reorder fired: doc at new
                dataFormat,
            }
     * the insertion sequence and that the reorder merge policy was never installed.
                null,
     */
            for (int i = 0; i < numDocs; i++) {
    public void testSortedFlushWithPositionalDeleteRetainsRowAndMarksDeleted() throws IOException {
        long[] newRowIds = { 2, 0, 1 };
        // Default: a single segment is produced before flush, no inter-segment merge needed.
     * is easy to attribute.
            FileInfos fileInfos = writer.flush(sortedFlushInput);
            assertThat(
        dataFormat = new LuceneDataFormat();
                "exception message should include the configured IndexSort",
                null,
                        "score at new position " + docId + " should be " + expectedScore,
import org.apache.lucene.codecs.Codec;
import org.apache.lucene.util.Bits;
                ConcurrentHashMap.newKeySet(),
        // Force multiple buffered segments deterministically: 200 docs / 20 per buffer
            FileInfos fileInfos = writer.flush(sortedFlushInput);
                    );
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
    /**
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
                assertThat(reader.leaves().size(), equalTo(1));
                LuceneDocumentInput input = new LuceneDocumentInput();
    /**
    private LuceneWriter newWriterWithMaxBufferedDocs(Path baseDir, Integer maxBufferedDocsOverride) throws IOException {
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                    assertTrue(rowIdDV.advanceExact(docId));
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
                ConcurrentHashMap.newKeySet(),
     * RAM buffer, so all docs land in a single in-memory segment before flush. To
            }
                new LuceneShardStatsTracker()
                baseDir,
                assertThat(reader.numDocs(), equalTo(numDocs));
                SegmentInfos infos = SegmentInfos.readLatestCommit(dir);
                writer.recordPositionalDelete(position);
                // Row IDs are rewritten to sequential 0..N-1 in the new doc order
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
     * doc is the one from insertion row id 1 (marker 100) at post-reorder position 0, and
    /**
                input.addField(textField, "doc_" + i);
        }
            FileInfos fileInfos = writer.flush(sortedFlushInput);
    }
                null,
                    assertThat(
                baseDir,
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
     * <p>After {@code flush(FlushInput)} with a reverse permutation:
            dataFormat,
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                    assertThat(rowIdDV.nextValue(), equalTo((long) docId));
                writer.addDoc(input);
                        markerDV.nextValue(),
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
                SortedNumericDocValues markerDV = leaf.getSortedNumericDocValues("marker");
                ConcurrentHashMap.newKeySet(),
                writer.addDoc(input);
            )
                assertThat(reader.maxDoc(), equalTo(numDocs));
                    assertTrue(rowIdDV.advanceExact(docId));
            for (int i = 0; i < numDocs; i++) {
     *   - cross-format alignment with Parquet (sequential row IDs at each doc position)
            )
/*
                input.getFinalInput().add(new SortedNumericDocValuesField("marker", i * 100L));
        // Original order: 0, 1, 2, 3, 4
        // Docs already in sorted order
     * flushing and sets {@code maxBufferedDocs()} to a small value (20), which makes
                indexSort,
        long[] oldRowIds = { 0, 1 };
    private static PackedRowIdMapping buildMapping(long[] oldRowIds, long[] newRowIds) {
            }
                1L,
                assertTrue(liveDocs.get(1));
     * segment — the test overrides the package-private hooks: disables RAM-buffer
    /**
            LuceneWriter writer = new LuceneWriter(
                assertNotNull(rowIdDV);
                ConcurrentHashMap.newKeySet(),
                null,
                dataFormat,
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); DirectoryReader reader = DirectoryReader.open(dir)) {
        Path baseDir = createTempDir();
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                    assertTrue(rowIdDV.advanceExact(docId));
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
                LeafReader leaf = reader.leaves().get(0).reader();
     * Guards that a freshly flushed segment stamps {@link LuceneWriter#WRITER_GENERATION_ATTRIBUTE}
        };
            }
            LuceneWriter writer = new LuceneWriter(
    @Override
        Sort rowIdSort = new Sort(new SortedNumericSortField(LuceneDocumentInput.ROW_ID_FIELD, SortField.Type.LONG));
     * Reusable scenario: index N docs with a {@code marker} side-channel in arrival order,
                writer.addDoc(input);
        runSortedFlushAndAssert(/* maxBufferedDocsOverride= */ null);
                ex.getMessage(),
                assertNotNull(markerDV);
     * When Lucene is primary with IndexSort and docs are already in sorted order,
                    // Row IDs rewritten to sequential 0..N-1 in the post-reorder doc order.
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
        Path baseDir = createTempDir();
        ) {
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
        ) {
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
        }
                ConcurrentHashMap.newKeySet(),
                for (int docId = 0; docId < numDocs; docId++) {
        runSortedFlushAndAssert(/* maxBufferedDocsOverride= */ 20);
                        scoreDV.nextValue(),
                null,
                Codec.getDefault(),
            }
        Path baseDir = createTempDir();
                input.getFinalInput().add(new SortedNumericDocValuesField("marker", i * 100L));
                SortedNumericDocValues markerDV = leaf.getSortedNumericDocValues("marker");
                new LuceneShardStatsTracker()
            null,
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            FileInfos fileInfos = writer.flush(sortedFlushInput);
    /**
            )
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
        int numDocs = 5;
                baseDir,
        int numDocs = oldRowIds.length;
                new LuceneShardStatsTracker()
                assertThat(reader.numDocs(), equalTo(numDocs));
                    assertThat(rowIdDV.nextValue(), equalTo((long) docId));
        try (
            }
        try (LuceneWriter writer = newWriterWithMaxBufferedDocs(baseDir, maxBufferedDocsOverride)) {
                input.getFinalInput().add(new SortedNumericDocValuesField("score", i * 100L));
                    assertTrue(scoreDV.advanceExact(docId));
    }
        MappedFieldType textField = mockTextField("content");
        long[] newRowIds = new long[numDocs];
                LuceneDocumentInput input = new LuceneDocumentInput();
            }
                1L,
                input.getFinalInput().add(new SortedNumericDocValuesField("age", i));
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
                Codec.getDefault(),
                null,
                Codec.getDefault(),
            )
            // Read the sorted segment and verify doc order
                writer.addDoc(input);
     * Constructs a {@link LuceneWriter} with an optional override of the package-private
        long[] newRowIds = { 2, 0, 1 };
     * When overriding, RAM-buffer flushing is disabled so doc count is the sole trigger.
                writer.addDoc(input);
     * flush with a reverse permutation, then assert reorder + row ID rewrite.
            LuceneWriter writer = new LuceneWriter(
        long[] newRowIds = { 4, 3, 2, 1, 0 };
            assertTrue(wfs.files().stream().anyMatch(file -> file.endsWith(".liv")));
                Codec.getDefault(),
        Path baseDir = createTempDir();
        int numDocs = 60;
 * The OpenSearch Contributors require contributions made to
    public void testSortedFlushProducesSingleSegment() throws IOException {
                ConcurrentHashMap.newKeySet(),
     */
                // Unsorted: row IDs sequential 0..N-1 AND marker[docId] == docId*100,
                null,
    /**
                null,
                1L,
import org.opensearch.index.mapper.MappedFieldType;
                    assertThat(
                // The deleted doc is the one that carried insertion row id 1 → marker 100, now at position 0.
                "flush must produce a .liv (liveDocs) file for the deferred positional delete",
    }
            LuceneWriter writer = new LuceneWriter(
                dataFormat,
        try (
            for (int i = 0; i < 3; i++) {
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
    }
     */
            }
                        "marker at position " + docId + " should be " + expectedMarker,
        }
        MappedFieldType textField = mockTextField("content");
                ConcurrentHashMap.newKeySet(),
                    assertThat(
                dataFormat,
        for (int i = 0; i < numDocs; i++) {
            for (int i = 0; i < numDocs; i++) {
import java.util.concurrent.ConcurrentHashMap;
        long[] oldRowIds = new long[numDocs];
        long gen = 13L;
                    assertTrue(markerDV.advanceExact(docId));
                ConcurrentHashMap.newKeySet(),
import org.apache.lucene.search.SortedNumericSortField;
                // Single committed segment after forceMerge(1) regardless of how many
                SortedNumericDocValues markerDV = leaf.getSortedNumericDocValues("marker");
                org.hamcrest.Matchers.containsString(Long.toString(generation))
        MappedFieldType textField = mockTextField("content");
                }
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
                input.addField(textField, "doc_" + i);
                0L,
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
            )
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
    public void testPrimaryFormatIndexSortWithAlreadySortedDocs() throws IOException {
import org.apache.lucene.search.Sort;
        }
        ) {
                        equalTo(expectedScore)
        MappedFieldType textField = mockTextField("content");
     *     the reorder actually moved docs and is not just an effect of natural ordering.
                Codec.getDefault(),
     * no longer stamps it (the codec does), so assert it survives a reorder flush.
                for (int docId = 0; docId < numDocs; docId++) {
     * When the child IndexWriter is configured with an IndexSort (Lucene as primary),
            assertThat(
     * with the writer generation on its {@code .si}. Both {@code LuceneReaderManager} and the refresh
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
            )
                input.addField(textField, "doc_" + i);
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory()))) {
     *                                (RAM-buffer flushing is disabled in that case)
        MappedFieldType textField = mockTextField("content");
import org.opensearch.index.engine.dataformat.FlushInput;
 * compatible open source license.
import org.opensearch.index.engine.exec.WriterFileSet;
                // proving doc at position docId is the doc originally inserted with row ID docId.
            FileInfos fileInfos = writer.flush(sortedFlushInput);
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
 * this file be licensed under the Apache-2.0 license or a
        }
            assertTrue(fileInfos.getWriterFileSet(dataFormat).isPresent());
        long gen = 42L;
            }
     * Sorted flush across multiple in-flight Lucene segments.
     * has docs reordered so that ___row_id at doc position 0 is 4 (the doc
                "exception message should include the writer generation",
     */
                LuceneDocumentInput input = new LuceneDocumentInput();
                wfs.files().stream().anyMatch(f -> f.endsWith(".liv"))
            assertThat(wfs.numRows(), equalTo((long) numDocs));
                writer.addDoc(input);
            for (int i = 0; i < numDocs; i++) {
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
                new LuceneShardStatsTracker()
                    // marker is (N-1-docId)*100.
                null,
        try (
     * Lucene spill a new segment every 20 docs deterministically.
    }
            oldRowIds[i] = i;
import org.apache.lucene.index.IndexReader;
                LeafReader leaf = reader.leaves().get(0).reader();
        int[] deletedPositions = { 5, 25, 45 };
                    assertTrue(rowIdDV.advanceExact(docId));
                assertThat(reader.leaves().size(), equalTo(1));
 * from the primary data format (Parquet).
     *   - the {@code marker} side-channel must follow the reverse permutation, proving
            }
            for (int i = 0; i < 3; i++) {
        }
        for (int i = 0; i < numDocs; i++) {
                LeafReader leaf = reader.leaves().get(0).reader();
        try (
     */
        }
        // Reverse permutation: doc inserted at position i ends up at position (N-1-i)
            );
                new LuceneShardStatsTracker()
        // Permutation: insertion row id 1 (v_old) maps to post-reorder position 0.
     */
                Codec.getDefault(),
            assertTrue(
     * exercise the multi-segment merge path — where the configured
            assertThat(wfs.writerGeneration(), equalTo(gen));
    }
        MappedFieldType textField = mockTextField("content");
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
                0L,
                        markerDV.nextValue(),
     */
        ) {
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
                    assertThat(rowIdDV.nextValue(), equalTo((long) docId));
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
                return override;
                dataFormat,
                for (int docId = 0; docId < numDocs; docId++) {
            oldRowIds[i] = i;
        ) {
                0L,
                dataFormat,
                baseDir,
    }
                Codec.getDefault(),
        long[] newRowIds = new long[numDocs];
            assertThat(wfs.numRows(), equalTo((long) numDocs));
            }
                null,
            for (int position : deletedPositions) {
            return new LuceneWriter(
            oldToNew[(int) oldRowIds[i]] = newRowIds[i];
                    assertFalse("generation-wide position " + position + " must be deleted", liveDocs.get(position));
    public void testSortedFlushReordersOtherFieldsAndRewritesRowIds() throws IOException {
                assertTrue(markerDV.advanceExact(0));
                0L,
    private void runSortedFlushAndAssert(Integer maxBufferedDocsOverride) throws IOException {
                null,
                assertNotNull(rowIdDV);
     */
    public void testFlushStampsWriterGenerationOnSegmentInfo() throws IOException {
                    assertThat(rowIdDV.nextValue(), equalTo((long) docId));
                LuceneDocumentInput input = new LuceneDocumentInput();
 */
            oldToNew[i] = i;
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
            assertThat(wfs.numRows(), equalTo((long) numDocs));
                LuceneDocumentInput input = new LuceneDocumentInput();
                new LuceneShardStatsTracker()
                Codec.getDefault(),
                writer.addDoc(input);
                writer.addDoc(input);
                // Identity permutation: doc at position i should have row_id i
                assertNotNull(markerDV);
                }
            assertThat(wfs.numRows(), equalTo((long) numDocs));
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
            newRowIds[i] = numDocs - 1 - i;
                gen,
            Codec.getDefault(),
                1L,
        }
        for (int i = 0; i < numDocs; i++) {
            baseDir,
            assertThat(wfs.numRows(), equalTo((long) numDocs));
     * Writes 5 docs with row IDs 0..4, then flushes with a reverse permutation
        // Build a reverse sort permutation: old_row_id → new_row_id
                LeafReader leaf = reader.leaves().get(0).reader();
        long[] oldRowIds = new long[numDocs];
                input.addField(textField, "doc_" + i);
                assertNotNull(liveDocs);
                assertNotNull("liveDocs must exist after a positional delete", liveDocs);
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
    /**
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
     * physically reordered to follow the docs (their values stay attached to their
        long[] newRowIds = new long[numDocs];
                // and __row_id__ values are rewritten to sequential 0..N.
                dataFormat,
        }
        }
     * (0→4, 1→3, 2→2, 3→1, 4→0). Verifies that the resulting Lucene segment
     */
     */
                // intermediate segments existed during indexing.
                new LuceneShardStatsTracker()
        try (
 * SPDX-License-Identifier: Apache-2.0
        }
                assertThat(reader.numDocs(), equalTo(numDocs - deletedPositions.length));
                indexSort,
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
        int numDocs = 5;
            writer.recordPositionalDelete(1L);
                LeafReader leaf = reader.leaves().get(0).reader();
            }
            }
            )
        int numDocs = 3;
                null,
            );
        }
public class LuceneWriterSortedFlushTests extends LucenePluginBaseTests {
            FileInfos fileInfos = writer.flush(sortedFlushInput);
        long[] newRowIds = { 1, 0 };
     */
            FileInfos fileInfos = writer.flush(sortedFlushInput);
                    assertThat(
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
    /**
                0L,
                    assertTrue(rowIdDV.advanceExact(docId));
                1L,
        ) {
            }
     * positional delete of insertion row id 1, flushed with permutation (0→2, 1→0, 2→1). The row is
     * so that LuceneIndexingExecutionEngine.refresh() can correlate it.
                assertThat("deleted position 0 must be the former row-id-1 doc (marker 100)", markerDV.nextValue(), equalTo(100L));
     * that was originally at row 4 is now first).
                LeafReader leaf = reader.leaves().get(0).reader();
     * twice (once natively by Lucene's IndexSort, once via the row ID permutation).
                LuceneDocumentInput input = new LuceneDocumentInput();
import org.apache.lucene.index.LeafReader;
                1L,
            // Same-generation update: the prior version was inserted at row id 1. Defer its
        return new PackedRowIdMapping(oldToNew, true);
        }
     * <p>By default {@link LuceneWriter} disables doc-count flushing and uses a 256 MB
        for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.store.NIOFSDirectory;
                dataFormat,
                baseDir,
        Path baseDir = createTempDir();
                input.addField(textField, "doc_" + i);
                null,
        long[] oldToNew = new long[numDocs];
                writer.addDoc(input);
                input.addField(textField, "doc_" + i);
    public void testUnsortedFlushMergesMultipleSegmentsBeforePositionalDeletes() throws IOException {
                        sci.info.getAttribute(LuceneWriter.WRITER_GENERATION_ATTRIBUTE),
import org.apache.lucene.document.SortedNumericDocValuesField;
    }
        }
     *   - user-field correctness (no value loss or reassignment)
        FlushInput sortedFlushInput = new FlushInput(buildMapping(oldRowIds, newRowIds));
                // User field: doc i carries score i*100
            }
import org.apache.lucene.index.SegmentInfos;
                LuceneDocumentInput input = new LuceneDocumentInput();
        Sort indexSort = new Sort(new SortedNumericSortField("age", SortField.Type.LONG));
                assertThat(reader.numDocs(), equalTo(numDocs - 1));
                assertThat(leaf.maxDoc(), equalTo(numDocs));
                0L,
        int numDocs = 20;
                SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
            }
        long[] newRowIds = { 2, 0, 1 };
    public void testEmptyFlushInputUsesUnsortedPath() throws IOException {
                writer.addDoc(input);
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                        "marker at position " + docId + " must equal " + (docId * 100L) + " (no reordering)",
        try (
            }
                    assertTrue(markerDV.advanceExact(docId));
                input.addField(textField, "doc_" + i);
            );
                    assertThat(rowIdDV.nextValue(), equalTo((long) docId));
                    // position docId came from original position (N-1-docId), so its
                // So doc at position docId should have row_id = docId.
        ) {
        MappedFieldType textField = mockTextField("content");
                0L,
                // __row_id__ still sequential 0..N-1 (deleted docs keep their doc values).
                    long expectedScore = (numDocs - 1 - docId) * 100L;
                new LuceneShardStatsTracker()
     */
                baseDir,
     * the segment should preserve the original order.
    public void setUp() throws Exception {
        try (
                }
        super.setUp();
            ConcurrentHashMap.newKeySet(),
     * Two-phase sorted flush with a positional delete (same-generation create→update): 3 docs, a
                0L,
     * rewritten to sequential 0..N-1 in the new doc order. This guarantees:
        long[] ages = { 10, 20, 30, 40, 50 };
                ex.getMessage(),
import org.apache.lucene.index.DirectoryReader;
                }
            LuceneWriter writer = new LuceneWriter(
                        equalTo(String.valueOf(gen))
                baseDir,
        long[] newRowIds = new long[numDocs];
                return 1024.0;
                }
        long[] oldRowIds = new long[numDocs];
    /**
                    );
                    long rowIdValue = rowIdDV.nextValue();
     * {@code ReorderingMergePolicy} drives a reorder that spans more than one source
        Path baseDir = createTempDir();
     * drop-generation reconciliation hard-require this attribute on every live leaf; the reorder merge
                    assertTrue(rowIdDV.advanceExact(docId));
                assertThat(reader.leaves().size(), equalTo(1));
                gen,
     * After a sorted flush with reorder + row ID rewrite, non-row-id fields must be
                ConcurrentHashMap.newKeySet(),
        Path baseDir = createTempDir();
            protected double ramBufferSizeMB() {
                for (int position : deletedPositions) {
 * Verifies that documents are reordered according to the sort permutation
        if (maxBufferedDocsOverride == null) {
                new LuceneShardStatsTracker()
        Path baseDir = createTempDir();
                assertNotNull(markerDV);
