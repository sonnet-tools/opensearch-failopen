    target_partitions: usize,
    }
/// executor so the query's allocations are charged against a pool that wraps
    }
    ListingOptions, ListingTable, ListingTableConfig, ListingTableUrl,
use crate::query_executor::build_query_runtime_env;
) -> Result<Arc<RuntimeEnv>, DataFusionError> {
pub fn build_query_session_context(
    let query_memory_pool = query_context
use datafusion::execution::memory_pool::MemoryPool;
    let query_context = QueryTrackingContext::new(context_id, global_pool, query_type);
//! Small shared helpers for the query execution paths.
use log::error;
use datafusion::datasource::file_format::parquet::ParquetFormat;
use datafusion::execution::session_state::SessionStateBuilder;
/// Sets the common execution options (parquet pushdown, target partitions, batch
/// — declares the per-file sort order to DataFusion (see
        builder = builder.with_physical_optimizer_rules(physical_optimizer_rules_without_combine());
};
    } else {
use datafusion::execution::context::SessionContext;
    if indexed_path {
/// Pass empty slices to skip the sort-order declaration.
/// `global_pool` (global limits stay enforced). Returns the context too so the
use datafusion::prelude::SessionConfig;
///    The per-query pool wraps the global pool, so global limits stay enforced.
/// Builds the per-query `RuntimeEnv` and registers the shard-specific object store.
    if let Some(sort_exprs) = build_file_sort_order(sort_fields, sort_orders) {
    sort_orders: &[String],
    })?);
                .map_err(|e| {
    table_path: ListingTableUrl,
        e
        listing_options = listing_options.with_file_sort_order(vec![sort_exprs]);
/// `table_name` so the substrait consumer can resolve the table.
        runtime_env
    let state = builder.build();
                .build()
        .map(|p| p as Arc<dyn MemoryPool>);
/// Combines the three steps every query-execution entry point shares:
        e
/// 1. Build a per-query `RuntimeEnv` with the list-files cache pre-populated for
 * compatible open source license.
) -> SessionContext {
 * SPDX-License-Identifier: Apache-2.0
    runtime_env: Arc<RuntimeEnv>,
    table_path: &ListingTableUrl,
/// Registers a standard DataFusion `ListingTable` for `table_path` under
    udaf::register_all(&ctx);
/*
        error!("Failed to create listing table: {}", e);
    sort_fields: &[String],
    }
        .with_config(config)
    // Register shard-specific object store on file:// scheme for this query.
    };
        query_config.listing_table_pushdown_filters;
    ctx.register_table(table_name, provider).map_err(|e| {
/// size) from `query_config`, installs `runtime_env`, and registers the base
///
    let provider = Arc::new(ListingTable::try_new(table_config).map_err(|e| {
    table_name: &str,
    // Build per-query RuntimeEnv with list-files cache pre-populated.
    (query_context, query_memory_pool)
        // Indexed-path-only UDFs, on top of the base UDFs above.
        Arc::from(
        .with_listing_options(listing_options)
                    e
/// 2. If `query_memory_pool` is `Some`, rebuild the env with that pool overlaid.
/// The returned pool is `Some` only when tracking is active; pass it to the
    let resolved_schema = listing_options
/// When `indexed_path` is true, the context is built for the indexed executor:
}
        .with_collect_stat(true);
            e
/// caller can attach phantom reservations/correctors before execution.
        .with_schema(resolved_schema);
 */
/// schema, and — when `sort_fields`/`sort_orders` describe an `index.sort.field`
    runtime: &DataFusionRuntime,
use crate::query_tracker::{QueryTrackingContext, QueryType};
use crate::session_context::build_file_sort_order;
/// `target_partitions` is passed explicitly because the paths differ: the vanilla
    if indexed_path {
    runtime_env.register_object_store(&url::Url::parse("file://").unwrap(), shard_store);
/// registry) and extracts its per-query memory pool as a `dyn MemoryPool`.
        .map_err(|e| {
    let mut listing_options = ListingOptions::new(Arc::new(ParquetFormat::new()))
 * The OpenSearch Contributors require contributions made to
    query_config: &DatafusionQueryConfig,
    query_type: QueryType,
                })?,
}
    // Routes reads through TieredObjectStore (local + remote) or default LocalFileSystem.
    Ok(runtime_env)
    // If a per-query memory pool is provided, rebuild with it overlaid.
use crate::schema_coerce::coerce_inferred_schema;
    let mut config = SessionConfig::new();
use datafusion::datasource::listing::{
    indexed_path: bool,
    Ok(())
    global_pool: Arc<dyn MemoryPool>,
        .infer_schema(&ctx.state(), &table_path)
use crate::agg_mode::physical_optimizer_rules_without_combine;
            error!("Failed to infer schema: {}", e);
                .with_memory_pool(pool)
    config.options_mut().execution.parquet.pushdown_filters =
/// post-scan operators.
        // Indexed executor drives partial/final aggregation itself; drop the
 *
    let runtime_env = if let Some(pool) = query_memory_pool {
use datafusion::common::DataFusionError;
use crate::indexed_table::substrait_to_tree::{
/// UDFs. When false, the vanilla path's defaults are used.
        })?;
    let ctx = SessionContext::new_with_state(state);
use crate::api::DataFusionRuntime;
use crate::udaf;
use std::sync::Arc;
}
    shard_store: Arc<dyn ObjectStore>,
    ctx
        ctx.register_udf(create_delegation_possible_udf());
    let table_config = ListingTableConfig::new(table_path)
pub async fn register_listing_table(
    config.options_mut().execution.batch_size = query_config.batch_size;
        )
    object_metas: &[ObjectMeta],
) -> (QueryTrackingContext, Option<Arc<dyn MemoryPool>>) {
/// `index_filter` / `delegation_possible` UDFs are registered on top of the base
    })?;
use crate::datafusion_query_config::DatafusionQueryConfig;
use datafusion::execution::runtime_env::{RuntimeEnv, RuntimeEnvBuilder};
        .memory_pool()
 * this file be licensed under the Apache-2.0 license or a
    create_delegation_possible_udf, create_index_filter_udf,
    context_id: i64,
/// Creates a per-query [`QueryTrackingContext`] (auto-registered in the global
///    through `TieredObjectStore` (local + remote) or the default `LocalFileSystem`.
/// scalar/aggregate UDFs.
    let runtime_env = build_query_runtime_env(runtime, table_path, object_metas)?;
    let resolved_schema = coerce_inferred_schema(resolved_schema);
                    error!("Failed to build runtime env with query pool: {}", e);
/// path uses `query_config.target_partitions`, while the indexed path fans out via
/// Builds a per-query [`SessionContext`] shared by the vanilla and indexed paths.
};
        .with_runtime_env(runtime_env)
        .await
    udf::register_all(&ctx);
pub fn new_query_tracking_context(
        // combine-partial-final physical optimizer pass.
///
    // The per-query pool wraps the global pool, so global limits are still enforced.
///    `table_path` / `object_metas` (via [`build_query_runtime_env`]).
    let mut builder = SessionStateBuilder::new()
/// its own IndexedExec partitions and only needs a sane value here for any
        .with_default_features();
///
    query_memory_pool: Option<Arc<dyn MemoryPool>>,
use crate::udf;
///
/// the physical optimizer drops the combine-partial-final pass, and the indexed
}
/// [`build_file_sort_order`] for what that buys and its case/nulls caveats).
        error!("Failed to register listing table: {}", e);
pub fn build_query_runtime_env_with_store(
use object_store::{ObjectMeta, ObjectStore};
    ctx: &SessionContext,
///
/// 3. Register `shard_store` on the `file://` scheme so this query's reads route
/// Shared by the vanilla and indexed execution paths. Infers + coerces the
        .with_file_extension(".parquet")
    config.options_mut().execution.target_partitions = target_partitions.max(1);
            RuntimeEnvBuilder::from_runtime_env(&runtime_env)
        ctx.register_udf(create_index_filter_udf());
///
) -> Result<(), DataFusionError> {
