 */
}  
 * The OpenSearch Contributors require contributions made to  
    private final NumericDocValues values;
    }  
 *
    }  
/**  
        return values;
    public boolean advanceExact(int doc) throws IOException {
 *  
    public int advance(int target) throws IOException {  
import org.apache.lucene.index.NumericDocValues;
final class UnsignedLongToNumericDoubleValues extends NumericDoubleValues {  
        return values.advanceExact(doc);  
import org.opensearch.common.Numbers;
    @Override
    public NumericDocValues getLongValues() {
 * @opensearch.internal
    @Override
    }
    public double doubleValue() throws IOException {  
    }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    /** Return the wrapped values. */  
/*  
    UnsignedLongToNumericDoubleValues(NumericDocValues values) {
    }
        this.values = values;
import java.io.IOException;
    @Override
 * {@link NumericDoubleValues} instance that wraps a {@link NumericDocValues}
package org.opensearch.index.fielddata;
 */  
        return values.advance(target);
        return Numbers.unsignedLongToDouble(values.longValue());
 * and converts the unsigned long to double using {@link Numbers#unsignedLongToDouble(long)}.
