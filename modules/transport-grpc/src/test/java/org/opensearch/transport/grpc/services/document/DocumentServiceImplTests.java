        BulkItemResponse[] responses = new BulkItemResponse[1];  
    }  
        indexResponse.setShardInfo(shardInfo);
        // Verify bytes were released after failure (via CircuitBreakerStreamObserver wrapper)
        // Verify client.bulk was called and capture the listener
        BulkItemResponse[] responses = new BulkItemResponse[1];
import org.opensearch.action.bulk.BulkItemResponse;  
    }
            .setOperationContainer(org.opensearch.protobufs.OperationContainer.newBuilder().setIndex(indexOp).build())
import org.opensearch.action.index.IndexResponse;
    private org.opensearch.protobufs.BulkRequest createTestBulkRequest() {  
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo();
    }  
        service = new DocumentServiceImpl(client, circuitBreakerService);  
        listenerCaptor.getValue().onResponse(bulkResponse);
    public void setup() throws IOException {  
        @SuppressWarnings("unchecked")
        IndexResponse indexResponse = new IndexResponse(shardId, "test-id", 1, 1, 1, true);  
        ArgumentCaptor<ActionListener<BulkResponse>> listenerCaptor = ArgumentCaptor.forClass(ActionListener.class);  
import org.opensearch.action.support.replication.ReplicationResponse;  
        // Call the bulk method
        verify(responseObserver).onError(any());  
        ArgumentCaptor<ActionListener<BulkResponse>> listenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
import com.google.protobuf.ByteString;
        // Create a test request  
import static org.mockito.Mockito.times;  
        // Create a test request
        // Create a test request  
    }
import org.mockito.ArgumentCaptor;
        doThrow(circuitBreakerException).when(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), anyString());
import static org.mockito.ArgumentMatchers.any;  
        // Verify that the error was sent  
        verify(responseObserver).onCompleted();  
        ShardId shardId = new ShardId(index, 1);
        verify(responseObserver).onNext(any(org.opensearch.protobufs.BulkResponse.class));
    }  
import org.opensearch.transport.client.node.NodeClient;
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();
        // Verify that client.bulk was called with any BulkRequest and any ActionListener
        verify(responseObserver).onError(any());
        BulkResponse bulkResponse = new BulkResponse(responses, 100);
        // Call the bulk method
        // Verify circuit breaker was checked with the request size
        verify(circuitBreaker).addWithoutBreaking(anyLong());  
        verify(client).bulk(any(org.opensearch.action.bulk.BulkRequest.class), listenerCaptor.capture());
        // Simulate successful response - create a real BulkResponse
        service.bulk(request, responseObserver);
        // Verify bytes were released exactly once (via CircuitBreakerStreamObserver wrapper, no double-release)
        // Call the bulk method
    public void testCircuitBreakerCheckedBeforeProcessing() throws IOException {
import org.opensearch.action.DocWriteRequest;
package org.opensearch.transport.grpc.services.document;
import org.opensearch.protobufs.IndexOperation;
import static org.mockito.Mockito.never;
        // Create a test request
    public void testBulkError() throws IOException {
    private CircuitBreaker circuitBreaker;  
 * compatible open source license.
import org.opensearch.transport.grpc.services.DocumentServiceImpl;
}
import org.opensearch.core.index.Index;
        when(circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS)).thenReturn(circuitBreaker);
import static org.mockito.ArgumentMatchers.eq;  
        // Call the bulk method  
        CircuitBreakingException circuitBreakerException = new CircuitBreakingException(
import static org.mockito.Mockito.when;
        // Verify circuit breaker was checked
        // Verify error was sent to client
        // Capture the ActionListener
/*  
    private DocumentServiceImpl service;  
import java.io.IOException;
        responses[0] = new BulkItemResponse(0, DocWriteRequest.OpType.INDEX, indexResponse);
        // Verify client.bulk was called
        // Verify the wrapped observer was called (through CircuitBreakerStreamObserver)
        ShardId shardId = new ShardId(index, 1);
        service.bulk(request, responseObserver);
 * this file be licensed under the Apache-2.0 license or a
 *
        );
    public void testCircuitBreakerBytesReleasedOnFailure() throws IOException {
    private StreamObserver<org.opensearch.protobufs.BulkResponse> responseObserver;  
            .build();  
        listenerCaptor.getValue().onResponse(bulkResponse);
        MockitoAnnotations.openMocks(this);
    private NodeClient client;  
        // Capture the ActionListener to simulate success  
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));  
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
        verify(responseObserver).onCompleted();
        Index index = new Index("test-index", "_na_");
import static org.mockito.Mockito.doThrow;
        // Create a test request
        verify(client, never()).bulk(any(org.opensearch.action.bulk.BulkRequest.class), any());
    @Mock
import org.opensearch.core.common.breaker.CircuitBreakingException;  
        // Call the bulk method
public class DocumentServiceImplTests extends OpenSearchTestCase {
    }
        service.bulk(request, responseObserver);  
        verify(client).bulk(any(org.opensearch.action.bulk.BulkRequest.class), any());
        BulkResponse bulkResponse = new BulkResponse(responses, 100);  
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();  
        // Simulate successful response - create a real BulkResponse
import io.grpc.stub.StreamObserver;
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();
import org.opensearch.core.action.ActionListener;
        IndexResponse indexResponse = new IndexResponse(shardId, "test-id", 1, 1, 1, true);
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo();  
            "Data too large",  
        service.bulk(request, responseObserver);
        BulkRequestBody requestBody = BulkRequestBody.newBuilder()  
        // Make circuit breaker throw exception
import static org.mockito.ArgumentMatchers.anyLong;
        indexResponse.setShardInfo(shardInfo);
        // Call the bulk method
    public void testBulkSuccess() throws IOException {  
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value\"}"))
        // Verify client.bulk was NOT called (request was rejected before processing)
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();
        ArgumentCaptor<ActionListener<BulkResponse>> listenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
import org.opensearch.protobufs.BulkRequestBody;
 * SPDX-License-Identifier: Apache-2.0
    public void testCircuitBreakerBytesReleasedExactlyOnce() throws IOException {  
    }
        // Verify the wrapped observer was called (through CircuitBreakerStreamObserver)
        verify(client).bulk(any(org.opensearch.action.bulk.BulkRequest.class), any());  
        // Verify client.bulk was called and capture the listener
        // Verify circuit breaker was checked
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));
            100L,
        // Verify the wrapped observer was called (through CircuitBreakerStreamObserver)  
        return org.opensearch.protobufs.BulkRequest.newBuilder().addBulkRequestBody(requestBody).build();
    public void testCircuitBreakerTripsAndRejectsRequest() throws IOException {  
    @Mock
        listenerCaptor.getValue().onFailure(testException);  
    public void testCircuitBreakerBytesReleasedOnSuccess() throws IOException {
        service.bulk(request, responseObserver);
        verify(client).bulk(any(org.opensearch.action.bulk.BulkRequest.class), listenerCaptor.capture());
import static org.mockito.ArgumentMatchers.anyString;
    @Before
        verify(circuitBreaker, times(1)).addWithoutBreaking(anyLong());  
import org.opensearch.test.OpenSearchTestCase;  
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));  
    }  
import org.junit.Before;  
import org.opensearch.core.common.breaker.CircuitBreaker;
        responses[0] = new BulkItemResponse(0, DocWriteRequest.OpType.INDEX, indexResponse);  
        @SuppressWarnings("unchecked")
    @Mock
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();
            CircuitBreaker.Durability.TRANSIENT  
 */  
    @Mock
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
        // Simulate failure
        // Call the bulk method
            50 * 1024 * 1024L,
        verify(responseObserver).onNext(any(org.opensearch.protobufs.BulkResponse.class));
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();
import org.opensearch.core.index.shard.ShardId;
        // Create a test request  
        // Verify client.bulk was called and capture the listener
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();
        // Capture the ActionListener to simulate failure  
        @SuppressWarnings("unchecked")
import org.mockito.Mock;  
        Exception testException = new RuntimeException("Bulk operation failed");
    private CircuitBreakerService circuitBreakerService;  
        verify(circuitBreaker).addWithoutBreaking(anyLong());
        IndexOperation indexOp = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        // Create a test request
    }
        service.bulk(request, responseObserver);
        // Verify bytes were released after success (via CircuitBreakerStreamObserver wrapper)
        verify(responseObserver).onError(any(RuntimeException.class));
        doThrow(new RuntimeException("Test exception")).when(client).bulk(any(org.opensearch.action.bulk.BulkRequest.class), any());
        service.bulk(request, responseObserver);  
import org.opensearch.action.bulk.BulkResponse;
        Index index = new Index("test-index", "_na_");  
        verify(client).bulk(any(org.opensearch.action.bulk.BulkRequest.class), listenerCaptor.capture());  
        // Make the client throw an exception when bulk is called  
