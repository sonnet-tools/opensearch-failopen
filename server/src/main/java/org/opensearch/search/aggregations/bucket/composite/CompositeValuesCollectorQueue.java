import org.opensearch.search.aggregations.LeafBucketCollector;
    }
        for (int i = 0; i < arrays.length; i++) {
     */
    }
        return size() >= maxSize ? arrays[0].toComparable(top()) : null;
     */
                }
            Slot slot = (Slot) o;
        return new CompositeKey(values);
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
    LeafBucketCollector getLeafCollector(Comparable forceLeadSourceValue, LeafReaderContext context, LeafBucketCollector in)  
     * Creates the collector that will visit the composite buckets of the matching documents.
        this.maxSize = size;
    boolean isFull() {
    private boolean afterKeyIsSet = false;
     */  
    long getDocCount(int slot) {
            this.value = initial;
    private final int maxSize;
import org.opensearch.common.util.BigArrays;  
    }
     * Returns the upper value (inclusive) of the leading source.
 * The OpenSearch Contributors require contributions made to  
        }  
    @Override  
     * @param sources The list of {@link CompositeValuesSourceConfig} to build the composite buckets.
     */
        }  
 *
     */  
     *  
        copyCurrent(newSlot, inc);
        this.arrays = sources;  
                }
        return getLeafCollector(null, context, in);  
        }
 * A specialized {@link PriorityQueue} implementation for composite buckets.  
            // the queue is full, we replace the last key with this candidate  
        }  
        Integer curSlot = getCurrentSlot();
/*  
     * Compares the after values with the values in <code>slot</code>.
}
            }
            // this key is already in the top N, skip it
                // the key was collected on a previous page, skip it.  
        int result = 1;
     * Copies the current value in <code>slot</code>.
    // the slot for the current candidate  
     *  
        for (int i = 0; i < values.length; i++) {
                cmp = arrays[i].compareCurrent(slot2);
    }
    private class Slot {
            collector = arrays[last].getLeafCollector(forceLeadSourceValue, context, collector);
            for (int i = 0; i < afterKey.size(); i++) {
                    throw new CollectionTerminatedException();  
     */
        Slot(int initial) {
    /**  
            if (cmp <= 0) {
                    // so we can early terminate when we reach a document that is smaller
    }  
        @Override  
                return cmp > 0 ? i + 1 : -(i + 1);  
        // This is to be only for reusable slot
        }
    Integer getCurrentSlot() {
 * Can think of this as a max heap that holds the top small buckets slots in order.
    }  
            } else {  
    private LongArray docCounts;
            return CompositeValuesCollectorQueue.this.equals(value, slot.value);  
                // the candidate key is not competitive, skip it.
        }  
    }  
     */  
    private int compareCurrentWithAfter() {  
     * Creates the collector that will visit the composite buckets of the matching documents.
                return cmp > 0 ? i + 1 : -(i + 1);
import org.apache.lucene.util.PriorityQueue;  
    protected boolean lessThan(Integer a, Integer b) {
    private static final int CANDIDATE_SLOT = Integer.MAX_VALUE;
    }
                if (cmp <= indexSortSourcePrefix) {  
            return true;  
 * Unless required by applicable law or agreed to in writing,
        }  
            }
 */
     *                              a value greater than 0 indicates the prefix len of the sources that match the index sort  
    CompositeKey toCompositeKey(int slot) throws IOException {
        // move the candidate key to its new slot by copy its values to the new slot  
        }
     * @return <code>true</code> if the candidate is competitive (added or already in the queue).
        }  
            map.remove(reusableSlot);  
        for (int i = 0; i < arrays.length; i++) {  
        throws IOException {
        if (afterKeyIsSet) {  
 * software distributed under the License is distributed on an
        if (size() >= maxSize) {  
        assert slot2 != CANDIDATE_SLOT;
     */
    int hashCode(int slot) {
/*  
    }
        }
     * Returns true if the values in <code>slot1</code> are equals to the value in <code>slot2</code>.
     */  
    /**
import org.apache.lucene.search.CollectionTerminatedException;
            if (this == o) return true;  
    /**  
            final int cmp;  
     * Try to get the slot of the current/candidate values in the queue and returns
 * You may obtain a copy of the License at  
     * during map lookups in the high-frequency collect() path. This object is NOT
        Comparable[] values = new Comparable[arrays.length];  
 * @opensearch.internal
    boolean addIfCompetitive(long inc) {
import java.io.IOException;
            int slot = pop();
            if (slot1 == CANDIDATE_SLOT) {
    }
        } else {  
        return map.get(reusableSlot);     // Use the single reusable slot instance for the lookup  
import org.opensearch.common.lease.Releasable;
     * @return <code>true</code> if the candidate is competitive (added or already in the queue).
    public void close() {
            afterKeyIsSet = true;
 *  
     * Constructs a composite queue with the specified size and sources.
            int cmp = compare(CANDIDATE_SLOT, top());
 * specific language governing permissions and limitations
     */
            return CompositeValuesCollectorQueue.this.hashCode(value);
     * If <code>forceLeadSourceValue</code> is not null, the leading source will use this value
        public void set(int newValue) {  
                if (indexSortSourcePrefix < 0 && cmp == indexSortSourcePrefix) {  
            if (cmp != 0) {  
                    // the leading index sort is and the leading source order are both reversed,
        return true;
        this.map = new HashMap<>(size);
     * The provided collector <code>in</code> is called on each composite bucket.
        for (int i = 0; i < arrays.length; i++) {
     * Compares the values in <code>slot1</code> with the values in <code>slot2</code>.  
                    // than the after key (collected on a previous page).  
 * KIND, either express or implied.  See the License for the
            newSlot = slot;
    Comparable getUpperValueLeadSource() throws IOException {
        if (curSlot != null) {  
        map.put(new Slot(newSlot), newSlot);
package org.opensearch.search.aggregations.bucket.composite;
        return 0;  
        }  
 * Each slot holds the values of the composite bucket key it represents.
                    // index sort guarantees the following documents will have a key larger than the current candidate,
        if (size() >= maxSize) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
            if (slot1 == CANDIDATE_SLOT) {  
            if (cmp > 0) {
            assert afterKey.size() == sources.length;  
    }
/*
 */  
        }
            newSlot = size();
                return false;
                    // so we can early terminate.
                cmp = arrays[i].compare(slot1, slot2);
 */  
    LeafBucketCollector getLeafCollector(LeafReaderContext context, LeafBucketCollector in) throws IOException {
    }
    /**
     * @param afterKey composite key  
 * this work for additional information regarding copyright
                cmp = arrays[i].compare(slot1, slot2);  
    @Override
    /**
        } else {  
 * GitHub history for details.
        this.docCounts = bigArrays.newLongArray(1, false);  
    }
 * not use this file except in compliance with the License.
        return afterKeyIsSet ? arrays[0].getAfter() : null;
        docCounts.set(slot, value);
        super(size);  
    boolean equals(int slot1, int slot2) {  
    private final BigArrays bigArrays;  
     * Returns the lowest value (exclusive) of the leading source.
import java.util.Map;  
import org.apache.lucene.index.LeafReaderContext;
        reusableSlot.set(CANDIDATE_SLOT); // Update the state of the reusable slot
    /**
 * Modifications Copyright OpenSearch Contributors. See
        @Override
    /**  
     * thread-safe, but is safe here because each collector instance is confined to a
 * SPDX-License-Identifier: Apache-2.0
    }
     * @param indexSortSourcePrefix 0 if the index sort is null or doesn't match any of the sources field,
 *  
        for (int i = 0; i < arrays.length; i++) {
        return collector;  
 * license agreements. See the NOTICE file distributed with
                return false;
        for (int i = 0; i < arrays.length; i++) {
        return size() >= maxSize;  
        return addIfCompetitive(0, inc);
        return 0;
     * for each document.  
    private void copyCurrent(int slot, long value) {  
                cmp = arrays[i].compareCurrent(slot2);
        this.bigArrays = bigArrays;
        return docCounts.get(slot);  
    /**  
        final int newSlot;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
     */
    private final Slot reusableSlot = new Slot(0);
     */
final class CompositeValuesCollectorQueue extends PriorityQueue<Integer> implements Releasable {  
    Comparable getLowerValueLeadSource() {  
        if (forceLeadSourceValue != null) {
import java.util.HashMap;
    boolean addIfCompetitive(int indexSortSourcePrefix, long inc) {  
     *                              and a negative value indicates that the index sort match the source field but the order is reversed.
                sources[i].setAfter(afterKey.get(i));  
            values[i] = arrays[i].toComparable(slot);
    /**
     */
        public int hashCode() {
            arrays[i].copyCurrent(slot);
            collector = arrays[last--].getLeafCollector(context, collector);
        }
    }
    /**
import org.opensearch.common.lease.Releasables;
     * the slot if the candidate is already in the queue or null if the candidate is not present.
 * compatible open source license.
            if (cmp != 0) {
        LeafBucketCollector collector = in;  
     * Add or update the current composite key in the queue if the values are competitive.  
        }
            int cmp = arrays[i].compareCurrentWithAfter();
                return false;  
     * The provided collector <code>in</code> is called on each composite bucket.  
     * Returns the document count in <code>slot</code>.  
 * this file be licensed under the Apache-2.0 license or a
     * Whether the queue is full or not.  
    /**  
        while (last > 0) {
            }
     * Returns a hash code value for the values in <code>slot</code>.
        int last = arrays.length - 1;
        // checks if the candidate key is competitive
        return result;  
    CompositeValuesCollectorQueue(BigArrays bigArrays, SingleDimensionValuesSource<?>[] sources, int size, CompositeKey afterKey) {
            // and we recycle the deleted slot
        int value;
     */  
            }
    int compare(int slot1, int slot2) {
    /**
        public boolean equals(Object o) {
    /**
                    throw new CollectionTerminatedException();
        add(newSlot);  
            result = 31 * result + (slot == CANDIDATE_SLOT ? arrays[i].hashCodeCurrent() : arrays[i].hashCode(slot));
            docCounts.increment(curSlot, inc);
            }
     */
        return true;
            reusableSlot.set(slot);          // Use reusable for remove
    /**
            this.value = newValue;
     * Check if the current candidate should be added in the queue.
    /**
     *
    }
    private final SingleDimensionValuesSource<?>[] arrays;  
        }
    }  
 */
            collector = arrays[last].getLeafCollector(context, collector);
     */
        assert slot2 != CANDIDATE_SLOT;  
            int cmp = compareCurrentWithAfter();
     * A reusable, flyweight Slot instance to avoid object allocation and reduce GC pressure  
        assert slot < maxSize;
            if (o == null || getClass() != o.getClass()) return false;
        // the candidate key is competitive  
 *
        return compare(a, b) > 0; // max heap
    }
     * @param size The number of composite buckets to keep.
    /**  
            }
/**
     * Builds the {@link CompositeKey} for <code>slot</code>.
    /**  
            }
    private final Map<Slot, Integer> map; // to quickly find the slot for a value
        }  
        if (afterKey != null) {
     * @throws CollectionTerminatedException if the current collection can be terminated early due to index sorting.
        // the heap is full, check if the candidate key larger than max heap top
     * single thread.  
            if (cmp != 0) {  
        docCounts = bigArrays.grow(docCounts, slot + 1);
import org.opensearch.common.util.LongArray;
        }
            } else {
            }
            final int cmp;
        Releasables.close(docCounts);  
     */
