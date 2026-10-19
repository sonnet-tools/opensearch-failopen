     * Returns the grouping contribution for this bucket.
     *  
    BucketOrder getBucketOrder(T agg);
     * @param buckets the bucket entries with keys, doc counts, and sub-aggs
     * Converts grouped bucket entries into an OpenSearch InternalAggregation for response building.
     */  
     * @param agg the bucket aggregation builder
 */  
    /**  
     *
    InternalAggregation toBucketAggregation(T agg, Iterable<BucketEntry> buckets);
     */  
     * @return the grouping info
 * Translates a bucket aggregation (terms, multi_terms, etc.) to a {@link GroupingInfo}
     * Each entry carries one key per field declared in {@link #getGrouping}, in declaration order:  
     * @param agg the original aggregation builder  
     * @return the bucket order, or null if default  
import org.opensearch.dsl.aggregation.AggregationTranslator;
import java.util.Collection;
     * {@code keys().get(i)} is the value of the i-th group field.
     */
     * @return the sub-aggregations
 * for GROUP BY resolution, and converts results back to InternalAggregation for response building.  
public interface BucketTranslator<T extends AggregationBuilder> extends AggregationTranslator<T> {
 *
import org.opensearch.search.aggregations.AggregationBuilder;
import org.opensearch.dsl.aggregation.GroupingInfo;
     * @return the InternalAggregation
    /**
     */
 * this file be licensed under the Apache-2.0 license or a
     * @param agg the bucket aggregation builder  
 * SPDX-License-Identifier: Apache-2.0
 */
     * @param agg the bucket aggregation builder
    Collection<AggregationBuilder> getSubAggregations(T agg);  
/*  
import org.opensearch.dsl.result.BucketEntry;  
    GroupingInfo getGrouping(T agg);
package org.opensearch.dsl.aggregation.bucket;
}
    /**
 * compatible open source license.
    /**
     *
/**
     * Returns sub-aggregations to recurse into.
     *
     * Returns the bucket order for post-aggregation sorting.  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.InternalAggregation;  
import org.opensearch.search.aggregations.BucketOrder;
