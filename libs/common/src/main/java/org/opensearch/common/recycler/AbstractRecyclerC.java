 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
}
 */  
/*  
public abstract class AbstractRecyclerC<T> implements Recycler.C<T> {  
    @Override
 */  
/*
    public void destroy(T value) {  
 * compatible open source license.
    public abstract T newInstance();  
    @Override
 */
    }
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.common.recycler;
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
        // by default we simply drop the object for GC.
 * under the License.  
 *  
 * software distributed under the License is distributed on an
/**
    @Override
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * Base recycler.
 *
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 */
 * specific language governing permissions and limitations
    public abstract void recycle(T value);  
 *  
