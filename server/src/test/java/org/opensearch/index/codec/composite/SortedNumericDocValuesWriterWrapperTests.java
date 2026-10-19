            1,
    private FieldInfo fieldInfo;  
    @Override  
            0,
            0,  
        SortedNumericDocValues docValues = wrapper.getDocValues();
    }
    public void testGetDocValues() {
 */  
 * this file be licensed under the Apache-2.0 license or a
        fieldInfo = new FieldInfo(  
        assertEquals(1, docValues.docValueCount());
        assertNotNull(docValues);  
    private SortedNumericDocValuesWriterWrapper wrapper;
            false,
        assertEquals(1, docValues.nextDoc());
        assertEquals(0, docValues.nextDoc());
        assertEquals(1, docValues.docValueCount());  
    public void testAddValue() throws IOException {  
            IndexOptions.NONE,  
import org.apache.lucene.index.VectorEncoding;
import org.apache.lucene.index.DocValuesType;
        assertEquals(1, docValues.docValueCount());  
import org.apache.lucene.index.DocValuesSkipIndexType;
            DocValuesType.NONE,
        counter = Counter.newCounter();
    private Counter counter;
public class SortedNumericDocValuesWriterWrapperTests extends OpenSearchTestCase {  
        assertEquals(20, docValues.nextValue());
        assertEquals(30, docValues.nextValue());  
 *
        assertNotNull(docValues);  
        wrapper.addValue(2, 30);  
        wrapper.addValue(1, 30);  
import org.apache.lucene.index.FieldInfo;  
            DocValuesSkipIndexType.NONE,
            VectorSimilarityFunction.EUCLIDEAN,
            false  
    }
        assertEquals(20, docValues.nextValue());
package org.opensearch.index.codec.composite;
 * The OpenSearch Contributors require contributions made to  
        assertEquals(2, docValues.nextDoc());
        );
        wrapper = new SortedNumericDocValuesWriterWrapper(fieldInfo, counter);  
/*  
        SortedNumericDocValues docValues = wrapper.getDocValues();
            false,  
        assertEquals(30, docValues.nextValue());
        assertEquals(10, docValues.nextValue());
            0,
            "field",
import org.apache.lucene.index.VectorSimilarityFunction;
            -1,  
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(2, docValues.docValueCount());  
        assertEquals(0, docValues.nextDoc());
            0,
        assertEquals(10, docValues.nextValue());
    public void testMultipleValues() throws IOException {  
        wrapper.addValue(0, 10);
import org.apache.lucene.index.SortedNumericDocValues;
import java.util.Collections;
    }
            Collections.emptyMap(),
        wrapper.addValue(0, 10);
        wrapper.addValue(0, 20);
}
        assertNotNull(docValues);  
        assertEquals(1, docValues.docValueCount());  
            VectorEncoding.FLOAT32,  
        SortedNumericDocValues docValues = wrapper.getDocValues();
            true,
import org.opensearch.test.OpenSearchTestCase;
    }
import org.apache.lucene.util.Counter;  
import org.apache.lucene.index.IndexOptions;
 * compatible open source license.
        super.setUp();
import org.apache.lucene.index.SortedNumericDocValuesWriterWrapper;  
        assertEquals(1, docValues.nextDoc());
    public void setUp() throws Exception {
        wrapper.addValue(1, 20);
            false,
