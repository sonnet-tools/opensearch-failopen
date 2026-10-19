    }
        IllegalArgumentException exception1 = expectThrows(IllegalArgumentException.class, () -> FieldValueProtoUtils.toProto(tooLarge));
        assertTrue("Result should be Long", result instanceof Long);
        Long longValue = 9223372036854775807L; // Max long value  
            "Exception message should mention cannot convert map",
        assertNotNull("FieldValue should not be null", fieldValue);
        assertEquals("Outer string field should match", "outer value", outerObjectMap.getFieldsOrThrow("outer_string").getStringValue());
        BigInteger tooLarge = new BigInteger("18446744073709551616"); // 2^64 (exceeds max unsigned long)  
 *
        // Check outer string field
import org.opensearch.protobufs.FieldValue;
        // Call the method under test, should throw IllegalArgumentException  
            BigInteger.valueOf(Long.MAX_VALUE) };
 */  
}  
    }  
        IllegalArgumentException exception = expectThrows(
    public void testFromProtoWithUint64Value() {  
        assertTrue("Bool value should be true", trueFieldValue.getBool());  
        FieldValue fieldValue = FieldValueProtoUtils.toProto(doubleValue);
        map.put("string", "value");
        );
import java.math.BigInteger;
        outerMap.put("outer_string", "outer value");  
    public void testToProtoWithDouble() {  
    // This test needs to be rewritten for the simplified FieldValue structure
    public void testToProtoWithEnum() {
        org.opensearch.protobufs.ObjectMap nestedObjectMap = outerObjectMap.getFieldsOrThrow("nested_map").getObjectMap();
            new BigInteger("9223372036854775807"), // Max signed long  
        BigInteger bigIntValue = new BigInteger("2147395412");
        FieldValue fieldValue = FieldValueProtoUtils.toProto(longValue);
        assertTrue("FieldValue should have general number", fieldValue.hasGeneralNumber());
        assertEquals("Uint64 value should match", 2147395412L, fieldValue.getGeneralNumber().getUint64Value());
    public void testToProtoWithInteger() {
        org.opensearch.protobufs.ObjectMap outerObjectMap = fieldValue.getObjectMap();
        assertNotNull("FieldValue should not be null", fieldValue);  
    }
        assertNotNull("FieldValue should not be null", fieldValue);
        assertEquals("Nested string field should match", "nested value", nestedObjectMap.getFieldsOrThrow("nested_string").getStringValue());
        Map<String, Object> nestedMap = new HashMap<>();
        assertTrue("Result should be BigInteger when value exceeds Long.MAX_VALUE", result instanceof BigInteger);
        assertNotNull("FieldValue should not be null", fieldValue);  
        FieldValue fieldValue = FieldValue.newBuilder().setGeneralNumber(generalNumber).build();
        assertEquals("Null value should match proto enum", NullValue.NULL_VALUE_NULL, fieldValue.getNullValue());
    public void testToProtoWithBoolean() {
        assertNotNull("Result should not be null", result);  
        // Use a test enum  
        BigInteger bigIntValue = new BigInteger("18446744073709551615"); // Max unsigned long
            () -> FieldValueProtoUtils.toProto(unsupportedObject)  
        FieldValue fieldValue = FieldValueProtoUtils.toProto(intValue);  
    }  
    public void testRoundTripBigInteger() {
    }
        );  
        assertEquals("Uint64 value should match max unsigned long", expectedValue, result);  
 * The OpenSearch Contributors require contributions made to  
    }
        Double doubleValue = 3.14159;
        FieldValue fieldValue = FieldValueProtoUtils.toProto(outerMap);  
        Object result = FieldValueProtoUtils.fromProto(fieldValue);
        assertEquals("Integer value should match", 42, fieldValue.getGeneralNumber().getInt32Value());
        assertEquals("Outer object map should have 2 fields", 2, outerObjectMap.getFieldsCount());  
            "Exception should mention out of range",  
        // Using a value that fits in Java long (max long is 9223372036854775807L)
        assertTrue("Nested integer field should have int32 value", nestedObjectMap.getFieldsOrThrow("nested_integer").hasInt32());  
            FieldValue fieldValue = FieldValueProtoUtils.toProto(original);
        // Convert from Protocol Buffer  
        // Test with false
        // Check nested integer field
    public void testToProtoWithMap() {  
        assertTrue("GeneralNumber should have uint64 value", fieldValue.getGeneralNumber().hasUint64Value());
        assertTrue(  
        assertTrue("Nested integer field should exist", nestedObjectMap.containsFields("nested_integer"));
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.test.OpenSearchTestCase;  
        Map<String, Object> outerMap = new HashMap<>();
        // (e.g., max uint64 = 2^64-1 appears as -1L in two's complement)  
import org.opensearch.protobufs.NullValue;
        // Create an object of an unsupported type  
        assertTrue(
        outerMap.put("nested_map", nestedMap);
        assertTrue(fieldValue.getGeneralNumber().hasDoubleValue());  
        assertNotNull("FieldValue should not be null", fieldValue);
        // Test with true  
        );
    }  
        assertEquals("Long value should match", 9223372036854775807L, fieldValue.getGeneralNumber().getInt64Value());  
        assertEquals("Uint64 value should match", -1L, fieldValue.getGeneralNumber().getUint64Value()); // -1L is max unsigned
        assertTrue("FieldValue should have general number", fieldValue.hasGeneralNumber());  
            assertEquals("Value should match for " + original, original.longValue(), ((Long) result).longValue());  
    }  
        assertTrue("Nested string field should exist", nestedObjectMap.containsFields("nested_string"));  
        assertTrue("Nested map field should exist", outerObjectMap.containsFields("nested_map"));
        assertTrue("Outer string field should have string value", outerObjectMap.getFieldsOrThrow("outer_string").hasStringValue());
    }
        // Verify the conversion  
        assertTrue("FieldValue should have general number", fieldValue.hasGeneralNumber());  
        FieldValue fieldValue = FieldValueProtoUtils.toProto(enumValue);
        FieldValue fieldValue = FieldValueProtoUtils.toProto(floatValue);  
        assertNotNull("Result should not be null", result);
    public void testToProtoWithNestedMap() {  
        assertEquals("Uint64 value should match", uint64Value, result);  
        FieldValue falseFieldValue = FieldValueProtoUtils.toProto(falseValue);
        Object result = FieldValueProtoUtils.fromProto(fieldValue);  
            Object result = FieldValueProtoUtils.fromProto(fieldValue);
    }
/*  
    public void testToProtoWithLong() {
        // The expected behavior is to return BigInteger for values that don't fit in signed long
            new BigInteger("0"),
        for (BigInteger original : testValues) {  
        Boolean trueValue = true;
        assertTrue("GeneralNumber should have uint64 value", fieldValue.getGeneralNumber().hasUint64Value());  
            assertTrue("Result should be Long for " + original, result instanceof Long);
        FieldValue fieldValue = FieldValueProtoUtils.toProto(null);  
        // Convert from Protocol Buffer
        // Test round-trip conversion for BigInteger values
    }
        // Test with a BigInteger that has a value within signed long range  
    }
    public void testToProtoWithBigInteger() {  
        BigInteger[] testValues = {  
        // Test with a BigInteger that represents an unsigned_long value
        assertEquals("String value should match enum toString", "TEST_VALUE", fieldValue.getString());  
        IllegalArgumentException exception2 = expectThrows(IllegalArgumentException.class, () -> FieldValueProtoUtils.toProto(negative));
        String stringValue = "test string";  
package org.opensearch.transport.grpc.proto.response.common;
            IllegalArgumentException.class,
        assertEquals("Nested object map should have 2 fields", 2, nestedObjectMap.getFieldsCount());  
        Object unsupportedObject = new StringBuilder("unsupported");
        assertNotNull("FieldValue should not be null", fieldValue);
        }
        // Create a FieldValue with UINT64_VALUE that exceeds Long.MAX_VALUE
        map.put("boolean", true);
        assertEquals("Double value should match", 3.14159, fieldValue.getGeneralNumber().getDoubleValue(), 0.001);
        assertTrue("Outer string field should exist", outerObjectMap.containsFields("outer_string"));  
    private enum TestEnum {  
        assertNotNull("FieldValue should not be null", fieldValue);
        Float floatValue = 2.71828f;
            "Exception should mention out of range",  
        nestedMap.put("nested_string", "nested value");
    }
        BigInteger negative = new BigInteger("-1");
    public void testToProtoWithUnsupportedType() {
        org.opensearch.protobufs.GeneralNumber generalNumber = org.opensearch.protobufs.GeneralNumber.newBuilder()  
        FieldValue trueFieldValue = FieldValueProtoUtils.toProto(trueValue);
            new BigInteger("2147395412"),
        assertTrue("Nested map field should have object map", outerObjectMap.getFieldsOrThrow("nested_map").hasObjectMap());  
        assertEquals("Float value should match", 2.71828f, fieldValue.getGeneralNumber().getFloatValue(), 0.0f);
        assertNotNull("FieldValue should not be null", trueFieldValue);
        assertTrue("FieldValue should have bool value", falseFieldValue.hasBool());
 * SPDX-License-Identifier: Apache-2.0
        FieldValue fieldValue = FieldValueProtoUtils.toProto(bigIntValue);
        assertTrue("FieldValue should have null value", fieldValue.hasNullValue());  
            exception2.getMessage().contains("out of range") || exception2.getMessage().contains("unsigned long")
        org.opensearch.protobufs.GeneralNumber generalNumber = org.opensearch.protobufs.GeneralNumber.newBuilder()
        assertNotNull("FieldValue should not be null", fieldValue);
        long uint64ValueExceedingLongMax = -1L; // This represents 2^64-1 (max unsigned long)
        Map<String, Object> map = new HashMap<>();
            exception1.getMessage().contains("out of range") || exception1.getMessage().contains("unsigned long")
    // Test enum for testing enum conversion
        map.put("integer", 42);  
        assertTrue(fieldValue.getGeneralNumber().hasInt32Value());
        assertTrue("FieldValue should have string value", fieldValue.hasString());
            .build();  
        // When a uint64 value > Long.MAX_VALUE is stored, it appears as a negative long
        // Check nested string field
        assertNotNull("FieldValue should not be null", fieldValue);
        assertTrue("FieldValue should have general number", fieldValue.hasGeneralNumber());
 * compatible open source license.
        assertTrue("FieldValue should have general number", fieldValue.hasGeneralNumber());  
    /*
        assertTrue("FieldValue should have object map", fieldValue.hasObjectMap());  
    public void testToProtoWithBigIntegerOutOfRange() {
    public void testFromProtoWithUint64ValueExceedingLongMax() {  
        assertTrue(
        assertNotNull("FieldValue should not be null", fieldValue);
        assertTrue("FieldValue should have general number", fieldValue.hasGeneralNumber());
        nestedMap.put("nested_integer", 99);  
        FieldValue fieldValue = FieldValueProtoUtils.toProto(stringValue);
import java.util.Map;
        assertTrue("Nested string field should have string value", nestedObjectMap.getFieldsOrThrow("nested_string").hasStringValue());
    // TODO: ObjectMap functionality removed in protobufs 0.8.0 - FieldValue now only supports basic types  
        // Check nested map field
        assertFalse("Bool value should be false", falseFieldValue.getBool());
        assertTrue(fieldValue.getGeneralNumber().hasInt64Value());
        TestEnum enumValue = TestEnum.TEST_VALUE;
    */  
    public void testToProtoWithString() {
            assertNotNull("Result should not be null for " + original, result);
            .build();
            .setUint64Value(uint64Value)
    public void testToProtoWithFloat() {
        // Test that BigInteger values outside unsigned long range throw exception
        Integer intValue = 42;
        BigInteger expectedValue = new BigInteger("18446744073709551615"); // 2^64 - 1
        // Should throw IllegalArgumentException for values out of range  
    }
        assertEquals("String value should match", "test string", fieldValue.getString());
import java.util.HashMap;  
            .setUint64Value(uint64ValueExceedingLongMax)
    }  
        TEST_VALUE
public class FieldValueProtoUtilsTests extends OpenSearchTestCase {  
        // Maps are not supported in FieldValue protobuf, should throw exception  
        );
        assertTrue(fieldValue.getGeneralNumber().hasFloatValue());
        assertEquals("Nested integer field should match", 99, nestedObjectMap.getFieldsOrThrow("nested_integer").getInt32());
    }  
        FieldValue fieldValue = FieldValueProtoUtils.toProto(bigIntValue);  
        long uint64Value = 9223372036854775807L;  
    public void testToProtoWithBigIntegerSmallValue() {
        assertTrue("FieldValue should have string value", fieldValue.hasString());
        // Create a FieldValue with UINT64_VALUE
        assertTrue("Exception message should mention cannot convert", exception.getMessage().contains("Cannot convert"));  
    public void testToProtoWithNull() {
        assertTrue("FieldValue should have bool value", trueFieldValue.hasBool());
        FieldValue fieldValue = FieldValue.newBuilder().setGeneralNumber(generalNumber).build();  
        assertNotNull("FieldValue should not be null", falseFieldValue);  
    }
            exception.getMessage().contains("Cannot convert") && exception.getMessage().contains("to FieldValue")
        // Verify the conversion - should return BigInteger for values exceeding Long.MAX_VALUE
        Boolean falseValue = false;  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> FieldValueProtoUtils.toProto(map));
