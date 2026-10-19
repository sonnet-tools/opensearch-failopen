        }
        Float floatValue = 2.71828f;
        Long longValue = 9223372036854775807L;  
        // Convert Double to Protocol Buffer
        // Convert String to Protocol Buffer
        assertNotNull("Value should not be null", value);  
    private static class UnsupportedType {
        assertNotNull("Value should not be null", value);
        assertTrue("Second element should be int32", value.getListValue().getValue(1).hasInt32());  
        // Verify the conversion  
    /*
        // Verify map entries
        String stringValue = "test string";  
        assertTrue("First element should be string", value.getListValue().getValue(0).hasString());  
public class ObjectMapProtoUtilsTests extends OpenSearchTestCase {
        Double doubleValue = 3.14159;
        VALUE_1,
        assertEquals("List should have correct size", 3, value.getListValue().getValueCount());  
            2,
        Map<String, Object> outerMap = new HashMap<>();
    /*
        // Verify the conversion
    }
            () -> ObjectMapProtoUtils.toProto(unsupportedValue)
import org.opensearch.protobufs.NullValue;
        // Attempt to convert to Protocol Buffer, should throw IllegalArgumentException
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(
        List<Object> innerList = Arrays.asList(1, 2, 3);
        assertTrue("Should have string value", value.hasString());
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(mapValue);
            "Nested map value should match",
        // Create a nested structure
    }  
        assertTrue("Exception message should contain object's toString", exception.getMessage().contains(unsupportedValue.toString()));
    public void testToProtoWithBoolean() {  
        assertTrue("String entry should be string", value.getObjectMap().getFieldsOrThrow("string").hasStringValue());  
        mapValue.put("string", "value");
        assertEquals(  
        Integer intValue = 42;
        assertEquals("Map should be empty", 0, value.getObjectMap().getFieldsCount());
        // Convert empty Map to Protocol Buffer  
            "Nested list second element should match",  
        assertTrue("Should have int32 value", value.hasInt32());  
        assertEquals("Int64 value should match", longValue.longValue(), value.getInt64());  
        assertTrue("Bool entry should be bool", value.getObjectMap().getFieldsOrThrow("bool").hasBoolValue());
    public void testToProtoWithUnsupportedType() {  
    }
/*  
    }  
    public void testToProtoWithString() {
        assertNotNull("Value should not be null", value);
            1,  
        // Verify the conversion
        @Override
package org.opensearch.transport.grpc.proto.response.common;
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(enumValue);
import org.opensearch.protobufs.ObjectMap;
        assertEquals("Int32 value should match", intValue.intValue(), value.getInt32());
        // Verify the conversion
    public void testToProtoWithEnum() {
 * The OpenSearch Contributors require contributions made to  
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(null);  
}
    public void testToProtoWithEmptyList() {
import java.util.List;  
        assertEquals("String value should match", stringValue, value.getString());  
    public void testToProtoWithLong() {
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(mapValue);  
    private enum TestEnum {  
            IllegalArgumentException.class,  
        // Convert Long to Protocol Buffer
        assertTrue("Should have list value", value.hasListValue());
        // Verify nested list
        assertTrue("Nested map key should exist", value.getObjectMap().getFieldsOrThrow("map").getObjectMap().containsFields("key"));  
            "Nested list should have correct size",
        // Verify the exception message contains the object's toString
        assertTrue("Nested list should exist", value.getObjectMap().containsFields("list"));
    }
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(longValue);
        outerMap.put("list", innerList);  
        // Verify the conversion  
        assertEquals("Third element should match", true, value.getListValue().getValue(2).getBool());
            value.getObjectMap().getFieldsOrThrow("list").getListValue().getValue(0).getInt32()  
            1,
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(listValue);
        assertEquals(
    }
        // Verify the conversion
    }
        assertNotNull("Value should not be null", value);
        assertNotNull("Value should not be null", value);
        // Verify the conversion
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(doubleValue);  
    }  
        assertTrue("Nested list should be list value", value.getObjectMap().getFieldsOrThrow("list").hasListValue());  
    */
        assertTrue("Should have object map", value.hasObjectMap());  
        assertEquals(
        assertEquals("Float value should match", floatValue, value.getFloat(), 0.0f);
            3,  
        // Convert Enum to Protocol Buffer  
        mapValue.put("bool", true);
        );
        );  
        mapValue.put("int", 42);  
    public void testToProtoWithInteger() {
        IllegalArgumentException exception = expectThrows(
            value.getObjectMap().getFieldsOrThrow("map").getObjectMap().getFieldsOrThrow("key").getStringValue()
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(intValue);
        assertEquals("String entry should match", "value", value.getObjectMap().getFieldsOrThrow("string").getStringValue());
    // Helper class for testing unsupported types  
        // Convert Float to Protocol Buffer  
 *
    public void testToProtoWithMap() {
        // Create an unsupported type (a custom class)
    */
        assertNotNull("Value should not be null", value);
            "Nested map should have correct size",
        // Verify the conversion  
        TestEnum enumValue = TestEnum.VALUE_2;
        assertTrue("Should have string value", value.hasString());  
        assertTrue("Bool entry should exist", value.getObjectMap().containsFields("bool"));
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull("Value should not be null", value);  
    }  
    }
        assertEquals(
        assertNotNull("Value should not be null", value);  
        assertEquals("Map should have correct size", 3, value.getObjectMap().getFieldsCount());
        List<Object> listValue = Arrays.asList();  
        assertEquals(
    }
        // Verify the conversion
        assertEquals("Second element should match", 42, value.getListValue().getValue(1).getInt32());
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(stringValue);
        assertTrue("Should have int64 value", value.hasInt64());
        assertEquals("Map should have correct size", 2, value.getObjectMap().getFieldsCount());
    public void testToProtoWithEmptyMap() {
        assertEquals("List should be empty", 0, value.getListValue().getValueCount());  
        // Convert Map to Protocol Buffer  
        // Verify list elements
        // Convert empty List to Protocol Buffer
    }
        VALUE_2,
            return "UnsupportedType";
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(outerMap);  
        assertTrue("Should have null value", value.hasNullValue());
        assertTrue("String entry should exist", value.getObjectMap().containsFields("string"));
        assertEquals("Bool value should match", boolValue, value.getBool());
 */  
            value.getObjectMap().getFieldsOrThrow("map").getObjectMap().getFieldsCount()
import java.util.Arrays;
        assertTrue("Third element should be bool", value.getListValue().getValue(2).hasBool());  
        VALUE_3  
        // Convert Integer to Protocol Buffer  
        );
        assertTrue("Int entry should exist", value.getObjectMap().containsFields("int"));  
 * this file be licensed under the Apache-2.0 license or a
            value.getObjectMap().getFieldsOrThrow("list").getListValue().getValue(1).getInt32()
            "Nested list first element should match",
        // Convert Boolean to Protocol Buffer
        Map<String, Object> innerMap = new HashMap<>();
        );
        );
 * compatible open source license.
        // Verify the conversion
    /*
        assertTrue("Nested map should exist", value.getObjectMap().containsFields("map"));
        assertEquals("Null value should be NULL_VALUE_NULL", NullValue.NULL_VALUE_NULL, value.getNullValue());
        assertNotNull("Value should not be null", value);
            value.getObjectMap().getFieldsOrThrow("list").getListValue().getValue(2).getInt32()
        assertTrue("Should have float value", value.hasFloat());  
        assertEquals("Int entry should match", 42, value.getObjectMap().getFieldsOrThrow("int").getInt32());
        // Convert List to Protocol Buffer
        Map<String, Object> mapValue = new HashMap<>();
        // Verify the conversion
    // TODO: ObjectMap functionality changed in protobufs 0.8.0  
        assertEquals("Bool entry should match", true, value.getObjectMap().getFieldsOrThrow("bool").getBoolValue());  
            "Nested list third element should match",
        assertTrue("Should have double value", value.hasDouble());
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(boolValue);  
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(listValue);
    }
        public String toString() {  
        List<Object> listValue = Arrays.asList("string", 42, true);  
        assertNotNull("Value should not be null", value);
        // Verify the conversion  
    }
    */  
            value.getObjectMap().getFieldsOrThrow("list").getListValue().getValueCount()
        innerMap.put("key", "value");  
        );
        assertTrue("Int entry should be int32", value.getObjectMap().getFieldsOrThrow("int").hasInt32());
        // Verify nested map
        );
    public void testToProtoWithFloat() {
        assertNotNull("Value should not be null", value);
            "value",  
            3,  
        assertNotNull("Value should not be null", value);  
        assertTrue("Should have bool value", value.hasBool());
    public void testToProtoWithNull() {
    public void testToProtoWithNestedStructures() {  
        // Convert null to Protocol Buffer
        assertEquals("Double value should match", doubleValue, value.getDouble(), 0.0);
        assertEquals("First element should match", "string", value.getListValue().getValue(0).getString());
        assertNotNull("Value should not be null", value);  
        outerMap.put("map", innerMap);
        // Convert to Protocol Buffer
        // Verify the conversion
        assertTrue("Should have object map", value.hasObjectMap());
        assertEquals("String value should match enum name", enumValue.toString(), value.getString());
        ObjectMap.Value value = ObjectMapProtoUtils.toProto(floatValue);
    public void testToProtoWithDouble() {  
        Map<String, Object> mapValue = new HashMap<>();
        UnsupportedType unsupportedValue = new UnsupportedType();
    // Helper enum for testing
    public void testToProtoWithList() {
    }  
    }  
        assertTrue("Nested map should be object map", value.getObjectMap().getFieldsOrThrow("map").hasObjectMap());  
        assertTrue("Should have list value", value.hasListValue());
        Boolean boolValue = true;
        assertTrue("Should have object map", value.hasObjectMap());
