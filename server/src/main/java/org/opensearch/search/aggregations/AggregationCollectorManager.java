import org.opensearch.search.internal.SearchContext;
    private final CheckedFunction<SearchContext, List<Aggregator>, IOException> aggProvider;
    public Collector newCollector() throws IOException {
 */  
        CheckedFunction<SearchContext, List<Aggregator>, IOException> aggProvider  
import java.util.Collection;
 * The OpenSearch Contributors require contributions made to  
    @Override
 * SPDX-License-Identifier: Apache-2.0
        return buildAggregationResult(internalAggregations);  
/**  
        context.aggregations().resetBucketMultiConsumer();  
 * compatible open source license.
    protected AggregationReduceableSearchResult buildAggregationResult(InternalAggregations internalAggregations) {  
import org.apache.lucene.search.Collector;
        BucketCollector collector = MultiBucketCollector.wrap(aggProvider.apply(searchContext));
        String collectorReason
        // For Aggregations we should not have a NO_OP_Collector  
        SearchContext context,  
    }
        SearchContext searchContext,
    }  
        assert internals.stream().noneMatch(Objects::isNull);
}  
        collector.preCollection();  
        assert collector != BucketCollector.NO_OP_COLLECTOR;
 *  
 * aggregation operators
 * @opensearch.internal
/*  
import org.opensearch.search.query.ReduceableSearchResult;
 * Common {@link CollectorManager} used by both concurrent and non-concurrent aggregation path and also for global and non-global
        return collector;
        return collectorReason;  
    private final String collectorReason;  
import java.util.List;  
        return collector;
    public abstract String getCollectorName();  
package org.opensearch.search.aggregations;
        this.collectorReason = collectorReason;  
    ) {  
    private static Collector createCollector(
    }
    ) throws IOException {
    @Override  
    protected final SearchContext context;
import org.apache.lucene.search.CollectorManager;
    AggregationCollectorManager(
    public ReduceableSearchResult reduce(Collection<Collector> collectors) throws IOException {  
        final InternalAggregations internalAggregations = InternalAggregations.from(internals);
import java.util.Objects;
        this.context = context;
        return new AggregationReduceableSearchResult(internalAggregations);
        this.aggProvider = aggProvider;
 * this file be licensed under the Apache-2.0 license or a
public abstract class AggregationCollectorManager implements CollectorManager<Collector, ReduceableSearchResult> {  
        final Collector collector = createCollector(context, aggProvider);
 *
 */
        CheckedFunction<SearchContext, List<Aggregator>, IOException> aggProvider,
    public String getCollectorReason() {
import org.opensearch.common.CheckedFunction;  
import java.io.IOException;
    }
    }
        final List<InternalAggregation> internals = context.bucketCollectorProcessor().toInternalAggregations(collectors);
    }
