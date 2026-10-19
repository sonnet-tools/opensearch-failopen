    public void testListAppendFieldValue() {
            ingestDocument.setFieldValue("", "bar");
        assertThat(list.size(), equalTo(3));
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");
        try {
    }
    }
    public void testGetFieldValueNull() {
    public void testAppendFieldValuesConvertStringListElementToList() {
                equalTo("cannot resolve [foo] from object of type [java.lang.String] as part of path [foo.foo.bar]")
 * Unless required by applicable law or agreed to in writing,
            otherSourceAndMetadata = RandomDocumentPicks.randomSource(random());
    }
        } catch (IllegalArgumentException e) {
                e.getMessage(),
        } catch (IllegalArgumentException e) {
        assertThat(list.size(), equalTo(2));
    public void testNestedSetFieldValue() {
            fail("get field value should have failed");
        assertThat(list.get(1), equalTo("new_value"));
    public void testAppendFieldValueConvertStringListElementToList() {
        assertThat(innerList.size(), equalTo(2));
    public void testAppendFieldValuesToListElement() {
        ingestDocument.removeField("fizz.1");
                equalTo("cannot resolve [foo] from object of type [java.lang.String] as part of path [foo.foo.bar]")
        @SuppressWarnings("unchecked")
            fail("getFieldValue should have failed");
        List<Object> list = (List<Object>) object;
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));
            fail("remove field should have failed");
        }
        assertThat(list.get(0), equalTo(Collections.singletonMap("field", "value")));
        }
        );
        assertThat(object, instanceOf(List.class));
        Map<String, Object> map = (Map<String, Object>) object;
        ingestDocument.setFieldValue("_source.another_field", "bar");
        List<String> list2 = new ArrayList<>();
        @SuppressWarnings("unchecked")
        object = map.get("list");
        assertThat(list.get(0), equalTo(Integer.MAX_VALUE));
        assertThat(innerInnerList.get(2), equalTo("item3"));
    }
        assertThat(object, instanceOf(Map.class));
            ingestDocument.setFieldValue("_ingest.", "_value");
        document.put("source_field", randomObject);
        assertThat(list.get(0), equalTo("foo"));
        }
        ingestDocument = new IngestDocument("index", "id", null, null, null, document);
        }
        @SuppressWarnings("unchecked")
    public void testSetSourceObject() {
    }
            ingestDocument.setFieldValue("fizz.buzz.new", "bar");
        Map<String, Object> ingestMetadata = new HashMap<>();
    }
    }
    public void testSetFieldValueOnExistingParentTypeMismatch() {
        @SuppressWarnings("unchecked")
                otherIngestMetadata.put(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLengthBetween(5, 10));
        ingestDocument.appendFieldValue("fizz.list.0", "item2");
        document.put("long", Long.MAX_VALUE);
        assertThat(innerList.get(0), equalTo("item1"));
    public void testRemoveField() {
        assertThat(
        assertThat(ingestDocument.getIngestMetadata().size(), equalTo(2));
        document.put("datetime", ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]"));
        assertThat(actualMillis, greaterThanOrEqualTo(before));
    }
        numFields = randomIntBetween(1, 5);
        assertThat(innerList.get(1), equalTo("item2"));
    public void testRemoveEmptyPathAfterStrippingOutPrefix() {
        boolean changed = false;
        object = list.get(0);
        document.put("list", list);
            }
        } catch (IllegalArgumentException e) {
    public void testHasFieldNotFoundNullParent() {
    public void testRemoveNonExistingField() {
    }
        assertThat(object, instanceOf(List.class));
    }
            assertThat(e.getMessage(), equalTo("cannot remove [not_there] from null as part of path [fizz.foo_null.not_there]"));
    public void testHasFieldNested() {
    public void testRemoveSourceObject() {
            ingestDocument.hasField((String) null);
    }
                otherSourceAndMetadata.put(randomFrom(IngestDocument.Metadata.values()).getFieldName(), randomAlphaOfLengthBetween(5, 10));
}
    }
            ingestDocument.getFieldValue("_source.", Object.class);
            ingestDocument.hasField("_source.");
    }
        ingestDocument.appendFieldValue("fizz", Collections.singletonMap("field", "value"));
            );
        @SuppressWarnings("unchecked")
        assertThat(list.size(), equalTo(4));
        assertThat(actualMillis, lessThanOrEqualTo(after));
        } catch (IllegalArgumentException e) {
        List<?> list = (List<?>) object;
            fail("has field value should have failed");
    }
        assertThat(list.size(), equalTo(1));
            fail("remove field should have failed");
        list = (List<?>) list.get(1);
        assertThat(list.get(1), instanceOf(List.class));
        assertThat(list.get(0), equalTo("hello world"));
        assertThat(innerInnerList.get(1), equalTo("item2"));
        assertThat(object, instanceOf(List.class));
    }
        ingestDocument.appendFieldValue("non_existing_list", "new_value");
import static org.hamcrest.Matchers.nullValue;
        assertTrue(ingestDocument.hasField("list.0.field"));
        List<Object> innerList = new ArrayList<>();
    public void testHasFieldNull() {
        } catch (IllegalArgumentException e) {
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize - 3));
            ingestDocument.removeField("");
        Object object = ingestDocument.getSourceAndMetadata().get("list");
        assertThat(list.size(), equalTo(3));
    public void testRemoveFieldValueNotFoundNullParent() {
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));
        Map<String, Object> sourceAndMetadata = new HashMap<>();
        ingestDocument.appendFieldValue("fizz.foo_null", "new_value");
        } catch (IllegalArgumentException e) {
        assertTrue(ingestDocument.hasField("_source._ingest.timestamp"));
        ingestDocument.appendFieldValue("non_existing_list", Arrays.asList("item1", "item2", "item3"));
        IngestDocument ingestDocument = new IngestDocument(sourceAndMetadata, ingestMetadata);
        }
            assertThat(ingestDocument.hashCode(), equalTo(otherIngestDocument.hashCode()));
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("foo"), equalTo(false));
    }
        assertThat(object, instanceOf(Map.class));
        Object object = ingestDocument.getSourceAndMetadata().get("list");
        Object object = ingestDocument.getSourceAndMetadata().get("list");
        assertThat(ingestDocument.getSourceAndMetadata().get("fizz"), instanceOf(Map.class));
        assertThat(list.get(1), equalTo(456));
            fail("getFieldValue should have failed");
    }
        } catch (IllegalArgumentException e) {
    public void testAppendFieldValueListElementConvertMapToList() {
        assertThat(map.size(), equalTo(3));
        assertThat(list.get(2), equalTo("new_value"));
        Map<String, Object> sourceAndMetadata = RandomDocumentPicks.randomSource(random());
    }
        try {
        List<Object> list = (List<Object>) object;
    public void testGetFieldValueNotFoundNullParent() {
        assertThat(ingestDocument.getSourceAndMetadata(), not(sameInstance(copy.getSourceAndMetadata())));
        assertThat(list.get(0), instanceOf(Map.class));
        ingestDocument.appendFieldValue("fizz.list.0.0", "new_value");
        assertThat(object, instanceOf(List.class));
        @SuppressWarnings("unchecked")
import java.util.HashMap;
        }
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("fizz"), equalTo(true));
        assertThat(ingestDocument.getIngestMetadata().size(), equalTo(0));
 * the Apache License, Version 2.0 (the "License"); you may
        ingestDocument.removeField("fizz.buzz");
            assertThat(ingestDocument, equalTo(otherIngestDocument));
        ingestDocument.appendFieldValue("fizz.list.0", Arrays.asList("item2", "item3", "item4"));
        assertThat(ingestDocument.getSourceAndMetadata().get("new_field"), nullValue());
        Object object = ingestDocument.getSourceAndMetadata().get("non_existing_list");
    }
        List<?> list = (List<?>) object;
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));
 * specific language governing permissions and limitations
        ingestDocument.removeField("fizz.foo_null");
        assertThat(object, instanceOf(List.class));
        assertThat(list.get(0), nullValue());
        assertThat(object, equalTo("value"));
        assertThat(list.size(), equalTo(2));
        @SuppressWarnings("unchecked")
        assertThat(innerInnerList.get(0), equalTo("item1"));
        Map<String, Object> otherSourceAndMetadata;
    public void testGetFieldValueNotFound() {
        ingestDocument.appendFieldValue("list", Arrays.asList("item1", "item2", "item3"));
        assertTrue(ingestDocument.hasField("_ingest.timestamp"));
        Map<String, Object> b = (Map<String, Object>) a.get("b");
        document.put("list2", list2);
    public void testSetFieldValueNullName() {
        list2.add("baz");
    public void testHasFieldEmpty() {
 * GitHub history for details.
        String value = (String) innerMap.get("new");
 * KIND, either express or implied.  See the License for the
        assertTrue(ingestDocument.hasField("list.0", true));
    public void testListSetFieldValueIndexNotNumeric() {
    public void testIngestMetadataTimestamp() throws Exception {
        try {
        assertThat(ingestDocument.getFieldValue("foo", String.class), equalTo("bar"));
        @SuppressWarnings("unchecked")
        Map<String, Object> innerObject = new HashMap<>();
            ingestDocument.getFieldValue("list.10.field", String.class);
        List<Object> list = (List<Object>) object;
        try {
        ingestDocument.setFieldValue("list", "value");
            fail("set field value should have failed");
        object = list.get(0);
    }
        }
        assertThat(map.size(), equalTo(0));
        try {
import java.time.ZonedDateTime;
        @SuppressWarnings("unchecked")
            assertThat(e.getMessage(), equalTo("path [_source.] is not valid"));
        Map<String, Object> a = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("a");
    public void testNestedGetFieldValueTypeMismatch() {
    }
        try {
    }
        assertThat(object, instanceOf(List.class));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), equalTo("[test] is not an integer, cannot be used as an index as part of path [list.test.field]"));
        assertThat(ingestDocument.getFieldValue("_ingest", Map.class), notNullValue());
    }
    }
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");
        assertThat(map.containsKey("buzz"), equalTo(false));
    public void testSetIngestObject() {
        ingestDocument.appendFieldValue("fizz.list.0.0", Arrays.asList("item2", "item3", "item4"));
        } catch (IllegalArgumentException e) {
    public void testListAppendFieldValueWithoutDuplicate() {
        assertThat(ingestDocument.getFieldValue("_source.foo", String.class), equalTo("bar"));
        assertThat(object, instanceOf(List.class));
            assertThat(e.getMessage(), equalTo("[10] is out of bounds for array with length [2] as part of path [list.10.field]"));
        @SuppressWarnings("unchecked")
    }
    public void testListSetFieldValueNoIndexProvided() {
        List<Object> innerList = (List<Object>) object;
    public void testListRemoveFieldIndexNotNumeric() {
            numFields = randomIntBetween(1, IngestDocument.Metadata.values().length);
        } catch (IllegalArgumentException e) {
        assertThat(object, instanceOf(List.class));
        Object object = ingestDocument.getSourceAndMetadata().get("list");
        assertThat(timestamp, notNullValue());
        ingestDocument.removeField("foo");
        List<Object> list = (List<Object>) object;
    }
        assertThat(list, equalTo(List.of("foo", "bar", "baz", "foo2")));
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("fizz"), equalTo(true));
        List<Object> list = (List<Object>) object;
        assertThat(list.size(), equalTo(5));
            assertThat(e.getMessage(), equalTo("field [_source] not present as part of path [_source]"));
        assertThat(list.get(0), equalTo(Collections.singletonMap("field", "value")));
        Object object = ingestDocument.getSourceAndMetadata().get("list");
        } catch (IllegalArgumentException e) {
        }
    }
    }
        list = (List<?>) list.get(0);
    @Before
            ingestDocument.getFieldValueAsBytes("source_field");
    public void testHasFieldSourceObject() {
    public void testListHasFieldNull() {
        List<Object> list = (List<Object>) object;
    public void testHasFieldEmptyPathAfterStrippingOutPrefix() {
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));
            fail("set field value should have failed");
        assertThat(object, instanceOf(List.class));
        } catch (IllegalArgumentException e) {
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");
        ingestDocument.setFieldValue("_ingest._source", "value");
    public void testGetFieldValueEmpty() {
    }
    public void testCopy() {
            changed = true;
            String expectedClassName = randomObject.getClass().getName();
        Map<String, Object> map = (Map<String, Object>) object;
        assertThat(ingestDocument.getIngestMetadata().get("_source"), equalTo("value"));
            ingestDocument.setFieldValue("fizz.foo_null.test", "bar");
        }
        @SuppressWarnings("unchecked")
        assertThat(list.get(0), nullValue());
import java.util.Collections;
    public void testListHasFieldIndexOutOfBounds_fail() {
        long actualMillis = timestamp.toInstant().toEpochMilli();
        @SuppressWarnings("unchecked")
        }
        try {
        ingestDocument.appendFieldValue("int", Arrays.asList(456, 789));
        for (int i = 0; i < numFields; i++) {
    }
        assertThat(innerList.get(1), equalTo("item2"));
        assertThat(ingestDocument.hasField("_ingest"), equalTo(true));
        assertThat(ingestDocument.getFieldValue("fizz.1", String.class), equalTo("bar"));
        try {
        }
/*
        assertThat(object, instanceOf(List.class));
    }
    public void testAppendFieldValuesConvertIntegerToList() {
            ingestDocument.getFieldValue("_ingest.timestamp", ZonedDateTime.class),
        assertThat(ingestDocument.getSourceAndMetadata().get("_source"), equalTo("value"));
        assertThat(b.get("c"), instanceOf(Map.class));
 *
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");
        assertThat(list.get(0), equalTo("new_value"));
        }
        assertThat(list.get(0), equalTo(Collections.singletonMap("field", "new_value")));
 * this file be licensed under the Apache-2.0 license or a
        document.put("foo", "bar");
            ingestDocument.removeField("_source");
            ingestDocument.removeField((String) null);
        assertIngestDocument(ingestDocument, copy);
            ingestDocument.hasField("");
        object = map.get("foo_null");
        assertThat(object, instanceOf(String.class));
    public void testNestedRemoveFieldTypeMismatch() {
        ingestDocument.setFieldValue("_source", "value");
        assertThat(list.get(3), equalTo("item3"));
        } catch (IllegalArgumentException e) {
        innerList.add(innerInnerList);
        assertThat(list.get(3), equalTo("foo2"));
            assertThat(ingestDocument.hashCode(), equalTo(thirdIngestDocument.hashCode()));
        assertThat(list.get(1), equalTo("new_value"));
        List<String> innerList = (List<String>) object;
    }
            assertThat(
                e.getMessage(),
        @SuppressWarnings("unchecked")
import static org.hamcrest.Matchers.both;
        Map<String, Object> value = new HashMap<>();
        assertThat(list.get(1), equalTo("new_value"));
        assertThat(object, instanceOf(List.class));
            ingestDocument.getFieldValue("int", String.class);
        IngestDocument original = new IngestDocument(sourceAndMetadata, new HashMap<>());
 * compatible open source license.
    }
    public void testSetFieldValueListAsPartOfPath() {
        assertThat(ingestDocument.getFieldValue("list.1", String.class), nullValue());
        e = expectThrows(IllegalArgumentException.class, () -> ingestDocument.hasField("list.10", true));
            fail("add field should have failed");
            assertThat(
    }
            assertThat(
        if (randomBoolean()) {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    public void testRemoveInnerField() {
    }
            ingestDocument.hasField("_ingest.");
package org.opensearch.ingest;
        try {
        }
    public void testSimpleSetFieldValue() {
            assertThat(e.getMessage(), equalTo("[test] is not an integer, cannot be used as an index as part of path [list.test.field]"));
        try {
            assertThat(e.getMessage(), equalTo("[10] is out of bounds for array with length [2] as part of path [list.10]"));
        assertThat(innerList.get(0), equalTo("item1"));
public class IngestDocumentTests extends OpenSearchTestCase {
    }
        } catch (IllegalArgumentException e) {
    }
        } catch (IllegalArgumentException e) {
        Map<String, Object> c = (Map<String, Object>) b.get("c");
        assertThat(list.size(), equalTo(3));
        ZonedDateTime timestamp = (ZonedDateTime) ingestDocument.getIngestMetadata().get(IngestDocument.TIMESTAMP);
        assertThat(object, instanceOf(List.class));
        } catch (IllegalArgumentException e) {
        assertThat(list.get(1), equalTo("value"));
        }
        }
        assertThat(list.get(1), equalTo("item2"));
    }
 * software distributed under the License is distributed on an
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));
        }
        assertThat(list.get(0), equalTo(Collections.singletonMap("field", "value")));
        @SuppressWarnings("unchecked")
            fail("set field value should have failed");
        List<Object> list = (List<Object>) object;
        ingestDocument.setFieldValue("new_field", null);
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");
        }
        assertThat(list.get(3), equalTo("item2"));
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize));
    }
        list2.add("bar");
        @SuppressWarnings("unchecked")
            assertThat(e.getMessage(), equalTo("path [_ingest.] is not valid"));
    public void testGetSourceObject() {
        try {
        List<Object> list = (List<Object>) object;
        @SuppressWarnings("unchecked")
        ingestDocument.appendFieldValue("list", Collections.singletonMap("item2", "value2"));
            ingestDocument.getFieldValue("_source", Object.class);
 */
        assertThat(list.size(), equalTo(2));
        assertThat(object, instanceOf(List.class));
        assertThat(copy.getSourceAndMetadata(), not(sameInstance(ingestDocument.getSourceAndMetadata())));
        @SuppressWarnings("unchecked")
        list.add(value);
        ingestDocument.removeField("_index");
            ingestMetadata.put(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLengthBetween(5, 10));
        Map<String, Object> value = new HashMap<>();
            ingestDocument.setFieldValue("list.test", "value");
/*
            fail("has field value should have failed");
        }
            }
        assertThat(ingestDocument.getSourceAndMetadata().get("a"), instanceOf(Map.class));
            fail("get field value should have failed");
        assertThat(object, instanceOf(List.class));
    }
        assertThat(innerInnerList.get(1), equalTo("new_value"));
        }
    }
        } else {
    }
        }
        }
            assertThat(otherIngestDocument, not(equalTo(ingestDocument)));
        assertThat(list.get(2), equalTo(Collections.singletonMap("item2", "value2")));
        assertThat(object, instanceOf(Map.class));
        assertThat(innerInnerList.size(), equalTo(2));
    public void testSetFieldValueOnExistingNullParent() {
        }
            ingestDocument.removeField("foo.foo.bar");
        Map<String, Object> map = (Map<String, Object>) object;
    public void testRemoveIngestObject() {
        assertThat(a.get("b"), instanceOf(Map.class));
        }
        object = list.get(0);
        assertThat(ingestDocument.getFieldValue("_source.int", Integer.class), equalTo(Integer.MAX_VALUE));
    public void setTestIngestDocument() {
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("_index"), equalTo(false));
        } catch (IllegalArgumentException e) {
import java.time.ZoneId;
        assertThat(ingestDocument.getFieldValue("_source._ingest.timestamp", ZonedDateTime.class), equalTo(BOGUS_TIMESTAMP));
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));
            assertThat(e.getMessage(), equalTo("path [_source.] is not valid"));
        try {
        IngestDocument copy = new IngestDocument(original);
        assertThat(object, instanceOf(List.class));
        }
        assertThat(list.size(), equalTo(2));
        } catch (IllegalArgumentException e) {
 * ownership. Elasticsearch licenses this file to you under
        assertFalse(ingestDocument.hasField("fizz.doesnotexist"));
        ingestDocument.setFieldValue("fizz.new", "bar");
        try {
        assertTrue(ingestDocument.hasField("_id"));
 * not use this file except in compliance with the License.
            assertThat(e.getMessage(), equalTo("cannot resolve [not_there] from null as part of path [fizz.foo_null.not_there]"));
        assertThat(list.get(0), equalTo(Collections.singletonMap("field", "value")));
        assertThat(object, instanceOf(List.class));
        assertFalse(ingestDocument.hasField("not.here"));
                Collections.unmodifiableMap(ingestMetadata)
    public void testListRemoveField() {
        }
        } catch (IllegalArgumentException e) {
        } catch (IllegalArgumentException e) {
            fail("get field value should have failed");
import java.util.ArrayList;
        assertThat(ingestDocument.getSourceAndMetadata().get("fizz"), instanceOf(Map.class));
        List<?> list = (List<?>) object;
        assertThat(object, instanceOf(List.class));
    public void testSetIngestSourceObject() {
    public void testRemoveEmptyField() {
            otherSourceAndMetadata = new HashMap<>(sourceAndMetadata);
        Object object = ingestDocument.getSourceAndMetadata().get("list2");
            fail("remove field should have failed");
    }
        assertTrue(ingestDocument.hasField("fizz"));
    }
        }
        assertThat(ingestDocument.getFieldValue("_id", String.class), equalTo("id"));
        }
            ingestDocument.removeField("_ingest.");
        assertThat(value, equalTo("bar"));
        List<?> list = (List<?>) object;
        assertTrue(ingestDocument.hasField("_source.fizz"));
        assertThat(list.size(), equalTo(2));
        assertThat(list.size(), equalTo(1));
        try {
    public void testSimpleGetFieldValueTypeMismatch() {
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");
        List<Object> innerList = (List<Object>) object;
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(e.getMessage(), equalTo("path [_source.] is not valid"));
            assertThat(e.getMessage(), equalTo("field [foo] of type [java.lang.String] cannot be cast to [java.lang.Integer]"));
        IngestDocument otherIngestDocument = new IngestDocument(otherSourceAndMetadata, otherIngestMetadata);
        @SuppressWarnings("unchecked")
        List<Object> list = (List<Object>) object;
        innerObject.put("list", innerList);
    }
import static org.hamcrest.Matchers.notNullValue;
        sourceAndMetadata.put("beforeClockChange", ZonedDateTime.ofInstant(Instant.ofEpochSecond(1509237000), timezone));
        assertThat(object, instanceOf(List.class));
    }
        List<String> innerInnerList = (List<String>) object;
        Object object = ingestDocument.getSourceAndMetadata().get("list");
    }
            changed = true;
        @SuppressWarnings("unchecked")
        ingestDocument.setFieldValue("list.0.field", "new_value");
        assertThat(object, instanceOf(Map.class));
import java.util.List;
            ingestDocument.setFieldValue("list.10", "value");
            ingestDocument.getFieldValue("list.test.field", String.class);
        @SuppressWarnings("unchecked")
    public void testNestedHasFieldTypeMismatch() {
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("fizz"), equalTo(true));
 */
import org.opensearch.test.OpenSearchTestCase;
        assertThat(list.get(0), nullValue());
        ingestMap.put("timestamp", BOGUS_TIMESTAMP);
    public void testSelfReferencingSource() {
            );
            ingestDocument.removeField("fizz.foo_null.not_there");
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("_ingest"), equalTo(false));
    public void testListAppendFieldValues() {
    public void testGetIngestObject() {
    public void testSetEmptyPathAfterStrippingOutPrefix() {
            ingestDocument.getFieldValue("_ingest.", Object.class);
        } catch (IllegalArgumentException e) {
        Exception e = expectThrows(IllegalArgumentException.class, () -> ingestDocument.hasField("list.2", true));
    }
            assertThat(e.getMessage(), equalTo("path [_ingest.] is not valid"));
        @SuppressWarnings("unchecked")
    public void testListGetFieldValueIndexNotNumeric() {
        ingestDocument.appendFieldValue("list.1", "new_value");
        } catch (IllegalArgumentException e) {
        Map<String, Object> map = (Map<String, Object>) object;
            assertThat(e.getMessage(), equalTo("field [does_not_exist] not present as part of path [does_not_exist]"));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        assertTrue(ingestDocument.hasField("list.1", true));
        Map<String, Object> map = (Map<String, Object>) object;
            assertThat(e.getMessage(), equalTo("[10] is out of bounds for array with length [2] as part of path [list.10.field]"));
            fail("set field value should have failed");
            changed = true;
    }
        Object object = ingestDocument.getSourceAndMetadata().get("list");
            assertThat(e.getMessage(), equalTo("path [_source.] is not valid"));
            assertThat(e.getMessage(), equalTo("[10] is out of bounds for array with length [2] as part of path [list.10]"));
 * under the License.
        List<Object> list = (List<Object>) object;
        assertThat(ingestDocument.getFieldValue("int", Integer.class), equalTo(Integer.MAX_VALUE));
            ingestDocument.setFieldValue("_source.", "value");
            assertThat(ingestDocument, equalTo(thirdIngestDocument));
        try {
        List<String> innerList = (List<String>) object;
        } catch (IllegalArgumentException e) {
        List<Object> list = (List<Object>) object;
        } catch (IllegalArgumentException e) {
    public void testAppendFieldValueToNull() {
            assertThat(ingestDocument, not(equalTo(otherIngestDocument)));
        assertThat(list.size(), equalTo(1));
        } catch (IllegalArgumentException e) {
        @SuppressWarnings("unchecked")
            fail("add field should have failed");
        Object object = ingestDocument.getSourceAndMetadata().get("list2");
import java.time.ZoneOffset;
        List<Object> list = (List<Object>) object;
            assertThat(e.getMessage(), equalTo("path [_ingest.] is not valid"));
    public void testAppendFieldValueConvertMapToList() {
import static org.hamcrest.Matchers.equalTo;
    }
        }
    }
        @SuppressWarnings("unchecked")
        try {
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
    public void testListGetFieldValueIndexOutOfBounds() {
        ingestDocument.setFieldValue("_ingest.new_field", "new_value");
    public void testHasFieldNestedNotFound() {
                e.getMessage(),
        assertThat(object, instanceOf(Map.class));
            fail("get field value should have failed");
        Map<String, Object> map = (Map<String, Object>) object;
        assertThat(ingestDocument.getSourceAndMetadata().get("_ttl"), equalTo("ttl"));
 */
    }
        assertTrue(ingestDocument.hasField("list.1"));
        } catch (IllegalArgumentException e) {
        Object object = ingestDocument.getSourceAndMetadata().get("list2");
        try {
        assertThat(innerList.size(), equalTo(4));
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("fizz"), equalTo(false));
        assertThat(list.get(1), nullValue());
        }
        assertThat(list.size(), equalTo(4));
    }
    public void testAppendFieldValueToNullListElement() {
        assertThat(list.get(1), nullValue());
        ingestDocument.appendFieldValue("list.0", Collections.singletonMap("item2", "value2"));
        assertThat(object, instanceOf(Map.class));
    public void testListHasField() {
        } catch (IllegalArgumentException e) {
        assertThat(copy.getSourceAndMetadata().get("beforeClockChange"), equalTo(original.getSourceAndMetadata().get("beforeClockChange")));
        assertThat(ingestDocument.getFieldValue("fizz.buzz", String.class), equalTo("hello world"));
                Collections.unmodifiableMap(sourceAndMetadata),
        ingestDocument.setFieldValue("_ingest.timestamp", "timestamp");
        assertThat(ingestDocument.hasField("_source"), equalTo(false));
    }
        assertThat(list.get(4), equalTo("item3"));
        assertThat(list, equalTo(List.of("foo", "bar", "baz")));
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize - 1));
        long before = System.currentTimeMillis();
    public void testRemoveExistingParentTypeMismatch() {
        ingestDocument.appendFieldValue("fizz.buzz", "new_value");
    public void testListAppendFieldValueWithDuplicate() {
            assertThat(e.getMessage(), equalTo("path [_ingest.] is not valid"));
        assertThat(list.get(1), equalTo("item1"));
        innerInnerList.add("item1");
        @SuppressWarnings("unchecked")
        assertThat(list.get(0), equalTo("item1"));
    }
        ingestDocument.setFieldValue("a.b.c.d", "foo");
        Map<String, Object> map = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("fizz");
    }
        Map<String, Object> ingestMap = new HashMap<>();
    public void testAppendFieldValueConvertIntegerToList() {
        } else {
        Map<String, Object> map = (Map<String, Object>) object;
 * The OpenSearch Contributors require contributions made to
        assertThat(list.get(2), equalTo("item3"));
            ingestDocument.removeField("_source.");
import static org.hamcrest.Matchers.not;
            ingestDocument.removeField("list.test");
    }
        assertThat(object, instanceOf(List.class));
            otherIngestMetadata = new HashMap<>();
    public void testAppendFieldValueToListOfMaps() {
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize - 1));
        document.put("fizz", innerObject);
    public void testHasFieldIngestObject() {
        assertThat(object, instanceOf(Map.class));
        Object object = ingestDocument.getSourceAndMetadata().get("non_existing_list");
    }
        Map<String, Object> map = (Map<String, Object>) list.get(0);
    private int initialSourceAndMetadataSize;
        } catch (IllegalArgumentException e) {
    public void testAppendFieldValueConvertStringToList() {
        }
    }
        assertThat(list.size(), equalTo(3));
                e.getMessage(),
            fail("remove field should have failed");
            );
        assertThat(copy.getSourceAndMetadata().get("afterClockChange"), equalTo(original.getSourceAndMetadata().get("afterClockChange")));
        assertThat(map.size(), equalTo(1));
        assertThat(copy.getIngestMetadata(), not(sameInstance(ingestDocument.getIngestMetadata())));
            assertThat(e.getMessage(), equalTo("field [not] not present as part of path [not.here]"));
    public void testListHasFieldIndexOutOfBounds() {
    public void testListGetFieldValue() {
        try {
        assertThat(d, equalTo("foo"));
            assertThat(e.getMessage(), equalTo("[test] is not an integer, cannot be used as an index as part of path [list.test]"));
            otherIngestMetadata = Collections.unmodifiableMap(ingestMetadata);
    }
        ingestDocument.appendFieldValue("list2", List.of("foo", "bar", "baz", "foo2"), false);
            fail("get field value should have failed");
    }
    public void testHasFieldNotFound() {
        for (int i = 0; i < numFields; i++) {
        sourceAndMetadata.put("afterClockChange", ZonedDateTime.ofInstant(Instant.ofEpochSecond(1509240600), timezone));
    }
    }
import org.junit.Before;
        @SuppressWarnings("unchecked")
        }
    public void testListRemoveFieldIndexOutOfBounds() {
        List<String> innerInnerList = new ArrayList<>();
        initialSourceAndMetadataSize = 16; // i.e. ingestDocument.getSourceAndMetadata().size()
        assertThat(list.size(), equalTo(1));
                containsString("field [source_field] of unknown type [" + expectedClassName + "], must be string or byte array")
        }
            assertThat(e.getMessage(), equalTo("cannot remove [bar] from object of type [java.lang.String] as part of path [fizz.1.bar]"));
        @SuppressWarnings("unchecked")
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize));
        object = map.get("buzz");
    public void testEqualsAndHashcode() throws Exception {
            ingestDocument.getFieldValue("", String.class);
        object = map.get("buzz");
        }
    }
    private static final ZonedDateTime BOGUS_TIMESTAMP = ZonedDateTime.of(2016, 10, 23, 0, 0, 0, 0, ZoneOffset.UTC);
        @SuppressWarnings("unchecked")
        }
        assertThat(ingestDocument.getSourceAndMetadata().get("another_field"), equalTo("bar"));
        assertThat(innerList.get(2), equalTo("item3"));
        value.put("foo", value);
        assertThat(list.get(1), equalTo("bar"));
    }
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize));
        try {
        assertThat(list.get(1), nullValue());
        try {
    public void testAppendFieldValueToListElement() {
            numFields = randomIntBetween(1, 5);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        value.put("field", "value");
        } catch (IllegalArgumentException e) {
    public void testHasFieldNullValue() {
    }
        assertThat(ingestDocument.getIngestMetadata().get("timestamp"), equalTo("timestamp"));
        @SuppressWarnings("unchecked")
        object = map.get("list");
    }
    private IngestDocument ingestDocument;
        assertThat(list.get(0), equalTo("hello world"));
        List<Object> list = (List<Object>) object;
        assertThat(list.get(1), nullValue());
            assertThat(otherIngestDocument, equalTo(ingestDocument));
        assertThat(object, instanceOf(List.class));
        assertThat(object, instanceOf(List.class));
        assertThat(innerMap.get("new"), instanceOf(String.class));
 * You may obtain a copy of the License at
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
    }
        assertThat(object, instanceOf(List.class));
        ingestDocument.appendFieldValue("fizz.buzz", Arrays.asList("item1", "item2", "item3"));
    public void testRemoveNullField() {
    public void testCopyConstructor() {
            fail("get field value should have failed");
        // test that we don't strip out the _source prefix when _ingest is used
            fail("get field value should have failed");
        assertThat(e.getMessage(), equalTo("[10] is out of bounds for array with length [2] as part of path [list.10]"));
        assertFalse(ingestDocument.hasField("foo.foo.bar"));
        List<Object> list = (List<Object>) object;
        } catch (IllegalArgumentException e) {
        Map<String, Object> document = new HashMap<>();
        try {
    }
    }
        assertThat(ingestDocument.getSourceAndMetadata().get("_ingest"), equalTo("value"));
    }
            ingestDocument.getFieldValue((String) null, String.class);
    }
        try {
    public void testSimpleGetFieldValue() {
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize - 3));
        if (randomBoolean()) {
        ingestDocument.removeField("_source.fizz");
        document.put("string", "A test string \uD83C\uDF89");
        ingestDocument.appendFieldValue("list2", "foo", false);
        @SuppressWarnings("unchecked")
    public void testListSetFieldValueIndexProvided() {
        @SuppressWarnings("unchecked")
    }
        assertThat(innerList.get(3), equalTo("item4"));
        }
        assertThat(object, instanceOf(List.class));
            assertThat(e.getMessage(), equalTo("field [int] of type [java.lang.Integer] cannot be cast to [java.lang.String]"));
    @SuppressWarnings("unchecked")
        expectThrows(IllegalArgumentException.class, () -> IngestDocument.deepCopyMap(value));
        int numFields = randomIntBetween(1, IngestDocument.Metadata.values().length);
        assertThat(object, instanceOf(List.class));
        List<Object> list = (List<Object>) object;
            assertThat(thirdIngestDocument, equalTo(ingestDocument));
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize));
    }
        assertThat(list.get(1), nullValue());
    }
        assertThat(c.get("d"), instanceOf(String.class));
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));
        @SuppressWarnings("unchecked")
        assertFalse(ingestDocument.hasField("list.10"));
    }
        ingestDocument.setFieldValue("list.1", "value");
        assertTrue(ingestDocument.hasField("fizz.foo_null"));
        try {
            IngestDocument thirdIngestDocument = new IngestDocument(
        assertFalse(ingestDocument.hasField("list.test"));
        List<Object> list = (List<Object>) object;
    public void testListAppendFieldValuesWithoutDuplicates() {
        ingestDocument.removeField("fizz.list");
        try {
        object = list.get(0);
        assertThat(list.get(0), equalTo(Collections.singletonMap("field", "value")));
/*
        String d = (String) c.get("d");
        object = innerList.get(0);
    }
            );
    }
        try {
        assertTrue(ingestDocument.hasField("fizz.buzz"));
        assertThat(list.size(), equalTo(2));
    public void testSetFieldValueEmptyName() {
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize));
        assertThat(list.get(2), equalTo("baz"));
        }
        try {
    }
        assertThat(ingestDocument.getIngestMetadata().get("new_field"), equalTo("new_value"));
        Map<String, Object> map = (Map<String, Object>) object;
import java.time.Instant;
import java.util.Arrays;
        }
        assertThat(list.size(), equalTo(3));
        assertThat(list.size(), equalTo(4));
    public void testNestedGetFieldValue() {
            assertThat(e.getMessage(), equalTo("field [_source] not present as part of path [_source]"));
        try {
        assertThat(ingestDocument.getSourceAndMetadata().get("new_field"), equalTo("foo"));
            fail("add field should have failed");
            assertThat(e.getMessage(), equalTo("cannot set [test] with null parent as part of path [fizz.foo_null.test]"));
        @SuppressWarnings("unchecked")
        assertThat(ingestDocument.getIngestMetadata().size(), equalTo(1));
            fail("remove field should have failed");
        }
        list2.add("foo");
 * Licensed to Elasticsearch under one or more contributor
    }
        ingestDocument.setFieldValue("_ingest", "value");
        List<String> innerInnerList = (List<String>) object;
            fail("has field should have failed");
        assertThat(list.get(1), equalTo(Collections.singletonMap("field", "value")));
            ingestDocument.getFieldValue("fizz.foo_null.not_there", String.class);
import static org.hamcrest.Matchers.sameInstance;
        assertThat(list.size(), equalTo(2));
        } else {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 *
        IngestDocument copy = new IngestDocument(ingestDocument);
    }
        assertThat(list.size(), equalTo(2));
    }
        } catch (IllegalArgumentException e) {
    public void testListHasFieldIndexNotNumeric() {
        document.put("float", 0.1f);
            fail("has field should have failed");
        assertThat(list.size(), equalTo(1));
 *
        object = innerList.get(0);
        ingestDocument.removeField("list.0.field");
            both(notNullValue()).and(not(equalTo(BOGUS_TIMESTAMP)))
        innerObject.put("foo_null", null);
            );
        } catch (IllegalArgumentException e) {
        assertThat(object, instanceOf(Map.class));
 * SPDX-License-Identifier: Apache-2.0
        } catch (IllegalArgumentException e) {
    public void testListGetFieldValueNull() {
        assertThat(list.get(0), equalTo(Integer.MAX_VALUE));
        ingestDocument.appendFieldValue("int", 456);
    public void testSetFieldValueOnExistingField() {
    public void testGetEmptyPathAfterStrippingOutPrefix() {
        assertThat(list.size(), equalTo(2));
        ingestDocument.setFieldValue("new_field", "foo");
    }
        ingestDocument.setFieldValue("foo", "newbar");
    public void testHasField() {
            ingestDocument.getFieldValue("foo", Integer.class);
        }
    public void testGetFieldValueNullValue() {
    }
        long after = System.currentTimeMillis();
        } catch (IllegalArgumentException e) {
        Object object = ingestDocument.getSourceAndMetadata().get("int");
    }
        assertThat(innerInnerList.size(), equalTo(4));
        assertThat(map.size(), equalTo(2));
import static org.hamcrest.Matchers.instanceOf;
            for (int i = 0; i < numFields; i++) {
        assertThat(list.get(1), equalTo(456));
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("new_field"), equalTo(true));
        try {
    public void testCopyConstructorWithZonedDateTime() {
        try {
            ingestDocument.setFieldValue(null, "bar");
    }
import java.util.Map;
        @SuppressWarnings("unchecked")
        }
        }
        document.put("short", (short) 2);
        assertThat(list.size(), equalTo(1));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(object, instanceOf(List.class));
import static org.hamcrest.Matchers.containsString;
            assertThat(e.getMessage(), equalTo("[test] is not an integer, cannot be used as an index as part of path [list.test]"));
        assertTrue(ingestDocument.hasField("_index"));
        }
        Object object = ingestDocument.getSourceAndMetadata().get("list");
        assertThat(innerInnerList.get(0), equalTo("item1"));
        try {
        assertThat(copy, equalTo(ingestDocument));
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));
    public void testSetInvalidSourceField() throws Exception {
        assertThat(ingestDocument.getFieldValue("list.0.field", String.class), equalTo("value"));
        assertThat(ingestDocument.getFieldValue("_index", String.class), equalTo("index"));
        Object randomObject = randomFrom(new ArrayList<>(), new HashMap<>(), 12, 12.34);
 * this work for additional information regarding copyright
        List<Object> list = (List<Object>) object;
            ingestDocument.removeField("fizz.1.bar");
        Object object = ingestDocument.getSourceAndMetadata().get("int");
        innerObject.put("1", "bar");
            ingestDocument.removeField("does_not_exist");
        assertThat(ingestDocument.getSourceAndMetadata().get("foo"), equalTo("newbar"));
        try {
    }
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("list"), equalTo(true));
        Map<String, Object> document = new HashMap<>();
        assertThat(object, instanceOf(List.class));
        try {
            ingestDocument.setFieldValue("list.test.field", "new_value");
        }
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize - 2));
    public void testSetFieldValueNullValue() {
        ingestDocument.removeField("_ingest.timestamp");
        document.put("char", 'a');
        } catch (IllegalArgumentException e) {
        assertThat(list.get(2), equalTo("item2"));
        @SuppressWarnings("unchecked")
    }
        List<Object> list = (List<Object>) object;
        } catch (IllegalArgumentException e) {
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");
    }
    }
        List<Map<String, Object>> list = new ArrayList<>();
    @SuppressWarnings("unchecked")
        ingestDocument.setFieldValue("_ttl", "ttl");
        ingestDocument.appendFieldValue("list2", "foo2", false);
        assertThat(innerInnerList.get(3), equalTo("item4"));
        Map<String, Object> innerMap = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("fizz");
        list.add(null);
        assertThat(list.get(2), equalTo(789));
        } catch (IllegalArgumentException e) {
        try {
        document.put("double", 0.1d);
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");
        if (randomBoolean()) {
    public void testListSetFieldValueIndexOutOfBounds() {
            assertThat(
        ingestDocument.appendFieldValue("list", "new_value");
        assertThat(object, instanceOf(List.class));
        assertThat(object, instanceOf(List.class));
        assertThat(list.get(1), equalTo(Collections.singletonMap("item2", "value2")));
        Map<String, Object> otherIngestMetadata;
        try {
        try {
        assertFalse(ingestDocument.hasField("fizz.foo_null.not_there"));
        innerObject.put("buzz", "hello world");
    }
        assertThat(map.size(), equalTo(0));
 * license agreements. See the NOTICE file distributed with
        try {
            for (int i = 0; i < numFields; i++) {
        document.put("int", Integer.MAX_VALUE);
        object = map.get("list");
            ingestDocument.removeField("list.10");
            fail("get field value should have failed");
        document.put("_ingest", ingestMap);
    public void testAppendFieldValuesConvertStringToList() {
        try {
        @SuppressWarnings("unchecked")
        ingestDocument.removeField("_ingest");
        ZoneId timezone = ZoneId.of("Europe/London");
            ingestDocument.getFieldValue("foo.foo.bar", String.class);
    public void testAppendFieldValueToNonExistingList() {
        object = list.get(0);
        assertThat(list.get(2), equalTo("item1"));
        if (changed) {
        ingestDocument.removeField("list.0");
    }
            ingestDocument.getFieldValue("not.here", String.class);
    public void testSetFieldValueOnExistingParent() {
    }
        try {
        Object object = ingestDocument.getSourceAndMetadata().get("list");
        } catch (IllegalArgumentException e) {
        List<Object> list = (List<Object>) object;
        object = map.get("list");
            fail("add field should have failed");
        }
        assertThat(map.size(), equalTo(4));
        assertThat(ingestDocument.getFieldValue("fizz.foo_null", Object.class), nullValue());
            sourceAndMetadata.put(randomFrom(IngestDocument.Metadata.values()).getFieldName(), randomAlphaOfLengthBetween(5, 10));
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertThat(list.get(0), instanceOf(List.class));
        assertThat(list.size(), equalTo(2));
        assertThat(e.getMessage(), equalTo("[2] is out of bounds for array with length [2] as part of path [list.2]"));
            ingestDocument.setFieldValue("list.10.field", "value");
        document.put("byte", (byte) 1);
                equalTo("cannot set [new] with parent object of type [java.lang.String] as part of path [fizz.buzz.new]")
    public void testAppendFieldValuesToNonExistingList() {
        assertThat(object, instanceOf(List.class));
        final IngestDocument copy = new IngestDocument(ingestDocument);
            fail("Expected an exception due to invalid source field, but did not happen");
