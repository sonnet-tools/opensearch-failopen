        final int endExclusive = randomIntBetween(0, 256);
 * Licensed to Elasticsearch under one or more contributor  
 *
 * software distributed under the License is distributed on an
/*  
     * @param sets         a pair of sets with elements from {@code [0, endExclusive)}  
public class SetsTests extends OpenSearchTestCase {
 * under the License.  
        assertDifference(endExclusive, sets, difference);
import static org.hamcrest.Matchers.greaterThan;  
    /**  
                assertThat(next, greaterThan(current));  
            int current = it.next();  
            .filter(i -> (sets.v1().contains(i) && sets.v2().contains(i)))  
/*  
        }  
 * not use this file except in compliance with the License.
                final int next = it.next();
    }
import static org.hamcrest.Matchers.equalTo;
        }  
        assertThat(intersection, containsInAnyOrder(expectedIntersection.toArray(new Integer[0])));
 * Unless required by applicable law or agreed to in writing,
    private Tuple<Set<Integer>, Set<Integer>> randomSets(final int endExclusive) {  
        return Tuple.tuple(left, right);  
import java.util.stream.IntStream;
        if (it.hasNext()) {
        final Set<Integer> intersection = Sets.intersection(sets.v1(), sets.v2());  
        final Tuple<Set<Integer>, Set<Integer>> sets = randomSets(endExclusive);
    public void testIntersection() {  
     * Assert the difference between two sets is as expected.  
                current = next;
            while (it.hasNext()) {
package org.opensearch.common.util.set;
    }
     */
        final Tuple<Set<Integer>, Set<Integer>> sets = randomSets(endExclusive);
import java.util.stream.Collectors;
/*
 *  
 */  
import java.util.Iterator;
 * specific language governing permissions and limitations
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.containsInAnyOrder;
            .boxed()
 * KIND, either express or implied.  See the License for the
            }
        final Set<Integer> expectedIntersection = IntStream.range(0, endExclusive)
import org.opensearch.common.collect.Tuple;
     * @param difference   the difference between the two sets
     * @return a pair of sets
        final Tuple<Set<Integer>, Set<Integer>> sets = randomSets(endExclusive);  
    public void testDifference() {
     */
    public void testSortedDifference() {
}  
 * The OpenSearch Contributors require contributions made to  
    private void assertDifference(final int endExclusive, final Tuple<Set<Integer>, Set<Integer>> sets, final Set<Integer> difference) {  
     *
 */
 * You may obtain a copy of the License at  
        final Set<Integer> difference = Sets.sortedDifference(sets.v1(), sets.v2());
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Produces two random sets consisting of elements from {@code [0, endExclusive)}.
     * @param endExclusive the exclusive upper bound of the elements of either set
 * license agreements. See the NOTICE file distributed with
            assertThat(difference.contains(i), equalTo(sets.v1().contains(i) && !sets.v2().contains(i)));
        final Set<Integer> left = new HashSet<>(randomSubsetOf(IntStream.range(0, endExclusive).boxed().collect(Collectors.toSet())));
 * compatible open source license.
import java.util.Set;  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * ownership. Elasticsearch licenses this file to you under  
        final int endExclusive = randomIntBetween(0, 256);  
            .collect(Collectors.toSet());
     *
 *
import java.util.HashSet;
        final Iterator<Integer> it = difference.iterator();
 * GitHub history for details.
        final Set<Integer> difference = Sets.difference(sets.v1(), sets.v2());
 * this work for additional information regarding copyright
     * @param endExclusive the exclusive upper bound of the elements of the sets  
        final Set<Integer> right = new HashSet<>(randomSubsetOf(IntStream.range(0, endExclusive).boxed().collect(Collectors.toSet())));
    }  
        for (int i = 0; i < endExclusive; i++) {
import org.opensearch.test.OpenSearchTestCase;
        assertDifference(endExclusive, sets, difference);  
    }
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
        final int endExclusive = randomIntBetween(0, 256);
    /**
