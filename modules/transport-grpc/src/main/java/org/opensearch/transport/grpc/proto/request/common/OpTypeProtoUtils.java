            default:
    public static DocWriteRequest.OpType fromProto(OpType opType) {
package org.opensearch.transport.grpc.proto.request.common;
public class OpTypeProtoUtils {  
 * Utility class for converting OpType Protocol Buffers to OpenSearch DocWriteRequest.OpType objects.
        // Utility class, no instances  
     * @param opType The Protocol Buffer OpType to convert
            case OP_TYPE_UNSPECIFIED:  
            case OP_TYPE_INDEX:
    }
                throw new UnsupportedOperationException("Invalid optype: " + opType);
     * Converts a Protocol Buffer OpType to its corresponding OpenSearch DocWriteRequest.OpType.
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
/*  
}
     */
     * Similar to {@link DocWriteRequest.OpType}.
        switch (opType) {
 */
                return DocWriteRequest.OpType.INDEX;
 * this file be licensed under the Apache-2.0 license or a
 * This class handles the conversion of Protocol Buffer representations to their  
    private OpTypeProtoUtils() {
 * compatible open source license.
import org.opensearch.protobufs.OpType;
     * @return The corresponding OpenSearch DocWriteRequest.OpType
 * corresponding OpenSearch operation type enumerations.
/**
 *
        }  
 */  
     * @throws UnsupportedOperationException if the operation type is not supported  
     *  
            case OP_TYPE_CREATE:
    }
                return DocWriteRequest.OpType.CREATE;  
import org.opensearch.action.DocWriteRequest;
    /**  
