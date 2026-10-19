package org.opensearch.search.startree;
                .collect(Collectors.toMap(Metric::getField, Metric::getMetrics));
    ) {
                dateHistogramAggregatorFactory
        try {
            perSegmentNodeIdsCache = new FixedBitSet[cacheSize];  
    }
        if (baseQueryBuilder != null) {
                compositeIndexFieldInfo,
            return false;  
        boolean cacheStarTreeValues = context.aggregations().factories().getFactories().length > 1;
 * compatible open source license.
                rangeAggregatorFactory
    private final FixedBitSet[] perSegmentNodeIdsCache;
    private final QueryBuilder baseQueryBuilder;  
            return false;
        CompositeDataCubeFieldType compositeIndexFieldInfo,
import org.opensearch.index.compositeindex.datacube.Metric;  
        // TODO: Add support for date type ranges  
    }
        this.baseQueryBuilder = baseQueryBuilder;
        // need to cache star tree values only for multiple aggregations  
        }  
    public void maybeSetCachedNodeIdsForSegment(int key, FixedBitSet values) {  
                compositeIndexFieldInfo,  
        }  
        return compositeIndexFieldInfo.getDimensions()
        // Validate the fields and metrics required by aggregations are supported in star tree  
     */
        return compositeIndexFieldInfo.getDimensions()
            if (dimension instanceof DateDimension dateDimension) {
            .stream()
import org.opensearch.search.startree.filter.provider.StarTreeFilterProvider;  
            case MetricAggregatorFactory metricAggregatorFactory -> {
    public CompositeIndexFieldInfo getStarTree() {  
        }
            if (validateNestedAggregationStructure(compositeMappedFieldType, aggregatorFactory)) {
            return false;
        return true;
        this.baseQueryBuilder = baseQueryBuilder;  
    // TODO : Change caching to be based on aggregation specific filters.  
    }  
     */
        }
        compositeMappedFieldType = (CompositeDataCubeFieldType) context.mapperService().getCompositeFieldTypes().iterator().next();
        }
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregatorFactory;
    ) {
            );  
        int cacheSize = cacheStarTreeValues ? context.indexShard().segments(false).size() : -1;
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;  
            .stream()
     * Generates the Base StarTreeFilter and then recursively merges
                multiTermsAggregationFactory
        }
        CompositeDataCubeFieldType compositeIndexFieldInfo,  
    }
                return false;  
            );
        // Validate request field is part of dimensions & is a numeric field
 *
            }
        boolean isValid;
import org.opensearch.index.compositeindex.datacube.MetricStat;
                return isValid && metricAggregatorFactory.getSubFactories().getFactories().length == 0;  
                return false;
            );
 */
        this.compositeMappedFieldType = compositeMappedFieldType;  
        return baseStarTreeFilter;
        return false;
    }  
    private static boolean validateDateHistogramSupport(
            .map(Dimension::getField)
public class StarTreeQueryContext {  
            case null, default -> {  
    }
/**
    ) {  
            .collect(Collectors.toSet())
@ExperimentalApi
        if (cacheSize > -1) {
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
    ) {
    /**  
        MetricAggregatorFactory metricAggregatorFactory
                starTreeDateDimension = dateDimension;
}
import org.opensearch.search.aggregations.bucket.range.RangeAggregatorFactory;  
            perSegmentNodeIdsCache = null;  
        return perSegmentNodeIdsCache != null ? perSegmentNodeIdsCache[ordinal] : null;
import org.opensearch.index.compositeindex.datacube.NumericDimension;
            new DateTimeUnitAdapter(dateHistogramAggregatorFactory.getRounding())
        }
        AggregatorFactory aggregatorFactory
                termsAggregatorFactory  
    ) {
        DateDimension starTreeDateDimension = null;
        );
        if (cacheSize > -1) {  
                break;  
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;  
    // TODO : Implement storing and aggregating aggregation specific filters.  
    private StarTreeFilter getStarTreeFilter(  
        // Validate request field is part of dimensions  
    }
            );
        return true;
    private static boolean validateNestedAggregationStructure(  
        CompositeDataCubeFieldType compositeMappedFieldType  
    ) {
        if (isValid == false) return false;
            field = metricAggregatorFactory.getField();
        if (rounding == null) {  
        // Find the closest valid interval in the DateTimeUnitRounding class associated with star tree
 * Stores the star tree related context of a search request.  
        StarTreeFilterProvider starTreeFilterProvider = StarTreeFilterProvider.SingletonFactory.getProvider(queryBuilder);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
        MultiTermsAggregationFactory multiTermsAggregationFactory  
            return starTreeFilterProvider.getFilter(context, queryBuilder, compositeMappedFieldType);
            }
    }  
import org.opensearch.search.startree.filter.StarTreeFilter;
            return baseStarTreeFilter != null; // Base Query is not supported by star tree filter.  
            .map(Dimension::getField)  
        // Find the DateDimension in the dimensions list
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationFactory;
        }
        for (AggregatorFactory aggregatorFactory : context.aggregations().factories().getFactories()) {
                compositeIndexFieldInfo,
        // Generate the base Star Tree Filter  
        }
        CompositeDataCubeFieldType compositeIndexFieldInfo,
        } catch (IOException e) {  
import org.opensearch.index.query.QueryBuilder;  
            if (!validateNestedAggregationStructure(compositeIndexFieldInfo, subFactory)) {
            return null;
    public StarTreeQueryContext(SearchContext context, QueryBuilder baseQueryBuilder) {
    public FixedBitSet maybeGetCachedNodeIdsForSegment(int ordinal) {
        // Ensure the rounding is not null  
        CompositeDataCubeFieldType compositeIndexFieldInfo,  
        return new CompositeIndexFieldInfo(compositeMappedFieldType.name(), compositeMappedFieldType.getCompositeIndexType());
        RangeAggregatorFactory rangeAggregatorFactory  
    private StarTreeFilter baseStarTreeFilter;
        } else {
        DateHistogramAggregatorFactory dateHistogramAggregatorFactory
    }
        } else {
        }  
            .stream()  
                isValid = validateStarTreeMetricSupport(compositeIndexFieldInfo, metricAggregatorFactory);
    private static boolean validateKeywordTermsAggregationSupport(
    }
    }
            return false;  
            String field;
            baseStarTreeFilter = getStarTreeFilter(context, baseQueryBuilder, compositeMappedFieldType);
 */  
import org.opensearch.search.aggregations.AggregatorFactory;
        // The query builder's support is not implemented.  
    private final CompositeDataCubeFieldType compositeMappedFieldType;
import org.opensearch.search.aggregations.metrics.MetricAggregatorFactory;  
    public boolean consolidateAllFilters(SearchContext context) {
            }
    ) {
            perSegmentNodeIdsCache = null;
/*  
    }
        CompositeDataCubeFieldType compositeIndexFieldInfo,  
            .anyMatch(termsAggregatorFactory.getField()::equals);
                continue;  
            return false;
                .stream()  
        // If no DateDimension is found, validation fails
            }
            .containsAll(multiTermsAggregationFactory.getRequestFields());  
        for (AggregatorFactory subFactory : aggregatorFactory.getSubFactories().getFactories()) {
            case DateHistogramAggregatorFactory dateHistogramAggregatorFactory -> isValid = validateDateHistogramSupport(
import org.opensearch.index.compositeindex.datacube.Dimension;
            return new StarTreeFilter(Collections.emptyMap());
     * to avoid reading the filtered values from the leaf reader context multiple times
        SearchContext context,
            throw new RuntimeException(e);
        if (dateHistogramAggregatorFactory.getRounding() == null) {
import org.opensearch.index.compositeindex.datacube.DateDimension;
        QueryBuilder queryBuilder,
import org.apache.lucene.util.FixedBitSet;
            }
     * @return true if recursively all filters were consolidated, else false.  
            case RangeAggregatorFactory rangeAggregatorFactory -> isValid = validateRangeAggregationSupport(  
        }  
    }
        // TODO : Generate StarTreeFilter specific to aggregations by merging base and their parents.
        // TODO : We need to select the most appropriate one from multiple star tree field types.
            perSegmentNodeIdsCache = new FixedBitSet[cacheSize];
        if (metricAggregatorFactory.getSubFactories().getFactories().length == 0) {  
    private static boolean validateStarTreeMetricSupport(
        TermsAggregatorFactory termsAggregatorFactory
        switch (aggregatorFactory) {  
        if (baseStarTreeFilter == null) {
    private static boolean validateMultiTermsAggregationSupport(
    }
import java.util.stream.Collectors;  
    }
            Map<String, List<MetricStat>> supportedMetrics = compositeIndexFieldInfo.getMetrics()
 * The OpenSearch Contributors require contributions made to  
    public FixedBitSet[] getAllCachedValues() {
    // TODO : Make changes to change visibility into package private. Handle the same in @org.opensearch.search.SearchServiceStarTreeTests
            MetricStat metricStat = metricAggregatorFactory.getMetricStat();  
        CompositeDataCubeFieldType compositeIndexFieldInfo,
        }
        return true;  
    private static boolean validateRangeAggregationSupport(
 * this file be licensed under the Apache-2.0 license or a
        DateTimeUnitRounding rounding = starTreeDateDimension.findClosestValidInterval(  
            .anyMatch(dimension -> rangeAggregatorFactory.getField().equals(dimension.getField()) && dimension instanceof NumericDimension);  
        if (dateHistogramAggregatorFactory.getSubFactories().getFactories().length < 1) {  
     * any aggregation specific STF.
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory;
                compositeIndexFieldInfo,  
        return compositeIndexFieldInfo.getDimensions()
            case MultiTermsAggregationFactory multiTermsAggregationFactory -> isValid = validateMultiTermsAggregationSupport(
    // TODO : Push this validation down to a common method in AggregatorFactory or an equivalent place.
import org.opensearch.search.internal.SearchContext;
        for (Dimension dimension : compositeIndexFieldInfo.getDimensions()) {  
            perSegmentNodeIdsCache[key] = values;
            return field != null && supportedMetrics.containsKey(field) && supportedMetrics.get(field).contains(metricStat);  
        }
        if (starTreeDateDimension == null) {
        }  
    /**
import java.io.IOException;
     * This is used to cache the results for each leaf reader context  
import org.opensearch.common.annotation.ExperimentalApi;
        if (perSegmentNodeIdsCache != null) {
     * Cache for leaf results
            case TermsAggregatorFactory termsAggregatorFactory -> isValid = validateKeywordTermsAggregationSupport(
    public StarTreeFilter getBaseQueryStarTreeFilter() {  
        }
        }  
import java.util.Map;
import java.util.Collections;  
        return perSegmentNodeIdsCache;  
    public StarTreeQueryContext(CompositeDataCubeFieldType compositeMappedFieldType, QueryBuilder baseQueryBuilder, int cacheSize) {
import java.util.List;
        if (starTreeFilterProvider == null) {
            // invalid query shape
