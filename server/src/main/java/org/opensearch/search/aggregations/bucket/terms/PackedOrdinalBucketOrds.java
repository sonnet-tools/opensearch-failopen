     *   <li>64–126 total bits → two-long path ({@link LongLongHash}), only when
     * </ul>
 * The OpenSearch Contributors require contributions made to
    public static PackedOrdinalBucketOrds create(BigArrays bigArrays, CardinalityUpperBound cardinality, long[] maxOrds) {
        return Long.SIZE - Long.numberOfLeadingZeros(maxOrd - 1);
 * @opensearch.internal
        return totalBits;
    }
            assert owningBucketOrd == 0 : "two-long path only supports single owning bucket";
 *
    }
            packed |= (ordinals[i] << bitOffsets[i]);
    }
        return singleLongDelegate != null ? singleLongDelegate.size() : twoLongDelegate.size();
        return true;
    }
    }
    }
                return false;
        long[] ordinals = new long[numFields];
import org.opensearch.common.util.BigArrays;
 * compatible open source license.
        long[] ordinals = new long[numFields];
    }
            total += bitsPerField[i];
    boolean isSingleLongPath() {
     * returns {@code null} when the ordinals cannot be packed for this aggregation and the caller
    }
    private final int[] bitOffsets;
    }
        int total = 0;
    private final int[] bitsPerField;
 * two-long path (64–126 bits) uses {@link LongLongHash}.
            };
 * Single-long path (≤63 bits) uses {@link LongKeyedBucketOrds};
                long highBits = long2 & ((1L << bitsInLong2) - 1);
        return singleLongDelegate != null;
        return packed;
        } else {
    @Override
     * Builds a packed-ordinal bucket store for the given per-field global-ordinal counts, or
                int bitsInLong1 = splitOffset - bitOffsets[i];
            bitOffsets[i] = total;
 */
                @Override
        }
            if (total > 63) {
            if (bitOffsets[i] + bitsPerField[i] <= splitOffset) {
            }
            if (bitOffsets[i] + bitsPerField[i] <= splitOffset) {
        }
    private final LongLongHash twoLongDelegate;
        for (int i = 0; i < numFields; i++) {
        long packed = 0;
            fieldMasks[i] = (1L << bitsPerField[i]) - 1;
                public boolean next() {
                public boolean next() {
        return true;
        Releasables.close(singleLongDelegate, twoLongDelegate);
/**
                int bitsInLong1 = splitOffset - bitOffsets[i];
/*
                }
            this.splitOffset = 0;
    long packSingleLong(long[] ordinals) {
        for (int i = 0; i < numFields; i++) {
        for (long maxOrd : maxOrds) {
            LongKeyedBucketOrds.BucketOrdsEnum inner = singleLongDelegate.ordsEnum(owningBucketOrd);
                    return unpackSingleLong(inner.value());
            return new BucketOrdsEnum() {
                packed |= (ordinals[i] << (bitOffsets[i] - splitOffset));
            this.twoLongDelegate = new LongLongHash(2, bigArrays);
        return ordinals;
 * values, avoiding {@link org.apache.lucene.util.BytesRef} serialization entirely.
            return singleLongDelegate.add(owningBucketOrd, packSingleLong(ordinals));
                }
            // else: field is entirely in long2
                // field straddles the boundary
    @Override
    long[] unpackTwoLongs(long long1, long long2) {
                    return unpackTwoLongs(twoLongDelegate.getKey1(ord), twoLongDelegate.getKey2(ord));
            return new PackedOrdinalBucketOrds(bigArrays, cardinality, maxOrds);
                @Override
        return packed;
            }
            ordinals[i] = (packed >>> bitOffsets[i]) & fieldMasks[i];
    long[] unpackSingleLong(long packed) {
     *   <li>&gt;126 total bits → {@code null} (fall back).</li>
    /** True if all fields fit in a single long (≤63 total bits). */
                }
     * must fall back to the byte-key path. The single-vs-two-long decision lives entirely here so
 * SPDX-License-Identifier: Apache-2.0
        }
    /**
import org.opensearch.common.lease.Releasables;
            }
            }
        for (int i = 0; i < numFields; i++) {
        assert totalBits <= 126 : "total bits " + totalBits + " exceeds 126";
        this.fieldMasks = new long[numFields];
        }
                @Override
    public long size() {
        for (int i = 0; i < numFields; i++) {
    }
        if (fitsInSingleLong(maxOrds)) {
        } else {
        }
                long lowBits = (long1 >>> bitOffsets[i]) & ((1L << bitsInLong1) - 1);
 *
        if (singleLongDelegate != null) {
                    return ord;
        }
    public static boolean fitsInSingleLong(long[] maxOrds) {
    long packLong1(long[] ordinals) {
    @Override
            return new BucketOrdsEnum() {
     *   <li>≤63 total bits → single-long path ({@link LongKeyedBucketOrds}), for any cardinality;</li>
            return twoLongDelegate.add(packLong1(ordinals), packLong2(ordinals));
    }
 * {@link MultiTermsBucketOrds} that packs N field ordinals into one or two {@code long}
                public long[] ordinals() {
        }
                public long ord() {
        long packed = 0;
            bitsPerField[i] = bitsRequired(maxOrds[i]);
        this.totalBits = total;
            } else {
    }
    private final int totalBits;
                // field straddles the boundary — high bits go into long2
            return new PackedOrdinalBucketOrds(bigArrays, cardinality, maxOrds);
                int bitsInLong2 = bitsPerField[i] - bitsInLong1;
                packed |= (ordinals[i] >>> bitsInLong1);
        assert ordinals.length == numFields;
                ordinals[i] = (long2 >>> (bitOffsets[i] - splitOffset)) & fieldMasks[i];
    public static boolean fitsInTwoLongs(long[] maxOrds) {
        }
        this.numFields = maxOrds.length;
    @Override
    private final int splitOffset;
        return ordinals;
        return singleLongDelegate != null ? singleLongDelegate.bucketsInOrd(owningBucketOrd) : twoLongDelegate.size();
            }
            this.splitOffset = 63;
        return packed;
            this.twoLongDelegate = null;
    }
            };
        }
     */
    /** Minimum bits to represent values in {@code [0, maxOrd)}. Returns 0 for maxOrd ≤ 0. */
                packed |= ((ordinals[i] & mask) << bitOffsets[i]);
        long packed = 0;
    private final LongKeyedBucketOrds singleLongDelegate;
            } else if (bitOffsets[i] < splitOffset) {
    public BucketOrdsEnum ordsEnum(long owningBucketOrd) {
     * <ul>
                // field straddles the boundary — low bits go into long1
}
        int total = 0;
    }
 * Fields are packed contiguously by insertion order, each assigned a bit width
package org.opensearch.search.aggregations.bucket.terms;
        }
        if (singleLongDelegate != null) {
        this.bitOffsets = new int[numFields];
            total += bitsRequired(maxOrd);
    public PackedOrdinalBucketOrds(BigArrays bigArrays, CardinalityUpperBound cardinality, long[] maxOrds) {
    long packLong2(long[] ordinals) {
     *       {@code cardinality == ONE} — {@link LongLongHash} has no owning-bucket concept, so it is
        if (totalBits <= 63) {
                }
    public long bucketsInOrd(long owningBucketOrd) {
                // field is entirely in long2
            } else if (bitOffsets[i] >= splitOffset) {
     * callers stay agnostic of the packing layout:
                    ord++;
    int totalBits() {
    }
            } else if (bitOffsets[i] + bitsPerField[i] > splitOffset) {
import org.opensearch.common.util.LongLongHash;
    }
        }
        this.bitsPerField = new int[numFields];
                ordinals[i] = (long1 >>> bitOffsets[i]) & fieldMasks[i];
        }
        if (maxOrd <= 0) {
                public long[] ordinals() {
    @Override
    }
                return false;
    static int bitsRequired(long maxOrd) {
                @Override
            // else: field is entirely in long1
        assert ordinals.length == numFields;
    private final int numFields;
import org.opensearch.search.aggregations.CardinalityUpperBound;
        }
    /** Package-private for testing. */
        for (int i = 0; i < numFields; i++) {
    private final long[] fieldMasks;
        } else {
        for (int i = 0; i < numFields; i++) {
 * derived from its global ordinal count.
    /** Package-private for testing. */
            this.singleLongDelegate = null;
 * this file be licensed under the Apache-2.0 license or a
                    return ord < twoLongDelegate.size();
        }
                private long ord = -1;
    public void close() {
            return 0;
public class PackedOrdinalBucketOrds implements MultiTermsBucketOrds {
                ordinals[i] = (highBits << bitsInLong1) | lowBits;
                @Override
            if (total > 126) {
                @Override
            total += bitsRequired(maxOrd);
            if (bitOffsets[i] >= splitOffset) {
    /** Bit boundary between long1 and long2 in the two-long path. */
 */
                int bitsInLong1 = splitOffset - bitOffsets[i];
        if (fitsInTwoLongs(maxOrds) && cardinality == CardinalityUpperBound.ONE) {
        int total = 0;
                long mask = (1L << bitsInLong1) - 1;
                public long ord() {
                    return inner.ord();
        for (long maxOrd : maxOrds) {
     *       unsafe under nested aggregations;</li>
    /** True if all fields fit in two longs (≤126 total bits). */
                    return inner.next();
        return null;
                packed |= (ordinals[i] << bitOffsets[i]);
                }
                }
                // field fits entirely in long1
    public long add(long owningBucketOrd, long[] ordinals) {
            this.singleLongDelegate = LongKeyedBucketOrds.build(bigArrays, cardinality);
