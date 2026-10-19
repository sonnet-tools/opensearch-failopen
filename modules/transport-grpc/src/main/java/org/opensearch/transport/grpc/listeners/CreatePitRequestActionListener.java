    public void onFailure(Exception e) {  
import org.opensearch.protobufs.CreatePITResponse;
        this.responseObserver = responseObserver;
package org.opensearch.transport.grpc.listeners;
        } catch (RuntimeException | IOException e) {
 */
    }  
/*  
import org.opensearch.transport.grpc.util.GrpcErrorHandler;
import org.opensearch.action.search.CreatePitResponse;  
    }
    public CreatePitRequestActionListener(StreamObserver<CreatePITResponse> responseObserver) {  
            responseObserver.onNext(protoResponse);
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    private static final Logger logger = LogManager.getLogger(CreatePitRequestActionListener.class);  
     *  
        try {  
import org.apache.logging.log4j.Logger;
        }
    }
     * @param responseObserver the observer that receives the protobuf response
    public void onResponse(CreatePitResponse response) {
    @Override
 * this file be licensed under the Apache-2.0 license or a
        StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
        responseObserver.onError(grpcError);  
import java.io.IOException;  
public class CreatePitRequestActionListener implements ActionListener<CreatePitResponse> {
 * Listener for PIT creation request completion.  
     * Creates a listener that forwards PIT creation responses to the gRPC stream.
            logger.error("Failed to convert create PIT response to protobuf: {}", e.getMessage());
    @Override
import org.apache.logging.log4j.LogManager;
 *
import io.grpc.stub.StreamObserver;  
            CreatePITResponse protoResponse = CreatePitResponseProtoUtils.toProto(response);
}
/**
 * SPDX-License-Identifier: Apache-2.0
        logger.debug("CreatePitRequestActionListener failed to process create PIT request: {}", e.getMessage());
    private final StreamObserver<CreatePITResponse> responseObserver;
            responseObserver.onCompleted();  
 */  
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);  
    /**
import io.grpc.StatusRuntimeException;
import org.opensearch.transport.grpc.proto.response.search.CreatePitResponseProtoUtils;  
            responseObserver.onError(grpcError);
     */
import org.opensearch.core.action.ActionListener;
