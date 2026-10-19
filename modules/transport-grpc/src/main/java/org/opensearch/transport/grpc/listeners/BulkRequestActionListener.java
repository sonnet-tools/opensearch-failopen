import java.io.IOException;
     *
    /**  
 *
    /**
import org.opensearch.transport.grpc.util.GrpcErrorHandler;  
public class BulkRequestActionListener implements ActionListener<BulkResponse> {
     *  
        StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
     * @param responseObserver The gRPC stream observer to send the response back to the client
     * @param response The bulk response from OpenSearch
import org.opensearch.transport.grpc.proto.response.document.bulk.BulkResponseProtoUtils;
 */  
     */
import org.opensearch.core.action.ActionListener;
 * The OpenSearch Contributors require contributions made to  
    private final StreamObserver<org.opensearch.protobufs.BulkResponse> responseObserver;  
     * Handles bulk request execution failures.  
    @Override  
            responseObserver.onError(grpcError);
        super();
        responseObserver.onError(grpcError);  
     * @param e The exception that occurred during execution  
     * Creates a new BulkRequestActionListener.  
            logger.error("Failed to convert bulk response to protobuf: " + e.getMessage());
}
        this.responseObserver = responseObserver;  
import io.grpc.StatusRuntimeException;
        try {  
    public void onResponse(org.opensearch.action.bulk.BulkResponse response) {
     * Converts the exception to an appropriate gRPC error and sends it to the client.
     * Converts the OpenSearch internal response to protobuf format and sends it to the client.
    public BulkRequestActionListener(StreamObserver<org.opensearch.protobufs.BulkResponse> responseObserver) {
/**
        // Bulk execution succeeded. Convert the opensearch internal response to protobuf
     * Handles successful bulk request execution.
     */
    /**
    @Override
    public void onFailure(Exception e) {  
 * SPDX-License-Identifier: Apache-2.0
import io.grpc.stub.StreamObserver;
    }
    private static final Logger logger = LogManager.getLogger(BulkRequestActionListener.class);
 */  
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);  
        logger.error("BulkRequestActionListener failed to process bulk request: " + e.getMessage());
        }
            org.opensearch.protobufs.BulkResponse protoResponse = BulkResponseProtoUtils.toProto(response);
    }  
        } catch (RuntimeException | IOException e) {
package org.opensearch.transport.grpc.listeners;
import org.apache.logging.log4j.LogManager;
     */  
import org.apache.logging.log4j.Logger;
    }
     *
            responseObserver.onNext(protoResponse);
            responseObserver.onCompleted();  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.bulk.BulkResponse;  
/*  
 * Listener for bulk request execution completion, handling successful and failure scenarios.
