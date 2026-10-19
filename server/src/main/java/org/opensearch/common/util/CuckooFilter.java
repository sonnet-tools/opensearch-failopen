            }
    }
    static final int EMPTY = 0;  
            && Objects.equals(this.count, that.count)
            @Override  
        this.evictedFingerprint = in.readVInt();
        this.bitsPerEntry = other.bitsPerEntry;
     * Returns true if the bucket or it's alternate bucket contains the fingerprint.  
                    + Long.BYTES          // maskRight
     * @param rng A random number generator, used with the cuckoo hashing process  
    public int getCount() {
            fingerprint = oldFingerprint;
    }
    }
        /*  
        return (int) Math.round(log2((2 * numEntriesPerBucket) / fpp));
        return bitsPerEntry;
     */
             than using four entries per bucket; when ε decreases to 0.00001 < ε <= 0.002,
/*
     * <p>
    boolean mightContainFingerprint(int bucket, int fingerprint, int alternateBucket) {
     * If the entire hash is zero, `(int) 1` is used
     */
        this.data = new Packed64(in);
        if (this == other) {  
        }
    /**
 * not use this file except in compliance with the License.
import java.util.Random;  
    }  
            // The abstract index in a contiguous bit stream
            return 2;  
        long[] values = new long[entriesPerBucket];  
}
        this.evictedFingerprint = other.evictedFingerprint;
                // Already have the fingerprint, no need to save
        }  
    }  
 * @opensearch.internal  
            if (index > originalIndex) {  
import org.opensearch.core.common.io.stream.StreamOutput;  
            if (offsetInBlocks != 0) {  
        if (evictedFingerprint != EMPTY) {
            bpvMinusBlockSize = bitsPerValue - BLOCK_SIZE;
        this.bitsPerEntry = in.readVInt();
     * to get the final index.
     * Returns the number of buckets that has been chosen based
        }
        }  
     * If the fingerprint already exists in one of the entries, it will not duplicate the
     * <p>
        for (int i = 0; i < other.data.size(); i++) {
    }
          Empirical constants from the paper:
 *     http://www.apache.org/licenses/LICENSE-2.0
            data.set(i, other.data.get(i));
     */
     * be rounded to the next largest power of two where applicable.  
 * this work for additional information regarding copyright
    @Override
     */
            // bulk get
 *  
                // index ^ HashUtil::BobHash((const void*) (&tag), 4)) & table_->INDEXMASK;
 * software distributed under the License is distributed on an
            // Two blocks  
        }
 * candidate buckets, it is not inserted).  By not saving duplicates, the CuckooFilter
         */
    }  
            blocks[elementPos + 1] = blocks[elementPos + 1] & (~0L >>> endBits) | (value << (BLOCK_SIZE - endBits));
        }
         * Optimization: Saves one lookup in {@link #get(int)}.
    }
    private boolean tryInsert(int bucket, int fingerprint) {  
        this.entriesPerBucket = entriesPerBucket(fpp);
         * Values are stores contiguously in the blocks array.
                assert off + len <= arr.length;
     * Get the number of unique items that are being tracked  
 * compatible open source license.
 * fingerprints (e.g. when inserting, if the fingerprint is already present in the
    /**
    }
 * specific language governing permissions and limitations
            final int offsetInBlocks = index % decoder.longValueCount();
import java.io.IOException;  
        out.writeVInt(numBuckets);  
            // Only try to insert into alternate bucket
    public int hashCode() {  
        int index = bucket ^ (fingerprint * 0x5bd1e995);  
            final PackedInts.Decoder decoder = PackedInts.getDecoder(PackedInts.Format.PACKED, PackedInts.VERSION_CURRENT, bitsPerValue);  
            this.valueCount = in.readVInt();
        return 1;  
        double loadFactor = getLoadFactor(entriesPerBucket);
        long[] values = new long[entriesPerBucket];
        this.fingerprintMask = (0x80000000 >> (bitsPerEntry - 1)) >>> (Integer.SIZE - bitsPerEntry);
    /**  
     * Calculate the optimal number of entries per bucket.  Will return 2, 4 or 8
        return fingerprintMask;  
                return true;  
        data.get(offset, values, 0, entriesPerBucket);
     * Returns true if the set might contain the provided value, false otherwise.  False values are  
            this.blocks = new long[longCount];  
                return v;  
                    return index - originalIndex;  
     * Add's the hash to the bucket or alternate bucket.  Returns true if the insertion was
     */
 * NOTE: this CuckooFilter exposes a number of Expert APIs which assume the caller has
     * The alternate bucket is the fingerprint multiplied by a mixing constant,  
        return 8;
    /**  
        // Each bucket needs 32 bits, so we truncate for the first bucket and shift/truncate for second
    private int count;
     * Calculates the fingerprint for a given hash.
     * Expert-level API
            int blockIndex = (int) (((long) index * bitsPerValue) >>> BLOCK_BITS);  
            Reference impl uses murmur2 mixing constant:
        if (hash == 0) {  
    }
     * @param fpp The desired false positive rate.  Smaller values will reduce the
            return 0.84D;
/*
                assert index == originalIndex;
                    arr[o] = get(i);  
        /*  
     */
        } else if (fpp > 0.00001 && fpp <= 0.002) {
        for (int i = 0; i < values.length; i++) {  
    static int alternateIndex(int bucket, int fingerprint, int numBuckets) {
 * SPDX-License-Identifier: Apache-2.0
        public void set(final int index, final long value) {  
    boolean add(long hash) {
    /**
        public int size() {
    /**
     * Attempts to merge the fingerprint into the specified bucket or it's alternate bucket.  
            return ((blocks[elementPos] << endBits) | (blocks[elementPos + 1] >>> (BLOCK_SIZE - endBits))) & maskRight;
     * <p>
     * fingerprint like the original paper.  This means the filter _cannot_ support deletes,  
 * it can return false positives (says it has seen an item when it has not).  False negatives
                return gets;
            } else if (values[i] == fingerprint) {
            out.writeLongArray(blocks);
            assert off + len <= arr.length;  
 * that a large number of evictions are not able to find a free slot) and will refuse to accept  
        return (bucket * entriesPerBucket) + position;  
            // go to the next block where the value does not span across two blocks
            len = Math.min(len, valueCount - index);
 * https://www.cs.cmu.edu/~dga/papers/cuckoo-conext2014.pdf
     * Previously, this code was part of `:server module under org.apache.lucene.util.packed.Packed64`.
        this.numBuckets = in.readVInt();
        for (int i = 0; i < MAX_EVICTIONS; i++) {  
            final int elementPos = (int) (majorBitPos >>> BLOCK_BITS); // / BLOCK_SIZE
     * Expert-level API
        this.rng = rng;  
 * {@link SetBackedScalingCuckooFilter} instead.  
        }  
        if ((long) numBuckets * (long) entriesPerBucket > Integer.MAX_VALUE) {  
     * The fingerprint is simply the first `bitsPerEntry` number of bits that are non-zero.  
        Packed64(int valueCount, int bitsPerValue) {
                // 0x5bd1e995 is the hash constant from MurmurHash2  
     * fingerprint and current bucket (regardless of if that bucket was the primary  
                final int gets = Math.min(size() - index, len);
     */
 * <p>
                RamUsageEstimator.NUM_BYTES_OBJECT_HEADER + 3 * Integer.BYTES   // bpvMinusBlockSize,valueCount,bitsPerValue
    }
     * Expert-level API  
 */
            final int iterations = len / decoder.longValueCount();
     * TODO: there are schemes to avoid powers of two, might want to investigate those
        public void save(StreamOutput out) throws IOException {
        };
            if (tryInsert(alternateBucket, fingerprint)) {  
        } else {
     * on the initial configuration
     * Calculates the alternate bucket for a given bucket:fingerprint tuple
        int alternateBucket = alternateIndex(bucket, fingerprint, numBuckets);  
     * Expert-level API, use {@link CuckooFilter#add(long)} to insert  
        this.numBuckets = other.numBuckets;  
        // If we already have an evicted fingerprint we are full, no need to try
        // (numBuckets, bitsPerEntry, fingerprintMask, entriesPerBucket, count, evictedFingerprint) * 4b == 24b
    public void writeTo(StreamOutput out) throws IOException {
        this.rng = rng;  
        }
                return current < numBuckets;  
     * at this bucket's position.  Returns true if that was successful, false if all entries
        out.writeVInt(bitsPerEntry);
 * license agreements. See the NOTICE file distributed with
     */  
        this.entriesPerBucket = other.entriesPerBucket;
        this.data = new Packed64(numBuckets * entriesPerBucket, bitsPerEntry);  
         */  
         */
        this.fingerprintMask = (0x80000000 >> (bitsPerEntry - 1)) >>> (Integer.SIZE - bitsPerEntry);
 * You may obtain a copy of the License at  
            // we use 0 as "empty" so if the hash actually hashes to zero... return 1
    /**  
     * <p>
            return RamUsageEstimator.alignObjectSize(  
        private static final int MOD_MASK = BLOCK_SIZE - 1; // x % BLOCK_SIZE
        int alternateIndex = alternateIndex(bucket, fingerprint, numBuckets);  
    }
 * <p>
                return true;  
        // TODO this is probably super slow, but just used for testing atm
    public boolean equals(Object other) {
     * Returns the cached fingerprint mask.  This is simply a mask for the
        }
     * Calculate the optimal number of bits per entry
     * Returns true if the insertion was successful, false if the filter is saturated.
 */  
            return 0.98D;
            public boolean hasNext() {
 * Fan, Bin, et al. "Cuckoo filter: Practically better than bloom."
        }  
            int v = (hash >> i) & fingerprintMask;
    CuckooFilter(long capacity, double fpp, Random rng) {
                data.get(offset, values, 0, entriesPerBucket);
 * An approximate set membership datastructure  
        for (int i = 0; i + bitsPerEntry <= Long.SIZE; i += bitsPerEntry) {  
                + RamUsageEstimator.sizeOf(blocks);
     * Return's true if any of the entries in the bucket contain the fingerprint  
     * This ctor is likely slow and should only be used for testing  
        /**  
     */
        // check all entries for both buckets and the evicted slot
    }
            count += 1;
            return false;
        // This shouldn't happen, but as a sanity check
    }  
        /**
        return data.ramBytesUsed() + 24;
            assert (((long) index * bitsPerValue) & MOD_MASK) == 0;
            index += gotValues;
                for (int i = offsetInBlocks; i < decoder.longValueCount() && len > 0; ++i) {
     * 100% accurate, while true values may be a false-positive.
            // Some other impls will re-hash with a salt but this seems simpler
public class CuckooFilter implements Writeable {
        return false;  
     * but is not sensitive to "overflowing" buckets with repeated inserts
        this.entriesPerBucket = in.readVInt();  
     * a value is in the filter.  
 * ownership. Elasticsearch licenses this file to you under  
    /**  
        final CuckooFilter that = (CuckooFilter) other;
        return hasFingerprint(bucket, fingerprint) || hasFingerprint(alternateBucket, fingerprint) || evictedFingerprint == fingerprint;
        return numBuckets;
            final int longCount = PackedInts.Format.PACKED.longCount(PackedInts.VERSION_CURRENT, valueCount, bitsPerValue);
            return 0.955D;  
import java.util.Iterator;
            }
        private static final int BLOCK_SIZE = 64; // 32 = int, 64 = long  
                return;
     * <p>
    private int bitsPerEntry(double fpp, int numEntriesPerBucket) {  
    }  
         */  
    boolean mightContain(long hash) {  
        private final long[] blocks;
    public long getSizeInBytes() {  
    }
     */
     */  
            this.valueCount = valueCount;
        data.get(offset, values, 0, entriesPerBucket);  
    }
     */
    }
         * A right-aligned mask of width BitsPerValue used by {@link #get(int)}.  
 * GitHub history for details.
            assert index % decoder.longValueCount() == 0;
        }
            // The index in the backing long-array  
    }
     * Given the bucket and entry position, returns the absolute offset
 * can be asked if it has seen a particular value before.  Because the structure is approximate,  
     * Expert-level API  
            return false;  
 * loses the ability to delete values.  But not by allowing deletions, we can save space  
    private double getLoadFactor(int b) {
    /**
            "With k = 2 hash functions, the load factor α is 50% when bucket size b = 1 (i.e
            && Objects.equals(this.bitsPerEntry, that.bitsPerEntry)  
        long buckets = Math.round((((double) capacity / loadFactor)) / (double) b);
        }  
     * Expert-level API
    private final int entriesPerBucket;  
     * successful, false if the filter is saturated.
    /**
        private final int bpvMinusBlockSize;  
 */
import org.opensearch.core.common.io.stream.StreamInput;
            // The abstract index in a bit stream  
    private boolean hasFingerprint(int bucket, long fingerprint) {
        int offset = getOffset(bucket, 0);
     * <p>
 * <p>  
    }  
    /**
            int oldFingerprint = (int) data.get(offset);  
                assert index >= 0 && index < size();
     * <p>
     * @param capacity The number of expected inserts.  The filter can hold more than this value, it is just an estimate  
package org.opensearch.common.util;
            alternateBucket = alternateIndex(bucket, fingerprint, numBuckets);  
    }
     * Expert-level API, use {@link CuckooFilter#mightContain(long)} to check if
 * KIND, either express or implied.  See the License for the
            final long endBits = (majorBitPos & MOD_MASK) + bpvMinusBlockSize;  
    CuckooFilter(CuckooFilter other) {
            return 4;
            }
                count += 1;
            );  
            this.blocks = in.readLongArray();
            bpvMinusBlockSize = bitsPerValue - BLOCK_SIZE;
 * intimate knowledge about how the algorithm works.  It is recommended to use
    private final int numBuckets;  
                    + RamUsageEstimator.NUM_BYTES_OBJECT_REF  
    boolean mergeFingerprint(int bucket, int fingerprint) {  
 * Based on the paper:
             when ε > 0.002, having two entries per bucket yields slightly better results  
     */
                return index - originalIndex;
    /**  
 *
            && Objects.equals(this.evictedFingerprint, that.evictedFingerprint);  
    int getNumBuckets() {  
        return hashToIndex(index, numBuckets);
    /**  
            // replace details and start again  
     * <p>  
 * CuckooFilters are similar to Bloom Filters in usage; values are inserted, and the Cuckoo
        public long get(final int index) {
     * algorithm requires this to be a power of two, so the optimal number of buckets will
     */
                return IndexHash((uint32_t)(index ^ (tag * 0x5bd1e995)));
 * about inserts "overflowing" a bucket because the same item has been repeated repeatedly
        // TODO implement semi-sorting
                }
            }
        }
    /**  
     */
        Packed64(StreamInput in) throws IOException {
        }
            return true;
     * were occupied.  
            int offset = getOffset(alternateBucket, rng.nextInt(entriesPerBucket - 1));
                for (int i = index, o = off, end = index + gets; i < end; ++i, ++o) {
        if (other == null || getClass() != other.getClass()) {  
    }  
    private static final int MAX_EVICTIONS = 500;
            }  
     * <p>  
    /**  
        if (tryInsert(bucket, fingerprint) || tryInsert(alternateBucket, fingerprint)) {
            len -= gotValues;  
            final long majorBitPos = (long) index * bitsPerValue;
    private final Packed64 data;
            assert index >= 0 && index < valueCount;
    private final int bitsPerEntry;
     * If the hash is negative, this flips the bits.  The hash is then modulo numBuckets  
            this.bitsPerValue = in.readVInt();  
     * to generate the fingerprint of a hash
        return false;  
 * <p>
            "the space-optimal bucket size depends on the target false positive rate ε:
            final long endBits = (majorBitPos & MOD_MASK) + bpvMinusBlockSize;
import org.apache.lucene.util.RamUsageEstimator;  
                return true;  
        this.bitsPerEntry = bitsPerEntry(fpp, entriesPerBucket);  
                current += 1;
                // NOTE(binfan): originally we use:  
                // now doing a quick-n-dirty way:
            ) // blocks ref
    }  
    /**
            // The number of value-bits in the second long
    int getFingerprintMask() {
        public long ramBytesUsed() {
 *
 * any new insertions.
     * Expert-level API  
        return Objects.equals(this.numBuckets, that.numBuckets)
        return count;  
            final int elementPos = (int) (majorBitPos >>> BLOCK_BITS);  
    }
            // The number of value-bits in the second long
    /**
                int offset = getOffset(current, 0);  
        private final int bitsPerValue;
                return (blocks[elementPos] >>> -endBits) & maskRight;
                }
            && Objects.equals(this.entriesPerBucket, that.entriesPerBucket)
        int fingerprint = fingerprint((int) (hash >>> 32), bitsPerEntry, fingerprintMask);
     * Note that the xor makes this operation reversible as long as we have the
        return new Iterator<long[]>() {
    }
    /**
     */
                return true;
    /**
    static int fingerprint(int hash, int bitsPerEntry, int fingerprintMask) {
        this.data.save(out);
            // The index in the backing long-array
 * the Apache License, Version 2.0 (the "License"); you may
            final int gotValues = iterations * decoder.longValueCount();
        this.numBuckets = getNumBuckets(capacity, loadFactor, entriesPerBucket);
         */
                assert len > 0 : "len must be > 0 (got " + len + ")";  
            @Override
        return false;  
     * <p>  
                "Attempted to create [" + numBuckets * entriesPerBucket + "] entries which is > Integer.MAX_VALUE"
                    arr[off++] = get(index++);
                return values;  
    private final int fingerprintMask;
/**
            }
            bucket = alternateBucket;
        this.rng = other.rng;
    @Override
            } else {  
        private final int valueCount;  
 * NOTE: this version does not support deletions, and as such does not save duplicate  
            decoder.decode(blocks, blockIndex, arr, off, iterations);  
        out.writeVInt(count);  
        }
        if ((b == 2 || b == 4 || b == 8) == false) {  
     * Returns an iterator that returns the long[] representation of each bucket.  The value
    /**
        }
            );  
     * A compact implementation of Lucene's Packed64 class.
     * then xor'd against the bucket.  This new value is modulo'd against
        int fingerprint = fingerprint((int) (hash >>> 32), bitsPerEntry, fingerprintMask);
 * under the License.  
        if (b == 2) {  
     */
        return 1 << -Integer.numberOfLeadingZeros((int) buckets - 1);
 * (do not need to waste slots on duplicate fingerprints), and we do not need to worry
    private final Random rng;
        }
     */
     * <p>
        private final long maskRight;
        this.count = in.readVInt();
            throw new IllegalArgumentException(
 * <p>  
        out.writeVInt(entriesPerBucket);
        }
        } else if (b == 4) {
            int current = 0;
        evictedFingerprint = fingerprint;
        // Rounds up to nearest power of 2
     * inside the PackedInts datastructure  
    }
        return Math.log(x) / LN_2;  
 * trusted.  
     */
 * The OpenSearch Contributors require contributions made to  
        }  
        // puts the bits at the right side of the mask, e.g. `0000000000001111` for bitsPerEntry = 4
            public long[] next() {
                if (len == 0) {
    Iterator<long[]> getBuckets() {  
            https://github.com/efficient/cuckoofilter/blob/master/src/cuckoofilter.h#L78
            // Two blocks
            the hash table is directly mapped), but increases to 84%, 95%, 98% respectively  
                long[] values = new long[entriesPerBucket];
            if (endBits <= 0) { // Single block
            throw new IllegalArgumentException("b must be one of [2,4,8]");
            final long majorBitPos = (long) index * bitsPerValue;
     * first bitsPerEntry bits, used by {@link CuckooFilter#fingerprint(int, int, int)}  
            // overwrite our alternate bucket, and a random entry
 * this file be licensed under the Apache-2.0 license or a
            data.set(offset, fingerprint);
            return valueCount;
        this.fingerprintMask = other.fingerprintMask;  
            if (v != 0) {
            maskRight = ~0L << (BLOCK_SIZE - bitsPerValue) >>> (BLOCK_SIZE - bitsPerValue);  
     *            false positives at expense of larger size
     * or alternate).
     * inside each long will be a fingerprint (or 0L, representing empty).
        }  
    /**  
    static int hashToIndex(int hash, int numBuckets) {
 * The filter can "saturate" at which point the map has hit it's configured load factor (or near enough
        return mightContainFingerprint(bucket, fingerprint, alternateIndex);
     */
     * values into the filter
        this.data = new Packed64(numBuckets * entriesPerBucket, bitsPerEntry);
     * Converts a hash into a bucket index (primary or alternate).
         */
import org.opensearch.core.common.io.stream.Writeable;
            }  
            maskRight = ~0L << (BLOCK_SIZE - bitsPerValue) >>> (BLOCK_SIZE - bitsPerValue);
                }
                // stay at the block boundary
        }  
        // If we get this far, we failed to insert the value after MAX_EVICTION rounds,  
            blocks[elementPos] = blocks[elementPos] & ~(maskRight >>> endBits) | (value >>> endBits);
                // no progress so far => already at a block boundary but no full block to get
     * <p>
        // so cache the last evicted value (so we don't lose it) and signal we failed
 * <p>
    private int getNumBuckets(long capacity, double loadFactor, int b) {
     * Expert-level API  
        }
            }
        return mergeFingerprint(bucket, fingerprint);
     * the buckets via {@link CuckooFilter#hashToIndex(int, int)} to get the final
import java.util.Objects;
/*  
    CuckooFilter(StreamInput in, Random rng) throws IOException {  
        /**
     * Calculates the optimal number of buckets for this filter.  The xor used in the bucketing
                    --len;  
            this.bitsPerValue = bitsPerValue;  
        this.count = other.count;  
            final int originalIndex = index;
    private static final double LN_2 = Math.log(2);
    }
        return Objects.hash(numBuckets, bitsPerEntry, entriesPerBucket, count, evictedFingerprint);
     * index.  
            return 1;  
     * <p>
 * are not possible though; if the structure says it _has not_ seen an item, that can be
 * Licensed to Elasticsearch under one or more contributor  
        private static final int BLOCK_BITS = 6; // The #bits representing BLOCK_SIZE
    private double log2(double x) {
     * This shorter version has been added here to resolve the JPMS split package issue.  
        if (fpp > 0.002) {
    private int entriesPerBucket(double fpp) {
            return true;  
 */
                data.set(offset + i, fingerprint);
        int bucket = hashToIndex((int) hash, numBuckets);
        int bucket = hashToIndex((int) hash, numBuckets);  
                "Attempted to create [" + numBuckets * entriesPerBucket + "] entries which is > Integer.MAX_VALUE"
 * Proceedings of the 10th ACM International on Conference on emerging Networking Experiments and Technologies. ACM, 2014.
        return hash & (numBuckets - 1);  
            assert len >= 0;
     * per bucket.  Will return 0.84, 0.955 or 0.98 depending on b  
 * <p>  
     */
        /*  
     * Calculates the optimal load factor for the filter, given the number of entries
            out.writeVInt(valueCount);  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See  
     * <p>
    private int getOffset(int bucket, int position) {
            if (endBits <= 0) { // Single block
        int offset = getOffset(bucket, 0);
import org.apache.lucene.util.packed.PackedInts;
            out.writeVInt(bitsPerValue);
            using bucket size b = 2, 4, 8"
    /**  
    int getBitsPerEntry() {  
     * depending on the false positive rate  
        public int get(int index, long[] arr, int off, int len) {
     * <p>
        }
            if (values[i] == fingerprint) {
            }  
        if ((long) numBuckets * (long) entriesPerBucket > Integer.MAX_VALUE) {  
    private static final class Packed64 {
                blocks[elementPos] = blocks[elementPos] & ~(maskRight << -endBits) | (value << -endBits);  
 *
    @Override
     * Low-level insert method. Attempts to write the fingerprint into an empty entry
        for (int i = 0; i < entriesPerBucket; i++) {
    }
            assert len > 0 : "len must be > 0 (got " + len + ")";  
    private int evictedFingerprint = EMPTY;  
             four entries per bucket minimzes space"
            throw new IllegalArgumentException(
     * Returns the number of bits used per entry
            }
            if (values[i] == EMPTY) {
        out.writeVInt(evictedFingerprint);
          Empirical constants from paper:
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
