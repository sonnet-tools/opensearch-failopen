 * including script stack traces, language information, and position details.
    private ScriptExceptionProtoUtils() {
 * SPDX-License-Identifier: Apache-2.0
     * Similar to {@link ScriptException#metadataToXContent(XContentBuilder, ToXContent.Params)}
public class ScriptExceptionProtoUtils {  
        // Add the position value to the main map  
    }
     * @return The updated map with position information added
    /**  
 *
            map = toProto(map, exception.getPos());
        map.put("script", ObjectMapProtoUtils.toProto(exception.getScript()));
/**  
 * this file be licensed under the Apache-2.0 license or a
 * Utility class for converting ScriptException objects to Protocol Buffers.
        ObjectMap.Builder positionMapBuilder = ObjectMap.newBuilder();
     *
        map.put("lang", ObjectMapProtoUtils.toProto(exception.getLang()));  
     * @param pos The ScriptException.Position containing position details  
import org.opensearch.core.xcontent.ToXContent;  
     * Converts the metadata from a ScriptException to a Protocol Buffer Struct.
     * @return A Protocol Buffer Struct containing the exception metadata
import org.opensearch.core.xcontent.XContentBuilder;
     */  
        }  
        positionMapBuilder.putFields("end", ObjectMapProtoUtils.toProto(pos.end));
    }
     */
    public static Map<String, ObjectMap.Value> toProto(Map<String, ObjectMap.Value> map, ScriptException.Position pos) {  
     * @param exception The ScriptException to convert
}
import org.opensearch.protobufs.ObjectMap;
        positionMapBuilder.putFields("start", ObjectMapProtoUtils.toProto(pos.start));  
 */  
    /**
import org.opensearch.script.ScriptException;  
 * compatible open source license.
        if (exception.getPos() != null) {
        Map<String, ObjectMap.Value> map = new HashMap<>();
    }
        ObjectMap.Value positionValue = ObjectMap.Value.newBuilder().setObjectMap(positionMapBuilder.build()).build();
 * This class specifically handles the conversion of ScriptException instances
        // Utility class, no instances  
        // Create a map for position information
package org.opensearch.transport.grpc.proto.response.exceptions;
        // Add position fields
/*  
        positionMapBuilder.putFields("offset", ObjectMapProtoUtils.toProto(pos.offset));
     * @param map The map to add position information to
     * Similar to {@link ScriptException.Position#toXContent(XContentBuilder, ToXContent.Params)}  
 * The OpenSearch Contributors require contributions made to  
        return map;
 */
        // Create a value with the position map  
        map.put("position", positionValue);
        map.put("script_stack", ObjectMapProtoUtils.toProto(exception.getScriptStack()));
import org.opensearch.transport.grpc.proto.response.common.ObjectMapProtoUtils;
import java.util.HashMap;  
        return map;  
     *  
    public static Map<String, ObjectMap.Value> metadataToProto(ScriptException exception) {
import java.util.Map;
     * Converts a ScriptException.Position to Protocol Buffer format and adds it to the given builder.
 * to their Protocol Buffer representation, preserving metadata about script errors  
