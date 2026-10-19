import org.opensearch.common.cache.store.OpenSearchOnHeapCache;  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
        IllegalArgumentException ex = assertThrows(
        ICache.Factory factory1 = mock(ICache.Factory.class);  
        CacheService cacheService = new CacheService(factoryMap, Settings.builder().build());
        ICache<String, String> iCache = cacheService.createCache(config, CacheType.INDICES_REQUEST_CACHE);  
    }  
        ICache.Factory factory1 = mock(ICache.Factory.class);
        ICache.Factory factory1 = mock(ICache.Factory.class);  
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.when;
 */  
        when(config.getRemovalListener()).thenReturn(mock(RemovalListener.class));  
        ICache.Factory factory1 = mock(ICache.Factory.class);
        when(factory1.create(eq(config), eq(CacheType.INDICES_REQUEST_CACHE), any(Map.class))).thenReturn(mockOnHeapCache);
        ICache<String, String> ircCache = cacheService.createCache(config, CacheType.INDICES_REQUEST_CACHE);  
            factoryMap,  
        CacheConfig<String, String> config = mock(CacheConfig.class);  
import java.util.Map;
            OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
    public void testWithCreateCacheForIndicesRequestCacheTypeWithStoreNameNull() {
        ICache<String, String> mockOnHeapCache = mock(OpenSearchOnHeapCache.class);  
import org.opensearch.plugins.CachePlugin;
        CacheModule cacheModule = new CacheModule(List.of(mockPlugin1), Settings.EMPTY);
import static org.mockito.ArgumentMatchers.eq;
        CacheService cacheService = new CacheService(factoryMap, Settings.builder().build());
        CacheConfig<String, String> config = mock(CacheConfig.class);
            factoryMap,  
            Settings.builder().put(indicesRequestCacheSetting.getKey(), "cache").build()
        CacheService cacheService = new CacheService(
        assertEquals("No store name: [opensearch_onheap] is registered for cache type: INDICES_REQUEST_CACHE", ex.getMessage());
        Setting<String> indicesRequestCacheSetting = CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE);  
public class CacheServiceTests extends OpenSearchTestCase {  
}
    public void testWithCreateCacheForIndicesRequestCacheType() {
        );
import org.opensearch.common.settings.Setting;
            IllegalArgumentException.class,
        ICache<String, String> onHeapCache = mock(OpenSearchOnHeapCache.class);
        Map<String, ICache.Factory> factoryMap = Map.of("cache1", factory1);  
import org.opensearch.common.cache.module.CacheModule;
        when(mockPlugin1.getCacheFactoryMap()).thenReturn(factoryMap);
        Map<String, ICache.Factory> factoryMap = Map.of(
 * compatible open source license.
            IllegalArgumentException.class,  
    }
import org.opensearch.common.settings.Settings;  
/*  
        when(onHeapCacheFactory.create(eq(config), eq(CacheType.INDICES_REQUEST_CACHE), any(Map.class))).thenReturn(mockOnHeapCache);
        ICache<String, String> mockOnHeapCache = mock(OpenSearchOnHeapCache.class);
            factory1,
        when(onHeapCacheFactory.create(eq(config), eq(CacheType.INDICES_REQUEST_CACHE), any(Map.class))).thenReturn(otherMockOnHeapCache);
        );
        assertTrue(iCache instanceof OpenSearchOnHeapCache);
        CacheConfig<String, String> config = mock(CacheConfig.class);
            onHeapCacheFactory  
        CachePlugin mockPlugin1 = mock(CachePlugin.class);
            factory1,
        when(config.getWeigher()).thenReturn((k, v) -> 100);
            onHeapCacheFactory  
import org.opensearch.common.cache.ICache;
        Map<String, ICache.Factory> factoryMap = Map.of(
            "cache1",  
        CachePlugin mockPlugin1 = mock(CachePlugin.class);
        );
        CacheConfig<String, String> config = mock(CacheConfig.class);  
        IllegalArgumentException ex = assertThrows(
import static org.mockito.Mockito.mock;  
        assertEquals("No store name: [cache] is registered for cache type: INDICES_REQUEST_CACHE", ex.getMessage());  
    }
        Map<String, ICache.Factory> factoryMap = Map.of("cache1", factory1);
        CacheConfig<String, String> config = mock(CacheConfig.class);  
package org.opensearch.common.cache.service;
        Setting<String> indicesRequestCacheSetting = CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE);
        ICache<String, String> otherMockOnHeapCache = mock(OpenSearchOnHeapCache.class);  
            Settings.builder().put(indicesRequestCacheSetting.getKey(), "cache1").build()
        when(config.getSettings()).thenReturn(Settings.EMPTY);
            () -> cacheService.createCache(config, CacheType.INDICES_REQUEST_CACHE)
        );
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.cache.CacheType;
            () -> cacheService.createCache(config, CacheType.INDICES_REQUEST_CACHE)  
            "cache1",  
    }
        ICache.Factory onHeapCacheFactory = mock(OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.class);
        ICache<String, String> ircCache = cacheService.createCache(config, CacheType.INDICES_REQUEST_CACHE);  
        when(factory1.create(config, CacheType.INDICES_REQUEST_CACHE, factoryMap)).thenReturn(onHeapCache);  
import org.opensearch.common.cache.RemovalListener;  
 *
            OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
        when(mockPlugin1.getCacheFactoryMap()).thenReturn(factoryMap);
    public void testWithCreateCacheWithDefaultStoreNameForIRC() {
        );
        CachePlugin mockPlugin1 = mock(CachePlugin.class);  
    }
import org.opensearch.common.cache.settings.CacheSettings;
import org.opensearch.common.cache.store.config.CacheConfig;
        CacheService cacheService = cacheModule.getCacheService();
        assertEquals(mockOnHeapCache, ircCache);
    public void testWithCreateCacheWithInvalidStoreNameAssociatedForCacheType() {
        CacheService cacheService = new CacheService(
        when(mockPlugin1.getCacheFactoryMap()).thenReturn(factoryMap);  
        ICache.Factory onHeapCacheFactory = mock(OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.class);
        assertEquals(mockOnHeapCache, ircCache);
    public void testWithCreateCacheWithNoStoreNamePresentForCacheType() {
import static org.mockito.ArgumentMatchers.any;
        ICache.Factory factory1 = mock(ICache.Factory.class);
        Map<String, ICache.Factory> factoryMap = Map.of("cache1", factory1);
        );
 * The OpenSearch Contributors require contributions made to  
