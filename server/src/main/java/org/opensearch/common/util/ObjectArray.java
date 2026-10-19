    /**  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * Abstraction of an array of object values.
    /**
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
@PublicApi(since = "1.0.0")  
    T get(long index);  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 */
     */
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
/*  
 * GitHub history for details.
/*
package org.opensearch.common.util;
 * under the License.  
 */  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 *  
 * Unless required by applicable law or agreed to in writing,
 */
 * not use this file except in compliance with the License.
 *  
 * @opensearch.api
 *     http://www.apache.org/licenses/LICENSE-2.0
}
 * Licensed to Elasticsearch under one or more contributor  
 *
 *
import org.opensearch.core.common.util.BigArray;
     * Get an element given its index.
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
 */  
    T set(long index, T value);
     * Set a value at the given index and return the previous value.  
public interface ObjectArray<T> extends BigArray {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
     */
/**
