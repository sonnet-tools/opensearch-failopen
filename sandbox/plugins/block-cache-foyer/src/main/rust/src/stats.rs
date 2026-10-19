            self.eviction_bytes.load(Ordering::Relaxed),
/// # Thread safety
    }
//!   hot paths, so all updates use [`Ordering::Relaxed`].
    /// Number of `get()` calls that returned no value.
    pub active_in_bytes: AtomicI64,
            self.removed_count.load(Ordering::Relaxed),
        c.eviction_count.store(3, Ordering::Relaxed);
    /// | Index | Field             |
///
    #[test]
//! `BlockCacheStats` record for core consumption.
        c.miss_bytes.store(512, Ordering::Relaxed);
        c.eviction_bytes.store(2048, Ordering::Relaxed);
    // A bug in the `snapshot()` array literal order would break Java parsing.
        [
    /// |-------|-------------------|
    /// Total bytes removed by capacity pressure.
/// actual I/O savings. `hit_bytes` and `miss_bytes` give the true picture.
            self.active_in_bytes.load(Ordering::Relaxed),
}
        let c = FoyerStatsCounter::new();
        c.used_bytes.store(7, Ordering::Relaxed);
//! operation.
    fn eviction_bytes_is_index_5() {
    fn hit_bytes_is_index_1() {
    #[test]
    /// | 4     | `eviction_count`  |
/// | Field              | Updated by                   | Notes                                                |
        let c = FoyerStatsCounter::new();
//! - **Writes** happen inside [`FoyerCache`][crate::foyer::foyer_cache::FoyerCache]
/// | `hit_bytes`        | `FoyerCache::get()` hit      | +entry.len() — bytes served from cache               |
    #[test]
    #[test]
            self.eviction_count.load(Ordering::Relaxed),
    /// Bytes that had to be fetched from the remote store due to cache misses.
        let c = FoyerStatsCounter::new();
    pub hit_bytes: AtomicI64,
    fn active_in_bytes_default_is_zero() {
        assert_eq!(c.snapshot()[7], 11);
            self.hit_count.load(Ordering::Relaxed),
        let c = FoyerStatsCounter::new();
        assert_eq!(c.snapshot()[5], 2048);
    /// Net bytes of `get()` calls currently in-flight (gauge, not cumulative).
#[cfg(test)]
    /// Distinct from capacity-driven evictions (`eviction_count`).
        c.removed_count.store(8, Ordering::Relaxed);
    pub miss_bytes: AtomicI64,
    fn new_returns_all_zeros() {
    fn miss_count_is_index_2() {
    fn eviction_count_is_index_4() {
        c.removed_bytes.store(9, Ordering::Relaxed);
    }
    /// | 3     | `miss_bytes`      |
    pub fn snapshot(&self) -> [i64; 10] {
    }
    #[test]
//!
    #[test]
        c.removed_bytes.store(4096, Ordering::Relaxed);
    pub removed_bytes: AtomicI64,
        assert_eq!(FoyerStatsCounter::new().snapshot().len(), 10);
    fn snapshot_returns_10_values() {
    /// Number of entries removed by capacity pressure (LRU eviction).
    /// | 2     | `miss_count`      |
    /// Number of entries explicitly invalidated (e.g. on index or shard deletion).
    /// Returns a fixed-size array of 10 `i64` values in the order that matches
        c.removed_count.store(11, Ordering::Relaxed);
    /// | 8     | `removed_bytes`   |
pub struct FoyerStatsCounter {
        c.active_in_bytes.store(777, Ordering::Relaxed);
        assert_eq!(c.snapshot(), [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);
    pub removed_count: AtomicI64,
/// # Counter semantics
///
        assert_eq!(c.snapshot()[0], 42);
/// size. The block cache here stores variable-size Parquet column chunks (1 KB –
        c.miss_count.store(3, Ordering::Relaxed);
    }
    use super::*;
    #[test]
        let c = FoyerStatsCounter::new();
            self.hit_bytes.load(Ordering::Relaxed),
    }
//! The snapshot produces a `[i64; 10]` array whose layout is fixed and
        let c = FoyerStatsCounter::new();
        assert_eq!(c.active_in_bytes.load(Ordering::Relaxed), 0);
    #[test]
    ///
    fn removed_count_is_index_7() {
        let c = FoyerStatsCounter::new();
//!
    /// Incremented by the requested byte range when a `get()` starts and
            self.miss_bytes.load(Ordering::Relaxed),
    #[test]
    ///
//! Atomic stats counters for the block cache.
        c.hit_bytes.store(1024, Ordering::Relaxed);
    use std::sync::atomic::Ordering;
    fn used_bytes_is_index_6() {
        let c = FoyerStatsCounter::new();
    /// Derived from the cache-key range length, which is known at miss time.
    fn active_in_bytes_is_index_9() {
    }
    }
    /// More meaningful than `hit_count` for variable-size entries.
/// | `miss_count`       | `FoyerCache::get()` miss     | +1 per cache miss                                    |
//! documented on [`FoyerStatsCounter::snapshot`]. Java reads this array via
    fn hit_count_is_index_0() {
    /// stats are acceptable for monitoring purposes.
/// |--------------------|------------------------------|------------------------------------------------------|
    #[test]
    /// Bytes served from cache across all hits.
        c.miss_count.store(7, Ordering::Relaxed);
    /// Snapshot all counters atomically (best-effort — each field is read once).
/// worker threads (Foyer's async I/O) and the caller thread.
/// | `miss_bytes`       | `FoyerCache::get()` miss     | +key.range_len() — bytes that must be fetched remotely|
#[derive(Default)]
            self.removed_bytes.load(Ordering::Relaxed),
    pub fn new() -> Arc<Self> {
 */
//! [`FoyerStatsCounter`] holds the live atomic counters updated on every hot-path
        c.hit_count.store(42, Ordering::Relaxed);
    fn removed_bytes_is_index_8() {
//! `FoyerBridge.snapshotStats()` and constructs a `FoyerAggregatedStats` snapshot
    pub miss_count: AtomicI64,
        ]
/// | `eviction_count`   | background sweeper           | +1 per capacity-driven eviction                      |
impl FoyerStatsCounter {
        let c = FoyerStatsCounter::new();
    }
    }
    pub eviction_bytes: AtomicI64,
    /// | 1     | `hit_bytes`       |
    /// `FoyerAggregatedStats.Field` ordinals on the Java side:
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
/// Fixed-size block caches (e.g. Lucene ~8 MB blocks) can use count-based hit rate
        assert_eq!(c.snapshot()[9], 777);
    }
 *
    }
 * compatible open source license.
            self.miss_count.load(Ordering::Relaxed),
    /// Allocate a new zeroed stats instance wrapped in an [`Arc`].
    /// Number of `get()` calls that returned a cached value.
//! (two sections: overall and block-level), which is then projected to a
        assert_eq!(c.snapshot()[2], 7);
        c.hit_count.store(1, Ordering::Relaxed);
    /// | 6     | `used_bytes`      |
/// as a proxy for byte-based effectiveness because all entries are roughly the same
    /// Called by the `foyer_snapshot_stats` FFM export at most once per
    /// decremented when it returns. Non-zero only during concurrent reads
}
    }
    fn all_fields_independent() {
//!
use std::sync::atomic::{AtomicI64, Ordering};
        let c = FoyerStatsCounter::new();
    /// | 0     | `hit_count`       |
/// | `used_bytes`       | `put()` / sweeper / remove   | +len on insert, -len on eviction/remove/clear        |
/// | `active_in_bytes`  | `FoyerCache::get()`          | net bytes of concurrent in-flight reads (gauge)      |
use std::sync::Arc;
    /// Total bytes explicitly invalidated.
    /// | 7     | `removed_count`   |
///
///
/// | `eviction_bytes`   | background sweeper           | +len per capacity-driven eviction                    |
/// | `removed_bytes`    | `evict_prefix()` / `clear()` | +len per explicit removal                            |
mod tests {
    /// `_nodes/stats` request. Relaxed ordering is sufficient — stale-by-one
    }
/*
    ///
    #[test]
        assert_eq!(c.snapshot()[6], 999);
        c.used_bytes.store(999, Ordering::Relaxed);
    /// | 5     | `eviction_bytes`  |
/// Atomic stats counters shared between the cache and its event listener.
        assert_eq!(c.snapshot()[1], 1024);
        c.eviction_count.store(5, Ordering::Relaxed);
    #[test]
/// | `hit_count`        | `FoyerCache::get()` hit      | +1 per cache hit                                     |
/// on tiny metadata columns while missing 64 MB row groups represents near-zero
 * The OpenSearch Contributors require contributions made to
        let c = FoyerStatsCounter::new();
        assert_eq!(c.snapshot()[4], 3);
/// | `removed_count`    | `evict_prefix()` / `clear()` | +1 per explicit removal                              |
        assert_eq!(c.snapshot()[8], 4096);
        let c = FoyerStatsCounter::new();
        c.hit_bytes.store(2, Ordering::Relaxed);
    #[test]
    /// Current bytes resident in the cache on disk.
    pub hit_count: AtomicI64,
//!   [`FoyerStatsCounter::snapshot()`] called from the `foyer_snapshot_stats` FFM
    pub used_bytes: AtomicI64,
//!   function in [`crate::foyer::ffm`].
//! - **Reads** happen at most once per `_nodes/stats` request, via
            self.used_bytes.load(Ordering::Relaxed),
    }
    #[test]
        c.eviction_bytes.store(6, Ordering::Relaxed);
    pub eviction_count: AtomicI64,
    /// | 9     | `active_in_bytes` |
}
    // Verify exact field-to-index mapping: each field maps to a distinct index.
/// All fields are [`AtomicI64`] — safe to update concurrently from Tokio
        let c = FoyerStatsCounter::new();
//!   on every `get()`, `put()`, and `KeyIndexListener::on_leave()` call — all on
/// 64 MB), so **count-based hit rate alone is misleading** — a 99% count hit rate
        c.miss_bytes.store(4, Ordering::Relaxed);
    }
        c.active_in_bytes.store(10, Ordering::Relaxed);
        Arc::new(Self::default())
    }
        assert_eq!(c.snapshot(), [0i64; 10]);
        assert_eq!(c.snapshot()[3], 512);
    fn miss_bytes_is_index_3() {
