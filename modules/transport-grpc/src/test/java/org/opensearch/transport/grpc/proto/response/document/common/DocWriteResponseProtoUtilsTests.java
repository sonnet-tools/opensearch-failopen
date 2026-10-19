        assertEquals("Index should match", "test-index", responseItem.getXIndex());
        IndexResponse indexResponse = new IndexResponse(shardId, "", 1, 2, 3, true);
    public void testToProtoWithEmptyId() throws IOException {  
        expectThrows(NullPointerException.class, () -> DocWriteResponseProtoUtils.toProto(null));  
public class DocWriteResponseProtoUtilsTests extends OpenSearchTestCase {
        // Verify the result
        // Create an IndexResponse with empty ID
        ResponseItem responseItem = responseItemBuilder.build();  
        // Create a ShardInfo with no failures
        assertEquals("Result should match", DocWriteResponse.Result.CREATED.getLowercase(), responseItem.getResult());
        assertFalse("Id should not be set", responseItem.hasXId());  
package org.opensearch.transport.grpc.proto.response.document.common;
        ResponseItem responseItem = responseItemBuilder.build();  
        ResponseItem.Builder responseItemBuilder = DocWriteResponseProtoUtils.toProto(indexResponse);  
        assertEquals("Total shards should match", 5, responseItem.getXShards().getTotal());
        // Create a ShardId
        assertEquals("Failed shards should match", indexResponse.getShardInfo().getFailed(), responseItem.getXShards().getFailed());  
    public void testToProtoWithIndexResponse() throws IOException {  
 */  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
    public void testToProtoWithNoSeqNo() throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
        ShardId shardId = new ShardId("test-index", "test-uuid", 0);
        // Convert to protobuf ResponseItem.Builder  
import org.opensearch.action.index.IndexResponse;
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);
        // Create a ShardId
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);
        ShardId shardId = new ShardId("test-index", "test-uuid", 0);
        ResponseItem.Builder responseItemBuilder = DocWriteResponseProtoUtils.toProto(indexResponse);  
    }
        // Verify sequence number and primary term
        IndexResponse indexResponse = new IndexResponse(shardId, "test-id", -1, 1, 3, true);
import org.opensearch.test.OpenSearchTestCase;  
        indexResponse.setShardInfo(shardInfo);  
        assertTrue("ForcedRefresh should be true", responseItem.getForcedRefresh());
    }
        assertEquals("Id should match", "test-id", responseItem.getXId());
import org.opensearch.action.support.replication.ReplicationResponse;  
        assertNotNull("ResponseItem.Builder should not be null", responseItemBuilder);  
        indexResponse.setForcedRefresh(true);
        // Create a ShardInfo with no failures
        // Verify sequence number and primary term are not set
        indexResponse.setShardInfo(shardInfo);  
        // Convert to protobuf ResponseItem.Builder
        assertEquals("SeqNo should match", indexResponse.getSeqNo(), responseItem.getXSeqNo());
        // Verify ShardInfo
        // Verify basic fields  
        // Create an IndexResponse with negative sequence number (unassigned)
import org.opensearch.protobufs.ResponseItem;
        assertEquals("Version should match", indexResponse.getVersion(), responseItem.getXVersion());  
        // Create a ShardInfo with no failures
        // Build the ResponseItem to verify its contents  
    }
        assertEquals("PrimaryTerm should match", indexResponse.getPrimaryTerm(), responseItem.getXPrimaryTerm());  
import org.opensearch.core.index.shard.ShardId;
        assertFalse("PrimaryTerm should not be set", responseItem.hasXPrimaryTerm());
 * compatible open source license.
import org.opensearch.action.DocWriteResponse;
        assertFalse("SeqNo should not be set", responseItem.hasXSeqNo());  
        // Convert to protobuf ResponseItem.Builder
    }
        ResponseItem.Builder responseItemBuilder = DocWriteResponseProtoUtils.toProto(indexResponse);
        // Create a ShardId
/*  
        ResponseItem responseItem = responseItemBuilder.build();
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);
    public void testToProtoWithNullResponse() throws IOException {
        // Build the ResponseItem to verify its contents
        assertNotNull("ResponseItem.Builder should not be null", responseItemBuilder);  
        IndexResponse indexResponse = new IndexResponse(shardId, "test-id", 1, 2, 3, true);
        assertNotNull("ResponseItem.Builder should not be null", responseItemBuilder);
        indexResponse.setShardInfo(shardInfo);  
 * SPDX-License-Identifier: Apache-2.0
        // Verify the result
        // Call toProto with null, should throw NullPointerException
        ShardId shardId = new ShardId("test-index", "test-uuid", 0);
        // Create an IndexResponse
        // Verify the result  
}
        assertEquals("Successful shards should match", 3, responseItem.getXShards().getSuccessful());
 *
        // Verify ID is set to null value
        // Build the ResponseItem to verify its contents
        assertNotNull("ShardInfo should not be null", responseItem.getXShards());  
