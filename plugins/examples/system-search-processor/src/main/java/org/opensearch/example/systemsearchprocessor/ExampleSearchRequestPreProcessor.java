        ) throws Exception {  
        );  
        }
    /**
    }
    }
            PipelineContext pipelineContext
        this.ignoreFailure = ignoreFailure;
 * An example system generated search request processor that will be executed before the user defined processor  
 * The OpenSearch Contributors require contributions made to  
        return this.tag;
    private final String tag;
        return this.ignoreFailure;
     * @param tag tag of the processor  
            String.format(Locale.ROOT, " [%s] should process the search request with PipelineProcessingContext.", TYPE)
            return new ExampleSearchRequestPreProcessor(tag, ignoreFailure);
     * original query size attribute key
    }
        return DESCRIPTION;  
    }  
package org.opensearch.example.systemsearchprocessor;
    }  
    public boolean isIgnoreFailure() {
import java.util.Locale;
                return false;
            return request;  
    @Override
     */
import org.opensearch.action.search.SearchRequest;
    @Override  
        return request;  
/**
        public boolean shouldGenerate(ProcessorGenerationContext context) {
    }  
/*  
    public static final String ORIGINAL_QUERY_SIZE_KEY = "example-original-query-size";  
     * @param ignoreFailure should processor ignore the failure
    private final boolean ignoreFailure;
    public SearchRequest processRequest(SearchRequest request) {  
    public ExampleSearchRequestPreProcessor(String tag, boolean ignoreFailure) {  
     */  
     * ExampleSearchRequestPreProcessor constructore
import org.opensearch.search.pipeline.Processor;  
    public String getTag() {  
            String description,
            String tag,
    }  
    public String getType() {
        + "executed before the user defined search request. It will increase the query size by 1.";
 * this file be licensed under the Apache-2.0 license or a
            SearchRequest searchRequest = context.searchRequest();
    @Override
    /**  
        public static final String TYPE = "example-search-request-pre-processor-factory";  
        throw new UnsupportedOperationException(
        int size = request.source().size();
            return size < 5;
    public static final String DESCRIPTION = "This is a system generated search request processor which will be"
        @Override  
 *
        request.source().size(size + 1);
        public SearchRequestProcessor create(
    @Override
            if (searchRequest == null || searchRequest.source() == null) {  
 * compatible open source license.
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,  
            Map<String, Object> config,
    /**  
        // This processor will be executed before the user defined search request processor
    public SearchRequest processRequest(SearchRequest request, PipelineProcessingContext requestContext) throws Exception {
    @Override  
        }
        return ExecutionStage.PRE_USER_DEFINED;
     */
}
        if (request == null || request.source() == null) {
            boolean ignoreFailure,  
        }
    /**
    @Override
import org.opensearch.search.pipeline.SystemGeneratedProcessor;  
 * SPDX-License-Identifier: Apache-2.0
    static class Factory implements SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor> {
    public String getDescription() {
import org.opensearch.search.pipeline.SearchRequestProcessor;
    @Override  
    }
        @Override
    }  
import java.util.Map;  
            }
            int size = searchRequest.source().size();  
     * type of the processor
    public SystemGeneratedProcessor.ExecutionStage getExecutionStage() {  
        requestContext.setAttribute(ORIGINAL_QUERY_SIZE_KEY, size);
 */
public class ExampleSearchRequestPreProcessor implements SearchRequestProcessor, SystemGeneratedProcessor {
    public static final String TYPE = "example-search-request-pre-processor";  
 */  
     */
        // store the original query size so that later the response processor can use it  
        return TYPE;
        // We auto generate the processor if the original query size is less than 5.
import org.opensearch.search.pipeline.PipelineProcessingContext;
     * description of the processor
import org.opensearch.search.pipeline.ProcessorGenerationContext;
        this.tag = tag;
