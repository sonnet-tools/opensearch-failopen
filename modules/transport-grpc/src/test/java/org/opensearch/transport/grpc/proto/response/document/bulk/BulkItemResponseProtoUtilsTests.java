        updateResponse.setShardInfo(shardInfo);
        // Verify the result
        // Verify GetResult fields
        assertEquals("Id should match", "test-id", responseItem.getXId());
        assertEquals("Version should match", deleteResponse.getVersion(), responseItem.getXVersion());  
        BulkItemResponse bulkItemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.INDEX, failure);
            1,
import org.opensearch.action.DocWriteResponse;
        // Create a BulkItemResponse with the UpdateResponse
        assertEquals("Index should match", "test-index", responseItem.getXIndex());
        // Create a ShardInfo with no failures
        );
    }  
            1,  
        // Create a ShardInfo with no failures  
        // Create a ShardInfo with no failures
        // Create a ShardId  
        // Create a BulkItemResponse with the failure
        BulkItemResponse bulkItemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.DELETE, deleteResponse);  
            null
import org.opensearch.core.rest.RestStatus;
    public void testToProtoWithNullResponse() throws IOException {  
import org.opensearch.index.get.GetResult;  
    }
 *
import java.util.Map;
    }  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Index should match", "test-index", responseItem.getXIndex());  
        assertEquals("Result should match", DocWriteResponse.Result.UPDATED.getLowercase(), responseItem.getResult());  
import org.opensearch.test.OpenSearchTestCase;
        BulkItemResponse bulkItemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.INDEX, indexResponse);
            "test-index",
        ShardId shardId = new ShardId("test-index", "test-uuid", 0);
        // Create a BulkItemResponse with the IndexResponse  
            new BytesArray("{\"field1\":\"value1\",\"field2\":42}".getBytes(StandardCharsets.UTF_8)),  
        // Convert to protobuf Item
        ShardId shardId = new ShardId("test-index", "test-uuid", 0);  
        org.opensearch.protobufs.ResponseItem responseItem = BulkItemResponseProtoUtils.toProto(bulkItemResponse);  
        UpdateResponse updateResponse = new UpdateResponse(shardId, "test-id", 1, 2, 3, DocWriteResponse.Result.UPDATED);  
        sourceMap.put("field1", new DocumentField("field1", List.of("value1")));
        org.opensearch.protobufs.ResponseItem responseItem = BulkItemResponseProtoUtils.toProto(bulkItemResponse);
        assertTrue("Error reason should contain exception message", responseItem.getError().getReason().contains("Test IO exception"));  
        // Verify the result
        );  
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);
        // Create a BulkItemResponse with the DeleteResponse
import java.nio.charset.StandardCharsets;
        // Create a ShardId
public class BulkItemResponseProtoUtilsTests extends OpenSearchTestCase {
        DeleteResponse deleteResponse = new DeleteResponse(shardId, "test-id", 1, 2, 3, true);
import org.opensearch.action.support.replication.ReplicationResponse;  
        assertEquals("Id should match", "test-id", responseItem.getXId());
            sourceMap,
        // Create a ShardInfo with no failures
 * compatible open source license.
        assertEquals("Result should match", DocWriteResponse.Result.DELETED.getLowercase(), responseItem.getResult());
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);  
        org.opensearch.protobufs.ResponseItem responseItem = BulkItemResponseProtoUtils.toProto(bulkItemResponse);
    public void testToProtoWithUpdateResponse() throws IOException {
        // Create a ShardId
        indexResponse.setShardInfo(shardInfo);
import org.opensearch.action.delete.DeleteResponse;
        org.opensearch.protobufs.ResponseItem responseItem = BulkItemResponseProtoUtils.toProto(bulkItemResponse);
        assertEquals("Result should match", DocWriteResponse.Result.CREATED.getLowercase(), responseItem.getResult());  
        IndexResponse indexResponse = new IndexResponse(shardId, "test-id", 1, 2, 3, true);
        expectThrows(NullPointerException.class, () -> BulkItemResponseProtoUtils.toProto(null));
        // Convert to protobuf Item  
import org.opensearch.action.index.IndexResponse;
import org.opensearch.action.update.UpdateResponse;
    public void testToProtoWithIndexResponse() throws IOException {
import org.opensearch.core.index.shard.ShardId;
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);  
        // Convert to protobuf ResponseItem  
    public void testToProtoWithDeleteResponse() throws IOException {  
            exception,  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.bulk.BulkItemResponse;  
        assertEquals("Get index should match", "test-index", responseItem.getXIndex());
import org.opensearch.core.common.bytes.BytesArray;  
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);
        GetResult getResult = new GetResult(
 * this file be licensed under the Apache-2.0 license or a
import io.grpc.Status;  
        // Create an UpdateResponse
        Exception exception = new IOException("Test IO exception");
        // Create a ShardId  
        assertEquals("Version should match", 1, responseItem.getXVersion());
        assertNotNull("ResponseItem should not be null", responseItem);
            0,
        // Create a BulkItemResponse with the IndexResponse and CREATE op type
        // Call toProto with null, should throw NullPointerException
        assertEquals("Id should match", "test-id", responseItem.getXId());  
import org.opensearch.common.document.DocumentField;
        assertEquals("Id should match", "test-id", responseItem.getXId());
            "test-id",
        BulkItemResponse bulkItemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.CREATE, indexResponse);
        // Convert to protobuf ResponseItem
        // Convert to protobuf Item
        // Create an IndexResponse  
            "test-id",
import org.opensearch.action.DocWriteRequest;
        // Verify the result  
        BulkItemResponse.Failure failure = new BulkItemResponse.Failure(  
        // Verify error
    }
        org.opensearch.protobufs.ResponseItem responseItem = BulkItemResponseProtoUtils.toProto(bulkItemResponse);
        assertEquals("Version should match", indexResponse.getVersion(), responseItem.getXVersion());
 */  
        // Verify the result
    public void testToProtoWithCreateResponse() throws IOException {
        // Create an UpdateResponse with GetResult
        // Create a ShardInfo with no failures  
        // Create an IndexResponse
    }
        assertEquals("Result should match", DocWriteResponse.Result.UPDATED.getLowercase(), responseItem.getResult());
        // Create a BulkItemResponse with the UpdateResponse  
        assertTrue("Get field should be set", responseItem.hasGet());  
        assertNotNull("ResponseItem should not be null", responseItem);
        assertTrue("Error should be set", responseItem.hasError());
package org.opensearch.transport.grpc.proto.response.document.bulk;
        assertEquals("Id should match", "test-id", responseItem.getXId());  
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);
        assertEquals("Version should match", indexResponse.getVersion(), responseItem.getXVersion());
        updateResponse.setGetResult(getResult);
        assertTrue("Get found should be true", responseItem.getGet().getFound());  
        deleteResponse.setShardInfo(shardInfo);  
        IndexResponse indexResponse = new IndexResponse(shardId, "test-id", 1, 2, 3, true);  
        // Create a GetResult  
        assertNotNull("ResponseItem should not be null", responseItem);  
        assertEquals("Index should match", "test-index", responseItem.getXIndex());  
        assertEquals("Result should match", DocWriteResponse.Result.CREATED.getLowercase(), responseItem.getResult());
        ShardId shardId = new ShardId("test-index", "test-uuid", 0);
    public void testToProtoWithFailure() throws IOException {  
    }
        assertEquals("Status should match", Status.INTERNAL.getCode().value(), responseItem.getStatus());
        // Create a ShardId
import java.util.List;  
        ShardId shardId = new ShardId("test-index", "test-uuid", 0);
    public void testToProtoWithUpdateResponseAndGetResult() throws IOException {
            true,
        // Convert to protobuf ResponseItem
        // Create a DeleteResponse
        // Verify the result  
        BulkItemResponse bulkItemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.UPDATE, updateResponse);
        assertEquals("Index should match", "test-index", responseItem.getXIndex());  
        assertNotNull("ResponseItem should not be null", responseItem);
        sourceMap.put("field2", new DocumentField("field1", List.of(42)));  
        org.opensearch.protobufs.ResponseItem responseItem = BulkItemResponseProtoUtils.toProto(bulkItemResponse);
        assertNotNull("ResponseItem should not be null", responseItem);
        Map<String, DocumentField> sourceMap = new HashMap<>();
        assertNotNull("ResponseItem should not be null", responseItem);
        ShardId shardId = new ShardId("test-index", "test-uuid", 0);  
            RestStatus.INTERNAL_SERVER_ERROR
import java.util.HashMap;
        assertEquals("Id should match", "test-id", responseItem.getXId());
        indexResponse.setShardInfo(shardInfo);
        assertEquals("Get id should match", "test-id", responseItem.getXId());
        assertEquals("Index should match", "test-index", responseItem.getXIndex());
        updateResponse.setShardInfo(shardInfo);
        // Create a failure
        BulkItemResponse bulkItemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.UPDATE, updateResponse);
}
    }  
import java.io.IOException;  
/*  
        // Verify the result
            "test-index",  
        assertEquals("Index should match", "test-index", responseItem.getXIndex());
        assertEquals("Version should match", updateResponse.getVersion(), responseItem.getXVersion());
        UpdateResponse updateResponse = new UpdateResponse(shardId, "test-id", 1, 2, 3, DocWriteResponse.Result.UPDATED);  
