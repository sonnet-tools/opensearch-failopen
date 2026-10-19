     * Intersects two range filters
        if (filter1 instanceof RangeMatchDimFilter rangeFilter1 && filter2 instanceof RangeMatchDimFilter rangeFilter2) {
     * Intersects two exact match filters
            return null;
        if (low1 == null) {
/*
        // throw exception for unsupported exception
            @Override
            includeLow = range2.isIncludeLow();
            if (comparison < 0) {
 */
            int comparison = mapper.compareValues(low1, low2);
        Object high2 = range2.getHigh();
import java.util.HashSet;
                "Cannot intersect filters for different dimensions: " + filter1.getDimensionName() + " and " + filter2.getDimensionName()
        if (validValues.isEmpty()) {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        );
        // Verify filters are for same dimension
        return new ExactMatchDimFilter(exact.getDimensionName(), validValues);
        // Find the more restrictive bounds
        }
        }
            if (comparison > 0) {
        throw new IllegalArgumentException(
     */
 */
            throw new IllegalArgumentException("Cannot intersect filters with null dimension name");
            if (values2Set.contains(value)) {
     * Returns null if no common values
                newLow = low2;
        if (intersection.isEmpty()) {
            "Unsupported filter combination: " + filter1.getClass().getSimpleName() + " and " + filter2.getClass().getSimpleName()
    private static DimensionFilter intersectRangeFilters(
            } else if (comparison > 0) {
        }
        // Handle Range + ExactMatch combination
            }
        } else if (high2 == null) {
        return mapper.isValueInRange(value, range.getLow(), range.getHigh(), range.isIncludeLow(), range.isIncludeHigh());
        for (Object value : values1) {
        }
    private static DimensionFilter intersectRangeWithExactMatch(
    }
    ) {
                newLow = low1;
}
    /**
                intersection.add(value);
            }
        RangeMatchDimFilter range,
        DimensionFilterMapper mapper
            ? mapper.getSubDimensionFieldEffective(range1.getSubDimensionName(), range2.getSubDimensionName())
    ) {
     * Gets intersection of two DimensionFilters
     */
import java.util.List;
            newHigh = high1;
        }
            }
        return new RangeMatchDimFilter(range1.getDimensionName(), newLow, newHigh, includeLow, includeHigh) {
     * Checks if a value falls within a range.
            includeLow = range1.isIncludeLow();
            return null;
        DimensionFilterMapper mapper
        return new ExactMatchDimFilter(exact1.getDimensionName(), intersection);
 *
     * Returns null if no values from exact match are within range.
        for (Object value : exact.getRawValues()) {
package org.opensearch.search.startree.filter;
        }
            newHigh = high2;
                return effectiveSubDimension;
    /**
        if (filter1 instanceof ExactMatchDimFilter exactFilter && filter2 instanceof RangeMatchDimFilter rangeFilter) {
                newHigh = high2;
            }
        Set<Object> values2Set = new HashSet<>(exact2.getRawValues());
    /**
        ExactMatchDimFilter exact,
 * Utility class for merging different types of {@link DimensionFilter}
                includeHigh = range1.isIncludeHigh();
        if (!filter1.getDimensionName().equals(filter2.getDimensionName())) {
            }
    private static DimensionFilter intersectExactMatchFilters(ExactMatchDimFilter exact1, ExactMatchDimFilter exact2) {
import java.util.Set;
            if (!mapper.isValidRange(newLow, newHigh, includeLow, includeHigh)) {
        RangeMatchDimFilter range1,
import org.opensearch.search.startree.filter.provider.DimensionFilterMapper;
            if (isValueInRange(value, range, mapper)) {
    private static boolean isValueInRange(Object value, RangeMatchDimFilter range, DimensionFilterMapper mapper) {
        RangeMatchDimFilter range2,
        }
        // Handle ExactMatch + Range combination
                includeLow = range2.isIncludeLow();
        } else {
    /**
        }
    }
        String effectiveSubDimension = mapper.resolveUsingSubDimension()
 * compatible open source license.
                newHigh = high1;
        }
     */
        if (newLow != null && newHigh != null) {
            int comparison = mapper.compareValues(high1, high2);
            return intersectRangeFilters(rangeFilter1, rangeFilter2, mapper);
            } else if (comparison < 0) {
     */
                includeLow = range1.isIncludeLow();
    }
        }
            return intersectExactMatchFilters(exactFilter1, exactFilter2);
     * Returns null if ranges don't overlap
            return null;
                includeLow = range1.isIncludeLow() && range2.isIncludeLow();
    }
                includeHigh = range1.isIncludeHigh() && range2.isIncludeHigh();
        if (filter1 == null || filter2 == null) {
            return intersectRangeWithExactMatch(rangeFilter, exactFilter, mapper);
        Object low2 = range2.getLow();
        }
                includeHigh = range2.isIncludeHigh();
        };
        } else {
        boolean includeLow;
     * Returns null if intersection results in no possible matches.
        Object newHigh;
        // Check if range is valid
    }
        // Handle Range + Range combination
            includeHigh = range1.isIncludeHigh();
            } else {
            } else {
        List<Object> intersection = new ArrayList<>();
/**
            }
            includeHigh = range2.isIncludeHigh();
                newHigh = high1;
        if (filter1 instanceof ExactMatchDimFilter exactFilter1 && filter2 instanceof ExactMatchDimFilter exactFilter2) {
            );
        Object newLow;
            throw new IllegalArgumentException(
        Object high1 = range1.getHigh();
        if (filter1.getDimensionName() == null || filter2.getDimensionName() == null) {
        if (high1 == null) {
                return null; // No overlap
public class DimensionFilterMergerUtils {
        // Handle ExactMatch + ExactMatch combination
                newLow = low1;
        }
        List<Object> validValues = new ArrayList<>();
        Object low1 = range1.getLow();
     */
    public static DimensionFilter intersect(DimensionFilter filter1, DimensionFilter filter2, DimensionFilterMapper mapper) {
            return intersectRangeWithExactMatch(rangeFilter, exactFilter, mapper);
        }
            newLow = low2;
        boolean includeHigh;
        if (filter1 instanceof RangeMatchDimFilter rangeFilter && filter2 instanceof ExactMatchDimFilter exactFilter) {
        } else if (low2 == null) {
 * Handles intersection operations between {@link ExactMatchDimFilter} and {@link RangeMatchDimFilter}
            public String getSubDimensionName() {
import java.util.ArrayList;
     * Intersects a range filter with an exact match filter.
            newLow = low1;
 * The OpenSearch Contributors require contributions made to
        }
                validValues.add(value);
    /**
            : null;
        List<Object> values1 = exact1.getRawValues();
