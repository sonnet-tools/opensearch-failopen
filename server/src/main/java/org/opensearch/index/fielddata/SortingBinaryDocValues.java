import org.apache.lucene.util.BytesRefBuilder;  
    public int docValueCount() {
            values = Arrays.copyOf(values, newLen);  
 * Licensed to Elasticsearch under one or more contributor  
        sorter.sort(0, count);  
 * specific language governing permissions and limitations
        if (values.length < count) {  
    }  
 *  
                values[i] = new BytesRefBuilder();
        }
    }
    public final BytesRef nextValue() {
import org.apache.lucene.util.ArrayUtil;
    }
     * {@link #count} of {@link #values}.  
    protected int count;  
    private int index;
            @Override
public abstract class SortingBinaryDocValues extends SortedBinaryDocValues {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
}
 * ownership. Elasticsearch licenses this file to you under  
    private final Sorter sorter;
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.util.RamUsageEstimator;
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
    protected final void sort() {
 *
import java.util.Arrays;
    protected SortingBinaryDocValues() {
 * software distributed under the License is distributed on an
    @Override
 * KIND, either express or implied.  See the License for the
                return values[i].get().compareTo(values[j].get());  
 */  
     * Sort values that are stored between offsets <code>0</code> and
 * Unless required by applicable law or agreed to in writing,
 *
            final int newLen = ArrayUtil.oversize(count, RamUsageEstimator.NUM_BYTES_OBJECT_REF);
        sorter = new InPlaceMergeSorter() {  
 * compatible open source license.
    /**
 * @opensearch.internal
    @Override  
        };
import org.apache.lucene.util.InPlaceMergeSorter;
            }
 * this file be licensed under the Apache-2.0 license or a
     */
            for (int i = oldLen; i < newLen; ++i) {
     */
     * Make sure the {@link #values} array can store at least {@link #count} entries.  
 * the Apache License, Version 2.0 (the "License"); you may
    protected final void grow() {
        assert index < count;
 */
 * GitHub history for details.
        return values[index++].get();  
import org.apache.lucene.util.Sorter;  
 * The OpenSearch Contributors require contributions made to  
 */
/**
/*  
            protected int compare(int i, int j) {
 * not use this file except in compliance with the License.
            protected void swap(int i, int j) {  
            @Override
package org.opensearch.index.fielddata;
                ArrayUtil.swap(values, i, j);
        index = 0;
 * under the License.  
 * Base class for building {@link SortedBinaryDocValues} instances based on unsorted content.
    protected BytesRefBuilder[] values;
/*
 *  
    }
            }  
            }
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.util.BytesRef;
        values = new BytesRefBuilder[] { new BytesRefBuilder() };
        return count;  
/*  
    /**
            final int oldLen = values.length;
 */  
