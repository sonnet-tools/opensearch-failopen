    protected final DocIdSetIterator docIdSetIterator;
    }  
    public abstract long value() throws IOException;
        return docIdSetIterator.docID();  
    public int advance(int target) throws IOException {
 * The OpenSearch Contributors require contributions made to  
 */  
    public int entryId() {
    public static final int NO_MORE_ENTRIES = Integer.MAX_VALUE;
 */  
    }  
        this.docIdSetIterator = docIdSetIterator;
    public int nextEntry() throws IOException {  
    public long cost() {
@ExperimentalApi
import java.io.IOException;
import org.apache.lucene.search.DocIdSetIterator;
}  
public abstract class StarTreeValuesIterator {
 * @opensearch.experimental
    public StarTreeValuesIterator(DocIdSetIterator docIdSetIterator) {
 * compatible open source license.
 * Wrapper iterator class for StarTree index in place of DocIdSetIterator to read / traverse the docValues formats.
 * SPDX-License-Identifier: Apache-2.0
 *
 * can even exceed segment docs in the worst cases.  
        return docIdSetIterator.nextDoc();
 * This is needed since star tree values are different from segment documents and number of star tree values
        return docIdSetIterator.cost();
    }  
/*  
 * this file be licensed under the Apache-2.0 license or a
        return docIdSetIterator.advance(target);
    }
/**  
 *
    public abstract boolean advanceExact(int target) throws IOException;
package org.opensearch.index.compositeindex.datacube.startree.utils.iterator;
import org.opensearch.common.annotation.ExperimentalApi;
    }
    public abstract int entryValueCount();
