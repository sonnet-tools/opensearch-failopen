        &sort_fields,
            expr_to_bool_tree(expr, &schema, &state)
/// `MatchAllDocsQuery` whose per-RG collector emits the segment's liveDocs.
    // the `delegated_predicate` UDF marker whose body panics) and uses this
            descending: true,
        BoolNode::Collector { .. } => {}
        Some(permit),
        assert!(!should_reverse_segments(Some(&top), &fields, &orders));
        let context_id_early = handle.query_context.context_id();
        let top = TopSort {
    // create_session_context registered the provider under that name, so re-register under the
                    },
        },
        };
                    &segment.object_path,
        _projection: Option<&Vec<usize>>,
    // with IndexedTableProvider after plan decoding.
            other => panic!("expected And, got {:?}", other),
            let residual_pruning_predicate: Option<Arc<PruningPredicate>> = residual_expr
                            Arc::clone(&performance_provider_locks),
                                format!(
                          chunk,
                                    "FfmSegmentCollector::create(context_id={}, provider={}, writer_generation={}, doc_range=[{},{})): {}",
    }
        Some(extraction) => match Arc::unwrap_or_clone(extraction.tree) {
        assert!(!should_reverse_segments(Some(&top), &[], &[]));
    #[test]
        };
    let context_id = query_context.context_id();
        ])));
                .and_then(|e| residual_bool_to_physical_expr(&e.tree))
        object_metas: shard_view.object_metas.clone(),
}
                        Ok(eval)
        })
#[cfg(test)]
    let schema = cross_rt_stream.schema();
    let sort_fields = handle.sort_fields;
                assert!(matches!(children[1], BoolNode::Not(_)));
                            residual_expr.clone(),
                None,
            // Extract the residual (non-Collector children of top-level
///
                                .map(|(pos, &idx)| (idx, pos))
        let rt = tokio::runtime::Builder::new_current_thread()
        )
    };
    // non-empty table_name gate, so hash-shuffle WORKER sessions (empty object_metas but scanning
    build_pruning_predicate, PagePruneMetrics, StatsPruneTree,
                        let resolved = tree.resolve(&per_leaf).map_err(|e| {
/// the query wants, so iterating them tail-first feeds the largest values to a
}
            let prune_tree_config = extraction
        BoolNode::Collector { annotation_id: id }
    });
//!   3. `collectDocs(collector, min, max, out)` FFM upcall (once per row group).
        sort_orders: sort_orders.clone(),
/// Decide whether to flip segment iteration order for the indexed scan.
    } else {
            )
                    Arc::clone(&pruning_predicates),
    let extraction = match filter_expr {
    let partition_weight = num_partitions.max(1) as u32;
    fn extraction_of(tree: BoolNode) -> Option<ExtractionResult> {
            _ => panic!("expected AND, got {:?}", r),
                            segment.arrow_schema.clone(),
                    children[0],
    }
    let state = ctx.state();
    // Apply aggregate mode stripping when prepare_partial_plan was called (engine-native-merge).
};
            // on_batch_mask. Also covers an unfoldable constant (e.g. mktime('...') >
    // below. The closures pass it through every FFM upcall so Java can route each
    common::DataFusionError,
    }
            > = {
            // Predicate-only scan: page-pruned universe, residual applied in
    };
/// scheduled by `compute_assignments` — is the *whole* point of this optimization
                .as_ref()
        // PruningPredicate cache exactly like a plain Predicate — DF prunes pages
    top_sort: Option<&TopSort>,
            };
    // registers the indexed-only index_filter / delegation_possible UDFs.
            object_path: object_store::path::Path::from(format!("seg-{}.parquet", global_base)),
        .filter_map(|expr| {
use crate::indexed_table::index::RowGroupDocsCollector;
    // registered StreamingTables, with an empty table_name) are NOT short-circuited to zero rows.
    // which then executes the marker UDF and errors.
                .as_ref()
    };
            cross_rt_stream.schema(),
                            )),
                            per_leaf.push((
        assert_eq!(
    let catalog_descending = catalog_order.eq_ignore_ascii_case("desc");
    // Collector injection below.
                          stats_prune_tree: Option<&Arc<StatsPruneTree>>| {
use crate::indexed_table::page_pruner::PagePruner;
//! Indexed query executor — decodes substrait, classifies the filter tree,
        assert_eq!(single_collector_id(&out.tree), Some(7));
                        });
                Ok(TreeNodeRecursion::Continue)
            BoolNode::Collector { annotation_id } if *annotation_id == LIVE_DOCS_MATCH_ALL_ANNOTATION_ID
            let residual_expr = residual_bool
                datafusion::logical_expr::Distinct::On(on) => current = on.input.as_ref(),
        let df = rt.block_on(ctx.sql(sql)).expect("sql");
                let mut map = std::collections::HashMap::with_capacity(leaves.len());
    let schema = crate::session_context::widen_schema_from_plan(
        let _ = expr.apply(|node| {
use crate::helper::{
                            Arc::clone(&segment.metadata),
                                    Some(Arc::new(collector) as Arc<dyn RowGroupDocsCollector>)
        // engine-native-merge: borrow the partial-state schema from the prepared plan so the
    }
            crate::query_tracker::QueryType::Shard,
        }
/// `global_base`. For the round trip to hold, both phases must agree on each
        // AND(AND(C₁, C₂), AND(C₃, C₄)) → no residual
            _ => FilterClass::None,
        "DataFusion physical plan:\n{}",
                    _ => Some(BoolNode::And(residuals)),
                ),
        .expect("register_batch");
 */
    runtime: &DataFusionRuntime,
        .map_err(|e| DataFusionError::Execution(format!("execute_stream: {}", e)))?;
use crate::indexed_table::segment_info::build_segments;
        let out = ensure_live_docs_coverage(extraction_of(collector(3)));
            LogicalPlan::Distinct(d) => match d {
            BoolNode::And(children) => {
            Some(permit),
    /// A narrow projection still collects exactly the columns the query touches
        assert!(extract_single_collector_residual(&collector(10)).is_none());
                            )),
    // IndexedExec partitions (derived from num_partitions), not DataFusion's, but
            other => panic!("expected unchanged And, got {:?}", other),
/// counter), so negative ids can never collide. Must match
    }
        ])));
                    BoolNode::Collector { annotation_id: 1 }
    common::tree_node::{TreeNode, TreeNodeRecursion},
        match current {
        // column chunk as a single page → "output too small for decompressed data"
    physical_expr::PhysicalExpr,
    logical_expr::Expr,
            dummy_segment(30, 30),
        } else {
        // live-docs-filtered on the Java side; injecting a second collector would demote
        physical_plan
    let permit = gate.acquire_many(partition_weight.min(max_p)).await;
use crate::indexed_table::table_provider::{
    #[test]
    };
                }
                            .row_group_indices
}
                let col = match &leading.expr {
    }
                                    .clone(),
    cpu_executor: DedicatedExecutor,
/// Result of walking a logical plan looking for the leading top-of-plan ORDER BY.
        match out.tree.as_ref() {
/*
        let predicate_column_names = collect_predicate_column_names(extraction.as_ref(), &schema);
///
        assert_eq!(segs[0].max_doc, 42);
                names.iter().any(|n| n == expected),
}
            let tree = Arc::new(tree);
    }));
                                .row_group_indices
                            segment.arrow_schema.clone(),
        assert!(should_reverse_segments(Some(&top), &fields, &orders));
                          stats_prune_tree: Option<&Arc<StatsPruneTree>>| {
        }
            .enable_all()
        // pushed into the scan), where no Projection expression lists the columns
        self.schema.clone()
/// `TopK` first and parquet page stats prune the rest.
    // projection (→ OffsetIndex) are wired — a match()-only query still needs a
            runtime.runtime_env.memory_pool.clone(),
        let plan_schema: arrow::datatypes::SchemaRef = if let Some(prepared) =
                    &segment.metadata,
    }
                }
        .indexed_config
    table_name: String,
/// Builds per-leaf PruningPredicates from pre-collected leaf exprs.
        // AND(P₁, AND(C₁, AND(C₂, P₂))) → AND(P₁, P₂)
/// tracker (same as vanilla path) — `None` disables tracking and uses the
    // interpretable by `api::fetch_by_row_ids` (which builds its own segments from
        crate::query_tracker::set_cpu_runtime_handle(context_id, rt);
                            stats_prune_tree: stats_prune_tree.cloned(),
    let mut exprs = Vec::new();
                assert!(is_predicate(&children[0]));
        names.sort();
                                }
//!   4. `releaseCollector(collector)` when RG scan completes.
                assert_eq!(children.len(), 2);
    #[test]
            let mut providers: Vec<Arc<ProviderHandle>> = Vec::with_capacity(leaf_ids.len());
                            collector_opt,
    /// for decompressed data"), or underflows the read byte range. The
            // the residual has zero Collectors — no Literal(true) substitution
    });
        let plan = build_logical_plan("SELECT v FROM t ORDER BY ts DESC");
                assert!(matches!(children[1], BoolNode::Or(_)));
    physical_plan::ExecutionPlan,
            )),
    fn coverage_or_predicate_tree_wraps_in_and() {
            BoolNode::And(children) => {
    // Augment each segment's footer-only metadata with a scoped page index so
    let mut exprs = Vec::new();
        let wrapped = datafusion::physical_plan::stream::RecordBatchStreamAdapter::new(
    let store_url = ObjectStoreUrl::parse(format!("{}://{}", parsed.scheme(), parsed.authority()))?;
            }
            let collector_strategy = CollectorCallStrategy::TightenOuterBounds;
                assert!(is_live_docs_leaf(&children[0]));
                let leaves = extraction.tree.delegation_possible_leaves();
    );
        assert!(extract_single_collector_residual(&tree).is_none());
use std::sync::Arc;
    collect_predicate_exprs(&e.tree, &mut exprs);
        if let Some(rt) = cpu_executor.handle() {
        None => None,
            names.insert(field.name().to_string());
        // predicates stay as the residual. Classification must remain SingleCollector.
use crate::indexed_table::eval::{CollectorCallStrategy, RowGroupBitsetSource, TreeBitsetSource};
    }
        prepared_plan: None,
    names.into_iter().collect()
    substrait_bytes: Vec<u8>,
        cancellation_token: crate::query_tracker::get_cancellation_token(context_id),
            handle.query_context,
    let requests_row_ids = handle
        let plan = build_logical_plan("SELECT v FROM t WHERE id = 1 ORDER BY ts");
    collect_predicate_exprs(&e.tree, &mut exprs);
/// dispatcher to build a per-leaf `PruningPredicate` cache keyed by
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
/// Coordinator-assigned annotation ids are non-negative (`PlannerContext.nextAnnotationId`
        let top = TopSort {
        BoolNode::Predicate(Arc::new(BinaryExpr::new(left, Operator::Eq, right)))
                            &schema_for_pruner,
/// which is also unqualified). `descending` is `true` for `ORDER BY x DESC`.
    let url_str = table_path.as_str();
    }
    physical_optimizer::pruning::PruningPredicate,
struct PlaceholderProvider {
    let aggregate_mode = handle.aggregate_mode;
            // in the tree. Key = `Arc::as_ptr(expr) as usize` — the
        return false;
                    names.insert(col.name().to_string());
        let ts = analyze_top_sort(&plan).expect("expected Sort");
        let tree = BoolNode::And(vec![
    let Some(top) = top_sort else { return false };
                assert!(is_live_docs_leaf(&children[0]));
            parquet_size: 0,
                        for (idx, provider) in providers.iter().enumerate() {
    // executor drives ordering itself via IndexedExec.
 * this file be licensed under the Apache-2.0 license or a
    let ctx = build_query_session_context(&query_config, runtime_env, num_partitions, true);
    // ── analyze_top_sort / should_reverse_segments ────────────────────
    // Tree: None — BitmapTreeEvaluator walks the whole BoolNode in
        use datafusion::physical_plan::empty::EmptyExec;
    let classification_override = handle.indexed_config.map(|config| {
    fn analyze_top_sort_returns_none_for_function_sort_key() {
        let residual = extract_single_collector_residual(&out.tree).unwrap();
                .and_then(|expr| build_pruning_predicate(expr, Arc::clone(&schema_for_pruner)));
/// - AND trees (pure-DF / DelegationPossible): the match-all Collector is prepended at the root,
                });
        ]);
            BoolNode::And(children) => {
    // Extract context_id early so it can be captured by the per-segment closures
                assert_eq!(children.len(), 3);
            row_groups: vec![],
                    Expr::Column(c) => c.name.clone(),
}
/// Collect all `Predicate(expr)` leaves in DFS order. Used by the
        let fields = vec!["id".to_string()];
            (2, _) => FilterClass::Tree,
        shard_view.object_metas.as_ref(),
    // same name. Using table_name for a multi-index query leaves the scan unbound, so DataFusion
                if let Some(augmented) = load_scoped_page_index_cols(
            // Drop releases the Lucene Weight via `releaseProvider`.
        let tree = BoolNode::And(vec![collector(10), collector(11)]);
            for segment in segments.iter_mut() {
        reverse_segment_iteration_order(&mut segs);
            metadata,
        ));
            wrapped,
        );
    log_debug!(
//! builds providers per leaf, runs the query.
    let metadata_cache = state.runtime_env().cache_manager.get_file_metadata_cache();
                    descending: !leading.asc,
                                .enumerate()
    #[test]
/// Collector leaf and return its query bytes.
                );
        query_memory_pool,
use crate::indexed_table::bool_tree::residual_bool_to_physical_expr;
        store: Arc::clone(&store),
            );
            let logical_plan =
        match node {
        writer_generations: shard_view.writer_generations.clone(),
                Arc::new(map)
                    0 => None,
}
            handle.ctx,
                        create_provider(context_id, annotation_id)
                            stream_metrics.ffm_collector_calls.clone(),
        extraction
            single_collector_id(&out.tree),
/// For a tree classified as `SingleCollector`, walk it to find the single
        assert_eq!(segs[0].max_doc, 30);
                match residuals.len() {
    }
            let performance_provider_locks: Arc<
        reverse_segment_iteration_order(&mut segments);
            )
pub(crate) fn should_reverse_segments(
                .flatten();
    build_query_runtime_env_with_store, build_query_session_context, register_listing_table,
use crate::indexed_table::page_pruner::{
        }
        // its real multi-page one) corrupts the page read: arrow decodes the whole
        runtime,
                Arc::new(
/// segments). The `global_base` values are unrelated to that pruning win.
    strip_collectors(tree)
    };
        let top = TopSort {
/// TODO: extract shared logic with `execute_indexed_query` to avoid duplication.
            writer_generation: global_base as i64 + 1, // arbitrary, just to vary
    };
        .iter()
}
        let fields = vec!["id".to_string()];
                    return Some(id);
            vec!["id".to_string(), "ts".to_string(), "v".to_string()],
                    Arc::clone(&tree),
    // empty stream. Mirrors the guard in query_executor::execute_with_context — including the
            descending: true,
                            cost_predicate,
    let Some(catalog_order) = sort_orders.first() else {
        let left: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new("price", 0));
    fn table_type(&self) -> TableType {
    use std::sync::Arc;
        ]));
/// Returns `true` iff the catalog has a sort declaration, the query has a top-level
                build_prune_tree_config(&extraction.tree, &schema_for_pruner, &leaf_exprs);
        match out.tree.as_ref() {
            let prune_tree_config = if pruning_predicates.is_empty() {
    fn should_reverse_segments_no_query_sort() {
    // SessionContext already has RuntimeEnv, caches, memory pool, UDF from create_session_context_indexed.
    }
        store_url,
            BoolNode::And(vec![collector(2), collector(3)]),
            other => BoolNode::And(vec![live_docs_collector(), other]),
    let handle =
            node,
    fn reverse_segments_empty_is_noop() {
        Some(extraction) if extraction.tree.is_covered_by_live_docs() => {
        let schema = std::sync::Arc::new(
use std::collections::{HashMap, HashSet};
                ))
        Arc::clone(&shard_view.store),
    #[test]
                                segment.writer_generation,
                    segment.metadata = augmented;
        let ts = analyze_top_sort(&plan).expect("expected Sort");
        assert!(segs.is_empty());
                crate::substrait_consumer::from_substrait_plan(&handle.ctx.state(), &plan).await?;
        Arc::clone(schema),
    let dataframe = ctx.execute_logical_plan(logical_plan).await?;
                                )
                providers.push(Arc::new(
/// Collect leaf predicate exprs from the extraction tree in a single traversal.
        let _ = node.apply_expressions(|expr| {
                            .map_err(|e| {
    fn build_logical_plan(sql: &str) -> datafusion::logical_expr::LogicalPlan {
        prune_tree_config,
    let (factory, prune_tree_config): (EvaluatorFactory, _) = match classification {
                let (parquet_cols, offset_cols) = resolve_predicate_parquet_columns_pair(
    // SingleCollector: residual (non-Collector top-AND children) →
                .as_ref()
    //   In block-granular mode the evaluator's `on_batch_mask` applies
}
    #[test]
    fn should_reverse_segments_query_sort_on_non_leading_catalog_field() {
    use super::*;
            return extraction;
/// the shard has deletions. Returns the extraction unchanged when a correctness Collector already
    let mut names = HashSet::new();
            Some(LIVE_DOCS_MATCH_ALL_ANNOTATION_ID)
            }
                        let resolved = Arc::new(resolved);
        let projection_column_names = collect_plan_column_names(&logical_plan);
                prune_tree_config,
        // Match PR #22041 — `Column::from_name` is case-sensitive. If casing differs,
    fn residual_nested_and_strips_collectors() {
        let top = TopSort {
                            chunk.row_group_indices.iter().enumerate().map(|(pos, &idx)| (idx, pos)).collect(),
                    children.iter().filter_map(strip_collectors).collect();
    let query_config = Arc::new(handle.query_config);
    EvaluatorFactory, IndexedTableConfig, IndexedTableProvider, SegmentFileInfo,
    if let Some(rt) = cpu_executor.handle() {
        FilterClass::None => {
                                segment.writer_generation,
/// per-RG collector emits the segment's liveDocs).
        analyze_top_sort(&logical_plan).as_ref(),
                        Ok(eval)
    }
            };
                            page_pruner: pruner,
    #[test]
        // AND(C₁, AND(C₂, P)) → residual is P
            let extraction = extraction.as_ref().ok_or_else(|| {
    let (cross_rt_stream, abort_handle, _task_done) =
    // never consults supports_filters_pushdown and keeps the delegated_predicate FilterExec —
    }
    let logical_plan = crate::substrait_consumer::from_substrait_plan(&ctx.state(), &plan).await?;
    //   PhysicalExpr for `ParquetSource::with_predicate`. In
                };
use std::fmt;
        // is NOT covered and the live-docs collector must be AND'ed at the root.
        table_name: table_name.clone(),
/// `column` is the bare column name (no qualifier — we compare against `index.sort.field`
        // excludes deleted docs, so no live-docs collector is injected. Tree unchanged.
    let wrapped = RecordBatchStreamAdapter::new(schema, cross_rt_stream);
        // Pure-DF predicate AND tree: match-all becomes the correctness collector,
                ));
    schema: &SchemaRef,
        let p1 = pred();
                        // Build one collector per Collector leaf for this chunk.
        }
            let bloom_store = Arc::clone(&store);
                if let Some(id) = single_collector_id(child) {
        })
    Arc<BoolNode>,
 * compatible open source license.
            // fallback treats missing entries as "no pruning for this
    fn residual_nested_and_with_or_predicate() {
    // This makes the indexed executor produce Binary HLL state (Partial) instead of Int64 (Final).
            }
                            let collector = FfmSegmentCollector::create(
    log_debug!(
            BoolNode::And(vec![collector(11), pred()]),
    fn residual_deeply_nested_and() {
                    move |segment: &SegmentFileInfo,
pub async unsafe fn execute_indexed_with_context(
                assert_eq!(children.len(), 2);
            collector(1),
    // Deregister the default ListingTable (registered by create_session_context) — will be replaced
                .as_ref()
/// nodes that don't reorder rows or rewrite sort key columns. On reaching
        tree: Arc::new(tree),
    )
    }
    // Production uses df_execute_with_context which acquires the gate on IO for backpressure.
        // using the original expr; only the per-RG decision differs.
        let fields = vec!["id".to_string()];
                            bloom_config,
        let names = collect_plan_column_names(&plan);
    }
        let out = ensure_live_docs_coverage(extraction_of(BoolNode::Or(vec![
        match residual {
    //
        ),
}
    }
    // `ShardView.object_metas` in catalog order).
        log_debug!(
        });
        assert_eq!(classify_filter(&out.tree), FilterClass::SingleCollector);
use datafusion::{
                                segment.writer_generation, e
fn single_collector_id(tree: &BoolNode) -> Option<i32> {
            let schema_for_pruner = schema.clone();
            }
    #[test]
    // Resolve classification: from Java config if available, otherwise derive from tree
    #[test]
    let filter_expr = extract_filter_expr(&logical_plan);
        assert_eq!(ts.column, "id");
                                    chunk.doc_max,
                cpu_executor.clone(),
///
            let cost_predicate = query_config.cost_predicate;
                        .map_err(|e| DataFusionError::External(e.into()))?,
            single_collector_id(&out.tree),
    // Widen to the plan's base_schema so columns absent from this shard's parquet (cross-shard drift) are null-filled at read time.
///
    }
            Some(e) => classify_filter(&e.tree),
    //   RowSelection and drops residual-failing rows via pushdown.
    fn pred() -> BoolNode {
                            stats_prune_tree.cloned(),
                assert!(matches!(children[1], BoolNode::Not(_)));
    }
        let stream_handle = crate::api::QueryStreamHandle::with_session_context(
            dummy_segment(20, 10),
    fn analyze_top_sort_descends_through_limit() {
use crate::indexed_table::ffm_callbacks::{create_provider, FfmSegmentCollector, ProviderHandle};
                assert!(children.iter().all(is_predicate));
            _ => return None,
            column: "id".to_string(),
                        })?;
    let parsed = url::Url::parse(url_str)
            BoolNode::And(vec![pred(), BoolNode::Or(vec![pred(), pred()])]),
    let mut names = HashSet::new();
        // masks the deleted docs that NOT(C₂) would otherwise re-admit. Tree unchanged.
    datasource::{TableProvider, TableType},
    }
        .unwrap_or_else(|| table_name.clone());
        None => match &extraction {
            // Build prune_tree_config from the normalized tree. This ensures
        ),
    // DataFusion's FileScanConfig. The full URL includes the path
            //   - `on_batch_mask` refinement in block-granular mode.
            // performance-delegated leaves and no Collector at all.
                assert_eq!(children.len(), 2);
        });
    }
    let mut indices = HashSet::new();
        .map_err(DataFusionError::Execution)
                            stats_prune_tree.cloned(),
            sort_fields.first(),
///
        }
pub async fn execute_indexed_query(
/// the fetch path is to keep query-phase `global_base` at its catalog-order value.
    handle: crate::session_context::SessionContextHandle,
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
        "DataFusion logical plan:\n{}",
    ctx.deregister_table(&register_name)?;
    let schema = crate::schema_coerce::coerce_inferred_schema(schema);
///   top-level AND with the live set masks them regardless of the inner shape.
                    None => None,
                        let eval: Arc<dyn RowGroupBitsetSource> =
                            page_prune_metrics: Some(PagePruneMetrics::from_stream_metrics(
                            collector_strategy,
        _state: &dyn Session,
                        ));
}
    substrait_bytes: Vec<u8>,
/// Reserved annotation id resolved by the Java `FilterDelegationHandle` to a
    let register_name = crate::api::first_named_table_name(substrait_bytes.as_slice())
    ctx.register_table(&register_name, placeholder)?;
        let out = ensure_live_docs_coverage(extraction_of(BoolNode::Not(Box::new(collector(4)))));
                            .collect();
    #[test]
        _filters: &[Expr],
/// `shard_view` carries the segment's parquet paths (populated when the reader
/// Descends through `Projection`, `Limit`, `SubqueryAlias`, `Distinct`, and `Filter` —
                    create_provider(context_id, *annotation_id)
                }
    /// a real read — arrow decodes the whole chunk as one page ("output too small
    //   row-granular mode parquet narrows Collector-matching rows via
    let store = ctx.state().runtime_env().object_store(&table_path)?;
    }
        let plan = build_logical_plan("SELECT id FROM t ORDER BY id DESC");
        // AND(C, NOT(C₂)): the AND is covered by C — intersecting with C's live-only bitmap
    leaf_exprs: &[Arc<dyn PhysicalExpr>],
        };
    let query_context = handle.query_context;
    // from the global runtime for cross-query reuse.
        }
        }),
                            Arc::clone(&segment.metadata),
    }
    match tree {
            let residual_pruning_predicate: Option<Arc<PruningPredicate>> = residual_expr
                        result.map(|pp| (Arc::as_ptr(expr) as *const () as usize, pp))
            },
            let extraction = extraction.ok_or_else(|| {
        let plan = build_logical_plan("SELECT id FROM t ORDER BY abs(v)");
                            Arc::clone(&segment.metadata),
// TODO: remove once api.rs migrates to instruction-based path directly.
    fn coverage_skips_bare_collector() {
        let schema = Arc::new(Schema::new(vec![
    use datafusion::common::ScalarValue;
                    children[0],
    physical_plan::stream::RecordBatchStreamAdapter,
                        let mut per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> =
        &ctx,
    // Permit was acquired by the caller (ffm.rs) on the IO runtime before
            CrossRtStream::new_with_df_error_stream_cancellable(
                            )
                        Ok(eval)
///
            // None = no filter = full scan.
                        .or_insert_with(|| Arc::new(std::sync::OnceLock::new()));
                std::collections::HashMap<i32, Arc<std::sync::OnceLock<ProviderHandle>>>,
            p1,
    }
    // Derive the parquet pushdown predicate from the BoolNode tree.
    async fn scan(
use crate::datafusion_query_config::DatafusionQueryConfig;
    };
                                provider.key(),
        let empty_exec = EmptyExec::new(Arc::clone(&plan_schema));
            }
        pushdown_predicate,
            let plan = Plan::decode(substrait_bytes.as_slice())
    let df_stream = execute_stream(physical_plan.clone(), ctx.task_ctx())
                assert_eq!(children.len(), 2);
            other => panic!("expected unchanged Or, got {:?}", other),
                                .iter()
/// evaluator based on the Java-provided FilterTreeShape.
    let num_partitions = query_config.target_partitions.max(1);
        physical_plan,
    BoolNode::Collector {
/// Why not recompute global_base after reversing?
    fn coverage_no_filter_becomes_bare_live_docs_collector() {
                            residual_pruning_predicate.clone(),
            .unwrap();
                                stream_metrics,
    fn should_reverse_segments_matches_leading_field_opposite_direction() {
                "expected column `{expected}` in collected names {names:?}"
    fn coverage_pure_predicate_tree_prepends_collector_and_stays_single_collector() {
//!   1. `createProvider(annotation_id)` FFM upcall → `provider_key`  (once per
        );
            }
    }
        // Build a minimal ParquetMetaData. We never read it back in these tests.
        execute_indexed_with_context_inner(handle, substrait_bytes, cpu_executor, permit);
        crate::agg_mode::apply_aggregate_mode(physical_plan, aggregate_mode, handle.has_topk)?
    }
use crate::cross_rt_stream::CrossRtStream;
        reverse_segment_iteration_order(&mut segs);
        df.into_unoptimized_plan()
        let ts = analyze_top_sort(&plan).expect("expected Sort");
        query_context: crate::query_tracker::QueryTrackingContext::new(
        let plan = build_logical_plan("SELECT id FROM t");
    }
        let tree = BoolNode::And(vec![
        .collect();
                DataFusionError::Internal(
        let orders = vec!["asc".to_string(), "asc".to_string()];
        }
                                provider.key(),
// Kept as thin wrapper to make existing tests exercise execute_indexed_with_context
            (1, _) => FilterClass::SingleCollector,
                    move |segment: &SegmentFileInfo,
        }
    /// (projected `v` + filter `id` + sort `ts`) — the scoping benefit is retained.
    let io_handle = handle.io_handle;
    fn should_reverse_segments_matches_leading_field_same_direction() {
            column: "ID".to_string(),
        )
    // Per-shard hasDeletions signal from the Java ShardScan handlers; drives the live-docs
    catalog::Session,
            descending: true,
            let schema_for_pruner = schema.clone();
    /// load gives only these columns a REAL multi-page OffsetIndex; columns left
    }
    let mut segments = segments;
        return Ok(Box::into_raw(Box::new(stream_handle)) as i64);
                            pruning_predicates: Arc::clone(&pruning_predicates),
        let out = ensure_live_docs_coverage(None);
                if let Some(field) = schema.fields().get(col.index()) {
            }
        assert_eq!(ts.column, "id");
        let mut segs = vec![
    // ensure_live_docs_coverage). The coordinator's plan bytes are never modified.
fn collect_predicate_exprs(tree: &BoolNode, out: &mut Vec<Arc<dyn PhysicalExpr>>) {
                }
            let tree = Arc::try_unwrap(extraction.tree)
/// global pool.
            })?;
    // No sort-order declaration on the indexed path (empty slices) — the indexed
    // QTF safe: `reverse_segment_iteration_order` deliberately does NOT recompute `global_base`
                match single_collector_id(&extraction.tree) {
    fn should_reverse_segments_catalog_desc_query_asc() {
                          stream_metrics: &StreamMetrics,
use prost::Message;
        // Catalog: [a ASC, b ASC]; query: ORDER BY b DESC. Segments are monotonic on `a`
        writer_generations.as_ref(),
        };
            // resolve to always-true are omitted; the walker's
            BoolNode::And(children) => {
            // Correctness-delegated provider (eager). `None` when the query has only
    use datafusion::logical_expr::{Expr, LogicalPlan};
        // id must never collide.
        use datafusion::execution::context::SessionContext;
                            .iter()
use native_bridge_common::log_debug;
            BoolNode::Collector { .. } => None,
            // needed (unlike bool_tree_to_pruning_expr which handles arbitrary
        .map_err(|e| DataFusionError::Execution(format!("parse table_path URL: {}", e)))?;
//!   2. `createCollector(provider_key, seg, min, max)` FFM upcall → collector
) -> Result<i64, DataFusionError> {
        let tree = BoolNode::And(vec![collector(10), pred()]);
    // DF still wants a sane value for any post-scan operators it may add. The
                    .filter_map(|expr| {
) -> bool {
        // we don't claim the catalog ordering applies. Safe default: no reversal.
                            evaluator: Arc::new(BitmapTreeEvaluator),
        let tree = BoolNode::And(vec![
    let gate = cpu_executor.concurrency_gate().clone();
        }
        &sort_fields,
        ))
                // candidates before other predicates.
    Arc<HashMap<usize, Arc<PruningPredicate>>>,
    ) {
    let (segments, schema) = build_segments(
/// Build the `prune_tree_config` tuple from a BoolNode tree and schema.
                assert!(children
    Some((
    }
    }
    // NOTE: gate acquired on CPU here — acceptable for this deprecated benchmark-only path.
    let query_future =
        }
        // OR(C₁, C₂) is covered: the union of two live-filtered collector bitmaps still
                ),
    crate::cancellation::cancellable(token.as_ref(), context_id, query_future)
        assert!(LIVE_DOCS_MATCH_ALL_ANNOTATION_ID < 0);
    let tree = match extraction {
                                    context_id,
            BoolNode::And(children) => {
    ctx.deregister_table(&register_name)?;
                        let pruner = Arc::new(PagePruner::new(
                .as_ref()
            Ok(TreeNodeRecursion::Continue)
        sort_orders: shard_view.sort_orders.clone(),
                assert_eq!(children.len(), 2);
fn collect_leaf_exprs(extraction: Option<&ExtractionResult>) -> Vec<Arc<dyn PhysicalExpr>> {
        let orders = vec!["asc".to_string()];
                                chunk.doc_min,
            _ => panic!("expected AND, got {:?}", r),
    }
    fn residual_and_only_collectors_is_none() {
            context_id,
                    .iter()
pub const LIVE_DOCS_MATCH_ALL_ANNOTATION_ID: i32 = -2;
            BoolNode::And(children) => assert_eq!(children.len(), 2),
    match tree {
            max_doc,
        logical_plan.display_indent()
    let physical_plan = crate::relabel_exec::wrap_if_relabel_needed(physical_plan, target_schema)?;
                .await
                                    provider.key(),
    let token = crate::query_tracker::get_cancellation_token(context_id);
        assert!(ts.descending);
                .as_ref()
///   root — required under NOT, where leaf-level liveDocs filtering readmits deleted docs but a
            datafusion::arrow::record_batch::RecordBatch::new_empty(schema),
    .map_err(DataFusionError::Execution)?;
        let out =
async unsafe fn execute_indexed_with_context_inner(
        segments,
    }
    fn strip_collectors(node: &BoolNode) -> Option<BoolNode> {
        }
            Field::new("v", DataType::Int32, false),
            other => panic!("expected And, got {:?}", other),
            }
    }
                            .enumerate()
            } else {
                assert!(children[1..].iter().all(is_predicate));
                            residual_pruning_predicate.clone(),
            // trees). DelegationPossible leaves contribute their original_expr
    use crate::indexed_table::bool_tree::BoolNode;
        let plan = build_logical_plan("SELECT * FROM t WHERE v = 0 ORDER BY ts");
                                "tree.resolve for segment gen={}: {}",
};
        &state,
                Arc::new(
        io_handle: tokio::runtime::Handle::current(),
        BoolNode::DelegationPossible { original_expr, .. } => out.push(Arc::clone(original_expr)),
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
                if let Expr::Column(col) = e {
        Some(c) => c,
            // same `Arc<PhysicalExpr>` reaches the tree walker at
///   the correctness collector, so per-RG candidates are exactly the segment's live docs.
        // (the OR subtree has no collectors, so it rides as the residual).
        // Output-schema columns of every node: this is what each node actually
        );
        FilterClass::SingleCollector => {
    }
                .and_then(|expr| build_pruning_predicate(expr, Arc::clone(&schema_for_pruner)));
            // Performance-delegated provider locks (lazy). Built ONCE per query,
    session_ctx_ptr: i64,
    // the scheme+authority ("file:///").
        }
fn collect_plan_column_names(plan: &datafusion::logical_expr::LogicalPlan) -> Vec<String> {
}
    collect_predicate_column_indices_from_exprs(&exprs)
use crate::indexed_table::eval::single_collector::SingleCollectorEvaluator;
                    .iter()
        ctx.register_batch(
};
    // Empty shard: skip build_segments (errors on zero files) and emit an
    cpu_executor: DedicatedExecutor,
    fn collect_plan_column_names_includes_select_star_columns() {
                                rg_bloom_pruned: stream_metrics.rg_bloom_pruned.clone(),
    if let Some(h) = abort_handle {
    }
        // is what masks them.
                                bloom_filter_eval_time: stream_metrics
// with minimal changes.
    }
        has_topk: false,
            // (same push_not_down + flatten normalization applied above).
        let orders = vec!["asc".to_string()];
        assert_eq!(segs[0].global_base, 30); // C's catalog base, unchanged.
            collector(1),
                    schema_for_pruner.clone(),
    segments.reverse();
    //   both mask and residual post-decode, and pushdown is suppressed
        wrapped,
                                stream_metrics.ffm_collector_calls.clone(),
    let table_path = handle.table_path;
    fn schema(&self) -> SchemaRef {
                children.insert(0, live_docs_collector());
            for child in children {
        }
            "indexed_executor: reversing segment iteration (catalog leading sort={:?} {:?}, query opposite)",
            // Build one `PruningPredicate` per unique `Predicate` leaf
        }
    fn reverse_segments_single_keeps_its_base() {
                            match &correctness_provider {
        for field in node.schema().fields() {
        Arc::clone(tree),
        _ => None,
    fn coverage_skips_existing_single_collector_shape() {
                    BoolNode::Collector { annotation_id: 7 }
        };
impl TableProvider for PlaceholderProvider {
    let num_partitions = query_config.target_partitions.max(1);
    #[test]
                .and_then(residual_bool_to_physical_expr);
    // ── extract_single_collector_residual ─────────────────────────────
                                Some(provider) => {
                ),
        }
    // Build a fresh session context per query. The indexed path fans out via
    fn coverage_or_with_uncovered_branch_wraps_in_and() {
        match out.tree.as_ref() {
/// (newest-segment-first feeds TopK earlier and lets page stats prune older
        assert_eq!(segs.len(), 1);
        assert!(!should_reverse_segments(Some(&top), &fields, &orders));
/// Instruction-based indexed execution path. Consumes a pre-configured SessionContextHandle
 * The OpenSearch Contributors require contributions made to
                leaf_exprs
    load_scoped_page_index_cols, resolve_predicate_parquet_columns_pair,
        FilterClass::None => {
    // types. The target is schema_coerce::coerce_inferred_schema(physical_schema) — same
    #[test]
    let Some(e) = extraction else { return vec![] };
        }
        metadata_cache,
    fn injected_live_docs_id_is_negative_and_reserved() {
                            Arc::new(crate::indexed_table::eval::single_collector::FfmDelegatedBackendCollectorFactory),
/// catalog-order shard-global row ID space.
    fn dummy_segment(max_doc: i64, global_base: u64) -> SegmentFileInfo {
        let r = extract_single_collector_residual(&tree).unwrap();
/// guarantees live-only output ([`BoolNode::is_covered_by_live_docs`]). Shapes:
                prune_tree_config,
                }
        });
    }
    let physical_plan = dataframe.create_physical_plan().await?;
    #[test]
                          stats_prune_tree: Option<&Arc<StatsPruneTree>>| {
                assert_eq!(children.len(), 2);
                          chunk,
    #[test]
        emit_row_ids,
        }
            // Normalize: push NOTs to leaves (De Morgan) then flatten nested
            Arc::new(prepared.schema().as_ref().clone())
    }
pub(crate) struct TopSort {
                        }
                            Some(PagePruneMetrics::from_stream_metrics(stream_metrics)),
    #[test]
        &sort_orders,
    let placeholder: Arc<dyn TableProvider> = Arc::new(PlaceholderProvider {
//!      Collector leaf, once per query).
/// For a tree classified as `SingleCollector`, return the residual
                )
    pub descending: bool,
        query_config: Arc::unwrap_or_clone(query_config),
        // Residual (what DF evaluates) keeps both predicates.
use substrait::proto::Plan;
            //
                .as_ref()
/// single BoolNode). Recursively strips Collector leaves from nested
            LogicalPlan::Limit(l) => current = l.input.as_ref(),
            out.tree.as_ref(),
                assert!(is_live_docs_leaf(&children[0]));
                            pruner,
            let schema_for_pruner = schema.clone();
use crate::api::DataFusionRuntime;
                            )
/// `Arc::as_ptr` identity.
        .is_some_and(|c| c.requests_row_ids);
        let (cross_rt_stream, abort_handle, _task_done) =
    // — each segment retains its catalog-order base, so the row IDs query phase emits are still
        matches!(
use crate::indexed_table::substrait_to_tree::{
    top.descending != catalog_descending
        evaluator_factory: factory,
/// `global_base` is the additive offset used to compute the QTF `__row_id__`:
/// ORDER BY whose leading key matches the catalog's leading sort field by name, and
    // narrowing the partition-stream registration uses, so consumer-side StreamingTable
impl fmt::Debug for PlaceholderProvider {
    //   by the stream's `will_build_mask` guard (to avoid misalignment).
            let mut leaf_exprs: Vec<Arc<dyn PhysicalExpr>> = Vec::new();
};
                        let bloom_config =
use crate::indexed_table::metrics::StreamMetrics;
        ]);
            // leaf" (safe: universe bitmap).
        // `ORDER BY abs(v)` — leading sort key isn't a plain column. Catalog monotonicity
pub(crate) fn reverse_segment_iteration_order(segments: &mut [SegmentFileInfo]) {
/// rebuilds segments via `build_segments` against `ShardView.object_metas` (always
                            segment.writer_generation,
        // Original: A(max_doc=10, base=0), B(max_doc=20, base=10), C(max_doc=30, base=30).
            column: "id".to_string(),
        use datafusion::execution::SessionStateBuilder;
            arrow_schema: std::sync::Arc::new(datafusion::arrow::datatypes::Schema::empty()),
    // the indexed PagePruner can page-prune. Both predicate (→ ColumnIndex) and
            ensure_live_docs_coverage(extraction_of(BoolNode::And(vec![collector(7), pred()])));
        schema: schema.clone(),
    } else {
    /// expression names) must yield ALL output columns. The scoped page-index
                df_stream,
        sort_fields: shard_view.sort_fields.clone(),
        assert_eq!(segs[2].max_doc, 10);
        assert_eq!(segs[1].max_doc, 20);
            })?;
                        // Bloom-filter row-group pruning is always enabled on the indexed read path.
        &schema,
}
        assert!(analyze_top_sort(&plan).is_none());
            // OR/NOT with no collectors pass through unchanged (they're
}
                assert!(matches!(children[1], BoolNode::Or(_)));
        assert_eq!(segs[0].global_base, 7);
    for expr in exprs {
/// leaf into the decoded tree (deleted-doc filtering, no dedicated liveDocs FFI). Called only when
            "t",
    register_listing_table(&ctx, &table_name, shard_view.table_path.clone(), &[], &[]).await?;
        BoolNode::And(children) => {
                                Arc::new(collector) as Arc<dyn RowGroupDocsCollector>,
                            ));
        // but every column is still read. Expression-only collection misses them,
            tree: Arc::new(tree),
    let ctx = handle.ctx;
/// in catalog order) and reverses the mapping back via `partition_point` on
}
    fn analyze_top_sort_descends_through_projection() {
                assert!(matches!(
            BoolNode::And(mut children) => {
        let df_stream = empty_exec.execute(0, handle.ctx.task_ctx())?;
        _limit: Option<usize>,
        assert!(!should_reverse_segments(None, &fields, &orders));
    let table_name = handle.table_name;
                prune_tree_config,
                        ));
        let fields = vec!["a".to_string(), "b".to_string()];
    loop {
                            leaves: Arc::new(CollectorLeafBitmaps::new(
        FilterClass::Tree => {
                ));
    // callback to the correct per-query FilterDelegationHandle and DelegationThreadTracker.
}
///
        };
                    },
};
    permit: tokio::sync::OwnedSemaphorePermit,
                DataFusionError::Internal(
/// after a function).
    };
                        ));
            // multiple DataFusion threads racing to populate the same Lucene
                .map(|pp| (Arc::as_ptr(expr) as *const () as usize, pp))
    extraction: Option<&ExtractionResult>,
    /// expression lists them. Collecting each plan node's OUTPUT SCHEMA fixes it.
            descending: false,
/// `LogicalPlan::Sort`, returns the leading sort key's bare column name and direction.
                None
        query_config: Arc::clone(&query_config),
                };
        assert!(should_reverse_segments(Some(&top), &fields, &orders));
    let Some(e) = extraction else { return vec![] };
            for annotation_id in &leaf_ids {
                BoolNode::And(children)
            column: "b".to_string(),
}
                                None => None,
    /// Regression: `SELECT *` (and any scan that reads columns no Projection
            }
            let cost_collector = query_config.cost_collector;
    names.into_iter().collect()
        },
    #[test]
            collect_predicate_exprs(&tree, &mut leaf_exprs);
        return None;
    }
        return false;
// ── Placeholder provider used only for substrait consume pass ─────────
            descending: true,
) -> Vec<String> {
                .map_err(|e| DataFusionError::Execution(format!("decode substrait: {}", e)))?;
        let r = extract_single_collector_residual(&tree).unwrap();
            BoolNode::Or(children) => {
                            format!(
        let top = TopSort {
                    &projection_column_names,
        // Pure-DF OR tree (no collectors): AND(live_docs, OR(P, P)) — still SingleCollector
            if let Some(col) = node.downcast_ref::<Column>() {
                indices.insert(col.index());
        // New iteration order: C, B, A.
    unsafe { execute_indexed_with_context(ptr, substrait_bytes, cpu_executor, permit).await }
            names,
                    _ => return None,
        ]);
            Field::new("id", DataType::Int64, false),
        assert_eq!(segs.len(), 3);
use crate::indexed_table::bool_tree::BoolNode;
            // AND) as a BoolNode and convert to PhysicalExpr. Used for:
        BoolNode::And(c) | BoolNode::Or(c) => {
    let ptr = Box::into_raw(Box::new(handle)) as i64;
}
        &register_name,
/// segment's `global_base` — and the only way to guarantee that without changing
        Ok(TreeNodeRecursion::Continue)
    let classification = match classification_override {
    let sort_orders = handle.sort_orders;
    physical_plan::displayable,
            LogicalPlan::Filter(f) => current = f.input.as_ref(),
/// - No filter (`count(*)`): a bare match-all Collector — the SingleCollector arm resolves it as
                            call_strategy,
            // StatsPruneTree children indices align with ResolvedNode children
    // `scan()` ignores DataFusion's filters argument (which contains
            LogicalPlan::SubqueryAlias(a) => current = a.input.as_ref(),
    // Extract the scheme+authority portion of the table URL for
        );
        None => live_docs_collector(),
        let out = ensure_live_docs_coverage(extraction_of(BoolNode::And(vec![
                let residuals: Vec<BoolNode> =
    use datafusion::logical_expr::Operator;
        // SingleCollector → Tree. Tree must be unchanged.
#[async_trait::async_trait]
        reverse_segment_iteration_order(&mut segs);
                    names.insert(field.name().to_string());
    fn coverage_tree_class_not_over_collector_gets_top_level_and() {
        // emits / reads. Critically this captures `SELECT *` (and any projection
    #[test]
        // doesn't transfer through a function, so we conservatively decline to reverse.
    }
            BoolNode::And(children) => {
    });
            let max_collector_parallelism = 1;
        ];
                    },
    );
    /// out get a single-page placeholder, which is fine for pruning but CORRUPTS
    fn residual_and_collector_plus_predicate() {
        assert_eq!(
/// For now this delegates to the existing function by reconstructing the needed args
        let orders = vec!["asc".to_string()];
        for expected in ["v", "id", "ts"] {
    }
    }
        // empty stream matches the populated shards' wire shape (e.g. Binary HLL for dc()).
    }
    )?;
    fn residual_nested_and_all_collectors_is_none() {
        // computes catalog-order bases).
            let leaf_ids = tree.collector_leaves();
        phantom_reservation: None,
        let mut names = collect_plan_column_names(&plan);
/// from the handle.
                    move |segment: &SegmentFileInfo,
    // Build the per-query RuntimeEnv (list-files cache pre-populated, optional
        assert_eq!(segs[1].global_base, 10); // B's catalog base, unchanged.
                        ));
                if parquet_cols.is_empty() && offset_cols.is_empty() {
    #[test]
    let context_id = handle.query_context.context_id();
    physical_expr::expressions::Column,
    #[test]
    tree: &Arc<BoolNode>,
                            residual_expr.clone(),
                    "classify_filter returned SingleCollector but extraction is None".into(),
        let fields = vec!["id".to_string()];
    // field instead.
            collector(10),
        assert!(matches!(
                                    e
            assert!(
            collector(2),
        let plan_schema = crate::schema_coerce::coerce_inferred_schema(plan_schema);
        assert!(analyze_top_sort(&plan).is_none());
 *
    #[test]
/// (all non-Collector parts of the AND tree, re-assembled into a
                .unwrap()
            other => Some(other.clone()),
    use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
) -> Option<(
    fn analyze_top_sort_finds_leading_desc() {
    indices.into_iter().collect()
        match (config.tree_shape, config.delegated_predicate_count) {
        let r = extract_single_collector_residual(&tree).unwrap();
        let out =
        Some(ref expr) => Some(
        BoolNode::Not(inner) => collect_predicate_exprs(inner, out),
                            cost_collector,
    // Sort-aware segment iteration. Mirror of `ContextIndexSearcher.shouldUseTimeSeriesDescSortOptimization`
pub(crate) fn analyze_top_sort(plan: &datafusion::logical_expr::LogicalPlan) -> Option<TopSort> {
        assert_eq!(classify_filter(&out.tree), FilterClass::SingleCollector);
    fn should_reverse_segments_field_name_case_sensitive() {
    );
    // On a shard with deletions, constrain the decoded tree to live docs (see
                    .collect(),
                                object_path: segment.object_path.clone(),
    // Java-side QTF signal: scan must emit __row_id__. Captured before consuming indexed_config below.
                            })?;
        ctx,
fn ensure_live_docs_coverage(extraction: Option<ExtractionResult>) -> ExtractionResult {
            residual_bool
                Some((
/// Reversing only the iteration order — i.e. the order in which chunks/RGs are
/// was built from a catalog snapshot). `query_memory_pool` is the per-query
/// `id = segment.global_base + position`. The fetch phase (`api::fetch_by_row_ids`)
        match r {
        Some(ensure_live_docs_coverage(extraction))
                                chunk.doc_max,
        }
            let call_strategy = CollectorCallStrategy::PageRangeSplit;
        use datafusion::physical_plan::ExecutionPlan;
            other => panic!("expected And, got {:?}", other),
    }
    fn coverage_skips_or_of_collectors() {
                datafusion::parquet::schema::types::Type::group_type_builder("schema")
                            .map_err(|e| format!("leaf {} collector: {}", idx, e))?;
                    continue;
                          stream_metrics: &StreamMetrics,
            other => panic!("expected unchanged And, got {:?}", other),
            sort_orders.first()
    }
    }
        let tree = BoolNode::And(vec![
fn build_prune_tree_config(
    #[test]
    query_config: Arc<DatafusionQueryConfig>,
            // same-kind connectives. Flatten after push_not_down so the
/// Returns `None` if the plan has no top-level Sort, or if the first Sort key is not
        }
                        let result = build_pruning_predicate(expr, Arc::clone(&schema_for_pruner));
            c.iter().for_each(|ch| collect_predicate_exprs(ch, out))
    SchemaRef,
            );
            global_base,
            datafusion::parquet::schema::types::SchemaDescriptor::new(std::sync::Arc::new(
            }
                          chunk,
    pub column: String,
            }
fn collect_predicate_column_indices(extraction: Option<&ExtractionResult>) -> Vec<usize> {
        // NOT(C) readmits deleted docs at the leaf level — the root AND with the live set
    }
                assert!(matches!(children[1], BoolNode::Or(_)));
    };
                .and_then(residual_bool_to_physical_expr)
    shard_view: &ShardView,
                assert!(matches!(
/// segments — laid down newest-last by the writer — are in reverse order from what
    query_memory_pool: Option<Arc<dyn MemoryPool>>,
        let ctx = SessionContext::new_with_state(state);
    // TopK above us pulls the highest-priority segment first and parquet page stats prune the rest.
        let top = TopSort {
    execution::object_store::ObjectStoreUrl,
            crate::query_tracker::set_abort_handle(context_id_early, h);
/// Reverse the iteration order of `segments` in place. Per-segment `global_base`
        CrossRtStream::new_with_df_error_stream_cancellable(df_stream, cpu_executor.clone(), None);
            column: "id".to_string(),
        let file_meta = FileMetaData::new(0, 0, None, None, schema, None);
    sort_fields: &[String],
            }
        &self,
        ]);
            // N) — no index column, but every row scanned and the constant applied as
    #[test]
            None => FilterClass::None,
    ExtractionResult {
            let correctness_provider: Option<Arc<ProviderHandle>> =
    }
        assert!(is_predicate(&r));
/// a plain `Expr::Column` (e.g. `ORDER BY lower(x)` — we can't claim catalog monotonicity
    // Register default ListingTable so substrait consumer can resolve the table.
                )
    let extraction = if deleted_doc_filtering_required {
/// tree is collectors-only (no residual predicates).
    // (e.g. "file:///Users/.../parquet/"); ObjectStoreUrl wants only
            let residual_bool = extract_single_collector_residual(&e.tree);
    let max_p = gate.max_permits();
                assert_eq!(children.len(), 2);
            other => panic!("expected And, got {:?}", other),
 * SPDX-License-Identifier: Apache-2.0
    substrait_bytes: Vec<u8>,
        indexed_config: None, // derive classification from tree
        }
                }
        let r = extract_single_collector_residual(&tree).unwrap();
            (
                assert_eq!(children.len(), 2);
        let state = SessionStateBuilder::new().with_default_features().build();
}
    ) -> Result<Arc<dyn ExecutionPlan>, DataFusionError> {
            }
    fn residual_bare_collector_is_none() {
        f.debug_struct("PlaceholderProvider").finish()
                )
            // to the residual so DF gets to evaluate them natively.
            build_pruning_predicate(expr, Arc::clone(schema))
            LogicalPlan::Sort(s) => {
    }
use crate::parquet_page_cache::{
) -> Result<i64, DataFusionError> {
                .and_then(|e| residual_bool_to_physical_expr(&e.tree));
    let leaf_exprs = collect_leaf_exprs(extraction.as_ref());
                                store: Arc::clone(&bloom_store),
        let right: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(0))));
        );
/// The reserved match-all Collector leaf (Java resolves the id to a `MatchAllDocsQuery` whose
            crate::query_tracker::set_cpu_runtime_handle(context_id_early, rt);
    }
            BoolNode::And(children) => {
            (
    // ORDER BY runs counter to the catalog's stored direction, reverse the segment vector so a
                // Keep the mandatory visibility mask first so downstream evaluation can narrow
/// `FilterDelegationHandle.LIVE_DOCS_MATCH_ALL_ANNOTATION_ID` on the Java side.
        }
                        let pruner = Arc::new(PagePruner::new(
        let _ = expr.apply(|node| {
                    &parquet_cols,
            });
        assert_eq!(ts.column, "ts");
        let mut segs: Vec<SegmentFileInfo> = vec![];
                            });
    }
                    .all(|c| matches!(c, BoolNode::Collector { .. })));
    schema: &SchemaRef,
        // AND(C, AND(P, OR(P, P))) → AND(P, OR(P, P))
// ── Helpers ───────────────────────────────────────────────────────────
                            Vec::with_capacity(providers.len());
                            &schema_for_pruner,
    let leaf_predicates: HashMap<usize, Arc<PruningPredicate>> = leaf_exprs
        // `count(*)` on a shard with deletions: candidates must be exactly the live docs.
        ctx,
        let out = ensure_live_docs_coverage(extraction_of(BoolNode::And(vec![pred(), pred()])));
                    "classify_filter returned Tree but extraction is None".into(),
        assert_eq!(segs[2].global_base, 0); // A's catalog base, unchanged.
        // (the leading key), not `b`. Reversing won't help — decline.
            // pure-predicate subtrees in a SingleCollector-classified tree).
            // get absorbed into the surrounding Or if applicable.
        }
            // residual (pushdown is Exact, so DataFusion drops the FilterExec).
    /// `match() | sort | head` shape (q23) hit this: it reads every column but no
        *Box::from_raw(session_ctx_ptr as *mut crate::session_context::SessionContextHandle);
    #[test]
    let mut current = plan;
//!   5. `releaseProvider(provider_key)` when the tree is dropped.
    //   `on_batch_mask` using arrow kernels; no pushdown needed.
    let object_metas = handle.object_metas;
        &substrait_bytes,
                    })
                        let rg_index_to_pos: HashMap<usize, usize> = chunk
    // for multi-index queries, the concrete name otherwise), not the per-shard table_name.
                            segment.arrow_schema.clone(),
    #[test]
        schema: schema.clone(),
        FilterClass::SingleCollector => extraction.as_ref().and_then(|e| {
/// Walk through the top of a logical plan to find the leading sort expression.
    }
/// ANDs. Returns `None` if the tree is a bare Collector or the entire
    #[test]
}
        assert!(ts.descending);
                    .unwrap(),
        displayable(physical_plan.as_ref()).indent(true)
            // One provider per Collector leaf (DFS order).
        FilterClass::Tree => None,
            )
        assert!(extract_single_collector_residual(&tree).is_none());
    let logical_plan = crate::substrait_consumer::from_substrait_plan(&ctx.state(), &plan).await?;
                                metadata: Arc::clone(&segment.metadata),
        crate::query_tracker::set_abort_handle(context_id, h);
                                io_handle: io_handle.clone(),
        );
        match r {
        .await
fn live_docs_collector() -> BoolNode {
                            Some(PagePruneMetrics::from_stream_metrics(stream_metrics)),
                                arrow_schema: Arc::clone(&bloom_schema),
        assert!(is_predicate(&r));
                    .build()
};
                Arc::new(
                                    chunk.doc_min,
    // The substrait scan binds to the plan's NamedTable name (the alias/pattern like "tb-1,tb-2"
            "every read column (full output schema) must be collected, not just expression columns"
) -> Result<i64, DataFusionError> {
    }
                            rg_index_to_pos,
}
    let Some(catalog_field) = sort_fields.first() else {
    let Some(e) = extraction else { return vec![] };
    let physical_plan = if aggregate_mode != crate::agg_mode::Mode::Default {
                .map_err(|e| DataFusionError::Execution(format!("expr_to_bool_tree: {}", e)))?,
            sort_max: None,
    // and producer-side batches agree by construction (see crate::relabel_exec).
                        let eval: Arc<dyn RowGroupBitsetSource> =
    sort_orders: &[String],
            // shared across all per-(segment×chunk) closures via Arc::clone — so
            other => panic!("expected And residual, got {:?}", other),
    // the vanilla path. File-metadata and file-statistics caches are inherited
use crate::api::ShardView;
                    &predicate_column_names,
        };
    #[test]
/// (with UDF registered and IndexedExecutionConfig set) and routes to the appropriate
                            tree: resolved,
    #[test]
    // scoped OffsetIndex so the reader fetches only matched pages.
            extraction
        let mut segs = vec![dummy_segment(42, 7)];
            dummy_segment(10, 0),
            BoolNode::Not(Box::new(collector(2))),
    // spawning on the CPU runtime, so the Java search thread blocks at the
                            };
    fn is_predicate(node: &BoolNode) -> bool {
/// Execute an indexed query.
    let target_schema = crate::schema_coerce::coerce_inferred_schema(physical_plan.schema());
            BoolNode::And(children) => {
/// All comparisons are case-sensitive on the field name (matching PR #22041's
            .build()
        TableType::Base
                                context_id,
        assert_eq!(
    arrow::datatypes::SchemaRef,
    execution::memory_pool::MemoryPool,
        Arc::clone(&store),
            //   - Page-stats pruning in candidate stage (via PruningPredicate).
///
    ))
        let out = ensure_live_docs_coverage(extraction_of(BoolNode::Or(vec![pred(), pred()])));
            let pruning_predicates: Arc<HashMap<usize, Arc<PruningPredicate>>> = Arc::new(
    physical_plan::execute_stream,
        }
    #[test]
                                    segment.writer_generation,
            Ok(TreeNodeRecursion::Continue)
                    &offset_cols,
    if top.column != *catalog_field {
    collect_predicate_exprs(&e.tree, &mut exprs);
}
        if let Some(h) = abort_handle {
                        Arc::new(crate::indexed_table::eval::predicate_evaluator::PredicateOnlyEvaluator::new(
        table_path: shard_view.table_path.clone(),
        assert_eq!(classify_filter(&out.tree), FilterClass::Tree);
                        let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
        sort_fields: sort_fields.clone(),
    #[test]
    #[test]
            LogicalPlan::Projection(p) => current = p.input.as_ref(),
        annotation_id: LIVE_DOCS_MATCH_ALL_ANNOTATION_ID,
        deleted_doc_filtering_required: false,
        // and a read column that gets only a placeholder OffsetIndex (instead of
            column: "id".to_string(),
    }
    fn is_live_docs_leaf(node: &BoolNode) -> bool {
    }
                    )),
        SegmentFileInfo {
use crate::indexed_table::eval::bitmap_tree::{BitmapTreeEvaluator, CollectorLeafBitmaps};
                    &store,
    // ── reverse_segment_iteration_order ───────────────────────────────
/// Constrain the extracted filter to live documents by AND-ing the reserved match-all Collector
//! per Collector leaf):
    let plan = Plan::decode(substrait_bytes.as_slice())
        if !predicate_column_names.is_empty() || !projection_column_names.is_empty() {
                            .map_err(|e| DataFusionError::External(e.into()))?,
                }
                        let collector_opt: Option<Arc<dyn RowGroupDocsCollector>> =
    // `indexed_path` flag also drops the combine-partial-final optimizer pass and
                    map.entry(*annotation_id)
                            )
                                    .bloom_filter_eval_time
    // for the indexed-parquet path. When the index has `index.sort.field` and the query's leading
                return Some(TopSort {
    if page_index::is_scoped_page_index_enabled() {
    }
        // Performance-delegated leaves contribute their original expression to the
                assert!(is_live_docs_leaf(&children[0]));
        // Coordinator annotation ids are non-negative (PlannerContext counter); the reserved
            // candidate stage. Predicates that fail to translate or
            (
}
// TODO: remove this function once all callers migrate to the instruction-based path
                    &segment.arrow_schema,
            // Predicate-only: push the whole tree (may be an unfoldable constant);
            let residual_bool = extract_single_collector_residual(&extraction.tree);
//!
    // Build SessionContextHandle and delegate to execute_indexed_with_context
    permit: tokio::sync::OwnedSemaphorePermit,
    let emit_row_ids = requests_row_ids;
        match out.tree.as_ref() {
        let orders = vec!["desc".to_string()];
            BoolNode::And(vec![collector(0), collector(1)]),
                        Arc::new(SingleCollectorEvaluator::new(
            }
        }
            Arc::new(logical_plan.schema().as_arrow().clone())
    let runtime_env = build_query_runtime_env_with_store(
                for (annotation_id, _expr) in &leaves {
        BoolNode::Predicate(expr) => out.push(Arc::clone(expr)),
        return false;
        Err(DataFusionError::Internal(
        assert!(!should_reverse_segments(Some(&top), &fields, &orders));
                            context_id,
    let deleted_doc_filtering_required = handle.deleted_doc_filtering_required;
//!      (once per SegmentChunk × Collector leaf).
        predicate_columns,
        BoolNode::Collector { annotation_id } => Some(*annotation_id),
)> {
    let stream_handle = crate::api::QueryStreamHandle::with_physical_plan(
    }
    let handle = crate::session_context::SessionContextHandle {
            BoolNode::And(vec![collector(0), BoolNode::And(vec![collector(1), p2])]),
    // per-query pool overlay) and register the shard object store — shared with
            //   - Parquet `with_predicate` pushdown in row-granular mode.
                                    let collector = FfmSegmentCollector::create(
        );
            "PlaceholderProvider should not be scanned".into(),
    fn collect_plan_column_names_collects_projected_and_referenced() {
                          stream_metrics: &StreamMetrics,
                                context_id,
            let bloom_schema = schema.clone();
                    &segment.metadata,
            BoolNode::Collector { annotation_id: 3 }
    }
    let _ = plan.apply(|node| {
    );
    let predicate_columns = collect_predicate_column_indices_from_exprs(&leaf_exprs);
/// the query's direction is the **opposite** of the catalog's. In that case the
            // SingleCollector is AND(Collector?, DelegationPossible*, residual*) so
            handle.prepared_plan.as_ref()
            BoolNode::And(children) => {
        // AND(Collector, P) — the existing correctness collector's bitmap is already
        .as_ref()
/// - Other shapes (OR/NOT over collectors and predicates): the match-all Collector is AND'ed at the
                            pruner,
    .await
    cpu_executor: DedicatedExecutor,
    let pushdown_predicate: Option<Arc<dyn PhysicalExpr>> = match &classification {
                    1 => Some(residuals.into_iter().next().unwrap()),
    use datafusion::physical_expr::PhysicalExpr;
            );
                    &schema,
    //
        Some(ExtractionResult {
/// `Column::from_name`). Direction comparison is case-insensitive on `"asc"`/`"desc"`.
    fn reverse_segments_preserves_global_base() {
            if let Some(col) = node.downcast_ref::<Column>() {
        assert!(!ts.descending);
            }
    ctx.register_table(&register_name, provider)?;
            cross_rt_stream,
    for expr in &exprs {
    context_id: i64,
    fn collector(id: i32) -> BoolNode {
        use datafusion::parquet::file::metadata::{FileMetaData, ParquetMetaData};
            }
fn collect_predicate_column_indices_from_exprs(exprs: &[Arc<dyn PhysicalExpr>]) -> Vec<usize> {
    let writer_generations = handle.writer_generations;
///
            descending: false,
                                chunk.doc_max,
            Field::new("ts", DataType::Int64, false),
                                chunk.doc_min,
    #[test]
    classify_filter, expr_to_bool_tree, extract_filter_expr, ExtractionResult, FilterClass,
            let prune_tree_config =
                ));
    let mut exprs = Vec::new();
        // (or, upstream, the (0,0)-page byte-range subtract underflow).
            sort_min: None,
            let residual_expr: Option<Arc<dyn PhysicalExpr>> = extraction
                            max_collector_parallelism,
    schema: SchemaRef,
                {
            collector(10),
        let p2 = pred();
            // Weight do so once per (query × annotation_id), not per chunk.
//! Per-leaf lifecycle at query time (one compiled-query + per-segment matcher
                datafusion::logical_expr::Distinct::All(input) => current = input.as_ref(),
                        ));
        // FilterTreeShape: 1 = CONJUNCTIVE → SingleCollector, 2 = INTERLEAVED → Tree.
    if leaf_predicates.is_empty() {
        // OR(C, P): the predicate branch re-admits deleted docs into the union, so the tree
                            &schema_for_pruner,
            Some(LIVE_DOCS_MATCH_ALL_ANNOTATION_ID)
        let orders = vec!["asc".to_string()];
        .map_err(|e| DataFusionError::Execution(format!("decode substrait: {}", e)))?;
        assert!(is_live_docs_leaf(&out.tree));
    #[test]
                            rg_index_to_pos: chunk
        query_context,
    Ok(Box::into_raw(Box::new(stream_handle)) as i64)
    fn analyze_top_sort_returns_none_when_no_sort() {
        &shard_view.table_path,
        match out.tree.as_ref() {
            // Previously errored here when emit_row_ids was false (indexed path only).
            }
    }
        }
    // gate when it is full — creating backpressure at the Java threadpool level.
    // ── collect_plan_column_names ─────────────────────────────────────
fn collect_predicate_column_names(
    // Retag bit-compatible Int↔UInt output mismatches to match the substrait-declared
mod tests {
        match out.tree.as_ref() {
        object_metas.as_ref(),
        let pq_meta = ParquetMetaData::new(file_meta, vec![]);
                .and_then(|e| build_prune_tree_config(&e.tree, &schema_for_pruner, &leaf_exprs));
                                provider.key(),
                let leading = s.expr.first()?;
use crate::cache::page_index;
            // connective changes from De Morgan (e.g. NOT(AND(...)) -> OR(NOT...))
        matches!(node, BoolNode::Predicate(_))
            ensure_live_docs_coverage(extraction_of(BoolNode::Or(vec![collector(1), pred()])));
fn extract_single_collector_residual(tree: &BoolNode) -> Option<BoolNode> {
            None
        }
        let metadata = std::sync::Arc::new(pq_meta);
                    Some(annotation_id) => Some(Arc::new(
            Ok(TreeNodeRecursion::Continue)
    fn coverage_skips_and_with_covered_collector_and_not() {
            let _ = expr.apply(|e| {
                            Some(crate::indexed_table::eval::single_collector::BloomConfig {
        match out.tree.as_ref() {
                    column: col,
///   keeping the tree `SingleCollector` with the predicates as the residual.
                .push_not_down()
    fn should_reverse_segments_no_catalog_sort() {
                        let pruner = Arc::new(PagePruner::new(
    exprs
            BoolNode::Predicate(_) => Some(node.clone()),
        {
        aggregate_mode: crate::agg_mode::Mode::Default,
    #[test]
        let plan = build_logical_plan("SELECT id FROM t ORDER BY id ASC LIMIT 10");
/// values are deliberately **left untouched** so each segment keeps its
use crate::executor::DedicatedExecutor;
#[derive(Debug, Clone, PartialEq, Eq)]
        // Reversal must keep each segment's original `global_base` intact so QTF row IDs
        // emitted in query phase remain interpretable by the fetch phase (which always
                                .collect(),
    };
    }
    #[test]
    }
    if should_reverse_segments(
        let fields = vec!["id".to_string()];
    if handle.object_metas.is_empty() && !handle.table_name.is_empty() {
        Arc::new(leaf_predicates),
                            .map(|(pos, &idx)| (idx, pos))
        // No projection expressions name id/ts/v, but `SELECT *` reads all three.
