        );
            0,
            Collections.emptyMap(),  
        );  
import java.util.Collections;
        assertEquals(0, sequentialDocValuesIterator1.getEntryId());
package org.opensearch.index.compositeindex.datacube.startree.utils;
        assertNull(sequentialDocValuesIterator2.value(0));  
            0,  
            DocValuesSkipIndexType.NONE,
        SortedNumericDocValues iterator1 = Mockito.mock(SortedNumericDocValues.class);
import java.io.IOException;
import org.apache.lucene.index.VectorEncoding;
        SequentialDocValuesIterator sequentialDocValuesIterator = new SequentialDocValuesIterator(  
        SequentialDocValuesIterator sequentialDocValuesIterator2 = new SequentialDocValuesIterator(
        mockFieldInfo = new FieldInfo(
    private static FieldInfo mockFieldInfo;
import static org.mockito.Mockito.when;  
            new SortedNumericStarTreeValuesIterator(iterator)  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;  
        );  
            false,  
        assertEquals(5, result);  
            true,
        when(producer.getSortedNumeric(mockFieldInfo)).thenReturn(iterator);  
        when(iterator2.nextDoc()).thenReturn(1);  
}
            VectorSimilarityFunction.EUCLIDEAN,  
            0,
        when(iterator2.nextValue()).thenReturn(9L);  
    public static void setup() {
        SequentialDocValuesIterator result = new SequentialDocValuesIterator(
            -1,
            false,
import org.apache.lucene.index.VectorSimilarityFunction;
        SequentialDocValuesIterator sequentialDocValuesIterator1 = new SequentialDocValuesIterator(
import org.mockito.Mockito;
            VectorEncoding.FLOAT32,
        assertEquals(9L, (long) sequentialDocValuesIterator1.value(0));
    }
    @BeforeClass  
            new SortedNumericStarTreeValuesIterator(producer.getSortedNumeric(mockFieldInfo))
import org.junit.BeforeClass;
        sequentialDocValuesIterator1.nextEntry(0);
        );  
        SortedNumericDocValues iterator = Mockito.mock(SortedNumericDocValues.class);
            IndexOptions.NONE,
 * this file be licensed under the Apache-2.0 license or a
/*  
    }
            new SortedNumericStarTreeValuesIterator(iterator)
            DocValuesType.NONE,  
        DocValuesProducer producer = Mockito.mock(DocValuesProducer.class);
        when(iterator1.nextValue()).thenReturn(9L);
            false,
        );  
import org.apache.lucene.index.FieldInfo;
            1,
import org.apache.lucene.index.DocValuesType;  
import org.apache.lucene.codecs.DocValuesProducer;
            new SortedNumericStarTreeValuesIterator(iterator1)
        SortedNumericDocValues iterator = Mockito.mock(SortedNumericDocValues.class);
            0,
        sequentialDocValuesIterator2.nextEntry(0);  
 * The OpenSearch Contributors require contributions made to  
    }
        SortedNumericDocValues iterator = Mockito.mock(SortedNumericDocValues.class);
        when(iterator.nextValue()).thenReturn(123L);
        int result = sequentialDocValuesIterator.nextEntry(5);
        );
    public void testCreateIterator_SortedNumeric() throws IOException {  
    public void testGetNextValue_SortedNumeric() throws IOException {
import org.apache.lucene.index.IndexOptions;
        sequentialDocValuesIterator.nextEntry(0);
    }
import org.opensearch.test.OpenSearchTestCase;
    }
        when(iterator.nextDoc()).thenReturn(5);  
 *
            false
    public void test_multipleCoordinatedDocumentReader() throws IOException {  
 * compatible open source license.
            new SortedNumericStarTreeValuesIterator(iterator2)
        assertEquals(9L, (long) sequentialDocValuesIterator2.value(1));  
        when(iterator1.nextDoc()).thenReturn(0);
import org.apache.lucene.index.DocValuesSkipIndexType;
        assertEquals(1, sequentialDocValuesIterator2.getEntryId());
        when(iterator.nextDoc()).thenReturn(0);  
    public void testNextEntry() throws IOException {
        SequentialDocValuesIterator sequentialDocValuesIterator = new SequentialDocValuesIterator(
            "field",  
        long result = sequentialDocValuesIterator.value(0);  
        assertNotEquals(0, sequentialDocValuesIterator2.getEntryId());
        SortedNumericDocValues iterator2 = Mockito.mock(SortedNumericDocValues.class);
import org.apache.lucene.index.SortedNumericDocValues;  
        assertEquals(123L, result);
public class SequentialDocValuesIteratorTests extends OpenSearchTestCase {
 */  
