        protected HashesIterator values(long bucketOrd) {
            hll = new HyperLogLog(bigArrays, initialBucketCount, precision);
        }
                        value = k;
import org.apache.lucene.util.packed.PackedInts;
 * It supports storing several HyperLogLogPlusPlus structures which are identified by a bucket number.
    public void merge(long thisBucket, AbstractHyperLogLogPlusPlus other, long otherBucket) {
        }
            throw new IllegalArgumentException(
                } else if (v == encoded) {
    private final LinearCounting lc;
        private final HyperLogLog hll;
 */
        }
        @Override
    }
            }
        if (algorithm.get(bucketOrd) == LINEAR_COUNTING) {
        }
        LinearCounting(BigArrays bigArrays, long initialBucketCount, int p, HyperLogLog hll) {
            pos = 0;
        public int value() {
            assert size == recomputedSize(bucketOrd);
        private int pos, size;
                    if (k != 0) {
                }
    }
        private long index(long bucketOrd, int index) {
/*
            this.m = m;
}
        private final HyperLogLogIterator iterator;
        @Override
    private static class HyperLogLog extends AbstractHyperLogLog implements Releasable {
 * software distributed under the License is distributed on an
 */
            } else {
    /**
    @Override
            upgradeToHll(thisBucket);
            sizes = bigArrays.grow(sizes, bucketOrd + 1);
    protected boolean getAlgorithm(long bucketOrd) {
     */
     *
            return (bucketOrd << p) + (index << 2);
            iterator = new LinearCountingIterator(this, capacity);
     * @opensearch.internal
                return 0;
     * The hyper log log
        final long hashTableEntries = (long) Math.ceil(count / MAX_LOAD_FACTOR);
        }
            this.runLens = bigArrays.newByteArray(initialBucketCount << precision);
    }
    @Override
                final int v = get(bucketOrd, i);
            this.bucketOrd = bucketOrd;
            for (long j = 0; j < values.size(); ++j) {
                    // k is already in the set
        @Override
     *
            }
                    upgradeToHll(thisBucket);
            return ByteUtils.readIntLE(readSpare.bytes, readSpare.offset);
        private ByteArray runLens;
 * Licensed to Elasticsearch under one or more contributor
            mask = capacity - 1;
            return false;
        }
        hll.ensureCapacity(bucket + 1);
        private final BigArrays bigArrays;
 * http://static.googleusercontent.com/media/research.google.com/fr//pubs/archive/40671.pdf and its appendix
        }
                }
            hll.reset(bucketOrd);
import org.opensearch.common.lease.Releasables;
            return runLens.size() >>> precision();
        }
    public void close() {
        }
        return 1L << precision;
     */
    protected AbstractLinearCounting.HashesIterator getLinearCounting(long bucketOrd) {
    private static class HyperLogLogIterator implements AbstractHyperLogLog.RunLenIterator {
        @Override
    }
        }
    public static int precisionFromThreshold(long count) {
            if (bucketOrd >= hll.maxOrd()) {
        protected int addEncoded(long bucketOrd, int encoded) {
/**
        this.lc = lc;
                for (; pos < capacity; ++pos) {
    private final HyperLogLog hll;
 *    http://www.apache.org/licenses/LICENSE-2.0
    void upgradeToHll(long bucketOrd) {
        @Override
    @Override
            this.p = p;
        Releasables.close(algorithm, hll, lc);
            this.capacity = capacity;
            if (algorithm.get(thisBucket) == LINEAR_COUNTING) {
        HyperLogLog(BigArrays bigArrays, long initialBucketCount, int precision) {
     * The plus plus
            return value;
            algorithm.set(bucketOrd);
    @Override
                final int newSize = lc.addEncoded(thisBucket, encoded);
            lc = new LinearCounting(bigArrays, initialBucketCount, precision, hll);
            super(p);
        protected final int threshold;
 * the Apache License, Version 2.0 (the "License"); you may
            hll.runLens.get(index(bucketOrd, index), 4, readSpare);
        HyperLogLogIterator(HyperLogLog hll, int p, int m) {
 *
     *
        if (other.getAlgorithm(otherBucket) == LINEAR_COUNTING) {
            this.bigArrays = bigArrays;
            }
 * Trying to understand what this class does without having read the paper is considered adventurous.
            writeSpare.putInt(0, value);
        }
 * SPDX-License-Identifier: Apache-2.0
            hll.collect(bucket, hash);
                hll.collectEncoded(thisBucket, encoded);
        // We need to copy values into an arrays as we will override
        public void close() {
            final int size = sizes.get(bucketOrd);
        }
    public long cardinality(long bucketOrd) {
import org.opensearch.common.util.BigArrays;
        int pos;
        private IntArray sizes;
        void reset(long bucketOrd, int size) {
    protected void addRunLen(long bucketOrd, int register, int runLen) {
     * @opensearch.internal
        }
            assert encoded != 0;
public final class HyperLogLogPlusPlus extends AbstractHyperLogLogPlusPlus {
     * Iterator for hyper log log
    @Override
 * <p>
        private final int m, p;
            runLens.set(bucketIndex, (byte) Math.max(encoded, runLens.get(bucketIndex)));
            final int newSize = lc.collect(bucket, hash);
import org.opensearch.common.util.BitArray;
    }
    }
    }
        protected int size(long bucketOrd) {
        }
        precision = Math.max(precision, AbstractHyperLogLog.MIN_PRECISION);
        }
            iterator.reset(bucketOrd);
                Releasables.close(hll, lc, algorithm);
        }
        }
    public void collect(long bucket, long hash) {
            if (success == false) {
            super(precision);
                    return sizes.increment(bucketOrd, 1);
            while (hashes.next()) {
            return iterator;
            return size;
    }
    public static final int DEFAULT_PRECISION = 14;
            int i = 0;
        if (algorithm.get(bucket) == LINEAR_COUNTING) {
                    final int k = lc.get(bucketOrd, pos);
 * <p>
        // We are actually using HyperLogLog's runLens array but interpreting it as a hash set for linear counting.
        @Override
        LinearCounting lc = null;
 */
        protected void reset(long bucketOrd) {
                pos++;
 *
        } finally {
    /**
    /**
        }
            if (newSize > lc.threshold) {
 * Hyperloglog++ counter, implemented based on pseudo code from
            return size;
     * Return the expected per-bucket memory usage for the given precision.
        }
            Releasables.close(sizes);
     */
        @Override
        private final LinearCountingIterator iterator;
 */
        protected RunLenIterator getRunLens(long bucketOrd) {
        } else {
            }
            this.lc = lc;
                if (v != 0) {
        public byte value() {
        public int size() {
 * @opensearch.internal
 *
        private final int capacity;
        private long bucketOrd;
     */
        this.hll = hll;
            this.size = size;
     */
        this.algorithm = algorithm;
        public long maxOrd() {
            }
            Releasables.close(values);
        // the values on the buffer
        if (algorithm.get(thisBucket) != HYPERLOGLOG) {
            if (bucketOrd >= sizes.size()) {
        private int recomputedSize(long bucketOrd) {
    }
        void reset(long bucket) {
    @Override
        if (precision() != other.precision()) {
        final IntArray values = lc.bigArrays.newIntArray(hashes.size());
 * The OpenSearch Contributors require contributions made to
            if (pos < m) {
                        return true;
        try {
            for (int i = (encoded & mask);; i = (i + 1) & mask) {
                final int v = get(bucketOrd, i);
            writeSpare = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        private final BigArrays bigArrays;
    protected AbstractHyperLogLog.RunLenIterator getHyperLogLog(long bucketOrd) {
 * Modifications Copyright OpenSearch Contributors. See
                    ++size;
                return 0;
    private static final float MAX_LOAD_FACTOR = 0.75f;
        int precision = PackedInts.bitsRequired(hashTableEntries * Integer.BYTES);
        @Override
            }
            int size = 0;
        }
        }
/*
        } else {
        }
    /**
            runLens.next();
import org.opensearch.common.lease.Releasable;
import org.opensearch.core.common.util.ByteArray;
        }
        }
        }
        @Override
 * <p>
 * The HyperLogLogPlusPlus contains two algorithms, one for linear counting and the HyperLogLog algorithm. Initially hashes added to the
            }
import java.nio.ByteBuffer;
        hll.ensureCapacity(thisBucket + 1);
        }
                    // means unused, take it!
        hll.addRunLen(0, register, runLen);
    }
        public boolean next() {
            hll.runLens.set(index(bucketOrd, index), writeSpare.array(), 0, 4);
    }
        }
            }
    }
/*
                if (newSize > lc.threshold) {
        } finally {
                value = hll.runLens.get(start + pos);
 * this file be licensed under the Apache-2.0 license or a
        long start;
 *
import org.opensearch.common.util.ByteUtils;
            return size;
        for (int i = 0; i < hll.m; ++i) {
        }
    }
 * You may obtain a copy of the License at
    /**
                    }
        return precision;
        while (values.next()) {
    @Override
        public void close() {
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.search.aggregations.metrics;
        // array for holding the runlens.
        }
 * to the HyperLogLog algorithm and then this is used.
 * This implementation is different from the original implementation in that it uses a hash table instead of a sorted list for linear
    private static class LinearCountingIterator implements AbstractLinearCounting.HashesIterator {
        // Number of elements stored.
            for (int i = 0; i <= mask; ++i) {
                final int encoded = values.get(j);
                hll.collectEncoded(bucketOrd, encoded);
 * specific language governing permissions and limitations
            hll.addRunLen(thisBucket, i, runLens.value());
            return hll.cardinality(bucketOrd);
     * The plus plus iterator
        HyperLogLog hll = null;
    /**
        precision = Math.min(precision, AbstractHyperLogLog.MAX_PRECISION);
            runLens.fill(bucketOrd << p, (bucketOrd << p) + m, (byte) 0);
        return hll.maxOrd();
        private final LinearCounting lc;
            if (pos < capacity) {
        @Override
     * Compute the required precision so that <code>count</code> distinct entries would be counted with linear counting.
 * KIND, either express or implied.  See the License for the
            threshold = (int) (capacity * MAX_LOAD_FACTOR);
            this.pos = size == 0 ? capacity : 0;
            this.hll = hll;
                upgradeToHll(bucket);
        if (getAlgorithm(bucketOrd) == LINEAR_COUNTING) {
            return lc.cardinality(bucketOrd);
    private void merge(long thisBucket, AbstractLinearCounting.HashesIterator values) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    return -1;
        BitArray algorithm = null;
 * counting. Although this requires more space and makes hyperloglog (which is less accurate) used sooner, this is also considerably faster.
 * GitHub history for details.
                values.set(i++, hashes.value());
            }
 * https://docs.google.com/document/d/1gyjfMHy43U9OWBXxfaeG-3MjGzejW1dlpyMwEYAAWEI/view?fullscreen
            merge(thisBucket, other.getHyperLogLog(otherBucket));
            this.iterator = new HyperLogLogIterator(this, precision, m);
        }
                        ++pos;
            readSpare = new BytesRef();
                if (v == 0) {
            }
        }
            merge(thisBucket, other.getLinearCounting(otherBucket));
        public boolean next() {
 * data structure are processed using the linear counting until a threshold defined by the precision is reached where the data is replayed
import org.apache.lucene.util.BytesRef;
        } else {
 * <p>
        private int value;
        protected void addRunLen(long bucketOrd, int register, int encoded) {
            );
            this.hll = hll;
        private final BytesRef readSpare;
    private static class LinearCounting extends AbstractLinearCounting implements Releasable {
    public static long memoryUsage(int precision) {
 * this work for additional information regarding copyright
        LinearCountingIterator(LinearCounting lc, int capacity) {
            runLens = bigArrays.grow(runLens, numBuckets << p);
            return iterator;
                return true;
        @Override
    }
                }
 * compatible open source license.
import org.opensearch.common.util.IntArray;
 * ownership. Elasticsearch licenses this file to you under
import java.nio.ByteOrder;
        }
        try {
        final AbstractLinearCounting.HashesIterator hashes = lc.values(bucketOrd);
    private final BitArray algorithm;
                }
            final int capacity = (1 << p) / 4; // because ints take 4 bytes
            Releasables.close(runLens);
        return lc.values(bucketOrd);
            final long bucketIndex = (bucketOrd << p) + register;
            success = true;
    }
 * not use this file except in compliance with the License.
     *
 * license agreements. See the NOTICE file distributed with
        protected void ensureCapacity(long numBuckets) {
        boolean success = false;
            return false;
        private byte value;
            }
        super(precision);
    public long maxOrd() {
        @Override
            start = bucket << p;
     * @opensearch.internal
            sizes = bigArrays.newIntArray(initialBucketCount);
     */
     * @opensearch.internal
        private final int mask;
        hll.ensureCapacity(bucketOrd + 1);
            iterator.reset(bucketOrd, size(bucketOrd));
    }
            algorithm = new BitArray(1, bigArrays);
        private void set(long bucketOrd, int index, int value) {
        private final ByteBuffer writeSpare;
    }
        return algorithm.get(bucketOrd);
            final int encoded = values.value();
            return value;
    private void merge(long thisBucket, AbstractHyperLogLog.RunLenIterator runLens) {
        return hll.getRunLens(bucketOrd);
                "Cannot merge HLL++ sketches with different precision: " + precision() + " vs " + other.precision()
        private int get(long bucketOrd, int index) {
            assert i == hashes.size();
                    set(bucketOrd, i, encoded);
        }
 * under the License.
    }
        private final HyperLogLog hll;
        }
    public HyperLogLogPlusPlus(int precision, BigArrays bigArrays, long initialBucketCount) {
        }
    }
            upgradeToHll(bucketOrd);
            this.bigArrays = bigArrays;
