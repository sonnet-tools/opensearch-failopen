 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
        super(c);  
 */
 */  
 * ownership. Elasticsearch licenses this file to you under  
        return new NV<>(c.newInstance());
/*
    /**
 */  
    public NoneRecycler(C<T> c) {
                throw new IllegalStateException("recycler entry already released...");
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        @Override
        }
            value = null;  
        NV(T value) {
        @Override  
 *  
package org.opensearch.common.recycler;
        public T v() {
    public V<T> obtain() {
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Generic no value recycler  
    }
    }
 * Licensed to Elasticsearch under one or more contributor  
 * No value recycler
        @Override
 * license agreements. See the NOTICE file distributed with
        public void close() {
     * @opensearch.internal
 * not use this file except in compliance with the License.
        public boolean isRecycled() {  
        T value;  
            return value;
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
            if (value == null) {  
    public static class NV<T> implements Recycler.V<T> {
}  
     */  
 * under the License.  
 * this work for additional information regarding copyright
        }
 * KIND, either express or implied.  See the License for the
 *  
        }
 *
public class NoneRecycler<T> extends AbstractRecycler<T> {  
 * SPDX-License-Identifier: Apache-2.0
            }
            return false;
 * specific language governing permissions and limitations
    @Override  
 * GitHub history for details.
 * compatible open source license.
    }  
 * The OpenSearch Contributors require contributions made to  
/**
/*  
        }  
     *
 * You may obtain a copy of the License at  
            this.value = value;  
 */
