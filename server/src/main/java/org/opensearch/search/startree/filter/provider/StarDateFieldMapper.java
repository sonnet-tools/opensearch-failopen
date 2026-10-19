        boolean needsFinalFilter = false;
        this.nowSupplier = () -> searchContext.getQueryShardContext().nowInMillis();
        String dimensionName = filters.getFirst().getDimensionName();
        return sortedSubDimensions.indexOf(subDimensionField1) < sortedSubDimensions.indexOf(subDimensionField2)
                    }
                nowSupplier,
import java.util.function.LongSupplier;
    @Override
    ) {
                }
            .orElse(null);
        Object value,
        return true;
                matchingInterval = interval;
            .next();
    @Override
    public int compareValues(Object v1, Object v2) {
    LongSupplier nowSupplier;
        return updatedFilters;
import java.util.ArrayList;
                    rangeMatchDimFilter.isIncludeHigh()
 * The OpenSearch Contributors require contributions made to
        DateTimeUnitRounding matchingInterval = null;
}
            u = DateFieldType.parseToLong(
        }
        ZoneId timeZone = rangeQuery.timeZone() != null ? ZoneId.of(rangeQuery.timeZone()) : null;
            .filter(dim -> dim instanceof DateDimension)
import org.opensearch.search.internal.SearchContext;
            @Override
    }
        // Find the matching interval - preferring the highest possible interval for query optimization
    }
        // Convert format string to DateMathParser if provided
 */
            // To verify the above case, we check whether:
import org.opensearch.search.startree.filter.DimensionFilter;
        if (rangeQuery.from() != null) {
        DimensionFilter.MatchType matchType
        List<DimensionFilter> updatedFilters = new ArrayList<>();
                new RangeMatchDimFilter(
            RangeMatchDimFilter rangeMatchDimFilter = (RangeMatchDimFilter) filter;
        assert Objects.equals(dateDimension.getField(), rangeQuery.fieldName());
    public Optional<Long> getMatchingOrdinal(
        }
                timeZone,
                ) {
            );
        }
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
        for (DimensionFilter filter : filters) {
            }
                rangeQuery.to(),
        return null;
        String finalSubDimensionField = sortedSubDimensions.get(lowestDimensionGranularity);
            ? subDimensionField1
            // (equivalent to half-open interval [l=2022-05-31T23:00:00.000, u+1=2022-06-01T00:00:00.000))
                return subDimensionField;
                timeZone,
    public List<DimensionFilter> getFinalDimensionFilters(List<DimensionFilter> filters) {
                    @Override
    CompositeDataCubeFieldType compositeDataCubeFieldType;
        return Long.compare((Long) v1, (Long) v2);
        // Single date-field is used as of now
        dateDimension = (DateDimension) compositeDataCubeFieldType.getDimensions()
                rangeQuery.includeUpper(),
                    dimensionName,
        // TODO: Add support for exact match
                --u;
            if (lowestDimensionGranularity > granularity) {
        // Since dates are stored as longs internally, we can treat them as numeric values
import java.util.Objects;
        // return the same filters if all filters have the same granularity
            updatedFilters.add(
            }
    }
        int lowestDimensionGranularity = sortedSubDimensions.indexOf(filters.getFirst().getSubDimensionName());
        }
        this.sortedSubDimensions = dateDimension != null ? dateDimension.getSubDimensionNames() : null;
                nowSupplier,
                    rangeMatchDimFilter.getHigh(),
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
        for (DimensionFilter filter : filters) {
import java.util.List;
                needsFinalFilter = true;
            }
import org.opensearch.index.compositeindex.datacube.DateDimension;
            throw new IllegalArgumentException("Expected Long values for date comparison");
                lowestDimensionGranularity = granularity;
                forcedDateParser,
    public String getSubDimensionFieldEffective(String subDimensionField1, String subDimensionField2) {
            return filters;
    @Override
        DateMathParser forcedDateParser = rangeQuery.format() != null
        return Optional.of((Long) value);
                        return finalSubDimensionField;
                rangeQuery.from(),
            .findFirst()
                !rangeQuery.includeLower(),
            : org.opensearch.index.mapper.DateFieldMapper.getDefaultDateTimeFormatter().toDateMathParser();
import java.util.Optional;
    }
            if (!rangeQuery.includeUpper()) {
            // 1/ l = 2022-05-31T23:00:00.000 is to the nearest 'hour' or not
        };
        return new RangeMatchDimFilter(field, l, u, true, true) {
        if (needsFinalFilter == false) {
                    rangeMatchDimFilter.getLow(),
            ? DateFormatter.forPattern(rangeQuery.format()).toDateMathParser()
            // 2/ u+1 = 2022-06-01T00:00:00.000 is to the nearest 'hour' or not.
            l = DateFieldType.parseToLong(
            );
            .iterator()
            public String getSubDimensionName() {
        if (rangeQuery.to() != null) {
            // So for example, closed-interval [l=2022-05-31T23:00:00.000, u=2022-05-31T23:59:59.999]
            if (!rangeQuery.includeLower()) {
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        DateFieldType dateFieldType = (DateFieldType) mappedFieldType;
            }
import org.opensearch.common.time.DateMathParser;
            boolean roundedHighMatches = u == Long.MAX_VALUE || interval.roundFloor(u + 1) == u + 1;
        String dimensionName,
        String field = rangeQuery.fieldName();
            // Check if l is start of star-tree interval
                dateFieldType.resolution()
                ++l;
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
    public boolean resolveUsingSubDimension() {
            // can be resolved by star-tree 'hour' interval.
            int granularity = sortedSubDimensions.indexOf(filter.getSubDimensionName());
        if (matchingInterval == null) {
        long u = Long.MAX_VALUE;
            if (roundedLowMatches && roundedHighMatches) {
    DateDimension dateDimension;
        long l = Long.MIN_VALUE;
                    public String getSubDimensionName() {
package org.opensearch.search.startree.filter.provider;
        StarTreeValues starTreeValues,
    public StarDateFieldMapper(SearchContext searchContext) {
    public DimensionFilter getRangeMatchFilter(MappedFieldType mappedFieldType, StarTreeRangeQuery rangeQuery) {
        this.compositeDataCubeFieldType = (CompositeDataCubeFieldType) searchContext.mapperService()
            : subDimensionField2;
 * compatible open source license.
        }
        if (filters == null || filters.size() <= 1) {
    }
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
                dateFieldType.resolution()
        }
        // l & u are inclusive interval boundaries here
class StarDateFieldMapper implements DimensionFilterMapper {
        }
    @Override
            return null; // No matching interval found, fall back to default implementation
                break; // Found the most granular matching interval
            // If both bounds can be resolved by this star-tree interval, we have an exact match for this interval
        List<DateTimeUnitRounding> intervals = dateDimension.getSortedCalendarIntervals().reversed();
            .stream()
            // Check if u+1 is the start of star-tree interval compared to u
        if (!(v1 instanceof Long) || !(v2 instanceof Long)) {
    List<String> sortedSubDimensions;
        for (DateTimeUnitRounding interval : intervals) {
        subDimensionField = field + "_" + matchingInterval.shortName();
    String subDimensionField;
import org.opensearch.search.startree.filter.RangeMatchDimFilter;
 *
        // Construct the sub-dimension field name
    }
        }
            return filters;
import java.time.ZoneId;
            );
import org.opensearch.index.mapper.MappedFieldType;
        }
                    rangeMatchDimFilter.isIncludeLow(),
    }
            boolean roundedLowMatches = l == Long.MIN_VALUE || interval.roundFloor(l) == l;
/*
    @Override
import org.opensearch.common.time.DateFormatter;
    public DimensionFilter getExactMatchFilter(MappedFieldType mappedFieldType, List<Object> rawValues) {
                forcedDateParser,
            // OpenSearch rounds up to the last millisecond in the rounding interval.
            }
            .getCompositeFieldTypes()
    @Override
    }
