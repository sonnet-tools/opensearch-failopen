            return;
        }
     *
            case Double d -> valueBuilder.setDouble(d);
/**  
 * The OpenSearch Contributors require contributions made to  
            valueBuilder.setNullValue(NullValue.NULL_VALUE_NULL);  
 * SPDX-License-Identifier: Apache-2.0
                Map<String, Object> map = (Map<String, Object>) m;  
        ObjectMap.Value.Builder valueBuilder = ObjectMap.Value.newBuilder();
        toProto(javaObject, valueBuilder);
import org.opensearch.protobufs.NullValue;  
import org.opensearch.protobufs.ObjectMap;
            }
}
        switch (javaObject) {
     */
     * @param javaObject The java object to convert  
     * @param javaObject The java object to convert  
        ObjectMap.ListValue.Builder listBuilder = ObjectMap.ListValue.newBuilder();
    }
     * @param map The map to convert  
    /**  
    public static void toProto(Object javaObject, ObjectMap.Value.Builder valueBuilder) {  
            case Map<?, ?> m -> {
     * @return A Protobuf ObjectMap.Value representation
 */
        }
        // Utility class, no instances  
        if (javaObject == null) {
            case String s -> valueBuilder.setString(s);
     * Converts a generic Java Object to its Protocol Buffer representation.
            case Long l -> valueBuilder.setInt64(l);
            default -> throw new IllegalArgumentException("Cannot convert " + javaObject + " to google.protobuf.Struct");  
     */  
public class ObjectMapProtoUtils {  
            toProto(listEntry, entryBuilder);
    }
     */
    /**
    /**  
            toProto(entry.getValue(), entryValueBuilder);
 * Utility class for converting generic Java objects to google.protobuf.Struct Protobuf type.
        // Process each list entry
            objectMapBuilder.putFields(entry.getKey(), entryValueBuilder.build());  
    private static void handleListValue(List<?> list, ObjectMap.Value.Builder valueBuilder) {
 *
package org.opensearch.transport.grpc.proto.response.common;
                @SuppressWarnings("unchecked")
     * Converts a generic Java Object to its Protocol Buffer representation.
            case Boolean b -> valueBuilder.setBool(b);
     *  
    @SuppressWarnings("unchecked")  
            case List<?> list -> handleListValue(list, valueBuilder);  
            case Integer i -> valueBuilder.setInt32(i);  
     *
            // Null
    private ObjectMapProtoUtils() {
        valueBuilder.setObjectMap(objectMapBuilder.build());  
    }
     * Helper method to handle Map values.
 */  
/*  
import java.util.Map;
    /**  
     * @param valueBuilder The builder to populate with the map data
        valueBuilder.setListValue(listBuilder.build());  
        }
     *
import java.util.List;  
            ObjectMap.Value.Builder entryValueBuilder = ObjectMap.Value.newBuilder();
    private static void handleMapValue(Map<String, Object> map, ObjectMap.Value.Builder valueBuilder) {
     * @param list The list to convert
    }
            // Create a new builder for each list entry  
 * compatible open source license.
            case Enum<?> e -> valueBuilder.setString(e.toString());
        return valueBuilder.build();  
        // Process each map entry
        for (Object listEntry : list) {
                handleMapValue(map, valueBuilder);
     * Helper method to handle List values.
            case Float f -> valueBuilder.setFloat(f);  
            ObjectMap.Value.Builder entryBuilder = ObjectMap.Value.newBuilder();
     */
 * this file be licensed under the Apache-2.0 license or a
            // Create a new builder for each map value  
        ObjectMap.Builder objectMapBuilder = ObjectMap.newBuilder();
     * @param valueBuilder The builder to populate with the list data
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            listBuilder.addValue(entryBuilder.build());  
    public static ObjectMap.Value toProto(Object javaObject) {  
    }
        }
     * @param valueBuilder The builder to populate with the java object data
