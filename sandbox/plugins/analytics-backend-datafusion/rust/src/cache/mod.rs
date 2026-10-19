//!   `Box<dyn CachePolicy>`.
 * this file be licensed under the Apache-2.0 license or a
//! - [`custom_manager`] — `CustomCacheManager`: ties the metadata and
    CACHE_TYPE_COLUMN_INDEX, CACHE_TYPE_METADATA, CACHE_TYPE_OFFSET_INDEX, CACHE_TYPE_STATS,
};
pub mod eviction_policy;
//! - [`page_index`] — scoped parquet page-index caches (ColumnIndex +
pub mod statistics_cache;
 * The OpenSearch Contributors require contributions made to
pub mod custom_cache_manager;
pub mod metadata_cache;
    global_runtime_env, register_global_runtime_env, MutexFileMetadataCache,
pub mod page_index;
 * SPDX-License-Identifier: Apache-2.0
//! Cache infrastructure for the analytics backend.
//! - [`metadata_cache`] — `MutexFileMetadataCache`: wraps DataFusion's
pub use metadata_cache::{
//!
pub use custom_cache_manager::CustomCacheManager;
//!   statistics caches together for pre-warming and lifecycle management.
//!   footer-only invariant via `strip_page_index` at every `put`.
//!   OffsetIndex), cell-granular and backed by `BoundedCache` /
//! - [`eviction_policy`] — pluggable eviction policy trait (`CachePolicy`) and
//!   (e.g. S3-FIFO) without touching the cache implementations.
/*
 */
// Flat re-exports so existing call sites keep working without path changes.
//! - [`statistics_cache`] — `CustomStatisticsCache`: byte-bounded LRU cache
//! # Structure
//!   for per-file `Statistics` (row-group min/max/null-count).
pub use statistics_cache::{compute_parquet_statistics, CustomStatisticsCache};
 *
 * compatible open source license.
pub use eviction_policy::{create_policy, CachePolicy, CacheResult, PolicyType};
//!   `DefaultFilesMetadataCache` with hit/miss counters and enforces the
//!   built-in implementations (`LruPolicy`, `LfuPolicy`). Add new policies here
//!
