        Index index = new Index("test-index", "_na_");
        // Call the bulk method
    private NodeClient client;
    }
import org.opensearch.action.bulk.BulkItemResponse;
        // Verify client.bulk was called and capture the listener
}
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));
import static org.mockito.Mockito.doThrow;
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));
        verify(client).bulk(any(org.opensearch.action.bulk.BulkRequest.class), listenerCaptor.capture());
        verify(responseObserver).onCompleted();
    public void testCircuitBreakerTripsAndRejectsRequest() throws IOException {
    }
        ShardId shardId = new ShardId(index, 1);
        ArgumentCaptor<ActionListener<BulkResponse>> listenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
        verify(client).bulk(any(org.opensearch.action.bulk.BulkRequest.class), listenerCaptor.capture());
    private CircuitBreaker circuitBreaker;
        @SuppressWarnings("unchecked")
    public void testCircuitBreakerBytesReleasedOnFailure() throws IOException {
import static org.mockito.Mockito.times;
    }
 */
        // Simulate successful response - create a real BulkResponse
            "Data too large",
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        responses[0] = new BulkItemResponse(0, DocWriteRequest.OpType.INDEX, indexResponse);
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();
        MockitoAnnotations.openMocks(this);
        listenerCaptor.getValue().onResponse(bulkResponse);
/*
        BulkItemResponse[] responses = new BulkItemResponse[1];
    public void testBulkSuccess() throws IOException {
        listenerCaptor.getValue().onResponse(bulkResponse);
        // Create a test request
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));
    @Mock
    public void testCircuitBreakerBytesReleasedExactlyOnce() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        // Make circuit breaker throw exception
        // Capture the ActionListener
        service.bulk(request, responseObserver);
    }
        // Verify client.bulk was NOT called (request was rejected before processing)
        // Verify that client.bulk was called with any BulkRequest and any ActionListener
        service = new DocumentServiceImpl(client, circuitBreakerService);
        @SuppressWarnings("unchecked")
        indexResponse.setShardInfo(shardInfo);
        // Simulate failure
        CircuitBreakingException circuitBreakerException = new CircuitBreakingException(
        // Capture the ActionListener to simulate failure
        verify(circuitBreaker).addWithoutBreaking(anyLong());
        // Call the bulk method
    private CircuitBreakerService circuitBreakerService;
        service.bulk(request, responseObserver);
 * this file be licensed under the Apache-2.0 license or a
        // Call the bulk method
    @Mock
import static org.mockito.ArgumentMatchers.anyString;
        service.bulk(request, responseObserver);
package org.opensearch.transport.grpc.services.document;
        // Verify the wrapped observer was called (through CircuitBreakerStreamObserver)
        // Create a test request
        ShardId shardId = new ShardId(index, 1);
        );
        // Verify client.bulk was called and capture the listener
        verify(responseObserver).onNext(any(org.opensearch.protobufs.BulkResponse.class));
        verify(client).bulk(any(org.opensearch.action.bulk.BulkRequest.class), any());
        // Verify circuit breaker was checked
        // Create a test request
import org.junit.Before;
        // Verify bytes were released exactly once (via CircuitBreakerStreamObserver wrapper, no double-release)
        // Verify circuit breaker was checked with the request size
import org.opensearch.core.common.breaker.CircuitBreaker;
        verify(responseObserver).onCompleted();
    private StreamObserver<org.opensearch.protobufs.BulkResponse> responseObserver;
        verify(responseObserver).onNext(any(org.opensearch.protobufs.BulkResponse.class));
        verify(responseObserver).onError(any());
import static org.mockito.Mockito.never;
            100L,
        // Call the bulk method
    private org.opensearch.protobufs.BulkRequest createTestBulkRequest() {
import org.opensearch.core.index.shard.ShardId;
 * compatible open source license.
        // Capture the ActionListener to simulate success
    @Mock
import java.io.IOException;
        // Verify bytes were released after success (via CircuitBreakerStreamObserver wrapper)
        // Simulate successful response - create a real BulkResponse
import io.grpc.stub.StreamObserver;
        BulkResponse bulkResponse = new BulkResponse(responses, 100);
    public void testCircuitBreakerCheckedBeforeProcessing() throws IOException {
        ArgumentCaptor<ActionListener<BulkResponse>> listenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
import static org.mockito.Mockito.when;
        verify(responseObserver).onError(any(RuntimeException.class));
        BulkResponse bulkResponse = new BulkResponse(responses, 100);
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();
        verify(client).bulk(any(org.opensearch.action.bulk.BulkRequest.class), any());
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();
    public void setup() throws IOException {
import static org.mockito.Mockito.verify;
    }
import org.opensearch.transport.client.node.NodeClient;
        listenerCaptor.getValue().onFailure(testException);
        service.bulk(request, responseObserver);
        verify(client, never()).bulk(any(org.opensearch.action.bulk.BulkRequest.class), any());
            .build();
        // Create a test request
        // Make the client throw an exception when bulk is called
        IndexResponse indexResponse = new IndexResponse(shardId, "test-id", 1, 1, 1, true);
        service.bulk(request, responseObserver);
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo();
import org.opensearch.core.index.Index;
import org.opensearch.protobufs.IndexOperation;
import org.opensearch.action.bulk.BulkResponse;
        // Verify the wrapped observer was called (through CircuitBreakerStreamObserver)
public class DocumentServiceImplTests extends OpenSearchTestCase {
    }
import org.opensearch.test.OpenSearchTestCase;
        doThrow(new RuntimeException("Test exception")).when(client).bulk(any(org.opensearch.action.bulk.BulkRequest.class), any());
        Index index = new Index("test-index", "_na_");
        indexResponse.setShardInfo(shardInfo);
        // Verify client.bulk was called
    private DocumentServiceImpl service;
        service.bulk(request, responseObserver);
        // Create a test request
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value\"}"))
        // Verify bytes were released after failure (via CircuitBreakerStreamObserver wrapper)
        // Call the bulk method
    @Before
    public void testCircuitBreakerBytesReleasedOnSuccess() throws IOException {
import static org.mockito.ArgumentMatchers.any;
 *
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();
        IndexResponse indexResponse = new IndexResponse(shardId, "test-id", 1, 1, 1, true);
        org.opensearch.protobufs.BulkRequest request = createTestBulkRequest();
        return org.opensearch.protobufs.BulkRequest.newBuilder().addBulkRequestBody(requestBody).build();
        ArgumentCaptor<ActionListener<BulkResponse>> listenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
    }
        responses[0] = new BulkItemResponse(0, DocWriteRequest.OpType.INDEX, indexResponse);
        IndexOperation indexOp = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        verify(circuitBreaker).addWithoutBreaking(anyLong());
import org.opensearch.action.index.IndexResponse;
        // Call the bulk method
        BulkItemResponse[] responses = new BulkItemResponse[1];
    }
            .setOperationContainer(org.opensearch.protobufs.OperationContainer.newBuilder().setIndex(indexOp).build())
import com.google.protobuf.ByteString;
import org.opensearch.protobufs.BulkRequestBody;
        // Verify circuit breaker was checked
    }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.DocWriteRequest;
        BulkRequestBody requestBody = BulkRequestBody.newBuilder()
        service.bulk(request, responseObserver);
import org.mockito.Mock;
        when(circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS)).thenReturn(circuitBreaker);
import org.opensearch.action.support.replication.ReplicationResponse;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;
        @SuppressWarnings("unchecked")
            CircuitBreaker.Durability.TRANSIENT
        // Call the bulk method
            50 * 1024 * 1024L,
        verify(client).bulk(any(org.opensearch.action.bulk.BulkRequest.class), listenerCaptor.capture());
import org.opensearch.transport.grpc.services.DocumentServiceImpl;
        // Verify that the error was sent
        // Verify client.bulk was called and capture the listener
import org.opensearch.core.common.breaker.CircuitBreakingException;
import org.opensearch.core.action.ActionListener;
        Exception testException = new RuntimeException("Bulk operation failed");
        doThrow(circuitBreakerException).when(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), anyString());
        // Create a test request
        // Create a test request
    @Mock
        verify(responseObserver).onError(any());
        // Verify the wrapped observer was called (through CircuitBreakerStreamObserver)
    public void testBulkError() throws IOException {
        verify(circuitBreaker, times(1)).addWithoutBreaking(anyLong());
        // Verify error was sent to client
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo();
import static org.mockito.ArgumentMatchers.eq;
