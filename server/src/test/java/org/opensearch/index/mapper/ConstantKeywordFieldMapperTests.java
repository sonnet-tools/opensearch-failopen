    }
        }
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            .startObject()
                ),
import org.opensearch.index.engine.dataformat.stub.MockDocumentInput;
                    "1",
            e.getMessage(),
            )
        // and capability validation is skipped for the empty format — the constant_keyword field is accepted.
            .endObject()
        return plugins;
 * compatible open source license.
            containsString(
    private final SourceToParse source(CheckedConsumer<XContentBuilder, IOException> build) throws IOException {
            // "constant_keyword" capability entry, so the pluggable-format capability validation correctly rejects the
            .getMapper(FIELD_NAME);  
            }  
            .field("type", "keyword")
    @Before
                iw.addDocument(doc);  
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
            .getMapper(FIELD_NAME);  
    }  
            );
                new SourceToParse(  
        indexService.mapperService()  
            .documentMapper()
            // The in-memory MockDataFormatPlugin cannot be registered alongside the real sandbox stack: both it and  
                assertEquals("{\"" + FIELD_NAME + "\":" + "\"default_value\"" + "}", source);
import org.opensearch.common.settings.Settings;
import java.io.IOException;
        // Plugin-free run: the data format value is left unset, so MockDataFormatPlugin's default "" format is selected  
import org.opensearch.core.xcontent.XContentBuilder;
        DocumentMapper mapper = parser.parse("type", new CompressedXContent(mapping.toString()));  
                    MediaTypeRegistry.JSON
            // field and index creation fails with MapperParsingException "... cannot cover ...".  
        assertThat(e.getMessage(), containsString("Field [field] is missing required parameter [value]"));
    public void setup() {
        indexService = createIndex("test");  
            b.field("field", "sdf");  
            plugins.add(MockDataFormatPlugin.class);
        );
            .startObject("type")
import org.opensearch.common.util.FeatureFlags;  
        assertThat(  
import org.opensearch.index.IndexService;  
import org.opensearch.plugins.Plugin;
            // would fail its "exactly one DeleteExecutionEngine" check when the shard engine is built. So on the stack
        })));
                    "test-pluggable",
        final XContentBuilder mapping = XContentFactory.jsonBuilder()
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            .startObject("type")
            // analytics-backend-lucene, not compile-visible here). No real format (lucene/parquet/composite) declares a
import org.apache.lucene.document.Document;
        builder.toXContent(xContentBuilder, false);
    }
        );
        // parseCreateFieldForPluggableFormat just validates, doesn't addField
    @Override  
            .field("type", "constant_keyword")
            .documentMapper()
                MapperParsingException.class,  
            .endObject()  
        build.accept(builder);  
package org.opensearch.index.mapper;
    private DocumentMapperParser parser;
            .field("type", "constant_keyword")
        try (Directory directory = newDirectory()) {  
    private static final String FIELD_NAME = "field";
    public void testMissingDefaultIndexMapper() throws Exception {  
        // valid value should not throw  
            indexSettings.put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene");
            .startObject("field")
import org.apache.lucene.store.Directory;
        ConstantKeywordFieldMapper.Builder builder = new ConstantKeywordFieldMapper.Builder("name", "value1");  
        parser = indexService.mapperService().documentMapperParser();
        if (shouldInstallSandboxStack()) {
            // the stack's LucenePlugin return a DeleteExecutionEngine, so DataFormatRegistry#getDeleteExecutionEngine
            .endObject()
            OpenSearchParseException.class,
                String source = builder.toString();
    public void testDefaultDisabledIndexMapper() throws Exception {
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();  
        if (shouldInstallSandboxStack() == false) {  
import org.opensearch.index.IndexSettings;
        // When the sandbox stack is installed, its LucenePlugin supplies the real data format, committer and
import static org.hamcrest.Matchers.containsString;  
        }));
        // constantKeywordField should not be stored
 * this file be licensed under the Apache-2.0 license or a
        mapper.copyTo = copyTo;
            .endObject();
        List<Class<? extends Plugin>> plugins = new ArrayList<>(List.of(InternalSettingsPlugin.class));
        OpenSearchParseException e = expectThrows(
            .field("type", "keyword")  
            assertThat(e.getMessage(), containsString("cannot cover"));  
    }  
import org.apache.lucene.document.StoredField;
                Document doc = new Document();
        }
            // path we exercise the real "lucene" data format (LuceneDataFormat.LUCENE_FORMAT_NAME in  
        Settings.Builder indexSettings = Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true);
    }
            .startObject("properties")  
    public void testPluggableDataFormatConstantKeywordValidates() throws Exception {  
        }  
        builder.endObject();
        XContentBuilder xContentBuilder = JsonXContent.contentBuilder().startObject();
            plugins.add(MockCommitterEnginePlugin.class);
import org.junit.Before;
                doc.add(new StoredField(FIELD_NAME, "default_value"));
import org.apache.lucene.index.DirectoryReader;  
    private IndexService indexService;  
            .startObject()  
            .mappers()
                () -> createIndexWithSimpleMappings("test-pluggable", indexSettings.build(), "field", "type=constant_keyword,value=foo")
import org.opensearch.common.xcontent.json.JsonXContent;
        assertNotNull(mapper);
 * The OpenSearch Contributors require contributions made to  
            .startObject("field2")  
        xContentBuilder.endObject();  
    }
import org.apache.lucene.index.IndexWriter;
            .mappers()
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;  
            .documentMapper()
        // Test via document parse — valid value should succeed
            return;
public class ConstantKeywordFieldMapperTests extends OpenSearchSingleNodeTestCase {
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
                "failed to parse field [field] of type [constant_keyword] in document with id '1'. Preview of field's value: 'sdf'"  
        final IndexableField field = doc.rootDoc().getField("field");  
            .startObject("field2")
import java.util.Collection;  
import org.opensearch.common.xcontent.XContentFactory;
    public void testPossibleToDeriveSource_WhenCopyToPresent() {
 */  
        ConstantKeywordFieldMapper mapper = getMapper(copyTo);
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.util.ArrayList;
        return new SourceToParse("test", "1", BytesReference.bytes(builder), MediaTypeRegistry.JSON);
            }
            try (DirectoryReader reader = DirectoryReader.open(directory)) {  
            () -> parser.parse("type", new CompressedXContent(mapping.toString()))  
    }  
    public void testDerivedValueFetching() throws IOException {
 *
        // calling directly since it's protected and same package
import org.opensearch.OpenSearchParseException;
            .parse(
import org.apache.lucene.index.IndexWriterConfig;
        mapping = mapping.endObject().endObject().endObject();
            b.field("field2", "szdfvsddf");
            .field("value", "default_value")  
                builder.endObject();  
        ConstantKeywordFieldMapper mapper = (ConstantKeywordFieldMapper) indexService.mapperService()  
    }
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
        // only in the plugin-free run.
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
}  
import org.opensearch.common.compress.CompressedXContent;
    }  
import org.opensearch.test.InternalSettingsPlugin;  
        return mapper;
            );
            ConstantKeywordFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty());
        indexService = createIndexWithSimpleMappings("test-pluggable", indexSettings.build(), "field", "type=constant_keyword,value=foo");
            b.field("field2", "field_2_value");  
            MapperParsingException e = expectThrows(
    public void testBuilderToXContent() throws IOException {
    protected Collection<Class<? extends Plugin>> getPlugins() {
        final ParsedDocument doc = mapper.parse(source(b -> {
/*  
            .endObject()
        assertEquals("{\"value\":\"value1\"}", xContentBuilder.toString());
import org.opensearch.core.common.bytes.BytesReference;  
            .endObject()
                new MockDocumentInput()  
import java.util.List;
        assertNull(field);  
            .startObject("properties")
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
        indexService = createIndexWithSimpleMappings("test-index", Settings.EMPTY, "field", "type=constant_keyword,value=default_value");
    private ConstantKeywordFieldMapper getMapper(FieldMapper.CopyTo copyTo) {
        XContentBuilder builder = JsonXContent.contentBuilder().startObject();
    }
        ConstantKeywordFieldMapper mapper = (ConstantKeywordFieldMapper) indexService.mapperService()  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.index.IndexableField;  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            .endObject();
import org.opensearch.common.CheckedConsumer;  
            b.field("field", "default_value");
        // delete engine (each of which the node permits exactly one of), so the in-memory mocks are registered  
            .startObject("field")  
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "foo").endObject()),  
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
