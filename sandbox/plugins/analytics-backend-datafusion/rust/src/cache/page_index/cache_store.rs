//! ```
            h.join().unwrap();
            .map(|(_, s)| s)
                }
/// # Implementing a new policy
        // SAFETY: caller holds the `BoundedCache` write lock.
        }
    /// Verify that `with_policy` compiles and works with a custom policy,
            w.used_bytes += size;
//! **Lazy deletion on overwrite**: re-inserting an existing key leaves a stale
        const ENTRY_SIZE: usize = 10;
                    c.insert_batch(batch);
use crate::eviction_policy::CacheEvictionPolicy;
    /// Reset all internal state (called on `clear_keep_limit`).
        Self {
    evictions: AtomicU64,
            }
        assert_eq!(c.get(&Key::new("a")), Some(vec![1, 2, 3]));
/// Implementations must use interior mutability (`Mutex`, atomics, etc.) so
    pub(crate) fn with_named_policy(limit: usize, policy: CacheEvictionPolicy) -> Self {
            h.join().unwrap();
    }
                }
    misses: AtomicU64,
        }
 * The OpenSearch Contributors require contributions made to
    /// Called repeatedly by [`BoundedCache::drain_to_limit`] until
        }
    fn entry_too_large_is_dropped() {
    }
/// `set_column_index_cache_limit` / `set_offset_index_cache_limit` during
        cache.insert(Key::new("x"), vec![], 10);
///
    #[test]
        let cache = Arc::new(make_cache(4096));
    K: Eq + Hash + Clone + Display + Send + Sync + 'static,
    use std::sync::Arc;
pub(crate) const DEFAULT_SCOPED_CACHE_LIMIT: usize = 150 * 1024 * 1024;
    }
            }
    /// Used when a parquet file is deleted or replaced.
//! **`evict_by_prefix`** is the only O(n) operation: it scans the eviction
        }
}
        }
            .filter(|e| e.key().to_string().starts_with(prefix))
        let mut w = self.write.lock();
            w.used_bytes = w.used_bytes.saturating_sub(old_size);
        let limit = self.limit_snapshot.load(Relaxed);
    pub(super) fn get(&self, key: &K) -> Option<V> {
mod tests {
/// Snapshot of one scoped cache's counters plus occupancy.
//!
        match self.map.get(key) {
    /// If `size > limit` the entry is silently dropped. Takes the write lock
        let c = make_cache(10);
        for t in 0..4usize {
    /// returned key is no longer in the `DashMap` (stale entry from an
            entries: self.map.len(),
    // Lock-free diagnostic counters.
    pub used_bytes: usize,
        }
        for t in 0..THREADS {
            // place for lazy deletion by drain_to_limit.
        self.hits.store(0, Relaxed);
    fn on_insert(&self, key: K) {
    fn concurrent_reads_and_writes_no_panic() {
    fn on_access(&self, key: &K);
            write: Mutex::new(WriteState::new(limit)),
    }
    /// Pop and return the next eviction candidate.
}
        }
    impl std::fmt::Display for Key {
        const THREADS: usize = 8;
    #[test]
            }
    /// Byte cap snapshot for lock-free `stats()`.
/// Surfaced on node-stats and used by tests.
        if old_size > 0 {
                for i in 0..500 {
    }
            .map
//! ```text
        let mut w = self.write.lock();
        }
    pub evictions: u64,
    fn on_insert(&self, key: K);
        self.policy.clear();
        }
    }
//!
//! victims with a single `DashMap::remove` miss — O(1) overwrite, no O(n)
                .unwrap_or(0);
    K: Eq + Hash + Clone + Display + Send + Sync + 'static,
//!
        w.limit = limit;
        for h in handles {
    }
    /// variant (e.g. `S3Fifo`) will be a compile error here until it's wired.
    /// proving the extensibility point works without modifying `BoundedCache`.
///
}
            }));
        for entry in cache.map.iter() {
    fn clear_resets_all_state() {
    fn insert_and_get_roundtrip() {
    pub misses: u64,
    write: Mutex<WriteState>,
        assert_eq!(s.hits, 0);
pub(super) struct BoundedCache<K, V, P = FifoPolicy<K>>
    /// FIFO ignores this; frequency-aware policies (LFU, S3-FIFO) update
 * SPDX-License-Identifier: Apache-2.0
//! entry in the eviction queue. [`BoundedCache::drain_to_limit`] skips stale
use dashmap::DashMap;
        fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
//! can be added later by implementing the same trait.
impl WriteState {
    /// Must be called inside the write lock.
        assert!(s.used_bytes <= 200);
        if victims.is_empty() {
    ///
        let map_total: usize = cache.map.iter().map(|e| e.value().1).sum();
/// the `BoundedCache` write lock is held. `on_access` is a no-op for FIFO and
                    c.insert(Key::new(format!("t{t}:k{i}")), vec![t as u8], ENTRY_SIZE);
//!  └── P (eviction policy)           ← owns the eviction queue, uses interior mutability
    }
        let s = cache.stats();
    fn clear(&self) {
        let mut w = self.write.lock();
    }
        c.insert(Key::new("a"), vec![], 10);
/// statics.
            evictions: self.evictions.load(Relaxed),
    policy: P,
            None => {
    ///
    /// access counts here.
        unsafe { &mut *self.queue.get() }
            // adjusted at overwrite time — skip without double-decrementing.
        let s = c.stats();
/// `on_access` needs to update state from the read path, it would need its own
/// all mutations. An additional inner lock on the queue would be a
    }
        // DashMap updates are outside the write lock — independently concurrent.
    }
    /// instead of N separate calls.
    limit_snapshot: AtomicUsize,
        drop(w);
        assert_eq!(s.used_bytes, 0);
//! cold-path operation (file deletion or merge), not on the query hot path.
            .unwrap_or(0);
        // O(n) scan — only called from evict_by_prefix (cold path).
            self.evictions.fetch_add(evicted, Relaxed);
    #[test]
        let s = cache.stats();
        let s = c.stats();
struct WriteState {
    fn new(limit: usize) -> Self {
        assert_eq!(c.get(&Key::new("file1:col0")), None);
    /// The policy should record `key` as the most-recently inserted entry.
        if evicted > 0 {
            }
        }));
        }
            if let Some((_, (_, size))) = self.map.remove(&victim) {
// ── BoundedCache ─────────────────────────────────────────────────────────────
    #[test]
    #[test]
        assert_eq!(c.get(&Key::new("a")), Some(vec![2]));
//!
    /// Called when a new entry is inserted (or an existing key is overwritten).
    pub(super) fn evict_by_prefix(&self, prefix: &str) {
/// Byte-bounded concurrent cache parameterised over an eviction policy `P`.
    fn on_remove(&self, key: &K);
/// All `ScopedEvictionPolicy` methods are called exclusively from inside
                    c.insert(Key::new(format!("k{}", i % 20)), vec![t as u8], 10);
    fn used_bytes_tracks_inserts_and_evictions() {
            if size > limit {
use std::cell::UnsafeCell;
/// Mutable accounting serialised under the `BoundedCache` write lock.
        for t in 0..3usize {
        let map_total: usize = cache.map.iter().map(|e| e.value().1).sum();
// ── Tests ────────────────────────────────────────────────────────────────────
        self.queue_mut().clear();
        }
        while w.used_bytes > w.limit {
        self.used_bytes_snapshot.store(0, Relaxed);
    #[test]
    limit: usize,
        }
    fn insert_batch_one_lock_same_result_as_individual() {
        let c2 = Arc::clone(&cache);
    /// Stale victims (overwritten entries) are skipped via lazy deletion.
        let evicted = self.drain_to_limit(&mut w);
        Self {
    }
            }
        // Collect victims by iterating the DashMap (avoids holding the write
            used_bytes: self.used_bytes_snapshot.load(Relaxed),
                for i in 0..300 {
        let CacheEvictionPolicy::Fifo = policy else {
    fn on_remove(&self, key: &K) {
    }
        assert_eq!(map_total, s.used_bytes);
                        .map(|i| (Key::new(format!("t{t}:b{b}:i{i}")), vec![t as u8], 8));
        assert_eq!(map_total, cache.stats().used_bytes);
            hits: AtomicU64::new(0),
        assert_eq!(map_total, s.used_bytes);
        }
        c.insert(Key::new("a"), vec![], 4);
            map: DashMap::new(),
        for (key, size, old_size) in to_account {
            if let Some((_, (_, size))) = self.map.remove(victim) {
            if old_size > 0 {
    }
unsafe impl<K: Send> Sync for FifoPolicy<K> {}
    /// Borrow the queue mutably. Caller must hold the outer write lock.
        self.limit_snapshot.store(limit, Relaxed);
    /// Preferred when a query produces several cells at once (e.g. all CI
        assert_eq!(c.get(&Key::new("file1:col1")), None);
/// inside the `BoundedCache` write lock, so implementations do not need their
        let victims: Vec<K> = self
        BoundedCache::new(limit)
        );
//! **Writes take one `parking_lot::Mutex`** for `used_bytes` + limit accounting.
                for i in 0..PER_THREAD {
    }
}
            "used_bytes={} must be <= limit=10",
        for t in 0..3usize {
            assert!(!entry.key().0.starts_with("hot/"));
    pub hits: u64,
}
            "used_bytes={} > limit={}",
/// 3. Expose a `PolicyType` variant in the Java API and route it from
///    `df_create_cache` in `ffm.rs`.
 *
            used_bytes_snapshot: AtomicUsize::new(0),
/// # Safety invariant
        let evicted = self.drain_to_limit(&mut w);
    /// cells for a vectored multi-column fetch). One lock + one eviction pass
    /// Value store — DashMap for lock-free concurrent reads.
    /// Create a `BoundedCache` with the named eviction policy.
// ── FIFO policy ──────────────────────────────────────────────────────────────
            evictions: AtomicU64::new(0),
                .map
    pub limit_bytes: usize,
            self.evictions.fetch_add(evicted, Relaxed);
        assert!(s.used_bytes <= LIMIT);
                w.used_bytes = w.used_bytes.saturating_sub(size);
    pub(super) fn stats(&self) -> ScopedCacheStats {
    /// overwrite), `drain_to_limit` skips it and calls `next_victim` again.
        if evicted > 0 {
    map: DashMap<K, (V, usize)>,
                evicted += 1;
unsafe impl<K: Send> Send for FifoPolicy<K> {}
//! **Pluggable eviction**: [`ScopedEvictionPolicy`] is the trait. Today
        c.insert(Key::new("a"), vec![1], 10);
        assert_eq!(s.misses, 0);
        handles.push(std::thread::spawn(move || {
        let cache = Arc::new(make_cache(LIMIT));
    fn next_victim(&self) -> Option<K> {
            s.used_bytes
/// Pluggable eviction policy for [`BoundedCache`].
///
        let mut evicted = 0u64;
            return;
        assert_eq!(c.get(&Key::new("huge")), None);
        c.insert(Key::new("b"), vec![], 4);
        for t in 0..4usize {
//! [`FifoPolicy`] is the only implementation. S3-FIFO (ghost-set promotion)
/// own locks — but must still be `Send + Sync` for the `Lazy<BoundedCache>`
impl<K, V, P> BoundedCache<K, V, P>
        c.insert(Key::new("file2:col0"), vec![], 10);
        assert_eq!(c1.get(&Key::new("b")), c2.get(&Key::new("b")));
    #[test]
        c.insert(Key::new("c"), vec![], 4);
    /// Drop all entries and reset counters, keeping the current limit.
        c.clear_keep_limit();
    /// Create a new cache with FIFO eviction — shorthand for tests.
        }
 */
 * compatible open source license.
            }));
                w.used_bytes = w.used_bytes.saturating_sub(old_size);
                }
            let c = Arc::clone(&cache);
///
//! Byte-bounded concurrent cache with a pluggable eviction policy.
        c.insert(Key::new("file1:col0"), vec![], 10);
/// is called from the lock-free `get` path — it does not touch the queue.
        assert_eq!(c.limit_snapshot.load(Relaxed), 1024);
            misses: self.misses.load(Relaxed),
        const PER_THREAD: usize = 200;
        }
        let map_total: usize = cache.map.iter().map(|e| e.value().1).sum();
    }
    used_bytes_snapshot: AtomicUsize,
        self.map.clear();
    }
        c.insert(Key::new("a"), vec![1, 2, 3], 3);
                self.misses.fetch_add(1, Relaxed);
        if to_account.is_empty() {
        assert_eq!(c.stats().used_bytes, 10);
        let c = make_cache(1024);
    fn concurrent_insert_batch_consistent() {
    /// Evict all entries whose `Display` representation starts with `prefix`.
//! # Architecture
            misses: AtomicU64::new(0),
            return;
    /// Evict policy victims until `used_bytes <= limit`.
        assert_eq!(c1.get(&Key::new("a")), c2.get(&Key::new("a")));
            let c = Arc::clone(&cache);
    #[test]
        self.misses.store(0, Relaxed);
        let cache: BoundedCache<Key, Vec<u8>, FifoPolicy<Key>> =
        }
    P: ScopedEvictionPolicy<K>,
where
    /// Lock-free read. Contends only on the DashMap per-shard read lock.
        self.queue_mut().pop_front()
/// `K` must implement `Display` so `evict_by_prefix` can match keys by their
                std::hint::spin_loop();
/// interior mutability (e.g. atomics for frequency counters).
    // ── concurrency ───────────────────────────────────────────────────────────
    pub(super) fn new() -> Self {
        let cache = Arc::new(make_cache(1000));
        c.insert(Key::new("file1:col1"), vec![], 10);
        assert_eq!(map_total, s.used_bytes);
        self.used_bytes_snapshot.store(w.used_bytes, Relaxed);
            unreachable!("BoundedCache only supports Fifo; use CustomStatisticsCache for Lru/Lfu");
        // A trivial "always evict the first key ever inserted" policy (same as FIFO).
        let mut handles = vec![];
                break;
///
        for h in handles {
            return;
    /// Insert multiple entries under a single write-lock acquisition.
        let mut w = self.write.lock();
    ///
    hits: AtomicU64,
    pub(super) fn set_limit(&self, limit: usize) {
//!
        }
        );
            }
                for b in 0..50usize {
    pub(super) fn with_policy(limit: usize, policy: P) -> Self {
        assert!(s.evictions >= 1);
    pub entries: usize,
        ScopedCacheStats {
                self.policy.on_access(key);
            s.used_bytes,
}
#[cfg(test)]
            self.evictions.fetch_add(evicted, Relaxed);
        assert!(
/// In production the Java settings consumer always calls
// ── Eviction policy trait ────────────────────────────────────────────────────
/// # No inner lock
        assert_eq!(s.entries, 0);
    }
impl<K> FifoPolicy<K> {
            self.policy.on_remove(victim);
/// The eviction queue lives in the policy; this struct tracks only bytes.
            limit_bytes: self.limit_snapshot.load(Relaxed),
    fn evict_by_prefix_removes_matching_entries() {
/// Every method that calls `queue_mut()` or `queue_ref()` must be called while
            let c = Arc::clone(&cache);
impl<K: Clone + PartialEq + Send + Sync> ScopedEvictionPolicy<K> for FifoPolicy<K> {
    // ── pluggable policy ──────────────────────────────────────────────────────
        }
    #[test]
    #[test]
        let cache = Arc::new(make_cache(200));
                }
/// 1. Implement this trait with interior mutability.
    pub(super) fn insert_batch(&self, entries: impl IntoIterator<Item = (K, V, usize)>) {
        self.used_bytes_snapshot.store(w.used_bytes, Relaxed);
        let limit = cache.limit_snapshot.load(Relaxed);
        c.insert(Key::new("a"), vec![2], 5);
            Some(entry) => {
        assert_eq!(c.get(&Key::new("file2:col0")), Some(vec![]));
    }
        Self::with_policy(limit, FifoPolicy::new())
    fn next_victim(&self) -> Option<K>;
    V: Clone + Send + Sync + 'static,
            let old_size = self
        assert!(cache.stats().used_bytes <= 20);
                    let _ = c.get(&Key::new(format!("k{}", i % 20)));
                w.used_bytes = w.used_bytes.saturating_sub(size);
pub struct ScopedCacheStats {
    #[test]
        }
        assert!(s.used_bytes <= limit);
//! retain scan.
//!  BoundedCache<K, V, P: ScopedEvictionPolicy<K>>
    #[test]
    /// Insert a key-value pair with its byte cost.
            handles.push(std::thread::spawn(move || {
        }
where
            h.join().unwrap();
        c.insert(Key::new("b"), vec![], 20);
    fn queue_mut(&self) -> &mut VecDeque<K> {
        let s = cache.stats();
                    c.insert(Key::new(format!("t{t}:k{i}")), vec![], 10);
pub(super) struct FifoPolicy<K> {
    use super::*;
    impl Key {
        let evicted = self.drain_to_limit(&mut w);
        for h in handles {
        let map_total: usize = cache.map.iter().map(|e| e.value().1).sum();
    ///
    }
        let c = make_cache(1024);
use parking_lot::Mutex;
            (Key::new("c"), vec![3u8], 30),
where
    /// Update the byte cap and immediately evict if over budget.
        }
        assert_eq!(s.evictions, 0);
        c.insert(Key::new("huge"), vec![], 11);
    /// for accounting; IO must be done by the caller before calling this.
        let mut handles = vec![];
            LIMIT
/// plugin initialization before any query runs, so this value is never used
        for h in handles {
        cache.evict_by_prefix("hot/");
    fn clear(&self);
//! queue to remove all cells for a deleted/replaced file. This is a rare
                    c.insert(Key::new(format!("cold/t{t}:k{i}")), vec![], 10);
        self.queue_mut().push_back(key);
            let c = Arc::clone(&cache);
}
impl<K, V> BoundedCache<K, V, FifoPolicy<K>>
    V: Clone + Send + Sync + 'static,
        for (key, value, size) in entries {
            }
    }
        let c = make_cache(1024);
            }));
        ];
                None
            handles.push(std::thread::spawn(move || {
        let mut to_account: Vec<(K, usize, usize)> = Vec::new();
use std::collections::VecDeque;
        let s = cache.stats();
/// S3-FIFO (planned successor) wraps two FIFO queues with a ghost set. If its
        // lock while doing string comparisons on every FIFO entry).
        let map_total: usize = cache.map.iter().map(|e| e.value().1).sum();
        let c2 = make_cache(1024);
        Self::with_named_policy(limit, CacheEvictionPolicy::Fifo)
use std::fmt::Display;
        }
    /// Allows the policy to remove the entry from its internal bookkeeping.
            .map
    K: Eq + Hash + Clone + Display + Send + Sync + 'static,
    fn overwrite_does_not_leak_bytes() {
/// 2. Wire it in `mod.rs` by passing it to `BoundedCache::new`.
            (Key::new("a"), vec![1u8], 10),
    used_bytes: usize,
{
    #[derive(Clone, PartialEq, Eq, Hash)]
        let cache = Arc::new(make_cache(LIMIT));
}
    /// Create a cache with an explicit policy. Use this when plugging in a
#[derive(Debug, Clone, Copy, PartialEq, Eq, Default)]
        assert_eq!(cache.get(&Key::new("x")), None, "x must have been evicted");
        let mut w = self.write.lock();
use std::hash::Hash;
                for i in 0..300 {
        let old_size = self
            limit,
    /// O(n) scan of the eviction queue — cold path only (file deletion/merge).
//! **Reads are lock-free** — `get` only touches the `DashMap` shard lock.
    pub(super) fn insert(&self, key: K, value: V, size: usize) {
//!  ├── Mutex<{ used_bytes, limit }>  ← write-path accounting only
            .iter()
    }
    // ── basic correctness ─────────────────────────────────────────────────────
                }
/// `BoundedCache`'s outer `Mutex<WriteState>` lock, which already serializes
    }
                }
        }
    }
            // Overwrite: update byte accounting. Stale FIFO entry is left in
{
                c2.set_limit(200);
/// they can be called through a shared reference. All methods are called from
                for i in 0..500 {
    fn concurrent_insert_and_evict_by_prefix_consistent() {
/// no-contention lock/unlock cycle with zero benefit. We use `UnsafeCell`
            to_account.push((key, size, old_size));
        assert_eq!(c.get(&Key::new("missing")), None);
///
        for victim in &victims {
}
    #[inline]
        }
            policy,
                continue;
        }
///
    V: Clone + Send + Sync + 'static,
    }
/*
        for (k, v, s) in entries.clone() {
        w.used_bytes = 0;
        let c = make_cache(10);
            BoundedCache::with_policy(20, FifoPolicy::new());
        if evicted > 0 {
                c2.set_limit(1000);
            let c = Arc::clone(&cache);
    }
        }
            c1.insert(k, v, s);
        self.used_bytes_snapshot.store(w.used_bytes, Relaxed);
                evicted += 1;
//! The eviction policy is called inside the lock for consistency.
    fn custom_policy_compiles_and_works() {
    }
    /// non-default policy (e.g. S3-FIFO in a future PR).
            handles.push(std::thread::spawn(move || {
    fn make_cache(limit: usize) -> BoundedCache<Key, Vec<u8>> {
            handles.push(std::thread::spawn(move || {
            self.evictions.fetch_add(evicted, Relaxed);
        let mut handles = vec![];
        let limit = self.limit_snapshot.load(Relaxed);
        w.used_bytes += size;
    }
///
        for t in 0..THREADS {
            let Some(victim) = self.policy.next_victim() else {
//!
        assert_eq!(c1.get(&Key::new("c")), c2.get(&Key::new("c")));
            handles.push(std::thread::spawn(move || {
        use crate::cache::eviction_policy::CacheEvictionPolicy;
            used_bytes: 0,
        assert_eq!(c.stats().used_bytes, 5);
        drop(w);
    pub(super) fn clear_keep_limit(&self) {
pub(super) trait ScopedEvictionPolicy<K>: Send + Sync {
{
    /// Lock-free stats snapshot.
/// Fallback byte budget used only in tests that bypass the Java startup path.
        evicted
        cache.insert(Key::new("y"), vec![], 10);
        if evicted > 0 {
        // FIFO does not track access order — no queue mutation, reads stay lock-free.
        const LIMIT: usize = THREADS * PER_THREAD * ENTRY_SIZE / 4;
                    c.insert(Key::new(format!("hot/t{t}:k{i}")), vec![], 10);
        self.used_bytes_snapshot.store(w.used_bytes, Relaxed);
        self.queue_mut().retain(|k| k != key);
    /// Guarded by the outer `BoundedCache` write lock — no inner lock needed.
    queue: UnsafeCell<VecDeque<K>>,
            f.write_str(&self.0)
/// string representation (e.g. `"path:col:rg"` → prefix `"path"`).
    }
/// Insert-order (FIFO) eviction policy.
            let c = Arc::clone(&cache);
    }
        let c = make_cache(1024);
    }
    fn drain_to_limit(&self, w: &mut WriteState) -> u64 {
                Some(entry.0.clone())
    fn concurrent_set_limit_and_inserts_consistent() {
///
    }
                .insert(key.clone(), (value, size))
        for h in handles {
            h.join().unwrap();
                .map(|(_, s)| s)
use std::sync::atomic::{AtomicU64, AtomicUsize, Ordering::Relaxed};
            }));
// SAFETY: `FifoPolicy` is only mutated under `BoundedCache`'s `Mutex<WriteState>`.
            };
            for _ in 0..20 {
/// and skipped by the `BoundedCache` eviction loop (lazy deletion).
        for _ in 0..4 {
            (Key::new("b"), vec![2u8], 20),
    }
        }
        assert_eq!(c1.stats().used_bytes, c2.stats().used_bytes);
//!
        drop(w);
            Key(s.into())
///
    fn on_access(&self, _key: &K) {
        fn new(s: impl Into<String>) -> Self {
    /// The match is exhaustive over `CacheEvictionPolicy` so adding a new
        }
            handles.push(std::thread::spawn(move || {
    }
        };
        }
        c.evict_by_prefix("file1");
            hits: self.hits.load(Relaxed),
        let mut evicted = 0u64;
                for i in 0..400 {
            s.used_bytes <= 10,
/// outside tests.
        assert_eq!(map_total, s.used_bytes);
// ── Write-lock state ─────────────────────────────────────────────────────────
        assert!(
            .insert(key.clone(), (value, size))
                }
        cache.insert(Key::new("z"), vec![], 10); // triggers eviction of "x"
            handles.push(std::thread::spawn(move || {
            s.used_bytes <= LIMIT,
            .collect();
    #[test]
            // If map.remove returned None: stale entry, used_bytes already
    /// `used_bytes <= limit`. The caller performs lazy deletion: if the
        assert_eq!(c.stats().used_bytes, 8);
        self.policy.on_insert(key);
/// instead, with the outer lock as the synchronization invariant.
            .map(|e| e.key().clone())
        drop(w);
/// are fully lock-free. Stale entries (from overwrites) are left in the queue
    }
        c2.insert_batch(entries.into_iter());
    /// Called when an entry is accessed on the hot read path.
}
            limit_snapshot: AtomicUsize::new(limit),
        Self {
        const THREADS: usize = 8;
            queue: UnsafeCell::new(VecDeque::new()),
        if size > limit {
        }
    P: ScopedEvictionPolicy<K>,
        let c1 = make_cache(1024);
    struct Key(String);
            let c = Arc::clone(&cache);
    /// Called when an entry is explicitly removed (prefix eviction, clear).
    fn concurrent_inserts_stay_within_limit() {
//!  ├── DashMap<K, (V, usize)>        ← lock-free concurrent reads
}
            }));
    /// Eviction policy — uses interior mutability, called inside `write` lock.
        }
            h.join().unwrap();
        self.evictions.store(0, Relaxed);
            }));
    pub(super) fn new(limit: usize) -> Self {
            }));
                self.hits.fetch_add(1, Relaxed);
    ///
        drop(w);
            self.policy.on_insert(key);
/// Oldest-inserted entry is evicted first. Access order is not tracked — reads
        }
        let mut handles = vec![];
    /// Byte accounting under one lock. The eviction queue lives in `policy`.
        let mut handles = vec![];
 * this file be licensed under the Apache-2.0 license or a
        let entries = vec![
                    let batch = (0..5usize)
        const LIMIT: usize = THREADS * 50 * 5 * 8 / 3;
        assert_eq!(c.stats().used_bytes, 0);
        }
    /// Only `Fifo` is accepted — `Lru`/`Lfu` belong to `CustomStatisticsCache`.
