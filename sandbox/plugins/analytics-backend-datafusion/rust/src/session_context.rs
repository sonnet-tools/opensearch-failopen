        ctx,
pub async fn prepare_partial_plan(
    execution::cache::cache_manager::CachedFileList,
        table_name: String::new(),
        phantom_reservation: None,
        indexed_config: None,
        substrait.encode(&mut buf).expect("encode");
        let fetch_rel = Box::new(Rel {
                sorts: vec![],
    shard_view: &ShardView,
fn substrait_has_fetch_rel(plan_bytes: &[u8]) -> bool {
    let parquet_meta = cached_parquet.parquet_metadata();
            to_substrait_plan(&df.logical_plan().clone(), &ctx.state()).expect("to_substrait");
        use datafusion::execution::object_store::{
        )
        sort_orders: Vec::new(),
            Field::new("b", DataType::Utf8, true),
    // Disable DataFusion's adaptive skip-partial-aggregation when TopK is active.
        let bytes = plan.encode_to_vec();
        let ctx = SessionContext::new();
    // This is the instruction-based execution path (ShardScanInstructionHandler).
    use crate::agg_mode::Mode;
        assert!(
        shard_view.sort_fields.len()
        .schema_force_view_types;
    // Augment with indexed config. The delegation marker UDFs (index_filter, delegation_possible)
    // Empty shard: loop is a no-op; infer_schema is also skipped below.
        shard_view_ptr,
    // `target_partitions` on the listing options drives the sort-aware bin-packer in
    pub(crate) prepared_plan: Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
            object_metas: Arc::new(vec![]),
    if !shard_view.sort_fields.is_empty() {
    let have: std::collections::HashSet<&str> = inferred
            schema: SchemaRef,
        error!(
            })?;
    /// excluded via the ordinary Lucene collector machinery. Sourced from the Java per-shard
    // expects (multi-index unions, or single-index cross-shard drift). No-op when the shard
                rel_type: Some(plan_rel::RelType::Rel(*fetch_rel)),
        listing_options
            has_topk: false,
                );
    context_id: i64,
            vec![Arc::new(Int64Array::from(vec![1i64]))],
    let expected = crate::schema_coerce::coerce_inferred_schema(Arc::new(expected));
        sort_fields: Vec::new(),
/// - Nulls placement mirrors Lucene's general default (ASC → NULLS FIRST,
    /// ObjectStoreRegistry. Two queries registering different stores under the bare `file://`
    let provider = Arc::new(
        use datafusion::parquet::arrow::ArrowWriter;
            let nulls_first = ascending;
    let sort_exprs: Vec<SortExpr> = sort_fields
/// for use during execution.
        // 1. NARROW read first: registers the table at the narrow (1-col) schema and, with
        let ctx = SessionContext::new();
        let plan = to_substrait_plan(&logical, &ctx.state()).expect("substrait plan");
                expression: None,
        .map(|p| p as Arc<dyn MemoryPool>);
            }))),
    plan.relations.iter().any(|pr| match pr.rel_type.as_ref() {
/// would be misread by new data nodes). The Substrait plan bytes are already part of
                .with_cache(Some(stats_cache)),
        .with_runtime_env(Arc::from(runtime_env))
                .options_mut()
            .with_schema(Arc::clone(&narrow));
    /// (the removed `first_named_table_name` approach) would pick the wrong name — and asserts
        .memory_pool()
            "subset gate must short-circuit to inferred"
    if base_schema.names.iter().all(|n| have.contains(n.as_str())) {
    pub ctx: SessionContext,
        aggregate_mode: crate::agg_mode::Mode::Default,
        ctx,
    has_partial_aggregate: bool,
        crate::agg_mode::Mode::Partial,
            datafusion::physical_optimizer::optimizer::PhysicalOptimizer::new().rules
    if plan_bytes.is_empty() {
            .into_unoptimized_plan();
        },
    fn test_substrait_has_fetch_rel_join_returns_false() {
            Some(RelType::Aggregate(a)) => a.input.as_ref().map_or(false, |r| rel_has_fetch(r)),
    let plan: substrait::proto::Plan = match prost::Message::decode(plan_bytes) {
}
    /// nullable so the consumer can bind. (Downstream, the field-count delta — 0 vs N — also
            .with_collect_stat(false); // mirrors the fix in create_session_context for widened tables
/// Caller contract: `sort_fields.len() == sort_orders.len()`. The Java side
 * this file be licensed under the Apache-2.0 license or a
        })?;
            .object_store_registry
            .await
        runtime_ptr,
    }
    }
            1.0,
            vec![Arc::new(Int64Array::from(vec![1i64]))],
    datasource::listing::{ListingOptions, ListingTable, ListingTableConfig, ListingTableUrl},
    // SortMergeJoinExec instead of the non-spillable HashJoinExec build.
        phantom_reservation: phantom,
    // variants including decimals, nested structs, user-defined types). All fields are
    use datafusion_substrait::logical_plan::consumer::{
    query_config: DatafusionQueryConfig,
    // If DF abandons partial agg midstream, the partial state sent to the coordinator is
            ListingTable::try_new(narrow_cfg)
    let query_memory_pool = query_context
        .expect("batch");
        e
        };
/// on the handle for later execution.
///
///   DataFusion's per-file chain validator to reject the ordering and fall back
    );
        )
    config: &DatafusionQueryConfig,
            .await
}
            .with_collect_stat(true);
        write_parquet(
    /// `resolve_register_name` still returns the logical table name. A future upstream merge that
    let force_view = ctx
    /// plan's base_schema still names columns. widen_schema_from_plan must append all of them as
        let config = SessionConfig::new();
        ]));
///
            .expect("per-query runtime env a");
    crate::schema_coerce::append_missing_nullable(inferred, &expected)
    let placeholder_path = ListingTableUrl::parse("file:///").map_err(|e| {
        assert!(
    let shard_view = &*(shard_view_ptr as *const ShardView);
        assert!(
        let query_context =
    // Install the scoped page-index reader factory on every parquet scan.
            relations: vec![PlanRel {
///
        );
                register_name, e
/// shard-scan instruction node (see `ShardScanWithDelegationHandler`).
            result.fields().len(),
    // (spillable) SortExecs the SMJ needs.
        let rows = ctx
/// This is metadata, not a sort: it tells DataFusion the parquet files are already
            .get_store(&file_url)
            .with_physical_optimizer_rules(
    )
/// captured from the plan's table-scan leaf and ships explicitly as `logicalTableName` on the
                advanced_extension: None,
        "create_session_context: successfully registered table '{}', table_name_len={}",
        // One file with the narrow schema (column "a" only), one with the widened schema (a + b).
            query_context,
    #[test]
            DefaultObjectStoreRegistry, ObjectStoreRegistry,
    crate::udf::register_all(&ctx);
            state_builder.with_physical_optimizer_rule(Arc::new(ScopedPageIndexOptimizer::new(
    runtime_ptr: i64,
        // Two per-query runtime envs, each derived the way create_session_context derives them:
        None => false,
    /// Aggregate execution mode for distributed partial/final stripping.
        .unwrap_or(query_config.batch_size);
        let table =
            Arc::ptr_eq(&got_a, &store_a),
/// lengths agree.
        &schema,
            .get_store(&file_url)
    pub(crate) aggregate_mode: crate::agg_mode::Mode,
        );
    let cached_parquet = cached
        e
    // the indexed path additionally UNWRAPS them before execution.
                }))),
        let narrow_tbl = Arc::new(
    async fn register_name_uses_logical_table_not_plan_placeholder() {
            Arc::clone(&registered_schema),
            name: &str,
    let state = ctx.state();
        .map(|b| b.target_partitions)
    handle.prepared_plan = Some(stripped);
    let runtime_env = runtime_env_builder.build().map_err(|e| {
            Arc::ptr_eq(&result, &inferred),
        config
        // The plan names a STAGE PLACEHOLDER, not the shard's real index.
    execution::memory_pool::MemoryPool,
        );
    /// scheme must not clobber each other — the bug that routed one shard's parquet read through
            Some(other) => {
            query_config: crate::datafusion_query_config::DatafusionQueryConfig::test_default(),
                .unwrap()
            sort_fields: vec![],
    // hash table, it sets prefer_hash_join=false so DataFusion's physical planner emits a spillable
    ctx: &SessionContext,
        use substrait::proto::expression::literal::LiteralType;
    );
            vec![Arc::new(Int64Array::from(vec![1i64]))],
    inferred: &arrow::datatypes::SchemaRef,
    crate::udaf::register_all(&ctx);
        datafusion::common::DataFusionError::Execution(format!(
            .options_mut()
    if sort_fields.is_empty() {
        sort_orders: shard_view.sort_orders.clone(),
        crate::query_executor::query_runtime_env_builder(runtime, list_file_cache);
    substrait_bytes: &[u8],
    Ok(Box::into_raw(Box::new(handle)) as i64)
    /// Java-side catalog snapshot via `create_reader`. Authoritative for stamping
        .expect("register");
    let expected = df_schema.as_arrow().clone();
            .with_object_store_registry(Arc::new(DefaultObjectStoreRegistry::new()))
                );
    // Widen to the plan's base_schema if this shard's parquet is missing columns the plan
/// The OpenSearch writer enforces this sort per segment, so the claim is
/// Substrait scan with an explicit flag passed through the instruction pipeline.
    fn test_substrait_has_fetch_rel_empty() {
use log::error;
                error!("create_session_context: failed to infer schema: {}", e);
    } else {
        prepare_partial_plan(&mut handle, &substrait_bytes)
            .await
        let mut buf = Vec::new();
    pool: &Arc<dyn MemoryPool>,
        ListingTable::try_new(table_config)
            .with_object_store_registry(Arc::new(DefaultObjectStoreRegistry::new()))
    table_name: &str,
        query_context,
                advanced_extension: None,
    let runtime_env = runtime_env_builder.build().map_err(|e| {
///
    let query_context = QueryTrackingContext::new(
    };
    })?;
            .build()
            ListingOptions, ListingTable, ListingTableConfig, ListingTableUrl,
    ctx.register_table(register_name.as_str(), provider)
    error!(
            }
        global_pool.clone(),
        assert_eq!(
        let wide: SchemaRef = Arc::new(Schema::new(vec![
    /// QTF query phase: scan must emit shard-global `__row_id__`.
    let target_schema = crate::schema_coerce::coerce_inferred_schema(stripped.schema());
        let got_a = env_a
            .build()
            .with_listing_options(narrow_opts)
/// state — no throwaway SessionState needed.
        let batch = RecordBatch::try_new(
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
    }
            ..Default::default()
            .expect("env_b must resolve a file:// store");
    // Also, this SHOULD be the last optimizer to see all projections / predicates
    // (single-index) scans keep full stats.
    // failing with "Cannot merge statistics with different number of columns". Non-widened
                offset_mode: None,
/// SessionContextHandle struct stays uniform with the shard-mode variant.
            }],
    // Acquire memory budget from cached parquet metadata (zero I/O).
        return Arc::clone(inferred);
        assert!(
    );
    let handle = &mut *(ptr as *mut SessionContextHandle);
    .map(Arc::new)?;
            e
        Ok(p) => p,
            .expect("shared runtime env");
        state_builder =
            .with_file_extension(".parquet")
            relations: vec![PlanRel {
/// # Safety
///
                rel_type: Some(plan_rel::RelType::Rel(*fetch_rel)),
/// `sort_fields` slice is empty), so the caller can skip
            vec![Arc::new(Int64Array::from(vec![1i64, 2, 3]))],
    /// `SegmentFileInfo.writer_generation`; footer-kv reads are debug-only assertions.
                .skip_partial_aggregation_probe_ratio_threshold,
/// `crate::api::first_named_table_name` approach upstream's #21822 originally used) is unreliable:
            writer.close().unwrap();
    context_id: i64,
    Some(sort_exprs)
                Arc::clone(&shard_view.store),
        ) {
            )
            "narrow.parquet",
/// Sort+Limit — TopK is active. Used in `create_session_context` to detect TopK before
        // And for single-index queries with empty plan bytes, the logical name is used directly.
            "input-7",
        let bytes = plan.encode_to_vec();
    );
            rr.input.as_ref().map_or(false, |r| rel_has_fetch(r))
                .execution
        assert!(handle.prepared_plan.is_some());
        let batch = RecordBatch::try_new(
        // When has_topk=false, skip_partial retains DF default (0.8) — no perf regression
        );
        )
    }
            .build();
                .with_cache(Some(stats_cache.clone())),
    }
            rel_type: Some(RelType::Fetch(Box::new(FetchRel {
    deleted_doc_filtering_required: bool,
    Ok(Box::into_raw(Box::new(handle)) as i64)
///
                Arc::new(StringArray::from(vec!["x"])),
        let _ = ctx
    );
        let plan = Plan {
    /// another shard's store and failed with "No such file or directory".
            rel_type: Some(RelType::Sort(Box::new(SortRel {
        assert!(!substrait_has_fetch_rel(&[]), "empty bytes → false");
}
    }
    list_file_cache.put(
        .iter()
    /// number of columns". The runtime-global file statistics cache is keyed by path+size+mtime
    let physical_plan = dataframe.create_physical_plan().await?;
    pub indexed_config: Option<IndexedExecutionConfig>,
/// covers every column.
            "SortRel without FetchRel → false"
        .unwrap_or(query_config.target_partitions);
        context_id,
    #[test]
/// in this order so `output_ordering` propagates through the scan,
    let ctx = SessionContext::new_with_state(state);
    deleted_doc_filtering_required: bool,
            Arc::ptr_eq(&got_b, &store_b),
/// (`DataFusionPlugin.createReaderManager`) guarantees this — `IndexSortConfig`
    // path (not schema), so a narrow cached Statistics can be merged against the widened one,
        let (mut handle, substrait_bytes) = make_test_handle().await;
            ListingTableUrl::parse(format!("file://{}", dir.path().to_str().unwrap())).unwrap();
        use prost::Message;
        let df = ctx.sql("SELECT x FROM \"input-7\"").await.expect("sql");
    let listing_options = if resolved_schema.fields().len() != inferred_field_count {
        .as_ref()
        listing_options.with_collect_stat(false)
        crate::query_tracker::QueryType::Shard,
        assert!(substrait_has_fetch_rel(&bytes), "FetchRel(count=10) → true");
/// table is registered with every column the Substrait consumer expects. Returns `inferred`
        //    collect_stat(true), seeds the shared cache with a 1-column Statistics for narrow.parquet.
        let schema = Arc::new(Schema::new(vec![Field::new("x", DataType::Int64, true)]));
    let stats_cache = runtime.runtime_env.cache_manager.get_file_statistic_cache();
                crate::agg_mode::physical_optimizer_rules_without_combine(),
    }
            .split_file_groups_by_statistics = true;
        .expect("batch");
        error!("create_session_context: failed to build runtime env: {}", e);
        let sort_rel = Box::new(Rel {
    pub delegated_predicate_count: i32,
    config.options_mut().execution.parquet.pushdown_filters =
    {
    // infer_schema calls DFParquetMetadata::fetch_metadata with PageIndexPolicy::Optional
        );
        let env_b = RuntimeEnvBuilder::from_runtime_env(&shared)
    let state = SessionStateBuilder::new()
            .with_schema(Arc::clone(&wide));
        plan_bytes,
    }
            io_handle: tokio::runtime::Handle::current(),
        };
    let list_file_cache = Arc::new(DefaultListFilesCache::default());
    use datafusion::execution::runtime_env::RuntimeEnvBuilder;
        table_path: placeholder_path,
    }
    use substrait::proto::Plan;
            "env_a must resolve to its own store"
                .options()
        return Arc::clone(inferred);
    let stripped = crate::relabel_exec::wrap_if_relabel_needed(stripped, target_schema)?;
    config.options_mut().execution.target_partitions = effective_partitions;
        )
        io_handle: tokio::runtime::Handle::current(),
        let result = widen_schema_from_plan(&ctx, &plan_bytes, "t", &inferred);
            .with_default_features()
        };
            path: shard_view.table_path.prefix().clone(),
        // DataFusion rewrites top-level strings to view types but not LIST children. Apply the
            e
        writer_generations: Arc::new(Vec::new()),
/// This detection avoids adding a new boolean field to the Java→Rust FFI surface
        let batch = RecordBatch::try_new(
            .skip_partial_aggregation_probe_ratio_threshold = 1.0;
    /// placeholder (`input-7`) — the exact case where reverse-engineering the name from plan bytes
                input: None,
        // Build a substrait plan with a Read rel pointing at "t" — base_schema.names = ["a"].
    sort_orders: &[String],
    }
mod tests {
        let env_a = RuntimeEnvBuilder::from_runtime_env(&shared)
        let handle = SessionContextHandle {
    /// Empty when the index has no `index.sort.field`. Consumed by the vanilla path
            Field::new("b", DataType::Utf8, true),
            relations: vec![PlanRel {
        Err(_) => return Arc::clone(inferred),
            writer_generations: Arc::new(vec![]),
    let first_meta = shard_view.object_metas.first()?;
/// `ptr` must be 0 or a valid pointer returned by `create_session_context`.
    pub table_path: ListingTableUrl,
        .options()
        let mut plan_bytes = Vec::new();
    let effective_batch_size = phantom_reservation
    /// WIDENED read; merging the cached narrow stats against freshly-computed widened stats blows
            dir.path(),
    #[test]
    };
}
            ctx,
            let mut writer = ArrowWriter::try_new(file, schema, None).unwrap();
        );
        listing_options = listing_options.with_file_sort_order(vec![sort_exprs]);
            sort_orders: vec![],
            )
/// Attempt to acquire a memory budget using cached parquet metadata.
                    rex_type: Some(RexType::Literal(Literal {
        ctx.register_table("t_narrow", narrow_tbl).unwrap();
    handle.indexed_config = Some(IndexedExecutionConfig {
        .with_target_partitions(effective_partitions);
    use std::sync::Arc;
    // function name" because df_execute_with_context reuses this handle's ctx instead
        );
    table_name.to_string()
        let plan = Plan {
        .map(|b| b.batch_size)
    // Register default ListingTable for parquet scans.
    #[tokio::test]
            ..Default::default()
            Field::new("a", DataType::Int64, true),
        // Build: FetchRel(count=10) wrapping SortRel — same as what DataFusion Substrait
    execution::SessionStateBuilder,
        let file_url = Url::parse("file://").unwrap();
        fn write_parquet(
        error!(
        deleted_doc_filtering_required,
        // for non-TopK multi-shard queries.
    use super::*;
    // When the coordinator estimates this worker join's build side is too large for an in-memory
                right: None,
        .with_config(config)
        let mut config = SessionConfig::new();
            }))),
    plan_bytes: &[u8],
) -> Result<i64, DataFusionError> {
use crate::datafusion_query_config::DatafusionQueryConfig;
    crate::query_budget::acquire_budget_from_metadata(
    // On cache miss (first query for this shard), skip — subsequent queries benefit.
    let extensions = Extensions::default();
        .parquet
    if ptr != 0 {
        let widened_tbl = Arc::new(
        let store_b: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
        e
        prepared_plan: None,
        assert!(
                common: None,
    use datafusion_substrait::logical_plan::producer::to_substrait_plan;
        let dir = tempfile::tempdir().unwrap();
    }
        // skip_partial must be disabled (1.0) when TopK is active — if DF abandons partial
            let _ = crate::indexed_table::parquet_bridge::load_parquet_metadata_with_meta(
        let sort_rel = Box::new(Rel {
    let cached = cache.get(&first_meta.location)?;
        let result = widen_schema_from_plan(&ctx, &[], "t", &schema);
    let consumer = DefaultSubstraitConsumer::new(&extensions, &state);
    // `split_groups_by_statistics_with_target_partitions`. We set it to the session's
            .execution
                left: None,
    async fn test_widen_schema_noop_when_plan_empty() {
    let mut runtime_env_builder =
                false
pub(crate) fn widen_schema_from_plan(
            .expect("env_a must resolve a file:// store");
        // Each query registers its own shard store under the same bare file:// scheme.
    } else {
fn try_acquire_budget(
        .with_listing_options(listing_options)
                .execution
    } else {
        deleted_doc_filtering_required: false,
/// `plan_bytes` is intentionally IGNORED. Reverse-engineering the name from the plan (the removed
            !substrait_has_fetch_rel(&bytes),
    #[test]
        // Must return inferred unchanged (Arc::clone, so pointer-equal).
                .options()
    #[tokio::test]
    pub object_metas: Arc<Vec<ObjectMeta>>,
/// Uses the `datafusion-substrait` consumer's `from_substrait_named_struct` for type conversion
/// Widens `inferred` to the plan's `base_schema` (for index-pattern / alias scans) so the
    let stripped = crate::agg_mode::apply_aggregate_mode(
    // Pre-widening field count — compared below to detect whether widening added columns.
        .build();
            .unwrap();
            .sql("SELECT a FROM t")
                count_mode: Some(fetch_rel::CountMode::CountExpr(Box::new(Expression {
        .as_ref()
        crate::schema_coerce::transform_schema_to_view_recursive(&expected)
        });
    config.options_mut().execution.batch_size = effective_batch_size;
    let mut runtime_env_builder = RuntimeEnvBuilder::from_runtime_env(&runtime.runtime_env);
        let mut plan_bytes = Vec::new();
    use substrait::proto::rel::RelType;
        query_config,
    // can apply PartialReduce without re-scanning the physical plan.
/// function is only called for multi-shard partial-aggregate fragments.
                "create_session_context: failed to register table '{}': {}",
        use datafusion::execution::cache::file_statistics_cache::DefaultFileStatisticsCache;
    };
/// `with_file_sort_order(...)` entirely.
        sort_fields: shard_view.sort_fields.clone(),
            config
    // output (state-suffixed Binary for HLL Partial vs. Int64 cardinality for Final.evaluate)
 *
        // Build Substrait bytes for SELECT SUM(x) FROM t
        );
        use prost::Message;
    context_id: i64,
                common: None,
            config
        );
/// reused in `prepare_partial_plan` without re-scanning the physical plan.
    /// True when the shard Substrait fragment contains a FetchRel (Sort+Limit = TopK).
    /// When true, the shard has deleted docs: the indexed executor ANDs a synthetic match-all
use object_store::ObjectMeta;
        (handle, buf)
    log_debug!(
        tree_shape,
                &meta.location,
                        nullable: false,
        config.target_partitions,
    // Pre-warm the metadata cache footer-only before infer_schema fires.
            "non-TopK queries must retain DF default threshold"
        // from the shared env but with a fresh object-store registry.
    };
    /// Parallel to `sort_fields`. Each entry is `"asc"` or `"desc"` (lowercase).
}
        &url::Url::parse("file://").unwrap(),
            .with_runtime_env(Arc::new(runtime_env))
            "create_worker_session_context: failed to build runtime env: {}",
///   normalization (`col("EventTime")` → `"eventtime"`), which silently fails
    let inferred_field_count = inferred.fields().len();
            !Arc::ptr_eq(&got_a, &got_b),
        Some(substrait::proto::plan_rel::RelType::Rel(r)) => rel_has_fetch(r),
/// (which would break wire compatibility with older nodes during rolling upgrades —
    let plan = Plan::decode(substrait_bytes).map_err(|e| {
    }
    }
                common: None,
    // are now registered for every session by udf::register_all (via create_session_context above);
    /// When set, indicates this session uses the indexed execution path with filter delegation.
    /// plan's first `NamedTable` happens to be. Builds a plan whose only `NamedTable` is a stage
        let plan = df.logical_plan().clone();
        "create_session_context: registered table '{}' with file_sort_order_keys={}",
        use object_store::memory::InMemory;
///
    delegated_predicate_count: i32,
            }],
//! SessionContext lifecycle for instruction-based execution.
/// Notes for readers:
        let stats_cache = Arc::new(DefaultFileStatisticsCache::default());
            phantom_reservation: None,
        .map(|(name, order)| {
    /// union) table schema must not fail planning with "Cannot merge statistics with different
        let _ = Box::from_raw(ptr as *mut SessionContextHandle);
                offset_mode: None,
    let handle = SessionContextHandle {
    // their function names. Without this, fragment execution fails with "Unsupported
    let table_config = ListingTableConfig::new(shard_view.table_path.clone())
        .memory_pool()
    /// up. We avoid this by disabling stat collection when widening changed the schema; this test
        // Each env resolves to its OWN store, and the two are independent: registering in one env
///
    let ptr = create_session_context(
        let inferred = crate::schema_coerce::transform_schema_to_view_recursive(inferred.as_ref());
        let store_a: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
        .with_file_extension(".parquet")
            let f = result.field_with_name(name).expect("column present");
        let result = widen_schema_from_plan(&ctx, &plan_bytes, "t", &inferred);
    pub(crate) has_topk: bool,
}
                post_join_filter: None,
            })?
        substrait.encode(&mut plan_bytes).expect("encode");
    /// A Join rel at the root — exercises the `Some(other)` arm that logs and returns false.
    // — otherwise RelabelExec would carry the pre-strip type tag (e.g. Int64) and fail with
            Arc::clone(&schema),
        );
            MemTable::try_new(Arc::clone(&registered_schema), vec![vec![]]).expect("memtable");
    pub requests_row_ids: bool,
    use datafusion::execution::cache::CacheAccessor;
    // below populates columns from the substrait base_schema.
        .with_runtime_env(Arc::from(runtime_env))
        use substrait::proto::rel::RelType;
        use substrait::proto::expression::{Literal, RexType};
) -> Result<i64, DataFusionError> {
/// (which already marks all fields nullable). The consumer is built from the session's existing
    // resolve_register_name for why we do NOT reverse-engineer this from the plan bytes. The
    /// Pre-prepared physical plan (set by prepare_partial_plan / prepare_final_plan).
/// Single-shard (SINGLE aggregate mode) never has `has_partial_aggregate=true` so this
    }
    // fragment means OpenSearchTopKRewriter fired. Stored on the handle so prepare_partial_plan
    let mut listing_options = ListingOptions::new(Arc::new(ParquetFormat::default()))
    // If widening added columns, disable stat collection: the global stats cache is keyed by
    #[test]
    // file-group partitioner so `output_ordering` can propagate from the scan.
            );
            !substrait_has_fetch_rel(&bytes),
    use datafusion::datasource::MemTable;
        assert!(
        .collect();
/// the existing wire contract and do not change format.
    };
/// backward-compatible flag delivery path that does not exist today.
        Ok(s) => s,
    // on a cache miss — fetching full page index bytes. By pre-warming here with
    datasource::file_format::parquet::ParquetFormat,
/// validates size match at index creation, so by the time we get here the
                Arc::clone(&metadata_cache),
            !substrait_has_fetch_rel(&bytes),
    // a cache hit and never touches the page index bytes.
        // does not leak into the other.
        let total: usize = rows.iter().map(|b| b.num_rows()).sum();
/// the DataFusion physical plan is built, so the result can be stored on the handle and
    async fn test_widen_schema_from_empty_inferred_adds_all_nullable() {
    // Register under the planner's logical table name (alias / index pattern / index), shipped
        has_topk: false,
    #[tokio::test]
    /// (`IndexedTableProvider` `output_ordering`) and by the indexed path's
        writer_generations: shard_view.writer_generations.clone(),
        build_file_sort_order(&shard_view.sort_fields, &shard_view.sort_orders)
    // already covers every base_schema column.
            dir.path(),
                .execution
    let has_topk = has_partial_aggregate && substrait_has_fetch_rel(plan_bytes);
        .with_default_features()
            vec![
        );
        // Sort without fetch → no FetchRel → false
                rel_type: Some(plan_rel::RelType::Rel(*sort_rel)),
        .with_physical_optimizer_rules(if has_partial_aggregate {
        };
        query_config.listing_table_pushdown_filters;
            ..Default::default()
            assert!(f.is_nullable(), "appended column {name} must be nullable");
    fn test_substrait_has_fetch_rel_with_fetch_no_count_mode() {
        // Even though the plan's NamedTable is "input-7", the logical table name must win.
        // inferred has every base_schema column (a) plus an extra one (b) — cheap gate fires.
    // When the index has `index.sort.field`, ask DataFusion to use the sort-aware
                rel_type: Some(plan_rel::RelType::Rel(*join_rel)),
    let mut config = SessionConfig::new();
    crate::udwf::register_all(&ctx);
                input: None,
    use parquet::arrow::parquet_to_arrow_schema;
        use object_store::ObjectStore;
    use arrow_array::{Int64Array, RecordBatch};
            prepared_plan: None,
        table_path: shard_view.table_path.clone(),
    #[tokio::test]
            .expect("sql")
 */
}
        assert_eq!(handle.aggregate_mode, Mode::Default);
            .expect("widened query plans")
        has_topk,
        // there is no FetchRel to detect — the upstream TopK-CSS PartialReduce path does not apply here.
        ctx.register_table("t", Arc::new(table)).expect("register");
                advanced_extension: None,
    crate::udaf::register_all(&ctx);
    execution::context::SessionContext,
    table_name: &str,
/// Build a per-file sort-order declaration for `ListingOptions::with_file_sort_order`.
        .file_metadata
        let got_b = env_b
/// Creates a SessionContext with per-query RuntimeEnv and registers the default
            }))),
//!
    tree_shape: i32,
                .skip_partial_aggregation_probe_ratio_threshold,
    {
        use url::Url;
        ctx.register_table("t", Arc::new(table)).expect("register");
    fn test_skip_partial_agg_disabled_when_has_topk() {
            .expect("widened query executes without stats-merge failure");
        let registered_schema = Arc::new(Schema::new(vec![
use std::sync::Arc;
    // group when min/max ranges can't chain). The session-state's `target_partitions`
            .with_cache(stats_cache),
    }
        pool,
}
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
    /// reintroduces plan-bytes extraction must change `resolve_register_name` and trip this.
    let global_pool = runtime.runtime_env.memory_pool.clone();
            deleted_doc_filtering_required: false,
        env_b.register_object_store(&file_url, Arc::clone(&store_b));
        assert!(handle.prepared_plan.is_none());
        env_a.register_object_store(&file_url, Arc::clone(&store_a));
    /// subset check at the top of the function, not the empty-plan early-return.
        }
        .copied_config()
    /// Detected once in `create_session_context` from plan_bytes and reused in
            dir: &std::path::Path,
        use datafusion::datasource::file_format::parquet::ParquetFormat;
        let narrow_opts = ListingOptions::new(Arc::new(ParquetFormat::default()))
            Some(RelType::Project(p)) => p.input.as_ref().map_or(false, |r| rel_has_fetch(r)),
            rel_type: Some(RelType::Join(Box::new(JoinRel {
use crate::api::{DataFusionRuntime, ShardView};
    /// Shard fragments never have Join above a TopK FetchRel, so this correctly returns false.
        log::warn!("widen_schema_from_plan: no base_schema found for table '{}' in plan — skipping widening", table_name);
                advanced_extension: None,
        let plan = to_substrait_plan(&logical, &ctx.state()).expect("substrait plan");
    // Wire the global statistics cache into the ListingTable.
    let inferred: arrow::datatypes::SchemaRef = if shard_view.object_metas.is_empty() {
    // PageIndexPolicy::Skip via load_parquet_metadata, every infer_schema call becomes
            fetch_rel, plan_rel, Expression, FetchRel, Plan, PlanRel, Rel, SortRel,
        let registered_schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int64, true)]));
    crate::udf::register_all(&ctx);
    //
            Arc::clone(&narrow),
    pub tree_shape: i32,
    // effective partition count so the bin-packer produces up to N groups (one file per
        };
    })?;
            .infer_schema(&ctx.state(), &shard_view.table_path)
    fn test_substrait_has_fetch_rel_with_fetch() {
        use substrait::proto::{
            .expect("table_path");
        let shared = RuntimeEnvBuilder::new()
    /// the widened scan plans + executes.
    if let Some(pool) = query_memory_pool {
            let batch = RecordBatch::try_new(Arc::clone(&schema), cols).unwrap();
    // "non-bit-compatible types: Binary → Int64" when wrapping the stripped Partial.
        let bytes = plan.encode_to_vec();
    fn rel_has_fetch(rel: &substrait::proto::Rel) -> bool {
                        literal_type: Some(LiteralType::I64(10)),
    shard_view_ptr: i64,
/// Creates a SessionContext configured for indexed execution with filter delegation.
        .with_config(config)
pub async unsafe fn create_worker_session_context(
            .options_mut()
        use datafusion::arrow::datatypes::SchemaRef;
pub(crate) fn build_file_sort_order(
        let narrow: SchemaRef = Arc::new(Schema::new(vec![Field::new("a", DataType::Int64, true)]));
        let schema = Arc::new(Schema::new(vec![Field::new("x", DataType::Int64, false)]));
                    std::mem::discriminant(other)
            Field::new("a", DataType::Int64, true),
        // FetchRel exists but count_mode is None — not a real limit, should not trigger TopK.
                .skip_partial_aggregation_probe_ratio_threshold = 1.0;
        assert_eq!(result.fields().len(), 1);
        let runtime_env = RuntimeEnvBuilder::new().build().expect("runtime env");
    // The physical planner reads this at create_physical_plan time; EnforceSorting inserts the
            config
    let df_schema = match from_substrait_named_struct(&consumer, &base_schema) {
            .sql("SELECT a, b FROM t")
            "skip_partial must be disabled (1.0) when TopK is active"
                r#type: 0,
        let table_url =
    Ok(ptr)
        physical_plan,
    let dataframe = handle.ctx.execute_logical_plan(logical_plan).await?;
        use substrait::proto::{plan_rel, JoinRel, Plan, PlanRel, Rel};
    runtime: &DataFusionRuntime,
    .ok()
    /// from CPU executor threads.
    // handle still requires a value here. Use the project root as a benign stable URL.
    pub deleted_doc_filtering_required: bool,
                        type_variation_reference: 0,
        // recursive form so predefined ARRAY<VARCHAR> fields bind as List<Utf8View>.
    sort_fields: &[String],
    runtime_env.register_object_store(
        );
            .build()
        assert!(
        .map_err(|e| {
    // Final/Partial pair without a RelabelExec wrapper at the root pre-empting the walk.
        assert_eq!(
                input: None,
            Some(RelType::Filter(f)) => f.input.as_ref().map_or(false, |r| rel_has_fetch(r)),
/// - `.sort(asc, nulls_first)` constructs a `SortExpr` — it does NOT execute a
    use crate::query_tracker::QueryTrackingContext;
        indexed_config: None,
    )?;
    async fn test_per_query_object_store_registry_is_isolated() {
            .sql("SELECT a, b FROM t_wide ORDER BY a")
    /// the shard's table MUST register under the planner's logical name, never under whatever the
        let inferred = listing_options
    /// Regression guard for the merge-resolution of #21822's multi-index `register_name` logic:
            )));
            .with_config(SessionConfig::new())
        // base_schema for "t" = [a (Int64), b (Utf8)].
                e
        .fields()
    plan_bytes: &[u8],
        table_name,
        config
    runtime_ptr: i64,
            .await
    fn test_skip_partial_agg_default_when_no_topk() {
        io_handle: tokio::runtime::Handle::current(),
    query_config: DatafusionQueryConfig,
            .unwrap()
    /// Writer generation per object_metas entry (parallel arrays). Sourced from the
    }
            .with_listing_options(widened_opts)
        let table_path = datafusion::datasource::listing::ListingTableUrl::parse("file:///tmp")
        .collect();
    /// reproduces the straddle (narrow read seeds the cache, widened read reuses it) and asserts
    let expected = if force_view {
    }
/// Creates a worker-mode SessionContext: no shard view, no listing table, no parquet
    Ok(())
        ]));
    pub writer_generations: Arc<Vec<i64>>,
        use substrait::proto::{plan_rel, Plan, PlanRel, Rel, SortRel};
) -> Result<(), datafusion::common::DataFusionError> {
                    "substrait_has_fetch_rel: {:?} — no TopK fetch",
    // Then derive `target_schema` and wrap with RelabelExec from the stripped plan's actual
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int64, true)]));
    let cache = runtime.runtime_env.cache_manager.get_file_metadata_cache();
            Arc::clone(&schema),
        query_config,
            "env_b must resolve to its own store"
        use prost::Message;
    fn test_substrait_has_fetch_rel_without_fetch() {
///   DESC → NULLS LAST). `index.sort.missing` can override this per field but
        .zip(sort_orders.iter())
            ..Default::default()
/// Prepares a partial-aggregate physical plan on the session handle.
///   lookup against case-sensitive Arrow schemas. `from_name` preserves case.
            "all base_schema columns must be appended"
        parquet_meta.file_metadata().key_value_metadata(),
        table_name: table_name.to_string(),
    // Cheap gate: if inferred already has every base_schema column, skip.
            "per-query stores must be independent across queries"
    execution::runtime_env::RuntimeEnvBuilder,
    let global_pool = runtime.runtime_env.memory_pool.clone();
/// stripping via `agg_mode::apply_aggregate_mode`, and stores the result
pub struct SessionContextHandle {
        let widened_opts = ListingOptions::new(Arc::new(ParquetFormat::default()))
    };
    let state = state_builder.build();
        crate::query_tracker::QueryType::Shard,
            Some(RelType::Fetch(f)) => f.count_mode.is_some(),
    runtime_ptr: i64,
            writer.write(&batch).unwrap();
        .execution
        Arc::new(arrow::datatypes::Schema::empty())
    let logical_plan =
    let query_context = QueryTrackingContext::new(
        }
        };
    /// Each per-query RuntimeEnv built the way create_session_context builds it must get its own
                native_bridge_common::log_debug!(
        };
        let df = ctx.sql("SELECT SUM(x) FROM t").await.expect("sql");
        let ctx = SessionContext::new_with_state(state);
    pub table_name: String,
        });
            .await
            }))),
use datafusion::{
    )
    prelude::*,
            "FetchRel without count_mode → false"
        crate::schema_coerce::coerce_inferred_schema(Arc::new(inferred))
        ctx.register_table("t", Arc::new(table)).expect("register");
/// Returns true if the Substrait plan bytes contain a FetchRel (Sort+Limit node).
                input: Some(sort_rel),
    /// `prepare_partial_plan` to apply PartialReduce for CSS correctness.
/// `register_name_uses_logical_table_not_plan_placeholder`.
    // Strip first on the raw physical plan so `force_aggregate_mode(Partial)` can find the
        CachedFileList::new(shard_view.object_metas.as_ref().clone()),
    pub query_config: DatafusionQueryConfig,
                common: None,
        context_id,
    #[tokio::test]
        };
    }
            .object_store_registry
}
    use datafusion::execution::SessionStateBuilder;
    if page_index::is_scoped_page_index_enabled() {
        .downcast_ref::<CachedParquetMetaData>()?;
    #[test]
    use datafusion_substrait::extensions::Extensions;
            ListingTable::try_new(widened_cfg)
        crate::substrait_consumer::from_substrait_plan(&handle.ctx.state(), &plan).await?;
        let widened_cfg = ListingTableConfig::new(table_url)
            .expect("sql")
/// metadata. The worker's substrait plan reads only from named-input streams that are
        }
    pub sort_orders: Vec<String>,
    config.options_mut().execution.batch_size = query_config.batch_size;
        let substrait = to_substrait_plan(&plan, &ctx.state()).expect("to_substrait");
    use datafusion::common::Column;
    query_config: DatafusionQueryConfig,
/*
    }
        object_metas: Arc::new(Vec::new()),
        aggregate_mode: crate::agg_mode::Mode::Default,
            .expect("per-query runtime env b");
    // Without this, queries use default LocalFileSystem and fail on warm.
    /// Per-query tuning knobs (batch size, partitions, filter strategies, etc.)
        config.batch_size,
        &datafusion::execution::cache::TableScopedPath {
    .await?;
    execution::cache::{CacheAccessor, DefaultListFilesCache},
        plan.encode(&mut plan_bytes).expect("encode");
    })
    pub(crate) phantom_reservation: Option<datafusion::execution::memory_pool::MemoryReservation>,
        let ctx = SessionContext::new();
    let Some(base_schema) = crate::api::base_schema_for_table(&plan, table_name) else {
) -> Result<i64, DataFusionError> {
    async fn make_test_handle() -> (SessionContextHandle, Vec<u8>) {
        let ctx = SessionContext::new();
        runtime_env_builder = runtime_env_builder.with_memory_pool(pool);
/// `SortPreservingMergeExec` replaces `SortExec`, and `sort_prefix` TopK fires.
            Field::new("a", DataType::Int64, true),
        Some(substrait::proto::plan_rel::RelType::Root(rr)) => {
        });
}
    let phantom_reservation = try_acquire_budget(runtime, &global_pool, &shard_view, &query_config);
        let state = SessionStateBuilder::new()
) -> Option<crate::query_budget::QueryMemoryBudget> {
        // producer emits for Sort(fetch=10, ...) from OpenSearchTopKRewriter.
    handle.aggregate_mode = crate::agg_mode::Mode::Partial;
            .map_err(|e| {
        // Workers execute a shuffle-fed join/agg fragment, never a shard TopK Substrait plan, so
        if has_topk {
        let plan = Plan {
        // Simulates the single shared global runtime_env (DataFusionRuntime.runtime_env).
    async fn prepare_partial_plan_sets_mode_and_stores_plan() {
    };
        return false;
        Err(_) => return Arc::clone(inferred),
///
/// rather than the real index, so it would register the shard table under the wrong name. The
    use datafusion::datasource::physical_plan::parquet::metadata::CachedParquetMetaData;
/// to reintroduce plan-bytes extraction must change THIS function, tripping
    // already marked nullable by the consumer.
    let handle = SessionContextHandle {
    #[tokio::test]
    );
            Arc::new(MemTable::try_new(Arc::clone(&schema), vec![vec![batch]]).expect("memtable")),
 * The OpenSearch Contributors require contributions made to
    has_partial_aggregate: bool,
    use prost::Message;
    /// before invoking the substrait NamedStruct→Arrow converter. Verifies the column-name
    let mut state_builder = SessionStateBuilder::new()
        context_id,
    // Sentinel placeholder for table_path — workers never reference a listing table; the
    }
        // Shared, runtime-global stats cache — the crux of the bug.
        use arrow_array::StringArray;
            // TODO: enumerate remaining rel types explicitly and panic on unknown ones.
            ],
                count_mode: None,
        //    widen_schema_from_plan. The fix sets collect_stat(false) because the schema was widened;
        // Empty shard → empty inferred schema (0 fields).
) -> Option<Vec<datafusion::logical_expr::SortExpr>> {
/// # Upgrade path note
        return Arc::clone(inferred);
        query_config,
}
///   the override isn't propagated yet. A wrong nulls claim at worst causes
        // agg midstream the partial state is incomplete and TopK sees wrong group counts.
            .execution
    pub io_handle: tokio::runtime::Handle,
        prepared_plan: None,
        // Register an in-memory table with column "x"
    if let Some(sort_exprs) =
        .with_collect_stat(true)
            .await
            e
/// ListingTable provider for parquet scans.
    };
/// Resolves the name to register the shard's table under so the Substrait plan's `NamedTable`
    /// Phantom reservation holding pool capacity for untracked memory.
        assert_eq!(handle.aggregate_mode, Mode::Partial);
    use prost::Message;
    // Cache key is meta.location (Path) — same key infer_schema uses.
        object_metas: shard_view.object_metas.clone(),
    #[test]
};
use crate::query_tracker::QueryTrackingContext;
        runtime_env_builder = runtime_env_builder.with_memory_pool(pool);
        assert_eq!(result.field(0).name(), "a");
///
    common::DataFusionError,
    .ok()
                    e
        });
        // Workers scan registered StreamingTables, not a sorted parquet index, so there is no
}
        table_name,
        .with_physical_optimizer_rules(crate::agg_mode::physical_optimizer_rules_without_combine())
            Some(RelType::Sort(s)) => s.input.as_ref().map_or(false, |r| rel_has_fetch(r)),
            let file = std::fs::File::create(dir.join(name)).unwrap();
use crate::cache::page_index;
                advanced_extension: None,
/// old coordinators serialising `PartialAggregateInstructionNode` without the field
    /// Cheap-gate branch: with a non-empty plan whose `base_schema` names are all already in
    })?;
    /// IO runtime handle for bloom filter reads and other async I/O dispatched
                    "create_session_context: failed to create listing table: {}",
    handle: &mut SessionContextHandle,
        requests_row_ids,
        );
        .expect("batch");
    }
        let join_rel = Box::new(Rel {
            relations: vec![PlanRel {
        let plan = Plan {
            QueryTrackingContext::new(0, global_pool, crate::query_tracker::QueryType::Shard);
    // of building a fresh one.
    // Register shard-specific object store on file:// scheme for this query.
///   to a regular `SortExec` — never wrong results.
            "Join rel → false (no TopK in shard fragment with Join)"
    let ctx = SessionContext::new_with_state(state);
        let inferred = Arc::new(Schema::empty());
    if let Some(pool) = query_memory_pool {
    let resolved_schema = widen_schema_from_plan(&ctx, plan_bytes, &register_name, &inferred);
        expected
            None => false,
/// ALWAYS the planner's logical table name (alias / index pattern / index), which the coordinator
        .unwrap_or_else(|| Arc::clone(inferred))
        return None;
        for meta in shard_view.object_metas.as_ref() {
        table_name.len()
            indexed_config: None,
        ctx.register_table("t_wide", widened_tbl).unwrap();
        let bytes = plan.encode_to_vec();
pub struct IndexedExecutionConfig {
#[cfg(test)]
pub async unsafe fn create_session_context_indexed(
        .with_schema(resolved_schema);
        let global_pool = ctx.runtime_env().memory_pool.clone();
            aggregate_mode: Mode::Default,
                Arc::new(Int64Array::from(vec![2i64])),
    let phantom = phantom_reservation.map(|b| b.phantom_reservation);
    use datafusion::logical_expr::{Expr, SortExpr};
/// verifiable-by-construction (DataFusion also checks per-file min/max stats).
                meta.clone(),
    /// `index.sort.field` plumbed from the Java side (`ShardView.sort_fields`).
    );
        );
    // controls EnforceDistribution; this one is independent.
    }
            table_name: "t".to_string(),
pub async unsafe fn create_session_context(
        delegated_predicate_count,
///
    let mut config = SessionConfig::new();
    }
            Arc::clone(&wide),
/// unchanged when no plan is supplied, no matching base_schema exists, or this shard already
    // incomplete — TopK sees wrong group counts and produces incorrect results.
        use substrait::proto::rel::RelType;
    let register_name = resolve_register_name(table_name, plan_bytes);
    async fn widened_scan_over_narrower_files_does_not_fail_stats_merge() {
    let schema = parquet_to_arrow_schema(
/// All shard-specific fields on the handle are populated with empty defaults so the
        .with_default_features()
    table_name: &str,
        Arc::clone(&shard_view.store),
                sorts: vec![],
    /// (NOT schema), so a Statistics cached during an earlier NARROW read is returned for a later
    /// Dropped when the handle is closed, releasing the capacity.
    use prost::Message;
    })?;
/// Returns `None` when the index has no `index.sort.field` configured (the input
        let narrow_cfg = ListingTableConfig::new(table_url.clone())
        assert_eq!(resolve_register_name("my_index", &plan_bytes), "my_index");
        );
                    })),
///   sort. Misleading name; it's a tuple builder.
 * SPDX-License-Identifier: Apache-2.0
        let fetch_rel = Box::new(Rel {
            table_path,
            .await;
        global_pool.clone(),
    plan_bytes: &[u8],
            "create_worker_session_context: failed to parse placeholder path: {}",
        .iter()
            "wide.parquet",
}
    // on this session so the substrait converter at execute_with_context can resolve
        );
            table: None,
        //    without it, merging the cached 1-col Statistics against a 2-col one fails planning.
        })
/// Opaque handle holding a configured SessionContext between FFM calls.
            .with_file_extension(".parquet")
        for name in ["a", "b"] {
            let ascending = order.eq_ignore_ascii_case("asc");
        let logical = ctx
            .collect()
        from_substrait_named_struct, DefaultSubstraitConsumer,
/// binds against it.
        // index sort to plumb (upstream added these fields for the shard-scan path; empty here).
        use substrait::proto::rel::RelType;
/// parameter is kept so this stays the single decision point — a future upstream merge that tries
        has_partial_aggregate,
/// Closes a SessionContext handle without executing. Used for cleanup on failure.
    /// segment-reversal optimization.
        let mut plan_bytes = Vec::new();
        assert_eq!(
    use datafusion::prelude::{SessionConfig, SessionContext};
            .sql("SELECT a FROM t_narrow")
/// That would be cleaner and avoid re-parsing the plan bytes, but requires a
    /// `inferred`, `widen_schema_from_plan` must short-circuit (return `Arc::clone(inferred)`)
use crate::scoped_index_optimizer::ScopedPageIndexOptimizer;
            .expect("prepare_partial_plan succeeds");
        use substrait::proto::rel::RelType;
    let query_memory_pool = query_context
        handle.has_topk,
                Arc::clone(&shard_view.store),
        } else {
/// TODO: Once AnalyticsCore supports a versioned flag/hint mechanism, replace this
//! `create_session_context` creates a fully configured SessionContext with
/// Decodes Substrait → LogicalPlan → PhysicalPlan, applies partial-mode
        });
 * compatible open source license.
    // Empty shard: skip infer_schema (errors on zero files); widen_schema_from_plan
        let metadata_cache = runtime.runtime_env.cache_manager.get_file_metadata_cache();
            Field::new("b", DataType::Utf8, true),
    };
/// a fragment's first `NamedTable` read can be a stage placeholder (`input-7`, `broadcast-N`)
        ))
    pub sort_fields: Vec<String>,
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
        let inferred = Arc::new(Schema::new(vec![
        }
    config.options_mut().optimizer.prefer_hash_join = query_config.prefer_hash_join;
    /// Empty-shard case: a shard with zero parquet files yields an empty inferred schema, but the
            Expr::Column(Column::from_name(name.clone())).sort(ascending, nulls_first)
        // Register a table whose schema is a subset of `inferred` below.
    let effective_partitions = phantom_reservation
/// Configuration for indexed execution with filter delegation, provided by Java.
        let has_topk = true;
        assert_eq!(total, 2, "widened scan must read both files");
        register_name,
        let logical = ctx
            .map_err(|e| {
) -> arrow::datatypes::SchemaRef {
    /// Regression: a shard whose parquet files have FEWER columns than the widened (alias/pattern
            .into_unoptimized_plan();
            .await
/// Registers the `delegated_predicate` UDF and stores the tree shape + predicate count
        let ctx = SessionContext::new();
    }
    }
                error!(
        ctx.register_table(
    }
        let table =
    if has_topk {
        let table = MemTable::try_new(Arc::clone(&schema), vec![vec![batch]]).expect("memtable");
                runtime.runtime_env.cache_manager.get_file_metadata_cache(),
            .await
pub unsafe fn close_session_context(ptr: i64) {
            rel_type: Some(RelType::Sort(Box::new(SortRel {
        }
                e
        }
fn resolve_register_name(table_name: &str, _plan_bytes: &[u8]) -> String {
/// - `Column::from_name` (vs `col(&str)`): `col` lowercases via SQL identifier
    // explicitly as logicalTableName on the shard-scan instruction node. See
                common: None,
/// Returns None on cache miss or if the budget system is not configured.
    let Ok(plan) = substrait::proto::Plan::decode(plan_bytes) else {
        ]));
            rel_type: Some(RelType::Fetch(Box::new(FetchRel {
            crate::agg_mode::physical_optimizer_rules_without_combine()
            cols: Vec<Arc<dyn arrow::array::Array>>,
        match rel.rel_type.as_ref() {
            2,
    // TODO: re-enable once DataFusion's Statistics::try_merge tolerates a column-count delta.
    // Use the substrait consumer to convert NamedStruct → Arrow Schema (handles all type
    #[tokio::test]
    // Detect TopK once from the Substrait bytes: a FetchRel (Sort+Limit) in a partial-agg
    physical_plan::ExecutionPlan,
        .map(|p| p as Arc<dyn MemoryPool>);
use native_bridge_common::log_debug;
    }
        parquet_meta,
                .unwrap()
            "prepare_partial_plan: failed to decode Substrait: {}",
    requests_row_ids: bool,
    shard_view_ptr: i64,
    config.options_mut().execution.target_partitions = query_config.target_partitions;
        write_parquet(
    async fn test_widen_schema_noop_when_all_columns_present() {
    /// hasDeletions probe; false on shards without deletions (zero overhead).
            0.8,
    });
        parquet_meta.file_metadata().schema_descr(),
/// later registered onto this session via `register_partition_stream_on_session_context`.
        // 2. WIDENED read reusing the SAME cache. This is what create_session_context does after
        let substrait =
    // Register OpenSearch UDFs (parse, item, mvappend, mvfind, mvzip, convert_tz, …)
    /// disables stat collection, avoiding the cache's column-count merge failure.)
        });
    )
    // empty-shard-aware schema inference + plan widening happens just below; no infer_schema here.
/// A FetchRel in a shard fragment means `OpenSearchTopKRewriter` inserted a per-shard
//! the default ListingTable registered. Called by ShardScanInstruction handler.
    pub query_context: QueryTrackingContext,
        use substrait::proto::{plan_rel, FetchRel, Plan, PlanRel, Rel};
            }],
        assert_eq!(resolve_register_name("my_index", &[]), "my_index");
        use datafusion::datasource::listing::{
        .map(|f| f.name().as_str())
        .as_any()
        query_context,
        use prost::Message;
///
            e
            MemTable::try_new(Arc::clone(&registered_schema), vec![vec![batch]]).expect("memtable");
            }],
            .collect()
    };
    /// Collector leaf (reserved annotation id) into the decoded filter tree so deleted rows are
            }))),
        plan.encode(&mut plan_bytes).expect("encode");
        deleted_doc_filtering_required,
            error!(
