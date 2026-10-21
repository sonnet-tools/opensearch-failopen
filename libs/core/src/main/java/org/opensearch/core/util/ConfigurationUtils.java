 *
    /**
    private static Boolean readBoolean(String propertyName, Object value) {
            return boolValue;
            return null;
    public static String readStringProperty(Map<String, Object> configuration, String propertyName, String defaultValue) {
        }
        try {
        throw newConfigurationException(propertyName, "property isn't a string, but of type [" + value.getClass().getName() + "]");
    /**
        return readString(propertyName, value);
                "property isn't a string or int, but of type [" + value.getClass().getName() + "]"
    /**
     */
    private static String readStringOrInt(String propertyName, Object value) {
    }
            return null;
     */
    private static String readString(String propertyName, Object value) {
        if (propertyName != null) {
        Object value = configuration.get(propertyName);
    }
 * SPDX-License-Identifier: Apache-2.0
    /**
     * <p>
 */
import org.opensearch.OpenSearchParseException;
        addMetadataToException(exception, propertyName);
        if (value == null) {
            return defaultValue;
     * Returns the specified property from the specified configuration map.
        } else {
            msg = reason;
    public static String readOptionalStringProperty(Map<String, Object> configuration, String propertyName) {
     */
        Object value = configuration.get(propertyName);
 * Utility class for parsing configurations.
 * @opensearch.api
     * <p>
            case Integer intValue -> String.valueOf(intValue);
            default -> throw newConfigurationException(
     * Returns the specified property from the specified configuration map.
        if (value == null) {
        if (value instanceof String stringValue) {
     * <p>
/**
        if (value == null) {
        throw newConfigurationException(propertyName, "property isn't a boolean, but of type [" + value.getClass().getName() + "]");
     * Returns and removes the specified optional property from the specified configuration map.
 * The OpenSearch Contributors require contributions made to
            case String stringValue -> stringValue;
        }
     * If the property value isn't of type string a {@link OpenSearchParseException} is thrown.
            throw newConfigurationException(propertyName, "required property is missing");
public final class ConfigurationUtils {
        } catch (Exception e) {
     * If the property value isn't of type string an {@link OpenSearchParseException} is thrown.
     * If the property is missing an {@link OpenSearchParseException} is thrown
            throw newConfigurationException(propertyName, "required property is missing");
     * <p>
            throw newConfigurationException(propertyName, "property cannot be converted to an int [" + value + "]");
    private static void addMetadataToException(OpenSearchException exception, String propertyName) {
        Object value = configuration.get(propertyName);
        }
        return readStringOrInt(propertyName, value);
        if (value == null) {
    }
        return switch (value) {
        return readString(propertyName, value);
        OpenSearchParseException exception = new OpenSearchParseException(msg);
     * Returns the specified property from the specified configuration map.
        }
        }
        return readStringOrInt(propertyName, value);
                propertyName,
        if (value == null) {
    }
     * If the property is missing an {@link OpenSearchParseException} is thrown
    public static OpenSearchException newConfigurationException(String propertyName, String reason) {
     */
        }
            return readBoolean(propertyName, value).booleanValue();
        if (value == null) {
            return defaultValue;
    }
        };
        Object value = configuration.get(propertyName);
    /**
            return defaultValue;
            msg = "[" + propertyName + "] " + reason;
        } else if (value == null) {
     * <p>
            return defaultValue;
import org.opensearch.OpenSearchException;
    }
    /**
            exception.addMetadata("opensearch.property_name", propertyName);
/*
        } else if (value == null) {
     * <p>
    public static boolean readBooleanProperty(Map<String, Object> configuration, String propertyName, boolean defaultValue) {
        }
        Object value = configuration.get(propertyName);
     * If the property value isn't of type string a {@link OpenSearchParseException} is thrown.
        Object value = configuration.get(propertyName);
@PublicApi(since = "3.0.0")
        if (value instanceof Boolean boolValue) {
        return exception;
        }
        try {
        }
     * If the property value isn't of type int a {@link OpenSearchParseException} is thrown.
     * If the property value isn't of type int a {@link OpenSearchParseException} is thrown.
            throw newConfigurationException(propertyName, "property cannot be converted to a double [" + value + "]");
 * this file be licensed under the Apache-2.0 license or a
            return Double.parseDouble(value.toString());
            return stringValue;
     * If the property is missing and no default value has been specified a {@link OpenSearchParseException} is thrown
        Object value = configuration.get(propertyName);
 * compatible open source license.
     * Returns the specified property from the specified configuration map.
            throw newConfigurationException(propertyName, "required property is missing");
        }
     * Returns and removes the specified property from the specified configuration map.
        if (value == null && defaultValue != null) {
            return Integer.parseInt(value.toString());
     * If the property value isn't of type string or int a {@link OpenSearchParseException} is thrown.
    }
            case null -> null;
        } catch (Exception e) {
        }
     * If the property value isn't of type string or int a {@link OpenSearchParseException} is thrown.
        if (value == null && defaultValue != null) {
package org.opensearch.core.util;
    }
     * If the property is missing an {@link OpenSearchParseException} is thrown
import org.opensearch.common.annotation.PublicApi;
    }
     */
 */
    /**
    private ConfigurationUtils() {}
     */
        if (propertyName == null) {
    public static String readStringOrIntProperty(Map<String, Object> configuration, String propertyName, String defaultValue) {
            );
}
        }
     * If the property is missing and no default value has been specified a {@link OpenSearchParseException} is thrown
    }
    public static String readStringProperty(Map<String, Object> configuration, String propertyName) {
     */
    public static Integer readIntProperty(Map<String, Object> configuration, String propertyName, Integer defaultValue) {
    }
        return readStringProperty(configuration, propertyName, null);
        String msg;
    public static String readOptionalStringOrIntProperty(Map<String, Object> configuration, String propertyName) {
     * <p>
        } else {
    public static Double readDoubleProperty(Map<String, Object> configuration, String propertyName) {
            return null;
        }
    }
 *
     * Returns the specified property from the specified configuration map.
import java.util.Map;
        }
    }
