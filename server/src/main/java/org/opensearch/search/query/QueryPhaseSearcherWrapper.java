    /**
 * this file be licensed under the Apache-2.0 license or a
            return defaultQueryPhaseSearcher.searchWith(searchContext, searcher, query, collectors, hasFilterCollector, hasTimeout);
import org.opensearch.search.internal.SearchContext;
     * {@link AggregationProcessor} to use to setup and post process aggregation related collectors during search request
     * @param searcher           context index searcher
/*  
    private final QueryPhaseSearcher defaultQueryPhaseSearcher;
        } else {
            return defaultQueryPhaseSearcher.aggregationProcessor(searchContext);
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
     *  
    private final QueryPhaseSearcher concurrentQueryPhaseSearcher;  
     * @throws java.io.IOException IOException  
import org.apache.lucene.search.Query;
        ContextIndexSearcher searcher,
     */
import java.util.LinkedList;
 */
    @Override
 *
    @Override
        boolean hasFilterCollector,
        }
    private static final Logger LOGGER = LogManager.getLogger(QueryPhaseSearcherWrapper.class);
 * compatible open source license.
 */  
     * @return {@link AggregationProcessor} to use  
    }  
/**  
        }  
public class QueryPhaseSearcherWrapper implements QueryPhaseSearcher {  
import java.io.IOException;  
package org.opensearch.search.query;
import org.opensearch.search.aggregations.AggregationProcessor;
        this.defaultQueryPhaseSearcher = new QueryPhase.DefaultQueryPhaseSearcher();  
        Query query,  
            return concurrentQueryPhaseSearcher.searchWith(searchContext, searcher, query, collectors, hasFilterCollector, hasTimeout);  
            return concurrentQueryPhaseSearcher.aggregationProcessor(searchContext);
        this.concurrentQueryPhaseSearcher = new ConcurrentQueryPhaseSearcher();
 *  
        boolean hasTimeout  
}
        SearchContext searchContext,
import org.apache.logging.log4j.Logger;
     * @param searchContext search context
 * non-concurrent search query phase and aggregation processor.
        if (searchContext.shouldUseConcurrentSearch()) {
    ) throws IOException {
     * @param searchContext      search context
     * @param query              query  
    }
     */
 * SPDX-License-Identifier: Apache-2.0
    }
     * @return is rescoring required or not
     * @param hasTimeout         "true" if timeout was set, "false" otherwise
    public QueryPhaseSearcherWrapper() {
 * Wrapper class for QueryPhaseSearcher that handles path selection for concurrent vs
import org.apache.logging.log4j.LogManager;
        LinkedList<QueryCollectorContext> collectors,
import org.opensearch.search.internal.ContextIndexSearcher;  
    public boolean searchWith(  
    /**  
    public AggregationProcessor aggregationProcessor(SearchContext searchContext) {  
        if (searchContext.shouldUseConcurrentSearch()) {
     * Perform search using {@link CollectorManager}
import org.apache.lucene.search.CollectorManager;  
        } else {  
