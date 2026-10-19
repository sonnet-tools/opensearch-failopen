        }
///
        //
    )
) -> Result<i64, DataFusionError> {
/// `row_number()` physical op) back to their Substrait-compatible counterparts
/// Initial target_partitions for coordinator-reduce sessions. Defaults to 4.
    let object_metas = shard_view.object_metas.clone();
        assert!(
        DataFusionError::Execution(format!("Failed to import Arrow C Data array: {}", e))
    let metadata_cache = ctx
        RuntimeEnvBuilder::new()
        assert_eq!(out.column(0).data_type(), &DataType::Utf8View);
        if col_idx >= schema.fields().len() {
/// MILLIS / MICROS / NANOS only — `Timestamp(Second)` is silently
    #[test]
    }
pub(crate) fn base_schema_for_table(
        let has_nontrivial_state = partial_schema.fields().iter().any(|f| {
    let consumer = DefaultSubstraitConsumer::new(&extensions, &session_state);
        let leaked_b = tmp.path().join("datafusion-Xy9pQ2");
    use datafusion::datasource::file_format::parquet::ParquetFormat;
//! # Thread safety
    manager.io_runtime.block_on(async {
        let values: Arc<dyn Array> = Arc::new(StringViewArray::from_iter_values(["x"]));
        return Err(DataFusionError::Execution(format!(
            Field::new("s", DataType::Utf8View, true),
/// `VectorSchemaRoot` to a paired `FFI_ArrowArray` / `FFI_ArrowSchema`, and
        unsafe { close_global_runtime(ptr) };
            .finish()
        let field_name = schema.field(col_idx).name().clone();
pub unsafe fn sender_fail(sender_ptr: i64, reason: &str) {
    pub fn with_session_context(
        let state = SessionStateBuilder::new()
/// `ptr` must be a valid pointer returned by `create_global_runtime`.
                                "start_timestamp".to_string(),
        }
        let _guard = lock_process_globals();
///   * **Phase 1 (sync, on this thread):** every immediate child (files,
    Ok(Box::into_raw(Box::new(shard_view)) as i64)
        let euid = unsafe { libc::geteuid() };
        shard_view,
        // Phase 2 will eventually remove both *.stale entries.
    // bit-compatible Int/UInt pairs; Utf8 and Utf8View have distinct buffer
        // original name. Phase 2 unlinks the .stale entries asynchronously.
        let schema = Arc::new(Schema::new(vec![Field::new(
            DataFusionError::Execution(format!("Failed to import Arrow C Data array: {}", e))
        crate::udf::register_all(&ctx);
/// # Safety
/// Returns memory pool usage (bytes reserved) and tripped count as a pair.
                f.is_nullable(),
/// Must stay in lockstep with the Java `MemoryLayout`.
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, spill_str, 0).expect("runtime build");
    );
        let cleaned = wait_until(2000, || !stale_link.exists());
            Field::new("a", DataType::Int64, false),
            cleaned,
                    .expect("column must be BinaryViewArray when schema declares BinaryView");
            row_base: seg.global_base as i64,
        writer_generations: Arc::new(writer_generations),
            ),
        token.as_ref(),
        // instead of writing to an unintended path. Construction must also flip the
        Some(RelType::Fetch(f)) => {
use datafusion::execution::memory_pool::{MemoryPool, TrackConsumersPool};
            "tags",
    // 64-byte. Mirror the same align_buffers dance the broadcast injection uses.
        assert!(
            partition_count
        mc_arc
    // registry entry can be removed by a sibling stream's Drop (same id) while
            .expect("stat parent")
    /// Concurrency gate permit — held for the query's entire lifetime.
        let batch = RecordBatch::try_new(
}
        let nested_dir = tmp.path().join("subdir/deeper");
                    .into_builder()
    #[test]
        let plan = self.physical_plan.as_ref()?;
    fn create_global_runtime_fails_fast_when_cleanup_fails() {
#[derive(Debug, Copy, Clone)]
/// Variant of [`register_memtable`] for the shard-scan path's `SessionContextHandle`. The
            &*(store_ptr
        assert!(
        // Column passes through unchanged — same Arc, original nanosecond type, no truncation.
        let _guard = lock_process_globals();
    let struct_array = StructArray::from(array_data);
/// released back to Rust's drop impls (the imported structs go out of scope
        //  Phase 2 (async, background thread): re-scan and remove every
        // Mark spill explicitly disabled so per_query_spill_budget short-circuits
    let reader = StreamReader::try_new(Cursor::new(bytes), None)
                        );
    manager: &RuntimeManager,
    for (&array_ptr, &schema_ptr) in array_ptrs.iter().zip(schema_ptrs.iter()) {
        } else if col.data_type().equals_datatype(want.data_type()) {
        // a no-op for already-aligned buffers and reallocates only the misaligned ones —
#[inline]
}
        );
    // Reconstruct the stream from the raw pointer returned by the executor.
        self
/// producer IPC header.
        // on this throwaway session while the real data-node session lowers
                            format!("{}_pruned", name),
    // stream_next on each batch pull.
/// Returns an error if `new_limit` is negative.
            values,
        // The cleanup logic must live entirely inside the spill-enabled branch. With
                Field::new("s", DataType::Utf8, true),
) -> Result<i64, DataFusionError> {
            .with_memory_pool(memory_pool)
            seg.max_doc
            handle
        None,
        }
        unsafe { close_global_runtime(ptr) };
/// Body only runs under `debug_assertions` (called from a `debug_assert!`).
    Ok(crate::schema_coerce::coerce_inferred_schema(
    // channel-close.
            part.into_iter().next().unwrap()
            }
    let struct_array = StructArray::from(array_data);
    let df_stream = ascending_row_id_check_stream(df_stream);
/// go below this value. Setting it equal to configured target_partitions
                            return;
    fn create_global_runtime_with_empty_spill_dir_disables_disk_manager() {
    let token = query_tracker::get_cancellation_token(context_id);
        let ffi_array = FFI_ArrowArray::from_raw(array_ptr as *mut FFI_ArrowArray);
    /// footers in production. Footer-kv reads, when they happen, are debug-only
///
        query_tracker::QueryType::Coordinator,
/// Fires the cancellation token for the given context_id.
///   by the caller; ownership transfers to Rust on success.
        Some(batch) => {
    Ok(())
        None => {
            .unwrap();
            task_done: None,
        // Operator-facing message must include the offending path + io kind so the
pub unsafe fn close_reader(ptr: i64) {
            .base_schema
                        "fetch_by_row_ids: __row_id__ not ascending — prev={}, next={} at row {}",
    let current_phantom = session.phantom_size();
        }
            crate::query_executor::query_runtime_env_builder(runtime, list_file_cache).build()?;
            .collect();
        let _ = Box::from_raw(sender_ptr as *mut PartitionStreamSender);
    for filename in filenames {
                collect_reads(left, out);
///
/// # Safety
}
    /// these globals and produce flaky assertions.
        .ctx
        SpillBudget::Disabled | SpillBudget::Available(_) => query_config.target_partitions,
        config.target_partitions,
    debug_assert_eq!(
        &schema,
        Some(available) => {
    for &gid in &row_ids {
        let bad_path = tmp.path().join("regular_file");
            "Sliced array must be detected as needing gc"
                internal_search,
    declared: &SchemaRef,
    None
    let is_significantly_bloated = bytes_allocated > 2 * bytes_used;
/// side runs the same coercer + wraps its physical plan with
///
/// - `partial_plan_bytes` must be a complete producer-side Substrait plan blob.
/// Extracts the table name from the first NamedTable read in the plan bytes.
        let result = create_global_runtime(64 * 1024 * 1024, 0, spill_str, 0);
    let state = SessionStateBuilder::new()
                collect_reads(input, out);
///   `create_session_context` / `create_session_context_indexed` / `create_worker_session_context`.
    query_context: &mut QueryTrackingContext,
    let schema_ipc = schema_to_ipc_bytes(table_schema.as_ref())?;
    // ── 1. Build RuntimeEnv + SessionContext ──
        } else if part.len() == 1 {
/// DataFusion is lax about them. A mismatch here is a planning-time bug (see
    // Java-side FFI structs untouched. The actual *underlying* array buffers live in
    crate::cache::register_global_runtime_env(&runtime.runtime_env);
    ///
        assert!(
        Some(RelType::Aggregate(a)) => {
    let handle = &mut *(stream_ptr as *mut QueryStreamHandle);
                    crate::ROW_ID_COLUMN_NAME,
    }
        let plan = ctx.sql(sql).await?.logical_plan().clone();
pub struct FileRowMetadata {
            .downcast_ref::<Int64Array>()
            _session_ctx: Some(ctx),
        ));
/// all batches for this partition have been pushed (or on cancellation).
                ._query_tracking_context
    // the declared type here. RelabelExec on the producer side only retags
    schema_ptrs: &[i64],
    crate::query_budget::set_min_target_partitions(value.max(1) as usize);
    /// Spill directory is owned by the JVM but its parent isn't (mount-point
    /// at that moment with "no global DataFusion runtime environment".
        );
}
/// Verify the fetch-result schema carries `__row_id__` plus every requested column.
            query_executor::execute_query(
    // `Arc<dyn ObjectStore>` for the DataFusion APIs below.
        assert_eq!(get_reduce_target_partitions(), 8);
        assert_eq!(get_reduce_target_partitions(), 32);
/// - `session_ctx_handle_ptr` must be a valid, non-zero pointer returned by
        let leaked_dir = spill_path.join("datafusion-aB3kF7");
    // its per-query memory pool overlaying the global pool.
        let expected_child = Arc::new(Field::new("item", DataType::Utf8View, true));
//!   The bridge layer wraps with `block_on` or `spawn`.
            Arc::new(Schema::new(vec![
                spill_dir
            })?;
        batches.push(aligned);
    const INDEX_FILTER: &[u8] = b"index_filter";
            "partition_batch_by_hash: partition_count must be > 0, got {}",
            // state for DataFusion to start; the *.stale entries just persist
        assert_eq!(ts.value(0), 1_000_000_001);
        let (out_array, out_schema) = arrow_array::ffi::to_ffi(&combined_data).map_err(|e| {
            "expected DiskManagerMode::Disabled when spill_dir is empty"
            // Already aborted, so this resolves as soon as the task unwinds; 30s is a backstop
    let checked = stream.map(move |batch_res| {
        }
        let cleaned = wait_until(2000, || !leftover.exists());
        "build_shard_files: object_metas and file_metadata must have matching length"
            // until a future boot with a healthy thread library reaps them.
                            .and_then(|v| v.as_i64())
        let int_array = Int64Array::from_iter_values(0..total_rows as i64);
    // setup, etc. can all take non-trivial time on a wide reduce).
    use arrow::ipc::reader::StreamReader;
/// UDF name and the `__row_id__` column name. Either one → indexed path.
    let mut array_data = array_data_result.map_err(|e| {
        assert!(
            "memory_pool_limit must be non-negative, got {}",
///
                    view_needs_gc(view.data_buffers(), view.total_buffer_bytes_used())
        let total_rows = 100_000usize;
    )));
    session_ctx_handle_ptr: i64,
/// logical names. The producer's physically-named batches still feed in fine: the streaming
/// listing-table-backed shard scan on the same session.
                    e
    base_path: &str,
//!
        Self {
        };
/// forever — `create_local_dirs` in `datafusion-execution` only creates a
        .file_metadata
fn ensure_batch_matches_stream_schema(
//!
        // Bind first, then trait-upcast at the let-binding boundary
    /// child as non-nullable would hand the consumer nulls it does not expect. The
    Ok(output)
    if ptr != 0 {
        }
    filenames: Vec<String>,
    tokio_rt_manager: &RuntimeManager,
            "tags",
        }
            .any(|(col, field)| match field.data_type() {
            gid,
        let sentinel = tmp.path().join("leaked_from_prior_run.tmp");
        if schema.column_with_name(col).is_none() {
        let actual_child = Arc::new(Field::new("element", DataType::Utf8View, true));
        fs::write(&top_file, b"top-level leak").expect("seed top file");
    // / HashJoinExec would compute on the receiver side.
            .collect();
            !leaked_dir.exists(),
        }
        let _guard = lock_process_globals();
            .as_any()
//!
pub unsafe fn partition_batch_by_hash(
                    map.insert(
    .await
        }
/// are heap-allocated by Rust here; ownership transfers to Java on success.
                if v < prev {
    // rebuild RecordBatches against it, so an unconformed string-view mismatch
        impl Drop for RestorePerms<'_> {
            _ => f.as_ref().clone(),
            let entries = fs::read_dir(&spill_path).map_err(|e| {
        assert!(Arc::ptr_eq(out.column(0), &col));
            // is replaced with one `equals_datatype` has proven layout-identical,
    substrait_bytes: &[u8],
    );
        ctx: datafusion::prelude::SessionContext,
    if spill_limit < 0 {
        )));
    match crate::memory_guard::available_disk_space(spill_dir) {
/// Closes a partition stream sender. Dropping the sender closes the mpsc,
    pub fn new_with_plan(
/// Lowers a partial-aggregate Substrait plan against a throwaway session and
        // Without these, HashAggregateExec lowers over Utf8 / Timestamp(Second)
                f.name(),
        pool,
        let boxed = unsafe {
        .unwrap_or_default();
            cleaned,
    #[test]
            strings.iter().map(|s| s.as_str()),
pub async unsafe fn execute_query(
        || plan_bytes.windows(ROW_ID.len()).any(|w| w == ROW_ID)
            if let Some(input) = &f.input {
            "spill root must remain a directory after cleanup"
    let sender = &*(sender_ptr as *const PartitionStreamSender);
        context_id,
// `execute_local_plan` hands back a `QueryStreamHandle` of the same shape
    }
/// typically the `io_runtime` handle from the global `RuntimeManager`.
            .downcast_ref::<StringViewArray>()
        query_context: QueryTrackingContext,
    {
                        "Failed to rename leaked spill entry {} -> {} (io kind={:?}): {}. \
                        e.kind(),
    // Import the input batch via Arrow C. Because Java retains ownership we re-construct
                           key: String,
    // Distribute global row_ids to per-file local positions.
    let session = &mut *(session_ptr as *mut LocalSession);
                    log::error!("{}", msg);
        return Ok(batch);
    partial_plan_bytes: &[u8],
/// Resolve the dynamic spill limit based on available disk space.
    let handle = &*(session_ctx_handle_ptr as *const crate::session_context::SessionContextHandle);
//!   single thread (node startup/shutdown).
/// coordinator-reduce path uses in [`register_partition_stream`] — instead of trusting the raw
            vec![Arc::new(string_view_array), Arc::new(int_array)],
    // than lingering in tokio's deferred drop queue on an idle runtime.
/// query error. In practice this is unreachable because the needle is not a
        // (MULTI_VALUE_EXPAND_TYPE_URL) places its parquet ReadRel beneath an
///
        let values: Vec<Vec<u8>> = (0..total_rows)
            msg
 */
    Ok(sender.send_blocking(Ok(batch), io_handle))
            object_meta: shard_view.object_metas[seg_ord].clone(),
        let ffi_array = FFI_ArrowArray::from_raw(array_ptr as *mut FFI_ArrowArray);
            }
            "fetch_by_row_ids: result schema missing {}, got {:?}",
                num_rows,
pub unsafe fn register_memtable_on_session_context(
    let provider = Arc::new(ShardTableProvider::new(ShardTableConfig {
    /// CI runs as a non-root user; if you need to verify under root, run the
                    );
            ],
    // which are always data-node work. Keeping the coordinator ungated avoids deadlock
            msg.contains("Failed to enumerate spill directory")
/// [`crate::relabel_exec::RelabelExec`] (zero-copy bit-tag flip per mismatched
        ]));
        if let Some(metrics) = plan.metrics() {
    /// A child-nullability mismatch is NOT layout-equivalent: relabeling a nullable
                Arc::clone(&shard_view.store),
        &schema,
                                    fs::remove_file(&path)
/// (logical-named) output schema — matching what the FINAL binds — so registration carries the
        let has_views = Self::schema_has_views(&stream.schema());
            "original subdir name must be gone (renamed)"
    use crate::query_executor::{store_url_from_table_path, wrap_stream_as_handle_with_plan};
            if c == crate::ROW_ID_COLUMN_NAME {
            .expect_err("view vs offset buffers must not be exported");
    /// Test helper: poll until `predicate` returns true or `timeout_ms` elapses.
        substrait::proto::plan_rel::RelType::Rel(r) => Some(r.clone()),
///
    }
    }
/// # Safety
        files.push(ShardFileInfo {
                input_id, e
        );
    let wire_slice = std::slice::from_raw_parts(ptr as *const WireFileMetadata, count);
        }
                    MetricValue::EndTimestamp(_) => {
    runtime_ptr: i64,
///
    // parallelism. Skip if a prior child already acquired a larger phantom.
        map.insert(
                        }
            "loose top-level file original name must be gone (renamed)"
        permit: Option<tokio::sync::OwnedSemaphorePermit>,
        let _guard = lock_process_globals();
        );
/// The spill directory itself is preserved. It may be a pre-existing mount
    /// Released on drop, which frees partition budget for other queries.
        assert!(ensure_batch_matches_stream_schema(&batch, &wider).is_err());
    // user-facing aliases Java wrote (e.g. "RegionID", "u") and must match what the
    array_data.align_buffers();
            return Err(DataFusionError::Execution(format!(
                shard_view.object_metas.clone(),
    }
        //
        datafusion::physical_plan::Partitioning::Hash(exprs, partition_count as usize);
        };
            // Apply pending phantom correction from the self-correcting budget.
// ---- Memory pool observability and dynamic limit ----
            crate::memory_guard::SpillBudget::Disabled,
        );
///     symlinks, and subdirectories alike) is renamed to a `<name>.stale`
    }
/// boundary never silently truncates values.
/// Uses 80% of available space on the spill directory's filesystem.
            "ts",
/// Java imports every batch against the schema returned once by `stream_get_schema`,
}
    /// Phase 1 (sync rename) must observably move each orphan subdir to a
/// Conforms a producer batch to the consumer-side `StreamingTable` schema.
//! null-checking before calling. Functions that return `i64` return heap-allocated
    let schema = derive_schema_from_partial_plan(partial_plan_bytes)?;
//! corresponding close function exactly once.
                    "(\"{}\" + \"row_base\") AS \"{}\"",
        let link = spill_path.join("escape_link");
    let store: Arc<dyn ObjectStore> = if store_ptr > 0 {
        let tmp = tempfile::tempdir().expect("tempdir");
        .register_table(input_id, Arc::new(table))
    )?;
    let handle = &mut *(stream_ptr as *mut QueryStreamHandle);
static REDUCE_TARGET_PARTITIONS: std::sync::atomic::AtomicUsize =
    spill_limit: i64,
///   the caller; ownership transfers to Rust on success.
    // Extract the substrait-declared output names from Plan.Root.names — these are the
    let mut output: Vec<(i64, i64)> = Vec::with_capacity(partition_count as usize);
/// closes the channel as a clean EOF, so a producer that died mid-stream (e.g. a spill-read failure
            "fetch_by_row_ids: row id {} out of bounds for segment {} (base={}, max_doc={})",
        );
/// Caller must call `stream_close` exactly once to free it.
/// # Writer generations
                let path = entry.path();
        // Include the physical plan display text
/// Calcite *logical* names (`sum_qty`). Registering the streaming table with the raw IPC names
        let struct_array = StructArray::from(array_data);
) -> bool {
}
            "partition_batch_by_hash: hash_key_indices must be non-empty".to_string(),
    /// column must fall through to the pass-through tier and keep its actual field.
        let effective_spill_limit = spill_limit as u64;
        let batch = RecordBatch::try_new(
/// `store_ptr`: 0 = use default LocalFileSystem (hot path),
            };
    let ffi_array = FFI_ArrowArray::from_raw(input_array_ptr as *mut FFI_ArrowArray);
}
    }
    /// test in a user namespace or container that drops the capability.
            Arc::new(Schema::new(vec![Field::new("n", DataType::Int64, false)]));
        let compacted = compact_string_view_columns(sliced);
            seg_idx,
            serde_json::Value::String(plan_text),
        .state()
    }
    #[test]
        .register_table(input_id, Arc::new(table))
    manager: &RuntimeManager,
        while std::time::Instant::now() < deadline {
/// # Safety
    let _guard = manager.io_runtime.enter();
use futures::TryStreamExt;
/// `filenames` are kept in the order supplied by the caller.
            OffsetBuffer::new(vec![0_i32, 1].into()),
        let ctx = datafusion::prelude::SessionContext::new_with_state(state);
///
    // same zero sentinel used for EOF.
            token.clone(),
    if sort_fields.len() != sort_orders.len() {
        };
    use crate::test_process_globals::lock as lock_process_globals;
        Some(RelType::Join(j)) => {
        custom_cache_manager,
        // If phase 1 had followed the symlink during rename, or phase 2 followed
#[derive(Debug, Clone)]
    for part in per_partition {
/// buffer layout differs from that schema is therefore read as garbage (the
                        .downcast_ref()
/// Unlike [`register_partition_stream`] this entry point takes an Arrow IPC schema blob
                        prev, v, i
    // Get the file metadata cache from the custom cache manager
    let cpu_rt_handle = query_tracker::take_cpu_runtime_handle(context_id);
        Some(RelType::Sort(s)) => {
        assert!(
/// the shard's parquet listing.
    #[test]
        context_id,
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
    arrow::datatypes::Schema::new_with_metadata(fields, schema.metadata().clone())
            spill_path.exists(),
        permit: Option<tokio::sync::OwnedSemaphorePermit>,
        let has_views = Self::schema_has_views(&stream.schema());
/// `isUtf8Family` so both sides agree on which divergence is safe to cast.
            }
        ]));
                effective_config,
                            }
        parquet_meta.file_metadata().key_value_metadata(),
    // Overwrite the input FFI structs with the re-exported ones. This is OK because the
        })?;
        // (Arc::clone alone can't infer the supertrait return type).
    if stream_ptr == 0 {
    let state = SessionStateBuilder::new()
                }
        let string_view_array =
    Ok(Box::into_raw(Box::new(session)) as i64)
        // any spill attempt surfaces the upstream "DiskManager is disabled" error
    let schema = parquet_to_arrow_schema(
        .runtime_env()
    let session = &mut *(session_ptr as *mut LocalSession);
            return Err(DataFusionError::Execution(format!(
    let schema_ipc = schema_to_ipc_bytes(schema.as_ref())?;
    sender.fail(DataFusionError::Execution(format!(
    pub object_meta: object_store::ObjectMeta,
        // successfully and the DiskManager must report tmp_files_enabled() == false so
        );
    /// rmdir; the fix wipes contents only.
    // Build file infos with access plans for targeted row retrieval
            Field::new("s", DataType::Utf8View, true),
/// `derive_schema_from_partial_plan`) and must be fixed there, not papered over per
    }
    let table_schema = schema_from_ipc_bytes(schema_ipc)?;
        session.execute_substrait(substrait_bytes),
        let stale_b = tmp.path().join("datafusion-Xy9pQ2.stale");
    if new_limit < 0 {
    // Registers the tracker + cancellation token under context_id in the
    let disk_manager = if spill_dir.is_empty() {
        .unwrap();
            new_limit
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, "", 0).expect("runtime build");
        // reachable with more than one shard since a single shard has no reduce
        }
            .map(|i| format!("long_string_value_{:06}_padding", i))
        let _ = Box::from_raw(ptr as *mut ShardView);
pub fn cancel_query(context_id: i64) {
            stream,
/// positionally (verified — names differ, types/order identical).
/// Uses shared helpers from query_executor for runtime setup, file info building,
    // aborts the CPU task), flush the runtime so the cascading abort of
        use arrow_array::StringArray;
            if let Some(input) = e.input.as_ref() {
        let raw = RecordBatch::from(struct_array);
    fn conform_batch_casts_only_string_view_leaving_timestamp_alone() {
            crate::memory_guard::per_query_spill_budget(),
        let aligned_values = aligned_list
            .as_any()
            .values()
/// and stream wrapping. The fetch-specific logic is building ParquetAccessPlans
/// Safe today because `datafusion.spill_directory` is `NodeScope + Final`, so
        if has_nontrivial_state
        // Lock parent to r+x only — simulates the mount-point parent the JVM doesn't own.
    fn create_global_runtime_unlinks_top_level_symlink_without_following() {
use crate::shard_table_provider::{ShardTableConfig, ShardTableProvider};
    Ok(Box::into_raw(Box::new(ffi_schema)) as i64)
                            format!("{}_matched", name),
}
pub fn get_reduce_target_partitions() -> usize {
            .map_err(|e| {
            OffsetBuffer::new(vec![0_i32, 2].into()),
        if use_indexed {
        let declared: SchemaRef = Arc::new(Schema::new(vec![Field::new(
/// `MessageChannelReader` / `ArrowStreamReader`.
    };
        assert_eq!(
        );
    // Note: Java validates non-empty + ascending row_ids before the FFM call; we don't repeat that here.
        };
    handle
            after_size,
                        stale.display(),
    partial_plan_bytes: &[u8],
 * this file be licensed under the Apache-2.0 license or a
}
        .collect()
        for i in 0..arr.len() {
        .with_config(config)
    Ok(Box::into_raw(Box::new(sender)) as i64)
    // Wrap the output in the same CrossRtStream + RecordBatchStreamAdapter
    writer_generations: Vec<i64>,
                    }
/// name has no `.stale` suffix, so phase 2 cannot collide with it.
    let needs_compaction =
/// Caller must call `close_global_runtime` exactly once to free it.
    }
pub unsafe fn register_partition_stream_on_session_context(
        query_context: QueryTrackingContext,
    if let Some(rt) = cpu_exec.handle() {
/// `HashJoinExec` would produce on the receiver side. Returns `partition_count` output
                        let name = entry.file_name();
                >)
                    let view: &arrow_array::BinaryViewArray = col
        .unwrap();
    for col in columns {
    context_id: i64,
/// This is an async function — the bridge layer decides how to run it
    if array_ptrs.len() != schema_ptrs.len() {
        let batch = RecordBatch::try_new(
/// consumes via Arrow C Data Interface and ships over the analytics shuffle transport.
    }
            _query_tracking_context: query_context,
                        pruning_metrics,
    // Exported VSRs may arrive with batch-level schemas that differ in
        // Restore parent perms via RAII so tempdir cleanup runs even on assertion failure.
    )?;
    let pool = &session.memory_pool();
/// - `array_ptr` must point to a populated `FFI_ArrowArray` struct owned by
    use substrait::proto::rel::RelType;
        let string_view_array = StringViewArray::from_iter_values(std::iter::empty::<&str>());
    // per partition per input batch, but using a Vec<RecordBatch> per partition keeps the
                );
/// Per-file info used by `ShardTableProvider` to inject `row_base` as a
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
    // reference (it is still dropped when `ffi_schema` goes out of scope).
) -> arrow::datatypes::Schema {
            // AND any *.stale leftovers from prior boots whose cleanup didn't
    let partition: Arc<dyn datafusion::physical_plan::streaming::PartitionStream> = Arc::new(
    if ptr == 0 || count == 0 {
        );
            "register_memtable: array_ptrs.len()={} != schema_ptrs.len()={}",
}
    let runtime = DataFusionRuntime {
        return read.base_schema.clone();
}
    let physical_plan =
    .map_err(DataFusionError::Execution)?;
    array_data.align_buffers();
    let table_schema = derive_schema_from_partial_plan(partial_plan_bytes)?;
    // Attach the teardown signal so stream_close releases borrowed input batches before allocator close.
use crate::indexed_executor::execute_indexed_query;
        .build();
    // the underlying memory. The simplest path is to import normally (consuming the FFI
        .with_default_features()
    //
                            log::warn!(
    match result {
        assert_eq!(before_size, after_size);
                    .collect();
    let mut batches = Vec::with_capacity(array_ptrs.len());
    // Catches drift if SQL synthesis or the optimizer ever drops a projection silently.
    // expression. This preserves caller column order and guarantees a single __row_id__
            msg.contains("io kind="),
        set_reduce_target_partitions(-5);
    store_ptr: i64,
            } else {
    }
    )?;
            .columns()
    matches!(t, DataType::Utf8 | DataType::Utf8View)
//
        store_url,
                shard_view,
    /// could escape the spill directory and delete files elsewhere.
pub struct ShardView {
        assert_eq!(
    /// Attaches the task-completion signal `stream_close` joins on before the allocator closes.
            filename
        assert!(nested_file.exists());
    for read in collect_plan_reads(plan) {
            seg.global_base,
    // `from_ffi` takes the array by value (consumes it) and the schema by
                    }
//! All functions in this module use plain Rust types — no FFI-specific types.
        assert!(Arc::ptr_eq(out.column(0), &col));
use datafusion::physical_plan::metrics::MetricValue;
        let table = MemTable::try_new(arrow_schema, vec![vec![]])?;
/// Returns the current memory pool limit in bytes.
/// from — the shipped record batches arrive over the wire pre-typed, and the caller computes
        // Cleanup failure is operator-actionable (permissions, RO mount, I/O) and
//! - `init_runtime_manager` and `shutdown_runtime_manager` must be called from a
    use prost::Message;
    fn create_global_runtime_cleans_prior_boot_stale_entries() {
        return Err(DataFusionError::Execution(
            }
        let batch = match batch_res {
        return Err(DataFusionError::Execution(format!(
    })?;
        ));
        assert!(
        let before_size = sliced.column(0).get_array_memory_size();
                    }
pub unsafe fn sender_terminate_early(sender_ptr: i64) {
        } else {
}
    }
    // column in the result.
/// the join/agg) instead of a clean EOF, then takes ownership of the sender and drops it (the same
            "str_col",
/// 3. Utf8/Utf8View: a real value-preserving cast, because their buffer layouts differ.
        assert!(
        }
            .column(0)
            if let Some(input) = &s.input {
        DataFusionError::Execution(format!(
        } else {
                    }
        set_reduce_target_partitions(4);
        batch
    // pull_from_input tasks (holding GroupValues buffers) is processed now rather
    // in single-JVM test topologies where coordinator and data node share a gate.
                collect_reads(input, out);
                     borrowed buffers; proceeding with allocator close (possible leak)"
            .expect("equivalent LIST child names align");
                log::warn!(
    for plan_rel in &plan.relations {
                let entry = entry.map_err(|e| {
            .map_err(|e| {
    }
impl DataFusionRuntime {
        let schema = listing_options
        } else {
        }
/// `CrossRtStream` + `RecordBatchStreamAdapter` shape as `execute_query`,
/// without being forgotten).
    // the registry, making it unreachable for flush_cpu_runtime.
        let cleaned = wait_until(2000, || !stale_a.exists() && !stale_b.exists());
        // its lowered output schema as substrait extension metadata so the
    }
        })
            get_reduce_target_partitions(),
        assert!(ptr > 0);
                })?;
                "Dynamic spill limit: {} bytes (80% of {} available on {})",
    plan: &substrait::proto::Plan,
        let runtime = unsafe { &*(ptr as *const DataFusionRuntime) };
        )
    }
/// (kill -9, OOM-kill, container restart) which would otherwise accumulate
        assert!(!nested_file.exists(), "nested leaked file must be removed");
        let string_view_array = StringViewArray::from_iter_values(strings.into_iter());
    if !needs_compaction {
                    | MetricValue::Gauge { .. }
/// `session_ptr` must be a valid, non-zero pointer returned by
        let spill_path = tmp.path().join("spill");
/// This is an async function — the bridge layer decides how to run it.
                        "Failed to read spill directory entry in {} (io kind={:?}): {}",
/// catalog is the source of truth. The generation is later passed to
    let array_data_result = arrow_array::ffi::from_ffi(ffi_array, &ffi_schema);
        map: &mut serde_json::Map<String, serde_json::Value>,
        .cache_manager
            }
    // Post-condition: returned stream schema must contain __row_id__ plus every requested column.
    for plan_rel in &plan.relations {
                    "Failed to enumerate spill directory {} (io kind={:?}): {}. \
    // context so those operators can register with the reactor.
                                continue;
        fs::write(&sentinel, b"stale spill data").expect("seed sentinel");
    // arrow_array::ffi::from_ffi takes ownership of the FFI structs (via FFI_ArrowArray
            sort_fields.len(),
            get_reduce_target_partitions(),
                    input_id, e
    /// stream is closed.
        );
        // Spill root itself must remain (cleanup wipes children only).
    /// inline recursive removal would be flagged.
pub unsafe fn sql_to_substrait(
        .with_task_done(task_done);
///
        let declared: SchemaRef =
        list_file_cache.put(
    for (seg_ord, seg) in segments.iter().enumerate() {
use arrow_schema::SchemaRef;
///
    use parquet::file::metadata::ParquetMetaData;
            StringViewArray::from_iter_values(strings.iter().map(|s| s.as_str()));
            DataType::List(actual_child),
        result.push(FileRowMetadata {
        );
        .with_config(SessionConfig::new())
        assert!(
            row_base += num_rows as i64;
        fs::write(leftover.join("residue.arrow"), b"prior boot data").expect("write residue");
    );
                coerced.metadata().clone(),
                    .downcast_ref()
/// Creates a native reader (ShardView) for the given path and files.
            }
        fs::create_dir(&leftover).expect("create leftover");
 * compatible open source license.
// 10KB: below this, the gc() copy cost outweighs the transfer savings.
        })?;
            get_reduce_target_partitions(),
                    return Err(DataFusionError::Configuration(msg));
        permit: Option<tokio::sync::OwnedSemaphorePermit>,
        if let Some(mgr) = crate::ffm::try_get_rt_manager() {
        let _ = Box::from_raw(ptr as *mut DataFusionRuntime);
            }
/// suffix in phase 2 also cleans up `*.stale` leftovers from any prior boot
        let default_rt = RuntimeEnvBuilder::new().build()?;
        let top_file = tmp.path().join("top.tmp");
        let out = super::conform_batch_to_schema(batch, &declared).unwrap();
        .map(|_| Vec::with_capacity(1))
                "partition_batch_by_hash: hash key index {} out of range for {}-column schema",
/// Hash-partitions one [`RecordBatch`] by the columns at `hash_key_indices` into
            _concurrency_permit: permit,
        // Phase 2: remove_file on a symlink unlinks the link itself, never the target.
        let sliced = full_array.slice(0, 100);
        let (_pool, handle) = DynamicLimitPool::new(0);
    let (sender, receiver) = crate::partition_stream::channel(Arc::clone(&table_schema));
//!
            last_seen = Some(v);
        query_context: QueryTrackingContext,
        let full_path = if filename.starts_with('/') || filename.contains(base_path) {
}
    let (df_stream, physical_plan) = cancellation::cancellable(
    /// Total rows in this file.
    array_ptrs: &[i64],
            false,
    internal_search: crate::datafusion_query_config::InternalSearch,
        }
            )])),
        } else {
            schema_ptrs.len()
/// # Safety
    use datafusion::execution::cache::CacheAccessor;
            Err(e) => return Err(e),
/// `ptr` must be 0 or a valid pointer returned by `create_global_runtime`.
    fn create_global_runtime_clears_leaked_spill_files_recursively() {
                full_array.total_buffer_bytes_used()
    // is irrelevant — no spill to throttle. One statvfs call (~1µs) only when enabled.
    let table_path = shard_view.table_path.clone();
                        let prev = map
        return Err(format!(
    context_id: i64,
            .parquet
                Field::new("n", DataType::Int64, false),
            // names/metadata (parquet emits `List<element>`, Substrait declares
///
///
        assert!(
        runtime,
}
/// On error ownership is released back to Rust's drop impls (the imported
            continue;
    has_views: bool,
//! The FFM bridge (`ffm.rs`) calls into these functions directly.
        set_reduce_target_partitions(1);
    let result = cancellation::cancellable(
        let mut map = serde_json::Map::new();
    session.register_memtable(input_id, table_schema, batches)?;
    // Create per-query context (auto-registers in the global registry) and extract
/// effectively disables adaptive reduction.
            // against a wedged task hanging the reduce thread. If it fires we proceed anyway and
    session_ptr: i64,
use std::sync::Arc;
    manager: &RuntimeManager,
        let arr = col
        ))
        let slice_rows = 10usize;
                                    "Background spill cleanup: failed to stat {} (io kind={:?}): {}",
        assert!(
            eprintln!(
            .map_err(|e| DataFusionError::Execution(format!("Substrait encode failed: {}", e)))?;
/// error instead of native memory corruption.
    // shape as `execute_query`, so existing `stream_next` / `stream_close`
/// and a handle to change the memory pool limit at runtime.
///
/// Cheap check: scan the substrait plan bytes for the `index_filter` function
        let mgr = unsafe { *Box::from_raw(cache_manager_ptr as *mut CustomCacheManager) };
///   by the caller; ownership transfers to Rust on success.
            // Utf8 offsets: "Offset buffer for type Utf8 is malformed", surfacing as
/// returns its physical output schema **narrowed via
    };
        })?;
    /// `create_global_runtime` also replaces the global `RuntimeEnv` registration and
                a.data_type(),
                        let v = m.value().as_usize() as i64;
            DataFusionError::Execution(format!("partition_batch_by_hash: export failed: {}", e))
                    };
/// trip (Arrow's `TimeUnit` enum is closed at four variants, so this
                arrow::datatypes::DataType::Binary | arrow::datatypes::DataType::List(_)
    reads
/// - `array_ptrs` and `schema_ptrs` must point to populated FFI structs owned
    schema_ipc: &[u8],
    runtime: &DataFusionRuntime,
        assert_eq!(aligned.schema(), expected_schema);
    if hash_key_indices.is_empty() {
                    "stream_close: timed out after 30s waiting for the reduce CPU task to release \
                Arc::new(TimestampNanosecondArray::from(vec![10i64, 20])),
        .unwrap();
}
            .with_cache_manager(cache_manager_config)
        let _ = ctx.register_table(&table_name, Arc::new(table));
    )
/// Anything else (e.g. timestamp precision) keeps its actual field and column so this
                Arc::new(view.gc()) as Arc<dyn Array>
    let mut result = Vec::with_capacity(count);
                    want.data_type(),
    let target_schema = Arc::new(arrow_schema::Schema::new_with_metadata(
            let limit = (available as f64 * FRACTION) as u64;
use datafusion::prelude::{SessionConfig, SessionContext};
                                    fs::remove_dir_all(&path)
///
        // create_global_runtime must clear the directory recursively (files AND
    // to the physical plan's output schema, matching what isthmus declared on the wire
        session.memory_pool(),
    if let Some(rx) = task_done {
        let schema = crate::schema_coerce::coerce_inferred_schema(schema);
        return Err(DataFusionError::Execution(format!(
        let err = ensure_batch_matches_stream_schema(&batch, &mk("item", DataType::Utf8))
                    dyn opensearch_tiered_storage::tiered_object_store::MetadataCachingStore,
/// Each `row_group_row_counts_ptr` must point to `num_row_groups` consecutive i64 values.
        }
}
    use substrait::proto::{read_rel::ReadType, Plan};
        },
/// schema as IPC bytes so the Java side can validate fed batches against it.
    // structs from Rust's perspective) but mark them not-released by overwriting the
        use arrow_schema::{Field, Schema, TimeUnit};
    if sender_ptr != 0 {
                    MetricValue::PruningMetrics {
/// substrait via [`derive_schema_from_partial_plan`] — the SAME derivation the
                collect_reads(input, out);
            !top_file.exists(),
                        build_row_selection_with_min_skip_run(&rg_bitmap, rg.num_rows as usize, 1);
    Box::pin(RecordBatchStreamAdapter::new(schema, checked))
}
                        let result = match entry.file_type() {
        let spill_path = parent.path().join("spill");
    _query_tracking_context: QueryTrackingContext,
        }
    schema: &arrow::datatypes::Schema,
    if schema.column_with_name(crate::ROW_ID_COLUMN_NAME).is_none() {
    // means a single ordered execution, so the check is global, not per-batch only.
        // recursive removal (a shallow delete would miss the nested file).
                limit,
            )
    ///   - Indexed path (`indexed_executor`): when the query's leading ORDER BY runs counter
        let cleaned = wait_until(2000, || !stale.exists());
        substrait::proto::plan_rel::RelType::Root(rr) => rr.input.as_ref().cloned(),
        // no synthetic MemTable is registered for it, and planning the producer
            DataFusionError::Execution(format!(
/// would nuke active spill state — rethink before adding one.
            .with_disk_manager_builder(disk_manager)
                collect_reads(input, out);
//! - `stream_get_schema`, `stream_close` must NOT be called
        try_acquire_budget_from_cache(shard_view, runtime, global_pool, &cfg)
            mode: u32,
                    "Failed to spawn background spill cleanup thread: {}. \
        } else {
            Field::new("ts", DataType::Timestamp(TimeUnit::Millisecond, None), true),
/// Returns the Arrow schema for the given stream as a heap-allocated FFI_ArrowSchema pointer.
        df_stream,
/// batches (some may be zero-row) as parallel `(array_ptr, schema_ptr)` pairs the JVM
            "background cleanup must remove both .stale entries within 2s"
        shard_view.writer_generations.as_ref(),
    let session = &*(session_ptr as *const LocalSession);
/// scan registered, so the join's two `NamedScan`s resolve against streaming tables alongside
) -> Result<i64, DataFusionError> {
                Field::new("s", DataType::Utf8, true),
            out.column(1).data_type(),
    Ok((Box::into_raw(Box::new(sender)) as i64, schema_ipc))
    })?;
        .get_file_metadata_cache();
    array_ptrs: &[i64],
    // shared Arc'd memory; from_ffi's ArrayData copy is a refcount-clone, not a deep copy.
                })
            stream,
                    col.data_type(),
/// >0 = `Box<Arc<dyn MetadataCachingStore>>` pointer (routes reads through TieredObjectStore;
        );
        use arrow_schema::{Field, Schema, TimeUnit};
        let ffi_schema = FFI_ArrowSchema::from_raw(schema_ptr as *mut FFI_ArrowSchema);
                        };
/// No-op for unknown or already-completed queries.
}
                    MetricValue::Ratio { .. }
    /// Keeps the SessionContext alive while the stream is being consumed.
    query_tracker::cancel_query(context_id);
    let batch_size = session.batch_size();
        .columns()
    use datafusion::prelude::SessionContext;
        }
            for entry in entries {
        let sliced = batch.slice(0, slice_rows);
/// `session_ptr` must be a valid, non-zero pointer returned by
        Some(RelType::Read(r)) => out.push((**r).clone()),
            path: &'a std::path::Path,
/// False positives take the indexed path and then fail in
            columns.push(cast);
            return;
    }
            .encode(&mut buf)
                DataFusionError::Execution(format!(
            if arr.is_null(i) {
    // would skip the cross_rt drop+drain cleanup and leak the aggregate's in-flight GroupValues.
/// Imports an Arrow C Data batch and pushes it through the partition
        let msg = err.to_string();
            let info = ShardFileInfo {
    }
    // Take ownership of the Java-allocated FFI structs. `from_raw` reads
                ))
        assert_eq!(
            ))
        let mut locked = fs::metadata(parent.path())
    pub num_rows: u64,
pub unsafe fn register_partition_stream_on_session_context_from_partial_plan(
    for (i, want) in declared.fields().iter().enumerate() {
        )));
        ctx: datafusion::prelude::SessionContext,
            continue;
        return Ok(());
    }
use datafusion::execution::disk_manager::{DiskManagerBuilder, DiskManagerMode};
        shard_view.object_metas.as_ref(),
    });
        let schema = Arc::new(Schema::new(vec![Field::new(
    }
        assert!(
        // Simulate a leaked spill file from a prior non-graceful shutdown.
                            name,
/// each partition's left/right input on the same session that already has the local shard
    Ok(metas)
            "create_reader: filenames ({}) and writer_generations ({}) must have the same length",
                            log::warn!(
/// Closes a native reader. Safe to call with 0 (no-op).
    if memory_pool_limit < 0 {
        self.task_done = Some(task_done);
}
        .relations
    let wrapped = RecordBatchStreamAdapter::new(cross_rt_stream.schema(), cross_rt_stream);
/// recursive unlinks happen in parallel with cluster join. Re-scanning by
                        name,
                    input_id, e
        assert_eq!(aligned_values.value(0), "prod");
        // Matching column keeps its original Arc (no copy).
        files,
            Some(ParquetAccessPlan::new_none(num_rgs))
///     via `remove_dir_all`.
    // Same teardown signal as execute_local_plan.
    };
/// (memory pool, disk manager, and caches are shared).
        assert!(
    for (&array_ptr, &schema_ptr) in array_ptrs.iter().zip(schema_ptrs.iter()) {
        };
/// # Safety
    })?;
        query_tracker::flush_cpu_runtime_with_handle(&rt, context_id);
/// we cannot rename orphans now, queries that need to spill would fail
    pub row_group_row_counts_ptr: i64,
    store: &dyn object_store::ObjectStore,
        fs::create_dir(&leaked_a).expect("create leaked a");
/// Converts SQL to Substrait plan bytes (test only).
    let batch = RecordBatch::from(struct_array);
        let ptr = result.expect("runtime build must succeed when only the parent is read-only");
            dynamic_limit_handle: handle,
    use crate::indexed_table::segment_info::build_segments;
        (CacheManagerConfig::default(), None)
        assert_eq!(view.value(0), "a");
/// handle automatically marks the query completed in the registry.
        timer,
                                }
use object_store::{ObjectStore, ObjectStoreExt};
        // Same layout, different child name: fine.
        .as_any()
    *out_ptr = runtime.runtime_env.memory_pool.reserved() as i64;
                    crate::ROW_ID_COLUMN_NAME
    };
                || msg.contains("Failed to clear leaked spill entry"),
            .unwrap();
        let aligned = conform_batch_to_schema(batch, &expected_schema)
        .build();
    partitioner.partition(batch, |partition_idx, sub_batch| {
    use prost::Message;
    Ok(Box::into_raw(Box::new(sender)) as i64)
        // Seed leaked entries: a datafusion-* subtree (kill -9 leftover) and a loose file.
        );
                    panic!(
                spill_dir,
/// stragglers are reaped on the next boot.
                }
    // more (partition_index, sub_batch) calls — we accumulate, then export each as one
    }
                &effective_config,
        {
    .await
            // Failing boot here would be more disruptive than the wasted disk.
    if sender_ptr == 0 {
                    spill_dir,
fn resolve_effective_config(
    // not as part of a stream of partitioned batches, so the input "partition index" is 0 of 1.
/// (specifically `BroadcastInjectionHandler`) ships the build-side memtable
    }
                            pruning_metrics.pruned() as i64,
    }
                "Failed to get object meta for {}: {}",
    if Arc::ptr_eq(&actual, expected) {
    )?;
        assert!(err.to_string().contains("misread buffers"), "{err}");
    let ffi_array = FFI_ArrowArray::from_raw(array_ptr as *mut FFI_ArrowArray);
// `execute_query` returns).
    crate::cache::page_index::set_whole_region_fetch_enabled(store_ptr > 0);
//! to the corresponding Rust type. The caller (bridge layer) is responsible for
        if euid == 0 {
/// a physical plan and reading its output schema — that is the schema the
        for child in plan.children() {
    let store = ctx
                 would silently succeed and the test would assert nothing"
        assert!(view.is_null(1));
    // batch. stream_close's teardown barrier releases that borrow before the allocator closes.
    /// Per-shard object store. When a native store is provided (store_ptr > 0),
/// Enables `row_base` computation without re-reading parquet footers.
            "tags",
    // The producer may emit a string column as plain Utf8 where the declared
                .stream
pub unsafe fn get_memory_pool_limit(ptr: i64) -> i64 {
        // as a phantom "disk pressure" signal and clamp every query to 1 partition.
            Field::new("str_col", DataType::Utf8View, false),
            DataFusionError::Execution(format!("Failed to import Arrow C Data array: {}", e))
    .await
        let _guard = lock_process_globals();
            }
    // Re-export so the caller's Java-side close on the input wrappers still has a release
        object_metas.len(),
            row_group_row_counts: seg.row_groups.iter().map(|rg| rg.num_rows as u64).collect(),
    pub access_plan: Option<datafusion::datasource::physical_plan::parquet::ParquetAccessPlan>,
    let physical_plan = df.create_physical_plan().await?;
        let sender = &*(sender_ptr as *const PartitionStreamSender);
        let stale = tmp.path().join("leaked_from_prior_run.tmp.stale");
                "skipping create_global_runtime_succeeds_when_jvm_does_not_own_spill_parent: \
        // not the 64-byte alignment DataFusion's SIMD kernels require. align_buffers() is
/// Per-file metadata passed from Java at shard view creation time.
        let spill_path = tmp.path().to_str().expect("utf-8 path");
/// registers them as an in-memory table on the given session under `input_id`.
    /// Walks the tree recursively, collecting metrics from every node.
                format!("\"{}\"", c)
        &mut query_context,
                let name_str = name.to_string_lossy();
        .zip(schema.fields().iter())
    };
/// or cancelled.
/// Why this matters (the q1/q15 fix): DataFusion's Substrait consumer binds a `NamedTable`
            DataType::Utf8View,
}
        let cleaned = wait_until(2000, || !stale_loose.exists() && !stale_dir.exists());
        let batches_in_pipeline = budget.target_partitions * 3 + 2; // partitions × multiplier + output channel(2)
            }
    })?;
                    perms.set_mode(self.mode);
    let cpu_executor = manager.cpu_executor();
            None,
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, spill_path, 1024 * 1024 * 1024)
        query_context.set_phantom_reservation(budget.phantom_reservation);
/// When the budget reduces parallelism under memory pressure, it will not
        } else {
/// `QueryStreamHandle` pointer whose output can be drained via the existing
/// `ptr` must be 0 or a valid pointer to `count` consecutive `WireFileMetadata` structs.
        let meta = store.head(&path).await.map_err(|e| {
            Vec::new()
    )? {
    Ok(())
            tmp.path().exists(),
                }
            false,
        let stale_dir = spill_path.join("datafusion-aB3kF7.stale");
            before_size > after_size * 100,
            )));
                .map_err(|e: DataFusionError| e)
            cleaned,
fn derive_schema_from_partial_plan(
            limit
        current_partitions,
    }
/// `partition_count` buckets, using DataFusion's repartition seed
            task_done: None,
/// The `io_handle` is the Tokio handle used to drive the blocking send;
    drop(handle);
use datafusion::common::DataFusionError;
            df_stream,
///
            // Phase 2: spawn the recursive deletion of all *.stale entries.
/// - `session_ctx_handle_ptr` must be a valid, non-zero pointer returned by
    let schema = batch.schema();
///
#[repr(C)]
            has_views,
    // Pointer type is `Arc<dyn MetadataCachingStore>` (since 2026-06); trait-upcast to
                            continue;
    let mut row_base: i64 = 0;
    permit: Option<tokio::sync::OwnedSemaphorePermit>,
        let aligned = RecordBatch::try_new(Arc::clone(&table_schema), raw.columns().to_vec())
            _concurrency_permit: permit,
        assert!(
/// is monotonically nondecreasing, including across batch boundaries. No-op in release.
    const FRACTION: f64 = 0.80;
                &shard_view.sort_fields,
/// Utf8 / Utf8View — the string-view family whose two variants share byte-identical
}
/// released after the batch is produced (or on cancellation/end-of-stream).
            },
use std::path::PathBuf;
            "DiskManager cap must equal the positive spill_limit passed in"
        ]));
            let counts_ptr = wire.row_group_row_counts_ptr as *const i64;
/// Java tripwire (`typesMatch` in DatafusionReduceSink) can validate batches
    // A Java-supplied store (store_ptr > 0) is a remote/warm store: fetch the whole
        let compacted = compact_string_view_columns(batch.clone());
///       trait upcasts to `dyn ObjectStore` for DataFusion APIs that take `Arc<dyn ObjectStore>`).
        }
) -> Result<(), DataFusionError> {
        let deadline = std::time::Instant::now() + std::time::Duration::from_millis(timeout_ms);
        // briefly for phase 2 to clear the *.stale entries.
/// probe-side `BroadcastInjectionHandler` runs against the same `SessionContextHandle` that
            fs::read(&outside).expect("read outside file"),
                // symlinks, and directories — fs::rename does not follow
pub unsafe fn execute_local_prepared_plan(
    let global_pool = runtime.runtime_env.memory_pool.clone();
            spill_limit
        }
        let bad_path_str = bad_path.to_str().expect("utf-8 path");
    // or List state for sub-32-bit bitmap accumulators). Use Partial schema + Root.names so
        assert_eq!(out.schema().as_ref(), declared.as_ref());
/// `register_partition_stream`.
/// catalog snapshot (`WriterFileSet.writerGeneration` and `WriterFileSet.files()`); the
    /// Returns execution metrics from ALL operators in the physical plan tree as JSON bytes.
    // from here.
                                spill_path_for_gc.display(), e.kind(), e
    // the coordinator sees the correct wire type.
    }
    fn conform_keeps_actual_field_when_list_child_nullability_differs() {
            panic!(
/// The split keeps boot fast even with tens of GB of orphan spill data: the
    let partitioning =
                                    path.display(), e.kind(), e
/// (`block_on` for synchronous FFM entry, `spawn` for async delivery).
    ///
            "Non-sliced array must NOT need gc"
        assert!(
fn schema_from_ipc_bytes(bytes: &[u8]) -> Result<SchemaRef, DataFusionError> {
    // cache, subsequent queries benefit).
    for wire in wire_slice {
    _concurrency_permit: Option<tokio::sync::OwnedSemaphorePermit>,
///   `create_local_session`.
        stream: RecordBatchStreamAdapter<CrossRtStream>,
        assert_eq!(
    // Use the handle's OWN token, not a registry lookup by context_id. The
        .map_err(|e| DataFusionError::Execution(format!("schema_from_ipc_bytes: {}", e)))?;
/// FFM wire format for per-file metadata.
/// Bundles a stream with its query tracking context so that dropping the
    match rel.rel_type.as_ref() {
                path: table_path.prefix().clone(),
            )));
    }
        assert!(
        // The build-side IPC payload arrives via Java's ArrowStreamReader, which produces
            DataType::Timestamp(TimeUnit::Millisecond, None),
    use arrow::ipc::writer::StreamWriter;
use std::collections::HashMap;
        Self {
/// `stream_ptr` must be a valid, non-zero pointer to a QueryStreamHandle.
    spill_dir: &str,
        let batch =
    match root.rel_type.as_ref()? {
                DataType::Timestamp(TimeUnit::Millisecond, tz.clone()),
/// path) — unreachable in practice because the needle is not a valid DataFusion
/// # Ordering
    array_ptr: i64,
        )
                DataFusionError::Execution(format!(
                available,
                .collect();
            format!("{}/{}", base_path.trim_end_matches('/'), filename)
    // join's null-fill side yields Utf8 while the live side yields Utf8View. The
        )]));
        let spill_path = tmp.path().to_str().expect("utf-8 path");
//!   concurrently on the same stream pointer.
                            );
                Arc::new(StringArray::from(vec![Some("a"), None, Some("c")])),
    pub sort_fields: Vec<String>,
    /// *.stale name. Phase 2 then removes the *.stale entries asynchronously.
    cfg.target_partitions = disk_capped_partitions;
        let outer_subdir = tmp.path().join("subdir");
            &DataType::Timestamp(TimeUnit::Nanosecond, None)
                    view_needs_gc(view.data_buffers(), view.total_buffer_bytes_used())
                context_id,
    /// Writer generation per file, parallel to `object_metas`. Sourced from the Java-side
///
) -> Result<(), DataFusionError> {
    let mut per_partition: Vec<Vec<RecordBatch>> = (0..partition_count as usize)
        serde_json::to_vec(&map).ok()
        // would truncate sub-ms precision — the Java tripwire tolerates this as advisory, so
pub struct DataFusionRuntime {
                                continue;
}
        // synchronously; phase 2 unlinks it asynchronously. The original name
                as *const Arc<
    partial_plan_bytes: &[u8],
                input_id, e
            _ => Arc::clone(col),
    }
    }
        plan: Arc<dyn datafusion::physical_plan::ExecutionPlan>,
            .with_runtime_env(Arc::from(runtime_env))
                .collect()
        !segments.is_empty(),
        })?;
        let view = out
    let df = ctx.sql(&sql).await?;
/// This is an async function — the bridge layer decides how to run it
/// execution so `cancel_query()` can interrupt it even during planning.
    }
/// Creates a DataFusion global runtime with the given resource limits.
            if let Err(e) = std::thread::Builder::new()
}
    }
                );
        )));
            false,
    let timer = datafusion::physical_plan::metrics::Time::default();
/// is the only precision that needs coercion).
/// name. If the planner emitted any `index_filter(bytes)` UDF call, the name
        .find_map(|pr| {
/// `List<Utf8>` vs `List<Utf8View>` JVM SIGSEGV). DataFusion guarantees that a
    schema_ipc: &[u8],
                            );
///
        set_reduce_target_partitions(1000);
}
///   `create_session_context` (or `create_session_context_indexed`).
/// (`sum_qty[sum]`) therefore fails the FINAL's by-name lookup with `No field named sum_qty`.
    // Align buffers — Java IPC produces 8-byte alignment but DataFusion's SIMD paths want
                .map(|(f, name)| {
            None,
        return Err(DataFusionError::Configuration(format!(
        assert!(
/// mount point. Callers wanting auto-creation must grant write on the parent.
/// phase 1 (which renames the link, never the target) and unlinked in
    std::sync::atomic::AtomicUsize::new(4);
/// `shard_view_ptr` and `runtime_ptr` must be valid, non-zero pointers.
/// `create_local_session`.
    let use_indexed = use_indexed_path(plan_bytes);
        ]));
        let mk = |child_name: &str, child_ty: DataType| {
    /// DataSourceExec skips row groups and applies RowSelection.
        )
        table_path: table_url,
        .collect();
    let ffi_schema = FFI_ArrowSchema::try_from(schema.as_ref())
    let mut array_data = arrow_array::ffi::from_ffi(ffi_array, &ffi_schema).map_err(|e| {
                full_path, e
        assert!(
/// `out_ptr` must point to a buffer of at least 2 i64 values.
// ── QTF fetch-phase assertion helpers (kept at the bottom of the file) ────────
/// This sweeps `datafusion-*/` orphans left by a non-graceful shutdown
    // input_partition=0 / num_input_partitions=1 — we partition each batch independently here,
/// Fails a partition stream so the consumer's `RecordBatchStream` yields a terminal ERROR (failing
        let before_size = sliced.columns()[0].get_array_memory_size();
    if actual.fields().len() != expected.fields().len() {
            };
            .as_any()
    let schema = handle.stream.schema();
        plan: &dyn datafusion::physical_plan::ExecutionPlan,
/// # Safety
    let ctx = SessionContext::new_with_state(state);
    /// Held for its `Drop` impl — marks the query completed when the
    let runtime = &*(ptr as *const DataFusionRuntime);
            array_ptrs.len(),
fn collect_plan_reads(plan: &substrait::proto::Plan) -> Vec<substrait::proto::ReadRel> {
            let array_data = struct_array.into_data();
        //
            row_group_row_counts: rg_counts,
        assert_eq!(out.column(1).data_type(), &DataType::Int64);
/// `sender_ptr` must be 0 or a valid pointer returned by
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, "", 0).expect("runtime build");
    ))
            );
    .ok()
    }
    // DataFusion's execute_stream is sync, but kicks off RepartitionExec /
                .try_next()
    let expected_schema = handle.stream.schema();
    // (sender/StreamingTable) schema is Utf8View, or vice versa — e.g. an outer
    let token = query_tracker::get_cancellation_token(context_id);
    let sql = format!("SELECT {} FROM t", projection);
/// Sets the memory pool limit at runtime. Takes effect for new allocations only.
    let task_done = handle.task_done.take();
/// query-tracking context + cancellation token under `context_id` so the
    if filenames.len() != writer_generations.len() {
            } else {
            custom_cache_manager: None,
///   `create_session_context` (or `create_session_context_indexed`).
/// `ptr` must be a valid pointer returned by `create_global_runtime`.
                    let entries = match fs::read_dir(&spill_path_for_gc) {
    use substrait::proto::read_rel::ReadType;
        Ok(())
    pub dynamic_limit_handle: DynamicLimitHandle,
}
                        // unlinks the link itself without following it.
        let total_rows = 10_000usize;
        Vec::with_capacity(hash_key_indices.len());
    if !cfg!(debug_assertions) {
                true,
    // The doc-values cursor is opened from Lucene with only a file path, so it reads the environment
    pub row_group_row_counts: Vec<u64>,
        //    *.stale entry — `remove_file` for files and symlinks (so we
// Coordinator-reduce local execution API
                        e
        writer
/// from row IDs and computing global __row_id__ = __row_id__ + row_base in SQL.
    /// Optional access plan for targeted row retrieval (QTF fetch phase).
        );
            DataFusionError::Execution(format!(
///
    if ptr != 0 {
    // not normal end-of-stream: callers must receive an error rather than the
        assert!(link.is_symlink(), "precondition: link is a symlink");
    let actual_schema = batch.schema();
        // Empty spill_dir is the "disabled" sentinel from Java. The runtime must build
        let spill_path = tmp.path().to_str().expect("utf-8 path");
/// Acquires a partition gate permit before polling the stream. The permit is
        file_metadata: None,
        let strings: Vec<String> = (0..total_rows)
    // release fn pointers... however that's brittle. Instead we copy the batch's columns
use crate::cross_rt_stream::CrossRtStream;
        locked.set_mode(0o555);
                collect_reads(right, out);
        // Phase 2: *.stale entries cleaned by the background thread.
        cfg.batch_size = budget.batch_size;
                // cleanup didn't finish — phase 2 below picks them up.
                DataType::Timestamp(TimeUnit::Nanosecond, None),
        // Register spill directory for per-query disk pressure checks
        );
        futures::executor::block_on(session_state.create_physical_plan(&logical_plan))?;
        use arrow_array::{TimestampMillisecondArray, TimestampNanosecondArray};
        CrossRtStream::new_with_df_error_stream_cancellable(
    use std::io::Cursor;
    }));
        std::os::unix::fs::symlink(&outside, &link).expect("create symlink");
///
            task_done: None,
/// structs go out of scope without being forgotten).
        session.set_phantom(budget.phantom_reservation);
    Ok(wrap_stream_as_handle_with_plan(
                        add(map, other.name().to_string(), other.as_usize() as i64);
            Arc::clone(boxed);
    }
    }
    } else {
            .with_mode(DiskManagerMode::Directories(vec![PathBuf::from(spill_dir)]))
                table_name.to_string(),
            std::slice::from_raw_parts(counts_ptr, num_rgs)
        );
    let current_partitions = session.target_partitions();
    // Construct DataFusion's BatchPartitioner — exactly the type RepartitionExec uses
            ))
    let mut fields = Vec::with_capacity(batch.num_columns());
        plan: Arc<dyn datafusion::physical_plan::ExecutionPlan>,
                     Renamed *.stale entries will accumulate until the next successful boot.",
        return batch;
    /// Lock for tests that mutate `memory_guard`'s global SPILL_ENABLED / SPILL_DIR or that
            // pressure) and not boot-fatal: the disk is already in a valid
    }
            fn drop(&mut self) {
        let path = object_store::path::Path::from(full_path.as_str());
/// [`crate::session_context::SessionContextHandle`] — the M2 hash-shuffle worker registers
            .map_err(|e| DataFusionError::Execution(format!("StreamWriter::try_new: {}", e)))?;
                }
        // Non-divergent column is untwiddled.
        struct RestorePerms<'a> {
            .as_any()
            log::info!(
    let mut per_segment: HashMap<usize, RoaringBitmap> = HashMap::new();
fn collect_reads(rel: &substrait::proto::Rel, out: &mut Vec<substrait::proto::ReadRel>) {
/// channel binds the FINAL plan to the registered (logical) names and accepts the batches
    use datafusion::execution::cache::cache_manager::CachedFileList;
        let rg_counts = if wire.row_group_row_counts_ptr == 0 || num_rgs == 0 {
                .spawn(move || {
fn compact_string_view_columns(batch: RecordBatch) -> RecordBatch {
}
            // are also rewritten to view types. DataFusion's non-recursive
        );
    // fails later with a schema/batch type mismatch. Cast ONLY those columns to
            cleaned,
    REDUCE_TARGET_PARTITIONS.load(std::sync::atomic::Ordering::Acquire)
    );
        partitioning,
    // `context_id` of 0 disables tracking (pool is not consulted) and no
        let mut writer = StreamWriter::try_new(&mut buf, schema)
    /// double-suffix them (no datafusion-old.stale.stale).
        let ffi_schema = FFI_ArrowSchema::from_raw(schema_ptr as *mut FFI_ArrowSchema);
            ))
/// registers here — no per-batch cast needed at the partition-stream feed.
    // path that task still holds Java-borrowed input batches. Wait for it to fully unwind (signal
    let store_url = store_url_from_table_path(&shard_view.table_path)?;
                batch
                query_memory_pool,
    }
    fn create_global_runtime_with_empty_spill_dir_does_not_touch_filesystem() {
/// 1. Exact type match: reuse the column, adopt the declared field (metadata agrees).
/// If `context_id != 0`, registers a cancellation token in ACTIVE_QUERIES before
                        let name = m.value().name().to_string();
    // by value). Java's expectation is that ownership of the input does NOT transfer. We
            declared.fields().len()
        let table_name = nt.names.last().cloned().unwrap_or_default();
            runtime.runtime_env.disk_manager.tmp_files_enabled(),
        let arrow_schema = crate::schema_coerce::coerce_inferred_schema(Arc::new(arrow_schema));
        // coordinator skips this throwaway lowering and both mirrors evaporate.
        batch_size,
/// valid DataFusion identifier anywhere else a plan would naturally contain
    let sender = Box::from_raw(sender_ptr as *mut PartitionStreamSender);
            runtime_env,
        return Err(DataFusionError::Configuration(format!(
                }
    table_name: &str,
    // the struct contents into Rust-owned values; the original memory is
}
/// [`schema_coerce::coerce_inferred_schema`]** to types Substrait can bind
            .with_metadata(f.metadata().clone()),
            "expected DiskManagerMode::Directories when spill_dir is set"
            vec![
/// - `input_array_ptr` and `input_schema_ptr` must point to populated FFI structs from a
    let handle = QueryStreamHandle::new(stream, query_context, None);
                );
    #[test]
    config.options_mut().execution.target_partitions = 1;
        assert_eq!(aligned_values.value(1), "error");
            crate::memory_guard::per_query_spill_budget(),
        // Set/get round-trips a value in range.
        );
            return nt.names.last().cloned();
    })
/// `stream_next` / `stream_close` exports.
                ))
                    .data_type(want.data_type().clone())
use crate::runtime_manager::RuntimeManager;
                    e.kind(),
/// function exit; only the schema is returned.
                "Failed to register memtable '{}' on session context: {}",
        let spill_str = spill_path.to_str().expect("utf-8 path");
                match m.value() {
) -> Result<i64, DataFusionError> {
            .build()?,
        );
    if partition_count <= 0 {
// drained via the existing `stream_next` / `stream_close` exports (because
        let batch = RecordBatch::try_new(
    // task can be aborted mid-execution when cancel_query fires.
use arrow_array::{Array, StructArray};
    /// `close_global_runtime` then leaves it dangling — which fails any doc-values test reading it
        // before touching SPILL_DIR. Without this, an unset OnceLock would surface
    let stream = *Box::from_raw(stream_ptr as *mut RecordBatchStreamAdapter<CrossRtStream>);
///
        );
use crate::phantom_corrector::PhantomCorrector;
    // logic robust to upstream changes.)
        let list = ListArray::new(
                    .build_unchecked()
                row_group_row_counts: fm.row_group_row_counts.clone(),
    let schema = batch.schema();
    // with `table_schema` so MemTable::try_new sees uniform headers. Column
///
}
                table: None,
    for read in &reads {
    let table_schema = derive_schema_from_partial_plan(partial_plan_bytes)?;
                    "Failed to align imported batch to registered schema for '{}': {}",
        .map_err(|e| DataFusionError::Execution(e))?;
        // the conform step must leave the column (and its actual type) untouched.
            "sentinel original name must be gone (renamed)"
    /// Behind an `Arc` only so it can be published to the global registry, which stores a `Weak`
    // so a `cancel_query(context_id)` call fires the token here too.
/// Whether a shard query routes to the indexed executor (vs the ListingTable path),
        ensure_batch_matches_stream_schema(&batch, &mk("item", DataType::Utf8View))
            ensure_batch_matches_stream_schema(&batch, &expected_schema)?;
use datafusion::execution::SessionStateBuilder;
            )
    // Grab the CPU runtime handle BEFORE drop — drop removes the tracker from
        );
            after_size,
/// responsible for closing the input FFI structs after this call returns. Output structs
    fn wait_until<F: Fn() -> bool>(timeout_ms: u64, predicate: F) -> bool {
    input_schema_ptr: i64,
                .io_runtime
/// promoted to `Timestamp(Millisecond)` by the data-node parquet round
        let substrait = to_substrait_plan(&plan, &ctx.state())?;
        .with_runtime_env(runtime_env)
    // FINAL substrait's Read.base_schema declares on the coordinator side.
        let leaked_file = leaked_dir.join("tmp_spill_001.arrow");
        // stage to derive a producer schema for.
                input_id, e
                            pruning_metrics.matched() as i64,
/// parent is **not** required — `spill_dir` is treated as a pre-existing
                .iter()
        fs::create_dir(&leaked_b).expect("create leaked b");
            .mode();
    let columns: Vec<Arc<dyn Array>> = batch
}
        // batches whose buffers are 8-byte-aligned slices into the IPC body (per spec) but
    crate::udf::register_all(&ctx);
/// Executes a query. Returns a heap-allocated pointer (as i64) to the result stream.
            }
        )));
    /// Physical plan reference for post-execution metrics extraction.
                        }
    Ok(schema_ipc)
        context_id,
/// All `ReadRel`s reachable from the plan's roots.
 *
        let ts = out
            .await?;
/// followed by the stream EOS marker). This is the wire format Java reads via
                col.to_data()
            .collect();
}
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, spill_path, 0).expect("runtime build");
                // symlinks (it renames the link itself).
                let stale = spill_path.join(format!("{}.stale", name_str));
            "str_col",
/// Phase 1 failure aborts boot with `DataFusionError::Configuration` — if
        let batch = RecordBatch::try_new(schema, vec![Arc::new(int_array)]).unwrap();
            if let Some(left) = &j.left {
/// # Safety
        async {
        let _restore = RestorePerms {
/// This is a cheap byte-substring scan, not a parse. A false positive on
    ))
            .build();
/// `create_global_runtime`.
                row_base,
        assert!(ptr > 0);
    let token = query_tracker::get_cancellation_token(context_id);
        unsafe { close_global_runtime(ptr) };
        use arrow_array::{StringArray, TimestampNanosecondArray};
/// # Safety
    let runtime = &*(ptr as *const DataFusionRuntime);
}
            Ok(b) => b,
    let (re_array, re_schema) = arrow_array::ffi::to_ffi(&array_data).map_err(|e| {
        new_query_tracking_context(context_id, global_pool.clone(), QueryType::Shard);
/// Prevents sliced StringView batches from carrying full backing buffers across FFI.
    // Otherwise use default LocalFileSystem.
/// - `session_ctx_handle_ptr` must be a valid, non-zero pointer returned by
            info
                    let msg = format!(
        assert!(
            }
    // native alignment requirements. align_buffers() is a no-op for
    input_id: &str,
    sort_fields: Vec<String>,
                };
        sender.terminate_early();
        schema
            "values above 32 clamp down to 32"
            )
                    Field::new(name.as_str(), f.data_type().clone(), f.is_nullable())
        let compacted = compact_string_view_columns(batch);
            estimated_batch_bytes,
use crate::cancellation;
            values,
        assert_eq!(get_reduce_target_partitions(), 4);
        );
                collect_reads(input, out);
        // Critical: the target outside spill must be intact across both phases.
    // to 1 so each query produces less spill volume. When spill is off, disk health
            RecordBatch::new_empty(Arc::clone(&schema))
                                serde_json::Value::Number(serde_json::Number::from(v)),
/// UTF-8 content but use distinct buffer layouts. Mirrors the Java sink's
    let df_stream = session.execute_prepared()?;
#[cfg(test)]
        let actual_schema = Arc::new(Schema::new(vec![actual_field.clone()]));
        let parent = tempfile::tempdir().expect("parent tempdir");
        crate::udaf::register_all(&ctx);
            memory_pool_limit
/// (`block_on` for synchronous delivery, `spawn` for async delivery).
        .map(|f| match f.data_type() {
    }
    let query_future = async move {
    let (cross_rt_stream, _abort_handle, task_done) =
            // has not yet joined, but stragglers are recoverable next boot.
        );
        );
///
        .unwrap();
    if let Some(partial_schema) = crate::agg_mode::partial_aggregate_schema(&physical_plan) {
 * The OpenSearch Contributors require contributions made to
            "symlink target outside spill dir must NOT be touched (cleanup must not follow symlinks)"
use crate::helper::{build_query_runtime_env_with_store, new_query_tracking_context};
use datafusion::execution::cache::cache_manager::CacheManagerConfig;
///
    // memory layouts match exactly (FFI_ArrowArray is a stable C struct).
    } else {
/// `ptr` must be a valid pointer returned by `create_global_runtime`.
        parquet_meta.file_metadata().schema_descr(),
/// Creates a `LocalSession` bound to the given runtime's [`RuntimeEnv`]
        }
    }
    table_name: &str,
        let Some(ReadType::NamedTable(nt)) = read.read_type.as_ref() else {
        // memory_guard SPILL_ENABLED flag off so per_query_spill_budget returns
    );
    }
/// `FfmSegmentCollector::create` so the Java side can identify the corresponding Lucene
            if let Some(prev) = last_seen {
    )
        let plan_text = datafusion::physical_plan::displayable(plan.as_ref())
        assert_eq!(view.value(2), "c");
                            map,
///
    ctx.register_table("t", provider)?;
    handle
                .zip(declared_names.iter())
        let sliced = batch.slice(0, slice_rows);
    /// pre-fix code path would silently succeed and the test would assert nothing.
    // Reduce path: cancel via the token only, do NOT register the abort handle — an abort() mid-send
    /// This pins the rename behavior so a future refactor that goes back to
            Field::new("int_col", DataType::Int64, false),
    pub writer_generations: Arc<Vec<i64>>,
        );
}
) -> Option<crate::query_budget::QueryMemoryBudget> {
                    e
/// ("execute_indexed_query called with no index_filter(...) in plan"). There
            budget.phantom_bytes / batches_in_pipeline
        let local_pos = (gid as u64 - seg.global_base) as u32;
    // fires once its batches drop) before returning, so the caller's allocator close is safe.
            fields.push(Arc::clone(want));
    // the zero-copy borrow for those; conformant columns keep borrowing as above.)
/// The returned stream wraps the DataFusion output in the same
            // finish. Errors inside the thread are logged only — the cluster
    // Engine-native-merge: Partial state types differ from Final output (Binary HLL sketches,
    /// catalog snapshot (`WriterFileSet.writerGeneration`) at reader-creation time. The
            e
                "ts",
        let mut buf = Vec::new();
        // the boot thread (uniform across files, symlinks, dirs); phase 2 removes
            Arc::new(Schema::new(vec![
    let partition: Arc<dyn datafusion::physical_plan::streaming::PartitionStream> = Arc::new(
}
            let batch = if handle.has_views {
                            .get("end_timestamp")
        fs::write(&loose_file, b"loose top-level file").expect("seed loose file");
                "stream_next: column {} ('{}') has type {:?} but the stream schema declares {:?}; \
    pub sort_orders: Vec<String>,
impl QueryStreamHandle {
                    continue;
/// call `close_local_session` exactly once to free it.
        assert!(
            if let Some(substrait::proto::plan_rel::RelType::Root(rr)) = pr.rel_type.as_ref() {
        // Disabled (not Critical) — preventing the 1-partition clamp.
    use arrow::datatypes::{DataType, Field, TimeUnit};
        // spill disabled (empty path), no filesystem operation should run — an
) -> Option<substrait::proto::NamedStruct> {
        ))
        let _ = Box::from_raw(ptr as *mut LocalSession);
            //
            .column(0)
    }
/// # Safety
        let batch = RecordBatch::try_new(schema, vec![Arc::new(string_view_array)]).unwrap();
/// wipe outside the spill mount.
pub async unsafe fn fetch_by_row_ids(
        _ => {}
        assert_eq!(aligned_list.value_offsets().as_ptr(), original_offsets);
    };
    pub fn with_physical_plan(
        })
        // parquet-read leaf, so the synthetic leaf we register here matches.
            true,
            before_size > after_size * 100,
    #[test]
        //  Phase 1 (sync, on boot thread): rename every immediate child to a
    let runtime = &*(ptr as *const DataFusionRuntime);
        let col_idx = idx as usize;
        let batch = RecordBatch::try_new(
    let query_context = QueryTrackingContext::new(
/// Closes a result stream. Safe to call with 0 (no-op).
                            }
            // SAFETY: `data` was taken from a valid array and only its data_type
            {
/// the FFI structs on success.
    pub table_path: ListingTableUrl,
        return stream;
        )]));
    let handle = &*(session_ctx_handle_ptr as *const crate::session_context::SessionContextHandle);
        let has_views = Self::schema_has_views(&stream.schema());
/// `derive_schema_from_partial_plan` re-lowers the producer plan and returns its top
fn ascending_row_id_check_stream(
    let mut columns = Vec::with_capacity(batch.num_columns());
///
                table_name.to_string(),
            .expect_err("create_global_runtime must fail when cleanup fails");
        return;
        // file in the directory before the call and assert it's gone after.
/// - `schema_ipc` must be a complete Arrow IPC schema-message blob.
/// the producer side, so no view-type or timestamp-precision rewrites are
            }
    row_ids: Vec<i64>,
    let cpu_exec = manager.cpu_executor();
    if actual_schema.fields().len() != declared.fields().len() {
        let aligned = RecordBatch::try_new(Arc::clone(&table_schema), raw.columns().to_vec())
                                } else {
            cleaned,
    // partitions that received zero rows so the receiver side still sees a valid IPC chunk).
    let waste = bytes_allocated.saturating_sub(bytes_used);
        // contents present at startup are leaked from a prior non-graceful shutdown.
        let stale_link = spill_path.join("escape_link.stale");
    stream: datafusion::execution::SendableRecordBatchStream,
        fs::write(&bad_path, b"not a directory").expect("seed regular file");
    pub custom_cache_manager: Option<CustomCacheManager>,
    // Acquire a schema-accurate phantom reservation for this reduce session.
                        add(
/// - `sender_ptr` must be a valid, non-zero pointer returned by
                    .map(|pos| pos - rg_start)
        }
    let declared_names: Vec<String> = plan
        .object_store(&shard_view.table_path)?;
            .execution
    // Same import-and-align pattern as register_memtable above. Java's ArrowStreamReader
        })?;
        .with_default_features()
        log::info!("DataFusion spill disabled (datafusion.spill_directory not set)");
            .downcast_ref::<StringViewArray>()
/// when `classify_filter` returns `None` (no automatic retry on the ListingTable
            physical_plan: None,
        assert!(
pub async unsafe fn execute_local_plan(
        fs::write(&outside, b"must NOT be touched").expect("seed outside file");
                .is_err();
use crate::datafusion_query_config::DatafusionQueryConfig;
        let batch = RecordBatch::try_new(Arc::clone(&declared), vec![Arc::clone(&col)]).unwrap();
            DataType::Utf8View,
        let batch =
    }
pub async fn create_object_metas(
    /// Row counts per row group in this file.
                                );
        //
        let batch = RecordBatch::try_new(
            } else {
    );
/// fresh `datafusion-XXXXXX/` and never touches siblings. The fresh dir's
/// on the Java drain thread) would otherwise make the consumer silently compute a result from PARTIAL
    ///   - Vanilla path: `ListingOptions.with_file_sort_order(...)` so DataFusion advertises
        let _guard = lock_process_globals();
        let col: arrow_array::ArrayRef = Arc::new(arrow_array::Int64Array::from(vec![10, 20]));
            writer_generations.len()
        })?;
    memory_pool_limit: i64,
            32,
        Arc::clone(&table_schema),
                        let prev = map
    // Pre-allocate the per-partition collectors. The partitioner's callback emits zero or
            .options()
    use super::*;
///
/// consumes them on the I/O runtime.
    }
                true,
    let mut partitioner = datafusion::physical_plan::repartition::BatchPartitioner::try_new(
    let corrector = if let Some(budget) =
            .map(|i| format!("binary_payload_{:08}_extra_bytes", i).into_bytes())
                    let prev = map.get(&key).and_then(|v| v.as_i64()).unwrap_or(0);
        filenames,
        };
        let original_parent_mode = fs::metadata(parent.path())
// reduce stage, streaming inputs are registered under synthetic names, a
        .map_err(|e| {
) -> Result<RecordBatch, DataFusionError> {
                collect_reads(input, out);
/// Closes a DataFusion global runtime. Safe to call with 0 (no-op).
        SpillBudget::Critical => 1,
    Ok(Box::into_raw(Box::new(handle)) as i64)
            collect_reads(&rel, &mut reads);
    use arrow_array::{BinaryViewArray, Int64Array, ListArray, StringViewArray};
    // per-batch cast at feed time.
    };
            .as_ref()
) -> (Arc<DatafusionQueryConfig>, Option<Arc<PhantomCorrector>>) {
    let wrapped = RecordBatchStreamAdapter::new(cross_rt_stream.schema(), cross_rt_stream);
///
    fn no_view_columns_passthrough() {
    // Extract Arrow schema (zero I/O — just struct conversion)
            }
) -> Result<i64, DataFusionError> {
            "spill mount-point must remain a directory"
            RecordBatch::try_new(schema, vec![Arc::new(string_view_array.clone())]).unwrap();
            let ffi_array = FFI_ArrowArray::new(&array_data);
/// # Safety
                        let v = m.value().as_usize() as i64;
            let data = unsafe {
                runtime,
                full_array.data_buffers(),
    let query_context = QueryTrackingContext::new(
/// Best-effort budget acquisition from cached parquet metadata.
    input_id: &str,
///
                let rg_end = rg_start + rg.num_rows as u32;
                        Ok(e) => e,
    let mut last_seen: Option<i64> = None;
        assert!(ptr > 0);
                    plan.set(rg.index, RowGroupAccess::Selection(selection));
    columns: Vec<String>,
            "symlink original name must be gone (renamed)"
        // at a regular file: spill_path.exists() returns true, but read_dir refuses
}
        None
                        if v > prev {
    let handle = &*(session_ctx_handle_ptr as *const crate::session_context::SessionContextHandle);
                                if ft.is_dir() && !ft.is_symlink() {
    );
        let after_size = compacted.column(0).get_array_memory_size();
            before_size / after_size
                        e.kind(),
        Self {
        return Err(DataFusionError::Execution(format!(
        Some(query_context.set_phantom_corrector(corrector))
        query_tracker::set_cpu_runtime_handle(context_id, rt);
/// represent in its logical type system. Parquet's TIMESTAMP supports
            cpu_exec.clone(),
/*
        // Mirror the two transformations the data-node session applies to its
/// `FFI_ArrowArray` / `FFI_ArrowSchema` structs on success — the Java side
        // coordinator's StreamingTable so it accepts the producer's batches
        .await
        DataFusionError::Execution(format!("Failed to import input Arrow C Data: {}", e))
    #[test]
use crate::query_executor;
        let declared: SchemaRef = Arc::new(Schema::new(vec![
        runtime,
}
/// - `schema_ptr` must point to a populated `FFI_ArrowSchema` struct owned
            b"must NOT be touched",
                i,
            schema_ptrs.len()
        batches.push(aligned);
}
}
            }
///     sibling. Renames are metadata-only — one syscall per entry, contents
            .with_default_features()
        Some(RelType::ExtensionMulti(e)) => {
/// is no automatic retry on the vanilla path — a false positive is a hard
    pub object_metas: Arc<Vec<object_store::ObjectMeta>>,
                        e
}
    /// Pointer to array of i64 row counts (one per row group).
            fields.push(Arc::clone(want));
    }
mod tests {
        let Some(ReadType::NamedTable(nt)) = read.read_type.as_ref() else {
                            Ok(e) => e,
                            Err(e) => {
    };
    true
        file_metadata.len(),
            arrow_schema
        let expected_schema = Arc::new(Schema::new(vec![Field::new(
        "fetch_by_row_ids: build_segments returned empty for non-empty shard view"
}
        assert!(top_file.exists());
        handle._query_tracking_context.context_id(),
    table_name: &str,
        let stale_top = tmp.path().join("top.tmp.stale");
    .map_err(DataFusionError::Execution)?;
    )?;
        );
    // ── 4. Execute SQL: compute global __row_id__ = __row_id__ + row_base ──
) -> Result<(i64, Vec<u8>), DataFusionError> {
pub struct WireFileMetadata {
        table_path,
        // Mixed batch: a Utf8→Utf8View mismatch (must cast) alongside a tolerated
use datafusion::execution::RecordBatchStream;
        if let Some(rel) = root_rel(plan_rel) {
    // here through the partition channel are already typed to match this schema — no
        //    never follow a symlink through to its target), `remove_dir_all`
        let compacted = compact_string_view_columns(batch);
            ),
        use std::os::unix::fs::PermissionsExt;
        // mirrors the streaming sink path in attach_input_batch() above.
                _ => false,
            Arc::clone(&actual_child),
    let ctx = SessionContext::new_with_state(state);
    // Recreate the FFI handles back in place so the caller's release closure on the
        let nested_file = nested_dir.join("deep.tmp");
    // reservation/corrector to the query context.
    }
            .copied_config()
        fs::create_dir(&spill_path).expect("create spill dir");
        let out = super::conform_batch_to_schema(batch, &declared).unwrap();
        .unwrap();
            2_000_000_999,
    partition_count: i32,
    if actual_schema.as_ref() == declared.as_ref() {
/// Loads the next record batch from the stream.
        .iter()
        crate::partition_stream::SingleReceiverPartition::new(receiver),
                        // keeps the symlink defense — fs::remove_file on a symlink
        exprs.push(Arc::new(
            let num_rows: u64 = fm.row_group_row_counts.iter().sum();
                    .as_any()
            .indent(true)
                let name = entry.file_name();
    }
use crate::memory_guard::{per_query_spill_budget, SpillBudget};
    let (effective_config, phantom_corrector) = resolve_effective_config(
///
        assert_eq!(get_reduce_target_partitions(), 1);
                     Verify the process owns the spill directory before restarting.",
    fn create_global_runtime_with_spill_dir_enables_disk_manager() {
    query_config: &DatafusionQueryConfig,
/// directly. The hash-shuffle path has no producer-side substrait plan to derive the schema
        assert!(!leaked_b.exists(), "original orphan b must be renamed away");
            .any(|f| matches!(f.data_type(), DataType::Utf8View | DataType::BinaryView))
        sort_orders,
/// `runtime_ptr` must be a valid, non-zero pointer returned by
    let mut reads = Vec::new();
            stream,
) -> Result<arrow::datatypes::SchemaRef, DataFusionError> {
    }
                if !rg_bitmap.is_empty() {
        // Phase 1: symlink is renamed inline (fs::rename does not follow symlinks).
            "Expected >100x reduction on StringView column, got before={} after={} ratio={}",
    runtime.dynamic_limit_handle.limit() as i64
    // kernels require 64-byte alignment; align_buffers() reallocates only the misaligned
use crate::query_tracker::{self, QueryTrackingContext, QueryType};
        });
    session_ptr: i64,
        } else {
    runtime_ptr: i64,
        fs::create_dir(&spill_path).expect("create spill mount-point dir");
    }
}
            Some(plan)
}
            // `List<Utf8>` here while the data node (which uses
    pub fn new(
            _query_tracking_context: query_context,
        assert_eq!(
        assert!(
            // `transform_schema_to_view` only touches top-level fields, which left
                // Rename to <name>.stale within the same parent. Metadata-only;
    ///
            cpu_exec.clone(),
            Arc::new(Schema::new(vec![Field::new(
///
    // Zero-copy: from_ffi BORROWS the Java buffers, keeping them alive until DataFusion drops the
            _concurrency_permit: permit,
    Ok(())
            OffsetBuffer::new(vec![0_i32, 1].into()),
    #[test]
        query_tracker::set_cpu_runtime_handle(context_id, rt);
    let (segments, resolved_schema) = build_segments(
    }
///     are not touched.
    // Look up metadata for the first file
                "Failed to register streaming table '{}' on session context (from partial plan): {}",
        debug_assert!(gid >= 0, "fetch_by_row_ids: negative row id {}", gid);
            "leaked file under leaked subdir must be removed"
    context_id: i64,
///
                DataType::BinaryView => {
pub unsafe fn close_global_runtime(ptr: i64) {
            .with_file_extension(".parquet")
    Ok(Box::into_raw(Box::new(runtime)) as i64)
        let schema = Arc::new(Schema::new(vec![
        Self::collect_metrics(plan.as_ref(), &mut map);
                }
        &shard_view.table_path,
        let stale_dir = tmp.path().join("subdir.stale");
        array_data.align_buffers();
                collect_reads(input, out);
/// from the substrait base_schema — the plan itself is the source of truth for
// Mirrors the shard-scan path: a `LocalSession` pointer is created once per
            BinaryViewArray::from_iter_values(values.iter().map(|v| v.as_slice()));
        // Timestamp precision mismatch (must pass through).
    let session = LocalSession::new(&runtime.runtime_env);
    /// `crate::test_process_globals::lock` rather than a lock of its own, because
        //    for directories. Filtering by the .stale suffix means the fresh
/// When `spill_dir` is non-empty, every immediate child is removed:
                        }
/// this never touches the bounded channel — it cannot block/deadlock against a full channel + a
    ///     to catalog-snapshot order, the per-shard segment iteration is reversed so a TopK
use std::num::NonZeroUsize;
            1_000_000_001i64,
            }
                plan_bytes.to_vec(),
 * SPDX-License-Identifier: Apache-2.0
///   successful Arrow C export of the input record batch. They are read but not consumed
        // ExtensionSingleRel. Without these arms the ReadRel is invisible here,
            .expect("stat parent")
/// # Safety
    if let Some(budget) = crate::query_budget::try_grow_reduce_budget(
                            );
    runtime: &DataFusionRuntime,
        assert!(!nested_dir.exists(), "nested leaked subdir must be removed");
    input_id: &str,
        // implies the runtime would fail later mid-query anyway. Surface the failure
        let _guard = lock_process_globals();
            }
) -> Result<i64, DataFusionError> {
    use parquet::arrow::parquet_to_arrow_schema;
fn conform_batch_to_schema(
        .zip(file_metadata.iter())
        let slice_rows = 100usize;
        );
            None,
    }
        });
                .block_on(async {
        df_stream.schema().as_ref(),
/// `SingleReceiverPartition` + `StreamingTable` + `register_table` on the
    /// Index sort fields, in priority order. Sourced from the index's
        per_partition[partition_idx].push(sub_batch);
) -> Result<Vec<u8>, DataFusionError> {
                                log::warn!("Background spill cleanup: read_dir error: {}", e);
    }
            let v = arr.value(i);
            vec![Arc::clone(&col)],
        Some(physical_plan),
        default_rt.object_store(&table_url)?
        fs::write(leaked_b.join("tmp_002.arrow"), b"data b").expect("write b");
/// Sets the minimum target_partitions floor for the adaptive budget system.
use arrow_schema::DataType;
    let schema = stream.schema();
            "phase 1 must NOT double-suffix existing .stale entries"
        let out = super::conform_batch_to_schema(batch, &declared).unwrap();
    fn stream_schema_tripwire_ignores_child_names_but_rejects_layout_mismatch() {
///
///     (which unlinks the symlink itself without following it); directories
                col, names
    }
    fn stream_schema_tripwire_rejects_column_count_mismatch() {
/// [`org.opensearch.analytics.spi.ShuffleScanInstructionNode`] equivalent. Mirrors how
/// point whose parent the JVM user does not own; rmdir'ing the root would
    }
            // per-value UTF-8 and offset scan on every batch.
///
    /// Skipped under EUID 0 — root has CAP_DAC_OVERRIDE (or the macOS equivalent)
/// so the session produces batches on the CPU executor while `stream_next`
        // Phase 1 renames the sentinel file to leaked_from_prior_run.tmp.stale
            msg
                let view: &arrow_array::StringViewArray = col
    }
            columns.push(arrow_array::make_array(data));
/// - `array_ptrs` and `schema_ptrs` must point to populated FFI structs owned
            .with_collect_stat(true);
///     removed off the boot path. Files and symlinks via `remove_file`
            let mut plan = ParquetAccessPlan::new_none(num_rgs);
            .permissions()
        let after_size = compacted.columns()[0].get_array_memory_size();
    // divergences (e.g. Timestamp precision) are left untouched — see
        );
        }
            actual_schema.fields().len(),
            physical_plan: Some(plan),
/// `session_ptr` must be a valid, non-zero pointer returned by
            columns.push(Arc::clone(col));
/// Unlike [`register_memtable`], this entry point takes an Arrow IPC schema blob directly
        let strings: Vec<String> = (0..1000)
    const FALLBACK: u64 = 8 * 1024 * 1024 * 1024; // 8GB
        .iter()
                DataType::List(Arc::new(Field::new(child_name, child_ty, true))),
            sort_orders.len()
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, spill_path, 0).expect("runtime build");
            "negative values clamp up to 1"
    columns: &[String],
                let view: &arrow_array::BinaryViewArray = col
            "leaked datafusion-* original name must be gone (renamed)"
        let values: Arc<dyn Array> = Arc::new(StringViewArray::from_iter_values(["prod", "error"]));
    // In debug builds, interpose an adapter that asserts __row_id__ values are
///
            e
    // cancellation token is registered in the global QUERY_REGISTRY.
    file_metadata: &[FileRowMetadata],
        // The spill directory itself is never removed (mount-point safe).
use arrow_array::ffi::FFI_ArrowArray;
        assert!(ptr > 0);
        token.as_ref(),
                        .as_any()
        dynamic_limit_handle,
///
pub unsafe fn decode_file_metadata(ptr: i64, count: usize) -> Option<Vec<FileRowMetadata>> {
        //    deletion target.
            Arc::clone(&schema),
/// `ptr` must be 0 or a valid pointer returned by `create_local_session`.
    stream: RecordBatchStreamAdapter<CrossRtStream>,
    pub fn with_task_done(mut self, task_done: tokio::sync::oneshot::Receiver<()>) -> Self {
        output.push((array_ptr, schema_ptr));
        assert!(ptr > 0);
        assert!(ptr > 0);
                .await
        "shuffle partition stream failed on the producer/drain side: {reason}"
                 EUID 0 bypasses chmod 0o555 via DAC override; the pre-fix code path \
    manager: &RuntimeManager,
                "Could not determine disk space for '{}', using fallback {}GB",
        Ok(buf)
                })
        }
///
            Field::new("b", DataType::Int64, false),
            let struct_array: StructArray = batch.into();
/// (`REPARTITION_RANDOM_STATE`) so the assignment matches what `RepartitionExec` and
                            map,
    schema_ptr: i64,
    #[test]
            _session_ctx: None,
    fn view_needs_gc_detects_bloat() {
                e.data_type()
                &shard_view.sort_orders,
            DataFusionError::Execution(format!(
    // Prepared-reduce path: same as execute_local_plan — token-only cancel, no abort handle.
                        spill_dir,
        )));
    // Fetch the next batch (cancellation-aware). Query cancellation is an abort,
                    let mut perms = metadata.permissions();
            msg
        &ctx.state(),
    let context_id = handle._query_tracking_context.context_id();
    expected: &SchemaRef,
    /// The physical plan may reference state (e.g. RuntimeEnv, caches) owned
        ]));
/// Contains the DataFusion RuntimeEnv (memory pool, disk spill, cache)
    ));
        /* num_input_partitions */ 1,
///
        }
    )
    // Apply disk-pressure capping + memory budget, attaching phantom
    // by value (zeroing its release fn pointer to take ownership); we have to undo that
/// schema as a standalone IPC blob produced by `ArrowSchemaIpc.toBytes(...)`.
        }
        .collect();
            has_views,
            .partition_point(|s| s.global_base <= gid as u64)
/// Returns the sender pointer; the caller frees it via [`crate::ffm::df_sender_close`] once
    use datafusion::execution::cache::{CacheAccessor, DefaultListFilesCache};
///
            batch.columns()[0].get_array_memory_size(),
                            serde_json::Value::Number(serde_json::Number::from(value)),
            runtime.runtime_env.disk_manager.max_temp_directory_size(),
    let stream_ptr = cancellation::cancellable(token.as_ref(), context_id, query_future)
    /// Pre-existing *.stale entries from a prior boot whose phase 2 didn't finish
    pub num_row_groups: i32,
    #[test]
                            );
/// Opaque runtime handle returned to the caller.
        .map_err(|e| {
    }
        //
        if nt.names.last().map(String::as_str) != Some(table_name) {
    // shared QUERY_REGISTRY — parity with execute_query + execute_local_plan,
                if let Ok(metadata) = fs::metadata(self.path) {
    session_ctx_handle_ptr: i64,
            access_plan,
        permit: Option<tokio::sync::OwnedSemaphorePermit>,
    if sender_ptr != 0 {
                        .downcast_ref()
    }
    if array_ptrs.len() != schema_ptrs.len() {
        // Boundary values pass through unchanged.
            "sender_send: failed to assemble conformed batch: {}",
                Field::new("ts", DataType::Timestamp(TimeUnit::Nanosecond, None), true),
///
                    log::error!("{}", msg);
            // Re-scan inside the thread so we pick up entries from this boot
/// # Safety
        file_schema: resolved_schema,
            std::thread::sleep(std::time::Duration::from_millis(20));
    let bytes_allocated: usize = buffers.iter().map(|b| b.len()).sum();
        .map_err(|e| DataFusionError::Execution(format!("Invalid table path: {}", e)))?;
        metadata_cache,
            .expect("runtime build");
        let schema = Arc::new(Schema::new(vec![Field::new(
                FALLBACK / (1024 * 1024 * 1024)
/// will be present in the plan's extension declarations.
        let loose_file = spill_path.join("stray.txt");
        assert!(
/// `ptr` must be a valid pointer returned by `create_global_runtime`.
        assert!(
///    nullability, child names/metadata may differ): zero-copy relabel. This is the
    session_ptr: i64,
        }
        )));
            columns.push(Arc::clone(col));
///
            "spill mount-point dir must be preserved"
                    i,
        }
            out.column(0).data_type(),
}
                    .expect("column must be StringViewArray when schema declares Utf8View");
    hash_key_indices: &[i32],
            // "RefCnt has gone negative".
        assert_eq!(
    fn reduce_target_partitions_roundtrips_and_clamps() {
}
                    }
    let fields: Vec<Field> = schema
pub fn set_reduce_target_partitions(value: i64) {
            vec![Arc::new(binary_view_array), Arc::new(int_array)],
                            .and_then(|v| v.as_i64())
        let names: Vec<String> = schema.fields().iter().map(|f| f.name().clone()).collect();
    })
    }
    )
    // Resolve the object store: if store_ptr > 0, clone the Arc from the boxed pointer.
                return true;
            ],
        );
    task_done: Option<tokio::sync::oneshot::Receiver<()>>,
        // Utf8 vs Utf8View child: the SIGSEGV class, must be rejected.
///
    // Race substrait planning + execution against the cancellation token so
        let _guard = lock_process_globals();
        let string_view_array: Arc<dyn Array> = Arc::new(StringViewArray::from_iter_values(
    }
const GC_MIN_WASTE_BYTES: usize = 10_240;
    ))?;
        parquet_meta,
        // it during remove, the outside file would have been clobbered.
}
/// Decode an array of `WireFileMetadata` from an FFM pointer.
            .zip(schema.fields().iter())
/// the schema once on the dispatch side and threads it through the
}
            !link.exists(),
}
/// Falls back to 8GB if disk space cannot be determined.
                    let selection =
    sender_ptr: i64,
                log::error!("{}", msg);
            DataType::List(declared_child),
    // Java side sees an intact, releasable struct. from_ffi consumed the FFI_ArrowArray
                // only write on spill_path itself. Works uniformly for files,
    /// When no store is provided, uses default LocalFileSystem.
        // Extension rels wrap a normal input. The multi-value expand
    ///     above us can prune via parquet page statistics.
    fn stringview_gc_empty_array() {
/// If not cached: returns None (first query — skip budget, warm cache).
    ) -> Self {
        if let Some(ReadType::NamedTable(nt)) = read.read_type {
    }
    let table = datafusion::catalog::streaming::StreamingTable::try_new(
    }
        );
/// must not release them after a successful send. On error ownership is
    // Reclaim ownership so the sender (and its channel) is dropped at end of scope — mirrors
            if let Some(right) = &j.right {
                            map.insert(
}
            df_stream,
            for rg in &seg.row_groups {
        }
            let coerced = crate::schema_coerce::coerce_inferred_schema(partial_schema);
                    } => {
    ) -> Self {
) -> Result<Vec<u8>, DataFusionError> {
/// # Safety
            crate::schema_coerce::transform_schema_to_view_recursive(&arrow_schema)
///
        );
/// producer will actually emit, so we eliminate any divergence between
/// teardown as [`sender_close`]). This is the truncation-safe terminal: a plain [`sender_close`]
                Arc::new(view.gc()) as Arc<dyn Array>
/// stream's mpsc. The Rust side takes ownership of the
#[derive(Debug, Clone)]
fn coerce_unsupported_timestamp_precision(
    let token = handle._query_tracking_context.cancellation_token();
/// against the same schema the native session is registered with.
        let struct_array = StructArray::from(array_data);
    .ok()
                    other => {
    let mut batches = Vec::with_capacity(array_ptrs.len());
        let sliced_view: &StringViewArray = sliced.as_any().downcast_ref().unwrap();
    /// Index sort directions per field — values: `"asc"` or `"desc"`.
            schema,
            before_size,
}
                schema.fields().len()
        assert_eq!(ts.value(1), 2_000_000_999);
use datafusion::datasource::listing::ListingTableUrl;
        value.max(1).min(32) as usize,
        };
/// The OpenSearch process must own `spill_dir` with `rwx`. Write on the
            }
            expected.fields().len()
        runtime,
                    .as_any()
            before_size / after_size
        // Plan may scan the same table twice; the second register is a no-op.
        // Operator-confirmed contract: the spill directory is OpenSearch-owned and any
            for input in &s.inputs {
        unsafe { close_global_runtime(ptr) };
        // accidental fs::remove_dir_all("") would error and break boot. This test
            .expect("child field name is not part of the buffer layout");
    // The token is held via the QueryStreamHandle's context and consulted by
fn schema_to_ipc_bytes(schema: &arrow::datatypes::Schema) -> Result<Vec<u8>, DataFusionError> {
/// Three tiers, checked per column against the declared field:
///
    let table = datafusion::catalog::streaming::StreamingTable::try_new(
                        map.insert(
    for &idx in hash_key_indices {
            "background cleanup must remove escape_link.stale within 2s"
    // batch per partition. (For our use case the partitioner emits at most one sub-batch
        // subdirectories) before / during constructing the DiskManager.
        }
    /// Per-file row group counts, passed from Java at shard view creation.
/// partition column and to resolve global row IDs back to file positions.
) -> datafusion::execution::SendableRecordBatchStream {
///
            batches_in_pipeline,
    /// Available after execution completes; read via `df_stream_get_metrics`.
        assert_eq!(out.schema().field(0), &actual_field);
        return;
        assert_ne!(
        let access_plan = if let Some(bm) = per_segment.get(&seg_ord) {
            Self::collect_metrics(child.as_ref(), map);
        // at boot with full context. Trigger the failure path by pointing spill_dir
                            map.insert(
        config.batch_size,
                        }
///
    // into a fresh ArrayData per column via a clone after import. The clone is cheap (Arc
        // plan on the coordinator fails with "No table named '<index>'" — only
        // Declared stream schema says Millisecond; producer emitted Nanosecond. A real cast
///
    std::ptr::write(input_schema_ptr as *mut FFI_ArrowSchema, re_schema);
/// QTF fetch phase: read specific rows by global row ID.
                    .filter(|&pos| pos >= rg_start && pos < rg_end)
            FALLBACK
) -> Result<Vec<(i64, i64)>, DataFusionError> {
        assert!(
    let table = datafusion::datasource::MemTable::try_new(table_schema, vec![batches])?;
        current_phantom,
    fn stringview_gc_compacts_sliced_buffers() {
                col_idx,
            task_done: None,
/// (e.g. `sum_qty[sum]`). The worker FINAL fragment's `base_schema`, however, declares the
/// If cached: extracts the schema + measured row bytes, acquires budget.
    /// When set, ShardTableProvider attaches it to the PartitionedFile so
    // "DiskManager is disabled" error instead of writing to an unintended path.
    }
/// declared and physical types.
/// Returns a heap-allocated pointer (as i64) to `LocalSession`. Caller must
/// `create_local_session`.
            "top-level file original name must be gone (renamed)"
        dynamic_pool,
            outside.exists(),
        (mgr.build_cache_manager_config(), Some(mgr))
                            .get("start_timestamp")
            msg.contains(bad_path_str),
    let table_schema = schema_from_ipc_bytes(schema_ipc)?;
        substrait
    /// Fires when the spawned CPU task has fully dropped; `stream_close` waits on it so borrowed
/// Returns the current memory pool usage in bytes.
        crate::memory_guard::set_spill_dir(spill_dir);
        ctx.register_table(&table_name, Arc::new(ListingTable::try_new(config)?))?;
        fs::create_dir_all(&nested_dir).expect("seed nested subdirs");
            RecordBatch::try_new(mk("element", DataType::Utf8View), vec![Arc::new(list)]).unwrap();
            "stream_next: batch column count {} does not match declared schema width {}",
            })?;
            handle
            .expect("aligned child remains Utf8View");
        .register_table(input_id, Arc::new(table))
/// passed the raw pointers as two parallel slices. Rust takes ownership of
pub unsafe fn create_local_session(runtime_ptr: i64) -> Result<i64, DataFusionError> {
        session.memory_pool(),
    fn create_global_runtime_renames_orphan_subdirs_to_stale_then_async_removes() {
            "error must include the io::ErrorKind for diagnosis; got: {}",
use datafusion::physical_plan::stream::RecordBatchStreamAdapter;
        let out = conform_batch_to_schema(batch, &declared).unwrap();
        );
            collect_reads(&rel, &mut reads);
/// Computes `row_base` as the cumulative prefix sum of file row counts.
        .fields()
    let mut handle = Box::from_raw(stream_ptr as *mut QueryStreamHandle);
        .unwrap();
    handle
/// parent `AnalyticsQueryTask` cancel propagates here, and wraps the native
        }
    let runtime_env = Arc::new(
            fields.push(Arc::clone(&actual_schema.fields()[i]));
        assert!(ptr > 0);
    /// environment is dropped when Java closes this runtime, exactly as it was when held by value.
                continue;
        .collect();
        Self {
    // Downcast Arc<dyn FileMetadata> to ParquetMetaData
    /// Cumulative row count from all preceding files.
    }
    batch: RecordBatch,
                .map(|&c| c as u64)
    use datafusion_substrait::logical_plan::consumer::{
        let spill_path = tmp.path().to_str().expect("utf-8 path");
            .with_config(SessionConfig::new())
            .iter()
    }
    Ok(buf)
    io_handle: &tokio::runtime::Handle,
/// Mirrors [`execute_local_plan`] for the prepared-plan path: registers a
            for m in metrics.iter() {
    pub fn new_for_bench(runtime_env: Arc<datafusion::execution::runtime_env::RuntimeEnv>) -> Self {
        // Originals were renamed inline — gone immediately by the original name.
    let runtime_env = build_query_runtime_env_with_store(
                if name_str.ends_with(".stale") {
                    e
                        .with_metadata(f.metadata().clone())
    let extensions = Extensions::default();
    ) {
            .map(|i| format!("long_string_value_{:06}_padding", i))
                    let msg = format!(
            "spill_limit must be non-negative, got {}",
        })
        let list = ListArray::new(
use datafusion::execution::runtime_env::RuntimeEnvBuilder;
    // Concatenate per partition (or produce an empty batch with the input schema for
        stream: RecordBatchStreamAdapter<CrossRtStream>,
    plan_bytes
/// `ptr` must be 0 or a valid pointer returned by `create_reader`.
    let table_name = table_name.to_string();
        // logs are diagnostic without needing further investigation.
/// output in the same `CrossRtStream` + `RecordBatchStreamAdapter` + handle
            cleaned,
    sql: &str,
        let arrow_schema = df_schema.as_arrow().clone();
pub(crate) fn first_named_table_name(plan_bytes: &[u8]) -> Option<String> {
        )]));
        let has_views = Self::schema_has_views(&stream.schema());
    // Buffers from Java's Flight RPC deserialization may not meet Rust's
    let projection = columns
    // Dropping the handle aborts the CPU task but does not wait for it; on the coordinator-reduce
            .iter()
/// Mirror parquet's coercion of Arrow Timestamp precisions it cannot
    crate::query_budget::acquire_budget_from_metadata(
        assert_eq!(
                        .expect("column must be StringViewArray when schema declares Utf8View");
        // Clamps to the [1, 32] range used by the datafusion.reduce.target_partitions setting.
/// input.
                .name("datafusion-spill-gc".to_string())
                }
        .iter()
            "Non-sliced batch must return the original column Arc (no copy)"
/// # Safety
    }
pub async unsafe fn stream_next(stream_ptr: i64) -> Result<i64, DataFusionError> {
        let batch = RecordBatch::try_new(actual_schema, vec![Arc::new(list)])
        let int_array = Int64Array::from_iter_values(0..1000);
    }
    #[test]
    // DiskManagerMode::Disabled — operators that need to spill will fail with a clear
            .await
pub unsafe fn stream_get_schema(stream_ptr: i64) -> Result<i64, DataFusionError> {
    let logical_plan = futures::executor::block_on(
/// `index_filter` takes the indexed path and then fails in `execute_indexed_query`
    ) -> Self {
    /// Per-row-group row counts.
}
            tmp.path().is_dir(),
            "Expected large reduction for BinaryView, got before={} after={} ratio={}",
        shard_view.object_metas.as_ref(),
        Some(RelType::ExtensionSingle(e)) => {
        Arc::clone(&store),
    let row_id_idx = match schema.column_with_name(crate::ROW_ID_COLUMN_NAME) {
    runtime.runtime_env.memory_pool.reserved() as i64
/// shape as the streaming path.
            DataType::Int64,
    shard_view: &ShardView,
    let sender = session.register_partition(input_id, schema)?;
    }
            physical_plan: Some(plan),
                                serde_json::Value::Number(serde_json::Number::from(v)),
    pub store: Arc<dyn ObjectStore>,
/// `stream_ptr` must be 0 or a valid pointer returned by `execute_query`.
///
    }
        array_data.align_buffers();
) -> Result<i64, DataFusionError> {
                )
    fn stringview_gc_inline_strings_no_change() {
            values,
    #[cfg(unix)]
        );
    object_metas: &[object_store::ObjectMeta],
    /// parallel by default; without serialization, two runtime-construction tests would race on
                    let _ = fs::set_permissions(self.path, perms);
    ));
        runtime_env,
    // page-index region so query range keys match eager warm-population (warm hits).
        query_context: QueryTrackingContext,
        &shard_view.sort_fields,
/// [`register_memtable_on_session_context`] also takes a schema blob.
                DataFusionError::Configuration(msg)
    fn conforms_list_child_name_to_declared_coordinator_schema() {
    }
            !view_needs_gc(
        // Cleanup is two-phase: phase 1 renames every immediate child to *.stale on
pub fn create_global_runtime(
            "background cleanup must remove both .stale entries within 2s"
                format!(
/// # Safety
                        }
        CrossRtStream::new_with_df_error_stream_cancellable(
    // for the input not to leak / double-free. The simplest way: convert the ArrayData
            DataType::Timestamp(TimeUnit::Second, tz) => Field::new(
            sentinel.exists(),
        let err = create_global_runtime(64 * 1024 * 1024, 0, bad_path_str, 0)
            }
                object_meta: meta.clone(),
                context_id,
    {
/// already dropped (consumer finished / cancelled) the flag is simply never read, which is correct.
            "error must reference the offending path; got: {}",
/// on the same stream.
        cfg.target_partitions = budget.target_partitions;
        )]));
    // same coercer + wraps its physical plan with `RelabelExec`, so the batches arriving
/// fail with `EACCES` in that topology. Top-level symlinks are renamed in
            &DataType::Timestamp(TimeUnit::Nanosecond, None)
        let arrow_schema = coerce_unsupported_timestamp_precision(&arrow_schema);
/// Encodes a Schema as Arrow IPC stream-format bytes (a schema-only message
                e.name(),
    #[test]
    // ── 3. Register ShardTableProvider ──
        //    directories are all renamed identically. Renames are metadata-only
    /// `index.sort.field` setting on the Java side. Empty when the index has
        let binary_view_array =
            return Ok(Arc::new(Schema::new_with_metadata(
        let base_schema = read
    // and then leaking the FFI handles back to the heap via Box::into_raw — leaving the
    #[test]
        );
            .downcast_ref::<ListArray>()
    // already-aligned buffers; only misaligned ones are reallocated.
                    }
                    want.name(),
        ]));
///
            .expect("aligned column remains LIST");
    global_pool: &Arc<dyn MemoryPool>,
    pub runtime_env: Arc<datafusion::execution::runtime_env::RuntimeEnv>,
            if timed_out {
    #[test]
    // produces 8-byte-aligned slices into the IPC body (per spec) but DataFusion's SIMD
/// against. NamedTable references are resolved against empty MemTables built
        // without reinterpretation. Long-term plan: have the data node embed
    #[test]
            _session_ctx: Some(ctx),
            if let Some(input) = &f.input {
/// decided by scanning the substrait plan bytes for two needles: the `index_filter`
        Some((idx, _)) => idx,
use arrow_array::RecordBatch;
            !runtime.runtime_env.disk_manager.tmp_files_enabled(),
            1024 * 1024 * 1024,
        assert!(
    if let Some(rt) = cpu_exec.handle() {
    }
    .map_err(DataFusionError::Execution)?;
        } else {
pub fn build_shard_files(
            "create_reader: sort_fields ({}) and sort_orders ({}) must have the same length",
        let corrector = Arc::new(PhantomCorrector::new_from_metadata(
/// `create_local_session` with a plan already prepared via
pub unsafe fn sender_close(sender_ptr: i64) {
        let after_size = compacted.columns()[0].get_array_memory_size();
            })?;
        );
        });
/// Build ObjectMeta for each file using the given object store.
    let session_state = ctx.state();
            DataType::Utf8View => {
    fn schema_has_views(schema: &arrow_schema::SchemaRef) -> bool {
    };
        let aligned_list = aligned
            budget.phantom_bytes,
                cpu_executor,
    /// catalog is the authoritative source — Rust never reads generations from parquet
            // Use the recursive variant so nested types (e.g. List<Utf8> child fields)
///   * **Phase 2 (async, background thread):** every `*.stale` entry is
    use datafusion::datasource::MemTable;
        Arc::clone(&table_schema),
        assert_eq!(out.column(0).data_type(), &DataType::Utf8View);
    // requests __row_id__ (QTF query phase); otherwise the ListingTable path.
}
/// Returns `(sender_ptr, schema_ipc_bytes)`. The IPC bytes are written so the
        vec![partition],
            false,
    ));
                compact_string_view_columns(batch)
    let memory_pool = Arc::new(TrackConsumersPool::new(
    input_array_ptr: i64,
                native_bridge_common::log_error!(
        .map(|(col, field)| match field.data_type() {
        // SAFETY: geteuid() is async-signal-safe and has no preconditions.
        let combined = if part.is_empty() {
//! - `stream_next`: async. The bridge layer wraps with `block_on` or `spawn`.
///    `List<element>` (parquet) vs `List<item>` (Substrait) case.
/// Opaque shard view handle returned to the caller.
            execute_indexed_query(
    /// must be cleaned up by the next boot's phase 2, and phase 1 must not
    sort_orders: Vec<String>,
/// Output: [usage, tripped] written to the provided pointer.
            // may leak the borrow — log it so a recurring timeout is visible rather than silent.
            _query_tracking_context: query_context,
    // cached metadata (zero I/O); if not cached, skip budget (first query warms the
    }
    // we just got back to FFI again and write the result back into the input pointers.
    pub row_base: i64,
    let handle = QueryStreamHandle::new_with_plan(wrapped, query_context, permit, physical_plan)
    input_id: &str,
    // Disk pressure: when spill is on and disk is dangerously low, cap parallelism
        }
    debug_assert!(assert_fetch_result_schema(
            "values below 1 clamp up to 1"
/// returning a [`PartitionStreamSender`] pointer the caller drives to push batches in.
        metas.push(meta);
            "physical_plan".to_string(),
    /// and bypasses the chmod 0o555 we use to simulate the locked parent, so the
    config: &DatafusionQueryConfig,
/// leaf — no filename parsing or parquet-footer reads are involved on the production path.
            Arc::ptr_eq(&string_view_array, compacted.column(0)),
    // After dropping the QueryStreamHandle (which drops CrossRtStream → JoinSet →
fn try_acquire_budget_from_cache(
pub struct QueryStreamHandle {
    let session = &*(session_ptr as *const LocalSession);
        }
}
    #[test]
                    for entry in entries {
            let timed_out = mgr
        assert!(
                                log::warn!(
    use arrow::buffer::OffsetBuffer;
        let cleaned = wait_until(2000, || !stale_top.exists() && !stale_dir.exists());
    }
        // Restore the default so test ordering can't leak state into other tests.
    let ffi_schema = FFI_ArrowSchema::from_raw(input_schema_ptr as *mut FFI_ArrowSchema);
        sort_fields,
    /// (and a `Weak` can only be made from an `Arc`). This is the sole strong reference, so the
                .fields()
    object_metas
            has_views,
        let runtime_env =
        };
}
            num_rows: seg.max_doc as u64,
    Ok(Box::into_raw(Box::new(handle)) as i64)
        );
    let mut buf: Vec<u8> = Vec::new();
    use arrow_schema::{Field, Schema};
            Arc::clone(&actual_child),
            // reduce stage's Arrow C Data import then read the view child's buffers as
        )));
    let plan: substrait::proto::Plan = prost::Message::decode(plan_bytes).ok()?;
            physical_plan: None,
// ---------------------------------------------------------------------------
    #[cfg(unix)]
}
            .permissions();
    let plan = Plan::decode(substrait_bytes).map_err(|e| {
    // a `cancel_query(context_id)` call from Java interrupts even before the
            .expect("runtime build");
    } else {
/// Registers a streaming partition input on a `SessionContextHandle` under `input_id`,
        // Phase 1 only requires write on spill_dir, never on its parent.
    /// by the session; dropping it prematurely causes use-after-free.
            .collect();
        )
                            Err(e) => {
/// boot thread pays only the rename count (≈10s of µs per entry) and the
//! pointers via `Box::into_raw`; the caller owns the pointer and must call the
/// aggregate's *physical* output batches, whose state columns are named `<alias>[<state>]`
                        );
    fn non_sliced_batch_skips_gc() {
}
        let runtime = unsafe { &*(ptr as *const DataFusionRuntime) };
    if ptr != 0 {
        set_reduce_target_partitions(8);
    // Acquire memory budget: reserve phantom for untracked memory. Best-effort from
            log::warn!(
    pub file_metadata: Option<Vec<FileRowMetadata>>,
///
    RecordBatch::try_new(target_schema, columns).map_err(|e| {
    /// observe the global runtime state from `create_global_runtime`. cargo test runs tests in
                        .as_any()
                cpu_executor,
            arrow::compute::concat_batches(&schema, &part).map_err(|e| {
        };
    fn conform_batch_casts_utf8_to_declared_utf8view() {
            datafusion::physical_expr::expressions::Column::new(&field_name, col_idx),
        let _guard = lock_process_globals();
                ))
//!   same pointer.
    }
    let df_stream = execute_stream(Arc::clone(&physical_plan), ctx.task_ctx())?;
        return Err(DataFusionError::Execution(format!(
            }
        // Timestamp column kept its actual (nanosecond) type — not truncated to the declared ms.
pub struct ShardFileInfo {
                runtime,
use roaring::RoaringBitmap;
            1,
        //    datafusion-XXXXXX/ that DataFusion provisions next is never a
    runtime.dynamic_limit_handle.set_limit(new_limit as usize);
        );
            }
        use arrow_schema::{Field, Schema};
    /// Top-level symlinks must be unlinked, not followed — otherwise the wipe
        // them in a background thread (remove_file for files/symlinks, remove_dir_all
    }
/// The sender is always dropped. (codex round-5 BLOCKER #1.)
        let seg_idx = segments
                        add(
                Some(rr.names.clone())
        let col = batch.column(i);
    for (i, (a, e)) in actual.fields().iter().zip(expected.fields()).enumerate() {
///
use std::fs;
        let mut array_data = arrow_array::ffi::from_ffi(ffi_array, &ffi_schema).map_err(|e| {
        let schema = Arc::new(Schema::new(vec![Field::new(
    pub row_group_row_counts: Vec<u64>,
/// - `session_ptr` must be a valid, non-zero pointer returned by
                DataFusionError::Execution(format!("partition_batch_by_hash: concat failed: {}", e))
        if !a.data_type().equals_datatype(e.data_type()) {
        let raw = RecordBatch::from(struct_array);
            // still holds. Skipping validation keeps this O(1) instead of a full
            .downcast_ref::<TimestampNanosecondArray>()
    // No concurrency gate here — this is the coordinator/legacy path.
use crate::custom_cache_manager::CustomCacheManager;
        );
                         Verify the process owns the spill directory before restarting.",
///
        let list = ListArray::new(
/// # Safety
            crate::ROW_ID_COLUMN_NAME,
/// Returns a heap-allocated FFI_ArrowArray pointer (as i64), or 0 if end-of-stream
            ])),
        store,
    }
            vec![
        )));
        let schema = Arc::new(Schema::new(vec![
        let col: arrow_array::ArrayRef = Arc::new(TimestampNanosecondArray::from(vec![
        })
pub unsafe fn set_memory_pool_limit(ptr: i64, new_limit: i64) -> Result<(), String> {
// Substrait plan is executed against those inputs, and the output stream is
    );
        set_reduce_target_partitions(0);
        let values: Arc<dyn Array> = Arc::new(StringViewArray::from_iter_values(["a"]));
/// # Safety
use crate::memory::{DynamicLimitHandle, DynamicLimitPool};
    #[test]
        let outside = tmp.path().join("outside_target.txt");
//! # Pointer contract
    let mut config = SessionConfig::new();
            "int_col",
        // Also doubles as a startup-cleanup regression check: drop a "leaked" sentinel
    fn binaryview_gc_compacts_sliced_buffers() {
                           delta: i64| {
            //
    fn conform_batch_passes_through_timestamp_precision_divergence() {
        }
            Field::new("bin_col", DataType::BinaryView, false),
        );
    let (mut query_context, query_memory_pool) =
        )]));
        )
    use arrow_array::Int64Array;
    let (cache_manager_config, custom_cache_manager) = if cache_manager_ptr != 0 {
    // Build PhysicalExprs from the column indices. Need the input schema for column types.
        let num_rgs = wire.num_row_groups as usize;
    }
        let tmp = tempfile::tempdir().expect("tempdir");
            compacted.columns()[0].get_array_memory_size()
                let rg_start = rg.first_row as u32;
/// # Safety
    crate::udaf::register_all(&ctx);
/// Sibling of [`register_partition_stream`] but for the shard-scan path's
        DataFusionError::Execution(format!("Failed to re-export input Arrow C Data: {}", e))
    let parquet_meta = cached
/// this runs exactly once per JVM. A future caller invoking it mid-flight
                Arc::new(StringArray::from(vec![Some("x"), Some("y")])),
    }
    for read in collect_plan_reads(&plan) {
    // internally — so the row-to-partition mapping matches what a downstream RepartitionExec
            let names: Vec<String> = schema.fields().iter().map(|f| f.name().clone()).collect();
        let leftover = tmp.path().join("datafusion-old.stale");
/// The Java side has accumulated all shard responses, exported each
///
            )]))
///
        Some(RelType::Project(p)) => {
    // StreamingTable advertises the declared schema, and downstream operators
    fn create_global_runtime_succeeds_when_jvm_does_not_own_spill_parent() {
            "prior-boot .stale leftover must be cleaned within 2s"
            1,
    permit: Option<tokio::sync::OwnedSemaphorePermit>,
    /// Parallel to `sort_fields`. Sourced from `index.sort.order`.
/// Streaming-input registration for the M3 hash-shuffle AGGREGATE worker.
        /* input_partition */ 0,
    Ok(Box::into_raw(Box::new(handle)) as i64)
        .map(|c| {
            DataType::BinaryView => {
                f.data_type(),
            "sentinel must exist before runtime build"
        .join(", ");
    } else {
            })?
/// `execute_indexed_query` when `classify_filter` returns `None`
            && !declared_names.is_empty()
        unsafe { close_global_runtime(ptr) };
    session_ctx_handle_ptr: i64,
                            }
            );
/// Registers a streaming input on the session under `input_id`. The schema is
            )));
        }
                if let Err(e) = fs::rename(&path, &stale) {
        ));
            array_ptrs.len(),
    #[test]
        // Phase 1: original names gone (renamed to *.stale).
        )]));
        let wider = Arc::new(Schema::new(vec![
    // fn to call. Otherwise the caller's close() segfaults on a null release pointer.
            .expect("ascending_row_id_check_stream: __row_id__ column must be Int64");
///   by the caller; ownership transfers to Rust on success.
        Self {
        per_segment.entry(seg_idx).or_default().insert(local_pos);
/// (`Int64` matching isthmus's `ROW_NUMBER OVER` declaration). The producer
                    .downcast_ref()
/// `ShardScanInstructionHandler` produced; the M1 broadcast memtable lives alongside the
                    | MetricValue::CurrentMemoryUsage(_) => {
    schema_ptrs: &[i64],
        })
        let strings: Vec<&str> = (0..100).map(|_| "short").collect();
    // ones (no-op for already-aligned).
            .map_err(|e| DataFusionError::Execution(format!("StreamWriter::finish: {}", e)))?;
    _session_ctx: Option<datafusion::prelude::SessionContext>,
            "derive_schema_from_partial_plan: decode failed: {}",
            Ok(Box::into_raw(Box::new(ffi_array)) as i64)
            );
        DiskManagerBuilder::default().with_mode(DiskManagerMode::Disabled)
    // monotonically nondecreasing across the entire stream. target_partitions=1
    let first_meta = shard_view.object_metas.first()?;
    table_path: &str,
        );
            };
/// derived by lowering `partial_plan_bytes` (the producer side's substrait) to
    let mut cfg = query_config.clone();
            "Memory pool limit must be non-negative, got {}",
///
            .await
                                "Background spill cleanup: failed to enumerate {} (io kind={:?}): {}",
    let mut reads = Vec::new();
        return None;
fn is_utf8_family(t: &DataType) -> bool {
        let actual_schema = Arc::new(Schema::new(vec![Field::new(
//! - `execute_query`: async. Safe to call concurrently with different shard/runtime pointers.
        .windows(INDEX_FILTER.len())
    runtime: &DataFusionRuntime,
        crate::memory_guard::mark_spill_disabled();
        let stale_loose = spill_path.join("stray.txt.stale");
        std::sync::atomic::Ordering::Release,
/// (the broadcast probe path has no producer-side substrait plan to derive the schema from —
            .expect("runtime LIST batch builds");
        // is taken.
        let view_types = ctx
                                "Background spill cleanup: failed to remove {} (io kind={:?}): {}",
            true,
    // drain this handle unchanged. Use the cancellable variant so the CPU
) -> Result<i64, DataFusionError> {
                // Skip already-renamed leftovers from a prior boot whose async
/// and an Arrow C Data array carries no type information of its own. A batch whose
pub unsafe fn register_memtable(
                        if v > 0 && v < prev {
                sliced_view.data_buffers(),
///
        let listing_options = ListingOptions::new(Arc::new(ParquetFormat::new()))
    let cache_mgr = runtime.custom_cache_manager.as_ref()?;
        panic!(
        declared.metadata().clone(),
/// # Safety
        assert!(ptr > 0);
        };
    );
        }
    // the FFI wrappers from raw pointers without consuming them — clone them by reading
        DiskManagerBuilder::default()
                    );
            DataType::Utf8View,
        )));
            "spill-disabled runtime must surface SpillBudget::Disabled (not Critical) so the caller does not clamp parallelism"
    query_config: crate::datafusion_query_config::DatafusionQueryConfig,
        fs::write(&nested_file, b"nested leak").expect("seed nested file");
///
        );
            .as_any()
            _session_ctx: None,
        .iter()
    plan_bytes: &[u8],
    let (dynamic_pool, dynamic_limit_handle) = DynamicLimitPool::new(memory_pool_limit as usize);
            }
/// the build-side capture sink emits a header-only IPC stream that already carries the
        .map_err(|e| DataFusionError::Execution(format!("Schema conversion failed: {}", e)))?;
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
pub unsafe fn close_local_session(ptr: i64) {
                // contents not touched. Same parent (spill_path), so requires
/// Returns a heap-allocated pointer (as i64) to `ShardView`.
                                "end_timestamp".to_string(),
        );
            actual.fields().len(),
                        // Use file_type (lstat semantics, does not follow symlinks)
                            Ok(ft) => {
use crate::partition_stream::PartitionStreamSender;
            "spill root must be preserved across cleanup"
        .ctx
        object_metas: Arc::new(object_metas),
                        let value = m.value().as_usize() as i64;
    // Register cancellation token.
            (gid as u64) >= seg.global_base && (gid as u64) < seg.global_base + seg.max_doc as u64,
            .with_schema(schema);
        );
        // physical outputs, runtime schema-mismatch on the wire.
    /// Number of row groups in this file.
            !leaked_file.exists(),
                    MetricValue::StartTimestamp(_) => {
    }
            if let Some(input) = &a.input {
/// # Safety
    // ── 2. Build ShardFileInfo with ParquetAccessPlan per file ──
        let mc_arc: Arc<dyn opensearch_tiered_storage::tiered_object_store::MetadataCachingStore> =
///
        crate::substrait_consumer::from_substrait_plan(&session_state, &plan),
        set_reduce_target_partitions(32);
            Field::new("n", DataType::Int64, false),
            path: parent.path(),
        Some(RelType::Filter(f)) => {
) -> Vec<ShardFileInfo> {
        let array_ptr = Box::into_raw(Box::new(out_array)) as i64;
fn assert_fetch_result_schema(
    session_ptr: i64,
    shard_view: &ShardView,
            DataFusionError::Execution(format!(
use datafusion::datasource::physical_plan::parquet::{ParquetAccessPlan, RowGroupAccess};
/// applied here beyond the post-physical coercer. The plan is dropped at
                                path.display(), e.kind(), e
        // Non-empty spill_dir takes the Directories(...) path. tmp_files_enabled() must
/// authoritative schema).
                .apply_pending_phantom_correction();
        let actual_child = Arc::new(Field::new("element", DataType::Utf8View, true));
            names
///
    // ── 5. Wrap and return ──
    let ffi_schema = FFI_ArrowSchema::from_raw(schema_ptr as *mut FFI_ArrowSchema);
        assert!(
// ---------------------------------------------------------------------------
        //    boot loudly with full error context.
    // Acquire budget using measured row bytes from metadata
    Some(result)
            let cast = arrow::compute::cast(col, want.data_type()).map_err(|e| {
        assert!(
        //    (one syscall per entry, contents not touched). Failure aborts
            before_size,
            &datafusion::execution::cache::TableScopedPath {
                 exporting it would misread buffers across FFI",
            // `transform_schema_to_view_recursive`) produced `List<Utf8View>`. The
                "Failed to register streaming table '{}' on session context: {}",
        .map(|(meta, fm)| {
/// # Safety
    #[test]
}
        &columns
                        // to dispatch: directories use remove_dir_all, everything
/// `SessionContextHandle`) EXCEPT the table schema is derived from the producer's PARTIAL
//! - `create_global_runtime` / `close_global_runtime` are not thread-safe for the
            .column(0)
    (Arc::new(cfg), corrector)
/// Identical to [`register_partition_stream_on_session_context`] (channel +
    pub fn get_metrics_json(&self) -> Option<Vec<u8>> {
    // bumps) and isolates the owned-by-Rust working batch from the input wrappers.
    #[test]
    }
        let batch = RecordBatch::try_new(actual_schema, vec![Arc::new(list)]).unwrap();
                DataFusionError::Execution(format!(
        let full_array = StringViewArray::from_iter_values(strings.iter().map(|s| s.as_str()));
    /// Two consumers today:
/// Field names and metadata are ignored: they are not part of the buffer layout, and
            })?;
    /// assertions.
                shard_view.table_path.clone(),
            view_needs_gc(
///
                    tokio::time::timeout(std::time::Duration::from_secs(30), rx).await
//! Functions that accept `i64` pointer arguments require non-zero, valid pointers
/// Zero I/O in all cases.
        // Producer emitted plain Utf8 for the string column.
    /// Used to wait on the background spill-cleanup thread without an arbitrary sleep.
            }
    cache_manager_ptr: i64,
        let col = batch.column(row_id_idx);
                query_memory_pool,
                        let entry = match entry {
    // Per-query memory tracking — wraps the session's global pool. A
        assert!(
    /// no `index.sort.field` configured. Parallel to `sort_orders`.
        assert_eq!(
        &global_pool,
        let compacted = compact_string_view_columns(batch.clone());
    use substrait::proto::read_rel::ReadType;
    #[test]
/// `stream_ptr` must be a valid, non-zero pointer. Must not be called concurrently
            // so every buffer/offset/null invariant validate_data() would check
        let int_array = Int64Array::from_iter_values(0..total_rows as i64);
        &query_config,
            let fields: Vec<Field> = coerced
        // Spill root itself preserved.
        physical_plan.schema(),
        } else if is_utf8_family(col.data_type()) && is_utf8_family(want.data_type()) {
                        // else (regular files, symlinks) uses remove_file. This
        pool,
    ///     `output_ordering` from the scan and the `sort_prefix` optimization fires on
    let shard_view = &*(shard_view_ptr as *const ShardView);
                .iter()
    // Route to the indexed executor when the plan has an index_filter UDF or
/// Delivery is OUT-OF-BAND (`PartitionStreamSender::fail` sets a flag the receiver reads on close), so
    // Empty spill_dir is the "disabled" sentinel from Java. Build the runtime with
            .saturating_sub(1);
            .with_max_temp_directory_size(effective_spill_limit)
    let mut files: Vec<ShardFileInfo> = Vec::new();
        // for dirs). The original names are gone immediately after phase 1; wait
            spill_path.is_dir(),
                phantom_corrector,
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, spill_path, 1024 * 1024 * 1024)
}
    let mut metas = Vec::with_capacity(filenames.len());
            .fields()
        );
    RecordBatch::try_new(schema, columns).expect("gc'd columns must match schema")
///   by this function; the caller releases them.
            use arrow::datatypes::{Field, Schema};
        store.as_ref(),
    // cancel then can't interrupt an in-flight drain (the ~5s LM stall).
        .state()
/// end-of-input.
        let mut array_data = arrow_array::ffi::from_ffi(ffi_array, &ffi_schema).map_err(|e| {
pub unsafe fn stream_close(stream_ptr: i64) {
use arrow_schema::ffi::FFI_ArrowSchema;
        // outside_target sits next to spill/. If cleanup followed the symlink, it would be deleted.
        Some(RelType::Set(s)) => {
        .iter()
            "error must identify it as a cleanup failure; got: {}",
        let declared: SchemaRef = Arc::new(Schema::new(vec![
        Ok(batch)
    // layouts, so this must be a real cast rather than a relabel. Other tolerated
        ));
            _concurrency_permit: permit,
    filenames: Vec<String>,
                collect_reads(input, out);
        assert_eq!(compacted.num_rows(), 0);
/// Executes a Substrait plan against a `LocalSession` and returns a
            !sentinel.exists(),
    }
                            .unwrap_or(0);
                    );
}
        .collect::<Vec<_>>()
        let tmp = tempfile::tempdir().expect("tempdir");
            !tmp.path().join("datafusion-old.stale.stale").exists(),
            ])),
/// # Safety
    // data is reused verbatim.
    // `cancellable_or` to a bare uncancellable await — the reduce sink's
            "spill-enabled runtime must NOT surface SpillBudget::Disabled"
    //
            .map(|i| format!("long_string_value_{:06}_padding", i))
    // derive_schema_from_partial_plan applies `schema_coerce::coerce_inferred_schema`
    }
pub unsafe fn get_memory_pool_usage(ptr: i64) -> i64 {
/// `ReadRel.base_schema` to the registered provider BY NAME. The producer ships the PARTIAL
    // sender_close. fail() records the reason out-of-band BEFORE that drop; the receiver yields it on
        .downcast_ref::<ParquetMetaData>()?;
                }
        )]));
        let declared_child = Arc::new(Field::new("item", DataType::Utf8View, false));
        )]));
/// Build `ShardFileInfo` from object metas and file metadata.
        query_tracker::QueryType::Coordinator,
            // Spawn failure itself is rare (EAGAIN/ENOMEM under extreme system
    .map(Arc::new)?;
/// Executes the previously prepared final-aggregate plan on a local session.
        crate::partition_stream::SingleReceiverPartition::new(receiver),
///
    let disk_capped_partitions = match per_query_spill_budget() {
        let schema_ptr = Box::into_raw(Box::new(out_schema)) as i64;
            }
        let actual_field = Field::new("tags", DataType::List(actual_child), true);
    fn collect_metrics(
            filenames.len(),
///
            schema,
    shard_view_ptr: i64,
    }
/// logged only; the cluster has either joined or is about to, and
        })?;
/// The input batch is borrowed (not consumed) — the Java caller retains ownership and is
            true,
/// later mid-query anyway. Phase 2 failures (including thread-spawn) are
/// Closes a `LocalSession`. Safe to call with 0 (no-op).
/// column), so runtime batches arrive with the same type tags the consumer
        .runtime_env()
}
/// [`LocalSession::prepare_final_plan`].
        unsafe { close_global_runtime(ptr) };
                            .unwrap_or(i64::MAX);
        if col.data_type() == want.data_type() {
            });
        fs::create_dir(&leaked_dir).expect("create leaked subdir");
    config.options_mut().execution.parquet.pushdown_filters = true;
                    );
        context_id,
            true,
        session.reduce_target_partitions(budget.target_partitions);
    let cpu_exec = manager.cpu_executor();
    use datafusion_substrait::logical_plan::producer::to_substrait_plan;
/// which the receiver side (DataFusion's streaming table) interprets as
/// Returns the sender pointer; the caller frees it via [`crate::ffm::df_sender_close`].
    }
/// <p>The coercer flips Arrow-only types (notably `UInt64` from DataFusion's
    /// topology). `fs::remove_dir_all(spill_dir)` would fail at the final
    const ROW_ID: &[u8] = crate::ROW_ID_COLUMN_NAME.as_bytes();
/// # Safety
        NonZeroUsize::new(5).unwrap(),
use crate::local_executor::LocalSession;
    let runtime = &*(ptr as *const DataFusionRuntime);
/// whose cleanup thread did not finish.
    batch: &RecordBatch,
    /// this routes reads through TieredObjectStore (local + remote).
fn resolve_dynamic_spill_limit(spill_dir: &str) -> u64 {
    let cache = cache_mgr.get_file_metadata_cache_for_datafusion()?;
/// substrait) the same way `register_partition_stream` does. Returns the
    context_id: i64,
        // be true so spill attempts succeed. The budget must NOT be Disabled —
            matches!(
    // this stream is mid-flight; a `None` token here silently degrades
        manager.cpu_executor(),
/// Imports a batch of Arrow C Data structures into a [`Vec<RecordBatch>`] and
}
            .with_listing_options(listing_options)
            let spill_path_for_gc = spill_path.clone();
                "fetch_by_row_ids: result schema missing requested column {}, got {:?}",
        .any(|w| w == INDEX_FILTER)
            "register_memtable_on_session_context: array_ptrs.len()={} != schema_ptrs.len()={}",
                    .iter()
        stream: RecordBatchStreamAdapter<CrossRtStream>,
            "background cleanup must remove both *.stale entries within 2s"
        if spill_path.exists() {
    }
    shard_view_ptr: i64,
            DataType::List(expected_child),
            !outer_subdir.exists(),
            _query_tracking_context: query_context,
    let object_metas = tokio_rt_manager.io_runtime.block_on(create_object_metas(
        );
    // honor that by reconstructing the FFI structs only momentarily here, calling from_ffi,
                    "Failed to align imported batch to registered schema for '{}': {}",
pub unsafe fn get_memory_pool_stats(ptr: i64, out_ptr: *mut i64) {
/// Safe to call with 0 (no-op).
        // set_spill_dir flips SPILL_ENABLED on. Whether it's Available or Critical
                Arc::new(arrow_array::Int64Array::from(vec![1, 2, 3])),
    #[test]
        fs::write(&leaked_file, b"stale spill data").expect("seed leaked file");
        unsafe { close_global_runtime(ptr) };
    let handle = QueryStreamHandle::new(wrapped, query_context, permit).with_task_done(task_done);
            stream,
                        );
    // now Rust's responsibility to drop.
        let num_rgs = seg.row_groups.len();
                    DataFusionError::Configuration(msg)
    *out_ptr.add(1) = runtime.dynamic_limit_handle.tripped_count() as i64;
                fields,
            "str_col",
///
                access_plan: None,
pub fn create_reader(
            !loose_file.exists(),
    // first batch is produced (planning, from_substrait_plan, repartition
            if let Some(input) = &p.input {
    // conform_batch_to_schema. (A cast copies only the mismatched columns, ending
        let estimated_batch_bytes = if budget.phantom_bytes > 0 && batches_in_pipeline > 0 {
        // Phase 1: both originals are renamed inline — gone immediately by the
        None => return stream, // schema-presence checked elsewhere; nothing to validate here
        fs::set_permissions(parent.path(), locked).expect("chmod parent 555");
        fields,
            && declared_names.len() == partial_schema.fields().len()
/// non-polling consumer, and it surfaces the error even when the channel is full. If the receiver was
    ///     TopK / SortPreservingMerge.
            Arc::new(Field::new("element", DataType::Utf8View, true)),
            cfg.batch_size * 100 // fallback
    shard_view: &ShardView,
        let combined_data: arrow::array::ArrayData = StructArray::from(combined).into();
    use futures::StreamExt;
    schema: &datafusion::arrow::datatypes::Schema,
                        Err(e) => {
}
        let original_offsets = list.value_offsets().as_ptr();
            .to_string();
                sliced_view.total_buffer_bytes_used()
        .ctx
/// 2. Layout-identical nested types ([`DataType::equals_datatype`]: same buffers and
        // is gone immediately; wait for the .stale name to disappear too.
            CachedFileList::new(object_metas.as_ref().clone()),
        let out = super::conform_batch_to_schema(batch, &declared).unwrap();
    })?;
                        path.display(),
        // Seed both a top-level file and a nested subdirectory + file to verify
        );
                        .expect("column must be BinaryViewArray when schema declares BinaryView");
    #[test]
        // over Utf8View / Timestamp(Millisecond) — same plan, divergent
                        if let Err(e) = result {
    // The default LocalFileSystem has no warm tier → keep the narrow scoped fetch.
    is_significantly_bloated && waste > GC_MIN_WASTE_BYTES
///   `register_partition_stream`.
/// # Side effect: spill directory contents are wiped (two-phase)
    std::ptr::write(input_array_ptr as *mut FFI_ArrowArray, re_array);
    let batch = conform_batch_to_schema(borrowed_batch, sender.schema())?;
fn view_needs_gc(buffers: &[arrow::buffer::Buffer], bytes_used: usize) -> bool {
/// Returns a heap-allocated pointer (as i64) to `DataFusionRuntime`.
        )
        let arrow_schema = if view_types {
            token.clone(),
    let _ = std::fs::create_dir_all(spill_dir);
                let rg_bitmap: RoaringBitmap = bm
        }
/// identifier a plan would otherwise contain.
    // nullability/metadata/field-naming details; rebuild each imported batch
        debug_assert!(
    physical_plan: Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
        // Two-phase to keep boot fast even when prior orphans hold tens of GB:
    };
        let leaked_a = tmp.path().join("datafusion-aB3kF7");
        let tmp = tempfile::tempdir().expect("tempdir");
/// batch.
    use datafusion::datasource::listing::{ListingOptions, ListingTable, ListingTableConfig};
    // Caller-supplied `columns` includes __row_id__ in its desired position. We project
            // Same buffer layout and nullability, differing only in child field
        stream: RecordBatchStreamAdapter<CrossRtStream>,
            "background cleanup must remove the .stale sentinel within 2s"
    None
    #[test]
        };
        let config = ListingTableConfig::new(table_path)
                        serde_json::Value::Number(serde_json::Number::from(prev + delta)),
            if predicate() {
        // Wipe leaked entries from a prior non-graceful shutdown.
                plan_bytes.to_vec(),
/// `shard_view_ptr` and `runtime_ptr` must be valid, non-zero pointers.
    let shard_view = &*(shard_view_ptr as *const ShardView);
/// Looks up the first file's ParquetMetaData from the file metadata cache.
        );
    // Adaptively reduces target_partitions if the phantom doesn't fit at full
pub unsafe fn sender_send(
}
        let stale_a = tmp.path().join("datafusion-aB3kF7.stale");
}
        let strings: Vec<String> = (0..10_000)
            "symlink target contents must be preserved verbatim"
/// `writer_generations[i]` is the generation of `filenames[i]`. Both come from the Java
}
            );
use datafusion::physical_plan::execute_stream;
/// Extracts the `base_schema` NamedStruct from the plan's first ReadRel matching `table_name`.
    }
            Field::new("int_col", DataType::Int64, false),
        return Err(DataFusionError::Execution(format!(
        let seg = &segments[seg_idx];
        //    <name>.stale sibling. One uniform branch — files, symlinks, and
        // depends on the test host's free disk; both prove the enabled-path branch
                DataType::Utf8View => {
    let (sender, receiver) = crate::partition_stream::channel(Arc::clone(&table_schema));
        fs::write(leaked_a.join("tmp_001.arrow"), b"data a").expect("write a");
    REDUCE_TARGET_PARTITIONS.store(
/// phase 2 via `remove_file`, so a stray symlink can never redirect the
            vec![Arc::new(Int64Array::from(vec![1]))],
        let spill_str = spill_path.to_str().expect("utf-8 path");
        None => Ok(0),
//! Bridge-agnostic API layer.
            for input in &e.inputs {
    }
        // String column conformed to the declared view type.
    let (cross_rt_stream, _abort_handle, task_done) =
        assert_eq!(
///
        assert!(!leaked_a.exists(), "original orphan a must be renamed away");
        let tmp = tempfile::tempdir().expect("tempdir");
        let batch = RecordBatch::try_new(schema, vec![Arc::clone(&string_view_array)]).unwrap();
        let spill_path = PathBuf::from(spill_dir);
    use datafusion_substrait::extensions::Extensions;
    // Gating happens inside the executor functions (execute_query / execute_indexed_query)
        .with_physical_optimizer_rules(crate::agg_mode::physical_optimizer_rules_without_combine())
    /// input batches are released before the per-query allocator closes. `None` outside coordinator-reduce.
}
        let compacted = compact_string_view_columns(sliced);
        let tmp = tempfile::tempdir().expect("tempdir");
        let declared = Arc::new(Schema::new(vec![Field::new(
    if let Some(rt) = cpu_rt_handle {
    ) -> Self {
    /// When present, enables ShardTableProvider construction with row_base.
fn root_rel(root: &substrait::proto::PlanRel) -> Option<substrait::proto::Rel> {
                "tags",
        unsafe { close_global_runtime(ptr) };
pub fn set_min_target_partitions(value: i64) {
    substrait_bytes: &[u8],
            .infer_schema(&ctx.state(), &table_path)
            .schema_force_view_types;
    let mut exprs: Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>> =
        );
    Ok(reader.schema())
    // for the producer (e.g. `Int64` for `ROW_NUMBER OVER`). The producer side runs the
                    let view: &arrow_array::StringViewArray = col
    }
                let msg = format!(
            fields.push(Arc::clone(want));
    fn conform_batch_is_noop_when_schemas_match() {
        DataFusionError::Execution(format!(
    use crate::indexed_table::row_selection::build_row_selection_with_min_skip_run;
            mode: original_parent_mode,
    pool: &Arc<dyn MemoryPool>,
fn use_indexed_path(plan_bytes: &[u8]) -> bool {
            ))
/// Wraps a stream in an adapter that asserts each emitted batch's `__row_id__` column
    let actual = batch.schema();
///
            .ok_or_else(|| DataFusionError::Execution("ReadRel missing base_schema".to_string()))?;
    // stream channels that require a Tokio reactor. Enter the IO runtime's
        };
        .map_err(|e| {
        if let Some(rel) = root_rel(plan_rel) {
///
                None
/// The schema is derived by lowering `partial_plan_bytes` (the producer side's
        predicate()
    let borrowed_batch = RecordBatch::from(struct_array);
            Arc::new(Schema::new(vec![Field::new(
    let shard_view = ShardView {
                    "sender_send: failed to cast column {} ('{}') from {:?} to declared {:?}: {}",
/// stream's batches match its `schema()`; this turns any violation into a query
        // to enumerate a non-directory and returns ErrorKind::NotADirectory.
                        };
        );
        let before_size = batch.columns()[0].get_array_memory_size();
        vec![partition],
            // `List<item>`). Relabel the ArrayData in place.
    // each column verbatim except __row_id__, which we replace with the synthesized
                })
        let list_file_cache = Arc::new(DefaultListFilesCache::default());
            has_views,
) -> Result<crate::partition_stream::SendOutcome, DataFusionError> {
        from_substrait_named_struct, DefaultSubstraitConsumer,
pub unsafe fn register_partition_stream(
/// Caller must call `close_reader` exactly once to free it.
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int64, false)]));
        let df_schema = from_substrait_named_struct(&consumer, base_schema)?;
    let cached = cache.get(&first_meta.location)?;
        // guards against future refactors that hoist the cleanup out of the else-branch.
/// Decodes an Arrow IPC stream-format header into a [`SchemaRef`]. The Java side
                        key,
/// # Operator contract
    }
    input_id: &str,
        return Err(DataFusionError::Execution(format!(
    debug_assert!(
        Arc::clone(&shard_view.store),
                let add = |map: &mut serde_json::Map<String, serde_json::Value>,
            continue;
            "sender_send: batch column count {} does not match declared schema {}",
//!
    let table_url = ListingTableUrl::parse(table_path)
                        let path = entry.path();
/// Tripwire at the FFI export boundary — checks, never casts.
                        if !name.to_string_lossy().ends_with(".stale") {
            )
) -> Result<Vec<object_store::ObjectMeta>, DataFusionError> {
        // No data conversion happens at runtime — these only configure the
    manager: &crate::runtime_manager::RuntimeManager,
        use arrow_schema::{Field, Schema};
            crate::memory_guard::SpillBudget::Disabled,
        ));
