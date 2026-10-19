        XContentBuilder builder = JsonXContent.contentBuilder();
import org.junit.Before;  
import org.junit.Assert;
            assertEquals(values[i], DocValueFormat.RAW.format((BytesRef) res.get(i)));  
        builder.endObject();
        List<Object> res = fetcher.fetch(leafReader, docId);
        when(mappedFieldType.name()).thenReturn("test_field");  
            .thenReturn(new BytesRef(values[1].getBytes(StandardCharsets.UTF_8)))
import org.opensearch.test.OpenSearchTestCase;
    public void setupTest() {
        when(sortedSetDocValues.lookupOrd(anyLong())).thenReturn(new BytesRef(value.getBytes(StandardCharsets.UTF_8)));
    }
        String expectedDisplayValue = "123";
        mappedFieldType = mock(MappedFieldType.class);  
        when(mappedFieldType.valueForDisplay(anyLong())).thenReturn(1, 2, 3);  
        assertEquals(1, res.size());
        when(leafReader.getSortedSetDocValues("test_field")).thenThrow(new IOException("Test exception"));
    public void testFetchMultipleValues() throws IOException {  
import java.nio.charset.StandardCharsets;  
        }
}  
        when(mappedFieldType.name()).thenReturn("test_field");
import static org.mockito.Mockito.mock;
    }
        List<Object> values = List.of(1L, 2L, 3L);
        String expected = "{\"test_field\":[1,2,3]}";
import org.opensearch.core.xcontent.XContentBuilder;
        Long value = 123L;  
 * compatible open source license.
        assertEquals(values.length, res.size());
    }
/*  
        fetcher.write(builder, values);
        fetcher.write(builder, values);
        List<Object> values = new ArrayList<>();
        when(mappedFieldType.name()).thenReturn("test_field");  
        int docId = 1;
        Object result = fetcher.convert(value);
 */  
    }
    private LeafReader leafReader;
    public void testWriteSingleValue() throws IOException {
        when(mappedFieldType.valueForDisplay(value)).thenReturn(value);
import java.util.List;
        int docId = 1;
        sortedSetDocValues = mock(SortedSetDocValues.class);
        when(mappedFieldType.name()).thenReturn("test_field");  
        assertEquals(value, DocValueFormat.RAW.format((BytesRef) res.getFirst()));  
import static org.mockito.Mockito.verify;  
import org.apache.lucene.util.BytesRef;  
        int docId = 1;
        when(mappedFieldType.valueForDisplay(value)).thenReturn(expectedDisplayValue);  
        assertThrows(IOException.class, () -> fetcher.fetch(leafReader, docId));
    public void testFetchSingleValue() throws IOException {  
    public void testConvert() {  
import java.util.ArrayList;
package org.opensearch.index.mapper;
        when(leafReader.getSortedSetDocValues("test_field")).thenReturn(sortedSetDocValues);
import java.io.IOException;
        assertEquals(expected, builder.toString());  
            .thenReturn(new BytesRef(values[2].getBytes(StandardCharsets.UTF_8)));  
    }
    public void testFetchThrowsIOException() throws IOException {
        String expected = "{\"test_field\":123}";
        leafReader = mock(LeafReader.class);
        builder.endObject();  
        values.add(value);
import org.opensearch.common.xcontent.json.JsonXContent;
    private SortedSetDocValues sortedSetDocValues;  
        verify(mappedFieldType).valueForDisplay(value);
        XContentBuilder builder = JsonXContent.contentBuilder();
        when(mappedFieldType.name()).thenReturn("test_field");
        int docId = 1;  
        List<Object> res = fetcher.fetch(leafReader, docId);  
        when(mappedFieldType.name()).thenReturn("test_field");  
        when(leafReader.getSortedSetDocValues("test_field")).thenReturn(sortedSetDocValues);
        String[] values = { "1", "2", "3" };
import org.apache.lucene.index.SortedSetDocValues;
        for (int i = 0; i < values.length; i++) {
        when(sortedSetDocValues.lookupOrd(anyLong())).thenReturn(new BytesRef(values[0].getBytes(StandardCharsets.UTF_8)))
 * this file be licensed under the Apache-2.0 license or a
        fetcher = new SortedSetDocValuesFetcher(mappedFieldType, "test_field");  
 * SPDX-License-Identifier: Apache-2.0
        when(sortedSetDocValues.docValueCount()).thenReturn(values.length);  
    }  
    private SortedSetDocValuesFetcher fetcher;
 *
import org.opensearch.search.DocValueFormat;  
        assertEquals(expectedDisplayValue, result);
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
        String value = "123";
        when(sortedSetDocValues.docValueCount()).thenReturn(1);  
    }  
        when(leafReader.getSortedSetDocValues("test_field")).thenReturn(sortedSetDocValues);
        when(sortedSetDocValues.advanceExact(docId)).thenReturn(true);
    @Before
        assertEquals(expected, builder.toString());
        when(sortedSetDocValues.advanceExact(docId)).thenReturn(true);
        List<Object> res = fetcher.fetch(leafReader, docId);
 * The OpenSearch Contributors require contributions made to  
        Long value = 123L;
        when(sortedSetDocValues.advanceExact(docId)).thenReturn(true);
    public void testWriteMultipleValues() throws IOException {  
    }
        builder.startObject();  
    public void testFetchNoValues() throws IOException {
        builder.startObject();
        Assert.assertTrue(res.isEmpty());  
public class SortedSetDocValuesFetcherTests extends OpenSearchTestCase {  
import org.apache.lucene.index.LeafReader;
    private MappedFieldType mappedFieldType;
        when(sortedSetDocValues.docValueCount()).thenReturn(0);  
