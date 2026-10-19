        // Convert to Java Map
        assertTrue("Map should contain the key", map.containsKey("key"));
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setListValue(listValue).build()).build();
        // Create an ObjectMap with an unset value type  
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setInt32(value).build()).build();  
            .addValue(ObjectMap.Value.newBuilder().setString("value1").build())  
            .build();  
        // Verify the result
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);
        assertEquals("Value should be an int64", value, map.get("key"));  
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);  
        assertTrue("Map should contain the key", map.containsKey("key"));
    public void testFromProtoWithStringValue() {
    public void testFromProtoWithInvalidValueTypeThrowsException() {
    public void testFromProtoWithNestedObjectMap() {
    public void testFromProtoWithListValue() {  
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setDouble(value).build()).build();  
        // Create an ObjectMap with an int32 value
        assertNotNull("Map should not be null", map);
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);
        assertNotNull("Map should not be null", map);  
        // Attempt to convert to Java Map, should throw UnsupportedOperationException
 * SPDX-License-Identifier: Apache-2.0
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setObjectMap(nestedMap).build()).build();
package org.opensearch.transport.grpc.proto.request.common;
        ObjectMap nestedMap = ObjectMap.newBuilder()
        // Create an ObjectMap with a list value
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setDouble(value).build()).build();  
        assertEquals("Map should have 1 entry", 1, map.size());
        // Create an ObjectMap with a null value
        assertEquals("Map should have 1 entry", 1, map.size());
        assertTrue("Map should contain the key", map.containsKey("key"));
import java.util.List;  
    public void testFromProtoWithFloatValue() {  
    }
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);  
        // Create a nested ObjectMap  
    public void testFromProtoWithInt64Value() {  
        assertEquals("Value should be an int32", value, map.get("key"));  
    }
        Map<?, ?> nested = (Map<?, ?>) map.get("key");
import org.opensearch.test.OpenSearchTestCase;
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setBool(true).build()).build();  
        double value = 123.456;
        assertEquals("Map should have 1 entry", 1, map.size());
        expectThrows(UnsupportedOperationException.class, () -> ObjectMapProtoUtils.fromProto(objectMap));
    public void testFromProtoWithBooleanValue() {
        // Convert to Java Map
        assertEquals("Map should have 1 entry", 1, map.size());  
        // Convert to Java Map  
        assertEquals("Value should be a float", value, (double) map.get("key"), 1e-6);  
    public void testFromProtoWithDoubleValue() {  
        // Create an ObjectMap with a string value  
}  
        assertEquals("Map should have 1 entry", 1, map.size());
 * compatible open source license.
        int value = 123;
        // Create an ObjectMap with an int64 value
        assertNotNull("Map should not be null", map);  
            .putFields("nestedKey", ObjectMap.Value.newBuilder().setString("nestedValue").build())
        assertEquals("Map should have 1 entry", 1, map.size());
        assertNotNull("Map should not be null", map);
        assertEquals("List should have 3 elements", 3, list.size());
        // Convert to Java Map
            .build();  
        assertTrue("Map should be empty", map.isEmpty());
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);  
        ObjectMap objectMap = ObjectMap.newBuilder()  
    public void testFromProtoWithNullValueThrowsException() {
        assertEquals("Map should have 1 entry", 1, map.size());  
        assertEquals("Value should be a boolean", true, map.get("key"));  
        assertEquals("Value should be a string", "value", map.get("key"));
    }
        // Convert to Java Map
        // Create an ObjectMap with a boolean value
    }  
            .build();
        // Verify the result
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);  
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setString("value").build()).build();
        assertTrue("Map should contain the key", map.containsKey("key"));
 */  
public class ObjectMapProtoUtilsTests extends OpenSearchTestCase {  
            .putFields("key", ObjectMap.Value.newBuilder().setNullValue(NullValue.NULL_VALUE_NULL).build())
        assertNotNull("Map should not be null", map);
        // Attempt to convert to Java Map, should throw IllegalArgumentException  
 * The OpenSearch Contributors require contributions made to  
        // Verify the result  
        assertTrue("Value should be a List", map.get("key") instanceof List);
        List<?> list = (List<?>) map.get("key");
        float value = 123.456f;
        // Create an ObjectMap with a double value
        // Verify the result
        // Verify the result
 * this file be licensed under the Apache-2.0 license or a
        expectThrows(IllegalArgumentException.class, () -> ObjectMapProtoUtils.fromProto(objectMap));
    }
        assertEquals("First element should be a string", "value1", list.get(0));  
        ObjectMap objectMap = ObjectMap.newBuilder().build();
/*  
        // Verify the result
        assertEquals("Second element should be an int", 123, list.get(1));
    }  
        assertEquals("Nested map should have 1 entry", 1, nested.size());
        // Convert to Java Map
    }
        // Convert to Java Map
        assertTrue("Nested map should contain the key", nested.containsKey("nestedKey"));  
        assertEquals("Nested value should be a string", "nestedValue", nested.get("nestedKey"));
        assertNotNull("Map should not be null", map);  
        assertEquals("Map should have 1 entry", 1, map.size());
        // Convert to Java Map  
        assertNotNull("Map should not be null", map);  
        assertEquals("Third element should be a boolean", true, list.get(2));
        assertTrue("Map should contain the key", map.containsKey("key"));
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);
    public void testFromProtoWithInt32Value() {  
    public void testFromProtoWithEmptyMap() {
    }  
    }
            .addValue(ObjectMap.Value.newBuilder().setBool(true).build())
        // Verify the result
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);
        Map<String, Object> map = ObjectMapProtoUtils.fromProto(objectMap);  
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().build()).build();
    }
import org.opensearch.protobufs.ObjectMap.ListValue;  
        assertTrue("Map should contain the key", map.containsKey("key"));
    }
import java.util.Map;
import org.opensearch.protobufs.NullValue;
        ListValue listValue = ListValue.newBuilder()
        assertEquals("Value should be a double", value, map.get("key"));  
        assertTrue("Value should be a Map", map.get("key") instanceof Map);
        assertNotNull("Map should not be null", map);  
        // Create an empty ObjectMap  
import org.opensearch.protobufs.ObjectMap;
        // Create an ObjectMap with a float value
            .addValue(ObjectMap.Value.newBuilder().setInt32(123).build())
        assertTrue("Map should contain the key", map.containsKey("key"));
        // Verify the result  
        long value = 123456789L;
        assertTrue("Map should contain the key", map.containsKey("key"));  
        ObjectMap objectMap = ObjectMap.newBuilder().putFields("key", ObjectMap.Value.newBuilder().setInt64(value).build()).build();  
        // Verify the result
 *
        assertNotNull("Map should not be null", map);
        // Convert to Java Map
