    private Map<CacheType, ICache<?, ?>> cacheTypeMap;
        for (CacheType type : cacheTypeMap.keySet()) {  
import org.opensearch.common.cache.CacheType;  
    public CacheService(Map<String, ICache.Factory> cacheStoreTypeFactories, Settings settings) {  
            // settings, so we fallback to onHeap to maintain backward compatibility.
    public <K, V> ICache<K, V> createCache(CacheConfig<K, V> config, CacheType cacheType) {
@ExperimentalApi
package org.opensearch.common.cache.service;
    }
            // In case storeName is not explicitly mentioned, we assume user is looking to use older
    public static boolean storeNamePresent(CacheType cacheType, Settings settings) {  
            statsMap.put(type, cacheTypeMap.get(type).stats(flags.getLevels()));
 * compatible open source license.
}
import org.opensearch.common.cache.settings.CacheSettings;
 * Service responsible to create caches.  
            // It is guaranteed that we will have this store name registered, so  
 * this file be licensed under the Apache-2.0 license or a
        return storeName != null && !storeName.isBlank();
        this.cacheStoreTypeFactories = cacheStoreTypeFactories;
        }  
    }
        return cacheSettingForCacheType.get(settings);  
        );
            storeName = OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME;
        }
        cacheTypeMap.put(cacheType, iCache);  
 */
        if (!cacheStoreTypeFactories.containsKey(storeName)) {
        if (!storeNamePresent(cacheType, settings)) {  
        Setting<String> cacheSettingForCacheType = CacheSettings.CACHE_TYPE_STORE_NAME.getConcreteSettingForNamespace(  
import java.util.Map;
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        return new NodeCacheStats(statsMap, flags);  
/**
        String storeName = getStoreNameFromSetting(cacheType, settings);
import org.opensearch.common.settings.Settings;
    }
    private static String getStoreNameFromSetting(CacheType cacheType, Settings settings) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.cache.store.config.CacheConfig;
    }
    private final Map<String, ICache.Factory> cacheStoreTypeFactories;
            cacheType.getSettingPrefix()
/*  
import org.opensearch.common.cache.store.OpenSearchOnHeapCache;
        this.cacheTypeMap = new HashMap<>();  
            // should be safe.
        return iCache;
    }
import java.util.TreeMap;  
    /**  
    public NodeCacheStats stats(CommonStatsFlags flags) {
import org.opensearch.common.annotation.ExperimentalApi;
        return this.cacheTypeMap;
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;  
        final SortedMap<CacheType, ImmutableCacheStatsHolder> statsMap = new TreeMap<>();
        }  
 */  
import java.util.HashMap;  
import org.opensearch.common.cache.ICache;
        ICache<K, V> iCache = factory.create(config, cacheType, cacheStoreTypeFactories);
     */
            throw new IllegalArgumentException("No store name: [" + storeName + "] is registered for cache type: " + cacheType);
    public Map<CacheType, ICache<?, ?>> getCacheTypeMap() {  
import java.util.SortedMap;
public class CacheService {  
import org.opensearch.common.settings.Setting;  
 * SPDX-License-Identifier: Apache-2.0
    }  
     * Check if a store type is present for this cache type.
        this.settings = settings;
    private final Settings settings;  
        String storeName = getStoreNameFromSetting(cacheType, settings);
        ICache.Factory factory = cacheStoreTypeFactories.get(storeName);
 *
