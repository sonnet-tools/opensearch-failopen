        final long weight = weigher.weightOf(value);
    public void pin(K key) {  
                }  
            lock.unlock();  
 */  
        try {  
        }  
            }
 * <a href="https://github.com/opensearch-project/OpenSearch/issues/6225">this ticket for future plans</a>
    }
            incRef(key);
 * So this is the best effort lazy cache to maintain capacity. <br>
    }  
    }
    private void addNode(K key, boolean pinned, V value) {
        lock.lock();  
 * <li>Supports Cache Pinning.</li>  
            lock.unlock();  
            int closedEntries = 0;
        try {  
            } else {  
        statsCounter.recordUsage(value, weight, pinned, false);
    private void replaceNode(Node<K, V> node, V newValue) {
            if (node.refCount > 0) {  
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
    }
            final Node<K, V> node = iterator.next();
    @Override
            this.value = value;
        this.statsCounter = new FileStatsCounter<>();
            if (node != null) {  
 * @opensearch.internal
            if (allFiles.length() > 1) {
        lock.lock();
                }
        evict();
        }
                closedEntries++;
     *  
     * @return the combined pinned weight of the values in this cache.
            lock.unlock();
                }
        Node<K, V> newNode = new Node<>(key, value, weight);  
 * <li>Cache maintains it's capacity using LRU Eviction while ignoring entries with {@link Node#refCount} greater than 0 from eviction</li>
                final V newValue = remappingFunction.apply(key, node.value);
            this.weight = weight;
        Objects.requireNonNull(key);
        }
 * <li>Supports RemovalListener</li>
        }
                node.refCount++;  
    @Override
    }
                if (node.evictable()) {
     * Unpins the key in the cache, allowing it to be evicted.
    // To be used only for debugging purposes
    /**
        if (node.value != newValue) { // replace if new value is not the same instance as existing value
            listener.onRemoval(new RemovalNotification<>(node.key, node.value, RemovalReason.EXPLICIT));  
    }
        this.listener = listener;
        lock.lock();
     */
            }  
                statsCounter.recordRemoval(node.value, node.pinned, node.weight);
            final Iterator<Node<K, V>> iterator = data.values().iterator();
            lock.unlock();
                    // Remapping function asked for removal, but nothing to remove
    public long activeUsage() {
    public void logCurrentState() {  
        // capacity.
        try {
            // Notify the listener only if the entry was evicted  
                replaceNode(node, value);
import java.util.function.BiFunction;
            statsCounter.recordHits(key, node.value, node.pinned, 1);  
class LRUCache<K, V> implements RefCountedCache<K, V> {
        Objects.requireNonNull(key);
            return statsCounter.snapshot();
                final V newValue = remappingFunction.apply(key, null);  
            return statsCounter.usage();  
        } finally {  
            }  
    private final long capacity;  
import org.opensearch.common.cache.RemovalNotification;
            final long oldWeight = node.weight;
        try {
        Objects.requireNonNull(key);  
            // update stats
            }
    private void evict() {
            this.pinned = false;
            lock.unlock();  
            }
        } finally {
 * <br>  
            // miss
    }  
            lock.unlock();  
 *
                }  
                    return newValue;
        }  
    }
        } finally {
        lock.lock();
            // hit
    }
        lock.lock();
                final V oldValue = node.value;
                }
        } finally {
                if (node.evictable()) {
import org.apache.logging.log4j.LogManager;
    @Override
    public long usage() {  
                }
                iterator.remove();
            lock.unlock();
import java.util.concurrent.locks.ReentrantLock;
                statsCounter.recordPinnedUsage(node.value, node.weight, true);
    private final RemovalListener<K, V> listener;
            statsCounter.resetActiveUsage();
        } finally {
        }  
        this.weigher = weigher;  
    }  
import org.opensearch.index.store.remote.utils.cache.stats.FileStatsCounter;
                    addNode(key, false, newValue);
                    removeNode(key);  
/*  
    /** the LRU list */
            if (node != null && (node.pinned == true)) {
    private void removeNode(K key) {  
    }
            iterator.remove();
                listener.onRemoval(new RemovalNotification<>(node.key, node.value, RemovalReason.RESTARTED));
        } finally {
        while (hasOverflowed() && iterator.hasNext()) {  
            return null;  
    }
        int refCount;
                final Node<K, V> node = iterator.next();
                iterator.remove();  
    public V put(K key, V value) {
            statsCounter.recordRemoval(node.value, node.pinned, node.weight);
            lock.unlock();
        Node(K key, V value, long weight) {
            }
                    continue;  
            node.weight = newWeight;
                String path = entry.getKey().toString();
        } finally {
                    evict(); // If cache usage is already overflowing trigger evictions
        this.lru = new LinkedHashMap<>();
        }
    private final LinkedHashMap<K, Node<K, V>> lru;
        } finally {  
                    .append(" ]\n");  
                sum += node.weight;
            // update the value and weight  
            }
                if (newValue == null) {
 * @see RefCountedCache  
        lock.lock();  
            lock.unlock();
    private static final Logger logger = LogManager.getLogger(LRUCache.class);
                return null;
     */
            lock.unlock();  
import java.util.function.Predicate;  
                    statsCounter.recordPinnedUsage(node.value, node.weight, false);
/**
    @Override
                    statsCounter.recordActiveUsage(node.value, node.weight, node.pinned, true);
    private final HashMap<K, Node<K, V>> data;
    }
        } finally {
        Objects.requireNonNull(key);
        this.data = new HashMap<>();
                    statsCounter.recordHits(key, node.value, node.pinned, 1);  
    }  
import org.apache.logging.log4j.Logger;
        try {
            this.key = key;  
        }
import org.opensearch.common.cache.RemovalReason;
            }
        try {  
            Node<K, V> node = data.get(key);
        V value;  
     */
                statsCounter.recordPinnedUsage(node.value, node.weight, true);
    /**
    @Override  
            final V oldValue = node.value;  
    }
        try {  
import java.util.Objects;  
            final long newWeight = weigher.weightOf(newValue);
        Objects.requireNonNull(key);
                if (node.pinned == false) {  
                    .append(" , Weight: ")
        Objects.requireNonNull(remappingFunction);
        try {  
    public long size() {  
    }
            statsCounter.resetPinnedUsage();
            while (iterator.hasNext()) {  
    @Override  
            node.value = newValue;
    }
            } else {
 * SPDX-License-Identifier: Apache-2.0
    public void incRef(K key) {
    public long prune(Predicate<K> keyPredicate) {
    public void unpin(K key) {
 * compatible open source license.
        try {
    }  
                allFiles.append(file)
        try {
            return statsCounter.pinnedUsage();
                return node.refCount;
    public Integer getRef(K key) {
        }
        Objects.requireNonNull(value);
            if (node == null) {  
            Node<K, V> node = data.get(key);  
            removeNode(key);  
                    return null;
                    // since it become active, we should remove it from eviction list
        long weight;
        try {  
        try {  
        } finally {
     * @param key
        public boolean evictable() {
        lock.lock();
 * LRU implementation of {@link RefCountedCache}.  
        lock.lock();
            return ((refCount == 0) && (pinned == false));
        Objects.requireNonNull(key);  
            lock.unlock();
        // Attempts to evict entries from the cache if it exceeds the maximum  
            return statsCounter.activeUsage();
        lock.lock();
    @Override
    @Override  
                } else {
        incRef(node.key);
        lock.lock();  
            while (iterator.hasNext()) {  
}  
        }
        Objects.requireNonNull(key);
            final Iterator<Node<K, V>> iterator = data.values().iterator();
            if (node != null) {
        lock.lock();  
                node.refCount--;  
            lru.clear();
            if (node.pinned) {
                Node<K, V> node = iterator.next();
        final K key;
                    .append(entry.getValue().refCount)  
    public void decRef(K key) {  
            Node<K, V> node = data.get(key);  
    // To be used only in testing framework.  
import java.util.LinkedHashMap;
                }
    public void remove(K key) {
            if (node != null) {
            Node<K, V> node = data.get(key);
    private final Weigher<V> weigher;  
                if (newValue == null) {
                return null;  
    @Override
                addNode(key, false, value);
import org.opensearch.index.store.remote.utils.cache.stats.IRefCountedCacheStats;
            statsCounter.recordEviction(node.value, node.weight);
            if (node != null) {  
package org.opensearch.index.store.remote.utils.cache;
            listener.onRemoval(new RemovalNotification<>(node.key, oldValue, RemovalReason.REPLACED));  
        }
        this.lock = new ReentrantLock();  
    /**  
    @Override
        lock.lock();
    @Override
     * @param key  
     * Pins the key in the cache, preventing it from being evicted.
            return node.value;
            }
        }  
            }
            if (node.evictable()) {  
    }
 * <ul>
        return data.size();
                if (node.refCount == 0) {
                String file = path.substring(path.lastIndexOf('/'));  
     *
 * </ul>
                node.pinned = true;  
        } finally {
                }
    public LRUCache(long capacity, RemovalListener<K, V> listener, Weigher<V> weigher) {  
        }
            Node<K, V> node = data.get(key);
                    .append(entry.getValue().weight)
import java.util.HashMap;
            while (iterator.hasNext()) {  
                    replaceNode(node, newValue);
        } finally {
 * <li>This cache has max capacity and this cache will best-effort maintain it's size to not exceed defined capacity</li>  
            lock.unlock();  
        data.put(key, newNode);
    private boolean hasOverflowed() {
                    return newValue;
                    return null;  
 */  
                if (node.evictable()) {
            data.remove(node.key, node);
        this.capacity = capacity;
 * <li>Cache capacity is computed as the sum of all {@link Weigher#weightOf(Object)}</li>
                }
 *
                listener.onRemoval(new RemovalNotification<>(node.key, node.value, RemovalReason.EXPLICIT));  
        Objects.requireNonNull(key);  
 * The OpenSearch Contributors require contributions made to  
                    // since its pinned, we should remove it from eviction list
        try {
        }
        }  
    public void closeIndexInputReferences() {
        } finally {  
        lock.lock();  
        }  
                    lru.remove(node.key, node);  
        Node<K, V> node = data.remove(key);
    @Override  
                if (node.refCount == 0) {
                return oldValue;  
    }
            }
    @Override  
    public void clear() {
                if (node.evictable()) {
        Objects.requireNonNull(key);  
        return sum;
            lock.unlock();
                    .append(" [RefCount: ")
    }
                statsCounter.recordRemoval(node.value, node.pinned, node.weight);  
 * For more context why in-house cache implementation exist look at  
import java.util.Iterator;  
            lock.unlock();  
                statsCounter.recordMisses(key, 1);
    }
import org.opensearch.common.cache.RemovalListener;  
        incRef(key);  
                lru.remove(node.key);
                    lru.put(node.key, node);
    public V get(K key) {  
            }
            Node<K, V> node = data.get(key);
        try {
                    // if it was inactive, we should add the weight to active usage from now  
                    // if it becomes evictable, we should add it to eviction list  
            final Iterator<Node<K, V>> iterator = lru.values().iterator();
        } finally {
        try {
        return statsCounter.usage() >= capacity;
            logger.trace("Reference cleanup completed - Total entries: {}", closedEntries);  
            }
            this.refCount = 0;  
    }
                    statsCounter.recordActiveUsage(node.value, node.weight, node.pinned, false);
    @Override  
                Node<K, V> node = iterator.next();
            final StringBuilder allFiles = new StringBuilder("\n");  
        lock.lock();
        final Iterator<Node<K, V>> iterator = lru.values().iterator();
import org.opensearch.index.store.remote.utils.cache.stats.StatsCounter;  
                iterator.remove();
        }
     * Returns the pinned usage of this cache.
 * This cache implementation meets these requirements:
    public long pinnedUsage() {
                    lru.remove(node.key);  
                } else {
                logger.trace(() -> "Cache entries : " + allFiles);  
                    // if it becomes evictable, we should add it to eviction list  
        } finally {
            if (node != null && node.refCount > 0) {
            listener.onRemoval(new RemovalNotification<>(node.key, node.value, RemovalReason.CAPACITY));  
                listener.onRemoval(new RemovalNotification<>(node.key, node.value, RemovalReason.EXPLICIT));
        boolean pinned;  
                    lru.put(node.key, node);
            if (node == null) {
        } finally {
        } finally {
        }
 * As long as {@link Node#refCount} greater than 0 or is pinned then node is not eligible for eviction.
        lock.lock();
                if (keyPredicate != null && !keyPredicate.test(node.key)) {
        }  
            lock.unlock();  
            }
            lock.unlock();
        try {  
                node.pinned = false;  
        lock.lock();
    @Override
            lock.unlock();
        try {
    @Override
            statsCounter.recordReplacement(oldValue, newValue, oldWeight, newWeight, node.refCount > 0, node.pinned);
    private final StatsCounter<K, V> statsCounter;
                data.remove(node.key, node);  
    static class Node<K, V> {  
                statsCounter.recordActiveUsage(node.value, node.weight, node.pinned, true);
    public IRefCountedCacheStats stats() {
        lock.lock();
        }
        }
            Node<K, V> node = data.get(key);
                    // if it was active, we should remove its weight from active usage  
            for (Map.Entry<K, Node<K, V>> entry : data.entrySet()) {
    private final ReentrantLock lock;
     *  
    }
    }  
                    statsCounter.recordMisses(key, 1);  
            }  
import org.opensearch.common.cache.Weigher;  
            statsCounter.resetUsage();  
 * this file be licensed under the Apache-2.0 license or a
                }
        long sum = 0L;
import java.util.Map;
 * <a href="https://github.com/opensearch-project/OpenSearch/issues/4964#issuecomment-1421689586">this comment</a> and
        }
        evict();  
            }
        if (node != null) {
            final Node<K, V> node = data.get(key);
