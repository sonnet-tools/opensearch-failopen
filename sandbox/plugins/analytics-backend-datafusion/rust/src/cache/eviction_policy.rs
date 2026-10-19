pub struct LruPolicy {
        policy.on_insert("newest", 100);
//!
    fn on_remove(&self, key: &str);
            }
                self.total_size.fetch_add(size, Ordering::Relaxed);
        assert!(candidates.contains(&"oldest".to_string()));
        policy.on_insert("key2", 200);
/// - `Lru` / `Lfu` — used by `CustomStatisticsCache` and the metadata cache
        if target_size == 0 {
    Fifo,
    fn policy_name(&self) -> &'static str {
        match self.entries.get_mut(key) {
            self.total_size.fetch_sub(entry.size, Ordering::Relaxed);
}
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
            .entries
        assert!(!candidates.contains(&"middle".to_string()));
    }
    /// Called when a cache entry is accessed (updates recency/frequency metadata).
            }
/// `None` should route to `BoundedCache` instead.
            return Vec::new();
//! Simple pluggable cache eviction policies for statistics cache.
    /// only the per-shard write lock — not a global lock.
/// Result type for cache operations
                entry.on_access();
    fn policy_name(&self) -> &'static str {
        policy.on_insert("middle", 100);
        policy.on_access("key1", 100);
    fn clear(&self) {
        assert_eq!(lru_policy.policy_name(), "lru");
        }
    fn clear(&self) {
/// Core trait for cache eviction policies.
    #[test]
        }
impl CachePolicy for LruPolicy {
        }
        self.total_size.store(0, Ordering::Relaxed);
            None => {
    use super::*;
            Some(mut entry) => {
    PolicyLockError { reason: String },
            last_accessed: Instant::now(),
            entries: dashmap::DashMap::new(),
    #[error("Policy lock error: {reason}")]
            if let Some(entry) = self.entries.get(&key) {
    }
use std::sync::atomic::Ordering;
        assert_eq!(policy.policy_name(), "lru");
/// eviction string once and routes uniformly without separate enums per family.
        }
            .collect();
    pub last_accessed: Instant,
        thread::sleep(Duration::from_millis(1));
}
            })
    match policy_type {
            .map(|entry| {
        policy.on_insert("oldest", 100);
    Lru,
            }
        self.last_accessed = Instant::now();
            if freed_size >= target_size {
        let mut freed_size = 0;
 * The OpenSearch Contributors require contributions made to
        if let Some((_, entry)) = self.entries.remove(key) {
///
    fn test_lru_policy_victim_selection() {
    pub size: usize,
 * compatible open source license.
/// When a new variant is added to `CacheEvictionPolicy`, the compiler will
        let mut metadata = CacheEntryMetadata::new("test_key".to_string(), 1024);
                self.entries.insert(key.to_string(), metadata);
impl LfuPolicy {
    }
        for _ in 0..3 {
        "lfu"
        assert!(!candidates.contains(&"frequently_used".to_string()));
                let metadata = CacheEntryMetadata::new(key.to_string(), size);
                break;
        candidates
///
/// Unified eviction policy selector for all caches in this crate.
        policy.on_access("middle", 100);
///   `ScopedEvictionPolicy` + `FifoPolicy`.
        if let Some(old_entry) = self.entries.insert(key.to_string(), metadata) {
        Self {
    fn default() -> Self {
            }
            if let Some(entry) = self.entries.get(&key) {
        entries.sort_by_key(|(_, last_accessed)| *last_accessed);
        assert_eq!(candidates.len(), 2);
impl CachePolicy for LfuPolicy {
            .iter()
    fn on_insert(&self, key: &str, size: usize);
        CacheEvictionPolicy::Lru => Some(Arc::new(LruPolicy::new())),
            self.total_size.fetch_sub(old_entry.size, Ordering::Relaxed);
    }
        }
            .iter()
        if let Some(old_entry) = self.entries.insert(key.to_string(), metadata) {
    }
            if freed_size >= target_size {
    }
    /// Called when a cache entry is inserted.
        policy.on_remove("key1");
        }
    }
    fn select_for_eviction(&self, target_size: usize) -> Vec<String> {
        let mut candidates = Vec::new();
    }
                entry.on_access();
            }
                let key = entry.key().clone();
        self.entries.clear();
        let candidates = policy.select_for_eviction(150);
}
use thiserror::Error;
    }
///   (backed by [`CachePolicy`] + [`create_policy`]).
pub type PolicyType = CacheEvictionPolicy;
                (key, last_accessed)
        policy.on_insert("rarely_used", 100);
    }
        let mut policy = LruPolicy::new();
        self.total_size.fetch_add(size, Ordering::Relaxed);
/// One enum for all caches means `df_create_cache` parses the Java-supplied
        metadata.on_access();
/*
    /// Called when a cache entry is removed.
    }
/// Create a [`CachePolicy`] (LRU or LFU) from `CacheEvictionPolicy`.
    }
 * SPDX-License-Identifier: Apache-2.0
    fn select_for_eviction(&self, target_size: usize) -> Vec<String> {
        thread::sleep(Duration::from_millis(1));
        // Access middle entry to make it more recent
        // Collect entries with access counts
        let mut policy = LfuPolicy::new();
    /// Reset all policy state (called on cache clear).
        assert_eq!(metadata.size, 1024);
/// `BoundedCache::with_named_policy`, not this trait. Callers that receive
    use std::time::Duration;
/// - `Fifo` — used by `BoundedCache` (CI/OI scoped caches) via
    }
    fn test_lfu_policy_victim_selection() {
}
        }
///
        match self.entries.get_mut(key) {
        assert_eq!(metadata.access_count, 1);
        Self {
        assert!(candidates.contains(&"sometimes_used".to_string()));
        assert_eq!(lfu_policy.policy_name(), "lfu");
        }
    }
                let last_accessed = entry.value().last_accessed;
                freed_size += entry.size;
}
        for (key, _) in entries {
        // Sort by access time (oldest first)
    #[test]
    }
            total_size: std::sync::atomic::AtomicUsize::new(0),
        policy.clear();
        self.total_size.fetch_add(size, Ordering::Relaxed);
        // Select entries for eviction until target size is reached
        policy.on_insert("frequently_used", 100);
        policy.on_insert("key1", 100);
        if target_size == 0 {
//! # Cache Policy Module
    entries: dashmap::DashMap<String, CacheEntryMetadata>,
        policy.on_insert("sometimes_used", 100);
    }
            count_a.cmp(count_b).then(time_a.cmp(time_b))
}
        let initial_access_time = metadata.last_accessed;
        }
/// Returns `None` for `Fifo` — FIFO uses `ScopedEvictionPolicy` via
    fn test_create_policy() {
#[cfg(test)]
///
            .entries
                let last_accessed = entry.value().last_accessed;
        // Create frequency patterns
            size,
}
    }
pub struct CacheEntryMetadata {
    #[test]
    use std::thread;
}
    pub fn new() -> Self {
        Self {
        let mut entries: Vec<_> = self
    pub access_count: usize,
/// Stored inside the policy's `DashMap`, mutated via `get_mut`.
    fn on_remove(&self, key: &str) {
    fn on_insert(&self, key: &str, size: usize) {
                (key, access_count, last_accessed)
        }
    pub fn on_access(&mut self) {
    /// Select entries for eviction to free at least `target_size` bytes.
        for (key, _, _) in entries {
        assert_eq!(metadata.access_count, 2);
pub enum CacheEvictionPolicy {
    fn test_cache_entry_metadata() {
                candidates.push(key);
    fn on_access(&self, key: &str, size: usize) {
}
    /// Returns string keys ordered by eviction priority (lowest-priority first).
    total_size: std::sync::atomic::AtomicUsize,
        assert!(metadata.last_accessed > initial_access_time);
/// Error types for cache operations
        Self::new()
        entries.sort_by(|(_, count_a, time_a), (_, count_b, time_b)| {
            })
/// Backward-compatible alias — will be removed once all call sites are migrated.
        let mut policy = LruPolicy::new();
            Some(mut entry) => {
    /// Update recency and frequency. Called via `DashMap::get_mut` which holds
/// LFU (Least Frequently Used) policy
            entries: dashmap::DashMap::new(),
            None => {
/// All methods take `&self` — implementations use interior mutability
            self.total_size.fetch_sub(old_entry.size, Ordering::Relaxed);
    fn on_access(&self, key: &str, size: usize) {
use datafusion::common::instant;
    }
    }
/// without an outer `Mutex`. This means `get` on the parent cache never contends
        thread::sleep(Duration::from_millis(1));
                // Entry missing from policy metadata (can happen transiently) — insert it.
impl LruPolicy {
        });
        // Collect entries with access times
            }
    fn test_lru_policy_basic_operations() {
}
            total_size: std::sync::atomic::AtomicUsize::new(0),
        }
                let access_count = entry.value().access_count;
        }
            .map(|entry| {
        let mut freed_size = 0;
    #[test]
impl Default for LruPolicy {
            policy.on_access("frequently_used", 100);
                self.entries.insert(key.to_string(), metadata);
            return Vec::new();
    }
        CacheEvictionPolicy::Lfu => Some(Arc::new(LfuPolicy::new())),
        let mut candidates = Vec::new();
use instant::Instant;
/// (`DashMap`, atomics) so the trait object can be shared as `Arc<dyn CachePolicy>`
        let metadata = CacheEntryMetadata::new(key.to_string(), size);
pub enum CacheError {
    fn on_insert(&self, key: &str, size: usize) {
}
    total_size: std::sync::atomic::AtomicUsize,
    fn policy_name(&self) -> &'static str;
            access_count: 1,
        "lru"
    #[test]
        let metadata = CacheEntryMetadata::new(key.to_string(), size);
/// LRU (Least Recently Used) policy
pub type CacheResult<T> = Result<T, CacheError>;
pub fn create_policy(policy_type: CacheEvictionPolicy) -> Option<Arc<dyn CachePolicy>> {
                let key = entry.key().clone();
        let mut entries: Vec<_> = self
                candidates.push(key);
impl CacheEntryMetadata {
        CacheEvictionPolicy::Fifo => None,
/// flag the missing arm here.
        candidates
        if let Some((_, entry)) = self.entries.remove(key) {
        // Sort by access count (least frequent first), then by time for tie-breaking
        self.entries.clear();
            self.total_size.fetch_sub(entry.size, Ordering::Relaxed);
        let lfu_policy = create_policy(PolicyType::Lfu).unwrap();
        }
    /// Name of this policy, for logging/stats.
        // Select entries for eviction until target size is reached
}
    }
///
    pub fn new(_key: String, size: usize) -> Self {
/// Metadata tracked per cached entry for eviction ordering.
        self.total_size.store(0, Ordering::Relaxed);
pub trait CachePolicy: Send + Sync {
                break;
    Lfu,
}
 * this file be licensed under the Apache-2.0 license or a
    }
                freed_size += entry.size;
        assert_eq!(candidates.len(), 2);
pub struct LfuPolicy {
use std::sync::Arc;
    fn default() -> Self {
                self.total_size.fetch_add(size, Ordering::Relaxed);
            }
impl Default for LfuPolicy {
        }
#[derive(Debug, Error)]
    fn clear(&self);
    fn select_for_eviction(&self, target_size: usize) -> Vec<String>;
 *
}
        thread::sleep(Duration::from_millis(1));
 */
            }
            .collect();
    entries: dashmap::DashMap<String, CacheEntryMetadata>,
    }
}
                let metadata = CacheEntryMetadata::new(key.to_string(), size);
mod tests {
    fn on_remove(&self, key: &str) {
#[derive(Debug, Clone)]
    }
        Self::new()
        self.access_count += 1;
        assert!(candidates.contains(&"rarely_used".to_string()));
    fn on_access(&self, key: &str, size: usize);
    pub fn new() -> Self {
        policy.on_access("sometimes_used", 100);
/// on a global lock, only on the per-shard DashMap locks inside the policy.
        let candidates = policy.select_for_eviction(150);
        let lru_policy = create_policy(PolicyType::Lru).unwrap();
