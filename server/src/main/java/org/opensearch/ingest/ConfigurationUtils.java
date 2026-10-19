            }
     * If the property value isn't of type list an {@link OpenSearchParseException} is thrown.
            }
 * KIND, either express or implied.  See the License for the
                "property isn't a string or int, but of type [" + value.getClass().getName() + "]"
    ) {
            Map<String, T> map = (Map<String, T>) value;
     * If the property value isn't of type int a {@link OpenSearchParseException} is thrown.
                null,
            List<Processor> onFailureProcessors = readProcessorConfigs(onFailureProcessorConfigs, scriptService, processorFactories);
            throw newConfigurationException(
            // installed for use by REST tests. `propertyValue` will not be
import java.io.InputStream;
                "property isn't a map or string, but of type [" + scriptConfig.getClass().getName() + "]"
        @Nullable Object config
            "property isn't a string, but of type [" + value.getClass().getName() + "]"
                return Script.parse(parser);
            return defaultValue;
            return stringValue;
            throw newConfigurationException(processorType, processorTag, propertyName, "required property is missing");
 * Utility class for ingest processor configurations
        if (value == null) {
     */
     * If the property is missing and no default value has been specified a {@link OpenSearchParseException} is thrown
            );
    private static String readString(String processorType, String processorTag, String propertyName, Object value) {
        } catch (Exception e) {
    }
        boolean ignoreFailure = ConfigurationUtils.readBooleanProperty(null, null, config, IGNORE_FAILURE_KEY, false);
        if (value instanceof Boolean booleanValue) {
            return map;
    }
            } else {
                };
                processorTag,
        }
        String propertyName,
        } else if (config instanceof String stringConfig && "script".equals(type)) {
 * GitHub history for details.
            throw newConfigurationException(
        );
    }
                if (conditionalScript != null) {
        String propertyName
        String processorTag,
                        "processor [{}] doesn't support one or more provided configuration parameters {}",
    public static String readStringProperty(
            "property isn't a boolean, but of type [" + value.getClass().getName() + "]"
    ) throws Exception {
            default -> throw newConfigurationException(
            return Collections.singletonMap("source", stringConfig);
     */
     * Returns and removes the specified property from the specified configuration map.
    public static TemplateScript.Factory readTemplateProperty(
    }
    /**
 * You may obtain a copy of the License at
        }
import org.opensearch.OpenSearchParseException;
 * compatible open source license.
    private static void addMetadataToException(
        String processorType,
        return readMap(processorType, processorTag, propertyName, value);
     * If the property value isn't of type string an {@link OpenSearchParseException} is thrown.
     * Returns and removes the specified property as an {@link Object} from the specified configuration map.
        Map<String, Processor.Factory> processorFactories,
        String tag = ConfigurationUtils.readOptionalStringProperty(null, null, config, TAG_KEY);
        String propertyName,
        String msg;
                null,
        }
    ) {
     * Returns and removes the specified property from the specified configuration map.
        try {
     * If the property is missing an {@link OpenSearchParseException} is thrown
                "property isn't a list, but of type [" + value.getClass().getName() + "]"
        } else {
        Map<String, Object> configuration,
     * Returns and removes the specified property from the specified configuration map.
import org.opensearch.core.xcontent.NamedXContentRegistry;
        } else if (config instanceof Map<?, ?>) {
 *
        String type,
        if (value == null) {
     * <p>
        String defaultValue
 * license agreements. See the NOTICE file distributed with
        }
    public static OpenSearchException newConfigurationException(
        if (value == null) {
        }
        }
        if (value == null) {
    /**
            exception.addMetadata("opensearch.processor_type", processorType);
        if (value == null) {
            exception.addMetadata("opensearch.property_name", propertyName);
    }
     * <p>
     * Returns and removes the specified optional property from the specified configuration map.
        }
     */
public final class ConfigurationUtils {
        String processorTag,
     * If the property value isn't of type string or int a {@link OpenSearchParseException} is thrown.
        String propertyName,
        String value = readStringProperty(processorType, processorTag, configuration, propertyName, null);
     * Returns and removes the specified property from the specified configuration map.
    ) {
        if (config == null) {
     * <p>
        if (value instanceof Map<?, ?>) {
        }
                propertyName,
            return Integer.parseInt(value.toString());
        Object value = configuration.remove(propertyName);
        }
import java.util.List;
                propertyName,
 * ownership. Elasticsearch licenses this file to you under
        String processorType,
        return readString(processorType, processorTag, propertyName, value);
 *
                }
            throw ConfigurationUtils.newConfigurationException(processorType, processorTag, propertyName, e);
                processorType,
        String processorType,
    private static Map<String, Object> normalizeScript(Object scriptConfig) {
     * If the property is missing an {@link OpenSearchParseException} is thrown
        Processor.Factory factory = processorFactories.get(type);
import org.opensearch.script.ScriptService;
                processorTag,
                XContentBuilder builder = XContentBuilder.builder(JsonXContent.jsonXContent).map(normalizeScript(scriptSource));
        String type,
    /**
        String description = ConfigurationUtils.readOptionalStringProperty(null, tag, config, DESCRIPTION_KEY);
                processorTag,
    ) {
     * <p>
     * Returns and removes the specified property as an {@link Object} from the specified configuration map.
        if (factory != null) {
import org.opensearch.script.Script;
        return exception;
            );
    /**
                "conditional",
                    @Override
package org.opensearch.ingest;
import java.util.Map;
        if (exception != null) {
            return defaultValue;
 * Licensed to Elasticsearch under one or more contributor
            return null;
            );
        return readList(processorType, processorTag, propertyName, value);
    /**
        return value;
                processorType,
        } else {
        Map<String, Object> configuration,
     * If the property value isn't of type string or int a {@link OpenSearchParseException} is thrown.
        String processorTag,
    public static OpenSearchException newConfigurationException(
        if (value instanceof List<?>) {
     */
     */
        Object value = configuration.remove(propertyName);
        return processors;
        Object value = configuration.remove(propertyName);
    @SuppressWarnings("unchecked")
        String processorTag,
        } catch (Exception e) {
            return defaultValue;
            );
            throw exception;
import java.util.Arrays;
        Map<String, Object> configuration,
    ) {
        }
        String processorType,
        }
        Integer defaultValue
        String propertyName,
    public static Processor readProcessor(
 * @opensearch.internal
            try {
        if (processorType != null) {
import org.opensearch.ExceptionsHelper;
        String processorTag,
        }
    ) {
        if (value == null) {
    }
    public static Processor readProcessor(
    @SuppressWarnings("unchecked")
    public static Integer readIntProperty(
                    processor = new ConditionalProcessor(tag, description, conditionalScript, scriptService, processor);
            return null;
        Exception exception = null;
    private static <T> Map<String, T> readMap(String processorType, String processorTag, String propertyName, Object value) {
        List<Map<String, Object>> processorConfigs,
        String processorTag,
    /**
        String processorType,
        }
                "property isn't a map, but of type [" + value.getClass().getName() + "]"
        Map<String, Object> configuration,
        String processorTag,
import org.opensearch.OpenSearchException;
     */
            throw newConfigurationException(type, null, null, "expect the config of processor [" + type + "] to be map, but is null");
        String processorTag,
     */
                    }
    ) {
 */
        String processorType,
            processorTag,
    ) throws Exception {
    ) {
    public static final String DESCRIPTION_KEY = "description";
        Exception cause
    public static String readOptionalStringProperty(
        addMetadataToException(exception, processorType, processorTag, propertyName);
        }
        }
        if (value == null) {
        Object value = configuration.remove(propertyName);
            throw newConfigurationException(
                processorType,
                return scriptService.compile(script, TemplateScript.CONTEXT);
        } else {
                return (params) -> new TemplateScript(params) {
    ) {
 */
        Object scriptSource = config.remove("if");
        String propertyName
 * Unless required by applicable law or agreed to in writing,
    public static TemplateScript.Factory compileTemplate(
    }
        String processorType,
        String propertyName
        }
            return readProcessor(processorFactories, scriptService, type, normalizedScript);
            );
            throw newConfigurationException(processorType, processorTag, propertyName, "required property is missing");
        String processorType,
    }
     * Returns and removes the specified property of type list from the specified configuration map.
     * <p>
        Object value = configuration.remove(propertyName);
        String processorType,
        Map<String, Object> configuration,
                "property cannot be converted to an int [" + value.toString() + "]"
            List<T> stringList = (List<T>) value;
                if (config.isEmpty() == false) {
    public static Double readDoubleProperty(
                InputStream stream = BytesReference.bytes(builder).streamInput();
        if (value == null) {
        String defaultValue
        Map<String, Object> configuration,
     * If the property is missing and no default value has been specified a {@link OpenSearchParseException} is thrown
import java.util.Collections;
        return readStringOrInt(processorType, processorTag, propertyName, value);
    }
            return defaultValue;
                }
    }
            @SuppressWarnings("unchecked")
    public static <T> List<T> readList(String processorType, String processorTag, Map<String, Object> configuration, String propertyName) {
        if (propertyName != null) {
        if (value == null) {
        ScriptService scriptService,
 */
                for (Map.Entry<String, Object> entry : processorConfigWithKey.entrySet()) {
        String processorTag,
    public static List<Processor> readProcessorConfigs(
        String propertyValue,
    private ConfigurationUtils() {}
    /**
        String processorTag,
        }
        if (propertyName == null) {
        } else if (value == null) {
        String processorTag,
    /**
            return Double.parseDouble(value.toString());
        if (scriptSource != null) {
            @SuppressWarnings("unchecked")
    private static String readStringOrInt(String processorType, String processorTag, String propertyName, Object value) {
            throw newConfigurationException(processorType, processorTag, propertyName, "required property is missing");
    /**
 *
import org.opensearch.common.xcontent.json.JsonXContent;
        Map<String, Object> configuration,
        return exception;
        }
        }
        String processorType,
        try {
 * SPDX-License-Identifier: Apache-2.0
            case String stringValue -> stringValue;
            throw newConfigurationException(
        Map<String, Processor.Factory> processorFactories
     * If the property value isn't of type string a {@link OpenSearchParseException} is thrown.
        return readString(processorType, processorTag, propertyName, value);
            throw newConfigurationException(processorType, processorTag, propertyName, "required property is missing");
            processorType,
 * specific language governing permissions and limitations
    /**
 * the Apache License, Version 2.0 (the "License"); you may
            }
import org.opensearch.script.TemplateScript;
     * <p>
        }
                        type,
    /**
            return null;
 * under the License.
        }
    public static String readStringProperty(
import java.util.HashMap;
                if (onFailureProcessors.size() > 0 || ignoreFailure) {
        String processorType,
                config,
            throw newConfigurationException(type, null, null, "the config of processor [" + type + "] cannot be null");
        return readStringOrInt(processorType, processorTag, propertyName, value);
        Object value = configuration.remove(propertyName);
        String propertyName
    }
        String processorTag,
        throw newConfigurationException(type, tag, null, "No processor type exists with name [" + type + "]");
        String processorType,
    public static <T> List<T> readOptionalList(
        }
 *
                    throw new OpenSearchParseException(
    private static Script extractConditional(Map<String, Object> config) throws IOException {
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.core.xcontent.XContentBuilder;
            for (Map<String, Object> processorConfigWithKey : processorConfigs) {
        String propertyName
            return booleanValue;
                    } catch (Exception e) {
            return (Map<String, Object>) scriptConfig;
        ScriptService scriptService
                        exception = ExceptionsHelper.useOrSuppress(exception, e);
            ) {
            return null;
        Object value = configuration.remove(propertyName);
        List<Processor> processors = new ArrayList<>();
                processorTag,
            List<Map<String, Object>> onFailureProcessorConfigs = ConfigurationUtils.readOptionalList(
    }
        } else {
 * Modifications Copyright OpenSearch Contributors. See
            // modified if templating is not available so a script that simply returns an unmodified `propertyValue`
        return readMap(processorType, processorTag, propertyName, value);
     * <p>
        String processorTag,
        return null;
        }
    }
        Map<String, Object> configuration,
    }
        Map<String, Object> configuration,
                return processor;
 */
        try {
        if (value == null && defaultValue != null) {
            return null;
                propertyName,
        String propertyName,
            try (
    public static Object readOptionalObject(Map<String, Object> configuration, String propertyName) {
        if (config == null) {
import java.io.IOException;
        Map<String, Processor.Factory> processorFactories,
     * If the property value isn't of type map an {@link OpenSearchParseException} is thrown.
            case Integer intValue -> String.valueOf(intValue);
            case null -> null;
        String propertyName
            // is returned.
/**
    }
                    }
 * not use this file except in compliance with the License.
        Object value = configuration.remove(propertyName);
                processorType,
    public static final String TAG_KEY = "tag";
            return stringList;
        } catch (Exception e) {
        throw newConfigurationException(
     * If the property value isn't of type int a {@link OpenSearchParseException} is thrown.
                null,
                throw newConfigurationException(type, tag, null, e);
        return configuration.remove(propertyName);
        ScriptService scriptService,
            // This check is here because the DEFAULT_TEMPLATE_LANG(mustache) is not
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                }
    ) {
    public static <T> Map<String, T> readOptionalMap(
        }
        String propertyName
        String processorType,
                Script script = new Script(ScriptType.INLINE, DEFAULT_TEMPLATE_LANG, propertyValue, Collections.emptyMap());
     * Returns and removes the specified property of type list from the specified configuration map.
        Object value = configuration.remove(propertyName);
        ScriptService scriptService,
                        processors.add(readProcessor(processorFactories, scriptService, entry.getKey(), entry.getValue()));
            );
        String propertyName,
        return readStringProperty(processorType, processorTag, configuration, propertyName, null);
     * Returns and removes the specified property of type map from the specified configuration map.
            throw newConfigurationException(
                XContentParser parser = MediaTypeRegistry.JSON.xContent()
        }
            } catch (Exception e) {
    ) throws Exception {
     */
     * If the property is missing an {@link OpenSearchParseException} is thrown
                    processor = new CompoundProcessor(ignoreFailure, Collections.singletonList(processor), onFailureProcessors);
        }
        if (scriptConfig instanceof Map<?, ?>) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
        }
    private static <T> List<T> readList(String processorType, String processorTag, String propertyName, Object value) {
/*
    /**
        if (value == null) {
        if (value == null && defaultValue != null) {
            msg = reason;
     */
            if (onFailureProcessorConfigs != null && onFailureProcessors.isEmpty()) {
    }
                propertyName,
/*
    ) {
        throw newConfigurationException(
        } else {
     * Returns and removes the specified property of type map from the specified configuration map.
            throw newConfigurationException(type, null, null, "property isn't a map, but of type [" + config.getClass().getName() + "]");
        Object value = configuration.remove(propertyName);
     */
        String processorType,
     * <p>
import org.opensearch.script.ScriptType;
        String propertyName,
import org.opensearch.core.common.bytes.BytesReference;
        String processorType,
        OpenSearchParseException exception = new OpenSearchParseException(msg);
            propertyName,
    public static final String IGNORE_FAILURE_KEY = "ignore_failure";
    public static boolean readBooleanProperty(
     * <p>
                    public String execute() {
        Map<String, Object> configuration,
        boolean defaultValue
    }
     * <p>
     * If the property value isn't of type map an {@link OpenSearchParseException} is thrown.
            throw newConfigurationException(processorType, processorTag, propertyName, "required property is missing");
        String processorTag,
        String propertyName
            Map<String, Object> normalizedScript = new HashMap<>(1);
 * The OpenSearch Contributors require contributions made to
     * If the property is missing an {@link OpenSearchParseException} is thrown
            propertyName,
     * Returns and removes the specified property from the specified configuration map.
    }
                    );
    }
        ScriptService scriptService
     * If the property value isn't of type list an {@link OpenSearchParseException} is thrown.
                        Arrays.toString(config.keySet().toArray())
     * If the property value isn't of type string a {@link OpenSearchParseException} is thrown.
        };
import org.opensearch.core.xcontent.XContentParser;
    }
    }
            }
            exception.addMetadata("opensearch.processor_tag", processorTag);
    }
        } else if (scriptConfig instanceof String stringConfig) {
                Processor processor = factory.create(processorFactories, tag, description, config);
    ) {
}
            if (scriptService.isLangSupported(DEFAULT_TEMPLATE_LANG) && propertyValue.contains("{{")) {
    }
        Script conditionalScript = extractConditional(config);
        String processorType,
        return switch (value) {
        OpenSearchException exception = ExceptionsHelper.convertToOpenSearchException(cause);
                    .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, stream)
    private static Boolean readBoolean(String processorType, String processorTag, String propertyName, Object value) {
                processorTag,
        String reason
                propertyName,
                processorType,
        @Nullable Map<String, Object> config
                throw newConfigurationException(type, tag, Pipeline.ON_FAILURE_KEY, "processors list cannot be empty");
                        return propertyValue;
    public static <T> Map<String, T> readMap(
        if (processorConfigs != null) {
    ) {
        Object value = configuration.remove(propertyName);
import static org.opensearch.script.Script.DEFAULT_TEMPLATE_LANG;
    public static String readStringOrIntProperty(
            msg = "[" + propertyName + "] " + reason;
        String propertyName,
        Map<String, Object> configuration,
        }
            normalizedScript.put(ScriptType.INLINE.getParseField().getPreferredName(), stringConfig);
        if (value instanceof String stringValue) {
     * <p>
/*
    }
    }
                }
    }
        OpenSearchException exception,
            return readBoolean(processorType, processorTag, propertyName, value).booleanValue();
        } else {
            }
    ) {
     * Returns and removes the specified property from the specified configuration map.
    }
        String processorTag,
        if (value == null) {
    ) {
     * If the property is missing an {@link OpenSearchParseException} is thrown
     */
            processorType,
import org.opensearch.common.Nullable;
        } else if (value == null) {
        Object value = configuration.remove(propertyName);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (processorTag != null) {
        String processorTag,
        addMetadataToException(exception, processorType, processorTag, propertyName);
                "script",
    ) {
            throw newConfigurationException(processorType, processorTag, propertyName, "required property is missing");
            );
    public static String readOptionalStringOrIntProperty(
        return compileTemplate(processorType, processorTag, propertyName, value, scriptService);
    }
            return readProcessor(processorFactories, scriptService, type, (Map<String, Object>) config);
     */
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
        return readList(processorType, processorTag, propertyName, value);
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    /**
        }
        Map<String, Object> configuration,
                "property cannot be converted to a double [" + value.toString() + "]"
                    try {
        }
     */
            processorTag,
     * If the property is missing an {@link OpenSearchParseException} is thrown
    public static Object readObject(String processorType, String processorTag, Map<String, Object> configuration, String propertyName) {
                Pipeline.ON_FAILURE_KEY
