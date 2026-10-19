        public Builder<K, V> setKeySerializer(Serializer<K, byte[]> keySerializer) {  
                .setDeliberateDelay(delay)
     * Provides a iterator over keys.
        return value;
            currentKey = null;
        }  
        @SuppressWarnings({ "unchecked" })  
            try {  
    public static class MockDiskCacheFactory implements Factory {
    }
        private final RemovalListener<K, V> removalListener;
        private K currentKey;  
        } else {  
        final int keyValueSize;
                return loader.load(key);
import org.opensearch.common.cache.store.config.CacheConfig;
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
    }  
            if (!hasNext()) {  
        public MockDiskCacheFactory(long delay, int maxSize, boolean statsTrackingEnabled, int keyValueSize) {
    }
            this.cache = cache;
    static class CacheKeyIterator<K, V> implements Iterator<K> {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.cache.CacheType;
            } catch (Exception e) {
        V value = this.cache.remove(key);
import org.opensearch.common.cache.ICacheKey;  
    @Override
    }  
     * @param <K> Type of key
            this.valueSerializer = valueSerializer;  
            this.statsTrackingEnabled = statsTrackingEnabled;
    public void put(ICacheKey<K> key, V value) {  
    long delay;
    }  
import org.opensearch.common.cache.ICache;
        @Override
    }
            assert config.getKeySerializer() != null;
            this.statsHolder.decrementItems(List.of());  
            if (config.getMaxSizeInBytes() > 0) {  
        V value = cache.computeIfAbsent(key, key1 -> {
 * The OpenSearch Contributors require contributions made to  
            this.removalListener = removalListener;
        }
            cache.remove(currentKey);
    public MockDiskCache(int maxSize, long delay, RemovalListener<ICacheKey<K>, V> removalListener, boolean statsTrackingEnabled) {
        // right number of entries, unless statsTrackingEnabled is false
    int maxSize;
        public K next() {
            return currentKey;
            return;
    public long count() {
        private final Map<K, V> cache;
        public CacheKeyIterator(Map<K, V> cache, RemovalListener<K, V> removalListener) {
    @Override
        final int maxSize;  
    @Override  
    @Override  
        this.cache.clear();
        public void remove() {  
        this.removalListener = removalListener;
    }
    }  
        if (statsTrackingEnabled) {
import org.opensearch.common.cache.LoadAwareCacheLoader;
        }  
            return NAME;
        return null;
            this.statsHolder = NoopCacheStatsHolder.getInstance();
    @Override  
            return this;
        }  
    public ImmutableCacheStatsHolder stats(String[] levels) {
        final boolean statsTrackingEnabled;
    }
    @Override  
                (Serializer<K, byte[]>) config.getKeySerializer()
                .setValueSerializer((Serializer<V, byte[]>) config.getValueSerializer())  
            }  
    }  
            this.statsHolder = new DefaultCacheStatsHolder(List.of(), "mock_disk_cache");
        int maxSize;
        try {  
        long delay;
    public static class Builder<K, V> extends ICacheBuilder<K, V> {
                                                // in TSC  
import java.util.concurrent.ConcurrentHashMap;
    }  
        this.maxSize = maxSize;  
    Map<ICacheKey<K>, V> cache;  
import org.opensearch.common.cache.RemovalListener;
                builder.setMaxSize(maxSize);  
        this.cache = new ConcurrentHashMap<ICacheKey<K>, V>();  
 * SPDX-License-Identifier: Apache-2.0
            }
            }
        }  
    private final RemovalListener<ICacheKey<K>, V> removalListener;
    @Override
        public boolean hasNext() {  
            )
        @Override
            return builder.build();
            return this;
        }
    private final CacheStatsHolder statsHolder; // Only update for number of entries; this is only used to test statsTrackingEnabled logic
import java.util.NoSuchElementException;
     */
                throw new RuntimeException(e);  
            currentKey = entry.getKey();
            MockDiskCache.Builder<K, V> builder = (Builder<K, V>) new Builder<K, V>().setKeySerializer(  
        @Override  
        }
        public <K, V> ICache<K, V> create(CacheConfig<K, V> config, CacheType cacheType, Map<String, Factory> cacheFactories) {
    /**  
        }  
            // For mock disk cache, size refers to number of entries for simplicity.
            this.entryIterator = cache.entrySet().iterator();  
            V value = cache.get(currentKey);
        }
    public V get(ICacheKey<K> key) {  
            removalListener.onRemoval(new RemovalNotification<>(key, value, RemovalReason.INVALIDATED));
            return new MockDiskCache<K, V>(this.maxSize, this.delay, this.getRemovalListener(), getStatsTrackingEnabled());
                .setStatsTrackingEnabled(config.getStatsTrackingEnabled());  
            this.removalListener.onRemoval(new RemovalNotification<>(key, value, RemovalReason.EVICTED));
    public ImmutableCacheStatsHolder stats() {  
        return () -> new CacheKeyIterator<>(cache, removalListener);  
                throw new IllegalStateException("No element to remove");
        }
    @Override
    public void refresh() {}  
            Map.Entry<K, V> entry = entryIterator.next();  
        private final Iterator<Map.Entry<K, V>> entryIterator;  
        Serializer<K, byte[]> keySerializer;  
        final long delay;
        this.cache.put(key, value);
            // cache would require.  
 */  
    @Override
        }
            this.keySerializer = keySerializer;
    @Override
import java.util.List;
import org.opensearch.common.cache.stats.CacheStatsHolder;  
        return statsHolder.getImmutableCacheStatsHolder(null);  
        return value;  
 *
        @Override
    }
     * @param <V> Type of value  
            } else {
import java.util.Iterator;
        public static final String NAME = "mockDiskCache";
                .setRemovalListener(config.getRemovalListener())
            throw new RuntimeException(e);  
        public String getCacheName() {  
            return entryIterator.hasNext();
    public void invalidate(ICacheKey<K> key) {
            this.removalListener.onRemoval(new RemovalNotification<>(currentKey, value, RemovalReason.INVALIDATED));  
            this.keyValueSize = keyValueSize;
        });
}
        public ICache<K, V> build() {
        Serializer<V, byte[]> valueSerializer;
        }
    public Iterable<ICacheKey<K>> keys() {
import org.opensearch.common.cache.stats.NoopCacheStatsHolder;  
import org.opensearch.common.cache.stats.DefaultCacheStatsHolder;
    }
        if (this.cache.size() >= maxSize) { // For simplification
        }
public class MockDiskCache<K, V> implements ICache<K, V> {
            this.maxSize = maxSize;  
import java.util.Map;  
        @Override
    public void invalidateAll() {  
            this.delay = millis;
        }
            return this;  
    }  
import org.opensearch.common.cache.serializer.Serializer;
        V value = cache.get(key);
            Thread.sleep(delay);
            if (currentKey == null) {
        public Builder<K, V> setDeliberateDelay(long millis) {
import org.opensearch.common.cache.RemovalNotification;  
        this.delay = delay;
            // As we can't directly IT with the tiered cache and ehcache, check that we receive non-null serializers, as an ehcache disk
import org.opensearch.common.cache.store.builders.ICacheBuilder;
        // To allow testing of statsTrackingEnabled logic in TSC, return a dummy ImmutableCacheStatsHolder with the
package org.opensearch.cache.common.tier;
import org.opensearch.common.cache.RemovalReason;
    }  
        return this.cache.size();
                throw new NoSuchElementException();
    @Override
        }  
        @Override
            this.maxSize = maxSize;  
            }
        public Builder<K, V> setMaxSize(int maxSize) {
            this.delay = delay;
/*  
 * compatible open source license.
    public void close() {  
        }
        public Builder<K, V> setValueSerializer(Serializer<V, byte[]> valueSerializer) {
        return maxSize;
        if (value != null) {  
    long getMaximumWeight() {
        } catch (InterruptedException e) {
    public V computeIfAbsent(ICacheKey<K> key, LoadAwareCacheLoader<ICacheKey<K>, V> loader) {
                builder.setMaxSize(Math.toIntExact(config.getMaxSizeInBytes()));
        this.statsHolder.incrementItems(List.of());  
            assert config.getValueSerializer() != null;
            return this;
