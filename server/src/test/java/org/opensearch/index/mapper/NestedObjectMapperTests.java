                .startObject("messages")
            .field("include_in_root", true)
                ),
        assertThat(doc.docs().get(0).get("nested1.nested2.field2"), equalTo("2"));
                }
                .startObject("comments")
            .toString();
    }
                .mapperService()
        assertThat(doc.docs().get(0).get("nested1.nested2.field2"), equalTo("2"));
                        .field("foo", "bar")
                + "] index level setting.",
                    XContentFactory.jsonBuilder()
        assertThat(doc.docs().get(0).get("field"), nullValue());
            .merge("type", new CompressedXContent(mapping.apply("type")), MergeReason.MAPPING_RECOVERY);
                        .endObject()
                        .endArray()
                        .endObject()
        assertThat(doc.docs().get(2).get("field"), nullValue());
            .startObject("type")
                        .field("field", "value")
        createIndex("test4", Settings.builder().put(MapperService.INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING.getKey(), 0).build())
        assertThat(doc.docs().size(), equalTo(1));
        XContentBuilder docBuilder2 = XContentFactory.jsonBuilder();
        String mapping1 = XContentFactory.jsonBuilder()
                MediaTypeRegistry.JSON
            new SourceToParse(
            .parse("type", new CompressedXContent(mapping));
            .endObject()
        String mapping = XContentFactory.jsonBuilder()
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").nullField("nested1").endObject()),
                        .field("field", "value")
                        .startObject()
        // setting limit to allow only two nested objects in the whole doc
     * redundancy, only the merged mapping does.
        // cannot update `include_in_root` dynamically
            }
        assertThat(doc.docs().get(5).get("field"), nullValue());
            .startObject()
                docBuilder.startObject().field("field1", "21").field("field2", "22").endObject();
                    .endObject()
    protected Collection<Class<? extends Plugin>> getPlugins() {
        ObjectMapper nested1Mapper = docMapper.objectMappers().get("nested1");
        DocumentMapper docMapper = mapperService.documentMapper();
    }
        {
                        .endObject()
                        .endArray()
            .toString();
                        .startObject()
            .endObject()
        assertThat(nested2Mapper.nested().isIncludeInRoot(), equalTo(false));
            () -> createIndex("test3", Settings.builder().put(MapperService.INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING.getKey(), 1).build())
                    .toString();
                        .endArray()
                        .startArray("nested1")
     * {@code false} and {@code include_in_root} set to {@code true}.
            .startObject(MapperService.SINGLE_MAPPING_NAME)
                + MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.getKey()
                docBuilder2.startObject().field("field1", "13").field("field2", "23").endObject();
/*
                .mapperService()
import static org.hamcrest.Matchers.nullValue;
            )
            new SourceToParse(
                .startObject("properties")
            Settings.EMPTY,
            .startObject("nested2")
        assertThat(nested1Mapper.nested().isIncludeInRoot(), equalTo(false));
                        .startObject()
            .toString();
            .endObject()
        assertThat(doc.docs().get(2).get("nested1.nested2.field2"), nullValue());
            .toString();
    }
        assertThat(doc.docs().get(0).get("field"), nullValue());
                + "]. This limit can be set by changing the ["
                        .endArray()
            new SourceToParse(
                BytesReference.bytes(
                MediaTypeRegistry.JSON
        );
import static org.hamcrest.Matchers.equalTo;
            .startObject("properties")
            .endObject()
                ),
                        .startObject()
                MediaTypeRegistry.JSON
            .field("include_in_root", true)
            .endObject()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .endObject()
            .field("type", "nested")
        assertThat(doc.docs().get(3).get("nested1.nested2.field2"), equalTo("5"));
                    .startObject("nested1")
                        .endObject()
        assertThat(doc.docs().get(6).get("nested1.field1"), nullValue());
            new SourceToParse(
        doc = docMapper.parse(
        ObjectMapper nested1Mapper = docMapper.objectMappers().get("nested1");
                        .field("field", "value")
            jsonBuilder().startObject()
            .startObject("nested2")
                        .field("field1", "4")
        String mapping = XContentFactory.jsonBuilder()
        XContentBuilder docBuilder = XContentFactory.jsonBuilder();
        ObjectMapper nested2Mapper = docMapper.objectMappers().get("nested1.nested2");
            }
            .field("type", "nested")
            docBuilder.endArray();
            .startObject("nested2")
        assertThat(doc.docs().get(5).get("field"), nullValue());
        assertThat(nested2Mapper.nested().isNested(), equalTo(true));
            )
                        .startObject()
            docBuilder.startArray("nested1");
            .parse("type", new CompressedXContent(mapping));
                        .endObject()
            .endObject()
            "index1",
            .startObject()
        assertThat(doc.docs().get(1).get("field"), nullValue());
                        .field("field", "value")
        assertThat(doc.docs().get(0).get("nested1.nested2.field2"), equalTo("2"));
        assertThat(nested1Mapper.nested().isIncludeInRoot(), equalTo(false));
                        .endObject()
                BytesReference.bytes(
        assertThat(doc.docs().get(4).get("nested1.nested2.field2"), equalTo("6"));
        assertThat(fields.size(), equalTo(new HashSet<>(fields).size()));
        String secondMapping = XContentFactory.jsonBuilder()
        assertThat(doc.docs().get(5).get("nested1.field1"), equalTo("4"));
        docBuilder2.startObject();
            .field("type", "nested")
            .endObject()
        ParsedDocument doc = docMapper.parse(
        {
        );
                        .field("field2", "6")
            .endObject()
                        .startArray("nested1")
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> docMapper.parse(source1));
            .startObject("nested1")
                BytesReference.bytes(
        MapperService mapperService = createIndex(
        );
                        .startArray("nested2")
    public void testLimitNestedDocsMultipleNestedFields() throws Exception {
                        .endArray()
                        .endObject()
            .endObject()
            () -> createIndex("test2", Settings.builder().put(MapperService.INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING.getKey(), 0).build())
import java.io.IOException;
        );
        XContentBuilder docBuilder = XContentFactory.jsonBuilder();
        assertThat(docMapper.hasNestedObjects(), equalTo(true));
                        .startObject()
                .field("type", "nested")
import org.opensearch.common.settings.Settings;
            .field("type", "nested")
                + MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.getKey()
                ),
            .endObject()
        doc = docMapper.parse(
                "1",
            .startObject("properties")
package org.opensearch.index.mapper;
            .toString();
            .startObject("field1")
                "test",
        MapperException e1 = expectThrows(
            )
                        .startObject()
                + "]. This limit can be set by changing the ["
        assertThat(doc.docs().get(0).get("nested1.field2"), equalTo("2"));
                        .startArray("nested1")
            .startObject("type")
        assertThat(doc.docs().get(1).get(NestedPathFieldMapper.NAME), equalTo(nested1Mapper.nestedTypePath()));
            .toString();
        final Collection<IndexableField> fields = doc.rootDoc().getFields();
        XContentBuilder docBuilder = XContentFactory.jsonBuilder();
        assertThat(nested2Mapper.nested().isIncludeInParent(), equalTo(false));
                BytesReference.bytes(
                        .startObject()
                        .startArray("nested2")
 * You may obtain a copy of the License at
                ),
                        .startObject()
            .endObject()
        );
            .startObject()
        assertThat(doc.docs().get(4).get("nested1.nested2.field2"), equalTo("6"));
            .endObject()
        DocumentMapper docMapper = createIndex("test").mapperService()
        long maxNoNestedDocs = 2L;
        assertThat(doc.docs().get(2).get("nested1.field1"), equalTo("1"));
                "1",
                .endObject()
            )
                        .endObject()
                    .endObject()
        assertThat(doc.docs().get(6).get("nested1.field1"), nullValue());
        ).mapperService();
            .startObject("nested1")
        ParsedDocument doc = docMapper.parse(
 * specific language governing permissions and limitations
            .endObject()
        {
                + maxNoNestedDocs
    }
            .startObject("properties")
            .endObject()
                        .startObject()
                    XContentFactory.jsonBuilder()
        MapperService mapperService = createIndex(
        ParsedDocument doc = docMapper.parse(
                BytesReference.bytes(
        DocumentMapper docMapper = mapperService.documentMapperParser().parse("type", new CompressedXContent(mapping));
            docBuilder2.startArray("nested1");
            .endObject()
        };
                        .startObject()
        MapperService mapperService = createIndex(
        assertThat(e.getMessage(), containsString("Limit of nested fields [1] has been exceeded"));
        }
                        .field("field2", "2")
            .startObject("nested1")
        assertThat(doc.docs().get(1).get("field"), nullValue());
            "test1",
}
            new SourceToParse(
                        .endObject()
 * under the License.
            .field("include_in_root", true)
        assertThat(doc.docs().get(1).get("nested1.field1"), nullValue());
        ParsedDocument doc = docMapper.parse(
            .endObject()
 *
            .field("type", "nested")
        );
                        .startObject()
                        .startArray("nested1")
            IllegalArgumentException.class,
        String mapping = XContentFactory.jsonBuilder()
            MapperException.class,
            "index1",
            .startObject("type")
     */
        DocumentMapper docMapper = createIndex("test").mapperService()
            .endObject()
            .field("include_in_parent", true)
                    XContentFactory.jsonBuilder()
        assertThat(doc.docs().size(), equalTo(3));
        // parsing a doc with 3 nested objects fails
    /**
                + "] index level setting.",
                        .startArray("nested1")
                        .startObject()
        assertThat(doc.docs().get(1).get("field"), nullValue());
                BytesReference.bytes(
        assertThat(doc.docs().size(), equalTo(7));
        assertThat(doc.docs().size(), equalTo(7));
        assertThat(nested1Mapper.nested().isNested(), equalTo(true));
            .field("type", "text")
        assertThat(doc.docs().get(0).get("nested1.nested2.field2"), equalTo("2"));
                        .field("field2", "3")
                        .endObject()
            .endObject()
            .field("include_in_root", true)
            docBuilder.startArray("nested2");
                        .startObject()
            .endObject()
            .endObject()
                BytesReference.bytes(
                        .field("foo", "bar")
            .endObject()
        SourceToParse source1 = new SourceToParse("test1", "1", BytesReference.bytes(docBuilder), MediaTypeRegistry.JSON);
            {
                        .startArray("nested2")
        assertThat(doc.docs().get(6).getFields("nested1.nested2.field2").length, equalTo(4));
            .endObject()
        );
        );
        ObjectMapper nested2Mapper = docMapper.objectMappers().get("nested1.nested2");
            .startObject("nested1")
        assertThat(doc.docs().get(4).get("field"), nullValue());
        assertThat(doc.docs().get(4).get("nested1.nested2.field2"), equalTo("6"));
                        .endObject()
        assertThat(nested2Mapper.nested().isNested(), equalTo(true));
            .endObject()
                + maxNoNestedDocs
                        .endObject()
                MediaTypeRegistry.JSON
                    .endObject()
            .documentMapperParser()
                        .startArray("nested2")
            .endObject()
        ParsedDocument doc = docMapper.parse(
                        .startObject()
        String mapping = XContentFactory.jsonBuilder()
                throw new UncheckedIOException(e);
                "test",
            .endObject()
                ),
                MediaTypeRegistry.JSON
                        .endObject()
            docBuilder.endArray();
            .startObject("properties")
            .endObject()
                        .endArray()
            .endObject()
                "test",
            new SourceToParse(
import java.util.Collection;
        /*
                .startObject("comments")
        assertThat(doc.docs().get(5).get("nested1.nested2.field2"), nullValue());
    }
            .startObject("properties")
            .startObject("type")
                + "] index level setting.",
            docBuilder.endArray();
            .startObject("properties")
        assertThat(doc.docs().size(), equalTo(3));
 * Licensed to Elasticsearch under one or more contributor
        assertThat(doc.docs().get(5).get("nested1.field1"), equalTo("4"));
    public void testParentObjectMapperAreNested() throws Exception {
            .documentMapperParser()
                        .startArray("nested1")
            "The number of nested documents has exceeded the allowed limit of ["
            docBuilder2.endArray();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            () -> mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping1), MergeReason.MAPPING_UPDATE)
                "test",
            .field("type", "nested")
            .endObject()
            .startObject("type")
                        .endObject()
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .startObject("properties")
    public void testEmptyNested() throws Exception {
        assertThat(doc.docs().get(3).get("nested1.nested2.field2"), equalTo("5"));
                "test",
        assertThat(doc.docs().get(1).get("nested1.field2"), equalTo("4"));
        DocumentMapper docMapper = createIndex("test").mapperService()
        MapperService mapperService = createIndex("test1", settings).mapperService();
            .endObject()
            .toString();
import org.opensearch.plugins.Plugin;
        );
                    .field("type", "nested")
                "1",
            .toString();
            .endObject()
                docBuilder2.startObject().field("field1", "12").field("field2", "22").endObject();
            .field("type", "nested")
            .endObject()
                BytesReference.bytes(
        // parsing a doc with 3 nested objects fails
            .toString();
        assertThat(doc.docs().get(3).get("field"), nullValue());
        {
                "1",
        assertThat(doc.docs().get(6).getFields("nested1.nested2.field2").length, equalTo(4));
        assertThat(nested2Mapper.nested().isIncludeInParent(), equalTo(true));
                BytesReference.bytes(
                docBuilder2.startObject().field("field1", "12").field("field2", "22").endObject();
            .endObject()
public class NestedObjectMapperTests extends OpenSearchSingleNodeTestCase {
            }
                        .startArray("nested2")
            .field("type", "nested")
        assertThat(docMapper.hasNestedObjects(), equalTo(true));
                    .endObject()
            .toString();
 * this file be licensed under the Apache-2.0 license or a
            .endObject()
                    .field("type", "nested")
                + defaultMaxNoNestedDocs
        );
                "test",
                MediaTypeRegistry.JSON
            .endObject()
        assertThat(nested1Mapper.nested().isNested(), equalTo(true));
        // setting limit to allow only two nested objects in the whole doc
            .startObject("nested2")
 * Unless required by applicable law or agreed to in writing,
                    docBuilder.startObject().field("f", i).endObject();
                        .endObject()
                        .endArray()
            .startObject()
            } catch (IOException e) {
        );
            .startObject()
        Function<String, String> mapping = type -> {
            jsonBuilder().startObject()
        assertThat(nested1Mapper.nested().isNested(), equalTo(true));
        assertThat(doc.docs().get(6).get("field"), equalTo("value"));
                docBuilder2.startObject().field("field1", "11").field("field2", "21").endObject();
 * KIND, either express or implied.  See the License for the
            .endObject()
            .endObject()
            .endObject()
            .startObject("properties")
                        .startObject()
                        .endArray()
 * ownership. Elasticsearch licenses this file to you under
     * Same as {@link NestedObjectMapperTests#testMultipleLevelsIncludeRoot1()} but tests that
            .startObject("nested1")
        assertThat(doc.docs().get(2).get("nested1.field1"), equalTo("1"));
                        .endObject()
            .toString();
        DocumentMapper docMapper = createIndex("test").mapperService()
            .endObject()
            .field("include_in_parent", true)
            Settings.EMPTY,
     * Checks that multiple levels of nested includes where a node is both directly and transitively
            e.getMessage()
            .startObject("type")
                        .field("field1", "1")
        docBuilder.endObject();
        assertThat(docMapper.hasNestedObjects(), equalTo(true));
            "The number of nested documents has exceeded the allowed limit of ["
            .startObject("nested1")
                "test",
            .field("type", "nested")
        assertThat(nested2Mapper.nested().isIncludeInParent(), equalTo(false));
        assertThat(doc.docs().get(5).get("field"), nullValue());
            .endObject()
 */
        SourceToParse source2 = new SourceToParse("test1", "2", BytesReference.bytes(docBuilder2), MediaTypeRegistry.JSON);
        DocumentMapper docMapper = createIndex("test").mapperService()
        assertThat(doc.docs().get(0).get(NestedPathFieldMapper.NAME), equalTo(nested1Mapper.nestedTypePath()));
        DocumentMapper docMapper = createIndex("test").mapperService()
            .endObject()
            .field("include_in_root", true)
            .field("include_in_parent", true)
                .endObject()
                        .startArray("nested2")
            .field("type", "nested")
                        .endObject()
        );
            () -> mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping2), MergeReason.MAPPING_UPDATE)
 */
                        .startObject()
                .endObject()
    }
            Settings.builder().put(MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.getKey(), maxNoNestedDocs).build()
        // parsing a doc with 2 nested objects succeeds
                        .field("field2", "2")
            .endObject()
        MapperService mapperService = createIndex("test").mapperService();
            .endObject()
            .endObject()
            .endObject()
        assertThat(doc.docs().get(2).get("nested1.nested2.field2"), equalTo("2"));
            .startObject("type")
            .startObject("nested2")
        assertThat(doc.docs().get(0).get("nested1.field2"), equalTo("2"));
            .field("type", "nested")
        assertThat(doc.docs().get(0).get("nested1.field1"), equalTo("1"));
        assertThat(nested2Mapper.nested().isIncludeInRoot(), equalTo(true));
     * root by a chain of {@code include_in_parent}, i.e. that has {@code include_in_parent} set to
        docBuilder.endObject();
                        .startObject()
        );
            .startObject("nested1")
            .field("type", "nested")
                    .startObject(type)
        assertThat(doc.docs().get(0).get("nested1.field1"), nullValue());
            new SourceToParse(
                        .field("field2", "3")
        assertThat(doc.docs().get(4).get("nested1.nested2.field2"), equalTo("6"));
            e.getMessage()
            }
        assertThat(doc.docs().get(1).get("field"), nullValue());
    public void testMultiObjectAndNested2() throws Exception {
            .endObject()
                .field("type", "object")
                MediaTypeRegistry.JSON
                        .endArray()
    public void testMultipleLevelsIncludeRoot1() throws Exception {
                return XContentFactory.jsonBuilder()
        assertThat(doc.docs().get(6).get("nested1.nested2.field2"), nullValue());
                .endObject()
/*
    }
                    .startObject()
            new SourceToParse(
                        .endObject()
        assertThat(docMapper.hasNestedObjects(), equalTo(true));
            .startObject("properties")
                "1",
        assertThat(doc.docs().get(1).get("nested1.nested2.field2"), equalTo("3"));
        assertThat(doc.docs().get(6).get("nested1.field1"), nullValue());
    public void testMultiNested() throws Exception {
            .startObject("nested1")
                    XContentFactory.jsonBuilder()
        docBuilder2.endObject();
                        .startObject()
                .endObject()
            .field("type", "nested")
            .documentMapperParser()
                        .field("field2", "2")
                        .startObject()
                .merge("type", new CompressedXContent(mapping.apply("type")), MergeReason.MAPPING_UPDATE)
            .endObject()
            .startObject("nested2")
        assertThat(nested2Mapper.nested().isIncludeInRoot(), equalTo(false));
            .startObject("properties")
                        .field("field2", "2")
                ),
                        .endArray()
                        .startObject()
            .parse("type", new CompressedXContent(mapping));
            .toString();
                        .endArray()
                docBuilder.startObject().field("field1", "11").field("field2", "21").endObject();
        assertThat(doc.docs().get(6).get("field"), equalTo("value"));
            .field("type", "nested")
import org.opensearch.test.InternalSettingsPlugin;
        );
            .startObject("nested1")
                        .endArray()
        ParsedDocument doc = docMapper.parse(
        assertThat(doc.docs().size(), equalTo(1));
                "1",
        DocumentMapper docMapper = mapperService.documentMapper();
            .startObject("properties")
            .documentMapperParser()
                        .endObject()
            jsonBuilder().startObject()
                        .startObject()
    /**
        SourceToParse source2 = new SourceToParse("test1", "2", BytesReference.bytes(docBuilder2), MediaTypeRegistry.JSON);
            docBuilder.startArray("nested1");
        assertThat(nested2Mapper.nested().isNested(), equalTo(true));
                .endObject()
                        .field("field1", "1")
            .endObject()
            .endObject()
                        .startObject()
        DocumentMapper docMapper = mapperService.documentMapperParser().parse("type", new CompressedXContent(mapping));
    public void testMultipleLevelsIncludeRoot2() throws Exception {
 *
            .startObject("nested1")
                ),
                        .startObject()
                    .startObject("properties")
                "test",
            )
            MapperException.class,
        assertThat(fields.size(), equalTo(new HashSet<>(fields).size()));
 * not use this file except in compliance with the License.
            )
            .endObject()
                        .field("field1", "4")
            .endObject()
                        .endArray()
        assertThat(doc.docs().get(1).get("field"), equalTo("value"));
            new SourceToParse(
            .startObject("properties")
                .startObject("properties")
                        .startObject()
            docBuilder.endArray();
            .endObject()
        mapperService = createIndex(
            .field("include_in_root", true)
            try {
            .endObject()
    }
                    XContentFactory.jsonBuilder()
        assertThat(doc.docs().get(1).get("nested1.field1"), nullValue());
                        .field("field2", "6")
            .endObject()
        ObjectMapper nested1Mapper = docMapper.objectMappers().get("nested1");
        ParsedDocument doc = docMapper.parse(
                ),
                        .endObject()
        assertThat(doc.docs().get(4).get("field"), nullValue());
        // parsing a doc with 2 nested objects succeeds
        );
                        .endArray()
    }
            .startObject("properties")
        return false;
        assertThat(doc.docs().size(), equalTo(7));
            .endObject()
    public void testLimitOfNestedFieldsPerIndex() throws Exception {
     */
        assertThat(doc.docs().get(6).get("nested1.nested2.field2"), nullValue());
        assertThat(nested1Mapper.nested().isIncludeInParent(), equalTo(false));
                        .endObject()
                .endObject()
        );
            .endObject()
    public void testMultiRootAndNested1() throws Exception {
            .startObject("nested1")
    public void testLimitNestedDocs() throws Exception {
 *
                    .endObject()
            e.getMessage()
            .field("include_in_parent", true)
            .startObject("properties")
        Exception e = expectThrows(
        assertThat(e.getMessage(), containsString("Limit of nested fields [0] has been exceeded"));
                        .field("field1", "1")
                        .endObject()
                    .endObject()
                        .endObject()
            .endObject()
     * Same as {@link NestedObjectMapperTests#testMultipleLevelsIncludeRoot1()} but tests for the
            .field("type", "nested")
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> docMapper.parse(source2));
                        .endArray()
            .endObject()
            "test1",
        assertTrue(objectMapper.parentObjectMapperAreNested(mapperService));
                        .endObject()
        DocumentMapper docMapper = mapperService.documentMapperParser().parse("type", new CompressedXContent(mapping));
                        .endObject()
                    XContentFactory.jsonBuilder()
            .field("dynamic", "strict")
            .field("include_in_parent", false)
        return Collections.singleton(InternalSettingsPlugin.class);
        assertThat(nested2Mapper.nested().isNested(), equalTo(true));
        DocumentMapper docMapper = createIndex("test").mapperService()
            .parse("type", new CompressedXContent(mapping));
        final Collection<IndexableField> fields = doc.rootDoc().getFields();
        assertThat(doc.docs().get(2).get("field"), equalTo("value"));
            .startObject(MapperService.SINGLE_MAPPING_NAME)
        // do not check nested fields limit if mapping is not updated
                    .startObject("nested2")
                        .field("field2", "5")
                .endObject()
            )
 * GitHub history for details.
            .field("type", "nested")
                        .field("field", "value")
        docBuilder.startObject();
        ObjectMapper nested1Mapper = docMapper.objectMappers().get("nested1");
        assertThat(doc.docs().get(1).get("nested1.field1"), nullValue());
        assertThat(doc.docs().get(5).get("nested1.nested2.field2"), equalTo("5"));
            .endObject()
            "The number of nested documents has exceeded the allowed limit of ["
            .startObject("properties")
                        .field("field1", "4")
                        .startArray("nested2")
                docBuilder2.startObject().field("field1", "11").field("field2", "21").endObject();
                        .endObject()
        assertThat(doc.docs().get(2).get("nested1.field1"), equalTo("1"));
        createIndex("test1").mapperService().merge("type", new CompressedXContent(mapping.apply("type")), MergeReason.MAPPING_UPDATE);
        assertThat(nested1Mapper.nested().isIncludeInParent(), equalTo(false));
        }
        assertThat(nested1Mapper.nested().isNested(), equalTo(true));
                MediaTypeRegistry.JSON
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(secondMapping), MergeReason.INDEX_TEMPLATE);
        // default limit allows at least two nested fields
            .startObject(MapperService.SINGLE_MAPPING_NAME)
        assertThat(doc.docs().get(0).get("nested1.field1"), nullValue());
            .endObject()
                        .field("foo", "bar")
        MapperService mapperService = createIndex("test").mapperService();
        );
        assertThat(doc.docs().get(0).get(NestedPathFieldMapper.NAME), equalTo(nested1Mapper.nestedTypePath()));
                        .endObject()
                        .startObject()
        objectMapper = mapperService.getObjectMapper("comments.messages");
            .endObject()
        assertThat(doc.docs().get(5).get("nested1.field1"), equalTo("4"));
                "1",
                        .startArray("nested2")
    }
        assertThat(doc.docs().get(0).get("nested1.field1"), equalTo("1"));
    @Override
    }
                    XContentFactory.jsonBuilder()
                        .startObject()
        assertThat(doc.docs().get(6).get("field"), equalTo("value"));
            }
        docBuilder2.startObject();
                        .endObject()
    public void testMultiObjectAndNested1() throws Exception {
                        .field("field2", "5")
          This is needed to force the index version with {@link IndexMetadata.SETTING_INDEX_VERSION_CREATED}.
        ).mapperService();
        assertThat(fields.size(), equalTo(new HashSet<>(fields).size()));
                        .field("field1", "1")
                        .startObject("nested1")
                        .field("field2", "5")
        docBuilder.endObject();
    @Override
                docBuilder.startObject().field("field1", "11").field("field2", "21").endObject();
                        .field("field2", "4")
            .field("type", "nested")
            .startObject()
        e = expectThrows(
        assertThat(nested1Mapper.nested().isIncludeInParent(), equalTo(true));
                        .endObject()
                        .startObject()
            docBuilder2.startArray("nested1");
                        .startObject()
            .field("type", "nested")
            docBuilder.startArray("nested1");
    public void testMultipleLevelsIncludeRootWithMerge() throws Exception {
            .toString();
        assertThat(nested2Mapper.nested().isIncludeInRoot(), equalTo(false));
        assertThat(doc.docs().size(), equalTo(2));
                        .startObject()
            .startObject()
            Settings.builder().put(MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.getKey(), maxNoNestedDocs).build()
            .parse("type", new CompressedXContent(mapping));
        assertThat(doc.docs().get(3).get("field"), nullValue());
            .parse("type", new CompressedXContent(mapping));
            {
                        .field("field2", "6")
                        .startArray("nested1")
        ParsedDocument doc = docMapper.parse(
            .field("type", "nested")
                        .field("field", "value")
            .startObject("nested1")
        assertThat(doc.docs().get(0).get("field"), nullValue());
                "test",
import org.opensearch.index.mapper.ObjectMapper.Dynamic;
            .startObject()
            .startObject("properties")
        assertThat(nested1Mapper.nested().isIncludeInRoot(), equalTo(false));
        assertThat(doc.docs().get(0).get("nested1.field1"), equalTo("1"));
            {
                ),
        ParsedDocument doc = docMapper.parse(
                "1",
                        .field("field2", "2")
                        .startArray("nested2")
        assertThat(doc.docs().get(3).get("nested1.nested2.field2"), equalTo("5"));
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> docMapper.parse(source2));
            .startObject(MapperService.SINGLE_MAPPING_NAME)
                        .endObject()
        ObjectMapper objectMapper = mapperService.getObjectMapper("comments.messages");
                        .endObject()
                        .endObject()
            .field("type", "nested")
        }
                        .field("field2", "2")
     * the redundant includes are removed even if each individual mapping doesn't contain the
        DocumentMapper docMapper = mapperService.documentMapper();
        assertThat(doc.docs().get(2).get("field"), nullValue());
                "test",
            .field("include_in_parent", true)
    }
        // cannot update `include_in_parent` dynamically
        ).mapperService();
                        .startObject()
            .startObject("nested1")
                + "]. This limit can be set by changing the ["
            Settings.EMPTY,
                docBuilder2.startObject().field("field1", "13").field("field2", "23").endObject();
        docBuilder.startObject();
                        .endObject()
                    XContentFactory.jsonBuilder().startObject().field("field", "value").startArray("nested").endArray().endObject()
            .startObject("properties")
                        .endObject()
        assertEquals(
            )
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), mergeReason);
                        .endObject()
        }
            .parse("type", new CompressedXContent(mapping));
        assertThat(doc.docs().get(4).get("field"), nullValue());
            docBuilder2.endArray();
                    XContentFactory.jsonBuilder()
                "1",
                MediaTypeRegistry.JSON
            .startObject("properties")
            .field("include_in_parent", true)
                        .startArray("nested1")
                        .endArray()
        assertThat(doc.docs().get(2).get("nested1.field1"), equalTo("1"));
        ParsedDocument doc = docMapper.parse(source1);
                        .endArray()
    public void testNestedArrayStrict() throws Exception {
            .endObject()
        assertFalse(objectMapper.parentObjectMapperAreNested(mapperService));
                BytesReference.bytes(
        ParsedDocument doc = docMapper.parse(
    protected boolean forbidPrivateIndexSettings() {
                        .endObject()
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        long defaultMaxNoNestedDocs = MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.get(settings);
            .endObject()
                        .endObject()
import org.opensearch.core.common.bytes.BytesReference;
            .field("type", "nested")
        XContentBuilder docBuilder2 = XContentFactory.jsonBuilder();
        assertThat(doc.docs().get(1).get("field"), nullValue());
            .endObject()
            .toString();
     * happen on a chain of nodes that starts from a parent node that is not directly connected to
        assertThat(doc.docs().get(0).get("field"), nullValue());
        assertThat(nested1Mapper.nested().isIncludeInRoot(), equalTo(false));
        String mapping = XContentFactory.jsonBuilder()
        MergeReason mergeReason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);
            .field("include_in_root", true)
        assertThat(doc.docs().get(6).get("field"), equalTo("value"));
import org.opensearch.core.xcontent.XContentBuilder;
    }
                        .startObject()
                .endObject()
                        .startObject()
            .endObject()
            .startObject("type")
                        .startObject()
            )
        assertThat(doc.docs().size(), equalTo(7));
            )
            {
            .startObject(MapperService.SINGLE_MAPPING_NAME)
            {
import org.apache.lucene.index.IndexableField;
                        .startObject()
        final Collection<IndexableField> fields = doc.rootDoc().getFields();
                        .endArray()
        );
 */
            .startObject()
                        .field("field2", "6")
                    XContentFactory.jsonBuilder()
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), mergeReason);
    public void testLimitNestedDocsDefaultSettings() throws Exception {
import java.util.HashSet;
            {
            .field("include_in_root", true)
        assertThat(docMapper.hasNestedObjects(), equalTo(true));
                        .endObject()
    public void testMergeNestedMappings() throws IOException {
            .toString();
        assertThat(doc.docs().get(0).get("nested1.field1"), nullValue());
            .startObject("properties")
            .field("include_in_parent", true)
                        .field("field1", "3")
 * SPDX-License-Identifier: Apache-2.0
        ParsedDocument doc = docMapper.parse(source1);
            .documentMapperParser()
        ).mapperService();
        MapperService mapperService = createIndex("test").mapperService();
        assertThat(doc.docs().get(5).get("nested1.field1"), equalTo("4"));
        );
        assertThat(doc.docs().get(3).get("field"), nullValue());
                        .startObject()
            .field("type", "nested")
 * The OpenSearch Contributors require contributions made to
                        .field("field1", "1")
        // parsing a doc with No. nested objects > defaultMaxNoNestedDocs fails
                        .endObject()
                "test",
 * this work for additional information regarding copyright
            .endObject()
                .field("type", "nested")
import java.io.UncheckedIOException;
            new SourceToParse(
        ObjectMapper nested2Mapper = docMapper.objectMappers().get("nested1.nested2");
        assertThat(nested1Mapper.nested().isIncludeInParent(), equalTo(false));
        assertThat(doc.docs().get(6).getFields("nested1.field1").length, equalTo(2));
     * case where the transitive {@code include_in_parent} and redundant {@code include_in_root}
        assertThat(doc.docs().size(), equalTo(3));
                        .startArray("nested2")
import java.util.function.Function;
            .startObject("properties")
import static org.hamcrest.Matchers.containsString;
            .startObject("nested2")
                        .field("field1", "1")
        assertThat(doc.docs().get(2).get("nested1.nested2.field2"), equalTo("2"));
        assertThat(doc.docs().get(2).get("field"), nullValue());
                        .endObject()
import org.opensearch.index.mapper.MapperService.MergeReason;
            .endObject()
        {
            .endObject()
            .field("include_in_root", true)
            .endObject()
                        .startObject()
 * software distributed under the License is distributed on an
                        .startObject()
                "test",
        ObjectMapper nested2Mapper = docMapper.objectMappers().get("nested1.nested2");
            }
    }
            .startObject("properties")
                        .startObject()
            .field("type", "nested")
            .endObject()
                        .startObject()
        Settings settings = Settings.builder().build();
        docBuilder2.endObject();
        assertEquals("the [include_in_parent] parameter can't be updated on a nested object mapping", e1.getMessage());
            new SourceToParse(
            .startObject("nested1")
            .startObject()
        assertThat(doc.docs().get(1).get("nested1.field1"), equalTo("3"));
            .endObject()
                        .endObject()
            .startObject()
    }
                        .startArray("nested3")
        MapperService mapperService = createIndex(
        assertThat(doc.docs().get(4).get("field"), nullValue());
                .endObject()
                        .endArray()
        assertThat(doc.docs().get(0).get("nested1.field1"), nullValue());
import org.opensearch.common.compress.CompressedXContent;
 *     http://www.apache.org/licenses/LICENSE-2.0
            .field("include_in_root", true)
        SourceToParse source1 = new SourceToParse("test1", "1", BytesReference.bytes(docBuilder), MediaTypeRegistry.JSON);
            .startObject("properties")
                MediaTypeRegistry.JSON
        assertThat(doc.docs().get(5).get("nested1.nested2.field2"), nullValue());
                .endObject()
            )
        assertThat(doc.docs().get(1).get("nested1.nested2.field2"), equalTo("3"));
                ),
        String mapping2 = XContentFactory.jsonBuilder()
/*
         */
        assertThat(doc.docs().get(0).get("field"), nullValue());
                        .field("field1", "1")
            .startObject()
        // setting limit to 1 with 2 nested fields fails
            .endObject()
                        .field("field2", "5")
                        .field("field2", "3")
        String mapping = XContentFactory.jsonBuilder()
        // explicitly setting limit to 0 prevents nested fields
            )
                MediaTypeRegistry.JSON
            .startObject("properties")
        docBuilder.startObject();
            .endObject()
        MergeReason mergeReason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);
            IllegalArgumentException.class,
            .mapperService()
        }
        assertThat(doc.docs().get(1).get("nested1.nested2.field2"), equalTo("3"));
            .documentMapperParser()
                        .startObject()
            .field("include_in_parent", true)
                .startObject("nested1")
            "index2",
            docBuilder2.startArray("nested2");
                .field("type", "nested")
                docBuilder.startObject().field("field1", "12").field("field2", "22").endObject();
        assertThat(docMapper.hasNestedObjects(), equalTo(true));
            .endObject()
            .startObject("type")
        assertThat(doc.docs().get(5).get("field"), nullValue());
        assertThat(doc.docs().get(2).get("nested1.nested2.field2"), nullValue());
    }
     */
            .endObject()
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(firstMapping), MergeReason.INDEX_TEMPLATE);
            {
            .startObject("nested2")
                        .startObject()
        assertThat(doc.docs().get(2).get("field"), nullValue());
            .field("include_in_parent", true)
                "1",
        String mapping = XContentFactory.jsonBuilder()
                .field("type", "nested")
import java.util.Collections;
                BytesReference.bytes(
        ObjectMapper nested1Mapper = docMapper.objectMappers().get("nested1");
     * included in root by {@code include_in_root} and a chain of {@code include_in_parent} does not
     * lead to duplicate fields on the root document.
            .endObject()
        assertEquals("the [include_in_root] parameter can't be updated on a nested object mapping", e2.getMessage());
            .toString();
                        .field("field1", "4")
                        .endArray()
        assertEquals(
            .endObject()
                "1",
                        .endObject()
            .startObject("properties")
                        .startObject()
        assertThat(doc.docs().get(5).get("nested1.nested2.field2"), equalTo("5"));
                    XContentFactory.jsonBuilder()
                        .endObject()
            .endObject()
            .endObject()
            .endObject()
        MapperException e2 = expectThrows(
        ObjectMapper nested1Mapper = docMapper.objectMappers().get("nested1");
            .startObject("properties")
            .startObject()
                + MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.getKey()
            new SourceToParse(
            .field("type", "nested")
 * compatible open source license.
            .startObject("nested1")
            .startObject()
import org.opensearch.common.xcontent.XContentFactory;
                .startObject("properties")
                .startObject("properties")
            .endObject()
            .field("type", "nested")
 * the Apache License, Version 2.0 (the "License"); you may
            .startObject("nested3")
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
        String mapping = XContentFactory.jsonBuilder()
                for (int i = 0; i <= defaultMaxNoNestedDocs; i++) {
        String firstMapping = XContentFactory.jsonBuilder()
 * Modifications Copyright OpenSearch Contributors. See
        String mapping = XContentFactory.jsonBuilder()
        SourceToParse source1 = new SourceToParse("test1", "1", BytesReference.bytes(docBuilder), MediaTypeRegistry.JSON);
                        .endArray()
    /**
        assertThat(doc.docs().get(3).get("nested1.nested2.field2"), equalTo("5"));
            }
 * license agreements. See the NOTICE file distributed with
        assertThat(nested2Mapper.nested().isIncludeInParent(), equalTo(true));
    public void testSingleNested() throws Exception {
                        .field("field2", "3")
    }
            .field("type", "nested")
                        .endObject()
                .merge("type", new CompressedXContent(mapping.apply("type")), MergeReason.MAPPING_UPDATE)
                MediaTypeRegistry.JSON
            .field("include_in_root", true)
        long maxNoNestedDocs = 2L;
            .endObject()
        assertThat(doc.docs().get(1).get("nested1.nested2.field2"), equalTo("3"));
        ).mapperService();
                        .startObject()
            .startObject("nested2")
            .field("include_in_parent", true)
            docBuilder2.endArray();
        assertThat(doc.docs().size(), equalTo(3));
                .startObject("messages")
            .startObject(MapperService.SINGLE_MAPPING_NAME)
        assertEquals(
                .startObject("properties")
            .endObject()
        String mapping = XContentFactory.jsonBuilder()
                        .endObject()
        assertThat(nested1Mapper.dynamic(), equalTo(Dynamic.STRICT));
        assertThat(nested1Mapper.nested().isNested(), equalTo(true));
        assertThat(nested1Mapper.nested().isNested(), equalTo(true));
                ),
                        .endObject()
            .startObject()
                        .startArray("nested2")
            .documentMapperParser()
        assertThat(doc.docs().get(1).get("nested1.field1"), equalTo("4"));
                        .startObject()
            .startObject("type")
            .startObject("nested1")
            .endObject()
            .startObject("properties")
                        .startArray("nested1")
            }
                        .field("field1", "4")
                "1",
    }
                        .field("field", "value")
                .endObject()
            .startObject()
        assertThat(doc.docs().get(2).get("field"), equalTo("value"));
        assertThat(doc.docs().get(1).get("nested1.field1"), nullValue());
        assertThat(doc.docs().get(3).get("field"), nullValue());
                    .startObject("properties")
