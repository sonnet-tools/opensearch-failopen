            new ExampleSearchRequestPreProcessor.Factory(),
    @Override
 */  
    @Override
 * this file be licensed under the Apache-2.0 license or a
        getSystemGeneratedSearchPhaseResultsProcessors(Parameters parameters) {
 */  
import org.opensearch.search.pipeline.SystemGeneratedProcessor;  
    }
}
        );
 *
    @Override
        return Map.of(
    }
    ) {
import org.opensearch.plugins.Plugin;
    public Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> getSystemGeneratedResponseProcessors(  
        Parameters parameters  
        return Map.of(ExampleSearchResponseProcessor.Factory.TYPE, new ExampleSearchResponseProcessor.Factory());  
import org.opensearch.search.pipeline.SearchPhaseResultsProcessor;  
    /**
import java.util.Map;
            new ExampleSearchRequestPostProcessor.Factory()  
            ExampleSearchRequestPreProcessor.Factory.TYPE,  
 * compatible open source license.
package org.opensearch.example.systemsearchprocessor;
    public ExampleSystemSearchProcessorPlugin() {}
        Parameters parameters
/**
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>>  
            ExampleSearchRequestPostProcessor.Factory.TYPE,
        return Map.of(ExampleSearchPhaseResultsProcessor.Factory.TYPE, new ExampleSearchPhaseResultsProcessor.Factory());
    public
 * The OpenSearch Contributors require contributions made to  
    ) {
 * SPDX-License-Identifier: Apache-2.0
     * Constructs a new ExampleSystemSearchProcessorPlugin  
import org.opensearch.plugins.SearchPipelinePlugin;
     */
import org.opensearch.search.pipeline.SearchRequestProcessor;
/*  
public class ExampleSystemSearchProcessorPlugin extends Plugin implements SearchPipelinePlugin {
import org.opensearch.search.pipeline.SearchResponseProcessor;
    public Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> getSystemGeneratedRequestProcessors(
 * An example plugin to demonstrate how to use system generated search processors.
    }  
