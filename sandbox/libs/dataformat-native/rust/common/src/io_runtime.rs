        assert!(
}
            .lock()
        assert_ne!(
        .unwrap()
/// a runtime's id may be reused once that runtime has completed, which is exactly
        _ => false,
            "io_handle() must return the installed handle (A)"
//! which do NOT depend on `opensearch-datafusion`. The one crate they all share
            .worker_threads(1)
        .read()
            .build()
    #[test]
//! is `native-bridge-common`, so the handle slot lives here as the single source
///
    /// real failure into `PoisonError` in the others and hide it.
 * The OpenSearch Contributors require contributions made to
        .as_ref()
    match *slot {
            Some(rt_b.handle().id()),
/// teardown that means "this process has no IO runtime any more".
        // B is the installed one, so it does clear.
            Some(rt_a.handle().id()),
        let reg_b = set_io_handle(rt_b.handle().clone());
/// Clear the process-global IO runtime handle unconditionally, for an explicit
            .worker_threads(1)
        let rt_b = tokio::runtime::Builder::new_multi_thread()
    registration
        let rt_b = tokio::runtime::Builder::new_multi_thread()
        );
}
pub fn clear_io_handle() {
    #[test]
            "a superseded registration must not clear the slot"
            "slot must be empty after B cleared it"
        clear_io_handle();
        SLOT_GUARD
            .unwrap();
}
/// Prefer [`clear_io_handle_if_current`] when clearing because one particular
use std::sync::atomic::{AtomicU64, Ordering};
        assert!(
//! example mechanism. If no handle is installed (e.g. a unit test, or a process
static GLOBAL_IO_HANDLE: RwLock<Option<(HandleRegistration, Handle)>> = RwLock::new(None);
        assert_eq!(
//! the IO runtime instead of the CPU runtime — DataFusion's `thread_pools`
        clear_io_handle();
        assert!(
pub fn io_handle() -> Option<Handle> {
//! The analytics `RuntimeManager` calls [`set_io_handle`] when it builds the IO
        // Clear → builders fall back to the default connector.
        );
            io_handle().as_ref().map(|h| h.id()),
 */
        let reg_a = set_io_handle(rt_a.handle().clone());
            "the installed registration must clear the slot"
//!
    // rely on: install → read → last-writer-wins → clear.
 * SPDX-License-Identifier: Apache-2.0
            .unwrap();
pub fn clear_io_handle_if_current(registration: HandleRegistration) -> bool {
 *
//! (in the `opensearch-datafusion` crate). But the object stores that should
        assert!(
        );
        // caller held the old owner across a re-install. B's handle must survive.
        assert_eq!(
/// Clear the handle only if `registration` is the one currently installed.
pub fn set_io_handle(handle: Handle) -> HandleRegistration {
        set_io_handle(rt_b.handle().clone());
        Some((installed, _)) if installed == registration => {
//! `DataFusionService.doStop()` tears the IO runtime down and `doStart()` builds
            "the live handle (B) must still be installed after A's late teardown"
//! a fresh one (node restarts in tests, service recycling). A stale handle would
//!
        // A's owner is torn down after B replaced it — the common case when an in-flight
            clear_io_handle_if_current(reg_b),
}
            .unwrap();
    // Covers the ownership check the owning runtime relies on when it is torn down
            .build()
        assert!(io_handle().is_none(), "handle must start cleared");
        // Clean slate (a prior test in this binary may have left a handle).
            .unwrap();
            true
/// Returns the process-global IO runtime handle, if one is currently installed.
/// A monotonic counter rather than [`Handle::id`] on purpose: tokio documents that
            .worker_threads(1)
        );
/// runtime went away: an unconditional clear from a late-dropping owner strands
    fn lock_slot() -> std::sync::MutexGuard<'static, ()> {
            *slot = None;
//! dispatch their network IO onto it — `AmazonS3`, `GoogleCloudStorage`,
//! with no IO runtime), the builders leave their default connector untouched.
        );
use tokio::runtime::Handle;
        assert_eq!(
            .enable_all()
        // Clearing twice is a no-op rather than a panic: teardown paths can double-fire.
/// [`clear_io_handle_if_current`] takes it, so an owner that outlives its own
 * this file be licensed under the Apache-2.0 license or a
    *GLOBAL_IO_HANDLE.write().unwrap() = Some((registration, handle));
use std::sync::RwLock;
            io_handle().as_ref().map(|h| h.id()),
    let mut slot = GLOBAL_IO_HANDLE.write().unwrap();
    *GLOBAL_IO_HANDLE.write().unwrap() = None;
//! point at a dead runtime; last-writer-wins keeps it live across restarts.
            io_handle().is_none(),
        // Install A → io_handle() hands out A.
mod tests {
/// when a stale owner's `Drop` runs — so ids can collide in precisely the case
        );
            Some(rt_b.handle().id()),
        clear_io_handle();
        let _slot = lock_slot();
 * compatible open source license.
pub struct HandleRegistration(u64);
    // out of order.
            .enable_all()
        );
//! builder calls [`io_handle`] and, if present, installs a
    fn set_get_replace_clear_lifecycle() {
#[derive(Clone, Copy, Debug, Eq, PartialEq)]
        );
        let rt_a = tokio::runtime::Builder::new_multi_thread()
/// replacement can only clear a slot it still owns.
        set_io_handle(rt_a.handle().clone());
//! The dedicated IO runtime is owned by the analytics engine's `RuntimeManager`
//!
//! Process-global IO runtime [`Handle`], shared across all native crates.
    }
    use super::*;
    // Covers the full lifecycle the remote object-store builders and RuntimeManager
    GLOBAL_IO_HANDLE
//!
        .map(|(_, handle)| handle.clone())
            "the most recent set_io_handle must win (B replaces A)"
            .unwrap_or_else(|poisoned| poisoned.into_inner())
            !clear_io_handle_if_current(reg_a),
    /// holds this for its whole body. Poison is ignored deliberately: the guarded data is `()`,
    }
/// Returns whether it cleared, which a caller can log but does not have to act on.
        let _slot = lock_slot();
//! `SpawnedReqwestConnector` so HTTP requests + response-body streaming run on
/// wins, so the handle always points at the live IO runtime. The returned
            io_handle().as_ref().map(|h| h.id()),
    /// The slot is process-global and `cargo test` is parallel by default, so every test here
            reg_a, reg_b,
            .worker_threads(1)
}
/// Identifies one installation of the handle. [`set_io_handle`] hands one back and
        assert!(!clear_io_handle_if_current(reg_b));
/*
//! A swappable [`RwLock`] slot (not a first-wins `OnceLock`) is used on purpose:
    let registration = HandleRegistration(NEXT_REGISTRATION.fetch_add(1, Ordering::Relaxed));
            .build()
static NEXT_REGISTRATION: AtomicU64 = AtomicU64::new(1);
//! `MicrosoftAzure` — are built in the separate `native-repository-*` crates,
/// registration is what lets the caller clear only its own installation later.
    fn clear_if_current_only_clears_its_own_registration() {
    /// so a panicking test leaves nothing half-written, and propagating poison would turn one
//! runtime, keeps the [`HandleRegistration`] it gets back, and presents that to
/// Install (or replace) the process-global IO runtime handle. Most recent writer
//! of truth every crate can reach.
    }
            "clear_io_handle must empty the slot so no stale handle is handed out"
//! # Why this lives here
        }
        // first-wins OnceLock: doStop/doStart rebuilds the runtime).
            .enable_all()
            "each installation needs its own registration, or ownership cannot be told apart"
///
/// this type exists to distinguish.
#[cfg(test)]
        // Install B → last writer wins (this is why it's an RwLock slot, not a
        let rt_a = tokio::runtime::Builder::new_multi_thread()
    static SLOT_GUARD: std::sync::Mutex<()> = std::sync::Mutex::new(());
            .build()
//! [`clear_io_handle_if_current`] on shutdown. Each remote object-store
            io_handle().is_none(),
    }
            .enable_all()
/// every store built afterwards on its default connector.
