        boolean timeoutSet  
            throw re;
package org.opensearch.search.query;
 * compatible open source license.
        if (re.getCause() == null || re instanceof OpenSearchException) {  
        // add the passed collector, the first collector context in the chain
import org.apache.lucene.search.Query;
import org.opensearch.search.internal.ContextIndexSearcher;  
    private final AggregationProcessor aggregationProcessor = new ConcurrentAggregationProcessor();
        );
            assert timeoutSet : "TimeExceededException thrown even though timeout wasn't set";
                throw (T) t.getCause();
        return searchWithCollectorManager(  
    @Override
 */  
        if (searchContext.terminateAfter() != SearchContext.DEFAULT_TERMINATE_AFTER && queryResult.terminatedEarly() == null) {
        ContextIndexSearcher searcher,
        QueryCollectorContext queryCollectorContext,
        boolean hasTimeout
import org.opensearch.search.aggregations.AggregationProcessor;
    public AggregationProcessor aggregationProcessor(SearchContext searchContext) {  
import java.util.Objects;
        if (searchContext.isSearchTimedOut()) {  
            result.reduce(queryResult);
        return aggregationProcessor;
            if (searchContext.request().allowPartialSearchResults() == false) {
            searchContext.shardTarget(),
        return false;
                throw new QueryPhaseExecutionException(searchContext.shardTarget(), "Time exceeded");  
        }
            collectors,
    }  
            collectorManager = profileCollectorManager;  
        } else {
            if (t.getCause() != null) {
import org.opensearch.search.profile.query.ProfileCollectorManager;
            }
        boolean hasFilterCollector,
        }  
import org.opensearch.search.aggregations.ConcurrentAggregationProcessor;
import java.util.LinkedList;  
            queryResult.terminatedEarly(false);
import org.apache.logging.log4j.Logger;
        Query query,  
            // Create collector manager tree
 * The OpenSearch Contributors require contributions made to  
/*  
/**
     * Default constructor
            searchContext.getProfilers().getCurrentQueryProfiler().setCollector(profileCollectorManager);
            }  
            re.getCause()
            final ReduceableSearchResult result = searcher.search(query, collectorManager);
    private static final Logger LOGGER = LogManager.getLogger(ConcurrentQueryPhaseSearcher.class);  
            "Failed to execute concurrent segment search thread",  
import org.apache.logging.log4j.LogManager;
        final QuerySearchResult queryResult = searchContext.queryResult();
        // Unwrap the RuntimeException and ExecutionException from Lucene concurrent search method and rethrow
        throw new QueryPhaseExecutionException(
import java.util.concurrent.ExecutionException;
            hasFilterCollector,  
        LinkedList<QueryCollectorContext> collectorContexts,  
        // Rethrow exception if cause is null or if it's an instance of OpenSearchException
            searcher,
 * The implementation of the {@link QueryPhaseSearcher} which attempts to use concurrent
    private static <T extends Exception> void rethrowCauseIfPossible(RuntimeException re, SearchContext searchContext) throws T {
        if (searchContext.getProfilers() != null) {
    }  
        boolean hasFilterCollector,  
            query,  
        if (queryCollectorContext instanceof RescoringQueryCollectorContext rescoringContext) {
        Query query,
 * search of Apache Lucene segments if it has been enabled.  
            Throwable t = re.getCause();  
    }  
        collectorContexts.addFirst(Objects.requireNonNull(queryCollectorContext));  
import org.apache.lucene.search.Collector;  
                QueryCollectorManagerContext.createQueryCollectorManagerWithProfiler(collectorContexts);
    ) throws IOException {
 */
        }
        }
            queryCollectorContext,
import java.io.IOException;
        LinkedList<QueryCollectorContext> collectors,
        SearchContext searchContext,
    @Override
        final CollectorManager<?, ReduceableSearchResult> collectorManager;  
    }
        if (re.getCause() instanceof ExecutionException || re.getCause() instanceof InterruptedException) {
        ContextIndexSearcher searcher,
 * SPDX-License-Identifier: Apache-2.0
     */
        QueryCollectorContext queryCollectorContext,
    public ConcurrentQueryPhaseSearcher() {}  
import org.apache.lucene.search.CollectorManager;
public class ConcurrentQueryPhaseSearcher extends DefaultQueryPhaseSearcher {
        SearchContext searchContext,  
}
    ) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            final ProfileCollectorManager<? extends Collector, ReduceableSearchResult> profileCollectorManager =  
            queryResult.searchTimedOut(true);
            searchContext,
        );
        try {  
        } catch (RuntimeException re) {  
        }  
import org.opensearch.search.internal.SearchContext;
import org.opensearch.OpenSearchException;  
    /**  
        }
        }
            hasTimeout
            collectorManager = QueryCollectorManagerContext.createQueryCollectorManager(collectorContexts);  
            return rescoringContext.shouldRescore();  
        // Rethrow any unexpected exception types  
    private static boolean searchWithCollectorManager(
 *
import org.opensearch.search.query.QueryPhase.DefaultQueryPhaseSearcher;  
    protected boolean searchWithCollector(  
            rethrowCauseIfPossible(re, searchContext);
