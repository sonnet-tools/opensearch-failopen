                    "1",
            .parse(
            // "constant_keyword" capability entry, so the pluggable-format capability validation correctly rejects the
            return;
        // only in the plugin-free run.
            // analytics-backend-lucene, not compile-visible here). No real format (lucene/parquet/composite) declares a
            .endObject()
            .startObject("properties")
            .mappers()
        XContentBuilder builder = JsonXContent.contentBuilder().startObject();
            .startObject("field")
        indexService = createIndexWithSimpleMappings("test-index", Settings.EMPTY, "field", "type=constant_keyword,value=default_value");
        );
import org.opensearch.index.IndexSettings;
        // parseCreateFieldForPluggableFormat just validates, doesn't addField
import org.opensearch.core.xcontent.XContentBuilder;
    }
        mapper.copyTo = copyTo;
import org.opensearch.plugins.Plugin;
        return new SourceToParse("test", "1", BytesReference.bytes(builder), MediaTypeRegistry.JSON);
    }
            MapperParsingException e = expectThrows(
import org.apache.lucene.index.IndexWriter;
        assertNull(field);
    }
            plugins.add(MockCommitterEnginePlugin.class);
            containsString(
            .startObject("type")
        // and capability validation is skipped for the empty format — the constant_keyword field is accepted.
            )
        // Test via document parse — valid value should succeed
import org.junit.Before;
                MapperParsingException.class,
            .documentMapper()
            .endObject();
import org.opensearch.common.xcontent.XContentFactory;
            // path we exercise the real "lucene" data format (LuceneDataFormat.LUCENE_FORMAT_NAME in
    public void testBuilderToXContent() throws IOException {
}
        // valid value should not throw
                iw.addDocument(doc);
            .startObject()
        XContentBuilder xContentBuilder = JsonXContent.contentBuilder().startObject();
            ConstantKeywordFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty());
            .startObject("field2")
        ConstantKeywordFieldMapper.Builder builder = new ConstantKeywordFieldMapper.Builder("name", "value1");
            b.field("field2", "field_2_value");
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
        xContentBuilder.endObject();
        try (Directory directory = newDirectory()) {
 *
    private IndexService indexService;
import org.apache.lucene.store.Directory;
        assertThat(
            }
            );
        build.accept(builder);
            .mappers()
    public void setup() {
                String source = builder.toString();
            indexSettings.put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene");
            );
            .field("type", "keyword")
 * compatible open source license.
                builder.endObject();
            assertThat(e.getMessage(), containsString("cannot cover"));
    public void testMissingDefaultIndexMapper() throws Exception {
 */
            // The in-memory MockDataFormatPlugin cannot be registered alongside the real sandbox stack: both it and
            // field and index creation fails with MapperParsingException "... cannot cover ...".
        if (shouldInstallSandboxStack()) {
import org.opensearch.index.engine.dataformat.stub.MockDocumentInput;
                Document doc = new Document();
        Settings.Builder indexSettings = Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true);
        if (shouldInstallSandboxStack() == false) {
            .field("type", "keyword")
                    MediaTypeRegistry.JSON
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
            b.field("field", "default_value");
        builder.toXContent(xContentBuilder, false);
import org.apache.lucene.index.IndexableField;
            .getMapper(FIELD_NAME);
    }
                    "test-pluggable",
            .endObject()
            .endObject();
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
    private DocumentMapperParser parser;
        indexService = createIndex("test");
import org.opensearch.common.settings.Settings;
        return mapper;
import org.apache.lucene.index.IndexWriterConfig;
    }
        mapping = mapping.endObject().endObject().endObject();
import org.apache.lucene.document.StoredField;
            .field("type", "constant_keyword")
                new SourceToParse(
        indexService.mapperService()
 * The OpenSearch Contributors require contributions made to
        // delete engine (each of which the node permits exactly one of), so the in-memory mocks are registered
import org.apache.lucene.document.Document;
            .endObject()
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
            OpenSearchParseException.class,
import java.io.IOException;
            // the stack's LucenePlugin return a DeleteExecutionEngine, so DataFormatRegistry#getDeleteExecutionEngine
/*
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        assertEquals("{\"value\":\"value1\"}", xContentBuilder.toString());
                "failed to parse field [field] of type [constant_keyword] in document with id '1'. Preview of field's value: 'sdf'"
import org.opensearch.common.CheckedConsumer;
            b.field("field2", "szdfvsddf");
            () -> parser.parse("type", new CompressedXContent(mapping.toString()))
            .startObject("properties")
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "foo").endObject()),
import java.util.List;
        List<Class<? extends Plugin>> plugins = new ArrayList<>(List.of(InternalSettingsPlugin.class));
            .startObject("field")
        return plugins;
        // calling directly since it's protected and same package
    }
        indexService = createIndexWithSimpleMappings("test-pluggable", indexSettings.build(), "field", "type=constant_keyword,value=foo");
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        final XContentBuilder mapping = XContentFactory.jsonBuilder()
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .startObject("field2")
        }));
    }
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
                () -> createIndexWithSimpleMappings("test-pluggable", indexSettings.build(), "field", "type=constant_keyword,value=foo")
import org.opensearch.core.xcontent.MediaTypeRegistry;
    private ConstantKeywordFieldMapper getMapper(FieldMapper.CopyTo copyTo) {
    public void testPluggableDataFormatConstantKeywordValidates() throws Exception {
public class ConstantKeywordFieldMapperTests extends OpenSearchSingleNodeTestCase {
        }
            .startObject()
    protected Collection<Class<? extends Plugin>> getPlugins() {
            .getMapper(FIELD_NAME);
import org.opensearch.common.xcontent.json.JsonXContent;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            b.field("field", "sdf");
        parser = indexService.mapperService().documentMapperParser();
        }
            .endObject()
import org.opensearch.OpenSearchParseException;
        );
        builder.endObject();
    @Before
            .startObject("type")
        assertNotNull(mapper);
        ConstantKeywordFieldMapper mapper = (ConstantKeywordFieldMapper) indexService.mapperService()
import org.apache.lucene.index.DirectoryReader;
import java.util.ArrayList;
import org.opensearch.common.compress.CompressedXContent;
    private final SourceToParse source(CheckedConsumer<XContentBuilder, IOException> build) throws IOException {
    private static final String FIELD_NAME = "field";
    @Override
 * SPDX-License-Identifier: Apache-2.0
            .field("type", "constant_keyword")
    }
        }
    public void testPossibleToDeriveSource_WhenCopyToPresent() {
            }
            // would fail its "exactly one DeleteExecutionEngine" check when the shard engine is built. So on the stack
                assertEquals("{\"" + FIELD_NAME + "\":" + "\"default_value\"" + "}", source);
            plugins.add(MockDataFormatPlugin.class);
    }
        // When the sandbox stack is installed, its LucenePlugin supplies the real data format, committer and
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
        final ParsedDocument doc = mapper.parse(source(b -> {
 * this file be licensed under the Apache-2.0 license or a
        assertThat(e.getMessage(), containsString("Field [field] is missing required parameter [value]"));
import org.opensearch.core.common.bytes.BytesReference;
            .field("value", "default_value")
                ),
    public void testDerivedValueFetching() throws IOException {
    public void testDefaultDisabledIndexMapper() throws Exception {
        // constantKeywordField should not be stored
        final IndexableField field = doc.rootDoc().getField("field");
import org.opensearch.index.IndexService;
        })));
        // Plugin-free run: the data format value is left unset, so MockDataFormatPlugin's default "" format is selected
        OpenSearchParseException e = expectThrows(
        DocumentMapper mapper = parser.parse("type", new CompressedXContent(mapping.toString()));
        ConstantKeywordFieldMapper mapper = getMapper(copyTo);
        ConstantKeywordFieldMapper mapper = (ConstantKeywordFieldMapper) indexService.mapperService()
                doc.add(new StoredField(FIELD_NAME, "default_value"));
import static org.hamcrest.Matchers.containsString;
import java.util.Collection;
package org.opensearch.index.mapper;
    }
                new MockDocumentInput()
            .endObject()
import org.opensearch.common.util.FeatureFlags;
            .documentMapper()
            .documentMapper()
            e.getMessage(),
import org.opensearch.test.InternalSettingsPlugin;
