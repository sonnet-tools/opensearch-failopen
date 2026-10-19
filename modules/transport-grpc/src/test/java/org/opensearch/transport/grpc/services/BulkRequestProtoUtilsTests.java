        return BulkRequest.newBuilder().addBulkRequestBody(requestBody).build();
        BulkRequestBody requestBody = BulkRequestBody.newBuilder()
        assertEquals("Should have the correct index", "test-index", docWriteRequest.index());
    }  
        assertEquals("Should have 1 request", 1, bulkRequest.numberOfActions());  
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOp).build())
import org.opensearch.action.index.IndexRequest;
            .build();
        // Verify the converted request
            .addBulkRequestBody(requestBody)
 * compatible open source license.
import org.opensearch.transport.client.node.NodeClient;  
import org.opensearch.action.DocWriteRequest;
import org.mockito.Mock;  
        // Verify the converted request
            .setOperationContainer(OperationContainer.newBuilder().setDelete(deleteOp).build())
        DocWriteRequest<?> docWriteRequest = bulkRequest.requests().get(0);
        return BulkRequest.newBuilder().addBulkRequestBody(requestBody).build();
            .setOperationContainer(OperationContainer.newBuilder().setCreate(writeOp).build())
        BulkRequestBody requestBody = BulkRequestBody.newBuilder()
    }  
 *
            .setRefresh(org.opensearch.protobufs.Refresh.REFRESH_TRUE)  
        // Verify the converted request
    private BulkRequest createBulkRequestWithCreateOperation() {
        assertEquals("Should have the correct pipeline", "test-pipeline", ((IndexRequest) docWriteRequest).getPipeline());  
    public void testPrepareRequestWithDeleteOperation() throws IOException {  
        DocWriteRequest<?> docWriteRequest = bulkRequest.requests().get(0);  
public class BulkRequestProtoUtilsTests extends OpenSearchTestCase {  
/*  
    private BulkRequest createBulkRequestWithDeleteOperation() {
        UpdateOperation updateOp = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();  
        BulkRequest request = createBulkRequestWithUpdateOperation();  
        assertEquals("Should have 1 request", 1, bulkRequest.numberOfActions());
        assertEquals("Should have the correct index", "test-index", docWriteRequest.index());
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.protobufs.DeleteOperation;  
 * this file be licensed under the Apache-2.0 license or a
        MockitoAnnotations.openMocks(this);
        assertEquals("Should have the correct id", "test-id", docWriteRequest.id());  
    }  
        // Convert to OpenSearch BulkRequest
        // Verify the update request
    }
        assertEquals("Should have 1 request", 1, bulkRequest.numberOfActions());  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.protobufs.BulkRequest;
        // Verify the create request
            .build();  
    public void testPrepareRequestWithIndexOperation() throws IOException {
        // Convert to OpenSearch BulkRequest
import org.opensearch.action.support.WriteRequest;  
        assertEquals("Should have the correct id", "test-id", docWriteRequest.id());
import org.opensearch.protobufs.IndexOperation;
        WriteOperation writeOp = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();  
        // Create a Protocol Buffer BulkRequest with an update operation
        assertEquals("Should have the correct index", "test-index", docWriteRequest.index());
            .build();  
        assertEquals("Should have the correct id", "test-id", docWriteRequest.id());
package org.opensearch.transport.grpc.services;
import org.junit.Before;
import org.opensearch.protobufs.BulkRequestBody;
    @Mock
        assertEquals("Should have 1 request", 1, bulkRequest.numberOfActions());  
        // Create a Protocol Buffer BulkRequest with a delete operation
import org.opensearch.protobufs.WriteOperation;
    public void testPrepareRequestWithCreateOperation() throws IOException {
}
        org.opensearch.action.bulk.BulkRequest bulkRequest = BulkRequestProtoUtils.prepareRequest(request);  
 * The OpenSearch Contributors require contributions made to  
    public void setup() {  
import org.opensearch.protobufs.OperationContainer;
 */  
        org.opensearch.action.bulk.BulkRequest bulkRequest = BulkRequestProtoUtils.prepareRequest(request);
        DocWriteRequest<?> docWriteRequest = bulkRequest.requests().get(0);  
        // Verify the converted request
        // Create a Protocol Buffer BulkRequest with a create operation
    @Before
            .setPipeline("test-pipeline")
            .build();
    }  
        // Verify the index request
import java.io.IOException;
    public void testPrepareRequestWithUpdateOperation() throws IOException {
    }
        DeleteOperation deleteOp = DeleteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();  
        // Verify the delete request
import org.opensearch.protobufs.UpdateOperation;  
        BulkRequest request = createBulkRequestWithIndexOperation();  
import org.mockito.MockitoAnnotations;
        // The actual refresh policy is IMMEDIATE since we set REFRESH_TRUE
    // Helper methods to create test requests
        // Convert to OpenSearch BulkRequest
        assertEquals("Should have the correct id", "test-id", docWriteRequest.id());
        return BulkRequest.newBuilder()
            .build();  
import org.opensearch.transport.grpc.proto.request.document.bulk.BulkRequestProtoUtils;
        BulkRequestBody requestBody = BulkRequestBody.newBuilder()  
        assertEquals("Should have the correct refresh policy", WriteRequest.RefreshPolicy.IMMEDIATE, bulkRequest.getRefreshPolicy());
            .setOperationContainer(OperationContainer.newBuilder().setIndex(indexOp).build())
    private NodeClient client;  
    private BulkRequest createBulkRequestWithIndexOperation() {
        assertEquals("Should have the correct index", "test-index", docWriteRequest.index());  
    }
        IndexOperation indexOp = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        DocWriteRequest<?> docWriteRequest = bulkRequest.requests().get(0);
        return BulkRequest.newBuilder().addBulkRequestBody(requestBody).build();
    }
        BulkRequest request = createBulkRequestWithDeleteOperation();
        assertEquals("Should be a CREATE operation", DocWriteRequest.OpType.CREATE, docWriteRequest.opType());
        org.opensearch.action.bulk.BulkRequest bulkRequest = BulkRequestProtoUtils.prepareRequest(request);  
    private BulkRequest createBulkRequestWithUpdateOperation() {
        BulkRequest request = createBulkRequestWithCreateOperation();  
        // Convert to OpenSearch BulkRequest
        assertEquals("Should be an INDEX operation", DocWriteRequest.OpType.INDEX, docWriteRequest.opType());  
    }  
        org.opensearch.action.bulk.BulkRequest bulkRequest = BulkRequestProtoUtils.prepareRequest(request);  
        // Create a Protocol Buffer BulkRequest with an index operation
        BulkRequestBody requestBody = BulkRequestBody.newBuilder()
