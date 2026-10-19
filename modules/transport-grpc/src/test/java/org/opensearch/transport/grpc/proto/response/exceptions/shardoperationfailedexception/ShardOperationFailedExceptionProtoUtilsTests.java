    public void testToProtoWithNullShardOperationFailedException() {  
        // Verify the result
        ShardFailure protoFailure = ShardOperationFailedExceptionProtoUtils.toProto(defaultShardOperationFailedException);  
        UnsupportedOperationException exception = expectThrows(
/*  
    }
        // Create a SnapshotShardFailure
        ReplicationResponse.ShardInfo.Failure replicationResponseFailure = new ReplicationResponse.ShardInfo.Failure(  
        assertEquals("Shard ID should match", 2, protoFailure.getShard());
    }
        // Create a mock ShardOperationFailedException that is not one of the supported types  
 * The OpenSearch Contributors require contributions made to  
        assertNotNull("Proto failure should not be null", protoFailure);  
        ShardFailure protoFailure = ShardOperationFailedExceptionProtoUtils.toProto(shardSearchFailure);
    public void testToProtoWithShardSearchFailure() throws IOException {  
    }
        SnapshotShardFailure shardSearchFailure = new SnapshotShardFailure("test_node", shardId, "Snapshot failed");
public class ShardOperationFailedExceptionProtoUtilsTests extends OpenSearchTestCase {
        ShardId shardId = new ShardId("test_index", "_na_", 4);
        assertEquals("Index should match", "test_index", protoFailure.getIndex());
        assertFalse("Primary should be false for search failures", protoFailure.getPrimary());
        );  
        ShardOperationFailedException mockFailure = mock(ShardOperationFailedException.class);
import org.opensearch.action.support.replication.ReplicationResponse;
        assertTrue("Primary should be true", protoFailure.getPrimary());  
            () -> ShardOperationFailedExceptionProtoUtils.toProto(null)
        );
        );  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.ShardOperationFailedException;  
import static org.mockito.Mockito.mock;
            new RuntimeException("Test exception")
import org.opensearch.core.index.shard.ShardId;
    }
        assertEquals("Shard ID should match", 3, protoFailure.getShard());
import org.opensearch.snapshots.SnapshotShardFailure;  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
            3,
import java.io.IOException;  
            new RuntimeException("Test exception"),  
        ShardId shardId = new ShardId("test_index", "_na_", 1);  
        // Verify primary field is false (default) for search failures  
        // ShardSearchFailure doesn't set primary, so it defaults to false in the legacy proto
            RestStatus.INTERNAL_SERVER_ERROR,
        ShardFailure protoFailure = ShardOperationFailedExceptionProtoUtils.toProto(shardSearchFailure);
 * SPDX-License-Identifier: Apache-2.0
        // Call the method under test, should throw UnsupportedOperationException  
        // Verify the result
            true
import org.opensearch.core.rest.RestStatus;  
    public void testToProtoWithReplicationResponseShardInfoFailure() throws IOException {  
        assertEquals("Node ID should match", "test_node", protoFailure.getNode());
        // Create a mock DefaultShardOperationFailedException
        // Create a mock ReplicationResponse.ShardInfo.Failure
            UnsupportedOperationException.class,
        assertEquals("Index should match", "test_index", protoFailure.getIndex());
        assertTrue(  
        // Create a ShardSearchFailure  
            UnsupportedOperationException.class,  
        // Create a SearchShardTarget with a nodeId
import org.opensearch.search.SearchShardTarget;
    public void testToProtoWithSnapshotShardFailure() throws IOException {
        assertNotNull("Proto failure should not be null", protoFailure);
import org.opensearch.protobufs.ShardFailure;
    public void testToProtoWithDefaultShardOperationFailedException() throws IOException {  
        SearchShardTarget searchShardTarget = new SearchShardTarget("test_node", shardId, null, null);
 *
        assertEquals("Status should match", "INTERNAL_SERVER_ERROR", protoFailure.getStatus());  
        UnsupportedOperationException exception = expectThrows(
        // Call the method under test with null, should throw UnsupportedOperationException
        DefaultShardOperationFailedException defaultShardOperationFailedException = new DefaultShardOperationFailedException(
    }  
        assertEquals("Shard ID should match", 4, protoFailure.getShard());
        ShardFailure protoFailure = ShardOperationFailedExceptionProtoUtils.toProto(replicationResponseFailure);  
        assertNotNull("Proto failure should not be null", protoFailure);  
        assertEquals("Index should match", "test_index", protoFailure.getIndex());
            () -> ShardOperationFailedExceptionProtoUtils.toProto(mockFailure)  
        assertNotNull("Proto failure should not be null", protoFailure);
        assertEquals("Status should match", "INTERNAL_SERVER_ERROR", protoFailure.getStatus());
        assertEquals("Index should match", "test_index", protoFailure.getIndex());  
        );
        // Call the method under test
        assertEquals("Shard ID should match", 1, protoFailure.getShard());  
import org.opensearch.action.search.ShardSearchFailure;
            "test_index",  
 */  
    public void testToProtoWithUnsupportedShardOperationFailedException() {
        ShardSearchFailure shardSearchFailure = new ShardSearchFailure(new Exception("fake exception"), searchShardTarget);
            exception.getMessage().contains("Unsupported ShardOperationFailedException")
        assertEquals("Status should match", "INTERNAL_SERVER_ERROR", protoFailure.getStatus());  
        // Call the method under test
import org.opensearch.test.OpenSearchTestCase;
            "test_node",
        assertEquals("Unsupported ShardOperationFailedException [null] cannot be converted to proto.", exception.getMessage());
        ShardId shardId = new ShardId("test_index", "_na_", 2);
            shardId,
        // Verify the result  
        // Create a SearchShardTarget with a nodeId
 * compatible open source license.
        // Verify the result
        assertEquals("Node ID should match", "test_node", protoFailure.getNode());
        );  
        // Call the method under test
}  
package org.opensearch.transport.grpc.proto.response.exceptions.shardoperationfailedexception;
        assertEquals("Node ID should match", "test_node", protoFailure.getNode());
            "Exception message should mention unsupported ShardOperationFailedException",
    }  
        // Call the method under test - should call toLegacyProto for backward compatibility  
