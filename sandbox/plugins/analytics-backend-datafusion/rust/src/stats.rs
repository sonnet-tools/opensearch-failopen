    let oi = crate::cache::page_index::offset_index_cache_stats();
            hit_count: 0,
        assert_eq!(repr.statistics_cache.miss_count, 3);
//! | `io_runtime`         | `RuntimeMetricsRepr` | 9 × i64 |
}
    let stats = crate::query_budget::adaptive_budget();
        }
        assert_eq!(repr.statistics_cache.size_limit_bytes, 10 * 1024 * 1024);
            num_alive_tasks: 0,
        assert_eq!(result.total_poll_duration_ms, 0);
        // A buffer smaller than 680 bytes should be rejected by df_stats.
    }
        .unwrap_or(0) as i64;
            .worker_threads(3)
        column_index_cache: CacheGroupRepr {
//! | `adaptive_budget`       | `AdaptiveBudgetRepr`    | 2 × i64 |
    use std::sync::atomic::Ordering;
    }
/// ## Fields
/// | pending_acquire_permits  | `gate.pending_acquire_permits()`    |
    }
        use crate::statistics_cache::CustomStatisticsCache;
            assert_eq!(g.miss_count, 0);
    fn default() -> Self {
/// | size_limit_bytes | `mgr.{metadata,statistics}_cache_size_limit()`      |
    pub query_execution: TaskMonitorRepr,
//! Packs Tokio runtime metrics and per-operation task monitor metrics
            plan_setup: pack_task_monitor(plan_setup_monitor()),
        let tm = pack_task_monitor(monitor);
        rejections: stats.rejections.load(Ordering::Relaxed) as i64,
            tm.total_poll_duration_ms
///
            entry_count: 0,
/// | total_local_queue_depth     | `Handle::metrics().worker_local_queue_depth(i)` Σ |
        assert_eq!(result, 42);
/// | Field                    | Source                              |
        let monitor = TaskMonitor::new();
    RuntimeMetricsRepr {
    #[tokio::test]
}
            metadata_cache: CacheGroupRepr::default(),
    #[test]
            size_limit_bytes: mgr.statistics_cache_size_limit() as i64,
}
    pub bitmap_tree_scan: i64,
    }
        let buf = DfStatsBuffer {
            total_local_queue_depth: 0,
        assert_eq!(result.total_scheduled_duration_ms, 0);
        let cpu_runtime = if let Some(ref cpu_mon) = mgr.cpu_monitor {
        let result = fut.await;
        num_alive_tasks: m.num_alive_tasks() as i64,
        assert_eq!(repr.statistics_cache.entry_count, 0);
pub struct TaskMonitorRepr {
        instrumented_count: cumulative.instrumented_count as i64,
            memory_bytes: metadata_memory,
    pub memory_bytes: i64,
#[repr(C)]
            .unwrap();
//! | `coordinator_reduce` | `TaskMonitorRepr`    | 5 × i64 |
    pub rg_skipped: i64,
    pub total_local_queue_depth: i64,
const _: () = assert!(size_of::<CacheStatsRepr>() == 20 * 8);
        let repr = pack_cache_stats(&mgr);
            hit_count: oi.hits as i64,
    pub io_runtime: RuntimeMetricsRepr,
        assert!(result.total_polls_count >= 0);
/// | total_overflow_count        | `Handle::metrics().worker_overflow_count(i)` Σ |
            buf.fragment_executor_gate.max_permits
/// Snapshot a `ConcurrencyGate` and return a populated `PartitionGateRepr`.
}
        Self {
        use crate::custom_cache_manager::CustomCacheManager;
            memory_bytes: statistics_memory,
const _: () = assert!(size_of::<CacheGroupRepr>() == 5 * 8);
            miss_count: 0,
    pub poison_permits: i64,
        use datafusion::execution::cache::CacheAccessor;
        target_max_permits: gate.target_max_permits() as i64,
    #[test]
    pub entry_count: i64,
    pub build_mask_time_ms: i64,
 * SPDX-License-Identifier: Apache-2.0
        assert_eq!(result.workers_count, 3);
use tokio::runtime::Handle;
}
const _: () = assert!(size_of::<DfStatsBuffer>() == 85 * 8);
            cache_stats: CacheStatsRepr::default(),
            if let Some(cpu_handle) = mgr.cpu_executor.handle() {
        }
        };
    let mut total_busy_ns: u64 = 0;
//! | `cache_stats`        | `CacheStatsRepr`     | 20 × i64 (4 × 5: metadata, statistics, column_index, offset_index) |
/// | total_busy_duration_ms      | `Handle::metrics().worker_total_busy_duration(i)` Σ |
}
                RuntimeMetricsRepr::zeroed()
        use std::sync::Arc;
        let mgr = CustomCacheManager::new();
    #[test]
        let mgr = crate::runtime_manager::RuntimeManager::new(1, 1.5, 1.5);
    pub pending_acquire_batches: i64,
        let result = pack_runtime_metrics(&monitor, rt.handle());
    pub prefetch_wait_count: i64,
    }
        use crate::custom_cache_manager::CustomCacheManager;
    pub single_collector_scan: i64,
    pub coordinator_reduce: TaskMonitorRepr,
//! | `query_execution`    | `TaskMonitorRepr`    | 5 × i64 |
    pub column_index_cache: CacheGroupRepr,
}
            buf.io_runtime.workers_count
        let mut mgr = CustomCacheManager::new();
        )));
/// Snapshot the global `AdaptiveBudgetStats` counters and return a populated `AdaptiveBudgetRepr`.
/// | miss_count       | `mgr.{metadata,statistics}_cache_miss_count()`      |
const _: () = assert!(size_of::<SearchStatsRepr>() == 17 * 8);
        .unwrap_or(0) as i64;
    pub filter_record_batch_time_ms: i64,
    fn default() -> Self {
        assert_eq!(layout::BUFFER_BYTE_SIZE, 680);
        use crate::eviction_policy::PolicyType;
            size_limit_bytes: ci.limit_bytes as i64,
        assert_eq!(result.dropped_count, 0);
    pub listing_table_scan: i64,
impl RuntimeMetricsRepr {
            hit_count: mgr.statistics_cache_hit_count() as i64,
    pub statistics_cache: CacheGroupRepr,
        fallbacks: stats.fallbacks.load(Ordering::Relaxed) as i64,
    }
    pub total_overflow_count: i64,
            tm.total_poll_duration_ms >= 0,
        dropped_count: cumulative.dropped_count as i64,
/// | memory_bytes     | `mgr.get_memory_consumed_by_type({METADATA,STATS})` |
    pub dropped_count: i64,
            stream_next: pack_task_monitor(stream_next_monitor()),
            .get(&Path::from("/test/missing/extra.parquet"))
            buf.io_runtime.workers_count > 0,
            buf.fragment_executor_gate.max_permits > 0,
            assert!(
            query_execution: pack_task_monitor(query_execution_monitor()),
    let mut total_local_queue: u64 = 0;
    use super::*;
    };
/// | num_alive_tasks             | `Handle::metrics().num_alive_tasks()`       |
        active_permits: gate.active_permits() as i64,
    pub total_wait_duration_ms: i64,
/// [`CacheStatsRepr`]. Disabled caches return all-zeros via the manager's
        poison_permits: gate.poison_permits_held() as i64,
/// |------------------------------|---------------------------------|
#[repr(C)]
        assert_eq!(repr.statistics_cache.hit_count, 0);
/*
    }
}
    let metadata_memory = mgr
        max_permits: gate.max_permits() as i64,
    }
            miss_count: oi.misses as i64,
    pub instrumented_count: i64,
/// | total_wait_duration_ms   | `gate.total_wait_ms()`              |
}
    for i in 0..num_workers {
            RuntimeMetricsRepr::zeroed()
    pub workers_count: i64,
                buf.cpu_runtime.workers_count
            offset_index_cache: CacheGroupRepr::default(),
            assert_eq!(g.memory_bytes, 0);
    let statistics_memory = mgr
pub fn pack_cache_stats(mgr: &CustomCacheManager) -> CacheStatsRepr {
pub fn pack_adaptive_budget() -> AdaptiveBudgetRepr {
    let m = handle.metrics();
        spawned_tasks_count: m.spawned_tasks_count() as i64,
const _: () = assert!(size_of::<PartitionGateRepr>() == 8 * 8);
        }
}
            total_polls_count: 0,
impl Default for CacheGroupRepr {
    fn test_pack_cache_stats_reflects_underlying_counters() {
    }
    }
    pub stream_next: TaskMonitorRepr,
        assert_eq!(result.instrumented_count, 0);
        );
//! |----------------------|----------------------|--------|
/// | entry_count      | `mgr.{metadata,statistics}_cache_entry_count()`     |
            assert_eq!(g.entry_count, 0);
#[cfg(test)]
    }
}
    async fn test_full_stats_packing() {
    }
//!
        use object_store::path::Path;
            }
        total_local_queue += m.worker_local_queue_depth(i) as u64;
        total_overflow += m.worker_overflow_count(i);
        let result = pack_task_monitor(&monitor);
            .build()
    TaskMonitorRepr {
    let cumulative = monitor.cumulative();
    let ci = crate::cache::page_index::column_index_cache_stats();
/// | pending_acquire_batches  | `gate.pending_acquire_batches()`    |
/// | total_poll_duration_ms       | cumulative poll duration (ms)   |
            );
/// | max_permits              | `gate.max_permits()`                |
mod tests {
    pub active_permits: i64,
/// | global_queue_depth          | `Handle::metrics().global_queue_depth()`    |
/// | hit_count        | `mgr.{metadata,statistics}_cache_hit_count()`       |
    pub metadata_cache: CacheGroupRepr,
#[repr(C)]
            assert!(stats_cache.get(&p).is_none());
        total_idle_duration_ms: cumulative.total_idle_duration.as_millis() as i64,
        offset_index_cache: CacheGroupRepr {
        assert_eq!(layout::BUFFER_BYTE_SIZE, 680);
    pub hit_count: i64,
        assert_eq!(size_of::<DfStatsBuffer>(), 680);
            total_overflow_count: 0,
        total_local_queue_depth: total_local_queue as i64,
/// | total_polls_count           | `Handle::metrics().worker_poll_count(i)` Σ  |
    }
        let monitor = RuntimeMonitor::new(&rt.handle());
    pub total_poll_duration_ms: i64,
        });
        },
    pub search_stats: SearchStatsRepr,
            42
    pub total_batches_started: i64,
            .enable_all()
        Self {
pub mod layout {
    fn test_pack_runtime_metrics_returns_struct() {
        }
        assert_eq!(repr.metadata_cache.size_limit_bytes, 50 * 1024 * 1024);
        // We can't call df_stats directly without a runtime manager,
            miss_count: mgr.statistics_cache_miss_count() as i64,
//! | `plan_setup`         | `TaskMonitorRepr`    | 5 × i64 |
    pub max_permits: i64,
///
    pub plan_setup: TaskMonitorRepr,
/// Snapshot a `RuntimeMonitor` and return a populated `RuntimeMetricsRepr`.
        ));
    pub size_limit_bytes: i64,
    pub const BUFFER_BYTE_SIZE: usize = size_of::<DfStatsBuffer>();
/// `unwrap_or(0)` accessor fallbacks.
        assert!(result.global_queue_depth >= 0);
        },
            adaptive_budget: pack_adaptive_budget(),
            hit_count: mgr.metadata_cache_hit_count() as i64,
            spawned_tasks_count: 0,
        assert!(layout::BUFFER_BYTE_SIZE > 0);
    pub fragment_executor_gate: PartitionGateRepr,
        coordinator_reduce_monitor, plan_setup_monitor, query_execution_monitor,
pub fn pack_task_monitor(monitor: &TaskMonitor) -> TaskMonitorRepr {
        if mgr.cpu_monitor.is_some() {
            search_stats: crate::search_stats::snapshot(),
                "CPU runtime workers_count should be > 0, got {}",
        },
        mgr.cpu_executor.shutdown();
            assert_eq!(g.size_limit_bytes, 0);
        let result = pack_runtime_metrics(&monitor, rt.handle());
/// | total_batches_started    | `gate.total_queries_admitted()`     |
}
#[repr(C)]
    fn test_pack_task_monitor_writes_duration_fields() {
        blocking_queue_depth: m.blocking_queue_depth() as i64,
            assert_eq!(g.hit_count, 0);
        );
    pub rg_processed: i64,
pub struct CacheGroupRepr {
/// Snapshot the [`CustomCacheManager`] caches and return a populated
            size_limit_bytes: mgr.metadata_cache_size_limit() as i64,
    pub elapsed_compute_ms: i64,
        std::mem::forget(mgr);
    fn test_pack_runtime_metrics_populates_workers_count() {
            blocking_queue_depth: 0,
        };
            } else {
        total_wait_duration_ms: gate.total_wait_ms() as i64,
//! | `search_stats`       | `SearchStatsRepr`    | 17 × i64 |
    pub total_scheduled_duration_ms: i64,
        stream_next_monitor,
    pub total_idle_duration_ms: i64,
/// | Field            | Source                                              |
pub fn pack_partition_gate(gate: &ConcurrencyGate) -> PartitionGateRepr {
/// Snapshot a `TaskMonitor` and return a populated `TaskMonitorRepr`.
/// | spawned_tasks_count         | `Handle::metrics().spawned_tasks_count()`   |
        assert!(
//! | `stream_next`        | `TaskMonitorRepr`    | 5 × i64 |
    const _: () = assert!(BUFFER_BYTE_SIZE == 680);
        total_busy_ns += m.worker_total_busy_duration(i).as_nanos() as u64;
    #[tokio::test]
    PartitionGateRepr {
    pub pending_acquire_permits: i64,
        pending_acquire_batches: gate.pending_acquire_batches() as i64,
    use super::*;
            miss_count: mgr.metadata_cache_miss_count() as i64,
        assert!(metadata_cache
}
        total_batches_started: gate.total_queries_admitted() as i64,
/// |------------------|-----------------------------------------------------|
    async fn test_pack_task_monitor_after_instrumented_future() {
        );
            "IO runtime workers_count should be > 0, got {}",
    pub delegation_calls: i64,
            coordinator_reduce: pack_task_monitor(coordinator_reduce_monitor()),
impl Default for CacheStatsRepr {
            miss_count: ci.misses as i64,
        let monitor = RuntimeMonitor::new(&rt.handle());
            total_busy_duration_ms: 0,
                pack_runtime_metrics(cpu_mon, &cpu_handle)
        total_polls_count: total_polls as i64,
    pub prefetch_wait_time_ms: i64,
        assert_eq!(result.workers_count, 2);
        assert_eq!(repr.metadata_cache.miss_count, 4);
            global_queue_depth: 0,
            io_runtime,
            PolicyType::Lru,
//! transfer across the FFM boundary.
    pub parquet_scan_total_time_ms: i64,
    pub parquet_processing_time_ms: i64,
        total_polls += m.worker_poll_count(i);
pub struct CacheStatsRepr {
/// | workers_count               | `Handle::metrics().num_workers()`           |
            "total_poll_duration should be >= 0, got {}",
            tokio::task::yield_now().await;
    pub fn zeroed() -> Self {
    }
pub struct SearchStatsRepr {
//! into a `#[repr(C)]` `DfStatsBuffer` struct (680 bytes) for efficient
//! Stats packing helpers for the FFM `df_stats()` function.
        mgr.set_statistics_cache(stats_cache);
    pub adaptive_budget: AdaptiveBudgetRepr,
            let p = Path::from(format!("/test/missing/{i}.parquet"));
#[repr(C)]
        total_busy_duration_ms: (total_busy_ns / 1_000_000) as i64,
            assert!(metadata_cache.get(&p).is_none());
            entry_count: mgr.statistics_cache_entry_count() as i64,
        let rt = tokio::runtime::Builder::new_multi_thread()
    pub cpu_runtime: RuntimeMetricsRepr,
        // Verify that the buffer size assertion holds
    #[test]
            .unwrap();
    pub offset_index_cache: CacheGroupRepr,
            "fragment_executor_gate max_permits should be > 0, got {}",
            statistics_cache: CacheGroupRepr::default(),
    pub cache_stats: CacheStatsRepr,
#[repr(C)]
    pub on_batch_mask_time_ms: i64,
    pub total_polls_count: i64,
    // Sum per-worker metrics into aggregates
        assert_eq!(result.total_idle_duration_ms, 0);
#[repr(C)]
const _: () = assert!(size_of::<AdaptiveBudgetRepr>() == 2 * 8);
}
            hit_count: ci.hits as i64,
        assert!(
pub fn pack_runtime_metrics(_monitor: &RuntimeMonitor, handle: &Handle) -> RuntimeMetricsRepr {
        assert!(result.total_busy_duration_ms >= 0);
const _: () = assert!(size_of::<RuntimeMetricsRepr>() == 9 * 8);
//! | `cpu_runtime`        | `RuntimeMetricsRepr` | 9 × i64 (zeroed if N/A) |
/// | blocking_queue_depth        | `Handle::metrics().blocking_queue_depth()`  |
        let io_runtime = pack_runtime_metrics(&mgr.io_monitor, mgr.io_runtime.handle());
        let rt = tokio::runtime::Builder::new_multi_thread()
use crate::executor::ConcurrencyGate;
            entry_count: ci.entries as i64,
const _: () = assert!(size_of::<TaskMonitorRepr>() == 5 * 8);
    pub num_alive_tasks: i64,
}
        for g in [&repr.metadata_cache, &repr.statistics_cache] {
//!
pub struct AdaptiveBudgetRepr {
            memory_bytes: 0,
    pub total_busy_duration_ms: i64,
    #[test]
//! | Group                | Type                 | Fields |
        Self {
pub struct DfStatsBuffer {
        let repr = pack_cache_stats(&mgr);
}
        mgr.set_file_metadata_cache(metadata_cache);
        total_poll_duration_ms: cumulative.total_poll_duration.as_millis() as i64,
            50 * 1024 * 1024,
/// | active_permits           | `gate.active_permits()`             |
    pub object_store_read_time_ms: i64,
/// | Field                        | Source                          |
        let monitor = query_execution_monitor();
    pub target_max_permits: i64,
            .worker_threads(2)
pub struct PartitionGateRepr {
            workers_count: 0,
pub struct RuntimeMetricsRepr {
    let mut total_polls: u64 = 0;
            entry_count: mgr.metadata_cache_entry_count() as i64,
//!
    CacheStatsRepr {
        statistics_cache: CacheGroupRepr {
        workers_count: num_workers as i64,
            0.8,
/// |-----------------------------|---------------------------------------------|
        },
    AdaptiveBudgetRepr {
/// | Field                       | Source                                     |
/// | total_scheduled_duration_ms  | cumulative scheduled dur. (ms)  |
                buf.cpu_runtime.workers_count > 0,
        .get_memory_consumed_by_type(crate::cache::CACHE_TYPE_STATS)
            10 * 1024 * 1024,
            memory_bytes: oi.used_bytes as i64,
    pub miss_count: i64,
            size_limit_bytes: 0,
///
        total_scheduled_duration_ms: cumulative.total_scheduled_duration.as_millis() as i64,
use tokio_metrics::{RuntimeMonitor, TaskMonitor};
            .is_none());
///
//! ## Struct layout
/// | total_idle_duration_ms       | cumulative idle duration (ms)   |
    pub rejections: i64,
        let fut = monitor.instrument(async {
    pub parquet_scan_until_data_time_ms: i64,
        total_overflow_count: total_overflow as i64,
        pending_acquire_permits: gate.pending_acquire_permits() as i64,
            fragment_executor_gate: pack_partition_gate(mgr.cpu_executor.concurrency_gate()),
        for i in 0..3 {
#[repr(C)]
///
        // but we verify the constant is correct.
    pub spawned_tasks_count: i64,
    #[test]
        let metadata_cache = Arc::new(MutexFileMetadataCache::new(DefaultFilesMetadataCache::new(
/// | target_max_permits       | `gate.target_max_permits()`         |
        use crate::cache::MutexFileMetadataCache;
        assert!(
    }
            entry_count: oi.entries as i64,
    }
        // Drive 3 misses on each cache and one extra miss on metadata.
    let mut total_overflow: u64 = 0;
    pub global_queue_depth: i64,
        } else {
    fn test_pack_cache_stats_empty_manager_zeroed() {
    fn test_df_stats_buffer_too_small() {
            cpu_runtime,
    pub fallbacks: i64,
 */
        global_queue_depth: m.global_queue_depth() as i64,
        let stats_cache = Arc::new(CustomStatisticsCache::new(
        assert_eq!(repr.metadata_cache.hit_count, 0);
            .enable_all()
    let num_workers = m.num_workers();
        metadata_cache: CacheGroupRepr {
}
    }
            size_limit_bytes: oi.limit_bytes as i64,
/// |--------------------------|-------------------------------------|
        assert_eq!(repr.metadata_cache.entry_count, 0);
    pub blocking_queue_depth: i64,
use crate::custom_cache_manager::CustomCacheManager;
        }
            .build()
        }
//! | `fragment_executor_gate` | `PartitionGateRepr`  | 8 × i64 |
        use datafusion::execution::cache::DefaultFilesMetadataCache;
}
/// | poison_permits           | `gate.poison_permits_held()`        |
            memory_bytes: ci.used_bytes as i64,
            column_index_cache: CacheGroupRepr::default(),
    pub parquet_bytes_scanned: i64,
        .get_memory_consumed_by_type(crate::cache::CACHE_TYPE_METADATA)
    use crate::task_monitors::{
