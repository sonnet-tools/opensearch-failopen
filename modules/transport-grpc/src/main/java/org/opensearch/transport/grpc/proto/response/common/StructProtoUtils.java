 * Utility class for converting generic Java objects to google.protobuf.Struct Protobuf type.  
            case Map<?, ?> map -> {
     * Converts a generic Java Object to its Protocol Buffer representation.  
 *
     * @return A Protobuf builder .google.protobuf.Struct representation  
import java.util.Map;  
            }
            default -> throw new IllegalArgumentException("Cannot convert " + javaObject.toString() + " to google.protobuf.Struct");  
        switch (javaObject) {
 */
                valueBuilder.setStructValue(structBuilder.build());
public class StructProtoUtils {
                    structBuilder.putFields(entry.getKey(), toProto(entry.getValue()));
            }
            case List<?> list -> {
     *
    /**
            case Number number -> valueBuilder.setNumberValue(number.doubleValue());
            case null -> valueBuilder.setNullValue(NullValue.NULL_VALUE);  
import com.google.protobuf.ListValue;  
 * compatible open source license.
        Value.Builder valueBuilder = Value.newBuilder();  
    public static Value toProto(Object javaObject) {
/*  
        }
 */  
                valueBuilder.setListValue(listBuilder.build());  
package org.opensearch.transport.grpc.proto.response.common;
import com.google.protobuf.NullValue;
        // Utility class, no instances
 * SPDX-License-Identifier: Apache-2.0
    }  
                for (Map.Entry<String, Object> entry : fieldMap.entrySet()) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
                for (Object listEntry : list) {  
            case String string -> valueBuilder.setStringValue(string);
    }
        return valueBuilder.build();  
                }  
     */
                    listBuilder.addValues(toProto(listEntry));
}
                Map<String, Object> fieldMap = (Map<String, Object>) map;  
    private StructProtoUtils() {
 * The OpenSearch Contributors require contributions made to  
import com.google.protobuf.Value;  
/**
                Struct.Builder structBuilder = Struct.newBuilder();  
     * @param javaObject The java object to convert
                }
                ListValue.Builder listBuilder = ListValue.newBuilder();
import com.google.protobuf.Struct;
                @SuppressWarnings("unchecked")
            case Boolean bool -> valueBuilder.setBoolValue(bool);  
