        return checkoutAll(t -> {});
    }
 *   <li>{@link #getAndLock()} — returns any available item, or creates a new one</li>
     * @throws IllegalStateException if the pool is closed
        }
    }
    /**
        T item = itemSupplier.get();
import java.io.Closeable;
     *
        }
 * The pool supports two modes of checkout:
    }
public final class LockablePool<T extends Lockable> implements Iterable<T>, Closeable {
                }
        availableItems.remove(item);
     * the predicate are removed from the available queue but remain tracked by the pool.
    private final Set<T> items;
    public synchronized Iterator<T> iterator() {
        }
    /**
import java.util.function.Supplier;
    }
    /**
     *
                        checkedOutItems.add(item);
                try {
import java.util.ArrayList;
     *
     * @return unmodifiable list of all items locked by current thread
     */
    private volatile boolean closed;
    }
            lockedItems.add(item);
     *
import java.util.Iterator;
        return null;
     * @param item the item to release
                        availableItems.remove(item);
     * Locks and polls a compatible item from the pool in a single pass. Items that fail
    /**
     * @throws IllegalStateException if the pool is closed
     * @param queueSupplier supplier for the underlying queue instances
        item.lock();
 * SPDX-License-Identifier: Apache-2.0
     * @throws IllegalArgumentException if the item is not registered in this pool
     */
    }
     * Lock and checkout all items from the pool.
    public void close() throws IOException {
}
import java.util.function.Consumer;
     * If no compatible item is found, a new one is created using the constructor's item supplier.
    /**
     * Evaluates all items in the pool and locks the first one matching the predicate.
        this.itemSupplier = Objects.requireNonNull(itemSupplier, "itemSupplier must not be null");
            throw new IllegalArgumentException("Item is not registered in this pool");
 * The OpenSearch Contributors require contributions made to
        ensureOpen();
     * @param isCompatible predicate to test each item
                    item.unlock();
 * A thread-safe pool of {@link Lockable} items backed by a {@link LockableConcurrentQueue}.
    private final LockableConcurrentQueue<T> availableItems;
     *
    /**
                        onCheckout.accept(item);
                item.lock();
    public T getAndLock() {
 *       but remain tracked by the pool and included in {@link #checkoutAll()}.</li>
     *
        ensureOpen();
import java.io.IOException;
        List<T> checkedOutItems = new ArrayList<>();
    @Override
     * @return a {@link Closeable} that unlocks the item when closed, or null if no match found
 * compatible open source license.
        return List.copyOf(items).iterator();
/*
                    return item::unlock;
     * still owns the item itself and is responsible for closing any underlying resources.
import java.util.Queue;
 * this file be licensed under the Apache-2.0 license or a
    public LockablePool(Supplier<T> itemSupplier, Supplier<Queue<T>> queueSupplier, int concurrency) {
 */
 * <p>
    public T getAndLock(Predicate<T> isCompatible) {
     *                   while every item lock is still held by the current thread.
 */
     */
     */
            throw new IllegalStateException("LockablePool is already closed");
        }
        this.availableItems = new LockableConcurrentQueue<>(queueSupplier, concurrency);
            }
    public void releaseAndUnlock(T item) {
    }
     *
        for (T item : this) {
                    }
     * @param isCompatible predicate to test each polled item
        return Collections.unmodifiableList(checkedOutItems);
    }
        return items.contains(item);
     * unlocks the item when closed, intended for use with try-with-resources. The caller
 *   <li>{@link #getAndLock(Predicate)} — returns a compatible item (per predicate),
        if (items.remove(item) == false) {
        items.add(item);
    }
     * as the removal: no other thread can poll, lock, or operate on them between
 *
        if (closed) {
     */
import java.util.Set;
     * the time they leave the pool and the time the callback returns. Use this
        assert isRegistered(item) : "Pool doesn't know about this item";
        this.closed = true;
     * @throws IllegalStateException if the pool is closed
 *       rejecting incompatible ones. Rejected items are removed from the available queue
    public synchronized Releasable checkout(T item) {
        List<T> lockedItems = new ArrayList<>();
     */
     * @param item item to validate
    }
     * @return a releasable whose {@code close()} unlocks the item
     * @return true if the item is part of this pool
        this.items = Collections.newSetFromMap(new IdentityHashMap<>());
     *
            item.lock();
    private final Supplier<T> itemSupplier;
     */
    }
    private synchronized T fetchItem() {
 * Items are locked on checkout and unlocked on release, ensuring safe reuse across threads.
        ensureOpen();
import java.util.Collections;
import org.opensearch.common.lease.Releasable;
     * @throws IllegalStateException if the pool is closed
        return item::unlock;
package org.opensearch.common.queue;
                item.unlock();
        return getAndLock(e -> true);
     * Check if an item is part of this pool.
     * @return unmodifiable list of all items locked by current thread.
    public List<T> checkoutAll(Consumer<T> onCheckout) {
    @Override
 *
     * must be atomic with the pool checkout.
    public List<T> checkoutAll() {
     * @param onCheckout callback invoked with the unmodifiable list of checked-out items
        availableItems.addAndUnlock(item);
    public synchronized boolean isRegistered(T item) {
     */
        ensureOpen();
        return Objects.requireNonNullElseGet(availableItems.lockAndPollWithRejects(isCompatible), this::fetchItem);
import java.util.Objects;
     * Locks and polls an item from the pool, or creates a new one if none are available.
    }
    /**
                } finally {
     * Releases the given item back to this pool for reuse.
                if (isRegistered(item)) {
        }
    public Closeable evaluateAllAndLock(Predicate<T> isCompatible) {
     * Removes a single already-locked item from the pool. The returned {@link Releasable}
import java.util.List;
     * when a side effect (e.g. removing a paired resource from another registry)
 * @param <T> the pooled item type, must implement {@link Lockable}
    /**
import java.util.IdentityHashMap;
     *
     */
            if (isCompatible.test(item)) {
     * @param concurrency   the concurrency level (number of stripes)
    private void ensureOpen() {
     * @return a locked item
/**
     * <p>The callback observes the checked-out items in the same critical section
     *
            }
 * </ul>
                    if (isRegistered(item) && items.remove(item)) {
                }
import java.util.function.Predicate;
        synchronized (this) {
        return item;
     * @param itemSupplier  factory for creating new items when the pool is empty
     *
    /**
        for (T item : this) {
            for (T item : lockedItems) {
    }
     * Lock and checkout all items from the pool.
 * <ul>
     * @param item the locked item to remove
     * @return a locked, compatible item
     *
     * Creates a new pool.
