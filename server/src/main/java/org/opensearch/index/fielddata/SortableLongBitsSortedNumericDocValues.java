    }  
    public SortedNumericDoubleValues getDoubleValues() {
 *  
    public long nextValue() throws IOException {  
    /** Return the wrapped values. */  
/*  
 */  
 * not use this file except in compliance with the License.
import org.apache.lucene.index.SortedNumericDocValues;
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
        return values.docValueCount();  
 * Unless required by applicable law or agreed to in writing,
    }  
 * Modifications Copyright OpenSearch Contributors. See
}
 * under the License.  
 * and converts the doubles to sortable long bits using
/*
 * compatible open source license.
 */
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.index.fielddata;
    public boolean advanceExact(int target) throws IOException {
        return NumericUtils.doubleToSortableLong(values.nextValue());
        return values.advanceExact(target);
    }
    @Override  
 * this work for additional information regarding copyright
 * {@link SortedNumericDocValues} instance that wraps a {@link SortedNumericDoubleValues}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * You may obtain a copy of the License at  
    SortableLongBitsSortedNumericDocValues(SortedNumericDoubleValues values) {
    private final SortedNumericDoubleValues values;  
 *
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.util.NumericUtils;
 *
 */  
    }
final class SortableLongBitsSortedNumericDocValues extends AbstractSortedNumericDocValues {
 * SPDX-License-Identifier: Apache-2.0
        this.values = values;  
 * {@link NumericUtils#doubleToSortableLong(double)}.  
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
    public int docValueCount() {
 *
 * @opensearch.internal
/*  
        return values;
 * specific language governing permissions and limitations
    @Override
/**  
 */  
    @Override
 * software distributed under the License is distributed on an
