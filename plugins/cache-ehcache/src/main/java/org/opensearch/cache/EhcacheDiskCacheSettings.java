        (key) -> Setting.simpleString(key, "", NodeScope)
    /**
                    + EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME
    public EhcacheDiskCacheSettings() {}
     */
        (key) -> Setting.intSetting(key, 1, 1, 3, NodeScope)
     * Disk cache max size setting.
        return cacheTypeSettings;
     */
     *
     *  number of cpu cores should ideally be fine.  
        Map<CacheType, Map<String, Setting<?>>> cacheTypeMap = new HashMap<>();
 * compatible open source license.
     *  implemented with ehcache using a partitioned thread pool exectutor By default all segments share a single write
     */  
    public static final Map<String, Setting<?>> getSettingListForCacheType(CacheType cacheType) {  
    );
    public static final Setting.AffixSetting<Integer> DISK_WRITE_MINIMUM_THREADS_SETTING = Setting.suffixKeySetting(
            key,
     * Defines how many segments the disk cache is separated into. Higher number achieves greater concurrency but
    public static final Map<CacheType, Map<String, Setting<?>>> CACHE_TYPE_MAP = getCacheTypeMap();
     * Key for disk segment.  
        DISK_WRITE_MIN_THREADS_KEY,  
    public static final String DISK_MAX_SIZE_IN_BYTES_KEY = "max_size_in_bytes";  
    public static final Setting.AffixSetting<Long> DISK_CACHE_MAX_SIZE_IN_BYTES_SETTING = Setting.suffixKeySetting(
     */
    /**
    private static final Map<String, Setting.AffixSetting<?>> KEY_SETTING_MAP = Map.of(
     *  Setting pattern: {cache_type}.ehcache_disk.max_threads
    /**  
        )
     * Key for cache alias.  
     * Map to store desired settings for a cache type.
    /**
    public static final Setting.AffixSetting<Integer> DISK_SEGMENTS_SETTING = Setting.suffixKeySetting(
    );
            for (Map.Entry<String, Setting.AffixSetting<?>> entry : KEY_SETTING_MAP.entrySet()) {
    public static final String DISK_SEGMENT_KEY = "disk_segment";
     */
     * Disk cache expire after access setting.
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".storage.path",
import org.opensearch.common.unit.TimeValue;
        DISK_CACHE_EXPIRE_AFTER_ACCESS_KEY,
    public static final Setting.AffixSetting<Boolean> DISK_CACHE_LISTENER_MODE_SYNC_SETTING = Setting.suffixKeySetting(  
     * If this cache is used as a tier in a TieredSpilloverCache, this setting is ignored.
        (key) -> Setting.longSetting(key, DEFAULT_CACHE_SIZE_IN_BYTES, NodeScope)  
            NodeScope  
    /**
    }
     * @return settings
                    + cacheType
        (key) -> Setting.boolSetting(key, false, NodeScope)
import java.util.Map;
     * Default constructor. Added to fix javadocs.  
            Map<String, Setting<?>> settingMap = new HashMap<>();
     * Setting pattern: {cache_type}.ehcache_disk.min_threads
            // CPU cores. Ideally won't be required, but in case one way use it.
    /**
            throw new IllegalArgumentException(  
    /**  
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".max_threads",
import org.opensearch.common.cache.CacheType;
        DISK_WRITE_CONCURRENCY_KEY,
    /**
     * Key for disk write concurrency.
    public static final Setting.AffixSetting<Integer> DISK_WRITE_MAXIMUM_THREADS_SETTING = Setting.suffixKeySetting(
    /**
     * Key for max size.
     * Used to form concrete setting for cache types and return desired map
    public static final Setting.AffixSetting<String> DISK_CACHE_ALIAS_SETTING = Setting.suffixKeySetting(
    );  
import org.opensearch.cache.store.disk.EhcacheDiskCache;
     */  
    );
 */  
    public static final String DISK_CACHE_ALIAS_KEY = "disk_cache_alias";
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".concurrency",  
    /**
    );
        return cacheTypeMap;
     *  search threads. Disk operations are typically I/O bound rather than CPU bound, so setting it greater than the
     */  
            Runtime.getRuntime().availableProcessors() * 10, // The max one can configure this in setting is 10 times
    /**
     */  
    /**
    public static final String DISK_LISTENER_MODE_SYNC_KEY = "disk_listener_mode";
import org.opensearch.common.settings.Setting;  
    );
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".segments",
public class EhcacheDiskCacheSettings {  
            );  
    /**  
    public static final Setting.AffixSetting<TimeValue> DISK_CACHE_EXPIRE_AFTER_ACCESS_SETTING = Setting.suffixKeySetting(
        DISK_CACHE_ALIAS_KEY,  
        (key) -> Setting.simpleString(key, "ehcache_disk", NodeScope)
     * Disk cache alias.  
        DISK_WRITE_MAXIMUM_THREADS_SETTING,
     */
        DISK_WRITE_MINIMUM_THREADS_SETTING,
     * Default value is 16 within Ehcache.
}  
     */  
     * Storage path for disk cache.
        DISK_SEGMENT_KEY,
import org.opensearch.threadpool.ThreadPool;
     */
     *  
    /**  
 */
/**  
     */
    public static final String DISK_WRITE_MIN_THREADS_KEY = "disk_write_min_threads";  
import static org.opensearch.common.settings.Setting.Property.NodeScope;
     */
    /**
     * Key for max threads.  
     */  
        DISK_MAX_SIZE_IN_BYTES_KEY,
    /**
        DISK_WRITE_CONCURRENCY_SETTING,  
    /**
            1,  
     *  Default is 1 within ehcache.
    public static final String DISK_WRITE_MAXIMUM_THREADS_KEY = "disk_write_max_threads";
                "No settings exist for cache store name: "
    /**  
    public static final Setting.AffixSetting<String> DISK_STORAGE_PATH_SETTING = Setting.suffixKeySetting(  
     */
     *  Ehcache disk write maximum threads for its pool. The default value is 1.5 * CPU_CORES ie equal to number of
     * Default cache size in bytes ie 1gb.  
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".max_size_in_bytes",
        if (cacheTypeSettings == null) {
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".is_event_listener_sync",
        }  
     *  
        DISK_SEGMENTS_SETTING,  
     *
    );  
        (key) -> Setting.intSetting(key, 2, 1, ThreadPool.searchThreadPoolSize(Runtime.getRuntime().availableProcessors()), NodeScope)  
 * Settings related to ehcache disk cache.
    public static final Setting.AffixSetting<Integer> DISK_WRITE_CONCURRENCY_SETTING = Setting.suffixKeySetting(
    );
            ThreadPool.searchThreadPoolSize(Runtime.getRuntime().availableProcessors()),
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".expire_after_access",
    /**  
        (key) -> Setting.intSetting(key, 16, 1, 32, NodeScope)  
    public static final String DISK_STORAGE_PATH_KEY = "disk_storage_path";
        Map<String, Setting<?>> cacheTypeSettings = CACHE_TYPE_MAP.get(cacheType);
     */
import java.util.HashMap;
                    + "associated with "  
     * Fetches setting list for a combination of cache type and store name.
        for (CacheType cacheType : CacheType.values()) {  
     * Key for expire after access.
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".min_threads",
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".alias",  
     * @return map of cacheType and associated settings.
     *  distinct write queues created for disk store where a group of segments share a write queue. This is  
    public static final String DISK_WRITE_CONCURRENCY_KEY = "disk_write_concurrency";
        (key) -> Setting.positiveTimeSetting(key, TimeValue.MAX_VALUE, NodeScope)  
        }
        DISK_CACHE_LISTENER_MODE_SYNC_SETTING
     */
    /**  
     *  queue ie write concurrency is 1. Check OffHeapDiskStoreConfiguration and DiskWriteThreadPool.
     * Disk cache listener mode setting.
    public static final long DEFAULT_CACHE_SIZE_IN_BYTES = 1073741824L;
        DISK_STORAGE_PATH_KEY,
     *  
        (key) -> Setting.intSetting(  
 *
        DISK_WRITE_MAXIMUM_THREADS_KEY,
     * Key for min threads.
    );
    public static final String DISK_SEGMENTS_KEY = "disk_segments";  
/*  
     */  
     * will hold that many file pointers. Default is 16.  
     */  
            }
    /**
     * Key for disk segment.
     */
        DISK_LISTENER_MODE_SYNC_KEY,  
    );
            cacheTypeMap.put(cacheType, settingMap);
 * SPDX-License-Identifier: Apache-2.0
    /**
    /**  
     * @param cacheType cache type  
    private static final Map<CacheType, Map<String, Setting<?>>> getCacheTypeMap() {
    public static final String DISK_CACHE_EXPIRE_AFTER_ACCESS_KEY = "disk_cache_expire_after_access_key";
        DISK_CACHE_ALIAS_SETTING,
     */
    /**
        DISK_STORAGE_PATH_SETTING,  
     */  
        DISK_CACHE_EXPIRE_AFTER_ACCESS_SETTING,
    /**
                    + "cache type: "
     * Key for listener mode  
     * Map of key to setting.
     */
    }  
 * The OpenSearch Contributors require contributions made to  
                settingMap.put(entry.getKey(), entry.getValue().getConcreteSettingForNamespace(cacheType.getSettingPrefix()));  
     * Ehcache disk write minimum threads for its pool
     */
 * this file be licensed under the Apache-2.0 license or a
     * Key for storage path.
     */  
     *
package org.opensearch.cache;
        DISK_CACHE_MAX_SIZE_IN_BYTES_SETTING,
     *  Not be to confused with number of disk segments, this is different. Defines
