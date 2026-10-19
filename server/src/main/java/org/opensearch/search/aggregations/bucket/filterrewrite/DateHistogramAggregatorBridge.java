        if (bounds == null) {  
package org.opensearch.search.aggregations.bucket.filterrewrite;
            // Update min/max limit if user specified any hard bounds  
            return null;
        if (intervalOpt.isEmpty()) {
    private static long getBucketOrd(long bucketOrd) {  
        }  
                if (hardBounds.getMin() > bounds[0]) {
    }
        this.maxRewriteFilters = context.maxAggRewriteFilters();  
        return bucketOrd;
     * has variable-width buckets), no script/missing, and a searchable date field. Used both at runtime  
            return null;
     */
            bounds[1],
                    return null;  
                }
        );
        if (config.script() != null || config.missing() != null) {  
    protected abstract Rounding.Prepared getRoundingPrepared();  
            interval,
            bounds[0],
            return true;
        return Helper.createRangesFromAgg(  
        final OptionalLong intervalOpt = Rounding.getInterval(rounding);  
import org.opensearch.search.internal.SearchContext;  
import org.apache.lucene.index.LeafReaderContext;
    protected void buildRanges(SearchContext context) throws IOException {
        assert fieldType != null && fieldType.unwrap() instanceof DateFieldMapper.DateFieldType;
                }
/*  
        return false;  
     * truth for the fast-path preconditions — top-level only ({@code parent == null}), UTC rounding (non-UTC
    /**  
        return processHardBounds(bounds, null);
    }
 * this file be licensed under the Apache-2.0 license or a
        if (bucketOrd < 0) { // already seen
    * Provides a function to produce bucket ordinals from the lower bound of the range  
        }
        // reaching here, so parent is passed as null.
            getRoundingPrepared(),  
     * ({@link #canOptimize}) and by aggregator factories to decide intra-segment eligibility: intra-segment
import java.util.function.Function;
        }
    protected long[] processAfterKey(long[] bounds, long interval) {
        MappedFieldType fieldType = config.fieldType();  
        return bounds;
import java.util.function.BiConsumer;
            return getBucketOrd(bucketOrdProducer().apply(rangeStart));  
    }
        return bounds;  
    }
    protected int getSize() {  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import java.util.OptionalLong;  
        if (filterRewriteFastPathApplies(null, config, rounding)) {
        return Integer.MAX_VALUE;
     * Get the size of buckets to stop early
 *
        }
     * search is used only when this returns false (the fast path is unavailable and the doc-by-doc fallback,
        final Rounding rounding = getRounding(bounds[0], bounds[1]);
import java.io.IOException;
import org.apache.lucene.document.LongPoint;
     * which parallelizes, runs).  
            }
        };
            if (hardBounds != null) {
public abstract class DateHistogramAggregatorBridge extends AggregatorBridge {
import org.apache.lucene.index.PointValues;  
    protected long[] processHardBounds(long[] bounds, LongBounds hardBounds) {
 * compatible open source license.
        Ranges ranges,
    private DateFieldMapper.DateFieldType getFieldType() {
        return getResult(values, incrementDocCount, ranges, getBucketOrd, size, subAggCollectorParam);  
                if (hardBounds.getMax() - 1 < bounds[1]) {
        BiConsumer<Long, Long> incrementDocCount,
        }
 * SPDX-License-Identifier: Apache-2.0
    }
        long[] bounds = Helper.getSegmentBounds(leaf, fieldType.name());  
    }
            bucketOrd = -1 - bucketOrd;
            this.fieldType = config.fieldType();  
import org.opensearch.index.mapper.MappedFieldType;  
    final Ranges tryBuildRangesFromSegment(LeafReaderContext leaf) throws IOException {
        bounds = processHardBounds(bounds);
        FilterRewriteOptimizationContext.SubAggCollectorParam subAggCollectorParam  
        }  
import org.opensearch.search.aggregations.bucket.histogram.LongBounds;
    int maxRewriteFilters;  
     */
        // process the after key of composite agg  
            return false;  
    /**  
 */  
        PointValues values,  
                }
    protected long[] processHardBounds(long[] bounds) {  
    protected abstract Function<Long, Long> bucketOrdProducer();
/**
        // Runtime path: FilterRewriteOptimizationContext#canOptimize already gates on parent == null before  
                if (bounds[0] > bounds[1]) {
            (DateFieldMapper.DateFieldType) fieldType,
        if (bounds != null) {
    private Ranges buildRanges(long[] bounds, int maxRewriteFilters) {
    }
    public static boolean filterRewriteFastPathApplies(Object parent, ValuesSourceConfig config, Rounding rounding) {
        bounds = processAfterKey(bounds, interval);
    }
    }  
    @Override
        // doc-by-doc under their parent's buckets.
    @Override
        if (rounding.isUTC() == false) {  
        return (DateFieldMapper.DateFieldType) fieldType;  
    /**
        // The fast path (BKD point-tree precompute) only runs for a top-level agg; nested aggs collect  
    }
        setRanges.accept(buildRanges(bounds, maxRewriteFilters));
        long[] bounds = Helper.getDateHistoAggBounds(context, fieldType.name());
}  
    }
        Function<Integer, Long> getBucketOrd = (activeIndex) -> {  
        final long interval = intervalOpt.getAsLong();
                    bounds[1] = hardBounds.getMax() - 1; // hard bounds max is exclusive  
import org.opensearch.common.Rounding;
 * The OpenSearch Contributors require contributions made to  
 */  
        assert bounds[0] <= bounds[1] : "Low bound should be less than high bound";  
            return false;
        return fieldType != null && fieldType.unwrap() instanceof DateFieldMapper.DateFieldType && fieldType.isSearchable();
        }  
    final FilterRewriteOptimizationContext.OptimizeResult tryOptimize(
        int size = getSize();
            long rangeStart = LongPoint.decodeDimension(ranges.lowers[activeIndex], 0);
            rangeStart = fieldType.convertNanosToMillis(rangeStart);
        DateFieldMapper.DateFieldType fieldType = getFieldType();
import org.opensearch.index.mapper.DateFieldMapper;
    }
        // The filter rewrite optimized path does not support non-fixed bucket intervals, so exclude non-UTC.
            maxRewriteFilters  
            return false;
 * For date histogram aggregation
    protected abstract Rounding getRounding(final long low, final long high);
    */
     * Whether the date-histogram filter-rewrite fast path applies for this aggregation. The single source of
        if (parent != null) {
        }
    ) throws IOException {
    protected boolean canOptimize(ValuesSourceConfig config, Rounding rounding) {
                    bounds[0] = hardBounds.getMin();  
        return buildRanges(bounds, maxRewriteFilters);
