                PS_INSTRUMENTED_COUNT,
            (long) CACHE_STATS_MEMORY_BYTES.get(seg, 0L),
     *
import org.opensearch.be.datafusion.stats.PartitionGateStats;
            (long) handles[5].get(seg, 0L),
    private static final String[] TASK_MONITOR_FIELDS = {
        "total_wait_duration_ms",
     * @return a populated PartitionGateStats instance
    private static final VarHandle SS_PARQUET_PROCESSING_TIME_MS = handle("search_stats", "parquet_processing_time_ms");
    private static final VarHandle CACHE_OI_MISS_COUNT = cacheHandle("offset_index_cache", "miss_count");
    private static VarHandle[] taskMonitorHandles(String group) {
     * @return a populated SearchStats instance
            ValueLayout.JAVA_LONG.withName("memory_bytes"),
    private static final String[] SEARCH_STATS_FIELDS = {
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
        "total_idle_duration_ms",
    }
     */
        "elapsed_compute_ms",
    private static final VarHandle DG_ACTIVE_PERMITS = handle("fragment_executor_gate", "active_permits");
     * @param field the field name (e.g. "workers_count")
            PathElement.groupElement(field)
        "on_batch_mask_time_ms",
            (long) SS_OBJECT_STORE_READ_TIME_MS.get(seg, 0L)
    // ---- VarHandles for io_runtime fields ----
            .withName(name);
            ValueLayout.JAVA_LONG.withName("target_max_permits"),
            (long) handles[0].get(seg, 0L),
    // ---- VarHandles for plan_setup fields ----
                IO_TOTAL_OVERFLOW_COUNT,
    private static final VarHandle CACHE_OI_SIZE_LIMIT_BYTES = cacheHandle("offset_index_cache", "size_limit_bytes");
    }
    private static final String[] PARTITION_GATE_FIELDS = {
    }
 * <p>The layout contains 10 named groups (2 runtime × 9 fields + 4 task monitor × 5 fields
            (long) SS_ON_BATCH_MASK_TIME_MS.get(seg, 0L),
        );
        cacheStatsGroup("cache_stats"),
public final class StatsLayout {
            (long) CACHE_CI_MISS_COUNT.get(seg, 0L),
    private static final VarHandle PS_TOTAL_POLL_DURATION_MS = handle("plan_setup", "total_poll_duration_ms");
        "pending_acquire_permits",
            (long) SS_BITMAP_TREE_SCAN.get(seg, 0L),
        "listing_table_scan",
                QE_TOTAL_IDLE_DURATION_MS,
        "target_max_permits",
    private static final VarHandle SS_PARQUET_BYTES_SCANNED = handle("search_stats", "parquet_bytes_scanned");
    }
    private static final VarHandle SN_TOTAL_IDLE_DURATION_MS = handle("stream_next", "total_idle_duration_ms");
            cacheGroup("column_index_cache"),
     * @param seg   the memory segment containing the DfStatsBuffer
    public static PartitionGateStats readPartitionGate(MemorySegment seg, String group, String displayName) {
            (long) handles[1].get(seg, 0L),
        partitionGateGroup("fragment_executor_gate"),
            (long) handles[6].get(seg, 0L),
 * compatible open source license.
        CacheGroupStats columnIndex = new CacheGroupStats(
    public static long readField(MemorySegment seg, String group, String field) {
            (long) SS_PARQUET_SCAN_UNTIL_DATA_TIME_MS.get(seg, 0L),
        return MemoryLayout.structLayout(ValueLayout.JAVA_LONG.withName("fallbacks"), ValueLayout.JAVA_LONG.withName("rejections"))
        CacheGroupStats offsetIndex = new CacheGroupStats(
     * @return a populated CacheStats instance with metadata + statistics sub-groups
    private static final VarHandle CR_TOTAL_SCHEDULED_DURATION_MS = handle("coordinator_reduce", "total_scheduled_duration_ms");
            ValueLayout.JAVA_LONG.withName("total_local_queue_depth")
     * @param seg   the memory segment containing the DfStatsBuffer
    private static VarHandle[] partitionGateHandles(String group) {
    /**
}
                PS_TOTAL_SCHEDULED_DURATION_MS,
            (long) handles[4].get(seg, 0L),
     * @return a populated TaskMonitorStats instance
    // ---- VarHandles for cache_stats.column_index_cache fields ----
    }
        );
    private static final VarHandle QE_INSTRUMENTED_COUNT = handle("query_execution", "instrumented_count");
     * @param group       "fragment_executor_gate" (layout key)
import org.opensearch.be.datafusion.stats.CacheStats;
    // ---- VarHandles for cache_stats.metadata_cache fields ----
    private static final VarHandle DG_PENDING_ACQUIRE_BATCHES = handle("fragment_executor_gate", "pending_acquire_batches");
            (long) CACHE_OI_SIZE_LIMIT_BYTES.get(seg, 0L)
            (long) CACHE_OI_MISS_COUNT.get(seg, 0L),
        "total_batches_started",
        "active_permits",
                DG_MAX_PERMITS,
    }
    private static final VarHandle AB_REJECTIONS = handle("adaptive_budget", "rejections");
    static {
            (long) handles[4].get(seg, 0L),
                SN_INSTRUMENTED_COUNT,
            ValueLayout.JAVA_LONG.withName("total_polls_count"),
    /**
            ValueLayout.JAVA_LONG.withName("total_batches_started"),
    private static StructLayout partitionGateGroup(String name) {
    }
            case "fragment_executor_gate" -> new VarHandle[] {
    private static final VarHandle CACHE_CI_HIT_COUNT = cacheHandle("column_index_cache", "hit_count");
     *
    private static final VarHandle CACHE_META_SIZE_LIMIT_BYTES = cacheHandle("metadata_cache", "size_limit_bytes");
    private static final VarHandle QE_DROPPED_COUNT = handle("query_execution", "dropped_count");
            ValueLayout.JAVA_LONG.withName("instrumented_count"),
 *
    private static VarHandle[] runtimeHandles(String group) {
            (long) CACHE_STATS_HIT_COUNT.get(seg, 0L),
            ValueLayout.JAVA_LONG.withName("blocking_queue_depth"),
import java.lang.foreign.StructLayout;
        "instrumented_count",
                PS_TOTAL_POLL_DURATION_MS,
     * @param seg the memory segment containing the DfStatsBuffer
            (long) handles[4].get(seg, 0L)
            case "coordinator_reduce" -> new VarHandle[] {
            ValueLayout.JAVA_LONG.withName("total_overflow_count"),
        "prefetch_wait_time_ms",
    private static final VarHandle SN_TOTAL_POLL_DURATION_MS = handle("stream_next", "total_poll_duration_ms");
        return new TaskMonitorStats(
            (long) handles[2].get(seg, 0L),
    private static final VarHandle SS_RG_SKIPPED = handle("search_stats", "rg_skipped");
        "single_collector_scan",
            ValueLayout.JAVA_LONG.withName("elapsed_compute_ms"),
            (long) CACHE_META_MISS_COUNT.get(seg, 0L),
        "build_mask_time_ms",
     * Read a partition gate group (8 fields) from the segment.
    }
            (long) handles[6].get(seg, 0L),
        ).withName(name);
    private static final VarHandle CPU_SPAWNED_TASKS_COUNT = handle("cpu_runtime", "spawned_tasks_count");
            ValueLayout.JAVA_LONG.withName("total_wait_duration_ms"),
    private static final VarHandle IO_GLOBAL_QUEUE_DEPTH = handle("io_runtime", "global_queue_depth");
            ValueLayout.JAVA_LONG.withName("parquet_bytes_scanned"),
            displayName,
            ValueLayout.JAVA_LONG.withName("hit_count"),
            (long) SS_RG_SKIPPED.get(seg, 0L),
            (long) handles[3].get(seg, 0L),
            PathElement.groupElement("cache_stats"),
                QE_DROPPED_COUNT };
                DG_TOTAL_WAIT_DURATION_MS,
import org.opensearch.be.datafusion.stats.CacheGroupStats;
    private static final VarHandle IO_TOTAL_OVERFLOW_COUNT = handle("io_runtime", "total_overflow_count");
            (long) SS_BUILD_MASK_TIME_MS.get(seg, 0L),
    private static final VarHandle SS_ON_BATCH_MASK_TIME_MS = handle("search_stats", "on_batch_mask_time_ms");
    private static final VarHandle CR_TOTAL_IDLE_DURATION_MS = handle("coordinator_reduce", "total_idle_duration_ms");
     */
     *
            throw new AssertionError("StatsLayout size mismatch: expected " + (85 * Long.BYTES) + " but got " + LAYOUT.byteSize());
        "total_polls_count",
        return MemoryLayout.structLayout(
        "poison_permits",
     */
    private static final VarHandle SN_DROPPED_COUNT = handle("stream_next", "dropped_count");
        return LAYOUT.varHandle(PathElement.groupElement(group), PathElement.groupElement(field));
            ValueLayout.JAVA_LONG.withName("size_limit_bytes")
    /** The struct layout mirroring Rust's {@code DfStatsBuffer}. */
import java.lang.foreign.ValueLayout;
                SN_TOTAL_POLL_DURATION_MS,
            (long) CACHE_META_MEMORY_BYTES.get(seg, 0L),
            (long) SS_FILTER_RECORD_BATCH_TIME_MS.get(seg, 0L),
        "bitmap_tree_scan",
            ValueLayout.JAVA_LONG.withName("spawned_tasks_count"),
        );
        "total_scheduled_duration_ms",
    public static final StructLayout LAYOUT = MemoryLayout.structLayout(
     * @return a populated PartitionGateStats instance
    public static CacheStats readCacheStats(MemorySegment seg) {
        "parquet_scan_until_data_time_ms",
            case "io_runtime" -> new VarHandle[] {
            ValueLayout.JAVA_LONG.withName("poison_permits"),
import java.lang.foreign.MemoryLayout;
            (long) SS_PREFETCH_WAIT_COUNT.get(seg, 0L),
    private static final VarHandle CACHE_CI_MEMORY_BYTES = cacheHandle("column_index_cache", "memory_bytes");
     * Read a single field from the segment.
     * @param seg the memory segment containing the DfStatsBuffer
                CR_TOTAL_POLL_DURATION_MS,
        );
    private static final VarHandle QE_TOTAL_IDLE_DURATION_MS = handle("query_execution", "total_idle_duration_ms");
            ValueLayout.JAVA_LONG.withName("rg_processed"),
    }
        return new SearchStats(
        ).withName(name);
     *
     *
            case "cpu_runtime" -> new VarHandle[] {
            cacheGroup("metadata_cache"),
    private static final VarHandle CACHE_META_ENTRY_COUNT = cacheHandle("metadata_cache", "entry_count");
        "total_busy_duration_ms",
            (long) CACHE_STATS_ENTRY_COUNT.get(seg, 0L),
            (long) SS_PARQUET_PROCESSING_TIME_MS.get(seg, 0L),
    private static final VarHandle SS_LISTING_TABLE_SCAN = handle("search_stats", "listing_table_scan");
            ValueLayout.JAVA_LONG.withName("max_permits"),
    private static final VarHandle SS_PARQUET_SCAN_UNTIL_DATA_TIME_MS = handle("search_stats", "parquet_scan_until_data_time_ms");
        "workers_count",
    private static final VarHandle CACHE_OI_ENTRY_COUNT = cacheHandle("offset_index_cache", "entry_count");
        "delegation_calls",
        }
            (long) CACHE_CI_HIT_COUNT.get(seg, 0L),
    }
            (long) CACHE_META_SIZE_LIMIT_BYTES.get(seg, 0L)
    private static final VarHandle IO_BLOCKING_QUEUE_DEPTH = handle("io_runtime", "blocking_queue_depth");
                PS_TOTAL_IDLE_DURATION_MS,
     */
     */
     *
            ValueLayout.JAVA_LONG.withName("object_store_read_time_ms")
        };
    /**
            ValueLayout.JAVA_LONG.withName("prefetch_wait_count"),
    private static StructLayout taskMonitorGroup(String name) {
                CPU_GLOBAL_QUEUE_DEPTH,
    private static final VarHandle DG_PENDING_ACQUIRE_PERMITS = handle("fragment_executor_gate", "pending_acquire_permits");
    /**
    private static final VarHandle QE_TOTAL_POLL_DURATION_MS = handle("query_execution", "total_poll_duration_ms");
    private static final VarHandle CACHE_OI_HIT_COUNT = cacheHandle("offset_index_cache", "hit_count");
            (long) CACHE_CI_ENTRY_COUNT.get(seg, 0L),
            (long) handles[0].get(seg, 0L),
    private static StructLayout runtimeGroup(String name) {
            (long) handles[2].get(seg, 0L),
                DG_PENDING_ACQUIRE_PERMITS,
    private static final VarHandle CR_DROPPED_COUNT = handle("coordinator_reduce", "dropped_count");
            (long) CACHE_STATS_MISS_COUNT.get(seg, 0L),
    private static final VarHandle DG_TARGET_MAX_PERMITS = handle("fragment_executor_gate", "target_max_permits");
     * @return a populated AdaptiveBudgetStats instance
        "parquet_processing_time_ms",
        return new PartitionGateStats(
    private static VarHandle cacheHandle(String subGroup, String field) {
    public static SearchStats readSearchStats(MemorySegment seg) {
                CPU_BLOCKING_QUEUE_DEPTH,
            (long) CACHE_STATS_SIZE_LIMIT_BYTES.get(seg, 0L)
    // ---- VarHandles for adaptive_budget fields ----
        return MemoryLayout.structLayout(
            ValueLayout.JAVA_LONG.withName("global_queue_depth"),
     * Read a task monitor group (5 fields) from the segment.
    /**
        adaptiveBudgetGroup("adaptive_budget"),
            (long) SS_DELEGATION_CALLS.get(seg, 0L),
        "max_permits",
        ).withName(name);
                CR_TOTAL_IDLE_DURATION_MS,
     * @param group one of the OperationType keys
        "dropped_count" };
    private static final VarHandle CACHE_CI_MISS_COUNT = cacheHandle("column_index_cache", "miss_count");
     */
    private static final VarHandle DG_TOTAL_WAIT_DURATION_MS = handle("fragment_executor_gate", "total_wait_duration_ms");
                CR_INSTRUMENTED_COUNT,
     */
                DG_ACTIVE_PERMITS,
            (long) CACHE_OI_HIT_COUNT.get(seg, 0L),
    private static final VarHandle DG_MAX_PERMITS = handle("fragment_executor_gate", "max_permits");
            (long) handles[3].get(seg, 0L),
    private static StructLayout searchStatsGroup(String name) {
    private static final VarHandle CACHE_STATS_SIZE_LIMIT_BYTES = cacheHandle("statistics_cache", "size_limit_bytes");
    private static final VarHandle CACHE_META_MISS_COUNT = cacheHandle("metadata_cache", "miss_count");
    private static final VarHandle CACHE_META_MEMORY_BYTES = cacheHandle("metadata_cache", "memory_bytes");
        return readPartitionGate(seg, group, group);
                CPU_SPAWNED_TASKS_COUNT,
        CacheGroupStats statistics = new CacheGroupStats(
    public static TaskMonitorStats readTaskMonitor(MemorySegment seg, String group) {
            (long) handles[0].get(seg, 0L),
                DG_PENDING_ACQUIRE_BATCHES };
    /**
                CPU_TOTAL_OVERFLOW_COUNT,
        };
import org.opensearch.be.datafusion.stats.SearchStats;
            case "query_execution" -> new VarHandle[] {
            ValueLayout.JAVA_LONG.withName("bitmap_tree_scan"),
    private static final String[] ADAPTIVE_BUDGET_FIELDS = { "fallbacks", "rejections" };
     * Read the adaptive budget group (2 fields) from the segment.
                QE_TOTAL_SCHEDULED_DURATION_MS,
        "total_poll_duration_ms",
            ValueLayout.JAVA_LONG.withName("total_idle_duration_ms"),
                IO_GLOBAL_QUEUE_DEPTH,
    private static final VarHandle PS_INSTRUMENTED_COUNT = handle("plan_setup", "instrumented_count");
            ValueLayout.JAVA_LONG.withName("active_permits"),
import java.lang.foreign.MemoryLayout.PathElement;
        return MemoryLayout.structLayout(
    /**
    private static final VarHandle CACHE_STATS_ENTRY_COUNT = cacheHandle("statistics_cache", "entry_count");
            ValueLayout.JAVA_LONG.withName("delegation_calls"),
    private static final VarHandle SS_OBJECT_STORE_READ_TIME_MS = handle("search_stats", "object_store_read_time_ms");
    // ---- VarHandles for search_stats fields ----
        return new CacheStats(metadata, statistics, columnIndex, offsetIndex);
    private static final VarHandle IO_TOTAL_BUSY_DURATION_MS = handle("io_runtime", "total_busy_duration_ms");
 */
    private static final VarHandle PS_DROPPED_COUNT = handle("plan_setup", "dropped_count");
 * + 1 partition gate × 8 fields + 1 adaptive budget × 2 fields + 1 cache stats × 10 fields
            ValueLayout.JAVA_LONG.withName("single_collector_scan"),
            ValueLayout.JAVA_LONG.withName("build_mask_time_ms"),
import java.lang.foreign.MemorySegment;
                PS_DROPPED_COUNT };
     * @param seg   the memory segment containing the DfStatsBuffer
    public static AdaptiveBudgetStats readAdaptiveBudgetStats(MemorySegment seg) {
    // ---- VarHandles for coordinator_reduce fields ----
    private static final VarHandle IO_TOTAL_LOCAL_QUEUE_DEPTH = handle("io_runtime", "total_local_queue_depth");
                QE_INSTRUMENTED_COUNT,
     * Read the search_stats group (17 fields) from the segment.
        "num_alive_tasks",
            (long) handles[1].get(seg, 0L),
            ValueLayout.JAVA_LONG.withName("prefetch_wait_time_ms"),
    private static final VarHandle SS_BITMAP_TREE_SCAN = handle("search_stats", "bitmap_tree_scan");
    private static final VarHandle IO_TOTAL_POLLS_COUNT = handle("io_runtime", "total_polls_count");
        runtimeGroup("cpu_runtime"),
            ValueLayout.JAVA_LONG.withName("miss_count"),
        return LAYOUT.varHandle(
            case "stream_next" -> new VarHandle[] {
                CPU_TOTAL_POLLS_COUNT,
    private static final VarHandle SS_FILTER_RECORD_BATCH_TIME_MS = handle("search_stats", "filter_record_batch_time_ms");
    }
            (long) CACHE_META_ENTRY_COUNT.get(seg, 0L),
            ValueLayout.JAVA_LONG.withName("listing_table_scan"),
    private static final VarHandle SN_INSTRUMENTED_COUNT = handle("stream_next", "instrumented_count");
/**
            ValueLayout.JAVA_LONG.withName("parquet_scan_total_time_ms"),
            ValueLayout.JAVA_LONG.withName("dropped_count")
            (long) SS_PARQUET_SCAN_TOTAL_TIME_MS.get(seg, 0L),
    }
                IO_TOTAL_BUSY_DURATION_MS,
    private static final VarHandle CPU_WORKERS_COUNT = handle("cpu_runtime", "workers_count");
     * Read a runtime metrics group (8 fields) from the segment.
        CacheGroupStats metadata = new CacheGroupStats(
    private static final VarHandle SS_RG_PROCESSED = handle("search_stats", "rg_processed");
                CPU_TOTAL_LOCAL_QUEUE_DEPTH };
            (long) SS_SINGLE_COLLECTOR_SCAN.get(seg, 0L),
                QE_TOTAL_POLL_DURATION_MS,
            (long) handles[8].get(seg, 0L)
     * @param group the group name (e.g. "io_runtime", "cpu_runtime")
                IO_TOTAL_LOCAL_QUEUE_DEPTH };
    // ---- VarHandles for cache_stats.offset_index_cache fields ----
    // ---- VarHandles for cache_stats.statistics_cache fields ----
            default -> throw new IllegalArgumentException("Unknown task monitor group: " + group);
            (long) SS_RG_PROCESSED.get(seg, 0L),
        };
        "spawned_tasks_count",
            (long) SS_PARQUET_BYTES_SCANNED.get(seg, 0L),
    private static final VarHandle PS_TOTAL_IDLE_DURATION_MS = handle("plan_setup", "total_idle_duration_ms");
    private static final VarHandle CPU_TOTAL_OVERFLOW_COUNT = handle("cpu_runtime", "total_overflow_count");
 * SPDX-License-Identifier: Apache-2.0
        return MemoryLayout.structLayout(
        "total_local_queue_depth" };
            ValueLayout.JAVA_LONG.withName("total_busy_duration_ms"),
        taskMonitorGroup("plan_setup"),
import java.lang.invoke.VarHandle;
        );
    }
        taskMonitorGroup("query_execution"),
        return (long) handle(group, field).get(seg, 0L);
            (long) handles[1].get(seg, 0L),
        "filter_record_batch_time_ms",
                IO_BLOCKING_QUEUE_DEPTH,
            PathElement.groupElement(subGroup),
    private static final VarHandle CPU_BLOCKING_QUEUE_DEPTH = handle("cpu_runtime", "blocking_queue_depth");
            (long) CACHE_CI_SIZE_LIMIT_BYTES.get(seg, 0L)
            (long) SS_ELAPSED_COMPUTE_MS.get(seg, 0L),
    // ---- VarHandles for cpu_runtime fields ----
     * @param seg   the memory segment containing the DfStatsBuffer
    /**
        VarHandle[] handles = taskMonitorHandles(group);
     *
            ValueLayout.JAVA_LONG.withName("rg_skipped"),
     * @return a populated RuntimeMetrics instance
 * Defines the {@code MemoryLayout.structLayout} mirroring the Rust {@code DfStatsBuffer}
        "rg_processed",
    }
                IO_WORKERS_COUNT,
        return new RuntimeMetrics(
     * @param seg the memory segment containing the DfStatsBuffer
        searchStatsGroup("search_stats")
        );
    private static final VarHandle CACHE_STATS_MEMORY_BYTES = cacheHandle("statistics_cache", "memory_bytes");
    }
            ValueLayout.JAVA_LONG.withName("num_alive_tasks"),
            (long) SS_LISTING_TABLE_SCAN.get(seg, 0L),
        "blocking_queue_depth",
        taskMonitorGroup("stream_next"),
    private static final VarHandle PS_TOTAL_SCHEDULED_DURATION_MS = handle("plan_setup", "total_scheduled_duration_ms");
                DG_TOTAL_BATCHES_STARTED,
            case "plan_setup" -> new VarHandle[] {
    private StatsLayout() {}
    private static final VarHandle CACHE_STATS_MISS_COUNT = cacheHandle("statistics_cache", "miss_count");
                IO_NUM_ALIVE_TASKS,
            ValueLayout.JAVA_LONG.withName("workers_count"),
            ValueLayout.JAVA_LONG.withName("parquet_scan_until_data_time_ms"),
    public static PartitionGateStats readPartitionGate(MemorySegment seg, String group) {
    private static final VarHandle SS_PARQUET_SCAN_TOTAL_TIME_MS = handle("search_stats", "parquet_scan_total_time_ms");
        return MemoryLayout.structLayout(
            (long) handles[5].get(seg, 0L),
            (long) handles[7].get(seg, 0L),
            default -> throw new IllegalArgumentException("Unknown partition gate group: " + group);
    private static StructLayout cacheGroup(String name) {
    private static final VarHandle CR_INSTRUMENTED_COUNT = handle("coordinator_reduce", "instrumented_count");
        return switch (group) {
        return MemoryLayout.structLayout(
    private static final VarHandle IO_WORKERS_COUNT = handle("io_runtime", "workers_count");
     * Read partition gate stats from the native buffer with a custom display name.
                DG_TARGET_MAX_PERMITS,
 * this file be licensed under the Apache-2.0 license or a
     * @param group "io_runtime" or "cpu_runtime"
    // ---- VarHandles for fragment_executor_gate fields ----
        return new AdaptiveBudgetStats((long) AB_FALLBACKS.get(seg, 0L), (long) AB_REJECTIONS.get(seg, 0L));
        runtimeGroup("io_runtime"),
    private static StructLayout cacheStatsGroup(String name) {
import org.opensearch.be.datafusion.stats.AdaptiveBudgetStats;
        );
    private static final VarHandle IO_SPAWNED_TASKS_COUNT = handle("io_runtime", "spawned_tasks_count");
        "parquet_bytes_scanned",
    private static final VarHandle CPU_NUM_ALIVE_TASKS = handle("cpu_runtime", "num_alive_tasks");
        "prefetch_wait_count",
    private static final VarHandle IO_NUM_ALIVE_TASKS = handle("io_runtime", "num_alive_tasks");
        if (LAYOUT.byteSize() != 85 * Long.BYTES) {
    }
                CR_TOTAL_SCHEDULED_DURATION_MS,
        taskMonitorGroup("coordinator_reduce"),
 *
                SN_TOTAL_SCHEDULED_DURATION_MS,
     * @param seg         the memory segment containing the DfStatsBuffer
            (long) CACHE_OI_ENTRY_COUNT.get(seg, 0L),
    private static final VarHandle CPU_TOTAL_LOCAL_QUEUE_DEPTH = handle("cpu_runtime", "total_local_queue_depth");
    private static final VarHandle CACHE_OI_MEMORY_BYTES = cacheHandle("offset_index_cache", "memory_bytes");
                IO_SPAWNED_TASKS_COUNT,
     * @return the long value at the specified path
        );
        "object_store_read_time_ms" };
            ValueLayout.JAVA_LONG.withName("filter_record_batch_time_ms"),
    }
    private static final VarHandle QE_TOTAL_SCHEDULED_DURATION_MS = handle("query_execution", "total_scheduled_duration_ms");
    private static final String[] CACHE_GROUP_FIELDS = { "hit_count", "miss_count", "entry_count", "memory_bytes", "size_limit_bytes" };
    );
        "pending_acquire_batches" };
    }
            ValueLayout.JAVA_LONG.withName("pending_acquire_permits"),
                SN_DROPPED_COUNT };
            (long) CACHE_OI_MEMORY_BYTES.get(seg, 0L),
                CPU_NUM_ALIVE_TASKS,
    private static final VarHandle SS_PREFETCH_WAIT_TIME_MS = handle("search_stats", "prefetch_wait_time_ms");
            ValueLayout.JAVA_LONG.withName("total_poll_duration_ms"),
        ).withName(name);
            (long) SS_PREFETCH_WAIT_TIME_MS.get(seg, 0L),
    private static final VarHandle CACHE_STATS_HIT_COUNT = cacheHandle("statistics_cache", "hit_count");
            (long) handles[3].get(seg, 0L),
     *
    }
    // ---- VarHandles for query_execution fields ----
            (long) CACHE_CI_MEMORY_BYTES.get(seg, 0L),
    private static final VarHandle DG_TOTAL_BATCHES_STARTED = handle("fragment_executor_gate", "total_batches_started");
    }
 * The OpenSearch Contributors require contributions made to
    private static final VarHandle CPU_TOTAL_POLLS_COUNT = handle("cpu_runtime", "total_polls_count");
            default -> throw new IllegalArgumentException("Unknown runtime group: " + group);
    private static final VarHandle SS_PREFETCH_WAIT_COUNT = handle("search_stats", "prefetch_wait_count");
            ValueLayout.JAVA_LONG.withName("entry_count"),
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
        VarHandle[] handles = runtimeHandles(group);
            ValueLayout.JAVA_LONG.withName("on_batch_mask_time_ms"),
     * @param displayName the JSON key name to use when serializing
        );
    private static final VarHandle AB_FALLBACKS = handle("adaptive_budget", "fallbacks");
        return switch (group) {
    private static final VarHandle SS_DELEGATION_CALLS = handle("search_stats", "delegation_calls");
    private static final VarHandle CPU_TOTAL_BUSY_DURATION_MS = handle("cpu_runtime", "total_busy_duration_ms");
            cacheGroup("offset_index_cache")
    private static final String[] RUNTIME_FIELDS = {
        ).withName(name);
    private static final VarHandle CACHE_CI_SIZE_LIMIT_BYTES = cacheHandle("column_index_cache", "size_limit_bytes");
     * @param group "fragment_executor_gate"
    // ---- VarHandles for stream_next fields ----
     * Read the cache_stats group (10 fields, 2 sub-caches × 5 fields each).
        "global_queue_depth",
                IO_TOTAL_POLLS_COUNT,
 * + 1 search stats × 17 fields = 85 longs = 680 bytes). The cache stats group holds three sub-caches × 5 fields each: metadata, statistics, and scoped page-index..
                CPU_TOTAL_BUSY_DURATION_MS,
    public static RuntimeMetrics readRuntimeMetrics(MemorySegment seg, String group) {
 * and provides {@link VarHandle} accessors for each field via layout path navigation.
    private static final VarHandle CACHE_CI_ENTRY_COUNT = cacheHandle("column_index_cache", "entry_count");
        VarHandle[] handles = partitionGateHandles(group);
        return switch (group) {
                CPU_WORKERS_COUNT,
/*
    // ---- Private helpers ----
        "parquet_scan_total_time_ms",
package org.opensearch.be.datafusion.nativelib;
    private static final VarHandle SS_ELAPSED_COMPUTE_MS = handle("search_stats", "elapsed_compute_ms");
 */
                DG_POISON_PERMITS,
    private static VarHandle handle(String group, String field) {
            (long) handles[7].get(seg, 0L)
            (long) CACHE_META_HIT_COUNT.get(seg, 0L),
                CR_DROPPED_COUNT };
    private static final VarHandle CR_TOTAL_POLL_DURATION_MS = handle("coordinator_reduce", "total_poll_duration_ms");
        "rg_skipped",
    /**
    private static StructLayout adaptiveBudgetGroup(String name) {
        ).withName(name);
    }
    private static final VarHandle CPU_GLOBAL_QUEUE_DEPTH = handle("cpu_runtime", "global_queue_depth");
            ValueLayout.JAVA_LONG.withName("total_scheduled_duration_ms"),
                SN_TOTAL_IDLE_DURATION_MS,
     */
            cacheGroup("statistics_cache"),
            ValueLayout.JAVA_LONG.withName("pending_acquire_batches")
            ValueLayout.JAVA_LONG.withName("parquet_processing_time_ms"),
    private static final VarHandle SS_SINGLE_COLLECTOR_SCAN = handle("search_stats", "single_collector_scan");
    private static final VarHandle DG_POISON_PERMITS = handle("fragment_executor_gate", "poison_permits");
            (long) handles[2].get(seg, 0L),
    private static final VarHandle SS_BUILD_MASK_TIME_MS = handle("search_stats", "build_mask_time_ms");
        "total_overflow_count",
    private static final VarHandle CACHE_META_HIT_COUNT = cacheHandle("metadata_cache", "hit_count");
    private static final VarHandle SN_TOTAL_SCHEDULED_DURATION_MS = handle("stream_next", "total_scheduled_duration_ms");
