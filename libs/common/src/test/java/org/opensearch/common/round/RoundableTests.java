    public void testRoundingSmallArray() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> RoundableFactory.create(new long[0], 0));  
 * SPDX-License-Identifier: Apache-2.0
            // Index of the expected round-down point.
    private void assertRounding(Roundable roundable, long[] values, int size) {
        int size = randomIntBetween(1, 64);
        }  
        long[] values = randomArrayOfSortedValues(size);  
package org.opensearch.common.round;
        for (int i = 1; i < size; i++) {
            // Value of the expected round-down point.
            long delta = (idx < size - 1) ? (values[idx + 1] - values[idx]) : 200;
import org.opensearch.test.OpenSearchTestCase;
        assertRounding(roundable, values, size);
        boolean useBtreeSearcher = "forced".equalsIgnoreCase(System.getProperty("opensearch.experimental.feature.simd.rounding.enabled"));  
        assertEquals("key must be greater than or equal to " + values[0], throwable.getMessage());  
    }
        assertEquals("BidirectionalLinearSearcher", roundable.getClass().getSimpleName());  
        return values;
 * this file be licensed under the Apache-2.0 license or a
/*  
        }  
        int capacity = size + randomInt(20); // May be slightly more than the size.
 *
        assertEquals(useBtreeSearcher ? "BtreeSearcher" : "BinarySearcher", roundable.getClass().getSimpleName());
            long key = expected + (randomNonNegativeLong() % delta);  
        Roundable roundable = RoundableFactory.create(values, size);
        assertRounding(roundable, values, size);
        Throwable throwable = assertThrows(AssertionError.class, () -> roundable.floor(values[0] - 1));
    public void testRoundingLargeArray() {
    }  
}
        Roundable roundable = RoundableFactory.create(values, size);
    public void testRoundingEmptyArray() {
    }
            long expected = values[idx];
    }
        int size = randomIntBetween(65, 256);
public class RoundableTests extends OpenSearchTestCase {  
            // Adding a random delta between 0 (inclusive) and delta (exclusive) to the expected
    }  
 * compatible open source license.
            assertEquals(expected, roundable.floor(key));
            // Delta between the expected and the next round-down point.
    private static long[] randomArrayOfSortedValues(int size) {  
 */  
            int idx = randomIntBetween(0, size - 1);
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < 100000; i++) {  
        long[] values = randomArrayOfSortedValues(size);  
            // round-down point, which will still floor to the same value.
            values[i] = values[i - 1] + (randomNonNegativeLong() % 200) + 1;
        assertEquals("at least one value must be present", throwable.getMessage());
        long[] values = new long[capacity];
