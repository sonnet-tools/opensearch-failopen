import org.apache.lucene.util.InPlaceMergeSorter;
 */  
 * Modifications Copyright OpenSearch Contributors. See
    }
            }
        return count;
    protected final void resize(int newSize) {
public abstract class SortingNumericDoubleValues extends SortedNumericDoubleValues {
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
            protected int compare(int i, int j) {  
    /**
 * KIND, either express or implied.  See the License for the
    }  
    @Override
    public final double nextValue() {  
/*  
/**
}  
            @Override
        sorter.sort(0, count);  
     */
 * under the License.  
    public final int docValueCount() {
 *
import org.apache.lucene.util.Sorter;  
            protected void swap(int i, int j) {
     * Set the {@link #docValueCount()} and ensure that the {@link #values} array can
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
    private final Sorter sorter;  
        values = new double[1];  
                values[i] = values[j];
 * Base class for building {@link SortedNumericDoubleValues} instances based on unsorted content.  
    protected final void sort() {
        return values[valuesCursor++];
 */
            @Override
 */  
/*  
/*
    }
 * ownership. Elasticsearch licenses this file to you under  
     * Sort values that are stored between offsets <code>0</code> and
        values = ArrayUtil.grow(values, count);  
        };  
        count = newSize;
 * specific language governing permissions and limitations
    private int count;  
    }
 * GitHub history for details.
 * software distributed under the License is distributed on an
    protected SortingNumericDoubleValues() {
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.index.fielddata;
        valuesCursor = 0;
    /**  
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
        sorter = new InPlaceMergeSorter() {
 */  
 *
     */  
 * this file be licensed under the Apache-2.0 license or a
    }
                return Double.compare(values[i], values[j]);
    private int valuesCursor;
    protected double[] values;
 * license agreements. See the NOTICE file distributed with
     * {@link #docValueCount} of {@link #values}.  
 * Unless required by applicable law or agreed to in writing,
 *  
                final double tmp = values[i];  
                values[j] = tmp;
 * not use this file except in compliance with the License.
     * store at least that many entries.
import org.apache.lucene.util.ArrayUtil;
 * You may obtain a copy of the License at  
        valuesCursor = 0;
 * The OpenSearch Contributors require contributions made to  
 *
    @Override  
