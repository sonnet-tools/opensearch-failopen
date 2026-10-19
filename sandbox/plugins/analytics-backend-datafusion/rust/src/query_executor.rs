    internal_search: crate::datafusion_query_config::InternalSearch,
}
) -> RuntimeEnvBuilder {
        // matches the exchange contract. Non-engine-native paths leave `prepared_plan` as None
/// Executes a Substrait plan against a pre-configured SessionContext.
/// Wrap a DataFusion stream in CrossRtStream and package as a QueryStreamHandle pointer.
        CrossRtStream::new_with_df_error_stream_cancellable(df_stream, cpu_executor.clone(), None);
    use crate::datafusion_query_config::InternalSearch;
    runtime: &DataFusionRuntime,
            DataFusionError::Execution(format!("Failed to decode Substrait: {}", e))
use crate::api::{DataFusionRuntime, ShardFileInfo};
 * this file be licensed under the Apache-2.0 license or a
/// Build a per-query RuntimeEnv sharing global caches, with a fresh list-files
/*
        // WORKER sessions (create_worker_session_context) also carry empty object_metas — they
    let df_stream = execute_stream(physical_plan, ctx.task_ctx()).map_err(|e| {
            let (cross_rt_stream, abort_handle, _task_done) =
    register_listing_table(&ctx, &table_name, table_path, sort_fields, sort_orders).await?;
            cross_rt_stream.schema(),
    );
    ctx: &SessionContext,
    handle: SessionContextHandle,
use std::sync::Arc;
/// registered in `ctx`. Not user search — those go through the Substrait flow in [`build_dataframe`].
            plan,
                crate::query_tracker::set_abort_handle(context_id, h);
}
    permit: tokio::sync::OwnedSemaphorePermit,
use crate::cross_rt_stream::CrossRtStream;
    let runtime_env = build_query_runtime_env_with_store(
    cpu_executor: DedicatedExecutor,
        InternalSearch::ByRowId(row_id) => df
            );
) -> Result<datafusion::execution::object_store::ObjectStoreUrl, DataFusionError> {
    // Attach phantom corrector for self-correcting budget (if provided)
    // declared on bit-compatible Int↔UInt pairs (see crate::relabel_exec). The target is
        runtime_env,
/// Build ShardFileInfo list from object metas by reading parquet footers.
/// per-query memory pool, then `.build()`.
    let table_scoped_path = datafusion::execution::cache::TableScopedPath {
    let query_context = crate::query_tracker::QueryTrackingContext::new(
    // spawning on the CPU runtime, so the Java search thread blocks at the
///   physical row position the writer stamps at flush, so equality is order-independent and prunes
/// Retained only for benchmarks. TODO: migrate benchmarks and remove.
    ctx: &SessionContext,
        parsed.scheme(),
        // columns on the wire (e.g. `dc[hll_registers]: Binary` for HLL sketch state). The
        .map_err(|e| DataFusionError::Execution(format!("Failed to decode Substrait: {}", e)))?;
    physical_plan::execute_stream,
        CrossRtStream::new_with_df_error_stream_cancellable(df_stream, cpu_executor.clone(), None);
        cross_rt_stream,
/// The shared per-query `RuntimeEnv` builder chain: inherits the global runtime's
    plan_bytes: &[u8],
            object_meta: meta.clone(),
/// This is the fragment (non-row-id) execution path: row-id-requesting plans are
            }
use crate::executor::DedicatedExecutor;
    plan_bytes: &[u8],
    }
        files.push(ShardFileInfo {
        crate::cancellation::cancellable(token.as_ref(), context_id, query_future)
                    runtime.runtime_env.cache_manager.get_file_metadata_cache(),
        )
}
    let stream = unsafe {
            let wrapped = datafusion::physical_plan::stream::RecordBatchStreamAdapter::new(
        &table_path,
    let mut cumulative_rows: i64 = 0;
        runtime.runtime_env.memory_pool.clone(),
            (
                e
            DataFusionError,
    // engine-internal point lookup). Physical planning + execution below is shared by both.
    let target_schema = crate::schema_coerce::coerce_inferred_schema(physical_plan.schema());
        let df_stream =
/// - [`InternalSearch::ByRowId`]: `SELECT * WHERE __row_id__ = n LIMIT 1`. `__row_id__` is the
    }
                as *mut datafusion::physical_plan::stream::RecordBatchStreamAdapter<CrossRtStream>,
                    error!(
    ctx.execute_logical_plan(logical_plan).await
        cross_rt_stream,
        InternalSearch::Off => unreachable!("internal_search_dataframe called with Off"),
        CachedFileList::new(object_metas.to_vec()),
        if let Some(prepared) = handle.prepared_plan.as_ref() {
use native_bridge_common::log_debug;
            access_plan: None,
    Box::into_raw(Box::new(handle)) as i64
        None => crate::api::QueryStreamHandle::with_session_context(
    if internal_search.is_internal_search() {
                );
        // Empty shard: skip physical planning (ParquetExec errors on zero files)
) -> i64 {
        // return zero rows (regression caught by HashShuffleJoinIT after the #21754 empty-index merge).
    cpu_executor: DedicatedExecutor,
                crate::query_tracker::set_cpu_runtime_handle(context_id, rt);
 *
    let cross_rt_stream = match phantom_corrector {
            .sum();
};
            >((Box::into_raw(Box::new(wrapped)) as i64, None));
use crate::session_context::SessionContextHandle;
        None => cross_rt_stream,
};
        // create_physical_plan runs all registered physical optimizer rules including
    // If cancellation fires → stream drops → handle drops → permit drops → gate releases.
    // Register the standard DataFusion ListingTable. This function only runs the vanilla
            })?;
                )
            .map_err(|e| DataFusionError::Execution(e))?;
        table: None,
    store: &Arc<dyn object_store::ObjectStore>,
        }
        false, // vanilla path
        None => crate::api::QueryStreamHandle::new(wrapped, query_context, None),
            let df_stream = empty_exec.execute(0, handle.ctx.task_ctx()).map_err(|e| {
    // gate when it is full — creating backpressure at the Java threadpool level.
            displayable(physical_plan.as_ref()).indent(true)
    // Engine-internal point lookup — build a native filter DataFrame and return early.
                CrossRtStream::new_with_df_error_stream_cancellable(
use datafusion::execution::cache::{CacheAccessor, DefaultListFilesCache};
    table_path: ListingTableUrl,
    list_file_cache.put(
            .map_err(|e| DataFusionError::Execution(format!("parquet metadata: {}", e)))?;
        query_memory_pool,
        if let Some(h) = abort_handle {
            );
    // vanilla path). TODO : Tune this during planning per query.
                        e
/// Build the native filter DataFrame for an engine-internal point lookup against the table already
    build_query_runtime_env_with_store, build_query_session_context, register_listing_table,
                .with_file_statistics_cache(
///
        //
        );
    };
                ),
/// Deprecated: Production now uses the decomposed `create_session_context` +
    table_name: &str,
        if let Some(rt) = cpu_executor.handle() {
    }
        let (cross_rt_stream, abort_handle, _task_done) =
        &table_scoped_path,
    table_name: String,
    execution::runtime_env::RuntimeEnvBuilder, physical_plan::displayable,
pub fn wrap_stream_as_handle_with_plan(
        log_debug!(
        }
                DataFusionError,
    sort_orders: &[String],
    // batches arriving from this producer agree by construction.
                .with_list_files_cache(Some(list_file_cache))
use log::error;
    // partition-stream registration uses, so the consumer's StreamingTable and the
            crate::query_tracker::set_abort_handle(context_id, h);
    let wrapped = datafusion::physical_plan::stream::RecordBatchStreamAdapter::new(
///   physical row position the writer stamps at flush, so equality is order-independent and prunes
    ))
                Arc::new(logical_plan.schema().as_arrow().clone());
            logical_plan.display_indent()
///   (version-map restore on recovery; metadata columns only).
/// Each file gets a cumulative `row_base` and per-RG row counts.
            Arc::clone(store),
        // scan registered StreamingTables, not parquet files — but use an empty table_name. Without
    query_memory_pool: Option<Arc<dyn datafusion::execution::memory_pool::MemoryPool>>,
use crate::helper::{
///   (version-map restore on recovery; metadata columns only).
        context_id,
                cross_rt_stream,
    for meta in object_metas {
/// An engine-internal point lookup (get-by-id / seq-no scan) returns early with a small native
    let (cross_rt_stream, abort_handle, _task_done) =
                    None,
    object_metas: &[ObjectMeta],
                .map(|i| pq_meta.row_group(i).num_rows() as u64)
        // ProjectRowIdOptimizer (registered in session_context when strategy=ListingTable).
    df_stream: datafusion::execution::SendableRecordBatchStream,
        crate::query_tracker::set_cpu_runtime_handle(context_id, rt);
        if handle.object_metas.is_empty() && !handle.table_name.is_empty() {
        // Union schema widening was applied at table registration (session_context::widen_to_union_schema).
}
        .with_cache_manager(
    // Reconstruct the stream from the raw pointer
pub fn wrap_stream_as_handle(
    cpu_executor: DedicatedExecutor,
    table_path: &ListingTableUrl,
                cpu_executor.clone(),
///   row-groups/pages via min/max stats.
                ),
pub async fn build_shard_file_infos(
            CacheManagerConfig::default()
use substrait::proto::Plan;
    };
use prost::Message;
/// File access goes through DataFusion's registered object store.
use datafusion::logical_expr::{col, lit};
use object_store::ObjectStore;
/// cache pre-populated for the given table path and object metas.
            .select_columns(&["_id", "_seq_no", "_primary_term", "_version"]),
            return Ok::<
    }
    let handle = match physical_plan {
}
        object_metas.as_ref(),
                error!("execute_with_context: failed to create empty stream: {}", e);
    let parsed = url::Url::parse(url_str)
) -> Result<i64, DataFusionError> {
        Some(plan) => {
                .await?;
}
            return Ok::<
pub fn store_url_from_table_path(
async fn build_dataframe(
///
                ),
    shard_store: Arc<dyn ObjectStore>,
    let ctx = build_query_session_context(
            if let Some(h) = abort_handle {
        query_config,
            meta.location.clone(),
        let physical_plan = dataframe.create_physical_plan().await?;
    // Build per-query RuntimeEnv (optional pool overlay) + register the shard store.
            let wrapped = datafusion::physical_plan::stream::RecordBatchStreamAdapter::new(
    if let Some(h) = abort_handle {
        let reader = datafusion::parquet::arrow::async_reader::ParquetObjectReader::new(
        query_config.target_partitions,
    if let Some(rt) = cpu_executor.handle() {
    let runtime_env = query_runtime_env_builder(runtime, list_file_cache).build()?;
            use datafusion::physical_plan::empty::EmptyExec;
    Ok(Box::into_raw(Box::new(stream_handle)) as i64)
                    df_stream,
                execute_stream(physical_plan.clone(), handle.ctx.task_ctx()).map_err(|e| {
            handle.query_context,
        let physical_plan =
        ))
/// `execute_with_context` path (via `api::execute_query`).
/// routed to the indexed executor by `df_execute_with_context` before reaching here.
        );
    )?;
    let dataframe = build_dataframe(&ctx, &table_name, &plan_bytes, internal_search).await?;
            if let Some(rt) = cpu_executor.handle() {
    df_stream: datafusion::execution::SendableRecordBatchStream,
            }
            let plan_schema: arrow::datatypes::SchemaRef =
        crate::query_tracker::set_abort_handle(context_id, h);
/// caches (file-metadata, file-statistics + limit) and uses a fresh object-store
    if let Some(h) = abort_handle {
        let builder = datafusion::parquet::arrow::ParquetRecordBatchStreamBuilder::new(reader)
/// into a logical plan and execute it.
    );
        shard_store,
            handle.query_context,
    RuntimeEnvBuilder::from_runtime_env(&runtime.runtime_env)
        // and fall through to the standard decode + execute below.
                    e
        crate::query_tracker::set_cpu_runtime_handle(context_id, rt);
use datafusion::execution::cache::cache_manager::{CacheManagerConfig, CachedFileList};
 */
}
            num_rows: num_rows as u64,
    internal_search: crate::datafusion_query_config::InternalSearch,
///   row-groups/pages via min/max stats.
pub async fn execute_query(
/// Panics on [`InternalSearch::Off`] — callers gate on `is_internal_search()` first.
            Some(permit),
            handle.ctx,
 * SPDX-License-Identifier: Apache-2.0
use object_store::ObjectMeta;
        }
        parsed.authority()
            use datafusion::physical_plan::ExecutionPlan;
use datafusion::execution::context::SessionContext;
        ),
    // Planning: build the query DataFrame (Substrait decode for normal search, native filter for an
    wrap_stream_as_handle_with_plan(df_stream, cpu_executor, runtime, context_id, None)
                CrossRtStream::new_with_df_error_stream_cancellable(
///
/// can be extracted from the plan tree after the stream is exhausted.
    let (cross_rt_stream, abort_handle, _task_done) =
        // PARTIAL stage triggered by SETUP_PARTIAL_AGGREGATE), skip the substrait re-decode
            if let Some(h) = abort_handle {
    match internal_search {
        });
        >((Box::into_raw(Box::new(wrapped)) as i64, Some(physical_plan)))
    context_id: i64,
    // Wrap in CrossRtStream — CPU work runs on DedicatedExecutor
            let physical_plan = std::sync::Arc::clone(prepared);
/// Execute a vanilla parquet query: substrait plan → DataFusion → CrossRtStream.
                DataFusionError,
        "{}://{}",
        // If prepare_partial_plan stored a stripped plan on this handle (engine-native-merge
        let substrait_plan = Plan::decode(plan_bytes).map_err(|e| {
    cpu_executor: DedicatedExecutor,
/// stream can break/abort the cross_rt task instead of stranding its pool reservation.
                    df_stream,
        .with_object_store_registry(Arc::new(
            .filter(col(crate::ROW_ID_COLUMN_NAME).eq(lit(row_id)))?
                Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
        crate::query_tracker::QueryType::Shard,
            row_group_row_counts: (0..pq_meta.num_row_groups())
        log_debug!(
    let url_str = table_path.as_str();
        );
    let list_file_cache = Arc::new(DefaultListFilesCache::default());
                .with_file_metadata_cache(Some(
    };
    let df = ctx.table(table_name).await?;
        cross_rt_stream.schema(),
}
            crate::relabel_exec::wrap_if_relabel_needed(physical_plan, target_schema)?;
/// TODO: Remove this function and migrate benchmarks to the decomposed path.
        // Gate on a non-empty table_name so this fires ONLY for real shard scans. Hash-shuffle
                cross_rt_stream.schema(),
        // and emit an EmptyExec stream with the logical plan's output schema.
) -> Result<i64, DataFusionError> {
///
    // Create the tracking context first so its cancellation token is registered before the task starts.
///
                    Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
 * compatible open source license.
    // Permit is held until the QueryStreamHandle is dropped (query complete).
    internal_search: crate::datafusion_query_config::InternalSearch,
    runtime: &DataFusionRuntime,
    // Build a fresh session context per query (default optimizer rules on the
        crate::query_tracker::set_abort_handle(context_id, h);
/// Wires cancellation like the shard-query path so a `cancel_query` on the QTF fetch-by-rowid
                    );
) -> Result<datafusion::dataframe::DataFrame, DataFusionError> {
///
    context_id: i64,
/// Internal-search filters:
            .await
    list_file_cache: Arc<DefaultListFilesCache>,
        // and run the prepared plan directly. This activates `force_aggregate_mode(Partial)`
                crate::query_tracker::set_abort_handle(context_id, h);
    sort_fields: &[String],
    datafusion::execution::object_store::ObjectStoreUrl::parse(format!(
    let mut files: Vec<ShardFileInfo> = Vec::new();
) -> Result<datafusion::dataframe::DataFrame, DataFusionError> {
/// - [`InternalSearch::ByRowId`]: `SELECT * WHERE __row_id__ = n LIMIT 1`. `__row_id__` is the
        let target_schema = crate::schema_coerce::coerce_inferred_schema(physical_plan.schema());
        let num_rows: i64 = (0..pq_meta.num_row_groups())
 * The OpenSearch Contributors require contributions made to
            "DataFusion logical plan:\n{}",
    // schema_coerce::coerce_inferred_schema(physical_schema) — the same narrowing the
) -> Result<Vec<ShardFileInfo>, DataFusionError> {
            }
    );
            stream,
/// raw Java pointer) happens at the FFM entry in `df_execute_with_context`, so
    query_config: &crate::datafusion_query_config::DatafusionQueryConfig,
        let wrapped = datafusion::physical_plan::stream::RecordBatchStreamAdapter::new(
                    runtime.runtime_env.cache_manager.get_metadata_cache_limit(),
            .map(|i| pq_meta.row_group(i).num_rows())
    plan_bytes: Vec<u8>,
                .collect(),
    // Declares the per-file sort order when the index has `index.sort.field`.
        let pq_meta = builder.metadata().clone();
    table_path: &ListingTableUrl,
                crate::query_tracker::set_cpu_runtime_handle(context_id, rt);
/// - [`InternalSearch::SeqNoAbove`]: `SELECT _id,_seq_no,_primary_term,_version WHERE _seq_no > f`
        path: table_path.prefix().clone(),
                    cpu_executor.clone(),
use datafusion::{
///
/// Build the query DataFrame against the table already registered in `ctx`.
    let (stream_ptr, physical_plan) =
                        "execute_with_context: failed to execute prepared plan: {}",
        // FINAL substrait declares VARBINARY (resolver's overrideExchangeType), so the wire
        let dataframe = handle.ctx.execute_logical_plan(logical_plan).await?;
            if let Some(rt) = cpu_executor.handle() {
/// Parse a ListingTableUrl into an ObjectStoreUrl (scheme + authority).
                ))
    }
    // (non-row-id) path — QTF row-id plans always route to the indexed executor.
                })?;
                cross_rt_stream.schema(),
                    i64,
        }
    let stream_handle = match physical_plan {
    context_id: i64,
            datafusion::execution::object_store::DefaultObjectStoreRegistry::new(),
            );
/// - [`InternalSearch::SeqNoAbove`]: `SELECT _id,_seq_no,_primary_term,_version WHERE _seq_no > f`
    );
        .with_file_size(meta.size);
            ),
///
    object_metas: Arc<Vec<ObjectMeta>>,
        *Box::from_raw(
            stream_ptr
) -> Result<Arc<datafusion::execution::runtime_env::RuntimeEnv>, DataFusionError> {
        InternalSearch::SeqNoAbove(seq_no_floor) => df
    }
        .map_err(|e| DataFusionError::Execution(format!("parse URL: {}", e)))?;
    Ok(Arc::from(runtime_env))
        let logical_plan =
                (
    let logical_plan =
            })?;
                (
            let empty_exec = EmptyExec::new(Arc::clone(&plan_schema));
    let token = crate::query_tracker::get_cancellation_token(context_id);
    };
        cross_rt_stream.schema(),
                    runtime.runtime_env.cache_manager.get_file_statistic_cache(),
            .filter(col("_seq_no").gt(lit(seq_no_floor)))?
            .limit(0, Some(1)),
/// filter DataFrame; otherwise this is the standard user-search flow: decode the Substrait plan
        crate::substrait_consumer::from_substrait_plan(&ctx.state(), &substrait_plan).await?;
    let wrapped = datafusion::physical_plan::stream::RecordBatchStreamAdapter::new(
        }
            handle.ctx,
    };
    );
    let query_future = async {
/// by the time this function is reached the pointer is already invalidated from
    runtime: &DataFusionRuntime,
    // Retag any physical-plan output columns whose type tags differ from what Substrait
        Some(plan) => crate::api::QueryStreamHandle::with_physical_plan(
    };
        e
        )
                e
async fn internal_search_dataframe(
    table_name: &str,
            .await
        // semantics — only AggregateExec(Mode::Partial) executes, emitting state-suffixed
    if let Some(rt) = cpu_executor.handle() {
        error!("Failed to create execution stream: {}", e);
pub async fn execute_with_context(
            "DataFusion physical plan:\n{}",
        return internal_search_dataframe(ctx, table_name, internal_search).await;
            }
                i64,
        // this guard a worker's join/aggregate plan would short-circuit to EmptyExec and silently
) -> i64 {
                df_stream,
    physical_plan: Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
        Ok::<
                );
/// Java's perspective and cleanup is pure RAII.
        })?;
    let physical_plan = dataframe.create_physical_plan().await?;
            let (cross_rt_stream, abort_handle, _task_done) =
/// Takes ownership of the handle by value. The ownership transfer (consuming the
    // Standard user-search flow: Substrait → logical plan → DataFrame.
        )
/// registry plus the provided per-query `list_file_cache`. Callers overlay any
                    Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
pub fn query_runtime_env_builder(
    runtime: &DataFusionRuntime,
    let physical_plan = crate::relabel_exec::wrap_if_relabel_needed(physical_plan, target_schema)?;
    // Permit was acquired by the caller (ffm.rs) on the IO runtime before
        ),
    runtime: &DataFusionRuntime,
    Ok(files)
pub fn build_query_runtime_env(
        Some(corrector) => cross_rt_stream.with_phantom_corrector(corrector),
    object_metas: &[ObjectMeta],
                    None,
            row_base: cumulative_rows,
                cross_rt_stream,
    Ok(Box::into_raw(Box::new(wrapped)) as i64)
    let substrait_plan = Plan::decode(plan_bytes)
                None,
}
/// Like [`wrap_stream_as_handle`] but attaches a physical plan so that execution metrics
            Some(permit),
            crate::substrait_consumer::from_substrait_plan(&handle.ctx.state(), &substrait_plan)
            CrossRtStream::new_with_df_error_stream_cancellable(
            crate::query_tracker::set_cpu_runtime_handle(context_id, rt);
    })?;
            >((Box::into_raw(Box::new(wrapped)) as i64, Some(physical_plan)));
}
        cumulative_rows += num_rows;
    let context_id = handle.query_context.context_id();
    }
// ── Shared helpers ──────────────────────────────────────────────────────────
            let plan_schema = crate::schema_coerce::coerce_inferred_schema(plan_schema);
            execute_stream(physical_plan.clone(), handle.ctx.task_ctx()).map_err(|e| {
    common::DataFusionError, datasource::listing::ListingTableUrl,
            crate::api::QueryStreamHandle::new_with_plan(wrapped, query_context, None, plan)
        runtime,
    phantom_corrector: Option<Arc<crate::phantom_corrector::PhantomCorrector>>,
            let df_stream =
                .with_metadata_cache_limit(
            stream,
                    cpu_executor.clone(),
            cross_rt_stream,
                    i64,
                error!("execute_with_context: failed to create stream: {}", e);
