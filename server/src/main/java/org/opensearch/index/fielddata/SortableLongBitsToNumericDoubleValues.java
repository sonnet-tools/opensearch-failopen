 * this file be licensed under the Apache-2.0 license or a
}
    public NumericDocValues getLongValues() {
 */  
    }
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
import org.apache.lucene.index.NumericDocValues;
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    private final NumericDocValues values;  
    }
    public double doubleValue() throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 * GitHub history for details.
    @Override
    }
    /** Return the wrapped values. */
        this.values = values;  
import org.apache.lucene.util.NumericUtils;
/**  
 * and converts the doubles to sortable long bits using
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.index.fielddata;
 *
 */  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
        return values;  
 */
    @Override  
        return NumericUtils.sortableLongToDouble(values.longValue());
/*  
        return values.advance(target);
 * {@link NumericUtils#sortableLongToDouble(long)}.  
/*
    public int advance(int target) throws IOException {
 * KIND, either express or implied.  See the License for the
    public boolean advanceExact(int doc) throws IOException {  
    }  
 *
 *
final class SortableLongBitsToNumericDoubleValues extends NumericDoubleValues {
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
 * not use this file except in compliance with the License.
        return values.advanceExact(doc);
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Modifications Copyright OpenSearch Contributors. See
    SortableLongBitsToNumericDoubleValues(NumericDocValues values) {
/*  
 * @opensearch.internal
 * {@link NumericDoubleValues} instance that wraps a {@link NumericDocValues}
 */  
 * The OpenSearch Contributors require contributions made to  
