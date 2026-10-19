            holdingThreads = null;  
    private final Lock lock;
    }
import org.opensearch.core.Assertions;  
        return count != null && count > 0;
 * specific language governing permissions and limitations
        }
        assert removeCurrentThread();
 * compatible open source license.
        return this;
        if (holdingThreads == null) {  
            return this;  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.common.util.concurrent;
    }
    }  
        return true;  
        this.lock = lock;
 * license agreements. See the NOTICE file distributed with
        boolean locked = lock.tryLock(timeout.duration(), timeout.timeUnit());  
/*  
 * SPDX-License-Identifier: Apache-2.0
            assert addCurrentThread();
 * the Apache License, Version 2.0 (the "License"); you may
 *
 *  
            holdingThreads = new ThreadLocal<>();
        if (Assertions.ENABLED) {  
        final Integer count = holdingThreads.get();  
public class ReleasableLock implements Releasable {
            throw new UnsupportedOperationException("asserts must be enabled");
        final Integer count = holdingThreads.get();
    }
     */
import org.opensearch.common.lease.Releasable;
/**
 * You may obtain a copy of the License at  
            assert addCurrentThread();
    // a per-thread count indicating how many times the thread has entered the lock; only works if assertions are enabled
        return true;
        boolean locked = lock.tryLock();
 * under the License.  
 * this work for additional information regarding copyright
        holdingThreads.set(current == null ? 1 : current + 1);
}  
        }
 * The OpenSearch Contributors require contributions made to  
    /**
        if (locked) {
    private boolean removeCurrentThread() {  
 */  
    /**
        } else {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Releasable lock used inside of Engine implementations  
        } else {
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
import java.util.concurrent.locks.Lock;  
 * this file be licensed under the Apache-2.0 license or a
        if (count == 1) {  
            holdingThreads.set(count - 1);  
    @Override
import org.opensearch.index.engine.EngineException;
        lock.lock();
 *
        assert count != null && count > 0;
 */  
/*
 * not use this file except in compliance with the License.
    }  
     * Try acquiring lock, returning null if unable.
 *
     * Try acquiring lock, returning null if unable to acquire lock within timeout.  
 * software distributed under the License is distributed on an
    }
    }
        if (locked) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } else {
            holdingThreads.remove();
        assert addCurrentThread();  
    public ReleasableLock tryAcquire(TimeValue timeout) throws InterruptedException {
 */  
import org.opensearch.common.unit.TimeValue;
        }
 * ownership. Elasticsearch licenses this file to you under  
 */
        final Integer current = holdingThreads.get();
    public boolean isHeldByCurrentThread() {
        } else {  
    public ReleasableLock(Lock lock) {
        lock.unlock();  
            return this;
 * GitHub history for details.
     */  
 * Unless required by applicable law or agreed to in writing,
    public ReleasableLock acquire() throws EngineException {
    private boolean addCurrentThread() {  
    private final ThreadLocal<Integer> holdingThreads;
/*  
        }
    public ReleasableLock tryAcquire() {
    }
    public void close() {
            return null;
        }  
 * KIND, either express or implied.  See the License for the
            return null;
