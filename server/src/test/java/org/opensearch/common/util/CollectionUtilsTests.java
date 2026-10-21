        // test no elements in an integer array
        assertTrue(CollectionUtils.isEmpty(list));
            Map<Object, Object> map = new HashMap<>();
    public void testOversizedPartition() {
                () -> CollectionUtils.ensureNoSelfReferences(map, "test with self ref value")
    private <T> void assertDeduped(List<T> array, Comparator<T> cmp, int expectedLength) {
/*
 * Modifications Copyright OpenSearch Contributors. See
import java.util.HashSet;
public class CollectionUtilsTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
    public void testEmptyPartition() {
            assertEquals(rotated.size(), list.size());
        }
        assertDeduped(List.of(0, 0, 1, 1, 2), Comparator.naturalOrder(), 3);
 */
 *
import java.util.HashMap;
        assertDeduped(List.<Integer>of(), Comparator.naturalOrder(), 0);
 * the Apache License, Version 2.0 (the "License"); you may
            );
 *
 * The OpenSearch Contributors require contributions made to
                IllegalArgumentException.class,
            IllegalArgumentException e = expectThrows(
        assertTrue(CollectionUtils.isEmpty(new ArrayList<>()));
package org.opensearch.common.util;
import java.util.ArrayList;
    }
        // unsorted input with several duplicate groups
                IllegalArgumentException.class,
    }
import java.util.Comparator;
            // verify unique elements
        for (List<T> clone : types) {
 * specific language governing permissions and limitations
        assertDeduped(List.of(2, 2, 2, 3, 3), Comparator.naturalOrder(), 2);
        assertEquals(Collections.emptyList(), eagerPartition(Collections.emptyList(), 1));
        );
        assertDeduped(List.<String>of(), Comparator.naturalOrder(), 0);
            for (int j = randomInt(4); j >= 0; --j) {
        // last-retained value was tracked incorrectly, leaving spurious duplicates
        assertEquals(
            assertEquals(new HashSet<>(rotated), new HashSet<>(list));
 * this work for additional information regarding copyright
            assertEquals(rotated.size(), list.size());
        assertDeduped(List.of(-1, 0, 2, 1, -1, 19, -1), Comparator.naturalOrder(), 5);
        assertDeduped(List.of(1, 1, 2, 3, 3, 3), Comparator.naturalOrder(), 3);
    public void testPerfectPartition() {
        // test sorted array
    }
        assertDeduped(List.of(5, 1, 5, 1, 3, 3), Comparator.naturalOrder(), 3);
            Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(7, 8, 9, 10, 11, 12)),
        final List<Integer> list = null;
        CollectionUtils.ensureNoSelfReferences(emptyMap(), "test with empty map");
 * Licensed to Elasticsearch under one or more contributor
    public void testRotate() {
        // test the dedup w/ ArrayLists and LinkedLists
            CollectionUtils.sortAndDedup(clone, cmp);
 *
            assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself (test with self ref value)"));
        for (int k = 0; k < iters; ++k) {
        assertDeduped(List.of(-1, 0, 1, 2, 19, 19), Comparator.naturalOrder(), 5);
    public void testSortAndDedup() {
 * Unless required by applicable law or agreed to in writing,
            Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList(4), Arrays.asList(5)),
            }
            // dedup the list
        );
        // duplicate runs followed by a trailing unique value
 * license agreements. See the NOTICE file distributed with
        final int iters = scaledRandomIntBetween(10, 100);
import java.util.Collections;
        CollectionUtils.ensureNoSelfReferences(null, "test with null");
                assertEquals(list, CollectionUtils.rotate(CollectionUtils.rotate(list, distance), -distance));
 * KIND, either express or implied.  See the License for the
            // reverse
    }
    public void testIsEmpty() {
            map.put(map, 1);
                assertEquals(rotated, CollectionUtils.rotate(list, distance));
/*
            if (distance != Integer.MIN_VALUE) {
 * compatible open source license.
    public void testSingletonPartition() {
            Map<String, Object> map = new HashMap<>();
 * You may obtain a copy of the License at
 * ownership. Elasticsearch licenses this file to you under
import static org.opensearch.core.common.util.CollectionUtils.eagerPartition;
 */
import org.opensearch.core.common.util.CollectionUtils;
        assertFalse(CollectionUtils.isEmpty(Collections.singletonList(5)));
        // multiple consecutive duplicate runs: every run after the first previously survived because the
            assertEquals(expectedLength, clone.size());
            assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself (test with self ref key)"));
            );
            final int size = randomIntBetween(1, 100);
 * under the License.
        {
        assertEquals(
            eagerPartition(Arrays.asList(1, 2, 3, 4, 5), 1)
        // test no elements in a string array
        assertDeduped(List.of(1, 1, 2, 2, 3, 3), Comparator.reverseOrder(), 3);
import static org.hamcrest.Matchers.containsString;
    public void testRotateEmpty() {
        // cache): dedup must still collapse them -- equality is decided by the comparator, not by reference
                assertNotEquals(cmp.compare(clone.get(i), clone.get(i + 1)), 0);
            Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5)),
            List<Object> list = new ArrayList<>();
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
    }
            final int distance = randomInt();
        // distinct object references that are equal by the comparator (values outside the Integer autobox
        }
    }
/*
import java.util.List;
import java.util.Arrays;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(
        // test unsorted array
            eagerPartition(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), 6)
 * SPDX-License-Identifier: Apache-2.0
        assertDeduped(List.of(0, 0, 1, 1), Comparator.naturalOrder(), 2);
import java.util.Map;
            map.put("field", map);
 * GitHub history for details.
    }
}
        );
            final List<Object> rotated = CollectionUtils.rotate(list, distance);
        // reverse comparator across multiple runs
            IllegalArgumentException e = expectThrows(
 */
            // check stability
    }
            eagerPartition(Arrays.asList(1, 2, 3, 4, 5), 2)
    }
import java.util.LinkedList;
    public void testSimplePartition() {
                list.add(new Object());
        assertEquals(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5)), eagerPartition(Arrays.asList(1, 2, 3, 4, 5), 15));
    }
        assertDeduped(List.of(1000, 1000, 2000, 2000), Comparator.naturalOrder(), 2);
import static java.util.Collections.emptyMap;
        assertDeduped(List.of(1000, 1000, 1000, 2000, 2000), Comparator.naturalOrder(), 2);
                () -> CollectionUtils.ensureNoSelfReferences(map, "test with self ref key")
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(CollectionUtils.rotate(Collections.emptyList(), randomInt()).isEmpty());
        assertDeduped(List.of(0, 0, 1, 1, 2, 2), Comparator.naturalOrder(), 3);
            // check content is the same
    }
            for (int i = 0; i < size; ++i) {
        List<List<T>> types = List.of(new ArrayList<T>(array), new LinkedList<>(array));
        {
        }
        }
import org.opensearch.test.OpenSearchTestCase;
            for (int i = 0; i < clone.size() - 1; ++i) {
            }
            }
    public void testEnsureNoSelfReferences() {
            }
