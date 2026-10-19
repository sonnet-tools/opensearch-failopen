            if (isValueInRange(value, range, mapper)) {
            }  
        };  
            public String getSubDimensionName() {  
            includeHigh = range1.isIncludeHigh();
    /**
        );  
public class DimensionFilterMergerUtils {  
    private static DimensionFilter intersectRangeWithExactMatch(
        // Find the more restrictive bounds
        throw new IllegalArgumentException(
        Object newLow;  
            "Unsupported filter combination: " + filter1.getClass().getSimpleName() + " and " + filter2.getClass().getSimpleName()
package org.opensearch.search.startree.filter;
                newLow = low1;
        }
            includeLow = range1.isIncludeLow();
        ExactMatchDimFilter exact,
/**
        }
    private static DimensionFilter intersectRangeFilters(
        if (!filter1.getDimensionName().equals(filter2.getDimensionName())) {
        }
 */
                newHigh = high2;  
        return new ExactMatchDimFilter(exact1.getDimensionName(), intersection);
        // Check if range is valid
 *
        if (low1 == null) {
     */
 */  
     */  
     */  
 * Utility class for merging different types of {@link DimensionFilter}  
        }
     * Returns null if no common values
 * SPDX-License-Identifier: Apache-2.0
    ) {  
                includeLow = range1.isIncludeLow() && range2.isIncludeLow();  
        DimensionFilterMapper mapper
    }
        if (filter1 instanceof RangeMatchDimFilter rangeFilter && filter2 instanceof ExactMatchDimFilter exactFilter) {  
        // Handle ExactMatch + Range combination
            return null;
        if (newLow != null && newHigh != null) {  
        }
        if (validValues.isEmpty()) {  
     * Returns null if intersection results in no possible matches.
                newHigh = high1;  
        Object newHigh;
        }
     * Intersects two range filters
            }
/*  
        } else if (high2 == null) {  
                "Cannot intersect filters for different dimensions: " + filter1.getDimensionName() + " and " + filter2.getDimensionName()  
        List<Object> values1 = exact1.getRawValues();
                includeHigh = range1.isIncludeHigh();
        }
        if (filter1 instanceof ExactMatchDimFilter exactFilter1 && filter2 instanceof ExactMatchDimFilter exactFilter2) {
            } else if (comparison > 0) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.startree.filter.provider.DimensionFilterMapper;
        // throw exception for unsupported exception  
        return mapper.isValueInRange(value, range.getLow(), range.getHigh(), range.isIncludeLow(), range.isIncludeHigh());
    }
    }
                newHigh = high1;  
            }
        if (intersection.isEmpty()) {  
        }  
            }
        Object low2 = range2.getLow();
    private static DimensionFilter intersectExactMatchFilters(ExactMatchDimFilter exact1, ExactMatchDimFilter exact2) {
            int comparison = mapper.compareValues(low1, low2);  
        // Handle Range + ExactMatch combination
                includeLow = range1.isIncludeLow();  
import java.util.HashSet;
        return new ExactMatchDimFilter(exact.getDimensionName(), validValues);
    }
            return null;
    /**
            );
        // Handle ExactMatch + ExactMatch combination  
            newHigh = high1;
                includeHigh = range2.isIncludeHigh();
            return intersectExactMatchFilters(exactFilter1, exactFilter2);
        } else {
                return null; // No overlap
    /**
            includeLow = range2.isIncludeLow();
            } else {
                newLow = low1;
                return effectiveSubDimension;
        if (high1 == null) {  
        }  
            return intersectRangeWithExactMatch(rangeFilter, exactFilter, mapper);
            throw new IllegalArgumentException("Cannot intersect filters with null dimension name");  
        return new RangeMatchDimFilter(range1.getDimensionName(), newLow, newHigh, includeLow, includeHigh) {
     * Intersects two exact match filters
        if (filter1 instanceof RangeMatchDimFilter rangeFilter1 && filter2 instanceof RangeMatchDimFilter rangeFilter2) {
        }
     * Returns null if no values from exact match are within range.  
            } else {
        }
                newLow = low2;
        if (filter1 == null || filter2 == null) {
            return intersectRangeWithExactMatch(rangeFilter, exactFilter, mapper);  
import java.util.List;
            return intersectRangeFilters(rangeFilter1, rangeFilter2, mapper);  
        Object high2 = range2.getHigh();  
 * this file be licensed under the Apache-2.0 license or a
            newLow = low1;  
            }  
            if (values2Set.contains(value)) {
    /**  
    private static boolean isValueInRange(Object value, RangeMatchDimFilter range, DimensionFilterMapper mapper) {
     * Gets intersection of two DimensionFilters  
     */  
                includeHigh = range1.isIncludeHigh() && range2.isIncludeHigh();
                intersection.add(value);
        } else {  
    /**  
        Object high1 = range1.getHigh();
            if (comparison > 0) {
    public static DimensionFilter intersect(DimensionFilter filter1, DimensionFilter filter2, DimensionFilterMapper mapper) {  
 * compatible open source license.
            return null;
    }  
        // Verify filters are for same dimension  
        RangeMatchDimFilter range1,
        Set<Object> values2Set = new HashSet<>(exact2.getRawValues());  
        Object low1 = range1.getLow();  
    ) {
     * Intersects a range filter with an exact match filter.
}
     * Checks if a value falls within a range.
            ? mapper.getSubDimensionFieldEffective(range1.getSubDimensionName(), range2.getSubDimensionName())
                validValues.add(value);
        if (filter1.getDimensionName() == null || filter2.getDimensionName() == null) {
 * Handles intersection operations between {@link ExactMatchDimFilter} and {@link RangeMatchDimFilter}
import java.util.Set;  
        }  
        List<Object> validValues = new ArrayList<>();
        if (filter1 instanceof ExactMatchDimFilter exactFilter && filter2 instanceof RangeMatchDimFilter rangeFilter) {
        for (Object value : exact.getRawValues()) {  
     * Returns null if ranges don't overlap
        String effectiveSubDimension = mapper.resolveUsingSubDimension()  
        }
        }
        // Handle Range + Range combination
        boolean includeHigh;
            newHigh = high2;
        for (Object value : values1) {  
            int comparison = mapper.compareValues(high1, high2);
            throw new IllegalArgumentException(
            newLow = low2;  
            if (!mapper.isValidRange(newLow, newHigh, includeLow, includeHigh)) {
        List<Object> intersection = new ArrayList<>();
            includeHigh = range2.isIncludeHigh();
            if (comparison < 0) {
            @Override
        boolean includeLow;
            } else if (comparison < 0) {
                includeLow = range2.isIncludeLow();  
        } else if (low2 == null) {
     */
            : null;
        RangeMatchDimFilter range,  
import java.util.ArrayList;  
        DimensionFilterMapper mapper
            }  
        RangeMatchDimFilter range2,  
