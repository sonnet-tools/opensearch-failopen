 * The OpenSearch Contributors require contributions made to  
        Object value = configuration.remove(propertyName);
    public static String readStringOrIntProperty(  
/**
    public static List<Processor> readProcessorConfigs(
        }  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            return Integer.parseInt(value.toString());  
        } else {  
        Object value = configuration.remove(propertyName);
import org.opensearch.script.ScriptService;
        String processorTag,
        };  
     */  
            "property isn't a boolean, but of type [" + value.getClass().getName() + "]"
                        "processor [{}] doesn't support one or more provided configuration parameters {}",
    /**  
        String propertyName  
    }
        String processorType,  
     * If the property is missing an {@link OpenSearchParseException} is thrown
            normalizedScript.put(ScriptType.INLINE.getParseField().getPreferredName(), stringConfig);
     * <p>
                        type,  
        String description = ConfigurationUtils.readOptionalStringProperty(null, tag, config, DESCRIPTION_KEY);  
            return defaultValue;  
            throw newConfigurationException(
                "property cannot be converted to an int [" + value.toString() + "]"  
        String propertyName,  
import org.opensearch.core.xcontent.XContentParser;
 * license agreements. See the NOTICE file distributed with
 */
    public static Object readObject(String processorType, String processorTag, Map<String, Object> configuration, String propertyName) {
                return Script.parse(parser);  
        }  
     * <p>
    public static <T> Map<String, T> readMap(  
        }
            } else {  
                "property isn't a map, but of type [" + value.getClass().getName() + "]"
                processorType,
                throw newConfigurationException(type, tag, Pipeline.ON_FAILURE_KEY, "processors list cannot be empty");
        Map<String, Object> configuration,  
        String propertyName  
public final class ConfigurationUtils {  
import org.opensearch.common.xcontent.json.JsonXContent;  
    ) {
            );  
                null,
    ) {  
    public static <T> List<T> readList(String processorType, String processorTag, Map<String, Object> configuration, String propertyName) {  
        } catch (Exception e) {
        return value;  
        if (value == null) {
        String propertyName,
        ScriptService scriptService  
            throw newConfigurationException(  
     * If the property value isn't of type list an {@link OpenSearchParseException} is thrown.  
    }
    ) {  
                        return propertyValue;
        Map<String, Object> configuration,
        return compileTemplate(processorType, processorTag, propertyName, value, scriptService);  
        return readStringOrInt(processorType, processorTag, propertyName, value);  
     * <p>
        }
        }
    public static final String TAG_KEY = "tag";
                Processor processor = factory.create(processorFactories, tag, description, config);
        }  
        String propertyName,  
     */
                processorTag,
     * If the property is missing an {@link OpenSearchParseException} is thrown
                }  
        String processorType,
        } else {  
            // installed for use by REST tests. `propertyValue` will not be  
    ) {  
        String processorTag,  
        if (value == null) {
        String processorTag,
        String propertyValue,
            return (Map<String, Object>) scriptConfig;  
                null,
    public static Integer readIntProperty(  
            throw exception;
        String msg;
        String propertyName,  
        if (value == null) {
    public static OpenSearchException newConfigurationException(  
     * Returns and removes the specified property of type map from the specified configuration map.  
            exception.addMetadata("opensearch.processor_type", processorType);
     * Returns and removes the specified property from the specified configuration map.
    ) throws Exception {  
        );  
    /**
        Object scriptSource = config.remove("if");
            return null;
        } catch (Exception e) {
    }  
                }  
    }
    /**  
        }  
                        processors.add(readProcessor(processorFactories, scriptService, entry.getKey(), entry.getValue()));
        Object value = configuration.remove(propertyName);
 * ownership. Elasticsearch licenses this file to you under  
                return processor;
        Object value = configuration.remove(propertyName);
                }
            throw newConfigurationException(type, null, null, "expect the config of processor [" + type + "] to be map, but is null");  
        return processors;
        try {  
     * <p>
                XContentParser parser = MediaTypeRegistry.JSON.xContent()  
        String processorType,
        }
 * Unless required by applicable law or agreed to in writing,
        @Nullable Map<String, Object> config  
import org.opensearch.OpenSearchParseException;  
        ScriptService scriptService,  
    public static Double readDoubleProperty(
        return null;  
                propertyName,  
        String propertyName
        String processorType,  
        if (scriptSource != null) {
        Map<String, Object> configuration,
    public static Processor readProcessor(
            processorType,
        String propertyName
        String processorType,
                if (onFailureProcessors.size() > 0 || ignoreFailure) {
        if (value == null) {  
import org.opensearch.core.xcontent.XContentBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
        String processorType,  
import org.opensearch.script.ScriptType;
        String processorTag,  
            return null;
            exception.addMetadata("opensearch.processor_tag", processorTag);
        ScriptService scriptService,
        String value = readStringProperty(processorType, processorTag, configuration, propertyName, null);
        try {
 * not use this file except in compliance with the License.
            case null -> null;  
        return readStringProperty(processorType, processorTag, configuration, propertyName, null);
    }
/*
        Object value = configuration.remove(propertyName);
                processorTag,
    ) {
        String processorTag,
                XContentBuilder builder = XContentBuilder.builder(JsonXContent.jsonXContent).map(normalizeScript(scriptSource));
    }
            throw newConfigurationException(processorType, processorTag, propertyName, "required property is missing");
        String processorType,
        }
     */
    }
            throw newConfigurationException(processorType, processorTag, propertyName, "required property is missing");
        if (value instanceof Boolean booleanValue) {
     */
 * @opensearch.internal
            if (onFailureProcessorConfigs != null && onFailureProcessors.isEmpty()) {  
            throw newConfigurationException(processorType, processorTag, propertyName, "required property is missing");
                throw newConfigurationException(type, tag, null, e);  
            throw newConfigurationException(processorType, processorTag, propertyName, "required property is missing");
        }  
        return configuration.remove(propertyName);
     * If the property is missing and no default value has been specified a {@link OpenSearchParseException} is thrown  
            return readProcessor(processorFactories, scriptService, type, (Map<String, Object>) config);
    ) {  
                "script",
        if (processorTag != null) {
        String processorType,
            );
     */
        Object value = configuration.remove(propertyName);
     * If the property value isn't of type string a {@link OpenSearchParseException} is thrown.
        if (value == null) {  
import java.util.HashMap;
    public static String readOptionalStringOrIntProperty(
        }
    }  
        String processorTag,
    public static Object readOptionalObject(Map<String, Object> configuration, String propertyName) {  
            // is returned.
        String tag = ConfigurationUtils.readOptionalStringProperty(null, null, config, TAG_KEY);
        return switch (value) {
 * software distributed under the License is distributed on an
 *
    public static String readOptionalStringProperty(
        Object value = configuration.remove(propertyName);
        String processorTag,
import org.opensearch.OpenSearchException;
        String propertyName  
                    }
            Map<String, T> map = (Map<String, T>) value;  
        String type,
        throw newConfigurationException(
            throw newConfigurationException(processorType, processorTag, propertyName, "required property is missing");
        String processorType,
            msg = "[" + propertyName + "] " + reason;
    }
        Object value = configuration.remove(propertyName);  
        String processorTag,
    private static Map<String, Object> normalizeScript(Object scriptConfig) {
            return Double.parseDouble(value.toString());
        if (exception != null) {  
                        exception = ExceptionsHelper.useOrSuppress(exception, e);  
            );
    ) {  
    public static boolean readBooleanProperty(  
     * Returns and removes the specified property of type list from the specified configuration map.
    /**
/*  
            case String stringValue -> stringValue;
    ) {  
        Map<String, Object> configuration,  
            case Integer intValue -> String.valueOf(intValue);
        Map<String, Object> configuration,
     * <p>
 *  
        String processorTag,
    /**
        Exception exception = null;
     * If the property is missing an {@link OpenSearchParseException} is thrown  
        addMetadataToException(exception, processorType, processorTag, propertyName);
            return stringValue;
                null,  
     */
import org.opensearch.script.TemplateScript;  
            List<T> stringList = (List<T>) value;  
    ) {  
        String defaultValue
                "property cannot be converted to a double [" + value.toString() + "]"
     */  
     * <p>
        Map<String, Processor.Factory> processorFactories,  
package org.opensearch.ingest;
    }
    public static Processor readProcessor(
    private ConfigurationUtils() {}  
                        Arrays.toString(config.keySet().toArray())
        Map<String, Processor.Factory> processorFactories
        if (factory != null) {
            }  
import org.opensearch.core.common.bytes.BytesReference;
                Script script = new Script(ScriptType.INLINE, DEFAULT_TEMPLATE_LANG, propertyValue, Collections.emptyMap());
    ) {
            throw newConfigurationException(  
        if (config == null) {
 * You may obtain a copy of the License at  
            throw newConfigurationException(type, null, null, "property isn't a map, but of type [" + config.getClass().getName() + "]");
    ) {
            return stringList;
import org.opensearch.common.Nullable;
 * SPDX-License-Identifier: Apache-2.0
    }  
                "property isn't a list, but of type [" + value.getClass().getName() + "]"
    private static String readStringOrInt(String processorType, String processorTag, String propertyName, Object value) {
                if (config.isEmpty() == false) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.MediaTypeRegistry;
        } else {
     * <p>
        String processorTag,
    private static Boolean readBoolean(String processorType, String processorTag, String propertyName, Object value) {  
     * Returns and removes the specified property from the specified configuration map.  
    }
            );
 *  
            List<Processor> onFailureProcessors = readProcessorConfigs(onFailureProcessorConfigs, scriptService, processorFactories);
            msg = reason;  
            @SuppressWarnings("unchecked")
            );
        }
                propertyName,  
    @SuppressWarnings("unchecked")  
        }
     * Returns and removes the specified property of type map from the specified configuration map.
     */
            "property isn't a string, but of type [" + value.getClass().getName() + "]"
                    .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, stream)
        }
    public static OpenSearchException newConfigurationException(
        Map<String, Object> configuration,
    public static final String IGNORE_FAILURE_KEY = "ignore_failure";
            throw ConfigurationUtils.newConfigurationException(processorType, processorTag, propertyName, e);  
     * If the property is missing an {@link OpenSearchParseException} is thrown
        if (processorConfigs != null) {  
        }  
        return readString(processorType, processorTag, propertyName, value);
        Object value = configuration.remove(propertyName);  
     * If the property is missing an {@link OpenSearchParseException} is thrown  
            @SuppressWarnings("unchecked")
     */
        return readList(processorType, processorTag, propertyName, value);  
            exception.addMetadata("opensearch.property_name", propertyName);
     * <p>
        String processorType,  
    private static Script extractConditional(Map<String, Object> config) throws IOException {  
        String propertyName
            throw newConfigurationException(
            // This check is here because the DEFAULT_TEMPLATE_LANG(mustache) is not
     * <p>
        Object value = configuration.remove(propertyName);
 */
            processorTag,  
        if (value instanceof String stringValue) {
        }
            }
     * Returns and removes the specified property as an {@link Object} from the specified configuration map.
        OpenSearchParseException exception = new OpenSearchParseException(msg);
            try (  
    private static <T> Map<String, T> readMap(String processorType, String processorTag, String propertyName, Object value) {  
        Map<String, Object> configuration,
                processorType,  
        Map<String, Object> configuration,  
        }
        String processorType,
        Processor.Factory factory = processorFactories.get(type);  
    private static <T> List<T> readList(String processorType, String processorTag, String propertyName, Object value) {  
        return readList(processorType, processorTag, propertyName, value);  
    /**
        String processorType,  
    public static <T> List<T> readOptionalList(
import org.opensearch.script.Script;  
        String processorType,
            return map;
        if (value == null) {  
                };  
        if (config == null) {
 * KIND, either express or implied.  See the License for the
            );
                    @Override
        if (value instanceof List<?>) {
    /**  
     * Returns and removes the specified property of type list from the specified configuration map.
                }  
                propertyName,  
     */
        if (value == null && defaultValue != null) {
     */
                    );
     * If the property is missing and no default value has been specified a {@link OpenSearchParseException} is thrown
import java.util.Map;  
        }  
        return readMap(processorType, processorTag, propertyName, value);  
                    }
        String propertyName,
    }
        }  
        Integer defaultValue
        }  
        String processorType,
        if (value == null) {
            return Collections.singletonMap("source", stringConfig);
            // modified if templating is not available so a script that simply returns an unmodified `propertyValue`
 * Utility class for ingest processor configurations
    }  
/*  
import static org.opensearch.script.Script.DEFAULT_TEMPLATE_LANG;
        Map<String, Object> configuration,
            for (Map<String, Object> processorConfigWithKey : processorConfigs) {
            throw newConfigurationException(  
            throw newConfigurationException(processorType, processorTag, propertyName, "required property is missing");  
        } else {
    }
     * If the property value isn't of type string an {@link OpenSearchParseException} is thrown.
 * GitHub history for details.
        boolean ignoreFailure = ConfigurationUtils.readBooleanProperty(null, null, config, IGNORE_FAILURE_KEY, false);
        return exception;  
    /**  
                    try {  
                return (params) -> new TemplateScript(params) {
        OpenSearchException exception = ExceptionsHelper.convertToOpenSearchException(cause);  
    public static final String DESCRIPTION_KEY = "description";  
        OpenSearchException exception,
        String type,
        String processorTag,
        ScriptService scriptService,
        if (value == null) {
        List<Processor> processors = new ArrayList<>();
    }
            } catch (Exception e) {
        String processorTag,
    /**  
 */  
        if (scriptConfig instanceof Map<?, ?>) {
            return booleanValue;
    ) {  
                InputStream stream = BytesReference.bytes(builder).streamInput();
            propertyName,
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
        }  
     * If the property is missing an {@link OpenSearchParseException} is thrown
     * If the property value isn't of type int a {@link OpenSearchParseException} is thrown.  
        if (value == null) {  
                "property isn't a map or string, but of type [" + scriptConfig.getClass().getName() + "]"
                    processor = new CompoundProcessor(ignoreFailure, Collections.singletonList(processor), onFailureProcessors);
                processorTag,
        String processorTag,  
        } catch (Exception e) {
        String propertyName
            return null;
 * Modifications Copyright OpenSearch Contributors. See
    }
        throw newConfigurationException(
        if (value == null && defaultValue != null) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return defaultValue;  
                for (Map.Entry<String, Object> entry : processorConfigWithKey.entrySet()) {
        } else if (value == null) {  
            try {
        Map<String, Object> configuration,
    }
        if (processorType != null) {
    public static TemplateScript.Factory readTemplateProperty(
    /**  
                    public String execute() {  
    public static String readStringProperty(
    public static String readStringProperty(
    /**  
                propertyName,  
            throw newConfigurationException(type, null, null, "the config of processor [" + type + "] cannot be null");
     * Returns and removes the specified property from the specified configuration map.  
import java.io.IOException;
            ) {
     * Returns and removes the specified property from the specified configuration map.
            }
        String propertyName,
        }  
 *
            );
            return defaultValue;
    ) {
                    } catch (Exception e) {
        String propertyName,
     * If the property value isn't of type string a {@link OpenSearchParseException} is thrown.
            return defaultValue;  
    @SuppressWarnings("unchecked")  
                processorType,
    }
        List<Map<String, Object>> processorConfigs,  
            List<Map<String, Object>> onFailureProcessorConfigs = ConfigurationUtils.readOptionalList(  
        } else if (config instanceof String stringConfig && "script".equals(type)) {
    }
                "property isn't a string or int, but of type [" + value.getClass().getName() + "]"
        }  
        try {
        Exception cause
                    processor = new ConditionalProcessor(tag, description, conditionalScript, scriptService, processor);
    ) {
    }
        if (value == null) {
        if (propertyName == null) {
        return readStringOrInt(processorType, processorTag, propertyName, value);
            processorType,
            if (scriptService.isLangSupported(DEFAULT_TEMPLATE_LANG) && propertyValue.contains("{{")) {  
    ) {
                if (conditionalScript != null) {
            }
    }
        }
        Map<String, Processor.Factory> processorFactories,
        }  
 */  
import org.opensearch.ExceptionsHelper;
     * Returns and removes the specified property from the specified configuration map.
        } else {
        }
            return readProcessor(processorFactories, scriptService, type, normalizedScript);
     * If the property value isn't of type map an {@link OpenSearchParseException} is thrown.  
     */  
    }
        String defaultValue
                Pipeline.ON_FAILURE_KEY
    /**
        String processorTag,
        );  
            return readBoolean(processorType, processorTag, propertyName, value).booleanValue();
                processorType,
        }  
 * compatible open source license.
    private static void addMetadataToException(
        Script conditionalScript = extractConditional(config);
 * under the License.  
                config,  
        if (value == null) {
        return exception;
     */
            return null;
 * Licensed to Elasticsearch under one or more contributor  
        }
        Map<String, Object> configuration,  
                processorType,
 * this work for additional information regarding copyright
            processorTag,  
        String processorType,  
        String propertyName  
        }
    public static <T> Map<String, T> readOptionalMap(
     * <p>
     * If the property value isn't of type string or int a {@link OpenSearchParseException} is thrown.  
        Object value = configuration.remove(propertyName);
    ) throws Exception {
        Object value = configuration.remove(propertyName);
    /**  
        boolean defaultValue
        addMetadataToException(exception, processorType, processorTag, propertyName);
        if (propertyName != null) {
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    }
        return readMap(processorType, processorTag, propertyName, value);
            return null;  
            Map<String, Object> normalizedScript = new HashMap<>(1);  
        Map<String, Object> configuration,
import java.io.InputStream;  
    private static String readString(String processorType, String processorTag, String propertyName, Object value) {  
        } else if (value == null) {
     * If the property value isn't of type int a {@link OpenSearchParseException} is thrown.
            }
            default -> throw newConfigurationException(  
    }
     * Returns and removes the specified property as an {@link Object} from the specified configuration map.
     * <p>
     * Returns and removes the specified optional property from the specified configuration map.  
    }
    ) throws Exception {  
    }  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
            propertyName,
}  
                processorTag,
    }  
        throw newConfigurationException(type, tag, null, "No processor type exists with name [" + type + "]");  
        if (value instanceof Map<?, ?>) {
    ) {
                "conditional",
        return readString(processorType, processorTag, propertyName, value);  
        }
    }
                    throw new OpenSearchParseException(
     * If the property value isn't of type string or int a {@link OpenSearchParseException} is thrown.  
import java.util.Collections;  
        } else if (config instanceof Map<?, ?>) {  
     * If the property value isn't of type map an {@link OpenSearchParseException} is thrown.
     * Returns and removes the specified property from the specified configuration map.  
    public static TemplateScript.Factory compileTemplate(  
        String processorTag,  
        @Nullable Object config
        String reason
        } else if (scriptConfig instanceof String stringConfig) {
        ScriptService scriptService
                propertyName,
                return scriptService.compile(script, TemplateScript.CONTEXT);
        String processorTag,
                processorTag,
        } else {
        String processorType,
        String propertyName,
     * If the property value isn't of type list an {@link OpenSearchParseException} is thrown.  
