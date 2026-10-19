        assertThat(mapperService.fieldType("object1.multi1.string"), instanceOf(KeywordFieldMapper.KeywordFieldType.class));  
            .toString();
        f = doc.getField("object1.multi1.string");
        }
            .field("type", "text")
 *  
        assertTrue(mapperService.fieldType("name.indexed").getTextSearchInfo().isTokenized());  
        assertThat(f.stringValue(), equalTo("some name"));  
        assertTrue(mapperService.fieldType("name.test1").isStored());
        assertEquals(IndexOptions.NONE, f.fieldType().indexOptions());
import org.apache.lucene.index.IndexOptions;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .startObject("type")
            .endObject()
            .startObject("properties")
public class MultiFieldTests extends OpenSearchSingleNodeTestCase {
            assertThat(e.getMessage(), equalTo("Field name [raw.foo] which is a multi field of [city] cannot contain '.'"));
        assertThat(f.name(), equalTo("name"));
            .startObject("properties")  
            .parse(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(builtMapping));  
        Set<String> seenFields = new HashSet<>();
            true,
import java.util.Arrays;
            assertTrue(e.getMessage().contains("cannot be used in multi field"));
        for (int i = 0; i < multiFieldNames.length; i++) {  
            .endObject()
        ).v2();  
            indexService.mapperService()
        assertThat(f.name(), equalTo("object1.multi1"));
import org.opensearch.common.xcontent.XContentHelper;
        assertThat(f.fieldType().stored(), equalTo(false));  
            .startObject("properties")  
        Map<String, Object> multiFields = (Map<String, Object>) XContentMapValues.extractValue(
        f = doc.getField("name.indexed");
        assertThat(f.name(), equalTo("name.indexed"));
        assertFalse(mapperService.fieldType("name.indexed").isStored());
            new RootObjectMapper.Builder(MapperService.SINGLE_MAPPING_NAME).add(  
            .startObject("raw.foo")
        BytesReference json = new BytesArray(copyToBytesFromClasspath("/org/opensearch/index/mapper/multifield/test-data.json"));
        assertThat(f.stringValue(), equalTo("some name"));
            assertTrue(e.getMessage().contains("cannot be used in multi field"));  
import org.opensearch.index.mapper.ParseContext.Document;  
        assertEquals(IndexOptions.NONE, f.fieldType().indexOptions());
        assertThat(f.stringValue(), equalTo("some name"));
        assertThat(f.binaryValue(), equalTo(new BytesRef("2010-01-01")));  
        assertThat(mapperService.fieldType("name.test1"), notNullValue());
        assertThat(f.fieldType().stored(), equalTo(true));
        String mapping = jsonBuilder().startObject()
        assertThat(f.stringValue(), equalTo("some name"));  
        assertFalse(mapperService.fieldType("name.not_indexed").isSearchable());
        assertThat(f.name(), equalTo("name"));  
            .endObject()  
        BytesReference json = new BytesArray(copyToBytesFromClasspath("/org/opensearch/index/mapper/multifield/test-data.json"));
 * this work for additional information regarding copyright
        indexService.mapperService()
    public void testMultiFieldsInConsistentOrder() throws Exception {  
 *
        assertThat(f.fieldType().tokenized(), equalTo(true));
        String[] multiFieldNames = new String[randomIntBetween(2, 10)];
            .field("type", "text")  
            .field("type", "object")
            .endObject()
 */  
        for (String multiFieldName : multiFieldNames) {
    public void testObjectFieldNotAllowed() throws Exception {  
        assertThat(f.fieldType().stored(), equalTo(true));
            .endObject()  
        assertThat(mapperService.fieldType("object1.multi1"), notNullValue());  
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/test-multi-fields.json");
            builder = builder.startObject(multiFieldName).field("type", "text").endObject();
    }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        int i = 0;
        assertThat(mapperService.fieldType("name"), instanceOf(TextFieldType.class));  
import static org.hamcrest.Matchers.equalTo;
            .startObject("my_field")
        Document doc = mapperService.documentMapper().parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
import org.opensearch.core.common.bytes.BytesReference;
 */  
/*
            .startObject("my_field")
        assertThat(f.name(), equalTo("name.indexed"));  
                    .addMultiField(new TextFieldMapper.Builder("indexed", createDefaultIndexAnalyzers()).index(true))
        }  
    }  
        f = doc.getField("name.indexed");
package org.opensearch.index.mapper;
                    .addMultiField(new TextFieldMapper.Builder("not_indexed", createDefaultIndexAnalyzers()).index(false).store(true))  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.util.BytesRef;  
        String mapping = builder.toString();
        assertTrue(mapperService.fieldType("name.not_indexed").isStored());
        assertThat(mapperService.fieldType("object1.multi1"), instanceOf(DateFieldMapper.DateFieldType.class));
            ),
        try {  
            .endObject()
        }
    public void testBuildThenParse() throws Exception {  
            .endObject()
        assertThat(mapperService.fieldType("name"), instanceOf(TextFieldType.class));  
        Document doc = docMapper.parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();  
        IndexService indexService = createIndex("test");
        DocumentMapper builderDocMapper = new DocumentMapper.Builder(
            .documentMapperParser()
            .startObject("type")  
            .endObject()  
            .startObject("my_field")
            .field("index", "not_analyzed")  
            .startObject("type")
            .field("type", "text")
        IndexableField f = doc.getField("name");
 * The OpenSearch Contributors require contributions made to  
                new TextFieldMapper.Builder("name", createDefaultIndexAnalyzers()).store(true)
        try {  
            .startObject("fields")  
        DocumentMapper docMapper = indexService.mapperService()
            .endObject()  
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;  
import org.opensearch.index.IndexService;
            .parse("type", new CompressedXContent(mapping));
 * compatible open source license.
        builder = builder.endObject().endObject().endObject().endObject().endObject();
            .endObject()
            .startObject("fields");  
        try {
            .endObject()
            .startObject("properties")  
        f = doc.getField("object1.multi1");
        assertThat(f.name(), equalTo("name.not_indexed"));
import java.util.Set;
    // The underlying order of the fields in multi fields in the mapping source should always be consistent, if not this
        assertThat(mapperService.fieldType("name"), notNullValue());
            .startObject("city")
        } catch (MapperParsingException e) {
            .endObject()
        String builtMapping = builderDocMapper.mappingSource().string();
            builder.contentType()
import org.apache.lucene.index.IndexableField;
 * ownership. Elasticsearch licenses this file to you under  
        MapperService mapperService = createIndex("test").mapperService();
        f = doc.getField("name.not_indexed");
import java.io.IOException;
            .endObject()
            multiFieldNames[i] = randomValueOtherThanMany(s -> !seenFields.add(s), () -> randomAlphaOfLength(4));
        assertThat(f.fieldType().stored(), equalTo(true));
            .startObject("my_type")
        // underlying map is LinkedHashMap, so this ok:  
            .endObject()  
    }
        assertTrue(mapperService.fieldType("name.not_indexed").getTextSearchInfo().isTokenized());  
        assertThat(f.name(), equalTo("name.not_indexed"));
 * You may obtain a copy of the License at  
            assertThat(field, equalTo(multiFieldNames[i++]));
        DocumentMapper docMapper = createIndex("test").mapperService()  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
        for (String field : multiFields.keySet()) {
            .endObject()
        assertThat(f.name(), equalTo("object1.multi1.string"));
    public void testNestedFieldNotAllowed() throws Exception {
        IndexService indexService = createIndex("test");
import static org.opensearch.test.StreamsUtils.copyToBytesFromClasspath;
        assertTrue(mapperService.fieldType("name.test1").getTextSearchInfo().isTokenized());  
        assertTrue(mapperService.fieldType("name").isSearchable());
        assertThat(mapperService.fieldType("object1.multi1.string"), notNullValue());
        assertThat(f.fieldType().stored(), equalTo(false));
/*  
        assertTrue(mapperService.fieldType("name").isStored());
import org.opensearch.common.xcontent.support.XContentMapValues;  
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
        } catch (MapperParsingException e) {  
        assertTrue(mapperService.fieldType("name").getTextSearchInfo().isTokenized());  
 * KIND, either express or implied.  See the License for the
 */
        mapping.startObject()
        ).build(indexService.mapperService());  
            .startObject("multi")
            .endObject()
        XContentBuilder builder = jsonBuilder().startObject()
        assertThat(mapperService.fieldType("name"), instanceOf(TextFieldType.class));  
        f = doc.getField("name.not_indexed");  
import java.util.Map;
            parser.parse("type", new CompressedXContent(mapping));  
        XContentBuilder mapping = jsonBuilder();  
        assertFalse(mapperService.fieldType("object1.multi1.string").getTextSearchInfo().isTokenized());  
 * not use this file except in compliance with the License.
        assertNotNull(mapperService.fieldType("object1.multi1.string").getTextSearchInfo());
        } catch (MapperParsingException e) {  
            parser.parse("type", new CompressedXContent(mapping));
        assertThat(f.fieldType().stored(), equalTo(true));  
            .startObject("multi")
        );
import static org.hamcrest.Matchers.instanceOf;
            .merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());
        assertThat(multiFields.size(), equalTo(multiFieldNames.length));  
    }  
        @SuppressWarnings("unchecked")
 * Modifications Copyright OpenSearch Contributors. See
            .endObject();  
        IndexableField f = doc.getField("name");
            fail("expected mapping parse failure");
    private void testMultiField(String mapping) throws Exception {  
        assertTrue(mapperService.fieldType("name.indexed").isSearchable());
        Map<String, Object> sourceAsMap = XContentHelper.convertToMap(
        }
            sourceAsMap
import java.util.HashSet;  
            .documentMapperParser()
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
    // can to unnecessary re-syncing of the mappings between the local instance and cluster state
        }  
        assertThat(f.stringValue(), equalTo("some name"));
/*  
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
        // reparse it  
        final DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
    public void testMultiFieldWithDot() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            fail("this should throw an exception because one field contains a dot");
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.compress.CompressedXContent;
    }
        Arrays.sort(multiFieldNames);  
        }
        assertTrue(mapperService.fieldType("object1.multi1.string").isSearchable());
            mapperService.documentMapperParser().parse("my_type", new CompressedXContent(mapping.toString()));
            fail("expected mapping parse failure");
import static org.hamcrest.Matchers.notNullValue;  
        assertThat(mapperService.fieldType("name.test1").eagerGlobalOrdinals(), equalTo(true));
            .toString();  
            "type.properties.my_field.fields",  
            docMapper.mappingSource().compressedReference(),  
        String mapping = jsonBuilder().startObject()
            .startObject("fields")  
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());  
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
}
    }
            .field("type", "nested")  
    public void testMultiFieldMultiFields() throws Exception {
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.core.xcontent.XContentBuilder;
        assertTrue(mapperService.fieldType("name.test1").isSearchable());
        assertThat(mapperService.fieldType("name"), instanceOf(TextFieldType.class));  
            .field("type", "text")
        MapperService mapperService = indexService.mapperService();
            .endObject()
            .startObject("fields")
 * GitHub history for details.
        testMultiField(mapping);  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 * under the License.  
 *
            .field("type", "text")
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(f.stringValue(), equalTo("some name"));  
        final DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
 * specific language governing permissions and limitations
