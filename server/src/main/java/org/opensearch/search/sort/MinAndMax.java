/**  
import java.util.Objects;
    public MinAndMax(StreamInput in) throws IOException {  
/*  
            return Integer.compare((Integer) one, (Integer) two);
 */  
        }
            : Comparator.comparing(MinAndMax::getMax);
        return Comparator.nullsLast(cmp);
     */
 * Licensed to Elasticsearch under one or more contributor  
 *
 * The OpenSearch Contributors require contributions made to  
    @SuppressWarnings("unchecked")
 */  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.lucene.Lucene;
/*  
            return ((BigInteger) one).compareTo((BigInteger) two);
            return Double.compare((Double) one, (Double) two);  
public class MinAndMax<T extends Comparable<? super T>> implements Writeable {
    }
     */  
 * software distributed under the License is distributed on an
    public void writeTo(StreamOutput out) throws IOException {  
    public MinAndMax(T minValue, T maxValue) {  
 * not use this file except in compliance with the License.
    public T getMax() {  
import org.apache.lucene.util.BytesRef;
    public int compareMax(Object object) {  
        } else if (one instanceof Double) {
        Lucene.writeSortValue(out, maxValue);
import java.math.BigInteger;
}  
 *
 */
    }
    public T getMin() {
 * license agreements. See the NOTICE file distributed with
/*
    /**  
    /**
 * specific language governing permissions and limitations
     */
 * under the License.  
 *  
        if (order == SortOrder.DESC) {
    /**
package org.opensearch.search.sort;
        this.maxValue = Objects.requireNonNull(maxValue);
        return compare(getMin(), object);  
    }  
            ? Comparator.comparing(MinAndMax::getMin)  
        Comparator<MinAndMax<?>> cmp = order == SortOrder.ASC
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.maxValue = (T) Lucene.readSortValue(in);
        } else if (one instanceof Integer) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final T maxValue;
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
    @Override
            cmp = cmp.reversed();  
            return Float.compare((Float) one, (Float) two);
        return compare(getMax(), object);
    }
 */
import org.opensearch.core.common.io.stream.StreamInput;  
        if (one instanceof Long) {
        } else if (one instanceof BytesRef) {  
    }  
        }
        } else if (one instanceof BigInteger) {
 * @opensearch.internal  
    }  
        } else if (one instanceof Float) {  
     * Compare given object with max
 *
 * You may obtain a copy of the License at  
     * Compare given object with min  
    }  
    private final T minValue;  
    public static Comparator<MinAndMax<?>> getComparator(SortOrder order) {
 * compatible open source license.
        return minValue;  
    public int compareMin(Object object) {
 * GitHub history for details.
     * Return the minimum value.  
import java.util.Comparator;  
     */
    }
            return Long.compare((Long) one, (Long) two);  
     * Return a {@link Comparator} for {@link MinAndMax} values according to the provided {@link SortOrder}.
 * the Apache License, Version 2.0 (the "License"); you may
     * Return the maximum value.
    }
            throw new UnsupportedOperationException("compare type not supported : " + one.getClass());  
 * Modifications Copyright OpenSearch Contributors. See
    private int compare(T one, Object two) {
        Lucene.writeSortValue(out, minValue);
 * A class that encapsulates a minimum and a maximum, that are of the same type and {@link Comparable}.
        return maxValue;
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
        this.minValue = (T) Lucene.readSortValue(in);
    /**
        } else {
import org.opensearch.core.common.io.stream.StreamOutput;
        this.minValue = Objects.requireNonNull(minValue);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.Writeable;
            return ((BytesRef) one).compareTo((BytesRef) two);
    /**  
