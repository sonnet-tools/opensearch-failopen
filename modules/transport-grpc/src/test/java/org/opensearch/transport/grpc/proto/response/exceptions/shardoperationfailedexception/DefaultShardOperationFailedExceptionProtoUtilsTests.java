import org.opensearch.core.action.support.DefaultShardOperationFailedException;
            new RuntimeException("Test cause 2"),
        assertEquals("Shard ID should match", 4, shardFailure.getShard());
            new RuntimeException("Test cause 3")
        );  
            "test-index-5",
        // Call the method under test  
    public void testToProtoWithAddIndexBlockResponseFailure() throws IOException {
        assertEquals("Index should match", "test-index-2", shardFailure.getIndex());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse;
        assertEquals("Shard ID should match", 3, shardFailure.getShard());
    public void testToProtoWithIndicesShardStoresResponseFailure() throws IOException {
        assertNotNull("ShardFailure should not be null", shardFailure);  
            "test-index",
        // Verify the result
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
        // Verify the result  
        assertEquals("Index should match", "test-index", shardFailure.getIndex());  
        // Create a real AddIndexBlockResponse.AddBlockShardResult.Failure  
    }  
            "node-3"
            2,  
        assertNotNull("Reason should not be null", shardFailure.getReason());
        ShardFailure shardFailure = DefaultShardOperationFailedExceptionProtoUtils.toProto(exception);  
        );  
        // Call the method under test
        assertEquals("Node should match", "node-3", shardFailure.getNode());
        ShardFailure shardFailure = DefaultShardOperationFailedExceptionProtoUtils.toProto(null);  
            "node-1"
        ShardFailure shardFailure = DefaultShardOperationFailedExceptionProtoUtils.toProto(exception);
import java.io.IOException;  
        assertFalse("Index should not be set", shardFailure.hasIndex());
        assertEquals("Index should match", "test-index-4", shardFailure.getIndex());
        assertNotNull("Reason should not be null", shardFailure.getReason());
        assertEquals("Status should match", RestStatus.INTERNAL_SERVER_ERROR.name(), shardFailure.getStatus());  
        // Call the method under test
    }  
        AddIndexBlockResponse.AddBlockShardResult.Failure exception = new AddIndexBlockResponse.AddBlockShardResult.Failure(
    }  
            new RuntimeException("Test cause")  
    public void testToProtoWithNullNodeId() throws IOException {
        // Create a real AddIndexBlockResponse.AddBlockShardResult.Failure with null nodeId  
        assertFalse("Node should not be set", shardFailure.hasNode());
import org.opensearch.action.admin.indices.shards.IndicesShardStoresResponse;  
        assertNotNull("ShardFailure should not be null", shardFailure);  
        DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException(  
    }  
        );  
        assertEquals("Shard ID should match", 2, shardFailure.getShard());
        CloseIndexResponse.ShardResult.Failure exception = new CloseIndexResponse.ShardResult.Failure(
}
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Status should match", RestStatus.INTERNAL_SERVER_ERROR.name(), shardFailure.getStatus());  
 */  
        assertFalse("Reason should not be set", shardFailure.hasReason());
        assertEquals("Shard ID should match", 5, shardFailure.getShard());
        // Create a real IndicesShardStoresResponse.Failure  
    public void testToProtoWithCloseIndexResponseFailure() throws IOException {
        ShardFailure shardFailure = DefaultShardOperationFailedExceptionProtoUtils.toProto(exception);  
        assertNotNull("ShardFailure should not be null", shardFailure);
        IndicesShardStoresResponse.Failure exception = new IndicesShardStoresResponse.Failure(
        // Verify the result
        assertNotNull("ShardFailure should not be null", shardFailure);  
            "node-2",
            null // null nodeId
        assertEquals("Node should match", "node-1", shardFailure.getNode());
        // Create a real CloseIndexResponse.ShardResult.Failure  
import org.opensearch.test.OpenSearchTestCase;
        assertNotNull("ShardFailure should not be null", shardFailure);  
            3,
import org.opensearch.protobufs.ShardFailure;  
            new RuntimeException("Test cause 5"),
        assertEquals("Status should match", RestStatus.INTERNAL_SERVER_ERROR.name(), shardFailure.getStatus());  
        assertNotNull("Reason should not be null", shardFailure.getReason());
        // Create a real DefaultShardOperationFailedException
 * compatible open source license.
import org.opensearch.core.rest.RestStatus;
        assertEquals("Status should match", RestStatus.INTERNAL_SERVER_ERROR.name(), shardFailure.getStatus());  
        assertNotNull("ShardFailure should not be null", shardFailure);
    }  
package org.opensearch.transport.grpc.proto.response.exceptions.shardoperationfailedexception;
        assertNotNull("Reason should not be null", shardFailure.getReason());
        assertNotNull("Reason should not be null", shardFailure.getReason());
        // Verify the result
            "test-index-2",
        assertEquals("Status should match", RestStatus.INTERNAL_SERVER_ERROR.name(), shardFailure.getStatus());
    public void testToProtoWithDefaultShardOperationFailedException() throws IOException {
            5,  
        assertEquals("Shard ID should match", 1, shardFailure.getShard());
        assertFalse("Node should not be set", shardFailure.hasNode());
        ShardFailure shardFailure = DefaultShardOperationFailedExceptionProtoUtils.toProto(exception);  
            1,
        );
/*  
        ShardFailure shardFailure = DefaultShardOperationFailedExceptionProtoUtils.toProto(exception);  
        );  
        assertFalse("Status should not be set", shardFailure.hasStatus());  
            "test-index-4",
        assertEquals("Index should match", "test-index-3", shardFailure.getIndex());
        // Call the method under test
 *
            4,  
        // Verify the result
        assertEquals("Node should match", "node-2", shardFailure.getNode());
        // Call the method under test
        AddIndexBlockResponse.AddBlockShardResult.Failure exception = new AddIndexBlockResponse.AddBlockShardResult.Failure(
 * The OpenSearch Contributors require contributions made to  
            "test-index-3",  
            new RuntimeException("Test cause 4"),
    }  
        assertEquals("Index should match", "test-index-5", shardFailure.getIndex());
public class DefaultShardOperationFailedExceptionProtoUtilsTests extends OpenSearchTestCase {
    public void testToProtoWithNull() throws IOException {
