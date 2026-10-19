        assertNull(
            assertEquals(2, ords.bucketsInOrd(0));
            assertEquals(-1 - bucketOrd1, bucketOrd3);
            assertEquals(2, ords.bucketsInOrd(0));
            long long1 = ords.packLong1(ordinals);
        long[] maxOrds = { 10, 10, 10, 10, 10, 10 };  
            assertTrue(containsArray(retrieved, ordinals2));
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        assertTrue(PackedOrdinalBucketOrds.fitsInTwoLongs(new long[] { 1000, 1000 }));  
        assertEquals(0, PackedOrdinalBucketOrds.bitsRequired(1)); // [0,1) = {0} needs 0 bits
            while (ordsEnum.next()) {
        // Tuples fitting in a single long use LongKeyedBucketOrds, which keys by owning bucket, so the
        long[] maxOrds = { 1L << 40, 1L << 40, 1L << 40 };  
    public void testTwoLongPathRoundTrip() {
        assertEquals(0, PackedOrdinalBucketOrds.bitsRequired(-1));
            MultiTermsBucketOrds.BucketOrdsEnum ordsEnum = ords.ordsEnum(0);
    }  
    public void setUp() throws Exception {  
        // 31 + 31 + 1 = 63 bits — exactly at the boundary
                return true;
    }
        }  
    /** Helper: check if a list of long[] contains an array with matching content. */  
            long[] unpacked = ords.unpackSingleLong(packed);  
    }  
            long long2 = ords.packLong2(ordinals);
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
    }
        assertTrue(PackedOrdinalBucketOrds.fitsInSingleLong(new long[] { 1L << 31, 1L << 32 }));  
        }  
    }
    }
        }  
        assertTrue(PackedOrdinalBucketOrds.fitsInSingleLong(new long[] { 1000, 1000 }));
    public void testAddAndRetrieveSingleLong() {
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            assertTrue(bucketOrd1 >= 0);  
                retrieved.add(ordsEnum.ordinals());
    public void testFitsInTwoLongs() {
            assertTrue(ords.totalBits() > 63);  
        assertTrue(PackedOrdinalBucketOrds.fitsInTwoLongs(new long[] { 1L << 42, 1L << 42, 1L << 42 }));
            long id0C = ords.add(0, ordsC);
    }  
            while (ordsEnum.next()) {  
    public void testMultipleOwningBucketsSingleLong() {
            assertArrayEquals(ordinals, unpacked);
            assertNotNull("single-long tuples must use the ordinal path under MANY", ords);
            long id0A = ords.add(0, ordsA);  
            long[] unpacked = ords.unpackSingleLong(packed);
        long[] maxOrds = { 1000, 1000 };
        assertEquals(1, PackedOrdinalBucketOrds.bitsRequired(2)); // [0,2) = {0,1} needs 1 bit  
            assertArrayEquals(ordinals, unpacked);  
            PackedOrdinalBucketOrds.create(bigArrays, CardinalityUpperBound.MANY, maxOrds)
    private BigArrays bigArrays;  
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {  
package org.opensearch.search.aggregations.bucket.terms;
        long[] maxOrds = { 1L << 43, 1L << 43, 1L << 43 };
            assertFalse(ords.isSingleLongPath());
        );
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(PackedOrdinalBucketOrds.fitsInSingleLong(new long[] { 1L << 32, 1L << 32 }));
            assertEquals(2, ords.bucketsInOrd(0));  
        // 40 bits × 3 = 120 bits → two-long path, allowed at the top level (ONE).
                retrieved.add(ordsEnum.ordinals());
            long bucketOrd1 = ords.add(0, ordinals1);
        }
            long bucketOrd1 = ords.add(0, ordinals1);  
        long[] maxOrds = { 1000, 1000 };
            assertEquals(1, ords.bucketsInOrd(1));
            assertEquals(2, retrieved.size());  
import org.opensearch.common.util.MockPageCacheRecycler;
            long long1 = ords.packLong1(ordinals);  
 * compatible open source license.
        assertNull(PackedOrdinalBucketOrds.create(bigArrays, CardinalityUpperBound.ONE, maxOrds));
            assertTrue(ords.isSingleLongPath());
        long[] maxOrds = { 1L << 31, 1L << 31, 1L << 1 };  
import java.util.List;
            assertEquals(63, ords.totalBits());  
    }
        // 31 + 32 = 63 bits — exactly fits
        }
            "two-long path must fall back under MANY cardinality",  
            long[] ordinals = { (1L << 49), (1L << 49) };  
            long[] ordsB = { 1, 2 }; // same ordinals but different owning bucket  
            assertTrue("Duplicate should return negated id", id0ADup < 0);  
            long[] unpacked = ords.unpackTwoLongs(long1, long2);  
            MultiTermsBucketOrds.BucketOrdsEnum ordsEnum = ords.ordsEnum(0);
            assertTrue(ords.isSingleLongPath());  
        }  
import java.util.Arrays;
            long id1A = ords.add(1, ordsA);
        try (PackedOrdinalBucketOrds ords = PackedOrdinalBucketOrds.create(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
        // 6 fields at 4 bits each = 24 bits total
    }
        // returns null and the caller falls back to the byte-key path.  
            long[] ordinals2 = { 100, 200, 300 };
            assertTrue(id0A >= 0);  
        // 3 fields at 42 bits each = 126 — exactly fits
        assertEquals(30, PackedOrdinalBucketOrds.bitsRequired(1L << 30));  
    }
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
        long[] maxOrds = { 1L << 40, 1L << 40, 1L << 40 };  
            long[] unpacked = ords.unpackTwoLongs(long1, long2);
        // single-long path is selected even for MANY (nested) aggregations — not just for ONE.
            if (Arrays.equals(item, target)) {  
    }
        assertEquals(20, PackedOrdinalBucketOrds.bitsRequired(1_000_000));
        long[] maxOrds = { 1L << 40, 1L << 40, 1L << 40 };
    public void testCreateTwoLongFallsBackUnderManyCardinality() {
    }  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
        // 3 fields at 43 bits each = 129 — does not fit  
            long[] ordinals = { (1L << 39), (1L << 39), (1L << 39) };
        // 43 bits × 3 = 129 bits → exceeds two-long capacity for any cardinality.  
            long[] ordinals = { 500, 300 };  
            assertArrayEquals(ordinals, unpacked);
            long[] ordinals = { 5, 5, 5, 5, 5, 5 };
            assertTrue(ords.isSingleLongPath());  
import java.util.ArrayList;  
        // 40 bits each × 3 = 120 bits total — needs two longs
            long bucketOrd3 = ords.add(0, ordinals1); // duplicate
            assertFalse("64-126 bit tuples must use the two-long path", ords.isSingleLongPath());  
            List<long[]> retrieved = new ArrayList<>();
    public void testCreateSingleLongUsedUnderManyCardinality() {  
            // Duplicate in same owning bucket returns negated id
        }
            assertArrayEquals(ordinals, unpacked);
/*  
            assertEquals(2, retrieved.size());
        }
    private static boolean containsArray(List<long[]> list, long[] target) {
            assertTrue(containsArray(retrieved, ordinals1));
import org.opensearch.common.util.MockBigArrays;  
import org.opensearch.common.settings.Settings;
            assertTrue(bucketOrd2 >= 0);
public class PackedOrdinalBucketOrdsTests extends OpenSearchTestCase {
        assertFalse(PackedOrdinalBucketOrds.fitsInTwoLongs(new long[] { 1L << 43, 1L << 43, 1L << 43 }));
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
            long id0ADup = ords.add(0, ordsA);
    public void testAddAndRetrieveTwoLongs() {  
            }  
            long[] ordsA = { 1, 2 };
            assertNotEquals("Different owning buckets must produce independent bucket ords", id0A, id1A);
        for (long[] item : list) {
        return false;
 * this file be licensed under the Apache-2.0 license or a
            }
    }
            long bucketOrd3 = ords.add(0, ordinals1); // duplicate
            // Same ordinals in different owning buckets must get independent IDs
            long packed = ords.packSingleLong(ordinals);  
            assertEquals(2, ords.size());
            assertTrue(containsArray(retrieved, ordinals2));  
            assertEquals(-1 - id0A, id0ADup);
    }
            long[] ordinals2 = { 300, 400 };  
        // 50 + 50 = 100 bits — second field straddles the 63-bit boundary
 */  
            assertTrue(containsArray(retrieved, ordinals1));
        try (PackedOrdinalBucketOrds ords = PackedOrdinalBucketOrds.create(bigArrays, CardinalityUpperBound.MANY, maxOrds)) {
    }
        }
    public void testFitsInSingleLong() {  
    public void testSingleLongPathRoundTrip() {
            long[] ordinals1 = { 1L << 39, 1L << 39, 1L << 39 };  
}  
    public void testCreateTwoLongUnderOneCardinality() {
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {
        super.setUp();
            // owning bucket 0 should have 2 entries; owning bucket 1 should have 1  
        assertEquals(2, PackedOrdinalBucketOrds.bitsRequired(4)); // [0,4) needs 2 bits
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.MANY, maxOrds)) {
            assertNotNull(ords);
    public void testCreateReturnsNullBeyond126Bits() {
        long[] maxOrds = { 1000, 1000 };  
            }
            long[] ordinals = { (1L << 31) - 1, (1L << 31) - 1, 1 };
        // Same 120-bit tuples but MANY (nested): LongLongHash has no owning-bucket concept, so create()
            long bucketOrd2 = ords.add(0, ordinals2);
    }
            assertEquals(2, ords.size());
        long[] maxOrds = { 1000, 1000 };  
        assertNull(PackedOrdinalBucketOrds.create(bigArrays, CardinalityUpperBound.MANY, maxOrds));  
            assertTrue(id0C >= 0);
        assertEquals(2, PackedOrdinalBucketOrds.bitsRequired(3)); // [0,3) needs 2 bits
            assertTrue(bucketOrd2 >= 0);
            assertArrayEquals(ordinals, unpacked);  
    @Override
            long long2 = ords.packLong2(ordinals);
            assertEquals(-1 - bucketOrd1, bucketOrd3);  
            long[] ordinals1 = { 100, 200 };
        assertEquals(3, PackedOrdinalBucketOrds.bitsRequired(8)); // [0,8) needs 3 bits
    }  
        long[] maxOrds = { 1L << 50, 1L << 50 };
        }
    public void testManyFieldsSingleLong() {
            assertTrue(ords.isSingleLongPath());
        assertEquals(3, PackedOrdinalBucketOrds.bitsRequired(5)); // [0,5) needs 3 bits  
            long packed = ords.packSingleLong(ordinals);
            List<long[]> retrieved = new ArrayList<>();  
            assertFalse(ords.isSingleLongPath());
            long bucketOrd2 = ords.add(0, ordinals2);  
import org.opensearch.common.util.BigArrays;
        try (PackedOrdinalBucketOrds ords = new PackedOrdinalBucketOrds(bigArrays, CardinalityUpperBound.ONE, maxOrds)) {  
    public void testBitsRequired() {
        // Verify that LongKeyedBucketOrds (single-long path) correctly partitions by owningBucketOrd.  
            assertTrue(ords.isSingleLongPath());
        }
            assertTrue(bucketOrd1 >= 0);
    public void testStraddlingFieldsTwoLongs() {  
        assertEquals(0, PackedOrdinalBucketOrds.bitsRequired(0));  
            long[] ordsC = { 3, 4 };
        long[] maxOrds = { 1L << 40, 1L << 40, 1L << 40 };
    public void testBoundaryCaseSingleLong63Bits() {
            assertTrue(id1A >= 0);
            long packed = ords.packSingleLong(ordinals);
 * The OpenSearch Contributors require contributions made to  
        // 32 + 32 = 64 bits — does not fit
 * SPDX-License-Identifier: Apache-2.0
 *
            long[] unpacked = ords.unpackSingleLong(packed);
