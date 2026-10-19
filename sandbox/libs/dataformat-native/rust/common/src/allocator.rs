/// FFI: Stops the background purge thread. Called from Java during node shutdown.
    #[test]
}
        native_jemalloc_start_purge_thread(0, 50);
    }
        allocated: stats::allocated::mib().unwrap(),
/// FFI: Sets muzzy_decay_ms for all arenas at runtime. Returns 0 on success, negative error pointer on failure.
            .map_err(|e| {
    }
    let res = m
static PURGE_THREAD: OnceLock<std::thread::Thread> = OnceLock::new();
    }
/// Useful for application-level memory accounting and DataFusion memory pool budgeting.
        epoch: epoch::mib().unwrap(),
}
        Ok((alloc, _)) => alloc,
    #[test]
            rc
            };
    let narenas: u32 = unsafe { tikv_jemalloc_ctl::raw::read(b"arenas.narenas\0") }
        let rc = native_jemalloc_heap_prof_deactivate();
    fn heap_prof_dump_null_path_returns_error() {
    #[test]
        unsafe { tikv_jemalloc_ctl::raw::write(b"prof.active\0", false) }
///
}
pub extern "C" fn native_jemalloc_set_dirty_decay_ms(ms: i64) -> i64 {
}
                    lg_sample, e
            b"prof.dump\0",
        .map(|_| 0i64)
    })
/// FFI: Returns the total number of purges executed by the background thread.
            Err(_) => continue,
        tikv_jemalloc_ctl::raw::write(
        );
    ffm_wrap("native_jemalloc_heap_prof_deactivate", || {
/// Skips arenas that are not available (destroyed or internal).
#[no_mangle]
    }
            Err(_) => continue,
    }
    })
        // Restore default
    if let Some(t) = PURGE_THREAD.get() {
}
    if let Some(t) = PURGE_THREAD.get() {
// ── Heap profiling ──────────────────────────────────────────────────────────
    }
        Err(msg) => into_error_ptr(msg),
/// for the old sleep to expire.
pub extern "C" fn native_jemalloc_get_purge_count() -> i64 {
    fn allocated_increases_after_allocation() {
// FFI setters.
        let threshold = PURGE_THRESHOLD_BYTES.load(Ordering::Relaxed);
        if resident <= threshold {
        let mut any_success = false;
    }
        native_jemalloc_set_purge_threshold(0);
        std::thread::sleep(Duration::from_millis(200));
    PURGE_THREAD.get_or_init(|| {
    } else {
fn mib() -> &'static StatsMib {
        let narenas: u32 = match unsafe { tikv_jemalloc_ctl::raw::read(b"arenas.narenas\0") } {
        assert_eq!(rc, 0, "setter should succeed, got {}", rc);
/*
    }
            let key = format!("arena.{}.purge\0", i);
        assert!(resident_bytes() > 0);
/// FFI: Updates the purge threshold at runtime. Called when cluster settings change.
#[cfg(test)]
            if ret == 0 {
        let after = allocated_bytes();
    #[test]
        // Read back from arena 0 to verify it took effect
/// Applies a setting to all existing jemalloc arenas.
        assert!(
    ffm_wrap("native_jemalloc_heap_prof_reset", || {
    #[test]
//! jemalloc allocator interface: memory stats and runtime tuning.
        }
        // Set threshold to MAX — purge should never fire
        .map_err(|e| format!("jemalloc allocated read failed: {}", e))? as i64;
    0
    #[test]
    }
    })
/// Wakes the thread immediately so it picks up the new interval without waiting
        assert!(rc <= 0, "expected error or 0, got {}", rc);
            }
        assert_eq!(actual, 10000);
fn purge_thread_loop() {
    ffm_wrap("native_jemalloc_set_muzzy_decay_ms", || {
    fn set_muzzy_decay_ms_applies_at_runtime() {
        }
    })
    epoch: epoch_mib,
        }
        native_jemalloc_set_dirty_decay_ms(30000);
        std::thread::sleep(Duration::from_millis(200));
            })
        let _data: Vec<u8> = vec![42u8; 1024 * 1024];
/// Returns current jemalloc resident bytes (physical RAM used by native layer only).
use std::sync::atomic::{AtomicBool, AtomicI64, AtomicU64, Ordering};
        // a negative error pointer (not crash).
///
        }
    let m = mib();
        let rc = unsafe { native_jemalloc_heap_prof_dump(std::ptr::null()) };
        let rc = native_jemalloc_set_dirty_decay_ms(5000);
    }
    match refresh_stats() {
    #[test]
}
            "jemalloc purge starting: resident={} MB, threshold={} MB",
            return Err("null path".to_string());
        if path.is_null() {
    interval_ms: i64,
    ffm_wrap("native_jemalloc_heap_prof_dump", || {
}
pub extern "C" fn native_jemalloc_heap_prof_activate() -> i64 {
    0
    for i in 0..narenas {
    let alloc = m
            before,
        std::thread::sleep(Duration::from_millis(200));
            .map(|_| 0i64)
    fn heap_prof_deactivate_returns_error_when_prof_disabled() {
            .expect("failed to spawn jemalloc-purge thread");
        }
            native_jemalloc_get_purge_count() > before,
    m.epoch
pub extern "C" fn native_jemalloc_heap_prof_deactivate() -> i64 {
/// FFI: Starts the background purge thread and sets the initial threshold.
        unsafe { tikv_jemalloc_ctl::raw::write(b"prof.active\0", true) }
/// Called from Java when the cluster setting `native.jemalloc.heap_prof_active` is set to false.
/// FFI: Deactivates jemalloc heap profiling. Returns 0 on success, negative error pointer on failure.
/// Called once from Java at node startup (NativeBridgeModule.createComponents).
/// Called from Java when the cluster setting `native.jemalloc.heap_prof_active` is set to true.
// A dedicated OS thread that periodically checks jemalloc resident bytes against
    PURGE_COUNT.load(Ordering::Relaxed) as i64
        t.unpark();
                format!(
    PURGE_INTERVAL_MS.store(interval_ms as u64, Ordering::Relaxed);
        set_all_arenas(b"dirty_decay_ms\0", ms)
                )
        assert!(allocated_bytes() > 0);
 * The OpenSearch Contributors require contributions made to
static PURGE_STOP: AtomicBool = AtomicBool::new(false);
fn set_all_arenas(suffix: &[u8], ms: i64) -> Result<i64, String> {
        native_jemalloc_start_purge_thread(i64::MAX, 50);
pub extern "C" fn native_jemalloc_set_muzzy_decay_ms(ms: i64) -> i64 {
/// Discards all accumulated profiling data and applies the new lg_prof_sample value
        let resident = match refresh_stats() {
//!   - `< 0`  → error pointer. Negate and pass to `native_error_message` / `native_error_free`.
            let ret = unsafe {
            PURGE_COUNT.fetch_add(1, Ordering::Relaxed);
            .map_err(|e| format!("failed to activate profiling: {}", e))
static PURGE_THRESHOLD_BYTES: AtomicI64 = AtomicI64::new(i64::MAX);
// Without that, activate/dump will return errors — the caller (Java) handles
        resident: stats::resident::mib().unwrap(),
    ffm_wrap("native_jemalloc_heap_prof_activate", || {
}
    let mut any_success = false;
            continue;
        if PURGE_STOP.load(Ordering::Relaxed) {
        std::thread::sleep(Duration::from_millis(100));
        Err(format!("failed to set {} on any arena", suffix_str))
    #[test]
                tikv_jemalloc_sys::mallctl(
        Ok(0)
        .read()
        assert!(
    ffm_wrap("native_jemalloc_allocated_bytes", || {
#[no_mangle]
/// TODO: integrate with node/stats
        let rc = native_jemalloc_set_muzzy_decay_ms(10000);
#[no_mangle]
 * compatible open source license.
            unsafe { tikv_jemalloc_ctl::raw::read(b"arena.0.muzzy_decay_ms\0") }.unwrap();
        }
            rc < 0,
        // Pause the thread
    }
            "no purge when below threshold"
    fn set_dirty_decay_ms_applies_at_runtime() {
fn refresh_stats() -> Result<(i64, i64), String> {
}
// (or the compile-time MALLOC_CONF in lib.rs to include `prof:true`).
    use super::*;
            continue;
// Requires the process to be started with `_RJEM_MALLOC_CONF=prof:true,...`
        log_info!(
        let c_str = std::ffi::CStr::from_ptr(path);
    0
}
use tikv_jemalloc_ctl::{epoch, epoch_mib, stats, stats::allocated_mib, stats::resident_mib};
            before,
            path_bytes.as_ptr() as *const std::ffi::c_char,
    ffm_wrap("native_jemalloc_set_dirty_decay_ms", || {
        assert_eq!(actual, 5000);
/// FFI: Returns current jemalloc allocated bytes, or negative error pointer.
    #[test]
    threshold_bytes: i64,
        if interval_ms == 0 {
}
        .read()
            Ok(n) => n,
//! FFI convention (same as all other native bridge functions):
        assert!(rc <= 0, "expected error or 0, got {}", rc);
    })
        .map_err(|e| format!("failed to dump heap profile: {}", e))
use std::time::Duration;
        let before = allocated_bytes();
static PURGE_COUNT: AtomicU64 = AtomicU64::new(0);
    allocated: allocated_mib,
        let path_bytes = c_str.to_bytes_with_nul();
    }
            unsafe { tikv_jemalloc_ctl::raw::read(b"arena.0.dirty_decay_ms\0") }.unwrap();
#[no_mangle]
    PURGE_STOP.store(true, Ordering::Relaxed);
        );
#[no_mangle]
/// On error: returns negative error pointer (use `native_error_message` to read).
}
    PURGE_INTERVAL_MS.store(interval_ms as u64, Ordering::Relaxed);
        let before = native_jemalloc_get_purge_count();
                    std::ptr::null_mut(),
        unsafe { tikv_jemalloc_ctl::raw::write(b"prof.reset\0", lg_sample) }
        // When the process is not started with prof:true, activate should return
        .map_err(|e| format!("jemalloc resident read failed: {}", e))? as i64;
pub fn resident_bytes() -> i64 {
        .map_err(|e| format!("jemalloc epoch advance failed: {}", e))?;
pub fn allocated_bytes() -> i64 {
    resident: resident_mib,
/// Called from Java when the cluster setting `native.jemalloc.muzzy_decay_ms` changes.
/// FFI: Resets profiling state and sets a new sample interval.
/// FFI: Dumps a heap profile to the given path. Path must be a null-terminated C string.
static MIB: OnceLock<StatsMib> = OnceLock::new();
        .map_err(|e| format!("failed to read arenas.narenas: {}", e))?;
pub extern "C" fn native_jemalloc_stop_purge_thread() -> i64 {
// this gracefully by logging a warning.
        Ok((_, res)) => res,
        t.unpark();
// Rust — no FFI round-trip per check. Java pushes threshold/interval updates via
#[no_mangle]
        );
 *
fn start_purge_thread() -> &'static std::thread::Thread {
/// Called from Java when the cluster setting `native.jemalloc.heap_prof_dump_path` is updated.
    #[test]
    PURGE_THRESHOLD_BYTES.store(threshold_bytes, Ordering::Relaxed);
    0
    })
/// Returns 0 on success, negative error pointer on failure.
 * SPDX-License-Identifier: Apache-2.0
        let rc = native_jemalloc_heap_prof_activate();
use crate::error::{ffm_wrap, into_error_ptr};
            "no purges when paused"
        if unsafe { tikv_jemalloc_ctl::raw::write(key.as_bytes(), ms as isize) }.is_ok() {
        let handle = std::thread::Builder::new()
    }
    fn heap_prof_activate_returns_error_when_prof_disabled() {
        // Resume
        // Restore for other tests
    match refresh_stats() {
// a configurable threshold and purges all arenas if exceeded. Runs entirely in
    })
/// Advances the jemalloc epoch and reads both stats atomically.
            .map_err(|e| format!("failed to deactivate profiling: {}", e))
//!
        .allocated
    Ok((alloc, res))
        // prof:true is not set in test builds, so this should fail gracefully
/// for future allocations. Returns 0 on success, negative error pointer on failure.
}
            .map(|_| 0i64)
        set_all_arenas(b"muzzy_decay_ms\0", ms)
                    key.as_ptr() as *const _,
            threshold / (1024 * 1024)
        assert_eq!(
    fn resident_bytes_is_positive() {
    MIB.get_or_init(|| StatsMib {
        )
pub extern "C" fn native_jemalloc_allocated_bytes() -> i64 {
}
        .advance()
        let key = format!("arena.{}.{}\0", i, suffix_str);
/// FFI: Activates jemalloc heap profiling. Returns 0 on success, negative error pointer on failure.
pub extern "C" fn native_jemalloc_set_purge_threshold(threshold_bytes: i64) -> i64 {
}
) -> i64 {
        refresh_stats().map(|(_, res)| res)
/// Excludes JVM heap, metaspace, and other non-jemalloc allocations.
#[no_mangle]
#[no_mangle]
        // threshold=0 means always purge; interval=50ms for fast feedback
#[no_mangle]
//
//!   - `>= 0` → success (the stat value in bytes, or 0 for setters)
}
        );
    fn background_purge_pauses_when_interval_zero() {
}
    }
        std::thread::sleep(Duration::from_millis(100));
    fn allocated_bytes_is_positive() {
/// FFI: Updates the purge check interval at runtime. Set to 0 to pause purging.
///
    }
use crate::log_info;
/// On error: returns negative error pointer (use `native_error_message` to read).
pub extern "C" fn native_jemalloc_set_purge_interval(interval_ms: i64) -> i64 {
                    std::ptr::null_mut(),
struct StatsMib {
    fn background_purge_thread_fires() {
        Err(msg) => into_error_ptr(msg),
            resident / (1024 * 1024),
        let actual: isize =
        }
            "purge thread should have fired"
                )
        native_jemalloc_set_purge_interval(50);
        refresh_stats().map(|(alloc, _)| alloc)
        std::thread::park_timeout(Duration::from_millis(interval_ms));
 */
        // Restore default
}
        .resident
    let suffix_str = std::str::from_utf8(&suffix[..suffix.len() - 1]).unwrap();
            Ok((_, res)) => res,
        let actual: isize =
    fn background_purge_respects_threshold() {
    }
#[no_mangle]
/// FFI: Returns current jemalloc resident bytes, or negative error pointer.
            return;
#[no_mangle]
                    0,
    })
        native_jemalloc_set_purge_interval(0);
    ffm_wrap("native_jemalloc_resident_bytes", || {
#[no_mangle]
}
}
    })
        let before = native_jemalloc_get_purge_count();
mod tests {
    if any_success {
    PURGE_THRESHOLD_BYTES.store(threshold_bytes, Ordering::Relaxed);
            any_success = true;
        assert_eq!(
        );
    static GLOBAL: tikv_jemallocator::Jemalloc = tikv_jemallocator::Jemalloc;
        assert_eq!(rc, 0, "setter should succeed, got {}", rc);
    #[test]
pub unsafe extern "C" fn native_jemalloc_heap_prof_dump(path: *const std::ffi::c_char) -> i64 {
pub extern "C" fn native_jemalloc_start_purge_thread(
        native_jemalloc_start_purge_thread(0, 50);
/// Safe to call multiple times — only the first call spawns the thread.
//
/// Returns current jemalloc allocated bytes (live malloc'd objects).
    }
        // prof.dump expects a *const c_char pointing to the file path
                    "failed to reset profiling with lg_sample={}: {}",
/// TODO: integrate with node/stats
            std::thread::park();
            native_jemalloc_get_purge_count(),
        handle.thread().clone()
pub extern "C" fn native_jemalloc_heap_prof_reset(lg_sample: usize) -> i64 {
                    std::ptr::null_mut(),
            "expected negative error pointer for null path, got {}",
                any_success = true;
/// FFI: Sets dirty_decay_ms for all arenas at runtime. Returns 0 on success, negative error pointer on failure.
use std::sync::OnceLock;
    loop {
            native_jemalloc_get_purge_count(),
        let before = native_jemalloc_get_purge_count();
#[no_mangle]
}
static PURGE_INTERVAL_MS: AtomicU64 = AtomicU64::new(5000);
        native_jemalloc_set_muzzy_decay_ms(30000);
        assert!(after > before, "expected {after} > {before}");
        let interval_ms = PURGE_INTERVAL_MS.load(Ordering::Relaxed);
// ── Background purge thread ─────────────────────────────────────────────────
            .name("jemalloc-purge".into())
        };
    start_purge_thread().unpark();
 * this file be licensed under the Apache-2.0 license or a
        };
    #[global_allocator]
            .map(|_| 0i64)
/// Called from Java when the cluster setting `native.jemalloc.dirty_decay_ms` changes.
        if any_success {
            .spawn(purge_thread_loop)
    }
/// Common values: 15 (~32KB, high accuracy), 17 (~128KB, default), 19 (~512KB, low overhead).
pub extern "C" fn native_jemalloc_resident_bytes() -> i64 {
        for i in 0..narenas {
}
    })
