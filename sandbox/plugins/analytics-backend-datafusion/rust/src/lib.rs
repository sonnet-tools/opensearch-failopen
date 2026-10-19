pub mod udaf;
pub mod indexed_executor;
/// Stored as Int64 in parquet, computed from position in the indexed path.
pub mod ffm;
 * compatible open source license.
pub mod executor;
/// Column name for the shard-global row identifier used by Query-Then-Fetch.
pub mod datafusion_query_config;
pub mod search_stats;
//!
pub mod runtime_manager;
 *
#[cfg(test)]
pub mod memory_guard;
pub mod shard_table_provider;
// normal dependencies of this crate — keeping the storage-primitive crate's test
pub mod cancellation;
//! DataFusion native execution engine for OpenSearch.
/// matching by convention.
pub mod query_tracker;
/// here. Today both sides hardcode "__row_id__" and rely on the strings
// One lock, and the one-time runtime-manager install, shared by every test that touches the
pub mod api;
/*
pub mod helper;
#[cfg(test)]
pub mod native_error;
 * this file be licensed under the Apache-2.0 license or a
mod tiered_storage_integration_tests;
pub mod schema_coerce;
pub mod project_row_id_analyzer;
pub mod query_executor;
pub mod substrait_consumer;
pub mod cross_rt_stream;
pub const ROW_ID_COLUMN_NAME: &str = "__row_id__";
// End-to-end TieredObjectStore + TieredBlockCache integration tests. Located here
pub mod scoped_page_index_reader;
pub mod native_node_stats;
 * The OpenSearch Contributors require contributions made to
//! `extern "C"` functions for JDK FFM.
 */
// (not in the lower-level `opensearch-tiered-storage` crate) because they drive a
pub mod task_monitors;
mod spill_e2e_test;
pub mod udf;
 * SPDX-License-Identifier: Apache-2.0
// engine's process-global state. See the module docs for why they are not one lock each.
/// TODO: source this from Java — the canonical column name should be defined
pub mod scoped_index_optimizer;
// Path aliases — old module names still resolve unchanged.
mod test_process_globals;
pub use cache::statistics_cache;
#[cfg(test)]
//! The bridge-agnostic API lives in [`api`]. The FFM bridge (`ffm.rs`) exports
pub mod udwf;
pub mod query_budget;
pub(crate) mod agg_mode;
pub mod memory;
pub mod forward_reader;
pub use cache::eviction_policy;
pub use cache::page_index as parquet_page_cache;
pub mod project_row_id_optimizer;
pub mod doc_values_cursor;
pub mod cache;
pub mod indexed_table;
pub mod partition_stream;
pub mod relabel_exec;
pub mod patterns;
/// once on the coordinator side and passed across FFM rather than hardcoded
pub mod local_executor;
///
pub mod session_context;
pub mod phantom_corrector;
pub mod can_match;
pub use cache::custom_cache_manager;
// build free of the DataFusion stack.
// real DataFusion session + Parquet I/O, and DataFusion/Parquet/Arrow are already
pub mod stats;
