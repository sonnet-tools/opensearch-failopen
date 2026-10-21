}
        Box::pin(locations.map(|_| {
        .unwrap();
// -- Delete -------------------------------------------------------------
        .await
        "a.parquet",
        let k = key.as_str().to_string();
        .register_file("a.parquet", FileLocation::Local, None)
) {
    assert_eq!(results[1].as_ref(), b"567", "miss fetched from local store");
        .await
        .unwrap();
        .list(Some(&Path::from("data")))
    );
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
fn local_entry() -> TieredFileEntry {
    tiered.delete(&Path::from("a.parquet")).await.unwrap();
            Some("remote/nonexistent.parquet".into()),
#[test]
    // Register a file so registry is non-empty
        .unwrap();
    let local = Arc::new(InMemory::new());
        self.evicted.lock().unwrap().push(prefix.to_string());
        .unwrap();
async fn test_put_metadata_routes_to_metadata_tier_only() {
use std::collections::HashMap;
    tiered
    let results: Vec<ObjectMeta> = tiered
use opensearch_block_cache::range_cache::{range_cache_key, CacheKey};
    let local = Arc::new(InMemory::new());
            FileLocation::Remote,
}
    local
async fn test_get_ranges_full_hit_served_from_cache() {
// -- Put ----------------------------------------------------------------
#[derive(Debug)]
use std::sync::Mutex;
    let bytes = result.bytes().await.unwrap();
        write!(f, "ErrorStore")
#[tokio::test]
        )
            "missing.parquet",
        .unwrap();
        tiered.resolve_range("any.parquet", &GetRange::Bounded(10..20)),
        TieredFileEntry::with_size(FileLocation::Local, None, 1000),
// -- Ref count balance --------------------------------------------------
    let error_remote: Arc<dyn ObjectStore> = Arc::new(ErrorStore);
    tiered
    let registry = Arc::new(TieredStorageRegistry::new());
    // Guard was dropped, ref count should be 0.
        .register_file(
    remote
        })
    Arc<InMemory>,
    let mut handles = Vec::new();
// Helper: create a local entry (reused by guard tests above).
            &Path::from("data/a.parquet"),
}
    assert_eq!(results[1].as_ref(), b"BBBB");
    let tiered = Arc::new(tiered);
    assert!(paths.contains(&"data/evicted.parquet".to_string()));
        assert_eq!(guard.ref_count(), 1);
        .put(
            &Path::from("data/local.parquet"),
    tiered
    data: Mutex<HashMap<String, Bytes>>,
    let (_registry, _local, _remote, tiered) = setup();
}
        .put(
#[tokio::test]
    assert_eq!(
}
    let (registry, local, cache, tiered) = setup_with_cache();
            .lock()
    let registry = Arc::new(TieredStorageRegistry::new());
    let (registry, _local, remote, tiered) = setup();
async fn test_head_file_path_not_treated_as_directory() {
    assert!(paths.contains(&"data/local.parquet".to_string()));
    for h in handles {
}
    assert_eq!(
    }
        None
    }
        Some(Arc::from("remote/c.parquet")),
    let remote_path = Path::from("remote/a.parquet");
            Some("remote/evicted.parquet".into()),
    remote
    let tiered = TieredObjectStore::new(Arc::clone(&registry), local as _);
        "a.parquet",
    assert!(matches!(
        .objects
        .head(&Path::from("data/parquet/nonexistent.parquet"))
    remote
    );
    assert_eq!(registry.len(), 1);
#[async_trait]
    let miss_key = range_cache_key("a.parquet", 5, 8);
    );
        .await
    assert_eq!(bytes.as_ref(), b"remote-data");
        result,
    let (_registry, local, remote, tiered) = setup();
#[tokio::test]
    tiered
async fn test_get_opts_routes_to_local_when_not_in_registry() {
        &self,
        .await
struct ErrorStore;
        locations: BoxStream<'static, OsResult<Path>>,
    tiered
        cache.meta.lock().unwrap().contains_key(key.as_str()),
        .put(
    // A get_opts miss populates the DATA tier (never the metadata tier).
        cache.evicted.lock().unwrap().as_slice(),
#[tokio::test]
        .unwrap();
// -- Error / edge-case tests --------------------------------------------
    local
        .await
        let t = Arc::clone(&tiered);
fn test_resolve_range_suffix_uses_registry_size() {
    tiered.evict_path("seg/a.parquet");
            &Path::from("remote/a.parquet"),
#[tokio::test]
            &Path::from("remote/a.parquet"),
        .unwrap();
        self.get_count.fetch_add(1, AtomicOrdering::SeqCst);
        .unwrap();
// -- Error store --------------------------------------------------------
        .put(
}
    tiered
async fn test_get_opts_routes_to_local_for_local_file() {
        .get_opts(&Path::from("local.parquet"), GetOptions::default())
    local
            .lock()
    // This guard adds 1, so underlying should have been 0 before.
    let registry = Arc::new(TieredStorageRegistry::new());
    }
        .put(
        "miss range populated into data tier"
        "metadata tier populated"
        self.meta
            PutPayload::from_static(b"0123456789"),
        .unwrap();
    assert_eq!(bytes.as_ref(), b"FOOTER");
        .await
async fn test_get_ranges_empty_returns_empty() {
}
    let (_registry, _local, remote, tiered) = setup();
async fn test_concurrent_get_opts_on_same_remote_file() {
    let (registry, _local, _remote, tiered) = setup();
        .unwrap();
        )
    assert_eq!(
#[async_trait]
    let error_remote: Arc<dyn ObjectStore> = Arc::new(ErrorStore);
    }
    }
            PutPayload::from_static(b"remote-data"),
    tiered.delete(&Path::from("a.parquet")).await.unwrap();
        .put(
        Err(object_store::Error::Generic {
            &Path::from("a.parquet"),
    }
            "a.parquet",
// -- Routing tests ------------------------------------------------------
    };
    ) -> OsResult<Box<dyn MultipartUpload>> {
    let local = Arc::new(InMemory::new());
    let (registry, local, cache, tiered) = setup_with_cache();
        .get_ranges(&Path::from("a.parquet"), &[0..3, 5..8])
        cache.data.lock().unwrap().is_empty(),
    let (registry, _local, cache, tiered) = setup_with_cache();
    let local = Arc::new(InMemory::new());
    registry.register(
}
        let bytes = h.await.unwrap();
        .register_file(
            PutPayload::from_static(b"0123456789"),
impl BlockCache for MockBlockCache {
        range: Some(GetRange::Bounded(0..4)),
        .await
    let result = local.get(&Path::from("new.parquet")).await.unwrap();
        .unwrap();
#[tokio::test]
    assert_eq!(
        .await
}
    fn delete_stream(
    assert!(result.is_err());
async fn test_get_opts_miss_populates_data_tier() {
    cache.put_metadata(
        h.await.expect("task should not panic");
        .await
        .get_ranges(&Path::from("a.parquet"), &[0..5, 5..10])
        .unwrap();
    tiered
        .await;
        .register_file(
    remote
            FileLocation::Remote,
        .unwrap();
#[derive(Default)]
        self.meta
        .collect::<Vec<_>>()
            .cloned()
        .await
        .await;
            })
        )
    assert_eq!(registry.len(), 1);
            FileLocation::Remote,
        .await
    // All reads should complete (Arc keeps store alive). No panics.
    let (registry, _local, _remote, tiered) = setup();
        FileLocation::Remote,
    );
    }
        .collect();
}
            // Each read may succeed or fail depending on timing with delete;
    remote
            FileLocation::Remote,
    ) -> OsResult<Box<dyn MultipartUpload>> {
}
}
    registry.register("data/parquet/a.parquet", entry);
    );
        )
    // Spawn 16 concurrent reads.
        TieredFileEntry::with_size(FileLocation::Local, None, 10),
        }
            Err(object_store::Error::Generic {
    );
            PutPayload::from_static(b"0123456789"),
#[test]
    tiered.put_metadata("a.parquet", &[0..10], &[Bytes::from_static(b"0123456789")]);
        .register_file("a.parquet", FileLocation::Local, None)
        .await
    let tiered = Arc::new(tiered);
        _location: &Path,
    let key = range_cache_key("a.parquet", 936, 1000);
        !cache.meta.lock().unwrap().contains_key(key.as_str()),
        &range_cache_key("a.parquet", 0, 4),
#[tokio::test]
    for _ in 0..16 {
        Err(object_store::Error::NotSupported { .. })
        .await
    let registry = TieredStorageRegistry::new();
    assert!(result.is_err());
    let tiered = TieredObjectStore::new(Arc::clone(&registry), local as _);
    // Registry entry still exists.
fn test_evict_path_noop_without_cache() {
async fn test_rename_returns_not_supported() {
        .get_opts(&Path::from("a.parquet"), GetOptions::default())
    let result = tiered
    // Local file should still exist (delete only removes registry entry).
fn setup_with_cache() -> (
    let local = Arc::new(InMemory::new());
            &Path::from("remote/evicted.parquet"),
    let error_remote: Arc<dyn ObjectStore> = Arc::new(ErrorStore);
        opts: PutMultipartOptions,
async fn test_list_no_duplicates_for_local_files() {
        .register_file(
        removed,
            FileLocation::Remote,
    ) -> OsResult<PutResult> {
        .register_file(
    ) -> BoxStream<'static, OsResult<Path>> {
            "data/evicted.parquet",
    });
    let opts = GetOptions {
            PutPayload::from_static(b"local"),
    registry.register(
            "a.parquet",
        self.inner.delete_stream(locations)
    ));
            .unwrap()
    }
    cache.put(
        .await
        .get_ranges(&Path::from("a.parquet"), &[0..4, 4..8])
    let result = tiered
    }
    let (registry, _local, _remote, tiered) = setup();
    assert_eq!(registry.len(), 0);
    ) -> BoxStream<'static, OsResult<Path>> {
        "a.parquet",
        .put(&remote_path, PutPayload::from_static(b"remote-data"))
            &Path::from("a.parquet"),
    let tiered = TieredObjectStore::new(Arc::clone(&registry), local as _);
        .await
            "a.parquet",
        handles.push(tokio::spawn(async move {
        .unwrap();
            FileLocation::Remote,
            store: "ErrorStore",
}
    async fn get_opts(&self, _location: &Path, _options: GetOptions) -> OsResult<GetResult> {
    TieredObjectStore,
        })
    let registry = Arc::new(TieredStorageRegistry::new());
            // the important thing is no panic.
    let (registry, local, _remote, tiered) = setup();
        .await
        .unwrap();
        &self,
async fn test_put_metadata_noop_without_cache() {
    async fn put_opts(
    let entry = TieredFileEntry::with_size(
    (registry, local, cache, tiered)
// -- List tests ---------------------------------------------------------
        Bytes::from_static(b"AAAA"),
}
    );
            store: "ErrorStore",
            FileLocation::Remote,
        &self,
    // Registry entry still exists.
        TieredFileEntry::with_size(FileLocation::Local, None, 1000),
use object_store::{CopyOptions, ObjectStoreExt, PutPayload};
    // Registry is empty — directory doesn't "exist"
#[tokio::test]
async fn test_error_store_guard_still_releases() {
    );
    // Guard was dropped before the remote call, so ref count should be 0.
}
    tiered.put_metadata("a.parquet", &[936..1000], &[Bytes::from_static(b"FOOTER")]);
// -- Copy/rename not supported ------------------------------------------
use opensearch_block_cache::traits::BlockCache;
    assert_eq!(results[0].as_ref(), b"012");
    registry.register(
        .put(
}
    assert!(result.is_ok(), "local file should still exist");
    let (_registry, _local, _remote, tiered) = setup();
    // File not found locally. Register as Remote with ErrorStore.
        &'a self,
    }
            FileLocation::Remote,
}
        .into_iter()
        tiered.resolve_range("missing.parquet", &GetRange::Suffix(64)),
    assert!(result.is_err());
        .collect::<Result<Vec<_>, _>>()
async fn test_evict_path_evicts_cache_prefix() {
    assert!(matches!(
    let result = tiered.head(&Path::from("data/parquet")).await;
        .list_with_delimiter(Some(&Path::from("data")))
    );
    assert!(matches!(
        .unwrap();
            &Path::from("new.parquet"),
    // Register a Remote file pointing to a path that doesn't exist on the remote store.
        )
                .await;
    tiered
        .unwrap();
    // head() on a directory path should return NotFound — DataFusion uses list()
#[test]
    ) -> std::pin::Pin<Box<dyn std::future::Future<Output = Option<Bytes>> + Send + 'a>> {
    let result = tiered.get_range(&Path::from("a.parquet"), 0..10).await;
        .map(|m| m.location.to_string())
            "a.parquet",
    }
        .iter()
        .unwrap();
        .await;
    async fn list_with_delimiter(&self, _prefix: Option<&Path>) -> OsResult<ListResult> {
fn test_resolve_range_offset_none_when_size_zero() {
    meta: Mutex<HashMap<String, Bytes>>,
        .unwrap();
use bytes::Bytes;
            "a.parquet",
        Some(Arc::from("remote/b.parquet")),
        )
    // DataFusion "this is not a file" and it proceeds to list().
        self.inner.get_opts(location, options).await
        .unwrap();
/// routing without pulling in real Foyer. Mirrors TieredBlockCache semantics:
        object_store::Error::NotFound { .. }
    // No cache attached — must be a no-op, not a panic.
        .unwrap();
        .unwrap();
        TieredFileEntry::with_size(FileLocation::Local, None, 1000),
            "a.parquet",
/// Minimal in-memory [`BlockCache`] for unit-testing TieredObjectStore's cache
        )
        self.inner.list_with_delimiter(prefix).await
        Self {
    // Suffix(64) → (size - 64, size).
    );
struct CallCountingStore {
        .into_iter()
        range: Some(GetRange::Bounded(936..1000)),
    assert_eq!(guard.ref_count(), 1); // Only this guard.
    );
    assert_eq!(results[1].as_ref(), b"567");
    assert_eq!(results.len(), 2);
        .unwrap();
        .await
        .count();
        self.data.lock().unwrap().clear();
        .unwrap();
        })
    local
fn test_register_file_remote_without_remote_path_returns_err() {
            Some("remote/evicted.parquet".into()),
        )
    let error_remote: Arc<dyn ObjectStore> = Arc::new(ErrorStore);
        .rename_if_not_exists(&Path::from("a"), &Path::from("b"))
}
        _opts: PutOptions,
            &Path::from("a.parquet"),
#[tokio::test]
            common_prefixes: vec![],
        )
#[tokio::test]
        .register_file(
/// Helper: create a registry + tiered store backed by in-memory stores.
        )
    tiered.set_remote(Arc::clone(&error_remote));
        Some((100, 1000))
#[tokio::test]
use object_store::memory::InMemory;
    assert_eq!(bytes.as_ref(), b"234");
        .await
        write!(f, "CallCountingStore")
    assert!(result.is_err());
        result.unwrap_err(),
    let result = tiered
#[test]
    ));
            FileLocation::Remote,
        tiered.resolve_range("z.parquet", &GetRange::Offset(10)),
}
    local
    assert!(result.is_empty());
    registry.register(
            get_count: AtomicUsize::new(0),
            .unwrap()
    let result = tiered
        .get_opts(&Path::from("a.parquet"), opts)
            PutPayload::from_static(b"data"),
    assert!(registry.get("a.parquet").is_some());
#[tokio::test]
use std::sync::atomic::{AtomicUsize, Ordering as AtomicOrdering};
}
        "metadata tier cleared for the evicted prefix"
        }));
#[tokio::test]
    // head() on a file path (has extension) should NOT use directory check
            &Path::from("remote/a.parquet"),
        }))
async fn test_copy_returns_not_supported() {
            PutPayload::from_static(b"remote-data"),
        .unwrap();
            "a.parquet",
        Some((936, 1000))
            &Path::from("remote/a.parquet"),
#[test]
    async fn put_multipart_opts(
    let (registry, local, _remote, tiered) = setup();
        .unwrap();
        .await
// -- ReadGuard scope / ref-count tests ----------------------------------
    fn new() -> Self {
    fn list(&self, prefix: Option<&Path>) -> BoxStream<'static, OsResult<ObjectMeta>> {
        .await
            .lock()
    }
        key: &'a CacheKey,
// -- Cache routing tests (MockBlockCache) -----------------------------------
// -- Range reads --------------------------------------------------------
    registry.register(
}
    let (registry, _local, _remote, tiered) = setup();
            source: "not supported".into(),
async fn test_get_opts_routes_to_remote_for_remote_file() {
async fn test_delete_removes_registry_entry_only() {
        .unwrap();
    registry.update("a.parquet", |e| {
            Some("remote/a.parquet".into()),
async fn test_put_metadata_served_from_cache_on_get_opts() {
#[tokio::test]
    let (_registry, _local, remote, tiered) = setup();
            PutPayload::from_static(b"data"),
    }
    let meta = tiered.head(&Path::from("a.parquet")).await.unwrap();
    inner: InMemory,
    let result = tiered.head(&Path::from("a.parquet")).await;
        .await
    let (_registry, local, _remote, tiered) = setup();
    let tiered = TieredObjectStore::new(Arc::clone(&registry), local as _);
    let opts = GetOptions {
        TieredFileEntry::with_size(FileLocation::Local, None, 100),
        Box::pin(async move { hit })
    // Warmup promotes the footer range into the metadata tier. No local file exists,
// -- Mock store for call tracking ---------------------------------------
        )
    let registry = TieredStorageRegistry::new();
}
            .or_else(|| self.data.lock().unwrap().get(&k).cloned());
    // Pre-seed only [0,4); [5,8) misses and is fetched from local.
        self.meta.lock().unwrap().clear();
    let result = tiered
impl ObjectStore for CallCountingStore {
    async fn get_opts(&self, location: &Path, options: GetOptions) -> OsResult<GetResult> {
        TieredFileEntry::with_size(FileLocation::Local, None, 1000),
        object_store::Error::NotFound { .. }
            "a.parquet",
#[tokio::test]
}
}
        .unwrap();
        _location: &Path,
    fn put(&self, key: &CacheKey, data: Bytes) {
        )
#[tokio::test]
        2048,
    let (_registry, _local, _remote, tiered) = setup();
    local
        "force remove should succeed even with active ref count"
    let (_registry, _local, _remote, tiered) = setup();
            t.get_opts(&Path::from("a.parquet"), GetOptions::default())
/// `get` probes the metadata tier first, then the data tier.
                .get_opts(&Path::from("a.parquet"), GetOptions::default())
        )
        assert_eq!(bytes.as_ref(), b"data");
            &Path::from("remote/a.parquet"),
async fn test_head_not_found() {
    assert_eq!(guard.ref_count(), 1);
            Some("remote/a.parquet".into()),
    }
    Arc<TieredStorageRegistry>,
    let (_registry, _local, _remote, tiered) = setup();
        tiered.resolve_range("a.parquet", &GetRange::Offset(100)),
    );
        .await
        .unwrap();
        .await;
    }
    let (_registry, _local, cache, tiered) = setup_with_cache();
        .unwrap();
}
            Some("remote/a.parquet".into()),
    }
    (registry, local, remote, tiered)
#[tokio::test]
    // All reads done, ref count should be 0.
    assert_eq!(
    let local = Arc::new(InMemory::new());
#[test]
    }
                store: "ErrorStore",
            .insert(key.as_str().to_string(), data);
    assert_eq!(results[0].as_ref(), b"AAAA", "hit served from cache");
}
    async fn put_multipart_opts(
}
#[tokio::test]
    ) -> OsResult<PutResult> {
    );
    assert!(result.is_err());
    let _ = tiered
impl fmt::Display for ErrorStore {
    let result = tiered.copy(&Path::from("a"), &Path::from("b")).await;
    // Bounded needs no registry/size — returned verbatim.
        self.inner.put_multipart_opts(location, opts).await
        )
        opts: PutOptions,
    let result = local.get(&Path::from("a.parquet")).await;
fn test_resolve_range_bounded_returns_bounds_directly() {
            PutOptions::default(),
            PutPayload::from_static(b"data"),
        .register_file(
            FileLocation::Remote,
// -- put_multipart_opts -------------------------------------------------
    }
    tiered
        )
    let registry = Arc::new(TieredStorageRegistry::new());
    );
        payload: PutPayload,
    let mut handles = Vec::new();
            .unwrap()
    assert!(
        .register_file(
    cache.put(
    // While reads are in flight, delete the file.
        Bytes::from_static(b"BBBB"),
                .unwrap()
async fn test_get_ranges_partial_miss_fetches_and_populates() {
    let (registry, _local, remote, tiered) = setup();
async fn test_get_ranges_error_from_remote_still_completes() {
    let (registry, _local, _remote, tiered) = setup();
        handles.push(tokio::spawn(async move {
}
        self.data
    assert!(result.is_err(), "ErrorStore should return an error");
        .get_opts(&Path::from("a.parquet"), GetOptions::default())
}
    let (_registry, _local, _remote, tiered) = setup();
        )
        .await
            &Path::from("remote/a.parquet"),
            .get(&k)
    async fn copy_opts(&self, _from: &Path, _to: &Path, _options: CopyOptions) -> OsResult<()> {
        .unwrap();
            .lock()
    );
            store: "ErrorStore",
    // Get another guard — ref_count should be 1, not 2.
#[tokio::test]
    // size 0 (default) is filtered out → None.
    async fn list_with_delimiter(&self, prefix: Option<&Path>) -> OsResult<ListResult> {
    let count = results
                .unwrap()
            &Path::from("data/local.parquet"),
    assert!(
}
    local
    assert_eq!(
        Bytes::from_static(b"m"),
            Some("remote/a.parquet".into()),
    assert!(
        result,
    // Trailing slash also treated as directory — returns NotFound
#[tokio::test]
    let bytes = result.bytes().await.unwrap();
        .put(&Path::from("a.parquet"), PutPayload::from_static(b"data"))
        futures::stream::empty().boxed()
        Err(object_store::Error::NotSupported { .. })
        Box::pin(async {})
    let result = tiered
        FileLocation::Remote,
        .list(Some(&Path::from("data")))
    let entry = TieredFileEntry::with_size(
        .unwrap();
    cache.put(
        tiered.resolve_range("a.parquet", &GetRange::Suffix(64)),
#[tokio::test]
    assert_eq!(count, 1, "local file should appear exactly once");
    let result = tiered.register_file("/a.parquet", FileLocation::Remote, None);
        self
    remote
}
    let tiered = TieredObjectStore::new(Arc::clone(&registry), Arc::clone(&local) as _);
    let guard = registry.get("a.parquet").unwrap();
    registry.register(
            FileLocation::Remote,
    );
    registry.register("data/parquet/b.parquet", entry);
    }
    let cache = Arc::new(MockBlockCache::default());
    }
    );
        self.inner.copy_opts(from, to, options).await
async fn test_head_directory_path_returns_synthetic_when_registry_has_entries() {
        location: &Path,
fn test_delete_during_active_guard() {
        )
async fn test_head_remote_fallback_error_still_completes() {
    let results = tiered
    assert_eq!(bytes.as_ref(), b"new-data");
            Some("remote/a.parquet".into()),
// -- head() directory existence check tests ---------------------------------
        cache.data.lock().unwrap().contains_key(miss_key.as_str()),
    TieredObjectStore,
        .unwrap();
        &range_cache_key("a.parquet", 0, 4),
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        self.inner.put_opts(location, payload, opts).await
    async fn copy_opts(&self, from: &Path, to: &Path, options: CopyOptions) -> OsResult<()> {
// -- resolve_range tests ----------------------------------------------------
    assert!(registry.get("a.parquet").is_some());
    let (_registry, local, _remote, tiered) = setup();
        .unwrap();
            PutPayload::from_static(b"local"),
    let results = tiered
    let result = tiered.head(&Path::from("data/parquet/")).await;
        let guard = registry.get("a.parquet").unwrap();
#[tokio::test]
            &Path::from("local.parquet"),
// -- Concurrency --------------------------------------------------------
        .unwrap()
}
#[tokio::test]
            Some("remote/a.parquet".into()),
async fn test_head_returns_local_metadata() {
        Bytes::from_static(b"AAAA"),
        Err(object_store::Error::Generic {
}
        "data tier must NOT be populated by put_metadata"
    Arc<InMemory>,
#[tokio::test]
            Some("remote/a.parquet".into()),
async fn test_put_writes_local_and_registers() {
    }
        )
        .await
            Some("remote/a.parquet".into()),
            PutPayload::from_static(b"data"),
    );
    let results: Vec<ObjectMeta> = tiered
        )
            PutPayload::from_static(b"0123456789"),
#[tokio::test]
    // Offset(100) → (100, size).
    let paths: Vec<String> = results.iter().map(|m| m.location.to_string()).collect();
            .retain(|k, _| !k.starts_with(prefix));
    // Register a file so registry is non-empty
    let result = tiered
    registry.register("a.parquet", local_entry());
        .register_file(
        )
    assert!(paths.contains(&"data/evicted.parquet".to_string()));
    let local = Arc::new(InMemory::new());
async fn test_concurrent_read_and_delete() {
    // The previously-missing range is now cached.
            source: "simulated error".into(),
    let result = tiered.head(&Path::from("nonexistent")).await;
    }
async fn test_failed_remote_read_not_found_still_completes() {
    let registry = Arc::new(TieredStorageRegistry::new());
        .unwrap();
        .with_cache(Arc::clone(&cache) as Arc<dyn BlockCache>);
        .register_file("data/local.parquet", FileLocation::Local, None)
            objects: vec![],
            let _ = t
    let (_registry, _local, _remote, tiered) = setup();
    tiered.set_remote(Arc::clone(&error_remote));
    let (_registry, _local, remote, tiered) = setup();
    let registry = Arc::new(TieredStorageRegistry::new());
async fn test_get_range_from_remote() {
    assert_eq!(registry.len(), 0);
    for h in handles {
    tiered
        .get_ranges(&Path::from("a.parquet"), &[])
        .await
    assert!(result.is_err());
            .meta
impl ObjectStore for ErrorStore {
        .put(
#[tokio::test]
    assert_eq!(registry.len(), 1);
}
async fn test_head_directory_path_with_trailing_slash() {
async fn test_head_directory_path_returns_not_found_when_registry_empty() {
        Err(object_store::Error::Generic {
        )
        &range_cache_key("seg/a.parquet", 0, 4),
        .unwrap();
}
#[tokio::test]
}
) {
    let result = tiered
    TieredFileEntry::new(FileLocation::Local, None)
    // Registry entry still exists.
    // Empty local store proves the cache served the read.
        .put(
    tiered.set_remote(Arc::clone(&mock_remote) as _);
}
    }
        &self,
        &range_cache_key("seg/a.parquet", 4, 8),
        1,
    }
        "a.parquet",
    assert_eq!(registry.len(), 1);
fn test_resolve_range_suffix_none_when_unregistered() {
        "exactly 1 call to remote get_opts"
        .unwrap();
            "a.parquet",
        .put(
    };
    remote
    // so a successful read proves the bytes were served from the cache.
    assert!(
    }
    let (registry, _local, cache, tiered) = setup_with_cache();
    for _ in 0..16 {
        Bytes::from_static(b"d"),
        .unwrap();
    assert!(registry.get("missing.parquet").is_some());
    let local = Arc::new(InMemory::new());
    registry.register("a.parquet", local_entry());
    assert!(paths.contains(&"data/local.parquet".to_string()));
    assert!(result.is_err(), "ErrorStore should return an error");
    let bytes = tiered
    assert_eq!(bytes.as_ref(), b"0123");
        .get_opts(&Path::from("a.parquet"), GetOptions::default())
        TieredFileEntry::with_size(FileLocation::Local, None, 10),
        })
        .register_file(
    assert!(
        "a.parquet",
    );
// -- Head ---------------------------------------------------------------
    tiered
        .await
        .register_file(
}
        e.acquire();
            inner: InMemory::new(),
    let bytes = result.bytes().await.unwrap();
                .await
struct MockBlockCache {
    let key = range_cache_key("a.parquet", 0, 4);
    Arc<InMemory>,
            Some("remote/a.parquet".into()),
        .unwrap();
        .await
}
        .unwrap();
        .register_file(
    local
                .await
        .put(&Path::from("a.parquet"), PutPayload::from_static(b"data"))
    async fn put_opts(
        .unwrap();
    let guard2 = registry.get("a.parquet").unwrap();
}
        .put_opts(
        let hit = self
            Some("remote/a.parquet".into()),
            .unwrap()
    tiered.set_remote(Arc::clone(&error_remote));
    );
    );
    // Register local file in registry — list() returns registry entries only
        ..Default::default()
    assert!(registry.get("a.parquet").is_none());
        .await
    ));
        .get_opts(&Path::from("a.parquet"), GetOptions::default())
#[tokio::test]
        .bytes()
        &range_cache_key("a.parquet", 4, 8),
        1024,
}
        Err(object_store::Error::NotSupported {
    let (registry, _local, remote, tiered) = setup();
        .put(
        .unwrap();
    let (_registry, local, _remote, tiered) = setup();
        .unwrap();
    fn as_any(&self) -> &dyn std::any::Any {
    let registry = Arc::new(TieredStorageRegistry::new());
    assert!(registry.get("a.parquet").is_some());
        !cache.data.lock().unwrap().contains_key(key.as_str()),
            PutPayload::from_static(b"local-data"),
    assert_eq!(registry.len(), 0, "registry entry should be removed");
async fn test_list_with_delimiter_includes_remote() {
            "a.parquet",
        .put(
    assert!(matches!(
    let entry = TieredFileEntry::with_size(
    assert_eq!(meta.size, 4);
    let (_registry, _local, remote, tiered) = setup();
async fn test_successful_remote_read_releases_ref_count() {
    tiered
}
        .iter()
    local
// -- register_file validation -------------------------------------------
    ));
}
            .insert(key.as_str().to_string(), data);
            .unwrap()
    }
        .put(
        Ok(ListResult {
        .unwrap();
    tiered.put_metadata("a.parquet", &[936..1000], &[Bytes::from_static(b"FOOTER")]);
        None
        .register_file(
        .register_file(
        .await
        Some((10, 20))
    let meta = tiered.head(&Path::from("a.parquet")).await.unwrap();
    assert!(matches!(
        "a.parquet",
fn setup() -> (
        .put(
            FileLocation::Remote,
    // Simulate an active reader via manual acquire (doesn't hold DashMap Ref).
    assert!(result.is_err(), "should error for non-existent remote path");
        "data tier cleared for the evicted prefix"
    assert!(
        .unwrap();
        &self,
        "data tier populated on miss"
    assert_eq!(meta.size, 11);
#[tokio::test]
}
        location: &Path,
async fn test_list_includes_remote_only_files() {
#[test]
#[tokio::test]
}
        .unwrap();
    {
            source: "simulated error".into(),
#[tokio::test]
        &self,
        .collect::<Result<Vec<_>, _>>()
                source: "simulated error".into(),
}
        .unwrap();
        .get_opts(&Path::from("missing.parquet"), GetOptions::default())
}
    tiered
        )
    assert!(result.is_err(), "head should fail when remote errors");
}
    fn list(&self, _prefix: Option<&Path>) -> BoxStream<'static, OsResult<ObjectMeta>> {
    );
    let tiered = TieredObjectStore::new(Arc::clone(&registry), Arc::clone(&local) as _)
    let (_registry, local, _remote, tiered) = setup();
        .unwrap()
        .filter(|m| m.location.as_ref() == "data/a.parquet")
    assert_eq!(registry.len(), 1);
        _opts: PutMultipartOptions,
        cache.data.lock().unwrap().contains_key(key.as_str()),
        .await;
        )
}
    fn put_metadata(&self, key: &CacheKey, data: Bytes) {
    let (_registry, local, _remote, tiered) = setup();
        .collect::<Vec<_>>()
            &Path::from("remote/evicted.parquet"),
        )
    let _ = tiered
    let bytes = tiered
    }
        .await
    cache.put(
            source: "simulated error".into(),
    assert_eq!(bytes.as_ref(), b"local-data");
            .retain(|k, _| !k.starts_with(prefix));
use futures::StreamExt;
async fn test_put_multipart_opts_not_supported() {
        .unwrap();
        // guard drops here
            .lock()
    tiered
        let t = Arc::clone(&tiered);
        .unwrap();
    tiered
        .put(&Path::from("a.parquet"), PutPayload::from_static(b"data"))
        .get_ranges(&Path::from("a.parquet"), &[0..4, 5..8])
    mock_remote
    tiered
    fn evict_prefix(&self, prefix: &str) {
        .put(
    let paths: Vec<String> = result
    // — it should try registry lookup, then remote, then local
    Arc<MockBlockCache>,
    remote
        )
    // No cache attached — must be a no-op, not a panic.
use super::*;
    assert_eq!(guard.ref_count(), 1); // Only this guard.
        )
    assert_eq!(bytes.as_ref(), b"local-data");
}
    let result = tiered
        )
    let tiered = TieredObjectStore::new(registry, local as _);
        .await
        locations: BoxStream<'static, OsResult<Path>>,
        .unwrap();
    Arc<TieredStorageRegistry>,
    let mock_remote = Arc::new(CallCountingStore::new());
impl CallCountingStore {
        result,
async fn test_mock_store_exactly_one_call_per_get_opts() {
            Some("remote/a.parquet".into()),
            "data/evicted.parquet",
    );
    let (_registry, local, remote, tiered) = setup();
        .unwrap();
    remote
    // A subsequent get returns None — no crash.
    get_count: AtomicUsize,
        "get_opts must not populate metadata tier"
        self.data
        }));
        .await
    // Not in registry, not local → NotFound
    let results = tiered
        .await
        .get_range(&Path::from("a.parquet"), 2..5)
async fn test_head_falls_back_to_remote() {
            PutPayload::from_static(b"local-data"),
        .unwrap();
            PutPayload::from_static(b"new-data"),
        .await
async fn test_get_ranges_multiple_from_remote() {
    assert!(
    tiered
#[tokio::test]
        )
        ..Default::default()
    let bytes = tiered
    tiered.set_remote(Arc::clone(&remote) as _);
    let (_registry, _local, _remote, tiered) = setup();
    tiered.set_remote(Arc::clone(&error_remote));
#[test]
    let bytes = result.bytes().await.unwrap();
    );
#[tokio::test]
    registry.register("z.parquet", TieredFileEntry::new(FileLocation::Local, None));
        .await
    );
        .await;
#[tokio::test]
    tiered
        )
            FileLocation::Remote,
        .bytes()
    fn get<'a>(
    // Registry entry still exists (guard was dropped before I/O, entry not removed).
    assert_eq!(
        )
    assert_eq!(guard2.ref_count(), 1, "previous guard should have released");
            FileLocation::Remote,
}
    let (registry, _local, _remote, tiered) = setup();
        .inner
    let (registry, _local, _remote, tiered) = setup();
fn test_guard_releases_on_scope_exit() {
    local
    fn clear(&self) -> std::pin::Pin<Box<dyn std::future::Future<Output = ()> + Send + '_>> {
        .unwrap();
    ));
            PutPayload::from_static(b"remote-data"),
fn test_resolve_range_offset_uses_registry_size() {
#[tokio::test]
    let result = tiered.head(&Path::from("data/parquet")).await;
    tiered.evict_path("x");
async fn test_get_range_error_from_remote_still_completes() {
}
#[tokio::test]
        cache.meta.lock().unwrap().is_empty(),
#[test]
    assert!(result.is_err());
    registry.register("data/parquet/c.parquet", entry);
        .put(
    evicted: Mutex<Vec<String>>,
        )
        .unwrap();
        _payload: PutPayload,
    let (_registry, _local, _remote, tiered) = setup();
}
    let removed = registry.remove("a.parquet", true);
        FileLocation::Remote,
    tiered
        result.unwrap_err(),
        .await
impl fmt::Display for CallCountingStore {
    let tiered = TieredObjectStore::new(Arc::clone(&registry), local as _);
            Some("remote/a.parquet".into()),
}
            "a.parquet",
#[derive(Debug)]
    // to discover files in directories, not head(). Returning NotFound tells
                .bytes()
        512,
    registry.register(
    fn delete_stream(
    );
#[tokio::test]
    let guard = registry.get("a.parquet").unwrap();
        .get_opts(&Path::from("a.parquet"), GetOptions::default())
    );
        .unwrap();
    );
    assert!(
    // Force-remove while ref_count > 0.
    let remote = Arc::new(InMemory::new());
        self.inner.list(prefix)
            &Path::from("remote/a.parquet"),
            FileLocation::Remote,
        "a.parquet",
        .register_file("data/a.parquet", FileLocation::Local, None)
    let result = tiered
    );
        Err(object_store::Error::NotSupported { .. })
    tiered
    let guard = registry.get("a.parquet").unwrap();
        Some(Arc::from("remote/a.parquet")),
        .get_opts(&Path::from("a.parquet"), opts)
    assert_eq!(results[0].as_ref(), b"AAAA");
        .register_file(
        mock_remote.get_count.load(AtomicOrdering::SeqCst),
    // After all reads finish, registry should have 0 entries.
        .await
        })
        &["seg/a.parquet".to_string()]
    // No registry entry → size unavailable → cache bypassed (None).
        .put_multipart_opts(&Path::from("a"), PutMultipartOptions::default())
    }
    let result = tiered
    let (registry, _local, _cache, tiered) = setup_with_cache();
            "a.parquet",
    );
    // Entry is gone.
}
        )
}
            PutPayload::from_static(b"data"),
        .await
