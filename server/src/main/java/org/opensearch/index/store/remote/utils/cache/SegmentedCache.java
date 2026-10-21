    }
        final RefCountedCacheStats totalBlockFileCacheStats = new RefCountedCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int concurrencyLevel;
        int h = key.hashCode();
        @SuppressWarnings("unchecked")
    @Override
        long totalActiveUsage = 0L;
         * @param capacity the weighted threshold to bound the map by
    @Override
         * value consumes. The default algorithm bounds the map by the number of
         * Specifies the estimated number of concurrently updating threads. The
         * @throws IllegalArgumentException if the maximumWeightedCapacity is
     */
            this.capacity = capacity;
    public long prune(Predicate<K> keyPredicate) {
 *
            return this;
    public void unpin(K key) {
        }
    }
/*
                throw new IllegalArgumentException(message);
         */
        Weigher<V> weigher;
        this.segmentMask = segments - 1;
        /**
         *                         threads
     */
    public long pinnedUsage() {
 * Segmented {@link LRUCache} to offer concurrent access with less contention.
        return segmentFor(key).put(key, value);
        INSTANCE;
            totalPinnedFileCacheStats
 */
        }
        this.table = newSegmentArray(segments);
        for (RefCountedCache<K, V> cache : table) {
        return weigher;
         * an entry is removed.
    }
        long totalUsage = 0L;
    @Override
    public Weigher<V> getWeigher() {
    }
            sum += cache.prune();
        final RefCountedCacheStats totalPinnedFileCacheStats = new RefCountedCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
import java.util.function.Predicate;
        return sum;
            totalUsage += c.usage();
        /**
         * @param weigher the algorithm to determine a value's weight
    }
    /**
        int i = 0;
    @Override
         * exceed it temporarily.
    @Override
 * compatible open source license.
        public long weightOf(Object value) {
     */
                ((LRUCache<K, V>) cache).logCurrentState();
        if (key == null || value == null) throw new NullPointerException();
    public long usage() {
    @Override
    enum SingletonWeigher implements Weigher<Object> {
    }
    @Override
         *                                  negative
    }
            this.concurrencyLevel = concurrencyLevel;
            totalBlockFileCacheStats,
     * Mask value for indexing into segments.
    private static final Logger logger = LogManager.getLogger(SegmentedCache.class);
            return new SegmentedCache<>(this);
    }
 */
    @Override
    }
    /**
        for (RefCountedCache<K, V> cache : table) {
         * Specifies an algorithm to determine how many the units of capacity a
            totalFullFileCacheStats,
            table[i] = new LRUCache<>(perSegmentCapacity, builder.listener, builder.weigher);
package org.opensearch.index.store.remote.utils.cache;
    public static <K, V> Builder<K, V> builder() {
        final RefCountedCacheStats totalOverallCacheStats = new RefCountedCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        /**
         *
        /**
         *
            totalOverallCacheStats.accumulate(aggregateStats.getOverallCacheStats());
        for (RefCountedCache<K, V> cache : table) {
        }
            sum += cache.prune(keyPredicate);
         * key-value pairs by giving each entry a weight of 1.
    }
            IRefCountedCacheStats c = cache.stats();
        h = ((h >>> 16) ^ h) * 0x45d9f3b;
            }
    // To be used only for debugging purposes
        this.capacity = perSegmentCapacity * segments;
    /**
        segmentFor(key).remove(key);
         *
            totalActiveUsage += c.activeUsage();
    public long activeUsage() {
        for (RefCountedCache<K, V> cache : table) {
        }
     * provides a flexible approach for constructing customized instances with
        return segmentFor(key).compute(key, remappingFunction);
        return perSegmentCapacity;
        }
            concurrencyLevel = DEFAULT_CONCURRENCY_LEVEL;
    /**
            IRefCountedCacheStats c = cache.stats();
    public void remove(K key) {
        // From Hacker's Delight, Chapter 3, Harry S. Warren Jr.
        }
    private static final int ceilingNextPowerOfTwo(int x) {
     * The array of bins. Size is always a power of two.
import org.opensearch.index.store.remote.utils.cache.stats.RefCountedCacheStats;
         *
            AggregateRefCountedCacheStats aggregateStats = (AggregateRefCountedCacheStats) cache.stats();
    public SegmentedCache(Builder<K, V> builder) {
        final int segments = ceilingNextPowerOfTwo(builder.concurrencyLevel);
         *                               not set
    }
    public long size() {
    }
    /**
     * Returns the pinned usage of this cache.
        this.weigher = builder.weigher;
         */
        long size = 0;
     * @return the combined pinned weight of the values in this cache.
            Objects.requireNonNull(listener);
            Objects.requireNonNull(weigher);
    public V get(K key) {
     */
import org.opensearch.index.store.remote.utils.cache.stats.IRefCountedCacheStats;
        public void onRemoval(RemovalNotification<Object, Object> notification) {
        return totalActiveUsage;
        h = ((h >>> 16) ^ h) * 0x45d9f3b;
/**
        }
    public long getPerSegmentCapacity() {
            ((LRUCache<K, V>) cache).closeIndexInputReferences();
        INSTANCE;
        @Override
    @Override
    }
import org.opensearch.common.cache.RemovalNotification;
    }
            this.listener = listener;
    private final int segmentMask;
            checkArgument(concurrencyLevel > 0, "concurrencyLevel has to be greater than 0");
     */
import java.util.function.BiFunction;
    }
         */
        if (key == null) throw new NullPointerException();
    public Integer getRef(K key) {
        return totalUsage;
        public Builder<K, V> listener(RemovalListener<K, V> listener) {
            totalBlockFileCacheStats.accumulate(aggregateStats.getBlockFileCacheStats());
         * Specifies an optional listener that is registered for notification when
         *
        long sum = 0L;
         * implementation performs internal sizing to try to accommodate this many
        public Builder<K, V> weigher(Weigher<V> weigher) {
        }
    public V put(K key, V value) {
public class SegmentedCache<K, V> implements RefCountedCache<K, V> {
            totalOverallCacheStats,
        segmentFor(key).decRef(key);
         * Specifies the maximum weighted capacity to coerce the map to and may
    enum DiscardingListener implements RemovalListener<Object, Object> {
        segmentFor(key).pin(key);
    }
    }
        for (int i = 0; i < table.length; i++) {
        }
     * A builder that creates {@link SegmentedCache} instances. It
            totalPinnedFileCacheStats.accumulate(aggregateStats.getPinnedFileCacheStats());
         * @throws NullPointerException if the weigher is null
            totalFullFileCacheStats.accumulate(aggregateStats.getFullFileCacheStats());
    public void incRef(K key) {
            cache.clear();
    @Override
    @Override
    /**
    private final RefCountedCache<K, V>[] table;
    public long capacity() {
    public IRefCountedCacheStats stats() {
 * @opensearch.internal
        return table[h & HASH_BITS & segmentMask];
     */
        }
        if (key == null || remappingFunction == null) throw new NullPointerException();
    }
    }
     *
            checkArgument(capacity >= 0, "capacity has to be greater or equal to 0");
    @SuppressWarnings("unchecked")
        Builder() {
        for (RefCountedCache<K, V> cache : table) {
            IRefCountedCacheStats c = cache.stats();
         */
    }
 * @param <V> type of th value
        public Builder<K, V> capacity(long capacity) {
        public SegmentedCache<K, V> build() {
    public long prune() {
            size += cache.size();
        long totalPinnedUsage = 0L;
            if (!expression) {
        return new Builder<>();
        final RefCountedCacheStats totalFullFileCacheStats = new RefCountedCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
import org.apache.logging.log4j.LogManager;
        for (RefCountedCache<K, V> cache : table) {
     * A listener that ignores all notifications.
    public static final class Builder<K, V> {
        }
 * @param <K> type of the key
        return new RefCountedCache[size];
        for (RefCountedCache<K, V> cache : table) {
    @Override
        if (key == null) throw new NullPointerException();
         *                                  equal to zero
    private static final int HASH_BITS = 0x7fffffff;
 * this file be licensed under the Apache-2.0 license or a
     * a named parameter syntax.
    private final long capacity;
            if (cache.size() > 0) {
            return this;
        if (key == null) throw new NullPointerException();
    }
        long capacity;
        long sum = 0L;
        return segmentFor(key).getRef(key);
        return size;
         * Ensures that the argument expression is true.
    }
        segmentFor(key).unpin(key);
         * @throws IllegalArgumentException if the concurrencyLevel is less than or
            }
         * @throws NullPointerException if the listener is null
    private final long perSegmentCapacity;
         * @param concurrencyLevel the estimated number of concurrently updating
        if (key == null) throw new NullPointerException();
     */
    @Override
         * @param listener the object to forward removed entries to
import org.apache.logging.log4j.Logger;
import org.opensearch.common.cache.RemovalListener;
                final int segmentIndex = i;
    final RefCountedCache<K, V>[] newSegmentArray(int size) {
        return sum;
        /**
        static final int DEFAULT_CONCURRENCY_LEVEL = Runtime.getRuntime().availableProcessors();
    }
        /**
        }
        }
        }
            listener = (RemovalListener<K, V>) DiscardingListener.INSTANCE;
        for (RefCountedCache<K, V> cache : table) {
        }
        return capacity;
            weigher = (Weigher<V>) SingletonWeigher.INSTANCE;
    public void clear() {
     * @return the capacity per internal segment
}
        }
        public Builder<K, V> concurrencyLevel(int concurrencyLevel) {
    @Override
import org.opensearch.common.cache.Weigher;
            return 1;
         */
    // To be used only in testing framework.
        return segmentFor(key).get(key);
 *
    }
    }
        h = (h >>> 16) ^ h;
        if (key == null) throw new NullPointerException();
    public void pin(K key) {
        @Override
    private final Weigher<V> weigher;
import org.opensearch.index.store.remote.utils.cache.stats.AggregateRefCountedCacheStats;
         * Creates a new {@link SegmentedCache} instance.
    }
import java.util.Objects;
    RefCountedCache<K, V> segmentFor(K key) {
        for (RefCountedCache<K, V> cache : table) {
        if (key == null) throw new NullPointerException();
    }
    @Override
    public void logCurrentState() {
        segmentFor(key).incRef(key);
        );
        }
        }
        if (key == null) throw new NullPointerException();
    @Override
            return this;
    @Override
            return this;
 * SPDX-License-Identifier: Apache-2.0
        return 1 << (Integer.SIZE - Integer.numberOfLeadingZeros(x - 1));
     * @return the weigher used for IndexInput
    }
    public void decRef(K key) {
        }
                logger.trace(() -> "SegmentedCache " + segmentIndex);
         * @throws IllegalStateException if the maximum weighted capacity was
    /**
    }
    public void closeIndexInputReferences() {
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        for (RefCountedCache<K, V> cache : table) {
         * threads (default Runtime.getRuntime().availableProcessors()).
        }
        return totalPinnedUsage;
            totalPinnedUsage += c.pinnedUsage();
        this.perSegmentCapacity = (builder.capacity + (segments - 1)) / segments;
        RemovalListener<K, V> listener;
        return new AggregateRefCountedCacheStats(
 * The OpenSearch Contributors require contributions made to
            capacity = -1;
    }
         */
            i++;
        // Based on this answer https://stackoverflow.com/a/12996028
        private static void checkArgument(boolean expression, String message) {
            this.weigher = weigher;
