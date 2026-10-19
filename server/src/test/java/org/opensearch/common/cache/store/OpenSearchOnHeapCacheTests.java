            .setSettings(settingsBuilder.build())
            assertEquals(numEvicted, cache.stats().getTotalEvictions());
        String[] levels = dimensionNames.toArray(new String[0]);
        iterator.next();
import org.opensearch.common.cache.stats.ImmutableCacheStats;
        Settings.Builder storeNameBlankSettingsBuilder = Settings.builder();
            .build();
import org.opensearch.common.cache.ICache;
            manuallySetNoopStatsCache.computeIfAbsent(key, getLoadAwareCacheLoader());
            dims.add("0");
import java.util.List;
        int numAdded = maxKeys + numEvicted;
    }
        List<ICacheKey<String>> insertedKeys = new ArrayList<>();
        boolean putSizeInConfig
            assertEquals(maxKeys, cache.stats().getTotalHits());
            @Override
    }
            snapshot = cache.stats(levels).getStatsForDimensionValues(keyAdded.dimensions);
            if (keyAdded.dimensions.equals(keyToDrop.dimensions)) {
import org.opensearch.common.cache.ICacheKey;
    private ICacheKey<String> getICacheKey(String key) {
    }
        long maxSizeFromConfig = between(3000, 4000);
            .setDimensionNames(dimensionNames)
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();
    public void testWithCacheConfigSettings_WhenStoreNameNotBlank() {
        CacheConfig.Builder<String, String> cacheConfigBuilder = new CacheConfig.Builder<String, String>().setKeyType(String.class)
            }
        if (putSizeInConfig) {
/*
        int maxKeys = between(10, 50);
            boolean isLoaded = false;
    }
            true
            assertEquals(maxKeys - numInvalidated, cache.stats().getTotalItems());
        OpenSearchOnHeapCache<String, String> manuallySetNoopStatsCache = getCache(maxKeys, listener, false);
        for (int i = 0; i < numAdded; i++) {
        // Now assert the stats are gone for any key that has this combination of dimensions, but still there otherwise
        CounterMetric numRemovals;
            observedKeys.add(iterator.next());
        ICacheKey<String> key = getICacheKey("key");
            cache.computeIfAbsent(key, getLoadAwareCacheLoader());
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        assertEquals(maxSizeFromConfig, onHeapCache.getMaximumWeight());
    public void testWithCacheConfigSizeSettings_WhenStoreNameBlank() {
    public void testStats() throws Exception {
        assertEquals(new HashSet<>(insertedKeys), observedKeys);
            insertedKeys.add(key);
import static org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings.MAXIMUM_SIZE_IN_BYTES_KEY;
        long maxSizeFromSetting = between(1000, 2000);
            assertEquals(0, cache.stats().getTotalHits());
        // Removing through the keys() iterator would be a silent no-op on the point-in-time copy; it must
            cacheConfigBuilder.build(),
import java.util.Random;
        );
        cache.computeIfAbsent(key, getLoadAwareCacheLoader());
        List<String> result = new ArrayList<>();
        return result;
     * list. This test fails if keys() exposes the live LRU iteration and passes with a point-in-time copy.
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
            .put(
            OpenSearchOnHeapCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
            numRemovals.inc();
            cache.computeIfAbsent(key, getLoadAwareCacheLoader());
import org.opensearch.common.cache.settings.CacheSettings;
            int numHits = i + 1 - (numAdded - maxKeys);
            result.add(String.valueOf(rand.nextInt(bound)));
            public boolean isLoaded() {
        }
            ICacheKey<String> key = new ICacheKey<>(UUID.randomUUID().toString(), getRandomDimensions());
        OpenSearchOnHeapCache<String, String> cache = getCache(100, listener, true);
            assertEquals(maxKeys * keyValueSize, cache.stats().getTotalSizeInBytes());
            .setStatsTrackingEnabled(true);
        int maxKeys = between(10, 50);
        OpenSearchOnHeapCache<String, String> onHeapCache = setupMaxSizeTest(
    }
        for (int i = 0; i < numAdded; i++) {
        long maxSizeFromSetting = between(1000, 2000);
        assertEquals(maxSizeFromSetting, onHeapCache.getMaximumWeight());
            @Override
        // iterator's cursor
            .setValueType(String.class)
    private List<String> getRandomDimensions() {
        }
        boolean statsTrackingEnabled
            .setRemovalListener(listener)
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.cache.CacheType;
        while (iterator.hasNext()) {
            ICacheKey<String> key = getICacheKey("key" + i);
        }
        Settings.Builder settingsBuilder = Settings.builder()
        return (OpenSearchOnHeapCache<String, String>) onHeapCacheFactory.create(
        assertEquals(1, cache.count());
    private final static long keyValueSize = 50;
import org.opensearch.common.cache.RemovalListener;
        MockRemovalListener() {
import org.opensearch.common.cache.RemovalNotification;
        assertNotNull(cache.get(insertedKeys.get(0)));
        Settings settings = Settings.builder()
            );
        }
                .get(MAXIMUM_SIZE_IN_BYTES_KEY)
import org.opensearch.common.metrics.CounterMetric;
            } else {
        List<ICacheKey<String>> keysAdded = new ArrayList<>();
        for (int i = numAdded - maxKeys; i < numAdded; i++) {
        }
import java.util.UUID;
                return isLoaded;
    public void testKeysIteratorDoesNotSupportRemoval() throws Exception {
        for (int i = numAdded - maxKeys; i < numAdded; i++) {
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();
            assertEquals(maxKeys, cache.stats().getTotalItems());
        expectThrows(UnsupportedOperationException.class, iterator::remove);
        Settings.Builder settingsBuilder,
            null
                isLoaded = true;
            maxSizeFromSetting + "b"
            cacheConfigBuilder.setMaxSizeInBytes(maxSizeFromConfig);
import java.util.ArrayList;
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();
        Iterator<ICacheKey<String>> iterator = cache.keys().iterator();
        // A hit on the least-recently-used key relinks it at the head of the LRU list, behind a live
            cache.computeIfAbsent(key, getLoadAwareCacheLoader());
    private static class MockRemovalListener<K, V> implements RemovalListener<ICacheKey<K>, V> {
import org.opensearch.common.cache.LoadAwareCacheLoader;
        );
        ICacheKey<String> keyToDrop = keysAdded.get(0);
        OpenSearchOnHeapCache<String, String> cache = getCache(maxKeys, listener, true);
        int maxKeys = 50;
            maxSizeFromSetting,
        }
            .setSettings(settings)
        ICache.Factory onHeapCacheFactory = new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory();
        // If the store name is blank, the cache should get its size from the config, not the setting.
        // we should get all-zero stats from cache.stats(), but count() should still work.
        assertNotNull(snapshot);
    private OpenSearchOnHeapCache<String, String> setupMaxSizeTest(
    }
            assertEquals((maxKeys - numInvalidated) * keyValueSize, cache.stats().getTotalSizeInBytes());
        );
        }
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
    public void testInvalidateWithDropDimensions() throws Exception {
        OpenSearchOnHeapCache<String, String> cache = getCache(maxKeys, listener, true);
            .build();
 * SPDX-License-Identifier: Apache-2.0
    ) {
    }
    private final static List<String> dimensionNames = List.of("dim1", "dim2", "dim3");
        int maxSizeKeys,
        // When we manually set statsTrackingEnabled = false in the config,
        ICache.Factory onHeapCacheFactory = new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory();
        assertEquals(maxSizeFromConfig, onHeapCache.getMaximumWeight());
package org.opensearch.common.cache.store;
 */
            .setValueType(String.class)
    private void assertZeroStats(ImmutableCacheStatsHolder stats) {
        }
            .setRemovalListener(listener)
            assertEquals(numAdded, cache.stats().getTotalMisses());
        }
        return new LoadAwareCacheLoader<>() {
        CacheConfig<String, String> cacheConfig = new CacheConfig.Builder<String, String>().setKeyType(String.class)
        long maxSizeFromConfig,
            )
        int numEvicted = between(10, 20);
            assertEquals(numHits, cache.stats().getTotalHits());
 * this file be licensed under the Apache-2.0 license or a
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
    public void testWithoutStatsTracking() throws Exception {
            .put(
    }
        // invalidate keys
            assertEquals(numEvicted, cache.stats().getTotalEvictions());
        MockRemovalListener<String, String> listener,
            assertEquals(Math.min(maxKeys, i + 1) * keyValueSize, cache.stats().getTotalSizeInBytes());
    }
                assertNull(snapshot);
     * Cache#keys() iterator silently skips an entry promoted from behind the not-yet-visited portion of the
            assertEquals(Math.min(maxKeys, i + 1), cache.stats().getTotalItems());
            CacheType.INDICES_REQUEST_CACHE,
        };
        }
        OpenSearchOnHeapCache<String, String> onHeapCache = setupMaxSizeTest(settingsBuilder, maxSizeFromSetting, maxSizeFromConfig, false);
            .setDimensionNames(dimensionNames)
        for (String dimName : dimensionNames) {
                return UUID.randomUUID().toString();
        List<String> dims = new ArrayList<>();
        for (int i = 0; i < maxKeys - 5; i++) {
                assertNotNull(snapshot);
        for (ICacheKey<String> keyAdded : keysAdded) {
import java.util.Set;
                    .getKey(),
            ImmutableCacheStatsHolder stats = manuallySetNoopStatsCache.stats();
                OpenSearchOnHeapCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
    /**
            maxSizeFromConfig,
    private LoadAwareCacheLoader<ICacheKey<String>, String> getLoadAwareCacheLoader() {
import org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings;
                maxSizeKeys * keyValueSize + "b"
        ImmutableCacheStats snapshot = cache.stats(levels).getStatsForDimensionValues(keyToDrop.dimensions);
        int numEvicted = between(10, 20);
        long maxSizeFromSetting,
import org.opensearch.common.settings.Settings;
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();
        return new ICacheKey<>(key, dims);
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
    }
        Iterator<ICacheKey<String>> iterator = cache.keys().iterator();
        long maxSizeFromConfig = between(3000, 4000);
public class OpenSearchOnHeapCacheTests extends OpenSearchTestCase {
    public void testKeysIsSafeToIterateUnderConcurrentPromotion() throws Exception {
            cache.computeIfAbsent(keysAdded.get(i), getLoadAwareCacheLoader());
        return (OpenSearchOnHeapCache<String, String>) onHeapCacheFactory.create(cacheConfig, CacheType.INDICES_REQUEST_CACHE, null);
            assertEquals(numAdded, cache.stats().getTotalMisses());
            }
        OpenSearchOnHeapCache<String, String> cache = getCache(100, listener, true);
        Random rand = Randomness.get();
                    .get(MAXIMUM_SIZE_IN_BYTES_KEY)
        @Override
            .setStatsTrackingEnabled(statsTrackingEnabled)
            .setWeigher((k, v) -> keyValueSize)
            numRemovals = new CounterMetric();
     * mid-iteration relinks the accessed entry to the head of the underlying LRU list, and the live
        // When the pluggable caches setting is on, we should get stats as expected from cache.stats().
        keyToDrop.setDropStatsForDimensions(true);
        // setting.
    }
import java.util.Iterator;
            cache.invalidate(keysAdded.get(i));
    }
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();
        // do gets from the last part of the list, which should be hits
    }
}
        int bound = 3;
            storeNameBlankSettingsBuilder,
        settingsBuilder.put(
            .setMaxSizeInBytes(maxSizeKeys * keyValueSize)
            .setWeigher((k, v) -> keyValueSize)
            int numInvalidated = i + 1 - (numAdded - maxKeys);
        int numAdded = maxKeys + numEvicted;
            assertEquals(Math.min(maxKeys, i + 1), manuallySetNoopStatsCache.count());
        }
import org.opensearch.common.Randomness;
            assertEquals(Math.max(0, i + 1 - maxKeys), cache.stats().getTotalEvictions());
        assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), stats.getTotalStats());
        }
     * keys() must be a point-in-time view that is safe to iterate under concurrent mutation: a cache hit
        // When the store name is not blank, the cache should get its size from the config if present, and otherwise should get it from the
        cache.invalidate(keyToDrop);
    private OpenSearchOnHeapCache<String, String> getCache(
            public String load(ICacheKey<String> key) {
import java.util.HashSet;
        public void onRemoval(RemovalNotification<ICacheKey<K>, V> notification) {
        observedKeys.add(iterator.next());
 *
        for (String dimName : dimensionNames) {
        Set<ICacheKey<String>> observedKeys = new HashSet<>();
            }
    ) {
        for (int i = 0; i < 5; i++) {
        onHeapCache = setupMaxSizeTest(settingsBuilder, maxSizeFromSetting, maxSizeFromConfig, true);
     */
            assertEquals(i + 1, cache.stats().getTotalMisses());
import org.opensearch.common.cache.store.config.CacheConfig;
        // fail fast so callers use invalidate(key) instead
            keysAdded.add(key);
            assertZeroStats(manuallySetNoopStatsCache.stats());
    }
                .getKey(),
        List<ICacheKey<String>> keysAdded = new ArrayList<>();
        }
            keysAdded.add(key);
