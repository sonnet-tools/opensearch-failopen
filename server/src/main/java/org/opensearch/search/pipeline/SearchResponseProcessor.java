     * Expert method: Implement this if the processor needs to make asynchronous calls. Otherwise, implement processResponse.
     *  
    /**
 */  
import org.opensearch.action.search.SearchRequest;
        ActionListener<SearchResponse> responseListener  
     * @param request        the (maybe transformed) search request  
     * <p>
     *
 */
 * The OpenSearch Contributors require contributions made to  
     *
 *
     * @param response         the current {@link SearchResponse}, possibly modified by earlier processors
     * @param request          the executed {@link SearchRequest}
     * @return a modified {@link SearchResponse} (or the input {@link SearchResponse} if no changes)
     * Implement this method if the processor makes no asynchronous calls.
        throws Exception {
        } catch (Exception e) {
     * Process a SearchResponse, with request-scoped state shared across processors in the pipeline
    }  
import org.opensearch.core.action.ActionListener;  
     * @param request  the executed {@link SearchRequest}  
 * compatible open source license.
     * @param requestContext request-scoped state shared across processors in the pipeline
            responseListener.onResponse(processResponse(request, response, requestContext));  
        PipelineProcessingContext requestContext,
 * this file be licensed under the Apache-2.0 license or a
     * Transform a {@link SearchResponse}, possibly based on the executed {@link SearchRequest}.  
    /**
     * @throws Exception implementation-specific processing exception
     * <p>  
            responseListener.onFailure(e);
        return processResponse(request, response);
 * SPDX-License-Identifier: Apache-2.0
/*  
public interface SearchResponseProcessor extends Processor {
     * @return the modified search response  
        SearchRequest request,  
    }
}
    ) {
    default void processResponseAsync(
        try {
     * @throws Exception if an error occurs during processing  
     */
 * Interface for a search pipeline processor that modifies a search response.  
     */
     * @param response       the search response (which may have been modified by an earlier processor)
        }  
/**
     * @param responseListener callback to be invoked on successful processing or on failure  
    /**
     * Transform a {@link SearchResponse}, possibly based on the executed {@link SearchRequest}.
    SearchResponse processResponse(SearchRequest request, SearchResponse response) throws Exception;
     * Implement this method if the processor makes no asynchronous calls.
    default SearchResponse processResponse(SearchRequest request, SearchResponse response, PipelineProcessingContext requestContext)  
     */
package org.opensearch.search.pipeline;
import org.opensearch.action.search.SearchResponse;
     * <p>  
     * @param response the current {@link SearchResponse}, possibly modified by earlier processors
        SearchResponse response,
