    public void testEmpty() {  
    public void testOneValue() {  
import org.opensearch.common.Numbers;
            // Convert back to long[]  
        assertEquals(Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG, set2.maxValue);  
    }
        assertEquals(set1, set2);  
        UnsignedLongHashSet set2 = new UnsignedLongHashSet(new long[] {});
        assertEquals(1, set2.size());  
        assertFalse(set1.stream().allMatch(unsignedLongHashSet::contains));  
            Set<Long> set1 = LongStream.of(values).boxed().collect(Collectors.toSet());  
            UnsignedLongHashSet set2 = new UnsignedLongHashSet(arr);
        assertEquals(1, set2.size());
        assertEquals(Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG, set2.maxValue);
            // Sort using compareUnsigned
    }
        assertEquals(42L, set2.minValue);
    public void testRandom() {
    private void assertNotEquals(Set<Long> set1, UnsignedLongHashSet unsignedLongHashSet) {
    }  
        assertEquals(1, set2.size());
            }
        assertEquals(42L, set2.maxValue);  
        set2 = new UnsignedLongHashSet(new long[] { Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG, 42L });
                    break;
            Arrays.sort(longObjects, Long::compareUnsigned);  
            while (true) {  
import java.util.stream.Collectors;
    }
            Set<Long> set3 = new HashSet<>(set1);
        }
    public void testSameValue() {
public class DocValuesUnsignedLongHashSetTests extends LuceneTestCase {
        Set<Long> set1 = new HashSet<>(Arrays.asList(42L));
import java.util.Arrays;
        if (set1.isEmpty() == false) {  
        assertTrue(set1.stream().allMatch(unsignedLongHashSet::contains));
                    values[i] = random().nextLong();
        assertEquals(2, set2.size());
}
 * compatible open source license.
        assertEquals(Long.MIN_VALUE, set2.minValue);  
            }  
        }  
        UnsignedLongHashSet set3 = new UnsignedLongHashSet(  
                    values[i] = values[random().nextInt(i)];  
        Set<Long> set2 = unsignedLongHashSet.stream().boxed().collect(Collectors.toSet());  
            Long[] longObjects = Arrays.stream(values).boxed().toArray(Long[]::new);
    }
        Set<Long> set2 = unsignedLongHashSet.stream().boxed().collect(Collectors.toSet());
        assertEquals(set1, set2);
        final int iters = atLeast(10);
                long next = random().nextLong();
 */
                    assertFalse(unsignedLongHashSet.contains(next));  
        assertEquals(1, set2.size());
                }
            for (int i = 0; i < values.length; ++i) {
        assertEquals(set1.size(), unsignedLongHashSet.size());
        assertEquals(set1, set2);  
    }
 *
        assertEquals(42, set2.maxValue);
import java.util.stream.LongStream;
package org.opensearch.lucene.util;  
            }
            assertEquals(set1, set2);
                arr[i] = longObjects[i];
    public void testSameMissingPlaceholder() {  
        UnsignedLongHashSet set2 = new UnsignedLongHashSet(new long[] { 42L, Numbers.MAX_UNSIGNED_LONG_VALUE_AS_LONG });  
        LuceneTestCase.assertNotEquals(set2, set3.stream().boxed().collect(Collectors.toSet()));
        set1 = new HashSet<>(Arrays.asList(Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG));
                }
        set1 = new HashSet<>(Arrays.asList(Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG, 42L));  
 * The OpenSearch Contributors require contributions made to
        Set<Long> set1 = new HashSet<>();
        UnsignedLongHashSet set2 = new UnsignedLongHashSet(new long[] { Long.MIN_VALUE, Long.MIN_VALUE });
 * this file be licensed under the Apache-2.0 license or a  
        for (int iter = 0; iter < iters; ++iter) {  
            if (values.length > 0 && random().nextBoolean()) {  
        assertEquals(0, set2.size());  
        UnsignedLongHashSet set2 = new UnsignedLongHashSet(new long[] { 42L, 42L });  
        assertEquals(set1, set2);
        assertEquals(Numbers.MAX_UNSIGNED_LONG_VALUE_AS_LONG, set2.maxValue);  
    }
        assertEquals(Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG, set2.minValue);
    private void assertEquals(Set<Long> set1, UnsignedLongHashSet unsignedLongHashSet) {  
    public void testTwoValues() {
                if (i == 0 || random().nextInt(10) < 9) {  
import org.apache.lucene.tests.util.LuceneTestCase;
        assertEquals(set1, set2);
            }  
                values[values.length / 2] = Long.MIN_VALUE;
        assertEquals(42L, set2.minValue);
        assertEquals(42L, set2.maxValue);
            long removed = set3.iterator().next();
import java.util.HashSet;
        assertEquals(42, set2.minValue);
            set1.stream().sorted(Long::compareUnsigned).mapToLong(Long::longValue).toArray()
        assertEquals(Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG, set2.minValue);  
                } else {
import java.util.Set;  
            long[] arr = new long[values.length];
 * SPDX-License-Identifier: Apache-2.0  
                if (next != removed && set3.add(next)) {
        assertEquals(Long.MIN_VALUE, set2.maxValue);
        assertEquals(Numbers.MAX_UNSIGNED_LONG_VALUE_AS_LONG, set2.minValue);
        );
        assertEquals(2, set2.size());
            long[] values = new long[random().nextInt(1 << random().nextInt(16))];
/*
        set2 = new UnsignedLongHashSet(new long[] { Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG });  
        UnsignedLongHashSet set2 = new UnsignedLongHashSet(new long[] { 42L });
        Set<Long> set1 = new HashSet<>(Arrays.asList(42L, Numbers.MAX_UNSIGNED_LONG_VALUE_AS_LONG));
            assertNotEquals(set3, unsignedLongHashSet);
        LuceneTestCase.assertEquals(set1, set2);
            for (int i = 0; i < arr.length; i++) {
    }
        LuceneTestCase.assertNotEquals(set1, set2);
