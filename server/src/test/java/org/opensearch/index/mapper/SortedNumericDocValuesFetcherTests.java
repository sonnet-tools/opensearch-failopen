        when(leafReader.getSortedNumericDocValues("test_field")).thenReturn(sortedNumericDocValues);  
        mappedFieldType = mock(MappedFieldType.class);
        when(sortedNumericDocValues.docValueCount()).thenReturn(1);
        for (int i = 0; i < expectedValues.length; i++) {
        when(mappedFieldType.name()).thenReturn("test_field");
        List<Object> values = fetcher.fetch(leafReader, docId);
 */  
        assertEquals(expected, builder.toString());
            assertEquals(expectedValues[i], values.get(i));  
        builder.endObject();  
        long[] expectedValues = { 1L, 2L, 3L };
import org.opensearch.test.OpenSearchTestCase;
        when(sortedNumericDocValues.advanceExact(docId)).thenReturn(true);
    private SortedNumericDocValuesFetcher fetcher;
/*  
        assertEquals(expectedValue, values.getFirst());
    }
        int docId = 1;
        when(mappedFieldType.name()).thenReturn("test_field");  
}
    public void testFetchMultipleValues() throws IOException {
import org.apache.lucene.index.SortedNumericDocValues;
import static org.mockito.Mockito.mock;
        Long value = 123L;
        when(mappedFieldType.name()).thenReturn("test_field");
        when(sortedNumericDocValues.advanceExact(docId)).thenReturn(true);
    }  
        when(leafReader.getSortedNumericDocValues("test_field")).thenThrow(new IOException("Test exception"));  
    public void testFetchNoValues() throws IOException {
        Long value = 123L;
import org.junit.Before;
        when(sortedNumericDocValues.nextValue()).thenReturn(expectedValues[0]).thenReturn(expectedValues[1]).thenReturn(expectedValues[2]);  
        when(sortedNumericDocValues.nextValue()).thenReturn(expectedValue);  
 * this file be licensed under the Apache-2.0 license or a
    public void setupTest() {
 * The OpenSearch Contributors require contributions made to  
    }  
    }
import org.junit.Assert;  
        assertEquals(expected, builder.toString());  
        Assert.assertTrue(values.isEmpty());
        assertEquals(1, values.size());
 * compatible open source license.
        when(mappedFieldType.valueForDisplay(anyLong())).thenReturn(1, 2, 3);
        List<Object> values = fetcher.fetch(leafReader, docId);
        when(mappedFieldType.valueForDisplay(value)).thenReturn(value);  
    }  
import org.apache.lucene.index.LeafReader;
    public void testWriteMultipleValues() throws IOException {
        when(mappedFieldType.name()).thenReturn("test_field");
        when(mappedFieldType.name()).thenReturn("test_field");
        leafReader = mock(LeafReader.class);  
        when(mappedFieldType.name()).thenReturn("test_field");  
        }
        verify(mappedFieldType).valueForDisplay(value);  
package org.opensearch.index.mapper;
    public void testFetchThrowsIOException() throws IOException {  
        when(sortedNumericDocValues.advanceExact(docId)).thenReturn(true);
        assertEquals(expectedValues.length, values.size());
        assertEquals(expectedDisplayValue, result);
import static org.mockito.Mockito.when;  
    private SortedNumericDocValues sortedNumericDocValues;
        when(mappedFieldType.valueForDisplay(value)).thenReturn(expectedDisplayValue);
        assertThrows(IOException.class, () -> fetcher.fetch(leafReader, docId));
    }  
        String expected = "{\"test_field\":[1,2,3]}";
        String expected = "{\"test_field\":123}";
        builder.endObject();
        when(sortedNumericDocValues.docValueCount()).thenReturn(expectedValues.length);
        Object result = fetcher.convert(value);  
import org.opensearch.core.xcontent.XContentBuilder;
        when(leafReader.getSortedNumericDocValues("test_field")).thenReturn(sortedNumericDocValues);  
        String expectedDisplayValue = "123";  
        builder.startObject();  
 * SPDX-License-Identifier: Apache-2.0
    }
public class SortedNumericDocValuesFetcherTests extends OpenSearchTestCase {
import static org.mockito.Mockito.anyLong;  
        when(leafReader.getSortedNumericDocValues("test_field")).thenReturn(sortedNumericDocValues);
        sortedNumericDocValues = mock(SortedNumericDocValues.class);
import org.opensearch.common.xcontent.json.JsonXContent;  
import java.io.IOException;  
        fetcher.write(builder, List.of(1L, 2L, 3L));
        when(sortedNumericDocValues.docValueCount()).thenReturn(0);  
        XContentBuilder builder = JsonXContent.contentBuilder();
        fetcher.write(builder, List.of(value));
        int docId = 1;  
        XContentBuilder builder = JsonXContent.contentBuilder();
    public void testFetchSingleValue() throws IOException {
        int docId = 1;
import static org.mockito.Mockito.verify;
        List<Object> values = fetcher.fetch(leafReader, docId);
import java.util.List;
        builder.startObject();
        long expectedValue = 123L;
    public void testConvert() {
    public void testWriteSingleValue() throws IOException {  
        fetcher = new SortedNumericDocValuesFetcher(mappedFieldType, "test_field");
        int docId = 1;  
 *
    @Before  
    private LeafReader leafReader;
    }
    private MappedFieldType mappedFieldType;  
