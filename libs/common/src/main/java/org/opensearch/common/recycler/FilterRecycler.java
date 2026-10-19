 */
 *  
    /** Wrap a recycled reference. */
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
    public Recycler.V<T> obtain() {
/**
    protected Recycler.V<T> wrap(Recycler.V<T> delegate) {  
 */
/*  
 * software distributed under the License is distributed on an
/*  
    /** Get the delegate instance to forward calls to. */
    @Override
/*
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
    }
        return delegate;
        return wrap(getDelegate().obtain());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 */  
    }
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 *  
package org.opensearch.common.recycler;
 * Base filter recycler.
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 *
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 */  
 * compatible open source license.
}  
 * ownership. Elasticsearch licenses this file to you under  
abstract class FilterRecycler<T> implements Recycler<T> {  
    protected abstract Recycler<T> getDelegate();  
 *
 * You may obtain a copy of the License at  
