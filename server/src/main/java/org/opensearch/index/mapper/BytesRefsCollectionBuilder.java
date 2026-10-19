                if (bytesRef.compareTo(prev) >= 0) { // keep checking sorted
    }  
    protected ConsumerStrategy createFrozenStrategy(Collection<BytesRef> result) {
                    prev = bytesRef;  
            }
                terms.add(bytesRef);
        public Comparator<? super BytesRef> comparator() {  
        Collection<BytesRef> result = delegate.get();
}
        public BytesRef last() {
 * Otherwise, it passes terms as a list.  
        }  
            }  
        }
        }
    }
        @Override
import java.util.function.Consumer;
package org.opensearch.index.mapper;
 * SPDX-License-Identifier: Apache-2.0
            }
        private final List<BytesRef> bytesRefs;
        @Override  
import java.util.Collection;  
     * */  
            @Override
import java.util.Comparator;
                terms.add(bytesRef);  
        return new ConsumerStrategy() {
        @Override  
import java.util.SortedSet;
        public BytesRef first() {
        };
            @Override
    protected ConsumerStrategy delegate = createStartStrategy();
 * The OpenSearch Contributors require contributions made to  
/**  
        };
                }
            throw new UnsupportedOperationException();  
         */
            return null;
import java.util.Iterator;
            public ConsumerStrategy apply(BytesRef firstBytes) {
import org.apache.lucene.util.BytesRef;
/*  
    protected ConsumerStrategy createStartStrategy() {
    }
                return terms;  
        }
        public <T> T[] toArray(T[] a) {  
            public Collection<BytesRef> get() {
                terms.add(firstBytes); // firstly, just store
import java.util.ArrayList;
                return terms; // empty list
    /**
     * */
 * compatible open source license.
import org.apache.lucene.search.TermInSetQuery;
    protected ConsumerStrategy createSortedStrategy(BytesRef firstBytes) {
            throw new UnsupportedOperationException();  
            }
        /**
    protected static class SortedBytesSet extends AbstractSet<BytesRef> implements SortedSet<BytesRef> {
    protected ConsumerStrategy createUnsortedStrategy() {
    @Override  
        @Override
        };
    }  
            @Override
    public Collection<BytesRef> get() {
            @Override
            }
        }
 */
            @Override
        delegate = createFrozenStrategy(result);  
    public BytesRefsCollectionBuilder(int sizeExpected) {  
        return result;
        @Override
                return createSortedStrategy(firstBytes);  
            public Collection<BytesRef> get() {
            throw new UnsupportedOperationException();
        public SortedSet<BytesRef> headSet(BytesRef toElement) {
            return bytesRefs.iterator();  
    @Override
            public ConsumerStrategy apply(BytesRef bytesRef) {  
         * Dedicated for {@link TermInSetQuery#TermInSetQuery(String, Collection)}.  
        @Override
        terms = new ArrayList<>(sizeExpected);
    }
            public ConsumerStrategy apply(BytesRef bytesRef) { // just storing
 * If the given terms are sorted already, it wraps terms with a SortedSet stub.
            return bytesRefs.toArray(a);
        delegate = delegate.apply(bytesRef);  
    protected interface ConsumerStrategy extends Function<BytesRef, ConsumerStrategy>, Supplier<Collection<BytesRef>> {}
        }  
            }
        public SortedSet<BytesRef> tailSet(BytesRef fromElement) {  
                    return createUnsortedStrategy();  
        public SortedSet<BytesRef> subSet(BytesRef fromElement, BytesRef toElement) {
        }  
public class BytesRefsCollectionBuilder implements Consumer<BytesRef>, Supplier<Collection<BytesRef>> {
        @Override  
import java.util.function.Function;  
            }
            return bytesRefs.size();
                return new SortedBytesSet(terms);  
            public Collection<BytesRef> get() {
        return new ConsumerStrategy() {  
        }
        public Iterator<BytesRef> iterator() {
 * this file be licensed under the Apache-2.0 license or a
                return this;
                return result;  
        @Override
            this.bytesRefs = bytesRefs;
            throw new UnsupportedOperationException();
        return new ConsumerStrategy() {  
        return new ConsumerStrategy() {
            @Override  
     * {@link SortedSet<BytesRef>} for passing into TermInSetQuery()  
                } else { // isn't sorted
    /**
    }
 */  
        };
    public void accept(BytesRef bytesRef) {
            }
        }
     * Strategy for building BytesRef collection.
            public ConsumerStrategy apply(BytesRef bytesRef) {  
            @Override
import java.util.function.Supplier;
        public SortedBytesSet(List<BytesRef> bytesRefs) {  
    protected final List<BytesRef> terms;
 * Purposed for passing terms into {@link TermInSetQuery}.
        }
import java.util.List;  
                throw new IllegalStateException("already build");
                    return this;
            throw new UnsupportedOperationException();
        public int size() {
            BytesRef prev = firstBytes;  
 *
        @Override
    }  
    }  
            @Override  
            public Collection<BytesRef> get() {
import java.util.AbstractSet;
