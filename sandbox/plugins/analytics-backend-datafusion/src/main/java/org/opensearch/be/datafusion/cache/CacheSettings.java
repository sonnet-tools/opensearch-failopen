    public static void validatePercentSum(int metaPct, int oiPct, int ciPct, int statsPct) {  
 *   = 100% (warm node)
    public static final String METADATA_INDEX_CACHE_TOTAL_SIZE_KEY = "datafusion.metadata_index_cache.total_size";
 *   ├──  4% → Arrow ingest pool                            (4% on warm nodes; 8% on all other node types)
import org.opensearch.common.settings.Settings;  
    /** Percentage of {@link #METADATA_INDEX_CACHE_TOTAL_SIZE} allocated to the footer metadata cache. Default 48%. */
        // Warm nodes dedicate a larger share (9%) to metadata caches; other node types retain the 3% default.
 * this file be licensed under the Apache-2.0 license or a
}
        Setting.Property.Dynamic
        STATISTICS_CACHE_PERCENT_KEY,
 *   │     ├── 35% → offset index     (projection-driven, Rust jemalloc)  
    public static final Setting<ByteSizeValue> METADATA_INDEX_CACHE_TOTAL_SIZE = new Setting<>(
     * read design (FIFO insert-order eviction under a single write lock).  
                    + "="
        Setting.Property.NodeScope,
 *   ├──  3% → Parquet write pool                           (3% on warm nodes; 5% on all other node types)
        STATISTICS_CACHE_ENABLED_KEY,  
        Setting.Property.NodeScope,
    public static final String OFFSET_INDEX_CACHE_PERCENT_KEY = "datafusion.cache.offset_index_percent";
        FOOTER_METADATA_CACHE_PERCENT_KEY,
        if (!upper.equals("LRU") && !upper.equals("LFU")) {
    );  
    public static final Setting<String> METADATA_CACHE_EVICTION_TYPE = new Setting<>(
    );
        CacheSettings::deriveMetadataIndexCacheTotalDefault,
                    + FOOTER_METADATA_CACHE_PERCENT_KEY
                    + ciPct
 *   │     │       (9% on warm nodes; 3% on all other node types)
        Setting.Property.Dynamic  
        return total + "b";
        Setting.Property.Dynamic
        Setting.Property.Dynamic  
     * Currently only {@code FIFO} is supported — the CI/OI caches use a lock-free
                    + ", "
            );
     * Validate that the four sub-cache percentages sum to &lt;= 100. Unused headroom (sum &lt; 100) is accepted — mirrors Arrow's pool model where sum(max) &lt;= budget.
        Setting.Property.Dynamic
                    + STATISTICS_CACHE_PERCENT_KEY
        }
    public static final Setting<String> COLUMN_INDEX_CACHE_EVICTION_TYPE = new Setting<>(  
 * with different eviction characteristics.  
        Setting.Property.Dynamic  
    }
                    + COLUMN_INDEX_CACHE_PERCENT_KEY  
     */
        Setting.Property.Dynamic
 * <pre>  
        34,
                    + ")"  
/*  
    /**
     * Total byte budget for all three metadata caches (footer metadata, ColumnIndex,
        "LRU",
    );
        }
     */
    public static final Setting<Boolean> METADATA_CACHE_ENABLED = Setting.boolSetting(  
        CacheSettings::validateEvictionType,
        "datafusion.metadata.cache.eviction.type",
     * Percentage of {@link #METADATA_INDEX_CACHE_TOTAL_SIZE} allocated to the OffsetIndex cache.
     */
 *  
        Setting.Property.Dynamic
     *  
 * the others is rejected at validation time.
     * Validates eviction type for the scoped CI/OI caches.
import org.opensearch.common.settings.Setting;
 *   ├──  5% → Arrow query pool
        Setting.Property.NodeScope,  
        Setting.Property.Dynamic
    );
    }  
    );  
    public static final Setting<Boolean> STATISTICS_CACHE_ENABLED = Setting.boolSetting(
public class CacheSettings {
    );
    );
                    + " (sum="
 * The OpenSearch Contributors require contributions made to  
    // ── Helpers ──────────────────────────────────────────────────────────────
    /**  
            throw new IllegalArgumentException(
     * Percentage of {@link #METADATA_INDEX_CACHE_TOTAL_SIZE} allocated to the file-level statistics cache
    static String deriveMetadataIndexCacheTotalDefault(Settings settings) {
    public static final Setting<Integer> FOOTER_METADATA_CACHE_PERCENT = Setting.intSetting(  
        OFFSET_INDEX_CACHE_PERCENT_KEY,  
     * Currently only {@code FIFO} is supported.
        if (!upper.equals("FIFO")) {
     * OffsetIndex). Defaults to 9% of {@code node.native_memory.limit} on warm nodes
        if (nativeLimit.getBytes() <= 0) {
 *   ├──  9% → datafusion.metadata_index_cache.total_size   (all metadata caches (footer + page indexes), this class)  
        48,
        CacheSettings::validateScopedEvictionType,  
    public static final Setting<Integer> COLUMN_INDEX_CACHE_PERCENT = Setting.intSetting(  
    /**
        Setting.Property.NodeScope,  
        "datafusion.statistics.cache.eviction.type",
    public static final String STATISTICS_CACHE_PERCENT_KEY = "datafusion.cache.statistics_percent";  
        Setting.Property.Dynamic
                    + OFFSET_INDEX_CACHE_PERCENT_KEY
 *   │     └── 15% → column index     (predicate-driven, Rust jemalloc)
     */
                    + metaPct  
 *  
        Setting.Property.NodeScope,  
        5,  
 */  
    public static final Setting<Integer> STATISTICS_CACHE_PERCENT = Setting.intSetting(
     * @param ciPct      column index cache percent  
     */
        "datafusion.column_index.cache.eviction.type",
        METADATA_CACHE_ENABLED_KEY,
 *  
    }
        Setting.Property.NodeScope,
                    + statsPct  
    // ── Sub-cache percentages (must sum to <= 100) ───────────────────────────────
     */  
 *   ├──  5% → Arrow flight pool  
    public static long[] computeCacheSizes(int metaPct, int oiPct, int ciPct, int statsPct, long totalBytes) {
     * @param oiPct      offset index cache percent
                    + value
 * SPDX-License-Identifier: Apache-2.0
        1,
 *
        s -> ByteSizeValue.parseBytesSizeValue(s, new ByteSizeValue(0, ByteSizeUnit.BYTES), METADATA_INDEX_CACHE_TOTAL_SIZE_KEY),
     * Does NOT validate that percents sum to &lt;= 100 — call {@link #validatePercentSum} first.
    /**  
import org.opensearch.cluster.node.DiscoveryNode;
 */
                    + oiPct
import org.opensearch.core.common.unit.ByteSizeUnit;
                "Invalid eviction type '"  
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;  
            );
 *
     * Default total page-cache budget: 9% of {@code node.native_memory.limit} on warm nodes,
        }  
        Setting.Property.NodeScope,
        Setting.Property.NodeScope,
        if (metaPct + oiPct + ciPct + statsPct > 100) {
    /**
        return upper;
    );  
                    + "' for scoped page-index cache. "
     * (3% on all other node types); falls back to 500 MB when AC is unconfigured.  
            throw new IllegalArgumentException(
     * Compute absolute cache sizes from percent values and a total budget.  
     * {@code S3_FIFO} will be added as a follow-up.
        "FIFO",
        "LRU",  
     * (row-group min/max/null-count). Default 5%.
     * Default 34%.  
    public static final String STATISTICS_CACHE_ENABLED_KEY = "datafusion.statistics.cache.enabled";
     * Eviction policy for the scoped OffsetIndex cache.  
            return (500L * 1024 * 1024) + "b";
                    + ", "
    }
    /** Percentage of {@link #METADATA_INDEX_CACHE_TOTAL_SIZE} allocated to the ColumnIndex cache. Default 13%. */
        Setting.Property.NodeScope,
        1,
        98,
     */
    /** Validates eviction type for metadata/statistics caches (LRU or LFU via CachePolicy). */
     * @param metaPct    footer metadata cache percent
        String upper = value.toUpperCase(Locale.ROOT);  
 * <h2>Budget model</h2>
 *   │     ├── 50% → metadata cache   (footer metadata, Rust jemalloc)
        98,
                    + "Only 'FIFO' is supported. S3_FIFO support is planned as a follow-up."  
        "FIFO",
import java.util.Locale;
 * </pre>
        true,
    private static String validateEvictionType(String value) {
        1,  
    /**  
                    + (metaPct + oiPct + ciPct + statsPct)
    );  
    /**
    );
    /**  
 *   ├── 71% → datafusion.memory_pool_limit_bytes  (operator pool)
    public static final Setting<Integer> OFFSET_INDEX_CACHE_PERCENT = Setting.intSetting(
        1,  
     */
    // Page-cache total budget (9% of node.native_memory.limit on warm nodes, 3% otherwise)
 * Settings for the DataFusion parquet caches.
 * <p>The three sub-cache percentages must sum to &lt;= 100 (unused headroom is accepted). Changing any one without adjusting
                    + ", "  
        CacheSettings::validateEvictionType,  
        Setting.Property.Dynamic  
        13,
            throw new IllegalArgumentException("Invalid eviction type '" + value + "'. Must be 'LRU' or 'LFU'.");
     * @param statsPct   statistics cache percent
    );
        Setting.Property.NodeScope,
     */  
                "Datafusion cache percentages must sum to <= 100, got: "  
        return new long[] { totalBytes * metaPct / 100, totalBytes * oiPct / 100, totalBytes * ciPct / 100, totalBytes * statsPct / 100 };
/**
        true,
                    + "="
 * holds file-level row-group statistics, not page-level indexes — a different working set
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);  
        String upper = value.toUpperCase(Locale.ROOT);  
                    + "="  
    }  
        CacheSettings::validateScopedEvictionType,  
    public static final Setting<String> OFFSET_INDEX_CACHE_EVICTION_TYPE = new Setting<>(  
        long total = Math.max(nativeLimit.getBytes() * percent / 100, 0L);  
package org.opensearch.be.datafusion.cache;
    public static final String METADATA_CACHE_ENABLED_KEY = "datafusion.metadata.cache.enabled";
     * Returns {@code long[]{footerMetadataBytes, offsetIndexBytes, columnIndexBytes, statisticsBytes}}.
 * node.native_memory.limit = 80% of off-heap
 * <p>The statistics cache is sized independently (not part of the 9% total) because it
    public static final Setting<String> STATISTICS_CACHE_EVICTION_TYPE = new Setting<>(  
                    + "="
    public static final String COLUMN_INDEX_CACHE_PERCENT_KEY = "datafusion.cache.column_index_percent";
        98,  
        COLUMN_INDEX_CACHE_PERCENT_KEY,
import org.opensearch.core.common.unit.ByteSizeValue;
 *   └──  3% → Parquet merge pool  
 * compatible open source license.
     * Eviction policy for the scoped ColumnIndex cache.
        int percent = DiscoveryNode.isWarmNode(settings) ? 9 : 3;
        "datafusion.offset_index.cache.eviction.type",
        return upper;  
     * Only {@code FIFO} is supported today; {@code S3_FIFO} will be added as a follow-up.  
     * Larger than ColumnIndex because it covers predicate ∪ projection ∪ {col 0}.
        Setting.Property.NodeScope,
    public static final String FOOTER_METADATA_CACHE_PERCENT_KEY = "datafusion.cache.footer_metadata_percent";  
    private static String validateScopedEvictionType(String value) {
    /**
        98,
        }  
     * 3% on all other node types. Falls back to 500 MB when AC is unconfigured (limit == 0).  
        METADATA_INDEX_CACHE_TOTAL_SIZE_KEY,  
