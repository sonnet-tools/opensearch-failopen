 * Holds all the cache factories and provides a way to fetch them when needed.
        cacheStoreTypeFactories.put(  
            OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
    // Package private for testing.
            new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory()
        this.settings = settings;
}
 * The OpenSearch Contributors require contributions made to  
            for (Map.Entry<String, ICache.Factory> entry : factoryMap.entrySet()) {  
    }
        return this.cacheService;
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
    private final Settings settings;
 * compatible open source license.
        this.cacheStoreTypeFactories = getCacheStoreTypeFactories(cachePlugins);
        return Collections.unmodifiableMap(cacheStoreTypeFactories);  
import org.opensearch.common.settings.Settings;
import org.opensearch.plugins.CachePlugin;  
public class CacheModule {
 *
/*  
    }
        Map<String, ICache.Factory> cacheStoreTypeFactories = new HashMap<>();
                    throw new IllegalArgumentException("Cache name: " + entry.getKey() + " is " + "already registered");
 */  
    public CacheModule(List<CachePlugin> cachePlugins, Settings settings) {  
        }
import org.opensearch.common.cache.service.CacheService;  
import java.util.Map;
    private final Map<String, ICache.Factory> cacheStoreTypeFactories;
    private final CacheService cacheService;  
import java.util.HashMap;  
    }
                }  
 * this file be licensed under the Apache-2.0 license or a
            }
    private static Map<String, ICache.Factory> getCacheStoreTypeFactories(List<CachePlugin> cachePlugins) {  
                if (cacheStoreTypeFactories.put(entry.getKey(), entry.getValue()) != null) {
 */  
            Map<String, ICache.Factory> factoryMap = cachePlugin.getCacheFactoryMap();
    }
import org.opensearch.common.cache.store.OpenSearchOnHeapCache;
        // Add the core OpenSearchOnHeapCache as well.
    public CacheService getCacheService() {  
import org.opensearch.common.cache.ICache;
import org.opensearch.common.annotation.ExperimentalApi;
package org.opensearch.common.cache.module;
    Map<String, ICache.Factory> getCacheStoreTypeFactories() {
/**
@ExperimentalApi
        return cacheStoreTypeFactories;  
        for (CachePlugin cachePlugin : cachePlugins) {
        );  
import java.util.List;
        this.cacheService = new CacheService(cacheStoreTypeFactories, settings);  
