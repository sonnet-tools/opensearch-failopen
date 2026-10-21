    public V get(ICacheKey<K> key) {
    private final boolean statsTrackingEnabled;
                cacheType.getSettingPrefix()
    @Override
 *
                .setRemovalListener(config.getRemovalListener());
 * compatible open source license.
    @Override
            .weigher(builder.getWeigher())
            cacheStatsHolder.incrementMisses(key.dimensions);
     * Factory to create OpenSearchOnheap cache.
    }
import org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings;
    private final ToLongBiFunction<ICacheKey<K>, V> weigher;
import org.opensearch.common.cache.store.builders.ICacheBuilder;
public class OpenSearchOnHeapCache<K, V> implements ICache<K, V>, RemovalListener<ICacheKey<K>, V> {
    private final CacheStatsHolder cacheStatsHolder;
/*
    public static class OpenSearchOnHeapCacheFactory implements Factory {
                but is not passed in from the IRC if a store name setting is present.
        this.dimensionNames = Objects.requireNonNull(builder.dimensionNames, "Dimension names can't be null");
    }
                builder.setNumberOfSegments(-1); // By default it will use 256 segments.
    private final Cache<ICacheKey<K>, V> cache;
 * @param <K> Type of key.
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
    @Override
import org.opensearch.common.cache.settings.CacheSettings;
 * @opensearch.experimental
        public <K, V> ICache<K, V> create(CacheConfig<K, V> config, CacheType cacheType, Map<String, Factory> cacheFactories) {
        }
    /**
        this.removalListener = builder.getRemovalListener();
    }
    }
            cache.getWeigher().applyAsLong(notification.getKey(), notification.getValue())
        if (RemovalReason.EVICTED.equals(notification.getRemovalReason())
    /**
import org.opensearch.common.cache.ICache;
            cache.invalidate(key);
 * this file be licensed under the Apache-2.0 license or a
        this.statsTrackingEnabled = builder.getStatsTrackingEnabled();
            || RemovalReason.CAPACITY.equals(notification.getRemovalReason())) {
                /*
    /**
            this.dimensionNames = dimensionNames;
 * The OpenSearch Contributors require contributions made to
        }
        return value;
import static org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings.MAXIMUM_SIZE_IN_BYTES_KEY;
            if (config.getMaxSizeInBytes() > 0) {
     */
            cacheStatsHolder.incrementItems(key.dimensions);
            cacheStatsHolder.incrementMisses(key.dimensions);
        cache.refresh();
        public static final String NAME = "opensearch_onheap";
        removalListener.onRemoval(notification);
    public V computeIfAbsent(ICacheKey<K> key, LoadAwareCacheLoader<ICacheKey<K>, V> loader) throws Exception {
            long maxSizeInBytes = ((ByteSizeValue) settingList.get(MAXIMUM_SIZE_IN_BYTES_KEY).get(settings)).getBytes();
    public ImmutableCacheStatsHolder stats(String[] levels) {
            this.cacheStatsHolder = NoopCacheStatsHolder.getInstance();
     * Builder object
                // For backward compatibility as the user intent is to use older settings.
            }
        }
        }
                .setStatsTrackingEnabled(statsTrackingEnabled)
            .setMaximumWeight(builder.getMaxWeightInBytes())
import org.opensearch.common.settings.Settings;
    }
    public Iterable<ICacheKey<K>> keys() {
        }
    @Override
    }
                .setExpireAfterAccess(((TimeValue) settingList.get(EXPIRE_AFTER_ACCESS_KEY).get(settings)))
        );
            notification.getKey().dimensions,
     */
        if (value != null) {
import org.opensearch.common.cache.Cache;
            cacheStatsHolder.incrementEvictions(notification.getKey().dimensions);
    }
            ICacheBuilder<K, V> builder = new Builder<K, V>().setDimensionNames(config.getDimensionNames())
    private final long maximumWeight;
    public void close() {}
package org.opensearch.common.cache.store;
            cacheStatsHolder.incrementHits(key.dimensions);
import java.util.Objects;
import org.opensearch.common.settings.Setting;
    @Override
    // pkg-private for testing
        cacheStatsHolder.reset();
            cacheStatsHolder.removeDimensions(key.dimensions);
        return value;
                builder.setMaximumWeightInBytes(maxSizeInBytes);
    }
                Use the cache config value if present.
import org.opensearch.common.cache.RemovalListener;
    public void put(ICacheKey<K> key, V value) {
        if (key.getDropStatsForDimensions()) {
            return this;
 */
    private final List<String> dimensionNames;
     */
        V value = cache.computeIfAbsent(key, key1 -> loader.load(key));
/**
            cacheStatsHolder.incrementHits(key.dimensions);
        if (builder.getNumberOfSegments() > 0) {
     * unmodifiable, so {@link java.util.Iterator#remove()} — which would be a silent no-op against a copy —
    @Override
            cacheStatsHolder.incrementSizeInBytes(key.dimensions, cache.getWeigher().applyAsLong(key, value));
 *
    @Override
import org.opensearch.common.cache.CacheBuilder;
            .removalListener(this);
        } else {
        @Override
            Settings settings = config.getSettings();
        cacheStatsHolder.decrementSizeInBytes(
import org.opensearch.common.cache.stats.NoopCacheStatsHolder;
    @Override
    }
            if (config.getSegmentCount() > 0) {
        this.weigher = builder.getWeigher();
     * @param <V> Type of value
        cacheStatsHolder.decrementItems(notification.getKey().dimensions);
import org.opensearch.common.cache.CacheType;
import org.opensearch.common.cache.LoadAwareCacheLoader;
    }
        this.maximumWeight = builder.getMaxWeightInBytes();
        }
import java.util.Collections;
     * live iterator walks the LRU linked list without holding the LRU lock, so a concurrent cache hit relinking
            Setting<String> cacheSettingForCacheType = CacheSettings.CACHE_TYPE_STORE_NAME.getConcreteSettingForNamespace(
    long getMaximumWeight() {
        @Override
        if (key.key != null) {
                builder.setMaximumWeightInBytes(config.getMaxSizeInBytes());
    }
    public static class Builder<K, V> extends ICacheBuilder<K, V> {
    @Override
 */
    public void onRemoval(RemovalNotification<ICacheKey<K>, V> notification) {
        }
import org.opensearch.common.cache.service.CacheService;
        } else {
        }
import org.opensearch.common.cache.RemovalReason;
    @Override
            } else {
        return Collections.unmodifiableList(cache.keysSnapshot());
     * Returns a point-in-time copy of the keys in the cache rather than the live {@link Cache#keys()} view. The
            if (!CacheService.storeNamePresent(cacheType, settings)) {
        cache.put(key, value);
     * a not-yet-visited entry to the head of the list can cause iteration to silently skip it. The copy is
            return builder.build();
            boolean statsTrackingEnabled = config.getStatsTrackingEnabled();
        return this.maximumWeight;
    }
import static org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings.EXPIRE_AFTER_ACCESS_KEY;
        return cache.count();
                This can be passed down from the TieredSpilloverCache when creating individual segments,
import org.opensearch.common.cache.RemovalNotification;
        if (statsTrackingEnabled) {
            return NAME;
                builder.setExpireAfterAccess(config.getExpireAfterAccess());
    public long count() {
    }
        @Override
        } else {
            }
        cacheStatsHolder.incrementSizeInBytes(key.dimensions, weigher.applyAsLong(key, value));
        }
        CacheBuilder<ICacheKey<K>, V> cacheBuilder = CacheBuilder.<ICacheKey<K>, V>builder()
}
        }
        if (!loader.isLoaded()) {
     * fails fast; use {@link #invalidate(ICacheKey)} to remove entries.
 * @param <V> Type of value.
    @Override
            return new OpenSearchOnHeapCache<K, V>(this);
                // when user wants to use older default onHeap cache settings.
import org.opensearch.common.cache.stats.CacheStatsHolder;
 * This variant of on-heap cache uses OpenSearch custom cache implementation.
        private List<String> dimensionNames;
        public ICache<K, V> build() {
    public OpenSearchOnHeapCache(Builder<K, V> builder) {
import org.opensearch.common.cache.store.config.CacheConfig;
            Map<String, Setting<?>> settingList = OpenSearchOnHeapCacheSettings.getSettingListForCacheType(cacheType);
            } else {
        cache = cacheBuilder.build();
        }
            this.cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, OpenSearchOnHeapCacheFactory.NAME);
import org.opensearch.core.common.unit.ByteSizeValue;
            cacheBuilder.setExpireAfterAccess(builder.getExpireAfterAcess());
            );
        if (builder.getExpireAfterAcess() != null) {
import org.opensearch.common.cache.stats.DefaultCacheStatsHolder;
                builder.setMaximumWeightInBytes(config.getMaxSizeInBytes());
                 */
                builder.setNumberOfSegments(config.getSegmentCount());
                builder.setNumberOfSegments(-1); // By default it will use 256 as we don't want to use this setting
        public String getCacheName() {
import org.opensearch.common.unit.TimeValue;
    public void invalidate(ICacheKey<K> key) {
    private final RemovalListener<ICacheKey<K>, V> removalListener;
import java.util.function.ToLongBiFunction;
        cacheStatsHolder.incrementItems(key.dimensions);
import java.util.List;
     * @param <K> Type of key
        V value = cache.get(key);
        public Builder<K, V> setDimensionNames(List<String> dimensionNames) {
                .setWeigher(config.getWeigher())
            cacheBuilder.setNumberOfSegments(builder.getNumberOfSegments());
        cache.invalidateAll();
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
import org.opensearch.common.cache.ICacheKey;
    }
    public void refresh() {
        return cacheStatsHolder.getImmutableCacheStatsHolder(levels);
        }
            }
    public void invalidateAll() {
