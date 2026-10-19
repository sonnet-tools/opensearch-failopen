 * The OpenSearch Contributors require contributions made to  
 * Rendering goes through
     * @return the InternalAggregation
    InternalAggregation toBucketAggregation(T agg, Iterable<BucketEntry> buckets, long eligibleDocCount);  
     * @param buckets the top bucket entries
 * SPDX-License-Identifier: Apache-2.0
public interface SizedBucketTranslator<T extends AggregationBuilder> extends BucketTranslator<T> {  
 * this file be licensed under the Apache-2.0 license or a
    long minDocCount(T agg);
     * already filtered (nulls, {@code min_doc_count}), ordered, and truncated by the plan —  
     * and are rendered as received.
}
 * already filtered, ordered, and truncated, plus the eligible-document total that  
 * top {@code size} buckets by the requested order, and the remaining documents are reported as
 * engine-side (LIMIT, HAVING, SORT), so the engine returns exactly the response's bucket set.  
     * @param agg the bucket aggregation builder
    int size(T agg);
     *
    /**
     */
     * Values above 1 become a plan-level HAVING filter.  
 */  
/**
    /**
 * {@code sum_other_doc_count}. Terms and its relatives fit this contract; types that return
 * A {@link BucketTranslator} for bucket types with top-K semantics: the response carries the  
     * Returns the requested bucket count (the {@code size} parameter).  
     */
     * @param eligibleDocCount total documents eligible for this level's buckets;
 *
import org.opensearch.search.aggregations.InternalAggregation;  
import org.opensearch.dsl.result.BucketEntry;
 * compatible open source license.
     * Returns the minimum per-bucket doc count (the {@code min_doc_count} parameter).
 * {@link #toBucketAggregation(AggregationBuilder, Iterable, long)}, which receives that set
 *
 * their full bucket set (histogram, range, filters) do not implement it.  
/*  
     * Renders a level whose plan enforced {@code size}. The entries are the final bucket set —
 * <p>Plans for these aggregations enforce {@code size}, {@code min_doc_count}, and order
 * {@code sum_other_doc_count} is derived from.
     *
    /**
     *        {@code sum_other_doc_count} is this value minus the received buckets' doc counts  
     *
import org.opensearch.search.aggregations.AggregationBuilder;
 */
package org.opensearch.dsl.aggregation.bucket;
     * @param agg the bucket aggregation builder
     * @param agg the original aggregation builder  
     * @return the requested size  
     */
     * @return the minimum doc count  
