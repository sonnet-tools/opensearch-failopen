        (key) -> Setting.boolSetting(key, false, NodeScope)
        DISK_WRITE_MIN_THREADS_KEY,
     */
     * @param cacheType cache type
import static org.opensearch.common.settings.Setting.Property.NodeScope;
     * @return map of cacheType and associated settings.
                settingMap.put(entry.getKey(), entry.getValue().getConcreteSettingForNamespace(cacheType.getSettingPrefix()));
    /**
        (key) -> Setting.longSetting(key, DEFAULT_CACHE_SIZE_IN_BYTES, NodeScope)
     * Key for listener mode
    );
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".max_size_in_bytes",
    public static final long DEFAULT_CACHE_SIZE_IN_BYTES = 1073741824L;
import org.opensearch.common.settings.Setting;
 * this file be licensed under the Apache-2.0 license or a
        Map<CacheType, Map<String, Setting<?>>> cacheTypeMap = new HashMap<>();
        DISK_CACHE_EXPIRE_AFTER_ACCESS_SETTING,
    /**
     * Key for disk segment.
        DISK_STORAGE_PATH_SETTING,
        return cacheTypeMap;
        DISK_SEGMENTS_SETTING,
        DISK_MAX_SIZE_IN_BYTES_KEY,
     */
    public static final Setting.AffixSetting<Boolean> DISK_CACHE_LISTENER_MODE_SYNC_SETTING = Setting.suffixKeySetting(
                    + EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME
     * Default constructor. Added to fix javadocs.
    public static final String DISK_CACHE_EXPIRE_AFTER_ACCESS_KEY = "disk_cache_expire_after_access_key";
     */
            // CPU cores. Ideally won't be required, but in case one way use it.
    );
        DISK_WRITE_CONCURRENCY_KEY,
    /**
    public static final String DISK_LISTENER_MODE_SYNC_KEY = "disk_listener_mode";
        }
    /**
    public static final Setting.AffixSetting<String> DISK_STORAGE_PATH_SETTING = Setting.suffixKeySetting(
import org.opensearch.common.cache.CacheType;
     */
    /**
     *
    public static final Setting.AffixSetting<Integer> DISK_WRITE_MINIMUM_THREADS_SETTING = Setting.suffixKeySetting(
            for (Map.Entry<String, Setting.AffixSetting<?>> entry : KEY_SETTING_MAP.entrySet()) {
    /**
        (key) -> Setting.intSetting(key, 2, 1, ThreadPool.searchThreadPoolSize(Runtime.getRuntime().availableProcessors()), NodeScope)
     */
package org.opensearch.cache;
     */
     * Map to store desired settings for a cache type.
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".max_threads",
    /**
    /**
    public static final String DISK_WRITE_MIN_THREADS_KEY = "disk_write_min_threads";
        (key) -> Setting.simpleString(key, "ehcache_disk", NodeScope)
        DISK_CACHE_EXPIRE_AFTER_ACCESS_KEY,
     */
    /**
     * Key for max size.
     * Map of key to setting.
    public static final Setting.AffixSetting<Long> DISK_CACHE_MAX_SIZE_IN_BYTES_SETTING = Setting.suffixKeySetting(
        DISK_WRITE_MAXIMUM_THREADS_SETTING,
                    + "associated with "
     */
     */
     */
            Map<String, Setting<?>> settingMap = new HashMap<>();
 * compatible open source license.
        DISK_WRITE_MAXIMUM_THREADS_KEY,
     * Key for max threads.
    /**
    /**
    public static final String DISK_MAX_SIZE_IN_BYTES_KEY = "max_size_in_bytes";
     *  Setting pattern: {cache_type}.ehcache_disk.max_threads
    );
    /**
     * Key for storage path.
        (key) -> Setting.intSetting(key, 1, 1, 3, NodeScope)
            );
    public static final Setting.AffixSetting<Integer> DISK_WRITE_CONCURRENCY_SETTING = Setting.suffixKeySetting(
    );
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".min_threads",
     */
     * Fetches setting list for a combination of cache type and store name.
import org.opensearch.cache.store.disk.EhcacheDiskCache;
    public static final Map<String, Setting<?>> getSettingListForCacheType(CacheType cacheType) {
     * Used to form concrete setting for cache types and return desired map
 *
    public static final Setting.AffixSetting<Integer> DISK_SEGMENTS_SETTING = Setting.suffixKeySetting(
    public static final String DISK_CACHE_ALIAS_KEY = "disk_cache_alias";
    /**
    );
    /**
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".segments",
    /**
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".expire_after_access",
public class EhcacheDiskCacheSettings {
    /**
     */
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".alias",
            }
import java.util.Map;
     *  implemented with ehcache using a partitioned thread pool exectutor By default all segments share a single write
     *  search threads. Disk operations are typically I/O bound rather than CPU bound, so setting it greater than the
     *
     *  number of cpu cores should ideally be fine.
     * Key for expire after access.
    public static final Setting.AffixSetting<String> DISK_CACHE_ALIAS_SETTING = Setting.suffixKeySetting(
    /**
                    + "cache type: "
        DISK_STORAGE_PATH_KEY,
        DISK_SEGMENT_KEY,
     *  distinct write queues created for disk store where a group of segments share a write queue. This is
     */
    public static final String DISK_SEGMENT_KEY = "disk_segment";
            key,
        (key) -> Setting.simpleString(key, "", NodeScope)
 * The OpenSearch Contributors require contributions made to
     *  queue ie write concurrency is 1. Check OffHeapDiskStoreConfiguration and DiskWriteThreadPool.
     *  Default is 1 within ehcache.
     */
    );
        for (CacheType cacheType : CacheType.values()) {
     *  Ehcache disk write maximum threads for its pool. The default value is 1.5 * CPU_CORES ie equal to number of
            Runtime.getRuntime().availableProcessors() * 10, // The max one can configure this in setting is 10 times
}
    /**
        (key) -> Setting.positiveTimeSetting(key, TimeValue.MAX_VALUE, NodeScope)
    /**
        Map<String, Setting<?>> cacheTypeSettings = CACHE_TYPE_MAP.get(cacheType);
    /**
     *
import org.opensearch.common.unit.TimeValue;
    private static final Map<String, Setting.AffixSetting<?>> KEY_SETTING_MAP = Map.of(
    public static final String DISK_WRITE_CONCURRENCY_KEY = "disk_write_concurrency";
        return cacheTypeSettings;
    public EhcacheDiskCacheSettings() {}
     *
 */
    public static final String DISK_WRITE_MAXIMUM_THREADS_KEY = "disk_write_max_threads";
        DISK_LISTENER_MODE_SYNC_KEY,
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".concurrency",
        DISK_WRITE_MINIMUM_THREADS_SETTING,
 * SPDX-License-Identifier: Apache-2.0
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".is_event_listener_sync",
     */
            ThreadPool.searchThreadPoolSize(Runtime.getRuntime().availableProcessors()),
     * Default value is 16 within Ehcache.
    private static final Map<CacheType, Map<String, Setting<?>>> getCacheTypeMap() {
    );
        DISK_CACHE_ALIAS_KEY,
    }
    }
     */
    public static final Setting.AffixSetting<Integer> DISK_WRITE_MAXIMUM_THREADS_SETTING = Setting.suffixKeySetting(
            NodeScope
     * Disk cache alias.
     * Default cache size in bytes ie 1gb.
            cacheTypeMap.put(cacheType, settingMap);
        DISK_CACHE_MAX_SIZE_IN_BYTES_SETTING,
    /**
                    + cacheType
     * Key for disk write concurrency.
     */
        DISK_CACHE_LISTENER_MODE_SYNC_SETTING
     */
 * Settings related to ehcache disk cache.
     */
    /**
        DISK_CACHE_ALIAS_SETTING,
        (key) -> Setting.intSetting(key, 16, 1, 32, NodeScope)
     * Disk cache expire after access setting.
            throw new IllegalArgumentException(
     * Disk cache max size setting.
            1,
                "No settings exist for cache store name: "
        }
     */
     * If this cache is used as a tier in a TieredSpilloverCache, this setting is ignored.
     */
 */
    public static final Map<CacheType, Map<String, Setting<?>>> CACHE_TYPE_MAP = getCacheTypeMap();
/**
     * Key for min threads.
        DISK_WRITE_CONCURRENCY_SETTING,
     * Storage path for disk cache.
/*
    /**
        EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME + ".storage.path",
        (key) -> Setting.intSetting(
     * Ehcache disk write minimum threads for its pool
     *
     * Defines how many segments the disk cache is separated into. Higher number achieves greater concurrency but
     * Key for disk segment.
    );
     */
import org.opensearch.threadpool.ThreadPool;
     * Key for cache alias.
    /**
     */
    public static final Setting.AffixSetting<TimeValue> DISK_CACHE_EXPIRE_AFTER_ACCESS_SETTING = Setting.suffixKeySetting(
        )
import java.util.HashMap;
    public static final String DISK_SEGMENTS_KEY = "disk_segments";
        if (cacheTypeSettings == null) {
     *
    );
    );
    public static final String DISK_STORAGE_PATH_KEY = "disk_storage_path";
     *  Not be to confused with number of disk segments, this is different. Defines
     */
     * will hold that many file pointers. Default is 16.
     */
    /**
     * Disk cache listener mode setting.
     * Setting pattern: {cache_type}.ehcache_disk.min_threads
     * @return settings
