        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new BoolQueryBuilder());
    public void testAllClauseTypesCombined() throws IOException {
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");  
        }
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
    }  
            }
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))  
        assertNull(regionRange.getHigh());  // Unbounded high
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
import org.opensearch.search.startree.filter.provider.StarTreeFilterProvider;  
    }
            .should(new RangeQueryBuilder(STATUS).gte(400).lte(500));
        assertTrue("Should be ExactMatchDimFilter", methodFilters.getFirst() instanceof ExactMatchDimFilter);
            // Success or 5xx errors  
                RangeMatchDimFilter statusRange = (RangeMatchDimFilter) statusFilter;
            .should(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrHour).lt(toDateStrHour).format(DATE_FORMAT))
import org.apache.lucene.document.FloatPoint;
            () -> randomNonNegativeLong(),
        assertEquals(new BytesRef(expectedValue), filter.getRawValues().getFirst());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        // Verify port filter
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
            .should(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrSec).lt(toDateStrSec).format(DATE_FORMAT));
    }  
        assertEquals("Should have two filters for status", 2, statusFilters.size());  
    }
        // MUST inside SHOULD for different dimension (should be rejected)  
        when(mapperService.fieldType(LATENCY)).thenReturn(latencyType);
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);  
        assertTrue(latencyFilters.getFirst() instanceof RangeMatchDimFilter);  
        // Test float range with different inclusivity combinations
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(validBoolQuery);
        long expectedToMillisHour = Instant.parse(toDateStrHour).toEpochMilli() - 1;
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
 *
    public void testEmptyShouldClause() throws IOException {  
            new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrHour).lt(toDateStrHour).format(DATE_FORMAT)  
            current.must(nested);
        KeywordFieldMapper.KeywordFieldType regionType = new KeywordFieldMapper.KeywordFieldType(REGION);  
        long expectedFromMillis = Instant.parse(fromDateStr).toEpochMilli();  
            .must(new TermQueryBuilder(METHOD, "POST"));  
import org.opensearch.index.query.TermsQueryBuilder;
        long expectedToMillisHour = Instant.parse(toDateStrHour).toEpochMilli() - 1;
            .filter(f -> f instanceof ExactMatchDimFilter)  
    }  
        assertNotNull("Filter should not be null", filter);
            .map(f -> (ExactMatchDimFilter) f)
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
    private final String STATUS = "status";
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);
        Set<Object> expectedPorts = new HashSet<>();
    }
        assertEquals(expectedHigh, ((Number) latencyRange.getHigh()).longValue());
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
    }
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);  
    public void testInvalidMustAndFilterCombination() throws IOException {
        assertEquals("Should have 1 dimension", 1, filter.getDimensions().size());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))  
        NumberFieldMapper.NumberFieldType portType = new NumberFieldMapper.NumberFieldType(PORT, NumberFieldMapper.NumberType.INTEGER);
        String fromDateStrMin = "2023-01-10T10:30:00.000Z";  
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        List<DimensionFilter> responseTimeFilters = filter.getFiltersForDimension(RESPONSE_TIME);  
        // Create a bool query with large number of SHOULD clauses  
        assertTrue("Upper bound should be exclusive", rangeFilter.isIncludeHigh());  
        assertNotNull("Filter should not be null", filter);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        regionFilters = filter.getFiltersForDimension(REGION);  
        Optional<RangeMatchDimFilter> rangeFilter = statusFilters.stream()
        assertEquals("Should have three filters", 3, statusFilters.size());
        // Add 100 SHOULD clauses for status  
        assertEquals("Status should have one filter", 1, statusFilters.size());  
        List<DateTimeUnitRounding> intervals = Arrays.asList(
        Set<Object> expectedValues = Set.of(201L, 404L);  
        // first date clause will use min granularity, second date clause will use hour granularity  
            actualZones.addAll(((ExactMatchDimFilter) zoneFilter).getRawValues());  
                    )
            .must(new RangeQueryBuilder(LATENCY).gte(0.6).lt(1.8))
        assertTrue("Should contain date-minute dimension", filter.getDimensions().contains(EVENT_DATE));
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        StarTreeFilter filter = provider.getFilter(searchContext, floatRangeQuery, compositeFieldType);  
        List<DimensionFilter> dateFilters = filter.getFiltersForDimension(EVENT_DATE);
        String fromDateStr = "2023-01-10T10:00:00.000Z";
        assertTrue(latencyRange.isIncludeHigh());  // After using nextDown, bound becomes inclusive
    @Before  
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertTrue(portRange.isIncludeLow() && portRange.isIncludeHigh());
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
            null
    public void testNestedMustClauses() throws IOException {
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        List<DimensionFilter> latencyFilters = filter.getFiltersForDimension(LATENCY);
        assertEquals("Should have 1 dimension", 1, filter.getDimensions().size());
        RangeMatchDimFilter regionRange = (RangeMatchDimFilter) regionFilters.getFirst();  
        testDateFilters(dateFilters, "event_date_minute", expectedLows, expectedHighs);
        // Verify date range filter  
        assertTrue(regionFilters.getFirst() instanceof RangeMatchDimFilter);
            );  
        assertExactMatchValue((ExactMatchDimFilter) statusFilters.getFirst(), 201L);
        Set<Object> expectedStatusValues = Set.of(200L, 404L);  
            actualValues.addAll(((ExactMatchDimFilter) dimensionFilter).getRawValues());
import org.opensearch.common.util.BigArrays;
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);  
import static org.mockito.Mockito.when;
    public void testInvalidDimensionNames() throws IOException {
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
    private final String EVENT_DATE = "event_date";
            .must(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrMin).lt(toDateStrMin).format(DATE_FORMAT));
        // Test single SHOULD clause  
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder();
        }
            actualValues.addAll(exactFilter.getRawValues());  
        Set<Object> expectedMethod = new HashSet<>();
        assertEquals("Port upper bound should be 443", 443L, portRange.getHigh());
        RangeMatchDimFilter latencyRange = (RangeMatchDimFilter) latencyFilters.getFirst();
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
        assertTrue("Should contain date-second dimension", filter.getDimensions().contains(EVENT_DATE));  
        // this should return null as same dimension in MUST is logically impossible
        // Test empty bool query  
        assertTrue(latencyFilters.getFirst() instanceof RangeMatchDimFilter);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        // first clause will use hour granularity, second clause will use minute granularity, overlapping intervals
        assertEquals(expectedLow, ((Number) latencyRange.getLow()).longValue());
        }  
                    new BoolQueryBuilder().should(new TermQueryBuilder(RESPONSE_TIME, 100)).should(new TermQueryBuilder(RESPONSE_TIME, 200))  
        assertEquals("Port lower bound should be 80", 80L, portRange.getLow());  
                    .should(new RangeQueryBuilder(LATENCY).gte(2.0).lt(3.0))  
        Set<Object> expectedStatus = Set.of(201L, 204L);
        boolQuery.must(statusShould);
            .must(new TermQueryBuilder(STATUS, 200));
import org.opensearch.index.mapper.CompositeDataCubeFieldType;  
        compositeFieldType = new StarTreeMapper.StarTreeFieldType(
        assertNull("Filter should be null for empty SHOULD clause", filter);  
        assertNotNull("Filter should not be null", filter);
    }
            BigArrays.NON_RECYCLING_INSTANCE,  
            .must(new TermQueryBuilder(METHOD, "GET"));  
        KeywordFieldMapper.KeywordFieldType methodType = new KeywordFieldMapper.KeywordFieldType(METHOD);  
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(200).lte(500))  
import org.junit.Before;
        assertTrue("Second range upper bound should be inclusive", secondRange.isIncludeHigh());  
        assertNotNull("Filter should not be null", filter);
        Set<Object> actualValues = new HashSet<>();
        assertEquals("Status should have two filters", 2, statusFilters.size());
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().mustNot(new TermQueryBuilder(STATUS, 200));
        assertNotNull("Filter should not be null", filter);  
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);  
 * compatible open source license.
        for (DimensionFilter dimFilter : statusFilters) {
        // For exclusive bounds (gt/lt), we need to use next/previous float values  
        assertEquals(new BytesRef("eu-z"), regionRange.getHigh());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(unboundedQuery);  
        assertNotNull("Filter should not be null", filter);
        ExactMatchDimFilter methodFilter = (ExactMatchDimFilter) methodFilters.getFirst();
        NumberFieldMapper.NumberFieldType nonStarTreeField = new NumberFieldMapper.NumberFieldType(
    }  
            .should(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 404)).should(new TermQueryBuilder(STATUS, 500)));
        assertEquals(expectedLow, ((Number) latencyRange.getLow()).longValue());
                    new OrdinalDimension(PORT),  
        regionRange = (RangeMatchDimFilter) regionFilters.get(0);
        assertEquals("Should have three dimensions", 3, filter.getDimensions().size());
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);  
        // SHOULD with different dimensions (should be rejected)
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
    public void testMustInsideShouldDifferentDimensionRejected() throws IOException {
    public void testFloatRanges() throws IOException {
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        assertNotNull("Filter should not be null", filter);
            null,
 * this file be licensed under the Apache-2.0 license or a
        List<DimensionFilter> dateFilters = filter.getFiltersForDimension(EVENT_DATE);
public class BoolStarTreeFilterProviderTests extends OpenSearchTestCase {
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))  
        BoolQueryBuilder shouldOnly = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200));
                        new BoolQueryBuilder().should(new TermQueryBuilder(RESPONSE_TIME, 300))  
        assertEquals("Should have two dimensions", 2, filter.getDimensions().size());
        // Test dimension that doesn't exist in mapping  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.SECOND_OF_MINUTE)
        Set<Object> actualStatus = new HashSet<>();  
            .must(new TermQueryBuilder(STATUS, 200));
            .must(new RangeQueryBuilder(PORT).gte(80).lte(443))
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
                    randomIntBetween(1, 10_000),  
        assertNotNull("Filter should not be null", filter);
        assertEquals("Method should have one filter", 1, methodFilters.size());  
    }
                    new OrdinalDimension(STATUS),
        Set<Object> expectedValues = Set.of(200L, 404L, 500L);
        assertNull("Filter should be null for nested empty bool queries", filter);
        assertEquals("Should have two filters for status", 2, statusFilters.size());
        assertEquals("Port lower bound should be 80", 80L, portRange.getLow());
            statusShould.should(new TermQueryBuilder(STATUS, i));  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
            .should(new TermQueryBuilder(METHOD, "GET"));  
        assertEquals("Second range upper bound should be 500", 500L, secondRange.getHigh());
            actualValues.addAll(((ExactMatchDimFilter) dimensionFilter).getRawValues());
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
            new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200)).must(new TermQueryBuilder(METHOD, "GET"))
import org.opensearch.Version;
    public void testShouldInsideShouldSameDimension() throws IOException {  
        BoolQueryBuilder floatRangeQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(LATENCY).gte(0.5f).lte(2.0f))
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))  
        // Build a deeply nested bool query
    public void testKeywordRanges() throws IOException {
        // Find and verify exact match filter
        mapperService = mock(MapperService.class);
        assertExactMatchValue((ExactMatchDimFilter) portFilters.getFirst(), 443L);  
import org.opensearch.index.mapper.NumberFieldMapper;
        RangeMatchDimFilter latencyRange = (RangeMatchDimFilter) latencyFilters.getFirst();
            .numberOfReplicas(0)  
            assertTrue("Should be ExactMatchDimFilter", dimFilter instanceof ExactMatchDimFilter);
    }
        long expectedLow = NumericUtils.floatToSortableInt(FloatPoint.nextUp(0.5f));
            )
                new BoolQueryBuilder().should(new RangeQueryBuilder(LATENCY).gte(0.0).lt(1.0))
        NumberFieldMapper.NumberFieldType latencyType = new NumberFieldMapper.NumberFieldType(LATENCY, NumberFieldMapper.NumberType.FLOAT);
            new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200)).must(new TermQueryBuilder(METHOD, "GET"))
    }  
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);  
        // Verify method filter (from MUST)
        when(mapperService.fieldType(STATUS)).thenReturn(statusType);  
        long expectedFromMillisHour = Instant.parse(fromDateStrHour).toEpochMilli();  
        for (DimensionFilter portFilter : portFilters) {
        for (int i = 0; i < dateFilters.size(); i++) {
import org.opensearch.index.query.QueryShardContext;
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);  
            .must(new TermsQueryBuilder(STATUS, Arrays.asList(200, 201)))  
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
        when(mapperService.getCompositeFieldTypes()).thenReturn(Set.of(compositeFieldType));  
        assertTrue("Upper bound should be inclusive", rangeFilter.isIncludeHigh());  
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);  
        assertTrue("Should be ExactMatchDimFilter", methodFilters.getFirst() instanceof ExactMatchDimFilter);  
        for (DimensionFilter dimFilter : statusFilters) {  
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertEquals(443L, portRange.getHigh());
        BoolQueryBuilder invalidBoolQuery = new BoolQueryBuilder().should(  
            mapperService,  
    }  
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
            .should(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrSec).lt(toDateStrSec).format(DATE_FORMAT));
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        // Verify date range filter
        RangeMatchDimFilter portRange = (RangeMatchDimFilter) portFilters.getFirst();  
            RangeMatchDimFilter rf = (RangeMatchDimFilter) dateFilters.get(i);  
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
        assertTrue("Port should be RangeMatchDimFilter", portFilters.getFirst() instanceof RangeMatchDimFilter);
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
    private final String REGION = "region";  
        assertNull("Filter should be null for MUST inside SHOULD", filter);  
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);  
        // Test invalid case - multiple dimensions in MUST inside SHOULD
            assertEquals("Sub-dimension should match", subDimension, rf.getSubDimensionName());
    public void testDeepNestedShouldClauses() throws IOException {
        assertEquals("Should have one filter after intersection", 1, statusFilters.size());
import org.opensearch.index.mapper.MapperService;  
            .should(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 404)).should(new TermQueryBuilder(STATUS, 500)));
        assertEquals("Should contain expected status values", expectedStatusValues, actualStatusValues);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);  
                    new BoolQueryBuilder().should(new TermQueryBuilder(ZONE, "us-east")).should(new TermQueryBuilder(ZONE, "us-west"))  
        }  
        BoolQueryBuilder nestedBoolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
                    .must(new BoolQueryBuilder().must(new TermQueryBuilder(PORT, 443)))
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
        ).should(new TermQueryBuilder(STATUS, 404));  
        // Verify port filter  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))  
        BoolQueryBuilder mustOnly = new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200));  
                    .should(new TermQueryBuilder(STATUS, 404))
import org.opensearch.index.mapper.StarTreeMapper;
            .numberOfShards(1)
            assertTrue(timeFilter instanceof ExactMatchDimFilter);
        assertTrue(latencyRange.isIncludeHigh());  
    }
        );  
        long expectedFromMillisSec = Instant.parse(fromDateStrSec).toEpochMilli();
        assertTrue("Should contain method dimension", filter.getDimensions().contains(METHOD));  
    }
            new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200)).must(new TermQueryBuilder(METHOD, "GET"))
                new BoolQueryBuilder().should(
            .should(new TermQueryBuilder(STATUS, 404))
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
/*  
import org.opensearch.index.compositeindex.datacube.MetricStat;  
            .must(
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
    private CompositeDataCubeFieldType compositeFieldType;
            .must(new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(300).lte(400)));
        assertEquals(expectedTimes, actualTimes);
        assertNotNull("Filter should not be null", filter);  
        assertNull("Filter should be null for same dimension in MUST", filter);  
        expectedLows = new long[] { expectedFromMillisMin, expectedFromMillisHour, expectedFromMillisSec };
        assertTrue("Lower bound should be exclusive", rangeFilter.isIncludeLow());
            null,
        // Test deeply nested empty bool queries
        // Verify status filters
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertEquals("First range lower bound should be 200", 200L, firstRange.getLow());
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
                assertTrue(statusRange.isIncludeHigh());  
    }  
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        assertExactMatchValue((ExactMatchDimFilter) filter.getFiltersForDimension(STATUS).get(0), 200L);
        BoolQueryBuilder floatRangeQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(LATENCY).gt(0.5).lt(2.0))  
        assertTrue(portRange.isIncludeLow() && portRange.isIncludeHigh());  
        assertNull("Filter should be null for empty bool query", filter);
        assertTrue("Port should be RangeMatchDimFilter", portFilters.getFirst() instanceof RangeMatchDimFilter);
        assertNull("Filter should be null when minimum_should_match is set in nested query", filter);
        assertTrue("Status should be ExactMatchDimFilter", statusFilters.getFirst() instanceof ExactMatchDimFilter);  
    }
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
    }  
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        assertEquals("Should contain expected values", expectedValues, actualValues);  
        assertEquals("Status should have expected values", expectedStatusValues, actualStatusValues);  
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
            .findFirst();
        boolQuery = new BoolQueryBuilder().should(
    }
        NumberFieldMapper.NumberFieldType statusType = new NumberFieldMapper.NumberFieldType(STATUS, NumberFieldMapper.NumberType.INTEGER);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
    public void testMustNotClauseReturnsNull() throws IOException {
            assertEquals("Date upper bound should match", expectedHighs[i], rf.getHigh());  
                ),  
        for (DimensionFilter statusFilter : statusFilters) {
    public void testDuplicateDimensionsAcrossNesting() throws IOException {
        Set<Object> actualValues = new HashSet<>();
    // Helper methods for assertions
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
    }
        // Test nested bool with minimum_should_match
            )
        boolQuery = new BoolQueryBuilder().should(
        assertExactMatchValue((ExactMatchDimFilter) portFilters.getFirst(), 443L);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder();
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);
        assertTrue(latencyRange.isIncludeLow());  
        assertNull("Filter should be null for SHOULD across different dimensions", filter);
    public void testMustWithDifferentQueryTypes() throws IOException {
        assertEquals("Should have two dimensions", 2, filter.getDimensions().size());
        RangeMatchDimFilter portRange = (RangeMatchDimFilter) portFilters.getFirst();
        assertTrue("Should contain method dimension", filter.getDimensions().contains(METHOD));
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
            .must(new BoolQueryBuilder().should(new TermQueryBuilder(PORT, 80)).should(new TermQueryBuilder(PORT, 9200)));  
            .build();
        List<DimensionFilter> latencyFilters = filter.getFiltersForDimension(LATENCY);
        assertEquals("Should have 2 dimension", 2, filter.getDimensions().size());  
        assertExactMatchValue((ExactMatchDimFilter) filter.getFiltersForDimension(STATUS).get(0), 200L);
            // Should intersect with range
        assertEquals("Should contain all expected status values", expectedValues, actualValues);  
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.get(0), "GET");  
        assertNotNull("Filter should not be null", filter);
    public void testSimpleMustWithMultipleDimensions() throws IOException {  
            null,  
    private SearchContext searchContext;
            actualStatusValues.addAll(exactFilter.getRawValues());
import org.opensearch.index.query.RangeQueryBuilder;  
        long expectedToMillisMin = Instant.parse(toDateStrMin).toEpochMilli() - 1;  
        long expectedFromMillisSec = Instant.parse(fromDateStrSec).toEpochMilli();
 */  
        boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(METHOD, "GET"))
        assertTrue("Should have exact match filter", exactFilter.isPresent());  
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.startree.filter.DimensionFilter;
        assertTrue("All should be ExactMatchDimFilter", statusFilters.stream().allMatch(f -> f instanceof ExactMatchDimFilter));
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"));
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());  
        // dis-joint intervals  
            actualStatusValues.addAll(((ExactMatchDimFilter) statusFilter).getRawValues());
        Set<Object> expectedZones = new HashSet<>();
    public void testShouldWithSameDimensionRange() throws IOException {
            // Range of region codes  
        assertEquals(2, latencyFilters.size());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(keywordRangeQuery);  
            );
    }  
        assertNull("Filter should be null for empty bool query", filter);
    public void testCombinedMustAndFilterClauses() throws IOException {
        );  
    public void testMustInsideShould() throws IOException {
            actualStatus.addAll(((ExactMatchDimFilter) statusFilter).getRawValues());  
                new BoolQueryBuilder().must(new RangeQueryBuilder(PORT).gte(80).lte(443))  
    public void testFloatRanges_Intersection() throws IOException {
        // Verify port filter (keyword SHOULD terms)
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
            null,
            ExactMatchDimFilter exactFilter = (ExactMatchDimFilter) dimFilter;
        assertEquals(80L, portRange.getLow());
                    new DateDimension(EVENT_DATE, intervals, DateFieldMapper.Resolution.MILLISECONDS)
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        assertTrue("Should be ExactMatchDimFilter", portFilters.getFirst() instanceof ExactMatchDimFilter);
            .must(new TermQueryBuilder(METHOD, "GET"));
            assertTrue("Should be ExactMatchDimFilter", dimFilter instanceof ExactMatchDimFilter);
        }
        // Verify method filter
    private void assertExactMatchValue(ExactMatchDimFilter filter, Long expectedValue) {
        assertNull("Filter should be null for conflicting conditions", filter);
        assertExactMatchValue((ExactMatchDimFilter) statusFilters.getFirst(), 200L);  
        // Verify status filters (term OR range)
                    .must(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200)).should(new TermQueryBuilder(STATUS, 201)))  
        for (DimensionFilter dimensionFilter : statusFilters) {
        assertEquals("Should have two dimensions", 2, filter.getDimensions().size());
    }  
        assertTrue("Both should be ExactMatchDimFilter", statusFilters.stream().allMatch(f -> f instanceof ExactMatchDimFilter));  
        RangeMatchDimFilter regionRange = (RangeMatchDimFilter) regionFilters.get(0);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200)).must(new TermQueryBuilder(STATUS, 404));  
        dateFilters = filter.getFiltersForDimension(EVENT_DATE);  
        KeywordFieldMapper.KeywordFieldType zoneType = new KeywordFieldMapper.KeywordFieldType(ZONE);  
        RangeMatchDimFilter portRange = (RangeMatchDimFilter) portFilters.getFirst();
        BoolQueryBuilder keywordRangeQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(REGION).gte("eu-").lt("eu-z"))
        }
        assertNull("Filter should be null for non-existent dimension", filter);
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertNotNull("Filter should not be null", filter);
        assertEquals(expectedZones, actualZones);
    private final String ZONE = "zone";  
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "POST");  
        StarTreeFilter filter = provider.getFilter(searchContext, mustOnly, compositeFieldType);  
        long expectedHigh = NumericUtils.floatToSortableInt(FloatPoint.nextDown(1.8f));
        BoolQueryBuilder combinedRangeQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))  
        assertNull("Filter should be null for unsupported query type in SHOULD", filter);  
        // Verify status filter
            .must(  
        assertTrue("Second range lower bound should be inclusive", secondRange.isIncludeLow());
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
            .must(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStr).lt(toDateStr).format(DATE_FORMAT)); // Common OpenSearch date format
        assertNull("Filter should be null for MUST inside SHOULD", filter);
            .must(new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200)).must(new TermQueryBuilder(PORT, 443)));
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        Set<Object> expectedStatusValues = Set.of(200L, 201L);
            .must(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200)).should(new RangeQueryBuilder(STATUS).gte(500).lt(600)))
        // Test with minimum_should_match set  
            assertTrue("Date upper bound should be inclusive", rf.isIncludeHigh());
    }  
        }
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder("wildcard_field", "value"))
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
            .should(new RangeQueryBuilder(STATUS).gte(400).lte(500));  
        BoolQueryBuilder statusShould = new BoolQueryBuilder();
        assertNotNull("Filter should not be null", filter);
            .must(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 404)).should(new TermQueryBuilder(STATUS, 403)));
        assertTrue("Should contain date-hour dimension", filter.getDimensions().contains(EVENT_DATE));  
                    .minimumShouldMatch(1)  
        boolQuery = new BoolQueryBuilder().should(new WildcardQueryBuilder(STATUS, "2*")).should(new TermQueryBuilder(STATUS, 404));  
    }
        boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder("non_star_tree_field", 100)).must(new TermQueryBuilder(METHOD, "GET"));
    }  
        KeywordFieldMapper.KeywordFieldType zoneType = new KeywordFieldMapper.KeywordFieldType(ZONE);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))  
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertEquals("Method should have one filter", 1, methodFilters.size());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
            ExactMatchDimFilter exactFilter = (ExactMatchDimFilter) dimFilter;
        );
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
import org.opensearch.index.query.TermQueryBuilder;
        assertEquals(2, portFilters.size());  
            .minimumShouldMatch(2);  // Explicitly set minimum_should_match  
        for (DimensionFilter dimensionFilter : statusFilters) {  
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),
        Set<Object> actualStatusValues = new HashSet<>(((ExactMatchDimFilter) statusFilters.getFirst()).getRawValues());
        Set<Object> actualStatusValues = new HashSet<>();
    }
        Set<Object> actualZones = new HashSet<>();
            } else {
import org.opensearch.index.mapper.DateFieldMapper;
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new RangeQueryBuilder(STATUS).gte(200).lte(300))
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
            assertTrue("Should be ExactMatchDimFilter", dimFilter instanceof ExactMatchDimFilter);  
        when(mapperService.fieldType(ZONE)).thenReturn(zoneType);  
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        RangeMatchDimFilter latencyRange = (RangeMatchDimFilter) latencyFilters.getFirst();
    }
        String fromDateStrSec = "2023-01-10T08:30:01.000Z";
            .filter(new TermQueryBuilder(STATUS, 404));  // Different value for same dimension
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);  
        assertNotNull("Filter should not be null", filter);  
            .must(new TermsQueryBuilder(METHOD, Arrays.asList("GET", "POST"))); // This should intersect with first method term
        long expectedFromMillisMin = Instant.parse(fromDateStrMin).toEpochMilli();
        // Verify port range  
    public void testMustWithSameDimension() throws IOException {
        WildcardFieldMapper.WildcardFieldType wildcardType = new WildcardFieldMapper.WildcardFieldType("wildcard_field");
    }  
import org.opensearch.search.startree.filter.RangeMatchDimFilter;
        Set<Object> expectedTimes = Set.of(100L, 200L, 300L, 400L);
        assertEquals(100, statusFilters.size());
        for (DimensionFilter dimFilter : statusFilters) {  
import org.opensearch.index.mapper.WildcardFieldMapper;  
        expectedMethod.add(new BytesRef("GET"));  
    private final String PORT = "port";
        ).should(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrMin).lt(toDateStrMin).format(DATE_FORMAT));
        String fromDateStrHour = "2023-02-10T10:00:00.000Z";
import org.opensearch.common.Rounding;  
                assertTrue(statusRange.isIncludeLow());
        // Verify status filter
            .must(new BoolQueryBuilder().must(new BoolQueryBuilder()));
        assertEquals("Should have two filters after intersection", 2, statusFilters.size());
        assertEquals(expectedMethod, new HashSet<>(methodFilter.getRawValues()));
            .must(
        // Verify method filter
        expectedHighs = new long[] { expectedToMillisMin, expectedToMillisHour, expectedToMillisSec };
    public void testInvalidMustClauses() throws IOException {  
        assertNotNull("Filter should not be null", filter);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200))
                )  
            .must(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrSec).lt(toDateStrSec).format(DATE_FORMAT))
        // Verify date range filter
        assertEquals(2, statusFilters.size());  
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        long expectedToMillisMin = Instant.parse(toDateStrMin).toEpochMilli() - 1;  
        assertNotNull("Filter should not be null", filter);  
        String toDateStrSec = "2023-01-10T14:30:31.000Z";  
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertNotNull("Filter should not be null", filter);
        filter = provider.getFilter(searchContext, combinedRangeQuery, compositeFieldType);  
        RangeMatchDimFilter firstRange = (RangeMatchDimFilter) statusFilters.getFirst();
        }
        assertExactMatchValue((ExactMatchDimFilter) statusFilters.getFirst(), 200L);  
        long expectedToMillisSec = Instant.parse(toDateStrSec).toEpochMilli() - 1;
                new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
    }
            .must(new TermQueryBuilder(STATUS, 200));
        List<DimensionFilter> regionFilters = filter.getFiltersForDimension(REGION);
    private MapperService mapperService;  
        assertTrue("Should contain status dimension", filter.getDimensions().contains(STATUS));
        assertEquals(new BytesRef("eu-a"), regionRange.getLow());
        assertTrue(latencyRange.isIncludeHigh());
    public void testShouldWithDifferentDimensions() throws IOException {  
import org.opensearch.cluster.metadata.IndexMetadata;
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
}
    public void testInvalidShouldClauses() throws IOException {
            NumberFieldMapper.NumberType.INTEGER  
        assertTrue("Should contain date-minute dimension", filter.getDimensions().contains(EVENT_DATE));
            xContentRegistry(),  
        assertNotNull("Filter should not be null", filter);
        assertTrue(regionRange.isIncludeHigh());  
        assertEquals("Should contain expected status values", expectedValues, actualValues);
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
        when(mapperService.fieldType(REGION)).thenReturn(regionType);
            assertTrue(statusFilter instanceof ExactMatchDimFilter);
        for (DimensionFilter statusFilter : statusFilters) {
    private void testDateFilters(List<DimensionFilter> dateFilters, String subDimension, long[] expectedLows, long[] expectedHighs) {  
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(mustOnly);
    private void assertExactMatchValue(ExactMatchDimFilter filter, String expectedValue) {  
        }
                "star_tree",
                    new OrdinalDimension(LATENCY),  
            NumberFieldMapper.NumberType.INTEGER  
        assertNotNull("Filter should not be null", filter);  
        assertExactMatchValue((ExactMatchDimFilter) statusFilters.getFirst(), 200L);
            .must(new RangeQueryBuilder(STATUS).gte(400).lt(500));
        assertEquals("Should have three dimensions", 3, filter.getDimensions().size());
            new StarTreeField(
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new BoolQueryBuilder())
    public void testLargeNumberOfClauses() throws IOException {
        expectedPorts.add(9200L);  
        assertEquals(443L, portRange.getHigh());
        String fromDateStrMin = "2023-01-10T10:30:00.000Z";  
        // Verify second range
import java.util.List;  
        assertNotNull("Filter should not be null", filter);  
        );
package org.opensearch.search.aggregations.startree;
        // Verify method filter
            null,
        when(mapperService.fieldType("wildcard_field")).thenReturn(wildcardType);  
        );  
import org.opensearch.index.compositeindex.datacube.Metric;
    public void testMustWithDateFieldRange() throws IOException {  
    }
        expectedPorts.add(80L);
        assertEquals(NumericUtils.floatToSortableInt(2.0f), ((Number) latencyRange.getHigh()).floatValue(), 0.0001);
            actualTimes.addAll(((ExactMatchDimFilter) timeFilter).getRawValues());  
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        assertNotNull("Filter should not be null", filter);
        assertEquals("Should have 1 filter for date", 1, dateFilters.size());  
        filter = provider.getFilter(searchContext, nestedBoolQuery, compositeFieldType);  
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
    public void testMaximumNestingDepth() throws IOException {  
        StarTreeFilter filter = provider.getFilter(searchContext, floatRangeQuery, compositeFieldType);
        long[] expectedHighs = new long[] { expectedToMillisHour, expectedToMillisMin };  
        // Verify status filter
import java.util.Set;
        assertNull("Filter should be null for same dimension in MUST", filter);
        for (DimensionFilter dimFilter : statusFilters) {
            actualValues.addAll(((ExactMatchDimFilter) dimFilter).getRawValues());
        // Setup common test dependencies
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        for (DimensionFilter dimFilter : latencyFilters) {
            new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrHour).lt(toDateStrHour).format(DATE_FORMAT)  
    }
            indexSettings,
        }
            assertTrue(dimFilter instanceof RangeMatchDimFilter);  
        assertTrue("Should be ExactMatchDimFilter", statusFilters.getFirst() instanceof ExactMatchDimFilter);
                    new OrdinalDimension(METHOD),
            .must(new TermQueryBuilder(METHOD, "GET"));
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
import org.opensearch.index.IndexSettings;  
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
        DateFieldMapper.DateFieldType eventDateFieldType = new DateFieldMapper.DateFieldType(EVENT_DATE);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"));
        assertNotNull("Filter should not be null", filter);
            .filter(new TermQueryBuilder(PORT, 443));
        assertEquals("Range upper bound should be 500", 500L, rangeFilter.get().getHigh());
    public void testKeywordFieldTypeHandling() throws IOException {  
            );
        assertNotNull("Filter should not be null", filter);
    }  
        assertNull("Filter should not be null", filter);
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(
            writableRegistry(),
        assertEquals("Second range lower bound should be 400", 400L, secondRange.getLow());  
        assertEquals(new BytesRef("eu-"), regionRange.getLow());
                    new OrdinalDimension(RESPONSE_TIME),
        String toDateStrHour = "2023-02-10T12:00:00.000Z";
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
    }
        assertNotNull("Filter should not be null", filter);  
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);  
        BoolQueryBuilder current = boolQuery;
        BoolQueryBuilder validBoolQuery = new BoolQueryBuilder().should(
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        Set<Object> actualStatusValues = new HashSet<>();
        RangeMatchDimFilter rangeFilter = (RangeMatchDimFilter) statusFilters.getFirst();
        // Test unsupported query type in SHOULD
            .must(new RangeQueryBuilder(PORT).gte(80).lte(443));
        assertEquals("Should have 1 dimension", 1, filter.getDimensions().size());
    public void setup() throws IOException {
            actualValues.addAll(exactFilter.getRawValues());  
        // Test invalid combination - same dimension in MUST and FILTER  
        assertNotNull("Filter should not be null", filter);
    public void testMalformedQueries() throws IOException {
        // Find and verify range filter  
        // first clause will use hour granularity, second clause will use minute granularity
        Set<Object> actualZones = new HashSet<>();
        assertTrue("Range lower bound should be inclusive", rangeFilter.get().isIncludeLow());
            .should(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrMin).lt(toDateStrMin).format(DATE_FORMAT))  
        assertEquals("Port should have one filter", 1, portFilters.size());
        }
    }
        StarTreeFilter filter = provider.getFilter(searchContext, validBoolQuery, compositeFieldType);  
                new BoolQueryBuilder().must(
                    .should(
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
    }
            .must(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrHour).lt(toDateStrHour).format(DATE_FORMAT));  
        // Verify first range  
        assertNotNull("Filter should not be null", filter);  
    public void testMultipleLevelsMustNesting() throws IOException {
    public void testSingleClauseBoolQueries() throws IOException {
        testDateFilters(dateFilters, "event_date_second", expectedLows, expectedHighs);
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        assertTrue(latencyFilters.getFirst() instanceof RangeMatchDimFilter);  
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
            .must(new BoolQueryBuilder().filter(new RangeQueryBuilder(STATUS).gte(200).lt(300)).must(new TermQueryBuilder(STATUS, 201)))  
import java.util.Collections;
    public void testEmptyNestedBools() throws IOException {  
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertEquals("Should have 3 filters for date", 3, dateFilters.size());
    }
        String toDateStrMin = "2023-01-10T12:30:00.000Z";
        assertFalse(regionRange.isIncludeLow());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        }
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(floatRangeQuery);
            );  // Set in nested bool
        Optional<ExactMatchDimFilter> exactFilter = statusFilters.stream()
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertEquals(new BytesRef("eu-"), regionRange.getLow());  
    }
        assertEquals("Should have four dimensions", 4, filter.getDimensions().size());  
                    Collections.emptySet(),
        assertEquals(expectedHigh, ((Number) latencyRange.getHigh()).longValue());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);  
                    new OrdinalDimension(REGION),
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);
        StarTreeFilter filter = provider.getFilter(searchContext, keywordRangeQuery, compositeFieldType);
import org.opensearch.index.mapper.KeywordFieldMapper;
        assertTrue("First range upper bound should be inclusive", firstRange.isIncludeHigh());
                assertEquals(200L, ((ExactMatchDimFilter) statusFilter).getRawValues().getFirst());  
        // Test nested MUST inside SHOULD  
        assertEquals("Status should have expected values", expectedStatusValues, actualStatusValues);  
        assertNull("Filter should be null when minimum_should_match is set", filter);
        assertEquals("Should have 2 filter for date", 2, dateFilters.size());  
        assertTrue("Should have range filter", rangeFilter.isPresent());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertEquals(expectedPorts, actualZones);
        when(mapperService.fieldType(EVENT_DATE)).thenReturn(eventDateFieldType); // Map the date field  
    }  
    }  
        provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        Set<Object> expectedValues = Set.of(200L, 404L);
            .filter(f -> f instanceof RangeMatchDimFilter)
        assertTrue(latencyRange.isIncludeLow());
    }
        String fromDateStrSec = "2023-01-10T14:30:01.000Z";
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
        // Add field type for zone
            // exclusive bounds
        boolQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(200).lt(300))
        assertNull("Filter should be null for unsupported field type", filter);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);  
                new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(200).lte(300))
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        // Verify status filter (intersection of range and term)
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull("Filter should not be null", filter);  
        assertTrue("Should contain all dimensions", filter.getDimensions().containsAll(Set.of(METHOD, PORT, STATUS)));  
import java.io.IOException;
        assertExactMatchValue((ExactMatchDimFilter) portFilters.getFirst(), 443L);
        assertEquals(4, responseTimeFilters.size());
        // Create composite field type with dimensions
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
        // Setup field types
        // For exclusive bounds (gt/lt), we need to use next/previous float values  
        assertNull("Filter should be null for empty nested bool queries", filter);
        // Verify method filter (keyword term query)
    public void testNestedBoolWithMustAndFilter() throws IOException {  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))  
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
            .must(
    public void testInvalidFieldTypes() throws IOException {  
            .must(
            BoolQueryBuilder nested = new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200 + i));  
        assertEquals("Should have three dimensions", 3, filter.getDimensions().size());
        // Test SHOULD clauses with different dimensions  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new WildcardQueryBuilder(METHOD, "GET*"))  
        // Verify method filter (keyword terms query)
        when(mapperService.fieldType(PORT)).thenReturn(portType);
        ).should(new TermQueryBuilder(STATUS, 404));
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        IndexMetadata indexMetadata = IndexMetadata.builder("index")  
        StarTreeFilter filter = provider.getFilter(searchContext, floatRangeQuery, compositeFieldType);
    }
        Set<Object> actualTimes = new HashSet<>();  
            new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrMin).lt(toDateStrMin).format(DATE_FORMAT)
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
            new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(200).lt(300)).must(new TermQueryBuilder(STATUS, 201))
        String toDateStrSec = "2023-01-10T10:21:31.000Z";  
        assertNotNull("Filter should not be null", filter);  
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());  
        filter = provider.getFilter(searchContext, invalidBoolQuery, compositeFieldType);
        assertEquals("First range upper bound should be 300", 300L, firstRange.getHigh());  
        assertTrue("Should contain date-second dimension", filter.getDimensions().contains(EVENT_DATE));
        when(searchContext.getQueryShardContext()).thenReturn(queryShardContext);
        long expectedFromMillisHour = Instant.parse(fromDateStrHour).toEpochMilli();  
        String toDateStrHour = "2023-01-10T12:00:00.000Z";
        List<DimensionFilter> dateFilters = filter.getFiltersForDimension("event_date");
        long expectedToMillis = Instant.parse(toDateStr).toEpochMilli() - 1;
            );  
import static org.mockito.Mockito.mock;
        // Verify status filters (intersection of range and terms)
        // Verify port filter (from FILTER)
        assertEquals("Upper bound should be 400", 400L, rangeFilter.getHigh());
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        assertEquals(NumericUtils.floatToSortableInt(0.5f), ((Number) latencyRange.getLow()).floatValue(), 0.0001);  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(
import org.opensearch.index.query.BoolQueryBuilder;
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(200).lt(300))  // 2xx status codes  
        }  
    }
        latencyFilters = filter.getFiltersForDimension(LATENCY);  
                )
        for (int i = 200; i < 300; i++) {
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
    public void testShouldWithSameDimensionMixed() throws IOException {  
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY),  
    public void testComplexMustWithNestedShould() throws IOException {
import org.apache.lucene.util.NumericUtils;  
                List.of(  
        Set<Object> actualValues = new HashSet<>();
        // should on different fields
        testDateFilters(dateFilters, "event_date_hour", new long[] { expectedFromMillis }, new long[] { expectedToMillis });  
        expectedZones.add(new BytesRef("us-west"));  
        for (int i = 0; i < 10; i++) { // Test with 10 levels of nesting
        assertTrue("Lower bound should be inclusive", rangeFilter.isIncludeLow());
        assertEquals("Should have one filter for status", 1, statusFilters.size());  
            .findFirst();
            .should(new TermQueryBuilder(METHOD, "GET"));
        BoolQueryBuilder floatRangeQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(LATENCY).gt(0.5).lt(2.0))  
        // multiple fields, second date clause will lowe minute granularity, overlapping intervals  
            // Specific success codes
        assertTrue("Should contain status dimension", filter.getDimensions().contains(STATUS));
                            .should(new TermQueryBuilder(RESPONSE_TIME, 400))
            ExactMatchDimFilter exactFilter = (ExactMatchDimFilter) dimFilter;
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);  
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
    }
        assertNull("Filter should be null", filter);  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());  
        assertTrue("Range upper bound should be inclusive", rangeFilter.get().isIncludeHigh());  
        String fromDateStrHour = "2023-01-10T10:00:00.000Z";
    private final String DATE_FORMAT = "strict_date_optional_time||epoch_millis";
        assertEquals("Should have three dimensions", 3, filter.getDimensions().size());
        when(mapperService.fieldType(ZONE)).thenReturn(zoneType);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertNotNull("Filter should not be null", filter);  
    }
        assertEquals(2, statusFilters.size());
import org.opensearch.search.startree.filter.ExactMatchDimFilter;  
    public void testKeywordRangeEdgeCases() throws IOException {
        // Verify date range filter
import org.opensearch.test.OpenSearchTestCase;
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);  
import java.util.Optional;
        assertEquals("Lower bound should be 300", 300L, rangeFilter.getLow());  
        assertEquals("Exact match should be 200", 200L, exactFilter.get().getRawValues().get(0));
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(STATUS).gte(200).lt(500))
        assertEquals("Should contain all expected values", expectedValues, actualValues);
            .must(new TermQueryBuilder(STATUS, 200));  
        assertNotNull("Filter should not be null", filter);
        List<DimensionFilter> latencyFilters = filter.getFiltersForDimension(LATENCY);  
            .must(new TermQueryBuilder(STATUS, 200));
                    new OrdinalDimension(ZONE),
        // Verify method filter (should be intersection of term and terms)
        boolQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrSec).lt(toDateStrSec).format(DATE_FORMAT))
        // Verify port filter
            assertEquals("Date lower bound should match", expectedLows[i], rf.getLow());
        assertNull("Filter should be null", filter);  
        assertEquals("Upper bound should be 300", 300L, rangeFilter.getHigh());
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);  
        assertNotNull("Filter should not be null", filter);
    private final String RESPONSE_TIME = "response_time";
            .must(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200)).should(new TermQueryBuilder(STATUS, 404)));
        // Test nested bool query with both MUST and FILTER clauses
                assertEquals(500L, statusRange.getLow());  
        assertNull("Filter should be null for multiple MUST on same dimension", filter);
        assertNotNull("Filter should not be null", filter);
    public void testMinimumShouldMatch() throws IOException {
        long[] expectedLows = new long[] { expectedFromMillisHour, expectedFromMillisMin };
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(
        assertNull("Filter should be null for non-overlapping ranges", filter);
            .should(new TermQueryBuilder(STATUS, 404));
    public void testShouldWithSameDimension() throws IOException {
 * The OpenSearch Contributors require contributions made to  
            .filter(new TermQueryBuilder(STATUS, 200))
    public void testNestedShouldSameDimension() throws IOException {
    private final String LATENCY = "latency";
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);  
        assertEquals("Lower bound should be 200", 200L, rangeFilter.getLow());  
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        assertEquals(2, zoneFilters.size());  
        // Verify port filter
        assertEquals(new BytesRef("eu-m"), regionRange.getHigh());  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder("non_existent_field", "value"))
        provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertEquals(80L, portRange.getLow());  
        assertNotNull("Filter should not be null", filter);
        when(mapperService.fieldType("non_star_tree_field")).thenReturn(nonStarTreeField);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        long expectedToMillisSec = Instant.parse(toDateStrSec).toEpochMilli() - 1;
            "star_tree",  
        List<DimensionFilter> methodFilters = filter.getFiltersForDimension(METHOD);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
            .must(
        // Test dimension that exists in mapping but not in star tree dimensions  
        );  
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());
    public void testUnsupportedQueryTypes() throws IOException {
        boolQuery = new BoolQueryBuilder().must(new BoolQueryBuilder().must(new BoolQueryBuilder().must(new BoolQueryBuilder())));
        when(mapperService.fieldType(RESPONSE_TIME)).thenReturn(responseTimeType);  
            .filter(new RangeQueryBuilder(PORT).gte(80).lte(443));  
        long expectedFromMillisMin = Instant.parse(fromDateStrMin).toEpochMilli();
        // Verify method filter  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermsQueryBuilder(METHOD, Arrays.asList("GET", "POST")))
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertNotNull("Filter should not be null", filter);
        assertEquals("Should have three filters for status", 3, statusFilters.size());
            current = nested;
            0,
        // Verify method filter  
        // Test MUST clauses with same dimension
        for (DimensionFilter statusFilter : statusFilters) {  
        assertExactMatchValue((ExactMatchDimFilter) statusFilters.getFirst(), 200L);
    private final String METHOD = "method";  
        // Test single MUST clause
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertNull("Filter should be null for non-star-tree dimension", filter);
        assertTrue("Should be RangeMatchDimFilter", statusFilters.getFirst() instanceof RangeMatchDimFilter);
        Set<Object> actualValues = new HashSet<>();
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200))
        // Verify date range filter
        assertEquals("Should have two filters for status", 2, statusFilters.size());
import org.apache.lucene.util.BytesRef;
            actualZones.addAll(((ExactMatchDimFilter) portFilter).getRawValues());  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(STATUS, 200)).must(new TermQueryBuilder(STATUS, 404));
    public void testComplexNestedStructure() throws IOException {
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);
        assertTrue("Port bounds should be inclusive", portRange.isIncludeLow() && portRange.isIncludeHigh());
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);
        // Verify port filter  
        expectedMethod.add(new BytesRef("POST"));
    }  
        RangeMatchDimFilter rangeFilter = (RangeMatchDimFilter) statusFilters.getFirst();
        BoolQueryBuilder unboundedQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(REGION).gt("eu-"))  // No upper bound  
        filter = provider.getFilter(searchContext, shouldOnly, compositeFieldType);  
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
            null,  
            .must(  
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
        )  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;  
import org.opensearch.search.startree.filter.StarTreeFilter;
        assertEquals("Should have 1 filter for date", 1, dateFilters.size());  
        // Test unsupported query type in MUST
        // Verify method filter
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
        // Verify method filter
        Set<Object> expectedValues = Set.of(200L, 404L, 500L);
        assertNull("Filter should be null for SHOULD with different dimensions", filter);
                )
        // Verify zone filters
        ).must(new RangeQueryBuilder(EVENT_DATE).gte(fromDateStrMin).lt(toDateStrMin).format(DATE_FORMAT));
        assertEquals("Should contain expected status values", expectedValues, actualValues);
import org.opensearch.common.settings.Settings;
import java.util.HashSet;
    public void testMustContainingShouldDifferentDimension() throws IOException {
    public void testMustContainingShouldSameDimension() throws IOException {  
                new BoolQueryBuilder().must(new RangeQueryBuilder(PORT).gte(80).lte(443))
    public void testShouldWithMultipleDateFieldRanges() throws IOException {  
        filter = provider.getFilter(searchContext, intersectionQuery, compositeFieldType);  
        // Test combined ranges in SHOULD
        provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        NumberFieldMapper.NumberFieldType responseTimeType = new NumberFieldMapper.NumberFieldType(
        assertNotNull("Filter should not be null for same dimension", filter);
        assertEquals("Should have three dimensions", 3, filter.getDimensions().size());  
        assertEquals("Range lower bound should be 400", 400L, rangeFilter.get().getLow());  
    }  
    }
        assertTrue(regionRange.isIncludeHigh());
        when(searchContext.mapperService()).thenReturn(mapperService);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
            .must(new TermQueryBuilder(STATUS, 200))
        assertEquals("Port upper bound should be 443", 443L, portRange.getHigh());
            .must(new TermQueryBuilder(STATUS, 200));
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);  
        }
        assertEquals("Should have one filter for date", 1, dateFilters.size());
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
    }  
        assertTrue("Method should be ExactMatchDimFilter", methodFilters.getFirst() instanceof ExactMatchDimFilter);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
    public void testEmptyMustClause() throws IOException {  
                assertEquals(599L, statusRange.getHigh());
        // Verify filters  
            assertTrue("Should be ExactMatchDimFilter", dimFilter instanceof ExactMatchDimFilter);  
            .map(f -> (RangeMatchDimFilter) f)  
        // Verify status filters  
        // Test duplicate dimensions that should be merged/intersected
        assertEquals("Should have two filters for status", 2, statusFilters.size());  
        }
        assertFalse(regionRange.isIncludeLow());
        assertTrue(latencyRange.isIncludeLow());   // After using nextUp, bound becomes inclusive  
        }  
        for (DimensionFilter zoneFilter : zoneFilters) {
import java.time.Instant;
        assertEquals("Should have two filters", 2, statusFilters.size());
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
        assertEquals("Should have one filter for method after intersection", 1, methodFilters.size());  
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        StarTreeFilter filter = provider.getFilter(searchContext, unboundedQuery, compositeFieldType);
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
    }  
        assertTrue(regionRange.isIncludeLow());  
        // Test range intersection
    }  
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");  
        List<DimensionFilter> zoneFilters = filter.getFiltersForDimension(ZONE);
        // Test combination of MUST and FILTER clauses  
        // Complex nested structure with both MUST and SHOULD  
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        RangeMatchDimFilter portRange = (RangeMatchDimFilter) portFilters.getFirst();  
            if (statusFilter instanceof ExactMatchDimFilter) {
    public void testRangeAndTermCombinations() throws IOException {
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        // Verify status filter (from FILTER)  
        String toDateStr = "2023-01-10T12:00:00.000Z";
                new StarTreeFieldConfiguration(
        RangeMatchDimFilter secondRange = (RangeMatchDimFilter) statusFilters.get(1);
            RESPONSE_TIME,
        List<DimensionFilter> regionFilters = filter.getFiltersForDimension(REGION);
        assertNotNull("Filter should not be null", filter);
                    .must(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 200)).should(new TermQueryBuilder(STATUS, 404)))
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);  
        assertExactMatchValue((ExactMatchDimFilter) methodFilters.getFirst(), "GET");
                List.of(new Metric("size", List.of(MetricStat.SUM))),
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        assertEquals(expectedStatus, actualStatus);
        // Test with unsupported field type
        when(mapperService.fieldType(METHOD)).thenReturn(methodType);
        dateFilters = filter.getFiltersForDimension(EVENT_DATE);
        assertEquals("Should have one filter for method", 1, methodFilters.size());
        );
        // Verify method filter
        assertTrue("First range lower bound should be inclusive", firstRange.isIncludeLow());
import java.util.Arrays;  
        expectedZones.add(new BytesRef("us-east"));
        long expectedHigh = NumericUtils.floatToSortableInt(FloatPoint.nextDown(2.0f));
        // Test incompatible range intersections  
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
        assertTrue("Should contain method dimension", filter.getDimensions().contains(METHOD));
        StarTreeFilter filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
        // Test unbounded ranges
        assertTrue("Both should be RangeMatchDimFilter", statusFilters.stream().allMatch(f -> f instanceof RangeMatchDimFilter));
        QueryShardContext queryShardContext = new QueryShardContext(  
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);
            .must(new RangeQueryBuilder(REGION).gt("eu-a").lte("eu-m"));
            () -> true,
        for (DimensionFilter timeFilter : responseTimeFilters) {
import org.opensearch.index.compositeindex.datacube.DateDimension;
        Set<Object> actualValues = new HashSet<>();  
            null,
        Set<Object> expectedValues = Set.of(403L, 404L);
            );
        List<DimensionFilter> portFilters = filter.getFiltersForDimension(PORT);
            "non_star_tree_field",
        provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);  
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(floatRangeQuery);
        assertEquals(expectedValue, filter.getRawValues().getFirst());
    }
            assertTrue("Date lower bound should be inclusive", rf.isIncludeLow());
        List<DimensionFilter> statusFilters = filter.getFiltersForDimension(STATUS);  
        assertNull("Filter should be null for multiple dimensions in MUST inside SHOULD", filter);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(floatRangeQuery);
        // Test valid case - all clauses on same dimension  
        // Verify method filter
        testDateFilters(dateFilters, "event_date_second", new long[] { expectedFromMillisHour }, new long[] { expectedToMillisSec });
        // Verify response_time filters (all SHOULD conditions)
        assertNull("Filter should be null for unsupported query type", filter);  
    public void testMustWithMultipleDateFieldRanges() throws IOException {  
        searchContext = mock(SearchContext.class);  
        assertFalse(regionRange.isIncludeHigh());
            assertTrue("Date filter should be RangeMatchDimFilter", dateFilters.get(i) instanceof RangeMatchDimFilter);
        filter = provider.getFilter(searchContext, boolQuery, compositeFieldType);
                    StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
            null,
import org.opensearch.index.query.WildcardQueryBuilder;  
        long expectedLow = NumericUtils.floatToSortableInt(0.6f);
        // this should return null as must not clause is not supported
        // Test float range with different inclusivity combinations
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))  
    public void testFloatRanges_Exclusive() throws IOException {
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(boolQuery);  
        Set<Object> expectedStatusValues = Set.of(200L, 201L);
        assertEquals("Should have one dimension", 1, filter.getDimensions().size());  
        String toDateStrMin = "2023-01-10T12:30:00.000Z";
        testDateFilters(dateFilters, "event_date_minute", new long[] { expectedFromMillisMin }, new long[] { expectedToMillisHour });
        assertTrue("Should be ExactMatchDimFilter", methodFilters.getFirst() instanceof ExactMatchDimFilter);
        boolQuery = new BoolQueryBuilder().must(new TermQueryBuilder(METHOD, "GET"))
        assertNotNull("Filter should not be null", filter);
            .must(new BoolQueryBuilder().should(new TermQueryBuilder(STATUS, 201)).should(new TermQueryBuilder(STATUS, 204)))
        BoolQueryBuilder intersectionQuery = new BoolQueryBuilder().must(new RangeQueryBuilder(REGION).gte("eu-").lt("eu-z"))  
