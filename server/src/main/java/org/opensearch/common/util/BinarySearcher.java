 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    return mid;
    }
     */
                if (mid < to) {
                // arr[mid] == value  
     * @return the magnitude of the distance between the element at <code>index</code> and the value being searched for.  
     * Rather, this value should be stored by the subclass along with the underlying array.  
    protected abstract double distance(int index);  
package org.opensearch.common.util;
/*  
     * closest to the search value.  
 * the Apache License, Version 2.0 (the "License"); you may
     * equal to, or greater than the value being searched for.
 * this work for additional information regarding copyright
     * It will usually be <code>Math.abs(array[index] - searchValue)</code>.
 * These things should be determined by the subclass in its overridden methods.
        while (from < to) {
 * To do a search, create a subclass and implement custom {@link #compare(int)} and {@link #distance(int)} methods.
 * specific language governing permissions and limitations
 * NOTE: this class is not thread safe
     *  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
     */
                    }
     * Uses a binary search to determine the index of the element within the index range {from, ... , to} that is
                    if (compareValBeforeMid < 0) {
 *  
                    }
                // arr[mid] < val  
     * @return a negative integer, zero, or a positive integer if the array's value at <code>index</code> is less than,  
 * Unless required by applicable law or agreed to in writing,
/*  
                // arr[mid] > val
    /**
    protected abstract int compare(int index);  
 */
                    // val < arr[mid] and there are no more candidates below mid, so mid is the closest  
            }
    public int search(int from, int to) {  
                    if (compareValAfterMid > 0) {  
                        return getClosestIndex(mid, mid + 1);
                    int compareValAfterMid = compare(mid + 1);
 * software distributed under the License is distributed on an
                        // val is between indices (mid - 1), mid
        }  
 */  
 *
    /**
                }
     **/
                        return getClosestIndex(mid, mid - 1);  
 *
     * @return the index of the closest element.
     */
                    return mid;
        } else {
/**
            int compareResult = compare(mid);  
 */
}
 * Performs binary search on an arbitrary data structure.
 * <p>
public abstract class BinarySearcher {  
 *     http://www.apache.org/licenses/LICENSE-2.0
                return mid;
/*
 * KIND, either express or implied.  See the License for the
                    // (mid > from) ensures that mid - 1 is not out of bounds
     * Requires: The underlying array should be sorted.
            } else {  
    /**
        }
                }  
 * Modifications Copyright OpenSearch Contributors. See
                } else if (mid == 0) {
        if (distance(index1) < distance(index2)) {  
     * Unlike most binary search implementations, the value being searched for is not an argument to search method.
                    int compareValBeforeMid = compare(mid - 1);  
            return index1;
 * under the License.  
 * You may obtain a copy of the License at  
 * compatible open source license.
                } else if (mid == to) {  
                    // (mid < to) ensures that mid + 1 is not out of bounds
 * {@link BinarySearcher} knows nothing about the value being searched for or the underlying data structure.  
                    // val > arr[mid] and there are no more elements above mid, so mid is the closest
 * <p>
     *
 * Refer to {@link BigArrays.DoubleBinarySearcher} for an example.  
 * @opensearch.internal
 *  
 * license agreements. See the NOTICE file distributed with
                    // Check if val is between (mid - 1, mid)
 * <p>  
 * <p>
            if (compareResult == 0) {
                to = mid - 1;
            return index2;  
                    // Check if val is between (mid, mid + 1) before setting left = mid + 1  
 * GitHub history for details.
    }  
                from = mid + 1;
            int mid = (from + to) >>> 1;
 * this file be licensed under the Apache-2.0 license or a
        return from;
 * The OpenSearch Contributors require contributions made to  
            } else if (compareResult < 0) {
    /**
 * Licensed to Elasticsearch under one or more contributor  
    private int getClosestIndex(int index1, int index2) {
 */  
                if (mid > from) {  
 * not use this file except in compliance with the License.
     * @return the index who's underlying value is closest to the value being searched for.  
     * <p>
