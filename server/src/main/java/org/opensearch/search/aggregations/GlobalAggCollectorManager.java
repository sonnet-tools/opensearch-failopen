        return collectorName;
        // Reduce the aggregations across slices before sending to the coordinator. We will perform shard level reduce as long as any slices
 * this file be licensed under the Apache-2.0 license or a
    public GlobalAggCollectorManager(SearchContext context) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            return super.newCollector();  
import org.opensearch.search.profile.query.CollectorResult;
 *
    }
        }
    @Override
 * The OpenSearch Contributors require contributions made to  
    }  
            return toReturn;
    public ReduceableSearchResult reduce(Collection<Collector> collectors) throws IOException {
        // we need to manually processPostCollection here to build empty InternalAggregation objects for this collector tree.
import org.apache.lucene.search.CollectorManager;
        collectorName = collector.toString();
    private Collector collector;
    }  
import org.opensearch.search.query.ReduceableSearchResult;
 * compatible open source license.
        // If there are no leaves then in concurrent search case postCollection, and subsequently buildAggregation, will not be called in  
public class GlobalAggCollectorManager extends AggregationCollectorManager {  
 */
        // search path. Since we build the InternalAggregation in postCollection that will not get created in such cases either. Therefore
    public String getCollectorName() {  
import java.util.Collections;  
    public Collector newCollector() throws IOException {  
        if (collector != null) {
        } else {
    @Override
    private final String collectorName;  
import java.io.IOException;
            collector = null;  
import java.util.Objects;
            InternalAggregations.reduce(Collections.singletonList(internalAggregations), context.partialOnShard())
        );
 * {@link CollectorManager} to take care of global aggregation operators in case of concurrent segment search
/**  
    protected AggregationReduceableSearchResult buildAggregationResult(InternalAggregations internalAggregations) {  
            }  
/*  
            for (Collector c : collectors) {
        return new AggregationReduceableSearchResult(  
            final Collector toReturn = collector;
    @Override
    }  
package org.opensearch.search.aggregations;
    }
import org.apache.lucene.search.Collector;
        // were created so that we can apply shard level bucket count thresholds in the reduce phase.
        }
 */  
        super(context, context.aggregations().factories()::createTopLevelGlobalAggregators, CollectorResult.REASON_AGGREGATION_GLOBAL);  
    @Override
                context.bucketCollectorProcessor().processPostCollection(c);
        if (context.searcher().getLeafContexts().isEmpty()) {  
import org.opensearch.search.internal.SearchContext;  
}  
        collector = Objects.requireNonNull(super.newCollector(), "collector instance is null");
import java.util.Collection;
        return super.reduce(collectors);
