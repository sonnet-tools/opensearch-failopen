import static org.mockito.ArgumentMatchers.anyLong;
        // Make circuit breaker throw exception  
        // Mock client to throw an exception  
import org.opensearch.common.unit.TimeValue;  
        // Create a test request
        // Verify circuit breaker was checked with the request size
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(addedBytesCaptor.capture(), eq("<grpc_request>"));
        // Verify client.search was called
        org.opensearch.protobufs.CreatePitRequest request = createTestCreatePitRequest();
        service.search(request, responseObserver);
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoTestUtils;
        ArgumentCaptor<Long> addedBytesCaptor = ArgumentCaptor.forClass(Long.class);  
    }
        long addedBytes = addedBytesCaptor.getValue();
            () -> new SearchServiceImpl(null, queryUtils, aggregationRegistry, aggregateRegistry, circuitBreakerService)
        verify(circuitBreaker).addWithoutBreaking(releasedBytesCaptor.capture());
        assertEquals("Query utils cannot be null", exception.getMessage());
        doThrow(new RuntimeException("Test exception")).when(client).deletePits(any(), any());  
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
        service.search(request, responseObserver);
 * The OpenSearch Contributors require contributions made to  
        verify(circuitBreaker).addWithoutBreaking(anyLong());
        org.opensearch.protobufs.CreatePitRequest request = createTestCreatePitRequest();
            "Data too large",
        // Call the search method  
        ArgumentCaptor<Long> addedBytesCaptor = ArgumentCaptor.forClass(Long.class);
        long addedBytes = addedBytesCaptor.getValue();
        // Verify bytes were added first (positive value)  
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));  
        service.createPit(request, createPitResponseObserver);
        verify(client, never()).createPit(any(org.opensearch.action.search.CreatePitRequest.class), any());
            50 * 1024 * 1024L,
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));
        CircuitBreakingException circuitBreakerException = new CircuitBreakingException(
import org.opensearch.core.indices.breaker.CircuitBreakerService;
            100L,  
        long addedBytes = addedBytesCaptor.getValue();
        service.createPit(request, createPitResponseObserver);
        verify(responseObserver).onNext(any(org.opensearch.protobufs.SearchResponse.class));  
        assertTrue("Added bytes should be positive", addedBytes > 0);  
    }
        verify(deletePitResponseObserver).onError(any());
        ArgumentCaptor<Long> releasedBytesCaptor = ArgumentCaptor.forClass(Long.class);
        return org.opensearch.protobufs.DeletePitRequest.newBuilder().addPitId("pit-id-1").build();
        doThrow(circuitBreakerException).when(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), anyString());
        ArgumentCaptor<ActionListener<SearchResponse>> listenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
            50 * 1024 * 1024L,
        assertTrue("Added bytes should be positive", addedBytes > 0);
        // Create a test request  
        service.createPit(request, createPitResponseObserver);  
/*  
        service.search(request, responseObserver);
        // Call the search method
        verify(client, never()).search(any(org.opensearch.action.search.SearchRequest.class), any());
        );
public class SearchServiceImplTests extends OpenSearchTestCase {
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));
        IllegalArgumentException exception = expectThrows(
    }  
    }
    public void testConstructorWithNullClient() {  
        doThrow(new RuntimeException("Test exception")).when(client).search(any(), any());
        org.opensearch.protobufs.SearchRequest request = createTestSearchRequest();  
    private StreamObserver<org.opensearch.protobufs.SearchResponse> responseObserver;  
    public void testCreatePitCircuitBreakerTripsAndRejectsRequest() throws Exception {  
        org.opensearch.protobufs.DeletePitRequest request = createTestDeletePitRequest();
        assertTrue("Added bytes should be positive", addedBytes > 0);  
            IllegalArgumentException.class,  
    }
 *
 * compatible open source license.
        );
            IllegalArgumentException.class,  
}
            .setSearchRequestBody(SearchRequestBody.newBuilder().setSize(10).build())
        assertEquals("Aggregation registry cannot be null", exception.getMessage());
        );
    private org.opensearch.protobufs.CreatePitRequest createTestCreatePitRequest() {  
        // Capture the bytes added and released
        verify(client).deletePits(any(org.opensearch.action.search.DeletePitRequest.class), any());
    public void testCreatePitSuccess() {
        long releasedBytes = releasedBytesCaptor.getValue();
            IllegalArgumentException.class,  
    @Mock
        return org.opensearch.protobufs.SearchRequest.newBuilder()  
import static org.mockito.Mockito.verify;
    public void testConstructorWithNullAggregationRegistry() {
        verify(client).search(any(org.opensearch.action.search.SearchRequest.class), listenerCaptor.capture());
        CircuitBreakingException circuitBreakerException = new CircuitBreakingException(
    @Before
            "Data too large",
        IllegalArgumentException exception = expectThrows(
    }
        assertEquals("Released bytes should equal negative of added bytes", -addedBytes, releasedBytes);
        verify(client).search(any(org.opensearch.action.search.SearchRequest.class), any());  
        // Call the search method
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
        when(mockResponse.getTotalShards()).thenReturn(5);
        IllegalArgumentException exception = expectThrows(
    }  
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(addedBytesCaptor.capture(), eq("<grpc_request>"));
    }
            100L,
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        when(mockResponse.getFailedShards()).thenReturn(0);
    public void testDeletePitSuccess() {  
        verify(client, never()).deletePits(any(org.opensearch.action.search.DeletePitRequest.class), any());  
        org.opensearch.protobufs.DeletePitRequest request = createTestDeletePitRequest();
        @SuppressWarnings("unchecked")  
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;  
    public void testCircuitBreakerStreamObserverWrapsResponseObserver() throws IOException {
        long releasedBytes = releasedBytesCaptor.getValue();
    private SearchServiceImpl service;  
        // Verify error was sent to client  
import org.opensearch.core.action.ActionListener;
import static org.mockito.Mockito.doThrow;
    public void testCreatePitBytesReleasedOnException() throws Exception {
        // Create a test request
    public void testCircuitBreakerBytesReleasedOnException() throws IOException {
        service.search(request, responseObserver);  
    public void testDeletePitBytesReleasedOnException() throws Exception {
        long releasedBytes = releasedBytesCaptor.getValue();  
        MockitoAnnotations.openMocks(this);
import org.mockito.ArgumentCaptor;
    @Mock
    private org.opensearch.protobufs.SearchRequest createTestSearchRequest() {
            IllegalArgumentException.class,  
package org.opensearch.transport.grpc.services;
        );  
    }
        assertEquals("Aggregate registry cannot be null", exception.getMessage());
            .addIndex("test-index")
    private NodeClient client;  
        org.opensearch.protobufs.SearchRequest request = createTestSearchRequest();
    }
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
    private AggregationBuilderProtoConverterRegistry aggregationRegistry;
import org.opensearch.test.OpenSearchTestCase;
            () -> new SearchServiceImpl(null, null, aggregationRegistry, aggregateRegistry, circuitBreakerService)
        verify(responseObserver).onCompleted();
    public void testConstructorWithBothNull() {
    public void testCircuitBreakerTripsAndRejectsRequest() throws IOException {
            () -> new SearchServiceImpl(client, queryUtils, aggregationRegistry, aggregateRegistry, null)
        when(mockResponse.getShardFailures()).thenReturn(new org.opensearch.action.search.ShardSearchFailure[0]);
import org.opensearch.core.common.breaker.CircuitBreaker;
        SearchResponse mockResponse = mock(SearchResponse.class);
        assertEquals("Client cannot be null", exception.getMessage());
        // Call the search method  
import org.opensearch.core.common.breaker.CircuitBreakingException;  
    public void testSearchSuccess() throws IOException {
    private CircuitBreaker circuitBreaker;  
            100L,  
        service.deletePit(request, deletePitResponseObserver);  
 */  
    private AggregateProtoConverterRegistry aggregateRegistry;  
            50 * 1024 * 1024L,
import org.opensearch.action.search.SearchResponse;
        doThrow(circuitBreakerException).when(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), anyString());
            CircuitBreaker.Durability.TRANSIENT
import org.opensearch.transport.client.node.NodeClient;
        // Create a test request
    public void testDeletePitCircuitBreakerTripsAndRejectsRequest() throws Exception {
    }
        // Create a test request
        service = new SearchServiceImpl(client, queryUtils, aggregationRegistry, aggregateRegistry, circuitBreakerService);  
        service.deletePit(request, deletePitResponseObserver);  
        // Verify the magnitudes match (added is positive, released is negative of same value)  
    private org.opensearch.protobufs.DeletePitRequest createTestDeletePitRequest() {
        // Verify the wrapped observer was called (through CircuitBreakerStreamObserver)
        ArgumentCaptor<Long> releasedBytesCaptor = ArgumentCaptor.forClass(Long.class);
    private StreamObserver<org.opensearch.protobufs.DeletePITResponse> deletePitResponseObserver;  
            IllegalArgumentException.class,  
        verify(createPitResponseObserver).onError(any());  
        doThrow(circuitBreakerException).when(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), anyString());
import org.opensearch.protobufs.SearchRequestBody;
import java.io.IOException;
    }
        aggregateRegistry = new AggregateProtoConverterRegistryImpl();
    private StreamObserver<org.opensearch.protobufs.CreatePITResponse> createPitResponseObserver;  
 * this file be licensed under the Apache-2.0 license or a
        org.opensearch.protobufs.DeletePitRequest request = createTestDeletePitRequest();  
        verify(client).createPit(any(org.opensearch.action.search.CreatePitRequest.class), any());  
        org.opensearch.protobufs.CreatePitRequest request = createTestCreatePitRequest();  
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));
        return org.opensearch.protobufs.CreatePitRequest.newBuilder().addIndex("test-index").setKeepAlive("1m").build();
        // Verify client.search was called and capture the listener  
        assertEquals("Circuit breaker service cannot be null", exception.getMessage());
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        verify(deletePitResponseObserver).onError(any());
            () -> new SearchServiceImpl(client, null, aggregationRegistry, aggregateRegistry, circuitBreakerService)
        ArgumentCaptor<Long> addedBytesCaptor = ArgumentCaptor.forClass(Long.class);  
        when(mockResponse.isTimedOut()).thenReturn(false);  
import static org.mockito.ArgumentMatchers.eq;  
    public void testCircuitBreakerCheckedBeforeProcessing() throws IOException {  
import org.mockito.Mock;  
    public void testConstructorWithNullCircuitBreakerService() {
import static org.mockito.ArgumentMatchers.any;  
        when(circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS)).thenReturn(circuitBreaker);
import static org.mockito.ArgumentMatchers.anyString;
        IllegalArgumentException exception = expectThrows(
        ArgumentCaptor<Long> releasedBytesCaptor = ArgumentCaptor.forClass(Long.class);
            "Data too large",  
import org.opensearch.action.search.SearchResponseSections;
        // Verify error was sent to client  
        verify(responseObserver).onError(any());
        assertEquals("Client cannot be null", exception.getMessage());
        // Verify bytes were released (via CircuitBreakerStreamObserver wrapper)  
    public void testConstructorWithNullQueryUtils() {
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));  
        // Test that constructor throws IllegalArgumentException when client is null
            IllegalArgumentException.class,  
        assertEquals("Released bytes should equal negative of added bytes", -addedBytes, releasedBytes);
        // Verify client.search was NOT called (request was rejected before processing)  
    public void testConstructorWithNullAggregateRegistry() {
        verify(circuitBreaker).addWithoutBreaking(releasedBytesCaptor.capture());
        CircuitBreakingException circuitBreakerException = new CircuitBreakingException(
import org.opensearch.transport.grpc.proto.request.search.aggregation.AggregationBuilderProtoConverterRegistryImpl;  
        // Verify that client.search was called with any SearchRequest and any ActionListener
    @Mock
    }
 * SPDX-License-Identifier: Apache-2.0
            CircuitBreaker.Durability.TRANSIENT
    }  
import org.junit.Before;  
        listenerCaptor.getValue().onResponse(mockResponse);  
        );
        assertEquals("Released bytes should equal negative of added bytes", -addedBytes, releasedBytes);
    }  
            () -> new SearchServiceImpl(client, queryUtils, aggregationRegistry, null, circuitBreakerService)
        doThrow(new RuntimeException("Test exception")).when(client).createPit(any(), any());
        org.opensearch.protobufs.SearchRequest request = createTestSearchRequest();
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;
        // Call search method  
        verify(circuitBreaker).addWithoutBreaking(releasedBytesCaptor.capture());  
        );
        service.deletePit(request, deletePitResponseObserver);
        // Simulate successful response  
import static org.mockito.Mockito.never;  
        org.opensearch.protobufs.SearchRequest request = createTestSearchRequest();  
import io.grpc.stub.StreamObserver;
        IllegalArgumentException exception = expectThrows(
import org.mockito.MockitoAnnotations;
        // Capture the ActionListener to simulate success
    @Mock
    }  
    private CircuitBreakerService circuitBreakerService;  
    }
    }
        verify(client).search(any(org.opensearch.action.search.SearchRequest.class), any());
        );  
        when(mockResponse.getSkippedShards()).thenReturn(0);  
        );
        // Verify bytes were released after exception (negative value)  
            () -> new SearchServiceImpl(client, queryUtils, null, aggregateRegistry, circuitBreakerService)
        service.search(request, responseObserver);
    }
    @Mock
            CircuitBreaker.Durability.TRANSIENT  
        verify(createPitResponseObserver).onError(any());
        org.opensearch.protobufs.SearchRequest request = createTestSearchRequest();  
        aggregationRegistry = new AggregationBuilderProtoConverterRegistryImpl();
    }
    private AbstractQueryBuilderProtoUtils queryUtils;
    public void setup() throws IOException {  
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(addedBytesCaptor.capture(), eq("<grpc_request>"));
        // Verify circuit breaker was checked  
    }
    @Mock
            .build();  
        queryUtils = QueryBuilderProtoTestUtils.createQueryUtils();  
import org.opensearch.search.SearchHits;  
        verify(responseObserver).onError(any());
        IllegalArgumentException exception = expectThrows(
        );
