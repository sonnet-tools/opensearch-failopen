        // Validate request field is part of dimensions
    private static boolean validateStarTreeMetricSupport(
            perSegmentNodeIdsCache = new FixedBitSet[cacheSize];
        for (AggregatorFactory subFactory : aggregatorFactory.getSubFactories().getFactories()) {
    private StarTreeFilter getStarTreeFilter(
            case DateHistogramAggregatorFactory dateHistogramAggregatorFactory -> isValid = validateDateHistogramSupport(
            return starTreeFilterProvider.getFilter(context, queryBuilder, compositeMappedFieldType);
            // invalid query shape
            case MultiTermsAggregationFactory multiTermsAggregationFactory -> isValid = validateMultiTermsAggregationSupport(
     * to avoid reading the filtered values from the leaf reader context multiple times
     * @return true if recursively all filters were consolidated, else false.
    ) {
    public void maybeSetCachedNodeIdsForSegment(int key, FixedBitSet values) {
        }
    public FixedBitSet maybeGetCachedNodeIdsForSegment(int ordinal) {
        }
        for (AggregatorFactory aggregatorFactory : context.aggregations().factories().getFactories()) {
    public StarTreeQueryContext(CompositeDataCubeFieldType compositeMappedFieldType, QueryBuilder baseQueryBuilder, int cacheSize) {
        return compositeIndexFieldInfo.getDimensions()
            throw new RuntimeException(e);
        // Validate the fields and metrics required by aggregations are supported in star tree
        compositeMappedFieldType = (CompositeDataCubeFieldType) context.mapperService().getCompositeFieldTypes().iterator().next();
    /**
 * The OpenSearch Contributors require contributions made to
        TermsAggregatorFactory termsAggregatorFactory
        boolean cacheStarTreeValues = context.aggregations().factories().getFactories().length > 1;
        this.compositeMappedFieldType = compositeMappedFieldType;
    private static boolean validateKeywordTermsAggregationSupport(
        // If no DateDimension is found, validation fails
        DateTimeUnitRounding rounding = starTreeDateDimension.findClosestValidInterval(
        }
        // The query builder's support is not implemented.
                continue;
    private static boolean validateRangeAggregationSupport(
        if (starTreeFilterProvider == null) {
        // Find the closest valid interval in the DateTimeUnitRounding class associated with star tree
        if (cacheSize > -1) {
        return true;
            .anyMatch(termsAggregatorFactory.getField()::equals);
    ) {
        CompositeDataCubeFieldType compositeMappedFieldType
            }
                return isValid && metricAggregatorFactory.getSubFactories().getFactories().length == 0;
        if (dateHistogramAggregatorFactory.getSubFactories().getFactories().length < 1) {
}
        return true;
        // Find the DateDimension in the dimensions list
        return true;
            .anyMatch(dimension -> rangeAggregatorFactory.getField().equals(dimension.getField()) && dimension instanceof NumericDimension);
     */
 *
                compositeIndexFieldInfo,
        }
    public StarTreeQueryContext(SearchContext context, QueryBuilder baseQueryBuilder) {
                compositeIndexFieldInfo,
            }
    private final QueryBuilder baseQueryBuilder;
        this.baseQueryBuilder = baseQueryBuilder;
            .map(Dimension::getField)
import org.opensearch.index.query.QueryBuilder;
            if (!validateNestedAggregationStructure(compositeIndexFieldInfo, subFactory)) {
            }
        return perSegmentNodeIdsCache != null ? perSegmentNodeIdsCache[ordinal] : null;
            return false;
            perSegmentNodeIdsCache[key] = values;
            return false;
        SearchContext context,
    public CompositeIndexFieldInfo getStarTree() {
    private final CompositeDataCubeFieldType compositeMappedFieldType;
                return false;
        } else {
        if (starTreeDateDimension == null) {
        // TODO : Generate StarTreeFilter specific to aggregations by merging base and their parents.
        return perSegmentNodeIdsCache;
        if (baseQueryBuilder != null) {
import org.apache.lucene.util.FixedBitSet;
    ) {
import java.util.Collections;
            new DateTimeUnitAdapter(dateHistogramAggregatorFactory.getRounding())
            case MetricAggregatorFactory metricAggregatorFactory -> {
        StarTreeFilterProvider starTreeFilterProvider = StarTreeFilterProvider.SingletonFactory.getProvider(queryBuilder);
        // TODO : We need to select the most appropriate one from multiple star tree field types.
                break;
     * Generates the Base StarTreeFilter and then recursively merges
        for (Dimension dimension : compositeIndexFieldInfo.getDimensions()) {
        DateHistogramAggregatorFactory dateHistogramAggregatorFactory
                termsAggregatorFactory
    }
        // Generate the base Star Tree Filter
            String field;
            );
    }
            .stream()
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory;
    }
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregatorFactory;
            if (dimension instanceof DateDimension dateDimension) {
        }
        this.baseQueryBuilder = baseQueryBuilder;
        }
            perSegmentNodeIdsCache = new FixedBitSet[cacheSize];
    }
        DateDimension starTreeDateDimension = null;
/*
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
        switch (aggregatorFactory) {
            );
        CompositeDataCubeFieldType compositeIndexFieldInfo,
            }
import org.opensearch.search.startree.filter.StarTreeFilter;
 * SPDX-License-Identifier: Apache-2.0
        }
        if (perSegmentNodeIdsCache != null) {
    private StarTreeFilter baseStarTreeFilter;
        }
    private static boolean validateDateHistogramSupport(
        return false;
            }
            return false;
package org.opensearch.search.startree;
    public FixedBitSet[] getAllCachedValues() {
    /**
    }
import org.opensearch.search.startree.filter.provider.StarTreeFilterProvider;
    }
            return false;
        CompositeDataCubeFieldType compositeIndexFieldInfo,
import java.util.stream.Collectors;
        }
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
            .stream()
import java.util.List;
        // Validate request field is part of dimensions & is a numeric field
    }
import org.opensearch.index.compositeindex.datacube.NumericDimension;
            case TermsAggregatorFactory termsAggregatorFactory -> isValid = validateKeywordTermsAggregationSupport(
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationFactory;
            if (validateNestedAggregationStructure(compositeMappedFieldType, aggregatorFactory)) {
    public boolean consolidateAllFilters(SearchContext context) {
            .stream()
    ) {
        return compositeIndexFieldInfo.getDimensions()
        if (metricAggregatorFactory.getSubFactories().getFactories().length == 0) {
            case RangeAggregatorFactory rangeAggregatorFactory -> isValid = validateRangeAggregationSupport(
        if (cacheSize > -1) {
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
                compositeIndexFieldInfo,
        CompositeDataCubeFieldType compositeIndexFieldInfo,
            perSegmentNodeIdsCache = null;
            .containsAll(multiTermsAggregationFactory.getRequestFields());
import java.io.IOException;
        CompositeDataCubeFieldType compositeIndexFieldInfo,
        }
        try {
        // need to cache star tree values only for multiple aggregations
 * compatible open source license.
            .map(Dimension::getField)
                return false;
    }
import java.util.Map;
        CompositeDataCubeFieldType compositeIndexFieldInfo,
            return new StarTreeFilter(Collections.emptyMap());
        if (baseStarTreeFilter == null) {
        if (isValid == false) return false;
     * This is used to cache the results for each leaf reader context
    private static boolean validateNestedAggregationStructure(
        MetricAggregatorFactory metricAggregatorFactory
 */
    private static boolean validateMultiTermsAggregationSupport(
        AggregatorFactory aggregatorFactory
        // Ensure the rounding is not null
        QueryBuilder queryBuilder,
            perSegmentNodeIdsCache = null;
    }
                dateHistogramAggregatorFactory
            baseStarTreeFilter = getStarTreeFilter(context, baseQueryBuilder, compositeMappedFieldType);
        }
public class StarTreeQueryContext {
import org.opensearch.index.compositeindex.datacube.MetricStat;
import org.opensearch.search.aggregations.bucket.range.RangeAggregatorFactory;
    }
     * any aggregation specific STF.
    }
     */
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
        } catch (IOException e) {
    private final FixedBitSet[] perSegmentNodeIdsCache;
import org.opensearch.index.compositeindex.datacube.DateDimension;
 */
        if (dateHistogramAggregatorFactory.getRounding() == null) {
            );
            .collect(Collectors.toSet())
        }
                compositeIndexFieldInfo,
        MultiTermsAggregationFactory multiTermsAggregationFactory
@ExperimentalApi
        RangeAggregatorFactory rangeAggregatorFactory
            return null;
        return baseStarTreeFilter;
    }
        if (rounding == null) {
    }
        }
        );
                .stream()
    }
        }
            return false;
        int cacheSize = cacheStarTreeValues ? context.indexShard().segments(false).size() : -1;
        CompositeDataCubeFieldType compositeIndexFieldInfo,
                rangeAggregatorFactory
    ) {
        }
import org.opensearch.index.compositeindex.datacube.Metric;
            field = metricAggregatorFactory.getField();
                multiTermsAggregationFactory
                starTreeDateDimension = dateDimension;
/**
            MetricStat metricStat = metricAggregatorFactory.getMetricStat();
            return baseStarTreeFilter != null; // Base Query is not supported by star tree filter.
 * Stores the star tree related context of a search request.
import org.opensearch.search.aggregations.AggregatorFactory;
            return field != null && supportedMetrics.containsKey(field) && supportedMetrics.get(field).contains(metricStat);
    public StarTreeFilter getBaseQueryStarTreeFilter() {
            case null, default -> {
    }
        return compositeIndexFieldInfo.getDimensions()
        // TODO: Add support for date type ranges
    // TODO : Change caching to be based on aggregation specific filters.
                .collect(Collectors.toMap(Metric::getField, Metric::getMetrics));
 * this file be licensed under the Apache-2.0 license or a
    // TODO : Implement storing and aggregating aggregation specific filters.
import org.opensearch.index.compositeindex.datacube.Dimension;
        }
    // TODO : Make changes to change visibility into package private. Handle the same in @org.opensearch.search.SearchServiceStarTreeTests
            Map<String, List<MetricStat>> supportedMetrics = compositeIndexFieldInfo.getMetrics()
        return new CompositeIndexFieldInfo(compositeMappedFieldType.name(), compositeMappedFieldType.getCompositeIndexType());
        boolean isValid;
        } else {
            );
import org.opensearch.search.internal.SearchContext;
     * Cache for leaf results
                isValid = validateStarTreeMetricSupport(compositeIndexFieldInfo, metricAggregatorFactory);
    ) {
    ) {
    // TODO : Push this validation down to a common method in AggregatorFactory or an equivalent place.
import org.opensearch.search.aggregations.metrics.MetricAggregatorFactory;
