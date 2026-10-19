    public String getCollectorName() {  
import org.opensearch.search.profile.query.CollectorResult;
    }
import java.util.Collection;
        collectorName = collector.toString();  
 * {@link CollectorManager} to take care of global aggregation operators in case of non-concurrent segment search. This CollectorManager
 *
        return collector;
 * this file be licensed under the Apache-2.0 license or a
    public Collector newCollector() throws IOException {
    }
    @Override  
import java.io.IOException;
    private final Collector collector;  
 */  
    }  
        super(context, context.aggregations().factories()::createTopLevelGlobalAggregators, CollectorResult.REASON_AGGREGATION_GLOBAL);
public class GlobalAggCollectorManagerWithSingleCollector extends AggregationCollectorManager {
import org.apache.lucene.search.CollectorManager;
 * returns the same collector instance (i.e. created in constructor of super class) on each newCollector call
        assert collectors.isEmpty() : "Reduce on GlobalAggregationCollectorManagerWithCollector called with non-empty collectors";
import org.opensearch.search.query.ReduceableSearchResult;
        collector = Objects.requireNonNull(super.newCollector(), "collector instance is null");
import java.util.Objects;
    public GlobalAggCollectorManagerWithSingleCollector(SearchContext context) throws IOException {  
    @Override
    private final String collectorName;
}  
/*  
import org.opensearch.search.internal.SearchContext;  
 * compatible open source license.
package org.opensearch.search.aggregations;
    @Override
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 */  
/**  
    public ReduceableSearchResult reduce(Collection<Collector> collectors) throws IOException {  
import java.util.List;  
        return super.reduce(List.of(collector));
        return collectorName;
    }  
import org.apache.lucene.search.Collector;
