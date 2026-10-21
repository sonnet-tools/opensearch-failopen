            for (int bit = filteredValues.nextSetBit(0); bit != DocIdSetIterator.NO_MORE_DOCS; bit = (bit + 1 < numBits)
                context.getQueryShardContext().getStarTreeQueryContext().getBaseQueryStarTreeFilter(),
    ) {
        }
        List<DimensionFilter> dimensionFiltersToMerge = new ArrayList<>(initialDimensionFilters);
 */
     */
        Consumer<Long> growArrays,
        StarTreeValues starTreeValues,
        for (String baseDimension : baseStarTreeFilter.getDimensions()) {
        CompositeIndexFieldInfo starTree,
        List<Dimension> matchingDimensions = orderedDimensions.stream().filter(x -> x.getField().equals(dimensionName)).toList();
        return result;
            // Iterate over the filtered values
    ) {
    }
                ? filteredValues.nextSetBit(bit + 1)
    }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.codec.composite.CompositeIndexReader;
    public static boolean isStarTreeSupported(SearchContext context) {
import java.util.Collections;
import org.opensearch.index.compositeindex.datacube.MetricStat;
        SortedNumericStarTreeValuesIterator valuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues.getMetricValuesIterator(
            starTreeFilter = StarTreeQueryHelper.mergeDimensionFilterIfNotExists(
            );
import org.opensearch.index.query.QueryShardContext;
    public static StarTreeBucketCollector getStarTreeBucketMetricCollector(
        ValuesSource.Numeric valuesSource,
        }
        context.getQueryShardContext().getStarTreeQueryContext().maybeSetCachedNodeIdsForSegment(ctx.ord, result);
                }
        assert starTreeValues != null;
    }
            SortedNumericStarTreeValuesIterator metricValuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
/**
    public static StarTreeValues getStarTreeValues(LeafReaderContext context, CompositeIndexFieldInfo starTree) throws IOException {
     * Get the filtered values for the star-tree query
            public void collectStarTreeEntry(int starTreeEntryBit, long bucket) throws IOException {
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils;
import org.opensearch.search.startree.filter.StarTreeFilter;
 * @opensearch.experimental
        Aggregator[] subAggregators
                if (valuesIterator.advanceExact(bit) == false) {
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
                if (!metricValuesIterator.advanceExact(starTreeEntryBit)) {
        List<DimensionFilter> initialDimensionFilters,
                // Advance the valuesIterator to the current bit
import org.apache.lucene.index.SegmentReader;
    /**
            result = StarTreeTraversalUtil.getStarTreeResult(
    ) throws IOException {
                dimensionFiltersToMerge.addAll(childFilters != null ? childFilters : Collections.emptyList());
        String metricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(starTree.getField(), fieldName, metric);
import org.apache.lucene.search.DocIdSetIterator;
        Consumer<Long> valueConsumer,
                List<DimensionFilter> childFilters = collector.getDimensionFilters();
                List.of(dimensionFilter)
    public static FixedBitSet getStarTreeResult(
        return (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(starTree);
import org.opensearch.search.internal.SearchContext;
        SegmentReader reader = Lucene.segmentReader(context.reader());
        FixedBitSet result = context.getQueryShardContext().getStarTreeQueryContext().maybeGetCachedNodeIdsForSegment(ctx.ord);
     */
            if (subAgg instanceof StarTreePreComputeCollector collector) {
        return (SortedNumericStarTreeValuesIterator) starTreeValues.getMetricValuesIterator(metricName);
    ) {
 *
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
        return (starTreeQueryContext != null) ? starTreeQueryContext.getStarTree() : null;
        }
}
            }
 * Helper class for building star-tree query
        String metric,
     * @return FixedBitSet of matched document IDs
    public static void precomputeLeafUsingStarTree(
        Dimension matchingDimension = getMatchingDimensionOrNull(dimensionName, orderedDimensions);
        StarTreeFilter starTreeFilter = context.getQueryShardContext().getStarTreeQueryContext().getBaseQueryStarTreeFilter();
        throws IOException {
            dimensionFilterMap.put(dimensionToMerge, dimensionFiltersToMerge);
    ) throws IOException {
        return dimensionFiltersToMerge;
        );
                starTree.getField(),
    public static SortedNumericStarTreeValuesIterator getDocCountsIterator(
    }
        ValuesSource.Numeric valuesSource,
            return null;
                ? matchingDocsBitSet.nextSetBit(bit + 1)
        assert parentCollector != null;
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
import org.opensearch.common.lucene.Lucene;
 * SPDX-License-Identifier: Apache-2.0
        String metric,
        // Obtain a FixedBitSet of matched star tree document IDs
                // Iterate over the values for the current entryId
     * For a StarTreeBucketCollector, get matching star-tree entries and update relevant buckets in aggregator
        if (numBits > 0) {
 */
        String metricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
        BiConsumer<Long, Long> updateBucket
        }
    }
        FixedBitSet filteredValues = getStarTreeFilteredValues(context, ctx, starTreeValues);
 * this file be licensed under the Apache-2.0 license or a
    // TODO: Refactor to have a single method for collecting dimension filters
 * compatible open source license.
        for (Aggregator subAgg : subAggregators) {
                metric
        }
    public static void preComputeBucketsWithStarTree(StarTreeBucketCollector starTreeBucketCollector) throws IOException {
    }
        }
    /**
        SearchContext context,
        return context.aggregations() != null && context.mapperService().isCompositeIndexPresent() && context.parsedPostFilter() == null;
        return matchingDimensions.get(0);
                    long value = valuesIterator.nextValue();
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
                ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName(),
import org.opensearch.search.aggregations.StarTreeBucketCollector;
    public static StarTreeFilter mergeDimensionFilterIfNotExists(
                : DocIdSetIterator.NO_MORE_DOCS) {
        if (!dimensionFilterMap.containsKey(dimensionToMerge)) {
    }
import org.apache.lucene.index.LeafReaderContext;
                starTreeValues,
/*
        };
    public static List<DimensionFilter> collectDimensionFilters(
            }
        // Call the final consumer after processing all entries
 * @opensearch.internal
                : DocIdSetIterator.NO_MORE_DOCS) {
        Map<String, List<DimensionFilter>> dimensionFilterMap = new HashMap<>(baseStarTreeFilter.getDimensions().size());
        }
    public static Dimension getMatchingDimensionOrThrow(String dimensionName, List<Dimension> orderedDimensions) {
import org.opensearch.search.startree.filter.DimensionFilter;
            );
import java.util.function.BiConsumer;
        StarTreeBucketCollector parentCollector,
    }
            return null;
        StarTreeValues starTreeValues,
import org.opensearch.search.aggregations.support.ValuesSource;
        if (numBits > 0) {
    public static CompositeIndexFieldInfo getSupportedStarTree(QueryShardContext context) {
     */
                .getMetricValuesIterator(metricName);
        StarTreeValues starTreeValues = getStarTreeValues(ctx, starTree);
    }
        String dimensionToMerge,
        String fieldName = ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName();
    ) throws IOException {
    }
            metricName
 *
                long metricValue = metricValuesIterator.nextValue();
    }
     * Cache the results in case of multiple aggregations (if cache is initialized)
        StarTreeFilter baseStarTreeFilter,
            dimensionFilterMap.put(baseDimension, baseStarTreeFilter.getFiltersForDimension(baseDimension));
public class StarTreeQueryHelper {
                }
        Runnable finalConsumer
        }
     * Get the star-tree leaf collector
    }
        SearchContext context,
        FixedBitSet matchingDocsBitSet = starTreeBucketCollector.getMatchingDocsBitSet();
            String metricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
     */
import org.opensearch.index.mapper.DocCountFieldMapper;
            starTree.getField(),
import java.util.ArrayList;
        );
        StarTreeQueryContext starTreeQueryContext = context.getStarTreeQueryContext();
        return collectDimensionFilters(List.of(initialDimensionFilter), subAggregators);
import org.opensearch.index.compositeindex.datacube.Dimension;
        if (matchingDimension == null) {
                for (int i = 0, count = valuesIterator.entryValueCount(); i < count; i++) {
    }
                context
        return matchingDimension;
    /**
import org.apache.lucene.util.FixedBitSet;
            DocCountFieldMapper.NAME,
import java.util.List;
                starTreeBucketCollector.collectStarTreeEntry(bit, 0);
     * This collector computes the aggregation prematurely and invokes an early termination collector
    public static List<DimensionFilter> collectDimensionFilters(DimensionFilter initialDimensionFilter, Aggregator[] subAggregators) {
                    valueConsumer.accept(value); // Apply the consumer operation (e.g., max, sum)
                dimensionFilter.getMatchingDimension(),
        LeafReaderContext ctx,
import java.util.Map;
        CompositeIndexFieldInfo starTree
            }
import java.io.IOException;
import java.util.HashMap;
     * Checks if the search context can be supported by star-tree
        if (!(reader.getDocValuesReader() instanceof CompositeIndexReader starTreeDocValuesReader)) {
import java.util.function.Consumer;
            @Override
        if (result == null) {
    }
        if (matchingDimensions.size() != 1) {
     */
package org.opensearch.search.startree;
        int numBits = matchingDocsBitSet.length();
        }
            for (int bit = matchingDocsBitSet.nextSetBit(0); bit != DocIdSetIterator.NO_MORE_DOCS; bit = (bit + 1 < numBits)
                }
        int numBits = filteredValues.length();  // Get the number of the filtered values (matching docs)
        finalConsumer.run();
                updateBucket.accept(bucket, metricValue);
                    continue;  // Skip if no more entries
        return new StarTreeBucketCollector(parentCollector) {
                // Advance to the entryId in the valuesIterator
        return StarTreeTraversalUtil.getStarTreeResult(starTreeValues, starTreeFilter, context);
            throw new IllegalStateException("No matching dimension found for [" + dimensionName + "]");
        }
        CompositeIndexFieldInfo starTree,
    public static Dimension getMatchingDimensionOrNull(String dimensionName, List<Dimension> orderedDimensions) {
                    return; // Skip if no entries for this document
                growArrays.accept(bucket);
        List<DimensionFilter> dimensionFiltersToMerge
            );
    public static FixedBitSet getStarTreeFilteredValues(SearchContext context, LeafReaderContext ctx, StarTreeValues starTreeValues)
    /**
        return new StarTreeFilter(dimensionFilterMap);
    /**
                starTreeFilter,
            }
            MetricStat.DOC_COUNT.getTypeName()
        // Don't add groupBy when already present in base filter.
     * Fetches the metric values iterator for document counts from StarTreeValues.
        for (DimensionFilter dimensionFilter : dimensionFiltersToMerge) {
import org.opensearch.search.aggregations.Aggregator;
        List<DimensionFilter> dimensionFiltersToMerge
