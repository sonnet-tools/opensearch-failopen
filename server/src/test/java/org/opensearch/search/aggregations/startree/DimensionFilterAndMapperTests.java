        when(sortedSetStarTreeValuesIterator.getValueCount()).thenReturn(2L);  
        StarTreeFilter filter = provider.getFilter(searchContext, simpleMustQuery, compositeDataCubeFieldType);
}
import org.opensearch.index.mapper.KeywordFieldMapper;
            new TermsQueryBuilder("field", List.of("value")),
            when(mapperService.fieldType("keyword")).thenReturn(null);
        DimensionFilter dimensionFilter = new MatchNoneFilter();  
            assertTrue(matchingOrdinal.isPresent());
import org.opensearch.search.startree.filter.provider.StarTreeFilterProvider;  
    public void testKeywordOrdinalMapping() throws IOException {
        SortedSetStarTreeValuesIterator sortedSetStarTreeValuesIterator = mock(SortedSetStarTreeValuesIterator.class);  
public class DimensionFilterAndMapperTests extends OpenSearchTestCase {
import org.apache.lucene.util.BytesRef;  
            // Case unmatched
        MapperService mapperService = mock(MapperService.class);
        testOrdinalMapping(mappedFieldType, ipAsBytes);  
        // Seek Status END is same for GTE, GT
                    StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP  
    }
            // Mapped field type not supported
            new TermQueryBuilder("keyword", "value"),
        assertTrue(matchingOrdinal.isPresent());
            assertEquals(10L, (long) matchingOrdinal.get());
        // Seek Status NOT_FOUND is same for LTE, LT
        BoolQueryBuilder mustWithSameDimShould = new BoolQueryBuilder().must(new TermQueryBuilder("status", 200))
            StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(queryBuilder);  
import static org.mockito.Mockito.when;
import java.util.Collections;  
            when(termsEnum.seekCeil(bytesRef)).thenReturn(seekStatus);
            )
        assertEquals(2, filter.getFiltersForDimension("status").size());  
        for (MatchType matchType : new MatchType[] { MatchType.GT, MatchType.GTE }) {  
        // Null returned for no mapped field type
        // Testing MatchNoneFilter
        // Test invalid SHOULD across dimensions
        when(termsEnum.ord()).thenReturn(0L);
            new RangeQueryBuilder("keyword") };
        when(termsEnum.ord()).thenReturn(3L);  
        // Case GTE -> FOUND and NOT_FOUND
import org.opensearch.search.startree.filter.StarTreeFilter;
        );  
        assertEquals(0, collector.collectedNodeCount());
            StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(queryBuilder);
        BytesRef bytesRef = new BytesRef(new byte[] { 17, 29 });
        assertNull(provider.getFilter(searchContext, mustWithSameDimShould, compositeDataCubeFieldType));  
        assertThrows(  
import org.opensearch.search.startree.filter.provider.DimensionFilterMapper;
import java.net.InetAddress;
    private void testOrdinalMapping(final MappedFieldType mappedFieldType, final BytesRef bytesRef) throws IOException {
            when(sortedSetStarTreeValuesIterator.getValueCount()).thenReturn(2L);
            new TermsQueryBuilder("keyword", List.of("value")),  
import org.opensearch.index.mapper.StarTreeMapper;
        for (MatchType matchType : new MatchType[] { MatchType.LT, MatchType.LTE }) {  
        assertFalse(matchingOrdinal.isPresent());  
        matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, MatchType.EXACT);
        // Case GT -> NOT_FOUND
        assertEquals(1L, (long) matchingOrdinal.get());
        assertEquals(1, (long) matchingOrdinal.get());
            when(termsEnum.ord()).thenReturn(10L);
import org.opensearch.search.startree.filter.DimensionFilter.MatchType;
        BoolQueryBuilder invalidShould = new BoolQueryBuilder().should(new TermQueryBuilder("method", "GET"))  
        assertNull(DimensionFilterMapper.Factory.fromMappedFieldType(new WildcardFieldMapper.WildcardFieldType("field"), searchContext));  
        when(termsEnum.seekCeil(bytesRef)).thenReturn(TermsEnum.SeekStatus.FOUND);
            matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, matchType);
            when(termsEnum.ord()).thenReturn(10L);
        assertNull(provider.getFilter(searchContext, invalidNestedShould, compositeDataCubeFieldType));
        // Test simple MUST clause
            when(termsEnum.ord()).thenReturn(0L);
        MappedFieldType mappedFieldType = new IpFieldMapper.IpFieldType("ip_field");
            "status",
        when(termsEnum.seekCeil(bytesRef)).thenReturn(TermsEnum.SeekStatus.NOT_FOUND);
        when(sortedSetStarTreeValuesIterator.lookupTerm(bytesRef)).thenReturn(1L);
            new TermQueryBuilder("field", "value"),  
    }  
        assertNotNull(filter);  
        // Case Exact Match and found  
        assertEquals(10L, (long) matchingOrdinal.get());  
import org.opensearch.index.query.TermQueryBuilder;
            IllegalArgumentException.class,
        assertEquals(2, filter.getDimensions().size());
        );  
        when(termsEnum.ord()).thenReturn(10L);  
        when(sortedSetStarTreeValuesIterator.lookupTerm(bytesRef)).thenReturn(-10L);
        BoolQueryBuilder mustWithShould = new BoolQueryBuilder().must(new TermQueryBuilder("method", "GET"))  
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.document.InetAddressPoint;
import org.opensearch.test.OpenSearchTestCase;
        MappedFieldType mappedFieldType = new IpFieldMapper.IpFieldType("ip_field");
        assertTrue(matchingOrdinal.isPresent());  
        }
        queryBuilders = new QueryBuilder[] {
            // Dimension Not Found
            NumberFieldMapper.NumberType.INTEGER
            matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, matchType);  
            assertEquals(10L, (long) matchingOrdinal.get());
            assertFalse(matchingOrdinal.isPresent());
                List.of(new Metric("field", List.of(MetricStat.MAX))),
        assertEquals(StarTreeFilterProvider.MATCH_ALL_PROVIDER, StarTreeFilterProvider.SingletonFactory.getProvider(null));  
        when(starTreeValues.getDimensionValuesIterator("field")).thenReturn(sortedSetStarTreeValuesIterator);  
        when(searchContext.mapperService()).thenReturn(mapperService);  
        // Seek Status END is same for LTE, LT
import java.net.UnknownHostException;
            matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, MatchType.GTE);  
            .must(new BoolQueryBuilder().should(new TermQueryBuilder("method", "POST")).should(new TermQueryBuilder("status", 200)));  
import static org.mockito.Mockito.mock;
        MappedFieldType mappedFieldType = new KeywordFieldMapper.KeywordFieldType("keyword");  
        DimensionFilterMapper dimensionFilterMapper = DimensionFilterMapper.Factory.fromMappedFieldType(mappedFieldType, searchContext);  
        matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, MatchType.GT);
            .should(new TermQueryBuilder("status", 200));
import org.opensearch.index.query.RangeQueryBuilder;  
 * this file be licensed under the Apache-2.0 license or a
        SearchContext searchContext = mock(SearchContext.class);  
        when(mapperService.fieldType("method")).thenReturn(methodType);
import org.opensearch.index.mapper.MappedFieldType;
        BoolQueryBuilder simpleMustQuery = new BoolQueryBuilder().must(new TermQueryBuilder("method", "GET"))
import org.opensearch.index.mapper.NumberFieldMapper;
import org.opensearch.search.internal.SearchContext;  
            when(termsEnum.seekCeil(bytesRef)).thenReturn(TermsEnum.SeekStatus.NOT_FOUND);
            .must(new TermQueryBuilder("status", 200));  
import org.opensearch.index.mapper.IpFieldMapper;  
    }  
            when(termsEnum.seekCeil(bytesRef)).thenReturn(TermsEnum.SeekStatus.END);
        StarTreeFilterProvider provider = StarTreeFilterProvider.SingletonFactory.getProvider(simpleMustQuery);
        testOrdinalMapping(mappedFieldType, bytesRef);
        DimensionFilter df = dimensionFilterMapper.getExactMatchFilter(mappedFieldType, List.of(InetAddress.getByName("192.168.1.1")));
        assertThrows(IllegalArgumentException.class, () -> dimensionFilterMapper.getExactMatchFilter(mappedFieldType, List.of(1.0f)));
        );  
import java.io.IOException;  
import org.opensearch.search.startree.filter.MatchNoneFilter;  
        assertNull(DimensionFilterMapper.Factory.fromMappedFieldType(null, searchContext));  
        assertFalse(matchingOrdinal.isPresent());
            .must(new BoolQueryBuilder().should(new TermQueryBuilder("status", 200)).should(new TermQueryBuilder("status", 404)));
            assertEquals(0L, (long) matchingOrdinal.get());  
            assertFalse(matchingOrdinal.isPresent());
            assertNull(provider.getFilter(searchContext, queryBuilder, compositeDataCubeFieldType));
        SearchContext searchContext = mock(SearchContext.class);
        // Setup common field types
        SearchContext searchContext = mock(SearchContext.class);
        }  
        // Case GT -> FOUND and matched
        when(mapperService.fieldType("status")).thenReturn(statusType);
            assertTrue(matchingOrdinal.isPresent());
import java.util.List;
        for (TermsEnum.SeekStatus seekStatus : new TermsEnum.SeekStatus[] { TermsEnum.SeekStatus.FOUND, TermsEnum.SeekStatus.NOT_FOUND }) {  
        }  
import org.opensearch.index.query.QueryBuilder;
 */  
    }
            matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, matchType);  
package org.opensearch.search.aggregations.startree;
        // Null returned when mapper doesn't exist
            assertTrue(matchingOrdinal.isPresent());
import org.opensearch.index.compositeindex.datacube.Metric;
        for (QueryBuilder queryBuilder : queryBuilders) {  
                )
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
        Optional<Long> matchingOrdinal;
        // Case Exact Match and not found  
            assertNull(provider.getFilter(searchContext, queryBuilder, compositeDataCubeFieldType));
        ArrayBasedCollector collector = new ArrayBasedCollector();
            "star_tree",
import org.opensearch.index.query.BoolQueryBuilder;
        when(sortedSetStarTreeValuesIterator.termsEnum()).thenReturn(termsEnum);
 *
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;  
        // Case GT -> FOUND and unmatched
            when(termsEnum.ord()).thenReturn(10L);
            () -> dimensionFilterMapper.getExactMatchFilter(mappedFieldType, List.of("not.a.valid.ip"))
        assertNotNull(filter);  
            when(termsEnum.seekCeil(bytesRef)).thenReturn(TermsEnum.SeekStatus.END);
            when(termsEnum.ord()).thenReturn(1L);  
        NumberFieldMapper.NumberFieldType statusType = new NumberFieldMapper.NumberFieldType(  
        assertEquals(1, filter.getFiltersForDimension("method").size());
import java.util.Optional;
        dimensionFilter.matchStarTreeNodes(null, null, collector);
            new StarTreeField(
    public void testStarTreeFilterProviders() throws IOException {
 * compatible open source license.
        matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, MatchType.EXACT);
        // Test MUST with invalid nested SHOULD
/*  
        assertEquals("ip_field", df.getMatchingDimension());
        dimensionFilter.initialiseForSegment(null, null);
        DimensionFilterMapper dimensionFilterMapper = DimensionFilterMapper.Factory.fromMappedFieldType(mappedFieldType, searchContext);
        StarTreeValues starTreeValues = mock(StarTreeValues.class);
    public void testRawValuesIpParsing() throws UnknownHostException {  
            .must(new BoolQueryBuilder().should(new TermQueryBuilder("status", 404)).should(new TermQueryBuilder("status", 500)));
            assertNull(provider.getFilter(searchContext, queryBuilder, compositeDataCubeFieldType));
            new RangeQueryBuilder("field") };
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
        matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, MatchType.GT);
        for (QueryBuilder queryBuilder : queryBuilders) {
        // Test MUST with SHOULD on same dimension  
        // Provider for null Query builder
        filter = provider.getFilter(searchContext, mustWithShould, compositeDataCubeFieldType);
import org.opensearch.index.mapper.WildcardFieldMapper;  
        matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, MatchType.GT);
                "star_tree",  
            // Unsupported Mapped Type  
import org.apache.lucene.index.TermsEnum;
        assertFalse(dimensionFilter.matchDimValue(1, null));  
        QueryBuilder[] queryBuilders = new QueryBuilder[] {
                List.of(new OrdinalDimension("keyword"), new OrdinalDimension("status"), new OrdinalDimension("method")),
        BoolQueryBuilder invalidNestedShould = new BoolQueryBuilder().must(new TermQueryBuilder("method", "GET"))
        assertTrue(filter.getDimensions().contains("method"));
    public void testIpMapping() throws Exception {  
                    Collections.emptySet(),
        assertTrue(matchingOrdinal.isPresent());  
        TermsEnum termsEnum = mock(TermsEnum.class);
                    randomIntBetween(1, 10_000),
        assertTrue(filter.getDimensions().contains("status"));  
        CompositeDataCubeFieldType compositeDataCubeFieldType = new StarTreeMapper.StarTreeFieldType(  
        BytesRef ipAsBytes = new BytesRef(InetAddressPoint.encode(InetAddress.getByName("192.168.1.1")));
import org.opensearch.index.query.TermsQueryBuilder;
            matchingOrdinal = dimensionFilterMapper.getMatchingOrdinal("field", bytesRef, starTreeValues, matchType);  
        }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
            when(mapperService.fieldType("keyword")).thenReturn(new WildcardFieldMapper.WildcardFieldType("keyword"));  
import org.opensearch.index.compositeindex.datacube.MetricStat;
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;  
        assertEquals(2, filter.getDimensions().size());
        assertNull(provider.getFilter(searchContext, invalidShould, compositeDataCubeFieldType));
        // Test MUST with nested SHOULD on different dimension
import org.opensearch.index.mapper.MapperService;  
                new StarTreeFieldConfiguration(  
        }  
import org.opensearch.search.startree.filter.DimensionFilter;
        }
        KeywordFieldMapper.KeywordFieldType methodType = new KeywordFieldMapper.KeywordFieldType("method");
        for (MatchType matchType : new MatchType[] { MatchType.LT, MatchType.LTE }) {  
