            exception.getMessage().contains("FieldValue type not recognized")
    }
        assertEquals("Value should match", 10.5f, termQueryBuilder.value());  
/*  
        assertEquals("Value should match", "test_value", termQueryBuilder.value());
    }
        // Call the method under test
        // Call the method under test  
        @SuppressWarnings("unchecked")
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);  
        TermQuery termQuery = TermQuery.newBuilder()  
            .setValue(FieldValue.newBuilder().setString("test_value").build())  
import org.opensearch.index.query.TermQueryBuilder;
            .build();
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);  
        assertEquals("Boost should be default", 1.0f, termQueryBuilder.boost(), 0.0f);
        assertTrue("Case insensitive should be true", termQueryBuilder.caseInsensitive());
            .setBoost(2.0f)
                    .setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setDoubleValue(3.14159))  
        // Verify the result  
        IllegalArgumentException exception = expectThrows(
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);
    public void testFromProtoWithStringValue() {
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
            .build();
            .setField("test_field")
        TermQuery termQuery = TermQuery.newBuilder()
        TermQuery termQuery = TermQuery.newBuilder()  
    }
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);
    public void testFromProtoWithObjectMapValue() {  
    public void testFromProtoWithInvalidFieldValueType() {
            .setBoost(2.0f)  
            .build();  
        ObjectMap.Builder objectMapBuilder = ObjectMap.newBuilder();  
            .setField("test_field")  
            IllegalArgumentException.class,
    public void testFromProtoWithCaseInsensitive() {
                FieldValue.newBuilder()
import org.opensearch.test.OpenSearchTestCase;
        // Create a protobuf TermQuery with no field value set  
        // Call the method under test, should throw IllegalArgumentException
    }
    public void testFromProtoWithUnsupportedFieldValueType() {
        // Call the method under test
            .setValue(  
                    .setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setInt64Value(9223372036854775807L))  
            .setValue(FieldValue.newBuilder().setString("test_value").build())
        TermQuery termQuery = TermQuery.newBuilder()  
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);  
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);  
                FieldValue.newBuilder().setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setFloatValue(42.0f)).build()
        assertTrue(
        // Verify the result
        // Create a protobuf TermQuery with case insensitive flag
            .setXName("test_query")  
        assertEquals("Value should match", "test_value", termQueryBuilder.value());
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);  
        objectMapValues.put("key1", "value1");  
    }
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);  
            .setCaseInsensitive(true)
            .setValue(FieldValue.newBuilder().setString("test_value").build())
    // TODO: ObjectMap functionality removed from FieldValue in protobufs 0.8.0
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);
        }  
                FieldValue.newBuilder().build() // No value set at all
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
        // Create a protobuf TermQuery with minimal values  
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
public class TermQueryBuilderProtoUtilsTests extends OpenSearchTestCase {  
            () -> TermQueryBuilderProtoUtils.fromProto(termQuery)  
    public void testFromProtoWithInt32Value() {  
            .setField("test_field")
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);
        assertEquals("Map entry 2 should match", "value2", value.get("key2"));
            .setField("test_field")  
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);  
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);  
 */  
            .setXName("test_query")  
            .setBoost(2.0f)  
        // Create a protobuf TermQuery with int32 value
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
        assertTrue("Value should be a Map", termQueryBuilder.value() instanceof Map);  
            .setValue(FieldValue.newBuilder().build()) // No value set  
            .setBoost(2.0f)  
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
        // Call the method under test
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);
            .setXName("test_query")
        // Verify the result
            .setXName("test_query")
        assertTrue(  
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
        // Verify the result
            objectMapBuilder.putFields(entry.getKey(), ObjectMap.Value.newBuilder().setString(entry.getValue()).build());
    */  
        );
    public void testFromProtoWithNumberValue() {
        assertEquals("Map should have 2 entries", 2, value.size());  
        // Create a protobuf TermQuery with invalid field value type  
            .setXName("test_query")
        // Verify the result
            )
            .build();  
                FieldValue.newBuilder()
            )  
    }
            .setField("test_field")
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);  
        // Verify the result  
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);  
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);  
    public void testFromProtoWithDefaultValues() {
            .build();
            )
        TermQuery termQuery = TermQuery.newBuilder()
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);  
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);  
import org.opensearch.protobufs.FieldValue;
    /*
            .setField("test_field")
            .setValue(
import org.opensearch.protobufs.TermQuery;  
        Map<String, Object> value = (Map<String, Object>) termQueryBuilder.value();
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);  
                FieldValue.newBuilder().setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setFloatValue(10.5f)).build()
            .setField("test_field")
        );  
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
            .setBoost(2.0f)
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
            .setField("test_field")
        assertEquals("Value should match", "test_value", termQueryBuilder.value());  
    }
    public void testFromProtoWithBooleanValue() {
                    .build()
            exception.getMessage().contains("FieldValue type not recognized")
package org.opensearch.transport.grpc.proto.request.search.query;
            .setBoost(2.0f)
        // Create a protobuf TermQuery with int64 value
        // Verify the result
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
    }  
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
            .setValue(FieldValue.newBuilder().setBool(true).build())
            )
        // Create a protobuf TermQuery with object map value
            .setValue(
        TermQuery termQuery = TermQuery.newBuilder()
        // Create a protobuf TermQuery with double value
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);
 * compatible open source license.
        assertEquals("Map entry 1 should match", "value1", value.get("key1"));
            .setBoost(2.0f)
            .setValue(  
        // Create a protobuf TermQuery with number value
            "Exception message should mention field value not recognized",  
        // Create a protobuf TermQuery with string value  
            .setXName("test_query")
}
        TermQuery termQuery = TermQuery.newBuilder()
            .build();  
            .build();
        assertEquals("Value should match", 3.14159, termQueryBuilder.value());
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
            .build();  
        // Call the method under test, should throw IllegalArgumentException  
            .build();  
            IllegalArgumentException.class,
            .setXName("test_query")
 * SPDX-License-Identifier: Apache-2.0
 *
        assertEquals("Value should match", 42.0f, termQueryBuilder.value());
        // Call the method under test
    }  
            .setField("test_field")
        // Create a protobuf TermQuery with boolean value  
        assertEquals("Value should match", true, termQueryBuilder.value());
            .setXName("test_query")
            () -> TermQueryBuilderProtoUtils.fromProto(termQuery)
        );
        // Call the method under test  
            )
        );  
            .setField("test_field")
        objectMapValues.put("key2", "value2");
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);  
    public void testFromProtoWithInt64Value() {
        // Call the method under test  
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
            "Exception message should mention field value not recognized",
 * The OpenSearch Contributors require contributions made to  
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);
        // Call the method under test
        IllegalArgumentException exception = expectThrows(  
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);  
            .build();  
        // Verify the result
        assertEquals("Field name should match", "test_field", termQueryBuilder.fieldName());
            .setValue(
            .setField("test_field")
        assertNotNull("TermQueryBuilder should not be null", termQueryBuilder);  
        // Verify the result  
        TermQuery termQuery = TermQuery.newBuilder()
    }  
            .build();  
        Map<String, String> objectMapValues = new HashMap<>();
        assertEquals("Boost should match", 2.0f, termQueryBuilder.boost(), 0.0f);  
        TermQueryBuilder termQueryBuilder = TermQueryBuilderProtoUtils.fromProto(termQuery);  
        TermQuery termQuery = TermQuery.newBuilder()
    public void testFromProtoWithDoubleValue() {
        TermQuery termQuery = TermQuery.newBuilder()  
        assertNull("Query name should be null", termQueryBuilder.queryName());
        for (Map.Entry<String, String> entry : objectMapValues.entrySet()) {
                    .build()
        TermQuery termQuery = TermQuery.newBuilder()
        assertEquals("Query name should match", "test_query", termQueryBuilder.queryName());
            .setValue(FieldValue.newBuilder().setObjectMap(objectMapBuilder.build()).build())  
        // Call the method under test
            .setBoost(2.0f)  
        assertEquals("Value should match", 9223372036854775807L, termQueryBuilder.value());
    }  
