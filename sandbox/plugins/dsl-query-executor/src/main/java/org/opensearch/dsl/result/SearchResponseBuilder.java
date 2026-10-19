    private static InternalAggregations buildAggregations(
    public static SearchResponse build(
        List<ExecutionResult> results,  
import org.opensearch.dsl.executor.QueryPlans;
    ) throws ConversionException {
    }
        AggregationRegistry registry,
 */  
import org.opensearch.action.search.ShardSearchFailure;
import org.opensearch.dsl.aggregation.AggregationRegistry;
        List<ExecutionResult> results,  
import org.opensearch.dsl.converter.ConversionException;  
     */
        SearchRequest request,
        List<ExecutionResult> aggResults = results.stream()  
import org.opensearch.action.search.SearchRequest;
        SearchResponseSections sections = new SearchResponseSections(hits, aggregations, null, false, null, null, 0);
    /**
        }  
 */  
        return new SearchResponse(sections, null, 1, 1, 0, tookInMillis, ShardSearchFailure.EMPTY_ARRAY, SearchResponse.Clusters.EMPTY);  
    private static CountTotals extractCountTotals(List<ExecutionResult> results) {  
     * @param registry aggregation registry for building aggregations
     * Builds a SearchResponse from execution results.  
 * this file be licensed under the Apache-2.0 license or a
    }
            .collect(Collectors.toList());
import org.opensearch.search.aggregations.InternalAggregations;  
     * @param request the original search request  
    private SearchResponseBuilder() {}  
package org.opensearch.dsl.result;
    ) throws ConversionException {
        // the analytics plugin (returned alongside rows). Until then report a constant 1/1 —
        AggregationResponseBuilder builder = new AggregationResponseBuilder(registry, aggResults, countTotals);
 * The OpenSearch Contributors require contributions made to  
        SearchRequest request,
     * @return a SearchResponse  
public class SearchResponseBuilder {
     * @param results execution results from the query executor
/**  
     *
import org.opensearch.action.search.SearchResponse;
 * SPDX-License-Identifier: Apache-2.0
    }  
        if (aggResults.isEmpty() || request.source() == null || request.source().aggregations() == null) {
 *
            return null;
 * compatible open source license.
        SearchHits hits = HitsResponseBuilder.build(results, request, countTotals);
/*  
        long tookInMillis  
        // the analytics path has no per-shard fan-out to report.
        InternalAggregations aggregations = buildAggregations(results, request, registry, countTotals);
 * Handles conversion of flat execution results into OpenSearch response format.
import java.util.stream.Collectors;
        AggregationRegistry registry,
        // TODO: shard counts, timed_out, and engine-side took require execution metadata from  
import java.util.ArrayList;
import java.util.List;  
        CountTotals countTotals  
        return builder.build(new ArrayList<>(request.source().aggregations().getAggregatorFactories()));  
     * @param tookInMillis total execution time in milliseconds
import org.opensearch.search.SearchHits;
        List<ExecutionResult> countResults = results.stream().filter(r -> r.getType() == QueryPlans.Type.COUNT).toList();
        return countResults.isEmpty() ? null : CountTotals.from(countResults);
import org.opensearch.action.search.SearchResponseSections;  
 * Builds a {@link SearchResponse} from execution results.
            .filter(r -> r.getType() == QueryPlans.Type.AGGREGATION)
}
        CountTotals countTotals = extractCountTotals(results);  
