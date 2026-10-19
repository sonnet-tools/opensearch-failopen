    }
            // Charge the exemption budget only now that the grow succeeded;
    const MB: usize = 1024 * 1024;
            }
        if crate::memory_guard::should_cancel_query(limit) {
                let handle = handle.clone();
}
                let _ = self
                if exempted {
pub(crate) fn spill_gate_decision(
pub struct DynamicLimitPool {
            let resident_usize = resident as usize;
        assert_eq!(handle.tripped_count(), 1);
        &self,
        Err(crate::native_error::pool_limit_error(
                    reservation.size(),
            dynamic_limit: limit,
            limit,
    #[test]
                reservation.size(),
            };
        handle.set_limit(4096);
        let (pool, handle) = new_pool(2048);
                reservation.consumer().name(),
        let used = self.used.load(Ordering::Relaxed);
    /// cannot exceed the cap. Increased when a request is exempted, decreased in
        // A request that fits the remaining 12 MB is allowed through.
        // 40MB room (512 - 472), 60MB request → rejected.
        assert_eq!(pool.reserved(), 100_000);
        assert!(reservation.try_grow(2048).is_ok());
        let (pool, handle) = new_pool(limit);
/*
            reservation.consumer().name(),
        let consumer = MemoryConsumer::new("large_pool_test");
/// The decision deliberately does not look at how many pages the allocator has
                (crate::memory_guard::get_thresholds().execution_critical * 100.0) as u32,
                ));
/// this code wrongly rejected the buffer ("Failed to reserve memory for sort
                    _ => {
                    .used
    Exempt,
            .used
        //   byte budget, and the pool-limit and 95% checks still apply, so this
    }
        // Consumer A takes 1500 bytes
        }
        // A buffer larger than the whole budget is still rejected.
    }
/// - Increasing the limit takes effect immediately for new allocations.
        // not finish. The decision now depends only on the budget.
            spill_gate_decision(true, 60 * MB, 512 * MB, 472 * MB),
            result.is_err(),
        // Create a pool with a huge limit (1TB). The test process RSS is well
    /// Returns the pool and a handle to change the limit later.
/// from running out of memory.
        assert_eq!(pool.reserved(), 2048);
        return SpillGateDecision::RejectNonSpillable;
        assert_eq!(pool.reserved(), 0);
                    reservation.consumer().name(),
        // if so, cancel the query rather than spilling (spill can't help at 95%+).
        let (pool, handle) = DynamicLimitPool::new(limit);
        // memory is below the override threshold, the pool's "full" state is
            });
            ) {
        // Decrease limit below current usage
        // `grow` is an infallible accounting call; the caller is responsible
    }
                    // Continue to the allocation below. Only count this against
                }
            // it can finish spilling; reject everything else so it spills.
        assert!(res_b.try_grow(1000).is_err());
/// Behaviour matches `GreedyMemoryPool` exactly, except the limit is stored
        // 12MB). A 64 MB request does not fit, so it is rejected.
    fn test_hard_guard_rejects_when_rss_exceeds_critical() {
    fn test_set_limit() {
        // RSS between operator (85%) and critical (95%) — reject (operator will spill)
        let mut reservation = consumer.register(&pool);
        let (pool, handle) = new_pool(1024);
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
            ));
        }
use datafusion::common::DataFusionError;
                        if handle.limit() >= 2048 {
                    // its retries before the raiser thread's store completed.
//! Dynamic memory pool for DataFusion query execution.
                    // final try_grow fails, that IS a real pool bug.
    }
                            reservation.try_grow(2048).expect(
        assert!(
            let barrier = Arc::new(Barrier::new(2));
    /// Create a new pool with the given initial limit.
/// the pool-limit check and the 95% critical check, so the node stays protected
impl MemoryPool for DynamicLimitPool {
    additional: usize,
        // wrap `used` back to zero by passing `usize::MAX`. `saturating_add`
            assert!(reservation.try_grow(1000).is_ok());
/// A request from a spillable consumer is allowed through ("exempt"). When such
    used: AtomicUsize,
        if used.checked_add(additional).is_some() {
        self.limit.load(Ordering::Acquire)
        assert_eq!(pool.reserved(), 2048);
        assert!(reservation.try_grow(2048).is_err());
                        self.tripped_count.fetch_add(1, Ordering::Relaxed);
                self.tripped_count.fetch_add(1, Ordering::Relaxed);
        // First grow succeeds
        additional: usize,
    let cap_room = cap.saturating_sub(outstanding);
        let d = spill_gate_decision(true, 193 * MB, 512 * MB, 0);
        assert_eq!(
                let pool = pool.clone();
        let (pool, handle) = new_pool(1024);
    }
        }
        // A 193 MB spill buffer must be allowed through as long as it fits the
        assert!(reservation.try_grow(2048).is_ok());
        // But new allocations fail
                    // the budget if the allocation actually succeeds (see
use datafusion::execution::memory_pool::{MemoryPool, MemoryReservation};
        let consumer = MemoryConsumer::new("test");
///
                    // the new limit is visible. The previous fixed-iteration loop
        handle.set_limit(2048);
/// That buffer must be allowed to allocate, otherwise the spill cannot finish
        // triggers spill — regardless of the cap budget.
        let (pool, handle) = new_pool(1_000_000);
    }
#[cfg(test)]
    /// Total bytes currently allowed through the 85% gate by the spill
        assert_eq!(d, SpillGateDecision::RejectNonSpillable);
    }
        let pool = Self {
/// freed-but-not-yet-returned. Right after a spill frees its data, the OS RSS
    } else {
/// a consumer hits the spill threshold it spills: it frees its existing data
        // Pool with 1KB limit — below MIN_POOL_FOR_OVERRIDE (16MB) so
        self.used.fetch_sub(shrink, Ordering::Relaxed);
        };
                    let mut reservation = consumer.register(&pool);
        SpillGateDecision::RejectCapped
    can_spill: bool,
    fn test_spill_gate_exempts_buffer_within_budget() {
    RejectCapped,
        let handle = DynamicLimitHandle {
                    barrier.wait();
    #[test]
                })
            0,
        let tripped = Arc::new(AtomicUsize::new(0));
        for _ in 0..100 {
///
    RejectNonSpillable,
        // pins `used` at `usize::MAX` instead.
        assert_eq!(handle.tripped_count(), 0);
    }
    fn reserved(&self) -> usize {
            if exempted {
    }
        // Set if a spillable consumer is allowed through the 85% check; its
///
        assert!(reservation.try_grow(2048).is_err());
        write!(
    tripped_count: Arc<AtomicUsize>,
        // - At 95% (critical): reject every request. This is the hard limit that
        // - At 85% (spill): reject requests so consumers spill to disk, except
    }
        let limit = Arc::new(AtomicUsize::new(initial_limit));
                    }
                    //
            if resident_usize > spill_bytes {
        // Second grow exceeds limit → rejected, tripped increments
    /// so tests wrap the concrete pool once rather than repeating the cast
        // Fails at 1024 limit
    /// the exemption budget is measured against, so concurrent spills together
                    let consumer = MemoryConsumer::new("race");
        let consumer_a = MemoryConsumer::new("sort_buffer");
                    self.exempt_outstanding
        );
            }
                Some(out.saturating_sub(shrink))
/// Handle to change the pool limit at runtime.
pub struct DynamicLimitHandle {
 * this file be licensed under the Apache-2.0 license or a
        assert!(reservation.try_grow(512).is_ok());
    /// Number of times try_grow was rejected (after jemalloc confirmation).
            if crate::memory_guard::should_override(
    /// Atomically set a new limit. Takes effect on the next `try_grow`.
                            break;
        // cannot wrap the counter.
            let raiser = {
                            additional,
                reservation.consumer().name()
        // budget. An earlier version also looked at how much memory the allocator
                crate::memory_guard::OverrideContext::Execution,
        let (pool, handle) = new_pool(4096);
    }
        assert!(reservation.try_grow(1).is_err());
            handle.tripped_count() >= 1,
        let d = spill_gate_decision(true, 262_528, 512 * MB, 0);
                let cap = crate::memory_guard::spill_exempt_cap_bytes();
        let d2 = spill_gate_decision(true, 8 * MB, 512 * MB, 500 * MB);
                (new_used <= limit).then_some(new_used)
        // Reserve 2048
                    additional,
    use datafusion::execution::memory_pool::MemoryConsumer;
    #[test]
use std::sync::atomic::{AtomicUsize, Ordering};
                        .fetch_add(additional, Ordering::Relaxed);
                        std::hint::spin_loop();
        assert_eq!(handle.limit(), 1024);
    #[test]
            return Err(crate::native_error::critical_pressure_error(
        let (_pool, handle) = new_pool(1024);
        let resident = crate::memory_guard::cached_resident_bytes();
 * The OpenSearch Contributors require contributions made to
}
        let _ = self
        let consumer = MemoryConsumer::new("scan");
    if additional <= cap_room {
        let d = spill_gate_decision(false, 256 * 1024, 512 * MB, 0);
/// - Decreasing the limit takes effect for new allocations only.
            limit: limit.clone(),
    }
        )
    limit: Arc<AtomicUsize>,
    fn try_grow(
    /// `shrink` as memory is freed (saturating, so it never goes below zero).
        }
                        return Err(crate::native_error::pool_limit_error(
    fn test_try_grow_within_limit() {
                    // `exempted`), so a failed one doesn't use up the budget.
//!
                    // The atomic invariant under test: once `handle.limit() >= 2048`
        handle.set_limit(1024);
/// real process memory. The 95% critical check runs in the caller before this
    #[test]
        // below 95% of 1TB, so the hard guard should NOT fire.
            return Ok(());
            result.is_ok(),
        }
            reservation.size(),
    fn test_try_grow_rejection_increments_tripped_count() {
            );
/// enough memory to cross the 95% critical threshold.
        let d2 = spill_gate_decision(true, 600 * MB, 512 * MB, 0);
        assert!(reservation.try_grow(1024).is_ok());
//! share an `Arc<AtomicUsize>` for the limit, so `set_limit` is lock-free
            handle.tripped_count(),
            additional,
///   Existing reservations that exceed the new limit are NOT reclaimed.
        assert_eq!(pool.reserved(), 0);
    /// Build an `Arc<dyn MemoryPool>` + handle for tests.
        // Fast path: try the normal CAS against the pool limit.
///
    /// Reject: not a spillable consumer, so reject it to make it spill.
                        if reservation.try_grow(2048).is_ok() {
impl DynamicLimitHandle {
        // Consumer B retries — now succeeds, no additional trip
        // data calls `shrink`). Subtract without going below zero. A normal,
    fn test_dynamic_limit_decrease_existing_reservations_kept() {
        let cas_result = self
            resident
}
        assert_eq!(pool.reserved(), 1024);
            }
        assert_eq!(d, SpillGateDecision::RejectCapped);
    }
                        }
            // RSS is between 85% and 95%. Allow a spillable consumer through so
        use std::sync::Barrier;
        // for pairing it with a successful `try_grow`, so under well-behaved
    pub fn tripped_count(&self) -> usize {
                self.exempt_outstanding
        pool.grow(&reservation, 1);
            exempt_outstanding: AtomicUsize::new(0),
            f,
 */
    outstanding: usize,
            self.dynamic_limit.load(Ordering::Acquire),
    fn test_spill_gate_exempts_spillable_within_cap() {
        );
        let mut reservation = consumer.register(&pool);
    }
                    0,
        // Create a pool with a limit smaller than the current process RSS.
        // `grow` is infallible accounting — a buggy caller must not be able to
    fn test_try_grow_overflow_protection() {
        };
                let handle = handle.clone();
impl DynamicLimitPool {
    #[test]
    fn test_initial_limit() {
        assert_eq!(handle.tripped_count(), 0);
    }
    fn shrink(&self, _reservation: &MemoryReservation, shrink: usize) {
        // checked_add inside fetch_update must reject it cleanly.
    pub fn new(initial_limit: usize) -> (Self, DynamicLimitHandle) {
        // Same request fits when the cap is unused.
        let mut reservation = consumer.register(&pool);
                            0,
            return; // RSS unexpectedly low — skip rather than false-fail
                        u.checked_add(additional)
                    handle.set_limit(1 << 30);
        let (pool, handle) = new_pool(20 * 1024 * 1024); // 20MB
                    // flaked on fast runners because the allocator could exhaust
        // Spillable, small request, full cap available → exempt.
    fn test_concurrent_set_limit_observed_by_try_grow() {
            "tripped_count should increment on hard guard rejection"
        //   protects the node from running out of memory.
        self.tripped_count.fetch_add(1, Ordering::Relaxed);
        // haven't been released yet.
            raiser.join().unwrap();
        // Fill to the limit
        let mut res_a = consumer_a.register(&pool);
            native_bridge_common::log_info!(
        reservation: &MemoryReservation,
            let thresholds = crate::memory_guard::get_thresholds();
    }
        assert_eq!(pool.reserved(), 4096);
        //
            tripped: tripped.clone(),
        assert_eq!(
/// Outcome of the 85%→95% spill-gate decision for one reservation.
        assert_eq!(
/// `cap - outstanding`, so that many spills happening at once cannot add up to
        let result = reservation.try_grow(1024);
        }
            allocator.join().unwrap();
        // Repeat to give the race a chance to surface.
/// in an `AtomicUsize` shared with a [`DynamicLimitHandle`].
        ))
            tripped_count: tripped,
        res_a.shrink(1500);
    #[test]
    #[test]
        let mut reservation = consumer.register(&pool);
//! Replaces DataFusion's `GreedyMemoryPool` with a pool whose limit can be
            "try_grow should fail when RSS ({}) exceeds critical threshold (95% of 20MB)",
        assert_eq!(pool.reserved(), usize::MAX);
        // triggers spill), consult jemalloc as ground truth. If actual process
/// band (above the spill threshold, below the critical threshold).
        if resident < critical_bytes {
}
        assert!(
                    // is observable, the very next `try_grow(2048)` MUST succeed
        self.tripped.load(Ordering::Relaxed)
        assert!(res_b.try_grow(1000).is_ok());
    ) -> Result<(), DataFusionError> {
        let d = spill_gate_decision(true, 64 * MB, 512 * MB, 500 * MB);
    fn test_grow_saturates_instead_of_wrapping() {
        assert_eq!(pool.reserved(), usize::MAX);
                let outstanding = self.exempt_outstanding.load(Ordering::Relaxed);
    }
    /// at every call site.
/// has not dropped yet (the allocator holds the pages), so that signal reads as
        assert!(res_a.try_grow(1500).is_ok());
                return Ok(());
        SpillGateDecision::Exempt
        self.dynamic_limit.load(Ordering::Acquire)
/// is called, so this can never allow crossing 95%.
    fn test_tripped_count_zero_when_all_grows_succeed() {
        use std::thread;
    }
    }
                Some(used.saturating_add(additional))
        assert_eq!(d, SpillGateDecision::Exempt);
            });
        self.limit.store(new_limit, Ordering::Release);
            let spill_bytes = (limit as f64 * thresholds.execution_spill) as usize;
                                "once handle.limit() reflects the raise, try_grow must succeed",
        if resident <= 0 {
                }
        // spill needs its buffer, so it wrongly rejected this and the spill could
        );
            self.used.load(Ordering::Relaxed)
            .fetch_update(Ordering::Relaxed, Ordering::Relaxed, |used| {
        // Most of the budget is already used (500MB of a 512MB cap, leaving
//! and takes effect on the next `try_grow` call.
        (Arc::new(pool), handle)
/// Decides what to do with a memory request whose RSS is in the 85%-to-95%
            "try_grow should succeed when RSS is well below 95% of 1TB pool limit"
            return; // jemalloc not available in this test env
    }
    }
mod tests {
                "Memory CANCEL: RSS exceeds critical threshold for consumer [{}]. Cancelling query to protect node.",
        // straight to tripped_count increment.
    use super::*;
    dynamic_limit: Arc<AtomicUsize>,
    #[test]
}
            SpillGateDecision::RejectCapped
        // callers `used + additional` cannot overflow `usize`. Use a saturating
        assert_eq!(handle.tripped_count(), 2);
            let critical_bytes = (limit as f64 * thresholds.execution_critical) as usize;
        let consumer = MemoryConsumer::new("test");
#[derive(Debug, Clone)]
pub(crate) enum SpillGateDecision {
    #[test]
    fn test_tripped_count_reflects_in_handle_after_multiple_consumers() {
            let allocator = {
                thread::spawn(move || {
    }
                            limit,
    }
/// same `Arc<AtomicUsize>`.
        let consumer_b = MemoryConsumer::new("hash_agg");
    #[test]
                    loop {
                    }
    #[test]
                            reservation.size(),
        assert!(reservation.try_grow(usize::MAX).is_err());
    pub fn tripped_count(&self) -> usize {
        assert!(reservation.try_grow(1024).is_err());
        assert_eq!(handle.limit(), 2048);
    cap: usize,
}
            .used
        let (pool, _handle) = new_pool(1024);
 * compatible open source license.
                        ));
        assert!(
}
    pub fn set_limit(&self, new_limit: usize) {
        // Consumer B tries 1000 bytes — only 548 available → rejected
        self.tripped_count.load(Ordering::Relaxed)
        let mut reservation = consumer.register(&pool);
    #[test]
        assert_eq!(d2, SpillGateDecision::Exempt);
                    barrier.wait();
                let new_used = used.checked_add(additional)?;
    /// exemption that have not yet been freed. This is the `outstanding` value
        let critical_bytes = (20.0 * 1024.0 * 1024.0 * 0.95) as i64;
        // Existing reservation is NOT reclaimed
                    limit,
                    // Retry until either allocation succeeds OR the handle reports
        let consumer = MemoryConsumer::new("hash_agg");
        let mut reservation = consumer.register(&pool);
        let resident = crate::memory_guard::cached_resident_bytes();
        assert_eq!(pool.reserved(), 512);
    }
        );
        let (pool, _handle) = new_pool(1024);
    }
        let (pool, handle) = new_pool(1024);
        assert!(reservation2.try_grow(1).is_err());
    #[test]
        assert_eq!(handle.tripped_count(), 0);
        let reservation = consumer.register(&pool);
            self.tripped_count.fetch_add(1, Ordering::Relaxed);
                })
 * SPDX-License-Identifier: Apache-2.0
        let _ = self
            // Critical (95%): hard reject — OOM imminent, protect the node.
                            break;
                    .fetch_add(additional, Ordering::Relaxed);
        // had freed but not yet returned, which reads as near-zero right when a
        assert_eq!(d2, SpillGateDecision::RejectCapped);
        assert_eq!(handle.tripped_count(), 0);
        // Two memory checks based on process RSS:
    fn test_dynamic_limit_increase() {
        let mut res_b = consumer_b.register(&pool);
        let consumer = MemoryConsumer::new("test");
                    SpillGateDecision::Exempt => exempted = true,
                            );
/// near-zero exactly when the spill needs its buffer, and an earlier version of
    /// Number of times try_grow was rejected.
        self.used.load(Ordering::Relaxed)
        let used = self.used.load(Ordering::Relaxed);
        );
        //   cannot push the node over the limit.
            limit.saturating_sub(used),
    tripped: Arc<AtomicUsize>,
        //
        assert_eq!(handle.tripped_count(), 1);
            if resident_usize > critical_bytes {
        assert!(reservation.try_grow(512).is_ok());
                let barrier = barrier.clone();
            SpillGateDecision::Exempt
    exempt_outstanding: AtomicUsize,
        // Now even 1 byte exceeds → tripped again
}
                let barrier = barrier.clone();
            used: AtomicUsize::new(0),
/// A `MemoryPool` whose limit can be changed at runtime.
    }
    /// Read the current limit.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
        //   spilling (see `spill_gate_decision`). The exemption is bounded by a
    }
#[derive(Debug)]
        // non-exempt shrink may give budget back a little early, which is safe:
    /// Allow the request through so the spill can finish writing.
                return Err(crate::native_error::pool_limit_error(
        let mut reservation2 = consumer2.register(&pool);
                limit,
}
            .exempt_outstanding
    fn grow(&self, _reservation: &MemoryReservation, additional: usize) {
///
                // jemalloc confirms headroom — allow the grow
        assert_eq!(d, SpillGateDecision::Exempt);
        let consumer = MemoryConsumer::new("test");
        // budget is only counted after the allocation actually succeeds below.
        for _ in 0..64 {
                let can_spill = reservation.consumer().can_spill();
) -> SpillGateDecision {
        // preventing unnecessary spills when phantoms from finished queries
    fn test_spill_gate_bound_is_cap_minus_outstanding() {
    #[test]
            "tripped_count should remain 0 when hard guard does not fire"
        assert_eq!(handle.tripped_count(), 1);
    /// Reject: spillable, but the request is larger than the remaining budget.
        let (pool, _handle) = new_pool(usize::MAX);
        // Consumer A releases, freeing space
        // A small allocation should succeed — RSS is far below 95% of 1TB
 *
    fn test_try_grow_exceeds_limit() {
/// Kept as a separate pure function so it can be unit-tested without needing
                        }
        let consumer = MemoryConsumer::new("hard_guard_test");
/// Can be stored separately from the pool (which is consumed by
        // The hard guard fires before the CAS — even a tiny grow should be rejected
                limit,
        // always trigger the hard guard (RSS > 95% of 20MB = 19MB).
impl std::fmt::Display for DynamicLimitPool {
                    .fetch_update(Ordering::Relaxed, Ordering::Relaxed, |u| {
/// first, then needs a small temporary buffer to write the spilled data out.
        let mut reservation = consumer.register(&pool);
        (pool, handle)
        // CAS loop so that a buggy caller (or a malicious `additional == usize::MAX`)
        );
    fn name(&self) -> &str {
            spill_gate_decision(true, 60 * MB, 512 * MB, 0),
                let limit = dynamic_limit.load(Ordering::Acquire);
        // Now succeeds
    /// Read the current limit.
        let limit = self.dynamic_limit.load(Ordering::Acquire);
        let mut reservation = consumer.register(&pool);
        // Only attempt override if the allocation is plausible (won't overflow).
            };
    pub fn limit(&self) -> usize {
                additional,
/// and the query gets stuck. The exemption is bounded by a fixed byte budget,
    }
        }
        let result = reservation.try_grow(4096);
    }
            // Absolute and pre-CAS for every consumer, spillable or not.
    fn test_spill_gate_caps_when_budget_exhausted() {
            "DynamicLimitPool(limit={}, used={})",
        // A non-spillable consumer in the 85% band is always rejected so it
        // from stale phantoms or accounting drift — allow the grow.
        // Both pool and jemalloc confirm pressure. Check if RSS is critical —
        assert!(reservation.try_grow(512).is_ok());
            }
        // `additional == usize::MAX` would overflow `used + additional`.
    }
                            reservation.consumer().name(),
        // A Rust test process typically uses 50-200MB RSS, so 20MB should
    }
                match spill_gate_decision(can_spill, additional, cap, outstanding) {
        let mut exempted = false;
    if !can_spill {
        // it only makes the exemption stricter, never looser.
                thread::spawn(move || {
//! changed at runtime via a shared `DynamicLimitHandle`. The pool and handle
            let (pool, handle) = new_pool(1024);
        }
    #[test]
            .fetch_update(Ordering::Relaxed, Ordering::Relaxed, |out| {
        // Pool accounting says "full". Before failing the operator (which
        let dynamic_limit = &self.dynamic_limit;
    pub fn limit(&self) -> usize {
        // Mirrors the observed 256 KiB spill-trigger allocation.
        let mut reservation = consumer.register(&pool);
            // released saturating in `shrink`.
        // This gives already-executing operators a higher effective limit,
    fn new_pool(limit: usize) -> (Arc<dyn MemoryPool>, DynamicLimitHandle) {
    }
    #[test]
        if cas_result.is_ok() {
        // Increase limit
/// `TrackConsumersPool::new`). Both the pool and handle point to the
                    // (that's the Release/Acquire happens-before contract). If that
        if resident > 0 && limit >= 16 * 1024 * 1024 {
        "DynamicLimitPool"
        pool.grow(&reservation, usize::MAX);
        // The sole bound is the hard cap minus outstanding exemptions.
    /// DataFusion 52+ `MemoryConsumer::register` takes `&Arc<dyn MemoryPool>`,
    fn test_hard_guard_passes_when_rss_below_critical() {
        let consumer = MemoryConsumer::new("test");
        let (pool, _handle) = new_pool(1024);
    fn test_spill_gate_rejects_non_spillable() {
///
use std::sync::Arc;
        //   spillable consumers, which are allowed through so they can finish
            .fetch_update(Ordering::Relaxed, Ordering::Relaxed, |used| {
    #[test]
                    });
    #[test]
            });
    // ---- Spill-gate exemption rule (pure, deterministic) ----
/// during spill"). The fixed byte budget avoids that. The caller still applies
        let consumer = MemoryConsumer::new("test");
        let consumer2 = MemoryConsumer::new("test2");
        let limit = dynamic_limit.load(Ordering::Acquire);
        // Give back exemption budget as memory is freed (a spill writing out its
        assert_eq!(pool.reserved(), 1024);
    }
        // jemalloc override is skipped entirely. Every rejection goes
        let limit = 1024 * 1024 * 1024 * 1024_usize; // 1TB
