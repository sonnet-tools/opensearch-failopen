    public void testToProtoWithSuccessfulResponse() throws IOException {
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo();
import org.opensearch.action.bulk.BulkResponse;  
        Index index = new Index("test-index", "_na_");
        assertEquals("Should have the correct ingest took time", 50, protoResponse.getIngestTook());
        assertFalse("Should not have errors", protoResponse.getErrors());
            new BulkItemResponse.Failure("test-index", "test-id", exception)
    public void testToProtoWithIngestTook() throws IOException {
    }
            0,
        indexResponse.setShardInfo(shardInfo);  
import org.opensearch.transport.grpc.proto.response.document.bulk.BulkResponseProtoUtils;  
        assertEquals("Should have the correct took time", 100, protoResponse.getTook());  
import org.opensearch.action.bulk.BulkItemResponse;
        ShardId shardId = new ShardId(index, 1);  
        org.opensearch.protobufs.ResponseItem responseItem = item.getIndex(); // Since this is an INDEX operation  
}  
        assertEquals("Should have the correct took time", 100, protoResponse.getTook());  
import org.opensearch.test.OpenSearchTestCase;
/*  
        assertTrue("Should have errors", protoResponse.getErrors());
import org.opensearch.core.index.shard.ShardId;
        org.opensearch.protobufs.BulkResponse protoResponse = BulkResponseProtoUtils.toProto(bulkResponse);  
import org.opensearch.action.index.IndexResponse;
        org.opensearch.protobufs.Item item = protoResponse.getItems(0);
        // Create a failed BulkResponse
        responses[0] = new BulkItemResponse(
        // Verify the conversion  
        // Create a successful BulkResponse  
        assertEquals("Should have the correct id", "test-id", responseItem.getXId());  
        Exception exception = new Exception("Test failure");  
        // Convert to Protocol Buffer
        // Set ingest took time to 50ms
 *
public class BulkResponseProtoUtilsTests extends OpenSearchTestCase {  
        assertEquals("Should have the correct took time", 100, protoResponse.getTook());
        BulkResponse bulkResponse = new BulkResponse(responses, 100);  
        org.opensearch.protobufs.BulkResponse protoResponse = BulkResponseProtoUtils.toProto(bulkResponse);
import io.grpc.Status;
            DocWriteRequest.OpType.INDEX,  
import org.opensearch.core.index.Index;  
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo();
        assertEquals("Should have 1 item", 1, protoResponse.getItemsCount());  
        assertTrue("Should have error", responseItem.getError().getReason().length() > 0);
        // Verify the conversion
        // Create a BulkResponse with ingest took time
 */  
import org.opensearch.action.support.replication.ReplicationResponse;
        BulkItemResponse[] responses = new BulkItemResponse[1];
    }
        ShardId shardId = new ShardId(index, 1);
        // Verify the item response
 * compatible open source license.
        // Verify the conversion
        org.opensearch.protobufs.Item item = protoResponse.getItems(0);  
        org.opensearch.protobufs.ResponseItem responseItem = item.getIndex(); // Since this is an INDEX operation
        indexResponse.setShardInfo(shardInfo);
    }
        assertEquals("Should have the correct id", "test-id", responseItem.getXId());
        assertEquals("Should have the correct index", "test-index", responseItem.getXIndex());
        IndexResponse indexResponse = new IndexResponse(shardId, "test-id", 1, 1, 1, true);
        assertEquals("Should have 1 item", 1, protoResponse.getItemsCount());
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Should have the correct status", Status.OK.getCode().value(), responseItem.getStatus());  
        BulkResponse bulkResponse = new BulkResponse(responses, 100, 50);  
        // Convert to Protocol Buffer
        responses[0] = new BulkItemResponse(0, DocWriteRequest.OpType.INDEX, indexResponse);
        org.opensearch.protobufs.BulkResponse protoResponse = BulkResponseProtoUtils.toProto(bulkResponse);  
        Index index = new Index("test-index", "_na_");
        BulkResponse bulkResponse = new BulkResponse(responses, 100);
        // Convert to Protocol Buffer  
        BulkItemResponse[] responses = new BulkItemResponse[1];
        IndexResponse indexResponse = new IndexResponse(shardId, "test-id", 1, 1, 1, true);  
        );
        responses[0] = new BulkItemResponse(0, DocWriteRequest.OpType.INDEX, indexResponse);  
        BulkItemResponse[] responses = new BulkItemResponse[1];  
        assertEquals("Should have the correct index", "test-index", responseItem.getXIndex());
package org.opensearch.transport.grpc.proto.response;
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.DocWriteRequest;
 * SPDX-License-Identifier: Apache-2.0
    public void testToProtoWithFailedResponse() throws IOException {  
        // Verify the item response
