 * SPDX-License-Identifier: Apache-2.0
    void preProcess(SearchContext context);
    /**  
     * @param context {@link SearchContext} for the request
/*  
import org.opensearch.common.annotation.PublicApi;
 * @opensearch.api
     * Callback invoked before collection of documents are done
 *
 * Interface to define different stages of aggregation processing before and after document collection
 * this file be licensed under the Apache-2.0 license or a
 */
package org.opensearch.search.aggregations;
     * @param context {@link SearchContext} for the request
/**
 *  
     */  
import org.opensearch.search.internal.SearchContext;
public interface AggregationProcessor {
     */  
     * Callback invoked after collection of documents are done
    /**  
 * compatible open source license.
    void postProcess(SearchContext context);
 * The OpenSearch Contributors require contributions made to  
}
@PublicApi(since = "2.9.0")  
 */  
