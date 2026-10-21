    async fn test_panic_propagates() {
    pub fn total_queries_admitted(&self) -> u64 {
    async fn test_resize_scale_up() {
                let runtime = runtime_builder.build().expect("Creating tokio runtime");
                    gate.semaphore.available_permits() >= target as usize,
            // Scale-Down: acquire poison permits to reduce effective capacity
        let (_abort_handle, fut) = self.spawn_with_abort_handle(task);
        gate.resize(0, "test").await;
        assert_eq!(gate.max_permits(), 4);
    Panic { msg: String },
    /// complete, the gate's effective max_permits SHALL equal Tn (the last value).
            // Convert integer to f64 multiplier in [0.1, 10.0]
                    target, initial_max,
                    final_max, resize_targets
    /// semaphore.
            self.start_shutdown.notify_one();
    {
    {
/// until the stream is fully consumed or dropped.
        let old_max = current_max;
            .fetch_sub(n as u64, Ordering::Relaxed);
    ///
        oneshot::error::RecvError, Mutex as AsyncMutex, Notify, OwnedSemaphorePermit, Semaphore,
            state.target_max_permits = new_max;
                                                         // Available permits should be 4: original 8 minus 4 acquired as poison
        state.handle = None;
        // Scale up: 4 → 6
        name: &str,
        assert_eq!(gate.max_permits(), 6);
                for _ in 0..excess {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        };
        let mut join_set = JoinSet::new();
    pub fn active_permits(&self) -> u32 {
                runtime.block_on(async move {
    /// Returns the number of batches currently waiting to acquire permits.
                state.target_max_permits = new_max;
                prop_assert!(
    /// the computed newMaxPermits SHALL equal max(1, floor(cpu_threads × multiplier)),
impl Drop for State {
    }
        Self {
                        gate_for_resize.resize(t, "prop_test").await;
        exec.join_blocking();
    /// `tokio_metrics::RuntimeMonitor` for the CPU runtime.
    /// completes, the effective max permits SHALL equal `target`.
                }
                        };
    /// - Scale-down: acquires poison permits to reduce effective capacity.
    }
        drop(task);
        let exec = test_exec(1);
    /// of acquire_many_owned poison permits on scale-up-after-scale-down).
                        let permit = gate_clone.acquire().await;
    }
            targets in proptest::collection::vec(1u32..=128u32, 2..20),
                    if tx_handle.send(Handle::current()).is_err() {
        assert_eq!(gate.pending_acquire_batches(), 1);
            thread: Some(thread),
                // Secondary assertion: since no queries are active, available permits
            })
        let permit = gate.acquire().await;
pub struct ConcurrencyGate {
            for _ in 0..permits_from_poison {
        }
        builder.worker_threads(threads).enable_all();
            let multiplier: f64 = multiplier_int as f64 / 10.0;
    /// Property 5: Concurrent acquire/resize safety
                }
        ) {
                prop_assert!(
        gate.resize(0, "test").await;
        let state = gate.resize_mutex.lock().await;
    pub fn join_blocking(&self) {
        assert_ne!(caller_id, spawned_id);
                    target, initial_max
    }
impl std::fmt::Debug for DedicatedExecutor {
                        .await
        state.poison_permits.len() as u32
    /// This test generates random gate sizes, numbers of concurrent acquires,
        let result = exec.spawn(async { 1 }).await;
        // Drop the first permit — spawned task should complete
            rt.block_on(async {
                // Primary assertion: max_permits reflects the target
    ///
pub struct DedicatedExecutor {
    #[tokio::test]
    /// **Validates: Requirements 3.1, 3.2, 3.4**
        if !std::thread::panicking() {
            .fetch_add(n as u64, Ordering::Relaxed);
                    gate_name, old_max, new_max, additional_needed
        let state = self.state.read();
        let gate = ConcurrencyGate::new(4);
                    let shutdown = notify_shutdown_captured.notified();
    /// Validates: Requirements 3.2, 3.7
        fn prop_permit_computation_correctness(
            Err(_) => 0, // Resize in progress, report 0
        gate.resize(4, "test").await;
 * this file be licensed under the Apache-2.0 license or a
                // must equal one of the resize targets (whichever executed last).
            // Property 1: Result is always at least 1
            pending_acquire_permits: AtomicU64::new(0),
    /// Validates: Requirements 3.6
    }
        exec.join_blocking();
        tokio::task::yield_now().await;
                // scheduler determines execution order. The final max_permits
                    gate.max_permits(), target,
                // Perform resize to target
                "[{}] resize complete: {} → {} (scale-up, released {} poison, added {} new)",
                // Apply all resizes sequentially
                        JobError::Panic { msg: s }
    /// Number of batches currently waiting to acquire permits from this gate.
                            "unknown internal error".to_string()
        gate.resize(6, "test").await;
                        } else {
        #![proptest_config(ProptestConfig::with_cases(100))]
    ///
        // Releases 2 poison permits (pops 2 entries), leaving 2 poison held.
    /// 4 poison permits held, and 4 available permits.
        exec.join_blocking();
use parking_lot::RwLock;
        assert_eq!(gate.max_permits(), 4);
            let b = barrier.clone();
    /// values in [0.1, 10.0] without floating-point strategy complexity.
        let current_max = self.max_permits.load(Ordering::Acquire);
        &self,
    }
        }
        let spawned_id = exec
    pub async fn acquire(&self) -> OwnedSemaphorePermit {
            initial_max in 1u32..=256u32,
            .unwrap();
        assert_eq!(result, 42);
        // Yield to let the spawned task start waiting
    #[tokio::test]
        let caller_id = std::thread::current().id();
            state.thread.take()
        self.max_permits.load(Ordering::Acquire)
        assert_eq!(gate.pending_acquire_batches(), 0);
        assert_eq!(poison_permits_held(&gate).await, 4); // 4 individual permits
        let state = State {
            return;
impl DedicatedExecutor {
    }
        assert_eq!(t2.await.unwrap(), 22);
    async fn test_resize_scale_down_no_active() {
        assert!(matches!(result, Err(JobError::WorkerGone)));
                    prop_assert!(
                     (initial_max={}, num_acquires={}, resize_targets={:?})",
// Based on InfluxDB's executor pattern.
            completed_shutdown: rx_shutdown.map_err(Arc::new).boxed().shared(),
        if let Some(thread) = self.thread.take() {
/// Limits the number of concurrent query streams active on the CPU executor.
    /// Validates: Requirements 3.1, 3.2
        assert_eq!(gate.max_permits(), 8);
        self.pending_acquire_permits
                }
}
}
        let handle = rx_handle.recv().expect("driver started");
}
                self.semaphore.add_permits(still_needed as usize);
        state.target_max_permits = new_max;
            state: Arc::new(RwLock::new(state)),
        let cloned = exec.clone();
                        .semaphore
    where
                    shutdown.await;
        let mut builder = tokio::runtime::Builder::new_multi_thread();
    }
            })?;
    /// We generate multiplier as an integer in [1, 100] divided by 10.0 to get
                prop_assert_eq!(
        let task = exec.spawn(async move {
    concurrency_gate: Arc<ConcurrencyGate>,
    /// Acquire N permits (partition-weighted). Held for the entire query stream lifetime.
            let _ = handle.join();
        exec.join_blocking();
            cpu_threads in 1i32..=128,
        .boxed();
        ) {
            .saturating_sub(self.semaphore.available_permits() as u32)
                     the last target {}",
            b.wait().await;
    }
    /// Validates: Requirements 3.7
                        .acquire_owned()
 * SPDX-License-Identifier: Apache-2.0
use std::sync::Arc;
        // Acquire the single permit so subsequent acquires will block
        assert_eq!(t1.await.unwrap(), 11);
struct State {
                "Mismatch: computed={}, expected={} for cpu_threads={}, multiplier={}",
                    let permit = self
        }
                // should be at least `target`. It may exceed target when a scale-up
    /// For any valid ConcurrencyGate with initial max permits `initial_max`
        }
 */
            info!(
    }
        };
    /// Non-blocking: returns current max_permits if a resize is in progress.
        }
        runtime_builder: tokio::runtime::Builder,
        let gate = ConcurrencyGate::new(8);
                b.wait();
use tokio::{
    #[tokio::test]
        if self.handle.is_some() {
                );
        assert_eq!(gate.semaphore.available_permits(), 6);
    /// On scale-up: we drop permits from here first, then add_permits for the delta.
                // Need to acquire additional poison permits (one at a time for precise release)
}
        assert_eq!(gate.max_permits(), 4);
        gate.resize(4, "test").await;
/*
            );
                    gate.resize(*target, "prop_test").await;
                let excess = existing_poison - total_poison_needed;
        match self.resize_mutex.try_lock() {
        assert_eq!(gate.pending_acquire_permits(), 1);
        assert_eq!(gate.semaphore.available_permits(), 8);
                b.wait();
                // Concurrently spawn resize tasks for each target in the sequence
                22
        // Validate bounds
                let gate = Arc::new(ConcurrencyGate::new(initial_max as usize));
            return (None, futures::future::err(JobError::WorkerGone).boxed());
                    let t = *target;
                let all_tasks = futures::future::join_all(join_handles);
            }
    /// Returns a clone of the underlying Tokio runtime `Handle`, if the
    /// permit. All acquired permits SHALL be backed by the single shared
                    });
    /// so scale-up releases exactly the needed count without overshoot.
    }
        } else {
                );
                "Permit count must be >= 1, got {} for cpu_threads={}, multiplier={}",
    /// can be used to cancel the CPU task from outside (e.g. from `cancel_query`).
    }
        }
            total_queries_admitted: AtomicU64::new(0),
    semaphore: Arc<Semaphore>,
        }
            self.completed_shutdown.clone().now_or_never();
        let abort_handle = join_set.spawn_on(task, &handle);
        self.shutdown();
            other => panic!("Expected Panic error, got {:?}", other),
            let rt = tokio::runtime::Runtime::new().unwrap();
            // proptest does not natively support async; create a runtime per iteration.
        fn prop_resize_reaches_target_capacity(
    /// CrossRtStream driver future and held for the query's entire lifetime.
        // Attempt resize to 0 again — still rejected
    ///   Math.max(1, (int)(cpuThreads * multiplier))
    ///
        task: T,
            if existing_poison >= total_poison_needed {
                Ok(())
    pub fn new(
        let permits = max_concurrent.max(1);
    poison_permits: Vec<OwnedSemaphorePermit>,
        assert_eq!(gate.pending_acquire_batches(), 0);
                    "After applying resize sequence {:?}, max_permits should equal \
                computed, expected, cpu_threads, multiplier);
                let mut runtime_builder = runtime_builder;
            }
        // Drop the task without awaiting — it should be cancelled
    /// Property 1: Resize reaches target capacity
    #[tokio::test]
    sync::{
                    initial_max, num_acquires, resize_targets
                            s.to_string()
        fn prop_concurrent_acquire_resize_safety(
    #[tokio::test]
                info!(
        let notify_shutdown_captured = Arc::clone(&notify_shutdown);
    #[tokio::test]
        let exec = test_exec(2);
            let rt = tokio::runtime::Runtime::new().unwrap();
            pending_acquire_batches: AtomicU64::new(0),
    pub fn max_permits(&self) -> u32 {
    /// Returns a reference to the concurrency gate for this executor.
                    "After resize({}) from initial_max={}, max_permits should equal target",
    #[tokio::test]
                let additional_needed = total_poison_needed - existing_poison;
        }
    fn drop(&mut self) {
        let handle = tokio::spawn(async move { gate_clone.acquire().await });
    /// On scale-down: we acquire permits and store them here.
    /// and any valid target `target` (both in [1, 256]), after `resize(target)`
    }
        self.total_queries_admitted.load(Ordering::Relaxed)
        exec.join_blocking();
                    gate.max_permits(), last_target,
            state.handle.clone()
        let elapsed_ms = start.elapsed().as_millis() as u64;
                    resize_targets.contains(&final_max),
        assert_eq!(gate.semaphore.available_permits(), 4);
                        drop(permit);
            }),
        assert_eq!(gate.semaphore.available_permits(), 6);
            concurrency_gate: Arc::new(ConcurrencyGate::new(max_concurrent_queries)),
    }
    /// executor has not been shut down. Used to create a
                    });
            rt.block_on(async {
    /// Returns the number of tasks currently waiting to acquire the semaphore.
            })?;
                    "[{}] resize complete: {} → {} (scale-down, released {} excess poison)",
        fn prop_last_writer_wins_convergence(
    }
        assert_eq!(gate.max_permits(), 4);
    total_wait_ms: AtomicU64,
    /// Scale-down from 8 → 4 with no active queries: verify max_permits == 4,
impl ConcurrencyGate {
        &self.concurrency_gate
        assert_eq!(poison_permits_held(&gate).await, 4); // 4 entries, one permit each
        // The barrier will never be reached, so this just verifies no hang
        max_concurrent_queries: usize,
            prop_assert_eq!(computed, expected,
    /// For any valid cpu_threads (in [1, 128]) and multiplier (in [0.1, 10.0]),
        let exec = test_exec(1);
    }
        let name = name.to_owned();
pub enum JobError {
    /// Like [`spawn`](Self::spawn), but also returns an [`AbortHandle`] that
    }
                    let gate_clone = Arc::clone(&gate);
}
        T: Future + Send + 'static,
    }
    pub fn spawn<T>(&self, task: T) -> impl Future<Output = Result<T::Output, JobError>>
    state: Arc<RwLock<State>>,
        T::Output: Send + 'static,
        self.pending_acquire_batches.fetch_add(1, Ordering::Relaxed);
            let computed = std::cmp::max(1, (cpu_threads as f64 * multiplier) as i32);
        #[test]
            multiplier_int in 1u32..=100,
        drop(permit);
use std::sync::atomic::{AtomicU32, AtomicU64, Ordering};
            }
    /// For any interleaving of acquire() calls from query tasks and concurrent
/// Holds poison permits (used to reduce effective capacity) and the
                        } else if let Some(s) = e.downcast_ref::<&str>() {
                    gate_name, old_max, new_max, excess
                info!(
        let handle = {
        assert_eq!(gate.pending_acquire_permits(), 0);
    ///
            total_wait_ms: AtomicU64::new(0),
        assert_eq!(gate.max_permits(), 8);
                    "After concurrent acquire/resize, max_permits ({}) should \
        let exec = test_exec(1);
        // 2 poison permits remain (8 - 6 = 2 needed to maintain capacity at 6)
            max_permits: AtomicU32::new(permits as u32),
    async fn test_clone_shares_runtime() {
#[cfg(test)]
                    "Deadlock detected: tasks did not complete within 5s timeout \
        self.pending_acquire_permits
        }
                // After all resizes, max_permits must equal the last target
        });
        assert_eq!(result, 99);
    use proptest::prelude::*;
    where
                gate_name,
    async fn test_submit_after_shutdown() {
            thread.join().ok();
            resize_targets in proptest::collection::vec(1u32..=64u32, 1..=5),
#[derive(Debug)]
    /// **Validates: Requirements 5.4**
        let gate = ConcurrencyGate::new(4);
        let exec = test_exec(1);
            if still_needed > 0 {
                // Use a timeout to detect deadlocks (5 seconds is generous)
    #[tokio::test]
// DedicatedExecutor — runs CPU-bound DataFusion work on its own tokio runtime.
    }
    }
        tokio::task::yield_now().await;
        let exec = test_exec(1);
                // hold it briefly (yield_now), then drop it.
            let existing_poison = state.poison_permits.len() as u32;
use futures::{future::BoxFuture, Future, FutureExt, TryFutureExt};
                    Ok(e) => {
    /// - Scale-up: releases poison permits first, then adds new permits.
                runtime.shutdown_timeout(SHUTDOWN_TIMEOUT);
#[derive(Clone)]
        };
        #![proptest_config(ProptestConfig::with_cases(100))]
    ) -> (
    target_max_permits: u32,
        fut
                for _ in 0..additional_needed {
            start_shutdown: notify_shutdown,
            // proptest does not natively support async; create a runtime per iteration.
        assert_eq!(poison_permits_held(&gate).await, 2);
    total_queries_admitted: AtomicU64,
    /// On 64-bit platforms, Semaphore::MAX_PERMITS exceeds u32::MAX so the upper
    #[tokio::test]
mod tests {
    }
        let gate = ConcurrencyGate::new(8);
        // Attempt resize to 0 — should be rejected (below minimum of 1)
    /// The target max_permits if a resize-down is in progress, else equals max_permits.
    pub async fn resize(&self, new_max: u32, gate_name: &str) {
            // For positive values (cpu_threads >= 1, multiplier >= 0.1), truncation
        (Some(abort_handle), fut)
            async move {
const SHUTDOWN_TIMEOUT: Duration = Duration::from_secs(60 * 5);
        #![proptest_config(ProptestConfig::with_cases(100))]
        let result = self.semaphore.clone().acquire_many_owned(n).await;
        #![proptest_config(ProptestConfig::with_cases(100))]
    use super::*;
    async fn test_resize_boundary_rejection() {
            rt.block_on(async {
        let exec = test_exec(1);
                    "[{}] resize complete: {} → {} (scale-down, acquired {} poison permits)",
                    let mut shutdown = std::pin::pin!(shutdown);
    }
    pub fn new(max_concurrent: usize) -> Self {
                })
            Ok(state) => state.poison_permits.len() as u32,
            42
                // Spawn `num_acquires` tasks that each acquire a permit,
                        tokio::task::yield_now().await;
    ///
    /// For any random sequence of resize targets [T1, T2, ..., Tn] (length 2..20,
            .await
            return; // No-op
        let b = barrier.clone();
            let mut state = self.state.write();
                    let handle = tokio::spawn(async move {
                .expect("just spawned task")
                // Assert: no panics occurred in any task
                // Assert: no deadlock (timeout didn't fire)
                        // Hold the permit briefly to create contention
// https://github.com/apache/datafusion/blob/main/datafusion-examples/examples/query_planning/thread_pools.rs
        assert_eq!(gate.max_permits(), 6);
            }
    resize_mutex: AsyncMutex<ResizeState>,
    /// Verify pending_acquire_permits increments during contention and returns to 0 after.
                    gate.semaphore.available_permits(), target
            Err(JobError::Panic { msg }) => assert!(msg.contains("boom")),
                computed, cpu_threads, multiplier);
            .expect("executor setup");
                        return;
    pub fn handle(&self) -> Option<Handle> {
    }
                let resize_targets_clone = resize_targets.clone();
                for _ in 0..num_acquires {
            self.max_permits.store(new_max, Ordering::Release);
    /// No-op resize (same value): verify no state change.
    /// Helper: read poison_permits count from the resize state.
    /// Returns the target max_permits (differs from max_permits during in-progress resize-down).
    async fn test_resize_scale_up_after_scale_down() {
                        .clone()
            .name(format!("{name} driver"))
    /// Since no queries are active in this test, available permits SHALL be
        let notify_shutdown = Arc::new(Notify::new());
    WorkerGone,
                    state.poison_permits.push(permit);
        self.pending_acquire_permits.load(Ordering::Relaxed)
        ) {
    }
        }
    max_permits: AtomicU32,
        let _permit2 = handle.await.unwrap();
        if new_max == current_max {
                    "After resize({}) from initial_max={} with no active queries, \
                Semaphore::MAX_PERMITS
    /// Per-query concurrency gate: limits how many query stream drivers can
    ///
    /// Each poison permit is acquired individually (one Vec entry = one permit),
            let still_needed = (new_max - current_max) - permits_from_poison;
    use tokio::sync::Barrier as AsyncBarrier;
                            s.clone()
                ).await;
                );
            );
        assert_eq!(gate.semaphore.available_permits(), 4);
    )
        assert_eq!(poison_permits_held(&gate).await, 0);
    },
    }
                // We already hold enough poison permits; release excess
    fn test_exec(threads: usize) -> DedicatedExecutor {
        assert_eq!(poison_permits_held(&gate).await, 0);
        DedicatedExecutor::new("test-cpu", builder, threads)
use std::time::{Duration, Instant};
    /// that acquire permits concurrently with multiple resize operations.
/// target max permits during an in-progress resize-down.
        state.start_shutdown.notify_one();
            let permits_from_poison = poison_count.min(new_max - current_max);
        gate.resize(8, "test").await;
    handle: Option<Handle>,
        self.total_wait_ms.load(Ordering::Relaxed)
    /// **Validates: Requirements 2.5**
        let result = exec.spawn(async { 42 }).await.unwrap();
    pub fn spawn_with_abort_handle<T>(
                for target in &resize_targets_clone {
}
        write!(f, "DedicatedExecutor")
        assert_eq!(gate.semaphore.available_permits(), 4);
        // Spawn a task that will block on acquire
                tx_shutdown.send(()).ok();
    runtime::Handle,
}
                // Since resize operations are spawned concurrently, the tokio
        self.total_wait_ms.fetch_add(elapsed_ms, Ordering::Relaxed);
        match result {
            num_acquires in 1usize..=16usize,
        let Some(handle) = handle else {
        let barrier = Arc::new(AsyncBarrier::new(2));
                gate.resize(target, "prop_test").await;
        barrier.wait();
        let t1 = exec.spawn({
                    all_tasks,
        let gate = Arc::new(ConcurrencyGate::new(1));
    ///
                    Err(_) => JobError::WorkerGone,
        T::Output: Send + 'static,
    #[tokio::test]
            // Property 2: Result matches the floor-based formula
                    let gate_for_resize = Arc::clone(&gate);
        assert_eq!(gate.semaphore.available_permits(), 4);
            let poison_count = state.poison_permits.len() as u32;
    completed_shutdown: futures::future::Shared<BoxFuture<'static, Result<(), Arc<RecvError>>>>,
        T: Future + Send + 'static,
                    let resize_handle = tokio::spawn(async move {
 * compatible open source license.
                prop_assert_eq!(
    /// then resize up to 6. Verify poison permits released and max_permits == 6.
                for (i, task_result) in results.iter().enumerate() {
    async fn test_spawn_runs_on_different_thread() {
}
        state.handle.clone()
    proptest! {
                prop_assert!(
                let final_max = gate.max_permits();
        assert_eq!(gate.max_permits(), 6);
                let last_target = *targets.last().unwrap();
    ///
                state.poison_permits.pop();
            join_set
    }
                }
        #[test]
        exec.join_blocking();
    }
                let gate = ConcurrencyGate::new(initial_max as usize);
            })?;
    ) -> Self {
    pub fn poison_permits_held(&self) -> u32 {
    proptest! {
                let gate = ConcurrencyGate::new(64);
    proptest! {
    /// and a sequence of resize targets (1..5), then spawns multiple tokio tasks
    pending_acquire_batches: AtomicU64,
        });
            let rt = tokio::runtime::Runtime::new().unwrap();
        let (tx_shutdown, rx_shutdown) = tokio::sync::oneshot::channel();
    #[tokio::test]
                Ok(())
        if new_max < 1 || new_max > Semaphore::MAX_PERMITS as u32 {
    /// bound check is effectively unreachable for u32 inputs — we verify the lower
            // toward zero is equivalent to floor. Both formulas must agree.
        assert_eq!(gate.pending_acquire_permits(), 0);
}
    /// Scale-up from 4 → 8: verify max_permits == 8 and 8 permits available.
    /// Resize the concurrency gate to a new maximum permit count.
        // Available permits == max_permits - poison_held = 6 (semaphore has 6 available)
        }
                let mut join_handles = Vec::new();
            self.handle = None;
    ///
        let result = cloned.spawn(async { 99 }).await.unwrap();
        };
                let result = tokio::time::timeout(
            let b = barrier.clone();
        self.max_permits
                Ok(())
        permit
        ) {
    use std::sync::{Arc, Barrier};
                         resize_targets={:?}): {:?}",
                // follows an implicit scale-down (poison permits released in bulk).
    }
        self.pending_acquire_batches.fetch_sub(1, Ordering::Relaxed);
    #[tokio::test]
    pub fn shutdown(&self) {
 *
            warn!(
            // Java's (int) cast truncates toward zero, equivalent to Rust's `as i32`.
        gate.resize(4, "test").await;
        assert_eq!(gate.semaphore.available_permits(), 8);
    async fn test_pending_acquire_permits_counter() {
        // After the spawned task completes, counters should be 0
    async fn test_resize_noop() {
                    result.is_ok(),
        let gate_clone = Arc::clone(&gate);
            // Scale-Up: release poison permits first, then add_permits for remaining delta
        // Scale down: 8 → 4 (acquires 4 individual poison permits)
        assert_eq!(gate.max_permits(), 4);
                        .expect("semaphore closed during resize");
                poison_permits: Vec::new(),
/// The permit is acquired inside the spawned stream-driver future and held
        assert_eq!(gate.max_permits(), 4);
        self.total_queries_admitted.fetch_add(1, Ordering::Relaxed);
        #[test]
    /// Validates: Requirements 3.1, 3.2
    pub fn pending_acquire_batches(&self) -> u64 {
                gate_name, old_max, new_max, permits_from_poison, still_needed
    }
struct ResizeState {
    /// Non-blocking: returns 0 if a resize is in progress.
                    state.poison_permits.pop();
                        task_result.is_ok(),
        });
        let mut state = self.state.write();
                );
    thread: Option<std::thread::JoinHandle<()>>,
    /// bound (0) is properly rejected.
                    Duration::from_secs(5),
    // ─── ConcurrencyGate resize unit tests ───────────────────────────────
    }
    }
        }
                for target in &targets {
                });
    }
                .join_next()
                );
                new_max,
            // Math.max(1, (int)(cpuThreads * multiplier))
                     available_permits ({}) should be >= target ({})",
                    join_handles.push(handle);
                    );
        gate.resize(6, "test").await;
/// Internal state guarded by the async resize mutex.
                state.target_max_permits = new_max;
            prop_assert!(computed >= 1,
    /// resize() calls, no thread SHALL panic, deadlock, or receive an invalid
            async move {
        let result = exec.spawn(async { panic!("boom") }).await;
    /// Boundary rejection: resize to 0 should be rejected.
    /// A timeout detects deadlocks.
    /// ensuring the result is always at least 1.
                    targets, last_target
    async fn test_spawn_basic() {
    /// Property 7: Permit computation correctness
        let start = Instant::now();
                self.max_permits.store(new_max, Ordering::Release);
                );
    /// **Validates: Requirements 5.2, 5.6**
    /// run simultaneously on this executor. Acquired inside the spawned
        assert_eq!(gate.semaphore.available_permits(), 6);
                     equal one of the resize_targets ({:?})",
                    join_handles.push(resize_handle);
        assert_eq!(gate.semaphore.available_permits(), 4);
        #[test]
                    shutdown.as_mut().enable();
    // ─── Property-based tests ────────────────────────────────────────────
    }
                11
        if let Some(handle) = thread_handle {
            target in 1u32..=256u32,
    task::{AbortHandle, JoinSet},
                );
        Self {
    /// Number of tasks currently waiting to acquire the semaphore.
    pub fn target_max_permits(&self) -> u32 {
        }
        }
    /// Acquire a permit. Held for the entire query stream lifetime.
    /// Returns the number of poison permits currently held.
    pending_acquire_permits: AtomicU64,
            semaphore: Arc::new(Semaphore::new(permits)),
                }
    /// This mirrors the Java-side computation:
};
        self.pending_acquire_batches.load(Ordering::Relaxed)
    }
                self.max_permits.store(new_max, Ordering::Release);
            .load(Ordering::Acquire)
        }
    start_shutdown: Arc<Notify>,
    async fn test_cancel_on_drop() {
    }
            Err(_) => self.max_permits.load(Ordering::Relaxed),
        Option<AbortHandle>,
    ///
            }
            .spawn(async { std::thread::current().id() })
    ///
                }
    /// Property 3: Last-writer-wins convergence
    /// at least `target` (may exceed target due to the bulk-release behavior
                        let s = if let Some(s) = e.downcast_ref::<String>() {
    }
            } else {
    }
        self.acquire_many(1).await
        // Verify a valid resize still works after a rejected one
                let results = result.unwrap();
                .await
    ///
        assert_eq!(gate.semaphore.available_permits(), 4);
                // Verify initial state
    /// values in [1, 128]) applied sequentially to a gate, after all resizes
    async fn poison_permits_held(gate: &ConcurrencyGate) -> u32 {
                    }
    pub fn pending_acquire_permits(&self) -> u64 {
        impl Future<Output = Result<T::Output, JobError>>,
        }
    proptest! {
            let total_poison_needed = current_max - new_max;
    }
        let thread_handle = {
                "[{}] resize rejected: new_max {} out of bounds [1, {}]",
            .spawn(move || {
                        "Task {} panicked (initial_max={}, num_acquires={}, \
            initial_max in 4u32..=64u32,
        let thread = std::thread::Builder::new()
    async fn test_multi_task() {
}
        exec.shutdown();
            let expected = std::cmp::max(1, (cpu_threads as f64 * multiplier).floor() as i32);
            Ok(state) => state.target_max_permits,
        let barrier = Arc::new(Barrier::new(3));
                .map_err(|e| match e.try_into_panic() {
    }
    /// - Serialized via the async resize mutex (only one resize at a time).
    /// Serializes resize operations. Only one resize runs at a time.
        let (tx_handle, rx_handle) = std::sync::mpsc::channel();
            // Compute using the same formula as the Java side:
        let fut = async move {
                // Assert: gate is in a valid state after all tasks complete.
    // ─── pending_acquire_permits counter tests ─────────────────────────────────
    }
        match self.resize_mutex.try_lock() {
                target_max_permits: permits as u32,
 * The OpenSearch Contributors require contributions made to
    /// Poison permits held to reduce effective capacity.
    pub fn total_wait_ms(&self) -> u64 {
    pub async fn acquire_many(&self, n: u32) -> OwnedSemaphorePermit {
        if new_max > current_max {
                    }
    /// Scale-up after scale-down: create gate with 8, resize down to 4 (poison held),
        let permit = result.expect("concurrency gate semaphore closed");
    pub fn concurrency_gate(&self) -> &Arc<ConcurrencyGate> {
        let t2 = exec.spawn({
            let state = self.state.read();
                        i, initial_max, num_acquires, resize_targets, task_result
            handle: Some(handle),
        }
        let mut state = self.resize_mutex.lock().await;
                prop_assert_eq!(gate.max_permits(), initial_max);
            resize_mutex: AsyncMutex::new(ResizeState {
        let gate = ConcurrencyGate::new(4);
use log::{info, warn};
    #[tokio::test]
