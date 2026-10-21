            public String getDimensionName() {
            range("unsigned_field", -2L, -1L, true, true),   // -1L is max unsigned long
            exactMatch("status", Arrays.asList(199L, 200L, 250L, 300L, 301L)),
 * compatible open source license.
        // Empty list
            range("status", 200L, 300L, false, false),
            @Override
            range("status", 200L, 200L, true, true),
                range("status", "200", "300", true, true),
            range("status", 200L, 300L, true, true),
        assertEquals("Cannot intersect filters with null dimension name", e2.getMessage());
            DimensionFilterMergerUtils.intersect(exactMatch("status", List.of(200L)), null, numericMapper)
        );
        // Inclusive/Exclusive boundaries
            exactMatch("status", List.of(250L)),
        RangeMatchDimFilter rangeResult = (RangeMatchDimFilter) result;
        assertExactMatchIntersection(
        );
            numericMapper
    private DimensionFilterMapper numericMapper;
            range("status", 200L, 300L, true, true),
    }
            new NumberFieldMapper.NumberFieldType("unsigned_field", NumberFieldMapper.NumberType.UNSIGNED_LONG),
        DimensionFilter customFilter = new CustomDimensionFilter();
            range("unsigned_field", 0L, -1L, true, true),
        // Single value intersection
        // Basic range intersection
            numericMapper
        assertEquals("Cannot intersect filters with null dimension name", e3.getMessage());
        RangeMatchDimFilter expected,
    // Helper methods
                numericMapper
            exactMatch("status", Arrays.asList(300, 400, 500)),
            searchContext
            range("unsigned_field", 2L, -2L, true, true),    // -2L is near max unsigned long
            range("status", 200L, 300L, false, false),
            range("status", null, 500L, true, true),
        assertRangeIntersection(
            range("status", 300L, 400L, true, true),
            IllegalArgumentException.class,
    }
            IllegalArgumentException.class,
                range("port", 80, 443, true, true),
package org.opensearch.search.aggregations.startree;
            numericMapper
            IllegalArgumentException.class,
            IllegalArgumentException.class,
        assertRangeIntersection(
import java.util.Arrays;
        );
import java.util.HashSet;
        // incompatible types
    public void testIntersectValidation() {
    ) {
        keywordMapper = DimensionFilterMapper.Factory.fromMappedFieldType(new KeywordFieldMapper.KeywordFieldType("method"), searchContext);
        assertExactMatchIntersection(
        assertRangeExactMatchIntersection(
        IllegalArgumentException e4 = assertThrows(
        DimensionFilter result = DimensionFilterMergerUtils.intersect(filter1, filter2, mapper);
        // Value in range
            unsignedLongMapper
    public void testRangeExactMatchIntersection() {
        assertNoIntersection(range("status", 200L, 200L, true, true), range("status", 200L, 200L, false, false), numericMapper);
        assertNull("Should return null for both null filters", DimensionFilterMergerUtils.intersect(null, null, numericMapper));
        assertEquals("Unsupported filter combination: RangeMatchDimFilter and CustomDimensionFilter", e2.getMessage());
    private DimensionFilterMapper keywordMapper;
    }
            numericMapper
    }
            @Override
        );
            exactMatch("status", Arrays.asList(200, 300, 400)),
        assertEquals(expected.isIncludeLow(), rangeResult.isIncludeLow());
        // Case sensitivity
    @Before
            exactMatch("status", List.of(200)),
        assertRangeIntersection(
        assertTrue(result instanceof ExactMatchDimFilter);
            numericMapper
            range("unsigned_field", 100L, 200L, true, true),
        // Value at range boundaries
            numericMapper
            exactMatch("status", Arrays.asList(200, 200, 300)),
        IllegalArgumentException e2 = assertThrows(
        assertRangeIntersection(
        ExactMatchDimFilter expected,
        RangeMatchDimFilter filter1,
            numericMapper
        // No intersection
    }
            exactMatch("method", List.of("GET")),
        );
        // Test null dimension names
        assertRangeExactMatchIntersection(
            numericMapper
        // Boundary conditions
    }
        // Null bounds (unbounded ranges)
        );
        DimensionFilterMapper mapper
        assertEquals("Cannot intersect filters with null dimension name", e1.getMessage());
            )
            IllegalArgumentException.class,
        );
        assertEquals("Unsupported filter combination: CustomDimensionFilter and ExactMatchDimFilter", e1.getMessage());
        assertRangeIntersection(
    ) {
        // Test unsupported combination with RangeMatchDimFilter
import static org.mockito.Mockito.mock;
 * The OpenSearch Contributors require contributions made to
        assertRangeIntersection(
            range("status", 300L, 400L, true, true),
    }
            )
                return false;
    private ExactMatchDimFilter exactMatch(String dimension, List<Object> values) {
            exactMatch("status", Arrays.asList(201L, 299L)),
            exactMatch("method", Arrays.asList("GET", "GET*")),
    public void testUnsignedLongRangeIntersection() {
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
            @Override
        );
        );
        // Test null filters
        // No values in range
        ExactMatchDimFilter exactResult = (ExactMatchDimFilter) result;
        // Test case 2: High values (near max unsigned long)
        assertRangeExactMatchIntersection(
        DimensionFilter result = DimensionFilterMergerUtils.intersect(range, exact, mapper);
/*
            new NumberFieldMapper.NumberFieldType("status", NumberFieldMapper.NumberType.LONG),
            public boolean matchDimValue(long ordinal, StarTreeValues starTreeValues) {
                numericMapper
        assertNull(
            IllegalArgumentException.class,
        // Single point overlap
            unsignedLongMapper
                numericMapper
        assertExactMatchIntersection(
        IllegalArgumentException e3 = assertThrows(
        assertRangeExactMatchIntersection(
 */
            exactMatch("status", List.of(250L)),
        assertRangeIntersection(
import org.opensearch.search.internal.SearchContext;
        // Exactly touching ranges (no overlap)
import org.opensearch.search.startree.filter.provider.DimensionFilterMapper;
        // Zero-width ranges
    public void testUnsupportedFilterCombination() {
            }
            () -> DimensionFilterMergerUtils.intersect(nullDimFilter1, nullDimFilter2, numericMapper)
        );
        DimensionFilter nullDimFilter2 = new ExactMatchDimFilter(null, List.of(300L));
    private void assertExactMatchIntersection(
        // Very large ranges
        IllegalArgumentException e1 = assertThrows(
        );
        assertRangeIntersection(
            exactMatch("status", Arrays.asList(201L, 299L)),
    private final SearchContext searchContext = mock(SearchContext.class);
            exactMatch("status", Arrays.asList(200L, 250L, 300L)),
        assertNoIntersection(exactMatch("status", List.of(200)), exactMatch("status", List.of(300)), numericMapper);
    private void assertRangeExactMatchIntersection(
            range("unsigned_field", 0L, -1L, true, true),    // 0 to max unsigned
            () -> DimensionFilterMergerUtils.intersect(nullDimFilter1, exactMatch("status", List.of(200L)), numericMapper)
            range("status", 200L, 300L, true, true),
            exactMatch("status", Arrays.asList(200L, 300L)),
        ExactMatchDimFilter exact,
                exactMatch("method", List.of("GET")),
            range("unsigned_field", -5L, -2L, true, true),
            keywordMapper
    private void assertRangeIntersection(
    public void testRangeIntersection() {
                return "status";
        // Test case 4: Non-overlapping ranges in unsigned space
        // Special characters in string values
    }
import org.opensearch.search.startree.StarTreeNodeCollector;
 * this file be licensed under the Apache-2.0 license or a
            @Override
        );
            range("status", 200L, 300L, true, true),
    }
        DimensionFilter result = DimensionFilterMergerUtils.intersect(filter1, filter2, mapper);
        );
            exactMatch("status", Arrays.asList(300, 400)),
            unsignedLongMapper
        class CustomDimensionFilter implements DimensionFilter {
            range("status", 200L, null, true, true),
        // Duplicate values
        ExactMatchDimFilter filter2,
            exactMatch("status", Arrays.asList(200, 300)),
        assertNoIntersection(
            exactMatch("status", List.of(200)),
            range("status", 200L, 200L, true, true),
            numericMapper
            exactMatch("method", Arrays.asList("GET", "GET/")),
        assertThrows(
}
        numericMapper = DimensionFilterMapper.Factory.fromMappedFieldType(
            () -> DimensionFilterMergerUtils.intersect(
        );
            public void initialiseForSegment(StarTreeValues starTreeValues, SearchContext searchContext) {}
            numericMapper
            range("status", 200L, 300L, true, true),
            range("status", 300L, 300L, true, true),
 *
        );
        );
    }
        assertEquals("Cannot intersect filters for different dimensions: status and method", e4.getMessage());
            range("unsigned_field", 2L, -2L, true, true),
        );
    ) {
        assertTrue(result instanceof RangeMatchDimFilter);
        );
            range("status", 200L, 200L, true, true),
                range("status", 200, 300, true, true),
import org.opensearch.search.startree.filter.DimensionFilterMergerUtils;
        assertNoIntersection(range("status", 200L, 300L, true, true), range("status", 301L, 400L, true, true), numericMapper);
            range("status", 200L, 300L, true, true),
            () -> DimensionFilterMergerUtils.intersect(
            keywordMapper
        );
        assertEquals(new HashSet<>(expected.getRawValues()), new HashSet<>(exactResult.getRawValues()));
import org.opensearch.test.OpenSearchTestCase;
            numericMapper
            range("unsigned_field", -10L, -5L, true, true),  // High unsigned values
    public void testDifferentDimensions() {
        assertNull(
        assertNoIntersection(
        );
        assertEquals(new HashSet<>(expected.getRawValues()), new HashSet<>(exactResult.getRawValues()));
            range("status", Long.MIN_VALUE, Long.MAX_VALUE, true, true),
        assertNoIntersection(range("status", 200L, 300L, true, true), exactMatch("status", Arrays.asList(199L, 301L)), numericMapper);
                range("status", 200, 300, true, true),
        DimensionFilterMapper unsignedLongMapper = DimensionFilterMapper.Factory.fromMappedFieldType(
    public void testExactMatchIntersection() {
        );
        // Test case 1: Regular positive values
        );
        );
        RangeMatchDimFilter filter2,
                exactMatch("status", List.of(200L)),
            numericMapper
    public void setup() {
        // Test unsupported combination with ExactMatchDimFilter
        IllegalArgumentException e1 = assertThrows(
            numericMapper
            range("unsigned_field", 1L, 10L, true, true),    // Low unsigned values
            "Should return null for null first filter",
import org.opensearch.index.mapper.NumberFieldMapper;
import org.junit.Before;
        DimensionFilterMapper mapper
            () -> DimensionFilterMergerUtils.intersect(customFilter, exactMatch("status", List.of(200L)), numericMapper)
    }
        );
            numericMapper
            IllegalArgumentException.class,
        // Cannot intersect different dimensions
        DimensionFilter nullDimFilter1 = new ExactMatchDimFilter(null, List.of(200L));
        assertExactMatchIntersection(
            public void matchStarTreeNodes(StarTreeNode parentNode, StarTreeValues starTreeValues, StarTreeNodeCollector collector) {}
        );
            range("status", 200L, 500L, true, true),
        // Non-overlapping ranges
            )
        );
        // Test case 3: Crossing the unsigned boundary
        ExactMatchDimFilter expected,
import org.opensearch.search.startree.filter.DimensionFilter;
        assertRangeIntersection(
        );
            range("status", 200L, 500L, true, true),
            range("unsigned_field", -5L, -2L, true, true),
            exactMatch("status", Arrays.asList(200, 300, 300)),
            unsignedLongMapper
        // Create a custom filter type for testing
            range("status", 200L, null, true, true),
            IllegalArgumentException.class,
import java.util.List;
import org.opensearch.search.startree.filter.RangeMatchDimFilter;
        assertNull(DimensionFilterMergerUtils.intersect(filter1, filter2, mapper));
    }
            DimensionFilterMergerUtils.intersect(null, exactMatch("status", List.of(200L)), numericMapper)
        ExactMatchDimFilter exactResult = (ExactMatchDimFilter) result;
        // Test case 6: Full range
        assertRangeIntersection(
        IllegalArgumentException e2 = assertThrows(
            range("status", 300L, 400L, true, true),
        assertTrue(result instanceof ExactMatchDimFilter);
        return new ExactMatchDimFilter(dimension, values);
        assertRangeIntersection(
            unsignedLongMapper
        // Multiple values, some in range
            () -> DimensionFilterMergerUtils.intersect(range("status", 200L, 300L, true, true), customFilter, numericMapper)
        RangeMatchDimFilter range,
        // Value at exclusive boundaries
    }
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;
        );
            range("status", 200L, 300L, false, true),
        );
        assertThrows(
            range("unsigned_field", 1L, -1L, true, true),    // -1L is max unsigned long
            range("status", 200L, 500L, true, true),
        }
            }
            exactMatch("method", Arrays.asList("GET", "Post")),
import org.opensearch.index.mapper.KeywordFieldMapper;
    }
            searchContext
            () -> DimensionFilterMergerUtils.intersect(exactMatch("status", List.of(200L)), nullDimFilter2, numericMapper)
            range("status", 200L, 300L, true, false),
        );
    private RangeMatchDimFilter range(String dimension, Object low, Object high, boolean includeLow, boolean includeHigh) {
        return new RangeMatchDimFilter(dimension, low, high, includeLow, includeHigh);
            range("unsigned_field", 200L, 300L, true, true),
        );
            range("unsigned_field", 100L, 500L, true, true),
        assertEquals(expected.getLow(), rangeResult.getLow());
        // Test case 5: Single point intersection at max unsigned value
        assertEquals(expected.isIncludeHigh(), rangeResult.isIncludeHigh());
public class DimensionFilterMergerUtilsTests extends OpenSearchTestCase {
        );
        // Test different dimensions
        assertRangeIntersection(
        assertNoIntersection(range("status", 200L, 300L, true, false), range("status", 300L, 400L, true, true), numericMapper);
            range("status", null, 500L, true, true),
            range("unsigned_field", -2L, -1L, true, true),
            range("unsigned_field", 200L, 300L, true, true),
        // Multiple values intersection
 * SPDX-License-Identifier: Apache-2.0
        );
            "Should return null for null second filter",
        ExactMatchDimFilter filter1,
import org.opensearch.search.startree.filter.ExactMatchDimFilter;
        );
            range("unsigned_field", 100L, 200L, true, true),
            exactMatch("method", Arrays.asList("get", "POST")),
        assertEquals(expected.getHigh(), rangeResult.getHigh());
        DimensionFilterMapper mapper
        assertNoIntersection(exactMatch("status", Collections.emptyList()), exactMatch("status", List.of(200)), numericMapper);
            range("unsigned_field", -10L, -1L, true, true),  // -1L is max unsigned long (2^64 - 1)
        // Setup unsigned long mapper
            unsignedLongMapper
            exactMatch("status", List.of(200)),
import java.util.Collections;
            exactMatch("status", Arrays.asList(200L, 300L)),
    private void assertNoIntersection(DimensionFilter filter1, DimensionFilter filter2, DimensionFilterMapper mapper) {
            () -> DimensionFilterMergerUtils.intersect(
