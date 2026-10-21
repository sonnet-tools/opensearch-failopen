        entries.sort_by(|(_, count_a, time_a), (_, count_b, time_b)| {
        // Create frequency patterns
        policy.on_access("key1", 100);
    /// Returns string keys ordered by eviction priority (lowest-priority first).
            if let Some(entry) = self.entries.get(&key) {
    fn policy_name(&self) -> &'static str {
        assert_eq!(candidates.len(), 2);
}
        let mut candidates = Vec::new();
    /// Select entries for eviction to free at least `target_size` bytes.
///   `ScopedEvictionPolicy` + `FifoPolicy`.
/// One enum for all caches means `df_create_cache` parses the Java-supplied
use std::sync::Arc;
/// - `Lru` / `Lfu` — used by `CustomStatisticsCache` and the metadata cache
/// (`DashMap`, atomics) so the trait object can be shared as `Arc<dyn CachePolicy>`
/// Returns `None` for `Fifo` — FIFO uses `ScopedEvictionPolicy` via
        assert!(candidates.contains(&"sometimes_used".to_string()));
        });
            .map(|entry| {
        CacheEvictionPolicy::Fifo => None,
    }
        assert_eq!(metadata.size, 1024);
            policy.on_access("frequently_used", 100);
            .iter()
        Self {
                candidates.push(key);
        assert_eq!(lru_policy.policy_name(), "lru");
    }
    entries: dashmap::DashMap<String, CacheEntryMetadata>,
}
    #[test]
        self.access_count += 1;
impl CachePolicy for LruPolicy {
    fn policy_name(&self) -> &'static str {
        }
    fn select_for_eviction(&self, target_size: usize) -> Vec<String>;
            .entries
        // Collect entries with access counts
    fn test_lru_policy_basic_operations() {
}
        // Collect entries with access times
#[cfg(test)]
#[derive(Debug, Error)]
        }
/// Result type for cache operations
        for _ in 0..3 {
            }
    fn test_lru_policy_victim_selection() {
}
    fn on_insert(&self, key: &str, size: usize);
            self.total_size.fetch_sub(entry.size, Ordering::Relaxed);
    pub fn new() -> Self {
        assert!(!candidates.contains(&"middle".to_string()));
    fn test_create_policy() {
    /// Called when a cache entry is accessed (updates recency/frequency metadata).
        policy.on_remove("key1");
    #[test]
        thread::sleep(Duration::from_millis(1));
/// without an outer `Mutex`. This means `get` on the parent cache never contends
        assert!(metadata.last_accessed > initial_access_time);
        let initial_access_time = metadata.last_accessed;
#[derive(Debug, Clone)]
    pub fn new() -> Self {
        }
        self.total_size.fetch_add(size, Ordering::Relaxed);
    fn test_lfu_policy_victim_selection() {
            return Vec::new();
    }
                // Entry missing from policy metadata (can happen transiently) — insert it.
                candidates.push(key);
    total_size: std::sync::atomic::AtomicUsize,
        for (key, _) in entries {
            }
    /// Name of this policy, for logging/stats.
    fn on_remove(&self, key: &str) {
                let last_accessed = entry.value().last_accessed;
        // Access middle entry to make it more recent
 * this file be licensed under the Apache-2.0 license or a
            Some(mut entry) => {
    pub access_count: usize,
}
/*
    }
        policy.on_insert("newest", 100);
/// Error types for cache operations
            }
    Lru,
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub struct LruPolicy {
            }
            }
        if let Some((_, entry)) = self.entries.remove(key) {
/// flag the missing arm here.
                let key = entry.key().clone();
}
                let metadata = CacheEntryMetadata::new(key.to_string(), size);
        }
        let lru_policy = create_policy(PolicyType::Lru).unwrap();
    }
    }
        let mut freed_size = 0;
}
 * SPDX-License-Identifier: Apache-2.0
        let mut policy = LfuPolicy::new();
    fn clear(&self) {
use instant::Instant;
    /// Called when a cache entry is inserted.
    fn default() -> Self {
        let mut metadata = CacheEntryMetadata::new("test_key".to_string(), 1024);
use std::sync::atomic::Ordering;
        policy.on_access("middle", 100);
                let last_accessed = entry.value().last_accessed;
            .entries
        let metadata = CacheEntryMetadata::new(key.to_string(), size);
use datafusion::common::instant;
 * The OpenSearch Contributors require contributions made to
            return Vec::new();
    }
        }
                freed_size += entry.size;
mod tests {
        thread::sleep(Duration::from_millis(1));
            access_count: 1,
                break;
        }
 */
impl Default for LfuPolicy {
            })
/// Stored inside the policy's `DashMap`, mutated via `get_mut`.
/// eviction string once and routes uniformly without separate enums per family.
}
        self.total_size.store(0, Ordering::Relaxed);
                self.entries.insert(key.to_string(), metadata);
    }
    pub last_accessed: Instant,
    fn test_cache_entry_metadata() {
        policy.on_insert("key1", 100);
                entry.on_access();
        match self.entries.get_mut(key) {
        metadata.on_access();
    pub fn new(_key: String, size: usize) -> Self {
        }
        policy.on_insert("sometimes_used", 100);
        self.entries.clear();
    fn select_for_eviction(&self, target_size: usize) -> Vec<String> {
        }
        assert!(candidates.contains(&"rarely_used".to_string()));
    pub size: usize,
        let mut policy = LruPolicy::new();
                let key = entry.key().clone();
    fn clear(&self) {
                break;
            size,
        if target_size == 0 {
        let mut entries: Vec<_> = self
    #[test]
        if let Some(old_entry) = self.entries.insert(key.to_string(), metadata) {
/// LFU (Least Frequently Used) policy
/// When a new variant is added to `CacheEvictionPolicy`, the compiler will
pub enum CacheEvictionPolicy {
}
        // Select entries for eviction until target size is reached
}
    }
        self.entries.clear();
///
    use std::thread;
        assert!(candidates.contains(&"oldest".to_string()));
/// on a global lock, only on the per-shard DashMap locks inside the policy.
        let mut candidates = Vec::new();
            .collect();
    #[test]
impl CacheEntryMetadata {
    }
        candidates
    /// Update recency and frequency. Called via `DashMap::get_mut` which holds
    /// Called when a cache entry is removed.
    }
    }
            entries: dashmap::DashMap::new(),
                self.total_size.fetch_add(size, Ordering::Relaxed);
        assert!(!candidates.contains(&"frequently_used".to_string()));
        Self {
            if let Some(entry) = self.entries.get(&key) {
        self.total_size.store(0, Ordering::Relaxed);
    fn on_insert(&self, key: &str, size: usize) {
    pub fn on_access(&mut self) {
            if freed_size >= target_size {
 *
/// Create a [`CachePolicy`] (LRU or LFU) from `CacheEvictionPolicy`.
            .map(|entry| {
        let mut entries: Vec<_> = self
        // Select entries for eviction until target size is reached
            if freed_size >= target_size {
    entries: dashmap::DashMap<String, CacheEntryMetadata>,
        if target_size == 0 {
 * compatible open source license.
        }
    }
            total_size: std::sync::atomic::AtomicUsize::new(0),
    }
                self.entries.insert(key.to_string(), metadata);
        }
            }
    #[error("Policy lock error: {reason}")]
        assert_eq!(candidates.len(), 2);
    use super::*;
pub struct CacheEntryMetadata {
    /// Reset all policy state (called on cache clear).
            self.total_size.fetch_sub(entry.size, Ordering::Relaxed);
                entry.on_access();
///
///
        // Sort by access time (oldest first)
        policy.on_insert("key2", 200);
        if let Some(old_entry) = self.entries.insert(key.to_string(), metadata) {
    }
    PolicyLockError { reason: String },
            self.total_size.fetch_sub(old_entry.size, Ordering::Relaxed);
            }
pub type PolicyType = CacheEvictionPolicy;
//! Simple pluggable cache eviction policies for statistics cache.
        "lru"
pub enum CacheError {
        }
    fn on_access(&self, key: &str, size: usize) {
                (key, last_accessed)
                let access_count = entry.value().access_count;
/// `None` should route to `BoundedCache` instead.
    fn on_remove(&self, key: &str) {
        candidates
            None => {
        policy.on_insert("rarely_used", 100);
        match self.entries.get_mut(key) {
        assert_eq!(policy.policy_name(), "lru");
impl Default for LruPolicy {
    }
        self.last_accessed = Instant::now();
            self.total_size.fetch_sub(old_entry.size, Ordering::Relaxed);
        thread::sleep(Duration::from_millis(1));
        }
            })
}
        CacheEvictionPolicy::Lfu => Some(Arc::new(LfuPolicy::new())),
        "lfu"
    Lfu,
        // Sort by access count (least frequent first), then by time for tie-breaking
        assert_eq!(metadata.access_count, 1);
        policy.on_insert("frequently_used", 100);
    fn select_for_eviction(&self, target_size: usize) -> Vec<String> {
                freed_size += entry.size;
            }
/// All methods take `&self` — implementations use interior mutability
    /// only the per-shard write lock — not a global lock.
    }
///
/// Backward-compatible alias — will be removed once all call sites are migrated.
    }
use thiserror::Error;
    fn default() -> Self {
            .collect();
            last_accessed: Instant::now(),
    fn policy_name(&self) -> &'static str;
        }
    }
        Self::new()
/// `BoundedCache::with_named_policy`, not this trait. Callers that receive
        policy.on_access("sometimes_used", 100);
impl LfuPolicy {
    fn on_access(&self, key: &str, size: usize);
impl CachePolicy for LfuPolicy {
pub trait CachePolicy: Send + Sync {
    }
        if let Some((_, entry)) = self.entries.remove(key) {
/// - `Fifo` — used by `BoundedCache` (CI/OI scoped caches) via
                let metadata = CacheEntryMetadata::new(key.to_string(), size);
        let metadata = CacheEntryMetadata::new(key.to_string(), size);
    fn clear(&self);
//!
    fn on_insert(&self, key: &str, size: usize) {
        for (key, _, _) in entries {
        let mut policy = LruPolicy::new();
        Self::new()
                (key, access_count, last_accessed)
    match policy_type {
        policy.on_insert("oldest", 100);
///
    }
        self.total_size.fetch_add(size, Ordering::Relaxed);
            total_size: std::sync::atomic::AtomicUsize::new(0),
    Fifo,
///   (backed by [`CachePolicy`] + [`create_policy`]).
        let mut freed_size = 0;
}
/// Metadata tracked per cached entry for eviction ordering.
    }
            Some(mut entry) => {
        Self {
        policy.clear();
pub type CacheResult<T> = Result<T, CacheError>;
    total_size: std::sync::atomic::AtomicUsize,
    use std::time::Duration;
        assert_eq!(metadata.access_count, 2);
/// Unified eviction policy selector for all caches in this crate.
        assert_eq!(lfu_policy.policy_name(), "lfu");
    }
pub fn create_policy(policy_type: CacheEvictionPolicy) -> Option<Arc<dyn CachePolicy>> {
                self.total_size.fetch_add(size, Ordering::Relaxed);
}
        let candidates = policy.select_for_eviction(150);
        thread::sleep(Duration::from_millis(1));
        CacheEvictionPolicy::Lru => Some(Arc::new(LruPolicy::new())),
}
pub struct LfuPolicy {
            .iter()
        entries.sort_by_key(|(_, last_accessed)| *last_accessed);
            None => {
        let lfu_policy = create_policy(PolicyType::Lfu).unwrap();
}
/// LRU (Least Recently Used) policy
    }
//! # Cache Policy Module
        }
/// Core trait for cache eviction policies.
        let candidates = policy.select_for_eviction(150);
    #[test]
        policy.on_insert("middle", 100);
    fn on_remove(&self, key: &str);
    fn on_access(&self, key: &str, size: usize) {
            entries: dashmap::DashMap::new(),
            count_a.cmp(count_b).then(time_a.cmp(time_b))
impl LruPolicy {
