    }
            alreadyClosed();  
 * KIND, either express or implied.  See the License for the
    /** gets the name of this instance */
/**  
    }
 * @opensearch.api
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
    public final void incRef() {
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
    }
 */
        }
     */
        int i = refCount.decrementAndGet();
            int i = refCount.get();
        do {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 *
            } else {  
        return name;  
}
            if (i > 0) {
 *  
        this.name = name;  
    public int refCount() {  
        if (tryIncRef() == false) {
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
package org.opensearch.common.util.concurrent;
                if (refCount.compareAndSet(i, i + 1)) {  
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected void alreadyClosed() {
            }
                return false;
    public final boolean tryIncRef() {
    }
                    return true;
 * this file be licensed under the Apache-2.0 license or a
    @Override
 * Licensed to Elasticsearch under one or more contributor  
    }
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * GitHub history for details.
/*  
        if (i == 0) {
 */  
     * Returns the current reference count.
            return true;  
    private final String name;  
        return this.refCount.get();
import java.util.concurrent.atomic.AtomicInteger;
    private final AtomicInteger refCount = new AtomicInteger(1);
    public String getName() {
        }
 * compatible open source license.
 */  
/*  
    @Override  
 * A basic RefCounted implementation that is initialized with a
        assert i >= 0;  
    protected abstract void closeInternal();  
    public final boolean decRef() {
 * specific language governing permissions and limitations
 * a 0 ref count  
 * the Apache License, Version 2.0 (the "License"); you may
 *
            closeInternal();
        return false;
 * ref count of 1 and calls {@link #closeInternal()} once it reaches
        throw new IllegalStateException(name + " is already closed can't increment refCount current count [" + refCount.get() + "]");  
 *
                }
    /**  
    }  
    public AbstractRefCounted(String name) {
public abstract class AbstractRefCounted implements RefCounted {
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
 */  
/*
        } while (true);  
