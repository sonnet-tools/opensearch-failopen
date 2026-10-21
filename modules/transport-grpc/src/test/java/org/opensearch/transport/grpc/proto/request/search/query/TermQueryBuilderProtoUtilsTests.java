        // Create a protobuf TermQuery with int32 value
import org.opensearch.index.query.TermQueryBuilder;
                FieldValue.newBuilder()
        Map<String, Object> value = (Map<String, Object>) termQueryBuilder.value();
        assertEquals("Value should match", "test_value", termQueryBuilder.value());
        // Create a protobuf TermQuery with boolean value
        assertEquals("Map entry 2 should match", "value2", value.get("key2"));
            exception.getMessage().contains("FieldValue type not recognized")
        // Verify the result
            .build();
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
    public void testFromProtoWithDoubleValue() {
            .setValue(FieldValue.newBuilder().setString("test_value").build())
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
            objectMapBuilder.putFields(entry.getKey(), ObjectMap.Value.newBuilder().setString(entry.getValue()).build());
        // Call the method under test
        // Create a protobuf TermQuery with case insensitive flag
        assertEquals("Boost should be default", 1.0f, termQueryBuilder.boost(), 0.0f);
        assertEquals("Value should match", "test_value", termQueryBuilder.value());
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);
        assertTrue("Case insensitive should be true", termQueryBuilder.caseInsensitive());
    }
        );
            .setBoost(2.0f)
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);
            .setValue(FieldValue.newBuilder().setString("test_value").build())
    }
        // Verify the result
    }
            .setXName("test_query")
        );
            .setField("test_field")
    }
            .setValue(
            .setValue(FieldValue.newBuilder().build()) // No value set
        );
        // Verify the result
            () -> TermQueryBuilderProtoUtils.fromProto(termQuery)
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
        assertEquals("Value should match", true, termQueryBuilder.value());
    public void testFromProtoWithDefaultValues() {
import org.opensearch.test.OpenSearchTestCase;
        IllegalArgumentException exception = expectThrows(
        assertEquals("Map entry 1 should match", "value1", value.get("key1"));
        TermQuery termQuery = TermQuery.newBuilder()
    }
            .setXName("test_query")
    }
            .setValue(
        TermQuery termQuery = TermQuery.newBuilder()
        assertTrue("Value should be a Map", termQueryBuilder.value() instanceof Map);
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);
 */
            .setField("test_field")
            .setField("test_field")
            .setXName("test_query")
    public void testFromProtoWithUnsupportedFieldValueType() {
    public void testFromProtoWithInt64Value() {
            IllegalArgumentException.class,
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
            .build();
        // Verify the result
}
            () -> TermQueryBuilderProtoUtils.fromProto(termQuery)
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);
            .setXName("test_query")
        // Create a protobuf TermQuery with invalid field value type
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
        // Create a protobuf TermQuery with object map value
            .build();
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);
        // Call the method under test
            .setXName("test_query")
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);
            .setValue(FieldValue.newBuilder().setBool(true).build())
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);
        Map<String, String> objectMapValues = new HashMap<>();
            .setBoost(2.0f)
    public void testFromProtoWithStringValue() {
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);
            .setBoost(2.0f)
            .setXName("test_query")
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);
        assertEquals("Value should match", 42.0f, termQueryBuilder.value());
            .setField("test_field")
            )
import org.opensearch.protobufs.FieldValue;
        // Create a protobuf TermQuery with no field value set
            .setXName("test_query")
            .build();
            .setXName("test_query")
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
    public void testFromProtoWithObjectMapValue() {
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);
            )
            )
    public void testFromProtoWithInvalidFieldValueType() {
        objectMapValues.put("key2", "value2");
package org.opensearch.transport.grpc.proto.request.search.query;
        // Verify the result
            .setValue(
        TermQuery termQuery = TermQuery.newBuilder()
        TermQuery termQuery = TermQuery.newBuilder()
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);
            .setBoost(2.0f)
            .setField("test_field")
        assertEquals("Value should match", 10.5f, termQueryBuilder.value());
    }
            .build();
        TermQuery termQuery = TermQuery.newBuilder()
            .setCaseInsensitive(true)
                    .build()
        }
    }
        // Verify the result
            .build();
        // Call the method under test
            .setValue(
    public void testFromProtoWithCaseInsensitive() {
        // Create a protobuf TermQuery with int64 value
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);
        assertEquals("Value should match", 9223372036854775807L, termQueryBuilder.value());
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);
        assertNull("Query name should be null", termQueryBuilder.queryName());
    public void testFromProtoWithNumberValue() {
        IllegalArgumentException exception = expectThrows(
    }
/*
        // Verify the result
 * The OpenSearch Contributors require contributions made to
            )
        for (Map.Entry<String, String> entry : objectMapValues.entrySet()) {
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
            .setBoost(2.0f)
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);
            IllegalArgumentException.class,
        objectMapValues.put("key1", "value1");
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
            .setValue(
        TermQuery termQuery = TermQuery.newBuilder()
    public void testFromProtoWithInt32Value() {
            .setBoost(2.0f)
        // Create a protobuf TermQuery with double value
                    .build()
            .setBoost(2.0f)
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);
            .setField("test_field")
public class TermQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
            .setBoost(2.0f)
        TermQuery termQuery = TermQuery.newBuilder()
 * this file be licensed under the Apache-2.0 license or a
            .setField("test_field")
        // Call the method under test
        ObjectMap.Builder objectMapBuilder = ObjectMap.newBuilder();
    /*
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);
        @SuppressWarnings("unchecked")
            .build();
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);
                FieldValue.newBuilder()
        TermQuery termQuery = TermQuery.newBuilder()
            .setValue(FieldValue.newBuilder().setObjectMap(objectMapBuilder.build()).build())
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
 * compatible open source license.
        // Call the method under test
            .setField("test_field")
            .build();
        TermQuery termQuery = TermQuery.newBuilder()
        // Create a protobuf TermQuery with string value
                FieldValue.newBuilder().setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setFloatValue(10.5f)).build()
        );
 * SPDX-License-Identifier: Apache-2.0
        // Create a protobuf TermQuery with minimal values
        // Call the method under test, should throw IllegalArgumentException
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
                    .setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setInt64Value(9223372036854775807L))
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);
        // Call the method under test
import org.opensearch.protobufs.TermQuery;
        // Verify the result
        // Call the method under test, should throw IllegalArgumentException
            exception.getMessage().contains("FieldValue type not recognized")
            .build();
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);
            .setValue(FieldValue.newBuilder().setString("test_value").build())
        assertEquals("Value should match", 3.14159, termQueryBuilder.value());
                    .setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setDoubleValue(3.14159))
    }
        // Create a protobuf TermQuery with number value
    public void testFromProtoWithBooleanValue() {
        TermQuery termQuery = TermQuery.newBuilder()
        assertTrue(
                FieldValue.newBuilder().setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setFloatValue(42.0f)).build()
            "Exception message should mention field value not recognized",
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);
        // Call the method under test
        // Call the method under test
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
 *
        assertEquals("Value should match", "test_value", termQueryBuilder.value());
        assertEquals("Map should have 2 entries", 2, value.size());
    */
            "Exception message should mention field value not recognized",
        // Verify the result
            .setField("test_field")
                FieldValue.newBuilder().build() // No value set at all
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
    }
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
        // Call the method under test
    // TODO: ObjectMap functionality removed from FieldValue in protobufs 0.8.0
            )
        TermQuery termQuery = TermQuery.newBuilder()
            .build();
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);
            .build();
            .setField("test_field")
        assertTrue(
            .setField("test_field")
