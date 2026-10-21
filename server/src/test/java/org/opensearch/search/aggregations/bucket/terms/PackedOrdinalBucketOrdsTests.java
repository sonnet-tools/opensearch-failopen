        return false;
            }
            assertTrue(bucketOrd2 >= 0);
        for (long[] item : list) {
    public void testFitsInTwoLongs() {
        assertNull(PackedOrdinalBucketOrds.create(bigArrays, CardinalityUpperBound.ONE, maxOrds));
            assertTrue(ords.isSingleLongPath());
            assertArrayEquals(ordinals, unpacked);
        assertTrue(PackedOrdinalBucketOrds.fitsInTwoLongs(new long[] { 1000, 1000 }));
            assertEquals(2, ords.size());
    }
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
            long[] ordinals2 = { 100, 200, 300 };
        assertFalse(PackedOrdinalBucketOrds.fitsInTwoLongs(new long[] { 1L << 43, 1L << 43, 1L << 43 }));
    }
            long bucketOrd2 = ords.add(0, ordinals2);
        // Verify that LongKeyedBucketOrds (single-long path) correctly partitions by owningBucketOrd.
            assertNotNull("single-long tuples must use the ordinal path under MANY", ords);
        assertEquals(2, PackedOrdinalBucketOrds.bitsRequired(3)); // [0,3) needs 2 bits
            long[] unpacked = ords.unpackSingleLong(packed);
    /** Helper: check if a list of long[] contains an array with matching content. */
        assertEquals(30, PackedOrdinalBucketOrds.bitsRequired(1L << 30));
            assertArrayEquals(ordinals, unpacked);
            if (Arrays.equals(item, target)) {
            long[] ordinals = { (1L << 39), (1L << 39), (1L << 39) };
            long[] unpacked = ords.unpackTwoLongs(long1, long2);
        // single-long path is selected even for MANY (nested) aggregations — not just for ONE.
            assertTrue(ords.isSingleLongPath());
                retrieved.add(ordsEnum.ordinals());
            MultiTermsBucketOrds.BucketOrdsEnum ordsEnum = ords.ordsEnum(0);
            long long1 = ords.packLong1(ordinals);
            assertEquals(-1 - bucketOrd1, bucketOrd3);
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
    public void testManyFieldsSingleLong() {
    private static boolean containsArray(List<long[]> list, long[] target) {
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
 * this file be licensed under the Apache-2.0 license or a
    private BigArrays bigArrays;
        }
            long packed = ords.packSingleLong(ordinals);
        }
    public void testAddAndRetrieveSingleLong() {
            List<long[]> retrieved = new ArrayList<>();
    }
            long id0C = ords.add(0, ordsC);
    }
import org.opensearch.common.util.MockPageCacheRecycler;
            long long2 = ords.packLong2(ordinals);
            while (ordsEnum.next()) {
    }
        long[] maxOrds = { 1000, 1000 };
        assertEquals(3, PackedOrdinalBucketOrds.bitsRequired(5)); // [0,5) needs 3 bits
import org.opensearch.search.aggregations.CardinalityUpperBound;
            assertTrue("Duplicate should return negated id", id0ADup < 0);
                return true;
        // 43 bits × 3 = 129 bits → exceeds two-long capacity for any cardinality.
            long bucketOrd3 = ords.add(0, ordinals1); // duplicate
            assertEquals(1, ords.bucketsInOrd(1));
            assertTrue(containsArray(retrieved, ordinals2));
            assertEquals(2, retrieved.size());
 * SPDX-License-Identifier: Apache-2.0
    }
        long[] maxOrds = { 1000, 1000 };
        // 40 bits each × 3 = 120 bits total — needs two longs
            assertTrue(id1A >= 0);
    public void testAddAndRetrieveTwoLongs() {
            long[] ordinals1 = { 100, 200 };
            long long1 = ords.packLong1(ordinals);
            assertEquals(-1 - id0A, id0ADup);
        // returns null and the caller falls back to the byte-key path.
            assertTrue(bucketOrd2 >= 0);
        // 31 + 32 = 63 bits — exactly fits
        }
        }
        assertTrue(PackedOrdinalBucketOrds.fitsInSingleLong(new long[] { 1L << 31, 1L << 32 }));
    @Override
        // 32 + 32 = 64 bits — does not fit
            long bucketOrd1 = ords.add(0, ordinals1);
        }
    public void testMultipleOwningBucketsSingleLong() {
            assertFalse(ords.isSingleLongPath());
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.MANY, maxOrds)) {
    public void testSingleLongPathRoundTrip() {
            assertTrue(ords.isSingleLongPath());
            long[] ordsB = { 1, 2 }; // same ordinals but different owning bucket
        }
            long id0A = ords.add(0, ordsA);
        long[] maxOrds = { 1L << 40, 1L << 40, 1L << 40 };
        super.setUp();
            long packed = ords.packSingleLong(ordinals);
    }
        long[] maxOrds = { 1L << 40, 1L << 40, 1L << 40 };
import java.util.ArrayList;
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
        // 40 bits × 3 = 120 bits → two-long path, allowed at the top level (ONE).
public class PackedOrdinalBucketOrdsTests extends OpenSearchTestCase {
        long[] maxOrds = { 1000, 1000 };
        );
package org.opensearch.search.aggregations.bucket.terms;
        long[] maxOrds = { 10, 10, 10, 10, 10, 10 };
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
        // 3 fields at 42 bits each = 126 — exactly fits
        try (PackedOrdinalBucketOrds ords = PackedOrdinalBucketOrds.create(bigArrays, CardinalityUpperBound.MANY, maxOrds)) {
import org.opensearch.common.util.BigArrays;
            long[] ordinals = { 500, 300 };
            assertEquals(2, ords.bucketsInOrd(0));
        assertEquals(20, PackedOrdinalBucketOrds.bitsRequired(1_000_000));
            // owning bucket 0 should have 2 entries; owning bucket 1 should have 1
    public void testFitsInSingleLong() {
            assertTrue(ords.isSingleLongPath());
 * compatible open source license.
        assertEquals(0, PackedOrdinalBucketOrds.bitsRequired(0));
            long[] ordinals2 = { 300, 400 };
    }
    public void testStraddlingFieldsTwoLongs() {
            // Duplicate in same owning bucket returns negated id
            long[] unpacked = ords.unpackSingleLong(packed);
import org.opensearch.common.settings.Settings;
        // 31 + 31 + 1 = 63 bits — exactly at the boundary
import org.opensearch.test.OpenSearchTestCase;
        long[] maxOrds = { 1L << 50, 1L << 50 };
        }
            long[] ordinals = { (1L << 31) - 1, (1L << 31) - 1, 1 };
            assertFalse("64-126 bit tuples must use the two-long path", ords.isSingleLongPath());
        // Tuples fitting in a single long use LongKeyedBucketOrds, which keys by owning bucket, so the
            "two-long path must fall back under MANY cardinality",
            long id1A = ords.add(1, ordsA);
            assertEquals(63, ords.totalBits());
    }
        assertFalse(PackedOrdinalBucketOrds.fitsInSingleLong(new long[] { 1L << 32, 1L << 32 }));
            long packed = ords.packSingleLong(ordinals);
            assertTrue(bucketOrd1 >= 0);
            List<long[]> retrieved = new ArrayList<>();
    }
    public void setUp() throws Exception {
    public void testCreateReturnsNullBeyond126Bits() {
    }
import java.util.Arrays;
        long[] maxOrds = { 1L << 43, 1L << 43, 1L << 43 };
            long[] unpacked = ords.unpackTwoLongs(long1, long2);
    }
            assertTrue(containsArray(retrieved, ordinals1));
    }
        assertTrue(PackedOrdinalBucketOrds.fitsInTwoLongs(new long[] { 1L << 42, 1L << 42, 1L << 42 }));
    }
            assertNotEquals("Different owning buckets must produce independent bucket ords", id0A, id1A);
            assertTrue(id0C >= 0);
            long[] ordinals1 = { 1L << 39, 1L << 39, 1L << 39 };
            assertEquals(2, ords.bucketsInOrd(0));
            PackedOrdinalBucketOrds.create(bigArrays, CardinalityUpperBound.MANY, maxOrds)
 */
            }
        long[] maxOrds = { 1000, 1000 };
        // 6 fields at 4 bits each = 24 bits total
            long[] ordinals = { (1L << 49), (1L << 49) };
 *
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            long long2 = ords.packLong2(ordinals);
    public void testCreateTwoLongUnderOneCardinality() {
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
        assertEquals(0, PackedOrdinalBucketOrds.bitsRequired(-1));
        // 50 + 50 = 100 bits — second field straddles the 63-bit boundary
        // 3 fields at 43 bits each = 129 — does not fit
        assertTrue(PackedOrdinalBucketOrds.fitsInSingleLong(new long[] { 1000, 1000 }));
            // Same ordinals in different owning buckets must get independent IDs
    }
        assertNull(PackedOrdinalBucketOrds.create(bigArrays, CardinalityUpperBound.MANY, maxOrds));
            assertEquals(-1 - bucketOrd1, bucketOrd3);
            assertEquals(2, ords.size());
            assertEquals(2, ords.bucketsInOrd(0));
/*
            assertTrue(id0A >= 0);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
 * The OpenSearch Contributors require contributions made to
    }
            assertTrue(ords.totalBits() > 63);
    public void testBitsRequired() {
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
            assertArrayEquals(ordinals, unpacked);
            assertEquals(2, retrieved.size());
            long[] unpacked = ords.unpackSingleLong(packed);
            assertFalse(ords.isSingleLongPath());
        try (PackedOrdinalBucketOrds ords = PackedOrdinalBucketOrds.create(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
            MultiTermsBucketOrds.BucketOrdsEnum ordsEnum = ords.ordsEnum(0);
            assertNotNull(ords);
        // Same 120-bit tuples but MANY (nested): LongLongHash has no owning-bucket concept, so create()
        assertEquals(0, PackedOrdinalBucketOrds.bitsRequired(1)); // [0,1) = {0} needs 0 bits
    public void testTwoLongPathRoundTrip() {
            assertTrue(ords.isSingleLongPath());
        long[] maxOrds = { 1L << 40, 1L << 40, 1L << 40 };
        long[] maxOrds = { 1L << 40, 1L << 40, 1L << 40 };
        assertEquals(3, PackedOrdinalBucketOrds.bitsRequired(8)); // [0,8) needs 3 bits
                retrieved.add(ordsEnum.ordinals());
        assertEquals(2, PackedOrdinalBucketOrds.bitsRequired(4)); // [0,4) needs 2 bits
            long[] ordinals = { 5, 5, 5, 5, 5, 5 };
        assertNull(
        assertEquals(1, PackedOrdinalBucketOrds.bitsRequired(2)); // [0,2) = {0,1} needs 1 bit
import java.util.List;
            }
    public void testCreateTwoLongFallsBackUnderManyCardinality() {
        }
            long bucketOrd3 = ords.add(0, ordinals1); // duplicate
            long bucketOrd1 = ords.add(0, ordinals1);
            long[] ordsA = { 1, 2 };
            long bucketOrd2 = ords.add(0, ordinals2);
    public void testCreateSingleLongUsedUnderManyCardinality() {
        }
            assertArrayEquals(ordinals, unpacked);
        long[] maxOrds = { 1L << 31, 1L << 31, 1L << 1 };
        }
            assertTrue(containsArray(retrieved, ordinals2));
            assertArrayEquals(ordinals, unpacked);
    public void testBoundaryCaseSingleLong63Bits() {
            long[] ordsC = { 3, 4 };
            while (ordsEnum.next()) {
            long id0ADup = ords.add(0, ordsA);
        }
    }
}
import org.opensearch.common.util.MockBigArrays;
            assertTrue(containsArray(retrieved, ordinals1));
            assertTrue(bucketOrd1 >= 0);
