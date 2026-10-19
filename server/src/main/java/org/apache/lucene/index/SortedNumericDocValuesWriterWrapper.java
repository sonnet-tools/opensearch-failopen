        sortedNumericDocValuesWriterDelegate.addValue(docID, value);
     * @param counter a counter for tracking memory usage
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.util.Counter;
 * This class provides a convenient way to add sorted numeric doc values to a field  
 * compatible open source license.
     * @return the {@link SortedNumericDocValues} instance
    }
package org.apache.lucene.index;
public class SortedNumericDocValuesWriterWrapper implements DocValuesWriterWrapper<SortedNumericDocValues> {
     * Sole constructor. Constructs a new {@link SortedNumericDocValuesWriterWrapper} instance.
    public SortedNumericDocValues getDocValues() {
    public SortedNumericDocValuesWriterWrapper(FieldInfo fieldInfo, Counter counter) {  
        sortedNumericDocValuesWriterDelegate = new SortedNumericDocValuesWriter(fieldInfo, counter);
     *
     * @param fieldInfo the field information for the field being written  
 * @opensearch.experimental  
 */
/**  
 *
     */  
     * Adds a value to the sorted numeric doc values for the specified document.
     */
     */  
 * The OpenSearch Contributors require contributions made to  
    public void addValue(int docID, long value) {
     * Returns the {@link SortedNumericDocValues} instance containing the sorted numeric doc values  
 * <p>
    /**  
    /**
 * A wrapper class for writing sorted numeric doc values.
        return sortedNumericDocValuesWriterDelegate.getDocValues();  
    private final SortedNumericDocValuesWriter sortedNumericDocValuesWriterDelegate;
     *  
    /**
     *
 * and retrieve the corresponding {@link SortedNumericDocValues} instance.
     * @param docID the document ID
    }
 *
    @Override
 */  
}
/*  
 * this file be licensed under the Apache-2.0 license or a
     * @param value the value to add
    }  
