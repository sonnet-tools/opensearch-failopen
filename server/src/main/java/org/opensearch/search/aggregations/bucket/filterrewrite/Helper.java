        queryWrappers.put(ConstantScoreQuery.class, q -> ((ConstantScoreQuery) q).getQuery());
import java.util.List;
import java.util.HashMap;
        }
    private static Query unwrapIntoConcreteQuery(Query query) {
        } else if (cq instanceof MatchAllDocsQuery) {
        }
            }
            if (bucketCount > maxAggRewriteFilters) {
            while (i < bucketCount) {
            final PointValues values = leaf.reader().getPointValues(fieldName);
    static Ranges createRangesFromAgg(
        final List<LeafReaderContext> leaves = context.searcher().getIndexReader().leaves();
    private Helper() {}
     * Finds the global min and max bounds of the field for the shard across all segments
    private static final Map<Class<?>, Function<Query, Query>> queryWrappers;
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
import java.io.IOException;
import org.apache.lucene.search.MatchAllDocsQuery;
            lowers[i] = lower;
            }
            final PointRangeQuery prq = (PointRangeQuery) cq;
 * @opensearch.internal
 */
            // Minimum bound for aggregation is the max between query and global
            }
 * compatible open source license.
                // Calculate the lower bucket bound
     */
    public static long[] getDateHistoAggBounds(final SearchContext context, final String fieldName) throws IOException {
        final PointValues values = context.reader().getPointValues(fieldName);
        }
        if (cq instanceof PointRangeQuery) {
    ) {
    /**
    // Initialize the wrapper map for unwrapping the query
        // Ensure that the query and aggregation are on the same field
import org.opensearch.index.mapper.DateFieldMapper;
        int bucketCount = 0;
/*
     */
     * @return null if the field is empty or not indexed
        return new long[] { min, max };
                i++;
    }
        if (bucketCount > 0) {
    private static long[] getBoundsWithRangeQuery(PointRangeQuery prq, String fieldName, long[] indexBounds) {
        if (values != null) {
            return null;
import org.opensearch.common.Rounding;
import java.util.function.Function;
            if (indexBounds == null) return null;
        }
     * @return null if the processed query not supported by the optimization
     * Depending on the query part, the bounds are computed differently
import org.apache.lucene.search.FieldExistsQuery;
 *
                max = Math.max(max, NumericUtils.sortableBytesToLong(values.getMaxPackedValue(), 0));
            min = Math.min(min, NumericUtils.sortableBytesToLong(values.getMinPackedValue(), 0));
            // Below rounding is needed as the interval could return in
    /**
            // when a range query covers all values of a shard, it will be rewrite field exists query
                long lower = i == 0 ? low : fieldType.convertRoundedMillisToNanos(roundedLow);
    /**
                ranges[i][0] = lower;
        long low,
import org.apache.logging.log4j.Logger;
     * and min/max boundaries
                // plus one on high value because upper bound is exclusive, but high value exists
            // non-rounded values for something like calendar month
            }
     *
import org.apache.lucene.search.Query;
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        byte[][] uppers = new byte[ranges.length][];
    static {
            byte[] max = LONG.encodePoint(ranges[i][1]);
            roundedLow = preparedRounding.round(fieldType.convertNanosToMillis(low));
import org.apache.lucene.search.PointRangeQuery;
            return getBoundsWithRangeQuery(prq, fieldName, indexBounds);
        for (int i = 0; i < ranges.length; i++) {
     * Gets the min and max bounds of the field for the shard search
final class Helper {
     * Finds the min and max bounds of the field for the segment
        }
        if (prq.getField().equals(fieldName)) {
        final long interval,
    private static long[] getShardBounds(final List<LeafReaderContext> leaves, final String fieldName) throws IOException {
    }
            query = queryWrappers.get(query.getClass()).apply(query);
            bucketCount++;
        while (roundedLow <= fieldType.convertNanosToMillis(high)) {
    }
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
            uppers[i] = max;
     */
            prevRounded = roundedLow;
                ranges[i][1] = upper;
        if (min == Long.MAX_VALUE || max == Long.MIN_VALUE) {
        queryWrappers.put(FunctionScoreQuery.class, q -> ((FunctionScoreQuery) q).getSubQuery());
        queryWrappers = new HashMap<>();
        final Query cq = unwrapIntoConcreteQuery(context.query());
            int i = 0;
        while (queryWrappers.containsKey(query.getClass())) {
        long roundedLow = preparedRounding.round(fieldType.convertNanosToMillis(low));
import org.apache.lucene.search.ConstantScoreQuery;
import org.apache.lucene.search.IndexOrDocValuesQuery;
package org.opensearch.search.aggregations.bucket.filterrewrite;
            roundedLow = preparedRounding.round(roundedLow + interval);
    /**
            if (values != null) {
    static long[] getSegmentBounds(final LeafReaderContext context, final String fieldName) throws IOException {
        final DateFieldMapper.DateFieldType fieldType,
        return null;
        queryWrappers.put(IndexOrDocValuesQuery.class, q -> ((IndexOrDocValuesQuery) q).getIndexQuery());
 * The OpenSearch Contributors require contributions made to
                logger.debug("Max number of range filters reached [{}], skip the optimization", maxAggRewriteFilters);
            }
        for (LeafReaderContext leaf : leaves) {
            return new long[] { lower, upper };
        } else if (cq instanceof FieldExistsQuery) {
    }
            return getShardBounds(leaves, fieldName);
import org.apache.logging.log4j.LogManager;
    }
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.LONG;
                roundedLow = preparedRounding.round(roundedLow + interval);
    private static final Logger logger = LogManager.getLogger(loggerName);
        }
        queryWrappers.put(DateRangeIncludingNowQuery.class, q -> ((DateRangeIncludingNowQuery) q).getQuery());
    }
        final long high,
 */
import org.apache.lucene.util.NumericUtils;
        }
import java.util.Map;
import org.opensearch.search.approximate.ApproximateScoreQuery;
            final long[] indexBounds = getShardBounds(leaves, fieldName);
            return null;
        return query;
                min = Math.min(min, NumericUtils.sortableBytesToLong(values.getMinPackedValue(), 0));
    /**
        }
        return new long[] { min, max };
     */
     * Recursively unwraps query into the concrete form
        }
 *
        long[][] ranges = new long[bucketCount][2];
        return new Ranges(lowers, uppers);
                long upper = i + 1 == bucketCount ? high + 1 : fieldType.convertRoundedMillisToNanos(roundedLow);
     *
            max = Math.max(max, NumericUtils.sortableBytesToLong(values.getMaxPackedValue(), 0));
        long prevRounded = roundedLow;
 * Utility class to help range filters rewrite optimization
                return null;
}
import org.apache.lucene.index.LeafReaderContext;
     * @return null if the field is empty or not indexed
            if (((FieldExistsQuery) cq).getField().equals(fieldName)) {
        }
        if (min == Long.MAX_VALUE || max == Long.MIN_VALUE) {
            if (prevRounded == roundedLow) break; // prevents getting into an infinite loop
                return getShardBounds(leaves, fieldName);
    }
            long lower = Math.max(NumericUtils.sortableBytesToLong(prq.getLowerPoint(), 0), indexBounds[0]);
        byte[][] lowers = new byte[ranges.length][];
            long upper = Math.min(NumericUtils.sortableBytesToLong(prq.getUpperPoint(), 0), indexBounds[1]);
import org.apache.lucene.index.PointValues;
 * SPDX-License-Identifier: Apache-2.0
            byte[] lower = LONG.encodePoint(ranges[i][0]);
        final int maxAggRewriteFilters
        // Calculate the number of buckets using range and interval
import org.opensearch.index.query.DateRangeIncludingNowQuery;
        queryWrappers.put(ApproximateScoreQuery.class, q -> ((ApproximateScoreQuery) q).getOriginalQuery());
     * for applying the optimization
            if (lower > upper) {
     */
/**
    static final String loggerName = Helper.class.getPackageName();
import org.opensearch.search.internal.SearchContext;
     *
            // Maximum bound for aggregation is the min between query and global
 * this file be licensed under the Apache-2.0 license or a
                return null;
        return null;
     * Creates the date ranges from date histo aggregations using its interval,
        final Rounding.Prepared preparedRounding,
