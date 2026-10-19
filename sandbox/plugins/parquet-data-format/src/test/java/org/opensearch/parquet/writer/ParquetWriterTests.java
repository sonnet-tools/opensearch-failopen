            schema,
        terminate(threadPool);
            1L,
    private IndexSettings indexSettings;
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);
            new ParquetDataFormat(),
        // Relieve the limit before teardown so writer/allocator cleanup can proceed cleanly.
            bufferPool,
        ParquetWriter writer = new ParquetWriter(
import org.apache.arrow.memory.OutOfMemoryException;
        WriteResult result = writer.addDoc(doc);
            () -> schema,
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(indexSettingsBuilder).build();
                ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME,
            () -> promotedSchema,
    }
        for (int i = 0; i < 10; i++) {
            doc.setRowId("__row_id__", i);
        doc.addField(nameField, "bob");
            new ParquetDataFormat(),
            indexSettings,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            threadPool,
            ParquetDocumentInput doc = new ParquetDocumentInput();
    }
            "expected an Arrow OutOfMemoryException cause but was: " + failure.cause(),
            1L,
        // Constrain the ingest pool so that allocating Arrow buffers while populating the
    private ArrowNativeAllocator nativeAllocator;
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        assertNotNull(fileInfos);
                1,
        );
        }
import org.opensearch.index.engine.dataformat.DocumentInput;
        super.setUp();
        );
            new ParquetDataFormat(),
        );
        assertEquals(FileInfos.empty(), writer.flush(FlushInput.EMPTY));
import org.opensearch.parquet.memory.ArrowBufferPool;
import org.opensearch.index.engine.dataformat.WriterState;
        promotedFields.addAll(metadataFields());
            indexSettings,
import org.opensearch.index.engine.dataformat.FlushInput;
        super.tearDown();
        threadPool = new ThreadPool(
import org.opensearch.cluster.metadata.IndexMetadata;
        }
            bufferPool,
}
            .build();
    public void testAddDocReturnsSuccess() throws Exception {
    private MappedFieldType scoreField;
        doc.addField(scoreField, 100L);
            settings,
            1L,
        String filePath = createTempDir().resolve("schema-fence.parquet").toString();
    }
            indexSettings,
    }
        List<Field> fields = new ArrayList<>();
        nativeAllocator.setPoolLimit(NativeAllocatorPoolConfig.POOL_INGEST, 1L);
            null
        Settings indexSettingsBuilder = Settings.builder()
        ParquetField keyword = ArrowFieldRegistry.getParquetField(nameField.typeName());
            new FixedExecutorBuilder(
import org.opensearch.parquet.engine.ParquetDataFormat;
        doc.addField(idField, 1);
    private ThreadPool threadPool;
        idField = new NumberFieldMapper.NumberFieldType("id", NumberFieldMapper.NumberType.INTEGER);
        doc.addField(idField, 42);
        populateMetadataFields(doc);
        doc.addField(nameField, "alice");
        writer.flush(FlushInput.EMPTY);
import org.opensearch.index.mapper.NumberFieldMapper;
            indexSettings,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            threadPool,
        String filePath = createTempDir().resolve("oom.parquet").toString();
            filePath,
    public void testAddDocReturnsFailureOnOutOfMemory() throws Exception {
        WriteResult.Failure failure = (WriteResult.Failure) result;
    public void testMultipleDocumentsFlush() throws Exception {
        writer.flush(FlushInput.EMPTY);
        bufferPool.close();
import org.opensearch.parquet.ParquetDataFormatPlugin;
        assertEquals(WriterState.RETIRED_FLUSHABLE, writer.state());
import java.util.ArrayList;
            null
 * compatible open source license.
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);
            bufferPool,
        assignTestCapabilities(scoreField, parquetFormat);
            failure.cause() instanceof OutOfMemoryException
    private MappedFieldType idField;
            null
        );
            new ParquetDataFormat(),
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
        Settings settings = Settings.builder().put("node.name", "parquetwriter-test").build();
        ParquetWriter writer = new ParquetWriter(
        fields.addAll(metadataFields());
        nameField = new KeywordFieldMapper.KeywordFieldType("name");
import org.opensearch.index.mapper.MappedFieldType;
        writer.close();
            null
        String filePath = createTempDir().resolve("single.parquet").toString();
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
            filePath,
        ParquetWriter writer = new ParquetWriter(
        assertTrue(Files.exists(Path.of(filePath)));
            bufferPool,
            doc.close();
            ParquetField pf = ArrowFieldRegistry.getParquetField(ft.typeName());
        nativeAllocator.setPoolLimit(NativeAllocatorPoolConfig.POOL_INGEST, Long.MAX_VALUE);
        promotedFields.add(ArrowFieldRegistry.getParquetField(idField.typeName()).toArrowField(idField.name(), false));
    private final ParquetDataFormat parquetFormat = new ParquetDataFormat();
import org.opensearch.threadpool.ThreadPool;
            1L,
import org.opensearch.index.engine.dataformat.WriteResult;
            null
package org.opensearch.parquet.writer;
        promotedFields.add(ArrowFieldRegistry.getParquetField(scoreField.typeName()).toArrowField(scoreField.name(), false));
            nativeAllocator.close();
            doc.addField(scoreField, (long) (i * 100));
        assertEquals(1, RustBridge.getFileMetadata(filePath).numRows());
        schema = buildSchema(List.of(idField, nameField, scoreField));
        return new Schema(fields);
                settings,
        String filePath = createTempDir().resolve("success.parquet").toString();
        doc.addField(nameField, "alice");
            filePath,
        assertEquals(10, RustBridge.getFileMetadata(filePath).numRows());
        // VectorSchemaRoot inside VSRManager.addDocument throws an Arrow OutOfMemoryException.
        promotedFields.add(keyword.toArrowField(nameField.name(), true));
        assertEquals(FileInfos.empty(), writer.flush(FlushInput.EMPTY));
            1L,
        bufferPool = new ArrowBufferPool(Settings.EMPTY, nativeAllocator);
            schema,
        ParquetWriter writer = new ParquetWriter(
            filePath,
        assertTrue(
    public void testSingleDocumentFlush() throws Exception {
import java.nio.file.Files;
        doc.close();
            bufferPool,
 *
        ParquetDocumentInput doc = new ParquetDocumentInput();
        );
            1L,
import org.opensearch.parquet.fields.ArrowFieldRegistry;
        doc.close();
    @Override
        String filePath = createTempDir().resolve("empty.parquet").toString();
        List<Field> promotedFields = new ArrayList<>();
import org.opensearch.threadpool.FixedExecutorBuilder;
            1L,
            doc.addField(idField, i);
import java.nio.file.Path;
        String filePath = createTempDir().resolve("multi.parquet").toString();
        writer.addDoc(doc);
            () -> schema,
            1L,
 */
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);
    public void setUp() throws Exception {
    private MappedFieldType nameField;
            1L,
            writer.addDoc(doc);
            threadPool,
        doc.close();
        );
import org.apache.arrow.vector.types.pojo.Field;
            threadPool,
            bufferPool,
public class ParquetWriterTests extends ParquetBaseTests {
                "thread_pool." + ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME
            schema,
import org.opensearch.index.IndexSettings;
    }
    }
import org.opensearch.parquet.fields.ParquetField;
import org.opensearch.Version;
 * this file be licensed under the Apache-2.0 license or a
        doc.addField(scoreField, 500L);
        Schema promotedSchema = new Schema(promotedFields);
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_INGEST, 0L, Long.MAX_VALUE, null);
    public void testFlushWithNoDocuments() throws Exception {
    }
            schema,
        doc.addField(scoreField, 100L);
            1L,
            threadPool,
        assignTestCapabilities(idField, parquetFormat);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        ParquetWriter writer = new ParquetWriter(
            fields.add(new Field(ft.name(), pf.getFieldType(), null));
    private ArrowBufferPool bufferPool;
            populateMetadataFields(doc);
import org.opensearch.common.settings.Settings;
            () -> schema,
            new ParquetDataFormat(),
        RustBridge.initLogger();
        writer.updateMappingVersion(2L);
            new ParquetDataFormat(),
            filePath,
        ParquetDocumentInput doc = new ParquetDocumentInput();
    }
    @Override
        populateMetadataFields(doc);
            null
        for (MappedFieldType ft : fieldTypes) {
        indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
import org.opensearch.index.mapper.KeywordFieldMapper;
    public void testMappingTypeChangeRetiresWriterForSchemaFence() throws Exception {
            )
            schema,
        if (nativeAllocator != null) {
            indexSettings,
            () -> schema,
        }
        assertTrue("expected a Failure result but was: " + result, result instanceof WriteResult.Failure);
/*
import org.opensearch.index.engine.dataformat.FileInfos;
            assertNotNull("No ParquetField registered for type: " + ft.typeName(), pf);
        ParquetWriter writer = new ParquetWriter(
            indexSettings,
import org.opensearch.parquet.ParquetBaseTests;
            nativeAllocator = null;
        );
        // addDoc must translate the OOM into a Failure result rather than propagating the throw.
                -1,
            schema,
    public void tearDown() throws Exception {
        nativeAllocator = new ArrowNativeAllocator();
            filePath,
        WriteResult result = writer.addDoc(doc);
    }
        doc.addField(idField, 1);
import org.opensearch.parquet.bridge.RustBridge;
        ParquetDocumentInput doc = new ParquetDocumentInput();
        populateMetadataFields(doc);
        assignTestCapabilities(nameField, parquetFormat);
import org.apache.arrow.vector.types.pojo.Schema;
            1L,
        scoreField = new NumberFieldMapper.NumberFieldType("score", NumberFieldMapper.NumberType.LONG);
import java.util.List;
            threadPool,
    private Schema schema;
            () -> schema,
            doc.addField(nameField, "user_" + i);
    private Schema buildSchema(List<MappedFieldType> fieldTypes) {
        );
        FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
        assertTrue(result instanceof WriteResult.Success);
            1L,
