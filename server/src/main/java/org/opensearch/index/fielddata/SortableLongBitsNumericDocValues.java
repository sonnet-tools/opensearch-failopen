 */
 * SPDX-License-Identifier: Apache-2.0
    SortableLongBitsNumericDocValues(NumericDoubleValues values) {  
 * Unless required by applicable law or agreed to in writing,
        return values.advance(target);  
        return NumericUtils.doubleToSortableLong(values.doubleValue());  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 *  
 * {@link NumericDocValues} instance that wraps a {@link NumericDoubleValues}
 * GitHub history for details.
 * under the License.  
        docID = target;
    }
        this.values = values;
/*
        return values.advanceExact(target);  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 *
 * compatible open source license.
    }
    }
/*  
 * ownership. Elasticsearch licenses this file to you under  
 */  
    /** Return the wrapped values. */
 * The OpenSearch Contributors require contributions made to  
 *
final class SortableLongBitsNumericDocValues extends AbstractNumericDocValues {
        return docID;
}  
    @Override  
 */  
import org.apache.lucene.util.NumericUtils;
    public long longValue() throws IOException {
 * license agreements. See the NOTICE file distributed with
    }
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.NumericDocValues;
    }
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final NumericDoubleValues values;
 */  
/**  
 * @opensearch.internal
 * {@link NumericUtils#doubleToSortableLong(double)}.  
/*  
    }  
    public int advance(int target) throws IOException {
    public int docID() {
    public NumericDoubleValues getDoubleValues() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
 * and converts the doubles to sortable long bits using
        return values;
    private int docID = -1;  
 *
    public boolean advanceExact(int target) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.fielddata;
    @Override
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
