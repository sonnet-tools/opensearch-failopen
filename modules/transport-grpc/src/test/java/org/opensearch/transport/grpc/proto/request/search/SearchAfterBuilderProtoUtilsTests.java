        Object[] values = SearchAfterBuilderProtoUtils.fromProto(fieldValues);
        assertEquals("Values array should have 1 element", 1, values.length);  
    public void testFromProtoWithInt64Value() throws IOException {
        assertNotNull("Values array should not be null", values);
/*  
        List<FieldValue> fieldValues = Collections.singletonList(FieldValue.newBuilder().setString("test_string").build());
        // Verify the result
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
        assertEquals("Values array should have 1 element", 1, values.length);
        fieldValues.add(
    public void testFromProtoWithFloatValue() throws IOException {
            FieldValue.newBuilder()
        // Create a list with a field value containing zero float
        List<FieldValue> fieldValues = Collections.singletonList(  
        // Call the method under test  
        Object[] values = SearchAfterBuilderProtoUtils.fromProto(fieldValues);
    }  
        assertEquals("Value should be a float", 42.0f, values[0]);
    }
        );
        // Verify the result
        assertNotNull("Values array should not be null", values);
        );  
        List<FieldValue> fieldValues = Collections.singletonList(
        );
        // Create a list with a float value
        // Create a list with a double value  
package org.opensearch.transport.grpc.proto.request.search;
        // Create a list with an empty field value (no value set)
        );  
        // Call the method under test
            FieldValue.newBuilder().setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setDoubleValue(3.14159)).build()
        // Call the method under test
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("Value should be a boolean", true, values[0]);
        assertNotNull("Values array should not be null", values);
        // Verify the result
    }
        assertEquals("Value should be 0.0f", 0.0f, values[0]);  
        Object[] values = SearchAfterBuilderProtoUtils.fromProto(fieldValues);
        List<FieldValue> fieldValues = new ArrayList<>();  
        // Verify the result
        assertNotNull("Values array should not be null", values);
        List<FieldValue> fieldValues = Collections.singletonList(  
    public void testFromProtoWithZeroFloatValue() throws IOException {  
        // Create a list with a boolean value
import java.util.ArrayList;
        );  
        // Call the method under test
import java.util.Collections;  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Values array should have 2 elements", 2, values.length);
        Object[] values = SearchAfterBuilderProtoUtils.fromProto(fieldValues);  
    }
        // Verify the result
 * compatible open source license.
            FieldValue.newBuilder().setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setFloatValue(42.0f)).build()
        Object[] values = SearchAfterBuilderProtoUtils.fromProto(fieldValues);
    }
    public void testFromProtoWithEmptyFieldValue() throws IOException {  
    public void testFromProtoWithEmptyList() throws IOException {
        fieldValues.add(
        assertNotNull("Values array should not be null", values);  
                .build()  
    public void testFromProtoWithInt32Value() throws IOException {
        // Verify the result  
 */  
import java.io.IOException;
                .setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setInt64Value(9223372036854775807L))
import org.opensearch.protobufs.FieldValue;
    }  
    }
    }
        // Create a list with an int64 value
        assertNotNull("Values array should not be null", values);
        Object[] values = SearchAfterBuilderProtoUtils.fromProto(fieldValues);
        assertEquals("Value should be a double", 3.14159, values[0]);
        // Call the method under test
    public void testFromProtoWithDoubleValue() throws IOException {
    public void testFromProtoWithBooleanValue() throws IOException {  
        // Call the method under test
    public void testFromProtoWithMultipleValues() throws IOException {
        assertNotNull("Values array should not be null", values);  
        Object[] values = SearchAfterBuilderProtoUtils.fromProto(fieldValues);
            FieldValue.newBuilder().setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setFloatValue(42.0f)).build()
        List<FieldValue> fieldValues = Collections.singletonList(FieldValue.newBuilder().build());
        assertEquals("First value should be a float", 42.0f, values[0]);
        // Create a list with an int32 value
        assertNotNull("Values array should not be null", values);
 * this file be licensed under the Apache-2.0 license or a
        // Call the method under test with an empty list  
        List<FieldValue> fieldValues = Collections.singletonList(
            FieldValue.newBuilder().setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setDoubleValue(3.14159)).build()
 *
public class SearchAfterBuilderProtoUtilsTests extends OpenSearchTestCase {  
        assertEquals("Values array should have 1 element", 1, values.length);  
    public void testFromProtoWithStringValue() throws IOException {
        );
        assertEquals("Values array should have 1 element", 1, values.length);  
        Object[] values = SearchAfterBuilderProtoUtils.fromProto(Collections.emptyList());
        assertEquals("Value should be a float", 2.71828f, values[0]);
        // Verify the result
        Object[] values = SearchAfterBuilderProtoUtils.fromProto(fieldValues);  
        // Call the method under test
        List<FieldValue> fieldValues = Collections.singletonList(  
        // Create a list with a string value  
    }
            FieldValue.newBuilder().setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setFloatValue(2.71828f)).build()
        assertEquals("Value should be a string", "test_string", values[0]);  
        Object[] values = SearchAfterBuilderProtoUtils.fromProto(fieldValues);
}
        assertNotNull("Values array should not be null", values);
    }
        assertEquals("Value should be a long", 9223372036854775807L, values[0]);
        // Create a list with multiple values of different types
        );
        assertEquals("Values array should be empty", 0, values.length);  
        assertNotNull("Values array should not be null", values);
            FieldValue.newBuilder().setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setFloatValue(0.0f)).build()  
        assertEquals("Values array should have 1 element", 1, values.length);
        assertEquals("Second value should be a double", 3.14159, values[1]);  
        // Verify the result  
        List<FieldValue> fieldValues = Collections.singletonList(FieldValue.newBuilder().setBool(true).build());
        // Call the method under test  
        assertEquals("Values array should be empty", 0, values.length);
        // Verify the result  
        // Verify the result  
        // Call the method under test  
