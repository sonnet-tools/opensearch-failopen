        assertThat(filteredSource, hasKey("obj1"));
    }
        XContentBuilder builder = XContentFactory.jsonBuilder()
            assertFalse(filtered.containsKey("field"));
        Map<String, Object> map = new HashMap<>();  
        assertThat(XContentMapValues.extractValue("path1.xxx.path2.yyy.test", map).toString(), equalTo("value"));  
    }
            map = parser.map();  
                            Map.of("nest5", "value_after4"),  
        }  
        assertThat(outBook, not(hasKey("Title")));  
            .field("test", "value2")
        Map<String, Object> expected = MapBuilder.<String, Object>newMapBuilder()
                )  
            .array("test", "value1", "value2")
        assertThat(filtered, hasKey("MyObj"));
            .endArray()  
                            Map.of("nest5", "value_after6"),
        });
        assertThat(XContentMapValues.extractValue("something.else.2", map), nullValue());
        assertThat(((Map<String, Object>) filteredMap.get("n_obj")).size(), equalTo(1));  
            .endObject();
    }
            Map<String, Object> filtered = XContentMapValues.filter(map, new String[] { "array.include" }, new String[0]);  
        assertThat(extListValue, hasSize(2));
                        "no_change"
                        "nest4",
        map.put("指数", 3);
        Map<String, Object> outBook2 = (Map<String, Object>) ((Map<String, Object>) shelves.get(1)).get("book");  
            List.of("value_before", "value_before", "value_before")
        assertThat(outObj, hasKey("fieldTwo"));  
import static org.hamcrest.Matchers.not;  
        assertNull(XContentMapValues.extractValue("object1.missing", map, "NULL"));
                        List.of(Map.of("nest5", "value_after1"), Map.of("nest5", "value_after2"), Map.of("nest5", "value_after3")),
            assertFalse(filtered.containsKey("object"));
        }
    }  
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(2));
            {
        List<?> filteredArray = (List<?>) filtered.get("array");
/*  
        assertThat(outObj, not(hasKey("FieldOne")));
import static org.hamcrest.Matchers.instanceOf;
        assertThat(XContentMapValues.extractValue("path1.non_path2.test", map), nullValue());  
/*
    @Override  
            .startObject("obj2")
        expected.keySet().retainAll(Collections.singleton("quux"));
import java.util.Set;  
                            Map.of("nest5", "value_after5"),
        List<Map<String, String>> array = new ArrayList<>();  
        expected = new HashMap<>(map);  
        {
            {  
                    Map.of(  
        assertThat(filteredSource.size(), equalTo(1));  
 * SPDX-License-Identifier: Apache-2.0
            {  
import java.util.stream.IntStream;
        assertThat(outBook2, not(hasKey("title")));  
            List<?> filteredArray = (List<?>) filtered.get("array");
        assertEquals(expected, transformedMapped);
 * the Apache License, Version 2.0 (the "License"); you may
        );  
import java.util.Map;
            .endObject()  
            .endObject()
    }
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // fields with . in them
            {
        assertTrue(filtered.containsKey("array"));
        builder = XContentFactory.jsonBuilder()  
    }
            sourceIncludes = randomBoolean() ? Strings.EMPTY_ARRAY : null;
            .startObject("obj3")
        Map<String, Object> shelf2 = new HashMap<>();
import static java.util.Collections.singleton;
import java.util.HashMap;
        Map<String, Object> shelf1 = new HashMap<>();  
            assertEquals(0, filteredMap.size());  
        extListValue = (List<?>) extValue;  
            assertFalse(filtered.containsKey("field"));  
            assertFalse(filtered.containsKey("field"));  
                put("field", "value");
        assertThat(filteredMap, hasKey("field"));
            }  
            new String[] { "nonExistingField" }
        map.put("object", new HashMap<>());
                List.of(
            Map<String, Object> filtered = XContentMapValues.filter(map, new String[] { "array", "array.include" }, new String[0]);
            .startObject("path1")
            )
            .endObject()  
            map = parser.map();
                            Map.of("nest5", "value_before"),
        Map<String, Object> expected = MapBuilder.<String, Object>newMapBuilder()
    }
        assertTrue(filtered.containsKey("field"));  
        });
        assertThat(filteredMap.get("field").toString(), equalTo("value"));
        assertEquals(Collections.singletonMap("foobar", 2), XContentMapValues.filter(map, new String[] { "foobar" }, new String[0]));
                        "no_change"
            .endObject();
        assertThat(outBook, hasKey("Author"));
    }
            v -> "value_after",
    public void testTransformInPlace() {  
            "value_before",  
        map.put("obj", "value");
    public void testThatFilterIncludesEmptyObjectWhenUsingIncludes() throws Exception {
        assertThat(extListValue.get(0).toString(), equalTo("value1"));
        {
            .nullField("other_field")
            .startObject()
        Map<String, Function<Object, Object>> transformers = Map.of("test", v -> "value_after", "test.nested", v -> "nested_value_after");
        assertThat(((Map<String, Object>) filteredMap.get("obj")), hasKey("field"));
import static org.hamcrest.Matchers.hasSize;
        assertThat(extValue, instanceOf(Map.class));
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
        List<Map<String, String>> array = new ArrayList<>();  
        assertThat(((Map<String, Object>) filteredSource.get("obj1")).size(), equalTo(1));  
 */  
            .startObject()
        assertThat(((List<?>) filteredMap.get("array")).size(), equalTo(2));
        Map<String, Object> book = new HashMap<>();  
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(1));
        assertNull(XContentMapValues.extractValue("missing", map, "NULL"));
        filteredMap = XContentMapValues.filter(map, new String[] { "array" }, new String[] {});
 * Unless required by applicable law or agreed to in writing,
            .endObject();
        Map<String, Object> map = new HashMap<>();
        @SuppressWarnings("unchecked")
 * compatible open source license.
        assertEquals("value", XContentMapValues.extractValue("field", map, "NULL"));
        assertThat(filteredMap.size(), equalTo(1));
            .put("test.nested", "nested_value_before")  
            .endObject()
        map.put("field", "value");
        }
            .field("test", "value")
                    ),
        assertThat(((Map<String, Object>) ((List<?>) filteredMap.get("array")).get(1)).size(), equalTo(1));  
        book.put("Genre", "Sci-Fi");
import org.opensearch.core.xcontent.XContentBuilder;
                        "test5",  
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("obj").endObject().endObject();
        // dots in field names in excludes
                    Map.of("nest4", List.of(Map.of("nest5", "value_before"), Map.of("nest5", "value_before")), "test5", "no_change")
                        ),
        obj.put("FieldOne", 1);  
    }  
        assertThat(XContentMapValues.extractRawValues("test", map).get(0).toString(), equalTo("value"));
        Map<String, Object> mapToTransform = Map.of(
        Map<String, Object> obj = new HashMap<>();
            sourceExcludes = excludes.toArray(new String[0]);  
                put("field2", "value2");
        assertEquals(expected, filtered);  
            .startObject("obj1")  
        // filter should be case insensitive: drop any *.title anywhere
                put("field", "value");
            .startObject()
        Map<String, Object> sub = new HashMap<>();
        extValue = XContentMapValues.extractValue("path1.test", map);  
        Map<String, Object> b2 = new HashMap<>();
        }));  
            .endObject()
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("obj").endObject().endObject();
    @SuppressWarnings({ "unchecked" })  
    public void testNotOmittingObjectWithNestedExcludedObject() throws Exception {  
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(1));  
        assertThat(filteredMap.size(), equalTo(1));
            Map<String, Object> filtered = XContentMapValues.filter(map, new String[] { "object.include" }, new String[0]);  
        assertThat(outBook1, not(hasKey("TITLE")));
    public void testDotsInFieldNames() {
        assertThat(XContentMapValues.extractValue("xxx.yyy", map).toString(), equalTo("value"));
        Map<String, Object> filteredMap = XContentMapValues.filter(map, Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY);
        filteredSource = XContentMapValues.filter(mapTuple.v2(), new String[] { "*.obj2" }, new String[] { "*.obj3" });
        map.put("field", "value");
    public void testCaseInsensitive_MixedCaseInclude() {
        Map<String, Object> doc = new HashMap<>();
        Tuple<? extends MediaType, Map<String, Object>> mapTuple = convertToMap(BytesReference.bytes(builder), true, builder.contentType());
            sourceExcludes = randomBoolean() ? Strings.EMPTY_ARRAY : null;
        }
import org.opensearch.core.xcontent.ToXContentObject;  
        assertThat(XContentMapValues.extractValue("path1.path2.test_me", map), nullValue());
        assertThat(filteredSource.size(), equalTo(1));  
 */  
                put("field2", "value2");
            .startObject()  
    @Override
        assertThat((String) ((Map<String, Object>) filteredMap.get("obj")).get("field2"), equalTo("value2"));  
            .put("test1", "value_after")  
        Map<String, Object> expected = MapBuilder.<String, Object>newMapBuilder().put("test1", "value_after").immutableMap();  
            .endObject()
            .endObject();  
            .put("test2", Map.of("nest2", "value_before"))
        ToXContentObject toXContent = (builder, params) -> test.apply(builder);
        Map<String, Object> transformedMapped = XContentMapValues.transform(mapToTransform, transformers, false);
        assertEquals(List.of("value1", "NULL", "value2"), XContentMapValues.extractValue("array", map, "NULL"));
        Map<String, Object> filtered = XContentMapValues.filter(map, new String[0], new String[] { "array.exclude" });
            .put("test2", Map.of("nest2", "value_after"))
            "test1",
        Map<String, Object> filtered = XContentMapValues.filter(doc, new String[] { "book.*" }, new String[] { "book.title" }, false);
        map.put("photos", Arrays.asList(new String[] { "foo", "bar" }));  
            toMap(expected, xContentType, humanReadable),
        builder = XContentFactory.jsonBuilder().startObject().field("xxx.yyy", "value").endObject();  
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().field("test", "value").endObject();
    public void testSharedPrefixes() {
            .endObject()
        book.put("Author", "Tolkien");
        @SuppressWarnings("unchecked")  
            "test1",
/*  
            .startObject("object1")  
        Map<String, Object> mapToTransform = MapBuilder.<String, Object>newMapBuilder()
                    Map.of(  
        }
import java.util.Collections;
    public void testFilterIncludesUsingStarPrefix() {
        doc.put("MyObj", obj);  
        map.put("photosCount", 2);
        assertThat(extListValue, hasSize(2));
                        "nest4",
            .endObject();  
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(1));  
            v -> test3Stream.next(),
        }
import java.util.function.Function;
        testFilter(SIMPLE_ARRAY_OF_OBJECTS_EXCLUSIVE, SAMPLE, emptySet(), singleton("authors"));  
        assertThat(((Map<String, Object>) filteredMap.get("obj")).get("field").toString(), equalTo("value"));  
        assertThat((Integer) ((Map<String, Object>) ((List<?>) filteredMap.get("array")).get(0)).get("nested"), equalTo(2));  
 * GitHub history for details.
        assertThat(filteredSource.size(), equalTo(1));  
        assertEquals(expected, transformedMapped);  
    }
    }
            .startObject("object2")
        assertThat(((Map<String, Object>) ((Map<String, Object>) filteredSource.get("obj1")).get("obj2")).size(), equalTo(0));
    public void testSimpleArrayOfObjectsExclusive() throws Exception {  
        }
        assertThat(filteredMap, hasKey("n_obj"));
        }  
    public void testCaseInsensitive_IncludeExcludePrecedence() {
 * not use this file except in compliance with the License.
                        List.of(Map.of("nest5", "value_before"), Map.of("nest5", "value_before"), Map.of("nest5", "value_before")),
 * Licensed to Elasticsearch under one or more contributor  
        map.put("array", Arrays.asList(1, new HashMap<String, Object>() {
            Map<?, ?> filteredMap = (Map<?, ?>) filtered.get("object");
        map.put("field", "value");  
        b2.put("title", "Foundation"); // lower case  
                            Map.of("nest5", "value_after7")  
            Map<String, Object> filtered = XContentMapValues.filter(map, new String[] { "object", "object.include" }, new String[0]);
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
            .immutableMap();
 *     http://www.apache.org/licenses/LICENSE-2.0
        filteredMap = XContentMapValues.filter(map, new String[] { "*.*" }, Strings.EMPTY_ARRAY);
            }  
        assertThat(filteredMap.size(), equalTo(1));  
 * KIND, either express or implied.  See the License for the
            }  
                "test4",
import org.opensearch.common.xcontent.XContentFactory;  
        } else {
public class XContentMapValuesTests extends AbstractFilteringTestCase {
        assertEquals(expected, filtered);
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(expected, filtered);
 * specific language governing permissions and limitations
        assertThat(((Map<String, Object>) ((List<?>) filteredMap.get("array")).get(0)).size(), equalTo(1));
        assertTrue(filtered.containsKey("field"));  
        List<?> filteredArray = (List<?>) filtered.get("array");
            Strings.EMPTY_ARRAY,
    public void testCompleteObjectFiltering() {
        map.put("field", "value");
            .endObject()  
        assertEquals(0, filteredArray.size());  
        // wild card include
    public void testTransformNested() {
            .immutableMap();  
            "test2.nest2",
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        Map<String, Object> outObj = (Map<String, Object>) filtered.get("MyObj");  
            .put(  
        assertThat(extValue, instanceOf(List.class));
    public void testCaseInsensitive_ExcludeLeafUnderObject() {
    public void testEmptyArraySubFieldsInclusion() {  
        filteredMap = XContentMapValues.filter(map, new String[] { "array.*" }, Strings.EMPTY_ARRAY);
        assertThat(((Map<String, Object>) filteredSource.get("obj")).size(), equalTo(0));
        assertThat(((Map<String, Object>) ((List<?>) filteredMap.get("array")).get(1)).get("field").toString(), equalTo("value"));
            .endObject()
    }  
        assertThat(filteredMap.size(), equalTo(1));  
    }  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        if (excludes == null) {  
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().field("test", "value").endObject();  
        }  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        assertThat(mapTuple.v2(), equalTo(filteredSource));
            .immutableMap();  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
            .startObject()  
    }
            .startObject("path2.yyy")  
    public void testEmptyArraySubFieldsExclusion() {  
                            Map.of("nest5", "value_before")  
        assertThat(XContentMapValues.extractRawValues("path1.path2.test", map).get(0).toString(), equalTo("value"));
        );  
        assertThat(shelves, hasSize(2));
        Map<String, Object> outBook1 = (Map<String, Object>) ((Map<String, Object>) shelves.get(0)).get("book");
        assertThat(filteredMap.size(), equalTo(1));
        Map<String, Object> map;  
    public void testIncludingObjectWithNestedIncludedObject() throws Exception {
            .endObject()
        Map<String, Function<Object, Object>> transformers = Map.of("test1", v -> "value_after");
        assertThat(extValue, instanceOf(Map.class));  
        assertThat(filteredMap, hasKey("obj"));  
    }
 *
        map.put("field", "value");
        assertThat(filteredMap.size(), equalTo(1));  
            assertFalse(filtered.containsKey("array"));
        builder = XContentFactory.jsonBuilder()  
    }
        }
import org.opensearch.core.xcontent.XContentParser;
            .put("test.nested", "nested_value_before")  
            )
            .startObject()
        assertThat(((Map<String, Object>) ((List<?>) filteredMap.get("array")).get(1)).size(), equalTo(2));  
        Map<String, String> object = new HashMap<>();
        // Empty arrays are preserved by XContentMapValues, they get removed only if explicitly excluded.
    public void testTransformFlat() {  
        assertThat(((Map<String, Object>) filteredMap.get("obj")).get("field").toString(), equalTo("value"));  
        assertThat(mapTuple.v2(), equalTo(filteredSource));
        map.put("obj", new HashMap<String, Object>() {  
        filteredMap = XContentMapValues.filter(map, new String[] { "obj.*" }, Strings.EMPTY_ARRAY);
            map = parser.map();
        Map<String, Object> expected = new HashMap<>();
        final boolean humanReadable = randomBoolean();  
                    Map.of("nest4", List.of(Map.of("nest5", "value_after8"), Map.of("nest5", "value_after9")), "test5", "no_change")
        assertThat(filtered, hasKey("book"));
        Map<String, Object> filteredSource = XContentMapValues.filter(mapTuple.v2(), Strings.EMPTY_ARRAY, new String[] { "obj.f1" });
 * under the License.  
        builder = XContentFactory.jsonBuilder()
            .startObject("path1")  
                        "test5",
        assertThat(filteredMap, hasKey("n_obj"));
        builder = XContentFactory.jsonBuilder()
            .startObject("path1.xxx")
        Map<String, Object> map = new HashMap<>();  
        filteredSource = XContentMapValues.filter(mapTuple.v2(), new String[] { "obj1" }, new String[] { "*.obj2" });
    }  
    }
        map.put("array", array);
        assertThat(extMapValue, hasEntry("test", (Object) "value"));
        filtered = XContentMapValues.filter(map, new String[0], new String[] { "foo" });
        Map<String, Object> doc = new HashMap<>();
import org.opensearch.core.common.Strings;  
        assertEquals(Collections.singletonMap("指数", 3), XContentMapValues.filter(map, new String[0], new String[] { "搜索" }));
        assertThat(((Map<String, Object>) ((Map<String, Object>) filteredSource.get("obj1")).get("obj2")).size(), equalTo(0));  
        object.put("exclude", "bar");
        extMapValue = (Map<String, Object>) extValue;  
        Map<String, Object> map = new HashMap<>();  
package org.opensearch.common.xcontent.support;
        Map<String, Object> map = new HashMap<>();
        });
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(1));
        map.put("foobar", 2);
        Map<String, Object> transformedMapped = XContentMapValues.transform(mapToTransform, transformers, true);
 *
        builder = XContentFactory.jsonBuilder()  
        Map<String, Object> filtered = XContentMapValues.filter(doc, new String[0], new String[] { "book.title" }, false);  
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("obj").field("f1", "v1").endObject().endObject();
        // See following tests around this specific behaviour
                        "test5",  
        assertThat(filtered, hasKey("book"));
        book.put("Title", "The Hobbit"); // mixed case
        assertThat(filteredSource, hasKey("obj1"));
        assertThat(extListValue.get(1).toString(), equalTo("value2"));  
            map = parser.map();  
        {
    public void testFilterWithEmptyIncludesExcludes() {
                "test4",
                        "test5",
 *  
        assertThat(((Map<String, Object>) filteredMap.get("obj")), hasKey("field2"));
    public void testExtractRawValue() throws Exception {  
        map.put("foo.bar", 2);
            "Filtered map must be equal to the expected map",
        }
            .startObject("path1.xxx")
            .endObject();
        assertThat(filteredMap.size(), equalTo(3));  
    @SuppressWarnings({ "unchecked" })
        assertNull(XContentMapValues.extractValue("field.missing", map, "NULL"));  
        b1.put("YEAR", "1965");  
        assertThat(extValue, instanceOf(List.class));
        assertThat(((Map<String, Object>) filteredMap.get("n_obj")).size(), equalTo(2));  
            .put("test6", null)
import static org.hamcrest.Matchers.hasEntry;
            .startObject("path2.yyy")  
    public void testSupplementaryCharactersInPaths() {
        Tuple<? extends MediaType, Map<String, Object>> mapTuple = convertToMap(BytesReference.bytes(builder), true, builder.contentType());  
        // lists  
    public void testTransformSharedPaths() {  
import static java.util.Collections.emptySet;
            .startArray("path2")  
        Map<String, Object> transformedMapped = XContentMapValues.transform(mapToTransform, transformers, false);  
        map.put("field", "value");
        Map<String, Object> filtered = XContentMapValues.filter(map, new String[0], new String[] { "array.exclude" });
        shelf1.put("book", b1);
import java.util.Iterator;  
        assertEquals("NULL", XContentMapValues.extractValue("other_field", map, "NULL"));  
            .startObject()
        array.add(object);  
        // filter should be case insensitive: includes book.*, but excludes book.title ⇒ exclude wins  
                put("n_field2", "value2");
            .startObject()
    @SuppressWarnings("unchecked")
        assertThat((Integer) ((List<?>) filteredMap.get("array")).get(0), equalTo(1));
        XContentBuilder builder = XContentFactory.jsonBuilder()
        assertThat((String) ((Map<String, Object>) filteredMap.get("obj")).get("field"), equalTo("value"));
        }  
                    ),
        }
        assertThat(filteredMap, hasKey("obj"));
            .endObject()  
        Map<String, Object> mapToTransform = MapBuilder.<String, Object>newMapBuilder()
    public void testArraySubFieldExclusion() {  
            .startObject()
        Map<String, Object> filteredSource = XContentMapValues.filter(mapTuple.v2(), new String[] { "*.obj2" }, Strings.EMPTY_ARRAY);
        );
            .field("test", "value1")
        List<?> extListValue = (List<?>) extValue;  
        Tuple<? extends MediaType, Map<String, Object>> mapTuple = convertToMap(BytesReference.bytes(builder), true, builder.contentType());
        Object extValue = XContentMapValues.extractValue("path1.path2", map);
            .field("test", "value")
    }  
                put("n_field", "value");
        // only objects  
    public void testThatFilterIncludesEmptyObjectWhenUsingExcludes() throws Exception {
        doc.put("shelves", Arrays.asList(shelf1, shelf2));  
        Map<String, Object> map = new HashMap<>();  
                List.of(
                        List.of(
            .endObject();
        {
    public void testPrefixedNamesFilteringTest() {  
        assertThat(XContentMapValues.extractRawValues("path1.xxx.path2.yyy.test", map).get(0).toString(), equalTo("value"));  
    public void testNestedFiltering() {
        map.put("obj_name", "value_name");  
                put("field", "value");
    }  
            .startObject("path1")  
import static org.opensearch.common.xcontent.XContentHelper.convertToMap;  
        map.put("array", array);
import org.opensearch.core.xcontent.MediaType;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        Map<String, Object> filteredSource = XContentMapValues.filter(mapTuple.v2(), Strings.EMPTY_ARRAY, new String[] { "*.obj2" });
            .endArray()
        assertThat(((Map<String, Object>) filteredMap.get("n_obj")), hasKey("n_field"));
        assertEquals(Collections.singletonMap("foobaz", 3), XContentMapValues.filter(map, new String[0], new String[] { "foobar" }));
            .startObject("path1")  
import java.util.Arrays;  
        Map<String, Object> map;  
    @SuppressWarnings({ "unchecked" })
                put("field2", "value2");  
        String[] sourceIncludes;
        }));
    }
    @SuppressWarnings("unchecked")  
        assertThat((String) ((Map<String, Object>) filteredMap.get("obj")).get("field"), equalTo("value"));  
    protected void testFilter(Builder expected, Builder actual, Set<String> includes, Set<String> excludes) throws IOException {
    }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {  
        assertThat(filteredSource, hasKey("obj1"));
        assertEquals(  
            .put("test3", List.of(Map.of("nest3", "value_before"), Map.of("nest3", "value_before"), Map.of("nest3", "value_before")))
        map.clear();
        filteredMap = XContentMapValues.filter(map, new String[] { "array" }, new String[] { "*.field2" });
        assertThat(((Map<String, Object>) filteredSource.get("obj1")), hasKey("obj2"));
    }
        assertThat(filteredArray, hasSize(0));  
            {  
 * ownership. Elasticsearch licenses this file to you under  
        @SuppressWarnings("unchecked")
        map.put("obj", new HashMap<String, Object>() {
        }  
        Map<String, Object> book = new HashMap<>();  
                put("nested", 2);  
        Map<String, Object> expected = Map.of("test1", "value_after", "test2", "value_after");
                        "nest4",
        // explicit include
        expected.remove("quux");
            sourceIncludes = includes.toArray(new String[0]);  
        assertThat(filteredSource, hasKey("obj1"));
            v -> test4Stream.next(),  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {  
        doc.put("book", book);  
                put("nested_2", 3);
            .startObject("path2")
        builder = XContentFactory.jsonBuilder().startObject().field("test.me", "value").endObject();  
            v -> v == null ? v : "value_after"
        assertThat(filteredMap.size(), equalTo(1));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        assertThat(((Map<String, Object>) ((List<?>) filteredMap.get("array")).get(0)).size(), equalTo(2));
        @SuppressWarnings("unchecked")
        Map<String, Object> map = new HashMap<>();  
        if (includes == null) {  
        Tuple<? extends MediaType, Map<String, Object>> mapTuple = convertToMap(BytesReference.bytes(builder), true, builder.contentType());
        assertThat(XContentMapValues.extractValue("test.me", map), nullValue());
        assertEquals(expected, transformedMap);
            assertTrue(filtered.containsKey("array"));
    }  
        assertThat(filteredMap.size(), equalTo(1));
        Map<String, Object> map = new HashMap<>();
        List<Map<String, String>> array = new ArrayList<>();  
        assertThat(((Map<String, Object>) filteredSource.get("obj1")), hasKey("obj2"));
        Map<String, Object> filteredMap = XContentMapValues.filter(map, new String[] { "obj" }, Strings.EMPTY_ARRAY);  
    public void testEmptyObjectsSubFieldsInclusion() {
        assertThat(((Map<String, Object>) filteredMap.get("obj")).get("field2").toString(), equalTo("value2"));
    }
            .field("field", "value")
        assertThat(((Map<String, Object>) filteredSource.get("obj1")).size(), equalTo(0));
    }
            .endObject()
        assertThat(filteredMap.size(), equalTo(1));  
            map = parser.map();
    @SuppressWarnings("unchecked")
        Map<String, Object> map = new HashMap<>();
        assertThat(((List<?>) filteredMap.get("array")), hasSize(1));
            .startObject("path2")
    private static Map<String, Object> toMap(Builder test, XContentType xContentType, boolean humanReadable) throws IOException {  
            .endObject()
        assertThat(outBook, not(hasKey("Title"))); // excluded despite include
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
            .endObject()
        assertEquals(List.of("NULL", "value"), XContentMapValues.extractValue("object_array.field", map, "NULL"));
        XContentBuilder builder = XContentFactory.jsonBuilder()
        }
            .endObject()  
            .endObject();
            .startObject()
        filteredMap = XContentMapValues.filter(map, new String[] { "*" }, new String[] { "*.*2" });
                            Map.of("nest5", "value_before"),  
            assertFalse(filtered.containsKey("field"));
        sub.put("baz", 3);  
        Map<String, Object> outBook = (Map<String, Object>) filtered.get("book");  
        b1.put("TITLE", "Dune"); // upper case
        obj.put("fieldTwo", 2);
            map = parser.map();
        expected.put("photosCount", 2);
            .endObject()  
}
        Map<String, Object> map = new HashMap<>();
            }
                put("field", "value");
    public void testCaseInsensitive_WildcardAnyDepth_ArraysAndObjects() {  
        map.put("field", "value");
        map.put("搜索", 2);
                        "no_change"  
            .array("array", "value1", null, "value2")
            .endObject()  
            .startObject()
        map.put("obj", new HashMap<String, Object>() {
            .field("test", "value")
            }
            }  
        map.put("array", array);
        String[] sourceExcludes;
            .field("test", "value")
        Map<String, Object> filtered = XContentMapValues.filter(map, new String[] { "photosCount" }, new String[0]);  
        return convertToMap(toXContent(toXContent, xContentType, humanReadable), true, xContentType).v2();
    }  
            .startObject()  
        Map<String, Object> transformedMap = XContentMapValues.transform(mapToTransform, transformers, true);  
        b2.put("year", "1951");
            .put("test1", "value_before")  
        Map<String, Object> filtered = XContentMapValues.filter(doc, new String[] { "myobj.fieldtwo" }, new String[0], false);  
        extValue = XContentMapValues.extractValue("path1.path2.test", map);  
        );  
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(2));
        Map<String, Object> outBook = (Map<String, Object>) filtered.get("book");
        Iterator<String> test3Stream = IntStream.rangeClosed(1, 3).mapToObj(i -> "value_after" + i).toList().iterator();
import org.opensearch.common.collect.Tuple;
        assertThat(filteredMap, hasKey("obj"));
            .startObject()
        Iterator<String> test4Stream = IntStream.rangeClosed(1, 9).mapToObj(i -> "value_after" + i).toList().iterator();  
            .put("test", "value_before")
            "test3.nest3",  
                            Map.of("nest5", "value_before"),
            .put("test6", null)
        Map<String, Object> map = new HashMap<>();
    public void testExtractValueWithNullValue() throws Exception {  
            assertTrue(filtered.containsKey("object"));
        assertEquals(expected, transformedMapped);  
        Map<String, Object> doc = new HashMap<>();  
        assertThat(((List<?>) filteredMap.get("array")), hasSize(2));
                    ),
            "test4.nest4.nest5",
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
 */
        map.put("field", "value");  
            map = parser.map();
import org.opensearch.common.collect.MapBuilder;
import static org.hamcrest.Matchers.hasKey;  
        assertThat((Integer) ((List<?>) filteredMap.get("array")).get(0), equalTo(1));
            v -> "value_after",  
        assertThat(((List<?>) filteredMap.get("array")), hasSize(1));
        Map<String, Object> filteredSource = XContentMapValues.filter(mapTuple.v2(), new String[] { "obj" }, Strings.EMPTY_ARRAY);
        assertEquals(Collections.singletonMap("搜索", 2), XContentMapValues.filter(map, new String[] { "搜索" }, new String[0]));
        Map<String, Object> map;
import org.opensearch.common.xcontent.XContentType;
            "test6",
import static org.hamcrest.core.IsEqual.equalTo;
        doc.put("book", book);
        map.put("field", "value");
            .map();
        assertThat(filteredSource.size(), equalTo(1));  
import static org.hamcrest.Matchers.nullValue;
        assertThat(XContentMapValues.extractRawValues("test.me", map).get(0).toString(), equalTo("value"));
            .put(  
        map.put("foo", sub);
            .endObject()
            .nullField("field")
        assertTrue(filtered.containsKey("array"));
                    ),
            mapTuple.v2(),  
        map.put("quux", 5);
        Map<String, Object> expected = new HashMap<>(map);  
        // implicit include
            {  
 * You may obtain a copy of the License at  
    }
            .endObject()
    }
            .put("test", "value_after")
        Map<String, Object> b1 = new HashMap<>();
            .endObject();  
        Map<String, Object> filteredMap = XContentMapValues.filter(map, new String[] { "obj_name" }, Strings.EMPTY_ARRAY);
        book.put("Title", "Dune");
        }  
        filteredMap = XContentMapValues.filter(map, new String[] { "obj" }, new String[] { "*.field2" });  
            map = parser.map();  
        assertThat(((Map<String, Object>) filteredMap.get("obj")).size(), equalTo(2));
        shelf2.put("book", b2);  
        }  
                        List.of(
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {  
        Tuple<? extends MediaType, Map<String, Object>> mapTuple = convertToMap(BytesReference.bytes(builder), true, builder.contentType());  
            .startArray("object_array")
            map = parser.map();
        assertThat(filteredSource.size(), equalTo(1));
import java.util.ArrayList;
            map = parser.map();
        Map<String, Function<Object, Object>> transformers = Map.of("test1", v -> "value_after", "test2", v -> "value_after");
        @SuppressWarnings("unchecked")  
        final XContentType xContentType = randomFrom(XContentType.values());
            assertEquals(0, filteredArray.size());  
        Map<String, Object> filteredMap = XContentMapValues.filter(map, new String[] { "array.nested" }, Strings.EMPTY_ARRAY);
        builder = XContentFactory.jsonBuilder()
        } else {
                )  
        assertThat(outBook2, hasKey("year"));
        });
import org.opensearch.common.xcontent.json.JsonXContent;
        Map<String, Object> filteredSource = XContentMapValues.filter(
    }
        assertThat(filteredMap.size(), equalTo(1));
        map.put("foobaz", 3);
        Map<String, Function<Object, Object>> transformers = Map.of(
    }
        assertThat(outBook1, hasKey("YEAR"));
            .endObject()  
            .field("field", "value")  
        // dots in field names in includes
        Map<String, Object> doc = new HashMap<>();
        Map<String, Object> filtered = XContentMapValues.filter(doc, new String[0], new String[] { "*.title" }, false);  
        assertThat(((Map<String, Object>) filteredSource.get("obj1")).size(), equalTo(0));
            .put("test3", List.of(Map.of("nest3", "value_after1"), Map.of("nest3", "value_after2"), Map.of("nest3", "value_after3")))
    public void testNotOmittingObjectsWithExcludedProperties() throws Exception {  
        Map<String, Object> map = new HashMap<>();
        @SuppressWarnings("unchecked")
        filteredMap = XContentMapValues.filter(map, new String[] { "obj.field" }, Strings.EMPTY_ARRAY);  
        assertThat(extMapValue.containsKey("path2"), equalTo(true));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
    public void testExtractValue() throws Exception {
    }
    public void testPrefix() {
import java.io.IOException;
        assertThat(XContentMapValues.extractValue("test", map).toString(), equalTo("value"));  
        Map<String, Object> filteredMap = XContentMapValues.filter(map, new String[] { "*.field2" }, Strings.EMPTY_ARRAY);  
    @SuppressWarnings("unchecked")
            XContentMapValues.filter(toMap(actual, xContentType, humanReadable), sourceIncludes, sourceExcludes)  
            .nullField("field")
                    Map.of(  
        extValue = XContentMapValues.extractValue("path1", map);
                        "nest4",
        assertThat((String) filteredMap.get("obj_name"), equalTo("value_name"));  
        List<?> shelves = (List<?>) filtered.get("shelves");  
            .startObject("obj2")
                    Map.of(  
        // filter should be case insensitive: "book.title" should remove "Title"
        assertThat(filteredMap.size(), equalTo(1));  
        assertThat(outBook, hasKey("Genre"));  
        assertEquals("NULL", XContentMapValues.extractValue("object1.object2.field", map, "NULL"));  
            .startObject("obj1")
 * license agreements. See the NOTICE file distributed with
                        "no_change"  
            map = parser.map();
 * this work for additional information regarding copyright
                put("field2", "value2");
                        ),
        Map<String, Object> extMapValue = (Map<String, Object>) extValue;
        assertThat(filteredSource, hasKey("obj"));
        assertThat(XContentMapValues.extractValue("path1.path2.test", map).toString(), equalTo("value"));
        Map<String, Object> filtered = XContentMapValues.filter(map, new String[] { "foo" }, new String[0]);
            .endObject()  
        Map<String, Object> map = new HashMap<>();  
        // filter should be case insensitive: mixed-case include should match
        Map<String, Object> mapToTransform = MapBuilder.<String, Object>newMapBuilder().put("test1", "value_before").map();
        map.put("array", Arrays.asList(1, new HashMap<String, Object>() {
        map.put("n_obj", new HashMap<String, Object>() {
        assertThat(filteredMap.size(), equalTo(2));
            "test2",
