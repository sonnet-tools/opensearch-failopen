import java.util.Locale;  
            return null;
        return enumName.toLowerCase(Locale.ROOT);
/*  
    private ProtobufEnumUtils() {
public class ProtobufEnumUtils {
 * - SORT_MODE_MIN → "min"
 * name prefix and converting to snake_case.
 */  
    /**
        if (enumName.startsWith(prefix)) {
        // Utility class
        }
     * @param protobufEnum The protobuf enum value
 *
 * This class provides a simple method to convert protobuf enums by removing the message
}
 * Utility class for converting protobuf enum values to OpenSearch string representations.  
     * Converts protobuf enum to string by removing the prefix and converting to lowercase.  
        String prefix = camelCaseToSnakeCase(messageName).toUpperCase(Locale.ROOT) + "_";
package org.opensearch.transport.grpc.util;
 * The OpenSearch Contributors require contributions made to  
     * @return The converted string value in lowercase, or null if input is null  
     */
 * @opensearch.internal  
        String messageName = protobufEnum.getClass().getSimpleName();  
 * this file be licensed under the Apache-2.0 license or a
    }  
    }  
     * Converts CamelCase to snake_case.  
     */
 */
 * - FIELD_TYPE_LONG → "long"  
    /**
    public static String convertToString(Enum<?> protobufEnum) {
 * - SORT_ORDER_ASC → "asc"
    }
        if (protobufEnum == null) {  
 *  
    private static String camelCaseToSnakeCase(String camelCase) {
        }  
        String enumName = protobufEnum.name();
 * compatible open source license.
/**
            return enumName.substring(prefix.length()).toLowerCase(Locale.ROOT);
 * Examples:
 *
        return camelCase.replaceAll("([a-z])([A-Z])", "$1_$2");  
 * SPDX-License-Identifier: Apache-2.0
     *
