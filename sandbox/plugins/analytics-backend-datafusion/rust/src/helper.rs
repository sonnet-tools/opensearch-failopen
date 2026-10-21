    target_partitions: usize,
) -> Result<(), DataFusionError> {
/// `target_partitions` is passed explicitly because the paths differ: the vanilla
    ctx
/// 1. Build a per-query `RuntimeEnv` with the list-files cache pre-populated for
        query_config.listing_table_pushdown_filters;
    config.options_mut().execution.parquet.pushdown_filters =
///    `table_path` / `object_metas` (via [`build_query_runtime_env`]).
/// The returned pool is `Some` only when tracking is active; pass it to the
/// [`build_file_sort_order`] for what that buys and its case/nulls caveats).
        // combine-partial-final physical optimizer pass.
/// UDFs. When false, the vanilla path's defaults are used.
    if indexed_path {
/// Sets the common execution options (parquet pushdown, target partitions, batch
use std::sync::Arc;
        .with_schema(resolved_schema);
/// the physical optimizer drops the combine-partial-final pass, and the indexed
) -> Result<Arc<RuntimeEnv>, DataFusionError> {
        e
    udf::register_all(&ctx);
    object_metas: &[ObjectMeta],
        ctx.register_udf(create_index_filter_udf());
    runtime: &DataFusionRuntime,
                    error!("Failed to build runtime env with query pool: {}", e);
/// schema, and — when `sort_fields`/`sort_orders` describe an `index.sort.field`
        // Indexed executor drives partial/final aggregation itself; drop the
        .memory_pool()
    };
    udaf::register_all(&ctx);
    table_path: &ListingTableUrl,
/// Pass empty slices to skip the sort-order declaration.
            e
        .map(|p| p as Arc<dyn MemoryPool>);
    runtime_env: Arc<RuntimeEnv>,
    (query_context, query_memory_pool)
};
    let ctx = SessionContext::new_with_state(state);
    Ok(())
    runtime_env.register_object_store(&url::Url::parse("file://").unwrap(), shard_store);
use datafusion::datasource::listing::{
    let table_config = ListingTableConfig::new(table_path)
 *
    table_name: &str,
pub fn new_query_tracking_context(
/// When `indexed_path` is true, the context is built for the indexed executor:
/// its own IndexedExec partitions and only needs a sane value here for any
    config.options_mut().execution.batch_size = query_config.batch_size;
        .with_collect_stat(true);
/// Shared by the vanilla and indexed execution paths. Infers + coerces the
/// Combines the three steps every query-execution entry point shares:
/// post-scan operators.
/// `index_filter` / `delegation_possible` UDFs are registered on top of the base
        })?;
use datafusion::common::DataFusionError;
        error!("Failed to register listing table: {}", e);
use datafusion::execution::runtime_env::{RuntimeEnv, RuntimeEnvBuilder};
/// — declares the per-file sort order to DataFusion (see
    // Routes reads through TieredObjectStore (local + remote) or default LocalFileSystem.
use datafusion::execution::session_state::SessionStateBuilder;
        runtime_env
///
                .map_err(|e| {
/// Builds the per-query `RuntimeEnv` and registers the shard-specific object store.
    // The per-query pool wraps the global pool, so global limits are still enforced.
 * this file be licensed under the Apache-2.0 license or a
        .with_default_features();
    shard_store: Arc<dyn ObjectStore>,
pub fn build_query_runtime_env_with_store(
    let mut listing_options = ListingOptions::new(Arc::new(ParquetFormat::new()))
    let resolved_schema = coerce_inferred_schema(resolved_schema);
            error!("Failed to infer schema: {}", e);
    if let Some(sort_exprs) = build_file_sort_order(sort_fields, sort_orders) {
use crate::session_context::build_file_sort_order;
/// registry) and extracts its per-query memory pool as a `dyn MemoryPool`.
pub fn build_query_session_context(
use datafusion::execution::memory_pool::MemoryPool;
/// 2. If `query_memory_pool` is `Some`, rebuild the env with that pool overlaid.
use datafusion::execution::context::SessionContext;
    let provider = Arc::new(ListingTable::try_new(table_config).map_err(|e| {
    context_id: i64,
/// size) from `query_config`, installs `runtime_env`, and registers the base
    ctx.register_table(table_name, provider).map_err(|e| {
use crate::query_executor::build_query_runtime_env;
use datafusion::datasource::file_format::parquet::ParquetFormat;
use log::error;
    let resolved_schema = listing_options
    let query_memory_pool = query_context
    }
    indexed_path: bool,
}
) -> (QueryTrackingContext, Option<Arc<dyn MemoryPool>>) {
    } else {
        listing_options = listing_options.with_file_sort_order(vec![sort_exprs]);
    create_delegation_possible_udf, create_index_filter_udf,
    })?);
}
    query_config: &DatafusionQueryConfig,
            RuntimeEnvBuilder::from_runtime_env(&runtime_env)
                .build()
    table_path: ListingTableUrl,
use crate::indexed_table::substrait_to_tree::{
///
use crate::udf;
        .with_config(config)
    let mut builder = SessionStateBuilder::new()
    // If a per-query memory pool is provided, rebuild with it overlaid.
    query_type: QueryType,
    Ok(runtime_env)
        .infer_schema(&ctx.state(), &table_path)
pub async fn register_listing_table(
        // Indexed-path-only UDFs, on top of the base UDFs above.
///
    }
}
/*
/// Registers a standard DataFusion `ListingTable` for `table_path` under
 */
        .with_listing_options(listing_options)
}
        .map_err(|e| {
    global_pool: Arc<dyn MemoryPool>,
    config.options_mut().execution.target_partitions = target_partitions.max(1);
 * The OpenSearch Contributors require contributions made to
/// 3. Register `shard_store` on the `file://` scheme so this query's reads route
                    e
};
        .with_file_extension(".parquet")
///
    sort_orders: &[String],
    let runtime_env = if let Some(pool) = query_memory_pool {
use crate::udaf;
    // Build per-query RuntimeEnv with list-files cache pre-populated.
    ListingOptions, ListingTable, ListingTableConfig, ListingTableUrl,
    sort_fields: &[String],
    let runtime_env = build_query_runtime_env(runtime, table_path, object_metas)?;
///    through `TieredObjectStore` (local + remote) or the default `LocalFileSystem`.
use datafusion::prelude::SessionConfig;
        builder = builder.with_physical_optimizer_rules(physical_optimizer_rules_without_combine());
use crate::schema_coerce::coerce_inferred_schema;
    if indexed_path {
/// path uses `query_config.target_partitions`, while the indexed path fans out via
/// `global_pool` (global limits stay enforced). Returns the context too so the
    }
/// Builds a per-query [`SessionContext`] shared by the vanilla and indexed paths.
///
/// Creates a per-query [`QueryTrackingContext`] (auto-registered in the global
                })?,
        error!("Failed to create listing table: {}", e);
        ctx.register_udf(create_delegation_possible_udf());
use crate::query_tracker::{QueryTrackingContext, QueryType};
    let mut config = SessionConfig::new();
/// scalar/aggregate UDFs.
/// `table_name` so the substrait consumer can resolve the table.
 * compatible open source license.
    ctx: &SessionContext,
    // Register shard-specific object store on file:// scheme for this query.
        .await
use crate::api::DataFusionRuntime;
        Arc::from(
/// caller can attach phantom reservations/correctors before execution.
) -> SessionContext {
//! Small shared helpers for the query execution paths.
        e
        )
///    The per-query pool wraps the global pool, so global limits stay enforced.
use object_store::{ObjectMeta, ObjectStore};
    })?;
use crate::datafusion_query_config::DatafusionQueryConfig;
    query_memory_pool: Option<Arc<dyn MemoryPool>>,
                .with_memory_pool(pool)
///
    let state = builder.build();
    let query_context = QueryTrackingContext::new(context_id, global_pool, query_type);
/// executor so the query's allocations are charged against a pool that wraps
 * SPDX-License-Identifier: Apache-2.0
        .with_runtime_env(runtime_env)
use crate::agg_mode::physical_optimizer_rules_without_combine;
