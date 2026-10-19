/// bitset over `[min_doc, max_doc)`.
    }
        let mut rng = StdRng::seed_from_u64(0x5555);
    use crate::indexed_table::page_pruner::build_pruning_predicate;
            .expect("simple AND(Collector, price<1000) must round-trip");
        expected.len(),
                    format_tree(&tree.tree),
    }));
                residual_physical.clone(),
    // code path that production never dispatches to for this shape.
        return None;
    /// **Specific Regression test.**
    }
///    page-level pruning during prefetch.
 */
            BoolNode::Collector { annotation_id } => {
                max_collector_parallelism: cfg_max_parallelism.unwrap_or(if num_tags > 1 {
                actual.len()
            let list: Option<Vec<Expr>> = in_list.list().iter().map(lift_phys_to_logical).collect();
    force_strategy: Option<FilterStrategy>,
    let bool_tree = tree.tree.clone().push_not_down();
    }));
        use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
    let t = tag?;
/// children.
        }
    };
        for &doc in &self.matching {
) -> (Vec<i32>, Arc<dyn datafusion::physical_plan::ExecutionPlan>) {
    }
                schema.clone(),
    /// `predicate` on the BitmapTree path — closer to production
    let pred_cols: Vec<usize> = {
            None,
/// Same walker as `indexed_executor::collect_predicate_exprs`, inlined
        // Force BooleanMask strategy through the SingleCollector path.
        let mut rgs = Vec::new();
                    // Multi-collector tree: randomly pick 1 (sequential) or
            Some(FilterStrategy::RowSelection),
/// Execute one tree end-to-end: wire mock collectors, build the table
                    strategy,
        };
        for strategy in [
        let predicate = BoolNode::Predicate(Arc::new(BinaryExpr::new(col, Operator::Lt, lit)));
        // Use the normal harness path — it now wires pruning_predicates.
/// pre-computed set of absolute doc ids and produces a packed u64
                .map(|(pos, &idx)| (idx, pos))
/// DataFusion pushes the full conjunct down to `scan()`.
    // `force_pushdown` overrides the node-wide indexed_pushdown_filters default;
            .expect("bare Predicate must round-trip");
            return Some(Expr::IsNull(Box::new(inner)));
        }
    let df = ctx.sql("SELECT * FROM t").await.unwrap();
        let collector = Arc::clone(&collector);
    let classification = classify_filter(&tree.tree);
    tree: &GeneratedTree,
    let residual = match residuals.len() {
    async fn harness_single_collector_pushdown_block_granular_must_align() {
    // does in production via `residual_bool_to_physical_expr`.
    ] {
    execute_tree_with_plan(_corpus, loaded, tree, force_strategy)
    loaded: &LoadedSegment,
        let expected = oracle_evaluate(&gt, &corpus);
        let c1_expr =
        use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
    let ctx = SessionContext::new();
/// embed seed info in a panic.
            let actual = execute_tree_single_collector(
            let mut acc = bool_to_logical(iter.next().unwrap())?;
        use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
                    Box::new(acc),
            .unwrap_or(0)
        let col: Arc<dyn PhysicalExpr> = Arc::new(Column::new("price", price_idx));
    }
    /// behavior.
            .await
///    children of the top AND).
    force_strategy: Option<FilterStrategy>,
    // with the evaluator paths. Tree-classified trees must NOT be
/// Same mock collector as the rest of tests_e2e uses. Takes a
            if children.is_empty() {
            collector_matches: vec![s1, s2],
        .await,
                .enumerate()
            .expect("tree classifies as SingleCollector");
fn collect_predicate_column_indices(tree: &BoolNode) -> Vec<usize> {
            Some(FilterStrategy::BooleanMask),
        None,
        let corpus = build_corpus(FixtureConfig::small(0xcafe_1111));
/// enforces the residual predicate authoritatively; parquet's own
        force_pushdown,
                let next = bool_to_logical(c)?;
    // classify_filter internally). SingleCollector-classified trees
            actual,
    ) -> usize {
            Arc<datafusion::physical_optimizer::pruning::PruningPredicate>,
        store,
    use super::*;
        .and_then(|expr| build_pruning_predicate(expr, schema.clone()));
    // `force_pushdown` overrides the node-wide indexed_pushdown_filters default;
        predicate_columns: vec![],
        use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
        _ => BoolNode::And(residuals),
                like.negated(),
            ));
                &corpus,
        store,
        max_doc: i32,
                call_strategy,
    factory: EvaluatorFactory,
        let phys_col: Arc<dyn PhysicalExpr> = Arc::new(Column::new("price", price_idx));
        run_single_collector_query(
                    node.downcast_ref::<datafusion::physical_expr::expressions::Column>()
            if p.name() == "QueryShardExec" {
        let where_expr = datafusion::logical_expr::and(or_expr, price_lt);
        let tree = BoolNode::And(vec![BoolNode::Collector { annotation_id: 0 }]);
}
        emit_row_ids: false,
                cost_collector: 10,
            assert!(arr.is_valid(i), "__doc_id is non-null");
            let mut iter = children.iter();
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
                "BitmapTreeEvaluator vs oracle mismatch (strategy={:?}):\n  tree = {}\n  {}\n",
            for child in p.children() {
    let mut schema_out: Option<datafusion::arrow::datatypes::SchemaRef> = None;
    let extra: Vec<_> = a.difference(&e).take(10).copied().collect();
/// Full-control execution: optionally attach a logical `Expr` as the
        let span = (max_doc - min_doc) as usize;
        let mut candidates: Vec<i32> = (0..corpus.num_rows() as i32).collect();
    }
    let bool_tree = Arc::new(bool_tree);
        cancellation_token: None,
    format!("{:?}", tree)
    _corpus: &Corpus,
        if sc_result.is_some() {
        match child {
    use datafusion::logical_expr::{col, lit, Expr, Operator};
        let gt = GeneratedTree {
    let plan = df.create_physical_plan().await.unwrap();
    /// run `AND(Collector, price<1000)` through all 3 strategies,
                pruner,
                &loaded,
    _corpus: &Corpus,
    let mut doc_ids: Vec<i32> = Vec::new();
        let expected = oracle_evaluate(&gt, &corpus);
        use datafusion::physical_expr::PhysicalExpr;
            tree: predicate,
    ///
    };
    }
        store_url,
    let mut qcb = crate::datafusion_query_config::DatafusionQueryConfig::builder()
                if expected != actual {
    async fn harness_bare_predicate() {
            Arc::clone(&pruning_predicates),
                Ok(datafusion::common::tree_node::TreeNodeRecursion::Continue)
        datafusion::physical_plan::execute_stream(Arc::clone(&plan), task_ctx).unwrap();
            .await
            collector_matches: vec![],
        let c2_expr =
/// working across segments).
        BoolNode::Predicate(expr) => out.push(Arc::clone(expr)),
        .target_partitions(1)
//! Shares one parquet corpus across iterations — the corpus build cost
            rgs.push(RowGroupInfo {
            actual.len()
        let any = expr.as_ref();
                .iter()
/// offset in the global doc-id space (so Collector doc-ids keep
            max_doc: seg_rows as i64,
            tree,
                strategy,
    )
                &corpus,
    #[tokio::test]
                    actual.len(),
    let plan = df.create_physical_plan().await.unwrap();
            Some(Expr::Not(Box::new(e)))
/// Execute `SELECT * FROM t WHERE <residual>` so DataFusion's planner
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        plan: &Arc<dyn datafusion::physical_plan::ExecutionPlan>,
    let mut exprs = Vec::new();
    loaded: &LoadedSegment,
            v.shuffle(rng);
            let rg_index_to_pos: HashMap<usize, usize> = chunk
                expected,
    /// numeric column, `pages_total > 0` means page pruning actually
        let size = std::fs::metadata(&path).unwrap().len();
        let mut indices = std::collections::BTreeSet::new();
                &schema,
        loaded,
    async fn harness_bitmap_tree_pushdown_block_granular_must_align() {
        );
        set.sum(|m| m.value().name() == name && m.metric_type() == MetricType::Dev)
        let residual_pp = residual_pp.clone();
            return Some(Expr::InList(datafusion::logical_expr::expr::InList::new(
        let matching: Vec<i32> = (0..100i32).collect();
    }
                matching: tree.collector_matches[tag as usize].clone(),
) -> Result<(), String> {
        use datafusion::logical_expr::Operator;
    /// attempted to evaluate. If it's 0 → regression (pruner skipped
    // `None` leaves the default in place.
        let tree_node = BoolNode::And(vec![collector_leaf, predicate]);
    /// Bug: pushdown drops rows at decode; `current_mask` is indexed
    // already cross-checked above; bare Collectors and AND-of-only-
}
    force_strategy: Option<FilterStrategy>,
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        .0
            }
    #[tokio::test]
async fn run_iteration_impl(
                .map(|pp| (Arc::as_ptr(expr) as *const () as usize, pp))
        let sc_result = execute_tree_single_collector(
                Box::new(l),
    let task_ctx = ctx.task_ctx();
        let meta =
    loaded: &LoadedSegment,
    };
pub(in crate::indexed_table::tests_e2e) async fn execute_tree_with_plan_pushdown(
        ] {
        let s1 = mkset(&mut rng);
            }
        use datafusion::arrow::datatypes::DataType;
}
                .unwrap();
        let actual = execute_tree_single_collector(
            if let Some(col) = node.downcast_ref::<datafusion::physical_expr::expressions::Column>()
/// builds a `FilterExec` around `QueryShardExec`. The FilterExec
            &loaded,
/// Pretty-print a tree to a debug string. Used in failure messages.
        .indexed_pushdown_filters(true)
        let mut out = vec![0u64; span.div_ceil(64)];
    /// pushed to parquet.**
            );
        use datafusion::logical_expr::{col, lit, Expr, Operator};
        // Uniform random subset at `pct`% density.
        qcb = qcb.indexed_pushdown_filters(push);
 * The OpenSearch Contributors require contributions made to
) -> (Vec<i32>, Arc<dyn datafusion::physical_plan::ExecutionPlan>) {
    /// emitted.
            }
                strategy,
    /// Tests all three strategies to ensure identical semantics.
            sort_max: None,
            ));
        }
            return Some(col(c.name()));
    );
    /// (regression from seed `INDEXED_E2E_SEED=1e94955ce24bc83d`).
    async fn harness_simple_and_collector_predicate() {
}
    ///
    matching: Vec<i32>,
}
    /// against an accidental "turn off pushdown everywhere" change
        assert_eq!(
            }
        let arr = b
        segments: loaded.segments.clone(),
            }
    doc_ids.sort_unstable();
        }
        let predicate = BoolNode::Predicate(Arc::new(BinaryExpr::new(col, Operator::Lt, lit)));
    let plan = df.create_physical_plan().await.unwrap();
            }
            let actual = execute_tree_single_collector(
            .collect(),
        };
                CollectorCallStrategy::FullRange,
            &corpus,
    /// pass because pushdown is disabled when `current_mask` would
        });
/// 4. Parquet's decode-time `with_predicate` + DataFusion's outer
        }
                expected.len(),
    loaded: &LoadedSegment,
use std::collections::HashMap;
    async fn harness_bare_collector() {
        });
    }
        run_iteration(&corpus, &loaded, &gt)
        qcb = qcb.min_skip_run_default(msr);
        let lit: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(500))));
            CollectorCallStrategy::FullRange,
        walk(plan, &mut set);
    use std::collections::BTreeSet;
/// has a `Filter` node containing the original WHERE (both the
    // Build per-leaf PruningPredicates the same way indexed_executor.rs
        }
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        pushdown_predicate,
        let corpus = build_corpus(FixtureConfig::small(0x1f00d));
    let missing: Vec<_> = e.difference(&a).take(10).copied().collect();
        ctx.table("t").await.unwrap().filter(filter).unwrap()
}
                indices.insert(col.index());
        let loaded = load_segment(&corpus);
}
        .force_strategy(force_strategy)
    /// wrong positions.
                Box::new(target),
    /// silently).
            pages_total > 0,
    fn collect_packed_u64_bitset(
        }
        use rand::SeedableRng;
        if let Some(c) = any.downcast_ref::<PhysColumn>() {
    tree: &GeneratedTree,
        Arc::new(move |segment, chunk, stream_metrics, stats_prune_tree| {
                ),
                    crate::indexed_table::eval::CollectorCallStrategy::FullRange,
#[derive(Debug)]
    }
                {
/// predicate through to `IndexedTableProvider::scan(filters)`, which
            for c in iter {
            sort_min: None,
    /// This mirrors production: construct a logical `Expr` containing
        _corpus,
            let r = lift_phys_to_logical(bin.right())?;
        }
            CollectorCallStrategy::TightenOuterBounds,
            Ok(datafusion::common::tree_node::TreeNodeRecursion::Continue)
        let collector_leaf = BoolNode::Collector { annotation_id: 0 };
                    stream_metrics.ffm_collector_calls.clone(),
                &gt,
            let mut iter = children.iter();
            "pages_total was 0; page pruner never ran on price<500 predicate — regression?"
    run_iteration_impl(corpus, loaded, tree, /*determinism_check=*/ false).await
        None
) -> Vec<i32> {
    Ok(())
                &loaded,
        sort_fields: vec![],
/// top-level AND, etc.).
        let col: Arc<dyn PhysicalExpr> = Arc::new(Column::new("price", 3));
        .as_ref()
            .filter_map(|expr| {
        let parquet_meta = meta.metadata().clone();
        let price_idx = corpus.schema.index_of("price").unwrap();
    ) -> Option<Expr> {
        Arc::new(move |segment, _chunk, stream_metrics, _stats_prune_tree| {
            Arc::new(Literal::new(ScalarValue::Int32(Some(1000))));
            expected,
pub(in crate::indexed_table::tests_e2e) async fn execute_tree_with(
        };
                first_row: offset,
    pub schema: datafusion::arrow::datatypes::SchemaRef,
    let collectors: Vec<Arc<dyn RowGroupDocsCollector>> = tags
) -> Result<(), String> {
/// Returns `None` when the tree doesn't classify as `SingleCollector`
            let inner = lift_phys_to_logical(is_null.arg())?;
        BoolNode::And(c) => c,
    async fn harness_single_collector_density_5pct_all_strategies() {
        BoolNode::Predicate(expr) => lift_phys_to_logical(expr),
        evaluator_factory: factory,
    }
async fn run_with_factory_plan(
        prune_tree_config: Some((
                    return Err(format!(
            {
/// query WHERE clause. When `Some`, DataFusion's planner pushes that
    // behavior instead of silently falling back to universe bitmaps.
        let loaded = load_segment(&corpus);
        .iter()
                        diff_info,
/// `execute_indexed_query` computes from the BoolNode for production.
            expected.len(),
    while let Some(batch) = stream.next().await {
            usize,
        .map(|&tag| {
        store_url,
        let loaded = load_segment(&corpus);
pub(in crate::indexed_table::tests_e2e) fn format_tree(tree: &BoolNode) -> String {
            BoolNode::Predicate(Arc::new(BinaryExpr::new(phys_col, Operator::Lt, phys_lit)));
        let (actual, _plan) = execute_tree_with_plan_pushdown_filter(
    tree: &GeneratedTree,
        let collector = BoolNode::Collector { annotation_id: 0 };
        })
        tree,
    let ctx = SessionContext::new();
                like.case_insensitive(),
                Arc::clone(&segment.metadata),
            object_path,
            Some(where_expr), // real WHERE clause pushed to scan(filters)
///
    let task_ctx = ctx.task_ctx();
pub(in crate::indexed_table::tests_e2e) async fn execute_tree_with_plan(
        let arr = b
        .target_partitions(1)
) -> Option<Vec<i32>> {
/// Extract `(tag, residual)` from a tree that classifies as
            arrow_schema: meta.schema().clone(),
        let lit: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(500))));
    ///
        if let Some(in_list) = any.downcast_ref::<InListExpr>() {
            offset += n;
                stats_prune_tree: stats_prune_tree.cloned(),
        for i in 0..arr.len() {
    };
        ] {
            Some(acc)
    _corpus: &Corpus,
        Ok(out.into())
            tree: tree_node,
    }
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
            Ok(eval)
        };
                Box::new(target),
        .collect();
        query_config: Arc::new(qc),
            doc_ids.push(arr.value(i));
        store,
    /// `IndexedStream::poll_next`, this fails with rows from the
        let s2 = mkset(&mut rng);
        }
    ctx.register_udf(crate::indexed_table::substrait_to_tree::create_index_filter_udf());
/// One iteration: generate a tree, evaluate via oracle + pipeline,
    // Wire one mock collector per Collector leaf, matching DFS order.
            let _ = pp.apply(|node| {
        let corpus = build_corpus(FixtureConfig::small(0xdead_beef_cafe));
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
        emit_row_ids: false,
    ctx.register_table("t", provider).unwrap();
        use rand::SeedableRng;
            }) as Arc<dyn RowGroupDocsCollector>
                    Box::new(next),
            let resolved = tree.resolve(&per_leaf)?;
        use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
) -> (Vec<i32>, Arc<dyn datafusion::physical_plan::ExecutionPlan>) {
/// pushdown.
            return Err(format!(
            tree,
    // Cross-check: when the tree classifies as SingleCollector, run
    // any De Morgan normalization — otherwise we'd be exercising a
        cancellation_token: None,
    let mut qcb = crate::datafusion_query_config::DatafusionQueryConfig::builder()
        BoolNode::And(c) | BoolNode::Or(c) => c
pub(in crate::indexed_table::tests_e2e) fn load_segment(corpus: &Corpus) -> LoadedSegment {
                        out.push(Arc::clone(metric));
        let predicate = BoolNode::Predicate(Arc::new(BinaryExpr::new(col, Operator::Lt, lit)));
    // referencing it (when where_expr is set) type-checks.
            ));
        }
                        call_strat,
        std::collections::HashMap<
                collector_strategy: [
    )
            v.sort_unstable();
    } else {
/// `index_filter(...)` UDF call AND parquet-native predicates).
    format!(
    );
    while let Some(batch) = stream.next().await {
            )));
        BoolNode::Not(inner) => collect_predicate_exprs_harness(inner, out),
    }
/// → parquet's `with_predicate`.
        use datafusion::common::ScalarValue;
            return Some(Expr::BinaryExpr(datafusion::logical_expr::BinaryExpr::new(
        .force_strategy(force_strategy)
            Some(acc)
            // And of zero children = TRUE tautology.
        &self,
            .iter()
    call_strategy: crate::indexed_table::eval::single_collector::CollectorCallStrategy,
            collector_matches: vec![],
        .batch_size([256, 1024, 8192][loaded.segments.len() % 3]);
    loaded: &LoadedSegment,
                stream_metrics.ffm_collector_calls.clone(),
        // preserves the schema order.
                return Some(lit(false));
                    expr,
    // `None` leaves the default in place.
        candidates.shuffle(&mut rng);
    let residual_pp = residual_physical
/// at decode time. `pushdown_predicate` provides the residual predicate
                    let diff_info = summarize_diff(&expected, &actual);
    EvaluatorFactory, IndexedTableConfig, IndexedTableProvider, SegmentFileInfo,
        BoolNode::Or(children) => {
    indices.into_iter().collect()
        }
    pushdown_predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
    ] {
            .expect("__doc_id is Int32");
    }
                 accepted the tree (should have returned None):\n  tree = {}\n",
use crate::indexed_table::bool_tree::BoolNode;
        }
                } else {
    #[tokio::test]
    ctx.register_table("t", provider).unwrap();
            .await
    let execution_props = datafusion::execution::context::ExecutionProps::new();
    /// `build_mask` (not the zero-copy `prefetch_mask_buffer` fast
    /// the SingleCollector path, this surfaces it. Additionally, this
        segments: loaded.segments.clone(),
        };
        schema: loaded.schema.clone(),
    for strategy in [
        use rand::rngs::StdRng;
            if doc >= min_doc && doc < max_doc {
        // original LogicalPlan's filter containing BOTH UDF calls AND
            loaded,
        use datafusion::logical_expr::Operator;
    execute_tree_with_plan_pushdown_filter(
    };
    #[tokio::test]
                    actual2.len(),
        factory,
/// the set of column indices referenced only by Predicate leaves.
        query_config: Arc::new(qc),
        global_first_row += seg_rows as i64;
/// re-runs (ordering flakes, race conditions).
        let collector = BoolNode::Collector { annotation_id: 0 };
    ///     selection → `current_mask` gets built from candidate bitmap)
                strategy,
    let factory: EvaluatorFactory = {
            .for_each(|ch| collect_predicate_exprs_harness(ch, out)),
    // oracle. This ensures FullRange, TightenOuterBounds, and
    /// path). Catches the mask-alignment bug where `finalize_batch`
        let mut rng = StdRng::seed_from_u64(0xbeef_1111);
        let corpus = build_corpus(FixtureConfig::small(0x4444));
                    std::collections::HashMap::new(),
        use rand::SeedableRng;
        indices.into_iter().collect()
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
        .await;
        _ => return None,
                Arc::clone(&segment.metadata),
///    then wraps a `FilterExec` around our scan and passes the
            assert_eq!(
    let mut tag: Option<u8> = None;
            tree: tree_node,
                out[rel / 64] |= 1u64 << (rel % 64);
/// Run the tree through `SingleCollectorEvaluator` (production's fast
    _corpus: &Corpus,
        let _ = expr.apply(|node| {
}
        pushdown_predicate: None,
            ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true))
        use rand::rngs::StdRng;
        prune_tree_config: None,
        let lit: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(1000))));
                Arc::new(idx_filter_udf.clone()),
        use rand::SeedableRng;
            tree: tree_node,
    let qc = qcb.build();
            let e = bool_to_logical(inner)?;
    force_strategy: Option<FilterStrategy>,
    (doc_ids, plan)
        let (_rows, plan) = execute_tree_with_plan(&corpus, &loaded, &gt, None).await;
            Arc::clone(&bool_tree),
        .batch_size([128, 1024, 8192][loaded.segments.len() % 3]);
///    `FilterExec` enforce the residual on returned rows — the
        let gt = GeneratedTree {
/// Like `execute_tree_with` but also returns the ExecutionPlan so
        let gt = GeneratedTree {
                pct,
            .column(0)
}
            &corpus,
        Literal as PhysLiteral,
    let residual_physical =
                ));
                execute_tree_single_collector(corpus, loaded, tree, strategy, call_strat).await
    force_pushdown: Option<bool>,
    /// This tests the OTHER branch of the fix — regression-proofing
                    ));
                .row_group_indices
///    evaluator itself only produces the Collector candidate bitmap.
//! generation + execution against the same file.
/// here so the harness can mirror production's per-leaf pruning setup.
    /// be built. If someone removes the fix, this test fails
                Some(
            }
                expected.len(),
///    the physical `predicate` on `QueryShardExec`.
        segments.push(SegmentFileInfo {
            if children.is_empty() {
    _corpus: &Corpus,
    run_with_factory_plan(
        if determinism_check {
        let expected = oracle_evaluate(&gt, &corpus);
        use datafusion::physical_expr::PhysicalExpr;
    let cfg_batch_size = _corpus.config.batch_size;
    if let Some(msr) = cfg_min_skip_run {
        let price_idx = corpus.schema.index_of("price").unwrap();
        use datafusion::common::ScalarValue;
        let pages_total = get_counter_from_plan(&plan, "pages_total");
    }
            writer_generation: i as i64,
        for i in 0..arr.len() {
}
            tree: predicate,
    out: &mut Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        }
/// A set of loaded segments derived from the corpus. Built once per
    #[tokio::test]
        BinaryExpr as PhysBinaryExpr, Column as PhysColumn, InListExpr, IsNullExpr, LikeExpr,
        // the residual. `index_filter(Binary([0])) OR index_filter(Binary([1]))`
            doc_ids.push(arr.value(i));
    // Dispatch fuzz: verify classify_filter's decision is consistent
    )
///    DataFusion's planner understands — `DataFrame::filter(expr)`
        expr: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
    }
            ));
                page_prune_metrics: Some(
            tree: tree_node,
            residual_logical,
        evaluator_factory: factory,
        if schema_out.is_none() {
    }
    // Register the index_filter UDF so any Expr::ScalarFunction
            .downcast_ref::<Int32Array>()
use crate::indexed_table::eval::bitmap_tree::{BitmapTreeEvaluator, CollectorLeafBitmaps};
/// logical `Expr` suitable for `DataFrame::filter`. Returns `None` if
                    ),
        if let Some(is_null) = any.downcast_ref::<IsNullExpr>() {
        Some(FilterStrategy::BooleanMask),
        force_strategy,
    /// `current_mask` built from candidate bitmap over delivered
    // CollectorCallStrategy combination and assert all agree with the
        candidates.sort_unstable();
            return Some(Expr::Like(datafusion::logical_expr::expr::Like::new(
                schema.clone(),
        let b = batch.unwrap();
use std::sync::Arc;
    loaded: &LoadedSegment,
        "expected={} actual={} missing(first 10)={:?} extra(first 10)={:?}",
    /// is non-identity and `current_mask` must be built through
                )),
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    // Collectors are valid SingleCollector shapes that the harness
/// identical output — catches non-determinism across partitions or
        candidates.truncate(corpus.num_rows() * pct / 100);
/// conjoins into `QueryShardExec.predicate` → `IndexedStream.predicate`
/// 1. Extracting the single `Collector` tag + residual (non-Collector
    let mut stream =
                    Box::new(acc),
        // Multi-collector → classifies as Tree path.
                segment.writer_generation,
///    predicate into `IndexedTableProvider::scan()` where it becomes
        // matches the tree's OR(C1, C2); `price < 1000` is the residual.
        .expect("tree classifies as SingleCollector");
    /// rows. Pushdown must be disabled for this RG so the delivered
            None,
    residual: datafusion::logical_expr::Expr,
        )
        }
        use datafusion::physical_plan::metrics::{MetricType, MetricsSet};
    /// Forces the block-granular mask path where `PositionMap::Runs`
        sort_orders: vec![],
        let price_lt = col("price").lt(lit(ScalarValue::Int32(Some(1000))));
                num_rows: n,
/// path). Works by:
                pruning_predicates: Arc::clone(&pruning_predicates),
            .downcast_ref::<Int32Array>()
            assert!(arr.is_valid(i), "__doc_id is non-null");
                }
            actual,
    }
            let mut v: Vec<i32> = (0..corpus.num_rows() as i32).collect();
    fn get_counter_from_plan(
/// Shared tail: given a factory, build provider, SELECT *, return doc ids.
            &loaded,
        use datafusion::physical_expr::PhysicalExpr;
        datafusion::physical_expr::create_physical_expr(&residual, &df_schema, &execution_props)
                    indices.insert(col.index());
            Arc::new(MockCollector {
                }
        use datafusion::physical_expr::PhysicalExpr;
            other => residuals.push(other.clone()),
}
        assert_eq!(
        let corpus = build_corpus(cfg);
        let tree = Arc::clone(&bool_tree);
        use datafusion::common::ScalarValue;
    // ... existing harness tests stay below
}
}
        .force_strategy(force_strategy)
        segments: loaded.segments.clone(),
    let num_tags = tags.len();
        BoolNode::Collector { .. } => None,
        .collect();
    let df = if let Some(filter) = where_expr {
            .await
        let loaded = load_segment(&corpus);
/// segment gets `writer_generation = i` and a `first_row` reflecting its
    let task_ctx = ctx.task_ctx();
        extra
    LoadedSegment {
    async fn harness_single_collector_density_1pct_all_strategies() {
/// This mirrors production: in production, the substrait LogicalPlan
        let loaded = load_segment(&corpus);
            .as_any()
    /// Walks the plan and sums the named counter off QueryShardExec.
        })
    .0
        crate::indexed_table::bool_tree::residual_bool_to_physical_expr(&residual_bool);
/// BitmapTreeEvaluator path, which default harness turns OFF.
        let gt = GeneratedTree {
    // Build residual page-pruning predicate (same as production's
                evaluator: Arc::new(BitmapTreeEvaluator),
        let file = std::fs::File::open(&path).unwrap();
    tree: &GeneratedTree,
    if !matches!(classify_filter(&tree.tree), FilterClass::SingleCollector) {
                    }
        None,
            Some(FilterStrategy::RowSelection),
        let corpus = build_corpus(FixtureConfig::small(corpus_seed));
    corpus: &Corpus,
    corpus: &Corpus,
        sort_fields: vec![],
    use datafusion::common::tree_node::TreeNode;
                "density={}% strategy={:?}: expected {} rows, got {}",
        sort_orders: vec![],
        if let Some(l) = any.downcast_ref::<PhysLiteral>() {
        use datafusion::physical_expr::PhysicalExpr;
                Box::new(pattern),
    /// filtering.
        leaf_exprs
            if let Some(actual) =
    (doc_ids, plan)
    }
    let matching = tree.collector_matches[tag as usize].clone();
    let mut stream =
    /// rowset matches what the mask assumes. Without the fix in
            );
    /// Same pattern as `metrics.rs::aggregate_metrics` but inlined.
    let tags = collect_collector_tags(&bool_tree);
/// (bare Collector, multi-Collector, OR at top level, NOT above
pub(in crate::indexed_table::tests_e2e) async fn execute_tree_single_collector(
        }
                &gt,
            &gt,
/// fuzz test and reused across all iterations.
pub(in crate::indexed_table::tests_e2e) struct LoadedSegment {
            .unwrap(),
        let gt = GeneratedTree {
    /// which would be correct but slow.
                    1
    }
    // Match production: classify the tree in its un-normalized form.
        let seg_rows = corpus.segment_row_counts[i];
            .expect("one iteration should round-trip cleanly");
    pub segments: Vec<SegmentFileInfo>,
        let mut set = MetricsSet::new();
    let cfg_max_parallelism = _corpus.config.max_collector_parallelism;
use super::oracle::oracle_evaluate;
        Some(false),
        }
                )
        .into_iter()
            collector_matches: vec![matching.clone()],
                walk(child, out);
        Some(FilterStrategy::RowSelection),
    };
            doc_ids.push(arr.value(i));
    // PageRangeSplit all produce identical results.
                acc = Expr::BinaryExpr(datafusion::logical_expr::BinaryExpr::new(
    tree: &BoolNode,
                        stream_metrics,
    /// Setup:
            let target = lift_phys_to_logical(in_list.expr())?;
    loaded: &LoadedSegment,
    use super::super::{build_corpus, generate_tree, FixtureConfig};
    // accepted by execute_tree_single_collector (which guards on
        let mut rng = StdRng::seed_from_u64(collector_seed);
        let per_leaf = per_leaf.clone();
use super::corpus::Corpus;
            metadata: Arc::clone(&parquet_meta),
}
    /// is the only test that actually invokes parquet with a non-null
//! Fuzz harness: run a generated tree through the real
            }
        }
        let or_expr = datafusion::logical_expr::or(c1_expr, c2_expr);
    force_strategy: Option<FilterStrategy>,
            "BitmapTree + pushdown ON + BooleanMask + real WHERE: expected {} rows, got {}",
        predicate_columns: pred_cols,
    let collector: Arc<dyn RowGroupDocsCollector> = Arc::new(MockCollector { matching });
        let tree_node = BoolNode::And(vec![collector, predicate]);
) -> Vec<i32> {
        let pruning_predicates = Arc::clone(&pruning_predicates);
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
    /// Metrics invariant: for a tree with at least one predicate on a
    #[tokio::test]
        let predicate =
pub(in crate::indexed_table::tests_e2e) async fn run_iteration_twice(
        // 5% density, uniform.
        >,
    }
    /// If BitmapTreeEvaluator shares any pushdown-alignment bug with
        let gt = GeneratedTree {
    // that the harness can handle (AND(Collector, predicates...)) are
    for strategy in [
    async fn run_single_collector_density_test(pct: usize, corpus_seed: u64, collector_seed: u64) {
/// `with_predicate` (threaded via `scan()`) does the decode-time
        let lit: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(1000))));
}
        )
    let df_schema = datafusion::common::DFSchema::try_from(loaded.schema.as_ref().clone()).unwrap();
        let schema = schema.clone();
) -> Result<(), String> {
    tree: &GeneratedTree,
            &gt,
        BoolNode::Collector { .. } => {}
        assert!(
    force_pushdown: Option<bool>,
            CollectorCallStrategy::FullRange,
        actual.len(),
        let c1 = BoolNode::Collector { annotation_id: 0 };
    determinism_check: bool,
        let predicate = BoolNode::Predicate(Arc::new(BinaryExpr::new(col, Operator::Lt, lit)));
                    crate::indexed_table::eval::CollectorCallStrategy::PageRangeSplit,
            let pattern = lift_phys_to_logical(like.pattern())?;
        if let Some(ref pp) = pushdown_predicate {
                expected,
        let corpus = build_corpus(FixtureConfig::small(0x2222));
        for strategy in [
        let loaded = load_segment(&corpus);
    }
    loaded: &LoadedSegment,
                CollectorCallStrategy::PageRangeSplit,
    execute_tree_with_plan_pushdown(_corpus, loaded, tree, force_strategy, Some(false)).await
    // No WHERE clause — the pushdown_predicate above carries the
        .await
    let mut doc_ids: Vec<i32> = Vec::new();
                None,
/// provider, query it, return the set of `__doc_id` values that came
    let pushdown_predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>> = Some(
use crate::indexed_table::eval::{RowGroupBitsetSource, TreeBitsetSource};
use crate::indexed_table::page_pruner::PagePruner;
            collector_matches: vec![matching.clone()],
        if let Some(like) = any.downcast_ref::<LikeExpr>() {
    /// (row-granular). No `current_mask` built; pushdown stays ON.
                        stream_metrics,
        1 => residuals.into_iter().next().unwrap(),
        Some(FilterStrategy::BooleanMask),
            global_base: 0,
        missing,
            .as_any()
    Some(
                    Box::new(next),
    /// DataFusion calls `IndexedTableProvider::scan(filters=[...])`
            )
                page_pruner: pruner,
    let mut indices = std::collections::BTreeSet::new();
    let bool_tree = tree.tree.clone().push_not_down();
use crate::indexed_table::substrait_to_tree::{classify_filter, FilterClass};
        let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
    factory: EvaluatorFactory,
        let matching: Vec<i32> = (0..100i32).collect();
            v.truncate(corpus.num_rows() / 20);
        candidates.sort_unstable();
    }
        evaluator_factory: factory,
                ),
    /// both the `index_filter(...)` UDF call and a parquet-native
            corpus,
    // residual. `scan()` ignores filters anyway.
        use datafusion::logical_expr::Operator;
        // Build the WHERE clause exactly as production would — the
    min_skip_run_override: Option<usize>,
            }
    if let Some(push) = force_pushdown {
        )
                std::sync::Arc::new(crate::indexed_table::eval::single_collector::FfmDelegatedBackendCollectorFactory),
        };
                    [1, 1, 2, 4][seed as usize % 4]
    loaded: &LoadedSegment,
                tree: Arc::new(resolved),
        // Force pushdown ON, BooleanMask strategy, with a real WHERE clause.
        candidates.sort_unstable();
        .target_partitions(cfg_target_partitions.max(1))
        );
    #[tokio::test]
        sort_orders: vec![],
                actual.len()
        let b = batch.unwrap();
    /// Pin the fix for the pushdown+current_mask alignment bug
fn extract_single_collector(tree: &BoolNode) -> Option<(u8, BoolNode)> {
        let mut offset = global_first_row;
            return Err(format!(
        let price_idx = corpus.schema.index_of("price").unwrap();
 * this file be licensed under the Apache-2.0 license or a
        candidates.truncate(corpus.num_rows() / 2);
}
    let store: Arc<dyn object_store::ObjectStore> =
    )
    force_strategy: Option<FilterStrategy>,
    }
        let c2 = BoolNode::Collector { annotation_id: 1 };
        run_iteration(&corpus, &loaded, &tree)
            .as_any()
            collector_matches: vec![candidates],
    let df = ctx.sql("SELECT * FROM t").await.unwrap();
    use crate::indexed_table::eval::single_collector::CollectorCallStrategy;
        if let Some(bin) = any.downcast_ref::<PhysBinaryExpr>() {
                    "non-deterministic output (strategy={:?}):\n  tree = {}\n  run1.len={} run2.len={}\n",
        use rand::seq::SliceRandom;
    ///   - `force_strategy = BooleanMask` (block-granular, coalesced
/// Like `run_iteration` but ALSO runs each strategy twice and asserts
    };
    tree: &GeneratedTree,
            CollectorCallStrategy::PageRangeSplit,
        let mut mkset = |rng: &mut StdRng| -> Vec<i32> {
    /// predicate (`price < 1000`), pass it via `.filter(...)` so
) {
    #[tokio::test]
    let mut qcb = crate::datafusion_query_config::DatafusionQueryConfig::builder()
    force_pushdown: Option<bool>,
        let actual = execute_tree_with(corpus, loaded, tree, strategy).await;
            let target = lift_phys_to_logical(like.expr())?;
            let l = lift_phys_to_logical(bin.left())?;
        };
    let mut segments = Vec::with_capacity(corpus.parquet_files.len());
                diff_info,
            Ok(eval)
        let cfg = FixtureConfig::block_granular_dense(0x4444);
    // as pushdown_predicate — mirrors what `execute_indexed_query`
                strategy,
    // the Collector).
            force_strategy,
        let lit: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(1000))));
}
    /// With the fix (`will_build_mask → push=false`), this should
            Some(FilterStrategy::BooleanMask),
    let residual_logical = bool_to_logical(&residual_bool)?;
    force_strategy: Option<FilterStrategy>,
            _corpus.config.min_skip_run_override,
    where_expr: Option<datafusion::logical_expr::Expr>,
/// Mirrors `indexed_executor::collect_predicate_column_indices` — returns
        }
async fn run_single_collector_query(
        candidates.shuffle(&mut rng);
            actual.len()
    }
                Box::new(r),
        ctx.sql("SELECT * FROM t").await.unwrap()
        force_strategy,
        Arc::new(object_store::local::LocalFileSystem::new());
                "classify_filter returned Tree but execute_tree_single_collector \
}
    let mut leaf_exprs: Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>> = Vec::new();
    let qc = qcb.build();
                Some(Arc::clone(&collector)),
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
        let corpus = build_corpus(FixtureConfig::small(0x1111));
            Expr::ScalarFunction(datafusion::logical_expr::expr::ScalarFunction::new_udf(
mod tests {
        }
    doc_ids.sort_unstable();
        if expected != actual {
    tree: &GeneratedTree,
                    loaded.schema.clone(),
                }
                *bin.op(),
                    return None;
                .collect();
/// Like `execute_tree_with_plan` but allows overriding `force_pushdown`.
        let path = tmp.path().to_path_buf();
        let arr = b
use futures::StreamExt;
            )));
        pushdown_predicate,
    ///   - `AND(Collector[5% density], price < 1000)`
            .downcast_ref::<Int32Array>()
            });
        )
        Arc::new(object_store::local::LocalFileSystem::new());
    /// Parameterized helper: build a Collector at `pct`% density,
        }
        .await;
            let _ = segment;
        for i in 0..arr.len() {
    let qc = qcb.build();
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
        BoolNode::DelegationPossible { original_expr, .. } => lift_phys_to_logical(original_expr),
        let residual_physical = residual_physical.clone();
    for (i, tmp) in corpus.parquet_files.iter().enumerate() {
    // Convert the residual logical Expr to a PhysicalExpr and stash
        let mut candidates: Vec<i32> = (0..corpus.num_rows() as i32).collect();
use crate::indexed_table::index::CollectDocsResult;
        run_single_collector_density_test(1, 0xcccc, 0xdddd).await;
/// 2. Converting the residual `BoolNode` to a logical `Expr` that
        BoolNode::DelegationPossible { original_expr, .. } => out.push(Arc::clone(original_expr)),
/// to hand parquet via `with_predicate` — mirrors what
    execute_tree_with(_corpus, loaded, tree, None).await
        schema: schema_out.expect("at least one segment"),
            assert!(arr.is_valid(i), "__doc_id is non-null");
    let e: BTreeSet<i32> = expected.iter().copied().collect();
}
    let store: Arc<dyn object_store::ObjectStore> =
    .await
/// `force_pushdown` parameter forces on/off parquet's RowFilter pushdown
        let b = batch.unwrap();
        }
                ));
        loaded,
            Some(FilterStrategy::BooleanMask),
    // Extract Collector tag + residual (everything under top AND except
                tag = Some(*annotation_id as u8);
        )),
            if actual != actual2 {
        name: &str,
) -> (Vec<i32>, Arc<dyn datafusion::physical_plan::ExecutionPlan>) {
    }));
    let pruning_predicates: Arc<
    match tree {
        }
        use datafusion::common::ScalarValue;
    let factory: EvaluatorFactory = {
    let store: Arc<dyn object_store::ObjectStore> =
    loaded: &LoadedSegment,
fn collect_predicate_exprs_harness(
    let cfg_min_skip_run = _corpus.config.min_skip_run_override;
            schema_out = Some(meta.schema().clone());
    collect_predicate_exprs_harness(&bool_tree, &mut leaf_exprs);
    force_strategy: Option<FilterStrategy>,
    tree: &GeneratedTree,
        datafusion::physical_plan::execute_stream(Arc::clone(&plan), task_ctx).unwrap();
                Arc::new(idx_filter_udf),
/// the tree contains a Collector (shouldn't happen on a residual from
use crate::indexed_table::eval::single_collector::SingleCollectorEvaluator;
            });
            expected,
    ctx.register_table("t", provider).unwrap();
    }
                actual,
    /// Sibling: 1% density → auto-strategy picks `min_skip_run=1`
        let predicate = BoolNode::Predicate(Arc::new(BinaryExpr::new(col, Operator::Lt, lit)));
            .iter()
            .expect("__doc_id is Int32");
        // Locate __doc_id column by name (filter path may reorder).
            CollectorCallStrategy::PageRangeSplit,
    let seed = _corpus.config.seed;
                cost_predicate: 1,
        predicate_columns: collect_predicate_column_indices(&bool_tree),
    // does in production, so our harness exercises real page-pruning
        fn walk(p: &Arc<dyn datafusion::physical_plan::ExecutionPlan>, out: &mut MetricsSet) {
    loaded: &LoadedSegment,
        .map(|(i, c)| (i as i32, c))
    /// assert each matches the oracle.
                None,
            v
        let schema = b.schema();
fn summarize_diff(expected: &[i32], actual: &[i32]) -> String {
        let _ = DataType::Int32; // silence unused import
    ///
            expected.len(),
/// Convert a `BoolNode` (with no Collector leaves) into a DataFusion
        let expected = oracle_evaluate(&gt, &corpus);
        candidates.truncate(corpus.num_rows() / 20);
        qcb = qcb.indexed_pushdown_filters(push);
                return Some(lit(true));
/// assert equal. Returns `Err(message)` on mismatch so the caller can
            .column(idx)
        qcb = qcb.min_skip_run_default(msr);
//! `IndexedStream` pipeline and compare against the oracle.
use datafusion::arrow::array::{Array, Int32Array};
        use datafusion::common::ScalarValue;
        use datafusion::common::tree_node::TreeNode;
                0,
            .await
        let idx_filter_udf = crate::indexed_table::substrait_to_tree::create_index_filter_udf();
    /// Bare Collector with 50% density and small `min_skip_run` (4).
    let (tag, residual_bool) = extract_single_collector(&bool_tree)?;
            let pruner = Arc::new(PagePruner::new(
            parquet_size: size,
    for expr in &exprs {
        use datafusion::logical_expr::Operator;
    run_iteration_impl(corpus, loaded, tree, /*determinism_check=*/ true).await
    if classification == FilterClass::Tree {
                strategy,
            return Some(lit(l.value().clone()));
    fn lift_phys_to_logical(
                in_list.negated(),
        run_iteration(&corpus, &loaded, &gt)
                "bare collector block-granular strategy={:?}: expected {} rows, got {}",
        segments,
    loaded: &LoadedSegment,
            }
        None,
    #[tokio::test]
            assert_eq!(
) -> Vec<i32> {
                crate::indexed_table::page_pruner::build_pruning_predicate(
    let mut global_first_row: i64 = 0;
                let rel = (doc - min_doc) as usize;
        let loaded = load_segment(&corpus);
async fn run_with_factory(
                if tag.is_some() {
        Some(FilterStrategy::RowSelection),
        let gt = GeneratedTree {
    let ctx = SessionContext::new();
};
/// Load the corpus's parquet files into `SegmentFileInfo`s. Each
                ][seed as usize % 3],
        let mut rng = StdRng::seed_from_u64(0x1beef_2222);
/// back.
            Expr::ScalarFunction(datafusion::logical_expr::expr::ScalarFunction::new_udf(
        datafusion::physical_plan::execute_stream(Arc::clone(&plan), task_ctx).unwrap();
            Some(true),       // pushdown ON
            factory,
                        "SingleCollectorEvaluator vs oracle mismatch (strategy={:?}, call={:?}):\n  tree = {}\n  {}\n",
        let col: Arc<dyn PhysicalExpr> = Arc::new(Column::new("price", price_idx));
        );
    }
    /// Degenerate tree: AND(Collector, Predicate(price < 1000)).
        let phys_lit: Arc<dyn PhysicalExpr> =
        let tree_node = BoolNode::And(vec![collector_leaf, predicate]);
            loaded.schema.clone(),
    let expected = oracle_evaluate(tree, corpus);
        // `__doc_id` is always column 0 in our corpus schema; SELECT *
            let mut acc = bool_to_logical(iter.next().unwrap())?;
    }
            ));
    let schema = loaded.schema.clone();
        use rand::rngs::StdRng;
    async fn harness_pages_total_nonzero_with_predicate() {
                actual,
                return Err(format!(
fn bool_to_logical(node: &BoolNode) -> Option<datafusion::logical_expr::Expr> {
    for child in children {
    /// indexes the RG-relative mask by delivered-row offset after
    async fn harness_bare_collector_block_granular() {
    use rand::SeedableRng;
        }
            })
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(SingleCollectorEvaluator::new(
/// `SingleCollector`. `residual` is the AND of all non-Collector
    use rand::rngs::StdRng;
use crate::indexed_table::table_provider::{
        use rand::seq::SliceRandom;
    /// immediately.
        let tree = generate_tree(&mut rng, &corpus);
        // Two collectors, 5% density each, uniform.
}
    // Only proceed for trees that classify as SingleCollector WITHOUT
                    ),
        })
                vec![lit(ScalarValue::Int32(Some(0)))],
            .expect("bare Collector must round-trip");
pub(in crate::indexed_table::tests_e2e) async fn execute_tree_with_plan_pushdown_filter(
                format_tree(&tree.tree),
    /// **Diagnostic: BitmapTreeEvaluator with a real WHERE clause
impl RowGroupDocsCollector for MockCollector {
        min_doc: i32,
/// Used for diagnostic tests that want to exercise pushdown=ON on the
        let gt = GeneratedTree {
            tree: collector,
 * compatible open source license.
    pushdown_predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
            let diff_info = summarize_diff(&expected, &actual);
            collector_matches: vec![candidates],
        let collector_leaf = BoolNode::Collector { annotation_id: 0 };
    }
        pushdown_predicate,
    tree: &GeneratedTree,
        let col: Arc<dyn PhysicalExpr> = Arc::new(Column::new("price", 3));
    collect_predicate_exprs_harness(tree, &mut exprs);
///
        0 => BoolNode::And(vec![]),
        use datafusion::common::ScalarValue;
        let loaded = load_segment(&corpus);
use crate::indexed_table::index::RowGroupDocsCollector;
            .column(0)
            let actual2 = execute_tree_with(corpus, loaded, tree, strategy).await;
                list?,
    let cfg_target_partitions = _corpus.config.target_partitions;
    // SingleCollector path).
}
                leaves: Arc::new(CollectorLeafBitmaps::new(
            for c in iter {
    /// then passed to parquet's `with_predicate` for decode-time
/// tests can inspect metrics.
                    Operator::Or,
        use rand::seq::SliceRandom;
                    // up to 4 (parallel) to exercise PrecomputedLeafCache.
struct MockCollector {
            }
        query_config: Arc::new(qc),
    factory: EvaluatorFactory,
    use crate::indexed_table::eval::single_collector::CollectorCallStrategy;
    /// skip runs shift the alignment.
        };
    while let Some(batch) = stream.next().await {
    > = Arc::new(
            .expect("bare Collector classifies as SingleCollector");
        candidates.shuffle(&mut rng);
        let idx = schema.index_of("__doc_id").expect("__doc_id in batch");
    .await
            None,
            {
use datafusion::execution::context::SessionContext;
    async fn harness_smoke_single_iteration() {
                residual_pp.clone(),
                    None,
    doc_ids.sort_unstable();
                        format_tree(&tree.tree),
        .await
    #[tokio::test]
    ///   - `force_pushdown = Some(true)` (parquet `with_predicate`
                    for metric in m.iter() {
    match node {
        let col: Arc<dyn PhysicalExpr> = Arc::new(Column::new("price", 3));
    let a: BTreeSet<i32> = actual.iter().copied().collect();
    let children = match tree {
    if let Some(push) = force_pushdown {
/// `extract_single_collector`) or an expression shape we can't lift.
                }),
        sort_fields: vec![],
        use datafusion::physical_expr::PhysicalExpr;
                let next = bool_to_logical(c)?;
    use datafusion::physical_expr::expressions::{
        let loaded = load_segment(&corpus);
    let mut residuals: Vec<BoolNode> = Vec::new();
        let tree_node = BoolNode::And(vec![BoolNode::Or(vec![c1, c2]), predicate]);
        let corpus = build_corpus(FixtureConfig::small(0x3333));
///
        schema: loaded.schema.clone(),
        BoolNode::Not(inner) => {
    _corpus: &Corpus,
    let mut stream =
pub(in crate::indexed_table::tests_e2e) async fn run_iteration(
) -> Vec<i32> {
    if let Some(msr) = min_skip_run_override {
    // through SingleCollectorEvaluator with every FilterStrategy ×
                &schema,
use crate::indexed_table::stream::{FilterStrategy, RowGroupInfo};
        .enumerate()
        for call_strat in [
                format_tree(&tree.tree),
#[cfg(test)]
/*
    /// 5% density → auto-strategy picks `min_skip_run=1024` →
        schema: loaded.schema.clone(),
        use rand::seq::SliceRandom;
    let mut doc_ids: Vec<i32> = Vec::new();
            .expect("__doc_id is Int32");
}
        run_single_collector_density_test(5, 0xaaaa, 0xbbbb).await;
            .map(|v| v.as_usize())
 *
    /// over pre-pushdown rows; mask slicing misaligns; wrong rows
                ));
    }
        use rand::rngs::StdRng;
    // doesn't implement, so we don't assert on those.
        let mut candidates: Vec<i32> = (0..corpus.num_rows() as i32).collect();
            row_groups: rgs,
            });
                index: j,
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
 * SPDX-License-Identifier: Apache-2.0
        run_iteration(&corpus, &loaded, &gt)
        prune_tree_config: None,
        cancellation_token: None,
            .await
        BoolNode::And(children) => {
    }
        use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
                std::sync::Arc::new(std::collections::HashMap::new()),
use super::tree_gen::{collect_collector_tags, GeneratedTree};
                if let Some(m) = p.metrics() {
            loaded,
            collector_matches: vec![candidates],
//! is paid once per test, then many iterations run cheap tree
        }
        let mut rng = StdRng::seed_from_u64(0xdead_beef_cafe);
                        strategy,
            Some(FilterStrategy::BooleanMask),
        for j in 0..parquet_meta.num_row_groups() {
        .batch_size(cfg_batch_size.unwrap_or([128, 1024, 8192][seed as usize % 3]));
            )));
    /// which conjoins and stashes as `QueryShardExec.predicate`,
    corpus: &Corpus,
        use datafusion::logical_expr::Operator;
///    the pre-picked match set, plus a residual `PruningPredicate` for
    ) -> Result<CollectDocsResult, String> {
        ] {
                vec![lit(ScalarValue::Int32(Some(1)))],
pub(in crate::indexed_table::tests_e2e) async fn execute_tree(
            )
    ///
    Some((t, residual))
            let pruner = Arc::new(PagePruner::new(
//!
                rg_index_to_pos,
}
    }
            "pushdown+BooleanMask alignment bug: expected {} rows, got {}",
        let schema = loaded.schema.clone();
    ///     filters rows at decode time)
            let n = parquet_meta.row_group(j).num_rows();
                }
            ));
            ));
    ///
                    Operator::And,
                if let Some(col) =
/// 3. Building the evaluator factory with a `MockCollector` replaying
        Arc::new(object_store::local::LocalFileSystem::new());
    doc_ids
        store_url,
    ///
        emit_row_ids: false,
        };
                acc = Expr::BinaryExpr(datafusion::logical_expr::BinaryExpr::new(
