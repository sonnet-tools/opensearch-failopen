                    + cacheType
                settingMap.put(entry.getKey(), entry.getValue().getConcreteSettingForNamespace(cacheType.getSettingPrefix()));
            Map<String, Setting<?>> settingMap = new HashMap<>();
     *  
    /**
     * Setting pattern: {cache_type}.opensearch_onheap.expire
                    + "cache type: "  
 */  
import org.opensearch.common.unit.TimeValue;
        return cacheTypeMap;
public class OpenSearchOnHeapCacheSettings {  
     * Setting to define maximum size for the cache as a percentage of heap memory available.  
                    + OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
        MAXIMUM_SIZE_IN_BYTES,
            for (Map.Entry<String, Setting.AffixSetting<?>> entry : KEY_SETTING_MAP.entrySet()) {  
    );
     *
        MAXIMUM_SIZE_IN_BYTES_KEY,  
import org.opensearch.common.settings.Setting;  
 *
     */
     * If this cache is used as a tier in a TieredSpilloverCache, this setting is ignored.
import java.util.HashMap;
    public static final Setting.AffixSetting<TimeValue> EXPIRE_AFTER_ACCESS_SETTING = Setting.suffixKeySetting(  
        (key) -> Setting.positiveTimeSetting(key, TimeValue.MAX_VALUE, Setting.Property.NodeScope)
 * SPDX-License-Identifier: Apache-2.0
    public static Map<String, Setting<?>> getSettingListForCacheType(CacheType cacheType) {
            }
import static org.opensearch.common.settings.Setting.Property.NodeScope;
    private static final Map<String, Setting.AffixSetting<?>> KEY_SETTING_MAP = Map.of(
/**  
    public static final String EXPIRE_AFTER_ACCESS_KEY = "expire_after_access";  
 * The OpenSearch Contributors require contributions made to  
    );
    public static final Setting.AffixSetting<ByteSizeValue> MAXIMUM_SIZE_IN_BYTES = Setting.suffixKeySetting(
        return cacheTypeSettings;
    }
        Map<CacheType, Map<String, Setting<?>>> cacheTypeMap = new HashMap<>();  
}  
        (key) -> Setting.memorySizeSetting(key, "1%", NodeScope)
        if (cacheTypeSettings == null) {
            cacheTypeMap.put(cacheType, settingMap);  
        EXPIRE_AFTER_ACCESS_SETTING  
        Map<String, Setting<?>> cacheTypeSettings = CACHE_TYPE_MAP.get(cacheType);  
        OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME + ".size",  
import org.opensearch.common.cache.CacheType;
    }  
            );
 * this file be licensed under the Apache-2.0 license or a
    private static Map<CacheType, Map<String, Setting<?>>> getCacheTypeMap() {
                    + "associated with "
import org.opensearch.common.cache.store.OpenSearchOnHeapCache;
/*  
                "No settings exist for cache store name: "  
        EXPIRE_AFTER_ACCESS_KEY,
        for (CacheType cacheType : CacheType.values()) {
 * compatible open source license.
    public static final Map<CacheType, Map<String, Setting<?>>> CACHE_TYPE_MAP = getCacheTypeMap();  
package org.opensearch.common.cache.store.settings;
     */
 * Settings for OpenSearchOnHeap
            throw new IllegalArgumentException(
import org.opensearch.core.common.unit.ByteSizeValue;
    /**
     * Setting pattern: {cache_type}.opensearch_onheap.size  
    );  
    public static final String MAXIMUM_SIZE_IN_BYTES_KEY = "maximum_size_in_bytes";
     * Setting to define expire after access.
        }  
        OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME + ".expire",
import java.util.Map;
        }
 */
