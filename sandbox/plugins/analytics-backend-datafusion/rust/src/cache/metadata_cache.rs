    }
pub const CACHE_TYPE_OFFSET_INDEX: &str = "OFFSET_INDEX";
            .as_any()
    }
    use once_cell::sync::Lazy;
        .as_any()
    }
        }
        assert!(
        let got = cache.get(&key).expect("entry must be retrievable");
        assert!(
            Ok(cache) => {
            .build();
                "cache_error".to_string()
        }
    }
        entry.meta,
                0
            Err(e) => {
#[cfg(test)]
    #[test]
        let entry = CachedFileMetadataEntry::new(
            .set_statistics_enabled(EnabledStatistics::Page)
            location: Path::from("data.parquet"),
 *
/// `ColumnIndex` / `OffsetIndex`). If the entry already lacks a page index — or
    pub inner: Mutex<DefaultFilesMetadataCache>,
            .file_metadata
            cache.clear();
        match self.inner.lock() {
    /// Held in statics: the registry keeps only a `Weak`, so an environment dropped at test end
            ArrowReaderOptions::new().with_page_index(true),
            page_index_present(&entry),
            last_modified: chrono::Utc::now(),
            }
/// The registered environment, or `None` before a global runtime exists or after the last one was
    fn object_meta(bytes: &Bytes) -> ObjectMeta {
///
        match self.inner.lock() {
                log_cache_error("remove", &e.to_string());
                std::collections::HashMap::new()
        // `PageIndexPolicy::ReadAll`, so the full index is present to retain.
}
    fn put(&self, k: &Path, v: CachedFileMetadataEntry) -> Option<CachedFileMetadataEntry> {
    GLOBAL_RUNTIME_ENV.read().as_ref().and_then(Weak::upgrade)
        let meta = ArrowReaderMetadata::load(
            .set_data_page_row_count_limit(128)
        // including page indexes so DataFusion's default page pruning path continues
}
        let cached = got
    }
use parking_lot::RwLock;
    miss_count: AtomicUsize,
                    self.hit_count.fetch_add(1, Ordering::Relaxed);
        assert!(
pub const CACHE_TYPE_METADATA: &str = "METADATA";
    let meta = cached.parquet_metadata();
    pub fn get_cache_limit(&self) -> usize {
        let pq = meta.metadata().clone();
            }
            Ok(cache) => cache.put(k, v),
            Err(e) => log_cache_error("update_cache_limit", &e.to_string()),
    #[test]
 * compatible open source license.
        .into_builder()
        );
    crate::test_process_globals::assert_held("the global DataFusion RuntimeEnv registration");
        if let Ok(cache) = self.inner.lock() {
        match self.inner.lock() {
            v
            "precondition: entry has page index"
            Ok(cache) => cache.update_cache_limit(limit),
        assert!(pq.column_index().is_none() && pq.offset_index().is_none());
            0
                log_cache_error("put", &e.to_string());
use std::sync::atomic::{AtomicUsize, Ordering};
            }
        }
    fn get(&self, k: &Path) -> Option<CachedFileMetadataEntry> {
    }
}
        self.miss_count.load(Ordering::Relaxed)
        assert!(
mod global_cache_registry_tests {
    }
        }
        if let Ok(cache) = self.inner.lock() {
    fn cache_limit(&self) -> usize {
}
        register_global_runtime_env(&SECOND);
    log_error!("[CACHE ERROR] {} operation failed: {}", operation, error);
}
    fn page_index_present(entry: &CachedFileMetadataEntry) -> bool {
}
/// rebuild).
            strip_page_index(v)
            }
        return entry;
            Err(e) => {
        assert!(m.num_row_groups() > 0);
use object_store::path::Path;
    fn remove(&self, k: &Path) -> Option<CachedFileMetadataEntry> {
        .unwrap();
    #[test]
        // When scoped page-index is enabled: strip ColumnIndex + OffsetIndex from
        )
#[cfg(test)]
use datafusion::execution::cache::cache_manager::{
use datafusion::parquet::file::metadata::ParquetMetaData;
            !page_index_present(&got),
                log_cache_error("get", &e.to_string());
                0
    /// would leave a dead registration for the next test in this binary.
            Ok(cache) => cache.len(),
fn strip_page_index(entry: CachedFileMetadataEntry) -> CachedFileMetadataEntry {
        match self.inner.lock() {
impl FileMetadataCache for MutexFileMetadataCache {
            .unwrap();
    fn contains_key(&self, k: &Path) -> bool {
        // to function. In this mode `load_parquet_metadata` fetches with
            object_meta(&bytes),
        );
    let Some(cached) = entry
            "cached entry must be footer-only after put"
        let batch = RecordBatch::try_new(
pub const CACHE_TYPE_STATS: &str = "STATISTICS";
        let bytes = parquet_with_page_index();
            Arc::new(CachedParquetMetaData::new(Arc::clone(&pq))),
    fn len(&self) -> usize {
        let v = if is_scoped_page_index_enabled() {
        )
        .set_offset_index(None)
        if let Ok(cache) = self.inner.lock() {
 */
            }
impl CacheAccessor<Path, CachedFileMetadataEntry> for MutexFileMetadataCache {
        let pq = meta.metadata().clone();
            }
            .downcast_ref::<CachedParquetMetaData>()
    pub fn new(cache: DefaultFilesMetadataCache) -> Self {
// Wrapper to make Mutex<DefaultFilesMetadataCache> implement FileMetadataCache
        } else {
        }
        let props = WriterProperties::builder()
/*
        cache.put(&key, entry);
        }
            .as_any()
    }
            Ok(cache) => cache.clear(),
    if meta.column_index().is_none() && meta.offset_index().is_none() {
                if result.is_some() {
                    self.miss_count.fetch_add(1, Ordering::Relaxed);
    static FIRST: Lazy<Arc<RuntimeEnv>> = Lazy::new(|| Arc::new(RuntimeEnv::default()));
        // pruning is handled by the scoped cache (`parquet_page_cache`).
    #[test]
        let key = Path::from("data.parquet");
    // Rebuild without the page index. The heavy decoded `ColumnIndex` /
            Arc::ptr_eq(&FIRST, &read_back),
            &bytes.clone(),
        let m = cached.parquet_metadata();
    fn name(&self) -> String {
 * SPDX-License-Identifier: Apache-2.0
            miss_count: AtomicUsize::new(0),
    pub fn update_cache_limit(&self, new_limit: usize) {
            version: None,
        }
        match self.inner.lock() {
            cache.update_cache_limit(new_limit);
        Arc::new(CachedParquetMetaData::new(Arc::new(stripped))),
        let cached = stripped
    }
        match self.inner.lock() {
        let meta = ArrowReaderMetadata::load(
    fn parquet_with_page_index() -> Bytes {
    fn update_cache_limit(&self, limit: usize) {
        let bytes = parquet_with_page_index();
    }
        let read_back = global_runtime_env().expect("a registered environment must be readable");
            hit_count: AtomicUsize::new(0),
/// closed.
}
                None
            Ok(cache) => cache.list_entries(),
    };
        );
        // the entry before caching. The level-1 cache stays footer-only; page-level
use datafusion::datasource::physical_plan::parquet::metadata::CachedParquetMetaData;
    }
            .unwrap();
use datafusion::execution::runtime_env::RuntimeEnv;
        }
    fn strip_is_noop_for_footer_only_entry() {
                log_cache_error("cache_limit", &e.to_string());
        assert!(
    use datafusion::parquet::arrow::ArrowWriter;
            }
/// registration never keeps a closed runtime alive.
            }
        );
             memory budget"
        .set_column_index(None)
        } else {
pub struct MutexFileMetadataCache {
        );
            "footer-only entry must be returned unchanged (same Arc)"
    fn put_strips_page_index_and_get_returns_footer_only() {
            &bytes.clone(),
        assert!(pq.column_index().is_some() && pq.offset_index().is_some());
        ObjectMeta {
            m.row_group(0).column(0).statistics().is_some(),
fn log_cache_error(operation: &str, error: &str) {
    CachedFileMetadataEntry::new(
        m.column_index().is_some() || m.offset_index().is_some()
        let entry = full_index_entry(&bytes);
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
        register_global_runtime_env(&FIRST);
                false
        }
                result
};
 * this file be licensed under the Apache-2.0 license or a
        match self.inner.lock() {
    pub fn hit_count(&self) -> usize {
        CachedFileMetadataEntry::new(object_meta(bytes), Arc::new(CachedParquetMetaData::new(pq)))
}
                let result = cache.get(k);
                log_cache_error("list_entries", &e.to_string());
            size: bytes.len() as u64,
        .file_metadata
    // (row-group + column chunk stats) is preserved.
            Ok(cache) => cache.name(),
    }
    let stripped = ParquetMetaData::clone(meta)
static GLOBAL_RUNTIME_ENV: RwLock<Option<Weak<RuntimeEnv>>> = RwLock::new(None);
        Bytes::from(buf)
                }
        w.write(&batch).unwrap();
        .build();
            .as_any()
    pub fn clear_cache(&self) {
            .downcast_ref::<CachedParquetMetaData>()
use crate::parquet_page_cache::is_scoped_page_index_enabled;
    hit_count: AtomicUsize,
            .unwrap();
        w.close().unwrap();
            Err(e) => {
            Err(e) => {
    use super::*;
            vec![Arc::new(Int64Array::from((0..4096i64).collect::<Vec<_>>()))],
        // When scoped page-index is disabled (fallback mode): retain the full entry
                log_cache_error("len", &e.to_string());
        register_global_runtime_env(&FIRST);
    }
            Ok(cache) => cache.cache_limit(),
/// The global runtime's `RuntimeEnv`, for callers that have none to read it from. Sharing the whole
    use datafusion::arrow::array::{Int64Array, RecordBatch};
/// This is the single chokepoint that enforces the footer-only invariant: every
        .downcast_ref::<CachedParquetMetaData>()
    }
    }
            "footer stats must survive"
        Self {
 * The OpenSearch Contributors require contributions made to
            .file_metadata
}
        let read_back = global_runtime_env().expect("the later environment must be readable");
                } else {
                None
/// isn't a `CachedParquetMetaData` at all — it's returned unchanged (no clone, no
        let m = cached.parquet_metadata();
            Ok(cache) => cache.remove(k),
        }
        };
        return entry;
use datafusion::execution::cache::CacheAccessor;
    }
    }
        match self.inner.lock() {
    }
/// environment keeps a caller's cache and memory budget consistent with the node's. `Weak`, so a
        }
    #[cfg(test)]
    pub fn miss_count(&self) -> usize {
        let mut buf: Vec<u8> = Vec::new();
    }
        let _globals = crate::test_process_globals::lock();
        let _globals = crate::test_process_globals::lock();
    }
    CachedFileMetadataEntry, FileMetadataCache, FileMetadataCacheEntry,
    // `OffsetIndex` are released when the original Arc drops; the footer
            Err(e) => {
    }
            cache.cache_limit()
        }
        self.hit_count.load(Ordering::Relaxed)
    fn a_registered_runtime_env_reads_back_as_the_same_object() {
pub fn register_global_runtime_env(runtime_env: &Arc<RuntimeEnv>) {
            Err(e) => {
    fn list_entries(&self) -> std::collections::HashMap<Path, FileMetadataCacheEntry> {
            Err(e) => log_cache_error("clear", &e.to_string()),
            Arc::ptr_eq(cached.parquet_metadata(), &pq),
        }
    }
    )
pub fn global_runtime_env() -> Option<Arc<RuntimeEnv>> {
        self.hit_count.store(0, Ordering::Relaxed);
/// `put` runs the entry through here before it lands in the shared LRU.
            ArrowReaderOptions::new().with_page_index(false),
    else {
            e_tag: None,
        let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
// Cache type constants
        .unwrap();
        assert!(!Arc::ptr_eq(&FIRST, &read_back));
    }
/// Return a cache entry whose `ParquetMetaData` carries footer-only metadata (no
        let stripped = strip_page_index(entry);
impl MutexFileMetadataCache {
        assert!(Arc::ptr_eq(&SECOND, &read_back));
    use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
    *GLOBAL_RUNTIME_ENV.write() = Some(Arc::downgrade(runtime_env));
        let cache = MutexFileMetadataCache::new(DefaultFilesMetadataCache::new(64 * 1024 * 1024));
            .downcast_ref::<CachedParquetMetaData>()
        let cached = entry
    use object_store::ObjectMeta;
        );
        }
            inner: Mutex::new(cache),
    use super::*;
            schema.clone(),
            .file_metadata
        match self.inner.lock() {
            Err(e) => {
                None
            Err(e) => {
    }
    fn full_index_entry(bytes: &Bytes) -> CachedFileMetadataEntry {
        }
        //
        let mut w = ArrowWriter::try_new(&mut buf, schema, Some(props)).unwrap();
mod strip_page_index_tests {
            "readers must share one environment, otherwise each caller gets its own cache and \
            }
    fn clear(&self) {
        match self.inner.lock() {
                log_cache_error("contains_key", &e.to_string());
        .unwrap();
        self.miss_count.store(0, Ordering::Relaxed);
    }
use datafusion::execution::cache::DefaultFilesMetadataCache;
use native_bridge_common::log_error;
                log_cache_error("name", &e.to_string());
    use prost::bytes::Bytes;
use std::sync::{Arc, Mutex, Weak};
    fn a_later_registration_replaces_the_earlier_one() {
}
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
        )
            Ok(cache) => cache.contains_key(k),
    static SECOND: Lazy<Arc<RuntimeEnv>> = Lazy::new(|| Arc::new(RuntimeEnv::default()));
/// Called once per `create_global_runtime`; a later runtime replaces the registration.
pub const CACHE_TYPE_COLUMN_INDEX: &str = "COLUMN_INDEX";
    pub fn reset_stats(&self) {
        // Already footer-only — keep the existing Arc, avoid a rebuild.
    }
