    }  
     * description of the processor  
    public String getTag() {  
    public String getDescription() {
 * this file be licensed under the Apache-2.0 license or a
    }
            String description,
 */
     * @param ignoreFailure should processor ignore the failure
            return new ExampleSearchRequestPostProcessor(tag, ignoreFailure);
 * The OpenSearch Contributors require contributions made to  
     * type of the processor
        @Override  
        request.source().size(size + 2);
        + "executed after the user defined search request. It will increase the query size by 2.";  
        @Override
        }
        // This processor will be executed after the user defined search request processor
    }  
        return DESCRIPTION;  
 * compatible open source license.
            }
import org.opensearch.action.search.SearchRequest;
            if (searchRequest == null || searchRequest.source() == null) {  
import org.opensearch.search.pipeline.SearchRequestProcessor;
    }  
        this.ignoreFailure = ignoreFailure;
        return TYPE;
            return request;
        this.tag = tag;
            boolean ignoreFailure,  
        public static final String TYPE = "example-search-request-post-processor-factory";  
        }  
            Map<String, Object> config,
            PipelineContext pipelineContext
        return this.tag;
    }
    public ExampleSearchRequestPostProcessor(String tag, boolean ignoreFailure) {  
    @Override
            String tag,
public class ExampleSearchRequestPostProcessor implements SearchRequestProcessor, SystemGeneratedProcessor {  
import org.opensearch.search.pipeline.SystemGeneratedProcessor;
 * SPDX-License-Identifier: Apache-2.0
 */  
    }  
        if (request == null || request.source() == null) {
    /**
}
    @Override
            SearchRequest searchRequest = context.searchRequest();
    @Override  
    public ExecutionStage getExecutionStage() {  
/*  
     * @param tag tag of the processor  
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,  
        }
    public SearchRequest processRequest(SearchRequest request) {  
    @Override  
    }
    /**
import org.opensearch.search.pipeline.Processor;
        ) throws Exception {  
import java.util.Map;
            return size < 5;
     */
    static class Factory implements SystemGeneratedFactory<SearchRequestProcessor> {
 *
     */
import org.opensearch.search.pipeline.ProcessorGenerationContext;  
     * ExampleSearchRequestPostProcessor constructor
        // We auto generate the processor if the original query size is less than 5.
    /**
    public static final String TYPE = "example-search-request-post-processor";
    private final boolean ignoreFailure;
        return this.ignoreFailure;
    @Override
    }  
        public boolean shouldGenerate(ProcessorGenerationContext context) {
     */  
package org.opensearch.example.systemsearchprocessor;
    private final String tag;
    public String getType() {
        public SearchRequestProcessor create(
                return false;
 * An example system generated search request processor that will be executed before the user defined processor
    public boolean isIgnoreFailure() {
    public static final String DESCRIPTION = "This is a system generated search request processor which will be"
        return ExecutionStage.POST_USER_DEFINED;
/**  
    @Override
            int size = searchRequest.source().size();  
        return request;  
        int size = request.source().size();
