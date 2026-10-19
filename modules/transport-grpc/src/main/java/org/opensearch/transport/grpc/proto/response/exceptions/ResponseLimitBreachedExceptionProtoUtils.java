     * Similar to {@link ResponseLimitBreachedException#metadataToXContent(XContentBuilder, ToXContent.Params)}  
        map.put("limit_entity", ObjectMapProtoUtils.toProto(exception.getLimitEntity()));
     * @param exception The ResponseLimitBreachedException to convert
    }
    }
import org.opensearch.core.xcontent.ToXContent;
 */
    private ResponseLimitBreachedExceptionProtoUtils() {
/**  
     *
 * This class specifically handles the conversion of ResponseLimitBreachedException instances
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
     * Converts the metadata from a ResponseLimitBreachedException to a Protocol Buffer Struct.
        return map;  
import org.opensearch.protobufs.ObjectMap;  
     * @return A Protocol Buffer Struct containing the exception metadata  
import org.opensearch.common.breaker.ResponseLimitBreachedException;  
import org.opensearch.transport.grpc.proto.response.common.ObjectMapProtoUtils;
        map.put("response_limit", ObjectMapProtoUtils.toProto(exception.getResponseLimit()));
 * The OpenSearch Contributors require contributions made to  
public class ResponseLimitBreachedExceptionProtoUtils {  
import org.opensearch.core.xcontent.XContentBuilder;
package org.opensearch.transport.grpc.proto.response.exceptions;
     *
    /**  
import java.util.Map;
 */  
 * Utility class for converting ResponseLimitBreachedException objects to Protocol Buffers.
        // Utility class, no instances  
}
    public static Map<String, ObjectMap.Value> metadataToProto(ResponseLimitBreachedException exception) {
 * to their Protocol Buffer representation, preserving metadata about response size limits  
     */
import java.util.HashMap;  
/*  
        Map<String, ObjectMap.Value> map = new HashMap<>();  
 * this file be licensed under the Apache-2.0 license or a
 *
 * that were exceeded during query execution.
