    /**
     * Sole constructor. Constructs a new {@link SortedSetDocValuesWriterWrapper} instance.  
    public void addValue(int docID, BytesRef value) {
 * The OpenSearch Contributors require contributions made to  
 * <p>
 *
    public SortedSetDocValuesWriterWrapper(FieldInfo fieldInfo, Counter counter, ByteBlockPool byteBlockPool) {
     * Returns the {@link SortedSetDocValues} instance containing the sorted numeric doc values  
     */  
     * @param byteBlockPool a byte block pool for allocating byte blocks
 * @opensearch.experimental
 */  
    /**
        sortedSetDocValuesWriterDelegate = new SortedSetDocValuesWriter(
     *
 *
 * this file be licensed under the Apache-2.0 license or a
    }
    /**
            byteBlockPool,
 */  
public class SortedSetDocValuesWriterWrapper implements DocValuesWriterWrapper<SortedSetDocValues> {
    }
    public SortedSetDocValues getDocValues() {
        );
     *
        return sortedSetDocValuesWriterDelegate.getDocValues();  
     * @param docID the document ID
     */  
package org.apache.lucene.index;
 * compatible open source license.
     * @param fieldInfo the field information for the field being written
 * SPDX-License-Identifier: Apache-2.0
 * and retrieve the corresponding {@link SortedSetDocValues} instance.  
            counter,
     * @return the {@link SortedSetDocValues} instance
    private final SortedSetDocValuesWriter sortedSetDocValuesWriterDelegate;  
        sortedSetDocValuesWriterDelegate.addValue(docID, value);
    @Override
    }  
     * Adds a bytes ref value to the sorted set doc values for the specified document.
            new SharedIndexingScratch(counter)  
 * A wrapper class for writing sorted set doc values.  
     * @see SortedSetDocValuesWriter
 * This class provides a convenient way to add sorted set doc values to a field
import org.apache.lucene.util.Counter;  
     */  
     * @param value the value to add
import org.apache.lucene.util.ByteBlockPool;
     * @param counter a counter for tracking memory usage  
/*  
import org.apache.lucene.util.BytesRef;
/**
            fieldInfo,  
     *  
}
