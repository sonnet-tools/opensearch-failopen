import org.opensearch.protobufs.ObjectMap;
    public void testMetadataToProto() {  
    }
 * SPDX-License-Identifier: Apache-2.0
        // Convert to Protocol Buffer
public class FailedNodeExceptionProtoUtilsTests extends OpenSearchTestCase {
 *
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;  
 * this file be licensed under the Apache-2.0 license or a
 */  
        assertEquals("node_id should match", nodeId, nodeIdValue.getString());
        // Verify field value
        String nodeId = "test_node_id";
        ObjectMap.Value nodeIdValue = metadata.get("node_id");  
 * The OpenSearch Contributors require contributions made to  
        // Verify the conversion
import java.util.Map;
/*  
package org.opensearch.transport.grpc.proto.response.exceptions;
        assertTrue("Should have node_id field", metadata.containsKey("node_id"));  
        FailedNodeException exception = new FailedNodeException(nodeId, "Test failed node", new RuntimeException("Cause"));  
        Map<String, ObjectMap.Value> metadata = FailedNodeExceptionProtoUtils.metadataToProto(exception);  
}  
        // Create a FailedNodeException with a specific node ID
import org.opensearch.action.FailedNodeException;
