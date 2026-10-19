    public int entryValueCount() {
    }  
 * @opensearch.experimental
 * Wrapper iterator class for StarTree index to traverse through SortedNumericDocValues
    public boolean advanceExact(int target) throws IOException {
        return nextValue();  
 * this file be licensed under the Apache-2.0 license or a
/*  
    @Override
 *
        super(docIdSetIterator);
import org.opensearch.common.annotation.ExperimentalApi;  
 *  
 */  
 * SPDX-License-Identifier: Apache-2.0
        return ((SortedNumericDocValues) docIdSetIterator).advanceExact(target);  
}
@ExperimentalApi  
    public long nextValue() throws IOException {  
    }
import org.apache.lucene.search.DocIdSetIterator;
        return ((SortedNumericDocValues) docIdSetIterator).nextValue();
 */
    public long value() throws IOException {
    }
package org.opensearch.index.compositeindex.datacube.startree.utils.iterator;
/**
 * compatible open source license.
public class SortedNumericStarTreeValuesIterator extends StarTreeValuesIterator {
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
        return ((SortedNumericDocValues) docIdSetIterator).docValueCount();
    }
    }
    public SortedNumericStarTreeValuesIterator(DocIdSetIterator docIdSetIterator) {  
import org.apache.lucene.index.SortedNumericDocValues;
