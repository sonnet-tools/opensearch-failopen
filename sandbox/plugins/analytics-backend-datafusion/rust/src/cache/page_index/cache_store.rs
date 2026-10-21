            }));
//! cold-path operation (file deletion or merge), not on the query hot path.
    V: Clone + Send + Sync + 'static,
                .unwrap_or(0);
    fn entry_too_large_is_dropped() {
    }
//! **`evict_by_prefix`** is the only O(n) operation: it scans the eviction
            if let Some((_, (_, size))) = self.map.remove(&victim) {
{
        fn new(s: impl Into<String>) -> Self {
        assert!(s.used_bytes <= 200);
        w.limit = limit;
}
        cache.evict_by_prefix("hot/");
        c.insert(Key::new("c"), vec![], 4);
    #[test]
        for entry in cache.map.iter() {
    policy: P,
    /// Pop and return the next eviction candidate.
        for t in 0..3usize {
//! The eviction policy is called inside the lock for consistency.
            hits: self.hits.load(Relaxed),
    used_bytes_snapshot: AtomicUsize,
            self.evictions.fetch_add(evicted, Relaxed);
            h.join().unwrap();
        assert_eq!(c.stats().used_bytes, 8);
        let c = make_cache(1024);
    /// Evict policy victims until `used_bytes <= limit`.
        }
            used_bytes: 0,
        for t in 0..4usize {
/// Fallback byte budget used only in tests that bypass the Java startup path.
    #[test]
/// In production the Java settings consumer always calls
        let limit = self.limit_snapshot.load(Relaxed);
    evictions: AtomicU64,
//!
}
            c1.insert(k, v, s);
where
//!
}
        while w.used_bytes > w.limit {
    /// Stale victims (overwritten entries) are skipped via lazy deletion.
    }
                evicted += 1;
        let map_total: usize = cache.map.iter().map(|e| e.value().1).sum();
    }
        );
/// `on_access` needs to update state from the read path, it would need its own
        let mut handles = vec![];
    impl Key {
    fn on_access(&self, key: &K);
    fn insert_batch_one_lock_same_result_as_individual() {
///
    hits: AtomicU64,
            .filter(|e| e.key().to_string().starts_with(prefix))
// ── Write-lock state ─────────────────────────────────────────────────────────
            }
            limit_snapshot: AtomicUsize::new(limit),
        c.insert(Key::new("huge"), vec![], 11);
            w.used_bytes += size;
        let map_total: usize = cache.map.iter().map(|e| e.value().1).sum();
        }
            unreachable!("BoundedCache only supports Fifo; use CustomStatisticsCache for Lru/Lfu");
        }
                    c.insert(Key::new(format!("cold/t{t}:k{i}")), vec![], 10);
        if evicted > 0 {
        drop(w);
    used_bytes: usize,
    /// Byte cap snapshot for lock-free `stats()`.
/// 3. Expose a `PolicyType` variant in the Java API and route it from
            policy,
    // ── basic correctness ─────────────────────────────────────────────────────
    map: DashMap<K, (V, usize)>,
    }
        }
        let map_total: usize = cache.map.iter().map(|e| e.value().1).sum();
//! can be added later by implementing the same trait.
        let mut to_account: Vec<(K, usize, usize)> = Vec::new();
        assert_eq!(c.get(&Key::new("huge")), None);
    }
// ── Eviction policy trait ────────────────────────────────────────────────────
    /// cells for a vectored multi-column fetch). One lock + one eviction pass
        c.insert(Key::new("file2:col0"), vec![], 10);
    fn overwrite_does_not_leak_bytes() {
}
            "used_bytes={} > limit={}",
        const PER_THREAD: usize = 200;
        assert!(s.used_bytes <= LIMIT);
            let c = Arc::clone(&cache);
    // ── concurrency ───────────────────────────────────────────────────────────
        let c = make_cache(10);
        c.clear_keep_limit();
        let cache = Arc::new(make_cache(LIMIT));
                    c.insert(Key::new(format!("t{t}:k{i}")), vec![], 10);
        }
        assert_eq!(c.stats().used_bytes, 10);
        self.used_bytes_snapshot.store(w.used_bytes, Relaxed);
            let c = Arc::clone(&cache);
            misses: AtomicU64::new(0),
        c.insert(Key::new("a"), vec![2], 5);
//!
    fn next_victim(&self) -> Option<K>;
    fn clear(&self) {
            if size > limit {
                for i in 0..300 {
    }
            }
    /// variant (e.g. `S3Fifo`) will be a compile error here until it's wired.
    ///
    fn concurrent_insert_batch_consistent() {
    pub(super) fn evict_by_prefix(&self, prefix: &str) {
                c2.set_limit(1000);
    fn clear_resets_all_state() {
            }
/// the `BoundedCache` write lock is held. `on_access` is a no-op for FIFO and
            let c = Arc::clone(&cache);
        assert_eq!(c1.get(&Key::new("b")), c2.get(&Key::new("b")));
    pub(super) fn with_policy(limit: usize, policy: P) -> Self {
    }
            }));
            self.policy.on_insert(key);
    }
}
        }
            hits: AtomicU64::new(0),
/// Snapshot of one scoped cache's counters plus occupancy.
}
        assert_eq!(c.get(&Key::new("file2:col0")), Some(vec![]));
            misses: self.misses.load(Relaxed),
        self.map.clear();
    ///
        for h in handles {
            }));
//! entry in the eviction queue. [`BoundedCache::drain_to_limit`] skips stale
}
        }
        c2.insert_batch(entries.into_iter());
///
    /// instead of N separate calls.
impl<K, V, P> BoundedCache<K, V, P>
/// all mutations. An additional inner lock on the queue would be a
            f.write_str(&self.0)
                }
    fn make_cache(limit: usize) -> BoundedCache<Key, Vec<u8>> {
    write: Mutex<WriteState>,
        self.queue_mut().retain(|k| k != key);
    struct Key(String);
        self.queue_mut().clear();
            return;
 * this file be licensed under the Apache-2.0 license or a
        assert_eq!(c.limit_snapshot.load(Relaxed), 1024);
    pub(super) fn get(&self, key: &K) -> Option<V> {
            to_account.push((key, size, old_size));
pub(super) struct BoundedCache<K, V, P = FifoPolicy<K>>
            if let Some((_, (_, size))) = self.map.remove(victim) {
// ── Tests ────────────────────────────────────────────────────────────────────
        for t in 0..3usize {
            (Key::new("b"), vec![2u8], 20),
        let c1 = make_cache(1024);
        }));
}
/*
    ///
        }
/// statics.
where
    /// The policy should record `key` as the most-recently inserted entry.
                .map
///
    /// Called when an entry is explicitly removed (prefix eviction, clear).
        for h in handles {
            s.used_bytes
        let map_total: usize = cache.map.iter().map(|e| e.value().1).sum();
    fn on_access(&self, _key: &K) {
        }
        let entries = vec![
    misses: AtomicU64,
        assert_eq!(s.evictions, 0);
    fn insert_and_get_roundtrip() {
        let cache = Arc::new(make_cache(1000));
        match self.map.get(key) {
//! ```
impl<K: Clone + PartialEq + Send + Sync> ScopedEvictionPolicy<K> for FifoPolicy<K> {
        if to_account.is_empty() {
use dashmap::DashMap;
            LIMIT
        assert_eq!(c.get(&Key::new("missing")), None);
pub(crate) const DEFAULT_SCOPED_CACHE_LIMIT: usize = 150 * 1024 * 1024;
    fn concurrent_inserts_stay_within_limit() {
        for (key, size, old_size) in to_account {
pub struct ScopedCacheStats {
//! [`FifoPolicy`] is the only implementation. S3-FIFO (ghost-set promotion)
//!
    }
        c.insert(Key::new("a"), vec![], 10);
        assert_eq!(c.get(&Key::new("file1:col1")), None);
/// plugin initialization before any query runs, so this value is never used
//!  ├── Mutex<{ used_bytes, limit }>  ← write-path accounting only
            return;
    fn concurrent_insert_and_evict_by_prefix_consistent() {
    }
        if evicted > 0 {
/// is called from the lock-free `get` path — it does not touch the queue.
            // adjusted at overwrite time — skip without double-decrementing.
        assert_eq!(c.get(&Key::new("a")), Some(vec![1, 2, 3]));
        let map_total: usize = cache.map.iter().map(|e| e.value().1).sum();
    pub evictions: u64,
//! **Lazy deletion on overwrite**: re-inserting an existing key leaves a stale
    /// Insert multiple entries under a single write-lock acquisition.
        assert_eq!(c1.get(&Key::new("c")), c2.get(&Key::new("c")));
            // If map.remove returned None: stale entry, used_bytes already
        let victims: Vec<K> = self
                self.hits.fetch_add(1, Relaxed);
        if evicted > 0 {
    /// Update the byte cap and immediately evict if over budget.
    /// Called repeatedly by [`BoundedCache::drain_to_limit`] until
                self.policy.on_access(key);
        let CacheEvictionPolicy::Fifo = policy else {
/// # No inner lock
                    let batch = (0..5usize)
            (Key::new("a"), vec![1u8], 10),
        assert!(
            .unwrap_or(0);
    /// The match is exhaustive over `CacheEvictionPolicy` so adding a new
        assert!(s.evictions >= 1);
        assert!(cache.stats().used_bytes <= 20);
    pub used_bytes: usize,
        }
            limit,
        let mut evicted = 0u64;
    /// proving the extensibility point works without modifying `BoundedCache`.
        }
 *
        }
/// own locks — but must still be `Send + Sync` for the `Lazy<BoundedCache>`
    pub(super) fn insert(&self, key: K, value: V, size: usize) {
/// no-contention lock/unlock cycle with zero benefit. We use `UnsafeCell`
    K: Eq + Hash + Clone + Display + Send + Sync + 'static,
/// Insert-order (FIFO) eviction policy.
    }
//!
        let c = make_cache(1024);
/// they can be called through a shared reference. All methods are called from
    /// Create a cache with an explicit policy. Use this when plugging in a
 * SPDX-License-Identifier: Apache-2.0
        c.evict_by_prefix("file1");
            w.used_bytes = w.used_bytes.saturating_sub(old_size);
        let mut w = self.write.lock();
    /// `used_bytes <= limit`. The caller performs lazy deletion: if the
            .map
        self.queue_mut().push_back(key);
        assert_eq!(cache.get(&Key::new("x")), None, "x must have been evicted");
//! **Writes take one `parking_lot::Mutex`** for `used_bytes` + limit accounting.
        }
    /// Borrow the queue mutably. Caller must hold the outer write lock.
    K: Eq + Hash + Clone + Display + Send + Sync + 'static,
    }
    /// FIFO ignores this; frequency-aware policies (LFU, S3-FIFO) update
//!
        const THREADS: usize = 8;
    }
        assert!(
    /// Called when a new entry is inserted (or an existing key is overwritten).
/// are fully lock-free. Stale entries (from overwrites) are left in the queue
        }
        assert_eq!(map_total, cache.stats().used_bytes);
//! **Reads are lock-free** — `get` only touches the `DashMap` shard lock.
        }
    pub limit_bytes: usize,
        if size > limit {
//! **Pluggable eviction**: [`ScopedEvictionPolicy`] is the trait. Today
                .insert(key.clone(), (value, size))
    /// returned key is no longer in the `DashMap` (stale entry from an
                for i in 0..500 {
    }
    fn custom_policy_compiles_and_works() {
            .iter()
                std::hint::spin_loop();
//! # Architecture
        }
    /// for accounting; IO must be done by the caller before calling this.
                    let _ = c.get(&Key::new(format!("k{}", i % 20)));
    fn concurrent_reads_and_writes_no_panic() {
            .map(|e| e.key().clone())
    // ── pluggable policy ──────────────────────────────────────────────────────
    /// non-default policy (e.g. S3-FIFO in a future PR).
            .collect();
        // Collect victims by iterating the DashMap (avoids holding the write
        // FIFO does not track access order — no queue mutation, reads stay lock-free.
    K: Eq + Hash + Clone + Display + Send + Sync + 'static,
            handles.push(std::thread::spawn(move || {
            BoundedCache::with_policy(20, FifoPolicy::new());
/// Mutable accounting serialised under the `BoundedCache` write lock.
/// S3-FIFO (planned successor) wraps two FIFO queues with a ghost set. If its
        let cache = Arc::new(make_cache(LIMIT));
/// `set_column_index_cache_limit` / `set_offset_index_cache_limit` during
        self.limit_snapshot.store(limit, Relaxed);
    limit: usize,
        assert_eq!(c1.get(&Key::new("a")), c2.get(&Key::new("a")));
        c.insert(Key::new("b"), vec![], 20);
            let old_size = self
        );
use parking_lot::Mutex;
    }
impl<K> FifoPolicy<K> {
        drop(w);
        assert_eq!(c.get(&Key::new("a")), Some(vec![2]));
    fn used_bytes_tracks_inserts_and_evictions() {
            self.policy.on_remove(victim);
            .map(|(_, s)| s)
    pub misses: u64,
    fn on_remove(&self, key: &K);
        let cache = Arc::new(make_cache(4096));
//! queue to remove all cells for a deleted/replaced file. This is a rare
    ///
        // lock while doing string comparisons on every FIFO entry).
/// inside the `BoundedCache` write lock, so implementations do not need their
        }
        let cache: BoundedCache<Key, Vec<u8>, FifoPolicy<Key>> =
            entries: self.map.len(),
    }
        self.misses.store(0, Relaxed);
        }
        }
    /// Allows the policy to remove the entry from its internal bookkeeping.
        let c = make_cache(1024);
// ── FIFO policy ──────────────────────────────────────────────────────────────
    fn drain_to_limit(&self, w: &mut WriteState) -> u64 {
                w.used_bytes = w.used_bytes.saturating_sub(old_size);
    /// Called when an entry is accessed on the hot read path.
        self.used_bytes_snapshot.store(0, Relaxed);
    }
        let mut handles = vec![];
        // DashMap updates are outside the write lock — independently concurrent.
        let s = cache.stats();
        let evicted = self.drain_to_limit(&mut w);
        }
            evictions: AtomicU64::new(0),
        Self::with_policy(limit, FifoPolicy::new())
///
    /// Preferred when a query produces several cells at once (e.g. all CI
            s.used_bytes <= 10,
    #[inline]
                for i in 0..PER_THREAD {
            self.evictions.fetch_add(evicted, Relaxed);
        Self::with_named_policy(limit, CacheEvictionPolicy::Fifo)
    #[test]
    #[test]
    impl std::fmt::Display for Key {
    /// access counts here.
    }
    #[test]
                for i in 0..300 {
    #[test]
    limit_snapshot: AtomicUsize,
        let c = make_cache(10);
        for victim in &victims {
}
//!
    /// Create a new cache with FIFO eviction — shorthand for tests.
        let mut handles = vec![];
            }));
                }
    fn concurrent_set_limit_and_inserts_consistent() {
            self.evictions.fetch_add(evicted, Relaxed);
    pub(super) fn new(limit: usize) -> Self {
        assert_eq!(map_total, s.used_bytes);
            for _ in 0..20 {
            return;
    }
            handles.push(std::thread::spawn(move || {
    }
                evicted += 1;
    }
    }
        assert_eq!(c.stats().used_bytes, 0);
        self.policy.clear();
// ── BoundedCache ─────────────────────────────────────────────────────────────
/// `BoundedCache`'s outer `Mutex<WriteState>` lock, which already serializes
        if evicted > 0 {
/// 1. Implement this trait with interior mutability.
    /// Reset all internal state (called on `clear_keep_limit`).
    pub(super) fn new() -> Self {
    fn on_insert(&self, key: K);
        assert_eq!(map_total, s.used_bytes);
    /// overwrite), `drain_to_limit` skips it and calls `next_victim` again.
    P: ScopedEvictionPolicy<K>,
//! victims with a single `DashMap::remove` miss — O(1) overwrite, no O(n)
//! retain scan.
        drop(w);
struct WriteState {
    pub(super) fn insert_batch(&self, entries: impl IntoIterator<Item = (K, V, usize)>) {
    P: ScopedEvictionPolicy<K>,
            handles.push(std::thread::spawn(move || {
        self.evictions.store(0, Relaxed);
            // Overwrite: update byte accounting. Stale FIFO entry is left in
//! Byte-bounded concurrent cache with a pluggable eviction policy.
                for i in 0..500 {
        }
    pub(crate) fn with_named_policy(limit: usize, policy: CacheEvictionPolicy) -> Self {
                }
        c.insert(Key::new("a"), vec![], 4);
        if old_size > 0 {
/// string representation (e.g. `"path:col:rg"` → prefix `"path"`).
            handles.push(std::thread::spawn(move || {
        let limit = self.limit_snapshot.load(Relaxed);
    /// Guarded by the outer `BoundedCache` write lock — no inner lock needed.
/// The eviction queue lives in the policy; this struct tracks only bytes.
    pub entries: usize,
        let s = cache.stats();
    /// Must be called inside the write lock.
            };
#[derive(Debug, Clone, Copy, PartialEq, Eq, Default)]
        let mut handles = vec![];
        c.insert(Key::new("a"), vec![1], 10);
///
use std::cell::UnsafeCell;
            h.join().unwrap();
        c.insert(Key::new("file1:col1"), vec![], 10);
/// instead, with the outer lock as the synchronization invariant.
/// interior mutability (e.g. atomics for frequency counters).
        self.used_bytes_snapshot.store(w.used_bytes, Relaxed);
    /// Lock-free read. Contends only on the DashMap per-shard read lock.
//!  ├── DashMap<K, (V, usize)>        ← lock-free concurrent reads
        self.hits.store(0, Relaxed);
        self.policy.on_insert(key);
{
        fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
            h.join().unwrap();
                .map(|(_, s)| s)
unsafe impl<K: Send> Send for FifoPolicy<K> {}
        let mut w = self.write.lock();
        let c2 = Arc::clone(&cache);
        cache.insert(Key::new("z"), vec![], 10); // triggers eviction of "x"
    /// Byte accounting under one lock. The eviction queue lives in `policy`.
        }
    #[test]
 */
    /// Drop all entries and reset counters, keeping the current limit.
    /// Only `Fifo` is accepted — `Lru`/`Lfu` belong to `CustomStatisticsCache`.
        };
        cache.insert(Key::new("x"), vec![], 10);
        drop(w);
        // A trivial "always evict the first key ever inserted" policy (same as FIFO).
            .map
    /// Eviction policy — uses interior mutability, called inside `write` lock.
// SAFETY: `FifoPolicy` is only mutated under `BoundedCache`'s `Mutex<WriteState>`.
    }
            let c = Arc::clone(&cache);
            self.evictions.fetch_add(evicted, Relaxed);
        c.insert(Key::new("b"), vec![], 4);
                }
/// outside tests.
        let mut w = self.write.lock();
        BoundedCache::new(limit)
}
    }
    /// Value store — DashMap for lock-free concurrent reads.
                }
            let c = Arc::clone(&cache);
        }
            if old_size > 0 {
        Self {
        }
/// Every method that calls `queue_mut()` or `queue_ref()` must be called while
                break;
        const LIMIT: usize = THREADS * PER_THREAD * ENTRY_SIZE / 4;
///
        const LIMIT: usize = THREADS * 50 * 5 * 8 / 3;
        let limit = cache.limit_snapshot.load(Relaxed);
    }
    pub(super) fn clear_keep_limit(&self) {
            h.join().unwrap();
        let mut evicted = 0u64;
            handles.push(std::thread::spawn(move || {
        for t in 0..THREADS {
//!  └── P (eviction policy)           ← owns the eviction queue, uses interior mutability
            let c = Arc::clone(&cache);
            used_bytes_snapshot: AtomicUsize::new(0),
            .insert(key.clone(), (value, size))
                }
        let old_size = self
///
        let s = c.stats();
use std::fmt::Display;
            assert!(!entry.key().0.starts_with("hot/"));
        self.used_bytes_snapshot.store(w.used_bytes, Relaxed);
where
    /// Used when a parquet file is deleted or replaced.
        let s = cache.stats();
        }
    #[test]
            "used_bytes={} must be <= limit=10",
            s.used_bytes,
        assert_eq!(c.stats().used_bytes, 5);
pub(super) struct FifoPolicy<K> {
    /// Create a `BoundedCache` with the named eviction policy.
        if victims.is_empty() {
    fn next_victim(&self) -> Option<K> {
                for b in 0..50usize {
    pub hits: u64,
        for _ in 0..4 {
    fn queue_mut(&self) -> &mut VecDeque<K> {
{
                    c.insert_batch(batch);
        let evicted = self.drain_to_limit(&mut w);
            }
    #[test]
        assert_eq!(map_total, s.used_bytes);
///
        drop(w);
        }
    /// O(n) scan of the eviction queue — cold path only (file deletion/merge).
    }
            let Some(victim) = self.policy.next_victim() else {
            // place for lazy deletion by drain_to_limit.
//!  BoundedCache<K, V, P: ScopedEvictionPolicy<K>>
    }
        ScopedCacheStats {
            }));
            }
unsafe impl<K: Send> Sync for FifoPolicy<K> {}
                        .map(|i| (Key::new(format!("t{t}:b{b}:i{i}")), vec![t as u8], 8));
                    c.insert(Key::new(format!("t{t}:k{i}")), vec![t as u8], ENTRY_SIZE);
            Key(s.into())
        for (key, value, size) in entries {
        }
///
        let c2 = make_cache(1024);
        let evicted = self.drain_to_limit(&mut w);
            s.used_bytes <= LIMIT,
/// All `ScopedEvictionPolicy` methods are called exclusively from inside
                c2.set_limit(200);
    #[test]
    /// If `size > limit` the entry is silently dropped. Takes the write lock
        handles.push(std::thread::spawn(move || {
pub(super) trait ScopedEvictionPolicy<K>: Send + Sync {
/// `K` must implement `Display` so `evict_by_prefix` can match keys by their
        evicted
///    `df_create_cache` in `ffm.rs`.
        let s = cache.stats();
    fn evict_by_prefix_removes_matching_entries() {
        assert_eq!(s.misses, 0);
        }
    /// Verify that `with_policy` compiles and works with a custom policy,
        }
        assert_eq!(s.entries, 0);
/// Pluggable eviction policy for [`BoundedCache`].
        let mut w = self.write.lock();
    #[test]
 * The OpenSearch Contributors require contributions made to
            h.join().unwrap();
        for h in handles {
    /// Lock-free stats snapshot.
        assert_eq!(s.used_bytes, 0);
    }
/// Surfaced on node-stats and used by tests.
use std::hash::Hash;
        let s = c.stats();
use crate::eviction_policy::CacheEvictionPolicy;
            (Key::new("c"), vec![3u8], 30),
use std::sync::atomic::{AtomicU64, AtomicUsize, Ordering::Relaxed};
                Some(entry.0.clone())
    /// Evict all entries whose `Display` representation starts with `prefix`.
    }
        self.queue_mut().pop_front()
#[cfg(test)]
                self.misses.fetch_add(1, Relaxed);
        cache.insert(Key::new("y"), vec![], 10);
    fn on_insert(&self, key: K) {
        c.insert(Key::new("a"), vec![1, 2, 3], 3);
    V: Clone + Send + Sync + 'static,
        for h in handles {
        w.used_bytes = 0;
impl WriteState {
mod tests {
            map: DashMap::new(),
///
            write: Mutex::new(WriteState::new(limit)),
    use super::*;
        w.used_bytes += size;
            limit_bytes: self.limit_snapshot.load(Relaxed),
        Self {
        ];
        self.used_bytes_snapshot.store(w.used_bytes, Relaxed);
    }
/// Implementations must use interior mutability (`Mutex`, atomics, etc.) so
        // SAFETY: caller holds the `BoundedCache` write lock.
        for t in 0..4usize {
            handles.push(std::thread::spawn(move || {
    fn clear(&self);
    use std::sync::Arc;
        assert_eq!(c1.stats().used_bytes, c2.stats().used_bytes);
                }
/// # Safety invariant
        Self {
    }
                    c.insert(Key::new(format!("hot/t{t}:k{i}")), vec![], 10);
        c.insert(Key::new("file1:col0"), vec![], 10);
    #[test]
        }
            Some(entry) => {
    pub(super) fn stats(&self) -> ScopedCacheStats {
    V: Clone + Send + Sync + 'static,
            queue: UnsafeCell::new(VecDeque::new()),
        let mut w = self.write.lock();
                None
    }
            }));
}
    #[derive(Clone, PartialEq, Eq, Hash)]
            handles.push(std::thread::spawn(move || {
        const THREADS: usize = 8;
                w.used_bytes = w.used_bytes.saturating_sub(size);
        const ENTRY_SIZE: usize = 10;
            evictions: self.evictions.load(Relaxed),
    queue: UnsafeCell<VecDeque<K>>,
            let c = Arc::clone(&cache);
use std::collections::VecDeque;
        assert_eq!(s.hits, 0);
                for i in 0..400 {
        for (k, v, s) in entries.clone() {
    }
                continue;
                    c.insert(Key::new(format!("k{}", i % 20)), vec![t as u8], 10);
    pub(super) fn set_limit(&self, limit: usize) {
            used_bytes: self.used_bytes_snapshot.load(Relaxed),
        }
    fn on_remove(&self, key: &K) {
            None => {
    // Lock-free diagnostic counters.
        }
    ///
            }
/// # Implementing a new policy
    }
 * compatible open source license.
    fn new(limit: usize) -> Self {
        for t in 0..THREADS {
        for h in handles {
/// Byte-bounded concurrent cache parameterised over an eviction policy `P`.
        }
            }
        assert_eq!(map_total, s.used_bytes);
    }
    /// Insert a key-value pair with its byte cost.
    #[test]
                w.used_bytes = w.used_bytes.saturating_sub(size);
        use crate::cache::eviction_policy::CacheEvictionPolicy;
//! ```text
impl<K, V> BoundedCache<K, V, FifoPolicy<K>>
        assert!(s.used_bytes <= limit);
        unsafe { &mut *self.queue.get() }
        assert_eq!(c.get(&Key::new("file1:col0")), None);
            }));
        // O(n) scan — only called from evict_by_prefix (cold path).
        let mut handles = vec![];
/// Oldest-inserted entry is evicted first. Access order is not tracked — reads
        let c = make_cache(1024);
/// 2. Wire it in `mod.rs` by passing it to `BoundedCache::new`.
        let cache = Arc::new(make_cache(200));
/// and skipped by the `BoundedCache` eviction loop (lazy deletion).
