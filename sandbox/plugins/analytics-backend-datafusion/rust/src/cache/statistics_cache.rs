                let state = self
        self.get(k).map(|c| c.statistics)
// CacheAccessor<TableScopedPath> impl below delegates to these via `&key.path`.
                .map_err(|e| CacheError::PolicyLockError {
            ScalarValue::Struct(arr) => {
        cache.get(&path);
    }
                }
        let cache = CustomStatisticsCache::with_default_config();
}
            let path = create_test_path(&format!("file{}", i));
/// (e.g. by `load_parquet_metadata` during metadata cache warming). The caller
            return Ok(0);
        let path = create_test_path("nonexistent");
// `&key.path`. The table scope is not used by this cache.
/// Trait to calculate heap memory size for statistics objects
        assert_eq!(cache.miss_count(), 0);
 * this file be licensed under the Apache-2.0 license or a
            num_rows: Precision::Exact(1000),
            size: 1000,
    use datafusion::datasource::physical_plan::parquet::metadata::DFParquetMetadata;
                .lock()
            }
    // Create ObjectStore and ObjectMeta for the file
        }
    }
        size: file_metadata.len(),
    pub fn set_policy(&self, policy_type: PolicyType) -> CacheResult<()> {
        }
        let meta = create_test_meta(&path);
        let cache = CustomStatisticsCache::with_default_config();
            + self.null_count.heap_size()
}
    }
        assert_eq!(cache.hit_count(), 1);
impl StatisticsMemorySize for Statistics {
    use datafusion::datasource::physical_plan::parquet::metadata::DFParquetMetadata;
    pub fn len(&self) -> usize {
    /// Remove entry internally (works with &self since inner_cache is thread-safe)
            + self.iter().map(|item| item.heap_size()).sum::<usize>()
    let schema = builder.schema().clone();
        cache.put_statistics(&path1, stats.clone(), &meta1);
    let metadata = builder.metadata();
            ScalarValue::List(arr) => {
    fn remove_internal(&self, k: &Path) -> Option<CachedFileMetadata> {
    }
    fn len(&self) -> usize {
    }
            "CustomStatisticsCache({})",
        cache.put_statistics(&path, stats, &meta);
    }
                    (current_size + memory_size) - (size_limit as f64 * 0.6) as usize;
        std::mem::size_of::<Self>()
        self.size_limit.store(new_limit, Ordering::Relaxed);
    use object_store::local::LocalFileSystem;
                    .lock()
    fn heap_size(&self) -> usize {
            + self.num_rows.heap_size()
                state
        let entries: Vec<(String, usize)> = {
        cache.put_statistics(&path, stats, &meta);
        for i in 0..3 {
        if let Ok(mut state) = self.memory_state.lock() {
            self.miss_count.fetch_add(1, Ordering::Relaxed);
use datafusion::common::TableReference;
            version: None,
) -> Result<Statistics, Box<dyn std::error::Error>> {
            self.policy().on_remove(&key);
            let size_limit = self.size_limit.load(Ordering::Relaxed);
            };
    }
impl HeapSize for ColumnStatistics {
    fn test_clear_resets_stats() {
    /// Get cache hit count
    /// Convenience method: put statistics with associated metadata (replaces old put_with_extra)
}
    hit_count: AtomicUsize,
        let memory_before = cache.memory_consumed();
}
            self.hit_count.fetch_add(1, Ordering::Relaxed);
        let cache = CustomStatisticsCache::new(PolicyType::Lru, 1024 * 1024, 0.8);
            state.total += memory_size;
        assert_eq!(cache.hit_count(), 2);
    };
    #[test]
    pub fn miss_count(&self) -> usize {
            .clone()
        version: None,
use datafusion::execution::cache::cache_manager::{
                }
        result.map(|x| x.1)
        assert_eq!(cache.policy_name().unwrap(), "lru");
                    .map(|s| s.tracker.get(&key).copied().unwrap_or(0))
        assert!(cache.memory_consumed() < memory_with_two);
        if result.is_some() {
    #[test]
                if let Ok(path) = self.parse_key_to_path(&key) {
            let stats = Arc::new(create_test_statistics());
        Ok(())
        assert_eq!(cache.miss_count(), 0);
            .map(|s| s.tracker.len())
        let cache = CustomStatisticsCache::new(PolicyType::Lru, 50 * 1024 * 1024, 0.8);
        assert_eq!(cache.miss_count(), 1);
use datafusion::physical_plan::Statistics;
    }
    }
            .map_err(|e| CacheError::PolicyLockError {
) -> Result<Statistics, Box<dyn std::error::Error>> {
        let result = self.inner_cache.remove(k);
            self.policy().on_access(&key, memory_size);
            }
        }
        assert_eq!(cache.hit_count(), 0);
    file_path: &str,
        for i in 0..10 {
    /// Reset hit and miss counters
            if let Ok(path) = self.parse_key_to_path(&candidate_key) {
            self.policy_name().unwrap_or_else(|_| "unknown".to_string())
        assert_eq!(cache.hit_count(), 0);
use std::collections::HashMap;
    }
        let path = create_test_path("file1");
            if entry_size > 0 {
///
        assert_eq!(cache.len(), 2);
            let stats = Arc::new(create_test_statistics());
        assert!(cache.get(&path).is_none());
            let meta = create_test_meta(&path);
                std::mem::size_of::<Self>() + std::mem::size_of_val(arr.as_ref()) + (arr.len() * 16)
        self.miss_count.load(Ordering::Relaxed)
 *
        std::collections::HashMap::new()
            state.tracker.clear();
            .unwrap_or(0)
        assert_eq!(cache.miss_count(), 0);
    }
            ),
}
            Precision::Inexact(val) => std::mem::size_of::<Self>() + val.heap_size(),
        let path2 = create_test_path("missing");
        }
            .unwrap_or_else(|e| e.into_inner())
        )
            let threshold = (size_limit as f64 * self.eviction_threshold) as usize;
        Ok(Path::from(key))
                tracker: HashMap::new(),
    fn test_memory_tracking_with_policy() {
    }
    /// Get total memory consumed by all cached statistics
    // Use DataFusion's method to extract statistics from parquet metadata
use arrow_schema::SchemaRef;
        self.memory_state
        for handle in handles {
    miss_count: AtomicUsize,
                self.remove_internal(&path);
        self.miss_count.store(0, Ordering::Relaxed);
    pub fn current_size(&self) -> CacheResult<usize> {
 */
                state.tracker.get(&key).copied().unwrap_or(0)
 * The OpenSearch Contributors require contributions made to
        assert_eq!(cache.policy_name().unwrap(), "lfu");
            for candidate_key in candidates {
        assert!(cache.len() > 0);
    }
        assert_eq!(cache.len(), 0);
            .lock()
                .memory_state
// bare `Path`, so the storage and bookkeeping stay Path-keyed and the
        for key in candidates {
    pub fn contains_key(&self, k: &Path) -> bool {
    fn create_test_statistics() -> Statistics {
    CachedFileMetadata, FileStatisticsCache, FileStatisticsCacheEntry,
            }
    fn heap_size(&self) -> usize {
        let meta1 = create_test_meta(&path1);
/*
                assert!(cache_clone.get(&path).is_some());
            let meta = create_test_meta(&path);
mod tests {
    }
        Ok(self.memory_consumed())
                    }
impl CustomStatisticsCache {
                        if let Ok(mut state) = self.memory_state.lock() {
        &self,
        let new_policy = create_policy(policy_type).expect("statistics cache requires Lru or Lfu");
            last_modified: Utc::now(),
impl HeapSize for ScalarValue {
    }
    fn put(&self, k: &TableScopedPath, v: CachedFileMetadata) -> Option<CachedFileMetadata> {
};
        assert_eq!(cache.len(), 0);
            .policy
    }
        }
        let cache = CustomStatisticsCache::with_default_config();
            let path = create_test_path(&format!("file{}", i));
    }
    fn heap_size(&self) -> usize {
///
        assert!(cache.memory_consumed() > 0);
            } else {
// These are inherent methods: for a `&Path` argument they take priority over the
        if current_size > new_limit {
        let meta = create_test_meta(&path);
    /// Create a new custom statistics cache
}
    fn memory_size(&self) -> usize;
    }
        FileStatisticsCache::update_cache_limit(&cache, 20 * 1024 * 1024);
        Ok(freed_size)
        let cache = CustomStatisticsCache::new(PolicyType::Lru, 1000, 0.8);
    /// Get current size limit in bytes (configured cap, not utilization)
    metadata: &ParquetMetaData,
        &self,
    }
            let handle = thread::spawn(move || {
                total: 0,
        ObjectMeta {
    }
        self.inner_cache.get(k).is_some()
    fn test_reset_stats() {
    pub fn current_size_limit(&self) -> usize {
        let misses = self.miss_count();
    }
    }
impl FileStatisticsCache for CustomStatisticsCache {
    fn create_test_meta(path: &Path) -> ObjectMeta {
        cache.get(&path2); // miss
    pub fn update_size_limit(&self, new_limit: usize) -> CacheResult<()> {
            let key = k.to_string();
    #[test]
        std::mem::size_of::<Self>()
            }
    pub fn remove(&self, k: &Path) -> Option<CachedFileMetadata> {
            }
/// and adds memory tracking + policy-based eviction on top.
    #[test]
        assert_eq!(cache.miss_count(), 2);
            let stats = Arc::new(create_test_statistics());
/// Protected by a single mutex to eliminate nested-lock deadlock risk.
        Ok(())
            hit_count: AtomicUsize::new(0),
    fn drop_table_entries(
            state.total = 0;
    #[test]
    }
        cache.get(&path1); // hit
        assert_eq!(cache.len(), 0);
                    })?;
use crate::eviction_policy::{create_policy, CacheError, CachePolicy, CacheResult, PolicyType};
                    state.total = state.total.saturating_sub(old_size);
    pub fn new(policy_type: PolicyType, size_limit: usize, eviction_threshold: f64) -> Self {
    ) -> datafusion::common::Result<()> {
        _table_ref: &Option<TableReference>,
    let file_metadata = std::fs::metadata(file_path)?;
        let cache = CustomStatisticsCache::with_default_config();
            miss_count: AtomicUsize::new(0),
        result
        self.size_limit.load(Ordering::Relaxed)
        for i in 0..5 {
            })),
                if let Ok(path) = self.parse_key_to_path(&candidate_key) {
    fn test_manual_eviction_with_memory_tracking() {
        let result = self.inner_cache.get(k);
        if result.is_some() {
/// Combined memory state: per-key sizes + total.
// Path-keyed core operations. DF54 keys the FileStatisticsCache by
    tracker: HashMap<String, usize>,
        e_tag: None,
        let cache = CustomStatisticsCache::with_default_config();
        std::mem::size_of::<Self>()
        let path = create_test_path("file1");
    size_limit: AtomicUsize,
            let meta = create_test_meta(&path);
        assert_eq!(cache.cache_limit(), 50 * 1024 * 1024);
    }
    }
    pub fn evict(&mut self, target_size: usize) -> CacheResult<usize> {
            }
    /// Create with default configuration
            let target_eviction =
{
    }
                let path = create_test_path(&format!("concurrent{}", i));
        last_modified: chrono::DateTime::from(file_metadata.modified()?),
        }
    }
                    .map_err(|e| CacheError::PolicyLockError {
            }
}
    }
        }
                create_policy(policy_type).expect("statistics cache requires Lru or Lfu"),
        let mut handles = vec![];
    }
        0 // Primitive types don't have heap allocation
            };
impl HeapSize for usize {
    let _object_meta = ObjectMeta {
        let total = hits + misses;
            inner_cache: DashMap::new(),
        assert!(memory_before > 0);
}
    }
        CustomStatisticsCache::len(self)
// trait's `&TableScopedPath` methods, so existing callers keep working unchanged.
        let path = create_test_path("file1");
        meta: &ObjectMeta,
// DF54 `FileStatisticsCache: CacheAccessor<TableScopedPath, CachedFileMetadata>`.
        for (key, size) in entries {
        cache.put_statistics(&path1, stats, &meta1);
        assert!(cache.memory_consumed() <= 1000);
    Ok(statistics)
            ScalarValue::Utf8(Some(s)) | ScalarValue::LargeUtf8(Some(s)) => {
            0.0
        let memory_size = v.statistics.memory_size();
            + self.column_statistics.heap_size()
            }
impl Default for CustomStatisticsCache {
                current_size - (new_limit as f64 * self.eviction_threshold) as usize;
}
        }
    policy: Mutex<Arc<dyn CachePolicy>>,
}
        assert!(cache.get(&path).is_none());
        let memory_with_two = cache.memory_consumed();
            new_policy.on_insert(&key, size);
        let meta = create_test_meta(&path);
        cache.reset_stats();
use datafusion::common::ScalarValue;
        let meta1 = create_test_meta(&path1);
    memory_state: Arc<Mutex<MemoryState>>,
    }
    #[test]
impl CustomStatisticsCache {
            + self.distinct_count.heap_size()
                        reason: format!("Failed to acquire memory_state lock: {}", e),
            .lock()
    }
    /// hot-path callers clone the `Arc` while holding the lock briefly, then call
        assert_eq!(cache.hit_count(), 0);
    fn heap_size(&self) -> usize {
    fn cache_limit(&self) -> usize {
        let key = k.to_string();
                            state.total = state.total.saturating_sub(entry_size);
    /// Current eviction policy. `Mutex` guards atomic swaps in `set_policy`;
            if let Some(old_size) = state.tracker.get(&key) {
    fn contains_key(&self, k: &TableScopedPath) -> bool {
        self.hit_count.store(0, Ordering::Relaxed);
        cache.get(&path2);
impl CacheAccessor<TableScopedPath, CachedFileMetadata> for CustomStatisticsCache {
    use datafusion::common::stats::Precision;
        }
}
                    .unwrap_or(0)
        };
        let meta = create_test_meta(&path);
        self.inner_cache.clear();
    pub fn reset_stats(&self) {
                let state = self.memory_state.lock();
                        self.policy().on_remove(&key);
        Self {
    inner_cache: DashMap<Path, CachedFileMetadata>,
    pub fn get_statistics(&self, k: &Path) -> Option<Arc<Statistics>> {
    #[test]
trait StatisticsMemorySize {
        for i in 0..3 {
    }
        match self {
}
    }
        let cache = CustomStatisticsCache::with_default_config();
}
    }
        let path1 = create_test_path("file1");
        assert_eq!(cache.memory_consumed(), memory_before);
    pub fn hit_count(&self) -> usize {
                        break;
}
                state.total = state.total.saturating_sub(*old_size);
        // This cache does not track table scope, so there are no per-table
    /// Get the underlying cache for compatibility
            + self.min_value.heap_size()
            state.tracker.insert(key.clone(), memory_size);
    fn clear(&self) {
    }
    fn test_remove_with_memory_tracking() {
    pub fn clear(&self) {
    }
    let _store: Arc<dyn object_store::ObjectStore> = Arc::new(LocalFileSystem::new());
    #[test]
        Self::new(PolicyType::Lru, 100 * 1024 * 1024, 0.8) // 100MB default
                    if freed_size >= target_size {
                let meta = create_test_meta(&path);
            cache.put_statistics(&path, stats, &meta);
        assert_eq!(cache.len(), 0);
    fn name(&self) -> String {
use dashmap::DashMap;
            let path = create_test_path(&format!("file{}", i));
            .unwrap_or(0)
        let mut freed_size = 0;
    pub fn with_default_config() -> Self {
        let path1 = create_test_path("file1");
                })?;
        self.hit_count.load(Ordering::Relaxed)
            })?;
    fn memory_size(&self) -> usize {
    Ok(statistics)
        for i in 0..10 {
        if result.is_some() {
            }
        let stats = Arc::new(create_test_statistics());
    }
                }
    /// so they don't hold the lock while calling policy methods.
    fn test_clear_with_memory_tracking() {
    /// Clone the policy Arc without holding the Mutex. Hot-path callers use this
        assert_eq!(cache.memory_consumed(), 0);
        format!(
    fn list_entries(&self) -> std::collections::HashMap<TableScopedPath, FileStatisticsCacheEntry> {
            if current_size + memory_size > threshold {
        let cache = CustomStatisticsCache::with_default_config();
        let mut cache = CustomStatisticsCache::with_default_config();
        assert!(cache.memory_consumed() < memory_before);
            let state = self
            let stats = Arc::new(create_test_statistics());
        cache.clear();
    use super::*;
            self.policy().on_remove(&key);
        let cache = CustomStatisticsCache::with_default_config();
        let cache = CustomStatisticsCache::with_default_config();
        let current_size = self.memory_state.lock().map(|s| s.total).unwrap_or(0);
        cache.clear();
    }
        CustomStatisticsCache::clear(self)
    }
        result.map(|s| s.value().clone())
        }
    // statistics_from_parquet_metadata is an associated function that takes metadata and schema
    use datafusion::parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
        &self.inner_cache
        Ok(())
impl<T: HeapSize> HeapSize for Vec<T> {
        assert!(freed > 0);
                        }
                // Estimate struct array memory size
            state.tracker.iter().map(|(k, v)| (k.clone(), *v)).collect()
pub fn compute_parquet_statistics(
                vec![]
        let path2 = create_test_path("missing");
    }
use object_store::{path::Path, ObjectMeta};
            });
}
        if total == 0 {
use datafusion::execution::cache::CacheAccessor;
        let current_size = self.current_size()?;
            + self.total_byte_size.heap_size()
            cache.put_statistics(&path, stats, &meta);
    fn test_concurrent_operations() {
        let key = k.to_string();
    }
    /// Update the cache size limit
// `TableScopedPath`; the convenience methods and tests in this module still use
        assert_eq!(cache.len(), 1);
                if let Some(old_size) = state.tracker.remove(&key) {
            column_statistics: vec![],
        if target_size == 0 {
        assert_eq!(cache.policy_name().unwrap(), "lru");
        result.map(|x| x.1)
use parquet::file::metadata::ParquetMetaData;
    }
    let statistics = DFParquetMetadata::statistics_from_parquet_metadata(metadata, schema)?;
        cache.get(&path);
        }
                    state.total = state.total.saturating_sub(old_size);
        }
        let eviction_candidates = {
            + self.total_byte_size.heap_size()
        assert_eq!(cache.len(), 1);
    /// Get current policy name
    fn test_update_cache_limit_trait_is_noop() {
    fn create_test_path(name: &str) -> Path {
        let stats = Arc::new(create_test_statistics());
/// Avoids a second file/IO round-trip when the footer has already been fetched
                    reason: format!("Failed to acquire memory_state lock: {}", e),
        assert_eq!(cache.memory_consumed(), 0);
        let result = self.inner_cache.remove(k);
        assert_eq!(cache.hit_rate(), 1.0);
        self.policy
    }
        self.policy().on_insert(&key, memory_size);
    let builder = ParquetRecordBatchReaderBuilder::try_new(file)?;
        }
    use object_store::path::Path;
pub struct CustomStatisticsCache {
        self.memory_state
    fn remove(&self, k: &TableScopedPath) -> Option<CachedFileMetadata> {
    }
        let stats = Arc::new(create_test_statistics());
    fn test_custom_stats_cache_creation() {
    let statistics = DFParquetMetadata::statistics_from_parquet_metadata(metadata, &schema)?;
    pub fn hit_rate(&self) -> f64 {
    for Precision<T>
        let stats = Arc::new(create_test_statistics());
/// Combined memory tracking and policy-based eviction cache
        assert!(cache.len() > 0);
    /// Get current cache size according to policy (uses actual memory consumption)
        cache.set_policy(PolicyType::Lfu).unwrap();
            .lock()
        let mut guard = self
            + self.column_statistics.heap_size()
    fn heap_size(&self) -> usize {
    use chrono::Utc;
            Precision::Exact(val) => std::mem::size_of::<Self>() + val.heap_size(),
    /// Eviction threshold (0.0 to 1.0)
    let path = Path::from(file_path);
        let path = create_test_path("file1");
/// Extension trait to add memory_size method to Statistics
        } else {
        CustomStatisticsCache::put(self, &k.path, v)
    fn policy(&self) -> Arc<dyn CachePolicy> {
        Ok(self.policy().policy_name().to_string())
            cache.put_statistics(&path, stats, &meta);
                self.policy().select_for_eviction(target_eviction)
}
use arrow_array::Array;
            cache.put_statistics(&path, stats, &meta);
        assert_eq!(cache.cache_limit(), 50 * 1024 * 1024);
        stats: Arc<Statistics>,
            if let Ok(mut state) = self.memory_state.lock() {
/// Compute statistics from an already-loaded `ParquetMetaData` and schema.
        *guard = new_policy;
    #[test]
        }
            size_limit: AtomicUsize::new(size_limit),
            let cache_clone = Arc::clone(&cache);
impl<T: HeapSize + std::fmt::Debug + Clone + PartialEq + Eq + PartialOrd> HeapSize
                std::mem::size_of::<Self>() + s.capacity()
        assert!((cache.hit_rate() - 0.6666666666666666).abs() < 0.0001);
    #[test]
                let target_eviction =
            hits as f64 / total as f64
            .map(|guard| guard.total)
    fn update_cache_limit(&self, _limit: usize) {}
        assert_eq!(cache.len(), 1); // entries still exist
            let meta = create_test_meta(&path);
 * SPDX-License-Identifier: Apache-2.0
    #[test]
    #[test]
 * compatible open source license.
        let stats = Arc::new(create_test_statistics());
                    .memory_state
        }
    }
    /// Get cache miss count
    }
        assert_eq!(cache.hit_count(), 1);
    }
        assert!(cache.memory_consumed() > 0);
        cache.remove(&path2);
    fn test_policy_switching_with_memory() {
            location: path.clone(),
        let cache = Arc::new(CustomStatisticsCache::with_default_config());
}
            .lock()
impl HeapSize for Statistics {
    pub fn put_statistics(
    fn get(&self, k: &TableScopedPath) -> Option<CachedFileMetadata> {
    }
    }
        assert_eq!(cache.miss_count(), 1);
        self.policy().clear();
    /// Manually trigger eviction.
            handle.join().unwrap();
        let memory_before = cache.memory_consumed();
        };
    /// Get cache hit rate (returns value between 0.0 and 1.0)
        let stats = Arc::new(create_test_statistics());
        // entries to drop. No-op.
        }
            let path = create_test_path(&format!("file{}", i));
    }
    /// through the clone without holding the lock.
    /// Size limit for the cache in bytes
            eviction_threshold,
    pub fn put(&self, k: &Path, v: CachedFileMetadata) -> Option<CachedFileMetadata> {
        cache.put_statistics(&path, stats, &meta);
        if let Ok(mut state) = self.memory_state.lock() {
        Statistics {
                std::mem::size_of::<Self>() + std::mem::size_of_val(arr.as_ref()) + (arr.len() * 8)
    }
        assert_eq!(cache.cache_limit(), 30 * 1024 * 1024);
    }
                        freed_size += entry_size;
            + self.max_value.heap_size()
                std::mem::size_of::<Self>() + b.capacity()
        std::mem::size_of::<Self>()
    pub fn name(&self) -> String {
    fn test_hit_count_tracking() {
    pub fn policy_name(&self) -> CacheResult<String> {
        cache.get(&path1); // hit
}
    }
        assert_eq!(cache.memory_consumed(), 0);
/// is responsible for providing the correct Arrow schema derived from the same
        let meta2 = create_test_meta(&path2);
struct MemoryState {
        match self {
                            state.tracker.remove(&key);
        assert!(cache.get(&path).is_some());
        let result = self.inner_cache.insert(k.clone(), v);
    /// Combined memory tracking state
            if let Ok(mut state) = self.memory_state.lock() {
    pub fn get(&self, k: &Path) -> Option<CachedFileMetadata> {
    }
        CustomStatisticsCache::contains_key(self, &k.path)
    }
        CustomStatisticsCache::get(self, &k.path)
        assert!(cache.get(&path).is_some());
        k: &Path,
        self.put(k, cached)
        assert_eq!(cache.memory_consumed(), 0);
        Self::with_default_config()
        CustomStatisticsCache::name(self)
/// This cache leverages DashMap's built-in concurrency from DefaultFileStatisticsCache
    /// The underlying DataFusion statistics cache (DashMap-based, already thread-safe)
            }
use datafusion::common::stats::{ColumnStatistics, Precision};
                cache_clone.put_statistics(&path, stats, &meta);
        cache.remove(&path1);
    /// Switch to a different eviction policy, rebuilding state from current entries.
    /// Cache hit count (thread-safe)
                // Estimate list array memory size
    schema: &SchemaRef,
                    self.remove_internal(&path);
/// Compute statistics from a parquet file using DataFusion's built-in functionality
    pub fn memory_consumed(&self) -> usize {
        }
                if let Some(old_size) = state.tracker.remove(&key) {
        let freed = cache.evict(memory_before / 2).unwrap();
            total_byte_size: Precision::Exact(50000),
    #[test]
            Precision::Absent => std::mem::size_of::<Self>(),
use std::sync::atomic::{AtomicUsize, Ordering};
/// metadata.
        CustomStatisticsCache::remove(self, &k.path)
    fn default() -> Self {
        use datafusion::execution::cache::cache_manager::FileStatisticsCache;
        self.size_limit.load(Ordering::Relaxed)
    pub fn inner(&self) -> &DashMap<Path, CachedFileMetadata> {
    /// Cache miss count (thread-safe)
            ScalarValue::Binary(Some(b)) | ScalarValue::LargeBinary(Some(b)) => {
        let path2 = create_test_path("file2");
        } else {
    }
            _ => std::mem::size_of::<Self>(), // Primitive types and nulls
            }
    let file = File::open(file_path)?;
    ) -> Option<CachedFileMetadata> {
#[cfg(test)]
        assert_eq!(cache.len(), 0);
                }
                    if self.inner_cache.remove(&path).is_some() {
    fn test_hit_rate_calculation() {
                reason: format!("Failed to acquire policy lock: {}", e),
// Storage stays Path-keyed (see inherent methods above); this delegates via
    fn heap_size(&self) -> usize;
    eviction_threshold: f64,
        for candidate_key in eviction_candidates {
    }
        self.reset_stats();
        assert_eq!(cache.hit_rate(), 0.0);
            handles.push(handle);
        }
        }
    }
        let key = k.to_string();
                    }
        }
    }
    fn parse_key_to_path(&self, key: &str) -> CacheResult<Path> {
        Path::from(format!("/test/{}.parquet", name))
        cache.put_statistics(&path, stats, &meta);
    total: usize,
pub fn compute_parquet_statistics_from_metadata(
            + (self.capacity() * std::mem::size_of::<T>())
            e_tag: None,
        }
    fn heap_size(&self) -> usize {
    }
use std::fs::File;
            let memory_size = {
    /// Parse cache key back to Path
        cache.update_size_limit(30 * 1024 * 1024).unwrap();
                let stats = Arc::new(create_test_statistics());
            + self.num_rows.heap_size()
trait HeapSize {
        let candidates = self.policy().select_for_eviction(target_size);
        location: path,
        use std::thread;
            let entry_size = {
        let cached = CachedFileMetadata::new(meta.clone(), stats, None);
use std::sync::{Arc, Mutex};
            let candidates = self.policy().select_for_eviction(target_eviction);
    #[test]
            policy: Mutex::new(
        cache.put_statistics(&path2, stats, &meta2);
        let hits = self.hit_count();
        assert!(cache.get(&path).is_some());
}
    fn test_policy_based_eviction_with_memory() {
            memory_state: Arc::new(Mutex::new(MemoryState {
use datafusion::execution::cache::TableScopedPath;
    /// Convenience method: get just the statistics Arc (for callers that don't need full CachedFileMetadata)
        }
    fn test_miss_count_tracking() {
