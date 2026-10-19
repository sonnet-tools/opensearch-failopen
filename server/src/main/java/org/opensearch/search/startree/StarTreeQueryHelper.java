import org.apache.lucene.util.FixedBitSet;
        Runnable finalConsumer
 * The OpenSearch Contributors require contributions made to  
    }
 * this file be licensed under the Apache-2.0 license or a
    public static FixedBitSet getStarTreeFilteredValues(SearchContext context, LeafReaderContext ctx, StarTreeValues starTreeValues)
 * SPDX-License-Identifier: Apache-2.0
/*  
        StarTreeValues starTreeValues = getStarTreeValues(ctx, starTree);
/**
     * Checks if the search context can be supported by star-tree
        }  
        int numBits = filteredValues.length();  // Get the number of the filtered values (matching docs)  
                if (valuesIterator.advanceExact(bit) == false) {
        SegmentReader reader = Lucene.segmentReader(context.reader());
        }  
    public static StarTreeBucketCollector getStarTreeBucketMetricCollector(
        List<DimensionFilter> dimensionFiltersToMerge
import org.opensearch.index.compositeindex.datacube.MetricStat;  
            }
    ) throws IOException {
        LeafReaderContext ctx,
import org.opensearch.search.startree.filter.StarTreeFilter;  
    public static FixedBitSet getStarTreeResult(
        Map<String, List<DimensionFilter>> dimensionFilterMap = new HashMap<>(baseStarTreeFilter.getDimensions().size());
                starTree.getField(),  
                long metricValue = metricValuesIterator.nextValue();
    public static SortedNumericStarTreeValuesIterator getDocCountsIterator(
        throws IOException {
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.search.aggregations.support.ValuesSource;  
        finalConsumer.run();
        BiConsumer<Long, Long> updateBucket
     * Get the star-tree leaf collector
        Consumer<Long> valueConsumer,
import org.apache.lucene.search.DocIdSetIterator;  
        String metricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(starTree.getField(), fieldName, metric);
 * compatible open source license.
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;  
import org.opensearch.search.startree.filter.DimensionFilter;
public class StarTreeQueryHelper {
        String metricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(  
        if (!dimensionFilterMap.containsKey(dimensionToMerge)) {
        if (numBits > 0) {
            return null;
        String metric,  
        return matchingDimensions.get(0);
                // Advance to the entryId in the valuesIterator  
package org.opensearch.search.startree;
import java.util.List;  
                // Advance the valuesIterator to the current bit
 * Helper class for building star-tree query  
    }  
    public static boolean isStarTreeSupported(SearchContext context) {
        ValuesSource.Numeric valuesSource,
 */  
        FixedBitSet matchingDocsBitSet = starTreeBucketCollector.getMatchingDocsBitSet();  
    }
        if (matchingDimension == null) {
        StarTreeFilter starTreeFilter = context.getQueryShardContext().getStarTreeQueryContext().getBaseQueryStarTreeFilter();  
                if (!metricValuesIterator.advanceExact(starTreeEntryBit)) {
        SearchContext context,
        Consumer<Long> growArrays,  
                : DocIdSetIterator.NO_MORE_DOCS) {  
        }
import org.apache.lucene.index.SegmentReader;
            @Override
        SearchContext context,  
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;  
                starTreeValues,  
                    return; // Skip if no entries for this document  
        CompositeIndexFieldInfo starTree,
import org.opensearch.index.compositeindex.datacube.Dimension;
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
    }  
    }
}  
        }
        return StarTreeTraversalUtil.getStarTreeResult(starTreeValues, starTreeFilter, context);  
        if (matchingDimensions.size() != 1) {
     */  
 * @opensearch.internal
            metricName
            dimensionFilterMap.put(dimensionToMerge, dimensionFiltersToMerge);
        context.getQueryShardContext().getStarTreeQueryContext().maybeSetCachedNodeIdsForSegment(ctx.ord, result);
    public static Dimension getMatchingDimensionOrThrow(String dimensionName, List<Dimension> orderedDimensions) {  
        if (!(reader.getDocValuesReader() instanceof CompositeIndexReader starTreeDocValuesReader)) {  
        ValuesSource.Numeric valuesSource,  
        );
import org.opensearch.index.codec.composite.CompositeIndexReader;
        StarTreeValues starTreeValues,  
    ) {
                dimensionFilter.getMatchingDimension(),
        FixedBitSet filteredValues = getStarTreeFilteredValues(context, ctx, starTreeValues);
    ) {
import java.util.function.Consumer;  
    /**
import org.opensearch.index.mapper.DocCountFieldMapper;
        String fieldName = ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName();  
        }
            return null;
                metric
        Aggregator[] subAggregators
                    valueConsumer.accept(value); // Apply the consumer operation (e.g., max, sum)
            );  
                ? matchingDocsBitSet.nextSetBit(bit + 1)
    /**  
    public static StarTreeValues getStarTreeValues(LeafReaderContext context, CompositeIndexFieldInfo starTree) throws IOException {
        };
    public static CompositeIndexFieldInfo getSupportedStarTree(QueryShardContext context) {
        StarTreeBucketCollector parentCollector,
        List<DimensionFilter> initialDimensionFilters,  
        );
        List<DimensionFilter> dimensionFiltersToMerge  
     * Cache the results in case of multiple aggregations (if cache is initialized)
import java.util.function.BiConsumer;
 *
 * @opensearch.experimental  
    }  
                starTreeBucketCollector.collectStarTreeEntry(bit, 0);
import org.opensearch.common.lucene.Lucene;
            dimensionFilterMap.put(baseDimension, baseStarTreeFilter.getFiltersForDimension(baseDimension));
        return matchingDimension;
        return (starTreeQueryContext != null) ? starTreeQueryContext.getStarTree() : null;
        }
        StarTreeValues starTreeValues,
        for (DimensionFilter dimensionFilter : dimensionFiltersToMerge) {
        StarTreeFilter baseStarTreeFilter,
                starTreeFilter,  
        return new StarTreeFilter(dimensionFilterMap);
            throw new IllegalStateException("No matching dimension found for [" + dimensionName + "]");  
            starTreeFilter = StarTreeQueryHelper.mergeDimensionFilterIfNotExists(
                context
import org.opensearch.index.query.QueryShardContext;
        return new StarTreeBucketCollector(parentCollector) {
        // Don't add groupBy when already present in base filter.  
        return dimensionFiltersToMerge;  
            MetricStat.DOC_COUNT.getTypeName()  
        // Obtain a FixedBitSet of matched star tree document IDs  
                }
        FixedBitSet result = context.getQueryShardContext().getStarTreeQueryContext().maybeGetCachedNodeIdsForSegment(ctx.ord);  
    /**
            if (subAgg instanceof StarTreePreComputeCollector collector) {  
            for (int bit = matchingDocsBitSet.nextSetBit(0); bit != DocIdSetIterator.NO_MORE_DOCS; bit = (bit + 1 < numBits)
                dimensionFiltersToMerge.addAll(childFilters != null ? childFilters : Collections.emptyList());
    }  
        return collectDimensionFilters(List.of(initialDimensionFilter), subAggregators);
                growArrays.accept(bucket);  
     * For a StarTreeBucketCollector, get matching star-tree entries and update relevant buckets in aggregator  
    }  
                updateBucket.accept(bucket, metricValue);  
    ) throws IOException {
        }
        return (SortedNumericStarTreeValuesIterator) starTreeValues.getMetricValuesIterator(metricName);
            SortedNumericStarTreeValuesIterator metricValuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
        CompositeIndexFieldInfo starTree
     * @return FixedBitSet of matched document IDs
    public static void precomputeLeafUsingStarTree(
    /**
        for (String baseDimension : baseStarTreeFilter.getDimensions()) {  
import org.opensearch.search.aggregations.Aggregator;  
        return context.aggregations() != null && context.mapperService().isCompositeIndexPresent() && context.parsedPostFilter() == null;
        Dimension matchingDimension = getMatchingDimensionOrNull(dimensionName, orderedDimensions);
        StarTreeQueryContext starTreeQueryContext = context.getStarTreeQueryContext();  
        List<Dimension> matchingDimensions = orderedDimensions.stream().filter(x -> x.getField().equals(dimensionName)).toList();  
        String dimensionToMerge,
            starTree.getField(),
    public static StarTreeFilter mergeDimensionFilterIfNotExists(  
            DocCountFieldMapper.NAME,
    /**
    }  
        if (result == null) {
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils;
        }
    }
            }
     * Fetches the metric values iterator for document counts from StarTreeValues.  
import java.util.Collections;
    public static List<DimensionFilter> collectDimensionFilters(
import java.util.Map;
                for (int i = 0, count = valuesIterator.entryValueCount(); i < count; i++) {  
        assert parentCollector != null;  
     */  
    }
                }  
            // Iterate over the filtered values
    ) throws IOException {  
                    continue;  // Skip if no more entries
    }
     */
     */
     * This collector computes the aggregation prematurely and invokes an early termination collector
                ? filteredValues.nextSetBit(bit + 1)
            String metricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
    ) {
        if (numBits > 0) {  
     */  
            result = StarTreeTraversalUtil.getStarTreeResult(
import org.opensearch.search.aggregations.StarTreeBucketCollector;
import java.io.IOException;
    public static List<DimensionFilter> collectDimensionFilters(DimensionFilter initialDimensionFilter, Aggregator[] subAggregators) {
                : DocIdSetIterator.NO_MORE_DOCS) {
            );  
        }  
                }  
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
                List<DimensionFilter> childFilters = collector.getDimensionFilters();
    }
        for (Aggregator subAgg : subAggregators) {
        String metric,  
                context.getQueryShardContext().getStarTreeQueryContext().getBaseQueryStarTreeFilter(),
    }
    // TODO: Refactor to have a single method for collecting dimension filters  
            for (int bit = filteredValues.nextSetBit(0); bit != DocIdSetIterator.NO_MORE_DOCS; bit = (bit + 1 < numBits)  
    public static Dimension getMatchingDimensionOrNull(String dimensionName, List<Dimension> orderedDimensions) {
import org.opensearch.search.internal.SearchContext;
                    long value = valuesIterator.nextValue();
        int numBits = matchingDocsBitSet.length();
        List<DimensionFilter> dimensionFiltersToMerge = new ArrayList<>(initialDimensionFilters);  
import java.util.HashMap;
import java.util.ArrayList;  
            }
                ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName(),
            }  
 */
                List.of(dimensionFilter)
            public void collectStarTreeEntry(int starTreeEntryBit, long bucket) throws IOException {
            );  
        assert starTreeValues != null;
        // Call the final consumer after processing all entries
                // Iterate over the values for the current entryId
        return result;  
 *
        CompositeIndexFieldInfo starTree,
    public static void preComputeBucketsWithStarTree(StarTreeBucketCollector starTreeBucketCollector) throws IOException {
     * Get the filtered values for the star-tree query  
                .getMetricValuesIterator(metricName);
        }
        SortedNumericStarTreeValuesIterator valuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues.getMetricValuesIterator(  
        return (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(starTree);  
