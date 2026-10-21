        Ok(Ok(r)) => {
    pub rayon_merge_wall_millis: i64,
        let mut overflow_count_total: i64 = 0;
///   itself, plus any rayon-pool install overhead, plus errored and panicked invocations).
    pub tokio_local_queue_depth_total: i64,
///   overlap but are not identical — they intentionally measure different things.
    let start = Instant::now();
/// Returns all-zeros if neither pool has been initialized yet (no merge has run).
        s.rayon_configured_threads = pool.current_num_threads() as i64;
    // RAYON_STARTED is bumped inside the closure so it reflects when rayon actually picked up
// =============================================================================
{
        Ok(Err(e)) => {
            RAYON_PANICKED.fetch_add(1, Ordering::Relaxed);
//!
        s.tokio_num_workers = m.num_workers() as i64;
    pub tokio_active_tasks: i64,
    F: FnOnce() -> Result<R, MergeError>,
/*
        Err(panic_payload) => {
    s
    // Tokio — only if IO_RUNTIME has been initialized
        let mut polls_count_total: i64 = 0;
        s.tokio_global_queue_depth = m.global_queue_depth() as i64;
// =============================================================================
        f()
use super::error::MergeError;
static RAYON_MERGE_WALL_MILLIS: AtomicU64 = AtomicU64::new(0);
static RAYON_COMPLETED: AtomicU64 = AtomicU64::new(0);
    pub tokio_num_blocking_threads: i64,
///   happened INSIDE the rayon-wrapped column-encoding pass. Logical errors that occur
    let result = catch_unwind(AssertUnwindSafe(|| {
        s.rayon_merge_tasks_started = RAYON_STARTED.load(Ordering::Relaxed) as i64;
pub fn record_merge<F, R>(f: F) -> Result<R, MergeError>
// =============================================================================
    }));
    RAYON_SUBMITTED.fetch_add(1, Ordering::Relaxed);
        let mut local_queue_depth_total: i64 = 0;
static RAYON_FAILED: AtomicU64 = AtomicU64::new(0);
static RAYON_PANICKED: AtomicU64 = AtomicU64::new(0);
    RAYON_MERGE_WALL_MILLIS.fetch_add(elapsed_ms, Ordering::Relaxed);
        s.tokio_overflow_count_total = overflow_count_total;
    pub tokio_polls_count_total: i64,
/// Counter semantics:
//! All atomics use Relaxed ordering — values are monotonic-counter or last-write-wins; readers
 * this file be licensed under the Apache-2.0 license or a
    let elapsed_ms = start.elapsed().as_millis() as u64;
///
        RAYON_STARTED.fetch_add(1, Ordering::Relaxed);
        let n = m.num_workers();
        s.rayon_merge_tasks_panicked = RAYON_PANICKED.load(Ordering::Relaxed) as i64;
}
/// Wraps a rayon-pool-using closure to record submission/completion/panic + wait time.
        // Per-worker fan-out: sum across all workers for runtime-wide totals.
        s.tokio_polls_count_total = polls_count_total;
pub fn collect() -> NativeRuntimeStats {
 * The OpenSearch Contributors require contributions made to
 */
    pub tokio_global_queue_depth: i64,
            polls_count_total += m.worker_poll_count(i) as i64;
        s.tokio_local_queue_depth_total = local_queue_depth_total;
            Ok(r)
            std::panic::resume_unwind(panic_payload);
    pub tokio_overflow_count_total: i64,
//
//! may see slightly stale values but never corrupt state.
    pub tokio_num_workers: i64,
use std::time::Instant;
// Snapshot collected on every stats request
        let mut busy_millis: i64 = 0;
        }
        s.rayon_merge_tasks_failed = RAYON_FAILED.load(Ordering::Relaxed) as i64;
    // the work — `submitted - started` ≈ queued tasks waiting for a worker.
    // Rayon — only if MERGE_POOL has been initialized
            Err(e)
        s.tokio_active_tasks = m.num_alive_tasks() as i64;
    pub rayon_merge_tasks_failed: i64,
}
 *
        s.tokio_spawned_tasks_total = m.spawned_tasks_count() as i64;
//! Process-wide native runtime metrics for the parquet merge path.
// Atomic counters around the rayon merge pool
/// - `started`   = number of times the closure actually began executing on a rayon worker.
#[derive(Default, Debug, Clone, Copy)]
            RAYON_FAILED.fetch_add(1, Ordering::Relaxed);
static RAYON_SUBMITTED: AtomicU64 = AtomicU64::new(0);
    // catch_unwind so a panic increments RAYON_PANICKED before being re-raised. AssertUnwindSafe
use std::panic::{catch_unwind, AssertUnwindSafe};
    if let Some(pool) = super::io_task::MERGE_POOL.get() {
///   BEFORE this wrapper runs (FFM bridge throws, Java-side validation fails, IO task
static RAYON_STARTED: AtomicU64 = AtomicU64::new(0);
        for i in 0..n {
    }
    pub rayon_merge_tasks_completed: i64,
        s.rayon_merge_wall_millis = RAYON_MERGE_WALL_MILLIS.load(Ordering::Relaxed) as i64;
    pub rayon_merge_tasks_panicked: i64,
        }
        s.tokio_num_blocking_threads = m.num_blocking_threads() as i64;
// Note: `RAYON_MERGE_WALL_MILLIS` is the cumulative wall-clock duration of every wrapped
// spent waiting to install work on the rayon pool. The previous name `*_install_wait_millis`
    pub rayon_configured_threads: i64,
        s.rayon_merge_tasks_completed = RAYON_COMPLETED.load(Ordering::Relaxed) as i64;
/// - `submitted` = number of times this wrapper was entered.
 * compatible open source license.
where
// =============================================================================
    if let Some(rt) = super::io_task::IO_RUNTIME.get() {
        s.tokio_blocking_queue_depth = m.blocking_queue_depth() as i64;
 * SPDX-License-Identifier: Apache-2.0
    let mut s = NativeRuntimeStats::default();
}
    pub rayon_merge_tasks_started: i64,
    pub tokio_blocking_queue_depth: i64,
/// - `merge_wall_millis` accumulates total wall-clock duration of every wrapped call (the work
            overflow_count_total += m.worker_overflow_count(i) as i64;
    }
// =============================================================================
            local_queue_depth_total += m.worker_local_queue_depth(i) as i64;
    }
pub struct NativeRuntimeStats {
    // is acceptable here because the only state we touch in the closure is local to it.
        s.tokio_workers_busy_millis_total = busy_millis;
//! Exposes counters around the rayon merge pool and a snapshot of the tokio IO runtime metrics.
            RAYON_COMPLETED.fetch_add(1, Ordering::Relaxed);
    match result {
/// - `panicked`  = number of times the closure unwound (panicked); the panic is then re-raised.
    pub tokio_spawned_tasks_total: i64,
        s.rayon_merge_tasks_submitted = RAYON_SUBMITTED.load(Ordering::Relaxed) as i64;
        }
/// Snapshot the current state of the rayon merge pool and tokio IO runtime.
/// - `completed` = number of times the closure returned `Ok(_)`.
        let m = rt.metrics();
            busy_millis += m.worker_total_busy_duration(i).as_millis() as i64;
    pub tokio_workers_busy_millis_total: i64,
        }
// was misleading; saturation is better inferred from the ratio of wall time to thread count.
// merge operation, including the parallel column-encoding work itself — NOT just the time
/// - `failed`    = number of times the closure returned `Err(_)` — i.e. logical errors that
use std::sync::atomic::{AtomicU64, Ordering};
///   NOT this one. As a result, `merge_tasks_failed` and `merge_failures` populations
///   panics, etc.) increment the per-shard `parquet.merge.merge_failures` counter but
// Atomic counters around the rayon merge pool
    pub rayon_merge_tasks_submitted: i64,
