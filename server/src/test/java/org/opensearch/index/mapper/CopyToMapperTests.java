                                {
        assertThat(doc.rootDoc().get("copy_test"), equalTo("foo"));
        ParseContext.Document doc = docMapper.parse(source(b -> {
import org.apache.lucene.index.IndexableField;
                    b.endObject();
            {
        assertThat(doc.getFields("copy_test").length, equalTo(1));
            b.endArray();
            }
                b.endObject();
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(Arrays.asList("baz", "bar"), fieldMapperAfter.copyTo().copyToFields());
                b.endObject();
public class CopyToMapperTests extends MapperServiceTestCase {
            b.field("copy_test", "foo");
    private void assertFieldValue(Document doc, String field, Number... expected) {
                    }
                    {
        assertThat(copyTestMap.get("type").toString(), is("text"));
        Document parent = doc.docs().get(2);
import org.opensearch.index.mapper.ParseContext.Document;
            b.endObject();
        MapperService mapperService = createMapperService(mapping(b -> {
                    {
                b.endObject();
                b.field("type", "text");
        }));
            b.endObject();
                    b.field("copy_to", "very.inner.field");
                    b.field("copy_to", "very.inner.field");
            b.field("copy_test", "foo");
        ParseContext.Document doc = docMapper.parse(source(b -> {
                    {
        assertThat(doc.getFields("copy_test").length, equalTo(2));
            }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createMapperService(fieldMapping(b -> {
        assertThat(doc.getFields("copy_test")[0].stringValue(), equalTo("foo"));
            {
            b.endObject();
                                    b.value("target"); // should go to the root doc
                    b.field("copy_to", "field.my_field.bar");
        assertEquals("[copy_to] may not be used to copy to a multi-field: [field.my_field.bar]", e.getMessage());
                            b.endObject();
        assertThat(e.getMessage(), Matchers.containsString("[copy_to] may not be used to copy from a multi-field: [field.bar]"));
            }
        MapperService mapperService = createMapperService(mapping(b -> {
            {
        assertFieldValue(nested, "n1.target");
            b.endObject();
                    {
            b.field("copy_test", "foo");
                        b.startObject("properties");
                    }
            }
                    b.startObject("bar").field("type", "text").endObject();
            {
import org.hamcrest.Matchers;
        assertThat(doc.getFields("new_field")[0].stringValue(), equalTo("bar"));
import org.opensearch.common.xcontent.json.JsonXContent;
            b.field("type", "nested");
import static org.hamcrest.Matchers.startsWith;
                {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(mapping(b -> {
        ParsedDocument parsedDoc = mapperService.documentMapper().parse(source(b -> {
        assertThat(doc.getFields("very.inner.field")[0].stringValue(), equalTo("foo"));
            b.startObject("another_field").field("type", "text").endObject();
    public void testCopyToChildNested() {
    }
                {
        }
                b.endObject();
 */
                }
                            {
            b.endObject();
                b.field("type", "integer");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(mapping(b -> {
    public void testCopyToDynamicInnerInnerObjectParsing() throws Exception {
        ParseContext.Document doc = docMapper.parse(source(b -> {
    @SuppressWarnings("unchecked")
    public void testCopyToMultiField() {
            b.startArray("n1");
                        b.field("doc_values", false);
            {
    }
                        b.field("match", "test");
            {
        ParseContext.Document doc = parsedDoc.rootDoc();
                    b.field("type", "text");
            }
            }
                    }
                                b.endArray();
                        b.startObject("mapping").field("type", "nested").endObject();
            {
                {
        assertThat(e.getMessage(), startsWith("It is forbidden to create dynamic nested objects ([very]) through `copy_to`"));
 *     http://www.apache.org/licenses/LICENSE-2.0
        }));
            b.startObject("copy_test");
        assertThat(doc.getFields("another_field").length, equalTo(2));
            b.field("new_field", "bar");
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {
        }));
            }
        }));
                b.startObject("properties");
        assertThat(doc.getFields("very.inner.field").length, equalTo(1));
            b.field("cyclic_test", "bar");
    public void testNestedCopyTo() throws IOException {
                    }
                b.endObject();
            b.startObject("copy_test");
                    b.startObject("target").field("type", "long").endObject();
        }));
        assertFieldValue(parent, "n1.n2.target");
                b.field("type", "nested");
                    b.endObject();
            b.endObject();
                b.startObject("properties");
            b.endObject();
    }
        assertThat(doc.getFields("copy_test")[0].stringValue(), equalTo("foo"));
        assertThat(doc.getFields("very.inner.field")[0].stringValue(), equalTo("foo"));
                    b.startObject("source");
                b.endObject();
                b.field("type", "text");
            }
            }
            b.endObject();
                b.endObject();
 *
 */
                    }
            }
        assertThat(doc.getFields("new_field")[0].numericValue().intValue(), equalTo(42));
                        b.field("type", "long");
            b.endObject();
                    b.field("type", "text");
                    b.field("copy_to", "very.inner.field");
                b.field("type", "nested");
        );
                b.field("copy_to", "my_field.bar");
        Exception e = expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(fieldMapping(b -> {
            }
        })));
import static org.hamcrest.Matchers.is;
                            b.startObject("source");
                b.field("doc_values", false);
                b.field("type", "text");
            b.field("dynamic", "strict");
            () -> docMapper.parse(source(b -> b.field("copy_test", "foo")))
        assertThat(doc.getFields("new_field")[0].stringValue(), equalTo("bar"));
                b.field("type", "text");
                b.startObject();
                        b.field("type", "long");
        assertThat(doc.getFields("int_to_str_test").length, equalTo(1));
        assertThat(doc.rootDoc().get("very.inner.field"), nullValue());
        FieldMapper fieldMapperBefore = (FieldMapper) docMapperBefore.mappers().getMapper("copy_test");
                b.field("type", "object");
            b.startObject("source");
        })));
            b.field("copy_test", "foo");
        assertFieldValue(root, "target", 3L, 5L, 7L);
                {
            }
            b.endObject();
        assertFieldValue(nested, "n1.n2.target", 3L);
            {
                b.array("copy_to", "baz", "bar");
            {
                                b.startArray("copy_to");
import org.opensearch.core.xcontent.XContentBuilder;
                }
        TextFieldMapper stringFieldMapper = (TextFieldMapper) fieldMapper;
                {
            b.endObject();
            }
        MapperParsingException e = expectThrows(
 * this work for additional information regarding copyright
                }
                                b.field("doc_values", false);
            b.startObject("properties");
                b.startObject("properties");
                {
        // Check data parsing
            }
            {
                b.startObject();
        }));
                b.startObject("bar").field("baz", "zoo").endObject();
                                    b.value("n1.target"); // should go to the parent doc
        assertThat(doc.getFields("copy_test")[0].stringValue(), equalTo("foo"));
                    b.endObject();
import java.util.List;
        assertArrayEquals(expected, actual);
                b.startObject("properties");
import static org.hamcrest.Matchers.nullValue;
        assertThat(doc.getFields("new_field").length, equalTo(2)); // new field has doc values
 * You may obtain a copy of the License at
        assertEquals(Arrays.asList("foo", "bar"), fieldMapperBefore.copyTo().copyToFields());
        assertNotNull(parsedDoc.dynamicMappingsUpdate());
            b.field("copy_test", "foo");
                }
 * Unless required by applicable law or agreed to in writing,
    }
                b.startObject();
            {
/*
                b.endObject();
                b.startObject();
        }
    }
                b.endObject();
    }
            b.startArray("dynamic_templates");
            {
        assertThat(doc.getFields("cyclic_test").length, equalTo(2));
            }
                        }
            b.startObject("fields");
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {
        }));
        List<String> copyToList = (List<String>) copyTestMap.get("copy_to");
        stringFieldMapper.toXContent(builder, ToXContent.EMPTY_PARAMS).endObject();
        createDocumentMapper(fieldMapping(b -> {
package org.opensearch.index.mapper;
            b.endObject();
            b.endObject();
            {
                b.endObject();
 * SPDX-License-Identifier: Apache-2.0
        Number[] actual = new Number[values.length];
            MapperParsingException.class,
        assertThat(doc.getFields("copy_test")[0].stringValue(), equalTo("foo"));
    }
                {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(mapping(b -> {
                    b.startObject("inner").field("type", "object").endObject();
            }
        DocumentMapper docMapperBefore = mapperService.documentMapper();
    public void testCopyToObject() {
            }
    }
            b.field("dynamic", "strict_allow_templates");
/*
                b.field("doc_values", false);
        ParsedDocument doc = mapper.parse(source(b -> {
 * under the License.
        assertEquals(6, doc.docs().size());
                    b.field("type", "text");
        nested = doc.docs().get(1);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            b.endObject();
                    b.startObject("n2");
        merge(mapperService, dynamicMapping(parsedDoc.dynamicMappingsUpdate()));
            b.endObject();
        );
            b.startObject("copy_test");
                    }
            b.endArray();
                    b.startObject("fields");
                b.field("copy_to", "very.far.inner.field");
                    {
                }
            {
        })));
        })));
    }
                        b.field("copy_to", "n2.target");
            {
                {
                    b.startObject("far").field("type", "object").endObject();
        assertThat(
        assertThat(e.getMessage(), startsWith("mapping set to strict, dynamic introduction of [very] within [_doc] is not allowed"));
                }
                    b.field("type", "text");
                b.field("type", "keyword");
                            b.startObject("target").field("type", "long").endObject();
        MapperParsingException e = expectThrows(
                    b.startObject("objects");
            }
            }
                    }
                {
        IndexableField[] values = doc.getFields(field);
                        b.endObject();
            b.field("dynamic", "false_allow_templates");
            b.startObject("very");
                }
            b.startObject("properties");
                        b.field("match_mapping_type", "object");
                    b.field("type", "keyword");
            serializedMap = parser.map();
                    {
                {
        Mapper fieldMapper = mapperService.documentMapper().mappers().getMapper("copy_test");
                b.array("copy_to", "another_field", "cyclic_test");
        XContentBuilder builder = jsonBuilder().startObject();
                b.startObject("fields");
        assertFieldValue(nested, "target");
        }));
                b.field("type", "text");
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
    public void testCopyToStrictAllowTemplatesDynamicInnerObjectParsing() throws Exception {
            b.endObject();
            b.startObject("n1");
                }
            b.startArray("dynamic_templates");
                {
 * Licensed to Elasticsearch under one or more contributor
 * the Apache License, Version 2.0 (the "License"); you may
            b.field("type", "keyword");
    public void testCopyToSiblingNested() {
        parent = doc.docs().get(4);
 * The OpenSearch Contributors require contributions made to
            {
        }));
                b.field("copy_to", "very.inner.field");
        assertThat(e.getMessage(), Matchers.startsWith("Illegal combination of [copy_to] and [nested] mappings"));
import org.opensearch.core.common.bytes.BytesReference;
        DocumentMapper docMapper = createDocumentMapper(topMapping(b -> {
            b.startObject("source");
    }
                        b.endObject();
                b.field("type", "long");
        ParsedDocument doc = docMapper.parse(source(b -> b.field("copy_test", "foo")));
        }));
            b.endObject();
                b.endObject();
                            b.endObject();
    public void testCopyToFieldMerge() throws Exception {
        }));
                b.startObject("copy_test");
        assertThat(doc.getFields("copy_test")[1].stringValue(), equalTo("bar"));
                        b.field("type", "object");
                    {
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {
        }
                        b.startObject("mapping").field("type", "object").endObject();
                        b.startObject("bar").field("type", "text").endObject();
        DocumentMapper docMapperAfter = mapperService.documentMapper();
                b.array("copy_to", "copy_test");
            }
            {
            {
                        {
        assertThat(copyToList.get(1), equalTo("cyclic_test"));
            {
            b.endObject();
        assertThat(doc.getFields("very.far.inner.field").length, equalTo(1));
        assertThat(e.getMessage(), startsWith("mapping set to strict, dynamic introduction of [field] within [very.far] is not allowed"));
            b.endObject();
                }
                b.array("copy_to", "foo", "bar");
 *
            {
                b.endObject();
        })));
        assertThat(doc.getFields("another_field")[1].stringValue(), equalTo("42"));
                    b.field("copy_to", "very.inner.field");
                }
                    b.endObject();
                    }
        expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(mapping(b -> {
            b.field("type", "nested");
                    {
                            }
            b.startObject("target");
                    b.field("type", "keyword");
                b.field("type", "object");
            }
                        b.startObject().field("source", 3).endObject();
    public void testNestedCopyToMultiField() {
import org.opensearch.core.xcontent.ToXContent;
        assertFieldValue(parent, "n1.target", 7L);
            }
import java.util.Arrays;
        FieldMapper fieldMapperAfter = (FieldMapper) docMapperAfter.mappers().getMapper("copy_test");
                b.endObject();
}
                        b.startObject().field("source", 5).endObject();
            b.startObject("cyclic_test");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(mapping(b -> {
                        b.startObject("properties");
                    b.startObject("far");
            b.endObject();
                b.startObject("copy_test");
            b.field("int_to_str_test", 42);
            b.startObject("target");
            {
            b.endObject();
        assertThat(e.getMessage(), Matchers.startsWith("Illegal combination of [copy_to] and [nested] mappings"));
                    {
            () -> docMapper.parse(source(b -> b.field("copy_test", "foo")))
    public void testCopyToNestedField() throws Exception {
        assertThat(doc.getFields("another_field")[0].stringValue(), equalTo("foo"));
import java.util.Map;
                    b.startArray("n2");
        for (int i = 0; i < values.length; ++i) {
                    b.startArray("n2");
                {
                b.startObject("properties");
                b.startObject("foo");
                b.field("type", "nested");
                b.endObject();
/*
            b.endObject();
        assertThat(doc.getFields("very.far.inner.field")[0].stringValue(), equalTo("foo"));
            b.startObject("n1");
        DocumentMapper docMapper = createDocumentMapper(topMapping(b -> {
        MapperParsingException e = expectThrows(
                }
    }
                        }
                }
        assertThat(copyToList.size(), equalTo(2));
            }
        assertEquals(Arrays.asList("foo", "bar"), fieldMapperBefore.copyTo().copyToFields());
            values = new IndexableField[0];
        assertThat(doc.getFields("copy_test").length, equalTo(1));
 * license agreements. See the NOTICE file distributed with
            b.startObject("properties");
import org.opensearch.core.xcontent.XContentParser;
        assertThat(doc.getFields("cyclic_test")[0].stringValue(), equalTo("foo"));
            b.startObject("n1");
                            }
                b.field("copy_to", "very.far.field");
        assertFieldValue(nested, "n1.n2.target", 5L);
            {
    public void testCopyToDynamicInnerObjectParsing() throws Exception {
    }
                        b.field("match", "test");
        assertThat(fieldMapper.typeName(), equalTo("long"));
        assertFieldValue(nested, "n1.target");
                    b.field("copy_to", "n.bar");
                b.endObject();
            {
                b.startObject();
 * KIND, either express or implied.  See the License for the
    public void testCopyToStrictDynamicInnerObjectParsing() throws Exception {
            b.endObject();
            b.startObject("properties");
                    b.endArray();
                b.startObject("copy_test");
 * Modifications Copyright OpenSearch Contributors. See
    public void testCopyToFieldsParsing() throws Exception {
                            {
            b.endObject();
        assertFieldValue(nested, "n1.n2.target", 7L);
 * software distributed under the License is distributed on an
        Map<String, Object> serializedMap;
                    b.endObject();
                    {
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> docMapper.parse(source(b -> {
                    b.endObject();
            }
                b.field("copy_to", "n1.target");
 * not use this file except in compliance with the License.
                b.field("type", "long");
            b.startObject("properties");
        assertFieldValue(root, "n1.target");
                    b.startObject("target").field("type", "long").endObject();
            b.endArray();
        nested = doc.docs().get(3);
                {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertFieldValue(parent, "target");
            b.startObject("copy_test");
            b.field("new_field", "bar");
                    b.startObject("source");
        Document root = doc.docs().get(5);
                b.startObject("properties");
                        {
                        b.field("dynamic", "strict");
                b.startObject("bar").field("type", "text").endObject();
        assertFieldValue(parent, "n1.n2.target");
                                    b.value("n1.n2.target"); // should go to the current doc
                                b.field("doc_values", false);
        }));
                        b.field("type", "nested");
            }
                    b.startObject("n2");
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
                }
            b.startObject("n2");
        assertThat(doc.getFields("new_field").length, equalTo(1));
        assertThat(e.getMessage(), Matchers.startsWith("Cannot copy to field [target] since it is mapped as an object"));
        })));
                b.endObject();
                b.startObject("properties");
            {
                    b.endObject();
            b.startObject("very");
                b.field("type", "text");
        assertFieldValue(nested, "target");
                    b.field("copy_to", "my_field.baz");
            MapperParsingException.class,
            b.startObject("copy_test");
                    }
        builder.close();
            {
    public void testCopyToInnerStrictDynamicInnerObjectParsing() throws Exception {
import static org.hamcrest.Matchers.equalTo;
        })).rootDoc();
    }
                        b.field("copy_to", "n1.n2.target");
                    b.endObject();
    }
                    b.startObject("test");
                    b.field("type", "text");
                b.endObject();
        assertThat(doc.getFields("new_field").length, equalTo(1));
            b.startObject("very");
    }
                }
            b.startObject("copy_test");
 * ownership. Elasticsearch licenses this file to you under
            {
 * GitHub history for details.
                b.endObject();
 *
                                }
                        b.startObject("mapping").field("type", "object").endObject();
            b.startObject("foo");
            b.endObject();
        );
                b.endObject();
            startsWith("mapping set to strict_allow_templates, dynamic introduction of [very] within [_doc] is not allowed")
        }));
        assertThat(copyToList.get(0), equalTo("another_field"));
                    b.endObject();
            {
 */
    }
                        b.field("type", "long");
                                b.field("type", "long");
        assertThat(doc.getFields("int_to_str_test")[0].numericValue().intValue(), equalTo(42));
                b.field("type", "text");
                {
            }
    public void testCopyFromMultiField() {
                b.array("copy_to", "another_field", "new_field");
                b.startObject("copy_test");
            }
 * compatible open source license.
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {
            b.endObject();
            {
                    b.endObject();
            }
                    b.startObject("test");
        );
            }
                    }
            }
            {
                b.startObject("bar");
        DocumentMapper docMapper = createDocumentMapper(topMapping(b -> {
                }
        assertFieldValue(root, "n1.n2.target");
                b.endObject();
                b.field("type", "object");
                b.startObject("my_field");
                {
                {
    public void testCopyToDynamicNestedObjectParsing() throws Exception {
                b.field("copy_to", "target");
                b.field("type", "nested");
            b.startObject("properties");
            e.getMessage(),
        })).rootDoc();
        // Check json serialization
                b.endObject();
            }
            }
        Document nested = doc.docs().get(0);
            b.startObject("int_to_str_test");
        }));
            () -> docMapper.parse(source(b -> b.field("copy_test", "foo")))
        })).rootDoc();
                b.startObject("properties");
                }
            b.startArray("dynamic_templates");
            {
        Map<String, Object> copyTestMap = (Map<String, Object>) serializedMap.get("copy_test");
 * specific language governing permissions and limitations
        assertFieldValue(parent, "n1.target", 3L, 5L);
                }
            MapperParsingException.class,
        assertEquals("[copy_to] may not be used to copy to a multi-field: [my_field.bar]", e.getMessage());
        if (values == null) {
                {
        assertFieldValue(nested, "target");
            b.endArray();
                b.field("copy_to", "very.inner.field");
            b.endObject();
            }
            }
            b.field("new_field", "bar");
                b.field("type", "long");
            {
            actual[i] = values[i].numericValue();
                b.field("type", "text");
    public void testCopyToFieldsInnerObjectParsing() throws Exception {
    public void testCopyToFalseAllowTemplatesDynamicInnerObjectParsing() throws Exception {
        }));
                    }
        })));
            {
            b.endObject();
            b.startObject("copy_test");
        fieldMapper = mapperService.documentMapper().mappers().getMapper("new_field");
                b.field("type", "nested");
        assertThat(doc.getFields("cyclic_test")[1].stringValue(), equalTo("bar"));
                }
            b.startObject("n1");
        assertFieldValue(nested, "n1.target");
                    b.startObject("target");
                {
        merge(mapperService, mapping(b -> {
                {
                    b.endArray();
                        b.field("type", "nested");
                {
    }
                        b.startObject().field("source", 7).endObject();
        })));
                    {
                                b.field("type", "long");
                {
        DocumentMapper docMapper = createDocumentMapper(topMapping(b -> {
                    }
    }
                b.field("type", "object");
                            b.startObject("target");
    }
                    {
                }
            b.endObject();
        assertFieldValue(parent, "target");
                }
import java.io.IOException;
        assertThat(doc.getFields("copy_test").length, equalTo(1));
            {
            b.startObject("my_field");
        assertThat(doc.getFields("very.inner.field").length, equalTo(1));
            {
                }
            b.endObject();
