 * under the License.  
        {
        assertEquals(
        // cache): dedup must still collapse them -- equality is decided by the comparator, not by reference  
 */
/*  
            for (int i = 0; i < clone.size() - 1; ++i) {
            map.put(map, 1);
        assertDeduped(List.of(1, 1, 2, 2, 3, 3), Comparator.reverseOrder(), 3);
            for (int j = randomInt(4); j >= 0; --j) {
        // test no elements in a string array  
        CollectionUtils.ensureNoSelfReferences(null, "test with null");  
            }
                list.add(new Object());  
        assertTrue(CollectionUtils.rotate(Collections.emptyList(), randomInt()).isEmpty());
            Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5)),
        // test no elements in an integer array
        }
        {  
import java.util.HashSet;  
        assertTrue(CollectionUtils.isEmpty(new ArrayList<>()));
    public void testSingletonPartition() {
 * the Apache License, Version 2.0 (the "License"); you may
                assertNotEquals(cmp.compare(clone.get(i), clone.get(i + 1)), 0);
            }
            Map<Object, Object> map = new HashMap<>();
        final List<Integer> list = null;  
    }
        }  
                IllegalArgumentException.class,
package org.opensearch.common.util;
        );
        List<List<T>> types = List.of(new ArrayList<T>(array), new LinkedList<>(array));
import java.util.List;
    }
        );
    }
        assertEquals(
import java.util.Comparator;
            assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself (test with self ref value)"));
import org.opensearch.core.common.util.CollectionUtils;
    }  
 * this work for additional information regarding copyright
        assertDeduped(List.of(-1, 0, 2, 1, -1, 19, -1), Comparator.naturalOrder(), 5);
import java.util.Map;  
    public void testOversizedPartition() {
            List<Object> list = new ArrayList<>();
    public void testSimplePartition() {  
 * ownership. Elasticsearch licenses this file to you under  
        }  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
                assertEquals(list, CollectionUtils.rotate(CollectionUtils.rotate(list, distance), -distance));
        assertTrue(CollectionUtils.isEmpty(list));
 * KIND, either express or implied.  See the License for the
 *
        assertFalse(CollectionUtils.isEmpty(Collections.singletonList(5)));
/*
            eagerPartition(Arrays.asList(1, 2, 3, 4, 5), 2)  
    }
            // check content is the same  
    }  
            assertEquals(rotated.size(), list.size());
}
        // multiple consecutive duplicate runs: every run after the first previously survived because the
        for (int k = 0; k < iters; ++k) {
            final int size = randomIntBetween(1, 100);
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
        assertDeduped(List.of(2, 2, 2, 3, 3), Comparator.naturalOrder(), 2);
        assertDeduped(List.of(1000, 1000, 1000, 2000, 2000), Comparator.naturalOrder(), 2);
        // test the dedup w/ ArrayLists and LinkedLists
        // reverse comparator across multiple runs  
            Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList(4), Arrays.asList(5)),  
                () -> CollectionUtils.ensureNoSelfReferences(map, "test with self ref key")  
            // dedup the list
        assertEquals(Collections.emptyList(), eagerPartition(Collections.emptyList(), 1));  
 * Unless required by applicable law or agreed to in writing,
        }
            eagerPartition(Arrays.asList(1, 2, 3, 4, 5), 1)
            Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(7, 8, 9, 10, 11, 12)),
        );
public class CollectionUtilsTests extends OpenSearchTestCase {  
            // reverse
 * The OpenSearch Contributors require contributions made to  
            Map<String, Object> map = new HashMap<>();  
        // distinct object references that are equal by the comparator (values outside the Integer autobox
    }  
        // test unsorted array
 * license agreements. See the NOTICE file distributed with
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertDeduped(List.<Integer>of(), Comparator.naturalOrder(), 0);  
    }
            }
        assertEquals(
 *
        assertDeduped(List.of(0, 0, 1, 1), Comparator.naturalOrder(), 2);
                assertEquals(rotated, CollectionUtils.rotate(list, distance));  
            final List<Object> rotated = CollectionUtils.rotate(list, distance);
import java.util.Collections;  
 * this file be licensed under the Apache-2.0 license or a
            // verify unique elements  
import static org.opensearch.core.common.util.CollectionUtils.eagerPartition;  
 * software distributed under the License is distributed on an
 * GitHub history for details.
            final int distance = randomInt();  
                IllegalArgumentException.class,
 * You may obtain a copy of the License at  
            assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself (test with self ref key)"));
    public void testSortAndDedup() {
    }
            eagerPartition(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), 6)  
        // unsorted input with several duplicate groups
import java.util.LinkedList;
    public void testRotate() {
        CollectionUtils.ensureNoSelfReferences(emptyMap(), "test with empty map");
            assertEquals(rotated.size(), list.size());
    private <T> void assertDeduped(List<T> array, Comparator<T> cmp, int expectedLength) {  
            for (int i = 0; i < size; ++i) {
        assertDeduped(List.of(1000, 1000, 2000, 2000), Comparator.naturalOrder(), 2);
 * not use this file except in compliance with the License.
 */  
            );
        // duplicate runs followed by a trailing unique value
        // test sorted array  
            IllegalArgumentException e = expectThrows(  
            if (distance != Integer.MIN_VALUE) {  
        assertDeduped(List.of(0, 0, 1, 1, 2, 2), Comparator.naturalOrder(), 3);  
            }  
            CollectionUtils.sortAndDedup(clone, cmp);
    public void testEmptyPartition() {
 *  
            IllegalArgumentException e = expectThrows(
        assertDeduped(List.of(0, 0, 1, 1, 2), Comparator.naturalOrder(), 3);  
        for (List<T> clone : types) {  
        // last-retained value was tracked incorrectly, leaving spurious duplicates  
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(expectedLength, clone.size());
        assertEquals(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5)), eagerPartition(Arrays.asList(1, 2, 3, 4, 5), 15));  
        assertDeduped(List.of(5, 1, 5, 1, 3, 3), Comparator.naturalOrder(), 3);
import java.util.HashMap;
    public void testIsEmpty() {
import java.util.Arrays;
        assertDeduped(List.of(1, 1, 2, 3, 3, 3), Comparator.naturalOrder(), 3);
            assertEquals(new HashSet<>(rotated), new HashSet<>(list));  
    public void testEnsureNoSelfReferences() {
            // check stability
import java.util.ArrayList;
    }  
    }  
                () -> CollectionUtils.ensureNoSelfReferences(map, "test with self ref value")
        final int iters = scaledRandomIntBetween(10, 100);  
import static java.util.Collections.emptyMap;
        assertDeduped(List.<String>of(), Comparator.naturalOrder(), 0);
            );  
            map.put("field", map);
/*  
import static org.hamcrest.Matchers.containsString;
 */  
        assertDeduped(List.of(-1, 0, 1, 2, 19, 19), Comparator.naturalOrder(), 5);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testPerfectPartition() {  
 * Licensed to Elasticsearch under one or more contributor  
    public void testRotateEmpty() {
