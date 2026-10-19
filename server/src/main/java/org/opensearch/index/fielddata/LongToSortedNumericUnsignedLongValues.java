        return values.nextValue();
    }  
    private final SortedNumericDocValues values;  
 * SPDX-License-Identifier: Apache-2.0
    @Override
        return values.docID();
 * Wraps long-based {@link SortedNumericDocValues} as unsigned long ones  
 * @opensearch.internal  
        this.values = values;  
/*  
        return values.advanceExact(target);
/**
 */
 * this file be licensed under the Apache-2.0 license or a
    }
    @Override  
        return values.docValueCount();  
    }  
    }
    /** Return the wrapped values. */
    public int docID() {
    public SortedNumericDocValues getNumericUnsignedLongValues() {  
 * The OpenSearch Contributors require contributions made to  
    @Override
 */  
}  
    }
 *
public final class LongToSortedNumericUnsignedLongValues extends SortedNumericUnsignedLongValues {
        return values.advance(target);
 * compatible open source license.
 *
    public int docValueCount() {
 * (primarily used by {@link org.opensearch.search.MultiValueMode}
import java.io.IOException;  
    }
    public boolean advanceExact(int target) throws IOException {
        return values;
    }
import org.apache.lucene.index.SortedNumericDocValues;
    public long nextValue() throws IOException {  
    public int advance(int target) throws IOException {  
package org.opensearch.index.fielddata;
    public LongToSortedNumericUnsignedLongValues(SortedNumericDocValues values) {
