import org.opensearch.protobufs.ObjectMap;  
public class CircuitBreakingExceptionProtoUtils {  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * to their Protocol Buffer representation, preserving metadata about memory limits  
    public static Map<String, ObjectMap.Value> metadataToProto(CircuitBreakingException exception) {
        map.put("bytes_wanted", ObjectMapProtoUtils.toProto(exception.getBytesWanted()));  
    private CircuitBreakingExceptionProtoUtils() {
 * compatible open source license.
/*  
 */
     * @return A Protocol Buffer Struct containing the exception metadata
}
     */  
import org.opensearch.core.xcontent.ToXContent;
     * @param exception The CircuitBreakingException to convert
package org.opensearch.transport.grpc.proto.response.exceptions;
 * Utility class for converting CircuitBreakingException objects to Protocol Buffers.
 * this file be licensed under the Apache-2.0 license or a
        Map<String, ObjectMap.Value> map = new HashMap<>();
import org.opensearch.core.xcontent.XContentBuilder;
     * Converts the metadata from a CircuitBreakingException to a Protocol Buffer Struct.
    }
        map.put("durability", ObjectMapProtoUtils.toProto(exception.getDurability()));
 *
        return map;  
 * and circuit breaker durability.
/**  
 * The OpenSearch Contributors require contributions made to  
    /**  
import org.opensearch.core.common.breaker.CircuitBreakingException;  
    }
     * Similar to {@link CircuitBreakingException#metadataToXContent(XContentBuilder, ToXContent.Params)}     *
import java.util.Map;
        // Utility class, no instances  
import org.opensearch.transport.grpc.proto.response.common.ObjectMapProtoUtils;
     *  
        map.put("bytes_limit", ObjectMapProtoUtils.toProto(exception.getByteLimit()));
 * This class specifically handles the conversion of CircuitBreakingException instances
import java.util.HashMap;  
