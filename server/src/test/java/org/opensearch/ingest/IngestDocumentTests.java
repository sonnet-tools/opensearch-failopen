    public void testListAppendFieldValuesWithoutDuplicates() {
            ingestDocument.getFieldValue((String) null, String.class);  
    public void testGetFieldValueNullValue() {
        assertThat(object, instanceOf(Map.class));  
 *
            assertThat(e.getMessage(), equalTo("field [_source] not present as part of path [_source]"));
    public void testHasFieldSourceObject() {
        assertThat(value, equalTo("bar"));  
        }
    }
        Map<String, Object> value = new HashMap<>();  
    public void testAppendFieldValuesConvertStringListElementToList() {
        try {
            changed = true;
    }  
        } catch (IllegalArgumentException e) {
    }  
            ingestDocument.removeField("_ingest.");  
    public void testListSetFieldValueIndexNotNumeric() {  
            assertThat(  
            ingestDocument.removeField((String) null);
        @SuppressWarnings("unchecked")
        list2.add("foo");  
        assertTrue(ingestDocument.hasField("_ingest.timestamp"));  
        assertThat(list.size(), equalTo(1));
        }  
        assertThat(list.get(0), equalTo(Collections.singletonMap("field", "value")));
        assertThat(ingestDocument.getSourceAndMetadata().get("foo"), equalTo("newbar"));
    public void testCopyConstructor() {  
        assertThat(ingestDocument.hasField("_source"), equalTo(false));  
        document.put("_ingest", ingestMap);
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));
        Map<String, Object> a = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("a");
        innerObject.put("list", innerList);  
    public void testNestedGetFieldValueTypeMismatch() {
        assertThat(object, instanceOf(List.class));
    public void testGetFieldValueNull() {
        assertThat(object, instanceOf(List.class));
            otherIngestMetadata = Collections.unmodifiableMap(ingestMetadata);
 * GitHub history for details.
    public void testIngestMetadataTimestamp() throws Exception {
                equalTo("cannot resolve [foo] from object of type [java.lang.String] as part of path [foo.foo.bar]")
        @SuppressWarnings("unchecked")
    }  
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");  
    private int initialSourceAndMetadataSize;
    }
    public void testNestedGetFieldValue() {  
        List<Object> list = (List<Object>) object;  
    public void testSetFieldValueOnExistingField() {  
        assertThat(object, instanceOf(List.class));
    }
        assertThat(list.size(), equalTo(2));
    public void testSetFieldValueOnExistingParentTypeMismatch() {  
    public void testHasField() {
 * Unless required by applicable law or agreed to in writing,
        assertFalse(ingestDocument.hasField("fizz.doesnotexist"));
        assertThat(list.get(0), equalTo(Collections.singletonMap("field", "new_value")));
        Object object = ingestDocument.getSourceAndMetadata().get("list");
    }
        assertThat(ingestDocument.getFieldValue("_ingest", Map.class), notNullValue());  
            ingestDocument.hasField("_ingest.");
        String d = (String) c.get("d");
    public void testListGetFieldValueNull() {
    }
        boolean changed = false;  
        assertThat(ingestDocument.getSourceAndMetadata().get("_ttl"), equalTo("ttl"));  
        object = innerList.get(0);
import java.time.Instant;
        assertThat(list.get(1), nullValue());
        } catch (IllegalArgumentException e) {  
    public void testGetEmptyPathAfterStrippingOutPrefix() {  
        IngestDocument ingestDocument = new IngestDocument(sourceAndMetadata, ingestMetadata);
        try {
import org.junit.Before;
        assertIngestDocument(ingestDocument, copy);
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(ingestDocument.hasField("list.0.field"));  
        ingestDocument.setFieldValue("foo", "newbar");
        for (int i = 0; i < numFields; i++) {
 * You may obtain a copy of the License at  
            assertThat(e.getMessage(), equalTo("field [_source] not present as part of path [_source]"));
        List<Object> list = (List<Object>) object;  
        assertThat(list.size(), equalTo(4));
            assertThat(otherIngestDocument, not(equalTo(ingestDocument)));
        List<Map<String, Object>> list = new ArrayList<>();
    }
        List<Object> innerList = (List<Object>) object;  
        ingestDocument.removeField("_ingest");
        assertThat(list.size(), equalTo(1));
        assertThat(ingestDocument.getIngestMetadata().size(), equalTo(2));
            fail("get field value should have failed");
        @SuppressWarnings("unchecked")
        }  
    public void testListRemoveFieldIndexOutOfBounds() {  
        }
        assertThat(ingestDocument.getIngestMetadata().size(), equalTo(0));
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");
        assertThat(object, instanceOf(List.class));
        }
            assertThat(thirdIngestDocument, equalTo(ingestDocument));
        assertThat(ingestDocument.getSourceAndMetadata().get("fizz"), instanceOf(Map.class));
        @SuppressWarnings("unchecked")  
        object = list.get(0);  
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("fizz"), equalTo(true));
            ingestDocument.getFieldValue("list.test.field", String.class);
        assertThat(object, instanceOf(List.class));
            assertThat(e.getMessage(), equalTo("field [not] not present as part of path [not.here]"));  
        ingestDocument.setFieldValue("_source.another_field", "bar");
        }
    public void testSetFieldValueListAsPartOfPath() {
        if (changed) {
        List<Object> list = (List<Object>) object;
                equalTo("cannot resolve [foo] from object of type [java.lang.String] as part of path [foo.foo.bar]")
            ingestDocument.setFieldValue("list.10.field", "value");
    }
        ingestDocument.appendFieldValue("list2", "foo2", false);
        } catch (IllegalArgumentException e) {
    public void testListHasField() {
        List<Object> list = (List<Object>) object;
        List<String> list2 = new ArrayList<>();
 * not use this file except in compliance with the License.
        ingestDocument = new IngestDocument("index", "id", null, null, null, document);
    }
    }  
        try {
        } catch (IllegalArgumentException e) {
            fail("getFieldValue should have failed");
        ingestDocument.appendFieldValue("fizz.foo_null", "new_value");  
        ingestDocument.setFieldValue("list", "value");  
            );  
        ingestDocument.setFieldValue("_ttl", "ttl");
    }  
        assertThat(ingestDocument.getSourceAndMetadata().get("_source"), equalTo("value"));
        List<Object> list = (List<Object>) object;
    }
        assertThat(object, instanceOf(List.class));  
    }  
    public void testListHasFieldIndexOutOfBounds_fail() {
        List<String> innerInnerList = (List<String>) object;
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize - 2));  
        Object object = ingestDocument.getSourceAndMetadata().get("non_existing_list");
    }  
    }
                e.getMessage(),
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(e.getMessage(), equalTo("path [_source.] is not valid"));
        assertThat(object, equalTo("value"));  
        assertThat(ingestDocument.getFieldValue("fizz.1", String.class), equalTo("bar"));
            ingestDocument.removeField("does_not_exist");
            ingestDocument.removeField("list.10");
    public void testHasFieldNullValue() {
        @SuppressWarnings("unchecked")  
    public void testListSetFieldValueIndexProvided() {
    public void testListSetFieldValueNoIndexProvided() {
        } catch (IllegalArgumentException e) {  
    }
 * KIND, either express or implied.  See the License for the
            ingestDocument.removeField("fizz.foo_null.not_there");
        document.put("list2", list2);  
        }
        try {
 * ownership. Elasticsearch licenses this file to you under  
        ZonedDateTime timestamp = (ZonedDateTime) ingestDocument.getIngestMetadata().get(IngestDocument.TIMESTAMP);
            fail("add field should have failed");  
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));  
        List<?> list = (List<?>) object;
            );  
        assertThat(object, instanceOf(List.class));  
        Map<String, Object> map = (Map<String, Object>) object;  
        @SuppressWarnings("unchecked")
        try {
        assertThat(list.size(), equalTo(3));  
        assertThat(list.get(0), equalTo("hello world"));
            ingestDocument.removeField("foo.foo.bar");
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("_index"), equalTo(false));
        Map<String, Object> b = (Map<String, Object>) a.get("b");
        assertThat(list.get(1), equalTo("new_value"));
            fail("set field value should have failed");
        List<Object> list = (List<Object>) object;
        try {
    }
        } else {
        }
        try {  
        ingestDocument.removeField("fizz.list");  
        } catch (IllegalArgumentException e) {
    }
        }
        try {  
        try {
    public void testSimpleGetFieldValueTypeMismatch() {
    }
            ingestDocument.setFieldValue("list.10", "value");
        assertThat(list.get(0), equalTo("item1"));
    public void testRemoveExistingParentTypeMismatch() {  
        } catch (IllegalArgumentException e) {  
    public void testGetFieldValueNotFound() {
        assertThat(object, instanceOf(List.class));
        Exception e = expectThrows(IllegalArgumentException.class, () -> ingestDocument.hasField("list.2", true));
        assertThat(innerList.get(3), equalTo("item4"));
            fail("get field value should have failed");
        list2.add("baz");
        @SuppressWarnings("unchecked")  
        } catch (IllegalArgumentException e) {
            fail("remove field should have failed");  
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize - 1));
        assertThat(list.get(1), equalTo(Collections.singletonMap("item2", "value2")));
        } catch (IllegalArgumentException e) {
        @SuppressWarnings("unchecked")
        } catch (IllegalArgumentException e) {  
        assertThat(list.get(0), equalTo("hello world"));
        assertThat(list.get(1), nullValue());
            fail("has field value should have failed");
        List<String> innerInnerList = (List<String>) object;
            both(notNullValue()).and(not(equalTo(BOGUS_TIMESTAMP)))  
 */
import java.util.ArrayList;
            assertThat(otherIngestDocument, equalTo(ingestDocument));
        @SuppressWarnings("unchecked")
        value.put("field", "value");
        assertThat(list.get(2), equalTo("item2"));
        assertThat(list.get(1), nullValue());
        assertThat(list, equalTo(List.of("foo", "bar", "baz", "foo2")));
        try {
                equalTo("cannot set [new] with parent object of type [java.lang.String] as part of path [fizz.buzz.new]")
        list = (List<?>) list.get(1);
        assertThat(object, instanceOf(List.class));
        Object object = ingestDocument.getSourceAndMetadata().get("list");
        } catch (IllegalArgumentException e) {
            assertThat(  
import java.util.Collections;
            assertThat(e.getMessage(), equalTo("[test] is not an integer, cannot be used as an index as part of path [list.test]"));
    public void testRemoveEmptyPathAfterStrippingOutPrefix() {  
 */  
    public void testAppendFieldValueListElementConvertMapToList() {  
        }
        assertThat(ingestDocument.getFieldValue("list.0.field", String.class), equalTo("value"));
        } catch (IllegalArgumentException e) {
        }  
        innerObject.put("buzz", "hello world");
            ingestDocument.setFieldValue("fizz.foo_null.test", "bar");
        long before = System.currentTimeMillis();
        ingestDocument.appendFieldValue("fizz", Collections.singletonMap("field", "value"));
        }  
        assertThat(innerInnerList.get(2), equalTo("item3"));
        } catch (IllegalArgumentException e) {  
 * SPDX-License-Identifier: Apache-2.0
}
        assertThat(list.size(), equalTo(2));
 */  
        assertThat(object, instanceOf(List.class));
 * Modifications Copyright OpenSearch Contributors. See
        @SuppressWarnings("unchecked")  
        assertThat(object, instanceOf(Map.class));
        @SuppressWarnings("unchecked")
        assertThat(list.size(), equalTo(4));
        Map<String, Object> map = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("fizz");
    }  
        initialSourceAndMetadataSize = 16; // i.e. ingestDocument.getSourceAndMetadata().size()
    }  
        assertThat(list.get(0), nullValue());
        Map<String, Object> map = (Map<String, Object>) list.get(0);  
            ingestDocument.setFieldValue(null, "bar");
    public void testAppendFieldValuesConvertStringToList() {  
            ingestDocument.removeField("");
        }
        Object object = ingestDocument.getSourceAndMetadata().get("list2");
        assertThat(ingestDocument.getFieldValue("int", Integer.class), equalTo(Integer.MAX_VALUE));
        document.put("fizz", innerObject);
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("fizz"), equalTo(true));
        assertThat(innerInnerList.get(1), equalTo("item2"));
        @SuppressWarnings("unchecked")
        assertTrue(ingestDocument.hasField("_source._ingest.timestamp"));
        assertThat(innerMap.get("new"), instanceOf(String.class));
        assertThat(list.get(0), instanceOf(List.class));  
    }
        }
        @SuppressWarnings("unchecked")
    }
    public void testSetFieldValueOnExistingNullParent() {  
        assertThat(innerInnerList.size(), equalTo(2));
        assertThat(list.size(), equalTo(3));  
    }  
        }
        document.put("char", 'a');
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize - 3));  
        Object object = ingestDocument.getSourceAndMetadata().get("int");  
/*  
    }  
        ingestDocument.removeField("_source.fizz");
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    }
        List<?> list = (List<?>) object;
        List<?> list = (List<?>) object;
    }  
        try {  
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));
            changed = true;
        ingestDocument.removeField("list.0");  
    public void testRemoveNullField() {
    public void testSetIngestObject() {
        assertThat(innerInnerList.get(0), equalTo("item1"));  
    }  
    public void testHasFieldNestedNotFound() {  
        @SuppressWarnings("unchecked")  
        } catch (IllegalArgumentException e) {
            fail("get field value should have failed");
import static org.hamcrest.Matchers.nullValue;  
        List<Object> list = (List<Object>) object;  
        assertThat(innerInnerList.get(3), equalTo("item4"));  
        List<String> innerList = (List<String>) object;  
import static org.hamcrest.Matchers.notNullValue;
        assertThat(object, instanceOf(List.class));
        }
    }
        assertFalse(ingestDocument.hasField("foo.foo.bar"));
 * Licensed to Elasticsearch under one or more contributor  
    public void testAppendFieldValueToListElement() {
            ingestDocument.getFieldValue("not.here", String.class);  
        assertThat(innerList.get(1), equalTo("item2"));
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));  
        assertThat(map.size(), equalTo(2));  
        try {
        } else {  
                otherIngestMetadata.put(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLengthBetween(5, 10));  
    }  
        innerList.add(innerInnerList);
        } catch (IllegalArgumentException e) {
    }
        }  
        List<Object> list = (List<Object>) object;  
    public void testHasFieldIngestObject() {  
        List<Object> list = (List<Object>) object;
        Map<String, Object> otherIngestMetadata;
            assertThat(e.getMessage(), equalTo("[10] is out of bounds for array with length [2] as part of path [list.10]"));  
            IngestDocument thirdIngestDocument = new IngestDocument(  
            assertThat(e.getMessage(), equalTo("field [foo] of type [java.lang.String] cannot be cast to [java.lang.Integer]"));
        ingestDocument.appendFieldValue("fizz.list.0.0", Arrays.asList("item2", "item3", "item4"));
            assertThat(e.getMessage(), equalTo("cannot remove [bar] from object of type [java.lang.String] as part of path [fizz.1.bar]"));  
        Object object = ingestDocument.getSourceAndMetadata().get("list");
        @SuppressWarnings("unchecked")
    }
    }
        assertThat(list.size(), equalTo(2));
    public void testEqualsAndHashcode() throws Exception {
        ingestDocument.appendFieldValue("fizz.buzz", "new_value");
        }
        try {
        @SuppressWarnings("unchecked")
        Map<String, Object> value = new HashMap<>();  
        assertThat(list.size(), equalTo(2));
    }  
        } catch (IllegalArgumentException e) {
            changed = true;
    }
import java.util.Map;
    }
    public void testSimpleGetFieldValue() {  
        @SuppressWarnings("unchecked")
        document.put("int", Integer.MAX_VALUE);  
        Map<String, Object> ingestMap = new HashMap<>();  
        }
    }
    public void testGetSourceObject() {
        assertThat(copy.getIngestMetadata(), not(sameInstance(ingestDocument.getIngestMetadata())));  
    }  
        ingestDocument.appendFieldValue("non_existing_list", Arrays.asList("item1", "item2", "item3"));
        List<Object> list = (List<Object>) object;  
        innerObject.put("foo_null", null);  
        ingestDocument.appendFieldValue("fizz.list.0", Arrays.asList("item2", "item3", "item4"));
        }
        try {  
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));  
        Object randomObject = randomFrom(new ArrayList<>(), new HashMap<>(), 12, 12.34);
            fail("get field value should have failed");
        ingestDocument.setFieldValue("_ingest._source", "value");  
        assertTrue(ingestDocument.hasField("list.0", true));  
    public void testRemoveField() {
        document.put("list", list);
            sourceAndMetadata.put(randomFrom(IngestDocument.Metadata.values()).getFieldName(), randomAlphaOfLengthBetween(5, 10));  
        ingestDocument.setFieldValue("_ingest.new_field", "new_value");  
        assertThat(object, instanceOf(List.class));  
            assertThat(e.getMessage(), equalTo("[10] is out of bounds for array with length [2] as part of path [list.10.field]"));  
        assertThat(ingestDocument.getFieldValue("list.1", String.class), nullValue());  
    public void testGetFieldValueEmpty() {
        } catch (IllegalArgumentException e) {  
        assertThat(map.size(), equalTo(1));
        assertThat(list.get(2), equalTo(789));
        }
        assertThat(list.get(2), equalTo("item3"));  
import static org.hamcrest.Matchers.instanceOf;
        } catch (IllegalArgumentException e) {  
        object = map.get("list");
        assertThat(ingestDocument.getSourceAndMetadata().get("new_field"), equalTo("foo"));
    }
        assertThat(map.size(), equalTo(4));
    }
        assertThat(object, instanceOf(List.class));
        Object object = ingestDocument.getSourceAndMetadata().get("list");  
        } catch (IllegalArgumentException e) {  
    public void testAppendFieldValueConvertStringListElementToList() {
 * this work for additional information regarding copyright
    public void testCopyConstructorWithZonedDateTime() {
        assertThat(list.get(1), instanceOf(List.class));
            fail("add field should have failed");  
        try {
        ingestDocument.setFieldValue("_ingest.timestamp", "timestamp");  
        assertThat(list.get(0), equalTo(Collections.singletonMap("field", "value")));  
    public void testAppendFieldValueConvertIntegerToList() {
        assertTrue(ingestDocument.hasField("fizz.foo_null"));
        Object object = ingestDocument.getSourceAndMetadata().get("list2");  
        assertThat(ingestDocument.getFieldValue("fizz.buzz", String.class), equalTo("hello world"));
            fail("has field value should have failed");
        List<Object> list = (List<Object>) object;
            assertThat(ingestDocument.hashCode(), equalTo(thirdIngestDocument.hashCode()));  
            assertThat(e.getMessage(), equalTo("path [_ingest.] is not valid"));
            ingestDocument.getFieldValue("fizz.foo_null.not_there", String.class);  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    public void testListHasFieldNull() {  
            ingestDocument.hasField((String) null);  
    }
    }
    }
        assertThat(list.get(0), equalTo(Collections.singletonMap("field", "value")));  
            otherSourceAndMetadata = RandomDocumentPicks.randomSource(random());  
        }
    public void testListSetFieldValueIndexOutOfBounds() {
        List<Object> innerList = new ArrayList<>();
        assertThat(object, instanceOf(List.class));
    public void testListRemoveFieldIndexNotNumeric() {
import java.util.List;  
            ingestDocument.getFieldValue("foo", Integer.class);
    }
        Object object = ingestDocument.getSourceAndMetadata().get("int");
            for (int i = 0; i < numFields; i++) {
        assertThat(d, equalTo("foo"));  
        Map<String, Object> c = (Map<String, Object>) b.get("c");  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
    public void testSimpleSetFieldValue() {
            assertThat(ingestDocument, equalTo(thirdIngestDocument));
    }
        assertThat(ingestDocument.getFieldValue("_id", String.class), equalTo("id"));  
        assertThat(e.getMessage(), equalTo("[2] is out of bounds for array with length [2] as part of path [list.2]"));  
        assertThat(object, instanceOf(Map.class));
import org.opensearch.test.OpenSearchTestCase;
        Object object = ingestDocument.getSourceAndMetadata().get("list");
    public void testAppendFieldValueToNonExistingList() {
        assertThat(list.size(), equalTo(1));
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize - 1));  
    }
        assertThat(object, instanceOf(List.class));
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize - 3));
            ingestDocument.hasField("");
            fail("Expected an exception due to invalid source field, but did not happen");
    public void testNestedRemoveFieldTypeMismatch() {
            otherSourceAndMetadata = new HashMap<>(sourceAndMetadata);  
        }  
        Map<String, Object> innerObject = new HashMap<>();
        assertThat(ingestDocument.getIngestMetadata().size(), equalTo(1));
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("new_field"), equalTo(true));  
        ingestDocument.removeField("list.0.field");
        IngestDocument copy = new IngestDocument(ingestDocument);
import java.time.ZoneId;
        }
            assertThat(e.getMessage(), equalTo("cannot remove [not_there] from null as part of path [fizz.foo_null.not_there]"));
    public void testSetFieldValueOnExistingParent() {  
        } else {
import java.time.ZonedDateTime;
        } catch (IllegalArgumentException e) {
        object = list.get(0);  
        } catch (IllegalArgumentException e) {
    public void testListGetFieldValue() {
        list = (List<?>) list.get(0);
        } catch (IllegalArgumentException e) {
    public void testSelfReferencingSource() {
            fail("getFieldValue should have failed");  
            ingestDocument.getFieldValue("list.10.field", String.class);
        assertThat(ingestDocument.getSourceAndMetadata().get("_ingest"), equalTo("value"));
    public void testHasFieldEmpty() {
        Map<String, Object> innerMap = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("fizz");  
        assertThat(ingestDocument.getSourceAndMetadata(), not(sameInstance(copy.getSourceAndMetadata())));  
            fail("add field should have failed");
            fail("has field should have failed");
    public void testRemoveFieldValueNotFoundNullParent() {
        assertThat(actualMillis, greaterThanOrEqualTo(before));
        if (randomBoolean()) {
    public void testCopy() {
        @SuppressWarnings("unchecked")
        ingestDocument.setFieldValue("a.b.c.d", "foo");  
        assertThat(list.get(0), equalTo(Integer.MAX_VALUE));
            ingestDocument.setFieldValue("fizz.buzz.new", "bar");
        assertThat(object, instanceOf(Map.class));  
        assertThat(object, instanceOf(String.class));
        assertThat(list.get(0), nullValue());  
        List<Object> list = (List<Object>) object;  
package org.opensearch.ingest;
        } catch (IllegalArgumentException e) {
        assertThat(list.get(2), equalTo("new_value"));  
    public void testAppendFieldValuesConvertIntegerToList() {
            String expectedClassName = randomObject.getClass().getName();
        assertThat(list.size(), equalTo(2));
        assertTrue(ingestDocument.hasField("_index"));  
            assertThat(e.getMessage(), equalTo("[test] is not an integer, cannot be used as an index as part of path [list.test]"));
        List<String> innerList = (List<String>) object;
    public void testSetInvalidSourceField() throws Exception {  
            fail("add field should have failed");  
        assertThat(list.get(0), equalTo(Collections.singletonMap("field", "value")));
    }
        assertThat(list.get(1), equalTo("value"));
            }
        List<?> list = (List<?>) object;  
        assertThat(object, instanceOf(Map.class));
        try {
        for (int i = 0; i < numFields; i++) {
    }  
        ingestDocument.setFieldValue("list.0.field", "new_value");
        @SuppressWarnings("unchecked")  
    }
    }  
        List<Object> innerList = (List<Object>) object;  
            assertThat(e.getMessage(), equalTo("[10] is out of bounds for array with length [2] as part of path [list.10]"));
            ingestDocument.removeField("fizz.1.bar");
    }
        assertFalse(ingestDocument.hasField("list.test"));  
        assertTrue(ingestDocument.hasField("_id"));
        assertThat(e.getMessage(), equalTo("[10] is out of bounds for array with length [2] as part of path [list.10]"));
        assertThat(list.get(0), equalTo(Collections.singletonMap("field", "value")));  
        @SuppressWarnings("unchecked")
            assertThat(e.getMessage(), equalTo("path [_ingest.] is not valid"));  
        }
        assertThat(ingestDocument.getFieldValue("_source.foo", String.class), equalTo("bar"));  
                Collections.unmodifiableMap(ingestMetadata)
        assertThat(innerInnerList.get(1), equalTo("new_value"));
            fail("remove field should have failed");
        } catch (IllegalArgumentException e) {
        List<Object> list = (List<Object>) object;
            fail("get field value should have failed");  
        List<Object> list = (List<Object>) object;
        assertThat(list.size(), equalTo(2));  
import static org.hamcrest.Matchers.not;
        assertThat(innerList.get(1), equalTo("item2"));  
    public void testAppendFieldValueConvertStringToList() {  
        Map<String, Object> map = (Map<String, Object>) object;
        assertThat(list.get(1), equalTo(456));
    public void testHasFieldEmptyPathAfterStrippingOutPrefix() {
    public void testListAppendFieldValue() {  
        final IngestDocument copy = new IngestDocument(ingestDocument);  
        @SuppressWarnings("unchecked")  
        try {  
                e.getMessage(),  
        document.put("string", "A test string \uD83C\uDF89");
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));
        assertThat(ingestDocument.getFieldValue("fizz.foo_null", Object.class), nullValue());
        assertThat(list.get(4), equalTo("item3"));
            ingestDocument.getFieldValue("_source.", Object.class);
            assertThat(e.getMessage(), equalTo("[10] is out of bounds for array with length [2] as part of path [list.10.field]"));  
        assertThat(object, instanceOf(List.class));
        assertThat(object, instanceOf(List.class));
    public void testHasFieldNested() {  
        } catch (IllegalArgumentException e) {  
        List<Object> list = (List<Object>) object;
    }
        List<Object> list = (List<Object>) object;
    public void testSetIngestSourceObject() {
        assertThat(innerList.size(), equalTo(4));  
    public void testSetEmptyPathAfterStrippingOutPrefix() {
        object = map.get("buzz");  
        ingestDocument.appendFieldValue("list2", List.of("foo", "bar", "baz", "foo2"), false);
        Map<String, Object> map = (Map<String, Object>) object;
        assertThat(map.containsKey("buzz"), equalTo(false));  
        @SuppressWarnings("unchecked")  
        assertThat(ingestDocument.getIngestMetadata().get("_source"), equalTo("value"));
            ingestDocument.getFieldValue("", String.class);  
        assertTrue(ingestDocument.hasField("list.1"));
            assertThat(e.getMessage(), equalTo("path [_ingest.] is not valid"));
import java.util.HashMap;
        @SuppressWarnings("unchecked")  
        ingestDocument.appendFieldValue("non_existing_list", "new_value");  
        } catch (IllegalArgumentException e) {
        }
        assertThat(innerList.get(0), equalTo("item1"));
            numFields = randomIntBetween(1, 5);
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("fizz"), equalTo(true));  
        Map<String, Object> otherSourceAndMetadata;
    }
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("list"), equalTo(true));
        }
        assertThat(actualMillis, lessThanOrEqualTo(after));  
        try {  
    public void testRemoveSourceObject() {  
        assertThat(list.get(0), nullValue());
            fail("remove field should have failed");
        } catch (IllegalArgumentException e) {
        assertThat(map.size(), equalTo(3));
        assertThat(innerInnerList.size(), equalTo(4));
            ingestDocument.setFieldValue("list.test.field", "new_value");
        @SuppressWarnings("unchecked")  
        assertFalse(ingestDocument.hasField("not.here"));
        assertThat(list.size(), equalTo(3));
        assertThat(object, instanceOf(List.class));
        assertThat(list.size(), equalTo(2));  
 * this file be licensed under the Apache-2.0 license or a
        object = map.get("buzz");  
            assertThat(ingestDocument.hashCode(), equalTo(otherIngestDocument.hashCode()));
    }
                Collections.unmodifiableMap(sourceAndMetadata),
        document.put("float", 0.1f);
        assertThat(list.size(), equalTo(1));
            assertThat(e.getMessage(), equalTo("path [_source.] is not valid"));  
        } catch (IllegalArgumentException e) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        try {
        object = map.get("foo_null");
    }
        ingestDocument.removeField("_ingest.timestamp");  
        assertThat(ingestDocument.getFieldValue("_source._ingest.timestamp", ZonedDateTime.class), equalTo(BOGUS_TIMESTAMP));
        assertThat(list.size(), equalTo(3));  
        expectThrows(IllegalArgumentException.class, () -> IngestDocument.deepCopyMap(value));
    }
 *  
    }
            assertThat(e.getMessage(), equalTo("cannot set [test] with null parent as part of path [fizz.foo_null.test]"));
        } catch (IllegalArgumentException e) {
        }  
        assertThat(innerInnerList.get(0), equalTo("item1"));  
        }
        object = map.get("list");
        assertThat(list.size(), equalTo(5));
        ZoneId timezone = ZoneId.of("Europe/London");
            ingestDocument.getFieldValue("int", String.class);
        document.put("foo", "bar");  
    public void testRemoveInnerField() {
        ingestDocument.appendFieldValue("list", "new_value");
        IngestDocument copy = new IngestDocument(original);  
            fail("set field value should have failed");
        Object object = ingestDocument.getSourceAndMetadata().get("list");
            assertThat(e.getMessage(), equalTo("field [int] of type [java.lang.Integer] cannot be cast to [java.lang.String]"));
    }
        }
        assertThat(object, instanceOf(List.class));
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("foo"), equalTo(false));
    }
            ingestDocument.removeField("_source.");
            ingestDocument.getFieldValueAsBytes("source_field");
    public void testListGetFieldValueIndexNotNumeric() {  
        try {  
        try {  
import static org.hamcrest.Matchers.sameInstance;
        @SuppressWarnings("unchecked")  
        try {  
        assertThat(innerList.get(2), equalTo("item3"));  
        int numFields = randomIntBetween(1, IngestDocument.Metadata.values().length);
        assertThat(list.size(), equalTo(1));
            ingestDocument.removeField("_source");
        assertThat(list.get(1), nullValue());  
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");  
        document.put("short", (short) 2);
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize));
        assertThat(c.get("d"), instanceOf(String.class));
    public void testListHasFieldIndexNotNumeric() {
        Map<String, Object> document = new HashMap<>();
    private static final ZonedDateTime BOGUS_TIMESTAMP = ZonedDateTime.of(2016, 10, 23, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(object, instanceOf(Map.class));
        assertThat(b.get("c"), instanceOf(Map.class));
                otherSourceAndMetadata.put(randomFrom(IngestDocument.Metadata.values()).getFieldName(), randomAlphaOfLengthBetween(5, 10));
        assertThat(object, instanceOf(List.class));  
    }
    public void testRemoveIngestObject() {  
    public void testRemoveNonExistingField() {  
        assertThat(innerList.get(0), equalTo("item1"));
    }
    public void testHasFieldNotFound() {
            );
        assertThat(list.get(1), equalTo("new_value"));  
import static org.hamcrest.Matchers.equalTo;  
        try {
        } catch (IllegalArgumentException e) {  
        assertThat(innerList.size(), equalTo(2));
 * under the License.  
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
            assertThat(ingestDocument, not(equalTo(otherIngestDocument)));  
            ingestDocument.getFieldValue("foo.foo.bar", String.class);
        assertThat(object, instanceOf(List.class));  
        ingestDocument.removeField("foo");
            }  
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");
            ingestDocument.setFieldValue("list.test", "value");
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;  
 * software distributed under the License is distributed on an
    }
            fail("get field value should have failed");
        assertThat(list.get(0), equalTo("new_value"));  
        @SuppressWarnings("unchecked")
    }  
    public void testAppendFieldValueToNullListElement() {
        ingestDocument.setFieldValue("fizz.new", "bar");
        @SuppressWarnings("unchecked")
        }
            for (int i = 0; i < numFields; i++) {
            assertThat(e.getMessage(), equalTo("path [_source.] is not valid"));  
    }  
        Map<String, Object> ingestMetadata = new HashMap<>();
        assertThat(list.size(), equalTo(2));
        sourceAndMetadata.put("afterClockChange", ZonedDateTime.ofInstant(Instant.ofEpochSecond(1509240600), timezone));  
        document.put("long", Long.MAX_VALUE);
 * compatible open source license.
        Object object = ingestDocument.getSourceAndMetadata().get("list");
    }  
        @SuppressWarnings("unchecked")  
            ingestDocument.setFieldValue("", "bar");  
        assertThat(ingestDocument.hasField("_ingest"), equalTo(true));
        assertThat(list.get(0), equalTo("foo"));
    public void testAppendFieldValueToNull() {
        assertThat(
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));
        try {  
        assertThat(ingestDocument.getSourceAndMetadata().get("a"), instanceOf(Map.class));
    }
            ingestDocument.hasField("_source.");  
        }
        Map<String, Object> sourceAndMetadata = RandomDocumentPicks.randomSource(random());  
        assertThat(list, equalTo(List.of("foo", "bar", "baz")));
    public void testHasFieldNotFoundNullParent() {
    public void testHasFieldNull() {
        try {
import static org.hamcrest.Matchers.both;
    }
        assertThat(object, instanceOf(List.class));  
        }  
            assertThat(
        // test that we don't strip out the _source prefix when _ingest is used
        long actualMillis = timestamp.toInstant().toEpochMilli();  
        } catch (IllegalArgumentException e) {  
            assertThat(e.getMessage(), equalTo("cannot resolve [not_there] from null as part of path [fizz.foo_null.not_there]"));  
        } catch (IllegalArgumentException e) {
        @SuppressWarnings("unchecked")
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");
            assertThat(e.getMessage(), equalTo("[test] is not an integer, cannot be used as an index as part of path [list.test.field]"));
        try {
        list2.add("bar");
        Object object = ingestDocument.getSourceAndMetadata().get("list");
        assertThat(list.get(1), nullValue());
    public void testListRemoveField() {
        try {
        assertThat(list.get(2), equalTo(Collections.singletonMap("item2", "value2")));
        IngestDocument original = new IngestDocument(sourceAndMetadata, new HashMap<>());
        ingestDocument.setFieldValue("_source", "value");
        try {  
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        assertThat(ingestDocument.getFieldValue("_source.int", Integer.class), equalTo(Integer.MAX_VALUE));
        assertThat(object, instanceOf(Map.class));  
        assertThat(object, instanceOf(List.class));
        assertThat(copy.getSourceAndMetadata().get("beforeClockChange"), equalTo(original.getSourceAndMetadata().get("beforeClockChange")));
        assertThat(list.get(0), instanceOf(Map.class));
        }
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("fizz"), equalTo(false));
    }  
    public void testAppendFieldValueToListOfMaps() {
        assertThat(object, instanceOf(List.class));
        assertThat(copy.getSourceAndMetadata(), not(sameInstance(ingestDocument.getSourceAndMetadata())));
    public void testSetFieldValueEmptyName() {
        @SuppressWarnings("unchecked")
    }
        document.put("double", 0.1d);  
        assertTrue(ingestDocument.hasField("_source.fizz"));
        ingestMap.put("timestamp", BOGUS_TIMESTAMP);
        if (randomBoolean()) {
    }  
        assertThat(ingestDocument.getSourceAndMetadata().get("another_field"), equalTo("bar"));
        list.add(null);  
        }
    public void testListGetFieldValueIndexOutOfBounds() {
        ingestDocument.setFieldValue("_ingest", "value");  
        assertThat(list.get(2), equalTo("baz"));
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");  
 * license agreements. See the NOTICE file distributed with
/*  
        Map<String, Object> map = (Map<String, Object>) object;  
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize));
            fail("set field value should have failed");
    public void testSetSourceObject() {  
            );  
        List<Object> list = (List<Object>) object;  
    }  
        ingestDocument.appendFieldValue("list", Arrays.asList("item1", "item2", "item3"));  
    }
import java.time.ZoneOffset;  
        ingestDocument.appendFieldValue("fizz.buzz", Arrays.asList("item1", "item2", "item3"));
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize));  
        assertThat(list.size(), equalTo(2));  
        @SuppressWarnings("unchecked")
        sourceAndMetadata.put("beforeClockChange", ZonedDateTime.ofInstant(Instant.ofEpochSecond(1509237000), timezone));
        Object object = ingestDocument.getSourceAndMetadata().get("list2");  
    @Before  
        object = list.get(0);
    }
        } catch (IllegalArgumentException e) {  
    @SuppressWarnings("unchecked")
        try {  
        List<Object> list = (List<Object>) object;
    public void testAppendFieldValuesToListElement() {  
        ingestDocument.appendFieldValue("fizz.list.0.0", "new_value");
        assertFalse(ingestDocument.hasField("fizz.foo_null.not_there"));  
        }  
            ingestDocument.setFieldValue("_ingest.", "_value");
        long after = System.currentTimeMillis();
            assertThat(e.getMessage(), equalTo("field [does_not_exist] not present as part of path [does_not_exist]"));
            otherIngestMetadata = new HashMap<>();  
        assertThat(object, instanceOf(List.class));
        ingestDocument.appendFieldValue("int", 456);  
        try {
        ingestDocument.appendFieldValue("list.1", "new_value");  
    public void testRemoveEmptyField() {
        assertThat(list.size(), equalTo(4));
    }  
        Map<String, Object> map = (Map<String, Object>) object;  
        Object object = ingestDocument.getSourceAndMetadata().get("non_existing_list");
        try {
        assertThat(list.get(1), equalTo("item1"));  
        try {
            assertThat(ingestDocument, equalTo(otherIngestDocument));  
            assertThat(e.getMessage(), equalTo("path cannot be null nor empty"));  
        assertTrue(ingestDocument.hasField("fizz.buzz"));
        assertThat(object, instanceOf(List.class));  
        try {
        } catch (IllegalArgumentException e) {
        ingestDocument.removeField("_index");
        ingestDocument.removeField("fizz.1");
            assertThat(e.getMessage(), equalTo("path [_ingest.] is not valid"));  
        assertThat(ingestDocument.getSourceAndMetadata().get("new_field"), nullValue());
        assertThat(list.get(0), equalTo(Integer.MAX_VALUE));  
        object = list.get(0);
        @SuppressWarnings("unchecked")
    }
    public void testSetFieldValueNullValue() {
        } catch (IllegalArgumentException e) {
        assertThat(list.get(2), equalTo("item1"));
/*
import static org.hamcrest.Matchers.containsString;
        ingestDocument.appendFieldValue("int", Arrays.asList(456, 789));
        try {  
        if (randomBoolean()) {
        list.add(value);
        @SuppressWarnings("unchecked")
        }  
        Map<String, Object> map = (Map<String, Object>) object;
        document.put("byte", (byte) 1);
        List<Object> list = (List<Object>) object;
        document.put("datetime", ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]"));  
            fail("set field value should have failed");  
            ingestMetadata.put(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLengthBetween(5, 10));
        String value = (String) innerMap.get("new");
        value.put("foo", value);
            fail("remove field should have failed");  
        try {  
        @SuppressWarnings("unchecked")  
            ingestDocument.getFieldValue("_ingest.timestamp", ZonedDateTime.class),
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");
        } catch (IllegalArgumentException e) {  
        assertThat(list.get(1), equalTo(456));  
 * The OpenSearch Contributors require contributions made to  
    public void testListHasFieldIndexOutOfBounds() {
            assertThat(e.getMessage(), equalTo("[test] is not an integer, cannot be used as an index as part of path [list.test.field]"));
    public void testAppendFieldValuesToNonExistingList() {  
        }
            ingestDocument.getFieldValue("_source", Object.class);
            fail("get field value should have failed");
        assertThat(list.get(3), equalTo("foo2"));
 *
    }  
        assertThat(list.get(3), equalTo("item2"));  
        Object object = ingestDocument.getSourceAndMetadata().get("fizz");  
        Map<String, Object> map = (Map<String, Object>) object;
        assertThat(list.size(), equalTo(1));
        object = map.get("list");
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("_ingest"), equalTo(false));  
    }
        assertThat(list.get(1), equalTo("bar"));  
        } catch (IllegalArgumentException e) {
        assertThat(ingestDocument.getIngestMetadata().get("timestamp"), equalTo("timestamp"));
    }  
        assertThat(copy.getSourceAndMetadata().get("afterClockChange"), equalTo(original.getSourceAndMetadata().get("afterClockChange")));  
        innerObject.put("1", "bar");
public class IngestDocumentTests extends OpenSearchTestCase {  
    }  
    public void testNestedSetFieldValue() {
        innerInnerList.add("item1");  
    public void testListAppendFieldValues() {
        assertFalse(ingestDocument.hasField("list.10"));
        assertThat(map.size(), equalTo(0));
            numFields = randomIntBetween(1, IngestDocument.Metadata.values().length);  
    }
        }
        object = list.get(0);  
            assertThat(e.getMessage(), equalTo("path [_source.] is not valid"));
                containsString("field [source_field] of unknown type [" + expectedClassName + "], must be string or byte array")
        assertThat(list.get(1), equalTo("new_value"));
        try {
        assertThat(copy, equalTo(ingestDocument));
        e = expectThrows(IllegalArgumentException.class, () -> ingestDocument.hasField("list.10", true));
        Object object = ingestDocument.getSourceAndMetadata().get("list");
            assertThat(
    public void testListAppendFieldValueWithoutDuplicate() {
        object = map.get("list");  
        }
        } catch (IllegalArgumentException e) {
        assertThat(a.get("b"), instanceOf(Map.class));  
    public void testGetIngestObject() {
        ingestDocument.appendFieldValue("list.0", Collections.singletonMap("item2", "value2"));
        assertThat(list.get(3), equalTo("item3"));
        assertThat(object, instanceOf(List.class));
        ingestDocument.setFieldValue("list.1", "value");  
        }  
import java.util.Arrays;  
                e.getMessage(),  
        try {
                e.getMessage(),
    }  
    }  
        assertThat(list.size(), equalTo(2));  
        assertThat(ingestDocument.getIngestMetadata().get("new_field"), equalTo("new_value"));
    }
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize));  
        @SuppressWarnings("unchecked")
    }
        assertThat(map.size(), equalTo(0));
        try {
        document.put("source_field", randomObject);  
        Map<String, Object> sourceAndMetadata = new HashMap<>();
    @SuppressWarnings("unchecked")
        assertThat(list.size(), equalTo(3));
        assertThat(list.get(1), equalTo(Collections.singletonMap("field", "value")));
        assertThat(ingestDocument.getSourceAndMetadata().get("fizz"), instanceOf(Map.class));
        ingestDocument.setFieldValue("new_field", null);
    public void testListAppendFieldValueWithDuplicate() {  
        List<String> innerInnerList = new ArrayList<>();
        Map<String, Object> document = new HashMap<>();
            fail("remove field should have failed");  
            );
        numFields = randomIntBetween(1, 5);  
    }
        ingestDocument.removeField("fizz.buzz");  
    public void setTestIngestDocument() {
            ingestDocument.setFieldValue("_source.", "value");  
        ingestDocument.appendFieldValue("fizz.list.0", "item2");
        ingestDocument.removeField("fizz.foo_null");
        assertThat(object, instanceOf(List.class));
    public void testNestedHasFieldTypeMismatch() {  
    }  
    public void testSetFieldValueNullName() {  
        }
        }
        assertThat(object, instanceOf(Map.class));
    }
    }
        assertThat(list.get(1), equalTo("item2"));
            ingestDocument.removeField("list.test");  
            ingestDocument.getFieldValue("_ingest.", Object.class);  
    public void testGetFieldValueNotFoundNullParent() {
        ingestDocument.setFieldValue("new_field", "foo");  
        );
        assertThat(ingestDocument.getFieldValue("_index", String.class), equalTo("index"));
            fail("get field value should have failed");
 * specific language governing permissions and limitations
        assertTrue(ingestDocument.hasField("list.1", true));
        assertTrue(ingestDocument.hasField("fizz"));
        assertThat(timestamp, notNullValue());
    }  
        assertThat(object, instanceOf(List.class));
        }
    private IngestDocument ingestDocument;  
        object = innerList.get(0);
        assertThat(ingestDocument.getFieldValue("foo", String.class), equalTo("bar"));
        IngestDocument otherIngestDocument = new IngestDocument(otherSourceAndMetadata, otherIngestMetadata);
        ingestDocument.appendFieldValue("list2", "foo", false);
        assertThat(ingestDocument.getSourceAndMetadata().size(), equalTo(initialSourceAndMetadataSize));
            fail("has field should have failed");
        ingestDocument.appendFieldValue("list", Collections.singletonMap("item2", "value2"));  
        Map<String, Object> map = (Map<String, Object>) object;
    public void testAppendFieldValueConvertMapToList() {
