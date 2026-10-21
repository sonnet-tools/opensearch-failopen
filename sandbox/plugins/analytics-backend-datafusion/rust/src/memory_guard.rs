        assert_eq!(spill_exempt_cap_bytes(), 512 * 1024 * 1024);
    /// RSS above this → reduce parallelism for new queries. Default: 0.75
pub fn set_pool_limit_for_guard(limit: i64) {
#[derive(Debug, Clone, Copy)]
        // - Admission override should NOT fire (RSS >= 70% threshold)
///
#[cfg(unix)]
            admission_reject: 0.85,
        return None;
}
/// Three states make the call site unambiguous:
    None
pub fn should_override(pool_limit_bytes: usize, context: OverrideContext) -> bool {
/// DataFusion is built with `DiskManagerMode::Disabled`). This makes the disabled
        let resident = cached_resident_bytes();
        );
    let mut stat = MaybeUninit::<libc::statvfs>::uninit();
    let available = match available_disk_space(spill_dir) {
#[derive(Debug, Clone, Copy)]
        let large_pool = 1024 * 1024 * 1024 * 1024; // 1TB
        assert_eq!(spill_exempt_cap_bytes(), 256 * 1024 * 1024);
        if LAST_CHECK_MS
/// reads fresh — because a stale-high value can incorrectly block the override
/// Cost: one `epoch.advance` + stat read (~1-5µs). Called once per query at
    let resident = cached_resident_bytes();
    }
    resident >= threshold_bytes as i64
#[cfg(test)]
}
    let resident = cached_resident_bytes();
        set_spill_exempt_cap_bytes(512 * 1024 * 1024);
        return false;
static ADMISSION_THROTTLE_X1000: AtomicU64 = AtomicU64::new(750);
        assert_eq!(spill_exempt_cap_bytes(), 0);
    };
        let result = should_override(large_pool, OverrideContext::Execution);
    }
}
/// Uses `resident_bytes` (physical RSS) instead of `allocated_bytes` (live objects).
    }
        (thresholds.admission_reject * 1000.0) as u64,
static LAST_CHECK_MS: AtomicU64 = AtomicU64::new(u64::MAX);
/// Mark spill explicitly disabled (called once from create_global_runtime when
/// state explicit so `per_query_spill_budget` returns `Disabled` instead of
        }
    resident < threshold_bytes as i64
    // ever changes.
/// - `pool_limit_bytes`: the pool's configured limit
    }
    let threshold_bytes = (pool_limit_bytes as u64).saturating_mul(threshold_x1000) / 1000;
    Disabled,
        // Round-trips an arbitrary value.
                small_pool
        // Restore default.
// Pool limit stored for the guard's threshold check. Set once from create_global_runtime.
/// - `context`: which layer is asking (determines threshold)
    fn default_thresholds() {
        // With a 20MB pool limit (above MIN_POOL_FOR_OVERRIDE), the current test
        Ordering::Release,
        assert!(
}
/// the epoch.advance() cost; all others get the cached value in <1ns.
        return false;
    let base = EPOCH_BASE.get_or_init(Instant::now);
        let resident = native_bridge_common::allocator::resident_bytes();
///                  (< 64MB after the fraction, or `statvfs` failed). Caller clamps to 1.
        // For a pool where RSS is between 70% and 85%:
    #[test]
    );
/// Execution thresholds control what happens during the query.
        assert!(!should_cancel_query(8 * 1024 * 1024)); // 8MB
        Ordering::Release,
pub enum OverrideContext {
//! Unified jemalloc-based memory guard for pool override decisions.
static DISK_FRACTION_X1000: AtomicU64 = AtomicU64::new(100); // 10% = 100/1000
/// Which layer is asking for the override check.
static EPOCH_BASE: std::sync::OnceLock<Instant> = std::sync::OnceLock::new();
pub fn get_thresholds() -> MemoryThresholds {
        admission_reject: ADMISSION_REJECT_X1000.load(Ordering::Acquire) as f64 / 1000.0,
    let _ = SPILL_DIR.set(path.to_string());
/// Returns `true` if the override should fire (proceed despite pool rejection).
        );
        set_spill_exempt_cap_bytes(64 * 1024 * 1024);
        }
            let threshold = (limit as u64 * spill_x1000 / 1000) as i64;
            execution_critical: 0.97,
    let threshold_x1000 = match context {
            }
        // Default is 512MB.
            !admission_result,
    let threshold_x1000 = ADMISSION_THROTTLE_X1000.load(Ordering::Acquire);
        let first = cached_resident_bytes();
        );
    /// Execution try_grow: deciding whether to allow despite pool rejection.
    if ret != 0 {
    // A stale-high value would block the override and prevent spill from completing.
//! truth refreshed at most once per 100ms. This avoids expensive jemalloc
    #[test]
        let spill_x1000 = EXECUTION_SPILL_X1000.load(Ordering::Relaxed);
    fn set_and_get_thresholds() {
/// * `Disabled`     — spill is off; parallelism MUST NOT be clamped (no spill = no risk).
///
        OverrideContext::Execution => EXECUTION_SPILL_X1000.load(Ordering::Acquire),
/// Formula: `10% of available_disk` for the `Available` case.
    ADMISSION_REJECT_X1000.store(
            assert!(
/// * `Available(n)` — spill is on and disk is healthy; full parallelism + per-query budget.
#[cfg(not(unix))]
/// When the cached value is above the spill threshold, bypasses the cache and
    }
            "[disk-pressure] Spill budget too low: {} MB (available={} MB)",
        admission_throttle: ADMISSION_THROTTLE_X1000.load(Ordering::Acquire) as f64 / 1000.0,
        let critical_bytes = (small_pool as f64 * 0.95) as i64;
// --- Thresholds ---
/// returning a phantom "disk pressure" signal driven by an unset `SPILL_DIR`.
fn pool_limit_for_guard() -> i64 {
/// Set the pool limit used by the cached RSS pressure check.
    let stat = unsafe { stat.assume_init() };
        {
    Some(stat.f_bavail as u64 * stat.f_frsize as u64)
/// * `Disabled`     when spill is off — no `statvfs` call, no clamp.
///
        Some(a) => a,
        // - Operator override SHOULD fire (RSS < 85% threshold)
                resident,
    use std::ffi::CString;
/// settings change. Thread-safe (atomic stores).
        let spill_result = should_override(pool_at_midpoint, OverrideContext::Execution);
    fn should_override_uses_resident_not_allocated() {
pub fn set_thresholds(thresholds: MemoryThresholds) {
        assert_eq!(spill_exempt_cap_bytes(), 0);
pub fn set_spill_dir(path: &str) {
/// earlier — that path is recoverable. This path fires only when spill was already
    #[test]
    );
        assert!((t.admission_throttle - 0.75).abs() < 0.001);
    fn skip_for_small_pools() {
    EXECUTION_CRITICAL_X1000.store(
        let large_pool = 1024 * 1024 * 1024 * 1024; // 1TB
    if pool_limit_bytes < MIN_POOL_FOR_OVERRIDE {
        let second = cached_resident_bytes();
        // typically uses 50-200MB RSS.
        // to 0 rather than wrap to a huge u64.
    #[test]
/// * `Available(n)` when spill is on and disk is healthy.
        set_spill_exempt_cap_bytes(0);
}
        }
pub fn set_spill_exempt_cap_bytes(bytes: u64) {
static EXECUTION_SPILL_X1000: AtomicU64 = AtomicU64::new(850);
    }
/// Check whether jemalloc says physical memory has headroom, meaning the
// ---------------------------------------------------------------------------
        if resident <= 0 {
/// Minimum pool size (bytes) for jemalloc override to activate.
pub fn should_cancel_query(pool_limit_bytes: usize) -> bool {
        }
        // admission: resident (77%) >= threshold (70%) → NOT below → override = false
        execution_critical: EXECUTION_CRITICAL_X1000.load(Ordering::Acquire) as f64 / 1000.0,
}
        if pool_at_midpoint < MIN_POOL_FOR_OVERRIDE {
static EXECUTION_CRITICAL_X1000: AtomicU64 = AtomicU64::new(950);
    fn cached_resident_bytes_is_stable_within_interval() {
        // The FFI export takes a signed i64 (Java long); negative inputs must clamp
// stay below the 95% limit. Default 512MB.
            "cached_resident_bytes() should never return negative, got {}",
        return false;
    fn set_and_get_spill_exempt_cap() {
    let cached = CACHED_RESIDENT.load(Ordering::Relaxed);
///
        // Zero is valid (disables the exemption budget).
        );
//! `epoch.advance()` calls on the hot path while keeping the memory picture
    if pool_limit_bytes < MIN_POOL_FOR_OVERRIDE {
            spill_result,
        return false;
    let threshold_bytes = (pool_limit_bytes as u64).saturating_mul(threshold_x1000) / 1000;
}
const RESIDENT_CACHE_INTERVAL_MS: u64 = 100;
    }
    SPILL_ENABLED.store(false, Ordering::Release);
        let t = get_thresholds();
}
    let last = LAST_CHECK_MS.load(Ordering::Relaxed);
                return fresh;
    CACHED_RESIDENT.load(Ordering::Relaxed)
            assert!(is_memory_pressured(small_pool));
pub fn is_memory_pressured(pool_limit_bytes: usize) -> bool {
        return SpillBudget::Critical;
            resident >= 0,
    pub execution_critical: f64,
            execution_spill: 0.90,
        // At 77% utilization: admission (75%) should NOT override, operator (85%) SHOULD override
        // Restore default.
    if resident <= 0 {
        assert!(!should_cancel_query(1_000_000)); // 1MB
        / 1000;
            return; // jemalloc not available in this test env
    let budget = available * fraction_x1000 / 1000;
    #[test]
    if now_ms.wrapping_sub(last) >= RESIDENT_CACHE_INTERVAL_MS {
        (thresholds.execution_critical * 1000.0) as u64,
    #[test]
        // Only assert if RSS actually exceeds the critical threshold
/// Used by `per_query_spill_budget` to short-circuit before touching `SPILL_DIR` so
        }
        // With a 1TB pool, current process RSS is far below 70% → not pressured
        let resident = cached_resident_bytes();
/// when DataFusion is built with `DiskManagerMode::Directories`).
            "Two immediate calls should return the same cached value"
static SPILL_DIR: std::sync::OnceLock<String> = std::sync::OnceLock::new();
pub fn spill_exempt_cap_bytes() -> usize {
    }
        let resident = native_bridge_common::allocator::resident_bytes();
        // Set pool limit to something well below current process RSS.
/// Cost: one `statvfs` syscall (~1µs) only when spill is enabled. Called once per
            "At 77% RSS, spill override SHOULD fire (threshold 85%)"
// be allowed through the 85% check at the same time, so several spills together
// --- Cached RSS ---
    // If last known value was above spill threshold, bypass cache and read fresh.
/// query at admission.
    if cached > 0 {
/// Returns `true` if RSS exceeds the critical threshold — the query should be
        assert!((t.admission_throttle - 0.60).abs() < 0.001);
/// Read current thresholds.
    SPILL_ENABLED.store(true, Ordering::Release);
        let t = MemoryThresholds::default();
            return; // jemalloc not available
    let c_path = CString::new(path).ok()?;
        }
const MIN_POOL_FOR_OVERRIDE: usize = 16 * 1024 * 1024; // 16MB
            first, second,
 *
            "At 77% RSS, admission override should NOT fire (threshold 70%)"
        // (only one thread per interval refreshes the cache).
    /// Admission-time: deciding whether to reduce target_partitions.
        crate::ffm::df_set_spill_exempt_cap_bytes(256 * 1024 * 1024);
    pub admission_throttle: f64,
 * this file be licensed under the Apache-2.0 license or a
/// # Arguments
        assert!(!should_override(1_000_000, OverrideContext::Execution));
        assert!((t.execution_spill - 0.85).abs() < 0.001);
            admission_throttle: 0.60,
    EXECUTION_SPILL_X1000.store(
/// the pool rejected, jemalloc confirms pressure, and spill alone can't recover
            let r = native_bridge_common::allocator::resident_bytes();
    #[test]
    }
        // so override should fire (resident < threshold = "headroom available")
            return r;
    }
        assert!(!is_memory_pressured(1_000_000)); // 1MB — below MIN_POOL_FOR_OVERRIDE
static SPILL_EXEMPT_CAP_BYTES: AtomicU64 = AtomicU64::new(512 * 1024 * 1024);
//!
    }
/// attempted or cannot help.
/// Fraction of available disk to allow per query (×1000 for atomic integer storage).
impl Default for MemoryThresholds {
        assert!(
        // process RSS should exceed 95% of 20MB = 19MB. A Rust test process
/// `allocated_bytes` undercounts true memory pressure because jemalloc retains
        if resident <= 0 {
}
    }
            result,
        // Pool below 16MB → always returns false (no override)
///
            .is_ok()
        // Operator threshold (85%) is more permissive than admission (75%).
    #[test]
        assert!(!should_cancel_query(15 * 1024 * 1024)); // 15MB
use std::time::Instant;
        let small_pool = 20 * 1024 * 1024; // 20MB — above MIN_POOL_FOR_OVERRIDE
            execution_spill: 0.85,
/// Set the spill directory and mark spill enabled (called once from create_global_runtime
                should_cancel_query(small_pool),
    fn is_memory_pressured_true_when_rss_exceeds_limit() {
            "With 1TB pool limit, resident should be well below threshold — override should fire"
///
    fn cached_resident_bytes_returns_non_negative() {
/*
///
/// Whether spill is enabled at runtime construction. Stays `false` when DataFusion
/// Returns:
    }
}
/// concurrency early — before any hash table allocation occurs. This prevents
        assert!((t.execution_critical - 0.95).abs() < 0.001);
    SpillBudget::Available(budget)
    SPILL_EXEMPT_CAP_BYTES.store(bytes, Ordering::Release);
        return false;
/// the "20 queries all pass admission simultaneously" burst that causes OOM.
            CACHED_RESIDENT.store(r, Ordering::Relaxed);
///
        return SpillBudget::Disabled;
// Total byte budget for the spill-gate exemption (see
            resident
    fn is_memory_pressured_false_for_large_pool() {
/// fast enough. Cancel the query to protect the node.
        set_thresholds(MemoryThresholds {
pub fn available_disk_space(path: &str) -> Option<u64> {
        assert!(!should_override(1_000_000, OverrideContext::Admission));
/// Configurable memory thresholds.
 * compatible open source license.
    }
    #[test]
            admission_throttle: 0.75,
        // that the thresholds are read correctly by setting them and checking
}
//! All RSS checks go through [`cached_resident_bytes()`] — a single source of
        // should always be exceeded.
    let fraction_x1000 = DISK_FRACTION_X1000.load(Ordering::Acquire);
    use std::mem::MaybeUninit;
        let limit = pool_limit_for_guard();
static SPILL_ENABLED: AtomicBool = AtomicBool::new(false);
        // A positive value passes through unchanged.
//!
}
        OverrideContext::Admission => ADMISSION_REJECT_X1000.load(Ordering::Acquire),
    fn is_memory_pressured_skips_small_pools() {
    fn should_cancel_query_true_when_rss_exceeds_limit() {
/// the disabled path doesn't masquerade as "disk dying" and clamp parallelism.
    }
        return false;
        .saturating_mul(EXECUTION_CRITICAL_X1000.load(Ordering::Acquire))
///
    if budget < 64 * 1024 * 1024 {
            return; // jemalloc not active in this test env (CI)
pub enum SpillBudget {
}
            return;
/// (which allows spill sort buffers to allocate). The cost of a fresh read (~1-5µs)
        // Two calls within <100ms should return the same cached value
/// Set the spill-gate exemption byte cap at runtime.
        // Returns > 0 when jemalloc is active, 0 when not (CI may not link jemalloc)
    }
    if resident <= 0 {
/// is built with `DiskManagerMode::Disabled` (i.e. `datafusion.spill_directory` unset).
    Critical,
use std::sync::atomic::{AtomicBool, AtomicI64, AtomicU64, Ordering};
        None => return SpillBudget::Critical,
        assert!(!is_memory_pressured(large_pool));
        let small_pool = 20 * 1024 * 1024; // 20MB
    SPILL_EXEMPT_CAP_BYTES.load(Ordering::Acquire) as usize
/// workloads, the gap between allocated and resident can be 10-20GB, causing the
static POOL_LIMIT_FOR_GUARD: AtomicI64 = AtomicI64::new(0);
        assert_eq!(spill_exempt_cap_bytes(), 64 * 1024 * 1024);
        crate::ffm::df_set_spill_exempt_cap_bytes(-1);
    #[test]
        set_thresholds(MemoryThresholds::default());
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
/// Returns jemalloc resident bytes, cached for up to 100ms on the happy path.
/// freed pages in thread caches and arenas (dirty/muzzy decay). Under concurrent
        Ordering::Release,
        Some(d) => d,
        assert!(
    /// RSS above this → force spill + disable override in try_grow. Default: 0.85
    if !SPILL_ENABLED.load(Ordering::Acquire) {
// ---------------------------------------------------------------------------
}
 * SPDX-License-Identifier: Apache-2.0
/// Returns the per-query spill budget based on available disk space.
            budget / (1024 * 1024),
    POOL_LIMIT_FOR_GUARD.store(limit, Ordering::Release);
            available / (1024 * 1024),
/// Per-query spill state, returned by `per_query_spill_budget`.
/// Current spill-gate exemption byte cap.
pub fn per_query_spill_budget() -> SpillBudget {
        if resident <= 0 {
    Available(u64),
    let critical_bytes = (pool_limit_bytes as u64)
        log::warn!(
    };
        );
    }
}
    fn should_cancel_query_false_for_small_pools() {
    }
        (thresholds.admission_throttle * 1000.0) as u64,
///
}
pub fn cached_resident_bytes() -> i64 {
/// * `Critical`     when spill is on but the spill volume is dangerously low
///
                "should_cancel_query should return true when RSS ({}) exceeds 95% of pool ({})",
/// * `Critical`     — spill is on but available disk is dangerously low; clamp to 1.
mod tests {
 */
        }
/// Returns `false` if pressure is real or stats are unavailable.
            .compare_exchange(last, now_ms, Ordering::Relaxed, Ordering::Relaxed)
    #[test]
        let admission_result = should_override(pool_at_midpoint, OverrideContext::Admission);
    #[test]
        // Pools below MIN_POOL_FOR_OVERRIDE (16MB) always return false
                let fresh = native_bridge_common::allocator::resident_bytes();
            return; // jemalloc not available in this test env
///
    }
    fn override_respects_spill_vs_admission_threshold() {
/// cancelled. This is the last-resort path (post-CAS-fail, post-override-denied):
    pub admission_reject: f64,
/// Set the memory thresholds at runtime. Called from Java when cluster
    MemoryThresholds {
        });
        }
    Execution,
}
}
    fn ffi_spill_exempt_cap_clamps_negative_to_zero() {
    if resident <= 0 {
    }
/// Admission thresholds control who gets in.
    ADMISSION_THROTTLE_X1000.store(
        let resident = native_bridge_common::allocator::resident_bytes();
        assert_eq!(
/// Called once at runtime creation.
// Configurable thresholds stored as fixed-point (×1000) in atomics.
static CACHED_RESIDENT: AtomicI64 = AtomicI64::new(0);
    }
    #[test]
/// is acceptable under pressure since it only fires when memory is elevated.
// `DynamicLimitPool::try_grow`). Limits how much memory spillable consumers can
    }
/// override to fire when the system is actually near OOM.
                CACHED_RESIDENT.store(fresh, Ordering::Relaxed);
    resident >= critical_bytes as i64
    let spill_dir = match SPILL_DIR.get() {
        set_spill_exempt_cap_bytes(512 * 1024 * 1024);
    }
static ADMISSION_REJECT_X1000: AtomicU64 = AtomicU64::new(850);
//! consistent across all decision layers (hard guard, override, cancel, admission).
        }
/// already exceeds the admission threshold (70% of pool limit by default).
        //
/// Stored spill directory path. Set once at runtime creation.
        assert!((t.execution_critical - 0.97).abs() < 0.001);
    );
    // SPILL_DIR first — but a defensive `match` keeps this safe even if call ordering
            );
pub struct MemoryThresholds {
/// artificial limits — never override.
        if resident >= critical_bytes {
    }
        // operator: resident (77%) < threshold (85%) → below → override = true
    fn default() -> Self {
    }
    );
        if resident as usize > small_pool * 70 / 100 {
        execution_spill: EXECUTION_SPILL_X1000.load(Ordering::Acquire) as f64 / 1000.0,
        (thresholds.execution_spill * 1000.0) as u64,
        if resident <= 0 {
    let ret = unsafe { libc::statvfs(c_path.as_ptr(), stat.as_mut_ptr()) };
        assert!((t.execution_spill - 0.90).abs() < 0.001);
        // behavior with known pool sizes.
    }
            admission_reject: 0.80,
        assert!(
        // Set pool limit so that resident is exactly between 70% and 85%
    if pool_limit_bytes < MIN_POOL_FOR_OVERRIDE {
    // Happy path: return cached value, refresh if interval elapsed.
    let now_ms = base.elapsed().as_millis() as u64;
    Admission,
    POOL_LIMIT_FOR_GUARD.load(Ordering::Relaxed)
// Initialized to u64::MAX so the first call always refreshes (any now_ms - MAX wraps to > 100).
// Disk spill budget: proactive disk pressure check
        }
/// Below this, the pool is assumed to be a unit test / benchmark with
        // A Rust test process typically uses 50-200MB RSS, so a 20MB limit
/// admission, not per-batch.
    let resident = cached_resident_bytes();
    /// RSS above this → reject new queries (429). Default: 0.85
//! Thresholds are configurable at runtime via `set_thresholds`.
}
/// Called BEFORE query execution (at budget acquisition) to reject or reduce
            execution_critical: 0.95,
        if limit > 0 {
/// pool's rejection is a false positive (stale accounting).
    // SPILL_ENABLED is only set to true by `set_spill_dir`, which always populates
 * The OpenSearch Contributors require contributions made to
pub fn mark_spill_disabled() {
/// On the happy path (RSS below threshold), only one thread per 100ms interval pays
            if cached >= threshold {
        // With a large pool (1TB), resident will always be below threshold
        // Only assert if RSS is actually above 70% of 20MB = 14MB (which it will be)
    }
        Ordering::Release,
        None => return SpillBudget::Critical,
/// Proactive admission check: returns `true` if jemalloc resident memory
    pub execution_spill: f64,
    };
    use super::*;
        // 64MB minimum viable spill
    /// RSS above this → hard guard rejects (pre-CAS) + cancel (post-CAS). Default: 0.95
        // pool = resident / 0.77 (midpoint) → resident/pool ≈ 77%
        );
        Self {
/// Query available disk space for the given path.
}
        let resident = resident as usize;
pub fn available_disk_space(_path: &str) -> Option<u64> {
        // We can't precisely control RSS in a unit test, but we can verify
///
        let pool_at_midpoint = (resident as f64 / 0.77) as usize;
        // Restore defaults
/// The same critical threshold is used by the hard guard (pre-CAS) to force spill
    #[test]
