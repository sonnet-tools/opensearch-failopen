        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new BoolQueryBuilder())
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
        ).must(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrMin).lt(toDateStrMin).format(DATE_FORMAT));
        // For exclusive bounds (gt/lt), we need to use next/previous float values
                assertEquals(500L, statusRange.getLow());
            .must(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 404)).should(new TermQueryBuilder(STATUS, 403)));
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(
    public void testSimpleMustWithMultipleDimensions() throws IOException {
            0,
        List<DimensionFilter> dateFilters = filter.getFiltersForDimension(EVENT_DATE);
            .must(
            .must(new TermsQueryBuilder(METHOD, Arrays.asList("GET", "POST"))); // This should intersect with first method term
            .must(new RangeQueryBuilder(LATENCY).gte(0.6).lt(1.8))
            BigArrays.NON_RECYCLING_INSTANCE,
        assertEquals("Port lower bound should be 80", 80L, portRange.getLow());
            .minimumShouldMatch(2);  // Explicitly set minimum_should_match
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "POST");
    public void testShouldWithDifferentDimensions() throws IOException {
        for (DimensionFilter dimFilter : latencyFilters) {
public class BoolStarTreeFilterProviderTests extends OpenSearchTestCase {
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        assertEquals("Should have three dimensions", 3, filter.getDimensions().size());
        );
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.SECOND_OF_MINUTE)
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertEquals("Upper bound should be 300", 300L, rangeFilter.getHigh());
        }
    public void testDeepNestedShouldClauses() throws IOException {
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(validBoolQuery);
        // Verify method filter
        assertNotNull("Filter should not be null", filter);
import org.opensearch.index.query.WildcardQueryBuilder;
            .must(new TermQueryBuilder(STATUS, 200));
        // Test invalid case - multiple dimensions in MUST inside SHOULD
        assertTrue("Both should be ExactMatchDimFilter", statusFilters.stream().allMatch(f -> f instanceof ExactMatchDimFilter));
import org.opensearch.index.query.QueryShardContext;
        assertNotNull("Filter should not be null", filter);
            } else {
    public void testInvalidMustClauses() throws IOException {
        Set<Object> expectedStatus = Set.of(201L, 204L);
    }
        assertEquals(new BytesRef("eu-z"), regionRange.getHigh());
    }
    public void testMustNotClauseReturnsNull() throws IOException {
    public void testUnsupportedQueryTypes() throws IOException {
    }
        // Verify status filter (intersection of range and term)
        for (DimensionFilter zoneFilter : zoneFilters) {
    public void testEmptyNestedBools() throws IOException {
}
        assertNull("Filter should not be null", filter);
        assertNotNull("Filter should not be null", filter);
        assertNotNull("Filter should not be null", filter);
        assertEquals(100, statusFilters.size());
import org.opensearch.index.compositeindex.datacube.Metric;
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
    public void testComplexMustWithNestedShould() throws IOException {
        );
        long expectedToMillisSec = Instant.parse(toDateStrSec).toEpochMilli() - 1;
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        // Verify second range
        assertEquals("Should have one filter after intersection", 1, statusFilters.size());
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
        String fromDateStrMin = "2023-01-10T10:30:00.000Z";
        assertEquals("Exact match should be 200", 200L, exactFilter.get().getRawValues().get(0));
        long expectedHigh = NumericUtils.floatToSortableInt(FloatPoint.nextDown(1.8f));
        assertEquals("Port upper bound should be 443", 443L, portRange.getHigh());
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertEquals(new BytesRef("eu-"), regionRange.getLow());
        boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(METHOD, "GET"))
        BoolQueryBuilder boolQuery = new BoolQueryBuilder();
        assertTrue("Upper bound should be exclusive", rangeFilter.isIncludeHigh());
            .must(new RangeQueryBuilder(PORT).gte(80).lte(443));
        assertEquals(expectedValue, filter.getRawValues().getFirst());
        String toDateStr = "2023-01-10T12:00:00.000Z";
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
        assertTrue("Should contain date-second dimension", filter.getDimensions().contains(EVENT_DATE));
import org.opensearch.index.mapper.NumberFieldMapper;
    }
            .must(
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
        assertNull("Filter should be null for empty bool query", filter);
        StarTreeFilter filter = provider.getFilter(searchContext, keywordRangeQuery, compositeFieldType);
    }
        List<DimensionFilter> latencyFilters = filter.getFiltersForDimension(LATENCY);
    public void testMalformedQueries() throws IOException {
import org.opensearch.index.mapper.DateFieldMapper;
            actualValues.addAll(exactFilter.getRawValues());
                new StarTreeFieldConfiguration(
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
        assertFalse(regionRange.isIncludeLow());
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
        NumberFieldMapper.NumberFieldType statusType = new NumberFieldMapper.NumberFieldType(STATUS, NumberFieldMapper.NumberType.INTEGER);
        StarTreeFilter filter = provider.getFilter(searchContext, validBoolQuery, compositeFieldType);
        when(searchContext.mapperService()).thenReturn(mapperService);
            .should(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrSec).lt(toDateStrSec).format(DATE_FORMAT));
            .must(new TermQueryBuilder(STATUS, 200));
        assertTrue("Should be ExactMatchDimFilter", methodFilters.getFirst() instanceof ExactMatchDimFilter);
import org.opensearch.index.query.BoolQueryBuilder;
import org.apache.lucene.document.FloatPoint;
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        when(mapperService.fieldType("wildcard_field")).thenReturn(wildcardType);
        // Verify status filter (from FILTER)
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
        for (DimensionFilter dimensionFilter : statusFilters) {
import org.opensearch.search.startree.filter.ExactMatchDimFilter;
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
    }
        assertNull("Filter should be null for conflicting conditions", filter);
        // Test dimension that doesn't exist in mapping
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
            .filter(new TermQueryBuilder(PORT, 443));
            .must(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrSec).lt(toDateStrSec).format(DATE_FORMAT))
import org.apache.lucene.util.NumericUtils;
        assertTrue("Should be ExactMatchDimFilter", methodFilters.getFirst() instanceof ExactMatchDimFilter);
        provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertNotNull("Filter should not be null", filter);
                    )
        filter = provider.getFilter(searchContext, invalidBoolQuery, compositeFieldType);
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
    }
        // Verify first range
        assertExactMatchValue((ExactMatchDimFilter) statusFilters.getFirst(), 200L);
        // Verify port filter (keyword SHOULD terms)
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
import org.opensearch.test.OpenSearchTestCase;
        assertExactMatchValue((ExactMatchDimFilter) portFilters.getFirst(), 443L);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
    public void testShouldWithMultipleDateFieldRanges() throws IOException {
            current = nested;
        when(mapperService.fieldType(ZONE)).thenReturn(zoneType);
            () -> randomNonNegativeLong(),
        assertTrue("Port bounds should be inclusive", portRange.isIncludeLow() && portRange.isIncludeHigh());
        assertEquals("Status should have expected values", expectedStatusValues, actualStatusValues);
        assertEquals("Should have three dimensions", 3, filter.getDimensions().size());
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        // Setup common test dependencies
        Set<Object> expectedPorts = new HashSet<>();
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
            // Success or 5xx errors
            assertTrue("Should be ExactMatchDimFilter", dimFilter instanceof ExactMatchDimFilter);
            writableRegistry(),
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertEquals("Should have one filter for method after intersection", 1, methodFilters.size());
        assertEquals(80L, portRange.getLow());
        assertNull("Filter should be null for empty nested bool queries", filter);
        assertNull("Filter should be null for same dimension in MUST", filter);
    public void testShouldInsideShouldSameDimension() throws IOException {
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertNotNull("Filter should not be null", filter);
        // Create a bool query with large number of SHOULD clauses
import java.util.HashSet;
    }
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
            null,
        when(mapperService.fieldType(LATENCY)).thenReturn(latencyType);
        // first clause will use hour granularity, second clause will use minute granularity
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
            null,
        }
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        )
        assertNotNull("Filter should not be null", filter);
                    .must(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200)).should(new TermQueryBuilder(STATUS, 201)))
        assertEquals("Method should have one filter", 1, methodFilters.size());
        RangeMatchDimFilter firstRange = (RangeMatchDimFilter) statusFilters.getFirst();
        // Find and verify range filter
        assertTrue("Should have range filter", rangeFilter.isPresent());
        assertEquals("Should contain expected status values", expectedStatusValues, actualStatusValues);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
            .should(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 404)).should(new TermQueryBuilder(STATUS, 500)));
        List<DimensionFilter> dateFilters = filter.getFiltersForDimension(EVENT_DATE);
            .findFirst();
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
    }
        }
        Set<Object> expectedValues = Set.of(200L, 404L);
 * compatible open source license.
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertEquals("Status should have one filter", 1, statusFilters.size());
        assertTrue(regionRange.isIncludeLow());
            new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrMin).lt(toDateStrMin).format(DATE_FORMAT)
        // Verify status filters
    }
        expectedZones.add(new BytesRef("us-west"));
        RangeMatchDimFilter rangeFilter = (RangeMatchDimFilter) statusFilters.getFirst();
        BoolQueryBuilder shouldOnly = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200));
        // this should return null as same dimension in MUST is logically impossible
import org.opensearch.common.Rounding;
            .numberOfShards(1)
        assertEquals(expectedHigh, ((Number) latencyRange.getHigh()).longValue());
import org.opensearch.index.mapper.MapperService;
        assertTrue("Should contain date-minute dimension", filter.getDimensions().contains(EVENT_DATE));
        Set<Object> actualStatusValues = new HashSet<>();
        assertEquals(expectedPorts, actualZones);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
                assertEquals(200L, ((ExactMatchDimFilter) statusFilter).getRawValues().getFirst());
            .findFirst();
                    new OrdinalDimension(ZONE),
        );
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
    private void assertExactMatchValue(ExactMatchDimFilter filter, Long expectedValue) {
    public void testNestedShouldSameDimension() throws IOException {
        BoolQueryBuilder invalidBoolQuery = new BoolQueryBuilder().should(
        assertEquals(expectedLow, ((Number) latencyRange.getLow()).longValue());
        assertEquals("Should have one filter for status", 1, statusFilters.size());
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        Set<Object> actualZones = new HashSet<>();
            );
    }
        assertNull("Filter should be null for unsupported query type in SHOULD", filter);
        }
        Set<Object> actualStatus = new HashSet<>();
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
            actualValues.addAll(((ExactMatchDimFilter) dimensionFilter).getRawValues());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        long[] expectedLows = new long[] { expectedFromMillisHour, expectedFromMillisMin };
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        expectedPorts.add(80L);
        long expectedLow = NumericUtils.floatToSortableInt(FloatPoint.nextUp(0.5f));
        boolQuery = new BoolQueryBuilder().should(
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertExactMatchValue((ExactMatchDimFilter) filter.getFiltersForDimension(STATUS).get(0), 200L);
        assertEquals("Port lower bound should be 80", 80L, portRange.getLow());
    }
            null
        }
                new BoolQueryBuilder().must(
            NumberFieldMapper.NumberType.INTEGER
        assertNull("Filter should be null for MUST inside SHOULD", filter);
            .must(new TermQueryBuilder(METHOD, "GET"));
        assertEquals(expectedMethod, new HashSet<>(methodFilter.getRawValues()));
        // Test MUST clauses with same dimension
        assertNull("Filter should be null for non-existent dimension", filter);
    public void testSingleClauseBoolQueries() throws IOException {
            current.must(nested);
        ).should(new TermQueryBuilder(STATUS, 404));
        long expectedToMillis = Instant.parse(toDateStr).toEpochMilli() - 1;
        // Test incompatible range intersections
        assertTrue(latencyRange.isIncludeLow());   // After using nextUp, bound becomes inclusive
        assertNotNull("Filter should not be null", filter);
        assertTrue(portRange.isIncludeLow() && portRange.isIncludeHigh());
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
import org.opensearch.index.query.TermsQueryBuilder;
        }
        assertTrue(latencyRange.isIncludeHigh());
        assertNotNull("Filter should not be null for same dimension", filter);
    }
        // Test combined ranges in SHOULD
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        assertEquals("First range lower bound should be 200", 200L, firstRange.getLow());
    public void testMinimumShouldMatch() throws IOException {
        BoolQueryBuilder statusShould = new BoolQueryBuilder();
        for (DimensionFilter dimFilter : statusFilters) {
        assertEquals("Should contain expected values", expectedValues, actualValues);
            .must(
            .should(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrMin).lt(toDateStrMin).format(DATE_FORMAT))
        ).should(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrMin).lt(toDateStrMin).format(DATE_FORMAT));
        // first clause will use hour granularity, second clause will use minute granularity, overlapping intervals
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
            .must(new TermQueryBuilder(STATUS, 200));
            );
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder("wildcard_field", "value"))
            .must(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200)).should(new RangeQueryBuilder(STATUS).gte(500).lt(600)))
        when(mapperService.fieldType(EVENT_DATE)).thenReturn(eventDateFieldType); // Map the date field
        filter = provider.getFilter(searchContext, combinedRangeQuery, compositeFieldType);
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);
import org.opensearch.index.IndexSettings;
import org.opensearch.search.internal.SearchContext;
        assertTrue("Upper bound should be inclusive", rangeFilter.isIncludeHigh());
        // Verify method filter
        assertNull("Filter should be null for multiple MUST on same dimension", filter);
        assertTrue("Second range lower bound should be inclusive", secondRange.isIncludeLow());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        // Find and verify exact match filter
        assertEquals("Should have 1 dimension", 1, filter.getDimensions().size());
        for (int i = 0; i < 10; i++) { // Test with 10 levels of nesting
        assertNotNull("Filter should not be null", filter);
    }
        long expectedToMillisHour = Instant.parse(toDateStrHour).toEpochMilli() - 1;
        }
        Set<Object> expectedValues = Set.of(200L, 404L, 500L);
        assertEquals("Should have three filters for status", 3, statusFilters.size());
    }
            .must(new RangeQueryBuilder(STATUS).gte(400).lt(500));
        assertTrue("Lower bound should be exclusive", rangeFilter.isIncludeLow());
        // SHOULD with different dimensions (should be rejected)
        List<DimensionFilter> latencyFilters = filter.getFiltersForDimension(LATENCY);
        // Verify port range
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
                        new BoolQueryBuilder().should(new TermQueryBuilder(RESPONSE_TIME, 300))
        assertTrue("First range lower bound should be inclusive", firstRange.isIncludeLow());
    }
import java.io.IOException;
        assertTrue("Should contain date-minute dimension", filter.getDimensions().contains(EVENT_DATE));
        when(mapperService.fieldType("non_star_tree_field")).thenReturn(nonStarTreeField);
        // Setup field types
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
            assertTrue("Date upper bound should be inclusive", rf.isIncludeHigh());
        dateFilters = filter.getFiltersForDimension(EVENT_DATE);
        assertTrue("Should contain status dimension", filter.getDimensions().contains(STATUS));
    // Helper methods for assertions
        assertFalse(regionRange.isIncludeHigh());
        assertEquals(new BytesRef("eu-"), regionRange.getLow());
                    .should(
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new WildcardQueryBuilder(METHOD, "GET*"))
        KeywordFieldMapper.KeywordFieldType regionType = new KeywordFieldMapper.KeywordFieldType(REGION);
            .must(new TermQueryBuilder(METHOD, "GET"));
            );
    }
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        BoolQueryBuilder floatRangeQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(LATENCY).gt(0.5).lt(2.0))
    public void testInvalidFieldTypes() throws IOException {
        // multiple fields, second date clause will lowe minute granularity, overlapping intervals
            .should(new TermQueryBuilder(METHOD, "GET"));
        assertTrue(regionRange.isIncludeHigh());
            // exclusive bounds
        BoolQueryBuilder mustOnly = new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200));
        List<DimensionFilter> zoneFilters = filter.getFiltersForDimension(ZONE);
        assertTrue("Should contain method dimension", filter.getDimensions().contains(METHOD));
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
    }
        assertEquals("Should contain expected status values", expectedValues, actualValues);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
    public void testMustContainingShouldDifferentDimension() throws IOException {
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
    public void testRangeAndTermCombinations() throws IOException {
            assertEquals("Date lower bound should match", expectedLows[i], rf.getLow());
        assertTrue(regionRange.isIncludeHigh());
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
        assertEquals("Range upper bound should be 500", 500L, rangeFilter.get().getHigh());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertNotNull("Filter should not be null", filter);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
    }
            )
    }
            actualTimes.addAll(((ExactMatchDimFilter) timeFilter).getRawValues());
        assertExactMatchValue((ExactMatchDimFilter) statusFilters.getFirst(), 200L);
    private final String RESPONSE_TIME = "response_time";
import org.opensearch.search.startree.filter.DimensionFilter;
        Set<Object> expectedValues = Set.of(403L, 404L);
        assertTrue(latencyRange.isIncludeHigh());  // After using nextDown, bound becomes inclusive
    }
        assertTrue("All should be ExactMatchDimFilter", statusFilters.stream().allMatch(f -> f instanceof ExactMatchDimFilter));
 * The OpenSearch Contributors require contributions made to
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(unboundedQuery);
import java.util.Set;
        assertEquals(2, statusFilters.size());
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(200).lt(500))
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        }
            NumberFieldMapper.NumberType.INTEGER
        BoolQueryBuilder intersectionQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(REGION).gte("eu-").lt("eu-z"))
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
        // Verify date range filter
        List<DimensionFilter> regionFilters = filter.getFiltersForDimension(REGION);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(
        BoolQueryBuilder validBoolQuery = new BoolQueryBuilder().should(
        }
            .must(new BoolQueryBuilder().must(new BoolQueryBuilder()));
        // Verify method filter (from MUST)
            .must(
            assertTrue("Should be ExactMatchDimFilter", dimFilter instanceof ExactMatchDimFilter);
        assertNotNull("Filter should not be null", filter);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(mustOnly);
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
    public void testShouldWithSameDimensionRange() throws IOException {
    public void testShouldWithSameDimension() throws IOException {
                    randomIntBetween(1, 10_000),
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);
        assertNull("Filter should be null for empty SHOULD clause", filter);
        testDateFilters(dateFilters, "event_date_hour", new long[] { expectedFromMillis }, new long[] { expectedToMillis });
        String toDateStrHour = "2023-01-10T12:00:00.000Z";
    public void testMustInsideShould() throws IOException {
            null,
        // Test dimension that exists in mapping but not in star tree dimensions
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertEquals(new BytesRef("eu-m"), regionRange.getHigh());
        // Verify port filter
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder("non_existent_field", "value"))
            .must(
        testDateFilters(dateFilters, "event_date_minute", expectedLows, expectedHighs);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        BoolQueryBuilder combinedRangeQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        assertTrue("Port should be RangeMatchDimFilter", portFilters.getFirst() instanceof RangeMatchDimFilter);
    private final String PORT = "port";
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        // Test duplicate dimensions that should be merged/intersected
    public void testInvalidMustAndFilterCombination() throws IOException {
            if (statusFilter instanceof ExactMatchDimFilter) {
import java.util.Collections;
        StarTreeFilter filter = provider.getFilter(searchContext, unboundedQuery, compositeFieldType);
            assertTrue(timeFilter instanceof ExactMatchDimFilter);
        String fromDateStrHour = "2023-01-10T10:00:00.000Z";
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        // Verify date range filter
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        assertTrue(latencyRange.isIncludeLow());
        assertEquals("Lower bound should be 300", 300L, rangeFilter.getLow());
        RangeMatchDimFilter regionRange = (RangeMatchDimFilter) regionFilters.get(0);
            .must(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200)).should(new TermQueryBuilder(STATUS, 404)));
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
    public void testInvalidDimensionNames() throws IOException {
        // Test nested MUST inside SHOULD
        Optional<ExactMatchDimFilter> exactFilter = statusFilters.stream()
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
    private MapperService mapperService;
            .must(new TermQueryBuilder(STATUS, 200))
        // Test float range with different inclusivity combinations
    }
        assertEquals(443L, portRange.getHigh());
        assertNotNull("Filter should not be null", filter);
        assertEquals(new BytesRef(expectedValue), filter.getRawValues().getFirst());
        assertTrue("Method should be ExactMatchDimFilter", methodFilters.getFirst() instanceof ExactMatchDimFilter);
        assertEquals(NumericUtils.floatToSortableInt(0.5f), ((Number) latencyRange.getLow()).floatValue(), 0.0001);
 * SPDX-License-Identifier: Apache-2.0
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        List<DateTimeUnitRounding> intervals = Arrays.asList(
        List<DimensionFilter> dateFilters = filter.getFiltersForDimension("event_date");
    public void testKeywordRanges() throws IOException {
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        // Test combination of MUST and FILTER clauses
    }
            "star_tree",
        assertEquals(443L, portRange.getHigh());
    public void testFloatRanges_Intersection() throws IOException {
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
    }
            .must(
        assertEquals("Should have one filter for date", 1, dateFilters.size());
        assertEquals(expectedHigh, ((Number) latencyRange.getHigh()).longValue());
        assertTrue(latencyFilters.getFirst() instanceof RangeMatchDimFilter);
import java.util.Optional;
                new BoolQueryBuilder().should(new RangeQueryBuilder(LATENCY).gte(0.0).lt(1.0))
        when(mapperService.fieldType(PORT)).thenReturn(portType);
        assertEquals(expectedTimes, actualTimes);
 * this file be licensed under the Apache-2.0 license or a
    public void testMaximumNestingDepth() throws IOException {
            BoolQueryBuilder nested = new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200 + i));
            .should(new TermQueryBuilder(METHOD, "GET"));
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
        assertNotNull("Filter should not be null", filter);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        assertEquals("Should have two filters for status", 2, statusFilters.size());
        assertTrue(latencyFilters.getFirst() instanceof RangeMatchDimFilter);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(200).lt(300))  // 2xx status codes
        assertNull("Filter should be null for empty bool query", filter);
                    new DateDimension(EVENT_DATE, intervals, DateFieldMapper.Resolution.MILLISECONDS)
            .must(new RangeQueryBuilder(PORT).gte(80).lte(443))
        expectedMethod.add(new BytesRef("GET"));
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertEquals("Status should have expected values", expectedStatusValues, actualStatusValues);
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
        BoolQueryBuilder floatRangeQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(LATENCY).gte(0.5f).lte(2.0f))
        // MUST inside SHOULD for different dimension (should be rejected)
            null,
        filter = provider.getFilter(searchContext, nestedBoolQuery, compositeFieldType);
            null,
            new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrHour).lt(toDateStrHour).format(DATE_FORMAT)
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(200).lte(500))
        }
    }
        // Test single MUST clause
        assertTrue("Range upper bound should be inclusive", rangeFilter.get().isIncludeHigh());
        long expectedFromMillis = Instant.parse(fromDateStr).toEpochMilli();
        Set<Object> actualValues = new HashSet<>();
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);
        assertNotNull("Filter should not be null", filter);
            "non_star_tree_field",
            assertTrue("Should be ExactMatchDimFilter", dimFilter instanceof ExactMatchDimFilter);
            .map(f -> (RangeMatchDimFilter) f)
        String fromDateStrMin = "2023-01-10T10:30:00.000Z";
            .build();
        assertEquals("Lower bound should be 200", 200L, rangeFilter.getLow());
        // Verify zone filters
        assertTrue("Should have exact match filter", exactFilter.isPresent());
                    new BoolQueryBuilder().should(new TermQueryBuilder(ZONE, "us-east")).should(new TermQueryBuilder(ZONE, "us-west"))
        assertTrue("Both should be RangeMatchDimFilter", statusFilters.stream().allMatch(f -> f instanceof RangeMatchDimFilter));
            .should(new TermQueryBuilder(STATUS, 404));
            ExactMatchDimFilter exactFilter = (ExactMatchDimFilter) dimFilter;
        Set<Object> expectedMethod = new HashSet<>();
        String fromDateStr = "2023-01-10T10:00:00.000Z";
        assertTrue(portRange.isIncludeLow() && portRange.isIncludeHigh());
        assertEquals("Second range lower bound should be 400", 400L, secondRange.getLow());
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        // Test SHOULD clauses with different dimensions
import org.opensearch.common.util.BigArrays;
    }
        assertNotNull("Filter should not be null", filter);
        for (DimensionFilter timeFilter : responseTimeFilters) {
    }
                List.of(
import org.opensearch.index.mapper.WildcardFieldMapper;
    private final String ZONE = "zone";
                    Collections.emptySet(),
        );
            .filter(new TermQueryBuilder(STATUS, 404));  // Different value for same dimension
                List.of(new Metric("size", List.of(MetricStat.SUM))),
        );
        long expectedFromMillisSec = Instant.parse(fromDateStrSec).toEpochMilli();
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().mustNot(new TermQueryBuilder(STATUS, 200));
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
            .should(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrHour).lt(toDateStrHour).format(DATE_FORMAT))
import org.apache.lucene.util.BytesRef;
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        assertNull("Filter should be null for SHOULD across different dimensions", filter);
        expectedZones.add(new BytesRef("us-east"));
        assertExactMatchValue((ExactMatchDimFilter) statusFilters.getFirst(), 201L);
        // Test invalid combination - same dimension in MUST and FILTER
        long expectedToMillisSec = Instant.parse(toDateStrSec).toEpochMilli() - 1;
        Set<Object> actualValues = new HashSet<>();
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
    public void testFloatRanges() throws IOException {
            RangeMatchDimFilter rf = (RangeMatchDimFilter) dateFilters.get(i);
    public void testDuplicateDimensionsAcrossNesting() throws IOException {
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertNotNull("Filter should not be null", filter);
        dateFilters = filter.getFiltersForDimension(EVENT_DATE);
        assertNotNull("Filter should not be null", filter);
import java.util.Arrays;
        Set<Object> actualStatusValues = new HashSet<>(((ExactMatchDimFilter) statusFilters.getFirst()).getRawValues());
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
    public void testKeywordFieldTypeHandling() throws IOException {
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
    public void testEmptyMustClause() throws IOException {
        Set<Object> expectedZones = new HashSet<>();
        String fromDateStrSec = "2023-01-10T08:30:01.000Z";
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        for (DimensionFilter dimFilter : statusFilters) {
        regionRange = (RangeMatchDimFilter) regionFilters.get(0);
        latencyFilters = filter.getFiltersForDimension(LATENCY);
    private CompositeDataCubeFieldType compositeFieldType;
        IndexMetadata indexMetadata = IndexMetadata.builder("index")
        // Add field type for zone
        boolQuery.must(statusShould);
        // Test with unsupported field type
        testDateFilters(dateFilters, "event_date_minute", new long[] { expectedFromMillisMin }, new long[] { expectedToMillisHour });
    }
                new BoolQueryBuilder().must(new RangeQueryBuilder(PORT).gte(80).lte(443))
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(floatRangeQuery);
            .filter(new TermQueryBuilder(STATUS, 200))
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
            actualValues.addAll(((ExactMatchDimFilter) dimFilter).getRawValues());
        StarTreeFilter filter = provider.getFilter(searchContext, mustOnly, compositeFieldType);
        regionFilters = filter.getFiltersForDimension(REGION);
        boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        assertExactMatchValue((ExactMatchDimFilter) portFilters.getFirst(), 443L);
        assertEquals(4, responseTimeFilters.size());
        assertEquals("Should contain all expected status values", expectedValues, actualValues);
            () -> true,
        // Test unsupported query type in SHOULD
        long expectedLow = NumericUtils.floatToSortableInt(0.6f);
            actualZones.addAll(((ExactMatchDimFilter) portFilter).getRawValues());
        assertEquals(2, statusFilters.size());
        when(mapperService.fieldType(RESPONSE_TIME)).thenReturn(responseTimeType);
        assertEquals(expectedLow, ((Number) latencyRange.getLow()).longValue());
        assertEquals("Should have 3 filters for date", 3, dateFilters.size());
        assertTrue("First range upper bound should be inclusive", firstRange.isIncludeHigh());
        Set<Object> actualValues = new HashSet<>();
    public void testFloatRanges_Exclusive() throws IOException {
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
package org.opensearch.search.aggregations.startree;
                    new OrdinalDimension(PORT),
            .must(new TermQueryBuilder(STATUS, 200));
        assertFalse(regionRange.isIncludeLow());
    public void setup() throws IOException {
        assertEquals("Second range upper bound should be 500", 500L, secondRange.getHigh());
        assertEquals("Port upper bound should be 443", 443L, portRange.getHigh());
            // Specific success codes
        List<DimensionFilter> responseTimeFilters = filter.getFiltersForDimension(RESPONSE_TIME);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
        // Verify method filter (keyword terms query)
        StarTreeFilter filter = provider.getFilter(searchContext, floatRangeQuery, compositeFieldType);
import org.opensearch.index.compositeindex.datacube.DateDimension;
        when(mapperService.getCompositeFieldTypes()).thenReturn(Set.of(compositeFieldType));
        mapperService = mock(MapperService.class);
        assertEquals("Method should have one filter", 1, methodFilters.size());
        Set<Object> expectedStatusValues = Set.of(200L, 201L);
        // Test unsupported query type in MUST
        boolQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(200).lt(300))
        assertNotNull("Filter should not be null", filter);
            null,
            .must(new RangeQueryBuilder(REGION).gt("eu-a").lte("eu-m"));
        // Verify status filters (intersection of range and terms)
        assertEquals("Should have 1 filter for date", 1, dateFilters.size());
        // Test nested bool query with both MUST and FILTER clauses
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        // Verify response_time filters (all SHOULD conditions)
            .must(new TermsQueryBuilder(STATUS, Arrays.asList(200, 201)))
    public void testInvalidShouldClauses() throws IOException {
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
            .should(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 404)).should(new TermQueryBuilder(STATUS, 500)));
import org.junit.Before;
    }
        QueryShardContext queryShardContext = new QueryShardContext(
            .filter(new RangeQueryBuilder(PORT).gte(80).lte(443));
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
        assertNull("Filter should be null", filter);
        assertExactMatchValue((ExactMatchDimFilter) statusFilters.getFirst(), 200L);
        assertNull("Filter should be null for same dimension in MUST", filter);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200))
    public void testLargeNumberOfClauses() throws IOException {
import org.opensearch.common.settings.Settings;
    public void testMustWithDifferentQueryTypes() throws IOException {
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
import org.opensearch.Version;
import org.opensearch.index.compositeindex.datacube.MetricStat;
        when(mapperService.fieldType(ZONE)).thenReturn(zoneType);
        expectedPorts.add(9200L);
        Set<Object> expectedTimes = Set.of(100L, 200L, 300L, 400L);
        // dis-joint intervals
        RangeMatchDimFilter portRange = (RangeMatchDimFilter) portFilters.getFirst();
        long expectedToMillisHour = Instant.parse(toDateStrHour).toEpochMilli() - 1;
        assertEquals("Should have two dimensions", 2, filter.getDimensions().size());
            .should(new TermQueryBuilder(STATUS, 404))
        for (DimensionFilter statusFilter : statusFilters) {
        }
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
import org.opensearch.index.mapper.StarTreeMapper;
        long expectedHigh = NumericUtils.floatToSortableInt(FloatPoint.nextDown(2.0f));
        assertTrue("Lower bound should be inclusive", rangeFilter.isIncludeLow());
    }
            .should(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrSec).lt(toDateStrSec).format(DATE_FORMAT));
/*
    private final String REGION = "region";
    private final String EVENT_DATE = "event_date";
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        boolQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrSec).lt(toDateStrSec).format(DATE_FORMAT))
            );  // Set in nested bool
        RangeMatchDimFilter rangeFilter = (RangeMatchDimFilter) statusFilters.getFirst();
        assertEquals("First range upper bound should be 300", 300L, firstRange.getHigh());
            );
        String toDateStrSec = "2023-01-10T10:21:31.000Z";
        provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
import static org.mockito.Mockito.when;
        // first date clause will use min granularity, second date clause will use hour granularity
            assertTrue("Should be ExactMatchDimFilter", dimFilter instanceof ExactMatchDimFilter);
                    new OrdinalDimension(METHOD),
        NumberFieldMapper.NumberFieldType responseTimeType = new NumberFieldMapper.NumberFieldType(
            new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200)).must(new TermQueryBuilder(METHOD, "GET"))
        assertTrue("Should contain date-second dimension", filter.getDimensions().contains(EVENT_DATE));
        for (int i = 200; i < 300; i++) {
        // Verify method filter
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),
                )
            .must(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 201)).should(new TermQueryBuilder(STATUS, 204)))
        assertTrue(regionFilters.getFirst() instanceof RangeMatchDimFilter);
        assertEquals("Should have three dimensions", 3, filter.getDimensions().size());
        assertEquals("Should have two dimensions", 2, filter.getDimensions().size());
        assertEquals("Upper bound should be 400", 400L, rangeFilter.getHigh());
import java.time.Instant;
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
    public void testEmptyShouldClause() throws IOException {
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
        assertNull("Filter should be null for non-overlapping ranges", filter);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        assertNotNull("Filter should not be null", filter);
    }
        Set<Object> actualZones = new HashSet<>();
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
    }
            assertEquals("Date upper bound should match", expectedHighs[i], rf.getHigh());
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        assertExactMatchValue((ExactMatchDimFilter) portFilters.getFirst(), 443L);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermsQueryBuilder(METHOD, Arrays.asList("GET", "POST")))
        // Verify status filters (term OR range)
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200)).must(new TermQueryBuilder(STATUS, 404));
        // Verify method filter
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
    }
    }
        assertEquals("Should have 1 filter for date", 1, dateFilters.size());
        boolQuery = new BoolQueryBuilder().should(new WildcardQueryBuilder(STATUS, "2*")).should(new TermQueryBuilder(STATUS, 404));
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertNull("Filter should be null for unsupported query type", filter);
    }
        assertEquals(expectedStatus, actualStatus);
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);
        expectedHighs = new long[] { expectedToMillisMin, expectedToMillisHour, expectedToMillisSec };
        // Verify method filter
        long expectedToMillisMin = Instant.parse(toDateStrMin).toEpochMilli() - 1;
        assertEquals(2, portFilters.size());
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
                new BoolQueryBuilder().should(
    }
    private final String DATE_FORMAT = "strict_date_optional_time||epoch_millis";
        KeywordFieldMapper.KeywordFieldType zoneType = new KeywordFieldMapper.KeywordFieldType(ZONE);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
                assertEquals(599L, statusRange.getHigh());
        assertNull("Filter should be null when minimum_should_match is set", filter);
        when(mapperService.fieldType(STATUS)).thenReturn(statusType);
        }
    }
                    .must(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200)).should(new TermQueryBuilder(STATUS, 404)))
            indexSettings,
        long expectedFromMillisMin = Instant.parse(fromDateStrMin).toEpochMilli();
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        assertEquals(expectedZones, actualZones);
        List<DimensionFilter> regionFilters = filter.getFiltersForDimension(REGION);
        KeywordFieldMapper.KeywordFieldType zoneType = new KeywordFieldMapper.KeywordFieldType(ZONE);
        expectedMethod.add(new BytesRef("POST"));
import org.opensearch.index.query.RangeQueryBuilder;
    }
        assertTrue(latencyRange.isIncludeHigh());
            null,
        assertNotNull("Filter should not be null", filter);
        assertNotNull("Filter should not be null", filter);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        RangeMatchDimFilter latencyRange = (RangeMatchDimFilter) latencyFilters.getFirst();
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
        boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder("non_star_tree_field", 100)).must(new TermQueryBuilder(METHOD, "GET"));
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
        assertEquals("Should have 1 dimension", 1, filter.getDimensions().size());
        // Verify port filter
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
        assertEquals("Should have two filters for status", 2, statusFilters.size());
    }
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
            .must(new BoolQueryBuilder().should(new TermQueryBuilder(PORT, 80)).should(new TermQueryBuilder(PORT, 9200)));
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(floatRangeQuery);
        // Verify date range filter
        assertNull("Filter should be null for nested empty bool queries", filter);
        RangeMatchDimFilter latencyRange = (RangeMatchDimFilter) latencyFilters.getFirst();
            .must(new TermQueryBuilder(METHOD, "POST"));
        // Test with minimum_should_match set
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertNotNull("Filter should not be null", filter);
                    .should(new TermQueryBuilder(STATUS, 404))
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        searchContext = mock(SearchContext.class);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        assertNull("Filter should be null for multiple dimensions in MUST inside SHOULD", filter);
        // Verify date range filter
        // Test float range with different inclusivity combinations
        for (DimensionFilter dimFilter : statusFilters) {
        // Verify status filter
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        DateFieldMapper.DateFieldType eventDateFieldType = new DateFieldMapper.DateFieldType(EVENT_DATE);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(keywordRangeQuery);
    public void testMustWithMultipleDateFieldRanges() throws IOException {
        assertExactMatchValue((ExactMatchDimFilter) statusFilters.getFirst(), 200L);
        List<DimensionFilter> latencyFilters = filter.getFiltersForDimension(LATENCY);
        // Verify method filter
    }
        assertEquals("Should have 2 filter for date", 2, dateFilters.size());
        assertEquals(2, zoneFilters.size());
            .must(new TermQueryBuilder(STATUS, 200));
            .must(new TermQueryBuilder(METHOD, "GET"));
        RangeMatchDimFilter latencyRange = (RangeMatchDimFilter) latencyFilters.getFirst();
        assertNotNull("Filter should not be null", filter);
        );
            ExactMatchDimFilter exactFilter = (ExactMatchDimFilter) dimFilter;
        NumberFieldMapper.NumberFieldType portType = new NumberFieldMapper.NumberFieldType(PORT, NumberFieldMapper.NumberType.INTEGER);
            .map(f -> (ExactMatchDimFilter) f)
        assertEquals("Port should have one filter", 1, portFilters.size());
    }
        assertEquals("Should have two dimensions", 2, filter.getDimensions().size());
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        Set<Object> actualTimes = new HashSet<>();
        expectedLows = new long[] { expectedFromMillisMin, expectedFromMillisHour, expectedFromMillisSec };
    }
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
                    .minimumShouldMatch(1)
                    new BoolQueryBuilder().should(new TermQueryBuilder(RESPONSE_TIME, 100)).should(new TermQueryBuilder(RESPONSE_TIME, 200))
        RangeMatchDimFilter portRange = (RangeMatchDimFilter) portFilters.getFirst();
        // Verify method filter
    private final String METHOD = "method";
            .must(new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(300).lte(400)));
        boolQuery = new BoolQueryBuilder().should(
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        // Test single SHOULD clause
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(floatRangeQuery);
        // Test nested bool with minimum_should_match
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY),
        // Complex nested structure with both MUST and SHOULD
        assertNotNull("Filter should not be null", filter);
            actualStatusValues.addAll(exactFilter.getRawValues());
        assertEquals("Should have one filter for method", 1, methodFilters.size());
        assertTrue("Second range upper bound should be inclusive", secondRange.isIncludeHigh());
        // this should return null as must not clause is not supported
            assertTrue("Date lower bound should be inclusive", rf.isIncludeLow());
        // Verify filters
            );
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertEquals("Should have two filters for status", 2, statusFilters.size());
    }
        // Verify method filter
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"));
                    new OrdinalDimension(REGION),
        assertNull("Filter should be null for unsupported field type", filter);
        assertNull("Filter should be null when minimum_should_match is set in nested query", filter);
            }
        long expectedFromMillisSec = Instant.parse(fromDateStrSec).toEpochMilli();
        RangeMatchDimFilter portRange = (RangeMatchDimFilter) portFilters.getFirst();
            actualValues.addAll(exactFilter.getRawValues());
        }
        assertTrue("Range lower bound should be inclusive", rangeFilter.get().isIncludeLow());
        // Verify port filter
                RangeMatchDimFilter statusRange = (RangeMatchDimFilter) statusFilter;
        // Verify status filter
        }
        assertEquals("Should have four dimensions", 4, filter.getDimensions().size());
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        // Verify method filter (keyword term query)
        assertEquals("Should have two filters after intersection", 2, statusFilters.size());
        assertNotNull("Filter should not be null", filter);
        assertNotNull("Filter should not be null", filter);
        assertNull("Filter should be null", filter);
        for (DimensionFilter statusFilter : statusFilters) {
    private void assertExactMatchValue(ExactMatchDimFilter filter, String expectedValue) {
        compositeFieldType = new StarTreeMapper.StarTreeFieldType(
        testDateFilters(dateFilters, "event_date_second", expectedLows, expectedHighs);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
                    new OrdinalDimension(STATUS),
        testDateFilters(dateFilters, "event_date_second", new long[] { expectedFromMillisHour }, new long[] { expectedToMillisSec });
        filter = provider.getFilter(searchContext, intersectionQuery, compositeFieldType);
        Set<Object> actualValues = new HashSet<>();
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
            actualStatusValues.addAll(((ExactMatchDimFilter) statusFilter).getRawValues());
    public void testComplexNestedStructure() throws IOException {
        String fromDateStrSec = "2023-01-10T14:30:01.000Z";
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
    }
        when(mapperService.fieldType(METHOD)).thenReturn(methodType);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        boolQuery = new BoolQueryBuilder().must(new BoolQueryBuilder().must(new BoolQueryBuilder().must(new BoolQueryBuilder())));
        assertTrue("Should be ExactMatchDimFilter", methodFilters.getFirst() instanceof ExactMatchDimFilter);
        assertTrue("Port should be RangeMatchDimFilter", portFilters.getFirst() instanceof RangeMatchDimFilter);
        long[] expectedHighs = new long[] { expectedToMillisHour, expectedToMillisMin };
                    StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
            .should(new RangeQueryBuilder(STATUS).gte(400).lte(500));
        assertTrue(latencyRange.isIncludeLow());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        when(searchContext.getQueryShardContext()).thenReturn(queryShardContext);
        long expectedToMillisMin = Instant.parse(toDateStrMin).toEpochMilli() - 1;
        ExactMatchDimFilter methodFilter = (ExactMatchDimFilter) methodFilters.getFirst();
    public void testMustWithDateFieldRange() throws IOException {
        BoolQueryBuilder current = boolQuery;
        assertTrue(latencyFilters.getFirst() instanceof RangeMatchDimFilter);
        );
        BoolQueryBuilder boolQuery = new BoolQueryBuilder();
                    new OrdinalDimension(RESPONSE_TIME),
                    .must(new BoolQueryBuilder().must(new TermQueryBuilder(PORT, 443)))
                new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(200).lte(300))
        assertNotNull("Filter should not be null", filter);
        BoolQueryBuilder nestedBoolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
        for (DimensionFilter statusFilter : statusFilters) {
            .must(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrMin).lt(toDateStrMin).format(DATE_FORMAT));
    public void testNestedMustClauses() throws IOException {
        BoolQueryBuilder keywordRangeQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(REGION).gte("eu-").lt("eu-z"))
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);
 */
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
            assertTrue(statusFilter instanceof ExactMatchDimFilter);
        assertTrue("Should be ExactMatchDimFilter", portFilters.getFirst() instanceof ExactMatchDimFilter);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
        // Add 100 SHOULD clauses for status
    private final String STATUS = "status";
                            .should(new TermQueryBuilder(RESPONSE_TIME, 400))
        assertNull("Filter should be null for SHOULD with different dimensions", filter);
        // should on different fields
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
import java.util.List;
            assertTrue("Date filter should be RangeMatchDimFilter", dateFilters.get(i) instanceof RangeMatchDimFilter);
        }
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
        // Test range intersection
import org.opensearch.search.startree.filter.RangeMatchDimFilter;
        // Verify port filter
        assertEquals(NumericUtils.floatToSortableInt(2.0f), ((Number) latencyRange.getHigh()).floatValue(), 0.0001);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
                )
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
            .should(new RangeQueryBuilder(STATUS).gte(400).lte(500));
        assertEquals("Should have 2 dimension", 2, filter.getDimensions().size());
        }
    public void testNestedBoolWithMustAndFilter() throws IOException {
        assertExactMatchValue((ExactMatchDimFilter) filter.getFiltersForDimension(STATUS).get(0), 200L);
            new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200)).must(new TermQueryBuilder(METHOD, "GET"))
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        // Verify port filter (from FILTER)
        BoolQueryBuilder floatRangeQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(LATENCY).gt(0.5).lt(2.0))
            .must(
            .must(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrHour).lt(toDateStrHour).format(DATE_FORMAT));
    private SearchContext searchContext;
        assertEquals("Should have 1 dimension", 1, filter.getDimensions().size());
            .must(new BoolQueryBuilder().filter(new RangeQueryBuilder(STATUS).gte(200).lt(300)).must(new TermQueryBuilder(STATUS, 201)))
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
            .filter(f -> f instanceof ExactMatchDimFilter)
        assertEquals("Should have three dimensions", 3, filter.getDimensions().size());
        assertTrue("Should contain all dimensions", filter.getDimensions().containsAll(Set.of(METHOD, PORT, STATUS)));
        // Test empty bool query
    }
        for (DimensionFilter dimFilter : statusFilters) {
        Set<Object> expectedStatusValues = Set.of(200L, 201L);
        // Verify method filter
    public void testMustWithSameDimension() throws IOException {
        assertNotNull("Filter should not be null", filter);
        assertEquals("Should have two filters for status", 2, statusFilters.size());
import static org.mockito.Mockito.mock;
        // Test valid case - all clauses on same dimension
        assertNotNull("Filter should not be null", filter);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        filter = provider.getFilter(searchContext, shouldOnly, compositeFieldType);
                new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(
        assertEquals("Should have three filters", 3, statusFilters.size());
        NumberFieldMapper.NumberFieldType nonStarTreeField = new NumberFieldMapper.NumberFieldType(
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"));
import org.opensearch.index.query.TermQueryBuilder;
        for (int i = 0; i < dateFilters.size(); i++) {
        // Verify method filter (should be intersection of term and terms)
        assertEquals("Status should have two filters", 2, statusFilters.size());
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.get(0), "GET");
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200)).must(new TermQueryBuilder(STATUS, 404));
        ).should(new TermQueryBuilder(STATUS, 404));
        assertTrue("Should contain method dimension", filter.getDimensions().contains(METHOD));
        StarTreeFilter filter = provider.getFilter(searchContext, floatRangeQuery, compositeFieldType);
            new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrHour).lt(toDateStrHour).format(DATE_FORMAT)
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
            new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200)).must(new TermQueryBuilder(METHOD, "GET"))
    public void testMultipleLevelsMustNesting() throws IOException {
        RangeMatchDimFilter portRange = (RangeMatchDimFilter) portFilters.getFirst();
    }
        // Verify status filter
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertEquals("Should contain expected status values", expectedValues, actualValues);
        // Verify status filters
        RangeMatchDimFilter regionRange = (RangeMatchDimFilter) regionFilters.getFirst();
        assertNotNull("Filter should not be null", filter);
            .must(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStr).lt(toDateStr).format(DATE_FORMAT)); // Common OpenSearch date format
                ),
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertEquals("Should contain all expected values", expectedValues, actualValues);
        Set<Object> actualValues = new HashSet<>();
        BoolQueryBuilder unboundedQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(REGION).gt("eu-"))  // No upper bound
        assertNull(regionRange.getHigh());  // Unbounded high
                "star_tree",
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
            null,
        assertEquals(80L, portRange.getLow());
        assertNotNull("Filter should not be null", filter);
        assertTrue("Should contain date-hour dimension", filter.getDimensions().contains(EVENT_DATE));
import org.opensearch.search.startree.filter.provider.StarTreeFilterProvider;
            new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(200).lt(300)).must(new TermQueryBuilder(STATUS, 201))
        Set<Object> expectedValues = Set.of(201L, 404L);
            actualValues.addAll(((ExactMatchDimFilter) dimensionFilter).getRawValues());
        assertTrue("Should contain status dimension", filter.getDimensions().contains(STATUS));
    public void testCombinedMustAndFilterClauses() throws IOException {
            assertEquals("Sub-dimension should match", subDimension, rf.getSubDimensionName());
        String toDateStrSec = "2023-01-10T14:30:31.000Z";
        assertTrue("Should contain method dimension", filter.getDimensions().contains(METHOD));
import org.opensearch.search.startree.filter.StarTreeFilter;
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
                assertTrue(statusRange.isIncludeLow());
        // Verify port filter
            .must(new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200)).must(new TermQueryBuilder(PORT, 443)));
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);
        long expectedFromMillisMin = Instant.parse(fromDateStrMin).toEpochMilli();
    public void testShouldWithSameDimensionMixed() throws IOException {
        RangeMatchDimFilter secondRange = (RangeMatchDimFilter) statusFilters.get(1);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        // Build a deeply nested bool query
        assertEquals("Should have three dimensions", 3, filter.getDimensions().size());
    }
            RESPONSE_TIME,
        String toDateStrMin = "2023-01-10T12:30:00.000Z";
        assertEquals("Should have two filters", 2, statusFilters.size());
            )
            .filter(f -> f instanceof RangeMatchDimFilter)
            new StarTreeField(
                new BoolQueryBuilder().must(new RangeQueryBuilder(PORT).gte(80).lte(443))
        String toDateStrHour = "2023-02-10T12:00:00.000Z";
        assertTrue("Should be ExactMatchDimFilter", statusFilters.getFirst() instanceof ExactMatchDimFilter);
        assertEquals(2, latencyFilters.size());
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        assertNotNull("Filter should not be null", filter);
        assertNotNull("Filter should not be null", filter);
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);
    }
            assertTrue(dimFilter instanceof RangeMatchDimFilter);
        assertEquals(new BytesRef("eu-a"), regionRange.getLow());
        StarTreeFilter filter = provider.getFilter(searchContext, floatRangeQuery, compositeFieldType);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        KeywordFieldMapper.KeywordFieldType methodType = new KeywordFieldMapper.KeywordFieldType(METHOD);
        String fromDateStrHour = "2023-02-10T10:00:00.000Z";
            .numberOfReplicas(0)
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
            actualStatus.addAll(((ExactMatchDimFilter) statusFilter).getRawValues());
        String toDateStrMin = "2023-01-10T12:30:00.000Z";
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
    }
        assertNull("Filter should be null for MUST inside SHOULD", filter);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
    }
    }
    public void testMustInsideShouldDifferentDimensionRejected() throws IOException {
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals("Range lower bound should be 400", 400L, rangeFilter.get().getLow());
            .must(new TermQueryBuilder(STATUS, 200));
        Set<Object> actualStatusValues = new HashSet<>();
 *
        assertTrue("Should be RangeMatchDimFilter", statusFilters.getFirst() instanceof RangeMatchDimFilter);
        Set<Object> expectedStatusValues = Set.of(200L, 404L);
        // Verify date range filter
        long expectedFromMillisHour = Instant.parse(fromDateStrHour).toEpochMilli();
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
        for (DimensionFilter portFilter : portFilters) {
                )
            xContentRegistry(),
        // Test unbounded ranges
        NumberFieldMapper.NumberFieldType latencyType = new NumberFieldMapper.NumberFieldType(LATENCY, NumberFieldMapper.NumberType.FLOAT);
            // Range of region codes
    public void testKeywordRangeEdgeCases() throws IOException {
    private void testDateFilters(List<DimensionFilter> dateFilters, String subDimension, long[] expectedLows, long[] expectedHighs) {
            actualZones.addAll(((ExactMatchDimFilter) zoneFilter).getRawValues());
            statusShould.should(new TermQueryBuilder(STATUS, i));
        assertNotNull("Filter should not be null", filter);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
                    .should(new RangeQueryBuilder(LATENCY).gte(2.0).lt(3.0))
            ExactMatchDimFilter exactFilter = (ExactMatchDimFilter) dimFilter;
                    new OrdinalDimension(LATENCY),
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        for (DimensionFilter dimensionFilter : statusFilters) {
        // Create composite field type with dimensions
        WildcardFieldMapper.WildcardFieldType wildcardType = new WildcardFieldMapper.WildcardFieldType("wildcard_field");
    public void testMustContainingShouldSameDimension() throws IOException {
        assertNotNull("Filter should not be null", filter);
        Set<Object> expectedValues = Set.of(200L, 404L, 500L);
                assertTrue(statusRange.isIncludeHigh());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        // For exclusive bounds (gt/lt), we need to use next/previous float values
        assertNull("Filter should be null for non-star-tree dimension", filter);
            mapperService,
        when(mapperService.fieldType(REGION)).thenReturn(regionType);
    public void testAllClauseTypesCombined() throws IOException {
        assertTrue("Status should be ExactMatchDimFilter", statusFilters.getFirst() instanceof ExactMatchDimFilter);
            // Should intersect with range
        // Test deeply nested empty bool queries
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new RangeQueryBuilder(STATUS).gte(200).lte(300))
    private final String LATENCY = "latency";
    @Before
import org.opensearch.index.mapper.KeywordFieldMapper;
        long expectedFromMillisHour = Instant.parse(fromDateStrHour).toEpochMilli();
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new BoolQueryBuilder());
        Optional<RangeMatchDimFilter> rangeFilter = statusFilters.stream()
