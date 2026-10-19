        }
 *
    }
import static org.mockito.Mockito.when;
                indexSettings,
            Path dataPath = tempDir.resolve(indexUUID).resolve("0");
            nativeAllocator.close();  
        engine = createEngine();
                shardPath,
        schema = buildSchema(List.of(idField, nameField, scoreField));
        nameField = createKeywordField("name");
        for (MappedFieldType ft : fieldTypes) {  
                settings,
    }
            doc.addField(idField, i);  
    private MappedFieldType nameField;
        MapperService mapperService = mock(MapperService.class);
        }
        terminate(threadPool);
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.opensearch.index.shard.ShardPath;
import org.opensearch.Version;  
import java.nio.file.Files;  
            populateMetadataFields(doc);
            IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
 */  
        for (int i = 0; i < 5; i++) {  
        RustBridge.initLogger();
    @Override
    private Schema schema;  
                () -> ParquetSettings.getLowCardinalityEnabledFields(mapperService),
            writer.flush(FlushInput.EMPTY);  
    public void testRefreshReturnsEmptyResult() throws Exception {
        List<Field> fields = new ArrayList<>();
import org.opensearch.index.engine.dataformat.Writer;
import static org.mockito.Mockito.mock;  
    }
import org.opensearch.parquet.writer.ParquetDocumentInput;
                .build();  
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
import org.opensearch.index.engine.dataformat.WriterConfig;  
    }
        try {
        assertTrue(Files.exists(luceneFile));
        Files.createFile(luceneFile);
        for (long gen = 1; gen <= 3; gen++) {  
        assertTrue(engine.refresh(RefreshInput.builder().build()).refreshedSegments().isEmpty());
import org.apache.arrow.vector.types.pojo.Field;
    }  
            assertNotNull("No ParquetField registered for type: " + ft.typeName(), pf);
        RefreshResult result = engine.refresh(null);
    public void testRefreshWithNullInput() throws Exception {
        super.tearDown();  
        assertEquals("parquet", engine.getDataFormat().name());
        assertNotNull(doc);
            doc.addField(idField, (int) gen);
 * The OpenSearch Contributors require contributions made to  
                ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME,
            doc.addField(scoreField, gen * 100);  
            .toString();
        assertTrue(Files.exists(Path.of(expectedFile)));
            doc.setRowId("__row_id__", 0L);
        assertTrue(Files.exists(luceneFile));  
            // documentMapper, so going through ArrowSchemaBuilder would yield only metadata
            doc.close();
        Settings settings = Settings.builder().put("node.name", "parquetengine-test").build();  
 * this file be licensed under the Apache-2.0 license or a
            doc.setRowId("__row_id__", i);  
        return new Schema(fields);  
import org.opensearch.threadpool.FixedExecutorBuilder;  
import org.opensearch.parquet.fields.ArrowFieldRegistry;  
 * compatible open source license.
    @Override
import org.opensearch.parquet.ParquetSettings;
            ParquetDocumentInput doc = engine.newDocumentInput();
    }
            );
    private String getExpectedParquetPath(long generation) {
                () -> mapperService.getIndexSettings().getIndexMetadata().getMappingVersion(),  
        fields.addAll(metadataFields());
            doc.close();
                -1,
        assertEquals(FileInfos.empty(), writer.flush(FlushInput.EMPTY));
            ParquetDocumentInput doc = engine.newDocumentInput();
import org.opensearch.parquet.fields.ParquetField;
}  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testCreateWriterAndFlush() throws Exception {  
        super.setUp();
            settings,
        when(mapperService.documentMapper()).thenReturn(null);
            writer.addDoc(doc);
        idField = createNumberField("id", NumberFieldMapper.NumberType.INTEGER);  
        assertEquals(5, RustBridge.getFileMetadata(expectedFile).numRows());
    private ParquetIndexingEngine engine;
    public void testGetDataFormat() {
import org.opensearch.index.engine.dataformat.RefreshResult;
import org.opensearch.index.IndexSettings;  
            Settings indexSettingsBuilder = Settings.builder()
    public void testGetMergerReturnsNonNull() {
    }
            .resolve("0")
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            Files.createDirectories(dataPath.resolve("parquet"));  
        expectThrows(UnsupportedOperationException.class, () -> engine.getNextWriterGeneration());  
    private MapperService createMockMapperService(Schema schema, IndexSettings indexSettings) {  
    }  
        writer.flush(FlushInput.EMPTY);
            IndexMetadata indexMetadata = IndexMetadata.builder("test_index").settings(indexSettingsBuilder).build();
import java.util.List;  
        Files.createFile(parquetFile);
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_INGEST, 0L, Long.MAX_VALUE, null);
        scoreField = createNumberField("score", NumberFieldMapper.NumberType.LONG);
            doc.addField(nameField, "user_" + gen);
        }  
        Path luceneFile = tempDir.resolve("test_lucene");
            doc.addField(scoreField, (long) (i * 100));
package org.opensearch.parquet.engine;
        threadPool = new ThreadPool(
        nativeAllocator = new ArrowNativeAllocator();  
        ParquetDocumentInput doc = engine.newDocumentInput();  
        return mapperService;
        Path parquetFile = tempDir.resolve("test.parquet");
        assertEquals(4, doc.getFinalInput().size());
    public void testMultipleWriterGenerations() throws Exception {
    }
    public void testFlushWithNoDocumentsReturnsEmpty() throws Exception {
            doc.addField(nameField, "user_" + i);
        populateMetadataFields(doc);
            assertEquals(1, RustBridge.getFileMetadata(getExpectedParquetPath(gen)).numRows());
            populateMetadataFields(doc);  
        assertNotNull(engine.getMerger());
import org.opensearch.parquet.ParquetBaseTests;
    public void setUp() throws Exception {  
    private ArrowNativeAllocator nativeAllocator;
    }  
    private ThreadPool threadPool;  
    public void testGetNextWriterGenerationThrows() {
        if (nativeAllocator != null) {
        }
                Settings.EMPTY,
            // Use the test's pre-built schema directly. The mock MapperService has no
import org.opensearch.core.index.shard.ShardId;
    private MappedFieldType scoreField;
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
    public void testNewDocumentInput() {
    }
                1,  
        engine.deleteFiles(Map.of("parquet", List.of(parquetFile.toString())));
import org.opensearch.index.mapper.MapperService;
import java.nio.file.Path;
            String indexUUID = "test_index_uuid";  
            // Each writer is fresh — rowIds restart at 0 within a writer's lifetime.
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);  
                threadPool,  
        doc.setRowId("__row_id__", 0);  
            .resolve(ParquetIndexingEngine.FILE_NAME_PREFIX + "_" + generation + ParquetIndexingEngine.FILE_NAME_EXT)  
    }
        assertNotNull(result);  
        Writer<ParquetDocumentInput> writer = engine.createWriter(new WriterConfig(1L));  
import org.opensearch.parquet.ParquetDataFormatPlugin;  
        assertTrue(Files.exists(parquetFile));  
        tempDir = createTempDir();
    }  
            .resolve("parquet")
import org.opensearch.parquet.bridge.RustBridge;
    }
import java.util.ArrayList;
                "thread_pool." + ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME
        }
        } catch (Exception e) {  
import org.opensearch.common.settings.Settings;
            Writer<ParquetDocumentInput> writer = engine.createWriter(new WriterConfig(gen));
public class ParquetIndexingEngineTests extends ParquetBaseTests {  
                () -> schema,
import org.opensearch.index.mapper.NumberFieldMapper;  
    private Schema buildSchema(List<MappedFieldType> fieldTypes) {
import java.util.Map;
        Writer<ParquetDocumentInput> writer = engine.createWriter(new WriterConfig(1L));
    private MappedFieldType idField;  
    }  
 * SPDX-License-Identifier: Apache-2.0
            MapperService mapperService = createMockMapperService(schema, indexSettings);  
            throw new RuntimeException(e);
    private Path tempDir;
            nativeAllocator = null;
        return tempDir.resolve("test_index_uuid")  
        assertNotNull(engine.refresh(RefreshInput.builder().build()));  
    public void testDeleteFiles() throws Exception {  
        assertTrue(result.refreshedSegments().isEmpty());
            return new ParquetIndexingEngine(
import org.opensearch.index.mapper.MappedFieldType;
    }  
import org.opensearch.threadpool.ThreadPool;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
/*  
import org.opensearch.index.engine.dataformat.FileInfos;
            )  
                nativeAllocator
    public void testDeleteFilesIgnoresUnrelatedFormats() throws Exception {  
import org.opensearch.index.engine.dataformat.FlushInput;
            ParquetField pf = ArrowFieldRegistry.getParquetField(ft.typeName());
    }  
        String expectedFile = getExpectedParquetPath(1L);  
    public void tearDown() throws Exception {  
        engine.deleteFiles(Map.of("lucene", List.of("test_lucene")));
        );
        assertFalse(Files.exists(parquetFile));  
            fields.add(new Field(ft.name(), pf.getFieldType(), null));  
            new FixedExecutorBuilder(  
import org.apache.arrow.vector.types.pojo.Schema;
            ShardPath shardPath = new ShardPath(false, dataPath, dataPath, shardId);
            ShardId shardId = new ShardId("test_index", indexUUID, 0);
            writer.addDoc(doc);
import org.opensearch.index.engine.dataformat.RefreshInput;  
    private ParquetIndexingEngine createEngine() {
                new ParquetDataFormat(),  
            // fields and addDocument would reject id/name/score with MismatchedInputException.  
