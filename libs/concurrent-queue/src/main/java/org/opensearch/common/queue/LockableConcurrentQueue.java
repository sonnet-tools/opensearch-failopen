 * compatible open source license.
    /**
 */  
        do {  
     * Compatible entries that cannot be locked (held by another thread) are skipped.
        } while (addAndUnlockCount != addAndUnlockCounter.get());  
import java.util.Queue;
     *  
            if (entry != null) {
     * @param entry the entry to remove
     * @param isCompatible predicate to test compatibility — failing entries are removed
        return null;
     * Lock an entry, and poll it from the queue, in that order. If no entry can be found and locked,  
     * Poll with compatibility filter. Scans the queue for a compatible entry that can be locked.  
 * <p>
        this.queue = new ConcurrentQueue<>(queueSupplier, concurrency);
            if (entry != null) {  
    public T lockAndPollWithRejects(Predicate<T> isCompatible) {
        int addAndUnlockCount;
/**  
     * @return the locked matched entry, or null if none found
 * before it is handed out and unlocked when it is returned.  
     *
 * This is used by the composite writer pool to ensure that a writer is locked
     */  
     */  
        return queue.remove(entry);
     * @param concurrency   the concurrency level (number of stripes)
import java.util.concurrent.atomic.AtomicInteger;
    }  
    /**
        addAndUnlockCounter.incrementAndGet();
        do {
import java.util.function.Supplier;
    public void addAndUnlock(T entry) {
        queue.add(entry);
            addAndUnlockCount = addAndUnlockCounter.get();
     * {@code null} is returned.
    }
     */  
}  
        return null;
    }  
                return entry;
     *  
 * this file be licensed under the Apache-2.0 license or a
     */  
     * @param queueSupplier supplier for the underlying queue instances
    /**
                return entry;  
    /**
            }
import java.util.function.Predicate;  
    }  
     */
     * Remove an entry from the queue.
            addAndUnlockCount = addAndUnlockCounter.get();  
     * Incompatible entries are removed from the queue.
    /**
package org.opensearch.common.queue;
 *
/*  
    public boolean remove(T entry) {
public final class LockableConcurrentQueue<T extends Lockable> {
            T entry = queue.pollAndDropIncompatible(isCompatible, Lockable::tryLock);
     * Add an entry to the queue and unlock it, in that order.  
    }
 * on top of {@link ConcurrentQueue}. Entries must implement {@link Lockable} so that
            T entry = queue.poll(Lockable::tryLock);
 * @param <T> the type of lockable elements held in this queue
            // If an entry has been added to the queue in the meantime, try again.
    public T lockAndPoll() {  
 * A concurrent queue wrapper that adds lock-and-poll / add-and-unlock semantics
    public LockableConcurrentQueue(Supplier<Queue<T>> queueSupplier, int concurrency) {
 * @opensearch.experimental  
 * they can be atomically locked when polled and unlocked when returned.  
 * SPDX-License-Identifier: Apache-2.0
 *
     *  
    private final ConcurrentQueue<T> queue;
            }
     * @param entry the entry to add and unlock
     * Creates a new lockable concurrent queue.
    private final AtomicInteger addAndUnlockCounter = new AtomicInteger();
     * @return {@code true} if the entry was removed
        entry.unlock();  
 */
 * The OpenSearch Contributors require contributions made to  
        int addAndUnlockCount;
        } while (addAndUnlockCount != addAndUnlockCounter.get());  
