//!   the candidate bitset; DataFusion's
pub mod substrait_to_tree;
//! - `page_pruner`, `partitioning`, `parquet_bridge`, `metrics`, `segment_info` — support
//!
//! - `bool_tree` — `BoolNode`, `ResolvedNode`, De Morgan's normalize
//!   domain (to decide which parquet pages to read) plus a refinement
/*
pub mod bool_tree;
 *
//! All three share the same [`stream::IndexedExec`] / [`stream::IndexedStream`]
//!   or OR/NOT mixing them with predicates, or any shape that isn't a
//! bounded (~512 bytes per RG), prefetch overlap hides index-side latency.
pub mod eval;
pub mod row_selection;
//! Index-accelerated parquet queries for DataFusion.
//! - `index` — `ShardSearcher` + `RowGroupDocsCollector` trait
pub mod segment_info;
//! Three shapes of query land in this module depending on the filter tree
pub mod ffm_callbacks;
pub mod bloom_pruner;
pub mod row_id_injection;
//! # Row-group-by-row-group streaming
//!   query never reaches this module; [`crate::query_executor`] runs it
//!
//! - **No-index path** — no `index_filter(...)` calls in the plan. The
mod dynamic_filter_probe;
//! there is no shard-wide bitset API.
//! - `eval` — `RowGroupBitsetSource` trait + concrete evaluators
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
pub mod table_provider;
//!
//!   [`eval::bitmap_tree::BitmapTreeEvaluator`], which runs a two-stage
pub mod stream;
 */
//!   evaluation per row group: a candidate stage in the RoaringBitmap
//! **Invariant.** Tree evaluation always happens per row group. Bitsets stay
//! - `substrait_to_tree` — `index_filter` UDF, `expr_to_bool_tree`, `classify_filter`
mod tests_e2e;
 * compatible open source license.
//! - `table_provider` — unified `IndexedTableProvider`
#[cfg(test)]
//!
//!   with zero or more parquet-native predicates. The collector produces
//!   stage on the decoded record batches using Arrow kernels (to produce
//! # Modules
//! The [`eval::RowGroupBitsetSource`] trait enforces this structurally —
//!   into Java (provider/collector lifetime wrappers + registration)
//! - `ffm_callbacks` — FFM upcall surface for the filter-tree callbacks
//! # Execution paths
//!   as a plain `ListingTable` scan.
//!
//!
//! - `stream` — unified `IndexedExec` + `IndexedStream`
//! - **Multi-filter tree path** — multiple `index_filter(...)` calls,
//!   flat AND-of-one-collector-plus-predicates. Uses
//! / [`table_provider::IndexedTableProvider`]. The evaluator choice is the
pub mod index;
//!
//! only thing that varies.
pub mod page_pruner;
 * this file be licensed under the Apache-2.0 license or a
pub mod dynamic_filter;
pub mod parquet_bridge;
//!   the exact per-row answer).
//!   applies the residual predicates during decode. See
//!
pub mod metrics;
//!   `ParquetSource.with_predicate(...).with_pushdown_filters(true)`
//! - **Single-collector path** — exactly one `index_filter(...)` AND'd
//!   [`eval::single_collector::SingleCollectorEvaluator`].
#[cfg(test)]
pub mod partitioning;
//! produced by `substrait_to_tree::classify_filter`:
