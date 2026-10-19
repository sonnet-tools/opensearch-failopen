        inc_native_search_task_total();
        inc_native_search_shard_task_total();
// ---------------------------------------------------------------------------
//! All operations use `Ordering::Relaxed` since cross-counter ordering is not
        assert_eq!(rc, 0);
// ---------------------------------------------------------------------------
 *
/// beyond the threshold duration.
    #[test]
        return -1;
#[cfg(test)]
    #[test]
}
// ---------------------------------------------------------------------------
pub(crate) static NATIVE_SEARCH_TASK_TOTAL: AtomicI64 = AtomicI64::new(0);
///   [24..32) native_search_shard_task_total
        assert_eq!(rc, -1);
        // vals[3] = shard total — should be baseline + 1
        setup();
        assert_eq!(rc, 0);
        let baseline: [i64; 4] = unsafe { std::ptr::read(buf.as_ptr() as *const [i64; 4]) };
    #[test]
// ---------------------------------------------------------------------------
/// Increments the total count of native search shard tasks that executed post-cancellation
 * compatible open source license.
///
/// # Safety
/// `current` counts are computed by scanning the live query registry.
//! `DfStatsBuffer` and `NODE_STATS_CACHE` used for plugin stats.
    }
    fn test_df_native_node_stats_total_counters() {
        setup();
    fn test_inc_native_search_task_total() {
// ---------------------------------------------------------------------------
    fn test_inc_native_search_shard_task_total() {
/// Increments the total count of native search tasks that executed post-cancellation
    std::ptr::copy_nonoverlapping(vals.as_ptr() as *const u8, out_ptr, 32);
    // if a query drops between our total read and scan, it increments total (which
/// `total` counts come from the atomic counters (incremented on query drop).
    #[test]
mod tests {
        inc_native_search_shard_task_total();
pub unsafe extern "C" fn df_native_node_stats(out_ptr: *mut u8, out_cap: i64) -> i64 {
/*
}
 */
}
// ---------------------------------------------------------------------------
        shard_total + shard_current,
    }
#[no_mangle]
/// `out_ptr` must point to a valid buffer of at least `out_cap` bytes.
//! These counters track native search tasks and native search shard tasks that
pub(crate) static NATIVE_SEARCH_SHARD_TASK_TOTAL: AtomicI64 = AtomicI64::new(0);
}
    let shard_total = NATIVE_SEARCH_SHARD_TASK_TOTAL.load(Ordering::Relaxed);
    }
        let rc = unsafe { df_native_node_stats(buf.as_mut_ptr(), 32) };
        assert_eq!(rc, -1);
//! required — each counter is independently meaningful.
        let vals: [i64; 4] = unsafe { std::ptr::read(buf.as_ptr() as *const [i64; 4]) };
// Test helpers (for resetting counters in tests)
///   [16..24) native_search_shard_task_current
    fn test_df_native_node_stats_accepts_larger_buffer() {
        let rc = unsafe { df_native_node_stats(buf.as_mut_ptr(), 32) };
        let mut buf = [0u8; 32];
        assert_eq!(vals[3], baseline[3] + 1);
    // won't find it). Worst case: transient undercount by 1, self-corrects next read.
    NATIVE_SEARCH_SHARD_TASK_TOTAL.store(0, Ordering::Relaxed);
    0
    use super::*;
    #[test]
        coordinator_total + coordinator_current,
#[cfg(test)]
    use crate::query_tracker;
        assert_eq!(rc, 0);
        reset_all_counters();
/// Reads task cancellation stats and writes them as `[i64; 4]` to the caller buffer.
///   [8..16)  native_search_task_total
    // both the scan result AND the incremented total.
        setup();
        // vals[1] = coordinator total — should be baseline + 2
/// beyond the threshold duration.
        inc_native_search_task_total();
}
        inc_native_search_task_total();
    if (out_cap as usize) < 32 {
    // The reverse order (scan first, then total) would allow a query to appear in
// Total counters — incremented by QueryTrackingContext::drop() when a
        inc_native_search_task_total();
    // we already captured at the lower value) and leaves the registry (so the scan
// cancelled query ran past the threshold before completing.
    let coordinator_total = NATIVE_SEARCH_TASK_TOTAL.load(Ordering::Relaxed);
//!
use std::sync::atomic::{AtomicI64, Ordering};
        shard_current,
        let rc = unsafe { df_native_node_stats(buf.as_mut_ptr(), 16) };
//! continue executing after cancellation. They are completely independent of
        assert_eq!(NATIVE_SEARCH_TASK_TOTAL.load(Ordering::Relaxed), 0);
// ---------------------------------------------------------------------------
 * SPDX-License-Identifier: Apache-2.0
        let mut buf = [0u8; 32];
        assert_eq!(vals[1], baseline[1] + 2);
    NATIVE_SEARCH_SHARD_TASK_TOTAL.fetch_add(1, Ordering::Relaxed);
        assert_eq!(NATIVE_SEARCH_SHARD_TASK_TOTAL.load(Ordering::Relaxed), 0);
    let vals: [i64; 4] = [
    fn test_df_native_node_stats_rejects_zero_capacity() {
///   [0..8)   native_search_task_current
        // Read baseline (other tests may run in parallel and share globals)
    fn setup() {
//! Native node stats counters for task cancellation metrics.
    ];
    let (shard_current, coordinator_current) =
    fn test_total_counters_initialized_to_zero() {
    fn test_df_native_node_stats_rejects_small_buffer() {
/// Returns 0 on success, -1 if buffer too small.
pub(crate) fn reset_all_counters() {
        inc_native_search_task_total();
    }
        assert_eq!(NATIVE_SEARCH_TASK_TOTAL.load(Ordering::Relaxed), 3);
        let mut buf = [0u8; 16];
        let rc = unsafe { df_native_node_stats(buf.as_mut_ptr(), 64) };
    }
// Public increment functions for producers (called from query_tracker Drop)
        coordinator_current,
    NATIVE_SEARCH_TASK_TOTAL.store(0, Ordering::Relaxed);
        let rc = unsafe { df_native_node_stats(buf.as_mut_ptr(), 0) };
        query_tracker::count_cancelled_running(query_tracker::cancel_stats_threshold());
//!
        assert_eq!(NATIVE_SEARCH_SHARD_TASK_TOTAL.load(Ordering::Relaxed), 2);
    #[test]
    }
    }
    }
pub fn inc_native_search_shard_task_total() {
 * The OpenSearch Contributors require contributions made to
        inc_native_search_shard_task_total();
        setup();
///
// FFM entry point
pub fn inc_native_search_task_total() {
// ---------------------------------------------------------------------------
/// Buffer layout (32 bytes):
    #[test]
        let mut buf = [0u8; 64];
    }
    // Read totals FIRST, then scan registry. This ordering prevents double-counting:
 * this file be licensed under the Apache-2.0 license or a
    NATIVE_SEARCH_TASK_TOTAL.fetch_add(1, Ordering::Relaxed);
