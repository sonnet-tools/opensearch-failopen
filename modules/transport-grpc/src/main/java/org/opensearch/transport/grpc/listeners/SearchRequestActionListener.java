     * @param aggregateRegistry the converter registry for dispatching aggregation conversions  
        responseObserver.onError(grpcError);
import org.apache.logging.log4j.LogManager;
     * Constructs a new SearchRequestActionListener.  
        this.responseObserver = responseObserver;
* compatible open source license.
import java.io.IOException;  
            org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(response, aggregateRegistry);  
     */
import io.grpc.stub.StreamObserver;  
        StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
    }  
        StreamObserver<org.opensearch.protobufs.SearchResponse> responseObserver,  
    private static final Logger logger = LogManager.getLogger(SearchRequestActionListener.class);  
*/  
 */
        try {
            responseObserver.onNext(protoResponse);
* SPDX-License-Identifier: Apache-2.0
 * Listener for search request execution completion, handling successful and failure scenarios.  
    private final AggregateProtoConverterRegistry aggregateRegistry;  
    }
    private final StreamObserver<org.opensearch.protobufs.SearchResponse> responseObserver;
public class SearchRequestActionListener implements ActionListener<SearchResponse> {
    public SearchRequestActionListener(
            responseObserver.onError(grpcError);  
        AggregateProtoConverterRegistry aggregateRegistry
            responseObserver.onCompleted();
* The OpenSearch Contributors require contributions made to  
import org.opensearch.core.action.ActionListener;
import org.opensearch.transport.grpc.util.GrpcErrorHandler;
*
}
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
/**
import org.opensearch.transport.grpc.proto.response.search.SearchResponseProtoUtils;
     *
* this file be licensed under the Apache-2.0 license or a
     * @param responseObserver the gRPC stream observer to send the search response to
    public void onResponse(SearchResponse response) {  
        logger.debug("SearchRequestActionListener failed to process search request: " + e.getMessage());  
package org.opensearch.transport.grpc.listeners;
        }
    ) {
            logger.error("Failed to convert search response to protobuf: " + e.getMessage());
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;  
import org.apache.logging.log4j.Logger;
    }  
/*  
    /**
        } catch (RuntimeException | IOException e) {  
import org.opensearch.action.search.SearchResponse;  
    @Override
    public void onFailure(Exception e) {
import io.grpc.StatusRuntimeException;
        this.aggregateRegistry = aggregateRegistry;
    @Override
        super();  
        // Search execution succeeded. Convert the opensearch internal response to protobuf
