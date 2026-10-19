    ) {
    /**  
        if (min == Long.MAX_VALUE || max == Long.MIN_VALUE) {  
        }
import org.apache.lucene.util.NumericUtils;
     * Depending on the query part, the bounds are computed differently  
import org.apache.logging.log4j.Logger;
        final long interval,
     * and min/max boundaries
     * @return null if the field is empty or not indexed  
     * for applying the optimization
    static long[] getSegmentBounds(final LeafReaderContext context, final String fieldName) throws IOException {
            final long[] indexBounds = getShardBounds(leaves, fieldName);
    }  
            byte[] lower = LONG.encodePoint(ranges[i][0]);
    private Helper() {}
import org.opensearch.index.mapper.DateFieldMapper;
import java.util.function.Function;
    private static Query unwrapIntoConcreteQuery(Query query) {
            bucketCount++;
            return null;
            if (lower > upper) {
        for (int i = 0; i < ranges.length; i++) {
            if (indexBounds == null) return null;
        final PointValues values = context.reader().getPointValues(fieldName);
 * @opensearch.internal  
    public static long[] getDateHistoAggBounds(final SearchContext context, final String fieldName) throws IOException {
import java.util.Map;
        }
    }
        }  
            int i = 0;
        queryWrappers.put(ApproximateScoreQuery.class, q -> ((ApproximateScoreQuery) q).getOriginalQuery());  
            final PointValues values = leaf.reader().getPointValues(fieldName);
    /**
     * Gets the min and max bounds of the field for the shard search
     * Finds the min and max bounds of the field for the segment
            roundedLow = preparedRounding.round(fieldType.convertNanosToMillis(low));  
        long roundedLow = preparedRounding.round(fieldType.convertNanosToMillis(low));  
            return getBoundsWithRangeQuery(prq, fieldName, indexBounds);  
        int bucketCount = 0;
        final int maxAggRewriteFilters  
        queryWrappers.put(DateRangeIncludingNowQuery.class, q -> ((DateRangeIncludingNowQuery) q).getQuery());
        }
 *
    }
                ranges[i][1] = upper;  
    /**  
     */  
    static Ranges createRangesFromAgg(  
    /**
import org.opensearch.common.Rounding;  
     */
            byte[] max = LONG.encodePoint(ranges[i][1]);  
        final List<LeafReaderContext> leaves = context.searcher().getIndexReader().leaves();  
            }
 * this file be licensed under the Apache-2.0 license or a
     */  
package org.opensearch.search.aggregations.bucket.filterrewrite;
import org.opensearch.search.internal.SearchContext;
        } else if (cq instanceof MatchAllDocsQuery) {
        if (bucketCount > 0) {
/**  
                logger.debug("Max number of range filters reached [{}], skip the optimization", maxAggRewriteFilters);  
        }
     * Recursively unwraps query into the concrete form
        long[][] ranges = new long[bucketCount][2];
        final Query cq = unwrapIntoConcreteQuery(context.query());
    private static final Logger logger = LogManager.getLogger(loggerName);
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
import org.apache.lucene.index.LeafReaderContext;  
                roundedLow = preparedRounding.round(roundedLow + interval);  
    static {  
    private static long[] getShardBounds(final List<LeafReaderContext> leaves, final String fieldName) throws IOException {
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;  
        return new long[] { min, max };
            // when a range query covers all values of a shard, it will be rewrite field exists query
            return getShardBounds(leaves, fieldName);
        if (min == Long.MAX_VALUE || max == Long.MIN_VALUE) {
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.ConstantScoreQuery;
                long lower = i == 0 ? low : fieldType.convertRoundedMillisToNanos(roundedLow);
                // plus one on high value because upper bound is exclusive, but high value exists
            max = Math.max(max, NumericUtils.sortableBytesToLong(values.getMaxPackedValue(), 0));
        while (queryWrappers.containsKey(query.getClass())) {
        return null;
import org.apache.lucene.search.Query;
    /**  
                i++;
                max = Math.max(max, NumericUtils.sortableBytesToLong(values.getMaxPackedValue(), 0));
        while (roundedLow <= fieldType.convertNanosToMillis(high)) {  
     *
        }
    static final String loggerName = Helper.class.getPackageName();  
        }
import org.apache.lucene.index.PointValues;
     *
            // Below rounding is needed as the interval could return in  
            return null;
        byte[][] uppers = new byte[ranges.length][];  
            if (values != null) {  
            long lower = Math.max(NumericUtils.sortableBytesToLong(prq.getLowerPoint(), 0), indexBounds[0]);
        } else if (cq instanceof FieldExistsQuery) {  
        return query;  
        if (values != null) {
     */
            // non-rounded values for something like calendar month
import org.apache.lucene.search.IndexOrDocValuesQuery;
        // Ensure that the query and aggregation are on the same field
 *
 * The OpenSearch Contributors require contributions made to  
                return getShardBounds(leaves, fieldName);  
import org.apache.lucene.search.PointRangeQuery;  
     * Finds the global min and max bounds of the field for the shard across all segments
                min = Math.min(min, NumericUtils.sortableBytesToLong(values.getMinPackedValue(), 0));
import java.util.List;  
        byte[][] lowers = new byte[ranges.length][];
            if (prevRounded == roundedLow) break; // prevents getting into an infinite loop  
                return null;
            if (bucketCount > maxAggRewriteFilters) {
            roundedLow = preparedRounding.round(roundedLow + interval);
    private static long[] getBoundsWithRangeQuery(PointRangeQuery prq, String fieldName, long[] indexBounds) {
        }  
    }
        }  
        final Rounding.Prepared preparedRounding,  
            while (i < bucketCount) {  
    }
            if (((FieldExistsQuery) cq).getField().equals(fieldName)) {
        for (LeafReaderContext leaf : leaves) {
            }
            }
        if (cq instanceof PointRangeQuery) {
            uppers[i] = max;
import org.opensearch.index.query.DateRangeIncludingNowQuery;  
    private static final Map<Class<?>, Function<Query, Query>> queryWrappers;  
 * compatible open source license.
            prevRounded = roundedLow;
import org.opensearch.search.approximate.ApproximateScoreQuery;
        // Calculate the number of buckets using range and interval
        queryWrappers.put(FunctionScoreQuery.class, q -> ((FunctionScoreQuery) q).getSubQuery());  
            }
        return null;
/*  
     */
            query = queryWrappers.get(query.getClass()).apply(query);  
        queryWrappers.put(ConstantScoreQuery.class, q -> ((ConstantScoreQuery) q).getQuery());
 */
     *
            return new long[] { lower, upper };
        long low,
        }  
final class Helper {
        if (prq.getField().equals(fieldName)) {  
import org.apache.logging.log4j.LogManager;
            }  
     * Creates the date ranges from date histo aggregations using its interval,  
                ranges[i][0] = lower;
            lowers[i] = lower;
}
 * Utility class to help range filters rewrite optimization
 */  
            // Maximum bound for aggregation is the min between query and global  
        queryWrappers.put(IndexOrDocValuesQuery.class, q -> ((IndexOrDocValuesQuery) q).getIndexQuery());
            min = Math.min(min, NumericUtils.sortableBytesToLong(values.getMinPackedValue(), 0));  
import org.apache.lucene.search.MatchAllDocsQuery;
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.LONG;
     * @return null if the processed query not supported by the optimization
            long upper = Math.min(NumericUtils.sortableBytesToLong(prq.getUpperPoint(), 0), indexBounds[1]);
    }
                // Calculate the lower bucket bound
                return null;  
            final PointRangeQuery prq = (PointRangeQuery) cq;  
    }  
            // Minimum bound for aggregation is the max between query and global
        final DateFieldMapper.DateFieldType fieldType,
import java.util.HashMap;
        return new long[] { min, max };  
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;  
import org.apache.lucene.search.FieldExistsQuery;  
    // Initialize the wrapper map for unwrapping the query
                long upper = i + 1 == bucketCount ? high + 1 : fieldType.convertRoundedMillisToNanos(roundedLow);  
        final long high,
        queryWrappers = new HashMap<>();
import java.io.IOException;
        long prevRounded = roundedLow;
     * @return null if the field is empty or not indexed  
        return new Ranges(lowers, uppers);
