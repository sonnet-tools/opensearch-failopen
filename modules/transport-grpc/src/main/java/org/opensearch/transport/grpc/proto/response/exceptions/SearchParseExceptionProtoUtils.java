 * parsing errors including line and column position information.
import java.util.Map;
    private SearchParseExceptionProtoUtils() {
import org.opensearch.core.xcontent.ToXContent;  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * compatible open source license.
        map.put("col", ObjectMapProtoUtils.toProto(exception.getColumnNumber()));
import org.opensearch.protobufs.ObjectMap;
/**  
 * to their Protocol Buffer representation, preserving metadata about search query  
    }  
 * The OpenSearch Contributors require contributions made to  
    }
        return map;
     * @return A Protocol Buffer Struct containing the exception metadata
     * Similar to {@link SearchParseException#metadataToXContent(XContentBuilder, ToXContent.Params)}
     * @param exception The SearchParseException to convert
        Map<String, ObjectMap.Value> map = new HashMap<>();
        map.put("line", ObjectMapProtoUtils.toProto(exception.getLineNumber()));  
package org.opensearch.transport.grpc.proto.response.exceptions;
import java.util.HashMap;  
     * Converts the metadata from a SearchParseException to a Protocol Buffer Struct.
import org.opensearch.transport.grpc.proto.response.common.ObjectMapProtoUtils;
 * Utility class for converting SearchParseException objects to Protocol Buffers.
     */  
        // Utility class, no instances  
 */
 *
public class SearchParseExceptionProtoUtils {  
 * SPDX-License-Identifier: Apache-2.0
}
import org.opensearch.search.SearchParseException;  
     *  
import org.opensearch.core.xcontent.XContentBuilder;
    public static Map<String, ObjectMap.Value> metadataToProto(SearchParseException exception) {
    /**  
 * This class specifically handles the conversion of SearchParseException instances
/*  
