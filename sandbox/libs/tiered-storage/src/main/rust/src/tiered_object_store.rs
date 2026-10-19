            .objects
    /// - `miss_indices`: original indices of the ranges that missed
                    e_tag: None,
    /// Promote `data` ranges to the never-evict metadata tier.
        self.registry.register(path, entry);
    /// probes the cache first. On hit (entry previously stored via `put_metadata`
        let entry = TieredFileEntry::new(FileLocation::Local, None);
        range: &GetRange,
/// (the never-evict Foyer SSD instance in production).
    ) -> BoxStream<'static, OsResult<Path>> {
    /// Store byte ranges directly into the metadata cache (never-evict tier).
                let path_str = path.as_ref();
#[async_trait]
        // Populate data Foyer for bounded-range reads so repeated single-range
    remote: std::sync::OnceLock<Arc<dyn ObjectStore>>,
            for (fetched_bytes, (&slot_i, miss_range)) in fetched
            location: location.clone(),
            native_bridge_common::log_debug!(
        }
            path_str,
        let mut miss_indices: Vec<usize> = Vec::new();
    /// No-op if no cache is attached (hot nodes or cache disabled).
        // that limit are silently skipped (no buffering needed for them either).
    }
    /// Resolve a GetRange to absolute (start, end) byte offsets.
        let cache = self.cache.as_ref()?;
        location: FileLocation,
        }
            return Some(Err(object_store::Error::NotFound {
                .try_serve_from_cache(path_str, location, get_range)
        location: &Path,
    }
                    location: location.clone(),
        native_bridge_common::log_debug!(
            path,
            &fetched,
use crate::registry::TieredStorageRegistry;
        payload: PutPayload,
                cache.put(&key, fetched_bytes.clone());
                    .registry
    }
//! On every read, it checks the file registry:
        path_str: &str,
                        futures::stream::empty().boxed(),
        let mapped = locations.map(move |result| {
    fn put_metadata(&self, path: &str, ranges: &[std::ops::Range<u64>], data: &[Bytes]) {
                    .filter(|&s| s > 0);
            .map(|(path, _, size)| {
        }
    ///
        &self,
                    return Ok(GetResult {
            !was_set,
    /// Used by `get_opts` to short-circuit range reads when the requested bytes were
            }));
impl ObjectStore for TieredObjectStore {
            for (fetched_bytes, &slot_i) in fetched.iter().zip(miss_indices.iter()) {
// ---------------------------------------------------------------------------
            format!("{}/", path_str)
    }
                    // Skip buffering for large ranges — TieredBlockCache::put() would
// ---------------------------------------------------------------------------
        let remote_stream = futures::stream::iter(remote_entries);
    ///
        if let Some(ref cache) = self.cache {
                    if range_size > max_size {
    /// Register a file in the registry. For Remote/Both locations, the caller
                slots[slot_i] = Some(fetched_bytes.clone());
        } else {
        }
 *
                    } else {
        path: &str,
            if let Some(result) = self.try_head_from_registry(location, path_str) {
}
            registry,
                    let bytes = get_result.bytes().await?;
            {
//! [`TieredObjectStore`] — routes reads between local and remote stores
        let path_str = path.strip_prefix('/').unwrap_or(path);
                    .get(path_str)
        let prefix_str = prefix.map(|p| p.as_ref().to_string()).unwrap_or_default();
                    miss_indices.push(i);
        &self,
                    .map(|g| g.size())
use async_trait::async_trait;
                    store.get_ranges(&rp, miss_ranges).await
                    size,
// ---------------------------------------------------------------------------
        if options.head {
                    let meta = ObjectMeta {
        // Check registry for cached file size
    }
    /// List: local entries first, then remote-only entries from registry (deduplicated).
    /// to REMOTE in the registry (e.g., afterSyncToRemote deleted the local copy).
                let key = range_cache_key(path_str, r.start, r.end);
                        last_modified: chrono::DateTime::<chrono::Utc>::default(),
use opensearch_block_cache::range_cache::range_cache_key;
            path_str,
                    });
        remote_path: Option<String>,
                miss_ranges.push(r.clone());
                path: path.to_string(),
        let store = Arc::clone(self.remote.get()?); // use store-level remote
        if let Some(ref cache) = self.cache {
        // cache.put() always routes to data Foyer — metadata Foyer is only
 */
// ---------------------------------------------------------------------------
        }
    }
// ObjectStore impl
            range: start..end,
            }
            }
                    }
        Some(Ok(GetResult {
            None
                        size: file_size,
        &self.registry
            source: "TieredObjectStore does not support put_multipart_opts".into(),
        }
    ///
        }
    /// Reference to the underlying registry.
            .collect();
    }
    /// Primary read path: check registry for remote routing, otherwise local.
        );
        self
    ObjectMeta, ObjectStore, PutMultipartOptions, PutOptions, PutPayload, PutResult,
            "TieredObjectStore: register_file path='{}', location={}",
        Err(object_store::Error::NotSupported {
                let file_size = self
        native_bridge_common::log_debug!(
                    let key = range_cache_key(path_str, start, end);
    }
    registry: Arc<TieredStorageRegistry>,
    ///
                        e_tag: None,
                    .get(path_str)
}
        }
    }
        &self,
        for (path, location, size) in self.registry.entries_matching(&prefix_str) {
impl fmt::Display for TieredObjectStore {
/// Used by warmup paths (e.g. `analytics-backend-datafusion`'s
        None
        native_bridge_common::log_debug!("[warm-tier] TieredObjectStore: block cache attached");
            path_str.to_string()
        Box::pin(mapped)
/*
        Ok(slots.into_iter().map(|o| o.unwrap()).collect())
                if let Some(ref c) = cache {
            remote: std::sync::OnceLock::new(),
            });
//!
                    let max_size = cache.as_any()
        // This ensures single-range reads (CachedMetadataReader::get_bytes for
        (slots, miss_indices, miss_ranges)
    ///
            match local_result {
    Result as OsResult,
            ranges.len(),
            return store.get_ranges(&rp, miss_ranges).await;
            meta,
// ---------------------------------------------------------------------------
            }
    pub fn register_file(
        });
    /// reassemble the complete result in original range order.
/// An [`ObjectStore`] that supports promoting reads into a sticky metadata tier
                    location: Path::from(path),
    /// Phase 2 — fetch missing ranges from the backing store (remote or local).
    /// Try to serve a range read from the cache. Returns `Some(Ok(GetResult))` on hit,
            local,
#[path = "tiered_object_store_tests.rs"]
                .zip(miss_indices.iter().zip(miss_ranges.iter()))
            e.remote_path = remote_arc;
        self.registry.update(path, move |e| {
        miss_indices: &[usize],
        if let Some((rp, store)) = self.resolve_remote(path_str) {
    /// List with delimiter: local entries first, then merge remote-only entries (deduplicated).
                path_str
    ///
}
    ///
    /// Tries the remote store first (registry lookup). Falls back to local,
            "TieredObjectStore: transition path='{}', location={}",
                    last_modified: chrono::DateTime::<chrono::Utc>::default(),
    ) -> OsResult<PutResult> {
        &self,
            "TieredObjectStore(files={}, cache={})",
    /// - `Suffix(n)`: resolved to `(file_size - n, file_size)` using registry.
                    .registry
                }
            return Ok(slots.into_iter().map(|o| o.unwrap()).collect());
    #[must_use]
            location
        remote_path: Option<String>,
    /// must provide a `remote_path`.
                if let Some((rp, store)) = self.should_retry_remote(path_str, e) {
        let remote_entries: Vec<OsResult<ObjectMeta>> = registry
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
            if let Some(ref get_range) = options.range {
                return result;
        Some((rp, store))
    /// Also handles head requests (options.head == true) by returning cached
    /// practice but is handled for completeness.
            GetRange::Bounded(r) => Some((r.start, r.end)),
                    meta,
            }
            if let Ok(ref path) = result {
///
    pub fn with_cache(mut self, cache: Arc<dyn BlockCache>) -> Self {
        // reads (IndexedExec column chunks) hit cache on subsequent queries.
        } else {
        native_bridge_common::log_debug!(
                    last_modified: chrono::DateTime::<chrono::Utc>::default(),
                    result
    pub fn registry(&self) -> &Arc<TieredStorageRegistry> {
 * SPDX-License-Identifier: Apache-2.0
impl fmt::Debug for TieredObjectStore {
    fn should_retry_remote(
                };
    /// No-op if no cache is attached.
        let result = self.local.get_ranges(location, miss_ranges).await;
                    cache.put(&key, bytes.clone());
                        );
    /// Evict all cache entries whose key starts with `path`.
        let file_size = self.registry.get(path_str).map(|g| g.size()).unwrap_or(end);
        // Fast path for head: check registry/directory without I/O
                            "TieredObjectStore: resolve_range Suffix({}) — file_size unavailable for '{}', cache bypassed",
    /// bytes are in the durable metadata_cache — surviving LRU eviction from
    async fn fetch_misses(
        write!(
                }
        }
        // This matches LocalFileSystem behavior: head() on a directory returns NotFound.
    /// Phase 3 — populate the block cache with freshly fetched bytes and
        let remote_arc: Option<Arc<str>> = remote_path.map(Arc::from);
    async fn put_opts(
            }
    }
            "TieredObjectStore: put_opts registered LOCAL path='{}'",
    /// `None` on miss. Does NOT auto-populate the cache on miss.
            &mut slots,
            }
        let local_paths: std::collections::HashSet<String> = result
            }
    /// Returns `None` if file_size is needed but not available in the registry.
        if guard.location() != FileLocation::Remote {
            GetRange::Suffix(n) => {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        match result {
            e.location = location;
    // during I/O to prevent eviction race — resolve_remote should return the guard
use futures::StreamExt;
    }
 * this file be licensed under the Apache-2.0 license or a
        }
// MetadataCachingStore impl — delegates to the inherent put_metadata above.
/// Per-shard model: one remote store is set once via [`set_remote()`] and
                } else {
        let mut result = self.local.list_with_delimiter(prefix).await?;
                slots.push(None);
    /// Called by warmup after fetching metadata bytes. The warmup code reads
        Ok(get_result)
    // NOTE: The guard is intentionally dropped before I/O. The Arc<dyn ObjectStore>
    ///
    local: Arc<dyn ObjectStore>,
// TieredObjectStore
                    // reject them anyway (max_data_entry_size). This avoids allocating
        locations: BoxStream<'static, OsResult<Path>>,
        let cached = cache.get(&key).await?;
        &self,
            })
        path_str: &str,
        let mut slots: Vec<Option<Bytes>> = Vec::with_capacity(ranges.len());
                    Some(size) => Some((size.saturating_sub(*n), size)),
            return Err(crate::types::FileRegistryError::InvalidRegistration {
            for (r, bytes) in ranges.iter().zip(data.iter()) {
    /// Attach a block cache. Hot nodes skip this; `None` means no caching.
                    .map(|g| g.size())
        let path_str = location.as_ref();
    async fn get_opts(&self, location: &Path, options: GetOptions) -> OsResult<GetResult> {
            if let Some(result) = self
        }
        })
            was_set
        Ok(())
        native_bridge_common::log_debug!(
        );
        let rp = Path::from(remote_path);
    /// Set the remote store (once). Subsequent calls are ignored.
mod tests;
    ) -> Option<OsResult<GetResult>> {
        let cache = self.cache.clone();
use std::ops::Range;
        path: &str,
            .field("file_count", &self.registry.len())
use std::sync::Arc;
            }
    /// - `slots`: one entry per input range — `Some(bytes)` for hits, `None` for misses
                return Some(Ok(GetResult {
        // (put there by warmup) or data Foyer (populated on prior miss).
            }
        // (read paths through ObjectStore::get_opts/get_ranges arrive with the leading '/'
                return result;
// ---------------------------------------------------------------------------
    /// during warmup), returns cached bytes immediately — zero S3/local I/O.
                })
//!
    /// Note: `GetRange::Offset` is defensive/forward-compatible code. DataFusion's
                Ok(ObjectMeta {
        fetched: &[Bytes],
        slots: &mut Vec<Option<Bytes>>,
            result
                        location: location.clone(),
            // Full cache hit — all ranges served from SSD.
            ),
        } else {
        );
                    c.evict_prefix(path_str);
    /// Default: no-op.
    ) -> OsResult<Vec<Bytes>> {
        &self,
    /// On writable warm, caller must pin the file to prevent eviction before
    pub fn set_remote(&self, store: Arc<dyn ObjectStore>) {
    /// If no cache is attached, only the slot reassembly is performed.
//! - **Local / Both / not registered** → falls through to the local store
    }
                result.objects.push(ObjectMeta {
        if miss_ranges.is_empty() {
                futures::stream::once(async { Ok(cached) }).boxed(),
        let result = self.local.put_opts(location, payload, opts).await?;
use opensearch_block_cache::traits::BlockCache;
///
            version: None,
pub trait MetadataCachingStore: ObjectStore {
    async fn put_multipart_opts(
// ---------------------------------------------------------------------------
        path_str: &str,
                    version: None,
        &self,
    pub fn transition(
    /// and retries remote if local returns `NotFound` and the file has since
        } else {
                    version: None,
        path_str: &str,
                    None => {
    ) -> Result<(), crate::types::FileRegistryError> {
        location: &Path,
        TieredObjectStore::put_metadata(self, path, ranges, data);
    /// Transition a file's location and metadata via `registry.update()`.
/// stores based on [`TieredStorageRegistry`] metadata.
        )
impl MetadataCachingStore for TieredObjectStore {
                    };
    }
            .iter()
            last_modified: chrono::DateTime::<chrono::Utc>::default(),
    fn list(&self, prefix: Option<&Path>) -> BoxStream<'static, OsResult<ObjectMeta>> {
    /// Optional node-level block cache. `None` on hot nodes or when disabled.
        }
    async fn list_with_delimiter(&self, prefix: Option<&Path>) -> OsResult<ListResult> {
                        native_bridge_common::log_debug!(
use object_store::{
///
        };
    async fn try_serve_from_cache(
        }))
        path_str: &str,
        // so repeated reads hit cache.
        Ok(result)
                cache.put_metadata(&key, bytes.clone());
        );
            }
    /// - `miss_ranges`: the ranges that need to be fetched from the backing store
            path_str,
            source: "TieredObjectStore does not support copy".into(),
            path,
use crate::registry::traits::FileRegistry;
            cache: None,
/// uniformly through any `Arc<dyn MetadataCachingStore>` without checking the
        opts: PutOptions,
                    range: 0..size,
                .iter()
                let meta = ObjectMeta {
                }
    /// so that stale byte-range entries are freed promptly.
    ) -> Result<(), crate::types::FileRegistryError> {
            let local_result = self.local.get_opts(location, options.clone()).await;
            native_bridge_common::log_debug!("[warm-tier] evict_path path='{}'", path);
                match file_size {
                    path_str
        Box::pin(local_stream.chain(remote_stream))
                }
                    last_modified: chrono::DateTime::<chrono::Utc>::default(),
                    miss_ranges.push(r.clone());
        let prefix_str = prefix.map(|p| p.as_ref().to_string()).unwrap_or_default();
        Ok(result)
/// `add_files_with_store`) that need to populate the metadata tier after
        match range {
            f,
        })
/// concrete type. [`TieredObjectStore`] overrides it to actually route the
                    // memory for entries that won't be cached.
                native_bridge_common::log_debug!(
        &self,
        if matches!(location, FileLocation::Remote) && remote_path.is_none() {
    /// Probes cache per range, fetches only misses, populates cache on success.
            });
#[cfg(test)]
        }
            &miss_ranges,
    cache: Option<Arc<dyn BlockCache>>,
                slots[slot_i] = Some(fetched_bytes.clone());
    }
                    size,
                        native_bridge_common::log_debug!(
        location: &Path,
    fn delete_stream(
    ///
            payload: object_store::GetResultPayload::Stream(
    /// When no cache is attached all ranges are unconditionally treated as misses.
    async fn copy_opts(&self, _from: &Path, _to: &Path, _options: CopyOptions) -> OsResult<()> {
//! registry's atomics and DashMap — no locks are held during I/O.
            {
        self.populate_cache_and_reassemble(
                        payload: object_store::GetResultPayload::Stream(
    }
                });
    /// If local read fails with NotFound and file transitioned to REMOTE, retries from remote.
    }
                }
        if let Some(ref get_range) = options.range {
                    ),
                            "TieredObjectStore: resolve_range Offset({}) — file_size unavailable for '{}', cache bypassed",
    ///
            store.get_opts(&rp, options.clone()).await
use futures::stream::BoxStream;
//! # Thread Safety
                path: path.to_string(),
        if matches!(location, FileLocation::Remote) && remote_path.is_none() {
                }
    // keeps the store alive independently. On writable warm, the guard must be held
    async fn get_ranges(&self, location: &Path, ranges: &[Range<u64>]) -> OsResult<Vec<Bytes>> {
        let path_str = location.as_ref();
        let path_str = location.as_ref();
            }
            }
    ) -> Option<(Path, Arc<dyn ObjectStore>)> {
            }
    /// For directory paths, returns NotFound so DataFusion uses list() instead.
 * The OpenSearch Contributors require contributions made to
            return None;
            if size > 0 {
/// tests) just inherit the no-op.
            if location == FileLocation::Remote && !local_paths.contains(&path) {
    /// Called from `ts_remove_file` after a file is removed from the registry
        let key = range_cache_key(path_str, start, end);
        _opts: PutMultipartOptions,
        if let Some(ref cache) = self.cache {
                }
    /// - `Bounded(start..end)`: returned directly.
}
                miss_indices.push(i);
//!
            ranges.iter().map(|r| r.end - r.start).sum::<u64>(),
        }
    /// size from the registry when available — avoids I/O for the common case.
        }
    /// Multi-range read with cache-first routing.
                Err(ref e) => {
/// fetching bytes through the store.
                    "TieredObjectStore: LOCAL NotFound, file transitioned to REMOTE — retrying path='{}'",
/// shared across all entries.
        let remote_path = guard.remote_path()?;
    /// Phase 1 — probe the block cache for each requested range.
    }
                    location: Path::from(path),
                        );
        location: FileLocation,
        }?;
                    }
                let key = range_cache_key(path_str, miss_range.start, miss_range.end);
    /// Create a new tiered store routing between `local` and remote backends.
        let registry = Arc::clone(&self.registry);
    ) {
use bytes::Bytes;
    }
                registry.remove(path_str, true);
                        store.get_opts(&rp, options.clone()).await
            &miss_indices,
}
    ///
            "[warm-tier] set_remote wired={} (already_set={})",
        let meta = ObjectMeta {
            }
            GetRange::Offset(o) => {
    /// On miss, proceeds with normal fetch (no auto-populate — metadata cache is
        &self,
            // No cache — all ranges are misses.
    /// Returns:
    fn try_head_from_registry(
            .collect();
                path_str, matches.len()
            self.cache.is_some()
                        None
                        version: None,
            size: file_size,
        // it's a directory. Return NotFound so DataFusion treats it as a
/// bytes into the metadata cache; plain stores (e.g. `LocalFileSystem` in
            cache.evict_prefix(path);
                        meta,
}
        };
    }
                    let file_size = self.registry.get(path_str).map(|g| g.size()).unwrap_or(end);
            .map(|m| m.location.as_ref().to_string())
                path: path_str.to_string(),
        // directory and proceeds to list() (which returns all registry files).
            attributes: Default::default(),
    /// transitioned to `REMOTE` in the registry.
            e_tag: None,
            .filter(|(_, loc, _)| *loc == FileLocation::Remote)
use std::fmt;
        if let Some(ref cache) = self.cache {
        if matches!(err, object_store::Error::NotFound { .. }) {
        miss_ranges: &[Range<u64>],
                        ),
    }
    }
    /// metadata (via this store or any source), then calls this to ensure the
    pub fn evict_path(&self, path: &str) {
        let mut miss_ranges: Vec<Range<u64>> = Vec::new();
    ///
    }
        if let Some(guard) = self.registry.get(path_str) {
            for (i, r) in ranges.iter().enumerate() {
                            o, path_str
        }
        }
        let prefix_with_slash = if path_str.ends_with('/') {
        let entry = TieredFileEntry::new(location, remote_path.map(Arc::from));
        let was_set = self.remote.set(store).is_err();
            Ok(bytes) => Ok(bytes),
        &self,
            }
            self.cache.is_some()
                            n, path_str
        }
                        None
        // Cache miss — fetch from remote/local then populate data Foyer.
        let matches = self.registry.entries_matching(&prefix_with_slash);
        // column chunks in the IndexedExec path) are cached on first access.
    ) -> (Vec<Option<Bytes>>, Vec<usize>, Vec<Range<u64>>) {
    /// Returns the remote path + store if retry is possible, None otherwise.
    #[must_use]
//! based on [`TieredStorageRegistry`] metadata.
        self.registry.register(path_str, entry);
    ) -> OsResult<Box<dyn MultipartUpload>> {
        // already stripped). Without this, warmup writes under "/Volumes/..." while query
                if let Some(cached) = cache.get(&key).await {
                    slots.push(None);
    }
            native_bridge_common::log_debug!(
    }
        let registry = Arc::clone(&self.registry);
    }
        }
        // On miss: fetches from S3/local, then populates data Foyer via put()
        f.debug_struct("TieredObjectStore")
                        return Ok(get_result);
                if let Some((start, end)) = self.resolve_range(path_str, get_range) {
        Ok(())
        native_bridge_common::log_info!("TieredObjectStore: created");
    }
/// ObjectStore implementation that routes reads between local and remote
                    payload: object_store::GetResultPayload::Stream(
                        attributes: Default::default(),
    /// Delete stream: remove each path from registry and evict cache entries.
    #[must_use]
                }));
    fn resolve_range(&self, path_str: &str, range: &GetRange) -> Option<(u64, u64)> {
            );
        location: &Path,
                    e_tag: None,
                        local_result
    ///
            "[warm-tier] put_metadata path='{}' ranges={} bytes={} cache={}",
                    }
// ---------------------------------------------------------------------------
                    size,
// Tests
        let get_result = if let Some((rp, store)) = self.resolve_remote(path_str) {
 * compatible open source license.
        self.cache = Some(cache);
        Err(object_store::Error::NotSupported {
            }
    /// data scan pressure and node restarts.
            if resolved.is_some() {
impl TieredObjectStore {
    ///
        miss_ranges: &[Range<u64>],
                } else {
                    None => {
    /// Checks if a local read error is NotFound and the file has since transitioned
                let file_size = self
                "TieredObjectStore: try_head_from_registry — path='{}' is a directory ({} files), returning NotFound",
        path_str: &str,
                    e_tag: None,
                    if let Some((rp, store)) = self.should_retry_remote(path_str, e) {
        let local_stream = self.local.list(prefix);
    /// Write to local store and register the file as [`FileLocation::Local`].
    /// current parquet reading pipeline only produces `Bounded` (column data) and
        drop(guard); // release before I/O — Arc keeps store alive
                "TieredObjectStore: get_opts REMOTE path='{}'",
        });
    pub fn new(registry: Arc<TieredStorageRegistry>, local: Arc<dyn ObjectStore>) -> Self {
        &self,
        if let Some(ref cache) = self.cache {
pub struct TieredObjectStore {
                match file_size {
        if !matches.is_empty() {
        err: &object_store::Error,
                reason: format!("remote_path required for location={}", location),
                    }
        let fetched = self.fetch_misses(location, path_str, &miss_ranges).await?;
                Ok(r) => Ok(r),
                        range: start..end,
        } else {
};
    /// previously stored via `put_metadata()` during warmup.
            .field("cache", &self.cache.is_some())
            .entries_matching(&prefix_str)
            resolved
    /// `Suffix` (footer metadata). The `Offset` variant is never generated in
            location
    path::Path, CopyOptions, GetOptions, GetRange, GetResult, ListResult, MultipartUpload,
                    Some(size) => Some((*o, size)),
            let size = guard.size();
        let (start, end) = self.resolve_range(path_str, range)?;
    /// When a bounded/suffix/offset range is specified AND a cache is attached,
    async fn probe_cache(
        // reads probe under "Volumes/..." — silent cache miss on every read.
    /// Returns `Some(GetResult)` if the head can be answered without I/O,
                    version: None,
        let (mut slots, miss_indices, miss_ranges) = self.probe_cache(path_str, ranges).await;
            self.registry.len(),
        let guard = self.registry.get(path)?;
                    let range_size = end - start;
    ) -> Option<OsResult<GetResult>> {
            .finish()
            let resolved = self.resolve_remote(path_str);
                    attributes: Default::default(),
use crate::types::{FileLocation, TieredFileEntry};
    /// - `Offset(n)`: resolved to `(n, file_size)` using registry.
    /// `None` if the caller should fall through to the normal get_opts path.
            return Err(crate::types::FileRegistryError::InvalidRegistration {
                source: format!("path is a directory with {} files", matches.len()).into(),
    fn resolve_remote(&self, path: &str) -> Option<(Path, Arc<dyn ObjectStore>)> {
    pub fn put_metadata(&self, path: &str, ranges: &[std::ops::Range<u64>], data: &[Bytes]) {
    fn put_metadata(&self, _path: &str, _ranges: &[std::ops::Range<u64>], _data: &[Bytes]) {}
// ---------------------------------------------------------------------------
//! - **Remote** → delegates to the store-level remote backend
                let key = range_cache_key(path_str, r.start, r.end);
                        .downcast_ref::<opensearch_block_cache::tiered_block_cache::TieredBlockCache>()
        native_bridge_common::log_debug!(
        Self {
            Err(ref e) => {
            .into_iter()
                            futures::stream::once(async { Ok(bytes) }).boxed(),
                        .map(|t| t.max_data_entry_size())
    /// sync completes.
/// The default implementation is a no-op so callers can invoke `put_metadata`
//! `TieredObjectStore` is `Send + Sync`. All mutable state lives in the
        // Directory existence check: if the path is a prefix of any registered file,
                    .filter(|&s| s > 0);
// MetadataCachingStore — extension trait
                );
        );
    }
                reason: format!("remote_path required for location={}", location),
            );
                        .unwrap_or(32 * 1024 * 1024); // fallback for non-tiered cache
}
    /// Fast-path head response from registry or directory existence check.
                .await
        );
            for (i, r) in ranges.iter().enumerate() {
        // Cache probe for range reads. Serves entries from metadata Foyer
        ranges: &[Range<u64>],
                    slots.push(Some(cached));
    // alongside the resolved path/store to pin the entry for the I/O duration.
        // TieredBlockCache::put() enforces max_data_entry_size — entries exceeding
// ---------------------------------------------------------------------------
        // populated via explicit put_metadata() from warmup.
        _location: &Path,
        // Normalize path by stripping leading '/' to match `object_store::Path` semantics
    /// populated only by explicit `put_metadata()` calls from warmup code).
    fn populate_cache_and_reassemble(
