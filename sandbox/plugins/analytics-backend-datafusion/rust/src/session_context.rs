    }
                .execution
            assert!(f.is_nullable(), "appended column {name} must be nullable");
        ctx.register_table("t", Arc::new(table)).expect("register");
            let nulls_first = ascending;
            );
///
        .file_metadata
            sort_fields: vec![],
    )
        ctx,
    async fn widened_scan_over_narrower_files_does_not_fail_stats_merge() {
        .schema_force_view_types;
            crate::agg_mode::physical_optimizer_rules_without_combine()
        };
    // This is the instruction-based execution path (ShardScanInstructionHandler).
    /// reintroduces plan-bytes extraction must change `resolve_register_name` and trip this.
///
    if sort_fields.is_empty() {
            }],
        };
            .build()
    } else {
            relations: vec![PlanRel {
/// Substrait scan with an explicit flag passed through the instruction pipeline.
            .expect("env_a must resolve a file:// store");
    )
    // hash table, it sets prefer_hash_join=false so DataFusion's physical planner emits a spillable
/// for use during execution.
        query_config.listing_table_pushdown_filters;
    };
            .with_config(SessionConfig::new())
    // (spillable) SortExecs the SMJ needs.
        // Register an in-memory table with column "x"
                common: None,
            to_substrait_plan(&df.logical_plan().clone(), &ctx.state()).expect("to_substrait");
            result.fields().len(),
        }
        assert!(
            .await
    }
        let table =
                count_mode: None,
        use datafusion::parquet::arrow::ArrowWriter;
        Some(substrait::proto::plan_rel::RelType::Root(rr)) => {
    crate::udaf::register_all(&ctx);
        // Build Substrait bytes for SELECT SUM(x) FROM t
            .skip_partial_aggregation_probe_ratio_threshold = 1.0;
        );
        let narrow_cfg = ListingTableConfig::new(table_url.clone())
/// `crate::api::first_named_table_name` approach upstream's #21822 originally used) is unreliable:
        indexed_config: None,
                runtime.runtime_env.cache_manager.get_file_metadata_cache(),
    }
    }
    // Pre-warm the metadata cache footer-only before infer_schema fires.
        crate::query_tracker::QueryType::Shard,
        deleted_doc_filtering_required,
/// # Upgrade path note
        for meta in shard_view.object_metas.as_ref() {
        ctx.register_table("t_wide", widened_tbl).unwrap();
                Arc::clone(&shard_view.store),
/// A FetchRel in a shard fragment means `OpenSearchTopKRewriter` inserted a per-shard
    let listing_options = if resolved_schema.fields().len() != inferred_field_count {
///
        runtime_ptr,
            .await
        let plan = Plan {
            prepared_plan: None,
            .expect("shared runtime env");
    /// nullable so the consumer can bind. (Downstream, the field-count delta — 0 vs N — also
            "all base_schema columns must be appended"
    use crate::query_tracker::QueryTrackingContext;
        let ctx = SessionContext::new();
    use substrait::proto::rel::RelType;
        use datafusion::datasource::listing::{
    // file-group partitioner so `output_ordering` can propagate from the scan.
    prelude::*,
        return Arc::clone(inferred);
    // Without this, queries use default LocalFileSystem and fail on warm.
use datafusion::{
                        literal_type: Some(LiteralType::I64(10)),
}
            .object_store_registry
pub async fn prepare_partial_plan(
    common::DataFusionError,
    let register_name = resolve_register_name(table_name, plan_bytes);
            )
    use datafusion_substrait::extensions::Extensions;
            table: None,
            let file = std::fs::File::create(dir.join(name)).unwrap();
        use substrait::proto::{
    if let Some(pool) = query_memory_pool {
                    e
        });
            ..Default::default()
        .iter()
                rel_type: Some(plan_rel::RelType::Rel(*fetch_rel)),
/// (`DataFusionPlugin.createReaderManager`) guarantees this — `IndexSortConfig`
    if plan_bytes.is_empty() {
        .copied_config()
        table_name,
/// `register_name_uses_logical_table_not_plan_placeholder`.
        let inferred = listing_options
            .await;
        let plan = to_substrait_plan(&logical, &ctx.state()).expect("substrait plan");
            .expect("table_path");
            !substrait_has_fetch_rel(&bytes),
        io_handle: tokio::runtime::Handle::current(),
    execution::cache::{CacheAccessor, DefaultListFilesCache},
    config: &DatafusionQueryConfig,
///   to a regular `SortExec` — never wrong results.
            "subset gate must short-circuit to inferred"
    if page_index::is_scoped_page_index_enabled() {
    deleted_doc_filtering_required: bool,
        runtime_env_builder = runtime_env_builder.with_memory_pool(pool);
        };
    };
    use prost::Message;
        // Each env resolves to its OWN store, and the two are independent: registering in one env
        let widened_tbl = Arc::new(
        parquet_meta.file_metadata().key_value_metadata(),
    // group when min/max ranges can't chain). The session-state's `target_partitions`
        assert!(
        from_substrait_named_struct, DefaultSubstraitConsumer,
            vec![Arc::new(Int64Array::from(vec![1i64]))],
    }
        query_config,
        runtime_env_builder = runtime_env_builder.with_memory_pool(pool);
    let mut config = SessionConfig::new();
/// `ptr` must be 0 or a valid pointer returned by `create_session_context`.
    async fn test_widen_schema_noop_when_all_columns_present() {
        assert_eq!(resolve_register_name("my_index", &plan_bytes), "my_index");
    let has_topk = has_partial_aggregate && substrait_has_fetch_rel(plan_bytes);
            cols: Vec<Arc<dyn arrow::array::Array>>,
 * this file be licensed under the Apache-2.0 license or a
        env_b.register_object_store(&file_url, Arc::clone(&store_b));
 * SPDX-License-Identifier: Apache-2.0
    pub(crate) phantom_reservation: Option<datafusion::execution::memory_pool::MemoryReservation>,
    let dataframe = handle.ctx.execute_logical_plan(logical_plan).await?;
            .await
///
        table_name: String::new(),
        .unwrap_or(query_config.batch_size);
        .map(|f| f.name().as_str())
        .with_default_features()
    // output (state-suffixed Binary for HLL Partial vs. Int64 cardinality for Final.evaluate)
        });
            .into_unoptimized_plan();
    Ok(Box::into_raw(Box::new(handle)) as i64)
        );
        };
    let phantom = phantom_reservation.map(|b| b.phantom_reservation);
    // their function names. Without this, fragment execution fails with "Unsupported
            .sql("SELECT a FROM t_narrow")
            Arc::ptr_eq(&got_a, &store_a),
    /// `inferred`, `widen_schema_from_plan` must short-circuit (return `Arc::clone(inferred)`)
/// Closes a SessionContext handle without executing. Used for cleanup on failure.
    shard_view_ptr: i64,
 * The OpenSearch Contributors require contributions made to
            .collect()
                e
        assert_eq!(result.field(0).name(), "a");
                advanced_extension: None,
        });
    // incomplete — TopK sees wrong group counts and produces incorrect results.
    async fn make_test_handle() -> (SessionContextHandle, Vec<u8>) {
///   sort. Misleading name; it's a tuple builder.
        });
    /// scheme must not clobber each other — the bug that routed one shard's parquet read through
    // Cheap gate: if inferred already has every base_schema column, skip.
        phantom_reservation: None,
    // If widening added columns, disable stat collection: the global stats cache is keyed by
    use super::*;
                advanced_extension: None,
    #[test]
        let bytes = plan.encode_to_vec();
        table_name,
    /// disables stat collection, avoiding the cache's column-count merge failure.)
            deleted_doc_filtering_required: false,
            query_config: crate::datafusion_query_config::DatafusionQueryConfig::test_default(),
            .get_store(&file_url)
/// covers every column.
            .expect("per-query runtime env a");
    #[tokio::test]
    let query_memory_pool = query_context
    // handle still requires a value here. Use the project root as a benign stable URL.
/// function is only called for multi-shard partial-aggregate fragments.
            })?;
/// Decodes Substrait → LogicalPlan → PhysicalPlan, applies partial-mode
    // PageIndexPolicy::Skip via load_parquet_metadata, every infer_schema call becomes
    runtime_ptr: i64,
        // Shared, runtime-global stats cache — the crux of the bug.
        let ctx = SessionContext::new();
        let bytes = plan.encode_to_vec();
        sort_orders: Vec::new(),
    tree_shape: i32,
/// Returns None on cache miss or if the budget system is not configured.
    }
            .options_mut()
            }],
    #[test]
            .with_default_features()
            .with_file_extension(".parquet")
                right: None,
        e
        // When has_topk=false, skip_partial retains DF default (0.8) — no perf regression
        let mut plan_bytes = Vec::new();
        let table =
        return false;
        ]));
                .with_cache(Some(stats_cache)),
) -> Result<i64, DataFusionError> {
                rel_type: Some(plan_rel::RelType::Rel(*fetch_rel)),
///
    Ok(ptr)
/// - `.sort(asc, nulls_first)` constructs a `SortExpr` — it does NOT execute a
            !substrait_has_fetch_rel(&bytes),
    pub tree_shape: i32,
    // Also, this SHOULD be the last optimizer to see all projections / predicates
    // already marked nullable by the consumer.
}
    // are now registered for every session by udf::register_all (via create_session_context above);
/// `sort_fields` slice is empty), so the caller can skip
        use substrait::proto::{plan_rel, JoinRel, Plan, PlanRel, Rel};
        query_context,
    plan_bytes: &[u8],
fn substrait_has_fetch_rel(plan_bytes: &[u8]) -> bool {
                &meta.location,
            }))),
/// This detection avoids adding a new boolean field to the Java→Rust FFI surface
    }
    pub(crate) has_topk: bool,
        ]));
            ],
///
    /// WIDENED read; merging the cached narrow stats against freshly-computed widened stats blows
        let ctx = SessionContext::new();
    query_config: DatafusionQueryConfig,
    if let Some(sort_exprs) =
    /// Pre-prepared physical plan (set by prepare_partial_plan / prepare_final_plan).
        ))
        use url::Url;
    execution::SessionStateBuilder,
    /// `SegmentFileInfo.writer_generation`; footer-kv reads are debug-only assertions.
                .options()
        let join_rel = Box::new(Rel {
    context_id: i64,
}
        };
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
            .expect("env_b must resolve a file:// store");
    use parquet::arrow::parquet_to_arrow_schema;
        "create_session_context: registered table '{}' with file_sort_order_keys={}",
}
            Arc::clone(&narrow),
    use datafusion::execution::SessionStateBuilder;
                    })),
/// `plan_bytes` is intentionally IGNORED. Reverse-engineering the name from the plan (the removed
    let sort_exprs: Vec<SortExpr> = sort_fields
        &schema,
        // for non-TopK multi-shard queries.
        .with_target_partitions(effective_partitions);
    let stripped = crate::relabel_exec::wrap_if_relabel_needed(stripped, target_schema)?;
        Err(_) => return Arc::clone(inferred),
    // Wire the global statistics cache into the ListingTable.
        );
        ListingTable::try_new(table_config)
            "SortRel without FetchRel → false"
    plan_bytes: &[u8],
    // The physical planner reads this at create_physical_plan time; EnforceSorting inserts the
                "create_session_context: failed to register table '{}': {}",
    .map(Arc::new)?;
    }
            MemTable::try_new(Arc::clone(&registered_schema), vec![vec![batch]]).expect("memtable");
        ) {
        let sort_rel = Box::new(Rel {
    };
    })?;
                .execution
    // Install the scoped page-index reader factory on every parquet scan.
            table_path,
            ..Default::default()
    table_name: &str,
                        type_variation_reference: 0,
/// (which already marks all fields nullable). The consumer is built from the session's existing
            e
        parquet_meta.file_metadata().schema_descr(),
            MemTable::try_new(Arc::clone(&registered_schema), vec![vec![]]).expect("memtable");
/// Opaque handle holding a configured SessionContext between FFM calls.
        context_id,
    crate::schema_coerce::append_missing_nullable(inferred, &expected)
    // Use the substrait consumer to convert NamedStruct → Arrow Schema (handles all type
    /// True when the shard Substrait fragment contains a FetchRel (Sort+Limit = TopK).
    has_partial_aggregate: bool,
            })?
            .with_cache(stats_cache),
    /// hasDeletions probe; false on shards without deletions (zero overhead).
        );
/// validates size match at index creation, so by the time we get here the
        .expect("register");
    }
        );
    // a cache hit and never touches the page index bytes.
    let global_pool = runtime.runtime_env.memory_pool.clone();
        crate::schema_coerce::coerce_inferred_schema(Arc::new(inferred))
        tree_shape,
            .with_object_store_registry(Arc::new(DefaultObjectStoreRegistry::new()))
        )
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int64, true)]));
    // expects (multi-index unions, or single-index cross-shard drift). No-op when the shard
        substrait.encode(&mut buf).expect("encode");
        let table_url =
        e
    }
        assert!(handle.prepared_plan.is_some());
    // (single-index) scans keep full stats.
    };
            Some(RelType::Sort(s)) => s.input.as_ref().map_or(false, |r| rel_has_fetch(r)),
                sorts: vec![],
        config
        let fetch_rel = Box::new(Rel {
    let ptr = create_session_context(
    );
    table_name: &str,
        listing_options = listing_options.with_file_sort_order(vec![sort_exprs]);
    async fn test_widen_schema_from_empty_inferred_adds_all_nullable() {
        use prost::Message;
    let state = SessionStateBuilder::new()
        })
            .execution
            .sql("SELECT a, b FROM t_wide ORDER BY a")
use native_bridge_common::log_debug;
            .with_schema(Arc::clone(&narrow));
        .collect();
            "skip_partial must be disabled (1.0) when TopK is active"
            Arc::clone(&registered_schema),
        writer_generations: Arc::new(Vec::new()),
    })
        crate::query_executor::query_runtime_env_builder(runtime, list_file_cache);
            .build()
    let logical_plan =
            Arc::clone(&schema),
use crate::query_tracker::QueryTrackingContext;
        (handle, buf)
        register_name,
    // When the index has `index.sort.field`, ask DataFusion to use the sort-aware
            Field::new("b", DataType::Utf8, true),
        let result = widen_schema_from_plan(&ctx, &plan_bytes, "t", &inferred);
    async fn test_widen_schema_noop_when_plan_empty() {
            rel_type: Some(RelType::Join(Box::new(JoinRel {
            writer.close().unwrap();
        let logical = ctx
) -> Option<Vec<datafusion::logical_expr::SortExpr>> {
    // Sentinel placeholder for table_path — workers never reference a listing table; the
        .with_listing_options(listing_options)
        let plan = df.logical_plan().clone();
            "create_worker_session_context: failed to parse placeholder path: {}",
        let plan = Plan {
        .downcast_ref::<CachedParquetMetaData>()?;
/// in this order so `output_ordering` propagates through the scan,
        listing_options.with_collect_stat(false)
        sort_orders: shard_view.sort_orders.clone(),
        let store_a: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
        let _ = ctx
    datasource::listing::{ListingOptions, ListingTable, ListingTableConfig, ListingTableUrl},
        write_parquet(
        "create_session_context: successfully registered table '{}', table_name_len={}",
            writer.write(&batch).unwrap();
    // Pre-widening field count — compared below to detect whether widening added columns.
/// old coordinators serialising `PartialAggregateInstructionNode` without the field
/// # Safety
    };
/// backward-compatible flag delivery path that does not exist today.
    context_id: i64,
        assert!(handle.prepared_plan.is_none());
    runtime_ptr: i64,
    // effective partition count so the bin-packer produces up to N groups (one file per
pub(crate) fn widen_schema_from_plan(
        let bytes = plan.encode_to_vec();
        shard_view_ptr,
    fn test_substrait_has_fetch_rel_empty() {
        use datafusion::execution::cache::file_statistics_cache::DefaultFileStatisticsCache;
        let plan = Plan {
    if base_schema.names.iter().all(|n| have.contains(n.as_str())) {
    /// (NOT schema), so a Statistics cached during an earlier NARROW read is returned for a later
    // `split_groups_by_statistics_with_target_partitions`. We set it to the session's
            Arc::ptr_eq(&result, &inferred),
            .options_mut()
                e
    /// Cheap-gate branch: with a non-empty plan whose `base_schema` names are all already in
    }
    .ok()
    /// excluded via the ordinary Lucene collector machinery. Sourced from the Java per-shard
    };
        )
            }))),
/// on the handle for later execution.
        let substrait =
        plan_bytes,
    fn test_substrait_has_fetch_rel_join_returns_false() {
    execution::runtime_env::RuntimeEnvBuilder,
        delegated_predicate_count,
        Some(substrait::proto::plan_rel::RelType::Rel(r)) => rel_has_fetch(r),
/// Build a per-file sort-order declaration for `ListingOptions::with_file_sort_order`.
        let widened_opts = ListingOptions::new(Arc::new(ParquetFormat::default()))
/// later registered onto this session via `register_partition_stream_on_session_context`.
        let batch = RecordBatch::try_new(
            .unwrap();
        use arrow_array::StringArray;
        use prost::Message;
    let shard_view = &*(shard_view_ptr as *const ShardView);
        let narrow_opts = ListingOptions::new(Arc::new(ParquetFormat::default()))
    crate::udwf::register_all(&ctx);
            .sql("SELECT a FROM t")
    // controls EnforceDistribution; this one is independent.
/// - `Column::from_name` (vs `col(&str)`): `col` lowercases via SQL identifier
    }
        query_config,
        .map(|p| p as Arc<dyn MemoryPool>);
    runtime_env.register_object_store(
use crate::cache::page_index;
}
                input: None,
    #[tokio::test]
        .with_runtime_env(Arc::from(runtime_env))
        .with_default_features()
/// would be misread by new data nodes). The Substrait plan bytes are already part of
    use arrow_array::{Int64Array, RecordBatch};
        prepared_plan: None,
                crate::agg_mode::physical_optimizer_rules_without_combine(),
 */
    /// up. We avoid this by disabling stat collection when widening changed the schema; this test
        );
    handle: &mut SessionContextHandle,
        let widened_cfg = ListingTableConfig::new(table_url)
/// Prepares a partial-aggregate physical plan on the session handle.
        let metadata_cache = runtime.runtime_env.cache_manager.get_file_metadata_cache();
    // failing with "Cannot merge statistics with different number of columns". Non-widened
    // below populates columns from the substrait base_schema.
    handle.prepared_plan = Some(stripped);
    /// subset check at the top of the function, not the empty-plan early-return.
        .unwrap_or_else(|| Arc::clone(inferred))
    shard_view_ptr: i64,
    plan_bytes: &[u8],
        assert!(
    // Disable DataFusion's adaptive skip-partial-aggregation when TopK is active.
        physical_plan,
            .await
            vec![Arc::new(Int64Array::from(vec![1i64, 2, 3]))],
    /// A Join rel at the root — exercises the `Some(other)` arm that logs and returns false.
        let ctx = SessionContext::new();
) -> arrow::datatypes::SchemaRef {
        let table_path = datafusion::datasource::listing::ListingTableUrl::parse("file:///tmp")
            "narrow.parquet",
}
    /// `index.sort.field` plumbed from the Java side (`ShardView.sort_fields`).
        assert!(
            .collect()
        config
            .expect("widened query plans")
                post_join_filter: None,
                rel_type: Some(plan_rel::RelType::Rel(*sort_rel)),
    use datafusion::prelude::{SessionConfig, SessionContext};
        deleted_doc_filtering_required,
        crate::substrait_consumer::from_substrait_plan(&handle.ctx.state(), &plan).await?;
    async fn test_per_query_object_store_registry_is_isolated() {
        fn write_parquet(
        );
    #[test]
        //    without it, merging the cached 1-col Statistics against a 2-col one fails planning.
/// a fragment's first `NamedTable` read can be a stage placeholder (`input-7`, `broadcast-N`)
        global_pool.clone(),
        let schema = Arc::new(Schema::new(vec![Field::new("x", DataType::Int64, false)]));
            Arc::ptr_eq(&got_b, &store_b),
    fn test_substrait_has_fetch_rel_with_fetch() {
    pub delegated_predicate_count: i32,
    let expected = df_schema.as_arrow().clone();
                count_mode: Some(fetch_rel::CountMode::CountExpr(Box::new(Expression {
        // inferred has every base_schema column (a) plus an extra one (b) — cheap gate fires.
        listing_options
        let env_a = RuntimeEnvBuilder::from_runtime_env(&shared)
/// Sort+Limit — TopK is active. Used in `create_session_context` to detect TopK before
        let (mut handle, substrait_bytes) = make_test_handle().await;
        use datafusion::arrow::datatypes::SchemaRef;
        // Build a substrait plan with a Read rel pointing at "t" — base_schema.names = ["a"].
        let fetch_rel = Box::new(Rel {
            0.8,
    let mut config = SessionConfig::new();
    // When the coordinator estimates this worker join's build side is too large for an in-memory
        writer_generations: shard_view.writer_generations.clone(),
//! the default ListingTable registered. Called by ShardScanInstruction handler.
    // Widen to the plan's base_schema if this shard's parquet is missing columns the plan
        }
/// Resolves the name to register the shard's table under so the Substrait plan's `NamedTable`
/// parameter is kept so this stays the single decision point — a future upstream merge that tries
                );
        .expect("batch");
        };
    }
    fn test_skip_partial_agg_disabled_when_has_topk() {
//! `create_session_context` creates a fully configured SessionContext with
            vec![Arc::new(Int64Array::from(vec![1i64]))],
        sort_fields: Vec::new(),
    // Register shard-specific object store on file:// scheme for this query.
/// the DataFusion physical plan is built, so the result can be stored on the handle and
        has_partial_aggregate,
        return Arc::clone(inferred);
    /// before invoking the substrait NamedStruct→Arrow converter. Verifies the column-name
            "per-query stores must be independent across queries"
    // Register under the planner's logical table name (alias / index pattern / index), shipped
        datafusion::common::DataFusionError::Execution(format!(
            Field::new("a", DataType::Int64, true),
    #[tokio::test]
            error!(
    }
        crate::agg_mode::Mode::Partial,
        write_parquet(
        // agg midstream the partial state is incomplete and TopK sees wrong group counts.
    /// plan's base_schema still names columns. widen_schema_from_plan must append all of them as
    ctx.register_table(register_name.as_str(), provider)
            config
    })?;
/// captured from the plan's table-scan leaf and ships explicitly as `logicalTableName` on the
        }
        )
        .build();
                    rex_type: Some(RexType::Literal(Literal {
        let file_url = Url::parse("file://").unwrap();
            phantom_reservation: None,
            table_name: "t".to_string(),
        .collect();
    let force_view = ctx
            schema: SchemaRef,
            Arc::clone(&wide),
            relations: vec![PlanRel {
        return Arc::clone(inferred);
    config.options_mut().execution.batch_size = effective_batch_size;
            ..Default::default()
            .object_store_registry
                error!(
    let have: std::collections::HashSet<&str> = inferred
    /// Regression: a shard whose parquet files have FEWER columns than the widened (alias/pattern
                advanced_extension: None,
        .map(|b| b.target_partitions)
    let Ok(plan) = substrait::proto::Plan::decode(plan_bytes) else {
    /// ObjectStoreRegistry. Two queries registering different stores under the bare `file://`
            Field::new("b", DataType::Utf8, true),
    runtime_ptr: i64,
    /// When true, the shard has deleted docs: the indexed executor ANDs a synthetic match-all
    Some(sort_exprs)
            .expect("sql")
    // Detect TopK once from the Substrait bytes: a FetchRel (Sort+Limit) in a partial-agg
        ctx.register_table(
        let df = ctx.sql("SELECT SUM(x) FROM t").await.expect("sql");
    // "non-bit-compatible types: Binary → Int64" when wrapping the stripped Partial.
fn try_acquire_budget(
/// Caller contract: `sort_fields.len() == sort_orders.len()`. The Java side
                input: None,
            "FetchRel without count_mode → false"
            .expect("widened query executes without stats-merge failure");
        );
        .with_physical_optimizer_rules(crate::agg_mode::physical_optimizer_rules_without_combine())
/// SessionContextHandle struct stays uniform with the shard-mode variant.
    use std::sync::Arc;
            let mut writer = ArrowWriter::try_new(file, schema, None).unwrap();
        let table = MemTable::try_new(Arc::clone(&schema), vec![vec![batch]]).expect("memtable");
    use datafusion::logical_expr::{Expr, SortExpr};
    use datafusion::execution::cache::CacheAccessor;
        );
    // If DF abandons partial agg midstream, the partial state sent to the coordinator is
    /// from CPU executor threads.
        assert_eq!(
fn resolve_register_name(table_name: &str, _plan_bytes: &[u8]) -> String {
        phantom_reservation: phantom,
        };
        // Empty shard → empty inferred schema (0 fields).
    let schema = parquet_to_arrow_schema(
        .expect("batch");
            .with_file_extension(".parquet")
    inferred: &arrow::datatypes::SchemaRef,
    delegated_predicate_count: i32,
    /// number of columns". The runtime-global file statistics cache is keyed by path+size+mtime
                expression: None,
                .with_cache(Some(stats_cache.clone())),
                native_bridge_common::log_debug!(
    fn test_substrait_has_fetch_rel_without_fetch() {
pub async unsafe fn create_session_context_indexed(
        ctx.register_table("t", Arc::new(table)).expect("register");
        aggregate_mode: crate::agg_mode::Mode::Default,
        .iter()
            let ascending = order.eq_ignore_ascii_case("asc");
#[cfg(test)]
            Arc::clone(&schema),
        );
        },
                offset_mode: None,
    use prost::Message;
        expected
        assert_eq!(
    let inferred_field_count = inferred.fields().len();
        }
        // producer emits for Sort(fetch=10, ...) from OpenSearchTopKRewriter.
    }
pub async unsafe fn create_session_context(
pub unsafe fn close_session_context(ptr: i64) {
            .unwrap()
    let global_pool = runtime.runtime_env.memory_pool.clone();
        .parquet
        crate::query_tracker::QueryType::Shard,
    );
    pub(crate) prepared_plan: Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
    // already covers every base_schema column.
        let narrow_tbl = Arc::new(
/// Returns true if the Substrait plan bytes contain a FetchRel (Sort+Limit node).
        // Each query registers its own shard store under the same bare file:// scheme.
    /// `resolve_register_name` still returns the logical table name. A future upstream merge that
                }))),
        let state = SessionStateBuilder::new()
        state_builder =
    if !shard_view.sort_fields.is_empty() {
    pub object_metas: Arc<Vec<ObjectMeta>>,
    };
    let physical_plan = dataframe.create_physical_plan().await?;
        .unwrap_or(query_config.target_partitions);
    // TODO: re-enable once DataFusion's Statistics::try_merge tolerates a column-count delta.
        table_name: table_name.to_string(),
    } else {
            dir.path(),
            "non-TopK queries must retain DF default threshold"
    execution::context::SessionContext,
        use substrait::proto::{plan_rel, Plan, PlanRel, Rel, SortRel};
                .skip_partial_aggregation_probe_ratio_threshold,
        log::warn!("widen_schema_from_plan: no base_schema found for table '{}' in plan — skipping widening", table_name);
        // 1. NARROW read first: registers the table at the narrow (1-col) schema and, with
        use substrait::proto::rel::RelType;
                Arc::new(StringArray::from(vec!["x"])),
            query_context,
    let handle = SessionContextHandle {
}
    /// When set, indicates this session uses the indexed execution path with filter delegation.
}
/// binds against it.
        use substrait::proto::rel::RelType;
        assert!(
            rr.input.as_ref().map_or(false, |r| rel_has_fetch(r))
        let inferred = Arc::new(Schema::new(vec![
    sort_orders: &[String],
    };
    #[test]
        let plan = to_substrait_plan(&logical, &ctx.state()).expect("substrait plan");
        if has_topk {
    pub table_name: String,
        context_id,
        use prost::Message;
        table_name.len()
/// Creates a worker-mode SessionContext: no shard view, no listing table, no parquet
    table_name.to_string()
            Field::new("a", DataType::Int64, true),
    pub sort_fields: Vec<String>,
    let plan: substrait::proto::Plan = match prost::Message::decode(plan_bytes) {
            ListingTableUrl::parse(format!("file://{}", dir.path().to_str().unwrap())).unwrap();
                    std::mem::discriminant(other)
        );
        // Workers execute a shuffle-fed join/agg fragment, never a shard TopK Substrait plan, so
    /// Detected once in `create_session_context` from plan_bytes and reused in
/// - Nulls placement mirrors Lucene's general default (ASC → NULLS FIRST,
/// TODO: Once AnalyticsCore supports a versioned flag/hint mechanism, replace this
        deleted_doc_filtering_required: false,
    #[test]
/// The OpenSearch writer enforces this sort per segment, so the claim is
        for name in ["a", "b"] {
            dir.path(),
        use object_store::memory::InMemory;
        });
    let query_context = QueryTrackingContext::new(
        // Build: FetchRel(count=10) wrapping SortRel — same as what DataFusion Substrait
    use datafusion_substrait::logical_plan::producer::to_substrait_plan;
 * compatible open source license.
    #[test]
///
    let placeholder_path = ListingTableUrl::parse("file:///").map_err(|e| {
    /// Empty-shard case: a shard with zero parquet files yields an empty inferred schema, but the
            .with_runtime_env(Arc::new(runtime_env))
    /// Regression guard for the merge-resolution of #21822's multi-index `register_name` logic:
            e
    /// (`IndexedTableProvider` `output_ordering`) and by the indexed path's
            let f = result.field_with_name(name).expect("column present");
        use substrait::proto::rel::RelType;
        pool,
        let result = widen_schema_from_plan(&ctx, &[], "t", &schema);
    let stats_cache = runtime.runtime_env.cache_manager.get_file_statistic_cache();
            "create_worker_session_context: failed to build runtime env: {}",
    pub query_context: QueryTrackingContext,
                input: Some(sort_rel),
        )
        // One file with the narrow schema (column "a" only), one with the widened schema (a + b).
        assert_eq!(total, 2, "widened scan must read both files");
    runtime: &DataFusionRuntime,
    let first_meta = shard_view.object_metas.first()?;
            Some(RelType::Aggregate(a)) => a.input.as_ref().map_or(false, |r| rel_has_fetch(r)),
        let inferred = Arc::new(Schema::empty());
    sort_fields: &[String],
    use datafusion_substrait::logical_plan::consumer::{
    let list_file_cache = Arc::new(DefaultListFilesCache::default());
    }
    let query_context = QueryTrackingContext::new(
    })?;
        let sort_rel = Box::new(Rel {
        Arc::new(arrow::datatypes::Schema::empty())
    if ptr != 0 {
            state_builder.with_physical_optimizer_rule(Arc::new(ScopedPageIndexOptimizer::new(
        use prost::Message;
/// Returns `None` when the index has no `index.sort.field` configured (the input
        e
    );
/// to reintroduce plan-bytes extraction must change THIS function, tripping
    crate::udf::register_all(&ctx);
    }
    let mut state_builder = SessionStateBuilder::new()
///   lookup against case-sensitive Arrow schemas. `from_name` preserves case.
            1.0,
/// Creates a SessionContext configured for indexed execution with filter delegation.
            .build();
    pub writer_generations: Arc<Vec<i64>>,
    let inferred: arrow::datatypes::SchemaRef = if shard_view.object_metas.is_empty() {
    /// union) table schema must not fail planning with "Cannot merge statistics with different
        use datafusion::datasource::file_format::parquet::ParquetFormat;
/// lengths agree.
        );
) -> Option<crate::query_budget::QueryMemoryBudget> {
    /// segment-reversal optimization.
    shard_view: &ShardView,
    } else {
            .expect("prepare_partial_plan succeeds");
        .memory_pool()
/// That would be cleaner and avoid re-parsing the plan bytes, but requires a
        parquet_meta,
            .with_object_store_registry(Arc::new(DefaultObjectStoreRegistry::new()))
}
            .expect("sql")
        };
        .map(|(name, order)| {
        query_config,
            2,
    pub table_path: ListingTableUrl,
        prepared_plan: None,
    })?;
        let store_b: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
        .as_ref()
            Expr::Column(Column::from_name(name.clone())).sort(ascending, nulls_first)
    /// Writer generation per object_metas entry (parallel arrays). Sourced from the
            !substrait_has_fetch_rel(&bytes),
    .ok()
    // resolve_register_name for why we do NOT reverse-engineer this from the plan bytes. The
        let df = ctx.sql("SELECT x FROM \"input-7\"").await.expect("sql");
    let mut runtime_env_builder = RuntimeEnvBuilder::from_runtime_env(&runtime.runtime_env);
    pub query_config: DatafusionQueryConfig,
        config.target_partitions,
pub async unsafe fn create_worker_session_context(
    /// Parallel to `sort_fields`. Each entry is `"asc"` or `"desc"` (lowercase).
    let query_memory_pool = query_context
///
    // infer_schema calls DFParquetMetadata::fetch_metadata with PageIndexPolicy::Optional
            }))),
            .into_unoptimized_plan();
            config
        // does not leak into the other.
    #[test]
        );
    // Register default ListingTable for parquet scans.
    // Then derive `target_schema` and wrap with RelabelExec from the stripped plan's actual
/// `with_file_sort_order(...)` entirely.
use crate::datafusion_query_config::DatafusionQueryConfig;
        None => false,
            .build()
    // can apply PartialReduce without re-scanning the physical plan.
            "Join rel → false (no TopK in shard fragment with Join)"
    context_id: i64,
                rel_type: Some(plan_rel::RelType::Rel(*join_rel)),
///   normalization (`col("EventTime")` → `"eventtime"`), which silently fails
                .options()
/// Configuration for indexed execution with filter delegation, provided by Java.
    let handle = &mut *(ptr as *mut SessionContextHandle);
    error!(
    let table_config = ListingTableConfig::new(shard_view.table_path.clone())
    async fn register_name_uses_logical_table_not_plan_placeholder() {
        assert_eq!(resolve_register_name("my_index", &[]), "my_index");
            let batch = RecordBatch::try_new(Arc::clone(&schema), cols).unwrap();
/*
    }
    pub(crate) aggregate_mode: crate::agg_mode::Mode,
        .with_config(config)
    // function name" because df_execute_with_context reuses this handle's ctx instead
    }
        use substrait::proto::expression::literal::LiteralType;
/// Uses the `datafusion-substrait` consumer's `from_substrait_named_struct` for type conversion
/// Creates a SessionContext with per-query RuntimeEnv and registers the default
            indexed_config: None,
        global_pool.clone(),
        plan.encode(&mut plan_bytes).expect("encode");
    pub ctx: SessionContext,
            ListingOptions, ListingTable, ListingTableConfig, ListingTableUrl,
        .with_schema(resolved_schema);
    let phantom_reservation = try_acquire_budget(runtime, &global_pool, &shard_view, &query_config);
    use datafusion::common::Column;
        error!("create_session_context: failed to build runtime env: {}", e);
            dir: &std::path::Path,
) -> Result<i64, DataFusionError> {
                meta.clone(),
                common: None,
    let consumer = DefaultSubstraitConsumer::new(&extensions, &state);
    /// Dropped when the handle is closed, releasing the capacity.
    // empty-shard-aware schema inference + plan widening happens just below; no infer_schema here.
/// (which would break wire compatibility with older nodes during rolling upgrades —
/// rather than the real index, so it would register the shard table under the wrong name. The
            .split_file_groups_by_statistics = true;
        // base_schema for "t" = [a (Int64), b (Utf8)].
        .map_err(|e| {
    // Strip first on the raw physical plan so `force_aggregate_mode(Partial)` can find the
    }
                input: None,
    // `target_partitions` on the listing options drives the sort-aware bin-packer in
    let df_schema = match from_substrait_named_struct(&consumer, &base_schema) {
            .infer_schema(&ctx.state(), &shard_view.table_path)
        assert_eq!(
            has_topk: false,
    }
        config.batch_size,
    let stripped = crate::agg_mode::apply_aggregate_mode(
    let target_schema = crate::schema_coerce::coerce_inferred_schema(stripped.schema());
    /// IO runtime handle for bloom filter reads and other async I/O dispatched
        .with_config(config)
        });
            vec![
    let state = ctx.state();
    plan.relations.iter().any(|pr| match pr.rel_type.as_ref() {
        .as_ref()
    Ok(())
    );
) -> Result<i64, DataFusionError> {
        use substrait::proto::expression::{Literal, RexType};
use crate::scoped_index_optimizer::ScopedPageIndexOptimizer;
            )));
            Field::new("b", DataType::Utf8, true),
    /// another shard's store and failed with "No such file or directory".
        // Register a table whose schema is a subset of `inferred` below.
    });
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
    query_config: DatafusionQueryConfig,
        let bytes = plan.encode_to_vec();
            ctx,
    #[tokio::test]
}
    let mut runtime_env_builder =
            "prepare_partial_plan: failed to decode Substrait: {}",
}
        sort_fields: shard_view.sort_fields.clone(),
        ctx.register_table("t_narrow", narrow_tbl).unwrap();
                );
            writer_generations: Arc::new(vec![]),
    let extensions = Extensions::default();
    /// Empty when the index has no `index.sort.field`. Consumed by the vanilla path
    /// Aggregate execution mode for distributed partial/final stripping.
        let batch = RecordBatch::try_new(
        // 2. WIDENED read reusing the SAME cache. This is what create_session_context does after
            .with_collect_stat(true);
                    "substrait_has_fetch_rel: {:?} — no TopK fetch",
            .with_collect_stat(false); // mirrors the fix in create_session_context for widened tables
    {
    use substrait::proto::Plan;
mod tests {
            Some(RelType::Project(p)) => p.input.as_ref().map_or(false, |r| rel_has_fetch(r)),
    let cache = runtime.runtime_env.cache_manager.get_file_metadata_cache();
    Ok(Box::into_raw(Box::new(handle)) as i64)
    }
        indexed_config: None,
        table_path: placeholder_path,
        match rel.rel_type.as_ref() {
        // from the shared env but with a fresh object-store registry.
/// All shard-specific fields on the handle are populated with empty defaults so the
        let mut plan_bytes = Vec::new();
    // Cache key is meta.location (Path) — same key infer_schema uses.
    handle.aggregate_mode = crate::agg_mode::Mode::Partial;
            .with_schema(Arc::clone(&wide));
        } else {
            }))),
    )
        assert_eq!(result.fields().len(), 1);
            .await
        Err(_) => return Arc::clone(inferred),
    /// Shard fragments never have Join above a TopK FetchRel, so this correctly returns false.
    let expected = if force_view {
        shard_view.sort_fields.len()
    pub deleted_doc_filtering_required: bool,
    let plan = Plan::decode(substrait_bytes).map_err(|e| {
/// shard-scan instruction node (see `ShardScanWithDelegationHandler`).
    log_debug!(
                register_name, e
    {
    pub requests_row_ids: bool,
        ]));
/// This is metadata, not a sort: it tells DataFusion the parquet files are already
            vec![Arc::new(Int64Array::from(vec![1i64]))],
        let has_topk = true;
        // there is no FetchRel to detect — the upstream TopK-CSS PartialReduce path does not apply here.
                error!("create_session_context: failed to infer schema: {}", e);
        let ctx = SessionContext::new();
            sort_orders: vec![],
        error!(
    let ctx = SessionContext::new_with_state(state);
use object_store::ObjectMeta;
                r#type: 0,
    config.options_mut().execution.batch_size = query_config.batch_size;
            .with_listing_options(widened_opts)
        &datafusion::execution::cache::TableScopedPath {
        // DataFusion rewrites top-level strings to view types but not LIST children. Apply the
                offset_mode: None,
        let got_b = env_b
    let runtime = &*(runtime_ptr as *const DataFusionRuntime);
                Arc::clone(&metadata_cache),
    #[tokio::test]
    requests_row_ids: bool,
        );
                advanced_extension: None,
        let ctx = SessionContext::new_with_state(state);
    let effective_batch_size = phantom_reservation
            .expect("per-query runtime env b");
        query_context,
        build_file_sort_order(&shard_view.sort_fields, &shard_view.sort_orders)
    }
    execution::cache::cache_manager::CachedFileList,
            aggregate_mode: Mode::Default,
pub(crate) fn build_file_sort_order(
    config.options_mut().execution.target_partitions = effective_partitions;
        // Workers scan registered StreamingTables, not a sorted parquet index, so there is no
    }
        // FetchRel exists but count_mode is None — not a real limit, should not trigger TopK.
        let shared = RuntimeEnvBuilder::new()
}
pub struct IndexedExecutionConfig {
        CachedFileList::new(shard_view.object_metas.as_ref().clone()),
    // Acquire memory budget from cached parquet metadata (zero I/O).
        .as_any()
    /// the shard's table MUST register under the planner's logical name, never under whatever the
            fetch_rel, plan_rel, Expression, FetchRel, Plan, PlanRel, Rel, SortRel,
            Some(RelType::Filter(f)) => f.input.as_ref().map_or(false, |r| rel_has_fetch(r)),
            path: shard_view.table_path.prefix().clone(),
        assert!(substrait_has_fetch_rel(&bytes), "FetchRel(count=10) → true");
    let handle = SessionContextHandle {
    // On cache miss (first query for this shard), skip — subsequent queries benefit.
///
                .skip_partial_aggregation_probe_ratio_threshold = 1.0;
        let query_context =
    let ctx = SessionContext::new_with_state(state);
    /// plan's first `NamedTable` happens to be. Builds a plan whose only `NamedTable` is a stage
    // path (not schema), so a narrow cached Statistics can be merged against the widened one,
    // — otherwise RelabelExec would carry the pre-strip type tag (e.g. Int64) and fail with
    fn test_skip_partial_agg_default_when_no_topk() {
/// Widens `inferred` to the plan's `base_schema` (for index-pattern / alias scans) so the
///   DESC → NULLS LAST). `index.sort.missing` can override this per field but
    substrait_bytes: &[u8],
        ctx.register_table("t", Arc::new(table)).expect("register");
    let effective_partitions = phantom_reservation
        let global_pool = ctx.runtime_env().memory_pool.clone();
/// Notes for readers:
/// ListingTable provider for parquet scans.
        let batch = RecordBatch::try_new(
    // the indexed path additionally UNWRAPS them before execution.
        let _ = Box::from_raw(ptr as *mut SessionContextHandle);
    execution::memory_pool::MemoryPool,
        let got_a = env_a
    /// reproduces the straddle (narrow read seeds the cache, widened read reuses it) and asserts
            }],
    let runtime_env = runtime_env_builder.build().map_err(|e| {
            ListingTable::try_new(widened_cfg)
        );
    let cached = cache.get(&first_meta.location)?;
};
    use datafusion::execution::runtime_env::RuntimeEnvBuilder;
        crate::schema_coerce::transform_schema_to_view_recursive(&expected)
        // The plan names a STAGE PLACEHOLDER, not the shard's real index.
        table_path: shard_view.table_path.clone(),
    .await?;
            .map_err(|e| {
        // And for single-index queries with empty plan bytes, the logical name is used directly.
    /// the widened scan plans + executes.
        object_metas: shard_view.object_metas.clone(),
            .map_err(|e| {
        requests_row_ids,
                common: None,
        let result = widen_schema_from_plan(&ctx, &plan_bytes, "t", &inferred);
            }
            datafusion::physical_optimizer::optimizer::PhysicalOptimizer::new().rules
        // index sort to plumb (upstream added these fields for the shard-scan path; empty here).
        .zip(sort_orders.iter())
            ListingTable::try_new(narrow_cfg)
    config.options_mut().execution.target_partitions = query_config.target_partitions;
        //    widen_schema_from_plan. The fix sets collect_stat(false) because the schema was widened;
    /// Phantom reservation holding pool capacity for untracked memory.
    physical_plan::ExecutionPlan,
    table_name: &str,
        return None;
    async fn prepare_partial_plan_sets_mode_and_stores_plan() {
        let runtime_env = RuntimeEnvBuilder::new().build().expect("runtime env");
        use datafusion::execution::object_store::{
/// state — no throwaway SessionState needed.
            "input-7",
    query_config: DatafusionQueryConfig,
        // Sort without fetch → no FetchRel → false
            None => false,
    use datafusion::datasource::physical_plan::parquet::metadata::CachedParquetMetaData;
        let rows = ctx
/// ALWAYS the planner's logical table name (alias / index pattern / index), which the coordinator
) -> Result<(), datafusion::common::DataFusionError> {
                common: None,
        }
                Arc::clone(&shard_view.store),
/// metadata. The worker's substrait plan reads only from named-input streams that are
/// `SortPreservingMergeExec` replaces `SortExec`, and `sort_prefix` TopK fires.
        .memory_pool()
    #[tokio::test]
            ..Default::default()
    // Register OpenSearch UDFs (parse, item, mvappend, mvfind, mvzip, convert_tz, …)
            name: &str,
    // Final/Partial pair without a RelabelExec wrapper at the root pre-empting the walk.
    datasource::file_format::parquet::ParquetFormat,
        Ok(s) => s,
            io_handle: tokio::runtime::Handle::current(),
/// stripping via `agg_mode::apply_aggregate_mode`, and stores the result
                .options_mut()
            e
    use prost::Message;
            .with_physical_optimizer_rules(
            Arc::new(MemTable::try_new(Arc::clone(&schema), vec![vec![batch]]).expect("memtable")),
            relations: vec![PlanRel {
        // Even though the plan's NamedTable is "input-7", the logical table name must win.
                Arc::new(Int64Array::from(vec![2i64])),
    )?;
            e
        .execution
    deleted_doc_filtering_required: bool,
        let plan = Plan {
        assert_eq!(handle.aggregate_mode, Mode::Partial);
    let state = state_builder.build();
        prepare_partial_plan(&mut handle, &substrait_bytes)
        .with_file_extension(".parquet")
    }
        .map(|b| b.batch_size)
        has_topk: false,
/// unchanged when no plan is supplied, no matching base_schema exists, or this shard already
        let registered_schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int64, true)]));
            Some(other) => {
    if has_topk {
            .await
                .unwrap()
    fn test_substrait_has_fetch_rel_with_fetch_no_count_mode() {
            rel_type: Some(RelType::Sort(Box::new(SortRel {
    );
///   the override isn't propagated yet. A wrong nulls claim at worst causes
            let _ = crate::indexed_table::parquet_bridge::load_parquet_metadata_with_meta(
            .execution
            .await
/// reused in `prepare_partial_plan` without re-scanning the physical plan.
    crate::query_budget::acquire_budget_from_metadata(
                false
    // on this session so the substrait converter at execute_with_context can resolve
        env_a.register_object_store(&file_url, Arc::clone(&store_a));
        substrait.encode(&mut plan_bytes).expect("encode");
            rel_type: Some(RelType::Sort(Box::new(SortRel {
    let Some(base_schema) = crate::api::base_schema_for_table(&plan, table_name) else {
        let dir = tempfile::tempdir().unwrap();
        //    collect_stat(true), seeds the shared cache with a 1-column Statistics for narrow.parquet.
        assert_eq!(handle.aggregate_mode, Mode::Default);
                .unwrap()
    );
///   DataFusion's per-file chain validator to reject the ordering and fall back
            )
                    "create_session_context: failed to create listing table: {}",
        use object_store::ObjectStore;
    // SortMergeJoinExec instead of the non-spillable HashJoinExec build.
        context_id,
        Arc::clone(&shard_view.store),
    /// placeholder (`input-7`) — the exact case where reverse-engineering the name from plan bytes
            "env_b must resolve to its own store"
 *
    /// (the removed `first_named_table_name` approach) would pick the wrong name — and asserts
        let substrait = to_substrait_plan(&plan, &ctx.state()).expect("to_substrait");
    };
use log::error;
    // Empty shard: skip infer_schema (errors on zero files); widen_schema_from_plan
    crate::udf::register_all(&ctx);
///
    // fragment means OpenSearchTopKRewriter fired. Stored on the handle so prepare_partial_plan
            "env_a must resolve to its own store"
    config.options_mut().execution.parquet.pushdown_filters =
            DefaultObjectStoreRegistry, ObjectStoreRegistry,
    use datafusion::datasource::MemTable;
        .with_runtime_env(Arc::from(runtime_env))
    let runtime_env = runtime_env_builder.build().map_err(|e| {
        use substrait::proto::rel::RelType;
        .map(|p| p as Arc<dyn MemoryPool>);
        .options()
    /// Java-side catalog snapshot via `create_reader`. Authoritative for stamping
/// Attempt to acquire a memory budget using cached parquet metadata.
    crate::udaf::register_all(&ctx);
    let cached_parquet = cached
                .execution
use crate::api::{DataFusionRuntime, ShardView};
use std::sync::Arc;
                        nullable: false,
        .with_collect_stat(true)
/// Single-shard (SINGLE aggregate mode) never has `has_partial_aggregate=true` so this
    if let Some(pool) = query_memory_pool {
    }
//! SessionContext lifecycle for instruction-based execution.
    // Augment with indexed config. The delegation marker UDFs (index_filter, delegation_possible)
        use substrait::proto::{plan_rel, FetchRel, Plan, PlanRel, Rel};
        assert!(
    pub sort_orders: Vec<String>,
///
        assert!(
        Ok(p) => p,
    );
        let inferred = crate::schema_coerce::transform_schema_to_view_recursive(inferred.as_ref());
            "wide.parquet",
        let total: usize = rows.iter().map(|b| b.num_rows()).sum();
        handle.has_topk,
            }],
        // Two per-query runtime envs, each derived the way create_session_context derives them:
            object_metas: Arc::new(vec![]),
        let stats_cache = Arc::new(DefaultFileStatisticsCache::default());
    let provider = Arc::new(
            }))),
        .expect("batch");
        let config = SessionConfig::new();
/// the existing wire contract and do not change format.
        // recursive form so predefined ARRAY<VARCHAR> fields bind as List<Utf8View>.
    handle.indexed_config = Some(IndexedExecutionConfig {
                .skip_partial_aggregation_probe_ratio_threshold,
        has_topk,
//!
    let expected = crate::schema_coerce::coerce_inferred_schema(Arc::new(expected));
        io_handle: tokio::runtime::Handle::current(),
    use crate::agg_mode::Mode;
            relations: vec![PlanRel {
            .with_listing_options(narrow_opts)
    #[tokio::test]
    has_partial_aggregate: bool,
        let mut buf = Vec::new();
                sorts: vec![],
        let wide: SchemaRef = Arc::new(Schema::new(vec![
            rel_type: Some(RelType::Fetch(Box::new(FetchRel {
        ctx,
        let registered_schema = Arc::new(Schema::new(vec![
        object_metas: Arc::new(Vec::new()),
    ctx: &SessionContext,
            !Arc::ptr_eq(&got_a, &got_b),
    let parquet_meta = cached_parquet.parquet_metadata();
    config.options_mut().optimizer.prefer_hash_join = query_config.prefer_hash_join;
    // on a cache miss — fetching full page index bytes. By pre-warming here with
        let env_b = RuntimeEnvBuilder::from_runtime_env(&shared)
            QueryTrackingContext::new(0, global_pool, crate::query_tracker::QueryType::Shard);
        error!(
        .with_physical_optimizer_rules(if has_partial_aggregate {
    pub indexed_config: Option<IndexedExecutionConfig>,
            .get_store(&file_url)
    // variants including decimals, nested structs, user-defined types). All fields are
    /// `prepare_partial_plan` to apply PartialReduce for CSS correctness.
        let mut config = SessionConfig::new();
}
    pool: &Arc<dyn MemoryPool>,
/// verifiable-by-construction (DataFusion also checks per-file min/max stats).
            Field::new("a", DataType::Int64, true),
        plan.encode(&mut plan_bytes).expect("encode");
            config
            .sql("SELECT a, b FROM t")
    /// Each per-query RuntimeEnv built the way create_session_context builds it must get its own
    /// QTF query phase: scan must emit shard-global `__row_id__`.
pub struct SessionContextHandle {
        // Must return inferred unchanged (Arc::clone, so pointer-equal).
            rel_type: Some(RelType::Fetch(Box::new(FetchRel {
    };
            .await
        let handle = SessionContextHandle {
    }
/// table is registered with every column the Substrait consumer expects. Returns `inferred`
        assert!(!substrait_has_fetch_rel(&[]), "empty bytes → false");
                left: None,
        &url::Url::parse("file://").unwrap(),
        aggregate_mode: crate::agg_mode::Mode::Default,
    let mut listing_options = ListingOptions::new(Arc::new(ParquetFormat::default()))
    // of building a fresh one.
        .fields()
            Some(RelType::Fetch(f)) => f.count_mode.is_some(),
            // TODO: enumerate remaining rel types explicitly and panic on unknown ones.
        let mut plan_bytes = Vec::new();
                common: None,
    list_file_cache.put(
        }
    /// Per-query tuning knobs (batch size, partitions, filter strategies, etc.)
    // Empty shard: loop is a no-op; infer_schema is also skipped below.
    // explicitly as logicalTableName on the shard-scan instruction node. See
    //
/// Registers the `delegated_predicate` UDF and stores the tree shape + predicate count
    let resolved_schema = widen_schema_from_plan(&ctx, plan_bytes, &register_name, &inferred);
        })?;
///
        // skip_partial must be disabled (1.0) when TopK is active — if DF abandons partial
        let schema = Arc::new(Schema::new(vec![Field::new("x", DataType::Int64, true)]));
                advanced_extension: None,
        let logical = ctx
    /// Collector leaf (reserved annotation id) into the decoded filter tree so deleted rows are
        let narrow: SchemaRef = Arc::new(Schema::new(vec![Field::new("a", DataType::Int64, true)]));
        );
    fn rel_has_fetch(rel: &substrait::proto::Rel) -> bool {
    pub io_handle: tokio::runtime::Handle,
        // Simulates the single shared global runtime_env (DataFusionRuntime.runtime_env).
