            final int size = sizes.get(bucketOrd);
        return LINEAR_COUNTING;
        throw new IllegalArgumentException("Implementation does not support HLL structures");
        @Override
    @Override
     * @opensearch.internal
        private long index(long bucketOrd, int index) {
                if (v == 0) {
                values = bigArrays.grow(values, (bucketOrd + 1) * capacity);
            this.start = bucketOrd * capacity;
    }
    @Override
        lc.addEncoded(bucket, encoded);
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
        return lc.cardinality(bucketOrd);
     * The plus plus iterator
        private int value, size;
                return 0;
    }
                sizes = bigArrays.grow(sizes, bucketOrd + 1);
        @Override
 * this file be licensed under the Apache-2.0 license or a
        }
                values = bigArrays.newIntArray(initialSize * capacity);
            iterator.reset(bucketOrd, size(bucketOrd));
 * ownership. Elasticsearch licenses this file to you under
            long globalIndex = index(bucketOrd, index);
        }
    protected void addEncoded(long bucket, int encoded) {
            try {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.util.BigArrays;
            assert size == recomputedSize(bucketOrd);
    /**
    }
            if (size == 0) {
            }
            return size;
 * This structure expects all the added values to be distinct and therefore there are no checks
        return lc.values(bucketOrd);
            return (bucketOrd * capacity) + index;
        protected HashesIterator values(long bucketOrd) {
    private final LinearCounting lc;
            return size;
            return false;
            }
        }
                success = true;
        private final LinearCountingIterator iterator;
     * @opensearch.internal
        }
            this.end = start + size;
            }
 * <p>
    @Override
                if (success == false) {
            this.capacity = capacity;
        protected int addEncoded(long bucketOrd, int encoded) {
            this.pos = start;
            return capacity;
            return values.get(globalIndex);
        }
                    return i;
                final int v = get(bucketOrd, i);
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Releasables.close(values, sizes);
        long start;
                return true;
            if (bucketOrd >= sizes.size()) {
     */
        // Number of elements stored.
        private int set(long bucketOrd, int value) {
            super(p);
        LinearCountingIterator(LinearCounting lc, int capacity) {
 *
     * The plus plus
            IntArray values = null;
package org.opensearch.search.aggregations.metrics;
    @Override
    }
 */
        void reset(long bucketOrd, int size) {
            boolean success = false;
        return lc.sizes.size();
 * compatible open source license.
 *
        super(precision);
/*
import org.opensearch.common.lease.Releasable;
                    Releasables.close(values, sizes);
    }
        private IntArray values;
    protected boolean getAlgorithm(long bucketOrd) {
 */
            return value;
        protected int size(long bucketOrd) {
            }
 * @opensearch.internal
    private static class LinearCounting extends AbstractLinearCounting implements Releasable {
        }
 * license agreements. See the NOTICE file distributed with
            this.bigArrays = bigArrays;
    @Override
            if (values.size() < globalIndex) {
                }
            int size = size(bucketOrd);
        private final LinearCounting lc;
     */
    public void close() {
        @Override
        }
     */
import org.opensearch.common.util.IntArray;
                sizes = bigArrays.newIntArray(initialSize);
        }
import org.opensearch.common.lease.Releasables;
    /**
    private static class LinearCountingIterator implements AbstractLinearCounting.HashesIterator {
    }
        }
    }
 * specific language governing permissions and limitations
 * AbstractHyperLogLogPlusPlus instance that only supports linear counting. The maximum number of hashes supported
 * The OpenSearch Contributors require contributions made to
        }
    public void collect(long bucket, long hash) {
 *
        private IntArray sizes;
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 */
        private long pos;
                return 0;
            this.sizes = sizes;
            this.size = size;
            assert encoded != 0;
 * Unless required by applicable law or agreed to in writing,
            this.lc = lc;
        public boolean next() {
/*
 * KIND, either express or implied.  See the License for the
            this.values = values;
     *
/**
    }
        long end;
/*
 * Licensed to Elasticsearch under one or more contributor
    @Override
    @Override
    }
                }
        this.lc = new LinearCounting(precision, bigArrays, capacity, initialSize);
        @Override
        lc.collect(bucket, hash);
 * by the structure is determined at construction time.
        private final int capacity;
            return sizes.increment(bucketOrd, 1);
        public void close() {
 * You may obtain a copy of the License at
        private int recomputedSize(long bucketOrd) {
            if (pos < end) {
            iterator = new LinearCountingIterator(this, capacity);
        LinearCounting(int p, BigArrays bigArrays, int capacity, int initialSize) {
    protected AbstractLinearCounting.HashesIterator getLinearCounting(long bucketOrd) {
        @Override
            values.set(index(bucketOrd, size), value);
 *
        public int size() {
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        }
        @Override
 * under the License.
            }
            return iterator;
        public int value() {
 * software distributed under the License is distributed on an
    public long cardinality(long bucketOrd) {
            } finally {
 */
        private final BigArrays bigArrays;
            this.capacity = capacity;
        private final int capacity;
        Releasables.close(lc);
            }
        @Override
        private int get(long bucketOrd, int index) {
     * Create an sparse HLL++ algorithm where capacity is the maximum number of hashes this structure can hold
                value = lc.values.get(pos++);
    HyperLogLogPlusPlusSparse(int precision, BigArrays bigArrays, int capacity, int initialSize) {
}
            IntArray sizes = null;
            return set(bucketOrd, encoded);
final class HyperLogLogPlusPlusSparse extends AbstractHyperLogLogPlusPlus implements Releasable {
        // We are actually using HyperLogLog's runLens array but interpreting it as a hash set for linear counting.
    }
    public long maxOrd() {
     * per bucket.
 * if an element has been previously added.
        }
    protected AbstractHyperLogLog.RunLenIterator getHyperLogLog(long bucketOrd) {
 * GitHub history for details.
     *
        }
            for (int i = 0; i < capacity; ++i) {
    }
