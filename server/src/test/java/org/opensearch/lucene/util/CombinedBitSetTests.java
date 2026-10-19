    }
 */  
 * the Apache License, Version 2.0 (the "License"); you may
            next += 1;
 * The OpenSearch Contributors require contributions made to  
 */  
            testCase(randomIntBetween(1, 10000), percent, 0.9f);
    }
            testCase(randomIntBetween(1, 10000), percent, 0.1f);  
    }  
    }  
        for (int i = 0; i < numBitsSet; ++i) {
        for (float percent : new float[] { 0f, 0.1f, 0.5f, 0.9f, 1f }) {
 * You may obtain a copy of the License at  
        int next = 0;
 *
 * SPDX-License-Identifier: Apache-2.0
    }
            }  
    private void and(BitSet set1, BitSet set2) {  
import org.apache.lucene.util.SparseFixedBitSet;
        for (int i = 0; i < maxDoc; ++i) {
        FixedBitSet expected = new FixedBitSet(numBits);
}
    public void testDense() {
 * specific language governing permissions and limitations
/*  
 *
    private void or(BitSet set1, BitSet set2) {
        and(expected, second);  
        }
            testCase(randomIntBetween(1, 10000), randomFloat(), randomFloat());
        for (float percent : new float[] { 0f, 0.1f, 0.5f, 0.9f, 1f }) {  
 * this work for additional information regarding copyright
                if (set.get(o) == false) {
        while (next < set1.length() && (next = set1.nextSetBit(next)) != DocIdSetIterator.NO_MORE_DOCS) {
        for (float percent : new float[] { 0f, 0.1f, 0.5f, 0.9f, 1f }) {
import org.apache.lucene.search.DocIdSetIterator;
            assertEquals("Different at " + i, set1.get(i), set2.get(i));  
            assertEquals(Integer.toString(i), expected.prevSetBit(i), actual.prevSetBit(i));
    private void assertEquals(BitSet set1, BitSet set2, int maxDoc) {
        final BitSet set = randomBoolean() ? new SparseFixedBitSet(numBits) : new FixedBitSet(numBits);
            if (set2.get(next) == false) {  
        while (next < set2.length() && (next = set2.nextSetBit(next)) != DocIdSetIterator.NO_MORE_DOCS) {  
        return randomSet(numBits, (int) (percentSet * numBits));
 * Modifications Copyright OpenSearch Contributors. See
        }
        return set;
        BitSet first = randomSet(numBits, percent1);
            testCase(randomIntBetween(1, 10000), 0f, percent);
        assert numBitsSet <= numBits;  
 * KIND, either express or implied.  See the License for the
    }
    private void testCase(int numBits, float percent1, float percent2) {  
                }
    public void testEmpty() {
        or(expected, first);
    }
                    set.set(o);  
 * software distributed under the License is distributed on an
            assertEquals(expected.nextSetBit(i), actual.nextSetBit(i));
/*  
    public void testRandom() {
        for (int i = 0; i < iterations; i++) {
import org.apache.lucene.util.FixedBitSet;  
/*
            set1.set(next);
        assertEquals(expected, actual, numBits);
    }
        int iterations = atLeast(10);  
 * this file be licensed under the Apache-2.0 license or a
        int next = 0;
    public void testSparse() {  
        for (int i = 0; i < numBits; ++i) {  
 * Licensed to Elasticsearch under one or more contributor  
        }
 * not use this file except in compliance with the License.
 * compatible open source license.
        }
public class CombinedBitSetTests extends OpenSearchTestCase {
 * Unless required by applicable law or agreed to in writing,
        }  
 * GitHub history for details.
    }
                set1.clear(next);
            }
    private BitSet randomSet(int numBits, int numBitsSet) {
    private BitSet randomSet(int numBits, float percentSet) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
package org.opensearch.lucene.util;
        }  
                    break;
                final int o = random().nextInt(numBits);
 *  
            testCase(randomIntBetween(1, 10000), 0.9f, percent);  
        }
            assertEquals(Integer.toString(i), expected.nextClearBit(i, numBits), actual.nextClearBit(i, numBits));  
        }
 * license agreements. See the NOTICE file distributed with
            testCase(randomIntBetween(1, 10000), 0.1f, percent);
    }  
import org.opensearch.test.OpenSearchTestCase;
 */
 * under the License.  
import org.apache.lucene.util.BitSet;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        CombinedBitSet actual = new CombinedBitSet(first, second);  
        assertEquals(expected.cardinality(), actual.cardinality());
            while (true) {  
 * ownership. Elasticsearch licenses this file to you under  
            next += 1;  
            testCase(randomIntBetween(1, 10000), percent, 0f);
        BitSet second = randomSet(numBits, percent2);
