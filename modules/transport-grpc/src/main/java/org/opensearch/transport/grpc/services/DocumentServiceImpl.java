/**
            logger.debug("Circuit breaker tripped for gRPC bulk request: {}", e.getMessage());
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
    private static final Logger logger = LogManager.getLogger(DocumentServiceImpl.class);
    @Override
                responseObserver,
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);  
    public void bulk(org.opensearch.protobufs.BulkRequest request, StreamObserver<org.opensearch.protobufs.BulkResponse> responseObserver) {  
 * Implementation of the gRPC Document Service.
            responseObserver.onError(grpcError);
            breaker.addWithoutBreaking(-requestSize);  
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("Client cannot be null");
        if (client == null) {
    private final Client client;  
import org.opensearch.transport.grpc.listeners.BulkRequestActionListener;
import org.opensearch.protobufs.services.DocumentServiceGrpc;  
    private final CircuitBreakerService circuitBreakerService;
    /**  
            );
import org.apache.logging.log4j.LogManager;
     * Creates a new DocumentServiceImpl.
 *
     * @param client Client for executing actions on the local node  
    }
import org.opensearch.transport.grpc.util.CircuitBreakerStreamObserver;
        }  
import io.grpc.stub.StreamObserver;
     */
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        } catch (RuntimeException e) {
 * The OpenSearch Contributors require contributions made to  
        int requestSize = request.getSerializedSize();
import org.opensearch.core.common.breaker.CircuitBreakingException;
    }  
     * @param circuitBreakerService Circuit breaker service for memory protection
import org.apache.logging.log4j.Logger;
                circuitBreakerService,  
                requestSize
            responseObserver.onError(grpcError);  
            logger.debug("DocumentServiceImpl failed: {} - {}", e.getClass().getSimpleName(), e.getMessage());
        } catch (CircuitBreakingException e) {
     *
            breaker.addEstimateBytesAndMaybeBreak(requestSize, "<grpc_request>");
            StreamObserver<org.opensearch.protobufs.BulkResponse> wrappedObserver = new CircuitBreakerStreamObserver<>(
            org.opensearch.action.bulk.BulkRequest bulkRequest = BulkRequestProtoUtils.prepareRequest(request);
            BulkRequestActionListener listener = new BulkRequestActionListener(wrappedObserver);
import org.opensearch.transport.grpc.util.GrpcErrorHandler;
    /**
 * this file be licensed under the Apache-2.0 license or a
            client.bulk(bulkRequest, listener);  
public class DocumentServiceImpl extends DocumentServiceGrpc.DocumentServiceImplBase {
    public DocumentServiceImpl(Client client, CircuitBreakerService circuitBreakerService) {  
import org.opensearch.transport.client.Client;
        }  
        if (circuitBreakerService == null) {
import io.grpc.StatusRuntimeException;
import org.opensearch.core.common.breaker.CircuitBreaker;  
 */  
import org.opensearch.transport.grpc.proto.request.document.bulk.BulkRequestProtoUtils;  
            throw new IllegalArgumentException("Circuit breaker service cannot be null");
        }
     * @param responseObserver The observer to send the response back to the client  
        CircuitBreaker breaker = circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
     *
        this.circuitBreakerService = circuitBreakerService;
/*  
     */
     * Processes a bulk request.  
        this.client = client;
}  
 */  
package org.opensearch.transport.grpc.services;
     * @param request The bulk request to process
        try {
 * compatible open source license.
