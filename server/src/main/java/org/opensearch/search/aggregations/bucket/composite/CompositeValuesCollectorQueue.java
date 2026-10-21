     * A reusable, flyweight Slot instance to avoid object allocation and reduce GC pressure
        if (size() >= maxSize) {
    /**
        return map.get(reusableSlot);     // Use the single reusable slot instance for the lookup
    boolean addIfCompetitive(int indexSortSourcePrefix, long inc) {
     * Check if the current candidate should be added in the queue.
                // the key was collected on a previous page, skip it.
        docCounts = bigArrays.grow(docCounts, slot + 1);
                return false;
        }
        }
     * @throws CollectionTerminatedException if the current collection can be terminated early due to index sorting.
            return CompositeValuesCollectorQueue.this.hashCode(value);
    private static final int CANDIDATE_SLOT = Integer.MAX_VALUE;
        return 0;
        }
        return result;
        reusableSlot.set(CANDIDATE_SLOT); // Update the state of the reusable slot
    }
 * Licensed to Elasticsearch under one or more contributor
     *
    }
        return compare(a, b) > 0; // max heap
     * Whether the queue is full or not.
            int cmp = compareCurrentWithAfter();
        final int newSlot;
    // the slot for the current candidate
     */
     */
            // the queue is full, we replace the last key with this candidate
            afterKeyIsSet = true;
    CompositeValuesCollectorQueue(BigArrays bigArrays, SingleDimensionValuesSource<?>[] sources, int size, CompositeKey afterKey) {
     *                              and a negative value indicates that the index sort match the source field but the order is reversed.
            newSlot = slot;
import java.util.Map;
                    throw new CollectionTerminatedException();
                return cmp > 0 ? i + 1 : -(i + 1);
     * during map lookups in the high-frequency collect() path. This object is NOT
import org.apache.lucene.search.CollectionTerminatedException;
     * @return <code>true</code> if the candidate is competitive (added or already in the queue).
            if (slot1 == CANDIDATE_SLOT) {
            }
        map.put(new Slot(newSlot), newSlot);
    }
    /**
     * Returns true if the values in <code>slot1</code> are equals to the value in <code>slot2</code>.
    /**
     * Returns a hash code value for the values in <code>slot</code>.
            int slot = pop();
        if (afterKey != null) {
 * SPDX-License-Identifier: Apache-2.0
     */
            values[i] = arrays[i].toComparable(slot);
        return true;
            if (cmp > 0) {
     * The provided collector <code>in</code> is called on each composite bucket.
    }
        for (int i = 0; i < arrays.length; i++) {
        if (forceLeadSourceValue != null) {
        return size() >= maxSize;
     * @param sources The list of {@link CompositeValuesSourceConfig} to build the composite buckets.
 */
     */
/*
            arrays[i].copyCurrent(slot);
        throws IOException {
        return afterKeyIsSet ? arrays[0].getAfter() : null;
                }
        add(newSlot);
 * GitHub history for details.
            }
}
                cmp = arrays[i].compare(slot1, slot2);
            collector = arrays[last].getLeafCollector(context, collector);
        if (curSlot != null) {
     */
                // the candidate key is not competitive, skip it.
            docCounts.increment(curSlot, inc);
     */
    boolean equals(int slot1, int slot2) {
    /**
            if (slot1 == CANDIDATE_SLOT) {
            return CompositeValuesCollectorQueue.this.equals(value, slot.value);
    /**
     * the slot if the candidate is already in the queue or null if the candidate is not present.
        return 0;
        for (int i = 0; i < arrays.length; i++) {
        } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * specific language governing permissions and limitations
import org.opensearch.common.util.BigArrays;
    LeafBucketCollector getLeafCollector(LeafReaderContext context, LeafBucketCollector in) throws IOException {
                if (indexSortSourcePrefix < 0 && cmp == indexSortSourcePrefix) {
     *                              a value greater than 0 indicates the prefix len of the sources that match the index sort
    Comparable getUpperValueLeadSource() throws IOException {
     * Builds the {@link CompositeKey} for <code>slot</code>.
        assert slot2 != CANDIDATE_SLOT;
            if (cmp != 0) {
            collector = arrays[last--].getLeafCollector(context, collector);
     * @param indexSortSourcePrefix 0 if the index sort is null or doesn't match any of the sources field,
            if (cmp != 0) {
     * Compares the after values with the values in <code>slot</code>.
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Compares the values in <code>slot1</code> with the values in <code>slot2</code>.
     * Constructs a composite queue with the specified size and sources.
     * The provided collector <code>in</code> is called on each composite bucket.
            result = 31 * result + (slot == CANDIDATE_SLOT ? arrays[i].hashCodeCurrent() : arrays[i].hashCode(slot));
            for (int i = 0; i < afterKey.size(); i++) {
 * under the License.
    private final Slot reusableSlot = new Slot(0);
    }
import java.io.IOException;
    /**
     * Copies the current value in <code>slot</code>.
import java.util.HashMap;
     */
            final int cmp;
    int hashCode(int slot) {
     * Returns the lowest value (exclusive) of the leading source.
        return getLeafCollector(null, context, in);
    /**
 * the Apache License, Version 2.0 (the "License"); you may
                    // so we can early terminate.
     * Add or update the current composite key in the queue if the values are competitive.
            }
        for (int i = 0; i < values.length; i++) {
            collector = arrays[last].getLeafCollector(forceLeadSourceValue, context, collector);
 * Can think of this as a max heap that holds the top small buckets slots in order.
    boolean addIfCompetitive(long inc) {
    }
        }
    CompositeKey toCompositeKey(int slot) throws IOException {
     */
/**
 *
                    // the leading index sort is and the leading source order are both reversed,
     */
        Comparable[] values = new Comparable[arrays.length];
                sources[i].setAfter(afterKey.get(i));
    }
    /**
                    throw new CollectionTerminatedException();
            int cmp = arrays[i].compareCurrentWithAfter();
    @Override
        }
    }
    }
    Comparable getLowerValueLeadSource() {
     * Creates the collector that will visit the composite buckets of the matching documents.
        // the candidate key is competitive
    private LongArray docCounts;
    }
        for (int i = 0; i < arrays.length; i++) {
 * A specialized {@link PriorityQueue} implementation for composite buckets.
     */
            if (this == o) return true;
        while (last > 0) {
 */
    /**
    protected boolean lessThan(Integer a, Integer b) {
 * compatible open source license.
/*
     */
        for (int i = 0; i < arrays.length; i++) {
     */
     * for each document.
        // move the candidate key to its new slot by copy its values to the new slot
final class CompositeValuesCollectorQueue extends PriorityQueue<Integer> implements Releasable {
        public boolean equals(Object o) {
        // the heap is full, check if the candidate key larger than max heap top
 * Unless required by applicable law or agreed to in writing,
    int compare(int slot1, int slot2) {
    }
        // checks if the candidate key is competitive
        }
    /**
    }
            } else {
    private void copyCurrent(int slot, long value) {
        super(size);
                    // so we can early terminate when we reach a document that is smaller
    }
    /**
    /**
        Slot(int initial) {
    }
        }
     * thread-safe, but is safe here because each collector instance is confined to a
            }
            assert afterKey.size() == sources.length;
                return false;
        LeafBucketCollector collector = in;
        }
import org.opensearch.common.lease.Releasables;
     * Creates the collector that will visit the composite buckets of the matching documents.
    }
        if (afterKeyIsSet) {
    private final Map<Slot, Integer> map; // to quickly find the slot for a value
        assert slot < maxSize;
        }
            } else {
        for (int i = 0; i < arrays.length; i++) {
     *
        }
 *
 * not use this file except in compliance with the License.
    }
 */
     * Returns the document count in <code>slot</code>.
                    // than the after key (collected on a previous page).
 *
    private int compareCurrentWithAfter() {
    }
            }
     *
     */
import org.opensearch.common.lease.Releasable;
        }
        }
        this.docCounts = bigArrays.newLongArray(1, false);
        @Override
import org.apache.lucene.util.PriorityQueue;
            Slot slot = (Slot) o;
    /**
        this.arrays = sources;
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
            return true;
            if (cmp != 0) {
            // and we recycle the deleted slot
    /**
 * The OpenSearch Contributors require contributions made to
        return collector;
    long getDocCount(int slot) {
            reusableSlot.set(slot);          // Use reusable for remove
        copyCurrent(newSlot, inc);
     * @return <code>true</code> if the candidate is competitive (added or already in the queue).
        int last = arrays.length - 1;
            this.value = newValue;
    boolean isFull() {
        public void set(int newValue) {
        }
        this.maxSize = size;
        } else {
     */
 * license agreements. See the NOTICE file distributed with
/*
        public int hashCode() {
            int cmp = compare(CANDIDATE_SLOT, top());
            if (cmp <= 0) {
        return true;
        // This is to be only for reusable slot
 */
        }
            map.remove(reusableSlot);
                cmp = arrays[i].compare(slot1, slot2);
                }
import org.opensearch.common.util.LongArray;
    private final int maxSize;
        return size() >= maxSize ? arrays[0].toComparable(top()) : null;
            }
                cmp = arrays[i].compareCurrent(slot2);
            this.value = initial;
    private final SingleDimensionValuesSource<?>[] arrays;
        int result = 1;
     */
    LeafBucketCollector getLeafCollector(Comparable forceLeadSourceValue, LeafReaderContext context, LeafBucketCollector in)
            // this key is already in the top N, skip it
    }
                return cmp > 0 ? i + 1 : -(i + 1);
package org.opensearch.search.aggregations.bucket.composite;
        this.bigArrays = bigArrays;
 * this work for additional information regarding copyright
        int value;
     */
            }
        }
     * @param afterKey composite key
                if (cmp <= indexSortSourcePrefix) {
    Integer getCurrentSlot() {
        return addIfCompetitive(0, inc);
    private boolean afterKeyIsSet = false;
    /**
import org.apache.lucene.index.LeafReaderContext;
            if (o == null || getClass() != o.getClass()) return false;
 * You may obtain a copy of the License at
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under
        if (size() >= maxSize) {
        this.map = new HashMap<>(size);
     * If <code>forceLeadSourceValue</code> is not null, the leading source will use this value
 * Each slot holds the values of the composite bucket key it represents.
        docCounts.set(slot, value);
    /**
 * software distributed under the License is distributed on an
     * Returns the upper value (inclusive) of the leading source.
            final int cmp;
                    // index sort guarantees the following documents will have a key larger than the current candidate,
        }
        @Override
     * Try to get the slot of the current/candidate values in the queue and returns
        return docCounts.get(slot);
        return new CompositeKey(values);
    @Override
        Releasables.close(docCounts);
            }
    /**
    public void close() {
 *
        Integer curSlot = getCurrentSlot();
     * single thread.
import org.opensearch.search.aggregations.LeafBucketCollector;
     */
                return false;
    private final BigArrays bigArrays;
    }
            newSlot = size();
 * Modifications Copyright OpenSearch Contributors. See
    private class Slot {
                cmp = arrays[i].compareCurrent(slot2);
     * @param size The number of composite buckets to keep.
        assert slot2 != CANDIDATE_SLOT;
        }
