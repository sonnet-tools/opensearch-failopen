                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            Optional<Writer<?>> nullResult = writer.getWriterForFormat(null);  
                input.addField(textField, "gen2 doc " + i);  
import org.apache.lucene.index.IndexReader;  
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                input.addField(textField, "v");
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);  
                    createTempDir(),  
                dataFormat,
        ) {  
                Codec.getDefault(),  
                new LuceneShardStatsTracker()
        FileInfos fileInfos;
                    equalTo(5)
        MappedFieldType textField = mockTextField("title");  
    }
        Path baseDir = createTempDir();
                assertThat(reader2.leaves().size(), equalTo(1));
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
            null,
        }
                dataFormat,
                baseDir,
                );
 *
            )
    public void testGetWriterForFormatReturnsEmptyForOtherFormats() throws IOException {
    public void testWriterDefaultGetWriterForFormatReturnsEmpty() {
            null,
public class LuceneWriterTests extends LucenePluginBaseTests {
            dataFormat,
            for (int i = 0; i < numDocs; i++) {
                1L,
            }
        }
                null,
}
 */  
        Optional<Writer<?>> result = writer.getWriterForFormat("any");  
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                null,  
            java.util.Map.of(  
    }  
        WriterFileSet fileSet = fileInfos.writerFilesMap().get(dataFormat);  
            LuceneDocumentInput input = new LuceneDocumentInput();
     * so it must not stay buffered and must not be counted toward heap usage.
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            LuceneWriter writer = new LuceneWriter(
        try (
                ConcurrentHashMap.newKeySet(),  
                LuceneDocumentInput input = new LuceneDocumentInput();  
                new LuceneShardStatsTracker()
            dataFormat,
                input.addField(textField, "doc " + i);  
            writer.rollbackTo(5);  
     * calls are rejected. Holds for both no-sort and indexSort branches.
            }
            }  
        input.addField(textField, "hello world");
    public void testPositionalDeleteRecordedAfterFlushIsDiscarded() throws IOException {  
                1L,
            ) {
            assertFalse("flush must produce files", fileInfos.writerFilesMap().isEmpty());
            Codec.getDefault(),  
            Codec.getDefault(),
        long gen2 = 2L;  
                1L,
        }
            input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
        assertTrue("getHeapBytesUsed should be > 0 before close", writer.getHeapBytesUsed() > 0);
                    assertThat(rowIdValues.nextValue(), equalTo((long) docId));  
                0L,  
                writer.rollbackTo(0);
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {  
        MappedFieldType keywordField = mockKeywordField("category");
        }
        ) {  
     * and maxDoc equals the live row count.
                baseDir,
            }  
        LuceneWriter writer2 = new LuceneWriter(
    }
                    assertTrue(rowIdValues.advanceExact(docId));
                IndexSearcher searcher = new IndexSearcher(reader);
        }
        Path baseDir = createTempDir();
        int numDocs = randomIntBetween(5, 20);
        assertTrue("pending positional delete must be counted before close", writer.getHeapBytesUsed() > 0);
                null,
            }  
        }
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                ConcurrentHashMap.newKeySet(),  
        MappedFieldType textField = mockTextField("content");  
            assertThat(wfs.writerGeneration(), equalTo(gen));
        FileInfos fileInfos2;
        // try-with-resources calls close(); getHeapBytesUsed verified as 0 after flush (which closes IndexWriter)
            0L,
            )  
                assertTrue(searcher.count(new TermQuery(new Term("body", "hello"))) > 0);
                input.addField(textField, "doc " + i);  
                1L,  
                assertThat(reader.numDocs(), equalTo(numDocs));  
            assertFalse("Should return empty for non-lucene format", parquetResult.isPresent());
        FileInfos fileInfos1;
    }
        Writer<?> writer = mock(Writer.class, org.mockito.Mockito.CALLS_REAL_METHODS);
            )
    }  
            try (
                0L,
            LuceneDocumentInput input = new LuceneDocumentInput();
    public void testWriterGenerationIsPreserved() throws IOException {  
            assertEquals(3, reader.maxDoc());
                0L,  
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
            writer.recordPositionalDelete(1L);  
import static org.mockito.Mockito.when;
                null,  
        LuceneWriter writer1 = new LuceneWriter(  
                input.addField(textField, "doc " + i);  
                LuceneDocumentInput input = new LuceneDocumentInput();  
    }
            null,  
        }
            Optional<Writer<?>> parquetResult = writer.getWriterForFormat("parquet");
                new LuceneShardStatsTracker()
        MappedFieldType fieldOwnedByOther = mock(MappedFieldType.class);
        input.addField(textField, "hello world");
 * this file be licensed under the Apache-2.0 license or a
                0L,  
    public void testRollbackInIndexSortBranchExpungesTombstone() throws IOException {  
        writer.addDoc(input);
                1L,
        Path baseDir = createTempDir();
                input.addField(keywordField, "cat_" + (i % 3));
                Codec.getDefault(),
    public void testFlushWithNoDocsReturnsEmpty() throws IOException {
                ConcurrentHashMap.newKeySet(),  
                ConcurrentHashMap.newKeySet(),  
     */
                null,
                assertThat(reader.numDocs(), equalTo(5));  
                java.util.Set.of(org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
                null,  
/*  
        MappedFieldType textField = mockTextField("content");  
            ConcurrentHashMap.newKeySet(),
                assertThat(reader1.leaves().size(), equalTo(1));  
        Path baseDir = createTempDir();
        } finally {
                new LuceneShardStatsTracker()
                new LuceneShardStatsTracker()
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
        }  
            }
 */
            writer.addDoc(rollback);
                IndexSearcher searcher = new IndexSearcher(reader);
import org.apache.lucene.index.SortedNumericDocValues;  
                ConcurrentHashMap.newKeySet(),
        // Create both writers without closing them until after verification,
        try (  
                baseDir,  
                null,  
    public void setUp() throws Exception {
                LuceneDocumentInput input = new LuceneDocumentInput();
            }
                ConcurrentHashMap.newKeySet(),  
import org.apache.lucene.search.SortField;
            LuceneWriter writer = new LuceneWriter(
            for (int i = 0; i < numDocs; i++) {
        ) {  
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
            assertEquals("late positional deletes must not be held on a flushed writer", 0L, writer.getHeapBytesUsed());  
                0L,  
            new LuceneShardStatsTracker()  
        Sort indexSort = new Sort(new SortedNumericSortField(LuceneDocumentInput.ROW_ID_FIELD, SortField.Type.LONG));
                0L,  
            assertThat("WriterFileSet must report live row count only", wfs.numRows(), equalTo(5L));
                null,
 * The OpenSearch Contributors require contributions made to  
                assertThat(reader.leaves().size(), equalTo(1));
            assertEquals(0, input.getFinalInput().getFields().size());
            assertThat(wfs2.numRows(), equalTo((long) numDocs2));
                assertNotNull(rowIdValues);  
                baseDir,
            // The document should have no fields for the unsupported type
        Path baseDir = createTempDir();  
                dataFormat,  
                assertThat(reader.leaves().size(), equalTo(1));
            LuceneWriter writer = new LuceneWriter(
        Path baseDir = createTempDir();
            writer.addDoc(input);  
                null,
            for (int i = 0; i < numDocs; i++) {
                dataFormat,
    }
            baseDir,  
            writer.recordPositionalDelete(2L);
                LeafReader leafReader = reader.leaves().get(0).reader();
    /** A writer closed without flushing (rollback path) must also release late row ids. */
            // Correct generations
        MappedFieldType keywordField = mockKeywordField("status");
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
            )
        Path baseDir = createTempDir();  
                null,
            assertFalse(wfs.files().isEmpty());
                assertThat(reader2.numDocs(), equalTo(numDocs2));
                1L,
                baseDir,
import static org.mockito.Mockito.mock;
            assertFalse("Should return empty for null format", nullResult.isPresent());  
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
        try (  
            assertEquals("no heap after flush", 0L, writer.getHeapBytesUsed());  
import org.apache.lucene.index.LeafReaderContext;
            LuceneDocumentInput input = new LuceneDocumentInput();
    }
            }  
            for (int i = 0; i < numDocs1; i++) {
            Optional<Writer<?>> result = writer.getWriterForFormat("lucene");
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {  
                assertThat(reader.leaves().size(), equalTo(1));  
            ConcurrentHashMap.newKeySet(),
            // Verify the segment is readable and has exactly numDocs documents  
            null,
                Codec.getDefault(),
    /**
import org.opensearch.index.engine.dataformat.FileInfos;  
            LuceneWriter writer = new LuceneWriter(
            }
            assertFalse("doc 1 must be dead", reader.leaves().get(0).reader().getLiveDocs().get(1));
    public void testMultipleWriterGenerationsProduceIsolatedSegments() throws IOException {
            writer1.close();
        ) {
                LuceneDocumentInput input = new LuceneDocumentInput();
            ConcurrentHashMap.newKeySet(),
            assertThat(wfs.writerGeneration(), equalTo(1L));  
                otherFormat,
                Codec.getDefault(),
            LuceneDocumentInput rollback = new LuceneDocumentInput();
        LuceneWriter writer = new LuceneWriter(
    private LuceneDataFormat dataFormat;
            assertEquals("row 1 must be marked deleted", 2, reader.numDocs());  
        when(fieldOwnedByOther.typeName()).thenReturn("integer");  
    public void testWriteAndFlushEndToEndWithTextAndKeyword() throws IOException {  
        when(fieldOwnedByOther.name()).thenReturn("count");
            ConcurrentHashMap.newKeySet(),
import org.opensearch.index.engine.dataformat.Writer;  
        assertEquals("close must release buffered positional deletes", 0L, writer.getHeapBytesUsed());
                null,
            }  
                null,
        try (  
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();  
    public void testGetHeapBytesUsedZeroAfterCloseWithoutFlush() throws IOException {
                baseDir,
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {
        try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(fileSet.directory())); IndexReader reader = DirectoryReader.open(dir)) {
            LuceneWriter writer = new LuceneWriter(
            fileInfos1 = writer1.flush(FlushInput.EMPTY);
        ) {
        long gen1 = 1L;
            assertThat(wfs.numRows(), equalTo((long) numDocs));  
        try (  
            for (int i = 0; i < numDocs2; i++) {
                new LuceneShardStatsTracker()
        Path baseDir = createTempDir();  
                null,  
                baseDir,  
            Codec.getDefault(),
            input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);  
            1L,  
import java.io.IOException;
        assertEquals("late positional delete after close must not be held", 0L, writer.getHeapBytesUsed());
        MappedFieldType textField = mockTextField("content");
                Codec.getDefault(),
import org.apache.lucene.search.SortedNumericSortField;  
     * After rollbackLastDoc the writer must transition to RETIRED_FLUSHABLE — further addDoc  
import static org.hamcrest.Matchers.equalTo;  
            0L,
                null,  
        when(numericField.name()).thenReturn("count");
                writer.addDoc(input);  
        writer.close();  
                null,  
        try (  
        // Empty capability map → no format owns this field; should be silently skipped  
        );  
            WriterFileSet wfs1 = fileInfos1.getWriterFileSet(dataFormat).get();
import org.opensearch.index.mapper.MappedFieldType;
            null,
import java.util.concurrent.ConcurrentHashMap;
                0L,  
                LuceneDocumentInput input = new LuceneDocumentInput();
                    new LuceneShardStatsTracker()
        }
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);  
            fileInfos = writer.flush(FlushInput.EMPTY);
                assertThat(reader.numDocs(), equalTo(numDocs));
                nextDoc.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
        Path baseDir = createTempDir();
 * SPDX-License-Identifier: Apache-2.0
                dataFormat,
                Codec.getDefault(),
                assertThat(
        MappedFieldType textField = mockTextField("content");  
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);  
            MappedFieldType textField = mockTextField("content");
                1L,
     */
        MappedFieldType textField = mockTextField("body");
                ConcurrentHashMap.newKeySet(),  
        ) {  
import org.apache.lucene.index.LeafReader;
                Codec.getDefault(),
        Path baseDir = createTempDir();
            // Verify each produces its own independent segment  
                nextDoc.addField(textField, "should-fail");  
        }
        Path baseDir = createTempDir();
        assertEquals("getHeapBytesUsed should be 0 after close", 0L, writer.getHeapBytesUsed());
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                0L,  
            writer2.close();  
            input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);  
        try (  
                null,
            null,
                null,
        ) {  
                null,
import org.apache.lucene.search.IndexSearcher;
        }  
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
                null,  
                assertThat(reader.numDocs(), equalTo(numDocs));
        try (  
import org.apache.lucene.search.Sort;
    }
            // Late delete: arrives after applyPositionalDeletes has drained the queue.
            }  
        MappedFieldType keywordField = mockKeywordField("status");  
        MappedFieldType numericField = mock(MappedFieldType.class);  
                    0L,
        try (  
                Codec.getDefault(),
        }  
                input.addField(keywordField, "active");
                0L,
    }
            assertTrue(fileInfos.writerFilesMap().isEmpty());
        try (  
            assertEquals(0, input.getFinalInput().getFields().size());  
            for (int i = 0; i < 5; i++) {
    public void testPositionalDeleteRecordedBeforeFlushIsApplied() throws IOException {
        }
            }  
        MappedFieldType textField = mockTextField("content");
import org.apache.lucene.store.NIOFSDirectory;
        try (
        when(otherFormat.name()).thenReturn("parquet");  
        when(numericField.typeName()).thenReturn("integer");
            try (NIOFSDirectory dir2 = new NIOFSDirectory(Path.of(wfs2.directory())); IndexReader reader2 = DirectoryReader.open(dir2)) {  
import java.util.Optional;  
                }
import org.opensearch.index.engine.dataformat.FlushInput;
        try (  
        input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);  
                0L,  
            input.addField(textField, "test value");
            }
                input.addField(textField, "hello world " + i);  
import org.apache.lucene.codecs.Codec;
                dataFormat,
            null,  
            LuceneDocumentInput input = new LuceneDocumentInput();
            0L,
                dataFormat,
                new LuceneShardStatsTracker()
        Path baseDir = createTempDir();  
    }
        writer.addDoc(input);
                baseDir,
            assertEquals("applied positional delete must not be counted after flush", 0L, writer.getHeapBytesUsed());  
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();  
            baseDir,  
            assertThat(wfs1.numRows(), equalTo((long) numDocs1));  
            gen1,
                // Verify exactly 1 segment
                ConcurrentHashMap.newKeySet(),  
                LuceneDocumentInput input = new LuceneDocumentInput();  
                dataFormat,
                Codec.getDefault(),
                indexSort,
            }  
                Codec.getDefault(),
        );  
                0L,  
                dataFormat,
            1L,  
        try (
                new LuceneShardStatsTracker()  
        when(fieldOwnedByOther.getCapabilityMap()).thenReturn(
 * segments in isolated temp directories with force-merge to 1 segment on flush.  
                writer.addDoc(input);
import org.opensearch.index.engine.dataformat.WriteResult;
        }  
                LuceneDocumentInput input = new LuceneDocumentInput();
            0L,
                baseDir,
                for (int docId = 0; docId < numDocs; docId++) {
                LuceneDocumentInput nextDoc = new LuceneDocumentInput();
        dataFormat = new LuceneDataFormat();  
                1L,
                // Verify row IDs match doc IDs  
            new LuceneShardStatsTracker()
            input.addField(fieldOwnedByOther, 42);
        MappedFieldType textField = mockTextField("content");
            input.addField(textField, "hello world");  
        // A pending row id that the writer never gets to apply.
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);  
                Codec.getDefault(),
            gen2,  
        when(numericField.getCapabilityMap()).thenReturn(java.util.Map.of());
            baseDir,
                LuceneDocumentInput input = new LuceneDocumentInput();  
        }
    /**
                    LeafReader leafReader = ctx.reader();
            dataFormat,  
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
                }
            LuceneWriter writer = new LuceneWriter(  
            baseDir,  
     * forceMerge actually rewrites the segment, so the tombstone is physically expunged  
                        assertThat("row ID should equal Lucene doc ID", rowIdValues.nextValue(), equalTo((long) docId));  
    }
                input.addField(textField, "document title " + i);
            )
    }
        DataFormat otherFormat = mock(DataFormat.class);
                0L,  
                0L,
        ) {  
                baseDir,
            assertTrue(fileInfos.getWriterFileSet(dataFormat).isPresent());
                expectThrows(IllegalStateException.class, () -> writer.addDoc(nextDoc));
            for (int i = 0; i < 3; i++) {
        Sort indexSort = new Sort(new SortedNumericSortField(LuceneDocumentInput.ROW_ID_FIELD, SortField.Type.LONG));
    /** Sealing must not affect row ids recorded before flush: they are still applied. */
            int numDocs = randomIntBetween(5, 15);
                LuceneDocumentInput input = new LuceneDocumentInput();
 * Tests for {@link LuceneWriter} — the per-generation Lucene writer that creates
                input.addField(textField, "gen1 doc " + i);
                writer1.addDoc(input);  
    }
                null,  
                Codec.getDefault(),
                null,  
            )  
            // Should not throw — unsupported types are silently skipped (handled by other formats)
            }
import org.opensearch.be.lucene.LuceneDataFormat;  
            assertThat(wfs2.writerGeneration(), equalTo(gen2));  
                1L,  
            dataFormat,
            }
            WriterFileSet wfs2 = fileInfos2.getWriterFileSet(dataFormat).get();
    }
                writer.addDoc(input);
            assertNotNull(reader.leaves().get(0).reader().getLiveDocs());
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
                ConcurrentHashMap.newKeySet(),  
                1L,
            LuceneWriter writer = new LuceneWriter(
                baseDir,
                ConcurrentHashMap.newKeySet(),  
    }
                new LuceneShardStatsTracker()
                // Verify correct doc count  
        Path baseDir = createTempDir();
            Codec.getDefault(),
    public void testAddDocAndFlushProducesSingleSegment() throws IOException {  
                dataFormat,
        LuceneDocumentInput input = new LuceneDocumentInput();
                dataFormat,
        for (Sort sort : new Sort[] { null, indexSort }) {  
                    }
            )  
                ConcurrentHashMap.newKeySet(),  
            LuceneWriter writer = new LuceneWriter(
        ) {
        int numDocs = randomIntBetween(10, 50);
                new LuceneShardStatsTracker()
                1L,
            null,  
        int numDocs1 = randomIntBetween(3, 10);
                    Codec.getDefault(),
            )
                dataFormat,
                1L,
                        assertTrue(rowIdValues.advanceExact(docId));
                1L,
    public void testUnsupportedFieldTypeIsSilentlySkipped() throws IOException {
            writer.addDoc(input);
import org.opensearch.index.engine.dataformat.DataFormat;
            )
                baseDir,
                null,  
        ) {  
            for (int i = 0; i < 3; i++) {
        MappedFieldType textField = mockTextField("content");
            LuceneWriter writer = new LuceneWriter(
        ) {  
                new LuceneShardStatsTracker()
            }  
                null,  
        );
    public void testPositionalDeleteRecordedAfterCloseIsDiscarded() throws IOException {
        writer.recordPositionalDelete(0L);  
                dataFormat,
            )
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
/**
            writer.addDoc(input);
                null,
                null,  
        ) {  
    public void testRowIdMatchesLuceneDocId() throws IOException {
            // Each is independently readable with correct content  
        }
        assertFalse(result.isPresent());
                ConcurrentHashMap.newKeySet(),
        ) {  
            )
    /**
                new LuceneShardStatsTracker()
                ConcurrentHashMap.newKeySet(),
import org.apache.lucene.index.DirectoryReader;
                new LuceneShardStatsTracker()
                new LuceneShardStatsTracker()
    public void testKeywordFieldsAreIndexed() throws IOException {  
import org.apache.lucene.index.Term;
                writer.addDoc(input);
                writer.addDoc(input);
            new LuceneShardStatsTracker()
                    dataFormat,
                    sort,  
        Path baseDir = createTempDir();
            try (NIOFSDirectory dir1 = new NIOFSDirectory(Path.of(wfs1.directory())); IndexReader reader1 = DirectoryReader.open(dir1)) {
                ConcurrentHashMap.newKeySet(),
            // Correct doc counts
        Path baseDir = createTempDir();  
        Path baseDir = createTempDir();
            try (NIOFSDirectory dir = new NIOFSDirectory(Path.of(wfs.directory())); IndexReader reader = DirectoryReader.open(dir)) {  
                Codec.getDefault(),
                baseDir,
            // add document so that it consumes heap memory
    public void testGetHeapBytesUsedPositiveAfterIndexing() throws IOException {
        writer.recordPositionalDelete(0L);  
                    "forceMerge under real merge policy must expunge tombstone",
                assertTrue(result instanceof WriteResult.Success);
            rollback.addField(textField, "to-rollback");  
        }  
                dataFormat,
                baseDir,  
                input.addField(textField, "value " + i);
 * compatible open source license.
    }
     */
                Codec.getDefault(),
            LuceneWriter writer = new LuceneWriter(
import java.nio.file.Path;
            input.addField(numericField, 42);  
        super.setUp();
                null,
    @Override  
        int numDocs2 = randomIntBetween(3, 10);
import org.apache.lucene.search.TermQuery;
                SortedNumericDocValues rowIdValues = leafReader.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
            assertThat(wfs1.writerGeneration(), equalTo(gen1));
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
        Path baseDir = createTempDir();
                baseDir,
                    null,
        MappedFieldType textField = mockTextField("content");
                LuceneDocumentInput input = new LuceneDocumentInput();  
                ConcurrentHashMap.newKeySet(),  
                0L,
     * Rollback path with the indexSort branch (LogByteSizeMergePolicy + IndexSort). Here
                // Verify keyword field is searchable
                1L,
                    1L,  
            LuceneWriter writer = new LuceneWriter(
                assertThat(searcher.count(new MatchAllDocsQuery()), equalTo(1));
        input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);  
                assertThat(reader1.numDocs(), equalTo(numDocs1));
            input.addField(keywordField, "active");
                for (LeafReaderContext ctx : reader.leaves()) {  
            assertTrue("getHeapBytesUsed should be > 0 after indexing", writer.getHeapBytesUsed() > 0);
        );  
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
            rollback.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 5);
            )
        ) {
            )
                writer2.addDoc(input);
            assertTrue("Should return present for 'lucene'", result.isPresent());  
            assertEquals("getHeapBytesUsed should be 0 after flush", 0L, writer.getHeapBytesUsed());  
                    ConcurrentHashMap.newKeySet(),
    public void testGetWriterForFormatReturnsItselfForLucene() throws IOException {
    }  
            assertNotEquals("Writers should have different directories", wfs1.directory(), wfs2.directory());
            writer.recordPositionalDelete(1L);
                input.addField(textField, "value " + i);
                WriteResult result = writer.addDoc(input);  
            LuceneDocumentInput input = new LuceneDocumentInput();
     * A delete can resolve a previous copy to a generation whose writer has already flushed but is
        try {
            }
    public void testMixedTextAndKeywordFields() throws IOException {
            writer.flush(FlushInput.EMPTY);
            MappedFieldType textField = mockTextField("content");
            assertThat(writer.generation(), equalTo(gen));
        );
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
import org.opensearch.index.engine.exec.WriterFileSet;
            LuceneWriter writer = new LuceneWriter(
     * still registered with the delete engine. The row id can no longer be applied by that writer,  
                writer.addDoc(input);  
        LuceneWriter writer = new LuceneWriter(
        try (  
        // because close() deletes the temp directory.
                null,
    }
                0L,  
            LuceneWriter writer = new LuceneWriter(
            )
    }  
                new LuceneShardStatsTracker()
    }
            WriterFileSet wfs = fileInfos.getWriterFileSet(dataFormat).get();
        }
            assertThat(wfs.numRows(), equalTo((long) numDocs));
            assertSame("Should return itself", writer, result.get());
        long gen = randomLongBetween(1, 100);
                LuceneWriter writer = new LuceneWriter(
        ) {  
            LuceneWriter writer = new LuceneWriter(
                null,  
                    for (int docId = 0; docId < leafReader.maxDoc(); docId++) {
            int numDocs = randomIntBetween(5, 20);  
                )  
                dataFormat,
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
                    assertNotNull("row_id doc values should exist", rowIdValues);  
                gen,  
        Path baseDir = createTempDir();
            fileInfos2 = writer2.flush(FlushInput.EMPTY);
                writer.addDoc(input);  
                MappedFieldType textField = mockTextField("content");
        LuceneDocumentInput input = new LuceneDocumentInput();
                assertThat("rollback must retire the writer (sort=" + sort + ")", writer.state().toString(), equalTo("RETIRED_FLUSHABLE"));  
            for (int i = 0; i < numDocs; i++) {
            LuceneWriter writer = new LuceneWriter(
                null,
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
    public void testFieldOwnedByAnotherFormatIsSilentlySkipped() throws IOException {  
                Codec.getDefault(),
    public void testRollbackRetiresWriterInBothBranches() throws IOException {  
        try (
        writer.close();  
            new LuceneShardStatsTracker()
            )
            // Different directories
                    reader.leaves().get(0).reader().maxDoc(),  
package org.opensearch.be.lucene.index;
                assertTrue(searcher.count(new TermQuery(new Term("status", "active"))) > 0);
                // Verify text field is searchable via TermQuery  
import org.apache.lucene.search.MatchAllDocsQuery;  
                    SortedNumericDocValues rowIdValues = leafReader.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
        Path baseDir = createTempDir();
            )  
