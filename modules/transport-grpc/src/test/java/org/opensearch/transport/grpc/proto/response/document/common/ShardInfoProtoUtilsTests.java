        Exception exception2 = new IllegalArgumentException("Test argument exception");
        failuresList.add(new ReplicationResponse.ShardInfo.Failure(shardId2, "node1", exception2, RestStatus.BAD_REQUEST, false));
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, failures);  
        List<ReplicationResponse.ShardInfo.Failure> failuresList = new ArrayList<>();
import java.io.IOException;
        );  
 * compatible open source license.
    public void testToProtoWithFailures() throws IOException {
        assertEquals("Total should match", 5, protoShardInfo.getTotal());
        assertTrue(  
        assertNotNull("ShardInfo should not be null", protoShardInfo);
    }
 *
    public void testToProtoWithNullShardInfo() throws IOException {  
package org.opensearch.transport.grpc.proto.response.document.common;
        assertEquals("Second failure index should match", "index2", protoShardInfo.getFailures(1).getIndex());
        assertEquals("Failed should match", shardInfo.getFailed(), protoShardInfo.getFailed());
            protoShardInfo.getFailures(1).getReason().getReason().contains("Test argument exception")  
        assertEquals("First failure index should match", "index1", protoShardInfo.getFailures(0).getIndex());
        );
        assertEquals("Second failure shard should match", 2, protoShardInfo.getFailures(1).getShard());  
        assertNotNull("ShardInfo should not be null", protoShardInfo);  
        assertEquals("Second failure status should match", "BAD_REQUEST", protoShardInfo.getFailures(1).getStatus());
            protoShardInfo.getFailures(0).getReason().getReason().contains("Test IO exception")
        // Convert to protobuf ShardInfo
    public void testToProtoWithNoFailures() throws IOException {
        assertEquals("Failures list should be empty", 0, protoShardInfo.getFailuresCount());
            "Second failure reason should contain exception message",
        failuresList.add(new ReplicationResponse.ShardInfo.Failure(shardId, "node0", exception1, RestStatus.INTERNAL_SERVER_ERROR, true));
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.core.index.Index;
        // Add a failure with an exception
}
        Exception exception1 = new IOException("Test IO exception");  
        assertFalse("Second failure primary flag should be false", protoShardInfo.getFailures(1).getPrimary());  
        assertEquals("First failure shard should match", 1, protoShardInfo.getFailures(0).getShard());
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);
        // Add another failure with a different exception  
    }  
        // Verify first failure  
 * this file be licensed under the Apache-2.0 license or a
        ShardId shardId = new ShardId(new Index("index1", "1"), 1);
        // Verify second failure
        ShardInfo protoShardInfo = ShardInfoProtoUtils.toProto(shardInfo);  
        // Verify the result  
 */  
        // Create a ShardInfo with no failures  
        assertEquals("Total should match", 5, protoShardInfo.getTotal());
import org.opensearch.protobufs.ShardInfo;
 * The OpenSearch Contributors require contributions made to  
        ShardId shardId2 = new ShardId(new Index("index2", "2"), 2);  
/*  
            "First failure reason should contain exception message",
        ShardInfo protoShardInfo = ShardInfoProtoUtils.toProto(shardInfo);
import org.opensearch.core.rest.RestStatus;
public class ShardInfoProtoUtilsTests extends OpenSearchTestCase {  
        ReplicationResponse.ShardInfo.Failure[] failures = failuresList.toArray(new ReplicationResponse.ShardInfo.Failure[0]);
        assertTrue(
        assertEquals("Successful should match", 3, protoShardInfo.getSuccessful());  
        assertEquals("Failures list should have 2 entries", 2, protoShardInfo.getFailuresCount());
import org.opensearch.action.support.replication.ReplicationResponse;
        assertTrue("First failure primary flag should be true", protoShardInfo.getFailures(0).getPrimary());
        assertEquals("First failure status should match", "INTERNAL_SERVER_ERROR", protoShardInfo.getFailures(0).getStatus());
        // Verify the result
        // Create a ShardInfo with failures
        assertEquals("Failed should match", 2, protoShardInfo.getFailed());  
        expectThrows(NullPointerException.class, () -> ShardInfoProtoUtils.toProto(null));
import java.util.ArrayList;  
import org.opensearch.core.index.shard.ShardId;  
        assertEquals("Successful should match", 3, protoShardInfo.getSuccessful());
    }  
        // Create failures  
        // Call toProto with null, should throw NullPointerException
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
        // Convert to protobuf ShardInfo  
