     *
        if (node.value != newValue) { // replace if new value is not the same instance as existing value
                    statsCounter.recordActiveUsage(node.value, node.weight, node.pinned, false);
        try {
/*
    public Integer getRef(K key) {
            Node<K, V> node = data.get(key);
                    // Remapping function asked for removal, but nothing to remove
        lock.lock();
    private void removeNode(K key) {
        lock.lock();
        lock.lock();
                if (newValue == null) {
import java.util.Map;
 * <a href="https://github.com/opensearch-project/OpenSearch/issues/4964#issuecomment-1421689586">this comment</a> and
            lru.clear();
            statsCounter.recordEviction(node.value, node.weight);
                final V newValue = remappingFunction.apply(key, node.value);
            final Node<K, V> node = data.get(key);
    }
            removeNode(key);
        Objects.requireNonNull(key);
    private final Weigher<V> weigher;
    @Override
    @Override
     * @param key
                closedEntries++;
import java.util.function.BiFunction;
    /** the LRU list */
    public void unpin(K key) {
                    // if it was active, we should remove its weight from active usage
                node.pinned = true;
            this.weight = weight;
                if (node.evictable()) {
import java.util.HashMap;
        lock.lock();
                node.refCount--;
            int closedEntries = 0;
            }
            // hit
 */
        final Iterator<Node<K, V>> iterator = lru.values().iterator();
        } finally {
        try {
                    addNode(key, false, newValue);
            statsCounter.recordRemoval(node.value, node.pinned, node.weight);
     * @return the combined pinned weight of the values in this cache.
                }
        }
                    // if it becomes evictable, we should add it to eviction list
                    .append(" [RefCount: ")
        Objects.requireNonNull(key);
        }
        }
import org.apache.logging.log4j.LogManager;
            if (node.evictable()) {
                    statsCounter.recordMisses(key, 1);
            if (node == null) {
            lock.unlock();
    public long usage() {
 * <li>Cache maintains it's capacity using LRU Eviction while ignoring entries with {@link Node#refCount} greater than 0 from eviction</li>
                listener.onRemoval(new RemovalNotification<>(node.key, node.value, RemovalReason.EXPLICIT));
                lru.remove(node.key);
    }
        }
                return null;
        }
            lock.unlock();
        } finally {
    public V put(K key, V value) {
        try {
/**
    private void evict() {
            return node.value;
        V value;
                listener.onRemoval(new RemovalNotification<>(node.key, node.value, RemovalReason.RESTARTED));
                data.remove(node.key, node);
        lock.lock();
        try {
    @Override
                statsCounter.recordMisses(key, 1);
            } else {
                if (keyPredicate != null && !keyPredicate.test(node.key)) {
                iterator.remove();
                    .append(entry.getValue().refCount)
        try {
            this.key = key;
            while (iterator.hasNext()) {
            this.pinned = false;
                String file = path.substring(path.lastIndexOf('/'));
            return ((refCount == 0) && (pinned == false));
                    return newValue;
                node.pinned = false;
            final Iterator<Node<K, V>> iterator = lru.values().iterator();
                    // since its pinned, we should remove it from eviction list
        incRef(node.key);
package org.opensearch.index.store.remote.utils.cache;
import org.opensearch.common.cache.RemovalNotification;
        try {
            lock.unlock();
                }
        evict();
        int refCount;
        } finally {
                    lru.put(node.key, node);
                if (node.evictable()) {
import org.opensearch.common.cache.Weigher;
    public void decRef(K key) {
    @Override
            }
import java.util.Iterator;
        } finally {
        long weight;
        lock.lock();
        }
    private final RemovalListener<K, V> listener;
 * SPDX-License-Identifier: Apache-2.0
                    replaceNode(node, newValue);
    public long pinnedUsage() {
            incRef(key);
    private static final Logger logger = LogManager.getLogger(LRUCache.class);
            }
            statsCounter.recordReplacement(oldValue, newValue, oldWeight, newWeight, node.refCount > 0, node.pinned);
    }
        this.listener = listener;
import java.util.concurrent.locks.ReentrantLock;
        } finally {
    }
        } finally {
                iterator.remove();
 */
                addNode(key, false, value);
            statsCounter.resetActiveUsage();
            lock.unlock();
        } finally {
            listener.onRemoval(new RemovalNotification<>(node.key, node.value, RemovalReason.EXPLICIT));
            final V oldValue = node.value;
 * </ul>
            if (node == null) {
                    lru.put(node.key, node);
    }
    private void addNode(K key, boolean pinned, V value) {
                }
            final Iterator<Node<K, V>> iterator = data.values().iterator();
                    lru.remove(node.key);
        try {
                }
                iterator.remove();
                    // if it was inactive, we should add the weight to active usage from now
        } finally {
 * <li>Supports RemovalListener</li>
                    evict(); // If cache usage is already overflowing trigger evictions
    public void remove(K key) {
    /**
                if (node.evictable()) {
    public V get(K key) {
            lock.unlock();
                    return newValue;
        incRef(key);
        lock.lock();
            lock.unlock();
            iterator.remove();
                node.refCount++;
import java.util.Objects;
        this.weigher = weigher;
            if (node != null && (node.pinned == true)) {
            }
import org.opensearch.common.cache.RemovalListener;
 * <ul>
        public boolean evictable() {
            final long oldWeight = node.weight;
        try {
    @Override
    }
            lock.unlock();
            // miss
 * <li>Cache capacity is computed as the sum of all {@link Weigher#weightOf(Object)}</li>
        }
 * The OpenSearch Contributors require contributions made to
    @Override
        } finally {
            }
                listener.onRemoval(new RemovalNotification<>(node.key, node.value, RemovalReason.EXPLICIT));
                    statsCounter.recordActiveUsage(node.value, node.weight, node.pinned, true);
        Objects.requireNonNull(remappingFunction);
        }
        Objects.requireNonNull(key);
        }
            while (iterator.hasNext()) {
            return statsCounter.activeUsage();
        // Attempts to evict entries from the cache if it exceeds the maximum
        return statsCounter.usage() >= capacity;
    }
            lock.unlock();
            while (iterator.hasNext()) {
            if (node != null && node.refCount > 0) {
        lock.lock();
            return statsCounter.snapshot();
import java.util.function.Predicate;
            this.value = value;
            // update stats
                statsCounter.recordPinnedUsage(node.value, node.weight, true);
            }
            lock.unlock();
        try {
     * Unpins the key in the cache, allowing it to be evicted.
        Objects.requireNonNull(key);
        lock.lock();
    }
        if (node != null) {
            }
            this.refCount = 0;
        Objects.requireNonNull(value);
                Node<K, V> node = iterator.next();
    private final long capacity;
            Node<K, V> node = data.get(key);
            logger.trace("Reference cleanup completed - Total entries: {}", closedEntries);
        lock.lock();
                return null;
            Node<K, V> node = data.get(key);
        this.statsCounter = new FileStatsCounter<>();
    }
 * So this is the best effort lazy cache to maintain capacity. <br>
        try {
    }
                    removeNode(key);
            lock.unlock();
                }
                    return null;
        statsCounter.recordUsage(value, weight, pinned, false);
                }
        final long weight = weigher.weightOf(value);
    }
    @Override
 * <a href="https://github.com/opensearch-project/OpenSearch/issues/6225">this ticket for future plans</a>
 * <li>This cache has max capacity and this cache will best-effort maintain it's size to not exceed defined capacity</li>
     */
            listener.onRemoval(new RemovalNotification<>(node.key, node.value, RemovalReason.CAPACITY));
        }
    }
    /**
        Objects.requireNonNull(key);
}
                return oldValue;
import org.opensearch.common.cache.RemovalReason;
import org.opensearch.index.store.remote.utils.cache.stats.FileStatsCounter;
                    continue;
                } else {
            }
            }
            lock.unlock();
                allFiles.append(file)
    @Override
        try {
    private final StatsCounter<K, V> statsCounter;
    }
    @Override
                }
    public long prune(Predicate<K> keyPredicate) {
    public void closeIndexInputReferences() {
 * As long as {@link Node#refCount} greater than 0 or is pinned then node is not eligible for eviction.
    private final HashMap<K, Node<K, V>> data;
     *
            node.weight = newWeight;
    }
            lock.unlock();
                if (node.pinned == false) {
    @Override
            lock.unlock();
            lock.unlock();
    @Override
            Node<K, V> node = data.get(key);
                    return null;
     * @param key
import org.opensearch.index.store.remote.utils.cache.stats.IRefCountedCacheStats;
        try {
 * @opensearch.internal
                final V newValue = remappingFunction.apply(key, null);
        // capacity.
    }
        this.capacity = capacity;
     * Returns the pinned usage of this cache.
    }
            node.value = newValue;
            data.remove(node.key, node);
        }
     *
        }
        } finally {
            }
        while (hasOverflowed() && iterator.hasNext()) {
        } finally {
                if (node.refCount == 0) {
            lock.unlock();
 * this file be licensed under the Apache-2.0 license or a
    @Override
            statsCounter.recordHits(key, node.value, node.pinned, 1);
    }
                    .append(entry.getValue().weight)
                    // since it become active, we should remove it from eviction list
                    .append(" ]\n");
        data.put(key, newNode);
        lock.lock();
    }
            if (node.pinned) {
                }
        this.lock = new ReentrantLock();
 *
            if (allFiles.length() > 1) {
import java.util.LinkedHashMap;
    @Override
                }
 * For more context why in-house cache implementation exist look at
    @Override
 * <li>Supports Cache Pinning.</li>
    private void replaceNode(Node<K, V> node, V newValue) {
        }
    }
        lock.lock();
        }
 * @see RefCountedCache
        boolean pinned;
        try {
            Node<K, V> node = data.get(key);
                statsCounter.recordActiveUsage(node.value, node.weight, node.pinned, true);
        try {
    public long size() {
                    statsCounter.recordPinnedUsage(node.value, node.weight, false);
            return null;
        }
                statsCounter.recordPinnedUsage(node.value, node.weight, true);
    private boolean hasOverflowed() {
            for (Map.Entry<K, Node<K, V>> entry : data.entrySet()) {
                }
            lock.unlock();
    private final LinkedHashMap<K, Node<K, V>> lru;
            }
    }
        lock.lock();
        return sum;
            final Node<K, V> node = iterator.next();
    public IRefCountedCacheStats stats() {
            final Iterator<Node<K, V>> iterator = data.values().iterator();
            }
            if (node != null) {
    private final ReentrantLock lock;
    }
        }
    // To be used only in testing framework.
     * Pins the key in the cache, preventing it from being evicted.
        final K key;
 * compatible open source license.
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
    // To be used only for debugging purposes
                return node.refCount;
import org.apache.logging.log4j.Logger;
            }
            }
    }
                if (node.refCount == 0) {
    }
                logger.trace(() -> "Cache entries : " + allFiles);
        evict();
    }
    public LRUCache(long capacity, RemovalListener<K, V> listener, Weigher<V> weigher) {
    /**
                statsCounter.recordRemoval(node.value, node.pinned, node.weight);
            listener.onRemoval(new RemovalNotification<>(node.key, oldValue, RemovalReason.REPLACED));
                    statsCounter.recordHits(key, node.value, node.pinned, 1);
        }
                } else {
            }
import org.opensearch.index.store.remote.utils.cache.stats.StatsCounter;
                    .append(" , Weight: ")
    public long activeUsage() {
            if (node != null) {
        Node(K key, V value, long weight) {
        try {
            return statsCounter.usage();
        return data.size();
            return statsCounter.pinnedUsage();
        } finally {
            final StringBuilder allFiles = new StringBuilder("\n");
    }
        } finally {
        this.lru = new LinkedHashMap<>();
    public void logCurrentState() {
        }
        }
                Node<K, V> node = iterator.next();
            if (node != null) {
        try {
        lock.lock();
                if (newValue == null) {
            lock.unlock();
    public void pin(K key) {
        } finally {
        Objects.requireNonNull(key);
        this.data = new HashMap<>();
            // Notify the listener only if the entry was evicted
                replaceNode(node, value);
    public void clear() {
        Objects.requireNonNull(key);
class LRUCache<K, V> implements RefCountedCache<K, V> {
                String path = entry.getKey().toString();
            Node<K, V> node = data.get(key);
        Objects.requireNonNull(key);
        Node<K, V> node = data.remove(key);
     */
 * This cache implementation meets these requirements:
        lock.lock();
 *
     */
        } finally {
                final Node<K, V> node = iterator.next();
        }
            // update the value and weight
                    lru.remove(node.key, node);
        lock.lock();
        lock.lock();
            if (node.refCount > 0) {
                sum += node.weight;
            Node<K, V> node = data.get(key);
        } finally {
 * <br>
 * LRU implementation of {@link RefCountedCache}.
                    // if it becomes evictable, we should add it to eviction list
            } else {
            statsCounter.resetUsage();
                final V oldValue = node.value;
        try {
        long sum = 0L;
    public void incRef(K key) {
        Objects.requireNonNull(key);
        }
    static class Node<K, V> {
        }
                statsCounter.recordRemoval(node.value, node.pinned, node.weight);
        Node<K, V> newNode = new Node<>(key, value, weight);
            final long newWeight = weigher.weightOf(newValue);
    @Override
                if (node.evictable()) {
            if (node != null) {
        } finally {
            statsCounter.resetPinnedUsage();
    @Override
            }
