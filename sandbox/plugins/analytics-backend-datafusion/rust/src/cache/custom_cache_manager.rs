    use crate::cache::page_index::{
            .map(|cache| cache.miss_count())
                        Some(a) => a.start.min(s)..a.end.max(e),
    /// Direct reference to the statistics cache
            "column index must be absent when statistics are disabled"
                }
    // ── compute_page_index_range ──────────────────────────────────────────────
                failed_files
    }
        // exact-key warm tier that 8-byte read probes key [size-8, size], which the
                "Failed to compute statistics for {}: {}",
        let mut mgr = CustomCacheManager::new();
            expected.push(r);
    offset_index_registered: bool,
    ///    range so it's also covered by the metadata Foyer promotion below
                        e_tag: None,
                        }
        self.file_metadata_cache
        e_tag: None,
    /// Key design:
    /// Get statistics cache hit rate
    /// Get statistics cache hit count
        }
        assert!(result.is_ok());
        use arrow::datatypes::{DataType, Field, Schema};
                .as_ref()
    }
            }
        }
    fn parquet_bytes(
        if let Err(e) =
        // matching the query-time whole-region probe keys exactly. A single merged
    }
            let path = Path::from(file_path);
/// Create ObjectMeta from a local file path.
        // Must not panic even with no metadata/stats caches set.
        .row_groups()
        }
                    .map_err(|e| format!("Failed to fetch footer: {}", e))
        ranges.push(r);
            file_metadata_cache: None,
    /// whether page indexes (column-index + offset-index) are emitted into the footer.
        if !failed_files.is_empty() {
            expected.push(r);
        );
                    .collect();
            })?;
            offset_index_registered: false,
            .as_ref()
    use chrono::{DateTime, Utc};
            .as_ref()
    pub fn statistics_cache_miss_count(&self) -> usize {
            page_index::clear_scoped_cache();
        match cache_type {
        for file_path in file_paths {
        if cache.contains_key(&path) {
        let mut success_count = 0;
        };
                    let meta = ObjectMeta {
        total
    /// Direct reference to the file metadata cache
    }
        assert!(mgr.column_index_registered);
    }
        let schema = Arc::new(Schema::new(fields));
            {
            .map(|cache| cache.clone() as Arc<dyn FileMetadataCache>)
            exp_ci.is_none(),
use object_store::path::Path;
                };
            }
        }
        use parquet::file::properties::WriterProperties;
    }
                        }
    }
            .statistics_cache
        use parquet::file::reader::FileReader;
        // Check if already cached
                                    stats_cache.put_statistics(&path, Arc::new(stats), &meta);
                }
        );
    use crate::cache::eviction_policy::PolicyType;
            );
    #[test]
    /// Create a new CustomCacheManager
        // 64 KB footer range above does NOT match — so without this the very first
 *
            .ok_or_else(|| "No file metadata cache configured".to_string())?
                    any_success = true;
    pub fn update_metadata_cache_limit(&self, new_limit: usize) {
        let _g = crate::test_process_globals::lock();
        // metadata read always misses the warm tier. Promoting the exact 8 bytes under
        store: Arc<dyn MetadataCachingStore>,
        let reader = SerializedFileReader::new(buf).unwrap();
    }
                let cols: Vec<Arc<dyn arrow::array::Array>> = (0..num_cols)
    }
        self.statistics_cache = Some(cache);
        let mut total = 0;
            let removed = if !errors.is_empty() && !any_removed {
        if let Some(cache) = &self.statistics_cache {
    let oi_region = metadata
                                        last_modified: chrono::Utc::now(),
        assert!(
                    error!(
                }
            return Ok(None);
        store.put_metadata(file_path, &index_ranges, &fetched_bytes);
/// - CI region = `min(start)..max(end)` over every column×RG `column_index` extent
    /// Get metadata cache size limit in bytes
        self.column_index_registered = true;
        let _g = crate::test_process_globals::lock();
    compute_parquet_statistics, compute_parquet_statistics_from_metadata,
                .get_ranges(&path, ranges)
                        version: None,
        let mut results = Vec::with_capacity(file_paths.len());
        if let Some(cache) = &self.statistics_cache {
        // and for OFFSET_INDEX too (both route to clear_scoped_cache)
                }
use datafusion::execution::cache::cache_manager::{
    /// Returns `Ok(None)` for non-parquet files.
                                            .map(|m| m.len())
        } else {
            )),
/// Returns up to two ranges (CI first, then OI), skipping whichever kind the file
                .map_err(|e| format!("Failed to update statistics cache limit: {:?}", e))
            datafusion::arrow::datatypes::SchemaRef,
        for rg in metadata.row_groups() {
                    results.push((file_path.clone(), success));
                self.file_metadata_cache
        let buf = parquet_bytes(3, 2, EnabledStatistics::Page);
    ///
        if let Some(stats_cache) = &self.statistics_cache {
        } else {
    pub fn add_files_with_store(
            error!(
    /// statistics without a second IO round-trip.
    }
            }
    let mut ranges = Vec::with_capacity(2);
            let default_stats = Arc::new(DefaultFileStatisticsCache::default());
        self.file_metadata_cache
                    (col.offset_index_offset(), col.offset_index_length())
    ranges
    /// Fetch footer only (no page indexes) from the store and put into heap cache.
        file_path: &str,
                    .map(|c| {
        let cache = self
    /// Get statistics cache entry count
        file_path: &str,
        store: &Arc<dyn MetadataCachingStore>,
            Ok(stats) => {
            Self::fetch_ranges_via_store(store, file_path, &index_ranges, rt_handle)?;
    fn warmup_file_with_store(
                let stats = page_index::column_index_cache_stats();
            .map(|cache| cache.hit_count())
                        Arc::new(Int64Array::from(vals)) as Arc<dyn arrow::array::Array>
            .map(|cache| cache.miss_count())
                Ok(None) => {
        // clear_cache_type must succeed for COLUMN_INDEX
    /// - Page indexes NOT stored in heap (avoids 1GB+ memory bloat on wide schemas).
            .set_write_batch_size(8)
        use parquet::file::properties::EnabledStatistics;
                }
            metadata_cache::CACHE_TYPE_COLUMN_INDEX | metadata_cache::CACHE_TYPE_OFFSET_INDEX => {
                Ok(page_index::offset_index_cache_stats().used_bytes)
        let cache = self
            }
    /// Update the statistics cache size limit
    /// read per file: `load_parquet_metadata` fetches the footer, caches it, and
        &self,
    };
                .update_size_limit(new_limit)
                            if cache_guard.remove(&path).is_some() {
            .build();
/// - OI region = `min(start)..max(end)` over every column×RG `offset_index` extent
        let store: Arc<dyn ObjectStore> = Arc::new(object_store::local::LocalFileSystem::new());
                false
) -> Vec<std::ops::Range<u64>> {
        assert!(mgr.offset_index_registered);
            .unwrap_or(0)
        native_bridge_common::log_debug!(
            w.close().unwrap();
            .map(|cache| cache.hit_rate())
            cache.clear();
            let mut errors = Vec::new();
        rt_handle: &tokio::runtime::Handle,
        }
        file_paths: &[String],
    fn set_column_index_cache_registers_and_sets_limit() {
    /// a dedicated synchronous thread. Integration tests use a separate OnceLock runtime.
        })?;
    pub fn metadata_cache_size_limit(&self) -> usize {
    }
        }
            metadata_cache::CACHE_TYPE_COLUMN_INDEX => {
            native_bridge_common::log_debug!(
    /// Fetch a parquet file's footer, warm the metadata cache, and return the
            for col in rg.columns() {
                } else {
                                    file_path
        }
    }
        }
                }
            }
    /// Check if a file exists in any cache
        let location = object_meta.location.clone();
        clear_scoped_cache_for_test();
            .as_ref()
        assert!(mgr.clear_cache_type(CACHE_TYPE_COLUMN_INDEX).is_ok());
    /// 3. Compute page/offset index byte ranges from the parsed footer; append the footer
                page_index::clear_scoped_cache();
        version: None,
    }
        clear_scoped_cache_for_test();
            object_meta.size,
 */
                }
                }
        // Check metadata cache
            let mut any_removed = false;
    /// Get memory consumed by specific cache type
            return Ok(true);
            if let Some(cache) = &self.file_metadata_cache {
                false
        let metadata_cache = self
    }
            .ok_or_else(|| "No file metadata cache configured".to_string())?;
        .row_groups()
    pub fn set_statistics_cache(&mut self, cache: Arc<CustomStatisticsCache>) {
                any_removed = true;
            size_limit
            }
        file_path: &str,
        parquet_metadata: &Arc<parquet::file::metadata::ParquetMetaData>,
                    .and_then(|cache| cache.get(&path))
        String,
        &self,
        {
            config = config.with_file_statistics_cache(Some(default_stats));
        // their own key makes that probe a warm hit.
                    });
            if cache.contains_key(&path) {
                        Ok(cache_guard) => {
        self.file_metadata_cache
                .await
            }
        );
    /// Register the column index cache with the given size limit.
        // Step 4: Fetch the ranges through the store (populates data Foyer on the way).
        let mut exp_oi: Option<std::ops::Range<u64>> = None;
    fn metadata_cache_put_returning_meta(
        let object_meta = rt_handle.block_on(async {
                    if let Some(stats_cache) = &self.statistics_cache {
                .map_err(|e| format!("Failed to fetch ranges for {}: {}", file_path, e))
        let path = Path::from(file_path.to_string());
                        Err(e) => {
pub(crate) fn compute_page_index_range(
        assert_eq!(
        assert_eq!(
        let metadata = reader.metadata();
                                    "[CACHE INFO] File not found in metadata cache: {}",
                if let Some(cache) = &self.file_metadata_cache {
                    None => Some(start..end),
                Ok(Some((schema, pq_meta))) => {
        .iter()
        rt_handle: &tokio::runtime::Handle,
        assert_eq!(column_index_cache_stats().limit_bytes, limit);
                }
        let mut expected: Vec<std::ops::Range<u64>> = Vec::new();
    ) -> Result<(Arc<parquet::file::metadata::ParquetMetaData>, ObjectMeta), String> {
/// Compute the page-index regions to warm, as SEPARATE column-index (CI) and
        // Check statistics cache
        use arrow::array::{Int64Array, RecordBatch};
    /// Used by [`Self::add_files`] (no-store flow) when the parquet lives on local fs
use std::sync::Arc;
        file_paths: &[String],
    /// Returns the parsed metadata and object meta (for file size).
            2,
            }
impl CustomCacheManager {
    pub fn metadata_cache_hit_count(&self) -> usize {
                            errors.push(format!("Metadata cache: Cache remove failed: {}", e));
        let reader = SerializedFileReader::new(buf).unwrap();
                        Err("Failed to lock metadata cache".to_string())
use crate::indexed_table::parquet_bridge;
    /// Check if a file exists in a specific cache type
            );
    pub fn get_memory_consumed_by_type(&self, cache_type: &str) -> Result<usize, String> {
    ) -> Result<bool, String> {
        // Heap holds the parsed `ParquetMetaData` for fast lookups; the metadata Foyer entry
        match cache_type {
/*
                    cache.clear();
                found = true;
            .map_err(|e| format!("failed to derive arrow schema for {}: {}", file_path, e))?,
        clear_scoped_cache_for_test();
        crate::cache::page_index::set_offset_index_cache_limit(size_limit);
        mgr.set_column_index_cache(16 * 1024 * 1024);
        mgr.set_column_index_cache(16 * 1024 * 1024);
                .map_or(false, |cache| cache.contains_key(&Path::from(file_path))),
/// CI∪OI range. The query probes the CI whole region and the OI whole region
    /// Panics if called from within a tokio async context (uses `block_on`).
                    Some(a) => Some(a.start.min(start)..a.end.max(end)),
            } else {
    /// Reset metadata cache stats
    /// Set the file metadata cache
            }
    /// cache is warmed, so we avoid re-fetching the footer through the store
                    }
    /// [`Self::statistics_cache_put_from_parsed`], which reuses already-parsed
    #[test]
                    .await
    pub fn new() -> Self {
                // worth it for a boolean check; callers use this for diagnostics only.
            .ok_or_else(|| "No statistics cache configured".to_string())?;
                {
                let batch = RecordBatch::try_new(schema.clone(), cols).unwrap();
        }
        let limit = 32 * 1024 * 1024; // 32 MB
        // footer-metadata length + "PAR1" magic) to learn the footer length. On an
        clear_scoped_cache_for_test();
                    );
        mgr.set_column_index_cache(limit);
            exp_oi,
                stats_cache.clone() as Arc<dyn FileStatisticsCache>
            .ok_or_else(|| "No statistics cache configured".to_string())?;
use crate::cache::metadata_cache::MutexFileMetadataCache;
                    .is_some()
        // Calling remove_files on a non-existent file must not panic.
        let mut mgr = CustomCacheManager::new();
                    any_removed = true;
        // which loads page indexes into the heap struct. Instead, load footer only
    column_index_registered: bool,
    }
                }
        // Step 1: Fetch footer only → heap cache (parsed ParquetMetaData)
                                Ok(stats) => {
                cache.put_statistics(&path, Arc::new(stats), &meta);
            ci, oi,
        let _g = crate::test_process_globals::lock();
                                            .unwrap_or(0),
    ) -> Result<usize, String> {
        }
    /// Warmup a single file
    pub fn statistics_cache_reset_stats(&self) {
            let mut any_success = false;
        log_debug!(
        let parquet_metadata: Arc<parquet::file::metadata::ParquetMetaData> =
    /// Footer metadata and statistics are derived from a **single** object-store
            return Ok(true);
        let path = Path::from(file_path.to_string());
        log_debug!(
    /// Remove multiple files from all caches
        self.offset_index_registered = true;
            if let Some(cache) = &self.statistics_cache {
        use parquet::file::serialized_reader::SerializedFileReader;
    pub fn statistics_cache_hit_rate(&self) -> f64 {
                let path = Path::from(file_path.clone());
        self.statistics_cache_compute_and_put(file_path)
    }
        let schema = Arc::new(
                let start = offset as u64;
            .as_ref()
            store
    use datafusion::common::DataFusionError;
    pub fn contains_file(&self, file_path: &str) -> bool {
    })?;
    }
                // with entries > 0. A per-file lookup requires iterating DashMap — not
        }
                .unwrap(),
        // is the SSD-served re-parse path when the heap evicts under memory pressure.
            column_index_registered: false,
    /// Set the statistics cache
    /// For warm shards (data on the per-shard remote store) the equivalent helper is
        let metadata_cache = cache_ref.clone() as Arc<dyn FileMetadataCache>;
        );
            .map(|cache| <MutexFileMetadataCache as CacheAccessor<_, _>>::len(cache))
            0
        Option<(
        // NOTE: this now returns SEPARATE CI and OI whole regions (up to 2 ranges),
            }
    }
                .statistics_cache
            Arc::new(CachedParquetMetaData::new(Arc::clone(&parquet_metadata))),
        let (ci, oi) = (ranges[0].clone(), ranges[1].clone());
                file_path, e
    ///   the fast path; the metadata-Foyer footer is the heap-eviction safety net (served from
            .as_ref()
                    if let Ok(cache_guard) = cache.inner.lock() {
            // so statistics can be derived without a second IO round-trip.
                    Ok(())
        Ok(true)
    ///
        self.statistics_cache
            statistics_cache: None,
    /// Warm-tier statistics warmer: derive statistics from already-parsed
            "[CACHE INFO] Offset index cache registered (limit={} bytes)",
}
}
        }
                    exp_oi = Some(match exp_oi {
    if let Some(r) = oi_region {
        Ok(results)
                        }
                    exp_oi = Some(match exp_oi {
        let cache = match self.statistics_cache.as_ref() {
    }
        let path = Path::from(file_path.to_string());
            .unwrap_or(0.0)
        if let Some(cache) = &self.file_metadata_cache {
        num_rg: usize,
                // we match by prefix; check via evict-probe is heavy so we approximate
                // CI is keyed by (file, col) — a file is "present" if entries > 0 and
                    version: None,
        if let Some(cache) = &self.file_metadata_cache {
            let success = if !errors.is_empty() && !any_success {
    }
    /// Write an in-memory parquet file and return its raw bytes. `stats` controls
            }
                }
                let start = offset as u64;
    /// Get or compute statistics
        index_ranges.push(footer_start..object_meta.size);
                Ok(true)
            }
                Err(e) => {
        let object_metas = create_object_meta_from_file(file_path)
                .with_metadata_cache_limit(cache.cache_limit());
            .ok_or_else(|| "No object metadata returned".to_string())?;
                if cache.get(&path).is_some() {
        Ok(results)
    }
        .flat_map(|rg| rg.columns().iter())
#[cfg(test)]
    /// Get metadata cache hit count
    ///
                Ok(page_index::column_index_cache_stats().used_bytes)
        }
                .map_err(|e| format!("Failed to head {}: {}", file_path, e))
        assert!(oi.end > oi.start, "OI region must be non-empty");
    /// Batch compute and cache statistics for multiple files
                }
        let mut exp_oi: Option<std::ops::Range<u64>> = None;
        let path = Path::from(file_path.to_string());
            .unwrap_or(0)
                let stats = page_index::offset_index_cache_stats();
            Arc<datafusion::parquet::file::metadata::ParquetMetaData>,
            results.push((file_path.clone(), success));
use datafusion::execution::cache::file_statistics_cache::DefaultFileStatisticsCache;
                }
        );
/// under separate keys, so a single merged key would never match (warm miss).
            .first()
    pub fn set_column_index_cache(&mut self, size_limit: usize) {
    }
        let _g = crate::test_process_globals::lock();
                    );
    /// 4. Fetch those ranges through the store (populates **data Foyer** as a side effect of get_ranges)
            {
            for col in rg.columns() {
    }
    }
            for rg in 0..num_rg {
                        file_path, e
        if ranges.is_empty() {
            "[CACHE INFO] Column index cache registered (limit={} bytes)",
            }
        file_paths: &[String],
        // Column index requires page-level statistics; with stats disabled it must be absent.
            size_limit
    /// Compute and put statistics into cache (hot path — reads the local file)
        let cache_ref = self
                if let (Some(off), Some(len)) =
            file_path,
    /// subsequent query lookups validate cleanly via `is_valid_for`.
                "[STATS CACHE WARNING] Failed to compute statistics for {} files: {:?}",
        self.statistics_cache
    /// Get the statistics cache
        if cache.get(&path).is_some() {
        store: &Arc<dyn MetadataCachingStore>,
        // Compute statistics
            let path = Path::from(file_path.clone());
fn create_object_meta_from_file(
            cache.reset_stats();
        // Put lightweight footer-only metadata into heap cache
    }
        })?;
    }
                            } else {
            file_path, e
        let props = WriterProperties::builder()
    }
        // On empty cache both return 0 bytes (no entries yet).
                    });
            "CI and OI must be distinct warm-tier keys (not merged)"
            .as_ref()
            }
                    }
    }
        }
        }
        location: Path::from(file_path),
            crate::cache::metadata_cache::CACHE_TYPE_STATS => self
            .set_max_row_group_size(32)
        file_path: &str,
                    found = true;
            mgr.get_memory_consumed_by_type(CACHE_TYPE_COLUMN_INDEX)
        use parquet::file::reader::FileReader;
            Some(ci),
    /// Build a CacheManagerConfig from the caches stored in this CustomCacheManager
    fn fetch_footer_to_heap(
                let end = start + length as u64;
    #[test]
        let cache = self
        clear_scoped_cache_for_test();
    /// 1. Fetch footer only (PageIndexPolicy::Skip) → heap cache (lightweight parsed metadata)
    > {
        let mut mgr = CustomCacheManager::new();
            Some(c) => c,
                    location: path.clone(),
                success_count += 1;
                stats.entries > 0
        Ok(success_count)
};
use crate::cache::statistics_cache::CustomStatisticsCache;
                "[warmup::warmup_file_with_store] statistics_cache_put failed for {}: {} (non-fatal)",
    }
            if let Ok(cache_guard) = cache.inner.lock() {
                let meta = ObjectMeta {
        let mut index_ranges = compute_page_index_range(&parquet_metadata);
            "OI region must equal the tight min..max fold of all offset_index extents"
        let mut results = Vec::new();
                                log_debug!(
                    results.push((file_path.clone(), false));
        );
                        file_path
            Err("No statistics cache configured".to_string())
            cache.clear();
                    (col.offset_index_offset(), col.offset_index_length())
            results.push((file_path.clone(), removed));
    pub fn add_files(
        // CI∪OI range would never match the query's per-kind probes (warm miss).
            .as_ref()
            use object_store::ObjectStoreExt;
            .ok_or_else(|| "No statistics cache configured".to_string())?;
        // Add file metadata cache if available
        let _g = crate::test_process_globals::lock();
    let file_size = metadata.len();
        }
        object_meta: &ObjectMeta,
        store: &Arc<dyn MetadataCachingStore>,
        );
                                    let meta = ObjectMeta {
    /// Get metadata cache miss count
                    Err("No metadata cache configured".to_string())
        assert_eq!(offset_index_cache_stats().limit_bytes, limit);
    fn remove_files_evicts_scoped_cache_when_registered() {
    }
            .unwrap_or(0)
            return Ok(vec![]);
            .statistics_cache
        Ok(Some((schema, pq_meta)))
            metadata_cache::CACHE_TYPE_METADATA => {
            expected,
        metadata_cache.put(&path, cached_entry);
        rt_handle: &tokio::runtime::Handle,
                let path = Path::from(file_path);
                    match cache.inner.lock() {
        if let Some(r) = exp_ci.clone() {
        });
    let object_meta = ObjectMeta {
            .map_err(|e| format!("Failed to get object metadata: {}", e))?;
    fn compute_page_index_range_returns_tight_ci_and_oi_regions() {
        assert!(!mgr.offset_index_registered);
    metadata: &parquet::file::metadata::ParquetMetaData,
    /// Get statistics cache size limit in bytes
        &self,
        use datafusion::execution::cache::CacheAccessor;
            metadata_cache::CACHE_TYPE_STATS => {
            metadata_cache::CACHE_TYPE_OFFSET_INDEX => {
        clear_scoped_cache_for_test();
            cache
    /// Update the file metadata cache size limit
}
            compute_page_index_range(metadata),
            0
        self.statistics_cache
            self.statistics_cache_put_from_parsed(file_path, &parquet_metadata, &object_meta)
            metadata_cache::CACHE_TYPE_COLUMN_INDEX => {
        .map(|t| DateTime::<Utc>::from(t))
        if let Some(cache) = &self.statistics_cache {
                }
            .set_statistics_enabled(stats)
        // DataFusion's FIRST footer read is an 8-byte read of the postscript (4-byte
            .as_ref()
        let buf = parquet_bytes(2, 1, EnabledStatistics::None);
        ranges.push(r);
}
        // Reuses `parquet_metadata` so we don't re-fetch through the store. Failures
    file_path: &str,
                file_metadata.schema_descr(),
        size: file_size,
            config = config.with_file_statistics_cache(Some(
        Self {
        rt_handle: &tokio::runtime::Handle,
    Ok(vec![object_meta])
        Ok(results)
    /// through the store (for Foyer caching), and promote those ranges to the
        cache.put_statistics(&path, Arc::new(stats), object_meta);
        let postscript_start = object_meta.size.saturating_sub(8);
            // Single footer fetch — warms metadata cache and returns the decoded metadata
        let mut found = false;
    pub fn get_statistics_cache(&self) -> Option<Arc<CustomStatisticsCache>> {
    use super::*;
        clear_scoped_cache_for_test();
        if let Some(r) = exp_oi {
 * this file be licensed under the Apache-2.0 license or a
                    (col.column_index_offset(), col.column_index_length())
        })
        if self.column_index_registered || self.offset_index_registered {
            _ => false,
            total += cache.memory_consumed();
        );
        self.statistics_cache
    /// returns `(schema, ParquetMetaData)`. Statistics are then computed from that
            .as_ref()
                    None => Some(start..end),
    ) -> Result<Vec<(String, bool)>, String> {
        }
            "result must equal the independent [CI?, OI?] fold, skipping absent index kinds"
    let modified = metadata
        let (parquet_metadata, object_meta) =
                    let (s, e) = (off as u64, off as u64 + len as u64);
};
            .as_ref()
    ) -> Result<Vec<bytes::Bytes>, String> {
    /// With page statistics disabled the column index is absent (it requires
            "[warm-tier] warmed file='{}' size={} promoted {} metadata ranges ({} bytes)",
        let meta = object_meta.clone();
    // Offset-index whole region across all columns × all row groups.
        ))
        file_path: &str,
            .file_metadata_cache
                let path = Path::from(file_path.clone());
            .set_data_page_row_count_limit(8)
        mgr.set_column_index_cache(16 * 1024 * 1024);
            {
) -> Result<Vec<ObjectMeta>, datafusion::common::DataFusionError> {
        // No-op when `store` is not a TieredObjectStore (default trait impl is no-op).
    }
        if !file_path.to_lowercase().ends_with(".parquet") {
            .as_ref()
    ///
                                }
                .await
            }
    CacheManagerConfig, FileMetadataCache, FileStatisticsCache,
                    errors.push("No metadata cache configured".to_string());
        let cached_entry = CachedFileMetadataEntry::new(
                w.write(&batch).unwrap();
                } else {
    }
        self.statistics_cache
        mgr.set_offset_index_cache(32 * 1024 * 1024);
                }
            index_ranges.len(),
            let mut w = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
                } else {
            }
                        file_path,
        }
    }
                    failed_files.push(file_path.clone());
        if let Some(cache) = &self.file_metadata_cache {
            .statistics_cache
                    } else {
                    .as_ref()
        clear_scoped_cache_for_test();
/// IMPORTANT: warmup must write these as TWO keys (CI, OI) — NOT one merged
            store
        use parquet::file::serialized_reader::SerializedFileReader;
        Ok((parquet_metadata, object_meta))
        }
        });
        // Add statistics cache memory
    /// (which is a remote-IO call on warm shards). Returns `Ok(true)` on insert,
    if let Some(r) = ci_region {
            metadata_cache::CACHE_TYPE_OFFSET_INDEX => {
            }
        log_debug!("[CACHE INFO] Statistics cache set in CustomCacheManager");
            let mut errors = Vec::new();
        match compute_parquet_statistics(file_path) {
                                );
                    log_debug!(
                failed_files.len(),
        &self,
    /// # Panics
    let metadata = std::fs::metadata(file_path).map_err(|e| {
    }
        use datafusion::parquet::arrow::parquet_to_arrow_schema;
                                        e_tag: None,
    /// Get total memory consumed by all caches
                }
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
        mgr.set_column_index_cache(16 * 1024 * 1024);
    ///   (never-evict SSD tier) via `store.put_metadata(...)`. The parsed footer in heap is
        num_cols: usize,
///
        // Add metadata cache memory
                    size: std::fs::metadata(file_path).map(|m| m.len()).unwrap_or(0),
                if let (Some(off), Some(len)) =
            index_ranges.iter().map(|r| r.end - r.start).sum::<u64>()
                            }
        for file_path in file_paths {
    /// Get the file metadata cache as Arc<dyn FileMetadataCache> for DataFusion
        crate::cache::page_index::set_column_index_cache_limit(size_limit);
        Ok(true)
                    Some(a) => Some(a.start.min(start)..a.end.max(end)),
            config = config
        {
            }
        assert!(mgr.clear_cache_type(CACHE_TYPE_OFFSET_INDEX).is_ok());
        clear_scoped_cache_for_test();
    fn clear_all_clears_scoped_cache_when_registered() {
    ) -> bytes::Bytes {
            "Failed to get file metadata for {}: {}",
                    Err("No statistics cache configured".to_string())
        rt_handle: &tokio::runtime::Handle,
            match self.warmup_file_with_store(file_path, &store, rt_handle) {
        found
    pub fn get_file_metadata_cache_for_datafusion(&self) -> Option<Arc<dyn FileMetadataCache>> {
}
        .modified()
        if let Some(cache) = self.get_file_metadata_cache_for_datafusion() {
    ) -> Result<Vec<(String, bool)>, String> {
    }
        }
                .head(&path)
                    let (s, e) = (off as u64, off as u64 + len as u64);
                        let path = Path::from(file_path.as_str());
 * compatible open source license.
            }
            return Ok(false);
        for rg in metadata.row_groups() {
                    );
    /// [`parquet::file::metadata::ParquetMetaData`] and put them into the statistics
    /// Clear specific cache type
    #[test]
                        if !stats_cache.contains_key(&path) {
    use crate::cache::{CACHE_TYPE_COLUMN_INDEX, CACHE_TYPE_OFFSET_INDEX};
        );
                {
        if let Some(cache) = &self.statistics_cache {
    }
                file_metadata.key_value_metadata(),
        );
                    last_modified: chrono::Utc::now(),
                let base = (rg * 100) as i64;
        let (schema, _size, pq_meta) = rt_handle.block_on(async {
        rt_handle.block_on(async {
        mgr.set_offset_index_cache(32 * 1024 * 1024);
    statistics_cache: Option<Arc<CustomStatisticsCache>>,
                        Some(a) => a.start.min(s)..a.end.max(e),
///
    pub fn statistics_cache_batch_compute_and_put(
        assert_eq!(
            if self.column_index_registered || self.offset_index_registered {
        &self,
        if let Some(cache) = &self.file_metadata_cache {
        let footer_prefetch = 64 * 1024u64; // matches DataFusion's DEFAULT_FOOTER_READ_SIZE
        let stats = DFParquetMetadata::statistics_from_parquet_metadata(parquet_metadata, &schema)
        let mut mgr = CustomCacheManager::new();
            metadata_cache::CACHE_TYPE_STATS => {
    /// decoded `(SchemaRef, Arc<ParquetMetaData>)` so the caller can derive
            }
        if cache.contains_key(&path) {
            .as_ref()
    pub fn metadata_cache_miss_count(&self) -> usize {
    /// Add multiple files to all applicable caches.
                    native_bridge_common::log_debug!(
        let mut mgr = CustomCacheManager::new();
                    }
        // Compute the expected tight folds independently and compare.
                (col.offset_index_offset(), col.offset_index_length())
use crate::cache::{metadata_cache, page_index};
/// lacks. Returns an empty Vec if the file has no page index at all.
                {
        }
        for file_path in file_paths {
            }
            } else {
use datafusion::datasource::physical_plan::parquet::metadata::DFParquetMetadata;
    /// Get metadata cache entry count
            cache.update_cache_limit(new_limit);
                Err(e) => {
    }
                any_success
            // Remove from metadata cache
                if let (Some(off), Some(len)) =
                }
        self.file_metadata_cache
        clear_scoped_cache_for_test, column_index_cache_stats, offset_index_cache_stats,
        let mut config = CacheManagerConfig::default();
            crate::cache::metadata_cache::CACHE_TYPE_METADATA => {
    pub fn statistics_cache_compute_and_put(&self, file_path: &str) -> Result<bool, String> {
    ) -> Result<
    /// Clear all caches
    /// kinds — which exercises the "one kind present" branch.
                any_removed
            .unwrap_or(0)
            ranges.len(),
        )>,
        // and manually put into the heap cache afterward.
        let mut failed_files = Vec::new();
                {
    /// Reset statistics cache stats
                let df_metadata = DFParquetMetadata::new(store.as_ref(), &object_meta);
        self.file_metadata_cache
        clear_scoped_cache_for_test();
    ///
            };
                if let Some(cache) = &self.file_metadata_cache {
                            }
    #[test]
    pub fn set_file_metadata_cache(&mut self, cache: Arc<MutexFileMetadataCache>) {
    pub fn set_offset_index_cache(&mut self, size_limit: usize) {
                    (col.column_index_offset(), col.column_index_length())
/// offset-index (OI) whole regions — matching exactly how the query-time
                    };
    /// 2. Derive statistics from the same parsed metadata → statistics cache
        use parquet::arrow::ArrowWriter;
        use parquet::file::properties::EnabledStatistics;
            match compute_parquet_statistics(file_path) {
                    });
        );
                    exp_ci = Some(match exp_ci {
        }
    }
    }
    /// region first, then the offset-index (OI) whole region — and each region is the
            parquet_to_arrow_schema(
        assert_ne!(
    }
    #[test]
    /// Get statistics cache miss count
    /// Sets the limit on the process-global `COLUMN_INDEX_CACHE` singleton.
                        "[STATS CACHE ERROR] Failed to compute statistics for {}: {}",
                if let Some(cache) = &self.file_metadata_cache {
    pub fn statistics_cache_entry_count(&self) -> usize {
                Ok(())
/// whole-region fetch (`page_index/page_index_io.rs::whole_index_region`) computes
    }
                    errors.push(format!("Metadata cache: {}", e));
    /// `Ok(false)` if the statistics cache is not configured or the file is
            self.fetch_footer_to_heap(file_path, store, rt_handle)?;
        }
            if cache.contains_key(&path) {
    /// Must be called from FFM entry points (Java → Rust, non-async) or from
        }
    /// already cached, `Err(_)` on schema/derivation failure.
/// Each region folds ALL columns across ALL row groups for that one index kind:
        &self,
                }
    fn set_offset_index_cache_registers_and_sets_limit() {
    /// Warmup: load footer (lightweight) into heap, fetch page/offset index bytes
    }
use datafusion::execution::cache::CacheAccessor;
    ) -> Result<bool, String> {
        use datafusion::datasource::physical_plan::parquet::metadata::CachedParquetMetaData;
        bytes::Bytes::from(buf)
                stats.entries > 0
                match acc {
use object_store::ObjectMeta;
    // Column-index whole region across all columns × all row groups.
                                    errors.push(format!("Statistics cache: {}", e));
                        size: std::fs::metadata(file_path).map(|m| m.len()).unwrap_or(0),
                                    };
                }
    /// `ParquetMetaData` from the warmup pass instead of opening the file locally
        // here are non-fatal — they only mean the first query will recompute statistics.
        // Add statistics cache if available - use CustomStatisticsCache directly
        let mut buf: Vec<u8> = Vec::new();
                                        size: std::fs::metadata(file_path)
                }
    /// metadata Foyer tier via `MetadataCachingStore::put_metadata`.
        .fold(None::<std::ops::Range<u64>>, |acc, col| {
        clear_scoped_cache_for_test();
                if cache.remove(&path).is_some() {
            rt_handle.block_on(async {
                acc
        .unwrap_or_else(|_| Utc::now());
                if let Some(cache) = &self.statistics_cache {
    pub fn update_statistics_cache_limit(&self, new_limit: usize) -> Result<(), String> {
            .unwrap_or(0)
use native_bridge_common::log_debug;
                file_path, e
        // Head call to get file size (TieredObjectStore serves from registry)
            .as_ref()
        }
            )
        }
    #[test]
                    return false;
        // Also promote the footer (last 64 KB) to metadata Foyer — heap-eviction safety net.
                            (base..base + 40).map(|v| v + (c as i64 * 1000)).collect();
                        Some(a) => a.start.min(s)..a.end.max(e),
        }
        assert!(!mgr.column_index_registered);
    pub fn statistics_cache_get_or_compute(&self, file_path: &str) -> Result<bool, String> {
                match acc {
        clear_scoped_cache_for_test();
        &self,
                Ok(stats) => {
        self.statistics_cache.clone()
                        last_modified: chrono::Utc::now(),
    /// - Footer (schema + RG stats) → heap file_metadata_cache (parsed `ParquetMetaData`, fast path)
            return Ok(false);
        let object_meta = object_metas
                    let (s, e) = (off as u64, off as u64 + len as u64);
            .map(|cache| cache.hit_count())
    }
use crate::cache::statistics_cache::{
        let footer_start = object_meta.size.saturating_sub(footer_prefetch);
    }
                                any_removed = true;
    /// Sets the limit on the process-global `OFFSET_INDEX_CACHE` singleton.
        {
                }
        let mut exp_ci: Option<std::ops::Range<u64>> = None;
    ///
        assert!(ci.end > ci.start, "CI region must be non-empty");
mod tests {
            "CI region must equal the tight min..max fold of all column_index extents"
        .fold(None::<std::ops::Range<u64>>, |acc, col| {
    /// tight min..max fold over the corresponding per-column extents in the footer.
        let limit = 16 * 1024 * 1024; // 16 MB
    file_metadata_cache: Option<Arc<MutexFileMetadataCache>>,
        DataFusionError::Execution(format!(
    fn compute_page_index_range_matches_independent_fold_no_page_stats() {
            match self.metadata_cache_put_returning_meta(file_path, rt_handle) {
                if !self.offset_index_registered {
        let ranges = compute_page_index_range(metadata);
                                }
/// Custom CacheManager that holds cache references directly
                if let (Some(off), Some(len)) =
        let mut exp_ci: Option<std::ops::Range<u64>> = None;
                    })
    fn fetch_ranges_via_store(
    /// A page-indexed file yields exactly TWO regions — the column-index (CI) whole
            .clone() as Arc<dyn FileMetadataCache>;
        let file_metadata = parquet_metadata.file_metadata();
        use datafusion::execution::cache::cache_manager::CachedFileMetadataEntry;
                .unwrap(),
                    e_tag: None,
                acc
        }
            None => return Ok(false),
    /// function must equal the independent `[CI?, OI?]` fold — skipping absent
    /// Fetch byte ranges from the store. Returns the fetched bytes in order.
    ///
        assert_eq!(
    pub fn build_cache_manager_config(&self) -> CacheManagerConfig {
    ///   SSD instead of S3 on cold-path re-parse).
        for file_path in file_paths {
                                Err(e) => {
            .as_ref()
                        None => s..e,
        assert_eq!(
            .unwrap_or(0)
                        location: path.clone(),
    pub fn statistics_cache_hit_count(&self) -> usize {
            if let (Some(offset), Some(length)) =
                Ok(success) => {
        .flat_map(|rg| rg.columns().iter())
        let _g = crate::test_process_globals::lock();
                Err(e) => {
        assert_eq!(
            .unwrap_or(0)
                page_index::evict_file_from_scoped_cache(file_path);
            .file_metadata_cache
                if !self.column_index_registered {
                    Ok(())
        match cache_type {
        }
    fn statistics_cache_put_from_parsed(
            .collect();
    /// 5. Promote those ranges to **metadata Foyer** (never-evict tier) via `store.put_metadata`
                continue;
        if !file_path.to_lowercase().ends_with(".parquet") {
                    Err("No metadata cache configured".to_string())
            } else {
    }
            "page-indexed file must yield separate CI and OI regions"
        // Step 5: Promote bytes to metadata Foyer (never-evict tier).
        last_modified: modified,
            .as_ref()
        let result = mgr.remove_files(&["/nonexistent/file.parquet".to_string()]);
        let path = Path::from(file_path.to_string());
/// and probes them.
        if let Some(cache) = &self.statistics_cache {
            // Evict from scoped page-index caches (CI + OI) by file prefix
        // Step 3: Compute page/offset index byte ranges from the parsed footer.
            .map(|cache| <CustomStatisticsCache as CacheAccessor<_, _>>::len(cache))
                total += cache_guard.memory_used();
            _ => Err(format!("Unknown cache type: {}", cache_type)),
    /// Called from [`Self::warmup_file_with_store`] right after the heap metadata
                        None => s..e,
                            match compute_parquet_statistics_from_metadata(&pq_meta, &schema) {
                    cache.clear();
            }
            cache.reset_stats();
            metadata_cache::CACHE_TYPE_METADATA => {
        self.file_metadata_cache = Some(cache);
        ranges: &[std::ops::Range<u64>],
                    return false;
            ));
    pub fn metadata_cache_reset_stats(&self) {
        let mut mgr = CustomCacheManager::new();
            .map(|cache| cache.current_size_limit())
            Err(e) => Err(format!(
    fn get_memory_consumed_by_type_returns_scoped_stats() {
                    });
        );
                let end = start + length as u64;
        );
                }
///
            .map_err(|e| format!("failed to compute statistics for {}: {}", file_path, e))?;
pub struct CustomCacheManager {
    fn clear_cache_type_column_index_clears_scoped_cache() {
                    // Derive statistics from the already-loaded metadata — no second read.
            }
                df_metadata
            object_meta.clone(),
    pub fn get_total_memory_consumed(&self) -> usize {
            // Default statistics cache if none set
            };
            .unwrap_or(0)
        stats: parquet::file::properties::EnabledStatistics,
                    cache.put_statistics(&path, Arc::new(stats), &meta);
        }
                        let vals: Vec<i64> =
                                        location: path.clone(),
    let ci_region = metadata
    pub fn metadata_cache_entry_count(&self) -> usize {
    }
    };
    /// cache, reusing the same [`ObjectMeta`] the heap metadata cache used so
                                        version: None,
        let metadata = reader.metadata();
        .iter()
                .await
    /// already-decoded metadata — avoiding a second file read.
        rt_handle: &tokio::runtime::Handle,
            exp_ci,
        mgr.set_offset_index_cache(limit);
                } else {
use object_store::ObjectStore;
                        Some(a) => a.start.min(s)..a.end.max(e),
        // Also promote the exact last-8-byte postscript [size-8, size] to metadata Foyer.
            .map(|cache| cache.get_cache_limit())
                        "[CACHE ERROR] add_files_with_store failed for {}: {}",
        // Step 2: Derive statistics from the same parsed metadata → statistics cache.
        let mut results = Vec::new();
    /// Register the offset index cache with the given size limit.
    pub fn clear_all(&self) {
        log_debug!("[CACHE INFO] File metadata cache set in CustomCacheManager");
            .map(|c| Field::new(format!("col_{}", c), DataType::Int64, false))
            if let (Some(offset), Some(length)) =
        }
                        e
            }
        let fetched_bytes =
    pub fn contains_file_by_type(&self, file_path: &str, cache_type: &str) -> bool {
            parquet_bridge::load_parquet_metadata_with_meta(store, &location, meta, metadata_cache)
                    success_count += 1;
                        "[CACHE INFO] File not added for metadata cache: {}",
    #[test]
        index_ranges.push(postscript_start..object_meta.size);
                .with_file_metadata_cache(Some(cache.clone()))
use log::{debug, error};
    /// page-level stats), though the writer may still emit an offset index. The
                if let Some(cache) = &self.statistics_cache {
    }
            mgr.get_memory_consumed_by_type(CACHE_TYPE_OFFSET_INDEX)
                (col.column_index_offset(), col.column_index_length())
        let fields: Vec<Field> = (0..num_cols)
    pub fn remove_files(&self, file_paths: &[String]) -> Result<Vec<(String, bool)>, String> {
                    Err("No statistics cache configured".to_string())
        }
            _ => Err(format!("Unknown cache type: {}", cache_type)),
        }
                        Ok(cache_guard.memory_used())
        }
                    let (s, e) = (off as u64, off as u64 + len as u64);
    pub fn clear_cache_type(&self, cache_type: &str) -> Result<(), String> {
            }
                        None => s..e,
    pub fn statistics_cache_size_limit(&self) -> usize {
                    .fetch_metadata()
            Some(oi),
        mgr.clear_all();
    }
            } else {
        }
                        None => s..e,
            // Remove from statistics cache
use opensearch_tiered_storage::tiered_object_store::MetadataCachingStore;
        // Do NOT pass file_metadata_cache here — that triggers PageIndexPolicy::Optional
                    exp_ci = Some(match exp_ci {
            }
    /// - Footer raw bytes (last 64 KB) + page-index bytes → **promoted to metadata Foyer**
                } else {
        config
                    Ok(cache.memory_consumed())
            let path = Path::from(file_path);
    }
