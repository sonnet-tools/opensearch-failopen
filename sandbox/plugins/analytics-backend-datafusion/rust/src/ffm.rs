/// Prepares a final-aggregate physical plan on a local session.
        .downcast_ref::<CachedParquetMetaData>()?;
    row_ids_count: i64,
        );
    let rt_manager = get_rt_manager().map_err(|e| format!("df_cache_manager_add_files: {}", e))?;
    let array_slice: &[i64] = if n == 0 {
static TOKIO_RUNTIME_MANAGER: RwLock<Option<Arc<RuntimeManager>>> = RwLock::new(None);
    out_ptr: *mut i64,
    };
        .map(send_outcome_to_code)
/// Warmup: load footer (lightweight) into heap and promote footer + page/offset
        assert!(
    /// so building the replacement before retiring the old one ends with a live manager and an
/// Java: NativeBridge.updateConcurrencyGate(String, int)
}
            ))
        // Stands in for a query that is still running when the re-init happens.
    }
        input_id,
    for i in 0..col_names_count as usize {
/// queries to release).
}
    // Route based on whether the session was configured for indexed execution,
use log::warn;
    let entry = cache.get(&ObjectPath::from(file_path))?;
) -> i64 {
            Ok(0)
        let f_ptr = *sort_fields_ptr.add(i);
    }
//! FFM bridge for DataFusion.
    let mut writer_generations = Vec::with_capacity(files_count as usize);
        slice::from_raw_parts(row_ids_ptr as *const i64, row_ids_count as usize).to_vec();
) -> i64 {
    // Copy struct bytes to caller buffer
        store_ptr,
    // The IO runtime still drives the outer block_on (bridging the synchronous FFI
        // TODO: refactor execute_indexed_with_context to take SessionContextHandle directly
/// Zero is ignored; negative returns an error.
    // Hard FFM-boundary checks (UB risk if violated): pointers must be non-zero before any deref.
use crate::api::DataFusionRuntime;
    bytes_len: usize,
/// Sets the memory pool limit at runtime. Takes effect for new allocations only.
        }),
    let cached_parquet = entry
}
        cache::CACHE_TYPE_OFFSET_INDEX => {
unsafe fn str_from_raw<'a>(ptr: *const u8, len: i64) -> Result<&'a str, String> {
        let deadline = std::time::Instant::now() + std::time::Duration::from_secs(1);
    input_id_ptr: *const u8,
pub extern "C" fn df_clear_scoped_page_index_cache() -> i64 {
        *Box::from_raw(session_ctx_ptr as *mut crate::session_context::SessionContextHandle);
        layout, pack_adaptive_budget, pack_cache_stats, pack_partition_gate, pack_runtime_metrics,
    session_ctx_ptr: i64,
        df_init_runtime_manager(1, 1.5, 1.5);
///
        str_from_raw(sql_ptr, sql_len).map_err(|e| format!("df_sql_to_substrait: sql: {}", e))?;
            out_cap
use crate::cache::page_index;
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
        key_slice,
            str_from_raw(ptr, len)
                table_name,
            crate::can_match::CanMatchResult::Unknown => return Ok(CAN_MATCH_UNKNOWN),
        .clone()
        let outgoing = get_rt_manager().expect("the manager just installed must be readable");
    input_id_ptr: *const u8,
                return true;
/// mid-stream failure (e.g. a spill-read error) truncates the partition — turning a silent
    );
) -> i64 {
#[ffm_safe]
/// `current_bytes` desc) as `WireQueryMetric`s into the caller-provided buffer.
    let table_path = str_from_raw(table_path_ptr, table_path_len)
pub extern "C" fn df_init_runtime_manager(
        {
#[ffm_safe]
    column_name: &str,
    let mgr_for_spawn = Arc::clone(&mgr);
    cache_type_len: i64,
            out[3] = b.value_kind as i64;
    // once the new one has published leaves a live manager with no handle registered — and the
    input_id_len: i64,
///
    Ok(())
/// Java: MethodHandle(JAVA_LONG, JAVA_LONG → JAVA_LONG)
        let _globals = crate::test_process_globals::lock();
        sort_orders,
/// Row IDs are passed as a direct pointer to i64 values (from BigIntVector's
    cache_manager_ptr: i64,
    gate_name_len: i64,
        sort_orders.push(
    runtime_ptr: i64,
    let store = Arc::clone(&shard_view.store);
    // Always-on `assert!` (not debug_assert!) — these protect against use-after-close from Java.
        .block_on(crate::task_monitors::plan_setup_monitor().instrument(
    file_path: &str,
        coordinator_multiplier,
    }
            "[blocked-thread] block_on({}) held Java thread for {:?}",
        format!(
) -> Option<crate::can_match::Bounds> {
        &mgr.io_runtime,
    files_len_ptr: *const i64,
    } else {
        cache::CACHE_TYPE_METADATA => {
                // This blocks the IO thread (and thus the Java search thread),
}
/// would give a min/max covering only the part it visited. A too-narrow range lets the
/// buffer with the byte count written through `out_len`. Returns the sender
    )
    if use_indexed {
) -> i64 {
                match mgr_for_spawn.cpu_executor().spawn(inner_fut).await {
            &path,
        return Err(format!(
/// Sets the spill-exemption cap in bytes (the total in-flight allocation allowed
    };
    api::register_memtable_on_session_context(
#[no_mangle]
        .map_err(|e| format!("df_register_partition_stream: input_id: {}", e))?;
    // when the stale `Drop` runs.
        array_slice,
}
        out_ptr,
        assert_eq!(send_outcome_to_code(SendOutcome::Sent), 0);
/// through the 85% spill gate by spillable consumers so they can finish spilling).
                query_config,
    }
    })?;
        .as_ref()?
}
                    Ok(inner) => inner,
            label,
                .update_statistics_cache_limit(new_limit as usize)
        row_ids_count
    }
    let manager = runtime
    let Some(mgr) = manager else {
    .map_err(|e| e.to_string())
    // async work in `cpu_executor.spawn`. In short: DataFusion operators
#[no_mangle]
    runtime_ptr: i64,
    plan_len: i64,
    if ptr != 0 {
/// Returns memory pool stats (usage + tripped count) in a single call.
        return Err(format!("negative capacity: {cap_entries}"));
pub unsafe extern "C" fn df_execute_query(
/// "called before runtime init" branch by passing `None`, instead of clearing the global and
        .get_file_metadata_cache_for_datafusion()?;
    };
        io_runtime,
        let ptr = *files_ptr.add(i);
) -> i64 {
                        None,
// Distributed aggregate: prepare partial/final plans
        return Ok(0);
        filenames.push(
                        file_size,
#[no_mangle]
pub unsafe extern "C" fn df_register_memtable(
        out_ptr,
    sender_ptr: i64,
    sort_fields_len_ptr: *const i64,
        assert!(
                runtime_ptr,
            str_from_raw(o_ptr, o_len)
mod tests {
        // hold the process-globals lock.
}
}
) -> i64 {
/// Identical wiring (channel + `SingleReceiverPartition` + `StreamingTable` registered on the
        0
        while std::time::Instant::now() < deadline {
}
            crate::task_monitors::plan_setup_monitor()
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
            crate::can_match::CanMatchResult::Yes => return Ok(CAN_MATCH_YES),
    mgr.io_runtime
/// Fold bounds from the metadata cache if the file is present there.
        {
unsafe fn try_store_sort_bounds(
    // Engine-internal point lookup. 0 = normal query (decode `plan_ptr` as Substrait);
        schema_slice,
    sort_orders_len_ptr: *const i64,
                            session_handle,
                context_id,
fn get_rt_manager() -> Result<Arc<RuntimeManager>, String> {
            file_size,
    table_name_len: i64,
/// FFM exports because `PartitionStreamSender` is the same type whether the session was
    let schema_ipc = slice::from_raw_parts(schema_ipc_ptr, schema_ipc_len as usize);
    let mgr = get_rt_manager()?;
    let cache = runtime
    files_count: i64,
    sort_fields_ptr: *const *const u8,
#[no_mangle]
                let permit = gate.acquire_many(partition_weight.min(max_p)).await;
            crate::can_match::CanMatchResult::No => continue,
    plan_len: i64,
/// Decodes the Substrait bytes, converts to a physical plan, strips the
    let store_box = &*(store_ptr
    session_ptr: i64,
}
/// On success the function returns the sender pointer cast to `i64`. On error it returns
    }
    rt_manager.io_runtime.block_on(async {
    runtime_ptr: i64,
use crate::runtime_manager::RuntimeManager;
#[no_mangle]
    // (cpu_executor.spawn requires 'static). Clone the manager Arc twice — once for
                has_partial_aggregate != 0,
        .map_err(|e| e.to_string())?;
        // The query finishes and releases the old manager, running its Drop last.
    }
                tree_shape,
    // Pack as parallel little-endian i64 pairs: [array_ptr_0, schema_ptr_0, array_ptr_1, ...]
    context_id: i64,
    if size_limit < 0 {
use crate::statistics_cache::CustomStatisticsCache;
            .expect("a live runtime manager must leave its IO handle published");
        "register_memtable schema IPC",
    files_ptr: *const *const u8,
        return Err(format!(
///
/// and checks row-group statistics against the range [filter_min, filter_max]
    Ok(size as i64)
        let len = *files_len_ptr.add(i);
        col_names_count
    // directly via the trait, no downcast needed.
    eviction_type_len: i64,
            Some(acc) => match acc.merge(file_bounds) {
/// runtime to acquire poison permits (may need to wait for in-flight
/// Updates the effective permit count of a named concurrency gate.
use std::sync::Arc;
#[no_mangle]
                        "df_execute_with_context: CPU spawn failed: {e:?}"
/// Fetch specific rows by global row ID — QTF fetch phase.
pub unsafe extern "C" fn df_sql_to_substrait(
    // See `df_execute_query` for the rationale behind wrapping the inner
#[no_mangle]
    let shard_view = &*(shard_view_ptr as *const api::ShardView);
        crate::datafusion_query_config::DatafusionQueryConfig::from_ffm_ptr(query_config_ptr);
    }
            let stats_cache =
/// probe scan registered, so the memtable lives alongside that table.
    input_id_len: i64,
    api::sender_terminate_early(sender_ptr);
    context_id: i64,
/// Collects all native executor metrics into a caller-provided byte buffer.
}
            "df_set_column_index_cache_limit: negative limit {}",
    bytes_len: usize,
        .map_err(|e| format!("df_cache_manager_add_files: {}", e))?;
}
#[no_mangle]
        search_stats: crate::search_stats::snapshot(),
        .custom_cache_manager
/// the worker FINAL's by-name `base_schema` binding resolves. See
    #[test]
        let _globals = crate::test_process_globals::lock();
/// Sets memory guard thresholds. Values are thresholds multiplied by 1000
/// final-aggregate half, and stores the result on the handle for later
            // synchronously inside the SEARCH-thread FFM call (DatafusionReduceSink.<init>);
use crate::api;
    Ok(api::get_memory_pool_limit(runtime_ptr))
            *out_ptr = ptr;
}
///
    manager
/// success half of the FFM contract. MUST match `NativeBridge.SENDER_SEND_RECEIVER_DROPPED`.
        );
    let manager = CustomCacheManager::new();
    } else {
        .clear_cache_type(cache_type)
    }
}
            try_cached_can_match(runtime_ptr, file_path, column_name, filter_min, filter_max)
/// Java: MethodHandle(JAVA_LONG → JAVA_LONG)
                // Acquire datanode gate on IO runtime BEFORE spawning on CPU.
        execution_spill: execution_spill_x1000 as f64 / 1000.0,
        .map_err(|e| e.to_string())
    let mgr = get_rt_manager()?;
/// `LocalSession` pointer (returned by `df_create_local_session`) — the M1 broadcast
                eviction_type
    if runtime_ptr == 0 {
        return Err(format!(
    context_id: i64,
    let manager = runtime
            str_from_raw(f_ptr, f_len)
        let ptr = *files_ptr.add(i);
/// and returns 1. Returns 0 with `out_ptr` untouched when no shard-wide bound exists —
    }
    let size = manager
    n_batches: i64,
        }
    }
/// than read from `TOKIO_RUNTIME_MANAGER`. Taking it as an argument is what lets a test reach the
    internal_search_mode: i64,
    }
    let cache_stats = if runtime_ptr != 0 {
    /// error address and dereferenced, which segfaults the whole node rather than failing
    );
    let query_config =
    let schema_ipc = api::register_memtable(
    fn send_outcome_maps_sent_to_zero() {
    /// A manager that outlives its own replacement must clear nothing. In-flight queries hold
                        .await
    let partial_plan = slice::from_raw_parts(partial_plan_ptr, partial_plan_len as usize);
        df_init_runtime_manager(1, 1.5, 1.5);
            };
    plan_ptr: *const u8,
pub extern "C" fn df_set_column_index_cache_limit(size_limit: i64) -> i64 {
    api::close_reader(ptr);
        return Err("null snapshot buffer".to_string());
    let schema_slice: &[i64] = if n == 0 {
pub unsafe extern "C" fn df_register_partition_stream_on_session_context_from_partial_plan(
//
        if let Some(cpu_handle) = mgr.cpu_executor.handle() {
}
/// Hash-partitions one Arrow C Data batch into N output batches using DataFusion's
) -> i64 {
    spill_dir_len: i64,
        );
        .add_files_with_store(&file_paths, store, rt_handle)
    file_path: &str,
        "df_fetch_by_row_ids: negative col_names_count {}",
    }
    // presents, so a manager can only clear a slot it still owns. `Handle::id()` cannot serve as
/// trackers are filtered out.
    } else {
#[no_mangle]
        .map_err(|e| e.to_string())?;
        ));
    let query_config =
    plan_ptr: *const u8,
        let mgr = get_rt_manager().expect("runtime should be initialized");
        out_cap,
        ));
) -> Result<(), String> {
        .as_any()
#[no_mangle]
        mgr.shutdown();
    use crate::executor::ConcurrencyGate;
    Ok(0)
pub extern "C" fn df_set_min_target_partitions(value: i64) {
    bytes_ptr: *const u8,
        .map_err(|e| format!("df_create_session_context_indexed: {}", e))?;
    schema_ipc_len: i64,
    if col_names_count > 0 {
//
        let rc = unsafe { df_can_match(0, 0, column.as_ptr(), column.len() as i64, 0, 100) };
    out_ptr: *mut u8,
                    "execute_local_plan: CPU spawn failed: {e:?}"
    if new_limit < 0 {
    }
#[no_mangle]
                fragment_executor_gate.max_permits(),
    let row_ids: Vec<i64> =
    /// Combined test for gate routing, driving [`update_concurrency_gate`] with the manager passed
        assert!(
    })
    admission_reject_x1000: i64,
        let len = *files_len_ptr.add(i);
/// Enable or disable the scoped page-index feature.
    filter_max: i64,
    runtime_ptr: i64,
pub unsafe extern "C" fn df_create_reader(
        stream_next: pack_task_monitor(stream_next_monitor()),
    )
#[no_mangle]
        let _ = Box::from_raw(ptr as *mut CustomCacheManager);
#[no_mangle]
//
        "df_cache_manager_get_memory_by_type: no cache manager configured".to_string()
#[no_mangle]
                let gate = mgr_for_spawn.cpu_executor().concurrency_gate().clone();
        );
pub unsafe extern "C" fn df_create_local_session(runtime_ptr: i64) -> i64 {
        &mgr.io_runtime,
/// `BatchPartitioner` (matches `RepartitionExec` and `HashJoinExec` row-to-partition
/// Returns the number of entries actually written.
    reason_ptr: *const u8,
    input_array_ptr: i64,
        .custom_cache_manager
    out_len: *mut i64,
#[ffm_safe]
        return Err("df_cache_manager_update_size_limit: null runtime pointer".to_string());
/// execution via `df_execute_local_prepared_plan`.
#[no_mangle]
    let entry = cache.get(&ObjectPath::from(file_path))?;
}
///
        return Err("df_cache_manager_contains_by_type: null runtime pointer".to_string());
pub unsafe extern "C" fn df_partition_batch_by_hash(
            str_from_raw(ptr, len)
    runtime_ptr: i64,
pub extern "C" fn df_set_memory_guard_thresholds(
        &[]
}
    runtime_ptr: i64,
            layout::BUFFER_BYTE_SIZE,
// ---------------------------------------------------------------------------
#[ffm_safe]
    let start = Instant::now();
            ),
    if runtime_ptr == 0 {
                            permit,
/// Shard-wide min/max of one column, for coordinator-side shard ordering.
                result, 0,
/// M3 hash-shuffle AGGREGATE worker variant of `df_register_partition_stream_on_session_context`.
    requests_row_ids: u8,
        let ptr = *col_names_ptr.add(i);
    let cache_type = str_from_raw(cache_type_ptr, cache_type_len)
        sort_fields.push(
/// # Safety
                        shard_view_ptr,
    let manager = runtime
                .to_string(),
    plan_ptr: *const u8,
            let inner_fut = async move {
        assert_eq!(
    out_cap: i64,
        "LRU" => CacheEvictionPolicy::Lru,
    api::get_memory_pool_stats(runtime_ptr, out_ptr);
#[no_mangle]
/// `handle_ptr` must be a valid pointer returned by `df_create_session_context`.
    });
}
#[no_mangle]
#[no_mangle]
    session_ptr: i64,
/// Copies up to `cap_entries` of the heaviest live queries (by
unsafe fn write_out_buffer(
    }
        return Err(format!(
        let replacement = get_rt_manager().expect("the replacement must be readable");
    let table_name = str_from_raw(table_name_ptr, table_name_len)
}
        filenames,
            let result = unsafe { call_update_gate("unknown_gate", 99) };
    file_size: usize,
        _ => {
    plan_ptr: *const u8,
    datanode_multiplier: f64,
    // goes. The airtight form has `set_io_handle` hand back a registration token that `Drop`
    fn reinitialising_the_runtime_manager_leaves_its_io_handle_published() {
/// Returns the status the FFI entry point reports to Java: always 0, since a gate the node has not
        return Err("null runtime pointer".to_string());
pub const CAN_MATCH_NO: i64 = 0;
    };
    // CPU runtime (optional — zeroed when absent)
 * this file be licensed under the Apache-2.0 license or a
                        &bytes_vec,
    /// - Calling update before runtime init returns success (Req 2.6)
#[cfg(test)]
        // Same cache-then-ObjectStore fallback as df_can_match.
    let mut bytes = Vec::with_capacity(pairs.len() * 16);
    let n = hash_key_indices_len as usize;
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
    query_config_ptr: i64,
            manager
    };
pub unsafe extern "C" fn df_cache_manager_update_size_limit(
    // (the QTF coordinator-reduce path runs synchronously inside the SEARCH-thread FFM
        return Err("df_cache_manager_remove_files: null runtime pointer".to_string());
        input_id,
/// created via `df_create_local_session` or `df_create_session_context`.
///
    shard_view_ptr: i64,
                has_partial_aggregate != 0,
    files_count: i64,
    op_name: &str,
pub unsafe extern "C" fn df_close_reader(ptr: i64) {
        .custom_cache_manager
}
        .downcast_ref::<CachedParquetMetaData>()?;
            // exclusively on the data-node FFM entry points.
/// Cache-miss fallback: read the footer via the shard's ObjectStore.
}
        }
    input_id_ptr: *const u8,
    /// Helper: call df_update_concurrency_gate with a Rust string.
    // the inner future to access the runtime env / etc., once for the outer block_on
    shard_view_ptr: i64,
    crate::memory_guard::set_thresholds(crate::memory_guard::MemoryThresholds {
    if runtime_ptr == 0 {
                    ))),
    /// published. `RuntimeManager::new` publishes the handle and `RuntimeManager::drop` clears it,
    /// Polls until the gate reports `expected` permits, up to one second. The resize runs as a
// the heaviest live queries by `current_bytes` (bounded min-heap of size N)
}
        )
    let table_name = str_from_raw(table_name_ptr, table_name_len)
    if files.is_empty() {
        &[]
pub unsafe extern "C" fn df_get_memory_pool_limit(runtime_ptr: i64) -> i64 {
    let cpu_executor = mgr.cpu_executor();
            match mgr_for_spawn.cpu_executor().spawn(inner_fut).await {
        array_slice,
/// [`SENDER_SEND_RECEIVER_DROPPED`] so the Java side can latch early-termination.
#[no_mangle]
#[ffm_safe]
///
    let partial_plan = slice::from_raw_parts(partial_plan_ptr, partial_plan_len as usize);
    )
    let mgr = get_rt_manager()?;
#[ffm_safe]
    table_path_len: i64,
#[no_mangle]
            .block_on(async move {
}
    use datafusion::datasource::physical_plan::parquet::metadata::CachedParquetMetaData;
    label: &str,
#[no_mangle]
    api::execute_local_prepared_plan(session_ptr, &mgr, context_id, None).map_err(|e| e.to_string())
        let runtime = &*(runtime_ptr as *const DataFusionRuntime);
#[ffm_safe]
}
        "FIFO" => CacheEvictionPolicy::Fifo,
) -> F::Output {
/// Gate names: "fragment_executor" (targets DedicatedExecutor gate).
/// Copies `bytes` into a caller-allocated `(out_ptr, out_cap)` buffer and writes
    let (sender_ptr, schema_ipc) =
    tree_shape: i32,
    if cap_entries < 0 {
                        )
    files_len_ptr: *const i64,
        &buf as *const DfStatsBuffer as *const u8,
    })?;
    #[test]
            "df_fetch_by_row_ids: row_ids_ptr is null but count={}",
        bytes.extend_from_slice(&s.to_le_bytes());
    let mgr = get_rt_manager()?;
    let bytes = slice::from_raw_parts(ptr, len as usize);
    let query_config =
                "df_create_cache: unsupported eviction type: {}",
}
    runtime_ptr: i64,
        &[]
) -> i64 {
/// Set the byte budget of the process-global scoped ColumnIndex cache.
}
    use crate::stats::{
    if shard_view_ptr == 0 {
        .map_err(|e| format!("df_create_cache: cache_type: {}", e))?;
    }
) -> i64 {
#[ffm_safe]
/// (e.g., 700 = 0.70, 850 = 0.85, 950 = 0.95).
    }
    io_runtime.spawn(async move {
#[ffm_safe]
    }
    if bytes.len() > out_cap as usize {
#[ffm_safe]
            crate::task_monitors::plan_setup_monitor()
                    });
    has_partial_aggregate: u8,
                return Err(format!("df_create_cache: COLUMN_INDEX cache only supports FIFO eviction, got {eviction_type}"));
        );
    let mut folded: Option<crate::can_match::Bounds> = None;
        }
        datanode_multiplier,
        out_cap,
    let mgr = get_rt_manager()?;
            api::execute_query(
}
                let inner_fut =
                    Err(e) => Err(datafusion::error::DataFusionError::Execution(format!(
        .block_on(
                let max_p = gate.max_permits();
    let manager = runtime.custom_cache_manager.as_ref().ok_or_else(|| {
    // Neither order is airtight; this one picks the cheaper failure. Handle readers take the IO-slot
        .map_err(|e| format!("df_cache_manager_clear_by_type: {}", e))?;
) -> i64 {
    write_out_buffer(&bytes, out_ptr, out_cap, out_len, "substrait plan")?;
    // or if the plan projects __row_id__ (QTF query phase). QTF row-id computation
/// Executes the previously prepared final-aggregate plan on a local session.
        df_init_runtime_manager(1, 1.5, 1.5);
        "stream_next",
    use object_store::path::Path as ObjectPath;
    if shard_view_ptr == 0 {
    // with no intervening shutdown) outlives this drop and clears the handle whenever its last clone
/// Shard may hold a matching row.
        out_len,
    }
pub const CAN_MATCH_YES: i64 = 1;
        );
                "fragment_executor gate max_permits should be updated to {}, is {}",
                        file_path,
        .map_err(|e| format!("df_create_session_context: {}", e))?;
        crate::datafusion_query_config::DatafusionQueryConfig::from_ffm_ptr(query_config_ptr);
    }
/// Number of i64 slots `df_shard_sort_bounds` writes into `out_ptr`.
        let len = *col_names_len_ptr.add(i);
        );
        let ptr = *files_ptr.add(i);
    Ok(0)
) -> i64 {
/// to at least `SORT_BOUNDS_SLOTS` writable i64 slots.
        .block_on(crate::task_monitors::plan_setup_monitor().instrument(
}
    for (a, s) in &pairs {
pub unsafe extern "C" fn df_get_memory_pool_usage(runtime_ptr: i64) -> i64 {
                            plan_vec,
) -> i64 {
        return Err("df_cache_manager_clear_by_type: null runtime pointer".to_string());
/// must be a valid pointer returned by [`df_create_global_runtime`].
        .ok_or_else(|| "df_cache_manager_clear_by_type: no cache manager configured".to_string())?;
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
/// must close them via Arrow C Data Interface.
pub unsafe extern "C" fn df_close_global_runtime(ptr: i64) {
/// - `runtime_ptr` must be a valid pointer from `df_create_global_runtime`.
        .map_err(|e| format!("df_cache_manager_get_memory_by_type: {}", e))?;
        .map_err(|e| e.to_string())
            "stats buffer too small: need {} but got {}",
            col_names_count
/// - `files_ptr[i]` must point to `files_len_ptr[i]` valid UTF-8 bytes.
#[ffm_safe]
                unsafe {
        let replacement_handle = replacement.io_runtime.handle().clone();
            send_outcome_to_code(SendOutcome::ReceiverDropped),
        partial_plan,
            out[0] = b.min;
        .ok_or_else(|| "df_cache_manager_clear: no cache manager configured".to_string())?;
///
/// Zero is ignored; negative returns an error.
    let shard_view = &*(shard_view_ptr as *const api::ShardView);
/// When disabled: metadata cache retains full page index (fallback mode).
    deleted_doc_filtering_required: u8,
    // Log summary
) -> i64 {
    if !ptr.is_null() && len > 0 {
                ))),
    }
        .map_err(|e| format!("df_sender_fail: reason: {}", e))?;
    // instead of the IO runtime. Without this wrap those operator drain tasks
        // isConsumerDone().
        filter_max,
}
        let ptr = *files_ptr.add(i);
            row_ids_count
    TOKIO_RUNTIME_MANAGER.read().clone()
    for file_meta in files.iter() {
#[no_mangle]
    for file_meta in files.iter() {
        }
    page_index::set_column_index_cache_limit(size_limit as usize);
    if !out_len.is_null() {
}
                        )
    input_id_len: i64,
        // merge widens the range and ORs has_nulls. None means the files disagree on value
    result
#[ffm_safe]
    };
        .ok_or_else(|| "Runtime manager not initialized".to_string())
            // A negative assertion: give a resize that must not have been spawned time to land
    let table_name = str_from_raw(table_name_ptr, table_name_len)
                Err(e) => Err(datafusion::error::DataFusionError::Execution(format!(
        // Extract target_partitions before moving session_handle into the closure.
    } else {
                    Ok(inner) => inner,
        partition_count,
            .custom_cache_manager
/// Probe the metadata cache for the file. If present, evaluate can-match in memory.
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
    Ok(0)
#[no_mangle]
pub extern "C" fn df_set_offset_index_cache_limit(size_limit: i64) -> i64 {
    .map_err(|e| e.to_string())
/// Set the byte budget of the process-global scoped OffsetIndex cache.
    Ok(0)
    crate::memory_guard::set_spill_exempt_cap_bytes(value.max(0) as u64);
    ))
    let array_slice: &[i64] = if n == 0 {
    let sql =
/// The output FFI structs are heap-allocated by Rust; ownership transfers to Java which
    }
            published.id(),
#[no_mangle]
                    .unwrap_or(crate::can_match::CanMatchResult::Unknown)
        .map_err(|e| format!("df_update_concurrency_gate: {}", e))?;
            .as_ref()
#[no_mangle]
#[no_mangle]
/*
#[ffm_safe]
#[no_mangle]
    input_schema_ptr: i64,
    let cache_type = str_from_raw(cache_type_ptr, cache_type_len)
pub unsafe extern "C" fn df_cache_manager_clear_by_type(
    column_name_ptr: *const u8,
            ),
    schema_ipc_ptr: *const u8,
}
pub extern "C" fn df_set_spill_exempt_cap_bytes(value: i64) {
        );
            "a superseded manager must not clear the live manager's handle"
    api::register_partition_stream_on_session_context_from_partial_plan(
        let file_bounds = try_cached_sort_bounds(runtime_ptr, file_path, column_name)
                // This blocks the IO thread (and thus the Java search thread),
#[ffm_safe]
    /// - Unknown gate name logs warning and returns success (Req 2.4)
    }
    // so a single sort_count covers both arrays.
    // capture by value (they are `Copy`).
// Coordinator-reduce local execution exports
    if elapsed > BLOCK_ON_LOG_THRESHOLD {
            ))),
pub extern "C" fn df_set_scoped_page_index_enabled(enabled: i64) -> i64 {
    new_limit: i64,
    let has_row_id = plan_bytes
    let cpu_runtime = if let Some(ref cpu_mon) = mgr.cpu_monitor {
/// already-exported Arrow C Data batches in two parallel pointer arrays and
        shard_view_ptr != 0,
    /// manager's `Drop` runs only once the last query lets go — after the replacement published its
    file_path: &str,
}
    // Still not fixed: a manager the caller holds another `Arc` to (in-flight queries, on a re-init
    });
}
pub unsafe extern "C" fn df_cache_manager_contains_by_type(
        .map_err(|e| format!("df_create_global_runtime: {}", e))?;
    }
    context_id: i64,
    // instead of the IO runtime. Without this, operator hash work runs on IO workers.
    } else {
        1
        warn!("df_update_concurrency_gate called before runtime init");
        file_paths.push(
        cache::CACHE_TYPE_METADATA => {
        return 0;
    out_ptr: *mut u8,
            if policy != CacheEvictionPolicy::Fifo {
use crate::eviction_policy::CacheEvictionPolicy;
            pack_runtime_metrics(cpu_mon, &cpu_handle)
    }
            .await
                internal_search,
///
            crate::session_context::create_worker_session_context(
            warn!("df_update_concurrency_gate: unknown gate '{}'", other);
            str_from_raw(ptr, len)
    };
) -> i64 {
pub(crate) fn try_get_rt_manager() -> Option<Arc<RuntimeManager>> {
) -> i64 {
    if cap_entries == 0 {
                        crate::indexed_executor::execute_indexed_with_context(
const SORT_BOUNDS_SLOTS: usize = 4;
#[ffm_safe]
                .map_err(|e| format!("df_cache_manager_add_files_with_store: {}", e))?
    let mgr = get_rt_manager()?;
    out_ptr: *mut u8,
}
    fn a_manager_outliving_its_replacement_does_not_clear_the_newer_io_handle() {
    let cpu_for_cross = cpu_executor.clone();
pub unsafe extern "C" fn df_execute_local_plan(
pub unsafe extern "C" fn df_sender_fail(
            let fragment_executor_gate = mgr.cpu_executor().concurrency_gate().clone();
pub unsafe extern "C" fn df_cache_manager_add_files(
                let gate = mgr_for_spawn.cpu_executor().concurrency_gate().clone();
        CacheStatsRepr::default()
    let mgr = get_rt_manager()?;
}
        crate::partition_stream::SendOutcome::ReceiverDropped => SENDER_SEND_RECEIVER_DROPPED,
    let manager = &mut *(cache_manager_ptr as *mut CustomCacheManager);
#[no_mangle]
pub unsafe extern "C" fn df_create_session_context(
/// coordinator-reduce `df_register_partition_stream` uses) instead of the raw producer IPC
        let published = native_bridge_common::io_runtime::io_handle()
            // type is accepted but not forwarded.
    out_ptr: *mut u8,
    let mgr = get_rt_manager()?;
    if runtime_ptr == 0 {
#[ffm_safe]
    }
    table_name_ptr: *const u8,
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
/// caller-provided output buffer (8 bytes for array_ptr, 8 bytes for schema_ptr, repeated).
#[no_mangle]
    api::set_reduce_target_partitions(value);
/// buffer is too small — the caller can re-allocate and retry.
            None => file_bounds,
        .map_err(|e| e.to_string())
    Some(rt_manager.io_runtime.block_on(async {
    let mgr = get_rt_manager()?;
    Ok(api::get_memory_pool_usage(runtime_ptr))
    sql_len: i64,
    );
            }
    let rt_manager = try_get_rt_manager()?;
    row_ids_ptr: i64,
#[ffm_safe]
        sort_fields,
/// this entry; the per-batch feed reuses the existing `df_sender_send` / `df_sender_close`
/// - `store_ptr` must be a valid `Box<Arc<dyn MetadataCachingStore>>` pointer (produced by
    // publishes the IO runtime handle and `RuntimeManager::drop` clears it, so dropping the old one
    /// whether to put their HTTP IO on this runtime, so they would silently fall back.
        .map_err(|e| format!("df_cache_manager_clear_by_type: {}", e))?;
    let mut file_paths = Vec::with_capacity(files_count as usize);
/// Non-erroring accessor; `None` before init / after shutdown.
            // CI/OI use BoundedCache<FIFO>; eviction type must be FIFO.
            )
// Close functions are infallible and do not use the macro. The output stream
        return Err("df_create_cache: null cache manager pointer".to_string());
/// `i64`s, where each pair `(array_ptrs[i], schema_ptrs[i])` is a populated
/// partial-aggregate half, and stores the result on the session for later
        match result {
    if runtime_ptr == 0 {
            rc >= 0,
        crate::partition_stream::SendOutcome::Sent => 0,
    let shard_view = &*(shard_view_ptr as *const api::ShardView);
// ---- Memory pool observability and dynamic limit ----
                shard_view_ptr,
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
    let column_name = str_from_raw(column_name_ptr, column_name_len)?;
// These are wired from Java at startup (CacheUtils.createCacheConfig) and on
        2 => crate::search_stats::inc_bitmap_tree_scan(),
            Ok(0)
/// Returns 0 on success; < 0 is a negated error-string pointer.
    let manager = runtime.custom_cache_manager.as_ref().ok_or_else(|| {
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
/// Returns 0 on success, a non-empty error string (via `ffm_wrap`) only on argument-decode failure.
    out_ptr: *mut *const u8,
        as *const std::sync::Arc<
pub unsafe extern "C" fn df_stream_get_metrics(
        other => {
use crate::cache;
    query_config_ptr: i64,
        admission_reject: admission_reject_x1000 as f64 / 1000.0,
            let initial_max = gate.max_permits();
            // Gate should not have been modified
    let mut columns: Vec<String> = Vec::with_capacity(col_names_count as usize);
/// for at least `cap_entries * size_of::<WireQueryMetric>()` bytes.
    let plan_vec = plan_bytes.to_vec();
                            &plan_vec,
        session_ctx_handle_ptr,
}
/// Fails a partition stream: pushes an error into the channel (so the consumer's stream yields an
        .read()
// ---------------------------------------------------------------------------
#[no_mangle]
/// injection runs on the same shard-scan session that has the listing-table-backed
    if let Some(mgr) = mgr {
    partition_count: i32,
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
        input_array_ptr,
// as `df_execute_query`, so it drains through the existing `df_stream_next` /
}
) {
#[no_mangle]
        slice::from_raw_parts(schema_ptrs, n)
        // ── Test 3: unknown gate name returns success without modifying gates (Req 2.4) ──
/// Could not tell (no statistics, unreadable footer, unsupported stats type) — keep the shard.
    for i in 0..files_count as usize {
    let cache_type = str_from_raw(cache_type_ptr, cache_type_len)
#[ffm_safe]
    writer_generations_ptr: *const i64,
 * compatible open source license.
    match handle.get_metrics_json() {
    let path = object_store::path::Path::from(file_path);
        col_names_count >= 0,
    let cached_parquet = entry
    page_index::set_scoped_page_index_enabled(enabled != 0);
                }
                .unwrap_or_else(|| {
    file_path_len: i64,
        .any(|w| w == crate::ROW_ID_COLUMN_NAME.as_bytes());
    drop(guard.take());
/// - metadata Foyer: the same ranges promoted via `MetadataCachingStore::put_metadata`
    // Parse the eviction type string into the unified CacheEvictionPolicy enum.
        .map_err(|e| format!("df_cache_manager_get_memory_by_type: {}", e))?;
    let files = &shard_view.object_metas;
        return Err("df_cache_manager_get_total_memory: null runtime pointer".to_string());
unsafe fn try_cached_can_match(
    gate_name_ptr: *const u8,
        });
///
                runtime_ptr,
            "df_fetch_by_row_ids: col_names_ptr is null but count={}",
        schema_slice,
        ));
    mgr.io_runtime
    col_names_ptr: *const *const u8,
        new_max_permits,
    runtime_ptr: i64,
use crate::datafusion_query_config::InternalSearch;
// ---- Stats collection ----
use native_bridge_common::ffm_safe;
        warn!(
        .ok_or_else(|| "df_cache_manager_add_files_with_store: no cache manager".to_string())?;
        .map_err(|e| format!("df_cache_manager_contains_by_type: file_path: {}", e))?;
#[no_mangle]
}
    substrait_len: i64,
    let reason = str_from_raw(reason_ptr, reason_len)
    delegated_predicate_count: i32,
        assert_eq!(rc, CAN_MATCH_UNKNOWN);
        let result =
    for i in 0..files_count as usize {
        columns.push(name.to_string());
/// `SessionContextHandle` pointer (returned by `df_create_session_context`) instead of a
            out[1] = b.max;
) -> Option<crate::can_match::CanMatchResult> {
    )));
        }
        .map_err(|e| format!("df_execute_query: {}", e))?;
use std::time::{Duration, Instant};
    let bytes = slice::from_raw_parts(bytes_ptr, bytes_len);
pub unsafe extern "C" fn df_register_partition_stream(
#[no_mangle]
            // No coordinator-gate acquire here. The QTF coordinator-reduce code path runs
    // Zero-copy read from BigIntVector's direct buffer
    let mgr = get_rt_manager()?;
            std::thread::sleep(std::time::Duration::from_millis(5));
            );
    let success_count = results.iter().filter(|(_, ok)| *ok).count();
#[ffm_safe]
    Box::into_raw(Box::new(manager)) as i64
    }
pub unsafe extern "C" fn df_execute_with_context(
        out_cap,
    };
#[no_mangle]
    api::sender_send(sender_ptr, array_ptr, schema_ptr, mgr.io_runtime.handle())
    }
    std::ptr::copy_nonoverlapping(
#[no_mangle]
) -> i64 {
pub extern "C" fn df_set_cancel_stats_threshold_ms(millis: i64) {
}
pub unsafe extern "C" fn df_create_global_runtime(
                context_id,
    out_len_ptr: *mut i64,
        slice::from_raw_parts_mut(out_ptr as *mut WireQueryMetric, cap_entries as usize);
    context_id: i64,
    )
    } else {
        None => -1,
    write_out_buffer(
    #[test]
            filter_min,
        fragment_executor_gate: pack_partition_gate(mgr.cpu_executor.concurrency_gate()),
pub unsafe extern "C" fn df_update_concurrency_gate(
#[no_mangle]
    array_ptrs: *const i64,
            out[2] = if b.has_nulls { 1 } else { 0 };
            );
        return -1;
pub unsafe extern "C" fn df_register_memtable_on_session_context(
    api::sender_close(sender_ptr);
        }
        "register_partition_stream schema IPC",
    out_len: *mut i64,
pub unsafe extern "C" fn df_cache_manager_get_total_memory(runtime_ptr: i64) -> i64 {
    }
                        filter_min,
    /// `Arc<RuntimeManager>` clones, so on a re-init with no intervening shutdown the outgoing
    // always runs in the indexed executor.
    let store = Arc::clone(&shard_view.store);
    files_count: i64,
#[ffm_safe]
// to the process-global caches in crate::cache::page_index.
            installed.io_runtime.handle().id(),
    /// the query. A null shard view is the cheapest way to reach a non-match status without
    Ok(0)
            let fragment_executor_max_before = fragment_executor_gate.max_permits();
#[no_mangle]
        partial_plan,
) -> i64 {
                    "df_create_cache: STATISTICS cache does not support FIFO eviction".to_string(),
    internal_search_bound: i64,
        &schema_ipc,
    fn send_outcome_maps_receiver_dropped_to_sentinel() {
        return Err("df_cache_manager_add_files: null runtime pointer".to_string());
 * The OpenSearch Contributors require contributions made to
/// be drained via `df_stream_next` / `df_stream_close`.
    future: F,
        crate::can_match::can_match_range_via_store(
    if cache_manager_ptr == 0 {
    sort_orders_ptr: *const *const u8,
                new_max,
    Ok(0)
// string pointer that `NativeCall.invoke` reads and frees on the Java side.
) -> i64 {
    let manager = runtime
        // domain, so there is no shard-wide range.
pub unsafe extern "C" fn df_query_registry_top_n_by_current(
        crate::can_match::sort_bounds_via_store(store, &path, file_size, column_name).await
    let cache_type = str_from_raw(cache_type_ptr, cache_type_len)
    }
            "the published handle must be the live manager's, not one from a torn-down runtime"
/// `session_ptr` must be a valid pointer returned by `df_create_local_session`
 * SPDX-License-Identifier: Apache-2.0
    let schema_ipc = slice::from_raw_parts(schema_ipc_ptr, schema_ipc_len as usize);
                    .await
/// on the named column.
        return Ok(CAN_MATCH_UNKNOWN);
        .ok_or_else(|| "df_cache_manager_remove_files: no cache manager configured".to_string())?;
const SENDER_SEND_RECEIVER_DROPPED: i64 = 1;
// wire layout.
///
    input_id_ptr: *const u8,
    }
    };
    let results = manager
            column_name,
        let ptr = Box::into_raw(Box::new(session_handle)) as i64;
        });
/// reading the footer via the shard's ObjectStore (local disk or S3).
            size_limit
    session_ptr: i64,
    memory_pool_limit: i64,
        crate::test_process_globals::install_runtime_manager();
    cache_type_len: i64,
// ---------------------------------------------------------------------------
    let mgr_for_inner = Arc::clone(&mgr);
    Ok(0)
    if runtime_ptr == 0 {
    }
            manager.set_statistics_cache(stats_cache);
    fn wait_for_max_permits(gate: &ConcurrencyGate, expected: u32) -> bool {
            std::thread::sleep(std::time::Duration::from_millis(100));
#[ffm_safe]
                &plan_vec,
        )
    }
        df_update_concurrency_gate(gate_name.as_ptr(), gate_name.len() as i64, new_max)
                &mgr_for_inner,
    Ok(manager.get_total_memory_consumed() as i64)
                        filter_max,
    column_name: &str,
    cache_type_len: i64,
#[no_mangle]
    Ok(0)
        .as_ref()
 */
        // ── Test 2: "fragment_executor" routes to CPU executor gate (Req 2.2) ──
    filter_min: i64,
}
) -> i64 {
#[ffm_safe]
    // Wrap plan setup in `cpu_executor.spawn` so DataFusion operators that
/// `NativeLibraryLoader.checkResult` treats every negative return as an address to read a message
        schema_ipc,
            *out_len_ptr = len;
    partial_plan_ptr: *const u8,
    crate::test_process_globals::assert_held("the process-global runtime manager");
        crate::task_monitors::coordinator_reduce_monitor().instrument(async move {
                // Acquire datanode gate on IO runtime BEFORE spawning on CPU.
/// built yet and a name it does not know are both "nothing to resize", not caller errors.
        let file_size = file_meta.size as usize;
    spill_limit: i64,
///
) -> i64 {
            cache_type
    use object_store::path::Path as ObjectPath;
) -> i64 {
    if ptr.is_null() {
                runtime_ptr,
pub unsafe extern "C" fn df_close_local_session(ptr: i64) {
    if row_ids_count > 0 {
    timed_block_on(&mgr.io_runtime, "execute_query", async move {
/// After this call:
            }
            "df_cache_manager_update_size_limit: unsupported cache type: {}",
        let len = *files_len_ptr.add(i);
    let io_runtime = mgr.io_runtime.clone();
        cache_stats,
use parking_lot::RwLock;
/// Only log block_on durations exceeding this threshold.
        return Err(format!(
/// the byte count through `out_len` (when non-null). Returns `Err` when the
    runtime: &tokio::runtime::Runtime,
        } else {
    let rt_handle = rt_manager.io_runtime.handle();
    // land on IO workers at plan-setup time and the IO runtime ends up doing
// SessionContext decomposition — instruction-based execution
    let gate_name_owned = gate_name.to_string();
//
            .block_on(async move {
    };
    let shard_view = &*(shard_view_ptr as *const api::ShardView);
    hash_key_indices_ptr: *const i32,
#[no_mangle]
    filter_max: i64,
}
    shard_view_ptr: i64,
pub extern "C" fn df_create_custom_cache_manager() -> i64 {
use datafusion::execution::cache::DefaultFilesMetadataCache;
    schema_ipc_len: i64,
#[ffm_safe]
                table_name,
                            ptr,
) {
}
    .map_err(|e| e.to_string())
    if runtime_ptr == 0 || out_ptr.is_null() {
#[no_mangle]
        return Err("null runtime pointer".to_string());
    runtime_ptr: i64,
/// from. A negative status here is dereferenced as that address and segfaults the node. Every
    if size_limit < 0 {
            return 0;
    page_index::clear_scoped_cache();
                }
        &[]
    let manager = runtime.custom_cache_manager.as_ref().ok_or_else(|| {
    *guard = Some(Arc::new(RuntimeManager::new(
        .map_err(|e| format!("df_cache_manager_update_size_limit: {}", e))?;
            return Ok(0);
            "df_can_match returned {rc}; negative values are error pointers to Java, not statuses"
    let n = n_batches as usize;
    sql_ptr: *const u8,
    let plan_bytes = slice::from_raw_parts(plan_ptr, plan_len as usize);
}
                .to_string(),
#[no_mangle]
    partial_plan_ptr: *const u8,
    if stream_ptr == 0 {
        let _ = Box::from_raw(std::slice::from_raw_parts_mut(ptr, len as usize));
            // before concluding that it did not.
    table_name_ptr: *const u8,
        ))
        }
    cap_entries: i64,
#[no_mangle]
        assert_eq!(
            str_from_raw(ptr, len)
    shard_view_ptr: i64,
}
    has_partial_aggregate: u8,
    Ok(if manager.contains_file_by_type(file_path, cache_type) {
    })
    api::stream_get_schema(stream_ptr).map_err(|e| e.to_string())
        // Must surface the sentinel, not collapse to 0 like a normal send, or Java never latches
#[no_mangle]
        let file_path = file_meta.location.as_ref();
    let mgr_for_inner = Arc::clone(&mgr);
    }
/// On success returns 0 and writes 16N to `out_len`. On error returns the FFM sentinel.
            },
    let mgr = get_rt_manager()?;
/// Writes [usage_bytes, tripped_count] to the output buffer.
#[ffm_safe]
                .instrument(session.prepare_final_plan(bytes)),
        // The cases below resize the gate on the manager the whole test binary shares, so they
        RuntimeMetricsRepr::zeroed()
        // Try cache first, then ObjectStore fallback
#[inline(always)]
) -> i64 {
            0
        ));
        .as_ref()
) -> i64 {
/// Returns current memory pool limit in bytes.
        crate::datafusion_query_config::DatafusionQueryConfig::from_ffm_ptr(query_config_ptr);
        );
        cache::CACHE_TYPE_STATS => {
// ---------------------------------------------------------------------------
#[no_mangle]
use crate::custom_cache_manager::CustomCacheManager;
                .map_err(|e| format!("df_cache_manager_update_size_limit: {}", e))?;
    // 1 = get-by-row-id (`__row_id__ = internal_search_bound`); 2 = seq-no scan
        _ => {}
    eviction_type_ptr: *const u8,
    cache_type_ptr: *const u8,
                cache_type
) -> i64 {
            dyn opensearch_tiered_storage::tiered_object_store::MetadataCachingStore,
}
    }
        .map_err(|e| format!("df_create_cache: eviction_type: {}", e))?;
    // (RepartitionExec drain, CoalescePartitionsExec, etc.) inherit the CPU executor
#[ffm_safe]
    plan_len: i64,
        format!(
pub unsafe extern "C" fn df_prepare_final_plan(
}
            store,
                    crate::task_monitors::query_execution_monitor().instrument(async move {
    mgr.io_runtime
    let mut guard = TOKIO_RUNTIME_MANAGER.write();
    file_size: usize,
        );
            .map_err(|e| e.to_string())
    out_ptr: *mut u8,
    if shard_view_ptr == 0 {
    // before it runs and `SpawnService` sees only a dropped oneshot.
    files_ptr: *const *const u8,
pub unsafe extern "C" fn df_execute_local_prepared_plan(session_ptr: i64, context_id: i64) -> i64 {
            0,
    /// Re-initialising on top of an existing manager must leave the NEW manager's IO handle
/// Layout: [min, max, has_nulls, value_kind]. Mirrored by `NativeBridge.SORT_BOUNDS_SLOTS`.
    schema_ptrs: *const i64,
    )?;
        ))
    crate::memory_guard::set_pool_limit_for_guard(new_limit);
        adaptive_budget: pack_adaptive_budget(),
        // One unreadable file means the shard-wide range is unknown — the other files'
    let bytes = api::sql_to_substrait(shard_view_ptr, table_name, sql, runtime_ptr, &mgr)
        &[]
        return Err("null runtime pointer".to_string());
    // sortFields.size() == sortOrders.size() (IndexSortConfig validates at index creation),
    cache_type_ptr: *const u8,
    reason_len: i64,
        )
// is not yet present. Once PR 1 merges the bodies replace these no-ops.
#[no_mangle]
        coordinator_reduce_monitor, plan_setup_monitor, query_execution_monitor,
///
            let out = std::slice::from_raw_parts_mut(out_ptr, SORT_BOUNDS_SLOTS);
    // Pointer type is `Arc<dyn MetadataCachingStore>`; the manager calls `put_metadata`
    crate::memory_guard::set_pool_limit_for_guard(memory_pool_limit);
    runtime_ptr: i64,
            .map_err(|e| format!("df_fetch_by_row_ids: column name: {}", e))?;
        "df_cache_manager_get_total_memory: no cache manager configured".to_string()
/// the native side constructs a [`MemTable`] in one shot.
) -> i64 {
            .unwrap_or_else(CacheStatsRepr::default)
/// Promotion happens entirely in Rust inside `CustomCacheManager::add_files_with_store`;
    runtime_ptr: i64,
        .map_err(|e| e.to_string())
    let key_slice: &[i32] = if n == 0 {
) -> Option<crate::can_match::Bounds> {
pub unsafe extern "C" fn df_destroy_custom_cache_manager(ptr: i64) {
    execution_critical_x1000: i64,
        .custom_cache_manager
        }
    }
    Ok(CAN_MATCH_NO)
#[no_mangle]
    filter_min: i64,
            let ptr = Box::into_raw(boxed) as *const u8;
        let f_len = *sort_fields_len_ptr.add(i);
            "df_fetch_by_row_ids: col_names_len_ptr is null but count={}",
    // native-repository-{s3,gcs,azure} stores read that handle to put their HTTP IO on this runtime.
                let permit = gate.acquire_many(partition_weight.min(max_p)).await;
    assert!(
    // Safety: runtime_ptr must be a valid pointer from df_create_global_runtime
#[no_mangle]
        // range would understate it.
        .as_ref()
        assert_eq!(SENDER_SEND_RECEIVER_DROPPED, 1);
    // (RepartitionExec, CoalescePartitionsExec, AggregateExec) eagerly
                delegated_predicate_count,
    timed_block_on(
                runtime_ptr,
    /// `df_can_match` reports has to be non-negative. A negative one is read by Java as an
///
    ///
        .block_on(crate::task_monitors::plan_setup_monitor().instrument(
        );
                    Err(e) => Err(datafusion::error::DataFusionError::Execution(format!(
    api::close_global_runtime(ptr);
        .map_err(|e| format!("df_register_memtable_on_session_context: input_id: {}", e))?;
    mgr.io_runtime
        let Some(file_bounds) = file_bounds else {
/// Variant of `df_register_memtable` for the shard-scan side. Takes a
    let input_id = str_from_raw(input_id_ptr, input_id_len)
                            cpu_for_cross,
        )),
    /// task on the IO runtime, so it is not observable the instant the call returns; polling
pub unsafe extern "C" fn df_close_session_context(ptr: i64) {
}
/// Rust takes ownership; on error the structs are dropped on the Rust side.
    plan_len: i64,
}
use std::slice;
    input_id_len: i64,
                .instrument(crate::session_context::prepare_partial_plan(handle, bytes)),
    }
                        crate::query_executor::execute_with_context(
    // the plan construction and stream wrapping hop to CPU.
            manager.set_column_index_cache(size_limit as usize);
    fn test_ffi_gate_routing() {
            crate::session_context::create_session_context_indexed(
}
    if runtime_ptr == 0 {
    .map_err(|e| e.to_string())
                deleted_doc_filtering_required != 0,
                        "df_execute_with_context: CPU spawn failed: {e:?}"
    }
        return Err("df_cache_manager_add_files_with_store: null runtime pointer".to_string());
    Some(crate::can_match::can_match_range_with_metadata(
    let files = &shard_view.object_metas;
) -> i64 {
}
/// On success returns the sender pointer cast to `i64`; on error returns the FFM error sentinel.
}
///
        match mgr_for_spawn.cpu_executor().spawn(inner_fut).await {
        table_path,
    }
        std::mem::size_of::<DfStatsBuffer>(),
///
    // lock only, not this guard, so a store built inside this window sees `None` and keeps its
    let manager = runtime.custom_cache_manager.as_ref().ok_or_else(|| {
    let partial_plan = slice::from_raw_parts(partial_plan_ptr, partial_plan_len as usize);
/// Prepares a partial-aggregate physical plan on the session context handle.
    // which policies are valid for each type.
        )
// NOTE: On main these are stubs that do nothing — the cache module from PR 1
        };
    if shard_view_ptr == 0 || out_ptr.is_null() {
    let input_id = str_from_raw(input_id_ptr, input_id_len)
            new_limit
// ---------------------------------------------------------------------------
    let mgr_for_spawn = Arc::clone(&mgr);
    store_ptr: i64,
        df_init_runtime_manager(1, 1.5, 1.5);
    schema_ptrs: *const i64,
    n_batches: i64,
        }
/// column absent, unsupported type, statistics missing, or files disagreeing on type.
        _ => Err(format!(
pub unsafe extern "C" fn df_set_memory_pool_limit(runtime_ptr: i64, new_limit: i64) -> i64 {
    new_max_permits: u32,
        .block_on(crate::api::fetch_by_row_ids(
    let rt_manager =
#[ffm_safe]
            Ok(inner) => inner,
/// The caller must free the returned bytes via `df_free_metrics_buf`.
///
        }
            assert_eq!(
    unsafe fn call_update_gate(gate_name: &str, new_max: u32) -> i64 {
    cache_type_ptr: *const u8,
    column_name: &str,
}
        let partition_weight = session_handle.query_config.target_partitions.max(1) as u32;
    let mut file_paths = Vec::with_capacity(files_count as usize);
        slice::from_raw_parts(array_ptrs, n)
    column_name: &str,
pub unsafe extern "C" fn df_free_metrics_buf(ptr: *mut u8, len: i64) {
    // Wrap plan setup in cpu_executor.spawn so internal DataFusion spawns
                plan_bytes,
        return Ok(CAN_MATCH_UNKNOWN);
///
    let mgr = get_rt_manager()?;
            assert_eq!(
    partial_plan_len: i64,
    let input_id = str_from_raw(input_id_ptr, input_id_len)
}
    )
            // is blocked waiting for permits its own work would release. Keep the gate
                // creating backpressure at the Java threadpool level when the gate is full.
        &metadata,
/// header. This registers the streaming table under the FINAL fragment's logical column names
    partial_plan_len: i64,
    sort_count: i64,
pub unsafe extern "C" fn df_cache_manager_clear(runtime_ptr: i64) -> i64 {
/// Returns current memory pool usage in bytes.
#[no_mangle]
#[no_mangle]
        slice::from_raw_parts(plan_ptr, plan_len as usize)
        slice::from_raw_parts(plan_ptr, plan_len as usize)
/// Safety: `out_ptr` must be non-null, 8-byte aligned, and point to storage
    };
#[ffm_safe]
    Ok(0)
    api::close_local_session(ptr);
    let gate = match gate_name {
    table_name_len: i64,
#[ffm_safe]
fn timed_block_on<F: std::future::Future>(
#[ffm_safe]
                shard_view_ptr,
        api::register_partition_stream(session_ptr, input_id, partial_plan)
    /// mid-read on the global, which surfaces as "no runtime manager registered" somewhere else.
/// Order of entries within the buffer is unspecified. Completed and zero-byte
    #[cfg(test)]
    files_ptr: *const *const u8,
    table_name_len: i64,
            let metadata_cache = Arc::new(cache::MutexFileMetadataCache::new(inner_cache));
// ---------------------------------------------------------------------------
pub unsafe extern "C" fn df_shard_sort_bounds(
///
            let boxed = bytes.into_boxed_slice();
// ── Scoped page-index cache limit setters ────────────────────────────────────
    let io_runtime = pack_runtime_metrics(&mgr.io_monitor, mgr.io_runtime.handle());
    .map_err(|e| e.to_string())
    //
    // call to the async spawn handle).
        pack_task_monitor, CacheStatsRepr, DfStatsBuffer, RuntimeMetricsRepr,
) -> i64 {
            .map(pack_cache_stats)
pub unsafe extern "C" fn df_cache_manager_get_memory_by_type(
    // Spawn the resize on the IO runtime. Scale-up completes immediately;
    if out_ptr.is_null() {
            let result = unsafe { call_update_gate("fragment_executor", new_max) };
#[no_mangle]
            e
            // METADATA uses DefaultFilesMetadataCache (has its own LRU); eviction
    api::sender_fail(sender_ptr, reason);
pub unsafe extern "C" fn df_register_partition_stream_on_session_context(
    // index sort configured; pass an empty Vec. The Java side guarantees
            );
    if out_cap < 0 || (out_cap as usize) < layout::BUFFER_BYTE_SIZE {
        plan_setup: pack_task_monitor(plan_setup_monitor()),
        .get_file_metadata_cache_for_datafusion()?;
pub unsafe extern "C" fn df_create_worker_session_context(
        .custom_cache_manager
    /// in. The "before runtime init" case (Req 2.6) is reached by passing `None`, not by clearing
    // held live by the caller for the duration of the FFM downcall — safe to
    let policy = match eviction_type.to_uppercase().as_str() {
    let column_name = str_from_raw(column_name_ptr, column_name_len)?;
        }
    api::create_reader(
            update_concurrency_gate(None, "fragment_executor", 10),
    let handle = &*(stream_ptr as *const api::QueryStreamHandle);
    file_path_ptr: *const u8,
    // Pointer to a `WireDatafusionQueryConfig`
#[no_mangle]
/// pointer (negated error pointer on failure).
    out_cap: i64,
/// `bytes_ptr` must point to `bytes_len` valid bytes of a Substrait plan.
    }
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
pub unsafe extern "C" fn df_cache_manager_remove_files(
    .map_err(|e| e.to_string())
    #[test]
    let cache = runtime
    // call and gating it can deadlock).
/// `shard_view_ptr` must be 0 or a valid `api::ShardView` pointer; `out_ptr` must point
    out_ptr: *mut u8,
    /// `#[ffm_safe]` reserves negative returns for negated error pointers, so every status
    cache_type_len: i64,
            }
    // all the work. The IO runtime still drives the outer `timed_block_on`
    let mut sort_fields = Vec::with_capacity(sort_count as usize);
unsafe fn try_store_can_match(
    // closure to call `cpu_executor().spawn`.
                deleted_doc_filtering_required != 0,
    runtime_ptr: i64,
    // (bridging the synchronous FFM call to the async spawn handle); only
    let file_path = str_from_raw(file_path_ptr, file_path_len)
pub unsafe extern "C" fn df_stats(runtime_ptr: i64, out_ptr: *mut u8, out_cap: i64) -> i64 {
/// sender that streams batches one at a time, the caller hands across `n`
            SENDER_SEND_RECEIVER_DROPPED
    str::from_utf8(bytes).map_err(|e| format!("invalid UTF-8: {}", e))
    }
    if runtime_ptr == 0 {
        .map_err(|e| e.to_string())?;
        return;
        let file_size = file_meta.size as usize;
    );
    }
        )
        coordinator_reduce: pack_task_monitor(coordinator_reduce_monitor()),
/// Maps a send outcome to the `df_sender_send` return code: normal send `0`, dropped receiver
    use datafusion::datasource::physical_plan::parquet::metadata::CachedParquetMetaData;
    let plan_bytes: &[u8] = if plan_len > 0 {
        return Err("null string pointer".to_string());
        .as_ref()?
    session_ctx_handle_ptr: i64,
#[ffm_safe]
/// Times a block_on call and logs a warning if it exceeds the threshold.
    let elapsed = start.elapsed();
    col_names_count: i64,
#[no_mangle]
        column_name,
        let published = native_bridge_common::io_runtime::io_handle()
            return Err(format!(
/// Writes the pointer to allocated bytes into `out_ptr` and the length into `out_len_ptr`.
    coordinator_multiplier: f64,
    let buf = DfStatsBuffer {
}
            col_names_count
                    crate::task_monitors::query_execution_monitor().instrument(async move {
    store_ptr: i64,
    let mut file_paths = Vec::with_capacity(files_count as usize);
    shard_view_ptr: i64,
#[ffm_safe]
    assert!(
/// Writes `[min, max, has_nulls, value_kind]` into `out_ptr` (4 caller-allocated i64 slots)
    Ok(0)
            size_limit
    if runtime_ptr == 0 {
#[ffm_safe]
        None => Ok(0),
    /// Replaces the manager the rest of the binary shares, hence the process-globals lock. What it
    column_name_len: i64,
    bytes: &[u8],
    fn can_match_status_codes_are_non_negative() {
}
        try_get_rt_manager(),
        return None;
    let cache_type = str_from_raw(cache_type_ptr, cache_type_len)
/// `FFI_ArrowArray` / `FFI_ArrowSchema` pair owned by the caller. On success
    } else {
#[ffm_safe]
fn send_outcome_to_code(outcome: crate::partition_stream::SendOutcome) -> i64 {
                &table_name_owned,
/// Java: MethodHandle(JAVA_LONG → JAVA_LONG)
    // runtime and do all the work there, leaving the CPU runtime idle.
    let mgr_for_spawn = Arc::clone(&mgr);
        .map_err(|e| e.to_string())
/// status crossing this boundary must be non-negative.
        &[]
    cache_type_ptr: *const u8,
    let bytes_vec = slice::from_raw_parts(substrait_ptr, substrait_len as usize).to_vec();
        session_ctx_handle_ptr,
pub unsafe extern "C" fn df_create_cache(
        );
        .as_any()
/// `array_ptrs` and `schema_ptrs` must each point to an `n`-element array of
        return None;
                .map_err(|e| format!("df_create_reader: sort_order[{}]: {}", i, e))?
        crate::task_monitors::stream_next_monitor().instrument(api::stream_next(stream_ptr)),
pub unsafe extern "C" fn df_stream_close(stream_ptr: i64) {
            Err(e) => Err(datafusion::error::DataFusionError::Execution(format!(
}
        ))
}
        crate::datafusion_query_config::DatafusionQueryConfig::from_ffm_ptr(query_config_ptr);
/// `df_sender_send` return code when the consumer dropped the receiver. Positive so it rides the
    let session = &mut *(session_ptr as *mut crate::local_executor::LocalSession);
    mgr.io_runtime
    let bytes = slice::from_raw_parts(bytes_ptr, bytes_len);
pub unsafe extern "C" fn df_prepare_partial_plan(
        slice::from_raw_parts(array_ptrs, n)
/// Resize logic behind [`df_update_concurrency_gate`], with the runtime manager passed in rather
/// Shard provably holds no matching row — the only status that prunes.
///   `ts_get_object_store_box_ptr`).
    ///
            if policy == CacheEvictionPolicy::Fifo {
        .map_err(|e| format!("df_create_reader: {}", e))?;
#[no_mangle]
                            permit,
/// - data Foyer: raw footer + page index bytes (via get_ranges populate)
        "LFU" => CacheEvictionPolicy::Lfu,
    runtime_ptr: i64,
        );
    session_ctx_handle_ptr: i64,
            "df_register_partition_stream_on_session_context: input_id: {}",
    // left `None` installed for good, and a store that captured a dead handle fails every request
}
/// with a plan already prepared via `df_prepare_final_plan`.
    use super::*;
    table_path_ptr: *const u8,
    let rt_handle = rt_manager.io_runtime.handle();
    #[test]
                });
            row_ids_ptr != 0,
/// # Safety
    Ok(0)
// so `Err(String)` returns are converted into a negated heap-allocated error
        >);
    api::create_local_session(runtime_ptr).map_err(|e| e.to_string())
    }
            return Err(format!(
    query_config_ptr: i64,
            if policy != CacheEvictionPolicy::Fifo {
        .map_err(|e| e.to_string())
) -> i64 {
    })?;
pub const CAN_MATCH_UNKNOWN: i64 = 2;
    let plan_bytes = slice::from_raw_parts(plan_ptr, plan_len as usize);
#[ffm_safe]
#[no_mangle]
    let table_name_owned = table_name.to_string();
    }
        admission_throttle: admission_throttle_x1000 as f64 / 1000.0,
    crate::search_stats::inc_listing_table_scan();
    new_max_permits: u32,
        .map_err(|e| format!("df_cache_manager_contains_by_type: cache_type: {}", e))?;
    }))
pub unsafe extern "C" fn df_create_session_context_indexed(
    // (`_seq_no > internal_search_bound`). When non-zero, `plan_ptr`/`plan_len` are
        &bytes,
use std::str;
    let plan_vec = plan_bytes.to_vec();
            "df_set_offset_index_cache_limit: negative limit {}",
                query_config,
            out_cap
                        session_ptr,
        assert_eq!(
    let shard_view = &*(shard_view_ptr as *const crate::api::ShardView);
    cpu_threads: i32,
    Ok(0)
        bytes.extend_from_slice(&a.to_le_bytes());
    if runtime_ptr == 0 {
}
            op_name, elapsed
        _ => {
        *out_len = bytes.len() as i64;
        }
    /// a runtime or any parquet on disk.
        return Ok(0);
    hash_key_indices_len: i64,
        .as_ref()
/// streaming input on the shard-scan session under `input_id` and returns the producer-side
/// Frees a metrics buffer previously returned by `df_stream_get_metrics`.
        .map_err(|e| format!("df_cache_manager_add_files_with_store: {}", e))?;
        out_len,
 *
/// `runtime_ptr` may be `0` to skip cache-stats collection. When non-zero it
            .map_err(|e| e.to_string())?;
    column_name_len: i64,
        out_len,
    out_len: *mut i64,
}
}
            manager.set_offset_index_cache(size_limit as usize);
    let n = n_batches as usize;
    manager.clear_all();
        .add_files(&file_paths, rt_handle)
/// `bytes_ptr` must point to `bytes_len` valid bytes of a Substrait plan.
            e
    write_out_buffer(
}
        let o_ptr = *sort_orders_ptr.add(i);
    }
    assert!(
    table_name_ptr: *const u8,
            shard_view, runtime, &mgr, row_ids, columns, context_id,
#[no_mangle]
    Ok(0)
// One FFM call: Java allocates a buffer sized for `N` entries, Rust selects
///
    let query_config =
    // that token — tokio reuses a runtime's id once that runtime has completed, which is exactly
    manager
                query_config,
                }
        .map_err(|e| format!("df_sql_to_substrait: table_name: {}", e))?;
                plan_bytes,
    // spawn in `execute()`. Without this wrap those spawns inherit the IO
        drop(outgoing);
/// coordinator skip a shard that really holds a top-N row, so this walks everything.
        return Err("df_cache_manager_get_memory_by_type: null runtime pointer".to_string());
    } else {
    shard_view_ptr: i64,
                .map_err(|e| format!("df_cache_manager_remove_files: {}", e))?
    match folded {
/// # Safety
/// the Java caller only supplies the file paths.
/// Returns a stream pointer (same shape as `df_execute_local_plan`) that can
}
            assert!(
    files_count: i64,
            );
) -> i64 {
pub unsafe extern "C" fn df_can_match(
    native_bridge_common::log_info!(
    // Cache stats (zeroed when no runtime pointer or no cache manager)
            Ok(1)
    partial_plan_ptr: *const u8,
    runtime_ptr: i64,
    // Copy the plan bytes so the spawned future can own them (`cpu_executor.spawn`
    query_config_ptr: i64,
        execution_critical: execution_critical_x1000 as f64 / 1000.0,
    let schema_slice: &[i64] = if n == 0 {
    out_len: *mut i64,
                Arc::new(CustomStatisticsCache::new(policy, size_limit as usize, 0.8));
    )
        return Err("df_cache_manager_clear: null runtime pointer".to_string());
    TOKIO_RUNTIME_MANAGER
        .custom_cache_manager
#[ffm_safe]
        &mgr,
#[ffm_safe]
    .map(|_| 0)
/// Returns 0 on success.
        }
}
    // All four cache types share one enum — the per-cache match below enforces
#[no_mangle]
/// - file_metadata_cache (heap): lightweight ParquetMetaData (footer only, no page indexes)
                result, 0,
    let input_id = str_from_raw(input_id_ptr, input_id_len).map_err(|e| {
    }
            manager.set_file_metadata_cache(metadata_cache);
    for i in 0..sort_count as usize {
                    )
#[no_mangle]
            if gate.max_permits() == expected {
                shard_view_ptr,
        folded = Some(match folded {
        runtime
/// Registers a streaming partition input on the session. Schema is derived by
        );
                "df_create_cache: invalid cache type: {}",
        file_paths.push(
    shard_view_ptr: i64,
/// IPC-encoded schema is written into the caller-allocated `out_ptr/out_cap`
pub unsafe extern "C" fn df_fetch_by_row_ids(
/// index bytes to the metadata Foyer tier (never-evict) through the store.
    handle_ptr: i64,
pub unsafe extern "C" fn df_sender_send(sender_ptr: i64, array_ptr: i64, schema_ptr: i64) -> i64 {
                .to_string(),
                            cpu_for_cross,
        let name = str_from_raw(ptr, len)
            manager.update_metadata_cache_limit(new_limit as usize);
        Some(b) => {
    Ok(written as i64)
            assert_eq!(
    Ok(0)
    let gate_name = str_from_raw(gate_name_ptr, gate_name_len)
    partial_plan_len: i64,
    let spill_dir = str_from_raw(spill_dir_ptr, spill_dir_len)
    // Retire the outgoing manager before building its replacement, not after. `RuntimeManager::new`
    let use_indexed = session_handle.indexed_config.is_some() || has_row_id;
        writer_generations,
    api::stream_close(stream_ptr);
            replacement_handle.id(),
            "call should return success even before runtime init"
    }
    // scale-down may need to wait for permits to become available.
        .as_ref()
    input_id_ptr: *const u8,
    }
    Ok(update_concurrency_gate(
        file_paths.push(
        gate.max_permits() == expected
    }
#[ffm_safe]
pub unsafe extern "C" fn df_sender_terminate_early(sender_ptr: i64) {
/// Returns 0 on success, non-zero if no metrics are available.
/// When enabled (default): metadata cache strips page index; scoped caches handle it.
        "df_cache_manager_update_size_limit: no cache manager configured".to_string()
    use crate::task_monitors::{
        // Extract target_partitions BEFORE boxing into raw pointer (session_handle is consumed).
    // Parse column names
/// Returns one of the `CAN_MATCH_*` statuses below.
            let inner_cache = DefaultFilesMetadataCache::new(size_limit as usize);
    let out: &mut [WireQueryMetric] =
            .expect("the replacement's handle must survive the outgoing manager's teardown");
/// is derived from the producer's PARTIAL substrait plan (the SAME derivation the
                        column_name,
}
        }
    } else {
                        context_id,
pub unsafe extern "C" fn df_get_memory_pool_stats(runtime_ptr: i64, out_ptr: *mut i64) {
/// Can-match evaluation via FFM. Iterates ALL parquet files in the shard view
#[ffm_safe]
    let metadata = cached_parquet.parquet_metadata();
pub extern "C" fn df_set_reduce_target_partitions(value: i64) {
    }
#[ffm_safe]
                return Err(
unsafe fn try_cached_sort_bounds(
        // ── Test 1: update before runtime init returns success (Req 2.6) ──
}
    }
        "df_fetch_by_row_ids: shard_view_ptr is null"
    file_path: &str,
    // Copy substrait bytes into an owned Vec so the spawned future can move them
        let installed = get_rt_manager().expect("the manager just installed must be readable");
    };
/// Scale-up is synchronous. Scale-down spawns an async task on the IO
/// lowering the producer-side substrait `partial_plan_bytes`; the resulting
    array_ptrs: *const i64,
    out_cap: i64,
}
                .map_err(|e| format!("df_cache_manager_add_files: {}", e))?
#[ffm_safe]
/// (e.g. `sum_qty`) rather than the producer's physical state names (e.g. `sum_qty[sum]`), so
    column_name_ptr: *const u8,
}
    // with `HttpErrorKind::Interrupted`, because a spawn onto a shut-down runtime is cancelled
#[ffm_safe]
    out_cap: i64,
        query_execution: pack_task_monitor(query_execution_monitor()),
                .map_err(|e| format!("df_create_reader: sort_field[{}]: {}", i, e))?
        stream_next_monitor,
        return None;
/// Separate from `df_can_match` on purpose: that function short-circuits at both the
    /// handle. Ordering the drop earlier cannot help here; the teardown has to check ownership.
    assert!(runtime_ptr != 0, "df_fetch_by_row_ids: runtime_ptr is null");
    // requires `'static`). The `shard_view_ptr`, `runtime_ptr` are raw pointers
        ));
    }
    files_len_ptr: *const i64,
    runtime_ptr: i64,
/// wrong-result into a loud query failure. The reason string is included in the surfaced error.
            }
const BLOCK_ON_LOG_THRESHOLD: Duration = Duration::from_millis(1);
            !col_names_ptr.is_null(),
    let input_id = str_from_raw(input_id_ptr, input_id_len).map_err(|e| {
        out_ptr,
    out_len: *mut i64,
    #[test]
    Ok(0)
    );
) -> i64 {
    // Decode parallel sort_fields / sort_orders String arrays. sort_count == 0 means no
            }
    /// leaves installed is a working manager, which is all any other test needs.
        slice::from_raw_parts(schema_ptrs, n)
}
}
        let len = *files_len_ptr.add(i);
///
        out_ptr,
    execution_spill_x1000: i64,
        files_count, success_count
#[no_mangle]
    let mut filenames = Vec::with_capacity(files_count as usize);
///
        "fragment_executor" => mgr.cpu_executor().concurrency_gate().clone(),
///
    if runtime_ptr == 0 {
                requests_row_ids != 0,
                Some(merged) => merged,
///
        let o_len = *sort_orders_len_ptr.add(i);
pub unsafe extern "C" fn df_stream_next(stream_ptr: i64) -> i64 {
        input_schema_ptr,
/// Returns execution metrics as JSON bytes for the given stream.
}
        Some(bytes) => {
    context_id: i64,
        assert!(
        .get_memory_consumed_by_type(cache_type)
/// Decodes the Substrait bytes, converts to a physical plan, strips the
    // IO runtime (always present)
pub extern "C" fn df_shutdown_runtime_manager() {
    timed_block_on(
        mgr.io_runtime
                "fragment_executor gate should not be modified for unknown gate name"
    }
    /// Returns the i64 result (0 = success for the outer call).
    filter_min: i64,
// `df_stream_close` paths unchanged.
        .block_on(
    ))
) -> i64 {
    }
        );
    // eagerly spawn in their `execute()` method (RepartitionExec,
        .ok_or_else(|| "df_cache_manager_add_files: no cache manager configured".to_string())?;
            })
    mgr.io_runtime
    // CoalescePartitionsExec, AggregateExec, ...) inherit the CPU executor
pub unsafe extern "C" fn df_stream_get_schema(stream_ptr: i64) -> i64 {
    api::set_min_target_partitions(value);
#[no_mangle]
// returned by `df_execute_local_plan` is the same `QueryStreamHandle` shape
    }
/// off-heap ArrowBuf). Zero-copy at FFM boundary: Rust reads directly from
        get_rt_manager().map_err(|e| format!("df_cache_manager_add_files_with_store: {}", e))?;
    if runtime_ptr == 0 {
///
    ///
) -> i64 {
    if files.is_empty() {
    })?;
        }
// ---------------------------------------------------------------------------
#[no_mangle]
    //
}
                return Err(format!("df_create_cache: OFFSET_INDEX cache only supports FIFO eviction, got {eviction_type}"));
    crate::session_context::close_session_context(ptr);
                .map_err(|e| format!("df_create_reader: {}", e))?
) -> i64 {
    for i in 0..files_count as usize {
    manager: Option<Arc<RuntimeManager>>,
        let partition_weight = session_handle.query_config.target_partitions.max(1) as u32;
    manager
        return Err(format!("negative string length: {}", len));
/// Deliberately 2, not -1: `#[ffm_safe]` returns `Err` as a *negated error pointer*, so Java's
    if len < 0 {
        input_id,
                None => return Ok(0),
        assert_eq!(
/// # Safety
#[ffm_safe]
        cpu_runtime,
                context_id,
#[no_mangle]
        }
        cache::CACHE_TYPE_STATS => {
            "df_register_partition_stream_on_session_context_from_partial_plan: input_id: {}",
                "FFI call should return success even for unknown gate"
    )
                    ))),
#[ffm_safe]
            crate::session_context::create_session_context(
/// Java: MethodHandle(JAVA_LONG, ADDRESS → void)
    let metadata = cached_parquet.parquet_metadata();
    let handle = &mut *(handle_ptr as *mut crate::session_context::SessionContextHandle);
        &schema_ipc,
    stream_ptr: i64,
        "partition_batch_by_hash output ptrs",
                let inner_fut =
    let path = object_store::path::Path::from(file_path);
    /// Validates: Requirements 2.2, 2.4, 2.6
}
    // default connector — remote IO then runs on the wrong pool, but it works. The old order instead
                gate.max_permits()
                // creating backpressure at the Java threadpool level when the gate is full.
#[no_mangle]
    crate::query_tracker::set_cancel_stats_threshold(millis as u64);
    schema_ipc_ptr: *const u8,
/// Sets the cancellation stats threshold in milliseconds.
        cpu_threads as usize,
        .map_err(|e| e.to_string())
    })?;
    cache_type_len: i64,
    let internal_search = InternalSearch::from_wire(internal_search_mode, internal_search_bound);
    size_limit: i64,
        "df_fetch_by_row_ids: negative row_ids_count {}",
    admission_throttle_x1000: i64,
    match cache_type {
/// Memtable variant of `df_register_partition_stream`: instead of returning a
/// Cache-miss fallback: read footer via the shard's ObjectStore.
    }
    /// Covers:
    filter_max: i64,
                wait_for_max_permits(&gate, new_max),
    })
    let rt_manager = try_get_rt_manager()?;
    spill_dir_ptr: *const u8,
#[no_mangle]
        .file_metadata
#[no_mangle]
            let new_max = initial_max + 4;
        return Err("df_cache_manager_add_files_with_store: null store pointer".to_string());
}
                        .await
}
///
        .custom_cache_manager
    substrait_ptr: *const u8,
        return Ok(0);
#[ffm_safe]
    let mgr = TOKIO_RUNTIME_MANAGER.write().take();
    };
    let pairs = api::partition_batch_by_hash(
        .map_err(|e| format!("df_register_memtable: input_id: {}", e))?;
        slice::from_raw_parts(hash_key_indices_ptr, n)
        return None;
        "df_cache_manager_contains_by_type: no cache manager configured".to_string()
/// channel sender pointer. M2 hash-shuffle workers register left/right partition inputs via
    let mgr = get_rt_manager()?;
    let session_handle =
            // gating it would deadlock when the gate is contended because the SEARCH thread
// Per-query registry top-N snapshot
    use crate::partition_stream::SendOutcome;
                match mgr_for_spawn.cpu_executor().spawn(inner_fut).await {
    cache_type_ptr: *const u8,
// ---------------------------------------------------------------------------
            ));
    // ignored and the plan is built natively via the DataFrame API — no Substrait.
    .map_err(|e| e.to_string())?;
    )?;
    page_index::set_offset_index_cache_limit(size_limit as usize);
    } else {
    col_names_len_ptr: *const i64,
    files_len_ptr: *const i64,
        filter_min,
///
#[no_mangle]
    api::set_memory_pool_limit(runtime_ptr, new_limit)?;
/// `SessionContextHandle`, returning the `PartitionStreamSender` pointer), but the table schema
        mgr.io_runtime
        ))
    };
    }
        &[]
// and writes them back-to-back. See `query_tracker::WireQueryMetric` for the
    let plan_bytes: &[u8] = if plan_len > 0 {
    // No coordinator-gate acquire here — see df_execute_local_plan for the rationale
    }
    .map_err(|e| e.to_string())?;
    let eviction_type = str_from_raw(eviction_type_ptr, eviction_type_len)
                .to_string(),
        gate_name,
            ),
/// the FFM error sentinel; the bridge layer converts that to a Java exception.
///
/// The buffer must have capacity for at least `size_of::<DfStatsBuffer>()` bytes (600).
    session_ptr: i64,
    )?;
#[ffm_safe]
    /// machine is.
    // Safety: cache_manager_ptr must be a valid pointer from df_create_custom_cache_manager
}
    if store_ptr == 0 {
    let mut sort_orders = Vec::with_capacity(sort_count as usize);
    Ok(0)
    std::ptr::copy_nonoverlapping(bytes.as_ptr(), out_ptr, bytes.len());
/// `api::register_partition_stream_on_session_context_from_partial_plan` for the full rationale.
    }
/// For each file: tries the metadata cache first (zero I/O), falls back to
    for i in 0..files_count as usize {
                fragment_executor_max_before,
/// Java's off-heap buffer without any intermediate allocation.
        .windows(crate::ROW_ID_COLUMN_NAME.len())
    deleted_doc_filtering_required: u8,
    /// rather than sleeping a fixed interval keeps the test from depending on how loaded the
    match outcome {
    api::register_partition_stream_on_session_context(session_ctx_handle_ptr, input_id, schema_ipc)
        "execute_local_plan",
///
// Mirror the shard-scan exports above: fallible entry points use `#[ffm_safe]`
        .await
                "FFI call should return success for 'fragment_executor'"
    bytes_ptr: *const u8,
            let gate = mgr.cpu_executor().concurrency_gate().clone();
/// racing every other test in the binary that needs it.
    }
    let result = runtime.block_on(future);
            .map_err(|e| e.to_string())
#[no_mangle]
    Ok(sender_ptr)
/// `session_ptr` must be a valid pointer returned by `df_create_local_session`.
/// Clear the process-global scoped page-index caches (drop entries + reset counters).
    if runtime_ptr == 0 {
            "df_cache_manager_update_size_limit: negative limit {}",
                    try_store_can_match(
            published.id(),
                    api::execute_local_plan(
    out_cap: i64,
    files_ptr: *const *const u8,
    }
/// Streaming sibling of `df_register_memtable_on_session_context`. Registers a partitioned
    gate_name: &str,
    })?;
    let runtime = &*(runtime_ptr as *const crate::api::DataFusionRuntime);
        cache::CACHE_TYPE_COLUMN_INDEX => {
    cache_manager_ptr: i64,
        let column = "@timestamp";
pub unsafe extern "C" fn df_sender_close(sender_ptr: i64) {
            })
pub unsafe extern "C" fn df_cache_manager_add_files_with_store(
                    )
                "df_execute_query: CPU spawn failed: {e:?}"
    api::create_global_runtime(memory_pool_limit, cache_manager_ptr, spill_dir, spill_limit)
///
/// Returns 0 on success; < 0 is a negated error-string pointer.
                let max_p = gate.max_permits();
    match tree_shape {
    table_name_ptr: *const u8,
        session_ptr,
    input_id_len: i64,
#[ffm_safe]
pub extern "C" fn df_cancel_query(context_id: i64) {
        1 => crate::search_stats::inc_single_collector_scan(),
        gate.resize(new_max_permits, &gate_name_owned).await;
        }
                );
            RuntimeMetricsRepr::zeroed()
                        &mgr_for_inner,
    api::cancel_query(context_id);
    table_name_len: i64,
        "df_cache_manager_add_files_with_store: {} files, {} warmed (page-index promoted to metadata Foyer)",
        let inner_fut = crate::task_monitors::query_execution_monitor().instrument(async move {
                query_config,
// dynamic setting changes (DataFusionPlugin settings consumers). They forward
    }
    }
}
            let len = bytes.len() as i64;
    use crate::query_tracker::{snapshot_top_n_by_current, WireQueryMetric};
    session_ctx_handle_ptr: i64,
    /// `TOKIO_RUNTIME_MANAGER`: clearing it would strand every other test in this binary that is
/// execution via `df_execute_with_context`.
/// Queries cancelled for less than this duration are not counted in stats.
    /// - "fragment_executor" routes to the DedicatedExecutor's gate (Req 2.2)
            // Through the real FFI entry point, so its pointer/length shell stays covered.
    match cache_type {
                Ok(inner_result) => inner_result,
    shard_view_ptr: i64,
    let mgr = get_rt_manager()?;
            !col_names_len_ptr.is_null(),
                .to_string(),
    shard_view_ptr: i64,
fn update_concurrency_gate(
    let written = snapshot_top_n_by_current(out);
        row_ids_count >= 0,
    let mgr = get_rt_manager()?;
        .file_metadata
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
    }
    let table_name = str_from_raw(table_name_ptr, table_name_len)
        let _globals = crate::test_process_globals::lock();
    Ok(0)
    let manager = runtime
    let store = std::sync::Arc::clone(store_box);
                .to_string(),
    } else {
    crate::can_match::sort_bounds_with_metadata(&metadata, column_name)
}
) -> Option<crate::can_match::CanMatchResult> {
        let file_path = file_meta.location.as_ref();
/// ERROR rather than a clean EOF), then drops the sender. Used by the Java shuffle drain thread when a
    write_out_buffer(
    runtime_ptr: i64,
        writer_generations.push(*writer_generations_ptr.add(i));
/// Live-tunable; takes effect on the next try_grow. Java: NativeBridge.setSpillExemptCapBytes(long).
            "{} size {} exceeds buffer capacity {}",
            filter_max,
        .map_err(|e| format!("df_cache_manager_remove_files: {}", e))?;
/// # Safety
/// file and row-group level, which is right for a boolean "could anything match" but
    0
                    });
    if runtime_ptr == 0 {
            bytes.len(),
    runtime_ptr: i64,
    Ok(0)
        .remove_files(&file_paths)
    };
    }
                context_id,
    /// empty handle slot — and the native-repository-{s3,gcs,azure} stores read that slot to decide
/// mapping). Writes the resulting N (array_ptr, schema_ptr) pairs as 16N bytes into the
            .or_else(|| try_store_sort_bounds(shard_view_ptr, file_path, column_name, file_size));
