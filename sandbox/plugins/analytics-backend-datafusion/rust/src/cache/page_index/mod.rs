//! `ParquetOffsetIndex`) — never a full `ParquetMetaData` (no footer
#[cfg(test)]
use datafusion::parquet::file::page_index::column_index::ColumnIndexMetaData;
//! `set_column_index`/`set_offset_index`.
//! # Why this exists
    let a = column_index_cache_stats();
/// Evict all page-index cells for a specific file from both caches.
    COLUMN_INDEX_CACHE.clear_keep_limit();
    COLUMN_INDEX_CACHE.clear_keep_limit();
//! the custom indexed-table executor).
pub mod cache_store;
/// whole region makes the query's key match what warming wrote → a warm hit. For
 *
/// Combined view (sum of both caches) — test-only convenience for assertions that
    COLUMN_INDEX_CACHE.set_limit(limit);
/// Drop all entries and reset counters in BOTH caches, keeping the budgets. For
//!   DataFusion chooses the scanned set itself, after our load).
//! ## Correctness / fallback
// "data.parquet" and the hit/miss counters are process-wide whatever the key is. That lock is not
/*
//!   the predicate column being evaluated
/// Set from `create_reader` when a Java-supplied (remote) store is wired in.
/// Process-global kill-switch for the scoped page-index feature.
pub fn clear_scoped_cache() {
//! The `ColumnIndex` and `OffsetIndex` are consumed by different parts of
//!   columns (`InMemoryRowGroup::fetch_ranges`, `projection.leaf_included(idx)`),
//! column/row-group projection, so we hand-roll it with the deprecated
/// Whether the page-index loader fetches each file's WHOLE index region in one
// Every test that touches the caches above must hold `crate::test_process_globals::lock` for its
//!   Key: `(file, predicate_cols, surviving_rgs)`. Deterministic in the
}
pub(crate) static OFFSET_INDEX_CACHE: Lazy<BoundedCache<OiCellKey, OiColumn>> = Lazy::new(|| {
/// Enable/disable whole-region page-index fetch. Called from `create_reader` based
//! arrow-rs is moving toward first-class selective metadata decoding
//! decoders). Migrate to `ParquetMetaDataOptions` when it grows a page-index knob.
/// local stores there is no warm tier and fewer bytes is better, so it stays off.
//! (per-page min/max; the per-page *string* min/max is the heap hog) plus
//! The level-1 metadata cache is kept footer-only (see
//! - **OffsetIndex — projection-driven.** Read at *scan* time for **projected**
        hits: a.hits + b.hits,
//! # Two caches, because the two indexes have different drivers
pub mod column_schema_resolver;
//!
//! On wide schemas this is very memory expensive.
}
pub fn set_scoped_page_index_enabled(enabled: bool) {
/// Toggled via `datafusion.scoped_page_index.enabled` dynamic cluster setting.
/// operational testing — reset and re-measure without a cluster restart.
    if limit > 0 {
    OFFSET_INDEX_CACHE.clear_keep_limit();
    SCOPED_PAGE_INDEX_ENABLED.load(Ordering::Relaxed)
pub fn set_offset_index_cache_limit(limit: usize) {
    ScopedCacheStats {
//! them into one key makes the projection-driven OffsetIndex poison the
pub mod page_index_io;
    Lazy::new(|| {
/// Set the ColumnIndex cache's byte budget. Called from startup wiring with the
#[cfg(test)]
pub fn set_column_index_cache_limit(limit: usize) {
}
//! Scoped parquet page-index caches — TWO caches, by consumer.
/// from a re-written file would otherwise be served as hits — wrong data.
//! the prior iteration). So they are split:
    resolve_predicate_parquet_columns, resolve_predicate_parquet_columns_pair,
//!   projections. This is the heavy index (string min/max) and the big heap win.
//! row group) — never a wrong result.
/// Returns true when the scoped page-index feature is enabled (default).
///
    SCOPED_PAGE_INDEX_ENABLED.store(enabled, Ordering::Relaxed);
//! predicate-driven ColumnIndex's broad cross-path sharing (the failure mode of
//! - **ColumnIndex — predicate-driven.** Read only at *prune* time, and only for
    crate::test_process_globals::assert_held("the scoped page-index caches");
/// Set the OffsetIndex cache's byte budget. Called from startup wiring with the
/// and the scoped optimizer/augmentation loops are no-ops.
        entries: a.entries + b.entries,
}
    OFFSET_INDEX_CACHE.clear_keep_limit();
//! [`read_columns_indexes`]/[`read_offset_indexes`] (the only public subset
use cache_keys::{CiCellKey, OiCellKey, OiColumn};
/// two caches separately ([`column_index_cache_stats`] / [`offset_index_cache_stats`]).
pub mod cache_keys;
pub use cache_store::ScopedCacheStats;
//!   Scoped to predicate columns (`NONE` placeholders elsewhere) and, optionally,
}
/// When false, `metadata_cache::put` retains the full page index (fallback mode),
//!   *predicate* (independent of what you `SELECT`), so the same filter shares
 * compatible open source license.
//!   index (no per-page string stats). Built for **all row groups** (an empty
}
/// exact byte-range string, and eager shard-init populates the whole-region range,
//!   its entry across scan paths **and** across queries with different
/// configured limit. Idempotent; shrinking evicts immediately. Zero ignored.
        limit_bytes: a.limit_bytes.max(b.limit_bytes),
}
// specific to these caches on purpose: a doc-values cursor open inserts here *and* reads the
    BoundedCache::with_named_policy(DEFAULT_SCOPED_CACHE_LIMIT, CacheEvictionPolicy::Fifo)
pub fn column_index_cache_stats() -> ScopedCacheStats {
///
/// Only worthwhile on a remote/warm object store: the warm tier is keyed by the
        COLUMN_INDEX_CACHE.set_limit(limit);
// whole body — distinct fixtures alone aren't enough, since the `InMemory` path is always
//!   page-skip metric. Key: `(file, projection_cols)` where
/// no freshness check (unlike the metadata cache's `is_valid_for`), so stale cells
//! Each cache stores only its decoded vector (`ParquetColumnIndex` /
//!   (`page_filter::PagesPruningStatistics`, `offset_index[rg][predicate_col]`).
/// in the cache under the same `(path, col, rg)` key. The page-index caches have
        misses: a.misses + b.misses,
/// on whether a remote object store is in use (`store_ptr > 0`).
//!   and at prune time for the predicate column, and at column 0 for the
use cache_store::{BoundedCache, DEFAULT_SCOPED_CACHE_LIMIT};
/// Counters + occupancy of the OffsetIndex (projection-driven) cache. Lock-free.
    COLUMN_INDEX_CACHE.set_limit(DEFAULT_SCOPED_CACHE_LIMIT);
//!
/// Returns true when whole-region page-index fetch is enabled (remote stores).
        BoundedCache::with_named_policy(DEFAULT_SCOPED_CACHE_LIMIT, CacheEvictionPolicy::Fifo)
    let b = offset_index_cache_stats();
use once_cell::sync::Lazy;
    }
}
/// `get_ranges` (decode stays scoped) instead of per-column scoped fetches.
//!   to the row groups that pass footer-stats pruning ([`surviving_row_groups`]).
//! (apache/arrow-rs#8643 open; the `ParquetStatisticsPolicy::skip_except` pattern
    }
    WHOLE_REGION_FETCH_ENABLED.store(enabled, Ordering::Relaxed);
    }
    });
}
//!
//!
pub use column_schema_resolver::{
pub fn is_scoped_page_index_enabled() -> bool {
/// Enable or disable the scoped page-index feature. Called from the Java settings consumer.
use crate::cache::eviction_policy::CacheEvictionPolicy;
//! caches it, shared by both scan paths (the DataFusion `ListingTable` path and
    WHOLE_REGION_FETCH_ENABLED.load(Ordering::Relaxed)
pub(crate) static WHOLE_REGION_FETCH_ENABLED: AtomicBool = AtomicBool::new(false);
/// Called when a segment file is deleted or replaced so stale cells don't survive
//! `OffsetIndex` (per-page byte offsets), for every column of every row group.
pub fn offset_index_cache_stats() -> ScopedCacheStats {
//!
});
//!   `projection_cols = predicate ∪ projection ∪ {0}`. This is the cheap, fixed-width
}
// Process-global caches
//! duplication). On lookup the two are **grafted** onto the caller's
/// Clear both caches AND restore the default limit on each.
//!
//! **Consequence for tests:** a lookup returns a *fresh* `Arc`, so `Arc::ptr_eq`
 * SPDX-License-Identifier: Apache-2.0
//! is the wrong signal for "served from cache" — assert via the per-cache hit
pub(crate) fn set_column_index_cache_limit_for_test(limit: usize) {
/// Counters + occupancy of the ColumnIndex (predicate-driven) cache. Lock-free.
//!
//!
        evictions: a.evictions + b.evictions,
/// only need "is the scoped machinery doing anything". Production code reads the
//! counters ([`column_index_cache_stats`] / [`offset_index_cache_stats`]).
        used_bytes: a.used_bytes + b.used_bytes,
//! footer-only metadata and the pruner conservatively no-ops (scans the whole
 * this file be licensed under the Apache-2.0 license or a
    COLUMN_INDEX_CACHE.evict_by_prefix(file_path);
        OFFSET_INDEX_CACHE.set_limit(limit);
    OFFSET_INDEX_CACHE.evict_by_prefix(file_path);
//!
pub(crate) static COLUMN_INDEX_CACHE: Lazy<BoundedCache<CiCellKey, ColumnIndexMetaData>> =
    if limit > 0 {
    COLUMN_INDEX_CACHE.stats()
}
pub fn is_whole_region_fetch_enabled() -> bool {
}
pub use page_index_io::load_scoped_page_index_cols;
};
}
pub(crate) fn scoped_cache_stats() -> ScopedCacheStats {
use std::sync::atomic::{AtomicBool, Ordering};
pub(crate) fn clear_scoped_cache_for_test() {
//!   OffsetIndex on a row group DataFusion scans panics / breaks reads, and
//!
//! DataFusion / parquet, with **different natural cache keys**. Forcing
//! already-resident footer via [`ParquetMetaData::into_builder`] →
//! Any failure (file has no page index, a column lacks an index range, a
    OFFSET_INDEX_CACHE.set_limit(DEFAULT_SCOPED_CACHE_LIMIT);
pub(crate) static SCOPED_PAGE_INDEX_ENABLED: AtomicBool = AtomicBool::new(true);
 * The OpenSearch Contributors require contributions made to
pub fn evict_file_from_scoped_cache(file_path: &str) {
pub fn set_whole_region_fetch_enabled(enabled: bool) {
//! decode/IO error) makes the load return `None`. The caller keeps its
/// so a narrower per-column fetch computes a different key and misses. Fetching the
//! ## Upstream note
#[cfg(test)]
 */
//! [`crate::cache`]); this module rebuilds a *scoped* page index per query and
//! merged in #8797 / #8714 for encoding stats). None yet expose a page-index
    OFFSET_INDEX_CACHE.stats()
//!
/// configured limit. Idempotent; shrinking evicts immediately. Zero ignored.
//! Parquet metadata loading pulls the **entire page index** — `ColumnIndex`
// runtime manager and the global `RuntimeEnv` registration, so one lock covers all of it.
//!
