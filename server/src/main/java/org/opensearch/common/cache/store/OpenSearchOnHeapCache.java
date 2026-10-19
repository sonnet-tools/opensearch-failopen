            this.dimensionNames = dimensionNames;  
import org.opensearch.common.settings.Settings;
        }  
    private final Cache<ICacheKey<K>, V> cache;  
import org.opensearch.common.cache.store.config.CacheConfig;
        cache.put(key, value);
     */
            return builder.build();  
            cacheStatsHolder.incrementHits(key.dimensions);
import static org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings.MAXIMUM_SIZE_IN_BYTES_KEY;
    private final ToLongBiFunction<ICacheKey<K>, V> weigher;
        }
    }
import org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings;  
        return value;
 * The OpenSearch Contributors require contributions made to  
        }
            long maxSizeInBytes = ((ByteSizeValue) settingList.get(MAXIMUM_SIZE_IN_BYTES_KEY).get(settings)).getBytes();
            this.cacheStatsHolder = NoopCacheStatsHolder.getInstance();
    public void onRemoval(RemovalNotification<ICacheKey<K>, V> notification) {
     * Factory to create OpenSearchOnheap cache.
import org.opensearch.common.cache.ICache;
     */  
        cache.invalidateAll();
    /**  
            .weigher(builder.getWeigher())  
        public <K, V> ICache<K, V> create(CacheConfig<K, V> config, CacheType cacheType, Map<String, Factory> cacheFactories) {
    public OpenSearchOnHeapCache(Builder<K, V> builder) {
            } else {
    public ImmutableCacheStatsHolder stats(String[] levels) {
                builder.setMaximumWeightInBytes(config.getMaxSizeInBytes());
                .setStatsTrackingEnabled(statsTrackingEnabled)
        cache.refresh();
        this.statsTrackingEnabled = builder.getStatsTrackingEnabled();
        this.removalListener = builder.getRemovalListener();
        }
            .removalListener(this);
        } else {  
        }  
        if (!loader.isLoaded()) {
    public V get(ICacheKey<K> key) {
            Setting<String> cacheSettingForCacheType = CacheSettings.CACHE_TYPE_STORE_NAME.getConcreteSettingForNamespace(
}  
 */  
import java.util.function.ToLongBiFunction;
import java.util.Collections;  
        }
    private final CacheStatsHolder cacheStatsHolder;
 * This variant of on-heap cache uses OpenSearch custom cache implementation.
        this.weigher = builder.getWeigher();
import org.opensearch.core.common.unit.ByteSizeValue;
        }
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
    }
        cacheStatsHolder.decrementItems(notification.getKey().dimensions);  
        if (value != null) {
        if (builder.getNumberOfSegments() > 0) {
            if (config.getMaxSizeInBytes() > 0) {
                builder.setNumberOfSegments(config.getSegmentCount());  
    // pkg-private for testing
    }  
import org.opensearch.common.cache.service.CacheService;
    }
                .setRemovalListener(config.getRemovalListener());
import org.opensearch.common.cache.ICacheKey;
import org.opensearch.common.cache.RemovalNotification;
     * Builder object
            cacheStatsHolder.incrementMisses(key.dimensions);
        } else {
     * @param <K> Type of key
            if (!CacheService.storeNamePresent(cacheType, settings)) {
                builder.setMaximumWeightInBytes(config.getMaxSizeInBytes());
import java.util.Map;
     * @param <V> Type of value  
/*  
            );
            ICacheBuilder<K, V> builder = new Builder<K, V>().setDimensionNames(config.getDimensionNames())  
                builder.setNumberOfSegments(-1); // By default it will use 256 as we don't want to use this setting  
        );
import org.opensearch.common.cache.stats.NoopCacheStatsHolder;  
        public Builder<K, V> setDimensionNames(List<String> dimensionNames) {
        public static final String NAME = "opensearch_onheap";
            }
package org.opensearch.common.cache.store;
            this.cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, OpenSearchOnHeapCacheFactory.NAME);  
            cacheBuilder.setNumberOfSegments(builder.getNumberOfSegments());  
 * @opensearch.experimental
            cache.getWeigher().applyAsLong(notification.getKey(), notification.getValue())  
    }
    }
            }  
 * compatible open source license.
import org.opensearch.common.cache.CacheBuilder;
        }  
    @Override  
public class OpenSearchOnHeapCache<K, V> implements ICache<K, V>, RemovalListener<ICacheKey<K>, V> {
        public ICache<K, V> build() {
 * SPDX-License-Identifier: Apache-2.0
    }  
        cache = cacheBuilder.build();
        this.maximumWeight = builder.getMaxWeightInBytes();  
        removalListener.onRemoval(notification);
    @Override  
        } else {  
import org.opensearch.common.cache.stats.CacheStatsHolder;  
        }
        if (key.getDropStatsForDimensions()) {
import org.opensearch.common.cache.store.builders.ICacheBuilder;
        return Collections.unmodifiableList(cache.keysSnapshot());  
            if (config.getSegmentCount() > 0) {
                // when user wants to use older default onHeap cache settings.
    private final long maximumWeight;  
    }
            cacheStatsHolder.incrementHits(key.dimensions);
            return this;
    public void put(ICacheKey<K> key, V value) {
    @Override
                 */  
        @Override
     */
 *
    @Override
import org.opensearch.common.unit.TimeValue;  
    long getMaximumWeight() {  
        cacheStatsHolder.decrementSizeInBytes(
        return value;  
        if (RemovalReason.EVICTED.equals(notification.getRemovalReason())  
    }  
 * @param <K> Type of key.
     * fails fast; use {@link #invalidate(ICacheKey)} to remove entries.
                but is not passed in from the IRC if a store name setting is present.
                builder.setMaximumWeightInBytes(maxSizeInBytes);  
import java.util.Objects;  
    public void invalidate(ICacheKey<K> key) {  
        }  
        return cacheStatsHolder.getImmutableCacheStatsHolder(levels);  
    public void refresh() {  
    private final RemovalListener<ICacheKey<K>, V> removalListener;
    public void invalidateAll() {
                /*
                builder.setNumberOfSegments(-1); // By default it will use 256 segments.
    @Override  
            Map<String, Setting<?>> settingList = OpenSearchOnHeapCacheSettings.getSettingListForCacheType(cacheType);  
import org.opensearch.common.cache.stats.DefaultCacheStatsHolder;
            cacheStatsHolder.incrementMisses(key.dimensions);
 * @param <V> Type of value.  
    public V computeIfAbsent(ICacheKey<K> key, LoadAwareCacheLoader<ICacheKey<K>, V> loader) throws Exception {
import org.opensearch.common.settings.Setting;
    /**  
    }
    public Iterable<ICacheKey<K>> keys() {
import org.opensearch.common.cache.settings.CacheSettings;
        @Override  
        this.dimensionNames = Objects.requireNonNull(builder.dimensionNames, "Dimension names can't be null");  
    private final List<String> dimensionNames;  
import static org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings.EXPIRE_AFTER_ACCESS_KEY;  
        if (key.key != null) {
        public String getCacheName() {
        }  
    @Override
        }
 */  
    @Override
     * a not-yet-visited entry to the head of the list can cause iteration to silently skip it. The copy is  
            cacheBuilder.setExpireAfterAccess(builder.getExpireAfterAcess());  
 *
    }
     * live iterator walks the LRU linked list without holding the LRU lock, so a concurrent cache hit relinking
        @Override
        if (builder.getExpireAfterAcess() != null) {
                builder.setExpireAfterAccess(config.getExpireAfterAccess());
import org.opensearch.common.cache.CacheType;  
                // For backward compatibility as the user intent is to use older settings.  
    @Override
            return NAME;
                cacheType.getSettingPrefix()  
import org.opensearch.common.cache.RemovalReason;  
/**  
            }
            Settings settings = config.getSettings();
            .setMaximumWeight(builder.getMaxWeightInBytes())
            notification.getKey().dimensions,
    private final boolean statsTrackingEnabled;
     * Returns a point-in-time copy of the keys in the cache rather than the live {@link Cache#keys()} view. The
    @Override
     * unmodifiable, so {@link java.util.Iterator#remove()} — which would be a silent no-op against a copy —
            cacheStatsHolder.incrementItems(key.dimensions);
                Use the cache config value if present.  
    public void close() {}
            cacheStatsHolder.incrementSizeInBytes(key.dimensions, cache.getWeigher().applyAsLong(key, value));  
        cacheStatsHolder.incrementItems(key.dimensions);  
        return this.maximumWeight;
        cacheStatsHolder.reset();  
        cacheStatsHolder.incrementSizeInBytes(key.dimensions, weigher.applyAsLong(key, value));
        if (statsTrackingEnabled) {
    @Override
    public static class OpenSearchOnHeapCacheFactory implements Factory {  
    /**  
    }
    @Override  
    }
            return new OpenSearchOnHeapCache<K, V>(this);  
import org.opensearch.common.cache.LoadAwareCacheLoader;  
            || RemovalReason.CAPACITY.equals(notification.getRemovalReason())) {
            cacheStatsHolder.removeDimensions(key.dimensions);
            boolean statsTrackingEnabled = config.getStatsTrackingEnabled();
import org.opensearch.common.cache.RemovalListener;
    }
            cacheStatsHolder.incrementEvictions(notification.getKey().dimensions);
import java.util.List;
                .setWeigher(config.getWeigher())  
                .setExpireAfterAccess(((TimeValue) settingList.get(EXPIRE_AFTER_ACCESS_KEY).get(settings)))
        V value = cache.computeIfAbsent(key, key1 -> loader.load(key));  
    public static class Builder<K, V> extends ICacheBuilder<K, V> {
import org.opensearch.common.cache.Cache;
        V value = cache.get(key);  
    public long count() {
            } else {
                This can be passed down from the TieredSpilloverCache when creating individual segments,
        CacheBuilder<ICacheKey<K>, V> cacheBuilder = CacheBuilder.<ICacheKey<K>, V>builder()
 * this file be licensed under the Apache-2.0 license or a
        private List<String> dimensionNames;  
        return cache.count();
            cache.invalidate(key);
