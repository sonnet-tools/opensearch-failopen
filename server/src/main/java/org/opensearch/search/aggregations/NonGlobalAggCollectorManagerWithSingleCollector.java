        return collector;
package org.opensearch.search.aggregations;
public class NonGlobalAggCollectorManagerWithSingleCollector extends AggregationCollectorManager {
import org.opensearch.search.query.ReduceableSearchResult;
 *
        super(context, context.aggregations().factories()::createTopLevelNonGlobalAggregators, CollectorResult.REASON_AGGREGATION);
    @Override  
    }
        return super.reduce(List.of(collector));
    public String getCollectorName() {  
    }  
    public NonGlobalAggCollectorManagerWithSingleCollector(SearchContext context) throws IOException {  
        assert collectors.isEmpty() : "Reduce on NonGlobalAggregationCollectorManagerWithCollector called with non-empty collectors";
import java.io.IOException;
/*  
    private final Collector collector;  
    @Override
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.CollectorManager;
 * compatible open source license.
 */  
import java.util.List;  
 */  
}  
import org.opensearch.search.internal.SearchContext;  
    public Collector newCollector() throws IOException {
    }
    @Override
import java.util.Collection;
 * {@link CollectorManager} to take care of non-global aggregation operators in case of non-concurrent segment search. This
        return collectorName;
        collector = Objects.requireNonNull(super.newCollector(), "collector instance is null");
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        collectorName = collector.toString();  
    }  
 * CollectorManager returns the same collector instance (i.e. created in constructor of super class) on each newCollector call
import org.apache.lucene.search.Collector;
    private final String collectorName;
import org.opensearch.search.profile.query.CollectorResult;
/**  
    public ReduceableSearchResult reduce(Collection<Collector> collectors) throws IOException {  
import java.util.Objects;
