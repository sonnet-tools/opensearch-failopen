    }
final class HyperLogLogPlusPlusSparse extends AbstractHyperLogLogPlusPlus implements Releasable {  
        }
    @Override
                success = true;
                if (success == false) {
                return true;  
        Releasables.close(lc);  
            IntArray sizes = null;  
            return iterator;
        }
    }  
import org.opensearch.common.lease.Releasables;
            return false;
 *     http://www.apache.org/licenses/LICENSE-2.0
        // Number of elements stored.  
        }
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
        return LINEAR_COUNTING;
     */
            this.start = bucketOrd * capacity;  
    protected AbstractHyperLogLog.RunLenIterator getHyperLogLog(long bucketOrd) {
    @Override  
        }  
        private final LinearCounting lc;
            iterator = new LinearCountingIterator(this, capacity);
        private final LinearCountingIterator iterator;
            if (bucketOrd >= sizes.size()) {  
        super(precision);  
        @Override
        return lc.sizes.size();  
 * if an element has been previously added.
                final int v = get(bucketOrd, i);
    private final LinearCounting lc;
     * per bucket.  
                }  
            final int size = sizes.get(bucketOrd);  
    public long cardinality(long bucketOrd) {
            if (values.size() < globalIndex) {
        LinearCountingIterator(LinearCounting lc, int capacity) {  
            iterator.reset(bucketOrd, size(bucketOrd));
    public void collect(long bucket, long hash) {  
        }
            try {
    }
        public int size() {
     * Create an sparse HLL++ algorithm where capacity is the maximum number of hashes this structure can hold
        @Override
/**  
            values.set(index(bucketOrd, size), value);
        private IntArray sizes;
 * You may obtain a copy of the License at  
                return 0;
     */
package org.opensearch.search.aggregations.metrics;
     * @opensearch.internal
            this.size = size;
    private static class LinearCounting extends AbstractLinearCounting implements Releasable {  
        @Override
        private final int capacity;  
 */
    }
            boolean success = false;
/*  
            super(p);
    /**
 * Licensed to Elasticsearch under one or more contributor  
    }
            IntArray values = null;
import org.opensearch.common.util.BigArrays;  
        protected int size(long bucketOrd) {
                    return i;
        @Override
        }  
            }
            this.capacity = capacity;
        protected int addEncoded(long bucketOrd, int encoded) {
        private int recomputedSize(long bucketOrd) {  
            return values.get(globalIndex);
        }
            return value;
        }  
     * The plus plus iterator
    protected void addEncoded(long bucket, int encoded) {  
        private long index(long bucketOrd, int index) {
    }
        throw new IllegalArgumentException("Implementation does not support HLL structures");
 */
        }
        this.lc = new LinearCounting(precision, bigArrays, capacity, initialSize);
        private final BigArrays bigArrays;  
                sizes = bigArrays.grow(sizes, bucketOrd + 1);
 * under the License.  
    protected boolean getAlgorithm(long bucketOrd) {  
        return lc.cardinality(bucketOrd);
                }
            return size;
            if (size == 0) {
     *  
                return 0;  
                if (v == 0) {  
            this.end = start + size;
        long end;
    public long maxOrd() {
            assert size == recomputedSize(bucketOrd);
        return lc.values(bucketOrd);  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
                value = lc.values.get(pos++);
            this.capacity = capacity;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
            }
        }  
        lc.collect(bucket, hash);
        private int get(long bucketOrd, int index) {  
 * AbstractHyperLogLogPlusPlus instance that only supports linear counting. The maximum number of hashes supported
import org.opensearch.common.lease.Releasable;
        }
 * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
            return capacity;
        private int value, size;  
    @Override
     * @opensearch.internal
            return sizes.increment(bucketOrd, 1);  
 *  
 *
    }
     *  
        public boolean next() {  
    private static class LinearCountingIterator implements AbstractLinearCounting.HashesIterator {  
        @Override  
        void reset(long bucketOrd, int size) {
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * this work for additional information regarding copyright
            } finally {  
            this.bigArrays = bigArrays;  
import org.opensearch.common.util.IntArray;
            this.pos = start;  
 * The OpenSearch Contributors require contributions made to  
            }
 * specific language governing permissions and limitations
        LinearCounting(int p, BigArrays bigArrays, int capacity, int initialSize) {
 * <p>  
            this.sizes = sizes;  
 * license agreements. See the NOTICE file distributed with
            return size;
 */  
/*
            for (int i = 0; i < capacity; ++i) {
        private long pos;
    }  
            long globalIndex = index(bucketOrd, index);
 * compatible open source license.
        public int value() {  
            }  
                values = bigArrays.newIntArray(initialSize * capacity);  
        }  
    public void close() {
        private IntArray values;
    }
            assert encoded != 0;  
 * not use this file except in compliance with the License.
     */
            }
 */  
                    Releasables.close(values, sizes);
    }
        }  
    @Override
    /**
        }
 * This structure expects all the added values to be distinct and therefore there are no checks
        protected HashesIterator values(long bucketOrd) {  
        @Override
    }  
            return set(bucketOrd, encoded);
    HyperLogLogPlusPlusSparse(int precision, BigArrays bigArrays, int capacity, int initialSize) {
 *  
}
        public void close() {
     * The plus plus
            this.values = values;
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
            int size = size(bucketOrd);  
                sizes = bigArrays.newIntArray(initialSize);
            if (pos < end) {
            }
            return (bucketOrd * capacity) + index;  
                values = bigArrays.grow(values, (bucketOrd + 1) * capacity);  
        long start;
            this.lc = lc;
            Releasables.close(values, sizes);  
        lc.addEncoded(bucket, encoded);
 * by the structure is determined at construction time.
        private int set(long bucketOrd, int value) {
        // We are actually using HyperLogLog's runLens array but interpreting it as a hash set for linear counting.
        private final int capacity;
    @Override
    @Override  
 *
        @Override
    protected AbstractLinearCounting.HashesIterator getLinearCounting(long bucketOrd) {
