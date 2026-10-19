        DataFusionPlugin.SCOPED_PAGE_INDEX_ENABLED,
        Setting.Property.NodeScope,  
    /**
    );
        });
     * @param clusterService the cluster service providing settings and listener registration  
     * both the default ceiling and the upper bound accepted for either batch-size setting, so the  
                .targetPartitions(deriveTargetPartitions(this.concurrentSearchMode, newValue))  
            .minSkipRunSelectivityThreshold(INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.get(settings))  
            return "0";  
        }
    public static final List<Setting<?>> INDEX_SCOPED_SETTINGS = List.of(DOCVALUES_INITIAL_BATCH_SIZE, DOCVALUES_MAX_BATCH_SIZE);
    }  
    /**
            default:  
        DATAFUSION_MEMORY_POOL_MIN,
        // to avoid over-subscription and ensure reasonable performance
    );
     * ({@code datafusion_query_config.rs}). Mirrored by {@code BATCH_SIZE_HARD_LIMIT} in
            .indexedPushdownFilters(INDEXED_PUSHDOWN_FILTERS.get(settings))
            if (v < 0) {  
     * The window then adapts: a dense forward scan doubles it up to
     * Example: with threshold 0.03, a filter that matches 2% of rows uses row-selection  
            .batchSize(BATCH_SIZE.get(settings))
     */  
import org.opensearch.common.annotation.ExperimentalApi;  
        Setting.Property.NodeScope,
            case "none":  
        LISTING_TABLE_PUSHDOWN_FILTERS,  
            snapshot = WireConfigSnapshot.builder(snapshot).forceStrategy(forceStrategyToWire(newValue)).build();  
    /**
    private volatile int maxSliceCount;  
        CacheSettings.OFFSET_INDEX_CACHE_EVICTION_TYPE,
        registerListeners(clusterSettings);
        DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP,  
        s -> derivePoolMinDefault(s, 37),  
     * Pins the indexed stream's per-row-group {@code min_skip_run} strategy instead of
     */
    public static final Setting<String> INDEXED_FORCE_STRATEGY = Setting.simpleString(  
     *
        if (nativeLimit.getBytes() <= 0) {
        CacheSettings.METADATA_CACHE_EVICTION_TYPE,
     * 8192 matches the batch size the DataFusion engine uses elsewhere in this plugin  
 * @opensearch.experimental
        Setting.Property.Dynamic
     * <p>
        }
import org.opensearch.search.SearchService;  
    );  
    );
     * helps a dense scan, but hold more decoded memory per open cursor and waste more decode work
        });
    private volatile WireConfigSnapshot snapshot;  
            snapshot = WireConfigSnapshot.builder(snapshot)
            snapshot = WireConfigSnapshot.builder(snapshot).indexedPushdownFilters(newValue).build();  
     * (default {@value #DEFAULT_DOCVALUES_MAX_BATCH_SIZE}).
     * Node-wide override intended for benchmarking/diagnostics; production normally  
        CacheSettings.FOOTER_METADATA_CACHE_PERCENT,
     * <p>
     * that list is fed to {@link ClusterSettings}, which accepts only {@code NodeScope} settings.
        CacheSettings.METADATA_INDEX_CACHE_TOTAL_SIZE,
 * atomically rebuilds the volatile snapshot on change. At query time, the instruction handler  
 * SPDX-License-Identifier: Apache-2.0
        clusterSettings.addSettingsUpdateConsumer(INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD, newValue -> {
    private volatile String concurrentSearchMode;  
    // ── Parquet doc-values read path ──
            this.maxSliceCount = newValue;
    );
    /**
     * row-selection optimizations and falls back to sequential decode. Shorter runs
    DatafusionSettings(Settings settings) {
 * Consolidates all DataFusion plugin settings (existing memory/spill/reduce/cache settings
     * {@code doc_values_cursor.rs}, which re-checks the value arriving over FFM.
        CacheSettings.STATISTICS_CACHE_PERCENT,
            .minSkipRunDefault(INDEXED_MIN_SKIP_RUN_DEFAULT.get(settings))
                throw new IllegalArgumentException("Setting [datafusion.memory_pool_min_bytes] must be >= 0, got " + v);
        CacheSettings.COLUMN_INDEX_CACHE_EVICTION_TYPE,  
        clusterSettings.addSettingsUpdateConsumer(INDEXED_PUSHDOWN_FILTERS, newValue -> {
     * "only use row-selection when the filter is very selective (few rows match)."
        1024,
 */
    public static final Setting<Integer> INDEXED_MIN_SKIP_RUN_DEFAULT = Setting.intSetting(
     */
            .build();
        Settings settings = clusterService.getSettings();  
     * {@code search.concurrent.max_slice_count} setting value.
    public static final int DEFAULT_DOCVALUES_MAX_BATCH_SIZE = 8_192;
     * Largest doc-values decode window the Parquet doc-values codec supports, in rows. Serves as
        DataFusionPlugin.DATAFUSION_REDUCE_TARGET_PARTITIONS,  
        });  
 *  
        // Concurrency gate settings
     */
    /**
        DEFAULT_DOCVALUES_INITIAL_BATCH_SIZE,
        1,
        Setting.Property.Dynamic
     *   <li>{@code "none"} (default) — selectivity heuristic decides (wire {@code -1});</li>
     * <p>  
            return 1;  
     * Starting size of a doc-values decode window, in rows, never above
     */
 * <p>
    public static final Setting<Integer> BATCH_SIZE = Setting.intSetting(
     * @param settings index settings, or {@link Settings#EMPTY} to take the defaults
    public static final Setting<Integer> DOCVALUES_INITIAL_BATCH_SIZE = Setting.intSetting(  
    public static final Setting<Double> INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD = Setting.doubleSetting(
     * Index-scoped settings the plugin registers. Kept separate from {@link #NODE_SCOPED_SETTINGS} because
    /**  
    public static final String POOL_DATAFUSION = "datafusion";  
 * hot path.
 *
                throw new IllegalArgumentException(
        DatafusionSettings::validateForceStrategy,  
    public static final Setting<Long> DATAFUSION_MEMORY_POOL_MIN = new Setting<>(
        8192,
    /**
                return 0;  
        // Indexed query settings — per-query tuning knobs for the indexed execution path
        DataFusionPlugin.DATAFUSION_MEMORY_GUARD_ADMISSION_THROTTLE_THRESHOLD,
        this.maxSliceCount = SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.get(settings);
import org.opensearch.common.settings.Setting;
    // ── Node-scoped settings registered by the plugin ──  
        // Even if the user set's a higher value, we will still want to limit the number
     *   <li>{@code "row_selection"} — force row-granular selection, {@code min_skip_run = 1} (wire {@code 0});</li>  
        "datafusion.memory_pool_min_bytes",
     */
     * the node-wide default until per-query planner support is added.  
        DataFusionPlugin.DATAFUSION_REDUCE_INPUT_MODE,
        "index.parquet.docvalues.initial_batch_size",
        1.5,  
        clusterSettings.addSettingsUpdateConsumer(BATCH_SIZE, newValue -> {  
            .indexedPushdownFilters(INDEXED_PUSHDOWN_FILTERS.get(settings))
     */  
@ExperimentalApi  
        return snapshot;
        clusterSettings.addSettingsUpdateConsumer(LISTING_TABLE_PUSHDOWN_FILTERS, newValue -> {
    }  
            snapshot = WireConfigSnapshot.builder(snapshot).listingTablePushdownFilters(newValue).build();
            .minSkipRunSelectivityThreshold(INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD.get(settings))  
     * Whether DataFusion applies its own decode-time predicate pushdown on the
/**
        DEFAULT_DOCVALUES_MAX_BATCH_SIZE,
     * Computes the default for a pool min as a percentage of
        });
        Setting.Property.IndexScope,  
     * When mode is {@code "none"}, target_partitions is forced to 1.
     * <p>
        // Cache settings — metadata, statistics, column index, offset index configuration  
        },
package org.opensearch.be.datafusion;
        forceStrategyToWire(value);  
        "datafusion.concurrency.fragment_executor_multiplier",
     * <p>  
        true,
    public static final Setting<Double> CONCURRENCY_DATANODE_MULTIPLIER = Setting.doubleSetting(
 * compatible open source license.
     *  
            .targetPartitions(deriveTargetPartitions(this.concurrentSearchMode, this.maxSliceCount))
    /**
    public static final List<Setting<?>> NODE_SCOPED_SETTINGS = List.of(
                );  
    /**  
        Setting.Property.Dynamic
    // ── Concurrency gate settings ──
     * deriving {@code target_partitions}. Updated by the registered listener.
        });
        INDEXED_PUSHDOWN_FILTERS,
    void registerListeners(ClusterSettings clusterSettings) {
        "none",
     * (e.g., based on filter shape and estimated selectivity). This setting acts as
        CONCURRENCY_DATANODE_MULTIPLIER,
    /**  
        }  
     */
     * Larger windows amortise the cost of crossing into the native reader over more rows, which
        this.snapshot = WireConfigSnapshot.builder()  
        Setting.Property.Dynamic  
     * (cheaper to just read everything sequentially).
     * Note: ideally this decision should be taken by the planner on a per-query basis
     * volatile read — safe for the query hot path with zero overhead.  
     * Same scope and dynamic-update semantics as {@link #DOCVALUES_INITIAL_BATCH_SIZE}.
    }
     * index-scoped ({@code index.parquet.page_row_limit}). Dynamic updates apply to cursors opened  
        Setting.Property.IndexScope,
     *   <li>{@code "boolean_mask"} — force a single whole-RG select (wire {@code 1}).</li>
     * <p>
            this.concurrentSearchMode = newValue;
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
        CacheSettings.COLUMN_INDEX_CACHE_PERCENT,
     * <p>
            return v;  
    public static int docValuesMaxBatchSize(Settings settings) {  
        Setting.Property.Dynamic
     * Tracks the current concurrent search mode ({@code "auto"}, {@code "all"}, or {@code "none"}).  
     */  
     * Otherwise caps the value at 100% of available CPU cores.
        Setting.Property.NodeScope,
     * decode (via {@code RowFilter} pushdown). When true (default), narrow row-granular  
        this.snapshot = WireConfigSnapshot.builder()  
     * (default {@value #DEFAULT_DOCVALUES_INITIAL_BATCH_SIZE}).
     * Derives {@code target_partitions} from the concurrent search mode and  
            .build();
     */
        "datafusion.indexed.force_strategy",
     */
     * handles filtering externally via bitmap-based row selection.
        DEFAULT_DOCVALUES_MAX_BATCH_SIZE,
    );
     * raw settings without registering dynamic update listeners.  
     * {@link #docValuesMaxBatchSize}. The two settings are independent, so a configuration that  
    }
    /**
     * When mode is {@code "none"}, forces target_partitions to 1 (no concurrency).  
        // of slices to the number of available processors  
    );
        if (maxSliceCount == 0) {
            case "row_selection":
     */
    static int forceStrategyToWire(String value) {
     * ListingTable (non-indexed) query path. Maps to DataFusion's  
        // For maxSliceCount == 0 also, we will be owning the concurrency level  
                return -1;
                return 1;
    public static final Setting<Boolean> INDEXED_PUSHDOWN_FILTERS = Setting.boolSetting(
            .listingTablePushdownFilters(LISTING_TABLE_PUSHDOWN_FILTERS.get(settings))  
    /** Minimum guaranteed bytes for the DataFusion memory pool. Default is half of datafusion max (37% of budget). */  
        // Scoped page-index feature flag
        clusterSettings.addSettingsUpdateConsumer(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE, newValue -> {
    public static final int DEFAULT_DOCVALUES_INITIAL_BATCH_SIZE = 32;
        Setting.Property.NodeScope,  
     * when access is sparse. Values above {@link #DEFAULT_DOCVALUES_MAX_BATCH_SIZE} are rejected.  
        "datafusion.listing_table.pushdown_filters",
     * have higher per-row overhead from selection vector maintenance.  
        DEFAULT_DOCVALUES_MAX_BATCH_SIZE,  
    public DatafusionSettings(ClusterService clusterService) {
        if (SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE.equals(mode)) {
            .targetPartitions(deriveTargetPartitions(this.concurrentSearchMode, this.maxSliceCount))
     * @return the current snapshot (never null after construction)
     * Returns 0 when AC is unconfigured.
        0.03,  
        this.maxSliceCount = SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.get(settings);
     * leaves this at {@code "none"}.
            snapshot = WireConfigSnapshot.builder(snapshot).targetPartitions(deriveTargetPartitions(newValue, this.maxSliceCount)).build();  
import org.opensearch.core.common.unit.ByteSizeValue;
public final class DatafusionSettings {
        s -> {
        this.concurrentSearchMode = SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.get(settings);  
        "datafusion.batch_size",  
        clusterSettings.addSettingsUpdateConsumer(INDEXED_MIN_SKIP_RUN_DEFAULT, newValue -> {  
        "datafusion.indexed.pushdown_filters",  
        DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT,  
        Setting.Property.Dynamic
    private static void validateForceStrategy(String value) {
        clusterSettings.addSettingsUpdateConsumer(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING, newValue -> {  
                .build();
                    "Setting [datafusion.indexed.force_strategy] must be one of [none, row_selection, boolean_mask], got [" + value + "]"
     * Tracks the current value of {@code search.concurrent.max_slice_count} for  
/*  
        DataFusionPlugin.DATAFUSION_MEMORY_GUARD_ADMISSION_REJECT_THRESHOLD,  
        "index.parquet.docvalues.max_batch_size",
            .forceStrategy(forceStrategyToWire(INDEXED_FORCE_STRATEGY.get(settings)))
     * </ul>
    /**  
        Setting.Property.Dynamic
import java.util.List;
            return Runtime.getRuntime().availableProcessors() / 2;
            .batchSize(BATCH_SIZE.get(settings))
        INDEXED_MIN_SKIP_RUN_DEFAULT,
}
    /** Number of rows per batch in the indexed query execution path. */
     * Ceiling for a doc-values decode window, in rows.
     */  
            .forceStrategy(forceStrategyToWire(INDEXED_FORCE_STRATEGY.get(settings)))
        10.0,
        clusterSettings.addSettingsUpdateConsumer(INDEXED_FORCE_STRATEGY, newValue -> {
        CacheSettings.STATISTICS_CACHE_ENABLED,  
        return Long.toString(Math.max(0L, nativeLimit.getBytes() * percent / 100));
    /**
    public static int docValuesInitialBatchSize(Settings settings) {
        "datafusion.indexed.min_skip_run_selectivity_threshold",
            snapshot = WireConfigSnapshot.builder(snapshot).minSkipRunDefault(newValue).build();
     * Selectivity threshold [0.0, 1.0] that controls when the indexed stream switches
        0.0,
     */  
    );
        });
     * ceiling can only be lowered.
    );
        INDEXED_MIN_SKIP_RUN_SELECTIVITY_THRESHOLD,  
     */
 * Each dynamic indexed setting registers an {@code addSettingsUpdateConsumer} callback that
            }
        DataFusionPlugin.DATAFUSION_MIN_TARGET_PARTITIONS,
 * this file be licensed under the Apache-2.0 license or a
    /**
    }  
        BATCH_SIZE,
     * When {@code max_slice_count} is 0, uses 50% of available CPU cores.
        INDEXED_FORCE_STRATEGY
 */  
        DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY,
        return DOCVALUES_MAX_BATCH_SIZE.get(settings);
import org.opensearch.common.settings.Settings;  
     * Whether the indexed stream asks parquet to apply the residual predicate during
            snapshot = WireConfigSnapshot.builder(snapshot).minSkipRunSelectivityThreshold(newValue).build();
     * Returns the current pre-computed wire config snapshot. This is a single
     * Default minimum run length (in rows) below which the indexed stream skips
     *
        Setting.Property.NodeScope,  
        DataFusionPlugin.DATAFUSION_MEMORY_GUARD_EXECUTION_SPILL_THRESHOLD,
    public static final Setting<Integer> DOCVALUES_MAX_BATCH_SIZE = Setting.intSetting(
        Setting.Property.NodeScope,  
     * {@link #DOCVALUES_MAX_BATCH_SIZE}, and a jump beyond the current window halves it back
     * {@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING}.  
     * asks to start above the ceiling is resolved down rather than rejected.
     * Creates the settings holder, builds the initial {@link WireConfigSnapshot} from  
        CacheSettings.OFFSET_INDEX_CACHE_PERCENT,  
        1,  
     * @param settings index settings, or {@link Settings#EMPTY} to take the defaults  
        Setting.Property.Dynamic  
    /**
    /**
 * The OpenSearch Contributors require contributions made to  
    );
     * <ul>
        switch (value) {
    }  
        Setting.Property.NodeScope,  
            case "boolean_mask":
        return Math.min(DOCVALUES_INITIAL_BATCH_SIZE.get(settings), docValuesMaxBatchSize(settings));  
    private static int deriveTargetPartitions(String mode, int maxSliceCount) {
    public WireConfigSnapshot getSnapshot() {
        0.1,
        1.0,
    /**
        1,
import org.opensearch.be.datafusion.cache.CacheSettings;
        1,
            long v = Long.parseLong(s);
    /**
        Setting.Property.Dynamic  
        });  
    }
        DataFusionPlugin.DATAFUSION_MEMORY_GUARD_EXECUTION_CRITICAL_THRESHOLD,
        Setting.Property.NodeScope,
     * towards this value. Start small so sparse access does not decode rows nobody reads.  
    /** Default starting size of a doc-values decode window, in rows. */
    }
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);
        CacheSettings.METADATA_CACHE_ENABLED,
    // ── New indexed query settings ──
     * Package-private constructor for testing — builds the initial snapshot from
     * from row-selection mode to full-decode mode. A low threshold (e.g., 0.03) means  
    // ── Snapshot management ──
     * after the change; a cursor keeps the value it opened with for its lifetime.
        "datafusion.indexed.min_skip_run_default",  
        }
     *
     */
    /** Maps the {@link #INDEXED_FORCE_STRATEGY} string to the Rust wire code (-1/0/1). */  
        this.concurrentSearchMode = SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.get(settings);  
     * <p>  
    }
     * {@code execution.parquet.pushdown_filters} session option.
            .minSkipRunDefault(INDEXED_MIN_SKIP_RUN_DEFAULT.get(settings))
        });
        CacheSettings.STATISTICS_CACHE_EVICTION_TYPE,
        // Runtime settings — memory pool, spill, reduce input mode, and budget tuning
    );
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
    public static final Setting<Boolean> LISTING_TABLE_PUSHDOWN_FILTERS = Setting.boolSetting(  
     * letting candidate selectivity decide. Accepts:  
        false,
    /** Fragment executor concurrency gate multiplier: max concurrent partition-equivalents = cpu_threads × multiplier. */  
     */
 * reads the snapshot with zero per-query overhead — no {@code ClusterService} lookup on the
     * (skip non-matching rows), but a filter matching 5% switches to full-decode
        return Math.min(maxSliceCount, Runtime.getRuntime().availableProcessors());
 * plus the new indexed query settings) and manages the pre-computed {@link WireConfigSnapshot}.  
     * Index-scoped because the useful range follows the file's page layout, which is itself
import org.opensearch.cluster.service.ClusterService;
            .listingTablePushdownFilters(LISTING_TABLE_PUSHDOWN_FILTERS.get(settings))  
     * the cluster service's settings, and registers listeners for dynamic updates.
     */  
    }
    static String derivePoolMinDefault(Settings settings, int percent) {  
        Setting.Property.Dynamic
import org.opensearch.common.settings.ClusterSettings;
            snapshot = WireConfigSnapshot.builder(snapshot).batchSize(newValue).build();
     * selections benefit from decode-time filtering; when false, the indexed stream
     * Starting size of the decode window a doc-values cursor asks Parquet for, in rows
        DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT,
     * Ceiling the adaptive doc-values decode window grows to, in rows
