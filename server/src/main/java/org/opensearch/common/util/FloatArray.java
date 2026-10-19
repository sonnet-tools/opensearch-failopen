     * Get an element given its index.
 * software distributed under the License is distributed on an
     * Increment value at the given index by <code>inc</code> and return the value.
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.common.util;
 * license agreements. See the NOTICE file distributed with
 *
     * Set a value at the given index and return the previous value.  
     */  
/*  
 *  
 * GitHub history for details.
    /**  
 * KIND, either express or implied.  See the License for the
    /**  
 */
    float set(long index, float value);
 */  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.util.BigArray;
@PublicApi(since = "1.0.0")  
     */
public interface FloatArray extends BigArray {
 */  
 * specific language governing permissions and limitations
     */
/*
 */
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * under the License.  
/**
     * Fill slots between <code>fromIndex</code> inclusive to <code>toIndex</code> exclusive with <code>value</code>.
 * compatible open source license.
 * @opensearch.api
     */
/*  
}
    /**
 * this file be licensed under the Apache-2.0 license or a
    float get(long index);  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    float increment(long index, float inc);
import org.opensearch.common.annotation.PublicApi;
 * Unless required by applicable law or agreed to in writing,
 * Abstraction of an array of double values.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    void fill(long fromIndex, long toIndex, float value);  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
    /**
