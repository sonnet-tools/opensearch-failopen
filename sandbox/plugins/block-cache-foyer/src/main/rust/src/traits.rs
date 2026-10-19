/// A disk block cache.
    ) -> std::pin::Pin<Box<dyn std::future::Future<Output = Option<Bytes>> + Send + 'a>>;
use crate::range_cache::CacheKey;
        &'a self,
///
    /// Look up a cached entry. Returns `Some(Bytes)` on hit, `None` on miss.
//! [`BlockCache`] trait — the abstraction for disk caching with typed keys.
/// tasks and threads.
    /// this falls back to `put()` — which is correct since the single-tier cache does
    /// Remove all entries from the cache.
/// Implementations must be `Send + Sync` so they can be shared across async
}
    /// For caches without a separate metadata tier (e.g., `FoyerCache` used standalone),
 */
    fn put(&self, key: &CacheKey, data: Bytes);
    /// metadata to its dedicated non-evictable metadata cache.
    /// For block entries: pass the segment base path — evicts all block keys for that segment.
    /// not distinguish metadata from data. `TieredBlockCache` overrides this to route
    /// Insert bytes under the given key (data cache — evictable by LRU).
///
    fn put_metadata(&self, key: &CacheKey, data: Bytes) {
    /// (non-evictable) tier, surviving LRU pressure from data scan workloads.
    ///
 * SPDX-License-Identifier: Apache-2.0
///
///
 * compatible open source license.
    fn get<'a>(
    /// Insert bytes into the metadata cache (never evicted by LRU).
/// string is a correct eviction prefix.
use bytes::Bytes;
/// via the helpers in [`crate::range_cache`]. This enforces the `\x1F` separator
/// Keys are [`CacheKey`] values — opaque newtypes that can only be constructed
/// `evict_prefix` still accepts `&str` because the eviction prefix is the bare
    ///
 * this file be licensed under the Apache-2.0 license or a
pub trait BlockCache: Send + Sync + std::any::Any {
/// convention at compile time and prevents accidental use of raw strings.
    /// Evict all entries whose key starts with `prefix`. A no-op if nothing matches.
 *
    fn evict_prefix(&self, prefix: &str);
        self.put(key, data);
    ///
/// file path (no separator) — there is nothing to encode, and any valid path
    fn as_any(&self) -> &dyn std::any::Any;
    fn clear(&self) -> std::pin::Pin<Box<dyn std::future::Future<Output = ()> + Send + '_>>;
    /// Called by the warmup path to ensure metadata bytes are stored in the durable
        key: &'a CacheKey,
 * The OpenSearch Contributors require contributions made to
    }
    /// For range entries: pass the file path — evicts all byte-range keys for that file.
/*
/// ## Eviction
