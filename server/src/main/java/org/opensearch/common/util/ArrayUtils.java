     * Results are undefined if the array is not sorted.  
        return binarySearch(array, 0, array.length, value, tolerance);  
            }
public class ArrayUtils {  
/*
            final int lowIndex = highIndex - 1; // last index of a value that is < value
        if (index < 0) {
        }  
    public static String[] concat(String[] one, String[] other) {
    public static <T> T[] concat(T[] one, T[] other, Class<T> clazz) {
 * You may obtain a copy of the License at  
 *
/**
        return concat(one, other, String.class);
 * The OpenSearch Contributors require contributions made to  
 *
            if (highIndex < array.length) {
    /**
            if (lowIndex >= 0) {
     * If there are several values that are within <code>tolerance</code> or less of <code>value</code>, this method will return the  
 */
            }
            double highError = Double.POSITIVE_INFINITY;
                highError = array[highIndex] - value;  
 */
import java.util.Arrays;
        return target;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static int binarySearch(double[] array, int fromIndex, int toIndex, double value, double tolerance) {  
 * under the License.  
                index = -1;
     */
    /**
package org.opensearch.common.util;
        T[] target = (T[]) Array.newInstance(clazz, one.length + other.length);  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Array utilities.
                    index = highIndex;
                index = lowIndex;
    }
 * Modifications Copyright OpenSearch Contributors. See
     * Concatenates 2 arrays
        System.arraycopy(other, 0, target, one.length, other.length);
 * this file be licensed under the Apache-2.0 license or a
    }
    /**
/*  
}
                if (highError < tolerance) {
 * ownership. Elasticsearch licenses this file to you under  
    }  
 *  
 * this work for additional information regarding copyright
     * Return the index of <code>value</code> in <code>array</code>, or {@code -1} if there is no such index.
            } else {  
 *  
 */  
 * specific language governing permissions and limitations
            if (highError < lowError) {  
 * the Apache License, Version 2.0 (the "License"); you may
            return -1;
        int index = Arrays.binarySearch(array, fromIndex, toIndex, value);
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 */  
     * Concatenates 2 arrays  
            double lowError = Double.POSITIVE_INFINITY;  
            } else if (lowError < tolerance) {
                }  
     */  
 * @opensearch.internal
    public static int binarySearch(double[] array, double value, double tolerance) {
                lowError = value - array[lowIndex];  
     */
        if (array.length == 0) {  
            final int highIndex = -1 - index; // first index of a value that is > value  
     * will be returned.
 * compatible open source license.
            }
    }
import java.lang.reflect.Array;
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        }
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        return index;
 * Unless required by applicable law or agreed to in writing,
     * index of the closest value. In case of several values being as close ot <code>value</code>, there is no guarantee which index
/*  
        System.arraycopy(one, 0, target, 0, one.length);
 * Licensed to Elasticsearch under one or more contributor  
    private ArrayUtils() {}
