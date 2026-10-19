        assert_eq!(gate.semaphore.available_permits(), 6);
        });
    async fn test_resize_scale_up_after_scale_down() {
                tx_shutdown.send(()).ok();
use std::sync::Arc;
                Semaphore::MAX_PERMITS
        self.max_permits.load(Ordering::Acquire)
            // Scale-Up: release poison permits first, then add_permits for remaining delta
    async fn test_panic_propagates() {
        assert_eq!(gate.pending_acquire_batches(), 1);
    /// Property 5: Concurrent acquire/resize safety
            b.wait().await;
                    prop_assert!(
    /// We generate multiplier as an integer in [1, 100] divided by 10.0 to get
        Option<AbortHandle>,
            prop_assert_eq!(computed, expected,
    handle: Option<Handle>,
        assert_eq!(gate.max_permits(), 4);
                     equal one of the resize_targets ({:?})",
                    let gate_clone = Arc::clone(&gate);
    }
        permit
            .spawn(async { std::thread::current().id() })
        self.pending_acquire_permits
    }
                     (initial_max={}, num_acquires={}, resize_targets={:?})",
    task::{AbortHandle, JoinSet},
        let exec = test_exec(1);
                    state.poison_permits.pop();
                    initial_max, num_acquires, resize_targets
                );
    proptest! {
    /// then resize up to 6. Verify poison permits released and max_permits == 6.
    /// For any random sequence of resize targets [T1, T2, ..., Tn] (length 2..20,
                    let t = *target;
use std::sync::atomic::{AtomicU32, AtomicU64, Ordering};
            return;
        let gate = ConcurrencyGate::new(8);
    },
    ///
    /// Acquire N permits (partition-weighted). Held for the entire query stream lifetime.
                            s.clone()
    }
        let mut builder = tokio::runtime::Builder::new_multi_thread();
    /// of acquire_many_owned poison permits on scale-up-after-scale-down).
use futures::{future::BoxFuture, Future, FutureExt, TryFutureExt};
                    });
    /// can be used to cancel the CPU task from outside (e.g. from `cancel_query`).
                        .acquire_owned()
        self.acquire_many(1).await
                }
        let t1 = exec.spawn({
            self.handle = None;
    ///
                .await
            self.completed_shutdown.clone().now_or_never();
        });
    /// CrossRtStream driver future and held for the query's entire lifetime.
    async fn test_resize_noop() {
        let gate_clone = Arc::clone(&gate);
                    join_handles.push(handle);
    /// Since no queries are active in this test, available permits SHALL be
        // Releases 2 poison permits (pops 2 entries), leaving 2 poison held.
                    gate.max_permits(), target,
    /// Returns the number of poison permits currently held.
        assert_eq!(gate.max_permits(), 4);
impl ConcurrencyGate {
    ///
        let gate = ConcurrencyGate::new(4);
        #![proptest_config(ProptestConfig::with_cases(100))]
        match self.resize_mutex.try_lock() {
                        JobError::Panic { msg: s }
            // Java's (int) cast truncates toward zero, equivalent to Rust's `as i32`.
                    gate.semaphore.available_permits(), target
        // Spawn a task that will block on acquire
        self.total_wait_ms.fetch_add(elapsed_ms, Ordering::Relaxed);
        if let Some(handle) = thread_handle {
                // Concurrently spawn resize tasks for each target in the sequence
                    join_handles.push(resize_handle);
    }
        assert_eq!(t1.await.unwrap(), 11);
                    Duration::from_secs(5),
            if still_needed > 0 {
        let handle = {
                    resize_targets.contains(&final_max),
            .await
                    let handle = tokio::spawn(async move {
    ///
        fn prop_permit_computation_correctness(
    /// Like [`spawn`](Self::spawn), but also returns an [`AbortHandle`] that
    /// and a sequence of resize targets (1..5), then spawns multiple tokio tasks
            prop_assert!(computed >= 1,
                let last_target = *targets.last().unwrap();
                );
/// until the stream is fully consumed or dropped.
        task: T,
                    gate.resize(*target, "prop_test").await;
        #[test]
                }
    ///
            }
    }
        assert_eq!(gate.max_permits(), 4);
    where
        max_concurrent_queries: usize,
        self.max_permits
            Err(JobError::Panic { msg }) => assert!(msg.contains("boom")),
 */
    /// On scale-down: we acquire permits and store them here.
    /// executor has not been shut down. Used to create a
                "[{}] resize rejected: new_max {} out of bounds [1, {}]",
    #[tokio::test]
                b.wait();
    /// For any valid ConcurrencyGate with initial max permits `initial_max`
            let b = barrier.clone();
                        .await
        let exec = test_exec(2);
    }
            let permits_from_poison = poison_count.min(new_max - current_max);
    ///
        gate.resize(4, "test").await;
            // proptest does not natively support async; create a runtime per iteration.
                    gate.max_permits(), last_target,
    /// This mirrors the Java-side computation:
            semaphore: Arc::new(Semaphore::new(permits)),
        T::Output: Send + 'static,
        let mut state = self.state.write();
                for target in &targets {
    semaphore: Arc<Semaphore>,
        let caller_id = std::thread::current().id();
    /// For any interleaving of acquire() calls from query tasks and concurrent
impl DedicatedExecutor {
                // must equal one of the resize targets (whichever executed last).
        assert_eq!(gate.semaphore.available_permits(), 6);
    async fn test_pending_acquire_permits_counter() {
    /// completes, the effective max permits SHALL equal `target`.
            } else {
            rt.block_on(async {
            let multiplier: f64 = multiplier_int as f64 / 10.0;
    thread: Option<std::thread::JoinHandle<()>>,
        assert_eq!(poison_permits_held(&gate).await, 4); // 4 individual permits
    }
    ///
        let result = exec.spawn(async { panic!("boom") }).await;
pub struct DedicatedExecutor {
                let result = tokio::time::timeout(
        let gate = ConcurrencyGate::new(8);
    }
                        // Hold the permit briefly to create contention
impl std::fmt::Debug for DedicatedExecutor {
 *
            let existing_poison = state.poison_permits.len() as u32;
            let still_needed = (new_max - current_max) - permits_from_poison;
    where
            total_queries_admitted: AtomicU64::new(0),
                    });
        oneshot::error::RecvError, Mutex as AsyncMutex, Notify, OwnedSemaphorePermit, Semaphore,
                // Verify initial state
        #[test]
pub enum JobError {
        ) {
 * this file be licensed under the Apache-2.0 license or a
            }
                info!(
    }
            resize_targets in proptest::collection::vec(1u32..=64u32, 1..=5),
    #[tokio::test]
    completed_shutdown: futures::future::Shared<BoxFuture<'static, Result<(), Arc<RecvError>>>>,
            42
                // Need to acquire additional poison permits (one at a time for precise release)
        assert_eq!(result, 42);
                    let gate_for_resize = Arc::clone(&gate);
        write!(f, "DedicatedExecutor")
        assert_eq!(poison_permits_held(&gate).await, 0);
        &self.concurrency_gate
            for _ in 0..permits_from_poison {
#[derive(Debug)]
        let task = exec.spawn(async move {
            rt.block_on(async {
            thread.join().ok();
            // Scale-Down: acquire poison permits to reduce effective capacity
    /// - Scale-up: releases poison permits first, then adds new permits.
const SHUTDOWN_TIMEOUT: Duration = Duration::from_secs(60 * 5);
    /// This test generates random gate sizes, numbers of concurrent acquires,
            self.start_shutdown.notify_one();
        #[test]
        let gate = ConcurrencyGate::new(4);
    /// For any valid cpu_threads (in [1, 128]) and multiplier (in [0.1, 10.0]),
            warn!(
    }
                    let shutdown = notify_shutdown_captured.notified();
        if let Some(thread) = self.thread.take() {
        self.pending_acquire_batches.fetch_sub(1, Ordering::Relaxed);
    }
    WorkerGone,
    async fn test_multi_task() {
        let elapsed_ms = start.elapsed().as_millis() as u64;
        }
                );
                let mut join_handles = Vec::new();
        let barrier = Arc::new(Barrier::new(3));
        };
        gate.resize(0, "test").await;
        tokio::task::yield_now().await;
    /// Property 1: Resize reaches target capacity
                );
                // Spawn `num_acquires` tasks that each acquire a permit,
                    "[{}] resize complete: {} → {} (scale-down, released {} excess poison)",
            let rt = tokio::runtime::Runtime::new().unwrap();
                        return;
    pub fn total_wait_ms(&self) -> u64 {
    use std::sync::{Arc, Barrier};
                        let s = if let Some(s) = e.downcast_ref::<String>() {
            thread: Some(thread),
    ) -> (
                    "[{}] resize complete: {} → {} (scale-down, acquired {} poison permits)",
            // Convert integer to f64 multiplier in [0.1, 10.0]
                        .expect("semaphore closed during resize");
    /// Each poison permit is acquired individually (one Vec entry = one permit),
}
        let state = State {
    /// Validates: Requirements 3.1, 3.2
                // After all resizes, max_permits must equal the last target
                self.max_permits.store(new_max, Ordering::Release);
            state.handle.clone()
};
    /// Verify pending_acquire_permits increments during contention and returns to 0 after.
        fn prop_resize_reaches_target_capacity(
                        task_result.is_ok(),
}
                    );
 * SPDX-License-Identifier: Apache-2.0
    pub fn target_max_permits(&self) -> u32 {
        assert_eq!(gate.semaphore.available_permits(), 4);
                for (i, task_result) in results.iter().enumerate() {
                    all_tasks,
                    let mut shutdown = std::pin::pin!(shutdown);
    /// - Serialized via the async resize mutex (only one resize at a time).
        let result = exec.spawn(async { 1 }).await;
        exec.join_blocking();
            Ok(state) => state.target_max_permits,
        if new_max < 1 || new_max > Semaphore::MAX_PERMITS as u32 {
    /// Boundary rejection: resize to 0 should be rejected.
    /// so scale-up releases exactly the needed count without overshoot.
            self.max_permits.store(new_max, Ordering::Release);
        exec.join_blocking();
    }
                        .semaphore
    pub fn active_permits(&self) -> u32 {
            let rt = tokio::runtime::Runtime::new().unwrap();
    /// Acquire a permit. Held for the entire query stream lifetime.
            max_permits: AtomicU32::new(permits as u32),
        name: &str,
        // Attempt resize to 0 — should be rejected (below minimum of 1)
    /// Scale-up from 4 → 8: verify max_permits == 8 and 8 permits available.
            // toward zero is equivalent to floor. Both formulas must agree.
        assert_eq!(t2.await.unwrap(), 22);
    pending_acquire_batches: AtomicU64,
        assert_eq!(poison_permits_held(&gate).await, 2);
                    gate_name, old_max, new_max, excess
    #[tokio::test]
        let result = exec.spawn(async { 42 }).await.unwrap();
        });
    async fn test_resize_scale_up() {
                let gate = ConcurrencyGate::new(64);
                "[{}] resize complete: {} → {} (scale-up, released {} poison, added {} new)",
                Ok(())
        let (tx_handle, rx_handle) = std::sync::mpsc::channel();
            .spawn(move || {
        };
    /// at least `target` (may exceed target due to the bulk-release behavior
        .boxed();
    }
        self.total_wait_ms.load(Ordering::Relaxed)
    /// Validates: Requirements 3.7
                let final_max = gate.max_permits();
                prop_assert_eq!(
/// The permit is acquired inside the spawned stream-driver future and held
        let permit = gate.acquire().await;
        match self.resize_mutex.try_lock() {
    /// Returns the number of tasks currently waiting to acquire the semaphore.
        };
        }
        barrier.wait();
                b.wait();
}
        // Drop the task without awaiting — it should be cancelled
        let abort_handle = join_set.spawn_on(task, &handle);
            return; // No-op
                "Mismatch: computed={}, expected={} for cpu_threads={}, multiplier={}",
        #![proptest_config(ProptestConfig::with_cases(100))]
            // Property 2: Result matches the floor-based formula
        let start = Instant::now();
            Err(_) => 0, // Resize in progress, report 0
        assert_eq!(gate.max_permits(), 4);
                    "After resize({}) from initial_max={}, max_permits should equal target",
// Based on InfluxDB's executor pattern.
        assert_eq!(poison_permits_held(&gate).await, 0);
    /// ensuring the result is always at least 1.
    pub fn total_queries_admitted(&self) -> u64 {
            })
                         resize_targets={:?}): {:?}",
                                                         // Available permits should be 4: original 8 minus 4 acquired as poison
                    gate.semaphore.available_permits() >= target as usize,
                        i, initial_max, num_acquires, resize_targets, task_result
                        };
    /// On scale-up: we drop permits from here first, then add_permits for the delta.
        // Yield to let the spawned task start waiting
                        gate_for_resize.resize(t, "prop_test").await;
                for target in &resize_targets_clone {
                // Secondary assertion: since no queries are active, available permits
    #[tokio::test]
        let handle = rx_handle.recv().expect("driver started");
    /// Returns a clone of the underlying Tokio runtime `Handle`, if the
                }
        if new_max == current_max {
        let (tx_shutdown, rx_shutdown) = tokio::sync::oneshot::channel();
                "Permit count must be >= 1, got {} for cpu_threads={}, multiplier={}",
                prop_assert_eq!(
        self.pending_acquire_batches.fetch_add(1, Ordering::Relaxed);
        } else {
    /// Resize the concurrency gate to a new maximum permit count.
            let total_poison_needed = current_max - new_max;
        assert!(matches!(result, Err(JobError::WorkerGone)));
        assert_eq!(gate.semaphore.available_permits(), 4);
                let results = result.unwrap();
            rt.block_on(async {
            .expect("executor setup");
        #[test]
    ///
        exec.join_blocking();
    /// - Scale-down: acquires poison permits to reduce effective capacity.
        let cloned = exec.clone();
}
    ///
    target_max_permits: u32,
                });
    pub fn concurrency_gate(&self) -> &Arc<ConcurrencyGate> {
        }
                self.semaphore.add_permits(still_needed as usize);
    /// No-op resize (same value): verify no state change.
    /// the computed newMaxPermits SHALL equal max(1, floor(cpu_threads × multiplier)),
        let exec = test_exec(1);
    async fn poison_permits_held(gate: &ConcurrencyGate) -> u32 {
            async move {
            .fetch_sub(n as u64, Ordering::Relaxed);
            );
    pub fn pending_acquire_batches(&self) -> u64 {
        let thread_handle = {
}
    pub fn max_permits(&self) -> u32 {
                for _ in 0..additional_needed {
use parking_lot::RwLock;
                // Assert: gate is in a valid state after all tasks complete.
        runtime_builder: tokio::runtime::Builder,
        self.pending_acquire_permits.load(Ordering::Relaxed)
    /// Non-blocking: returns 0 if a resize is in progress.
    }
        assert_eq!(gate.pending_acquire_permits(), 1);
        assert_eq!(gate.max_permits(), 4);
    async fn test_clone_shares_runtime() {
        T: Future + Send + 'static,
    total_wait_ms: AtomicU64,
        let spawned_id = exec
#[derive(Clone)]
        state.handle.clone()
            Ok(state) => state.poison_permits.len() as u32,
                        let permit = gate_clone.acquire().await;
    }
    use proptest::prelude::*;
        let exec = test_exec(1);
        &self,
                let excess = existing_poison - total_poison_needed;
    /// Scale-down from 8 → 4 with no active queries: verify max_permits == 4,
        }
    concurrency_gate: Arc<ConcurrencyGate>,
                    result.is_ok(),
    }
        let permit = result.expect("concurrency gate semaphore closed");
        exec.join_blocking();
        assert_eq!(gate.max_permits(), 6);
            }
    pub fn shutdown(&self) {
            info!(
                // Since resize operations are spawned concurrently, the tokio
        let gate = Arc::new(ConcurrencyGate::new(1));
    // ─── Property-based tests ────────────────────────────────────────────
                new_max,
        assert_eq!(gate.semaphore.available_permits(), 6);
                    "Deadlock detected: tasks did not complete within 5s timeout \
    }
            multiplier_int in 1u32..=100,
                self.max_permits.store(new_max, Ordering::Release);
        gate.resize(6, "test").await;
        assert_eq!(gate.semaphore.available_permits(), 4);
        let old_max = current_max;
    }
        let fut = async move {
            pending_acquire_permits: AtomicU64::new(0),
    }
                    }
    Panic { msg: String },
        assert_eq!(gate.semaphore.available_permits(), 8);
    /// **Validates: Requirements 2.5**
    start_shutdown: Arc<Notify>,
                target_max_permits: permits as u32,
    total_queries_admitted: AtomicU64,
                        } else {
            .saturating_sub(self.semaphore.available_permits() as u32)
        assert_eq!(gate.max_permits(), 6);
            );
    #[tokio::test]
                // hold it briefly (yield_now), then drop it.
    /// **Validates: Requirements 3.1, 3.2, 3.4**
                poison_permits: Vec::new(),
                    target, initial_max,
        assert_eq!(result, 99);
                // scheduler determines execution order. The final max_permits
                Ok(())
    }
        let name = name.to_owned();
        gate.resize(0, "test").await;
            let state = self.state.read();
                // Primary assertion: max_permits reflects the target
                    "After resize({}) from initial_max={} with no active queries, \
        state.start_shutdown.notify_one();
        gate.resize(4, "test").await;
pub struct ConcurrencyGate {
    pending_acquire_permits: AtomicU64,
struct ResizeState {
                let gate = Arc::new(ConcurrencyGate::new(initial_max as usize));
                     the last target {}",
            let _ = handle.join();
            targets in proptest::collection::vec(1u32..=128u32, 2..20),
            async move {
            let rt = tokio::runtime::Runtime::new().unwrap();
        state.poison_permits.len() as u32
                state.poison_permits.pop();
    /// Validates: Requirements 3.2, 3.7
        assert_eq!(gate.semaphore.available_permits(), 4);
        fn prop_concurrent_acquire_resize_safety(
            start_shutdown: notify_shutdown,
                prop_assert!(
use std::time::{Duration, Instant};
        fn prop_last_writer_wins_convergence(
    }
            let expected = std::cmp::max(1, (cpu_threads as f64 * multiplier).floor() as i32);
        if self.handle.is_some() {
        assert_eq!(gate.semaphore.available_permits(), 4);
        self.total_queries_admitted.load(Ordering::Relaxed)
    runtime::Handle,
    {
    /// Validates: Requirements 3.1, 3.2
                .expect("just spawned task")
                        .clone()
                prop_assert_eq!(gate.max_permits(), initial_max);
                let runtime = runtime_builder.build().expect("Creating tokio runtime");
        let result = cloned.spawn(async { 99 }).await.unwrap();
            state.target_max_permits = new_max;
        drop(permit);
        }
                let resize_targets_clone = resize_targets.clone();
    /// Property 7: Permit computation correctness
/// Holds poison permits (used to reduce effective capacity) and the
        let handle = tokio::spawn(async move { gate_clone.acquire().await });
        // Acquire the single permit so subsequent acquires will block
                runtime.block_on(async move {
            total_wait_ms: AtomicU64::new(0),
        exec.join_blocking();
            num_acquires in 1usize..=16usize,
    }
    /// 4 poison permits held, and 4 available permits.
                            s.to_string()
    async fn test_submit_after_shutdown() {
        assert_eq!(gate.pending_acquire_permits(), 0);
// DedicatedExecutor — runs CPU-bound DataFusion work on its own tokio runtime.
                computed, cpu_threads, multiplier);
        // Attempt resize to 0 again — still rejected
        }
                // Assert: no deadlock (timeout didn't fire)
            initial_max in 4u32..=64u32,
                for _ in 0..excess {
        }
            // Property 1: Result is always at least 1
                );
                );
    pub async fn acquire(&self) -> OwnedSemaphorePermit {
    /// semaphore.
    /// Validates: Requirements 3.6
            // Math.max(1, (int)(cpuThreads * multiplier))
        drop(task);
    }
    max_permits: AtomicU32,
            concurrency_gate: Arc::new(ConcurrencyGate::new(max_concurrent_queries)),
            // Compute using the same formula as the Java side:
#[cfg(test)]
        assert_ne!(caller_id, spawned_id);
    /// Scale-up after scale-down: create gate with 8, resize down to 4 (poison held),
                // Apply all resizes sequentially
    {
    /// Serializes resize operations. Only one resize runs at a time.
        let current_max = self.max_permits.load(Ordering::Acquire);
        }
                    if tx_handle.send(Handle::current()).is_err() {
        let state = gate.resize_mutex.lock().await;
    /// Per-query concurrency gate: limits how many query stream drivers can
            pending_acquire_batches: AtomicU64::new(0),
            .unwrap();
                // Perform resize to target
    /// bound check is effectively unreachable for u32 inputs — we verify the lower
                    }
        gate.resize(4, "test").await;
            // For positive values (cpu_threads >= 1, multiplier >= 0.1), truncation
        let gate = ConcurrencyGate::new(4);
        // Drop the first permit — spawned task should complete
    /// that acquire permits concurrently with multiple resize operations.
            .name(format!("{name} driver"))
        assert_eq!(gate.max_permits(), 4);
                computed, expected, cpu_threads, multiplier);
        }
        let result = self.semaphore.clone().acquire_many_owned(n).await;
                }
    /// resize() calls, no thread SHALL panic, deadlock, or receive an invalid
                // should be at least `target`. It may exceed target when a scale-up
    // ─── pending_acquire_permits counter tests ─────────────────────────────────
        ) {
    async fn test_spawn_runs_on_different_thread() {
    /// Returns a reference to the concurrency gate for this executor.
    }
    pub fn spawn<T>(&self, task: T) -> impl Future<Output = Result<T::Output, JobError>>
            cpu_threads in 1i32..=128,
    /// run simultaneously on this executor. Acquired inside the spawned
}
        // Verify a valid resize still works after a rejected one
    ) -> Self {
        self.shutdown();
use log::{info, warn};
}
        let t2 = exec.spawn({
use tokio::{
    pub fn new(
/// Internal state guarded by the async resize mutex.
            }
    #[tokio::test]
    #[tokio::test]
        exec.join_blocking();
                     available_permits ({}) should be >= target ({})",
                    gate_name, old_max, new_max, additional_needed
        let barrier = Arc::new(AsyncBarrier::new(2));
                state.target_max_permits = new_max;
    pub fn poison_permits_held(&self) -> u32 {
    /// Returns the target max_permits (differs from max_permits during in-progress resize-down).
        let exec = test_exec(1);
                gate_name,
        }
            .load(Ordering::Acquire)
            handle: Some(handle),
            completed_shutdown: rx_shutdown.map_err(Arc::new).boxed().shared(),
        ) {
        let permits = max_concurrent.max(1);
        Self {
    pub async fn resize(&self, new_max: u32, gate_name: &str) {
                prop_assert!(
                })
                        } else if let Some(s) = e.downcast_ref::<&str>() {
        state.handle = None;
                        tokio::task::yield_now().await;
    poison_permits: Vec<OwnedSemaphorePermit>,
    }
    /// bound (0) is properly rejected.
    /// Non-blocking: returns current max_permits if a resize is in progress.
        let (_abort_handle, fut) = self.spawn_with_abort_handle(task);
        }
        let state = self.state.read();
    /// Helper: read poison_permits count from the resize state.
    }
    async fn test_resize_boundary_rejection() {
        assert_eq!(gate.max_permits(), 8);
        DedicatedExecutor::new("test-cpu", builder, threads)
            // proptest does not natively support async; create a runtime per iteration.
        }
                11
    /// complete, the gate's effective max_permits SHALL equal Tn (the last value).
    ///   Math.max(1, (int)(cpuThreads * multiplier))
    // ─── ConcurrencyGate resize unit tests ───────────────────────────────
                for _ in 0..num_acquires {
        // Scale down: 8 → 4 (acquires 4 individual poison permits)
                        drop(permit);
        }
                let mut runtime_builder = runtime_builder;
    /// and any valid target `target` (both in [1, 256]), after `resize(target)`
        // 2 poison permits remain (8 - 6 = 2 needed to maintain capacity at 6)
    proptest! {
    /// values in [1, 128]) applied sequentially to a gate, after all resizes
    #[tokio::test]
    resize_mutex: AsyncMutex<ResizeState>,
        if !std::thread::panicking() {
                    let permit = self
    }
        if new_max > current_max {
 * The OpenSearch Contributors require contributions made to
/// target max permits during an in-progress resize-down.
    #[tokio::test]
    #[tokio::test]
    /// The target max_permits if a resize-down is in progress, else equals max_permits.
        ) {
    #[tokio::test]
                gate.resize(target, "prop_test").await;
    pub fn pending_acquire_permits(&self) -> u64 {
    /// **Validates: Requirements 5.4**
    pub fn new(max_concurrent: usize) -> Self {
}
                state.target_max_permits = new_max;
        assert_eq!(gate.pending_acquire_permits(), 0);
// https://github.com/apache/datafusion/blob/main/datafusion-examples/examples/query_planning/thread_pools.rs
                let gate = ConcurrencyGate::new(initial_max as usize);
    ///
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
            if existing_poison >= total_poison_needed {
    pub fn handle(&self) -> Option<Handle> {
    ///
        let _permit2 = handle.await.unwrap();
                prop_assert!(
impl Drop for State {
        let exec = test_exec(1);
            })?;
    }
            join_set
/// Limits the number of concurrent query streams active on the CPU executor.
                    state.poison_permits.push(permit);
    async fn test_resize_scale_down_no_active() {
    async fn test_spawn_basic() {
                    Ok(e) => {
                .join_next()
        self.pending_acquire_batches.load(Ordering::Relaxed)
        tokio::task::yield_now().await;
    ///
        assert_eq!(gate.max_permits(), 8);
    proptest! {
                let additional_needed = total_poison_needed - existing_poison;
    }
    }
        let mut join_set = JoinSet::new();
        fut
    /// Property 3: Last-writer-wins convergence
        }
            let computed = std::cmp::max(1, (cpu_threads as f64 * multiplier) as i32);
    }
    /// A timeout detects deadlocks.
    use super::*;
        // Validate bounds
    }
    /// Number of batches currently waiting to acquire permits from this gate.
        builder.worker_threads(threads).enable_all();
    /// Returns the number of batches currently waiting to acquire permits.
    }
                    shutdown.as_mut().enable();
    pub fn spawn_with_abort_handle<T>(
    async fn test_cancel_on_drop() {
        self.total_queries_admitted.fetch_add(1, Ordering::Relaxed);
    sync::{
        assert_eq!(poison_permits_held(&gate).await, 4); // 4 entries, one permit each
            }),
            let b = barrier.clone();
        assert_eq!(gate.max_permits(), 6);
    }
        let notify_shutdown_captured = Arc::clone(&notify_shutdown);
    /// values in [0.1, 10.0] without floating-point strategy complexity.
        gate.resize(8, "test").await;
        impl Future<Output = Result<T::Output, JobError>>,
            state: Arc::new(RwLock::new(state)),
        #![proptest_config(ProptestConfig::with_cases(100))]
                .map_err(|e| match e.try_into_panic() {
                Ok(())
        (Some(abort_handle), fut)
                    final_max, resize_targets
    ///
                // Use a timeout to detect deadlocks (5 seconds is generous)
    fn drop(&mut self) {
        assert_eq!(gate.semaphore.available_permits(), 4);
            })?;
            initial_max in 1u32..=256u32,
    }
}
    pub async fn acquire_many(&self, n: u32) -> OwnedSemaphorePermit {
            state.thread.take()
/*
    /// Poison permits held to reduce effective capacity.
                    target, initial_max
                info!(
                    "After applying resize sequence {:?}, max_permits should equal \
    }
            target in 1u32..=256u32,
    /// **Validates: Requirements 5.2, 5.6**
            }
            resize_mutex: AsyncMutex::new(ResizeState {
                        "Task {} panicked (initial_max={}, num_acquires={}, \
        // After the spawned task completes, counters should be 0
            .fetch_add(n as u64, Ordering::Relaxed);
    proptest! {
        // Scale up: 4 → 6
            })?;
    }
                ).await;
        let Some(handle) = handle else {
    /// On 64-bit platforms, Semaphore::MAX_PERMITS exceeds u32::MAX so the upper
                    "After concurrent acquire/resize, max_permits ({}) should \
                let all_tasks = futures::future::join_all(join_handles);
        #![proptest_config(ProptestConfig::with_cases(100))]
                22
        };
        gate.resize(6, "test").await;
    /// `tokio_metrics::RuntimeMonitor` for the CPU runtime.
struct State {
                    Err(_) => JobError::WorkerGone,
    state: Arc<RwLock<State>>,
                }
        // The barrier will never be reached, so this just verifies no hang
mod tests {
        state.target_max_permits = new_max;
    /// Number of tasks currently waiting to acquire the semaphore.
        let notify_shutdown = Arc::new(Notify::new());
                            "unknown internal error".to_string()
        let b = barrier.clone();
            return (None, futures::future::err(JobError::WorkerGone).boxed());
 * compatible open source license.
    #[tokio::test]
        }
        }
        let exec = test_exec(1);
        assert_eq!(gate.pending_acquire_batches(), 0);
    #[tokio::test]
        }
        let mut state = self.resize_mutex.lock().await;
            other => panic!("Expected Panic error, got {:?}", other),
        exec.shutdown();
                }
                // Assert: no panics occurred in any task
        self.pending_acquire_permits
}
                );
                    let resize_handle = tokio::spawn(async move {
                runtime.shutdown_timeout(SHUTDOWN_TIMEOUT);
        T::Output: Send + 'static,
        Self {
        match result {
        assert_eq!(gate.semaphore.available_permits(), 8);
    )
                // We already hold enough poison permits; release excess
            let mut state = self.state.write();
        assert_eq!(gate.pending_acquire_batches(), 0);
                // follows an implicit scale-down (poison permits released in bulk).
            Err(_) => self.max_permits.load(Ordering::Relaxed),
    }
                    shutdown.await;
    pub fn join_blocking(&self) {
    fn test_exec(threads: usize) -> DedicatedExecutor {
    }
        // Available permits == max_permits - poison_held = 6 (semaphore has 6 available)
    use tokio::sync::Barrier as AsyncBarrier;
            let poison_count = state.poison_permits.len() as u32;
    }
    /// permit. All acquired permits SHALL be backed by the single shared
                gate_name, old_max, new_max, permits_from_poison, still_needed
        let thread = std::thread::Builder::new()
        T: Future + Send + 'static,
                    targets, last_target
