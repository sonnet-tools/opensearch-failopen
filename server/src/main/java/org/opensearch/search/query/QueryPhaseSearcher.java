     * @param hasTimeout "true" if timeout was set, "false" otherwise
    /**
     * @throws IOException IOException  
 * @opensearch.api
     * @param searcher context index searcher
    }  
import org.opensearch.search.aggregations.DefaultAggregationProcessor;
     * @return is rescoring required or not
    /**
package org.opensearch.search.query;
import java.io.IOException;  
public interface QueryPhaseSearcher {
     * @param query query  
        ContextIndexSearcher searcher,
import org.opensearch.search.aggregations.AggregationProcessor;
    ) throws IOException;  
        boolean hasFilterCollector,
        Query query,
/*  
     * Perform search using {@link CollectorManager}  
import org.opensearch.search.internal.SearchContext;
 *  
        boolean hasTimeout
        LinkedList<QueryCollectorContext> collectors,  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.Query;
     * {@link AggregationProcessor} to use to setup and post process aggregation related collectors during search request  
/**  
 */  
    boolean searchWith(
import org.apache.lucene.search.CollectorManager;
 * used at {@link QueryPhase}.
     * @param searchContext search context
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 *
     */  
import org.opensearch.common.annotation.PublicApi;  
@PublicApi(since = "2.0.0")  
    default AggregationProcessor aggregationProcessor(SearchContext searchContext) {
}
 * The extension point which allows to plug in custom search implementation to be
     * @param searchContext search context
     */
import java.util.LinkedList;
 */
        SearchContext searchContext,  
        return new DefaultAggregationProcessor();
import org.opensearch.search.internal.ContextIndexSearcher;  
 * compatible open source license.
     * @return {@link AggregationProcessor} to use
