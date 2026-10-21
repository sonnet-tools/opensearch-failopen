            if let Some(result) = self
                    meta,
    /// Try to serve a range read from the cache. Returns `Some(Ok(GetResult))` on hit,
            GetRange::Offset(o) => {
                reason: format!("remote_path required for location={}", location),
                        location: location.clone(),
        })
        // it's a directory. Return NotFound so DataFusion treats it as a
}
            for (fetched_bytes, (&slot_i, miss_range)) in fetched
    /// Returns `Some(GetResult)` if the head can be answered without I/O,
            native_bridge_common::log_debug!(
                };
        Ok(result)
    /// Probes cache per range, fetches only misses, populates cache on success.
        let cache = self.cache.clone();
    ) -> Result<(), crate::types::FileRegistryError> {
            location
            );
    /// - `Bounded(start..end)`: returned directly.
        location: FileLocation,
            let local_result = self.local.get_opts(location, options.clone()).await;
                    last_modified: chrono::DateTime::<chrono::Utc>::default(),
    ///
    /// Note: `GetRange::Offset` is defensive/forward-compatible code. DataFusion's
        _location: &Path,
                    slots.push(Some(cached));
    }
    /// - `slots`: one entry per input range — `Some(bytes)` for hits, `None` for misses
        Ok(())
    // alongside the resolved path/store to pin the entry for the I/O duration.
        }
        )
                if let Some(ref c) = cache {
        path: &str,
            }
        let meta = ObjectMeta {
        native_bridge_common::log_info!("TieredObjectStore: created");
    /// transitioned to `REMOTE` in the registry.
                }
}
            .collect();
        }
            meta,
/// Per-shard model: one remote store is set once via [`set_remote()`] and
// ---------------------------------------------------------------------------
            result
    /// Used by `get_opts` to short-circuit range reads when the requested bytes were
        self.registry.register(path_str, entry);
            .collect();
    ) -> Option<OsResult<GetResult>> {
                        e_tag: None,
        Some((rp, store))
    /// sync completes.
            e.location = location;
// ---------------------------------------------------------------------------
    pub fn with_cache(mut self, cache: Arc<dyn BlockCache>) -> Self {
        Self {
    /// `Suffix` (footer metadata). The `Offset` variant is never generated in
                Ok(ObjectMeta {
    ///
        let prefix_str = prefix.map(|p| p.as_ref().to_string()).unwrap_or_default();
    pub fn put_metadata(&self, path: &str, ranges: &[std::ops::Range<u64>], data: &[Bytes]) {
            resolved
                        attributes: Default::default(),
                    }
            }
                    .filter(|&s| s > 0);
                Ok(r) => Ok(r),
    }
    pub fn register_file(
    fn list(&self, prefix: Option<&Path>) -> BoxStream<'static, OsResult<ObjectMeta>> {
/// `add_files_with_store`) that need to populate the metadata tier after
            &miss_indices,
        let mut miss_indices: Vec<usize> = Vec::new();
        // already stripped). Without this, warmup writes under "/Volumes/..." while query
    /// Attach a block cache. Hot nodes skip this; `None` means no caching.
        if let Some((rp, store)) = self.resolve_remote(path_str) {
    /// - `miss_indices`: original indices of the ranges that missed
    }
    /// Phase 3 — populate the block cache with freshly fetched bytes and
        }
use async_trait::async_trait;
            let size = guard.size();
                        );
            }
                    // Skip buffering for large ranges — TieredBlockCache::put() would
        };
// ---------------------------------------------------------------------------
    /// List with delimiter: local entries first, then merge remote-only entries (deduplicated).
        } else {
        self.registry.update(path, move |e| {
                    // reject them anyway (max_data_entry_size). This avoids allocating
//! - **Remote** → delegates to the store-level remote backend
                    slots.push(None);
                    None => {
            f,
        })
                        range: start..end,
        });
            .field("file_count", &self.registry.len())
    ) -> Option<(Path, Arc<dyn ObjectStore>)> {
        // reads probe under "Volumes/..." — silent cache miss on every read.
//! - **Local / Both / not registered** → falls through to the local store
    /// When a bounded/suffix/offset range is specified AND a cache is attached,
            "TieredObjectStore: put_opts registered LOCAL path='{}'",
        let registry = Arc::clone(&self.registry);
        let local_stream = self.local.list(prefix);
                reason: format!("remote_path required for location={}", location),
                .await
    /// Phase 1 — probe the block cache for each requested range.
    /// Default: no-op.
        let rp = Path::from(remote_path);
                path_str
                let key = range_cache_key(path_str, r.start, r.end);
        native_bridge_common::log_debug!(
        &self,
        );
    fn put_metadata(&self, path: &str, ranges: &[std::ops::Range<u64>], data: &[Bytes]) {
    #[must_use]
    fn try_head_from_registry(
                slots[slot_i] = Some(fetched_bytes.clone());
            &fetched,
                        None
        let registry = Arc::clone(&self.registry);
        let entry = TieredFileEntry::new(location, remote_path.map(Arc::from));
    }
            for (fetched_bytes, &slot_i) in fetched.iter().zip(miss_indices.iter()) {
use crate::registry::traits::FileRegistry;
                }
use std::ops::Range;
        // This matches LocalFileSystem behavior: head() on a directory returns NotFound.
        &self,
        // Populate data Foyer for bounded-range reads so repeated single-range
 */
            }));
                source: format!("path is a directory with {} files", matches.len()).into(),
    ///
        // On miss: fetches from S3/local, then populates data Foyer via put()
        let path_str = path.strip_prefix('/').unwrap_or(path);
    fn delete_stream(
            Err(ref e) => {
    /// Write to local store and register the file as [`FileLocation::Local`].
            });
        }
// ---------------------------------------------------------------------------
        f.debug_struct("TieredObjectStore")
                    .filter(|&s| s > 0);
                        payload: object_store::GetResultPayload::Stream(
            source: "TieredObjectStore does not support put_multipart_opts".into(),
            self.cache.is_some()
    ///
                        size: file_size,
        location: &Path,
    /// so that stale byte-range entries are freed promptly.
            {
}
    pub fn registry(&self) -> &Arc<TieredStorageRegistry> {
            return Err(crate::types::FileRegistryError::InvalidRegistration {
        path_str: &str,
        for (path, location, size) in self.registry.entries_matching(&prefix_str) {
        if let Some(guard) = self.registry.get(path_str) {
                    let range_size = end - start;
                    e_tag: None,
            store.get_opts(&rp, options.clone()).await
        }
        remote_path: Option<String>,
                cache.put(&key, fetched_bytes.clone());
                let key = range_cache_key(path_str, r.start, r.end);
    async fn get_opts(&self, location: &Path, options: GetOptions) -> OsResult<GetResult> {
                );
        if let Some(ref get_range) = options.range {
        Ok(result)
    /// to REMOTE in the registry (e.g., afterSyncToRemote deleted the local copy).
                }));
}
        }
                    size,
        let store = Arc::clone(self.remote.get()?); // use store-level remote
    /// Checks if a local read error is NotFound and the file has since transitioned
        locations: BoxStream<'static, OsResult<Path>>,
                "TieredObjectStore: get_opts REMOTE path='{}'",
    }
// ---------------------------------------------------------------------------
            return None;
        let fetched = self.fetch_misses(location, path_str, &miss_ranges).await?;
        }
        None
        // Cache probe for range reads. Serves entries from metadata Foyer
}
        location: &Path,
    }
                        .downcast_ref::<opensearch_block_cache::tiered_block_cache::TieredBlockCache>()
                    let key = range_cache_key(path_str, start, end);
            path_str,
        let (mut slots, miss_indices, miss_ranges) = self.probe_cache(path_str, ranges).await;
                } else {
        Box::pin(local_stream.chain(remote_stream))
            if let Some(result) = self.try_head_from_registry(location, path_str) {
        let mut slots: Vec<Option<Bytes>> = Vec::with_capacity(ranges.len());
            if location == FileLocation::Remote && !local_paths.contains(&path) {
    ///
impl fmt::Debug for TieredObjectStore {
        miss_ranges: &[Range<u64>],
        path_str: &str,
                }
            }
                    c.evict_prefix(path_str);
                return result;
                    version: None,
                });
    ///
        if guard.location() != FileLocation::Remote {
/// ObjectStore implementation that routes reads between local and remote
    }
        }
            }
        );
                        meta,
        path_str: &str,
        }
    /// `None` on miss. Does NOT auto-populate the cache on miss.
    /// size from the registry when available — avoids I/O for the common case.
impl ObjectStore for TieredObjectStore {
    async fn get_ranges(&self, location: &Path, ranges: &[Range<u64>]) -> OsResult<Vec<Bytes>> {
        }))
                    cache.put(&key, bytes.clone());
    /// metadata (via this store or any source), then calls this to ensure the
                            futures::stream::once(async { Ok(bytes) }).boxed(),
        // (put there by warmup) or data Foyer (populated on prior miss).
                slots[slot_i] = Some(fetched_bytes.clone());
                    return Ok(GetResult {
        self.populate_cache_and_reassemble(
                    if let Some((rp, store)) = self.should_retry_remote(path_str, e) {
        let file_size = self.registry.get(path_str).map(|g| g.size()).unwrap_or(end);
    /// and retries remote if local returns `NotFound` and the file has since
        // This ensures single-range reads (CachedMetadataReader::get_bytes for
                .zip(miss_indices.iter().zip(miss_ranges.iter()))
                let path_str = path.as_ref();
    }
        );
            location
    /// Returns `None` if file_size is needed but not available in the registry.
//! [`TieredObjectStore`] — routes reads between local and remote stores
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        &self,
        if let Some(ref cache) = self.cache {
                let file_size = self
        let local_paths: std::collections::HashSet<String> = result
    /// Returns:
            version: None,
                        ),
                    let file_size = self.registry.get(path_str).map(|g| g.size()).unwrap_or(end);
        payload: PutPayload,
    }
        }
    ) -> Result<(), crate::types::FileRegistryError> {
    }
use opensearch_block_cache::traits::BlockCache;
    /// Also handles head requests (options.head == true) by returning cached
        };
        native_bridge_common::log_debug!("[warm-tier] TieredObjectStore: block cache attached");
            native_bridge_common::log_debug!(
        // Fast path for head: check registry/directory without I/O
use futures::StreamExt;
            GetRange::Suffix(n) => {
                    miss_indices.push(i);
            .map(|m| m.location.as_ref().to_string())
    ///
            if resolved.is_some() {
    fn should_retry_remote(
    /// previously stored via `put_metadata()` during warmup.
            path,
                    range: 0..size,
            None
                let file_size = self
                        return Ok(get_result);
/// The default implementation is a no-op so callers can invoke `put_metadata`
    /// bytes are in the durable metadata_cache — surviving LRU eviction from
        // Cache miss — fetch from remote/local then populate data Foyer.
            path_str,
// TieredObjectStore
impl MetadataCachingStore for TieredObjectStore {
    /// - `miss_ranges`: the ranges that need to be fetched from the backing store
    ObjectMeta, ObjectStore, PutMultipartOptions, PutOptions, PutPayload, PutResult,
                    let bytes = get_result.bytes().await?;
    /// Promote `data` ranges to the never-evict metadata tier.
impl TieredObjectStore {
        let cached = cache.get(&key).await?;
            attributes: Default::default(),
        &self,
            }
use std::fmt;
    // during I/O to prevent eviction race — resolve_remote should return the guard
    }
    remote: std::sync::OnceLock<Arc<dyn ObjectStore>>,
    /// `None` if the caller should fall through to the normal get_opts path.
    pub fn new(registry: Arc<TieredStorageRegistry>, local: Arc<dyn ObjectStore>) -> Self {
                    .registry
        let entry = TieredFileEntry::new(FileLocation::Local, None);
        &self,
//! registry's atomics and DashMap — no locks are held during I/O.
                slots.push(None);
            if let Some(ref get_range) = options.range {
        // that limit are silently skipped (no buffering needed for them either).
                    miss_ranges.push(r.clone());
    /// Set the remote store (once). Subsequent calls are ignored.
    path::Path, CopyOptions, GetOptions, GetRange, GetResult, ListResult, MultipartUpload,
    async fn put_opts(
    // keeps the store alive independently. On writable warm, the guard must be held
            self.registry.len(),
// ---------------------------------------------------------------------------
        (slots, miss_indices, miss_ranges)
                Err(ref e) => {
use object_store::{
        // cache.put() always routes to data Foyer — metadata Foyer is only
        }
        &self,
        drop(guard); // release before I/O — Arc keeps store alive
    /// Returns the remote path + store if retry is possible, None otherwise.
        TieredObjectStore::put_metadata(self, path, ranges, data);
    }
use opensearch_block_cache::range_cache::range_cache_key;
                    };
    ///
    #[must_use]
 * SPDX-License-Identifier: Apache-2.0
        Some(Ok(GetResult {
            });
            }
    fn resolve_remote(&self, path: &str) -> Option<(Path, Arc<dyn ObjectStore>)> {
    /// Store byte ranges directly into the metadata cache (never-evict tier).
        let result = self.local.get_ranges(location, miss_ranges).await;
            .iter()
    /// List: local entries first, then remote-only entries from registry (deduplicated).
                cache.put_metadata(&key, bytes.clone());
    ///
        opts: PutOptions,
        location: FileLocation,
        let path_str = location.as_ref();
        if let Some(ref cache) = self.cache {
        let remote_stream = futures::stream::iter(remote_entries);
/// tests) just inherit the no-op.
    }
    /// reassemble the complete result in original range order.
    /// must provide a `remote_path`.
        if !matches.is_empty() {
                            "TieredObjectStore: resolve_range Offset({}) — file_size unavailable for '{}', cache bypassed",
        Ok(())
        let prefix_with_slash = if path_str.ends_with('/') {
        err: &object_store::Error,
            &mut slots,
/*
            // Full cache hit — all ranges served from SSD.
    fn populate_cache_and_reassemble(
            path,
            .filter(|(_, loc, _)| *loc == FileLocation::Remote)
    ///
                } else {
    }
                    // memory for entries that won't be cached.
// ---------------------------------------------------------------------------
    /// during warmup), returns cached bytes immediately — zero S3/local I/O.
    /// Evict all cache entries whose key starts with `path`.
use std::sync::Arc;
                    .registry
        ranges: &[Range<u64>],
        location: &Path,
                        );
    /// No-op if no cache is attached (hot nodes or cache disabled).
            GetRange::Bounded(r) => Some((r.start, r.end)),
                    location: Path::from(path),
                let key = range_cache_key(path_str, miss_range.start, miss_range.end);
        if matches!(location, FileLocation::Remote) && remote_path.is_none() {
                    .get(path_str)
    /// On miss, proceeds with normal fetch (no auto-populate — metadata cache is
///
        path_str: &str,
            !was_set,
use crate::registry::TieredStorageRegistry;
/// (the never-evict Foyer SSD instance in production).
    }
        miss_indices: &[usize],
        self
    /// Multi-range read with cache-first routing.
        if miss_ranges.is_empty() {
                return Some(Ok(GetResult {
    /// If no cache is attached, only the slot reassembly is performed.
                    store.get_ranges(&rp, miss_ranges).await
    /// For directory paths, returns NotFound so DataFusion uses list() instead.
        let mapped = locations.map(move |result| {
                    last_modified: chrono::DateTime::<chrono::Utc>::default(),
/// stores based on [`TieredStorageRegistry`] metadata.
            last_modified: chrono::DateTime::<chrono::Utc>::default(),
                    ),
    // NOTE: The guard is intentionally dropped before I/O. The Arc<dyn ObjectStore>
        // TieredBlockCache::put() enforces max_data_entry_size — entries exceeding
    /// On writable warm, caller must pin the file to prevent eviction before
                "TieredObjectStore: try_head_from_registry — path='{}' is a directory ({} files), returning NotFound",
/// Used by warmup paths (e.g. `analytics-backend-datafusion`'s
            location: location.clone(),
                    .get(path_str)
/// shared across all entries.
        } else {
                    None => {
                match file_size {
    async fn put_multipart_opts(
//! # Thread Safety
#[cfg(test)]
            return Ok(slots.into_iter().map(|o| o.unwrap()).collect());
        Err(object_store::Error::NotSupported {
    ) -> OsResult<Box<dyn MultipartUpload>> {
        path_str: &str,
    }
            }
            remote: std::sync::OnceLock::new(),
        let was_set = self.remote.set(store).is_err();
    /// Fast-path head response from registry or directory existence check.
            range: start..end,
        write!(
    ) -> BoxStream<'static, OsResult<Path>> {
        }
    fn put_metadata(&self, _path: &str, _ranges: &[std::ops::Range<u64>], _data: &[Bytes]) {}
                    Some(size) => Some((size.saturating_sub(*n), size)),
                if let Some(cached) = cache.get(&key).await {
/// uniformly through any `Arc<dyn MetadataCachingStore>` without checking the
    pub fn evict_path(&self, path: &str) {
        let mut result = self.local.list_with_delimiter(prefix).await?;
pub struct TieredObjectStore {
            local,
                    if range_size > max_size {
                if let Some((start, end)) = self.resolve_range(path_str, get_range) {
                    location: location.clone(),
    /// Register a file in the registry. For Remote/Both locations, the caller
// ---------------------------------------------------------------------------
    /// Phase 2 — fetch missing ranges from the backing store (remote or local).
}
                        .map(|t| t.max_data_entry_size())
        }
mod tests;
    async fn copy_opts(&self, _from: &Path, _to: &Path, _options: CopyOptions) -> OsResult<()> {
                path_str, matches.len()
            .finish()
                    Some(size) => Some((*o, size)),
        // directory and proceeds to list() (which returns all registry files).
        let remote_entries: Vec<OsResult<ObjectMeta>> = registry
                    } else {
// Tests
    }
        // Check registry for cached file size
                        .unwrap_or(32 * 1024 * 1024); // fallback for non-tiered cache
// ---------------------------------------------------------------------------
        Err(object_store::Error::NotSupported {
                        version: None,
                    let meta = ObjectMeta {
        path_str: &str,
    }
            .field("cache", &self.cache.is_some())
            }
        native_bridge_common::log_debug!(
                registry.remove(path_str, true);
        Ok(slots.into_iter().map(|o| o.unwrap()).collect())
                        futures::stream::empty().boxed(),
        }
        let prefix_str = prefix.map(|p| p.as_ref().to_string()).unwrap_or_default();
        &self,
        }
    /// Delete stream: remove each path from registry and evict cache entries.
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        let key = range_cache_key(path_str, start, end);
    /// When no cache is attached all ranges are unconditionally treated as misses.
                        native_bridge_common::log_debug!(
    /// Primary read path: check registry for remote routing, otherwise local.
            path_str.to_string()
            // No cache — all ranges are misses.
                    location: Path::from(path),
 *
    /// Optional node-level block cache. `None` on hot nodes or when disabled.
                    path_str
                .try_serve_from_cache(path_str, location, get_range)
//! `TieredObjectStore` is `Send + Sync`. All mutable state lives in the
            path_str,
                    "TieredObjectStore: LOCAL NotFound, file transitioned to REMOTE — retrying path='{}'",
        _opts: PutMultipartOptions,
    async fn fetch_misses(
    /// Reference to the underlying registry.
                    }
        let result = self.local.put_opts(location, payload, opts).await?;
    }
#[async_trait]
            .objects
                        last_modified: chrono::DateTime::<chrono::Utc>::default(),
    /// Called by warmup after fetching metadata bytes. The warmup code reads
                            "TieredObjectStore: resolve_range Suffix({}) — file_size unavailable for '{}', cache bypassed",
        match result {
            if size > 0 {
/// bytes into the metadata cache; plain stores (e.g. `LocalFileSystem` in
    local: Arc<dyn ObjectStore>,
    pub fn transition(
    fn resolve_range(&self, path_str: &str, range: &GetRange) -> Option<(u64, u64)> {
    /// probes the cache first. On hit (entry previously stored via `put_metadata`
        if let Some(ref cache) = self.cache {
        native_bridge_common::log_debug!(
                    size,
        // so repeated reads hit cache.
            }
            source: "TieredObjectStore does not support copy".into(),
        let remote_path = guard.remote_path()?;
        &self,
    /// No-op if no cache is attached.
        slots: &mut Vec<Option<Bytes>>,
        let matches = self.registry.entries_matching(&prefix_with_slash);
    ) -> OsResult<PutResult> {
        if options.head {
        if let Some(ref cache) = self.cache {
        Box::pin(mapped)
                }
            return Err(crate::types::FileRegistryError::InvalidRegistration {
                    payload: object_store::GetResultPayload::Stream(
        });
        let path_str = location.as_ref();
            }
    async fn list_with_delimiter(&self, prefix: Option<&Path>) -> OsResult<ListResult> {
                }
            registry,
            }
        } else {
            e_tag: None,
            ranges.len(),
            for (r, bytes) in ranges.iter().zip(data.iter()) {
            self.cache.is_some()
            }
use crate::types::{FileLocation, TieredFileEntry};
                miss_indices.push(i);
            for (i, r) in ranges.iter().enumerate() {
                    let max_size = cache.as_any()
        // (read paths through ObjectStore::get_opts/get_ranges arrive with the leading '/'
        &self,
            ),
    /// Transition a file's location and metadata via `registry.update()`.
            "TieredObjectStore: transition path='{}', location={}",
    }
        }
    /// - `Offset(n)`: resolved to `(n, file_size)` using registry.
pub trait MetadataCachingStore: ObjectStore {
                match file_size {
    Result as OsResult,
            format!("{}/", path_str)
                    attributes: Default::default(),
                })
            {
            Ok(bytes) => Ok(bytes),
        // populated via explicit put_metadata() from warmup.
        range: &GetRange,
 * this file be licensed under the Apache-2.0 license or a
                if let Some((rp, store)) = self.should_retry_remote(path_str, e) {
                    e_tag: None,
//!
    }
                        None
// ObjectStore impl
                native_bridge_common::log_debug!(
        let path_str = location.as_ref();
            .into_iter()
            if let Ok(ref path) = result {
    async fn try_serve_from_cache(
                    version: None,
        miss_ranges: &[Range<u64>],
                .iter()
        // column chunks in the IndexedExec path) are cached on first access.
            }
use bytes::Bytes;
    /// Called from `ts_remove_file` after a file is removed from the registry
                    version: None,
    }
use futures::stream::BoxStream;
    /// Create a new tiered store routing between `local` and remote backends.
 * compatible open source license.
            "TieredObjectStore(files={}, cache={})",
            return Some(Err(object_store::Error::NotFound {
//!
                        native_bridge_common::log_debug!(
        fetched: &[Bytes],
    /// - `Suffix(n)`: resolved to `(file_size - n, file_size)` using registry.
            let resolved = self.resolve_remote(path_str);
    ///
        let mut miss_ranges: Vec<Range<u64>> = Vec::new();
                miss_ranges.push(r.clone());
                }
            .entries_matching(&prefix_str)
        }?;
                    e_tag: None,
                    last_modified: chrono::DateTime::<chrono::Utc>::default(),
            size: file_size,
                    });
        let guard = self.registry.get(path)?;
        let get_result = if let Some((rp, store)) = self.resolve_remote(path_str) {
            );
                            o, path_str
//! based on [`TieredStorageRegistry`] metadata.
                path: path.to_string(),
    cache: Option<Arc<dyn BlockCache>>,
        self.cache = Some(cache);
            .map(|(path, _, size)| {
    /// data scan pressure and node restarts.
    ///
/// concrete type. [`TieredObjectStore`] overrides it to actually route the
                return result;
impl fmt::Display for TieredObjectStore {
            ranges.iter().map(|r| r.end - r.start).sum::<u64>(),
    ) {
            for (i, r) in ranges.iter().enumerate() {
    registry: Arc<TieredStorageRegistry>,
        );
        self.registry.register(path, entry);
        let (start, end) = self.resolve_range(path_str, range)?;
//! On every read, it checks the file registry:
        );
                path: path.to_string(),
// MetadataCachingStore — extension trait
        } else {
            }
            "[warm-tier] put_metadata path='{}' ranges={} bytes={} cache={}",
    /// Resolve a GetRange to absolute (start, end) byte offsets.
    ///
    }
    /// populated only by explicit `put_metadata()` calls from warmup code).
    }
        }
};
                        store.get_opts(&rp, options.clone()).await
}
            payload: object_store::GetResultPayload::Stream(
                    result
/// fetching bytes through the store.
    ) -> OsResult<Vec<Bytes>> {
    /// current parquet reading pipeline only produces `Bounded` (column data) and
                    }
    /// practice but is handled for completeness.
                result.objects.push(ObjectMeta {
            match local_result {
        );
            cache.evict_prefix(path);
        // Directory existence check: if the path is a prefix of any registered file,
                    .map(|g| g.size())
            native_bridge_common::log_debug!("[warm-tier] evict_path path='{}'", path);
///
    }
        if matches!(err, object_store::Error::NotFound { .. }) {
        Ok(get_result)
            &miss_ranges,
        match range {
                        local_result
        location: &Path,
        let remote_arc: Option<Arc<str>> = remote_path.map(Arc::from);
            "TieredObjectStore: register_file path='{}', location={}",
        } else {
                    }
        let cache = self.cache.as_ref()?;
        &self.registry
        // reads (IndexedExec column chunks) hit cache on subsequent queries.
                path: path_str.to_string(),
                    size,
        &self,
    ) -> (Vec<Option<Bytes>>, Vec<usize>, Vec<Range<u64>>) {
        native_bridge_common::log_debug!(
        if matches!(location, FileLocation::Remote) && remote_path.is_none() {
                }
    pub fn set_remote(&self, store: Arc<dyn ObjectStore>) {
    #[must_use]
// MetadataCachingStore impl — delegates to the inherent put_metadata above.
// ---------------------------------------------------------------------------
            "[warm-tier] set_remote wired={} (already_set={})",
    async fn probe_cache(
    /// Tries the remote store first (registry lookup). Falls back to local,
        remote_path: Option<String>,
        }
                futures::stream::once(async { Ok(cached) }).boxed(),
    ) -> Option<OsResult<GetResult>> {
//!
            return store.get_ranges(&rp, miss_ranges).await;
            }
        }
/// An [`ObjectStore`] that supports promoting reads into a sticky metadata tier
            cache: None,
    }
            e.remote_path = remote_arc;
                let meta = ObjectMeta {
                    .map(|g| g.size())
                            n, path_str
    /// If local read fails with NotFound and file transitioned to REMOTE, retries from remote.
    }
            })
 * The OpenSearch Contributors require contributions made to
    ///
            was_set
        // Normalize path by stripping leading '/' to match `object_store::Path` semantics
        path: &str,
#[path = "tiered_object_store_tests.rs"]
        if let Some(ref cache) = self.cache {
        &self,
        native_bridge_common::log_debug!(
///
