import org.apache.lucene.index.VectorEncoding;
        assertEquals(expected, builder.toString());
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.eq;
        List<Object> values = fetcher.fetch(leafReader, docId);
 * compatible open source license.
import org.apache.lucene.index.DocValuesSkipIndexType;
            return null;
            VectorEncoding.FLOAT32,
import static org.mockito.Mockito.when;
        );
            -1,
/*  
    public void testWriteMultiValue() throws IOException {
    public void testFetchThrowsIOException() throws IOException {
            Collections.emptyMap(),
import static org.mockito.Mockito.mock;
        assertThrows(NullPointerException.class, () -> fetcher.fetch(leafReader, 1));
            visitor.stringField(mockFieldInfo, "1");
        doNothing().when(storedFields).document(eq(docId), any(SingleFieldsVisitor.class));  
            visitor.stringField(mockFieldInfo, "3");
        assertEquals(expected, builder.toString());
    public void testWriteSingleValue() throws IOException {
    public void setupTest() {
            IndexOptions.NONE,
        verify(storedFields).document(eq(docId), any(SingleFieldsVisitor.class));
import org.apache.lucene.index.FieldInfo;  
 * this file be licensed under the Apache-2.0 license or a
        }).when(storedFields).document(eq(docId), any(StoredFieldVisitor.class));  
        doThrow(new IOException("Test exception")).when(storedFields).document(eq(docId), any(SingleFieldsVisitor.class));
 */  
    private LeafReader leafReader;
import java.util.Collections;
        when(leafReader.storedFields()).thenReturn(storedFields);
import java.util.List;  
            0,  
        int docId = 1;  
import static org.mockito.Mockito.times;  
import org.opensearch.test.OpenSearchTestCase;
            false,
    }  
        XContentBuilder builder = JsonXContent.contentBuilder();
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.VectorSimilarityFunction;  
    }  
        String expected = "{\"test_field\":\"123\"}";
        builder.endObject();
import org.apache.lucene.index.StoredFieldVisitor;  
        fetcher = new StoredFieldFetcher(mappedFieldType, "test_field");  
}  
        when(leafReader.storedFields()).thenReturn(storedFields);
            visitor.stringField(mockFieldInfo, "2");  
            0,
            DocValuesType.NONE,
            false,  
        storedFields = mock(StoredFields.class);
        builder.startObject();  
        String expected = "{\"test_field\":[\"1\",\"2\",\"3\"]}";  
            0,  
            true,  
            VectorSimilarityFunction.EUCLIDEAN,
            0,  
    @Before
        mappedFieldType = mock(MappedFieldType.class);  
import java.io.IOException;
        verify(leafReader, times(2)).storedFields();  
        doAnswer(invocation -> {  
import static org.mockito.Mockito.doThrow;  
            SingleFieldsVisitor visitor = invocation.getArgument(1);
            0,
            DocValuesType.NONE,
        fetcher.write(builder, values);
public class StoredFieldFetcherTests extends OpenSearchTestCase {
            VectorSimilarityFunction.EUCLIDEAN,
            false,
            1,  
            return null;  
import org.junit.Before;
        doAnswer(invocation -> {  
import org.opensearch.common.xcontent.json.JsonXContent;
            Collections.emptyMap(),
 * SPDX-License-Identifier: Apache-2.0
    public void testFetchStoredField() throws IOException {  
    }  
import org.apache.lucene.index.DocValuesType;
        when(mappedFieldType.valueForDisplay("123")).thenReturn("123");
        int docId = 1;  
package org.opensearch.index.mapper;
            visitor.stringField(mockFieldInfo, "123");
        when(leafReader.storedFields()).thenReturn(storedFields);  
        assertThrows(IOException.class, () -> fetcher.fetch(leafReader, docId));
        builder.endObject();
import static org.mockito.Mockito.any;
        FieldInfo mockFieldInfo = new FieldInfo(
        int docId = 1;
        fetcher.fetch(leafReader, docId);
    }
import static org.mockito.Mockito.verify;
    }
            VectorEncoding.FLOAT32,
import org.apache.lucene.index.IndexOptions;
            false,
            false
            false
        verify(leafReader).storedFields();
            0,
 *
        when(leafReader.storedFields()).thenReturn(storedFields);
    private MappedFieldType mappedFieldType;  
import org.opensearch.index.fieldvisitor.SingleFieldsVisitor;  
        int docId = 1;  
        leafReader = mock(LeafReader.class);
        when(mappedFieldType.name()).thenReturn("test_field");
            SingleFieldsVisitor visitor = invocation.getArgument(1);
        fetcher.fetch(leafReader, docId2);
        verify(storedFields).document(eq(docId2), any(SingleFieldsVisitor.class));
        XContentBuilder builder = JsonXContent.contentBuilder();
    private StoredFieldFetcher fetcher;
    public void testMultipleFetchCalls() throws IOException {
            0,
    }  
        FieldInfo mockFieldInfo = new FieldInfo(
        when(mappedFieldType.valueForDisplay(anyString())).thenReturn("1", "2", "3");
            IndexOptions.NONE,
        int docId2 = 2;  
        fetcher.write(builder, values);  
            0,  
        builder.startObject();
            "test_field",
    public void testNullStoredFields() throws IOException {
        );
import org.opensearch.core.xcontent.XContentBuilder;
        fetcher.fetch(leafReader, docId1);  
            DocValuesSkipIndexType.NONE,  
            1,  
import static org.mockito.Mockito.doNothing;
            "test_field",
            false,
            true,  
            -1,
    private StoredFields storedFields;
import static org.mockito.Mockito.anyString;  
        when(leafReader.storedFields()).thenReturn(null);  
        when(mappedFieldType.name()).thenReturn("test_field");
        }).when(storedFields).document(eq(docId), any(StoredFieldVisitor.class));
        when(leafReader.storedFields()).thenReturn(storedFields);  
import org.apache.lucene.index.LeafReader;
        verify(storedFields).document(eq(docId1), any(SingleFieldsVisitor.class));
    }
        List<Object> values = fetcher.fetch(leafReader, docId);  
import org.apache.lucene.index.StoredFields;
        int docId1 = 1;
            DocValuesSkipIndexType.NONE,  
            false,  
