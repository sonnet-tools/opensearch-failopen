        key: &'a CacheKey,
//!
        Box::pin(async move {
        &self.metadata_cache
const DEFAULT_MAX_DATA_ENTRY_SIZE: u64 = 32 * 1024 * 1024;
 */
        self.data_cache.clear_sync();
impl TieredBlockCache {
    }
    pub fn max_data_entry_size(&self) -> u64 {
use std::sync::Arc;
    }
    }
            // On warm restart, Foyer recovers these from disk — instant hit.
    }
        })
//!
    }
/// Default max data entry size: 32MB.
impl BlockCache for TieredBlockCache {
use crate::foyer::foyer_cache::FoyerCache;
        self.data_cache.put(key, data);
            "[tiered-block-cache] max_metadata_entry_size updated to {}B",
        self
        // Data cache put — entries exceeding max_data_entry_size are skipped.
    }
//! via `RecoverMode::Quiet`. After restart, `get()` probes metadata cache first
            native_bridge_common::log_info!("[tiered-block-cache] cleared");
    }
}
//! reclaimer — they are always reinserted.
        native_bridge_common::log_info!(
        let limit = self.max_data_entry_size.load(Ordering::Relaxed);
    fn get<'a>(
 * The OpenSearch Contributors require contributions made to
//! reinsertion). The metadata cache is a smaller SSD-backed [`FoyerCache`] configured
/// Covers individual column chunks for most schemas. Skips full-RG fetches.
    /// Access the underlying data cache (e.g. for stats).
        // Delegate to the inherent method which applies the size bound.
        Self {
}
            metadata_cache,
/// - `put_metadata()` → metadata cache if entry ≤ max_metadata_entry_size, else skip.
    ///
const DEFAULT_MAX_METADATA_ENTRY_SIZE: u64 = 8 * 1024 * 1024;
/// ## Lookup order
}
    /// Entries exceeding max_metadata_entry_size are skipped (not cached).
        &'a self,
        self.max_data_entry_size.load(Ordering::Relaxed)
    }
    fn clear(&self) -> std::pin::Pin<Box<dyn std::future::Future<Output = ()> + Send + '_>> {
        native_bridge_common::log_info!(
//!
/// - `put()` → data cache if entry ≤ max_data_entry_size, else skip.
            size
pub struct TieredBlockCache {
///
//! [`TieredBlockCache`] — routes entries between a data cache and a metadata cache.
/// `get()` always probes metadata cache first (small, fast), then data cache.
    }
    /// Clear all entries synchronously.
//! No persistence needed for routing state. Foyer recovers metadata SSD blocks
/// Covers up to ~1000-column schemas with page indexes.
//! ## Routing
    pub async fn wait_for_flush(&self) {
//!
            max_metadata_entry_size: AtomicU64::new(DEFAULT_MAX_METADATA_ENTRY_SIZE),
//! - `put_metadata()`: explicit warmup call — goes to metadata cache only.
            data_cache.disk_bytes,
        native_bridge_common::log_info!("[tiered-block-cache] clear_sync completed");
    pub(crate) fn clear_sync(&self) {
///
            self.data_cache.get(key).await
        self.metadata_cache.wait_for_flush().await;
            if let Some(bytes) = self.metadata_cache.get(key).await {
        }
    }
    max_data_entry_size: AtomicU64,
    fn put(&self, key: &CacheKey, data: Bytes) {
/// ## Write routing
        );
        self.max_data_entry_size.store(size, Ordering::Relaxed);
///
    /// Update max data entry size dynamically. Takes effect immediately.
    /// Put bytes into the metadata cache. Called during shard warmup only.
    /// Wait for both caches' flushers to drain. After this, all entries are on
    pub fn metadata_cache(&self) -> &FoyerCache {
            // Fall through to data cache.
/// A two-tier block cache: metadata cache + data cache on separate SSDs.
//! - `put()`: always goes to data cache (normal query-time caching).
    fn evict_prefix(&self, prefix: &str) {
    pub fn put_metadata(&self, key: &CacheKey, data: Bytes) {
///
            max_data_entry_size: AtomicU64::new(DEFAULT_MAX_DATA_ENTRY_SIZE),
        }
        native_bridge_common::log_info!(
            return;
                return Some(bytes);
            data_cache,
            DEFAULT_MAX_DATA_ENTRY_SIZE
 * compatible open source license.
    }
            DEFAULT_MAX_METADATA_ENTRY_SIZE,
        self.metadata_cache.clear_sync();
    pub fn update_max_metadata_entry_size(&self, size: u64) {
    max_metadata_entry_size: AtomicU64,
    fn put_metadata(&self, key: &CacheKey, data: Bytes) {
        Box::pin(async move {
//! The data cache is a large SSD-backed [`FoyerCache`] with default eviction (RejectAll
//! and finds the recovered entries — zero S3 calls for metadata.
///
        TieredBlockCache::put_metadata(self, key, data);
//! with AdmitAll reinsertion so that metadata entries are never evicted by the disk
        })
    /// Metadata cache uses LRU eviction on a separate SSD.
            size
        self.data_cache.wait_for_flush().await;
//! ## Restart
            self.metadata_cache.clear_sync();
 * this file be licensed under the Apache-2.0 license or a
    pub fn data_cache(&self) -> &FoyerCache {
/// Default max metadata entry size: 8MB.
 * SPDX-License-Identifier: Apache-2.0
    /// Current max data entry size (used by TieredObjectStore for get_opts threshold).
    }
            // Metadata cache first — small SSD, fast probe, never evicts.
        if data.len() as u64 > limit {
        if data.len() as u64 > limit {
             max_metadata_entry={}B, max_data_entry={}B",
use bytes::Bytes;
    pub fn update_max_data_entry_size(&self, size: u64) {
/// without caching). This bounds memory usage for large entries.
use crate::range_cache::CacheKey;
        &self.data_cache
    /// Access the underlying metadata cache (e.g. for stats).
    metadata_cache: Arc<FoyerCache>,
        self.data_cache.evict_prefix(prefix);
    /// Max entry size for data cache. Entries larger than this are not cached.
            "[tiered-block-cache] created: data_disk={}B, metadata_disk={}B, \
            self.data_cache.clear_sync();
    /// SSD and findable via get(). Used in tests and warmup to ensure durability.
            metadata_cache.disk_bytes,
use std::sync::atomic::{AtomicU64, Ordering};
        self.max_metadata_entry_size.store(size, Ordering::Relaxed);
    }
            return;
    pub fn new(data_cache: Arc<FoyerCache>, metadata_cache: Arc<FoyerCache>) -> Self {
    /// Max entry size for metadata cache. Entries larger than this are not cached.
        }
    /// Update max metadata entry size dynamically. Takes effect immediately.
/// Entries exceeding their respective limits are not cached (returned to caller
 *
        let limit = self.max_metadata_entry_size.load(Ordering::Relaxed);
//!
        );
use crate::traits::BlockCache;
    }
        self.metadata_cache.put(key, data);
        self.metadata_cache.evict_prefix(prefix);
    }
    fn as_any(&self) -> &dyn std::any::Any {
/*
            }
//! - `get()`: tries metadata cache first, then data cache. No marking needed.
    ) -> std::pin::Pin<Box<dyn std::future::Future<Output = Option<Bytes>> + Send + 'a>> {
    data_cache: Arc<FoyerCache>,
        );
            "[tiered-block-cache] max_data_entry_size updated to {}B",
