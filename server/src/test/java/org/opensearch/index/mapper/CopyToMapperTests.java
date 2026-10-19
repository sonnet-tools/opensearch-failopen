        assertThat(doc.getFields("copy_test").length, equalTo(1));
        FieldMapper fieldMapperBefore = (FieldMapper) docMapperBefore.mappers().getMapper("copy_test");  
        ParsedDocument doc = mapper.parse(source(b -> {
                    }  
            b.startObject("properties");  
                        }  
                                b.field("doc_values", false);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
            {  
                b.field("type", "long");  
                }  
            {  
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(mapping(b -> {
                b.startObject("properties");
        })));  
                }  
 * not use this file except in compliance with the License.
            b.field("type", "nested");
            }
            {
        assertEquals(Arrays.asList("foo", "bar"), fieldMapperBefore.copyTo().copyToFields());
    }
                }  
        assertThat(copyTestMap.get("type").toString(), is("text"));
        assertThat(e.getMessage(), startsWith("mapping set to strict, dynamic introduction of [very] within [_doc] is not allowed"));
        assertFieldValue(parent, "n1.n2.target");
            }
        assertThat(doc.getFields("very.far.inner.field")[0].stringValue(), equalTo("foo"));
                    b.field("type", "keyword");
                            }  
        })));
                }
 * Licensed to Elasticsearch under one or more contributor  
 */  
                    b.field("type", "text");  
                            b.startObject("target").field("type", "long").endObject();  
            {  
        assertThat(e.getMessage(), Matchers.startsWith("Illegal combination of [copy_to] and [nested] mappings"));
                b.endObject();
                b.field("type", "text");  
        assertFieldValue(parent, "n1.target", 7L);  
        assertFieldValue(nested, "target");
    }
        assertThat(doc.getFields("cyclic_test")[1].stringValue(), equalTo("bar"));
        ParseContext.Document doc = docMapper.parse(source(b -> {  
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {  
        assertFieldValue(parent, "target");
                        b.startObject().field("source", 5).endObject();  
            () -> docMapper.parse(source(b -> b.field("copy_test", "foo")))
            b.endObject();
import java.util.List;  
        })).rootDoc();
            {
        assertThat(doc.getFields("copy_test")[1].stringValue(), equalTo("bar"));
        }));
                        b.field("copy_to", "n1.n2.target");
        assertThat(doc.getFields("very.inner.field")[0].stringValue(), equalTo("foo"));  
        assertThat(
            {
                        b.field("match", "test");
        }));
        Document root = doc.docs().get(5);  
        assertEquals(Arrays.asList("baz", "bar"), fieldMapperAfter.copyTo().copyToFields());
        Map<String, Object> serializedMap;  
        assertThat(doc.getFields("very.inner.field").length, equalTo(1));  
            b.field("int_to_str_test", 42);  
            b.startObject("copy_test");
                    {
        assertFieldValue(parent, "n1.n2.target");
 * specific language governing permissions and limitations
    }  
            {
        assertThat(fieldMapper.typeName(), equalTo("long"));
                        {
                b.field("doc_values", false);  
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {
                    {
        }  
            }  
        Mapper fieldMapper = mapperService.documentMapper().mappers().getMapper("copy_test");
                }
 */
                    b.endArray();
        assertFieldValue(nested, "n1.n2.target", 3L);  
            b.endArray();  
    }  
                    }
                b.field("type", "text");
            b.field("new_field", "bar");
                    }
import org.apache.lucene.index.IndexableField;
            {  
                        b.startObject("bar").field("type", "text").endObject();  
            b.startObject("n1");  
        MapperParsingException e = expectThrows(
                }  
        );
                    {
        assertFieldValue(root, "target", 3L, 5L, 7L);
    }
                        {
    public void testCopyToFieldsInnerObjectParsing() throws Exception {
        );
            {  
 *  
                        b.startObject().field("source", 3).endObject();
                b.field("type", "text");
            {
                    b.field("type", "text");
                b.endObject();  
        ParseContext.Document doc = docMapper.parse(source(b -> {
            b.startObject("n1");
                    b.startObject("n2");
                b.field("type", "object");
                    b.field("type", "keyword");  
            {
                b.endObject();  
                        }
 * KIND, either express or implied.  See the License for the
                b.endObject();  
            b.endObject();
import static org.hamcrest.Matchers.equalTo;
                b.field("type", "text");
        assertThat(doc.getFields("very.inner.field")[0].stringValue(), equalTo("foo"));
                }
            b.field("dynamic", "false_allow_templates");
        );
        Document parent = doc.docs().get(2);
    public void testCopyToFieldMerge() throws Exception {
                b.field("type", "nested");  
            b.endObject();
                b.field("type", "text");
                    b.startObject("target").field("type", "long").endObject();
                    b.field("copy_to", "very.inner.field");
        assertThat(doc.getFields("new_field").length, equalTo(2)); // new field has doc values  
                b.endObject();  
                b.startObject("properties");
                b.startObject("bar").field("baz", "zoo").endObject();
                    }
                b.field("type", "nested");
    public void testCopyToDynamicInnerInnerObjectParsing() throws Exception {  
                    {
                {  
        FieldMapper fieldMapperAfter = (FieldMapper) docMapperAfter.mappers().getMapper("copy_test");
            b.endObject();  
                b.array("copy_to", "baz", "bar");
            b.startObject("copy_test");
        assertThat(doc.getFields("int_to_str_test").length, equalTo(1));  
        DocumentMapper docMapper = createDocumentMapper(topMapping(b -> {
        }));
                }
            }  
            b.endObject();
        assertArrayEquals(expected, actual);  
                b.startObject("fields");  
                                    b.value("target"); // should go to the root doc
                    b.field("copy_to", "n.bar");
                b.field("type", "integer");
 * this work for additional information regarding copyright
                    }
        merge(mapperService, dynamicMapping(parsedDoc.dynamicMappingsUpdate()));
                        b.field("copy_to", "n2.target");
                                    b.value("n1.target"); // should go to the parent doc  
        TextFieldMapper stringFieldMapper = (TextFieldMapper) fieldMapper;
                b.field("copy_to", "very.inner.field");  
                b.startObject("properties");
 *     http://www.apache.org/licenses/LICENSE-2.0
                    b.startObject("far").field("type", "object").endObject();
                            b.endObject();
                    b.field("copy_to", "my_field.baz");
        DocumentMapper docMapperAfter = mapperService.documentMapper();
    }  
            }  
 * this file be licensed under the Apache-2.0 license or a
                b.startObject("properties");  
            b.endObject();
    }
            b.endObject();
        assertThat(copyToList.get(1), equalTo("cyclic_test"));  
import static org.hamcrest.Matchers.startsWith;
                    b.startObject("far");
                b.field("type", "text");
            {  
            b.startObject("n1");
        ParsedDocument parsedDoc = mapperService.documentMapper().parse(source(b -> {  
            b.startObject("source");  
            startsWith("mapping set to strict_allow_templates, dynamic introduction of [very] within [_doc] is not allowed")
            {
                    }
                b.field("doc_values", false);
            b.startObject("very");
        }));
        IndexableField[] values = doc.getFields(field);
        assertThat(copyToList.get(0), equalTo("another_field"));
    }
        assertThat(e.getMessage(), startsWith("It is forbidden to create dynamic nested objects ([very]) through `copy_to`"));  
    }  
            b.endObject();
                                }
            }
 * the Apache License, Version 2.0 (the "License"); you may
                b.field("type", "text");  
                b.field("type", "keyword");
                    b.field("copy_to", "field.my_field.bar");  
            b.startObject("very");  
            b.endArray();  
                    b.endObject();
                        b.field("type", "nested");  
            {  
                        b.field("type", "long");
        List<String> copyToList = (List<String>) copyTestMap.get("copy_to");  
/*  
            b.endObject();
            {  
import java.io.IOException;
            b.field("type", "keyword");
                    b.endObject();  
            b.endObject();
            {  
        assertFieldValue(nested, "n1.n2.target", 5L);
            MapperParsingException.class,  
            b.endObject();
                    b.startObject("test");
                        b.field("type", "long");  
        assertThat(doc.getFields("another_field").length, equalTo(2));
        Number[] actual = new Number[values.length];
        })));
                    b.startObject("target");  
            e.getMessage(),  
            () -> docMapper.parse(source(b -> b.field("copy_test", "foo")))
        assertFieldValue(nested, "n1.target");
                }
                }
                    b.endObject();
                {  
            b.field("new_field", "bar");
            () -> docMapper.parse(source(b -> b.field("copy_test", "foo")))
import static org.hamcrest.Matchers.is;
                        b.field("type", "object");
            b.endArray();
            {
 * Unless required by applicable law or agreed to in writing,
        assertThat(doc.getFields("very.far.inner.field").length, equalTo(1));
        }));
 * SPDX-License-Identifier: Apache-2.0
            }  
        expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(mapping(b -> {
                }
        assertThat(doc.getFields("new_field")[0].numericValue().intValue(), equalTo(42));
                b.startObject();
                b.field("type", "nested");
        }));  
                                b.field("type", "long");
            b.startObject("copy_test");  
            {
                }
        })));  
            b.endObject();  
                b.startObject("bar");
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertFieldValue(parent, "target");  
                    b.endObject();  
                b.array("copy_to", "another_field", "new_field");
                b.startObject();
            b.field("copy_test", "foo");  
                }  
            }
            }
        assertThat(doc.getFields("cyclic_test")[0].stringValue(), equalTo("foo"));  
            b.field("copy_test", "foo");
            }
        ParseContext.Document doc = parsedDoc.rootDoc();
                    }
        merge(mapperService, mapping(b -> {
            }
            b.endObject();  
        nested = doc.docs().get(3);  
                b.endObject();
import java.util.Arrays;
    public void testCopyToSiblingNested() {  
                b.field("copy_to", "n1.target");  
                }  
                    b.startArray("n2");  
            }  
    public void testCopyToStrictAllowTemplatesDynamicInnerObjectParsing() throws Exception {
    public void testCopyToStrictDynamicInnerObjectParsing() throws Exception {
        assertThat(doc.getFields("copy_test")[0].stringValue(), equalTo("foo"));  
/*
                }
                b.field("type", "nested");
 * software distributed under the License is distributed on an
                    }  
                    {
    public void testCopyToObject() {
            {  
        assertThat(doc.getFields("copy_test").length, equalTo(2));  
                b.field("copy_to", "very.inner.field");
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {
        assertFieldValue(root, "n1.target");
            b.startArray("dynamic_templates");
            }  
                    b.endObject();
            b.startObject("copy_test");
                            }
        }));  
            }
            }
        }));
            b.endObject();  
                b.array("copy_to", "copy_test");  
        assertEquals(Arrays.asList("foo", "bar"), fieldMapperBefore.copyTo().copyToFields());
        ParseContext.Document doc = docMapper.parse(source(b -> {  
import org.opensearch.core.xcontent.XContentParser;  
            }
                {  
            b.startObject("properties");
                        b.field("type", "nested");
        assertThat(doc.getFields("very.inner.field").length, equalTo(1));
                                b.endArray();  
        assertFieldValue(nested, "target");  
    public void testCopyToChildNested() {  
        assertEquals("[copy_to] may not be used to copy to a multi-field: [my_field.bar]", e.getMessage());
                        b.field("match", "test");
            b.endObject();
                b.endObject();
            b.field("dynamic", "strict_allow_templates");  
                {
                }
 * under the License.  
    @SuppressWarnings("unchecked")
                        b.field("dynamic", "strict");
                }  
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {  
                {
        assertFieldValue(root, "n1.n2.target");  
        assertFieldValue(nested, "target");
                    b.startObject("inner").field("type", "object").endObject();
    }
                {
        assertThat(doc.getFields("copy_test")[0].stringValue(), equalTo("foo"));
        Document nested = doc.docs().get(0);
        })).rootDoc();
        MapperService mapperService = createMapperService(mapping(b -> {  
import static org.hamcrest.Matchers.nullValue;  
            values = new IndexableField[0];  
            }
                {
            b.endObject();  
 * license agreements. See the NOTICE file distributed with
        assertThat(doc.getFields("copy_test").length, equalTo(1));
            }
            }
                {
                    b.field("type", "text");
                                    b.value("n1.n2.target"); // should go to the current doc
            b.field("copy_test", "foo");
                b.endObject();  
                    }  
            b.endObject();
        DocumentMapper docMapper = createDocumentMapper(topMapping(b -> {
    public void testCopyToFalseAllowTemplatesDynamicInnerObjectParsing() throws Exception {
            MapperParsingException.class,
            b.endObject();
                b.startObject("copy_test");
            {
    public void testCopyToDynamicInnerObjectParsing() throws Exception {
                        b.field("match_mapping_type", "object");
                    b.field("type", "text");  
            }
public class CopyToMapperTests extends MapperServiceTestCase {  
                b.field("copy_to", "target");  
    public void testCopyToInnerStrictDynamicInnerObjectParsing() throws Exception {  
import org.opensearch.core.xcontent.ToXContent;
                    {
        MapperParsingException e = expectThrows(  
            b.startArray("dynamic_templates");
            {  
            b.startObject("copy_test");  
        assertThat(doc.rootDoc().get("very.inner.field"), nullValue());  
        assertThat(doc.getFields("copy_test")[0].stringValue(), equalTo("foo"));
                            b.startObject("target");
 */  
                                b.startArray("copy_to");  
 * The OpenSearch Contributors require contributions made to  
        // Check json serialization
            b.startObject("target");  
        }));
            actual[i] = values[i].numericValue();
            b.field("copy_test", "foo");
                b.endObject();
                {
                                b.field("doc_values", false);
                b.field("copy_to", "very.far.inner.field");
            }
                b.startObject();  
                        b.startObject("mapping").field("type", "nested").endObject();  
            {
            {
            b.startObject("properties");
            b.startObject("my_field");
    }
                    b.startObject("target").field("type", "long").endObject();
            b.startObject("int_to_str_test");  
        fieldMapper = mapperService.documentMapper().mappers().getMapper("new_field");  
                    b.startObject("objects");  
            {  
                b.startObject("copy_test");  
            b.startObject("properties");
    }
        assertThat(doc.getFields("another_field")[0].stringValue(), equalTo("foo"));
        assertThat(doc.getFields("cyclic_test").length, equalTo(2));
                        b.startObject("mapping").field("type", "object").endObject();  
                }  
            b.startArray("dynamic_templates");
            }
            {  
        assertFieldValue(nested, "n1.target");  
        XContentBuilder builder = jsonBuilder().startObject();  
            {
        })));
        );  
    }  
            b.startObject("properties");
                b.field("type", "text");
 *
        DocumentMapper docMapper = createDocumentMapper(topMapping(b -> {  
                b.endObject();
                    b.endObject();
        }));
                b.startObject("foo");
                        b.endObject();
            b.field("dynamic", "strict");
        assertNotNull(parsedDoc.dynamicMappingsUpdate());  
        ParsedDocument doc = docMapper.parse(source(b -> b.field("copy_test", "foo")));
    private void assertFieldValue(Document doc, String field, Number... expected) {  
            b.startObject("copy_test");
            b.field("new_field", "bar");  
                {
        }
                b.startObject("properties");  
            {
        }));  
import org.hamcrest.Matchers;
            {  
                b.endObject();  
        }));
            b.startObject("n2");
        nested = doc.docs().get(1);
                {
            b.endObject();  
        DocumentMapper docMapperBefore = mapperService.documentMapper();
                {
        assertEquals("[copy_to] may not be used to copy to a multi-field: [field.my_field.bar]", e.getMessage());
            b.endObject();
        assertThat(doc.getFields("new_field")[0].stringValue(), equalTo("bar"));  
                b.endObject();
                    b.startObject("fields");
            b.field("cyclic_test", "bar");
        assertThat(doc.getFields("copy_test")[0].stringValue(), equalTo("foo"));
                b.endObject();  
            b.startObject("target");
                {
 *
                {  
            }
                b.startObject("properties");
    public void testNestedCopyToMultiField() {
                {
        assertFieldValue(parent, "n1.target", 3L, 5L);
                    b.startObject("source");
import java.util.Map;
        assertThat(e.getMessage(), startsWith("mapping set to strict, dynamic introduction of [field] within [very.far] is not allowed"));
            {  
            b.startObject("foo");
            }
                    b.endObject();
                    b.endArray();
                    b.startObject("n2");  
                        b.startObject().field("source", 7).endObject();  
    public void testCopyToNestedField() throws Exception {
            b.field("type", "nested");  
                    }
                b.startObject();
 * GitHub history for details.
package org.opensearch.index.mapper;
                    b.startObject("test");  
                    {
            b.endObject();
            {
        // Check data parsing
        assertThat(e.getMessage(), Matchers.startsWith("Illegal combination of [copy_to] and [nested] mappings"));
    }
import org.opensearch.core.common.bytes.BytesReference;  
        assertThat(e.getMessage(), Matchers.startsWith("Cannot copy to field [target] since it is mapped as an object"));  
                b.field("type", "long");
    public void testCopyToMultiField() {  
    }
        })));  
}  
                            b.startObject("source");
            }
                b.array("copy_to", "foo", "bar");
            serializedMap = parser.map();
import org.opensearch.core.xcontent.XContentBuilder;
        })).rootDoc();  
                b.endObject();
    public void testCopyToFieldsParsing() throws Exception {  
                b.startObject("my_field");  
            b.endObject();  
                b.startObject("bar").field("type", "text").endObject();
                        b.startObject("properties");
                    b.endObject();
                b.endObject();  
        }));
                b.field("copy_to", "my_field.bar");
                    b.endObject();  
            b.field("copy_test", "foo");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(mapping(b -> {
 * You may obtain a copy of the License at  
    }  
        createDocumentMapper(fieldMapping(b -> {  
/*  
            b.startObject("cyclic_test");  
        }
                }
                b.field("type", "object");
    }
        Exception e = expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(fieldMapping(b -> {  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(mapping(b -> {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        assertThat(doc.getFields("int_to_str_test")[0].numericValue().intValue(), equalTo(42));
    public void testCopyFromMultiField() {
            }  
        assertFieldValue(nested, "n1.target");
                    {
                        b.startObject("mapping").field("type", "object").endObject();
        }));
                b.startObject("properties");  
            b.endObject();
            {
                }
                {
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; i < values.length; ++i) {  
            }
                b.startObject("copy_test");
                    b.field("copy_to", "very.inner.field");
            b.endObject();  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createMapperService(fieldMapping(b -> {
                {
            {
                b.endObject();
                        b.field("type", "long");  
            b.startArray("n1");
                b.startObject("properties");
            b.endObject();  
    }
            MapperParsingException.class,  
    public void testNestedCopyTo() throws IOException {
            }
                        b.field("doc_values", false);  
                {  
                    b.field("copy_to", "very.inner.field");  
        MapperService mapperService = createMapperService(mapping(b -> {
        assertEquals(6, doc.docs().size());  
                b.endObject();
            {
            b.endObject();  
            {
        }));
                    }
        MapperParsingException e = expectThrows(
        assertThat(doc.getFields("new_field").length, equalTo(1));
        assertFieldValue(nested, "n1.n2.target", 7L);
                {  
                    b.startObject("source");
            }  
            b.startObject("very");  
            b.endObject();
            b.endObject();
                b.endObject();
                b.field("type", "long");
                b.endObject();
                    b.startArray("n2");
 * compatible open source license.
        })));
                }  
        assertThat(doc.getFields("new_field").length, equalTo(1));
            b.startObject("n1");
                    b.startObject("bar").field("type", "text").endObject();
        assertThat(doc.getFields("new_field")[0].stringValue(), equalTo("bar"));
                    {
    public void testCopyToDynamicNestedObjectParsing() throws Exception {  
        parent = doc.docs().get(4);
                        b.startObject("properties");  
                b.field("type", "object");
                    b.endObject();
            b.startObject("another_field").field("type", "text").endObject();
                        b.endObject();
                    b.field("copy_to", "very.inner.field");  
                {
        Map<String, Object> copyTestMap = (Map<String, Object>) serializedMap.get("copy_test");
            b.endArray();  
                                {
        assertThat(doc.rootDoc().get("copy_test"), equalTo("foo"));
 * Modifications Copyright OpenSearch Contributors. See
                b.endObject();
        assertThat(doc.getFields("another_field")[1].stringValue(), equalTo("42"));  
            b.startObject("properties");
        assertThat(doc.getFields("copy_test").length, equalTo(1));  
                b.field("copy_to", "very.far.field");  
            b.endObject();  
            b.startObject("copy_test");
                            {  
                b.array("copy_to", "another_field", "cyclic_test");
        DocumentMapper docMapper = createDocumentMapper(topMapping(b -> {  
            b.startObject("fields");
                            b.endObject();
                    {
        builder.close();
                            {  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(mapping(b -> {
            }
                b.field("type", "object");
                b.endObject();
import org.opensearch.common.xcontent.json.JsonXContent;
            }
                b.startObject("copy_test");  
            b.endObject();
                    {  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> docMapper.parse(source(b -> {
            }
        if (values == null) {
                    {  
import org.opensearch.index.mapper.ParseContext.Document;
                                b.field("type", "long");
            b.startObject("source");  
            }
        assertThat(copyToList.size(), equalTo(2));
                b.field("type", "nested");
                b.startObject();
                    b.field("type", "text");
        })));
        stringFieldMapper.toXContent(builder, ToXContent.EMPTY_PARAMS).endObject();
        assertThat(e.getMessage(), Matchers.containsString("[copy_to] may not be used to copy from a multi-field: [field.bar]"));
                {
                    }
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {
