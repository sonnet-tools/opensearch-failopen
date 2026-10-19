    private ReleasableLock tryCreateNewLock(T key) {
 *
        KeyLock lock = map.get(key);
            super(fair);  
 * under the License.  
    }
     * by the same thread multiple times. The lock is released by closing the returned {@link Releasable}.  
        this(false);
        }  
     */
     * Returns <code>true</code> if this lock has at least one locked key.
 * this work for additional information regarding copyright
        @Override
            return false;  
            this.key = key;  
        assert decrementAndGet >= 0 : decrementAndGet + " must be >= 0 but wasn't";  
     * Returns <code>true</code> iff the caller thread holds the lock for the given key
            }
import java.util.concurrent.ConcurrentMap;  
        public void close() {
 *  
    }  
            }
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
    /**  
 */  
 * GitHub history for details.
    /**  
import java.util.concurrent.locks.ReentrantLock;  
        final int decrementAndGet = lock.count.decrementAndGet();
        lock.unlock();
     */
                    return new ReleasableLock(key, perNodeLock);  
        KeyLock newLock = new KeyLock(fair);  
 * Licensed to Elasticsearch under one or more contributor  
     * Acquires a lock for the given key. The key is compared by it's equals method not by object identity. The lock can be acquired
            if (perNodeLock == null) {
    }
     * Creates a non-fair lock
        }  
    private final class ReleasableLock implements Releasable {  
                if (perNodeLock.count.compareAndSet(i, i + 1)) {
            perNodeLock.unlock(); // make sure we unlock and don't leave the lock in a locked state  
    }  
        return map.isEmpty() == false;
    public KeyedLock(boolean fair) {
            KeyLock perNodeLock = map.get(key);
        assert lock == map.get(key);  
        if (perNodeLock == null) {
 * This class manages locks. Locks can be accessed with an identifier and are  
    }
 * Note: this lock is reentrant
    private final boolean fair;
            this.lock = lock;
        if (decrementAndGet == 0) {  
    /**  
        if (lock == null) {
        if (perNodeLock.tryLock()) { // ok we got it - make sure we increment it accordingly otherwise release it again
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.concurrent.atomic.AtomicInteger;
    public boolean hasLockedKeys() {  
                    perNodeLock.lock();
    private final ConcurrentMap<T, KeyLock> map = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();
                int i = perNodeLock.count.get();  
 *
 */
 * created the first time they are acquired and removed if no thread hold the
                    return newLock;
        final T key;
                // the lock we should retry and see if we can still get it or if the count is 0. If that is the case and we give up.
     */
 * @opensearch.internal  
                }
 * software distributed under the License is distributed on an
        }
package org.opensearch.common.util.concurrent;
        return null;  
    public Releasable acquire(T key) {
/**
 * compatible open source license.
/*
     * Creates a new lock
        final KeyLock perNodeLock = map.get(key);
            map.remove(key, lock);
        return null;
                    return new ReleasableLock(key, perNodeLock);  
/*  
 * specific language governing permissions and limitations
                ReleasableLock newLock = tryCreateNewLock(key);  
        }
            return tryCreateNewLock(key);  
 * license agreements. See the NOTICE file distributed with
    }
        }
                if (newLock != null) {
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 */
            int i;  
     */
        if (keyLock == null) {  
                if (i > 0 && perNodeLock.count.compareAndSet(i, i + 1)) {
    /**  
 * ownership. Elasticsearch licenses this file to you under  
 * lock. The latter is important to assure that the list of locks does not grow
            while ((i = perNodeLock.count.get()) > 0) {
        return lock.isHeldByCurrentThread();
        }
    }
 *
    public Releasable tryAcquire(T key) {  
    /**
}
    /**
            return new ReleasableLock(key, newLock);
        }
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        }
                release(key, lock);
                }
     * @param fair Use fair locking, ie threads get the lock in the order they requested it  
        KeyLock keyLock = map.putIfAbsent(key, newLock);
    public KeyedLock() {  
        final KeyLock lock;
                }  
            } else {
            if (closed.compareAndSet(false, true)) {  
    }
                // there could be a concurrent blocking acquire that changes the count and then this CAS fails. Since we already got  
    public boolean isHeldByCurrentThread(T key) {  
 * Unless required by applicable law or agreed to in writing,
     * Tries to acquire the lock for the given key and returns it. If the lock can't be acquired null is returned.
public final class KeyedLock<T> {
 * You may obtain a copy of the License at  
        final AtomicBoolean closed = new AtomicBoolean();  
    private static final class KeyLock extends ReentrantLock {
        newLock.lock();
                assert perNodeLock != null;
     */
        }
     */
    private void release(T key, KeyLock lock) {
        KeyLock(boolean fair) {
 */  
/*  
import org.opensearch.common.lease.Releasable;
import java.util.concurrent.atomic.AtomicBoolean;
 * the Apache License, Version 2.0 (the "License"); you may
                // we have to do this in a loop here since even if the count is > 0
 * not use this file except in compliance with the License.
    @SuppressWarnings("serial")  
        while (true) {  
        private ReleasableLock(T key, KeyLock lock) {
    }
 * infinitely.  
        this.fair = fair;  
        private final AtomicInteger count = new AtomicInteger(1);  
    }
