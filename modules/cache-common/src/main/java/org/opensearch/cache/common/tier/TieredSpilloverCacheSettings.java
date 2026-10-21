import java.util.Map;
     * Pattern: {cache_type}.tiered_spillover.onheap.store.size
                        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
        (key) -> Setting.boolSetting(key, true, NodeScope, Setting.Property.Dynamic)
    public static final Map<CacheType, Setting<Boolean>> DISK_CACHE_ENABLED_SETTING_MAP;
    /**
     * Setting which defines the onHeap cache size to be used within tiered cache.
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".onheap.store.name",
            DEFAULT_TOOK_TIME_DISK_THRESHOLD,
        // configure its own segmentCount via setting in the future.
    private static final Setting.AffixSetting<TimeValue> TIERED_SPILLOVER_DISK_TOOK_TIME_THRESHOLD = Setting.suffixKeySetting(
            NodeScope,
     * retrieved accordingly.
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".segments",
    /**
    );
    /**
import static org.opensearch.common.cache.settings.CacheSettings.INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE;
     * retrieved accordingly.
                        INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE,
     * This setting overrides size settings from the heap tier implementation.
            key,
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".onheap.store.size",
     * Example: indices.request.cache.tiered_spillover.onheap.store.name
     */
        return VALID_SEGMENT_COUNT_VALUES.get(VALID_SEGMENT_COUNT_VALUES.size() - 1);
    );
     */
                return segmentValue;
    /**
        )
     * Setting which defines the disk cache store to be used in TieredSpilloverCache.
    }
     * Minimum disk cache size ie 10mb. May not make such sense to keep a value smaller than this.
    /**
                        Locale.ROOT,
    /**
import org.opensearch.threadpool.ThreadPool;
     */
 * SPDX-License-Identifier: Apache-2.0
    static {
     * Fetches concrete took time policy and disk cache settings.
    /**
     * Ceiling on the default segment count. Segments divide tier capacity ({@code capacity / segments}), so on
}
import org.opensearch.common.unit.TimeValue;
    public static final Setting.AffixSetting<ByteSizeValue> TIERED_SPILLOVER_ONHEAP_STORE_SIZE = Setting.suffixKeySetting(
        }, NodeScope)
    public static final TimeValue DEFAULT_TOOK_TIME_THRESHOLD = TimeValue.ZERO;
                throw new IllegalArgumentException(
 * Settings related to TieredSpilloverCache.
        // Limit the segment count to keep each segment's capacity large enough (see DEFAULT_SEGMENT_COUNT_CEILING).
 */
     * Stores disk cache enabled settings for various cache types as these are dynamic so that can be registered and
        for (int segmentValue : VALID_SEGMENT_COUNT_VALUES) {
            concreteDiskTookTimePolicySettingMap.put(
    );
     * Default constructor
    public static final Map<CacheType, Setting<TimeValue>> TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP;
     * For example, if OpenSearchOnHeapCache is the heap tier in the request cache, and
     */
                cacheType,
/*
    /**
     * Setting to disable/enable disk cache dynamically.
        (key) -> Setting.timeSetting(
     * The default took time threshold for a value to enter the heap tier of the cache, and therefore to enter the cache at all.
     * Setting which defines the onHeap cache store to be used in TieredSpilloverCache.
     */
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
     * @return default segment count
     */
            TimeValue.ZERO, // Minimum value for this setting
    public static final Setting.AffixSetting<Integer> TIERED_SPILLOVER_SEGMENTS = Setting.suffixKeySetting(
public class TieredSpilloverCacheSettings {
     */
        }
import static org.opensearch.common.cache.settings.CacheSettings.VALID_SEGMENT_COUNT_VALUES;
    public static final Setting.AffixSetting<String> TIERED_SPILLOVER_DISK_STORE_NAME = Setting.suffixKeySetting(
                    )
    public static final long MIN_DISK_CACHE_SIZE_IN_BYTES = 10485760L;
     * Setting defining the minimum took time for a query to be allowed in the disk tier of the cache.
import java.util.concurrent.TimeUnit;
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".policies.took_time.threshold",
     */
     */
    /**
    );
     * Setting defining the minimum took time for a query to be allowed in the cache.
    TieredSpilloverCacheSettings() {}
                TIERED_SPILLOVER_TOOK_TIME_THRESHOLD.getConcreteSettingForNamespace(cacheType.getSettingPrefix())
                cacheType,
     * retrieved accordingly.
        (key) -> Setting.intSetting(key, defaultSegments(), 1, k -> {
        (key) -> Setting.simpleString(key, "", NodeScope)
     * This setting overrides the size setting from the disk tier implementation.
     * Setting defining the number of segments within Tiered cache
    public static final Map<CacheType, Setting<TimeValue>> TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP;
            Setting.Property.Dynamic
import org.opensearch.core.common.unit.ByteSizeValue;
     * indices.requests.cache.opensearch_onheap.size is set, that value will be ignored in favor of this setting.
     */
    );
     *
        defaultSegmentCount = Math.min(defaultSegmentCount, DEFAULT_SEGMENT_COUNT_CEILING);
    /**
     */
    private static final Setting.AffixSetting<TimeValue> TIERED_SPILLOVER_TOOK_TIME_THRESHOLD = Setting.suffixKeySetting(
    );
     */
        TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP = concreteDiskTookTimePolicySettingMap;
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".disk.store.enabled",
                cacheType,
     * Override via the {@code *.tiered_spillover.segments} setting.
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".disk.store.name",
            DEFAULT_TOOK_TIME_THRESHOLD,
     * Setting which defines the disk cache size to be used within tiered cache.
            NodeScope,
import org.opensearch.common.cache.CacheType;
import java.util.Locale;
        (key) -> Setting.memorySizeSetting(key, "1%", NodeScope)
 */
     * Pattern: {cache_type}.tiered_spillover.onheap.store.name
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".disk.store.policies.took_time.threshold",
            concreteTookTimePolicySettingMap.put(
 * compatible open source license.
     */
        TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP = concreteTookTimePolicySettingMap;
package org.opensearch.cache.common.tier;
            );
        (key) -> Setting.longSetting(key, DEFAULT_DISK_CACHE_SIZE_IN_BYTES, MIN_DISK_CACHE_SIZE_IN_BYTES, NodeScope)
    public static final Setting.AffixSetting<Boolean> TIERED_SPILLOVER_DISK_CACHE_SETTING = Setting.suffixKeySetting(
     */
    /**
     * Default cache size in bytes ie 1gb.
            }
        int defaultSegmentCount = ThreadPool.searchThreadPoolSize(Runtime.getRuntime().availableProcessors());
            );
     * indices.requests.cache.ehcache_disk.max_size_in_bytes is set, that value will be ignored in favor of this setting.
        (key) -> Setting.simpleString(key, "", NodeScope)
        // Now round it off to the next power of 2 as we don't support any other values.
     *
                TIERED_SPILLOVER_DISK_CACHE_SETTING.getConcreteSettingForNamespace(cacheType.getSettingPrefix())
     */
     * Stores took time policy settings for the disk tiers of various cache types as these are dynamic so that can be registered and
                    String.format(
    );
import static org.opensearch.common.settings.Setting.Property.NodeScope;
        Map<CacheType, Setting<TimeValue>> concreteTookTimePolicySettingMap = new HashMap<>();
    }
    /**
    public static final int DEFAULT_SEGMENT_COUNT_CEILING = 16;
            if (defaultSegmentCount <= segmentValue) {
            TimeValue.ZERO, // Minimum value for this setting
import java.util.HashMap;
    /**
            }
     * Stores took time policy settings for various cache types as these are dynamic so that can be registered and
        }
     */
    /**
    /**
 *
        for (CacheType cacheType : CacheType.values()) {
            key,
    public static final Setting.AffixSetting<String> TIERED_SPILLOVER_ONHEAP_STORE_NAME = Setting.suffixKeySetting(
    );
        )
            diskCacheSettingMap.put(
     * Returns the default segment count to be used within TieredCache.
    public static final TimeValue DEFAULT_TOOK_TIME_DISK_THRESHOLD = new TimeValue(10, TimeUnit.MILLISECONDS);
        Map<CacheType, Setting<TimeValue>> concreteDiskTookTimePolicySettingMap = new HashMap<>();
        Map<CacheType, Setting<Boolean>> diskCacheSettingMap = new HashMap<>();
            );
                );
     * For example, if EhcacheDiskCache is the disk tier in the request cache, and
     */
    /**
     * hosts with many CPU cores the default segment count splits capacity into partitions too small and hurts the hit rate.
    /**
    public static final long DEFAULT_DISK_CACHE_SIZE_IN_BYTES = 1073741824L;
            if (!VALID_SEGMENT_COUNT_VALUES.contains(k)) {
                TIERED_SPILLOVER_DISK_TOOK_TIME_THRESHOLD.getConcreteSettingForNamespace(cacheType.getSettingPrefix())
     * Example: indices.request.cache.tiered_spillover.onheap.store.size
     */
            Setting.Property.Dynamic
        DISK_CACHE_ENABLED_SETTING_MAP = diskCacheSettingMap;
     * The default took time threshold for a value to enter the disk tier of the cache.
    /**
        (key) -> Setting.timeSetting(
     */
        // For now, we use number of search threads as the default segment count. If needed each cache type can
    public static int defaultSegments() {
import org.opensearch.common.settings.Setting;
    public static final Setting.AffixSetting<Long> TIERED_SPILLOVER_DISK_STORE_SIZE = Setting.suffixKeySetting(
/**
    /**
        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME + ".disk.store.size",
