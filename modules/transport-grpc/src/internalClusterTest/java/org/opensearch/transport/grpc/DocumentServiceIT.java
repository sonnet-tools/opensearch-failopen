 *
 */  
import org.opensearch.protobufs.BulkRequestBody;
 */  
            IndexOperation indexOp = IndexOperation.newBuilder().setXIndex(indexName).setXId("1").build();  
            assertNotNull("Bulk response should not be null", bulkResponse);
            ManagedChannel channel = client.getChannel();
 * SPDX-License-Identifier: Apache-2.0
            BulkResponse bulkResponse = documentStub.bulk(bulkRequest);
            // Verify the document is searchable
     * Tests the bulk operation via gRPC.
            BulkRequest bulkRequest = BulkRequest.newBuilder().addBulkRequestBody(requestBody).build();
import org.opensearch.protobufs.IndexOperation;
                .setObject(com.google.protobuf.ByteString.copyFromUtf8(DEFAULT_DOCUMENT_SOURCE))
        try (NettyGrpcClient client = createGrpcClient()) {  
import org.opensearch.protobufs.services.DocumentServiceGrpc;
 * compatible open source license.
            // Verify the response  
            // Execute the bulk request  
import org.opensearch.protobufs.BulkResponse;  
    }
            // Create a bulk request with an index operation
import org.opensearch.protobufs.BulkRequest;
import org.opensearch.transport.grpc.ssl.NettyGrpcClient;  
        String indexName = "test-bulk-index";
/*  
}  
            DocumentServiceGrpc.DocumentServiceBlockingStub documentStub = DocumentServiceGrpc.newBlockingStub(channel);  
        }
package org.opensearch.transport.grpc;
            BulkRequestBody requestBody = BulkRequestBody.newBuilder()
                .setOperationContainer(org.opensearch.protobufs.OperationContainer.newBuilder().setIndex(indexOp).build())  
     */
 * The OpenSearch Contributors require contributions made to  
            // Create a DocumentService stub
 * this file be licensed under the Apache-2.0 license or a
public class DocumentServiceIT extends GrpcTransportBaseIT {
            waitForSearchableDoc(indexName, "1");  
/**
import io.grpc.ManagedChannel;
        createTestIndex(indexName);  
    /**  
 * Integration tests for the DocumentService gRPC service.
    public void testDocumentServiceBulk() throws Exception {  
        // Create a gRPC client
        // Create a test index
                .build();
