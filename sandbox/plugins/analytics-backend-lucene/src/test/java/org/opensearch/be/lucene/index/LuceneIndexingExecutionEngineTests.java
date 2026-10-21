        WriterConfig config2 = new WriterConfig(2L);
import org.opensearch.index.engine.exec.commit.CommitterConfig;
                assertNotNull(wfs);
        Writer<LuceneDocumentInput> writer = engine.createWriter(new WriterConfig(generation));
        long totalHeap = engine.getHeapBytesUsed();
            store
            new NIOFSDirectory(dataPath),
            for (Segment seg : result.refreshedSegments()) {
    }
        when(ms.getIndexSettings()).thenReturn(indexSettings);
            .addFile("carried-through.marker")
        if (committer != null) {
    }
            // Verify shared writer has the docs
    public void testDeleteFilesIsNoOpForLuceneFormat() throws IOException {
 * compatible open source license.
            }
            assertFalse("Result should have segments", result.refreshedSegments().isEmpty());
    }
import org.opensearch.index.seqno.RetentionLeases;
        long generation = 1L;
                LuceneDocumentInput input = new LuceneDocumentInput();
    /**
import org.opensearch.be.lucene.LuceneDataFormat;
    }
            store
        RefreshResult withoutDeletes = engine.refresh(RefreshInput.builder().existingSegments(List.of(existing)).build());
            assertEquals(store.shardPath().resolveIndex().toString(), resultWfs.directory());
        );
     * call engine.refresh(). Verify the shared writer has the docs and the result
                tempBase,
    public void testWriterCreationAndFlushThroughEngine() throws IOException {
import org.opensearch.index.engine.dataformat.WriterConfig;
                writer.addDoc(input);
        }
            mapperService,
        }
    /**
        Path tempBase = createTempDir();
            null,
            boolean foundGen2 = false;
                if (wfs.writerGeneration() == gen1) {
import org.apache.lucene.tests.analysis.MockAnalyzer;
        LuceneWriter writer1 = (LuceneWriter) engine.createWriter(new WriterConfig(gen1));
            shardId,
                LuceneDocumentInput input = new LuceneDocumentInput();
        assertNotNull(result);
    private MapperService mapperService;
    }
            mapperService,
    /**
        Segment segment = Segment.builder(1L).addSearchableFiles("parquet", writerFileSet).build();
                LuceneDocumentInput input = engine.newDocumentInput();
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
            FileInfos fileInfos = luceneWriter.flush(FlushInput.EMPTY);
            new InternalTranslogFactory(),
            mapperService.getIndexSettings(),
            Store.OnClose.EMPTY,
        assertTrue("no-delete refresh must not compute dropped generations", withoutDeletes.droppedGenerations().isEmpty());
        ) {
    /**
                Codec.getDefault(),
            store
                assertFalse(wfs.files().isEmpty());
            mapperService.getIndexSettings(),
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
        }
        RefreshInput emptyInput = RefreshInput.builder().build();
     */
                ConcurrentHashMap.newKeySet(),
            committer,
        }
    public void testRefreshIncorporatesLuceneSegments() throws IOException {
            null,
            WriterFileSet resultWfs = resultSegment.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);
            writer1.getHeapBytesUsed() + writer2.getHeapBytesUsed(),
    public void testRefreshWithNoLuceneFilesSkipsAddIndexes() throws IOException {
import org.opensearch.index.seqno.SequenceNumbers;
     * handles segment file cleanup via IndexCommit.delete() + deleteUnusedFiles().
     * Create 2 writers via the engine, write docs to each, flush each, refresh with both.
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
            new LuceneDataFormat(),
    /**
        assertEquals(
                generation,
        WriterFileSet rebuilt = withDeletes.refreshedSegments().get(0).dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);
            null,
     */
    /**
            null,
        assertEquals(0, writer.getDocStats().numDocs);
                input.addField(textField, "writer1 doc " + i);
            "Engine heap should equal sum of individual writers",
            assertEquals(numDocs, resultWfs.numRows());
    private LuceneCommitter committer;
    /**
            Segment segment = Segment.builder(generation).addSearchableFiles(luceneDataFormat, wfs).build();
            assertEquals(numDocs1 + numDocs2, sharedWriter.getDocStats().numDocs);
        MappedFieldType textField = mockTextField("content");
        // Files still exist — Lucene manages their lifecycle
        WriterFileSet carried = withoutDeletes.refreshedSegments()
import org.opensearch.test.DummyShardLock;
            .directory(Path.of(publishedFiles.directory()))
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
        IndexWriter sharedWriter = committer.getIndexWriter();
                new LuceneShardStatsTracker()
            published = initial.refreshedSegments().get(0);
            null
            mapperService,
     * Refresh skips WriterFileSets whose directory does not match the Lucene data format name.
            FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
            writer2.close();
        Path baseDir = createTempDir();
        );
                luceneDataFormat,
        String translogUUID = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, 1L);
import org.opensearch.index.store.Store;
                    assertEquals(numDocs1, wfs.numRows());
                0L,
        }
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            RefreshInput refreshInput = RefreshInput.builder().addSegment(segment).build();
        ) {
 *
        );
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
            null,
     * deleteFiles ignores non-lucene format keys.
            null,
        assertEquals(generation, rebuilt.writerGeneration());
                luceneDataFormat,
            assertTrue("Should find segment with generation 1", foundGen1);
            assertEquals(numDocs, resultWfs.numRows());
            null,
            committer.close();
import org.opensearch.plugins.EnginePlugin;
            LuceneDocumentInput input = new LuceneDocumentInput();
        LuceneWriter writer2 = (LuceneWriter) engine.createWriter(config2);
            // Build segments and refresh with both
        int numDocs = randomIntBetween(1, 20);
                WriterFileSet wfs = seg.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);
            .build();
            input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
        Object value = field.get(null);
            store
            store.close();
            committer,
        );
import java.io.IOException;
    }
            Segment resultSegment = result.refreshedSegments().get(0);
            FileInfos fileInfos1 = writer1.flush(FlushInput.EMPTY);
        assertNotNull("LOCK_HELD field must be accessible via reflection", value);
        engine.deleteFiles(java.util.Map.of("lucene", java.util.List.of("_0.cfs", "_0.cfe")));
     */
            store
    }
            writer1.close();
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
            store
            null,
            luceneDataFormat,
     */
        store = new Store(
    public void testRefreshRebuildsExistingSegmentsOnlyWhenDeletesApplied() throws IOException {
            .get(LuceneDataFormat.LUCENE_FORMAT_NAME);
     * Validates: Requirements 2.3
            Segment segment2 = Segment.builder(gen2).addSearchableFiles(luceneDataFormat, wfs2).build();
            store
            RefreshInput refreshInput = RefreshInput.builder().addSegment(segment).build();
            assertFalse(resultWfs.files().isEmpty());
        assertTrue("LOCK_HELD must be a Set<String>", value instanceof java.util.Set);
    @Override
                assertEquals(store.shardPath().resolveIndex().toString(), wfs.directory());
                ConcurrentHashMap.newKeySet(),
 * this file be licensed under the Apache-2.0 license or a
            WriterFileSet wfs = fileInfos.getWriterFileSet(luceneDataFormat).get();
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
                writer1.addDoc(input);
        writer1.close();
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
            WriterFileSet wfs = fileInfos.getWriterFileSet(luceneDataFormat).get();
     * deleteFiles is a no-op for Lucene format — Lucene's internal IndexFileDeleter
    }
            RefreshResult initial = engine.refresh(
import org.apache.lucene.index.IndexWriter;
            assertEquals(numDocs, writer.getDocStats().numDocs);
            WriterFileSet resultWfs = resultSegment.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);
        int numDocs = randomIntBetween(3, 15);
     * Refresh with null input returns empty result.
            for (int i = 0; i < numDocs; i++) {
            assertEquals(store.shardPath().resolveIndex().toString(), resultWfs.directory());
        CommitterConfig settings = new CommitterConfig(engineConfig, () -> {});
        // Create writer through the engine
        return new LuceneCommitter(settings);
                luceneWriter.addDoc(input);
            null,
        WriterFileSet writerFileSet = WriterFileSet.builder().directory(parquetDir).writerGeneration(1L).addNumRows(1).build();
        Files.createDirectories(dataPath);
     * Use engine.createWriter() to create a writer, add docs, flush, build segment,
import org.opensearch.common.settings.Settings;
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
        RefreshResult result = engine.refresh(emptyInput);
            () -> new RetentionLeases(0, 0, Collections.emptyList()),
            committer,
        engine.deleteFiles(java.util.Map.of("parquet", java.util.List.of("_0.parquet")));
        IndexWriter writer = committer.getIndexWriter();
        // because close() deletes the temp directory that refresh needs to read.
        RefreshResult result = engine.refresh(null);
            null,
            input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            mapperService,
        mapperService = createMockMapperService();
        RefreshInput refreshInput = RefreshInput.builder().addSegment(segment).build();
            input.addField(textField, "doc " + i);
import org.opensearch.index.engine.dataformat.FileInfos;
     */
        WriterConfig config1 = new WriterConfig(1L);
            for (int i = 0; i < numDocs2; i++) {
        );
import java.util.Collections;
        assertTrue(java.util.Set.of(directory.listAll()).contains("_0.cfe"));
        MappedFieldType textField = mockTextField("content");
            TimeValue.timeValueMinutes(5),
            mapperService.getIndexSettings(),
     * changed), this test fails during CI — signalling that clearStaleLocks needs updating.
            .dfGroupedSearchableFiles()
import org.opensearch.index.translog.TranslogConfig;
        } finally {
import java.util.concurrent.ConcurrentHashMap;
            assertFalse("Result should have file names", resultWfs.files().isEmpty());
        );
                input.addField(keywordField, "tag_" + i);
     * Property 1: refresh incorporates Lucene segments when parent writer is present.
import static org.mockito.Mockito.mock;
        LuceneWriter writer2 = (LuceneWriter) engine.createWriter(new WriterConfig(gen2));
        long gen1 = 1L;
import static org.mockito.Mockito.when;
     */
import java.nio.file.Files;
        assertEquals(0, committer.getIndexWriter().getDocStats().numDocs);
    }
            RefreshResult result = engine.refresh(refreshInput);
        super.setUp();
     */
            LuceneDocumentInput input = new LuceneDocumentInput();
        );
            .get(0)
            indexSettings,
        Path dataPath = baseDir.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));
            )
            new TranslogConfig(shardId, translogPath, indexSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false),
        assertEquals("All writers closed, heap should be 0", 0L, engine.getHeapBytesUsed());
            WriterFileSet flushed = luceneWriter.flush(FlushInput.EMPTY).getWriterFileSet(luceneDataFormat).get();
        try (
import org.opensearch.index.translog.Translog;
            // Verify result has 2 segments with correct generations
            mapperService,
    /**
     * segments have correct file names from the shared directory.
                RefreshInput.builder().addSegment(Segment.builder(generation).addSearchableFiles(luceneDataFormat, flushed).build()).build()
        MapperService ms = mock(MapperService.class);
     * deleteFiles removes lucene-format files from the store directory.
            committer,
        // Create writers through the engine — do NOT close them before refresh,
        return ms;
import org.opensearch.index.mapper.MapperService;
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
import org.opensearch.index.engine.dataformat.FlushInput;
        java.nio.file.Files.createDirectories(translogPath);
        assertEquals(0, sharedWriter.getDocStats().numDocs);
        when(ms.indexAnalyzer()).thenReturn(new MockAnalyzer(random()));
        assertEquals("No writers yet, heap should be 0", 0L, engine.getHeapBytesUsed());
import org.opensearch.core.index.shard.ShardId;
            writer.close();
            // Verify result segments have correct file names from the shared directory
import org.opensearch.be.lucene.LucenePlugin;
    @SuppressForbidden(reason = "Test verifies reflection used by clearStaleLocks is compatible with current Lucene")
    @Override
 */
        MappedFieldType textField = mockTextField("content");
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
            () -> Boolean.TRUE,
        for (int i = 0; i < 3; i++) {
            false,
            boolean foundGen1 = false;
            mapperService.getIndexSettings(),
            for (int i = 0; i < 3; i++) {
        assertEquals(writer2.getHeapBytesUsed(), heapAfterClose);
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
public class LuceneIndexingExecutionEngineTests extends LucenePluginBaseTests {
import org.apache.lucene.store.NIOFSDirectory;
import java.util.List;
    private MapperService createMockMapperService() {
        RefreshResult withDeletes = engine.refresh(RefreshInput.builder().existingSegments(List.of(existing)).deletesApplied(true).build());
            new LuceneDataFormat(),
     * carried through untouched and no dropped generation is computed. With a delete applied, every
                input.addField(textField, "writer2 doc " + i);
            committer,
        );
            store
        PluginsService mockPluginsService = mock(PluginsService.class);
}
            input.addField(textField, "doc " + i);
    public void tearDown() throws Exception {
import org.opensearch.index.engine.dataformat.RefreshResult;
            null,
                LuceneDocumentInput input = engine.newDocumentInput();
        long generation = 1L;
            mapperService,
        assertEquals("Non-lucene directories should be skipped", 0, writer.getDocStats().numDocs);
    public void testRefreshSkipsNonLuceneDirectories() throws IOException {
import org.opensearch.index.shard.ShardPath;
import org.opensearch.plugins.PluginsService;
                input.addField(textField, "content value " + i);
            assertNotNull("Result segment should have lucene files", resultWfs);
            mapperService,
            assertNotNull(resultWfs);
 * The OpenSearch Contributors require contributions made to
            new MockAnalyzer(random()),
            null,
            mapperService,
            totalHeap
        for (int i = 0; i < 5; i++) {
 */
            WriterFileSet wfs2 = fileInfos2.getWriterFileSet(luceneDataFormat).get();
        store.createEmpty(org.apache.lucene.util.Version.LATEST, translogUUID);
            assertEquals(numDocs, sharedWriter.getDocStats().numDocs);
        }
        when(mockPluginsService.filterPlugins(EnginePlugin.class)).thenReturn(List.of(new LucenePlugin()));
    /**
            assertTrue("Should find segment with generation 2", foundGen2);
import org.opensearch.common.SuppressForbidden;
     * Asserts that reflection access to NativeFSLockFactory.LOCK_HELD works with the
            assertFalse(result.refreshedSegments().isEmpty());
     * The delete gate: with no delete applied, an already-published generation's catalog entry is
import org.opensearch.test.IndexSettingsModule;
            committer,
    }
            luceneDataFormat,
     * deleteFiles is a no-op — Lucene's internal IndexFileDeleter handles segment file cleanup.
import org.opensearch.index.IndexSettings;
import java.nio.file.Path;
            new CodecService(null, indexSettings, LogManager.getLogger(getClass()), List.of()),
            // Verify shared writer has all docs
        );
                null,
            for (int i = 0; i < numDocs1; i++) {
        long generation = 1L;
                    assertEquals(numDocs2, wfs.numRows());
            // The directory should be the shared writer's directory (store index path)
            mapperService.getIndexSettings(),
            new DummyShardLock(shardId),
    }
        } finally {
            MappedFieldType textField = mockTextField("content");
        expectThrows(IllegalArgumentException.class, () -> new LuceneIndexingExecutionEngine(null, null, null, null, null));
import org.opensearch.index.engine.dataformat.Writer;
 * SPDX-License-Identifier: Apache-2.0
            Segment segment = Segment.builder(generation).addSearchableFiles(luceneDataFormat, wfs).build();
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
            // Verify the result has segments with actual file names from the shared directory
        // Use LuceneWriter to create segments (which sets the writer_generation attribute via LuceneWriterCodec)
import org.opensearch.index.engine.exec.WriterFileSet;
            assertNotNull(result);
            committer,
            }
            RefreshResult result = engine.refresh(refreshInput);
            mapperService,
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
 * Tests for {@link LuceneIndexingExecutionEngine}.
        );
                Codec.getDefault(),
     */
                null,
        assertTrue("Heap should decrease after closing a writer", heapAfterClose < totalHeap);
            Segment resultSegment = result.refreshedSegments().get(0);
     */
     * Verify the shared writer has all docs and the result has 2 segments with correct generations.
        try {
import org.opensearch.index.engine.exec.Segment;
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
/**
            RefreshResult result = engine.refresh(refreshInput);
            for (int i = 0; i < numDocs; i++) {
        ShardId shardId = new ShardId("test", "_na_", 0);
        assertTrue(java.util.Set.of(directory.listAll()).contains("_0.cfs"));
            shardPath
        java.lang.reflect.Field field = org.apache.lucene.store.NativeFSLockFactory.class.getDeclaredField("LOCK_HELD");
        org.apache.lucene.store.Directory directory = store.directory();
        WriterFileSet publishedFiles = published.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);
        MappedFieldType keywordField = mockKeywordField("tag");
            WriterFileSet wfs1 = fileInfos1.getWriterFileSet(luceneDataFormat).get();
            luceneDataFormat,
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
    }
    private Store store;
            committer,
    /**
     * Constructor with null committer throws IllegalArgumentException.
        Files.createDirectories(parquetDir);
package org.opensearch.be.lucene.index;
            null,
        assertFalse("delete refresh must rebuild the entry from the reader", rebuilt.files().contains("carried-through.marker"));
        long heapAfterClose = engine.getHeapBytesUsed();
            assertEquals(2, result.refreshedSegments().size());
            store
        // Add docs to both writers
            mapperService.getIndexSettings(),
        }
                new LuceneShardStatsTracker()
    }
            store
            null,
import org.opensearch.common.util.BigArrays;
            LuceneWriter luceneWriter = new LuceneWriter(
            new LuceneDataFormat(),
import org.apache.lucene.codecs.Codec;
    public void testConstructorWithNullCommitterThrows() {
        Path parquetDir = createTempDir().resolve("parquet");
        );
        try {
            shardId,
import org.opensearch.index.engine.EngineConfigFactory;
            .writerGeneration(publishedFiles.writerGeneration())
            .addNumRows(publishedFiles.numRows())
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
            null,
        // Create writers via engine.createWriter to use the engine's internal activeWriters set
            FileInfos fileInfos2 = writer2.flush(FlushInput.EMPTY);
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
            }
        int numDocs2 = randomIntBetween(3, 10);
            writer1.addDoc(input);
            store,
        LuceneWriter writer1 = (LuceneWriter) engine.createWriter(config1);
        // Tag the published entry with a name the reader can never produce, so a carried-through
     */
            null,
        super.tearDown();
import org.opensearch.index.engine.EngineConfig;
            luceneDataFormat,
        Segment published;
                null,
            LuceneWriter luceneWriter = new LuceneWriter(
     * Refresh with no files skips addIndexes.
                    foundGen1 = true;
        Segment existing = Segment.builder(generation).addSearchableFiles(luceneDataFormat, tagged).build();
        Path translogPath = dataPath.resolve("translog");
                createTempDir(),
     * live generation's file set is rebuilt from the reader so new {@code .liv} files are cataloged.
            indexSettings,
import org.opensearch.common.unit.TimeValue;
        Path tempBase = createTempDir();
            mapperService.getIndexSettings(),
    public void testGetHeapBytesUsedSumsActiveWriters() throws IOException {
                input.addField(textField, "doc_" + i);
            null,
        );
    }
                input.addField(textField, "doc_" + i);
        writer2.close();
        assertNotNull(result);
        MappedFieldType textField = mockTextField("content");
            null,
    }
import org.opensearch.index.mapper.MappedFieldType;
            )
        IndexWriter sharedWriter = committer.getIndexWriter();
            Segment segment1 = Segment.builder(gen1).addSearchableFiles(luceneDataFormat, wfs1).build();
        if (store != null) {
        assertTrue("nothing was actually deleted, so no generation is dropped", withDeletes.droppedGenerations().isEmpty());
        long gen2 = 2L;
            // Build a Segment from the FileInfos
    public void testDeleteFilesIgnoresNonLuceneFormat() throws IOException {
                generation,
            null,
        directory.createOutput("_0.cfs", org.apache.lucene.store.IOContext.DEFAULT).close();
    public void testNativeFSLockFactoryLockHeldFieldAccessible() throws Exception {
        field.setAccessible(true);
            null,
        // entry is distinguishable from one rebuilt out of the reader's leaves.
                writer2.addDoc(input);
            assertEquals(generation, resultWfs.writerGeneration());
        engine.refresh(refreshInput);
            // Build segment and refresh
            .addFiles(publishedFiles.files())
            mapperService,
        EngineConfig engineConfig = new EngineConfigFactory(mockPluginsService, indexSettings).newEngineConfig(
                LuceneDocumentInput input = engine.newDocumentInput();
        }
                }
            null,
     */
            }
        int numDocs1 = randomIntBetween(3, 10);
            assertEquals(generation, resultWfs.writerGeneration());
        // Close writer1 — engine heap should decrease
     */
        LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
/*
                input.setRowId(LuceneDocumentInput.ROW_ID_FIELD, i);
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
import org.opensearch.index.codec.CodecService;
        );
            }
            committer,
            committer,
        try (
import org.apache.logging.log4j.LogManager;
            mapperService.getIndexSettings(),
            writer2.addDoc(input);
                null,
    public void testRefreshWithNullInputReturnsEmpty() throws IOException {
        directory.createOutput("_0.cfe", org.apache.lucene.store.IOContext.DEFAULT).close();
import org.opensearch.index.translog.InternalTranslogFactory;
        WriterFileSet tagged = WriterFileSet.builder()
    /**
     * current Lucene version. If Lucene changes this field (renamed, removed, or type
     */
        shardPath = new ShardPath(false, dataPath, dataPath, shardId);
            luceneDataFormat,
        assertTrue("no-delete refresh must carry the existing entry verbatim", carried.files().contains("carried-through.marker"));
            luceneDataFormat,
                luceneWriter.addDoc(input);
        IndexWriter writer = committer.getIndexWriter();
    private LuceneCommitter createCommitter() throws IOException {
    }
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
            RefreshInput refreshInput = RefreshInput.builder().addSegment(segment1).addSegment(segment2).build();
            luceneDataFormat,
    private ShardPath shardPath;
                0L,
            mapperService.getIndexSettings(),
import org.opensearch.index.engine.dataformat.RefreshInput;
            }
    /**
        assertTrue(result.refreshedSegments().isEmpty());
                    foundGen2 = true;
        assertTrue("Engine heap should be > 0 with active writers", totalHeap > 0);
    /**
            );
        committer = createCommitter();
                } else if (wfs.writerGeneration() == gen2) {
    public void testMultipleWriterRefreshAccumulatesInSharedWriter() throws IOException {
            mapperService.getIndexSettings(),
        // Create a segment directory that looks like it has files but is keyed under "parquet"
    public void setUp() throws Exception {
