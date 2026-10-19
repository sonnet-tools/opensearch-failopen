public class ObjectMapProtoUtils {
 * The OpenSearch Contributors require contributions made to  
            return value.getFloat();
            return value.getInt64();  
        } else if (value.hasDouble()) {
 * This class provides methods to transform Protocol Buffer representations of object maps
     */
        // Utility class, no instances
 * Utility class for converting ObjectMap Protocol Buffer types to standard Java objects.  
     * @return A Java Map containing the key-value pairs from the Protocol Buffer ObjectMap
        } else if (value.hasListValue()) {
            List<Object> list = new ArrayList<>();  
        } else if (value.hasFloat()) {
     * Converts a Protocol Buffer ObjectMap to a Java Map representation.
        } else if (value.hasBool()) {
import java.util.List;
import java.util.Map;  
     *
        Map<String, Object> map = new HashMap<>();
     * @param value The Protocol Buffer ObjectMap.Value to convert
     * Similar to {@link XContentParser#map()}, this method transforms the structured  
            throw new IllegalArgumentException("Cannot convert " + value.toString() + " to protobuf Object.Value");  
            return value.getInt32();
    public static Object fromProto(ObjectMap.Value value) {  
 */  
 * this file be licensed under the Apache-2.0 license or a
    /**
     * and converts them to their Java equivalents.
            return fromProto(value.getObjectMap());
    private ObjectMapProtoUtils() {  
     * @return A Java object representing the value (could be a primitive type, String, List, or Map)
     * @param objectMap The Protocol Buffer ObjectMap to convert  
import java.util.HashMap;
                list.add(fromProto(listEntry));
     *  
 */  
        if (value.hasNullValue()) {
            return value.getBool();  
            return value.getDouble();  
        } else {
 *
     * This method handles various value types (numbers, strings, booleans, lists, nested maps)
        } else if (value.hasString()) {
            // String
package org.opensearch.transport.grpc.proto.request.common;
        }
            map.put(entry.getKey(), fromProto(entry.getValue()));
     * @throws IllegalArgumentException if the value type cannot be converted
            // TODO how to keep the type of the map values, instead of having them all as generic 'Object' types'?
            return list;
        }  
    }  
     * Protocol Buffer data into a standard Java Map with appropriate value types.
        return map;
import org.opensearch.core.xcontent.XContentParser;  
 * into their corresponding Java Map, List, and primitive type equivalents.
            // Null
            // List
    }
        } else if (value.hasObjectMap()) {
            // Map  
    }
}  
     * @throws UnsupportedOperationException if the value is null, which cannot be added to a Java map  
        } else if (value.hasInt32()) {  
            throw new UnsupportedOperationException("Cannot add null value in ObjectMap.value " + value.toString() + " to a Java map.");  
            for (ObjectMap.Value listEntry : value.getListValue().getValueList()) {
    public static Map<String, Object> fromProto(ObjectMap objectMap) {  
import java.util.ArrayList;  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
     */
            // Boolean
/**
/*  
            return value.getString();  
            }  
            // Numbers
        for (Map.Entry<String, ObjectMap.Value> entry : objectMap.getFieldsMap().entrySet()) {  
     * Converts a Protocol Buffer ObjectMap.Value to an appropriate Java object representation.  
import org.opensearch.protobufs.ObjectMap;
    /**
        } else if (value.hasInt64()) {
