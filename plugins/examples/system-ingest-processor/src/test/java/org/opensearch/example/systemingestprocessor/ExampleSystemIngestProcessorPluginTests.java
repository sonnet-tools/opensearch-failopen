 *
package org.opensearch.example.systemingestprocessor;
    private final Processor.Parameters parameters = mock(Processor.Parameters.class);  
        final Map<String, Processor.Factory> factories = plugin.getSystemIngestProcessors(parameters);  
 */  
        assertTrue(
 * SPDX-License-Identifier: Apache-2.0
}
        );
/*  
import java.util.Map;
import static org.opensearch.example.systemingestprocessor.ExampleSystemIngestProcessorPlugin.TRIGGER_SETTING;
public class ExampleSystemIngestProcessorPluginTests extends OpenSearchTestCase {
 * compatible open source license.
    private final ExampleSystemIngestProcessorPlugin plugin = new ExampleSystemIngestProcessorPlugin();
    public void testGetSettings() {
    public void testGetSystemIngestProcessors() {
    }
import org.opensearch.ingest.Processor;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
import static org.mockito.Mockito.mock;
        assertEquals(List.of(TRIGGER_SETTING), plugin.getSettings());  
            "Should return the example system ingest processor factory.",  
    }  
            factories.get(ExampleSystemIngestProcessorFactory.TYPE) instanceof ExampleSystemIngestProcessorFactory
