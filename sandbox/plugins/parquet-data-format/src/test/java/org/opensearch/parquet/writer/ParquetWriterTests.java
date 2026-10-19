            fields.add(new Field(ft.name(), pf.getFieldType(), null));
        doc.close();
            threadPool,
        assignTestCapabilities(nameField, parquetFormat);
import org.apache.arrow.memory.OutOfMemoryException;
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);
import java.util.ArrayList;  
import org.opensearch.parquet.fields.ParquetField;
    public void testFlushWithNoDocuments() throws Exception {  
    private Schema buildSchema(List<MappedFieldType> fieldTypes) {
        Settings settings = Settings.builder().put("node.name", "parquetwriter-test").build();  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
import org.apache.arrow.vector.types.pojo.Field;
import java.util.List;
            filePath,  
 *
        String filePath = createTempDir().resolve("oom.parquet").toString();
            () -> promotedSchema,
            new ParquetDataFormat(),  
        doc.close();
            writer.addDoc(doc);
            ParquetField pf = ArrowFieldRegistry.getParquetField(ft.typeName());
        );
        assertTrue(Files.exists(Path.of(filePath)));
        String filePath = createTempDir().resolve("schema-fence.parquet").toString();  
import org.opensearch.parquet.engine.ParquetDataFormat;  
    private MappedFieldType nameField;  
        ParquetWriter writer = new ParquetWriter(
        RustBridge.initLogger();  
import org.opensearch.index.engine.dataformat.FlushInput;  
            indexSettings,
            null  
        );
        }
            indexSettings,
            threadPool,
            schema,
    @Override  
        // addDoc must translate the OOM into a Failure result rather than propagating the throw.
        writer.flush(FlushInput.EMPTY);  
        Schema promotedSchema = new Schema(promotedFields);
            bufferPool,  
    }
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.index.mapper.MappedFieldType;
            null  
    }
    public void testMappingTypeChangeRetiresWriterForSchemaFence() throws Exception {
        doc.addField(idField, 1);
            indexSettings,
        assertNotNull(fileInfos);
            bufferPool,  
        for (MappedFieldType ft : fieldTypes) {
            () -> schema,
        String filePath = createTempDir().resolve("single.parquet").toString();
    }
    public void testAddDocReturnsSuccess() throws Exception {  
        doc.addField(idField, 42);
import org.opensearch.common.settings.Settings;
        doc.close();
            schema,
    private final ParquetDataFormat parquetFormat = new ParquetDataFormat();
            nativeAllocator.close();  
        assertTrue("expected a Failure result but was: " + result, result instanceof WriteResult.Failure);
            filePath,  
import org.opensearch.index.IndexSettings;  
            )  
            doc.addField(scoreField, (long) (i * 100));  
        fields.addAll(metadataFields());  
        List<Field> promotedFields = new ArrayList<>();
        doc.addField(scoreField, 100L);
            indexSettings,
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
            1L,
            1L,
        );
        String filePath = createTempDir().resolve("multi.parquet").toString();
        ParquetWriter writer = new ParquetWriter(
        String filePath = createTempDir().resolve("success.parquet").toString();
        doc.addField(idField, 1);  
        }
            new FixedExecutorBuilder(  
            null
        scoreField = new NumberFieldMapper.NumberFieldType("score", NumberFieldMapper.NumberType.LONG);  
    }
        );
        assertTrue(  
        FileInfos fileInfos = writer.flush(FlushInput.EMPTY);  
            "expected an Arrow OutOfMemoryException cause but was: " + failure.cause(),
        ParquetDocumentInput doc = new ParquetDocumentInput();
        WriteResult result = writer.addDoc(doc);  
public class ParquetWriterTests extends ParquetBaseTests {  
 * compatible open source license.
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(indexSettingsBuilder).build();
import org.opensearch.index.mapper.NumberFieldMapper;
    @Override
        List<Field> fields = new ArrayList<>();  
        assertEquals(10, RustBridge.getFileMetadata(filePath).numRows());  
/*  
        super.setUp();
import org.opensearch.parquet.ParquetDataFormatPlugin;
import org.opensearch.index.engine.dataformat.WriterState;
    }
            () -> schema,
        promotedFields.add(ArrowFieldRegistry.getParquetField(idField.typeName()).toArrowField(idField.name(), false));  
            new ParquetDataFormat(),
import org.opensearch.parquet.memory.ArrowBufferPool;  
            nativeAllocator = null;
            doc.close();  
            new ParquetDataFormat(),  
                ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME,
            doc.addField(idField, i);
            new ParquetDataFormat(),  
        );
                -1,
    public void tearDown() throws Exception {
        ParquetDocumentInput doc = new ParquetDocumentInput();  
    private ArrowBufferPool bufferPool;
        populateMetadataFields(doc);
            bufferPool,
    public void testMultipleDocumentsFlush() throws Exception {
            indexSettings,
    }  
            assertNotNull("No ParquetField registered for type: " + ft.typeName(), pf);  
            schema,
        for (int i = 0; i < 10; i++) {
            settings,
import org.opensearch.Version;
        bufferPool.close();
        promotedFields.add(keyword.toArrowField(nameField.name(), true));
            schema,
            threadPool,
            bufferPool,  
            1L,
        assertEquals(FileInfos.empty(), writer.flush(FlushInput.EMPTY));  
        schema = buildSchema(List.of(idField, nameField, scoreField));
        ParquetWriter writer = new ParquetWriter(
        );
            1L,
            new ParquetDataFormat(),  
import org.opensearch.cluster.metadata.IndexMetadata;
        String filePath = createTempDir().resolve("empty.parquet").toString();
        populateMetadataFields(doc);
            doc.addField(nameField, "user_" + i);
import org.opensearch.parquet.ParquetBaseTests;  
    }
    private ThreadPool threadPool;  
import org.apache.arrow.vector.types.pojo.Schema;  
 * this file be licensed under the Apache-2.0 license or a
                settings,
        doc.addField(nameField, "alice");  
        promotedFields.add(ArrowFieldRegistry.getParquetField(scoreField.typeName()).toArrowField(scoreField.name(), false));
            threadPool,
        if (nativeAllocator != null) {
        bufferPool = new ArrowBufferPool(Settings.EMPTY, nativeAllocator);  
        writer.flush(FlushInput.EMPTY);  
package org.opensearch.parquet.writer;
import org.opensearch.parquet.bridge.RustBridge;
    private Schema schema;
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_INGEST, 0L, Long.MAX_VALUE, null);
        doc.addField(nameField, "bob");  
        assertEquals(WriterState.RETIRED_FLUSHABLE, writer.state());
            filePath,  
        ParquetDocumentInput doc = new ParquetDocumentInput();  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            () -> schema,  
            doc.setRowId("__row_id__", i);
        assertTrue(result instanceof WriteResult.Success);
            1L,
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);
    private ArrowNativeAllocator nativeAllocator;  
            indexSettings,
        nativeAllocator = new ArrowNativeAllocator();
        ParquetField keyword = ArrowFieldRegistry.getParquetField(nameField.typeName());
import java.nio.file.Files;
            .build();  
        );
            schema,
        ParquetWriter writer = new ParquetWriter(
        assignTestCapabilities(idField, parquetFormat);
        nameField = new KeywordFieldMapper.KeywordFieldType("name");
            1L,
import org.opensearch.index.mapper.KeywordFieldMapper;  
        ParquetWriter writer = new ParquetWriter(
        return new Schema(fields);
import java.nio.file.Path;
            threadPool,
        );  
import org.opensearch.index.engine.dataformat.DocumentInput;
            populateMetadataFields(doc);  
                1,  
            null  
            1L,
}  
        nativeAllocator.setPoolLimit(NativeAllocatorPoolConfig.POOL_INGEST, Long.MAX_VALUE);
        threadPool = new ThreadPool(
    private IndexSettings indexSettings;
            () -> schema,
            bufferPool,  
        Settings indexSettingsBuilder = Settings.builder()
            null  
 * The OpenSearch Contributors require contributions made to  
        WriteResult result = writer.addDoc(doc);  
            new ParquetDataFormat(),  
        indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
    }  
    private MappedFieldType idField;
            1L,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            filePath,  
            threadPool,  
        writer.addDoc(doc);  
            schema,
import org.opensearch.parquet.fields.ArrowFieldRegistry;
            filePath,  
        // Relieve the limit before teardown so writer/allocator cleanup can proceed cleanly.  
        }
    public void setUp() throws Exception {
        populateMetadataFields(doc);
            ParquetDocumentInput doc = new ParquetDocumentInput();
    public void testSingleDocumentFlush() throws Exception {  
    }
            bufferPool,  
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);  
        idField = new NumberFieldMapper.NumberFieldType("id", NumberFieldMapper.NumberType.INTEGER);
        WriteResult.Failure failure = (WriteResult.Failure) result;
        terminate(threadPool);  
            1L,
        assignTestCapabilities(scoreField, parquetFormat);  
import org.opensearch.index.engine.dataformat.WriteResult;
        doc.addField(scoreField, 500L);
            () -> schema,
import org.opensearch.index.engine.dataformat.FileInfos;
        // Constrain the ingest pool so that allocating Arrow buffers while populating the  
            failure.cause() instanceof OutOfMemoryException
    private MappedFieldType scoreField;
        writer.updateMappingVersion(2L);  
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;  
        nativeAllocator.setPoolLimit(NativeAllocatorPoolConfig.POOL_INGEST, 1L);
            filePath,
            1L,
        ParquetWriter writer = new ParquetWriter(  
                "thread_pool." + ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME
        doc.addField(scoreField, 100L);
        promotedFields.addAll(metadataFields());  
        doc.addField(nameField, "alice");
 */  
    public void testAddDocReturnsFailureOnOutOfMemory() throws Exception {  
import org.opensearch.threadpool.FixedExecutorBuilder;
        assertEquals(FileInfos.empty(), writer.flush(FlushInput.EMPTY));
            1L,  
 * SPDX-License-Identifier: Apache-2.0
        super.tearDown();  
            1L,
        writer.close();
            null  
        assertEquals(1, RustBridge.getFileMetadata(filePath).numRows());
        // VectorSchemaRoot inside VSRManager.addDocument throws an Arrow OutOfMemoryException.
