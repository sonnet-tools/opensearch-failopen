#[no_mangle]
    assert!(runtime_ptr != 0, "df_fetch_by_row_ids: runtime_ptr is null");
    // Pointer type is `Arc<dyn MetadataCachingStore>`; the manager calls `put_metadata`
    let gate_name_owned = gate_name.to_string();
    cache_type_ptr: *const u8,
        .clear_cache_type(cache_type)
                    Err(e) => Err(datafusion::error::DataFusionError::Execution(format!(
    /// Combined test for gate routing, driving [`update_concurrency_gate`] with the manager passed
        &schema_ipc,
        return Ok(CAN_MATCH_UNKNOWN);
        cache::CACHE_TYPE_STATS => {
/// `handle_ptr` must be a valid pointer returned by `df_create_session_context`.
    let gate = match gate_name {
                tree_shape,
    let schema_ipc = api::register_memtable(
    // ignored and the plan is built natively via the DataFrame API — no Substrait.
            0
    // or if the plan projects __row_id__ (QTF query phase). QTF row-id computation
    if shard_view_ptr == 0 || out_ptr.is_null() {
    let store = Arc::clone(&shard_view.store);
#[no_mangle]
    Ok(0)
#[no_mangle]
    let partial_plan = slice::from_raw_parts(partial_plan_ptr, partial_plan_len as usize);
fn timed_block_on<F: std::future::Future>(
        sort_fields,
// ---------------------------------------------------------------------------
    let mgr = get_rt_manager()?;
/// probe scan registered, so the memtable lives alongside that table.
#[ffm_safe]
        let _ = Box::from_raw(ptr as *mut CustomCacheManager);
        cache::CACHE_TYPE_STATS => {
}
        }
}
/// Returns a stream pointer (same shape as `df_execute_local_plan`) that can
/// sender that streams batches one at a time, the caller hands across `n`
    }
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
        )
    handle_ptr: i64,
    let mut file_paths = Vec::with_capacity(files_count as usize);
    cache_type_len: i64,
pub unsafe extern "C" fn df_prepare_final_plan(
    let mut file_paths = Vec::with_capacity(files_count as usize);
///
    schema_ipc_len: i64,
use crate::statistics_cache::CustomStatisticsCache;
            "df_cache_manager_update_size_limit: negative limit {}",
    filter_max: i64,
        .file_metadata
    if store_ptr == 0 {
        );
            shard_view, runtime, &mgr, row_ids, columns, context_id,
    for file_meta in files.iter() {
    /// so building the replacement before retiring the old one ends with a live manager and an
    cache_type_ptr: *const u8,
    for i in 0..files_count as usize {
            e
#[no_mangle]
        crate::partition_stream::SendOutcome::Sent => 0,
    bytes_ptr: *const u8,
    shard_view_ptr: i64,
            out[3] = b.value_kind as i64;
pub unsafe extern "C" fn df_cache_manager_clear(runtime_ptr: i64) -> i64 {
    context_id: i64,
/// must close them via Arrow C Data Interface.
    let metadata = cached_parquet.parquet_metadata();
use crate::cache::page_index;
    /// published. `RuntimeManager::new` publishes the handle and `RuntimeManager::drop` clears it,
        slice::from_raw_parts(array_ptrs, n)
    input_id_len: i64,
        return Ok(0);
        let rc = unsafe { df_can_match(0, 0, column.as_ptr(), column.len() as i64, 0, 100) };
            new_limit
/// `i64`s, where each pair `(array_ptrs[i], schema_ptrs[i])` is a populated
        // ── Test 2: "fragment_executor" routes to CPU executor gate (Req 2.2) ──
#[no_mangle]
        )
    if runtime_ptr == 0 {
#[no_mangle]
    let mgr = get_rt_manager()?;
            size_limit
                fragment_executor_gate.max_permits(),
/// Streaming sibling of `df_register_memtable_on_session_context`. Registers a partitioned
/// Promotion happens entirely in Rust inside `CustomCacheManager::add_files_with_store`;
    page_index::clear_scoped_cache();
    write_out_buffer(
                runtime_ptr,
    query_config_ptr: i64,
    for i in 0..sort_count as usize {
                .to_string(),
    // spawn in `execute()`. Without this wrap those spawns inherit the IO
pub unsafe extern "C" fn df_can_match(
}
#[no_mangle]
    let row_ids: Vec<i64> =
        schema_slice,
    out_len: *mut i64,
use log::warn;
        file_paths.push(
                Ok(inner_result) => inner_result,
        filenames.push(
    let written = snapshot_top_n_by_current(out);
    };
///
}
        schema_slice,
        );
) -> i64 {
    crate::session_context::close_session_context(ptr);
    Ok(0)
                        crate::query_executor::execute_with_context(
            None => file_bounds,
        assert_eq!(
            &path,
    let mgr = get_rt_manager()?;
        );
            .block_on(async move {
    let handle = &*(stream_ptr as *const api::QueryStreamHandle);
    shard_view_ptr: i64,
    if shard_view_ptr == 0 {
#[ffm_safe]
            let inner_fut = async move {
    })?;
    column_name: &str,
    execution_spill_x1000: i64,
    Box::into_raw(Box::new(manager)) as i64
    };
        &mgr.io_runtime,
    )
        let _globals = crate::test_process_globals::lock();
                has_partial_aggregate != 0,
    partition_count: i32,
        .map_err(|e| format!("df_sender_fail: reason: {}", e))?;
    let internal_search = InternalSearch::from_wire(internal_search_mode, internal_search_bound);
    let table_name = str_from_raw(table_name_ptr, table_name_len)
///
            .as_ref()
        crate::task_monitors::stream_next_monitor().instrument(api::stream_next(stream_ptr)),
    if files.is_empty() {
            let ptr = Box::into_raw(boxed) as *const u8;
    };
            crate::session_context::create_session_context(
    if runtime_ptr == 0 || out_ptr.is_null() {
        );
        "df_cache_manager_get_total_memory: no cache manager configured".to_string()
#[no_mangle]
        .ok_or_else(|| "df_cache_manager_remove_files: no cache manager configured".to_string())?;
    let shard_view = &*(shard_view_ptr as *const api::ShardView);
    };
///
    // Pointer to a `WireDatafusionQueryConfig`
        let Some(file_bounds) = file_bounds else {
    Ok(size as i64)
    use object_store::path::Path as ObjectPath;
use crate::eviction_policy::CacheEvictionPolicy;
    schema_ipc_len: i64,
    // eagerly spawn in their `execute()` method (RepartitionExec,
    input_id_ptr: *const u8,
    input_id_len: i64,
        "df_fetch_by_row_ids: negative col_names_count {}",
        bytes.extend_from_slice(&s.to_le_bytes());
use crate::api::DataFusionRuntime;
        .downcast_ref::<CachedParquetMetaData>()?;
/// Cache-miss fallback: read footer via the shard's ObjectStore.
    // See `df_execute_query` for the rationale behind wrapping the inner
    store_ptr: i64,
    let mgr_for_inner = Arc::clone(&mgr);
                "fragment_executor gate max_permits should be updated to {}, is {}",
/// Fails a partition stream: pushes an error into the channel (so the consumer's stream yields an
        .map_err(|e| e.to_string())?;
// string pointer that `NativeCall.invoke` reads and frees on the Java side.
    // Decode parallel sort_fields / sort_orders String arrays. sort_count == 0 means no
    if row_ids_count > 0 {
    /// `TOKIO_RUNTIME_MANAGER`: clearing it would strand every other test in this binary that is
    let shard_view = &*(shard_view_ptr as *const api::ShardView);
            if policy != CacheEvictionPolicy::Fifo {
}
        sort_orders.push(
    if size_limit < 0 {
    runtime_ptr: i64,
    }
            // exclusively on the data-node FFM entry points.
    } else {
    Ok(0)
        session_ptr,
    crate::memory_guard::set_pool_limit_for_guard(new_limit);
                table_name,
            Ok(1)
        _ => {
                query_config,
            let len = bytes.len() as i64;
            return Err(format!(
    timed_block_on(&mgr.io_runtime, "execute_query", async move {
    let mgr = get_rt_manager()?;
        );
    let io_runtime = pack_runtime_metrics(&mgr.io_monitor, mgr.io_runtime.handle());
}
    write_out_buffer(&bytes, out_ptr, out_cap, out_len, "substrait plan")?;
    // async work in `cpu_executor.spawn`. In short: DataFusion operators
            let inner_cache = DefaultFilesMetadataCache::new(size_limit as usize);
            std::thread::sleep(std::time::Duration::from_millis(100));
    ))
        let published = native_bridge_common::io_runtime::io_handle()
        .custom_cache_manager
/// to at least `SORT_BOUNDS_SLOTS` writable i64 slots.
pub unsafe extern "C" fn df_register_memtable(
    api::create_reader(
pub unsafe extern "C" fn df_cache_manager_contains_by_type(
#[no_mangle]
    .map_err(|e| e.to_string())
            let gate = mgr.cpu_executor().concurrency_gate().clone();
#[ffm_safe]
/// wrong-result into a loud query failure. The reason string is included in the surfaced error.
use crate::api;
/// Can-match evaluation via FFM. Iterates ALL parquet files in the shard view
    schema_ptrs: *const i64,
        "df_cache_manager_add_files_with_store: {} files, {} warmed (page-index promoted to metadata Foyer)",
    if new_limit < 0 {
    if cap_entries < 0 {
                return Err(format!("df_create_cache: OFFSET_INDEX cache only supports FIFO eviction, got {eviction_type}"));
) -> i64 {
    }
        .custom_cache_manager
    )
                shard_view_ptr,
/// On success returns 0 and writes 16N to `out_len`. On error returns the FFM sentinel.
        return Err("df_cache_manager_get_total_memory: null runtime pointer".to_string());
                result, 0,
    api::register_partition_stream_on_session_context_from_partial_plan(
        *Box::from_raw(session_ctx_ptr as *mut crate::session_context::SessionContextHandle);
        sort_orders,
/// pointer (negated error pointer on failure).
            Ok(inner) => inner,
                let gate = mgr_for_spawn.cpu_executor().concurrency_gate().clone();
}
    }
/// Prepares a partial-aggregate physical plan on the session context handle.
            crate::session_context::create_worker_session_context(
    })
        "df_fetch_by_row_ids: shard_view_ptr is null"
        session_ctx_handle_ptr,
    Ok(if manager.contains_file_by_type(file_path, cache_type) {
/// Decodes the Substrait bytes, converts to a physical plan, strips the
    sql_len: i64,
            // Gate should not have been modified
        .get_file_metadata_cache_for_datafusion()?;
// dynamic setting changes (DataFusionPlugin settings consumers). They forward
        warn!(
                );
    // Parse the eviction type string into the unified CacheEvictionPolicy enum.
#[ffm_safe]
        layout, pack_adaptive_budget, pack_cache_stats, pack_partition_gate, pack_runtime_metrics,
pub unsafe extern "C" fn df_create_worker_session_context(
    let Some(mgr) = manager else {
        &[]
        let file_path = file_meta.location.as_ref();
    col_names_count: i64,
        "partition_batch_by_hash output ptrs",
// and writes them back-to-back. See `query_tracker::WireQueryMetric` for the
        0
// the heaviest live queries by `current_bytes` (bounded min-heap of size N)
    files_len_ptr: *const i64,
///
        warn!("df_update_concurrency_gate called before runtime init");
                        context_id,
                table_name,
            installed.io_runtime.handle().id(),
    // requires `'static`). The `shard_view_ptr`, `runtime_ptr` are raw pointers
#[ffm_safe]
        );
}
        crate::partition_stream::SendOutcome::ReceiverDropped => SENDER_SEND_RECEIVER_DROPPED,
    api::set_memory_pool_limit(runtime_ptr, new_limit)?;
    write_out_buffer(
    fn wait_for_max_permits(gate: &ConcurrencyGate, expected: u32) -> bool {
    }
/// Zero is ignored; negative returns an error.
        None => -1,
    if col_names_count > 0 {
/// Set the byte budget of the process-global scoped OffsetIndex cache.
        );
#[no_mangle]
/// Number of i64 slots `df_shard_sort_bounds` writes into `out_ptr`.
        crate::datafusion_query_config::DatafusionQueryConfig::from_ffm_ptr(query_config_ptr);
pub unsafe extern "C" fn df_cache_manager_get_total_memory(runtime_ptr: i64) -> i64 {
        columns.push(name.to_string());
    let manager = runtime.custom_cache_manager.as_ref().ok_or_else(|| {
#[ffm_safe]
#[no_mangle]
#[ffm_safe]
    }
            }
/// caller-provided output buffer (8 bytes for array_ptr, 8 bytes for schema_ptr, repeated).
    runtime: &tokio::runtime::Runtime,
    };
    // native-repository-{s3,gcs,azure} stores read that handle to put their HTTP IO on this runtime.
pub unsafe extern "C" fn df_create_session_context(
pub extern "C" fn df_set_cancel_stats_threshold_ms(millis: i64) {
            str_from_raw(o_ptr, o_len)
    let plan_bytes = slice::from_raw_parts(plan_ptr, plan_len as usize);
        assert_eq!(send_outcome_to_code(SendOutcome::Sent), 0);
pub extern "C" fn df_clear_scoped_page_index_cache() -> i64 {
/// on the named column.
            match mgr_for_spawn.cpu_executor().spawn(inner_fut).await {
        .map_err(|e| format!("df_create_session_context: {}", e))?;
    }
        return Err(format!(
                            session_handle,
/// [`SENDER_SEND_RECEIVER_DROPPED`] so the Java side can latch early-termination.
        }),
        .map_err(|e| format!("df_cache_manager_remove_files: {}", e))?;
                return Err(format!("df_create_cache: COLUMN_INDEX cache only supports FIFO eviction, got {eviction_type}"));
        return Ok(0);
pub extern "C" fn df_set_reduce_target_partitions(value: i64) {
                    )
#[ffm_safe]
        // The cases below resize the gate on the manager the whole test binary shares, so they
                Arc::new(CustomStatisticsCache::new(policy, size_limit as usize, 0.8));
/// partial-aggregate half, and stores the result on the session for later
/// lowering the producer-side substrait `partial_plan_bytes`; the resulting
    api::create_local_session(runtime_ptr).map_err(|e| e.to_string())
    // instead of the IO runtime. Without this, operator hash work runs on IO workers.
    };
        execution_critical: execution_critical_x1000 as f64 / 1000.0,
pub unsafe extern "C" fn df_stream_get_metrics(
        .map_err(|e| format!("df_register_memtable_on_session_context: input_id: {}", e))?;
        input_schema_ptr,
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
    bytes: &[u8],
pub extern "C" fn df_set_column_index_cache_limit(size_limit: i64) -> i64 {
#[no_mangle]
        partition_count,
#[ffm_safe]
            // CI/OI use BoundedCache<FIFO>; eviction type must be FIFO.
    files_len_ptr: *const i64,
    match cache_type {
    cache_type_len: i64,
    let files = &shard_view.object_metas;
    let manager = runtime.custom_cache_manager.as_ref().ok_or_else(|| {
    page_index::set_offset_index_cache_limit(size_limit as usize);
    let io_runtime = mgr.io_runtime.clone();
    eviction_type_len: i64,
    bytes_ptr: *const u8,
/// channel sender pointer. M2 hash-shuffle workers register left/right partition inputs via
) -> i64 {
#[ffm_safe]
        return None;
        col_names_count >= 0,
    let mut columns: Vec<String> = Vec::with_capacity(col_names_count as usize);
    plan_len: i64,
            pack_runtime_metrics(cpu_mon, &cpu_handle)
    session_ptr: i64,
        cache::CACHE_TYPE_METADATA => {
    session_ctx_ptr: i64,
    mgr.io_runtime
        .as_ref()?
    if stream_ptr == 0 {
    shard_view_ptr: i64,
// is not yet present. Once PR 1 merges the bodies replace these no-ops.
}
        coordinator_reduce: pack_task_monitor(coordinator_reduce_monitor()),
    Ok(0)
/// Only log block_on durations exceeding this threshold.
        "LFU" => CacheEvictionPolicy::Lfu,
        return Err("df_cache_manager_add_files_with_store: null store pointer".to_string());
/// When enabled (default): metadata cache strips page index; scoped caches handle it.
        }
        "stream_next",
#[no_mangle]
    let shard_view = &*(shard_view_ptr as *const api::ShardView);
    /// Replaces the manager the rest of the binary shares, hence the process-globals lock. What it
            std::thread::sleep(std::time::Duration::from_millis(5));
) -> i64 {
        }
}
    Ok(0)
            if policy != CacheEvictionPolicy::Fifo {
pub unsafe extern "C" fn df_execute_local_prepared_plan(session_ptr: i64, context_id: i64) -> i64 {
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
pub unsafe extern "C" fn df_create_local_session(runtime_ptr: i64) -> i64 {
///
        let inner_fut = crate::task_monitors::query_execution_monitor().instrument(async move {
    array_ptrs: *const i64,
    assert!(
    session_ctx_handle_ptr: i64,
/// with a plan already prepared via `df_prepare_final_plan`.
    api::cancel_query(context_id);
    spill_dir_ptr: *const u8,
#[no_mangle]
            ));
}
        stream_next: pack_task_monitor(stream_next_monitor()),
            return 0;
        df_init_runtime_manager(1, 1.5, 1.5);
/// off-heap ArrowBuf). Zero-copy at FFM boundary: Rust reads directly from
        cpu_threads as usize,
    /// machine is.
        crate::datafusion_query_config::DatafusionQueryConfig::from_ffm_ptr(query_config_ptr);
    crate::search_stats::inc_listing_table_scan();
        {
                            cpu_for_cross,
    hash_key_indices_len: i64,
}
    let bytes = slice::from_raw_parts(ptr, len as usize);
                delegated_predicate_count,
        .map_err(|e| format!("df_create_cache: eviction_type: {}", e))?;
    let store = std::sync::Arc::clone(store_box);
}
///
unsafe fn try_cached_can_match(
        input_id,
    page_index::set_scoped_page_index_enabled(enabled != 0);
/// the byte count through `out_len` (when non-null). Returns `Err` when the
#[no_mangle]
        .map_err(|e| format!("df_cache_manager_update_size_limit: {}", e))?;
    let mut guard = TOKIO_RUNTIME_MANAGER.write();
    let schema_slice: &[i64] = if n == 0 {
    use datafusion::datasource::physical_plan::parquet::metadata::CachedParquetMetaData;
        .block_on(crate::task_monitors::plan_setup_monitor().instrument(
/// header. This registers the streaming table under the FINAL fragment's logical column names
    // the plan construction and stream wrapping hop to CPU.
        _ => {
        .map_err(|e| format!("df_sql_to_substrait: table_name: {}", e))?;
        return Err("df_create_cache: null cache manager pointer".to_string());
    );
    if shard_view_ptr == 0 {
    session_ptr: i64,
    } else {
            filter_min,
                context_id,
        .block_on(crate::task_monitors::plan_setup_monitor().instrument(
    if files.is_empty() {
    // so a single sort_count covers both arrays.
    let use_indexed = session_handle.indexed_config.is_some() || has_row_id;
                    crate::task_monitors::query_execution_monitor().instrument(async move {
#[ffm_safe]
 * this file be licensed under the Apache-2.0 license or a
    match tree_shape {
    .map_err(|e| e.to_string())
        .as_ref()
            // Through the real FFI entry point, so its pointer/length shell stays covered.
    session_ctx_handle_ptr: i64,
                .map_err(|e| format!("df_create_reader: sort_field[{}]: {}", i, e))?
#[ffm_safe]
            replacement_handle.id(),
                "fragment_executor gate should not be modified for unknown gate name"
/// # Safety
                            plan_vec,
pub unsafe extern "C" fn df_register_memtable_on_session_context(
        array_slice,
        .map_err(|e| format!("df_cache_manager_add_files: {}", e))?;
    }
        RuntimeMetricsRepr::zeroed()
    api::sender_terminate_early(sender_ptr);
                match mgr_for_spawn.cpu_executor().spawn(inner_fut).await {
    cap_entries: i64,
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
        out_len,
}
    if runtime_ptr == 0 {
    files_ptr: *const *const u8,
    if runtime_ptr == 0 {
    let table_name = str_from_raw(table_name_ptr, table_name_len)
    let rt_handle = rt_manager.io_runtime.handle();
/// When disabled: metadata cache retains full page index (fallback mode).
    cache_type_len: i64,
}
            cache_type
    .map_err(|e| e.to_string())
                deleted_doc_filtering_required != 0,
    if runtime_ptr == 0 {
    manager
        return Err(format!(
            published.id(),
    // Always-on `assert!` (not debug_assert!) — these protect against use-after-close from Java.
        format!(
pub const CAN_MATCH_UNKNOWN: i64 = 2;
    } else {
}
    let rt_manager = try_get_rt_manager()?;
    gate_name_len: i64,
    runtime_ptr: i64,
    // Cache stats (zeroed when no runtime pointer or no cache manager)
    }
        .map_err(|e| format!("df_cache_manager_contains_by_type: cache_type: {}", e))?;
    }
        file_paths.push(
/// `df_sender_send` return code when the consumer dropped the receiver. Positive so it rides the
/// than read from `TOKIO_RUNTIME_MANAGER`. Taking it as an argument is what lets a test reach the
/// `bytes_ptr` must point to `bytes_len` valid bytes of a Substrait plan.
        // ── Test 3: unknown gate name returns success without modifying gates (Req 2.4) ──
pub unsafe extern "C" fn df_stats(runtime_ptr: i64, out_ptr: *mut u8, out_cap: i64) -> i64 {
pub extern "C" fn df_shutdown_runtime_manager() {
        .map_err(|e| e.to_string())?;
    if runtime_ptr == 0 {
        .map_err(|e| format!("df_create_reader: {}", e))?;
    for (a, s) in &pairs {
) -> i64 {
/// Hash-partitions one Arrow C Data batch into N output batches using DataFusion's
/// mapping). Writes the resulting N (array_ptr, schema_ptr) pairs as 16N bytes into the
#[ffm_safe]
        std::mem::size_of::<DfStatsBuffer>(),
                deleted_doc_filtering_required != 0,
    }
/// `BatchPartitioner` (matches `RepartitionExec` and `HashJoinExec` row-to-partition
        // merge widens the range and ORs has_nulls. None means the files disagree on value
    fn can_match_status_codes_are_non_negative() {
                new_max,
/*
        "df_cache_manager_get_memory_by_type: no cache manager configured".to_string()
        store_ptr,
/// reading the footer via the shard's ObjectStore (local disk or S3).
    }
        .map_err(|e| e.to_string())?;
/// buffer is too small — the caller can re-allocate and retry.
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
        try_get_rt_manager(),
    }
    // land on IO workers at plan-setup time and the IO runtime ends up doing
/// Java: NativeBridge.updateConcurrencyGate(String, int)
    let table_name = str_from_raw(table_name_ptr, table_name_len)
        df_init_runtime_manager(1, 1.5, 1.5);
    // with `HttpErrorKind::Interrupted`, because a spawn onto a shut-down runtime is cancelled
            published.id(),
    runtime_ptr: i64,
            .await
    runtime_ptr: i64,
    table_name_len: i64,
    has_partial_aggregate: u8,
) -> i64 {
    cache_type_ptr: *const u8,
    new_limit: i64,
/// Fold bounds from the metadata cache if the file is present there.
    context_id: i64,
        >);
        return Err("df_cache_manager_get_memory_by_type: null runtime pointer".to_string());
}
                // creating backpressure at the Java threadpool level when the gate is full.
) -> i64 {
) -> i64 {
pub extern "C" fn df_set_offset_index_cache_limit(size_limit: i64) -> i64 {
pub unsafe extern "C" fn df_partition_batch_by_hash(
//
    /// `df_can_match` reports has to be non-negative. A negative one is read by Java as an
            out_cap
        let o_len = *sort_orders_len_ptr.add(i);
    /// empty handle slot — and the native-repository-{s3,gcs,azure} stores read that slot to decide
    }
    input_id_ptr: *const u8,
        &[]
        query_execution: pack_task_monitor(query_execution_monitor()),
    filter_min: i64,
    } else {
    }
        &[]
    let plan_vec = plan_bytes.to_vec();
    // publishes the IO runtime handle and `RuntimeManager::drop` clears it, so dropping the old one
/// the worker FINAL's by-name `base_schema` binding resolves. See
    // Engine-internal point lookup. 0 = normal query (decode `plan_ptr` as Substrait);
}
            }
/// Returns one of the `CAN_MATCH_*` statuses below.
    }
) -> i64 {
    let size = manager
    out_ptr: *mut u8,
        bytes.extend_from_slice(&a.to_le_bytes());
}
                // Acquire datanode gate on IO runtime BEFORE spawning on CPU.
                        file_size,
#[ffm_safe]
/// After this call:
// ---------------------------------------------------------------------------
    let mut writer_generations = Vec::with_capacity(files_count as usize);
            );
    let files = &shard_view.object_metas;
        let len = *files_len_ptr.add(i);
        return Err("df_cache_manager_clear_by_type: null runtime pointer".to_string());
        .file_metadata
#[ffm_safe]
    // Route based on whether the session was configured for indexed execution,
    }
#[no_mangle]
    .map_err(|e| e.to_string())?;
            "df_set_offset_index_cache_limit: negative limit {}",
///
    table_name_ptr: *const u8,
    Ok(0)
    }
        return Err("null snapshot buffer".to_string());
pub unsafe extern "C" fn df_stream_next(stream_ptr: i64) -> i64 {
            let metadata_cache = Arc::new(cache::MutexFileMetadataCache::new(inner_cache));
}
///
}
    let n = n_batches as usize;
/// Java: MethodHandle(JAVA_LONG, ADDRESS → void)
    files_len_ptr: *const i64,
    } else {
    };
#[no_mangle]
    file_path: &str,
/// Copies up to `cap_entries` of the heaviest live queries (by
 */
    runtime_ptr: i64,
) -> i64 {
    }
    table_name_ptr: *const u8,
) -> i64 {
        .map_err(|e| format!("df_execute_query: {}", e))?;
        let column = "@timestamp";
                runtime_ptr,
        "LRU" => CacheEvictionPolicy::Lru,
    /// Re-initialising on top of an existing manager must leave the NEW manager's IO handle
    // call to the async spawn handle).
}
    let mgr = get_rt_manager()?;
    file_path_len: i64,
        &schema_ipc,
    Ok(())
pub unsafe extern "C" fn df_close_session_context(ptr: i64) {
    gate_name_ptr: *const u8,
            return Ok(0);
        }
}
    partial_plan_ptr: *const u8,
                .to_string(),
                let permit = gate.acquire_many(partition_weight.min(max_p)).await;
    use crate::partition_stream::SendOutcome;
        gate.max_permits() == expected
    // Safety: cache_manager_ptr must be a valid pointer from df_create_custom_cache_manager
//
        column_name,
    };
// ---------------------------------------------------------------------------
pub unsafe extern "C" fn df_query_registry_top_n_by_current(
                let max_p = gate.max_permits();
    /// Helper: call df_update_concurrency_gate with a Rust string.
    out_ptr: *mut u8,
                        .await
    /// a runtime or any parquet on disk.
#[no_mangle]
            .map_err(|e| e.to_string())
/// Java: MethodHandle(JAVA_LONG, JAVA_LONG → JAVA_LONG)
unsafe fn try_store_can_match(
        .read()
pub unsafe extern "C" fn df_create_session_context_indexed(
/// `api::register_partition_stream_on_session_context_from_partial_plan` for the full rationale.
        }
            str_from_raw(f_ptr, f_len)
    column_name: &str,
    let manager = runtime
        let len = *files_len_ptr.add(i);
///   `ts_get_object_store_box_ptr`).
    files_ptr: *const *const u8,
            row_ids_count
pub unsafe extern "C" fn df_stream_close(stream_ptr: i64) {
/// `NativeLibraryLoader.checkResult` treats every negative return as an address to read a message
        // domain, so there is no shard-wide range.
    runtime_ptr: i64,
        "execute_local_plan",
        .block_on(crate::api::fetch_by_row_ids(
    // once the new one has published leaves a live manager with no handle registered — and the
        gate.resize(new_max_permits, &gate_name_owned).await;
    let partial_plan = slice::from_raw_parts(partial_plan_ptr, partial_plan_len as usize);
        }
}
        let runtime = &*(runtime_ptr as *const DataFusionRuntime);
// Mirror the shard-scan exports above: fallible entry points use `#[ffm_safe]`
        .map_err(|e| format!("df_cache_manager_contains_by_type: file_path: {}", e))?;
        partial_plan,
/// `runtime_ptr` may be `0` to skip cache-stats collection. When non-zero it
) -> i64 {
                    ))),
        // Extract target_partitions BEFORE boxing into raw pointer (session_handle is consumed).
        &[]
/// `bytes_ptr` must point to `bytes_len` valid bytes of a Substrait plan.
            ),
    // Copy struct bytes to caller buffer
    let pairs = api::partition_batch_by_hash(
    table_name_len: i64,
        // TODO: refactor execute_indexed_with_context to take SessionContextHandle directly
}
/// Could not tell (no statistics, unreadable footer, unsupported stats type) — keep the shard.
    /// handle. Ordering the drop earlier cannot help here; the teardown has to check ownership.
    new_max_permits: u32,
    let mgr = get_rt_manager()?;
        );
        str_from_raw(sql_ptr, sql_len).map_err(|e| format!("df_sql_to_substrait: sql: {}", e))?;
    reason_len: i64,
    // IO runtime (always present)
    })
    })?;
        out_cap,
    result
                            ptr,
    file_path: &str,
        crate::datafusion_query_config::DatafusionQueryConfig::from_ffm_ptr(query_config_ptr);
    let input_id = str_from_raw(input_id_ptr, input_id_len)
        return Err("null runtime pointer".to_string());
) -> i64 {
    let store_box = &*(store_ptr
/// Clear the process-global scoped page-index caches (drop entries + reset counters).
            row_ids_ptr != 0,
        new_max_permits,
    let manager = runtime
            if gate.max_permits() == expected {
    let array_slice: &[i64] = if n == 0 {
    column_name_len: i64,
    files_count: i64,
        );
fn send_outcome_to_code(outcome: crate::partition_stream::SendOutcome) -> i64 {
            Ok(0)
            *out_len_ptr = len;
        crate::can_match::sort_bounds_via_store(store, &path, file_size, column_name).await
        match mgr_for_spawn.cpu_executor().spawn(inner_fut).await {
        .map_err(|e| format!("df_cache_manager_clear_by_type: {}", e))?;
    // left `None` installed for good, and a store that captured a dead handle fails every request
#[ffm_safe]
    session_ptr: i64,
/// Java's off-heap buffer without any intermediate allocation.
    }
    // (`_seq_no > internal_search_bound`). When non-zero, `plan_ptr`/`plan_len` are
    api::execute_local_prepared_plan(session_ptr, &mgr, context_id, None).map_err(|e| e.to_string())
        return Err(format!("negative capacity: {cap_entries}"));
            }
                plan_bytes,
    )
#[ffm_safe]
/// For each file: tries the metadata cache first (zero I/O), falls back to
#[ffm_safe]
// SessionContext decomposition — instruction-based execution
    if cache_manager_ptr == 0 {
    let cache = runtime
        .get_memory_consumed_by_type(cache_type)
                internal_search,
}
        }
    }
                // creating backpressure at the Java threadpool level when the gate is full.
}
pub unsafe extern "C" fn df_cache_manager_update_size_limit(
    column_name_ptr: *const u8,
/// and returns 1. Returns 0 with `out_ptr` untouched when no shard-wide bound exists —
            crate::task_monitors::plan_setup_monitor()
    // Parse column names
        _ => {}
#[ffm_safe]
///
        cache_stats,
const BLOCK_ON_LOG_THRESHOLD: Duration = Duration::from_millis(1);
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
pub unsafe extern "C" fn df_execute_query(
            str_from_raw(ptr, len)
        slice::from_raw_parts(row_ids_ptr as *const i64, row_ids_count as usize).to_vec();
        Some(b) => {
    ///
#[no_mangle]
    let input_id = str_from_raw(input_id_ptr, input_id_len).map_err(|e| {
/// Resize logic behind [`df_update_concurrency_gate`], with the runtime manager passed in rather
        .downcast_ref::<CachedParquetMetaData>()?;
        .map_err(|e| e.to_string())
/// Separate from `df_can_match` on purpose: that function short-circuits at both the
    cpu_threads: i32,
/// Frees a metrics buffer previously returned by `df_stream_get_metrics`.
pub unsafe extern "C" fn df_cache_manager_add_files_with_store(
    let mut file_paths = Vec::with_capacity(files_count as usize);
/// Returns execution metrics as JSON bytes for the given stream.
                .to_string(),
                .update_statistics_cache_limit(new_limit as usize)
/// the native side constructs a [`MemTable`] in one shot.
    let cache = runtime
            col_names_count
    // Retire the outgoing manager before building its replacement, not after. `RuntimeManager::new`
    let manager = CustomCacheManager::new();
///
    let cache_type = str_from_raw(cache_type_ptr, cache_type_len)
// ---------------------------------------------------------------------------
        out_len,
pub unsafe extern "C" fn df_sender_send(sender_ptr: i64, array_ptr: i64, schema_ptr: i64) -> i64 {
use std::time::{Duration, Instant};
                Some(merged) => merged,
    manager
    //
                    Ok(inner) => inner,
    // instead of the IO runtime. Without this wrap those operator drain tasks
        out_ptr,
    admission_reject_x1000: i64,
}
pub unsafe extern "C" fn df_update_concurrency_gate(
                    });
    if runtime_ptr == 0 {
                // Acquire datanode gate on IO runtime BEFORE spawning on CPU.
    cache_type_len: i64,
    #[test]
                });
        assert_eq!(rc, CAN_MATCH_UNKNOWN);
        schema_ipc,
    has_partial_aggregate: u8,
        .map_err(|e| format!("df_update_concurrency_gate: {}", e))?;
        .clone()
}
// Coordinator-reduce local execution exports
        );
    Ok(sender_ptr)
        // Extract target_partitions before moving session_handle into the closure.
///
/// Updates the effective permit count of a named concurrency gate.
            manager.set_column_index_cache(size_limit as usize);
    n_batches: i64,
    #[cfg(test)]
/// Live-tunable; takes effect on the next try_grow. Java: NativeBridge.setSpillExemptCapBytes(long).
/// The buffer must have capacity for at least `size_of::<DfStatsBuffer>()` bytes (600).
                context_id,
#[no_mangle]
 * The OpenSearch Contributors require contributions made to
    // CoalescePartitionsExec, AggregateExec, ...) inherit the CPU executor
                    Ok(inner) => inner,
    let mgr = get_rt_manager()?;
        ))
    let mgr = get_rt_manager()?;
                    Err(e) => Err(datafusion::error::DataFusionError::Execution(format!(
    if runtime_ptr == 0 {
        return None;
    let plan_bytes = slice::from_raw_parts(plan_ptr, plan_len as usize);
    column_name_ptr: *const u8,
    };
            // synchronously inside the SEARCH-thread FFM call (DatafusionReduceSink.<init>);
        *out_len = bytes.len() as i64;
/// and checks row-group statistics against the range [filter_min, filter_max]
        while std::time::Instant::now() < deadline {
    runtime_ptr: i64,
        return Err(format!(
/// Rust takes ownership; on error the structs are dropped on the Rust side.
/// Row IDs are passed as a direct pointer to i64 values (from BigIntVector's
        .add_files(&file_paths, rt_handle)
    }
#[ffm_safe]
    let schema_ipc = slice::from_raw_parts(schema_ipc_ptr, schema_ipc_len as usize);
    let mgr = get_rt_manager()?;
    input_id_ptr: *const u8,
    let session_handle =
    table_name_ptr: *const u8,
        ))
        )),
    let manager = runtime
    if runtime_ptr == 0 {
    // All four cache types share one enum — the per-cache match below enforces
    // (cpu_executor.spawn requires 'static). Clone the manager Arc twice — once for
    row_ids_count: i64,
    manager
pub unsafe extern "C" fn df_sender_fail(
}
    api::sender_close(sender_ptr);
            Ok(0)
    });
    }
    writer_generations_ptr: *const i64,
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
            *out_ptr = ptr;
        gate_name,
                        "df_execute_with_context: CPU spawn failed: {e:?}"
            crate::can_match::CanMatchResult::Unknown => return Ok(CAN_MATCH_UNKNOWN),
    if runtime_ptr == 0 {
        .custom_cache_manager
    let n = hash_key_indices_len as usize;
    .map_err(|e| e.to_string())
    )
) -> i64 {
            "df_cache_manager_update_size_limit: unsupported cache type: {}",
    Ok(update_concurrency_gate(
            manager
            if policy == CacheEvictionPolicy::Fifo {
) -> i64 {
        let ptr = Box::into_raw(Box::new(session_handle)) as i64;
    table_name_len: i64,
    let rt_manager =
        }
#[no_mangle]
        .block_on(
#[ffm_safe]
    let cpu_for_cross = cpu_executor.clone();
    shard_view_ptr: i64,
    }
///
                        file_path,
        .block_on(crate::task_monitors::plan_setup_monitor().instrument(
    // runtime and do all the work there, leaving the CPU runtime idle.
        array_slice,
pub extern "C" fn df_set_min_target_partitions(value: i64) {
    let elapsed = start.elapsed();
    files_ptr: *const *const u8,
// as `df_execute_query`, so it drains through the existing `df_stream_next` /
    fn send_outcome_maps_sent_to_zero() {
    file_path: &str,
    label: &str,
        &mgr.io_runtime,
    file_size: usize,
    mgr.io_runtime
    eviction_type_ptr: *const u8,
    runtime_ptr: i64,
                query_config,
#[no_mangle]
        .windows(crate::ROW_ID_COLUMN_NAME.len())
use crate::custom_cache_manager::CustomCacheManager;
// ---------------------------------------------------------------------------
#[no_mangle]
    mgr.io_runtime
                    )
    #[test]
                return Err(
#[no_mangle]
        1 => crate::search_stats::inc_single_collector_scan(),
        )
        .map_err(|e| format!("df_create_global_runtime: {}", e))?;
    Ok(written as i64)
                &plan_vec,
/// Order of entries within the buffer is unspecified. Completed and zero-byte
        "fragment_executor" => mgr.cpu_executor().concurrency_gate().clone(),
    size_limit: i64,
    Ok(0)
    fn a_manager_outliving_its_replacement_does_not_clear_the_newer_io_handle() {
#[ffm_safe]
///
/// Variant of `df_register_memtable` for the shard-scan side. Takes a
    let table_path = str_from_raw(table_path_ptr, table_path_len)
    let mut filenames = Vec::with_capacity(files_count as usize);
    input_id_len: i64,
    timed_block_on(
        ))
        ))
}
/// Registers a streaming partition input on the session. Schema is derived by
    }
    // The IO runtime still drives the outer block_on (bridging the synchronous FFI
    runtime_ptr: i64,
    plan_ptr: *const u8,
) -> i64 {
    ))
    crate::memory_guard::set_pool_limit_for_guard(memory_pool_limit);
}
        slice::from_raw_parts(hash_key_indices_ptr, n)
        let ptr = *files_ptr.add(i);
    array_ptrs: *const i64,
        return Err("null string pointer".to_string());
        writer_generations.push(*writer_generations_ptr.add(i));
                    try_store_can_match(
/// `shard_view_ptr` must be 0 or a valid `api::ShardView` pointer; `out_ptr` must point
                        &bytes_vec,
    }
#[ffm_safe]
    // index sort configured; pass an empty Vec. The Java side guarantees
    let mgr = get_rt_manager()?;
        assert!(
            let boxed = bytes.into_boxed_slice();
    Ok(0)
unsafe fn write_out_buffer(
/// # Safety
    let bytes = slice::from_raw_parts(bytes_ptr, bytes_len);
    let file_path = str_from_raw(file_path_ptr, file_path_len)
            file_size,
    if ptr != 0 {
        .as_ref()
/// Sets the memory pool limit at runtime. Takes effect for new allocations only.
    execution_critical_x1000: i64,
        .ok_or_else(|| "df_cache_manager_clear: no cache manager configured".to_string())?;
}
                .to_string(),
    column_name_len: i64,
    if let Some(mgr) = mgr {
    let schema_slice: &[i64] = if n == 0 {
}
        out_len,
    }
            "[blocked-thread] block_on({}) held Java thread for {:?}",
/// Collects all native executor metrics into a caller-provided byte buffer.
                        "df_execute_with_context: CPU spawn failed: {e:?}"
}
    api::sender_fail(sender_ptr, reason);
        }
/// mid-stream failure (e.g. a spill-read error) truncates the partition — turning a silent
/// would give a min/max covering only the part it visited. A too-narrow range lets the
#[no_mangle]
        sort_fields.push(
    shard_view_ptr: i64,
                &mgr_for_inner,
/// injection runs on the same shard-scan session that has the listing-table-backed
            col_names_count
    match folded {
        pack_task_monitor, CacheStatsRepr, DfStatsBuffer, RuntimeMetricsRepr,
            assert_eq!(
    requests_row_ids: u8,
    manager: Option<Arc<RuntimeManager>>,
            assert_eq!(
    file_path_ptr: *const u8,
                        filter_min,
            );
#[no_mangle]
        .ok_or_else(|| "df_cache_manager_add_files_with_store: no cache manager".to_string())?;
                // This blocks the IO thread (and thus the Java search thread),
    let input_id = str_from_raw(input_id_ptr, input_id_len).map_err(|e| {
        "df_fetch_by_row_ids: negative row_ids_count {}",
    let results = manager
        // Same cache-then-ObjectStore fallback as df_can_match.
            str_from_raw(ptr, len)
        .as_any()
    }
    }
        ));
            store,
#[no_mangle]
    }
    let plan_bytes: &[u8] = if plan_len > 0 {
/// Returns the status the FFI entry point reports to Java: always 0, since a gate the node has not
        } else {
            Some(acc) => match acc.merge(file_bounds) {
        .custom_cache_manager
#[ffm_safe]
#[ffm_safe]
) -> i64 {
pub unsafe extern "C" fn df_sender_terminate_early(sender_ptr: i64) {
                fragment_executor_max_before,
        return Ok(CAN_MATCH_UNKNOWN);
/// created via `df_create_local_session` or `df_create_session_context`.
        .get_file_metadata_cache_for_datafusion()?;
#[ffm_safe]
    plan_ptr: *const u8,
    ///
                .map_err(|e| format!("df_cache_manager_remove_files: {}", e))?
/// runtime to acquire poison permits (may need to wait for in-flight
}
        };
                let permit = gate.acquire_many(partition_weight.min(max_p)).await;
/// coordinator skip a shard that really holds a top-N row, so this walks everything.
        )
// ---------------------------------------------------------------------------
/// The caller must free the returned bytes via `df_free_metrics_buf`.
#[no_mangle]
    if size_limit < 0 {
                .instrument(crate::session_context::prepare_partial_plan(handle, bytes)),
        }
                    "execute_local_plan: CPU spawn failed: {e:?}"
pub unsafe extern "C" fn df_create_cache(
    delegated_predicate_count: i32,
    sort_orders_ptr: *const *const u8,
    cache_type_ptr: *const u8,
use datafusion::execution::cache::DefaultFilesMetadataCache;
        );
        }
    let session = &mut *(session_ptr as *mut crate::local_executor::LocalSession);
    api::create_global_runtime(memory_pool_limit, cache_manager_ptr, spill_dir, spill_limit)
                context_id,
        cache::CACHE_TYPE_METADATA => {
        .ok_or_else(|| "df_cache_manager_clear_by_type: no cache manager configured".to_string())?;
#[ffm_safe]
    for i in 0..col_names_count as usize {
    let input_id = str_from_raw(input_id_ptr, input_id_len)
        // range would understate it.
/// Identical wiring (channel + `SingleReceiverPartition` + `StreamingTable` registered on the
#[no_mangle]
    /// Validates: Requirements 2.2, 2.4, 2.6
            !col_names_len_ptr.is_null(),
            // gating it would deadlock when the gate is contended because the SEARCH thread
    Ok(0)
}
    ///
        let _ = Box::from_raw(std::slice::from_raw_parts_mut(ptr, len as usize));
/// Returns 0 on success; < 0 is a negated error-string pointer.
    Ok(0)
            "df_fetch_by_row_ids: col_names_len_ptr is null but count={}",
    plan_len: i64,
        return;
    table_name_len: i64,
    spill_dir_len: i64,
#[no_mangle]
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
            bytes.len(),
    #[test]
}
/// built yet and a name it does not know are both "nothing to resize", not caller errors.
/// through the 85% spill gate by spillable consumers so they can finish spilling).
    table_name_ptr: *const u8,
    if use_indexed {
    }))
        }
    partial_plan_len: i64,
    }
    }
#[no_mangle]
        // hold the process-globals lock.
    }
        coordinator_reduce_monitor, plan_setup_monitor, query_execution_monitor,
// Per-query registry top-N snapshot
/// - metadata Foyer: the same ranges promoted via `MetadataCachingStore::put_metadata`
                    .await
/// On success the function returns the sender pointer cast to `i64`. On error it returns
) -> i64 {
    for i in 0..files_count as usize {
    let mgr = get_rt_manager()?;
        let file_size = file_meta.size as usize;
            let out = std::slice::from_raw_parts_mut(out_ptr, SORT_BOUNDS_SLOTS);
    out_ptr: *mut u8,
// `df_stream_close` paths unchanged.
/// column absent, unsupported type, statistics missing, or files disagreeing on type.
    shard_view_ptr: i64,
/// queries to release).
    /// rather than sleeping a fixed interval keeps the test from depending on how loaded the
    io_runtime.spawn(async move {
        runtime
 * compatible open source license.
        row_ids_count >= 0,
        let f_ptr = *sort_fields_ptr.add(i);
/// be drained via `df_stream_next` / `df_stream_close`.
        });
    sender_ptr: i64,
#[no_mangle]
        .as_ref()
/// # Safety
            manager.set_file_metadata_cache(metadata_cache);
    page_index::set_column_index_cache_limit(size_limit as usize);
/// Queries cancelled for less than this duration are not counted in stats.
    // goes. The airtight form has `set_io_handle` hand back a registration token that `Drop`
}
#[no_mangle]
                shard_view_ptr,
                match mgr_for_spawn.cpu_executor().spawn(inner_fut).await {
    use crate::executor::ConcurrencyGate;
#[no_mangle]
        adaptive_budget: pack_adaptive_budget(),
    }
// One FFM call: Java allocates a buffer sized for `N` entries, Rust selects
    let out: &mut [WireQueryMetric] =
#[no_mangle]
    }
    // (RepartitionExec drain, CoalescePartitionsExec, etc.) inherit the CPU executor
            size_limit
//! FFM bridge for DataFusion.
) -> i64 {
pub unsafe extern "C" fn df_close_reader(ptr: i64) {
#[no_mangle]
    crate::memory_guard::set_spill_exempt_cap_bytes(value.max(0) as u64);
#[no_mangle]
/// Cache-miss fallback: read the footer via the shard's ObjectStore.
#[no_mangle]
    input_id_len: i64,
                        session_ptr,
) -> i64 {
/// Java: MethodHandle(JAVA_LONG → JAVA_LONG)
    // 1 = get-by-row-id (`__row_id__ = internal_search_bound`); 2 = seq-no scan
        .ok_or_else(|| "df_cache_manager_add_files: no cache manager configured".to_string())?;
            let result = unsafe { call_update_gate("fragment_executor", new_max) };
}
    let has_row_id = plan_bytes
                        .await
}
    let plan_vec = plan_bytes.to_vec();
#[no_mangle]
/// Returns 0 on success, a non-empty error string (via `ffm_wrap`) only on argument-decode failure.
            "df_fetch_by_row_ids: col_names_ptr is null but count={}",
}
    new_max_permits: u32,
    } else {
        mgr.io_runtime
        "FIFO" => CacheEvictionPolicy::Fifo,
        session_ctx_handle_ptr,
#[ffm_safe]
    schema_ipc_ptr: *const u8,
            label,
        let len = *col_names_len_ptr.add(i);
    let cache_stats = if runtime_ptr != 0 {
                .instrument(session.prepare_final_plan(bytes)),
        writer_generations,
    let result = runtime.block_on(future);
        }
    /// leaves installed is a working manager, which is all any other test needs.
    api::stream_get_schema(stream_ptr).map_err(|e| e.to_string())
        let deadline = std::time::Instant::now() + std::time::Duration::from_secs(1);
        admission_throttle: admission_throttle_x1000 as f64 / 1000.0,
        // Stands in for a query that is still running when the re-init happens.
                context_id,
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
    let mgr = get_rt_manager()?;
    let cpu_executor = mgr.cpu_executor();
#[ffm_safe]
/// status crossing this boundary must be non-negative.
        file_paths.push(
/// Memtable variant of `df_register_partition_stream`: instead of returning a
        let replacement = get_rt_manager().expect("the replacement must be readable");
}
    shard_view_ptr: i64,
            out[2] = if b.has_nulls { 1 } else { 0 };
) -> i64 {
    // (RepartitionExec, CoalescePartitionsExec, AggregateExec) eagerly
}
///
    let array_slice: &[i64] = if n == 0 {
    column_name: &str,
/// trackers are filtered out.
/// - data Foyer: raw footer + page index bytes (via get_ranges populate)
    );
/// Enable or disable the scoped page-index feature.
        match result {
    partial_plan_ptr: *const u8,
#[no_mangle]
use std::sync::Arc;
        col_names_count
                let gate = mgr_for_spawn.cpu_executor().concurrency_gate().clone();
    context_id: i64,
    Ok(0)
const SENDER_SEND_RECEIVER_DROPPED: i64 = 1;
    let table_name = str_from_raw(table_name_ptr, table_name_len)
    reason_ptr: *const u8,
            manager.set_offset_index_cache(size_limit as usize);
#[ffm_safe]
/// final-aggregate half, and stores the result on the handle for later
#[ffm_safe]
            "call should return success even before runtime init"
        let ptr = *files_ptr.add(i);
            .map_err(|e| e.to_string())
/// Warmup: load footer (lightweight) into heap and promote footer + page/offset
    bytes_len: usize,
            !col_names_ptr.is_null(),
fn get_rt_manager() -> Result<Arc<RuntimeManager>, String> {
/// Returns current memory pool limit in bytes.
    // No coordinator-gate acquire here — see df_execute_local_plan for the rationale
    // Copy substrait bytes into an owned Vec so the spawned future can move them
    } else {
    if cap_entries == 0 {
pub unsafe extern "C" fn df_create_reader(
#[inline(always)]
    // which policies are valid for each type.
    api::sender_send(sender_ptr, array_ptr, schema_ptr, mgr.io_runtime.handle())
    let query_config =
        return Ok(0);
/// Shard provably holds no matching row — the only status that prunes.
/// `LocalSession` pointer (returned by `df_create_local_session`) — the M1 broadcast
            .unwrap_or_else(CacheStatsRepr::default)
pub unsafe extern "C" fn df_create_global_runtime(
}
    api::close_reader(ptr);
        "df_cache_manager_update_size_limit: no cache manager configured".to_string()
    Some(crate::can_match::can_match_range_with_metadata(
        _ => Err(format!(
    }
    match cache_type {
        df_init_runtime_manager(1, 1.5, 1.5);
pub unsafe extern "C" fn df_prepare_partial_plan(
    // default connector — remote IO then runs on the wrong pool, but it works. The old order instead
/// Sets the cancellation stats threshold in milliseconds.
        coordinator_multiplier,
        let name = str_from_raw(ptr, len)
// NOTE: On main these are stubs that do nothing — the cache module from PR 1
    // Safety: runtime_ptr must be a valid pointer from df_create_global_runtime
            crate::can_match::CanMatchResult::Yes => return Ok(CAN_MATCH_YES),
        let _globals = crate::test_process_globals::lock();
                wait_for_max_permits(&gate, new_max),
/// buffer with the byte count written through `out_len`. Returns the sender
    substrait_ptr: *const u8,
}
        files_count, success_count
//
    let cached_parquet = entry
}
    // Spawn the resize on the IO runtime. Scale-up completes immediately;
    deleted_doc_filtering_required: u8,
#[ffm_safe]
#[no_mangle]
/// must be a valid pointer returned by [`df_create_global_runtime`].
                }
        assert!(
/// Probe the metadata cache for the file. If present, evaluate can-match in memory.
/// from. A negative status here is dereferenced as that address and segfaults the node. Every
    // (the QTF coordinator-reduce path runs synchronously inside the SEARCH-thread FFM
    }
    #[test]
    let mut sort_fields = Vec::with_capacity(sort_count as usize);
    let mgr_for_inner = Arc::clone(&mgr);
            .map(pack_cache_stats)
        }
        let partition_weight = session_handle.query_config.target_partitions.max(1) as u32;
// ---- Memory pool observability and dynamic limit ----
pub unsafe extern "C" fn df_fetch_by_row_ids(
use native_bridge_common::ffm_safe;
        crate::can_match::can_match_range_via_store(
        .map_err(|e| e.to_string())
    // presents, so a manager can only clear a slot it still owns. `Handle::id()` cannot serve as
            update_concurrency_gate(None, "fragment_executor", 10),
    let input_id = str_from_raw(input_id_ptr, input_id_len)
    cache_manager_ptr: i64,
    api::get_memory_pool_stats(runtime_ptr, out_ptr);
    stream_ptr: i64,
        );
 *
            .block_on(async move {
#[no_mangle]
        );
    assert!(
            manager.update_metadata_cache_limit(new_limit as usize);
                        )
        }
    session_ptr: i64,
            column_name,
        );
    crate::test_process_globals::assert_held("the process-global runtime manager");
            // type is accepted but not forwarded.
    shard_view_ptr: i64,
            op_name, elapsed
    // all the work. The IO runtime still drives the outer `timed_block_on`
    let manager = &mut *(cache_manager_ptr as *mut CustomCacheManager);
        assert_eq!(SENDER_SEND_RECEIVER_DROPPED, 1);
        cache::CACHE_TYPE_COLUMN_INDEX => {
        let published = native_bridge_common::io_runtime::io_handle()
        slice::from_raw_parts_mut(out_ptr as *mut WireQueryMetric, cap_entries as usize);
    /// manager's `Drop` runs only once the last query lets go — after the replacement published its
/// Writes `[min, max, has_nulls, value_kind]` into `out_ptr` (4 caller-allocated i64 slots)
        let f_len = *sort_fields_len_ptr.add(i);
#[no_mangle]
    // Neither order is airtight; this one picks the cheaper failure. Handle readers take the IO-slot
    let mut bytes = Vec::with_capacity(pairs.len() * 16);
//
        .map_err(|e| format!("df_cache_manager_get_memory_by_type: {}", e))?;
    let manager = runtime.custom_cache_manager.as_ref().ok_or_else(|| {
) -> Option<crate::can_match::CanMatchResult> {
    let entry = cache.get(&ObjectPath::from(file_path))?;
pub unsafe extern "C" fn df_cache_manager_get_memory_by_type(
) -> i64 {
            let new_max = initial_max + 4;
        let len = *files_len_ptr.add(i);
}
    hash_key_indices_ptr: *const i32,
            assert_eq!(
                            cpu_for_cross,
}
        drop(outgoing);
    crate::query_tracker::set_cancel_stats_threshold(millis as u64);
        other => {
/// Times a block_on call and logs a warning if it exceeds the threshold.
    files_count: i64,
            // METADATA uses DefaultFilesMetadataCache (has its own LRU); eviction
                has_partial_aggregate != 0,
        return Err(format!("negative string length: {}", len));
    let bytes = api::sql_to_substrait(shard_view_ptr, table_name, sql, runtime_ptr, &mgr)
    )
            dyn opensearch_tiered_storage::tiered_object_store::MetadataCachingStore,
    sort_fields_ptr: *const *const u8,
    let partial_plan = slice::from_raw_parts(partial_plan_ptr, partial_plan_len as usize);
            }
unsafe fn try_cached_sort_bounds(
        assert_eq!(
/// Zero is ignored; negative returns an error.
}
    timed_block_on(
    query_config_ptr: i64,
    let cached_parquet = entry
pub extern "C" fn df_create_custom_cache_manager() -> i64 {
#[ffm_safe]
    runtime_ptr: i64,
    runtime_ptr: i64,
    Ok(0)
    // Pack as parallel little-endian i64 pairs: [array_ptr_0, schema_ptr_0, array_ptr_1, ...]
        df_init_runtime_manager(1, 1.5, 1.5);
}
    let spill_dir = str_from_raw(spill_dir_ptr, spill_dir_len)
        input_array_ptr,
    // Still not fixed: a manager the caller holds another `Arc` to (in-flight queries, on a re-init
        .map_err(|e| e.to_string())
) -> Option<crate::can_match::CanMatchResult> {
        .map_err(|e| e.to_string())
    let rt_manager = get_rt_manager().map_err(|e| format!("df_cache_manager_add_files: {}", e))?;
        }
    }
    file_size: usize,
}
    input_id_len: i64,
        .block_on(
        plan_setup: pack_task_monitor(plan_setup_monitor()),
#[no_mangle]
    let rt_manager = try_get_rt_manager()?;
    let mgr_for_spawn = Arc::clone(&mgr);
pub extern "C" fn df_init_runtime_manager(
#[ffm_safe]
        return Err("df_cache_manager_add_files: null runtime pointer".to_string());
    plan_ptr: *const u8,
///
        df_update_concurrency_gate(gate_name.as_ptr(), gate_name.len() as i64, new_max)
    match handle.get_metrics_json() {
                        &mgr_for_inner,
    );
        // One unreadable file means the shard-wide range is unknown — the other files'
                Err(e) => Err(datafusion::error::DataFusionError::Execution(format!(
) -> i64 {
/// for at least `cap_entries * size_of::<WireQueryMetric>()` bytes.
    out_ptr: *mut u8,
    })
// so `Err(String)` returns are converted into a negated heap-allocated error
pub unsafe extern "C" fn df_get_memory_pool_stats(runtime_ptr: i64, out_ptr: *mut i64) {
    }
                .map_err(|e| format!("df_cache_manager_add_files: {}", e))?
    for i in 0..files_count as usize {
    fn send_outcome_maps_receiver_dropped_to_sentinel() {
    };
#[ffm_safe]
    if shard_view_ptr == 0 {
    let mgr_for_spawn = Arc::clone(&mgr);
}
// wire layout.
    /// Polls until the gate reports `expected` permits, up to one second. The resize runs as a
    out_ptr: *mut u8,
    filter_min: i64,
#[no_mangle]
        .map_err(|e| format!("df_register_memtable: input_id: {}", e))?;
        &mgr,
    str::from_utf8(bytes).map_err(|e| format!("invalid UTF-8: {}", e))
        let file_bounds = try_cached_sort_bounds(runtime_ptr, file_path, column_name)
#[no_mangle]
}
    let mut sort_orders = Vec::with_capacity(sort_count as usize);
    let cache_type = str_from_raw(cache_type_ptr, cache_type_len)
    0
/// Shard may hold a matching row.
    coordinator_multiplier: f64,
                    ))),
        &metadata,
    };
    // capture by value (they are `Copy`).
        &buf as *const DfStatsBuffer as *const u8,
/// Returns 0 on success, non-zero if no metrics are available.
    let path = object_store::path::Path::from(file_path);
    let key_slice: &[i32] = if n == 0 {
        out_ptr,
    let bytes = slice::from_raw_parts(bytes_ptr, bytes_len);
    out_cap: i64,
        api::register_partition_stream(session_ptr, input_id, partial_plan)
    /// A manager that outlives its own replacement must clear nothing. In-flight queries hold
#[no_mangle]
    // before it runs and `SpawnService` sees only a dropped oneshot.
    files_len_ptr: *const i64,
/// Set the byte budget of the process-global scoped ColumnIndex cache.
    match outcome {
    sort_fields_len_ptr: *const i64,
    Ok(0)
    let eviction_type = str_from_raw(eviction_type_ptr, eviction_type_len)
        // isConsumerDone().
    query_config_ptr: i64,
        let file_path = file_meta.location.as_ref();
            crate::session_context::create_session_context_indexed(
/// index bytes to the metadata Foyer tier (never-evict) through the store.
        Some(bytes) => {
    )?;
/// Returns 0 on success; < 0 is a negated error-string pointer.
/// Fetch specific rows by global row ID — QTF fetch phase.
    context_id: i64,
/// success half of the FFM contract. MUST match `NativeBridge.SENDER_SEND_RECEIVER_DROPPED`.
#[no_mangle]
    gate_name: &str,
pub unsafe extern "C" fn df_destroy_custom_cache_manager(ptr: i64) {
}
        let ptr = *col_names_ptr.add(i);
#[no_mangle]
    spill_limit: i64,
            };
pub unsafe extern "C" fn df_register_partition_stream_on_session_context(
    plan_ptr: *const u8,
/// "called before runtime init" branch by passing `None`, instead of clearing the global and
    };
#[no_mangle]
    let manager = runtime
    TOKIO_RUNTIME_MANAGER
        filenames,
/// coordinator-reduce `df_register_partition_stream` uses) instead of the raw producer IPC
                query_config,
    input_id_ptr: *const u8,
        mgr.shutdown();
            assert!(
    })?;
        execution_spill: execution_spill_x1000 as f64 / 1000.0,
    } else {
            str_from_raw(ptr, len)
        .custom_cache_manager
    #[test]
        .map_err(|e| format!("df_cache_manager_add_files_with_store: {}", e))?;
    /// in. The "before runtime init" case (Req 2.6) is reached by passing `None`, not by clearing
/// IPC-encoded schema is written into the caller-allocated `out_ptr/out_cap`
#[ffm_safe]
            ))),
        fragment_executor_gate: pack_partition_gate(mgr.cpu_executor.concurrency_gate()),
        datanode_multiplier,
///
            "df_can_match returned {rc}; negative values are error pointers to Java, not statuses"
    let mgr = get_rt_manager()?;
    }
///
    /// Returns the i64 result (0 = success for the outer call).
    .map_err(|e| e.to_string())?;
pub unsafe extern "C" fn df_execute_local_plan(
    }
pub unsafe extern "C" fn df_free_metrics_buf(ptr: *mut u8, len: i64) {
#[ffm_safe]
                cache_type
        as *const std::sync::Arc<
    /// mid-read on the global, which surfaces as "no runtime manager registered" somewhere else.
/// `SessionContextHandle`, returning the `PartitionStreamSender` pointer), but the table schema
///
            // before concluding that it did not.
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
            })
}
            )
                .to_string(),
    /// error address and dereferenced, which segfaults the whole node rather than failing
    n_batches: i64,
        assert_eq!(
/// racing every other test in the binary that needs it.
/// Maps a send outcome to the `df_sender_send` return code: normal send `0`, dropped receiver
/// is derived from the producer's PARTIAL substrait plan (the SAME derivation the
    context_id: i64,
            crate::can_match::CanMatchResult::No => continue,
    let cache_type = str_from_raw(cache_type_ptr, cache_type_len)
    sort_count: i64,
}
            layout::BUFFER_BYTE_SIZE,
        .map_err(|e| format!("df_create_cache: cache_type: {}", e))?;
#[ffm_safe]
) -> i64 {
// ---- Stats collection ----
    }
            e
/// Returns 0 on success.
        return Err("df_cache_manager_add_files_with_store: null runtime pointer".to_string());
        shard_view_ptr != 0,
    }
    let handle = &mut *(handle_ptr as *mut crate::session_context::SessionContextHandle);
///
// Distributed aggregate: prepare partial/final plans
#[no_mangle]
    let buf = DfStatsBuffer {
pub unsafe extern "C" fn df_get_memory_pool_usage(runtime_ptr: i64) -> i64 {
    }
            str_from_raw(ptr, len)
    if out_cap < 0 || (out_cap as usize) < layout::BUFFER_BYTE_SIZE {
            let stats_cache =
    let mgr_for_spawn = Arc::clone(&mgr);
        &[]
#[no_mangle]
    }
        let ptr = *files_ptr.add(i);
/// file and row-group level, which is right for a boolean "could anything match" but
        // Try cache first, then ObjectStore fallback
            },
    out_len: *mut i64,
    col_names_len_ptr: *const i64,
    };
    if runtime_ptr == 0 {
                .map_err(|e| format!("df_cache_manager_add_files_with_store: {}", e))?
        cpu_runtime,
        2 => crate::search_stats::inc_bitmap_tree_scan(),
/// Returns current memory pool usage in bytes.
    //
    api::set_reduce_target_partitions(value);
    out_len_ptr: *mut i64,
/// execution via `df_execute_with_context`.
        admission_reject: admission_reject_x1000 as f64 / 1000.0,
            ),
    )
    files_count: i64,
///
#[no_mangle]
    /// - "fragment_executor" routes to the DedicatedExecutor's gate (Req 2.2)
    // sortFields.size() == sortOrders.size() (IndexSortConfig validates at index creation),
#[no_mangle]
    let shard_view = &*(shard_view_ptr as *const crate::api::ShardView);
#[ffm_safe]
                            permit,
    plan_len: i64,
/// Writes [usage_bytes, tripped_count] to the output buffer.
    let cache_type = str_from_raw(cache_type_ptr, cache_type_len)
    runtime_ptr: i64,
}
                ))),
unsafe fn try_store_sort_bounds(
                        shard_view_ptr,
    )));
#[ffm_safe]
        // ── Test 1: update before runtime init returns success (Req 2.6) ──
    );
    out_cap: i64,
            "stats buffer too small: need {} but got {}",
pub extern "C" fn df_set_spill_exempt_cap_bytes(value: i64) {
        stream_next_monitor,
            .custom_cache_manager
    for file_meta in files.iter() {
    filter_min: i64,
) -> i64 {
) -> F::Output {
            .map_err(|e| format!("df_fetch_by_row_ids: column name: {}", e))?;
/// Gate names: "fragment_executor" (targets DedicatedExecutor gate).
#[no_mangle]
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
/// Non-erroring accessor; `None` before init / after shutdown.
pub extern "C" fn df_cancel_query(context_id: i64) {
    let column_name = str_from_raw(column_name_ptr, column_name_len)?;
    Ok(0)
    let table_name_owned = table_name.to_string();
}
        "register_memtable schema IPC",
    // Hard FFM-boundary checks (UB risk if violated): pointers must be non-zero before any deref.
const SORT_BOUNDS_SLOTS: usize = 4;
                shard_view_ptr,
use crate::runtime_manager::RuntimeManager;
    partial_plan_len: i64,
    let gate_name = str_from_raw(gate_name_ptr, gate_name_len)
    // with no intervening shutdown) outlives this drop and clears the handle whenever its last clone
            let fragment_executor_gate = mgr.cpu_executor().concurrency_gate().clone();
    let query_config =
                &table_name_owned,
    let query_config =
    mgr.io_runtime
    let store = Arc::clone(&shard_view.store);
        filter_max,
#[no_mangle]
    out_cap: i64,
        return None;
            "df_fetch_by_row_ids: row_ids_ptr is null but count={}",
/// the FFM error sentinel; the bridge layer converts that to a Java exception.
        input_id,
                .unwrap_or_else(|| {
/// # Safety
                // This blocks the IO thread (and thus the Java search thread),
                "FFI call should return success for 'fragment_executor'"
    );
) {
    // directly via the trait, no downcast needed.
                "df_create_cache: unsupported eviction type: {}",
}
                result, 0,
        input_id,
/// `FFI_ArrowArray` / `FFI_ArrowSchema` pair owned by the caller. On success
    }
pub unsafe extern "C" fn df_execute_with_context(
        "register_partition_stream schema IPC",
) -> i64 {
                "df_execute_query: CPU spawn failed: {e:?}"
            0,
                            &plan_vec,
    }
        crate::datafusion_query_config::DatafusionQueryConfig::from_ffm_ptr(query_config_ptr);
    if out_ptr.is_null() {
            out[1] = b.max;
/// (e.g., 700 = 0.70, 850 = 0.85, 950 = 0.95).
    }
    let runtime = &*(runtime_ptr as *const crate::api::DataFusionRuntime);
    /// `Arc<RuntimeManager>` clones, so on a re-init with no intervening shutdown the outgoing
            "df_register_partition_stream_on_session_context_from_partial_plan: input_id: {}",
pub unsafe extern "C" fn df_stream_get_schema(stream_ptr: i64) -> i64 {
                runtime_ptr,
    // Wrap plan setup in `cpu_executor.spawn` so DataFusion operators that
    Ok(0)
            return Err(format!(
    let cache_type = str_from_raw(cache_type_ptr, cache_type_len)
    use datafusion::datasource::physical_plan::parquet::metadata::CachedParquetMetaData;
}
    let start = Instant::now();
    Ok(0)
/// The output FFI structs are heap-allocated by Rust; ownership transfers to Java which
    // lock only, not this guard, so a store built inside this window sees `None` and keeps its
    }
    Ok(api::get_memory_pool_usage(runtime_ptr))
    sql_ptr: *const u8,
    // that token — tokio reuses a runtime's id once that runtime has completed, which is exactly
    crate::memory_guard::set_thresholds(crate::memory_guard::MemoryThresholds {
            crate::task_monitors::plan_setup_monitor()
    column_name: &str,
}
/// Deliberately 2, not -1: `#[ffm_safe]` returns `Err` as a *negated error pointer*, so Java's
        crate::task_monitors::coordinator_reduce_monitor().instrument(async move {
) -> Option<crate::can_match::Bounds> {
}
    runtime_ptr: i64,
                plan_bytes,
    let n = n_batches as usize;
pub unsafe extern "C" fn df_register_partition_stream_on_session_context_from_partial_plan(
        return Err("df_cache_manager_contains_by_type: null runtime pointer".to_string());
                        filter_max,
}
    store_ptr: i64,
        .as_ref()?
            api::execute_query(
/// ERROR rather than a clean EOF), then drops the sender. Used by the Java shuffle drain thread when a
        search_stats: crate::search_stats::snapshot(),
    if ptr.is_null() {
    let entry = cache.get(&ObjectPath::from(file_path))?;
        slice::from_raw_parts(plan_ptr, plan_len as usize)
        // Must surface the sentinel, not collapse to 0 like a normal send, or Java never latches
    /// the query. A null shard view is the cheapest way to reach a non-match status without
///
            // A negative assertion: give a resize that must not have been spawned time to land
    manager.clear_all();
        let mgr = get_rt_manager().expect("runtime should be initialized");
    };
            RuntimeMetricsRepr::zeroed()
unsafe fn str_from_raw<'a>(ptr: *const u8, len: i64) -> Result<&'a str, String> {
            // No coordinator-gate acquire here. The QTF coordinator-reduce code path runs
        .map_err(|e| e.to_string())
    op_name: &str,
    // scale-down may need to wait for permits to become available.
    }
    })?;
            })
        .as_ref()
use parking_lot::RwLock;
    datanode_multiplier: f64,
#[ffm_safe]
        assert!(
        )
                gate.max_permits()
        slice::from_raw_parts(schema_ptrs, n)
    std::ptr::copy_nonoverlapping(bytes.as_ptr(), out_ptr, bytes.len());
    mgr.io_runtime
        let result =
/// (e.g. `sum_qty`) rather than the producer's physical state names (e.g. `sum_qty[sum]`), so
pub(crate) fn try_get_rt_manager() -> Option<Arc<RuntimeManager>> {
    let mgr = TOKIO_RUNTIME_MANAGER.write().take();
    out_ptr: *mut *const u8,
        .map_err(|e| format!("df_cache_manager_clear_by_type: {}", e))?;
                None => return Ok(0),
    out_ptr: *mut i64,
        out_ptr,
    plan_len: i64,
        assert!(
use crate::cache;
        partial_plan,
    tree_shape: i32,
            .or_else(|| try_store_sort_bounds(shard_view_ptr, file_path, column_name, file_size));
        .map_err(|e| format!("df_cache_manager_get_memory_by_type: {}", e))?;
    let shard_view = &*(shard_view_ptr as *const api::ShardView);
    schema_ptrs: *const i64,
    Ok(manager.get_total_memory_consumed() as i64)
    let manager = runtime.custom_cache_manager.as_ref().ok_or_else(|| {
    api::set_min_target_partitions(value);
    let plan_bytes: &[u8] = if plan_len > 0 {
    api::register_memtable_on_session_context(
        });
/// `session_ptr` must be a valid pointer returned by `df_create_local_session`
    }
        "df_cache_manager_contains_by_type: no cache manager configured".to_string()
#[no_mangle]
}
#[ffm_safe]
    input_array_ptr: i64,
    };
                    "df_create_cache: STATISTICS cache does not support FIFO eviction".to_string(),
        slice::from_raw_parts(plan_ptr, plan_len as usize)
    if elapsed > BLOCK_ON_LOG_THRESHOLD {
        .add_files_with_store(&file_paths, store, rt_handle)
    TOKIO_RUNTIME_MANAGER.read().clone()
/// Copies `bytes` into a caller-allocated `(out_ptr, out_cap)` buffer and writes
/// Scale-up is synchronous. Scale-down spawns an async task on the IO
    filter_max: i64,
/// - `runtime_ptr` must be a valid pointer from `df_create_global_runtime`.
    // closure to call `cpu_executor().spawn`.
}
    input_id_ptr: *const u8,
        let file_size = file_meta.size as usize;
    let cpu_runtime = if let Some(ref cpu_mon) = mgr.cpu_monitor {
            .expect("a live runtime manager must leave its IO handle published");
        folded = Some(match folded {
    out_ptr: *mut u8,
    }
        None => Ok(0),
                eviction_type
    runtime_ptr: i64,
) -> i64 {
}
pub unsafe extern "C" fn df_sender_close(sender_ptr: i64) {
    // CPU runtime (optional — zeroed when absent)
    })?;
pub unsafe extern "C" fn df_register_partition_stream(
        ));
                    });
pub unsafe extern "C" fn df_set_memory_pool_limit(runtime_ptr: i64, new_limit: i64) -> i64 {
        let installed = get_rt_manager().expect("the manager just installed must be readable");
            "a superseded manager must not clear the live manager's handle"
    if len < 0 {
///
#[no_mangle]
    if !out_len.is_null() {
/// `session_ptr` must be a valid pointer returned by `df_create_local_session`.
    }
    api::close_global_runtime(ptr);
    let bytes_vec = slice::from_raw_parts(substrait_ptr, substrait_len as usize).to_vec();
        return 0;
    /// task on the IO runtime, so it is not observable the instant the call returns; polling
///
            "the published handle must be the live manager's, not one from a torn-down runtime"
                let inner_fut =
#[ffm_safe]
        &[]
) -> Result<(), String> {
        out_cap,
    table_path_ptr: *const u8,
    cache_type_ptr: *const u8,
    }
            let initial_max = gate.max_permits();
        key_slice,
        1
    if runtime_ptr == 0 {
        out_ptr,
    .map(|_| 0)
            );
    // the inner future to access the runtime env / etc., once for the outer block_on
    use super::*;
        }
    assert!(
        CacheStatsRepr::default()
    // Copy the plan bytes so the spawned future can own them (`cpu_executor.spawn`
            ))
/// Java: MethodHandle(JAVA_LONG → JAVA_LONG)
    .map_err(|e| e.to_string())
        let len = *files_len_ptr.add(i);
    let manager = runtime
                        None,
        .map_err(|e| format!("df_create_session_context_indexed: {}", e))?;
    table_path_len: i64,
use std::str;
        let outgoing = get_rt_manager().expect("the manager just installed must be readable");
        return None;
        let _globals = crate::test_process_globals::lock();
/// `current_bytes` desc) as `WireQueryMetric`s into the caller-provided buffer.
    api::register_partition_stream_on_session_context(session_ctx_handle_ptr, input_id, schema_ipc)
            .map_err(|e| e.to_string())?;
    use crate::stats::{
                    api::execute_local_plan(
        format!(
#[no_mangle]
// ---------------------------------------------------------------------------
#[no_mangle]
                    crate::task_monitors::query_execution_monitor().instrument(async move {
    files_ptr: *const *const u8,
///
/// streaming input on the shard-scan session under `input_id` and returns the producer-side
            try_cached_can_match(runtime_ptr, file_path, column_name, filter_min, filter_max)
            let fragment_executor_max_before = fragment_executor_gate.max_permits();
use crate::datafusion_query_config::InternalSearch;
            );
    }
        assert_eq!(
    partial_plan_ptr: *const u8,
    unsafe fn call_update_gate(gate_name: &str, new_max: u32) -> i64 {
    let mut folded: Option<crate::can_match::Bounds> = None;
#[no_mangle]
    }
        return Err("null runtime pointer".to_string());
    admission_throttle_x1000: i64,
#[no_mangle]
    out_len: *mut i64,
/// Returns memory pool stats (usage + tripped count) in a single call.
// to the process-global caches in crate::cache::page_index.
    let (sender_ptr, schema_ipc) =
        .map_err(|e| format!("df_register_partition_stream: input_id: {}", e))?;
/// the Java caller only supplies the file paths.
/// - `store_ptr` must be a valid `Box<Arc<dyn MetadataCachingStore>>` pointer (produced by
    if runtime_ptr == 0 {
        let replacement_handle = replacement.io_runtime.handle().clone();
                unsafe {
            // is blocked waiting for permits its own work would release. Keep the gate
}
    }
            out_cap
        return Err(format!(
pub unsafe extern "C" fn df_shard_sort_bounds(
#[cfg(test)]
            manager.set_statistics_cache(stats_cache);
        .any(|w| w == crate::ROW_ID_COLUMN_NAME.as_bytes());
    runtime_ptr: i64,
    let column_name = str_from_raw(column_name_ptr, column_name_len)?;
                requests_row_ids != 0,
                .to_string(),
    bytes_len: usize,
    std::ptr::copy_nonoverlapping(
    api::stream_close(stream_ptr);
    fn test_ffi_gate_routing() {
        return Err("null runtime pointer".to_string());
#[no_mangle]
    query_config_ptr: i64,
            send_outcome_to_code(SendOutcome::ReceiverDropped),
        table_path,
    Ok(CAN_MATCH_NO)
            ),
    native_bridge_common::log_info!(
    )
    api::close_local_session(ptr);
        get_rt_manager().map_err(|e| format!("df_cache_manager_add_files_with_store: {}", e))?;
#[ffm_safe]
}
        out_cap,
        .as_ref()
        .custom_cache_manager
pub extern "C" fn df_set_scoped_page_index_enabled(enabled: i64) -> i64 {
// returned by `df_execute_local_plan` is the same `QueryStreamHandle` shape
    if bytes.len() > out_cap as usize {
    /// whether to put their HTTP IO on this runtime, so they would silently fall back.
pub unsafe extern "C" fn df_cache_manager_clear_by_type(
    let sql =
                let max_p = gate.max_permits();
/// Prepares a final-aggregate physical plan on a local session.
            out[0] = b.min;
    )?;
            SENDER_SEND_RECEIVER_DROPPED
                            permit,
    // always runs in the indexed executor.
    Ok(api::get_memory_pool_limit(runtime_ptr))
fn update_concurrency_gate(
    input_schema_ptr: i64,
}
        .await
        let ptr = *files_ptr.add(i);
        ));
) -> i64 {
pub unsafe extern "C" fn df_close_local_session(ptr: i64) {
                query_config,
    let path = object_store::path::Path::from(file_path);
        return Err("df_cache_manager_remove_files: null runtime pointer".to_string());
        io_runtime,
///
    }
                .map_err(|e| format!("df_create_reader: sort_order[{}]: {}", i, e))?
/// Writes the pointer to allocated bytes into `out_ptr` and the length into `out_len_ptr`.
    future: F,
        );
    }
    let metadata = cached_parquet.parquet_metadata();
    out_cap: i64,
) -> i64 {
    internal_search_bound: i64,
/// M3 hash-shuffle AGGREGATE worker variant of `df_register_partition_stream_on_session_context`.
    substrait_len: i64,
        return -1;
    // Wrap plan setup in cpu_executor.spawn so internal DataFusion spawns
    partial_plan_len: i64,
        .as_any()
    out_len: *mut i64,
        let o_ptr = *sort_orders_ptr.add(i);
///
 * SPDX-License-Identifier: Apache-2.0
) -> i64 {
        .map_err(|e| e.to_string())
/// this entry; the per-batch feed reuses the existing `df_sender_send` / `df_sender_close`
        .map_err(|e| e.to_string())
/// Shard-wide min/max of one column, for coordinator-side shard ordering.
pub extern "C" fn df_set_memory_guard_thresholds(
    #[test]
            Err(e) => Err(datafusion::error::DataFusionError::Execution(format!(
    let policy = match eviction_type.to_uppercase().as_str() {
    }
    for i in 0..files_count as usize {
    schema_ipc_ptr: *const u8,
        return Err(format!(
    });
pub const CAN_MATCH_YES: i64 = 1;
/// Layout: [min, max, has_nulls, value_kind]. Mirrored by `NativeBridge.SORT_BOUNDS_SLOTS`.
) -> i64 {
    }
#[no_mangle]
    let success_count = results.iter().filter(|(_, ok)| *ok).count();
    // (bridging the synchronous FFM call to the async spawn handle); only
        let partition_weight = session_handle.query_config.target_partitions.max(1) as u32;
    out_cap: i64,
/// Sets memory guard thresholds. Values are thresholds multiplied by 1000
                "df_create_cache: invalid cache type: {}",
    mgr.io_runtime
    use crate::task_monitors::{
        return Err("df_cache_manager_clear: null runtime pointer".to_string());
// Close functions are infallible and do not use the macro. The output stream
/// - `files_ptr[i]` must point to `files_len_ptr[i]` valid UTF-8 bytes.
// These are wired from Java at startup (CacheUtils.createCacheConfig) and on
        // The query finishes and releases the old manager, running its Drop last.
    col_names_ptr: *const *const u8,
    context_id: i64,
}
    // held live by the caller for the duration of the FFM downcall — safe to
    if !ptr.is_null() && len > 0 {
    use crate::query_tracker::{snapshot_top_n_by_current, WireQueryMetric};
}
/// Sets the spill-exemption cap in bytes (the total in-flight allocation allowed
pub unsafe extern "C" fn df_cache_manager_remove_files(
    files_count: i64,
        .remove_files(&file_paths)
// ── Scoped page-index cache limit setters ────────────────────────────────────
/// Returns the number of entries actually written.
use std::slice;
    memory_pool_limit: i64,
    runtime_ptr: i64,
            }
    let mgr = get_rt_manager()?;
    cache_manager_ptr: i64,
    cache_type_len: i64,
        mgr.io_runtime
    file_path: &str,
    use object_store::path::Path as ObjectPath;
}
) -> i64 {
    let query_config =
        slice::from_raw_parts(schema_ptrs, n)
    let rt_handle = rt_manager.io_runtime.handle();
#[ffm_safe]
/// execution via `df_execute_local_prepared_plan`.
    let schema_ipc = slice::from_raw_parts(schema_ipc_ptr, schema_ipc_len as usize);
    deleted_doc_filtering_required: u8,
    runtime_ptr: i64,
    // when the stale `Drop` runs.
// ---------------------------------------------------------------------------
    crate::can_match::sort_bounds_with_metadata(&metadata, column_name)
#[no_mangle]
    }
    } else {
}
                        column_name,
            "df_register_partition_stream_on_session_context: input_id: {}",
    let mgr = get_rt_manager()?;
            warn!("df_update_concurrency_gate: unknown gate '{}'", other);
        cache::CACHE_TYPE_OFFSET_INDEX => {
    }
    let reason = str_from_raw(reason_ptr, reason_len)
/// # Safety
    Ok(0)
    rt_manager.io_runtime.block_on(async {
) -> i64 {
        crate::test_process_globals::install_runtime_manager();
            filter_max,
    }
///
    )?;
    write_out_buffer(
/// Decodes the Substrait bytes, converts to a physical plan, strips the
            "df_set_column_index_cache_limit: negative limit {}",
            .expect("the replacement's handle must survive the outgoing manager's teardown");
    } else {
        row_ids_count
    Some(rt_manager.io_runtime.block_on(async {
        .custom_cache_manager
        &[]
        return Err("df_cache_manager_update_size_limit: null runtime pointer".to_string());
            let result = unsafe { call_update_gate("unknown_gate", 99) };
/// Safety: `out_ptr` must be non-null, 8-byte aligned, and point to storage
static TOKIO_RUNTIME_MANAGER: RwLock<Option<Arc<RuntimeManager>>> = RwLock::new(None);
    filter_max: i64,
}
    /// - Unknown gate name logs warning and returns success (Req 2.4)
                .map_err(|e| format!("df_create_reader: {}", e))?
    Ok(0)
                }
pub unsafe extern "C" fn df_sql_to_substrait(
                .map_err(|e| format!("df_cache_manager_update_size_limit: {}", e))?;
        {
    // Log summary
/// `SessionContextHandle` pointer (returned by `df_create_session_context`) instead of a
#[ffm_safe]
    // Zero-copy read from BigIntVector's direct buffer
                let inner_fut =
///
/// - file_metadata_cache (heap): lightweight ParquetMetaData (footer only, no page indexes)
pub const CAN_MATCH_NO: i64 = 0;
/// FFM exports because `PartitionStreamSender` is the same type whether the session was
    /// `#[ffm_safe]` reserves negative returns for negated error pointers, so every status
    }
        .ok_or_else(|| "Runtime manager not initialized".to_string())
    session_ctx_handle_ptr: i64,
    // call and gating it can deadlock).
        ));
    drop(guard.take());
/// Executes the previously prepared final-aggregate plan on a local session.
pub unsafe extern "C" fn df_close_global_runtime(ptr: i64) {
) {
/// already-exported Arrow C Data batches in two parallel pointer arrays and
    shard_view_ptr: i64,
}
/// `array_ptrs` and `schema_ptrs` must each point to an `n`-element array of
    if runtime_ptr == 0 {
        if let Some(cpu_handle) = mgr.cpu_executor.handle() {
}
    out_len: *mut i64,
pub unsafe extern "C" fn df_cache_manager_add_files(
    row_ids_ptr: i64,
                        )
    fn reinitialising_the_runtime_manager_leaves_its_io_handle_published() {
    sort_orders_len_ptr: *const i64,
                        crate::indexed_executor::execute_indexed_with_context(
    /// Covers:
    if runtime_ptr == 0 {
        &bytes,
}
#[no_mangle]
///
mod tests {
    .map_err(|e| e.to_string())
    *guard = Some(Arc::new(RuntimeManager::new(
pub unsafe extern "C" fn df_get_memory_pool_limit(runtime_ptr: i64) -> i64 {
/// On success returns the sender pointer cast to `i64`; on error returns the FFM error sentinel.
            rc >= 0,
        ));
    } else {
        filter_min,
) -> Option<crate::can_match::Bounds> {
    })?;
    internal_search_mode: i64,
                "FFI call should return success even for unknown gate"
                    .unwrap_or(crate::can_match::CanMatchResult::Unknown)
    /// - Calling update before runtime init returns success (Req 2.6)
        slice::from_raw_parts(array_ptrs, n)
            "{} size {} exceeds buffer capacity {}",
        .map(send_outcome_to_code)
                return true;
                }
                runtime_ptr,
