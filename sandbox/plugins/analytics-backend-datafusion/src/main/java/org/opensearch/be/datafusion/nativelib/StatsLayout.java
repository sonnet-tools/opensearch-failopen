        "max_permits",  
    /**  
            (long) handles[1].get(seg, 0L),
            (long) CACHE_META_SIZE_LIMIT_BYTES.get(seg, 0L)  
    private static final VarHandle SS_LISTING_TABLE_SCAN = handle("search_stats", "listing_table_scan");
     * @param group the group name (e.g. "io_runtime", "cpu_runtime")
            ValueLayout.JAVA_LONG.withName("miss_count"),
            ValueLayout.JAVA_LONG.withName("rg_processed"),
 *
import org.opensearch.be.datafusion.stats.AdaptiveBudgetStats;
            (long) CACHE_CI_HIT_COUNT.get(seg, 0L),
    // ---- VarHandles for cache_stats.metadata_cache fields ----
            (long) CACHE_OI_MEMORY_BYTES.get(seg, 0L),
    }
        searchStatsGroup("search_stats")
            ValueLayout.JAVA_LONG.withName("total_poll_duration_ms"),
        );
            ValueLayout.JAVA_LONG.withName("num_alive_tasks"),
            (long) SS_RG_SKIPPED.get(seg, 0L),  
    private static final VarHandle IO_WORKERS_COUNT = handle("io_runtime", "workers_count");
        };
package org.opensearch.be.datafusion.nativelib;
                DG_TOTAL_BATCHES_STARTED,
    private static final VarHandle QE_TOTAL_IDLE_DURATION_MS = handle("query_execution", "total_idle_duration_ms");  
    private static final VarHandle CR_TOTAL_SCHEDULED_DURATION_MS = handle("coordinator_reduce", "total_scheduled_duration_ms");
     * Read a partition gate group (8 fields) from the segment.
    }
        "pending_acquire_batches" };
    public static CacheStats readCacheStats(MemorySegment seg) {  
    private static final VarHandle DG_TOTAL_WAIT_DURATION_MS = handle("fragment_executor_gate", "total_wait_duration_ms");  
     *
     * @return a populated AdaptiveBudgetStats instance
        return MemoryLayout.structLayout(ValueLayout.JAVA_LONG.withName("fallbacks"), ValueLayout.JAVA_LONG.withName("rejections"))
            (long) SS_OBJECT_STORE_READ_TIME_MS.get(seg, 0L)
import java.lang.foreign.MemorySegment;
                SN_TOTAL_POLL_DURATION_MS,
    // ---- VarHandles for plan_setup fields ----
            (long) CACHE_STATS_MEMORY_BYTES.get(seg, 0L),  
        return new RuntimeMetrics(  
        "listing_table_scan",
            ValueLayout.JAVA_LONG.withName("entry_count"),
            ValueLayout.JAVA_LONG.withName("size_limit_bytes")
        "parquet_bytes_scanned",
                CPU_NUM_ALIVE_TASKS,  
            (long) SS_DELEGATION_CALLS.get(seg, 0L),
    private static final VarHandle DG_ACTIVE_PERMITS = handle("fragment_executor_gate", "active_permits");
            (long) CACHE_OI_ENTRY_COUNT.get(seg, 0L),
            ValueLayout.JAVA_LONG.withName("total_overflow_count"),
     * @param seg         the memory segment containing the DfStatsBuffer  
        return MemoryLayout.structLayout(
    private static final VarHandle SS_BITMAP_TREE_SCAN = handle("search_stats", "bitmap_tree_scan");  
    );
            (long) CACHE_STATS_HIT_COUNT.get(seg, 0L),  
        "total_batches_started",  
    private static final VarHandle SS_PARQUET_PROCESSING_TIME_MS = handle("search_stats", "parquet_processing_time_ms");  
    private static final VarHandle IO_TOTAL_POLLS_COUNT = handle("io_runtime", "total_polls_count");  
        "prefetch_wait_count",
     * Read the adaptive budget group (2 fields) from the segment.
    private static final VarHandle SS_RG_PROCESSED = handle("search_stats", "rg_processed");
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
    private static final VarHandle CACHE_STATS_HIT_COUNT = cacheHandle("statistics_cache", "hit_count");
    /**
        );
                QE_INSTRUMENTED_COUNT,
                PS_TOTAL_POLL_DURATION_MS,
        taskMonitorGroup("coordinator_reduce"),  
    }
    }
import java.lang.invoke.VarHandle;
    private static StructLayout partitionGateGroup(String name) {  
            default -> throw new IllegalArgumentException("Unknown task monitor group: " + group);  
    }
        VarHandle[] handles = taskMonitorHandles(group);  
                QE_TOTAL_SCHEDULED_DURATION_MS,
            (long) handles[3].get(seg, 0L),  
            (long) handles[1].get(seg, 0L),  
            (long) SS_SINGLE_COLLECTOR_SCAN.get(seg, 0L),
    private static final VarHandle SS_ELAPSED_COMPUTE_MS = handle("search_stats", "elapsed_compute_ms");
                DG_PENDING_ACQUIRE_PERMITS,
    }
        taskMonitorGroup("query_execution"),
    private static final VarHandle CACHE_STATS_MEMORY_BYTES = cacheHandle("statistics_cache", "memory_bytes");
        "total_overflow_count",  
                CPU_GLOBAL_QUEUE_DEPTH,
            ValueLayout.JAVA_LONG.withName("instrumented_count"),
 */
    private static final VarHandle AB_FALLBACKS = handle("adaptive_budget", "fallbacks");
    private static final VarHandle CPU_GLOBAL_QUEUE_DEPTH = handle("cpu_runtime", "global_queue_depth");
     * Read the cache_stats group (10 fields, 2 sub-caches × 5 fields each).
/*  
                CR_INSTRUMENTED_COUNT,
 * and provides {@link VarHandle} accessors for each field via layout path navigation.  
            cacheGroup("column_index_cache"),  
        return new AdaptiveBudgetStats((long) AB_FALLBACKS.get(seg, 0L), (long) AB_REJECTIONS.get(seg, 0L));
        ).withName(name);  
    }
    private static final VarHandle CPU_TOTAL_OVERFLOW_COUNT = handle("cpu_runtime", "total_overflow_count");
            ValueLayout.JAVA_LONG.withName("delegation_calls"),
     * @param seg the memory segment containing the DfStatsBuffer  
            ValueLayout.JAVA_LONG.withName("total_busy_duration_ms"),
        CacheGroupStats metadata = new CacheGroupStats(
    private static final VarHandle QE_TOTAL_SCHEDULED_DURATION_MS = handle("query_execution", "total_scheduled_duration_ms");
            ValueLayout.JAVA_LONG.withName("total_local_queue_depth")
        CacheGroupStats offsetIndex = new CacheGroupStats(
    private static final VarHandle IO_BLOCKING_QUEUE_DEPTH = handle("io_runtime", "blocking_queue_depth");
        "on_batch_mask_time_ms",
    // ---- VarHandles for query_execution fields ----  
    private static final String[] SEARCH_STATS_FIELDS = {
            .withName(name);
            (long) handles[2].get(seg, 0L),
    }
    private static final VarHandle CACHE_OI_MEMORY_BYTES = cacheHandle("offset_index_cache", "memory_bytes");  
    private static final VarHandle SS_FILTER_RECORD_BATCH_TIME_MS = handle("search_stats", "filter_record_batch_time_ms");
                DG_MAX_PERMITS,
    private static final VarHandle DG_TOTAL_BATCHES_STARTED = handle("fragment_executor_gate", "total_batches_started");
                QE_TOTAL_IDLE_DURATION_MS,  
     * @param seg   the memory segment containing the DfStatsBuffer  
        return switch (group) {
    }
    // ---- VarHandles for adaptive_budget fields ----
    // ---- Private helpers ----
    private static final VarHandle CPU_WORKERS_COUNT = handle("cpu_runtime", "workers_count");
                PS_TOTAL_IDLE_DURATION_MS,  
            ValueLayout.JAVA_LONG.withName("object_store_read_time_ms")
    private static final VarHandle CPU_TOTAL_BUSY_DURATION_MS = handle("cpu_runtime", "total_busy_duration_ms");  
 * SPDX-License-Identifier: Apache-2.0
        ).withName(name);  
    private static StructLayout taskMonitorGroup(String name) {
     * @return a populated RuntimeMetrics instance
        return LAYOUT.varHandle(
                DG_TARGET_MAX_PERMITS,  
    // ---- VarHandles for cache_stats.statistics_cache fields ----  
            (long) SS_FILTER_RECORD_BATCH_TIME_MS.get(seg, 0L),
    private static final VarHandle PS_TOTAL_POLL_DURATION_MS = handle("plan_setup", "total_poll_duration_ms");  
            case "query_execution" -> new VarHandle[] {  
    }
    private static final String[] CACHE_GROUP_FIELDS = { "hit_count", "miss_count", "entry_count", "memory_bytes", "size_limit_bytes" };
    public static final StructLayout LAYOUT = MemoryLayout.structLayout(  
        "total_wait_duration_ms",
        "object_store_read_time_ms" };  
            ValueLayout.JAVA_LONG.withName("prefetch_wait_time_ms"),
    private static final VarHandle DG_PENDING_ACQUIRE_PERMITS = handle("fragment_executor_gate", "pending_acquire_permits");
    private static final VarHandle CACHE_META_ENTRY_COUNT = cacheHandle("metadata_cache", "entry_count");
    /**  
     * @param seg   the memory segment containing the DfStatsBuffer
            ValueLayout.JAVA_LONG.withName("pending_acquire_batches")  
import org.opensearch.be.datafusion.stats.CacheStats;  
    private static final VarHandle IO_TOTAL_BUSY_DURATION_MS = handle("io_runtime", "total_busy_duration_ms");
    private static final VarHandle CR_TOTAL_IDLE_DURATION_MS = handle("coordinator_reduce", "total_idle_duration_ms");
    private static final VarHandle SS_PREFETCH_WAIT_TIME_MS = handle("search_stats", "prefetch_wait_time_ms");
 * + 1 partition gate × 8 fields + 1 adaptive budget × 2 fields + 1 cache stats × 10 fields  
    private static final VarHandle CPU_SPAWNED_TASKS_COUNT = handle("cpu_runtime", "spawned_tasks_count");
                CR_TOTAL_IDLE_DURATION_MS,  
    private static VarHandle cacheHandle(String subGroup, String field) {  
            (long) CACHE_OI_HIT_COUNT.get(seg, 0L),
    private static final VarHandle CACHE_OI_SIZE_LIMIT_BYTES = cacheHandle("offset_index_cache", "size_limit_bytes");
    private static final VarHandle SS_RG_SKIPPED = handle("search_stats", "rg_skipped");  
    public static PartitionGateStats readPartitionGate(MemorySegment seg, String group) {
                IO_TOTAL_OVERFLOW_COUNT,
        "target_max_permits",
            (long) handles[1].get(seg, 0L),
        return switch (group) {
                SN_DROPPED_COUNT };
                CPU_SPAWNED_TASKS_COUNT,
            ValueLayout.JAVA_LONG.withName("pending_acquire_permits"),
                QE_TOTAL_POLL_DURATION_MS,
     * @param seg the memory segment containing the DfStatsBuffer
    private static final VarHandle SS_DELEGATION_CALLS = handle("search_stats", "delegation_calls");
     * @param seg   the memory segment containing the DfStatsBuffer
        runtimeGroup("cpu_runtime"),
     * @return a populated PartitionGateStats instance  
            (long) SS_PREFETCH_WAIT_COUNT.get(seg, 0L),  
        return readPartitionGate(seg, group, group);  
    /**  
     * @param field the field name (e.g. "workers_count")
     * @return a populated CacheStats instance with metadata + statistics sub-groups
        "rg_processed",  
        "num_alive_tasks",  
    }
            ValueLayout.JAVA_LONG.withName("parquet_processing_time_ms"),  
    private static final VarHandle CACHE_CI_MISS_COUNT = cacheHandle("column_index_cache", "miss_count");  
    private static final VarHandle CACHE_META_SIZE_LIMIT_BYTES = cacheHandle("metadata_cache", "size_limit_bytes");
            (long) SS_ON_BATCH_MASK_TIME_MS.get(seg, 0L),  
    private static final VarHandle CACHE_OI_HIT_COUNT = cacheHandle("offset_index_cache", "hit_count");  
     * @return a populated TaskMonitorStats instance  
                PS_INSTRUMENTED_COUNT,
    /** The struct layout mirroring Rust's {@code DfStatsBuffer}. */
                PS_TOTAL_SCHEDULED_DURATION_MS,
import java.lang.foreign.MemoryLayout;  
    private static final VarHandle CPU_TOTAL_POLLS_COUNT = handle("cpu_runtime", "total_polls_count");
        cacheStatsGroup("cache_stats"),  
    private static final VarHandle DG_POISON_PERMITS = handle("fragment_executor_gate", "poison_permits");
    private static final VarHandle DG_MAX_PERMITS = handle("fragment_executor_gate", "max_permits");
     */
    private static final VarHandle DG_PENDING_ACQUIRE_BATCHES = handle("fragment_executor_gate", "pending_acquire_batches");
            (long) handles[6].get(seg, 0L),  
                DG_TOTAL_WAIT_DURATION_MS,  
            (long) CACHE_META_HIT_COUNT.get(seg, 0L),
            (long) SS_BITMAP_TREE_SCAN.get(seg, 0L),  
    private static final String[] RUNTIME_FIELDS = {
        ).withName(name);
    private static VarHandle[] runtimeHandles(String group) {
            ValueLayout.JAVA_LONG.withName("global_queue_depth"),  
    private static final VarHandle CACHE_META_MEMORY_BYTES = cacheHandle("metadata_cache", "memory_bytes");  
                IO_NUM_ALIVE_TASKS,
            (long) CACHE_META_ENTRY_COUNT.get(seg, 0L),
            (long) CACHE_CI_SIZE_LIMIT_BYTES.get(seg, 0L)
    /**  
            case "plan_setup" -> new VarHandle[] {  
    private static final VarHandle SS_SINGLE_COLLECTOR_SCAN = handle("search_stats", "single_collector_scan");
     *
        "workers_count",  
    private static final VarHandle IO_TOTAL_OVERFLOW_COUNT = handle("io_runtime", "total_overflow_count");
    private static StructLayout searchStatsGroup(String name) {
    private static final VarHandle PS_DROPPED_COUNT = handle("plan_setup", "dropped_count");
            (long) CACHE_CI_MEMORY_BYTES.get(seg, 0L),
     */
    private static final VarHandle CACHE_CI_MEMORY_BYTES = cacheHandle("column_index_cache", "memory_bytes");
    }  
        "total_poll_duration_ms",
    private static final VarHandle SS_ON_BATCH_MASK_TIME_MS = handle("search_stats", "on_batch_mask_time_ms");  
            (long) handles[3].get(seg, 0L),
    private static final VarHandle IO_GLOBAL_QUEUE_DEPTH = handle("io_runtime", "global_queue_depth");  
     * Read a runtime metrics group (8 fields) from the segment.
        "total_polls_count",
    private static final String[] TASK_MONITOR_FIELDS = {
        "filter_record_batch_time_ms",
    private static final VarHandle CPU_NUM_ALIVE_TASKS = handle("cpu_runtime", "num_alive_tasks");
    private static StructLayout cacheGroup(String name) {
                CPU_TOTAL_OVERFLOW_COUNT,  
                DG_ACTIVE_PERMITS,
    private static final VarHandle SN_TOTAL_POLL_DURATION_MS = handle("stream_next", "total_poll_duration_ms");
                CPU_TOTAL_POLLS_COUNT,
     *
     * @param group one of the OperationType keys
    private static VarHandle[] partitionGateHandles(String group) {
        );
    private static final VarHandle CR_DROPPED_COUNT = handle("coordinator_reduce", "dropped_count");
        "parquet_processing_time_ms",
    private static final VarHandle SN_DROPPED_COUNT = handle("stream_next", "dropped_count");  
            (long) CACHE_META_MEMORY_BYTES.get(seg, 0L),
        "build_mask_time_ms",  
            (long) handles[8].get(seg, 0L)  
            (long) handles[4].get(seg, 0L),
    /**
                SN_INSTRUMENTED_COUNT,
        );  
    private static final VarHandle PS_TOTAL_SCHEDULED_DURATION_MS = handle("plan_setup", "total_scheduled_duration_ms");
        return MemoryLayout.structLayout(  
        ).withName(name);
            (long) handles[4].get(seg, 0L),
    // ---- VarHandles for cpu_runtime fields ----  
    }  
            ValueLayout.JAVA_LONG.withName("hit_count"),  
        "total_local_queue_depth" };
        );
            default -> throw new IllegalArgumentException("Unknown partition gate group: " + group);  
            (long) CACHE_OI_SIZE_LIMIT_BYTES.get(seg, 0L)  
     */
            ValueLayout.JAVA_LONG.withName("total_batches_started"),
     */
    private static final VarHandle SN_INSTRUMENTED_COUNT = handle("stream_next", "instrumented_count");
import java.lang.foreign.MemoryLayout.PathElement;
        "parquet_scan_until_data_time_ms",  
            (long) CACHE_STATS_ENTRY_COUNT.get(seg, 0L),
    }
        );  
            ValueLayout.JAVA_LONG.withName("parquet_scan_until_data_time_ms"),
    private static final VarHandle IO_NUM_ALIVE_TASKS = handle("io_runtime", "num_alive_tasks");
        "single_collector_scan",  
        "elapsed_compute_ms",
            ValueLayout.JAVA_LONG.withName("target_max_permits"),
            ValueLayout.JAVA_LONG.withName("build_mask_time_ms"),
     */
    private static final VarHandle DG_TARGET_MAX_PERMITS = handle("fragment_executor_gate", "target_max_permits");  
        return (long) handle(group, field).get(seg, 0L);  
     *
            case "fragment_executor_gate" -> new VarHandle[] {  
     * Read partition gate stats from the native buffer with a custom display name.
     * @param displayName the JSON key name to use when serializing
            (long) handles[5].get(seg, 0L),
                IO_TOTAL_LOCAL_QUEUE_DEPTH };
        taskMonitorGroup("stream_next"),
        taskMonitorGroup("plan_setup"),  
        };
 * compatible open source license.
public final class StatsLayout {  
        "spawned_tasks_count",
        "total_idle_duration_ms",
            displayName,
            ValueLayout.JAVA_LONG.withName("listing_table_scan"),
            ValueLayout.JAVA_LONG.withName("parquet_scan_total_time_ms"),
                IO_GLOBAL_QUEUE_DEPTH,  
    /**
    // ---- VarHandles for io_runtime fields ----
                DG_PENDING_ACQUIRE_BATCHES };
            ValueLayout.JAVA_LONG.withName("active_permits"),  
            (long) handles[2].get(seg, 0L),  
        partitionGateGroup("fragment_executor_gate"),
     *  
            ValueLayout.JAVA_LONG.withName("elapsed_compute_ms"),
        "active_permits",
import java.lang.foreign.ValueLayout;
            ValueLayout.JAVA_LONG.withName("poison_permits"),  
                IO_BLOCKING_QUEUE_DEPTH,
        return switch (group) {  
            PathElement.groupElement(field)
        VarHandle[] handles = partitionGateHandles(group);  
                IO_TOTAL_POLLS_COUNT,  
     * @param seg the memory segment containing the DfStatsBuffer  
/**
     * @return the long value at the specified path  
                IO_TOTAL_BUSY_DURATION_MS,
    private static final VarHandle CPU_TOTAL_LOCAL_QUEUE_DEPTH = handle("cpu_runtime", "total_local_queue_depth");  
        return new CacheStats(metadata, statistics, columnIndex, offsetIndex);
            ValueLayout.JAVA_LONG.withName("workers_count"),
            ValueLayout.JAVA_LONG.withName("prefetch_wait_count"),  
    }  
    private static final VarHandle CACHE_STATS_MISS_COUNT = cacheHandle("statistics_cache", "miss_count");
    private static final VarHandle CPU_BLOCKING_QUEUE_DEPTH = handle("cpu_runtime", "blocking_queue_depth");  
        );
        "instrumented_count",
        "global_queue_depth",
     * @return a populated PartitionGateStats instance  
    private static final VarHandle CACHE_STATS_ENTRY_COUNT = cacheHandle("statistics_cache", "entry_count");  
    // ---- VarHandles for cache_stats.column_index_cache fields ----
            ValueLayout.JAVA_LONG.withName("max_permits"),
        "poison_permits",
        return MemoryLayout.structLayout(
            ValueLayout.JAVA_LONG.withName("single_collector_scan"),
    private static final VarHandle SS_PREFETCH_WAIT_COUNT = handle("search_stats", "prefetch_wait_count");  
     * @param seg   the memory segment containing the DfStatsBuffer  
    public static SearchStats readSearchStats(MemorySegment seg) {
    private static final VarHandle SS_PARQUET_SCAN_UNTIL_DATA_TIME_MS = handle("search_stats", "parquet_scan_until_data_time_ms");
        "parquet_scan_total_time_ms",
            (long) handles[5].get(seg, 0L),  
    private static StructLayout runtimeGroup(String name) {  
            (long) CACHE_STATS_SIZE_LIMIT_BYTES.get(seg, 0L)
        "blocking_queue_depth",
            PathElement.groupElement(subGroup),  
    private static final VarHandle QE_INSTRUMENTED_COUNT = handle("query_execution", "instrumented_count");
    }  
        "dropped_count" };  
        adaptiveBudgetGroup("adaptive_budget"),
            PathElement.groupElement("cache_stats"),
    private static final VarHandle QE_DROPPED_COUNT = handle("query_execution", "dropped_count");
    private static final VarHandle CR_TOTAL_POLL_DURATION_MS = handle("coordinator_reduce", "total_poll_duration_ms");  
            ValueLayout.JAVA_LONG.withName("rg_skipped"),  
            case "stream_next" -> new VarHandle[] {  
     *  
    private static final VarHandle CACHE_OI_MISS_COUNT = cacheHandle("offset_index_cache", "miss_count");
     * @param group       "fragment_executor_gate" (layout key)
    // ---- VarHandles for cache_stats.offset_index_cache fields ----
            (long) SS_ELAPSED_COMPUTE_MS.get(seg, 0L),
    private static StructLayout adaptiveBudgetGroup(String name) {  
     * Read the search_stats group (17 fields) from the segment.  
    public static PartitionGateStats readPartitionGate(MemorySegment seg, String group, String displayName) {
    private static VarHandle handle(String group, String field) {
     *
    private static final VarHandle AB_REJECTIONS = handle("adaptive_budget", "rejections");  
    private static final VarHandle IO_TOTAL_LOCAL_QUEUE_DEPTH = handle("io_runtime", "total_local_queue_depth");
        return MemoryLayout.structLayout(  
    private static final String[] ADAPTIVE_BUDGET_FIELDS = { "fallbacks", "rejections" };  
        );
        return MemoryLayout.structLayout(  
            ValueLayout.JAVA_LONG.withName("total_scheduled_duration_ms"),
        return LAYOUT.varHandle(PathElement.groupElement(group), PathElement.groupElement(field));  
    private static StructLayout cacheStatsGroup(String name) {
            (long) handles[4].get(seg, 0L)  
    private static final VarHandle PS_TOTAL_IDLE_DURATION_MS = handle("plan_setup", "total_idle_duration_ms");
     */  
        "pending_acquire_permits",  
     * Read a single field from the segment.
            default -> throw new IllegalArgumentException("Unknown runtime group: " + group);  
            (long) handles[7].get(seg, 0L)
    }  
            (long) handles[6].get(seg, 0L),
     */
            (long) CACHE_META_MISS_COUNT.get(seg, 0L),  
            throw new AssertionError("StatsLayout size mismatch: expected " + (85 * Long.BYTES) + " but got " + LAYOUT.byteSize());  
            (long) handles[0].get(seg, 0L),  
        CacheGroupStats columnIndex = new CacheGroupStats(  
            (long) SS_PARQUET_SCAN_TOTAL_TIME_MS.get(seg, 0L),
            ValueLayout.JAVA_LONG.withName("on_batch_mask_time_ms"),  
                DG_POISON_PERMITS,
                SN_TOTAL_IDLE_DURATION_MS,  
    private static final String[] PARTITION_GATE_FIELDS = {
    private static final VarHandle SN_TOTAL_IDLE_DURATION_MS = handle("stream_next", "total_idle_duration_ms");
     * @param group "io_runtime" or "cpu_runtime"
    private static final VarHandle CACHE_CI_ENTRY_COUNT = cacheHandle("column_index_cache", "entry_count");
        return MemoryLayout.structLayout(
    private static final VarHandle SS_PARQUET_BYTES_SCANNED = handle("search_stats", "parquet_bytes_scanned");
import org.opensearch.be.datafusion.stats.SearchStats;  
            (long) SS_RG_PROCESSED.get(seg, 0L),
    public static long readField(MemorySegment seg, String group, String field) {
}  
            case "io_runtime" -> new VarHandle[] {
    private static final VarHandle CR_INSTRUMENTED_COUNT = handle("coordinator_reduce", "instrumented_count");  
        );
            ValueLayout.JAVA_LONG.withName("spawned_tasks_count"),  
    private StatsLayout() {}
                CR_TOTAL_POLL_DURATION_MS,
    private static final VarHandle SS_PARQUET_SCAN_TOTAL_TIME_MS = handle("search_stats", "parquet_scan_total_time_ms");
        CacheGroupStats statistics = new CacheGroupStats(
    private static final VarHandle CACHE_OI_ENTRY_COUNT = cacheHandle("offset_index_cache", "entry_count");
    private static VarHandle[] taskMonitorHandles(String group) {
    }
        VarHandle[] handles = runtimeHandles(group);
            case "cpu_runtime" -> new VarHandle[] {
import java.lang.foreign.StructLayout;  
                CPU_BLOCKING_QUEUE_DEPTH,
 * The OpenSearch Contributors require contributions made to  
    public static AdaptiveBudgetStats readAdaptiveBudgetStats(MemorySegment seg) {  
                IO_WORKERS_COUNT,
import org.opensearch.be.datafusion.stats.CacheGroupStats;
    private static final VarHandle CACHE_META_HIT_COUNT = cacheHandle("metadata_cache", "hit_count");  
 * <p>The layout contains 10 named groups (2 runtime × 9 fields + 4 task monitor × 5 fields
            ValueLayout.JAVA_LONG.withName("total_polls_count"),  
 * Defines the {@code MemoryLayout.structLayout} mirroring the Rust {@code DfStatsBuffer}
        "total_busy_duration_ms",
                IO_SPAWNED_TASKS_COUNT,  
        return new TaskMonitorStats(
    private static final VarHandle CACHE_STATS_SIZE_LIMIT_BYTES = cacheHandle("statistics_cache", "size_limit_bytes");
        "prefetch_wait_time_ms",  
            ValueLayout.JAVA_LONG.withName("bitmap_tree_scan"),  
        return new PartitionGateStats(
        "rg_skipped",
            (long) SS_PREFETCH_WAIT_TIME_MS.get(seg, 0L),
    /**
 * + 1 search stats × 17 fields = 85 longs = 680 bytes). The cache stats group holds three sub-caches × 5 fields each: metadata, statistics, and scoped page-index..
        "delegation_calls",
            ValueLayout.JAVA_LONG.withName("dropped_count")
    private static final VarHandle QE_TOTAL_POLL_DURATION_MS = handle("query_execution", "total_poll_duration_ms");
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
            (long) SS_PARQUET_SCAN_UNTIL_DATA_TIME_MS.get(seg, 0L),
        };
            ValueLayout.JAVA_LONG.withName("memory_bytes"),  
 *
    private static final VarHandle CACHE_META_MISS_COUNT = cacheHandle("metadata_cache", "miss_count");
        ).withName(name);
import org.opensearch.be.datafusion.stats.PartitionGateStats;
                QE_DROPPED_COUNT };
            (long) handles[0].get(seg, 0L),
        runtimeGroup("io_runtime"),
     *
                PS_DROPPED_COUNT };
    }  
        }
            (long) CACHE_CI_MISS_COUNT.get(seg, 0L),
    private static final VarHandle CACHE_CI_SIZE_LIMIT_BYTES = cacheHandle("column_index_cache", "size_limit_bytes");  
    // ---- VarHandles for stream_next fields ----
            (long) SS_PARQUET_BYTES_SCANNED.get(seg, 0L),
    private static final VarHandle SS_OBJECT_STORE_READ_TIME_MS = handle("search_stats", "object_store_read_time_ms");
    /**  
            (long) handles[2].get(seg, 0L),
            (long) handles[7].get(seg, 0L),
        "bitmap_tree_scan",
            (long) CACHE_OI_MISS_COUNT.get(seg, 0L),  
     */
            (long) CACHE_CI_ENTRY_COUNT.get(seg, 0L),  
    private static final VarHandle SS_BUILD_MASK_TIME_MS = handle("search_stats", "build_mask_time_ms");
     * Read a task monitor group (5 fields) from the segment.
            ValueLayout.JAVA_LONG.withName("total_idle_duration_ms"),  
            ValueLayout.JAVA_LONG.withName("parquet_bytes_scanned"),
            (long) SS_BUILD_MASK_TIME_MS.get(seg, 0L),
                CPU_WORKERS_COUNT,  
     * @param group "fragment_executor_gate"
            (long) SS_LISTING_TABLE_SCAN.get(seg, 0L),
        if (LAYOUT.byteSize() != 85 * Long.BYTES) {
    // ---- VarHandles for fragment_executor_gate fields ----  
        return new SearchStats(  
    private static final VarHandle CACHE_CI_HIT_COUNT = cacheHandle("column_index_cache", "hit_count");
    // ---- VarHandles for search_stats fields ----  
     * @return a populated SearchStats instance  
            ValueLayout.JAVA_LONG.withName("blocking_queue_depth"),
    public static TaskMonitorStats readTaskMonitor(MemorySegment seg, String group) {
            cacheGroup("metadata_cache"),
    private static final VarHandle IO_SPAWNED_TASKS_COUNT = handle("io_runtime", "spawned_tasks_count");  
            case "coordinator_reduce" -> new VarHandle[] {  
    // ---- VarHandles for coordinator_reduce fields ----
            (long) CACHE_STATS_MISS_COUNT.get(seg, 0L),
    private static final VarHandle SN_TOTAL_SCHEDULED_DURATION_MS = handle("stream_next", "total_scheduled_duration_ms");  
    private static final VarHandle PS_INSTRUMENTED_COUNT = handle("plan_setup", "instrumented_count");  
                CR_TOTAL_SCHEDULED_DURATION_MS,
                CR_DROPPED_COUNT };
                CPU_TOTAL_BUSY_DURATION_MS,
            cacheGroup("statistics_cache"),
    static {
            (long) handles[0].get(seg, 0L),
    public static RuntimeMetrics readRuntimeMetrics(MemorySegment seg, String group) {
        ).withName(name);
 * this file be licensed under the Apache-2.0 license or a
                SN_TOTAL_SCHEDULED_DURATION_MS,
            (long) SS_PARQUET_PROCESSING_TIME_MS.get(seg, 0L),  
            cacheGroup("offset_index_cache")
    }  
                CPU_TOTAL_LOCAL_QUEUE_DEPTH };
            ValueLayout.JAVA_LONG.withName("filter_record_batch_time_ms"),
        "total_scheduled_duration_ms",  
    }
            (long) handles[3].get(seg, 0L),
            ValueLayout.JAVA_LONG.withName("total_wait_duration_ms"),
 */  
