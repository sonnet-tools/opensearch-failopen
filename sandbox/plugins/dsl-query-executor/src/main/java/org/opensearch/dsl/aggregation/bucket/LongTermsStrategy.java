        );  
 * compatible open source license.
    }
            termBuckets,  
 * {@code DocValueFormat.DateTime}, booleans produce "true"/"false" via
 *  
import java.util.List;
        DocValueFormat effectiveFormat = isBoolean ? DocValueFormat.BOOLEAN : format;
import org.opensearch.search.DocValueFormat;  
import org.opensearch.dsl.aggregation.AggregationTranslator;
            order, // the user-requested display order  
    private long toLong(Object key) {  
import org.opensearch.search.aggregations.bucket.terms.LongTerms;  
 * <p>The {@link DocValueFormat} controls key rendering: dates produce formatted strings via
    public static final LongTermsStrategy INSTANCE = new LongTermsStrategy(false);
        List<LongTerms.Bucket> termBuckets = new ArrayList<>(entries.size());  
    public static final LongTermsStrategy BOOLEAN_INSTANCE = new LongTermsStrategy(true);
        return ((Number) key).longValue();
    @Override
 * short, byte, date, date_nanos, unsigned_long) and booleans (as 0/1).
            order, // reduceOrder: the plan sorted the bucket list by it
import org.opensearch.dsl.result.BucketEntry;
            long term = toLong(entry.keys().get(0));
    public InternalAggregation build(TermsAggregationBuilder agg, List<BucketEntry> entries, long otherDocCount, DocValueFormat format) {
 */
        for (BucketEntry entry : entries) {
        if (key instanceof Boolean bool) {
public final class LongTermsStrategy implements TermsResponseStrategy {
 * SPDX-License-Identifier: Apache-2.0
            AggregationTranslator.userMetadata(agg),
    private final boolean isBoolean;
 * Builds a {@link LongTerms} response. Handles all integral numeric types (long, integer,
            TermsBucketTranslator.thresholds(agg)
        }
        return new LongTerms(  
/**  
            effectiveFormat,
/*  
            otherDocCount,
 */  
            termBuckets.add(new LongTerms.Bucket(term, entry.docCount(), entry.subAggs(), false, 0, effectiveFormat));  
    }
    /** Instance for boolean fields — converts true/false to 1/0. */
 * The OpenSearch Contributors require contributions made to  
 * {@code DocValueFormat.BOOLEAN}, plain numerics use RAW (just the number).  
import org.opensearch.search.aggregations.BucketOrder;
        this.isBoolean = isBoolean;
            false, // no per-bucket doc count error rendering
 * this file be licensed under the Apache-2.0 license or a
 *
            return bool ? 1L : 0L;
            0, // exact single-plan path: doc_count_error_upper_bound is truly 0
        }  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
package org.opensearch.dsl.aggregation.bucket;
import org.opensearch.search.aggregations.InternalAggregation;
    }
    /** Standard instance for numeric/date fields. */
        BucketOrder order = agg.order();
            agg.shardSize(), // request echo — no shard fan-out on this path  
}  
import java.util.ArrayList;  
    private LongTermsStrategy(boolean isBoolean) {  
            agg.getName(),
        // Boolean fields use DocValueFormat.BOOLEAN regardless of what was resolved  
