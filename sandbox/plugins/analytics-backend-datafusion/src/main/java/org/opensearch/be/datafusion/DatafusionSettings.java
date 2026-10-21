    );
/*
     */
    }
     * Otherwise caps the value at 100% of available CPU cores.
        if (nativeLimit.getBytes() <= 0) {
     * Starting size of the decode window a doc-values cursor asks Parquet for, in rows
        });
     * Computes the default for a pool min as a percentage of
     */
            .targetPartitions(deriveTargetPartitions(this.concurrentSearchMode, this.maxSliceCount))
    public static int docValuesMaxBatchSize(Settings settings) {
package org.opensearch.be.datafusion;
     * index-scoped ({@code index.parquet.page_row_limit}). Dynamic updates apply to cursors opened
        Setting.Property.Dynamic
    public static final Setting<Long> DATAFUSION_MEMORY_POOL_MIN = new Setting<>(
    /**
        "none",
        // Concurrency gate settings
    );
        Setting.Property.NodeScope,
import org.opensearch.common.annotation.ExperimentalApi;
    private static int deriveTargetPartitions(String mode, int maxSliceCount) {
     * Returns 0 when AC is unconfigured.
            case "boolean_mask":
     * Example: with threshold 0.03, a filter that matches 2% of rows uses row-selection
            this.maxSliceCount = newValue;
        CacheSettings.OFFSET_INDEX_CACHE_PERCENT,
    // ── Parquet doc-values read path ──
     * that list is fed to {@link ClusterSettings}, which accepts only {@code NodeScope} settings.
     * selections benefit from decode-time filtering; when false, the indexed stream
        clusterSettings.addSettingsUpdateConsumer(INDEXED_FORCE_STRATEGY, newValue -> {
     * <p>
     * <p>
        DatafusionSettings::validateForceStrategy,
        s -> derivePoolMinDefault(s, 37),
        Setting.Property.NodeScope,
        INDEXED_PUSHDOWN_FILTERS,
     */
import org.opensearch.common.settings.Settings;
        "datafusion.listing_table.pushdown_filters",
        1,
        "datafusion.indexed.min_skip_run_selectivity_threshold",
        // to avoid over-subscription and ensure reasonable performance
        DataFusionPlugin.DATAFUSION_REDUCE_TARGET_PARTITIONS,
     * handles filtering externally via bitmap-based row selection.
     * Ceiling the adaptive doc-values decode window grows to, in rows
     * Starting size of a doc-values decode window, in rows, never above
        DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT,
        DEFAULT_DOCVALUES_MAX_BATCH_SIZE,
        // Even if the user set's a higher value, we will still want to limit the number
     * ListingTable (non-indexed) query path. Maps to DataFusion's
            .forceStrategy(forceStrategyToWire(INDEXED_FORCE_STRATEGY.get(settings)))
            snapshot = WireConfigSnapshot.builder(snapshot).batchSize(newValue).build();
    public static final Setting<Integer> BATCH_SIZE = Setting.intSetting(
        if (maxSliceCount == 0) {
     * (e.g., based on filter shape and estimated selectivity). This setting acts as
    /**
        Setting.Property.Dynamic
        Setting.Property.NodeScope,
     */
import org.opensearch.search.SearchService;
    }
    public static int docValuesInitialBatchSize(Settings settings) {
import org.opensearch.be.datafusion.cache.CacheSettings;
                .build();
    // ── Snapshot management ──
    /**
        this.concurrentSearchMode = SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.get(settings);
        true,
     * Selectivity threshold [0.0, 1.0] that controls when the indexed stream switches
        Setting.Property.IndexScope,
 * compatible open source license.
    /**
import org.opensearch.common.settings.ClusterSettings;
    }
    void registerListeners(ClusterSettings clusterSettings) {
        DataFusionPlugin.SCOPED_PAGE_INDEX_ENABLED,
     * leaves this at {@code "none"}.
     */
     *   <li>{@code "row_selection"} — force row-granular selection, {@code min_skip_run = 1} (wire {@code 0});</li>
            return "0";
    static int forceStrategyToWire(String value) {
        "datafusion.indexed.force_strategy",
     * Pins the indexed stream's per-row-group {@code min_skip_run} strategy instead of
            this.concurrentSearchMode = newValue;
    }
     * Whether DataFusion applies its own decode-time predicate pushdown on the
     * 8192 matches the batch size the DataFusion engine uses elsewhere in this plugin
     */
    /**
     * helps a dense scan, but hold more decoded memory per open cursor and waste more decode work
        Setting.Property.NodeScope,
        registerListeners(clusterSettings);
        CacheSettings.COLUMN_INDEX_CACHE_EVICTION_TYPE,
        CacheSettings.STATISTICS_CACHE_PERCENT,
        "datafusion.memory_pool_min_bytes",
        }
        Setting.Property.Dynamic
 * SPDX-License-Identifier: Apache-2.0
    private static void validateForceStrategy(String value) {
        });
     *
     * decode (via {@code RowFilter} pushdown). When true (default), narrow row-granular
                throw new IllegalArgumentException("Setting [datafusion.memory_pool_min_bytes] must be >= 0, got " + v);
    /**
 * The OpenSearch Contributors require contributions made to
     * Tracks the current concurrent search mode ({@code "auto"}, {@code "all"}, or {@code "none"}).
    /** Minimum guaranteed bytes for the DataFusion memory pool. Default is half of datafusion max (37% of budget). */
     * {@code search.concurrent.max_slice_count} setting value.
     * <p>
    );
            long v = Long.parseLong(s);
    }
 *
        clusterSettings.addSettingsUpdateConsumer(LISTING_TABLE_PUSHDOWN_FILTERS, newValue -> {
        });
     */
        this.maxSliceCount = SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.get(settings);
    /**
        Setting.Property.NodeScope,
        DataFusionPlugin.DATAFUSION_MEMORY_GUARD_EXECUTION_SPILL_THRESHOLD,
            .targetPartitions(deriveTargetPartitions(this.concurrentSearchMode, this.maxSliceCount))
     * raw settings without registering dynamic update listeners.
        this.concurrentSearchMode = SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.get(settings);
     * <p>
        return snapshot;
     * @param settings index settings, or {@link Settings#EMPTY} to take the defaults
            .batchSize(BATCH_SIZE.get(settings))
 * reads the snapshot with zero per-query overhead — no {@code ClusterService} lookup on the
     * Tracks the current value of {@code search.concurrent.max_slice_count} for
        clusterSettings.addSettingsUpdateConsumer(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE, newValue -> {
            .build();
                return 0;
     * Default minimum run length (in rows) below which the indexed stream skips
        0.0,
     */
    public static final String POOL_DATAFUSION = "datafusion";
        CONCURRENCY_DATANODE_MULTIPLIER,
    );
        "datafusion.concurrency.fragment_executor_multiplier",
        Setting.Property.Dynamic
        this.snapshot = WireConfigSnapshot.builder()
     * from row-selection mode to full-decode mode. A low threshold (e.g., 0.03) means
            case "row_selection":
        // Cache settings — metadata, statistics, column index, offset index configuration
     * letting candidate selectivity decide. Accepts:
        clusterSettings.addSettingsUpdateConsumer(BATCH_SIZE, newValue -> {
            snapshot = WireConfigSnapshot.builder(snapshot).indexedPushdownFilters(newValue).build();
    DatafusionSettings(Settings settings) {
     */
    public WireConfigSnapshot getSnapshot() {
 *
        Setting.Property.Dynamic
 */
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
     * (skip non-matching rows), but a filter matching 5% switches to full-decode
        });
     * towards this value. Start small so sparse access does not decode rows nobody reads.
                .targetPartitions(deriveTargetPartitions(this.concurrentSearchMode, newValue))
     */
        DataFusionPlugin.DATAFUSION_MIN_TARGET_PARTITIONS,
     * "only use row-selection when the filter is very selective (few rows match)."
    public static final Setting<Boolean> INDEXED_PUSHDOWN_FILTERS = Setting.boolSetting(
        "index.parquet.docvalues.initial_batch_size",
        switch (value) {
        1,
     * <p>
 * <p>
 * @opensearch.experimental
        DEFAULT_DOCVALUES_MAX_BATCH_SIZE,
    public static final int DEFAULT_DOCVALUES_INITIAL_BATCH_SIZE = 32;
        0.1,
 */
        Setting.Property.NodeScope,
     * Same scope and dynamic-update semantics as {@link #DOCVALUES_INITIAL_BATCH_SIZE}.
        INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD,
            .batchSize(BATCH_SIZE.get(settings))
        CacheSettings.METADATA_CACHE_EVICTION_TYPE,
        return Long.toString(Math.max(0L, nativeLimit.getBytes() * percent / 100));
     *   <li>{@code "boolean_mask"} — force a single whole-RG select (wire {@code 1}).</li>
     * both the default ceiling and the upper bound accepted for either batch-size setting, so the
    /**
    /**
            .listingTablePushdownFilters(LISTING_TABLE_PUSHDOWN_FILTERS.get(settings))
        clusterSettings.addSettingsUpdateConsumer(INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD, newValue -> {
     * after the change; a cursor keeps the value it opened with for its lifetime.
    /**
     * @return the current snapshot (never null after construction)
        Setting.Property.Dynamic
            .indexedPushdownFilters(INDEXED_PUSHDOWN_FILTERS.get(settings))
 * hot path.
    }
     * deriving {@code target_partitions}. Updated by the registered listener.
        BATCH_SIZE,
     * {@link #docValuesMaxBatchSize}. The two settings are independent, so a configuration that
        0.03,
        // Runtime settings — memory pool, spill, reduce input mode, and budget tuning
        this.maxSliceCount = SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.get(settings);
        "datafusion.indexed.pushdown_filters",
     * <p>
        // For maxSliceCount == 0 also, we will be owning the concurrency level
        this.snapshot = WireConfigSnapshot.builder()
            snapshot = WireConfigSnapshot.builder(snapshot).targetPartitions(deriveTargetPartitions(newValue, this.maxSliceCount)).build();
     */
    /**
    );
    // ── Concurrency gate settings ──
     * </ul>
        Setting.Property.IndexScope,
     * {@code doc_values_cursor.rs}, which re-checks the value arriving over FFM.
        return Math.min(DOCVALUES_INITIAL_BATCH_SIZE.get(settings), docValuesMaxBatchSize(settings));
            .minSkipRunDefault(INDEXED_MIN_SKIP_RUN_DEFAULT.get(settings))
    public static final List<Setting<?>> NODE_SCOPED_SETTINGS = List.of(
        CacheSettings.STATISTICS_CACHE_ENABLED,
import java.util.List;
     * When mode is {@code "none"}, forces target_partitions to 1 (no concurrency).
    );
     *
        Settings settings = clusterService.getSettings();
     * when access is sparse. Values above {@link #DEFAULT_DOCVALUES_MAX_BATCH_SIZE} are rejected.
     * Larger windows amortise the cost of crossing into the native reader over more rows, which
     * Largest doc-values decode window the Parquet doc-values codec supports, in rows. Serves as
            .minSkipRunSelectivityThreshold(INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.get(settings))
    private volatile String concurrentSearchMode;
}
     * {@link #DOCVALUES_MAX_BATCH_SIZE}, and a jump beyond the current window halves it back
     * the cluster service's settings, and registers listeners for dynamic updates.
        CacheSettings.COLUMN_INDEX_CACHE_PERCENT,
    /** Default starting size of a doc-values decode window, in rows. */
        CacheSettings.FOOTER_METADATA_CACHE_PERCENT,
    public static final Setting<Double> INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD = Setting.doubleSetting(
     */
    public static final Setting<String> INDEXED_FORCE_STRATEGY = Setting.simpleString(
        CacheSettings.METADATA_INDEX_CACHE_TOTAL_SIZE,
            .listingTablePushdownFilters(LISTING_TABLE_PUSHDOWN_FILTERS.get(settings))
        clusterSettings.addSettingsUpdateConsumer(INDEXED_PUSHDOWN_FILTERS, newValue -> {
        return DOCVALUES_MAX_BATCH_SIZE.get(settings);
     */
            .forceStrategy(forceStrategyToWire(INDEXED_FORCE_STRATEGY.get(settings)))
            .indexedPushdownFilters(INDEXED_PUSHDOWN_FILTERS.get(settings))
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);
            if (v < 0) {
     * <p>
        }
    /** Maps the {@link #INDEXED_FORCE_STRATEGY} string to the Rust wire code (-1/0/1). */
     * Ceiling for a doc-values decode window, in rows.
                );
            snapshot = WireConfigSnapshot.builder(snapshot).minSkipRunSelectivityThreshold(newValue).build();
        false,
     * row-selection optimizations and falls back to sequential decode. Shorter runs
        s -> {
@ExperimentalApi
        Setting.Property.Dynamic
public final class DatafusionSettings {
        DataFusionPlugin.DATAFUSION_REDUCE_INPUT_MODE,
    public static final Setting<Double> CONCURRENCY_DATANODE_MULTIPLIER = Setting.doubleSetting(
     */
    }
     * Creates the settings holder, builds the initial {@link WireConfigSnapshot} from
    );
        // of slices to the number of available processors
    );
 * Consolidates all DataFusion plugin settings (existing memory/spill/reduce/cache settings
     * the node-wide default until per-query planner support is added.
        });
        10.0,
    public static final Setting<Integer> INDEXED_MIN_SKIP_RUN_DEFAULT = Setting.intSetting(
     * Note: ideally this decision should be taken by the planner on a per-query basis
    );
        1.5,
        DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP,
        forceStrategyToWire(value);
    /**
     * (cheaper to just read everything sequentially).
    );
            snapshot = WireConfigSnapshot.builder(snapshot).listingTablePushdownFilters(newValue).build();
        });
import org.opensearch.cluster.service.ClusterService;
    // ── Node-scoped settings registered by the plugin ──
     * When mode is {@code "none"}, target_partitions is forced to 1.
        // Scoped page-index feature flag
        Setting.Property.Dynamic
        }
        DEFAULT_DOCVALUES_INITIAL_BATCH_SIZE,
        },
        LISTING_TABLE_PUSHDOWN_FILTERS,
        clusterSettings.addSettingsUpdateConsumer(INDEXED_MIN_SKIP_RUN_DEFAULT, newValue -> {
 * Each dynamic indexed setting registers an {@code addSettingsUpdateConsumer} callback that
     */
            snapshot = WireConfigSnapshot.builder(snapshot).minSkipRunDefault(newValue).build();
        "index.parquet.docvalues.max_batch_size",
     *   <li>{@code "none"} (default) — selectivity heuristic decides (wire {@code -1});</li>
        CacheSettings.METADATA_CACHE_ENABLED,
        DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT,
                return -1;
    private volatile WireConfigSnapshot snapshot;
     * @param settings index settings, or {@link Settings#EMPTY} to take the defaults
    }
            snapshot = WireConfigSnapshot.builder(snapshot)
            snapshot = WireConfigSnapshot.builder(snapshot).forceStrategy(forceStrategyToWire(newValue)).build();
     * (default {@value #DEFAULT_DOCVALUES_MAX_BATCH_SIZE}).
     */
    }
        INDEXED_FORCE_STRATEGY
                throw new IllegalArgumentException(
    public static final int DEFAULT_DOCVALUES_MAX_BATCH_SIZE = 8_192;
 * this file be licensed under the Apache-2.0 license or a
        CacheSettings.STATISTICS_CACHE_EVICTION_TYPE,
        "datafusion.batch_size",
        1024,
 * atomically rebuilds the volatile snapshot on change. At query time, the instruction handler
     * {@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING}.
    static String derivePoolMinDefault(Settings settings, int percent) {
 * plus the new indexed query settings) and manages the pre-computed {@link WireConfigSnapshot}.
    /** Number of rows per batch in the indexed query execution path. */
        Setting.Property.Dynamic
        Setting.Property.NodeScope,
        return Math.min(maxSliceCount, Runtime.getRuntime().availableProcessors());
        DataFusionPlugin.DATAFUSION_MEMORY_GUARD_ADMISSION_REJECT_THRESHOLD,
     *
import org.opensearch.core.common.unit.ByteSizeValue;
     * asks to start above the ceiling is resolved down rather than rejected.
        Setting.Property.NodeScope,
            .minSkipRunDefault(INDEXED_MIN_SKIP_RUN_DEFAULT.get(settings))
        DATAFUSION_MEMORY_POOL_MIN,
import org.opensearch.common.settings.Setting;
        Setting.Property.Dynamic
     * (default {@value #DEFAULT_DOCVALUES_INITIAL_BATCH_SIZE}).
            default:
    // ── New indexed query settings ──
     * volatile read — safe for the query hot path with zero overhead.
            return v;
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
     * ({@code datafusion_query_config.rs}). Mirrored by {@code BATCH_SIZE_HARD_LIMIT} in
     * <ul>
            .build();
    public static final Setting<Integer> DOCVALUES_INITIAL_BATCH_SIZE = Setting.intSetting(
    public static final Setting<Boolean> LISTING_TABLE_PUSHDOWN_FILTERS = Setting.boolSetting(
            return 1;
     * Package-private constructor for testing — builds the initial snapshot from
    /**
            return Runtime.getRuntime().availableProcessors() / 2;
    private volatile int maxSliceCount;
    /**
    /**
     */
        if (SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE.equals(mode)) {
    }
/**
        1,
     * have higher per-row overhead from selection vector maintenance.
    public static final List<Setting<?>> INDEX_SCOPED_SETTINGS = List.of(DOCVALUES_INITIAL_BATCH_SIZE, DOCVALUES_MAX_BATCH_SIZE);
        DataFusionPlugin.DATAFUSION_MEMORY_GUARD_EXECUTION_CRITICAL_THRESHOLD,
     * Index-scoped because the useful range follows the file's page layout, which is itself
    /**
        INDEXED_MIN_SKIP_RUN_DEFAULT,
     * The window then adapts: a dense forward scan doubles it up to
        DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY,
            }
        clusterSettings.addSettingsUpdateConsumer(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING, newValue -> {
     *
                    "Setting [datafusion.indexed.force_strategy] must be one of [none, row_selection, boolean_mask], got [" + value + "]"
        DataFusionPlugin.DATAFUSION_MEMORY_GUARD_ADMISSION_THROTTLE_THRESHOLD,
    );
     * Derives {@code target_partitions} from the concurrent search mode and
        CacheSettings.OFFSET_INDEX_CACHE_EVICTION_TYPE,
     * Whether the indexed stream asks parquet to apply the residual predicate during
    public static final Setting<Integer> DOCVALUES_MAX_BATCH_SIZE = Setting.intSetting(
     * Returns the current pre-computed wire config snapshot. This is a single
        });
    /**
        "datafusion.indexed.min_skip_run_default",
            .minSkipRunSelectivityThreshold(INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.get(settings))
     * When {@code max_slice_count} is 0, uses 50% of available CPU cores.
     * <p>
     */
     * @param clusterService the cluster service providing settings and listener registration
    public DatafusionSettings(ClusterService clusterService) {
        DEFAULT_DOCVALUES_MAX_BATCH_SIZE,
        1,
                return 1;
            case "none":
        8192,
     * ceiling can only be lowered.
        1.0,
        }
    /**
    /** Fragment executor concurrency gate multiplier: max concurrent partition-equivalents = cpu_threads × multiplier. */
     * Index-scoped settings the plugin registers. Kept separate from {@link #NODE_SCOPED_SETTINGS} because
        });
     * Node-wide override intended for benchmarking/diagnostics; production normally
     * {@code execution.parquet.pushdown_filters} session option.
        // Indexed query settings — per-query tuning knobs for the indexed execution path
