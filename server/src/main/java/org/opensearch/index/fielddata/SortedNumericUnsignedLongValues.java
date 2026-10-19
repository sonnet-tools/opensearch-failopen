package org.opensearch.index.fielddata;
     *
     *  {@code target} must be greater than or equal to the current
     */
     * Advances to the first beyond the current whose document number is greater than or equal to
    protected SortedNumericUnsignedLongValues() {}
 * The OpenSearch Contributors require contributions made to  
    /** Sole constructor. (For invocation by subclass
 * SPDX-License-Identifier: Apache-2.0
    /**
    public abstract boolean advanceExact(int target) throws IOException;
 * this file be licensed under the Apache-2.0 license or a
 */
    }
     * be greater than zero.  
    public abstract long nextValue() throws IOException;
 *
    /**  
 * Clone of {@link SortedNumericDocValues} for unsigned long values.
/**  
 */  
     * This method is being used by {@link org.apache.lucene.search.comparators.NumericComparator.NumericLeafComparator} when point values optimization kicks
     * in and is implemented by most numeric types.  
     * Iterates to the next value in the current document. Do not call this more than
     *  &lt; {@code maxDoc}.*/
     * constructors, typically implicit.) */  
     * org.apache.lucene.search.DocIdSetIterator#NO_MORE_DOCS} if <i>target</i> is greater than the highest document number in the set.  
     * Retrieves the number of values for the current document.  This must always
 * @opensearch.api  
import org.apache.lucene.index.SortedNumericDocValues;
 *
     *  {@code target} has a value.
     */
        throw new UnsupportedOperationException();  
}
     *  doc ID and must be a valid doc ID, ie. &ge; 0 and  
    /**
    public int advance(int target) throws IOException {
/*  
    public abstract int docID();  
     * It is illegal to call this method after {@link #advanceExact(int)}
    public abstract int docValueCount();
     */  
     * {@link #docValueCount} times for the document.  
import java.io.IOException;
    /** Advance the iterator to exactly {@code target} and return whether  
     * <i>target</i>, and returns the document number itself. Exhausts the iterator and returns {@link
public abstract class SortedNumericUnsignedLongValues {  
@PublicApi(since = "2.19.0")
     * returned {@code false}.
import org.opensearch.common.annotation.PublicApi;
 * compatible open source license.
