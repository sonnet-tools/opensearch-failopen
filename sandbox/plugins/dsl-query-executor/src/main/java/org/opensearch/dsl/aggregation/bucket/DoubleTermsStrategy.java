    }
    public InternalAggregation build(TermsAggregationBuilder agg, List<BucketEntry> entries, long otherDocCount, DocValueFormat format) {  
import org.opensearch.search.aggregations.bucket.terms.DoubleTerms;  
public final class DoubleTermsStrategy implements TermsResponseStrategy {
            0,
            AggregationTranslator.userMetadata(agg),
            termBuckets.add(new DoubleTerms.Bucket(term, entry.docCount(), entry.subAggs(), false, 0, format));
            termBuckets,
            agg.getName(),
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import org.opensearch.search.DocValueFormat;  
 * this file be licensed under the Apache-2.0 license or a
 * half_float, scaled_float). Constructor argument semantics match {@link LongTermsStrategy}.
}  
/**  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
            order,
        for (BucketEntry entry : entries) {
package org.opensearch.dsl.aggregation.bucket;
    /** Singleton instance. */  
import org.opensearch.dsl.aggregation.AggregationTranslator;
        }
            false,
            agg.shardSize(),
            format,  
 */  
    private DoubleTermsStrategy() {}  
import org.opensearch.dsl.result.BucketEntry;
import org.opensearch.search.aggregations.BucketOrder;
import org.opensearch.search.aggregations.InternalAggregation;
            order,  
 *
        );
    public static final DoubleTermsStrategy INSTANCE = new DoubleTermsStrategy();
    @Override
import java.util.ArrayList;  
/*  
            otherDocCount,  
 * Builds a {@link DoubleTerms} response for floating-point key types (float, double,
        List<DoubleTerms.Bucket> termBuckets = new ArrayList<>(entries.size());
            TermsBucketTranslator.thresholds(agg)  
 */  
            double term = ((Number) entry.keys().get(0)).doubleValue();  
        BucketOrder order = agg.order();  
        return new DoubleTerms(
import java.util.List;
