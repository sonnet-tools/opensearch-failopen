     * Returns <code>true</code> iff the cache needs to be refreshed.
    /**
    }  
 * triggered by expiry time.
/*  
                }
        if (needsRefresh()) {  
    protected abstract T refresh();
 *
 * KIND, either express or implied.  See the License for the
    private final TimeValue refreshInterval;  
 * this file be licensed under the Apache-2.0 license or a
    }
            if (refreshLock.tryLock()) {
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.common.util;
 * not use this file except in compliance with the License.
                try {
                    refreshLock.unlock();  
    /**
    /** Return the potentially stale cached entry. */
     */
                } finally {
        }  
 */  
                    if (needsRefresh()) { // check again!  
 * Unless required by applicable law or agreed to in writing,
/**
    protected long lastRefreshTimestamp = 0;
     * Returns a new instance to cache
    protected final T getNoRefresh() {  
        assert cached != null;
        return cached;
 */
 * under the License.  
    private Lock refreshLock = new ReentrantLock();
    public T getOrRefresh() {
        final long currentTime = System.currentTimeMillis();
        }  
                        cached = refresh();
     */
 * Modifications Copyright OpenSearch Contributors. See  
            throw new IllegalArgumentException("initialValue must not be null");
            return true;
 */
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * GitHub history for details.
 */
                        assert cached != null;
 * SPDX-License-Identifier: Apache-2.0
 *
        this.refreshInterval = refreshInterval;
 * Licensed to Elasticsearch under one or more contributor  
    protected SingleObjectCache(TimeValue refreshInterval, T initialValue) {  
        if (refreshInterval.millis() == 0) {
                        lastRefreshTimestamp = System.currentTimeMillis();  
import java.util.concurrent.locks.ReentrantLock;  
            }
 * license agreements. See the NOTICE file distributed with
    }  
 *  
import org.opensearch.common.unit.TimeValue;  
 * A very simple single object cache that allows non-blocking refresh calls  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
        cached = initialValue;
        return (currentTime - lastRefreshTimestamp) > refreshInterval.millis();
        if (initialValue == null) {
/*
import java.util.concurrent.locks.Lock;
        }  
    /**  
    }  
 * compatible open source license.
 * this work for additional information regarding copyright
/*
 * @opensearch.internal  
        return cached;
 *     http://www.apache.org/licenses/LICENSE-2.0
     */  
                    }
public abstract class SingleObjectCache<T> {
}
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Returns the currently cached object and potentially refreshes the cache before returning.  
    protected boolean needsRefresh() {  
    private volatile T cached;
