}
    }
            .file_metadata
        match self.inner.lock() {
                "cache_error".to_string()
        let cached = entry
        let bytes = parquet_with_page_index();
    fn full_index_entry(bytes: &Bytes) -> CachedFileMetadataEntry {
            object_meta(&bytes),
    pub inner: Mutex<DefaultFilesMetadataCache>,
        .unwrap();
        .file_metadata
    }
        // `PageIndexPolicy::ReadAll`, so the full index is present to retain.
        .downcast_ref::<CachedParquetMetaData>()
                log_cache_error("name", &e.to_string());
fn strip_page_index(entry: CachedFileMetadataEntry) -> CachedFileMetadataEntry {
    GLOBAL_RUNTIME_ENV.read().as_ref().and_then(Weak::upgrade)
        }
    }
        // pruning is handled by the scoped cache (`parquet_page_cache`).
        m.column_index().is_some() || m.offset_index().is_some()
    *GLOBAL_RUNTIME_ENV.write() = Some(Arc::downgrade(runtime_env));
        );
        .unwrap();
                log_cache_error("contains_key", &e.to_string());
/// Called once per `create_global_runtime`; a later runtime replaces the registration.
        let entry = CachedFileMetadataEntry::new(
/// rebuild).
    }
            .unwrap();
        )
        Bytes::from(buf)
            }
        }
        .set_offset_index(None)
        match self.inner.lock() {
            .as_any()
        if let Ok(cache) = self.inner.lock() {
            .set_data_page_row_count_limit(128)
            Err(e) => {
        match self.inner.lock() {
        );
            Ok(cache) => cache.remove(k),
        match self.inner.lock() {
    }
    else {
    CachedFileMetadataEntry, FileMetadataCache, FileMetadataCacheEntry,
    use super::*;
    fn put_strips_page_index_and_get_returns_footer_only() {
        }
        assert!(m.num_row_groups() > 0);
    #[test]
    };
    }
impl CacheAccessor<Path, CachedFileMetadataEntry> for MutexFileMetadataCache {
 * this file be licensed under the Apache-2.0 license or a
    }
            Ok(cache) => cache.list_entries(),
            }
        let batch = RecordBatch::try_new(
            Err(e) => {
            Err(e) => {
impl FileMetadataCache for MutexFileMetadataCache {
            hit_count: AtomicUsize::new(0),
    pub fn miss_count(&self) -> usize {
        let cached = got
        let _globals = crate::test_process_globals::lock();
        }
        let cache = MutexFileMetadataCache::new(DefaultFilesMetadataCache::new(64 * 1024 * 1024));
        assert!(Arc::ptr_eq(&SECOND, &read_back));
        }
        // including page indexes so DataFusion's default page pruning path continues
}
///
/// registration never keeps a closed runtime alive.
    fn a_registered_runtime_env_reads_back_as_the_same_object() {
// Cache type constants
    // `OffsetIndex` are released when the original Arc drops; the footer
            .as_any()
            cache.update_cache_limit(new_limit);
            ArrowReaderOptions::new().with_page_index(true),
}
    }
        };
            vec![Arc::new(Int64Array::from((0..4096i64).collect::<Vec<_>>()))],
        let m = cached.parquet_metadata();
        assert!(
        assert!(
        } else {
        let bytes = parquet_with_page_index();
}
            v
    /// Held in statics: the registry keeps only a `Weak`, so an environment dropped at test end
        .set_column_index(None)
    if meta.column_index().is_none() && meta.offset_index().is_none() {
    #[test]
        .into_builder()
    fn page_index_present(entry: &CachedFileMetadataEntry) -> bool {
        let stripped = strip_page_index(entry);
        }
        let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
        return entry;
use datafusion::parquet::file::metadata::ParquetMetaData;
fn log_cache_error(operation: &str, error: &str) {
        Arc::new(CachedParquetMetaData::new(Arc::new(stripped))),
use native_bridge_common::log_error;
        //
        let meta = ArrowReaderMetadata::load(
            .set_statistics_enabled(EnabledStatistics::Page)
    #[test]
                log_cache_error("len", &e.to_string());
        w.write(&batch).unwrap();
/// Return a cache entry whose `ParquetMetaData` carries footer-only metadata (no
    fn clear(&self) {
        .unwrap();
    pub fn new(cache: DefaultFilesMetadataCache) -> Self {
            .downcast_ref::<CachedParquetMetaData>()
            Ok(cache) => cache.name(),
    }
/// environment keeps a caller's cache and memory budget consistent with the node's. `Weak`, so a
        assert!(
    pub fn update_cache_limit(&self, new_limit: usize) {
            cache.clear();
                0
    pub fn clear_cache(&self) {
    }
        // When scoped page-index is disabled (fallback mode): retain the full entry
                log_cache_error("remove", &e.to_string());
        w.close().unwrap();
                None
    fn remove(&self, k: &Path) -> Option<CachedFileMetadataEntry> {
        // to function. In this mode `load_parquet_metadata` fetches with
                log_cache_error("list_entries", &e.to_string());
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
            Err(e) => {
        // When scoped page-index is enabled: strip ColumnIndex + OffsetIndex from
/// closed.
    #[test]
}
    #[cfg(test)]
    /// would leave a dead registration for the next test in this binary.
    use object_store::ObjectMeta;
use std::sync::atomic::{AtomicUsize, Ordering};
static GLOBAL_RUNTIME_ENV: RwLock<Option<Weak<RuntimeEnv>>> = RwLock::new(None);
#[cfg(test)]
use std::sync::{Arc, Mutex, Weak};
            }
    fn cache_limit(&self) -> usize {
            "cached entry must be footer-only after put"
            }
        }
            0
        register_global_runtime_env(&FIRST);
            size: bytes.len() as u64,
use crate::parquet_page_cache::is_scoped_page_index_enabled;
        let key = Path::from("data.parquet");
        register_global_runtime_env(&FIRST);
            "precondition: entry has page index"
    }
    pub fn hit_count(&self) -> usize {
/// `put` runs the entry through here before it lands in the shared LRU.
            cache.cache_limit()
    use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
            .downcast_ref::<CachedParquetMetaData>()
        entry.meta,
        self.hit_count.store(0, Ordering::Relaxed);
    CachedFileMetadataEntry::new(
    fn strip_is_noop_for_footer_only_entry() {
            Arc::ptr_eq(&FIRST, &read_back),
        Self {
    fn put(&self, k: &Path, v: CachedFileMetadataEntry) -> Option<CachedFileMetadataEntry> {
        let pq = meta.metadata().clone();
    fn len(&self) -> usize {
            location: Path::from("data.parquet"),
/// The registered environment, or `None` before a global runtime exists or after the last one was
            Err(e) => {
    fn contains_key(&self, k: &Path) -> bool {
    }
    }
            miss_count: AtomicUsize::new(0),
        }
            ArrowReaderOptions::new().with_page_index(false),
                None
        match self.inner.lock() {
        } else {
    fn a_later_registration_replaces_the_earlier_one() {
    }
                0
                }
            Ok(cache) => {
            inner: Mutex::new(cache),
            .build();
            Arc::ptr_eq(cached.parquet_metadata(), &pq),
        if let Ok(cache) = self.inner.lock() {
        }
        assert!(
    use datafusion::parquet::arrow::ArrowWriter;
        assert!(pq.column_index().is_none() && pq.offset_index().is_none());
            version: None,
        let entry = full_index_entry(&bytes);
            Err(e) => {
    let Some(cached) = entry
                    self.hit_count.fetch_add(1, Ordering::Relaxed);
        match self.inner.lock() {
        }
        let meta = ArrowReaderMetadata::load(
            .as_any()
}
        }
pub struct MutexFileMetadataCache {
    log_error!("[CACHE ERROR] {} operation failed: {}", operation, error);
        );
pub const CACHE_TYPE_OFFSET_INDEX: &str = "OFFSET_INDEX";
    let stripped = ParquetMetaData::clone(meta)
use datafusion::execution::cache::DefaultFilesMetadataCache;
            Ok(cache) => cache.cache_limit(),
        let m = cached.parquet_metadata();
        let got = cache.get(&key).expect("entry must be retrievable");
    use super::*;
mod strip_page_index_tests {
    fn object_meta(bytes: &Bytes) -> ObjectMeta {
            Ok(cache) => cache.contains_key(k),
    fn parquet_with_page_index() -> Bytes {
    // (row-group + column chunk stats) is preserved.
        let read_back = global_runtime_env().expect("a registered environment must be readable");
            Err(e) => log_cache_error("update_cache_limit", &e.to_string()),
 * compatible open source license.
            "readers must share one environment, otherwise each caller gets its own cache and \
        self.hit_count.load(Ordering::Relaxed)
            }
                std::collections::HashMap::new()
/// The global runtime's `RuntimeEnv`, for callers that have none to read it from. Sharing the whole
                false
pub fn register_global_runtime_env(runtime_env: &Arc<RuntimeEnv>) {
        );
            !page_index_present(&got),
        if let Ok(cache) = self.inner.lock() {
#[cfg(test)]
    }
        )
pub const CACHE_TYPE_COLUMN_INDEX: &str = "COLUMN_INDEX";
 * The OpenSearch Contributors require contributions made to
                log_cache_error("put", &e.to_string());
 */
        cache.put(&key, entry);
        }
/// `ColumnIndex` / `OffsetIndex`). If the entry already lacks a page index — or
    hit_count: AtomicUsize,
        assert!(!Arc::ptr_eq(&FIRST, &read_back));
    }
    let meta = cached.parquet_metadata();
            last_modified: chrono::Utc::now(),
        ObjectMeta {
        match self.inner.lock() {
            "footer-only entry must be returned unchanged (same Arc)"
                log_cache_error("get", &e.to_string());
    crate::test_process_globals::assert_held("the global DataFusion RuntimeEnv registration");
    miss_count: AtomicUsize,
    use prost::bytes::Bytes;
}
    use datafusion::arrow::array::{Int64Array, RecordBatch};
            e_tag: None,
             memory budget"
            Err(e) => {
        assert!(pq.column_index().is_some() && pq.offset_index().is_some());
            }
        let cached = stripped
            Err(e) => {
        let _globals = crate::test_process_globals::lock();
/// This is the single chokepoint that enforces the footer-only invariant: every
        let mut buf: Vec<u8> = Vec::new();
 *
        // Already footer-only — keep the existing Arc, avoid a rebuild.
    }
            Err(e) => log_cache_error("clear", &e.to_string()),
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
 * SPDX-License-Identifier: Apache-2.0
use parking_lot::RwLock;
/*
        let props = WriterProperties::builder()
        let mut w = ArrowWriter::try_new(&mut buf, schema, Some(props)).unwrap();
        self.miss_count.load(Ordering::Relaxed)
            Arc::new(CachedParquetMetaData::new(Arc::clone(&pq))),
    static SECOND: Lazy<Arc<RuntimeEnv>> = Lazy::new(|| Arc::new(RuntimeEnv::default()));
        )
                let result = cache.get(k);
    }
    }
                if result.is_some() {
    pub fn get_cache_limit(&self) -> usize {
    fn update_cache_limit(&self, limit: usize) {
use datafusion::datasource::physical_plan::parquet::metadata::CachedParquetMetaData;
        }
            &bytes.clone(),
            }
    fn get(&self, k: &Path) -> Option<CachedFileMetadataEntry> {
            Ok(cache) => cache.clear(),
    }
};
        }
    }
        match self.inner.lock() {
// Wrapper to make Mutex<DefaultFilesMetadataCache> implement FileMetadataCache
    fn name(&self) -> String {
            "footer stats must survive"
        .build();
        }
            strip_page_index(v)
        assert!(
        // the entry before caching. The level-1 cache stays footer-only; page-level
                } else {
}
    }
    }
use object_store::path::Path;
    }
            .downcast_ref::<CachedParquetMetaData>()
                log_cache_error("cache_limit", &e.to_string());
        let pq = meta.metadata().clone();
            .unwrap();
        CachedFileMetadataEntry::new(object_meta(bytes), Arc::new(CachedParquetMetaData::new(pq)))
    // Rebuild without the page index. The heavy decoded `ColumnIndex` /
        );
            .unwrap();
                result
        match self.inner.lock() {
            &bytes.clone(),
    }
pub const CACHE_TYPE_STATS: &str = "STATISTICS";
        .as_any()
            }
    }
/// isn't a `CachedParquetMetaData` at all — it's returned unchanged (no clone, no
use datafusion::execution::runtime_env::RuntimeEnv;
        match self.inner.lock() {
            .file_metadata
            Ok(cache) => cache.put(k, v),
        );
use datafusion::execution::cache::cache_manager::{
    fn list_entries(&self) -> std::collections::HashMap<Path, FileMetadataCacheEntry> {
pub const CACHE_TYPE_METADATA: &str = "METADATA";
            }
impl MutexFileMetadataCache {
        let read_back = global_runtime_env().expect("the later environment must be readable");
        self.miss_count.store(0, Ordering::Relaxed);
use datafusion::execution::cache::CacheAccessor;
    use once_cell::sync::Lazy;
    )
            page_index_present(&entry),
        return entry;
            .file_metadata
    static FIRST: Lazy<Arc<RuntimeEnv>> = Lazy::new(|| Arc::new(RuntimeEnv::default()));
pub fn global_runtime_env() -> Option<Arc<RuntimeEnv>> {
}
        register_global_runtime_env(&SECOND);
}
        let v = if is_scoped_page_index_enabled() {
                None
            Ok(cache) => cache.update_cache_limit(limit),
            Ok(cache) => cache.len(),
mod global_cache_registry_tests {
            m.row_group(0).column(0).statistics().is_some(),
                    self.miss_count.fetch_add(1, Ordering::Relaxed);
    pub fn reset_stats(&self) {
            schema.clone(),
