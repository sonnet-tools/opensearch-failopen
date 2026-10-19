#[tokio::test]
fn test_resolve_range_suffix_uses_registry_size() {
    // A subsequent get returns None — no crash.
#[tokio::test]
#[tokio::test]
    assert_eq!(
        .get_opts(&Path::from("missing.parquet"), GetOptions::default())
        })
        )
        512,
        h.await.expect("task should not panic");
}
    tiered.set_remote(Arc::clone(&error_remote));
        )
    let results = tiered
#[tokio::test]
        .unwrap();
    assert!(paths.contains(&"data/evicted.parquet".to_string()));
        .await
        .unwrap();
        &range_cache_key("seg/a.parquet", 0, 4),
        .register_file("a.parquet", FileLocation::Local, None)
// Helper: create a local entry (reused by guard tests above).
    Arc<TieredStorageRegistry>,
            .lock()
    assert_eq!(guard.ref_count(), 1);
}
        Bytes::from_static(b"d"),
        tiered.resolve_range("z.parquet", &GetRange::Offset(10)),
        .register_file(
    let tiered = Arc::new(tiered);
    );
        .get_opts(&Path::from("a.parquet"), GetOptions::default())
    let bytes = result.bytes().await.unwrap();
        result.unwrap_err(),
        .collect();
            "a.parquet",
            "a.parquet",
        .put(&remote_path, PutPayload::from_static(b"remote-data"))
        .await
use object_store::memory::InMemory;
    let results = tiered
    assert!(matches!(
    let tiered = Arc::new(tiered);
            "data/evicted.parquet",
        .collect::<Result<Vec<_>, _>>()
    assert!(registry.get("a.parquet").is_some());
    );
        .unwrap();
        .unwrap();
        .put(
        )
        .await
async fn test_head_directory_path_returns_not_found_when_registry_empty() {
#[tokio::test]
}
            .unwrap()
}
        Err(object_store::Error::NotSupported { .. })
impl ObjectStore for ErrorStore {
        cache.evicted.lock().unwrap().as_slice(),
    ) -> OsResult<Box<dyn MultipartUpload>> {
    assert!(registry.get("a.parquet").is_some());
#[test]
// -- ReadGuard scope / ref-count tests ----------------------------------
            FileLocation::Remote,
}
        .unwrap();
        .count();
    let guard2 = registry.get("a.parquet").unwrap();
        .unwrap();
    ) -> OsResult<PutResult> {
    // Guard was dropped, ref count should be 0.
        e.acquire();
}
    Arc<InMemory>,
    }
/// Helper: create a registry + tiered store backed by in-memory stores.
#[async_trait]
    assert_eq!(guard.ref_count(), 1); // Only this guard.
    registry.register(
    tiered
        )
        .unwrap();
        .unwrap();
        .await
        .await
            FileLocation::Remote,
// -- Delete -------------------------------------------------------------
        Self {
        .put(&Path::from("a.parquet"), PutPayload::from_static(b"data"))
    assert!(result.is_err());
}
    // so a successful read proves the bytes were served from the cache.
        self
            "a.parquet",
            PutPayload::from_static(b"data"),
        "data tier must NOT be populated by put_metadata"
            FileLocation::Remote,
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
    local
        FileLocation::Remote,
    fn clear(&self) -> std::pin::Pin<Box<dyn std::future::Future<Output = ()> + Send + '_>> {
        .unwrap();
        .await;
    ));
    }
#[tokio::test]
        Box::pin(async {})
    ) -> OsResult<PutResult> {
#[tokio::test]
    tiered.set_remote(Arc::clone(&mock_remote) as _);
            FileLocation::Remote,
    let (registry, _local, _remote, tiered) = setup();
            "a.parquet",
    }
        .unwrap();
        .with_cache(Arc::clone(&cache) as Arc<dyn BlockCache>);
        &self,
            Some("remote/a.parquet".into()),
        .get_opts(&Path::from("a.parquet"), GetOptions::default())
    let (_registry, _local, _remote, tiered) = setup();
    let error_remote: Arc<dyn ObjectStore> = Arc::new(ErrorStore);
    fn new() -> Self {
        handles.push(tokio::spawn(async move {
        .await
    assert!(result.is_err(), "head should fail when remote errors");
            FileLocation::Remote,
        2048,
        .put(
        result.unwrap_err(),
        assert_eq!(guard.ref_count(), 1);
        )
    }
        .iter()
    // No cache attached — must be a no-op, not a panic.
    assert_eq!(
        &self,
    registry.register("data/parquet/a.parquet", entry);
        self.data
            FileLocation::Remote,
        .put(
    let (registry, _local, _cache, tiered) = setup_with_cache();
        _opts: PutOptions,
    let (_registry, _local, remote, tiered) = setup();
        .unwrap();
        cache.meta.lock().unwrap().is_empty(),
// -- Mock store for call tracking ---------------------------------------
        .unwrap();
    assert_eq!(results[1].as_ref(), b"567", "miss fetched from local store");
#[async_trait]
        .unwrap();
        let k = key.as_str().to_string();
        self.inner.get_opts(location, options).await
        )
        self.meta
    let (registry, _local, remote, tiered) = setup();
use futures::StreamExt;
    // Guard was dropped before the remote call, so ref count should be 0.
    remote
    mock_remote
    let (_registry, local, remote, tiered) = setup();
    let result = tiered.register_file("/a.parquet", FileLocation::Remote, None);
        )
    let key = range_cache_key("a.parquet", 936, 1000);
    tiered
#[tokio::test]
            FileLocation::Remote,
        }));
            Some("remote/a.parquet".into()),
    (registry, local, cache, tiered)
    local
    let opts = GetOptions {
    let local = Arc::new(InMemory::new());
    );
/// Minimal in-memory [`BlockCache`] for unit-testing TieredObjectStore's cache
    // Registry entry still exists.
        .await
async fn test_evict_path_evicts_cache_prefix() {
async fn test_get_opts_routes_to_local_when_not_in_registry() {
        .await
            source: "simulated error".into(),
        )
    }
async fn test_get_ranges_multiple_from_remote() {
use opensearch_block_cache::traits::BlockCache;
            FileLocation::Remote,
        .await
#[tokio::test]
async fn test_put_metadata_noop_without_cache() {
        .await
            &Path::from("data/local.parquet"),
// -- List tests ---------------------------------------------------------
    });
        .register_file(
            &Path::from("remote/evicted.parquet"),
    meta: Mutex<HashMap<String, Bytes>>,
            PutPayload::from_static(b"0123456789"),
fn test_delete_during_active_guard() {
    assert!(result.is_err(), "ErrorStore should return an error");
            &Path::from("remote/evicted.parquet"),
            })
// -- Error store --------------------------------------------------------
    let (_registry, _local, remote, tiered) = setup();
    let (_registry, local, remote, tiered) = setup();
                .bytes()
        )
        .put(
            Some("remote/a.parquet".into()),
#[tokio::test]
        None
        Bytes::from_static(b"BBBB"),
        .put(
}
    fn delete_stream(
    assert!(matches!(
    // A get_opts miss populates the DATA tier (never the metadata tier).
        .await
    assert!(
async fn test_successful_remote_read_releases_ref_count() {
#[test]
#[tokio::test]
            Some("remote/evicted.parquet".into()),
}
            PutPayload::from_static(b"local-data"),
    // While reads are in flight, delete the file.
        TieredFileEntry::with_size(FileLocation::Local, None, 1000),
    let tiered = TieredObjectStore::new(registry, local as _);
    registry.register("a.parquet", local_entry());
    assert_eq!(meta.size, 4);
    tiered.set_remote(Arc::clone(&error_remote));
        }
        .put(
#[test]
#[tokio::test]
        "a.parquet",
        &'a self,
        )
#[tokio::test]
impl fmt::Display for ErrorStore {
        .unwrap();
        &self,
    assert_eq!(results[0].as_ref(), b"AAAA", "hit served from cache");
    let local = Arc::new(InMemory::new());
    let (_registry, _local, _remote, tiered) = setup();
    // Get another guard — ref_count should be 1, not 2.
    // This guard adds 1, so underlying should have been 0 before.
        .register_file(
    local
    assert_eq!(bytes.as_ref(), b"234");
async fn test_concurrent_read_and_delete() {
use std::sync::Mutex;
    let (_registry, _local, _remote, tiered) = setup();
            FileLocation::Remote,
    );
    let tiered = TieredObjectStore::new(Arc::clone(&registry), Arc::clone(&local) as _)
    local
}
        })
            Some("remote/evicted.parquet".into()),
    // Register local file in registry — list() returns registry entries only
        .register_file("data/a.parquet", FileLocation::Local, None)
        .put(
        .unwrap();
        &self,
            .lock()
}
    assert_eq!(
    fn list(&self, prefix: Option<&Path>) -> BoxStream<'static, OsResult<ObjectMeta>> {
        .register_file(
    assert!(paths.contains(&"data/local.parquet".to_string()));
        .unwrap();
        .get_opts(&Path::from("a.parquet"), opts)
#[tokio::test]
    };
#[tokio::test]
        .await
            source: "simulated error".into(),
        .filter(|m| m.location.as_ref() == "data/a.parquet")
#[tokio::test]
#[tokio::test]
    let local = Arc::new(InMemory::new());
    let local = Arc::new(InMemory::new());
}
    let (_registry, _local, _remote, tiered) = setup();
        location: &Path,
            PutPayload::from_static(b"0123456789"),
fn setup() -> (
        .register_file(
        TieredFileEntry::with_size(FileLocation::Local, None, 1000),
    }
    let result = local.get(&Path::from("new.parquet")).await.unwrap();
// -- Copy/rename not supported ------------------------------------------
    assert_eq!(
    }
            PutPayload::from_static(b"0123456789"),
            PutPayload::from_static(b"new-data"),
    assert!(registry.get("missing.parquet").is_some());
        )
    ) -> BoxStream<'static, OsResult<Path>> {
            &Path::from("remote/a.parquet"),
    // After all reads finish, registry should have 0 entries.
    remote
    tiered.set_remote(Arc::clone(&error_remote));
        .unwrap();
    tiered
async fn test_list_includes_remote_only_files() {
    assert_eq!(bytes.as_ref(), b"local-data");
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
fn test_resolve_range_offset_none_when_size_zero() {
    remote
    evicted: Mutex<Vec<String>>,
}
use bytes::Bytes;
    }
        .await
        )
        .await
    }
            PutPayload::from_static(b"remote-data"),
            .or_else(|| self.data.lock().unwrap().get(&k).cloned());
        )
async fn test_get_ranges_partial_miss_fetches_and_populates() {
        .await
        .get_ranges(&Path::from("a.parquet"), &[0..4, 5..8])
            .insert(key.as_str().to_string(), data);
        .await
        result,
        .unwrap();
    let mock_remote = Arc::new(CallCountingStore::new());
        let guard = registry.get("a.parquet").unwrap();
            &Path::from("a.parquet"),
    let entry = TieredFileEntry::with_size(
    assert_eq!(registry.len(), 1);
async fn test_get_range_from_remote() {
fn test_evict_path_noop_without_cache() {
/// `get` probes the metadata tier first, then the data tier.
    let registry = Arc::new(TieredStorageRegistry::new());
        self.inner.put_multipart_opts(location, opts).await
#[tokio::test]
// -- Cache routing tests (MockBlockCache) -----------------------------------
    local
        )
            source: "simulated error".into(),
    assert!(
        .await;
        Bytes::from_static(b"AAAA"),
    tiered
    let mut handles = Vec::new();
            "a.parquet",
            store: "ErrorStore",
async fn test_concurrent_get_opts_on_same_remote_file() {
        .await
}
async fn test_get_opts_routes_to_remote_for_remote_file() {
    let result = tiered.get_range(&Path::from("a.parquet"), 0..10).await;
    }
    // Force-remove while ref_count > 0.
        _location: &Path,
    tiered
    tiered
    registry.register(
        self.inner.delete_stream(locations)
    local
    tiered
async fn test_put_metadata_routes_to_metadata_tier_only() {
    fn delete_stream(
#[tokio::test]
#[tokio::test]
        "metadata tier populated"
        .get_ranges(&Path::from("a.parquet"), &[0..5, 5..10])
    async fn copy_opts(&self, from: &Path, to: &Path, options: CopyOptions) -> OsResult<()> {
}
    let (_registry, local, _remote, tiered) = setup();
        .await
    inner: InMemory,
            "a.parquet",
    tiered
    let (_registry, _local, remote, tiered) = setup();
}
                .await
async fn test_copy_returns_not_supported() {
        .await
        .unwrap();
    }
    let tiered = TieredObjectStore::new(Arc::clone(&registry), Arc::clone(&local) as _);
            store: "ErrorStore",
    );
            Some("remote/a.parquet".into()),
        .into_iter()
#[test]
    for h in handles {
        key: &'a CacheKey,
        .await
        self.data.lock().unwrap().clear();
    assert!(result.is_err(), "ErrorStore should return an error");
    assert_eq!(bytes.as_ref(), b"FOOTER");
#[tokio::test]
    cache.put(
    // size 0 (default) is filtered out → None.
}
#[tokio::test]
#[tokio::test]
        .put(
    ));
    let (_registry, local, _remote, tiered) = setup();
        .await
                .unwrap()
        .register_file(
    tiered.put_metadata("a.parquet", &[936..1000], &[Bytes::from_static(b"FOOTER")]);
            &Path::from("new.parquet"),
    let (registry, _local, _remote, tiered) = setup();
        )
        &range_cache_key("a.parquet", 4, 8),
    let (registry, _local, _remote, tiered) = setup();
        Some((10, 20))
        payload: PutPayload,
impl fmt::Display for CallCountingStore {
        .await;
            "a.parquet",
#[tokio::test]
    let results: Vec<ObjectMeta> = tiered
            "a.parquet",
        .put(
// -- register_file validation -------------------------------------------
    let guard = registry.get("a.parquet").unwrap();
async fn test_put_writes_local_and_registers() {
        Box::pin(async move { hit })
        .unwrap();
        result,
        .put(
        .register_file("data/local.parquet", FileLocation::Local, None)
    assert!(result.is_err(), "should error for non-existent remote path");
        1024,
    Arc<InMemory>,
    let registry = TieredStorageRegistry::new();
            &Path::from("remote/a.parquet"),
        range: Some(GetRange::Bounded(936..1000)),
            PutPayload::from_static(b"remote-data"),
    let (registry, _local, cache, tiered) = setup_with_cache();
    let (_registry, local, _remote, tiered) = setup();
    // Registry entry still exists (guard was dropped before I/O, entry not removed).
            FileLocation::Remote,
        .unwrap();
}
        .unwrap();
        "a.parquet",
        .into_iter()
    // Spawn 16 concurrent reads.
    let local = Arc::new(InMemory::new());
            Some("remote/a.parquet".into()),
        .put(
        Some((936, 1000))
fn test_guard_releases_on_scope_exit() {
    let (registry, _local, remote, tiered) = setup();
        tiered.resolve_range("a.parquet", &GetRange::Suffix(64)),
    let result = tiered
        .get_opts(&Path::from("a.parquet"), GetOptions::default())
    assert_eq!(registry.len(), 0, "registry entry should be removed");
                .await;
            PutPayload::from_static(b"data"),
    get_count: AtomicUsize,
            t.get_opts(&Path::from("a.parquet"), GetOptions::default())
    let (registry, local, _remote, tiered) = setup();
    let remote = Arc::new(InMemory::new());
    );
        .await
}
        )
    );
        .map(|m| m.location.to_string())
        )
        .unwrap()
    for h in handles {
/// routing without pulling in real Foyer. Mirrors TieredBlockCache semantics:
    let tiered = TieredObjectStore::new(Arc::clone(&registry), local as _);
        .unwrap();
        mock_remote.get_count.load(AtomicOrdering::SeqCst),
        _opts: PutMultipartOptions,
        &range_cache_key("a.parquet", 0, 4),
    let bytes = tiered
}
}
        cache.data.lock().unwrap().is_empty(),
    let (_registry, _local, _remote, tiered) = setup();
        .unwrap();
}
    async fn put_multipart_opts(
        1,
    let (_registry, local, _remote, tiered) = setup();
    remote
    remote
    registry.register(
        })
        .put(
    assert!(matches!(
}
        .get_opts(&Path::from("local.parquet"), GetOptions::default())
    assert_eq!(
use super::*;
            FileLocation::Remote,
        ..Default::default()
    fn put(&self, key: &CacheKey, data: Bytes) {
            "a.parquet",
        location: &Path,
    let result = tiered.copy(&Path::from("a"), &Path::from("b")).await;
            inner: InMemory::new(),
async fn test_head_returns_local_metadata() {
    assert_eq!(
async fn test_head_directory_path_returns_synthetic_when_registry_has_entries() {
    registry.register("data/parquet/c.parquet", entry);
    {
}
async fn test_get_opts_routes_to_local_for_local_file() {
        let hit = self
        Bytes::from_static(b"m"),
async fn test_error_store_guard_still_releases() {
        .register_file(
    tiered
        let t = Arc::clone(&tiered);
            Some("remote/a.parquet".into()),
async fn test_get_range_error_from_remote_still_completes() {
        opts: PutOptions,
    }
    let meta = tiered.head(&Path::from("a.parquet")).await.unwrap();
    let _ = tiered
    // Registry entry still exists.
        .await
    Arc<InMemory>,
    tiered
async fn test_put_multipart_opts_not_supported() {
        tiered.resolve_range("missing.parquet", &GetRange::Suffix(64)),
    }
    tiered.put_metadata("a.parquet", &[0..10], &[Bytes::from_static(b"0123456789")]);
    (registry, local, remote, tiered)
                .get_opts(&Path::from("a.parquet"), GetOptions::default())
        FileLocation::Remote,
}
}
async fn test_put_metadata_served_from_cache_on_get_opts() {
    let registry = Arc::new(TieredStorageRegistry::new());
        write!(f, "ErrorStore")
    registry.register("a.parquet", local_entry());
    );
    let bytes = result.bytes().await.unwrap();
    );
    }
    async fn copy_opts(&self, _from: &Path, _to: &Path, _options: CopyOptions) -> OsResult<()> {
    );
    remote
    let result = tiered
            &Path::from("a.parquet"),
        .bytes()
#[test]
    let results = tiered
        "data tier populated on miss"
        Err(object_store::Error::Generic {
        .get_range(&Path::from("a.parquet"), 2..5)
            get_count: AtomicUsize::new(0),
        .unwrap();
    assert_eq!(registry.len(), 1);
            .unwrap()
    // head() on a directory path should return NotFound — DataFusion uses list()
impl ObjectStore for CallCountingStore {
    }
        &range_cache_key("seg/a.parquet", 4, 8),
        self.get_count.fetch_add(1, AtomicOrdering::SeqCst);
#[test]
    assert_eq!(results[1].as_ref(), b"567");
        removed,
#[tokio::test]
        TieredFileEntry::with_size(FileLocation::Local, None, 1000),
        &self,
        .await
            Some("remote/a.parquet".into()),
        "a.parquet",
}
struct MockBlockCache {
            &Path::from("data/a.parquet"),
        .head(&Path::from("data/parquet/nonexistent.parquet"))
            Some("remote/a.parquet".into()),
        )
        .await
            .meta
        TieredFileEntry::with_size(FileLocation::Local, None, 10),
        .await
        tiered.resolve_range("a.parquet", &GetRange::Offset(100)),
        .await
    );
}
        .unwrap();
        )
    let (_registry, _local, remote, tiered) = setup();
        "exactly 1 call to remote get_opts"
        self.inner.list_with_delimiter(prefix).await
            FileLocation::Remote,
    fn put_metadata(&self, key: &CacheKey, data: Bytes) {
async fn test_failed_remote_read_not_found_still_completes() {
            common_prefixes: vec![],
            &Path::from("a.parquet"),
// -- Routing tests ------------------------------------------------------
            PutPayload::from_static(b"data"),
            .lock()
    local
        Bytes::from_static(b"AAAA"),
            &Path::from("remote/a.parquet"),
    // Empty local store proves the cache served the read.
        self.inner.list(prefix)
            .get(&k)
        }))
    for _ in 0..16 {
        .register_file(
            objects: vec![],
            &Path::from("remote/a.parquet"),
    assert!(registry.get("a.parquet").is_some());
        .unwrap();
        })
        )
        "data tier cleared for the evicted prefix"
async fn test_head_directory_path_with_trailing_slash() {
        .register_file(
        .register_file(
    assert!(result.is_err());
    assert!(result.is_ok(), "local file should still exist");
        )
impl BlockCache for MockBlockCache {
    );
        .unwrap();
    assert!(result.is_err());
}
    let tiered = TieredObjectStore::new(Arc::clone(&registry), local as _);
    let result = tiered
    tiered
    tiered.evict_path("seg/a.parquet");
        Err(object_store::Error::NotSupported { .. })
    let result = tiered
// -- head() directory existence check tests ---------------------------------
// -- resolve_range tests ----------------------------------------------------
// -- Ref count balance --------------------------------------------------
        )
        "a.parquet",
    local
impl CallCountingStore {
    assert_eq!(registry.len(), 1);
    let result = tiered.head(&Path::from("a.parquet")).await;
        "metadata tier cleared for the evicted prefix"
    );
    assert!(matches!(
        .get_ranges(&Path::from("a.parquet"), &[0..4, 4..8])
    assert_eq!(
#[tokio::test]
            Some("remote/a.parquet".into()),
        .unwrap();
    remote
    assert!(
            &Path::from("local.parquet"),
    Arc<MockBlockCache>,
        .await
    let error_remote: Arc<dyn ObjectStore> = Arc::new(ErrorStore);
    tiered
        .objects
}
        let t = Arc::clone(&tiered);
    fn as_any(&self) -> &dyn std::any::Any {
        range: Some(GetRange::Bounded(0..4)),
        cache.data.lock().unwrap().contains_key(key.as_str()),
        .await
        write!(f, "CallCountingStore")
        .register_file(
        Err(object_store::Error::NotSupported { .. })
        )
        )
    registry.register(
            PutPayload::from_static(b"local-data"),
            FileLocation::Remote,
#[tokio::test]
        Err(object_store::Error::Generic {
fn test_resolve_range_offset_uses_registry_size() {
    let opts = GetOptions {
    data: Mutex<HashMap<String, Bytes>>,
    assert_eq!(registry.len(), 0);
    let entry = TieredFileEntry::with_size(
        .unwrap();
        "force remove should succeed even with active ref count"
        .unwrap();
        .unwrap();
) {
        .put(
    let registry = Arc::new(TieredStorageRegistry::new());
            Some("remote/nonexistent.parquet".into()),
    let result = tiered.head(&Path::from("data/parquet")).await;
    // Register a file so registry is non-empty
            Some("remote/a.parquet".into()),
#[tokio::test]
            &Path::from("remote/a.parquet"),
        )
        .await;
    registry.register(
    tiered.delete(&Path::from("a.parquet")).await.unwrap();
            PutOptions::default(),
    let result = local.get(&Path::from("a.parquet")).await;
        .await
    registry.register(
    assert_eq!(guard.ref_count(), 1); // Only this guard.
    let meta = tiered.head(&Path::from("a.parquet")).await.unwrap();
#[tokio::test]
    registry.register("z.parquet", TieredFileEntry::new(FileLocation::Local, None));
        .unwrap();
    Arc<TieredStorageRegistry>,
        result,
    let tiered = TieredObjectStore::new(Arc::clone(&registry), local as _);
        self.meta.lock().unwrap().clear();
            PutPayload::from_static(b"data"),
async fn test_get_opts_miss_populates_data_tier() {
            // the important thing is no panic.
        "a.parquet",
    // Entry is gone.
        .unwrap();
            &Path::from("data/local.parquet"),
    let local = Arc::new(InMemory::new());
        cache.meta.lock().unwrap().contains_key(key.as_str()),
    // Register a file so registry is non-empty
    ) -> OsResult<Box<dyn MultipartUpload>> {
fn setup_with_cache() -> (
    let result = tiered
    let (registry, _local, _remote, tiered) = setup();
            "a.parquet",
        .rename_if_not_exists(&Path::from("a"), &Path::from("b"))
        _payload: PutPayload,
struct CallCountingStore {
        .await;
        .await
#[test]
            .cloned()
}
    let (_registry, _local, _remote, tiered) = setup();
            .lock()
    }
        TieredFileEntry::with_size(FileLocation::Local, None, 1000),
async fn test_get_ranges_empty_returns_empty() {
}
    local
        )
}
        TieredFileEntry::with_size(FileLocation::Local, None, 10),
    let result = tiered.head(&Path::from("data/parquet/")).await;
    async fn list_with_delimiter(&self, _prefix: Option<&Path>) -> OsResult<ListResult> {
    // Register a Remote file pointing to a path that doesn't exist on the remote store.
    async fn put_opts(
    assert!(result.is_err());
    assert_eq!(bytes.as_ref(), b"remote-data");
        // guard drops here
        cache.data.lock().unwrap().contains_key(miss_key.as_str()),
        handles.push(tokio::spawn(async move {
            let _ = t
    // Pre-seed only [0,4); [5,8) misses and is fetched from local.
                source: "simulated error".into(),
async fn test_head_file_path_not_treated_as_directory() {
}
    registry.register("data/parquet/b.parquet", entry);
    // No registry entry → size unavailable → cache bypassed (None).
    assert_eq!(meta.size, 11);
    // Not in registry, not local → NotFound
    tiered
        .collect::<Result<Vec<_>, _>>()
}
    let miss_key = range_cache_key("a.parquet", 5, 8);
    // File not found locally. Register as Remote with ErrorStore.
        .inner
#[tokio::test]
}
    let result = tiered
        .put_multipart_opts(&Path::from("a"), PutMultipartOptions::default())
            &Path::from("remote/a.parquet"),
        .put(
    assert!(result.is_err());
    let paths: Vec<String> = result
        .iter()
    assert!(
    let (registry, _local, cache, tiered) = setup_with_cache();
        .unwrap();
// -- Head ---------------------------------------------------------------
    tiered.evict_path("x");
    assert!(matches!(
    }
    let guard = registry.get("a.parquet").unwrap();
        )
    }
    tiered.delete(&Path::from("a.parquet")).await.unwrap();
            .retain(|k, _| !k.starts_with(prefix));
    assert!(result.is_empty());
            .unwrap()
    let local = Arc::new(InMemory::new());
        self.meta
        .unwrap();
    // Bounded needs no registry/size — returned verbatim.
                .unwrap()
    }
    tiered
        .unwrap();
        .await;
    tiered
    let (_registry, _local, cache, tiered) = setup_with_cache();
    let (registry, _local, _remote, tiered) = setup();
        .unwrap();
#[test]
    }
    // All reads done, ref count should be 0.
    cache.put_metadata(
async fn test_list_with_delimiter_includes_remote() {
        .unwrap();
    );
        .unwrap();
        .await
    );
    let (_registry, _local, _remote, tiered) = setup();
            // Each read may succeed or fail depending on timing with delete;
    let registry = TieredStorageRegistry::new();
        .unwrap();
    let (registry, local, cache, tiered) = setup_with_cache();
        .put(&Path::from("a.parquet"), PutPayload::from_static(b"data"))
#[derive(Default)]
#[tokio::test]
            .retain(|k, _| !k.starts_with(prefix));
    let result = tiered.head(&Path::from("data/parquet")).await;
                store: "ErrorStore",
        "miss range populated into data tier"
        .await
            FileLocation::Remote,
        tiered.resolve_range("any.parquet", &GetRange::Bounded(10..20)),
        .unwrap();
        self.data
            FileLocation::Remote,
    let (registry, local, _remote, tiered) = setup();
    );
    async fn put_multipart_opts(
        .await
    );
        .unwrap();
}
        Err(object_store::Error::NotSupported {
    tiered.set_remote(Arc::clone(&error_remote));
#[tokio::test]
        .unwrap();
        Err(object_store::Error::Generic {
    assert_eq!(results[0].as_ref(), b"AAAA");
    let result = tiered
    );
        .get_ranges(&Path::from("a.parquet"), &[0..3, 5..8])
    let guard = registry.get("a.parquet").unwrap();
            "a.parquet",
    TieredObjectStore,
    );
    let result = tiered
        Ok(ListResult {
        "get_opts must not populate metadata tier"
    async fn get_opts(&self, location: &Path, options: GetOptions) -> OsResult<GetResult> {
            Some("remote/a.parquet".into()),
    assert_eq!(bytes.as_ref(), b"new-data");
    async fn get_opts(&self, _location: &Path, _options: GetOptions) -> OsResult<GetResult> {
#[derive(Debug)]
    let (_registry, local, _remote, tiered) = setup();
    assert_eq!(registry.len(), 1);
struct ErrorStore;
    );
// -- put_multipart_opts -------------------------------------------------
    let remote_path = Path::from("remote/a.parquet");
    let error_remote: Arc<dyn ObjectStore> = Arc::new(ErrorStore);
        .unwrap();
async fn test_get_ranges_error_from_remote_still_completes() {
    }
            "data/evicted.parquet",
    fn evict_prefix(&self, prefix: &str) {
    tiered
    let results: Vec<ObjectMeta> = tiered
    let (registry, local, cache, tiered) = setup_with_cache();
    let mut handles = Vec::new();
        .list_with_delimiter(Some(&Path::from("data")))
        &range_cache_key("a.parquet", 0, 4),
async fn test_delete_removes_registry_entry_only() {
    let registry = Arc::new(TieredStorageRegistry::new());
    // No cache attached — must be a no-op, not a panic.
}
    let (registry, _local, _remote, tiered) = setup();
    let (registry, _local, _remote, tiered) = setup();
    ) -> BoxStream<'static, OsResult<Path>> {
    let result = tiered
        .unwrap();
    );
        .register_file(
        .put(&Path::from("a.parquet"), PutPayload::from_static(b"data"))
    assert_eq!(count, 1, "local file should appear exactly once");
            PutPayload::from_static(b"local"),
    assert!(paths.contains(&"data/local.parquet".to_string()));
            PutPayload::from_static(b"data"),
            Err(object_store::Error::Generic {
    tiered
    let cache = Arc::new(MockBlockCache::default());
    assert!(
}
        FileLocation::Remote,
    let bytes = tiered
#[test]
    let registry = Arc::new(TieredStorageRegistry::new());
        None
        .unwrap();
        _location: &Path,
    cache.put(
    tiered.put_metadata("a.parquet", &[936..1000], &[Bytes::from_static(b"FOOTER")]);
    }
            .lock()
}
        .list(Some(&Path::from("data")))
        self.evicted.lock().unwrap().push(prefix.to_string());
    assert!(result.is_err());
        let bytes = h.await.unwrap();
}
            .unwrap()
            PutPayload::from_static(b"remote-data"),
        .unwrap();
        .put(
    // Registry entry still exists.
        self.inner.copy_opts(from, to, options).await
}
        object_store::Error::NotFound { .. }
        .get_opts(&Path::from("a.parquet"), GetOptions::default())
    ));
#[tokio::test]
        )
    let bytes = result.bytes().await.unwrap();
#[tokio::test]
    TieredFileEntry::new(FileLocation::Local, None)
    let result = tiered
    tiered
        !cache.meta.lock().unwrap().contains_key(key.as_str()),
        Some((100, 1000))
    assert!(
        .unwrap();
    let result = tiered
    assert!(result.is_err());
    let bytes = tiered
    tiered
        locations: BoxStream<'static, OsResult<Path>>,
    let entry = TieredFileEntry::with_size(
        .put_opts(
}
        .unwrap();
fn test_register_file_remote_without_remote_path_returns_err() {
        .register_file(
    let (registry, _local, remote, tiered) = setup();
    );
// -- Put ----------------------------------------------------------------
    let local = Arc::new(InMemory::new());
    }
    let paths: Vec<String> = results.iter().map(|m| m.location.to_string()).collect();
    let count = results
        .await
    // Registry is empty — directory doesn't "exist"
}
        Box::pin(locations.map(|_| {
    let bytes = result.bytes().await.unwrap();
    );
        )
            "missing.parquet",
#[tokio::test]
    let (_registry, _local, _remote, tiered) = setup();
use object_store::{CopyOptions, ObjectStoreExt, PutPayload};
        .unwrap()
    assert!(paths.contains(&"data/evicted.parquet".to_string()));
            "a.parquet",
    );
    registry.register(
        .await
    );
        !cache.data.lock().unwrap().contains_key(key.as_str()),
    let _ = tiered
#[derive(Debug)]
use opensearch_block_cache::range_cache::{range_cache_key, CacheKey};
        &self,
    let registry = Arc::new(TieredStorageRegistry::new());
    assert_eq!(bytes.as_ref(), b"0123");
        .unwrap();
    );
        )
async fn test_head_not_found() {
            store: "ErrorStore",
) {
    let error_remote: Arc<dyn ObjectStore> = Arc::new(ErrorStore);
        self.inner.put_opts(location, payload, opts).await
    local
        }));
fn test_resolve_range_suffix_none_when_unregistered() {
    for _ in 0..16 {
}
        assert_eq!(bytes.as_ref(), b"data");
        .unwrap();
            .insert(key.as_str().to_string(), data);
            PutPayload::from_static(b"0123456789"),
    // Trailing slash also treated as directory — returns NotFound
}
        Some(Arc::from("remote/a.parquet")),
#[tokio::test]
        .await
// -- Range reads --------------------------------------------------------
        )
    assert_eq!(results.len(), 2);
        &["seg/a.parquet".to_string()]
    assert_eq!(results[1].as_ref(), b"BBBB");
        })
    assert!(
// -- Error / edge-case tests --------------------------------------------
        locations: BoxStream<'static, OsResult<Path>>,
        ..Default::default()
async fn test_get_ranges_full_hit_served_from_cache() {
    assert_eq!(bytes.as_ref(), b"local-data");
    ) -> std::pin::Pin<Box<dyn std::future::Future<Output = Option<Bytes>> + Send + 'a>> {
    let removed = registry.remove("a.parquet", true);
    }
        .register_file(
        "a.parquet",
    fn get<'a>(
        .register_file("a.parquet", FileLocation::Local, None)
    let (_registry, _local, _remote, tiered) = setup();
    // Suffix(64) → (size - 64, size).
        .await
fn test_resolve_range_bounded_returns_bounds_directly() {
        .get_opts(&Path::from("a.parquet"), opts)
    remote
        futures::stream::empty().boxed()
    // Local file should still exist (delete only removes registry entry).
            source: "not supported".into(),
#[tokio::test]
        .collect::<Vec<_>>()
    // All reads should complete (Arc keeps store alive). No panics.
    // to discover files in directories, not head(). Returning NotFound tells
    );
    assert_eq!(registry.len(), 1);
    assert_eq!(registry.len(), 0);
    );
    registry.update("a.parquet", |e| {
}
    }
    async fn put_opts(
use std::sync::atomic::{AtomicUsize, Ordering as AtomicOrdering};
use std::collections::HashMap;
    }
    tiered
    ));
    };
        opts: PutMultipartOptions,
            .unwrap()
    cache.put(
        Some(Arc::from("remote/b.parquet")),
    let tiered = TieredObjectStore::new(Arc::clone(&registry), local as _);
        Some(Arc::from("remote/c.parquet")),
                .await
}
    // Warmup promotes the footer range into the metadata tier. No local file exists,
    ));
        .unwrap();
        object_store::Error::NotFound { .. }
}
    async fn list_with_delimiter(&self, prefix: Option<&Path>) -> OsResult<ListResult> {
        .get_opts(&Path::from("a.parquet"), GetOptions::default())
    // The previously-missing range is now cached.
}
    tiered.set_remote(Arc::clone(&remote) as _);
            PutPayload::from_static(b"local"),
    fn list(&self, _prefix: Option<&Path>) -> BoxStream<'static, OsResult<ObjectMeta>> {
            Some("remote/a.parquet".into()),
    assert!(registry.get("a.parquet").is_none());
}
    // head() on a file path (has extension) should NOT use directory check
        .get_ranges(&Path::from("a.parquet"), &[])
async fn test_head_falls_back_to_remote() {
    // DataFusion "this is not a file" and it proceeds to list().
    // Simulate an active reader via manual acquire (doesn't hold DashMap Ref).
        )
        .unwrap();
    // — it should try registry lookup, then remote, then local
    let tiered = TieredObjectStore::new(Arc::clone(&registry), local as _);
}
    cache.put(
fn local_entry() -> TieredFileEntry {
    assert_eq!(results[0].as_ref(), b"012");
    // Offset(100) → (100, size).
    }
        .register_file(
        TieredFileEntry::with_size(FileLocation::Local, None, 100),
async fn test_head_remote_fallback_error_still_completes() {
        "a.parquet",
    );
async fn test_mock_store_exactly_one_call_per_get_opts() {
        .list(Some(&Path::from("data")))
        .unwrap();
}
        .collect::<Vec<_>>()
    }
}
    TieredObjectStore,
}
        .put(
    );
async fn test_list_no_duplicates_for_local_files() {
    let registry = Arc::new(TieredStorageRegistry::new());
            &Path::from("remote/a.parquet"),
    let registry = Arc::new(TieredStorageRegistry::new());
async fn test_rename_returns_not_supported() {
    assert!(
}
}
    remote
    let result = tiered.head(&Path::from("nonexistent")).await;
// -- Concurrency --------------------------------------------------------
    assert_eq!(guard2.ref_count(), 1, "previous guard should have released");
        .bytes()
    let key = range_cache_key("a.parquet", 0, 4);
