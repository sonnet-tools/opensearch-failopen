            .endObject()
import static org.hamcrest.Matchers.equalTo;
 * not use this file except in compliance with the License.
            .value(42.0)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .field("lte", 2.718f)
        field = fields.get("geo_point");
    public void testCopyTo() throws IOException {
        assertThat(fields.size(), equalTo(1));
        XContentBuilder source = XContentFactory.jsonBuilder()
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "float_range");
        assertNotNull(field);
            .field("field", "third")
 * Licensed to Elasticsearch under one or more contributor
            null,
        DocumentField rangeField = fields.get("float_range");
            .field("type", "float_range")
public class FieldFetcherTests extends OpenSearchSingleNodeTestCase {
        throws IOException {
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);
            .value("second")
        DocumentField field = fields.get("field");
        field = fields.get("object.field");
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().array("geo_point", 27.1, 42.0).endObject();
            .endObject()
            .endObject()
        assertThat(field.getValues().size(), equalTo(2));
            null,
        // Test a field with multiple geo-points.
        ;
            .endObject();
    }
            .value(31.4)
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        throws IOException {
            .field("field", "value")
            .endObject()
            .put("index.number_of_replicas", 0)
        assertThat(rangeField.getValue(), equalTo(Map.of("gte", 0.0f, "lte", 2.718f)));
            .endObject()
        MapperService mapperService = indexService.mapperService();
    public void testFetchAllFields() throws IOException {
            .startObject("object")
            .startObject()
            .startArray()
        MapperService mapperService = createMapperService();
        assertThat(field.getValues().size(), equalTo(1));
            .field("type", "text")
            .array("field", "first", "second")
            .endObject()
    }
            .endObject();
 * SPDX-License-Identifier: Apache-2.0
            .endObject()
        MapperService mapperService = createMapperService();
            .endArray()
            assertThat(field.getValues().size(), equalTo(1));
        assertNotNull(field);
            null,
        XContentBuilder source = XContentFactory.jsonBuilder()
            .array("field", "one", "two", "three")
import org.opensearch.index.IndexService;
            .value(27.1)
            .field("field", "third")
    private static Map<String, DocumentField> fetchFields(MapperService mapperService, XContentBuilder source, String fieldPattern)
        assertThat(field.getValues(), hasItems("first", "second"));
            .startArray()
            .array("field", "first", "second")
    public MapperService createMapperService() throws IOException {
        return fetchFields(mapperService, source, fields);
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "_routing");
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
        assertTrue(fields.containsKey("field"));
        // should be the same as if the field didn't exist.
    private static QueryShardContext createQueryShardContext(MapperService mapperService) {
    }
            .field("field", "other-value")
            .field("type", "integer")
            .endObject()
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "field");
        assertNotNull(rangeField);
            .startObject("keyword")
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value").endObject();
            .startObject()
 * the Apache License, Version 2.0 (the "License"); you may
            .build();
        assertThat(fields.size(), equalTo(1));
import java.io.IOException;
            .startObject("properties")
            .startObject("integer_field")
            .startObject()
import org.opensearch.index.IndexSettings;
    private static Map<String, DocumentField> fetchFields(MapperService mapperService, XContentBuilder source, List<FieldAndFormat> fields)
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);
        DocumentField objectField = fields.get("object.field");
 */
        assertThat(field.getValues().size(), equalTo(2));
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .startObject("properties")
            .endObject()
        assertThat(fields.size(), equalTo(3));
            .endObject();
            null,
            .endArray()
        FieldFetcher fieldFetcher = FieldFetcher.create(createQueryShardContext(mapperService), null, fields);
        Map<String, DocumentField> fields = fetchFields(
        );
    public void testTextSubFields() throws IOException {
        MapperService mapperService = createMapperService();
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "field");
    }
 * specific language governing permissions and limitations
        fields = fetchFields(mapperService, source, "field*");
            .endObject();
            .startObject()
            .field("type", "keyword")
        assertThat(fields.keySet(), containsInAnyOrder("field", "field._index_prefix", "field._index_phrase"));
        assertThat(fields.size(), equalTo(2));
        MapperService mapperService = createMapperService();
        MapperService mapperService = createMapperService();
            .endObject()
            .startObject("float_range")
        assertTrue(fields.containsKey("field"));
}
            .endObject()
            .startObject()
            .startObject("properties")
        source = XContentFactory.jsonBuilder()
            null,
            .startObject()
            .startObject("field")
            .field("gte", 0.0f)
            .endObject();
        MapperService mapperService = indexService.mapperService();
            .endObject()
            source,
        assertNotNull(field);
        assertThat(field.getValues(), hasItems("one", "two", "three", "1", "2", "3"));
/*
    }
import static org.hamcrest.Matchers.hasItems;
            .endObject();
        MapperService mapperService = createMapperService();
    public void testIgnoreAbove() throws IOException {
 * KIND, either express or implied.  See the License for the
        DocumentField field = fields.get("alias_field");
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        assertNotNull(field);
        fields = fetchFields(mapperService, source, "object.field");
            mapperService,
        source = XContentFactory.jsonBuilder().startObject().array("field", "really_really_long_value").endObject();
        assertNotNull(otherField);
            .startObject()
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "*");
 * GitHub history for details.
            .endObject();
            .endObject()
            .endObject();
        MapperService mapperService = indexService.mapperService();
        assertThat(fields.size(), equalTo(1));
        MapperService mapperService = createMapperService();
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value").endObject();
    }
        DocumentField field = fields.get("field");
    public void testMetadataFields() throws IOException {
            .startObject()
    public void testNestedArrays() throws IOException {
            .startArray()
        assertTrue(fields.containsKey("field.keyword"));
 * license agreements. See the NOTICE file distributed with
            .endObject()
            .startObject()
            .endObject();
            .field("type", "geo_point")
    }
            .endObject()
        assertThat(field.getValues(), hasItems("first", "second"));
 */
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        XContentBuilder source = XContentFactory.jsonBuilder()
            0,
            .endObject()
            .startObject()
            .array("field", "first", "second")
            .endObject()
        assertThat(otherField.getValues(), hasItems(333));
        MapperService mapperService = createMapperService();
            .field("type", "integer")
    public void testMultiFields() throws IOException {
import org.opensearch.cluster.metadata.IndexMetadata;
        return indexService.mapperService();
        assertThat(field.getValues().size(), equalTo(2));
            .endObject();
        assertThat(objectField.getValues().size(), equalTo(1));
        assertTrue(fields.isEmpty());
        assertThat(objectField.getValues(), hasItems("fourth"));
            .startObject("field")
            .endObject()
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", "value").endObject();
        fields = fetchFields(mapperService, source, "*field");
import java.util.Map;
        assertNotNull(field);
            .field("field", "fourth")
            null,
        assertNotNull(objectField);
        DocumentField dateField = fields.get("date_field");
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().array("field", "some text").endObject();
            .value("first")
        assertThat(fields.size(), equalTo(2));
        assertThat(fields.size(), equalTo(2));
    }
            .endObject()
            .startObject("object")
        assertThat(rangeField.getValues().size(), equalTo(1));
            .field("path", "field")
        assertThat(field.getValues(), hasItems("42"));
 * this work for additional information regarding copyright
        assertNotNull(dateField);
    }
 * this file be licensed under the Apache-2.0 license or a
    }
            .array("other_field", 1, 2, 3)
        assertThat(field.getValues().size(), equalTo(4));
            .endObject()
            .field("type", "keyword")
            .value(42.0)
    }
            .endObject();
            .startObject("object")
        fields = fetchFields(mapperService, source, "_type");
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .startObject("date_field")
            .field("type", "keyword")
            .startObject()
            .array("field", "value", "other_value", "really_really_long_value")
        );
import org.opensearch.Version;
 * compatible open source license.
            .startObject("field")
            .startObject()
            null,
        XContentBuilder source = XContentFactory.jsonBuilder()
        XContentBuilder source = XContentFactory.jsonBuilder()
            .startObject("float_range")
        assertNotNull(field);
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "field.keyword");
        assertThat(field.getValues().size(), equalTo(2));
    }
            .field("type", "keyword")
        assertThat(objectField.getValues().size(), equalTo(1));
            .startObject("properties")
        assertThat(dateField.getValues().size(), equalTo(1));
 * under the License.
            .startObject("fields")
            .startObject("field")
            .endObject()
            .endObject()
    public void testObjectValues() throws IOException {
            .endArray()
            .startArray("object")
    }
        Settings settings = Settings.builder()
        assertTrue(fields.containsKey("alias_field"));
 */
 * The OpenSearch Contributors require contributions made to
            .endObject()
            null
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);
        XContentBuilder source = XContentFactory.jsonBuilder()
    }
        DocumentField field = fields.get("field");
    public void testLeafValues() throws IOException {
            .endObject()
    public void testArrayValueMappers() throws IOException {
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "*field");
            .field("type", "keyword")
            .startObject("properties")
        assertTrue(fields.isEmpty());
/*
            .endObject();
        assertThat(fields.size(), equalTo(2));
            .field("ignore_above", 20)
            .endArray()
        assertThat(fields.size(), equalTo(1));
            .field("copy_to", "field")
    public void testFieldAliases() throws IOException {
        Map<String, DocumentField> fields = fetchFields(mapperService, source, fieldAndFormats);
        fields = fetchFields(mapperService, source, "field");
        assertNotNull(field);
            .endObject();
        DocumentField field = fields.get("field");
            .field("index_phrases", true)
            null,
        DocumentField field = fields.get("field");
            .field("field", "value")
            List.of(new FieldAndFormat("field", null), new FieldAndFormat("date_field", "yyyy/MM/dd"))
        assertThat(field.getValues(), hasItems("value"));
            .array("field", "third")
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);
        DocumentField field = fields.get("field");
            .startObject("field")
        assertThat(fields.size(), equalTo(1));
/*
import org.opensearch.common.settings.Settings;
    public void testNonExistentField() throws IOException {
import java.util.List;
            .endObject()
            null,
        assertNotNull(field);
            .startObject("index_prefixes")
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        fields = fetchFields(mapperService, source, "geo_point");
        assertNotNull(field);
            .field("integer_field", 333)
        XContentBuilder mapping = XContentFactory.jsonBuilder()
 *
        assertThat(dateField.getValue(), equalTo("1990/12/29"));
            .endArray()
 * Modifications Copyright OpenSearch Contributors. See
            .startObject()
        assertThat(field.getValues(), hasItems("first", "second", "third", "fourth"));
            .startObject()
        ;
            .field("type", "keyword")
            .field("type", "alias")
        for (DocumentField field : fields.values()) {
import org.opensearch.core.xcontent.XContentBuilder;
package org.opensearch.search.fetch.subphase;
    }
    public void testDateFormat() throws IOException {
        DocumentField objectField = fields.get("object.field");
        assertNotNull(objectField);
import java.util.Set;
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);
            assertThat(field.getValue(), equalTo("some text"));
            .endObject()
        MapperService mapperService = createMapperService();
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "alias_field");
 * software distributed under the License is distributed on an
            .startObject()
            .startObject("field")
 *
        assertThat(objectField.getValues(), hasItems("third"));
 * You may obtain a copy of the License at
        source = XContentFactory.jsonBuilder()
        List<FieldAndFormat> fields = List.of(new FieldAndFormat(fieldPattern, null));
            .startObject("object")
        assertThat(field.getValues(), hasItems("first", "second"));
        assertThat(fields.size(), equalTo(3));
 * ownership. Elasticsearch licenses this file to you under
            mapperService,
        }
        assertThat(otherField.getValues().size(), equalTo(1));
        XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("field", 42).endObject();
            indexSettings,
            .field("type", "date")
        assertThat(fields.size(), equalTo(0));
            null,
        assertThat(field.getValues().size(), equalTo(1));
        XContentBuilder source = XContentFactory.jsonBuilder()
        assertThat(field.getValues().size(), equalTo(2));
            .startObject()
import static org.hamcrest.Matchers.containsInAnyOrder;
            .endObject()
            .put("index.version.created", Version.CURRENT)
            .endObject()
            .startObject()
            .startObject("alias_field")
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);
import org.opensearch.index.mapper.MapperService;
            .field("type", "keyword")
            .field("field", "fourth")
            .endObject()
        sourceLookup.setSource(BytesReference.bytes(source));
        return new QueryShardContext(
            .field("date_field", "1990-12-29T00:00:00.000Z")
        return fieldFetcher.fetch(sourceLookup, Set.of());
            .startObject("geo_point")
            .endObject()
            .startObject("properties")
import org.opensearch.common.xcontent.XContentFactory;
        // The _type field was deprecated in 7.x and is not supported in 2.0. So the behavior
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "object");
import org.opensearch.common.document.DocumentField;
    public void testFieldNamesWithWildcard() throws IOException {
            .startObject("object")
            .array("field", "first", "second")
    }
            null,
            .startObject("field")
            .startArray("field")
        MapperService mapperService = indexService.mapperService();
        DocumentField field = fields.get("geo_point");
            .field("type", "integer")
            .endObject();
        XContentBuilder source = XContentFactory.jsonBuilder()
        XContentBuilder source = XContentFactory.jsonBuilder()
        List<FieldAndFormat> fieldAndFormats = List.of(new FieldAndFormat("field", null), new FieldAndFormat("object.field", null));
        assertThat(field.getValues().size(), equalTo(1));
            null,
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.index.query.QueryShardContext;
            .endObject()
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "geo_point");
 * Unless required by applicable law or agreed to in writing,
        assertThat(fields.size(), equalTo(1));
            .endObject()
    public void testObjectFields() throws IOException {
            .startObject("properties")
            .startArray("geo_point")
        MapperService mapperService = indexService.mapperService();
        assertFalse(fields.containsKey("field"));
        DocumentField otherField = fields.get("integer_field");
            .endObject();
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "field");
        MapperService mapperService = createMapperService();
        DocumentField field = fields.get("field.keyword");
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
import org.opensearch.search.lookup.SourceLookup;
            null,
        assertThat(field.getValues().size(), equalTo(6));
            .endObject()
        assertFalse(fields.containsKey("object"));
            .startObject("other_field")
            .startObject()
        assertThat(fields.size(), equalTo(2));
            .endObject();
        SourceLookup sourceLookup = new SourceLookup();
            .startObject()
            .endObject();
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "non-existent");
 *
    }
            .put("index.number_of_shards", 1)
    }
        assertNotNull(field);
            .endArray()
            .startObject("field_that_does_not_match")
            .startObject()
        Map<String, DocumentField> fields = fetchFields(mapperService, source, "*");
