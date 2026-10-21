        assertNotNull("Map should not be null", map);
 */
        assertEquals("Value should be a double", value, map.get("key"));
        Map<?, ?> nested = (Map<?, ?>) map.get("key");
        // Create an ObjectMap with a null value
    }
        assertTrue("Map should contain the key", map.containsKey("key"));
    }
        assertTrue("Value should be a Map", map.get("key") instanceof Map);
 * The OpenSearch Contributors require contributions made to
        ObjectMap objectMap = ObjectMap.newBuilder()
        // Convert to Java Map
        // Verify the result
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);
        assertTrue("Map should contain the key", map.containsKey("key"));
        assertEquals("Map should have 1 entry", 1, map.size());
        assertTrue("Map should contain the key", map.containsKey("key"));
        // Create an ObjectMap with a double value
        assertEquals("Nested value should be a string", "nestedValue", nested.get("nestedKey"));
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setBool(true).build()).build();
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull("Map should not be null", map);
        assertEquals("Value should be a string", "value", map.get("key"));
    }
        assertEquals("List should have 3 elements", 3, list.size());
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setInt64(value).build()).build();
        ObjectMap objectMap = ObjectMap.newBuilder().build();
        // Verify the result
        // Convert to Java Map
        float value = 123.456f;
            .build();
        // Attempt to convert to Java Map, should throw UnsupportedOperationException
        assertEquals("Value should be an int32", value, map.get("key"));
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);
import java.util.List;
        List<?> list = (List<?>) map.get("key");
        // Create an ObjectMap with an unset value type
        // Create an empty ObjectMap
import org.opensearch.protobufs.ObjectMap.ListValue;
    }
        assertEquals("Value should be a float", value, (double) map.get("key"), 1e-6);
        expectThrows(UnsupportedOperationException.class, () -> ObjectMapProtoUtils.fromProto(objectMap));
        // Convert to Java Map
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().build()).build();
package org.opensearch.transport.grpc.proto.request.common;
        int value = 123;
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);
 * compatible open source license.
        // Create an ObjectMap with a boolean value
        // Convert to Java Map
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);
        assertEquals("Value should be a boolean", true, map.get("key"));
        assertTrue("Map should contain the key", map.containsKey("key"));
        assertNotNull("Map should not be null", map);
        // Create an ObjectMap with an int64 value
        // Verify the result
    }
            .addValue(ObjectMap.Value.newBuilder().setString("value1").build())
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setListValue(listValue).build()).build();
    public void testFromProtoWithListValue() {
        assertEquals("Map should have 1 entry", 1, map.size());
        // Verify the result
        assertEquals("Map should have 1 entry", 1, map.size());
        // Create an ObjectMap with an int32 value
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);
        // Verify the result
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setString("value").build()).build();
        assertEquals("Map should have 1 entry", 1, map.size());
        // Convert to Java Map
        assertTrue("Nested map should contain the key", nested.containsKey("nestedKey"));
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setObjectMap(nestedMap).build()).build();
    public void testFromProtoWithBooleanValue() {
    public void testFromProtoWithStringValue() {
            .putFields("nestedKey", ObjectMap.Value.newBuilder().setString("nestedValue").build())
        assertNotNull("Map should not be null", map);
    public void testFromProtoWithNestedObjectMap() {
        expectThrows(IllegalArgumentException.class, () -> ObjectMapProtoUtils.fromProto(objectMap));
    public void testFromProtoWithEmptyMap() {
        // Create an ObjectMap with a string value
    }
        assertEquals("Map should have 1 entry", 1, map.size());
        ListValue listValue = ListValue.newBuilder()
        assertTrue("Map should contain the key", map.containsKey("key"));
        assertNotNull("Map should not be null", map);
            .addValue(ObjectMap.Value.newBuilder().setInt32(123).build())
            .putFields("key", ObjectMap.Value.newBuilder().setNullValue(NullValue.NULL_VALUE_NULL).build())
        assertTrue("Map should contain the key", map.containsKey("key"));
            .build();
        // Create an ObjectMap with a list value
        assertEquals("Map should have 1 entry", 1, map.size());
    public void testFromProtoWithNullValueThrowsException() {
    }
        assertEquals("Nested map should have 1 entry", 1, nested.size());
        assertNotNull("Map should not be null", map);
    public void testFromProtoWithInvalidValueTypeThrowsException() {
        // Verify the result
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);
        // Convert to Java Map
 *
        assertTrue("Map should contain the key", map.containsKey("key"));
}
    }
        assertEquals("Third element should be a boolean", true, list.get(2));
            .build();
        // Verify the result
        assertEquals("Second element should be an int", 123, list.get(1));
    public void testFromProtoWithInt32Value() {
        assertNotNull("Map should not be null", map);
        assertEquals("Map should have 1 entry", 1, map.size());
        assertEquals("Map should have 1 entry", 1, map.size());
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setDouble(value).build()).build();
        ObjectMap nestedMap = ObjectMap.newBuilder()
        assertTrue("Map should be empty", map.isEmpty());
        // Verify the result
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);
        // Convert to Java Map
        assertTrue("Map should contain the key", map.containsKey("key"));
    }
import org.opensearch.test.OpenSearchTestCase;
    public void testFromProtoWithDoubleValue() {
    public void testFromProtoWithFloatValue() {
import org.opensearch.protobufs.NullValue;
        double value = 123.456;
        long value = 123456789L;
        // Verify the result
        // Attempt to convert to Java Map, should throw IllegalArgumentException
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setInt32(value).build()).build();
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setDouble(value).build()).build();
    }
        // Create an ObjectMap with a float value
        assertEquals("Value should be an int64", value, map.get("key"));
    public void testFromProtoWithInt64Value() {
        assertNotNull("Map should not be null", map);
/*
        // Convert to Java Map
        assertNotNull("Map should not be null", map);
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
public class ObjectMapProtoUtilsTests extends OpenSearchTestCase {
        assertTrue("Value should be a List", map.get("key") instanceof List);
        // Convert to Java Map
import org.opensearch.protobufs.ObjectMap;
        // Create a nested ObjectMap
    }
            .addValue(ObjectMap.Value.newBuilder().setBool(true).build())
        assertEquals("First element should be a string", "value1", list.get(0));
