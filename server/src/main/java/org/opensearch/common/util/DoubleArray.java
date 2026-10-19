 * under the License.  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 *
     */  
 *  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
     * Fill slots between <code>fromIndex</code> inclusive to <code>toIndex</code> exclusive with <code>value</code>.
    /**  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.annotation.PublicApi;
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
@PublicApi(since = "1.0.0")  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
/**
     * Increment value at the given index by <code>inc</code> and return the value.
 * Modifications Copyright OpenSearch Contributors. See
public interface DoubleArray extends BigArray {
    double get(long index);  
 * compatible open source license.
}
/*
     * Get an element given its index.
    /**
package org.opensearch.common.util;
 *
 */  
 * Abstraction of an array of double values.
 * @opensearch.api
 * Licensed to Elasticsearch under one or more contributor  
     */
 */
    /**
     * Set a value at the given index and return the previous value.  
/*  
    double set(long index, double value);
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
    /**  
    void fill(long fromIndex, long toIndex, double value);  
 */
     */
 * license agreements. See the NOTICE file distributed with
/*  
     */
    double increment(long index, double inc);
import org.opensearch.core.common.util.BigArray;
