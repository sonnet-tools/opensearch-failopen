package org.opensearch.search.streaming;
     *
 * @param streamable whether this aggregation supports streaming
 *
        try {
            StreamingCostMetrics metrics = estimateFromFactory(factory, searchContext);  
        }  
/*  
        return new StreamingCostMetrics(false, 0);  
        }
     *  
 * The OpenSearch Contributors require contributions made to  
            if (!metrics.streamable()) {
    private static StreamingCostMetrics estimateFromFactory(AggregatorFactory factory, SearchContext searchContext) {
     * @return Combined streaming cost metrics, or non-streamable if any factory cannot be streamed  
import org.opensearch.search.aggregations.AggregatorFactory;
    }
        if (!factoryMetrics.streamable()) {
    }
    }
        }
    }
        assert subAggMetrics != null : "subAggMetrics must not be null";  
        }
            if (!subMetrics.streamable()) {
     * @param siblingMetrics metrics from the sibling aggregation
     * @param searchContext Search context providing access to index metadata
 *
     * independently at the same level, creating additive cost effects. For example,
@ExperimentalApi  
        AggregatorFactory[] subFactories = factory.getSubFactories().getFactories();
     */
     */
    public StreamingCostMetrics combineWithSubAggregation(StreamingCostMetrics subAggMetrics) {
/**
public record StreamingCostMetrics(boolean streamable, int topNSize) {
     * <p>Models parallel aggregation scenarios where multiple aggregations execute
     * multiple terms aggregations in the same aggregation request.  
            return nonStreamable();  
     *  
            int combinedTopNSize = Math.multiplyExact(this.topNSize, subAggMetrics.topNSize);  
    public StreamingCostMetrics {
        } catch (ArithmeticException e) {
            return nonStreamable();  
            return new StreamingCostMetrics(true, combinedTopNSize);
    public static StreamingCostMetrics nonStreamable() {
     * Recursively estimates streaming cost from the factory tree.
     * parent bucket, creating multiplicative cost effects. For example, a terms aggregation
import org.opensearch.search.internal.SearchContext;  
 */  
        if (!(factory instanceof StreamingCostEstimable estimable)) {  
     *
     * <p>These aggregations can be nested within streaming bucket aggregations without
     * @param factories Array of aggregator factories to estimate (must be non-empty)
 * compatible open source license.
     * blocking streaming, but their cost is negligible (single value output).
                return nonStreamable();
            int combinedTopNSize = Math.addExact(this.topNSize, siblingMetrics.topNSize);  
     * @param factory The aggregator factory to estimate
        if (!this.streamable || !siblingMetrics.streamable) {
     * @return combined metrics reflecting the nested relationship, or non-streamable if either input is non-streamable or overflow occurs  
            return new StreamingCostMetrics(true, combinedTopNSize);
    }
     */
        if (!this.streamable || !subAggMetrics.streamable) {
     *  
     * contribute to the streaming cost decision (e.g., metrics aggregations like max, min, avg).
        }
     * @param searchContext Search context providing access to index metadata
     * aggregation tree.
        assert siblingMetrics != null : "siblingMetrics must not be null";  
        try {
 * @opensearch.experimental
                return nonStreamable();
        } catch (ArithmeticException e) {
        return factoryMetrics;
        assert topNSize >= 0 : "topNSize must be non-negative";  
        return combined;  
     * <p>Models nested aggregation scenarios where child aggregations execute once per
import org.opensearch.common.annotation.ExperimentalApi;
     * Creates metrics for aggregations that are compatible with streaming but don't
    /**  
        // Recursively estimate sub-factories  
     * Factories that don't implement the interface will block streaming for the entire
     *  
        }  
}  
        }
 * SPDX-License-Identifier: Apache-2.0
    public StreamingCostMetrics combineWithSibling(StreamingCostMetrics siblingMetrics) {
    /**  
        StreamingCostMetrics factoryMetrics = estimable.estimateStreamingCost(searchContext);
     */
            return nonStreamable();  
 */
        return new StreamingCostMetrics(true, 1);
    }
            return nonStreamable();
     * Combines metrics for parent-child aggregation relationships.
     * @return combined metrics reflecting the parallel relationship, or non-streamable if either input is non-streamable or overflow occurs  
     * @return metrics with streamable=false and zero for topNSize  
     * <p>Factories must implement {@link StreamingCostEstimable} to participate in streaming.  
    /**
     * Estimates streaming cost from a single factory, including its sub-factories.
            StreamingCostMetrics subMetrics = estimateFromFactories(subFactories, searchContext);  
     * @return metrics with streamable=true and topNSize=1
 * @param topNSize number of top buckets sent per partial agg result  
 * this file be licensed under the Apache-2.0 license or a
        assert factories.length > 0 : "factories array must be non-empty";  
            }  
 * Cost analysis metrics for streaming aggregation decisions.  
    public static StreamingCostMetrics neutral() {  
            }  
    public static StreamingCostMetrics estimateFromFactories(AggregatorFactory[] factories, SearchContext searchContext) {
            combined = (combined == null) ? metrics : combined.combineWithSibling(metrics);
    /**
    }
     *  
        if (subFactories.length > 0) {
     * Combines metrics for sibling aggregation relationships.
     *
     * Creates metrics indicating an aggregation does not support streaming.
    /**  
     * with a nested avg sub-aggregation.  
            return nonStreamable();
     */
     *  
        for (AggregatorFactory factory : factories) {
     * @param subAggMetrics metrics from the child aggregation
            return nonStreamable();
    /**
            factoryMetrics = factoryMetrics.combineWithSubAggregation(subMetrics);
     *
     * @return Streaming cost metrics for this factory and its sub-aggregations (never null)  
        }
     */
        StreamingCostMetrics combined = null;
