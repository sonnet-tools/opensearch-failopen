     */
 */  
     * Constructs a new ExampleSystemIngestProcessorPlugin
 */
    @Override  
    }  
    public ExampleSystemIngestProcessorPlugin() {}
/*  
     * A custom index setting which is used to control if we should create the example system ingest processor.
}
 * Example plugin that implements a custom system ingest processor.
    /**  
import org.opensearch.common.settings.Setting;
        "index.example_system_ingest_processor_plugin.trigger_setting",
    );
     */  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.example.systemingestprocessor;
 * The OpenSearch Contributors require contributions made to  
import java.util.List;  
    public List<Setting<?>> getSettings() {
/**  
import org.opensearch.ingest.Processor;
    }
 * compatible open source license.
        Setting.Property.IndexScope,  
        return Map.of(ExampleSystemIngestProcessorFactory.TYPE, new ExampleSystemIngestProcessorFactory());  
 * SPDX-License-Identifier: Apache-2.0
        false,
 *
        Setting.Property.Dynamic
    @Override
    /**
    public static final Setting<Boolean> TRIGGER_SETTING = Setting.boolSetting(  
        return List.of(TRIGGER_SETTING);
import org.opensearch.plugins.Plugin;
public class ExampleSystemIngestProcessorPlugin extends Plugin implements IngestPlugin {  
import org.opensearch.plugins.IngestPlugin;  
    public Map<String, Processor.Factory> getSystemIngestProcessors(Processor.Parameters parameters) {
import java.util.Map;
