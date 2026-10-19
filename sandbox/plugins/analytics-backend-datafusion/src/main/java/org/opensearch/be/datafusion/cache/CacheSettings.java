     */
                    + " (sum="
        }
        return new long[] { totalBytes * metaPct / 100, totalBytes * oiPct / 100, totalBytes * ciPct / 100, totalBytes * statsPct / 100 };
        return upper;
 * <p>The statistics cache is sized independently (not part of the 9% total) because it
        true,
     * Default 34%.
        METADATA_INDEX_CACHE_TOTAL_SIZE_KEY,
                    + COLUMN_INDEX_CACHE_PERCENT_KEY
        CacheSettings::validateEvictionType,
                "Invalid eviction type '"
    );
/*
     * Only {@code FIFO} is supported today; {@code S3_FIFO} will be added as a follow-up.
                    + "="
    );
        "FIFO",
import org.opensearch.common.settings.Setting;
    public static final Setting<ByteSizeValue> METADATA_INDEX_CACHE_TOTAL_SIZE = new Setting<>(
    /**
        Setting.Property.Dynamic
    /**
        STATISTICS_CACHE_ENABLED_KEY,
     *
        34,
    public static void validatePercentSum(int metaPct, int oiPct, int ciPct, int statsPct) {
import java.util.Locale;
     * Validates eviction type for the scoped CI/OI caches.
    public static final String STATISTICS_CACHE_PERCENT_KEY = "datafusion.cache.statistics_percent";
    public static final String STATISTICS_CACHE_ENABLED_KEY = "datafusion.statistics.cache.enabled";
        int percent = DiscoveryNode.isWarmNode(settings) ? 9 : 3;
                    + ", "
                    + "="
        String upper = value.toUpperCase(Locale.ROOT);
     * @param oiPct      offset index cache percent
 * the others is rejected at validation time.
                    + OFFSET_INDEX_CACHE_PERCENT_KEY
            throw new IllegalArgumentException("Invalid eviction type '" + value + "'. Must be 'LRU' or 'LFU'.");
 *   │     ├── 35% → offset index     (projection-driven, Rust jemalloc)
                    + "="
    );
        Setting.Property.Dynamic
 *   ├──  9% → datafusion.metadata_index_cache.total_size   (all metadata caches (footer + page indexes), this class)
     * Percentage of {@link #METADATA_INDEX_CACHE_TOTAL_SIZE} allocated to the file-level statistics cache
                    + value
    /** Percentage of {@link #METADATA_INDEX_CACHE_TOTAL_SIZE} allocated to the footer metadata cache. Default 48%. */
     */
 *
        5,
 * <pre>
    }
    // ── Helpers ──────────────────────────────────────────────────────────────
 *   ├── 71% → datafusion.memory_pool_limit_bytes  (operator pool)
    }
     */
        1,
     */
    );
 * holds file-level row-group statistics, not page-level indexes — a different working set
     */
        CacheSettings::validateScopedEvictionType,
            throw new IllegalArgumentException(
    static String deriveMetadataIndexCacheTotalDefault(Settings settings) {
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);
        return upper;
                    + ", "
 * SPDX-License-Identifier: Apache-2.0
 * Settings for the DataFusion parquet caches.
        Setting.Property.Dynamic
        98,
        Setting.Property.NodeScope,
     * {@code S3_FIFO} will be added as a follow-up.
    private static String validateEvictionType(String value) {
        Setting.Property.Dynamic
        CacheSettings::deriveMetadataIndexCacheTotalDefault,
    /**
                "Datafusion cache percentages must sum to <= 100, got: "
        if (metaPct + oiPct + ciPct + statsPct > 100) {
        CacheSettings::validateEvictionType,
 *
        Setting.Property.Dynamic
 *
     * (3% on all other node types); falls back to 500 MB when AC is unconfigured.
        98,
        STATISTICS_CACHE_PERCENT_KEY,
    );
     * @param statsPct   statistics cache percent
public class CacheSettings {
 *
    public static final Setting<Integer> OFFSET_INDEX_CACHE_PERCENT = Setting.intSetting(
        "LRU",
        "datafusion.metadata.cache.eviction.type",
        long total = Math.max(nativeLimit.getBytes() * percent / 100, 0L);
    /** Percentage of {@link #METADATA_INDEX_CACHE_TOTAL_SIZE} allocated to the ColumnIndex cache. Default 13%. */
        if (nativeLimit.getBytes() <= 0) {
        "datafusion.statistics.cache.eviction.type",
 *   │     └── 15% → column index     (predicate-driven, Rust jemalloc)
     * Does NOT validate that percents sum to &lt;= 100 — call {@link #validatePercentSum} first.
        Setting.Property.NodeScope,
package org.opensearch.be.datafusion.cache;
        "datafusion.offset_index.cache.eviction.type",
        Setting.Property.Dynamic
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
        Setting.Property.NodeScope,
import org.opensearch.common.settings.Settings;
     * 3% on all other node types. Falls back to 500 MB when AC is unconfigured (limit == 0).
    public static final String METADATA_CACHE_ENABLED_KEY = "datafusion.metadata.cache.enabled";
    public static final Setting<String> METADATA_CACHE_EVICTION_TYPE = new Setting<>(
 *   ├──  5% → Arrow flight pool
 * this file be licensed under the Apache-2.0 license or a
        Setting.Property.NodeScope,
        Setting.Property.NodeScope,
        FOOTER_METADATA_CACHE_PERCENT_KEY,
            throw new IllegalArgumentException(
 *   ├──  4% → Arrow ingest pool                            (4% on warm nodes; 8% on all other node types)
        s -> ByteSizeValue.parseBytesSizeValue(s, new ByteSizeValue(0, ByteSizeUnit.BYTES), METADATA_INDEX_CACHE_TOTAL_SIZE_KEY),
        Setting.Property.Dynamic
                    + STATISTICS_CACHE_PERCENT_KEY
        }
 * <p>The three sub-cache percentages must sum to &lt;= 100 (unused headroom is accepted). Changing any one without adjusting
        1,
 * compatible open source license.
        1,
            );
}
        Setting.Property.Dynamic
     * Larger than ColumnIndex because it covers predicate ∪ projection ∪ {col 0}.
    /** Validates eviction type for metadata/statistics caches (LRU or LFU via CachePolicy). */
        1,
        Setting.Property.NodeScope,
import org.opensearch.core.common.unit.ByteSizeUnit;
 * <h2>Budget model</h2>
     * Returns {@code long[]{footerMetadataBytes, offsetIndexBytes, columnIndexBytes, statisticsBytes}}.
        if (!upper.equals("FIFO")) {
        "datafusion.column_index.cache.eviction.type",
        Setting.Property.Dynamic
        CacheSettings::validateScopedEvictionType,
     * Default total page-cache budget: 9% of {@code node.native_memory.limit} on warm nodes,
import org.opensearch.cluster.node.DiscoveryNode;
        }
    );
     * OffsetIndex). Defaults to 9% of {@code node.native_memory.limit} on warm nodes
 *   └──  3% → Parquet merge pool
    public static final String METADATA_INDEX_CACHE_TOTAL_SIZE_KEY = "datafusion.metadata_index_cache.total_size";
    /**
    }
    /**
     * Eviction policy for the scoped ColumnIndex cache.
import org.opensearch.core.common.unit.ByteSizeValue;
     * @param metaPct    footer metadata cache percent
 *   ├──  5% → Arrow query pool
    public static final Setting<Boolean> STATISTICS_CACHE_ENABLED = Setting.boolSetting(
 */
     * Percentage of {@link #METADATA_INDEX_CACHE_TOTAL_SIZE} allocated to the OffsetIndex cache.
 * </pre>
                    + ", "
        Setting.Property.NodeScope,
    /**
 * The OpenSearch Contributors require contributions made to
 * with different eviction characteristics.
    );
        98,
    public static final Setting<String> COLUMN_INDEX_CACHE_EVICTION_TYPE = new Setting<>(
        METADATA_CACHE_ENABLED_KEY,
        "LRU",
        return total + "b";
 *   ├──  3% → Parquet write pool                           (3% on warm nodes; 5% on all other node types)
    // ── Sub-cache percentages (must sum to <= 100) ───────────────────────────────
     * Total byte budget for all three metadata caches (footer metadata, ColumnIndex,
                    + metaPct
        Setting.Property.NodeScope,
     * @param ciPct      column index cache percent
                    + (metaPct + oiPct + ciPct + statsPct)
    /**
    public static final Setting<Boolean> METADATA_CACHE_ENABLED = Setting.boolSetting(
                    + "Only 'FIFO' is supported. S3_FIFO support is planned as a follow-up."
     * Validate that the four sub-cache percentages sum to &lt;= 100. Unused headroom (sum &lt; 100) is accepted — mirrors Arrow's pool model where sum(max) &lt;= budget.
        true,
                    + "="
 *   │     │       (9% on warm nodes; 3% on all other node types)
    );
    public static final String OFFSET_INDEX_CACHE_PERCENT_KEY = "datafusion.cache.offset_index_percent";
    }
    );
     */
     * Currently only {@code FIFO} is supported.
 */
                    + FOOTER_METADATA_CACHE_PERCENT_KEY
        }
    /**
 *
        Setting.Property.NodeScope,
        13,
/**
        Setting.Property.NodeScope,
        OFFSET_INDEX_CACHE_PERCENT_KEY,
     */
        COLUMN_INDEX_CACHE_PERCENT_KEY,
     * Currently only {@code FIFO} is supported — the CI/OI caches use a lock-free
        // Warm nodes dedicate a larger share (9%) to metadata caches; other node types retain the 3% default.
        Setting.Property.Dynamic
            );
        Setting.Property.NodeScope,
    }
        Setting.Property.Dynamic
     * Compute absolute cache sizes from percent values and a total budget.
    public static final String FOOTER_METADATA_CACHE_PERCENT_KEY = "datafusion.cache.footer_metadata_percent";
        if (!upper.equals("LRU") && !upper.equals("LFU")) {
 * node.native_memory.limit = 80% of off-heap
                    + ciPct
    // Page-cache total budget (9% of node.native_memory.limit on warm nodes, 3% otherwise)
 *   │     ├── 50% → metadata cache   (footer metadata, Rust jemalloc)
    public static final Setting<String> STATISTICS_CACHE_EVICTION_TYPE = new Setting<>(
        48,
                    + "' for scoped page-index cache. "
 *   = 100% (warm node)
        98,
                    + ")"
     * read design (FIFO insert-order eviction under a single write lock).
        "FIFO",
     * Eviction policy for the scoped OffsetIndex cache.
    private static String validateScopedEvictionType(String value) {
        String upper = value.toUpperCase(Locale.ROOT);
    public static final Setting<String> OFFSET_INDEX_CACHE_EVICTION_TYPE = new Setting<>(
    );
    public static final Setting<Integer> FOOTER_METADATA_CACHE_PERCENT = Setting.intSetting(
    );
                    + statsPct
     * (row-group min/max/null-count). Default 5%.
     */
    public static final Setting<Integer> STATISTICS_CACHE_PERCENT = Setting.intSetting(
    public static long[] computeCacheSizes(int metaPct, int oiPct, int ciPct, int statsPct, long totalBytes) {
            return (500L * 1024 * 1024) + "b";
     */
    public static final String COLUMN_INDEX_CACHE_PERCENT_KEY = "datafusion.cache.column_index_percent";
    /**
                    + oiPct
    public static final Setting<Integer> COLUMN_INDEX_CACHE_PERCENT = Setting.intSetting(
