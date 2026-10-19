    @Override  
     * Set the {@link #docValueCount()} and ensure that the {@link #values} array can  
                final long tmp = values[i];
    private final Sorter sorter;  
        // resize
                return Long.compare(values[i], values[j]);  
        }  
            return;
 *
/**
            protected int compare(int i, int j) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
public abstract class SortingNumericDocValues extends SortedNumericDocValues {
}
            }
        values = ArrayUtil.growExact(values, newValuesLength);
                values[j] = tmp;
 * this work for additional information regarding copyright
        // account for initial values size of 1
 */  
/*
        // copying.
import java.util.function.LongConsumer;  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
     * {@link #count} of {@link #values}.
            @Override  
 * Unless required by applicable law or agreed to in writing,
     */
     * store at least that many entries.
        circuitBreakerConsumer.accept(newValuesLength * Long.BYTES);
    }
    protected final void resize(int newSize) {  
    protected SortingNumericDocValues(LongConsumer circuitBreakerConsumer) {
 *  
        circuitBreakerConsumer.accept(-oldValuesSizeInBytes);
            }
 * software distributed under the License is distributed on an
            protected void swap(int i, int j) {
        if (newSize <= values.length) {
        long oldValuesSizeInBytes = values.length * Long.BYTES;  
    protected int valuesCursor;
    /**
    }  
package org.opensearch.index.fielddata;
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
import org.apache.lucene.index.SortedNumericDocValues;
 * You may obtain a copy of the License at  
 *
    }  
        };
        // account for freeing the old values array
 */
        // as well as the overhead of keeping both arrays in memory while
        sorter.sort(0, count);
                values[i] = values[j];  
 */  
 * The OpenSearch Contributors require contributions made to  
    protected final void sort() {  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }  
/*  
import org.apache.lucene.util.InPlaceMergeSorter;  
        // to include both the additional bytes used by the grown array  
 * under the License.  
 * specific language governing permissions and limitations
import org.apache.lucene.util.Sorter;
    protected long[] values;
        values = new long[1];
            @Override
        this.circuitBreakerConsumer = circuitBreakerConsumer;  
        count = newSize;
        this(l -> {});
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
    private int count;  
import org.apache.lucene.util.ArrayUtil;
 * ownership. Elasticsearch licenses this file to you under  
    /**
 */  
/*  
    public final int docValueCount() {
     * Sort values that are stored between offsets <code>0</code> and  
        return values[valuesCursor++];
 * not use this file except in compliance with the License.
     */
        this.circuitBreakerConsumer.accept(Long.BYTES);
        int newValuesLength = ArrayUtil.oversize(newSize, Long.BYTES);
 * this file be licensed under the Apache-2.0 license or a
    private LongConsumer circuitBreakerConsumer;
    public final long nextValue() {
        // Array is expected to grow so increment the circuit breaker
        sorter = new InPlaceMergeSorter() {
    @Override
        valuesCursor = 0;  
    protected SortingNumericDocValues() {  
 *
        valuesCursor = 0;
    }
 * license agreements. See the NOTICE file distributed with
 * Base class for building {@link SortedNumericDocValues} instances based on unsorted content.  
 * SPDX-License-Identifier: Apache-2.0
        return count;  
