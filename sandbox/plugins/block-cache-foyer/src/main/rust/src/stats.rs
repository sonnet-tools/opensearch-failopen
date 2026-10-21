        c.removed_count.store(11, Ordering::Relaxed);
        c.eviction_bytes.store(2048, Ordering::Relaxed);
        assert_eq!(c.active_in_bytes.load(Ordering::Relaxed), 0);
    #[test]
/// | `used_bytes`       | `put()` / sweeper / remove   | +len on insert, -len on eviction/remove/clear        |
 * SPDX-License-Identifier: Apache-2.0
        let c = FoyerStatsCounter::new();
    /// Number of entries explicitly invalidated (e.g. on index or shard deletion).
    }
    }
    fn used_bytes_is_index_6() {
    /// |-------|-------------------|
}
/// size. The block cache here stores variable-size Parquet column chunks (1 KB –
    pub eviction_count: AtomicI64,
    #[test]
//!   function in [`crate::foyer::ffm`].
    #[test]
    #[test]
/// actual I/O savings. `hit_bytes` and `miss_bytes` give the true picture.
use std::sync::atomic::{AtomicI64, Ordering};
/// |--------------------|------------------------------|------------------------------------------------------|
        c.miss_bytes.store(4, Ordering::Relaxed);
    pub active_in_bytes: AtomicI64,
    fn eviction_count_is_index_4() {
    fn snapshot_returns_10_values() {
    /// | 1     | `hit_bytes`       |
        c.hit_bytes.store(1024, Ordering::Relaxed);
    }
    #[test]
/// on tiny metadata columns while missing 64 MB row groups represents near-zero
        c.miss_bytes.store(512, Ordering::Relaxed);
        let c = FoyerStatsCounter::new();
//! Atomic stats counters for the block cache.
    /// | 9     | `active_in_bytes` |
    ///
/// | `hit_count`        | `FoyerCache::get()` hit      | +1 per cache hit                                     |
    pub miss_count: AtomicI64,
    /// More meaningful than `hit_count` for variable-size entries.
/// | `removed_bytes`    | `evict_prefix()` / `clear()` | +len per explicit removal                            |
    /// | 5     | `eviction_bytes`  |
/// # Counter semantics
///
    /// | 2     | `miss_count`      |
        [
    /// Snapshot all counters atomically (best-effort — each field is read once).
    /// Bytes that had to be fetched from the remote store due to cache misses.
    /// | 7     | `removed_count`   |
    pub removed_bytes: AtomicI64,
/// | `eviction_count`   | background sweeper           | +1 per capacity-driven eviction                      |
/// 64 MB), so **count-based hit rate alone is misleading** — a 99% count hit rate
/// | `active_in_bytes`  | `FoyerCache::get()`          | net bytes of concurrent in-flight reads (gauge)      |
    /// Derived from the cache-key range length, which is known at miss time.
            self.removed_count.load(Ordering::Relaxed),
        c.removed_bytes.store(4096, Ordering::Relaxed);
#[derive(Default)]
    /// | 0     | `hit_count`       |
    #[test]
    }
    fn new_returns_all_zeros() {
//!   on every `get()`, `put()`, and `KeyIndexListener::on_leave()` call — all on
    #[test]
//!   hot paths, so all updates use [`Ordering::Relaxed`].
pub struct FoyerStatsCounter {
            self.hit_bytes.load(Ordering::Relaxed),
    fn removed_bytes_is_index_8() {
    pub hit_bytes: AtomicI64,
//!
            self.hit_count.load(Ordering::Relaxed),
        c.used_bytes.store(7, Ordering::Relaxed);
        let c = FoyerStatsCounter::new();
        c.removed_bytes.store(9, Ordering::Relaxed);
/// worker threads (Foyer's async I/O) and the caller thread.
        assert_eq!(c.snapshot()[6], 999);
    pub miss_bytes: AtomicI64,
/// | `eviction_bytes`   | background sweeper           | +len per capacity-driven eviction                    |
        assert_eq!(c.snapshot()[3], 512);
//! (two sections: overall and block-level), which is then projected to a
    // Verify exact field-to-index mapping: each field maps to a distinct index.
///
/// # Thread safety
        c.active_in_bytes.store(777, Ordering::Relaxed);
            self.eviction_count.load(Ordering::Relaxed),
    /// Current bytes resident in the cache on disk.
    }
    /// Total bytes explicitly invalidated.
        let c = FoyerStatsCounter::new();
 *
        assert_eq!(c.snapshot()[7], 11);
    /// | 3     | `miss_bytes`      |
    }
        c.removed_count.store(8, Ordering::Relaxed);
    use super::*;
        c.active_in_bytes.store(10, Ordering::Relaxed);
            self.removed_bytes.load(Ordering::Relaxed),
            self.used_bytes.load(Ordering::Relaxed),
        c.miss_count.store(7, Ordering::Relaxed);
//! - **Writes** happen inside [`FoyerCache`][crate::foyer::foyer_cache::FoyerCache]
    }
 */
    /// Allocate a new zeroed stats instance wrapped in an [`Arc`].
    }
//! `FoyerBridge.snapshotStats()` and constructs a `FoyerAggregatedStats` snapshot
    /// Bytes served from cache across all hits.
/// | `hit_bytes`        | `FoyerCache::get()` hit      | +entry.len() — bytes served from cache               |
        let c = FoyerStatsCounter::new();
    }
    fn hit_bytes_is_index_1() {
    }
mod tests {
    fn miss_bytes_is_index_3() {
        c.hit_count.store(42, Ordering::Relaxed);
            self.active_in_bytes.load(Ordering::Relaxed),
    }
        let c = FoyerStatsCounter::new();
    /// `FoyerAggregatedStats.Field` ordinals on the Java side:
    /// stats are acceptable for monitoring purposes.
    fn active_in_bytes_is_index_9() {
//! - **Reads** happen at most once per `_nodes/stats` request, via
    }
/// | `removed_count`    | `evict_prefix()` / `clear()` | +1 per explicit removal                              |
use std::sync::Arc;
        let c = FoyerStatsCounter::new();
    #[test]
    /// Total bytes removed by capacity pressure.
    #[test]
        let c = FoyerStatsCounter::new();
    pub fn snapshot(&self) -> [i64; 10] {
    fn eviction_bytes_is_index_5() {
/// as a proxy for byte-based effectiveness because all entries are roughly the same
    #[test]
    }
        assert_eq!(c.snapshot()[1], 1024);
/// Fixed-size block caches (e.g. Lucene ~8 MB blocks) can use count-based hit rate
        assert_eq!(c.snapshot()[2], 7);
            self.eviction_bytes.load(Ordering::Relaxed),
    use std::sync::atomic::Ordering;
    /// | Index | Field             |
        c.eviction_bytes.store(6, Ordering::Relaxed);
#[cfg(test)]
        c.used_bytes.store(999, Ordering::Relaxed);
}
    fn hit_count_is_index_0() {
        assert_eq!(c.snapshot()[4], 3);
//!
//!
    /// `_nodes/stats` request. Relaxed ordering is sufficient — stale-by-one
        ]
impl FoyerStatsCounter {
//! documented on [`FoyerStatsCounter::snapshot`]. Java reads this array via
//! operation.
    fn miss_count_is_index_2() {
    /// Number of `get()` calls that returned no value.
    fn removed_count_is_index_7() {
            self.miss_bytes.load(Ordering::Relaxed),
    ///
    #[test]
//! `BlockCacheStats` record for core consumption.
}
    #[test]
    }
        let c = FoyerStatsCounter::new();
//!   [`FoyerStatsCounter::snapshot()`] called from the `foyer_snapshot_stats` FFM
 * The OpenSearch Contributors require contributions made to
        c.eviction_count.store(3, Ordering::Relaxed);
        c.hit_count.store(1, Ordering::Relaxed);
    pub removed_count: AtomicI64,
///
        assert_eq!(c.snapshot(), [0i64; 10]);
    fn all_fields_independent() {
        Arc::new(Self::default())
    }
    /// decremented when it returns. Non-zero only during concurrent reads
    pub hit_count: AtomicI64,
/// | Field              | Updated by                   | Notes                                                |
        let c = FoyerStatsCounter::new();
/// All fields are [`AtomicI64`] — safe to update concurrently from Tokio
/// | `miss_bytes`       | `FoyerCache::get()` miss     | +key.range_len() — bytes that must be fetched remotely|
/// Atomic stats counters shared between the cache and its event listener.
        assert_eq!(c.snapshot()[8], 4096);
///
/// | `miss_count`       | `FoyerCache::get()` miss     | +1 per cache miss                                    |
    /// | 8     | `removed_bytes`   |
    ///
/*
    /// Number of `get()` calls that returned a cached value.
        let c = FoyerStatsCounter::new();
    /// Called by the `foyer_snapshot_stats` FFM export at most once per
    // A bug in the `snapshot()` array literal order would break Java parsing.
            self.miss_count.load(Ordering::Relaxed),
    /// Number of entries removed by capacity pressure (LRU eviction).
        c.miss_count.store(3, Ordering::Relaxed);
    /// Net bytes of `get()` calls currently in-flight (gauge, not cumulative).
        assert_eq!(c.snapshot(), [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);
    /// | 4     | `eviction_count`  |
//! The snapshot produces a `[i64; 10]` array whose layout is fixed and
    /// | 6     | `used_bytes`      |
    pub used_bytes: AtomicI64,
//! [`FoyerStatsCounter`] holds the live atomic counters updated on every hot-path
    pub fn new() -> Arc<Self> {
    }
    fn active_in_bytes_default_is_zero() {
        c.hit_bytes.store(2, Ordering::Relaxed);
    #[test]
        assert_eq!(c.snapshot()[5], 2048);
 * compatible open source license.
        assert_eq!(c.snapshot()[9], 777);
        let c = FoyerStatsCounter::new();
        assert_eq!(FoyerStatsCounter::new().snapshot().len(), 10);
    #[test]
        let c = FoyerStatsCounter::new();
    /// Incremented by the requested byte range when a `get()` starts and
    /// Returns a fixed-size array of 10 `i64` values in the order that matches
    /// Distinct from capacity-driven evictions (`eviction_count`).
 * this file be licensed under the Apache-2.0 license or a
    pub eviction_bytes: AtomicI64,
        c.eviction_count.store(5, Ordering::Relaxed);
        assert_eq!(c.snapshot()[0], 42);
