                    searchFor += (bigArray.get(index + 1) - bigArray.get(index)) / 3;
import java.util.Arrays;
        double searchFor = bigArray.get(index);
        int searchFor;
                    // There is nothing below index  
 * specific language governing permissions and limitations
    private BigArrays bigArrays;  
 * Unless required by applicable law or agreed to in writing,
        }
 * SPDX-License-Identifier: Apache-2.0
        double currentValue = randomDoubleBetween(-100, 100, true);
            if (randomBoolean()) {
                    // Divide by 3 so that it's closer to array.get(index) than to array.get(index + 1)
 * GitHub history for details.
        assertEquals(Math.abs(searcherIndex - arraysIndex) <= 1, true);
        // Arrays.binarySearch always rounds down whereas BinarySearcher rounds to the closest index
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.settings.Settings;
        @Override
        BinarySearcher searcher = new IntBinarySearcher(array, searchFor);
 *     http://www.apache.org/licenses/LICENSE-2.0
        double[] array = new double[size];
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchTestCase;
            this.searchFor = searchFor;  
            bigArray.set(i, currentValue);  
        for (int i = 0; i < size; i++) {
            arraysIndex = -(arraysIndex + 1);
        Releasables.close(bigArray);
            // Arrays.binarySearch didn't find an exact match  
 * license agreements. See the NOTICE file distributed with
 *
        }
 * this work for additional information regarding copyright
                } else {  
import org.junit.Before;
    public void init() {  
        int[] array = new int[size];
        @Override  
                    searchFor -= 0.1;
            array[i] = currentValue;
        final int size = randomIntBetween(50, 10000);
public class BinarySearcherTests extends OpenSearchTestCase {  
    }
        // Pick a number to search for
        int index = randomIntBetween(0, size - 1);  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
}  
        Arrays.sort(array);
        for (int i = 0; i < size; ++i) {
    }
        BigArrays.DoubleBinarySearcher searcher = new BigArrays.DoubleBinarySearcher(bigArray);  
            this.array = array;
    public void testCompareWithArraysBinarySearch() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.common.util;
                // Pick one below array.get(index)
                    searchFor += 0.1;
        IntBinarySearcher(int[] array, int searchFor) {
        protected int compare(int index) {
import org.opensearch.common.lease.Releasables;
        return new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());  
 */  
        int searcherIndex = searcher.search(0, size - 1);  
    private BigArrays randombigArrays() {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
        assertEquals(index, searcher.search(0, size - 1, searchFor));
            return Math.abs(array[index] - searchFor);
 *  
                // Pick a number above array.get(index)
        }
        if (arraysIndex < 0) {  
            // Arrays.binarySearch didn't find an exact match
                }
/*
        int[] array;
                } else {
        int arraysIndex = Arrays.binarySearch(array, searchFor);
        }  
        if (arraysIndex < 0) {
        // Sanity check: confirm that ArrayUtils.binarySearch() returns the same index  
    }  
        DoubleArray bigArray = new BigDoubleArray(size, bigArrays, false);  
        assertEquals(Math.abs(index - arraysIndex) <= 1, true);  
 */  
        // So sometimes they will be off by 1  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
        if (randomBoolean()) {
 * You may obtain a copy of the License at  
            return Integer.compare(array[index], searchFor);
 */
    }  
 * software distributed under the License is distributed on an
        // Fill array with sorted values  
        bigArrays = randombigArrays();
                }  
 *
        }  
        int arraysIndex = Arrays.binarySearch(array, searchFor);
        int size = randomIntBetween(30, 10000);  
 * The OpenSearch Contributors require contributions made to  
        int searchFor = randomInt();  
            array[i] = randomInt();  
            currentValue += randomDoubleBetween(0, 30, false);
 * not use this file except in compliance with the License.
                    // There is nothing about index
    @Before
 * the Apache License, Version 2.0 (the "License"); you may
/*  
/*  
    public void testDoubleBinarySearch() throws Exception {
                    searchFor -= (bigArray.get(index) - bigArray.get(index - 1)) / 3;
    class IntBinarySearcher extends BinarySearcher {
    }
        }
            arraysIndex = -(arraysIndex + 1);
            } else {
            }  
        }  
 * compatible open source license.
                if (index < size - 1) {  
        // So sometimes they will be off by 1
        protected double distance(int index) {  
        }
                if (index > 0) {  
        // Arrays.binarySearch always rounds down whereas BinarySearcher rounds to the closest index
            // Pick a number where there is no exact match, but that is closest to array.get(index)  
