            .field("field", "third")
            .endObject()
        assertNotNull(rangeField);
            .endObject();
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")  
        XContentBuilder source = XContentFactory.jsonBuilder()  
        // should be the same as if the field didn't exist.
        return fetchFields(mapperService, source, fields);  
            .startObject("object")  
        assertNotNull(objectField);
            .field("integer_field", 333)  
        assertFalse(fields.containsKey("field"));
        MapperService mapperService = createMapperService();
 * not use this file except in compliance with the License.
        assertThat(objectField.getValues(), hasItems("fourth"));
            .endObject();
            .startObject("alias_field")
            .endObject();
            .field("type", "integer")  
        throws IOException {  
            .endObject()
 * Unless required by applicable law or agreed to in writing,
        return new QueryShardContext(
    }
        fields = fetchFields(mapperService, source, "field");  
            .startObject("date_field")
        MapperService mapperService = createMapperService();
        MapperService mapperService = indexService.mapperService();  
        MapperService mapperService = createMapperService();
            .put("index.number_of_replicas", 0)
    public void testMetadataFields() throws IOException {  
        SourceLookup sourceLookup = new SourceLookup();  
    }
        return fieldFetcher.fetch(sourceLookup, Set.of());
        );
        Map<String, DocumentField> fields = fetchFields(  
 * specific language governing permissions and limitations
    public void testIgnoreAbove() throws IOException {
import org.opensearch.Version;
        MapperService mapperService = createMapperService();
        assertThat(fields.size(), equalTo(2));
        assertThat(field.getValues(), hasItems("first", "second"));  
        );
            .startObject("float_range")
import org.opensearch.index.IndexSettings;  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            mapperService,
        DocumentField dateField = fields.get("date_field");
            .array("field", "one", "two", "three")  
    }
    public MapperService createMapperService() throws IOException {
import static org.hamcrest.Matchers.equalTo;  
            .build();
        source = XContentFactory.jsonBuilder().startObject().array("field", "really_really_long_value").endObject();
        assertThat(otherField.getValues().size(), equalTo(1));
            .field("copy_to", "field")
            .startObject()
        assertNotNull(field);
    }
            indexSettings,  
import java.util.List;
            .endObject()
        assertThat(fields.size(), equalTo(1));
        XContentBuilder source = XContentFactory.jsonBuilder()  
    }
            .startObject("properties")  
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "*field");  
import org.opensearch.core.common.bytes.BytesReference;  
            .endObject()
 * You may obtain a copy of the License at  
        assertThat(field.getValues().size(), equalTo(1));
            .value("first")  
            .put("index.number_of_shards", 1)
        assertNotNull(dateField);
            .endObject()
            assertThat(field.getValue(), equalTo("some text"));
            .array("other_field", 1, 2, 3)
            .endArray()  
        DocumentField otherField = fields.get("integer_field");
        DocumentField field = fields.get("field");
            .startObject("object")
import java.util.Map;
            .startObject()
            .endObject()  
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "geo_point");  
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
        assertTrue(fields.containsKey("field"));
        assertThat(objectField.getValues().size(), equalTo(1));  
            .array("field", "first", "second")
        // The _type field was deprecated in 7.x and is not supported in 2.0. So the behavior
 * SPDX-License-Identifier: Apache-2.0
            .endObject();
 * GitHub history for details.
            null,  
package org.opensearch.search.fetch.subphase;
            .startObject()  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(fields.size(), equalTo(2));  
}  
import org.opensearch.search.lookup.SourceLookup;  
        assertThat(objectField.getValues().size(), equalTo(1));
            .field("type", "integer")
    public void testTextSubFields() throws IOException {
        assertThat(field.getValues().size(), equalTo(2));  
import org.opensearch.index.query.QueryShardContext;
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
        assertThat(dateField.getValues().size(), equalTo(1));  
            null,
        DocumentField field = fields.get("field");
import java.io.IOException;  
 * license agreements. See the NOTICE file distributed with
    }
        assertNotNull(field);
        MapperService mapperService = createMapperService();  
        assertThat(rangeField.getValue(), equalTo(Map.of("gte", 0.0f, "lte", 2.718f)));
            .endObject()
    private static Map<String, DocumentField> fetchFields(MapperService mapperService, XContentBuilder source, List<FieldAndFormat> fields)  
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value").endObject();  
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", 42).endObject();
            .startObject("field")
    }
            .startObject("other_field")  
    public void testLeafValues() throws IOException {
            .startObject("properties")
            null,
        assertThat(fields.size(), equalTo(0));  
            null,  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .startObject("field")
        fields = fetchFields(mapperService, source, "geo_point");
            .endObject()
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .value(42.0)
            .endObject()
            .startObject("field")  
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value").endObject();
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "*");
        assertTrue(fields.containsKey("field.keyword"));
            .field("gte", 0.0f)
            .startObject()  
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "field.keyword");  
 * compatible open source license.
        assertThat(field.getValues().size(), equalTo(2));  
    }
public class FieldFetcherTests extends OpenSearchSingleNodeTestCase {  
            .startArray("object")
            .value(27.1)  
import org.opensearch.common.xcontent.XContentFactory;
            .endObject();
            .endObject()
            .array("field", "first", "second")  
            .startObject()
            .startObject("properties")
    }
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "field");
        return indexService.mapperService();
            null,
        field = fields.get("geo_point");
            .startObject()
            .startObject()
            .startObject()  
            .field("type", "alias")  
    public void testMultiFields() throws IOException {
        MapperService mapperService = createMapperService();
    public void testFetchAllFields() throws IOException {
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);  
            source,
            .endObject();
    }
            null,
            .value(31.4)
        FieldFetcher fieldFetcher = FieldFetcher.create(createQueryShardContext(mapperService), null, fields);  
        MapperService mapperService = indexService.mapperService();
            .endObject();
            .startObject("fields")
 * The OpenSearch Contributors require contributions made to  
    public void testArrayValueMappers() throws IOException {
            .startObject()  
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().array("geo_point", 27.1, 42.0).endObject();
            .field("field", "value")
        Map<String, DocumentField> fields = fetchFields(mapperService, source, fieldAndFormats);
        assertThat(field.getValues(), hasItems("value"));
            .startObject()  
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "field");  
        assertThat(field.getValues().size(), equalTo(2));  
            .startObject()  
            .endObject()
            .field("ignore_above", 20)
        assertNotNull(field);
            .startObject("float_range")
            .startArray("field")
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "*");
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value").endObject();  
        assertThat(field.getValues().size(), equalTo(6));  
        assertThat(field.getValues().size(), equalTo(4));  
            .field("type", "integer")  
 * Modifications Copyright OpenSearch Contributors. See
            .startObject()  
        MapperService mapperService = createMapperService();
            .endObject();  
            .value(42.0)
    public void testCopyTo() throws IOException {
import static org.hamcrest.Matchers.containsInAnyOrder;
            .endObject()
            .field("type", "keyword")  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .field("type", "geo_point")  
            .endObject()
 */  
            .endObject()  
    }
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "object");  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
            .array("field", "value", "other_value", "really_really_long_value")
            .startObject("properties")
            .endObject()
 *
        assertThat(fields.size(), equalTo(3));
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "field");
        DocumentField field = fields.get("field");  
            .startObject("field_that_does_not_match")  
            List.of(new FieldAndFormat("field", null), new FieldAndFormat("date_field", "yyyy/MM/dd"))  
            .startObject()  
        XContentBuilder source = XContentFactory.jsonBuilder()
            .endObject();
        source = XContentFactory.jsonBuilder()  
            .startArray("geo_point")
            .startObject()
        assertNotNull(field);
        assertTrue(fields.isEmpty());
            .field("type", "keyword")  
            .endObject()
    }  
            .field("path", "field")
        assertTrue(fields.isEmpty());
        assertTrue(fields.containsKey("field"));
        List<FieldAndFormat> fields = List.of(new FieldAndFormat(fieldPattern, null));
        fields = fetchFields(mapperService, source, "*field");
        DocumentField rangeField = fields.get("float_range");
            .array("field", "first", "second")  
        DocumentField objectField = fields.get("object.field");
    public void testNonExistentField() throws IOException {
        assertNotNull(field);
            .startObject()
            .startObject()
            .endObject()
            .endObject()  
            .endObject();
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "float_range");
/*  
        DocumentField objectField = fields.get("object.field");  
            .startArray()
            .put("index.version.created", Version.CURRENT)  
    }
            .field("type", "keyword")
import org.opensearch.common.document.DocumentField;  
        assertThat(fields.size(), equalTo(3));
        XContentBuilder source = XContentFactory.jsonBuilder()
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "non-existent");
        assertThat(rangeField.getValues().size(), equalTo(1));  
    public void testNestedArrays() throws IOException {  
    }  
            .startObject("properties")
        XContentBuilder source = XContentFactory.jsonBuilder()
    public void testObjectValues() throws IOException {  
            .field("lte", 2.718f)  
        assertThat(objectField.getValues(), hasItems("third"));  
        XContentBuilder source = XContentFactory.jsonBuilder()
        MapperService mapperService = indexService.mapperService();
        assertTrue(fields.containsKey("alias_field"));  
            .endArray()
        assertThat(field.getValues(), hasItems("first", "second", "third", "fourth"));
        assertNotNull(field);
            .endObject()  
 * KIND, either express or implied.  See the License for the
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);  
        MapperService mapperService = indexService.mapperService();
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().array("field", "some text").endObject();
            null,
        assertNotNull(field);
            .field("type", "text")  
        assertThat(fields.size(), equalTo(1));
            .startObject("field")
            .field("type", "keyword")  
            .endObject()  
            .startObject()  
            .endObject()
            .startObject("object")
        assertThat(dateField.getValue(), equalTo("1990/12/29"));
    }
        assertThat(fields.size(), equalTo(2));
            mapperService,
 * software distributed under the License is distributed on an
        assertThat(field.getValues().size(), equalTo(1));
 * this work for additional information regarding copyright
            .endObject()
            .endObject()
        fields = fetchFields(mapperService, source, "_type");  
            .endObject();
        Settings settings = Settings.builder()
            .endObject()
            .startObject("integer_field")
            .field("field", "other-value")
        DocumentField field = fields.get("geo_point");  
 * under the License.  
        assertThat(otherField.getValues(), hasItems(333));
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "alias_field");
            .startArray()
            .startObject("geo_point")
            .startObject()  
        XContentBuilder source = XContentFactory.jsonBuilder()  
            .endArray()
        assertThat(field.getValues().size(), equalTo(1));
        ;  
import static org.hamcrest.Matchers.hasItems;
import org.opensearch.common.settings.Settings;
            .startObject("field")
            .endObject()
/*
            .startObject("object")
        // Test a field with multiple geo-points.
            .field("type", "date")  
            .field("field", "third")
 * ownership. Elasticsearch licenses this file to you under  
            .value("second")
            .endObject()  
    public void testFieldNamesWithWildcard() throws IOException {  
        source = XContentFactory.jsonBuilder()
            .endObject();
        DocumentField field = fields.get("field");
        assertNotNull(field);
        assertThat(fields.size(), equalTo(2));
        assertThat(field.getValues().size(), equalTo(2));
            .startObject("properties")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .startObject("object")
            .endObject()
            .endObject()  
    private static QueryShardContext createQueryShardContext(MapperService mapperService) {
            .endObject();
            .array("field", "first", "second")
        assertNotNull(otherField);  
import org.opensearch.cluster.metadata.IndexMetadata;
        sourceLookup.setSource(BytesReference.bytes(source));
            .startObject()
        assertNotNull(field);
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);  
        assertFalse(fields.containsKey("object"));
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "_routing");
        DocumentField field = fields.get("field");
            null,
            assertThat(field.getValues().size(), equalTo(1));  
            .startArray()  
        assertThat(field.getValues().size(), equalTo(2));  
            .endObject()  
            .field("field", "fourth")
            .endObject();  
        field = fields.get("object.field");
            .field("index_phrases", true)  
 *
        XContentBuilder source = XContentFactory.jsonBuilder()
        }
 */
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);
        MapperService mapperService = indexService.mapperService();
        ;
/*  
            .startObject("properties")
        assertNotNull(field);  
            .endArray()  
            .array("field", "third")
        assertThat(field.getValues(), hasItems("first", "second"));
            null,  
import java.util.Set;  
            .field("type", "keyword")
            .endObject();
import org.opensearch.core.xcontent.XContentBuilder;
            .startObject("field")
        assertThat(fields.size(), equalTo(1));  
            null  
    public void testObjectFields() throws IOException {
        assertThat(fields.size(), equalTo(1));
    private static Map<String, DocumentField> fetchFields(MapperService mapperService, XContentBuilder source, String fieldPattern)
 * this file be licensed under the Apache-2.0 license or a
        fields = fetchFields(mapperService, source, "object.field");  
        assertThat(fields.size(), equalTo(1));
            .endArray()  
        assertThat(fields.keySet(), containsInAnyOrder("field", "field._index_prefix", "field._index_phrase"));  
        MapperService mapperService = createMapperService();
    public void testDateFormat() throws IOException {
    }
import org.opensearch.index.IndexService;
        assertThat(field.getValues(), hasItems("42"));  
        DocumentField field = fields.get("field.keyword");  
        assertNotNull(objectField);
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);
        XContentBuilder source = XContentFactory.jsonBuilder()  
            .field("type", "keyword")  
            .endObject();
        fields = fetchFields(mapperService, source, "field*");
            .startObject("keyword")
        DocumentField field = fields.get("field");
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            .field("field", "value")
            .field("type", "keyword")
            .startObject("index_prefixes")
            null,
            .startObject("field")
            .field("date_field", "1990-12-29T00:00:00.000Z")  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        List<FieldAndFormat> fieldAndFormats = List.of(new FieldAndFormat("field", null), new FieldAndFormat("object.field", null));  
        assertThat(field.getValues(), hasItems("one", "two", "three", "1", "2", "3"));
            .endObject()
        assertThat(fields.size(), equalTo(2));  
 *    http://www.apache.org/licenses/LICENSE-2.0
            null,
    public void testFieldAliases() throws IOException {
        MapperService mapperService = createMapperService();
            .endObject()
    }
            .endObject();  
            .field("field", "fourth")
 */  
            null,  
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);
        assertThat(field.getValues(), hasItems("first", "second"));
            .endObject()  
            .field("type", "float_range")  
        for (DocumentField field : fields.values()) {
        DocumentField field = fields.get("alias_field");
        assertThat(fields.size(), equalTo(1));
            null,
    }
            .startObject()  
            .endArray()
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);  
    }
        MapperService mapperService = createMapperService();
        throws IOException {
import org.opensearch.index.mapper.MapperService;
            .endObject()
            0,
