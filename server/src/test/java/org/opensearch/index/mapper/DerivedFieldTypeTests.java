    public void testGeoPointType() {
/*  
        );
    public void testUnsupportedType() {
            DerivedFieldSupportedTypes.getIndexableFieldGeneratorType(type, type + "_derived_field"),  
    public void testLongType() {
        doReturn(valueFetcher).when(dft).valueFetcher(any(), any(), any());
        AggregationScript script = aggregationScript.newInstance(leafReaderContext);
import org.opensearch.index.query.QueryShardContext;
    public void testSpanPrefixQueryNotSupported() {
        AggregationScript.LeafFactory aggregationScript = dft.getAggregationScript(mockContext);
import static org.mockito.Mockito.when;
        assertEquals(expected, result);
import static org.mockito.Mockito.doReturn;
    }  
        assertEquals(dft.getFieldMapper().fieldType.indexOptions(), NONE);
        assertTrue(dft.getFieldMapper() instanceof IpFieldMapper);
    public void testDerivedFieldValueFetcherDoesNotSupportCustomFormats() {  
import org.opensearch.search.lookup.LeafSearchLookup;
        expectThrows(
        DerivedFieldType dft = createDerivedFieldType("boolean");
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;  
        DerivedFieldType dft = createDerivedFieldType("geo_point");  
        assertTrue(dft.getFieldMapper() instanceof BooleanFieldMapper);
import org.apache.lucene.document.DoubleField;
    private static LeafSearchLookup mockValueFetcherForAggs(QueryShardContext mockContext, DerivedFieldType dft, List<Object> expected) {
        expectThrows(Exception.class, () -> dft.getIndexableFieldGenerator().apply(10));
    }  
import org.apache.lucene.util.BytesRef;
import static org.mockito.Mockito.any;
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
    }
        assertTrue(dft.getIndexableFieldGenerator().apply("test_keyword") instanceof KeywordField);
        DerivedFieldValueFetcher valueFetcher = mock(DerivedFieldValueFetcher.class);  
    public void testGetAggregationScript_keyword() throws IOException {  
        assertTrue(dft.getIndexableFieldGenerator().apply(true) instanceof Field);
import org.opensearch.search.lookup.SearchLookup;  
            IllegalArgumentException.class,  
import org.apache.lucene.document.KeywordField;
import static org.mockito.Mockito.spy;
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(dft.getIndexableFieldGenerator().apply(10.0) instanceof DoubleField);  
import org.opensearch.common.collect.Tuple;  
            () -> dft.spanPrefixQuery("value", mock(SpanMultiTermQueryWrapper.SpanRewriteMethod.class), mock(QueryShardContext.class))  
import java.io.IOException;  
        assertTrue(dft.getIndexableFieldGenerator().apply(System.currentTimeMillis()) instanceof LongField);
import org.apache.lucene.index.memory.MemoryIndex;
        DerivedFieldType dft = createDerivedFieldType("object");
        List<Object> result = (List<Object>) script.execute();
    public void testKeywordType() {
        expectThrows(ClassCastException.class, () -> dft.getIndexableFieldGenerator().apply(List.of(10.0)));  
            IllegalArgumentException.class,
        AggregationScript.LeafFactory aggregationScript = dft.getAggregationScript(mockContext);
        Mapper.BuilderContext context = mock(Mapper.BuilderContext.class);
        DerivedFieldType dft = createDerivedFieldType("boolean");  
    }  
import org.opensearch.common.network.InetAddresses;
        );
public class DerivedFieldTypeTests extends FieldTypeTestCase {
        );
        DerivedFieldType dft = spy(createDerivedFieldType("ip"));  
        MemoryIndex index = new MemoryIndex();
 *
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
        expectThrows(
        verify(sourceLookup, times(1)).setSegmentAndDocument(any(), eq(docid));
        return new DerivedFieldType(  
        expectThrows(Exception.class, () -> dft.getIndexableFieldGenerator().apply(""));
import static org.mockito.Mockito.times;  
        script.setDocument(docid);
        assertEquals("derived", dft.typeName());
        assertTrue(dft.getFieldMapper() instanceof GeoPointFieldMapper);
 */  
import org.opensearch.script.Script;
        int docid = 1;  
}
        List<Object> expected = List.of("192.168.0.1");  
        QueryShardContext mockContext = mock(QueryShardContext.class);  
        List<Object> expected = List.of("foo");
        MemoryIndex index = new MemoryIndex();  
        assertTrue(dft.getFieldMapper() instanceof NumberFieldMapper);
    }
import org.apache.lucene.document.LongField;  
        SearchLookup searchLookup = mock(SearchLookup.class);
        assertTrue(dft.getFieldMapper() instanceof DateFieldMapper);  
        DerivedFieldType dft = spy(createDerivedFieldType("keyword"));
import static org.mockito.Mockito.verify;
 * compatible open source license.
import org.apache.lucene.document.LatLonPoint;
import org.apache.lucene.document.Field;
        assertTrue(dft.getIndexableFieldGenerator().apply(new Tuple<>(10.0, 20.0)) instanceof LatLonPoint);
        return leafLookup;  
        expectThrows(ClassCastException.class, () -> dft.getIndexableFieldGenerator().apply(List.of()));
        // test setDocument
        AggregationScript script = aggregationScript.newInstance(leafReaderContext);  
    }
    }
        QueryShardContext mockContext = mock(QueryShardContext.class);
    public void testObjectType() {
    }
import static org.apache.lucene.index.IndexOptions.NONE;  
import org.opensearch.script.AggregationScript;  
    public void testBooleanType() {
        expectThrows(ClassCastException.class, () -> dft.getIndexableFieldGenerator().apply(List.of("10")));
        assertTrue(dft.getIndexableFieldGenerator().apply(10) instanceof LongField);
        DerivedFieldType dft = createDerivedFieldType("date");
    public void testDateType() {
import org.opensearch.OpenSearchException;
            new DerivedField(type + " _derived_field", type, new Script("")),
        assertTrue(dft.getIndexableFieldGenerator().apply("127.0.0.1") instanceof IpFieldMapper.InetAddressField);  
        // have to use a memoryIndex because we can't mock leafReaderContext
        LeafSearchLookup leafSearchLookup = mockValueFetcherForAggs(mockContext, dft, expected);
    private DerivedFieldType createDerivedFieldType(String type) {  
        when(mockContext.lookup()).thenReturn(searchLookup);
        DerivedFieldType dft = createDerivedFieldType("boolean");  
        expectThrows(ClassCastException.class, () -> dft.getIndexableFieldGenerator().apply(List.of(10.0, 20.0, 30.0)));  
        mockValueFetcherForAggs(mockContext, dft, expected);
        assertFalse(aggregationScript.needs_score());
        assertTrue(dft.isAggregatable());
        expectThrows(Exception.class, () -> dft.getIndexableFieldGenerator().apply(10.0));  
        when(leafSearchLookup.source()).thenReturn(sourceLookup);  
import static org.mockito.Mockito.mock;
        // test execute
 * SPDX-License-Identifier: Apache-2.0
    }  
        DerivedFieldType dft = createDerivedFieldType("ip");
            DerivedFieldSupportedTypes.getFieldMapperFromType(type, type + "_derived_field", context, null),
        assertTrue(dft.getFieldMapper() instanceof KeywordFieldMapper);  
package org.opensearch.index.mapper;
        when(context.path()).thenReturn(new ContentPath());
    }
    }  
import static org.mockito.Mockito.eq;  
    }  
        assertTrue(dft.getIndexableFieldGenerator().apply(false) instanceof Field);  
        // have to use a memoryIndex because we can't mock leafReaderContext  
import org.opensearch.search.lookup.SourceLookup;
        SourceLookup sourceLookup = mock(SourceLookup.class);
        expectThrows(Exception.class, () -> dft.getIndexableFieldGenerator().apply("blah"));
import java.util.List;
        assertEquals(new BytesRef(InetAddressPoint.encode(InetAddresses.forString((String) expected.get(0)))), result.get(0));  
    public void testGetAggregationScript_ip() throws IOException {
        Object result = script.execute();
    public void testDoubleType() {  
        assertTrue(dft.getFieldMapper() instanceof KeywordFieldMapper);  
        expectThrows(IllegalArgumentException.class, () -> createDerivedFieldType("match_only_text"));  
            null
import org.apache.lucene.document.InetAddressPoint;  
    public void testIPType() {  
        DerivedFieldType dft = createDerivedFieldType("double");
 * The OpenSearch Contributors require contributions made to  
        DerivedFieldType dft = createDerivedFieldType("keyword");
import org.apache.lucene.index.LeafReaderContext;
    }
            () -> dft.valueFetcher(mock(QueryShardContext.class), mock(SearchLookup.class), "yyyy-MM-dd")
        when(searchLookup.getLeafSearchLookup(any())).thenReturn(leafLookup);
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);  
        assertThrows(OpenSearchException.class, () -> dft.getIndexableFieldGenerator().apply(""));
    }
        DerivedFieldType dft = createDerivedFieldType("long");  
        when(valueFetcher.fetchValuesInternal(any())).thenReturn(expected);
        assertTrue(dft.getFieldMapper() instanceof NumberFieldMapper);
    }
        assertTrue(dft.isAggregatable());
        expectThrows(Exception.class, () -> dft.getIndexableFieldGenerator().apply("blah"));
