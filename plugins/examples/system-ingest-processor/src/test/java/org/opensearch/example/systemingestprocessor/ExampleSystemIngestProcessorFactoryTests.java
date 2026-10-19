        final ExampleSystemIngestProcessorFactory factory = new ExampleSystemIngestProcessorFactory();
        properties.put(TRIGGER_FIELD_NAME, Map.of("type", "text"));  
        Map<String, Object> mapping = new HashMap<>();  
    }  
import static org.opensearch.example.systemingestprocessor.ExampleSystemIngestProcessorPlugin.TRIGGER_SETTING;  
 * this file be licensed under the Apache-2.0 license or a
    public void testNewProcessor_whenWithTriggerSettingFromIndex_thenReturnProcessor() {
import java.util.Map;
        final ExampleSystemIngestProcessorFactory factory = new ExampleSystemIngestProcessorFactory();
/*  
import java.util.HashMap;
import org.opensearch.ingest.AbstractBatchingSystemProcessor;
    }  
        Settings triggerEnabled = Settings.builder().put(TRIGGER_SETTING.getKey(), true).build();
        AbstractBatchingSystemProcessor processor = factory.newProcessor(
        assertNull("Should not create an example system ingest processor when the mapping is not found.", processor);
        mapping.put(PROPERTIES, properties);
        assertTrue(processor instanceof ExampleSystemIngestProcessor);
import java.util.List;  
    public void testNewProcessor_whenNoMapping_thenReturnNull() {  
    public void testNewProcessor_whenWithoutTriggerField_thenReturnProcessor() {
        final ExampleSystemIngestProcessorFactory factory = new ExampleSystemIngestProcessorFactory();  
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_TEMPLATE_SETTINGS;
 * SPDX-License-Identifier: Apache-2.0
        AbstractBatchingSystemProcessor processor = factory.newProcessor("tag", null, Map.of(INDEX_TEMPLATE_MAPPINGS, List.of(doc)));
        AbstractBatchingSystemProcessor processor = factory.newProcessor("tag", "description", Map.of(INDEX_SETTINGS, triggerDisabled));  
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_SETTINGS;
    }  
    }  
            "tag",
        );
        Map<String, Object> properties = new HashMap<>();  
 * The OpenSearch Contributors require contributions made to  
        doc.put(DOC, mapping);
        assertNotNull("Should create an example system ingest processor when the trigger field is found.", processor);
    public void testNewProcessor_whenWithTriggerSettingDisabled_thenReturnProcessor() {
import static org.opensearch.example.systemingestprocessor.ExampleSystemIngestProcessorFactory.TRIGGER_FIELD_NAME;
        Settings triggerEnabled = Settings.builder().put(TRIGGER_SETTING.getKey(), true).build();
        assertTrue(processor instanceof ExampleSystemIngestProcessor);  
import static org.opensearch.example.systemingestprocessor.ExampleSystemIngestProcessorFactory.PROPERTIES;
        Settings triggerDisabled = Settings.builder().put(TRIGGER_SETTING.getKey(), false).build();
    public void testNewProcessor_whenWithTriggerField_thenReturnProcessor() {
    public void testNewProcessor_whenWithTriggerSettingFromTemplate_thenReturnProcessor() {  
}
 * compatible open source license.
        Map<String, Object> mapping = new HashMap<>();
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_MAPPINGS;
    }
    }
        Map<String, Object> doc = new HashMap<>();
        Map<String, Object> properties = new HashMap<>();
        assertNull("Should not create an example system ingest processor when the trigger_setting is false.", processor);
        assertNotNull("Should create an example system ingest processor when the trigger_setting is true.", processor);
            Map.of(INDEX_TEMPLATE_SETTINGS, List.of(triggerEnabled))
package org.opensearch.example.systemingestprocessor;
import org.opensearch.test.OpenSearchTestCase;  
 */  
import static org.opensearch.example.systemingestprocessor.ExampleSystemIngestProcessorFactory.DOC;  
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_TEMPLATE_MAPPINGS;  
 *
            "description",  
        assertNotNull("Should create an example system ingest processor when the trigger_setting is true.", processor);
        final ExampleSystemIngestProcessorFactory factory = new ExampleSystemIngestProcessorFactory();
        assertNull("Should not create an example system ingest processor when the trigger field is not found.", processor);  
        AbstractBatchingSystemProcessor processor = factory.newProcessor("tag", "description", Map.of(INDEX_SETTINGS, triggerEnabled));  
import org.opensearch.common.settings.Settings;
        final ExampleSystemIngestProcessorFactory factory = new ExampleSystemIngestProcessorFactory();  
        final ExampleSystemIngestProcessorFactory factory = new ExampleSystemIngestProcessorFactory();  
        assertTrue(processor instanceof ExampleSystemIngestProcessor);
public class ExampleSystemIngestProcessorFactoryTests extends OpenSearchTestCase {  
        mapping.put(PROPERTIES, properties);
        AbstractBatchingSystemProcessor processor = factory.newProcessor("tag", "description", Map.of());  
        AbstractBatchingSystemProcessor processor = factory.newProcessor("tag", "description", Map.of(INDEX_MAPPINGS, mapping));
