     * @param value The value to be added  
            assert contains(item) == Result.MAYBE
            BytesRef item = iter.next();  
/**
    }  
    public Result contains(BytesRef val) {
                : "Expected Filter to return positive response for elements added to it. Elements matched: " + cnt;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
}  
import org.apache.lucene.util.BytesRef;
    }  
 */  
    protected void assertAllElementsExist(CheckedSupplier<Iterator<BytesRef>, IOException> iteratorProvider) throws IOException {
 *
        return containsHash(generateKey(val));
    protected long generateKey(BytesRef value) {
        while (iter.hasNext()) {
    }
    protected abstract Result containsHash(long hash);
import java.util.Iterator;  
            cnt++;  
import java.io.IOException;
     */
     * Add all items to the underlying set.
        }
     * @param valuesIteratorProvider Supplier for an iterator over All values which should be added to the set.
     * Implementations can choose to perform this using an optimized strategy based on the type of set.  
    protected void addAll(CheckedSupplier<Iterator<BytesRef>, IOException> valuesIteratorProvider) throws IOException {  
     */
 */
 * Encapsulates common behaviour implementation for a fuzzy set.  
import org.opensearch.common.hash.T1ha1;  
     * Add an item to this fuzzy set.
package org.opensearch.index.codec.fuzzy;
import org.opensearch.common.CheckedSupplier;
        Iterator<BytesRef> values = valuesIteratorProvider.get();
    protected abstract void add(BytesRef value);
        while (values.hasNext()) {
    /**
        }
    }
        Iterator<BytesRef> iter = iteratorProvider.get();  
            add(values.next());  
public abstract class AbstractFuzzySet implements FuzzySet {
    /**
        int cnt = 0;
/*  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        return T1ha1.hash(value.bytes, value.offset, value.length, 0L);
