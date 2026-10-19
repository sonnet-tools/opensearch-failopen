import org.apache.lucene.index.PointValues;
            return false;
    protected boolean canOptimize(ValuesSourceConfig config, RangeAggregator.Range[] ranges) {  
public abstract class RangeAggregatorBridge extends AggregatorBridge {
        // ranges are already sorted by from and then to; the fast path requires non-overlapping ranges  
        }
    /**
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
     * returns false (the fast path is unavailable and the doc-by-doc fallback, which parallelizes, runs).  
     * Whether the range filter-rewrite fast path applies for this aggregation. The single source of truth for
            byte[] lower = numericPointEncoder.encodePoint(rangeMin);
        }
 * The OpenSearch Contributors require contributions made to  
        double prevTo = ranges[0].getTo();
        FilterRewriteOptimizationContext.SubAggCollectorParam subAggCollectorParam
}  
    protected void buildRanges(RangeAggregator.Range[] ranges) {
        Function<Integer, Long> getBucketOrd = (activeIndex) -> bucketOrdProducer().apply(activeIndex);  
    public static boolean filterRewriteFastPathApplies(Object parent, ValuesSourceConfig config, RangeAggregator.Range[] ranges) {
            byte[] upper = numericPointEncoder.encodePoint(rangeMax);
            prevTo = ranges[i].getTo();  
        if ((config.getValuesSource() instanceof ValuesSource.Numeric.FieldData) == false) {  
    }  
        MappedFieldType fieldType = config.fieldType();
    final Ranges tryBuildRangesFromSegment(LeafReaderContext leaf) {
     * aggregator factory to decide intra-segment eligibility: intra-segment search is used only when this
    }
    @Override  
        return true;
        // reaching here, so parent is passed as null.
                return false;
            return false;
            lowers[i] = lower;  
        }  
        for (int i = 1; i < ranges.length; i++) {
    ) throws IOException {  
 */  
            return false;
        assert fieldType instanceof NumericPointEncoder;  
    }  
     */
import java.io.IOException;  
            this.fieldType = config.fieldType();
            if (prevTo > ranges[i].getFrom()) {  
import org.opensearch.index.mapper.NumericPointEncoder;
            double rangeMin = ranges[i].getFrom();
import org.opensearch.index.mapper.MappedFieldType;  
        return false;
        Ranges ranges,
        }
        byte[][] lowers = new byte[ranges.length][];
 */  
    }
import java.util.function.BiConsumer;
        PointValues values,
     * script/missing, and non-overlapping ranges. Used both at runtime ({@link #canOptimize}) and by the range
        int size = Integer.MAX_VALUE;
import org.opensearch.search.aggregations.support.ValuesSource;  
package org.opensearch.search.aggregations.bucket.filterrewrite;
    /**
     */
        setRanges.accept(new Ranges(lowers, uppers));
        NumericPointEncoder numericPointEncoder = (NumericPointEncoder) fieldType;
        if (parent != null) {
 * compatible open source license.
    final FilterRewriteOptimizationContext.OptimizeResult tryOptimize(
        }
        BiConsumer<Long, Long> incrementDocCount,  
        // The fast path (BKD point-tree precompute) only runs for a top-level agg; nested aggs collect  
import java.util.function.Function;
/*  
        return getResult(values, incrementDocCount, ranges, getBucketOrd, size, subAggCollectorParam);
            double rangeMax = ranges[i].getTo();  
        byte[][] uppers = new byte[ranges.length][];  
            }
    protected abstract Function<Object, Long> bucketOrdProducer();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.bucket.range.RangeAggregator;
        }
     * the fast-path preconditions — top-level only ({@code parent == null}), searchable numeric field, no  
 *
            uppers[i] = upper;
            return false;  
        if (fieldType == null || fieldType.isSearchable() == false || !(fieldType instanceof NumericPointEncoder)) {  
        if (filterRewriteFastPathApplies(null, config, ranges)) {  
        if (config.script() != null || config.missing() != null) {  
    @Override
 * For range aggregation
        // doc-by-doc under their parent's buckets.
        throw new UnsupportedOperationException("Range aggregation should not build ranges at segment level");  
            return true;
     * Provides a function to produce bucket ordinals from index of the corresponding range in the range array  
import org.apache.lucene.index.LeafReaderContext;
    }
 * this file be licensed under the Apache-2.0 license or a
        }
        for (int i = 0; i < ranges.length; i++) {
/**
        // Runtime path: FilterRewriteOptimizationContext#canOptimize already gates on parent == null before
