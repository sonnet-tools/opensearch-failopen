 * Licensed to Elasticsearch under one or more contributor  
    @Override
 */  
 * Modifications Copyright OpenSearch Contributors. See
}  
 * compatible open source license.
 * You may obtain a copy of the License at  
    public int advance(int target) throws IOException {  
    }  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
    /** Return the wrapped values. */  
 */  
        return values;
/**  
    @Override
 * SPDX-License-Identifier: Apache-2.0
final class SortableLongBitsToSortedNumericDoubleValues extends SortedNumericDoubleValues {
/*  
    @Override
    }  
 */
 * the Apache License, Version 2.0 (the "License"); you may
    }
import java.io.IOException;
        return values.docValueCount();  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * {@link SortedNumericDoubleValues} instance that wraps a {@link SortedNumericDocValues}
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
    public double nextValue() throws IOException {  
 * software distributed under the License is distributed on an
 */  
import org.apache.lucene.util.NumericUtils;
 * specific language governing permissions and limitations
 * and converts the doubles to sortable long bits using
import org.apache.lucene.index.SortedNumericDocValues;
        return values.advance(target);
    }
/*
 *  
 * not use this file except in compliance with the License.
    public SortedNumericDocValues getLongValues() {
 * {@link NumericUtils#sortableLongToDouble(long)}.  
 * @opensearch.internal
    private final SortedNumericDocValues values;  
    }
        return values.advanceExact(target);
        this.values = values;  
 * GitHub history for details.
 * under the License.  
    public int docValueCount() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
package org.opensearch.index.fielddata;
    }
 *
 *
/*  
    public boolean advanceExact(int target) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 *
        return NumericUtils.sortableLongToDouble(values.nextValue());
    SortableLongBitsToSortedNumericDoubleValues(SortedNumericDocValues values) {
