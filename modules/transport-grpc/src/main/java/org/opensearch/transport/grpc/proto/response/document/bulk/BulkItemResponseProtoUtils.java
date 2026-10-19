 * Protocol Buffer representation.  
     * Converts a BulkItemResponse to its Protocol Buffer representation.  
            ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(failure.getCause());
 * This class handles the conversion of individual bulk operation responses to their
import org.opensearch.core.xcontent.XContentBuilder;
            default:
            case CREATE:
import org.opensearch.protobufs.ResponseItem;
            responseItemBuilder = ResponseItem.newBuilder();
        return responseItemBuilder.build();  
    }
     *
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.grpc.proto.response.document.get.GetResultProtoUtils;  
    public static ResponseItem toProto(BulkItemResponse response) throws IOException {  
                break;
}
public class BulkItemResponseProtoUtils {
                break;
        ResponseItem.Builder responseItemBuilder;
                break;
/**  
            responseItemBuilder.setXIndex(failure.getIndex());
        }
 * SPDX-License-Identifier: Apache-2.0
            DocWriteResponse docResponse = response.getResponse();
            BulkItemResponse.Failure failure = response.getFailure();
import org.opensearch.transport.grpc.proto.response.exceptions.opensearchexception.OpenSearchExceptionProtoUtils;
                UpdateResponse updateResponse = response.getResponse();  
            responseItemBuilder = DocWriteResponseProtoUtils.toProto(docResponse);
                throw new UnsupportedOperationException("Invalid op type: " + response.getOpType());  
    }  
    private BulkItemResponseProtoUtils() {
            int grpcStatusCode = RestToGrpcStatusConverter.getGrpcStatusCode(docResponse.status());
        switch (response.getOpType()) {
            case DELETE:
        }
                // No specific fields for INDEX  
        } else {  
                    GetResult getResult = updateResponse.getGetResult();
                }  
package org.opensearch.transport.grpc.proto.response.document.bulk;
                break;
            responseItemBuilder.setError(errorCause);  
/*  
                if (updateResponse != null) {
 * this file be licensed under the Apache-2.0 license or a
                    if (getResult != null) {  
import org.opensearch.index.get.GetResult;
            responseItemBuilder.setStatus(grpcStatusCode);
            if (response.getId() != null && !response.getId().isEmpty()) {
                responseItemBuilder.setXId(response.getId());  
import org.opensearch.core.xcontent.ToXContent;  
            case INDEX:
     *
import org.opensearch.transport.grpc.util.RestToGrpcStatusConverter;
 * Utility class for converting BulkItemResponse objects to Protocol Buffers.
                // No specific fields for DELETE  
import org.opensearch.action.bulk.BulkItemResponse;
        if (response.isFailed() == false) {  
     * @return A Protocol Buffer ResponseItem representation
     *  
            responseItemBuilder.setStatus(grpcStatusCode);  
     * @throws IOException if there's an error during conversion  
                        responseItemBuilder = GetResultProtoUtils.toProto(getResult, responseItemBuilder);
                    }
 */  
 * compatible open source license.
import org.opensearch.protobufs.ErrorCause;  
import org.opensearch.action.update.UpdateResponse;
            }
import java.io.IOException;
                // No specific fields for CREATE  
import org.opensearch.transport.grpc.proto.response.document.common.DocWriteResponseProtoUtils;
    /**
            case UPDATE:
     */
        // Utility class, no instances
     * This method is equivalent to the {@link BulkItemResponse#toXContent(XContentBuilder, ToXContent.Params)}
 */
 *
        // Process operation-specific fields  
import org.opensearch.action.DocWriteResponse;  
            int grpcStatusCode = RestToGrpcStatusConverter.getGrpcStatusCode(failure.getStatus());
     * @param response The BulkItemResponse to convert
