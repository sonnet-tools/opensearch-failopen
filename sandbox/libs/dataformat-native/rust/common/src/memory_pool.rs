                    pool_name: self.name,
    }
                            let token = overcommit_grant();
        let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::IgnoreLimit);
                                    "[RUST] over-commit granted: pool '{}' consumer '{}' token {} committing {} bytes beyond limit (reservation size now {})",
    pub fn size(&self) -> usize {
fn overcommit_grant() -> i64 {
        write!(
        let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::Reject);
            .field("name", &self.name)
}
pub const MERGE_WAIT_TIMEOUT: Duration = Duration::from_secs(600);
//! The pool rejects allocations that would exceed the configured limit.
        assert_eq!(pool.used(), 300);
        {
                self.consumer,
                self.pool.name(),
            });
    #[test]
            used: AtomicUsize::new(0),
        assert_eq!(pool.used(), 512);
        let pool = Arc::new(MemoryPool::new("test", 1024));
                                    self.pool.name(),
            res.request(500).unwrap();
            pool: Arc::clone(pool),
        let start = std::time::Instant::now();
    pub pool_name: &'static str,
pub fn set_overcommit_callbacks(decider: OverCommitDecider, releaser: OverCommitReleaser) {
    pub fn reserve_estimated(
    /// If actual > estimated: infallible grow for the delta.
    }
        let pool = Arc::new(MemoryPool::new("test", 100));
        let pool = Arc::new(MemoryPool::new("test", 1024));
    IgnoreLimit,
                match self.pool.try_grow(bytes) {
#[derive(Debug, Clone)]
                self.pool.wait_and_grow(bytes, *timeout)?;
            .fetch_update(Ordering::Relaxed, Ordering::Relaxed, |current| {
//! pool on drop, preventing leaks even on error paths.
            })
                self.overcommit_token
    /// reservation is freed/dropped. Falls back to a plain reject when no decider is registered or the
                                );
    pub requested: usize,
/// Merge operations can wait longer (600 seconds).
    }
                if limit > 0 && new_used > limit {
        f.debug_struct("MemoryPool")
                    }
pub enum PoolBehavior {
            return Ok(());
        if bytes == 0 {
            self.overcommit_token = 0;
    fn test_set_limit_allows_growth() {
        }
        let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::Reject);
                .unwrap();
        self.notify.notify_all();
#[derive(Debug, Clone)]
//! Provides an atomic counter with a configurable limit. Operations that allocate
    }
/// A node-level memory pool backed by an atomic counter with blocking wait support.
        self.size += bytes;
// The decision "may this reservation over-commit its pool right now?" is owned by the Java-side
        }
/// Error returned when a pool cannot satisfy an allocation request.
        let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::Reject);
                        Ok(())
        }
            let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::Reject);
        if self.overcommit_token != 0 {
 * SPDX-License-Identifier: Apache-2.0
impl std::error::Error for PoolExhausted {}
                            self.size += bytes;
            pool: Arc::clone(&self.pool),
// Over-commit decider hook.
    }
    Reject,
            crate::log_debug!(
        }
    /// Reserve an estimated amount. Returns the estimated amount for later use with `reconcile()`.
        if actual > estimated {
//! Memory pool for tracking native memory usage across write and merge operations.
        assert!(res.request(512).is_ok());
        {
                used: self.used.load(Ordering::Relaxed),
        self.pool.grow(bytes);
                .wait_timeout(guard, remaining.min(Duration::from_secs(1)))
                                    self.size
        let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::Reject);
            overcommit_release(self.overcommit_token);
        let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::IgnoreLimit);
 * this file be licensed under the Apache-2.0 license or a
        Self {
        self.peak.load(Ordering::Relaxed)
                            // over-committing without re-consulting the decider.
/// (nonzero), or 0 when no decider is registered (feature effectively off) or the decider declines.
                                    bytes
                            if token != 0 {
    pub fn consumer(&self) -> &'static str {
                limit,
        self.used
            crate::log_debug!(
//!
    pub fn free(&mut self) -> usize {
        release(token);
    pub fn new(name: &'static str, limit: usize) -> Self {
pub struct PoolTimeout {
use std::sync::atomic::{AtomicUsize, Ordering};
    /// allocator) grants an over-commit based on node-level native memory pressure. When granted, the
        }
        assert_eq!(res.size(), 0);
        assert_eq!(pool.used(), 100);
            );
    #[test]
        // Wake waiters — new limit might allow blocked allocations
/// Releaser: called with the token of a reservation that held an over-commit permit when it is
            assert_eq!(pool.used(), 500);
        }
//! `MemoryReservation` is an RAII handle that automatically returns memory to the
    }
        }
    }
    pub fn used(&self) -> usize {
}
}
pub type OverCommitDecider = extern "C" fn() -> i64;
            );
        assert!(pool.used() > pool.limit());
        assert_eq!(pool.used(), 0);
    }
    pub pool_name: &'static str,
    /// Blocks until `bytes` can be reserved, or timeout expires.
    match OVERCOMMIT_DECIDER.get() {
    /// Grow based on the reservation's behavior: block (Wait) or reject (Reject).
        if s > 0 {
/// Registers the over-commit decision callbacks. Idempotent — first registration wins.
            return;
    pub fn shrink(&mut self, bytes: usize) {
    pub fn peak(&self) -> usize {
    pool: Arc<MemoryPool>,
                            self.pool.grow(bytes);
            self.size = 0;
    }
        estimated: usize,
    /// Infallible grow.
            "[{}] timed out waiting for {} bytes after {:?} (used: {}, limit: {})",
    pub fn set_limit(&self, new_limit: usize) {
        self.size
//! significant memory call `try_grow` before allocating and `shrink` after freeing.
}
    }
    }
    notify: Condvar,
        }
    pub fn wait_and_grow(&self, bytes: usize, timeout: Duration) -> Result<(), PoolTimeout> {
    #[test]
    }
            }
        if bytes == 0 {
            if elapsed >= timeout {
    }
        loop {
    }
        self.name
impl std::error::Error for PoolTimeout {}
    fn test_peak_tracking() {
            let remaining = timeout - elapsed;
                                    self.pool.name(),
    #[test]
                self.pool.grow(bytes);
                }
    }
}
                            Ok(())
/// Returns the over-commit permit identified by `token` back to the decider (Java allocator).
            let guard = self.notify_lock.lock().unwrap();
        assert_eq!(res.size(), 500);
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
    /// returned to the decider (with this token) when the reservation is freed/dropped (one grant ↔
        Self {
            overcommit_token: 0,
    #[test]
    /// reservation over-commits via infallible `grow` and the decider is told to release when the
fn overcommit_release(token: i64) {
            name,
pub struct PoolExhausted {
            let elapsed = start.elapsed();
                "[RUST] over-commit permit released on drop: pool '{}' consumer '{}' token {}",
                self.pool.name(),
        self.request(estimated)?;
            return Ok(());
                    Ok(()) => {
/// Automatically releases all held memory on drop.
    pub fn request(&mut self, bytes: usize) -> Result<(), Box<dyn std::error::Error>> {
        let pool = Arc::new(MemoryPool::new("test", 1024));
    fn test_try_grow_exceeds_limit() {
    pub requested: usize,
        let pool = Arc::new(MemoryPool::new("test", 100));
                                crate::log_debug!(
    }
    #[test]
    /// Nonzero token of the over-commit permit held by this reservation (0 = none). The permit is
/// Asks the registered decider whether an over-commit may proceed. Returns the granted token id
                });
    limit: AtomicUsize,
    }
        let new_used = self.used.fetch_add(bytes, Ordering::Relaxed) + bytes;
    pub waited: Duration,
// ─────────────────────────────────────────────────────────────────────────────
                        self.size += bytes;
mod tests {
/// Controls how a reservation reacts when the pool is full.
}
/// RAII handle that tracks a portion of memory reserved from a [`MemoryPool`].
        self.used.load(Ordering::Relaxed)
            overcommit_release(self.overcommit_token);
#[cfg(test)]
        assert_eq!(res.size(), 512);
    }
                                Err(Box::new(exhausted))
    fn test_ignore_limit_drop_releases() {
        }
 * The OpenSearch Contributors require contributions made to
    ) -> Result<usize, Box<dyn std::error::Error>> {
                                crate::log_debug!(
            PoolBehavior::Wait(timeout) => {
 * compatible open source license.
    /// Create a sibling reservation from the same pool with a different consumer name.
            }
                            }
            PoolBehavior::IgnoreLimit => {
    }
    /// Block until memory is available, up to the given timeout.
// ─────────────────────────────────────────────────────────────────────────────
                                    bytes,
            .field("limit", &self.limit.load(Ordering::Relaxed))
}
    pub fn name(&self) -> &'static str {
                        }
                                // Decider (Java allocator) granted based on node-level native pressure.
            self.pool.shrink(s);
        child.request(100).unwrap();
            .fetch_update(Ordering::Relaxed, Ordering::Relaxed, |used| {
                                );
    let _ = OVERCOMMIT_DECIDER.set(decider);
                                    "[RUST] over-commit refused by decider: pool '{}' consumer '{}' needed {} bytes beyond limit",
    }
    }
    pub fn pool(&self) -> &Arc<MemoryPool> {
        }
                                    token,
    pub fn child(&self, consumer: &'static str) -> Self {
                    Some(new_used)
    pub fn grow(&self, bytes: usize) {
                    limit,
        assert!(res.request(200).is_err());
        }
    Wait(Duration),
        // Request far beyond the limit — must succeed and over-commit.
            }
            }),
    /// Release `bytes` from this reservation.
static OVERCOMMIT_DECIDER: OnceLock<OverCommitDecider> = OnceLock::new();
    }
            Err(_) => Err(PoolExhausted {
    /// Release all memory back to the pool.
            return Ok(());
            notify_lock: Mutex::new(()),
                                    self.consumer,
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
 */
// linked into a single cdylib, these statics are a single shared instance and one registration
    fn test_child_reservation() {
pub const DEFAULT_WAIT_TIMEOUT: Duration = Duration::from_secs(300);
use std::sync::{Arc, Condvar, Mutex, OnceLock};
    pub limit: usize,
            .finish()
        // Already over the limit; further requests still succeed immediately.
            }
            consumer,
}
        match result {
                self.size += bytes;
    }
        if bytes == 0 {
                    requested: bytes,
            behavior: self.behavior.clone(),
        )
                    None
        Ok(estimated)
            res.request(500).unwrap();
    overcommit_token: i64,
                } else {
                Ok(())
    /// Create a new pool. `limit = 0` means unlimited.
/// Error returned when wait_and_grow times out.
            if self.try_grow(bytes).is_ok() {
                let used = self.used.load(Ordering::Relaxed);
        }
                let new_used = used.checked_add(bytes)?;
    pub used: usize,
                    }
        }
        s
            Ok(old) => {
                    Err(exhausted) => {
                requested: bytes,
    }
    /// decider declines.
                            // Already holding an over-commit permit for this reservation — continue
    #[test]
    }
        let pool = Arc::new(MemoryPool::new("test", 100));
            self.pool_name, self.requested, self.waited, self.used, self.limit
                .notify
                return Ok(());
    #[test]
impl Drop for MemoryReservation {
                                    self.consumer,
    size: usize,
        if self.size > 0 {
        pool.set_limit(500);
        } else if actual < estimated {
        }
    if let Some(release) = OVERCOMMIT_RELEASER.get() {
        self.notify.notify_all();
    /// Reconcile a previous estimate with the actual measured size.
        if bytes == 0 {
            }
}
        Self {
                "[RUST] over-commit permit released: pool '{}' consumer '{}' token {}",
            return;
pub struct MemoryPool {
            notify: Condvar::new(),
}
    pub limit: usize,
        assert!(res.request(2048).is_err());
    let _ = OVERCOMMIT_RELEASER.set(releaser);
    behavior: PoolBehavior,
    /// Never block and never fail: account via infallible `grow`, allowing the pool to over-commit.
            f,
                Ok(())
        let res = MemoryReservation::new(&pool, "parent", PoolBehavior::Reject);
                pool_name: self.name,
    /// Release `bytes` back to the pool. Notifies any waiting threads.
impl fmt::Debug for MemoryPool {
    use super::*;
            self.pool.shrink(self.size);
}
    }
            "[{}] memory limit exceeded: requested {} bytes, used {}, limit {}",
        self.limit.store(new_limit, Ordering::Release);
    }
        let result = self
static OVERCOMMIT_RELEASER: OnceLock<OverCommitReleaser> = OnceLock::new();
// `ArrowNativeAllocator` (it knows node-level native memory pressure, permits, and the feature
        }
    }
        assert_eq!(pool.peak(), 800);
        res.request(800).unwrap();
    fn drop(&mut self) {
impl fmt::Display for PoolTimeout {
        self.peak.fetch_max(new_used, Ordering::Relaxed);
        let limit = self.limit.load(Ordering::Relaxed);
        let pool = Arc::new(MemoryPool::new("test", 1024));
        let s = self.size;
        &self.pool
    fn test_drop_releases_memory() {
                                self.pool.grow(bytes); // infallible over-commit
    /// Atomically update the limit. Called by the Java rebalancer.
            .field("peak", &self.peak.load(Ordering::Relaxed))
    }
            f,
/*
impl fmt::Display for PoolExhausted {
// covers every pool that uses `Reject`.
impl MemoryPool {
            let _ = self
//!
                }
        None => 0,
        assert_eq!(pool.used(), 500);
        let pool = Arc::new(MemoryPool::new("test", 1024));
    /// one release).
        }
    fn test_try_grow_within_limit() {
            let mut res = MemoryReservation::new(&pool, "writer", PoolBehavior::IgnoreLimit);
        &mut self,
            .field("used", &self.used.load(Ordering::Relaxed))
                    used,
//
        match &self.behavior {
use std::time::Duration;
            consumer,
                Ok(())
}
    pub fn limit(&self) -> usize {
    name: &'static str,
    /// If actual < estimated: shrink the excess.
        assert_eq!(pool.used(), 0);
    pub fn shrink(&self, bytes: usize) {
    }
                        if self.overcommit_token != 0 {
        assert!(res.request(1000).is_ok());
#[derive(Debug, Clone)]
                            } else {
    }
        assert!(res.request(200).is_ok());
        write!(
}
                self.overcommit_token
        }
    peak: AtomicUsize,
        self.pool.shrink(actual);
}
                    waited: elapsed,
    notify_lock: Mutex<()>,
            self.pool_name, self.requested, self.used, self.limit
/// Default timeout for blocking wait (300 seconds).
        let pool = Arc::new(MemoryPool::new("test", 100));
        if self.overcommit_token != 0 {
    consumer: &'static str,
            peak: AtomicUsize::new(0),
use std::fmt;
    pub fn new(pool: &Arc<MemoryPool>, consumer: &'static str, behavior: PoolBehavior) -> Self {
/// freed/dropped, so the Java allocator can release exactly that grant.
        assert_eq!(pool.used(), 0);
    }
            size: 0,
            limit: AtomicUsize::new(limit),
    used: AtomicUsize,
                                self.overcommit_token = token;
            behavior,
    }
    /// Returns a reference to the underlying pool.
            PoolBehavior::Reject => {
            .used
        )
    #[test]
    }
            self.shrink(estimated - actual);
        let actual = bytes.min(self.size);
                return Err(PoolTimeout {
    }
    }
                                self.size += bytes;
            overcommit_token: 0,
    pub fn grow(&mut self, bytes: usize) {
}
                self.peak.fetch_max(old + bytes, Ordering::Relaxed);
            }
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
/// opaque handle minted by the Java allocator; Rust stores it and echoes it back on release.
    fn test_ignore_limit_never_fails_when_already_over() {
            size: 0,
pub struct MemoryReservation {
        assert!(res.request(500).is_ok());
    pub fn reconcile(&mut self, estimated: usize, actual: usize) {
impl MemoryReservation {
 *
        }
            self.grow(actual - estimated);
    pub fn try_grow(&self, bytes: usize) -> Result<(), PoolExhausted> {
        self.size -= actual;
                let limit = self.limit.load(Ordering::Relaxed);
        if self.try_grow(bytes).is_ok() {
            .unwrap();
pub type OverCommitReleaser = extern "C" fn(i64);
        Some(decide) => decide(),
    fn test_ignore_limit_exceeds_limit() {
                Some(current.saturating_sub(bytes))
        res.request(1000).unwrap();
                self.size += bytes;
            assert_eq!(pool.used(), 500);
                                Ok(())
    pub used: usize,
        self.consumer
                        } else {
                self.consumer,
        self.limit.load(Ordering::Relaxed)
    /// Infallible grow — use when the allocation has already happened.
// flag). Java registers two C-ABI callbacks via FFM upcall stubs. Because all native modules are
    /// Attempt to reserve `bytes`. Returns error if it would exceed the limit.
/// Decider: returns a nonzero token id to grant an over-commit, or 0 to reject. The token is an
        let mut child = res.child("child");
        assert_eq!(pool.used(), 2000);
        res.shrink(500);
    /// Fail immediately if the pool is full, unless the registered over-commit decider (the Java-side
        assert_eq!(child.consumer(), "child");
