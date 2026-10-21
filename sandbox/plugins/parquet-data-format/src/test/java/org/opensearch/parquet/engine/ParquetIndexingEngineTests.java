            doc.addField(scoreField, gen * 100);
        } catch (Exception e) {
        assertTrue(Files.exists(Path.of(expectedFile)));
            String indexUUID = "test_index_uuid";
                () -> schema,
        idField = createNumberField("id", NumberFieldMapper.NumberType.INTEGER);
import java.util.ArrayList;
    public void testNewDocumentInput() {
            doc.addField(scoreField, (long) (i * 100));
    public void testFlushWithNoDocumentsReturnsEmpty() throws Exception {
            ParquetDocumentInput doc = engine.newDocumentInput();
        return new Schema(fields);
import java.nio.file.Path;
        terminate(threadPool);
import org.opensearch.index.mapper.NumberFieldMapper;
    public void testRefreshReturnsEmptyResult() throws Exception {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.parquet.ParquetSettings;
            throw new RuntimeException(e);
            .resolve("0")
            doc.addField(idField, (int) gen);
        assertEquals(4, doc.getFinalInput().size());
import org.opensearch.index.shard.ShardPath;
        assertTrue(Files.exists(luceneFile));
        }
        engine = createEngine();
    private ArrowNativeAllocator nativeAllocator;
import org.opensearch.index.engine.dataformat.RefreshInput;
    private Schema schema;
                ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME,
    public void testCreateWriterAndFlush() throws Exception {
                1,
                -1,
import org.opensearch.parquet.fields.ParquetField;
            writer.addDoc(doc);
            return new ParquetIndexingEngine(
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        MapperService mapperService = mock(MapperService.class);
        for (long gen = 1; gen <= 3; gen++) {
                "thread_pool." + ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME
        populateMetadataFields(doc);
    @Override
    }
import org.opensearch.parquet.ParquetBaseTests;
        ParquetDocumentInput doc = engine.newDocumentInput();
public class ParquetIndexingEngineTests extends ParquetBaseTests {
    }
import org.opensearch.threadpool.FixedExecutorBuilder;
            new FixedExecutorBuilder(
            writer.addDoc(doc);
    private String getExpectedParquetPath(long generation) {
import org.opensearch.index.IndexSettings;
 */
        Files.createFile(luceneFile);
    }
 * compatible open source license.
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testGetDataFormat() {
        assertEquals(FileInfos.empty(), writer.flush(FlushInput.EMPTY));
import org.opensearch.index.engine.dataformat.FlushInput;
            fields.add(new Field(ft.name(), pf.getFieldType(), null));
    private MapperService createMockMapperService(Schema schema, IndexSettings indexSettings) {
    @Override
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
            doc.addField(nameField, "user_" + i);
        assertFalse(Files.exists(parquetFile));
            // Use the test's pre-built schema directly. The mock MapperService has no
    }
            nativeAllocator = null;
        super.tearDown();
                () -> mapperService.getIndexSettings().getIndexMetadata().getMappingVersion(),
 * this file be licensed under the Apache-2.0 license or a
    }
        assertTrue(result.refreshedSegments().isEmpty());
            doc.addField(nameField, "user_" + gen);
        assertNotNull(doc);
        tempDir = createTempDir();
/*
    private ParquetIndexingEngine createEngine() {
            doc.addField(idField, i);
        schema = buildSchema(List.of(idField, nameField, scoreField));
        engine.deleteFiles(Map.of("lucene", List.of("test_lucene")));
    private ThreadPool threadPool;
    }
import java.nio.file.Files;
    public void testMultipleWriterGenerations() throws Exception {
        RefreshResult result = engine.refresh(null);
    }
package org.opensearch.parquet.engine;
            Settings indexSettingsBuilder = Settings.builder()
import org.apache.arrow.vector.types.pojo.Field;
import static org.mockito.Mockito.mock;
            )
import java.util.Map;
            // documentMapper, so going through ArrowSchemaBuilder would yield only metadata
            ShardPath shardPath = new ShardPath(false, dataPath, dataPath, shardId);
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.parquet.bridge.RustBridge;
import org.opensearch.common.settings.Settings;
        when(mapperService.documentMapper()).thenReturn(null);
        nativeAllocator = new ArrowNativeAllocator();
        writer.flush(FlushInput.EMPTY);
        scoreField = createNumberField("score", NumberFieldMapper.NumberType.LONG);
        String expectedFile = getExpectedParquetPath(1L);
    public void testGetMergerReturnsNonNull() {
    }
            .toString();
    private MappedFieldType scoreField;
            nativeAllocator.close();
            // Each writer is fresh — rowIds restart at 0 within a writer's lifetime.
            ParquetDocumentInput doc = engine.newDocumentInput();
            IndexMetadata indexMetadata = IndexMetadata.builder("test_index").settings(indexSettingsBuilder).build();
        for (int i = 0; i < 5; i++) {
            .resolve(ParquetIndexingEngine.FILE_NAME_PREFIX + "_" + generation + ParquetIndexingEngine.FILE_NAME_EXT)
        }
        List<Field> fields = new ArrayList<>();
            .resolve("parquet")
            ParquetField pf = ArrowFieldRegistry.getParquetField(ft.typeName());
        return mapperService;
    public void testGetNextWriterGenerationThrows() {
        Files.createFile(parquetFile);
        assertNotNull(engine.refresh(RefreshInput.builder().build()));
    }
import org.opensearch.index.engine.dataformat.Writer;
                .build();
import org.opensearch.Version;
        RustBridge.initLogger();
        threadPool = new ThreadPool(
    }
    }
    public void setUp() throws Exception {
            IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        fields.addAll(metadataFields());
    }
    public void testDeleteFilesIgnoresUnrelatedFormats() throws Exception {
import org.opensearch.parquet.writer.ParquetDocumentInput;
import org.opensearch.index.engine.dataformat.WriterConfig;
        if (nativeAllocator != null) {
import org.opensearch.parquet.ParquetDataFormatPlugin;
        }
                threadPool,
        Writer<ParquetDocumentInput> writer = engine.createWriter(new WriterConfig(1L));
        assertNotNull(engine.getMerger());
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_INGEST, 0L, Long.MAX_VALUE, null);
    public void tearDown() throws Exception {
    }
import static org.mockito.Mockito.when;
                new ParquetDataFormat(),
            );
            // fields and addDocument would reject id/name/score with MismatchedInputException.
    private ParquetIndexingEngine engine;
        expectThrows(UnsupportedOperationException.class, () -> engine.getNextWriterGeneration());
        Settings settings = Settings.builder().put("node.name", "parquetengine-test").build();
            Path dataPath = tempDir.resolve(indexUUID).resolve("0");
        }
import org.opensearch.core.index.shard.ShardId;
        Path luceneFile = tempDir.resolve("test_lucene");
        super.setUp();
    }
import org.opensearch.parquet.fields.ArrowFieldRegistry;
            doc.close();
            MapperService mapperService = createMockMapperService(schema, indexSettings);
    private Schema buildSchema(List<MappedFieldType> fieldTypes) {
import org.opensearch.cluster.metadata.IndexMetadata;
        assertTrue(Files.exists(parquetFile));
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.index.engine.dataformat.FileInfos;
            ShardId shardId = new ShardId("test_index", indexUUID, 0);
            doc.setRowId("__row_id__", 0L);
        assertTrue(engine.refresh(RefreshInput.builder().build()).refreshedSegments().isEmpty());
            doc.setRowId("__row_id__", i);
        );
        }
                indexSettings,
    private MappedFieldType idField;
import java.util.List;
            assertEquals(1, RustBridge.getFileMetadata(getExpectedParquetPath(gen)).numRows());
        return tempDir.resolve("test_index_uuid")
            doc.close();
        engine.deleteFiles(Map.of("parquet", List.of(parquetFile.toString())));
        nameField = createKeywordField("name");
                shardPath,
    public void testRefreshWithNullInput() throws Exception {
            settings,
            populateMetadataFields(doc);
import org.apache.arrow.vector.types.pojo.Schema;
        doc.setRowId("__row_id__", 0);
        Writer<ParquetDocumentInput> writer = engine.createWriter(new WriterConfig(1L));
}
            Writer<ParquetDocumentInput> writer = engine.createWriter(new WriterConfig(gen));
 *
        assertTrue(Files.exists(luceneFile));
                nativeAllocator
    public void testDeleteFiles() throws Exception {
                Settings.EMPTY,
                () -> ParquetSettings.getLowCardinalityEnabledFields(mapperService),
            assertNotNull("No ParquetField registered for type: " + ft.typeName(), pf);
    private Path tempDir;
            writer.flush(FlushInput.EMPTY);
                settings,
import org.opensearch.index.mapper.MapperService;
    }
        for (MappedFieldType ft : fieldTypes) {
        try {
        assertEquals("parquet", engine.getDataFormat().name());
    }
            populateMetadataFields(doc);
import org.opensearch.index.engine.dataformat.RefreshResult;
        assertNotNull(result);
 * The OpenSearch Contributors require contributions made to
        Path parquetFile = tempDir.resolve("test.parquet");
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
    private MappedFieldType nameField;
            Files.createDirectories(dataPath.resolve("parquet"));
        assertEquals(5, RustBridge.getFileMetadata(expectedFile).numRows());
