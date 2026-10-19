        std::mem::size_of::<Self>()
    Ok(statistics)
        assert_eq!(cache.policy_name().unwrap(), "lru");
        }
/// This cache leverages DashMap's built-in concurrency from DefaultFileStatisticsCache
                std::mem::size_of::<Self>() + std::mem::size_of_val(arr.as_ref()) + (arr.len() * 16)
        } else {
        for (key, size) in entries {
                std::mem::size_of::<Self>() + std::mem::size_of_val(arr.as_ref()) + (arr.len() * 8)
        assert_eq!(cache.hit_rate(), 0.0);
        let eviction_candidates = {
        let meta = create_test_meta(&path);
            Precision::Exact(val) => std::mem::size_of::<Self>() + val.heap_size(),
    }
        let memory_before = cache.memory_consumed();
        assert_eq!(cache.memory_consumed(), 0);
            + self.max_value.heap_size()
        for handle in handles {
        assert!(cache.len() > 0);
        cache.put_statistics(&path, stats, &meta);
    #[test]
    use chrono::Utc;
}
    /// Manually trigger eviction.
            eviction_threshold,
    }
                    state.total = state.total.saturating_sub(old_size);
        }
    pub fn get(&self, k: &Path) -> Option<CachedFileMetadata> {
            let stats = Arc::new(create_test_statistics());
                if let Some(old_size) = state.tracker.remove(&key) {
    fn test_hit_rate_calculation() {
            column_statistics: vec![],
    fn heap_size(&self) -> usize;
    }
        let mut guard = self
};
            + self.min_value.heap_size()
        self.get(k).map(|c| c.statistics)
    pub fn hit_rate(&self) -> f64 {
        assert_eq!(cache.memory_consumed(), 0);
                    self.remove_internal(&path);
        assert!(freed > 0);
        k: &Path,
    /// Cache miss count (thread-safe)
        let path = create_test_path("file1");
        let cache = CustomStatisticsCache::with_default_config();
// bare `Path`, so the storage and bookkeeping stay Path-keyed and the
        self.size_limit.load(Ordering::Relaxed)
                    state.total = state.total.saturating_sub(old_size);
        if result.is_some() {
            }
        }
        let candidates = self.policy().select_for_eviction(target_size);
        }
        CustomStatisticsCache::name(self)
    fn put(&self, k: &TableScopedPath, v: CachedFileMetadata) -> Option<CachedFileMetadata> {
    #[test]
    /// through the clone without holding the lock.
        location: path,
    fn heap_size(&self) -> usize {
    /// Create with default configuration
    #[test]
        assert_eq!(cache.len(), 1);
        result.map(|x| x.1)
        cache.put_statistics(&path, stats, &meta);
            let meta = create_test_meta(&path);
                        self.policy().on_remove(&key);
        }
                state.tracker.get(&key).copied().unwrap_or(0)
        cache.update_size_limit(30 * 1024 * 1024).unwrap();
                reason: format!("Failed to acquire policy lock: {}", e),
    use datafusion::common::stats::Precision;
    miss_count: AtomicUsize,
            hits as f64 / total as f64
                })?;
            Precision::Inexact(val) => std::mem::size_of::<Self>() + val.heap_size(),
                assert!(cache_clone.get(&path).is_some());
    }
    fn name(&self) -> String {
            inner_cache: DashMap::new(),
    /// so they don't hold the lock while calling policy methods.
            let stats = Arc::new(create_test_statistics());
    }
            state.tracker.clear();
        if total == 0 {
trait StatisticsMemorySize {
        assert_eq!(cache.len(), 1);
    };
                if let Some(old_size) = state.tracker.remove(&key) {
        format!(
    }
// CacheAccessor<TableScopedPath> impl below delegates to these via `&key.path`.
        }
            let threshold = (size_limit as f64 * self.eviction_threshold) as usize;
            version: None,
/// Combined memory tracking and policy-based eviction cache
    }
        &self,
    let builder = ParquetRecordBatchReaderBuilder::try_new(file)?;
        _table_ref: &Option<TableReference>,
    fn test_remove_with_memory_tracking() {
            .lock()
    }
 * The OpenSearch Contributors require contributions made to
}
    }
    /// Get the underlying cache for compatibility
impl<T: HeapSize + std::fmt::Debug + Clone + PartialEq + Eq + PartialOrd> HeapSize
        let hits = self.hit_count();
    fn test_policy_switching_with_memory() {
/// Trait to calculate heap memory size for statistics objects
    }
    }
        assert_eq!(cache.memory_consumed(), 0);
// trait's `&TableScopedPath` methods, so existing callers keep working unchanged.
    /// Current eviction policy. `Mutex` guards atomic swaps in `set_policy`;
        stats: Arc<Statistics>,
use std::fs::File;
        }
                total: 0,
            let memory_size = {
    fn test_update_cache_limit_trait_is_noop() {
        self.miss_count.store(0, Ordering::Relaxed);
    fn remove_internal(&self, k: &Path) -> Option<CachedFileMetadata> {
    /// Reset hit and miss counters
    use datafusion::datasource::physical_plan::parquet::metadata::DFParquetMetadata;
use datafusion::execution::cache::CacheAccessor;
    }
        let stats = Arc::new(create_test_statistics());
pub fn compute_parquet_statistics(
        let meta = create_test_meta(&path);
            }
    /// Get cache hit rate (returns value between 0.0 and 1.0)
            if let Ok(path) = self.parse_key_to_path(&candidate_key) {
            state.total += memory_size;
    // Create ObjectStore and ObjectMeta for the file
            let size_limit = self.size_limit.load(Ordering::Relaxed);
                    }
        let result = self.inner_cache.remove(k);
        CustomStatisticsCache::contains_key(self, &k.path)
    fn len(&self) -> usize {
            + self.null_count.heap_size()
    /// Parse cache key back to Path
        if let Ok(mut state) = self.memory_state.lock() {
            size: 1000,
}
        let cache = CustomStatisticsCache::with_default_config();
    fn policy(&self) -> Arc<dyn CachePolicy> {
        let stats = Arc::new(create_test_statistics());
use std::sync::atomic::{AtomicUsize, Ordering};
                create_policy(policy_type).expect("statistics cache requires Lru or Lfu"),
        )
        for i in 0..10 {
        let cache = CustomStatisticsCache::with_default_config();
    fn test_concurrent_operations() {
    fn contains_key(&self, k: &TableScopedPath) -> bool {
        assert_eq!(cache.miss_count(), 1);
        self.reset_stats();
    fn update_cache_limit(&self, _limit: usize) {}
        cache.get(&path);
        self.inner_cache.get(k).is_some()
        let path2 = create_test_path("missing");
    pub fn reset_stats(&self) {
    }
        let cache = CustomStatisticsCache::with_default_config();
    }
        assert_eq!(cache.hit_count(), 0);
    let file_metadata = std::fs::metadata(file_path)?;
    fn parse_key_to_path(&self, key: &str) -> CacheResult<Path> {
        assert!(cache.memory_consumed() < memory_with_two);
    let file = File::open(file_path)?;
        };
    pub fn len(&self) -> usize {
        cache.remove(&path1);
    pub fn get_statistics(&self, k: &Path) -> Option<Arc<Statistics>> {
        }
    }
use arrow_array::Array;
        self.inner_cache.clear();
impl CacheAccessor<TableScopedPath, CachedFileMetadata> for CustomStatisticsCache {
    pub fn memory_consumed(&self) -> usize {
        use std::thread;
                }
    }
    }
        }
    }
            size_limit: AtomicUsize::new(size_limit),
            .lock()
            };
        let meta = create_test_meta(&path);
        let path = create_test_path("file1");
            cache.put_statistics(&path, stats, &meta);
    use object_store::local::LocalFileSystem;
        Statistics {
            let entry_size = {
                let target_eviction =
                .memory_state
 */
        }
                state
        self.hit_count.store(0, Ordering::Relaxed);
        cache.clear();
    /// Create a new custom statistics cache
    tracker: HashMap<String, usize>,
    pub fn hit_count(&self) -> usize {
        let stats = Arc::new(create_test_statistics());
        let cache = CustomStatisticsCache::new(PolicyType::Lru, 1000, 0.8);
use datafusion::common::stats::{ColumnStatistics, Precision};
}
/*
            .policy
        if current_size > new_limit {
    /// Get current cache size according to policy (uses actual memory consumption)
    }
/// metadata.
            }
}
    pub fn clear(&self) {
    use datafusion::datasource::physical_plan::parquet::metadata::DFParquetMetadata;
    pub fn contains_key(&self, k: &Path) -> bool {
        }
            }
            })?;
    pub fn put(&self, k: &Path, v: CachedFileMetadata) -> Option<CachedFileMetadata> {
        match self {
/// (e.g. by `load_parquet_metadata` during metadata cache warming). The caller
        Ok(())
            e_tag: None,
        let cache = CustomStatisticsCache::with_default_config();
            let handle = thread::spawn(move || {
    }
        Path::from(format!("/test/{}.parquet", name))
}
// Path-keyed core operations. DF54 keys the FileStatisticsCache by
use dashmap::DashMap;
    }
        assert!((cache.hit_rate() - 0.6666666666666666).abs() < 0.0001);
}
impl HeapSize for ScalarValue {
    inner_cache: DashMap<Path, CachedFileMetadata>,
        assert_eq!(cache.len(), 0);
        self.policy
            policy: Mutex::new(
                            state.total = state.total.saturating_sub(entry_size);
impl HeapSize for usize {
        self.memory_state
                self.remove_internal(&path);
            });
            let key = k.to_string();
        assert_eq!(cache.hit_rate(), 1.0);
                if let Ok(path) = self.parse_key_to_path(&candidate_key) {
 * this file be licensed under the Apache-2.0 license or a
    }
            ScalarValue::Struct(arr) => {
    fn heap_size(&self) -> usize {
        assert_eq!(cache.miss_count(), 0);
        use datafusion::execution::cache::cache_manager::FileStatisticsCache;
    /// Convenience method: get just the statistics Arc (for callers that don't need full CachedFileMetadata)
    #[test]
                            state.tracker.remove(&key);
        if result.is_some() {
            ),
    }
            if let Ok(mut state) = self.memory_state.lock() {
            })),
        let freed = cache.evict(memory_before / 2).unwrap();
use datafusion::execution::cache::TableScopedPath;
        let key = k.to_string();
        assert_eq!(cache.len(), 0);
                cache_clone.put_statistics(&path, stats, &meta);
/// Compute statistics from a parquet file using DataFusion's built-in functionality
    }
        cache.put_statistics(&path1, stats, &meta1);
        if result.is_some() {
    fn test_manual_eviction_with_memory_tracking() {
        for candidate_key in eviction_candidates {
use crate::eviction_policy::{create_policy, CacheError, CachePolicy, CacheResult, PolicyType};
use arrow_schema::SchemaRef;
/// Extension trait to add memory_size method to Statistics
        // This cache does not track table scope, so there are no per-table
    }
        assert_eq!(cache.hit_count(), 0);
            let meta = create_test_meta(&path);
    fn heap_size(&self) -> usize {
        let cache = CustomStatisticsCache::new(PolicyType::Lru, 50 * 1024 * 1024, 0.8);
            let stats = Arc::new(create_test_statistics());
        let memory_with_two = cache.memory_consumed();
            self.miss_count.fetch_add(1, Ordering::Relaxed);
                if let Ok(path) = self.parse_key_to_path(&key) {
        assert_eq!(cache.miss_count(), 0);
        &self,
        assert_eq!(cache.hit_count(), 1);
        let new_policy = create_policy(policy_type).expect("statistics cache requires Lru or Lfu");
    }
    fn test_clear_with_memory_tracking() {
                        freed_size += entry_size;
    }
        self.hit_count.load(Ordering::Relaxed)
                .map_err(|e| CacheError::PolicyLockError {
    }
    }
            .lock()
    }
            handles.push(handle);
        size: file_metadata.len(),
    fn heap_size(&self) -> usize {
            .lock()
        Self::new(PolicyType::Lru, 100 * 1024 * 1024, 0.8) // 100MB default
}
        Ok(())
                }
mod tests {
        Self::with_default_config()
impl CustomStatisticsCache {
}
        assert_eq!(cache.len(), 0);
        CustomStatisticsCache::len(self)
    /// Remove entry internally (works with &self since inner_cache is thread-safe)
                let stats = Arc::new(create_test_statistics());
) -> Result<Statistics, Box<dyn std::error::Error>> {
    #[test]
        CustomStatisticsCache::clear(self)
            let path = create_test_path(&format!("file{}", i));
            + self.total_byte_size.heap_size()
                std::mem::size_of::<Self>() + s.capacity()
                    }
        let cache = CustomStatisticsCache::with_default_config();
            }
        let stats = Arc::new(create_test_statistics());
        CustomStatisticsCache::put(self, &k.path, v)
        }
        self.policy().on_insert(&key, memory_size);
    }
        &self.inner_cache
        let mut cache = CustomStatisticsCache::with_default_config();
    fn test_miss_count_tracking() {
    }
            total_byte_size: Precision::Exact(50000),
            if let Some(old_size) = state.tracker.get(&key) {
use std::collections::HashMap;
    ) -> datafusion::common::Result<()> {
        let cache = CustomStatisticsCache::with_default_config();
        }
        let cache = Arc::new(CustomStatisticsCache::with_default_config());
        assert!(cache.get(&path).is_some());
    }
impl<T: HeapSize> HeapSize for Vec<T> {
    #[test]
    }
    file_path: &str,
            if let Ok(mut state) = self.memory_state.lock() {
    #[test]
            self.hit_count.fetch_add(1, Ordering::Relaxed);
                        }
    }
        let path = create_test_path("file1");
        assert!(cache.get(&path).is_some());
    pub fn remove(&self, k: &Path) -> Option<CachedFileMetadata> {
use std::sync::{Arc, Mutex};
use datafusion::common::TableReference;
    pub fn inner(&self) -> &DashMap<Path, CachedFileMetadata> {
    pub fn with_default_config() -> Self {
            "CustomStatisticsCache({})",
    fn get(&self, k: &TableScopedPath) -> Option<CachedFileMetadata> {
            memory_state: Arc::new(Mutex::new(MemoryState {
            + self.num_rows.heap_size()
            };
    size_limit: AtomicUsize,
use datafusion::execution::cache::cache_manager::{
    let statistics = DFParquetMetadata::statistics_from_parquet_metadata(metadata, schema)?;
    /// Get current policy name
        let mut handles = vec![];
                let state = self
            self.policy().on_remove(&key);
            + self.num_rows.heap_size()
/// Avoids a second file/IO round-trip when the footer has already been fetched
    /// Update the cache size limit
        let cached = CachedFileMetadata::new(meta.clone(), stats, None);
            }
        Ok(freed_size)
            cache.put_statistics(&path, stats, &meta);
    }
        assert!(cache.get(&path).is_some());
        for i in 0..3 {
                std::mem::size_of::<Self>() + b.capacity()
        for key in candidates {
///
    let metadata = builder.metadata();
    }
        cache.put_statistics(&path2, stats, &meta2);
        let path1 = create_test_path("file1");
        }
            let meta = create_test_meta(&path);
        let cache = CustomStatisticsCache::with_default_config();
    fn test_reset_stats() {
            .map(|guard| guard.total)
    #[test]
            self.policy().on_access(&key, memory_size);
        0 // Primitive types don't have heap allocation
    fn drop_table_entries(
    /// Get total memory consumed by all cached statistics
            + self.distinct_count.heap_size()
    pub fn name(&self) -> String {
        Ok(self.policy().policy_name().to_string())
 *
            }
    fn create_test_path(name: &str) -> Path {
        result.map(|s| s.value().clone())
    pub fn new(policy_type: PolicyType, size_limit: usize, eviction_threshold: f64) -> Self {
        assert_eq!(cache.len(), 2);
        assert_eq!(cache.memory_consumed(), memory_before);
    }
        CustomStatisticsCache::remove(self, &k.path)
}
        self.memory_state
        assert_eq!(cache.len(), 0);
        result.map(|x| x.1)
    total: usize,
        let cache = CustomStatisticsCache::with_default_config();
    fn clear(&self) {
use parquet::file::metadata::ParquetMetaData;
            let cache_clone = Arc::clone(&cache);
    let _store: Arc<dyn object_store::ObjectStore> = Arc::new(LocalFileSystem::new());
    fn default() -> Self {
        }
        }
                let state = self.memory_state.lock();
                    .map(|s| s.tracker.get(&key).copied().unwrap_or(0))
        meta: &ObjectMeta,
    fn heap_size(&self) -> usize {
            .unwrap_or(0)
 * SPDX-License-Identifier: Apache-2.0
        assert_eq!(cache.memory_consumed(), 0);
impl FileStatisticsCache for CustomStatisticsCache {
                vec![]
    pub fn evict(&mut self, target_size: usize) -> CacheResult<usize> {
        let result = self.inner_cache.insert(k.clone(), v);
    }
    fn create_test_statistics() -> Statistics {
                state.total = state.total.saturating_sub(*old_size);
        let result = self.inner_cache.remove(k);
            + self.total_byte_size.heap_size()
    }
        cache.reset_stats();
            + self.column_statistics.heap_size()
        assert_eq!(cache.cache_limit(), 30 * 1024 * 1024);
        let entries: Vec<(String, usize)> = {
// These are inherent methods: for a `&Path` argument they take priority over the
    // statistics_from_parquet_metadata is an associated function that takes metadata and schema
pub fn compute_parquet_statistics_from_metadata(
    ) -> Option<CachedFileMetadata> {
            + self.iter().map(|item| item.heap_size()).sum::<usize>()
/// and adds memory tracking + policy-based eviction on top.
    Ok(statistics)
    fn list_entries(&self) -> std::collections::HashMap<TableScopedPath, FileStatisticsCacheEntry> {
impl Default for CustomStatisticsCache {
                    if freed_size >= target_size {
            let path = create_test_path(&format!("file{}", i));
        assert!(memory_before > 0);
    /// Convenience method: put statistics with associated metadata (replaces old put_with_extra)
            let stats = Arc::new(create_test_statistics());
            return Ok(0);
    #[test]
    fn test_memory_tracking_with_policy() {
        assert_eq!(cache.miss_count(), 0);
        }
            .clone()
                .lock()
            state.tracker.iter().map(|(k, v)| (k.clone(), *v)).collect()
            for candidate_key in candidates {
    use super::*;
    pub fn set_policy(&self, policy_type: PolicyType) -> CacheResult<()> {
/// is responsible for providing the correct Arrow schema derived from the same
    fn heap_size(&self) -> usize {
        assert_eq!(cache.len(), 1); // entries still exist
        }
        }
        std::mem::size_of::<Self>()
        self.size_limit.store(new_limit, Ordering::Relaxed);
    let _object_meta = ObjectMeta {
        let stats = Arc::new(create_test_statistics());
}
trait HeapSize {
        let current_size = self.current_size()?;
        self.put(k, cached)
        cache.get(&path1); // hit
        let result = self.inner_cache.get(k);
            } else {
    fn remove(&self, k: &TableScopedPath) -> Option<CachedFileMetadata> {
            _ => std::mem::size_of::<Self>(), // Primitive types and nulls
        cache.put_statistics(&path1, stats.clone(), &meta1);
            ScalarValue::Binary(Some(b)) | ScalarValue::LargeBinary(Some(b)) => {
        }
    use object_store::path::Path;
        let current_size = self.memory_state.lock().map(|s| s.total).unwrap_or(0);
        assert!(cache.memory_consumed() > 0);
        cache.get(&path1); // hit
    }
    let statistics = DFParquetMetadata::statistics_from_parquet_metadata(metadata, &schema)?;
}
        let key = k.to_string();
}
        let memory_size = v.statistics.memory_size();
use object_store::{path::Path, ObjectMeta};
        self.miss_count.load(Ordering::Relaxed)
    CachedFileMetadata, FileStatisticsCache, FileStatisticsCacheEntry,
        assert_eq!(cache.hit_count(), 1);
                        reason: format!("Failed to acquire memory_state lock: {}", e),
        let memory_before = cache.memory_consumed();
            self.policy_name().unwrap_or_else(|_| "unknown".to_string())
    #[test]
    }
        let path1 = create_test_path("file1");
{
    }
            miss_count: AtomicUsize::new(0),
            let candidates = self.policy().select_for_eviction(target_eviction);
    }
        }
        Ok(self.memory_consumed())
        FileStatisticsCache::update_cache_limit(&cache, 20 * 1024 * 1024);
        if let Ok(mut state) = self.memory_state.lock() {
        cache.set_policy(PolicyType::Lfu).unwrap();
            ScalarValue::Utf8(Some(s)) | ScalarValue::LargeUtf8(Some(s)) => {
impl CustomStatisticsCache {
    }
        let path = create_test_path("nonexistent");
        cache.put_statistics(&path, stats, &meta);
            ScalarValue::List(arr) => {
                    .unwrap_or(0)
        result
            let meta = create_test_meta(&path);
    }
        assert_eq!(cache.policy_name().unwrap(), "lru");
                        break;
/// Compute statistics from an already-loaded `ParquetMetaData` and schema.
            + self.column_statistics.heap_size()
                self.policy().select_for_eviction(target_eviction)
            cache.put_statistics(&path, stats, &meta);
        cache.get(&path2); // miss
            handle.join().unwrap();
                // Estimate list array memory size
    }
    pub fn current_size_limit(&self) -> usize {
// Storage stays Path-keyed (see inherent methods above); this delegates via
        assert_eq!(cache.hit_count(), 2);
    /// Cache hit count (thread-safe)
    }
            if entry_size > 0 {
    }
    }
        let path2 = create_test_path("file2");
        let cache = CustomStatisticsCache::new(PolicyType::Lru, 1024 * 1024, 0.8);
                }
use datafusion::physical_plan::Statistics;
        Ok(Path::from(key))
            let state = self
            if current_size + memory_size > threshold {
                }
struct MemoryState {
    metadata: &ParquetMetaData,
        self.size_limit.load(Ordering::Relaxed)
    }
        for i in 0..5 {
}
    /// Switch to a different eviction policy, rebuilding state from current entries.
            0.0
            new_policy.on_insert(&key, size);
}
) -> Result<Statistics, Box<dyn std::error::Error>> {
        } else {
pub struct CustomStatisticsCache {
    }
    pub fn update_size_limit(&self, new_limit: usize) -> CacheResult<()> {
    // Use DataFusion's method to extract statistics from parquet metadata
            self.policy().on_remove(&key);
            .map(|s| s.tracker.len())
        let mut freed_size = 0;
    /// Combined memory tracking state
        let meta = create_test_meta(&path);
            let path = create_test_path(&format!("file{}", i));
    /// The underlying DataFusion statistics cache (DashMap-based, already thread-safe)
        let misses = self.miss_count();
    for Precision<T>
/// Combined memory state: per-key sizes + total.
    use datafusion::parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
    pub fn policy_name(&self) -> CacheResult<String> {
    }
        }
                    .map_err(|e| CacheError::PolicyLockError {
        let total = hits + misses;
    memory_state: Arc<Mutex<MemoryState>>,
        Self {
            + (self.capacity() * std::mem::size_of::<T>())
        std::mem::size_of::<Self>()
                    if self.inner_cache.remove(&path).is_some() {
                let meta = create_test_meta(&path);
        ObjectMeta {
    pub fn current_size(&self) -> CacheResult<usize> {
            last_modified: Utc::now(),
    }
        for i in 0..10 {
        let path2 = create_test_path("missing");
    }
                    .memory_state
        std::mem::size_of::<Self>()
        };
    fn create_test_meta(path: &Path) -> ObjectMeta {
        assert!(cache.get(&path).is_none());
        for i in 0..3 {
        match self {
    policy: Mutex<Arc<dyn CachePolicy>>,
                // Estimate struct array memory size
    #[test]
            .unwrap_or_else(|e| e.into_inner())
    fn test_policy_based_eviction_with_memory() {
impl HeapSize for Statistics {
        assert!(cache.memory_consumed() > 0);
    /// Get current size limit in bytes (configured cap, not utilization)
        if target_size == 0 {
        *guard = new_policy;
                    })?;
            }
            let target_eviction =
        Ok(())
        version: None,
            }
 * compatible open source license.
#[cfg(test)]
    pub fn put_statistics(
                    .lock()
    /// Eviction threshold (0.0 to 1.0)
        assert_eq!(cache.miss_count(), 2);
        CustomStatisticsCache::get(self, &k.path)
                        if let Ok(mut state) = self.memory_state.lock() {
}
        assert_eq!(cache.miss_count(), 1);
        let meta1 = create_test_meta(&path1);
    }
            location: path.clone(),
    /// hot-path callers clone the `Arc` while holding the lock briefly, then call
    /// Get cache miss count
            num_rows: Precision::Exact(1000),
    }
        cache.get(&path2);
                let path = create_test_path(&format!("concurrent{}", i));
            .map_err(|e| CacheError::PolicyLockError {
                    (current_size + memory_size) - (size_limit as f64 * 0.6) as usize;
        std::collections::HashMap::new()
    }
                    reason: format!("Failed to acquire memory_state lock: {}", e),
            }
use datafusion::common::ScalarValue;
        e_tag: None,
    #[test]
    let schema = builder.schema().clone();
        assert!(cache.get(&path).is_none());
    fn memory_size(&self) -> usize {
        assert_eq!(cache.hit_count(), 0);
    }
        last_modified: chrono::DateTime::from(file_metadata.modified()?),
// `&key.path`. The table scope is not used by this cache.
    schema: &SchemaRef,
            hit_count: AtomicUsize::new(0),
        assert_eq!(cache.cache_limit(), 50 * 1024 * 1024);
            let path = create_test_path(&format!("file{}", i));
        let stats = Arc::new(create_test_statistics());
        cache.clear();
        cache.put_statistics(&path, stats, &meta);
    /// Clone the policy Arc without holding the Mutex. Hot-path callers use this
            }
    fn test_custom_stats_cache_creation() {
    #[test]
        let key = k.to_string();
}
                current_size - (new_limit as f64 * self.eviction_threshold) as usize;
}
    /// Get cache hit count
            .unwrap_or(0)
        let path = create_test_path("file1");
    /// Size limit for the cache in bytes
        let meta2 = create_test_meta(&path2);
        cache.get(&path);
            state.total = 0;
    let path = Path::from(file_path);
    fn test_clear_resets_stats() {
    pub fn miss_count(&self) -> usize {
    }
        let meta1 = create_test_meta(&path1);
    eviction_threshold: f64,
        assert_eq!(cache.len(), 0);
                tracker: HashMap::new(),
        assert_eq!(cache.policy_name().unwrap(), "lfu");
    fn test_hit_count_tracking() {
    #[test]
    }
        cache.remove(&path2);
        assert_eq!(cache.cache_limit(), 50 * 1024 * 1024);
    fn cache_limit(&self) -> usize {
    hit_count: AtomicUsize,
            cache.put_statistics(&path, stats, &meta);
///
        self.policy().clear();
            state.tracker.insert(key.clone(), memory_size);
}
// `TableScopedPath`; the convenience methods and tests in this module still use
impl StatisticsMemorySize for Statistics {
        assert!(cache.memory_consumed() <= 1000);
        assert!(cache.len() > 0);
        assert!(cache.memory_consumed() < memory_before);
            Precision::Absent => std::mem::size_of::<Self>(),
    fn memory_size(&self) -> usize;
impl HeapSize for ColumnStatistics {
// DF54 `FileStatisticsCache: CacheAccessor<TableScopedPath, CachedFileMetadata>`.
        // entries to drop. No-op.
/// Protected by a single mutex to eliminate nested-lock deadlock risk.
