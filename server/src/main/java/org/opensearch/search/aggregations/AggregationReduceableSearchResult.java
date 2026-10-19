            // as well
 * query results
    public AggregationReduceableSearchResult(InternalAggregations aggregations) {
 */  
 * {@link ReduceableSearchResult} returned by the {@link AggregationCollectorManager} which merges the aggregation with the one present in
            final InternalAggregations existingAggregations = result.aggregations().expand();  
 */  
    }  
import java.io.IOException;
        }  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
            result.aggregations(finalReducedAggregations);
            // the aggregations result from reduce of either global or non-global aggs is present so lets combine it with other aggs
public class AggregationReduceableSearchResult implements ReduceableSearchResult {
import org.opensearch.search.query.QuerySearchResult;
        } else {  
package org.opensearch.search.aggregations;
import org.opensearch.search.query.ReduceableSearchResult;
    @Override
 * SPDX-License-Identifier: Apache-2.0
    private final InternalAggregations aggregations;
    public void reduce(QuerySearchResult result) throws IOException {  
            result.aggregations(aggregations);
        if (!result.hasAggs()) {
            final InternalAggregations finalReducedAggregations = InternalAggregations.merge(existingAggregations, aggregations);
        this.aggregations = aggregations;
/**  
}
    }
 * compatible open source license.
 *
/*  
