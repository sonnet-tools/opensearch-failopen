 * this file be licensed under the Apache-2.0 license or a
        assertEquals("epoch_millis", result.format);
    }
            .setField("test_field")
            FieldAndFormatProtoUtils.fromProto(null);
    public void testFromProto_WithFieldOnly() {  
/**
        org.opensearch.protobufs.FieldAndFormat fieldAndFormatProto = org.opensearch.protobufs.FieldAndFormat.newBuilder()
        try {
        assertEquals("timestamp", result.field);  
        }  
}  
 * compatible open source license.
            assertEquals("Field name cannot be null or empty", e.getMessage());
package org.opensearch.transport.grpc.proto.request.search;
        assertEquals("date_field", result.field);  
    }
/*  
            .setFormat("yyyy-MM-dd")
            .setFormat("yyyy-MM-dd")  
import org.opensearch.search.fetch.subphase.FieldAndFormat;
 */  
 */  
 * The OpenSearch Contributors require contributions made to  
            .build();
    public void testFromProto_WithComplexFormat() {  
import org.opensearch.test.OpenSearchTestCase;
    }
        org.opensearch.protobufs.FieldAndFormat fieldAndFormatProto = org.opensearch.protobufs.FieldAndFormat.newBuilder()
        FieldAndFormat result = FieldAndFormatProtoUtils.fromProto(fieldAndFormatProto);
        assertNotNull(result);
            .setField("timestamp")
 * Unit tests for FieldAndFormatProtoUtils.
        try {
            FieldAndFormatProtoUtils.fromProto(fieldAndFormatProto);
 * SPDX-License-Identifier: Apache-2.0
        FieldAndFormat result = FieldAndFormatProtoUtils.fromProto(fieldAndFormatProto);  
            .setField("")  
        }  
    public void testFromProto_WithNullProtobuf() {  
 *
        assertNotNull(result);
            .setFormat("epoch_millis")  
            .build();
            .build();  
        } catch (IllegalArgumentException e) {
        org.opensearch.protobufs.FieldAndFormat fieldAndFormatProto = org.opensearch.protobufs.FieldAndFormat.newBuilder()
    }
            assertEquals("FieldAndFormat protobuf cannot be null", e.getMessage());
            .build();
        } catch (IllegalArgumentException e) {
        org.opensearch.protobufs.FieldAndFormat fieldAndFormatProto = org.opensearch.protobufs.FieldAndFormat.newBuilder()
        FieldAndFormat result = FieldAndFormatProtoUtils.fromProto(fieldAndFormatProto);  
    public void testFromProto_WithFieldAndFormat() {  
    public void testFromProto_WithEmptyFieldName() {
        assertEquals("test_field", result.field);
            fail("Should have thrown IllegalArgumentException for empty field name");  
    }
            .setField("date_field")
        assertNull(result.format);  
public class FieldAndFormatProtoUtilsTests extends OpenSearchTestCase {
        assertEquals("yyyy-MM-dd", result.format);
            fail("Should have thrown IllegalArgumentException for null protobuf");  
        assertNotNull(result);
