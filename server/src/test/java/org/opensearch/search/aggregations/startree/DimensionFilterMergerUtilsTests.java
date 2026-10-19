            range("unsigned_field", 200L, 300L, true, true),  
            range("status", 200L, 300L, false, true),  
        assertExactMatchIntersection(
            exactMatch("status", Arrays.asList(300, 400, 500)),
import org.opensearch.search.startree.filter.ExactMatchDimFilter;  
        DimensionFilter result = DimensionFilterMergerUtils.intersect(filter1, filter2, mapper);  
}  
public class DimensionFilterMergerUtilsTests extends OpenSearchTestCase {
            range("status", null, 500L, true, true),
        // Test case 3: Crossing the unsigned boundary  
    }
import org.opensearch.search.startree.filter.DimensionFilter;
            range("unsigned_field", -2L, -1L, true, true),   // -1L is max unsigned long
        assertRangeIntersection(
import static org.mockito.Mockito.mock;
        assertRangeIntersection(
    }
        RangeMatchDimFilter filter1,
            range("status", 300L, 400L, true, true),
 */  
        // Test case 5: Single point intersection at max unsigned value  
    public void testIntersectValidation() {
        );
        );  
        assertTrue(result instanceof ExactMatchDimFilter);
    private final SearchContext searchContext = mock(SearchContext.class);
                return "status";
            range("unsigned_field", 2L, -2L, true, true),    // -2L is near max unsigned long
        RangeMatchDimFilter expected,  
    }
            public boolean matchDimValue(long ordinal, StarTreeValues starTreeValues) {
    }  
        assertEquals("Unsupported filter combination: CustomDimensionFilter and ExactMatchDimFilter", e1.getMessage());
        assertNoIntersection(exactMatch("status", Collections.emptyList()), exactMatch("status", List.of(200)), numericMapper);
            numericMapper
            )  
            }
        // Test different dimensions
    public void testUnsupportedFilterCombination() {
        ExactMatchDimFilter exact,
            range("unsigned_field", 0L, -1L, true, true),  
            () -> DimensionFilterMergerUtils.intersect(customFilter, exactMatch("status", List.of(200L)), numericMapper)  
            () -> DimensionFilterMergerUtils.intersect(
            unsignedLongMapper  
/*  
    }
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
            new NumberFieldMapper.NumberFieldType("unsigned_field", NumberFieldMapper.NumberType.UNSIGNED_LONG),
 *
            new NumberFieldMapper.NumberFieldType("status", NumberFieldMapper.NumberType.LONG),
            exactMatch("method", Arrays.asList("GET", "Post")),  
            range("unsigned_field", 100L, 500L, true, true),
            () -> DimensionFilterMergerUtils.intersect(
        IllegalArgumentException e3 = assertThrows(
                return false;  
    private RangeMatchDimFilter range(String dimension, Object low, Object high, boolean includeLow, boolean includeHigh) {
        IllegalArgumentException e2 = assertThrows(
        // Single point overlap
        );
            numericMapper
            exactMatch("status", Arrays.asList(200L, 300L)),
        ExactMatchDimFilter filter2,
        );
            exactMatch("method", Arrays.asList("get", "POST")),
            numericMapper  
            range("status", 200L, 300L, true, true),  
        // No intersection  
            IllegalArgumentException.class,
        DimensionFilter nullDimFilter2 = new ExactMatchDimFilter(null, List.of(300L));
        );
            DimensionFilterMergerUtils.intersect(exactMatch("status", List.of(200L)), null, numericMapper)
        }
        assertEquals(expected.getLow(), rangeResult.getLow());  
            exactMatch("status", List.of(250L)),
    private void assertExactMatchIntersection(  
            exactMatch("status", Arrays.asList(200, 300)),
import org.opensearch.index.mapper.KeywordFieldMapper;  
import java.util.HashSet;
            range("unsigned_field", -10L, -5L, true, true),  // High unsigned values
        assertRangeExactMatchIntersection(  
        );
    private ExactMatchDimFilter exactMatch(String dimension, List<Object> values) {
            () -> DimensionFilterMergerUtils.intersect(range("status", 200L, 300L, true, true), customFilter, numericMapper)
    public void testDifferentDimensions() {
        assertRangeExactMatchIntersection(
            unsignedLongMapper
        // Boundary conditions
            numericMapper
                numericMapper
        // Test unsupported combination with RangeMatchDimFilter
        assertEquals("Unsupported filter combination: RangeMatchDimFilter and CustomDimensionFilter", e2.getMessage());  
        );
        );
 * this file be licensed under the Apache-2.0 license or a
            IllegalArgumentException.class,  
        );
        );
    private DimensionFilterMapper numericMapper;  
        // Test unsupported combination with ExactMatchDimFilter  
import org.opensearch.search.startree.filter.DimensionFilterMergerUtils;
            exactMatch("method", Arrays.asList("GET", "GET/")),
        );
        assertExactMatchIntersection(
        assertEquals(expected.isIncludeHigh(), rangeResult.isIncludeHigh());  
import java.util.Collections;
import org.opensearch.search.startree.filter.provider.DimensionFilterMapper;
        );  
        assertRangeIntersection(  
        assertNoIntersection(range("status", 200L, 300L, true, false), range("status", 300L, 400L, true, true), numericMapper);  
            exactMatch("status", Arrays.asList(201L, 299L)),
            range("status", 200L, 300L, true, true),  
            exactMatch("status", Arrays.asList(199L, 200L, 250L, 300L, 301L)),
        );
        );
import org.opensearch.test.OpenSearchTestCase;  
        // Value in range
            range("unsigned_field", 200L, 300L, true, true),
 * SPDX-License-Identifier: Apache-2.0
            range("status", Long.MIN_VALUE, Long.MAX_VALUE, true, true),
        assertExactMatchIntersection(  
        assertEquals("Cannot intersect filters with null dimension name", e2.getMessage());  
        );  
            range("status", 200L, 500L, true, true),  
            "Should return null for null second filter",  
        IllegalArgumentException e1 = assertThrows(
            )  
        assertExactMatchIntersection(  
        );
        assertEquals("Cannot intersect filters with null dimension name", e3.getMessage());  
        assertNoIntersection(range("status", 200L, 300L, true, true), range("status", 301L, 400L, true, true), numericMapper);  
        assertEquals(expected.isIncludeLow(), rangeResult.isIncludeLow());
            range("unsigned_field", 2L, -2L, true, true),
        DimensionFilterMapper mapper
            "Should return null for null first filter",
        assertNull(
            range("status", 200L, 300L, true, true),
        );  
    public void testRangeExactMatchIntersection() {  
            unsignedLongMapper  
                range("port", 80, 443, true, true),
            range("unsigned_field", 100L, 200L, true, true),  
            numericMapper
        // Special characters in string values
        assertRangeIntersection(
            numericMapper
        IllegalArgumentException e1 = assertThrows(
        assertRangeIntersection(  
            IllegalArgumentException.class,  
            exactMatch("status", Arrays.asList(200, 300, 300)),  
    private DimensionFilterMapper keywordMapper;
        assertThrows(  
    }
        assertNull(
        assertNoIntersection(range("status", 200L, 300L, true, true), exactMatch("status", Arrays.asList(199L, 301L)), numericMapper);
                range("status", 200, 300, true, true),  
            range("status", 200L, 500L, true, true),  
        // Inclusive/Exclusive boundaries  
        // Value at exclusive boundaries
        ExactMatchDimFilter exactResult = (ExactMatchDimFilter) result;
            numericMapper
    public void testExactMatchIntersection() {
            () -> DimensionFilterMergerUtils.intersect(
        assertNull("Should return null for both null filters", DimensionFilterMergerUtils.intersect(null, null, numericMapper));  
import java.util.List;  
            public void initialiseForSegment(StarTreeValues starTreeValues, SearchContext searchContext) {}
        DimensionFilterMapper mapper
        // Empty list  
            )  
            keywordMapper
                range("status", 200, 300, true, true),
                range("status", "200", "300", true, true),  
        // Multiple values intersection
        );  
        assertEquals(new HashSet<>(expected.getRawValues()), new HashSet<>(exactResult.getRawValues()));  
        keywordMapper = DimensionFilterMapper.Factory.fromMappedFieldType(new KeywordFieldMapper.KeywordFieldType("method"), searchContext);
            @Override
            exactMatch("status", Arrays.asList(200, 300, 400)),  
        assertRangeIntersection(
            exactMatch("status", List.of(250L)),
    private void assertRangeExactMatchIntersection(  
    ) {
        RangeMatchDimFilter range,
        );
        );  
            () -> DimensionFilterMergerUtils.intersect(exactMatch("status", List.of(200L)), nullDimFilter2, numericMapper)
        // Duplicate values  
import org.opensearch.search.internal.SearchContext;
            public String getDimensionName() {  
        return new ExactMatchDimFilter(dimension, values);  
        );
                numericMapper
        ExactMatchDimFilter filter1,
        );  
        ExactMatchDimFilter expected,  
        );
    ) {
            range("status", 200L, null, true, true),
            unsignedLongMapper
            range("unsigned_field", -5L, -2L, true, true),
import org.opensearch.search.startree.filter.RangeMatchDimFilter;
            numericMapper  
            public void matchStarTreeNodes(StarTreeNode parentNode, StarTreeValues starTreeValues, StarTreeNodeCollector collector) {}
        // Test case 4: Non-overlapping ranges in unsigned space
            searchContext
            range("unsigned_field", -10L, -1L, true, true),  // -1L is max unsigned long (2^64 - 1)  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        // Very large ranges  
            exactMatch("status", Arrays.asList(201L, 299L)),  
            numericMapper
            range("status", 200L, 200L, true, true),
        // Setup unsigned long mapper
        assertEquals(expected.getHigh(), rangeResult.getHigh());
        assertNoIntersection(
        // incompatible types
        assertRangeIntersection(
        // Test case 2: High values (near max unsigned long)
        assertRangeExactMatchIntersection(
            exactMatch("status", List.of(200)),  
                exactMatch("method", List.of("GET")),
    }  
            range("status", 200L, 200L, true, true),
        // Case sensitivity
            }
            range("status", 200L, 300L, true, true),  
        );  
            exactMatch("method", List.of("GET")),  
        ExactMatchDimFilter expected,  
                numericMapper
            range("status", 200L, null, true, true),
        );
            exactMatch("status", Arrays.asList(200L, 250L, 300L)),
        assertRangeIntersection(
            exactMatch("status", Arrays.asList(200, 200, 300)),
            range("unsigned_field", 1L, 10L, true, true),    // Low unsigned values
            range("unsigned_field", 1L, -1L, true, true),    // -1L is max unsigned long  
            @Override
            exactMatch("status", List.of(200)),
            @Override
        );
        RangeMatchDimFilter filter2,
            numericMapper
        DimensionFilter nullDimFilter1 = new ExactMatchDimFilter(null, List.of(200L));  
        // Test null dimension names
    }
            range("status", 200L, 300L, false, false),
            unsignedLongMapper
        DimensionFilter customFilter = new CustomDimensionFilter();
            IllegalArgumentException.class,  
        DimensionFilterMapper mapper
    ) {
            numericMapper  
import org.opensearch.search.startree.StarTreeNodeCollector;  
    // Helper methods  
    }
            numericMapper  
import org.junit.Before;
    private void assertRangeIntersection(  
        assertRangeIntersection(
        // Zero-width ranges
            range("status", 200L, 300L, true, false),
            IllegalArgumentException.class,  
        class CustomDimensionFilter implements DimensionFilter {
            range("unsigned_field", -2L, -1L, true, true),
            range("status", 200L, 200L, true, true),  
        assertRangeIntersection(  
        IllegalArgumentException e4 = assertThrows(  
            exactMatch("status", Arrays.asList(300, 400)),
            () -> DimensionFilterMergerUtils.intersect(nullDimFilter1, exactMatch("status", List.of(200L)), numericMapper)
import java.util.Arrays;  
        // Basic range intersection
    public void testUnsignedLongRangeIntersection() {
    }  
        DimensionFilterMapper unsignedLongMapper = DimensionFilterMapper.Factory.fromMappedFieldType(  
            range("status", 200L, 300L, true, true),
        // No values in range
        assertRangeIntersection(  
        assertNull(DimensionFilterMergerUtils.intersect(filter1, filter2, mapper));
        // Test case 1: Regular positive values
        DimensionFilter result = DimensionFilterMergerUtils.intersect(range, exact, mapper);  
    public void testRangeIntersection() {
        RangeMatchDimFilter rangeResult = (RangeMatchDimFilter) result;
        return new RangeMatchDimFilter(dimension, low, high, includeLow, includeHigh);
            range("unsigned_field", 100L, 200L, true, true),
        DimensionFilter result = DimensionFilterMergerUtils.intersect(filter1, filter2, mapper);  
            IllegalArgumentException.class,
        // Test case 6: Full range
        assertEquals("Cannot intersect filters for different dimensions: status and method", e4.getMessage());
            DimensionFilterMergerUtils.intersect(null, exactMatch("status", List.of(200L)), numericMapper)  
            exactMatch("status", List.of(200)),
            range("status", 300L, 400L, true, true),
        );
        assertNoIntersection(  
        );
        );
        );
            IllegalArgumentException.class,
        assertThrows(  
    private void assertNoIntersection(DimensionFilter filter1, DimensionFilter filter2, DimensionFilterMapper mapper) {  
        // Test null filters  
            range("status", null, 500L, true, true),
            range("status", 300L, 300L, true, true),
            searchContext
        // Cannot intersect different dimensions
        // Null bounds (unbounded ranges)
            () -> DimensionFilterMergerUtils.intersect(nullDimFilter1, nullDimFilter2, numericMapper)
package org.opensearch.search.aggregations.startree;
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;
    }
            range("status", 300L, 400L, true, true),  
        numericMapper = DimensionFilterMapper.Factory.fromMappedFieldType(  
            range("status", 200L, 300L, false, false),
import org.opensearch.index.mapper.NumberFieldMapper;
        );
        // Non-overlapping ranges
            unsignedLongMapper
        assertRangeIntersection(  
        // Exactly touching ranges (no overlap)
        assertNoIntersection(range("status", 200L, 200L, true, true), range("status", 200L, 200L, false, false), numericMapper);  
        );  
        assertTrue(result instanceof RangeMatchDimFilter);
            keywordMapper
        assertRangeExactMatchIntersection(
        // Create a custom filter type for testing  
        // Value at range boundaries  
        assertEquals("Cannot intersect filters with null dimension name", e1.getMessage());  
        );
            range("status", 200L, 300L, true, true),  
    @Before
            exactMatch("status", Arrays.asList(200L, 300L)),  
        ExactMatchDimFilter exactResult = (ExactMatchDimFilter) result;
    }
        IllegalArgumentException e2 = assertThrows(
            IllegalArgumentException.class,
            range("unsigned_field", -5L, -2L, true, true),
        assertEquals(new HashSet<>(expected.getRawValues()), new HashSet<>(exactResult.getRawValues()));  
        // Multiple values, some in range
    }
            numericMapper
                exactMatch("status", List.of(200L)),  
        assertNoIntersection(exactMatch("status", List.of(200)), exactMatch("status", List.of(300)), numericMapper);
    public void setup() {
        assertTrue(result instanceof ExactMatchDimFilter);
            numericMapper  
        );
            exactMatch("method", Arrays.asList("GET", "GET*")),
            @Override
            range("unsigned_field", 0L, -1L, true, true),    // 0 to max unsigned
    }
        // Single value intersection
            range("status", 200L, 500L, true, true),
