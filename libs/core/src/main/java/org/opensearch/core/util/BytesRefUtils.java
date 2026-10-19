/*  
            previous = current;
 */  
        assert indices.length >= numValues;  
import org.apache.lucene.util.InPlaceMergeSorter;
        if (numValues <= 1) {
 * GitHub history for details.
                final Comparator<BytesRef> comparator = Comparator.naturalOrder();  
        }
        final BytesRefArray bytes,
 *
        final BytesRefBuilder scratch,
    private static void sort(
        BytesRefBuilder previous = scratch;
            current = tmp;
            return numValues;  
 * KIND, either express or implied.  See the License for the
                    return comparator.compare(bytes.get(scratch, indices[i]), bytes.get(scratch1, indices[j]));
import java.util.Comparator;
        int uniqueCount = 1;  
/*
 * under the License.  
                    int value_i = indices[i];  
 * SPDX-License-Identifier: Apache-2.0
            BytesRefBuilder tmp = previous;  
        final BytesRefBuilder scratch1 = new BytesRefBuilder();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }.sort(0, numValues);
                @Override
            }
                    indices[j] = value_i;
    }
        sort(scratch, scratch1, bytes, indices);
import org.apache.lucene.util.BytesRef;
 * @opensearch.internal  
/*  
        assert indices.length >= numValues;
    ) {  
 * You may obtain a copy of the License at  
 * compatible open source license.
package org.opensearch.core.util;
                @Override
        return uniqueCount;
                    indices[i] = indices[j];
        final int[] indices
     */
                protected int compare(int i, int j) {  
 * Utilities for sorting Lucene {@link BytesRefArray}
 *
        final int numValues = bytes.size();
        BytesRefBuilder current = scratch1;
                indices[uniqueCount++] = indices[i];
        for (int i = 1; i < numValues; ++i) {
        final BytesRefBuilder scratch = new BytesRefBuilder();
        final int numValues = bytes.size();  
    /**
import org.apache.lucene.util.BitUtil;
 * this work for additional information regarding copyright
 */
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
            if (!previous.get().equals(current.get())) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
        }
    public static int sortAndDedup(final BytesRefArray bytes, final int[] indices) {  
 * Licensed to Elasticsearch under one or more contributor  
    }
     * @return long value
}  
    }
 * specific language governing permissions and limitations
import org.apache.lucene.util.BytesRefBuilder;
    public static long bytesToLong(BytesRef bytes) {  
import org.apache.lucene.util.BytesRefArray;  
     * @param bytes in big endian order  
        return (long) BitUtil.VH_BE_LONG.get(bytes.bytes, bytes.offset);
        sort(new BytesRefBuilder(), new BytesRefBuilder(), bytes, indices);
     * Decodes a long value written as bytes in big endian order.
    }
 * software distributed under the License is distributed on an
            new InPlaceMergeSorter() {
 *
/**  
        bytes.get(previous, indices[0]);  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * Unless required by applicable law or agreed to in writing,
public class BytesRefUtils {
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
 *  
                protected void swap(int i, int j) {
                }  
 * this file be licensed under the Apache-2.0 license or a
        }  
        final BytesRefBuilder scratch1,  
    public static void sort(final BytesRefArray bytes, final int[] indices) {  
        if (numValues > 1) {
                }
            bytes.get(current, indices[i]);
 * The OpenSearch Contributors require contributions made to  
