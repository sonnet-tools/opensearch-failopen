 *
/**  
    public boolean tryLock() {
 */  
    /**
}
        lock.unlock();
    @Override
 *  
    public void lock() {  
 * a {@link ReentrantLock} for use in pool-based concurrency patterns.
package org.opensearch.common.queue;
 * The OpenSearch Contributors require contributions made to  
    }  
 *  
        lock.lock();
     * Returns the wrapped reference.  
     * @return a new {@code DefaultLockableHolder} containing {@code ref}
        return lock.tryLock();  
    }
     * Creates a new holder wrapping the given reference.
 * <p>Used by {@link LockablePool} to track items that can be locked for exclusive
    /**  
    }
        return ref;
        return new DefaultLockableHolder<>(ref);
    @Override  
 * SPDX-License-Identifier: Apache-2.0
    public void unlock() {
    @Override
    public T get() {
public class DefaultLockableHolder<T> implements Lockable {  
 * compatible open source license.
        this.ref = ref;  
 * access (e.g., writers in the indexing pipeline) and unlocked when returned to the pool.
    private final T ref;
import java.util.concurrent.locks.ReentrantLock;
     *
    }  
    public static <R> DefaultLockableHolder<R> of(R ref) {
    private DefaultLockableHolder(T ref) {
     *
 * A {@link Lockable} wrapper around an arbitrary reference, pairing the value with
    }
 * @param <T> the type of the wrapped reference
     * @param ref the reference to wrap  
 * this file be licensed under the Apache-2.0 license or a
     * @return the reference held by this holder
     * @param <R> the reference type
     */  
 */
    }  
    private final ReentrantLock lock = new ReentrantLock();  
/*  
     */  
