     * @throws Exception implementation-specific processing exception
    ) {
        }
    }
    }  
            requestListener.onFailure(e);  
    /**
     * @throws Exception implementation-specific processing exception
     * @return the modified search request
     * Process a SearchRequest, with request-scoped state shared across processors in the pipeline  
}  
public interface SearchRequestProcessor extends Processor {
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
     * Implement this method if the processor makes no asynchronous calls.
 * SPDX-License-Identifier: Apache-2.0
/*  
 *
        try {  
 * Interface for a search pipeline processor that modifies a search request.
     * @param requestListener callback to be invoked on successful processing or on failure
     * Transform a {@link SearchRequest}. Executed on the coordinator node before any {@link org.opensearch.action.search.SearchPhase}  
     * <p>
     * @param request the search request (which may have been modified by an earlier processor)
        } catch (Exception e) {
     * Implement this method if the processor makes no asynchronous calls.
        SearchRequest request,
     * Process a SearchRequest without receiving request-scoped state.  
     * @param request the executed {@link SearchRequest}
     */  
     * @return the modified search request  
            requestListener.onResponse(processRequest(request, requestContext));
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.pipeline;
     */
        return processRequest(request);
        ActionListener<SearchRequest> requestListener
     * Expert method: Implement this if the processor needs to make asynchronous calls. Otherwise, implement processRequest.  
import org.opensearch.action.search.SearchRequest;
    default void processRequestAsync(
    /**
 */  
    /**
/**
        PipelineProcessingContext requestContext,  
    default SearchRequest processRequest(SearchRequest request, PipelineProcessingContext requestContext) throws Exception {
import org.opensearch.core.action.ActionListener;
 */  
    SearchRequest processRequest(SearchRequest request) throws Exception;  
     * @param requestContext request-scoped state shared across processors in the pipeline  
     * @param request the search request (which may have been modified by an earlier processor)
     */  
     * executes.
