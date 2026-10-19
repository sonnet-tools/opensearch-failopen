 * This class specifically handles the conversion of FailedNodeException instances
import java.util.HashMap;  
     * @return A Protocol Buffer Struct containing the exception metadata
import java.util.Map;
        Map<String, ObjectMap.Value> map = new HashMap<>();
 * to their Protocol Buffer representation, preserving metadata about node failures  
     * Converts the metadata from a FailedNodeException to a Protocol Buffer Struct.
 *
import org.opensearch.core.xcontent.ToXContent;
/*  
/**  
        // Utility class, no instances  
package org.opensearch.transport.grpc.proto.response.exceptions;
 * this file be licensed under the Apache-2.0 license or a
    /**  
    }
        return map;
 */
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
        map.put("node_id", ObjectMapProtoUtils.toProto(exception.nodeId()));  
    public static Map<String, ObjectMap.Value> metadataToProto(FailedNodeException exception) {
}  
 */  
     * Similar to {@link FailedNodeException#metadataToXContent(XContentBuilder, ToXContent.Params)}     *
 * in a distributed OpenSearch cluster.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.protobufs.ObjectMap;  
     */  
     *  
 * Utility class for converting FailedNodeException objects to Protocol Buffers.
     * @param exception The FailedNodeException to convert
public class FailedNodeExceptionProtoUtils {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.FailedNodeException;  
import org.opensearch.transport.grpc.proto.response.common.ObjectMapProtoUtils;
    private FailedNodeExceptionProtoUtils() {
    }
