import org.apache.lucene.search.Query;  
                }
 *
                result.reduce(context.queryResult());  
        // for concurrent case we will perform only global aggregation in post process as QueryResult is already populated with results of
 */
        context.aggregations(null);
        }  
                    context.getProfilers().addQueryProfiler().setCollector((InternalProfileComponent) globalCollectorManager);  
        // processing the non-global aggregation  
    public void postProcess(SearchContext context) {
            context.queryResult().aggregations(null);
/*  
import org.opensearch.search.profile.query.InternalProfileComponent;
        } catch (IOException ex) {
        } catch (Exception e) {
                Query query = context.buildFilteredQuery(Queries.newMatchAllQuery());
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.CollectorManager;
        }
}
 * all the shards  
        CollectorManager<? extends Collector, ReduceableSearchResult> globalCollectorManager = context.queryCollectorManagers()
        }
            return;
    }
                if (context.getProfilers() != null) {  
                        Collections.emptyList()
            }
 */  
                // initialize global aggregators as well, such that any failure to initialize can be caught before executing the request  
        context.queryCollectorManagers().remove(GlobalAggCollectorManager.class);  
import org.opensearch.search.internal.SearchContext;
import java.util.Collections;  
        if (context.aggregations() == null) {  
        // disable aggregations so that they don't run on next pages in case of scrolling  
                        ((AggregationCollectorManager) globalCollectorManager).getCollectorReason(),  
/**
    private final BucketCollectorProcessor bucketCollectorProcessor = new BucketCollectorProcessor();
                    context.queryCollectorManagers().put(NonGlobalAggCollectorManager.class, new NonGlobalAggCollectorManager(context));
 * SPDX-License-Identifier: Apache-2.0
                        globalCollectorManager,
                // update the bucket collector process as there is aggregation in the request
 * The OpenSearch Contributors require contributions made to  
                if (context.aggregations().factories().hasNonGlobalAggregator()) {  
import org.opensearch.common.lucene.search.Queries;
        try {
            if (context.aggregations() != null) {  
        try {  
    @Override  
                if (context.aggregations().factories().hasGlobalAggregator()) {
            throw new AggregationInitializationException("Could not initialize aggregators", ex);  
    }
 * {@link AggregationProcessor} implementation to be used with {@link org.opensearch.search.query.ConcurrentQueryPhaseSearcher}. It takes  
 * avoid the increase in aggregation result sets returned by each shard to coordinator where final reduce happens for results received from
        context.queryCollectorManagers().remove(NonGlobalAggCollectorManager.class);
 * compatible open source license.
import org.opensearch.search.query.ReduceableSearchResult;  
                    globalCollectorManager = new InternalProfileCollectorManager(
                }  
import java.io.IOException;
                context.setBucketCollectorProcessor(bucketCollectorProcessor);
    @Override
            if (globalCollectorManager != null) {
import org.apache.lucene.search.Collector;
 * care of performing shard level reduce on Aggregation results collected as part of concurrent execution among slices. This is done to
                }
import org.opensearch.search.profile.query.InternalProfileCollectorManager;  
import org.opensearch.search.query.QueryPhaseExecutionException;
            .get(GlobalAggCollectorManager.class);
                    );
public class ConcurrentAggregationProcessor implements AggregationProcessor {
            }
                    context.queryCollectorManagers().put(GlobalAggCollectorManager.class, new GlobalAggCollectorManager(context));
            throw new QueryPhaseExecutionException(context.shardTarget(), "Failed to execute global aggregators", e);  
                final ReduceableSearchResult result = context.searcher().search(query, globalCollectorManager);
package org.opensearch.search.aggregations;
    public void preProcess(SearchContext context) {
