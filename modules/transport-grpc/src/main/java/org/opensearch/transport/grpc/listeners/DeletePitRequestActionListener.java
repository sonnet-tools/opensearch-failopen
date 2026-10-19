/**  
import org.opensearch.protobufs.DeletePITResponse;
 * The OpenSearch Contributors require contributions made to  
            responseObserver.onError(grpcError);
     * Creates a listener that forwards PIT deletion responses to the gRPC stream.  
import io.grpc.StatusRuntimeException;  
            DeletePITResponse protoResponse = DeletePitResponseProtoUtils.toProto(response);
        }  
            StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);
        try {
    private static final Logger logger = LogManager.getLogger(DeletePitRequestActionListener.class);
    /**
            logger.error("Failed to convert delete PIT response to protobuf: {}", e.getMessage());  
package org.opensearch.transport.grpc.listeners;
 * this file be licensed under the Apache-2.0 license or a
}  
        StatusRuntimeException grpcError = GrpcErrorHandler.convertToGrpcError(e);  
        logger.debug("DeletePitRequestActionListener failed to process delete PIT request: {}", e.getMessage());
    }
        responseObserver.onError(grpcError);
import org.opensearch.transport.grpc.proto.response.search.DeletePitResponseProtoUtils;  
public class DeletePitRequestActionListener implements ActionListener<DeletePitResponse> {  
    @Override  
        } catch (RuntimeException e) {
 * compatible open source license.
     */  
     * @param responseObserver the observer that receives the protobuf response
import org.apache.logging.log4j.Logger;
    public void onFailure(Exception e) {
    }  
 * SPDX-License-Identifier: Apache-2.0
/*  
 *
    public DeletePitRequestActionListener(StreamObserver<DeletePITResponse> responseObserver) {
 */
        this.responseObserver = responseObserver;
import io.grpc.stub.StreamObserver;
    public void onResponse(DeletePitResponse response) {  
 * Listener for PIT deletion request completion.
import org.opensearch.core.action.ActionListener;
            responseObserver.onNext(protoResponse);  
 */  
     *
import org.opensearch.action.search.DeletePitResponse;  
    private final StreamObserver<DeletePITResponse> responseObserver;  
    }
    @Override
import org.apache.logging.log4j.LogManager;
import org.opensearch.transport.grpc.util.GrpcErrorHandler;
            responseObserver.onCompleted();
