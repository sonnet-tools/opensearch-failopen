    @Override
import org.opensearch.common.util.BigArrays;
    static int bitsRequired(long maxOrd) {
        return true;  
                @Override  
        for (int i = 0; i < numFields; i++) {
            this.splitOffset = 63;  
            this.singleLongDelegate = LongKeyedBucketOrds.build(bigArrays, cardinality);  
import org.opensearch.common.lease.Releasables;
                ordinals[i] = (highBits << bitsInLong1) | lowBits;
                packed |= (ordinals[i] << bitOffsets[i]);  
            // else: field is entirely in long1
        if (totalBits <= 63) {
    private final int[] bitsPerField;
                return false;  
 * @opensearch.internal
            this.splitOffset = 0;
    @Override
            }
    private final int numFields;  
                    return unpackSingleLong(inner.value());
                    return unpackTwoLongs(twoLongDelegate.getKey1(ord), twoLongDelegate.getKey2(ord));  
            } else if (bitOffsets[i] + bitsPerField[i] > splitOffset) {  
    long packLong2(long[] ordinals) {  
        return packed;  
    public long bucketsInOrd(long owningBucketOrd) {
        for (int i = 0; i < numFields; i++) {
        return singleLongDelegate != null ? singleLongDelegate.bucketsInOrd(owningBucketOrd) : twoLongDelegate.size();  
        for (int i = 0; i < numFields; i++) {
    public static boolean fitsInSingleLong(long[] maxOrds) {
                private long ord = -1;  
        return packed;
 * The OpenSearch Contributors require contributions made to  
    }
    int totalBits() {  
        return singleLongDelegate != null;  
    /** Bit boundary between long1 and long2 in the two-long path. */
    public static PackedOrdinalBucketOrds create(BigArrays bigArrays, CardinalityUpperBound cardinality, long[] maxOrds) {
            return new BucketOrdsEnum() {  
            if (total > 126) {
                long lowBits = (long1 >>> bitOffsets[i]) & ((1L << bitsInLong1) - 1);
            return singleLongDelegate.add(owningBucketOrd, packSingleLong(ordinals));  
        this.numFields = maxOrds.length;
     *   <li>64–126 total bits → two-long path ({@link LongLongHash}), only when
        long[] ordinals = new long[numFields];
        this.bitsPerField = new int[numFields];  
 * two-long path (64–126 bits) uses {@link LongLongHash}.
package org.opensearch.search.aggregations.bucket.terms;
    private final int splitOffset;
            }
            return new PackedOrdinalBucketOrds(bigArrays, cardinality, maxOrds);  
            return new BucketOrdsEnum() {
            } else if (bitOffsets[i] < splitOffset) {
                ordinals[i] = (long2 >>> (bitOffsets[i] - splitOffset)) & fieldMasks[i];
            total += bitsPerField[i];  
            total += bitsRequired(maxOrd);
            }
            }  
        }  
        return ordinals;
            return 0;
     *   <li>&gt;126 total bits → {@code null} (fall back).</li>
                packed |= ((ordinals[i] & mask) << bitOffsets[i]);
        if (maxOrd <= 0) {  
        return true;  
            }  
            if (bitOffsets[i] + bitsPerField[i] <= splitOffset) {
    /**  
                int bitsInLong1 = splitOffset - bitOffsets[i];
        }
        assert totalBits <= 126 : "total bits " + totalBits + " exceeds 126";  
            this.twoLongDelegate = new LongLongHash(2, bigArrays);
                // field is entirely in long2
 */  
        long[] ordinals = new long[numFields];  
public class PackedOrdinalBucketOrds implements MultiTermsBucketOrds {
                long mask = (1L << bitsInLong1) - 1;
            } else {
    @Override  
                }
        return packed;
    private final int[] bitOffsets;
                long highBits = long2 & ((1L << bitsInLong2) - 1);
        this.bitOffsets = new int[numFields];
     * returns {@code null} when the ordinals cannot be packed for this aggregation and the caller
    public long add(long owningBucketOrd, long[] ordinals) {  
    private final long[] fieldMasks;  
    long[] unpackTwoLongs(long long1, long long2) {
            this.twoLongDelegate = null;
     * <ul>
        long packed = 0;
 * this file be licensed under the Apache-2.0 license or a
    @Override
        int total = 0;
 */  
            bitOffsets[i] = total;
    @Override  
        }  
                    return ord;
    public void close() {
 * Single-long path (≤63 bits) uses {@link LongKeyedBucketOrds};  
                // field straddles the boundary — high bits go into long2
     * must fall back to the byte-key path. The single-vs-two-long decision lives entirely here so  
     */  
                @Override
                ordinals[i] = (long1 >>> bitOffsets[i]) & fieldMasks[i];
                packed |= (ordinals[i] >>> bitsInLong1);  
                @Override
        return Long.SIZE - Long.numberOfLeadingZeros(maxOrd - 1);  
                }
                int bitsInLong1 = splitOffset - bitOffsets[i];
     *       unsafe under nested aggregations;</li>  
    /** Minimum bits to represent values in {@code [0, maxOrd)}. Returns 0 for maxOrd ≤ 0. */
        this.fieldMasks = new long[numFields];
        for (int i = 0; i < numFields; i++) {  
        }
                return false;  
    /** True if all fields fit in a single long (≤63 total bits). */  
                public long[] ordinals() {  
 * compatible open source license.
        return singleLongDelegate != null ? singleLongDelegate.size() : twoLongDelegate.size();
                    return ord < twoLongDelegate.size();
        }
    }
        } else {  
        return totalBits;
        }
 * SPDX-License-Identifier: Apache-2.0
                }  
        if (fitsInSingleLong(maxOrds)) {
    /** Package-private for testing. */
        assert ordinals.length == numFields;
 * {@link MultiTermsBucketOrds} that packs N field ordinals into one or two {@code long}
    long[] unpackSingleLong(long packed) {
    boolean isSingleLongPath() {
        assert ordinals.length == numFields;  
            return twoLongDelegate.add(packLong1(ordinals), packLong2(ordinals));  
        Releasables.close(singleLongDelegate, twoLongDelegate);
 * Fields are packed contiguously by insertion order, each assigned a bit width
     *   <li>≤63 total bits → single-long path ({@link LongKeyedBucketOrds}), for any cardinality;</li>  
    long packSingleLong(long[] ordinals) {
 *
            this.singleLongDelegate = null;
    }
            if (bitOffsets[i] + bitsPerField[i] <= splitOffset) {
import org.opensearch.common.util.LongLongHash;  
            // else: field is entirely in long2
                }
                public long[] ordinals() {
                    return inner.next();  
                int bitsInLong1 = splitOffset - bitOffsets[i];  
    }
        this.totalBits = total;
    public BucketOrdsEnum ordsEnum(long owningBucketOrd) {  
                // field straddles the boundary  
                int bitsInLong2 = bitsPerField[i] - bitsInLong1;  
    }
        }  
 * derived from its global ordinal count.  
                @Override
        for (int i = 0; i < numFields; i++) {  
            } else if (bitOffsets[i] >= splitOffset) {  
                // field fits entirely in long1
        if (singleLongDelegate != null) {
    public PackedOrdinalBucketOrds(BigArrays bigArrays, CardinalityUpperBound cardinality, long[] maxOrds) {
        if (singleLongDelegate != null) {
            if (bitOffsets[i] >= splitOffset) {  
        for (int i = 0; i < numFields; i++) {
        }
        } else {
 * values, avoiding {@link org.apache.lucene.util.BytesRef} serialization entirely.
     * </ul>
            fieldMasks[i] = (1L << bitsPerField[i]) - 1;
    }
                    ord++;
        int total = 0;
    }  
    }
                public boolean next() {
     * callers stay agnostic of the packing layout:
                // field straddles the boundary — low bits go into long1
                public boolean next() {  
            ordinals[i] = (packed >>> bitOffsets[i]) & fieldMasks[i];
    private final int totalBits;
    long packLong1(long[] ordinals) {
                }
            };  
                }  
        }
/**  
    }  
        }
        int total = 0;
    /** True if all fields fit in two longs (≤126 total bits). */  
    }
                packed |= (ordinals[i] << (bitOffsets[i] - splitOffset));
            return new PackedOrdinalBucketOrds(bigArrays, cardinality, maxOrds);  
            LongKeyedBucketOrds.BucketOrdsEnum inner = singleLongDelegate.ordsEnum(owningBucketOrd);
        long packed = 0;
import org.opensearch.search.aggregations.CardinalityUpperBound;
    }
    private final LongKeyedBucketOrds singleLongDelegate;
                public long ord() {  
        }
    }  
        if (fitsInTwoLongs(maxOrds) && cardinality == CardinalityUpperBound.ONE) {
    public long size() {
        for (long maxOrd : maxOrds) {  
        }
            assert owningBucketOrd == 0 : "two-long path only supports single owning bucket";
        long packed = 0;
        }
        return null;
    public static boolean fitsInTwoLongs(long[] maxOrds) {
        } else {
    }
    }
        for (long maxOrd : maxOrds) {  
            bitsPerField[i] = bitsRequired(maxOrds[i]);  
    /** Package-private for testing. */
        }
    private final LongLongHash twoLongDelegate;  
        return ordinals;
 *
            total += bitsRequired(maxOrd);
            };
/*  
    }  
                @Override
            packed |= (ordinals[i] << bitOffsets[i]);  
    }
     *       {@code cardinality == ONE} — {@link LongLongHash} has no owning-bucket concept, so it is
            if (total > 63) {
     * Builds a packed-ordinal bucket store for the given per-field global-ordinal counts, or
    }  
                @Override
                    return inner.ord();
                public long ord() {
}
