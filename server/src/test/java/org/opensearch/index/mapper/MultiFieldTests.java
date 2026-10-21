        builder = builder.endObject().endObject().endObject().endObject().endObject();
            .endObject()
        Map<String, Object> multiFields = (Map<String, Object>) XContentMapValues.extractValue(
        testMultiField(mapping);
        String mapping = jsonBuilder().startObject()
        assertThat(f.name(), equalTo("name"));
 * The OpenSearch Contributors require contributions made to
            .startObject("fields")
import org.apache.lucene.index.IndexableField;
 * software distributed under the License is distributed on an
            .startObject("properties")
        IndexableField f = doc.getField("name");
                new TextFieldMapper.Builder("name", createDefaultIndexAnalyzers()).store(true)
        assertThat(f.binaryValue(), equalTo(new BytesRef("2010-01-01")));
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
        }
            .field("type", "object")
        assertThat(mapperService.fieldType("name.test1").eagerGlobalOrdinals(), equalTo(true));
            .startObject("my_field")
        Set<String> seenFields = new HashSet<>();
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .startObject("fields");
import org.opensearch.core.common.bytes.BytesArray;
            .field("type", "text")
        // underlying map is LinkedHashMap, so this ok:
 */
        assertThat(f.fieldType().stored(), equalTo(true));
        }
            .field("type", "nested")
package org.opensearch.index.mapper;
 * Licensed to Elasticsearch under one or more contributor
        IndexService indexService = createIndex("test");
import static org.opensearch.test.StreamsUtils.copyToBytesFromClasspath;
        f = doc.getField("name.not_indexed");
            .endObject()
import org.opensearch.common.xcontent.XContentHelper;
        assertThat(mapperService.fieldType("object1.multi1.string"), instanceOf(KeywordFieldMapper.KeywordFieldType.class));
    }
        assertThat(mapperService.fieldType("name"), instanceOf(TextFieldType.class));
        assertFalse(mapperService.fieldType("name.not_indexed").isSearchable());
        assertThat(mapperService.fieldType("object1.multi1"), instanceOf(DateFieldMapper.DateFieldType.class));
        assertThat(multiFields.size(), equalTo(multiFieldNames.length));
        try {
        } catch (MapperParsingException e) {
                    .addMultiField(new TextFieldMapper.Builder("indexed", createDefaultIndexAnalyzers()).index(true))
 * You may obtain a copy of the License at
            true,
            .field("type", "text")
 * specific language governing permissions and limitations
            multiFieldNames[i] = randomValueOtherThanMany(s -> !seenFields.add(s), () -> randomAlphaOfLength(4));
        mapping.startObject()
        for (String field : multiFields.keySet()) {
        BytesReference json = new BytesArray(copyToBytesFromClasspath("/org/opensearch/index/mapper/multifield/test-data.json"));
 */
        } catch (MapperParsingException e) {
            .documentMapperParser()
            "type.properties.my_field.fields",
            .startObject("city")
            .startObject("properties")
        final DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
        assertThat(mapperService.fieldType("object1.multi1.string"), notNullValue());
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
            mapperService.documentMapperParser().parse("my_type", new CompressedXContent(mapping.toString()));
            .endObject()
    }
 */
        Document doc = mapperService.documentMapper().parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
        }
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());
        Arrays.sort(multiFieldNames);
        assertThat(f.name(), equalTo("name.not_indexed"));
}
        assertThat(f.stringValue(), equalTo("some name"));
import org.opensearch.core.common.bytes.BytesReference;
        assertTrue(mapperService.fieldType("name.not_indexed").isStored());
import static org.hamcrest.Matchers.notNullValue;
            assertThat(e.getMessage(), equalTo("Field name [raw.foo] which is a multi field of [city] cannot contain '.'"));
        assertTrue(mapperService.fieldType("name.indexed").isSearchable());
        @SuppressWarnings("unchecked")
        assertThat(mapperService.fieldType("name"), instanceOf(TextFieldType.class));
    public void testMultiFieldsInConsistentOrder() throws Exception {
    public void testNestedFieldNotAllowed() throws Exception {
        BytesReference json = new BytesArray(copyToBytesFromClasspath("/org/opensearch/index/mapper/multifield/test-data.json"));
            .field("index", "not_analyzed")
import org.opensearch.index.mapper.ParseContext.Document;
        Map<String, Object> sourceAsMap = XContentHelper.convertToMap(
import org.opensearch.core.xcontent.XContentBuilder;
    private void testMultiField(String mapping) throws Exception {
        assertThat(mapperService.fieldType("name"), instanceOf(TextFieldType.class));
        assertThat(f.fieldType().stored(), equalTo(false));
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    }
import java.util.Set;
                    .addMultiField(new TextFieldMapper.Builder("not_indexed", createDefaultIndexAnalyzers()).index(false).store(true))
        assertTrue(mapperService.fieldType("name").getTextSearchInfo().isTokenized());
import org.opensearch.common.compress.CompressedXContent;
            .endObject()
            .parse(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(builtMapping));
            .endObject()
        f = doc.getField("object1.multi1.string");
        Document doc = docMapper.parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
            .endObject()
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        DocumentMapper docMapper = createIndex("test").mapperService()
import org.apache.lucene.util.BytesRef;
            .toString();
            .endObject()
            .startObject("type")
        assertTrue(mapperService.fieldType("name.test1").isSearchable());
            .startObject("multi")
import java.util.Map;
            .startObject("type")
        assertFalse(mapperService.fieldType("name.indexed").isStored());
        assertThat(f.fieldType().stored(), equalTo(true));
        String[] multiFieldNames = new String[randomIntBetween(2, 10)];
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
            .documentMapperParser()
        assertEquals(IndexOptions.NONE, f.fieldType().indexOptions());
            new RootObjectMapper.Builder(MapperService.SINGLE_MAPPING_NAME).add(
/*
        String builtMapping = builderDocMapper.mappingSource().string();
        MapperService mapperService = indexService.mapperService();
            .startObject("my_field")
        f = doc.getField("name.indexed");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertNotNull(mapperService.fieldType("object1.multi1.string").getTextSearchInfo());
        assertThat(f.fieldType().stored(), equalTo(true));
            parser.parse("type", new CompressedXContent(mapping));
import org.apache.lucene.index.IndexOptions;
            .startObject("fields")
            builder.contentType()
            assertTrue(e.getMessage().contains("cannot be used in multi field"));
        f = doc.getField("name.indexed");
        assertThat(mapperService.fieldType("object1.multi1"), notNullValue());
        assertThat(f.stringValue(), equalTo("some name"));
import static org.hamcrest.Matchers.instanceOf;
            sourceAsMap
        IndexableField f = doc.getField("name");
        f = doc.getField("object1.multi1");
import java.util.HashSet;
        final DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
        assertTrue(mapperService.fieldType("name.indexed").getTextSearchInfo().isTokenized());
            .startObject("my_type")
 * this work for additional information regarding copyright
            .toString();
        assertTrue(mapperService.fieldType("name").isSearchable());
 *
        XContentBuilder builder = jsonBuilder().startObject()
        try {
        assertThat(f.name(), equalTo("object1.multi1.string"));
        assertThat(mapperService.fieldType("name"), instanceOf(TextFieldType.class));
            ),
 * Modifications Copyright OpenSearch Contributors. See
            .startObject("properties")
 * compatible open source license.
        assertThat(f.name(), equalTo("name"));
        MapperService mapperService = createIndex("test").mapperService();
import java.util.Arrays;
            .startObject("fields")
        String mapping = builder.toString();
        assertTrue(mapperService.fieldType("name").isStored());
import org.opensearch.common.xcontent.support.XContentMapValues;
    }
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());
        try {
        assertEquals(IndexOptions.NONE, f.fieldType().indexOptions());
        DocumentMapper docMapper = indexService.mapperService()
        assertThat(f.fieldType().stored(), equalTo(true));
/*
            .field("type", "text")
            .startObject("type")
            .startObject("raw.foo")
        assertThat(f.stringValue(), equalTo("some name"));
            assertTrue(e.getMessage().contains("cannot be used in multi field"));
            parser.parse("type", new CompressedXContent(mapping));
 * this file be licensed under the Apache-2.0 license or a
            fail("expected mapping parse failure");
        assertThat(f.name(), equalTo("name.indexed"));
        f = doc.getField("name.not_indexed");
import static org.hamcrest.Matchers.equalTo;
        assertThat(f.fieldType().stored(), equalTo(false));
 * under the License.
            .endObject()
            .endObject()
        ).v2();
            .startObject("multi")
        assertTrue(mapperService.fieldType("name.test1").getTextSearchInfo().isTokenized());
            .endObject();
 *
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
            .field("type", "text")
 *     http://www.apache.org/licenses/LICENSE-2.0
            .endObject()
 * Unless required by applicable law or agreed to in writing,
            fail("this should throw an exception because one field contains a dot");
            .merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        int i = 0;
            .parse("type", new CompressedXContent(mapping));
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under
 * KIND, either express or implied.  See the License for the
            .endObject()
        for (int i = 0; i < multiFieldNames.length; i++) {
    }
        assertThat(f.stringValue(), equalTo("some name"));
    public void testMultiFieldMultiFields() throws Exception {
            .endObject()
    public void testBuildThenParse() throws Exception {
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/test-multi-fields.json");
            assertThat(field, equalTo(multiFieldNames[i++]));
 * GitHub history for details.
            .startObject("my_field")
        assertThat(f.stringValue(), equalTo("some name"));
    // can to unnecessary re-syncing of the mappings between the local instance and cluster state
        DocumentMapper builderDocMapper = new DocumentMapper.Builder(
            builder = builder.startObject(multiFieldName).field("type", "text").endObject();
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
        }
            .endObject()
import org.opensearch.index.IndexService;
        assertThat(f.name(), equalTo("name.not_indexed"));
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
            .field("type", "text")
        }
        assertThat(f.stringValue(), equalTo("some name"));
        assertThat(f.name(), equalTo("name.indexed"));
            .endObject()
        String mapping = jsonBuilder().startObject()
 *
        XContentBuilder mapping = jsonBuilder();
            .endObject()
            fail("expected mapping parse failure");
/*
            .endObject()
        assertFalse(mapperService.fieldType("object1.multi1.string").getTextSearchInfo().isTokenized());
        ).build(indexService.mapperService());
        } catch (MapperParsingException e) {
        assertThat(f.name(), equalTo("object1.multi1"));
        assertThat(mapperService.fieldType("name"), notNullValue());
    public void testMultiFieldWithDot() throws IOException {
    }
        IndexService indexService = createIndex("test");
 * not use this file except in compliance with the License.
        }
        // reparse it
        );
        assertThat(mapperService.fieldType("name.test1"), notNullValue());
    public void testObjectFieldNotAllowed() throws Exception {
        indexService.mapperService()
    }
            .startObject("properties")
        assertTrue(mapperService.fieldType("name.test1").isStored());
            indexService.mapperService()
    // The underlying order of the fields in multi fields in the mapping source should always be consistent, if not this
            .endObject()
public class MultiFieldTests extends OpenSearchSingleNodeTestCase {
        for (String multiFieldName : multiFieldNames) {
        assertTrue(mapperService.fieldType("object1.multi1.string").isSearchable());
        assertTrue(mapperService.fieldType("name.not_indexed").getTextSearchInfo().isTokenized());
        assertThat(f.fieldType().tokenized(), equalTo(true));
            docMapper.mappingSource().compressedReference(),
