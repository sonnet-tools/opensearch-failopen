            final int index = (threadHash + i) % concurrency;  
    }  
 */  
                }  
        // Seed the order in which to look at entries based on the current thread. This helps distribute
                }  
        lock.lock();  
 * queues using thread-affinity-based hashing. This reduces contention by allowing
    void add(T entry) {  
 */  
    private T scanAndDropIncompatible(Queue<T> queue, Predicate<T> isCompatible, Predicate<T> predicate) {
    }
    boolean remove(T entry) {  
        for (int i = 0; i < concurrency; ++i) {  
        }
            }
                    return;  
        }
            );
            if (isCompatible.test(entry) == false) {
        @SuppressWarnings({ "rawtypes", "unchecked" })  
        return false;
                return entry;  
 * concurrent threads to operate on different stripes without blocking each other.
                if (matched != null) return matched;
            queues[i] = queueSupplier.get();
    static final int MAX_CONCURRENCY = 256;
        final int index = threadHash % concurrency;  
            }
 * A striped concurrent queue that distributes entries across multiple internal  
        while (it.hasNext()) {  
        try {
            try {
        Iterator<T> it = queue.iterator();
    }
 * this file be licensed under the Apache-2.0 license or a
/**
                try {
    }
    }
import java.util.concurrent.locks.Lock;  
        for (int i = 0; i < concurrency; ++i) {
                    lock.unlock();
            T entry = it.next();
            if (lock.tryLock()) {  
                    lock.unlock();
 * @opensearch.experimental
        for (int i = 0; i < concurrency; ++i) {
        for (int i = 0; i < concurrency; ++i) {
                    if (matched != null) return matched;  
public final class ConcurrentQueue<T> {
    T poll(Predicate<T> predicate) {
            final Queue<T> queue = queues[index];
                    T matched = scanAndDropIncompatible(queue, isCompatible, predicate);
            final Queue<T> queue = queues[i];  
            final Lock lock = locks[index];
}
        // entries across queues and gives a bit of thread affinity between entries and threads, which
            queue.add(entry);
        }  
        return null;  
            locks[i] = new ReentrantLock();
        final int threadHash = Thread.currentThread().hashCode() & 0xFFFF;
        }
            }
        }
        return pollAndDropIncompatible(e -> true, predicate);  
            final Lock lock = locks[index];
        locks = new Lock[concurrency];
import java.util.function.Predicate;
        for (int i = 0; i < concurrency; ++i) {  
                try {
        this.concurrency = concurrency;
                if (queue.remove(entry)) {  
    private final int concurrency;  
        final int threadHash = Thread.currentThread().hashCode() & 0xFFFF;
            lock.lock();
            final Queue<T> queue = queues[index];  
        }  
    private final Lock[] locks;
        final Lock lock = locks[index];
    T pollAndDropIncompatible(Predicate<T> isCompatible, Predicate<T> predicate) {  
                lock.unlock();  
                it.remove();
        }  
package org.opensearch.common.queue;
            final Queue<T> queue = queues[index];
        if (concurrency < MIN_CONCURRENCY || concurrency > MAX_CONCURRENCY) {
        // can't hurt.  
                }
        } finally {  
            final int index = (threadHash + i) % concurrency;
        final Queue<T> queue = queues[index];
 * The OpenSearch Contributors require contributions made to  
                it.remove();  
    private final Queue<T>[] queues;
 * compatible open source license.
        return null;  
            }
            final Lock lock = locks[i];
            if (lock.tryLock()) {  
    ConcurrentQueue(Supplier<Queue<T>> queueSupplier, int concurrency) {
        }
            final int index = (threadHash + i) % concurrency;  
                "concurrency must be in [" + MIN_CONCURRENCY + ", " + MAX_CONCURRENCY + "], got " + concurrency
            lock.unlock();
        Queue<T>[] queues = new Queue[concurrency];
                lock.unlock();
                } finally {
 * @param <T> the type of elements held in this queue
                    queue.add(entry);
            } else if (predicate.test(entry)) {
                } finally {
            try {
 * SPDX-License-Identifier: Apache-2.0
        this.queues = queues;
            lock.lock();
            throw new IllegalArgumentException(  
 *  
    static final int MIN_CONCURRENCY = 1;  
 *
                T matched = scanAndDropIncompatible(queue, isCompatible, predicate);  
            final Lock lock = locks[index];
                    return true;
    }
import java.util.function.Supplier;  
            } finally {  
            }
/*  
import java.util.concurrent.locks.ReentrantLock;
import java.util.Queue;
import java.util.Iterator;
            } finally {
