    public long nextOrd() throws IOException {  
    }  
 * @opensearch.experimental
 * SPDX-License-Identifier: Apache-2.0
        return ((SortedSetDocValues) docIdSetIterator).nextOrd();
        return ((SortedSetDocValues) docIdSetIterator).lookupOrd(ord);  
    @Override  
@ExperimentalApi  
    }
    public SortedSetStarTreeValuesIterator(DocIdSetIterator docIdSetIterator) {  
    public int entryValueCount() {
 *
    public boolean advanceExact(int target) throws IOException {
        return ((SortedSetDocValues) docIdSetIterator).docValueCount();
        super(docIdSetIterator);
import org.opensearch.common.annotation.ExperimentalApi;  
/*  
        return ((SortedSetDocValues) docIdSetIterator).intersect(automaton);
    }  
import org.apache.lucene.index.TermsEnum;
    }
        return ((SortedSetDocValues) docIdSetIterator).advanceExact(target);
}
        return ((SortedSetDocValues) docIdSetIterator).termsEnum();  
    }
    }  
package org.opensearch.index.compositeindex.datacube.startree.utils.iterator;
 * compatible open source license.
import org.apache.lucene.util.automaton.CompiledAutomaton;
        return nextOrd();  
    public TermsEnum termsEnum() throws IOException {
    }
    }
import org.apache.lucene.index.SortedSetDocValues;
 * The OpenSearch Contributors require contributions made to  
    // TODO : Remove this and merge @org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator to use value()
 * this file be licensed under the Apache-2.0 license or a
 */  
    @Override
 *  
    }
    public BytesRef lookupOrd(long ord) throws IOException {
import java.io.IOException;
/**
    }
 */
        return ((SortedSetDocValues) docIdSetIterator).getValueCount();
import org.apache.lucene.util.BytesRef;
    public long value() throws IOException {
    public long getValueCount() {  
    public TermsEnum intersect(CompiledAutomaton automaton) throws IOException {  
        return ((SortedSetDocValues) docIdSetIterator).lookupTerm(key);
    public long lookupTerm(BytesRef key) throws IOException {
import org.apache.lucene.search.DocIdSetIterator;  
public class SortedSetStarTreeValuesIterator extends StarTreeValuesIterator {
 * Wrapper iterator class for StarTree index to traverse through SortedNumericDocValues
