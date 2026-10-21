            new BigInteger("9223372036854775807"), // Max signed long
            assertEquals("Value should match for " + original, original.longValue(), ((Long) result).longValue());
        assertEquals("Uint64 value should match max unsigned long", expectedValue, result);
        assertEquals("Null value should match proto enum", NullValue.NULL_VALUE_NULL, fieldValue.getNullValue());
    }
        org.opensearch.protobufs.ObjectMap outerObjectMap = fieldValue.getObjectMap();
    }
    }
    }
        for (BigInteger original : testValues) {
        assertEquals("Outer object map should have 2 fields", 2, outerObjectMap.getFieldsCount());
            "Exception should mention out of range",
            .build();
        assertEquals("Uint64 value should match", 2147395412L, fieldValue.getGeneralNumber().getUint64Value());
        FieldValue fieldValue = FieldValueProtoUtils.toProto(enumValue);
        assertTrue("FieldValue should have general number", fieldValue.hasGeneralNumber());
        assertTrue("Nested string field should have string value", nestedObjectMap.getFieldsOrThrow("nested_string").hasStringValue());
        assertTrue("Outer string field should exist", outerObjectMap.containsFields("outer_string"));
        assertTrue("Nested string field should exist", nestedObjectMap.containsFields("nested_string"));
        assertFalse("Bool value should be false", falseFieldValue.getBool());
            () -> FieldValueProtoUtils.toProto(unsupportedObject)
        assertEquals("Float value should match", 2.71828f, fieldValue.getGeneralNumber().getFloatValue(), 0.0f);
        // Test with true
        FieldValue fieldValue = FieldValueProtoUtils.toProto(longValue);
    public void testToProtoWithNestedMap() {
    // This test needs to be rewritten for the simplified FieldValue structure
        org.opensearch.protobufs.ObjectMap nestedObjectMap = outerObjectMap.getFieldsOrThrow("nested_map").getObjectMap();
        assertTrue("FieldValue should have general number", fieldValue.hasGeneralNumber());
            Object result = FieldValueProtoUtils.fromProto(fieldValue);
 * compatible open source license.
        // The expected behavior is to return BigInteger for values that don't fit in signed long
            FieldValue fieldValue = FieldValueProtoUtils.toProto(original);
        assertNotNull("FieldValue should not be null", fieldValue);
package org.opensearch.transport.grpc.proto.response.common;
        assertNotNull("FieldValue should not be null", fieldValue);
    public void testToProtoWithNull() {
        assertTrue(
    }
    public void testFromProtoWithUint64Value() {
        // Test round-trip conversion for BigInteger values
        IllegalArgumentException exception2 = expectThrows(IllegalArgumentException.class, () -> FieldValueProtoUtils.toProto(negative));
        // Check nested string field
        assertTrue("GeneralNumber should have uint64 value", fieldValue.getGeneralNumber().hasUint64Value());
        map.put("string", "value");
        assertNotNull("FieldValue should not be null", fieldValue);
    }
        assertTrue("GeneralNumber should have uint64 value", fieldValue.getGeneralNumber().hasUint64Value());
        assertEquals("String value should match", "test string", fieldValue.getString());
    public void testToProtoWithBigInteger() {
        outerMap.put("nested_map", nestedMap);
    public void testToProtoWithString() {
        assertNotNull("FieldValue should not be null", fieldValue);
        assertEquals("Nested integer field should match", 99, nestedObjectMap.getFieldsOrThrow("nested_integer").getInt32());
        assertEquals("Uint64 value should match", uint64Value, result);
        assertNotNull("FieldValue should not be null", fieldValue);
        Boolean falseValue = false;
            exception.getMessage().contains("Cannot convert") && exception.getMessage().contains("to FieldValue")
        FieldValue fieldValue = FieldValueProtoUtils.toProto(bigIntValue);
        BigInteger[] testValues = {
        // Call the method under test, should throw IllegalArgumentException
        assertTrue("Exception message should mention cannot convert", exception.getMessage().contains("Cannot convert"));
        assertTrue("Nested map field should have object map", outerObjectMap.getFieldsOrThrow("nested_map").hasObjectMap());
        // Convert from Protocol Buffer
    }
        );
        Boolean trueValue = true;
    public void testToProtoWithMap() {
        // Create a FieldValue with UINT64_VALUE that exceeds Long.MAX_VALUE
        assertTrue(fieldValue.getGeneralNumber().hasDoubleValue());
        // Check nested map field
        Double doubleValue = 3.14159;
import java.math.BigInteger;
            new BigInteger("0"),
        // Should throw IllegalArgumentException for values out of range
    public void testToProtoWithEnum() {
            exception2.getMessage().contains("out of range") || exception2.getMessage().contains("unsigned long")
    public void testRoundTripBigInteger() {
    }
    }
            assertNotNull("Result should not be null for " + original, result);
        assertNotNull("FieldValue should not be null", fieldValue);
        // Test with a BigInteger that represents an unsigned_long value
        );
        nestedMap.put("nested_string", "nested value");
        FieldValue fieldValue = FieldValueProtoUtils.toProto(doubleValue);
        // Create a FieldValue with UINT64_VALUE
        // Check nested integer field
        nestedMap.put("nested_integer", 99);
        );
        map.put("integer", 42);
        assertEquals("Nested object map should have 2 fields", 2, nestedObjectMap.getFieldsCount());
        TEST_VALUE
        assertTrue("FieldValue should have bool value", falseFieldValue.hasBool());
            .build();
    }
        assertTrue("FieldValue should have object map", fieldValue.hasObjectMap());
        }
            .setUint64Value(uint64Value)
        assertTrue(
        BigInteger tooLarge = new BigInteger("18446744073709551616"); // 2^64 (exceeds max unsigned long)
        assertTrue("FieldValue should have null value", fieldValue.hasNullValue());
        FieldValue fieldValue = FieldValueProtoUtils.toProto(intValue);
        assertNotNull("FieldValue should not be null", fieldValue);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> FieldValueProtoUtils.toProto(map));
        assertTrue("FieldValue should have general number", fieldValue.hasGeneralNumber());
    public void testToProtoWithInteger() {
        assertNotNull("FieldValue should not be null", trueFieldValue);
    }
    }
        assertNotNull("FieldValue should not be null", fieldValue);
        FieldValue fieldValue = FieldValueProtoUtils.toProto(floatValue);
            "Exception message should mention cannot convert map",
        Map<String, Object> outerMap = new HashMap<>();
        Object unsupportedObject = new StringBuilder("unsupported");
        assertNotNull("Result should not be null", result);
import java.util.Map;
        assertTrue("FieldValue should have general number", fieldValue.hasGeneralNumber());
        assertTrue("FieldValue should have string value", fieldValue.hasString());
        assertTrue(fieldValue.getGeneralNumber().hasFloatValue());
    public void testToProtoWithBoolean() {
        Long longValue = 9223372036854775807L; // Max long value
        FieldValue fieldValue = FieldValueProtoUtils.toProto(outerMap);
    public void testToProtoWithFloat() {
        Object result = FieldValueProtoUtils.fromProto(fieldValue);
        assertEquals("Long value should match", 9223372036854775807L, fieldValue.getGeneralNumber().getInt64Value());
        assertTrue("FieldValue should have general number", fieldValue.hasGeneralNumber());
            BigInteger.valueOf(Long.MAX_VALUE) };
        assertTrue("FieldValue should have general number", fieldValue.hasGeneralNumber());
        // Test with a BigInteger that has a value within signed long range
        // Check outer string field
        assertTrue("FieldValue should have bool value", trueFieldValue.hasBool());
        IllegalArgumentException exception1 = expectThrows(IllegalArgumentException.class, () -> FieldValueProtoUtils.toProto(tooLarge));
        assertNotNull("FieldValue should not be null", fieldValue);
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(fieldValue.getGeneralNumber().hasInt64Value());
    private enum TestEnum {
 * The OpenSearch Contributors require contributions made to
        FieldValue trueFieldValue = FieldValueProtoUtils.toProto(trueValue);
        IllegalArgumentException exception = expectThrows(
        // Convert from Protocol Buffer
 *
        assertTrue("FieldValue should have string value", fieldValue.hasString());
        BigInteger expectedValue = new BigInteger("18446744073709551615"); // 2^64 - 1
        assertTrue("Nested integer field should exist", nestedObjectMap.containsFields("nested_integer"));
import java.util.HashMap;
        // (e.g., max uint64 = 2^64-1 appears as -1L in two's complement)
        Map<String, Object> nestedMap = new HashMap<>();
        BigInteger bigIntValue = new BigInteger("18446744073709551615"); // Max unsigned long
            IllegalArgumentException.class,
        FieldValue fieldValue = FieldValueProtoUtils.toProto(bigIntValue);
        );
        FieldValue fieldValue = FieldValueProtoUtils.toProto(stringValue);
        BigInteger bigIntValue = new BigInteger("2147395412");
        assertNotNull("FieldValue should not be null", fieldValue);
        assertTrue(fieldValue.getGeneralNumber().hasInt32Value());
        org.opensearch.protobufs.GeneralNumber generalNumber = org.opensearch.protobufs.GeneralNumber.newBuilder()
        outerMap.put("outer_string", "outer value");
    public void testToProtoWithDouble() {
        assertNotNull("FieldValue should not be null", falseFieldValue);
    // TODO: ObjectMap functionality removed in protobufs 0.8.0 - FieldValue now only supports basic types
    public void testFromProtoWithUint64ValueExceedingLongMax() {
            new BigInteger("2147395412"),
            .setUint64Value(uint64ValueExceedingLongMax)
import org.opensearch.protobufs.FieldValue;
/*
            exception1.getMessage().contains("out of range") || exception1.getMessage().contains("unsigned long")
        assertTrue("Bool value should be true", trueFieldValue.getBool());
        FieldValue fieldValue = FieldValue.newBuilder().setGeneralNumber(generalNumber).build();
        // Test that BigInteger values outside unsigned long range throw exception
        // When a uint64 value > Long.MAX_VALUE is stored, it appears as a negative long
}
    }
    }
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Nested integer field should have int32 value", nestedObjectMap.getFieldsOrThrow("nested_integer").hasInt32());
        BigInteger negative = new BigInteger("-1");
        assertEquals("Integer value should match", 42, fieldValue.getGeneralNumber().getInt32Value());
import org.opensearch.protobufs.NullValue;
        // Use a test enum
    public void testToProtoWithLong() {
        assertEquals("Nested string field should match", "nested value", nestedObjectMap.getFieldsOrThrow("nested_string").getStringValue());
        assertTrue("Result should be Long", result instanceof Long);
        Map<String, Object> map = new HashMap<>();
    public void testToProtoWithBigIntegerOutOfRange() {
    }
        // Verify the conversion
    /*
        Float floatValue = 2.71828f;
    }
        assertNotNull("Result should not be null", result);
        Integer intValue = 42;
        assertTrue("Nested map field should exist", outerObjectMap.containsFields("nested_map"));
        // Test with false
        // Maps are not supported in FieldValue protobuf, should throw exception
        // Create an object of an unsupported type
        FieldValue fieldValue = FieldValue.newBuilder().setGeneralNumber(generalNumber).build();
        FieldValue fieldValue = FieldValueProtoUtils.toProto(null);
    public void testToProtoWithUnsupportedType() {
        TestEnum enumValue = TestEnum.TEST_VALUE;
        String stringValue = "test string";
        FieldValue falseFieldValue = FieldValueProtoUtils.toProto(falseValue);
        assertTrue(
        assertEquals("Outer string field should match", "outer value", outerObjectMap.getFieldsOrThrow("outer_string").getStringValue());
    */
        assertEquals("String value should match enum toString", "TEST_VALUE", fieldValue.getString());
public class FieldValueProtoUtilsTests extends OpenSearchTestCase {
        map.put("boolean", true);
    public void testToProtoWithBigIntegerSmallValue() {
    // Test enum for testing enum conversion
        Object result = FieldValueProtoUtils.fromProto(fieldValue);
        long uint64Value = 9223372036854775807L;
            "Exception should mention out of range",
        // Verify the conversion - should return BigInteger for values exceeding Long.MAX_VALUE
        assertTrue("Outer string field should have string value", outerObjectMap.getFieldsOrThrow("outer_string").hasStringValue());
import org.opensearch.test.OpenSearchTestCase;
            assertTrue("Result should be Long for " + original, result instanceof Long);
        assertEquals("Double value should match", 3.14159, fieldValue.getGeneralNumber().getDoubleValue(), 0.001);
        // Using a value that fits in Java long (max long is 9223372036854775807L)
        assertTrue("Result should be BigInteger when value exceeds Long.MAX_VALUE", result instanceof BigInteger);
    }
    }
 */
        assertEquals("Uint64 value should match", -1L, fieldValue.getGeneralNumber().getUint64Value()); // -1L is max unsigned
        org.opensearch.protobufs.GeneralNumber generalNumber = org.opensearch.protobufs.GeneralNumber.newBuilder()
        long uint64ValueExceedingLongMax = -1L; // This represents 2^64-1 (max unsigned long)
