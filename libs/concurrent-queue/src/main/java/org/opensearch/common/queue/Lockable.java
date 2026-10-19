}  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
     * @return {@code true} if the lock was acquired
    /**
     */
     */
     */
 *
/*  
 * A minimal locking contract for objects managed by a {@link LockableConcurrentQueue}.
    /**
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.experimental
    boolean tryLock();  
 * compatible open source license.
/**
     *  
public interface Lockable {  
package org.opensearch.common.queue;
 *  
    /**
 */
     * Acquires the lock.  
     * Attempts to acquire the lock without blocking.
    void lock();
    void unlock();
 */  
     * Releases the lock.  
