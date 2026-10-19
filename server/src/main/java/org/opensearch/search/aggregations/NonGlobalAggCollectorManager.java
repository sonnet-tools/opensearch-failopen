            for (Collector c : collectors) {
        // If there are no leaves then in concurrent search case postCollection, and subsequently buildAggregation, will not be called in  
        // we need to manually processPostCollection here to build empty InternalAggregation objects for this collector tree.
 * compatible open source license.
        if (context.searcher().getLeafContexts().isEmpty()) {  
            collector = null;  
 * this file be licensed under the Apache-2.0 license or a
        }
    public NonGlobalAggCollectorManager(SearchContext context) throws IOException {
            InternalAggregations.reduce(Collections.singletonList(internalAggregations), context.partialOnShard())
    }  
    }
 * The OpenSearch Contributors require contributions made to  
    public String getCollectorName() {  
    public Collector newCollector() throws IOException {  
        );
import org.apache.lucene.search.Collector;
import java.util.Collection;
        super(context, context.aggregations().factories()::createTopLevelNonGlobalAggregators, CollectorResult.REASON_AGGREGATION);  
        if (collector != null) {
        // Reduce the aggregations across slices before sending to the coordinator. We will perform shard level reduce as long as any slices
            return super.newCollector();  
}  
import org.apache.lucene.search.CollectorManager;
    private Collector collector;
import org.opensearch.search.profile.query.CollectorResult;
        // were created so that we can apply shard level bucket count thresholds in the reduce phase.
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;  
 * {@link CollectorManager} to take care of non-global aggregation operators in case of concurrent segment search
            final Collector toReturn = collector;
        } else {
import java.io.IOException;
import org.opensearch.search.query.ReduceableSearchResult;
    }
    }  
 */
        // search path. Since we build the InternalAggregation in postCollection that will not get created in such cases either. Therefore
/*  
    @Override
/**  
import java.util.Objects;
    @Override
 *
package org.opensearch.search.aggregations;
    public ReduceableSearchResult reduce(Collection<Collector> collectors) throws IOException {
        return collectorName;
    }  
        collectorName = collector.toString();
        collector = Objects.requireNonNull(super.newCollector(), "collector instance is null");
 */  
    protected AggregationReduceableSearchResult buildAggregationResult(InternalAggregations internalAggregations) {  
            return toReturn;
                context.bucketCollectorProcessor().processPostCollection(c);
    @Override
        return new AggregationReduceableSearchResult(  
            }  
import org.opensearch.search.internal.SearchContext;  
public class NonGlobalAggCollectorManager extends AggregationCollectorManager {  
    private final String collectorName;  
        return super.reduce(collectors);
    @Override
        }
