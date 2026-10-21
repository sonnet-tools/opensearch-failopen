    public void deletePit(
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
        StreamObserver<org.opensearch.protobufs.CreatePITResponse> responseObserver
            StreamObserver<org.opensearch.protobufs.SearchResponse> wrappedObserver = new CircuitBreakerStreamObserver<>(
        try {
    private final Client client;
            org.opensearch.action.search.SearchRequest searchRequest = SearchRequestProtoUtils.prepareRequest(
    /**
            breaker.addEstimateBytesAndMaybeBreak(requestSize, "<grpc_request>");
            responseObserver.onError(grpcError);
        AggregationBuilderProtoConverterRegistry aggregationRegistry,
import org.opensearch.transport.grpc.proto.request.search.CreatePitRequestProtoUtils;
            responseObserver.onError(grpcError);
     */
     * @param aggregationRegistry Aggregation registry for parsing protobuf aggregations (request-side)
        CircuitBreaker breaker = circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
            throw new IllegalArgumentException("Circuit breaker service cannot be null");
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
        AggregateProtoConverterRegistry aggregateRegistry,
import io.grpc.StatusRuntimeException;
                responseObserver,
     *
            DeletePitRequestActionListener listener = new DeletePitRequestActionListener(wrappedObserver);
import org.opensearch.transport.grpc.util.CircuitBreakerStreamObserver;
 * executes them using the provided client, and returns the results back to the gRPC client.
 * compatible open source license.
        StreamObserver<org.opensearch.protobufs.SearchResponse> responseObserver
 * Implementation of the gRPC SearchService.
            logger.debug("Circuit breaker tripped for gRPC search request: {}", e.getMessage());
    public SearchServiceImpl(
            responseObserver.onError(grpcError);
            responseObserver.onError(grpcError);
    }
 */
            );
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
            breaker.addWithoutBreaking(-requestSize);
public class SearchServiceImpl extends SearchServiceGrpc.SearchServiceImplBase {
            );
     *
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
        this.aggregateRegistry = aggregateRegistry;
                responseObserver,
import org.opensearch.core.common.breaker.CircuitBreakingException;
    private final CircuitBreakerService circuitBreakerService;
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Query utils cannot be null");
     * @param circuitBreakerService Circuit breaker service for tracking in-flight requests
        this.circuitBreakerService = circuitBreakerService;
     * Processes a search request.
 */
/**
                aggregationRegistry
     * @param request The delete PIT request to process
            StreamObserver<org.opensearch.protobufs.DeletePITResponse> wrappedObserver = new CircuitBreakerStreamObserver<>(
        }
        }
    ) {
import org.opensearch.transport.grpc.util.GrpcErrorHandler;
import org.opensearch.transport.grpc.listeners.SearchRequestActionListener;
                client,
            logger.debug("SearchServiceImpl failed to process search request, request=" + request + ", error=" + e.getMessage());
            responseObserver.onError(grpcError);
     * @param client Client for executing actions on the local node
        if (aggregationRegistry == null) {
            responseObserver.onError(grpcError);
     * Creates a new SearchServiceImpl.
            logger.debug("SearchServiceImpl failed to process create PIT request, request={}, error={}", request, e.getMessage());
                circuitBreakerService,
        }
        } catch (RuntimeException | IOException e) {
            throw new IllegalArgumentException("Aggregation registry cannot be null");
                requestSize
        org.opensearch.protobufs.SearchRequest request,
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
     * @param queryUtils Query utils instance for parsing protobuf queries
        int requestSize = request.getSerializedSize();
    ) {
                request,
     * Processes a delete PIT request.
        CircuitBreaker breaker = circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
        this.aggregationRegistry = aggregationRegistry;
            breaker.addEstimateBytesAndMaybeBreak(requestSize, "<grpc_request>");
    /**
            client.createPit(createPitRequest, listener);
        }
        if (client == null) {
import io.grpc.stub.StreamObserver;
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;
import org.opensearch.transport.grpc.proto.request.search.DeletePitRequestProtoUtils;
        if (queryUtils == null) {
                circuitBreakerService,
package org.opensearch.transport.grpc.services;
        this.queryUtils = queryUtils;
            breaker.addWithoutBreaking(-requestSize);
import org.opensearch.transport.grpc.listeners.DeletePitRequestActionListener;
        int requestSize = request.getSerializedSize();
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
            breaker.addWithoutBreaking(-requestSize);
            logger.debug("SearchServiceImpl failed to process delete PIT request, request={}, error={}", request, e.getMessage());
                circuitBreakerService,
    public void search(
     */
            logger.debug("Circuit breaker tripped for gRPC create PIT request: {}", e.getMessage());
    ) {
            StreamObserver<org.opensearch.protobufs.CreatePITResponse> wrappedObserver = new CircuitBreakerStreamObserver<>(
            logger.debug("Circuit breaker tripped for gRPC delete PIT request: {}", e.getMessage());
            throw new IllegalArgumentException("Client cannot be null");
                responseObserver,
import org.opensearch.transport.client.Client;
     */
        int requestSize = request.getSerializedSize();
                queryUtils,
     * Processes a create PIT request.
        CircuitBreakerService circuitBreakerService
    }
    }
 * This class handles incoming gRPC search requests, converts them to OpenSearch search requests,
        }
        }
     * @param responseObserver The observer to send the response back to the client
        Client client,
    private final AggregationBuilderProtoConverterRegistry aggregationRegistry;
        } catch (CircuitBreakingException e) {
 * this file be licensed under the Apache-2.0 license or a
     *
        if (circuitBreakerService == null) {
            throw new IllegalArgumentException("Aggregate registry cannot be null");
        }
            CreatePitRequestActionListener listener = new CreatePitRequestActionListener(wrappedObserver);
        } catch (RuntimeException e) {
            client.deletePits(deletePitRequest, listener);
        try {
        StreamObserver<org.opensearch.protobufs.DeletePITResponse> responseObserver
            );
import org.opensearch.protobufs.services.SearchServiceGrpc;
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
        if (aggregateRegistry == null) {
 * SPDX-License-Identifier: Apache-2.0
    private static final Logger logger = LogManager.getLogger(SearchServiceImpl.class);
/*
    private final AbstractQueryBuilderProtoUtils queryUtils;
            org.opensearch.action.search.CreatePitRequest createPitRequest = CreatePitRequestProtoUtils.prepareRequest(request);
    @Override
            breaker.addEstimateBytesAndMaybeBreak(requestSize, "<grpc_request>");
        org.opensearch.protobufs.DeletePitRequest request,
    ) {
    private final AggregateProtoConverterRegistry aggregateRegistry;
        }
            org.opensearch.action.search.DeletePitRequest deletePitRequest = DeletePitRequestProtoUtils.prepareRequest(request);
            client.search(searchRequest, listener);
     */
import java.io.IOException;
        } catch (CircuitBreakingException e) {
     * @param aggregateRegistry Aggregate registry for converting aggregation results (response-side)
    @Override
    @Override
import org.opensearch.core.indices.breaker.CircuitBreakerService;
    public void createPit(
        AbstractQueryBuilderProtoUtils queryUtils,
    /**
    }
     * @param responseObserver The observer to send the response back to the client
        try {
            );
    /**
        } catch (CircuitBreakingException e) {
import org.opensearch.transport.grpc.listeners.CreatePitRequestActionListener;
import org.opensearch.core.common.breaker.CircuitBreaker;
 * The OpenSearch Contributors require contributions made to
 *
}
                requestSize
                requestSize
import org.opensearch.transport.grpc.proto.request.search.SearchRequestProtoUtils;
     * @param request The search request to process
     * @param request The PIT request to process
     *
     * @param responseObserver The observer to send the response back to the client
        this.client = client;
            SearchRequestActionListener listener = new SearchRequestActionListener(wrappedObserver, aggregateRegistry);
        org.opensearch.protobufs.CreatePitRequest request,
        CircuitBreaker breaker = circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
