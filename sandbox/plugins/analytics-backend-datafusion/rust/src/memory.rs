/// `cap - outstanding`, so that many spills happening at once cannot add up to
                    reservation.size(),
        SpillGateDecision::Exempt
        assert!(reservation.try_grow(512).is_ok());
///
    }
        }
            reservation.consumer().name(),
        let used = self.used.load(Ordering::Relaxed);
                })
/// real process memory. The 95% critical check runs in the caller before this
        self.tripped.load(Ordering::Relaxed)
            }
        assert_eq!(d, SpillGateDecision::RejectCapped);
    }
        assert!(res_a.try_grow(1500).is_ok());
                let barrier = barrier.clone();
    /// exemption that have not yet been freed. This is the `outstanding` value
        (pool, handle)
                    }
        );
            return Ok(());
    use datafusion::execution::memory_pool::MemoryConsumer;
        assert_eq!(pool.reserved(), 1024);
impl DynamicLimitHandle {
    }
            self.dynamic_limit.load(Ordering::Acquire),
        let result = reservation.try_grow(1024);
                    // the new limit is visible. The previous fixed-iteration loop
            return; // jemalloc not available in this test env
    #[test]
            f,
        // from stale phantoms or accounting drift — allow the grow.
        // Pool accounting says "full". Before failing the operator (which
pub(crate) enum SpillGateDecision {
        assert_eq!(d2, SpillGateDecision::Exempt);
                Some(out.saturating_sub(shrink))
            .fetch_update(Ordering::Relaxed, Ordering::Relaxed, |out| {
        assert!(reservation.try_grow(2048).is_err());
///
/// The decision deliberately does not look at how many pages the allocator has
        let (pool, handle) = new_pool(1024);
    additional: usize,
            used: AtomicUsize::new(0),
            "tripped_count should remain 0 when hard guard does not fire"
                            reservation.size(),
        assert!(reservation2.try_grow(1).is_err());
        "DynamicLimitPool"
                    barrier.wait();
        // Fill to the limit
        // Create a pool with a limit smaller than the current process RSS.
        );
        // 40MB room (512 - 472), 60MB request → rejected.
        assert!(reservation.try_grow(512).is_ok());
        // triggers spill), consult jemalloc as ground truth. If actual process
/// from running out of memory.
        let reservation = consumer.register(&pool);
            ) {
        assert_eq!(handle.tripped_count(), 0);
        let resident = crate::memory_guard::cached_resident_bytes();
    #[test]
                let barrier = barrier.clone();
/// - Decreasing the limit takes effect for new allocations only.
        // Only attempt override if the allocation is plausible (won't overflow).
                        self.tripped_count.fetch_add(1, Ordering::Relaxed);
    cap: usize,
 * compatible open source license.
        // Reserve 2048
        let (pool, handle) = new_pool(limit);
        //   byte budget, and the pool-limit and 95% checks still apply, so this
    #[test]
        // Set if a spillable consumer is allowed through the 85% check; its
        assert!(reservation.try_grow(2048).is_ok());
        let (pool, handle) = new_pool(2048);
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
        assert_eq!(d, SpillGateDecision::Exempt);
        additional: usize,
    #[test]
        // Fails at 1024 limit
    fn try_grow(
        // not finish. The decision now depends only on the budget.
            if crate::memory_guard::should_override(
        assert_eq!(pool.reserved(), 0);
///
    fn test_concurrent_set_limit_observed_by_try_grow() {
            SpillGateDecision::Exempt
    fn test_spill_gate_exempts_spillable_within_cap() {
/// Outcome of the 85%→95% spill-gate decision for one reservation.
                    //
        let consumer = MemoryConsumer::new("hash_agg");
        assert_eq!(
        let used = self.used.load(Ordering::Relaxed);
        let limit = self.dynamic_limit.load(Ordering::Acquire);
                let handle = handle.clone();
        // Increase limit
    fn test_grow_saturates_instead_of_wrapping() {
        assert_eq!(pool.reserved(), 100_000);
mod tests {
        assert_eq!(handle.tripped_count(), 0);
        // preventing unnecessary spills when phantoms from finished queries
            result.is_ok(),
        let mut reservation = consumer.register(&pool);
            additional,
        assert!(
            let raiser = {
        let (pool, handle) = DynamicLimitPool::new(limit);
        // A buffer larger than the whole budget is still rejected.
        // Mirrors the observed 256 KiB spill-trigger allocation.
                let can_spill = reservation.consumer().can_spill();
            let resident_usize = resident as usize;
    #[test]
    }
                }
        let d = spill_gate_decision(true, 193 * MB, 512 * MB, 0);
            .used
        let d = spill_gate_decision(true, 64 * MB, 512 * MB, 500 * MB);
///
                self.tripped_count.fetch_add(1, Ordering::Relaxed);
                        if handle.limit() >= 2048 {
            });
                return Err(crate::native_error::pool_limit_error(
                    // (that's the Release/Acquire happens-before contract). If that
            tripped: tripped.clone(),
        let consumer = MemoryConsumer::new("test");
 * SPDX-License-Identifier: Apache-2.0
                match spill_gate_decision(can_spill, additional, cap, outstanding) {
        pool.grow(&reservation, usize::MAX);
    }
        assert_eq!(
    Exempt,
                            0,
    /// cannot exceed the cap. Increased when a request is exempted, decreased in
        SpillGateDecision::RejectCapped
        let mut reservation2 = consumer2.register(&pool);
//! changed at runtime via a shared `DynamicLimitHandle`. The pool and handle
    /// Build an `Arc<dyn MemoryPool>` + handle for tests.
        let dynamic_limit = &self.dynamic_limit;
    use super::*;
        // A 193 MB spill buffer must be allowed through as long as it fits the
}
        );
            .fetch_update(Ordering::Relaxed, Ordering::Relaxed, |used| {
            limit.saturating_sub(used),
        // budget is only counted after the allocation actually succeeds below.
        //   spillable consumers, which are allowed through so they can finish
/// `TrackConsumersPool::new`). Both the pool and handle point to the
    fn test_tripped_count_zero_when_all_grows_succeed() {
        ))
        assert_eq!(pool.reserved(), 2048);
    if !can_spill {
    }
/*
                thread::spawn(move || {
            };
            dynamic_limit: limit,
        // Second grow exceeds limit → rejected, tripped increments
/// Handle to change the pool limit at runtime.
                    barrier.wait();
        let (pool, _handle) = new_pool(1024);
    ) -> Result<(), DataFusionError> {
            }
            // Critical (95%): hard reject — OOM imminent, protect the node.
        assert!(reservation.try_grow(2048).is_ok());
        let (_pool, handle) = new_pool(1024);
            let spill_bytes = (limit as f64 * thresholds.execution_spill) as usize;
    }
        );
    }
        use std::thread;
///   Existing reservations that exceed the new limit are NOT reclaimed.
#[derive(Debug, Clone)]
        let _ = self
    /// Allow the request through so the spill can finish writing.
                    // flaked on fast runners because the allocator could exhaust
    #[test]
                    let mut reservation = consumer.register(&pool);
        let (pool, _handle) = new_pool(usize::MAX);
    }
/// A `MemoryPool` whose limit can be changed at runtime.
    /// Read the current limit.
        assert_eq!(pool.reserved(), 2048);
        let mut reservation = consumer.register(&pool);
        let consumer = MemoryConsumer::new("large_pool_test");
                })
                    .fetch_update(Ordering::Relaxed, Ordering::Relaxed, |u| {
        write!(
    if additional <= cap_room {
                (new_used <= limit).then_some(new_used)
        pool.grow(&reservation, 1);
                    limit,
    }
}
        let (pool, handle) = new_pool(1024);
                        return Err(crate::native_error::pool_limit_error(
            exempt_outstanding: AtomicUsize::new(0),
    }
    }
        // The sole bound is the hard cap minus outstanding exemptions.
                return Ok(());
                        }
        let consumer = MemoryConsumer::new("test");
        // Repeat to give the race a chance to surface.
 *
            .fetch_update(Ordering::Relaxed, Ordering::Relaxed, |used| {
/// is called, so this can never allow crossing 95%.
        let mut reservation = consumer.register(&pool);
    #[test]
        let consumer = MemoryConsumer::new("test");
            }
    /// so tests wrap the concrete pool once rather than repeating the cast
    const MB: usize = 1024 * 1024;
    fn test_spill_gate_caps_when_budget_exhausted() {
        assert_eq!(pool.reserved(), usize::MAX);
        let limit = 1024 * 1024 * 1024 * 1024_usize; // 1TB
    used: AtomicUsize,
    }
        // This gives already-executing operators a higher effective limit,
/// A request from a spillable consumer is allowed through ("exempt"). When such
impl DynamicLimitPool {
impl std::fmt::Display for DynamicLimitPool {
                    SpillGateDecision::Exempt => exempted = true,
        // jemalloc override is skipped entirely. Every rejection goes
                (crate::memory_guard::get_thresholds().execution_critical * 100.0) as u32,
            "try_grow should succeed when RSS is well below 95% of 1TB pool limit"
    fn test_try_grow_overflow_protection() {
                self.exempt_outstanding
        // cannot wrap the counter.
        // `grow` is infallible accounting — a buggy caller must not be able to
        // callers `used + additional` cannot overflow `usize`. Use a saturating
}
/// - Increasing the limit takes effect immediately for new allocations.
        let consumer_a = MemoryConsumer::new("sort_buffer");
    }
            // Charge the exemption budget only now that the grow succeeded;
        };
    /// `shrink` as memory is freed (saturating, so it never goes below zero).
            );
use datafusion::common::DataFusionError;
                    loop {
    /// DataFusion 52+ `MemoryConsumer::register` takes `&Arc<dyn MemoryPool>`,
        return SpillGateDecision::RejectNonSpillable;
                    // Continue to the allocation below. Only count this against
//! Replaces DataFusion's `GreedyMemoryPool` with a pool whose limit can be
        handle.set_limit(4096);
                        }
        let mut res_a = consumer_a.register(&pool);
        assert!(
use std::sync::atomic::{AtomicUsize, Ordering};
        let mut exempted = false;
        let limit = dynamic_limit.load(Ordering::Acquire);
                    .fetch_add(additional, Ordering::Relaxed);
        assert!(reservation.try_grow(2048).is_err());
        // `additional == usize::MAX` would overflow `used + additional`.
    pub fn tripped_count(&self) -> usize {
        let pool = Self {
        assert!(
        assert!(reservation.try_grow(1024).is_ok());
                reservation.consumer().name()
}
            handle.tripped_count() >= 1,
        assert!(res_b.try_grow(1000).is_err());
        assert_eq!(handle.tripped_count(), 0);
        }
/// Behaviour matches `GreedyMemoryPool` exactly, except the limit is stored
    }
        //   spilling (see `spill_gate_decision`). The exemption is bounded by a
        //   protects the node from running out of memory.
            };
        );
        let d2 = spill_gate_decision(true, 600 * MB, 512 * MB, 0);
    /// at every call site.
/// enough memory to cross the 95% critical threshold.
        // First grow succeeds
        // The hard guard fires before the CAS — even a tiny grow should be rejected
                limit,
        // if so, cancel the query rather than spilling (spill can't help at 95%+).
        // - At 95% (critical): reject every request. This is the hard limit that
        // non-exempt shrink may give budget back a little early, which is safe:
            let (pool, handle) = new_pool(1024);
    /// Total bytes currently allowed through the 85% gate by the spill
        // Now succeeds
    /// Returns the pool and a handle to change the limit later.
        if cas_result.is_ok() {
    }
        // straight to tripped_count increment.
        self.used.fetch_sub(shrink, Ordering::Relaxed);
/// freed-but-not-yet-returned. Right after a spill frees its data, the OS RSS
}
            self.tripped_count.fetch_add(1, Ordering::Relaxed);
    fn test_dynamic_limit_decrease_existing_reservations_kept() {
    dynamic_limit: Arc<AtomicUsize>,
    fn test_hard_guard_rejects_when_rss_exceeds_critical() {
            let critical_bytes = (limit as f64 * thresholds.execution_critical) as usize;
        // A non-spillable consumer in the 85% band is always rejected so it
                reservation.size(),
        // Give back exemption budget as memory is freed (a spill writing out its
    }
                    });
                    _ => {
        let (pool, handle) = new_pool(4096);
        assert_eq!(handle.limit(), 1024);
    exempt_outstanding: AtomicUsize,
                let cap = crate::memory_guard::spill_exempt_cap_bytes();
                    // `exempted`), so a failed one doesn't use up the budget.
            .used
        let consumer = MemoryConsumer::new("hard_guard_test");
    /// the exemption budget is measured against, so concurrent spills together
        handle.set_limit(2048);
        // Two memory checks based on process RSS:
        // budget. An earlier version also looked at how much memory the allocator
                        std::hint::spin_loop();
        let cas_result = self
        handle.set_limit(1024);
                            );
}
        // triggers spill — regardless of the cap budget.
        }
        assert_eq!(handle.tripped_count(), 1);
        // pins `used` at `usize::MAX` instead.
                    0,
                let pool = pool.clone();
            if exempted {
        // 12MB). A 64 MB request does not fit, so it is rejected.
/// has not dropped yet (the allocator holds the pages), so that signal reads as
    }
    // ---- Spill-gate exemption rule (pure, deterministic) ----
                        .fetch_add(additional, Ordering::Relaxed);
                thread::spawn(move || {
//! Dynamic memory pool for DataFusion query execution.
        //
                            additional,
        // A request that fits the remaining 12 MB is allowed through.
        self.tripped_count.load(Ordering::Relaxed)
                let limit = dynamic_limit.load(Ordering::Acquire);
        reservation: &MemoryReservation,
                    reservation.consumer().name(),
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        // for pairing it with a successful `try_grow`, so under well-behaved
        // checked_add inside fetch_update must reject it cleanly.
        let result = reservation.try_grow(4096);
        // Most of the budget is already used (500MB of a 512MB cap, leaving
            return; // RSS unexpectedly low — skip rather than false-fail
                crate::memory_guard::OverrideContext::Execution,
    #[test]
        // data calls `shrink`). Subtract without going below zero. A normal,
            limit,
    }
/// Decides what to do with a memory request whose RSS is in the 85%-to-95%
/// the pool-limit check and the 95% critical check, so the node stays protected
    fn test_spill_gate_rejects_non_spillable() {
    }
        let handle = DynamicLimitHandle {
        // memory is below the override threshold, the pool's "full" state is
            // Absolute and pre-CAS for every consumer, spillable or not.
    fn shrink(&self, _reservation: &MemoryReservation, shrink: usize) {
        if resident > 0 && limit >= 16 * 1024 * 1024 {
        }
        // Pool with 1KB limit — below MIN_POOL_FOR_OVERRIDE (16MB) so
        assert!(res_b.try_grow(1000).is_ok());
impl MemoryPool for DynamicLimitPool {
        // Existing reservation is NOT reclaimed
        // Consumer A takes 1500 bytes
        &self,
        if crate::memory_guard::should_cancel_query(limit) {
}
                    }
                reservation.consumer().name(),
}
        (Arc::new(pool), handle)
    } else {
        assert_eq!(handle.limit(), 2048);
            self.used.load(Ordering::Relaxed)
        assert_eq!(pool.reserved(), 1024);
    fn test_try_grow_exceeds_limit() {
    /// Number of times try_grow was rejected.
    }
    }
    fn test_set_limit() {
                }
    can_spill: bool,
                ));
            // RSS is between 85% and 95%. Allow a spillable consumer through so
                    // its retries before the raiser thread's store completed.
        assert!(reservation.try_grow(1024).is_err());
        let (pool, handle) = new_pool(20 * 1024 * 1024); // 20MB
        if used.checked_add(additional).is_some() {
        let critical_bytes = (20.0 * 1024.0 * 1024.0 * 0.95) as i64;
                    // The atomic invariant under test: once `handle.limit() >= 2048`
                            break;
            raiser.join().unwrap();
                if exempted {
        let (pool, _handle) = new_pool(1024);
                    self.exempt_outstanding
        }
        // Fast path: try the normal CAS against the pool limit.
    }
    }
    /// Read the current limit.
        // spill needs its buffer, so it wrongly rejected this and the spill could
                limit,
    pub fn new(initial_limit: usize) -> (Self, DynamicLimitHandle) {
        let consumer = MemoryConsumer::new("scan");
///
    #[test]
            limit: limit.clone(),
    #[test]
        // - At 85% (spill): reject requests so consumers spill to disk, except
        // always trigger the hard guard (RSS > 95% of 20MB = 19MB).
            let barrier = Arc::new(Barrier::new(2));
            result.is_err(),
            spill_gate_decision(true, 60 * MB, 512 * MB, 472 * MB),
    tripped: Arc<AtomicUsize>,
        // below 95% of 1TB, so the hard guard should NOT fire.
#[cfg(test)]
    fn new_pool(limit: usize) -> (Arc<dyn MemoryPool>, DynamicLimitHandle) {
/// Can be stored separately from the pool (which is consumed by
            SpillGateDecision::RejectCapped
                        u.checked_add(additional)
        }
            handle.tripped_count(),
/// during spill"). The fixed byte budget avoids that. The caller still applies
        // But new allocations fail
        self.used.load(Ordering::Relaxed)
    fn test_tripped_count_reflects_in_handle_after_multiple_consumers() {
    pub fn set_limit(&self, new_limit: usize) {
    #[test]
        Err(crate::native_error::pool_limit_error(
            tripped_count: tripped,
        let consumer = MemoryConsumer::new("test");
    pub fn limit(&self) -> usize {
        assert_eq!(pool.reserved(), 0);
                            limit,
 */
        assert_eq!(handle.tripped_count(), 1);
            native_bridge_common::log_info!(
                            reservation.try_grow(2048).expect(
            // it can finish spilling; reject everything else so it spills.
        let d2 = spill_gate_decision(true, 8 * MB, 512 * MB, 500 * MB);
        let resident = crate::memory_guard::cached_resident_bytes();
    fn test_try_grow_within_limit() {
        let (pool, handle) = new_pool(1_000_000);
        // had freed but not yet returned, which reads as near-zero right when a
        }
}
/// same `Arc<AtomicUsize>`.
            assert!(reservation.try_grow(1000).is_ok());
            if resident_usize > spill_bytes {
        assert_eq!(d, SpillGateDecision::RejectNonSpillable);
        // Create a pool with a huge limit (1TB). The test process RSS is well
    /// Create a new pool with the given initial limit.
        )
    #[test]
                    // the budget if the allocation actually succeeds (see
        let (pool, handle) = new_pool(1024);
    }
    fn test_try_grow_rejection_increments_tripped_count() {
        use std::sync::Barrier;
            // released saturating in `shrink`.
/// and the query gets stuck. The exemption is bounded by a fixed byte budget,
                let new_used = used.checked_add(additional)?;
        let mut res_b = consumer_b.register(&pool);
        // haven't been released yet.
    RejectNonSpillable,
            return Err(crate::native_error::critical_pressure_error(
            resident
                let _ = self
                    additional,
    #[test]
        self.limit.store(new_limit, Ordering::Release);
            allocator.join().unwrap();
        assert_eq!(handle.tripped_count(), 1);
        self.dynamic_limit.load(Ordering::Acquire)
    limit: Arc<AtomicUsize>,
            0,
        assert_eq!(pool.reserved(), 4096);
        let limit = Arc::new(AtomicUsize::new(initial_limit));
/// That buffer must be allowed to allocate, otherwise the spill cannot finish
        let consumer = MemoryConsumer::new("test");
            "DynamicLimitPool(limit={}, used={})",
    fn test_spill_gate_exempts_buffer_within_budget() {
        assert_eq!(pool.reserved(), usize::MAX);
                                "once handle.limit() reflects the raise, try_grow must succeed",
 * this file be licensed under the Apache-2.0 license or a
    #[test]
        }
    pub fn tripped_count(&self) -> usize {
        assert!(reservation.try_grow(512).is_ok());
        // Spillable, small request, full cap available → exempt.
pub(crate) fn spill_gate_decision(
                let outstanding = self.exempt_outstanding.load(Ordering::Relaxed);
        // Now even 1 byte exceeds → tripped again
        self.tripped_count.fetch_add(1, Ordering::Relaxed);
        let mut reservation = consumer.register(&pool);
        let mut reservation = consumer.register(&pool);
            spill_gate_decision(true, 60 * MB, 512 * MB, 0),
#[derive(Debug)]
                        ));
    fn test_dynamic_limit_increase() {
        let mut reservation = consumer.register(&pool);
                        if reservation.try_grow(2048).is_ok() {
use std::sync::Arc;
pub struct DynamicLimitHandle {
        // A small allocation should succeed — RSS is far below 95% of 1TB
        let consumer_b = MemoryConsumer::new("hash_agg");
                            reservation.consumer().name(),
        };
        // CAS loop so that a buggy caller (or a malicious `additional == usize::MAX`)
        assert_eq!(d2, SpillGateDecision::RejectCapped);
/// band (above the spill threshold, below the critical threshold).
    /// Atomically set a new limit. Takes effect on the next `try_grow`.
    fn grow(&self, _reservation: &MemoryReservation, additional: usize) {
    }
                additional,
                // jemalloc confirms headroom — allow the grow
            reservation.size(),
                    handle.set_limit(1 << 30);
    /// Reject: not a spillable consumer, so reject it to make it spill.
                    let consumer = MemoryConsumer::new("race");
        let consumer = MemoryConsumer::new("test");
) -> SpillGateDecision {
    fn name(&self) -> &str {
            });
        // Both pool and jemalloc confirm pressure. Check if RSS is critical —
    fn test_hard_guard_passes_when_rss_below_critical() {
                    // is observable, the very next `try_grow(2048)` MUST succeed
/// a consumer hits the spill threshold it spills: it frees its existing data
    fn test_initial_limit() {
    /// Number of times try_grow was rejected (after jemalloc confirmation).
    tripped_count: Arc<AtomicUsize>,
    #[test]
                let handle = handle.clone();
/// first, then needs a small temporary buffer to write the spilled data out.
        self.limit.load(Ordering::Acquire)
    #[test]
/// this code wrongly rejected the buffer ("Failed to reserve memory for sort
    /// Reject: spillable, but the request is larger than the remaining budget.
    }
        let mut reservation = consumer.register(&pool);
    }
        // A Rust test process typically uses 50-200MB RSS, so 20MB should
        let mut reservation = consumer.register(&pool);
                Some(used.saturating_add(additional))
                "Memory CANCEL: RSS exceeds critical threshold for consumer [{}]. Cancelling query to protect node.",
    }
        if resident < critical_bytes {
        let _ = self
/// in an `AtomicUsize` shared with a [`DynamicLimitHandle`].
        // Decrease limit below current usage
    RejectCapped,
    }
    outstanding: usize,
            ));
            }
    }
//! share an `Arc<AtomicUsize>` for the limit, so `set_limit` is lock-free
/// Kept as a separate pure function so it can be unit-tested without needing
        assert_eq!(pool.reserved(), 512);
        for _ in 0..64 {
use datafusion::execution::memory_pool::{MemoryPool, MemoryReservation};
            let thresholds = crate::memory_guard::get_thresholds();
        // Consumer A releases, freeing space
    }
        assert!(reservation.try_grow(usize::MAX).is_err());
        // Same request fits when the cap is unused.
            let allocator = {
        );
///
    }
                    // Retry until either allocation succeeds OR the handle reports
    #[test]
        assert_eq!(
        assert!(reservation.try_grow(1).is_err());
        assert_eq!(d, SpillGateDecision::Exempt);
//! and takes effect on the next `try_grow` call.
        let (pool, _handle) = new_pool(1024);
    pub fn limit(&self) -> usize {
/// near-zero exactly when the spill needs its buffer, and an earlier version of
        // `grow` is an infallible accounting call; the caller is responsible
            .exempt_outstanding
        // Consumer B tries 1000 bytes — only 548 available → rejected
        let d = spill_gate_decision(true, 262_528, 512 * MB, 0);
            });
        // it only makes the exemption stricter, never looser.
    #[test]
    fn test_spill_gate_bound_is_cap_minus_outstanding() {
        let mut reservation = consumer.register(&pool);
            if resident_usize > critical_bytes {
            "try_grow should fail when RSS ({}) exceeds critical threshold (95% of 20MB)",
        let d = spill_gate_decision(false, 256 * 1024, 512 * MB, 0);
                            break;
        if resident <= 0 {
//!
        assert_eq!(handle.tripped_count(), 2);
    #[test]
        //   cannot push the node over the limit.
pub struct DynamicLimitPool {
        let tripped = Arc::new(AtomicUsize::new(0));
                    // final try_grow fails, that IS a real pool bug.
        res_a.shrink(1500);
        // wrap `used` back to zero by passing `usize::MAX`. `saturating_add`
    }
        // RSS between operator (85%) and critical (95%) — reject (operator will spill)
 * The OpenSearch Contributors require contributions made to
            "tripped_count should increment on hard guard rejection"
        let consumer2 = MemoryConsumer::new("test2");
        //
        assert_eq!(handle.tripped_count(), 0);
        for _ in 0..100 {
                    .used
    fn reserved(&self) -> usize {
    let cap_room = cap.saturating_sub(outstanding);
        // Consumer B retries — now succeeds, no additional trip
