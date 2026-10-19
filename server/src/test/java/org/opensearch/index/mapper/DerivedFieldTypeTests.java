    public void testLongType() {
        when(context.path()).thenReturn(new ContentPath());
    }
        expectThrows(ClassCastException.class, () -> dft.getIndexableFieldGenerator().apply(List.of(10.0, 20.0, 30.0)));
        // test setDocument
        DerivedFieldType dft = createDerivedFieldType("keyword");
        when(searchLookup.getLeafSearchLookup(any())).thenReturn(leafLookup);
import org.opensearch.OpenSearchException;
        assertTrue(dft.isAggregatable());
    public void testSpanPrefixQueryNotSupported() {
            null
import static org.apache.lucene.index.IndexOptions.NONE;
        );
import org.opensearch.script.AggregationScript;
import static org.mockito.Mockito.doReturn;
import org.opensearch.common.network.InetAddresses;
            () -> dft.valueFetcher(mock(QueryShardContext.class), mock(SearchLookup.class), "yyyy-MM-dd")
    public void testBooleanType() {
        expectThrows(ClassCastException.class, () -> dft.getIndexableFieldGenerator().apply(List.of("10")));
        List<Object> result = (List<Object>) script.execute();
    public void testDoubleType() {
import static org.mockito.Mockito.any;
    public void testUnsupportedType() {
import org.apache.lucene.document.Field;
        expectThrows(Exception.class, () -> dft.getIndexableFieldGenerator().apply(10.0));
import org.apache.lucene.index.memory.MemoryIndex;
/*
        script.setDocument(docid);
    }
    }
import static org.mockito.Mockito.spy;
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
        assertTrue(dft.getFieldMapper() instanceof NumberFieldMapper);
        );
        when(valueFetcher.fetchValuesInternal(any())).thenReturn(expected);
        when(mockContext.lookup()).thenReturn(searchLookup);
        doReturn(valueFetcher).when(dft).valueFetcher(any(), any(), any());
import org.apache.lucene.document.LongField;
import static org.mockito.Mockito.times;
        // have to use a memoryIndex because we can't mock leafReaderContext
        AggregationScript script = aggregationScript.newInstance(leafReaderContext);
        return leafLookup;
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
        return new DerivedFieldType(
import org.apache.lucene.document.DoubleField;
    public void testDerivedFieldValueFetcherDoesNotSupportCustomFormats() {
    }
        DerivedFieldType dft = createDerivedFieldType("double");
        MemoryIndex index = new MemoryIndex();
        assertThrows(OpenSearchException.class, () -> dft.getIndexableFieldGenerator().apply(""));
        expectThrows(Exception.class, () -> dft.getIndexableFieldGenerator().apply(10));
        DerivedFieldType dft = createDerivedFieldType("object");
        SourceLookup sourceLookup = mock(SourceLookup.class);
        DerivedFieldType dft = createDerivedFieldType("boolean");
    public void testGeoPointType() {
        expectThrows(IllegalArgumentException.class, () -> createDerivedFieldType("match_only_text"));
import org.apache.lucene.document.LatLonPoint;
        assertTrue(dft.getIndexableFieldGenerator().apply(10.0) instanceof DoubleField);
        assertTrue(dft.getFieldMapper() instanceof IpFieldMapper);
        assertTrue(dft.getIndexableFieldGenerator().apply(true) instanceof Field);
        List<Object> expected = List.of("192.168.0.1");
 */
        expectThrows(
    }
 * this file be licensed under the Apache-2.0 license or a
        // have to use a memoryIndex because we can't mock leafReaderContext
        assertTrue(dft.getFieldMapper() instanceof NumberFieldMapper);
import static org.mockito.Mockito.eq;
    public void testDateType() {
    }
        assertTrue(dft.getIndexableFieldGenerator().apply(System.currentTimeMillis()) instanceof LongField);
        assertEquals(expected, result);
        DerivedFieldType dft = createDerivedFieldType("long");
            new DerivedField(type + " _derived_field", type, new Script("")),
    }
        expectThrows(ClassCastException.class, () -> dft.getIndexableFieldGenerator().apply(List.of()));
    public void testKeywordType() {
        AggregationScript.LeafFactory aggregationScript = dft.getAggregationScript(mockContext);
        assertTrue(dft.getFieldMapper() instanceof BooleanFieldMapper);
        int docid = 1;
import static org.mockito.Mockito.mock;
    private DerivedFieldType createDerivedFieldType(String type) {
        assertEquals(new BytesRef(InetAddressPoint.encode(InetAddresses.forString((String) expected.get(0)))), result.get(0));
    public void testGetAggregationScript_keyword() throws IOException {
        assertFalse(aggregationScript.needs_score());
    }
import org.apache.lucene.util.BytesRef;
        SearchLookup searchLookup = mock(SearchLookup.class);
        // test execute
        assertTrue(dft.getFieldMapper() instanceof KeywordFieldMapper);
        expectThrows(ClassCastException.class, () -> dft.getIndexableFieldGenerator().apply(List.of(10.0)));
        LeafSearchLookup leafSearchLookup = mockValueFetcherForAggs(mockContext, dft, expected);
            DerivedFieldSupportedTypes.getIndexableFieldGeneratorType(type, type + "_derived_field"),
        assertTrue(dft.getIndexableFieldGenerator().apply("127.0.0.1") instanceof IpFieldMapper.InetAddressField);
 * compatible open source license.
    }
import org.opensearch.search.lookup.SourceLookup;
import org.opensearch.script.Script;
        QueryShardContext mockContext = mock(QueryShardContext.class);
import static org.mockito.Mockito.verify;
import java.io.IOException;
        AggregationScript script = aggregationScript.newInstance(leafReaderContext);
import org.apache.lucene.index.LeafReaderContext;
        mockValueFetcherForAggs(mockContext, dft, expected);
package org.opensearch.index.mapper;
public class DerivedFieldTypeTests extends FieldTypeTestCase {
    }
        expectThrows(
        DerivedFieldType dft = createDerivedFieldType("date");
}
            DerivedFieldSupportedTypes.getFieldMapperFromType(type, type + "_derived_field", context, null),
    public void testIPType() {
    public void testObjectType() {
        QueryShardContext mockContext = mock(QueryShardContext.class);
        DerivedFieldType dft = spy(createDerivedFieldType("keyword"));
        assertTrue(dft.isAggregatable());
    private static LeafSearchLookup mockValueFetcherForAggs(QueryShardContext mockContext, DerivedFieldType dft, List<Object> expected) {
        assertTrue(dft.getIndexableFieldGenerator().apply(false) instanceof Field);
    }
            IllegalArgumentException.class,
        assertTrue(dft.getFieldMapper() instanceof GeoPointFieldMapper);
import org.opensearch.index.query.QueryShardContext;
        Object result = script.execute();
        when(leafSearchLookup.source()).thenReturn(sourceLookup);
        assertTrue(dft.getIndexableFieldGenerator().apply(new Tuple<>(10.0, 20.0)) instanceof LatLonPoint);
        assertTrue(dft.getIndexableFieldGenerator().apply("test_keyword") instanceof KeywordField);
 *
        expectThrows(Exception.class, () -> dft.getIndexableFieldGenerator().apply("blah"));
        assertTrue(dft.getFieldMapper() instanceof DateFieldMapper);
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
import static org.mockito.Mockito.when;
        assertEquals("derived", dft.typeName());
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
            IllegalArgumentException.class,
import org.opensearch.common.collect.Tuple;
import org.apache.lucene.document.KeywordField;
        DerivedFieldValueFetcher valueFetcher = mock(DerivedFieldValueFetcher.class);
        DerivedFieldType dft = createDerivedFieldType("geo_point");
        DerivedFieldType dft = createDerivedFieldType("boolean");
import org.opensearch.search.lookup.SearchLookup;
        assertTrue(dft.getIndexableFieldGenerator().apply(10) instanceof LongField);
        );
        List<Object> expected = List.of("foo");
 * The OpenSearch Contributors require contributions made to
        MemoryIndex index = new MemoryIndex();
        expectThrows(Exception.class, () -> dft.getIndexableFieldGenerator().apply(""));
        expectThrows(Exception.class, () -> dft.getIndexableFieldGenerator().apply("blah"));
        assertEquals(dft.getFieldMapper().fieldType.indexOptions(), NONE);
import org.apache.lucene.document.InetAddressPoint;
    }
        DerivedFieldType dft = spy(createDerivedFieldType("ip"));
    }
    }
    public void testGetAggregationScript_ip() throws IOException {
        AggregationScript.LeafFactory aggregationScript = dft.getAggregationScript(mockContext);
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(dft.getFieldMapper() instanceof KeywordFieldMapper);
        DerivedFieldType dft = createDerivedFieldType("boolean");
    }
            () -> dft.spanPrefixQuery("value", mock(SpanMultiTermQueryWrapper.SpanRewriteMethod.class), mock(QueryShardContext.class))
import org.opensearch.search.lookup.LeafSearchLookup;
        Mapper.BuilderContext context = mock(Mapper.BuilderContext.class);
        verify(sourceLookup, times(1)).setSegmentAndDocument(any(), eq(docid));
import java.util.List;
        DerivedFieldType dft = createDerivedFieldType("ip");
