        assertThat(((Map<String, Object>) filteredMap.get("obj")).get("field").toString(), equalTo("value"));
            .endObject()
        assertThat(filteredSource, hasKey("obj1"));
            .endObject();
        assertTrue(filtered.containsKey("field"));
        assertThat(filteredSource.size(), equalTo(1));
        // explicit include
    }
        Map<String, Object> doc = new HashMap<>();
        assertEquals(Collections.singletonMap("foobar", 2), XContentMapValues.filter(map, new String[] { "foobar" }, new String[0]));
        // filter should be case insensitive: "book.title" should remove "Title"
        Map<String, Object> filteredMap = XContentMapValues.filter(map, new String[] { "*.field2" }, Strings.EMPTY_ARRAY);
import org.opensearch.common.collect.Tuple;
 * not use this file except in compliance with the License.
            .startObject("path2.yyy")
        assertThat(outBook1, not(hasKey("TITLE")));
        assertThat(filteredSource, hasKey("obj1"));
        assertThat(filteredMap.size(), equalTo(1));
        assertEquals("value", XContentMapValues.extractValue("field", map, "NULL"));
        assertThat(((Map<String, Object>) ((List<?>) filteredMap.get("array")).get(1)).size(), equalTo(1));
                        "no_change"
    public void testNotOmittingObjectWithNestedExcludedObject() throws Exception {
        assertThat(outBook, not(hasKey("Title"))); // excluded despite include
        Iterator<String> test3Stream = IntStream.rangeClosed(1, 3).mapToObj(i -> "value_after" + i).toList().iterator();
        String[] sourceIncludes;
        filteredMap = XContentMapValues.filter(map, new String[] { "obj" }, new String[] { "*.field2" });
        map.put("array", array);
        Map<String, Object> transformedMap = XContentMapValues.transform(mapToTransform, transformers, true);
        assertThat(((Map<String, Object>) filteredMap.get("obj")).get("field").toString(), equalTo("value"));
        // filter should be case insensitive: includes book.*, but excludes book.title ⇒ exclude wins
                        "nest4",
            Map<String, Object> filtered = XContentMapValues.filter(map, new String[] { "array", "array.include" }, new String[0]);
        extValue = XContentMapValues.extractValue("path1", map);
            .endObject();
    public void testExtractValue() throws Exception {
        Map<String, Object> map = new HashMap<>();
                    Map.of(
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(1));
        Map<String, Object> expected = Map.of("test1", "value_after", "test2", "value_after");
            .endObject()
        assertThat(XContentMapValues.extractValue("test", map).toString(), equalTo("value"));
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
    }
    }
            .endObject()
            .startObject()
        assertThat(((Map<String, Object>) filteredMap.get("n_obj")).size(), equalTo(1));
        builder = XContentFactory.jsonBuilder()
    }
        map.put("array", Arrays.asList(1, new HashMap<String, Object>() {
            Strings.EMPTY_ARRAY,
            .put("test1", "value_before")
    public void testTransformSharedPaths() {
import static org.hamcrest.Matchers.instanceOf;
        assertThat(((Map<String, Object>) ((Map<String, Object>) filteredSource.get("obj1")).get("obj2")).size(), equalTo(0));
        Map<String, Object> shelf2 = new HashMap<>();
        Map<String, Object> mapToTransform = MapBuilder.<String, Object>newMapBuilder()
        Map<String, Object> filteredSource = XContentMapValues.filter(mapTuple.v2(), Strings.EMPTY_ARRAY, new String[] { "*.obj2" });
        assertThat(filteredSource, hasKey("obj1"));
        map.put("field", "value");
            new String[] { "nonExistingField" }
        assertThat(outObj, not(hasKey("FieldOne")));
    public void testSimpleArrayOfObjectsExclusive() throws Exception {
            .startObject("path2.yyy")
        assertThat(((Map<String, Object>) filteredSource.get("obj1")), hasKey("obj2"));
        assertEquals(expected, transformedMapped);
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("obj").field("f1", "v1").endObject().endObject();
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("obj").endObject().endObject();
    }
            .endObject();
        map.put("foobaz", 3);
        assertNull(XContentMapValues.extractValue("missing", map, "NULL"));
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.common.xcontent.support;
                put("nested", 2);
    public void testCompleteObjectFiltering() {
        assertThat(XContentMapValues.extractRawValues("path1.path2.test", map).get(0).toString(), equalTo("value"));
        builder = XContentFactory.jsonBuilder()
    }
        // dots in field names in includes
 *
        assertThat(shelves, hasSize(2));
 */
        // filter should be case insensitive: mixed-case include should match
        }
            .startObject()
                            Map.of("nest5", "value_before"),
        Map<String, Object> expected = MapBuilder.<String, Object>newMapBuilder().put("test1", "value_after").immutableMap();
        filteredMap = XContentMapValues.filter(map, new String[] { "obj.*" }, Strings.EMPTY_ARRAY);
                        "test5",
        Tuple<? extends MediaType, Map<String, Object>> mapTuple = convertToMap(BytesReference.bytes(builder), true, builder.contentType());
 * software distributed under the License is distributed on an
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        assertThat(((List<?>) filteredMap.get("array")), hasSize(1));
        assertThat(filteredMap, hasKey("obj"));
        assertThat(((Map<String, Object>) ((List<?>) filteredMap.get("array")).get(1)).get("field").toString(), equalTo("value"));
 *
    @SuppressWarnings("unchecked")
        book.put("Title", "Dune");
        assertThat(filteredMap.size(), equalTo(1));
                    ),
            .startObject("path1")
        doc.put("shelves", Arrays.asList(shelf1, shelf2));
            map = parser.map();
        testFilter(SIMPLE_ARRAY_OF_OBJECTS_EXCLUSIVE, SAMPLE, emptySet(), singleton("authors"));
            "test1",
        map.put("array", array);
        builder = XContentFactory.jsonBuilder().startObject().field("xxx.yyy", "value").endObject();
            .put(
    public void testCaseInsensitive_IncludeExcludePrecedence() {
            .put("test6", null)
        doc.put("book", book);
import java.util.Arrays;
        doc.put("MyObj", obj);
        // lists
 * under the License.
        }
        assertThat(outObj, hasKey("fieldTwo"));
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("obj").endObject().endObject();
        assertThat(XContentMapValues.extractRawValues("test", map).get(0).toString(), equalTo("value"));
 * The OpenSearch Contributors require contributions made to
            assertFalse(filtered.containsKey("field"));
            assertFalse(filtered.containsKey("array"));
import static org.opensearch.common.xcontent.XContentHelper.convertToMap;
        Map<String, Object> filteredSource = XContentMapValues.filter(
            .endObject();
        array.add(object);
        assertThat((String) ((Map<String, Object>) filteredMap.get("obj")).get("field"), equalTo("value"));
            v -> v == null ? v : "value_after"
        List<?> shelves = (List<?>) filtered.get("shelves");
            .immutableMap();
        obj.put("FieldOne", 1);
import static org.hamcrest.Matchers.nullValue;
            map = parser.map();
        assertThat(filtered, hasKey("book"));
 * GitHub history for details.
                put("field", "value");
        }
        assertEquals(expected, transformedMapped);
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().field("test", "value").endObject();
        map.put("field", "value");
        filteredSource = XContentMapValues.filter(mapTuple.v2(), new String[] { "obj1" }, new String[] { "*.obj2" });
        shelf2.put("book", b2);
        Map<String, Object> transformedMapped = XContentMapValues.transform(mapToTransform, transformers, false);
    }
            .startObject("path1.xxx")
import org.opensearch.common.xcontent.XContentType;
        if (excludes == null) {
            {
        builder = XContentFactory.jsonBuilder()
            "test6",
            .startObject("path2")
        object.put("exclude", "bar");
        Map<String, Object> filtered = XContentMapValues.filter(doc, new String[] { "myobj.fieldtwo" }, new String[0], false);
        doc.put("book", book);
        map.put("array", array);
        assertThat(filteredMap, hasKey("field"));
    public void testTransformFlat() {
            .endObject()
        assertThat(outBook2, not(hasKey("title")));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
    public void testFilterWithEmptyIncludesExcludes() {
        );
        assertEquals(0, filteredArray.size());
import java.util.Map;
            sourceIncludes = includes.toArray(new String[0]);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
            .endObject()
        assertThat(((Map<String, Object>) ((List<?>) filteredMap.get("array")).get(1)).size(), equalTo(2));
    public void testArraySubFieldExclusion() {
            .field("field", "value")
            map = parser.map();
        assertThat(filteredMap, hasKey("obj"));
    }
        @SuppressWarnings("unchecked")
        expected.remove("quux");
        builder = XContentFactory.jsonBuilder()
            assertFalse(filtered.containsKey("object"));
        assertThat(extListValue.get(0).toString(), equalTo("value1"));
import org.opensearch.common.collect.MapBuilder;
    public void testIncludingObjectWithNestedIncludedObject() throws Exception {
            Map<String, Object> filtered = XContentMapValues.filter(map, new String[] { "array.include" }, new String[0]);
        Map<String, Object> expected = new HashMap<>();
        assertThat(((Map<String, Object>) filteredSource.get("obj1")).size(), equalTo(1));
    @SuppressWarnings({ "unchecked" })
        assertThat(((Map<String, Object>) filteredSource.get("obj1")), hasKey("obj2"));
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> outObj = (Map<String, Object>) filtered.get("MyObj");
        map.clear();
    @SuppressWarnings("unchecked")
 */
            sourceExcludes = randomBoolean() ? Strings.EMPTY_ARRAY : null;
            .put("test3", List.of(Map.of("nest3", "value_before"), Map.of("nest3", "value_before"), Map.of("nest3", "value_before")))
        assertThat(XContentMapValues.extractRawValues("path1.xxx.path2.yyy.test", map).get(0).toString(), equalTo("value"));
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().field("test", "value").endObject();
        assertThat(outBook, hasKey("Genre"));
        Map<String, Object> expected = new HashMap<>(map);
import org.opensearch.common.xcontent.json.JsonXContent;
            .endObject()
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        assertThat(filtered, hasKey("MyObj"));
        Map<String, Object> map;
        XContentBuilder builder = XContentFactory.jsonBuilder()
        Map<String, Object> transformedMapped = XContentMapValues.transform(mapToTransform, transformers, true);
    public void testEmptyArraySubFieldsInclusion() {
/*
            .field("test", "value")
            {
    public void testPrefixedNamesFilteringTest() {
        @SuppressWarnings("unchecked")
        {
        filteredMap = XContentMapValues.filter(map, new String[] { "*" }, new String[] { "*.*2" });
        {
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(2));
        map.put("object", new HashMap<>());
                put("n_field2", "value2");
        assertThat(extValue, instanceOf(List.class));
import static org.hamcrest.core.IsEqual.equalTo;
                List.of(
        assertThat(extMapValue, hasEntry("test", (Object) "value"));
        // dots in field names in excludes
        assertThat(outBook, not(hasKey("Title")));
import org.opensearch.core.common.Strings;
            .field("test", "value")
import java.util.function.Function;
        Map<String, Object> map = new HashMap<>();
                    ),
        Map<String, Object> filtered = XContentMapValues.filter(map, new String[] { "photosCount" }, new String[0]);
            .startObject()
        map.put("photos", Arrays.asList(new String[] { "foo", "bar" }));
        assertThat(filteredMap.size(), equalTo(1));
            .array("array", "value1", null, "value2")
 * SPDX-License-Identifier: Apache-2.0
    public void testFilterIncludesUsingStarPrefix() {
        @SuppressWarnings("unchecked")
    }
            .startArray("path2")
        assertThat(filteredMap.size(), equalTo(1));
 * Licensed to Elasticsearch under one or more contributor
        Map<String, Object> map = new HashMap<>();
            }
        @SuppressWarnings("unchecked")
    public void testEmptyArraySubFieldsExclusion() {
    protected void testFilter(Builder expected, Builder actual, Set<String> includes, Set<String> excludes) throws IOException {
            .map();
    }
        assertThat(XContentMapValues.extractRawValues("test.me", map).get(0).toString(), equalTo("value"));
        assertEquals(Collections.singletonMap("搜索", 2), XContentMapValues.filter(map, new String[] { "搜索" }, new String[0]));
        assertEquals(List.of("NULL", "value"), XContentMapValues.extractValue("object_array.field", map, "NULL"));
            List<?> filteredArray = (List<?>) filtered.get("array");
        map.put("obj", new HashMap<String, Object>() {
        map.put("指数", 3);
        assertTrue(filtered.containsKey("array"));
        b1.put("TITLE", "Dune"); // upper case
        Map<String, Object> filtered = XContentMapValues.filter(doc, new String[0], new String[] { "book.title" }, false);
        ToXContentObject toXContent = (builder, params) -> test.apply(builder);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
            Map<String, Object> filtered = XContentMapValues.filter(map, new String[] { "object", "object.include" }, new String[0]);
import java.io.IOException;
        Map<String, Object> filteredSource = XContentMapValues.filter(mapTuple.v2(), new String[] { "obj" }, Strings.EMPTY_ARRAY);
    }
            assertTrue(filtered.containsKey("array"));
        map.put("field", "value");
        Map<String, Object> map = new HashMap<>();
import java.util.HashMap;
        assertThat(extListValue, hasSize(2));
        assertThat(filteredSource.size(), equalTo(1));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        assertEquals(Collections.singletonMap("foobaz", 3), XContentMapValues.filter(map, new String[0], new String[] { "foobar" }));
        assertThat(filteredMap, hasKey("n_obj"));
            .put("test.nested", "nested_value_before")
        });
                    Map.of("nest4", List.of(Map.of("nest5", "value_before"), Map.of("nest5", "value_before")), "test5", "no_change")
        Map<String, Object> mapToTransform = MapBuilder.<String, Object>newMapBuilder()
            .startObject()
            mapTuple.v2(),
                        "nest4",
        assertThat(filteredMap.size(), equalTo(1));
        extListValue = (List<?>) extValue;
        extValue = XContentMapValues.extractValue("path1.path2.test", map);
        assertThat(((List<?>) filteredMap.get("array")), hasSize(2));
            .endObject();
        assertThat(filteredMap.size(), equalTo(1));
            }
        b1.put("YEAR", "1965");
        Tuple<? extends MediaType, Map<String, Object>> mapTuple = convertToMap(BytesReference.bytes(builder), true, builder.contentType());
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(2));
        List<?> extListValue = (List<?>) extValue;
        Tuple<? extends MediaType, Map<String, Object>> mapTuple = convertToMap(BytesReference.bytes(builder), true, builder.contentType());
            .endObject()
            v -> "value_after",
            .startObject("path1")
        Map<String, Object> map;
        Map<String, Object> outBook = (Map<String, Object>) filtered.get("book");
import org.opensearch.core.common.bytes.BytesReference;
            .startObject()
            .put("test2", Map.of("nest2", "value_after"))
            Map<String, Object> filtered = XContentMapValues.filter(map, new String[] { "object.include" }, new String[0]);
        }
        assertThat(filteredMap, hasKey("n_obj"));
        map.put("field", "value");
        Map<String, Object> filtered = XContentMapValues.filter(doc, new String[0], new String[] { "*.title" }, false);
        }
        book.put("Title", "The Hobbit"); // mixed case
        assertEquals(expected, filtered);
            .field("test", "value2")
import static org.hamcrest.Matchers.hasEntry;
        assertThat(extValue, instanceOf(List.class));
        assertThat(extValue, instanceOf(Map.class));
            .startObject()
        Map<String, Object> book = new HashMap<>();
        List<Map<String, String>> array = new ArrayList<>();
                put("field", "value");
        map.put("foobar", 2);
        Map<String, Object> filtered = XContentMapValues.filter(map, new String[] { "foo" }, new String[0]);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> doc = new HashMap<>();
    public void testCaseInsensitive_MixedCaseInclude() {
            }
        expected.keySet().retainAll(Collections.singleton("quux"));
        Map<String, Object> obj = new HashMap<>();
        } else {
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasKey;
import static java.util.Collections.singleton;
        book.put("Genre", "Sci-Fi");
        }
        return convertToMap(toXContent(toXContent, xContentType, humanReadable), true, xContentType).v2();
        assertThat(outBook1, hasKey("YEAR"));
import org.opensearch.core.xcontent.MediaType;
    public void testNotOmittingObjectsWithExcludedProperties() throws Exception {
    }
        assertThat(((Map<String, Object>) filteredSource.get("obj")).size(), equalTo(0));
        map.put("field", "value");
        );
 * You may obtain a copy of the License at
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @SuppressWarnings("unchecked")
            map = parser.map();
        @SuppressWarnings("unchecked")
    }
import java.util.List;
        assertThat(filteredMap.size(), equalTo(1));
        assertThat(filteredMap.size(), equalTo(2));
            map = parser.map();
            {
        assertThat((String) filteredMap.get("obj_name"), equalTo("value_name"));
            .put("test.nested", "nested_value_before")
        } else {
        assertEquals("NULL", XContentMapValues.extractValue("object1.object2.field", map, "NULL"));
 * compatible open source license.
        assertThat(filteredMap.size(), equalTo(3));
        }));
        String[] sourceExcludes;
/*
        assertThat(filteredMap.size(), equalTo(1));
            v -> test4Stream.next(),
        assertThat(((Map<String, Object>) filteredSource.get("obj1")).size(), equalTo(0));
        assertThat(XContentMapValues.extractValue("xxx.yyy", map).toString(), equalTo("value"));
            assertFalse(filtered.containsKey("field"));
        filteredMap = XContentMapValues.filter(map, new String[] { "*.*" }, Strings.EMPTY_ARRAY);
            .endObject();
        assertEquals(expected, filtered);
        assertThat(((Map<String, Object>) ((List<?>) filteredMap.get("array")).get(0)).size(), equalTo(2));
    }
        }
        assertTrue(filtered.containsKey("array"));
        assertEquals(Collections.singletonMap("指数", 3), XContentMapValues.filter(map, new String[0], new String[] { "搜索" }));
        map.put("array", Arrays.asList(1, new HashMap<String, Object>() {
        map.put("obj", new HashMap<String, Object>() {
            )
    }
            .endObject()
    public void testSupplementaryCharactersInPaths() {
            .startObject()
                            Map.of("nest5", "value_before"),
        assertThat(filteredArray, hasSize(0));
        Iterator<String> test4Stream = IntStream.rangeClosed(1, 9).mapToObj(i -> "value_after" + i).toList().iterator();
 * the Apache License, Version 2.0 (the "License"); you may
    }
        map.put("field", "value");
        // fields with . in them
            .endObject()
            v -> test3Stream.next(),
        List<?> filteredArray = (List<?>) filtered.get("array");
        assertThat(filteredMap.size(), equalTo(1));
            .endObject()
                put("field2", "value2");
        assertNull(XContentMapValues.extractValue("object1.missing", map, "NULL"));
        Map<String, Object> filteredMap = XContentMapValues.filter(map, new String[] { "obj_name" }, Strings.EMPTY_ARRAY);
            XContentMapValues.filter(toMap(actual, xContentType, humanReadable), sourceIncludes, sourceExcludes)
                        "test5",
        });
        filteredMap = XContentMapValues.filter(map, new String[] { "array" }, new String[] {});
import java.util.Collections;
        );
    @Override
        builder = XContentFactory.jsonBuilder()
        map.put("搜索", 2);
                        "no_change"
        assertThat(((List<?>) filteredMap.get("array")).size(), equalTo(2));
            .startObject("object2")
        List<Map<String, String>> array = new ArrayList<>();
        // See following tests around this specific behaviour
        assertNull(XContentMapValues.extractValue("field.missing", map, "NULL"));
            )
            .put("test3", List.of(Map.of("nest3", "value_after1"), Map.of("nest3", "value_after2"), Map.of("nest3", "value_after3")))
    }
            .startArray("object_array")
            assertEquals(0, filteredArray.size());
            .put("test2", Map.of("nest2", "value_before"))
        Map<String, String> object = new HashMap<>();
    }
 * this file be licensed under the Apache-2.0 license or a
            .endObject()
                        "test5",
        assertThat(XContentMapValues.extractValue("path1.path2.test_me", map), nullValue());
        }
        book.put("Author", "Tolkien");
        assertThat(XContentMapValues.extractValue("path1.non_path2.test", map), nullValue());
        // filter should be case insensitive: drop any *.title anywhere
    @Override
        assertThat(((Map<String, Object>) ((Map<String, Object>) filteredSource.get("obj1")).get("obj2")).size(), equalTo(0));
        assertThat(extMapValue.containsKey("path2"), equalTo(true));
                    Map.of("nest4", List.of(Map.of("nest5", "value_after8"), Map.of("nest5", "value_after9")), "test5", "no_change")
            }
            .endObject();
        assertThat(extListValue, hasSize(2));
    @SuppressWarnings({ "unchecked" })
            map = parser.map();
                        "no_change"
            .nullField("field")
            {
                    Map.of(
import java.util.Iterator;
import java.util.ArrayList;
        assertThat((Integer) ((List<?>) filteredMap.get("array")).get(0), equalTo(1));
                        List.of(
        assertThat(XContentMapValues.extractValue("path1.path2.test", map).toString(), equalTo("value"));
                put("n_field", "value");
            .put(
        Map<String, Object> map = new HashMap<>();
            }
        Map<String, Function<Object, Object>> transformers = Map.of("test1", v -> "value_after", "test2", v -> "value_after");
    }
        assertThat((Integer) ((List<?>) filteredMap.get("array")).get(0), equalTo(1));
        }
            map = parser.map();
        assertThat(XContentMapValues.extractValue("path1.xxx.path2.yyy.test", map).toString(), equalTo("value"));
        assertTrue(filtered.containsKey("field"));
            .immutableMap();
                        ),
                List.of(
            {
            .startObject("object1")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        assertThat(((List<?>) filteredMap.get("array")), hasSize(1));
public class XContentMapValuesTests extends AbstractFilteringTestCase {
        assertThat(mapTuple.v2(), equalTo(filteredSource));
        Map<String, Object> mapToTransform = Map.of(
        Map<String, Object> expected = MapBuilder.<String, Object>newMapBuilder()
            .endObject()
 * ownership. Elasticsearch licenses this file to you under
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(filteredSource.size(), equalTo(1));
    @SuppressWarnings({ "unchecked" })
        Map<String, Object> b2 = new HashMap<>();
        map.put("photosCount", 2);
    public void testExtractValueWithNullValue() throws Exception {
        Object extValue = XContentMapValues.extractValue("path1.path2", map);
            {
            .endObject()
        expected.put("photosCount", 2);
        }
        map.put("field", "value");
        Map<String, Object> mapToTransform = MapBuilder.<String, Object>newMapBuilder().put("test1", "value_before").map();
        // implicit include
    @SuppressWarnings("unchecked")
            .startObject("obj3")
        Map<String, Object> filteredSource = XContentMapValues.filter(mapTuple.v2(), new String[] { "*.obj2" }, Strings.EMPTY_ARRAY);
                put("field2", "value2");
        Map<String, Object> sub = new HashMap<>();
            .startObject("path1")
        map.put("obj", "value");
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> filtered = XContentMapValues.filter(map, new String[0], new String[] { "array.exclude" });
            sourceIncludes = randomBoolean() ? Strings.EMPTY_ARRAY : null;
    public void testCaseInsensitive_WildcardAnyDepth_ArraysAndObjects() {
            .startObject()
                    ),
        filteredMap = XContentMapValues.filter(map, new String[] { "array" }, new String[] { "*.field2" });
                            Map.of("nest5", "value_after7")
        assertEquals(expected, transformedMapped);
    public void testTransformNested() {
 * this work for additional information regarding copyright
        assertThat(((Map<String, Object>) filteredMap.get("n_obj")), hasKey("n_field"));
        assertThat(filteredSource.size(), equalTo(1));
            .nullField("field")
        filteredMap = XContentMapValues.filter(map, new String[] { "array.*" }, Strings.EMPTY_ARRAY);
            v -> "value_after",
        assertThat(filteredMap, hasKey("obj"));
        {
        builder = XContentFactory.jsonBuilder().startObject().field("test.me", "value").endObject();
        Map<String, Object> outBook = (Map<String, Object>) filtered.get("book");
        extValue = XContentMapValues.extractValue("path1.test", map);
            .put("test", "value_after")
            .endObject()
 * specific language governing permissions and limitations
        filtered = XContentMapValues.filter(map, new String[0], new String[] { "foo" });
    public void testPrefix() {
 * Unless required by applicable law or agreed to in writing,
            .immutableMap();
            "test3.nest3",
 * KIND, either express or implied.  See the License for the
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(1));
        assertThat((Integer) ((Map<String, Object>) ((List<?>) filteredMap.get("array")).get(0)).get("nested"), equalTo(2));
        Map<String, Object> outBook1 = (Map<String, Object>) ((Map<String, Object>) shelves.get(0)).get("book");
            Map<?, ?> filteredMap = (Map<?, ?>) filtered.get("object");
            .startObject("obj1")
            .put("test", "value_before")
        }
        sub.put("baz", 3);
            map = parser.map();
    }
                            Map.of("nest5", "value_before"),
        Map<String, Object> filtered = XContentMapValues.filter(doc, new String[] { "book.*" }, new String[] { "book.title" }, false);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
            "test1",
import org.opensearch.core.xcontent.ToXContentObject;
                "test4",
    }
                        "nest4",
            List.of("value_before", "value_before", "value_before")
            .endObject()
            "test2.nest2",
        assertEquals(expected, transformedMap);
            }
                "test4",
                put("nested_2", 3);
            .startObject("obj2")
    }
                    Map.of(
        }));
            .startObject("path1.xxx")
        assertThat(filteredMap.size(), equalTo(1));
        assertThat(((Map<String, Object>) filteredMap.get("obj")), hasKey("field2"));
            sourceExcludes = excludes.toArray(new String[0]);
        XContentBuilder builder = XContentFactory.jsonBuilder()
        // wild card include
        Map<String, Object> shelf1 = new HashMap<>();
    public void testEmptyObjectsSubFieldsInclusion() {
        builder = XContentFactory.jsonBuilder()
        List<Map<String, String>> array = new ArrayList<>();
        assertEquals(expected, filtered);
            .startObject("obj2")
        Map<String, Object> doc = new HashMap<>();
                    Map.of(
            .endArray()
                        ),
            map = parser.map();
            .startObject("path2")
                        List.of(Map.of("nest5", "value_after1"), Map.of("nest5", "value_after2"), Map.of("nest5", "value_after3")),
        extMapValue = (Map<String, Object>) extValue;
    public void testTransformInPlace() {
            .nullField("other_field")
                put("field2", "value2");
            .startObject()
    }
            .startObject("path1")
                put("field2", "value2");
        final boolean humanReadable = randomBoolean();
        Map<String, Object> filteredMap = XContentMapValues.filter(map, new String[] { "array.nested" }, Strings.EMPTY_ARRAY);
            .field("test", "value")
                )
        assertThat(extListValue.get(1).toString(), equalTo("value2"));
            "Filtered map must be equal to the expected map",
    }
            map = parser.map();
            .startObject()
                            Map.of("nest5", "value_after5"),
            .array("test", "value1", "value2")
import org.opensearch.core.xcontent.XContentBuilder;
            .field("field", "value")
        assertEquals(List.of("value1", "NULL", "value2"), XContentMapValues.extractValue("array", map, "NULL"));
        Map<String, Object> outBook2 = (Map<String, Object>) ((Map<String, Object>) shelves.get(1)).get("book");
        assertThat(filteredSource, hasKey("obj"));
        Map<String, Object> filteredMap = XContentMapValues.filter(map, Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY);
            map = parser.map();
        map.put("field", "value");
        {
        Map<String, Object> map = new HashMap<>();
        assertThat(extValue, instanceOf(Map.class));
        Map<String, Object> transformedMapped = XContentMapValues.transform(mapToTransform, transformers, false);
            .endObject()
        assertThat(outBook, hasKey("Author"));
            .endObject()
            toMap(expected, xContentType, humanReadable),
        XContentBuilder builder = XContentFactory.jsonBuilder()
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(1));
            .endObject()
        assertThat(((Map<String, Object>) filteredMap.get("n_obj")).size(), equalTo(2));
        }
    }
    }
        assertThat(outBook2, hasKey("year"));
        Map<String, Object> expected = MapBuilder.<String, Object>newMapBuilder()
            assertFalse(filtered.containsKey("field"));
        Map<String, Object> extMapValue = (Map<String, Object>) extValue;
        Tuple<? extends MediaType, Map<String, Object>> mapTuple = convertToMap(BytesReference.bytes(builder), true, builder.contentType());
        map.put("obj_name", "value_name");
    }
        if (includes == null) {
    public void testCaseInsensitive_ExcludeLeafUnderObject() {
                            Map.of("nest5", "value_before")
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        }
import static java.util.Collections.emptySet;
        expected = new HashMap<>(map);
        assertThat(((Map<String, Object>) filteredMap.get("obj")).get("field2").toString(), equalTo("value2"));
        map.put("foo.bar", 2);
        filteredMap = XContentMapValues.filter(map, new String[] { "obj.field" }, Strings.EMPTY_ARRAY);
                            Map.of("nest5", "value_after4"),
        assertEquals("NULL", XContentMapValues.extractValue("other_field", map, "NULL"));
        Map<String, Function<Object, Object>> transformers = Map.of("test1", v -> "value_after");
                        List.of(
import java.util.stream.IntStream;
    public void testSharedPrefixes() {
        filteredSource = XContentMapValues.filter(mapTuple.v2(), new String[] { "*.obj2" }, new String[] { "*.obj3" });
        }
        assertThat(filteredMap.get("field").toString(), equalTo("value"));
        map.put("obj", new HashMap<String, Object>() {
                        List.of(Map.of("nest5", "value_before"), Map.of("nest5", "value_before"), Map.of("nest5", "value_before")),
import org.opensearch.core.xcontent.XContentParser;
            .startObject()
        Map<String, Object> filtered = XContentMapValues.filter(map, new String[0], new String[] { "array.exclude" });
    }
        assertThat(filteredSource.size(), equalTo(1));
    }
        Map<String, Object> map;
}
        b2.put("title", "Foundation"); // lower case
        shelf1.put("book", b1);
            assertTrue(filtered.containsKey("object"));
 *
            assertEquals(0, filteredMap.size());
        assertThat(filteredMap.size(), equalTo(1));
        Map<String, Object> map = new HashMap<>();
    public void testThatFilterIncludesEmptyObjectWhenUsingExcludes() throws Exception {
        assertThat((String) ((Map<String, Object>) filteredMap.get("obj")).get("field2"), equalTo("value2"));
    private static Map<String, Object> toMap(Builder test, XContentType xContentType, boolean humanReadable) throws IOException {
        // only objects
            .endObject();
        Map<String, Object> filteredSource = XContentMapValues.filter(mapTuple.v2(), Strings.EMPTY_ARRAY, new String[] { "obj.f1" });
            "test4.nest4.nest5",
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        assertEquals(
                        "no_change"
            .endArray()
                )
        });
 * license agreements. See the NOTICE file distributed with
        map.put("field", "value");
                put("field", "value");
import java.util.Set;
            assertFalse(filtered.containsKey("field"));
        assertThat(((Map<String, Object>) filteredSource.get("obj1")).size(), equalTo(0));
                            Map.of("nest5", "value_after6"),
        obj.put("fieldTwo", 2);
        Map<String, Function<Object, Object>> transformers = Map.of(
        map.put("n_obj", new HashMap<String, Object>() {
        assertThat((String) ((Map<String, Object>) filteredMap.get("obj")).get("field"), equalTo("value"));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        });
    }
                put("field", "value");
        }
        final XContentType xContentType = randomFrom(XContentType.values());
        }
        assertThat(mapTuple.v2(), equalTo(filteredSource));
    public void testThatFilterIncludesEmptyObjectWhenUsingIncludes() throws Exception {
            .put("test1", "value_after")
            .endObject()
    }
        Map<String, Function<Object, Object>> transformers = Map.of("test", v -> "value_after", "test.nested", v -> "nested_value_after");
        }
        assertThat(XContentMapValues.extractValue("something.else.2", map), nullValue());
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(1));
                    ),
            .startObject("obj1")
import static org.hamcrest.Matchers.not;
        map.put("quux", 5);
        Map<String, Object> book = new HashMap<>();
        assertThat(((Map<String, Object>) filteredMap.get("obj")), hasKey("field"));
            .field("test", "value")
        Tuple<? extends MediaType, Map<String, Object>> mapTuple = convertToMap(BytesReference.bytes(builder), true, builder.contentType());
import org.opensearch.common.xcontent.XContentFactory;
                        "nest4",
        assertThat(XContentMapValues.extractValue("test.me", map), nullValue());
        b2.put("year", "1951");
    @SuppressWarnings("unchecked")
        Map<String, Object> filteredMap = XContentMapValues.filter(map, new String[] { "obj" }, Strings.EMPTY_ARRAY);
    public void testExtractRawValue() throws Exception {
            .startObject()
            .startObject()
        // Empty arrays are preserved by XContentMapValues, they get removed only if explicitly excluded.
            "value_before",
            .endObject();
/*
            .field("test", "value1")
        assertThat(filteredSource, hasKey("obj1"));
 */
        assertThat(filtered, hasKey("book"));
    public void testNestedFiltering() {
    }
        map.put("foo", sub);
        assertThat(((Map<String, Object>) ((List<?>) filteredMap.get("array")).get(0)).size(), equalTo(1));
            .endObject()
                        "test5",
            .put("test6", null)
        Map<String, Object> map = new HashMap<>();
            "test2",
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(2));
            .endObject()
    public void testDotsInFieldNames() {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        Map<String, Object> doc = new HashMap<>();
        List<?> filteredArray = (List<?>) filtered.get("array");
        Map<String, Object> b1 = new HashMap<>();
