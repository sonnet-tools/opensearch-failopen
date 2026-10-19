    });
//!
//!   index (no per-page string stats). Built for **all row groups** (an empty
pub fn offset_index_cache_stats() -> ScopedCacheStats {
//! [`read_columns_indexes`]/[`read_offset_indexes`] (the only public subset
// Every test that touches the caches above must hold `crate::test_process_globals::lock` for its
        OFFSET_INDEX_CACHE.set_limit(limit);
//!   *predicate* (independent of what you `SELECT`), so the same filter shares
    OFFSET_INDEX_CACHE.stats()
 */
pub fn evict_file_from_scoped_cache(file_path: &str) {
//! - **ColumnIndex — predicate-driven.** Read only at *prune* time, and only for
 *
}
pub use page_index_io::load_scoped_page_index_cols;
//! Parquet metadata loading pulls the **entire page index** — `ColumnIndex`
//! decode/IO error) makes the load return `None`. The caller keeps its
//! The level-1 metadata cache is kept footer-only (see
pub fn set_offset_index_cache_limit(limit: usize) {
//! DataFusion / parquet, with **different natural cache keys**. Forcing
}
//!
pub fn column_index_cache_stats() -> ScopedCacheStats {
/// Returns true when whole-region page-index fetch is enabled (remote stores).
}
// whole body — distinct fixtures alone aren't enough, since the `InMemory` path is always
        limit_bytes: a.limit_bytes.max(b.limit_bytes),
/// local stores there is no warm tier and fewer bytes is better, so it stays off.
//!
        evictions: a.evictions + b.evictions,
//! # Why this exists
//! is the wrong signal for "served from cache" — assert via the per-cache hit
    ScopedCacheStats {
 * compatible open source license.
pub(crate) static WHOLE_REGION_FETCH_ENABLED: AtomicBool = AtomicBool::new(false);
pub(crate) static SCOPED_PAGE_INDEX_ENABLED: AtomicBool = AtomicBool::new(true);
        BoundedCache::with_named_policy(DEFAULT_SCOPED_CACHE_LIMIT, CacheEvictionPolicy::Fifo)
 * The OpenSearch Contributors require contributions made to
pub mod page_index_io;
    OFFSET_INDEX_CACHE.clear_keep_limit();
/// Toggled via `datafusion.scoped_page_index.enabled` dynamic cluster setting.
        used_bytes: a.used_bytes + b.used_bytes,
//! `set_column_index`/`set_offset_index`.
}
/*
pub use cache_store::ScopedCacheStats;
/// Drop all entries and reset counters in BOTH caches, keeping the budgets. For
//!   and at prune time for the predicate column, and at column 0 for the
#[cfg(test)]
pub fn is_scoped_page_index_enabled() -> bool {
/// exact byte-range string, and eager shard-init populates the whole-region range,
    if limit > 0 {
/// Called when a segment file is deleted or replaced so stale cells don't survive
    let b = offset_index_cache_stats();
// runtime manager and the global `RuntimeEnv` registration, so one lock covers all of it.
//! merged in #8797 / #8714 for encoding stats). None yet expose a page-index
/// When false, `metadata_cache::put` retains the full page index (fallback mode),
// Process-global caches
/// Whether the page-index loader fetches each file's WHOLE index region in one
}
///
#[cfg(test)]
//! counters ([`column_index_cache_stats`] / [`offset_index_cache_stats`]).
    COLUMN_INDEX_CACHE.clear_keep_limit();
//! decoders). Migrate to `ParquetMetaDataOptions` when it grows a page-index knob.
//! # Two caches, because the two indexes have different drivers
/// Set the ColumnIndex cache's byte budget. Called from startup wiring with the
//!
        entries: a.entries + b.entries,
//!   Key: `(file, predicate_cols, surviving_rgs)`. Deterministic in the
//! Any failure (file has no page index, a column lacks an index range, a
/// Evict all page-index cells for a specific file from both caches.
/// Combined view (sum of both caches) — test-only convenience for assertions that
//! `ParquetOffsetIndex`) — never a full `ParquetMetaData` (no footer
pub fn is_whole_region_fetch_enabled() -> bool {
pub(crate) fn clear_scoped_cache_for_test() {
//!
/// Counters + occupancy of the OffsetIndex (projection-driven) cache. Lock-free.
//!
//! them into one key makes the projection-driven OffsetIndex poison the
/// Enable/disable whole-region page-index fetch. Called from `create_reader` based
    if limit > 0 {
    COLUMN_INDEX_CACHE.set_limit(limit);
    OFFSET_INDEX_CACHE.evict_by_prefix(file_path);
}
    COLUMN_INDEX_CACHE.set_limit(DEFAULT_SCOPED_CACHE_LIMIT);
    Lazy::new(|| {
    crate::test_process_globals::assert_held("the scoped page-index caches");
    }
//!   columns (`InMemoryRowGroup::fetch_ranges`, `projection.leaf_included(idx)`),
    BoundedCache::with_named_policy(DEFAULT_SCOPED_CACHE_LIMIT, CacheEvictionPolicy::Fifo)
/// operational testing — reset and re-measure without a cluster restart.
//! duplication). On lookup the two are **grafted** onto the caller's
/// Returns true when the scoped page-index feature is enabled (default).
pub fn set_column_index_cache_limit(limit: usize) {
//!   its entry across scan paths **and** across queries with different
}
/// from a re-written file would otherwise be served as hits — wrong data.
}
//! arrow-rs is moving toward first-class selective metadata decoding
//! (per-page min/max; the per-page *string* min/max is the heap hog) plus
});
//! the prior iteration). So they are split:
    resolve_predicate_parquet_columns, resolve_predicate_parquet_columns_pair,
//!   the predicate column being evaluated
/// two caches separately ([`column_index_cache_stats`] / [`offset_index_cache_stats`]).
 * SPDX-License-Identifier: Apache-2.0
//! [`crate::cache`]); this module rebuilds a *scoped* page index per query and
//!
/// and the scoped optimizer/augmentation loops are no-ops.
use datafusion::parquet::file::page_index::column_index::ColumnIndexMetaData;
//!
/// Process-global kill-switch for the scoped page-index feature.
pub(crate) fn scoped_cache_stats() -> ScopedCacheStats {
//! `OffsetIndex` (per-page byte offsets), for every column of every row group.
/// Set the OffsetIndex cache's byte budget. Called from startup wiring with the
use std::sync::atomic::{AtomicBool, Ordering};
//! **Consequence for tests:** a lookup returns a *fresh* `Arc`, so `Arc::ptr_eq`
//! column/row-group projection, so we hand-roll it with the deprecated
/// Set from `create_reader` when a Java-supplied (remote) store is wired in.
pub mod cache_keys;
//!   projections. This is the heavy index (string min/max) and the big heap win.
//! Scoped parquet page-index caches — TWO caches, by consumer.
//!   OffsetIndex on a row group DataFusion scans panics / breaks reads, and
pub(crate) fn set_column_index_cache_limit_for_test(limit: usize) {
        misses: a.misses + b.misses,
    COLUMN_INDEX_CACHE.evict_by_prefix(file_path);
//! The `ColumnIndex` and `OffsetIndex` are consumed by different parts of
    SCOPED_PAGE_INDEX_ENABLED.load(Ordering::Relaxed)
    COLUMN_INDEX_CACHE.clear_keep_limit();
pub fn set_whole_region_fetch_enabled(enabled: bool) {
// specific to these caches on purpose: a doc-values cursor open inserts here *and* reads the
/// Enable or disable the scoped page-index feature. Called from the Java settings consumer.
pub mod cache_store;
 * this file be licensed under the Apache-2.0 license or a
//!   Scoped to predicate columns (`NONE` placeholders elsewhere) and, optionally,
/// configured limit. Idempotent; shrinking evicts immediately. Zero ignored.
#[cfg(test)]
//!
//! row group) — never a wrong result.
pub mod column_schema_resolver;
/// configured limit. Idempotent; shrinking evicts immediately. Zero ignored.
        COLUMN_INDEX_CACHE.set_limit(limit);
//!   `projection_cols = predicate ∪ projection ∪ {0}`. This is the cheap, fixed-width
//!   to the row groups that pass footer-stats pruning ([`surviving_row_groups`]).
//!
}
///
/// Only worthwhile on a remote/warm object store: the warm tier is keyed by the
    let a = column_index_cache_stats();
//! caches it, shared by both scan paths (the DataFusion `ListingTable` path and
}
pub fn clear_scoped_cache() {
//! predicate-driven ColumnIndex's broad cross-path sharing (the failure mode of
    WHOLE_REGION_FETCH_ENABLED.store(enabled, Ordering::Relaxed);
use cache_store::{BoundedCache, DEFAULT_SCOPED_CACHE_LIMIT};
}
/// `get_ranges` (decode stays scoped) instead of per-column scoped fetches.
/// so a narrower per-column fetch computes a different key and misses. Fetching the
//! ## Upstream note
//! (apache/arrow-rs#8643 open; the `ParquetStatisticsPolicy::skip_except` pattern
}
use cache_keys::{CiCellKey, OiCellKey, OiColumn};
//! the custom indexed-table executor).
//! footer-only metadata and the pruner conservatively no-ops (scans the whole
//!   DataFusion chooses the scanned set itself, after our load).
/// Counters + occupancy of the ColumnIndex (predicate-driven) cache. Lock-free.
//!   (`page_filter::PagesPruningStatistics`, `offset_index[rg][predicate_col]`).
        hits: a.hits + b.hits,
}
//! already-resident footer via [`ParquetMetaData::into_builder`] →
    COLUMN_INDEX_CACHE.stats()
pub(crate) static COLUMN_INDEX_CACHE: Lazy<BoundedCache<CiCellKey, ColumnIndexMetaData>> =
// "data.parquet" and the hit/miss counters are process-wide whatever the key is. That lock is not
};
/// no freshness check (unlike the metadata cache's `is_valid_for`), so stale cells
    WHOLE_REGION_FETCH_ENABLED.load(Ordering::Relaxed)
/// on whether a remote object store is in use (`store_ptr > 0`).
//! - **OffsetIndex — projection-driven.** Read at *scan* time for **projected**
pub use column_schema_resolver::{
//!
/// only need "is the scoped machinery doing anything". Production code reads the
    }
/// whole region makes the query's key match what warming wrote → a warm hit. For
//!
//! On wide schemas this is very memory expensive.
    }
    OFFSET_INDEX_CACHE.clear_keep_limit();
//!   page-skip metric. Key: `(file, projection_cols)` where
use crate::cache::eviction_policy::CacheEvictionPolicy;
pub(crate) static OFFSET_INDEX_CACHE: Lazy<BoundedCache<OiCellKey, OiColumn>> = Lazy::new(|| {
use once_cell::sync::Lazy;
/// Clear both caches AND restore the default limit on each.
//! Each cache stores only its decoded vector (`ParquetColumnIndex` /
    SCOPED_PAGE_INDEX_ENABLED.store(enabled, Ordering::Relaxed);
/// in the cache under the same `(path, col, rg)` key. The page-index caches have
pub fn set_scoped_page_index_enabled(enabled: bool) {
    OFFSET_INDEX_CACHE.set_limit(DEFAULT_SCOPED_CACHE_LIMIT);
//! ## Correctness / fallback
