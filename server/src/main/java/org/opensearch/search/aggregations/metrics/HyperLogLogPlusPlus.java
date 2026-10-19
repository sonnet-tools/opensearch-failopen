        }  
            }
        private long index(long bucketOrd, int index) {  
    public static int precisionFromThreshold(long count) {  
        for (int i = 0; i < hll.m; ++i) {
                Releasables.close(hll, lc, algorithm);
    private void merge(long thisBucket, AbstractLinearCounting.HashesIterator values) {
                if (v != 0) {  
            if (pos < m) {  
 * Trying to understand what this class does without having read the paper is considered adventurous.
    public static long memoryUsage(int precision) {
        private final int mask;
                    // k is already in the set
            readSpare = new BytesRef();
            runLens = bigArrays.grow(runLens, numBuckets << p);
        } else {
        @Override
import org.opensearch.common.util.BitArray;  
        @Override
 * software distributed under the License is distributed on an
     * The plus plus  
            hll.runLens.set(index(bucketOrd, index), writeSpare.array(), 0, 4);
    }
     */
     *  
        @Override
    /**
    protected AbstractHyperLogLog.RunLenIterator getHyperLogLog(long bucketOrd) {
            success = true;
        }
import org.opensearch.core.common.util.ByteArray;  
        }
                values.set(i++, hashes.value());  
    }
 *
        hll.addRunLen(0, register, runLen);  
        } finally {  
        private void set(long bucketOrd, int index, int value) {  
        this.algorithm = algorithm;  
        }
        } else {  
        private final LinearCountingIterator iterator;
                final int v = get(bucketOrd, i);
        int precision = PackedInts.bitsRequired(hashTableEntries * Integer.BYTES);
            algorithm.set(bucketOrd);
        void reset(long bucketOrd, int size) {
        }
                    return -1;  
        private byte value;  
            iterator = new LinearCountingIterator(this, capacity);  
        protected RunLenIterator getRunLens(long bucketOrd) {  
    public void collect(long bucket, long hash) {  
    }
        }
     * Return the expected per-bucket memory usage for the given precision.  
            writeSpare.putInt(0, value);
    private static class LinearCounting extends AbstractLinearCounting implements Releasable {
            pos = 0;  
            }
     * @opensearch.internal
        } finally {
        }  
                    set(bucketOrd, i, encoded);
        hll.ensureCapacity(thisBucket + 1);
            while (hashes.next()) {
            } else {  
            merge(thisBucket, other.getLinearCounting(otherBucket));
                final int newSize = lc.addEncoded(thisBucket, encoded);
        private final int capacity;  
        }
    private void merge(long thisBucket, AbstractHyperLogLog.RunLenIterator runLens) {  
            sizes = bigArrays.newIntArray(initialBucketCount);  
        if (algorithm.get(bucket) == LINEAR_COUNTING) {
        precision = Math.min(precision, AbstractHyperLogLog.MAX_PRECISION);
        int pos;
    protected boolean getAlgorithm(long bucketOrd) {  
                    return sizes.increment(bucketOrd, 1);  
     * The hyper log log
    @Override
    /**
 * KIND, either express or implied.  See the License for the
            return false;
    }  
        private final int m, p;  
    private static class HyperLogLog extends AbstractHyperLogLog implements Releasable {  
 */  
        this.hll = hll;
        }
        @Override
    }
            this.pos = size == 0 ? capacity : 0;
            if (pos < capacity) {
        }  
        private final BytesRef readSpare;
 * this work for additional information regarding copyright
        if (getAlgorithm(bucketOrd) == LINEAR_COUNTING) {
        } else {
        @Override
            merge(thisBucket, other.getHyperLogLog(otherBucket));  
     * @opensearch.internal
        precision = Math.max(precision, AbstractHyperLogLog.MIN_PRECISION);  
            return lc.cardinality(bucketOrd);
import java.nio.ByteOrder;  
 * Modifications Copyright OpenSearch Contributors. See
                }
            return value;
                    ++size;
                final int encoded = values.get(j);
 *
        // array for holding the runlens.  
 */  
    }  
            start = bucket << p;
}
    public void merge(long thisBucket, AbstractHyperLogLogPlusPlus other, long otherBucket) {
            throw new IllegalArgumentException(
     * Iterator for hyper log log
/*  
            return ByteUtils.readIntLE(readSpare.bytes, readSpare.offset);  
            final long bucketIndex = (bucketOrd << p) + register;
            );  
    @Override  
 * to the HyperLogLog algorithm and then this is used.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return iterator;
        private final ByteBuffer writeSpare;  
 * <p>
            return runLens.size() >>> precision();
                }
        }
            return size;  
    @Override
        public int value() {
        }  
            }  
import java.nio.ByteBuffer;
    /**
        while (values.next()) {
            }  
        long start;
     * Compute the required precision so that <code>count</code> distinct entries would be counted with linear counting.
        return precision;
    public HyperLogLogPlusPlus(int precision, BigArrays bigArrays, long initialBucketCount) {  
                if (newSize > lc.threshold) {  
        return algorithm.get(bucketOrd);
            final int newSize = lc.collect(bucket, hash);  
 * @opensearch.internal  
                hll.collectEncoded(bucketOrd, encoded);  
            this.bigArrays = bigArrays;  
            threshold = (int) (capacity * MAX_LOAD_FACTOR);
 * not use this file except in compliance with the License.
        private ByteArray runLens;
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @opensearch.internal
    @Override
        if (algorithm.get(bucketOrd) == LINEAR_COUNTING) {  
    /**
            if (bucketOrd >= sizes.size()) {
                        value = k;
        }
    protected void addRunLen(long bucketOrd, int register, int runLen) {
        // the values on the buffer
            algorithm = new BitArray(1, bigArrays);  
        @Override  
        }  
                "Cannot merge HLL++ sketches with different precision: " + precision() + " vs " + other.precision()
    public long maxOrd() {
                return 0;
        public byte value() {  
            hll.reset(bucketOrd);  
import org.apache.lucene.util.BytesRef;
        public boolean next() {
 * compatible open source license.
            for (int i = 0; i <= mask; ++i) {
            }
            Releasables.close(sizes);  
    }
        }  
        HyperLogLog(BigArrays bigArrays, long initialBucketCount, int precision) {  
        }
public final class HyperLogLogPlusPlus extends AbstractHyperLogLogPlusPlus {
    void upgradeToHll(long bucketOrd) {  
                    upgradeToHll(thisBucket);
        return hll.getRunLens(bucketOrd);
            if (success == false) {  
        final AbstractLinearCounting.HashesIterator hashes = lc.values(bucketOrd);
    }  
            iterator.reset(bucketOrd);
            hll.addRunLen(thisBucket, i, runLens.value());  
                    }  
                        return true;
     * The plus plus iterator
import org.opensearch.common.util.BigArrays;
     *  
                hll.collectEncoded(thisBucket, encoded);
 * https://docs.google.com/document/d/1gyjfMHy43U9OWBXxfaeG-3MjGzejW1dlpyMwEYAAWEI/view?fullscreen
 * data structure are processed using the linear counting until a threshold defined by the precision is reached where the data is replayed
 * license agreements. See the NOTICE file distributed with
                for (; pos < capacity; ++pos) {  
        boolean success = false;
/**
    private final HyperLogLog hll;  
/*  
            this.hll = hll;  
    public static final int DEFAULT_PRECISION = 14;  
        BitArray algorithm = null;
    }
     */
            hll = new HyperLogLog(bigArrays, initialBucketCount, precision);
        protected int addEncoded(long bucketOrd, int encoded) {
        private final HyperLogLog hll;
            runLens.fill(bucketOrd << p, (bucketOrd << p) + m, (byte) 0);  
                    if (k != 0) {
            this.size = size;  
import org.opensearch.common.util.ByteUtils;
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        private IntArray sizes;  
 *
        this.lc = lc;
        return 1L << precision;  
        }  
 * GitHub history for details.
        protected void addRunLen(long bucketOrd, int register, int encoded) {  
 * http://static.googleusercontent.com/media/research.google.com/fr//pubs/archive/40671.pdf and its appendix
            if (bucketOrd >= hll.maxOrd()) {  
        @Override  
        protected final int threshold;  
            runLens.next();
                }
            mask = capacity - 1;
    private final BitArray algorithm;
     *  
        }  
 */
        LinearCounting lc = null;  
     */  
        return lc.values(bucketOrd);  
        private int value;  
            upgradeToHll(thisBucket);
                return true;  
        private int recomputedSize(long bucketOrd) {
     * @opensearch.internal
    /**  
    @Override  
        try {  
/*
        }
            super(p);  
import org.opensearch.common.lease.Releasables;
            this.iterator = new HyperLogLogIterator(this, precision, m);
        public boolean next() {
            this.hll = hll;
            Releasables.close(runLens);  
        }  
                if (v == 0) {  
            runLens.set(bucketIndex, (byte) Math.max(encoded, runLens.get(bucketIndex)));
            return (bucketOrd << p) + (index << 2);
        hll.ensureCapacity(bucketOrd + 1);
            this.bucketOrd = bucketOrd;
            return size;  
 * This implementation is different from the original implementation in that it uses a hash table instead of a sorted list for linear
        public int size() {
                return 0;
        private final LinearCounting lc;
 * SPDX-License-Identifier: Apache-2.0
        }
    protected AbstractLinearCounting.HashesIterator getLinearCounting(long bucketOrd) {
 * Licensed to Elasticsearch under one or more contributor  
        public void close() {
                }
            final int capacity = (1 << p) / 4; // because ints take 4 bytes  
    private final LinearCounting lc;
 * <p>  
        }
            if (algorithm.get(thisBucket) == LINEAR_COUNTING) {
                final int v = get(bucketOrd, i);
        HyperLogLogIterator(HyperLogLog hll, int p, int m) {
 * You may obtain a copy of the License at  
        private final HyperLogLog hll;
            hll.collect(bucket, hash);
        }
        private int get(long bucketOrd, int index) {
        }  
        protected HashesIterator values(long bucketOrd) {
        @Override  
            this.m = m;
        private final HyperLogLogIterator iterator;
            if (newSize > lc.threshold) {
            super(precision);
            assert size == recomputedSize(bucketOrd);
        super(precision);
        @Override
     *
            }
            iterator.reset(bucketOrd, size(bucketOrd));
    /**
 * <p>  
        }  
        if (other.getAlgorithm(otherBucket) == LINEAR_COUNTING) {  
 */
        private final BigArrays bigArrays;
    private static class LinearCountingIterator implements AbstractLinearCounting.HashesIterator {  
                } else if (v == encoded) {
 * ownership. Elasticsearch licenses this file to you under  
    }
    private static class HyperLogLogIterator implements AbstractHyperLogLog.RunLenIterator {  
                    final int k = lc.get(bucketOrd, pos);
        void reset(long bucket) {
 * specific language governing permissions and limitations
    }  
            Releasables.close(values);
            }
        }
        }  
            final int encoded = values.value();  
            for (int i = (encoded & mask);; i = (i + 1) & mask) {
            hll.runLens.get(index(bucketOrd, index), 4, readSpare);
            return value;
    }
            sizes = bigArrays.grow(sizes, bucketOrd + 1);
    @Override  
 * It supports storing several HyperLogLogPlusPlus structures which are identified by a bucket number.
        @Override
            assert encoded != 0;  
 * The OpenSearch Contributors require contributions made to  
        HyperLogLog hll = null;
 * Hyperloglog++ counter, implemented based on pseudo code from  
 * Unless required by applicable law or agreed to in writing,
            return hll.cardinality(bucketOrd);
            return iterator;  
        if (precision() != other.precision()) {  
        LinearCountingIterator(LinearCounting lc, int capacity) {
     */
        protected int size(long bucketOrd) {  
        private long bucketOrd;
        @Override  
    public long cardinality(long bucketOrd) {  
 * <p>  
package org.opensearch.search.aggregations.metrics;
 * The HyperLogLogPlusPlus contains two algorithms, one for linear counting and the HyperLogLog algorithm. Initially hashes added to the  
            }
                        ++pos;  
        }
            this.runLens = bigArrays.newByteArray(initialBucketCount << precision);
            int i = 0;
    public void close() {
        @Override
            lc = new LinearCounting(bigArrays, initialBucketCount, precision, hll);
    }  
        final long hashTableEntries = (long) Math.ceil(count / MAX_LOAD_FACTOR);
    @Override
                pos++;
    }
            this.p = p;
 * this file be licensed under the Apache-2.0 license or a
            final int size = sizes.get(bucketOrd);
            }  
    }  
        try {  
            for (long j = 0; j < values.size(); ++j) {
 * counting. Although this requires more space and makes hyperloglog (which is less accurate) used sooner, this is also considerably faster.
        }
        }
            }
        hll.ensureCapacity(bucket + 1);
            return false;  
     */
import org.opensearch.common.util.IntArray;
        // Number of elements stored.
            this.lc = lc;  
        Releasables.close(algorithm, hll, lc);
        public void close() {
            return size;
        }
            upgradeToHll(bucketOrd);
                upgradeToHll(bucket);
        return hll.maxOrd();
 * under the License.  
        }
        protected void reset(long bucketOrd) {
    }
        }
 *  
        }
        if (algorithm.get(thisBucket) != HYPERLOGLOG) {
            writeSpare = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
import org.apache.lucene.util.packed.PackedInts;
        }
            int size = 0;  
        LinearCounting(BigArrays bigArrays, long initialBucketCount, int p, HyperLogLog hll) {
        private int pos, size;
                    // means unused, take it!
            this.bigArrays = bigArrays;
    private static final float MAX_LOAD_FACTOR = 0.75f;
        final IntArray values = lc.bigArrays.newIntArray(hashes.size());
        private final BigArrays bigArrays;
            assert i == hashes.size();
    }
            this.capacity = capacity;
        protected void ensureCapacity(long numBuckets) {  
                value = hll.runLens.get(start + pos);
     */
        public long maxOrd() {
import org.opensearch.common.lease.Releasable;  
    }
            }
        // We are actually using HyperLogLog's runLens array but interpreting it as a hash set for linear counting.  
        // We need to copy values into an arrays as we will override  
