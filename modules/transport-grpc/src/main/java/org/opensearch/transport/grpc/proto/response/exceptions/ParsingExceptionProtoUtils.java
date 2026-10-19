import static org.opensearch.core.common.ParsingException.UNKNOWN_POSITION;
 * Utility class for converting ParsingException objects to Protocol Buffers.
    private ParsingExceptionProtoUtils() {
public class ParsingExceptionProtoUtils {  
 * to their Protocol Buffer representation, preserving metadata about parsing errors  
 * compatible open source license.
 * including line and column position information when available.
import org.opensearch.core.common.ParsingException;  
        if (exception.getLineNumber() != UNKNOWN_POSITION) {
            map.put("col", ObjectMapProtoUtils.toProto(exception.getColumnNumber()));
     * Converts the metadata from a ParsingException to a Protocol Buffer Struct.
import org.opensearch.transport.grpc.proto.response.common.ObjectMapProtoUtils;
import java.util.HashMap;
 */  
 */
    /**  
        return map;  
     * when available (when not equal to UNKNOWN_POSITION), which helps identify  
/*  
     * @param exception The ParsingException to convert  
        Map<String, ObjectMap.Value> map = new HashMap<>();
    public static Map<String, ObjectMap.Value> metadataToProto(ParsingException exception) {  
     * This method extracts line and column position information from the exception
 * SPDX-License-Identifier: Apache-2.0
    }
/**  
 * This class specifically handles the conversion of ParsingException instances
    }
     */
}
 *
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.transport.grpc.proto.response.exceptions;
            map.put("line", ObjectMapProtoUtils.toProto(exception.getLineNumber()));  
        // Utility class, no instances  
        }
import java.util.Map;
     * @return A Protocol Buffer Struct containing the exception metadata
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.protobufs.ObjectMap;
     * the exact location of parsing errors in the input content.
     *
