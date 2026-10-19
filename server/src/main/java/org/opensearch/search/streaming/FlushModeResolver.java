            for (AggregationBuilder nestedAgg : agg.getSubAggregations()) {
 *
     * @return true if all aggregations are eligible for streaming, false otherwise  
 *  
        // Prevent coordinator overload with too many buckets
        return isMetricAggregation(agg);
import java.util.Collection;
    }
 */
    public static final Setting<Long> STREAMING_MAX_ESTIMATED_BUCKET_COUNT = Setting.longSetting(  
     *  
    /**
public final class FlushModeResolver {
@ExperimentalApi  
import org.opensearch.common.annotation.ExperimentalApi;
     * If an aggregation is estimated to produce more buckets than this threshold,
}
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;  
        }  
 * Determines optimal {@link FlushMode} for streaming aggregations based on cost metrics.
     * Minimum cardinality ratio required for streaming aggregations.  
        }
            return false;  
     * Evaluates cost metrics to determine if streaming is beneficial.
    public static final Setting<Long> STREAMING_MIN_ESTIMATED_BUCKET_COUNT = Setting.longSetting(
        1L,
        Setting.Property.Dynamic,
                if (!isMetricAggregation(nestedAgg)) {
     */
            return defaultMode;
     */
        "search.aggregations.streaming.min_cardinality_ratio",
        1000,  
    private static boolean isTopLevelStreamable(AggregationBuilder agg) {
            }
     * @param metrics combined cost metrics from the factory tree
                return false;
import org.opensearch.search.aggregations.AggregationBuilder;  
            // Level 2 sub-aggs can only be metrics, not more terms  
        0.0,  
     * traditional shard-level processing will be used instead of streaming.  
            return false;
     * If the ratio is below this threshold, traditional processing is used
            || agg instanceof SumAggregationBuilder;  
        100_000L,
     *   <li>Sub-aggregations: numeric terms, cardinality, max, min, sum</li>
        for (AggregationBuilder agg : topLevelAggs) {
        1000L,
        1.0,
    private FlushModeResolver() {}  
     * @param defaultMode fallback mode when streaming is not beneficial
            || agg instanceof MaxAggregationBuilder
        if (metrics.topNSize() <= maxBucketCount) {
     */  
                    return false;  
        Setting.Property.NodeScope,
    }  
        1L,  
     * traditional processing is used to avoid streaming overhead for small result sets.  
                }
/*  
        }
    /**  
        if (agg instanceof TermsAggregationBuilder) {
        "search.aggregations.streaming.min_estimated_bucket_count",  
     * Determines if an aggregation tree is eligible for streaming based on aggregation types.  
        if (!(agg instanceof TermsAggregationBuilder)) {
        return agg instanceof CardinalityAggregationBuilder  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        for (AggregationBuilder subAgg : subAggs) {
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
        if (!metrics.streamable()) {
    public static FlushMode decideFlushMode(StreamingCostMetrics metrics, FlushMode defaultMode, long maxBucketCount) {  
        }
     * @return {@link FlushMode#PER_SEGMENT} if streaming is beneficial, otherwise the default mode
     *
     * Maximum estimated bucket count allowed for streaming aggregations.
            }
            }
        return true;
    public static final Setting<Integer> STREAMING_AGGREGATION_MIN_SEGMENT_SIZE_SETTING = Setting.intSetting(
        // Check sub-aggregations  
     */
        1,
     * @param aggregations the aggregation factories to validate
    /**
        Setting.Property.NodeScope,
    }
/**
        }
    /**
        if (aggregations == null || aggregations.count() == 0) {  
        "search.aggregations.streaming.max_estimated_bucket_count",
    private static boolean isSubAggregationStreamable(AggregationBuilder agg) {
            || agg instanceof MinAggregationBuilder
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;  
     *
     * Default is 1000. Can be adjusted based on accuracy requirements.
        Setting.Property.Dynamic
     */
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
     *   <li>Top level: terms aggregations (string or numeric)</li>
 */  
     * Range: 0.0 to 1.0, where 0.01 means at least 1% unique values.
     * This prevents coordinator overload from processing too many streaming buckets.
    /**  
     * Minimum segment-level size for streaming aggregations to ensure accuracy.  
     * <ul>  
import org.opensearch.common.settings.Setting;
    public static final Setting<Double> STREAMING_MIN_CARDINALITY_RATIO = Setting.doubleSetting(  
     * If an aggregation is estimated to produce fewer buckets than this threshold,
        "index.aggregation.streaming.min_segment_size",
 * this file be licensed under the Apache-2.0 license or a
        Setting.Property.IndexScope  
                return false;
     */
package org.opensearch.search.streaming;
            return FlushMode.PER_SEGMENT;  
            return true;  
    );
    }  
        Setting.Property.Dynamic
     * This applies per-segment in streaming mode to control the topN buckets collected.
    );  
        }  
        0.01,
 * SPDX-License-Identifier: Apache-2.0
            if (!isSubAggregationStreamable(subAgg)) {  
        return defaultMode;
        Setting.Property.NodeScope,  
     * Calculated as (estimated_buckets / documents_with_field).
        Collection<AggregationBuilder> topLevelAggs = aggregations.getAggregatorFactories();
    private static boolean isMetricAggregation(AggregationBuilder agg) {
 * compatible open source license.
    public static boolean isStreamable(AggregatorFactories.Builder aggregations) {
    );
     * </ul>  
            if (!isTopLevelStreamable(agg)) {  
        return true;
import org.opensearch.search.aggregations.AggregatorFactories;
 * The OpenSearch Contributors require contributions made to  
     * Minimum estimated bucket count required for streaming aggregations.
    }
     * to prevent performance regression on low-cardinality data.  
        Collection<AggregationBuilder> subAggs = agg.getSubAggregations();
 * @opensearch.internal
    /**
     * @param maxBucketCount maximum bucket count threshold  
     * <p>Streaming aggregations support:
        Setting.Property.Dynamic  
        }  
    );
