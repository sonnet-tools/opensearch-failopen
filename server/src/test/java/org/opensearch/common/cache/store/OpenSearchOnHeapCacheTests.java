        int maxSizeKeys,
    private LoadAwareCacheLoader<ICacheKey<String>, String> getLoadAwareCacheLoader() {  
        ICacheKey<String> keyToDrop = keysAdded.get(0);
import org.opensearch.common.cache.stats.ImmutableCacheStats;  
    private OpenSearchOnHeapCache<String, String> setupMaxSizeTest(
import org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings;  
        int numEvicted = between(10, 20);
    public void testInvalidateWithDropDimensions() throws Exception {  
        return new LoadAwareCacheLoader<>() {
            .build();
        for (int i = 0; i < numAdded; i++) {
            assertEquals(Math.min(maxKeys, i + 1) * keyValueSize, cache.stats().getTotalSizeInBytes());
     * keys() must be a point-in-time view that is safe to iterate under concurrent mutation: a cache hit
    }
        settingsBuilder.put(  
            maxSizeFromConfig,  
        assertNotNull(snapshot);
                return UUID.randomUUID().toString();
    }  
                return isLoaded;  
                    .getKey(),
    public void testKeysIsSafeToIterateUnderConcurrentPromotion() throws Exception {
            .build();
        // Removing through the keys() iterator would be a silent no-op on the point-in-time copy; it must
    public void testStats() throws Exception {
        ICache.Factory onHeapCacheFactory = new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory();
import org.opensearch.common.cache.store.config.CacheConfig;
        CacheConfig.Builder<String, String> cacheConfigBuilder = new CacheConfig.Builder<String, String>().setKeyType(String.class)
            .setDimensionNames(dimensionNames)
        OpenSearchOnHeapCache<String, String> cache = getCache(maxKeys, listener, true);  
            keysAdded.add(key);  
            OpenSearchOnHeapCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
            ImmutableCacheStatsHolder stats = manuallySetNoopStatsCache.stats();
        }
import java.util.ArrayList;
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());  
    }  
        int numAdded = maxKeys + numEvicted;
        // When the store name is not blank, the cache should get its size from the config if present, and otherwise should get it from the
            maxSizeFromSetting,
        // When we manually set statsTrackingEnabled = false in the config,  
            ICacheKey<String> key = new ICacheKey<>(UUID.randomUUID().toString(), getRandomDimensions());
    private void assertZeroStats(ImmutableCacheStatsHolder stats) {
     * mid-iteration relinks the accessed entry to the head of the underlying LRU list, and the live  
import java.util.Iterator;
            .put(
            assertEquals(maxKeys - numInvalidated, cache.stats().getTotalItems());
        MockRemovalListener<String, String> listener,
    private static class MockRemovalListener<K, V> implements RemovalListener<ICacheKey<K>, V> {  
    }
        keyToDrop.setDropStatsForDimensions(true);  
        int maxKeys = 50;
        }
import org.opensearch.common.cache.CacheType;
        List<String> dims = new ArrayList<>();
        }
        for (String dimName : dimensionNames) {  
            assertEquals(numAdded, cache.stats().getTotalMisses());  
import org.opensearch.common.Randomness;
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();
        boolean putSizeInConfig  
        // When the pluggable caches setting is on, we should get stats as expected from cache.stats().
        assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), stats.getTotalStats());  
        Settings.Builder settingsBuilder = Settings.builder()  
    private final static List<String> dimensionNames = List.of("dim1", "dim2", "dim3");
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
                .get(MAXIMUM_SIZE_IN_BYTES_KEY)
            dims.add("0");
        }
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();
        assertEquals(1, cache.count());
import org.opensearch.common.cache.RemovalListener;  
                OpenSearchOnHeapCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
        CacheConfig<String, String> cacheConfig = new CacheConfig.Builder<String, String>().setKeyType(String.class)  
        }  
        }
        int numEvicted = between(10, 20);
        ICacheKey<String> key = getICacheKey("key");
            storeNameBlankSettingsBuilder,
        for (int i = 0; i < numAdded; i++) {
        // setting.
            insertedKeys.add(key);
        OpenSearchOnHeapCache<String, String> cache = getCache(100, listener, true);  
import org.opensearch.common.cache.LoadAwareCacheLoader;
import org.opensearch.test.OpenSearchTestCase;  
        for (ICacheKey<String> keyAdded : keysAdded) {
            assertEquals(numHits, cache.stats().getTotalHits());
        CounterMetric numRemovals;
            }
                assertNotNull(snapshot);  
    public void testWithCacheConfigSizeSettings_WhenStoreNameBlank() {  
                maxSizeKeys * keyValueSize + "b"
        cache.computeIfAbsent(key, getLoadAwareCacheLoader());  
            null
            .setValueType(String.class)
        }  
        };
    }  
    }
        );
    }  
        // Now assert the stats are gone for any key that has this combination of dimensions, but still there otherwise  
        OpenSearchOnHeapCache<String, String> cache = getCache(maxKeys, listener, true);
        long maxSizeFromSetting = between(1000, 2000);
        assertEquals(new HashSet<>(insertedKeys), observedKeys);
        observedKeys.add(iterator.next());
        while (iterator.hasNext()) {
    }  
        ImmutableCacheStats snapshot = cache.stats(levels).getStatsForDimensionValues(keyToDrop.dimensions);  
        long maxSizeFromConfig,
    }
            .setSettings(settings)
            manuallySetNoopStatsCache.computeIfAbsent(key, getLoadAwareCacheLoader());
public class OpenSearchOnHeapCacheTests extends OpenSearchTestCase {  
            maxSizeFromSetting + "b"
            assertEquals((maxKeys - numInvalidated) * keyValueSize, cache.stats().getTotalSizeInBytes());  
     * Cache#keys() iterator silently skips an entry promoted from behind the not-yet-visited portion of the
        long maxSizeFromConfig = between(3000, 4000);  
        List<ICacheKey<String>> insertedKeys = new ArrayList<>();
    public void testWithoutStatsTracking() throws Exception {
        Settings.Builder settingsBuilder,  
        @Override
    public void testWithCacheConfigSettings_WhenStoreNameNotBlank() {  
            int numHits = i + 1 - (numAdded - maxKeys);
        for (int i = numAdded - maxKeys; i < numAdded; i++) {
    /**
            keysAdded.add(key);
import java.util.List;
        }
 *
            boolean isLoaded = false;
            .setWeigher((k, v) -> keyValueSize)
            cache.computeIfAbsent(key, getLoadAwareCacheLoader());
            assertEquals(numAdded, cache.stats().getTotalMisses());  
        return new ICacheKey<>(key, dims);  
     * list. This test fails if keys() exposes the live LRU iteration and passes with a point-in-time copy.
            assertEquals(0, cache.stats().getTotalHits());
            }
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();
            assertEquals(Math.min(maxKeys, i + 1), cache.stats().getTotalItems());  
        for (String dimName : dimensionNames) {  
        // A hit on the least-recently-used key relinks it at the head of the LRU list, behind a live
            assertEquals(maxKeys, cache.stats().getTotalHits());
        String[] levels = dimensionNames.toArray(new String[0]);
            @Override
            .setRemovalListener(listener)
            assertEquals(maxKeys * keyValueSize, cache.stats().getTotalSizeInBytes());  
    }
import java.util.Random;  
            )  
            true
    }
            cacheConfigBuilder.build(),
        for (int i = 0; i < 5; i++) {
        Settings.Builder storeNameBlankSettingsBuilder = Settings.builder();
            .put(
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();  
        OpenSearchOnHeapCache<String, String> onHeapCache = setupMaxSizeTest(  
        int bound = 3;
            assertEquals(numEvicted, cache.stats().getTotalEvictions());
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME  
import org.opensearch.common.cache.settings.CacheSettings;
        Iterator<ICacheKey<String>> iterator = cache.keys().iterator();
            .setStatsTrackingEnabled(statsTrackingEnabled)
        OpenSearchOnHeapCache<String, String> cache = getCache(100, listener, true);
import org.opensearch.common.cache.ICache;  
            }
        for (int i = 0; i < maxKeys - 5; i++) {
            cache.computeIfAbsent(keysAdded.get(i), getLoadAwareCacheLoader());  
                    .get(MAXIMUM_SIZE_IN_BYTES_KEY)  
package org.opensearch.common.cache.store;
        OpenSearchOnHeapCache<String, String> onHeapCache = setupMaxSizeTest(settingsBuilder, maxSizeFromSetting, maxSizeFromConfig, false);
import java.util.UUID;
import static org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings.MAXIMUM_SIZE_IN_BYTES_KEY;
import java.util.HashSet;  
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();
        List<ICacheKey<String>> keysAdded = new ArrayList<>();  
        int maxKeys = between(10, 50);  
        if (putSizeInConfig) {
        for (int i = numAdded - maxKeys; i < numAdded; i++) {
            ICacheKey<String> key = getICacheKey("key" + i);  
        onHeapCache = setupMaxSizeTest(settingsBuilder, maxSizeFromSetting, maxSizeFromConfig, true);
import org.opensearch.common.cache.ICacheKey;
}
            assertZeroStats(manuallySetNoopStatsCache.stats());
        // do gets from the last part of the list, which should be hits
            assertEquals(numEvicted, cache.stats().getTotalEvictions());
        int maxKeys = between(10, 50);  
        // we should get all-zero stats from cache.stats(), but count() should still work.
            @Override
            );
                isLoaded = true;  
    ) {
        assertEquals(maxSizeFromConfig, onHeapCache.getMaximumWeight());
    private ICacheKey<String> getICacheKey(String key) {
    private List<String> getRandomDimensions() {
            assertEquals(maxKeys, cache.stats().getTotalItems());
        Settings settings = Settings.builder()  
        }
    }  
            int numInvalidated = i + 1 - (numAdded - maxKeys);
            public String load(ICacheKey<String> key) {
                assertNull(snapshot);
        }
        int numAdded = maxKeys + numEvicted;
        );
            cache.invalidate(keysAdded.get(i));  
    }
            if (keyAdded.dimensions.equals(keyToDrop.dimensions)) {  
        return (OpenSearchOnHeapCache<String, String>) onHeapCacheFactory.create(cacheConfig, CacheType.INDICES_REQUEST_CACHE, null);  
        Set<ICacheKey<String>> observedKeys = new HashSet<>();  
        }
import java.util.Set;
                .getKey(),  
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();
        expectThrows(UnsupportedOperationException.class, iterator::remove);  
        Iterator<ICacheKey<String>> iterator = cache.keys().iterator();
 */  
        // iterator's cursor  
            cache.computeIfAbsent(key, getLoadAwareCacheLoader());
        }
/*  
            .setWeigher((k, v) -> keyValueSize)  
        OpenSearchOnHeapCache<String, String> manuallySetNoopStatsCache = getCache(maxKeys, listener, false);  
        assertEquals(maxSizeFromSetting, onHeapCache.getMaximumWeight());
import org.opensearch.common.metrics.CounterMetric;
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());  
        );
        assertEquals(maxSizeFromConfig, onHeapCache.getMaximumWeight());  
        assertNotNull(cache.get(insertedKeys.get(0)));
        iterator.next();  
    }
            .setRemovalListener(listener)  
            cache.computeIfAbsent(key, getLoadAwareCacheLoader());
            .setStatsTrackingEnabled(true);
            public boolean isLoaded() {
    public void testKeysIteratorDoesNotSupportRemoval() throws Exception {
            .setSettings(settingsBuilder.build())
            } else {
        List<ICacheKey<String>> keysAdded = new ArrayList<>();
        }  
 * compatible open source license.
        MockRemovalListener() {  
            .setMaxSizeInBytes(maxSizeKeys * keyValueSize)  
 * this file be licensed under the Apache-2.0 license or a
        cache.invalidate(keyToDrop);
import org.opensearch.common.cache.RemovalNotification;
        List<String> result = new ArrayList<>();
            assertEquals(i + 1, cache.stats().getTotalMisses());
        long maxSizeFromSetting = between(1000, 2000);
import org.opensearch.common.settings.Settings;
     */  
        // If the store name is blank, the cache should get its size from the config, not the setting.
            .setDimensionNames(dimensionNames)  
            CacheType.INDICES_REQUEST_CACHE,  
            .setValueType(String.class)
 * SPDX-License-Identifier: Apache-2.0
        // fail fast so callers use invalidate(key) instead
        return (OpenSearchOnHeapCache<String, String>) onHeapCacheFactory.create(
        return result;  
        // invalidate keys
            cacheConfigBuilder.setMaxSizeInBytes(maxSizeFromConfig);  
        Random rand = Randomness.get();  
 * The OpenSearch Contributors require contributions made to  
    private final static long keyValueSize = 50;
        ICache.Factory onHeapCacheFactory = new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory();  
            assertEquals(Math.min(maxKeys, i + 1), manuallySetNoopStatsCache.count());  
            assertEquals(Math.max(0, i + 1 - maxKeys), cache.stats().getTotalEvictions());
            observedKeys.add(iterator.next());  
        public void onRemoval(RemovalNotification<ICacheKey<K>, V> notification) {
            result.add(String.valueOf(rand.nextInt(bound)));
        long maxSizeFromSetting,
            numRemovals = new CounterMetric();
    ) {
            snapshot = cache.stats(levels).getStatsForDimensionValues(keyAdded.dimensions);
    private OpenSearchOnHeapCache<String, String> getCache(  
        long maxSizeFromConfig = between(3000, 4000);  
            numRemovals.inc();  
        boolean statsTrackingEnabled  
