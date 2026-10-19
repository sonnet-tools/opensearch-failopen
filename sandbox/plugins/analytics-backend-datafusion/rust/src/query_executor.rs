/// into a logical plan and execute it.
    if internal_search.is_internal_search() {
    runtime: &DataFusionRuntime,
                (
    cpu_executor: DedicatedExecutor,
    );
///
    // Permit is held until the QueryStreamHandle is dropped (query complete).
use crate::api::{DataFusionRuntime, ShardFileInfo};
/// Each file gets a cumulative `row_base` and per-RG row counts.
                )
use substrait::proto::Plan;
                .map(|i| pq_meta.row_group(i).num_rows() as u64)
                    df_stream,
 */
        return internal_search_dataframe(ctx, table_name, internal_search).await;
        // semantics — only AggregateExec(Mode::Partial) executes, emitting state-suffixed
        //
// ── Shared helpers ──────────────────────────────────────────────────────────
    let target_schema = crate::schema_coerce::coerce_inferred_schema(physical_plan.schema());
        e
/// cache pre-populated for the given table path and object metas.
pub fn wrap_stream_as_handle(
            crate::api::QueryStreamHandle::new_with_plan(wrapped, query_context, None, plan)
/// An engine-internal point lookup (get-by-id / seq-no scan) returns early with a small native
        let (cross_rt_stream, abort_handle, _task_done) =
            use datafusion::physical_plan::ExecutionPlan;
            object_meta: meta.clone(),
        crate::query_tracker::set_cpu_runtime_handle(context_id, rt);
///   row-groups/pages via min/max stats.
/// - [`InternalSearch::ByRowId`]: `SELECT * WHERE __row_id__ = n LIMIT 1`. `__row_id__` is the
        Some(plan) => crate::api::QueryStreamHandle::with_physical_plan(
use datafusion::execution::cache::cache_manager::{CacheManagerConfig, CachedFileList};
}
        >((Box::into_raw(Box::new(wrapped)) as i64, Some(physical_plan)))
 * compatible open source license.
pub async fn execute_with_context(
    // (non-row-id) path — QTF row-id plans always route to the indexed executor.
        log_debug!(
    // Create the tracking context first so its cancellation token is registered before the task starts.
        ))
    let wrapped = datafusion::physical_plan::stream::RecordBatchStreamAdapter::new(
    // Engine-internal point lookup — build a native filter DataFrame and return early.
            num_rows: num_rows as u64,
    }
    // Attach phantom corrector for self-correcting budget (if provided)
    let dataframe = build_dataframe(&ctx, &table_name, &plan_bytes, internal_search).await?;
        .with_cache_manager(
        // return zero rows (regression caught by HashShuffleJoinIT after the #21754 empty-index merge).
            stream,
    }
                Arc::new(logical_plan.schema().as_arrow().clone());
            crate::relabel_exec::wrap_if_relabel_needed(physical_plan, target_schema)?;
            stream_ptr
}
/// Panics on [`InternalSearch::Off`] — callers gate on `is_internal_search()` first.
    let token = crate::query_tracker::get_cancellation_token(context_id);
///   (version-map restore on recovery; metadata columns only).
        }
/// registry plus the provided per-query `list_file_cache`. Callers overlay any
        ),
            .limit(0, Some(1)),
        if let Some(rt) = cpu_executor.handle() {
    internal_search: crate::datafusion_query_config::InternalSearch,
        let pq_meta = builder.metadata().clone();
) -> Result<datafusion::dataframe::DataFrame, DataFusionError> {
        .with_object_store_registry(Arc::new(
    ctx: &SessionContext,
            let wrapped = datafusion::physical_plan::stream::RecordBatchStreamAdapter::new(
        let physical_plan = dataframe.create_physical_plan().await?;
    runtime: &DataFusionRuntime,
            crate::substrait_consumer::from_substrait_plan(&handle.ctx.state(), &substrait_plan)
        )
        query_config,
    physical_plan: Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
) -> Result<i64, DataFusionError> {
                    error!(
            return Ok::<
    Box::into_raw(Box::new(handle)) as i64
            datafusion::execution::object_store::DefaultObjectStoreRegistry::new(),
            let plan_schema = crate::schema_coerce::coerce_inferred_schema(plan_schema);
    Ok(files)
        // this guard a worker's join/aggregate plan would short-circuit to EmptyExec and silently
/// Wires cancellation like the shard-query path so a `cancel_query` on the QTF fetch-by-rowid
                cross_rt_stream.schema(),
/// - [`InternalSearch::SeqNoAbove`]: `SELECT _id,_seq_no,_primary_term,_version WHERE _seq_no > f`
/*
        Ok::<
    let list_file_cache = Arc::new(DefaultListFilesCache::default());
/// can be extracted from the plan tree after the stream is exhausted.
    object_metas: Arc<Vec<ObjectMeta>>,
        // Union schema widening was applied at table registration (session_context::widen_to_union_schema).
        InternalSearch::Off => unreachable!("internal_search_dataframe called with Off"),
        crate::query_tracker::QueryType::Shard,
 *
            let df_stream = empty_exec.execute(0, handle.ctx.task_ctx()).map_err(|e| {
                CrossRtStream::new_with_df_error_stream_cancellable(
    }
}
/// Build the query DataFrame against the table already registered in `ctx`.
use crate::executor::DedicatedExecutor;
    table_path: &ListingTableUrl,
/// Build a per-query RuntimeEnv sharing global caches, with a fresh list-files
            .map_err(|e| DataFusionError::Execution(format!("parquet metadata: {}", e)))?;
            >((Box::into_raw(Box::new(wrapped)) as i64, Some(physical_plan)));
/// `execute_with_context` path (via `api::execute_query`).
        )
///
    context_id: i64,
            "DataFusion logical plan:\n{}",
        error!("Failed to create execution stream: {}", e);
    // Build a fresh session context per query (default optimizer rules on the
            use datafusion::physical_plan::empty::EmptyExec;
/// stream can break/abort the cross_rt task instead of stranding its pool reservation.
                    cpu_executor.clone(),
    shard_store: Arc<dyn ObjectStore>,
/// caches (file-metadata, file-statistics + limit) and uses a fresh object-store
async fn build_dataframe(
            execute_stream(physical_plan.clone(), handle.ctx.task_ctx()).map_err(|e| {
    let stream_handle = match physical_plan {
use datafusion::logical_expr::{col, lit};
    cpu_executor: DedicatedExecutor,
/// Java's perspective and cleanup is pure RAII.
            >((Box::into_raw(Box::new(wrapped)) as i64, None));
    let query_future = async {
                    None,
            .map(|i| pq_meta.row_group(i).num_rows())
        None => cross_rt_stream,
    let parsed = url::Url::parse(url_str)
            handle.ctx,
            Some(permit),
}
        &table_scoped_path,
            let (cross_rt_stream, abort_handle, _task_done) =
        cross_rt_stream,
        let dataframe = handle.ctx.execute_logical_plan(logical_plan).await?;
            let physical_plan = std::sync::Arc::clone(prepared);
                df_stream,
/// Build ShardFileInfo list from object metas by reading parquet footers.
    let (cross_rt_stream, abort_handle, _task_done) =
        cross_rt_stream,
                .with_file_statistics_cache(
        // and fall through to the standard decode + execute below.
        let wrapped = datafusion::physical_plan::stream::RecordBatchStreamAdapter::new(
        None => crate::api::QueryStreamHandle::with_session_context(
    internal_search: crate::datafusion_query_config::InternalSearch,
/// Retained only for benchmarks. TODO: migrate benchmarks and remove.
        // scan registered StreamingTables, not parquet files — but use an empty table_name. Without
            ),
    let cross_rt_stream = match phantom_corrector {
/// This is the fragment (non-row-id) execution path: row-id-requesting plans are
        let target_schema = crate::schema_coerce::coerce_inferred_schema(physical_plan.schema());
        // ProjectRowIdOptimizer (registered in session_context when strategy=ListingTable).
    let physical_plan = crate::relabel_exec::wrap_if_relabel_needed(physical_plan, target_schema)?;
use object_store::ObjectMeta;
    match internal_search {
            if let Some(h) = abort_handle {
    cpu_executor: DedicatedExecutor,
    sort_orders: &[String],
                cross_rt_stream.schema(),
        ),
    );
        Some(corrector) => cross_rt_stream.with_phantom_corrector(corrector),
    // Planning: build the query DataFrame (Substrait decode for normal search, native filter for an
        CrossRtStream::new_with_df_error_stream_cancellable(df_stream, cpu_executor.clone(), None);
        crate::substrait_consumer::from_substrait_plan(&ctx.state(), &substrait_plan).await?;
            .await
                    i64,
    };
                        "execute_with_context: failed to execute prepared plan: {}",
        let reader = datafusion::parquet::arrow::async_reader::ParquetObjectReader::new(
/// Wrap a DataFusion stream in CrossRtStream and package as a QueryStreamHandle pointer.
) -> i64 {
                    runtime.runtime_env.cache_manager.get_file_statistic_cache(),
    let df = ctx.table(table_name).await?;
        }
/// raw Java pointer) happens at the FFM entry in `df_execute_with_context`, so
    Ok(Box::into_raw(Box::new(stream_handle)) as i64)
                    Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
use crate::cross_rt_stream::CrossRtStream;
        runtime,
    let runtime_env = build_query_runtime_env_with_store(
    table_name: &str,
) -> Result<Vec<ShardFileInfo>, DataFusionError> {
use log::error;
    RuntimeEnvBuilder::from_runtime_env(&runtime.runtime_env)
            plan,
pub async fn build_shard_file_infos(
        cumulative_rows += num_rows;
                );
            let df_stream =
                    i64,
///
/// - [`InternalSearch::SeqNoAbove`]: `SELECT _id,_seq_no,_primary_term,_version WHERE _seq_no > f`
    })?;
pub fn store_url_from_table_path(
            .filter(col("_seq_no").gt(lit(seq_no_floor)))?
};
        // columns on the wire (e.g. `dc[hll_registers]: Binary` for HLL sketch state). The
                    runtime.runtime_env.cache_manager.get_file_metadata_cache(),
            logical_plan.display_indent()
                })?;
    plan_bytes: Vec<u8>,
            .sum();
pub fn query_runtime_env_builder(
            }
        files.push(ShardFileInfo {
        *Box::from_raw(
    runtime: &DataFusionRuntime,
        .map_err(|e| DataFusionError::Execution(format!("Failed to decode Substrait: {}", e)))?;
    let ctx = build_query_session_context(
                (
            let empty_exec = EmptyExec::new(Arc::clone(&plan_schema));
) -> Result<datafusion::dataframe::DataFrame, DataFusionError> {
            let plan_schema: arrow::datatypes::SchemaRef =
}
}
    );
                ),
            );
    let mut files: Vec<ShardFileInfo> = Vec::new();
        shard_store,
            "DataFusion physical plan:\n{}",
    execution::runtime_env::RuntimeEnvBuilder, physical_plan::displayable,
    phantom_corrector: Option<Arc<crate::phantom_corrector::PhantomCorrector>>,
        CrossRtStream::new_with_df_error_stream_cancellable(df_stream, cpu_executor.clone(), None);
/// Internal-search filters:
        if let Some(h) = abort_handle {
    // Permit was acquired by the caller (ffm.rs) on the IO runtime before
            (
    let (cross_rt_stream, abort_handle, _task_done) =
    };
    }
            .await
            }
                crate::query_tracker::set_abort_handle(context_id, h);
        false, // vanilla path
    internal_search: crate::datafusion_query_config::InternalSearch,
    let url_str = table_path.as_str();
        );
            crate::query_tracker::set_abort_handle(context_id, h);
    store: &Arc<dyn object_store::ObjectStore>,
///   row-groups/pages via min/max stats.
    };
            let wrapped = datafusion::physical_plan::stream::RecordBatchStreamAdapter::new(
            let (cross_rt_stream, abort_handle, _task_done) =
    let substrait_plan = Plan::decode(plan_bytes)
                DataFusionError,
    // Retag any physical-plan output columns whose type tags differ from what Substrait
/// filter DataFrame; otherwise this is the standard user-search flow: decode the Substrait plan
///
        crate::query_tracker::set_abort_handle(context_id, h);
    let query_context = crate::query_tracker::QueryTrackingContext::new(
        if let Some(prepared) = handle.prepared_plan.as_ref() {
                DataFusionError,
    if let Some(h) = abort_handle {
        .map_err(|e| DataFusionError::Execution(format!("parse URL: {}", e)))?;
/// The shared per-query `RuntimeEnv` builder chain: inherits the global runtime's
    }
use datafusion::execution::context::SessionContext;
            Arc::clone(store),
/// registered in `ctx`. Not user search — those go through the Substrait flow in [`build_dataframe`].
                    cpu_executor.clone(),
        "{}://{}",
    );
        let num_rows: i64 = (0..pq_meta.num_row_groups())
///
                .with_metadata_cache_limit(
    let handle = match physical_plan {
        context_id,
        query_memory_pool,
        cross_rt_stream.schema(),
) -> Result<Arc<datafusion::execution::runtime_env::RuntimeEnv>, DataFusionError> {
    // Standard user-search flow: Substrait → logical plan → DataFrame.
                Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
                i64,
        }
}
        // and run the prepared plan directly. This activates `force_aggregate_mode(Partial)`
        // create_physical_plan runs all registered physical optimizer rules including
    context_id: i64,
            })?;
        })?;
    )?;
        cross_rt_stream.schema(),
 * this file be licensed under the Apache-2.0 license or a
        // FINAL substrait declares VARBINARY (resolver's overrideExchangeType), so the wire
            .filter(col(crate::ROW_ID_COLUMN_NAME).eq(lit(row_id)))?
use crate::helper::{
    // Build per-query RuntimeEnv (optional pool overlay) + register the shard store.
        );
    // schema_coerce::coerce_inferred_schema(physical_schema) — the same narrowing the
    // Register the standard DataFusion ListingTable. This function only runs the vanilla
            stream,
                .await?;
            row_base: cumulative_rows,
use crate::session_context::SessionContextHandle;
    for meta in object_metas {
    common::DataFusionError, datasource::listing::ListingTableUrl,
    // Declares the per-file sort order when the index has `index.sort.field`.
    // gate when it is full — creating backpressure at the Java threadpool level.
                .collect(),
    register_listing_table(&ctx, &table_name, table_path, sort_fields, sort_orders).await?;
    };
        )
) -> Result<i64, DataFusionError> {
        );
use prost::Message;
    let df_stream = execute_stream(physical_plan, ctx.task_ctx()).map_err(|e| {
                    None,
pub async fn execute_query(
    };
            return Ok::<
    ctx: &SessionContext,
/// Build the native filter DataFrame for an engine-internal point lookup against the table already
    // partition-stream registration uses, so the consumer's StreamingTable and the
                error!("execute_with_context: failed to create stream: {}", e);
            CrossRtStream::new_with_df_error_stream_cancellable(
) -> RuntimeEnvBuilder {
        }
/// per-query memory pool, then `.build()`.
        let df_stream =
    };
pub fn build_query_runtime_env(
    list_file_cache: Arc<DefaultListFilesCache>,
    table_path: &ListingTableUrl,
    cpu_executor: DedicatedExecutor,
            row_group_row_counts: (0..pq_meta.num_row_groups())
    if let Some(rt) = cpu_executor.handle() {
        log_debug!(
        runtime_env,
use std::sync::Arc;
    let stream = unsafe {
        });
        let substrait_plan = Plan::decode(plan_bytes).map_err(|e| {
                    );
            DataFusionError,
 * The OpenSearch Contributors require contributions made to
    build_query_runtime_env_with_store, build_query_session_context, register_listing_table,
) -> i64 {
    }
        InternalSearch::ByRowId(row_id) => df
    table_name: &str,
                    Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
 * SPDX-License-Identifier: Apache-2.0
            Some(permit),
    wrap_stream_as_handle_with_plan(df_stream, cpu_executor, runtime, context_id, None)
                as *mut datafusion::physical_plan::stream::RecordBatchStreamAdapter<CrossRtStream>,
    // Reconstruct the stream from the raw pointer
/// by the time this function is reached the pointer is already invalidated from
    table_path: ListingTableUrl,
///   physical row position the writer stamps at flush, so equality is order-independent and prunes
    df_stream: datafusion::execution::SendableRecordBatchStream,
    if let Some(h) = abort_handle {
            if let Some(rt) = cpu_executor.handle() {
                crate::query_tracker::set_cpu_runtime_handle(context_id, rt);
    ctx.execute_logical_plan(logical_plan).await
    // Wrap in CrossRtStream — CPU work runs on DedicatedExecutor
use native_bridge_common::log_debug;
    plan_bytes: &[u8],
        object_metas.as_ref(),
        }
    physical_plan::execute_stream,
            displayable(physical_plan.as_ref()).indent(true)
        // matches the exchange contract. Non-engine-native paths leave `prepared_plan` as None
                CrossRtStream::new_with_df_error_stream_cancellable(
    plan_bytes: &[u8],
pub fn wrap_stream_as_handle_with_plan(
            handle.ctx,
    // engine-internal point lookup). Physical planning + execution below is shared by both.
    ))
        // PARTIAL stage triggered by SETUP_PARTIAL_AGGREGATE), skip the substrait re-decode
    // If cancellation fires → stream drops → handle drops → permit drops → gate releases.
    runtime: &DataFusionRuntime,
    query_memory_pool: Option<Arc<dyn datafusion::execution::memory_pool::MemoryPool>>,
/// Execute a vanilla parquet query: substrait plan → DataFusion → CrossRtStream.
                execute_stream(physical_plan.clone(), handle.ctx.task_ctx()).map_err(|e| {
    datafusion::execution::object_store::ObjectStoreUrl::parse(format!(
    let (stream_ptr, physical_plan) =
    let physical_plan = dataframe.create_physical_plan().await?;
        InternalSearch::SeqNoAbove(seq_no_floor) => df
    object_metas: &[ObjectMeta],
/// Takes ownership of the handle by value. The ownership transfer (consuming the
        path: table_path.prefix().clone(),
    // declared on bit-compatible Int↔UInt pairs (see crate::relabel_exec). The target is
///   physical row position the writer stamps at flush, so equality is order-independent and prunes
                    df_stream,
        Some(plan) => {
    runtime: &DataFusionRuntime,
            handle.query_context,
                .with_list_files_cache(Some(list_file_cache))
            .select_columns(&["_id", "_seq_no", "_primary_term", "_version"]),
            cross_rt_stream,
            cross_rt_stream.schema(),
        // If prepare_partial_plan stored a stripped plan on this handle (engine-native-merge
use datafusion::{
    // spawning on the CPU runtime, so the Java search thread blocks at the
                ),
                    runtime.runtime_env.cache_manager.get_metadata_cache_limit(),
/// TODO: Remove this function and migrate benchmarks to the decomposed path.
                ))
    let wrapped = datafusion::physical_plan::stream::RecordBatchStreamAdapter::new(
        if handle.object_metas.is_empty() && !handle.table_name.is_empty() {
///
    let table_scoped_path = datafusion::execution::cache::TableScopedPath {
        None => crate::api::QueryStreamHandle::new(wrapped, query_context, None),
        let physical_plan =
            CacheManagerConfig::default()
/// Like [`wrap_stream_as_handle`] but attaches a physical plan so that execution metrics
            );
                e
                cross_rt_stream,
                        e
            DataFusionError::Execution(format!("Failed to decode Substrait: {}", e))
/// routed to the indexed executor by `df_execute_with_context` before reaching here.
    query_config: &crate::datafusion_query_config::DatafusionQueryConfig,
    context_id: i64,
    );
}
    table_name: String,
        // and emit an EmptyExec stream with the logical plan's output schema.
        crate::query_tracker::set_abort_handle(context_id, h);
        .with_file_size(meta.size);
                .with_file_metadata_cache(Some(
                );
    sort_fields: &[String],
        // WORKER sessions (create_worker_session_context) also carry empty object_metas — they
    let context_id = handle.query_context.context_id();
        parsed.authority()
                ),
                    e
use object_store::ObjectStore;
///
            .map_err(|e| DataFusionError::Execution(e))?;
        let builder = datafusion::parquet::arrow::ParquetRecordBatchStreamBuilder::new(reader)
                e
            }
        // Empty shard: skip physical planning (ParquetExec errors on zero files)
    }
    let runtime_env = query_runtime_env_builder(runtime, list_file_cache).build()?;
            meta.location.clone(),
}
        runtime.runtime_env.memory_pool.clone(),
            })?;
            }
        crate::query_tracker::set_cpu_runtime_handle(context_id, rt);
    df_stream: datafusion::execution::SendableRecordBatchStream,
        // Gate on a non-empty table_name so this fires ONLY for real shard scans. Hash-shuffle
        parsed.scheme(),
            handle.query_context,
            access_plan: None,
    let mut cumulative_rows: i64 = 0;
                cross_rt_stream,
}
                crate::query_tracker::set_abort_handle(context_id, h);
/// Deprecated: Production now uses the decomposed `create_session_context` +
    let logical_plan =
    permit: tokio::sync::OwnedSemaphorePermit,
        query_config.target_partitions,
    use crate::datafusion_query_config::InternalSearch;
/// - [`InternalSearch::ByRowId`]: `SELECT * WHERE __row_id__ = n LIMIT 1`. `__row_id__` is the
        crate::cancellation::cancellable(token.as_ref(), context_id, query_future)
            if let Some(h) = abort_handle {
        table: None,
async fn internal_search_dataframe(
    if let Some(rt) = cpu_executor.handle() {
                crate::query_tracker::set_cpu_runtime_handle(context_id, rt);
    // batches arriving from this producer agree by construction.
    list_file_cache.put(
/// Executes a Substrait plan against a pre-configured SessionContext.
/// File access goes through DataFusion's registered object store.
            crate::query_tracker::set_cpu_runtime_handle(context_id, rt);
        let logical_plan =
};
                None,
use datafusion::execution::cache::{CacheAccessor, DefaultListFilesCache};
            );
///
        CachedFileList::new(object_metas.to_vec()),
            if let Some(rt) = cpu_executor.handle() {
///   (version-map restore on recovery; metadata columns only).
    handle: SessionContextHandle,
    object_metas: &[ObjectMeta],
    // vanilla path). TODO : Tune this during planning per query.
                cpu_executor.clone(),
    Ok(Arc::from(runtime_env))
    Ok(Box::into_raw(Box::new(wrapped)) as i64)
/// Parse a ListingTableUrl into an ObjectStoreUrl (scheme + authority).
        &table_path,
) -> Result<datafusion::execution::object_store::ObjectStoreUrl, DataFusionError> {
                error!("execute_with_context: failed to create empty stream: {}", e);
