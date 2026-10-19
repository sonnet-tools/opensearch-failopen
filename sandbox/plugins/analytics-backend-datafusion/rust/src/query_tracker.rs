// ---------------------------------------------------------------------------
        cancel_query(shard_id);
        }
///
        let global = make_global_pool(10_000);
//! Each query gets its own [`QueryMemoryPool`] that wraps the global pool.
        assert!(tracker.cancelled_at_nanos.load(Ordering::Relaxed) == 0);
        );
            if cancelled_nanos > 0 {
    fn test_wall_secs_ticks_while_running() {
//! usage independently.
        drop(ctx);
        assert!(QUERY_REGISTRY.contains_key(&ctx_id));
    /// Helper: drain all live tracker contexts so each top-N test starts from
// Query type discriminator
        // drop removes from registry automatically
        let mut buf = fresh_buf(3);
        let ctx_a_id = 50_005;
            self.peak_bytes.load(Ordering::Relaxed)
        // Verify not yet dropped
                (Some(c), Some(r)) => (c, r),
        for r in reservations.drain(..) {
            } else if let Some(Reverse(min)) = heap.peek() {
            self.bytes.cmp(&other.bytes)
    // -----------------------------------------------------------------------
/// `stream_close` to grab the handle before the tracker is dropped (which
        let tracker = Arc::clone(QUERY_REGISTRY.get(&ctx_id).unwrap().last().unwrap());
    fn test_top_n_with_buffer_larger_than_live_set() {
pub fn cancel_stats_threshold() -> Duration {
        // touch it.
        let mut res_b = make_reservation(&(pool_b.clone() as Arc<dyn MemoryPool>), "query_b");
    }
    pub cpu_runtime_handle: OnceLock<tokio::runtime::Handle>,
    fn test_context_registers_and_removes_on_drop() {
    // on it immediately, which can legitimately be 0ns — clamp to 1 so a real
    })
    #[test]
                context_id,
    for _ in 0..FLUSH_WORKER_COUNT {
/// Flush variant that takes the runtime handle directly — used by `stream_close`
                    heap.pop();
            drop(r);
        self.peak_bytes.load(Ordering::Relaxed)
///
    pub fn set_phantom_reservation(&mut self, reservation: MemoryReservation) {
        } // ctx dropped here — removes from registry
}
            //
    pub fn is_completed(&self) -> bool {
        drop(tracker);
                    }
            }
/// `task_cancellation.duration_millis` default of 10 000 ms.
            fn drop(&mut self) {
        assert_eq!(qp.current_bytes(), 700);
            f,
        let ctx_id = 50_002;
        assert_eq!(coord_tracker.query_type, QueryType::Coordinator);
        )
            .last()
    // -----------------------------------------------------------------------
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
        assert_eq!(qp.peak_bytes(), 1500);
            warn!(
            match (&self.phantom_corrector, &mut self.phantom_reservation) {
                entry.retain(|t| !Arc::ptr_eq(t, tracker));
    for entry in QUERY_REGISTRY.iter() {
        // At minimum, id_hi (the heaviest) must be in our slice if any of
        let global = make_global_pool(10_000);
    let threshold_nanos = threshold.as_nanos() as u64;
        // Simulates: query succeeds → stream is consumed → handle dropped
        self.current_bytes.load(Ordering::Relaxed)
/// Top-N snapshot: copy at most `out.len()` of the heaviest live queries
        trackers
        let ctx_b_id = 50_006;
        let second = QueryTrackingContext::new(ctx_id, global, QueryType::Coordinator);
    /// if tracking is disabled.
/// in parallel rather than serialized through one worker's yields.
            contexts.push(ctx);
    written
        let first = QueryTrackingContext::new(ctx_id, Arc::clone(&global), QueryType::Coordinator);
/// seen so far; the smallest of those sits at the root, and any new entry
    #[test]
                if bytes > min.bytes {
        self.tracker.as_ref().map_or(0, |t| t.context_id)
            .cancelled_at_nanos
            .unwrap()
    #[test]
            inner,
    /// The per-query memory pool to install in a `RuntimeEnv`, or `None`
    impl PartialEq for HeapEntry {
        let mut buf: Vec<WireQueryMetric> = Vec::new();
    #[test]
/// Filters applied on the Rust side, in this order:
        let mut r_live = make_reservation(&live_pool, "live");
                        }
        cancel_query(ctx_id);
impl QueryMemoryPool {
    }
        // ours made it in.
    use datafusion::execution::memory_pool::GreedyMemoryPool;
    pub fn current_bytes(&self) -> usize {
}
    pub fn peak_bytes(&self) -> usize {
        let mut reservation = make_reservation(&pool, "lifecycle_test");
    phantom_corrector: Option<Arc<crate::phantom_corrector::PhantomCorrector>>,
            tracker.mark_completed();
    }
    /// and returns `None` once the entry is gone — silently making the
        if context_id == 0 {
        assert_eq!(pool_a.current_bytes(), 3000);
}
/// over this registry lookup, which can go stale mid-stream.
    struct HeapEntry {
        let tok_a = a.cancellation_token().unwrap();
        reservation.try_grow(3000).unwrap();
///
        let old = self.current_bytes.fetch_add(additional, Ordering::Relaxed);
        self.current_bytes.fetch_sub(shrink, Ordering::Relaxed);
// ---------------------------------------------------------------------------
        assert!(!QUERY_REGISTRY.contains_key(&ctx_a_id));
        thread::sleep(Duration::from_millis(50));
    #[test]
            .and_then(|t| t.cpu_runtime_handle.get().cloned())
            Some(self.cmp(other))
        tracker: Arc<QueryTracker>,
/// `reduceDone.await(5s)` latch expired on every LM query (~5s stall).
        // After flushing, the sentinel must have been dropped.
        written += 1;
                drop(entry);
        // Simulate allocations during stream consumption
            let shrink = (-delta) as usize;
    fn test_drop_removes_from_registry() {
        let pool: Arc<dyn MemoryPool> = qp.clone();
        let live_pool: Arc<dyn MemoryPool> = live_ctx.memory_pool().unwrap();
/// Clone a cancellation token for the given context_id, if registered.
/// single pass over the registry runs in `O(M log N)` where `M` is the
        let global = make_global_pool(1_000_000);
            .get(&ctx_id)
        drop(res_b);
        let mut buf = fresh_buf(2);
        assert_eq!(qp.peak_bytes(), 5000);
        QUERY_REGISTRY.remove(&done_id);
        }
    impl Eq for HeapEntry {}
                    match tracker.query_type {
            let _hold = sentinel; // captured in the future's state
    impl Ord for HeapEntry {
}
            query_type,
}
impl std::fmt::Display for QueryMemoryPool {
            }
    drop(tx);
        let pool: Arc<dyn MemoryPool> = qp.clone();
    for _ in 0..FLUSH_WORKER_COUNT {
            if bytes == 0 {
        Self {
            .load(Ordering::Relaxed);
        let qp = ctx.memory_pool().unwrap();
        res_b.try_grow(7000).unwrap();
        assert_eq!(QUERY_REGISTRY.get(&ctx_id).unwrap().len(), 2);
        i64::MAX
        });
    ) -> Result<(), DataFusionError> {
        self.inner.try_grow(reservation, additional)?;
    /// Attach a phantom reservation for bounded memory accounting.
    }
        assert_eq!(qp.current_bytes(), 1000);
            phantom_reservation: None,
#[derive(Debug)]
/// Order of entries written into `out` is unspecified — heap order, not
/// | Field         | Meaning                                                   |
        let shard_ctx = QueryTrackingContext::new(shard_id, Arc::clone(&global), QueryType::Shard);
    #[test]
        );
        let mut r_md = make_reservation(&pool_md, "md");
        &self,
    fn test_top_n_caps_at_buffer_capacity() {
            .compare_exchange(0, nanos, Ordering::Release, Ordering::Relaxed)
        // Verify each query is registered, cancelled, and has correct type
        tracker
        let tx = tx.clone();
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
            }
    // `token.cancel()` can wake tasks whose teardown re-enters the registry
                break;
        // Registered but never reserved — current_bytes stays 0.
    // shard lock.
    }
        let ctx_id = 50_000;
        drop(tracker);
    /// Apply pending phantom correction from the self-correcting budget.
                reservation.shrink(actual_shrink);
        let written = snapshot_top_n_by_current(&mut buf);
                continue;
mod tests {
                }
}
        let ctx_id = 50_004;
        // First stream closes (stage-1 drains to EOF and drops) …
            .or_default()
    }
            if let Some(mut entry) = QUERY_REGISTRY.get_mut(&tracker.context_id) {
    #[test]
    fn test_count_cancelled_running_with_zero_threshold() {
        assert!(pool.reserved() >= 2000);
        let global = make_global_pool(10_000);
        let global = make_global_pool(1_000_000);
            thread::sleep(Duration::from_millis(5));
    /// registers TWO reduce streams under the SAME context_id (stage-1 and
            current_bytes: AtomicUsize::new(0),
        }
            wall_nanos: std::sync::atomic::AtomicU64::new(0),
}
        }
        // Drop one, other keeps running
/// should prefer its own token (see `QueryTrackingContext::cancellation_token`)
        drop(ctx_b);
        }
use log::{debug, warn};
    }
// ---------------------------------------------------------------------------
        }
        assert_eq!(qp.current_bytes(), 900);
        assert_eq!(qp.current_bytes(), 2000);
    }
    /// The context_id for this query, or 0 if tracking is disabled.
                sample_logged += 1;
                self.0.store(true, Ordering::Release);
    }
/// `executeLocalPlan(..., ctx.taskId())` with the same query-level task id.
        // Pool stats still accessible via Arc
        // is settled, then drop the context to flip the completed flag.
/// which must extract the handle before dropping the tracker (drop removes it
            !dropped.load(Ordering::Acquire),
    }
    }
        let ctx_hi = QueryTrackingContext::new(id_hi, Arc::clone(&global), QueryType::Shard);
pub fn cancel_query(context_id: i64) {
    fn test_context_removes_on_error_drop() {
    }
    // -----------------------------------------------------------------------
        let global = make_global_pool(1_000_000);
///
        }
                tracker.context_id,
use std::time::{Duration, Instant};
/// spawns lightweight tasks that yield repeatedly, ensuring workers wake up and
        };
// ---------------------------------------------------------------------------
        if !our.is_empty() {
    }
    }
            }
            .unwrap()
        cancel_query(ctx_id);
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
        let delta = corrector.take_pending_delta();
/// after the `QueryStreamHandle` is dropped (via `stream_close`). Call
        assert_eq!(qp.current_bytes(), 0);
            }
        drop(ctx_a);
        let ids: Vec<i64> = (70_300..70_310).collect();
    // QueryMemoryPool tests
/// Returns the currently configured cancellation stats threshold.
                tracker: None,
    /// to flush pending deferred drops (pull_from_input tasks holding GroupValues
pub fn get_cancellation_token(context_id: i64) -> Option<CancellationToken> {
    /// Attach a phantom corrector and return an Arc clone for CrossRtStream.
        for ctx in contexts.drain(..) {
// Per-query memory pool
    }
            assert_eq!(qp.peak_bytes(), 5000);
        let ctx = QueryTrackingContext::new(0, global, QueryType::Shard);
    for tracker in trackers {
        drop(second);
        assert!(
        let shard_tracker = Arc::clone(QUERY_REGISTRY.get(&shard_id).unwrap().last().unwrap());
                }
        let pool: Arc<dyn MemoryPool> = qp.clone();
            self.inner.name(),
                        }
            tracker.abort_handle.set(handle).ok();
                continue;
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
                        QueryType::Shard => {
    QUERY_REGISTRY.get(&context_id).and_then(|trackers| {
        let pool_hi: Arc<dyn MemoryPool> = ctx_hi.memory_pool().unwrap();
            // query is never simultaneously visible in both the registry scan
    let mut coordinator_count: i64 = 0;
            "QueryMemoryPool(inner={}, current={}, peak={})",
        if let Some(tracker) = trackers.last() {
        let mut reservation = make_reservation(&pool, "stream_data");
        self.inner.unregister(consumer);
            drop(ctx);
            .iter()
    phantom_reservation: Option<MemoryReservation>,
 */
                tracker.memory_pool.current_bytes(),
    // -----------------------------------------------------------------------
    pub context_id: i64,
        let ctx_id = 50_011;
// Global registry
pub struct QueryTrackingContext {
    /// cancel_query on a shared id must cancel EVERY live tracker, not just one.
        // Not cancelled yet
        Ok(())
/// registry size and `N = out.len()`. The heap holds the *top N candidates*
    // -----------------------------------------------------------------------
        let shard_id = 60_005;
    // BinaryHeap is a max-heap; Reverse flips it so the smallest current_bytes
        drop(ctx);
/// Registry of live query trackers, keyed by context_id.
        assert_eq!(qp.peak_bytes(), 1500);
        // Tail past `written` keeps the sentinel — proves the snapshot did not
        {
        if rx.recv_timeout(CANCEL_FLUSH_TIMEOUT).is_err() {
    }
        let qp = Arc::new(QueryMemoryPool::new(global));
///   are not "heavy" candidates)
/// Flush the CPU runtime for the given context_id, giving tokio workers
        });
                CANCEL_FLUSH_TIMEOUT.as_millis()
        let deadline = Instant::now() + Duration::from_secs(10);
        drop(r_hi);
                // Strictly greater: equal-byte ties keep the first-seen entry.
        assert!(survivor_token.is_cancelled());
}
            let mut reservation = make_reservation(&pool, "test");
        // Small delay to let the task actually park at the pending().await
        let sentinel = DropSentinel(Arc::clone(&dropped));
        drop(ctx_lo);
        if let Some(h) = abort_handle {
    }
            if cancelled_nanos > 0 && (now_nanos - cancelled_nanos) >= threshold_nanos {
        drop(r_done);
        flush_cpu_runtime_with_handle(&handle, context_id);
    }
pub struct QueryMemoryPool {
        } else {
            };
        }
/// Targets the most recently registered tracker for the id — matching the
            debug!(
/// completion status. Shared via `Arc` between the context and the registry.
    pub fn wall_secs(&self) -> f64 {
    /// Set atomically via CAS in cancel_query — no lock needed.
    }
    }
        let pool_a = ctx_a.memory_pool().unwrap();
    for Reverse(entry) in heap.into_iter() {
        Self {
    /// disabled. Prefer this over `get_cancellation_token(context_id)` when a
    fn test_cancel_query_flushes_deferred_drops() {
    /// Heap entry — orders purely by `bytes`. The tracker rides along but is
        cancel_query(ctx_id);
    fn track_shrink(&self, shrink: usize) {
    let rt_handle = QUERY_REGISTRY.get(&context_id).and_then(|trackers| {
            if sample_logged < 5 {
            if dropped.load(Ordering::Acquire) {
        Self {
impl QueryTracker {
    pub fn cancellation_token(&self) -> Option<CancellationToken> {
///
/// Call this AFTER `stream_close` has dropped the `QueryStreamHandle` (which
        // a genuine regression (flush never processes the drop) still fails.
        reservation.try_grow(200).unwrap();
// ---------------------------------------------------------------------------
            }
            .filter(|m| (id_lo..=id_hi).contains(&m.context_id))
            reservations.push(r);
    peak_bytes: AtomicUsize,
    fn test_count_cancelled_running_distinguishes_query_types() {
// ---------------------------------------------------------------------------
            tracker.cpu_runtime_handle.set(handle).ok();
        assert!(shard_tracker.cancelled_at_nanos.load(Ordering::Relaxed) > 0);
        let qp = ctx.memory_pool().unwrap();
        out[written] = WireQueryMetric::from_tracker(&entry.tracker);
            phantom_corrector: None,
        // explicit cleanup (the error path in executeQueryPhaseAsync)
        assert!(!QUERY_REGISTRY.contains_key(&ctx_b_id));
    let trackers: Vec<Arc<QueryTracker>> = match QUERY_REGISTRY.get(&context_id) {
impl WireQueryMetric {
        drop(ctx);
    fn fresh_buf(n: usize) -> Vec<WireQueryMetric> {
    pub fn set_phantom_corrector(
            peak_bytes: AtomicUsize::new(0),
            .and_then(|t| t.cpu_runtime_handle.get().cloned())
/// scheduling opportunities to process deferred drops from the abort cascade.
/// sorted. Callers that need a sorted view sort the prefix client-side.
        let first = QUERY_REGISTRY
    }
            set_abort_handle(ctx_id, h);
            // If this query was cancelled and ran past the threshold, bump the total counter.
            let _ = tx.send(());
pub fn take_cpu_runtime_handle(context_id: i64) -> Option<tokio::runtime::Handle> {
        }
            if actual_shrink > 0 {
const _: () = assert!(std::mem::size_of::<WireQueryMetric>() == 2 * 8);
        handle.spawn(async move {
        let global = make_global_pool(10_000);
    #[test]
    Shard,
    }
        MemoryConsumer::new(name).register(pool)
            if completed {
        assert!(QUERY_REGISTRY.contains_key(&ctx_b_id));
        for (i, id) in ids.iter().enumerate() {
impl MemoryPool for QueryMemoryPool {
        QUERY_REGISTRY.remove(&id_lo);
        r.try_grow(2_048).unwrap();
        let nanos = self.wall_nanos.load(Ordering::Acquire);
            let bytes = usize_to_i64_saturating(bytes_raw);
        fn cmp(&self, other: &Self) -> Ordering {
            cancellation_token: CancellationToken::new(),
        // log the miss and the live ids so any recurrence is visible.
// ---------------------------------------------------------------------------
    let (tx, rx) = std::sync::mpsc::sync_channel(FLUSH_WORKER_COUNT);
        let _ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
        let pool: Arc<dyn MemoryPool> = ctx.memory_pool().unwrap();
        assert_eq!(written, 0);
            self.start_time.elapsed().as_secs_f64()
            cancelled_at_nanos: AtomicU64::new(0),
        self.peak_bytes
        let t2 = QUERY_REGISTRY
#[derive(Debug, Clone, Copy)]
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
    }
            dropped.load(Ordering::Acquire),
    #[test]
        }
/// For `context_id == 0` (unset), no tracking is performed.
    #[test]
    #[test]
    }
        reservation.try_grow(4000).unwrap();
    }
            "cancel_query: NO REGISTRY ENTRY for context_id={context_id} (no-op). live ids={live:?}"
    }
        // flush is best-effort: it spawns a fixed number of yield tasks and
        assert_eq!(pool_b.current_bytes(), 7000);
    CANCEL_STATS_THRESHOLD_MS.store(millis, Ordering::Relaxed);
        cancel_query(ctx_id);
    /// otherwise returns live elapsed time.
        fn eq(&self, other: &Self) -> bool {
        // collide with any other test's id (70_001 collides with test_top_n_picks_highest_current_bytes).
        drop(coord_tracker);
        // Now cancelled_at_nanos should be > 0
            .unwrap()
        let ctx_id = 50_010;
        self.inner.reserved()
pub fn set_abort_handle(context_id: i64, handle: AbortHandle) {
            .get(&ctx_id)
use std::sync::atomic::{AtomicBool, AtomicU64, AtomicUsize, Ordering};
        let global = make_global_pool(10_000);
/// attaches its handles.
        let live: Vec<i64> = QUERY_REGISTRY.iter().map(|e| *e.key()).collect();
            .get(&ctx_id)
        value as i64
        let a = QueryTrackingContext::new(ctx_id, Arc::clone(&global), QueryType::Coordinator);
        assert_eq!(qp.current_bytes(), 5000);
    }
                    }));
///
        // Store the runtime handle in the tracker (mirrors production path).
    fn test_cancel_query_sets_cancelled_at() {
}
        for tracker in entry.value() {
        let ctx_lo = QueryTrackingContext::new(id_lo, Arc::clone(&global), QueryType::Shard);
        drop(ctx);
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
    tracker: Option<Arc<QueryTracker>>,
///
    completed: AtomicBool,
    // Top-N snapshot tests
/// a stable, alignment-safe layout (8-byte aligned on every target we support).
// Registry snapshot — top-N FFM export
        assert!(tok_b.is_cancelled());
        if let Some(rt) = exec.handle() {
        QUERY_REGISTRY.remove(&live_id);
pub struct QueryTracker {
}
    }
    // Snapshot the trackers under the entry lock, then cancel outside it —
    });
        let coord_ctx =
        let done_ctx = QueryTrackingContext::new(done_id, Arc::clone(&global), QueryType::Shard);
        let id = 70_200;
        let mut reservations = Vec::with_capacity(ids.len());
        assert!(global.reserved() >= 10000);
/// - `current_bytes == 0` is skipped (registered but un-allocated trackers
    // sits at the root. That root is the weakest member of the current top-N
        let done_id = 70_102;
    #[test]
        assert_eq!(qp.peak_bytes(), 1500);
        drop(live_ctx);
        // Append, don't insert: a second stream registering under the same
            .unwrap()
        assert!(QUERY_REGISTRY.contains_key(&ctx_id));
        // Removed from registry after drop
///   Level 1: CrossRtStream CPU task abort → drops CoalescePartitions receiver
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
    std::sync::atomic::AtomicU64::new(10_000);
        let ctx_id = 50_043;
    pub fn context_id(&self) -> i64 {
        let mut contexts = Vec::with_capacity(ids.len());
        let b = QueryTrackingContext::new(ctx_id, global, QueryType::Coordinator);
#[derive(Debug)]
        assert!(tracker.cancelled_at_nanos.load(Ordering::Relaxed) > 0);
                if elapsed_since_cancel >= cancel_stats_threshold().as_nanos() as u64 {
    if n == 0 {
use datafusion::execution::memory_pool::{MemoryConsumer, MemoryPool, MemoryReservation};
        thread::sleep(Duration::from_millis(50));
        self.completed.load(Ordering::Acquire)
        let coord_tracker = Arc::clone(QUERY_REGISTRY.get(&coord_id).unwrap().last().unwrap());
/// The previous `DashMap<i64, Arc<QueryTracker>>` silently overwrote the
    if value > i64::MAX as usize {
}
/// Default threshold for "long-running post-cancel" — matches the Java-side
        cancel_query(ctx_id);
        assert!(ctx.memory_pool().is_some());
        let (abort_handle, _join_fut) = exec.spawn_with_abort_handle(async move {
    fn test_query_pool_current_returns_to_zero_on_drop() {
        assert_eq!(QUERY_REGISTRY.get(&ctx_id).unwrap().len(), 1);
                if now_empty {
    }
            .unwrap()
    if let Some(trackers) = QUERY_REGISTRY.get(&context_id) {
            return;
            .fetch_max(old + additional, Ordering::Relaxed);
            );
    /// and the surviving stream could never be interrupted.
        &mut self,
    }
        let mut buf = fresh_buf(8);
    // -----------------------------------------------------------------------
    }
    if let Some(handle) = rt_handle {
        if delta > 0 {
        write!(
        assert_eq!(qp.current_bytes(), 0);
        );
    }
                    tracker: Arc::clone(tracker),
            let current = reservation.size();
    fn test_query_pool_delegates_reserved_to_inner() {
        }
        drop(reservation);
        let live_id = 70_100;
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
            }
///   Level 2: CoalescePartitions' run_input tasks see closed channel → exit →
        drop(ctx_md);
            current_bytes: -1,
        assert!(tok_a.is_cancelled());
        self.inner.register(consumer);
///   drops to zero on `Drop` anyway, so this is mostly a fast path)
}
/// Counts queries currently running past the cancellation threshold, by type.
        assert_eq!(qp.peak_bytes(), 4000);
            .last()
                context_id: 0,
        drop(shard_ctx);
        res_a.try_grow(3000).unwrap();
                            crate::native_node_stats::inc_native_search_shard_task_total();
    }
    fn unregister(&self, consumer: &MemoryConsumer) {
            .get(&ctx_id)
    pub abort_handle: OnceLock<AbortHandle>,
            let bytes_raw = tracker.memory_pool.current_bytes();
    }
        let live_ctx = QueryTrackingContext::new(live_id, Arc::clone(&global), QueryType::Shard);
    }
    let mut written = 0usize;
            assert!(our.iter().any(|m| m.context_id == id_hi));
        drop(tracker);
            // key blindly: sibling streams under the same context_id may still
        let done_pool: Arc<dyn MemoryPool> = done_ctx.memory_pool().unwrap();
        let id_md = 70_001;
            flush_cpu_runtime(ctx_id);
                            crate::native_node_stats::inc_native_search_task_total();
        // returns once they finish, which under heavy parallel test load (a
        for slot in &buf[written..] {
//! All allocations flow through the global pool (so the global limit is
    // Query lifecycle tests (simulating stream completion and error paths)
            let ctx = QueryTrackingContext::new(*id, Arc::clone(&global), QueryType::Shard);
        assert_eq!(qp.peak_bytes(), 8000);
/// `stream_next` could not be interrupted, and the reduce sink's
                                  // Block forever — only abort can end this.
                    QueryType::Coordinator => coordinator_count += 1,
            }
        let second = QUERY_REGISTRY
            let actual_shrink = shrink.min(current.saturating_sub(floor));
///
        let exec = crate::executor::DedicatedExecutor::new("test-flush", builder, 2);
        .get(&context_id)
        assert!(our.iter().any(|m| m.context_id == live_id));
    Coordinator,
    fn test_top_n_zero_capacity_returns_zero() {
            .unwrap()
        assert!(!our.iter().any(|m| m.context_id == done_id));
pub fn set_cancel_stats_threshold(millis: u64) {
        reservation.try_grow(500).unwrap();
        drop(first);
        }
        // Pool still works (Arc kept alive by qp)
            .unwrap()
    use super::*;
const FLUSH_YIELDS_PER_WORKER: usize = 32;
    fn test_context_returns_none_pool_for_zero_id() {
    }
        clone
        reservation.try_grow(1000).unwrap();
        let global = make_global_pool(10_000);
}
    QUERY_REGISTRY
    /// Data-node shard fragment execution (AnalyticsShardTask on the Java side).
        if let Some(handle) = tracker.abort_handle.get() {
/// Returns (shard_current, coordinator_current).
        }
            if heap.len() < n {
 * SPDX-License-Identifier: Apache-2.0
    fn test_top_n_picks_highest_current_bytes() {
    fn test_multiple_concurrent_queries() {
    pub memory_pool: Arc<QueryMemoryPool>,
//!
        let pool_md: Arc<dyn MemoryPool> = ctx_md.memory_pool().unwrap();
/// reduce sinks (stage 1 and stage 3), and both call
        let ctx_id = 50_042;
        assert_eq!(qp.peak_bytes(), 5000);
        assert!(
        self.completed.store(true, Ordering::Release);
    impl PartialOrd for HeapEntry {
            handle.abort();
    fn grow(&self, reservation: &MemoryReservation, additional: usize) {
        let our: Vec<&WireQueryMetric> = buf[..written]
        assert_eq!(shard_tracker.query_type, QueryType::Shard);
        assert!(coord_tracker.cancelled_at_nanos.load(Ordering::Relaxed) > 0);
            break;
        assert!(ctx.memory_pool().is_none());
        self.wall_nanos.store(elapsed_nanos, Ordering::Release);
            }
/// (ranked by `current_bytes` descending) into `out`. Returns the number of
/// Lock-free: reads each entry's `cancelled_at_nanos` atomically.
        self.phantom_corrector = Some(corrector);
/// Fire the cancellation token for the given context_id and abort the CPU task.
/// instant avoids storing full Instant values (which aren't atomically sized).
            let _pool = ctx.memory_pool();
        drop(shard_tracker);
            memory_pool: query_pool,
        let our: Vec<&WireQueryMetric> = buf[..written]
    // -----------------------------------------------------------------------
    let mut shard_count: i64 = 0;
}
        // CPU-starved CI box running 1000+ tests against a 2-worker runtime) can
        // Both trackers visible under the shared id.
            completed: AtomicBool::new(false),
        let global = make_global_pool(1_000_000);
static QUERY_REGISTRY: Lazy<DashMap<i64, Vec<Arc<QueryTracker>>>> = Lazy::new(DashMap::new);
/// Yields per flush worker. The abort cascade has 3 scheduling levels:
#[derive(Debug)]
                tokio::task::yield_now().await;
        }
        impl Drop for DropSentinel {
    #[test]
        drop(r);
/// the woken tasks (which may land on different workers' queues) are processed
    fn test_top_n_skips_completed_and_zero_byte_trackers() {
                    QUERY_REGISTRY.remove_if(&tracker.context_id, |_, v| v.is_empty());
        assert!(written < buf.len());
            // (current) and the total counter — preventing double-counting in
            .collect();
    (shard_count, coordinator_count)
pub enum QueryType {
    }
}
const CANCEL_FLUSH_TIMEOUT: Duration = Duration::from_millis(500);
        assert!(!survivor_token.is_cancelled());
    /// Coordinator-side local reduce execution (AnalyticsQueryTask on the Java side).
    fn mark_completed(&self) {
        // Entry is gone after drop
/// independently tracking this query's current and peak memory usage.
    pub query_type: QueryType,
    }
            n
    #[test]
//! still enforced), but each query also tracks its own current and peak
        self.inner.grow(reservation, additional);
        drop(done_ctx);
        // Cancel it
        let global = make_global_pool(1_000_000);
        let mut r_done = make_reservation(&done_pool, "done");
        while !dropped.load(Ordering::Acquire) && Instant::now() < deadline {
        for tracker in entry.value() {
/// Sets the cancellation stats threshold (in milliseconds).
        assert_eq!(qp.current_bytes(), 0);
/// Number of flush tasks to spawn. Spawning across multiple workers ensures
pub fn flush_cpu_runtime(context_id: i64) {
    #[test]
        return 0;
    }
            }
        // Second cancel should not overwrite the first timestamp
        }
        let mut res_a = make_reservation(&(pool_a.clone() as Arc<dyn MemoryPool>), "query_a");
    // -----------------------------------------------------------------------
        drop(ctx);
        // does nothing. Silent no-ops here hid a real bug (the ~5s LM stall):
//! [`QueryTrackingContext`] owns the per-query pool and tracker, auto-registers
            current_bytes: usize_to_i64_saturating(tracker.memory_pool.current_bytes()),
/// still-running sibling. `cancel_query` then found nothing, an in-flight
        let mut builder = tokio::runtime::Builder::new_multi_thread();
        let global = make_global_pool(10_000);
    }
        let tracker = Arc::new(QueryTracker {
        let _zero_ctx = QueryTrackingContext::new(zero_id, Arc::clone(&global), QueryType::Shard);
    // -----------------------------------------------------------------------
        // first stream's tracker.
    pub fn new(context_id: i64, global_pool: Arc<dyn MemoryPool>, query_type: QueryType) -> Self {
        r_hi.try_grow(9_000).unwrap();
        let (corrector, reservation) =
        }
    /// Nanos since PROCESS_START when cancellation was signalled, or 0 if not cancelled.
                "Query completed ctx={}: wall={:.3}s, mem_current={}B, mem_peak={}B",
        // values at materialization time, consistent with from_tracker. Ranking
}
}
        assert!(tracker.cancelled_at_nanos.load(Ordering::Relaxed) > 0);
        assert_eq!(qp.peak_bytes(), 8000);
        let written = snapshot_top_n_by_current(&mut buf);
    }
/// No-op for unknown or already-completed queries.
    use std::cmp::{Ordering, Reverse};
                }));
/// aligned for `WireQueryMetric` (8-byte aligned).
/// Store the CPU runtime handle for the given context_id so that
    #[test]
        let tracker = Arc::clone(QUERY_REGISTRY.get(&ctx_id).unwrap().last().unwrap());
                heap.push(Reverse(HeapEntry {
    /// caller's await uncancellable.
//! Per-query memory tracking via DataFusion's MemoryPool trait.
                let now_empty = entry.is_empty();
        assert_eq!(qp.current_bytes(), 8000);
        let ctx_a = QueryTrackingContext::new(ctx_a_id, Arc::clone(&global), QueryType::Shard);
        // flush_cpu_runtime gives the runtime scheduling opportunities to
/// The value is a Vec because ONE context_id can have MULTIPLE live native
                match tracker.query_type {
        // The abort is async — the task future may not be dropped yet.
    }
    // 0 is the "not cancelled" sentinel in cancelled_at_nanos. The FIRST deref
    /// Regression test for the ~5s late-materialization stall: an LM query
    }
            .wall_secs();
            );
            WireQueryMetric {
    fn register(&self, consumer: &MemoryConsumer) {
            cpu_runtime_handle: OnceLock::new(),
        if delta == 0 {
        let ctx = QueryTrackingContext::new(id, global, QueryType::Shard);
use once_cell::sync::Lazy;
    }
/// first tracker on the second insert, and `Drop` removed the key
    if let Some(trackers) = QUERY_REGISTRY.get(&context_id) {
/// Maximum time the flush will block waiting for the CPU runtime to process
        drop(reservation);
    /// registry overwrote the first tracker at insert and removed the whole
        trackers.len()
        assert_eq!(tracker.cancelled_at_nanos.load(Ordering::Relaxed), 0);
        }
/// Holds per-query metrics: memory pool reference, wall-clock timing, and
    fn test_cancel_query_cancels_all_siblings() {
        let dropped = Arc::new(AtomicBool::new(false));
    pub context_id: i64,
pub fn flush_cpu_runtime_with_handle(handle: &tokio::runtime::Handle, context_id: i64) {
        // Not cancelled — cancelled_at_nanos should be 0
    fn track_grow(&self, additional: usize) {
        cancel_query(coord_id);
            r.try_grow((i as usize + 1) * 1_000).unwrap();
    use std::time::{Duration, Instant};
        cancel_query(ctx_id);
    pub fn apply_pending_phantom_correction(&mut self) {
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
            .wall_secs();
/// deferred drops (pull_from_input tasks holding GroupValues buffers).
        // After drop, not in registry
            "sentinel should be alive before cancel"
            .filter(|m| [live_id, zero_id, done_id].contains(&m.context_id))
            let _ = reservation.try_grow(delta as usize);
fn usize_to_i64_saturating(value: usize) -> i64 {
// ---------------------------------------------------------------------------
            self.current_bytes.load(Ordering::Relaxed),
    /// not part of the comparison, so `QueryTracker` doesn't need `Ord`.
        thread::sleep(Duration::from_millis(10));
    // Flush-on-cancel tests
        }
        let id_hi = 70_002;
            set_cpu_runtime_handle(ctx_id, rt);
        let pool: Arc<dyn MemoryPool> = qp.clone();
        }
#[cfg(test)]
    /// Wall-clock duration. Returns the frozen snapshot if completed,
        {
            abort_handle: OnceLock::new(),
        let query_pool = Arc::new(QueryMemoryPool::new(global_pool));
        let clone = Arc::clone(&corrector);
        }
    }
            assert!(QUERY_REGISTRY.contains_key(&ctx_id));
                let elapsed_since_cancel =
/// `out` may be a raw slice pointing at a Java-owned buffer; it must be valid
        return;
        vec![
        let qp = Arc::new(QueryMemoryPool::new(global));
            .last()
        drop(r_live);
    }
}
            .last()
        assert!(written <= 3, "must not exceed buffer capacity");
        drop(ctx);
pub fn snapshot_top_n_by_current(out: &mut [WireQueryMetric]) -> usize {
    }
/// for writes of `out.len() * size_of::<WireQueryMetric>()` bytes and properly
                    PROCESS_START.elapsed().as_nanos() as u64 - cancelled_nanos;
        // Completed before snapshot. Drop reservation first so QueryMemoryPool
    fn test_context_removes_on_normal_drop_with_stream() {
    fn from_tracker(tracker: &QueryTracker) -> Self {
    fn shrink(&self, reservation: &MemoryReservation, shrink: usize) {
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
        r_md.try_grow(5_000).unwrap();
    }
            let floor = current / 10;
///
    /// a clean registry. Tests in this module are tagged with unique id ranges
        builder.worker_threads(2).enable_all();
        ]
/// Wire representation of a single query's tracker, used by the top-N
        drop(r_lo);
                "flush_cpu_runtime({}): timed out after {}ms",
    }
        let qp = Arc::new(QueryMemoryPool::new(global));
    // set — the one a heavier candidate displaces.
        r_live.try_grow(4_096).unwrap();
/// Runtime-configurable threshold. Initialized to DEFAULT_CANCEL_THRESHOLD (10_000 ms).
                }
        let global = make_global_pool(1_000_000);
                current_bytes: 0,
            .cancelled_at_nanos
            return Self {
}
}
    native_bridge_common::log_debug!(
        let written = snapshot_top_n_by_current(&mut buf);
            futures::future::pending::<()>().await;
                phantom_corrector: None,
/// A per-query MemoryPool that delegates to a shared global pool while
            // be live. Drop the key when the Vec empties.
        }
            .last()
        assert_eq!(qp.current_bytes(), 1500);
        // Top-2 must contain ids hi and md but not lo. Other parallel tests
            QueryTrackingContext::new(coord_id, Arc::clone(&global), QueryType::Coordinator);
                    heap.push(Reverse(HeapEntry {
            // snapshot_cancellation_stats.
            QUERY_REGISTRY.remove(id);
    use std::collections::BinaryHeap;
    #[test]
    }
    fn drop(&mut self) {
        // … the survivor MUST still be registered and cancellable.
/// streams: a query with a late-materialization stage opens two coordinator
        // Removed from registry
        drop(res_a);
            context_id: -1,
/// - completed trackers are skipped (a completed query's `current_bytes`
        let zero_id = 70_101;
        let coord_id = 60_006;
    Duration::from_millis(CANCEL_STATS_THRESHOLD_MS.load(Ordering::Relaxed))
    fn test_query_pool_tracks_current_and_peak() {
    ) -> Arc<crate::phantom_corrector::PhantomCorrector> {
/// No-op if no runtime handle is registered or the query is unknown.
    /// This context's OWN cancellation token, or `None` if tracking is
/// registered tracker's token — callers that own a `QueryTrackingContext`
        let global = make_global_pool(10_000);
        // race the runtime actually polling and dropping the aborted task. Poll
            let completed = tracker.is_completed();
        if let Some(tracker) = &self.tracker {
            assert_eq!(slot.context_id, -1);
    fn test_memory_tracking_through_full_lifecycle() {
    // of PROCESS_START in a process creates the Instant and measures elapsed
/// `cancel_query` can flush deferred drops on that runtime.
 *
    use std::thread;
    /// but the registry is process-wide, so we only assert on contexts we own.
        self.tracker.as_ref().map(|t| t.cancellation_token.clone())
/// With multiple streams under one id this returns the MOST RECENTLY
        self.phantom_reservation = Some(reservation);
    }
        struct DropSentinel(Arc<AtomicBool>);
    /// Snapshot wall time and mark completed.
        // cancelled_at should be set
        QUERY_REGISTRY.remove(&id_md);
    /// stage-3 sinks both pass ctx.taskId()). The old `DashMap<i64, Arc<_>>`
            };
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
        r_done.try_grow(8_192).unwrap();
impl Drop for QueryTrackingContext {
        Arc::new(GreedyMemoryPool::new(limit))
}
            .load(Ordering::Relaxed);
        // the flush until the deferred drop is observed, bounded by a timeout so
        let ctx_id = 60_002;
            start_time: Instant::now(),
    pub cancellation_token: CancellationToken,
    /// CPU task abort handle, set after the stream is created.
        drop(b);
// Per-query tracker (metrics snapshot)
        assert!(QUERY_REGISTRY.contains_key(&ctx_id));
        }
        }
        }
        let global = make_global_pool(10_000);
        let ctx_id = 50_001;
        let global = make_global_pool(10_000);
    }
        exec.join_blocking();
use dashmap::DashMap;
/// drops the JoinSet, releasing aborted task futures for collection). The flush
    current_bytes: AtomicUsize,
    // -----------------------------------------------------------------------
        let id_lo = 70_000;
    pub cancelled_at_nanos: AtomicU64,
        r_lo.try_grow(1_000).unwrap();
 * The OpenSearch Contributors require contributions made to
        QUERY_REGISTRY.remove(&zero_id);
    /// disabled and `memory_pool()` returns `None`.
/*
            for _ in 0..FLUSH_YIELDS_PER_WORKER {
    let n = out.len();
        // Unique id: the QUERY_REGISTRY is process-wide and tests run in parallel, so this must not
    }
        reservation.shrink(6000);
        } else {
        QUERY_REGISTRY
            .iter()
}
    fn test_cancel_query_idempotent() {
                        QueryType::Coordinator => {
/// process the pending drops (pull_from_input futures → GroupValues buffers).
        reservation.try_grow(5000).unwrap();
/// snapshot API. Fields are `i64` so the struct crosses the FFM boundary with
    fn make_reservation(pool: &Arc<dyn MemoryPool>, name: &str) -> MemoryReservation {
    }
    } else {
    for entry in QUERY_REGISTRY.iter() {
    /// Handle to the DedicatedExecutor's tokio runtime. Used by `cancel_query`
    // -----------------------------------------------------------------------
                phantom_reservation: None,
///
            };
        self.inner.name()
        // Spawn a task that holds the sentinel and blocks forever at an await.
        });
    }
            .cancelled_at_nanos
/// unconditionally — so the first stream to close deleted the entry for its
        let ctx_id = 60_003;
        let mut r_lo = make_reservation(&pool_lo, "lo");
static PROCESS_START: Lazy<Instant> = Lazy::new(Instant::now);
        tracker.cancellation_token.cancel();
            nanos as f64 / 1_000_000_000.0
    };
        // and final values are independent point-in-time samples.
        assert_eq!(qp.peak_bytes(), 1000);
    wall_nanos: std::sync::atomic::AtomicU64,
        reservation: &MemoryReservation,
    // cancellation is never mistaken for "not cancelled".
        self.track_shrink(shrink);
static CANCEL_STATS_THRESHOLD_MS: std::sync::atomic::AtomicU64 =
        corrector: Arc<crate::phantom_corrector::PhantomCorrector>,
    }
    let mut heap: BinaryHeap<Reverse<HeapEntry>> = BinaryHeap::with_capacity(n);
/// processed and GroupValues buffers are freed.
    // QueryTrackingContext lifecycle tests
        QUERY_REGISTRY.remove(&id);
/// Extract the CPU runtime handle from the tracker, removing it. Used by
        let mut buf = vec![sentinel; 16];
        assert_eq!(qp.peak_bytes(), 4000);
const FLUSH_WORKER_COUNT: usize = 4;
                        tracker: Arc::clone(tracker),
            assert_eq!(qp.current_bytes(), 5000);
    /// key at first Drop — so `cancel_query` on the shared id found nothing
                tracker.wall_secs(),
        drop(_ctx);
        }
    // (Drop → get_mut on the same shard) and would deadlock under DashMap's
    }
///
        let written = snapshot_top_n_by_current(&mut buf);
/// Store the CPU task's AbortHandle for the given context_id.
        trackers
//! on [`Drop`].
    if trackers.is_empty() {
    let now_nanos = PROCESS_START.elapsed().as_nanos() as u64;
    #[test]
    }
        self.track_grow(additional);
        let ctx_id = 80_001;
///
        let pool: Arc<dyn MemoryPool> = qp.clone();
        self.tracker.as_ref().map(|t| Arc::clone(&t.memory_pool))
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
    let nanos = (PROCESS_START.elapsed().as_nanos() as u64).max(1);
        let survivor_token = second.cancellation_token().unwrap();
        let global = make_global_pool(10_000_000);
            let pool: Arc<dyn MemoryPool> = ctx.memory_pool().unwrap();
        drop(ctx);
    #[test]
///
        assert!(QUERY_REGISTRY.get(&ctx_id).is_none());
        for id in &ids {
// ---------------------------------------------------------------------------
/// Process-wide epoch for cancelled_at timestamps. Using nanos since this
                _ => return,
        drop(ctx);
    #[test]
    );
        // cancel_query aborts the task (marks it cancelled in the runtime)
        QUERY_REGISTRY.remove(&id_hi);
        // Stream fully consumed — reservation and context dropped together
// ---------------------------------------------------------------------------
    }
        let pool_b = ctx_b.memory_pool().unwrap();
/// Per-query context that owns the memory pool and tracker.
            .entry(context_id)
        // Tracks whether the captured state inside the spawned future was dropped.
        .and_then(|trackers| trackers.last().map(|t| t.cancellation_token.clone()))
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
            }
    fn name(&self) -> &str {
//!
/// removes it from the registry).
//! in the global [`QueryRegistry`] on creation, and removes the entry
pub const DEFAULT_CANCEL_THRESHOLD: Duration = Duration::from_secs(10);
    }
        }
// QueryTrackingContext
/// - On [`Drop`]: removes the tracker from the registry and logs final metrics.
    pub current_bytes: i64,
/// entries actually written.
            .unwrap()
        let global = make_global_pool(1_000_000);
        let mut reservation = make_reservation(&pool, "test");
        Some(entry) => entry.iter().map(Arc::clone).collect(),
    }
    /// Create a new query context. If `context_id` is 0, tracking is
    fn reserved(&self) -> usize {
/// Note: this does NOT flush the runtime — the abort cascade only completes
        }
    #[test]
        drop(ctx);
            let mut r = make_reservation(&pool, "cap");
        reservation.shrink(800);
/// from the registry).
            let cancelled_nanos = tracker.cancelled_at_nanos.load(Ordering::Acquire);
}
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
        let tok_b = b.cancellation_token().unwrap();
        cancel_query(ctx_id);
    fn make_global_pool(limit: usize) -> Arc<dyn MemoryPool> {
    }
        // Build a dedicated executor with its own tokio runtime.
            context_id: tracker.context_id,
        fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
    }
        let global = make_global_pool(1_000_000);
        reservation.try_grow(2000).unwrap();
    let mut sample_logged = 0usize;
use tokio_util::sync::CancellationToken;
        let ctx_b = QueryTrackingContext::new(ctx_b_id, Arc::clone(&global), QueryType::Shard);
        None => Vec::new(),
    pub fn memory_pool(&self) -> Option<Arc<QueryMemoryPool>> {
 * compatible open source license.
///            drop PerPartitionStream → Arc<SpawnedTask> refcount hits 0
/// Set via `set_cancel_stats_threshold`.
/// call pattern where a stream registers its context then immediately
 * this file be licensed under the Apache-2.0 license or a
    /// `QueryTrackingContext` is at hand: the registry lookup targets the most
            .last()
    fn test_sibling_stream_drop_does_not_orphan_survivor() {
        let t1 = QUERY_REGISTRY
            context_id,
    #[test]
    // -----------------------------------------------------------------------
pub struct WireQueryMetric {
        let elapsed_nanos = self.start_time.elapsed().as_nanos() as u64;
pub fn count_cancelled_running(threshold: Duration) -> (i64, i64) {
        assert!(t2 - t1 >= 0.04);
        let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
            self.bytes == other.bytes
    }
        let sentinel = WireQueryMetric {
        }
        // process the abort and drop the future (freeing the sentinel). A single
        let mut reservation = make_reservation(&pool, "test");
/// |---------------|-----------------------------------------------------------|
                    bytes,
        // Simulates: query execution fails → context dropped without
        bytes: i64,
use tokio::task::AbortHandle;
            .ok();
    #[test]
    }
                    QueryType::Shard => shard_count += 1,
            tracker: Some(tracker),
// ---------------------------------------------------------------------------
/// heavier than that root replaces it.
impl QueryTrackingContext {
        // Cancel
        drop(ctx_hi);
        let global = make_global_pool(10_000);
        let ctx_md = QueryTrackingContext::new(id_md, Arc::clone(&global), QueryType::Shard);
        let global = make_global_pool(10_000_000);
    /// buffers) after aborting the outer CrossRtStream task.
        // A cancel for an id that was never registered (or already finished)
        drop(coord_ctx);
///
    pub start_time: Instant,
    inner: Arc<dyn MemoryPool>,
        // Re-read the tracker fields here so the wire entry reflects the live
                        bytes,
            .collect();
        self.inner.shrink(reservation, shrink);
/// | context_id    | `QueryTracker::context_id`                                |
        assert_eq!(first, second);
        let global = make_global_pool(1_000_000);
        let written = snapshot_top_n_by_current(&mut buf);
        drop(a);
/// Selection is done with a bounded min-heap of capacity `out.len()`, so a
/// - On creation: registers the tracker in the global registry.
        additional: usize,
            .push(Arc::clone(&tracker));
            // Remove from registry BEFORE incrementing total. This ensures a
        // context_id (LM queries have two reduce sinks) must not orphan the
// ---------------------------------------------------------------------------
/// Distinguishes shard-level queries from coordinator-level queries for stats.
/// Each level needs at least one scheduling round per task. With
        if let Some(tracker) = trackers.last() {
use std::sync::{Arc, OnceLock};
        let tracker = Arc::clone(QUERY_REGISTRY.get(&ctx_id).unwrap().last().unwrap());
        drop(r_md);
///   Level 3: SpawnedTask::drop aborts pull_from_input → drops GroupValues
    pub fn new(inner: Arc<dyn MemoryPool>) -> Self {
}
        assert!(written >= 1);
        assert_eq!(qp.peak_bytes(), 8000);
    // Cancellation stats tests
        native_bridge_common::log_debug!(
}
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
        let mut r = make_reservation(&pool, "only");
        if nanos > 0 {
    }
        let ctx_id = 60_001;
            // Remove ONLY this context's own tracker (ptr_eq), never the whole
        assert!(written >= 1 && written <= 2);
        "cancel_query: cancelling context_id={context_id} ({} tracker(s))",
        let mut r_hi = make_reservation(&pool_hi, "hi");
/// | current_bytes | `QueryMemoryPool::current_bytes`, clamped to `i64::MAX`   |
        thread::sleep(Duration::from_millis(10));
        assert!(!QUERY_REGISTRY.contains_key(&ctx_id));
                tracker.memory_pool.peak_bytes(),
            assert!(!our.iter().any(|m| m.context_id == id_lo));
        // Drop context — removes from registry
    }
/// target_partitions = N, levels 2 and 3 each have N tasks.
        // may push entries into the registry, so we filter to our id range.
    fn try_grow(
        assert!(!our.iter().any(|m| m.context_id == zero_id));
        use std::sync::atomic::AtomicBool;
                }
/// [`flush_cpu_runtime`] after `stream_close` to ensure deferred drops are
            let ctx = QueryTrackingContext::new(ctx_id, global, QueryType::Shard);
            let cancelled_nanos = tracker.cancelled_at_nanos.load(Ordering::Acquire);
pub fn set_cpu_runtime_handle(context_id: i64, handle: tokio::runtime::Handle) {
    /// recently registered tracker for the id (which may be a sibling stream)
        self.track_grow(additional);
            "sentinel must be dropped after flush — deferred drop was not processed"
use datafusion::common::DataFusionError;
            reservation.try_grow(5000).unwrap();
        let pool_lo: Arc<dyn MemoryPool> = ctx_lo.memory_pool().unwrap();
#[repr(C)]
/// 32 yields per worker covers up to 32 partitions per level on a single worker.
