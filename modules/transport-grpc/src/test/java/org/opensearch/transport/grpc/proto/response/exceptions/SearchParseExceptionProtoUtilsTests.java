        // Verify the conversion  
        // Convert to Protocol Buffer  
        @Override
        // Create a mock SearchParseException with specific line and column information
            super(null, "Test search parse error", null);  
    }
import java.io.IOException;
     * A simple mock implementation of SearchParseException for testing purposes.
 * The OpenSearch Contributors require contributions made to  
            this.lineNumber = lineNumber;
        public int getColumnNumber() {
        public MockSearchParseException(int lineNumber, int columnNumber) throws IOException {
        SearchParseException exception = new MockSearchParseException(lineNumber, columnNumber);
import java.util.Map;  
    }
        ObjectMap.Value colValue = metadata.get("col");  
    private static class MockSearchParseException extends SearchParseException {
        int columnNumber = 15;
        private final int columnNumber;  
 *
import org.opensearch.test.OpenSearchTestCase;  
        assertTrue("Should have col field", metadata.containsKey("col"));
public class SearchParseExceptionProtoUtilsTests extends OpenSearchTestCase {
    /**  
 * SPDX-License-Identifier: Apache-2.0
        public int getLineNumber() {  
     * This mock only provides the line and column numbers needed for the test.
}  
        @Override
            return lineNumber;
package org.opensearch.transport.grpc.proto.response.exceptions;
     */  
        Map<String, ObjectMap.Value> metadata = SearchParseExceptionProtoUtils.metadataToProto(exception);
        // Create a mock SearchParseException that only provides the line and column numbers  
        }
        assertEquals("line should match", lineNumber, lineValue.getInt32());
            return columnNumber;  
        // Verify field values
        int lineNumber = 25;  
        }
        private final int lineNumber;
 * compatible open source license.
        assertTrue("Should have line field", metadata.containsKey("line"));
    public void testMetadataToProto() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.protobufs.ObjectMap;
/*  
        }  
            this.columnNumber = columnNumber;
 */  
import org.opensearch.search.SearchParseException;
        assertEquals("col should match", columnNumber, colValue.getInt32());  
        ObjectMap.Value lineValue = metadata.get("line");
