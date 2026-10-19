     * Get an element given its index.
 * license agreements. See the NOTICE file distributed with
     * Fill slots between <code>fromIndex</code> inclusive to <code>toIndex</code> exclusive with <code>value</code>.
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * You may obtain a copy of the License at  
 * compatible open source license.
     * Increment value at the given index by <code>inc</code> and return the value.
import org.opensearch.common.annotation.PublicApi;
 */
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 *  
    long set(long index, long value);
 * Unless required by applicable law or agreed to in writing,
     */  
 *
import org.opensearch.core.common.util.BigArray;
    /**
package org.opensearch.common.util;
    long get(long index);  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 *  
    /**  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
/*
    /**  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * Abstraction of an array of long values.
 */  
 *
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
/*  
     */
    long increment(long index, long inc);
 */  
    /**
 * not use this file except in compliance with the License.
public interface LongArray extends BigArray {
 */
     */
 * ownership. Elasticsearch licenses this file to you under  
}
/**
@PublicApi(since = "1.0.0")  
 * The OpenSearch Contributors require contributions made to  
     * Set a value at the given index and return the previous value.  
     */
 * @opensearch.api
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    void fill(long fromIndex, long toIndex, long value);  
