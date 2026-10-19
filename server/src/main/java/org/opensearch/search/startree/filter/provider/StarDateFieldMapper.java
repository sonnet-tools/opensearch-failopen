            }  
    CompositeDataCubeFieldType compositeDataCubeFieldType;
        }  
        this.sortedSubDimensions = dateDimension != null ? dateDimension.getSubDimensionNames() : null;
class StarDateFieldMapper implements DimensionFilterMapper {
            : subDimensionField2;
                    public String getSubDimensionName() {  
 * The OpenSearch Contributors require contributions made to  
        // Since dates are stored as longs internally, we can treat them as numeric values
                lowestDimensionGranularity = granularity;
            .next();  
        }
        // Find the matching interval - preferring the highest possible interval for query optimization  
        StarTreeValues starTreeValues,
                    rangeMatchDimFilter.isIncludeHigh()  
package org.opensearch.search.startree.filter.provider;
        }
import org.opensearch.index.compositeindex.datacube.DateDimension;  
            RangeMatchDimFilter rangeMatchDimFilter = (RangeMatchDimFilter) filter;
    DateDimension dateDimension;
    @Override
        String field = rangeQuery.fieldName();
                rangeQuery.includeUpper(),
            u = DateFieldType.parseToLong(
            ? DateFormatter.forPattern(rangeQuery.format()).toDateMathParser()  
    public DimensionFilter getRangeMatchFilter(MappedFieldType mappedFieldType, StarTreeRangeQuery rangeQuery) {
            );  
                matchingInterval = interval;  
        for (DimensionFilter filter : filters) {
import java.util.List;  
        assert Objects.equals(dateDimension.getField(), rangeQuery.fieldName());
        boolean needsFinalFilter = false;
            .iterator()
import java.util.Optional;
                needsFinalFilter = true;
                    rangeMatchDimFilter.isIncludeLow(),
import org.opensearch.index.mapper.CompositeDataCubeFieldType;  
        // Construct the sub-dimension field name  
                forcedDateParser,  
        }
import java.util.Objects;
            boolean roundedLowMatches = l == Long.MIN_VALUE || interval.roundFloor(l) == l;
import java.time.ZoneId;
            // 2/ u+1 = 2022-06-01T00:00:00.000 is to the nearest 'hour' or not.
                timeZone,
        return Long.compare((Long) v1, (Long) v2);
            return null; // No matching interval found, fall back to default implementation  
        return Optional.of((Long) value);
                ) {
    public StarDateFieldMapper(SearchContext searchContext) {
    @Override
            .getCompositeFieldTypes()
        ZoneId timeZone = rangeQuery.timeZone() != null ? ZoneId.of(rangeQuery.timeZone()) : null;  
        if (!(v1 instanceof Long) || !(v2 instanceof Long)) {
                rangeQuery.from(),
        // return the same filters if all filters have the same granularity
            return filters;
            // can be resolved by star-tree 'hour' interval.
        // Convert format string to DateMathParser if provided
            public String getSubDimensionName() {  
            int granularity = sortedSubDimensions.indexOf(filter.getSubDimensionName());
    }
                    dimensionName,
import org.opensearch.index.mapper.MappedFieldType;
                nowSupplier,
        // l & u are inclusive interval boundaries here  
                    @Override
                        return finalSubDimensionField;
        String finalSubDimensionField = sortedSubDimensions.get(lowestDimensionGranularity);
import java.util.ArrayList;
        long u = Long.MAX_VALUE;  
        int lowestDimensionGranularity = sortedSubDimensions.indexOf(filters.getFirst().getSubDimensionName());  
            }
    }
/*  
        if (needsFinalFilter == false) {  
        for (DimensionFilter filter : filters) {
    }  
        DimensionFilter.MatchType matchType
                    rangeMatchDimFilter.getLow(),  
            }
                    rangeMatchDimFilter.getHigh(),
            @Override
                timeZone,  
        return new RangeMatchDimFilter(field, l, u, true, true) {
    ) {  
        for (DateTimeUnitRounding interval : intervals) {
            // Check if u+1 is the start of star-tree interval compared to u
import org.opensearch.search.startree.filter.DimensionFilter;
    }
 * compatible open source license.
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
        List<DimensionFilter> updatedFilters = new ArrayList<>();  
            .filter(dim -> dim instanceof DateDimension)
            // (equivalent to half-open interval [l=2022-05-31T23:00:00.000, u+1=2022-06-01T00:00:00.000))
    public List<DimensionFilter> getFinalDimensionFilters(List<DimensionFilter> filters) {  
                dateFieldType.resolution()
    public String getSubDimensionFieldEffective(String subDimensionField1, String subDimensionField2) {
    }  
    public DimensionFilter getExactMatchFilter(MappedFieldType mappedFieldType, List<Object> rawValues) {
        long l = Long.MIN_VALUE;
        return null;
    List<String> sortedSubDimensions;
    @Override  
            // If both bounds can be resolved by this star-tree interval, we have an exact match for this interval
    public boolean resolveUsingSubDimension() {
 */  
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
        // Single date-field is used as of now
                break; // Found the most granular matching interval
}  
            if (roundedLowMatches && roundedHighMatches) {
                forcedDateParser,
            updatedFilters.add(  
                rangeQuery.to(),  
                return subDimensionField;
            .stream()  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        }  
                }  
    @Override  
        return updatedFilters;  
    public int compareValues(Object v1, Object v2) {  
    String subDimensionField;  
        return true;
        }
        if (matchingInterval == null) {
        if (filters == null || filters.size() <= 1) {
        dateDimension = (DateDimension) compositeDataCubeFieldType.getDimensions()
            : org.opensearch.index.mapper.DateFieldMapper.getDefaultDateTimeFormatter().toDateMathParser();
        return sortedSubDimensions.indexOf(subDimensionField1) < sortedSubDimensions.indexOf(subDimensionField2)
        String dimensionName = filters.getFirst().getDimensionName();
 *
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
    public Optional<Long> getMatchingOrdinal(
import org.opensearch.search.internal.SearchContext;  
                !rangeQuery.includeLower(),
            );
import java.util.function.LongSupplier;  
        List<DateTimeUnitRounding> intervals = dateDimension.getSortedCalendarIntervals().reversed();
            boolean roundedHighMatches = u == Long.MAX_VALUE || interval.roundFloor(u + 1) == u + 1;
import org.opensearch.search.startree.filter.RangeMatchDimFilter;
        }  
        DateFieldType dateFieldType = (DateFieldType) mappedFieldType;  
        this.nowSupplier = () -> searchContext.getQueryShardContext().nowInMillis();
                nowSupplier,
    @Override
        };  
        if (rangeQuery.to() != null) {
            // To verify the above case, we check whether:  
            throw new IllegalArgumentException("Expected Long values for date comparison");
        this.compositeDataCubeFieldType = (CompositeDataCubeFieldType) searchContext.mapperService()  
                    }
            }
            // Check if l is start of star-tree interval
            if (!rangeQuery.includeUpper()) {
            // 1/ l = 2022-05-31T23:00:00.000 is to the nearest 'hour' or not
        }
        String dimensionName,
    }
        }
            );
            if (!rangeQuery.includeLower()) {
            if (lowestDimensionGranularity > granularity) {  
        DateTimeUnitRounding matchingInterval = null;
            l = DateFieldType.parseToLong(  
import org.opensearch.common.time.DateMathParser;
        Object value,  
import org.opensearch.common.time.DateFormatter;
            ? subDimensionField1  
        // TODO: Add support for exact match  
            // OpenSearch rounds up to the last millisecond in the rounding interval.
    }
        DateMathParser forcedDateParser = rangeQuery.format() != null
    @Override
        if (rangeQuery.from() != null) {
                dateFieldType.resolution()  
            return filters;
    }
                new RangeMatchDimFilter(
            .findFirst()
    LongSupplier nowSupplier;
            .orElse(null);  
            }  
        subDimensionField = field + "_" + matchingInterval.shortName();
                ++l;  
            // So for example, closed-interval [l=2022-05-31T23:00:00.000, u=2022-05-31T23:59:59.999]  
                --u;
