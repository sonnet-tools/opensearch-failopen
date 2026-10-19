 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.common;
        if (supplier != null) {  
 * compatible open source license.
 *
            supplier = null;
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
            value = supplier.get();
 */
/**  
 *
 *
 * not use this file except in compliance with the License.
 *  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api  
        return value;
    public MemoizedSupplier(Supplier<T> supplier) {  
 */  
import java.util.function.Supplier;
 */  
 * KIND, either express or implied.  See the License for the
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * specific language governing permissions and limitations
/*  
/*  
 * Unless required by applicable law or agreed to in writing,
public class MemoizedSupplier<T> implements Supplier<T> {
    @Override
    }
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
    private T value;
}  
 * A base supplier using memoization optimization technique
    }
        this.supplier = supplier;
 */
/*
 * You may obtain a copy of the License at  
    public T get() {
    private Supplier<T> supplier;  
 * this work for additional information regarding copyright
