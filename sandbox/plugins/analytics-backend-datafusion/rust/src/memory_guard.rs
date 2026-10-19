/// When the cached value is above the spill threshold, bypasses the cache and
    if cached > 0 {
pub fn per_query_spill_budget() -> SpillBudget {
/// Minimum pool size (bytes) for jemalloc override to activate.
/// * `Critical`     when spill is on but the spill volume is dangerously low
        return false;
    if pool_limit_bytes < MIN_POOL_FOR_OVERRIDE {
    }
        assert!((t.execution_critical - 0.97).abs() < 0.001);
                small_pool
    if resident <= 0 {
        );
/// Uses `resident_bytes` (physical RSS) instead of `allocated_bytes` (live objects).
        if resident >= critical_bytes {
        let resident = native_bridge_common::allocator::resident_bytes();
    #[test]
/// Proactive admission check: returns `true` if jemalloc resident memory
    pub execution_spill: f64,
    let critical_bytes = (pool_limit_bytes as u64)
/// Mark spill explicitly disabled (called once from create_global_runtime when
/// * `Disabled`     — spill is off; parallelism MUST NOT be clamped (no spill = no risk).
/// workloads, the gap between allocated and resident can be 10-20GB, causing the
        let admission_result = should_override(pool_at_midpoint, OverrideContext::Admission);
//! `epoch.advance()` calls on the hot path while keeping the memory picture
    let last = LAST_CHECK_MS.load(Ordering::Relaxed);
///
    #[test]
    fn should_cancel_query_true_when_rss_exceeds_limit() {
static CACHED_RESIDENT: AtomicI64 = AtomicI64::new(0);
    }
/*
    fn override_respects_spill_vs_admission_threshold() {
    #[test]
        // - Admission override should NOT fire (RSS >= 70% threshold)
    fn skip_for_small_pools() {
    resident < threshold_bytes as i64
        // Returns > 0 when jemalloc is active, 0 when not (CI may not link jemalloc)
}
        // Two calls within <100ms should return the same cached value
    fn should_override_uses_resident_not_allocated() {
        }
use std::time::Instant;
///
        // With a 1TB pool, current process RSS is far below 70% → not pressured
    let available = match available_disk_space(spill_dir) {
#[cfg(not(unix))]
///
        }
    SPILL_ENABLED.store(true, Ordering::Release);
    let now_ms = base.elapsed().as_millis() as u64;
}
            );
        let resident = resident as usize;
    fn ffi_spill_exempt_cap_clamps_negative_to_zero() {
    if ret != 0 {
        Some(d) => d,
    }
            execution_spill: 0.90,
/// query at admission.
/// override to fire when the system is actually near OOM.
        assert!(!should_cancel_query(8 * 1024 * 1024)); // 8MB
    }
        OverrideContext::Admission => ADMISSION_REJECT_X1000.load(Ordering::Acquire),
fn pool_limit_for_guard() -> i64 {
#[derive(Debug, Clone, Copy)]
        assert!(!is_memory_pressured(large_pool));
/// admission, not per-batch.
    let threshold_x1000 = ADMISSION_THROTTLE_X1000.load(Ordering::Acquire);
    MemoryThresholds {
        assert_eq!(spill_exempt_cap_bytes(), 64 * 1024 * 1024);
            "With 1TB pool limit, resident should be well below threshold — override should fire"
        // Default is 512MB.
    }
    fn default() -> Self {
        // Round-trips an arbitrary value.
    }
                let fresh = native_bridge_common::allocator::resident_bytes();
        // A Rust test process typically uses 50-200MB RSS, so a 20MB limit
/// earlier — that path is recoverable. This path fires only when spill was already
    #[test]
/// # Arguments
    fn set_and_get_spill_exempt_cap() {
        });
        let resident = cached_resident_bytes();
    let stat = unsafe { stat.assume_init() };
        return false;
        }
    if resident <= 0 {
/// the epoch.advance() cost; all others get the cached value in <1ns.
    let threshold_x1000 = match context {
}
    let ret = unsafe { libc::statvfs(c_path.as_ptr(), stat.as_mut_ptr()) };
pub fn set_spill_dir(path: &str) {
        if limit > 0 {
/// Used by `per_query_spill_budget` to short-circuit before touching `SPILL_DIR` so
        }
        // Zero is valid (disables the exemption budget).
        assert!(!should_cancel_query(15 * 1024 * 1024)); // 15MB
    #[test]
            "cached_resident_bytes() should never return negative, got {}",
        // With a 20MB pool limit (above MIN_POOL_FOR_OVERRIDE), the current test
            assert!(
///
/// Cost: one `epoch.advance` + stat read (~1-5µs). Called once per query at
                should_cancel_query(small_pool),
        // We can't precisely control RSS in a unit test, but we can verify
/// Returns the per-query spill budget based on available disk space.
//! truth refreshed at most once per 100ms. This avoids expensive jemalloc
/// concurrency early — before any hash table allocation occurs. This prevents
/// attempted or cannot help.
    POOL_LIMIT_FOR_GUARD.store(limit, Ordering::Release);
    // Happy path: return cached value, refresh if interval elapsed.
 * this file be licensed under the Apache-2.0 license or a
        // Only assert if RSS is actually above 70% of 20MB = 14MB (which it will be)
    };
        // admission: resident (77%) >= threshold (70%) → NOT below → override = false
        assert!(!should_override(1_000_000, OverrideContext::Execution));
                return fresh;
    SPILL_EXEMPT_CAP_BYTES.store(bytes, Ordering::Release);
static SPILL_ENABLED: AtomicBool = AtomicBool::new(false);
// `DynamicLimitPool::try_grow`). Limits how much memory spillable consumers can
/// Called BEFORE query execution (at budget acquisition) to reject or reduce
    }
///
    }
    #[test]
            execution_critical: 0.97,
    let c_path = CString::new(path).ok()?;
        crate::ffm::df_set_spill_exempt_cap_bytes(-1);
        if resident <= 0 {
static ADMISSION_REJECT_X1000: AtomicU64 = AtomicU64::new(850);
    // SPILL_DIR first — but a defensive `match` keeps this safe even if call ordering
        Ordering::Release,
        crate::ffm::df_set_spill_exempt_cap_bytes(256 * 1024 * 1024);
/// returning a phantom "disk pressure" signal driven by an unset `SPILL_DIR`.
static LAST_CHECK_MS: AtomicU64 = AtomicU64::new(u64::MAX);
    if pool_limit_bytes < MIN_POOL_FOR_OVERRIDE {
}
    );
    Disabled,
    if pool_limit_bytes < MIN_POOL_FOR_OVERRIDE {
    };
    #[test]
        None => return SpillBudget::Critical,
/// the "20 queries all pass admission simultaneously" burst that causes OOM.
pub fn set_thresholds(thresholds: MemoryThresholds) {
        let small_pool = 20 * 1024 * 1024; // 20MB — above MIN_POOL_FOR_OVERRIDE
            first, second,
/// Per-query spill state, returned by `per_query_spill_budget`.
        // Operator threshold (85%) is more permissive than admission (75%).
            "[disk-pressure] Spill budget too low: {} MB (available={} MB)",
        / 1000;
static ADMISSION_THROTTLE_X1000: AtomicU64 = AtomicU64::new(750);
        assert!((t.admission_throttle - 0.75).abs() < 0.001);
/// Returns `false` if pressure is real or stats are unavailable.
}
        if resident <= 0 {
/// Check whether jemalloc says physical memory has headroom, meaning the
/// pool's rejection is a false positive (stale accounting).
        // The FFI export takes a signed i64 (Java long); negative inputs must clamp
        let first = cached_resident_bytes();
/// The same critical threshold is used by the hard guard (pre-CAS) to force spill
            "At 77% RSS, spill override SHOULD fire (threshold 85%)"
    SpillBudget::Available(budget)
    }
        execution_spill: EXECUTION_SPILL_X1000.load(Ordering::Acquire) as f64 / 1000.0,
}
mod tests {
        set_thresholds(MemoryThresholds::default());
        set_spill_exempt_cap_bytes(512 * 1024 * 1024);
/// Below this, the pool is assumed to be a unit test / benchmark with
    // SPILL_ENABLED is only set to true by `set_spill_dir`, which always populates
        // Set pool limit so that resident is exactly between 70% and 85%
}
    SPILL_EXEMPT_CAP_BYTES.load(Ordering::Acquire) as usize
 * compatible open source license.
        // Only assert if RSS actually exceeds the critical threshold
    Available(u64),
        // operator: resident (77%) < threshold (85%) → below → override = true
    fn is_memory_pressured_skips_small_pools() {
static DISK_FRACTION_X1000: AtomicU64 = AtomicU64::new(100); // 10% = 100/1000
        let t = MemoryThresholds::default();
/// settings change. Thread-safe (atomic stores).
    let budget = available * fraction_x1000 / 1000;
        assert!(!should_override(1_000_000, OverrideContext::Admission));
    /// Execution try_grow: deciding whether to allow despite pool rejection.
    #[test]
    }
    use super::*;
        OverrideContext::Execution => EXECUTION_SPILL_X1000.load(Ordering::Acquire),
        set_thresholds(MemoryThresholds {
        assert!((t.admission_throttle - 0.60).abs() < 0.001);
pub fn set_pool_limit_for_guard(limit: i64) {
// ---------------------------------------------------------------------------
/// Current spill-gate exemption byte cap.
            spill_result,
/// Read current thresholds.
}
        Self {
        Some(a) => a,
        }
 */
    };
pub fn should_cancel_query(pool_limit_bytes: usize) -> bool {
}
        // Pools below MIN_POOL_FOR_OVERRIDE (16MB) always return false
}
// --- Thresholds ---
        admission_reject: ADMISSION_REJECT_X1000.load(Ordering::Acquire) as f64 / 1000.0,
/// Configurable memory thresholds.
        // A positive value passes through unchanged.
    }
pub struct MemoryThresholds {
            execution_critical: 0.95,
///
            .compare_exchange(last, now_ms, Ordering::Relaxed, Ordering::Relaxed)
}
        // to 0 rather than wrap to a huge u64.
            let threshold = (limit as u64 * spill_x1000 / 1000) as i64;
pub fn spill_exempt_cap_bytes() -> usize {
    }
        return false;
    if budget < 64 * 1024 * 1024 {
    ADMISSION_THROTTLE_X1000.store(
    pub execution_critical: f64,
            !admission_result,
/// Admission thresholds control who gets in.
            assert!(is_memory_pressured(small_pool));
            execution_spill: 0.85,
/// fast enough. Cancel the query to protect the node.
        );
// Initialized to u64::MAX so the first call always refreshes (any now_ms - MAX wraps to > 100).
        set_spill_exempt_cap_bytes(0);
/// On the happy path (RSS below threshold), only one thread per 100ms interval pays
        Ordering::Release,
    }
    EXECUTION_CRITICAL_X1000.store(
        assert!(!is_memory_pressured(1_000_000)); // 1MB — below MIN_POOL_FOR_OVERRIDE
/// Returns `true` if the override should fire (proceed despite pool rejection).
        // Set pool limit to something well below current process RSS.
    fn cached_resident_bytes_is_stable_within_interval() {
        assert_eq!(
/// (which allows spill sort buffers to allocate). The cost of a fresh read (~1-5µs)
        }
 *
// --- Cached RSS ---
        set_spill_exempt_cap_bytes(512 * 1024 * 1024);
            "Two immediate calls should return the same cached value"
/// is acceptable under pressure since it only fires when memory is elevated.
        Ordering::Release,
    fn should_cancel_query_false_for_small_pools() {
        return SpillBudget::Critical;
/// Set the spill-gate exemption byte cap at runtime.
    #[test]
        // process RSS should exceed 95% of 20MB = 19MB. A Rust test process
        let small_pool = 20 * 1024 * 1024; // 20MB
        // 64MB minimum viable spill
    /// RSS above this → reduce parallelism for new queries. Default: 0.75
    }
    // ever changes.
///
        }
        if resident <= 0 {
    // A stale-high value would block the override and prevent spill from completing.
}
static SPILL_EXEMPT_CAP_BYTES: AtomicU64 = AtomicU64::new(512 * 1024 * 1024);
pub enum OverrideContext {
        // Restore default.
    }
        // so override should fire (resident < threshold = "headroom available")
static POOL_LIMIT_FOR_GUARD: AtomicI64 = AtomicI64::new(0);
    if now_ms.wrapping_sub(last) >= RESIDENT_CACHE_INTERVAL_MS {
    let threshold_bytes = (pool_limit_bytes as u64).saturating_mul(threshold_x1000) / 1000;
            return; // jemalloc not available
/// Returns `true` if RSS exceeds the critical threshold — the query should be
/// Called once at runtime creation.
        );
    }
/// Execution thresholds control what happens during the query.
/// Set the memory thresholds at runtime. Called from Java when cluster
    }
    }
}
        // Pool below 16MB → always returns false (no override)
/// already exceeds the admission threshold (70% of pool limit by default).
/// Three states make the call site unambiguous:
 * SPDX-License-Identifier: Apache-2.0
// Pool limit stored for the guard's threshold check. Set once from create_global_runtime.
    if resident <= 0 {
///
/// Set the pool limit used by the cached RSS pressure check.
/// is built with `DiskManagerMode::Disabled` (i.e. `datafusion.spill_directory` unset).
        if pool_at_midpoint < MIN_POOL_FOR_OVERRIDE {
    }
        None => return SpillBudget::Critical,
    /// RSS above this → hard guard rejects (pre-CAS) + cancel (post-CAS). Default: 0.95
    let fraction_x1000 = DISK_FRACTION_X1000.load(Ordering::Acquire);
            available / (1024 * 1024),
    POOL_LIMIT_FOR_GUARD.load(Ordering::Relaxed)
#[cfg(unix)]
// Total byte budget for the spill-gate exemption (see
    }
    let _ = SPILL_DIR.set(path.to_string());
    }
            resident >= 0,
            let r = native_bridge_common::allocator::resident_bytes();
    // If last known value was above spill threshold, bypass cache and read fresh.
    resident >= threshold_bytes as i64
/// DataFusion is built with `DiskManagerMode::Disabled`). This makes the disabled
    let threshold_bytes = (pool_limit_bytes as u64).saturating_mul(threshold_x1000) / 1000;
        assert!(!should_cancel_query(1_000_000)); // 1MB
        (thresholds.execution_spill * 1000.0) as u64,
    use std::mem::MaybeUninit;
static EXECUTION_SPILL_X1000: AtomicU64 = AtomicU64::new(850);
    ADMISSION_REJECT_X1000.store(
///
    resident >= critical_bytes as i64
        let result = should_override(large_pool, OverrideContext::Execution);
/// the pool rejected, jemalloc confirms pressure, and spill alone can't recover
}
    if !SPILL_ENABLED.load(Ordering::Acquire) {
}
    let resident = cached_resident_bytes();
    /// Admission-time: deciding whether to reduce target_partitions.
        // should always be exceeded.
    pub admission_reject: f64,
        let large_pool = 1024 * 1024 * 1024 * 1024; // 1TB
    let resident = cached_resident_bytes();
//! consistent across all decision layers (hard guard, override, cancel, admission).
        (thresholds.admission_reject * 1000.0) as u64,
    let mut stat = MaybeUninit::<libc::statvfs>::uninit();
use std::sync::atomic::{AtomicBool, AtomicI64, AtomicU64, Ordering};
pub fn available_disk_space(_path: &str) -> Option<u64> {
            .is_ok()
        // Restore defaults
            }
        (thresholds.execution_critical * 1000.0) as u64,
pub enum SpillBudget {
        // With a large pool (1TB), resident will always be below threshold
pub fn mark_spill_disabled() {
/// artificial limits — never override.
        assert!((t.execution_spill - 0.90).abs() < 0.001);
const RESIDENT_CACHE_INTERVAL_MS: u64 = 100;
    let resident = cached_resident_bytes();
        // - Operator override SHOULD fire (RSS < 85% threshold)
    #[test]
/// when DataFusion is built with `DiskManagerMode::Directories`).
                "should_cancel_query should return true when RSS ({}) exceeds 95% of pool ({})",
///
impl Default for MemoryThresholds {
        // typically uses 50-200MB RSS.
    Critical,
        assert_eq!(spill_exempt_cap_bytes(), 0);
        assert_eq!(spill_exempt_cap_bytes(), 256 * 1024 * 1024);
            return; // jemalloc not available in this test env
        let critical_bytes = (small_pool as f64 * 0.95) as i64;
        let spill_result = should_override(pool_at_midpoint, OverrideContext::Execution);
static EXECUTION_CRITICAL_X1000: AtomicU64 = AtomicU64::new(950);
// stay below the 95% limit. Default 512MB.
            admission_throttle: 0.60,
        //
        admission_throttle: ADMISSION_THROTTLE_X1000.load(Ordering::Acquire) as f64 / 1000.0,
    None
        return None;
// Configurable thresholds stored as fixed-point (×1000) in atomics.
        let resident = native_bridge_common::allocator::resident_bytes();
        execution_critical: EXECUTION_CRITICAL_X1000.load(Ordering::Acquire) as f64 / 1000.0,
            "At 77% RSS, admission override should NOT fire (threshold 70%)"
        return SpillBudget::Disabled;
        if resident as usize > small_pool * 70 / 100 {
/// Query available disk space for the given path.
pub fn should_override(pool_limit_bytes: usize, context: OverrideContext) -> bool {
            budget / (1024 * 1024),
    use std::ffi::CString;
/// Whether spill is enabled at runtime construction. Stays `false` when DataFusion
    /// RSS above this → reject new queries (429). Default: 0.85
// Disk spill budget: proactive disk pressure check
/// cancelled. This is the last-resort path (post-CAS-fail, post-override-denied):
        // Restore default.
        }
/// `allocated_bytes` undercounts true memory pressure because jemalloc retains
    #[test]
    let cached = CACHED_RESIDENT.load(Ordering::Relaxed);
    EXECUTION_SPILL_X1000.store(
        // At 77% utilization: admission (75%) should NOT override, operator (85%) SHOULD override
}
/// freed pages in thread caches and arenas (dirty/muzzy decay). Under concurrent
    SPILL_ENABLED.store(false, Ordering::Release);
        // pool = resident / 0.77 (midpoint) → resident/pool ≈ 77%
    );
        assert_eq!(spill_exempt_cap_bytes(), 0);
    let spill_dir = match SPILL_DIR.get() {
            if cached >= threshold {
        (thresholds.admission_throttle * 1000.0) as u64,
pub fn cached_resident_bytes() -> i64 {
        }
    /// RSS above this → force spill + disable override in try_grow. Default: 0.85
/// - `pool_limit_bytes`: the pool's configured limit
        log::warn!(
//! All RSS checks go through [`cached_resident_bytes()`] — a single source of
        return false;
    Admission,
        let t = get_thresholds();
            resident
/// - `context`: which layer is asking (determines threshold)
/// Which layer is asking for the override check.
        assert!(
        let large_pool = 1024 * 1024 * 1024 * 1024; // 1TB
    );
static EPOCH_BASE: std::sync::OnceLock<Instant> = std::sync::OnceLock::new();
//!
}
    CACHED_RESIDENT.load(Ordering::Relaxed)
    }
        );
}
        assert!(
/// Stored spill directory path. Set once at runtime creation.
    Some(stat.f_bavail as u64 * stat.f_frsize as u64)
///
        // that the thresholds are read correctly by setting them and checking
//!
        );
/// * `Critical`     — spill is on but available disk is dangerously low; clamp to 1.
/// Cost: one `statvfs` syscall (~1µs) only when spill is enabled. Called once per
            return; // jemalloc not active in this test env (CI)
}
// be allowed through the 85% check at the same time, so several spills together
static SPILL_DIR: std::sync::OnceLock<String> = std::sync::OnceLock::new();
/// * `Available(n)` when spill is on and disk is healthy.
const MIN_POOL_FOR_OVERRIDE: usize = 16 * 1024 * 1024; // 16MB
            admission_reject: 0.80,
        }
        return false;
    }
/// * `Disabled`     when spill is off — no `statvfs` call, no clamp.
        // (only one thread per interval refreshes the cache).
        assert!((t.execution_critical - 0.95).abs() < 0.001);
pub fn set_spill_exempt_cap_bytes(bytes: u64) {
///                  (< 64MB after the fraction, or `statvfs` failed). Caller clamps to 1.
        assert!((t.execution_spill - 0.85).abs() < 0.001);
        );
    }
    }
/// Fraction of available disk to allow per query (×1000 for atomic integer storage).
pub fn is_memory_pressured(pool_limit_bytes: usize) -> bool {
//! Thresholds are configurable at runtime via `set_thresholds`.
}
        assert!(
    );
            return;
        assert_eq!(spill_exempt_cap_bytes(), 512 * 1024 * 1024);
        Ordering::Release,
/// Formula: `10% of available_disk` for the `Available` case.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
                resident,
//! Unified jemalloc-based memory guard for pool override decisions.
/// reads fresh — because a stale-high value can incorrectly block the override
            result,
///
        let pool_at_midpoint = (resident as f64 / 0.77) as usize;
        // behavior with known pool sizes.
/// the disabled path doesn't masquerade as "disk dying" and clamp parallelism.
        let limit = pool_limit_for_guard();
    let base = EPOCH_BASE.get_or_init(Instant::now);
        if LAST_CHECK_MS
        set_spill_exempt_cap_bytes(64 * 1024 * 1024);
    }
    fn is_memory_pressured_false_for_large_pool() {
/// Set the spill directory and mark spill enabled (called once from create_global_runtime
/// Returns jemalloc resident bytes, cached for up to 100ms on the happy path.
            return r;
    #[test]
        if resident <= 0 {
// ---------------------------------------------------------------------------
                CACHED_RESIDENT.store(fresh, Ordering::Relaxed);
            CACHED_RESIDENT.store(r, Ordering::Relaxed);
        assert!(
    #[test]
    #[test]
#[cfg(test)]
            return; // jemalloc not available in this test env
///
    fn cached_resident_bytes_returns_non_negative() {
#[derive(Debug, Clone, Copy)]
    }
pub fn get_thresholds() -> MemoryThresholds {
pub fn available_disk_space(path: &str) -> Option<u64> {
/// Returns:
    fn is_memory_pressured_true_when_rss_exceeds_limit() {
            admission_throttle: 0.75,
        let spill_x1000 = EXECUTION_SPILL_X1000.load(Ordering::Relaxed);
        // For a pool where RSS is between 70% and 85%:
    fn default_thresholds() {
        .saturating_mul(EXECUTION_CRITICAL_X1000.load(Ordering::Acquire))
        return false;
        let second = cached_resident_bytes();
/// state explicit so `per_query_spill_budget` returns `Disabled` instead of
    fn set_and_get_thresholds() {
        let resident = cached_resident_bytes();
    pub admission_throttle: f64,
 * The OpenSearch Contributors require contributions made to
    Execution,
        let resident = native_bridge_common::allocator::resident_bytes();
/// * `Available(n)` — spill is on and disk is healthy; full parallelism + per-query budget.
            admission_reject: 0.85,
        {
