            RuntimeMetricsRepr::zeroed()
use tokio::runtime::Handle;
    let oi = crate::cache::page_index::offset_index_cache_stats();
        }
/// Snapshot a `TaskMonitor` and return a populated `TaskMonitorRepr`.
                buf.cpu_runtime.workers_count
/// | total_polls_count           | `Handle::metrics().worker_poll_count(i)` Σ  |
    let metadata_memory = mgr
#[repr(C)]
    let statistics_memory = mgr
        assert_eq!(size_of::<DfStatsBuffer>(), 680);
        total_busy_duration_ms: (total_busy_ns / 1_000_000) as i64,
        }
mod tests {
pub struct AdaptiveBudgetRepr {
pub struct RuntimeMetricsRepr {
    pub hit_count: i64,
}
const _: () = assert!(size_of::<TaskMonitorRepr>() == 5 * 8);
        .unwrap_or(0) as i64;
            spawned_tasks_count: 0,
            blocking_queue_depth: 0,
    #[tokio::test]
/// | blocking_queue_depth        | `Handle::metrics().blocking_queue_depth()`  |
        assert_eq!(repr.statistics_cache.size_limit_bytes, 10 * 1024 * 1024);
/// Snapshot the [`CustomCacheManager`] caches and return a populated
//!
    let m = handle.metrics();
pub struct PartitionGateRepr {
            PolicyType::Lru,
#[repr(C)]
        let monitor = RuntimeMonitor::new(&rt.handle());
/// |------------------------------|---------------------------------|
    #[test]
    }
            size_limit_bytes: ci.limit_bytes as i64,
    #[tokio::test]
    pub coordinator_reduce: TaskMonitorRepr,
    pub total_local_queue_depth: i64,
#[repr(C)]
impl Default for CacheStatsRepr {
/*
        let monitor = RuntimeMonitor::new(&rt.handle());
        };
        pending_acquire_batches: gate.pending_acquire_batches() as i64,
            assert_eq!(g.miss_count, 0);
            .unwrap();
//! | `plan_setup`         | `TaskMonitorRepr`    | 5 × i64 |
            memory_bytes: 0,
            .build()
            50 * 1024 * 1024,
        let io_runtime = pack_runtime_metrics(&mgr.io_monitor, mgr.io_runtime.handle());
/// | total_idle_duration_ms       | cumulative idle duration (ms)   |
        global_queue_depth: m.global_queue_depth() as i64,
/// [`CacheStatsRepr`]. Disabled caches return all-zeros via the manager's
        coordinator_reduce_monitor, plan_setup_monitor, query_execution_monitor,
            hit_count: oi.hits as i64,
            buf.io_runtime.workers_count
    pub query_execution: TaskMonitorRepr,
    pub total_poll_duration_ms: i64,
        });
        assert!(
        stream_next_monitor,
        }
    pub column_index_cache: CacheGroupRepr,
//! | Group                | Type                 | Fields |
    let cumulative = monitor.cumulative();
    }
#[cfg(test)]
            assert_eq!(g.memory_bytes, 0);
            } else {
        pending_acquire_permits: gate.pending_acquire_permits() as i64,
/// |--------------------------|-------------------------------------|
 */
    pub entry_count: i64,
    pub plan_setup: TaskMonitorRepr,
            }
        column_index_cache: CacheGroupRepr {
pub struct TaskMonitorRepr {
use crate::executor::ConcurrencyGate;
/// | entry_count      | `mgr.{metadata,statistics}_cache_entry_count()`     |
                buf.cpu_runtime.workers_count > 0,
            memory_bytes: statistics_memory,
//! | `query_execution`    | `TaskMonitorRepr`    | 5 × i64 |
    pub single_collector_scan: i64,
    pub offset_index_cache: CacheGroupRepr,
/// `unwrap_or(0)` accessor fallbacks.
        assert_eq!(repr.statistics_cache.entry_count, 0);
            size_limit_bytes: mgr.statistics_cache_size_limit() as i64,
        for g in [&repr.metadata_cache, &repr.statistics_cache] {
    pub parquet_processing_time_ms: i64,
        total_polls_count: total_polls as i64,
#[repr(C)]
    #[test]
}
                pack_runtime_metrics(cpu_mon, &cpu_handle)
    pub total_idle_duration_ms: i64,
    pub parquet_scan_until_data_time_ms: i64,
        rejections: stats.rejections.load(Ordering::Relaxed) as i64,
            );
            total_polls_count: 0,
/// | pending_acquire_permits  | `gate.pending_acquire_permits()`    |
            offset_index_cache: CacheGroupRepr::default(),
        let monitor = query_execution_monitor();
        total_polls += m.worker_poll_count(i);
//! Packs Tokio runtime metrics and per-operation task monitor metrics
/// | global_queue_depth          | `Handle::metrics().global_queue_depth()`    |
    pub poison_permits: i64,
}
    pub memory_bytes: i64,
use crate::custom_cache_manager::CustomCacheManager;
    pub size_limit_bytes: i64,
            tm.total_poll_duration_ms >= 0,
}
    pub const BUFFER_BYTE_SIZE: usize = size_of::<DfStatsBuffer>();
//! | `cpu_runtime`        | `RuntimeMetricsRepr` | 9 × i64 (zeroed if N/A) |
            tokio::task::yield_now().await;
    pub total_scheduled_duration_ms: i64,
    fn test_pack_cache_stats_empty_manager_zeroed() {
pub mod layout {
            memory_bytes: metadata_memory,
            hit_count: mgr.statistics_cache_hit_count() as i64,
        assert_eq!(repr.metadata_cache.entry_count, 0);
/// | num_alive_tasks             | `Handle::metrics().num_alive_tasks()`       |
            miss_count: 0,
        // We can't call df_stats directly without a runtime manager,
    // Sum per-worker metrics into aggregates
    }
    let stats = crate::query_budget::adaptive_budget();
const _: () = assert!(size_of::<SearchStatsRepr>() == 17 * 8);
            .worker_threads(2)
        use std::sync::Arc;
    pub num_alive_tasks: i64,
/// | pending_acquire_batches  | `gate.pending_acquire_batches()`    |
        let tm = pack_task_monitor(monitor);
        total_busy_ns += m.worker_total_busy_duration(i).as_nanos() as u64;
}
            memory_bytes: oi.used_bytes as i64,
    fn default() -> Self {
    pub fragment_executor_gate: PartitionGateRepr,
    let mut total_overflow: u64 = 0;
    pub max_permits: i64,
//! | `stream_next`        | `TaskMonitorRepr`    | 5 × i64 |
    pub rg_processed: i64,
        let result = pack_runtime_metrics(&monitor, rt.handle());
            .enable_all()
    fn default() -> Self {
            .worker_threads(3)
        mgr.cpu_executor.shutdown();
    pub search_stats: SearchStatsRepr,
        },
pub fn pack_task_monitor(monitor: &TaskMonitor) -> TaskMonitorRepr {
    pub prefetch_wait_count: i64,
    }
        }
    pub adaptive_budget: AdaptiveBudgetRepr,
/// Snapshot a `ConcurrencyGate` and return a populated `PartitionGateRepr`.
/// | workers_count               | `Handle::metrics().num_workers()`           |
        .get_memory_consumed_by_type(crate::cache::CACHE_TYPE_METADATA)
    pub on_batch_mask_time_ms: i64,
        assert_eq!(repr.statistics_cache.hit_count, 0);
}
        },
            0.8,
    pub spawned_tasks_count: i64,
        let cpu_runtime = if let Some(ref cpu_mon) = mgr.cpu_monitor {
        instrumented_count: cumulative.instrumented_count as i64,
        let mut mgr = CustomCacheManager::new();
        }
            miss_count: oi.misses as i64,
        assert!(
    fn test_pack_runtime_metrics_returns_struct() {
        mgr.set_file_metadata_cache(metadata_cache);
        let buf = DfStatsBuffer {
    pub pending_acquire_permits: i64,
        total_wait_duration_ms: gate.total_wait_ms() as i64,
            assert_eq!(g.hit_count, 0);
    #[test]
            cpu_runtime,
/// | total_poll_duration_ms       | cumulative poll duration (ms)   |
//! | `search_stats`       | `SearchStatsRepr`    | 17 × i64 |
            search_stats: crate::search_stats::snapshot(),
            size_limit_bytes: mgr.metadata_cache_size_limit() as i64,
    let ci = crate::cache::page_index::column_index_cache_stats();
    fn test_pack_cache_stats_reflects_underlying_counters() {
        assert_eq!(layout::BUFFER_BYTE_SIZE, 680);
/// | size_limit_bytes | `mgr.{metadata,statistics}_cache_size_limit()`      |
        assert_eq!(result.total_scheduled_duration_ms, 0);
        workers_count: num_workers as i64,
    pub cache_stats: CacheStatsRepr,
    pub elapsed_compute_ms: i64,
        // Verify that the buffer size assertion holds
    #[test]
}
    pub total_busy_duration_ms: i64,
        fallbacks: stats.fallbacks.load(Ordering::Relaxed) as i64,
    pub rg_skipped: i64,
pub struct SearchStatsRepr {
            miss_count: ci.misses as i64,
/// | spawned_tasks_count         | `Handle::metrics().spawned_tasks_count()`   |
    fn test_pack_runtime_metrics_populates_workers_count() {
            assert!(
//! transfer across the FFM boundary.
    }
            .unwrap();
const _: () = assert!(size_of::<DfStatsBuffer>() == 85 * 8);
    pub total_overflow_count: i64,
        let rt = tokio::runtime::Builder::new_multi_thread()
#[repr(C)]
    pub delegation_calls: i64,
            let p = Path::from(format!("/test/missing/{i}.parquet"));
            query_execution: pack_task_monitor(query_execution_monitor()),
        total_local_queue_depth: total_local_queue as i64,
        active_permits: gate.active_permits() as i64,
//! | `fragment_executor_gate` | `PartitionGateRepr`  | 8 × i64 |
        let stats_cache = Arc::new(CustomStatisticsCache::new(
        let repr = pack_cache_stats(&mgr);
    pub workers_count: i64,
        for i in 0..3 {
        assert_eq!(result.total_poll_duration_ms, 0);
            assert!(stats_cache.get(&p).is_none());
/// | total_local_queue_depth     | `Handle::metrics().worker_local_queue_depth(i)` Σ |
        mgr.set_statistics_cache(stats_cache);
        // but we verify the constant is correct.
        )));
            io_runtime,
        assert_eq!(result.instrumented_count, 0);
            buf.io_runtime.workers_count > 0,
    let mut total_busy_ns: u64 = 0;
            42
/// | Field                        | Source                          |
    pub build_mask_time_ms: i64,
        };
            total_overflow_count: 0,
/// | hit_count        | `mgr.{metadata,statistics}_cache_hit_count()`       |
            assert!(metadata_cache.get(&p).is_none());
            stream_next: pack_task_monitor(stream_next_monitor()),
    pub pending_acquire_batches: i64,
            10 * 1024 * 1024,
pub struct CacheGroupRepr {
    pub total_polls_count: i64,
//! | `io_runtime`         | `RuntimeMetricsRepr` | 9 × i64 |
//! | `coordinator_reduce` | `TaskMonitorRepr`    | 5 × i64 |
        assert!(result.global_queue_depth >= 0);
            size_limit_bytes: 0,
    }
        },
            adaptive_budget: pack_adaptive_budget(),
        .get_memory_consumed_by_type(crate::cache::CACHE_TYPE_STATS)
//! Stats packing helpers for the FFM `df_stats()` function.
//! into a `#[repr(C)]` `DfStatsBuffer` struct (680 bytes) for efficient
}
    async fn test_full_stats_packing() {
const _: () = assert!(size_of::<CacheGroupRepr>() == 5 * 8);
    use super::*;
            hit_count: ci.hits as i64,
        let metadata_cache = Arc::new(MutexFileMetadataCache::new(DefaultFilesMetadataCache::new(
    pub active_permits: i64,
    pub prefetch_wait_time_ms: i64,
        assert!(layout::BUFFER_BYTE_SIZE > 0);
        },
impl Default for CacheGroupRepr {
    pub instrumented_count: i64,
}
    use super::*;
    let num_workers = m.num_workers();
            miss_count: mgr.statistics_cache_miss_count() as i64,
    }
            size_limit_bytes: oi.limit_bytes as i64,
        use crate::eviction_policy::PolicyType;
/// | total_batches_started    | `gate.total_queries_admitted()`     |
/// | Field                       | Source                                     |
pub fn pack_cache_stats(mgr: &CustomCacheManager) -> CacheStatsRepr {
            entry_count: mgr.metadata_cache_entry_count() as i64,
/// ## Fields
    fn test_df_stats_buffer_too_small() {
    pub stream_next: TaskMonitorRepr,
    pub target_max_permits: i64,
            .build()
            statistics_cache: CacheGroupRepr::default(),
            hit_count: mgr.metadata_cache_hit_count() as i64,
    RuntimeMetricsRepr {
        let result = pack_task_monitor(&monitor);
    for i in 0..num_workers {
/// |-----------------------------|---------------------------------------------|
    pub listing_table_scan: i64,
/// | total_wait_duration_ms   | `gate.total_wait_ms()`              |
        );
    pub rejections: i64,
//! ## Struct layout
    CacheStatsRepr {
/// | memory_bytes     | `mgr.get_memory_consumed_by_type({METADATA,STATS})` |
    }
        target_max_permits: gate.target_max_permits() as i64,
            column_index_cache: CacheGroupRepr::default(),
        total_overflow_count: total_overflow as i64,
        use object_store::path::Path;
            entry_count: oi.entries as i64,
            global_queue_depth: 0,
    }
/// Snapshot the global `AdaptiveBudgetStats` counters and return a populated `AdaptiveBudgetRepr`.
        );
        let result = pack_runtime_metrics(&monitor, rt.handle());
/// Snapshot a `RuntimeMonitor` and return a populated `RuntimeMetricsRepr`.
/// | Field            | Source                                              |
    pub dropped_count: i64,
/// | total_scheduled_duration_ms  | cumulative scheduled dur. (ms)  |
        ));
    }
        if mgr.cpu_monitor.is_some() {
        assert_eq!(result.workers_count, 2);
        assert!(result.total_polls_count >= 0);
        use crate::custom_cache_manager::CustomCacheManager;
const _: () = assert!(size_of::<RuntimeMetricsRepr>() == 9 * 8);
            miss_count: mgr.metadata_cache_miss_count() as i64,
            metadata_cache: CacheGroupRepr::default(),
    }
        let result = fut.await;
            hit_count: 0,
    }
        // Drive 3 misses on each cache and one extra miss on metadata.
    let mut total_local_queue: u64 = 0;
    use crate::task_monitors::{
const _: () = assert!(size_of::<AdaptiveBudgetRepr>() == 2 * 8);
        );
            entry_count: ci.entries as i64,
    }
            "total_poll_duration should be >= 0, got {}",
        use crate::custom_cache_manager::CustomCacheManager;
///
            entry_count: mgr.statistics_cache_entry_count() as i64,
        num_alive_tasks: m.num_alive_tasks() as i64,
            workers_count: 0,
    TaskMonitorRepr {
    #[test]
        total_batches_started: gate.total_queries_admitted() as i64,
        assert_eq!(result, 42);
        .unwrap_or(0) as i64;
        total_scheduled_duration_ms: cumulative.total_scheduled_duration.as_millis() as i64,
    }
            .get(&Path::from("/test/missing/extra.parquet"))
const _: () = assert!(size_of::<CacheStatsRepr>() == 20 * 8);
            cache_stats: CacheStatsRepr::default(),
    const _: () = assert!(BUFFER_BYTE_SIZE == 680);
            assert_eq!(g.entry_count, 0);
            tm.total_poll_duration_ms
}
        poison_permits: gate.poison_permits_held() as i64,
    let mut total_polls: u64 = 0;
        total_local_queue += m.worker_local_queue_depth(i) as u64;
            fragment_executor_gate: pack_partition_gate(mgr.cpu_executor.concurrency_gate()),
            plan_setup: pack_task_monitor(plan_setup_monitor()),
    #[test]
            "fragment_executor_gate max_permits should be > 0, got {}",
///
///
        Self {
        dropped_count: cumulative.dropped_count as i64,
/// | target_max_permits       | `gate.target_max_permits()`         |
    PartitionGateRepr {
/// | miss_count       | `mgr.{metadata,statistics}_cache_miss_count()`      |
        let repr = pack_cache_stats(&mgr);
        use datafusion::execution::cache::CacheAccessor;
//! | `cache_stats`        | `CacheStatsRepr`     | 20 × i64 (4 × 5: metadata, statistics, column_index, offset_index) |
    }
        let mgr = crate::runtime_manager::RuntimeManager::new(1, 1.5, 1.5);
    pub total_batches_started: i64,
pub struct DfStatsBuffer {
        Self {
}
    pub fn zeroed() -> Self {
            coordinator_reduce: pack_task_monitor(coordinator_reduce_monitor()),
/// | max_permits              | `gate.max_permits()`                |
        metadata_cache: CacheGroupRepr {
/// | total_busy_duration_ms      | `Handle::metrics().worker_total_busy_duration(i)` Σ |
        assert_eq!(result.workers_count, 3);
        max_permits: gate.max_permits() as i64,
            buf.fragment_executor_gate.max_permits
}
    pub object_store_read_time_ms: i64,
/// | poison_permits           | `gate.poison_permits_held()`        |
/// |------------------|-----------------------------------------------------|
        assert_eq!(layout::BUFFER_BYTE_SIZE, 680);
//! | `adaptive_budget`       | `AdaptiveBudgetRepr`    | 2 × i64 |
}
    AdaptiveBudgetRepr {
/// | active_permits           | `gate.active_permits()`             |
impl RuntimeMetricsRepr {
        statistics_cache: CacheGroupRepr {
 * SPDX-License-Identifier: Apache-2.0
    };
        use crate::statistics_cache::CustomStatisticsCache;
pub fn pack_partition_gate(gate: &ConcurrencyGate) -> PartitionGateRepr {
const _: () = assert!(size_of::<PartitionGateRepr>() == 8 * 8);
        let monitor = TaskMonitor::new();
        assert_eq!(result.total_idle_duration_ms, 0);
    pub fallbacks: i64,
#[repr(C)]
        assert!(
#[repr(C)]
        total_poll_duration_ms: cumulative.total_poll_duration.as_millis() as i64,
use tokio_metrics::{RuntimeMonitor, TaskMonitor};
        use datafusion::execution::cache::DefaultFilesMetadataCache;
///
pub fn pack_runtime_metrics(_monitor: &RuntimeMonitor, handle: &Handle) -> RuntimeMetricsRepr {
    pub bitmap_tree_scan: i64,
    pub cpu_runtime: RuntimeMetricsRepr,
            num_alive_tasks: 0,
        assert_eq!(repr.statistics_cache.miss_count, 3);
        blocking_queue_depth: m.blocking_queue_depth() as i64,
    pub global_queue_depth: i64,
    pub parquet_scan_total_time_ms: i64,
    fn test_pack_task_monitor_writes_duration_fields() {
        assert_eq!(result.dropped_count, 0);
}
                "CPU runtime workers_count should be > 0, got {}",
        assert_eq!(repr.metadata_cache.size_limit_bytes, 50 * 1024 * 1024);
            total_busy_duration_ms: 0,
    pub metadata_cache: CacheGroupRepr,
///
    pub total_wait_duration_ms: i64,
    }
                RuntimeMetricsRepr::zeroed()
    pub parquet_bytes_scanned: i64,
        use crate::cache::MutexFileMetadataCache;
            buf.fragment_executor_gate.max_permits > 0,
        } else {
}
        let rt = tokio::runtime::Builder::new_multi_thread()
        assert_eq!(repr.metadata_cache.hit_count, 0);
    pub blocking_queue_depth: i64,
            entry_count: 0,
//!
    use std::sync::atomic::Ordering;
            total_local_queue_depth: 0,
#[repr(C)]
            "IO runtime workers_count should be > 0, got {}",
    async fn test_pack_task_monitor_after_instrumented_future() {
        assert!(result.total_busy_duration_ms >= 0);
    pub statistics_cache: CacheGroupRepr,
            memory_bytes: ci.used_bytes as i64,
        offset_index_cache: CacheGroupRepr {
    pub miss_count: i64,
    pub filter_record_batch_time_ms: i64,
        total_overflow += m.worker_overflow_count(i);
        Self {
    pub io_runtime: RuntimeMetricsRepr,
        let fut = monitor.instrument(async {
/// | total_overflow_count        | `Handle::metrics().worker_overflow_count(i)` Σ |
            .enable_all()
//!
}
        spawned_tasks_count: m.spawned_tasks_count() as i64,
pub struct CacheStatsRepr {
        let mgr = CustomCacheManager::new();
}
        // A buffer smaller than 680 bytes should be rejected by df_stats.
        assert!(metadata_cache
            .is_none());
//! |----------------------|----------------------|--------|
pub fn pack_adaptive_budget() -> AdaptiveBudgetRepr {
}
            if let Some(cpu_handle) = mgr.cpu_executor.handle() {
            assert_eq!(g.size_limit_bytes, 0);
    }
        }
/// | Field                    | Source                              |
        total_idle_duration_ms: cumulative.total_idle_duration.as_millis() as i64,
        std::mem::forget(mgr);
        assert_eq!(repr.metadata_cache.miss_count, 4);
