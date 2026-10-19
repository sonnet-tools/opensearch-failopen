//! The analytics `RuntimeManager` calls [`set_io_handle`] when it builds the IO
            "a superseded registration must not clear the slot"
pub struct HandleRegistration(u64);
            .unwrap();
        );
//! Process-global IO runtime [`Handle`], shared across all native crates.
        // Clean slate (a prior test in this binary may have left a handle).
 *
 */
/// Returns the process-global IO runtime handle, if one is currently installed.
    }
    /// holds this for its whole body. Poison is ignored deliberately: the guarded data is `()`,
}
//! (in the `opensearch-datafusion` crate). But the object stores that should
    }
/// teardown that means "this process has no IO runtime any more".
            true
        let rt_a = tokio::runtime::Builder::new_multi_thread()
//! [`clear_io_handle_if_current`] on shutdown. Each remote object-store
static NEXT_REGISTRATION: AtomicU64 = AtomicU64::new(1);
            .lock()
        );
        clear_io_handle();
        assert!(!clear_io_handle_if_current(reg_b));
    fn set_get_replace_clear_lifecycle() {
        assert_eq!(
    // Covers the ownership check the owning runtime relies on when it is torn down
    // out of order.
///
            "the live handle (B) must still be installed after A's late teardown"
/// runtime went away: an unconditional clear from a late-dropping owner strands
        assert_ne!(
/// when a stale owner's `Drop` runs — so ids can collide in precisely the case
/// Prefer [`clear_io_handle_if_current`] when clearing because one particular
        let rt_a = tokio::runtime::Builder::new_multi_thread()
 * The OpenSearch Contributors require contributions made to
    *GLOBAL_IO_HANDLE.write().unwrap() = Some((registration, handle));
    registration
    }
 * compatible open source license.
            .worker_threads(1)
        .unwrap()
    /// so a panicking test leaves nothing half-written, and propagating poison would turn one
//! of truth every crate can reach.
            *slot = None;
        // A's owner is torn down after B replaced it — the common case when an in-flight
            .enable_all()
//! which do NOT depend on `opensearch-datafusion`. The one crate they all share
/// this type exists to distinguish.
    *GLOBAL_IO_HANDLE.write().unwrap() = None;
        );
        let _slot = lock_slot();
        clear_io_handle();
            .worker_threads(1)
        // first-wins OnceLock: doStop/doStart rebuilds the runtime).
use std::sync::atomic::{AtomicU64, Ordering};
 * this file be licensed under the Apache-2.0 license or a
//!
            "each installation needs its own registration, or ownership cannot be told apart"
            "the installed registration must clear the slot"
pub fn set_io_handle(handle: Handle) -> HandleRegistration {
            .enable_all()
    }
///
            .enable_all()
        assert!(
        .as_ref()
//! A swappable [`RwLock`] slot (not a first-wins `OnceLock`) is used on purpose:
    let registration = HandleRegistration(NEXT_REGISTRATION.fetch_add(1, Ordering::Relaxed));
        let reg_b = set_io_handle(rt_b.handle().clone());
            .build()
        set_io_handle(rt_b.handle().clone());
    let mut slot = GLOBAL_IO_HANDLE.write().unwrap();
/// registration is what lets the caller clear only its own installation later.
        );
        .read()
        assert_eq!(
            .unwrap_or_else(|poisoned| poisoned.into_inner())
        let reg_a = set_io_handle(rt_a.handle().clone());
    GLOBAL_IO_HANDLE
    /// The slot is process-global and `cargo test` is parallel by default, so every test here
}
//!
        // Install A → io_handle() hands out A.
        assert!(
//!
            io_handle().is_none(),
//! `MicrosoftAzure` — are built in the separate `native-repository-*` crates,
        }
            "io_handle() must return the installed handle (A)"
        assert!(io_handle().is_none(), "handle must start cleared");
            "slot must be empty after B cleared it"
    // Covers the full lifecycle the remote object-store builders and RuntimeManager
}
/// Identifies one installation of the handle. [`set_io_handle`] hands one back and
    #[test]
        );
            .unwrap();
            .build()
//! the IO runtime instead of the CPU runtime — DataFusion's `thread_pools`
        set_io_handle(rt_a.handle().clone());
    fn lock_slot() -> std::sync::MutexGuard<'static, ()> {
/// every store built afterwards on its default connector.
            reg_a, reg_b,
//! point at a dead runtime; last-writer-wins keeps it live across restarts.
}
        .map(|(_, handle)| handle.clone())
//! dispatch their network IO onto it — `AmazonS3`, `GoogleCloudStorage`,
            .worker_threads(1)
//! is `native-bridge-common`, so the handle slot lives here as the single source
use tokio::runtime::Handle;
        let rt_b = tokio::runtime::Builder::new_multi_thread()
            .worker_threads(1)
    static SLOT_GUARD: std::sync::Mutex<()> = std::sync::Mutex::new(());
        let _slot = lock_slot();
            io_handle().is_none(),
        );
        let rt_b = tokio::runtime::Builder::new_multi_thread()
//! with no IO runtime), the builders leave their default connector untouched.
/// a runtime's id may be reused once that runtime has completed, which is exactly
    match *slot {
//! The dedicated IO runtime is owned by the analytics engine's `RuntimeManager`
    fn clear_if_current_only_clears_its_own_registration() {
static GLOBAL_IO_HANDLE: RwLock<Option<(HandleRegistration, Handle)>> = RwLock::new(None);
            .unwrap();
    /// real failure into `PoisonError` in the others and hide it.
            .enable_all()
            !clear_io_handle_if_current(reg_a),
        // B is the installed one, so it does clear.
            io_handle().as_ref().map(|h| h.id()),
/// replacement can only clear a slot it still owns.
        assert!(
/// Clear the handle only if `registration` is the one currently installed.
        clear_io_handle();
//!
    use super::*;
#[derive(Clone, Copy, Debug, Eq, PartialEq)]
            "the most recent set_io_handle must win (B replaces A)"
use std::sync::RwLock;
            .build()
            Some(rt_a.handle().id()),
        Some((installed, _)) if installed == registration => {
/// Clear the process-global IO runtime handle unconditionally, for an explicit
            .unwrap();
            io_handle().as_ref().map(|h| h.id()),
        // caller held the old owner across a re-install. B's handle must survive.
            Some(rt_b.handle().id()),
        // Clearing twice is a no-op rather than a panic: teardown paths can double-fire.
            io_handle().as_ref().map(|h| h.id()),
//! runtime, keeps the [`HandleRegistration`] it gets back, and presents that to
/*
    // rely on: install → read → last-writer-wins → clear.
/// Returns whether it cleared, which a caller can log but does not have to act on.
        assert!(
/// A monotonic counter rather than [`Handle::id`] on purpose: tokio documents that
        assert_eq!(
            clear_io_handle_if_current(reg_b),
mod tests {
    #[test]
/// [`clear_io_handle_if_current`] takes it, so an owner that outlives its own
//! a fresh one (node restarts in tests, service recycling). A stale handle would
        // Clear → builders fall back to the default connector.
        SLOT_GUARD
        // Install B → last writer wins (this is why it's an RwLock slot, not a
            .build()
//! `SpawnedReqwestConnector` so HTTP requests + response-body streaming run on
//! # Why this lives here
            "clear_io_handle must empty the slot so no stale handle is handed out"
//! `DataFusionService.doStop()` tears the IO runtime down and `doStart()` builds
}
pub fn io_handle() -> Option<Handle> {
            Some(rt_b.handle().id()),
#[cfg(test)]
 * SPDX-License-Identifier: Apache-2.0
pub fn clear_io_handle() {
        _ => false,
/// Install (or replace) the process-global IO runtime handle. Most recent writer
        );
        );
pub fn clear_io_handle_if_current(registration: HandleRegistration) -> bool {
/// wins, so the handle always points at the live IO runtime. The returned
//! example mechanism. If no handle is installed (e.g. a unit test, or a process
//! builder calls [`io_handle`] and, if present, installs a
