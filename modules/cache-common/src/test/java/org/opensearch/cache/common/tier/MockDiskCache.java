    }
            this.statsHolder = new DefaultCacheStatsHolder(List.of(), "mock_disk_cache");
            return this;
        });
                builder.setMaxSize(Math.toIntExact(config.getMaxSizeInBytes()));
        }
        }
    @Override
    }
        } catch (InterruptedException e) {
        }
    @Override
import java.util.Map;
        V value = cache.computeIfAbsent(key, key1 -> {
            }
     * @param <V> Type of value
                builder.setMaxSize(maxSize);
        public CacheKeyIterator(Map<K, V> cache, RemovalListener<K, V> removalListener) {
    public Iterable<ICacheKey<K>> keys() {
import java.util.Iterator;
            this.keySerializer = keySerializer;
        public Builder<K, V> setKeySerializer(Serializer<K, byte[]> keySerializer) {
import org.opensearch.common.cache.ICacheKey;
    }
    }
        public void remove() {
    }
        return null;
                throw new IllegalStateException("No element to remove");
        @Override
                .setValueSerializer((Serializer<V, byte[]>) config.getValueSerializer())
            throw new RuntimeException(e);
        }
            this.keyValueSize = keyValueSize;
                .setRemovalListener(config.getRemovalListener())
import org.opensearch.common.cache.store.config.CacheConfig;
    public V computeIfAbsent(ICacheKey<K> key, LoadAwareCacheLoader<ICacheKey<K>, V> loader) {
public class MockDiskCache<K, V> implements ICache<K, V> {
    public void invalidateAll() {
        final int keyValueSize;
    }
        @Override
     */
            // For mock disk cache, size refers to number of entries for simplicity.
            }
        public Builder<K, V> setDeliberateDelay(long millis) {
        try {
        public MockDiskCacheFactory(long delay, int maxSize, boolean statsTrackingEnabled, int keyValueSize) {
    Map<ICacheKey<K>, V> cache;
                throw new NoSuchElementException();
        }
            return currentKey;
    public void invalidate(ICacheKey<K> key) {
        this.cache = new ConcurrentHashMap<ICacheKey<K>, V>();
    long delay;
import org.opensearch.common.cache.store.builders.ICacheBuilder;
                return loader.load(key);
            this.delay = millis;
    public V get(ICacheKey<K> key) {
    }
        @Override
import java.util.NoSuchElementException;
        }
import org.opensearch.common.cache.RemovalNotification;
        long delay;
        public ICache<K, V> build() {
        public String getCacheName() {
            if (currentKey == null) {
            // As we can't directly IT with the tiered cache and ehcache, check that we receive non-null serializers, as an ehcache disk
 * SPDX-License-Identifier: Apache-2.0
        if (statsTrackingEnabled) {
            assert config.getKeySerializer() != null;
        private final Iterator<Map.Entry<K, V>> entryIterator;
        int maxSize;
        this.cache.put(key, value);
        }
}
        private final RemovalListener<K, V> removalListener;
            cache.remove(currentKey);
    @Override
import org.opensearch.common.cache.CacheType;
    static class CacheKeyIterator<K, V> implements Iterator<K> {
        this.delay = delay;
        }
    public void close() {
        final int maxSize;
 *
        } else {
import org.opensearch.common.cache.stats.NoopCacheStatsHolder;
    private final CacheStatsHolder statsHolder; // Only update for number of entries; this is only used to test statsTrackingEnabled logic
        @SuppressWarnings({ "unchecked" })
        public Builder<K, V> setValueSerializer(Serializer<V, byte[]> valueSerializer) {
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
        }
                (Serializer<K, byte[]>) config.getKeySerializer()
            return;
            } else {
            // cache would require.
        return statsHolder.getImmutableCacheStatsHolder(null);
    }
            } catch (Exception e) {
            return builder.build();
    public void refresh() {}
                                                // in TSC
 * The OpenSearch Contributors require contributions made to
            removalListener.onRemoval(new RemovalNotification<>(key, value, RemovalReason.INVALIDATED));
        this.cache.clear();
import org.opensearch.common.cache.stats.CacheStatsHolder;
        return () -> new CacheKeyIterator<>(cache, removalListener);
            return entryIterator.hasNext();
import org.opensearch.common.cache.RemovalReason;
        return maxSize;
        public Builder<K, V> setMaxSize(int maxSize) {
        }
            assert config.getValueSerializer() != null;
        this.maxSize = maxSize;
    long getMaximumWeight() {
                throw new RuntimeException(e);
        final long delay;
import java.util.concurrent.ConcurrentHashMap;
            if (config.getMaxSizeInBytes() > 0) {
            return this;
import org.opensearch.common.cache.serializer.Serializer;
        private final Map<K, V> cache;
            currentKey = entry.getKey();
    }
        this.statsHolder.incrementItems(List.of());
    }
            currentKey = null;
import java.util.List;
            this.cache = cache;
            MockDiskCache.Builder<K, V> builder = (Builder<K, V>) new Builder<K, V>().setKeySerializer(
        @Override
        public K next() {
        @Override
 * compatible open source license.
import org.opensearch.common.cache.RemovalListener;
            this.statsHolder.decrementItems(List.of());
            return NAME;
        @Override
        Serializer<K, byte[]> keySerializer;
 */
            this.valueSerializer = valueSerializer;
            this.statsHolder = NoopCacheStatsHolder.getInstance();
            this.maxSize = maxSize;
            Map.Entry<K, V> entry = entryIterator.next();
    }
    public void put(ICacheKey<K> key, V value) {
        if (value != null) {
import org.opensearch.common.cache.stats.DefaultCacheStatsHolder;
    @Override
import org.opensearch.common.cache.ICache;
import org.opensearch.common.cache.LoadAwareCacheLoader;
     * Provides a iterator over keys.
        }
            this.removalListener.onRemoval(new RemovalNotification<>(currentKey, value, RemovalReason.INVALIDATED));
        return value;
            this.statsTrackingEnabled = statsTrackingEnabled;
            Thread.sleep(delay);
    public static class MockDiskCacheFactory implements Factory {
                .setStatsTrackingEnabled(config.getStatsTrackingEnabled());
        V value = this.cache.remove(key);
        }
        V value = cache.get(key);
    public MockDiskCache(int maxSize, long delay, RemovalListener<ICacheKey<K>, V> removalListener, boolean statsTrackingEnabled) {
            return this;
        public boolean hasNext() {
    public ImmutableCacheStatsHolder stats() {
        public static final String NAME = "mockDiskCache";
    @Override
            this.delay = delay;
            V value = cache.get(currentKey);
    public ImmutableCacheStatsHolder stats(String[] levels) {
     * @param <K> Type of key
        }
            return new MockDiskCache<K, V>(this.maxSize, this.delay, this.getRemovalListener(), getStatsTrackingEnabled());
        this.removalListener = removalListener;
package org.opensearch.cache.common.tier;
    public static class Builder<K, V> extends ICacheBuilder<K, V> {
            return this;
    }
/*
            }
    @Override
    @Override
        // right number of entries, unless statsTrackingEnabled is false
    int maxSize;
        final boolean statsTrackingEnabled;
            this.removalListener.onRemoval(new RemovalNotification<>(key, value, RemovalReason.EVICTED));
            this.entryIterator = cache.entrySet().iterator();
 * this file be licensed under the Apache-2.0 license or a
        }
        // To allow testing of statsTrackingEnabled logic in TSC, return a dummy ImmutableCacheStatsHolder with the
            }
    @Override
    /**
            try {
    @Override
        if (this.cache.size() >= maxSize) { // For simplification
    }
        Serializer<V, byte[]> valueSerializer;
        public <K, V> ICache<K, V> create(CacheConfig<K, V> config, CacheType cacheType, Map<String, Factory> cacheFactories) {
            if (!hasNext()) {
    @Override
    public long count() {
        }
        return value;
            this.removalListener = removalListener;
            this.maxSize = maxSize;
        return this.cache.size();
    private final RemovalListener<ICacheKey<K>, V> removalListener;
            )
    }
        private K currentKey;
        }
    }
    @Override
                .setDeliberateDelay(delay)
