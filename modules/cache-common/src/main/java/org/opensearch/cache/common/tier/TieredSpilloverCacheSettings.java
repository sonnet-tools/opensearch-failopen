 * this file be licensed under the Apache-2.0 license or a
    public static final Setting.AffixSetting<Boolean> TIERED_SPILLOVER_DISK_CACHE_SETTING = Setting.suffixKeySetting(
    /**
            Setting.Property.Dynamic
     * retrieved accordingly.
     * Pattern: {cache_type}.tiered_spillover.onheap.store.name  
     */
    public static final long DEFAULT_DISK_CACHE_SIZE_IN_BYTES = 1073741824L;  
                cacheType,  
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".policies.took_time.threshold",
public class TieredSpilloverCacheSettings {
    }  
    private static final Setting.AffixSetting<TimeValue> TIERED_SPILLOVER_TOOK_TIME_THRESHOLD = Setting.suffixKeySetting(
import org.opensearch.common.settings.Setting;
            diskCacheSettingMap.put(  
            if (!VALID_SEGMENT_COUNT_VALUES.contains(k)) {  
     * indices.requests.cache.ehcache_disk.max_size_in_bytes is set, that value will be ignored in favor of this setting.  
     * Setting which defines the disk cache size to be used within tiered cache.  
        // configure its own segmentCount via setting in the future.
        Map<CacheType, Setting<Boolean>> diskCacheSettingMap = new HashMap<>();
 * The OpenSearch Contributors require contributions made to  
    public static final Setting.AffixSetting<String> TIERED_SPILLOVER_DISK_STORE_NAME = Setting.suffixKeySetting(
    /**
    );
            }
        (key) -> Setting.timeSetting(
                cacheType,
import java.util.HashMap;
                    String.format(
     */
            key,
     */  
     *
     *
     * Default constructor  
/*  
     */
     * Setting defining the minimum took time for a query to be allowed in the disk tier of the cache.
    public static final Map<CacheType, Setting<TimeValue>> TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP;  
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".disk.store.policies.took_time.threshold",
                TIERED_SPILLOVER_DISK_CACHE_SETTING.getConcreteSettingForNamespace(cacheType.getSettingPrefix())
    public static final Map<CacheType, Setting<Boolean>> DISK_CACHE_ENABLED_SETTING_MAP;  
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".onheap.store.name",
     * Setting to disable/enable disk cache dynamically.
            DEFAULT_TOOK_TIME_DISK_THRESHOLD,
     */
            }  
     */
     */
import static org.opensearch.common.cache.settings.CacheSettings.INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE;  
package org.opensearch.cache.common.tier;
    public static final Setting.AffixSetting<Long> TIERED_SPILLOVER_DISK_STORE_SIZE = Setting.suffixKeySetting(
    public static final Setting.AffixSetting<ByteSizeValue> TIERED_SPILLOVER_ONHEAP_STORE_SIZE = Setting.suffixKeySetting(  
    );  
                    )  
     * Ceiling on the default segment count. Segments divide tier capacity ({@code capacity / segments}), so on
import static org.opensearch.common.settings.Setting.Property.NodeScope;
     * Setting defining the number of segments within Tiered cache
import org.opensearch.core.common.unit.ByteSizeValue;
    public static final Map<CacheType, Setting<TimeValue>> TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP;  
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".disk.store.size",  
        Map<CacheType, Setting<TimeValue>> concreteTookTimePolicySettingMap = new HashMap<>();  
     * The default took time threshold for a value to enter the heap tier of the cache, and therefore to enter the cache at all.  
     * Setting which defines the disk cache store to be used in TieredSpilloverCache.  
            TimeValue.ZERO, // Minimum value for this setting
 *
     * For example, if EhcacheDiskCache is the disk tier in the request cache, and
    /**
        (key) -> Setting.longSetting(key, DEFAULT_DISK_CACHE_SIZE_IN_BYTES, MIN_DISK_CACHE_SIZE_IN_BYTES, NodeScope)
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".segments",
     * Setting defining the minimum took time for a query to be allowed in the cache.
    public static final TimeValue DEFAULT_TOOK_TIME_DISK_THRESHOLD = new TimeValue(10, TimeUnit.MILLISECONDS);
     * indices.requests.cache.opensearch_onheap.size is set, that value will be ignored in favor of this setting.
                );
    public static final int DEFAULT_SEGMENT_COUNT_CEILING = 16;  
 * SPDX-License-Identifier: Apache-2.0
/**
    /**
    );
import java.util.concurrent.TimeUnit;
    /**
import org.opensearch.common.cache.CacheType;
                TIERED_SPILLOVER_TOOK_TIME_THRESHOLD.getConcreteSettingForNamespace(cacheType.getSettingPrefix())  
                        Locale.ROOT,  
     * The default took time threshold for a value to enter the disk tier of the cache.
                        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
     * Example: indices.request.cache.tiered_spillover.onheap.store.size
    public static int defaultSegments() {
    );  
            key,  
     */
     * hosts with many CPU cores the default segment count splits capacity into partitions too small and hurts the hit rate.  
    TieredSpilloverCacheSettings() {}
        (key) -> Setting.timeSetting(  
        // Now round it off to the next power of 2 as we don't support any other values.
     * Pattern: {cache_type}.tiered_spillover.onheap.store.size  
    /**
     * Returns the default segment count to be used within TieredCache.
 * Settings related to TieredSpilloverCache.
    );
        Map<CacheType, Setting<TimeValue>> concreteDiskTookTimePolicySettingMap = new HashMap<>();
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".disk.store.name",  
        )
        }, NodeScope)  
     */  
    /**  
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".onheap.store.size",
        }
    }
    /**
     */
     * Stores took time policy settings for the disk tiers of various cache types as these are dynamic so that can be registered and  
    );  
import java.util.Map;  
    /**  
                        INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE,
     * Example: indices.request.cache.tiered_spillover.onheap.store.name
    /**
    /**
     * Stores disk cache enabled settings for various cache types as these are dynamic so that can be registered and  
            concreteDiskTookTimePolicySettingMap.put(
     * Minimum disk cache size ie 10mb. May not make such sense to keep a value smaller than this.  
            TimeValue.ZERO, // Minimum value for this setting  
 */  
    );
    static {
     * This setting overrides size settings from the heap tier implementation.
     */
        (key) -> Setting.memorySizeSetting(key, "1%", NodeScope)
    /**
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".disk.store.enabled",
        // For now, we use number of search threads as the default segment count. If needed each cache type can  
    /**  
     */
import org.opensearch.threadpool.ThreadPool;
     * @return default segment count  
            Setting.Property.Dynamic
    public static final Setting.AffixSetting<String> TIERED_SPILLOVER_ONHEAP_STORE_NAME = Setting.suffixKeySetting(  
 * compatible open source license.
     * retrieved accordingly.
            );  
import org.opensearch.common.unit.TimeValue;  
        return VALID_SEGMENT_COUNT_VALUES.get(VALID_SEGMENT_COUNT_VALUES.size() - 1);
    /**
        int defaultSegmentCount = ThreadPool.searchThreadPoolSize(Runtime.getRuntime().availableProcessors());
    /**
        TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP = concreteTookTimePolicySettingMap;
        (key) -> Setting.simpleString(key, "", NodeScope)
     * Default cache size in bytes ie 1gb.
     */
            );
            NodeScope,  
        TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP = concreteDiskTookTimePolicySettingMap;  
     * Override via the {@code *.tiered_spillover.segments} setting.
     */  
        (key) -> Setting.boolSetting(key, true, NodeScope, Setting.Property.Dynamic)  
    public static final Setting.AffixSetting<Integer> TIERED_SPILLOVER_SEGMENTS = Setting.suffixKeySetting(  
     * Stores took time policy settings for various cache types as these are dynamic so that can be registered and  
    public static final TimeValue DEFAULT_TOOK_TIME_THRESHOLD = TimeValue.ZERO;
    /**
 */  
     */
     */
        // Limit the segment count to keep each segment's capacity large enough (see DEFAULT_SEGMENT_COUNT_CEILING).  
    public static final long MIN_DISK_CACHE_SIZE_IN_BYTES = 10485760L;
                return segmentValue;
            );
    );
            concreteTookTimePolicySettingMap.put(
                cacheType,
     */
        (key) -> Setting.simpleString(key, "", NodeScope)
            NodeScope,
}  
import java.util.Locale;
        (key) -> Setting.intSetting(key, defaultSegments(), 1, k -> {
        for (CacheType cacheType : CacheType.values()) {  
            if (defaultSegmentCount <= segmentValue) {
     * For example, if OpenSearchOnHeapCache is the heap tier in the request cache, and  
     * Setting which defines the onHeap cache store to be used in TieredSpilloverCache.
        DISK_CACHE_ENABLED_SETTING_MAP = diskCacheSettingMap;
    /**  
     */
            DEFAULT_TOOK_TIME_THRESHOLD,
        )  
    private static final Setting.AffixSetting<TimeValue> TIERED_SPILLOVER_DISK_TOOK_TIME_THRESHOLD = Setting.suffixKeySetting(  
    /**  
     * Setting which defines the onHeap cache size to be used within tiered cache.
     * Fetches concrete took time policy and disk cache settings.  
     * This setting overrides the size setting from the disk tier implementation.
                TIERED_SPILLOVER_DISK_TOOK_TIME_THRESHOLD.getConcreteSettingForNamespace(cacheType.getSettingPrefix())
        for (int segmentValue : VALID_SEGMENT_COUNT_VALUES) {  
import static org.opensearch.common.cache.settings.CacheSettings.VALID_SEGMENT_COUNT_VALUES;
        defaultSegmentCount = Math.min(defaultSegmentCount, DEFAULT_SEGMENT_COUNT_CEILING);
     */
    /**
        }
                throw new IllegalArgumentException(
     * retrieved accordingly.
