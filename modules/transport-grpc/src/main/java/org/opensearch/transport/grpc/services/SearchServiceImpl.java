            CreatePitRequestActionListener listener = new CreatePitRequestActionListener(wrappedObserver);  
    @Override
     * @param aggregateRegistry Aggregate registry for converting aggregation results (response-side)
            throw new IllegalArgumentException("Aggregation registry cannot be null");
        org.opensearch.protobufs.SearchRequest request,
    private static final Logger logger = LogManager.getLogger(SearchServiceImpl.class);
        if (client == null) {  
     *
 */  
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);  
            );
            logger.debug("Circuit breaker tripped for gRPC create PIT request: {}", e.getMessage());  
            responseObserver.onError(grpcError);
        }
            client.search(searchRequest, listener);
import org.opensearch.transport.grpc.proto.request.search.SearchRequestProtoUtils;
import org.apache.logging.log4j.Logger;
            breaker.addEstimateBytesAndMaybeBreak(requestSize, "<grpc_request>");
package org.opensearch.transport.grpc.services;
import org.opensearch.transport.client.Client;
     * @param queryUtils Query utils instance for parsing protobuf queries  
import org.opensearch.transport.grpc.util.CircuitBreakerStreamObserver;
import java.io.IOException;
                aggregationRegistry
            responseObserver.onError(grpcError);  
     * @param client Client for executing actions on the local node
 * Implementation of the gRPC SearchService.
     */
            throw new IllegalArgumentException("Query utils cannot be null");
import org.opensearch.protobufs.services.SearchServiceGrpc;  
        StreamObserver<org.opensearch.protobufs.DeletePITResponse> responseObserver
            StreamObserver<org.opensearch.protobufs.CreatePITResponse> wrappedObserver = new CircuitBreakerStreamObserver<>(
        StreamObserver<org.opensearch.protobufs.CreatePITResponse> responseObserver  
    ) {
     *
        try {
    private final AggregationBuilderProtoConverterRegistry aggregationRegistry;
        } catch (RuntimeException e) {
 *
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
            logger.debug("SearchServiceImpl failed to process search request, request=" + request + ", error=" + e.getMessage());  
     * @param request The search request to process
    /**
        CircuitBreaker breaker = circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
        }
            throw new IllegalArgumentException("Aggregate registry cannot be null");
        Client client,  
            responseObserver.onError(grpcError);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.breaker.CircuitBreaker;  
        } catch (RuntimeException e) {  
            SearchRequestActionListener listener = new SearchRequestActionListener(wrappedObserver, aggregateRegistry);
public class SearchServiceImpl extends SearchServiceGrpc.SearchServiceImplBase {  
        } catch (CircuitBreakingException e) {  
import org.opensearch.transport.grpc.proto.request.search.CreatePitRequestProtoUtils;
        CircuitBreaker breaker = circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
        } catch (RuntimeException | IOException e) {
        }
import io.grpc.stub.StreamObserver;
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;  
/**
        StreamObserver<org.opensearch.protobufs.SearchResponse> responseObserver
        this.aggregateRegistry = aggregateRegistry;
 * executes them using the provided client, and returns the results back to the gRPC client.
                queryUtils,
                requestSize
            logger.debug("Circuit breaker tripped for gRPC search request: {}", e.getMessage());
            logger.debug("SearchServiceImpl failed to process create PIT request, request={}, error={}", request, e.getMessage());
    public void search(  
            throw new IllegalArgumentException("Client cannot be null");
            breaker.addWithoutBreaking(-requestSize);  
            responseObserver.onError(grpcError);
        int requestSize = request.getSerializedSize();
 * compatible open source license.
    /**
    private final Client client;
    @Override
                request,
    /**  
            org.opensearch.action.search.SearchRequest searchRequest = SearchRequestProtoUtils.prepareRequest(
import io.grpc.StatusRuntimeException;
     *
    }  
        if (aggregationRegistry == null) {  
 * The OpenSearch Contributors require contributions made to  
                circuitBreakerService,  
    }
        org.opensearch.protobufs.DeletePitRequest request,
            client.deletePits(deletePitRequest, listener);  
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
     * @param responseObserver The observer to send the response back to the client  
                client,  
        this.circuitBreakerService = circuitBreakerService;
 * This class handles incoming gRPC search requests, converts them to OpenSearch search requests,  
     * Creates a new SearchServiceImpl.  
    /**
import org.opensearch.transport.grpc.listeners.DeletePitRequestActionListener;  
import org.opensearch.transport.grpc.proto.request.search.DeletePitRequestProtoUtils;  
import org.opensearch.core.common.breaker.CircuitBreakingException;
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;
                responseObserver,
            StreamObserver<org.opensearch.protobufs.DeletePITResponse> wrappedObserver = new CircuitBreakerStreamObserver<>(
     * Processes a search request.  
            throw new IllegalArgumentException("Circuit breaker service cannot be null");
            org.opensearch.action.search.DeletePitRequest deletePitRequest = DeletePitRequestProtoUtils.prepareRequest(request);
        AggregateProtoConverterRegistry aggregateRegistry,  
            );
    ) {  
            org.opensearch.action.search.CreatePitRequest createPitRequest = CreatePitRequestProtoUtils.prepareRequest(request);
        if (aggregateRegistry == null) {  
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
     */
        }
        this.queryUtils = queryUtils;
     * Processes a create PIT request.
            breaker.addWithoutBreaking(-requestSize);
                circuitBreakerService,
        }  
    private final AggregateProtoConverterRegistry aggregateRegistry;
        int requestSize = request.getSerializedSize();
            DeletePitRequestActionListener listener = new DeletePitRequestActionListener(wrappedObserver);
            client.createPit(createPitRequest, listener);
        } catch (CircuitBreakingException e) {
import org.opensearch.transport.grpc.listeners.CreatePitRequestActionListener;
            );  
 * SPDX-License-Identifier: Apache-2.0
        }
     * @param responseObserver The observer to send the response back to the client
    public void deletePit(  
        org.opensearch.protobufs.CreatePitRequest request,
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        int requestSize = request.getSerializedSize();
        try {
     */
    @Override  
     * @param circuitBreakerService Circuit breaker service for tracking in-flight requests  
        AbstractQueryBuilderProtoUtils queryUtils,
        this.client = client;
    ) {  
     * @param responseObserver The observer to send the response back to the client  
            logger.debug("SearchServiceImpl failed to process delete PIT request, request={}, error={}", request, e.getMessage());
import org.opensearch.transport.grpc.util.GrpcErrorHandler;  
     */
 */
        }
    private final CircuitBreakerService circuitBreakerService;  
        }
     *
            StreamObserver<org.opensearch.protobufs.SearchResponse> wrappedObserver = new CircuitBreakerStreamObserver<>(
    public SearchServiceImpl(
            breaker.addWithoutBreaking(-requestSize);
        if (circuitBreakerService == null) {  
        AggregationBuilderProtoConverterRegistry aggregationRegistry,
                responseObserver,  
     * @param request The delete PIT request to process
                responseObserver,
            responseObserver.onError(grpcError);
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
    private final AbstractQueryBuilderProtoUtils queryUtils;  
        CircuitBreaker breaker = circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);  
     * @param request The PIT request to process  
import org.opensearch.transport.grpc.listeners.SearchRequestActionListener;
}  
/*  
            breaker.addEstimateBytesAndMaybeBreak(requestSize, "<grpc_request>");
            logger.debug("Circuit breaker tripped for gRPC delete PIT request: {}", e.getMessage());
        CircuitBreakerService circuitBreakerService
            responseObserver.onError(grpcError);  
                requestSize
            breaker.addEstimateBytesAndMaybeBreak(requestSize, "<grpc_request>");  
import org.apache.logging.log4j.LogManager;
    public void createPit(
                circuitBreakerService,  
    }
    ) {
     * Processes a delete PIT request.  
        this.aggregationRegistry = aggregationRegistry;  
     * @param aggregationRegistry Aggregation registry for parsing protobuf aggregations (request-side)
        if (queryUtils == null) {  
    }  
        try {
            );  
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);  
        } catch (CircuitBreakingException e) {
                requestSize
