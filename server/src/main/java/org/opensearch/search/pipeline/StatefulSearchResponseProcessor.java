/*  
 * A specialization of {@link SearchResponseProcessor} that makes use of the request-scoped processor state.
    }  
package org.opensearch.search.pipeline;
 */  
        throws Exception;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.search.SearchRequest;
        throw new UnsupportedOperationException();
    SearchResponse processResponse(SearchRequest request, SearchResponse response, PipelineProcessingContext requestContext)  
/**
public interface StatefulSearchResponseProcessor extends SearchResponseProcessor {
 * Implementors must implement the processResponse method that accepts request-scoped processor state.  
 * compatible open source license.
 */
    default SearchResponse processResponse(SearchRequest request, SearchResponse response) {
    @Override  
import org.opensearch.action.search.SearchResponse;
 *
}
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * this file be licensed under the Apache-2.0 license or a
