    /// Apply pending phantom correction from the self-correcting budget.
    #[test]
//!
        self.inner.unregister(consumer);
    fn test_cancel_query_cancels_all_siblings() {
}
        // does nothing. Silent no-ops here hid a real bug (the ~5s LM stall):
        // may push entries into the registry, so we filter to our id range.
use dashmap::DashMap;
/// unconditionally — so the first stream to close deleted the entry for its
    fn test_multiple_concurrent_queries() {
                }
    inner: Arc<dyn MemoryPool>,
    impl Ord for HeapEntry {
    // BinaryHeap is a max-heap; Reverse flips it so the smallest current_bytes
///
        let mut r_done = make_reservation(&done_pool, "done");
        let ctx_a_id = 50_005;
                // Strictly greater: equal-byte ties keep the first-seen entry.
    // on it immediately, which can legitimately be 0ns — clamp to 1 so a real
pub fn flush_cpu_runtime_with_handle(handle: &tokio::runtime::Handle, context_id: i64) {
/// `stream_close` to grab the handle before the tracker is dropped (which
        trackers
            .push(Arc::clone(&tracker));
        }
            // query is never simultaneously visible in both the registry scan
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
    pub memory_pool: Arc<QueryMemoryPool>,
            .last()
            // Remove from registry BEFORE incrementing total. This ensures a
        drop(tracker);
        for r in reservations.drain(..) {
        .and_then(|trackers| trackers.last().map(|t| t.cancellation_token.clone()))
        let mut reservation = make_reservation(&pool, "test");
        assert_eq!(coord_tracker.query_type, QueryType::Coordinator);
            start_time: Instant::now(),
            .last()
        });
    /// Snapshot wall time and mark completed.
        }
//! Per-query memory tracking via DataFusion's MemoryPool trait.
            // snapshot_cancellation_stats.
        // first stream's tracker.
        }
/// Filters applied on the Rust side, in this order:
    #[test]
        assert!(written >= 1);
            .cancelled_at_nanos
        let pool_md: Arc<dyn MemoryPool> = ctx_md.memory_pool().unwrap();
            debug!(
        self.completed.load(Ordering::Acquire)
    fn unregister(&self, consumer: &MemoryConsumer) {
    // -----------------------------------------------------------------------
        }
            .unwrap()
    #[test]
        assert_eq!(qp.current_bytes(), 0);
            assert_eq!(qp.current_bytes(), 5000);
    }
//! still enforced), but each query also tracks its own current and peak
        let pool_a = ctx_a.memory_pool().unwrap();
        assert_eq!(qp.current_bytes(), 2000);
        // process the abort and drop the future (freeing the sentinel). A single
        reservation: &MemoryReservation,
        assert!(t2 - t1 >= 0.04);
            phantom_corrector: None,
        }
    completed: AtomicBool,
        let exec = crate::executor::DedicatedExecutor::new("test-flush", builder, 2);
//! All allocations flow through the global pool (so the global limit is
            .load(Ordering::Relaxed);
mod tests {
        for ctx in contexts.drain(..) {
        tracker
        drop(a);
    use std::cmp::{Ordering, Reverse};
        let our: Vec<&WireQueryMetric> = buf[..written]
            for _ in 0..FLUSH_YIELDS_PER_WORKER {
        i64::MAX
/// independently tracking this query's current and peak memory usage.
        }
#[derive(Debug)]
// Global registry
        // Removed from registry
        // Second cancel should not overwrite the first timestamp
        let mut r_hi = make_reservation(&pool_hi, "hi");
        let tok_b = b.cancellation_token().unwrap();
        cancel_query(ctx_id);
        Self {
        let pool_lo: Arc<dyn MemoryPool> = ctx_lo.memory_pool().unwrap();
        let ctx_hi = QueryTrackingContext::new(id_hi, Arc::clone(&global), QueryType::Shard);
#[repr(C)]
            }
impl QueryTracker {
        // Both trackers visible under the shared id.
///
/// after the `QueryStreamHandle` is dropped (via `stream_close`). Call
            r.try_grow((i as usize + 1) * 1_000).unwrap();
        let global = make_global_pool(10_000);
        assert!(tracker.cancelled_at_nanos.load(Ordering::Relaxed) == 0);
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
        let mut buf = fresh_buf(8);
        drop(coord_ctx);
        }
    let mut coordinator_count: i64 = 0;
            assert!(our.iter().any(|m| m.context_id == id_hi));
    for tracker in trackers {
        let mut buf = fresh_buf(3);
            if cancelled_nanos > 0 && (now_nanos - cancelled_nanos) >= threshold_nanos {
        self.tracker.as_ref().map(|t| Arc::clone(&t.memory_pool))
/// | Field         | Meaning                                                   |
        let qp = ctx.memory_pool().unwrap();
    fn test_top_n_skips_completed_and_zero_byte_trackers() {
            .last()
/// which must extract the handle before dropping the tracker (drop removes it
        let (corrector, reservation) =
    fn test_wall_secs_ticks_while_running() {
    fn test_sibling_stream_drop_does_not_orphan_survivor() {
    }
///
        // the flush until the deferred drop is observed, bounded by a timeout so
        fn cmp(&self, other: &Self) -> Ordering {
///
        if rx.recv_timeout(CANCEL_FLUSH_TIMEOUT).is_err() {
    }
    }
            let completed = tracker.is_completed();
impl std::fmt::Display for QueryMemoryPool {
        let id = 70_200;
        &mut self,
    fn test_query_pool_delegates_reserved_to_inner() {
 * compatible open source license.
            tracker.cpu_runtime_handle.set(handle).ok();
    QUERY_REGISTRY.get(&context_id).and_then(|trackers| {
                }
use tokio_util::sync::CancellationToken;
// Per-query memory pool
        let clone = Arc::clone(&corrector);
            current_bytes: -1,
    fn test_top_n_with_buffer_larger_than_live_set() {
        } // ctx dropped here — removes from registry
    Shard,
                            crate::native_node_stats::inc_native_search_task_total();
    // Cancellation stats tests
            contexts.push(ctx);
        let shard_ctx = QueryTrackingContext::new(shard_id, Arc::clone(&global), QueryType::Shard);
        }
/// | current_bytes | `QueryMemoryPool::current_bytes`, clamped to `i64::MAX`   |
                match tracker.query_type {
        QUERY_REGISTRY.remove(&live_id);
        let ctx_b_id = 50_006;
    }
        let delta = corrector.take_pending_delta();
    }
///   drops to zero on `Drop` anyway, so this is mostly a fast path)
    );
        reservation.try_grow(2000).unwrap();
static PROCESS_START: Lazy<Instant> = Lazy::new(Instant::now);
            .wall_secs();
        // First stream closes (stage-1 drains to EOF and drops) …
        let global = make_global_pool(10_000);
///
        }
        assert_eq!(qp.peak_bytes(), 8000);
    }
    /// if tracking is disabled.
    use std::thread;
    tracker: Option<Arc<QueryTracker>>,
            assert!(QUERY_REGISTRY.contains_key(&ctx_id));
    if let Some(trackers) = QUERY_REGISTRY.get(&context_id) {
            self.current_bytes.load(Ordering::Relaxed),
            if cancelled_nanos > 0 {
    // QueryTrackingContext lifecycle tests
    /// disabled. Prefer this over `get_cancellation_token(context_id)` when a
        exec.join_blocking();
        assert_eq!(qp.peak_bytes(), 1500);
        assert!(tok_a.is_cancelled());
        assert!(coord_tracker.cancelled_at_nanos.load(Ordering::Relaxed) > 0);
    }
        let written = snapshot_top_n_by_current(&mut buf);
/// the woken tasks (which may land on different workers' queues) are processed
/// Distinguishes shard-level queries from coordinator-level queries for stats.
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
            }
/// `cancel_query` can flush deferred drops on that runtime.
        // Simulates: query succeeds → stream is consumed → handle dropped
        // Simulate allocations during stream consumption
}
            cancelled_at_nanos: AtomicU64::new(0),
            assert_eq!(slot.context_id, -1);
            // (current) and the total counter — preventing double-counting in
    }
        drop(r_lo);
        }
// ---------------------------------------------------------------------------
                            crate::native_node_stats::inc_native_search_shard_task_total();
        // Not cancelled — cancelled_at_nanos should be 0
/// target_partitions = N, levels 2 and 3 each have N tasks.
                        QueryType::Shard => {
            }
    // -----------------------------------------------------------------------
        assert!(written < buf.len());
        // flush_cpu_runtime gives the runtime scheduling opportunities to
        cancel_query(ctx_id);
        let done_pool: Arc<dyn MemoryPool> = done_ctx.memory_pool().unwrap();
            }
/*
use tokio::task::AbortHandle;
            WireQueryMetric {
            memory_pool: query_pool,
        let global = make_global_pool(10_000);
        drop(ctx);
    fn test_query_pool_tracks_current_and_peak() {
    }
        Self {
            match (&self.phantom_corrector, &mut self.phantom_reservation) {
/// `reduceDone.await(5s)` latch expired on every LM query (~5s stall).
    phantom_corrector: Option<Arc<crate::phantom_corrector::PhantomCorrector>>,
        assert!(tok_b.is_cancelled());
pub enum QueryType {
    for _ in 0..FLUSH_WORKER_COUNT {
    #[test]
        drop(r_md);
        drop(_ctx);
        let pool: Arc<dyn MemoryPool> = qp.clone();
        ]
    }
        // touch it.
        let mut r_lo = make_reservation(&pool_lo, "lo");
    }
    impl Eq for HeapEntry {}
            .cancelled_at_nanos
    // Top-N snapshot tests
        thread::sleep(Duration::from_millis(10));
}
        let live: Vec<i64> = QUERY_REGISTRY.iter().map(|e| *e.key()).collect();
        let pool_b = ctx_b.memory_pool().unwrap();
        );
// ---------------------------------------------------------------------------
        let done_id = 70_102;
        assert!(written >= 1 && written <= 2);
        self.phantom_corrector = Some(corrector);
        r_live.try_grow(4_096).unwrap();
        let b = QueryTrackingContext::new(ctx_id, global, QueryType::Coordinator);
    #[test]
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
/// `stream_next` could not be interrupted, and the reduce sink's
    }
    pub cpu_runtime_handle: OnceLock<tokio::runtime::Handle>,
    if let Some(trackers) = QUERY_REGISTRY.get(&context_id) {
        assert_eq!(qp.peak_bytes(), 5000);
        MemoryConsumer::new(name).register(pool)
    #[test]
        clone
impl WireQueryMetric {
                let now_empty = entry.is_empty();
        drop(coord_tracker);
    // Snapshot the trackers under the entry lock, then cancel outside it —
    }
}
                tracker.memory_pool.current_bytes(),
        let qp = Arc::new(QueryMemoryPool::new(global));
        self.track_grow(additional);
        let live_ctx = QueryTrackingContext::new(live_id, Arc::clone(&global), QueryType::Shard);
    #[test]
        assert_eq!(qp.current_bytes(), 900);
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
        }
                sample_logged += 1;
/// A per-query MemoryPool that delegates to a shared global pool while
        }
pub fn take_cpu_runtime_handle(context_id: i64) -> Option<tokio::runtime::Handle> {
        self.inner.reserved()
    });
    }
//! in the global [`QueryRegistry`] on creation, and removes the entry
            drop(ctx);
        self.peak_bytes.load(Ordering::Relaxed)
            let floor = current / 10;
/// `executeLocalPlan(..., ctx.taskId())` with the same query-level task id.
/// Flush the CPU runtime for the given context_id, giving tokio workers
        // a genuine regression (flush never processes the drop) still fails.
    if value > i64::MAX as usize {
const FLUSH_YIELDS_PER_WORKER: usize = 32;
const FLUSH_WORKER_COUNT: usize = 4;
        let shard_tracker = Arc::clone(QUERY_REGISTRY.get(&shard_id).unwrap().last().unwrap());
            if bytes == 0 {
    use std::collections::BinaryHeap;
#[derive(Debug)]
        assert_eq!(QUERY_REGISTRY.get(&ctx_id).unwrap().len(), 1);
    #[test]
    /// Heap entry — orders purely by `bytes`. The tracker rides along but is
        // Drop context — removes from registry
///   are not "heavy" candidates)
            tracker.mark_completed();
                context_id: 0,
        let global = make_global_pool(1_000_000);
                if bytes > min.bytes {
/// (ranked by `current_bytes` descending) into `out`. Returns the number of
        if delta == 0 {
        // cancelled_at should be set
    }
/// heavier than that root replaces it.
/// Extract the CPU runtime handle from the tracker, removing it. Used by
        for tracker in entry.value() {
    }
            let cancelled_nanos = tracker.cancelled_at_nanos.load(Ordering::Acquire);
    /// The per-query memory pool to install in a `RuntimeEnv`, or `None`
    }
/// Holds per-query metrics: memory pool reference, wall-clock timing, and
            }
                                  // Block forever — only abort can end this.
                if elapsed_since_cancel >= cancel_stats_threshold().as_nanos() as u64 {
/// No-op for unknown or already-completed queries.
        assert!(tracker.cancelled_at_nanos.load(Ordering::Relaxed) > 0);
 * SPDX-License-Identifier: Apache-2.0
const _: () = assert!(std::mem::size_of::<WireQueryMetric>() == 2 * 8);
            self.inner.name(),
/// for writes of `out.len() * size_of::<WireQueryMetric>()` bytes and properly
        // Entry is gone after drop
            }
            .fetch_max(old + additional, Ordering::Relaxed);
            let pool: Arc<dyn MemoryPool> = ctx.memory_pool().unwrap();
        assert_eq!(qp.peak_bytes(), 1000);
/// seen so far; the smallest of those sits at the root, and any new entry
        }
        drop(ctx_md);
            reservations.push(r);
 *
        QUERY_REGISTRY
        let t2 = QUERY_REGISTRY
            if dropped.load(Ordering::Acquire) {
        let pool: Arc<dyn MemoryPool> = qp.clone();
    }
            }
        reservation.try_grow(1000).unwrap();
    }
        // drop removes from registry automatically
                }));
///
        let ctx_id = 60_003;
        }
    #[test]
    // -----------------------------------------------------------------------
            .unwrap()
        let mut contexts = Vec::with_capacity(ids.len());
                drop(entry);
#[derive(Debug, Clone, Copy)]
    let mut shard_count: i64 = 0;
    let now_nanos = PROCESS_START.elapsed().as_nanos() as u64;
/// reduce sinks (stage 1 and stage 3), and both call
        let global = make_global_pool(1_000_000);
        assert_eq!(qp.peak_bytes(), 5000);
/// Flush variant that takes the runtime handle directly — used by `stream_close`
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
        drop(ctx);
            n
        let global = make_global_pool(1_000_000);
        }
        let mut r_live = make_reservation(&live_pool, "live");
        drop(live_ctx);
    fn test_cancel_query_flushes_deferred_drops() {
// ---------------------------------------------------------------------------
    if n == 0 {
        assert_eq!(qp.peak_bytes(), 8000);
    use std::time::{Duration, Instant};
        let ctx_id = 50_001;
    /// registry overwrote the first tracker at insert and removed the whole
        return 0;
        drop(ctx);
    pub fn set_phantom_corrector(
            );
            .iter()
        drop(shard_tracker);
                entry.retain(|t| !Arc::ptr_eq(t, tracker));
        let pool: Arc<dyn MemoryPool> = qp.clone();
}
/// registered tracker's token — callers that own a `QueryTrackingContext`
        // After flushing, the sentinel must have been dropped.
    }
        }
        let written = snapshot_top_n_by_current(&mut buf);
            futures::future::pending::<()>().await;
            let _ = tx.send(());
            abort_handle: OnceLock::new(),
        drop(b);
            nanos as f64 / 1_000_000_000.0
        let shard_id = 60_005;
/// Clone a cancellation token for the given context_id, if registered.
                context_id,
        cancel_query(coord_id);
/// `task_cancellation.duration_millis` default of 10 000 ms.
        Self {
        return;
        let written = snapshot_top_n_by_current(&mut buf);
            Some(self.cmp(other))
/// deferred drops (pull_from_input tasks holding GroupValues buffers).
                    match tracker.query_type {
        assert_eq!(tracker.cancelled_at_nanos.load(Ordering::Relaxed), 0);
            context_id: -1,
        // flush is best-effort: it spawns a fixed number of yield tasks and
        // cancel_query aborts the task (marks it cancelled in the runtime)
    fn track_grow(&self, additional: usize) {
/// a stable, alignment-safe layout (8-byte aligned on every target we support).
        assert_eq!(qp.peak_bytes(), 4000);
        fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        let our: Vec<&WireQueryMetric> = buf[..written]
    /// Wall-clock duration. Returns the frozen snapshot if completed,
            warn!(
        let global = make_global_pool(10_000);
    fn shrink(&self, reservation: &MemoryReservation, shrink: usize) {
pub fn cancel_stats_threshold() -> Duration {
///   Level 2: CoalescePartitions' run_input tasks see closed channel → exit →
        assert!(QUERY_REGISTRY.contains_key(&ctx_id));
        let _ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
        assert_eq!(qp.current_bytes(), 1500);
    }
            .unwrap()
}
        }
        }
    }
                        tracker: Arc::clone(tracker),
    fn make_global_pool(limit: usize) -> Arc<dyn MemoryPool> {
        drop(ctx);
            assert_eq!(qp.peak_bytes(), 5000);
        let ctx = QueryTrackingContext::new(0, global, QueryType::Shard);
            tracker.abort_handle.set(handle).ok();
        fn eq(&self, other: &Self) -> bool {
/// For `context_id == 0` (unset), no tracking is performed.
/// Lock-free: reads each entry's `cancelled_at_nanos` atomically.
/// With multiple streams under one id this returns the MOST RECENTLY
    pub context_id: i64,
        self.completed.store(true, Ordering::Release);
        drop(r_hi);
    }
/// - `current_bytes == 0` is skipped (registered but un-allocated trackers
    /// a clean registry. Tests in this module are tagged with unique id ranges
        self.inner.shrink(reservation, shrink);
    fn fresh_buf(n: usize) -> Vec<WireQueryMetric> {
    fn drop(&mut self) {
                "flush_cpu_runtime({}): timed out after {}ms",
    #[test]
            let mut reservation = make_reservation(&pool, "test");
        let mut r_md = make_reservation(&pool_md, "md");
        assert!(!survivor_token.is_cancelled());
    pub start_time: Instant,
        };
        // The abort is async — the task future may not be dropped yet.
                continue;
        let live_pool: Arc<dyn MemoryPool> = live_ctx.memory_pool().unwrap();
/// removes it from the registry).
const CANCEL_FLUSH_TIMEOUT: Duration = Duration::from_millis(500);
    /// This context's OWN cancellation token, or `None` if tracking is
            } else if let Some(Reverse(min)) = heap.peek() {
    }
use std::sync::atomic::{AtomicBool, AtomicU64, AtomicUsize, Ordering};
            .get(&ctx_id)
    // cancellation is never mistaken for "not cancelled".
    }
            return Self {
        let coord_tracker = Arc::clone(QUERY_REGISTRY.get(&coord_id).unwrap().last().unwrap());
        if let Some(tracker) = trackers.last() {
            .filter(|m| (id_lo..=id_hi).contains(&m.context_id))
        cancel_query(ctx_id);
    }
// ---------------------------------------------------------------------------
    pub fn cancellation_token(&self) -> Option<CancellationToken> {
        let coord_id = 60_006;
/// single pass over the registry runs in `O(M log N)` where `M` is the
        drop(ctx_a);
    fn make_reservation(pool: &Arc<dyn MemoryPool>, name: &str) -> MemoryReservation {
use log::{debug, warn};
    pub query_type: QueryType,
    fn name(&self) -> &str {
    }
            .entry(context_id)
/// Call this AFTER `stream_close` has dropped the `QueryStreamHandle` (which
    }
        drop(ctx_b);
        // explicit cleanup (the error path in executeQueryPhaseAsync)
        let mut res_b = make_reservation(&(pool_b.clone() as Arc<dyn MemoryPool>), "query_b");
        drop(ctx);
    }
        let nanos = self.wall_nanos.load(Ordering::Acquire);
        cancel_query(ctx_id);
            f,
        // Verify each query is registered, cancelled, and has correct type
        assert!(ctx.memory_pool().is_none());
        let tracker = Arc::clone(QUERY_REGISTRY.get(&ctx_id).unwrap().last().unwrap());
        let mut buf: Vec<WireQueryMetric> = Vec::new();
        if context_id == 0 {
        let second = QUERY_REGISTRY
        assert_eq!(qp.peak_bytes(), 4000);
            cpu_runtime_handle: OnceLock::new(),
        // is settled, then drop the context to flip the completed flag.
    /// caller's await uncancellable.
        reservation.try_grow(5000).unwrap();
    /// key at first Drop — so `cancel_query` on the shared id found nothing
        // Top-2 must contain ids hi and md but not lo. Other parallel tests
    pub context_id: i64,
        if let Some(handle) = tracker.abort_handle.get() {
        drop(tracker);
    // -----------------------------------------------------------------------
    /// `QueryTrackingContext` is at hand: the registry lookup targets the most
        let global = make_global_pool(1_000_000);
    pub fn memory_pool(&self) -> Option<Arc<QueryMemoryPool>> {
            .ok();
/// Store the CPU task's AbortHandle for the given context_id.
            };
            .unwrap()
    }
pub fn flush_cpu_runtime(context_id: i64) {
        drop(tracker);
    // set — the one a heavier candidate displaces.
            handle.abort();
    }
    drop(tx);
    }
    ) -> Arc<crate::phantom_corrector::PhantomCorrector> {
/// Order of entries written into `out` is unspecified — heap order, not
            flush_cpu_runtime(ctx_id);
        out[written] = WireQueryMetric::from_tracker(&entry.tracker);
        // Now cancelled_at_nanos should be > 0
        thread::sleep(Duration::from_millis(10));
    fn test_top_n_zero_capacity_returns_zero() {
        let survivor_token = second.cancellation_token().unwrap();
    // QueryMemoryPool tests
        assert_eq!(first, second);
    }
    let nanos = (PROCESS_START.elapsed().as_nanos() as u64).max(1);
        assert_eq!(qp.peak_bytes(), 1500);
        for slot in &buf[written..] {
        let global = make_global_pool(10_000_000);
            let bytes_raw = tracker.memory_pool.current_bytes();
        let global = make_global_pool(1_000_000);
            }
    fn test_context_returns_none_pool_for_zero_id() {
        let global = make_global_pool(10_000);
/// - On [`Drop`]: removes the tracker from the registry and logs final metrics.
        self.current_bytes.fetch_sub(shrink, Ordering::Relaxed);
        drop(first);
    fn register(&self, consumer: &MemoryConsumer) {
    let (tx, rx) = std::sync::mpsc::sync_channel(FLUSH_WORKER_COUNT);
    for entry in QUERY_REGISTRY.iter() {
        if nanos > 0 {
/// first tracker on the second insert, and `Drop` removed the key
                (Some(c), Some(r)) => (c, r),
}
}
        let written = snapshot_top_n_by_current(&mut buf);
                tracker: None,
            .and_then(|t| t.cpu_runtime_handle.get().cloned())
/// aligned for `WireQueryMetric` (8-byte aligned).
                    tracker: Arc::clone(tracker),
/// drops the JoinSet, releasing aborted task futures for collection). The flush
    }
    /// Create a new query context. If `context_id` is 0, tracking is
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
    }
    }
    fn test_query_pool_current_returns_to_zero_on_drop() {
            .collect();
        // race the runtime actually polling and dropping the aborted task. Poll
        QUERY_REGISTRY.remove(&done_id);
    }
/// scheduling opportunities to process deferred drops from the abort cascade.
        tracker.cancellation_token.cancel();
        Ok(())
            .unwrap()
    // Query lifecycle tests (simulating stream completion and error paths)
    // 0 is the "not cancelled" sentinel in cancelled_at_nanos. The FIRST deref
    if let Some(handle) = rt_handle {
    for _ in 0..FLUSH_WORKER_COUNT {
//!
/// The previous `DashMap<i64, Arc<QueryTracker>>` silently overwrote the
    // -----------------------------------------------------------------------
/// The value is a Vec because ONE context_id can have MULTIPLE live native
    /// buffers) after aborting the outer CrossRtStream task.
            tracker: Some(tracker),
/// process the pending drops (pull_from_input futures → GroupValues buffers).
        let global = make_global_pool(1_000_000);
/// Fire the cancellation token for the given context_id and abort the CPU task.
        assert!(!our.iter().any(|m| m.context_id == zero_id));
    }
        let mut buf = vec![sentinel; 16];
        }
        let query_pool = Arc::new(QueryMemoryPool::new(global_pool));
#[cfg(test)]
        // and final values are independent point-in-time samples.
                tracker.memory_pool.peak_bytes(),
                reservation.shrink(actual_shrink);
        let first = QUERY_REGISTRY
        assert!(global.reserved() >= 10000);
 */
        {
}
            QueryTrackingContext::new(coord_id, Arc::clone(&global), QueryType::Coordinator);
}
        r_lo.try_grow(1_000).unwrap();
        // Cancel
                tracker.context_id,
        assert_eq!(qp.current_bytes(), 8000);
/// Returns the currently configured cancellation stats threshold.
    #[test]
    (shard_count, coordinator_count)
        QUERY_REGISTRY.remove(&zero_id);
        let old = self.current_bytes.fetch_add(additional, Ordering::Relaxed);
            let _hold = sentinel; // captured in the future's state
    }
        {
        self.tracker.as_ref().map_or(0, |t| t.context_id)
    }
    }
    fn grow(&self, reservation: &MemoryReservation, additional: usize) {
/// streams: a query with a late-materialization stage opens two coordinator
/// Top-N snapshot: copy at most `out.len()` of the heaviest live queries
        let mut res_a = make_reservation(&(pool_a.clone() as Arc<dyn MemoryPool>), "query_a");
        assert!(!our.iter().any(|m| m.context_id == done_id));
    pub fn new(context_id: i64, global_pool: Arc<dyn MemoryPool>, query_type: QueryType) -> Self {
            peak_bytes: AtomicUsize::new(0),
    /// recently registered tracker for the id (which may be a sibling stream)
    pub fn current_bytes(&self) -> usize {
        // Append, don't insert: a second stream registering under the same
            .last()
static QUERY_REGISTRY: Lazy<DashMap<i64, Vec<Arc<QueryTracker>>>> = Lazy::new(DashMap::new);
}
        let tok_a = a.cancellation_token().unwrap();
            self.bytes.cmp(&other.bytes)
        let qp = Arc::new(QueryMemoryPool::new(global));
    fn test_memory_tracking_through_full_lifecycle() {
    if trackers.is_empty() {
    fn test_cancel_query_sets_cancelled_at() {
            set_cpu_runtime_handle(ctx_id, rt);
    struct HeapEntry {
        let pool_hi: Arc<dyn MemoryPool> = ctx_hi.memory_pool().unwrap();
//! on [`Drop`].
        assert_eq!(qp.peak_bytes(), 8000);
pub struct QueryTracker {
/// call pattern where a stream registers its context then immediately
}
        assert!(tracker.cancelled_at_nanos.load(Ordering::Relaxed) > 0);
        write!(
            if let Some(mut entry) = QUERY_REGISTRY.get_mut(&tracker.context_id) {
        }
            let cancelled_nanos = tracker.cancelled_at_nanos.load(Ordering::Acquire);
    let mut sample_logged = 0usize;
    }
 * this file be licensed under the Apache-2.0 license or a
    // -----------------------------------------------------------------------
}
/// Store the CPU runtime handle for the given context_id so that
        let global = make_global_pool(10_000);
        let tracker = Arc::clone(QUERY_REGISTRY.get(&ctx_id).unwrap().last().unwrap());
    pub fn new(inner: Arc<dyn MemoryPool>) -> Self {
/// registry size and `N = out.len()`. The heap holds the *top N candidates*
        drop(shard_ctx);
        let written = snapshot_top_n_by_current(&mut buf);
        res_a.try_grow(3000).unwrap();
        // At minimum, id_hi (the heaviest) must be in our slice if any of
            "sentinel must be dropped after flush — deferred drop was not processed"
    };
        if let Some(rt) = exec.handle() {
    }
            };
                    }
}
        let deadline = Instant::now() + Duration::from_secs(10);
    pub cancellation_token: CancellationToken,
            if sample_logged < 5 {
                        bytes,
            fn drop(&mut self) {
            !dropped.load(Ordering::Acquire),
        for id in &ids {
/// still-running sibling. `cancel_query` then found nothing, an in-flight
            phantom_reservation: None,
    // -----------------------------------------------------------------------
        let ids: Vec<i64> = (70_300..70_310).collect();
    // Flush-on-cancel tests
/// Yields per flush worker. The abort cascade has 3 scheduling levels:
}
    fn reserved(&self) -> usize {
        let ctx_id = 50_002;
        self.inner.register(consumer);
    fn test_context_registers_and_removes_on_drop() {
                phantom_reservation: None,
        let first = QueryTrackingContext::new(ctx_id, Arc::clone(&global), QueryType::Coordinator);
        let tracker = Arc::new(QueryTracker {
    wall_nanos: std::sync::atomic::AtomicU64,
    std::sync::atomic::AtomicU64::new(10_000);
        }
    /// The context_id for this query, or 0 if tracking is disabled.
    }
/// Per-query context that owns the memory pool and tracker.
    fn track_shrink(&self, shrink: usize) {
        self.track_grow(additional);
        assert!(our.iter().any(|m| m.context_id == live_id));
            .get(&ctx_id)
    /// Handle to the DedicatedExecutor's tokio runtime. Used by `cancel_query`
    let threshold_nanos = threshold.as_nanos() as u64;
        );
        drop(ctx_lo);
        // … the survivor MUST still be registered and cancellable.
        r_done.try_grow(8_192).unwrap();
impl Drop for QueryTrackingContext {
    // -----------------------------------------------------------------------
    // of PROCESS_START in a process creates the Instant and measures elapsed
    #[test]
// Query type discriminator
        let ctx_md = QueryTrackingContext::new(id_md, Arc::clone(&global), QueryType::Shard);
    pub fn is_completed(&self) -> bool {
                current_bytes: 0,
    fn test_cancel_query_idempotent() {
/// Set via `set_cancel_stats_threshold`.
/// sorted. Callers that need a sorted view sort the prefix client-side.
pub fn set_cpu_runtime_handle(context_id: i64, handle: tokio::runtime::Handle) {
    }
// QueryTrackingContext
    // sits at the root. That root is the weakest member of the current top-N
    /// but the registry is process-wide, so we only assert on contexts we own.
}
                        }
            current_bytes: usize_to_i64_saturating(tracker.memory_pool.current_bytes()),
}
        assert_eq!(qp.current_bytes(), 0);
    } else {
    }
        let dropped = Arc::new(AtomicBool::new(false));
                }
///
        let global = make_global_pool(10_000);
use datafusion::common::DataFusionError;
        drop(r_live);
            };
        bytes: i64,
        // Unique id: the QUERY_REGISTRY is process-wide and tests run in parallel, so this must not
    // shard lock.
        let mut reservation = make_reservation(&pool, "stream_data");
    }
    /// Helper: drain all live tracker contexts so each top-N test starts from
    #[test]
        // Completed before snapshot. Drop reservation first so QueryMemoryPool
        let sentinel = WireQueryMetric {
        assert_eq!(qp.current_bytes(), 5000);
    }
    let rt_handle = QUERY_REGISTRY.get(&context_id).and_then(|trackers| {
use once_cell::sync::Lazy;
        assert_eq!(qp.current_bytes(), 0);
            .iter()
        &self,
}
/// | context_id    | `QueryTracker::context_id`                                |
//! Each query gets its own [`QueryMemoryPool`] that wraps the global pool.
            "sentinel should be alive before cancel"
    QUERY_REGISTRY
    }
    fn mark_completed(&self) {
        vec![
    }
        let ctx_id = 60_001;
        drop(ctx);
    #[test]
        cancel_query(ctx_id);
        // CPU-starved CI box running 1000+ tests against a 2-worker runtime) can
        assert!(written <= 3, "must not exceed buffer capacity");
            thread::sleep(Duration::from_millis(5));
            return;
            context_id: tracker.context_id,
        // Verify not yet dropped
///
        let ctx_id = 50_010;
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
        impl Drop for DropSentinel {
        let mut r = make_reservation(&pool, "only");
}
        assert_eq!(QUERY_REGISTRY.get(&ctx_id).unwrap().len(), 2);
        }
/// snapshot API. Fields are `i64` so the struct crosses the FFM boundary with
pub fn snapshot_top_n_by_current(out: &mut [WireQueryMetric]) -> usize {
        drop(res_a);
        reservation.shrink(6000);
// Per-query tracker (metrics snapshot)
    /// Regression test for the ~5s late-materialization stall: an LM query
            "QueryMemoryPool(inner={}, current={}, peak={})",
            let shrink = (-delta) as usize;
        let pool: Arc<dyn MemoryPool> = qp.clone();
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
    Duration::from_millis(CANCEL_STATS_THRESHOLD_MS.load(Ordering::Relaxed))
use std::sync::{Arc, OnceLock};
        drop(ctx);
    pub cancelled_at_nanos: AtomicU64,
        assert!(!QUERY_REGISTRY.contains_key(&ctx_a_id));
        Some(entry) => entry.iter().map(Arc::clone).collect(),
        );
    impl PartialEq for HeapEntry {
        for tracker in entry.value() {
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
}
    /// disabled and `memory_pool()` returns `None`.
//! [`QueryTrackingContext`] owns the per-query pool and tracker, auto-registers
        let pool: Arc<dyn MemoryPool> = ctx.memory_pool().unwrap();
        use std::sync::atomic::AtomicBool;
        let t1 = QUERY_REGISTRY
        struct DropSentinel(Arc<AtomicBool>);
        native_bridge_common::log_debug!(
/// Process-wide epoch for cancelled_at timestamps. Using nanos since this
fn usize_to_i64_saturating(value: usize) -> i64 {
    /// not part of the comparison, so `QueryTracker` doesn't need `Ord`.
            .filter(|m| [live_id, zero_id, done_id].contains(&m.context_id))
    /// registers TWO reduce streams under the SAME context_id (stage-1 and
        reservation.try_grow(500).unwrap();
}
        let id_md = 70_001;
                    QueryType::Shard => shard_count += 1,
                tracker.wall_secs(),
            // If this query was cancelled and ran past the threshold, bump the total counter.
    fn test_count_cancelled_running_distinguishes_query_types() {
    // -----------------------------------------------------------------------
    // -----------------------------------------------------------------------
        // Cancel it
        let global = make_global_pool(1_000_000);
        assert!(!QUERY_REGISTRY.contains_key(&ctx_b_id));
        QUERY_REGISTRY.remove(&id_lo);
        QUERY_REGISTRY.remove(&id_md);
        let coord_ctx =
    #[test]
    /// Set atomically via CAS in cancel_query — no lock needed.
impl QueryTrackingContext {
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
    pub fn context_id(&self) -> i64 {
pub fn set_cancel_stats_threshold(millis: u64) {
/// Maximum time the flush will block waiting for the CPU runtime to process
/// Selection is done with a bounded min-heap of capacity `out.len()`, so a
        let live_id = 70_100;
    #[test]
    // -----------------------------------------------------------------------
        thread::sleep(Duration::from_millis(50));
        let zero_id = 70_101;
            cancellation_token: CancellationToken::new(),
        self.inner.grow(reservation, additional);
    }
// ---------------------------------------------------------------------------
    fn test_count_cancelled_running_with_zero_threshold() {
        assert_eq!(written, 0);
    /// CPU task abort handle, set after the stream is created.
        reservation.try_grow(200).unwrap();
pub fn count_cancelled_running(threshold: Duration) -> (i64, i64) {
            .and_then(|t| t.cpu_runtime_handle.get().cloned())
        let tracker = Arc::clone(QUERY_REGISTRY.get(&ctx_id).unwrap().last().unwrap());
        // Re-read the tracker fields here so the wire entry reflects the live
    phantom_reservation: Option<MemoryReservation>,
    /// Attach a phantom corrector and return an Arc clone for CrossRtStream.
    /// Nanos since PROCESS_START when cancellation was signalled, or 0 if not cancelled.
            let bytes = usize_to_i64_saturating(bytes_raw);
        let _zero_ctx = QueryTrackingContext::new(zero_id, Arc::clone(&global), QueryType::Shard);
        // Drop one, other keeps running
/// Each level needs at least one scheduling round per task. With
/// entries actually written.
            .unwrap()
/// Note: this does NOT flush the runtime — the abort cascade only completes
use datafusion::execution::memory_pool::{MemoryConsumer, MemoryPool, MemoryReservation};
                    }));
            wall_nanos: std::sync::atomic::AtomicU64::new(0),
    // -----------------------------------------------------------------------
        self.tracker.as_ref().map(|t| t.cancellation_token.clone())
/// attaches its handles.
        // Tail past `written` keeps the sentinel — proves the snapshot did not
        drop(r_done);
    }
    #[test]
        }
                let elapsed_since_cancel =
            .unwrap()
///   Level 3: SpawnedTask::drop aborts pull_from_input → drops GroupValues
                self.0.store(true, Ordering::Release);
}
        // collide with any other test's id (70_001 collides with test_top_n_picks_highest_current_bytes).
    #[test]
        assert!(ctx.memory_pool().is_some());
            completed: AtomicBool::new(false),
        while !dropped.load(Ordering::Acquire) && Instant::now() < deadline {
pub struct WireQueryMetric {
        drop(reservation);
    pub fn set_phantom_reservation(&mut self, reservation: MemoryReservation) {
        }
            }
        } else {
pub fn get_cancellation_token(context_id: i64) -> Option<CancellationToken> {
        let global = make_global_pool(1_000_000);
impl QueryMemoryPool {
        "cancel_query: cancelling context_id={context_id} ({} tracker(s))",
        assert!(QUERY_REGISTRY.contains_key(&ctx_id));
                phantom_corrector: None,
        Arc::new(GreedyMemoryPool::new(limit))
        cancel_query(ctx_id);
        drop(r);
    /// cancel_query on a shared id must cancel EVERY live tracker, not just one.
    use super::*;
            let _pool = ctx.memory_pool();
    fn from_tracker(tracker: &QueryTracker) -> Self {
    fn test_drop_removes_from_registry() {
/// Default threshold for "long-running post-cancel" — matches the Java-side
///            drop PerPartitionStream → Arc<SpawnedTask> refcount hits 0
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
                if now_empty {
            );
        written += 1;
        corrector: Arc<crate::phantom_corrector::PhantomCorrector>,
            .or_default()
        flush_cpu_runtime_with_handle(&handle, context_id);
/// Counts queries currently running past the cancellation threshold, by type.
        let mut buf = fresh_buf(2);
            query_type,
        // Pool still works (Arc kept alive by qp)
        for (i, id) in ids.iter().enumerate() {
        handle.spawn(async move {
/// Returns (shard_current, coordinator_current).
    }
            if actual_shrink > 0 {
            self.peak_bytes.load(Ordering::Relaxed)
            let actual_shrink = shrink.min(current.saturating_sub(floor));
        reservation.try_grow(3000).unwrap();
        let id_hi = 70_002;
        // Stream fully consumed — reservation and context dropped together
    pub fn apply_pending_phantom_correction(&mut self) {
        drop(ctx_hi);
        assert!(
            .get(&ctx_id)
                CANCEL_FLUSH_TIMEOUT.as_millis()
                    QueryType::Coordinator => coordinator_count += 1,
        // log the miss and the live ids so any recurrence is visible.
        if delta > 0 {
    }
        let ctx_id = 50_000;
            self.bytes == other.bytes
    /// stage-3 sinks both pass ctx.taskId()). The old `DashMap<i64, Arc<_>>`
        }
use std::time::{Duration, Instant};
            .load(Ordering::Relaxed);
        cancel_query(ctx_id);
// ---------------------------------------------------------------------------
        drop(reservation);
        self.current_bytes.load(Ordering::Relaxed)
    impl PartialOrd for HeapEntry {
            reservation.try_grow(5000).unwrap();
    pub fn peak_bytes(&self) -> usize {
}
                break;
        )
        cancel_query(shard_id);
    for entry in QUERY_REGISTRY.iter() {
            dropped.load(Ordering::Acquire),
                    heap.pop();
    for Reverse(entry) in heap.into_iter() {
            break;
/// should prefer its own token (see `QueryTrackingContext::cancellation_token`)
// ---------------------------------------------------------------------------
        let ctx = QueryTrackingContext::new(id, global, QueryType::Shard);
    /// to flush pending deferred drops (pull_from_input tasks holding GroupValues
        // returns once they finish, which under heavy parallel test load (a
pub struct QueryTrackingContext {
        if !our.is_empty() {
        self.wall_nanos.store(elapsed_nanos, Ordering::Release);
/// Targets the most recently registered tracker for the id — matching the
        // Pool stats still accessible via Arc
            // key blindly: sibling streams under the same context_id may still
        let pool: Arc<dyn MemoryPool> = qp.clone();
// ---------------------------------------------------------------------------
    }
    }
        let global = make_global_pool(10_000);
    fn test_top_n_caps_at_buffer_capacity() {
                continue;
            let current = reservation.size();
        }
        QUERY_REGISTRY.remove(&id_hi);
            let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
        let global = make_global_pool(10_000);
        .get(&context_id)
        assert!(QUERY_REGISTRY.contains_key(&ctx_id));
        let mut reservation = make_reservation(&pool, "test");
                tokio::task::yield_now().await;
        let global = make_global_pool(10_000);
    }
        builder.worker_threads(2).enable_all();
        let mut builder = tokio::runtime::Builder::new_multi_thread();
pub fn set_abort_handle(context_id: i64, handle: AbortHandle) {
            .cancelled_at_nanos
                        }
            .unwrap()
        });
/// `out` may be a raw slice pointing at a Java-owned buffer; it must be valid
    }
}
            .compare_exchange(0, nanos, Ordering::Release, Ordering::Relaxed)
/// processed and GroupValues buffers are freed.
        drop(ctx);
            current_bytes: AtomicUsize::new(0),
    pub abort_handle: OnceLock<AbortHandle>,
        } else {
        // context_id (LM queries have two reduce sinks) must not orphan the
        let qp = Arc::new(QueryMemoryPool::new(global));
///
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
    let trackers: Vec<Arc<QueryTracker>> = match QUERY_REGISTRY.get(&context_id) {
        assert_eq!(pool_a.current_bytes(), 3000);
    Coordinator,
    /// and returns `None` once the entry is gone — silently making the
        // Build a dedicated executor with its own tokio runtime.
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
        assert!(pool.reserved() >= 2000);
        let ctx_id = 50_043;
}
    // (Drop → get_mut on the same shard) and would deadlock under DashMap's
        let ctx_id = 50_042;
    ) -> Result<(), DataFusionError> {
    }
        if let Some(tracker) = trackers.last() {
            if completed {
/// - On creation: registers the tracker in the global registry.
                    heap.push(Reverse(HeapEntry {
        let mut reservation = make_reservation(&pool, "lifecycle_test");
/// completion status. Shared via `Arc` between the context and the registry.
        drop(ctx);
            drop(r);
        let elapsed_nanos = self.start_time.elapsed().as_nanos() as u64;
        let qp = ctx.memory_pool().unwrap();
        let mut reservations = Vec::with_capacity(ids.len());
        assert!(shard_tracker.cancelled_at_nanos.load(Ordering::Relaxed) > 0);
        assert!(QUERY_REGISTRY.contains_key(&ctx_b_id));
            .collect();
    pub fn wall_secs(&self) -> f64 {
        r_md.try_grow(5_000).unwrap();
        r_hi.try_grow(9_000).unwrap();
            assert!(!our.iter().any(|m| m.context_id == id_lo));
        tracker: Arc<QueryTracker>,
            .get(&ctx_id)
        // Simulates: query execution fails → context dropped without
// ---------------------------------------------------------------------------
        assert_eq!(pool_b.current_bytes(), 7000);
        let ctx_lo = QueryTrackingContext::new(id_lo, Arc::clone(&global), QueryType::Shard);
        additional: usize,
                    QUERY_REGISTRY.remove_if(&tracker.context_id, |_, v| v.is_empty());
        self.track_shrink(shrink);
        let ctx_a = QueryTrackingContext::new(ctx_a_id, Arc::clone(&global), QueryType::Shard);
        let sentinel = DropSentinel(Arc::clone(&dropped));
        value as i64
        drop(second);
/// No-op if no runtime handle is registered or the query is unknown.
    current_bytes: AtomicUsize,
        let tx = tx.clone();
        self.phantom_reservation = Some(reservation);
            "cancel_query: NO REGISTRY ENTRY for context_id={context_id} (no-op). live ids={live:?}"
        thread::sleep(Duration::from_millis(50));
    }
        // Store the runtime handle in the tracker (mirrors production path).
    fn try_grow(
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
            let ctx = QueryTrackingContext::new(*id, Arc::clone(&global), QueryType::Shard);
///
        // values at materialization time, consistent with from_tracker. Ranking
            if heap.len() < n {
        let ctx_id = 50_011;
        self.inner.name()
        let ctx_id = 60_002;
    #[test]
        self.peak_bytes
        let (abort_handle, _join_fut) = exec.spawn_with_abort_handle(async move {
        let global = make_global_pool(10_000_000);
    })
        res_b.try_grow(7000).unwrap();
            context_id,
        assert_eq!(qp.peak_bytes(), 1500);
pub const DEFAULT_CANCEL_THRESHOLD: Duration = Duration::from_secs(10);
    peak_bytes: AtomicUsize,
                        QueryType::Coordinator => {
 * The OpenSearch Contributors require contributions made to
        r.try_grow(2_048).unwrap();
            QUERY_REGISTRY.remove(id);
            // Remove ONLY this context's own tracker (ptr_eq), never the whole
/// in parallel rather than serialized through one worker's yields.
    let mut heap: BinaryHeap<Reverse<HeapEntry>> = BinaryHeap::with_capacity(n);
/// Wire representation of a single query's tracker, used by the top-N
/// [`flush_cpu_runtime`] after `stream_close` to ensure deferred drops are
                _ => return,
    }
        // Registered but never reserved — current_bytes stays 0.
            //
    pub current_bytes: i64,
        QUERY_REGISTRY.remove(&id);
    /// Attach a phantom reservation for bounded memory accounting.
                "Query completed ctx={}: wall={:.3}s, mem_current={}B, mem_peak={}B",
        }
    #[test]
        if let Some(tracker) = &self.tracker {
        trackers
            }
        let global = make_global_pool(1_000_000);
// ---------------------------------------------------------------------------
    use datafusion::execution::memory_pool::GreedyMemoryPool;
///
    let mut written = 0usize;
        trackers.len()
        let done_ctx = QueryTrackingContext::new(done_id, Arc::clone(&global), QueryType::Shard);
        // Small delay to let the task actually park at the pending().await
        assert!(QUERY_REGISTRY.get(&ctx_id).is_none());
    /// Coordinator-side local reduce execution (AnalyticsQueryTask on the Java side).
/// - completed trackers are skipped (a completed query's `current_bytes`
                    bytes,
        let id_lo = 70_000;
        reservation.try_grow(4000).unwrap();
        drop(res_b);
/// Sets the cancellation stats threshold (in milliseconds).
// ---------------------------------------------------------------------------
            set_abort_handle(ctx_id, h);
        assert_eq!(shard_tracker.query_type, QueryType::Shard);
/// Registry of live query trackers, keyed by context_id.
                }
/// spawns lightweight tasks that yield repeatedly, ensuring workers wake up and
    fn test_context_removes_on_error_drop() {
            let mut r = make_reservation(&pool, "cap");
        None => Vec::new(),
    // `token.cancel()` can wake tasks whose teardown re-enters the registry
            let _ = reservation.try_grow(delta as usize);
///
    native_bridge_common::log_debug!(
    }
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
    fn test_top_n_picks_highest_current_bytes() {
    #[test]
        self.inner.try_grow(reservation, additional)?;
pub struct QueryMemoryPool {
///
/// instant avoids storing full Instant values (which aren't atomically sized).
        let second = QueryTrackingContext::new(ctx_id, global, QueryType::Coordinator);
    /// Data-node shard fragment execution (AnalyticsShardTask on the Java side).
        drop(done_ctx);
            inner,
/// 32 yields per worker covers up to 32 partitions per level on a single worker.
//! usage independently.
    fn test_context_removes_on_normal_drop_with_stream() {
        let global = make_global_pool(10_000);
            // be live. Drop the key when the Vec empties.
    }
/// |---------------|-----------------------------------------------------------|
        }
            .last()
        // Not cancelled yet
pub fn cancel_query(context_id: i64) {
///   Level 1: CrossRtStream CPU task abort → drops CoalescePartitions receiver
        let ctx_id = 50_004;
            self.start_time.elapsed().as_secs_f64()
            }
// Registry snapshot — top-N FFM export
/// Runtime-configurable threshold. Initialized to DEFAULT_CANCEL_THRESHOLD (10_000 ms).
    /// and the surviving stream could never be interrupted.
    #[test]
        // Spawn a task that holds the sentinel and blocks forever at an await.
        assert!(survivor_token.is_cancelled());
        let a = QueryTrackingContext::new(ctx_id, Arc::clone(&global), QueryType::Coordinator);
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
        assert_eq!(qp.current_bytes(), 1000);
        let ctx_id = 80_001;
        });
    }
    written
                    PROCESS_START.elapsed().as_nanos() as u64 - cancelled_nanos;
/// over this registry lookup, which can go stale mid-stream.
        // A cancel for an id that was never registered (or already finished)
    #[test]
/// from the registry).
/// Number of flush tasks to spawn. Spawning across multiple workers ensures
        assert_eq!(qp.current_bytes(), 700);
impl MemoryPool for QueryMemoryPool {
        reservation.shrink(800);
        let ctx_b = QueryTrackingContext::new(ctx_b_id, Arc::clone(&global), QueryType::Shard);
        // Tracks whether the captured state inside the spawned future was dropped.
    CANCEL_STATS_THRESHOLD_MS.store(millis, Ordering::Relaxed);
    }
        // After drop, not in registry
    /// otherwise returns live elapsed time.
    let n = out.len();
///
    }
// ---------------------------------------------------------------------------
                heap.push(Reverse(HeapEntry {
static CANCEL_STATS_THRESHOLD_MS: std::sync::atomic::AtomicU64 =
#[derive(Debug)]
        // ours made it in.
        // Removed from registry after drop
        assert!(
        if let Some(h) = abort_handle {
            .wall_secs();
            .last()
