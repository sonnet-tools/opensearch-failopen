import org.opensearch.common.cache.CacheType;
    private static final String EHCACHE_CACHE_PLUGIN = "EhcachePlugin";
    @Override
     */
/*  
        return EHCACHE_CACHE_PLUGIN;
import static org.opensearch.cache.EhcacheDiskCacheSettings.CACHE_TYPE_MAP;  
/**
    /**  
        return settingList;  
    public String getName() {
    public Map<String, ICache.Factory> getCacheFactoryMap() {  
import java.util.ArrayList;
 */
public class EhcacheCachePlugin extends Plugin implements CachePlugin {
                settingList.add(entry1.getValue());  
package org.opensearch.cache;
    }
 * compatible open source license.
        for (Map.Entry<CacheType, Map<String, Setting<?>>> entry : CACHE_TYPE_MAP.entrySet()) {
 * Ehcache based cache plugin.  
    public EhcacheCachePlugin() {}  
            }
 */  
 * this file be licensed under the Apache-2.0 license or a
        }
 * The OpenSearch Contributors require contributions made to  
    @Override  
    @Override
    public List<Setting<?>> getSettings() {
import java.util.List;  
        List<Setting<?>> settingList = new ArrayList<>();  
}
import org.opensearch.common.cache.ICache;  
            for (Map.Entry<String, Setting<?>> entry1 : entry.getValue().entrySet()) {
import org.opensearch.cache.store.disk.EhcacheDiskCache;
    }  
import org.opensearch.common.settings.Setting;
 * SPDX-License-Identifier: Apache-2.0
        return Map.of(EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME, new EhcacheDiskCache.EhcacheDiskCacheFactory());
    }
import org.opensearch.plugins.CachePlugin;
 *
     * Default constructor to avoid javadoc related failures.
import org.opensearch.plugins.Plugin;  
import java.util.Map;
