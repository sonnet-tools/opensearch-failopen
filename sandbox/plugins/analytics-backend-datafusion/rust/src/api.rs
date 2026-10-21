            )));
        let cleaned = wait_until(2000, || !stale_loose.exists() && !stale_dir.exists());
    };
                native_bridge_common::log_error!(
    std::ptr::write(input_array_ptr as *mut FFI_ArrowArray, re_array);
        // file in the directory before the call and assert it's gone after.
        );
                        let result = match entry.file_type() {
    fn create_global_runtime_clears_leaked_spill_files_recursively() {
    // Empty spill_dir is the "disabled" sentinel from Java. Build the runtime with
            }
            spill_path.exists(),
                                path.display(), e.kind(), e
    let store_url = store_url_from_table_path(&shard_view.table_path)?;
        // Timestamp precision mismatch (must pass through).
        runtime,
        metadata_cache,
            has_views,
//!   single thread (node startup/shutdown).
    }
) -> datafusion::execution::SendableRecordBatchStream {
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, spill_path, 1024 * 1024 * 1024)
            .downcast_ref::<Int64Array>()
                .iter()
        let batch = RecordBatch::try_new(schema, vec![Arc::clone(&string_view_array)]).unwrap();
    // reservation/corrector to the query context.
        Some(RelType::Project(p)) => {
                        .expect("column must be BinaryViewArray when schema declares BinaryView");
            .execution
            "derive_schema_from_partial_plan: decode failed: {}",
    let (df_stream, physical_plan) = cancellation::cancellable(
        let mc_arc: Arc<dyn opensearch_tiered_storage::tiered_object_store::MetadataCachingStore> =
    let cached = cache.get(&first_meta.location)?;
    #[test]
        .map_err(|e| {
            physical_plan: Some(plan),
}
/// `stream_next` / `stream_close` exports.
            "prior-boot .stale leftover must be cleaned within 2s"
        let expected_child = Arc::new(Field::new("item", DataType::Utf8View, true));
    /// Pre-existing *.stale entries from a prior boot whose phase 2 didn't finish
            "stream_next: batch column count {} does not match declared schema width {}",
/// Imports a batch of Arrow C Data structures into a [`Vec<RecordBatch>`] and
    // Grab the CPU runtime handle BEFORE drop — drop removes the tracker from
    // `from_ffi` takes the array by value (consumes it) and the schema by
            before_size / after_size
    let session_state = ctx.state();
    substrait_bytes: &[u8],
        fields,
        let nested_file = nested_dir.join("deep.tmp");
/// will be present in the plan's extension declarations.
            let struct_array: StructArray = batch.into();
        from_substrait_named_struct, DefaultSubstraitConsumer,
/// Output: [usage, tripped] written to the provided pointer.
        .map(|_| Vec::with_capacity(1))
                FALLBACK / (1024 * 1024 * 1024)
    }
                // symlinks, and directories — fs::rename does not follow
        // its lowered output schema as substrait extension metadata so the
    // stream_next on each batch pull.
        );
    (Arc::new(cfg), corrector)
    let schema_ipc = schema_to_ipc_bytes(table_schema.as_ref())?;
        // batches whose buffers are 8-byte-aligned slices into the IPC body (per spec) but
            .finish()
            None,
                runtime,
            // pressure) and not boot-fatal: the disk is already in a valid
    // Disk pressure: when spill is on and disk is dangerously low, cap parallelism
            .with_mode(DiskManagerMode::Directories(vec![PathBuf::from(spill_dir)]))
            // per-value UTF-8 and offset scan on every batch.
    use datafusion_substrait::logical_plan::producer::to_substrait_plan;
///
/// Encodes a Schema as Arrow IPC stream-format bytes (a schema-only message
        assert!(!leaked_b.exists(), "original orphan b must be renamed away");
    /// environment is dropped when Java closes this runtime, exactly as it was when held by value.
    // Overwrite the input FFI structs with the re-exported ones. This is OK because the
        custom_cache_manager,
/// On error ownership is released back to Rust's drop impls (the imported
                        build_row_selection_with_min_skip_run(&rg_bitmap, rg.num_rows as usize, 1);
///
            })?;
    #[test]
        let err = ensure_batch_matches_stream_schema(&batch, &mk("item", DataType::Utf8))
/// Whether a shard query routes to the indexed executor (vs the ListingTable path),
        let batch = RecordBatch::try_new(schema, vec![Arc::new(string_view_array)]).unwrap();
            Arc::new(Field::new("element", DataType::Utf8View, true)),
                }
        fs::create_dir(&spill_path).expect("create spill mount-point dir");
                        if v > prev {
                        if v > 0 && v < prev {
    plan: &substrait::proto::Plan,
    }
        if euid == 0 {
        }
        default_rt.object_store(&table_url)?
        per_segment.entry(seg_idx).or_default().insert(local_pos);
    // nullability/metadata/field-naming details; rebuild each imported batch
pub unsafe fn register_partition_stream(
    fn schema_has_views(schema: &arrow_schema::SchemaRef) -> bool {
    /// Parallel to `sort_fields`. Sourced from `index.sort.order`.
///
        use arrow_schema::{Field, Schema, TimeUnit};
                                if ft.is_dir() && !ft.is_symlink() {
        );
    pub object_meta: object_store::ObjectMeta,
/// Returns the sender pointer; the caller frees it via [`crate::ffm::df_sender_close`] once
    input_id: &str,
use std::fs;
/// Opaque shard view handle returned to the caller.
    let mut last_seen: Option<i64> = None;
    #[test]
use crate::indexed_executor::execute_indexed_query;
    spill_limit: i64,
            // may leak the borrow — log it so a recurring timeout is visible rather than silent.
    /// When present, enables ShardTableProvider construction with row_base.
        let tmp = tempfile::tempdir().expect("tempdir");
                shard_view.table_path.clone(),
                    }
        let default_rt = RuntimeEnvBuilder::new().build()?;
}
            .permissions()
    pub store: Arc<dyn ObjectStore>,
}
/// >0 = `Box<Arc<dyn MetadataCachingStore>>` pointer (routes reads through TieredObjectStore;
) -> Option<substrait::proto::NamedStruct> {
        );
    fn stream_schema_tripwire_ignores_child_names_but_rejects_layout_mismatch() {
        .unwrap_or_default();
    use arrow::buffer::OffsetBuffer;
    let actual_schema = batch.schema();
/// input.
            // AND any *.stale leftovers from prior boots whose cleanup didn't
    // cancel then can't interrupt an in-flight drain (the ~5s LM stall).
            "spill mount-point dir must be preserved"
            let v = arr.value(i);
    // sender_close. fail() records the reason out-of-band BEFORE that drop; the receiver yields it on
}
    runtime.dynamic_limit_handle.set_limit(new_limit as usize);
/// # Safety
    }
    manager: &RuntimeManager,
    let (effective_config, phantom_corrector) = resolve_effective_config(
            }
            .indent(true)
    // Reclaim ownership so the sender (and its channel) is dropped at end of scope — mirrors
    let logical_plan = futures::executor::block_on(
    // Caller-supplied `columns` includes __row_id__ in its desired position. We project
    // requests __row_id__ (QTF query phase); otherwise the ListingTable path.
            }
}
        query_context: QueryTrackingContext,
            cleaned,
            .infer_schema(&ctx.state(), &table_path)
pub struct ShardView {
}
///
        .downcast_ref::<ParquetMetaData>()?;
    // task can be aborted mid-execution when cancel_query fires.
        use arrow_array::{StringArray, TimestampNanosecondArray};
        );
        let actual_child = Arc::new(Field::new("element", DataType::Utf8View, true));
            _query_tracking_context: query_context,
            let info = ShardFileInfo {
    if stream_ptr == 0 {
        };
                .try_next()
                            map.insert(
            execute_indexed_query(
    let ffi_array = FFI_ArrowArray::from_raw(input_array_ptr as *mut FFI_ArrowArray);
            Arc::new(Schema::new(vec![Field::new(
            )
            //
use datafusion::common::DataFusionError;
/// released back to Rust's drop impls (the imported structs go out of scope
        assert!(
        // the conform step must leave the column (and its actual type) untouched.
    matches!(t, DataType::Utf8 | DataType::Utf8View)
        },
    // and then leaking the FFI handles back to the heap via Box::into_raw — leaving the
}
            && !declared_names.is_empty()
        table_path: table_url,
///   by the caller; ownership transfers to Rust on success.
    spill_dir: &str,
const GC_MIN_WASTE_BYTES: usize = 10_240;
/// This is an async function — the bridge layer decides how to run it
                // Skip already-renamed leftovers from a prior boot whose async
            .permissions();
    internal_search: crate::datafusion_query_config::InternalSearch,
/// If cached: extracts the schema + measured row bytes, acquires budget.
        let has_views = Self::schema_has_views(&stream.schema());
    session_ctx_handle_ptr: i64,
        ]));
    runtime_ptr: i64,
    let pool = &session.memory_pool();
            .base_schema
    // in single-JVM test topologies where coordinator and data node share a gate.
            serde_json::Value::String(plan_text),
    // path that task still holds Java-borrowed input batches. Wait for it to fully unwind (signal
    }
            .column(0)
        assert!(ptr > 0);
/// `store_ptr`: 0 = use default LocalFileSystem (hot path),
                "Dynamic spill limit: {} bytes (80% of {} available on {})",
            custom_cache_manager: None,
    input_id: &str,
                );
        ]));
    )
    batch: &RecordBatch,
            runtime.runtime_env.disk_manager.tmp_files_enabled(),
            .zip(schema.fields().iter())
                Field::new("ts", DataType::Timestamp(TimeUnit::Nanosecond, None), true),
        // Spill root itself preserved.
        assert!(err.to_string().contains("misread buffers"), "{err}");
// ---- Memory pool observability and dynamic limit ----
    // Build PhysicalExprs from the column indices. Need the input schema for column types.
///
        let total_rows = 100_000usize;
            .expect("stat parent")
fn try_acquire_budget_from_cache(
///
                                "Background spill cleanup: failed to enumerate {} (io kind={:?}): {}",
/// authoritative schema).
        let slice_rows = 10usize;
/// Returns a heap-allocated pointer (as i64) to `LocalSession`. Caller must
    }
) -> Result<i64, DataFusionError> {
        assert!(
            has_views,
    /// Total rows in this file.
            (gid as u64) >= seg.global_base && (gid as u64) < seg.global_base + seg.max_doc as u64,
        assert!(Arc::ptr_eq(out.column(0), &col));
/// 1. Exact type match: reuse the column, adopt the declared field (metadata agrees).
                    };
    let actual = batch.schema();
        // is taken.
            DataFusionError::Execution(format!("Failed to import Arrow C Data array: {}", e))
            spill_limit
                    }
/// Returns an error if `new_limit` is negative.
        _ => {}
}
            .expect("runtime build");
        // subdirectories) before / during constructing the DiskManager.
        plan: &dyn datafusion::physical_plan::ExecutionPlan,
        assert!(
//! pointers via `Box::into_raw`; the caller owns the pointer and must call the
        let plan_text = datafusion::physical_plan::displayable(plan.as_ref())
pub unsafe fn get_memory_pool_usage(ptr: i64) -> i64 {
    let use_indexed = use_indexed_path(plan_bytes);
            &*(store_ptr
            1024 * 1024 * 1024,
    /// Row counts per row group in this file.
            continue;
            datafusion::physical_expr::expressions::Column::new(&field_name, col_idx),
        self
            if let Some(right) = &j.right {
    // Post-condition: returned stream schema must contain __row_id__ plus every requested column.
    tokio_rt_manager: &RuntimeManager,
    .await
        // Two-phase to keep boot fast even when prior orphans hold tens of GB:
            "Expected large reduction for BinaryView, got before={} after={} ratio={}",
    Ok(())
use crate::memory::{DynamicLimitHandle, DynamicLimitPool};
        // Phase 2 will eventually remove both *.stale entries.
/// responsible for closing the input FFI structs after this call returns. Output structs
        assert_eq!(
    use crate::indexed_table::row_selection::build_row_selection_with_min_skip_run;
/// UTF-8 content but use distinct buffer layouts. Mirrors the Java sink's
            Field::new("int_col", DataType::Int64, false),
        let wider = Arc::new(Schema::new(vec![
            // `transform_schema_to_view_recursive`) produced `List<Utf8View>`. The
    session_ptr: i64,
///
                 exporting it would misread buffers across FFI",
        parquet_meta.file_metadata().key_value_metadata(),
        .with_physical_optimizer_rules(crate::agg_mode::physical_optimizer_rules_without_combine())
                    .build_unchecked()
/// Decode an array of `WireFileMetadata` from an FFM pointer.
            _concurrency_permit: permit,
            .expect("aligned column remains LIST");
                input_id, e
        let num_rgs = wire.num_row_groups as usize;
    /// this routes reads through TieredObjectStore (local + remote).
/// leaf — no filename parsing or parquet-footer reads are involved on the production path.
    }
        //
    fn stream_schema_tripwire_rejects_column_count_mismatch() {
            crate::ROW_ID_COLUMN_NAME,
        .cache_manager
        }
    table_name: &str,
            cfg.batch_size * 100 // fallback
            Field::new("s", DataType::Utf8View, true),
    *out_ptr.add(1) = runtime.dynamic_limit_handle.tripped_count() as i64;
            .with_max_temp_directory_size(effective_spill_limit)
                let rg_start = rg.first_row as u32;
                    view_needs_gc(view.data_buffers(), view.total_buffer_bytes_used())
            1,
        permit: Option<tokio::sync::OwnedSemaphorePermit>,
use datafusion::datasource::listing::ListingTableUrl;
pub fn set_min_target_partitions(value: i64) {
    if let Some(rx) = task_done {
/// Returns a heap-allocated pointer (as i64) to `ShardView`.
                    "sender_send: failed to cast column {} ('{}') from {:?} to declared {:?}: {}",
            .map_err(|e| {
                ))
        assert!(
    if actual_schema.as_ref() == declared.as_ref() {
    // the registry, making it unreachable for flush_cpu_runtime.
        //
/// logical names. The producer's physically-named batches still feed in fine: the streaming
/// declared and physical types.
            ))
                Arc::new(StringArray::from(vec![Some("x"), Some("y")])),
        query_tracker::QueryType::Coordinator,
                log::error!("{}", msg);
            // `List<item>`). Relabel the ArrayData in place.
        let plan = self.physical_plan.as_ref()?;
// drained via the existing `stream_next` / `stream_close` exports (because
// reduce stage, streaming inputs are registered under synthetic names, a
    }
    let ffi_schema = FFI_ArrowSchema::from_raw(schema_ptr as *mut FFI_ArrowSchema);
    } else {
        query_tracker::set_cpu_runtime_handle(context_id, rt);
        ctx: datafusion::prelude::SessionContext,
        let runtime = unsafe { &*(ptr as *const DataFusionRuntime) };
            .expect_err("create_global_runtime must fail when cleanup fails");
    // for the producer (e.g. `Int64` for `ROW_NUMBER OVER`). The producer side runs the
use std::num::NonZeroUsize;
    fn non_sliced_batch_skips_gc() {
///
            .map(|i| format!("binary_payload_{:08}_extra_bytes", i).into_bytes())
                    .map(|pos| pos - rg_start)
/// fresh `datafusion-XXXXXX/` and never touches siblings. The fresh dir's
        // Operator-confirmed contract: the spill directory is OpenSearch-owned and any
/// Imports an Arrow C Data batch and pushes it through the partition
        let mgr = unsafe { *Box::from_raw(cache_manager_ptr as *mut CustomCacheManager) };
        token.as_ref(),
    // Distribute global row_ids to per-file local positions.
            .partition_point(|s| s.global_base <= gid as u64)
        // Include the physical plan display text
        unsafe { close_global_runtime(ptr) };
                Arc::new(view.gc()) as Arc<dyn Array>
                "Failed to get object meta for {}: {}",
    fn no_view_columns_passthrough() {
    }
//! Bridge-agnostic API layer.
}
/// Why this matters (the q1/q15 fix): DataFusion's Substrait consumer binds a `NamedTable`
                        .as_any()
/// If `context_id != 0`, registers a cancellation token in ACTIVE_QUERIES before
        let string_view_array: Arc<dyn Array> = Arc::new(StringViewArray::from_iter_values(
        assert_eq!(out.column(1).data_type(), &DataType::Int64);
            estimated_batch_bytes,
/// `List<Utf8>` vs `List<Utf8View>` JVM SIGSEGV). DataFusion guarantees that a
        // Without these, HashAggregateExec lowers over Utf8 / Timestamp(Second)
///
        let num_rgs = seg.row_groups.len();
    .map_err(DataFusionError::Execution)?;
        // create_global_runtime must clear the directory recursively (files AND
            .iter()
            !runtime.runtime_env.disk_manager.tmp_files_enabled(),
        .runtime_env()
/// [`schema_coerce::coerce_inferred_schema`]** to types Substrait can bind
    }
        assert!(
    let (mut query_context, query_memory_pool) =
/// Cheap check: scan the substrait plan bytes for the `index_filter` function
    match root.rel_type.as_ref()? {
                // symlinks (it renames the link itself).
// `execute_local_plan` hands back a `QueryStreamHandle` of the same shape
pub unsafe fn sql_to_substrait(
    }
        let schema = Arc::new(Schema::new(vec![Field::new(
/// structs go out of scope without being forgotten).
        substrait::proto::plan_rel::RelType::Rel(r) => Some(r.clone()),
    }
                            log::warn!(
        // No data conversion happens at runtime — these only configure the
        };
    /// footers in production. Footer-kv reads, when they happen, are debug-only
            }
            _query_tracking_context: query_context,
    pub dynamic_limit_handle: DynamicLimitHandle,
        let arrow_schema = df_schema.as_arrow().clone();
    let mut cfg = query_config.clone();
            DataType::Utf8View => {
/// `QueryStreamHandle` pointer whose output can be drained via the existing
            RecordBatch::try_new(mk("element", DataType::Utf8View), vec![Arc::new(list)]).unwrap();
        impl Drop for RestorePerms<'_> {
}
    Ok(Box::into_raw(Box::new(runtime)) as i64)
pub unsafe fn register_partition_stream_on_session_context(
        )]));
            if let Some(input) = &a.input {
        assert!(ptr > 0);
/// represent in its logical type system. Parquet's TIMESTAMP supports
        dynamic_limit_handle,
    /// A child-nullability mismatch is NOT layout-equivalent: relabeling a nullable
            // Use the recursive variant so nested types (e.g. List<Utf8> child fields)
            dynamic_limit_handle: handle,
        )));
        // Seed both a top-level file and a nested subdirectory + file to verify
    }
    pub fn with_task_done(mut self, task_done: tokio::sync::oneshot::Receiver<()>) -> Self {
        let cleaned = wait_until(2000, || !stale_link.exists());
                         Verify the process owns the spill directory before restarting.",
        futures::executor::block_on(session_state.create_physical_plan(&logical_plan))?;
            !sentinel.exists(),
                let view: &arrow_array::StringViewArray = col
        SpillBudget::Critical => 1,
            .with_collect_stat(true);
    use datafusion::execution::cache::CacheAccessor;
    // drain this handle unchanged. Use the cancellable variant so the CPU
        .unwrap();
                DataFusionError::Execution(format!("partition_batch_by_hash: concat failed: {}", e))
            DataFusionError::Execution(format!(
        SpillBudget::Disabled | SpillBudget::Available(_) => query_config.target_partitions,
        let compacted = compact_string_view_columns(batch.clone());
    //
    let query_context = QueryTrackingContext::new(
        crate::memory_guard::set_spill_dir(spill_dir);
                        e.kind(),
    let session = LocalSession::new(&runtime.runtime_env);
        let has_nontrivial_state = partial_schema.fields().iter().any(|f| {
    manager: &RuntimeManager,
    }
        )));
                // only write on spill_path itself. Works uniformly for files,
        )
        let actual_field = Field::new("tags", DataType::List(actual_child), true);
        )]));
            return Err(DataFusionError::Execution(format!(
                        spill_dir,
        let batch = RecordBatch::try_new(
        // successfully and the DiskManager must report tmp_files_enabled() == false so
    }
                        .with_metadata(f.metadata().clone())
        );
use datafusion::execution::SessionStateBuilder;
///   by this function; the caller releases them.
    // structs from Rust's perspective) but mark them not-released by overwriting the
        None,
    // this stream is mid-flight; a `None` token here silently degrades
    let sender = &*(sender_ptr as *const PartitionStreamSender);
        );
/// Initial target_partitions for coordinator-reduce sessions. Defaults to 4.
/// decided by scanning the substrait plan bytes for two needles: the `index_filter`
        assert_eq!(
    let runtime = DataFusionRuntime {
///   `create_session_context` (or `create_session_context_indexed`).
                            .and_then(|v| v.as_i64())
    session_ptr: i64,
            continue;
/// `ptr` must be a valid pointer returned by `create_global_runtime`.
        batches.push(aligned);
                context_id,
            );
        NonZeroUsize::new(5).unwrap(),
    ))
        .unwrap();
    pub num_rows: u64,
            vec![Arc::new(string_view_array), Arc::new(int_array)],
    let mut batches = Vec::with_capacity(array_ptrs.len());
            if timed_out {
// ---------------------------------------------------------------------------
                collect_reads(left, out);
use crate::phantom_corrector::PhantomCorrector;
                            pruning_metrics.pruned() as i64,
    let table_schema = derive_schema_from_partial_plan(partial_plan_bytes)?;
    pub row_group_row_counts: Vec<u64>,
}
        }
///
        // briefly for phase 2 to clear the *.stale entries.
        // without reinterpretation. Long-term plan: have the data node embed
        // Boundary values pass through unchanged.
    };
    let schema_ipc = schema_to_ipc_bytes(schema.as_ref())?;
/// # Operator contract
/// This is a cheap byte-substring scan, not a parse. A false positive on
    }
        .collect();
        }
    let disk_manager = if spill_dir.is_empty() {
        let effective_spill_limit = spill_limit as u64;
    partitioner.partition(batch, |partition_idx, sub_batch| {
    // DiskManagerMode::Disabled — operators that need to spill will fail with a clear
            "Non-sliced batch must return the original column Arc (no copy)"
    let batch_size = session.batch_size();
/// batch.
/// valid DataFusion identifier anywhere else a plan would naturally contain
        substrait::proto::plan_rel::RelType::Root(rr) => rr.input.as_ref().cloned(),
                ))
        let path = object_store::path::Path::from(full_path.as_str());
        let list = ListArray::new(
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, spill_path, 0).expect("runtime build");
    pub runtime_env: Arc<datafusion::execution::runtime_env::RuntimeEnv>,
/// function exit; only the schema is returned.
        let compacted = compact_string_view_columns(batch);
        // Mixed batch: a Utf8→Utf8View mismatch (must cast) alongside a tolerated
        // Extension rels wrap a normal input. The multi-value expand
        while std::time::Instant::now() < deadline {
    use datafusion_substrait::logical_plan::consumer::{
                "tags",
    input_array_ptr: i64,
    }
        let after_size = compacted.columns()[0].get_array_memory_size();
        unsafe { close_global_runtime(ptr) };
            if arr.is_null(i) {
/// end-of-input.
    /// Optional access plan for targeted row retrieval (QTF fetch phase).
/// Acquires a partition gate permit before polling the stream. The permit is
        query_context: QueryTrackingContext,
    context_id: i64,
/// a physical plan and reading its output schema — that is the schema the
}
    let needs_compaction =
    // the struct contents into Rust-owned values; the original memory is
        );
/// forever — `create_local_dirs` in `datafusion-execution` only creates a
            _concurrency_permit: permit,
        if spill_path.exists() {
/// so the session produces batches on the CPU executor while `stream_next`
/// # Safety
    let (cache_manager_config, custom_cache_manager) = if cache_manager_ptr != 0 {
/// The returned stream wraps the DataFusion output in the same
            .to_string();
    /// by the session; dropping it prematurely causes use-after-free.
                col.to_data()
/// `ptr` must be a valid pointer returned by `create_global_runtime`.
            )]))
/// `MessageChannelReader` / `ArrowStreamReader`.
/// execution so `cancel_query()` can interrupt it even during planning.
}
    for read in &reads {
        let batch = match batch_res {
///
/// Hash-partitions one [`RecordBatch`] by the columns at `hash_key_indices` into
            DataFusionError::Execution(format!(
            row_base: seg.global_base as i64,
    }
        // as a phantom "disk pressure" signal and clamp every query to 1 partition.
    use arrow_array::{BinaryViewArray, Int64Array, ListArray, StringViewArray};
        let batch = RecordBatch::try_new(
        let listing_options = ListingOptions::new(Arc::new(ParquetFormat::new()))
    .await
    let mut exprs: Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>> =
        let aligned = RecordBatch::try_new(Arc::clone(&table_schema), raw.columns().to_vec())
                    .downcast_ref()
            msg
        let spill_path = PathBuf::from(spill_dir);
    // shape as `execute_query`, so existing `stream_next` / `stream_close`
        )]));
            Arc::clone(boxed);
/// `execute_indexed_query` when `classify_filter` returns `None`
///       trait upcasts to `dyn ObjectStore` for DataFusion APIs that take `Arc<dyn ObjectStore>`).
    /// Available after execution completes; read via `df_stream_get_metrics`.
    pub fn new(
        timer,
/// Zero I/O in all cases.
/// Variant of [`register_memtable`] for the shard-scan path's `SessionContextHandle`. The
        let deadline = std::time::Instant::now() + std::time::Duration::from_millis(timeout_ms);
    let expected_schema = handle.stream.schema();
    _concurrency_permit: Option<tokio::sync::OwnedSemaphorePermit>,
fn schema_to_ipc_bytes(schema: &arrow::datatypes::Schema) -> Result<Vec<u8>, DataFusionError> {
    }
    global_pool: &Arc<dyn MemoryPool>,
                "Failed to register memtable '{}' on session context: {}",
/// # Safety
        )));
/// Opaque runtime handle returned to the caller.
/// [`crate::session_context::SessionContextHandle`] — the M2 hash-shuffle worker registers
            let counts_ptr = wire.row_group_row_counts_ptr as *const i64;
    use datafusion::datasource::listing::{ListingOptions, ListingTable, ListingTableConfig};
            .ok_or_else(|| DataFusionError::Execution("ReadRel missing base_schema".to_string()))?;
/// `VectorSchemaRoot` to a paired `FFI_ArrowArray` / `FFI_ArrowSchema`, and
        let view_types = ctx
        let _guard = lock_process_globals();
/// - `input_array_ptr` and `input_schema_ptr` must point to populated FFI structs from a
            limit
        table_path,
            collect_reads(&rel, &mut reads);
//!
        &shard_view.table_path,
        CrossRtStream::new_with_df_error_stream_cancellable(
    );
    }
/// [`org.opensearch.analytics.spi.ShuffleScanInstructionNode`] equivalent. Mirrors how
        let int_array = Int64Array::from_iter_values(0..total_rows as i64);
        Some(RelType::Aggregate(a)) => {
                })
            panic!(
        assert!(view.is_null(1));
    let df_stream = ascending_row_id_check_stream(df_stream);
        dynamic_pool,
                runtime,
///
/// already dropped (consumer finished / cancelled) the flag is simply never read, which is correct.
    let extensions = Extensions::default();
use datafusion::execution::memory_pool::{MemoryPool, TrackConsumersPool};
            .with_listing_options(listing_options)
    )));
            vec![
}
use datafusion::physical_plan::metrics::MetricValue;
        )
        ensure_batch_matches_stream_schema(&batch, &mk("item", DataType::Utf8View))
        pool,
                    } => {
            let mut plan = ParquetAccessPlan::new_none(num_rgs);
fn assert_fetch_result_schema(
}
    for (i, (a, e)) in actual.fields().iter().zip(expected.fields()).enumerate() {
            }
            "tags",
            after_size,
                        "fetch_by_row_ids: __row_id__ not ascending — prev={}, next={} at row {}",
) -> Result<i64, DataFusionError> {
    if array_ptrs.len() != schema_ptrs.len() {
    };
    let schema = handle.stream.schema();
}
        unsafe { close_global_runtime(ptr) };
) -> Result<arrow::datatypes::SchemaRef, DataFusionError> {
    }
            cleaned,
    // memory layouts match exactly (FFI_ArrowArray is a stable C struct).
    use crate::indexed_table::segment_info::build_segments;
            });
                log::warn!(
    let sql = format!("SELECT {} FROM t", projection);
    Some(result)
        DiskManagerBuilder::default().with_mode(DiskManagerMode::Disabled)
    /// input batches are released before the per-query allocator closes. `None` outside coordinator-reduce.
            )));
    }
        // Mirror the two transformations the data-node session applies to its
                        map.insert(
        }
        }
pub unsafe fn create_local_session(runtime_ptr: i64) -> Result<i64, DataFusionError> {
        let tmp = tempfile::tempdir().expect("tempdir");
            crate::memory_guard::per_query_spill_budget(),
    manager: &crate::runtime_manager::RuntimeManager,
            e
    stream: RecordBatchStreamAdapter<CrossRtStream>,
                           delta: i64| {
                .name("datafusion-spill-gc".to_string())
        );
    let state = SessionStateBuilder::new()
        let batch = RecordBatch::try_new(schema, vec![Arc::new(int_array)]).unwrap();
        //    never follow a symlink through to its target), `remove_dir_all`
    // already-aligned buffers; only misaligned ones are reallocated.
                    .collect();
        )]));
pub async unsafe fn stream_next(stream_ptr: i64) -> Result<i64, DataFusionError> {
        let err = create_global_runtime(64 * 1024 * 1024, 0, bad_path_str, 0)
            .iter()
        debug_assert!(
///
use arrow_schema::DataType;
    // Dropping the handle aborts the CPU task but does not wait for it; on the coordinator-reduce
//!
    // stream channels that require a Tokio reactor. Enter the IO runtime's
            budget.phantom_bytes,
        );
    /// Per-shard object store. When a native store is provided (store_ptr > 0),
    );
    }
/// UDF name and the `__row_id__` column name. Either one → indexed path.
/// No-op for unknown or already-completed queries.
        // Plan may scan the same table twice; the second register is a no-op.
        token.as_ref(),
            )
            row_base += num_rows as i64;
                }
/// Java tripwire (`typesMatch` in DatafusionReduceSink) can validate batches
        let ffi_array = FFI_ArrowArray::from_raw(array_ptr as *mut FFI_ArrowArray);
/// `runtime_ptr` must be a valid, non-zero pointer returned by
///   `create_local_session`.
    let batch = RecordBatch::from(struct_array);
        return;
        assert!(
    let metadata_cache = ctx
            &datafusion::execution::cache::TableScopedPath {
    ))
        DataFusionError::Execution(format!("Failed to re-export input Arrow C Data: {}", e))
        let boxed = unsafe {
        //    boot loudly with full error context.
        // would truncate sub-ms precision — the Java tripwire tolerates this as advisory, so
    query_config: crate::datafusion_query_config::DatafusionQueryConfig,
        .with_config(config)
                        name,
    }
            .any(|(col, field)| match field.data_type() {
        .find_map(|pr| {
    let handle = &*(session_ctx_handle_ptr as *const crate::session_context::SessionContextHandle);
            vec![Arc::clone(&col)],
            // Already aborted, so this resolves as soon as the task unwinds; 30s is a backstop
    match rel.rel_type.as_ref() {
    io_handle: &tokio::runtime::Handle,
        panic!(
    /// Top-level symlinks must be unlinked, not followed — otherwise the wipe
                ._query_tracking_context
    //
// Coordinator-reduce local execution API
    let token = handle._query_tracking_context.cancellation_token();
        vec![partition],
                true,
    /// Per-row-group row counts.
                            map,
        return Err(DataFusionError::Execution(format!(
    /// This pins the rename behavior so a future refactor that goes back to
        fs::write(&leaked_file, b"stale spill data").expect("seed leaked file");
    // layouts, so this must be a real cast rather than a relabel. Other tolerated
            columns.push(Arc::clone(col));
    // Apply disk-pressure capping + memory budget, attaching phantom
            "symlink target outside spill dir must NOT be touched (cleanup must not follow symlinks)"
pub fn cancel_query(context_id: i64) {
    pub sort_fields: Vec<String>,
    // Gating happens inside the executor functions (execute_query / execute_indexed_query)
}
        let tmp = tempfile::tempdir().expect("tempdir");
    // Downcast Arc<dyn FileMetadata> to ParquetMetaData
        locked.set_mode(0o555);
/// shape as the streaming path.
pub fn create_global_runtime(
        // depends on the test host's free disk; both prove the enabled-path branch
// Mirrors the shard-scan path: a `LocalSession` pointer is created once per
    /// Held for its `Drop` impl — marks the query completed when the
                    );
/// # Safety
///
    // we just got back to FFI again and write the result back into the input pointers.
                DataFusionError::Execution(format!(
    let memory_pool = Arc::new(TrackConsumersPool::new(
        let bad_path_str = bad_path.to_str().expect("utf-8 path");
                shard_view,
    if partition_count <= 0 {
    }
    })?;
        }
        query_context.set_phantom_reservation(budget.phantom_reservation);
) -> Result<i64, DataFusionError> {
                row_base,
/// When the budget reduces parallelism under memory pressure, it will not
                limit,
                "ts",
                    DataFusionError::Configuration(msg)
        )));
            physical_plan: Some(plan),
    // partitions that received zero rows so the receiver side still sees a valid IPC chunk).
    // native alignment requirements. align_buffers() is a no-op for
        assert!(
    if let Some(partial_schema) = crate::agg_mode::partial_aggregate_schema(&physical_plan) {
            fields.push(Arc::clone(&actual_schema.fields()[i]));
    if array_ptrs.len() != schema_ptrs.len() {
        );
        vec![partition],
    sender_ptr: i64,
        /* num_input_partitions */ 1,
//! - `stream_next`: async. The bridge layer wraps with `block_on` or `spawn`.
    use arrow::datatypes::{DataType, Field, TimeUnit};
    if hash_key_indices.is_empty() {
    }
        }
                        };
    /// catalog is the authoritative source — Rust never reads generations from parquet
            columns.push(Arc::clone(col));
    let shard_view = &*(shard_view_ptr as *const ShardView);
/// released after the batch is produced (or on cancellation/end-of-stream).
    _session_ctx: Option<datafusion::prelude::SessionContext>,
    for &gid in &row_ids {
                            Err(e) => {
    // Register cancellation token.
    let query_context = QueryTrackingContext::new(
///
    let table_path = shard_view.table_path.clone();
    }
    /// column must fall through to the pass-through tier and keep its actual field.
    // with `table_schema` so MemTable::try_new sees uniform headers. Column
        let parent = tempfile::tempdir().expect("parent tempdir");
    let table_url = ListingTableUrl::parse(table_path)
    if ptr != 0 {
            access_plan,
            values,
            "tags",
                    e
        query_context: QueryTrackingContext,
            // Utf8 offsets: "Offset buffer for type Utf8 is malformed", surfacing as
    #[test]
            _query_tracking_context: query_context,
        assert!(
        let state = SessionStateBuilder::new()
        assert_eq!(
            );
            Field::new("b", DataType::Int64, false),
            }
        let raw = RecordBatch::from(struct_array);
    // Wrap the output in the same CrossRtStream + RecordBatchStreamAdapter
    // Acquire budget using measured row bytes from metadata
        return batch;
            _query_tracking_context: query_context,
        .register_table(input_id, Arc::new(table))
    schema_ipc: &[u8],
                                "start_timestamp".to_string(),
    // the declared type here. RelabelExec on the producer side only retags
                true,
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int64, false)]));
        assert!(
    .ok()
            filename
                                "end_timestamp".to_string(),
                );
        })
///
}
            use arrow::datatypes::{Field, Schema};
    ///
        .ctx
    for (seg_ord, seg) in segments.iter().enumerate() {
            ],
            .downcast_ref::<StringViewArray>()
        assert!(
    // Take ownership of the Java-allocated FFI structs. `from_raw` reads
    } else {
        // Phase 2: remove_file on a symlink unlinks the link itself, never the target.
    {
    plan_bytes
    // by value (zeroing its release fn pointer to take ownership); we have to undo that
fn collect_reads(rel: &substrait::proto::Rel, out: &mut Vec<substrait::proto::ReadRel>) {
            .values()
        );
            DataFusionError::Execution(format!(
/// is monotonically nondecreasing, including across batch boundaries. No-op in release.
    // In debug builds, interpose an adapter that asserts __row_id__ values are
/// `derive_schema_from_partial_plan`) and must be fixed there, not papered over per
                        let v = m.value().as_usize() as i64;
            .await
    /// topology). `fs::remove_dir_all(spill_dir)` would fail at the final
        "build_shard_files: object_metas and file_metadata must have matching length"
                    .as_any()
    pub fn with_physical_plan(
                    let msg = format!(
    #[test]
        current_partitions,
            msg.contains("io kind="),
        let config = ListingTableConfig::new(table_path)
        let msg = err.to_string();
        let batch = RecordBatch::try_new(Arc::clone(&declared), vec![Arc::clone(&col)]).unwrap();
    debug_assert_eq!(
///
        files.push(ShardFileInfo {
        .collect::<Vec<_>>()
        let list_file_cache = Arc::new(DefaultListFilesCache::default());
    let mut row_base: i64 = 0;
            physical_plan: None,
        } else {
                        .as_any()
        let slice_rows = 100usize;
/// Wraps a stream in an adapter that asserts each emitted batch's `__row_id__` column
            "error must identify it as a cleanup failure; got: {}",
    }
    drop(handle);
        Some((idx, _)) => idx,
            .build()?,
    if spill_limit < 0 {
            false,
    pub writer_generations: Arc<Vec<i64>>,
/// # Safety
            .column(0)
) -> Result<i64, DataFusionError> {
            &DataType::Timestamp(TimeUnit::Nanosecond, None)
    {
        let schema = Arc::new(Schema::new(vec![Field::new(
            for input in &e.inputs {
            get_reduce_target_partitions(),
pub unsafe fn sender_terminate_early(sender_ptr: i64) {
                "fetch_by_row_ids: result schema missing requested column {}, got {:?}",
                }
    let runtime = &*(ptr as *const DataFusionRuntime);
        );
                            .and_then(|v| v.as_i64())
        });
            .expect("equivalent LIST child names align");
/// DataFusion is lax about them. A mismatch here is a planning-time bug (see
    for read in collect_plan_reads(&plan) {
    )?;
/// Lowers a partial-aggregate Substrait plan against a throwaway session and
/// partition column and to resolve global row IDs back to file positions.
        })
        pool,
/// Closes a result stream. Safe to call with 0 (no-op).
        .join(", ");
/// point whose parent the JVM user does not own; rmdir'ing the root would
                    log::error!("{}", msg);
            format!("{}/{}", base_path.trim_end_matches('/'), filename)
}
                        if let Err(e) = result {
    // Pointer type is `Arc<dyn MetadataCachingStore>` (since 2026-06); trait-upcast to
/// `writer_generations[i]` is the generation of `filenames[i]`. Both come from the Java
    // Exported VSRs may arrive with batch-level schemas that differ in
                .is_err();
    let disk_capped_partitions = match per_query_spill_budget() {
        }
            stream,
        return Ok(());
                            }
/// registers them as an in-memory table on the given session under `input_id`.
/// Returns a heap-allocated pointer (as i64) to `DataFusionRuntime`.
        };
        DataFusionError::Execution(format!("Failed to import input Arrow C Data: {}", e))
    // channel-close.
            for input in &s.inputs {
    )?;
    // to 1 so each query produces less spill volume. When spill is off, disk health
    // ── 2. Build ShardFileInfo with ParquetAccessPlan per file ──
        let schema = Arc::new(Schema::new(vec![Field::new(
    expected: &SchemaRef,
    let cpu_rt_handle = query_tracker::take_cpu_runtime_handle(context_id);
    // Reduce path: cancel via the token only, do NOT register the abort handle — an abort() mid-send
            // against a wedged task hanging the reduce thread. If it fires we proceed anyway and
                "stream_next: column {} ('{}') has type {:?} but the stream schema declares {:?}; \
    /// stream is closed.
        assert!(
    true
///
        assert!(
        // Clamps to the [1, 32] range used by the datafusion.reduce.target_partitions setting.
/// # Side effect: spill directory contents are wiped (two-phase)
            }
                full_array.total_buffer_bytes_used()
        fs::write(&nested_file, b"nested leak").expect("seed nested file");
        assert!(
        let raw = RecordBatch::from(struct_array);
        if col_idx >= schema.fields().len() {
            cleaned,
            "create_reader: filenames ({}) and writer_generations ({}) must have the same length",
    // derive_schema_from_partial_plan applies `schema_coerce::coerce_inferred_schema`
    sender.fail(DataFusionError::Execution(format!(
        let seg_idx = segments
/// QTF fetch phase: read specific rows by global row ID.
        };
/// The `io_handle` is the Tokio handle used to drive the blocking send;
    // `context_id` of 0 disables tracking (pool is not consulted) and no
                None
/// # Safety
        let string_view_array = StringViewArray::from_iter_values(strings.into_iter());
            "Non-sliced array must NOT need gc"
    #[test]
///
        DataFusionError::Execution(format!(
            _session_ctx: None,
pub unsafe fn close_reader(ptr: i64) {
                 EUID 0 bypasses chmod 0o555 via DAC override; the pre-fix code path \
}
        }
            ))
        crate::udf::register_all(&ctx);
    ///     above us can prune via parquet page statistics.
) -> Result<i64, DataFusionError> {
/// Verify the fetch-result schema carries `__row_id__` plus every requested column.
                }
    // / HashJoinExec would compute on the receiver side.
    // Get the file metadata cache from the custom cache manager
/// Creates a DataFusion global runtime with the given resource limits.
use datafusion::physical_plan::stream::RecordBatchStreamAdapter;
    }
        })
/// 2. Layout-identical nested types ([`DataType::equals_datatype`]: same buffers and
                shard_view.object_metas.clone(),
            Arc::clone(&actual_child),
                    .as_any()
/// Field names and metadata are ignored: they are not part of the buffer layout, and
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, spill_path, 1024 * 1024 * 1024)
        let struct_array = StructArray::from(array_data);
        let before_size = batch.columns()[0].get_array_memory_size();
                        }
    // join's null-fill side yields Utf8 while the live side yields Utf8View. The
    #[cfg(unix)]
        }
/// side runs the same coercer + wraps its physical plan with
    // from here.
            sentinel.exists(),
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
        // Also doubles as a startup-cleanup regression check: drop a "leaked" sentinel
    )
    }
            std::slice::from_raw_parts(counts_ptr, num_rgs)
    pub file_metadata: Option<Vec<FileRowMetadata>>,
            "loose top-level file original name must be gone (renamed)"
/// followed by the stream EOS marker). This is the wire format Java reads via
        Some(available) => {
            } else {
        };
    })?;
        return Err(format!(
                    .iter()
        );
            .saturating_sub(1);
impl DataFusionRuntime {
        ctx.register_table(&table_name, Arc::new(ListingTable::try_new(config)?))?;
    array_ptr: i64,
    query_config: &DatafusionQueryConfig,
            _ => f.as_ref().clone(),
            StringViewArray::from_iter_values(strings.iter().map(|s| s.as_str()));
                f.data_type(),
}
                    continue;
            "sender_send: batch column count {} does not match declared schema {}",
    input_id: &str,
/// (`Int64` matching isthmus's `ROW_NUMBER OVER` declaration). The producer
    crate::query_budget::set_min_target_partitions(value.max(1) as usize);
    // Fetch the next batch (cancellation-aware). Query cancellation is an abort,
/// Fires the cancellation token for the given context_id.
                .collect()
                sliced_view.total_buffer_bytes_used()
        assert!(nested_file.exists());
    /// Physical plan reference for post-execution metrics extraction.
    // Construct DataFusion's BatchPartitioner — exactly the type RepartitionExec uses
                    .expect("column must be BinaryViewArray when schema declares BinaryView");
        &global_pool,
                        }
        // (Arc::clone alone can't infer the supertrait return type).
    let mut fields = Vec::with_capacity(batch.num_columns());
        } else {
    let schema = derive_schema_from_partial_plan(partial_plan_bytes)?;
            .with_file_extension(".parquet")
/// # Safety
        .windows(INDEX_FILTER.len())
use crate::cancellation;
                let stale = spill_path.join(format!("{}.stale", name_str));
    array_data.align_buffers();
                    return Err(DataFusionError::Configuration(msg));
    fn conform_batch_casts_utf8_to_declared_utf8view() {
        let mut buf = Vec::new();
            "spill-enabled runtime must NOT surface SpillBudget::Disabled"
use crate::custom_cache_manager::CustomCacheManager;
    pool: &Arc<dyn MemoryPool>,
            DataFusionError::Execution(format!(
            let coerced = crate::schema_coerce::coerce_inferred_schema(partial_schema);
    // The default LocalFileSystem has no warm tier → keep the narrow scoped fetch.
        return Err(DataFusionError::Execution(format!(
    );
    pub table_path: ListingTableUrl,
            _concurrency_permit: permit,
                .map(|&c| c as u64)
            let data = unsafe {
/// derived by lowering `partial_plan_bytes` (the producer side's substrait) to
    fn collect_metrics(
///     removed off the boot path. Files and symlinks via `remove_file`
        let loose_file = spill_path.join("stray.txt");
        let original_offsets = list.value_offsets().as_ptr();
}
            "Memory pool limit must be non-negative, got {}",
        );
    Ok((Box::into_raw(Box::new(sender)) as i64, schema_ipc))
    ));
    if !cfg!(debug_assertions) {
        let spill_path = tmp.path().join("spill");
                    MetricValue::EndTimestamp(_) => {
            }
    let (segments, resolved_schema) = build_segments(
        );
    pub row_group_row_counts_ptr: i64,
    Ok(Box::into_raw(Box::new(sender)) as i64)
        cfg.target_partitions = budget.target_partitions;
        context_id,
            Field::new("bin_col", DataType::BinaryView, false),
                            format!("{}_matched", name),
        DiskManagerBuilder::default()
            for m in metrics.iter() {
fn is_utf8_family(t: &DataType) -> bool {
/// returns its physical output schema **narrowed via
) -> Result<Vec<object_store::ObjectMeta>, DataFusionError> {
    let handle = QueryStreamHandle::new_with_plan(wrapped, query_context, permit, physical_plan)
        RuntimeEnvBuilder::new()
                    "Failed to enumerate spill directory {} (io kind={:?}): {}. \
        // Phase 1: original names gone (renamed to *.stale).
            DataType::Int64,
        files,
                    let msg = format!(
            OffsetBuffer::new(vec![0_i32, 1].into()),
    /// catalog snapshot (`WriterFileSet.writerGeneration`) at reader-creation time. The
        predicate()
            out.column(1).data_type(),
            task_done: None,
        unsafe { close_global_runtime(ptr) };
            "int_col",
    let cpu_exec = manager.cpu_executor();
            runtime.runtime_env.disk_manager.max_temp_directory_size(),
            .expect("ascending_row_id_check_stream: __row_id__ column must be Int64");
    crate::udaf::register_all(&ctx);
    // release fn pointers... however that's brittle. Instead we copy the batch's columns
    ///     `output_ordering` from the scan and the `sort_prefix` optimization fires on
/// # Safety
        writer_generations: Arc::new(writer_generations),
}
        permit: Option<tokio::sync::OwnedSemaphorePermit>,
}
        let string_view_array = StringViewArray::from_iter_values(std::iter::empty::<&str>());
    let mut reads = Vec::new();
        let schema = crate::schema_coerce::coerce_inferred_schema(schema);
    // "DiskManager is disabled" error instead of writing to an unintended path.
        let has_views = Self::schema_has_views(&stream.schema());
        let full_array = StringViewArray::from_iter_values(strings.iter().map(|s| s.as_str()));
            Field::new("n", DataType::Int64, false),
        let mk = |child_name: &str, child_ty: DataType| {
    use substrait::proto::read_rel::ReadType;
        set_reduce_target_partitions(-5);
            crate::memory_guard::SpillBudget::Disabled,
    let ffi_schema = FFI_ArrowSchema::from_raw(input_schema_ptr as *mut FFI_ArrowSchema);
        let aligned = conform_batch_to_schema(batch, &expected_schema)
        let _guard = lock_process_globals();
            Err(e) => return Err(e),
    if !needs_compaction {
    // Concatenate per partition (or produce an empty batch with the input schema for
        // Phase 1 renames the sentinel file to leaked_from_prior_run.tmp.stale
        fs::write(&outside, b"must NOT be touched").expect("seed outside file");
                spill_dir,
                        // to dispatch: directories use remove_dir_all, everything
        let schema = Arc::new(Schema::new(vec![
//! to the corresponding Rust type. The caller (bridge layer) is responsible for
    // would skip the cross_rt drop+drain cleanup and leak the aggregate's in-flight GroupValues.
/// substrait via [`derive_schema_from_partial_plan`] — the SAME derivation the
        if let Some(rel) = root_rel(plan_rel) {
            cleaned,
        set_reduce_target_partitions(1);
        })
/// - `schema_ipc` must be a complete Arrow IPC schema-message blob.
    let session = &*(session_ptr as *const LocalSession);
                &effective_config,
    // Same teardown signal as execute_local_plan.
                || msg.contains("Failed to clear leaked spill entry"),
    // produces 8-byte-aligned slices into the IPC body (per spec) but DataFusion's SIMD
        );
/// each partition's left/right input on the same session that already has the local shard
/// `create_local_session`.
                                log::warn!("Background spill cleanup: read_dir error: {}", e);
/// - `session_ctx_handle_ptr` must be a valid, non-zero pointer returned by
    let ctx = SessionContext::new_with_state(state);
    batch: RecordBatch,
    }
            if let Some(input) = &s.input {
                DataType::List(Arc::new(Field::new(child_name, child_ty, true))),
//!
        .map_err(|e| DataFusionError::Execution(format!("Invalid table path: {}", e)))?;
use arrow_array::RecordBatch;
                            Ok(ft) => {
        })?;
        query_tracker::flush_cpu_runtime_with_handle(&rt, context_id);
/// False positives take the indexed path and then fail in
        .map_err(|e| DataFusionError::Execution(e))?;
/// - `array_ptrs` and `schema_ptrs` must point to populated FFI structs owned
/// positionally (verified — names differ, types/order identical).
    let wrapped = RecordBatchStreamAdapter::new(cross_rt_stream.schema(), cross_rt_stream);
        serde_json::to_vec(&map).ok()
            Some(plan)
    #[test]
            .with_memory_pool(memory_pool)
    runtime.dynamic_limit_handle.limit() as i64
/// without being forgotten).
    let mut buf: Vec<u8> = Vec::new();
fn use_indexed_path(plan_bytes: &[u8]) -> bool {
/// # Safety
            _ => Arc::clone(col),
    // registry entry can be removed by a sibling stream's Drop (same id) while
/// - `partial_plan_bytes` must be a complete producer-side Substrait plan blob.
        .zip(schema.fields().iter())
                    );
                if !rg_bitmap.is_empty() {
///
/// `ptr` must be 0 or a valid pointer returned by `create_local_session`.
                    let view: &arrow_array::StringViewArray = col
        assert_eq!(
    let physical_plan =
                    input_id, e
/// consumes them on the I/O runtime.
        );
pub unsafe fn sender_close(sender_ptr: i64) {
        let strings: Vec<String> = (0..10_000)
    /// observe the global runtime state from `create_global_runtime`. cargo test runs tests in
///
            }
 * this file be licensed under the Apache-2.0 license or a
    let mut files: Vec<ShardFileInfo> = Vec::new();
        .get_file_metadata_cache();
                    }
    /// Keeps the SessionContext alive while the stream is being consumed.
        let leftover = tmp.path().join("datafusion-old.stale");
/// `stream_ptr` must be 0 or a valid pointer returned by `execute_query`.
            true,
    }
            RecordBatch::new_empty(Arc::clone(&schema))
        store,
/// (specifically `BroadcastInjectionHandler`) ships the build-side memtable
            partition_count
        assert_eq!(get_reduce_target_partitions(), 8);
        assert!(!leaked_a.exists(), "original orphan a must be renamed away");
            "create_reader: sort_fields ({}) and sort_orders ({}) must have the same length",
        });
    runtime: &DataFusionRuntime,
    manager: &RuntimeManager,
        // is gone immediately; wait for the .stale name to disappear too.
    fn create_global_runtime_cleans_prior_boot_stale_entries() {
            // Phase 2: spawn the recursive deletion of all *.stale entries.
            task_done: None,
        )
            RecordBatch::try_new(schema, vec![Arc::new(string_view_array.clone())]).unwrap();
        manager.cpu_executor(),
                Field::new("n", DataType::Int64, false),
fn derive_schema_from_partial_plan(
    for read in collect_plan_reads(plan) {
    }
        let struct_array = StructArray::from(array_data);
    let mut config = SessionConfig::new();
        fs::create_dir_all(&nested_dir).expect("seed nested subdirs");
            !loose_file.exists(),
    }
        struct RestorePerms<'a> {
                    input_id, e
        list_file_cache.put(
    pub row_base: i64,
    RecordBatch::try_new(target_schema, columns).map_err(|e| {
    crate::cache::page_index::set_whole_region_fetch_enabled(store_ptr > 0);
        let tmp = tempfile::tempdir().expect("tempdir");
    let sender = Box::from_raw(sender_ptr as *mut PartitionStreamSender);
            {
    } else {
/// Returns `(sender_ptr, schema_ipc_bytes)`. The IPC bytes are written so the
        // Restore parent perms via RAII so tempdir cleanup runs even on assertion failure.
        context_id,
    // honor that by reconstructing the FFI structs only momentarily here, calling from_ffi,
        let batch = RecordBatch::try_new(
/// Extracts the table name from the first NamedTable read in the plan bytes.
    fn create_global_runtime_with_spill_dir_enables_disk_manager() {
/// Each `row_group_row_counts_ptr` must point to `num_row_groups` consecutive i64 values.
    const INDEX_FILTER: &[u8] = b"index_filter";
            BinaryViewArray::from_iter_values(values.iter().map(|v| v.as_slice()));
pub unsafe fn sender_fail(sender_ptr: i64, reason: &str) {
            }
        if use_indexed {
///   `create_session_context` (or `create_session_context_indexed`).
    schema: &datafusion::arrow::datatypes::Schema,
        crate::udaf::register_all(&ctx);
/// listing-table-backed shard scan on the same session.
                            .get("end_timestamp")
        async {
    Ok(reader.schema())
/// (`block_on` for synchronous delivery, `spawn` for async delivery).
    None
        cfg.batch_size = budget.batch_size;
        // spill disabled (empty path), no filesystem operation should run — an
    plan_bytes: &[u8],
    if let Some(budget) = crate::query_budget::try_grow_reduce_budget(
                collect_reads(input, out);
                        // else (regular files, symlinks) uses remove_file. This
/// `SessionContextHandle`) EXCEPT the table schema is derived from the producer's PARTIAL
pub unsafe fn get_memory_pool_stats(ptr: i64, out_ptr: *mut i64) {
    shard_view: &ShardView,
            !tmp.path().join("datafusion-old.stale.stale").exists(),
            _session_ctx: Some(ctx),
                    .data_type(want.data_type().clone())
            .with_disk_manager_builder(disk_manager)
    #[test]
    fn create_global_runtime_fails_fast_when_cleanup_fails() {
    if new_limit < 0 {
        file_metadata.len(),
                return true;
            .map(|i| format!("long_string_value_{:06}_padding", i))
 * SPDX-License-Identifier: Apache-2.0
    // Create per-query context (auto-registers in the global registry) and extract
        }
                if let Ok(metadata) = fs::metadata(self.path) {
    input_id: &str,
            array_ptrs.len(),
        let Some(ReadType::NamedTable(nt)) = read.read_type.as_ref() else {
        fs::create_dir(&leaked_dir).expect("create leaked subdir");
        use std::os::unix::fs::PermissionsExt;
        // Disabled (not Critical) — preventing the 1-partition clamp.
/// Prevents sliced StringView batches from carrying full backing buffers across FFI.
/// `FfmSegmentCollector::create` so the Java side can identify the corresponding Lucene
        let actual_schema = Arc::new(Schema::new(vec![actual_field.clone()]));
            DataType::Utf8View,
        self.task_done = Some(task_done);
    // Zero-copy: from_ffi BORROWS the Java buffers, keeping them alive until DataFusion drops the
            // Same buffer layout and nullability, differing only in child field
        );
    /// Spill directory is owned by the JVM but its parent isn't (mount-point
                // Rename to <name>.stale within the same parent. Metadata-only;
/// which the receiver side (DataFusion's streaming table) interprets as
            physical_plan: None,
                    perms.set_mode(self.mode);
    // pull_from_input tasks (holding GroupValues buffers) is processed now rather
    let plan = Plan::decode(substrait_bytes).map_err(|e| {
        );
            actual.fields().len(),
///   * **Phase 2 (async, background thread):** every `*.stale` entry is
                    "(\"{}\" + \"row_base\") AS \"{}\"",
        let _ = Box::from_raw(ptr as *mut LocalSession);
    // Race substrait planning + execution against the cancellation token so
                e.data_type()
    // Acquire memory budget: reserve phantom for untracked memory. Best-effort from
        fs::write(leaked_b.join("tmp_002.arrow"), b"data b").expect("write b");
                            .get("start_timestamp")
/// Phase 1 failure aborts boot with `DataFusionError::Configuration` — if
            "physical_plan".to_string(),
            crate::memory_guard::per_query_spill_budget(),
        ctx: datafusion::prelude::SessionContext,
/// MILLIS / MICROS / NANOS only — `Timestamp(Second)` is silently
            "phase 1 must NOT double-suffix existing .stale entries"
        parquet_meta.file_metadata().schema_descr(),
///
/// # Safety
            fn drop(&mut self) {
        assert_eq!(view.value(0), "a");
    }
/// parent is **not** required — `spill_dir` is treated as a pre-existing
        let values: Vec<Vec<u8>> = (0..total_rows)
pub(crate) fn base_schema_for_table(
        &shard_view.sort_fields,
/// boundary never silently truncates values.
        }
/// (`sum_qty[sum]`) therefore fails the FINAL's by-name lookup with `No field named sum_qty`.
        let sender = &*(sender_ptr as *const PartitionStreamSender);
                    let entries = match fs::read_dir(&spill_path_for_gc) {
    session_ctx_handle_ptr: i64,
    let df_stream = execute_stream(Arc::clone(&physical_plan), ctx.task_ctx())?;
///
            !top_file.exists(),
        ));
}
            ensure_batch_matches_stream_schema(&batch, &expected_schema)?;
                .map_err(|e: DataFusionError| e)
        &mut query_context,
                collect_reads(input, out);
/// # Safety
    let mut partitioner = datafusion::physical_plan::repartition::BatchPartitioner::try_new(
/// `row_number()` physical op) back to their Substrait-compatible counterparts
        let expected_schema = Arc::new(Schema::new(vec![Field::new(
            "symlink original name must be gone (renamed)"
fn ensure_batch_matches_stream_schema(
use arrow_schema::SchemaRef;
    }
                batch
        let original_parent_mode = fs::metadata(parent.path())
        for child in plan.children() {
    }
        .iter()
    array_data.align_buffers();
            "str_col",
        let batch = RecordBatch::try_new(
    partial_plan_bytes: &[u8],
        assert_eq!(aligned_values.value(1), "error");
    }
        // at boot with full context. Trigger the failure path by pointing spill_dir
        .columns()
        // Non-empty spill_dir takes the Directories(...) path. tmp_files_enabled() must
    #[test]
//! All functions in this module use plain Rust types — no FFI-specific types.
/// typically the `io_runtime` handle from the global `RuntimeManager`.
        output.push((array_ptr, schema_ptr));
    table_path: &str,
/// and an Arrow C Data array carries no type information of its own. A batch whose
    };
            .with_schema(schema);
/// consumes via Arrow C Data Interface and ships over the analytics shuffle transport.
use std::sync::Arc;
///
                        if !name.to_string_lossy().ends_with(".stale") {
/// # Safety
    ));
        // Simulate a leaked spill file from a prior non-graceful shutdown.
    fn create_global_runtime_succeeds_when_jvm_does_not_own_spill_parent() {
fn schema_from_ipc_bytes(bytes: &[u8]) -> Result<SchemaRef, DataFusionError> {
            sort_fields.len(),
    let wrapped = RecordBatchStreamAdapter::new(cross_rt_stream.schema(), cross_rt_stream);
        .relations
        let leaked_dir = spill_path.join("datafusion-aB3kF7");
    let store: Arc<dyn ObjectStore> = if store_ptr > 0 {
/// non-polling consumer, and it surfaces the error even when the channel is full. If the receiver was
    // data is reused verbatim.
/// stream's batches match its `schema()`; this turns any violation into a query
/// Uses shared helpers from query_executor for runtime setup, file info building,
        // Same layout, different child name: fine.
}
                        // unlinks the link itself without following it.
    let session = &mut *(session_ptr as *mut LocalSession);
        Ok(buf)
///
/// from row IDs and computing global __row_id__ = __row_id__ + row_base in SQL.
/// Uses 80% of available space on the spill directory's filesystem.
            has_views,
        // to enumerate a non-directory and returns ErrorKind::NotADirectory.
    };
        assert_eq!(out.column(0).data_type(), &DataType::Utf8View);
        fs::set_permissions(parent.path(), locked).expect("chmod parent 555");
        );
/// This is an async function — the bridge layer decides how to run it.
                Arc::new(arrow_array::Int64Array::from(vec![1, 2, 3])),
            32,
        shard_view,
    /// Attaches the task-completion signal `stream_close` joins on before the allocator closes.
///     via `remove_dir_all`.
    for (&array_ptr, &schema_ptr) in array_ptrs.iter().zip(schema_ptrs.iter()) {
        );
            array_ptrs.len(),
        // Phase 1 only requires write on spill_dir, never on its parent.
                        );
            .column(0)
    /// assertions.
        assert_eq!(out.column(0).data_type(), &DataType::Utf8View);
    let waste = bytes_allocated.saturating_sub(bytes_used);
pub unsafe fn decode_file_metadata(ptr: i64, count: usize) -> Option<Vec<FileRowMetadata>> {
                    e
/// The Java side has accumulated all shard responses, exported each
/// we cannot rename orphans now, queries that need to spill would fail
    let table = datafusion::datasource::MemTable::try_new(table_schema, vec![batches])?;
        store.as_ref(),
    let table_schema = derive_schema_from_partial_plan(partial_plan_bytes)?;
        //
        let compacted = compact_string_view_columns(sliced);
    // Acquire a schema-accurate phantom reservation for this reduce session.
        store_url,
use datafusion::execution::disk_manager::{DiskManagerBuilder, DiskManagerMode};
    }
        let table = MemTable::try_new(arrow_schema, vec![vec![]])?;
            }
                    map.insert(
    }
    }
    let schema = batch.schema();
    Box::pin(RecordBatchStreamAdapter::new(schema, checked))
    let runtime_env = Arc::new(
    manager.io_runtime.block_on(async {
        assert!(ptr > 0);
pub unsafe fn get_memory_pool_limit(ptr: i64) -> i64 {
    shard_view: &ShardView,
                ))
    substrait_bytes: &[u8],
                        let entry = match entry {
/// Executes the previously prepared final-aggregate plan on a local session.
                            .unwrap_or(0);
                match m.value() {
    // same coercer + wraps its physical plan with `RelabelExec`, so the batches arriving
        // Restore the default so test ordering can't leak state into other tests.
                 would silently succeed and the test would assert nothing"
        return Ok(batch);
        fs::create_dir(&spill_path).expect("create spill dir");
    #[test]
///
    let cache = cache_mgr.get_file_metadata_cache_for_datafusion()?;
        Some(RelType::Fetch(f)) => {
            new_limit
        };
                Some(rr.names.clone())
        assert!(
        Arc::clone(&table_schema),
 * The OpenSearch Contributors require contributions made to
            2_000_000_999,
        .collect();
                f.is_nullable(),
    )?;
    let table_name = table_name.to_string();
        );
        batch
        let df_schema = from_substrait_named_struct(&consumer, base_schema)?;
        // Timestamp column kept its actual (nanosecond) type — not truncated to the declared ms.
#[inline]
    /// Index sort fields, in priority order. Sourced from the index's
                    let prev = map.get(&key).and_then(|v| v.as_i64()).unwrap_or(0);
        let mut array_data = arrow_array::ffi::from_ffi(ffi_array, &ffi_schema).map_err(|e| {
    /// `create_global_runtime` also replaces the global `RuntimeEnv` registration and
/// Utf8 / Utf8View — the string-view family whose two variants share byte-identical
            row_group_row_counts: rg_counts,
            crate::schema_coerce::transform_schema_to_view_recursive(&arrow_schema)
/// Contains the DataFusion RuntimeEnv (memory pool, disk spill, cache)
    runtime_ptr: i64,
}
                    dyn opensearch_tiered_storage::tiered_object_store::MetadataCachingStore,
        ]));
/// substrait) the same way `register_partition_stream` does. Returns the
    // cancellation token is registered in the global QUERY_REGISTRY.
/// Decodes an Arrow IPC stream-format header into a [`SchemaRef`]. The Java side
            return nt.names.last().cloned();
        } else {
    // column in the result.
///
        // coordinator skips this throwaway lowering and both mirrors evaporate.
        )
                f.name(),
            OffsetBuffer::new(vec![0_i32, 1].into()),
                sliced_view.data_buffers(),
            df_stream,
        // before touching SPILL_DIR. Without this, an unset OnceLock would surface
/// from — the shipped record batches arrive over the wire pre-typed, and the caller computes
            "register_memtable: array_ptrs.len()={} != schema_ptrs.len()={}",
}
            Arc::ptr_eq(&string_view_array, compacted.column(0)),
    if ptr != 0 {
        let int_array = Int64Array::from_iter_values(0..total_rows as i64);
/// this runs exactly once per JVM. A future caller invoking it mid-flight
pub fn build_shard_files(
            true,
use crate::partition_stream::PartitionStreamSender;
        assert_eq!(
            .downcast_ref::<ListArray>()
                query_memory_pool,
/// Sibling of [`register_partition_stream`] but for the shard-scan path's
///   successful Arrow C export of the input record batch. They are read but not consumed
        let _ = Box::from_raw(ptr as *mut ShardView);
        DataFusionError::Execution(format!("Failed to import Arrow C Data array: {}", e))
            df_stream,
        let values: Arc<dyn Array> = Arc::new(StringViewArray::from_iter_values(["x"]));
        ))
    session_ptr: i64,
    context_id: i64,
    // Registers the tracker + cancellation token under context_id in the
    }
    let mut handle = Box::from_raw(stream_ptr as *mut QueryStreamHandle);
/// `stream_ptr` must be a valid, non-zero pointer to a QueryStreamHandle.
/// trip (Arrow's `TimeUnit` enum is closed at four variants, so this
    for plan_rel in &plan.relations {
    #[test]
                Arc::new(TimestampNanosecondArray::from(vec![10i64, 20])),
        //    for directories. Filtering by the .stale suffix means the fresh
    #[test]
    // Import the input batch via Arrow C. Because Java retains ownership we re-construct
        batches.push(aligned);
            e
        assert_eq!(view.value(2), "c");
    debug_assert!(
        } else {
                spill_dir
    /// Per-file row group counts, passed from Java at shard view creation.
                            name,
            .encode(&mut buf)
            .parquet
            })?
            true,
///   `register_partition_stream`.
fn view_needs_gc(buffers: &[arrow::buffer::Buffer], bytes_used: usize) -> bool {
                            );
}
    row_ids: Vec<i64>,
                if let Err(e) = fs::rename(&path, &stale) {
            tmp.path().is_dir(),
            };
        shard_view.object_metas.as_ref(),
            "str_col",
        let ts = out
        // coordinator's StreamingTable so it accepts the producer's batches
            // `List<Utf8>` here while the data node (which uses
///
            }
        .iter()
        session.memory_pool(),
    debug_assert!(assert_fetch_result_schema(
        .ctx
            has_views,
    /// CI runs as a non-root user; if you need to verify under root, run the
            None,
            DataFusionError::Execution(format!("Failed to import Arrow C Data array: {}", e))
    )
    input_id: &str,
                            map,
    sql: &str,
    }
    // Prepared-reduce path: same as execute_local_plan — token-only cancel, no abort handle.
        return None;
            };
            .collect();
                };
            "sender_send: failed to assemble conformed batch: {}",
                    view_needs_gc(view.data_buffers(), view.total_buffer_bytes_used())
    for filename in filenames {
                continue;
        let _ = Box::from_raw(ptr as *mut DataFusionRuntime);
    runtime: &DataFusionRuntime,
/// `HashJoinExec` would produce on the receiver side. Returns `partition_count` output
        // memory_guard SPILL_ENABLED flag off so per_query_spill_budget returns
        );
/// Per-file metadata passed from Java at shard view creation time.
            };
    #[test]
        let estimated_batch_bytes = if budget.phantom_bytes > 0 && batches_in_pipeline > 0 {
                        let v = m.value().as_usize() as i64;
        // be true so spill attempts succeed. The budget must NOT be Disabled —
    let projection = columns
    let handle = &*(session_ctx_handle_ptr as *const crate::session_context::SessionContextHandle);
            let batch = if handle.has_views {
    let handle = QueryStreamHandle::new(wrapped, query_context, permit).with_task_done(task_done);
        )));
        session.set_phantom(budget.phantom_reservation);
///
        let local_pos = (gid as u64 - seg.global_base) as u32;
    // batch. stream_close's teardown barrier releases that borrow before the allocator closes.
/// `create_local_session` with a plan already prepared via
        Some(RelType::ExtensionSingle(e)) => {
    pub sort_orders: Vec<String>,
        }
/// Computes `row_base` as the cumulative prefix sum of file row counts.
    // Java-side FFI structs untouched. The actual *underlying* array buffers live in
    let ctx = SessionContext::new_with_state(state);
    }
                            Err(e) => {
        // Declared stream schema says Millisecond; producer emitted Nanosecond. A real cast
        batch_size,
    if actual_schema.fields().len() != declared.fields().len() {
                collect_reads(input, out);
            before_size,
    );
fn ascending_row_id_check_stream(
        let spill_path = tmp.path().to_str().expect("utf-8 path");
        .unwrap();
    let object_metas = shard_view.object_metas.clone();
    let reader = StreamReader::try_new(Cursor::new(bytes), None)
                plan_bytes.to_vec(),
                collect_reads(input, out);
    }
    let table_schema = schema_from_ipc_bytes(schema_ipc)?;
    /// and bypasses the chmod 0o555 we use to simulate the locked parent, so the
    // per partition per input batch, but using a Vec<RecordBatch> per partition keeps the
                input_id, e
            fields.push(Arc::clone(want));
        // original name. Phase 2 unlinks the .stale entries asynchronously.
            DataType::List(actual_child),
        let schema_ptr = Box::into_raw(Box::new(out_schema)) as i64;
    /// Concurrency gate permit — held for the query's entire lifetime.
                table_name.to_string(),
    Ok(metas)
}
    let wire_slice = std::slice::from_raw_parts(ptr as *const WireFileMetadata, count);
        let mut locked = fs::metadata(parent.path())
            actual_schema.fields().len(),
/// Tripwire at the FFI export boundary — checks, never casts.
    let mut per_segment: HashMap<usize, RoaringBitmap> = HashMap::new();
                full_path, e
        );
    let table_schema = schema_from_ipc_bytes(schema_ipc)?;
        let view = out
    if filenames.len() != writer_generations.len() {
    }
    use parquet::file::metadata::ParquetMetaData;
use crate::shard_table_provider::{ShardTableConfig, ShardTableProvider};
            token.clone(),
    let mut columns = Vec::with_capacity(batch.num_columns());
        //    directories are all renamed identically. Renames are metadata-only
    // ── 5. Wrap and return ──
    ///     to catalog-snapshot order, the per-shard segment iteration is reversed so a TopK
        );
//!
    /// must be cleaned up by the next boot's phase 2, and phase 1 must not
        let spill_path = tmp.path().to_str().expect("utf-8 path");
        .with_task_done(task_done);
// ---------------------------------------------------------------------------
    }
        assert!(link.is_symlink(), "precondition: link is a symlink");
                    .into_builder()
                                spill_path_for_gc.display(), e.kind(), e
            _concurrency_permit: permit,
        (mgr.build_cache_manager_config(), Some(mgr))
    /// test in a user namespace or container that drops the capability.
        runtime,
    .await
    ctx.register_table("t", provider)?;
            // so every buffer/offset/null invariant validate_data() would check
///
            .as_any()
    #[test]
        // SAFETY: geteuid() is async-signal-safe and has no preconditions.
    // user-facing aliases Java wrote (e.g. "RegionID", "u") and must match what the
                )
        let outside = tmp.path().join("outside_target.txt");
///
    let mut array_data = arrow_array::ffi::from_ffi(ffi_array, &ffi_schema).map_err(|e| {
    // ── 4. Execute SQL: compute global __row_id__ = __row_id__ + row_base ──
///   by the caller; ownership transfers to Rust on success.
        file_metadata: None,
                DataType::Timestamp(TimeUnit::Millisecond, tz.clone()),
        // Operator-facing message must include the offending path + io kind so the
            schema_ptrs.len()
        if nt.names.last().map(String::as_str) != Some(table_name) {
        Vec::with_capacity(hash_key_indices.len());
}
                object_meta: meta.clone(),
use crate::query_tracker::{self, QueryTrackingContext, QueryType};
        )
        return Err(DataFusionError::Execution(format!(
                            log::warn!(
                    e.kind(),
            _session_ctx: Some(ctx),
    // here through the partition channel are already typed to match this schema — no
        let names: Vec<String> = schema.fields().iter().map(|f| f.name().clone()).collect();
        Some(RelType::Read(r)) => out.push((**r).clone()),
    );
fn collect_plan_reads(plan: &substrait::proto::Plan) -> Vec<substrait::proto::ReadRel> {
                    "Failed to align imported batch to registered schema for '{}': {}",
            }
    let store = ctx
    );
pub unsafe fn set_memory_pool_limit(ptr: i64, new_limit: i64) -> Result<(), String> {
///
    /// child as non-nullable would hand the consumer nulls it does not expect. The
            handle
/// handle automatically marks the query completed in the registry.
/// `session_ptr` must be a valid, non-zero pointer returned by
        Ok(())
        set_reduce_target_partitions(1000);
    // which are always data-node work. Keeping the coordinator ungated avoids deadlock
        ));
        .map(|(col, field)| match field.data_type() {
            .map_err(|e| DataFusionError::Execution(format!("Substrait encode failed: {}", e)))?;
    use futures::StreamExt;
        assert!(
    };
        // Phase 2: *.stale entries cleaned by the background thread.
        runtime_env,
/// `ShardScanInstructionHandler` produced; the M1 broadcast memtable lives alongside the
        (CacheManagerConfig::default(), None)
///   the caller; ownership transfers to Rust on success.
            // names/metadata (parquet emits `List<element>`, Substrait declares
                        let prev = map
        config.batch_size,
        //    (one syscall per entry, contents not touched). Failure aborts
#[repr(C)]
                            }
                    crate::ROW_ID_COLUMN_NAME,
                DataType::BinaryView => {
/// Creates a native reader (ShardView) for the given path and files.
/// # Safety
                        };
use crate::query_executor;
pub struct DataFusionRuntime {
    array_ptrs: &[i64],
    Ok(output)
        );
/// when `classify_filter` returns `None` (no automatic retry on the ListingTable
                                );
                                continue;
    use std::io::Cursor;
        &ctx.state(),
        array_data.align_buffers();
            schema,
                            continue;
                        add(
    /// Lock for tests that mutate `memory_guard`'s global SPILL_ENABLED / SPILL_DIR or that
    cache_manager_ptr: i64,
    }
            // are also rewritten to view types. DataFusion's non-recursive
        let spill_path = parent.path().join("spill");
        ]));
        //  Phase 1 (sync, on boot thread): rename every immediate child to a
        assert!(ptr > 0);
//! # Pointer contract
    )? {
                let path = entry.path();
            "leaked datafusion-* original name must be gone (renamed)"
/// phase 1 (which renames the link, never the target) and unlinked in
        Some(batch) => {
    // logic robust to upstream changes.)
        }
        .object_store(&shard_view.table_path)?;
/// Streaming-input registration for the M3 hash-shuffle AGGREGATE worker.
    // not as part of a stream of partitioned batches, so the input "partition index" is 0 of 1.
/// effectively disables adaptive reduction.
            cleaned,
                .block_on(async {
) -> Result<i64, DataFusionError> {
/// `filenames` are kept in the order supplied by the caller.
        // no synthetic MemTable is registered for it, and planning the producer
        plan: Arc<dyn datafusion::physical_plan::ExecutionPlan>,
/// `ptr` must be a valid pointer returned by `create_global_runtime`.
    columns: Vec<String>,
/// Caller must call `close_reader` exactly once to free it.
        let compacted = compact_string_view_columns(batch);
            DataType::Timestamp(TimeUnit::Millisecond, None),
            .expect("runtime build");
/// (`block_on` for synchronous FFM entry, `spawn` for async delivery).
        shard_view.writer_generations.as_ref(),
/// 3. Utf8/Utf8View: a real value-preserving cast, because their buffer layouts differ.
        let schema = Arc::new(Schema::new(vec![Field::new(
        let _ = Box::from_raw(sender_ptr as *mut PartitionStreamSender);
    // not normal end-of-stream: callers must receive an error rather than the
/// Bundles a stream with its query tracking context so that dropping the
    /// Cumulative row count from all preceding files.
    let first_meta = shard_view.object_metas.first()?;
        })?;
        if let Some(rel) = root_rel(plan_rel) {
        let after_size = compacted.column(0).get_array_memory_size();
/// Returns a heap-allocated FFI_ArrowArray pointer (as i64), or 0 if end-of-stream
                     borrowed buffers; proceeding with allocator close (possible leak)"
            "DiskManager cap must equal the positive spill_limit passed in"
    // by value). Java's expectation is that ownership of the input does NOT transfer. We
        Self::collect_metrics(plan.as_ref(), &mut map);
            "str_col",
/// Loads the next record batch from the stream.
        let values: Arc<dyn Array> = Arc::new(StringViewArray::from_iter_values(["prod", "error"]));
/*
    // is irrelevant — no spill to throttle. One statvfs call (~1µs) only when enabled.
                let name_str = name.to_string_lossy();
    manager: &RuntimeManager,
pub unsafe fn partition_batch_by_hash(
        let list = ListArray::new(
}
        let leaked_b = tmp.path().join("datafusion-Xy9pQ2");
            }
        let out = conform_batch_to_schema(batch, &declared).unwrap();
    // Attach the teardown signal so stream_close releases borrowed input batches before allocator close.
            return Err(DataFusionError::Execution(format!(
            handle
            Field::new("s", DataType::Utf8View, true),
            // still holds. Skipping validation keeps this O(1) instead of a full
        // a no-op for already-aligned buffers and reallocates only the misaligned ones —
    /// double-suffix them (no datafusion-old.stale.stale).
/// registers here — no per-batch cast needed at the partition-stream feed.
/// Executes a query. Returns a heap-allocated pointer (as i64) to the result stream.
            .unwrap();
pub struct QueryStreamHandle {
            Field::new("str_col", DataType::Utf8View, false),
/// call `close_local_session` exactly once to free it.
    }
    stream: datafusion::execution::SendableRecordBatchStream,
    if ptr == 0 || count == 0 {
        fs::write(leaked_a.join("tmp_001.arrow"), b"data a").expect("write a");
        assert!(
    let current_phantom = session.phantom_size();
        let col = batch.column(row_id_idx);
        assert!(ptr > 0);
            // SAFETY: `data` was taken from a valid array and only its data_type
        let compacted = compact_string_view_columns(batch.clone());
                }
        let combined = if part.is_empty() {
/// applied here beyond the post-physical coercer. The plan is dropped at
    use arrow::ipc::reader::StreamReader;
) -> Vec<ShardFileInfo> {
    // StreamingTable advertises the declared schema, and downstream operators
            .options()
    query_context: &mut QueryTrackingContext,
/// the schema once on the dispatch side and threads it through the
        // over Utf8View / Timestamp(Millisecond) — same plan, divergent
        // guards against future refactors that hoist the cleanup out of the else-branch.
    let global_pool = runtime.runtime_env.memory_pool.clone();
        let declared: SchemaRef = Arc::new(Schema::new(vec![Field::new(
                    }
        );
    fn binaryview_gc_compacts_sliced_buffers() {
            //
                col, names
    // aborts the CPU task), flush the runtime so the cascading abort of
    let physical_plan = df.create_physical_plan().await?;
            budget.phantom_bytes / batches_in_pipeline
/// Falls back to 8GB if disk space cannot be determined.
            log::info!(
use crate::datafusion_query_config::DatafusionQueryConfig;
        };
            for rg in &seg.row_groups {
                    let view: &arrow_array::BinaryViewArray = col
        )));
        let stale_dir = spill_path.join("datafusion-aB3kF7.stale");
    #[test]
/// Identical to [`register_partition_stream_on_session_context`] (channel +
/// Per-file info used by `ShardTableProvider` to inject `row_base` as a
    memory_pool_limit: i64,
        let spill_path = tmp.path().to_str().expect("utf-8 path");
/// `ReadRel.base_schema` to the registered provider BY NAME. The producer ships the PARTIAL
    pub fn new_with_plan(
            .any(|f| matches!(f.data_type(), DataType::Utf8View | DataType::BinaryView))
            .expect("runtime LIST batch builds");
pub unsafe fn sender_send(
/// Best-effort budget acquisition from cached parquet metadata.
        let declared = Arc::new(Schema::new(vec![Field::new(
/// catalog is the source of truth. The generation is later passed to
    use datafusion::execution::cache::cache_manager::CachedFileList;
    // Engine-native-merge: Partial state types differ from Final output (Binary HLL sketches,
        .as_any()
        .with_runtime_env(runtime_env)
        .build();
    // Resolve the object store: if store_ptr > 0, clone the Arc from the boxed pointer.
            .collect();
            let timed_out = mgr
            stream,
        let schema = Arc::new(Schema::new(vec![
/// This is an async function — the bridge layer decides how to run it
        let result = create_global_runtime(64 * 1024 * 1024, 0, spill_str, 0);
    /// Returns execution metrics from ALL operators in the physical plan tree as JSON bytes.
    use arrow_schema::{Field, Schema};
        .register_table(input_id, Arc::new(table))
    // first batch is produced (planning, from_substrait_plan, repartition
            .with_default_features()
/// coordinator-reduce path uses in [`register_partition_stream`] — instead of trusting the raw
        let sliced = batch.slice(0, slice_rows);
/// against. NamedTable references are resolved against empty MemTables built
    let stream = *Box::from_raw(stream_ptr as *mut RecordBatchStreamAdapter<CrossRtStream>);
            schema_ptrs.len()
        .map(|f| match f.data_type() {
/// [`register_memtable_on_session_context`] also takes a schema blob.
                cpu_executor,
            "spill root must be preserved across cleanup"
        }
}
///
/// - `array_ptrs` and `schema_ptrs` must point to populated FFI structs owned
            ))
        let base_schema = read
        sort_fields,
            vec![Arc::new(Int64Array::from(vec![1]))],
        Self {
        let actual_child = Arc::new(Field::new("element", DataType::Utf8View, true));
            let array_data = struct_array.into_data();
    // Build file infos with access plans for targeted row retrieval
        );
pub unsafe fn close_global_runtime(ptr: i64) {
/// Body only runs under `debug_assertions` (called from a `debug_assert!`).
    _query_tracking_context: QueryTrackingContext,
/// error instead of native memory corruption.
                collect_reads(right, out);
        } else if part.len() == 1 {
    let mut output: Vec<(i64, i64)> = Vec::with_capacity(partition_count as usize);
    }
            _session_ctx: None,
///
            return;
    // kernels require 64-byte alignment; align_buffers() reallocates only the misaligned
            ))
        let outer_subdir = tmp.path().join("subdir");
/// # Writer generations
            .copied_config()
    // Reconstruct the stream from the raw pointer returned by the executor.
        // recursive removal (a shallow delete would miss the nested file).
    #[test]
///
        } else if col.data_type().equals_datatype(want.data_type()) {
        });
            )])),
        // Bind first, then trait-upcast at the let-binding boundary
            DataType::BinaryView => {
        use arrow_schema::{Field, Schema};
            Arc::new(Schema::new(vec![
                as *const Arc<
/// [`crate::relabel_exec::RelabelExec`] (zero-copy bit-tag flip per mismatched
    ))?;
/// is no automatic retry on the vanilla path — a false positive is a hard
    file_metadata: &[FileRowMetadata],
use datafusion::execution::RecordBatchStream;
            columns.push(cast);
                        }
    }
            path: &'a std::path::Path,
        let out = super::conform_batch_to_schema(batch, &declared).unwrap();
        let actual_schema = Arc::new(Schema::new(vec![Field::new(
/// schema as IPC bytes so the Java side can validate fed batches against it.
    /// *.stale name. Phase 2 then removes the *.stale entries asynchronously.
            .await?;
            let names: Vec<String> = schema.fields().iter().map(|f| f.name().clone()).collect();
}
    handle
/// promoted to `Timestamp(Millisecond)` by the data-node parquet round
            info
pub struct WireFileMetadata {
        // for dirs). The original names are gone immediately after phase 1; wait
                        // keeps the symlink defense — fs::remove_file on a symlink
            values,
                a.data_type(),
        assert!(
/// When `spill_dir` is non-empty, every immediate child is removed:
    const FRACTION: f64 = 0.80;
                collect_reads(input, out);
/// Fails a partition stream so the consumer's `RecordBatchStream` yields a terminal ERROR (failing
        log::info!("DataFusion spill disabled (datafusion.spill_directory not set)");
    };
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
    // cached metadata (zero I/O); if not cached, skip budget (first query warms the
        .register_table(input_id, Arc::new(table))
            "expected DiskManagerMode::Disabled when spill_dir is empty"
    use parquet::arrow::parquet_to_arrow_schema;
        .map_err(|e| DataFusionError::Execution(format!("Schema conversion failed: {}", e)))?;
        // Column passes through unchanged — same Arc, original nanosecond type, no truncation.
    /// DataSourceExec skips row groups and applies RowSelection.
/// [`LocalSession::prepare_final_plan`].
            ],
/// catalog snapshot (`WriterFileSet.writerGeneration` and `WriterFileSet.files()`); the
    config.options_mut().execution.parquet.pushdown_filters = true;
///
/// Safe to call with 0 (no-op).
            msg
/// path) — unreachable in practice because the needle is not a valid DataFusion
    let parquet_meta = cached
    if actual.fields().len() != expected.fields().len() {
        );
    fn wait_until<F: Fn() -> bool>(timeout_ms: u64, predicate: F) -> bool {
        Self {
    ///   - Indexed path (`indexed_executor`): when the query's leading ORDER BY runs counter
        let batch = RecordBatch::try_new(actual_schema, vec![Arc::new(list)])
                format!("\"{}\"", c)
/// Converts SQL to Substrait plan bytes (test only).
/// passed the raw pointers as two parallel slices. Rust takes ownership of
            query_executor::execute_query(
///
                })?;
        return read.base_schema.clone();
        array_data.align_buffers();
            view_needs_gc(
                );
        let _guard = lock_process_globals();
/// - `session_ptr` must be a valid, non-zero pointer returned by
pub struct ShardFileInfo {
            msg.contains(bad_path_str),
/// stream's mpsc. The Rust side takes ownership of the
    /// Test helper: poll until `predicate` returns true or `timeout_ms` elapses.
}
            Arc::new(Schema::new(vec![Field::new("n", DataType::Int64, false)]));
    // bit-compatible Int/UInt pairs; Utf8 and Utf8View have distinct buffer
///
            }
        }
    let token = query_tracker::get_cancellation_token(context_id);
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, spill_str, 0).expect("runtime build");
            }
///
    // bumps) and isolates the owned-by-Rust working batch from the input wrappers.
    use arrow::ipc::writer::StreamWriter;
    let is_significantly_bloated = bytes_allocated > 2 * bytes_used;
                                    path.display(), e.kind(), e
        .ctx
///     sibling. Renames are metadata-only — one syscall per entry, contents
            .build();
pub unsafe fn stream_close(stream_ptr: i64) {
        fs::create_dir(&leaked_a).expect("create leaked a");
    // fn to call. Otherwise the caller's close() segfaults on a null release pointer.
    use datafusion::execution::cache::{CacheAccessor, DefaultListFilesCache};
        // stage to derive a producer schema for.
        // Matching column keeps its original Arc (no copy).
        let ffi_array = FFI_ArrowArray::from_raw(array_ptr as *mut FFI_ArrowArray);
                .await
    let columns: Vec<Arc<dyn Array>> = batch
        if !a.data_type().equals_datatype(e.data_type()) {
    /// parallel by default; without serialization, two runtime-construction tests would race on
            .map(|i| format!("long_string_value_{:06}_padding", i))
        let rg_counts = if wire.row_group_row_counts_ptr == 0 || num_rgs == 0 {
        }
pub async unsafe fn execute_query(
            // state for DataFusion to start; the *.stale entries just persist
    const FALLBACK: u64 = 8 * 1024 * 1024 * 1024; // 8GB
use datafusion::datasource::physical_plan::parquet::{ParquetAccessPlan, RowGroupAccess};
        let int_array = Int64Array::from_iter_values(0..1000);
}
    #[test]
}
    handle
/// `stream_ptr` must be a valid, non-zero pointer. Must not be called concurrently
            })?;
        let _restore = RestorePerms {
#[derive(Debug, Clone)]
                        path.display(),
        let aligned_values = aligned_list
use crate::cross_rt_stream::CrossRtStream;
    let plan: substrait::proto::Plan = prost::Message::decode(plan_bytes).ok()?;
            // until a future boot with a healthy thread library reaps them.
        let total_rows = 10_000usize;
    }
/// scan registered, so the join's two `NamedScan`s resolve against streaming tables alongside
        ))
            "Sliced array must be detected as needing gc"
/// the shard's parquet listing.
        //    <name>.stale sibling. One uniform branch — files, symlinks, and
    partition_count: i32,
        let stale_b = tmp.path().join("datafusion-Xy9pQ2.stale");
    }
/// Java imports every batch against the schema returned once by `stream_get_schema`,
        assert_eq!(ts.value(1), 2_000_000_999);
    }
        let strings: Vec<String> = (0..total_rows)
            out.column(0).data_type(),
/// `ptr` must be a valid pointer returned by `create_global_runtime`.
            1_000_000_001i64,
) -> Result<Vec<u8>, DataFusionError> {
    /// Phase 1 (sync rename) must observably move each orphan subdir to a
        {
                DataType::Timestamp(TimeUnit::Nanosecond, None),
/// recursive unlinks happen in parallel with cluster join. Re-scanning by
    // Buffers from Java's Flight RPC deserialization may not meet Rust's
        assert!(
        let stale = tmp.path().join("leaked_from_prior_run.tmp.stale");
    let batch = conform_batch_to_schema(borrowed_batch, sender.schema())?;
    let mut array_data = array_data_result.map_err(|e| {
        let out = super::conform_batch_to_schema(batch, &declared).unwrap();
    let fields: Vec<Field> = schema
            .downcast_ref::<TimestampNanosecondArray>()
    // page-index region so query range keys match eager warm-population (warm hits).
pub(crate) fn first_named_table_name(plan_bytes: &[u8]) -> Option<String> {
                    col.data_type(),
///
        // Cleanup failure is operator-actionable (permissions, RO mount, I/O) and
                        serde_json::Value::Number(serde_json::Number::from(prev + delta)),
    let partition: Arc<dyn datafusion::physical_plan::streaming::PartitionStream> = Arc::new(
        }
                })
) -> Result<i64, DataFusionError> {
        None
    ///
        let _guard = lock_process_globals();
///
    // Use the handle's OWN token, not a registry lookup by context_id. The
    // rebuild RecordBatches against it, so an unconformed string-view mismatch
                .iter()
                effective_config,
        })?;
            stream,
        );
    let current_partitions = session.target_partitions();
/// buffer layout differs from that schema is therefore read as garbage (the
        assert!(ptr > 0);
        // ExtensionSingleRel. Without these arms the ReadRel is invisible here,
mod tests {
/// - `session_ctx_handle_ptr` must be a valid, non-zero pointer returned by
    let (cross_rt_stream, _abort_handle, task_done) =
        new_query_tracking_context(context_id, global_pool.clone(), QueryType::Shard);
    let schema = stream.schema();
            DataType::Utf8View,
        }
    let runtime = &*(ptr as *const DataFusionRuntime);
        let arrow_schema = crate::schema_coerce::coerce_inferred_schema(Arc::new(arrow_schema));
        let sliced = batch.slice(0, slice_rows);
/// wipe outside the spill mount.
    }
///
    }
        Some(query_context.set_phantom_corrector(corrector))
    schema_ptrs: &[i64],
    })
    let (re_array, re_schema) = arrow_array::ffi::to_ffi(&array_data).map_err(|e| {
                access_plan: None,
            if let Err(e) = std::thread::Builder::new()
        let out = super::conform_batch_to_schema(batch, &declared).unwrap();
    pub fn get_metrics_json(&self) -> Option<Vec<u8>> {
        assert!(
    /// Used to wait on the background spill-cleanup thread without an arbitrary sleep.
/// closes the channel as a clean EOF, so a producer that died mid-stream (e.g. a spill-read failure
    let state = SessionStateBuilder::new()
        // Utf8 vs Utf8View child: the SIGSEGV class, must be rejected.
        // set_spill_dir flips SPILL_ENABLED on. Whether it's Available or Critical
//!   same pointer.
        // Non-divergent column is untwiddled.
        let schema = listing_options
                        "Failed to rename leaked spill entry {} -> {} (io kind={:?}): {}. \
/// schema as a standalone IPC blob produced by `ArrowSchemaIpc.toBytes(...)`.
/// would nuke active spill state — rethink before adding one.
        None => return stream, // schema-presence checked elsewhere; nothing to validate here
///
        stream: RecordBatchStreamAdapter<CrossRtStream>,
        parquet_meta,
                    panic!(
        // The cleanup logic must live entirely inside the spill-enabled branch. With
                            .unwrap_or(i64::MAX);
        } else {
/// boot thread pays only the rename count (≈10s of µs per entry) and the
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, "", 0).expect("runtime build");
        let spill_str = spill_path.to_str().expect("utf-8 path");
        let arr = col
        fs::write(leftover.join("residue.arrow"), b"prior boot data").expect("write residue");
) -> arrow::datatypes::Schema {
            tmp.path().exists(),
    let provider = Arc::new(ShardTableProvider::new(ShardTableConfig {
        let _guard = lock_process_globals();
        physical_plan.schema(),
}
            before_size > after_size * 100,
            names
/// `ptr` must be 0 or a valid pointer returned by `create_reader`.
                fields,
        use arrow_array::{TimestampMillisecondArray, TimestampNanosecondArray};
        assert!(
    // Recreate the FFI handles back in place so the caller's release closure on the
        let string_view_array =
        fs::create_dir(&leaked_b).expect("create leaked b");
    // After dropping the QueryStreamHandle (which drops CrossRtStream → JoinSet →
            seg_idx,
use datafusion::prelude::{SessionConfig, SessionContext};
            "Expected >100x reduction on StringView column, got before={} after={} ratio={}",
        );
                if v < prev {
            true,
    #[test]
    let row_id_idx = match schema.column_with_name(crate::ROW_ID_COLUMN_NAME) {
            collect_reads(&rel, &mut reads);
    // The doc-values cursor is opened from Lucene with only a file path, so it reads the environment
/// `out_ptr` must point to a buffer of at least 2 i64 values.
        for i in 0..arr.len() {
            .await
        use arrow_schema::{Field, Schema};
    /// pre-fix code path would silently succeed and the test would assert nothing.
            num_rows: seg.max_doc as u64,
                .collect();
/// The schema is derived by lowering `partial_plan_bytes` (the producer side's
        // Lock parent to r+x only — simulates the mount-point parent the JVM doesn't own.
    context_id: i64,
/// must not release them after a successful send. On error ownership is
            return Ok(Arc::new(Schema::new_with_metadata(
    use datafusion::prelude::SessionContext;
        if col.data_type() == want.data_type() {
/// If not cached: returns None (first query — skip budget, warm cache).
    } else {
                                serde_json::Value::Number(serde_json::Number::from(v)),
    // the FFI wrappers from raw pointers without consuming them — clone them by reading
    runtime.runtime_env.memory_pool.reserved() as i64
/// is the only precision that needs coercion).
        )]));
    let partitioning =
        );
        None => {
    for &idx in hash_key_indices {
        };
    use datafusion::datasource::file_format::parquet::ParquetFormat;
            vec![
        // reachable with more than one shard since a single shard has no reduce
    fn create_global_runtime_unlinks_top_level_symlink_without_following() {
    }
    // Java side sees an intact, releasable struct. from_ffi consumed the FFI_ArrowArray
        // The spill directory itself is never removed (mount-point safe).
            .expect("stat parent")
    let runtime = &*(ptr as *const DataFusionRuntime);
//! - `stream_get_schema`, `stream_close` must NOT be called
                            serde_json::Value::Number(serde_json::Number::from(value)),
use datafusion::execution::runtime_env::RuntimeEnvBuilder;
/// # Safety
static REDUCE_TARGET_PARTITIONS: std::sync::atomic::AtomicUsize =
            cpu_exec.clone(),
                                "Background spill cleanup: failed to remove {} (io kind={:?}): {}",
    use substrait::proto::read_rel::ReadType;
/// Delivery is OUT-OF-BAND (`PartitionStreamSender::fail` sets a flag the receiver reads on close), so
        let leaked_file = leaked_dir.join("tmp_spill_001.arrow");
            task_done: None,
        if has_nontrivial_state
    let stream_ptr = cancellation::cancellable(token.as_ref(), context_id, query_future)
                >)
        try_acquire_budget_from_cache(shard_view, runtime, global_pool, &cfg)
///
        filenames,
    config: &DatafusionQueryConfig,
    columns: &[String],
//! - `init_runtime_manager` and `shutdown_runtime_manager` must be called from a
                    let mut perms = metadata.permissions();
    ) -> Self {
        session.memory_pool(),
///   * **Phase 1 (sync, on this thread):** every immediate child (files,
}
    let df = ctx.sql(&sql).await?;
//!   concurrently on the same stream pointer.
            b"must NOT be touched",
        })?;
            // is replaced with one `equals_datatype` has proven layout-identical,
        // Wipe leaked entries from a prior non-graceful shutdown.
/// column), so runtime batches arrive with the same type tags the consumer
        assert!(!nested_dir.exists(), "nested leaked subdir must be removed");
        }
/// The split keeps boot fast even with tens of GB of orphan spill data: the
            Arc::new(Schema::new(vec![
}
        .state()
/// the join/agg) instead of a clean EOF, then takes ownership of the sender and drops it (the same
    }
    let mut metas = Vec::with_capacity(filenames.len());
                let view: &arrow_array::BinaryViewArray = col
/// The OpenSearch process must own `spill_dir` with `rwx`. Write on the
                        key,
        &query_config,
    );
) -> bool {
) -> Result<Vec<u8>, DataFusionError> {
        let declared: SchemaRef =
        if let Some(metrics) = plan.metrics() {
//! corresponding close function exactly once.
            arrow_schema
    /// Pointer to array of i64 row counts (one per row group).
    // into a fresh ArrayData per column via a clone after import. The clone is cheap (Arc
        sender.terminate_early();
}
        let combined_data: arrow::array::ArrayData = StructArray::from(combined).into();
        "shuffle partition stream failed on the producer/drain side: {reason}"
/// # Safety
            Arc::new(Schema::new(vec![Field::new(
/// # Safety
    })
    };
    pub object_metas: Arc<Vec<object_store::ObjectMeta>>,
        unsafe { close_global_runtime(ptr) };
    /// at that moment with "no global DataFusion runtime environment".
    for (&array_ptr, &schema_ptr) in array_ptrs.iter().zip(schema_ptrs.iter()) {
    // the underlying memory. The simplest path is to import normally (consuming the FFI
    #[test]
/// Three tiers, checked per column against the declared field:
    // for the input not to leak / double-free. The simplest way: convert the ArrayData
        let stale_top = tmp.path().join("top.tmp.stale");
    session_ptr: i64,
        }
    let mut batches = Vec::with_capacity(array_ptrs.len());
        return stream;
    REDUCE_TARGET_PARTITIONS.store(
        DataFusionError::Execution(format!(
    Ok(buf)
                "skipping create_global_runtime_succeeds_when_jvm_does_not_own_spill_parent: \
    let mut result = Vec::with_capacity(count);
            }
                .stream
/// The input batch is borrowed (not consumed) — the Java caller retains ownership and is
        let batch =
            DataType::List(declared_child),
fn conform_batch_to_schema(
use futures::TryStreamExt;
    let declared_names: Vec<String> = plan
    ));
    // parallelism. Skip if a prior child already acquired a larger phantom.
            .as_any()
                    "Failed to spawn background spill cleanup thread: {}. \
            .as_any()
/// on the same stream.
        ));
        assert!(
    // a `cancel_query(context_id)` call from Java interrupts even before the
        );
///
/// aggregate's *physical* output batches, whose state columns are named `<alias>[<state>]`
            "tags",
    // 64-byte. Mirror the same align_buffers dance the broadcast injection uses.
                    want.data_type(),
                     Verify the process owns the spill directory before restarting.",
                        stale.display(),
                    "Failed to align imported batch to registered schema for '{}': {}",
        let array_ptr = Box::into_raw(Box::new(out_array)) as i64;
pub fn set_reduce_target_partitions(value: i64) {
        unsafe { close_global_runtime(ptr) };
fn resolve_dynamic_spill_limit(spill_dir: &str) -> u64 {
        query_context: QueryTrackingContext,
/// on the Java drain thread) would otherwise make the consumer silently compute a result from PARTIAL
///
    .map(Arc::new)?;
        // The build-side IPC payload arrives via Java's ArrowStreamReader, which produces
        query_tracker::set_cpu_runtime_handle(context_id, rt);
                        add(map, other.name().to_string(), other.as_usize() as i64);
/// Extracts the `base_schema` NamedStruct from the plan's first ReadRel matching `table_name`.
            .with_metadata(f.metadata().clone()),
    const ROW_ID: &[u8] = crate::ROW_ID_COLUMN_NAME.as_bytes();
            !leaked_file.exists(),
        assert!(
                Arc::new(StringArray::from(vec![Some("a"), None, Some("c")])),
/// Unlike [`register_memtable`], this entry point takes an Arrow IPC schema blob directly
    session.register_memtable(input_id, table_schema, batches)?;
    )
/// # Safety
}
/// The sender is always dropped. (codex round-5 BLOCKER #1.)
    )?;
/// `sender_ptr` must be 0 or a valid pointer returned by
/// Must stay in lockstep with the Java `MemoryLayout`.
/// suffix in phase 2 also cleans up `*.stale` leftovers from any prior boot
            "original subdir name must be gone (renamed)"
        Arc::clone(&store),
            }
                "partition_batch_by_hash: hash key index {} out of range for {}-column schema",
    let ffi_array = FFI_ArrowArray::from_raw(array_ptr as *mut FFI_ArrowArray);
    /// inline recursive removal would be flagged.
        let binary_view_array =
    fn reduce_target_partitions_roundtrips_and_clamps() {
        value.max(1).min(32) as usize,
/// Mirror parquet's coercion of Arrow Timestamp precisions it cannot
/// fail with `EACCES` in that topology. Top-level symlinks are renamed in
        session.reduce_target_partitions(budget.target_partitions);
        })?;
    // (sender/StreamingTable) schema is Utf8View, or vice versa — e.g. an outer
                    want.name(),
    .map_err(DataFusionError::Execution)?;
    /// `close_global_runtime` then leaves it dangling — which fails any doc-values test reading it
    fn stringview_gc_compacts_sliced_buffers() {
                "Failed to register streaming table '{}' on session context (from partial plan): {}",
///
    reads
        let col: arrow_array::ArrayRef = Arc::new(TimestampNanosecondArray::from(vec![
    ///     TopK / SortPreservingMerge.
            schema,
    object_metas
            }
//! # Thread safety
        ]));
        stream: RecordBatchStreamAdapter<CrossRtStream>,
            msg.contains("Failed to enumerate spill directory")
        )));
        }
        let list = ListArray::new(
    // Extract the substrait-declared output names from Plan.Root.names — these are the
                DataType::Utf8View => {
    // Route to the indexed executor when the plan has an index_filter UDF or
    pub row_group_row_counts: Vec<u64>,
            after_size,
            fs::read(&outside).expect("read outside file"),
/// producer will actually emit, so we eliminate any divergence between
                    for entry in entries {
    let (sender, receiver) = crate::partition_stream::channel(Arc::clone(&table_schema));
///
    // No concurrency gate here — this is the coordinator/legacy path.
                    let selection =
/// ("execute_indexed_query called with no index_filter(...) in plan"). There
                    Field::new(name.as_str(), f.data_type().clone(), f.is_nullable())
        handle._query_tracking_context.context_id(),
    fn stringview_gc_inline_strings_no_change() {
                let msg = format!(
    Ok(Box::into_raw(Box::new(handle)) as i64)
}
        let before_size = sliced.columns()[0].get_array_memory_size();
        writer
    fn create_global_runtime_with_empty_spill_dir_does_not_touch_filesystem() {
                    );
            "spill-disabled runtime must surface SpillBudget::Disabled (not Critical) so the caller does not clamp parallelism"
            })?;
        )));
    })?;
/// from the substrait base_schema — the plan itself is the source of truth for
/// and stream wrapping. The fetch-specific logic is building ParquetAccessPlans
        return Err(DataFusionError::Execution(format!(
                input_id, e
                            }
/// Returns the current memory pool usage in bytes.
        assert!(
        let out = super::conform_batch_to_schema(batch, &declared).unwrap();
    fn create_global_runtime_with_empty_spill_dir_disables_disk_manager() {
            vec![Arc::new(binary_view_array), Arc::new(int_array)],
            // has not yet joined, but stragglers are recoverable next boot.
use crate::runtime_manager::RuntimeManager;
            Ok(b) => b,
}
                        .expect("column must be StringViewArray when schema declares Utf8View");
}
                .spawn(move || {
                collect_reads(input, out);
        }
/// Registers a streaming partition input on a `SessionContextHandle` under `input_id`,
                        Err(e) => {
        let bad_path = tmp.path().join("regular_file");
        let sliced = full_array.slice(0, 100);
        // Phase 1: symlink is renamed inline (fs::rename does not follow symlinks).
        // not the 64-byte alignment DataFusion's SIMD kernels require. align_buffers() is
        std::sync::atomic::Ordering::Release,
            cleaned,
    if schema.column_with_name(crate::ROW_ID_COLUMN_NAME).is_none() {
        fs::write(&bad_path, b"not a directory").expect("seed regular file");
/// Build `ShardFileInfo` from object metas and file metadata.
                    log::error!("{}", msg);
        // outside_target sits next to spill/. If cleanup followed the symlink, it would be deleted.
    let table = datafusion::catalog::streaming::StreamingTable::try_new(
        let values: Arc<dyn Array> = Arc::new(StringViewArray::from_iter_values(["a"]));
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, spill_path, 0).expect("runtime build");
        let cleaned = wait_until(2000, || !stale.exists());
        assert_eq!(get_reduce_target_partitions(), 32);
}
            batches_in_pipeline,
        }
        fs::create_dir(&leftover).expect("create leftover");
    // ones (no-op for already-aligned).
/// Returns the Arrow schema for the given stream as a heap-allocated FFI_ArrowSchema pointer.
    sort_fields: Vec<String>,
        if let Some(ReadType::NamedTable(nt)) = read.read_type {
use arrow_array::ffi::FFI_ArrowArray;
            false,
    // to the physical plan's output schema, matching what isthmus declared on the wire
/// `ptr` must be 0 or a valid pointer to `count` consecutive `WireFileMetadata` structs.
            // Failing boot here would be more disruptive than the wasted disk.
    use substrait::proto::{read_rel::ReadType, Plan};
    // Look up metadata for the first file
            .as_any()
        assert_eq!(out.schema().field(0), &actual_field);
            before_size,
            "spill mount-point must remain a directory"
    let target_schema = Arc::new(arrow_schema::Schema::new_with_metadata(
            None,
            get_reduce_target_partitions(),
            msg
use object_store::{ObjectStore, ObjectStoreExt};
        }
    #[cfg(unix)]
                table: None,
    // divergences (e.g. Timestamp precision) are left untouched — see
    // means a single ordered execution, so the check is global, not per-batch only.
    let mut reads = Vec::new();
        )]));
        if let Some(mgr) = crate::ffm::try_get_rt_manager() {
                Arc::clone(&shard_view.store),
///
        // Phase 1: both originals are renamed inline — gone immediately by the
        let ffi_schema = FFI_ArrowSchema::from_raw(schema_ptr as *mut FFI_ArrowSchema);
        .with_default_features()
    filenames: Vec<String>,
        // it during remove, the outside file would have been clobbered.
    use prost::Message;
        ]));
/// phase 2 via `remove_file`, so a stray symlink can never redirect the
///    nullability, child names/metadata may differ): zero-copy relabel. This is the
    crate::udf::register_all(&ctx);
pub unsafe fn stream_get_schema(stream_ptr: i64) -> Result<i64, DataFusionError> {
        let cleaned = wait_until(2000, || !stale_a.exists() && !stale_b.exists());
/// Closes a `LocalSession`. Safe to call with 0 (no-op).
    #[test]
    context_id: i64,
) -> Result<(), DataFusionError> {
    ) -> Self {
        )]));
}
        partitioning,
                    crate::ROW_ID_COLUMN_NAME
            )));
                        // Use file_type (lstat semantics, does not follow symlinks)
    // more (partition_index, sub_batch) calls — we accumulate, then export each as one
/// whose cleanup thread did not finish.
        assert_eq!(aligned_values.value(0), "prod");
/// All `ReadRel`s reachable from the plan's roots.
    shard_view_ptr: i64,
        return Err(DataFusionError::Execution(format!(
    let cpu_executor = manager.cpu_executor();
        unsafe { close_global_runtime(ptr) };
                available,
    if sender_ptr != 0 {
    let partition: Arc<dyn datafusion::physical_plan::streaming::PartitionStream> = Arc::new(
    permit: Option<tokio::sync::OwnedSemaphorePermit>,
            .expect_err("view vs offset buffers must not be exported");
            "top-level file original name must be gone (renamed)"
            filenames.len(),
    shard_view: &ShardView,
/// # Safety
/// go below this value. Setting it equal to configured target_partitions
/// Unlike [`register_partition_stream`] this entry point takes an Arrow IPC schema blob
        // physical outputs, runtime schema-mismatch on the wire.
/// directly. The hash-shuffle path has no producer-side substrait plan to derive the schema
                .zip(declared_names.iter())
    let _ = std::fs::create_dir_all(spill_dir);
                table_name.to_string(),
    /// rmdir; the fix wipes contents only.
            crate::memory_guard::SpillBudget::Disabled,
//! null-checking before calling. Functions that return `i64` return heap-allocated
                    e
            // Spawn failure itself is rare (EAGAIN/ENOMEM under extreme system
                .apply_pending_phantom_correction();
                    .filter(|&pos| pos >= rg_start && pos < rg_end)
    physical_plan: Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
    let (sender, receiver) = crate::partition_stream::channel(Arc::clone(&table_schema));
            "error must reference the offending path; got: {}",
}
/// - `session_ctx_handle_ptr` must be a valid, non-zero pointer returned by
    Ok(wrap_stream_as_handle_with_plan(
        //
    if sort_fields.len() != sort_orders.len() {
            .as_any()
// ── QTF fetch-phase assertion helpers (kept at the bottom of the file) ────────
                                log::warn!(
            part.into_iter().next().unwrap()
                            );
        }
                // contents not touched. Same parent (spill_path), so requires
    use arrow_array::Int64Array;
        let runtime_env =
    }
    Ok(Box::into_raw(Box::new(sender)) as i64)
        return Err(DataFusionError::Execution(format!(
                    }
            DataFusionError::Execution(format!("partition_batch_by_hash: export failed: {}", e))
/// `create_global_runtime`.
    use datafusion::datasource::MemTable;
        )
/// Mirrors [`execute_local_plan`] for the prepared-plan path: registers a
            if let Some(input) = &f.input {
        let nested_dir = tmp.path().join("subdir/deeper");
/// all batches for this partition have been pushed (or on cancellation).
    }
    Ok(crate::schema_coerce::coerce_inferred_schema(
        permit: Option<tokio::sync::OwnedSemaphorePermit>,
                        e.kind(),
        .map_err(|e| DataFusionError::Execution(format!("schema_from_ipc_bytes: {}", e)))?;
        .unwrap();
            batch.columns()[0].get_array_memory_size(),
        // Producer emitted plain Utf8 for the string column.
        .with_config(SessionConfig::new())
        // Empty spill_dir is the "disabled" sentinel from Java. The runtime must build
    object_metas: &[object_store::ObjectMeta],
        config.target_partitions,
    #[test]
/// - `sender_ptr` must be a valid, non-zero pointer returned by
                format!(
    let (cross_rt_stream, _abort_handle, task_done) =
            if c == crate::ROW_ID_COLUMN_NAME {
            }
/// (the broadcast probe path has no producer-side substrait plan to derive the schema from —
        assert!(ensure_batch_matches_stream_schema(&batch, &wider).is_err());
                            map.insert(
fn root_rel(root: &substrait::proto::PlanRel) -> Option<substrait::proto::Rel> {
///
            CachedFileList::new(object_metas.as_ref().clone()),
#[derive(Debug, Copy, Clone)]
            token.clone(),
        let has_views = Self::schema_has_views(&stream.schema());
            Some(ParquetAccessPlan::new_none(num_rgs))
    Ok(Box::into_raw(Box::new(shard_view)) as i64)
    );
        let access_plan = if let Some(bm) = per_segment.get(&seg_ord) {
        assert_eq!(compacted.num_rows(), 0);
            Self::collect_metrics(child.as_ref(), map);
/// Closes a native reader. Safe to call with 0 (no-op).
/// `register_partition_stream`.
        &columns
    for part in per_partition {
        fs::write(&sentinel, b"stale spill data").expect("seed sentinel");
    let shard_view = ShardView {
        // the boot thread (uniform across files, symlinks, dirs); phase 2 removes
            !view_needs_gc(
}
    // arrow_array::ffi::from_ffi takes ownership of the FFI structs (via FFI_ArrowArray
///     symlinks, and subdirectories alike) is renamed to a `<name>.stale`
                compact_string_view_columns(batch)
        .any(|w| w == INDEX_FILTER)
pub unsafe fn close_local_session(ptr: i64) {
    #[test]
/// Returns the current memory pool limit in bytes.
            outside.exists(),
        debug_assert!(gid >= 0, "fetch_by_row_ids: negative row id {}", gid);
        .iter()
    pub custom_cache_manager: Option<CustomCacheManager>,
        // synchronously; phase 2 unlinks it asynchronously. The original name
            eprintln!(
    fn conform_keeps_actual_field_when_list_child_nullability_differs() {
    let token = query_tracker::get_cancellation_token(context_id);
    let df_stream = session.execute_prepared()?;
        assert_eq!(out.schema().as_ref(), declared.as_ref());
                    i,
            Arc::clone(&actual_child),
        .map_err(|e| {
            seg.max_doc
                query_memory_pool,
        .build();
            } else {
                                    "Background spill cleanup: failed to stat {} (io kind={:?}): {}",
        // Set/get round-trips a value in range.
            .with_runtime_env(Arc::from(runtime_env))
        Self {
/// name. If the planner emitted any `index_filter(bytes)` UDF call, the name
                }
    use datafusion_substrait::extensions::Extensions;
/// `partition_count` buckets, using DataFusion's repartition seed
                phantom_corrector,
        let batch =
            DataType::List(expected_child),
    // cache, subsequent queries benefit).
    }
        query_tracker::QueryType::Coordinator,
    // expression. This preserves caller column order and guarantees a single __row_id__
        let ptr = create_global_runtime(64 * 1024 * 1024, 0, "", 0).expect("runtime build");
        let batch = RecordBatch::try_new(actual_schema, vec![Arc::new(list)]).unwrap();
    fn create_global_runtime_renames_orphan_subdirs_to_stale_then_async_removes() {
    let table = datafusion::catalog::streaming::StreamingTable::try_new(
            "fetch_by_row_ids: row id {} out of bounds for segment {} (base={}, max_doc={})",
                path: table_path.prefix().clone(),
    // Note: Java validates non-empty + ascending row_ids before the FFM call; we don't repeat that here.
        // implies the runtime would fail later mid-query anyway. Surface the failure
/// Build ObjectMeta for each file using the given object store.
    // internally — so the row-to-partition mapping matches what a downstream RepartitionExec
    Ok(Box::into_raw(Box::new(ffi_schema)) as i64)
        result.push(FileRowMetadata {
    filenames: Vec<String>,
            cpu_exec.clone(),
}
        let stale_loose = spill_path.join("stray.txt.stale");
/// (`REPARTITION_RANDOM_STATE`) so the assignment matches what `RepartitionExec` and
            // "RefCnt has gone negative".
///
/// Calcite *logical* names (`sum_qty`). Registering the streaming table with the raw IPC names
fn coerce_unsupported_timestamp_precision(
        let after_size = compacted.columns()[0].get_array_memory_size();
    }));
    /// (and a `Weak` can only be made from an `Arc`). This is the sole strong reference, so the
            task_done: None,
        let mut map = serde_json::Map::new();
    // conform_batch_to_schema. (A cast copies only the mismatched columns, ending
    // Align buffers — Java IPC produces 8-byte alignment but DataFusion's SIMD paths want
        || plan_bytes.windows(ROW_ID.len()).any(|w| w == ROW_ID)
    // now Rust's responsibility to drop.
                        pruning_metrics,
            FALLBACK
    Ok(())
//!   The bridge layer wraps with `block_on` or `spawn`.
        .collect();
            .collect();
                        e
//
    store_ptr: i64,
use arrow_schema::ffi::FFI_ArrowSchema;
    // monotonically nondecreasing across the entire stream. target_partitions=1
        return Err(DataFusionError::Execution(format!(
    // its per-query memory pool overlaying the global pool.
/// This sweeps `datafusion-*/` orphans left by a non-graceful shutdown
                full_array.data_buffers(),
    let session = &mut *(session_ptr as *mut LocalSession);
        "fetch_by_row_ids: build_segments returned empty for non-empty shard view"
            .downcast_ref::<StringViewArray>()
        assert_eq!(
        Some(RelType::Sort(s)) => {
        file_schema: resolved_schema,
pub unsafe fn execute_local_prepared_plan(
    schema_ipc: &[u8],
        );
        .fields()
    }
    let runtime = &*(ptr as *const DataFusionRuntime);
                .map(|(f, name)| {
            "ts",
/// are heap-allocated by Rust here; ownership transfers to Java on success.
    // or List state for sub-32-bit bitmap accumulators). Use Partial schema + Root.names so
/// # Safety
                                }
        assert_eq!(aligned_list.value_offsets().as_ptr(), original_offsets);
//!
pub fn get_reduce_target_partitions() -> usize {
            log::warn!(
    std::ptr::write(input_schema_ptr as *mut FFI_ArrowSchema, re_schema);
/// and a handle to change the memory pool limit at runtime.
    query_tracker::cancel_query(context_id);
///
    fn conform_batch_is_noop_when_schemas_match() {
        )]));
        // Originals were renamed inline — gone immediately by the original name.
        assert!(Arc::ptr_eq(out.column(0), &col));
        let sliced_view: &StringViewArray = sliced.as_any().downcast_ref().unwrap();
}
        object_metas.len(),
                    MetricValue::Ratio { .. }
        let declared_child = Arc::new(Field::new("item", DataType::Utf8View, false));
    if ptr != 0 {
pub async fn create_object_metas(
            .mode();
/// Caller must call `stream_close` exactly once to free it.
}
                            Ok(e) => e,
    for plan_rel in &plan.relations {
/// producer IPC header.
    // ── 3. Register ShardTableProvider ──
            "sentinel must exist before runtime build"
    // same zero sentinel used for EOF.
    writer_generations: Vec<i64>,
        // Mark spill explicitly disabled so per_query_spill_budget short-circuits
            "spill_limit must be non-negative, got {}",
    Ok(Box::into_raw(Box::new(session)) as i64)
        // Cleanup is two-phase: phase 1 renames every immediate child to *.stale on
) -> (Arc<DatafusionQueryConfig>, Option<Arc<PhantomCorrector>>) {
    // setup, etc. can all take non-trivial time on a wide reduce).
        let _ = ctx.register_table(&table_name, Arc::new(table));
pub async unsafe fn execute_local_plan(
            }
    if sender_ptr == 0 {
/// Sets the memory pool limit at runtime. Takes effect for new allocations only.
            runtime_env,
            ),
    // per-batch cast at feed time.
        let _guard = lock_process_globals();
                        prev, v, i
                        }
    /// Behind an `Arc` only so it can be published to the global registry, which stores a `Weak`
        let before_size = sliced.column(0).get_array_memory_size();
    #[test]
use crate::local_executor::LocalSession;
        assert_eq!(get_reduce_target_partitions(), 4);
                &shard_view.sort_orders,
        let meta = store.head(&path).await.map_err(|e| {
                context_id,
            fields.push(Arc::clone(want));
///
    }
    let handle = &mut *(stream_ptr as *mut QueryStreamHandle);
}
/// # Safety
            Field::new("a", DataType::Int64, false),
        unsafe { close_global_runtime(ptr) };
            object_meta: shard_view.object_metas[seg_ord].clone(),
/// Returns memory pool usage (bytes reserved) and tripped count as a pair.
            ),
        let mut array_data = arrow_array::ffi::from_ffi(ffi_array, &ffi_schema).map_err(|e| {
    // Same import-and-align pattern as register_memtable above. Java's ArrowStreamReader
    let schema = parquet_to_arrow_schema(
            if let Some(prev) = last_seen {
        // If phase 1 had followed the symlink during rename, or phase 2 followed
use datafusion::execution::cache::cache_manager::CacheManagerConfig;
        let ffi_schema = FFI_ArrowSchema::from_raw(schema_ptr as *mut FFI_ArrowSchema);
    // Otherwise use default LocalFileSystem.
 * compatible open source license.
    pub fn new_for_bench(runtime_env: Arc<datafusion::execution::runtime_env::RuntimeEnv>) -> Self {
        .unwrap();
        .map(|c| {
    }
    schema: &arrow::datatypes::Schema,
        let mut writer = StreamWriter::try_new(&mut buf, schema)
        let ptr = result.expect("runtime build must succeed when only the parent is read-only");
        mc_arc
    if sender_ptr != 0 {
pub unsafe fn register_memtable_on_session_context(
/// query-tracking context + cancellation token under `context_id` so the
    match result {
            arrow::compute::concat_batches(&schema, &part).map_err(|e| {
    // Adaptively reduces target_partitions if the phantom doesn't fit at full
/// `session_ptr` must be a valid, non-zero pointer returned by
    std::sync::atomic::AtomicUsize::new(4);
/// (memory pool, disk manager, and caches are shared).
}
        // instead of writing to an unintended path. Construction must also flip the
    let borrowed_batch = RecordBatch::from(struct_array);
    /// Fires when the spawned CPU task has fully dropped; `stream_close` waits on it so borrowed
/// Looks up the first file's ParquetMetaData from the file metadata cache.
        let cleaned = wait_until(2000, || !stale_top.exists() && !stale_dir.exists());
    Ok(schema_ipc)
    ///
        );
            mode: u32,
        );
        let col: arrow_array::ArrayRef = Arc::new(arrow_array::Int64Array::from(vec![10, 20]));
        .map_err(|e| {
    // fires once its batches drop) before returning, so the caller's allocator close is safe.
        };
    schema_ptr: i64,
/// channel binds the FINAL plan to the registered (logical) names and accepts the batches
                Field::new("s", DataType::Utf8, true),
    ) -> Self {
/// probe-side `BroadcastInjectionHandler` runs against the same `SessionContextHandle` that
        let _guard = lock_process_globals();
                    .downcast_ref()
    }
                            return;
    None
    // input_partition=0 / num_input_partitions=1 — we partition each batch independently here,
        Arc::clone(&shard_view.store),
    // Extract Arrow schema (zero I/O — just struct conversion)
        runtime,
        assert!(
        substrait
                e.name(),
            "partition_batch_by_hash: partition_count must be > 0, got {}",
                        let value = m.value().as_usize() as i64;
        assert!(top_file.exists());
/// `create_local_session`.
        fs::write(&top_file, b"top-level leak").expect("seed top file");
                            );
            .expect("child field name is not part of the buffer layout");
/// or cancelled.
        );
        //  Phase 2 (async, background thread): re-scan and remove every
    // than lingering in tokio's deferred drop queue on an idle runtime.
    let handle = &mut *(stream_ptr as *mut QueryStreamHandle);
        std::os::unix::fs::symlink(&outside, &link).expect("create symlink");
) -> Option<crate::query_budget::QueryMemoryBudget> {
        if schema.column_with_name(col).is_none() {
            let limit = (available as f64 * FRACTION) as u64;
    }
///
/// # Safety
///     are not touched.
            Ok(Box::into_raw(Box::new(ffi_array)) as i64)
    use super::*;
    let checked = stream.map(move |batch_res| {
                row_group_row_counts: fm.row_group_row_counts.clone(),
    let (dynamic_pool, dynamic_limit_handle) = DynamicLimitPool::new(memory_pool_limit as usize);
        map.insert(
/// returning a [`PartitionStreamSender`] pointer the caller drives to push batches in.
/// Enables `row_base` computation without re-reading parquet footers.
    let struct_array = StructArray::from(array_data);
/// the producer side, so no view-type or timestamp-precision rewrites are
/// - `array_ptr` must point to a populated `FFI_ArrowArray` struct owned by
            memory_pool_limit
    #[test]
                    spill_dir,
            1,
        );
    /// Walks the tree recursively, collecting metrics from every node.
        let declared: SchemaRef = Arc::new(Schema::new(vec![
    let result = cancellation::cancellable(
pub unsafe fn register_partition_stream_on_session_context_from_partial_plan(
        let batch = RecordBatch::try_new(
            },
        &schema,
            stream,
            spill_path.is_dir(),
        assert!(ptr > 0);
        }
                "Failed to register streaming table '{}' on session context: {}",
    // fails later with a schema/batch type mismatch. Cast ONLY those columns to
            .schema_force_view_types;
        );
        session.execute_substrait(substrait_bytes),
        // logs are diagnostic without needing further investigation.
        !segments.is_empty(),
        assert_eq!(aligned.schema(), expected_schema);
        datafusion::physical_plan::Partitioning::Hash(exprs, partition_count as usize);
// 10KB: below this, the gc() copy cost outweighs the transfer savings.
        crate::partition_stream::SingleReceiverPartition::new(receiver),
    }
        let tmp = tempfile::tempdir().expect("tempdir");
            columns.push(arrow_array::make_array(data));
/// <p>The coercer flips Arrow-only types (notably `UInt64` from DataFusion's
            Vec::new()
                let add = |map: &mut serde_json::Map<String, serde_json::Value>,
        // contents present at startup are leaked from a prior non-graceful shutdown.
    // reference (it is still dropped when `ffi_schema` goes out of scope).
    // A Java-supplied store (store_ptr > 0) is a remote/warm store: fetch the whole
    }
            if let Some(input) = e.input.as_ref() {
            seg.global_base,
        let (out_array, out_schema) = arrow_array::ffi::to_ffi(&combined_data).map_err(|e| {
            "error must include the io::ErrorKind for diagnosis; got: {}",
/// `index_filter` takes the indexed path and then fails in `execute_indexed_query`
    }
                    other => {
) -> Result<i64, DataFusionError> {
/// Creates a `LocalSession` bound to the given runtime's [`RuntimeEnv`]
    let runtime_env = build_query_runtime_env_with_store(
            "memory_pool_limit must be non-negative, got {}",
            .map(|i| format!("long_string_value_{:06}_padding", i))
            strings.iter().map(|s| s.as_str()),
                let entry = entry.map_err(|e| {
        .map(|(meta, fm)| {
    // FINAL substrait's Read.base_schema declares on the coordinator side.
    }
        let field_name = schema.field(col_idx).name().clone();
                }
/// Closes a DataFusion global runtime. Safe to call with 0 (no-op).
        assert_ne!(
                    .expect("column must be StringViewArray when schema declares Utf8View");
        Some(RelType::Set(s)) => {
//! Functions that accept `i64` pointer arguments require non-zero, valid pointers
    }
                .fields()
                    tokio::time::timeout(std::time::Duration::from_secs(30), rx).await
            row_group_row_counts: seg.row_groups.iter().map(|rg| rg.num_rows as u64).collect(),
        // on this throwaway session while the real data-node session lowers
/// # Safety
                schema.fields().len()
    use prost::Message;
/// this never touches the bounded channel — it cannot block/deadlock against a full channel + a
        let (_pool, handle) = DynamicLimitPool::new(0);
        shard_view.object_metas.as_ref(),
            .expect("aligned child remains Utf8View");
    permit: Option<tokio::sync::OwnedSemaphorePermit>,
}
    )?;
        let seg = &segments[seg_idx];
            let entries = fs::read_dir(&spill_path).map_err(|e| {
        }
        return Err(DataFusionError::Configuration(format!(
    /// When set, ShardTableProvider attaches it to the PartitionedFile so
/// - `schema_ptr` must point to a populated `FFI_ArrowSchema` struct owned
        let strings: Vec<String> = (0..1000)
        let spill_str = spill_path.to_str().expect("utf-8 path");
    let handle = QueryStreamHandle::new(stream, query_context, None);
    /// Skipped under EUID 0 — root has CAP_DAC_OVERRIDE (or the macOS equivalent)
    if let Some(rt) = cpu_rt_handle {
        //    deletion target.
        );
impl QueryStreamHandle {
            let ffi_array = FFI_ArrowArray::new(&array_data);
    };
        let top_file = tmp.path().join("top.tmp");
    }
            mode: original_parent_mode,
    cfg.target_partitions = disk_capped_partitions;
        } else {
            gid,
        declared.metadata().clone(),
    // batch per partition. (For our use case the partitioner emits at most one sub-batch
            })?;
                _ => false,
/// (kill -9, OOM-kill, container restart) which would otherwise accumulate
            // `transform_schema_to_view` only touches top-level fields, which left
                &shard_view.sort_fields,
}
/// (e.g. `sum_qty[sum]`). The worker FINAL fragment's `base_schema`, however, declares the
    })?;
        //
/// Returns the sender pointer; the caller frees it via [`crate::ffm::df_sender_close`].
        let stale_a = tmp.path().join("datafusion-aB3kF7.stale");
        } else {
    }
    use crate::query_executor::{store_url_from_table_path, wrap_stream_as_handle_with_plan};
            // reduce stage's Arrow C Data import then read the view child's buffers as
use crate::helper::{build_query_runtime_env_with_store, new_query_tracking_context};
            if let Some(input) = &p.input {
    // Pre-allocate the per-partition collectors. The partitioner's callback emits zero or
        let spill_path = tmp.path().to_str().expect("utf-8 path");
///
        .iter()
    })?;
        let aligned_list = aligned
            "spill root must remain a directory after cleanup"
            ])),
        assert!(
            false,
            continue;
            sort_orders.len()
    );
///
///
            false,
    let object_metas = tokio_rt_manager.io_runtime.block_on(create_object_metas(
) -> Result<crate::partition_stream::SendOutcome, DataFusionError> {
    .map_err(DataFusionError::Execution)?;
}
        assert_eq!(
#[cfg(test)]
    *out_ptr = runtime.runtime_env.memory_pool.reserved() as i64;
        );
        assert_eq!(ts.value(0), 1_000_000_001);
            before_size / after_size
            fields.push(Arc::clone(want));
        // mirrors the streaming sink path in attach_input_batch() above.
    // The producer may emit a string column as plain Utf8 where the declared
    // context so those operators can register with the reactor.
    let cache_mgr = runtime.custom_cache_manager.as_ref()?;
/// `shard_view_ptr` and `runtime_ptr` must be valid, non-zero pointers.
        Self {
    }
        );
        Some(RelType::Filter(f)) => {
    let token = query_tracker::get_cancellation_token(context_id);
fn resolve_effective_config(
        };
        Some(RelType::Join(j)) => {
                internal_search,
        let has_views = Self::schema_has_views(&stream.schema());
///
        context_id,
    let corrector = if let Some(budget) =
) -> Result<(), DataFusionError> {
        let ctx = datafusion::prelude::SessionContext::new_with_state(state);
    arrow::datatypes::Schema::new_with_metadata(fields, schema.metadata().clone())
                if name_str.ends_with(".stale") {
            // Re-scan inside the thread so we pick up entries from this boot
                        );
            "symlink target contents must be preserved verbatim"
/// `derive_schema_from_partial_plan` re-lowers the producer plan and returns its top
                cpu_executor,
/// identifier a plan would otherwise contain.
                        Ok(e) => e,
    /// Number of row groups in this file.
    // `Arc<dyn ObjectStore>` for the DataFusion APIs below.
/// `SingleReceiverPartition` + `StreamingTable` + `register_table` on the
    // shared QUERY_REGISTRY — parity with execute_query + execute_local_plan,
        assert!(ptr > 0);
    let shard_view = &*(shard_view_ptr as *const ShardView);
    let _guard = manager.io_runtime.enter();
        })?;
    // Re-export so the caller's Java-side close on the input wrappers still has a release
        }
        .zip(file_metadata.iter())
/// the FFI structs on success.
    config.options_mut().execution.target_partitions = 1;
            "values below 1 clamp up to 1"
    let array_data_result = arrow_array::ffi::from_ffi(ffi_array, &ffi_schema);
        let plan = ctx.sql(sql).await?.logical_plan().clone();
        // Seed leaked entries: a datafusion-* subtree (kill -9 leftover) and a loose file.
            !outer_subdir.exists(),
        Some(physical_plan),
            matches!(
        assert_eq!(before_size, after_size);
            DataType::Utf8View,
            .map_err(|e| DataFusionError::Execution(format!("StreamWriter::finish: {}", e)))?;
    // so a `cancel_query(context_id)` call fires the token here too.
/// Executes a Substrait plan against a `LocalSession` and returns a
    use substrait::proto::rel::RelType;
        set_reduce_target_partitions(8);
            .with_cache_manager(cache_manager_config)
pub async unsafe fn fetch_by_row_ids(
    }
            Field::new("int_col", DataType::Int64, false),
    }
    /// could escape the spill directory and delete files elsewhere.
// `execute_query` returns).
    has_views: bool,
            last_seen = Some(v);
                }
    /// no `index.sort.field` configured. Parallel to `sort_orders`.
/// Conforms a producer batch to the consumer-side `StreamingTable` schema.
    let sender = session.register_partition(input_id, schema)?;
                Arc::new(view.gc()) as Arc<dyn Array>
            declared.fields().len()
                                    fs::remove_dir_all(&path)
        per_partition[partition_idx].push(sub_batch);
            && declared_names.len() == partial_schema.fields().len()
                    MetricValue::PruningMetrics {
    }
        crate::memory_guard::mark_spill_disabled();
                // cleanup didn't finish — phase 2 below picks them up.
/// Resolve the dynamic spill limit based on available disk space.
        ));
                    | MetricValue::Gauge { .. }
        crate::substrait_consumer::from_substrait_plan(&session_state, &plan),
    /// Index sort directions per field — values: `"asc"` or `"desc"`.
        return Err(DataFusionError::Execution(
        assert!(!nested_file.exists(), "nested leaked file must be removed");
#[derive(Debug, Clone)]
        &schema,
        assert_eq!(
    fn view_needs_gc_detects_bloat() {
    ///   - Vanilla path: `ListingOptions.with_file_sort_order(...)` so DataFusion advertises
    schema_ptrs: &[i64],
                        );
        //    datafusion-XXXXXX/ that DataFusion provisions next is never a
        let Some(ReadType::NamedTable(nt)) = read.read_type.as_ref() else {
        assert!(
        let _guard = lock_process_globals();
/// Sets the minimum target_partitions floor for the adaptive budget system.
                collect_reads(input, out);
            crate::query_executor::query_runtime_env_builder(runtime, list_file_cache).build()?;
        fs::write(&loose_file, b"loose top-level file").expect("seed loose file");
/// stragglers are reaped on the next boot.
            let cast = arrow::compute::cast(col, want.data_type()).map_err(|e| {
    /// The physical plan may reference state (e.g. RuntimeEnv, caches) owned
    for col in columns {
            values,
            .with_config(SessionConfig::new())
            "background cleanup must remove both *.stale entries within 2s"
        }
                num_rows,
    runtime: &DataFusionRuntime,
    // each column verbatim except __row_id__, which we replace with the synthesized
    declared: &SchemaRef,
    /// these globals and produce flaky assertions.
            ])),
    }
    let ffi_schema = FFI_ArrowSchema::try_from(schema.as_ref())
        };
                DataFusionError::Execution(format!(
            "expected DiskManagerMode::Directories when spill_dir is set"
        // plan on the coordinator fails with "No table named '<index>'" — only
 */
        stream: RecordBatchStreamAdapter<CrossRtStream>,
    REDUCE_TARGET_PARTITIONS.load(std::sync::atomic::Ordering::Acquire)
                    }
                        .downcast_ref()
    }
        df_stream,
            let fields: Vec<Field> = coerced
        df_stream.schema().as_ref(),
        // any spill attempt surfaces the upstream "DiskManager is disabled" error
            let spill_path_for_gc = spill_path.clone();
        assert!(
            .map_err(|e| DataFusionError::Execution(format!("StreamWriter::try_new: {}", e)))?;
        assert!(
    ) {
///
/// mount point. Callers wanting auto-creation must grant write on the parent.
/// Safe today because `datafusion.spill_directory` is `NodeScope + Final`, so
        map: &mut serde_json::Map<String, serde_json::Value>,
                coerced.metadata().clone(),
        let substrait = to_substrait_plan(&plan, &ctx.state())?;
        .state()
// Substrait plan is executed against those inputs, and the output stream is
                     Renamed *.stale entries will accumulate until the next successful boot.",
///
            .unwrap();
        .with_default_features()
//! The FFM bridge (`ffm.rs`) calls into these functions directly.
        set_reduce_target_partitions(32);
            !link.exists(),
/// `isUtf8Family` so both sides agree on which divergence is safe to cast.
use crate::memory_guard::{per_query_spill_budget, SpillBudget};
pub unsafe fn register_memtable(
                    let _ = fs::set_permissions(self.path, perms);
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
            }
        let cleaned = wait_until(2000, || !leftover.exists());
    for wire in wire_slice {
    }
            "leaked file under leaked subdir must be removed"
        context_id,
        };
                                } else {
        let _guard = lock_process_globals();
    // the coordinator sees the correct wire type.
                DataFusionError::Execution(format!(
    }
            .columns()
        let col = batch.column(i);
        Self {
    table_name: &str,
            for entry in entries {
        let aligned = RecordBatch::try_new(Arc::clone(&table_schema), raw.columns().to_vec())
    partial_plan_bytes: &[u8],
        // (MULTI_VALUE_EXPAND_TYPE_URL) places its parquet ReadRel beneath an
    // ── 1. Build RuntimeEnv + SessionContext ──
        );
    /// When no store is provided, uses default LocalFileSystem.
            if predicate() {
        .runtime_env()
    task_done: Option<tokio::sync::oneshot::Receiver<()>>,
/// `FFI_ArrowArray` / `FFI_ArrowSchema` structs on success — the Java side
        let full_path = if filename.starts_with('/') || filename.contains(base_path) {
            "background cleanup must remove both .stale entries within 2s"
        // Spill root itself must remain (cleanup wipes children only).
) -> Result<RecordBatch, DataFusionError> {
                let name = entry.file_name();
                "Could not determine disk space for '{}', using fallback {}GB",
            writer_generations.len()
        crate::partition_stream::SingleReceiverPartition::new(receiver),
        assert_eq!(get_reduce_target_partitions(), 1);
    // DataFusion's execute_stream is sync, but kicks off RepartitionExec /
        // parquet-read leaf, so the synthetic leaf we register here matches.
        //    *.stale entry — `remove_file` for files and symlinks (so we
///
        }
                        add(
///
                let rg_bitmap: RoaringBitmap = bm
        let batches_in_pipeline = budget.target_partitions * 3 + 2; // partitions × multiplier + output channel(2)
        .await
            "partition_batch_by_hash: hash_key_indices must be non-empty".to_string(),
    if memory_pool_limit < 0 {
        return;
        } else if is_utf8_family(col.data_type()) && is_utf8_family(want.data_type()) {
use std::collections::HashMap;
/// `session_ptr` must be a valid, non-zero pointer returned by
        assert_eq!(
///
    pub access_plan: Option<datafusion::datasource::physical_plan::parquet::ParquetAccessPlan>,
/// # Ordering
}
        sort_orders,
/// (logical-named) output schema — matching what the FINAL binds — so registration carries the
            "sentinel original name must be gone (renamed)"
use datafusion::physical_plan::execute_stream;
}
/// later mid-query anyway. Phase 2 failures (including thread-spawn) are
    array_ptrs: &[i64],
            std::thread::sleep(std::time::Duration::from_millis(20));
///    `List<element>` (parquet) vs `List<item>` (Substrait) case.
/// query error. In practice this is unreachable because the needle is not a
        /* input_partition */ 0,
            &DataType::Timestamp(TimeUnit::Nanosecond, None)
}
    // Per-query memory tracking — wraps the session's global pool. A
 *
        assert!(
        .file_metadata
            path: parent.path(),
        );
    let schema = batch.schema();
            .as_ref()
        use arrow_schema::{Field, Schema, TimeUnit};
                })
    let query_future = async move {
/// teardown as [`sender_close`]). This is the truncation-safe terminal: a plain [`sender_close`]
//! - `create_global_runtime` / `close_global_runtime` are not thread-safe for the
        // them in a background thread (remove_file for files/symlinks, remove_dir_all
    Ok(Box::into_raw(Box::new(handle)) as i64)
        }
}
    fn conforms_list_child_name_to_declared_coordinator_schema() {
/// # Safety
        set_reduce_target_partitions(4);
                        "Failed to read spill directory entry in {} (io kind={:?}): {}",
                    MetricValue::StartTimestamp(_) => {
        object_metas: Arc::new(object_metas),
///   `create_session_context` / `create_session_context_indexed` / `create_worker_session_context`.
    // The token is held via the QueryStreamHandle's context and consulted by
                            pruning_metrics.matched() as i64,
///
                                serde_json::Value::Number(serde_json::Number::from(v)),
    /// Two consumers today:
        set_reduce_target_partitions(0);
/// `shard_view_ptr` and `runtime_ptr` must be valid, non-zero pointers.
///
        let table_name = nt.names.last().cloned().unwrap_or_default();
    let struct_array = StructArray::from(array_data);
            OffsetBuffer::new(vec![0_i32, 2].into()),
        }
    use crate::test_process_globals::lock as lock_process_globals;
    sort_orders: Vec<String>,
            .map_err(|e| {
    pub fn with_session_context(
    fn conform_batch_casts_only_string_view_leaving_timestamp_alone() {
            !leaked_dir.exists(),
/// batches (some may be zero-row) as parallel `(array_ptr, schema_ptr)` pairs the JVM
            // finish. Errors inside the thread are logged only — the cluster
            if let Some(left) = &j.left {
///   by the caller; ownership transfers to Rust on success.
            "register_memtable_on_session_context: array_ptrs.len()={} != schema_ptrs.len()={}",
        Some(RelType::ExtensionMulti(e)) => {
        )));
        );
        CrossRtStream::new_with_df_error_stream_cancellable(
    session_ctx_handle_ptr: i64,
        } else {
                           key: String,
        permit: Option<tokio::sync::OwnedSemaphorePermit>,
    }
        let col_idx = idx as usize;
    match crate::memory_guard::available_disk_space(spill_dir) {
        })
    /// `index.sort.field` setting on the Java side. Empty when the index has
) -> Result<Vec<(i64, i64)>, DataFusionError> {
        metas.push(meta);
    Ok(())
    /// `crate::test_process_globals::lock` rather than a lock of its own, because
    handle
/// `ptr` must be 0 or a valid pointer returned by `create_global_runtime`.
        }
                    | MetricValue::CurrentMemoryUsage(_) => {
        .collect()
    Ok(Box::into_raw(Box::new(handle)) as i64)
    for (i, want) in declared.fields().iter().enumerate() {
                .io_runtime
            );
    let timer = datafusion::physical_plan::metrics::Time::default();
            "negative values clamp up to 1"
    // the zero-copy borrow for those; conformant columns keep borrowing as above.)
    is_significantly_bloated && waste > GC_MIN_WASTE_BYTES
        let strings: Vec<&str> = (0..100).map(|_| "short").collect();
            );
            )
}
use std::path::PathBuf;
            expected.fields().len()
                arrow::datatypes::DataType::Binary | arrow::datatypes::DataType::List(_)
        Arc::clone(&table_schema),
        stream: RecordBatchStreamAdapter<CrossRtStream>,
                            format!("{}_pruned", name),
/// name has no `.stale` suffix, so phase 2 cannot collide with it.
    let consumer = DefaultSubstraitConsumer::new(&extensions, &session_state);
pub struct FileRowMetadata {
/// Registers a streaming input on the session under `input_id`. The schema is
                                    fs::remove_file(&path)
/// against the same schema the native session is registered with.
        let leaked_a = tmp.path().join("datafusion-aB3kF7");
/// Caller must call `close_global_runtime` exactly once to free it.
        use arrow_array::StringArray;
}
                            );
        plan: Arc<dyn datafusion::physical_plan::ExecutionPlan>,
                        e
                        .downcast_ref()
    #[test]
    if Arc::ptr_eq(&actual, expected) {
            // Apply pending phantom correction from the self-correcting budget.
    }
    fn stringview_gc_empty_array() {
        return Err(DataFusionError::Configuration(format!(
/// output in the same `CrossRtStream` + `RecordBatchStreamAdapter` + handle
                        let prev = map
        let link = spill_path.join("escape_link");
                Field::new("s", DataType::Utf8, true),
/// logged only; the cluster has either joined or is about to, and
        }
    // `cancellable_or` to a bare uncancellable await — the reduce sink's
        );
    ) -> Self {
    };
            "values above 32 clamp down to 32"
            let num_rows: u64 = fm.row_group_row_counts.iter().sum();
                    plan.set(rg.index, RowGroupAccess::Selection(selection));
/// # Safety
/// `CrossRtStream` + `RecordBatchStreamAdapter` shape as `execute_query`,
        exprs.push(Arc::new(
fn compact_string_view_columns(batch: RecordBatch) -> RecordBatch {
        current_phantom,
        let declared: SchemaRef = Arc::new(Schema::new(vec![
    });
        .iter()
                        let path = entry.path();
                col_idx,
            "background cleanup must remove both .stale entries within 2s"
        let compacted = compact_string_view_columns(sliced);
    RecordBatch::try_new(schema, columns).expect("gc'd columns must match schema")
pub fn create_reader(
        })?;
            if let Some(input) = &f.input {
            .fields()
        let arrow_schema = coerce_unsupported_timestamp_precision(&arrow_schema);
    Ok(sender.send_blocking(Ok(batch), io_handle))
    let bytes_allocated: usize = buffers.iter().map(|b| b.len()).sum();
                        }
}
    pub num_row_groups: i32,
        // Register spill directory for per-query disk pressure checks
            .collect();
    table_name: &str,
                        let name = entry.file_name();
    }
        let batch = RecordBatch::try_new(
        let stale_link = spill_path.join("escape_link.stale");
    )
            Arc::clone(&schema),
    let cpu_exec = manager.cpu_executor();
/// Anything else (e.g. timestamp precision) keeps its actual field and column so this
use arrow_array::{Array, StructArray};
                        let name = m.value().name().to_string();
            if let Some(substrait::proto::plan_rel::RelType::Root(rr)) = pr.rel_type.as_ref() {
            get_reduce_target_partitions(),
    let context_id = handle._query_tracking_context.context_id();
            }
                    );
                plan_bytes.to_vec(),
        );
        Ok(batch)
        .unwrap();
                    "stream_close: timed out after 30s waiting for the reduce CPU task to release \
    store: &dyn object_store::ObjectStore,
    crate::cache::register_global_runtime_env(&runtime.runtime_env);
use roaring::RoaringBitmap;
        assert!(
            "background cleanup must remove the .stale sentinel within 2s"
    partial_plan_bytes: &[u8],
        let tmp = tempfile::tempdir().expect("tempdir");
        ));
        let corrector = Arc::new(PhantomCorrector::new_from_metadata(
        // Critical: the target outside spill must be intact across both phases.
///
    }
        let runtime = unsafe { &*(ptr as *const DataFusionRuntime) };
///
    crate::query_budget::acquire_budget_from_metadata(
    base_path: &str,
    /// Writer generation per file, parallel to `object_metas`. Sourced from the Java-side
        let arrow_schema = if view_types {
    fn conform_batch_passes_through_timestamp_precision_divergence() {
    let mut per_partition: Vec<Vec<RecordBatch>> = (0..partition_count as usize)
            Field::new("ts", DataType::Timestamp(TimeUnit::Millisecond, None), true),
        None => Ok(0),
    if let Some(rt) = cpu_exec.handle() {
                DataFusionError::Configuration(msg)
/// Closes a partition stream sender. Dropping the sender closes the mpsc,
        // at a regular file: spill_path.exists() returns true, but read_dir refuses
        let euid = unsafe { libc::geteuid() };
    hash_key_indices: &[i32],
        // accidental fs::remove_dir_all("") would error and break boot. This test
            DataType::Timestamp(TimeUnit::Second, tz) => Field::new(
    // shared Arc'd memory; from_ffi's ArrayData copy is a refcount-clone, not a deep copy.
                                continue;
///     (which unlinks the symlink itself without following it); directories
            before_size > after_size * 100,
            "fetch_by_row_ids: result schema missing {}, got {:?}",
    .ok()
    // Catches drift if SQL synthesis or the optimizer ever drops a projection silently.
    let session = &*(session_ptr as *const LocalSession);
    if let Some(rt) = cpu_exec.handle() {
            compacted.columns()[0].get_array_memory_size()
        // String column conformed to the declared view type.
    let handle = &*(session_ctx_handle_ptr as *const crate::session_context::SessionContextHandle);
    shard_view_ptr: i64,
            "background cleanup must remove escape_link.stale within 2s"
    }
        let stale_dir = tmp.path().join("subdir.stale");
) -> Result<(i64, Vec<u8>), DataFusionError> {
    let task_done = handle.task_done.take();
/// parent `AnalyticsQueryTask` cancel propagates here, and wraps the native
    /// Released on drop, which frees partition budget for other queries.
                collect_reads(input, out);
/// The spill directory itself is preserved. It may be a pre-existing mount
/// FFM wire format for per-file metadata.
                i,
        let sentinel = tmp.path().join("leaked_from_prior_run.tmp");
            } else {
        );
            )
        schema
    input_schema_ptr: i64,
//! - `execute_query`: async. Safe to call concurrently with different shard/runtime pointers.
/// the build-side capture sink emits a header-only IPC stream that already carries the
                let rg_end = rg_start + rg.num_rows as u32;
