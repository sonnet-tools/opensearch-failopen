 * The OpenSearch Contributors require contributions made to  
        when(factory2.getCacheName()).thenReturn("cache");
import static org.mockito.Mockito.mock;  
}  
 */  
 *
        assertEquals(factoryMap.get("cache1"), factory1);
import org.opensearch.common.settings.Settings;
        ICache.Factory factory2 = mock(ICache.Factory.class);  
        ICache.Factory factory1 = mock(ICache.Factory.class);
        ICache.Factory factory1 = mock(ICache.Factory.class);
        CachePlugin mockPlugin2 = mock(CachePlugin.class);
        CacheModule cacheModule = new CacheModule(List.of(mockPlugin1, mockPlugin2), Settings.EMPTY);
        CachePlugin mockPlugin1 = mock(CachePlugin.class);  
        when(mockPlugin2.getCacheFactoryMap()).thenReturn(Map.of("cache", factory2));
 * compatible open source license.
import org.opensearch.plugins.CachePlugin;  
    public void testWithSameCacheStoreTypeAndName() {
    }  
        when(factory1.getCacheName()).thenReturn("cache");
/*  
import org.opensearch.common.cache.ICache;
package org.opensearch.common.cache.module;
            () -> new CacheModule(List.of(mockPlugin1, mockPlugin2), Settings.EMPTY)
        );  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
        when(mockPlugin2.getCacheFactoryMap()).thenReturn(Map.of("cache2", factory2));
    public void testWithMultiplePlugins() {
import static org.mockito.Mockito.when;
        when(mockPlugin1.getCacheFactoryMap()).thenReturn(Map.of("cache", factory1));  
        CachePlugin mockPlugin2 = mock(CachePlugin.class);
        IllegalArgumentException ex = assertThrows(  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(factoryMap.get("cache2"), factory2);
public class CacheModuleTests extends OpenSearchTestCase {  
        Map<String, ICache.Factory> factoryMap = cacheModule.getCacheStoreTypeFactories();  
import java.util.List;  
        when(mockPlugin1.getCacheFactoryMap()).thenReturn(Map.of("cache1", factory1));
        CachePlugin mockPlugin1 = mock(CachePlugin.class);  
            IllegalArgumentException.class,
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Cache name: cache is already registered", ex.getMessage());
    }
        ICache.Factory factory2 = mock(ICache.Factory.class);  
