 * this work for additional information regarding copyright
            this.selectors = selectors;
    private AtomicInteger counter = new AtomicInteger(0);  
 * specific language governing permissions and limitations
    RoundRobinSupplier(S[] selectors) {  
final class RoundRobinSupplier<S> implements Supplier<S> {
        this.selectorsSet.set(true);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final AtomicBoolean selectorsSet = new AtomicBoolean(false);
 *
import java.util.concurrent.atomic.AtomicBoolean;
    int count() {
 * not use this file except in compliance with the License.
    }  
 * compatible open source license.
}
        this.selectors = null;  
/*  
    }
 *  
 * under the License.  
import java.util.concurrent.atomic.AtomicInteger;
 * the Apache License, Version 2.0 (the "License"); you may
        }
 */
        S[] selectors = this.selectors;
 * license agreements. See the NOTICE file distributed with
 */  
    public S get() {  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.selectors = selectors;
 * You may obtain a copy of the License at  
        return selectors[counter.getAndIncrement() % selectors.length];
    void setSelectors(S[] selectors) {
 * software distributed under the License is distributed on an
    private volatile S[] selectors;
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
package org.opensearch.nio;
    @Override
 */  
        } else {
    }  
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * this file be licensed under the Apache-2.0 license or a
    RoundRobinSupplier() {
 * Unless required by applicable law or agreed to in writing,
 *
 * The OpenSearch Contributors require contributions made to  
        if (selectorsSet.compareAndSet(false, true)) {  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
        return selectors.length;
import java.util.function.Supplier;  
            throw new AssertionError("Selectors already set. Should only be set once.");  
    }
 * SPDX-License-Identifier: Apache-2.0
