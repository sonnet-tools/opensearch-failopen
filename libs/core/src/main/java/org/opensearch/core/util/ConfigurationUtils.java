import org.opensearch.common.annotation.PublicApi;  
    public static String readStringProperty(Map<String, Object> configuration, String propertyName, String defaultValue) {
import org.opensearch.OpenSearchParseException;
        if (value == null) {  
        if (value == null) {  
            return null;
        } else {  
    /**  
            return Double.parseDouble(value.toString());  
    /**
        }
 * this file be licensed under the Apache-2.0 license or a
        }
        }
        return exception;
 * Utility class for parsing configurations.
            throw newConfigurationException(propertyName, "required property is missing");  
        Object value = configuration.get(propertyName);
     */
        } else if (value == null) {
 */
            case Integer intValue -> String.valueOf(intValue);
    public static Double readDoubleProperty(Map<String, Object> configuration, String propertyName) {  
}
     * Returns the specified property from the specified configuration map.
            throw newConfigurationException(propertyName, "required property is missing");  
        throw newConfigurationException(propertyName, "property isn't a string, but of type [" + value.getClass().getName() + "]");  
     * If the property value isn't of type string or int a {@link OpenSearchParseException} is thrown.
    }  
 * SPDX-License-Identifier: Apache-2.0
        if (value instanceof Boolean boolValue) {  
     */
import org.opensearch.OpenSearchException;
        }  
     * Returns the specified property from the specified configuration map.
        }
        } else if (value == null) {
    private static String readString(String propertyName, Object value) {
            exception.addMetadata("opensearch.property_name", propertyName);
    }
    public static String readStringOrIntProperty(Map<String, Object> configuration, String propertyName, String defaultValue) {  
     */  
     * Returns the specified property from the specified configuration map.
 */  
     * If the property is missing and no default value has been specified a {@link OpenSearchParseException} is thrown
        }
    public static boolean readBooleanProperty(Map<String, Object> configuration, String propertyName, boolean defaultValue) {
        if (value == null) {
            throw newConfigurationException(propertyName, "property cannot be converted to an int [" + value + "]");
     * If the property value isn't of type int a {@link OpenSearchParseException} is thrown.  
        try {
            msg = reason;
    }
     * <p>
        return readStringOrInt(propertyName, value);
            case null -> null;  
    }
            case String stringValue -> stringValue;
    }
        return switch (value) {
        throw newConfigurationException(propertyName, "property isn't a boolean, but of type [" + value.getClass().getName() + "]");  
     * If the property is missing an {@link OpenSearchParseException} is thrown
    /**
 *  
            return boolValue;
            return defaultValue;
                propertyName,
        }
        }  
     * If the property value isn't of type string a {@link OpenSearchParseException} is thrown.
     * Returns and removes the specified property from the specified configuration map.
        }
        } else {  
    /**  
    private static Boolean readBoolean(String propertyName, Object value) {
        if (propertyName != null) {
     * <p>  
            );  
    }  
            return readBoolean(propertyName, value).booleanValue();
     * If the property value isn't of type string an {@link OpenSearchParseException} is thrown.  
     */
        OpenSearchParseException exception = new OpenSearchParseException(msg);  
            msg = "[" + propertyName + "] " + reason;
@PublicApi(since = "3.0.0")  
            return null;
     * If the property is missing and no default value has been specified a {@link OpenSearchParseException} is thrown
            return defaultValue;  
     * <p>
    }  
        }  
        return readStringOrInt(propertyName, value);
    }
     * If the property value isn't of type string or int a {@link OpenSearchParseException} is thrown.  
        Object value = configuration.get(propertyName);
        Object value = configuration.get(propertyName);
    }
        Object value = configuration.get(propertyName);
package org.opensearch.core.util;
 * compatible open source license.
        return readString(propertyName, value);  
        }  
 *
            return Integer.parseInt(value.toString());  
    }
import java.util.Map;
    public static Integer readIntProperty(Map<String, Object> configuration, String propertyName, Integer defaultValue) {  
        }
public final class ConfigurationUtils {
            return null;  
        if (value == null && defaultValue != null) {  
        } catch (Exception e) {
     * If the property is missing an {@link OpenSearchParseException} is thrown
    /**  
     * Returns and removes the specified optional property from the specified configuration map.  
     * Returns the specified property from the specified configuration map.
    public static String readStringProperty(Map<String, Object> configuration, String propertyName) {  
            return stringValue;
    private ConfigurationUtils() {}  
     * Returns the specified property from the specified configuration map.
        return readStringProperty(configuration, propertyName, null);
        if (value == null) {
     */
            throw newConfigurationException(propertyName, "property cannot be converted to a double [" + value + "]");
    private static String readStringOrInt(String propertyName, Object value) {
        }
        if (value instanceof String stringValue) {  
        }
    public static String readOptionalStringProperty(Map<String, Object> configuration, String propertyName) {
        if (value == null) {
     * <p>
 * The OpenSearch Contributors require contributions made to  
                "property isn't a string or int, but of type [" + value.getClass().getName() + "]"
     * If the property is missing an {@link OpenSearchParseException} is thrown
        if (value == null && defaultValue != null) {
     */  
            throw newConfigurationException(propertyName, "required property is missing");
    }
        };
/**
    /**  
    /**
    public static String readOptionalStringOrIntProperty(Map<String, Object> configuration, String propertyName) {  
        if (propertyName == null) {
    private static void addMetadataToException(OpenSearchException exception, String propertyName) {  
     * <p>  
     */
        Object value = configuration.get(propertyName);  
    }  
        try {
        addMetadataToException(exception, propertyName);
/*  
        Object value = configuration.get(propertyName);
     * <p>
        } catch (Exception e) {
        return readString(propertyName, value);
            default -> throw newConfigurationException(  
    public static OpenSearchException newConfigurationException(String propertyName, String reason) {
     * If the property value isn't of type int a {@link OpenSearchParseException} is thrown.  
        if (value == null) {
     * <p>
     * If the property value isn't of type string a {@link OpenSearchParseException} is thrown.
    }
        Object value = configuration.get(propertyName);
            return defaultValue;
 * @opensearch.api
            return defaultValue;  
        String msg;  
