    }
                        })?;
    #[test]
            },
            "every read column (full output schema) must be collected, not just expression columns"
        BoolNode::Collector { annotation_id } => Some(*annotation_id),
        "DataFusion physical plan:\n{}",
    /// Regression: `SELECT *` (and any scan that reads columns no Projection
                            ));
                assert!(is_live_docs_leaf(&children[0]));
            let tree = Arc::new(tree);
            )
        }
    fn analyze_top_sort_finds_leading_desc() {
                ),
            }
}
        let stream_handle = crate::api::QueryStreamHandle::with_session_context(
    }
        });
            collector(1),
    // Register default ListingTable so substrait consumer can resolve the table.
    // TopK above us pulls the highest-priority segment first and parquet page stats prune the rest.
                                    chunk.doc_min,
            LogicalPlan::Sort(s) => {
#[cfg(test)]
            let residual_pruning_predicate: Option<Arc<PruningPredicate>> = residual_expr
    if should_reverse_segments(
    #[test]
                            Some(PagePruneMetrics::from_stream_metrics(stream_metrics)),
                .await
            other => panic!("expected And, got {:?}", other),
                            .enumerate()
                                provider.key(),
        assert!(!should_reverse_segments(Some(&top), &fields, &orders));
    };
impl fmt::Debug for PlaceholderProvider {
use std::collections::{HashMap, HashSet};
                                .iter()
    }
            let collector_strategy = CollectorCallStrategy::TightenOuterBounds;
            let prune_tree_config = extraction
    let Some(e) = extraction else { return vec![] };
                providers.push(Arc::new(
            LogicalPlan::Limit(l) => current = l.input.as_ref(),
/// values are deliberately **left untouched** so each segment keeps its
            ensure_live_docs_coverage(extraction_of(BoolNode::And(vec![collector(7), pred()])));
/// `LogicalPlan::Sort`, returns the leading sort key's bare column name and direction.
                                chunk.doc_min,
pub(crate) struct TopSort {
                                )
    EvaluatorFactory, IndexedTableConfig, IndexedTableProvider, SegmentFileInfo,
            )
        reverse_segment_iteration_order(&mut segs);
            LogicalPlan::Projection(p) => current = p.input.as_ref(),
                        Ok(eval)
    }
                crate::substrait_consumer::from_substrait_plan(&handle.ctx.state(), &plan).await?;
    loop {
    let (cross_rt_stream, abort_handle, _task_done) =
            let mut providers: Vec<Arc<ProviderHandle>> = Vec::with_capacity(leaf_ids.len());
    #[test]
    fn coverage_pure_predicate_tree_prepends_collector_and_stays_single_collector() {
                    create_provider(context_id, *annotation_id)
        object_metas.as_ref(),
        let tree = BoolNode::And(vec![
        // NOT(C) readmits deleted docs at the leaf level — the root AND with the live set
        // Pure-DF OR tree (no collectors): AND(live_docs, OR(P, P)) — still SingleCollector
use crate::indexed_table::substrait_to_tree::{
    /// expression names) must yield ALL output columns. The scoped page-index
    let mut names = HashSet::new();
    let pushdown_predicate: Option<Arc<dyn PhysicalExpr>> = match &classification {
    ctx.register_table(&register_name, provider)?;
            column: "id".to_string(),
}
                .and_then(|expr| build_pruning_predicate(expr, Arc::clone(&schema_for_pruner)));
    let query_future =
    // below. The closures pass it through every FFM upcall so Java can route each
        BoolNode::And(c) | BoolNode::Or(c) => {
/// global pool.
fn ensure_live_docs_coverage(extraction: Option<ExtractionResult>) -> ExtractionResult {
        io_handle: tokio::runtime::Handle::current(),
    build_pruning_predicate, PagePruneMetrics, StatsPruneTree,
        let fields = vec!["id".to_string()];
        // engine-native-merge: borrow the partial-state schema from the prepared plan so the
//! Indexed query executor — decodes substrait, classifies the filter tree,
                .and_then(|e| residual_bool_to_physical_expr(&e.tree))
        table_name: table_name.clone(),
        let plan = build_logical_plan("SELECT id FROM t ORDER BY abs(v)");
    ctx.deregister_table(&register_name)?;
    async fn scan(
    let _ = plan.apply(|node| {
    let tree = match extraction {
    });
        // we don't claim the catalog ordering applies. Safe default: no reversal.
    // Apply aggregate mode stripping when prepare_partial_plan was called (engine-native-merge).
            let _ = expr.apply(|e| {
            BoolNode::Not(Box::new(collector(2))),
        let ts = analyze_top_sort(&plan).expect("expected Sort");
    let gate = cpu_executor.concurrency_gate().clone();
        Arc::clone(tree),
    }
            BoolNode::Collector { annotation_id } if *annotation_id == LIVE_DOCS_MATCH_ALL_ANNOTATION_ID
    }
    leaf_exprs: &[Arc<dyn PhysicalExpr>],
    #[test]
            names.insert(field.name().to_string());
            // fallback treats missing entries as "no pruning for this
                    &projection_column_names,
    let state = ctx.state();
            // Predicate-only: push the whole tree (may be an unfoldable constant);
use crate::indexed_table::page_pruner::{
    }
            extraction
    Arc<HashMap<usize, Arc<PruningPredicate>>>,
        assert!(ts.descending);
                          stats_prune_tree: Option<&Arc<StatsPruneTree>>| {
                    &store,
        );
    substrait_bytes: Vec<u8>,
                cpu_executor.clone(),
        // empty stream matches the populated shards' wire shape (e.g. Binary HLL for dc()).
            // Correctness-delegated provider (eager). `None` when the query has only
    fn residual_and_only_collectors_is_none() {
/// per-RG collector emits the segment's liveDocs).
            // One provider per Collector leaf (DFS order).
            writer_generation: global_base as i64 + 1, // arbitrary, just to vary
                            segment.arrow_schema.clone(),
        }
                    .iter()
        // Pure-DF predicate AND tree: match-all becomes the correctness collector,
                .as_ref()
    }
    }
    fn residual_nested_and_strips_collectors() {
        let _ = node.apply_expressions(|expr| {
    }
use crate::indexed_table::bool_tree::BoolNode;
use crate::indexed_table::table_provider::{
    fn collect_plan_column_names_collects_projected_and_referenced() {
                                Arc::new(collector) as Arc<dyn RowGroupDocsCollector>,
    substrait_bytes: Vec<u8>,
                            };
        })
                                chunk.doc_max,
            column: "id".to_string(),
        // SingleCollector → Tree. Tree must be unchanged.
                        let mut per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> =
                }
        let out = ensure_live_docs_coverage(extraction_of(BoolNode::Not(Box::new(collector(4)))));
                            per_leaf.push((
    let (factory, prune_tree_config): (EvaluatorFactory, _) = match classification {
                ))
    let logical_plan = crate::substrait_consumer::from_substrait_plan(&ctx.state(), &plan).await?;
        let ts = analyze_top_sort(&plan).expect("expected Sort");
    let query_context = handle.query_context;
    if handle.object_metas.is_empty() && !handle.table_name.is_empty() {
    let max_p = gate.max_permits();
///   keeping the tree `SingleCollector` with the predicates as the residual.
    physical_plan::ExecutionPlan,
use datafusion::{
                        let rg_index_to_pos: HashMap<usize, usize> = chunk
        assert_eq!(segs[0].max_doc, 42);
    match tree {
}
    }
use crate::indexed_table::eval::bitmap_tree::{BitmapTreeEvaluator, CollectorLeafBitmaps};
                          chunk,
    indices.into_iter().collect()
 */
        // but every column is still read. Expression-only collection misses them,
) -> bool {
    #[test]
        },
    let physical_plan = if aggregate_mode != crate::agg_mode::Mode::Default {
    }
        }
            p1,
            let residual_expr: Option<Arc<dyn PhysicalExpr>> = extraction
            .enable_all()
        Some(c) => c,
        let plan = build_logical_plan("SELECT v FROM t ORDER BY ts DESC");
        assert!(analyze_top_sort(&plan).is_none());
        metadata_cache,
                                    context_id,
    // Java-side QTF signal: scan must emit __row_id__. Captured before consuming indexed_config below.
    query_config: Arc<DatafusionQueryConfig>,
    /// A narrow projection still collects exactly the columns the query touches
    fn residual_nested_and_all_collectors_is_none() {
                // Keep the mandatory visibility mask first so downstream evaluation can narrow
        FilterClass::Tree => {
                            Arc::clone(&segment.metadata),
    let schema = cross_rt_stream.schema();
                    children.iter().filter_map(strip_collectors).collect();
            collector(10),
        assert_eq!(segs[0].max_doc, 30);
            sort_max: None,
    fn residual_and_collector_plus_predicate() {
    let wrapped = RecordBatchStreamAdapter::new(schema, cross_rt_stream);
/// Coordinator-assigned annotation ids are non-negative (`PlannerContext.nextAnnotationId`
                                context_id,
            crate::query_tracker::QueryType::Shard,
/// in catalog order) and reverses the mapping back via `partition_point` on
        };
    let handle =
        assert_eq!(
        let top = TopSort {
    };
fn collect_predicate_column_indices_from_exprs(exprs: &[Arc<dyn PhysicalExpr>]) -> Vec<usize> {
    use super::*;
    // Derive the parquet pushdown predicate from the BoolNode tree.
        emit_row_ids,
        matches!(
                leaf_exprs
            BoolNode::And(mut children) => {
                }
            let bloom_schema = schema.clone();
        let plan = build_logical_plan("SELECT * FROM t WHERE v = 0 ORDER BY ts");
use crate::helper::{
/// Reserved annotation id resolved by the Java `FilterDelegationHandle` to a
                            let collector = FfmSegmentCollector::create(
/// ANDs. Returns `None` if the tree is a bare Collector or the entire
        ));
                let mut map = std::collections::HashMap::with_capacity(leaves.len());
        sort_orders: sort_orders.clone(),
    #[test]
                                store: Arc::clone(&bloom_store),
                assert!(matches!(
    };
    catalog::Session,
    // `indexed_path` flag also drops the combine-partial-final optimizer pass and
    // Build a fresh session context per query. The indexed path fans out via
                            collector_strategy,
        query_context,
            let mut leaf_exprs: Vec<Arc<dyn PhysicalExpr>> = Vec::new();
                };
/// after a function).
///
            // (same push_not_down + flatten normalization applied above).
    if let Some(h) = abort_handle {
            crate::query_tracker::set_abort_handle(context_id_early, h);
        let pq_meta = ParquetMetaData::new(file_meta, vec![]);
        for field in node.schema().fields() {
/// the fetch path is to keep query-phase `global_base` at its catalog-order value.
/// segments — laid down newest-last by the writer — are in reverse order from what
    // for the indexed-parquet path. When the index has `index.sort.field` and the query's leading
        let r = extract_single_collector_residual(&tree).unwrap();
    load_scoped_page_index_cols, resolve_predicate_parquet_columns_pair,
        CrossRtStream::new_with_df_error_stream_cancellable(df_stream, cpu_executor.clone(), None);
                                    Some(Arc::new(collector) as Arc<dyn RowGroupDocsCollector>)
        Ok(TreeNodeRecursion::Continue)
        .map_err(DataFusionError::Execution)
        let orders = vec!["asc".to_string()];
            global_base,
        FilterClass::None => {
    runtime: &DataFusionRuntime,
    fn is_predicate(node: &BoolNode) -> bool {
        };
        let out = ensure_live_docs_coverage(None);
/// - AND trees (pure-DF / DelegationPossible): the match-all Collector is prepended at the root,
        let plan = build_logical_plan("SELECT v FROM t WHERE id = 1 ORDER BY ts");
/// Returns `None` if the plan has no top-level Sort, or if the first Sort key is not
        // AND(P₁, AND(C₁, AND(C₂, P₂))) → AND(P₁, P₂)
            Some(LIVE_DOCS_MATCH_ALL_ANNOTATION_ID)
            CrossRtStream::new_with_df_error_stream_cancellable(
        assert_eq!(classify_filter(&out.tree), FilterClass::SingleCollector);
        None => None,
/// - No filter (`count(*)`): a bare match-all Collector — the SingleCollector arm resolves it as
            // Extract the residual (non-Collector children of top-level
    top_sort: Option<&TopSort>,
                                chunk.doc_max,
        shard_view.object_metas.as_ref(),
        log_debug!(
    // ensure_live_docs_coverage). The coordinator's plan bytes are never modified.
/// `shard_view` carries the segment's parquet paths (populated when the reader
                        result.map(|pp| (Arc::as_ptr(expr) as *const () as usize, pp))
    }
            //   - Parquet `with_predicate` pushdown in row-granular mode.
            }
    let parsed = url::Url::parse(url_str)
    #[test]
        Arc::new(leaf_predicates),
/// Instruction-based indexed execution path. Consumes a pre-configured SessionContextHandle
        assert_eq!(ts.column, "id");
                match residuals.len() {
            max_doc,
        // AND(Collector, P) — the existing correctness collector's bitmap is already
        // emitted in query phase remain interpretable by the fetch phase (which always
                assert!(matches!(children[1], BoolNode::Or(_)));
    // field instead.
///
        assert!(!should_reverse_segments(Some(&top), &[], &[]));
            descending: true,
    let context_id = query_context.context_id();
    )?;
                            Arc::clone(&segment.metadata),
        let mut segs: Vec<SegmentFileInfo> = vec![];
    });
        let left: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new("price", 0));
    if leaf_predicates.is_empty() {
            BoolNode::And(children) => assert_eq!(children.len(), 2),
            }
                    move |segment: &SegmentFileInfo,
        assert_eq!(
                                stream_metrics,
    // callback to the correct per-query FilterDelegationHandle and DelegationThreadTracker.
                    children[0],
    let url_str = table_path.as_str();
    fn coverage_or_predicate_tree_wraps_in_and() {
                    return Some(id);
            // leaf" (safe: universe bitmap).
                assert!(matches!(children[1], BoolNode::Or(_)));
        );
// ── Helpers ───────────────────────────────────────────────────────────
    }
}
    common::DataFusionError,
/// ORDER BY whose leading key matches the catalog's leading sort field by name, and
        // is NOT covered and the live-docs collector must be AND'ed at the root.
            LogicalPlan::Distinct(d) => match d {
                indices.insert(col.index());
            residual_bool
    // — each segment retains its catalog-order base, so the row IDs query phase emits are still
            let residual_bool = extract_single_collector_residual(&extraction.tree);
                        ));
        let residual = extract_single_collector_residual(&out.tree).unwrap();
    };
        }
            // AND) as a BoolNode and convert to PhysicalExpr. Used for:
        match out.tree.as_ref() {
            })?;
                            page_pruner: pruner,
                datafusion::logical_expr::Distinct::On(on) => current = on.input.as_ref(),
        }
                let leading = s.expr.first()?;
    let extraction = match filter_expr {
                                None => None,
/// segment's `global_base` — and the only way to guarantee that without changing
    }
                    .iter()
    for expr in &exprs {
                            &schema_for_pruner,
                    continue;
    fn collector(id: i32) -> BoolNode {
use crate::indexed_table::index::RowGroupDocsCollector;
//!   5. `releaseProvider(provider_key)` when the tree is dropped.
        &substrait_bytes,
    // ORDER BY runs counter to the catalog's stored direction, reverse the segment vector so a
        SegmentFileInfo {
        // OR(C, P): the predicate branch re-admits deleted docs into the union, so the tree
        }
    fn coverage_skips_bare_collector() {
                        let bloom_config =
    cpu_executor: DedicatedExecutor,
/// a plain `Expr::Column` (e.g. `ORDER BY lower(x)` — we can't claim catalog monotonicity
    #[test]
            datafusion::arrow::record_batch::RecordBatch::new_empty(schema),
                )
    /// `match() | sort | head` shape (q23) hit this: it reads every column but no
            collect_predicate_exprs(&tree, &mut leaf_exprs);
    #[test]
    fn coverage_skips_or_of_collectors() {
        physical_plan,
            single_collector_id(&out.tree),
            let leaf_ids = tree.collector_leaves();
                .as_ref()
use crate::indexed_table::eval::single_collector::SingleCollectorEvaluator;
        indexed_config: None, // derive classification from tree
    }
        // doesn't transfer through a function, so we conservatively decline to reverse.
                Arc::new(
                let col = match &leading.expr {
    // Tree: None — BitmapTreeEvaluator walks the whole BoolNode in
    let predicate_columns = collect_predicate_column_indices_from_exprs(&leaf_exprs);
fn collect_plan_column_names(plan: &datafusion::logical_expr::LogicalPlan) -> Vec<String> {
    use crate::indexed_table::bool_tree::BoolNode;
    let mut exprs = Vec::new();
/// Descends through `Projection`, `Limit`, `SubqueryAlias`, `Distinct`, and `Filter` —
                assert!(is_predicate(&children[0]));
    let Some(catalog_order) = sort_orders.first() else {
    datasource::{TableProvider, TableType},
            }
        df.into_unoptimized_plan()
        // Residual (what DF evaluates) keeps both predicates.
}
/// was built from a catalog snapshot). `query_memory_pool` is the per-query
                }
    #[test]
    //   row-granular mode parquet narrows Collector-matching rows via
// Kept as thin wrapper to make existing tests exercise execute_indexed_with_context
        // Match PR #22041 — `Column::from_name` is case-sensitive. If casing differs,
#[async_trait::async_trait]
        names.sort();
};
            let plan = Plan::decode(substrait_bytes.as_slice())
        store: Arc::clone(&store),
/// Collect all `Predicate(expr)` leaves in DFS order. Used by the
        let out =
            _ => panic!("expected AND, got {:?}", r),
    use datafusion::logical_expr::{Expr, LogicalPlan};
                        .map_err(|e| DataFusionError::External(e.into()))?,
                    .unwrap(),
    // DataFusion's FileScanConfig. The full URL includes the path
    // Retag bit-compatible Int↔UInt output mismatches to match the substrait-declared
    let context_id = handle.query_context.context_id();
    fn coverage_tree_class_not_over_collector_gets_top_level_and() {
    // (e.g. "file:///Users/.../parquet/"); ObjectStoreUrl wants only
                            })?;
                                .collect(),
            BoolNode::And(vec![collector(2), collector(3)]),
                                segment.writer_generation,
    // interpretable by `api::fetch_by_row_ids` (which builds its own segments from
        _ => None,
pub async fn execute_indexed_query(
        Some(permit),
        let df = rt.block_on(ctx.sql(sql)).expect("sql");
        tree: Arc::new(tree),
        predicate_columns,
/// `Arc::as_ptr` identity.
            return extraction;
            // to the residual so DF gets to evaluate them natively.
                            .map(|(pos, &idx)| (idx, pos))
        let wrapped = datafusion::physical_plan::stream::RecordBatchStreamAdapter::new(
/// Build the `prune_tree_config` tuple from a BoolNode tree and schema.
    // spawning on the CPU runtime, so the Java search thread blocks at the
        }
                    Some(annotation_id) => Some(Arc::new(
    // projection (→ OffsetIndex) are wired — a match()-only query still needs a
    let classification_override = handle.indexed_config.map(|config| {
    /// out get a single-page placeholder, which is fine for pruning but CORRUPTS
/// The reserved match-all Collector leaf (Java resolves the id to a `MatchAllDocsQuery` whose
                .and_then(residual_bool_to_physical_expr)
    // Extract the scheme+authority portion of the table URL for
}
        displayable(physical_plan.as_ref()).indent(true)
/// `Column::from_name`). Direction comparison is case-insensitive on `"asc"`/`"desc"`.
        let mut names = collect_plan_column_names(&plan);
            // on_batch_mask. Also covers an unfoldable constant (e.g. mktime('...') >
                    &segment.metadata,
    fn reverse_segments_single_keeps_its_base() {
    // Resolve classification: from Java config if available, otherwise derive from tree
        }
                          chunk,
            // None = no filter = full scan.
    // DF still wants a sane value for any post-scan operators it may add. The
        ))
                                format!(
                assert_eq!(children.len(), 2);
                )
                DataFusionError::Internal(
        BoolNode::DelegationPossible { original_expr, .. } => out.push(Arc::clone(original_expr)),
    }
        sort_fields: shard_view.sort_fields.clone(),
            if let Some(col) = node.downcast_ref::<Column>() {
    let extraction = if deleted_doc_filtering_required {
                                rg_bloom_pruned: stream_metrics.rg_bloom_pruned.clone(),
            tree: Arc::new(tree),
use std::fmt;
                            )
                                io_handle: io_handle.clone(),
            BoolNode::Collector { .. } => None,
    let stream_handle = crate::api::QueryStreamHandle::with_physical_plan(
            let residual_bool = extract_single_collector_residual(&e.tree);
use crate::cross_rt_stream::CrossRtStream;
/// `global_base` is the additive offset used to compute the QTF `__row_id__`:
    physical_expr::expressions::Column,
    logical_expr::Expr,
/// counter), so negative ids can never collide. Must match
            // the residual has zero Collectors — no Literal(true) substitution
/// the query's direction is the **opposite** of the catalog's. In that case the
                          chunk,
                        let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
            let performance_provider_locks: Arc<
    // Extract context_id early so it can be captured by the per-segment closures
    let table_name = handle.table_name;
                        for (idx, provider) in providers.iter().enumerate() {
        let tree = BoolNode::And(vec![
    if page_index::is_scoped_page_index_enabled() {
    #[test]
/// Reverse the iteration order of `segments` in place. Per-segment `global_base`
        assert!(matches!(
    }
            // pure-predicate subtrees in a SingleCollector-classified tree).
                assert_eq!(children.len(), 2);
        let plan = build_logical_plan("SELECT id FROM t ORDER BY id ASC LIMIT 10");
            descending: true,
        // No projection expressions name id/ts/v, but `SELECT *` reads all three.
    Ok(Box::into_raw(Box::new(stream_handle)) as i64)
        BoolNode::Predicate(expr) => out.push(Arc::clone(expr)),
        use datafusion::physical_plan::empty::EmptyExec;
/// the query wants, so iterating them tail-first feeds the largest values to a
    let mut segments = segments;
            }
            // Drop releases the Lucene Weight via `releaseProvider`.
/// from the handle.
    table_name: String,
    let mut exprs = Vec::new();
                        ));
        // OR(C₁, C₂) is covered: the union of two live-filtered collector bitmaps still
// TODO: remove once api.rs migrates to instruction-based path directly.
/// Execute an indexed query.
            column: "id".to_string(),
) -> Result<i64, DataFusionError> {
            });
    fn pred() -> BoolNode {
use std::sync::Arc;
                return Some(TopSort {
fn live_docs_collector() -> BoolNode {
    #[test]
            // SingleCollector is AND(Collector?, DelegationPossible*, residual*) so
            // connective changes from De Morgan (e.g. NOT(AND(...)) -> OR(NOT...))
        None => match &extraction {
            (2, _) => FilterClass::Tree,
            assert!(
    let (segments, schema) = build_segments(
    let leaf_exprs = collect_leaf_exprs(extraction.as_ref());
    //   `on_batch_mask` using arrow kernels; no pushdown needed.
                            collector_opt,
        let out =
            Field::new("ts", DataType::Int64, false),
                if parquet_cols.is_empty() && offset_cols.is_empty() {
        execute_indexed_with_context_inner(handle, substrait_bytes, cpu_executor, permit);
        use datafusion::physical_plan::ExecutionPlan;
        }
        .map_err(|e| DataFusionError::Execution(format!("execute_stream: {}", e)))?;
                                Some(provider) => {
}
/// which is also unqualified). `descending` is `true` for `ORDER BY x DESC`.
    schema: &SchemaRef,
                .as_ref()
    execution::object_store::ObjectStoreUrl,
        // excludes deleted docs, so no live-docs collector is injected. Tree unchanged.
use crate::cache::page_index;
                assert!(matches!(
                            });
        BoolNode::And(children) => {
                .as_ref()
    } else {
                                stream_metrics.ffm_collector_calls.clone(),
            BoolNode::And(children) => {
        let out = ensure_live_docs_coverage(extraction_of(BoolNode::And(vec![pred(), pred()])));
    let leaf_predicates: HashMap<usize, Arc<PruningPredicate>> = leaf_exprs
        }
    fn should_reverse_segments_field_name_case_sensitive() {
            handle.prepared_plan.as_ref()
        }
            sort_min: None,
        match r {
    // the vanilla path. File-metadata and file-statistics caches are inherited
            Field::new("v", DataType::Int32, false),
            context_id,
    schema: &SchemaRef,
/// For a tree classified as `SingleCollector`, walk it to find the single
    ctx.register_table(&register_name, placeholder)?;
    // non-empty table_name gate, so hash-shuffle WORKER sessions (empty object_metas but scanning
                assert!(matches!(children[1], BoolNode::Not(_)));
                assert_eq!(children.len(), 3);
/// (newest-segment-first feeds TopK earlier and lets page stats prune older
                                arrow_schema: Arc::clone(&bloom_schema),
            );
            wrapped,
    }
}
            column: "id".to_string(),
        // AND(C, AND(P, OR(P, P))) → AND(P, OR(P, P))
        .map_err(|e| DataFusionError::Execution(format!("decode substrait: {}", e)))?;
            parquet_size: 0,
                }
        match node {
            }
                            page_prune_metrics: Some(PagePruneMetrics::from_stream_metrics(
                Ok(TreeNodeRecursion::Continue)
        );
        // Coordinator annotation ids are non-negative (PlannerContext counter); the reserved
    }
};
            for segment in segments.iter_mut() {
    // types. The target is schema_coerce::coerce_inferred_schema(physical_schema) — same
    }
    fn should_reverse_segments_matches_leading_field_opposite_direction() {
                                }
    }
                            .iter()
    fn schema(&self) -> SchemaRef {
                if let Some(id) = single_collector_id(child) {
use crate::parquet_page_cache::{
            node,
        ctx.register_batch(
        .filter_map(|expr| {
    fn is_live_docs_leaf(node: &BoolNode) -> bool {
    let metadata_cache = state.runtime_env().cache_manager.get_file_metadata_cache();
            let residual_expr = residual_bool
/// Builds per-leaf PruningPredicates from pre-collected leaf exprs.
    register_listing_table(&ctx, &table_name, shard_view.table_path.clone(), &[], &[]).await?;
    let dataframe = ctx.execute_logical_plan(logical_plan).await?;
        );
            // get absorbed into the surrounding Or if applicable.
        assert!(analyze_top_sort(&plan).is_none());
    );
                Arc::new(map)
    ))
    /// for decompressed data"), or underflows the read byte range. The
        let fields = vec!["id".to_string()];
                df_stream,
        &shard_view.table_path,
                datafusion::parquet::schema::types::Type::group_type_builder("schema")
    #[test]
        aggregate_mode: crate::agg_mode::Mode::Default,
            other => panic!("expected And, got {:?}", other),
        *Box::from_raw(session_ctx_ptr as *mut crate::session_context::SessionContextHandle);
    }
        reverse_segment_iteration_order(&mut segs);
                    .build()
            let schema_for_pruner = schema.clone();
                            Arc::clone(&performance_provider_locks),
    // Widen to the plan's base_schema so columns absent from this shard's parquet (cross-shard drift) are null-filled at read time.
            row_groups: vec![],
    // scoped OffsetIndex so the reader fetches only matched pages.
}
        {
    }
            None => FilterClass::None,
        let fields = vec!["id".to_string()];
            let call_strategy = CollectorCallStrategy::PageRangeSplit;
/// rebuilds segments via `build_segments` against `ShardView.object_metas` (always
        &sort_fields,
                            bloom_config,
    fn coverage_skips_and_with_covered_collector_and_not() {
                            cost_predicate,
) -> Result<i64, DataFusionError> {
    #[test]
        let (cross_rt_stream, abort_handle, _task_done) =
use crate::api::ShardView;
            // Normalize: push NOTs to leaves (De Morgan) then flatten nested
        let empty_exec = EmptyExec::new(Arc::clone(&plan_schema));
                        Arc::new(SingleCollectorEvaluator::new(
        let orders = vec!["asc".to_string()];
                    schema_for_pruner.clone(),
    #[test]
//!   1. `createProvider(annotation_id)` FFM upcall → `provider_key`  (once per
    }
                    segment.metadata = augmented;
        let r = extract_single_collector_residual(&tree).unwrap();
    };
            }
    // never consults supports_filters_pushdown and keeps the delegated_predicate FilterExec —
    let physical_plan = dataframe.create_physical_plan().await?;
                assert_eq!(children.len(), 2);
            Some(e) => classify_filter(&e.tree),
    };
            _ => return None,
            other => panic!("expected And residual, got {:?}", other),
    names.into_iter().collect()
    // SessionContext already has RuntimeEnv, caches, memory pool, UDF from create_session_context_indexed.
};
        let orders = vec!["asc".to_string(), "asc".to_string()];
    }
            Arc::new(prepared.schema().as_ref().clone())
            let extraction = extraction.as_ref().ok_or_else(|| {
        query_config: Arc::clone(&query_config),
                if let Expr::Column(col) = e {
                assert_eq!(children.len(), 2);
                            pruner,
        _state: &dyn Session,
                None,
    #[test]
            let correctness_provider: Option<Arc<ProviderHandle>> =
    // QTF safe: `reverse_segment_iteration_order` deliberately does NOT recompute `global_base`
                None
                            stats_prune_tree: stats_prune_tree.cloned(),
        // its real multi-page one) corrupts the page read: arrow decodes the whole
    }
            }
    //   In block-granular mode the evaluator's `on_batch_mask` applies
    let ptr = Box::into_raw(Box::new(handle)) as i64;
        Arc::clone(&store),
    cpu_executor: DedicatedExecutor,
            }
        }
        reverse_segment_iteration_order(&mut segs);
        physical_plan
                    &offset_cols,
        writer_generations.as_ref(),
        .expect("register_batch");
            let extraction = extraction.ok_or_else(|| {
    // gate when it is full — creating backpressure at the Java threadpool level.
}
                assert!(is_live_docs_leaf(&children[0]));
            // Weight do so once per (query × annotation_id), not per chunk.
                        let result = build_pruning_predicate(expr, Arc::clone(&schema_for_pruner));
    let ctx = handle.ctx;
pub(crate) fn reverse_segment_iteration_order(segments: &mut [SegmentFileInfo]) {
                )
    /// (projected `v` + filter `id` + sort `ts`) — the scoping benefit is retained.
    // `ShardView.object_metas` in catalog order).
                            .collect();
/// For a tree classified as `SingleCollector`, return the residual
    physical_plan::displayable,
/// Reversing only the iteration order — i.e. the order in which chunks/RGs are
///
    let io_handle = handle.io_handle;
            "t",
    fn strip_collectors(node: &BoolNode) -> Option<BoolNode> {
            LogicalPlan::SubqueryAlias(a) => current = a.input.as_ref(),
            // needed (unlike bool_tree_to_pruning_expr which handles arbitrary
    .await
            // OR/NOT with no collectors pass through unchanged (they're
            // shared across all per-(segment×chunk) closures via Arc::clone — so
                            Arc::new(crate::indexed_table::eval::single_collector::FfmDelegatedBackendCollectorFactory),
                assert!(children
    #[test]
    // ── reverse_segment_iteration_order ───────────────────────────────
            Ok(TreeNodeRecursion::Continue)
    // Production uses df_execute_with_context which acquires the gate on IO for backpressure.
        .indexed_config
use native_bridge_common::log_debug;
        }
    // This makes the indexed executor produce Binary HLL state (Partial) instead of Int64 (Final).
    build_query_runtime_env_with_store, build_query_session_context, register_listing_table,
                            Some(PagePruneMetrics::from_stream_metrics(stream_metrics)),
        let p2 = pred();
    // SingleCollector: residual (non-Collector top-AND children) →
        evaluator_factory: factory,
    let logical_plan = crate::substrait_consumer::from_substrait_plan(&ctx.state(), &plan).await?;
///   root — required under NOT, where leaf-level liveDocs filtering readmits deleted docs but a
            for child in children {
                        Arc::new(crate::indexed_table::eval::predicate_evaluator::PredicateOnlyEvaluator::new(
        wrapped,
    let partition_weight = num_partitions.max(1) as u32;
        )
            let cost_collector = query_config.cost_collector;
        assert!(!should_reverse_segments(Some(&top), &fields, &orders));
                            .map_err(|e| {
                .unwrap()
                        let pruner = Arc::new(PagePruner::new(
            descending: false,
        use datafusion::parquet::file::metadata::{FileMetaData, ParquetMetaData};
    let store = ctx.state().runtime_env().object_store(&table_path)?;
        // Build a minimal ParquetMetaData. We never read it back in these tests.
use crate::indexed_table::page_pruner::PagePruner;
        match out.tree.as_ref() {
                            max_collector_parallelism,
            // Build one `PruningPredicate` per unique `Predicate` leaf
        ]));
            _ => FilterClass::None,
    let deleted_doc_filtering_required = handle.deleted_doc_filtering_required;
///
            other => panic!("expected unchanged Or, got {:?}", other),
            let residual_pruning_predicate: Option<Arc<PruningPredicate>> = residual_expr
    }
            "indexed_executor: reversing segment iteration (catalog leading sort={:?} {:?}, query opposite)",
        )
            )
mod tests {
    collect_predicate_exprs(&e.tree, &mut exprs);
        let plan = build_logical_plan("SELECT id FROM t ORDER BY id DESC");
        let names = collect_plan_column_names(&plan);
        let r = extract_single_collector_residual(&tree).unwrap();
            BoolNode::Or(children) => {
        let rt = tokio::runtime::Builder::new_current_thread()
    // Permit was acquired by the caller (ffm.rs) on the IO runtime before
                          stream_metrics: &StreamMetrics,
                .push_not_down()
//!   4. `releaseCollector(collector)` when RG scan completes.
                                .enumerate()
    pub column: String,
        use datafusion::execution::context::SessionContext;
            // same `Arc<PhysicalExpr>` reaches the tree walker at
                assert_eq!(children.len(), 2);
    #[test]
        // computes catalog-order bases).
            );
    // same name. Using table_name for a multi-index query leaves the scan unbound, so DataFusion
            .build()
/// `MatchAllDocsQuery` whose per-RG collector emits the segment's liveDocs.
        "DataFusion logical plan:\n{}",
    let mut names = HashSet::new();
            Some(permit),
        let fields = vec!["id".to_string()];
                    &parquet_cols,
    ExtractionResult {
    sort_fields: &[String],
///
        let plan_schema: arrow::datatypes::SchemaRef = if let Some(prepared) =
    let token = crate::query_tracker::get_cancellation_token(context_id);
    substrait_bytes: Vec<u8>,
    physical_plan::execute_stream,
                Arc::new(
///
    #[test]
/// `TopK` first and parquet page stats prune the rest.
        schema: schema.clone(),
                match single_collector_id(&extraction.tree) {
        );
pub const LIVE_DOCS_MATCH_ALL_ANNOTATION_ID: i32 = -2;
            BoolNode::And(children) => {
    let permit = gate.acquire_many(partition_weight.min(max_p)).await;
    fn coverage_or_with_uncovered_branch_wraps_in_and() {
                            evaluator: Arc::new(BitmapTreeEvaluator),
}
    // No sort-order declaration on the indexed path (empty slices) — the indexed
    //   both mask and residual post-decode, and pushdown is suppressed
        }
//! builds providers per leaf, runs the query.
            BoolNode::And(children) => {
    }));
        // Performance-delegated leaves contribute their original expression to the
    permit: tokio::sync::OwnedSemaphorePermit,
    let ctx = build_query_session_context(&query_config, runtime_env, num_partitions, true);
    fn residual_bare_collector_is_none() {
        let ts = analyze_top_sort(&plan).expect("expected Sort");
/// - Other shapes (OR/NOT over collectors and predicates): the match-all Collector is AND'ed at the
    }
        match r {
    }
        } else {
        let tree = BoolNode::And(vec![collector(10), collector(11)]);
                            )),
                let leaves = extraction.tree.delegation_possible_leaves();
    SchemaRef,
                            Arc::clone(&segment.metadata),
    }
                    names.insert(col.name().to_string());
                            cost_collector,
    //
        .unwrap_or_else(|| table_name.clone());
                build_prune_tree_config(&extraction.tree, &schema_for_pruner, &leaf_exprs);
            object_path: object_store::path::Path::from(format!("seg-{}.parquet", global_base)),
                    .filter_map(|expr| {
                }
/// `column` is the bare column name (no qualifier — we compare against `index.sort.field`
            // Previously errored here when emit_row_ids was false (indexed path only).
                                object_path: segment.object_path.clone(),
    /// a real read — arrow decodes the whole chunk as one page ("output too small
/// single BoolNode). Recursively strips Collector leaves from nested
            let max_collector_parallelism = 1;
        let schema = Arc::new(Schema::new(vec![
            names,
                let residuals: Vec<BoolNode> =
                .as_ref()
    match tree {
        assert_eq!(segs.len(), 1);
                            pruning_predicates: Arc::clone(&pruning_predicates),
                    _ => Some(BoolNode::And(residuals)),
        assert_eq!(segs[0].global_base, 30); // C's catalog base, unchanged.
        assert_eq!(segs[1].max_doc, 20);
    physical_optimizer::pruning::PruningPredicate,
            BoolNode::And(children) => {
        let orders = vec!["asc".to_string()];
            // candidate stage. Predicates that fail to translate or
            // N) — no index column, but every row scanned and the constant applied as
/// (with UDF registered and IndexedExecutionConfig set) and routes to the appropriate
    )
    // empty stream. Mirrors the guard in query_executor::execute_with_context — including the
            // same-kind connectives. Flatten after push_not_down so the
    tree: &Arc<BoolNode>,
    crate::cancellation::cancellable(token.as_ref(), context_id, query_future)
                    "classify_filter returned Tree but extraction is None".into(),
        if let Some(rt) = cpu_executor.handle() {
            handle.ctx,
    fn build_logical_plan(sql: &str) -> datafusion::logical_expr::LogicalPlan {
            let prune_tree_config =
        }
        let metadata = std::sync::Arc::new(pq_meta);
                    "classify_filter returned SingleCollector but extraction is None".into(),
                .and_then(|expr| build_pruning_predicate(expr, Arc::clone(&schema_for_pruner)));
                            residual_expr.clone(),
            .unwrap();
        BoolNode::Collector { .. } => {}
/// Collect leaf predicate exprs from the extraction tree in a single traversal.
    // the scheme+authority ("file:///").
            // performance-delegated leaves and no Collector at all.
// with minimal changes.
        assert_eq!(single_collector_id(&out.tree), Some(7));
            BoolNode::And(vec![collector(0), collector(1)]),
            BoolNode::And(children) => {
            // resolve to always-true are omitted; the walker's
    extraction: Option<&ExtractionResult>,
        );
                    None => None,
    }
    // narrowing the partition-stream registration uses, so consumer-side StreamingTable
            }
    #[test]
        // Original: A(max_doc=10, base=0), B(max_doc=20, base=10), C(max_doc=30, base=30).
    // executor drives ordering itself via IndexedExec.
                        ));
            );
            None
    }
            > = {
        .as_ref()
            }
        }
            sort_orders.first()
        ]);
            }
    fn should_reverse_segments_no_catalog_sort() {
        // New iteration order: C, B, A.
                    names.insert(field.name().to_string());
    #[test]
        .map_err(|e| DataFusionError::Execution(format!("parse table_path URL: {}", e)))?;
                            context_id,
                    map.entry(*annotation_id)
 *
fn extract_single_collector_residual(tree: &BoolNode) -> Option<BoolNode> {
    ) -> Result<Arc<dyn ExecutionPlan>, DataFusionError> {
/// scheduled by `compute_assignments` — is the *whole* point of this optimization
use crate::api::DataFusionRuntime;
    // which then executes the marker UDF and errors.
                    descending: !leading.asc,
        assert!(extract_single_collector_residual(&tree).is_none());
                }
    );
    // with IndexedTableProvider after plan decoding.
    let register_name = crate::api::first_named_table_name(substrait_bytes.as_slice())
                    .collect(),
            other => BoolNode::And(vec![live_docs_collector(), other]),
        FilterClass::Tree => None,
    let requests_row_ids = handle
            LogicalPlan::Filter(f) => current = f.input.as_ref(),
                    },
            dummy_segment(30, 30),
        if let Some(h) = abort_handle {
        );
/// TODO: extract shared logic with `execute_indexed_query` to avoid duplication.
            };
            let schema_for_pruner = schema.clone();
                BoolNode::And(children)
    };
    /// load gives only these columns a REAL multi-page OffsetIndex; columns left
            //
                            Some(crate::indexed_table::eval::single_collector::BloomConfig {
                assert!(matches!(children[1], BoolNode::Not(_)));
        FilterClass::None => {
                                context_id,
    let df_stream = execute_stream(physical_plan.clone(), ctx.task_ctx())
                    },
    .map_err(DataFusionError::Execution)?;
    }
            _ => panic!("expected AND, got {:?}", r),
};
    }
    fn dummy_segment(max_doc: i64, global_base: u64) -> SegmentFileInfo {
        };
            dummy_segment(10, 0),
                                    .clone(),
                        let eval: Arc<dyn RowGroupBitsetSource> =
struct PlaceholderProvider {
    arrow::datatypes::SchemaRef,
    };
    collect_predicate_exprs(&e.tree, &mut exprs);
use crate::datafusion_query_config::DatafusionQueryConfig;
                assert!(is_live_docs_leaf(&children[0]));
        query_config: Arc::unwrap_or_clone(query_config),
//!      (once per SegmentChunk × Collector leaf).
            let pruning_predicates: Arc<HashMap<usize, Arc<PruningPredicate>>> = Arc::new(
        let predicate_column_names = collect_predicate_column_names(extraction.as_ref(), &schema);
                                provider.key(),
            // trees). DelegationPossible leaves contribute their original_expr
                .and_then(residual_bool_to_physical_expr);
        // column chunk as a single page → "output too small for decompressed data"
            })?;
                    BoolNode::Collector { annotation_id: 1 }
            BoolNode::Collector { annotation_id: 3 }
    Some((
            crate::query_tracker::set_cpu_runtime_handle(context_id_early, rt);
                .and_then(|e| build_prune_tree_config(&e.tree, &schema_for_pruner, &leaf_exprs));
            dummy_segment(20, 10),
        sort_orders: shard_view.sort_orders.clone(),
                names.iter().any(|n| n == expected),
///   top-level AND with the live set masks them regardless of the inner shape.
        assert_eq!(ts.column, "ts");
async unsafe fn execute_indexed_with_context_inner(
        assert_eq!(ts.column, "id");
        },
    }
            //   - `on_batch_mask` refinement in block-granular mode.
            sort_fields.first(),
                        Ok(eval)
    }
            BoolNode::And(children) => {
                            chunk.row_group_indices.iter().enumerate().map(|(pos, &idx)| (idx, pos)).collect(),
                    &segment.arrow_schema,
        let right: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(0))));
                    &predicate_column_names,
        self.schema.clone()
use substrait::proto::Plan;
        // emits / reads. Critically this captures `SELECT *` (and any projection
        assert_eq!(
 * this file be licensed under the Apache-2.0 license or a
        segments,
    #[test]
        &register_name,
            let prune_tree_config = if pruning_predicates.is_empty() {
        }
    let catalog_descending = catalog_order.eq_ignore_ascii_case("desc");
                            &schema_for_pruner,
                                bloom_filter_eval_time: stream_metrics
        let p1 = pred();
        Some(ref expr) => Some(
                {
    fn reverse_segments_preserves_global_base() {
    context_id: i64,
        let fields = vec!["a".to_string(), "b".to_string()];
            "PlaceholderProvider should not be scanned".into(),
            BoolNode::And(children) => {
}
                .flatten();
        store_url,
    fn coverage_no_filter_becomes_bare_live_docs_collector() {
use prost::Message;
        // AND(AND(C₁, C₂), AND(C₃, C₄)) → no residual
/// dispatcher to build a per-leaf `PruningPredicate` cache keyed by
        // (or, upstream, the (0,0)-page byte-range subtract underflow).
        // using the original expr; only the per-RG decision differs.
        Err(DataFusionError::Internal(
                ));
/*
fn single_collector_id(tree: &BoolNode) -> Option<i32> {
                        let resolved = Arc::new(resolved);
        annotation_id: LIVE_DOCS_MATCH_ALL_ANNOTATION_ID,
                .map_err(|e| DataFusionError::Execution(format!("decode substrait: {}", e)))?;
    }
    exprs
            column: "ID".to_string(),
                                    let collector = FfmSegmentCollector::create(
        // AND(C, NOT(C₂)): the AND is covered by C — intersecting with C's live-only bitmap
        assert!(extract_single_collector_residual(&tree).is_none());
    collect_predicate_exprs(&e.tree, &mut exprs);
            arrow_schema: std::sync::Arc::new(datafusion::arrow::datatypes::Schema::empty()),
/// Collector leaf and return its query bytes.
                ));
                        // Bloom-filter row-group pruning is always enabled on the indexed read path.
fn collect_predicate_column_names(
            column: "b".to_string(),
        // predicates stay as the residual. Classification must remain SingleCollector.
#[derive(Debug, Clone, PartialEq, Eq)]
            out.tree.as_ref(),
    // Deregister the default ListingTable (registered by create_session_context) — will be replaced
    session_ctx_ptr: i64,
                datafusion::logical_expr::Distinct::All(input) => current = input.as_ref(),
        assert!(extract_single_collector_residual(&collector(10)).is_none());
            BoolNode::And(vec![pred(), BoolNode::Or(vec![pred(), pred()])]),
            }
                                    provider.key(),
            Arc::new(logical_plan.schema().as_arrow().clone())
        assert!(LIVE_DOCS_MATCH_ALL_ANNOTATION_ID < 0);
            Ok(TreeNodeRecursion::Continue)
        assert!(!ts.descending);
    let query_config = Arc::new(handle.query_config);
            // multiple DataFusion threads racing to populate the same Lucene
                    &segment.metadata,
                    children[0],
        &schema,
        ])));
        // is what masks them.
    unsafe { execute_indexed_with_context(ptr, substrait_bytes, cpu_executor, permit).await }
pub(crate) fn should_reverse_segments(
        let tree = BoolNode::And(vec![
                            residual_pruning_predicate.clone(),
    let physical_plan = crate::relabel_exec::wrap_if_relabel_needed(physical_plan, target_schema)?;
    }
            collector(1),
            collector(2),
/// nodes that don't reorder rows or rewrite sort key columns. On reaching
        ]);
        // Reversal must keep each segment's original `global_base` intact so QTF row IDs
                ),
        match current {
        }
            ensure_live_docs_coverage(extraction_of(BoolNode::Or(vec![collector(1), pred()])));
                    Expr::Column(c) => c.name.clone(),
        let ctx = SessionContext::new_with_state(state);
    // IndexedExec partitions (derived from num_partitions), not DataFusion's, but
                assert!(is_live_docs_leaf(&children[0]));
/// All comparisons are case-sensitive on the field name (matching PR #22041's
        let tree = BoolNode::And(vec![collector(10), pred()]);
    let plan = Plan::decode(substrait_bytes.as_slice())
        assert!(should_reverse_segments(Some(&top), &fields, &orders));
        // `ORDER BY abs(v)` — leading sort key isn't a plain column. Catalog monotonicity
            BoolNode::And(children) => {
        writer_generations: shard_view.writer_generations.clone(),
            other => panic!("expected And, got {:?}", other),
        ];
    shard_view: &ShardView,
        let mut segs = vec![
    }
        let projection_column_names = collect_plan_column_names(&logical_plan);
        let schema = std::sync::Arc::new(
        for expected in ["v", "id", "ts"] {
        let file_meta = FileMetaData::new(0, 0, None, None, schema, None);
        .collect();
    #[test]
            collector(10),
                        let resolved = tree.resolve(&per_leaf).map_err(|e| {
/// `global_base`. For the round trip to hold, both phases must agree on each
        pushdown_predicate,
/// evaluator based on the Java-provided FilterTreeShape.
                    })
                            leaves: Arc::new(CollectorLeafBitmaps::new(
        .iter()
            let bloom_store = Arc::clone(&store);
        let orders = vec!["asc".to_string()];
        assert_eq!(segs[2].max_doc, 10);
                                    segment.writer_generation,
    strip_collectors(tree)
        let top = TopSort {
        let df_stream = empty_exec.execute(0, handle.ctx.task_ctx())?;
        assert_eq!(segs[0].global_base, 7);
        }
) -> Option<(
        }
        return false;
    fn extraction_of(tree: BoolNode) -> Option<ExtractionResult> {
    let runtime_env = build_query_runtime_env_with_store(
    let aggregate_mode = handle.aggregate_mode;
    ctx.deregister_table(&register_name)?;
            )),
    let schema = crate::schema_coerce::coerce_inferred_schema(schema);
        let out = ensure_live_docs_coverage(extraction_of(BoolNode::Or(vec![pred(), pred()])));
                    },
        &sort_orders,
        ])));
        Some(extraction) => match Arc::unwrap_or_clone(extraction.tree) {
        let r = extract_single_collector_residual(&tree).unwrap();
            }
    fn should_reverse_segments_no_query_sort() {
        }),
            vec!["id".to_string(), "ts".to_string(), "v".to_string()],
//!   2. `createCollector(provider_key, seg, min, max)` FFM upcall → collector
        let state = SessionStateBuilder::new().with_default_features().build();
    };
        assert!(is_live_docs_leaf(&out.tree));
        _projection: Option<&Vec<usize>>,
    let table_path = handle.table_path;
    fn analyze_top_sort_descends_through_limit() {
///
        has_topk: false,
                            residual_pruning_predicate.clone(),
            runtime.runtime_env.memory_pool.clone(),
    }
    // for multi-index queries, the concrete name otherwise), not the per-shard table_name.
        FilterClass::SingleCollector => {
                .map(|pp| (Arc::as_ptr(expr) as *const () as usize, pp))
                        ));
    sort_orders: &[String],
                    0 => None,
        // live-docs-filtered on the Java side; injecting a second collector would demote
            let logical_plan =
        Arc::clone(&shard_view.store),
    let schema = crate::session_context::widen_schema_from_plan(
// TODO: remove this function once all callers migrate to the instruction-based path
                assert!(children[1..].iter().all(is_predicate));
    }
}
use crate::indexed_table::ffm_callbacks::{create_provider, FfmSegmentCollector, ProviderHandle};
        })
        let out = ensure_live_docs_coverage(extraction_of(BoolNode::Or(vec![
/// `id = segment.global_base + position`. The fetch phase (`api::fetch_by_row_ids`)
            let tree = Arc::try_unwrap(extraction.tree)
    fn collect_plan_column_names_includes_select_star_columns() {
                .as_ref()
    };
    segments.reverse();
                    Arc::clone(&pruning_predicates),
        }
        }
            }
//! Per-leaf lifecycle at query time (one compiled-query + per-segment matcher
                    move |segment: &SegmentFileInfo,
            (
                        create_provider(context_id, annotation_id)
)> {
use crate::indexed_table::segment_info::build_segments;
        assert!(ts.descending);
    }
                                provider.key(),
impl TableProvider for PlaceholderProvider {
        match (config.tree_shape, config.delegated_predicate_count) {
                        Ok(eval)
        match out.tree.as_ref() {
        if !predicate_column_names.is_empty() || !projection_column_names.is_empty() {
    #[test]
                                    .bloom_filter_eval_time
        let _ = expr.apply(|node| {
    log_debug!(
                .and_then(|e| residual_bool_to_physical_expr(&e.tree));
        return false;
                if let Some(augmented) = load_scoped_page_index_cols(
    let Some(e) = extraction else { return vec![] };
use crate::indexed_table::bool_tree::residual_bool_to_physical_expr;
    //
/// Decide whether to flip segment iteration order for the indexed scan.
                    &segment.object_path,
        crate::agg_mode::apply_aggregate_mode(physical_plan, aggregate_mode, handle.has_topk)?
        let fields = vec!["id".to_string()];
    }
    common::tree_node::{TreeNode, TreeNodeRecursion},
                DataFusionError::Internal(
            let schema_for_pruner = schema.clone();
///
        BoolNode::Collector { annotation_id: id }
                let (parquet_cols, offset_cols) = resolve_predicate_parquet_columns_pair(
        });
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
    let store_url = ObjectStoreUrl::parse(format!("{}://{}", parsed.scheme(), parsed.authority()))?;
        // pushed into the scan), where no Projection expression lists the columns
                    column: col,
    ) {
    }
        Some(ensure_live_docs_coverage(extraction))
/// Returns `true` iff the catalog has a sort declaration, the query has a top-level
                            rg_index_to_pos,
            (
    use datafusion::logical_expr::Operator;
                );
        reverse_segment_iteration_order(&mut segments);
    #[test]
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        &ctx,
    fn should_reverse_segments_catalog_desc_query_asc() {
        return false;
    #[test]
        prune_tree_config,
    fn table_type(&self) -> TableType {
                assert_eq!(children.len(), 2);
        analyze_top_sort(&logical_plan).as_ref(),
    fn analyze_top_sort_descends_through_projection() {
        let plan_schema = crate::schema_coerce::coerce_inferred_schema(plan_schema);
                            stats_prune_tree.cloned(),
            descending: true,
                assert_eq!(children.len(), 2);
// ── Placeholder provider used only for substrait consume pass ─────────
            Ok(TreeNodeRecursion::Continue)
                prune_tree_config,
            //   - Page-stats pruning in candidate stage (via PruningPredicate).
        match out.tree.as_ref() {
        assert_eq!(classify_filter(&out.tree), FilterClass::Tree);
        match residual {
    // `scan()` ignores DataFusion's filters argument (which contains
        phantom_reservation: None,
                            match &correctness_provider {
/// (all non-Collector parts of the AND tree, re-assembled into a
        cancellation_token: crate::query_tracker::get_cancellation_token(context_id),
    use datafusion::physical_expr::PhysicalExpr;
                        let pruner = Arc::new(PagePruner::new(
        assert!(is_predicate(&r));
        });
        FilterClass::SingleCollector => extraction.as_ref().and_then(|e| {
        &self,
        query_context: crate::query_tracker::QueryTrackingContext::new(
        let top = TopSort {
        let top = TopSort {
        };
    }
    }
    names.into_iter().collect()
                            tree: resolved,
    use datafusion::common::ScalarValue;
        ]);
                        let collector_opt: Option<Arc<dyn RowGroupDocsCollector>> =
        assert_eq!(segs.len(), 3);
    // and producer-side batches agree by construction (see crate::relabel_exec).
}
            BoolNode::And(vec![collector(0), BoolNode::And(vec![collector(1), p2])]),
            other => Some(other.clone()),
        &sort_fields,
        return Ok(Box::into_raw(Box::new(stream_handle)) as i64);
                                "tree.resolve for segment gen={}: {}",
            other => panic!("expected And, got {:?}", other),
            handle.query_context,
    // ── extract_single_collector_residual ─────────────────────────────
use crate::indexed_table::eval::{CollectorCallStrategy, RowGroupBitsetSource, TreeBitsetSource};
            BoolNode::And(vec![collector(11), pred()]),
        TableType::Base
/// catalog-order shard-global row ID space.
        assert!(is_predicate(&r));
                prune_tree_config,
    let num_partitions = query_config.target_partitions.max(1);
        // (the OR subtree has no collectors, so it rides as the residual).
        assert!(segs.is_empty());
                            .row_group_indices
    // The substrait scan binds to the plan's NamedTable name (the alias/pattern like "tb-1,tb-2"
        let mut segs = vec![dummy_segment(42, 7)];
                                segment.writer_generation,
                            stats_prune_tree.cloned(),
        assert!(!should_reverse_segments(Some(&top), &fields, &orders));
    });
            // residual (pushdown is Exact, so DataFusion drops the FilterExec).
) -> Vec<String> {
                assert_eq!(children.len(), 2);
    }
}
        let out = ensure_live_docs_coverage(extraction_of(collector(3)));
                        let pruner = Arc::new(PagePruner::new(
            metadata,
                .as_ref()
                for (annotation_id, _expr) in &leaves {
                ),
        ),
                                    chunk.doc_max,
            cross_rt_stream,
                                .map(|(pos, &idx)| (idx, pos))
            expr_to_bool_tree(expr, &schema, &state)
                            segment.writer_generation,
        table_path: shard_view.table_path.clone(),
pub(crate) fn analyze_top_sort(plan: &datafusion::logical_expr::LogicalPlan) -> Option<TopSort> {
    } else {
    query_memory_pool: Option<Arc<dyn MemoryPool>>,
        ]);
            BoolNode::Predicate(_) => Some(node.clone()),
    }
//!   3. `collectDocs(collector, min, max, out)` FFM upcall (once per row group).
    fn analyze_top_sort_returns_none_for_function_sort_key() {
        None => live_docs_collector(),
        ctx,
    #[test]
    fn reverse_segments_empty_is_noop() {
        // id must never collide.
        }
                                metadata: Arc::clone(&segment.metadata),
    // the indexed PagePruner can page-prune. Both predicate (→ ColumnIndex) and
    let filter_expr = extract_filter_expr(&logical_plan);
    use std::sync::Arc;
                if let Some(field) = schema.fields().get(col.index()) {
                assert!(matches!(children[1], BoolNode::Or(_)));
    use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
        runtime,
    }
                        .or_insert_with(|| Arc::new(std::sync::OnceLock::new()));
pub async unsafe fn execute_indexed_with_context(
/// Why not recompute global_base after reversing?
    let mut exprs = Vec::new();
    fn residual_deeply_nested_and() {
    fn should_reverse_segments_matches_leading_field_same_direction() {
        matches!(node, BoolNode::Predicate(_))
    fn should_reverse_segments_query_sort_on_non_leading_catalog_field() {
        ),
        &state,
            build_pruning_predicate(expr, Arc::clone(schema))
        query_memory_pool,
        assert_eq!(segs[2].global_base, 0); // A's catalog base, unchanged.
    fn residual_nested_and_with_or_predicate() {
            c.iter().for_each(|ch| collect_predicate_exprs(ch, out))
    // per-query pool overlay) and register the shard object store — shared with
    physical_expr::PhysicalExpr,
                    )),
        let _ = expr.apply(|node| {
        };
    #[test]
//! per Collector leaf):
        };
        }
}
                            )),
        assert!(!should_reverse_segments(None, &fields, &orders));
                            stream_metrics.ffm_collector_calls.clone(),
use crate::indexed_table::metrics::StreamMetrics;
        crate::query_tracker::set_cpu_runtime_handle(context_id, rt);
    #[test]
    }
            // Performance-delegated provider locks (lazy). Built ONCE per query,
        assert_eq!(segs[1].global_base, 10); // B's catalog base, unchanged.
        logical_plan.display_indent()
            single_collector_id(&out.tree),
                            &schema_for_pruner,
                          stats_prune_tree: Option<&Arc<StatsPruneTree>>| {
    let sort_orders = handle.sort_orders;
        assert_eq!(classify_filter(&out.tree), FilterClass::SingleCollector);
};
                            )
            (
    #[test]
    log_debug!(
    let writer_generations = handle.writer_generations;
        }
/// the shard has deletions. Returns the extraction unchanged when a correctness Collector already
}
    top.descending != catalog_descending
        // PruningPredicate cache exactly like a plain Predicate — DF prunes pages
    collect_predicate_column_indices_from_exprs(&exprs)
        let out = ensure_live_docs_coverage(extraction_of(BoolNode::And(vec![
                        }
                            .map_err(|e| format!("leaf {} collector: {}", idx, e))?;
                    BoolNode::Collector { annotation_id: 7 }
    fn analyze_top_sort_returns_none_when_no_sort() {
}
    // Build the per-query RuntimeEnv (list-files cache pre-populated, optional
    fn coverage_skips_existing_single_collector_shape() {
                        });
///   the correctness collector, so per-RG candidates are exactly the segment's live docs.
                std::collections::HashMap<i32, Arc<std::sync::OnceLock<ProviderHandle>>>,
    // the `delegated_predicate` UDF marker whose body panics) and uses this
    );
    // On a shard with deletions, constrain the decoded tree to live docs (see
    // from the global runtime for cross-query reuse.
            other => panic!("expected unchanged And, got {:?}", other),
//!
        BoolNode::Predicate(Arc::new(BinaryExpr::new(left, Operator::Eq, right)))
        _limit: Option<usize>,
    );
    // create_session_context registered the provider under that name, so re-register under the
    /// expression lists them. Collecting each plan node's OUTPUT SCHEMA fixes it.
                    .all(|c| matches!(c, BoolNode::Collector { .. })));
    for expr in exprs {
        Some(extraction) if extraction.tree.is_covered_by_live_docs() => {
        Arc::clone(schema),
        // Catalog: [a ASC, b ASC]; query: ORDER BY b DESC. Segments are monotonic on `a`
            Some(LIVE_DOCS_MATCH_ALL_ANNOTATION_ID)
                            call_strategy,
        _filters: &[Expr],
        return None;
        let context_id_early = handle.query_context.context_id();
    let Some(e) = extraction else { return vec![] };
                            .map_err(|e| DataFusionError::External(e.into()))?,
                            )
                    _ => return None,
fn collect_leaf_exprs(extraction: Option<&ExtractionResult>) -> Vec<Arc<dyn PhysicalExpr>> {
        use datafusion::execution::SessionStateBuilder;
        // masks the deleted docs that NOT(C₂) would otherwise re-admit. Tree unchanged.
                                    "FfmSegmentCollector::create(context_id={}, provider={}, writer_generation={}, doc_range=[{},{})): {}",
    //   PhysicalExpr for `ParquetSource::with_predicate`. In
fn build_prune_tree_config(
    // Build SessionContextHandle and delegate to execute_indexed_with_context
                children.insert(0, live_docs_collector());
                };
        match out.tree.as_ref() {
            }
            // in the tree. Key = `Arc::as_ptr(expr) as usize` — the
    #[test]
                ));
    Arc<BoolNode>,
    let Some(top) = top_sort else { return false };
                          stream_metrics: &StreamMetrics,
        f.debug_struct("PlaceholderProvider").finish()
    // Per-shard hasDeletions signal from the Java ShardScan handlers; drives the live-docs
    schema: SchemaRef,
            BoolNode::And(children) => {
    }
    physical_plan::stream::RecordBatchStreamAdapter,
            } else {
            descending: false,
                prune_tree_config,
                Some((
            };
        prepared_plan: None,
            // StatsPruneTree children indices align with ResolvedNode children
                .map_err(|e| DataFusionError::Execution(format!("expr_to_bool_tree: {}", e)))?,
            }
    // ── collect_plan_column_names ─────────────────────────────────────
/// For now this delegates to the existing function by reconstructing the needed args
        schema: schema.clone(),
    }
    if let Some(rt) = cpu_executor.handle() {
                    Arc::clone(&tree),
        object_metas: shard_view.object_metas.clone(),
                Arc::new(
    #[test]
 * SPDX-License-Identifier: Apache-2.0
                            segment.arrow_schema.clone(),
            datafusion::parquet::schema::types::SchemaDescriptor::new(std::sync::Arc::new(
        // FilterTreeShape: 1 = CONJUNCTIVE → SingleCollector, 2 = INTERLEAVED → Tree.
                    &schema,
    #[test]
/// tree is collectors-only (no residual predicates).
                            Vec::with_capacity(providers.len());
/// guarantees live-only output ([`BoolNode::is_covered_by_live_docs`]). Shapes:
    }
        crate::query_tracker::set_abort_handle(context_id, h);
            other => panic!("expected unchanged And, got {:?}", other),
 * The OpenSearch Contributors require contributions made to
                            segment.arrow_schema.clone(),
        // (the leading key), not `b`. Reversing won't help — decline.
                }
    let mut current = plan;
        // Output-schema columns of every node: this is what each node actually
    let sort_fields = handle.sort_fields;
    let target_schema = crate::schema_coerce::coerce_inferred_schema(physical_plan.schema());
                // candidates before other predicates.
    // Augment each segment's footer-only metadata with a scoped page index so
/// segments). The `global_base` values are unrelated to that pruning win.
        BoolNode::Not(inner) => collect_predicate_exprs(inner, out),
        let top = TopSort {
                        let eval: Arc<dyn RowGroupBitsetSource> =
    // Empty shard: skip build_segments (errors on zero files) and emit an
    handle: crate::session_context::SessionContextHandle,
    let Some(catalog_field) = sort_fields.first() else {
        .await
                    1 => Some(residuals.into_iter().next().unwrap()),
///
    // ── analyze_top_sort / should_reverse_segments ────────────────────
 * compatible open source license.
                                    e
                        // Build one collector per Collector leaf for this chunk.
            descending: true,
                "expected column `{expected}` in collected names {names:?}"
    #[test]
/// `FilterDelegationHandle.LIVE_DOCS_MATCH_ALL_ANNOTATION_ID` on the Java side.
/// Result of walking a logical plan looking for the leading top-of-plan ORDER BY.
    let placeholder: Arc<dyn TableProvider> = Arc::new(PlaceholderProvider {
    permit: tokio::sync::OwnedSemaphorePermit,
        let orders = vec!["desc".to_string()];
    }
}
}
            Field::new("id", DataType::Int64, false),
        let plan = build_logical_plan("SELECT id FROM t");
            (1, _) => FilterClass::SingleCollector,
    }
        deleted_doc_filtering_required: false,
                          stats_prune_tree: Option<&Arc<StatsPruneTree>>| {
        .is_some_and(|c| c.requests_row_ids);
    }
    classify_filter, expr_to_bool_tree, extract_filter_expr, ExtractionResult, FilterClass,
            if let Some(col) = node.downcast_ref::<Column>() {
        match out.tree.as_ref() {
        extraction
use crate::executor::DedicatedExecutor;
fn collect_predicate_exprs(tree: &BoolNode, out: &mut Vec<Arc<dyn PhysicalExpr>>) {
            // Build prune_tree_config from the normalized tree. This ensures
            cross_rt_stream.schema(),
        ctx,
        let tree = BoolNode::And(vec![
};
                                .row_group_indices
                            pruner,
    let object_metas = handle.object_metas;
        // `count(*)` on a shard with deletions: candidates must be exactly the live docs.
        sort_fields: sort_fields.clone(),
    //   RowSelection and drops residual-failing rows via pushdown.
    }
/// leaf into the decoded tree (deleted-doc filtering, no dedicated liveDocs FFI). Called only when
        Some(ExtractionResult {
    execution::memory_pool::MemoryPool,
            // Predicate-only scan: page-pruned universe, residual applied in
                });
    // registered StreamingTables, with an empty table_name) are NOT short-circuited to zero rows.
    pub descending: bool,
        let top = TopSort {
        }
}
            let cost_predicate = query_config.cost_predicate;
}
/// tracker (same as vanilla path) — `None` disables tracking and uses the
                            residual_expr.clone(),
) -> Result<i64, DataFusionError> {
                          stream_metrics: &StreamMetrics,
    BoolNode::Collector {
    // Sort-aware segment iteration. Mirror of `ContextIndexSearcher.shouldUseTimeSeriesDescSortOptimization`
        };
                            rg_index_to_pos: chunk
    let classification = match classification_override {
                                segment.writer_generation, e
    }
    let num_partitions = query_config.target_partitions.max(1);
                        ));
fn collect_predicate_column_indices(extraction: Option<&ExtractionResult>) -> Vec<usize> {
        assert!(should_reverse_segments(Some(&top), &fields, &orders));
                    move |segment: &SegmentFileInfo,
/// Constrain the extracted filter to live documents by AND-ing the reserved match-all Collector
        // AND(C₁, AND(C₂, P)) → residual is P
        // and a read column that gets only a placeholder OffsetIndex (instead of
/// Walk through the top of a logical plan to find the leading sort expression.
            for annotation_id in &leaf_ids {
    // registers the indexed-only index_filter / delegation_possible UDFs.
                            format!(
//!      Collector leaf, once per query).
    // NOTE: gate acquired on CPU here — acceptable for this deprecated benchmark-only path.
        match out.tree.as_ref() {
                assert!(children.iter().all(is_predicate));
    //   by the stream's `will_build_mask` guard (to avoid misalignment).
    // Collector injection below.
    let emit_row_ids = requests_row_ids;
    }
    cpu_executor: DedicatedExecutor,
    if top.column != *catalog_field {
    let mut indices = HashSet::new();
    fn injected_live_docs_id_is_negative_and_reserved() {
                                chunk.doc_min,
    let handle = crate::session_context::SessionContextHandle {
