import org.opensearch.search.pipeline.SearchResponseProcessor;
        assertEquals(1, factoryMap.size());
 * SPDX-License-Identifier: Apache-2.0
    private final SearchPipelinePlugin.Parameters parameters = mock(SearchPipelinePlugin.Parameters.class);
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> factoryMap = plugin
    private final ExampleSystemSearchProcessorPlugin plugin = new ExampleSystemSearchProcessorPlugin();
}
public class ExampleSystemSearchProcessorPluginTests extends OpenSearchTestCase {  
    }
import org.opensearch.plugins.SearchPipelinePlugin;
 */  
import static org.mockito.Mockito.mock;
 * this file be licensed under the Apache-2.0 license or a
            .getSystemGeneratedRequestProcessors(parameters);  
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> factoryMap = plugin
    public void testGetSystemGeneratedRequestProcessors() {
    public void testGetSystemGeneratedSearchPhaseResultsProcessors() {
package org.opensearch.example.systemsearchprocessor;
    }
 * compatible open source license.
    }  
        assertEquals(1, factoryMap.size());
            .getSystemGeneratedSearchPhaseResultsProcessors(parameters);  
            .getSystemGeneratedResponseProcessors(parameters);
import org.opensearch.search.pipeline.SystemGeneratedProcessor;
        assertTrue(factoryMap.get(ExampleSearchResponseProcessor.Factory.TYPE) instanceof ExampleSearchResponseProcessor.Factory);
        assertEquals(2, factoryMap.size());
import org.opensearch.test.OpenSearchTestCase;  
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;
        assertTrue(factoryMap.get(ExampleSearchRequestPostProcessor.Factory.TYPE) instanceof ExampleSearchRequestPostProcessor.Factory);
 *
        assertTrue(factoryMap.get(ExampleSearchPhaseResultsProcessor.Factory.TYPE) instanceof ExampleSearchPhaseResultsProcessor.Factory);  
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>> factoryMap = plugin
        assertTrue(factoryMap.get(ExampleSearchRequestPreProcessor.Factory.TYPE) instanceof ExampleSearchRequestPreProcessor.Factory);  
    public void testGetSystemGeneratedResponseProcessors() {  
/*  
import org.opensearch.search.pipeline.SearchPhaseResultsProcessor;
import org.opensearch.search.pipeline.SearchRequestProcessor;  
