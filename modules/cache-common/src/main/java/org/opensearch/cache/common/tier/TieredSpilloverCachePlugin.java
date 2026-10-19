            );
    /**
        return TIERED_CACHE_SPILLOVER_PLUGIN_NAME;  
/**
        return settingList;
import java.util.Map;
    }  
        this.settings = settings;  
 * Plugin for TieredSpilloverCache.
     * @param settings settings  
    @Override
/*  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(cacheType.getSettingPrefix())
        List<Setting<?>> settingList = new ArrayList<>();
    @Override  
        for (CacheType cacheType : CacheType.values()) {
    public String getName() {
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(cacheType.getSettingPrefix())
    @Override
import org.opensearch.common.settings.Setting;  
    }
    public static final String TIERED_CACHE_SPILLOVER_PLUGIN_NAME = "tieredSpilloverCachePlugin";  
 * The OpenSearch Contributors require contributions made to  
     * Plugin name
     * Default constructor
            TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME,  
import java.util.ArrayList;
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.DISK_CACHE_ENABLED_SETTING_MAP;  
import java.util.List;  
            settingList.add(  
            settingList.add(  
 * this file be licensed under the Apache-2.0 license or a
    }
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_SIZE.getConcreteSettingForNamespace(cacheType.getSettingPrefix())
            );
            settingList.add(  
        return Map.of(
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP;
import org.opensearch.common.cache.ICache;
    public List<Setting<?>> getSettings() {  
            settingList.add(TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(cacheType));
            );
            new TieredSpilloverCache.TieredSpilloverCacheFactory()
import org.opensearch.common.cache.CacheType;
 * SPDX-License-Identifier: Apache-2.0
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(cacheType.getSettingPrefix())
    private final Settings settings;
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP;
        }  
import org.opensearch.common.settings.Settings;
            settingList.add(  
import org.opensearch.plugins.CachePlugin;
 *
     */
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(cacheType.getSettingPrefix())
            settingList.add(DISK_CACHE_ENABLED_SETTING_MAP.get(cacheType));
    /**  
            settingList.add(TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(cacheType));  
 * compatible open source license.
            settingList.add(  
    }
}
    public Map<String, ICache.Factory> getCacheFactoryMap() {
import org.opensearch.plugins.Plugin;  
            );
public class TieredSpilloverCachePlugin extends Plugin implements CachePlugin {
 */  
    public TieredSpilloverCachePlugin(Settings settings) {
            );
     */
package org.opensearch.cache.common.tier;
        );
 */  
