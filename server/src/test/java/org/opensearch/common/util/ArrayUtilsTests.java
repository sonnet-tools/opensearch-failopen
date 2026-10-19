 * under the License.  
 * this work for additional information regarding copyright
        for (int j = 0; j < 100; j++) {
                assertThat(bitSet.get(foundIndex), is(true));
 * Modifications Copyright OpenSearch Contributors. See
 */  
            first[i] = randomRealisticUnicodeOfCodepointLengthBetween(0, 10);
                    value = Double.NaN;
 * Licensed to Elasticsearch under one or more contributor  
                    lookForValue = value;  
/*
            double tolerance = randomDoubleBetween(0, 0.01, true);
                    value = randomDoubleBetween(0, 9, true);
}  
 *
 * The OpenSearch Contributors require contributions made to  
            }
 *
                if (frequently()) {  
 * this file be licensed under the Apache-2.0 license or a
        String[] first = new String[firstSize];
    public void testConcat() {
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
        assertArrayEquals(new String[] { "a", "b", "c", "d" }, ArrayUtils.concat(new String[] { "a", "b" }, new String[] { "c", "d" }));
            sourceOfTruth.add(first[i]);
 */
                if (Double.isNaN(lookForValue) && Double.isNaN(array[i])) {
        for (int i = 0; i < firstSize; i++) {  
            // return the first one that will match.
            double[] array = new double[10];  
/*  
 * KIND, either express or implied.  See the License for the
        }  
            BitSet bitSet = new BitSet(10);  
 */  
                }  
                assertThat(foundIndex, is(-1));  
import java.util.Arrays;
                } else {                    // sometimes we'll have NaN in the array
        int secondSize = randomIntBetween(0, 10);
                double value;
 * You may obtain a copy of the License at  
            }  
                if (i == index && lookForValue < 0) {
                    array[i] = value;  
            // array that will match the looked for value with the random tolerance. In such cases, the binary search will
        ArrayList<String> sourceOfTruth = new ArrayList<>();
            int foundIndex = ArrayUtils.binarySearch(array, lookForValue, tolerance);  
        assertArrayEquals(sourceOfTruth.toArray(new String[0]), ArrayUtils.concat(first, second));
        }  
                    bitSet.set(i);
                }
                }
                } else if ((array[i] >= lookForValue - tolerance) && (array[i] <= lookForValue + tolerance)) {
            } else {
 * compatible open source license.
 * GitHub history for details.
import static org.hamcrest.Matchers.is;
    }
            sourceOfTruth.add(second[i]);
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            double lookForValue = frequently() ? -1 : Double.NaN; // sometimes we'll look for NaN
import java.util.ArrayList;  
                    bitSet.set(i);  
 *  
public class ArrayUtilsTests extends OpenSearchTestCase {  
    public void testBinarySearch() throws Exception {
                    array[i] = value + ((randomBoolean() ? 1 : -1) * randomDouble() * tolerance);
            for (int i = 0; i < array.length; i++) {
 * ownership. Elasticsearch licenses this file to you under  
import java.util.BitSet;
            // pick up all the indices that fall within the range of [lookForValue - tolerance, lookForValue + tolerance]
import org.opensearch.test.OpenSearchTestCase;
            Arrays.sort(array);  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
        String[] second = new String[secondSize];
            }
        }
            // we need to do this, since we choose the values randomly and we might end up having multiple values in the  
        for (int i = 0; i < secondSize; i++) {  
            int index = randomIntBetween(0, 9);  
            if (bitSet.cardinality() == 0) {
            second[i] = randomRealisticUnicodeOfCodepointLengthBetween(0, 10);
            for (int i = 0; i < array.length; i++) {
 * software distributed under the License is distributed on an
        int firstSize = randomIntBetween(0, 10);  
package org.opensearch.common.util;
 * not use this file except in compliance with the License.
