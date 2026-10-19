    use crate::cache::page_index::{
                .with_file_metadata_cache(Some(cache.clone()))
        // is the SSD-served re-parse path when the heap evicts under memory pressure.
        use parquet::file::properties::EnabledStatistics;
        } else {
        );
/*
            }
            return Ok(true);
        // Step 2: Derive statistics from the same parsed metadata → statistics cache.
        for file_path in file_paths {
        // Check if already cached
    /// [`Self::statistics_cache_put_from_parsed`], which reuses already-parsed
    // ── compute_page_index_range ──────────────────────────────────────────────
    }
        version: None,
        let fetched_bytes =
    /// Get statistics cache size limit in bytes
        }
        if let Some(cache) = &self.file_metadata_cache {
        let _g = crate::test_process_globals::lock();
            }
    }
                }
    }
        }
        let metadata = reader.metadata();
    ) -> Result<Vec<bytes::Bytes>, String> {
    }
    }
        self.file_metadata_cache
            "[warm-tier] warmed file='{}' size={} promoted {} metadata ranges ({} bytes)",
    }
            _ => false,
        Ok(success_count)
            }
impl CustomCacheManager {
        rt_handle.block_on(async {
            // Default statistics cache if none set
                    Ok(())
            }
                    results.push((file_path.clone(), success));
    /// Fetch byte ranges from the store. Returns the fetched bytes in order.
        clear_scoped_cache_for_test();
            _ => Err(format!("Unknown cache type: {}", cache_type)),
                .update_size_limit(new_limit)
            object_meta.clone(),
            .unwrap_or(0)
            if let Ok(cache_guard) = cache.inner.lock() {
                        }
        self.file_metadata_cache
            }
                if let Some(cache) = &self.statistics_cache {
                }
    /// read per file: `load_parquet_metadata` fetches the footer, caches it, and
        }
        // here are non-fatal — they only mean the first query will recompute statistics.
    /// Write an in-memory parquet file and return its raw bytes. `stats` controls
        })
        use parquet::arrow::ArrowWriter;
    /// Warmup: load footer (lightweight) into heap, fetch page/offset index bytes
        let mut expected: Vec<std::ops::Range<u64>> = Vec::new();
            let mut any_success = false;
            file_metadata_cache: None,
        .flat_map(|rg| rg.columns().iter())
        clear_scoped_cache_for_test();
        store: &Arc<dyn MetadataCachingStore>,
                Ok(None) => {
        let mut failed_files = Vec::new();
    #[test]
                    found = true;
        if let Some(cache) = &self.statistics_cache {
    /// Get statistics cache hit rate
        // metadata read always misses the warm tier. Promoting the exact 8 bytes under
            "Failed to get file metadata for {}: {}",
            .file_metadata_cache
    /// region first, then the offset-index (OI) whole region — and each region is the
        let mut config = CacheManagerConfig::default();
                        "[STATS CACHE ERROR] Failed to compute statistics for {}: {}",
        rt_handle: &tokio::runtime::Handle,
        let postscript_start = object_meta.size.saturating_sub(8);
                    .fetch_metadata()
    /// Get memory consumed by specific cache type
    /// Register the column index cache with the given size limit.
            file_path,
                .with_metadata_cache_limit(cache.cache_limit());
                let cols: Vec<Arc<dyn arrow::array::Array>> = (0..num_cols)
    /// returns `(schema, ParquetMetaData)`. Statistics are then computed from that
            .map_err(|e| format!("Failed to get object metadata: {}", e))?;
                    success_count += 1;
        // Add file metadata cache if available
/// Each region folds ALL columns across ALL row groups for that one index kind:
                        Some(a) => a.start.min(s)..a.end.max(e),
    /// already-decoded metadata — avoiding a second file read.
    /// a dedicated synchronous thread. Integration tests use a separate OnceLock runtime.
            index_ranges.iter().map(|r| r.end - r.start).sum::<u64>()
        let mut found = false;
            .as_ref()
                };
            let path = Path::from(file_path);
                let path = Path::from(file_path.clone());
        }
                    location: path.clone(),
        );
            .map(|cache| <MutexFileMetadataCache as CacheAccessor<_, _>>::len(cache))
        for rg in metadata.row_groups() {
        // CI∪OI range would never match the query's per-kind probes (warm miss).
            size_limit
        }
            return Ok(false);
                }
                .map_or(false, |cache| cache.contains_key(&Path::from(file_path))),
            exp_oi,
            let path = Path::from(file_path.clone());
            datafusion::arrow::datatypes::SchemaRef,
                    exp_oi = Some(match exp_oi {
            .as_ref()
            exp_ci.is_none(),
    let mut ranges = Vec::with_capacity(2);
        Ok(true)
            expected.push(r);
                            } else {
    /// Register the offset index cache with the given size limit.
                    let (s, e) = (off as u64, off as u64 + len as u64);
    /// cache is warmed, so we avoid re-fetching the footer through the store
            store
pub(crate) fn compute_page_index_range(
        if let Some(cache) = &self.file_metadata_cache {
            .as_ref()
        store: &Arc<dyn MetadataCachingStore>,
    /// Warm-tier statistics warmer: derive statistics from already-parsed
            .as_ref()
use std::sync::Arc;
                    .and_then(|cache| cache.get(&path))
        assert_eq!(offset_index_cache_stats().limit_bytes, limit);
    /// page-level stats), though the writer may still emit an offset index. The
    }
        let mut results = Vec::new();
    }
    }
                    Err("No statistics cache configured".to_string())
                any_removed = true;
    ///   SSD instead of S3 on cold-path re-parse).
        clear_scoped_cache_for_test();
    pub fn statistics_cache_reset_stats(&self) {
                {
    fn set_column_index_cache_registers_and_sets_limit() {
                        file_path
    /// - Footer raw bytes (last 64 KB) + page-index bytes → **promoted to metadata Foyer**
                total += cache_guard.memory_used();
            .as_ref()
            native_bridge_common::log_debug!(
            }
    /// Compute and put statistics into cache (hot path — reads the local file)
            // Remove from metadata cache
        }
    ) -> Result<
    let modified = metadata
                                        version: None,
                let stats = page_index::column_index_cache_stats();
    }
        .fold(None::<std::ops::Range<u64>>, |acc, col| {
}
    /// Direct reference to the file metadata cache
    }
        let mut results = Vec::new();
                if let Some(cache) = &self.file_metadata_cache {
    pub fn clear_all(&self) {
    /// Update the statistics cache size limit
    fn set_offset_index_cache_registers_and_sets_limit() {
            // Remove from statistics cache
        Ok(Some((schema, pq_meta)))
            expected.push(r);
        rt_handle: &tokio::runtime::Handle,
            .build();
                            match compute_parquet_statistics_from_metadata(&pq_meta, &schema) {
                stats_cache.clone() as Arc<dyn FileStatisticsCache>
        // and for OFFSET_INDEX too (both route to clear_scoped_cache)
        }
                if let (Some(off), Some(len)) =
        assert_eq!(column_index_cache_stats().limit_bytes, limit);
    pub fn metadata_cache_hit_count(&self) -> usize {
    /// metadata Foyer tier via `MetadataCachingStore::put_metadata`.
        use parquet::file::reader::FileReader;
        );
                failed_files
                    return false;
        let meta = object_meta.clone();
    pub fn new() -> Self {
        .unwrap_or_else(|_| Utc::now());
    pub fn statistics_cache_hit_rate(&self) -> f64 {
    use crate::cache::{CACHE_TYPE_COLUMN_INDEX, CACHE_TYPE_OFFSET_INDEX};
        crate::cache::page_index::set_offset_index_cache_limit(size_limit);
                    Some(a) => Some(a.start.min(start)..a.end.max(end)),
                        Ok(cache_guard) => {
        let cached_entry = CachedFileMetadataEntry::new(
                    });
        assert_eq!(
        assert!(ci.end > ci.start, "CI region must be non-empty");
 */
    /// Set the statistics cache
                let stats = page_index::offset_index_cache_stats();
    pub fn set_column_index_cache(&mut self, size_limit: usize) {
                }
        self.statistics_cache
}
        );
        .row_groups()
        let buf = parquet_bytes(2, 1, EnabledStatistics::None);
                        Err(e) => {
    /// Get statistics cache miss count
        }
            .set_write_batch_size(8)
        } else {
    /// Create a new CustomCacheManager
                                            .map(|m| m.len())
            .first()
    pub fn remove_files(&self, file_paths: &[String]) -> Result<Vec<(String, bool)>, String> {
            if cache.contains_key(&path) {
        &self,
        // matching the query-time whole-region probe keys exactly. A single merged
    }
            } else {
        );
        self.statistics_cache
/// whole-region fetch (`page_index/page_index_io.rs::whole_index_region`) computes
            // so statistics can be derived without a second IO round-trip.
        if cache.get(&path).is_some() {
            if let Some(cache) = &self.statistics_cache {
            metadata_cache::CACHE_TYPE_OFFSET_INDEX => {
            "page-indexed file must yield separate CI and OI regions"
        }
    /// kinds — which exercises the "one kind present" branch.
        // Step 5: Promote bytes to metadata Foyer (never-evict tier).
 * SPDX-License-Identifier: Apache-2.0
    pub fn metadata_cache_miss_count(&self) -> usize {
        DataFusionError::Execution(format!(
    /// Footer metadata and statistics are derived from a **single** object-store
        rt_handle: &tokio::runtime::Handle,
                file_path, e
        let reader = SerializedFileReader::new(buf).unwrap();
                    });
                {
            .as_ref()
            .statistics_cache
        use arrow::array::{Int64Array, RecordBatch};
    /// Get metadata cache entry count
        // Check statistics cache
        }
                // worth it for a boolean check; callers use this for diagnostics only.
        if let Some(stats_cache) = &self.statistics_cache {
                    errors.push(format!("Metadata cache: {}", e));
                    exp_ci = Some(match exp_ci {
    ) -> Result<bool, String> {
    ) -> Result<Vec<(String, bool)>, String> {
        location: Path::from(file_path),
            config = config
///
                    }
    /// Sets the limit on the process-global `COLUMN_INDEX_CACHE` singleton.
    fn metadata_cache_put_returning_meta(
        match cache_type {
            }
                } else {
                // CI is keyed by (file, col) — a file is "present" if entries > 0 and
                "[warmup::warmup_file_with_store] statistics_cache_put failed for {}: {} (non-fatal)",
            config = config.with_file_statistics_cache(Some(
    }
    /// Get statistics cache entry count
                        None => s..e,
        if let Some(cache) = &self.statistics_cache {
        }
        if cache.contains_key(&path) {
        last_modified: modified,
        }
    fn remove_files_evicts_scoped_cache_when_registered() {
                        file_path, e
            object_meta.size,
        use parquet::file::serialized_reader::SerializedFileReader;
                    }
        let mut index_ranges = compute_page_index_range(&parquet_metadata);
                stats.entries > 0
        ))
                    .await
            );
        // Check metadata cache
    /// Panics if called from within a tokio async context (uses `block_on`).
    /// Build a CacheManagerConfig from the caches stored in this CustomCacheManager
        use datafusion::execution::cache::CacheAccessor;
                any_success
                        }
        // Compute the expected tight folds independently and compare.
    ///
    /// decoded `(SchemaRef, Arc<ParquetMetaData>)` so the caller can derive
        size: file_size,
 * The OpenSearch Contributors require contributions made to
        let _g = crate::test_process_globals::lock();
                    };
    /// Set the file metadata cache
        );
        self.statistics_cache_compute_and_put(file_path)
                }
    };
        let cache = self
        .map(|t| DateTime::<Utc>::from(t))
            size_limit
                .map_err(|e| format!("Failed to head {}: {}", file_path, e))
        config
    /// Must be called from FFM entry points (Java → Rust, non-async) or from
                            }
        );
                        file_path,
                false
        log_debug!(
            file_path, e
            cache.clear();
    }
                    None => Some(start..end),
                Ok(page_index::column_index_cache_stats().used_bytes)
 *
            self.statistics_cache_put_from_parsed(file_path, &parquet_metadata, &object_meta)
                            if cache_guard.remove(&path).is_some() {
            parquet_bridge::load_parquet_metadata_with_meta(store, &location, meta, metadata_cache)
    }
        let buf = parquet_bytes(3, 2, EnabledStatistics::Page);
                                    "[CACHE INFO] File not found in metadata cache: {}",
    }
                } else {
                        e
                page_index::clear_scoped_cache();
            store
            0
        let footer_prefetch = 64 * 1024u64; // matches DataFusion's DEFAULT_FOOTER_READ_SIZE
    }
        mgr.clear_all();
            .unwrap_or(0.0)
/// - CI region = `min(start)..max(end)` over every column×RG `column_index` extent
        let mut mgr = CustomCacheManager::new();
            Err("No statistics cache configured".to_string())
        // Calling remove_files on a non-existent file must not panic.
                        None => s..e,
                failed_files.len(),
        if self.column_index_registered || self.offset_index_registered {
            }
    pub fn metadata_cache_entry_count(&self) -> usize {
            .unwrap_or(0)
    if let Some(r) = ci_region {
    /// 1. Fetch footer only (PageIndexPolicy::Skip) → heap cache (lightweight parsed metadata)
            }
        let cache = self
            .map_err(|e| format!("failed to derive arrow schema for {}: {}", file_path, e))?,
    /// With page statistics disabled the column index is absent (it requires
use crate::indexed_table::parquet_bridge;
        // NOTE: this now returns SEPARATE CI and OI whole regions (up to 2 ranges),
                        None => s..e,
    fn get_memory_consumed_by_type_returns_scoped_stats() {
                                        location: path.clone(),
use opensearch_tiered_storage::tiered_object_store::MetadataCachingStore;
                any_removed
        let mut mgr = CustomCacheManager::new();
        assert!(!mgr.offset_index_registered);
 * compatible open source license.
    pub fn metadata_cache_size_limit(&self) -> usize {
        use datafusion::parquet::arrow::parquet_to_arrow_schema;
        match cache_type {
        }
            Some(oi),
                            errors.push(format!("Metadata cache: Cache remove failed: {}", e));
        }
        let mut mgr = CustomCacheManager::new();
            .ok_or_else(|| "No file metadata cache configured".to_string())?
    #[test]
        &self,
        // Step 4: Fetch the ranges through the store (populates data Foyer on the way).
            }
            offset_index_registered: false,
        Ok(true)
    /// Get total memory consumed by all caches
        }
        self.statistics_cache = Some(cache);
            _ => Err(format!("Unknown cache type: {}", cache_type)),
        // On empty cache both return 0 bytes (no entries yet).
                        Ok(cache_guard.memory_used())
            cache.update_cache_limit(new_limit);
        // clear_cache_type must succeed for COLUMN_INDEX
                    log_debug!(
                let end = start + length as u64;
            w.close().unwrap();
                    Ok(cache.memory_consumed())
                    Ok(())
        let path = Path::from(file_path.to_string());
    /// Used by [`Self::add_files`] (no-store flow) when the parquet lives on local fs
                .await
                        Err("Failed to lock metadata cache".to_string())
                    } else {
    ///   the fast path; the metadata-Foyer footer is the heap-eviction safety net (served from
        // Do NOT pass file_metadata_cache here — that triggers PageIndexPolicy::Optional
use crate::cache::statistics_cache::{
        clear_scoped_cache_for_test();
            if let (Some(offset), Some(length)) =
        log_debug!("[CACHE INFO] File metadata cache set in CustomCacheManager");
        &self,
        // and manually put into the heap cache afterward.
        let metadata_cache = self
    column_index_registered: bool,
/// IMPORTANT: warmup must write these as TWO keys (CI, OI) — NOT one merged
        }
                }
        let (schema, _size, pq_meta) = rt_handle.block_on(async {
        assert!(mgr.clear_cache_type(CACHE_TYPE_COLUMN_INDEX).is_ok());
        self.file_metadata_cache = Some(cache);
                    any_removed = true;
        // Step 3: Compute page/offset index byte ranges from the parsed footer.
        let location = object_meta.location.clone();
                    native_bridge_common::log_debug!(
    }
    let oi_region = metadata
/// lacks. Returns an empty Vec if the file has no page index at all.
    ) -> Result<Vec<(String, bool)>, String> {
                                }
    /// Fetch footer only (no page indexes) from the store and put into heap cache.
            metadata_cache::CACHE_TYPE_OFFSET_INDEX => {
        // Also promote the footer (last 64 KB) to metadata Foyer — heap-eviction safety net.
            mgr.get_memory_consumed_by_type(CACHE_TYPE_COLUMN_INDEX)
            Some(ci),
                                        last_modified: chrono::Utc::now(),
        file_paths: &[String],
                let batch = RecordBatch::try_new(schema.clone(), cols).unwrap();
        e_tag: None,
        store: &Arc<dyn MetadataCachingStore>,
            metadata_cache::CACHE_TYPE_COLUMN_INDEX | metadata_cache::CACHE_TYPE_OFFSET_INDEX => {
        }
        assert!(mgr.clear_cache_type(CACHE_TYPE_OFFSET_INDEX).is_ok());
                }
                continue;
            };
        log_debug!(
    /// [`parquet::file::metadata::ParquetMetaData`] and put them into the statistics
        }
    use chrono::{DateTime, Utc};
        stats: parquet::file::properties::EnabledStatistics,
            return Ok(true);
            statistics_cache: None,
        rt_handle: &tokio::runtime::Handle,
use object_store::path::Path;
        ranges: &[std::ops::Range<u64>],
                                    let meta = ObjectMeta {
        assert!(mgr.column_index_registered);
    /// Remove multiple files from all caches
                    results.push((file_path.clone(), false));
    pub fn contains_file(&self, file_path: &str) -> bool {
        bytes::Bytes::from(buf)
        use datafusion::execution::cache::cache_manager::CachedFileMetadataEntry;
        clear_scoped_cache_for_test();
            }
    }
    }
        let path = Path::from(file_path.to_string());
        }
    // Column-index whole region across all columns × all row groups.
        }
            .map(|cache| cache.current_size_limit())
        let metadata_cache = cache_ref.clone() as Arc<dyn FileMetadataCache>;
    /// Clear all caches
                acc
        use parquet::file::properties::WriterProperties;
                .unwrap(),
            })?;
                            }
                                        e_tag: None,
                    // Derive statistics from the already-loaded metadata — no second read.
        num_cols: usize,
    }
                if cache.get(&path).is_some() {
            metadata_cache::CACHE_TYPE_STATS => {
                Ok(Some((schema, pq_meta))) => {
                    None => Some(start..end),
    }
        let object_meta = object_metas
    pub fn statistics_cache_size_limit(&self) -> usize {
            let mut w = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
    > {
                Ok(success) => {
            match self.warmup_file_with_store(file_path, &store, rt_handle) {
};
        {
            for col in rg.columns() {
    ///    range so it's also covered by the metadata Foyer promotion below
    fn compute_page_index_range_matches_independent_fold_no_page_stats() {
    /// whether page indexes (column-index + offset-index) are emitted into the footer.
        // 64 KB footer range above does NOT match — so without this the very first
                                    };
                    let (s, e) = (off as u64, off as u64 + len as u64);
    }
    /// Add multiple files to all applicable caches.
        assert_ne!(
) -> Vec<std::ops::Range<u64>> {
/// Returns up to two ranges (CI first, then OI), skipping whichever kind the file
use datafusion::execution::cache::CacheAccessor;
                        last_modified: chrono::Utc::now(),
    /// Returns the parsed metadata and object meta (for file size).
    /// For warm shards (data on the per-shard remote store) the equivalent helper is
        match cache_type {
    /// Check if a file exists in a specific cache type
        // Also promote the exact last-8-byte postscript [size-8, size] to metadata Foyer.
    }
        let fields: Vec<Field> = (0..num_cols)
    /// Get metadata cache size limit in bytes
            "CI region must equal the tight min..max fold of all column_index extents"
        if let Some(cache) = &self.statistics_cache {
        // footer-metadata length + "PAR1" magic) to learn the footer length. On an
            metadata_cache::CACHE_TYPE_METADATA => {
            }
        }
                if let (Some(off), Some(len)) =
    }
        if let Some(cache) = &self.statistics_cache {
        let props = WriterProperties::builder()
    /// 2. Derive statistics from the same parsed metadata → statistics cache
    use datafusion::common::DataFusionError;
        Option<(
            Ok(stats) => {
            .set_statistics_enabled(stats)
                    let (s, e) = (off as u64, off as u64 + len as u64);
        // Head call to get file size (TieredObjectStore serves from registry)
    /// (which is a remote-IO call on warm shards). Returns `Ok(true)` on insert,
                false
        {
        let mut mgr = CustomCacheManager::new();
                    });
    /// statistics without a second IO round-trip.
            .unwrap_or(0)
                    any_success = true;
        mgr.set_column_index_cache(limit);
                        Arc::new(Int64Array::from(vals)) as Arc<dyn arrow::array::Array>
        let cache = match self.statistics_cache.as_ref() {
                    cache.put_statistics(&path, Arc::new(stats), &meta);
                    error!(
        let object_metas = create_object_meta_from_file(file_path)
                }
    pub fn metadata_cache_reset_stats(&self) {
                if cache.remove(&path).is_some() {
#[cfg(test)]
                    }
    /// Get metadata cache hit count
    statistics_cache: Option<Arc<CustomStatisticsCache>>,
                w.write(&batch).unwrap();
        for file_path in file_paths {
    pub fn update_statistics_cache_limit(&self, new_limit: usize) -> Result<(), String> {
        let store: Arc<dyn ObjectStore> = Arc::new(object_store::local::LocalFileSystem::new());
                                any_removed = true;
    }
        mgr.set_column_index_cache(16 * 1024 * 1024);
                }
                    errors.push("No metadata cache configured".to_string());
                let start = offset as u64;
    pub fn set_file_metadata_cache(&mut self, cache: Arc<MutexFileMetadataCache>) {
                "Failed to compute statistics for {}: {}",
/// Compute the page-index regions to warm, as SEPARATE column-index (CI) and
            } else {
            cache.reset_stats();
/// - OI region = `min(start)..max(end)` over every column×RG `offset_index` extent
        use parquet::file::properties::EnabledStatistics;
                } else {
        total
    /// A page-indexed file yields exactly TWO regions — the column-index (CI) whole
    })?;
            }
        if let Some(cache) = &self.statistics_cache {
        cache.put_statistics(&path, Arc::new(stats), object_meta);
                        let vals: Vec<i64> =
    CacheManagerConfig, FileMetadataCache, FileStatisticsCache,
                } else {
    /// Direct reference to the statistics cache
        &self,
        if let Some(cache) = &self.file_metadata_cache {
    }
    /// Get statistics cache hit count
        if !file_path.to_lowercase().ends_with(".parquet") {
            total += cache.memory_consumed();
        mgr.set_column_index_cache(16 * 1024 * 1024);
    }
        .flat_map(|rg| rg.columns().iter())
        }
        index_ranges.push(footer_start..object_meta.size);
            );
                    Err("No metadata cache configured".to_string())
        }
        &self,
                }
            let removed = if !errors.is_empty() && !any_removed {
/// and probes them.
    }
                file_path, e
                        Some(a) => a.start.min(s)..a.end.max(e),
                // we match by prefix; check via evict-probe is heavy so we approximate
        &self,
        ranges.push(r);
            let path = Path::from(file_path);
        // exact-key warm tier that 8-byte read probes key [size-8, size], which the
    /// Sets the limit on the process-global `OFFSET_INDEX_CACHE` singleton.
            let mut any_removed = false;
    }
    let ci_region = metadata
        }
        let mut total = 0;
            .map(|cache| cache.hit_count())
    ///
            }
        native_bridge_common::log_debug!(
                        None => s..e,
        };
        // Put lightweight footer-only metadata into heap cache
            .ok_or_else(|| "No statistics cache configured".to_string())?;
                }
        let reader = SerializedFileReader::new(buf).unwrap();
                        size: std::fs::metadata(file_path).map(|m| m.len()).unwrap_or(0),
    /// Reset metadata cache stats
        );
            "[CACHE INFO] Column index cache registered (limit={} bytes)",
        object_meta: &ObjectMeta,
                Ok(())
            let mut errors = Vec::new();
        let mut success_count = 0;
            .collect();
    fn parquet_bytes(
        assert!(mgr.offset_index_registered);
                file_metadata.schema_descr(),
            }
            .as_ref()
                .head(&path)
            crate::cache::metadata_cache::CACHE_TYPE_METADATA => {
    #[test]
                }
                            (base..base + 40).map(|v| v + (c as i64 * 1000)).collect();
                file_metadata.key_value_metadata(),
        mgr.set_offset_index_cache(32 * 1024 * 1024);
            }
        }
                .await
            Err(e) => Err(format!(
            // Evict from scoped page-index caches (CI + OI) by file prefix
            .set_data_page_row_count_limit(8)
    }
                                    errors.push(format!("Statistics cache: {}", e));
                    return false;
            metadata_cache::CACHE_TYPE_STATS => {
        if let Err(e) =
        clear_scoped_cache_for_test();
            {
                    last_modified: chrono::Utc::now(),
                .map_err(|e| format!("Failed to update statistics cache limit: {:?}", e))
                .statistics_cache
                let path = Path::from(file_path);
        );
            }
        }
            metadata_cache::CACHE_TYPE_COLUMN_INDEX => {
            use object_store::ObjectStoreExt;
        self.statistics_cache
            }
        let schema = Arc::new(Schema::new(fields));
                page_index::evict_file_from_scoped_cache(file_path);
    /// subsequent query lookups validate cleanly via `is_valid_for`.
    let metadata = std::fs::metadata(file_path).map_err(|e| {
                        "[CACHE ERROR] add_files_with_store failed for {}: {}",
        })?;
                                );
        metadata_cache.put(&path, cached_entry);
            ranges.len(),
use object_store::ObjectMeta;
        let (ci, oi) = (ranges[0].clone(), ranges[1].clone());
                                Err(e) => {
            .map_err(|e| format!("failed to compute statistics for {}: {}", file_path, e))?;
    }
                }
                acc
                    let meta = ObjectMeta {
            // Single footer fetch — warms metadata cache and returns the decoded metadata
/// Create ObjectMeta from a local file path.
            cache.reset_stats();
            let success = if !errors.is_empty() && !any_success {
            if self.column_index_registered || self.offset_index_registered {
            .as_ref()
                match acc {
                Ok(page_index::offset_index_cache_stats().used_bytes)
            if let Some(cache) = &self.file_metadata_cache {
        assert_eq!(
                .await
    #[test]
        self.statistics_cache.clone()
use datafusion::execution::cache::cache_manager::{
        .fold(None::<std::ops::Range<u64>>, |acc, col| {
        clear_scoped_cache_for_test();
///
    pub fn get_file_metadata_cache_for_datafusion(&self) -> Option<Arc<dyn FileMetadataCache>> {
    }
            }
                "[STATS CACHE WARNING] Failed to compute statistics for {} files: {:?}",
    /// through the store (for Foyer caching), and promote those ranges to the
            Some(c) => c,
                    version: None,
        if !file_path.to_lowercase().ends_with(".parquet") {
        let mut mgr = CustomCacheManager::new();
    pub fn add_files_with_store(
            }
        .iter()
                    e_tag: None,
        log_debug!("[CACHE INFO] Statistics cache set in CustomCacheManager");
            )),
                        e_tag: None,
                    exp_ci = Some(match exp_ci {
        let path = Path::from(file_path.to_string());
        let path = Path::from(file_path.to_string());
    file_metadata_cache: Option<Arc<MutexFileMetadataCache>>,
                } else {
        self.statistics_cache
                .as_ref()
        assert!(!mgr.column_index_registered);
                Err(e) => {
        Self {
                let end = start + length as u64;
            let mut errors = Vec::new();
            .map(|cache| cache.miss_count())
            config = config.with_file_statistics_cache(Some(default_stats));
        assert_eq!(
        clear_scoped_cache_for_test();
            2,
        // Compute statistics
/// offset-index (OI) whole regions — matching exactly how the query-time
        if let Some(r) = exp_oi {
        for file_path in file_paths {
                Err(e) => {
        {
                                            .unwrap_or(0),
    /// Get or compute statistics
    ) -> Result<bool, String> {
        use parquet::file::reader::FileReader;
        if let Some(r) = exp_ci.clone() {
        let object_meta = rt_handle.block_on(async {
            Self::fetch_ranges_via_store(store, file_path, &index_ranges, rt_handle)?;
            .ok_or_else(|| "No object metadata returned".to_string())?;
            }
        );
        });
        clear_scoped_cache_for_test();
        assert!(
                    );
                    .is_some()
            for col in rg.columns() {
    #[test]
    }
    /// function must equal the independent `[CI?, OI?]` fold — skipping absent
            exp_ci,
            .ok_or_else(|| "No statistics cache configured".to_string())?;
        let limit = 32 * 1024 * 1024; // 32 MB
    }
                        "[CACHE INFO] File not added for metadata cache: {}",
            .unwrap_or(0)
use native_bridge_common::log_debug;
        let file_metadata = parquet_metadata.file_metadata();
        assert_eq!(
            column_index_registered: false,
    }
    pub fn statistics_cache_hit_count(&self) -> usize {
                Ok(stats) => {
        }
    }
                success_count += 1;
            .ok_or_else(|| "No statistics cache configured".to_string())?;
    };
        }
    use super::*;
    pub fn statistics_cache_entry_count(&self) -> usize {
    ///   (never-evict SSD tier) via `store.put_metadata(...)`. The parsed footer in heap is
    }
};
        });
}
    /// # Panics
    /// - Footer (schema + RG stats) → heap file_metadata_cache (parsed `ParquetMetaData`, fast path)
        // Add statistics cache if available - use CustomStatisticsCache directly
    ) -> bytes::Bytes {
use log::{debug, error};
        clear_scoped_cache_for_test();
    ) -> Result<(Arc<parquet::file::metadata::ParquetMetaData>, ObjectMeta), String> {
    }
        let cache_ref = self
            {
                }
        let _g = crate::test_process_globals::lock();
        // Step 1: Fetch footer only → heap cache (parsed ParquetMetaData)
    /// Called from [`Self::warmup_file_with_store`] right after the heap metadata
                }
                let base = (rg * 100) as i64;
            rt_handle.block_on(async {
            .unwrap_or(0)
                    .map_err(|e| format!("Failed to fetch footer: {}", e))
    metadata: &parquet::file::metadata::ParquetMetaData,
        self.statistics_cache
                stats.entries > 0
            let default_stats = Arc::new(DefaultFileStatisticsCache::default());
                    Err("No statistics cache configured".to_string())
    fn statistics_cache_put_from_parsed(
            .as_ref()
        num_rg: usize,
        index_ranges.push(postscript_start..object_meta.size);
            ci, oi,
                    cache.clear();
                let df_metadata = DFParquetMetadata::new(store.as_ref(), &object_meta);
        })?;
            };
            .unwrap_or(0)
            } else {
use datafusion::datasource::physical_plan::parquet::metadata::DFParquetMetadata;
                        version: None,
        let mut exp_oi: Option<std::ops::Range<u64>> = None;
            return Ok(vec![]);
                                log_debug!(
        let mut exp_ci: Option<std::ops::Range<u64>> = None;
            .as_ref()
    let object_meta = ObjectMeta {
        mgr.set_column_index_cache(16 * 1024 * 1024);
        Ok(results)
                }
            expected,
        file_path: &str,
        use parquet::file::serialized_reader::SerializedFileReader;
    /// Returns `Ok(None)` for non-parquet files.
                // with entries > 0. A per-file lookup requires iterating DashMap — not
                                    file_path
                {
        use arrow::datatypes::{DataType, Field, Schema};
        Ok(results)
            if let (Some(offset), Some(length)) =
                    let (s, e) = (off as u64, off as u64 + len as u64);
            .map(|cache| cache.hit_rate())
pub struct CustomCacheManager {
        Ok(results)
        match compute_parquet_statistics(file_path) {
        let footer_start = object_meta.size.saturating_sub(footer_prefetch);
    /// Get the file metadata cache as Arc<dyn FileMetadataCache> for DataFusion
        Ok((parquet_metadata, object_meta))
    /// Update the file metadata cache size limit
            .as_ref()
        file_path: &str,
                    exp_oi = Some(match exp_oi {
        );
        // Must not panic even with no metadata/stats caches set.
/// under separate keys, so a single merged key would never match (warm miss).
    /// - Page indexes NOT stored in heap (avoids 1GB+ memory bloat on wide schemas).
                df_metadata
            index_ranges.len(),
            }
        self.file_metadata_cache
            error!(
        }
        file_path: &str,
                    if let Ok(cache_guard) = cache.inner.lock() {
    /// 5. Promote those ranges to **metadata Foyer** (never-evict tier) via `store.put_metadata`
    /// Clear specific cache type
                    .map(|c| {
        clear_scoped_cache_for_test();
/// Custom CacheManager that holds cache references directly
        .modified()
            .unwrap_or(0)
        file_path: &str,
                if let Some(cache) = &self.statistics_cache {
    /// Check if a file exists in any cache
                    });
        }
                    failed_files.push(file_path.clone());
    pub fn clear_cache_type(&self, cache_type: &str) -> Result<(), String> {
    }
        let result = mgr.remove_files(&["/nonexistent/file.parquet".to_string()]);
                                    stats_cache.put_statistics(&path, Arc::new(stats), &meta);
        store: Arc<dyn MetadataCachingStore>,
    offset_index_registered: bool,
    pub fn get_memory_consumed_by_type(&self, cache_type: &str) -> Result<usize, String> {
    #[test]
            ));
    }
                }
        // Heap holds the parsed `ParquetMetaData` for fast lookups; the metadata Foyer entry
    let file_size = metadata.len();
        }
                (col.offset_index_offset(), col.offset_index_length())
    }
use datafusion::execution::cache::file_statistics_cache::DefaultFileStatisticsCache;
            .map(|cache| cache.clone() as Arc<dyn FileMetadataCache>)
    ///
    fn clear_cache_type_column_index_clears_scoped_cache() {
            Arc<datafusion::parquet::file::metadata::ParquetMetaData>,
        file_paths: &[String],
 * this file be licensed under the Apache-2.0 license or a
        clear_scoped_cache_for_test, column_index_cache_stats, offset_index_cache_stats,
    /// Batch compute and cache statistics for multiple files
    ///
            if cache.contains_key(&path) {
                let start = offset as u64;
        // Column index requires page-level statistics; with stats disabled it must be absent.
            } else {
                    })
            }
    /// `Ok(false)` if the statistics cache is not configured or the file is
                    );
    use crate::cache::eviction_policy::PolicyType;
                .map_err(|e| format!("Failed to fetch ranges for {}: {}", file_path, e))
        file_paths: &[String],
use crate::cache::{metadata_cache, page_index};
            match self.metadata_cache_put_returning_meta(file_path, rt_handle) {
    // Offset-index whole region across all columns × all row groups.
        clear_scoped_cache_for_test();
}
    pub fn set_statistics_cache(&mut self, cache: Arc<CustomStatisticsCache>) {
        file_path: &str,
            "OI region must equal the tight min..max fold of all offset_index extents"
        let mut exp_ci: Option<std::ops::Range<u64>> = None;
    fn warmup_file_with_store(
                                }
                found = true;
        let mut exp_oi: Option<std::ops::Range<u64>> = None;
    /// Get the statistics cache
        let ranges = compute_page_index_range(metadata);
    /// tight min..max fold over the corresponding per-column extents in the footer.
            None => return Ok(false),
        // DataFusion's FIRST footer read is an 8-byte read of the postscript (4-byte
        .iter()
    /// Fetch a parquet file's footer, warm the metadata cache, and return the
    fn fetch_footer_to_heap(
                                Ok(stats) => {
            "CI and OI must be distinct warm-tier keys (not merged)"
) -> Result<Vec<ObjectMeta>, datafusion::common::DataFusionError> {
        let mut mgr = CustomCacheManager::new();
        let schema = Arc::new(
    if let Some(r) = oi_region {
        );
    Ok(vec![object_meta])
                self.file_metadata_cache
        let (parquet_metadata, object_meta) =
            .map(|cache| cache.miss_count())
                    .as_ref()
            for rg in 0..num_rg {
    fn clear_all_clears_scoped_cache_when_registered() {
            Arc::new(CachedParquetMetaData::new(Arc::clone(&parquet_metadata))),
        for rg in metadata.row_groups() {
    pub fn add_files(
                (col.column_index_offset(), col.column_index_length())
                if let (Some(off), Some(len)) =
            .set_max_row_group_size(32)
}
        // Add metadata cache memory
                                        size: std::fs::metadata(file_path)
use crate::cache::metadata_cache::MutexFileMetadataCache;
            }
///
        if ranges.is_empty() {
        self.offset_index_registered = true;
    }
            .clone() as Arc<dyn FileMetadataCache>;
            compute_page_index_range(metadata),
                {
        ranges.push(r);
        assert_eq!(
    ) -> Result<usize, String> {
        store.put_metadata(file_path, &index_ranges, &fetched_bytes);
                        let path = Path::from(file_path.as_str());
        let _g = crate::test_process_globals::lock();
    pub fn get_statistics_cache(&self) -> Option<Arc<CustomStatisticsCache>> {
                if let Some(cache) = &self.file_metadata_cache {
    /// `ParquetMetaData` from the warmup pass instead of opening the file locally
                    .collect();
                        if !stats_cache.contains_key(&path) {
            }
            .as_ref()
    fn compute_page_index_range_returns_tight_ci_and_oi_regions() {
            "result must equal the independent [CI?, OI?] fold, skipping absent index kinds"
            {
use object_store::ObjectStore;
mod tests {
                    (col.column_index_offset(), col.column_index_length())
    pub fn contains_file_by_type(&self, file_path: &str, cache_type: &str) -> bool {
        if cache.contains_key(&path) {
                if !self.offset_index_registered {
/// CI∪OI range. The query probes the CI whole region and the OI whole region
        mgr.set_offset_index_cache(limit);
                        Some(a) => a.start.min(s)..a.end.max(e),
                        }
            }
                cache.put_statistics(&path, Arc::new(stats), &meta);
            .as_ref()
            parquet_to_arrow_schema(
            .map(|cache| cache.get_cache_limit())
    fn fetch_ranges_via_store(
                    (col.column_index_offset(), col.column_index_length())
        // Add statistics cache memory
    /// cache, reusing the same [`ObjectMeta`] the heap metadata cache used so
            "column index must be absent when statistics are disabled"
    /// Reset statistics cache stats
            return Ok(None);
    }
    #[test]
        .row_groups()
            .as_ref()
    pub fn build_cache_manager_config(&self) -> CacheManagerConfig {
        found
    }
            return Ok(false);
        }
            .unwrap_or(0)
        &self,
    pub fn get_total_memory_consumed(&self) -> usize {
                }
                if let Some(cache) = &self.file_metadata_cache {
    }
                        Some(a) => a.start.min(s)..a.end.max(e),
                        location: path.clone(),
    pub fn statistics_cache_compute_and_put(&self, file_path: &str) -> Result<bool, String> {
        use datafusion::datasource::physical_plan::parquet::metadata::CachedParquetMetaData;
        if let Some(cache) = self.get_file_metadata_cache_for_datafusion() {
        // which loads page indexes into the heap struct. Instead, load footer only
        let limit = 16 * 1024 * 1024; // 16 MB
        rt_handle: &tokio::runtime::Handle,
        )>,
fn create_object_meta_from_file(
use crate::cache::statistics_cache::CustomStatisticsCache;
            0
            mgr.get_memory_consumed_by_type(CACHE_TYPE_OFFSET_INDEX)
            .as_ref()
                    Err("No metadata cache configured".to_string())
        // their own key makes that probe a warm hit.
        // Reuses `parquet_metadata` so we don't re-fetch through the store. Failures
                let path = Path::from(file_path.clone());
    file_path: &str,
                .unwrap(),
                    Some(a) => Some(a.start.min(start)..a.end.max(end)),
        self.column_index_registered = true;
        }
            .map(|cache| cache.hit_count())
        let cache = self
    /// Warmup a single file
        String,
            metadata_cache::CACHE_TYPE_COLUMN_INDEX => {
        let stats = DFParquetMetadata::statistics_from_parquet_metadata(parquet_metadata, &schema)
            results.push((file_path.clone(), success));
            cache.clear();
        let _g = crate::test_process_globals::lock();
        // No-op when `store` is not a TieredObjectStore (default trait impl is no-op).
        assert_eq!(
    ///
                }
        let _g = crate::test_process_globals::lock();
        }
        let path = Path::from(file_path.to_string());
                    (col.offset_index_offset(), col.offset_index_length())
                }
                if !self.column_index_registered {
            .statistics_cache
    compute_parquet_statistics, compute_parquet_statistics_from_metadata,
                    size: std::fs::metadata(file_path).map(|m| m.len()).unwrap_or(0),
    /// 4. Fetch those ranges through the store (populates **data Foyer** as a side effect of get_ranges)
    #[test]
                    cache.clear();
    }
                .get_ranges(&path, ranges)
    ///
        if let Some(cache) = &self.file_metadata_cache {
        for file_path in file_paths {
                Ok(true)
                    (col.offset_index_offset(), col.offset_index_length())
        parquet_metadata: &Arc<parquet::file::metadata::ParquetMetaData>,
    }
        self.file_metadata_cache
        mgr.set_offset_index_cache(32 * 1024 * 1024);
        );
    ranges
            )
                match acc {
    /// already cached, `Err(_)` on schema/derivation failure.
        let mut buf: Vec<u8> = Vec::new();
            .map(|cache| <CustomStatisticsCache as CacheAccessor<_, _>>::len(cache))
        }
            page_index::clear_scoped_cache();
            match compute_parquet_statistics(file_path) {
            results.push((file_path.clone(), removed));
    pub fn statistics_cache_miss_count(&self) -> usize {
        let mut results = Vec::with_capacity(file_paths.len());
            "[CACHE INFO] Offset index cache registered (limit={} bytes)",
            .map(|c| Field::new(format!("col_{}", c), DataType::Int64, false))
                    if let Some(stats_cache) = &self.statistics_cache {
                if let (Some(off), Some(len)) =
        if !failed_files.is_empty() {
        let metadata = reader.metadata();
        assert!(result.is_ok());
    pub fn update_metadata_cache_limit(&self, new_limit: usize) {
                }
            .file_metadata_cache
            .statistics_cache
        rt_handle: &tokio::runtime::Handle,
    /// Key design:
        crate::cache::page_index::set_column_index_cache_limit(size_limit);
    pub fn statistics_cache_get_or_compute(&self, file_path: &str) -> Result<bool, String> {
        let parquet_metadata: Arc<parquet::file::metadata::ParquetMetaData> =
                    );
                }
        mgr.set_column_index_cache(16 * 1024 * 1024);
        self.file_metadata_cache
            metadata_cache::CACHE_TYPE_METADATA => {
    /// 3. Compute page/offset index byte ranges from the parsed footer; append the footer
                Err(e) => {
                let meta = ObjectMeta {
            cache
    /// Get metadata cache miss count
            .ok_or_else(|| "No file metadata cache configured".to_string())?;
                    match cache.inner.lock() {
    }
            self.fetch_footer_to_heap(file_path, store, rt_handle)?;
    ///
    pub fn set_offset_index_cache(&mut self, size_limit: usize) {
        assert!(oi.end > oi.start, "OI region must be non-empty");
            crate::cache::metadata_cache::CACHE_TYPE_STATS => self
    pub fn statistics_cache_batch_compute_and_put(
