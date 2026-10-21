import org.opensearch.index.engine.dataformat.DataFormatPlugin;
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.parquet.fields.ParquetField;
    @Override
        );
public class ParquetDataFormatAwareEngineTests extends AbstractDataFormatAwareEngineTestCase {
import org.opensearch.parquet.writer.ParquetDocumentInput;
        );
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;
import static org.opensearch.parquet.ParquetBaseTests.metadataFields;
import static org.opensearch.parquet.ParquetBaseTests.ID_FIELD;
        }
    protected DocumentInput<?> createDocumentInput() {
import org.opensearch.plugins.SearchBackEndPlugin;
        for (MappedFieldType ft : List.of(NAME_FIELD, AGE_FIELD)) {
        Path dataPath = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
    private static final String DATE_NANOS_FIELD_NAME = "date_nanos_field";
    private Schema buildSchema() {
import org.opensearch.threadpool.FixedExecutorBuilder;
            new NumberFieldMapper.NumberFieldType(UNSIGNED_LONG_FIELD_NAME, NumberFieldMapper.NumberType.UNSIGNED_LONG),
                );
        );
import org.opensearch.index.engine.dataformat.stub.MockDeleteExecutionEngine;
import org.opensearch.parquet.ParquetDataFormatPlugin;
            public org.opensearch.index.engine.dataformat.DataFormat getDataFormat() {
        fields.addAll(metadataFields());
    }
        );
import org.opensearch.index.mapper.KeywordFieldMapper;
    private static final MappedFieldType AGE_FIELD = new NumberFieldMapper.NumberFieldType("age", NumberFieldMapper.NumberType.INTEGER);
import org.opensearch.index.mapper.BinaryFieldMapper.BinaryFieldType;
            new NumberFieldMapper.NumberFieldType(SHORT_FIELD_NAME, NumberFieldMapper.NumberType.SHORT),
    protected String dataFormatName() {
        input.addField(matchOnlyTextFieldType, randomAlphaOfLength(100));
import org.apache.arrow.vector.types.pojo.Field;
            format
            nativeAllocator = null;
    );
    private static final String BOOLEAN_FIELD_NAME = "boolean_field";
        addFieldWithCapabilities(input, new BooleanFieldType(BOOLEAN_FIELD_NAME), randomBoolean(), format);
        when(ms.fieldType(SeqNoFieldMapper.NAME)).thenReturn(SEQ_NO_FIELD);
    }
    private static final String LONG_FIELD_NAME = "long_field";
        NAME_FIELD.setCapabilityMap(Map.of(ParquetDataFormatPlugin.PARQUET_DATA_FORMAT, Set.of(COLUMNAR_STORAGE)));
import org.opensearch.index.engine.dataformat.stub.MockSearchBackEndPlugin;
import org.opensearch.index.mapper.NumberFieldMapper;
            fields.add(new Field(ft.name(), pf.getFieldType(), null));
            }
            new NumberFieldMapper.NumberFieldType(DOUBLE_FIELD_NAME, NumberFieldMapper.NumberType.DOUBLE),
        input.addField(fieldType, value);
            nativeAllocator.close();
}
            fields.add(new Field(dataField.getKey() + "_field", dataField.getValue().getFieldType(), null));
    private Schema schema;
            new NumberFieldMapper.NumberFieldType(FLOAT_FIELD_NAME, NumberFieldMapper.NumberType.FLOAT),
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_INGEST, 0L, Long.MAX_VALUE, null);
 *
                    engineConfig.indexSettings(),
import java.util.Map;
import org.apache.arrow.vector.types.pojo.Schema;
    public void setUp() throws Exception {
            input,
    private static final String FLOAT_FIELD_NAME = "float_field";
    private static final String DATE_FIELD_NAME = "date_field";
            shardPath
    }
        );
    MatchOnlyTextFieldType matchOnlyTextFieldType = new MatchOnlyTextFieldMapper.MatchOnlyTextFieldType(
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            format
import static org.mockito.Mockito.when;
        Settings settings = Settings.builder().put("node.name", "parquet-dfae-test").build();
    }
                return new MockDeleteExecutionEngine(dataFormat);
                    Settings.EMPTY,
import org.opensearch.index.shard.ShardPath;
 * The OpenSearch Contributors require contributions made to
 * <p>Requires the native library ({@code libopensearch_native}) to be built
    private static final String TEXT_FIELD_NAME = "text_field";
            settings,
import java.util.ArrayList;
            input,
        schema = buildSchema();
import org.opensearch.common.network.InetAddresses;
                .build()
    }
        addFieldWithCapabilities(input, new IpFieldType(IP_FIELD_NAME), InetAddresses.forString("0.0.0.0"), format);
    protected MapperService createMockMapperService(IndexSettings indexSettings) {
    @Override
        List<Field> fields = new ArrayList<>();
import java.nio.file.Path;
        );
            System.nanoTime(),
            public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig engineConfig) {
        RustBridge.initLogger();
        ParquetDataFormat format = new ParquetDataFormat();
import org.opensearch.parquet.fields.plugins.CoreDataFieldPlugin;
    private static final String BINARY_FIELD_NAME = "binary_field";
            format
            new NumberFieldMapper.NumberFieldType(BYTE_FIELD_NAME, NumberFieldMapper.NumberType.BYTE),
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
    private static final String UNSIGNED_LONG_FIELD_NAME = "unsigned_long_field";
import org.opensearch.index.mapper.TextSearchInfo;
            }
    static {
 * bypassing the need for a real {@link org.opensearch.index.mapper.MapperService}.
import org.opensearch.parquet.fields.ArrowFieldRegistry;
        addFieldWithCapabilities(
                    engineConfig.store().shardPath(),
        false,
            format
    protected SearchBackEndPlugin<?> createSearchBackEndPlugin() {
            public DeleteExecutionEngine<?> getDeleteExecutionEngine(Committer committer) {
        addFieldWithCapabilities(input, new DateFieldType(DATE_FIELD_NAME), System.currentTimeMillis(), format);
import org.opensearch.index.mapper.SeqNoFieldMapper;
    }
        if (nativeAllocator != null) {
    @Override
            new NumberFieldMapper.NumberFieldType(LONG_FIELD_NAME, NumberFieldMapper.NumberType.LONG),
 */
        // Create a plugin that bypasses MapperService and uses our hardcoded schema
    private static final String HALF_FLOAT_FIELD_NAME = "half_float_field";
            Double.MAX_VALUE,
            new DateFieldType(DATE_NANOS_FIELD_NAME, DateFieldMapper.Resolution.NANOSECONDS),
 * compatible open source license.
        return new Store(
    }
            "test",
import org.opensearch.index.mapper.BooleanFieldMapper.BooleanFieldType;
            ParquetField pf = ArrowFieldRegistry.getParquetField(ft.typeName());
            Settings.builder()
            @Override
 * <p>Provides a hardcoded Arrow schema with keyword and integer fields,
            format
        ShardPath shardPath = new ShardPath(false, dataPath, dataPath, shardId);
            input,
        );
                ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME,
    private static final String INT_FIELD_NAME = "integer_field";
            format
        addFieldWithCapabilities(
        addFieldWithCapabilities(
        addFieldWithCapabilities(
        input.addField(NAME_FIELD, "name");
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
            new org.apache.lucene.store.NIOFSDirectory(dataPath),
import org.opensearch.index.store.PrecomputedChecksumStrategy;
            Long.MAX_VALUE,
        true,
import org.opensearch.common.settings.Settings;
        return new DataFormatPlugin() {
    private static final String DOUBLE_FIELD_NAME = "double_field";
        when(ms.getIndexSettings()).thenReturn(indexSettings);
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        addFieldWithCapabilities(
            input,
import static org.opensearch.parquet.ParquetBaseTests.VERSION_FIELD;
        ParametrizedFieldMapper.Parameter.metaParam().get()
            }
        super.tearDown();
import org.apache.arrow.vector.types.pojo.ArrowType;
        );
    }
import org.apache.arrow.vector.types.pojo.FieldType;
import org.opensearch.index.store.Store;
            Integer.MAX_VALUE,
                    threadPool,
import org.opensearch.parquet.ParquetSettings;
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper.MatchOnlyTextFieldType;
    @Override
 * Runs the {@link AbstractDataFormatAwareEngineTestCase} suite with the real
            Short.MAX_VALUE,
            input,
            input,
        addFieldWithCapabilities(
        };
        );
            Float.MAX_VALUE,
        return ms;
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
    private void addFieldWithCapabilities(ParquetDocumentInput input, MappedFieldType fieldType, Object value, ParquetDataFormat format) {
    private static final String BYTE_FIELD_NAME = "byte_field";
            @Override
            format
        MapperService ms = mock(MapperService.class);
import org.opensearch.test.IndexSettingsModule;
    }
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
import org.opensearch.index.mapper.MappedFieldType;
        when(ms.fieldType(VersionFieldMapper.NAME)).thenReturn(VERSION_FIELD);
            new org.opensearch.test.DummyShardLock(shardId),
                settings,
        for (Map.Entry<String, ParquetField> dataField : new CoreDataFieldPlugin().getParquetFields().entrySet()) {
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;
    protected ThreadPool buildThreadPool() {
    protected DataFormatPlugin createDataFormatPlugin() {
import java.util.Set;
        TextSearchInfo.SIMPLE_MATCH_ONLY,
import java.nio.charset.StandardCharsets;
import org.opensearch.index.IndexSettings;
 *
        assignTestCapabilities(fieldType, format);
            private final ParquetDataFormat dataFormat = new ParquetDataFormat();
import org.opensearch.index.mapper.DateFieldMapper;
import org.opensearch.index.mapper.ParametrizedFieldMapper;
 * SPDX-License-Identifier: Apache-2.0
        );
import org.opensearch.index.engine.dataformat.AbstractDataFormatAwareEngineTestCase;
import org.opensearch.index.mapper.MapperService;
import static org.opensearch.parquet.ParquetBaseTests.SEQ_NO_FIELD;
                    nativeAllocator
            Long.MAX_VALUE,
                1,
import static org.opensearch.index.engine.dataformat.DataFormatTestUtils.assignTestCapabilities;
            format
            input,
        addFieldWithCapabilities(input, new TextFieldType(TEXT_FIELD_NAME), randomAlphaOfLength(100), format);
        return new MockSearchBackEndPlugin(List.of(ParquetDataFormat.PARQUET_DATA_FORMAT_NAME));
    private ArrowNativeAllocator nativeAllocator;
        ParquetDocumentInput input = new ParquetDocumentInput();
        java.nio.file.Files.createDirectories(dataPath);
    @Override
        addFieldWithCapabilities(
 *
        return new TestThreadPool(
import org.opensearch.index.engine.exec.commit.Committer;
        super.setUp();
                "thread_pool." + ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME
            shardId,
        nativeAllocator = new ArrowNativeAllocator();
        }
            new FixedExecutorBuilder(
        // Parquet engine needs a real filesystem path for writing .parquet files
            getClass().getName(),
        );
    @Override
            Byte.MAX_VALUE,
            input,
    }
            new NumberFieldMapper.NumberFieldType(HALF_FLOAT_FIELD_NAME, NumberFieldMapper.NumberType.HALF_FLOAT),
 * is a dependency of the test task in the Parquet plugin's {@code build.gradle}.
            indexSettings,
        org.opensearch.index.mapper.DocumentMapper documentMapper = mock(org.opensearch.index.mapper.DocumentMapper.class);
                return dataFormat;
    protected Store createStore() throws IOException {
 * and available on the library path. The Gradle task {@code buildRustLibrary}
import org.opensearch.threadpool.ThreadPool;
package org.opensearch.parquet.engine;
            new NumberFieldMapper.NumberFieldType(INT_FIELD_NAME, NumberFieldMapper.NumberType.INTEGER),
    private static final String MATCH_ONLY_TEXT_FIELD_NAME = "match_only_text_field";
    private static final String IP_FIELD_NAME = "ip_field";
                    () -> schema,
    }
 */
 * this file be licensed under the Apache-2.0 license or a
                    () -> 1L,
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
/*
        input.addField(ID_FIELD, "doc-id".getBytes(StandardCharsets.UTF_8));
        );
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
            Short.MAX_VALUE,
            )
        );
import java.util.List;
                .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
            input,
    @Override
                -1,
                    new PrecomputedChecksumStrategy(),
                return new ParquetIndexingEngine(
        return input;
import org.opensearch.index.mapper.IpFieldMapper.IpFieldType;
            new BinaryFieldType(BINARY_FIELD_NAME),
import org.opensearch.parquet.bridge.RustBridge;
        when(ms.documentMapper()).thenReturn(documentMapper);
        assignTestCapabilities(matchOnlyTextFieldType, format);
import java.io.IOException;
import org.opensearch.index.engine.dataformat.DeleteExecutionEngine;
    @Override
        }
        fields.add(new Field(DocumentInput.ROW_ID_FIELD, FieldType.notNullable(new ArrowType.Int(64, true)), null));
        when(documentMapper.getVersion()).thenReturn(1L);
        MATCH_ONLY_TEXT_FIELD_NAME,
        AGE_FIELD.setCapabilityMap(Map.of(ParquetDataFormatPlugin.PARQUET_DATA_FORMAT, Set.of(COLUMNAR_STORAGE)));
import static org.mockito.Mockito.mock;
            input,
        return ParquetDataFormat.PARQUET_DATA_FORMAT_NAME;
    private static final String SHORT_FIELD_NAME = "short_field";
        addFieldWithCapabilities(
        addFieldWithCapabilities(
    @Override
    }
/**
            randomAlphaOfLength(100).getBytes(StandardCharsets.UTF_8),
        addFieldWithCapabilities(
            format
        return new Schema(fields);
            @Override
 * correctly with the Parquet writer, native Rust bridge, and Arrow vectors.
import org.opensearch.index.engine.dataformat.DocumentInput;
            Store.OnClose.EMPTY,
                    dataFormat,
    private static final MappedFieldType NAME_FIELD = new KeywordFieldMapper.KeywordFieldType("name");
    public void tearDown() throws Exception {
import org.opensearch.index.mapper.VersionFieldMapper;
            format
                    () -> ParquetSettings.getLowCardinalityEnabledFields(engineConfig.mapperService()),
 * Parquet native engine. Validates that the DFAE orchestration layer works
