                    }  
import java.util.Collections;
        } catch (IOException ex) {  
                // initialize global aggregators as well, such that any failure to initialize can be caught before executing the request  
        }
        } catch (IOException ex) {
 */  
 * {@link AggregationProcessor} implementation which is used with {@link org.opensearch.search.query.QueryPhase.DefaultQueryPhaseSearcher}.  
    @Override
package org.opensearch.search.aggregations;
 * reduce on the collected documents at shard level
                                    Collections.emptyList()  
                        context.getProfilers()  
                                    globalCollectorManager.getCollectorReason(),
        }  
/*  
                    globalCollectorManager.reduce(List.of()).reduce(context.queryResult());
                        .put(GlobalAggCollectorManager.class, new GlobalAggCollectorManagerWithSingleCollector(context));  
            throw new AggregationInitializationException("Could not initialize aggregators", ex);
    @Override
                    context.queryCollectorManagers()  
/**
            }  
        final AggregationCollectorManager globalCollectorManager = (AggregationCollectorManager) context.queryCollectorManagers()
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
                                    globalCollectorManager.newCollector(),
                // update the bucket collector process as there is aggregation in the request  
import org.opensearch.search.query.QueryPhaseExecutionException;
            }  
import java.util.List;  
            try {
import org.opensearch.search.internal.SearchContext;  
 * this file be licensed under the Apache-2.0 license or a
        context.queryCollectorManagers().remove(NonGlobalAggCollectorManager.class);
}
                                )
                        .put(NonGlobalAggCollectorManager.class, new NonGlobalAggCollectorManagerWithSingleCollector(context));
    private final BucketCollectorProcessor bucketCollectorProcessor = new BucketCollectorProcessor();  
                                new InternalProfileCollector(  
        if (context.queryResult().hasAggs()) {  
            }
public class DefaultAggregationProcessor implements AggregationProcessor {
                    context.searcher().search(query, globalCollectorManager.newCollector());
        final AggregationCollectorManager nonGlobalCollectorManager = (AggregationCollectorManager) context.queryCollectorManagers()
 */  
    public void preProcess(SearchContext context) {  
                }
 *
                            );
    public void postProcess(SearchContext context) {  
            .get(GlobalAggCollectorManager.class);
                            .setCollector(
        if (context.aggregations() == null) {
            context.queryResult().aggregations(null);
                if (globalCollectorManager != null) {  
            if (context.aggregations() != null) {
        try {  
import org.opensearch.search.profile.query.InternalProfileCollector;
        context.aggregations(null);  
            // no need to compute the aggs twice, they should be computed on a per context basis
                            .addQueryProfiler()
        // disable aggregations so that they don't run on next pages in case of scrolling
                nonGlobalCollectorManager.reduce(List.of()).reduce(context.queryResult());
                throw new QueryPhaseExecutionException(context.shardTarget(), "Failed to execute global aggregators", e);
        try {
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.Query;
                context.setBucketCollectorProcessor(bucketCollectorProcessor);
                    Query query = context.buildFilteredQuery(Queries.newMatchAllQuery());
                }  
            throw new QueryPhaseExecutionException(context.shardTarget(), "Post processing failed for aggregators", ex);
            return;  
            .get(NonGlobalAggCollectorManager.class);  
                if (context.aggregations().factories().hasNonGlobalAggregator()) {
 * This is the default implementation which works when collection for aggregations happen in sequential manner. It doesn't perform any
    }  
import org.opensearch.common.lucene.search.Queries;
                    if (context.getProfilers() != null) {
            return;
        }  
                    context.queryCollectorManagers()
                }
        context.queryCollectorManagers().remove(GlobalAggCollectorManager.class);
    }  
            } catch (Exception e) {
                if (context.aggregations().factories().hasGlobalAggregator()) {
        }
            if (nonGlobalCollectorManager != null) {
 * compatible open source license.
