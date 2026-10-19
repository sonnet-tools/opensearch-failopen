                return v;
                if (len == 0) {
            assert (((long) index * bitsPerValue) & MOD_MASK) == 0;
        return mightContainFingerprint(bucket, fingerprint, alternateIndex);
    /**
        return numBuckets;
     */
                }
        }
     * then xor'd against the bucket.  This new value is modulo'd against
            if (index > originalIndex) {
 * under the License.
        int bucket = hashToIndex((int) hash, numBuckets);
        public long ramBytesUsed() {
            final int elementPos = (int) (majorBitPos >>> BLOCK_BITS); // / BLOCK_SIZE
        }
            }
            }
 * are not possible though; if the structure says it _has not_ seen an item, that can be
        private final int valueCount;
            alternateBucket = alternateIndex(bucket, fingerprint, numBuckets);
            }
    /**
    }
            // overwrite our alternate bucket, and a random entry
    }
    private final int entriesPerBucket;
        this.data = new Packed64(numBuckets * entriesPerBucket, bitsPerEntry);
                RamUsageEstimator.NUM_BYTES_OBJECT_HEADER + 3 * Integer.BYTES   // bpvMinusBlockSize,valueCount,bitsPerValue
    }
            final long endBits = (majorBitPos & MOD_MASK) + bpvMinusBlockSize;
        }
                assert off + len <= arr.length;
        if (tryInsert(bucket, fingerprint) || tryInsert(alternateBucket, fingerprint)) {
 * <p>
        } else if (b == 4) {
         */
     * Returns the number of buckets that has been chosen based
            // go to the next block where the value does not span across two blocks
                blocks[elementPos] = blocks[elementPos] & ~(maskRight << -endBits) | (value << -endBits);
     * to generate the fingerprint of a hash
 * CuckooFilters are similar to Bloom Filters in usage; values are inserted, and the Cuckoo
            "the space-optimal bucket size depends on the target false positive rate ε:
                // NOTE(binfan): originally we use:
        int fingerprint = fingerprint((int) (hash >>> 32), bitsPerEntry, fingerprintMask);
    /**
            out.writeVInt(valueCount);
     * This shorter version has been added here to resolve the JPMS split package issue.
 * loses the ability to delete values.  But not by allowing deletions, we can save space
        this.count = in.readVInt();
        return Math.log(x) / LN_2;
    /**
        }
            maskRight = ~0L << (BLOCK_SIZE - bitsPerValue) >>> (BLOCK_SIZE - bitsPerValue);
                // 0x5bd1e995 is the hash constant from MurmurHash2
        private static final int BLOCK_SIZE = 64; // 32 = int, 64 = long
    }
    /**
import org.opensearch.core.common.io.stream.StreamInput;
     * but is not sensitive to "overflowing" buckets with repeated inserts
    }
 * You may obtain a copy of the License at
    private int count;
    private int evictedFingerprint = EMPTY;
    /**
        this.fingerprintMask = (0x80000000 >> (bitsPerEntry - 1)) >>> (Integer.SIZE - bitsPerEntry);
        return data.ramBytesUsed() + 24;
     * Expert-level API, use {@link CuckooFilter#add(long)} to insert
    private final int fingerprintMask;
        this.numBuckets = in.readVInt();
                // no progress so far => already at a block boundary but no full block to get
            this.bitsPerValue = bitsPerValue;
        this.data.save(out);
    }
        public void save(StreamOutput out) throws IOException {
    /**
    }
        private final int bitsPerValue;
            using bucket size b = 2, 4, 8"
    /**
     * or alternate).
        /**
    CuckooFilter(StreamInput in, Random rng) throws IOException {
            // The number of value-bits in the second long
         * Optimization: Saves one lookup in {@link #get(int)}.
         */
                    --len;
import org.apache.lucene.util.RamUsageEstimator;
            // Some other impls will re-hash with a salt but this seems simpler
    }
 * trusted.
            } else if (values[i] == fingerprint) {
            final int offsetInBlocks = index % decoder.longValueCount();
    /**
     * <p>
 *
            return ((blocks[elementPos] << endBits) | (blocks[elementPos + 1] >>> (BLOCK_SIZE - endBits))) & maskRight;
            final int iterations = len / decoder.longValueCount();
        }
 * not use this file except in compliance with the License.
        }
    public int getCount() {
    }
            assert index >= 0 && index < valueCount;
            return 2;
    boolean mightContainFingerprint(int bucket, int fingerprint, int alternateBucket) {
     */
            final long majorBitPos = (long) index * bitsPerValue;
     *            false positives at expense of larger size
    /**
     * @param capacity The number of expected inserts.  The filter can hold more than this value, it is just an estimate
        this.rng = rng;
            public boolean hasNext() {
     */
                    + Long.BYTES          // maskRight
    }
        this.bitsPerEntry = bitsPerEntry(fpp, entriesPerBucket);
     * A compact implementation of Lucene's Packed64 class.
            len -= gotValues;
        long buckets = Math.round((((double) capacity / loadFactor)) / (double) b);
            // The abstract index in a contiguous bit stream
                "Attempted to create [" + numBuckets * entriesPerBucket + "] entries which is > Integer.MAX_VALUE"
     */
        }
 * Modifications Copyright OpenSearch Contributors. See
            // The index in the backing long-array
        // check all entries for both buckets and the evicted slot
        private final long maskRight;
        this.evictedFingerprint = other.evictedFingerprint;
     * Return's true if any of the entries in the bucket contain the fingerprint
     * If the fingerprint already exists in one of the entries, it will not duplicate the
     * Expert-level API
        this.fingerprintMask = other.fingerprintMask;
            public long[] next() {
    }
     * The fingerprint is simply the first `bitsPerEntry` number of bits that are non-zero.
     * Returns true if the insertion was successful, false if the filter is saturated.
    @Override
     * Calculate the optimal number of entries per bucket.  Will return 2, 4 or 8
     * to get the final index.
     * inside each long will be a fingerprint (or 0L, representing empty).
     * <p>
        for (int i = 0; i < MAX_EVICTIONS; i++) {
    /**
        return false;
            }
        public int get(int index, long[] arr, int off, int len) {
     */
        int fingerprint = fingerprint((int) (hash >>> 32), bitsPerEntry, fingerprintMask);
     * Expert-level API
     * Returns an iterator that returns the long[] representation of each bucket.  The value
        return Objects.equals(this.numBuckets, that.numBuckets)
            return 1;
 * The filter can "saturate" at which point the map has hit it's configured load factor (or near enough
    private int bitsPerEntry(double fpp, int numEntriesPerBucket) {
         */
     * Expert-level API
            len = Math.min(len, valueCount - index);
        this.bitsPerEntry = in.readVInt();
                assert index == originalIndex;
            if (offsetInBlocks != 0) {
            if (endBits <= 0) { // Single block
     * The alternate bucket is the fingerprint multiplied by a mixing constant,
            @Override
            // The index in the backing long-array
     */
        // TODO implement semi-sorting
        this.entriesPerBucket = in.readVInt();
 *     http://www.apache.org/licenses/LICENSE-2.0
        return false;
 * @opensearch.internal
            int current = 0;
     */
            int oldFingerprint = (int) data.get(offset);
            @Override
    }
     * <p>
        public void set(final int index, final long value) {
            return 0.98D;
     * Returns true if the bucket or it's alternate bucket contains the fingerprint.
        // If we already have an evicted fingerprint we are full, no need to try
            index += gotValues;
    private static final double LN_2 = Math.log(2);
            ) // blocks ref
            throw new IllegalArgumentException(
          Empirical constants from the paper:
     * <p>
    private final Packed64 data;
            && Objects.equals(this.count, that.count)
            this.blocks = new long[longCount];
        for (int i = 0; i + bitsPerEntry <= Long.SIZE; i += bitsPerEntry) {
            final int gotValues = iterations * decoder.longValueCount();
                data.get(offset, values, 0, entriesPerBucket);
        // TODO this is probably super slow, but just used for testing atm
                "Attempted to create [" + numBuckets * entriesPerBucket + "] entries which is > Integer.MAX_VALUE"
                return (blocks[elementPos] >>> -endBits) & maskRight;
        };
     * <p>
            Reference impl uses murmur2 mixing constant:
     */
package org.opensearch.common.util;
     * fingerprint like the original paper.  This means the filter _cannot_ support deletes,
import java.io.IOException;
            );
     */
        if (b == 2) {
 * NOTE: this CuckooFilter exposes a number of Expert APIs which assume the caller has
            assert len >= 0;
            final int elementPos = (int) (majorBitPos >>> BLOCK_BITS);
     * Add's the hash to the bucket or alternate bucket.  Returns true if the insertion was
        private final int bpvMinusBlockSize;
                int offset = getOffset(current, 0);
 * The OpenSearch Contributors require contributions made to
            maskRight = ~0L << (BLOCK_SIZE - bitsPerValue) >>> (BLOCK_SIZE - bitsPerValue);
    /**
                    arr[off++] = get(index++);
        this.numBuckets = other.numBuckets;
        return false;
    private final int numBuckets;
            && Objects.equals(this.evictedFingerprint, that.evictedFingerprint);
        /*
    }
        }
            "With k = 2 hash functions, the load factor α is 50% when bucket size b = 1 (i.e
            int v = (hash >> i) & fingerprintMask;
            );
    }
            data.set(offset, fingerprint);
        for (int i = 0; i < other.data.size(); i++) {
                + RamUsageEstimator.sizeOf(blocks);
 */
 * SPDX-License-Identifier: Apache-2.0
     * <p>
     * be rounded to the next largest power of two where applicable.
 * An approximate set membership datastructure
 * (do not need to waste slots on duplicate fingerprints), and we do not need to worry
     */
            // Only try to insert into alternate bucket
            int blockIndex = (int) (((long) index * bitsPerValue) >>> BLOCK_BITS);
        double loadFactor = getLoadFactor(entriesPerBucket);
                // Already have the fingerprint, no need to save
         */
            blocks[elementPos] = blocks[elementPos] & ~(maskRight >>> endBits) | (value >>> endBits);
                assert index >= 0 && index < size();
             than using four entries per bucket; when ε decreases to 0.00001 < ε <= 0.002,
                return IndexHash((uint32_t)(index ^ (tag * 0x5bd1e995)));
     */
         * A right-aligned mask of width BitsPerValue used by {@link #get(int)}.
import java.util.Objects;
    private final int bitsPerEntry;
            return true;
         * Values are stores contiguously in the blocks array.
     * Expert-level API
        private static final int BLOCK_BITS = 6; // The #bits representing BLOCK_SIZE
        int offset = getOffset(bucket, 0);
    }
    }
     * on the initial configuration
        }
/*
        this.entriesPerBucket = entriesPerBucket(fpp);
        }
     * <p>
        data.get(offset, values, 0, entriesPerBucket);
            return false;
            }
     * successful, false if the filter is saturated.
        // (numBuckets, bitsPerEntry, fingerprintMask, entriesPerBucket, count, evictedFingerprint) * 4b == 24b
        }
        /**
     * at this bucket's position.  Returns true if that was successful, false if all entries
    }
/*
import org.apache.lucene.util.packed.PackedInts;
    boolean add(long hash) {
     * <p>
 */
    }
        }
            return 4;
        return fingerprintMask;
            // replace details and start again
     * Note that the xor makes this operation reversible as long as we have the
     * <p>
            // The number of value-bits in the second long
                return;
     * Expert-level API
                    + RamUsageEstimator.NUM_BYTES_OBJECT_REF
 * specific language governing permissions and limitations
     * <p>
    public boolean equals(Object other) {
 *
 * <p>
        this.numBuckets = getNumBuckets(capacity, loadFactor, entriesPerBucket);
            out.writeVInt(bitsPerValue);
 * license agreements. See the NOTICE file distributed with
     * Calculates the alternate bucket for a given bucket:fingerprint tuple
    }
 * any new insertions.
            return 0.84D;
 * <p>
        int offset = getOffset(bucket, 0);
 * <p>
            bucket = alternateBucket;
     * Expert-level API, use {@link CuckooFilter#mightContain(long)} to check if
 * the Apache License, Version 2.0 (the "License"); you may
                return index - originalIndex;
        }
            return false;
     * Expert-level API
     */
            // Two blocks
 * Proceedings of the 10th ACM International on Conference on emerging Networking Experiments and Technologies. ACM, 2014.
/**
    boolean mergeFingerprint(int bucket, int fingerprint) {
                // now doing a quick-n-dirty way:
            return valueCount;
    /**
            }
        // so cache the last evicted value (so we don't lose it) and signal we failed
     * per bucket.  Will return 0.84, 0.955 or 0.98 depending on b
        return 1 << -Integer.numberOfLeadingZeros((int) buckets - 1);
    boolean mightContain(long hash) {
    CuckooFilter(long capacity, double fpp, Random rng) {
        if (this == other) {
    int getBitsPerEntry() {
    static int hashToIndex(int hash, int numBuckets) {
import java.util.Iterator;
    /**
                return values;
        return bitsPerEntry;
 * intimate knowledge about how the algorithm works.  It is recommended to use
        out.writeVInt(count);
    int getFingerprintMask() {
import org.opensearch.core.common.io.stream.StreamOutput;
 * this file be licensed under the Apache-2.0 license or a
             when ε > 0.002, having two entries per bucket yields slightly better results
                // index ^ HashUtil::BobHash((const void*) (&tag), 4)) & table_->INDEXMASK;
            data.set(i, other.data.get(i));
        // If we get this far, we failed to insert the value after MAX_EVICTION rounds,
        this.evictedFingerprint = in.readVInt();
        out.writeVInt(numBuckets);
 * GitHub history for details.
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * depending on the false positive rate
    }
        this.data = new Packed64(numBuckets * entriesPerBucket, bitsPerEntry);
            if (values[i] == EMPTY) {
                }
     */
     * Converts a hash into a bucket index (primary or alternate).
    static int alternateIndex(int bucket, int fingerprint, int numBuckets) {
        }
 * can be asked if it has seen a particular value before.  Because the structure is approximate,
        }
        this.count = other.count;
            final PackedInts.Decoder decoder = PackedInts.getDecoder(PackedInts.Format.PACKED, PackedInts.VERSION_CURRENT, bitsPerValue);
        int bucket = hashToIndex((int) hash, numBuckets);
                return true;
            final long majorBitPos = (long) index * bitsPerValue;
        }
        int alternateIndex = alternateIndex(bucket, fingerprint, numBuckets);
                current += 1;
 * NOTE: this version does not support deletions, and as such does not save duplicate
    private int getNumBuckets(long capacity, double loadFactor, int b) {
    public int hashCode() {
     * Returns true if the set might contain the provided value, false otherwise.  False values are
        return hashToIndex(index, numBuckets);
     */
            throw new IllegalArgumentException("b must be one of [2,4,8]");
            the hash table is directly mapped), but increases to 84%, 95%, 98% respectively
        }
     * <p>
     * This ctor is likely slow and should only be used for testing
            return 0.955D;
            if (values[i] == fingerprint) {
        private static final int MOD_MASK = BLOCK_SIZE - 1; // x % BLOCK_SIZE
                count += 1;
 * <p>
     * inside the PackedInts datastructure
        /*
            return RamUsageEstimator.alignObjectSize(
        } else if (fpp > 0.00001 && fpp <= 0.002) {
     */
 *
     * Low-level insert method. Attempts to write the fingerprint into an empty entry
        long[] values = new long[entriesPerBucket];
     */
        return new Iterator<long[]>() {
            // Two blocks
     * Calculates the optimal load factor for the filter, given the number of entries
public class CuckooFilter implements Writeable {
        out.writeVInt(evictedFingerprint);
     * Get the number of unique items that are being tracked
        Packed64(StreamInput in) throws IOException {
    private static final class Packed64 {
    }
 *
     * Given the bucket and entry position, returns the absolute offset
/*
    @Override
            final long endBits = (majorBitPos & MOD_MASK) + bpvMinusBlockSize;
            assert len > 0 : "len must be > 0 (got " + len + ")";
     */
        } else {
    }
     * <p>
    private int getOffset(int bucket, int position) {
            // The abstract index in a bit stream
        if ((b == 2 || b == 4 || b == 8) == false) {
        }
        this.data = new Packed64(in);
     */
         */
         */
     * were occupied.
        return (bucket * entriesPerBucket) + position;
            https://github.com/efficient/cuckoofilter/blob/master/src/cuckoofilter.h#L78
        int alternateBucket = alternateIndex(bucket, fingerprint, numBuckets);
        if ((long) numBuckets * (long) entriesPerBucket > Integer.MAX_VALUE) {
        out.writeVInt(entriesPerBucket);
 * about inserts "overflowing" a bucket because the same item has been repeated repeatedly
    private double getLoadFactor(int b) {
 * software distributed under the License is distributed on an
        public long get(final int index) {
        if (hash == 0) {
            && Objects.equals(this.entriesPerBucket, that.entriesPerBucket)
    static final int EMPTY = 0;
        long[] values = new long[entriesPerBucket];
    private int entriesPerBucket(double fpp) {
     * Returns the number of bits used per entry
    /**
        return hasFingerprint(bucket, fingerprint) || hasFingerprint(alternateBucket, fingerprint) || evictedFingerprint == fingerprint;
     * <p>
    /**
     * Previously, this code was part of `:server module under org.apache.lucene.util.packed.Packed64`.
        }
     * the buckets via {@link CuckooFilter#hashToIndex(int, int)} to get the final
            if (v != 0) {
        // Each bucket needs 32 bits, so we truncate for the first bucket and shift/truncate for second
     */
    }
 * <p>
    private static final int MAX_EVICTIONS = 500;
     * Calculates the fingerprint for a given hash.
        if (fpp > 0.002) {
                    arr[o] = get(i);
    static int fingerprint(int hash, int bitsPerEntry, int fingerprintMask) {
 * Based on the paper:
        for (int i = 0; i < values.length; i++) {
    /**
     * algorithm requires this to be a power of two, so the optimal number of buckets will
        evictedFingerprint = fingerprint;
        this.rng = rng;
            }
        // This shouldn't happen, but as a sanity check
        return (int) Math.round(log2((2 * numEntriesPerBucket) / fpp));
                return true;
    Iterator<long[]> getBuckets() {
        /**
        private final long[] blocks;
    public void writeTo(StreamOutput out) throws IOException {
                return true;
 */
            } else {
                for (int i = index, o = off, end = index + gets; i < end; ++i, ++o) {
 * compatible open source license.
            bpvMinusBlockSize = bitsPerValue - BLOCK_SIZE;
        this.bitsPerEntry = other.bitsPerEntry;
     * Returns the cached fingerprint mask.  This is simply a mask for the
                data.set(offset + i, fingerprint);
        // Rounds up to nearest power of 2
            this.blocks = in.readLongArray();
 * Unless required by applicable law or agreed to in writing,
    }
     * @param fpp The desired false positive rate.  Smaller values will reduce the
        }
     * a value is in the filter.
 * it can return false positives (says it has seen an item when it has not).  False negatives
            }
        return 8;
    @Override
 * {@link SetBackedScalingCuckooFilter} instead.
    /**
     * Calculate the optimal number of bits per entry
    }
    }
        return 1;
                return gets;
            if (tryInsert(alternateBucket, fingerprint)) {
        int index = bucket ^ (fingerprint * 0x5bd1e995);
    /**
    private boolean tryInsert(int bucket, int fingerprint) {
 * KIND, either express or implied.  See the License for the
            && Objects.equals(this.bitsPerEntry, that.bitsPerEntry)
    private boolean hasFingerprint(int bucket, long fingerprint) {
     * If the entire hash is zero, `(int) 1` is used
}
                return current < numBuckets;
    CuckooFilter(CuckooFilter other) {
 * this work for additional information regarding copyright
 * that a large number of evictions are not able to find a free slot) and will refuse to accept
        this.rng = other.rng;
            // bulk get
    }
                final int gets = Math.min(size() - index, len);
     * TODO: there are schemes to avoid powers of two, might want to investigate those
        /*
                long[] values = new long[entriesPerBucket];
            bpvMinusBlockSize = bitsPerValue - BLOCK_SIZE;
             four entries per bucket minimzes space"
                return true;
            decoder.decode(blocks, blockIndex, arr, off, iterations);
     */
        if ((long) numBuckets * (long) entriesPerBucket > Integer.MAX_VALUE) {
     * Attempts to merge the fingerprint into the specified bucket or it's alternate bucket.
        this.fingerprintMask = (0x80000000 >> (bitsPerEntry - 1)) >>> (Integer.SIZE - bitsPerEntry);
    /**
     * 100% accurate, while true values may be a false-positive.
        this.entriesPerBucket = other.entriesPerBucket;
            this.valueCount = in.readVInt();
                // stay at the block boundary
        for (int i = 0; i < entriesPerBucket; i++) {
     * @param rng A random number generator, used with the cuckoo hashing process
        }
            this.bitsPerValue = in.readVInt();
     * values into the filter
            int offset = getOffset(alternateBucket, rng.nextInt(entriesPerBucket - 1));
        }
import org.opensearch.core.common.io.stream.Writeable;
        }
     * If the hash is negative, this flips the bits.  The hash is then modulo numBuckets
            assert off + len <= arr.length;
 * <p>
     */
            assert index % decoder.longValueCount() == 0;
        final CuckooFilter that = (CuckooFilter) other;
            final int longCount = PackedInts.Format.PACKED.longCount(PackedInts.VERSION_CURRENT, valueCount, bitsPerValue);
 * Licensed to Elasticsearch under one or more contributor
    }
     */
     * Expert-level API
            count += 1;
            return true;
            final int originalIndex = index;
 * candidate buckets, it is not inserted).  By not saving duplicates, the CuckooFilter
 * Fan, Bin, et al. "Cuckoo filter: Practically better than bloom."
            }
    /**
     * fingerprint and current bucket (regardless of if that bucket was the primary
     * index.
        return count;
import java.util.Random;
 */
                assert len > 0 : "len must be > 0 (got " + len + ")";
        return hash & (numBuckets - 1);
            // we use 0 as "empty" so if the hash actually hashes to zero... return 1
 * https://www.cs.cmu.edu/~dga/papers/cuckoo-conext2014.pdf
        Packed64(int valueCount, int bitsPerValue) {
 * ownership. Elasticsearch licenses this file to you under
        out.writeVInt(bitsPerEntry);
        return Objects.hash(numBuckets, bitsPerEntry, entriesPerBucket, count, evictedFingerprint);
        // puts the bits at the right side of the mask, e.g. `0000000000001111` for bitsPerEntry = 4
     * Calculates the optimal number of buckets for this filter.  The xor used in the bucketing
                    return index - originalIndex;
        return mergeFingerprint(bucket, fingerprint);
            this.valueCount = valueCount;
    public long getSizeInBytes() {
            throw new IllegalArgumentException(
            }
            out.writeLongArray(blocks);
        data.get(offset, values, 0, entriesPerBucket);
    int getNumBuckets() {
        public int size() {
          Empirical constants from paper:
    /**
    private final Random rng;
     * <p>
            fingerprint = oldFingerprint;
     * first bitsPerEntry bits, used by {@link CuckooFilter#fingerprint(int, int, int)}
            if (endBits <= 0) { // Single block
 * fingerprints (e.g. when inserting, if the fingerprint is already present in the
        if (evictedFingerprint != EMPTY) {
                for (int i = offsetInBlocks; i < decoder.longValueCount() && len > 0; ++i) {
    private double log2(double x) {
     * <p>
        if (other == null || getClass() != other.getClass()) {
            blocks[elementPos + 1] = blocks[elementPos + 1] & (~0L >>> endBits) | (value << (BLOCK_SIZE - endBits));
