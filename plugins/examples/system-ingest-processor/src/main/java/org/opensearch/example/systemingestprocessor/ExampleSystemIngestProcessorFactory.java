        final Object settingsFromIndex = config.get(INDEX_SETTINGS);
    /**
     */
 */  
            mappings.addAll((List<Map<String, Object>>) mappingFromTemplates);
            if (doc.containsKey(PROPERTIES) && doc.get(PROPERTIES) instanceof Map) {
            description =
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_SETTINGS;  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.example.systemingestprocessor;
     */  
        if (settingsFromTemplates instanceof List) {
    public static final String PROPERTIES = "properties";
     */
import java.util.List;
    private Map<String, Object> getProperties(Map<String, Object> mapping) {
        // override the previous one so we need to loop through all the settings.  
        }  
            final Map<String, Object> properties = getProperties(mapping);
    /**  
}  
        if (mappings.isEmpty() && settings.isEmpty()) {  
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_TEMPLATE_SETTINGS;
import java.util.Collection;
     * The name of the trigger field.  
            // if there is no property in the mapping we simply skip it  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
                isTriggerFieldFound = true;  
    @SuppressWarnings("unchecked")
        if (mapping.containsKey(DOC) && mapping.get(DOC) instanceof Map) {  
        }
        return isTriggerFieldFound ? new ExampleSystemIngestProcessor(tag, description, DEFAULT_BATCH_SIZE) : null;
        final List<Settings> settings = new ArrayList<>();
            return new HashMap<>();  
        if (mapping == null) {
        }  
                return (Map<String, Object>) doc.get(PROPERTIES);  
            Map<String, Object> doc = (Map<String, Object>) mapping.get(DOC);
            settings.add((Settings) settingsFromIndex);
        boolean isTriggerFieldFound = false;  
 * A factory to create the example system ingest processor
                isTriggerFieldFound = TRIGGER_SETTING.get(setting);  
/**
import org.opensearch.common.settings.Settings;
import java.util.HashMap;  
    }
            if (setting.hasValue(TRIGGER_SETTING.getKey())) {
     * The type of the factory.
     * mapping properties under a _doc key.
    /**
        // If no config we are not able to create a processor so simply return a null to show no processor created
    protected ExampleSystemIngestProcessorFactory() {  
import static org.opensearch.example.systemingestprocessor.ExampleSystemIngestProcessorPlugin.TRIGGER_SETTING;
        if (settingsFromIndex instanceof Settings) {
    public static final String TRIGGER_FIELD_NAME = "system_ingest_processor_trigger_field";
        }
     * @param mapping index mapping  
            }
     */
        }
            }
            if (properties.isEmpty()) {
    private static final int DEFAULT_BATCH_SIZE = 10;
public class ExampleSystemIngestProcessorFactory extends AbstractBatchingSystemProcessor.Factory {
    public static final String TYPE = "example_system_ingest_processor_factory";  
        } else if (mapping.containsKey(PROPERTIES) && mapping.get(PROPERTIES) instanceof Map) {
            }  
        final Object mappingFromTemplates = config.get(INDEX_TEMPLATE_MAPPINGS);
            mappings.add((Map<String, Object>) mappingFromIndex);
        final Object mappingFromIndex = config.get(INDEX_MAPPINGS);  
import org.opensearch.ingest.AbstractBatchingSystemProcessor;
            }
     */
            return null;
/*  
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_TEMPLATE_MAPPINGS;
        final Object settingsFromTemplates = config.get(INDEX_TEMPLATE_SETTINGS);  
        if (description == null) {
    }
     * Name for properties. An object field will define subfields as properties.
    /**
     * A default batch size.
        }
 */  
     * Constructs a new ExampleSystemIngestProcessorFactory
import java.util.ArrayList;
    }
        }
    /**
        if (mappingFromIndex instanceof Map) {
                continue;
    protected AbstractBatchingSystemProcessor newProcessor(String tag, String description, Map<String, Object> config) {  
    @Override
                "This is an example system ingest processor. It will auto add a text field to the ingest doc if the mapping contains a trigger field.";  
        if (mappingFromTemplates instanceof List) {
        super(TYPE);
        }  
        final List<Map<String, Object>> mappings = new ArrayList<>();
            settings.addAll((Collection<? extends Settings>) settingsFromTemplates);
import java.util.Map;
     */  
     * Name for doc. Actions like create index and legacy create/update index template will have the  
    /**  
            if (properties.containsKey(TRIGGER_FIELD_NAME)) {
        for (final Map<String, Object> mapping : mappings) {
        return new HashMap<>();  
 *
        for (final Settings setting : settings) {
     */
     * @return properties of the mapping
     * Help extract the properties from a mapping
        }
        // If the trigger setting is configured then use it directly.
        }  
        // When we rely on the v1 template to create the index there can be multiple settings and the later one can
    @SuppressWarnings("unchecked")  
            return (Map<String, Object>) mapping.get(PROPERTIES);  
    /**
    public static final String DOC = "_doc";  
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_MAPPINGS;
 * this file be licensed under the Apache-2.0 license or a
