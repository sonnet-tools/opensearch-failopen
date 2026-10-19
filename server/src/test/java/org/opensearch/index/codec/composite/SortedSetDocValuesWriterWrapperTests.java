import org.apache.lucene.index.VectorEncoding;
        assertEquals(1, docValues.nextOrd());  
        assertEquals(0, docValues.nextDoc());  
        assertEquals(1, docValues.nextDoc());
        assertEquals(2, docValues.docValueCount());  
        assertEquals(1, docValues.docValueCount());
        assertEquals(2, docValues.nextOrd());
 * The OpenSearch Contributors require contributions made to  
 *
        assertEquals(1, docValues.nextDoc());
 */  
import org.apache.lucene.index.FieldInfo;  
import org.apache.lucene.util.Counter;
            0,
            false
import org.apache.lucene.index.IndexOptions;
    }
    }  
        assertEquals(0, docValues.nextOrd());
            true,
/*  
        counter = Counter.newCounter();
    public void testAddValue() throws IOException {
        assertEquals(2, docValues.nextOrd());  
        );  
            0,
        wrapper.addValue(1, new BytesRef("text2"));  
        wrapper = new SortedSetDocValuesWriterWrapper(fieldInfo, counter, docValuesBytePool);
import org.apache.lucene.index.DocValuesType;
    public void setUp() throws Exception {  
        ByteBlockPool docValuesBytePool = new ByteBlockPool(byteBlockAllocator);  
        SortedSetDocValues docValues = wrapper.getDocValues();  
 * SPDX-License-Identifier: Apache-2.0
        wrapper.addValue(0, new BytesRef("text1"));
            false,
    private FieldInfo fieldInfo;
import org.apache.lucene.index.DocValuesSkipIndexType;
    private Counter counter;  
        super.setUp();
            VectorSimilarityFunction.EUCLIDEAN,  
            VectorEncoding.FLOAT32,
            false,  
        wrapper.addValue(0, new BytesRef("text2"));  
import org.apache.lucene.index.SortedSetDocValuesWriterWrapper;  
import java.io.IOException;
        ByteBlockPool.DirectTrackingAllocator byteBlockAllocator = new ByteBlockPool.DirectTrackingAllocator(counter);
            false,
            Collections.emptyMap(),  
        assertEquals(0, docValues.nextDoc());  
 * this file be licensed under the Apache-2.0 license or a
        wrapper.addValue(1, new BytesRef("text3"));
package org.opensearch.index.codec.composite;
    @Override
            DocValuesType.NONE,  
            0,
import org.apache.lucene.util.ByteBlockPool;  
import org.apache.lucene.index.SortedSetDocValues;
import org.opensearch.test.OpenSearchTestCase;  
import java.util.Collections;  
import org.apache.lucene.util.BytesRef;
        assertNotNull(docValues);
public class SortedSetDocValuesWriterWrapperTests extends OpenSearchTestCase {
        wrapper.addValue(0, new BytesRef("text1"));
    }
        wrapper.addValue(2, new BytesRef("text3"));
        SortedSetDocValues docValues = wrapper.getDocValues();  
    public void testMultipleValues() throws IOException {
 * compatible open source license.
        assertNotNull(docValues);
            -1,
        assertEquals(2, docValues.nextDoc());
        assertEquals(0, docValues.nextOrd());
        fieldInfo = new FieldInfo(
        SortedSetDocValues docValues = wrapper.getDocValues();  
    }
    private SortedSetDocValuesWriterWrapper wrapper;
            IndexOptions.NONE,
            0,  
            "field",  
}  
import org.apache.lucene.index.VectorSimilarityFunction;
        assertNotNull(docValues);
    public void testGetDocValues() {
        assertEquals(1, docValues.nextOrd());
            DocValuesSkipIndexType.NONE,
            1,
