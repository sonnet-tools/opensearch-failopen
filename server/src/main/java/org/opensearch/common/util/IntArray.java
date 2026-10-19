 *  
 */  
 *  
 * Unless required by applicable law or agreed to in writing,
 * Abstraction of an array of integer values.
    /**
public interface IntArray extends BigArray {
 * license agreements. See the NOTICE file distributed with
    void fill(long fromIndex, long toIndex, int value);  
     */
import org.opensearch.core.common.util.BigArray;
/**
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
     */
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
     * Get an element given its index.
/*  
 * under the License.  
     * Increment value at the given index by <code>inc</code> and return the value.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.annotation.PublicApi;
 * Modifications Copyright OpenSearch Contributors. See
     */
 * not use this file except in compliance with the License.
     */  
}
 *
/*
 * Licensed to Elasticsearch under one or more contributor  
     * Set a value at the given index and return the previous value.  
    /**  
    int set(long index, int value);
 * software distributed under the License is distributed on an
 */  
    /**
 * this work for additional information regarding copyright
 */
 *
@PublicApi(since = "1.0.0")  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
/*  
 * SPDX-License-Identifier: Apache-2.0
     * Fill slots between <code>fromIndex</code> inclusive to <code>toIndex</code> exclusive with <code>value</code>.
    int increment(long index, int inc);
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.common.util;
 * @opensearch.api
 * You may obtain a copy of the License at  
    int get(long index);  
 */
