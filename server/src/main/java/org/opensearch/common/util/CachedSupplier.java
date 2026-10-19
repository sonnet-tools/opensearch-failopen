 * SPDX-License-Identifier: Apache-2.0
 *  
        if (resultSet == false) {
 * You may obtain a copy of the License at  
        this.supplier = supplier;
 * ownership. Elasticsearch licenses this file to you under  
 */
package org.opensearch.common.util;
 * specific language governing permissions and limitations
/*  
 * A {@link Supplier} that caches its return value. This may be useful to make
 * this work for additional information regarding copyright
    }  
 *
 * a {@link Supplier} idempotent or for performance reasons if always returning
/*
 * @opensearch.internal
 * under the License.  
 */  
    public CachedSupplier(Supplier<T> supplier) {
 * Unless required by applicable law or agreed to in writing,
 * the same instance is acceptable.  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 */  
 * compatible open source license.
 * not use this file except in compliance with the License.
}
public final class CachedSupplier<T> implements Supplier<T> {
            resultSet = true;  
import java.util.function.Supplier;
        }
    private boolean resultSet;
 * software distributed under the License is distributed on an
 * GitHub history for details.
            result = supplier.get();
 *
        return result;
    private T result;
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
    @Override
    public synchronized T get() {  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    private Supplier<T> supplier;  
 */  
    }  
