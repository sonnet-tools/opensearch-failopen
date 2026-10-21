                ConcurrentHashMap.newKeySet(),
            input.addField(fieldOwnedByOther, 42);
                Codec.getDefault(),
                null,
                dataFormat,
        Path baseDir = createTempDir();
            fileInfos2 = writer2.flush(FlushInput.EMPTY);
                    sort,
        super.setUp();
        MappedFieldType textField = mockTextField("content");
                0L,
                null,
                dataFormat,
                1L,
            LuceneDocumentInput input = new LuceneDocumentInput();
        try (
            baseDir,
    /**
                null,
        Path baseDir = createTempDir();
            // Each is independently readable with correct content
            for (int i = 0; i < 5; i++) {
            )
            )
            assertThat(wfs.numRows(), equalTo((long) numDocs));
        LuceneWriter writer = new LuceneWriter(
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
                new LuceneShardStatsTracker()
                baseDir,
                // Verify keyword field is searchable
    }
                LuceneDocumentInput input = new LuceneDocumentInput();
            LuceneDocumentInput input = new LuceneDocumentInput();
    }
                java.util.Set.of(org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)
            )
            input.addField(textField, "hello world");
        writer.recordPositionalDelete(0L);
import static org.mockito.Mockito.when;
                input.addField(keywordField, "active");
        writer.addDoc(input);
            MappedFieldType textField = mockTextField("content");
                writer.addDoc(input);
        try (
            Optional<Writer<?>> nullResult = writer.getWriterForFormat(null);
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
                }
                new LuceneShardStatsTracker()
            ConcurrentHashMap.newKeySet(),
        try {
                    1L,
            try (
                assertThat(reader.numDocs(), equalTo(numDocs));
    }
import org.opensearch.index.engine.dataformat.Writer;
                baseDir,
            writer.recordPositionalDelete(1L);
    }
            }
                    0L,
     */
                input.addField(keywordField, "cat_" + (i % 3));
                ConcurrentHashMap.newKeySet(),
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
                        assertTrue(rowIdValues.advanceExact(docId));
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
                input.addField(textField, "doc " + i);
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
import org.apache.lucene.index.IndexReader;
        Path baseDir = createTempDir();
import org.apache.lucene.index.LeafReader;
            for (int i = 0; i < numDocs; i++) {
     */
            assertTrue(fileInfos.writerFilesMap().isEmpty());
        );
    public void testMultipleWriterGenerationsProduceIsolatedSegments() throws IOException {
                new LuceneShardStatsTracker()
     * so it must not stay buffered and must not be counted toward heap usage.
                assertThat(reader2.leaves().size(), equalTo(1));
            // Verify the segment is readable and has exactly numDocs documents
            LuceneWriter writer = new LuceneWriter(
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            LuceneWriter writer = new LuceneWriter(
            0L,
            LuceneWriter writer = new LuceneWriter(
     * and maxDoc equals the live row count.
        assertEquals("close must release buffered positional deletes", 0L, writer.getHeapBytesUsed());
                assertTrue(searcher.count(new TermQuery(new Term("body", "hello"))) > 0);
                Codec.getDefault(),
                assertThat(reader1.leaves().size(), equalTo(1));
        try (
                null,
                ConcurrentHashMap.newKeySet(),
                LeafReader leafReader = reader.leaves().get(0).reader();
            // Different directories
            rollback.addField(textField, "to-rollback");
    public void testMixedTextAndKeywordFields() throws IOException {
        try (
                baseDir,
                // Verify text field is searchable via TermQuery
                assertThat("rollback must retire the writer (sort=" + sort + ")", writer.state().toString(), equalTo("RETIRED_FLUSHABLE"));
        // Create both writers without closing them until after verification,
public class LuceneWriterTests extends LucenePluginBaseTests {
     * calls are rejected. Holds for both no-sort and indexSort branches.
            )
            for (int i = 0; i < 3; i++) {
                assertNotNull(rowIdValues);
            LuceneWriter writer = new LuceneWriter(
            writer.addDoc(input);
            )
            dataFormat,
                writer.addDoc(input);
 * segments in isolated temp directories with force-merge to 1 segment on flush.
                Codec.getDefault(),
                1L,
        Path baseDir = createTempDir();
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            )
        Path baseDir = createTempDir();
    public void testRowIdMatchesLuceneDocId() throws IOException {
            dataFormat,
        input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
                Codec.getDefault(),
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
        writer.close();
            assertThat(wfs.writerGeneration(), equalTo(1L));
                baseDir,
import org.apache.lucene.search.Sort;
            for (int i = 0; i < numDocs; i++) {
import org.opensearch.index.engine.dataformat.WriteResult;
        LuceneWriter writer1 = new LuceneWriter(
    }
                1L,
                LuceneDocumentInput input = new LuceneDocumentInput();
            // add document so that it consumes heap memory
            int numDocs = randomIntBetween(5, 20);
        );
                input.addField(textField, "v");
                assertThat(reader.leaves().size(), equalTo(1));
import org.apache.lucene.search.SortField;
import org.apache.lucene.index.Term;
                baseDir,
import org.apache.lucene.search.MatchAllDocsQuery;
                baseDir,
        long gen2 = 2L;
        }
            writer.addDoc(input);
        when(numericField.typeName()).thenReturn("integer");
    public void testGetHeapBytesUsedPositiveAfterIndexing() throws IOException {
            }
            }
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
                writer.rollbackTo(0);
        MappedFieldType textField = mockTextField("content");
        }
        writer.addDoc(input);
    }
            LuceneWriter writer = new LuceneWriter(
        Path baseDir = createTempDir();
                null,
                input.addField(textField, "value " + i);
        Writer<?> writer = mock(Writer.class, org.mockito.Mockito.CALLS_REAL_METHODS);
import static org.mockito.Mockito.mock;
            null,
        assertEquals("late positional delete after close must not be held", 0L, writer.getHeapBytesUsed());
    }
            // Correct doc counts
            try (NIOFSDirectory dir2 = new NIOFSDirectory(Path.of(wfs2.directory())); IndexReader reader2 = DirectoryReader.open(dir2)) {
                null,
            WriterFileSet wfs1 = fileInfos1.getWriterFileSet(dataFormat).get();
                baseDir,
        Path baseDir = createTempDir();
                0L,
        Path baseDir = createTempDir();
import java.io.IOException;
        LuceneWriter writer = new LuceneWriter(
                    LeafReader leafReader = ctx.reader();
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
    public void testWriterGenerationIsPreserved() throws IOException {
                Codec.getDefault(),
    }
                null,
 */
            for (int i = 0; i < numDocs; i++) {
        Optional<Writer<?>> result = writer.getWriterForFormat("any");
                    SortedNumericDocValues rowIdValues = leafReader.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
                LuceneWriter writer = new LuceneWriter(
        when(numericField.name()).thenReturn("count");
                input.addField(textField, "doc " + i);
            LuceneDocumentInput rollback = new LuceneDocumentInput();
            writer.rollbackTo(5);
    public void testAddDocAndFlushProducesSingleSegment() throws IOException {
        }
        WriterFileSet fileSet = fileInfos.writerFilesMap().get(dataFormat);
                writer.addDoc(input);
        LuceneDocumentInput input = new LuceneDocumentInput();
        // try-with-resources calls close(); getHeapBytesUsed verified as 0 after flush (which closes IndexWriter)
        LuceneWriter writer2 = new LuceneWriter(
import static org.hamcrest.Matchers.equalTo;
    @Override
                Codec.getDefault(),
                null,
                assertThat(reader.leaves().size(), equalTo(1));
            LuceneDocumentInput input = new LuceneDocumentInput();
            input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
import org.opensearch.index.engine.exec.WriterFileSet;
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
    public void testWriterDefaultGetWriterForFormatReturnsEmpty() {
    /**
            LuceneWriter writer = new LuceneWriter(
                    }
                baseDir,
                assertThat(reader.leaves().size(), equalTo(1));
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
                null,
            writer2.close();
        ) {
            )
        long gen = randomLongBetween(1, 100);
            assertFalse("Should return empty for null format", nullResult.isPresent());
        ) {
                null,
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
    public void testGetWriterForFormatReturnsItselfForLucene() throws IOException {
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
            // Should not throw — unsupported types are silently skipped (handled by other formats)
            assertNotEquals("Writers should have different directories", wfs1.directory(), wfs2.directory());
import java.util.Optional;
import org.apache.lucene.index.SortedNumericDocValues;
            java.util.Map.of(
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
        writer.recordPositionalDelete(0L);
                IndexSearcher searcher = new IndexSearcher(reader);
            ConcurrentHashMap.newKeySet(),
        Path baseDir = createTempDir();
        MappedFieldType keywordField = mockKeywordField("status");
            }
}
                input.addField(textField, "gen2 doc " + i);
                null,
/*
            )
            input.addField(keywordField, "active");
            }
                null,
        Path baseDir = createTempDir();
                    new LuceneShardStatsTracker()
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
        assertEquals("getHeapBytesUsed should be 0 after close", 0L, writer.getHeapBytesUsed());
    public void testPositionalDeleteRecordedAfterCloseIsDiscarded() throws IOException {
                dataFormat,
            }
                    "forceMerge under real merge policy must expunge tombstone",
            // Late delete: arrives after applyPositionalDeletes has drained the queue.
                0L,
            assertNotNull(reader.leaves().get(0).reader().getLiveDocs());
            assertTrue("getHeapBytesUsed should be > 0 after indexing", writer.getHeapBytesUsed() > 0);
            writer.flush(FlushInput.EMPTY);
        ) {
                null,
            LuceneDocumentInput input = new LuceneDocumentInput();
            0L,
import org.apache.lucene.index.DirectoryReader;
            LuceneWriter writer = new LuceneWriter(
                null,
                0L,
                LuceneDocumentInput input = new LuceneDocumentInput();
    }
                MappedFieldType textField = mockTextField("content");
import org.apache.lucene.codecs.Codec;
import org.apache.lucene.index.LeafReaderContext;
        MappedFieldType textField = mockTextField("content");
            }
            new LuceneShardStatsTracker()
                1L,
                    assertThat(rowIdValues.nextValue(), equalTo((long) docId));
                baseDir,
/**
        FileInfos fileInfos;
                assertThat(reader2.numDocs(), equalTo(numDocs2));
            ConcurrentHashMap.newKeySet(),
        ) {
    }
 * this file be licensed under the Apache-2.0 license or a
        MappedFieldType textField = mockTextField("content");
 * SPDX-License-Identifier: Apache-2.0
            )
                new LuceneShardStatsTracker()
                null,
            LuceneWriter writer = new LuceneWriter(
        int numDocs = randomIntBetween(10, 50);
            )
            ) {
        }
                new LuceneShardStatsTracker()
        }
        Path baseDir = createTempDir();
                assertTrue(result instanceof WriteResult.Success);
                Codec.getDefault(),
                1L,
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
                    assertTrue(rowIdValues.advanceExact(docId));
                LuceneDocumentInput input = new LuceneDocumentInput();
import java.nio.file.Path;
                dataFormat,
                assertThat(reader1.numDocs(), equalTo(numDocs1));
        LuceneDocumentInput input = new LuceneDocumentInput();
                    reader.leaves().get(0).reader().maxDoc(),
import org.apache.lucene.search.TermQuery;
                new LuceneShardStatsTracker()
        }
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
 */
                LuceneDocumentInput nextDoc = new LuceneDocumentInput();
        writer.close();
        try (
                    null,
                ConcurrentHashMap.newKeySet(),
            LuceneWriter writer = new LuceneWriter(
                new LuceneShardStatsTracker()
            baseDir,
            assertEquals("late positional deletes must not be held on a flushed writer", 0L, writer.getHeapBytesUsed());
                new LuceneShardStatsTracker()
                );
        Path baseDir = createTempDir();
            gen1,
            rollback.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 5);
    /** A writer closed without flushing (rollback path) must also release late row ids. */
                new LuceneShardStatsTracker()
                LuceneDocumentInput input = new LuceneDocumentInput();
                0L,
        input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
    public void testFieldOwnedByAnotherFormatIsSilentlySkipped() throws IOException {
        ) {
 * Tests for {@link LuceneWriter} — the per-generation Lucene writer that creates
        }
    }
                assertTrue(searcher.count(new TermQuery(new Term("status", "active"))) > 0);
    public void testRollbackInIndexSortBranchExpungesTombstone() throws IOException {
        ) {
                dataFormat,
        try (
        assertTrue("getHeapBytesUsed should be > 0 before close", writer.getHeapBytesUsed() > 0);
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
                input.addField(textField, "hello world " + i);
            assertEquals("no heap after flush", 0L, writer.getHeapBytesUsed());
            new LuceneShardStatsTracker()
        int numDocs = randomIntBetween(5, 20);
            assertThat(wfs.numRows(), equalTo((long) numDocs));
    public void testRollbackRetiresWriterInBothBranches() throws IOException {
        FileInfos fileInfos1;
                0L,
            }
            )
 * The OpenSearch Contributors require contributions made to
                new LuceneShardStatsTracker()
            assertTrue("Should return present for 'lucene'", result.isPresent());
        // Empty capability map → no format owns this field; should be silently skipped
            try (NIOFSDirectory dir1 = new NIOFSDirectory(Path.of(wfs1.directory())); IndexReader reader1 = DirectoryReader.open(dir1)) {
            assertThat(wfs1.writerGeneration(), equalTo(gen1));
        ) {
 * compatible open source license.
                0L,
        assertTrue("pending positional delete must be counted before close", writer.getHeapBytesUsed() > 0);
                Codec.getDefault(),
    public void testGetWriterForFormatReturnsEmptyForOtherFormats() throws IOException {
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
    public void testPositionalDeleteRecordedAfterFlushIsDiscarded() throws IOException {
            assertSame("Should return itself", writer, result.get());
    public void testWriteAndFlushEndToEndWithTextAndKeyword() throws IOException {
            assertFalse(wfs.files().isEmpty());
                dataFormat,
    }
            Codec.getDefault(),
        ) {
                LuceneDocumentInput input = new LuceneDocumentInput();
                // Verify correct doc count
                0L,
                ConcurrentHashMap.newKeySet(),
        }
            null,
                ConcurrentHashMap.newKeySet(),
            }
                ConcurrentHashMap.newKeySet(),
        input.addField(textField, "hello world");
        Path baseDir = createTempDir();
            assertFalse("doc 1 must be dead", reader.leaves().get(0).reader().getLiveDocs().get(1));
    public void testKeywordFieldsAreIndexed() throws IOException {
import org.opensearch.be.lucene.LuceneDataFormat;
        }
            }
            gen2,
                dataFormat,
                new LuceneShardStatsTracker()
    }
            assertThat(wfs2.numRows(), equalTo((long) numDocs2));
        for (Sort sort : new Sort[] { null, indexSort }) {
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            LuceneWriter writer = new LuceneWriter(
                0L,
            int numDocs = randomIntBetween(5, 15);
        ) {
    public void testFlushWithNoDocsReturnsEmpty() throws IOException {
            writer.addDoc(rollback);
        );
        }
                null,
            assertThat("WriterFileSet must report live row count only", wfs.numRows(), equalTo(5L));
                dataFormat,
        }
                0L,
            for (int i = 0; i < numDocs2; i++) {
            assertFalse("Should return empty for non-lucene format", parquetResult.isPresent());
        ) {
            LuceneWriter writer = new LuceneWriter(
        }
            }
        try (
                dataFormat,
            }
     * Rollback path with the indexSort branch (LogByteSizeMergePolicy + IndexSort). Here
            writer1.close();
                LuceneDocumentInput input = new LuceneDocumentInput();
        }
        try (
                1L,
        MappedFieldType fieldOwnedByOther = mock(MappedFieldType.class);
        dataFormat = new LuceneDataFormat();
            )
            MappedFieldType textField = mockTextField("content");
            fileInfos = writer.flush(FlushInput.EMPTY);
            0L,
                nextDoc.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
                assertThat(
                dataFormat,
    }
        ) {
            Codec.getDefault(),
                null,
            )
            )
        Sort indexSort = new Sort(new SortedNumericSortField(LuceneDocumentInput.ROW_ID_FIELD, SortField.Type.LONG));
            // Verify each produces its own independent segment
        }
        }
                nextDoc.addField(textField, "should-fail");
                    for (int docId = 0; docId < leafReader.maxDoc(); docId++) {
                LuceneDocumentInput input = new LuceneDocumentInput();
            // The document should have no fields for the unsupported type
                assertThat(searcher.count(new MatchAllDocsQuery()), equalTo(1));
                null,
                ConcurrentHashMap.newKeySet(),
                    Codec.getDefault(),
            )
            )
                new LuceneShardStatsTracker()
                1L,
                dataFormat,
                for (int docId = 0; docId < numDocs; docId++) {
                input.addField(textField, "doc " + i);
    }
            null,
        // because close() deletes the temp directory.
        MappedFieldType textField = mockTextField("content");
            input.addField(textField, "test value");
        int numDocs2 = randomIntBetween(3, 10);
            assertTrue(fileInfos.getWriterFileSet(dataFormat).isPresent());
                null,
            for (int i = 0; i < numDocs1; i++) {
import org.opensearch.index.mapper.MappedFieldType;
                baseDir,
                Codec.getDefault(),
        try (
                null,
                // Verify exactly 1 segment
import org.opensearch.index.engine.dataformat.DataFormat;
 *
                assertThat(reader.numDocs(), equalTo(5));
            baseDir,
                writer.addDoc(input);
        } finally {
                1L,
                assertThat(reader.numDocs(), equalTo(numDocs));
            null,
    }
        MappedFieldType textField = mockTextField("title");
                    ConcurrentHashMap.newKeySet(),
            writer.recordPositionalDelete(1L);
        MappedFieldType keywordField = mockKeywordField("status");
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
package org.opensearch.be.lucene.index;
                ConcurrentHashMap.newKeySet(),
                baseDir,
            dataFormat,
                input.addField(textField, "gen1 doc " + i);
                    dataFormat,
        MappedFieldType textField = mockTextField("body");
                input.addField(textField, "document title " + i);
     * A delete can resolve a previous copy to a generation whose writer has already flushed but is
                assertThat(reader.numDocs(), equalTo(numDocs));
            1L,
            writer.addDoc(input);
        }
            null,
            }
                otherFormat,
            for (int i = 0; i < numDocs; i++) {
        Sort indexSort = new Sort(new SortedNumericSortField(LuceneDocumentInput.ROW_ID_FIELD, SortField.Type.LONG));
            new LuceneShardStatsTracker()
            }
                    createTempDir(),
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                dataFormat,
            1L,
        assertFalse(result.isPresent());
        when(fieldOwnedByOther.getCapabilityMap()).thenReturn(
                input.addField(textField, "value " + i);
                new LuceneShardStatsTracker()
            writer.recordPositionalDelete(2L);
            new LuceneShardStatsTracker()
                1L,
            dataFormat,
            }
                gen,
        ) {
                null,
                0L,
            assertThat(writer.generation(), equalTo(gen));
            assertThat(wfs2.writerGeneration(), equalTo(gen2));
import org.opensearch.index.engine.dataformat.FlushInput;
                        assertThat("row ID should equal Lucene doc ID", rowIdValues.nextValue(), equalTo((long) docId));
        }
                ConcurrentHashMap.newKeySet(),
                ConcurrentHashMap.newKeySet(),
                dataFormat,
                ConcurrentHashMap.newKeySet(),
    }
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
            Codec.getDefault(),
        Path baseDir = createTempDir();
        try (
            WriterFileSet wfs2 = fileInfos2.getWriterFileSet(dataFormat).get();
                1L,
            baseDir,
                Codec.getDefault(),
                baseDir,
                writer2.addDoc(input);
        try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(fileSet.directory())); IndexReader reader = DirectoryReader.open(dir)) {
            assertFalse("flush must produce files", fileInfos.writerFilesMap().isEmpty());
import org.apache.lucene.search.SortedNumericSortField;
                Codec.getDefault(),
     */
                baseDir,
        ) {
        MappedFieldType textField = mockTextField("content");
                writer.addDoc(input);
            LuceneWriter writer = new LuceneWriter(
                null,
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
        );
                for (LeafReaderContext ctx : reader.leaves()) {
                ConcurrentHashMap.newKeySet(),
            }
        when(fieldOwnedByOther.typeName()).thenReturn("integer");
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
            LuceneDocumentInput input = new LuceneDocumentInput();
                null,
    /**
            null,
                LuceneDocumentInput input = new LuceneDocumentInput();
        Path baseDir = createTempDir();
            fileInfos1 = writer1.flush(FlushInput.EMPTY);
            assertThat(wfs.writerGeneration(), equalTo(gen));
     * After rollbackLastDoc the writer must transition to RETIRED_FLUSHABLE — further addDoc
    }
        ) {
                }
            input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
                baseDir,
            input.addField(numericField, 42);
                null,
    public void setUp() throws Exception {
        when(fieldOwnedByOther.name()).thenReturn("count");
    /** Sealing must not affect row ids recorded before flush: they are still applied. */
            assertEquals("getHeapBytesUsed should be 0 after flush", 0L, writer.getHeapBytesUsed());
                writer1.addDoc(input);
            LuceneWriter writer = new LuceneWriter(
        MappedFieldType textField = mockTextField("content");
                null,
                1L,
        Path baseDir = createTempDir();
            ConcurrentHashMap.newKeySet(),
                    assertNotNull("row_id doc values should exist", rowIdValues);
                ConcurrentHashMap.newKeySet(),
                0L,
                ConcurrentHashMap.newKeySet(),
                indexSort,
        Path baseDir = createTempDir();
                null,
        try (
            assertEquals(3, reader.maxDoc());
                Codec.getDefault(),
                1L,
    public void testUnsupportedFieldTypeIsSilentlySkipped() throws IOException {
                null,
                writer.addDoc(input);
                1L,
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
        DataFormat otherFormat = mock(DataFormat.class);
                Codec.getDefault(),
            Optional<Writer<?>> result = writer.getWriterForFormat("lucene");
            }
        try (
            assertEquals("applied positional delete must not be counted after flush", 0L, writer.getHeapBytesUsed());
import org.apache.lucene.search.IndexSearcher;
                0L,
                    equalTo(5)
    private LuceneDataFormat dataFormat;
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
                WriteResult result = writer.addDoc(input);
        );
     * forceMerge actually rewrites the segment, so the tombstone is physically expunged
                Codec.getDefault(),
        try (
            0L,
                1L,
                new LuceneShardStatsTracker()
            input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
        Path baseDir = createTempDir();
    public void testGetHeapBytesUsedZeroAfterCloseWithoutFlush() throws IOException {
                baseDir,
        try (
                expectThrows(IllegalStateException.class, () -> writer.addDoc(nextDoc));
    }
            }
     * still registered with the delete engine. The row id can no longer be applied by that writer,
    }
            LuceneWriter writer = new LuceneWriter(
            LuceneWriter writer = new LuceneWriter(
            Optional<Writer<?>> parquetResult = writer.getWriterForFormat("parquet");
        MappedFieldType textField = mockTextField("content");
            assertEquals(0, input.getFinalInput().getFields().size());
                LuceneDocumentInput input = new LuceneDocumentInput();
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
            for (int i = 0; i < 3; i++) {
                0L,
        input.addField(textField, "hello world");
                new LuceneShardStatsTracker()
            assertEquals("row 1 must be marked deleted", 2, reader.numDocs());
                // Verify row IDs match doc IDs
                IndexSearcher searcher = new IndexSearcher(reader);
        Path baseDir = createTempDir();
            // Correct generations
            Codec.getDefault(),
        when(numericField.getCapabilityMap()).thenReturn(java.util.Map.of());
        MappedFieldType numericField = mock(MappedFieldType.class);
        FileInfos fileInfos2;
        ) {
    }
            null,
import org.opensearch.index.engine.dataformat.FileInfos;
        long gen1 = 1L;
        }
        // A pending row id that the writer never gets to apply.
                0L,
        when(otherFormat.name()).thenReturn("parquet");
import java.util.concurrent.ConcurrentHashMap;
                null,
                dataFormat,
import org.apache.lucene.store.NIOFSDirectory;
        try (
            null,
                null,
                dataFormat,
                Codec.getDefault(),
                SortedNumericDocValues rowIdValues = leafReader.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
        MappedFieldType keywordField = mockKeywordField("category");
                )
            assertThat(wfs1.numRows(), equalTo((long) numDocs1));
            assertEquals(0, input.getFinalInput().getFields().size());
    public void testPositionalDeleteRecordedBeforeFlushIsApplied() throws IOException {
                writer.addDoc(input);
        int numDocs1 = randomIntBetween(3, 10);
