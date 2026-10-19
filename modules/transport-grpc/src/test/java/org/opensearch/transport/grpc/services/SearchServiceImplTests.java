        // Verify error was sent to client
    public void testCreatePitSuccess() {
        service = new SearchServiceImpl(client, queryUtils, aggregationRegistry, aggregateRegistry, circuitBreakerService);
            CircuitBreaker.Durability.TRANSIENT
        aggregationRegistry = new AggregationBuilderProtoConverterRegistryImpl();
    }
        // Create a test request
    public void testDeletePitCircuitBreakerTripsAndRejectsRequest() throws Exception {
        return org.opensearch.protobufs.SearchRequest.newBuilder()
        verify(client).search(any(org.opensearch.action.search.SearchRequest.class), any());
    public void testConstructorWithNullAggregationRegistry() {
            IllegalArgumentException.class,
 * SPDX-License-Identifier: Apache-2.0
    }
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        verify(client, never()).createPit(any(org.opensearch.action.search.CreatePitRequest.class), any());
        IllegalArgumentException exception = expectThrows(
        CircuitBreakingException circuitBreakerException = new CircuitBreakingException(
            IllegalArgumentException.class,
import static org.mockito.Mockito.doThrow;
        ArgumentCaptor<Long> releasedBytesCaptor = ArgumentCaptor.forClass(Long.class);
        service.createPit(request, createPitResponseObserver);
        service.deletePit(request, deletePitResponseObserver);
        org.opensearch.protobufs.SearchRequest request = createTestSearchRequest();
        // Call search method
        ArgumentCaptor<ActionListener<SearchResponse>> listenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
        // Verify the magnitudes match (added is positive, released is negative of same value)
            .build();
        verify(deletePitResponseObserver).onError(any());
    @Mock
    private org.opensearch.protobufs.CreatePitRequest createTestCreatePitRequest() {
        verify(client, never()).deletePits(any(org.opensearch.action.search.DeletePitRequest.class), any());
        @SuppressWarnings("unchecked")
        assertEquals("Released bytes should equal negative of added bytes", -addedBytes, releasedBytes);
        IllegalArgumentException exception = expectThrows(
import static org.mockito.Mockito.verify;
        assertTrue("Added bytes should be positive", addedBytes > 0);
    }
        MockitoAnnotations.openMocks(this);
    private AbstractQueryBuilderProtoUtils queryUtils;
            IllegalArgumentException.class,
 */
    }
        doThrow(new RuntimeException("Test exception")).when(client).search(any(), any());
        // Verify bytes were released (via CircuitBreakerStreamObserver wrapper)
        );
    private SearchServiceImpl service;
        ArgumentCaptor<Long> addedBytesCaptor = ArgumentCaptor.forClass(Long.class);
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
        service.search(request, responseObserver);
    }
 * compatible open source license.
        long releasedBytes = releasedBytesCaptor.getValue();
    private org.opensearch.protobufs.DeletePitRequest createTestDeletePitRequest() {
        long releasedBytes = releasedBytesCaptor.getValue();
        // Create a test request
import org.opensearch.action.search.SearchResponse;
            50 * 1024 * 1024L,
import org.opensearch.core.common.breaker.CircuitBreaker;
    }
        );
        queryUtils = QueryBuilderProtoTestUtils.createQueryUtils();
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(addedBytesCaptor.capture(), eq("<grpc_request>"));
        assertEquals("Query utils cannot be null", exception.getMessage());
    public void setup() throws IOException {
    public void testDeletePitBytesReleasedOnException() throws Exception {
        org.opensearch.protobufs.DeletePitRequest request = createTestDeletePitRequest();
            .setSearchRequestBody(SearchRequestBody.newBuilder().setSize(10).build())
        verify(client, never()).search(any(org.opensearch.action.search.SearchRequest.class), any());
    }
        IllegalArgumentException exception = expectThrows(
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(addedBytesCaptor.capture(), eq("<grpc_request>"));
        long addedBytes = addedBytesCaptor.getValue();
            IllegalArgumentException.class,
public class SearchServiceImplTests extends OpenSearchTestCase {
import static org.mockito.ArgumentMatchers.anyLong;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
import org.junit.Before;
 * this file be licensed under the Apache-2.0 license or a
    public void testCreatePitBytesReleasedOnException() throws Exception {
import org.mockito.ArgumentCaptor;
        doThrow(circuitBreakerException).when(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), anyString());
        service.deletePit(request, deletePitResponseObserver);
        long releasedBytes = releasedBytesCaptor.getValue();
        IllegalArgumentException exception = expectThrows(
        verify(circuitBreaker).addWithoutBreaking(releasedBytesCaptor.capture());
        );
 * The OpenSearch Contributors require contributions made to
        when(mockResponse.getFailedShards()).thenReturn(0);
    private AggregationBuilderProtoConverterRegistry aggregationRegistry;
            CircuitBreaker.Durability.TRANSIENT
        // Create a test request
import org.opensearch.core.action.ActionListener;
        when(circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS)).thenReturn(circuitBreaker);
        doThrow(circuitBreakerException).when(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), anyString());
        );
        ArgumentCaptor<Long> releasedBytesCaptor = ArgumentCaptor.forClass(Long.class);
        assertEquals("Aggregation registry cannot be null", exception.getMessage());
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(addedBytesCaptor.capture(), eq("<grpc_request>"));
    @Before
        aggregateRegistry = new AggregateProtoConverterRegistryImpl();
        );
        assertEquals("Client cannot be null", exception.getMessage());
        doThrow(circuitBreakerException).when(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), anyString());
            "Data too large",
        // Call the search method
        assertTrue("Added bytes should be positive", addedBytes > 0);
        // Capture the ActionListener to simulate success
            100L,
        );
        verify(client).createPit(any(org.opensearch.action.search.CreatePitRequest.class), any());
    public void testSearchSuccess() throws IOException {
        // Verify bytes were released after exception (negative value)
        // Simulate successful response
        when(mockResponse.getTotalShards()).thenReturn(5);
        service.createPit(request, createPitResponseObserver);
            () -> new SearchServiceImpl(client, queryUtils, null, aggregateRegistry, circuitBreakerService)
        assertEquals("Client cannot be null", exception.getMessage());
        verify(deletePitResponseObserver).onError(any());
import static org.mockito.ArgumentMatchers.eq;
        // Test that constructor throws IllegalArgumentException when client is null
        CircuitBreakingException circuitBreakerException = new CircuitBreakingException(
    public void testConstructorWithNullAggregateRegistry() {
    }
        // Verify circuit breaker was checked
}
        verify(circuitBreaker).addWithoutBreaking(releasedBytesCaptor.capture());
        org.opensearch.protobufs.SearchRequest request = createTestSearchRequest();
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoTestUtils;
            () -> new SearchServiceImpl(client, null, aggregationRegistry, aggregateRegistry, circuitBreakerService)
        // Verify client.search was called
        // Call the search method
import java.io.IOException;
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        // Verify client.search was called and capture the listener
        org.opensearch.protobufs.SearchRequest request = createTestSearchRequest();
        assertEquals("Circuit breaker service cannot be null", exception.getMessage());
    private AggregateProtoConverterRegistry aggregateRegistry;
        doThrow(new RuntimeException("Test exception")).when(client).createPit(any(), any());
            () -> new SearchServiceImpl(client, queryUtils, aggregationRegistry, aggregateRegistry, null)
        verify(createPitResponseObserver).onError(any());
    public void testCircuitBreakerTripsAndRejectsRequest() throws IOException {
    }
        return org.opensearch.protobufs.CreatePitRequest.newBuilder().addIndex("test-index").setKeepAlive("1m").build();
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
            IllegalArgumentException.class,
        // Verify that client.search was called with any SearchRequest and any ActionListener
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));
import static org.mockito.ArgumentMatchers.anyString;
            "Data too large",
    }
        when(mockResponse.isTimedOut()).thenReturn(false);
        verify(createPitResponseObserver).onError(any());
        // Create a test request
        IllegalArgumentException exception = expectThrows(
import static org.mockito.Mockito.mock;
        doThrow(new RuntimeException("Test exception")).when(client).deletePits(any(), any());
    @Mock
        when(mockResponse.getSkippedShards()).thenReturn(0);
        verify(responseObserver).onCompleted();
    public void testCircuitBreakerCheckedBeforeProcessing() throws IOException {
            CircuitBreaker.Durability.TRANSIENT
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        assertEquals("Aggregate registry cannot be null", exception.getMessage());
import org.opensearch.protobufs.SearchRequestBody;
import org.opensearch.transport.grpc.proto.request.search.aggregation.AggregationBuilderProtoConverterRegistryImpl;
    }
    public void testConstructorWithNullClient() {
        // Verify circuit breaker was checked with the request size
import org.opensearch.action.search.SearchResponseSections;
        // Call the search method
        return org.opensearch.protobufs.DeletePitRequest.newBuilder().addPitId("pit-id-1").build();
        listenerCaptor.getValue().onResponse(mockResponse);
import org.opensearch.core.common.breaker.CircuitBreakingException;
    @Mock
            () -> new SearchServiceImpl(null, null, aggregationRegistry, aggregateRegistry, circuitBreakerService)
    }
    public void testConstructorWithNullCircuitBreakerService() {
        service.search(request, responseObserver);
        service.search(request, responseObserver);
        service.search(request, responseObserver);
import org.mockito.Mock;
            () -> new SearchServiceImpl(null, queryUtils, aggregationRegistry, aggregateRegistry, circuitBreakerService)
    private StreamObserver<org.opensearch.protobufs.DeletePITResponse> deletePitResponseObserver;
    }
import org.opensearch.common.unit.TimeValue;
        );
    }
            "Data too large",
        org.opensearch.protobufs.DeletePitRequest request = createTestDeletePitRequest();
        ArgumentCaptor<Long> addedBytesCaptor = ArgumentCaptor.forClass(Long.class);
    public void testConstructorWithBothNull() {
    }
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;
        assertTrue("Added bytes should be positive", addedBytes > 0);
        long addedBytes = addedBytesCaptor.getValue();
    @Mock
            50 * 1024 * 1024L,
            () -> new SearchServiceImpl(client, queryUtils, aggregationRegistry, null, circuitBreakerService)
        // Verify client.search was NOT called (request was rejected before processing)
    }
        verify(responseObserver).onNext(any(org.opensearch.protobufs.SearchResponse.class));
        verify(responseObserver).onError(any());
        );
        );
import org.mockito.MockitoAnnotations;
package org.opensearch.transport.grpc.services;
        // Call the search method
    @Mock
/*
        verify(responseObserver).onError(any());
    private NodeClient client;
        assertEquals("Released bytes should equal negative of added bytes", -addedBytes, releasedBytes);
import io.grpc.stub.StreamObserver;
 *
    public void testDeletePitSuccess() {
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));
        ArgumentCaptor<Long> addedBytesCaptor = ArgumentCaptor.forClass(Long.class);
    private CircuitBreaker circuitBreaker;
        // Verify bytes were added first (positive value)
        // Create a test request
        service.deletePit(request, deletePitResponseObserver);
            100L,
import static org.mockito.Mockito.when;
        verify(client).deletePits(any(org.opensearch.action.search.DeletePitRequest.class), any());
        org.opensearch.protobufs.SearchRequest request = createTestSearchRequest();
    }
import org.opensearch.transport.client.node.NodeClient;
    private org.opensearch.protobufs.SearchRequest createTestSearchRequest() {
            100L,
import org.opensearch.test.OpenSearchTestCase;
            IllegalArgumentException.class,
        // Mock client to throw an exception
    @Mock
        org.opensearch.protobufs.CreatePitRequest request = createTestCreatePitRequest();
    public void testCircuitBreakerStreamObserverWrapsResponseObserver() throws IOException {
        service.createPit(request, createPitResponseObserver);
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;
        verify(circuitBreaker).addWithoutBreaking(releasedBytesCaptor.capture());
        // Verify the wrapped observer was called (through CircuitBreakerStreamObserver)
        assertEquals("Released bytes should equal negative of added bytes", -addedBytes, releasedBytes);
import static org.mockito.ArgumentMatchers.any;
        org.opensearch.protobufs.DeletePitRequest request = createTestDeletePitRequest();
        service.search(request, responseObserver);
        org.opensearch.protobufs.CreatePitRequest request = createTestCreatePitRequest();
        when(mockResponse.getShardFailures()).thenReturn(new org.opensearch.action.search.ShardSearchFailure[0]);
            50 * 1024 * 1024L,
        org.opensearch.protobufs.SearchRequest request = createTestSearchRequest();
        SearchResponse mockResponse = mock(SearchResponse.class);
    public void testCircuitBreakerBytesReleasedOnException() throws IOException {
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));
    }
    private CircuitBreakerService circuitBreakerService;
        // Verify error was sent to client
        // Capture the bytes added and released
import static org.mockito.Mockito.never;
        org.opensearch.protobufs.CreatePitRequest request = createTestCreatePitRequest();
    public void testCreatePitCircuitBreakerTripsAndRejectsRequest() throws Exception {
        CircuitBreakingException circuitBreakerException = new CircuitBreakingException(
        long addedBytes = addedBytesCaptor.getValue();
        IllegalArgumentException exception = expectThrows(
    }
        // Make circuit breaker throw exception
        verify(client).search(any(org.opensearch.action.search.SearchRequest.class), any());
    }
        verify(circuitBreaker).addWithoutBreaking(anyLong());
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        ArgumentCaptor<Long> releasedBytesCaptor = ArgumentCaptor.forClass(Long.class);
    private StreamObserver<org.opensearch.protobufs.SearchResponse> responseObserver;
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
    public void testConstructorWithNullQueryUtils() {
import org.opensearch.search.SearchHits;
        verify(circuitBreaker).addEstimateBytesAndMaybeBreak(anyLong(), eq("<grpc_request>"));
        verify(client).search(any(org.opensearch.action.search.SearchRequest.class), listenerCaptor.capture());
            .addIndex("test-index")
    }
    private StreamObserver<org.opensearch.protobufs.CreatePITResponse> createPitResponseObserver;
