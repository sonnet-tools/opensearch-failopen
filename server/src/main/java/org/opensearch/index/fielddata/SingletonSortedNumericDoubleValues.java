    }
 * Exposes multi-valued view over a single-valued instance.
 *
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.index.fielddata;
    public double nextValue() throws IOException {
    }
    public boolean advanceExact(int target) throws IOException {  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 */
/*
    @Override  
 */  
 * You may obtain a copy of the License at  
 * compatible open source license.
 */  
 * that works for single or multi-valued types.
        return 1;  
    private final NumericDoubleValues in;  
    }  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
    @Override
}  
 *  
 * This can be used if you want to have one multi-valued implementation  
final class SingletonSortedNumericDoubleValues extends SortedNumericDoubleValues {
    /** Return the wrapped {@link NumericDoubleValues} */  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    public int advance(int target) throws IOException {  
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
        return in.advanceExact(target);
 * not use this file except in compliance with the License.
 * GitHub history for details.
        return in;
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal  
 *
 * <p>
 *
    }
 * this work for additional information regarding copyright
    public NumericDoubleValues getNumericDoubleValues() {
/**  
        return in.doubleValue();
    SingletonSortedNumericDoubleValues(NumericDoubleValues in) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
    }
        return in.advance(target);
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
        this.in = in;  
/*  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * software distributed under the License is distributed on an
    @Override
    public int docValueCount() {
