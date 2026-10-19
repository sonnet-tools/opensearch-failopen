    private static final String UNSIGNED_LONG_FIELD_NAME = "unsigned_long_field";  
            new NumberFieldMapper.NumberFieldType(DOUBLE_FIELD_NAME, NumberFieldMapper.NumberType.DOUBLE),
        }
            format
        addFieldWithCapabilities(  
            Long.MAX_VALUE,  
            input,
        };
        input.addField(matchOnlyTextFieldType, randomAlphaOfLength(100));
    private Schema schema;
import java.util.Set;
        super.tearDown();
            new NumberFieldMapper.NumberFieldType(SHORT_FIELD_NAME, NumberFieldMapper.NumberType.SHORT),
                .build()
    @Override
 * bypassing the need for a real {@link org.opensearch.index.mapper.MapperService}.
/*  
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;  
    private static final String BINARY_FIELD_NAME = "binary_field";
import org.opensearch.index.engine.dataformat.stub.MockDeleteExecutionEngine;
import org.opensearch.cluster.metadata.IndexMetadata;
        return input;  
            format
                    threadPool,
    private static final String SHORT_FIELD_NAME = "short_field";  
            public org.opensearch.index.engine.dataformat.DataFormat getDataFormat() {
    protected Store createStore() throws IOException {
        addFieldWithCapabilities(
        return new MockSearchBackEndPlugin(List.of(ParquetDataFormat.PARQUET_DATA_FORMAT_NAME));
    }
        addFieldWithCapabilities(  
    }
import org.apache.arrow.vector.types.pojo.ArrowType;
    @Override
import org.opensearch.index.mapper.KeywordFieldMapper;
            new BinaryFieldType(BINARY_FIELD_NAME),
            input,
            new org.apache.lucene.store.NIOFSDirectory(dataPath),
    protected MapperService createMockMapperService(IndexSettings indexSettings) {
    @Override  
            @Override
import org.opensearch.threadpool.ThreadPool;
            input,
            input,
    @Override
}  
        AGE_FIELD.setCapabilityMap(Map.of(ParquetDataFormatPlugin.PARQUET_DATA_FORMAT, Set.of(COLUMNAR_STORAGE)));
 */
        );
            format
import org.opensearch.index.shard.ShardPath;  
                    nativeAllocator  
        );
                -1,
    private static final String TEXT_FIELD_NAME = "text_field";
import org.opensearch.index.IndexSettings;
        addFieldWithCapabilities(input, new IpFieldType(IP_FIELD_NAME), InetAddresses.forString("0.0.0.0"), format);
import org.opensearch.index.engine.exec.commit.Committer;
import static org.mockito.Mockito.when;
            input,
            Double.MAX_VALUE,  
                return new MockDeleteExecutionEngine(dataFormat);  
    protected DataFormatPlugin createDataFormatPlugin() {
        input.addField(NAME_FIELD, "name");
import org.apache.arrow.vector.types.pojo.Field;
            format  
            indexSettings,
            getClass().getName(),
            settings,
            format
                );
        super.setUp();  
        );  
import org.opensearch.index.mapper.TextSearchInfo;
            Short.MAX_VALUE,  
        addFieldWithCapabilities(  
 * is a dependency of the test task in the Parquet plugin's {@code build.gradle}.
        }
        return ParquetDataFormat.PARQUET_DATA_FORMAT_NAME;  
    protected DocumentInput<?> createDocumentInput() {
 * and available on the library path. The Gradle task {@code buildRustLibrary}  
    private static final String DATE_NANOS_FIELD_NAME = "date_nanos_field";  
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
    private static final MappedFieldType NAME_FIELD = new KeywordFieldMapper.KeywordFieldType("name");
        nativeAllocator = new ArrowNativeAllocator();
import org.opensearch.index.engine.dataformat.AbstractDataFormatAwareEngineTestCase;
 * this file be licensed under the Apache-2.0 license or a
 *
    private ArrowNativeAllocator nativeAllocator;
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_INGEST, 0L, Long.MAX_VALUE, null);  
    );  
            Store.OnClose.EMPTY,
    }
 * Runs the {@link AbstractDataFormatAwareEngineTestCase} suite with the real
import org.opensearch.test.IndexSettingsModule;
    private static final String BOOLEAN_FIELD_NAME = "boolean_field";  
    }  
    private static final String BYTE_FIELD_NAME = "byte_field";
            format
        when(documentMapper.getVersion()).thenReturn(1L);
import org.opensearch.index.mapper.VersionFieldMapper;
        addFieldWithCapabilities(input, new DateFieldType(DATE_FIELD_NAME), System.currentTimeMillis(), format);
import org.opensearch.index.mapper.MappedFieldType;
            new NumberFieldMapper.NumberFieldType(UNSIGNED_LONG_FIELD_NAME, NumberFieldMapper.NumberType.UNSIGNED_LONG),
import java.nio.file.Path;  
            @Override
        for (Map.Entry<String, ParquetField> dataField : new CoreDataFieldPlugin().getParquetFields().entrySet()) {
    @Override
        org.opensearch.index.mapper.DocumentMapper documentMapper = mock(org.opensearch.index.mapper.DocumentMapper.class);
        return new TestThreadPool(  
    protected String dataFormatName() {
        );
        return new DataFormatPlugin() {
                return new ParquetIndexingEngine(
        );
    @Override
    private static final MappedFieldType AGE_FIELD = new NumberFieldMapper.NumberFieldType("age", NumberFieldMapper.NumberType.INTEGER);  
    }
        addFieldWithCapabilities(input, new BooleanFieldType(BOOLEAN_FIELD_NAME), randomBoolean(), format);  
import org.opensearch.parquet.ParquetDataFormatPlugin;  
import org.opensearch.index.mapper.MapperService;  
        addFieldWithCapabilities(input, new TextFieldType(TEXT_FIELD_NAME), randomAlphaOfLength(100), format);  
            format
        addFieldWithCapabilities(  
import org.opensearch.parquet.fields.ParquetField;
import org.opensearch.plugins.SearchBackEndPlugin;
            input,
    static {
import java.io.IOException;
import static org.opensearch.parquet.ParquetBaseTests.SEQ_NO_FIELD;  
        when(ms.getIndexSettings()).thenReturn(indexSettings);  
import org.opensearch.index.store.Store;
    private void addFieldWithCapabilities(ParquetDocumentInput input, MappedFieldType fieldType, Object value, ParquetDataFormat format) {  
            input,
    protected ThreadPool buildThreadPool() {
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper.MatchOnlyTextFieldType;
        when(ms.fieldType(VersionFieldMapper.NAME)).thenReturn(VERSION_FIELD);
        input.addField(fieldType, value);
import org.opensearch.index.mapper.SeqNoFieldMapper;
package org.opensearch.parquet.engine;
        ParametrizedFieldMapper.Parameter.metaParam().get()
            )  
import java.util.Map;  
import java.nio.charset.StandardCharsets;
    }  
            ParquetField pf = ArrowFieldRegistry.getParquetField(ft.typeName());
        return new Schema(fields);
import java.util.List;
            new NumberFieldMapper.NumberFieldType(BYTE_FIELD_NAME, NumberFieldMapper.NumberType.BYTE),
            Float.MAX_VALUE,  
import static org.opensearch.parquet.ParquetBaseTests.VERSION_FIELD;
        );
            }
                    new PrecomputedChecksumStrategy(),
import org.opensearch.index.engine.dataformat.DataFormatPlugin;  
    @Override
    @Override  
            format
            shardId,  
                    engineConfig.indexSettings(),  
import org.opensearch.index.mapper.NumberFieldMapper;  
        addFieldWithCapabilities(  
import org.opensearch.index.engine.dataformat.DocumentInput;
    private static final String DOUBLE_FIELD_NAME = "double_field";
            "test",
public class ParquetDataFormatAwareEngineTests extends AbstractDataFormatAwareEngineTestCase {  
        when(ms.fieldType(SeqNoFieldMapper.NAME)).thenReturn(SEQ_NO_FIELD);
    public void tearDown() throws Exception {
import org.opensearch.index.mapper.BooleanFieldMapper.BooleanFieldType;  
import org.opensearch.common.network.InetAddresses;
 *
        );  
            format
            new DateFieldType(DATE_NANOS_FIELD_NAME, DateFieldMapper.Resolution.NANOSECONDS),
            @Override  
import static org.opensearch.index.engine.dataformat.DataFormatTestUtils.assignTestCapabilities;  
import org.opensearch.index.mapper.BinaryFieldMapper.BinaryFieldType;
        // Parquet engine needs a real filesystem path for writing .parquet files  
            input,
    private static final String HALF_FLOAT_FIELD_NAME = "half_float_field";
            shardPath
        );
            Long.MAX_VALUE,  
        ParquetDataFormat format = new ParquetDataFormat();
            input,  
        schema = buildSchema();
            new org.opensearch.test.DummyShardLock(shardId),  
        }  
import org.opensearch.index.mapper.ParametrizedFieldMapper;
import org.opensearch.index.mapper.DateFieldMapper;
    private Schema buildSchema() {
import static org.opensearch.parquet.ParquetBaseTests.metadataFields;
        return ms;
        MATCH_ONLY_TEXT_FIELD_NAME,
        true,
        addFieldWithCapabilities(  
        );
            nativeAllocator = null;
                return dataFormat;  
import org.opensearch.index.engine.dataformat.DeleteExecutionEngine;
        false,  
import org.opensearch.parquet.fields.plugins.CoreDataFieldPlugin;
            new NumberFieldMapper.NumberFieldType(LONG_FIELD_NAME, NumberFieldMapper.NumberType.LONG),
            Integer.MAX_VALUE,  
 */  
    private static final String MATCH_ONLY_TEXT_FIELD_NAME = "match_only_text_field";
 * <p>Provides a hardcoded Arrow schema with keyword and integer fields,  
import org.opensearch.index.engine.dataformat.stub.MockSearchBackEndPlugin;  
        for (MappedFieldType ft : List.of(NAME_FIELD, AGE_FIELD)) {
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;  
import org.opensearch.common.settings.Settings;  
        ParquetDocumentInput input = new ParquetDocumentInput();  
                    Settings.EMPTY,  
            format
            fields.add(new Field(dataField.getKey() + "_field", dataField.getValue().getFieldType(), null));  
    MatchOnlyTextFieldType matchOnlyTextFieldType = new MatchOnlyTextFieldMapper.MatchOnlyTextFieldType(  
                .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)  
            randomAlphaOfLength(100).getBytes(StandardCharsets.UTF_8),  
        RustBridge.initLogger();
                1,  
    private static final String IP_FIELD_NAME = "ip_field";
                "thread_pool." + ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME
            input,
        );
        assignTestCapabilities(matchOnlyTextFieldType, format);
import org.opensearch.parquet.fields.ArrowFieldRegistry;  
    @Override
import org.apache.arrow.vector.types.pojo.Schema;
                ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME,
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(  
import org.opensearch.index.mapper.IpFieldMapper.IpFieldType;  
                    () -> 1L,
 * compatible open source license.
        MapperService ms = mock(MapperService.class);  
 * correctly with the Parquet writer, native Rust bridge, and Arrow vectors.  
                settings,
        Path dataPath = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
    private static final String INT_FIELD_NAME = "integer_field";
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;
            }
    }
        ShardPath shardPath = new ShardPath(false, dataPath, dataPath, shardId);
    }
            new NumberFieldMapper.NumberFieldType(HALF_FLOAT_FIELD_NAME, NumberFieldMapper.NumberType.HALF_FLOAT),
        addFieldWithCapabilities(  
            new FixedExecutorBuilder(  
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;  
    public void setUp() throws Exception {
            public DeleteExecutionEngine<?> getDeleteExecutionEngine(Committer committer) {
            nativeAllocator.close();
                    () -> ParquetSettings.getLowCardinalityEnabledFields(engineConfig.mapperService()),
            fields.add(new Field(ft.name(), pf.getFieldType(), null));  
                    () -> schema,  
            System.nanoTime(),
        );
            new NumberFieldMapper.NumberFieldType(INT_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER),
            public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig engineConfig) {
import org.opensearch.parquet.bridge.RustBridge;
/**  
    }
        addFieldWithCapabilities(  
            Settings.builder()
 * Parquet native engine. Validates that the DFAE orchestration layer works
            Byte.MAX_VALUE,  
        );
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
 * <p>Requires the native library ({@code libopensearch_native}) to be built
import org.opensearch.index.store.PrecomputedChecksumStrategy;
            new NumberFieldMapper.NumberFieldType(FLOAT_FIELD_NAME, NumberFieldMapper.NumberType.FLOAT),
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        Settings settings = Settings.builder().put("node.name", "parquet-dfae-test").build();
import org.opensearch.parquet.writer.ParquetDocumentInput;  
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
    private static final String LONG_FIELD_NAME = "long_field";
    private static final String FLOAT_FIELD_NAME = "float_field";  
    }
    protected SearchBackEndPlugin<?> createSearchBackEndPlugin() {  
            private final ParquetDataFormat dataFormat = new ParquetDataFormat();
        List<Field> fields = new ArrayList<>();  
            }
        if (nativeAllocator != null) {  
 *
import java.util.ArrayList;
    }
import static org.opensearch.parquet.ParquetBaseTests.ID_FIELD;
            Short.MAX_VALUE,  
import org.opensearch.threadpool.TestThreadPool;
        TextSearchInfo.SIMPLE_MATCH_ONLY,
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;
        NAME_FIELD.setCapabilityMap(Map.of(ParquetDataFormatPlugin.PARQUET_DATA_FORMAT, Set.of(COLUMNAR_STORAGE)));  
        return new Store(
        when(ms.documentMapper()).thenReturn(documentMapper);  
import org.opensearch.parquet.ParquetSettings;
        assignTestCapabilities(fieldType, format);
        fields.add(new Field(DocumentInput.ROW_ID_FIELD, FieldType.notNullable(new ArrowType.Int(64, true)), null));  
                    engineConfig.store().shardPath(),
    }
 * The OpenSearch Contributors require contributions made to  
        );
        addFieldWithCapabilities(  
        fields.addAll(metadataFields());
        // Create a plugin that bypasses MapperService and uses our hardcoded schema  
 * SPDX-License-Identifier: Apache-2.0
        input.addField(ID_FIELD, "doc-id".getBytes(StandardCharsets.UTF_8));
    private static final String DATE_FIELD_NAME = "date_field";
import static org.mockito.Mockito.mock;  
        java.nio.file.Files.createDirectories(dataPath);
import org.opensearch.threadpool.FixedExecutorBuilder;  
                    dataFormat,
import org.apache.arrow.vector.types.pojo.FieldType;  
