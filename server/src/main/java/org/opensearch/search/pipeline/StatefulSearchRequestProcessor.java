 * The OpenSearch Contributors require contributions made to  
        throw new UnsupportedOperationException();
import org.opensearch.action.search.SearchRequest;
    SearchRequest processRequest(SearchRequest request, PipelineProcessingContext requestContext) throws Exception;
 * this file be licensed under the Apache-2.0 license or a
 * A specialization of {@link SearchRequestProcessor} that makes use of the request-scoped processor state.
    @Override
 * SPDX-License-Identifier: Apache-2.0
 *
package org.opensearch.search.pipeline;
/*  
    default SearchRequest processRequest(SearchRequest request) {  
/**  
    }
 */  
public interface StatefulSearchRequestProcessor extends SearchRequestProcessor {
 */  
 * compatible open source license.
    @Override
 * Implementors must implement the processRequest method that accepts request-scoped processor state.
}  
