    public void testRefreshIncorporatesLuceneSegments() throws IOException {
    /**
import java.util.concurrent.ConcurrentHashMap;
        writer1.close();  
            Segment segment2 = Segment.builder(gen2).addSearchableFiles(luceneDataFormat, wfs2).build();
        long generation = 1L;
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
            committer,
     */
                null,  
                input.addField(keywordField, "tag_" + i);
        field.setAccessible(true);
    /**
        assertEquals(0, writer.getDocStats().numDocs);  
                if (wfs.writerGeneration() == gen1) {  
            assertNotNull(resultWfs);
            indexSettings,
            null,  
            .build();
            WriterFileSet resultWfs = resultSegment.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);  
                RefreshInput.builder().addSegment(Segment.builder(generation).addSearchableFiles(luceneDataFormat, flushed).build()).build()  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        Writer<LuceneDocumentInput> writer = engine.createWriter(new WriterConfig(generation));
        assertNotNull(result);
            null
            assertNotNull(result);
    /**  
            writer1.close();
            assertTrue("Should find segment with generation 1", foundGen1);
        int numDocs = randomIntBetween(3, 15);
import org.apache.logging.log4j.LogManager;
import org.opensearch.index.translog.TranslogConfig;
    private LuceneCommitter committer;
            mapperService,  
        assertNotNull(result);
            mapperService.getIndexSettings(),
                0L,
     * Property 1: refresh incorporates Lucene segments when parent writer is present.
        String translogUUID = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, 1L);  
    @SuppressForbidden(reason = "Test verifies reflection used by clearStaleLocks is compatible with current Lucene")
                    foundGen2 = true;
        Path parquetDir = createTempDir().resolve("parquet");
            store
        // Create writers through the engine — do NOT close them before refresh,  
    }  
        WriterConfig config1 = new WriterConfig(1L);
        MappedFieldType textField = mockTextField("content");
            null,
            new LuceneDataFormat(),
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
    /**  
            assertEquals(generation, resultWfs.writerGeneration());  
     */  
        Segment segment = Segment.builder(1L).addSearchableFiles("parquet", writerFileSet).build();
            WriterFileSet resultWfs = resultSegment.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);
import org.opensearch.index.engine.dataformat.Writer;
        } finally {  
            mapperService,
    /**
        WriterFileSet carried = withoutDeletes.refreshedSegments()  
                null,
        LuceneWriter writer1 = (LuceneWriter) engine.createWriter(new WriterConfig(gen1));
            FileInfos fileInfos = luceneWriter.flush(FlushInput.EMPTY);
            committer,  
                    foundGen1 = true;
        try (
        int numDocs2 = randomIntBetween(3, 10);
            store
import org.opensearch.index.shard.ShardPath;
        assertTrue("no-delete refresh must not compute dropped generations", withoutDeletes.droppedGenerations().isEmpty());
                generation,
        assertEquals("All writers closed, heap should be 0", 0L, engine.getHeapBytesUsed());  
            WriterFileSet wfs = fileInfos.getWriterFileSet(luceneDataFormat).get();
            () -> Boolean.TRUE,
    }  
        );  
    }  
                assertEquals(store.shardPath().resolveIndex().toString(), wfs.directory());
            null,
    }
}
     */
        PluginsService mockPluginsService = mock(PluginsService.class);
    public void testDeleteFilesIgnoresNonLuceneFormat() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    }
            // Verify result segments have correct file names from the shared directory  
        assertTrue("Heap should decrease after closing a writer", heapAfterClose < totalHeap);
        assertNotNull("LOCK_HELD field must be accessible via reflection", value);
     * Constructor with null committer throws IllegalArgumentException.
        assertTrue("LOCK_HELD must be a Set<String>", value instanceof java.util.Set);
            mapperService.getIndexSettings(),
            LuceneDocumentInput input = new LuceneDocumentInput();  
        }
        Path tempBase = createTempDir();
            .directory(Path.of(publishedFiles.directory()))  
        long gen1 = 1L;
    }
import org.opensearch.index.engine.dataformat.WriterConfig;
            null,
        MappedFieldType textField = mockTextField("content");  
            mapperService.getIndexSettings(),
        long heapAfterClose = engine.getHeapBytesUsed();
            Segment segment1 = Segment.builder(gen1).addSearchableFiles(luceneDataFormat, wfs1).build();
import org.opensearch.index.IndexSettings;
            new DummyShardLock(shardId),
        long generation = 1L;
            // Build segments and refresh with both  
            committer,
            Store.OnClose.EMPTY,  
            mapperService,  
    public void testRefreshWithNoLuceneFilesSkipsAddIndexes() throws IOException {  
                LuceneDocumentInput input = new LuceneDocumentInput();
        writer2.close();
                generation,
        super.tearDown();
            for (int i = 0; i < 3; i++) {
            committer,
    public void setUp() throws Exception {
     * carried through untouched and no dropped generation is computed. With a delete applied, every
 */
            committer,
 */  
        long totalHeap = engine.getHeapBytesUsed();  
            luceneDataFormat,  
     * Use engine.createWriter() to create a writer, add docs, flush, build segment,  
                Codec.getDefault(),  
            luceneDataFormat,
        IndexWriter sharedWriter = committer.getIndexWriter();
    /**  
            store
            assertEquals(numDocs1 + numDocs2, sharedWriter.getDocStats().numDocs);
            LuceneWriter luceneWriter = new LuceneWriter(
        WriterFileSet publishedFiles = published.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);
            boolean foundGen1 = false;
            mapperService.getIndexSettings(),
            assertEquals(2, result.refreshedSegments().size());
import org.opensearch.index.mapper.MappedFieldType;  
            null,  
import org.opensearch.index.engine.exec.Segment;  
 * compatible open source license.
            mapperService.getIndexSettings(),
            LuceneWriter luceneWriter = new LuceneWriter(  
import java.nio.file.Path;
        Path baseDir = createTempDir();
            }  
        java.nio.file.Files.createDirectories(translogPath);
            store  
            null,
            FileInfos fileInfos2 = writer2.flush(FlushInput.EMPTY);
        ) {
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(  
     * Refresh with no files skips addIndexes.
        // Add docs to both writers
            mapperService.getIndexSettings(),
        IndexWriter writer = committer.getIndexWriter();
            for (int i = 0; i < numDocs; i++) {
                } else if (wfs.writerGeneration() == gen2) {  
                0L,  
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            WriterFileSet wfs1 = fileInfos1.getWriterFileSet(luceneDataFormat).get();
import org.opensearch.index.translog.InternalTranslogFactory;  
        for (int i = 0; i < 3; i++) {
        if (committer != null) {
import org.opensearch.test.DummyShardLock;
            luceneDataFormat,
    @Override
        assertTrue(java.util.Set.of(directory.listAll()).contains("_0.cfe"));
            .addFile("carried-through.marker")
            for (Segment seg : result.refreshedSegments()) {  
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
        );
        assertEquals(0, sharedWriter.getDocStats().numDocs);
                LuceneDocumentInput input = engine.newDocumentInput();
            false,  
        RefreshResult withoutDeletes = engine.refresh(RefreshInput.builder().existingSegments(List.of(existing)).build());
            assertNotNull("Result segment should have lucene files", resultWfs);
        EngineConfig engineConfig = new EngineConfigFactory(mockPluginsService, indexSettings).newEngineConfig(
        Segment existing = Segment.builder(generation).addSearchableFiles(luceneDataFormat, tagged).build();  
            writer2.close();
            mapperService,  
                null,
            Segment segment = Segment.builder(generation).addSearchableFiles(luceneDataFormat, wfs).build();  
            TimeValue.timeValueMinutes(5),  
        assertFalse("delete refresh must rebuild the entry from the reader", rebuilt.files().contains("carried-through.marker"));  
        committer = createCommitter();
    /**
            mapperService,
            RefreshResult result = engine.refresh(refreshInput);  
            .get(0)
import org.opensearch.index.store.Store;
import org.opensearch.plugins.EnginePlugin;  
                    assertEquals(numDocs1, wfs.numRows());
            }
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
     */
            null,
            LuceneDocumentInput input = new LuceneDocumentInput();  
import org.opensearch.common.util.BigArrays;  
                Codec.getDefault(),
        }  
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
        );
import org.opensearch.plugins.PluginsService;
            mapperService.getIndexSettings(),  
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
            for (int i = 0; i < numDocs1; i++) {
            assertEquals(store.shardPath().resolveIndex().toString(), resultWfs.directory());
     * segments have correct file names from the shared directory.
        );
            }
     */
     * Asserts that reflection access to NativeFSLockFactory.LOCK_HELD works with the
            // Verify shared writer has the docs  
        CommitterConfig settings = new CommitterConfig(engineConfig, () -> {});  
            luceneDataFormat,
        when(ms.indexAnalyzer()).thenReturn(new MockAnalyzer(random()));  
        try {
            WriterFileSet wfs = fileInfos.getWriterFileSet(luceneDataFormat).get();  
        }
        ShardId shardId = new ShardId("test", "_na_", 0);
import org.opensearch.be.lucene.LuceneDataFormat;  
        int numDocs1 = randomIntBetween(3, 10);  
    }
        );  
        WriterFileSet tagged = WriterFileSet.builder()
import org.opensearch.test.IndexSettingsModule;  
            input.addField(textField, "doc " + i);
import org.opensearch.index.engine.dataformat.FlushInput;
            WriterFileSet wfs2 = fileInfos2.getWriterFileSet(luceneDataFormat).get();
/**  
     * Create 2 writers via the engine, write docs to each, flush each, refresh with both.  
            RefreshResult result = engine.refresh(refreshInput);
            }  
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(  
            null,
     * current Lucene version. If Lucene changes this field (renamed, removed, or type
        return new LuceneCommitter(settings);
            assertFalse("Result should have segments", result.refreshedSegments().isEmpty());
            RefreshResult initial = engine.refresh(
import org.opensearch.index.engine.EngineConfig;
            // Verify result has 2 segments with correct generations
                input.addField(textField, "writer2 doc " + i);  
    }
        directory.createOutput("_0.cfs", org.apache.lucene.store.IOContext.DEFAULT).close();  
import org.opensearch.index.engine.exec.WriterFileSet;
            luceneDataFormat,
            for (int i = 0; i < numDocs2; i++) {
            committer,  
    public void testConstructorWithNullCommitterThrows() {  
            mapperService,  
import org.opensearch.index.seqno.RetentionLeases;
        Files.createDirectories(parquetDir);
            MappedFieldType textField = mockTextField("content");  
            null,  
            new TranslogConfig(shardId, translogPath, indexSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false),
     */
            Segment resultSegment = result.refreshedSegments().get(0);  
     * deleteFiles is a no-op for Lucene format — Lucene's internal IndexFileDeleter
        Files.createDirectories(dataPath);
        store = new Store(
     */
        }
        assertTrue("nothing was actually deleted, so no generation is dropped", withDeletes.droppedGenerations().isEmpty());
            store.close();
                writer1.addDoc(input);  
        );  
            Segment segment = Segment.builder(generation).addSearchableFiles(luceneDataFormat, wfs).build();
            mapperService,
import org.opensearch.index.seqno.SequenceNumbers;  
import org.opensearch.index.engine.dataformat.FileInfos;  
import org.apache.lucene.codecs.Codec;
            new InternalTranslogFactory(),
            shardId,
     * Verify the shared writer has all docs and the result has 2 segments with correct generations.
import org.opensearch.common.unit.TimeValue;
     * The delete gate: with no delete applied, an already-published generation's catalog entry is
    }
            null,
            null,
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();  
    }
import org.opensearch.core.index.shard.ShardId;
            committer,
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
        assertTrue(java.util.Set.of(directory.listAll()).contains("_0.cfs"));  
     * deleteFiles ignores non-lucene format keys.
                luceneDataFormat,
        assertEquals(generation, rebuilt.writerGeneration());
    public void testNativeFSLockFactoryLockHeldFieldAccessible() throws Exception {  
        Path dataPath = baseDir.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));  
        RefreshResult result = engine.refresh(emptyInput);
            assertEquals(numDocs, sharedWriter.getDocStats().numDocs);
import java.util.List;  
            RefreshResult result = engine.refresh(refreshInput);
            .addNumRows(publishedFiles.numRows())
            assertFalse("Result should have file names", resultWfs.files().isEmpty());
import org.opensearch.index.engine.EngineConfigFactory;
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);  
        try (  
import org.opensearch.index.translog.Translog;
import static org.mockito.Mockito.mock;  
/*  
        );  
                assertFalse(wfs.files().isEmpty());
            mapperService.getIndexSettings(),
            // Build segment and refresh  
            );
            mapperService.getIndexSettings(),
            Segment resultSegment = result.refreshedSegments().get(0);
    /**
            totalHeap
            published = initial.refreshedSegments().get(0);
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
        assertTrue("no-delete refresh must carry the existing entry verbatim", carried.files().contains("carried-through.marker"));
    }  
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            null,  
        return ms;  
import org.opensearch.index.engine.exec.commit.CommitterConfig;
        IndexWriter sharedWriter = committer.getIndexWriter();  
                tempBase,
            committer,
        );
    }
     * Validates: Requirements 2.3  
            null,
    private ShardPath shardPath;
    public void testRefreshSkipsNonLuceneDirectories() throws IOException {
package org.opensearch.be.lucene.index;
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
                input.addField(textField, "content value " + i);  
            mapperService,  
     * deleteFiles removes lucene-format files from the store directory.
                assertNotNull(wfs);
            assertEquals(numDocs, writer.getDocStats().numDocs);
        assertEquals("Non-lucene directories should be skipped", 0, writer.getDocStats().numDocs);  
        super.setUp();  
            RefreshInput refreshInput = RefreshInput.builder().addSegment(segment).build();
            )
            assertEquals(store.shardPath().resolveIndex().toString(), resultWfs.directory());  
                new LuceneShardStatsTracker()
     */  
                createTempDir(),
            new LuceneDataFormat(),  
import org.opensearch.index.codec.CodecService;  
        IndexWriter writer = committer.getIndexWriter();
        // Create writers via engine.createWriter to use the engine's internal activeWriters set
        WriterFileSet writerFileSet = WriterFileSet.builder().directory(parquetDir).writerGeneration(1L).addNumRows(1).build();
                    assertEquals(numDocs2, wfs.numRows());
            indexSettings,  
                input.addField(textField, "doc_" + i);  
            store  
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(  
        for (int i = 0; i < 5; i++) {
import org.opensearch.index.engine.dataformat.RefreshResult;  
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(  
        int numDocs = randomIntBetween(1, 20);
                input.addField(textField, "doc_" + i);  
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
    public void testGetHeapBytesUsedSumsActiveWriters() throws IOException {
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
import static org.mockito.Mockito.when;
        engine.deleteFiles(java.util.Map.of("lucene", java.util.List.of("_0.cfs", "_0.cfe")));  
        org.apache.lucene.store.Directory directory = store.directory();
            new CodecService(null, indexSettings, LogManager.getLogger(getClass()), List.of()),
            store
        store.createEmpty(org.apache.lucene.util.Version.LATEST, translogUUID);  
        expectThrows(IllegalArgumentException.class, () -> new LuceneIndexingExecutionEngine(null, null, null, null, null));
    /**  
import org.apache.lucene.index.IndexWriter;  
                null,
                LuceneDocumentInput input = engine.newDocumentInput();
        Object value = field.get(null);  
                ConcurrentHashMap.newKeySet(),
    public void testMultipleWriterRefreshAccumulatesInSharedWriter() throws IOException {  
            luceneDataFormat,
    }
            .addFiles(publishedFiles.files())  
        RefreshInput emptyInput = RefreshInput.builder().build();  
        // Create writer through the engine
        // because close() deletes the temp directory that refresh needs to read.
        LuceneWriter writer1 = (LuceneWriter) engine.createWriter(config1);
            new NIOFSDirectory(dataPath),
        mapperService = createMockMapperService();
                WriterFileSet wfs = seg.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);
        RefreshResult withDeletes = engine.refresh(RefreshInput.builder().existingSegments(List.of(existing)).deletesApplied(true).build());
            null,
        LuceneWriter writer2 = (LuceneWriter) engine.createWriter(new WriterConfig(gen2));  
        long generation = 1L;  
            store  
 * Tests for {@link LuceneIndexingExecutionEngine}.
     */  
            writer.close();
            null,  
        MapperService ms = mock(MapperService.class);
            shardPath
                }  
            null,  
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();  
import org.opensearch.index.mapper.MapperService;
                luceneDataFormat,  
    public void testRefreshRebuildsExistingSegmentsOnlyWhenDeletesApplied() throws IOException {
                new LuceneShardStatsTracker()  
            // The directory should be the shared writer's directory (store index path)
        when(mockPluginsService.filterPlugins(EnginePlugin.class)).thenReturn(List.of(new LucenePlugin()));  
            committer,  
            input.addField(textField, "doc " + i);
        } finally {  
            writer1.getHeapBytesUsed() + writer2.getHeapBytesUsed(),
    private LuceneCommitter createCommitter() throws IOException {  
        shardPath = new ShardPath(false, dataPath, dataPath, shardId);  
    public void testDeleteFilesIsNoOpForLuceneFormat() throws IOException {
                LuceneDocumentInput input = engine.newDocumentInput();  
     * Refresh with null input returns empty result.
            }  
        assertEquals(0, committer.getIndexWriter().getDocStats().numDocs);  
            null,
        RefreshInput refreshInput = RefreshInput.builder().addSegment(segment).build();  
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
    @Override
     * live generation's file set is rebuilt from the reader so new {@code .liv} files are cataloged.  
        }  
            for (int i = 0; i < numDocs; i++) {
            assertEquals(generation, resultWfs.writerGeneration());
            assertEquals(numDocs, resultWfs.numRows());  
            WriterFileSet flushed = luceneWriter.flush(FlushInput.EMPTY).getWriterFileSet(luceneDataFormat).get();
        WriterConfig config2 = new WriterConfig(2L);  
        MappedFieldType textField = mockTextField("content");
    /**
            assertFalse(result.refreshedSegments().isEmpty());
        assertTrue(result.refreshedSegments().isEmpty());  
    public void tearDown() throws Exception {  
        }  
 *
import org.apache.lucene.store.NIOFSDirectory;
    }
            input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            store,  
     */  
        assertEquals(
                luceneWriter.addDoc(input);
     */
 * The OpenSearch Contributors require contributions made to  
            // Verify shared writer has all docs
        );  
 * this file be licensed under the Apache-2.0 license or a
            luceneDataFormat,
import org.apache.lucene.tests.analysis.MockAnalyzer;
import java.io.IOException;
            assertFalse(resultWfs.files().isEmpty());
        Path translogPath = dataPath.resolve("translog");
            mapperService.getIndexSettings(),  
        when(ms.getIndexSettings()).thenReturn(indexSettings);
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
        );
        // Use LuceneWriter to create segments (which sets the writer_generation attribute via LuceneWriterCodec)
            }  
    private MapperService mapperService;
    private Store store;  
        // entry is distinguishable from one rebuilt out of the reader's leaves.  
        ) {  
        WriterFileSet rebuilt = withDeletes.refreshedSegments().get(0).dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);
            mapperService,
        java.lang.reflect.Field field = org.apache.lucene.store.NativeFSLockFactory.class.getDeclaredField("LOCK_HELD");
import java.util.Collections;
            store
import org.opensearch.common.SuppressForbidden;  
        long gen2 = 2L;
import java.nio.file.Files;  
            RefreshInput refreshInput = RefreshInput.builder().addSegment(segment1).addSegment(segment2).build();
            FileInfos fileInfos1 = writer1.flush(FlushInput.EMPTY);
            store
    public void testRefreshWithNullInputReturnsEmpty() throws IOException {
            RefreshInput refreshInput = RefreshInput.builder().addSegment(segment).build();
        Segment published;
        // Close writer1 — engine heap should decrease
            assertEquals(numDocs, resultWfs.numRows());
            store
            // Build a Segment from the FileInfos
            null,
                luceneWriter.addDoc(input);
            null,
        );  
import org.opensearch.be.lucene.LucenePlugin;
            null,
     * changed), this test fails during CI — signalling that clearStaleLocks needs updating.  
            committer,
     * deleteFiles is a no-op — Lucene's internal IndexFileDeleter handles segment file cleanup.
        );
            new LuceneDataFormat(),
            )
    /**  
     * handles segment file cleanup via IndexCommit.delete() + deleteUnusedFiles().
     * Refresh skips WriterFileSets whose directory does not match the Lucene data format name.  
    private MapperService createMockMapperService() {
            mapperService,
                writer2.addDoc(input);
        }
        directory.createOutput("_0.cfe", org.apache.lucene.store.IOContext.DEFAULT).close();
        }  
            assertTrue("Should find segment with generation 2", foundGen2);
        // Files still exist — Lucene manages their lifecycle
            "Engine heap should equal sum of individual writers",  
                LuceneDocumentInput input = new LuceneDocumentInput();
        );
        // Tag the published entry with a name the reader can never produce, so a carried-through
            input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
        engine.deleteFiles(java.util.Map.of("parquet", java.util.List.of("_0.parquet")));
        try {  
        if (store != null) {
            shardId,
            null,  
        RefreshResult result = engine.refresh(null);
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        Path tempBase = createTempDir();
        assertEquals("No writers yet, heap should be 0", 0L, engine.getHeapBytesUsed());
            .dfGroupedSearchableFiles()
            boolean foundGen2 = false;
        MappedFieldType textField = mockTextField("content");  
        engine.refresh(refreshInput);
        assertTrue("Engine heap should be > 0 with active writers", totalHeap > 0);
import org.opensearch.common.settings.Settings;
        LuceneWriter writer2 = (LuceneWriter) engine.createWriter(config2);
                ConcurrentHashMap.newKeySet(),  
        assertEquals(writer2.getHeapBytesUsed(), heapAfterClose);  
import org.opensearch.index.engine.dataformat.RefreshInput;
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
    /**  
            writer1.addDoc(input);  
        // Create a segment directory that looks like it has files but is keyed under "parquet"  
     * call engine.refresh(). Verify the shared writer has the docs and the result
            new MockAnalyzer(random()),
            writer2.addDoc(input);  
public class LuceneIndexingExecutionEngineTests extends LucenePluginBaseTests {  
     */  
    public void testWriterCreationAndFlushThroughEngine() throws IOException {
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(  
            .writerGeneration(publishedFiles.writerGeneration())
            () -> new RetentionLeases(0, 0, Collections.emptyList()),  
     */
    }  
    /**
                writer.addDoc(input);  
        MappedFieldType keywordField = mockKeywordField("tag");
    }
            // Verify the result has segments with actual file names from the shared directory
            .get(LuceneDataFormat.LUCENE_FORMAT_NAME);  
                input.addField(textField, "writer1 doc " + i);
            committer.close();
