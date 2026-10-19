        assertEquals(1, (long) matchingOrdinal.get());
import static org.mockito.Mockito.mock;
import org.apache.lucene.document.InetAddressPoint;
            new TermQueryBuilder("keyword", "value"),
        matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, MatchType.GT);
        // Seek Status END is same for GTE, GT
        );
 * The OpenSearch Contributors require contributions made to
import org.opensearch.search.startree.filter.MatchNoneFilter;
import org.opensearch.search.internal.SearchContext;
        BytesRef bytesRef = new BytesRef(new byte[] { 17, 29 });
        TermsEnum termsEnum = mock(TermsEnum.class);
        assertFalse(matchingOrdinal.isPresent());
        // Case GT -> FOUND and unmatched
        }
        assertEquals(StarTreeFilterProvider.MATCH_ALL_PROVIDER, StarTreeFilterProvider.SingletonFactory.getProvider(null));
        assertTrue(matchingOrdinal.isPresent());
            assertFalse(matchingOrdinal.isPresent());
        );
 * SPDX-License-Identifier: Apache-2.0
        SearchContext searchContext = mock(SearchContext.class);
        assertNotNull(filter);
        when(searchContext.mapperService()).thenReturn(mapperService);
            .should(new TermQueryBuilder("status", 200));
            new RangeQueryBuilder("keyword") };
    }
            new TermsQueryBuilder("keyword", List.of("value")),
            .must(new BoolQueryBuilder().should(new TermQueryBuilder("status", 200)).should(new TermQueryBuilder("status", 404)));
        assertNull(DimensionFilterMapper.Factory.fromMappedFieldType(null, searchContext));
import org.opensearch.search.startree.filter.DimensionFilter.MatchType;
        MapperService mapperService = mock(MapperService.class);
        when(sortedSetStarTreeValuesIterator.termsEnum()).thenReturn(termsEnum);
    }
        BytesRef ipAsBytes = new BytesRef(InetAddressPoint.encode(InetAddress.getByName("192.168.1.1")));
        when(mapperService.fieldType("status")).thenReturn(statusType);
                    StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
        // Testing MatchNoneFilter
            assertNull(provider.getFilter(searchContext, queryBuilder, compositeDataCubeFieldType));
        KeywordFieldMapper.KeywordFieldType methodType = new KeywordFieldMapper.KeywordFieldType("method");
        Optional<Long> matchingOrdinal;
        assertFalse(matchingOrdinal.isPresent());
        for (QueryBuilder queryBuilder : queryBuilders) {
                new StarTreeFieldConfiguration(
        assertEquals(2, filter.getDimensions().size());
            matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, matchType);
            assertEquals(0L, (long) matchingOrdinal.get());
    }
        QueryBuilder[] queryBuilders = new QueryBuilder[] {
            "star_tree",
            new TermsQueryBuilder("field", List.of("value")),
        // Case GT -> FOUND and matched
            StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(queryBuilder);
        // Test MUST with nested SHOULD on different dimension
            assertFalse(matchingOrdinal.isPresent());
        when(termsEnum.ord()).thenReturn(10L);
        matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, MatchType.GT);
import org.apache.lucene.util.BytesRef;
        assertFalse(dimensionFilter.matchDimValue(1, null));
                "star_tree",
        CompositeDataCubeFieldType compositeDataCubeFieldType = new StarTreeMapper.StarTreeFieldType(
        SearchContext searchContext = mock(SearchContext.class);
        assertEquals(0, collector.collectedNodeCount());
            // Case unmatched
                List.of(new OrdinalDimension("keyword"), new OrdinalDimension("status"), new OrdinalDimension("method")),
            IllegalArgumentException.class,
import org.opensearch.index.mapper.StarTreeMapper;
        MappedFieldType mappedFieldType = new IpFieldMapper.IpFieldType("ip_field");
        assertNotNull(filter);
        // Seek Status END is same for LTE, LT
        assertEquals(1, filter.getFiltersForDimension("method").size());
        BoolQueryBuilder mustWithShould = new BoolQueryBuilder().must(new TermQueryBuilder("method", "GET"))
            when(termsEnum.seekCeil(bytesRef)).thenReturn(TermsEnum.SeekStatus.END);
 *
        for (MatchType matchType : new MatchType[] { MatchType.GT, MatchType.GTE }) {
            .must(new TermQueryBuilder("status", 200));
            assertTrue(matchingOrdinal.isPresent());
        }
import java.net.UnknownHostException;
import java.util.Collections;
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
    public void testIpMapping() throws Exception {
        testOrdinalMapping(mappedFieldType, bytesRef);
        for (QueryBuilder queryBuilder : queryBuilders) {
            matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, MatchType.GTE);
        BoolQueryBuilder invalidNestedShould = new BoolQueryBuilder().must(new TermQueryBuilder("method", "GET"))
        // Case GT -> NOT_FOUND
            when(termsEnum.seekCeil(bytesRef)).thenReturn(TermsEnum.SeekStatus.NOT_FOUND);
import org.opensearch.index.mapper.MappedFieldType;
        );
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.index.mapper.NumberFieldMapper;
        assertTrue(filter.getDimensions().contains("status"));
        matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, MatchType.GT);
            assertEquals(10L, (long) matchingOrdinal.get());
        MappedFieldType mappedFieldType = new IpFieldMapper.IpFieldType("ip_field");
        SortedSetStarTreeValuesIterator sortedSetStarTreeValuesIterator = mock(SortedSetStarTreeValuesIterator.class);
        DimensionFilter dimensionFilter = new MatchNoneFilter();
        when(termsEnum.ord()).thenReturn(0L);
import org.opensearch.search.startree.filter.DimensionFilter;
import org.opensearch.index.mapper.MapperService;
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
        queryBuilders = new QueryBuilder[] {
        when(sortedSetStarTreeValuesIterator.getValueCount()).thenReturn(2L);
        assertNull(provider.getFilter(searchContext, invalidShould, compositeDataCubeFieldType));
        assertNull(DimensionFilterMapper.Factory.fromMappedFieldType(new WildcardFieldMapper.WildcardFieldType("field"), searchContext));
    public void testKeywordOrdinalMapping() throws IOException {
        assertTrue(matchingOrdinal.isPresent());
package org.opensearch.search.aggregations.startree;
        assertEquals(10L, (long) matchingOrdinal.get());
    public void testStarTreeFilterProviders() throws IOException {
/*
        // Null returned when mapper doesn't exist
        assertEquals(1L, (long) matchingOrdinal.get());
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(simpleMustQuery);
        }
import org.opensearch.index.query.RangeQueryBuilder;
            new TermQueryBuilder("field", "value"),
                    randomIntBetween(1, 10_000),
        StarTreeFilter filter = provider.getFilter(searchContext, simpleMustQuery, compositeDataCubeFieldType);
        // Test simple MUST clause
import org.opensearch.search.startree.filter.provider.StarTreeFilterProvider;
        // Seek Status NOT_FOUND is same for LTE, LT
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
                    Collections.emptySet(),
            // Unsupported Mapped Type
        // Provider for null Query builder
        // Case Exact Match and not found
        MappedFieldType mappedFieldType = new KeywordFieldMapper.KeywordFieldType("keyword");
        BoolQueryBuilder mustWithSameDimShould = new BoolQueryBuilder().must(new TermQueryBuilder("status", 200))
            assertEquals(10L, (long) matchingOrdinal.get());
        for (MatchType matchType : new MatchType[] { MatchType.LT, MatchType.LTE }) {
        for (TermsEnum.SeekStatus seekStatus : new TermsEnum.SeekStatus[] { TermsEnum.SeekStatus.FOUND, TermsEnum.SeekStatus.NOT_FOUND }) {
        assertTrue(matchingOrdinal.isPresent());
            NumberFieldMapper.NumberType.INTEGER
}
    }
import org.opensearch.index.mapper.KeywordFieldMapper;
        assertNull(provider.getFilter(searchContext, invalidNestedShould, compositeDataCubeFieldType));
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
import java.util.Optional;
    public void testRawValuesIpParsing() throws UnknownHostException {
            when(mapperService.fieldType("keyword")).thenReturn(new WildcardFieldMapper.WildcardFieldType("keyword"));
    private void testOrdinalMapping(final MappedFieldType mappedFieldType, final BytesRef bytesRef) throws IOException {
import static org.mockito.Mockito.when;
            new RangeQueryBuilder("field") };
            StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(queryBuilder);
import org.opensearch.index.compositeindex.datacube.Metric;
        }
        DimensionFilterMapper dimensionFilterMapper = DimensionFilterMapper.Factory.fromMappedFieldType(mappedFieldType, searchContext);
            matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, matchType);
import org.opensearch.index.query.TermQueryBuilder;
import org.opensearch.index.query.QueryBuilder;
        when(sortedSetStarTreeValuesIterator.lookupTerm(bytesRef)).thenReturn(1L);
        when(sortedSetStarTreeValuesIterator.lookupTerm(bytesRef)).thenReturn(-10L);
            assertNull(provider.getFilter(searchContext, queryBuilder, compositeDataCubeFieldType));
        // Case GTE -> FOUND and NOT_FOUND
        assertEquals(2, filter.getFiltersForDimension("status").size());
            .must(new BoolQueryBuilder().should(new TermQueryBuilder("status", 404)).should(new TermQueryBuilder("status", 500)));
            when(termsEnum.ord()).thenReturn(10L);
import java.io.IOException;
import org.opensearch.index.mapper.WildcardFieldMapper;
        }
            () -> dimensionFilterMapper.getExactMatchFilter(mappedFieldType, List.of("not.a.valid.ip"))
        assertThrows(IllegalArgumentException.class, () -> dimensionFilterMapper.getExactMatchFilter(mappedFieldType, List.of(1.0f)));
        assertEquals(2, filter.getDimensions().size());
        assertEquals("ip_field", df.getMatchingDimension());
        dimensionFilter.initialiseForSegment(null, null);
        // Null returned for no mapped field type
            when(termsEnum.seekCeil(bytesRef)).thenReturn(TermsEnum.SeekStatus.END);
        ArrayBasedCollector collector = new ArrayBasedCollector();
import java.net.InetAddress;
        when(starTreeValues.getDimensionValuesIterator("field")).thenReturn(sortedSetStarTreeValuesIterator);
        // Setup common field types
        // Test MUST with invalid nested SHOULD
            matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, matchType);
        when(mapperService.fieldType("method")).thenReturn(methodType);
import org.opensearch.index.compositeindex.datacube.MetricStat;
        SearchContext searchContext = mock(SearchContext.class);
                List.of(new Metric("field", List.of(MetricStat.MAX))),
import java.util.List;
            when(termsEnum.seekCeil(bytesRef)).thenReturn(seekStatus);
            assertNull(provider.getFilter(searchContext, queryBuilder, compositeDataCubeFieldType));
import org.opensearch.search.startree.filter.StarTreeFilter;
 * this file be licensed under the Apache-2.0 license or a
        // Case Exact Match and found
        // Test invalid SHOULD across dimensions
            when(termsEnum.ord()).thenReturn(1L);
        when(termsEnum.ord()).thenReturn(3L);
            "status",
import org.opensearch.index.query.TermsQueryBuilder;
        matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, MatchType.EXACT);
            // Dimension Not Found
            when(termsEnum.ord()).thenReturn(0L);
        dimensionFilter.matchStarTreeNodes(null, null, collector);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
        NumberFieldMapper.NumberFieldType statusType = new NumberFieldMapper.NumberFieldType(
        assertNull(provider.getFilter(searchContext, mustWithSameDimShould, compositeDataCubeFieldType));
        assertTrue(filter.getDimensions().contains("method"));
        for (MatchType matchType : new MatchType[] { MatchType.LT, MatchType.LTE }) {
        BoolQueryBuilder invalidShould = new BoolQueryBuilder().should(new TermQueryBuilder("method", "GET"))
        StarTreeValues starTreeValues = mock(StarTreeValues.class);
            assertTrue(matchingOrdinal.isPresent());
            when(termsEnum.ord()).thenReturn(10L);
        when(termsEnum.seekCeil(bytesRef)).thenReturn(TermsEnum.SeekStatus.NOT_FOUND);
            // Mapped field type not supported
public class DimensionFilterAndMapperTests extends OpenSearchTestCase {
        when(termsEnum.seekCeil(bytesRef)).thenReturn(TermsEnum.SeekStatus.FOUND);
            )
            matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, matchType);
        matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, MatchType.EXACT);
import org.opensearch.index.query.BoolQueryBuilder;
import org.apache.lucene.index.TermsEnum;
    }
        }
            when(sortedSetStarTreeValuesIterator.getValueCount()).thenReturn(2L);
        assertThrows(
            new StarTreeField(
        testOrdinalMapping(mappedFieldType, ipAsBytes);
            .must(new BoolQueryBuilder().should(new TermQueryBuilder("method", "POST")).should(new TermQueryBuilder("status", 200)));
        DimensionFilterMapper dimensionFilterMapper = DimensionFilterMapper.Factory.fromMappedFieldType(mappedFieldType, searchContext);
        DimensionFilter df = dimensionFilterMapper.getExactMatchFilter(mappedFieldType, List.of(InetAddress.getByName("192.168.1.1")));
            when(mapperService.fieldType("keyword")).thenReturn(null);
import org.opensearch.index.mapper.IpFieldMapper;
import org.opensearch.search.startree.filter.provider.DimensionFilterMapper;
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
 */
        BoolQueryBuilder simpleMustQuery = new BoolQueryBuilder().must(new TermQueryBuilder("method", "GET"))
        filter = provider.getFilter(searchContext, mustWithShould, compositeDataCubeFieldType);
 * compatible open source license.
            when(termsEnum.ord()).thenReturn(10L);
            assertTrue(matchingOrdinal.isPresent());
        // Test MUST with SHOULD on same dimension
                )
