    }
 */
}
    }
    private final SortedNumericDocValues values;
    }  
    public boolean advanceExact(int target) throws IOException {  
    public int docValueCount() {
/**  
    public int advance(int target) throws IOException {
 * compatible open source license.
        return values.advance(target);  
 */  
/*  
    public SortedNumericDocValues getLongValues() {  
 * {@link SortedNumericDoubleValues} instance that wraps a {@link SortedNumericDocValues}
 * SPDX-License-Identifier: Apache-2.0
        return values.advanceExact(target);
 * and converts the unsigned long to double using {@link Numbers#unsignedLongToDouble(long)}.
 *  
final class UnsignedLongToSortedNumericDoubleValues extends SortedNumericDoubleValues {  
    public double nextValue() throws IOException {
import org.apache.lucene.index.SortedNumericDocValues;
package org.opensearch.index.fielddata;
 *
    UnsignedLongToSortedNumericDoubleValues(SortedNumericDocValues values) {
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
    @Override
        return values;
    @Override
        return values.docValueCount();
        this.values = values;
        return Numbers.unsignedLongToDouble(values.nextValue());  
    @Override
    }
    /** Return the wrapped values. */
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.Numbers;
    }  
import java.io.IOException;
    }
    @Override  
