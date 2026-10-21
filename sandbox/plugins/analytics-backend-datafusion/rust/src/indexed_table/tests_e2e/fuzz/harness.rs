            tree,
                vec![lit(ScalarValue::Int32(Some(1)))],
        }
        let residual_physical = residual_physical.clone();
    }
/// Load the corpus's parquet files into `SegmentFileInfo`s. Each
        let any = expr.as_ref();
/// Convert a `BoolNode` (with no Collector leaves) into a DataFusion
    );
        BoolNode::And(c) | BoolNode::Or(c) => c
/// `SingleCollector`. `residual` is the AND of all non-Collector
/// `extract_single_collector`) or an expression shape we can't lift.
        crate::indexed_table::bool_tree::residual_bool_to_physical_expr(&residual_bool);
        use datafusion::logical_expr::Operator;
    };
/// builds a `FilterExec` around `QueryShardExec`. The FilterExec
    execute_tree_with_plan_pushdown(_corpus, loaded, tree, force_strategy, Some(false)).await
}
                indices.insert(col.index());
                {
                ][seed as usize % 3],
            tree: predicate,
        set.sum(|m| m.value().name() == name && m.metric_type() == MetricType::Dev)
        force_pushdown,
    #[tokio::test]
        // Build the WHERE clause exactly as production would — the
                page_prune_metrics: Some(
            let mut iter = children.iter();
///    children of the top AND).
        }
                crate::indexed_table::page_pruner::build_pruning_predicate(
    call_strategy: crate::indexed_table::eval::single_collector::CollectorCallStrategy,
        None,
        .0
        BoolNode::Predicate(expr) => lift_phys_to_logical(expr),
            object_path,
        expected.len(),
    let mut leaf_exprs: Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>> = Vec::new();
    if let Some(push) = force_pushdown {
        use rand::seq::SliceRandom;
    /// run `AND(Collector, price<1000)` through all 3 strategies,
        // preserves the schema order.
        ] {
                let next = bool_to_logical(c)?;
            loaded,
                acc = Expr::BinaryExpr(datafusion::logical_expr::BinaryExpr::new(
            assert_eq!(
        use datafusion::logical_expr::{col, lit, Expr, Operator};
        for i in 0..arr.len() {
                pruner,
    ctx.register_table("t", provider).unwrap();
    };
        use datafusion::physical_expr::PhysicalExpr;
        let lit: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(1000))));
        let size = std::fs::metadata(&path).unwrap().len();
        let mut rgs = Vec::new();
            .downcast_ref::<Int32Array>()
                    strategy,
    execute_tree_with(_corpus, loaded, tree, None).await
            }
            ));
            BoolNode::Predicate(Arc::new(BinaryExpr::new(phys_col, Operator::Lt, phys_lit)));
            Some(acc)
        let span = (max_doc - min_doc) as usize;
    }
            loaded.schema.clone(),
    /// silently).
            }
    let classification = classify_filter(&tree.tree);
/// bitset over `[min_doc, max_doc)`.
pub(in crate::indexed_table::tests_e2e) async fn execute_tree_with_plan(
                strategy,
        })
            actual,
pub(in crate::indexed_table::tests_e2e) struct LoadedSegment {
            if let Some(actual) =
    // already cross-checked above; bare Collectors and AND-of-only-
    /// emitted.
            .expect("bare Collector classifies as SingleCollector");
    for expr in &exprs {
    while let Some(batch) = stream.next().await {
        let where_expr = datafusion::logical_expr::and(or_expr, price_lt);
    use std::collections::BTreeSet;
    #[tokio::test]
                index: j,
    if let Some(msr) = cfg_min_skip_run {
    // ... existing harness tests stay below
                        call_strat,
    }
            writer_generation: i as i64,
        let pruning_predicates = Arc::clone(&pruning_predicates);
    }
        let idx_filter_udf = crate::indexed_table::substrait_to_tree::create_index_filter_udf();
    let residual_logical = bool_to_logical(&residual_bool)?;
///    `FilterExec` enforce the residual on returned rows — the
        let col: Arc<dyn PhysicalExpr> = Arc::new(Column::new("price", price_idx));
                let rel = (doc - min_doc) as usize;
                out[rel / 64] |= 1u64 << (rel % 64);
/// identical output — catches non-determinism across partitions or
    let mut doc_ids: Vec<i32> = Vec::new();
}
    let a: BTreeSet<i32> = actual.iter().copied().collect();
            "pushdown+BooleanMask alignment bug: expected {} rows, got {}",
        store,
/// Returns `None` when the tree doesn't classify as `SingleCollector`
        for i in 0..arr.len() {
}
        schema: loaded.schema.clone(),
        let residual_pp = residual_pp.clone();
        BoolNode::Not(inner) => {
    match tree {
            }) as Arc<dyn RowGroupDocsCollector>
        candidates.shuffle(&mut rng);
}
            collector_matches: vec![s1, s2],
                    Operator::And,
            return Some(Expr::BinaryExpr(datafusion::logical_expr::BinaryExpr::new(
    let plan = df.create_physical_plan().await.unwrap();
        let schema = loaded.schema.clone();
    for (i, tmp) in corpus.parquet_files.iter().enumerate() {
}
 * this file be licensed under the Apache-2.0 license or a
            tree: tree_node,
) -> Vec<i32> {
                call_strategy,
                }),
    fn collect_packed_u64_bitset(
            .await
        segments: loaded.segments.clone(),
    force_pushdown: Option<bool>,
) -> (Vec<i32>, Arc<dyn datafusion::physical_plan::ExecutionPlan>) {
        .map(|(i, c)| (i as i32, c))
        Arc::new(object_store::local::LocalFileSystem::new());
            let target = lift_phys_to_logical(in_list.expr())?;
    /// Pin the fix for the pushdown+current_mask alignment bug
        let (actual, _plan) = execute_tree_with_plan_pushdown_filter(
            pages_total > 0,
    /// If BitmapTreeEvaluator shares any pushdown-alignment bug with
                }
/// 2. Converting the residual `BoolNode` to a logical `Expr` that
use crate::indexed_table::substrait_to_tree::{classify_filter, FilterClass};
        let gt = GeneratedTree {
    let ctx = SessionContext::new();
}
        let col: Arc<dyn PhysicalExpr> = Arc::new(Column::new("price", 3));
                 accepted the tree (should have returned None):\n  tree = {}\n",
        BoolNode::Predicate(expr) => out.push(Arc::clone(expr)),
use crate::indexed_table::table_provider::{
    let factory: EvaluatorFactory = {
            });
    }
        use datafusion::logical_expr::Operator;
        if determinism_check {
            collector_matches: vec![],
    let bool_tree = tree.tree.clone().push_not_down();
    _corpus: &Corpus,
            CollectorCallStrategy::PageRangeSplit,
    /// (row-granular). No `current_mask` built; pushdown stays ON.
        if sc_result.is_some() {
    let qc = qcb.build();
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
            .iter()
    /// be built. If someone removes the fix, this test fails
use crate::indexed_table::index::RowGroupDocsCollector;
        use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
pub(in crate::indexed_table::tests_e2e) async fn run_iteration(
            ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true))
            _corpus.config.min_skip_run_override,
        .force_strategy(force_strategy)
    let mut stream =
                let next = bool_to_logical(c)?;
) -> Result<(), String> {
/// Like `execute_tree_with` but also returns the ExecutionPlan so
        BoolNode::And(c) => c,
    /// over pre-pushdown rows; mask slicing misaligns; wrong rows
    let store: Arc<dyn object_store::ObjectStore> =
            if doc >= min_doc && doc < max_doc {
                    crate::indexed_table::eval::CollectorCallStrategy::PageRangeSplit,
                }
    _corpus: &Corpus,
            actual.len()
/// `with_predicate` (threaded via `scan()`) does the decode-time
pub(in crate::indexed_table::tests_e2e) async fn execute_tree_with_plan_pushdown(
        candidates.shuffle(&mut rng);
        use datafusion::physical_plan::metrics::{MetricType, MetricsSet};
///
        use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
    #[tokio::test]
    // Extract Collector tag + residual (everything under top AND except
                segment.writer_generation,
use crate::indexed_table::eval::bitmap_tree::{BitmapTreeEvaluator, CollectorLeafBitmaps};
    EvaluatorFactory, IndexedTableConfig, IndexedTableProvider, SegmentFileInfo,
        }
            let _ = pp.apply(|node| {
        use rand::rngs::StdRng;
            Some(FilterStrategy::BooleanMask),
/// Like `execute_tree_with_plan` but allows overriding `force_pushdown`.
            tree: tree_node,
                "classify_filter returned Tree but execute_tree_single_collector \
        prune_tree_config: None,
    loaded: &LoadedSegment,
    loaded: &LoadedSegment,
    /// Metrics invariant: for a tree with at least one predicate on a
        use datafusion::arrow::datatypes::DataType;
                    Operator::Or,
        }
    }
                )),
    }
    run_iteration_impl(corpus, loaded, tree, /*determinism_check=*/ true).await
/// the set of column indices referenced only by Predicate leaves.
            return Some(Expr::IsNull(Box::new(inner)));
        );
        let idx = schema.index_of("__doc_id").expect("__doc_id in batch");
            Ok(eval)
        use rand::seq::SliceRandom;
        ] {
        let phys_lit: Arc<dyn PhysicalExpr> =
        qcb = qcb.min_skip_run_default(msr);
/// the tree contains a Collector (shouldn't happen on a residual from
                    // Multi-collector tree: randomly pick 1 (sequential) or
        use rand::SeedableRng;
        qcb = qcb.indexed_pushdown_filters(push);
        candidates.truncate(corpus.num_rows() / 2);
                Box::new(target),
        let gt = GeneratedTree {
            Arc::clone(&bool_tree),
    _corpus: &Corpus,
        pushdown_predicate: None,
                cost_collector: 10,
            CollectorCallStrategy::FullRange,
    fn lift_phys_to_logical(
                .row_group_indices
        use datafusion::common::ScalarValue;
    }
                .collect();
        let arr = b
    let bool_tree = tree.tree.clone().push_not_down();
    force_strategy: Option<FilterStrategy>,
    async fn harness_single_collector_density_1pct_all_strategies() {
                if let Some(col) =
pub(in crate::indexed_table::tests_e2e) async fn execute_tree(
        };
    let mut tag: Option<u8> = None;
            return Some(lit(l.value().clone()));
        evaluator_factory: factory,
    loaded: &LoadedSegment,
            }
    ///
    pushdown_predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
            });
    tree: &GeneratedTree,
            None,
pub(in crate::indexed_table::tests_e2e) async fn execute_tree_single_collector(
                diff_info,
        )
                    return None;
            arrow_schema: meta.schema().clone(),
        let loaded = load_segment(&corpus);
            ));
    let store: Arc<dyn object_store::ObjectStore> =
    ///   - `force_strategy = BooleanMask` (block-granular, coalesced
    // that the harness can handle (AND(Collector, predicates...)) are
        }
        use datafusion::physical_expr::PhysicalExpr;
                expected,
            .expect("bare Collector must round-trip");
    if classification == FilterClass::Tree {
                return Some(lit(true));
            factory,
        _corpus,
        }
            collector_matches: vec![matching.clone()],
        let gt = GeneratedTree {
        if let Some(bin) = any.downcast_ref::<PhysBinaryExpr>() {
}
    }
/// offset in the global doc-id space (so Collector doc-ids keep
    collect_predicate_exprs_harness(&bool_tree, &mut leaf_exprs);
    corpus: &Corpus,
///
        segments.push(SegmentFileInfo {
    loaded: &LoadedSegment,
                matching: tree.collector_matches[tag as usize].clone(),
                None,
    let collector: Arc<dyn RowGroupDocsCollector> = Arc::new(MockCollector { matching });
    ] {
                } else {
            let resolved = tree.resolve(&per_leaf)?;
///    evaluator itself only produces the Collector candidate bitmap.
        }
            )
    let df = ctx.sql("SELECT * FROM t").await.unwrap();
            let mut iter = children.iter();
/// segment gets `writer_generation = i` and a `first_row` reflecting its
/// Extract `(tag, residual)` from a tree that classifies as
    /// Degenerate tree: AND(Collector, Predicate(price < 1000)).
    use super::super::{build_corpus, generate_tree, FixtureConfig};
            )));
    };
                    node.downcast_ref::<datafusion::physical_expr::expressions::Column>()
    if let Some(push) = force_pushdown {
            tree,
    force_strategy: Option<FilterStrategy>,
                "bare collector block-granular strategy={:?}: expected {} rows, got {}",
        force_strategy,
    fn get_counter_from_plan(
        let lit: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(500))));
}
        Some(FilterStrategy::BooleanMask),
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
                &corpus,
///    the pre-picked match set, plus a residual `PruningPredicate` for
            sort_min: None,
        // Force pushdown ON, BooleanMask strategy, with a real WHERE clause.
            }
        let tree_node = BoolNode::And(vec![collector_leaf, predicate]);
        )),
}
    let residual_pp = residual_physical
    // does in production via `residual_bool_to_physical_expr`.
        let schema = schema.clone();
    /// Bare Collector with 50% density and small `min_skip_run` (4).
    ///
                    return Err(format!(
        candidates.sort_unstable();
    /// attempted to evaluate. If it's 0 → regression (pruner skipped
    loaded: &LoadedSegment,
            let r = lift_phys_to_logical(bin.right())?;
                        format_tree(&tree.tree),
    /// `build_mask` (not the zero-copy `prefetch_mask_buffer` fast
            row_groups: rgs,
                execute_tree_single_collector(corpus, loaded, tree, strategy, call_strat).await
                like.negated(),
    // referencing it (when where_expr is set) type-checks.
            CollectorCallStrategy::TightenOuterBounds,
/// fuzz test and reused across all iterations.
    }
    async fn harness_pages_total_nonzero_with_predicate() {
        std::collections::HashMap<
) -> (Vec<i32>, Arc<dyn datafusion::physical_plan::ExecutionPlan>) {
        use datafusion::common::ScalarValue;
    let mut indices = std::collections::BTreeSet::new();
            .await
    // code path that production never dispatches to for this shape.
    for strategy in [
}
    indices.into_iter().collect()
/// BitmapTreeEvaluator path, which default harness turns OFF.
        use rand::rngs::StdRng;
pub(in crate::indexed_table::tests_e2e) async fn run_iteration_twice(
/// pre-computed set of absolute doc ids and produces a packed u64
        }
            tree: collector,
    };
    run_iteration_impl(corpus, loaded, tree, /*determinism_check=*/ false).await
        segments,
        prune_tree_config: None,
        use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
        Arc::new(move |segment, chunk, stream_metrics, stats_prune_tree| {
        sort_fields: vec![],
    ///     selection → `current_mask` gets built from candidate bitmap)
    #[tokio::test]
    corpus: &Corpus,
    /// Sibling: 1% density → auto-strategy picks `min_skip_run=1`
                page_pruner: pruner,
            &corpus,
                tag = Some(*annotation_id as u8);
            v.sort_unstable();
        let pages_total = get_counter_from_plan(&plan, "pages_total");
mod tests {
            collector_matches: vec![matching.clone()],
        use datafusion::common::ScalarValue;
    (doc_ids, plan)
    // Convert the residual logical Expr to a PhysicalExpr and stash
    }
            Expr::ScalarFunction(datafusion::logical_expr::expr::ScalarFunction::new_udf(
        })
            Some(where_expr), // real WHERE clause pushed to scan(filters)
                    1
        let mut candidates: Vec<i32> = (0..corpus.num_rows() as i32).collect();
            return Some(col(c.name()));
                strategy,
                first_row: offset,
    for child in children {
                    for metric in m.iter() {
        1 => residuals.into_iter().next().unwrap(),
    let expected = oracle_evaluate(tree, corpus);
        schema: loaded.schema.clone(),
        }
        }
                &loaded,
};
    }
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
            expected.len(),
        let loaded = load_segment(&corpus);
        .enumerate()
    _corpus: &Corpus,
            let pruner = Arc::new(PagePruner::new(
    }));
        match child {
    };
async fn run_single_collector_query(
    Some(
        // Use the normal harness path — it now wires pruning_predicates.
                }
}
                like.case_insensitive(),
        let tree_node = BoolNode::And(vec![collector_leaf, predicate]);
        let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
            let rg_index_to_pos: HashMap<usize, usize> = chunk
    /// indexes the RG-relative mask by delivered-row offset after
    let mut stream =
                        out.push(Arc::clone(metric));
            }
    .await
            &gt,
        let mut mkset = |rng: &mut StdRng| -> Vec<i32> {
            collector_matches: vec![candidates],
        let meta =
        let collector_leaf = BoolNode::Collector { annotation_id: 0 };
    async fn harness_single_collector_density_5pct_all_strategies() {
fn collect_predicate_column_indices(tree: &BoolNode) -> Vec<usize> {
    let tags = collect_collector_tags(&bool_tree);
            tree: predicate,
        // `__doc_id` is always column 0 in our corpus schema; SELECT *
    where_expr: Option<datafusion::logical_expr::Expr>,
        use datafusion::physical_expr::PhysicalExpr;
        .await
                leaves: Arc::new(CollectorLeafBitmaps::new(
                std::sync::Arc::new(std::collections::HashMap::new()),
    // Build residual page-pruning predicate (same as production's
        None
    > = Arc::new(
    async fn harness_bare_collector() {
                None,
            .map(|v| v.as_usize())
        use datafusion::physical_expr::PhysicalExpr;
        .collect();
    let mut doc_ids: Vec<i32> = Vec::new();
        let price_lt = col("price").lt(lit(ScalarValue::Int32(Some(1000))));
        }
    // does in production, so our harness exercises real page-pruning
/// `force_pushdown` parameter forces on/off parquet's RowFilter pushdown
        use datafusion::logical_expr::Operator;
    while let Some(batch) = stream.next().await {
        BoolNode::And(children) => {
/// One iteration: generate a tree, evaluate via oracle + pipeline,
        for &doc in &self.matching {
///    DataFusion's planner understands — `DataFrame::filter(expr)`
        prune_tree_config: Some((
    let mut residuals: Vec<BoolNode> = Vec::new();
        segments: loaded.segments.clone(),
                    let diff_info = summarize_diff(&expected, &actual);
        let loaded = load_segment(&corpus);
        }
    force_strategy: Option<FilterStrategy>,
                        strategy,
/// back.
                Arc::clone(&segment.metadata),
            let mut acc = bool_to_logical(iter.next().unwrap())?;
    ctx.register_udf(crate::indexed_table::substrait_to_tree::create_index_filter_udf());
                "BitmapTreeEvaluator vs oracle mismatch (strategy={:?}):\n  tree = {}\n  {}\n",
            let diff_info = summarize_diff(&expected, &actual);
    tree: &GeneratedTree,
    /// which conjoins and stashes as `QueryShardExec.predicate`,
            .expect("one iteration should round-trip cleanly");
    let execution_props = datafusion::execution::context::ExecutionProps::new();
            // And of zero children = TRUE tautology.
        let _ = expr.apply(|node| {
) -> (Vec<i32>, Arc<dyn datafusion::physical_plan::ExecutionPlan>) {
        qcb = qcb.min_skip_run_default(msr);
        let tree = BoolNode::And(vec![BoolNode::Collector { annotation_id: 0 }]);
    _corpus: &Corpus,
                expected.len(),
impl RowGroupDocsCollector for MockCollector {
        .await;
        let mut out = vec![0u64; span.div_ceil(64)];
    }
            }
    let pred_cols: Vec<usize> = {
            Some(acc)
    /// pushed to parquet.**
        let col: Arc<dyn PhysicalExpr> = Arc::new(Column::new("price", 3));
        fn walk(p: &Arc<dyn datafusion::physical_plan::ExecutionPlan>, out: &mut MetricsSet) {
    )
        };
        );
    /// **Specific Regression test.**
    min_skip_run_override: Option<usize>,
        if expected != actual {
use crate::indexed_table::index::CollectDocsResult;
        }
            for c in iter {
/// DataFusion pushes the full conjunct down to `scan()`.
    /// path). Catches the mask-alignment bug where `finalize_batch`
            for child in p.children() {
            Some(FilterStrategy::RowSelection),
            .await
    let collectors: Vec<Arc<dyn RowGroupDocsCollector>> = tags
                walk(child, out);
    loaded: &LoadedSegment,
            )));
    /// With the fix (`will_build_mask → push=false`), this should
                &gt,
    }
        let tree_node = BoolNode::And(vec![BoolNode::Or(vec![c1, c2]), predicate]);
    let mut global_first_row: i64 = 0;
        let mut candidates: Vec<i32> = (0..corpus.num_rows() as i32).collect();
//! generation + execution against the same file.
        candidates.truncate(corpus.num_rows() / 20);
                CollectorCallStrategy::PageRangeSplit,
        let corpus = build_corpus(FixtureConfig::small(0xcafe_1111));
    /// Tests all three strategies to ensure identical semantics.
) -> Vec<i32> {
    use crate::indexed_table::page_pruner::build_pruning_predicate;
        let per_leaf = per_leaf.clone();
    let mut qcb = crate::datafusion_query_config::DatafusionQueryConfig::builder()
    }));
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(SingleCollectorEvaluator::new(
        use rand::SeedableRng;
}
                max_collector_parallelism: cfg_max_parallelism.unwrap_or(if num_tags > 1 {
        let actual = execute_tree_single_collector(
        Some(FilterStrategy::RowSelection),
        }
    #[tokio::test]
/// predicate through to `IndexedTableProvider::scan(filters)`, which
        global_first_row += seg_rows as i64;
            global_base: 0,
                evaluator: Arc::new(BitmapTreeEvaluator),
}
        let seg_rows = corpus.segment_row_counts[i];
                strategy,
    .0
            let mut acc = bool_to_logical(iter.next().unwrap())?;
    pub schema: datafusion::arrow::datatypes::SchemaRef,
                        diff_info,
) -> Option<Vec<i32>> {
            );
}
    tree: &GeneratedTree,
    factory: EvaluatorFactory,
        let loaded = load_segment(&corpus);
        };
            force_strategy,
/// Same walker as `indexed_executor::collect_predicate_exprs`, inlined
        BoolNode::Or(children) => {
    format!("{:?}", tree)
            Some(FilterStrategy::RowSelection),
        .force_strategy(force_strategy)
    match node {
    let mut qcb = crate::datafusion_query_config::DatafusionQueryConfig::builder()
        let price_idx = corpus.schema.index_of("price").unwrap();
    if !matches!(classify_filter(&tree.tree), FilterClass::SingleCollector) {
                &gt,
    } else {
        let expected = oracle_evaluate(&gt, &corpus);
                Arc::clone(&segment.metadata),
fn extract_single_collector(tree: &BoolNode) -> Option<(u8, BoolNode)> {
            .await
            &loaded,
    /// **Diagnostic: BitmapTreeEvaluator with a real WHERE clause
        .batch_size(cfg_batch_size.unwrap_or([128, 1024, 8192][seed as usize % 3]));
        run_iteration(&corpus, &loaded, &gt)
                Box::new(pattern),
    }
                ),
        use rand::SeedableRng;
    // Register the index_filter UDF so any Expr::ScalarFunction
            .as_any()
            let pruner = Arc::new(PagePruner::new(
    Some((t, residual))
}
    }));
        actual.len(),
        sort_orders: vec![],
        None,
        let tree = Arc::clone(&bool_tree);
        predicate_columns: vec![],
async fn run_iteration_impl(
        .target_partitions(1)
                *bin.op(),
        }
            Expr::ScalarFunction(datafusion::logical_expr::expr::ScalarFunction::new_udf(
    // SingleCollector path).
            offset += n;
            assert_eq!(
        let gt = GeneratedTree {
        }
            return Some(Expr::Like(datafusion::logical_expr::expr::Like::new(
    // No WHERE clause — the pushdown_predicate above carries the
            .filter_map(|expr| {
        let collector = BoolNode::Collector { annotation_id: 0 };
    loaded: &LoadedSegment,
            parquet_size: size,
        let mut indices = std::collections::BTreeSet::new();
/// 1. Extracting the single `Collector` tag + residual (non-Collector
        };
        "expected={} actual={} missing(first 10)={:?} extra(first 10)={:?}",
                .map(|pp| (Arc::as_ptr(expr) as *const () as usize, pp))
    // Dispatch fuzz: verify classify_filter's decision is consistent
            .expect("__doc_id is Int32");
        let matching: Vec<i32> = (0..100i32).collect();
        let mut rng = StdRng::seed_from_u64(0x1beef_2222);
        .iter()
/// assert equal. Returns `Err(message)` on mismatch so the caller can
        };
        cancellation_token: None,
        BoolNode::Collector { .. } => {}
            assert!(arr.is_valid(i), "__doc_id is non-null");
/// Like `run_iteration` but ALSO runs each strategy twice and asserts
        let corpus = build_corpus(FixtureConfig::small(0x3333));
        ctx.sql("SELECT * FROM t").await.unwrap()
        use rand::seq::SliceRandom;
            let _ = segment;
        let loaded = load_segment(&corpus);
            other => residuals.push(other.clone()),
    // CollectorCallStrategy combination and assert all agree with the
        for strategy in [
                    indices.insert(col.index());
            .downcast_ref::<Int32Array>()
//! `IndexedStream` pipeline and compare against the oracle.
                pct,
                stats_prune_tree: stats_prune_tree.cloned(),
        let expected = oracle_evaluate(&gt, &corpus);
        }
    let plan = df.create_physical_plan().await.unwrap();
        use rand::rngs::StdRng;
    // with the evaluator paths. Tree-classified trees must NOT be
            .column(idx)
                strategy,
    ///
    let qc = qcb.build();
    ] {
}
        let arr = b
    // through SingleCollectorEvaluator with every FilterStrategy ×
            Some(true),       // pushdown ON
        // Two collectors, 5% density each, uniform.
        }
        .await
        // the residual. `index_filter(Binary([0])) OR index_filter(Binary([1]))`
    tree: &GeneratedTree,
        for i in 0..arr.len() {
    let task_ctx = ctx.task_ctx();
            if actual != actual2 {
use super::tree_gen::{collect_collector_tags, GeneratedTree};
        schema: schema_out.expect("at least one segment"),
        if let Some(is_null) = any.downcast_ref::<IsNullExpr>() {
use datafusion::arrow::array::{Array, Int32Array};
    force_strategy: Option<FilterStrategy>,
async fn run_with_factory_plan(
            doc_ids.push(arr.value(i));
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
    let missing: Vec<_> = e.difference(&a).take(10).copied().collect();
}
    execute_tree_with_plan_pushdown_filter(
            let actual = execute_tree_single_collector(
    /// rows. Pushdown must be disabled for this RG so the delivered
            )
#[cfg(test)]
    #[tokio::test]
        let gt = GeneratedTree {
        let loaded = load_segment(&corpus);
            let actual2 = execute_tree_with(corpus, loaded, tree, strategy).await;
            doc_ids.push(arr.value(i));
 * The OpenSearch Contributors require contributions made to
        let b = batch.unwrap();
    let ctx = SessionContext::new();
            Some(Expr::Not(Box::new(e)))
    let pruning_predicates: Arc<
    // Collectors are valid SingleCollector shapes that the harness
            .unwrap(),
                stream_metrics.ffm_collector_calls.clone(),
        extra
use datafusion::execution::context::SessionContext;
) -> Result<(), String> {
    factory: EvaluatorFactory,
    /// This tests the OTHER branch of the fix — regression-proofing
        use datafusion::physical_expr::PhysicalExpr;
        )
) -> Result<(), String> {
        assert_eq!(
        let corpus = build_corpus(FixtureConfig::small(0x1f00d));
            }
    ctx.register_table("t", provider).unwrap();
        use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
        let price_idx = corpus.schema.index_of("price").unwrap();
                expected.len(),
                    actual2.len(),
///    predicate into `IndexedTableProvider::scan()` where it becomes
    /// behavior.
            for c in iter {
    let mut schema_out: Option<datafusion::arrow::datatypes::SchemaRef> = None;
        .batch_size([256, 1024, 8192][loaded.segments.len() % 3]);
        let predicate = BoolNode::Predicate(Arc::new(BinaryExpr::new(col, Operator::Lt, lit)));
                    std::collections::HashMap::new(),
            Arc::clone(&pruning_predicates),
            &corpus,
        });
        let mut candidates: Vec<i32> = (0..corpus.num_rows() as i32).collect();
        use datafusion::logical_expr::Operator;
    async fn harness_smoke_single_iteration() {
            if let Some(col) = node.downcast_ref::<datafusion::physical_expr::expressions::Column>()
    /// wrong positions.
use futures::StreamExt;
    use datafusion::logical_expr::{col, lit, Expr, Operator};
            .expect("tree classifies as SingleCollector");
        candidates.shuffle(&mut rng);
            Arc::new(Literal::new(ScalarValue::Int32(Some(1000))));
        let mut offset = global_first_row;
    // Only proceed for trees that classify as SingleCollector WITHOUT
    /// is non-identity and `current_mask` must be built through
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
                    }
            tree: tree_node,
            let e = bool_to_logical(inner)?;
    )
        .await,
                Some(Arc::clone(&collector)),
                    Box::new(next),
    tree: &GeneratedTree,
        });
        predicate_columns: collect_predicate_column_indices(&bool_tree),
        let col: Arc<dyn PhysicalExpr> = Arc::new(Column::new("price", price_idx));
        let mut rng = StdRng::seed_from_u64(0xdead_beef_cafe);
    }
        let expected = oracle_evaluate(&gt, &corpus);
            .for_each(|ch| collect_predicate_exprs_harness(ch, out)),
    /// is the only test that actually invokes parquet with a non-null
        // 5% density, uniform.
        use datafusion::physical_expr::PhysicalExpr;
    let schema = loaded.schema.clone();
        };
        let path = tmp.path().to_path_buf();
        tree,
        _ => BoolNode::And(residuals),
                Box::new(target),
                residual_physical.clone(),
    // `force_pushdown` overrides the node-wide indexed_pushdown_filters default;
    ///   - `force_pushdown = Some(true)` (parquet `with_predicate`
    /// assert each matches the oracle.
        predicate_columns: pred_cols,
                in_list.negated(),
    pub segments: Vec<SegmentFileInfo>,
    // any De Morgan normalization — otherwise we'd be exercising a
            rgs.push(RowGroupInfo {
            assert!(arr.is_valid(i), "__doc_id is non-null");
    tree: &GeneratedTree,
        Arc::new(object_store::local::LocalFileSystem::new());
use crate::indexed_table::page_pruner::PagePruner;
    #[tokio::test]
    let cfg_target_partitions = _corpus.config.target_partitions;
    }
            v
        );
) -> Vec<i32> {
            .column(0)
    // `None` leaves the default in place.
            .collect(),
/// 4. Parquet's decode-time `with_predicate` + DataFusion's outer
pub(in crate::indexed_table::tests_e2e) fn format_tree(tree: &BoolNode) -> String {
        let sc_result = execute_tree_single_collector(
        let or_expr = datafusion::logical_expr::or(c1_expr, c2_expr);
    };
    loaded: &LoadedSegment,
        candidates.sort_unstable();
/// to hand parquet via `with_predicate` — mirrors what
    (doc_ids, plan)
        factory,
    // residual. `scan()` ignores filters anyway.
        for call_strat in [
        }
        .target_partitions(1)
    doc_ids
                std::sync::Arc::new(crate::indexed_table::eval::single_collector::FfmDelegatedBackendCollectorFactory),
    tree: &GeneratedTree,
        Ok(out.into())
        let loaded = load_segment(&corpus);
                schema.clone(),
        let loaded = load_segment(&corpus);
        for strategy in [
        let corpus = build_corpus(FixtureConfig::small(corpus_seed));
        let collector = BoolNode::Collector { annotation_id: 0 };
            if p.name() == "QueryShardExec" {
        Some(FilterStrategy::RowSelection),
    let mut segments = Vec::with_capacity(corpus.parquet_files.len());
            }
fn summarize_diff(expected: &[i32], actual: &[i32]) -> String {
            })
        expr: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
/// `index_filter(...)` UDF call AND parquet-native predicates).
                cost_predicate: 1,
        cancellation_token: None,
    // behavior instead of silently falling back to universe bitmaps.
        .await;
    force_pushdown: Option<bool>,
            let inner = lift_phys_to_logical(is_null.arg())?;
    async fn harness_bare_predicate() {
            Ok(datafusion::common::tree_node::TreeNodeRecursion::Continue)
                Arc::new(idx_filter_udf),
    execute_tree_with_plan(_corpus, loaded, tree, force_strategy)
                    stream_metrics.ffm_collector_calls.clone(),
        }
        let s2 = mkset(&mut rng);
/// Full-control execution: optionally attach a logical `Expr` as the
            let actual = execute_tree_single_collector(
    let task_ctx = ctx.task_ctx();
        use datafusion::logical_expr::Operator;
use std::collections::HashMap;
            Some(FilterStrategy::BooleanMask),
    use rand::SeedableRng;
                        stream_metrics,
    let task_ctx = ctx.task_ctx();
                Box::new(l),
        .expect("tree classifies as SingleCollector");
        ctx.table("t").await.unwrap().filter(filter).unwrap()
/// Run the tree through `SingleCollectorEvaluator` (production's fast
        };
            usize,
    let extra: Vec<_> = a.difference(&e).take(10).copied().collect();
    let mut doc_ids: Vec<i32> = Vec::new();
                Ok(datafusion::common::tree_node::TreeNodeRecursion::Continue)
            actual.len()
            residual_logical,
    use crate::indexed_table::eval::single_collector::CollectorCallStrategy;
    .await
        use datafusion::common::ScalarValue;
    }
        BinaryExpr as PhysBinaryExpr, Column as PhysColumn, InListExpr, IsNullExpr, LikeExpr,
/// children.
        // Multi-collector → classifies as Tree path.
                "density={}% strategy={:?}: expected {} rows, got {}",
    let df = ctx.sql("SELECT * FROM t").await.unwrap();
#[derive(Debug)]
                .unwrap();
fn collect_predicate_exprs_harness(
        BoolNode::DelegationPossible { original_expr, .. } => lift_phys_to_logical(original_expr),
        let gt = GeneratedTree {
    // classify_filter internally). SingleCollector-classified trees
        .as_ref()
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
            metadata: Arc::clone(&parquet_meta),
    use rand::rngs::StdRng;
    /// `predicate` on the BitmapTree path — closer to production
            Arc::new(MockCollector {
/// working across segments).
            }
        .and_then(|expr| build_pruning_predicate(expr, schema.clone()));
            let n = parquet_meta.row_group(j).num_rows();
/// Same mock collector as the rest of tests_e2e uses. Takes a
                    format_tree(&tree.tree),
        let predicate = BoolNode::Predicate(Arc::new(BinaryExpr::new(col, Operator::Lt, lit)));
    }
    let (tag, residual_bool) = extract_single_collector(&bool_tree)?;
    /// Forces the block-granular mask path where `PositionMap::Runs`
 * compatible open source license.
    }
    /// `current_mask` built from candidate bitmap over delivered
                num_rows: n,
    let residual = match residuals.len() {
        let lit: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(1000))));
            collector_matches: vec![candidates],
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
    let residual_physical =
                .iter()
            });
            let l = lift_phys_to_logical(bin.left())?;
        }
    // Cross-check: when the tree classifies as SingleCollector, run
pub(in crate::indexed_table::tests_e2e) async fn execute_tree_with(
    // oracle. This ensures FullRange, TightenOuterBounds, and
        .force_strategy(force_strategy)
        pushdown_predicate,
        let tree = generate_tree(&mut rng, &corpus);
/// conjoins into `QueryShardExec.predicate` → `IndexedStream.predicate`
        run_iteration(&corpus, &loaded, &gt)
        segments: loaded.segments.clone(),
        loaded,
                    Box::new(next),
        use rand::SeedableRng;
    let ctx = SessionContext::new();
            return Err(format!(
        store_url,
            .as_any()
    tree: &GeneratedTree,
            if children.is_empty() {
    let seed = _corpus.config.seed;
    format!(
        let b = batch.unwrap();
        force_strategy,
    /// rowset matches what the mask assumes. Without the fix in
}
/// at decode time. `pushdown_predicate` provides the residual predicate
    /// 5% density → auto-strategy picks `min_skip_run=1024` →
        let corpus = build_corpus(FixtureConfig::small(0xdead_beef_cafe));
        };
    }
        let s1 = mkset(&mut rng);
                    expr,
}
//! Fuzz harness: run a generated tree through the real
        min_doc: i32,
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    let mut stream =
///
    collect_predicate_exprs_harness(tree, &mut exprs);
            {
            .unwrap_or(0)
        ] {
    }
/// re-runs (ordering flakes, race conditions).
    }
        let corpus = build_corpus(FixtureConfig::small(0x2222));
    async fn harness_simple_and_collector_predicate() {
        )
        .map(|&tag| {
use super::corpus::Corpus;
            corpus,
        }
    let factory: EvaluatorFactory = {
        let actual = execute_tree_with(corpus, loaded, tree, strategy).await;
                schema.clone(),
                )
        BoolNode::Not(inner) => collect_predicate_exprs_harness(inner, out),
/// Used for diagnostic tests that want to exercise pushdown=ON on the
        let collector_leaf = BoolNode::Collector { annotation_id: 0 };
///    then wraps a `FilterExec` around our scan and passes the
/// provider, query it, return the set of `__doc_id` values that came
/// top-level AND, etc.).
            .iter()
        let matching: Vec<i32> = (0..100i32).collect();
            return Err(format!(
            .await
        use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
                    crate::indexed_table::eval::CollectorCallStrategy::FullRange,
        let lit: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(500))));
        loaded,
            ));
            &gt,
                collector_strategy: [
            "BitmapTree + pushdown ON + BooleanMask + real WHERE: expected {} rows, got {}",
    // Build per-leaf PruningPredicates the same way indexed_executor.rs
}
        let cfg = FixtureConfig::block_granular_dense(0x4444);
    matching: Vec<i32>,
    )
        datafusion::physical_plan::execute_stream(Arc::clone(&plan), task_ctx).unwrap();
    let cfg_batch_size = _corpus.config.batch_size;
    ///     filters rows at decode time)
    /// the SingleCollector path, this surfaces it. Additionally, this
            ));
    let num_tags = tags.len();
                Box::new(r),
    // doesn't implement, so we don't assert on those.
    /// pass because pushdown is disabled when `current_mask` would
    let mut exprs = Vec::new();
                Some(
        query_config: Arc::new(qc),
        BoolNode::DelegationPossible { original_expr, .. } => out.push(Arc::clone(original_expr)),
                    None,
    // Match production: classify the tree in its un-normalized form.
                format_tree(&tree.tree),
pub(in crate::indexed_table::tests_e2e) fn load_segment(corpus: &Corpus) -> LoadedSegment {
/// (bare Collector, multi-Collector, OR at top level, NOT above
    pushdown_predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        evaluator_factory: factory,
    ///   - `AND(Collector[5% density], price < 1000)`
                if let Some(m) = p.metrics() {
/// → parquet's `with_predicate`.
        query_config: Arc::new(qc),
    let df = if let Some(filter) = where_expr {
        Arc::new(move |segment, _chunk, stream_metrics, _stats_prune_tree| {
    let cfg_min_skip_run = _corpus.config.min_skip_run_override;
    }
        datafusion::physical_plan::execute_stream(Arc::clone(&plan), task_ctx).unwrap();
                    "non-deterministic output (strategy={:?}):\n  tree = {}\n  run1.len={} run2.len={}\n",
            .downcast_ref::<Int32Array>()
                format_tree(&tree.tree),
            &loaded,
    #[tokio::test]
        let predicate = BoolNode::Predicate(Arc::new(BinaryExpr::new(col, Operator::Lt, lit)));
        run_iteration(&corpus, &loaded, &tree)
    loaded: &LoadedSegment,
        let schema = b.schema();
        let corpus = build_corpus(cfg);
/// pushdown.
            )));
    let plan = df.create_physical_plan().await.unwrap();
    LoadedSegment {
            loaded,
///    the physical `predicate` on `QueryShardExec`.
        Arc::new(object_store::local::LocalFileSystem::new());
    /// This mirrors production: construct a logical `Expr` containing
    determinism_check: bool,
    /// both the `index_filter(...)` UDF call and a parquet-native
    /// Same pattern as `metrics.rs::aggregate_metrics` but inlined.
            CollectorCallStrategy::PageRangeSplit,
        let parquet_meta = meta.metadata().clone();
        assert_eq!(
    force_strategy: Option<FilterStrategy>,
        return None;
        })
    doc_ids.sort_unstable();
    /// immediately.
        .batch_size([128, 1024, 8192][loaded.segments.len() % 3]);
        let c2_expr =
    // PageRangeSplit all produce identical results.
    /// Bug: pushdown drops rows at decode; `current_mask` is indexed
    ///
                }
                CollectorCallStrategy::FullRange,
    force_strategy: Option<FilterStrategy>,
    /// DataFusion calls `IndexedTableProvider::scan(filters=[...])`
fn bool_to_logical(node: &BoolNode) -> Option<datafusion::logical_expr::Expr> {
            Arc<datafusion::physical_optimizer::pruning::PruningPredicate>,
        missing,
                ));
) -> (Vec<i32>, Arc<dyn datafusion::physical_plan::ExecutionPlan>) {
    use crate::indexed_table::eval::single_collector::CollectorCallStrategy;
                    ));
    use super::*;
/// Mirrors `indexed_executor::collect_predicate_column_indices` — returns
                    Box::new(acc),
    Ok(())
    let matching = tree.collector_matches[tag as usize].clone();
        let gt = GeneratedTree {
    }
    out: &mut Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
                    [1, 1, 2, 4][seed as usize % 4]
        let (_rows, plan) = execute_tree_with_plan(&corpus, &loaded, &gt, None).await;
    /// filtering.
    while let Some(batch) = stream.next().await {
        pushdown_predicate,
            return Some(Expr::InList(datafusion::logical_expr::expr::InList::new(
            let target = lift_phys_to_logical(like.expr())?;
        let b = batch.unwrap();
                ));
    }
                    ),
        };
    ) -> Option<Expr> {
        // matches the tree's OR(C1, C2); `price < 1000` is the residual.
        )
use crate::indexed_table::eval::{RowGroupBitsetSource, TreeBitsetSource};
            Some(FilterStrategy::BooleanMask),
            ));
            .expect("simple AND(Collector, price<1000) must round-trip");
        sort_orders: vec![],
    force_strategy: Option<FilterStrategy>,
    // the Collector).
    }
/// Shared tail: given a factory, build provider, SELECT *, return doc ids.
        walk(plan, &mut set);
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        // Force BooleanMask strategy through the SingleCollector path.
        run_single_collector_density_test(1, 0xcccc, 0xdddd).await;
    // `force_pushdown` overrides the node-wide indexed_pushdown_filters default;
}
                    ),
    let df_schema = datafusion::common::DFSchema::try_from(loaded.schema.as_ref().clone()).unwrap();
        let c2 = BoolNode::Collector { annotation_id: 1 };
        let c1 = BoolNode::Collector { annotation_id: 0 };
    /// `IndexedStream::poll_next`, this fails with rows from the
    let mut qcb = crate::datafusion_query_config::DatafusionQueryConfig::builder()
                actual,
                actual.len()
            None,
    // as pushdown_predicate — mirrors what `execute_indexed_query`
        // Locate __doc_id column by name (filter path may reorder).
                ));
        let collector = Arc::clone(&collector);
    /// then passed to parquet's `with_predicate` for decode-time
    _corpus: &Corpus,
            Ok(eval)
        let phys_col: Arc<dyn PhysicalExpr> = Arc::new(Column::new("price", price_idx));
    }
//! Shares one parquet corpus across iterations — the corpus build cost
        let mut rng = StdRng::seed_from_u64(0x5555);
/// embed seed info in a panic.
/// query WHERE clause. When `Some`, DataFusion's planner pushes that
            expected.len(),
        _ => return None,
        let tree_node = BoolNode::And(vec![collector, predicate]);
        assert!(
/// A set of loaded segments derived from the corpus. Built once per
        plan: &Arc<dyn datafusion::physical_plan::ExecutionPlan>,
}
                vec![lit(ScalarValue::Int32(Some(0)))],
/// here so the harness can mirror production's per-leaf pruning setup.
        Literal as PhysLiteral,
    let e: BTreeSet<i32> = expected.iter().copied().collect();
        sort_orders: vec![],
                Arc::new(idx_filter_udf.clone()),
        use datafusion::common::ScalarValue;
        let mut rng = StdRng::seed_from_u64(0xbeef_1111);
                return Some(lit(false));
    ctx.register_table("t", provider).unwrap();
    doc_ids.sort_unstable();
        if let Some(l) = any.downcast_ref::<PhysLiteral>() {
                    actual.len(),
    /// (regression from seed `INDEXED_E2E_SEED=1e94955ce24bc83d`).
            doc_ids.push(arr.value(i));
                ),
        if let Some(ref pp) = pushdown_predicate {
    ) -> Result<CollectDocsResult, String> {
        use rand::rngs::StdRng;
            "pages_total was 0; page pruner never ran on price<500 predicate — regression?"
        run_single_collector_density_test(5, 0xaaaa, 0xbbbb).await;
            expected,
/// path). Works by:
    let cfg_max_parallelism = _corpus.config.max_collector_parallelism;
            let mut v: Vec<i32> = (0..corpus.num_rows() as i32).collect();
/*
        let price_idx = corpus.schema.index_of("price").unwrap();
        cancellation_token: None,
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        let corpus = build_corpus(FixtureConfig::small(0x1111));
    );
        BoolNode::Collector { .. } => None,
 */
                rg_index_to_pos,
                list?,
/// 3. Building the evaluator factory with a `MockCollector` replaying
    let pushdown_predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>> = Some(
/// `execute_indexed_query` computes from the BoolNode for production.
                if tag.is_some() {
        Some(false),
    /// which would be correct but slow.
    force_strategy: Option<FilterStrategy>,
        .target_partitions(cfg_target_partitions.max(1))
//! is paid once per test, then many iterations run cheap tree
            let pattern = lift_phys_to_logical(like.pattern())?;
        }
                &loaded,
        store,
            }
                tree: Arc::new(resolved),
    ///
            {
            actual,
            let list: Option<Vec<Expr>> = in_list.list().iter().map(lift_phys_to_logical).collect();
                residual_pp.clone(),
    // accepted by execute_tree_single_collector (which guards on
        max_doc: i32,
        query_config: Arc::new(qc),
            schema_out = Some(meta.schema().clone());
    let qc = qcb.build();
        for j in 0..parquet_meta.num_row_groups() {
            collector_matches: vec![candidates],
        let predicate = BoolNode::Predicate(Arc::new(BinaryExpr::new(col, Operator::Lt, lit)));
    };
 *
use crate::indexed_table::eval::single_collector::SingleCollectorEvaluator;
            v.truncate(corpus.num_rows() / 20);
    doc_ids.sort_unstable();
        schema: loaded.schema.clone(),
use crate::indexed_table::stream::{FilterStrategy, RowGroupInfo};
                &schema,
                actual,
    corpus: &Corpus,
                    loaded.schema.clone(),
    ) -> usize {
) {
}
        let _ = DataType::Int32; // silence unused import
    /// predicate (`price < 1000`), pass it via `.filter(...)` so
        sort_fields: vec![],
/// enforces the residual predicate authoritatively; parquet's own
    let children = match tree {
use std::sync::Arc;
        datafusion::physical_plan::execute_stream(Arc::clone(&plan), task_ctx).unwrap();
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
            v.shuffle(rng);
    // Wire one mock collector per Collector leaf, matching DFS order.
) -> Vec<i32> {
                0,
            collector_matches: vec![],
        evaluator_factory: factory,
use crate::indexed_table::bool_tree::BoolNode;
    loaded: &LoadedSegment,
    factory: EvaluatorFactory,
        store,
        emit_row_ids: false,
        .into_iter()
        }
                expected,
            tree: tree_node,
    /// against an accidental "turn off pushdown everywhere" change
            .as_any()
        if let Some(c) = any.downcast_ref::<PhysColumn>() {
/// Execute `SELECT * FROM t WHERE <residual>` so DataFusion's planner
    ///
    let t = tag?;
        candidates.truncate(corpus.num_rows() * pct / 100);
                .enumerate()
                        stream_metrics,
        // Uniform random subset at `pct`% density.
    tree: &GeneratedTree,
    let store: Arc<dyn object_store::ObjectStore> =
/// has a `Filter` node containing the original WHERE (both the
        datafusion::physical_expr::create_physical_expr(&residual, &df_schema, &execution_props)
        &self,
            if children.is_empty() {
            .await
///    page-level pruning during prefetch.
        let mut set = MetricsSet::new();
    loaded: &LoadedSegment,
        let mut rng = StdRng::seed_from_u64(collector_seed);
    residual: datafusion::logical_expr::Expr,
            assert!(arr.is_valid(i), "__doc_id is non-null");
        run_single_collector_query(
        qcb = qcb.indexed_pushdown_filters(push);
            .expect("__doc_id is Int32");
        if let Some(like) = any.downcast_ref::<LikeExpr>() {
        emit_row_ids: false,
    force_pushdown: Option<bool>,
                        "SingleCollectorEvaluator vs oracle mismatch (strategy={:?}, call={:?}):\n  tree = {}\n  {}\n",
    use datafusion::common::tree_node::TreeNode;
        name: &str,
                acc = Expr::BinaryExpr(datafusion::logical_expr::BinaryExpr::new(
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
            }
    }
        sort_fields: vec![],
                return Err(format!(
                .map(|(pos, &idx)| (idx, pos))
        pushdown_predicate,
        None,
    #[tokio::test]
            None,
            expected,
        let corpus = build_corpus(FixtureConfig::small(0x4444));
        emit_row_ids: false,
async fn run_with_factory(
                strategy,
        use rand::seq::SliceRandom;
        use datafusion::common::ScalarValue;
        use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
    /// Parameterized helper: build a Collector at `pct`% density,
/// Execute one tree end-to-end: wire mock collectors, build the table
    #[tokio::test]
        candidates.sort_unstable();
        store_url,
                &schema,
                    // up to 4 (parallel) to exercise PrecomputedLeafCache.
    async fn harness_bitmap_tree_pushdown_block_granular_must_align() {
        if let Some(in_list) = any.downcast_ref::<InListExpr>() {
                    Box::new(acc),
        .collect();
        indices.into_iter().collect()
        let c1_expr =
/// Pretty-print a tree to a debug string. Used in failure messages.
    )
        let col: Arc<dyn PhysicalExpr> = Arc::new(Column::new("price", 3));
    if let Some(msr) = min_skip_run_override {
struct MockCollector {
    /// numeric column, `pages_total > 0` means page pruning actually
    // `None` leaves the default in place.
use super::oracle::oracle_evaluate;
        let loaded = load_segment(&corpus);
    for strategy in [
/// logical `Expr` suitable for `DataFrame::filter`. Returns `None` if
    run_with_factory_plan(
        use datafusion::common::tree_node::TreeNode;
        // original LogicalPlan's filter containing BOTH UDF calls AND
        let file = std::fs::File::open(&path).unwrap();
        0 => BoolNode::And(vec![]),
/// tests can inspect metrics.
        store_url,
 * SPDX-License-Identifier: Apache-2.0
    async fn harness_bare_collector_block_granular() {
    loaded: &LoadedSegment,
    async fn run_single_collector_density_test(pct: usize, corpus_seed: u64, collector_seed: u64) {
        .indexed_pushdown_filters(true)
pub(in crate::indexed_table::tests_e2e) async fn execute_tree_with_plan_pushdown_filter(
    }
        let lit: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(1000))));
            ));
            CollectorCallStrategy::FullRange,
            max_doc: seg_rows as i64,
            .expect("bare Predicate must round-trip");
        let expected = oracle_evaluate(&gt, &corpus);
        let predicate =
    let bool_tree = Arc::new(bool_tree);
    tree: &BoolNode,
    ///
        if schema_out.is_none() {
    use datafusion::physical_expr::expressions::{
        >,
            );
                if expected != actual {
            ));
                &corpus,
/// This mirrors production: in production, the substrait LogicalPlan
    /// skip runs shift the alignment.
        let gt = GeneratedTree {
                actual.len()
            .expect("__doc_id is Int32");
        let arr = b
    async fn harness_single_collector_pushdown_block_granular_must_align() {
        run_iteration(&corpus, &loaded, &gt)
        let predicate = BoolNode::Predicate(Arc::new(BinaryExpr::new(col, Operator::Lt, lit)));
                pruning_predicates: Arc::clone(&pruning_predicates),
            Some(FilterStrategy::BooleanMask),
            .column(0)
    /// Setup:
            BoolNode::Collector { annotation_id } => {
    /// Walks the plan and sums the named counter off QueryShardExec.
            sort_max: None,
        Some(FilterStrategy::BooleanMask),
        leaf_exprs
//!
    }
