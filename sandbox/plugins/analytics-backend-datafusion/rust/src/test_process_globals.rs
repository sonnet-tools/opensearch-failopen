//! These are not independent — opening a doc-values cursor reads the runtime manager and the
use std::cell::Cell;
         as the first line of the test body and keep the binding alive for the whole test."
///
//! Test-only discipline for the engine's process-global state.
    // before another thread can take the mutex and see a stale non-zero depth of its own.
    static HELD_DEPTH: Cell<usize> = const { Cell::new(0) };
    ONCE.call_once(|| crate::ffm::df_init_runtime_manager(2, 1.5, 1.5));
/// ```ignore
//! - the `memory_guard` spill globals that runtime construction writes.
    static ONCE: std::sync::Once = std::sync::Once::new();
}
    // Dropped after the depth decrement below, which is the order we want: the depth must reach 0
/// one instead of trusting a comment.
#[track_caller]
/// pulls the manager out from under every other test that is mid-read — which surfaces as
    /// acquisition — a helper that locks inside a test that already did — releases correctly.
///
    );
use std::sync::{Mutex, MutexGuard};
        "{what} is process-global, but this test does not hold \
//! tests take 0.21s in total when run serially, so the lost parallelism is not measurable against
//! Production installs each of these globals once from `DataFusionService.doStart` and never
//!
/// to catch is an unguarded test running *concurrently with* a guarded one, and a global counter
/// first call installs the manager, and `df_init_runtime_manager` asserts the lock for that reason.
/// `what` names the state being touched, so the panic says which invariant was broken.
/// corrupting an unrelated test's assertion in a later run.
///
/// let _globals = crate::test_process_globals::lock();
/// Installs the runtime manager production installs from `DataFusionService.doStart`, once per test
/// in `tests/` already use.
//!   only a `Weak`, so closing a runtime that registered it leaves every reader with `None`;
//!
         crate::test_process_globals::lock(). Add `let _globals = crate::test_process_globals::lock();` \
/// can leave half-written, and propagating poison would turn one genuine failure into a dozen
///
impl Drop for ProcessGlobalsGuard {
/// DataFusion executor thread polls; assert at the entry point the test itself calls.
///
}
/// Cheap and idempotent, so callers may call it unconditionally, but [`lock`] must be held: the
//! - the runtime manager, `ffm::TOKIO_RUNTIME_MANAGER` — see [`install_runtime_manager`];
//! Every test that touches any of the above must hold [`lock`] for its whole body. The affected
}
/// process.
        .lock()
/// Panics unless the calling thread holds [`lock`]. Call this from the entry points that reach the
    let inner = PROCESS_GLOBALS
//! - the scoped page-index caches, `cache::page_index::{COLUMN_INDEX_CACHE, OFFSET_INDEX_CACHE}`,
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
}
/// "no runtime manager registered" from an unrelated test. Nothing tears it down; the manager's
/*
/// Proof that the holder has exclusive access to the engine's process-global state. Also records
//!   whose hit/miss/entry counters are process-wide;
//! test that reads it. The globals in question are
pub(crate) fn assert_held(what: &str) {
//! many threads, so a test that replaces, resets or asserts on one of them is racing every other
}
//! - the global `RuntimeEnv` registration, `cache::metadata_cache::GLOBAL_RUNTIME_ENV`, which keeps
/// unconditionally and `df_shutdown_runtime_manager` clears it, so a second call from one test
 * SPDX-License-Identifier: Apache-2.0
//!
 * The OpenSearch Contributors require contributions made to
 *
/// returned guard in a binding that lives as long as the test body:
 */
//! turn a data race into a lock-ordering problem.
    fn drop(&mut self) {
/// the fact on the holding thread, so [`assert_held`] can tell a guarded caller from an unguarded
}
//! lock rather than one lock each. Separate locks would force a test to hold several at once and
    }
thread_local! {
///
/// Exclusive access to the engine's process-global state for the duration of a test. Hold the
//! `RuntimeEnv` registration and inserts into the page-index caches — so they are covered by ONE
        .unwrap_or_else(|poisoned| poisoned.into_inner());
        HELD_DEPTH.with(Cell::get) > 0,
/// Install-once rather than per-test: `df_init_runtime_manager` replaces the global
pub(crate) struct ProcessGlobalsGuard {
//!
pub(crate) fn lock() -> ProcessGlobalsGuard {
    ProcessGlobalsGuard { _inner: inner }
/// Poison is deliberately ignored: the guarded data is `()`, so there is nothing a panicking test
//! contends on them. A test binary is the opposite: `cargo test` runs every test in one process on
/// shared globals, so a test that forgets the lock fails loudly at the offending call instead of
static PROCESS_GLOBALS: Mutex<()> = Mutex::new(());
/// the thread that took the guard. A global counter would be useless here — the failure this exists
        HELD_DEPTH.with(|depth| depth.set(depth.get() - 1));
pub(crate) fn install_runtime_manager() {
    HELD_DEPTH.with(|depth| depth.set(depth.get() + 1));
/// threads live until the test process exits. Mirrors the `OnceLock` setup the integration tests
//! a suite that takes ~9s.
    assert!(
    _inner: MutexGuard<'static, ()>,
    /// How many guards this thread currently holds. A depth rather than a flag so a nested
/// Thread-local by design, and that is also its limit: it can only be placed where the work runs on
/// ```
/// `PoisonError` panics in unrelated tests and bury the real one.
/// reads as "held" in exactly that situation. So do not move these calls onto a path that a
