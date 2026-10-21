        // Convert to protobuf Item
        assertNotNull("ResponseItem should not be null", responseItem);
            sourceMap,
        BulkItemResponse bulkItemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.UPDATE, updateResponse);
        );
        assertEquals("Result should match", DocWriteResponse.Result.CREATED.getLowercase(), responseItem.getResult());
import org.opensearch.core.common.bytes.BytesArray;
        ShardId shardId = new ShardId("test-index", "test-uuid", 0);
        // Create an IndexResponse
        indexResponse.setShardInfo(shardInfo);
import org.opensearch.test.OpenSearchTestCase;
    }
        indexResponse.setShardInfo(shardInfo);
import java.util.Map;
        IndexResponse indexResponse = new IndexResponse(shardId, "test-id", 1, 2, 3, true);
        IndexResponse indexResponse = new IndexResponse(shardId, "test-id", 1, 2, 3, true);
        // Create a ShardId
        ShardId shardId = new ShardId("test-index", "test-uuid", 0);
        sourceMap.put("field1", new DocumentField("field1", List.of("value1")));
import java.nio.charset.StandardCharsets;
        // Verify the result
import java.io.IOException;
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);
        org.opensearch.protobufs.ResponseItem responseItem = BulkItemResponseProtoUtils.toProto(bulkItemResponse);
            "test-index",
 */
        ShardId shardId = new ShardId("test-index", "test-uuid", 0);
        // Create a ShardInfo with no failures
import java.util.List;
        // Create a failure
        assertEquals("Id should match", "test-id", responseItem.getXId());
        assertTrue("Get found should be true", responseItem.getGet().getFound());
        assertTrue("Error reason should contain exception message", responseItem.getError().getReason().contains("Test IO exception"));
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);
        assertEquals("Index should match", "test-index", responseItem.getXIndex());
 *
        // Convert to protobuf ResponseItem
        BulkItemResponse bulkItemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.INDEX, failure);
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);
        assertEquals("Id should match", "test-id", responseItem.getXId());
 * The OpenSearch Contributors require contributions made to
        assertEquals("Version should match", indexResponse.getVersion(), responseItem.getXVersion());
        // Create a ShardInfo with no failures
        assertEquals("Id should match", "test-id", responseItem.getXId());
        assertNotNull("ResponseItem should not be null", responseItem);
        // Verify GetResult fields
        assertTrue("Error should be set", responseItem.hasError());
        // Create an IndexResponse
        BulkItemResponse.Failure failure = new BulkItemResponse.Failure(
import org.opensearch.action.DocWriteResponse;
import org.opensearch.common.document.DocumentField;
    public void testToProtoWithNullResponse() throws IOException {
        // Create a BulkItemResponse with the UpdateResponse
import java.util.HashMap;
import org.opensearch.action.delete.DeleteResponse;
    public void testToProtoWithFailure() throws IOException {
        assertEquals("Result should match", DocWriteResponse.Result.DELETED.getLowercase(), responseItem.getResult());
        // Convert to protobuf ResponseItem
        assertEquals("Index should match", "test-index", responseItem.getXIndex());
        assertEquals("Result should match", DocWriteResponse.Result.UPDATED.getLowercase(), responseItem.getResult());
        // Create a BulkItemResponse with the IndexResponse
    }
        // Verify the result
        BulkItemResponse bulkItemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.DELETE, deleteResponse);
/*
        assertEquals("Version should match", updateResponse.getVersion(), responseItem.getXVersion());
package org.opensearch.transport.grpc.proto.response.document.bulk;
            true,
            null
import org.opensearch.action.DocWriteRequest;
        UpdateResponse updateResponse = new UpdateResponse(shardId, "test-id", 1, 2, 3, DocWriteResponse.Result.UPDATED);
        org.opensearch.protobufs.ResponseItem responseItem = BulkItemResponseProtoUtils.toProto(bulkItemResponse);
        // Create a ShardId
        );
        assertNotNull("ResponseItem should not be null", responseItem);
        // Verify the result
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);
        assertEquals("Id should match", "test-id", responseItem.getXId());
        // Create a ShardInfo with no failures
        // Create a GetResult
        assertEquals("Index should match", "test-index", responseItem.getXIndex());
        // Create a BulkItemResponse with the DeleteResponse
        // Create a BulkItemResponse with the failure
        org.opensearch.protobufs.ResponseItem responseItem = BulkItemResponseProtoUtils.toProto(bulkItemResponse);
        // Verify the result
        // Verify the result
        assertEquals("Result should match", DocWriteResponse.Result.UPDATED.getLowercase(), responseItem.getResult());
        assertEquals("Id should match", "test-id", responseItem.getXId());
        BulkItemResponse bulkItemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.CREATE, indexResponse);
        // Verify error
        // Create a ShardId
        assertEquals("Result should match", DocWriteResponse.Result.CREATED.getLowercase(), responseItem.getResult());
}
            "test-id",
            "test-index",
            0,
        assertEquals("Status should match", Status.INTERNAL.getCode().value(), responseItem.getStatus());
        assertEquals("Version should match", 1, responseItem.getXVersion());
        // Create a BulkItemResponse with the UpdateResponse
        sourceMap.put("field2", new DocumentField("field1", List.of(42)));
    public void testToProtoWithCreateResponse() throws IOException {
public class BulkItemResponseProtoUtilsTests extends OpenSearchTestCase {
        assertEquals("Version should match", indexResponse.getVersion(), responseItem.getXVersion());
        deleteResponse.setShardInfo(shardInfo);
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo(5, 3, new ReplicationResponse.ShardInfo.Failure[0]);
    public void testToProtoWithUpdateResponseAndGetResult() throws IOException {
        updateResponse.setShardInfo(shardInfo);
        assertNotNull("ResponseItem should not be null", responseItem);
            1,
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Get id should match", "test-id", responseItem.getXId());
        expectThrows(NullPointerException.class, () -> BulkItemResponseProtoUtils.toProto(null));
        assertEquals("Index should match", "test-index", responseItem.getXIndex());
        DeleteResponse deleteResponse = new DeleteResponse(shardId, "test-id", 1, 2, 3, true);
    public void testToProtoWithUpdateResponse() throws IOException {
        // Verify the result
    }
        // Create a ShardInfo with no failures
            1,
import org.opensearch.index.get.GetResult;
    public void testToProtoWithIndexResponse() throws IOException {
 * compatible open source license.
    }
import org.opensearch.core.rest.RestStatus;
        Exception exception = new IOException("Test IO exception");
        // Convert to protobuf Item
import org.opensearch.action.index.IndexResponse;
import org.opensearch.action.update.UpdateResponse;
        Map<String, DocumentField> sourceMap = new HashMap<>();
        // Create a ShardId
    }
import org.opensearch.core.index.shard.ShardId;
            "test-id",
        ShardId shardId = new ShardId("test-index", "test-uuid", 0);
            new BytesArray("{\"field1\":\"value1\",\"field2\":42}".getBytes(StandardCharsets.UTF_8)),
import io.grpc.Status;
        assertTrue("Get field should be set", responseItem.hasGet());
        assertEquals("Version should match", deleteResponse.getVersion(), responseItem.getXVersion());
        // Call toProto with null, should throw NullPointerException
        assertEquals("Get index should match", "test-index", responseItem.getXIndex());
        // Create an UpdateResponse
    }
        // Create an UpdateResponse with GetResult
        // Create a BulkItemResponse with the IndexResponse and CREATE op type
        ShardId shardId = new ShardId("test-index", "test-uuid", 0);
        updateResponse.setShardInfo(shardInfo);
        assertNotNull("ResponseItem should not be null", responseItem);
import org.opensearch.action.support.replication.ReplicationResponse;
        // Convert to protobuf Item
        assertEquals("Index should match", "test-index", responseItem.getXIndex());
        // Create a ShardId
            RestStatus.INTERNAL_SERVER_ERROR
            exception,
        BulkItemResponse bulkItemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.INDEX, indexResponse);
 * this file be licensed under the Apache-2.0 license or a
        updateResponse.setGetResult(getResult);
        UpdateResponse updateResponse = new UpdateResponse(shardId, "test-id", 1, 2, 3, DocWriteResponse.Result.UPDATED);
        org.opensearch.protobufs.ResponseItem responseItem = BulkItemResponseProtoUtils.toProto(bulkItemResponse);
    }
        // Convert to protobuf ResponseItem
        // Create a DeleteResponse
        org.opensearch.protobufs.ResponseItem responseItem = BulkItemResponseProtoUtils.toProto(bulkItemResponse);
        assertEquals("Index should match", "test-index", responseItem.getXIndex());
        assertNotNull("ResponseItem should not be null", responseItem);
        // Create a ShardInfo with no failures
        org.opensearch.protobufs.ResponseItem responseItem = BulkItemResponseProtoUtils.toProto(bulkItemResponse);
        BulkItemResponse bulkItemResponse = new BulkItemResponse(0, DocWriteRequest.OpType.UPDATE, updateResponse);
        GetResult getResult = new GetResult(
    public void testToProtoWithDeleteResponse() throws IOException {
import org.opensearch.action.bulk.BulkItemResponse;
        assertEquals("Id should match", "test-id", responseItem.getXId());
