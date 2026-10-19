             * [ _ _ _ _ _ _ _ _ ]
             *        and re-inserted it at the next empty slot as [ordinal=0, psl=2].  
    }  
             */
            assertEquals(encodeValue(2, 0, 2), h.getTable().get(3));  
import java.util.Map;
                    reference.put(key, (long) reference.size());  
            h.add(16);
        return (psl << 48) | (fingerprint << 32) | ordinal;
            h.add(8);  
                long key = randomLong() % (1 << 12);  // roughly ~4% unique keys
             * [ 1 2 0 _ _ _ _ _ ]
            long hash(long key) {
            final long capacity = h.getTable().size();
            assertEquals(reference.size(), h.size());
             * [ 0 _ _ _ _ _ _ _ ]
             *  
             * After: inserted [ordinal=0, psl=0] at the empty slot.
public class ReorganizingLongHashTests extends OpenSearchTestCase {  
    private static long encodeValue(long psl, long fingerprint, long ordinal) {
             * [ 1 2 0 _ _ _ _ _ ]
 */  
            assertEquals(encodeValue(2, 0, 0), h.getTable().get(2));  
            /*
    public void testRearrangement() {
 * this file be licensed under the Apache-2.0 license or a
            // Verify the behaviour of "get".
                0.6f + randomFloat() * 0.39f,  // random load factor to verify collision resolution
             *  
                if (reference.containsKey(key)) {  
            for (long idx = 0; idx < h.getTable().size(); idx++) {
             * Add key=16, hash=16, home_slot=0  
             * [ 1 0 _ _ _ _ _ _ ]
                    assertEquals(-1, h.find(key));
             * Before: empty slot.  
             * [ 1 0 _ _ _ _ _ _ ]  
            ReorganizingLongHash h = new ReorganizingLongHash(  
    public void testFuzzy() {
            }  
import org.opensearch.test.OpenSearchTestCase;
                } else {
             *
            @Override
            for (Map.Entry<Long, Long> entry : reference.entrySet()) {  
                }  
                    assertEquals(-1 - expectedOrdinal, h.add(key));
             * The ideal home slot of a key can then be defined as: (hash(key) & mask) = (key & 7).
             *
                    assertEquals((capacity + idx - homeIdx) & mask, value >>> 48);
             *   ▼  
             *
             *
        assert ordinal < (1L << 32);
             * Before: occupied slot.
                return key;  
            assertEquals(encodeValue(0, 0, 3), h.getTable().get(0));  
            for (int i = 0; i < (1 << 20); i++) {
             * [ 3 1 0 2 _ _ _ _ ]  
        assert psl < (1L << 15);
                BigArrays.NON_RECYCLING_INSTANCE  
                    final long homeIdx = h.hash(h.get((int) value)) & mask;
    }  
        try (ReorganizingLongHash h = new ReorganizingLongHash(4, 0.6f, BigArrays.NON_RECYCLING_INSTANCE) {  
             */  
             */
                    assertEquals((long) reference.get(key), h.add(key));
            assertEquals(encodeValue(0, 0, 2), h.getTable().get(1));
                randomIntBetween(1, 100),      // random capacity
            }
                    assertEquals(expectedOrdinal, h.find(key));  
             */  
             * After: inserted [ordinal=2, psl=0] at the existing slot, displaced [ordinal=0, psl=1],
             * of values in the hash table. The backing array of the hash table will have a size (8),  
            assertEquals(encodeValue(1, 0, 0), h.getTable().get(1));
        }
             *   ▼
        }
        Map<Long, Long> reference = new HashMap<>();  
/*  
 *
            assertEquals(encodeValue(0, 0, 1), h.getTable().get(0));
        ) {
                }
             *        until everything found an empty slot.
            h.add(1);  
             * After: inserted [ordinal=3, psl=0] at the existing slot, displaced [ordinal=1, psl=0]  
 * The OpenSearch Contributors require contributions made to  
                if (value != -1) {  
            final long mask = capacity - 1;  
    }
            /*  
             * i.e. nextPowerOfTwo(initialCapacity/loadFactor), so the bitmask will be (7).
            /*
                final long value = h.getTable().get(idx);
            )
             *     ▼
             *   ▼
package org.opensearch.common.util;
        try (
             *  
             *        and re-inserted it at the next best slot. Repeated this for other displaced values
            /*
             * Overriding with an "identity" hash function to make it easier to reason about the placement
            // Verify the behaviour of "add" and "find".  
                    long expectedOrdinal = reference.get(key);
            assertEquals(encodeValue(2, 0, 0), h.getTable().get(2));
            /**
}
            assertEquals(encodeValue(0, 0, 1), h.getTable().get(0));
             * Add key=8, hash=8, home_slot=0
            // Verify the behaviour of "size".
            assertEquals(encodeValue(0, 0, 0), h.getTable().get(0));
import java.util.HashMap;  
             * Add key=1, hash=1, home_slot=1
            // Verify the calculation of PSLs.
        assert fingerprint < (1L << 16);  
            h.add(0);
             * Before: occupied slot.
             * Before: occupied slot.
            }
             *
            }
             */
 * SPDX-License-Identifier: Apache-2.0
             * Add key=0, hash=0, home_slot=0
 * compatible open source license.
                assertEquals((long) entry.getKey(), h.get(entry.getValue()));
        }) {
             *        and re-inserted it at the next empty slot as [ordinal=0, psl=1].  
             * After: inserted [ordinal=1, psl=0] at the existing slot, displaced [ordinal=0, psl=0],
            assertEquals(encodeValue(1, 0, 1), h.getTable().get(1));
             * [ 0 _ _ _ _ _ _ _ ]  
