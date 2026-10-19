package org.opensearch.transport.grpc.proto.response.document.common;
 */  
        // Verify the conversion  
 *
        // Verify the conversion
        List<Object> fieldValues = Arrays.asList("value1", "value2");
import java.util.List;  
        ObjectMap.Value value = DocumentFieldProtoUtils.toProto(fieldValues);
        // Convert to Protocol Buffer
    public void testToProtoWithSimpleValues() {  
        assertNotNull("Value should not be null", value);  
        assertNotNull("Value should not be null", value);
import java.util.Collections;
public class DocumentFieldProtoUtilsTests extends OpenSearchTestCase {
import org.opensearch.protobufs.ObjectMap;
    public void testToProtoWithEmptyList() {
        List<Object> fieldValues = Collections.emptyList();  
 * SPDX-License-Identifier: Apache-2.0
        // Convert null to Protocol Buffer  
        assertNotNull("Value should not be null", value);
        ObjectMap.Value value = DocumentFieldProtoUtils.toProto(fieldValues);  
        // is not yet completed. This test will need to be updated once the implementation is complete.
    }  
        // Create a list of field values
 * The OpenSearch Contributors require contributions made to  
    }
import java.util.Arrays;
        ObjectMap.Value value = DocumentFieldProtoUtils.toProto(null);
        // Note: The current implementation might return a default value because the implementation
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
        // Create an empty list of field values
        // Convert to Protocol Buffer
}  
 * compatible open source license.
    public void testToProtoWithNullList() {
    }
        // Verify the conversion
/*  
