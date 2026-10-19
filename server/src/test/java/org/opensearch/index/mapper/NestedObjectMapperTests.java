        assertThat(doc.docs().get(2).get("nested1.nested2.field2"), nullValue());
        ParsedDocument doc = docMapper.parse(
                MediaTypeRegistry.JSON
        assertThat(doc.docs().get(3).get("nested1.nested2.field2"), equalTo("5"));  
            .startObject("nested1")
 *     http://www.apache.org/licenses/LICENSE-2.0
            .field("type", "nested")  
        assertThat(doc.docs().get(0).get("nested1.field1"), equalTo("1"));
            .startObject("properties")
                        .field("field2", "2")
                        .startObject()
        String mapping = XContentFactory.jsonBuilder()
                        .field("field2", "3")
                .endObject()
        SourceToParse source1 = new SourceToParse("test1", "1", BytesReference.bytes(docBuilder), MediaTypeRegistry.JSON);
                        .endObject()
                .endObject()  
        }
        assertThat(doc.docs().get(2).get("nested1.field1"), equalTo("1"));
            } catch (IOException e) {
        );
            new SourceToParse(  
            .startObject("type")  
            "index2",  
        assertThat(nested2Mapper.nested().isIncludeInParent(), equalTo(true));
            .field("include_in_root", true)
        SourceToParse source2 = new SourceToParse("test1", "2", BytesReference.bytes(docBuilder2), MediaTypeRegistry.JSON);
            .parse("type", new CompressedXContent(mapping));
        doc = docMapper.parse(
            .startObject()  
                docBuilder2.startObject().field("field1", "11").field("field2", "21").endObject();  
        ObjectMapper nested2Mapper = docMapper.objectMappers().get("nested1.nested2");  
            .field("include_in_root", true)  
                        .endObject()  
            .startObject("properties")  
    }
                .startObject("messages")
                        .endArray()
            .startObject("type")
        assertThat(nested2Mapper.nested().isIncludeInRoot(), equalTo(false));  
            .field("type", "nested")
            .startObject("type")
import java.util.HashSet;  
import org.opensearch.core.xcontent.XContentBuilder;
            .endObject()
            docBuilder.endArray();  
            .field("include_in_parent", true)  
        assertThat(doc.docs().get(2).get("nested1.field1"), equalTo("1"));
            .toString();
        ParsedDocument doc = docMapper.parse(  
            .endObject()
                        .startObject()
            .endObject()
            .endObject()
                    .startObject("properties")  
        assertThat(doc.docs().get(2).get("field"), nullValue());
        assertThat(doc.docs().get(6).get("nested1.field1"), nullValue());
            "test1",
                MediaTypeRegistry.JSON  
                        .endObject()
        assertTrue(objectMapper.parentObjectMapperAreNested(mapperService));  
            .toString();
            docBuilder.startArray("nested1");
        String mapping1 = XContentFactory.jsonBuilder()  
                        .startObject()  
            .startObject()
    public void testMultiObjectAndNested2() throws Exception {
                docBuilder2.startObject().field("field1", "13").field("field2", "23").endObject();  
            .field("type", "nested")  
                ),
                MediaTypeRegistry.JSON  
        assertThat(doc.docs().get(0).get("nested1.field2"), equalTo("2"));  
            .endObject()
            .endObject()
            .startObject()
                throw new UncheckedIOException(e);
        ParsedDocument doc = docMapper.parse(  
        Exception e = expectThrows(
        ParsedDocument doc = docMapper.parse(
     * case where the transitive {@code include_in_parent} and redundant {@code include_in_root}
    public void testMultipleLevelsIncludeRootWithMerge() throws Exception {
                + MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.getKey()
        MapperService mapperService = createIndex("test").mapperService();  
        assertThat(nested2Mapper.nested().isIncludeInParent(), equalTo(true));  
        ParsedDocument doc = docMapper.parse(source1);  
            .endObject()
 * the Apache License, Version 2.0 (the "License"); you may
        // parsing a doc with 2 nested objects succeeds  
        assertThat(doc.docs().get(4).get("nested1.nested2.field2"), equalTo("6"));
            .startObject("properties")  
        final Collection<IndexableField> fields = doc.rootDoc().getFields();
        assertThat(doc.docs().get(3).get("field"), nullValue());
                "1",  
            )
            .endObject()  
            .endObject()  
                    .endObject()
    public void testNestedArrayStrict() throws Exception {
        assertThat(doc.docs().get(0).get("nested1.field1"), nullValue());
            .startObject()
 * KIND, either express or implied.  See the License for the
                        .endObject()
                        .endArray()  
        // cannot update `include_in_parent` dynamically
                        .startObject()
            .startObject("type")
            () -> mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping1), MergeReason.MAPPING_UPDATE)
        DocumentMapper docMapper = mapperService.documentMapperParser().parse("type", new CompressedXContent(mapping));
        assertThat(doc.docs().get(1).get("nested1.field1"), nullValue());
                        .startObject()  
/*  
            docBuilder.endArray();
            Settings.builder().put(MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.getKey(), maxNoNestedDocs).build()  
                    .startObject("properties")  
            .field("type", "nested")  
        MapperException e2 = expectThrows(
            )  
            new SourceToParse(
            .endObject()  
                        .endObject()
            Settings.builder().put(MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.getKey(), maxNoNestedDocs).build()
            .startObject("properties")
        }
            .field("include_in_parent", true)
                .field("type", "object")
                        .startArray("nested1")  
        assertThat(doc.docs().get(3).get("nested1.nested2.field2"), equalTo("5"));  
        createIndex("test4", Settings.builder().put(MapperService.INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING.getKey(), 0).build())
        ParsedDocument doc = docMapper.parse(  
 * license agreements. See the NOTICE file distributed with
        );  
                        .startObject()
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
            new SourceToParse(
                        .field("field2", "5")  
        String mapping = XContentFactory.jsonBuilder()  
    }  
            .startObject()
            "index1",
        DocumentMapper docMapper = mapperService.documentMapper();  
        );  
            .documentMapperParser()
        assertThat(doc.docs().get(5).get("nested1.nested2.field2"), nullValue());
            .startObject("nested1")
                .merge("type", new CompressedXContent(mapping.apply("type")), MergeReason.MAPPING_UPDATE)
                    .endObject()  
        ParsedDocument doc = docMapper.parse(  
    /**
        // setting limit to 1 with 2 nested fields fails  
            .startObject("nested2")
            .endObject()
            .startObject("nested1")
 * under the License.  
                .endObject()
            docBuilder.startArray("nested1");
            .startObject("properties")  
 * not use this file except in compliance with the License.
        assertThat(doc.docs().size(), equalTo(7));
     */  
            .field("type", "nested")  
                .mapperService()
        );
        );
            .toString();
        ).mapperService();
                        .startObject()
        ).mapperService();
     * included in root by {@code include_in_root} and a chain of {@code include_in_parent} does not
                        .endArray()
            .endObject()
import java.io.IOException;
            .endObject()  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        SourceToParse source2 = new SourceToParse("test1", "2", BytesReference.bytes(docBuilder2), MediaTypeRegistry.JSON);  
                        .endObject()  
        /*
                .endObject()
            Settings.EMPTY,  
        );
                        .endObject()
            .endObject()  
 * this file be licensed under the Apache-2.0 license or a
                        .startObject()  
            e.getMessage()
        assertThat(doc.docs().get(6).get("field"), equalTo("value"));
                    XContentFactory.jsonBuilder()
                "1",
                ),  
            .toString();
                        .endArray()
        SourceToParse source1 = new SourceToParse("test1", "1", BytesReference.bytes(docBuilder), MediaTypeRegistry.JSON);
            .startObject("nested2")  
                        .field("field1", "4")  
        DocumentMapper docMapper = mapperService.documentMapper();
                        .endObject()
            "The number of nested documents has exceeded the allowed limit of ["
            .startObject("nested1")
                + MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.getKey()
            )
            {
            .endObject()
            .documentMapperParser()
        assertThat(docMapper.hasNestedObjects(), equalTo(true));
                        .field("field2", "2")
            .field("include_in_root", true)  
        assertThat(doc.docs().get(5).get("nested1.field1"), equalTo("4"));  
                    .field("type", "nested")
/*  
            .field("type", "nested")  
                + maxNoNestedDocs
        ObjectMapper nested1Mapper = docMapper.objectMappers().get("nested1");  
                .field("type", "nested")
/*
                        .field("foo", "bar")  
            .endObject()
        assertThat(doc.docs().get(2).get("nested1.field1"), equalTo("1"));  
                .endObject()
                "test",  
                "test",
        );
                        .field("field2", "3")
        assertThat(doc.docs().get(5).get("nested1.nested2.field2"), equalTo("5"));
        {  
                    XContentFactory.jsonBuilder()
        assertThat(doc.docs().get(1).get("nested1.nested2.field2"), equalTo("3"));  
                    .field("type", "nested")
package org.opensearch.index.mapper;
        assertThat(doc.docs().get(1).get("nested1.field1"), nullValue());  
            .endObject()
        assertThat(nested1Mapper.nested().isIncludeInParent(), equalTo(false));
            .endObject()  
            .startObject()
        assertThat(nested1Mapper.dynamic(), equalTo(Dynamic.STRICT));
        assertThat(doc.docs().size(), equalTo(3));
        assertThat(doc.docs().get(4).get("field"), nullValue());  
        DocumentMapper docMapper = createIndex("test").mapperService()
            )
        assertThat(nested2Mapper.nested().isIncludeInParent(), equalTo(false));
                        .startArray("nested3")
 * software distributed under the License is distributed on an
            .startObject("properties")
                        .field("field1", "4")
        assertThat(doc.docs().get(4).get("nested1.nested2.field2"), equalTo("6"));
        // setting limit to allow only two nested objects in the whole doc  
                    XContentFactory.jsonBuilder()
            .endObject()  
                        .endObject()  
                        .startObject()
        assertEquals("the [include_in_parent] parameter can't be updated on a nested object mapping", e1.getMessage());  
        ParsedDocument doc = docMapper.parse(
        String mapping = XContentFactory.jsonBuilder()  
            .field("type", "nested")
            .endObject()
                        .endObject()
        docBuilder.endObject();  
        MapperService mapperService = createIndex("test").mapperService();
            .startObject()  
            jsonBuilder().startObject()
                BytesReference.bytes(
                .mapperService()
                MediaTypeRegistry.JSON
        ObjectMapper nested1Mapper = docMapper.objectMappers().get("nested1");
                        .startObject()
        assertThat(doc.docs().get(2).get("field"), equalTo("value"));  
            .field("type", "text")  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> docMapper.parse(source2));
        assertThat(doc.docs().get(1).get("nested1.field2"), equalTo("4"));
            }  
                        .startArray("nested2")
        assertThat(doc.docs().get(0).get("nested1.field1"), nullValue());  
    }  
            .startObject("properties")
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(secondMapping), MergeReason.INDEX_TEMPLATE);  
        assertThat(doc.docs().get(6).get("nested1.field1"), nullValue());
                        .startObject()  
                .field("type", "nested")  
            .startObject("nested2")
        assertThat(doc.docs().get(4).get("nested1.nested2.field2"), equalTo("6"));
                .startObject("properties")
            .endObject()
        assertThat(doc.docs().get(5).get("nested1.nested2.field2"), nullValue());
        assertThat(doc.docs().get(1).get("nested1.field1"), nullValue());  
            .documentMapperParser()
        String secondMapping = XContentFactory.jsonBuilder()
    public void testMultipleLevelsIncludeRoot2() throws Exception {  
        assertThat(doc.docs().get(0).get("nested1.nested2.field2"), equalTo("2"));
                .endObject()  
        // parsing a doc with 2 nested objects succeeds
        DocumentMapper docMapper = createIndex("test").mapperService()
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").nullField("nested1").endObject()),  
            .documentMapperParser()
 * SPDX-License-Identifier: Apache-2.0
        assertThat(doc.docs().get(2).get("nested1.nested2.field2"), nullValue());  
                        .endObject()  
            .endObject()
        assertThat(doc.docs().get(5).get("nested1.field1"), equalTo("4"));  
            {  
        assertThat(nested2Mapper.nested().isIncludeInRoot(), equalTo(false));  
        String mapping = XContentFactory.jsonBuilder()  
            .startObject("properties")
                BytesReference.bytes(  
        assertThat(nested1Mapper.nested().isIncludeInParent(), equalTo(false));
        MapperException e1 = expectThrows(
        // cannot update `include_in_root` dynamically  
                        .field("field1", "1")  
            .startObject("nested2")
        assertThat(doc.docs().get(1).get("field"), nullValue());
            {
            .startObject("properties")
            .endObject()
                MediaTypeRegistry.JSON
        );
                        .startObject()  
                    XContentFactory.jsonBuilder().startObject().field("field", "value").startArray("nested").endArray().endObject()  
                        .endObject()
        MapperService mapperService = createIndex("test1", settings).mapperService();  
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(firstMapping), MergeReason.INDEX_TEMPLATE);
                        .startArray("nested2")  
                }
 * Unless required by applicable law or agreed to in writing,
        XContentBuilder docBuilder2 = XContentFactory.jsonBuilder();
            "The number of nested documents has exceeded the allowed limit of ["
                        .endObject()
        ObjectMapper nested1Mapper = docMapper.objectMappers().get("nested1");  
        assertThat(nested2Mapper.nested().isIncludeInParent(), equalTo(false));  
        assertThat(doc.docs().get(0).get(NestedPathFieldMapper.NAME), equalTo(nested1Mapper.nestedTypePath()));
            .startObject("properties")
            .endObject()  
 * compatible open source license.
                MediaTypeRegistry.JSON  
                        .endArray()
            .startObject()
                + "]. This limit can be set by changing the ["  
                        .field("field", "value")  
                    .startObject("nested2")
 */
        String mapping = XContentFactory.jsonBuilder()
                        .endObject()
                MediaTypeRegistry.JSON
    public void testEmptyNested() throws Exception {  
                + "] index level setting.",
        return Collections.singleton(InternalSettingsPlugin.class);  
                + "] index level setting.",
    }
        String mapping = XContentFactory.jsonBuilder()
        ObjectMapper nested1Mapper = docMapper.objectMappers().get("nested1");
                        .startArray("nested2")
                        .startArray("nested1")
            e.getMessage()
        assertThat(docMapper.hasNestedObjects(), equalTo(true));
                        .field("field1", "4")
        assertThat(doc.docs().get(0).get("field"), nullValue());  
        assertThat(nested2Mapper.nested().isNested(), equalTo(true));
        SourceToParse source1 = new SourceToParse("test1", "1", BytesReference.bytes(docBuilder), MediaTypeRegistry.JSON);  
        {
                        .endObject()
    }
                        .startObject()
        ParsedDocument doc = docMapper.parse(  
                        .field("field2", "6")
            )
            .parse("type", new CompressedXContent(mapping));  
            .endObject()  
    @Override  
                        .endObject()
        mapperService = createIndex(
                .merge("type", new CompressedXContent(mapping.apply("type")), MergeReason.MAPPING_UPDATE)
                    .endObject()
        MapperService mapperService = createIndex(
        assertThat(doc.docs().get(1).get(NestedPathFieldMapper.NAME), equalTo(nested1Mapper.nestedTypePath()));
 *  
                        .startArray("nested1")
                .field("type", "nested")
            .field("include_in_parent", true)  
 * Modifications Copyright OpenSearch Contributors. See
            .endObject()  
            .field("type", "nested")
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> docMapper.parse(source2));  
                "1",  
            .field("type", "nested")
 * The OpenSearch Contributors require contributions made to  
        objectMapper = mapperService.getObjectMapper("comments.messages");  
            .startObject("nested1")  
        final Collection<IndexableField> fields = doc.rootDoc().getFields();
                        .endArray()
            () -> mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping2), MergeReason.MAPPING_UPDATE)  
            .field("type", "nested")
            .field("type", "nested")  
            .endObject()
        assertThat(nested1Mapper.nested().isNested(), equalTo(true));  
                "test",  
            .field("dynamic", "strict")  
            .endObject()  
                    .toString();  
                    XContentFactory.jsonBuilder()  
            .endObject()
        ObjectMapper nested2Mapper = docMapper.objectMappers().get("nested1.nested2");
        assertThat(nested1Mapper.nested().isIncludeInRoot(), equalTo(false));
                        .startObject()
                docBuilder.startObject().field("field1", "12").field("field2", "22").endObject();
    public void testSingleNested() throws Exception {  
        assertThat(doc.docs().size(), equalTo(7));
            .toString();
                BytesReference.bytes(
            .endObject()
            new SourceToParse(  
            .endObject()
            .startObject("nested1")  
                        .startArray("nested2")
            new SourceToParse(
            .endObject()  
                        .endObject()
            .parse("type", new CompressedXContent(mapping));
public class NestedObjectMapperTests extends OpenSearchSingleNodeTestCase {
import static org.hamcrest.Matchers.equalTo;
        assertThat(nested1Mapper.nested().isIncludeInRoot(), equalTo(false));  
            .documentMapperParser()
        assertThat(doc.docs().get(1).get("field"), nullValue());
            .field("type", "nested")  
        DocumentMapper docMapper = mapperService.documentMapper();
 *
        assertThat(doc.docs().get(6).get("nested1.nested2.field2"), nullValue());
     * happen on a chain of nodes that starts from a parent node that is not directly connected to
            docBuilder.endArray();
                        .endArray()  
                        .startObject()
        // do not check nested fields limit if mapping is not updated  
     * root by a chain of {@code include_in_parent}, i.e. that has {@code include_in_parent} set to  
            "test1",  
            .field("include_in_parent", true)
                    XContentFactory.jsonBuilder()
        assertThat(nested1Mapper.nested().isIncludeInRoot(), equalTo(false));
        MapperService mapperService = createIndex(
        assertThat(doc.docs().size(), equalTo(3));
        assertFalse(objectMapper.parentObjectMapperAreNested(mapperService));
                .endObject()  
            .field("type", "nested")
        assertThat(e.getMessage(), containsString("Limit of nested fields [1] has been exceeded"));
        );  
                        .startObject()
            {
        String mapping2 = XContentFactory.jsonBuilder()
                "1",  
    /**  
                BytesReference.bytes(
            .startObject("type")
            new SourceToParse(
                        .startObject()
    }  
            .documentMapperParser()
            .endObject()
            IllegalArgumentException.class,
            }
                        .endObject()  
                    XContentFactory.jsonBuilder()
        assertThat(doc.docs().get(1).get("nested1.nested2.field2"), equalTo("3"));
            .field("include_in_parent", true)
        assertThat(doc.docs().get(6).getFields("nested1.nested2.field2").length, equalTo(4));  
                        .startArray("nested1")
                        .endObject()
        assertThat(doc.docs().get(1).get("field"), nullValue());
                        .endArray()
            .endObject()
                "1",  
import java.util.Collections;
        );  
    }  
                        .startObject()  
            Settings.EMPTY,
        };
            .parse("type", new CompressedXContent(mapping));  
        assertThat(doc.docs().get(1).get("nested1.nested2.field2"), equalTo("3"));
                        .startArray("nested1")
        // parsing a doc with No. nested objects > defaultMaxNoNestedDocs fails  
                        .startObject()
                        .endObject()
            .endObject()
        ParsedDocument doc = docMapper.parse(  
                        .field("field", "value")  
                        .field("field2", "2")  
        assertThat(doc.docs().get(4).get("field"), nullValue());
                        .field("field2", "2")
                    XContentFactory.jsonBuilder()
                .startObject("nested1")
        assertThat(nested2Mapper.nested().isNested(), equalTo(true));
                        .startArray("nested2")
        assertThat(doc.docs().get(0).get("field"), nullValue());
                docBuilder2.startObject().field("field1", "12").field("field2", "22").endObject();
            docBuilder2.startArray("nested1");
     */
                        .startObject()  
            .endObject()
     * lead to duplicate fields on the root document.  
                        .field("field1", "1")
        }
            .endObject()
    }
            () -> createIndex("test2", Settings.builder().put(MapperService.INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING.getKey(), 0).build())  
            .field("type", "nested")
            .startObject("nested1")
        assertThat(doc.docs().get(4).get("field"), nullValue());
        assertThat(doc.docs().get(0).get("nested1.nested2.field2"), equalTo("2"));  
                MediaTypeRegistry.JSON  
        assertThat(doc.docs().get(3).get("nested1.nested2.field2"), equalTo("5"));
            .startObject("type")  
import java.util.function.Function;
            .field("include_in_root", true)
                + MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.getKey()  
                        .endObject()
            .endObject()  
    }
                        .startObject()  
        long maxNoNestedDocs = 2L;  
                docBuilder.startObject().field("field1", "11").field("field2", "21").endObject();  
                        .startObject()  
                        .startArray("nested2")
            MapperException.class,
                .endObject()
                        .field("field1", "1")
        assertThat(doc.docs().get(1).get("field"), equalTo("value"));
        assertThat(doc.docs().get(2).get("nested1.nested2.field2"), equalTo("2"));
            .field("type", "nested")  
            )
                .startObject("properties")  
            .endObject()
    public void testMultiRootAndNested1() throws Exception {  
            .startObject("type")
        assertThat(doc.docs().get(6).getFields("nested1.nested2.field2").length, equalTo(4));  
                        .endObject()
    public void testLimitNestedDocs() throws Exception {
                .startObject("properties")
        XContentBuilder docBuilder2 = XContentFactory.jsonBuilder();
                docBuilder2.startObject().field("field1", "11").field("field2", "21").endObject();
            )
            .startObject("type")  
            .field("type", "nested")  
            .field("include_in_root", true)
            .endObject()  
                        .endObject()  
        final Collection<IndexableField> fields = doc.rootDoc().getFields();
    public void testParentObjectMapperAreNested() throws Exception {  
    public void testLimitNestedDocsDefaultSettings() throws Exception {
            .endObject()
        );
            docBuilder.endArray();  
 * You may obtain a copy of the License at  
                        .startObject()
                        .endArray()  
                "test",
        assertEquals(  
                        .endArray()
                        .field("field", "value")
        assertThat(nested2Mapper.nested().isNested(), equalTo(true));
            new SourceToParse(  
            .field("include_in_parent", true)  
        assertThat(nested1Mapper.nested().isNested(), equalTo(true));  
            .endObject()  
                .endObject()
     * {@code false} and {@code include_in_root} set to {@code true}.
        assertThat(fields.size(), equalTo(new HashSet<>(fields).size()));
                MediaTypeRegistry.JSON
            .endObject()
        assertThat(doc.docs().get(2).get("field"), nullValue());
        assertThat(doc.docs().size(), equalTo(2));  
            .endObject()  
                BytesReference.bytes(
        docBuilder2.startObject();  
            .endObject()
            docBuilder.startArray("nested2");
        long maxNoNestedDocs = 2L;
        );
        );
    }  
            .startObject("nested1")  
                        .startArray("nested1")
    public void testMergeNestedMappings() throws IOException {
        assertThat(doc.docs().get(4).get("nested1.nested2.field2"), equalTo("6"));
        String mapping = XContentFactory.jsonBuilder()
            .startObject()
            )
        assertThat(nested2Mapper.nested().isIncludeInRoot(), equalTo(false));
    public void testMultiNested() throws Exception {  
            .startObject("nested1")
            .field("include_in_root", true)
                    docBuilder.startObject().field("f", i).endObject();
         */
        assertThat(doc.docs().get(1).get("nested1.field1"), equalTo("4"));
        MapperService mapperService = createIndex("test").mapperService();
                        .startArray("nested1")
import java.io.UncheckedIOException;  
            .startObject("properties")  
            .endObject()
            }
                        .field("field", "value")
            .field("type", "nested")
                        .endObject()
                        .field("field2", "3")  
        {
                        .startObject()  
        DocumentMapper docMapper = createIndex("test").mapperService()  
        DocumentMapper docMapper = mapperService.documentMapperParser().parse("type", new CompressedXContent(mapping));  
            }
        MergeReason mergeReason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);
                        .field("field1", "1")
                        .endObject()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
            .startObject("nested3")
            .endObject()
        assertThat(doc.docs().get(2).get("field"), nullValue());
        ).mapperService();
        assertThat(doc.docs().get(2).get("nested1.field1"), equalTo("1"));  
            .parse("type", new CompressedXContent(mapping));  
        assertThat(doc.docs().get(1).get("nested1.nested2.field2"), equalTo("3"));  
                        .endArray()  
        assertThat(doc.docs().get(6).get("field"), equalTo("value"));  
            .startObject("nested2")
                ),
                        .startObject()
                        .endArray()
        String mapping = XContentFactory.jsonBuilder()  
            .endObject()
                        .endArray()
            .endObject()
                docBuilder.startObject().field("field1", "21").field("field2", "22").endObject();  
                .startObject("comments")
                        .field("field1", "1")
            .endObject()
            .endObject()
        createIndex("test1").mapperService().merge("type", new CompressedXContent(mapping.apply("type")), MergeReason.MAPPING_UPDATE);
                + "]. This limit can be set by changing the ["
        }  
        XContentBuilder docBuilder = XContentFactory.jsonBuilder();
        assertThat(doc.docs().get(6).get("nested1.nested2.field2"), nullValue());
                .endObject()
                        .startObject()  
            docBuilder2.endArray();
     * redundancy, only the merged mapping does.
        ObjectMapper nested1Mapper = docMapper.objectMappers().get("nested1");
    protected boolean forbidPrivateIndexSettings() {
                        .startArray("nested1")  
                    .endObject()  
                "1",
            jsonBuilder().startObject()
        assertThat(doc.docs().get(5).get("field"), nullValue());  
        assertThat(doc.docs().get(5).get("nested1.field1"), equalTo("4"));
            )
        String mapping = XContentFactory.jsonBuilder()  
                + "] index level setting.",  
                        .startObject()
        );
            .startObject("properties")
                    .endObject()
        docBuilder2.endObject();
            .endObject()
    }
            .field("type", "nested")
            new SourceToParse(
                        .field("field2", "6")  
import org.opensearch.common.xcontent.XContentFactory;
        assertThat(docMapper.hasNestedObjects(), equalTo(true));
                docBuilder2.startObject().field("field1", "13").field("field2", "23").endObject();  
                        .field("field", "value")
                        .startObject()  
            .toString();
            .endObject()
            .startObject(MapperService.SINGLE_MAPPING_NAME)  
                        .endObject()
import static org.hamcrest.Matchers.containsString;
            .toString();
            .endObject()
                BytesReference.bytes(
        assertThat(nested2Mapper.nested().isIncludeInRoot(), equalTo(true));
        docBuilder2.endObject();
    }  
        DocumentMapper docMapper = createIndex("test").mapperService()  
        assertThat(doc.docs().get(1).get("field"), nullValue());
                        .startArray("nested2")  
import org.opensearch.plugins.Plugin;
            .toString();
                .startObject("properties")  
        String mapping = XContentFactory.jsonBuilder()
                        .endObject()
            .startObject(MapperService.SINGLE_MAPPING_NAME)
            docBuilder2.endArray();
                "test",
                .field("type", "nested")
                        .startObject("nested1")
                for (int i = 0; i <= defaultMaxNoNestedDocs; i++) {  
        assertThat(doc.docs().get(6).get("nested1.field1"), nullValue());
                ),
                        .startObject()
            .startObject("nested1")
            .endObject()
            .endObject()
                        .field("field1", "4")
            .startObject()
        assertThat(doc.docs().get(6).get("field"), equalTo("value"));
                        .endObject()  
                "test",
 *
            .startObject("field1")
                        .startObject()
     */
                docBuilder2.startObject().field("field1", "12").field("field2", "22").endObject();
import org.opensearch.common.settings.Settings;  
        ParsedDocument doc = docMapper.parse(
        assertThat(doc.docs().get(1).get("nested1.field1"), equalTo("3"));  
            .endObject()
                        .startObject()
        docBuilder2.startObject();
            docBuilder.startArray("nested1");
            {
            .endObject()
        // parsing a doc with 3 nested objects fails  
        Function<String, String> mapping = type -> {
import org.apache.lucene.index.IndexableField;
            .endObject()
            try {
            .endObject()
            IllegalArgumentException.class,
            () -> createIndex("test3", Settings.builder().put(MapperService.INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING.getKey(), 1).build())  
        assertThat(doc.docs().get(5).get("nested1.nested2.field2"), equalTo("5"));
                .endObject()  
        // default limit allows at least two nested fields  
                "1",
     * Same as {@link NestedObjectMapperTests#testMultipleLevelsIncludeRoot1()} but tests that  
    @Override
                BytesReference.bytes(
                        .field("field1", "1")  
    }
        assertThat(doc.docs().get(0).get("nested1.nested2.field2"), equalTo("2"));  
        assertThat(nested1Mapper.nested().isIncludeInRoot(), equalTo(false));  
        );  
                        .startObject()  
    }
            .toString();  
        assertThat(doc.docs().get(0).get("nested1.field1"), nullValue());
            .endObject()
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), mergeReason);
        ).mapperService();
        assertThat(doc.docs().get(0).get("nested1.field1"), nullValue());  
        assertEquals(
                "test",
            .endObject()  
                        .field("field2", "2")  
            }
        docBuilder.startObject();
        long defaultMaxNoNestedDocs = MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.get(settings);
            .startObject("type")  
            .startObject("nested1")
            {
            .startObject("nested1")
        assertThat(doc.docs().size(), equalTo(1));  
            .endObject()  
            e.getMessage()  
                        .startArray("nested2")
            docBuilder2.startArray("nested1");
                        .startObject()
}
        assertThat(doc.docs().get(1).get("field"), nullValue());
import org.opensearch.index.mapper.MapperService.MergeReason;
            .toString();
                docBuilder.startObject().field("field1", "11").field("field2", "21").endObject();
    public void testLimitNestedDocsMultipleNestedFields() throws Exception {
                    XContentFactory.jsonBuilder()
        // parsing a doc with 3 nested objects fails
                        .startObject()
            .field("type", "nested")  
                "test",
        Settings settings = Settings.builder().build();
        ObjectMapper nested2Mapper = docMapper.objectMappers().get("nested1.nested2");  
            new SourceToParse(
                ),
import org.opensearch.index.mapper.ObjectMapper.Dynamic;  
            .startObject("nested1")
            .merge("type", new CompressedXContent(mapping.apply("type")), MergeReason.MAPPING_RECOVERY);  
            .field("type", "nested")
        assertThat(doc.docs().get(0).get("nested1.nested2.field2"), equalTo("2"));
                        .endObject()  
                        .field("field2", "5")
        assertThat(doc.docs().get(0).get("nested1.field1"), equalTo("1"));  
                        .endObject()
                "1",
        assertThat(doc.docs().get(1).get("nested1.field1"), nullValue());
            .documentMapperParser()
            jsonBuilder().startObject()  
            "index1",
        assertThat(e.getMessage(), containsString("Limit of nested fields [0] has been exceeded"));
            .field("include_in_root", true)
                        .endArray()
            .startObject("nested2")  
        assertThat(nested1Mapper.nested().isNested(), equalTo(true));
            .startObject("properties")
        assertThat(nested1Mapper.nested().isIncludeInParent(), equalTo(true));
            .field("include_in_parent", true)  
                ),
                "1",
            new SourceToParse(  
                        .startObject()
    }  
            .startObject("properties")  
        assertThat(doc.docs().size(), equalTo(7));
            .field("type", "nested")
        assertThat(doc.docs().get(5).get("field"), nullValue());  
            .endObject()  
            .startObject(MapperService.SINGLE_MAPPING_NAME)
        docBuilder.startObject();
 */  
            .toString();
        assertThat(doc.docs().get(3).get("field"), nullValue());  
        docBuilder.startObject();  
            .endObject()
        String firstMapping = XContentFactory.jsonBuilder()
                        .endArray()  
            new SourceToParse(
                        .field("field2", "6")
        String mapping = XContentFactory.jsonBuilder()
import static org.hamcrest.Matchers.nullValue;  
            .parse("type", new CompressedXContent(mapping));  
import org.opensearch.test.InternalSettingsPlugin;
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> docMapper.parse(source1));
            docBuilder2.endArray();
            .startObject()
                MediaTypeRegistry.JSON  
            .startObject("nested1")
            .field("include_in_parent", true)  
    /**
                        .startArray("nested2")  
            .startObject(MapperService.SINGLE_MAPPING_NAME)
            .startObject("properties")
            .toString();
        );
            .startObject("properties")
            .field("include_in_root", true)
                        .endArray()
                        .endArray()
        assertThat(doc.docs().get(2).get("field"), equalTo("value"));  
                "1",  
        assertThat(doc.docs().get(4).get("field"), nullValue());  
            }  
                        .startObject()
            .field("type", "nested")  
            .parse("type", new CompressedXContent(mapping));
            new SourceToParse(
                        .endObject()
                BytesReference.bytes(  
            .startObject("nested1")
        String mapping = XContentFactory.jsonBuilder()
                        .field("field", "value")
            .field("include_in_parent", true)
                        .field("foo", "bar")
        assertThat(doc.docs().get(0).get("nested1.field2"), equalTo("2"));
                        .endObject()  
                        .endArray()  
    public void testMultipleLevelsIncludeRoot1() throws Exception {
        assertThat(doc.docs().get(3).get("nested1.nested2.field2"), equalTo("5"));
                "test",
        assertThat(doc.docs().size(), equalTo(7));
                "test",
            Settings.EMPTY,
            .endObject()
            .startObject("properties")
                        .field("field2", "2")  
            .field("include_in_root", true)
        assertThat(doc.docs().get(2).get("nested1.nested2.field2"), equalTo("2"));  
                "1",
                        .endArray()  
        docBuilder.endObject();
                        .field("field", "value")
            .endObject()
        assertThat(doc.docs().get(3).get("field"), nullValue());  
    }  
                        .endObject()
                        .startObject()
            .field("type", "nested")
        ObjectMapper nested1Mapper = docMapper.objectMappers().get("nested1");  
                        .endObject()
        assertThat(nested1Mapper.nested().isNested(), equalTo(true));
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                        .startArray("nested2")
        {  
                    XContentFactory.jsonBuilder()
import org.opensearch.common.compress.CompressedXContent;
        DocumentMapper docMapper = createIndex("test").mapperService()  
            )
                        .field("field1", "3")  
            .startObject("nested2")
            .startObject("nested2")
            {  
                "test",
                        .startObject()
                        .field("field2", "5")  
        assertThat(docMapper.hasNestedObjects(), equalTo(true));
                        .endObject()
            .startObject("properties")
                return XContentFactory.jsonBuilder()  
        assertThat(doc.docs().size(), equalTo(3));
                        .startObject()
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), mergeReason);  
                BytesReference.bytes(
        );  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(nested1Mapper.nested().isNested(), equalTo(true));
                        .startArray("nested2")  
                .startObject("comments")  
            }
            .startObject("properties")
            .endObject()
            .endObject()
 * GitHub history for details.
    public void testMultiObjectAndNested1() throws Exception {
        e = expectThrows(
                        .field("field2", "5")
            )
            .field("type", "nested")
                        .endObject()
                + maxNoNestedDocs  
            .endObject()  
                        .startObject()  
        );
                        .field("field2", "3")  
import org.opensearch.core.common.bytes.BytesReference;
            .startObject()  
                ),
        assertEquals("the [include_in_root] parameter can't be updated on a nested object mapping", e2.getMessage());
                .endObject()  
        assertThat(doc.docs().size(), equalTo(3));
                        .endObject()
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(doc.docs().get(6).get("field"), equalTo("value"));  
            .startObject()
        DocumentMapper docMapper = mapperService.documentMapperParser().parse("type", new CompressedXContent(mapping));
                + "]. This limit can be set by changing the ["
                        .field("field2", "4")
        {  
        DocumentMapper docMapper = createIndex("test").mapperService()
                        .endObject()  
                ),
            .toString();
                        .startObject()
        assertThat(doc.docs().get(5).get("field"), nullValue());
                        .startObject()
                        .endObject()
            .field("include_in_root", true)
    }
        MapperService mapperService = createIndex(
            .startObject("properties")
                        .endObject()  
                MediaTypeRegistry.JSON  
            .endObject()  
                        .startObject()  
            .startObject("nested2")
        XContentBuilder docBuilder = XContentFactory.jsonBuilder();
        assertThat(nested1Mapper.nested().isIncludeInParent(), equalTo(false));
        );
                ),
                        .field("field2", "6")  
                + defaultMaxNoNestedDocs
        assertEquals(
            .endObject()  
        assertThat(fields.size(), equalTo(new HashSet<>(fields).size()));
            .toString();
            .startObject("properties")  
        DocumentMapper docMapper = createIndex("test").mapperService()
        assertThat(doc.docs().get(5).get("nested1.field1"), equalTo("4"));
            MapperException.class,  
            .startObject("type")  
        assertThat(doc.docs().get(6).getFields("nested1.field1").length, equalTo(2));
        ).mapperService();
            .endObject()  
        doc = docMapper.parse(
            .startObject("properties")
            .endObject()  
            .endObject()
            .startObject("properties")  
    }
            .endObject()
        ObjectMapper objectMapper = mapperService.getObjectMapper("comments.messages");
            .startObject()
        assertThat(doc.docs().get(0).get("field"), nullValue());
            .endObject()
        XContentBuilder docBuilder = XContentFactory.jsonBuilder();
 * this work for additional information regarding copyright
        assertThat(docMapper.hasNestedObjects(), equalTo(true));
                MediaTypeRegistry.JSON  
        // explicitly setting limit to 0 prevents nested fields  
        assertThat(doc.docs().get(0).get("nested1.field1"), equalTo("1"));
        assertThat(nested1Mapper.nested().isNested(), equalTo(true));  
                        .endObject()
        docBuilder.endObject();
                ),  
                        .field("field1", "1")  
            .endObject()
     * the redundant includes are removed even if each individual mapping doesn't contain the
                    .startObject(type)
            .startObject()
            .startObject("properties")
            .startObject("properties")  
                    .startObject("nested1")
            .field("include_in_root", true)
            .endObject()
            .endObject()  
                BytesReference.bytes(
            .mapperService()
                        .endObject()
        assertThat(doc.docs().get(3).get("field"), nullValue());
            )  
                        .endObject()  
                    XContentFactory.jsonBuilder()
        // setting limit to allow only two nested objects in the whole doc
 * specific language governing permissions and limitations
            .startObject(MapperService.SINGLE_MAPPING_NAME)  
        assertThat(doc.docs().get(0).get("field"), nullValue());
                        .startObject()
                    .endObject()
            .startObject()
            .endObject()  
        assertThat(fields.size(), equalTo(new HashSet<>(fields).size()));
            .endObject()
            .toString();  
                        .field("field1", "4")  
            .field("type", "nested")  
                        .endObject()
        assertThat(doc.docs().get(5).get("field"), nullValue());
                .startObject("properties")
        return false;
                "1",  
                    .startObject()
        }  
        assertThat(doc.docs().get(0).get(NestedPathFieldMapper.NAME), equalTo(nested1Mapper.nestedTypePath()));
 */  
            .endObject()  
import java.util.Collection;
            .endObject()  
        ObjectMapper nested2Mapper = docMapper.objectMappers().get("nested1.nested2");
                ),
            docBuilder2.startArray("nested2");  
            .startObject("properties")
                .startObject("messages")  
    protected Collection<Class<? extends Plugin>> getPlugins() {
        MergeReason mergeReason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);  
        MapperService mapperService = createIndex(  
        assertThat(nested2Mapper.nested().isNested(), equalTo(true));
                        .endArray()  
            .field("include_in_parent", true)
                        .field("foo", "bar")
            .endObject()  
                BytesReference.bytes(  
            .startObject("nested1")
                        .endArray()  
                "test",
            .startObject(MapperService.SINGLE_MAPPING_NAME)
        assertThat(doc.docs().get(2).get("field"), nullValue());
     * Checks that multiple levels of nested includes where a node is both directly and transitively
                        .startArray("nested1")
        assertThat(doc.docs().size(), equalTo(1));
            .field("type", "nested")
                        .endObject()
                .endObject()
        assertThat(docMapper.hasNestedObjects(), equalTo(true));
     * Same as {@link NestedObjectMapperTests#testMultipleLevelsIncludeRoot1()} but tests for the  
        assertThat(doc.docs().get(0).get("field"), nullValue());
            .toString();
                        .startObject()
                        .endObject()
        ParsedDocument doc = docMapper.parse(source1);
    public void testLimitOfNestedFieldsPerIndex() throws Exception {  
            "The number of nested documents has exceeded the allowed limit of ["  
            .field("include_in_parent", false)  
          This is needed to force the index version with {@link IndexMetadata.SETTING_INDEX_VERSION_CREATED}.  
