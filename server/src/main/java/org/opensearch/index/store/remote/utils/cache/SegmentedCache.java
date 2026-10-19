            AggregateRefCountedCacheStats aggregateStats = (AggregateRefCountedCacheStats) cache.stats();
    private final int segmentMask;  
        for (RefCountedCache<K, V> cache : table) {
         * exceed it temporarily.
     * @return the weigher used for IndexInput  
 * @param <K> type of the key
        for (RefCountedCache<K, V> cache : table) {
        Weigher<V> weigher;
            checkArgument(capacity >= 0, "capacity has to be greater or equal to 0");  
            size += cache.size();  
            return 1;  
            cache.clear();
    }
    enum SingletonWeigher implements Weigher<Object> {
        }
         * implementation performs internal sizing to try to accommodate this many
     */  
         * @throws NullPointerException if the listener is null
    public long capacity() {  
    private final long perSegmentCapacity;  
     * provides a flexible approach for constructing customized instances with
        public void onRemoval(RemovalNotification<Object, Object> notification) {
        }
        h = ((h >>> 16) ^ h) * 0x45d9f3b;  
         *  
     * Returns the pinned usage of this cache.  
        h = (h >>> 16) ^ h;
        }
         *                               not set
 * SPDX-License-Identifier: Apache-2.0
                ((LRUCache<K, V>) cache).logCurrentState();  
        public SegmentedCache<K, V> build() {  
        return segmentFor(key).put(key, value);
        final int segments = ceilingNextPowerOfTwo(builder.concurrencyLevel);
        final RefCountedCacheStats totalFullFileCacheStats = new RefCountedCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);  
     * @return the combined pinned weight of the values in this cache.
    }  
    @Override
     */  
         * Creates a new {@link SegmentedCache} instance.
            this.capacity = capacity;
    }
    }
        }
    @Override
    @Override
            totalOverallCacheStats.accumulate(aggregateStats.getOverallCacheStats());  
        INSTANCE;
        }  
            this.weigher = weigher;
     * A listener that ignores all notifications.
            ((LRUCache<K, V>) cache).closeIndexInputReferences();  
        return table[h & HASH_BITS & segmentMask];  
        );
            totalPinnedFileCacheStats.accumulate(aggregateStats.getPinnedFileCacheStats());  
            Objects.requireNonNull(listener);
        }  
    private final Weigher<V> weigher;
        if (key == null) throw new NullPointerException();
        this.segmentMask = segments - 1;  
 */
        h = ((h >>> 16) ^ h) * 0x45d9f3b;
         */
            totalOverallCacheStats,
        this.weigher = builder.weigher;  
        }
         * an entry is removed.
    @Override
        }
            return this;  
        for (RefCountedCache<K, V> cache : table) {  
    }  
        this.capacity = perSegmentCapacity * segments;
            this.concurrencyLevel = concurrencyLevel;
        segmentFor(key).incRef(key);
    @Override
 * compatible open source license.
    private static final int ceilingNextPowerOfTwo(int x) {
        /**  
         * @throws NullPointerException if the weigher is null
        @Override
    final RefCountedCache<K, V>[] newSegmentArray(int size) {
     * a named parameter syntax.  
    public void remove(K key) {
        public Builder<K, V> weigher(Weigher<V> weigher) {  
}
import java.util.Objects;
    /**  
    public static final class Builder<K, V> {
    public long size() {  
    }
            listener = (RemovalListener<K, V>) DiscardingListener.INSTANCE;  
        // From Hacker's Delight, Chapter 3, Harry S. Warren Jr.  
        int h = key.hashCode();
    @Override
         *  
        return 1 << (Integer.SIZE - Integer.numberOfLeadingZeros(x - 1));
    @Override
import java.util.function.BiFunction;
    }  
        RemovalListener<K, V> listener;  
    @Override
            }
        return sum;
        return segmentFor(key).get(key);
     * @return the capacity per internal segment
            i++;
         * @throws IllegalArgumentException if the maximumWeightedCapacity is
        }
    }  
        return totalPinnedUsage;
    /**
        return new AggregateRefCountedCacheStats(  
        if (key == null || value == null) throw new NullPointerException();  
        static final int DEFAULT_CONCURRENCY_LEVEL = Runtime.getRuntime().availableProcessors();
        long totalPinnedUsage = 0L;  
 * Segmented {@link LRUCache} to offer concurrent access with less contention.  
            totalFullFileCacheStats.accumulate(aggregateStats.getFullFileCacheStats());
            }  
    public void pin(K key) {  
    }
    }  
         * threads (default Runtime.getRuntime().availableProcessors()).
        long capacity;
    @Override
        for (int i = 0; i < table.length; i++) {
        final RefCountedCacheStats totalOverallCacheStats = new RefCountedCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    // To be used only for debugging purposes
         * Specifies an algorithm to determine how many the units of capacity a
package org.opensearch.index.store.remote.utils.cache;
            return this;
        long sum = 0L;
        long totalUsage = 0L;
    private final long capacity;
    public IRefCountedCacheStats stats() {  
        final RefCountedCacheStats totalPinnedFileCacheStats = new RefCountedCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
        }
    }  
         * @param weigher the algorithm to determine a value's weight  
        return capacity;
    RefCountedCache<K, V> segmentFor(K key) {  
            this.listener = listener;  
     */
        return perSegmentCapacity;
        return totalUsage;
    @Override
            totalBlockFileCacheStats,  
     */
    public V get(K key) {
import java.util.function.Predicate;  
    public long getPerSegmentCapacity() {
        this.table = newSegmentArray(segments);
    /**
         */
        this.perSegmentCapacity = (builder.capacity + (segments - 1)) / segments;
         *                                  negative  
    private static final Logger logger = LogManager.getLogger(SegmentedCache.class);
    @Override
        }  
        }
        private static void checkArgument(boolean expression, String message) {  
    // To be used only in testing framework.  
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
    @Override
        if (key == null) throw new NullPointerException();
        return new Builder<>();  
            IRefCountedCacheStats c = cache.stats();
    }  
    public void closeIndexInputReferences() {
    public Integer getRef(K key) {  
        }
        public Builder<K, V> capacity(long capacity) {
import org.opensearch.index.store.remote.utils.cache.stats.AggregateRefCountedCacheStats;  
import org.opensearch.index.store.remote.utils.cache.stats.RefCountedCacheStats;
    public long activeUsage() {
    public static <K, V> Builder<K, V> builder() {
        }
         * @throws IllegalStateException if the maximum weighted capacity was  
        return totalActiveUsage;
    public void decRef(K key) {  
        for (RefCountedCache<K, V> cache : table) {
 *
        segmentFor(key).remove(key);
        for (RefCountedCache<K, V> cache : table) {
            capacity = -1;  
        public Builder<K, V> concurrencyLevel(int concurrencyLevel) {  
            totalPinnedFileCacheStats
        return segmentFor(key).compute(key, remappingFunction);
     * A builder that creates {@link SegmentedCache} instances. It
        // Based on this answer https://stackoverflow.com/a/12996028
    }  
    }
    @Override
     */
         * Ensures that the argument expression is true.
        segmentFor(key).decRef(key);
    public void logCurrentState() {  
    }  
        }
            totalBlockFileCacheStats.accumulate(aggregateStats.getBlockFileCacheStats());
            Objects.requireNonNull(weigher);
            checkArgument(concurrencyLevel > 0, "concurrencyLevel has to be greater than 0");
         * key-value pairs by giving each entry a weight of 1.
        }
        }  
     */  
            table[i] = new LRUCache<>(perSegmentCapacity, builder.listener, builder.weigher);
        return segmentFor(key).getRef(key);
        for (RefCountedCache<K, V> cache : table) {
    @Override
     *
        Builder() {
         * Specifies the maximum weighted capacity to coerce the map to and may
         */
         *  
    /**  
        return size;
    public long prune() {  
        return new RefCountedCache[size];  
        }
                throw new IllegalArgumentException(message);
        segmentFor(key).unpin(key);
         * @throws IllegalArgumentException if the concurrencyLevel is less than or  
            if (!expression) {
            if (cache.size() > 0) {  
import org.opensearch.common.cache.Weigher;
    public void clear() {
     * The array of bins. Size is always a power of two.
            return this;  
    }
        for (RefCountedCache<K, V> cache : table) {  
     */  
            totalPinnedUsage += c.pinnedUsage();  
         * @param listener the object to forward removed entries to
        if (key == null) throw new NullPointerException();  
            totalUsage += c.usage();
        @SuppressWarnings("unchecked")
    public long usage() {  
    public SegmentedCache(Builder<K, V> builder) {
    }  
    }
    }
            IRefCountedCacheStats c = cache.stats();
        int concurrencyLevel;  
        }
        if (key == null) throw new NullPointerException();
         */  
        }
        long size = 0;
        public Builder<K, V> listener(RemovalListener<K, V> listener) {
         */
    public V put(K key, V value) {
            return new SegmentedCache<>(this);
    public Weigher<V> getWeigher() {
public class SegmentedCache<K, V> implements RefCountedCache<K, V> {  
        if (key == null) throw new NullPointerException();
import org.apache.logging.log4j.Logger;
        segmentFor(key).pin(key);
    @Override
        for (RefCountedCache<K, V> cache : table) {
 * this file be licensed under the Apache-2.0 license or a
    }
            totalFullFileCacheStats,
         *                         threads
            sum += cache.prune(keyPredicate);  
         *
                logger.trace(() -> "SegmentedCache " + segmentIndex);
        return sum;
    public long pinnedUsage() {
 */  
        for (RefCountedCache<K, V> cache : table) {
         *
    /**
        long totalActiveUsage = 0L;  
            totalActiveUsage += c.activeUsage();  
    public long prune(Predicate<K> keyPredicate) {  
        /**  
        if (key == null || remappingFunction == null) throw new NullPointerException();  
        INSTANCE;
         * Specifies the estimated number of concurrently updating threads. The  
        if (key == null) throw new NullPointerException();  
        /**
            sum += cache.prune();  
 *  
    }
    /**
    }  
    private static final int HASH_BITS = 0x7fffffff;  
        return weigher;  
    }  
            concurrencyLevel = DEFAULT_CONCURRENCY_LEVEL;
import org.opensearch.index.store.remote.utils.cache.stats.IRefCountedCacheStats;
    public void incRef(K key) {  
            weigher = (Weigher<V>) SingletonWeigher.INSTANCE;
    }
                final int segmentIndex = i;
 * @opensearch.internal
        final RefCountedCacheStats totalBlockFileCacheStats = new RefCountedCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
         * @param capacity the weighted threshold to bound the map by
            return this;
        public long weightOf(Object value) {
    }  
        /**
import org.apache.logging.log4j.LogManager;
    @SuppressWarnings("unchecked")
    }  
 * The OpenSearch Contributors require contributions made to  
    @Override
        long sum = 0L;
 * @param <V> type of th value
    private final RefCountedCache<K, V>[] table;
        /**  
         * Specifies an optional listener that is registered for notification when
         * value consumes. The default algorithm bounds the map by the number of  
    }
        for (RefCountedCache<K, V> cache : table) {
     * Mask value for indexing into segments.
/**
         * @param concurrencyLevel the estimated number of concurrently updating
import org.opensearch.common.cache.RemovalNotification;
    public void unpin(K key) {  
            IRefCountedCacheStats c = cache.stats();  
    enum DiscardingListener implements RemovalListener<Object, Object> {
import org.opensearch.common.cache.RemovalListener;  
/*  
         */
    /**
        if (key == null) throw new NullPointerException();
    }
    }
        int i = 0;
         *                                  equal to zero
        /**  
    @Override
        @Override
