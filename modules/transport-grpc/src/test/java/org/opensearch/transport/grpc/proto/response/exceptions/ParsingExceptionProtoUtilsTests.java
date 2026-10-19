    }  
import org.opensearch.protobufs.ObjectMap;
        assertTrue("Should have col field", metadata.containsKey("col"));
    public void testMetadataToProtoWithUnknownPosition() {
        // Convert to Protocol Buffer
        ParsingException exception = new ParsingException(UNKNOWN_POSITION, UNKNOWN_POSITION, "Test parsing error", null);
import org.opensearch.test.OpenSearchTestCase;  
    }  
        // Verify the conversion - should be empty since position is unknown  
 */  
        assertTrue("Should have line field", metadata.containsKey("line"));  
 * The OpenSearch Contributors require contributions made to  
        int columnNumber = 10;
public class ParsingExceptionProtoUtilsTests extends OpenSearchTestCase {  
        ObjectMap.Value lineValue = metadata.get("line");
 *
        // Convert to Protocol Buffer  
 * compatible open source license.
/*  
        assertFalse("Should have col field", metadata.containsKey("col"));
import static org.opensearch.core.common.ParsingException.UNKNOWN_POSITION;
        // Verify the conversion
        // Create a ParsingException with unknown position  
package org.opensearch.transport.grpc.proto.response.exceptions;
        // Create a ParsingException with line and column information  
        assertFalse("Should have line field", metadata.containsKey("line"));
        Map<String, ObjectMap.Value> metadata = ParsingExceptionProtoUtils.metadataToProto(exception);
import java.util.Map;
    public void testMetadataToProtoWithPositionInfo() {
        Map<String, ObjectMap.Value> metadata = ParsingExceptionProtoUtils.metadataToProto(exception);  
        assertEquals("line should match", lineNumber, lineValue.getInt32());
        // Verify field values  
        ObjectMap.Value colValue = metadata.get("col");
        ParsingException exception = new ParsingException(lineNumber, columnNumber, "Test parsing error", null);  
        int lineNumber = 42;
import org.opensearch.core.common.ParsingException;
        assertEquals("col should match", columnNumber, colValue.getInt32());
}
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
