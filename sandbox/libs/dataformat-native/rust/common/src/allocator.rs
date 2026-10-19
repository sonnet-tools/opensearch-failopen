    loop {
    })
        if interval_ms == 0 {
/// Common values: 15 (~32KB, high accuracy), 17 (~128KB, default), 19 (~512KB, low overhead).
    let res = m
    #[test]
/// Returns 0 on success, negative error pointer on failure.
        set_all_arenas(b"muzzy_decay_ms\0", ms)
use std::sync::OnceLock;
        Ok((_, res)) => res,
                format!(
pub fn resident_bytes() -> i64 {
        };
    fn background_purge_pauses_when_interval_zero() {
    })
/// On error: returns negative error pointer (use `native_error_message` to read).
pub extern "C" fn native_jemalloc_resident_bytes() -> i64 {
/// Returns current jemalloc allocated bytes (live malloc'd objects).
}
}
        std::thread::sleep(Duration::from_millis(200));
            if ret == 0 {
        // Restore for other tests
mod tests {
}
#[no_mangle]
    fn allocated_increases_after_allocation() {
}
/// for future allocations. Returns 0 on success, negative error pointer on failure.
pub extern "C" fn native_jemalloc_stop_purge_thread() -> i64 {
    }
 */
        .read()
    ffm_wrap("native_jemalloc_heap_prof_deactivate", || {
            std::thread::park();
        set_all_arenas(b"dirty_decay_ms\0", ms)
//
#[no_mangle]
}
        native_jemalloc_set_dirty_decay_ms(30000);
        };
#[no_mangle]
    #[global_allocator]
    PURGE_COUNT.load(Ordering::Relaxed) as i64
    }
        assert!(rc <= 0, "expected error or 0, got {}", rc);
        handle.thread().clone()
        log_info!(
        let before = native_jemalloc_get_purge_count();
    if let Some(t) = PURGE_THREAD.get() {
    PURGE_THREAD.get_or_init(|| {
        // When the process is not started with prof:true, activate should return
/// FFI: Returns current jemalloc resident bytes, or negative error pointer.
    MIB.get_or_init(|| StatsMib {
        // Restore default
#[no_mangle]
/*
        .resident
 * The OpenSearch Contributors require contributions made to
// (or the compile-time MALLOC_CONF in lib.rs to include `prof:true`).
#[no_mangle]
static PURGE_THREAD: OnceLock<std::thread::Thread> = OnceLock::new();
/// FFI: Stops the background purge thread. Called from Java during node shutdown.
        // Set threshold to MAX — purge should never fire
            Ok(n) => n,
 *
#[no_mangle]
    PURGE_THRESHOLD_BYTES.store(threshold_bytes, Ordering::Relaxed);
    if any_success {
#[no_mangle]
/// Skips arenas that are not available (destroyed or internal).
        assert!(rc <= 0, "expected error or 0, got {}", rc);
    ffm_wrap("native_jemalloc_set_dirty_decay_ms", || {
                    std::ptr::null_mut(),
        native_jemalloc_start_purge_thread(i64::MAX, 50);
/// FFI: Updates the purge threshold at runtime. Called when cluster settings change.
        refresh_stats().map(|(alloc, _)| alloc)
        }
pub extern "C" fn native_jemalloc_set_dirty_decay_ms(ms: i64) -> i64 {
        let rc = native_jemalloc_heap_prof_activate();
//! FFI convention (same as all other native bridge functions):
        }
#[no_mangle]
    match refresh_stats() {
use crate::error::{ffm_wrap, into_error_ptr};
/// FFI: Updates the purge check interval at runtime. Set to 0 to pause purging.
        std::thread::sleep(Duration::from_millis(200));
    use super::*;
        assert_eq!(rc, 0, "setter should succeed, got {}", rc);
    static GLOBAL: tikv_jemallocator::Jemalloc = tikv_jemallocator::Jemalloc;
use tikv_jemalloc_ctl::{epoch, epoch_mib, stats, stats::allocated_mib, stats::resident_mib};
        .map_err(|e| format!("jemalloc epoch advance failed: {}", e))?;
 * compatible open source license.
#[no_mangle]
}
    }
        let rc = native_jemalloc_set_dirty_decay_ms(5000);
    ffm_wrap("native_jemalloc_heap_prof_reset", || {
    allocated: allocated_mib,
    }
        );
        refresh_stats().map(|(_, res)| res)
        )
#[no_mangle]
/// Advances the jemalloc epoch and reads both stats atomically.
// ── Heap profiling ──────────────────────────────────────────────────────────
        Ok(0)
        }
            unsafe { tikv_jemalloc_ctl::raw::read(b"arena.0.muzzy_decay_ms\0") }.unwrap();
/// Called from Java when the cluster setting `native.jemalloc.heap_prof_dump_path` is updated.
            })
    PURGE_INTERVAL_MS.store(interval_ms as u64, Ordering::Relaxed);
fn mib() -> &'static StatsMib {
        Err(msg) => into_error_ptr(msg),
    Ok((alloc, res))
/// Applies a setting to all existing jemalloc arenas.
    }
        let threshold = PURGE_THRESHOLD_BYTES.load(Ordering::Relaxed);
/// Returns current jemalloc resident bytes (physical RAM used by native layer only).
    })
        native_jemalloc_set_muzzy_decay_ms(30000);
                    std::ptr::null_mut(),
        assert!(
pub extern "C" fn native_jemalloc_heap_prof_activate() -> i64 {
    }
    fn heap_prof_deactivate_returns_error_when_prof_disabled() {
    #[test]
                    std::ptr::null_mut(),
        std::thread::sleep(Duration::from_millis(200));
        // Resume
) -> i64 {
    ffm_wrap("native_jemalloc_allocated_bytes", || {
        let rc = native_jemalloc_heap_prof_deactivate();
                    0,
        let narenas: u32 = match unsafe { tikv_jemalloc_ctl::raw::read(b"arenas.narenas\0") } {
        .map_err(|e| format!("jemalloc resident read failed: {}", e))? as i64;
/// FFI: Sets muzzy_decay_ms for all arenas at runtime. Returns 0 on success, negative error pointer on failure.
        if resident <= threshold {
    0
        std::thread::sleep(Duration::from_millis(100));
        if any_success {
    }
    let suffix_str = std::str::from_utf8(&suffix[..suffix.len() - 1]).unwrap();
            Ok((_, res)) => res,
        assert_eq!(
}
        assert!(
            .map_err(|e| format!("failed to deactivate profiling: {}", e))
            .map_err(|e| format!("failed to activate profiling: {}", e))
/// FFI: Returns current jemalloc allocated bytes, or negative error pointer.
                )
        assert!(allocated_bytes() > 0);
        Err(msg) => into_error_ptr(msg),
    }
    fn set_dirty_decay_ms_applies_at_runtime() {
        let handle = std::thread::Builder::new()
///
    #[test]
            resident / (1024 * 1024),
    }
}
/// FFI: Returns the total number of purges executed by the background thread.
            native_jemalloc_get_purge_count(),
                tikv_jemalloc_sys::mallctl(
/// TODO: integrate with node/stats
        native_jemalloc_start_purge_thread(0, 50);
// FFI setters.
            "jemalloc purge starting: resident={} MB, threshold={} MB",
    PURGE_THRESHOLD_BYTES.store(threshold_bytes, Ordering::Relaxed);
}
    if let Some(t) = PURGE_THREAD.get() {
        native_jemalloc_set_purge_interval(0);
            b"prof.dump\0",
        let before = native_jemalloc_get_purge_count();
        );
        // Pause the thread
/// Called once from Java at node startup (NativeBridgeModule.createComponents).
        tikv_jemalloc_ctl::raw::write(
        }
/// FFI: Dumps a heap profile to the given path. Path must be a null-terminated C string.
        t.unpark();
    #[test]
        }
        native_jemalloc_set_purge_threshold(0);
#[cfg(test)]
    }
            threshold / (1024 * 1024)
        let after = allocated_bytes();
}
/// FFI: Deactivates jemalloc heap profiling. Returns 0 on success, negative error pointer on failure.
            let key = format!("arena.{}.purge\0", i);
        }
///
}
                    key.as_ptr() as *const _,
            before,
use std::time::Duration;
        epoch: epoch::mib().unwrap(),
        native_jemalloc_set_purge_interval(50);
            native_jemalloc_get_purge_count(),
pub extern "C" fn native_jemalloc_set_purge_threshold(threshold_bytes: i64) -> i64 {
                )
use std::sync::atomic::{AtomicBool, AtomicI64, AtomicU64, Ordering};
    })
        .map_err(|e| format!("failed to read arenas.narenas: {}", e))?;
        if path.is_null() {
    fn allocated_bytes_is_positive() {
    })
        let c_str = std::ffi::CStr::from_ptr(path);
            .map(|_| 0i64)
static PURGE_INTERVAL_MS: AtomicU64 = AtomicU64::new(5000);
}
        let mut any_success = false;
        let before = allocated_bytes();
        // a negative error pointer (not crash).
fn purge_thread_loop() {
fn refresh_stats() -> Result<(i64, i64), String> {
/// Called from Java when the cluster setting `native.jemalloc.heap_prof_active` is set to false.
        t.unpark();
// this gracefully by logging a warning.
            "purge thread should have fired"
    }
    #[test]
/// On error: returns negative error pointer (use `native_error_message` to read).
/// Wakes the thread immediately so it picks up the new interval without waiting
    fn heap_prof_dump_null_path_returns_error() {
        let key = format!("arena.{}.{}\0", i, suffix_str);
            "expected negative error pointer for null path, got {}",
        }
    let m = mib();
}
        resident: stats::resident::mib().unwrap(),
        .advance()
        assert_eq!(rc, 0, "setter should succeed, got {}", rc);
        assert_eq!(actual, 10000);
}
/// Useful for application-level memory accounting and DataFusion memory pool budgeting.
    match refresh_stats() {
pub fn allocated_bytes() -> i64 {
}
struct StatsMib {
    })
pub extern "C" fn native_jemalloc_heap_prof_reset(lg_sample: usize) -> i64 {
    0
        // prof.dump expects a *const c_char pointing to the file path
/// Called from Java when the cluster setting `native.jemalloc.dirty_decay_ms` changes.
        unsafe { tikv_jemalloc_ctl::raw::write(b"prof.active\0", true) }
        // Restore default
    fn set_muzzy_decay_ms_applies_at_runtime() {
            .map(|_| 0i64)
        if PURGE_STOP.load(Ordering::Relaxed) {
/// FFI: Activates jemalloc heap profiling. Returns 0 on success, negative error pointer on failure.
        // threshold=0 means always purge; interval=50ms for fast feedback
static PURGE_THRESHOLD_BYTES: AtomicI64 = AtomicI64::new(i64::MAX);
    #[test]
        // Read back from arena 0 to verify it took effect
            Err(_) => continue,
            };
}
    epoch: epoch_mib,
/// Called from Java when the cluster setting `native.jemalloc.heap_prof_active` is set to true.
pub extern "C" fn native_jemalloc_allocated_bytes() -> i64 {
static PURGE_STOP: AtomicBool = AtomicBool::new(false);
    ffm_wrap("native_jemalloc_set_muzzy_decay_ms", || {
#[no_mangle]
        native_jemalloc_start_purge_thread(0, 50);
    0
        assert_eq!(
}
use crate::log_info;
            rc < 0,
        let resident = match refresh_stats() {
        Ok((alloc, _)) => alloc,
            continue;
//!   - `>= 0` → success (the stat value in bytes, or 0 for setters)
        let rc = native_jemalloc_set_muzzy_decay_ms(10000);
    fn background_purge_respects_threshold() {
            return Err("null path".to_string());
            }
    #[test]
/// Discards all accumulated profiling data and applies the new lg_prof_sample value
        assert_eq!(actual, 5000);
                any_success = true;
        for i in 0..narenas {
pub extern "C" fn native_jemalloc_start_purge_thread(
            .map(|_| 0i64)
    }
        .map(|_| 0i64)
            path_bytes.as_ptr() as *const std::ffi::c_char,
fn start_purge_thread() -> &'static std::thread::Thread {
            let ret = unsafe {
fn set_all_arenas(suffix: &[u8], ms: i64) -> Result<i64, String> {
        .allocated
/// Excludes JVM heap, metaspace, and other non-jemalloc allocations.
    PURGE_STOP.store(true, Ordering::Relaxed);
pub extern "C" fn native_jemalloc_set_muzzy_decay_ms(ms: i64) -> i64 {
    PURGE_INTERVAL_MS.store(interval_ms as u64, Ordering::Relaxed);
            any_success = true;
            before,
    resident: resident_mib,
    let narenas: u32 = unsafe { tikv_jemalloc_ctl::raw::read(b"arenas.narenas\0") }
        let actual: isize =
    }
    ffm_wrap("native_jemalloc_heap_prof_dump", || {
            "no purges when paused"
pub extern "C" fn native_jemalloc_heap_prof_deactivate() -> i64 {
    }
            return;
    fn heap_prof_activate_returns_error_when_prof_disabled() {
                    lg_sample, e
// ── Background purge thread ─────────────────────────────────────────────────
pub unsafe extern "C" fn native_jemalloc_heap_prof_dump(path: *const std::ffi::c_char) -> i64 {
static MIB: OnceLock<StatsMib> = OnceLock::new();
    m.epoch
    })
    }
    })
//!
pub extern "C" fn native_jemalloc_set_purge_interval(interval_ms: i64) -> i64 {
/// Called from Java when the cluster setting `native.jemalloc.muzzy_decay_ms` changes.
}
#[no_mangle]
        std::thread::park_timeout(Duration::from_millis(interval_ms));
/// Safe to call multiple times — only the first call spawns the thread.
    #[test]
// A dedicated OS thread that periodically checks jemalloc resident bytes against
//! jemalloc allocator interface: memory stats and runtime tuning.
}
}
            .spawn(purge_thread_loop)
    }
            unsafe { tikv_jemalloc_ctl::raw::read(b"arena.0.dirty_decay_ms\0") }.unwrap();
// Rust — no FFI round-trip per check. Java pushes threshold/interval updates via
    interval_ms: i64,
    }
        assert!(resident_bytes() > 0);
        .read()
    })
    fn resident_bytes_is_positive() {
            rc
        );
///
            "no purge when below threshold"
            .name("jemalloc-purge".into())
    #[test]
    start_purge_thread().unpark();
        Err(format!("failed to set {} on any arena", suffix_str))
    ffm_wrap("native_jemalloc_heap_prof_activate", || {
    } else {
    let alloc = m
        // prof:true is not set in test builds, so this should fail gracefully
/// FFI: Starts the background purge thread and sets the initial threshold.
/// FFI: Sets dirty_decay_ms for all arenas at runtime. Returns 0 on success, negative error pointer on failure.
// Requires the process to be started with `_RJEM_MALLOC_CONF=prof:true,...`
        let actual: isize =
                    "failed to reset profiling with lg_sample={}: {}",
        unsafe { tikv_jemalloc_ctl::raw::write(b"prof.active\0", false) }
    }
    #[test]
        unsafe { tikv_jemalloc_ctl::raw::write(b"prof.reset\0", lg_sample) }
/// TODO: integrate with node/stats
 * this file be licensed under the Apache-2.0 license or a
// a configurable threshold and purges all arenas if exceeded. Runs entirely in
    #[test]
        let _data: Vec<u8> = vec![42u8; 1024 * 1024];
/// FFI: Resets profiling state and sets a new sample interval.
        );
    for i in 0..narenas {
    fn background_purge_thread_fires() {
//
}
        .map_err(|e| format!("jemalloc allocated read failed: {}", e))? as i64;
            Err(_) => continue,
pub extern "C" fn native_jemalloc_get_purge_count() -> i64 {
        if unsafe { tikv_jemalloc_ctl::raw::write(key.as_bytes(), ms as isize) }.is_ok() {
 * SPDX-License-Identifier: Apache-2.0
// Without that, activate/dump will return errors — the caller (Java) handles
            .map_err(|e| {
            native_jemalloc_get_purge_count() > before,
}
        );
        std::thread::sleep(Duration::from_millis(100));
            continue;
    0
#[no_mangle]
            PURGE_COUNT.fetch_add(1, Ordering::Relaxed);
        allocated: stats::allocated::mib().unwrap(),
    ffm_wrap("native_jemalloc_resident_bytes", || {
            .expect("failed to spawn jemalloc-purge thread");
        .map_err(|e| format!("failed to dump heap profile: {}", e))
    let mut any_success = false;
        let interval_ms = PURGE_INTERVAL_MS.load(Ordering::Relaxed);
//!   - `< 0`  → error pointer. Negate and pass to `native_error_message` / `native_error_free`.
/// for the old sleep to expire.
        let rc = unsafe { native_jemalloc_heap_prof_dump(std::ptr::null()) };
        let path_bytes = c_str.to_bytes_with_nul();
        assert!(after > before, "expected {after} > {before}");
    })
        let before = native_jemalloc_get_purge_count();
static PURGE_COUNT: AtomicU64 = AtomicU64::new(0);
    threshold_bytes: i64,
