// ─────────────────────────────────────────────────────────────────────────────
            assert_eq!(pool.used(), 500);
                    Ok(()) => {
    use super::*;
pub type OverCommitDecider = extern "C" fn() -> i64;
            }
    }
    pub pool_name: &'static str,
    notify: Condvar,
                                    bytes,
/// Registers the over-commit decision callbacks. Idempotent — first registration wins.
        if self.size > 0 {
pub struct MemoryReservation {
}
    pub fn new(pool: &Arc<MemoryPool>, consumer: &'static str, behavior: PoolBehavior) -> Self {
/// A node-level memory pool backed by an atomic counter with blocking wait support.
        assert_eq!(pool.used(), 100);
        assert_eq!(res.size(), 512);
/// Error returned when wait_and_grow times out.
}
                }
        assert_eq!(pool.used(), 500);
#[derive(Debug, Clone)]
    let _ = OVERCOMMIT_RELEASER.set(releaser);
    }
                                crate::log_debug!(
    }
    /// reservation over-commits via infallible `grow` and the decider is told to release when the
            res.request(500).unwrap();
            return Ok(());
        self.size
        assert_eq!(pool.used(), 512);
        match result {
    pub fn child(&self, consumer: &'static str) -> Self {
                pool_name: self.name,
                                );
        res.shrink(500);
                        self.size += bytes;
    pub limit: usize,
    }
                Ok(())
    /// Fail immediately if the pool is full, unless the registered over-commit decider (the Java-side
                });
    }
    }
    fn test_ignore_limit_never_fails_when_already_over() {
                                Ok(())
    /// If actual > estimated: infallible grow for the delta.
                self.overcommit_token
            let _ = self
                                crate::log_debug!(
impl Drop for MemoryReservation {
    }
    }
    /// Release all memory back to the pool.
use std::sync::atomic::{AtomicUsize, Ordering};
    /// Infallible grow — use when the allocation has already happened.
}
    pub fn shrink(&mut self, bytes: usize) {
                                    "[RUST] over-commit granted: pool '{}' consumer '{}' token {} committing {} bytes beyond limit (reservation size now {})",
/// Asks the registered decider whether an over-commit may proceed. Returns the granted token id
impl fmt::Debug for MemoryPool {
                } else {
        let new_used = self.used.fetch_add(bytes, Ordering::Relaxed) + bytes;
//!
/// RAII handle that tracks a portion of memory reserved from a [`MemoryPool`].
            consumer,
//! The pool rejects allocations that would exceed the configured limit.
            "[{}] memory limit exceeded: requested {} bytes, used {}, limit {}",
        self.limit.load(Ordering::Relaxed)
        Ok(estimated)
        estimated: usize,
            .fetch_update(Ordering::Relaxed, Ordering::Relaxed, |used| {
                                self.size += bytes;
    }
                self.pool.grow(bytes);
                used: self.used.load(Ordering::Relaxed),
    /// Reserve an estimated amount. Returns the estimated amount for later use with `reconcile()`.
#[derive(Debug, Clone)]
    #[test]
    pub fn request(&mut self, bytes: usize) -> Result<(), Box<dyn std::error::Error>> {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        let pool = Arc::new(MemoryPool::new("test", 1024));
impl MemoryReservation {
            notify_lock: Mutex::new(()),
        }
        res.request(1000).unwrap();
    /// returned to the decider (with this token) when the reservation is freed/dropped (one grant ↔
            used: AtomicUsize::new(0),
    }
    size: usize,
    pub fn reserve_estimated(
        let res = MemoryReservation::new(&pool, "parent", PoolBehavior::Reject);
            self.pool_name, self.requested, self.waited, self.used, self.limit
    pub fn free(&mut self) -> usize {
        assert!(res.request(1000).is_ok());
        let start = std::time::Instant::now();
                                    self.pool.name(),
                                    self.pool.name(),
    #[test]
                Ok(())
impl std::error::Error for PoolTimeout {}
                        if self.overcommit_token != 0 {
    }
    /// Release `bytes` from this reservation.
#[derive(Debug, Clone)]
            }),
            self.overcommit_token = 0;
        )
        res.request(800).unwrap();
    pub limit: usize,
    fn test_peak_tracking() {
 * this file be licensed under the Apache-2.0 license or a
                self.size += bytes;
    /// reservation is freed/dropped. Falls back to a plain reject when no decider is registered or the
            PoolBehavior::Reject => {
                                    self.size
    }
    overcommit_token: i64,
            }
    pub used: usize,
            if elapsed >= timeout {
    }
}
        self.used
                                    token,
    }
fn overcommit_release(token: i64) {
    ) -> Result<usize, Box<dyn std::error::Error>> {
    }
        pool.set_limit(500);
        loop {
        let pool = Arc::new(MemoryPool::new("test", 1024));
}
    pub fn set_limit(&self, new_limit: usize) {
                "[RUST] over-commit permit released: pool '{}' consumer '{}' token {}",
        self.size -= actual;
            overcommit_release(self.overcommit_token);
    /// Reconcile a previous estimate with the actual measured size.
        }
    /// Atomically update the limit. Called by the Java rebalancer.
            PoolBehavior::Wait(timeout) => {
    }
    #[test]
use std::time::Duration;
                                self.pool.grow(bytes); // infallible over-commit
            self.size = 0;
                    limit,
        self.peak.fetch_max(new_used, Ordering::Relaxed);
mod tests {
        self.name
pub struct PoolTimeout {
        {
        write!(
        if bytes == 0 {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        s
        assert_eq!(res.size(), 500);
                    }
        // Request far beyond the limit — must succeed and over-commit.
        assert!(res.request(500).is_ok());
pub const DEFAULT_WAIT_TIMEOUT: Duration = Duration::from_secs(300);
        release(token);
            pool: Arc::clone(&self.pool),
        if bytes == 0 {
        Self {
    pub requested: usize,
    /// Returns a reference to the underlying pool.
/// Default timeout for blocking wait (300 seconds).
            return Ok(());
            }
                                    self.consumer,
            self.pool_name, self.requested, self.used, self.limit
                requested: bytes,
        }
    pub fn name(&self) -> &'static str {
            limit: AtomicUsize::new(limit),
                self.peak.fetch_max(old + bytes, Ordering::Relaxed);
    if let Some(release) = OVERCOMMIT_RELEASER.get() {
            pool: Arc::clone(pool),
    pub fn consumer(&self) -> &'static str {
                self.consumer,
    used: AtomicUsize,
                            self.size += bytes;
            "[{}] timed out waiting for {} bytes after {:?} (used: {}, limit: {})",
pub type OverCommitReleaser = extern "C" fn(i64);
    fn test_try_grow_within_limit() {
        }
static OVERCOMMIT_RELEASER: OnceLock<OverCommitReleaser> = OnceLock::new();
            size: 0,
        let result = self
/// Decider: returns a nonzero token id to grant an over-commit, or 0 to reject. The token is an
                return Err(PoolTimeout {
    fn drop(&mut self) {
                            }
        let limit = self.limit.load(Ordering::Relaxed);
    fn test_drop_releases_memory() {
            .field("limit", &self.limit.load(Ordering::Relaxed))
            );
        } else if actual < estimated {
    pub used: usize,
            }
            assert_eq!(pool.used(), 500);
            let elapsed = start.elapsed();
                    Err(exhausted) => {
                self.consumer,
    /// If actual < estimated: shrink the excess.
//
        }
        let actual = bytes.min(self.size);
                        } else {
        }
    fn test_child_reservation() {
    }
        // Wake waiters — new limit might allow blocked allocations
    /// allocator) grants an over-commit based on node-level native memory pressure. When granted, the
        let pool = Arc::new(MemoryPool::new("test", 100));
    pub fn peak(&self) -> usize {
    consumer: &'static str,
                .wait_timeout(guard, remaining.min(Duration::from_secs(1)))
/// freed/dropped, so the Java allocator can release exactly that grant.
}
                                );
    Wait(Duration),
            .field("used", &self.used.load(Ordering::Relaxed))
// ─────────────────────────────────────────────────────────────────────────────
use std::fmt;
                    Some(new_used)
pub struct PoolExhausted {
            self.pool.shrink(s);
            .fetch_update(Ordering::Relaxed, Ordering::Relaxed, |current| {
        assert!(res.request(200).is_ok());
    fn test_ignore_limit_drop_releases() {
        }
        assert!(res.request(512).is_ok());
                            } else {
        self.request(estimated)?;
    behavior: PoolBehavior,
    }
        )
    }
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
    pub fn pool(&self) -> &Arc<MemoryPool> {
        let pool = Arc::new(MemoryPool::new("test", 1024));
    /// Create a sibling reservation from the same pool with a different consumer name.
use std::sync::{Arc, Condvar, Mutex, OnceLock};
            self.grow(actual - estimated);
    /// Block until memory is available, up to the given timeout.
                            Ok(())
                                Err(Box::new(exhausted))
                if limit > 0 && new_used > limit {
        }
            );
// covers every pool that uses `Reject`.
        if bytes == 0 {
                                    "[RUST] over-commit refused by decider: pool '{}' consumer '{}' needed {} bytes beyond limit",
pub enum PoolBehavior {
        let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::Reject);
    fn test_try_grow_exceeds_limit() {
}
    match OVERCOMMIT_DECIDER.get() {
        self.peak.load(Ordering::Relaxed)
                                // Decider (Java allocator) granted based on node-level native pressure.
/// Releaser: called with the token of a reservation that held an over-commit permit when it is
            behavior,
/// Returns the over-commit permit identified by `token` back to the decider (Java allocator).
        }
                        Ok(())
        assert_eq!(pool.used(), 300);
        let pool = Arc::new(MemoryPool::new("test", 100));
/// Merge operations can wait longer (600 seconds).
static OVERCOMMIT_DECIDER: OnceLock<OverCommitDecider> = OnceLock::new();
                            if token != 0 {
        assert_eq!(res.size(), 0);
        let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::Reject);
            .field("name", &self.name)
        f.debug_struct("MemoryPool")
/*
        }
        if bytes == 0 {
    /// Attempt to reserve `bytes`. Returns error if it would exceed the limit.
        let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::Reject);
    pub fn try_grow(&self, bytes: usize) -> Result<(), PoolExhausted> {
                self.pool.name(),
 *
    pub fn size(&self) -> usize {
    /// decider declines.
        }
        Self {
}
            })
    }
                return Ok(());
/// (nonzero), or 0 when no decider is registered (feature effectively off) or the decider declines.
        if actual > estimated {
        self.notify.notify_all();
            }
                match self.pool.try_grow(bytes) {
    }
            peak: AtomicUsize::new(0),
                            // Already holding an over-commit permit for this reservation — continue
fn overcommit_grant() -> i64 {
/// Automatically releases all held memory on drop.
                self.size += bytes;
        self.size += bytes;
    #[test]
        if self.try_grow(bytes).is_ok() {
    pub fn limit(&self) -> usize {
        self.pool.shrink(actual);
}
                    }
impl std::error::Error for PoolExhausted {}
            crate::log_debug!(
    }
//! `MemoryReservation` is an RAII handle that automatically returns memory to the
        self.notify.notify_all();
                "[RUST] over-commit permit released on drop: pool '{}' consumer '{}' token {}",
                let new_used = used.checked_add(bytes)?;
                let limit = self.limit.load(Ordering::Relaxed);
    }
                            self.pool.grow(bytes);
                let used = self.used.load(Ordering::Relaxed);
                self.overcommit_token
//! significant memory call `try_grow` before allocating and `shrink` after freeing.
    /// one release).
        self.consumer
                self.pool.name(),
impl MemoryPool {
                    requested: bytes,
            behavior: self.behavior.clone(),
 * SPDX-License-Identifier: Apache-2.0
            .field("peak", &self.peak.load(Ordering::Relaxed))
        None => 0,
    }
            consumer,
    notify_lock: Mutex<()>,
        assert!(res.request(2048).is_err());
    fn test_set_limit_allows_growth() {
#[cfg(test)]
        }
                limit,
    pub pool_name: &'static str,
    /// Never block and never fail: account via infallible `grow`, allowing the pool to over-commit.
    }
            let remaining = timeout - elapsed;
    name: &'static str,
                                    bytes
            PoolBehavior::IgnoreLimit => {
        assert_eq!(child.consumer(), "child");
        assert!(pool.used() > pool.limit());
}
            let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::Reject);
        let mut child = res.child("child");
// `ArrowNativeAllocator` (it knows node-level native memory pressure, permits, and the feature
                }
    fn test_ignore_limit_exceeds_limit() {
//! pool on drop, preventing leaks even on error paths.
/// Error returned when a pool cannot satisfy an allocation request.
    /// Nonzero token of the over-commit permit held by this reservation (0 = none). The permit is
    peak: AtomicUsize,
                    used,
    pub fn new(name: &'static str, limit: usize) -> Self {
                    waited: elapsed,
    }
        }
    pub fn used(&self) -> usize {
    #[test]
//!
    /// Grow based on the reservation's behavior: block (Wait) or reject (Reject).
        }
pub const MERGE_WAIT_TIMEOUT: Duration = Duration::from_secs(600);
    /// Create a new pool. `limit = 0` means unlimited.
    pub waited: Duration,
            });
    /// Blocks until `bytes` can be reserved, or timeout expires.
    }
            self.shrink(estimated - actual);
    limit: AtomicUsize,
            notify: Condvar::new(),
            f,
            size: 0,
                            let token = overcommit_grant();
            return;
}
                self.pool.wait_and_grow(bytes, *timeout)?;
        assert!(res.request(200).is_err());
        assert_eq!(pool.used(), 0);
// flag). Java registers two C-ABI callbacks via FFM upcall stubs. Because all native modules are
        child.request(100).unwrap();
        Self {
        match &self.behavior {
            let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::IgnoreLimit);
                Ok(())
/// Controls how a reservation reacts when the pool is full.
    }
    IgnoreLimit,
                .notify
        }
impl fmt::Display for PoolTimeout {
    }
    }
        assert_eq!(pool.used(), 2000);
        let pool = Arc::new(MemoryPool::new("test", 100));
            overcommit_release(self.overcommit_token);
    let _ = OVERCOMMIT_DECIDER.set(decider);
    Reject,
        }
    pub fn grow(&mut self, bytes: usize) {
        let pool = Arc::new(MemoryPool::new("test", 1024));
            .finish()
 */
// linked into a single cdylib, these statics are a single shared instance and one registration
}
}
            self.pool.shrink(self.size);
        if self.overcommit_token != 0 {
        &mut self,
                                    self.consumer,
                Some(current.saturating_sub(bytes))
    }
//! Provides an atomic counter with a configurable limit. Operations that allocate
    }
            Ok(old) => {
        }
                                self.overcommit_token = token;
    pool: Arc<MemoryPool>,
}
pub fn set_overcommit_callbacks(decider: OverCommitDecider, releaser: OverCommitReleaser) {
    pub requested: usize,
        &self.pool
        // Already over the limit; further requests still succeed immediately.
            return;
    pub fn grow(&self, bytes: usize) {
pub struct MemoryPool {
    #[test]
        let s = self.size;
            res.request(500).unwrap();
                .unwrap();
//! Memory pool for tracking native memory usage across write and merge operations.
    pub fn reconcile(&mut self, estimated: usize, actual: usize) {
    #[test]
            .used
        self.pool.grow(bytes);
                            // over-committing without re-consulting the decider.
/// opaque handle minted by the Java allocator; Rust stores it and echoes it back on release.
            crate::log_debug!(
            return Ok(());
}
            if self.try_grow(bytes).is_ok() {
// The decision "may this reservation over-commit its pool right now?" is owned by the Java-side
            overcommit_token: 0,
        let pool = Arc::new(MemoryPool::new("test", 100));
            .unwrap();
    pub fn shrink(&self, bytes: usize) {
        self.limit.store(new_limit, Ordering::Release);
            }
                        }
        assert_eq!(pool.used(), 0);
        if self.overcommit_token != 0 {
        self.used.load(Ordering::Relaxed)
        let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::IgnoreLimit);
            Err(_) => Err(PoolExhausted {
    /// Release `bytes` back to the pool. Notifies any waiting threads.
    #[test]
    }
    #[test]
            f,
            let guard = self.notify_lock.lock().unwrap();
// Over-commit decider hook.
        if s > 0 {
    }
        }
                    None
            overcommit_token: 0,
    /// Infallible grow.
        assert_eq!(pool.used(), 0);
        let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::IgnoreLimit);
        write!(
        {
        Some(decide) => decide(),
    pub fn wait_and_grow(&self, bytes: usize, timeout: Duration) -> Result<(), PoolTimeout> {
        assert_eq!(pool.peak(), 800);
    }
            name,
 * The OpenSearch Contributors require contributions made to
impl fmt::Display for PoolExhausted {
        let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::Reject);
        let pool = Arc::new(MemoryPool::new("test", 1024));
 * compatible open source license.
                    pool_name: self.name,
    }
