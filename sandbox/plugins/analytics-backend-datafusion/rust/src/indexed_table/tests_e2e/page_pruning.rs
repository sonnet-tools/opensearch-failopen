    let pruner = PagePruner::new(&schema, seg.metadata, schema.clone());
    expected_len: usize,
///
/// AND(Collector(all), Predicate(price < 1024)) → only page 0 survives.
        store_url,
/// → Most selective predicate first, then less selective, then Coll(all)
///     ├─ Pred(price < 21024)       keeps 3/4 pages → cost = ceil(1000*3/4) = 750
    }));
) -> (Vec<i32>, Arc<dyn ExecutionPlan>) {
    // All should be even-indexed within page 2
/// Predicate that matches nothing → all 4 pages pruned, zero rows.
    let tree = BoolNode::And(vec![
        collector_leaf(0), // all docs
use crate::indexed_table::bool_tree::BoolNode;
                collector_leaf(5),                          // odd docs
    run_all_strategies(0, residual, 0, NUM_PAGES).await;
#[derive(Debug)]
    let mut sorted: Vec<(u32, usize)> = costs.iter().copied().zip(0..).collect();
            BoolNode::And(vec![
///   Root acc = {1024..4095} & OR_result
        BoolNode::Collector { .. } => {}
async fn run_bitmap_tree(tree: BoolNode) -> (Vec<i32>, Arc<dyn ExecutionPlan>) {
    let (prices, plan) = run_bitmap_tree(tree).await;
    Arc::new(Schema::new(vec![
}
    // Page 1 (10000..11023): even docs only → 512 rows
    let children = match &resolved {
    let pruner = PagePruner::new(&schema, seg.metadata, schema.clone());
        row_groups: rgs,
    let pred_narrow = binop(col_expr("price"), Operator::Lt, lit_i32(1024)); // keeps page 0
        collector_leaf(1), // even docs
    subtree_cost, BitmapTreeEvaluator, CollectorLeafBitmaps,
const NUM_PAGES: usize = 4;
use tempfile::NamedTempFile;
///   Net new from first2pp: {1025, 2048} → +2 docs
async fn complex_5_wide_or_mixed_predicates_collectors() {
        assert_eq!(
///            ranges = intersect([(1024,3072)], [(2048,4096)]) = [(2048,3072)]
    let pred_lt_31k = binop(col_expr("price"), Operator::Lt, lit_i32(31_024));
    // Pred(<21024):  3/4 pages kept → ceil(1000 * 3 / 4) = 750
    };
        BoolNode::Not(c) => wire_collectors_dfs(c, out),
        Field::new("price", DataType::Int32, false),
}
        arrow_schema: schema.clone(),
///      called with ranges from root acc (page 2 only after step 3)
            BoolNode::And(vec![
}
            .flat_map(|p| {
///     ├─ Pred(price < 31024)                                keeps pages 0,1,2
/// Costs:                        [250,        250,           750,          10_000]
///
        .collect();
    // child 2: OR subtree (sum of inner costs)
    let path = tmp.path().to_path_buf();
///   2. Pred(price < 31024): cost 750 (3/4 pages)
    // child 3: Coll(all) = 10_000
        pred_node(pred_wide.clone()),    // child 1
///           ├─ AND(Pred(price >= 20000), Pred(price < 21024), Coll(odd))  page 2, odd
        global_base: 0,
}
/// Root AND sort order: [Pred(750), Pred(1000), Coll(10_000), OR(31_250)]
                collector_leaf(1),      // even docs
///   1. Pred(price >= 10000): cost 750 (3/4 pages)
}
///            inner-inner result = empty
        .filter(|&&p| p >= 10_000 && p < 11_024)
    // All 4096 rows returned, 0 pruned (pages_total may be 0 since
        pred_node(pred_narrow2.clone()), // child 3
///            inner_acc unchanged
/// Pred(<1024) is index 0, Pred(>=30000) is index 3 → Pred(<1024) first.
///          Coll(first2pp) called with [(1024,3072)] → docs 1024,1025,2048,2049
        let m = aggregate_metrics(&plan);
    assert_eq!(sorted_indices[0], 0, "most selective pred first");
        .into_iter()
    assert_eq!(sorted[3].1, 2, "OR subtree last (cost {})", sorted[3].0);
    let left = binop(col_expr("price"), Operator::GtEq, lit_i32(10_000));
        sort_max: None,
    // Resolve tree to get ResolvedNodes.
        );
    match node {
            "strategy {:?}: expected {} rows, got {}",
        .copied()
/// 3 of 4 pages pruned.
    let m = aggregate_metrics(&plan);
    let schema = meta.schema().clone();
    };
        emit_row_ids: false,
/// ```
    let plan = df.create_physical_plan().await.unwrap();
        Field::new("brand", DataType::Utf8, false),
/// Run a BoolNode tree through the bitmap-tree evaluator, return (prices, plan).
            BoolNode::And(vec![pred_node(pred_lt_21k), collector_leaf(1)]),
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
impl RowGroupDocsCollector for MockCollector {
    assert_eq!(get_counter(&m, "pages_pruned"), 1);
            BoolNode::And(vec![collector_leaf(6), pred_node(pred_ge_30k)]), // page3 coll, page 3
    let pred_narrow2 = binop(col_expr("price"), Operator::GtEq, lit_i32(30_000)); // 1/4 pages
        BoolNode::Or(vec![
 * compatible open source license.
    residual: Arc<dyn PhysicalExpr>,
        1 => (0..NUM_ROWS as i32).step_by(2).collect(),
                rg_index_to_pos: HashMap::new(),
    set.sum(|m| m.value().name() == name && m.metric_type() == MetricType::Dev)
};
/// All produce the same rows for price in [10_000, 11_024).
            Arc::new(StringArray::from(brands)),
    let schema = fixture_schema();
    EvaluatorFactory, IndexedTableConfig, IndexedTableProvider, SegmentFileInfo,
    let (prices, plan) = run_bitmap_tree(tree).await;
        let pp_map = Arc::clone(&pp_map);
            "strategy {:?}: pages_pruned",
    sorted_indices.sort_by_key(|&i| costs[i]);
 * The OpenSearch Contributors require contributions made to
    assert_eq!(*prices.last().unwrap(), 21_023);
//! |  0   | 0–1023      | 0..1_024       | `"alpha"` |
        })
    let prices: Vec<i32> = (0..NUM_PAGES)
// ═════════════════════════════════════════════════════════════════════
            Ok(eval)
    let parquet_meta = meta.metadata().clone();
    assert_eq!(prices.len(), 512);
        .set_statistics_enabled(EnabledStatistics::Page)
/// AND─┬─ Pred(price >= 10000)                              3/4 pages → cost 750
        exprs
    let tree = BoolNode::And(vec![
///      2a. AND(Pred(price < 11024), Coll(even)):
/// Root AND execution:
///     │    Pred keeps 1/4 → cost 250, Coll cost 10_000 → subtree 10_250
        cost_a < cost_b,
    let (prices, plan) = run_bitmap_tree(tree).await;
///
    assert_eq!(page2_prices.len(), 1024);
    ]);
        .iter()
                schema.clone(),
    collector_tag: u8,
    let tree = BoolNode::And(vec![collector_leaf(0), pred_node(expr)]);
    CollectorCallStrategy, RgEvalContext, RowGroupBitsetSource, TreeBitsetSource,
    assert!(!prices.contains(&10_000));
///          Pred keeps 3/4 → cost 750, Coll cost 10_000 → subtree 10_750
        .flat_map(|p| std::iter::repeat(labels[p]).take(ROWS_PER_PAGE))
                    .map(|pp| (Arc::as_ptr(expr) as *const () as usize, pp))
    w.close().unwrap();
fn write_fixture() -> NamedTempFile {
///          inner_acc = {0..3071}
            BoolNode::And(vec![
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
// ── Expression helpers ──────────────────────────────────────────────
        predicate_columns: vec![],
    // Final page-level decision: pages 0 and 3 have candidates, pages 1 and 2 don't.
    // Pred(<1024):   1/4 pages kept → ceil(1000 * 1 / 4) = 250
        writer_generation: 0,
    let (seg, schema) = load_segment(&tmp);
            })
async fn single_collector_prunes_3_pages_all_strategies() {
    tmp
    let pred_ge_10k = binop(col_expr("price"), Operator::GtEq, lit_i32(10_000));
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
///      Now only pages 1+2 survive in the accumulator.
        _ => panic!("expected AND"),
    let pruner = PagePruner::new(&schema, seg.metadata, schema.clone());
    }
        .collect();
    // from the Coll(even) step that the refinement stage (on_batch_mask)
    let (prices, plan) = run_bitmap_tree(tree).await;
// ═════════════════════════════════════════════════════════════════════
        BoolNode::And(vec![
        prune_tree_config: None,
            get_counter(&m, "pages_pruned"),
        *p < 1024 || *p >= 30_000
    let (seg, schema) = load_segment(&tmp);
    Arc::new(Literal::new(ScalarValue::Int32(Some(v))))
    let p2: Vec<_> = prices
}
///      acc &= {0..3071} → {1024..3071}, ranges = [(1024,3072)]
}
}
//! |  1   | 1024–2047   | 10_000..11_024 | `"beta"`  |
        .collect();
/// Run a single-collector query with a given strategy, return (prices, plan).
            .iter()
//! |  2  | first 2 per page              | sparse (8 docs)      |
        5 => (1..NUM_ROWS as i32).step_by(2).collect(), // odd docs
                Some(collector_for_tag(collector_tag)),
async fn bitmap_tree_nested_collector_and_or_predicates() {
///
        pred_node(pred_ge_10k), // child 0
        pred_node(pred_lt_31k), // pages 0,1,2
///          - NOT(Coll(page3)) called with [(2048,3072)] → page3 collector
///
            BoolNode::And(vec![
        BoolNode::And(vec![collector_leaf(3), pred_node(pred_narrow)]), // branch_A
    BoolNode::Collector {
/// Execution order:
                pred_node(pred_ge_30k), // page 3
    let m = aggregate_metrics(&plan);
                Some(Arc::clone(&residual_expr)),
///
    let pred_ge_10k = binop(col_expr("price"), Operator::GtEq, lit_i32(10_000));
fn cost_ordering_predicates_sorted_by_selectivity() {
use datafusion::execution::context::SessionContext;
        _ => panic!("expected AND"),
fn wire_collectors_dfs(node: &BoolNode, out: &mut Vec<Arc<dyn RowGroupDocsCollector>>) {
        min_doc: 0,
    };
    // child 0: Pred(>=10k) keeps pages 1,2,3 (3/4) → ceil(1000*3/4) = 750
                strategy,
    let pp_map = build_pp_map(&tree, &schema);
            let base = (p as i32) * 10_000;
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
        max_doc: i32,
///
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(SingleCollectorEvaluator::new(
            (0..ROWS_PER_PAGE as i32).map(move |i| base + i)
        .into_iter()
///          Coll(odd) called with [(2048,3072)] → odd docs in page 2 only
///
}
    let branch_a = BoolNode::And(vec![collector_leaf(3), pred_node(pred_narrow.clone())]);
        .into_iter()
//! |  1  | 0, 2, 4, …                   | even docs            |
                    None,
async fn execute_and_collect(
///      root ranges tighten to [(0,1024)]
    let m = aggregate_metrics(&plan);
    expected_pruned: usize,
///   1. Pred(price >= 10000) → acc = {1024..4095}, ranges = [(1024,4096)]
    assert_eq!(get_counter(&m, "pages_pruned"), NUM_PAGES);
    let factory: EvaluatorFactory = {
///      inherited ranges = [(1024,3072)]
    ctx.register_table("t", provider).unwrap();
    execute_and_collect(seg, schema, factory).await
/// Build an RgEvalContext for the fixture's single RG.
    let page2_prices: Vec<i32> = prices
//! |  4  | 2048..4096                    | pages 2+3            |
///     ├─ AND─┬─ Pred(price >= 20000)                          keeps pages 2,3
            num_rows: n,
/// ```
        if plan.name() == "QueryShardExec" {
    assert!(prices.contains(&0));
         (A={}, B={})",
    let cost_b = subtree_cost(&children[1], &ctx, &pruner, &pp_map);
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
// ── Segment loader & metrics ────────────────────────────────────────
}
async fn bitmap_tree_or_predicate_keeps_two_pages() {
///     │     │      └─ Coll(even_docs)                       even doc IDs
        &self,
///      acc = {1024..4095}, ranges = [(1024,4096)]
#[test]
                &schema,
        }
//! # Mock collectors
use datafusion::physical_plan::metrics::MetricsSet;
///   3. OR evaluated with inherited ranges [(1024,3072)]:
fn load_segment(tmp: &NamedTempFile) -> (SegmentFileInfo, SchemaRef) {
    // Even docs in page 3: 512 rows.
        BoolNode::And(cs) | BoolNode::Or(cs) => cs.iter().for_each(|c| collect_pred_exprs(c, out)),
    // Pages 0 and 3 have no candidates → 2 pruned
    assert_eq!(get_counter(&m, "pages_pruned"), 2);
    // Page 0 has no candidates → 1 pruned
///          Result: 4 docs
    let tree = BoolNode::And(vec![
    )
    let m = aggregate_metrics(&plan);
    );
///   1025 is odd → already in page 1 even? No, 1025 is odd doc. But first2pp
        segments: vec![seg],
///          - Pred(price < 21024) → inner_acc = {0..3071}
    assert_eq!(get_counter(&m, "pages_pruned"), NUM_PAGES);
    let mut colls = Vec::new();
        .filter(|&&p| p >= 30_000 && p < 31_024)
        .map(|c| subtree_cost(c, &ctx, &pruner, &pp_map))
    schema: SchemaRef,
        .iter()
            collector_leaf(0), // all docs
        crate::indexed_table::bool_tree::ResolvedNode::And(c) => c,
///      Now only pages 1+2 survive.
    let pred_narrow = binop(col_expr("price"), Operator::Lt, lit_i32(1024)); // 1/4 pages
        annotation_id: tag as i32,
    l: Arc<dyn PhysicalExpr>,
    ]);
}
        cost_b
            if doc >= min_doc && doc < max_doc {
        pushdown_predicate: None,
use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
    set
        .filter(|&&p| p >= 20_000 && p < 21_024)
                page_prune_metrics: Some(
            BoolNode::And(vec![pred_node(pred_lt_11k), collector_leaf(1)]), // even, page 1
    // metrics is computed after the tree resolves — pages 0 and 3 are
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
use std::sync::Arc;
    assert_eq!(sorted_indices[1], 3, "second most selective pred second");
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    };
async fn run_single_collector(
}
    // Page 1: even docs (512) + doc 1025 from first2pp = 513
///   2. Pred(price < 31024)  → acc &= {0..3071} → {1024..3071}, ranges = [(1024,3072)]
                leaves: Arc::new(CollectorLeafBitmaps::new(sm.ffm_collector_calls.clone())),
        crate::indexed_table::bool_tree::ResolvedNode::And(c) => c,
///   branch_B: Pred keeps 3/4 → cost 750, Coll cost 10_000 → total 10_750
    }
    let page1_prices: Vec<i32> = prices
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        Arc::new(move |segment, _chunk, sm, _stats_prune_tree| {
}
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
///   4. root acc &= OR result → docs from pages 1+2 that are in the OR
        2 => (0..NUM_PAGES)
    // pruned (no candidates). Page 1 has residual even-doc candidates
        .build();
    let pp_map = build_pp_map(&tree, &schema);
    wire_collectors_dfs(&tree, &mut colls);
    wire_collectors_dfs(&tree, &mut colls);
///
        .collect();
async fn bitmap_tree_and_two_predicates_intersect() {
        .collect();
                pruning_predicates: Arc::clone(&pp_map),
                Some(crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(sm)),
// Execution order tests — assert selectivity-aware cost ordering
            BoolNode::And(vec![collector_leaf(2), pred_node(pred_lt_21k)]), // first2pp, pages 0,1,2
///   2. OR with 5 children, inherited ranges [(1024,4096)]:
//! 4096 rows, 1 RG, 4 pages of 1024 rows each.
    assert_eq!(prices.len(), 0);
    use datafusion::physical_plan::metrics::MetricType;
    run_all_strategies(1, residual, ROWS_PER_PAGE / 2, 3).await;
    let tmp = write_fixture();
const NUM_ROWS: usize = ROWS_PER_PAGE * NUM_PAGES; // 4096
        .copied()
    let expr = binop(col_expr("price"), Operator::Lt, lit_i32(1024));
        cancellation_token: None,
///          inner-inner AND:
                cost_collector: 10,
                sm.ffm_collector_calls.clone(),
    assert_eq!(costs[3], 10_000, "Coll(all)");
/// FullRange calls collector on full [0, 4096), TightenOuterBounds
    let store: Arc<dyn object_store::ObjectStore> =
///
                    out.push(Arc::clone(metric));
    tree: &BoolNode,
        for i in 0..b.num_rows() {
const ROWS_PER_PAGE: usize = 1024;
    };
///     └─ Pred(price >= 30000)      keeps 1/4 pages → cost = 250
                collector_leaf(5),
/// The two predicates with equal cost (250) are stable-sorted by original index.
/// AND─┬─ Pred(price >= 10000)                                keeps pages 1,2,3
    let df = ctx.sql("SELECT price, brand FROM t").await.unwrap();
    let pred_lt_31k = binop(col_expr("price"), Operator::Lt, lit_i32(31_024));
            strategy
fn aggregate_metrics(plan: &Arc<dyn ExecutionPlan>) -> MetricsSet {
        offset += n;
#![cfg(test)]
    let tree = tree.push_not_down();
    let branch_b = BoolNode::And(vec![collector_leaf(4), pred_node(pred_wide.clone())]);
fn col_expr(name: &str) -> Arc<dyn PhysicalExpr> {
        ]),
async fn single_collector_no_pruning_all_strategies() {
fn collect_pred_exprs(node: &BoolNode, out: &mut Vec<Arc<dyn PhysicalExpr>>) {
    // Pages 0, 3: excluded by predicate intersection
                pred_node(pred_ge_20k),
///            Pred(>=30k) keeps page 3 → cost 250, evaluated first
        BoolNode::Or(vec![
//!
///          ranges = intersect([(1024,4096)], [(2048,4096)]) = [(2048,4096)]
        cost_collector: 10,
use datafusion::arrow::array::{Int32Array, StringArray};
    let pred_narrow = binop(col_expr("price"), Operator::Lt, lit_i32(1024));
}
                stats_prune_tree: None,
    let residual_pp = build_pruning_predicate(&residual_expr, schema.clone());
        ],
//! |  6  | 3072..4096                    | page 3 only          |
///   2048,2049 — 2048 is even (not in odd set, but first2pp adds it), 2049 is odd (already in odd set).
    assert_eq!(get_counter(&m, "pages_pruned"), 2);
        BoolNode::DelegationPossible { .. } => {}
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
/// AND─┬─ branch_A: AND(Coll(pages0+1), Pred(price < 1024))
    let ctx = fixture_eval_ctx();
}
    let pred_wide = binop(col_expr("price"), Operator::Lt, lit_i32(21024)); // 3/4 pages
/// ```text
    // All 4 pages pruned in the final bitmap (empty candidates).
/// ```
    assert_eq!(sorted[2].1, 3, "Coll(all) third (cost {})", sorted[2].0);
///            ranges = intersect([(2048,3072)], [(3072,4096)]) = [] (empty!)
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = colls
        .into_iter()
    let tree = BoolNode::And(vec![
        .collect();
///      returns even docs in page 2 → 512 docs
            if let Some(m) = plan.metrics() {
    }
            strategy,
    assert!(prices.contains(&30_000));
//! |  5  | 1, 3, 5, …                   | odd docs             |
///          Result: empty
}
                out[rel / 64] |= 1u64 << (rel % 64);
                build_pruning_predicate(expr, schema.clone())
    let tree = tree.push_not_down();
        CollectorCallStrategy::PageRangeSplit,
        cost_a,
        .force_strategy(Some(FilterStrategy::BooleanMask))
}
///
    let pred_wide = binop(col_expr("price"), Operator::Lt, lit_i32(21024)); // keeps pages 0,1,2
    // Only page 2 survives, even docs only → 512 rows
///          inner_acc &= universe → unchanged {2048..3071}
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
///   branch_A: Pred keeps 1/4 → cost 250, Coll cost 10_000 → total 10_250
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = colls
    prices.sort();
/// Expected sort order by cost: [Pred(<1024), Pred(>=30000), Pred(<21024), Coll(all)]
/// Step-by-step:
}
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
///      OR unions: even docs from pages 1+2 ∪ odd docs from page 2
use futures::StreamExt;
    seg: SegmentFileInfo,
            ));
    Arc::new(
        ]),
}
/// The more selective predicate's branch wins, causing its tight range
use datafusion::physical_expr::PhysicalExpr;
        })
use crate::indexed_table::index::RowGroupDocsCollector;
) -> (Vec<i32>, Arc<dyn ExecutionPlan>) {
use crate::indexed_table::index::CollectDocsResult;
        BoolNode::And(cs) | BoolNode::Or(cs) => cs.iter().for_each(|c| wire_collectors_dfs(c, out)),
        datafusion::physical_plan::execute_stream(Arc::clone(&plan), task_ctx).unwrap();
///
    ] {
    let pred_ge_30k = binop(col_expr("price"), Operator::GtEq, lit_i32(30_000));
    assert_eq!(cost_b, 10_750, "branch_B: Coll + wide pred");
        }
        pred_node(pred_ge_10k), // pages 1,2,3
/// Selectivity-aware cost ordering:
    }
///   2. branch_A's Coll(pages0+1) called with ranges [(0,1024)] → returns docs in page 0
    for i in 0..parquet_meta.num_row_groups() {
    // Verify sort order: [250, 250, 750, 10_000]
    // Final page-level: pages 0 and 3 have candidates, pages 1 and 2 pruned.
    assert_eq!(prices.len(), ROWS_PER_PAGE);
    Arc::new(MockCollector { docs })
        );
//! | page | rows        | price range    | brand     |
            pred_node(pred_ge_20k), // pages 2,3
};
/// AND─┬─ Pred(price >= 10000)                                keeps pages 1,2,3
                Arc::clone(&segment.metadata),
///      OR unions all: 512 + 512 + 1024 + 0 + 4 = 2052 docs
        BoolNode::Predicate(e) => out.push(Arc::clone(e)),
        // page 3: price = 30000 + (doc_id - 3072), even doc → even offset
            walk(child, out);
///      inner ranges = intersect([(0,1024)], [(0,3072)]) = [(0,1024)]
    docs: Vec<i32>,
        .target_partitions(1)
        sort_min: None,
        .map(|(i, c)| (i as i32, c))
///          Pred(<21024) keeps pages 0,1,2 → cost lower, evaluated first
        _ => panic!("expected AND"),
        let (prices, plan) =
    assert_eq!(*prices.last().unwrap(), 1023);
///     └─ Coll(all)                                          cost 10_000
    }
/// ```
        Arc::new(object_store::local::LocalFileSystem::new());
            prices.len(),
    let right = binop(col_expr("price"), Operator::Lt, lit_i32(21_024));
                collector_leaf(5),
}
    }
        .iter()
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
}
///      → returns empty (pages2+3 collector has no docs in page 0)
// ── Mock collector ──────────────────────────────────────────────────
            BoolNode::Not(Box::new(BoolNode::And(vec![
    let (prices, plan) = run_bitmap_tree(tree).await;
    // even page 2 (512 rows). However, the candidate bitmap used for
    let mut set = MetricsSet::new();
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    strategy: CollectorCallStrategy,
///     │      └─ Coll(all)                                      all docs
            .filter_map(|expr| {
use crate::indexed_table::eval::bitmap_tree::{
    }
        .collect();
    assert_eq!(costs[1], 1000, "Pred(<31k): all pages kept (31023 < 31024)");
    // All 1024 rows from page 0 (prices 0..1024).
) {
// Single collector page pruning tests — all three CollectorCallStrategy
                None,
///   4. Coll(even): cost 10_000
                cost_predicate: 1,
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
            get_counter(&m, "pages_total"),
///     └─ Coll(all_docs)                                      all doc IDs
///
    let tmp = write_fixture();
                pred_node(pred_lt_21k), // pages 0,1,2
/// AND'd together → nothing survives. The key: branch_A's tight range [(0,1024)]
    let meta =
    let hi = binop(col_expr("price"), Operator::Lt, lit_i32(11_024));
/// Root AND execution (cost-sorted):
    assert_eq!(sorted_indices[3], 2, "collector last");
    let tree = tree.push_not_down();
///          Result: odd docs from page 2 (512 docs)
///      3a. Pred(price >= 20000): keeps pages 2,3 → cost 500 (2/4)
        let col = b.column(0).as_any().downcast_ref::<Int32Array>().unwrap();
//! # Fixture layout
///          - Pred(price >= 20000) → inner_acc = {2048..4095}
///     ├─ Coll(all)                 cost = 10 * 1000 = 10_000
// ═════════════════════════════════════════════════════════════════════
                ),
};
///          inner_acc = {2048..4095}
        ]),
        collector_leaf(1), // even docs
    let expr = binop(col_expr("price"), Operator::Lt, lit_i32(-1));
///   Total: 512 + 512 + 1024 + 2 = 2050
        sort_fields: vec![],
        parquet_size: size,
        .collect();
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = colls
///   1. branch_A's Pred(price < 1024) → bitmap {0..1023} (page 0 only)
    let tree = BoolNode::And(vec![collector_leaf(0), pred_node(expr)]);
/// Residual price >= 30_000 with even-docs collector → even docs from page 3.
            BoolNode::Not(Box::new(collector_leaf(0))),                     // NOT all = empty
///   with tightened range, then OR last (most expensive).
        "OR subtree ({}) should be more expensive than single Coll ({})",
    let tmp = write_fixture();
    ]);
    assert_eq!(page1_prices.len(), 512);
//!
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    let pred_ge_20k = binop(col_expr("price"), Operator::GtEq, lit_i32(20_000));
///          ← narrowed to page 2 only!
        .set_write_batch_size(ROWS_PER_PAGE)
        .iter()
        });
        let n = parquet_meta.row_group(i).num_rows();
// ── Fixture builder ─────────────────────────────────────────────────
    let pred_ge_20k = binop(col_expr("price"), Operator::GtEq, lit_i32(20_000));
/// Helper: run the same residual across all three strategies, assert identical results.
//! |  3   | 3072–4095   | 30_000..31_024 | `"delta"` |
use datafusion::parquet::arrow::ArrowWriter;
        0 => (0..NUM_ROWS as i32).collect(),
///      2c. AND(Coll(page3), Pred(price >= 30000)):
///      root acc = branch_A result (page 0 docs only)
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
/// tag 3 → pages 0+1 only (docs 0..2048), tag 4 → pages 2+3 only (docs 2048..4096),
    assert_eq!(*prices.first().unwrap(), 10_000);
        cost_predicate: 1,
                BoolNode::Not(Box::new(collector_leaf(6))), // NOT page3
) -> Arc<dyn PhysicalExpr> {
use datafusion::arrow::record_batch::RecordBatch;
    op: Operator,
///          Pred(<21024) keeps pages 0,1,2 → inner_acc &= {0..3071} → {2048..3071}
use crate::indexed_table::table_provider::{
        collector_leaf(0),
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = colls
        CollectorCallStrategy::PageRangeSplit,
                Arc::clone(&segment.metadata),
    let size = std::fs::metadata(&path).unwrap().len();
    walk(plan, &mut set);
/// Result: 0 rows. The two collectors have disjoint doc sets (pages 0+1 vs 2+3)
///     │      ├─ NOT── AND─┬─ Coll(page3)                      page 3 docs
    let resolved = tree.resolve(&per_leaf).unwrap();
    let residual = binop(col_expr("price"), Operator::Lt, lit_i32(1024));
// ── Tree wiring ─────────────────────────────────────────────────────
///          ranges = intersect([(1024,4096)], [(3072,4096)]) = [(3072,4096)]
    // All prices should be in page 2 range
    // Coll(even) is evaluated before the inner AND (lower cost: 10_000 vs
            ));
///          NOT(empty) = universe {0..4095}
///   = page 1 even (512) + page 2 odd (512) + page 3 (1024) + {1025,2048} extra
                residual_pp.clone(),
                for metric in m.iter() {
fn build_pp_map(
// Complex tree tests — selectivity-aware ordering & range propagation
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
///       doc 2049 overlaps with odd page 2. Union deduplicates.)
        BoolNode::Predicate(_) => {}
/// ```text
}
}
            ]))),
                schema.clone(),
    assert_eq!(prices.len(), 2 * ROWS_PER_PAGE);
 * this file be licensed under the Apache-2.0 license or a
///      root acc &= even → even docs in page 2
//! Price ranges are non-overlapping so predicates like `price < 1024`
                let rel = (doc - min_doc) as usize;
/// ```text
// ═════════════════════════════════════════════════════════════════════
fn lit_i32(v: i32) -> Arc<dyn PhysicalExpr> {
///            ranges = intersect([(1024,3072)], [(0,3072)]) = [(1024,3072)]
    // pruning was skipped entirely).
    let task_ctx = ctx.task_ctx();
            first_row: offset,
//! |  2   | 2048–3071   | 20_000..21_024 | `"gamma"` |
    assert_eq!(prices.len(), 512 + 1024);
    collect_pred_exprs(tree, &mut exprs);
            Ok(eval)
///          Coll(even) called with [(1024,2048)] → even docs in page 1
        pred_node(pred_lt_31k), // child 1
                vec![base, base + 1]
    let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), schema, Some(props)).unwrap();
        .flat_map(|p| {
    assert_eq!(costs[2], 10_000, "Coll(all) should cost 10_000");
        .filter(|&&p| p >= 20_000 && p < 21_024)
//!
        "branch with more selective predicate should be cheaper \
/// Residual price < 1024 with all-docs collector → page 0 only, 3 pruned.
///
    let tree = BoolNode::And(vec![collector_leaf(0), pred_node(left), pred_node(right)]);
            let pruner = Arc::new(PagePruner::new(
        max_doc: NUM_ROWS as i32,
        assert_eq!(
///      ranges tighten further
    .unwrap();
            ]),
///   3. inner AND (Pred + NOT(AND) + Coll): cost = 250 + 10_000 + 10_000 = 20_250
        BoolNode::DelegationPossible { .. } => {}
    let labels = ["alpha", "beta", "gamma", "delta"];
async fn bitmap_tree_and_predicate_prunes_3_pages() {
///      2e. AND(Coll(first2pp), Pred(price < 21024)):
    );
// ── Execution harnesses ─────────────────────────────────────────────
use crate::indexed_table::eval::{
    let p1: Vec<_> = prices
    let pred_ge_20k = binop(col_expr("price"), Operator::GtEq, lit_i32(20_000));
        let b = batch.unwrap();
            expected_len,
/// to propagate to branch_B's collector.
/// Final: even page 1 ∪ odd page 2 ∪ all page 3 ∪ {1024,1025,2048,2049}
    let batch = RecordBatch::try_new(
                std::sync::Arc::new(std::collections::HashMap::new()),
///
            prices.len()
///
        sort_orders: vec![],
        let schema = schema.clone();
        max_doc: NUM_ROWS as i64,
                collector_strategy:
///
///
fn cost_ordering_complex_tree_predicates_before_or_before_nothing() {
use std::collections::HashMap;
/// AND(Collector(even), OR(Predicate(price < 1024), Predicate(price >= 30_000)))
        pred_node(pred_ge_10k), // pages 1,2,3
    let cost_a = subtree_cost(&children[0], &ctx, &pruner, &pp_map);
    // will filter out, but the candidate-stage bitmap still has them.
    let residual = binop(lo, Operator::And, hi);
///
async fn single_collector_all_pruned_all_strategies() {
    assert_eq!(sorted_indices[2], 1, "wide pred third");
        .enumerate()
                BoolNode::Not(Box::new(collector_leaf(6))),
    let pred_ge_10k = binop(col_expr("price"), Operator::GtEq, lit_i32(10_000));
    let pred_wide = binop(col_expr("price"), Operator::Lt, lit_i32(21024));
        CollectorCallStrategy::TightenOuterBounds,
///            ← tightened to page 2 only!
use datafusion::common::ScalarValue;
    ]);
    assert_eq!(get_counter(&m, "pages_pruned"), 2);
        .map(|v| v.as_usize())
fn binop(
 *
    assert_eq!(get_counter(&m, "pages_pruned"), 2);
    // Page 2 (20000..21023): even ∪ odd = all → 1024 rows
///     ├─ OR─┬─ AND─┬─ Pred(price < 21024)                  keeps pages 0,1,2
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    // Count by page:
    wire_collectors_dfs(&tree, &mut colls);
///          Pred(>=30k) keeps page 3 → cost lower, evaluated first
        or_cost,
    let file = std::fs::File::open(&path).unwrap();
    let ctx = fixture_eval_ctx();
    assert!(prices.iter().all(|&p| (p - 20_000) % 2 == 0));
    let tree = BoolNode::And(vec![
    let p0: Vec<_> = prices.iter().filter(|&&p| p < 1_024).collect();
///
//! |------|-------------|----------------|-----------|
///      3c. Coll(all) called with [(2048,3072)] → all docs in page 2
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
    let tree = BoolNode::And(vec![
                tree: Arc::new(resolved),
                segment.writer_generation,
/// tag 5 → odd docs only, tag 6 → page 3 only (docs 3072..4096).
async fn bitmap_tree_all_pages_pruned() {
) -> Arc<HashMap<usize, Arc<datafusion::physical_optimizer::pruning::PruningPredicate>>> {
///           ├─ NOT(Coll(all))                                 complement of all = empty
async fn single_collector_even_docs_page3_all_strategies() {
    sorted.sort_by_key(|&(cost, idx)| (cost, idx));
            run_single_collector(collector_tag, Arc::clone(&residual), strategy).await;
}
    assert_eq!(costs[3], 250, "Pred(>=30000) should cost 250");
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        .map(|(i, c)| (i as i32, c))
    // Indices 0 and 3 (cost 250) come first, then 1 (750), then 2 (10_000).
    }
    ]);
            prices.push(col.value(i));
fn collector_for_tag(tag: u8) -> Arc<dyn RowGroupDocsCollector> {
use datafusion::logical_expr::Operator;
    let pp_map = build_pp_map(&tree, &schema);
async fn complex_selectivity_ordering_tighter_branch_first() {
        let schema = schema.clone();
        BoolNode::Or(vec![
//! |  3  | 0..2048                       | pages 0+1            |
        BoolNode::Not(c) => collect_pred_exprs(c, out),
        Arc::new(move |segment, _chunk, sm, _stats_prune_tree| {
    r: Arc<dyn PhysicalExpr>,
    factory: EvaluatorFactory,
        4 => (2048..NUM_ROWS as i32).collect(),         // pages 2+3
    let (seg, schema) = load_segment(&tmp);
        collector_leaf(0), // child 3
    // branch_B: Coll(10_000) + Pred(3/4 = 750) = 10_750
///      root acc &= empty → empty
    let tree = BoolNode::And(vec![branch_a, branch_b]);
        rgs.push(RowGroupInfo {
//! |  0  | all 4096                      | all docs             |
    };
        .collect();
    // Final page-level: pages 1 and 2 have candidates, pages 0 and 3 don't.
}
            NUM_PAGES,
        .collect();
//!
            }
                    std::collections::HashMap::new(),
            ));
        })
    let mut offset = 0i64;
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
///          Pred keeps page 0,1 → inner_acc = {0..2047}
}
        pred_node(pred_ge_10k),
    let mut prices = Vec::new();
    // Verify page 1 prices are all even-indexed (even doc IDs → even prices in page 1)
            ]),
///     │            └─ NOT── Coll(page3_only)                 excludes page 3 docs
///          Result: page 3 docs (1024 docs)
    let right = binop(col_expr("price"), Operator::GtEq, lit_i32(30_000));
///          - Coll(even) called with [(1024,3072)] → even docs in pages 1+2
    let idx = fixture_schema().index_of(name).unwrap();
    (prices, plan)
    let (prices, plan) = run_bitmap_tree(tree).await;
    let m = aggregate_metrics(&plan);
        evaluator_factory: factory,
///
///
    assert!(
        schema.clone(),
/// Execution order at root AND (cost-sorted):
        .enumerate()
///
    assert_eq!(sorted[0].1, 0, "Pred(>=10k) first (cost {})", sorted[0].0);
    let m = aggregate_metrics(&plan);
/// Final result: all docs from pages 1+2 (even from pages 1+2, odd from page 2,
///          Coll(all) called with [(1024,4096)] → all docs in pages 1,2,3
///      3a. inner AND₁ (Pred + Coll(even)):
        let per_leaf = per_leaf.clone();
                pred_node(pred_lt_21k.clone()),
// Bitmap tree (multi-filter) page pruning tests
                0,
    match node {
///   → branch_A evaluated first (more selective predicate)
    assert_eq!(costs[0], 750, "Pred(>=10k): 3/4 pages");
///
            });
/// AND─┬─ branch_A: AND(Coll(pages0+1), Pred(price < 1024))    ← Pred keeps 1/4 pages
// ═════════════════════════════════════════════════════════════════════
                collector_leaf(6),      // page3 collector
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
    while let Some(batch) = stream.next().await {
///     └─ branch_B: AND(Coll(pages2+3), Pred(price < 21024))
}
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    // Verify all of page 2 is present
            expected_len,
        .collect();
///          - Coll(odd) called with [(2048,3072)] → odd docs in page 2 only
/// unioned = all of page 2 + even of page 1). Total = 1024 (page 2) + 512 (even page 1) = 1536.
}
///          Result: even docs from page 1 (512 docs)
fn get_counter(set: &MetricsSet, name: &str) -> usize {
    }));
///      Sorted by cost — predicates are cheap, collectors expensive.
    assert_eq!(p3.len(), 1024);
    let m = aggregate_metrics(&plan);
    let tree = tree.push_not_down();
///          ranges = intersect([(1024,4096)], [(0,2048)]) = [(1024,2048)]
}
            index: i,
    BoolNode::Predicate(expr)
///      root acc &= all_docs (no-op since all_docs is everything)
            .collect(),
/// ```text
    let costs: Vec<u32> = children
    let tree = BoolNode::And(vec![
        .map(|c| subtree_cost(c, &ctx, &pruner, &pp_map))
    fn collect_packed_u64_bitset(
    let pred_lt_21k = binop(col_expr("price"), Operator::Lt, lit_i32(21_024));
#[test]
///   adds 1024,1025 — 1024 is even (already in even set), 1025 is new.
///     │     └─ AND─┬─ Pred(price >= 20000)                  keeps pages 2,3
    assert_eq!(costs[1], 750, "Pred(<21024) should cost 750");
        assert_eq!(prices.len(), NUM_ROWS, "strategy {:?}", strategy);
    assert_eq!(costs[0], 250, "Pred(<1024) should cost 250");
    let residual = binop(col_expr("price"), Operator::GtEq, lit_i32(30_000));
}
        .enumerate()
fn fixture_eval_ctx() -> RgEvalContext {
/// ```
        3 => (0..2048).collect(),                       // pages 0+1
        .indexed_pushdown_filters(false)
///
///     │      │            └─ Pred(price >= 30000)              keeps page 3
///     ├─ Pred(price < 31024)                                4/4 pages → cost 1000
    let pp_map = build_pp_map(&tree, &schema);
            expected_pruned,
        Ok(out.into())
    collector_tag: u8,
        let residual_expr = Arc::clone(&residual_expr);
    let mut stream =
use crate::indexed_table::eval::single_collector::SingleCollectorEvaluator;
        rg_idx: 0,
    let (prices, plan) = run_bitmap_tree(tree).await;
    // Page 0: excluded by root Pred(>= 10000)
///     └─ branch_B: AND(Coll(pages2+3), Pred(price < 21024))   ← Pred keeps 3/4 pages
/// ```text
    let mut rgs = Vec::new();
    ]))
/*
                let base = (p * ROWS_PER_PAGE) as i32;
    Arc::new(PhysColumn::new(name, idx))
    let resolved = tree.resolve(&per_leaf).unwrap();
    // Verify execution order: Pred(>=10k) first, Pred(<31k) second, Coll third, OR last
    let children = match &resolved {
//!
///   5. Coll(all_docs) called with tightened ranges → only scans pages 1+2
                evaluator: Arc::new(BitmapTreeEvaluator),
///          ranges = intersect([(1024,4096)], [(0,3072)]) = [(1024,3072)]
        .unwrap_or(0)
/// Residual that matches everything → no pages pruned.
///      3b. NOT(AND(Coll(page3), Pred(price >= 30000))):
    assert!(prices.iter().all(|p| {
async fn single_collector_page1_only() {
        BoolNode::And(vec![collector_leaf(4), pred_node(pred_wide)]),   // branch_B
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    wire_collectors_dfs(&tree, &mut colls);
/// AND(Predicate(price >= 10_000), Predicate(price < 21_024)) → pages 1 and 2.
    let tmp = NamedTempFile::new().unwrap();
///
///     │     └─ AND(Pred(price >= 20000), Coll(odd), NOT(Coll(page3)))
    let mut colls = Vec::new();
            Arc::new(Int32Array::from(prices)),
    let seg = SegmentFileInfo {
 */
    // ~20_750), so the root accumulator after Coll(even) has even docs in
    ]);
    for strategy in [
        collector_strategy: CollectorCallStrategy::TightenOuterBounds,
    for strategy in [
        // page 0: price == doc_id, even doc → even price
    assert_eq!(prices.len(), 2 * ROWS_PER_PAGE);
//! | tag | docs                          | description          |
///   1. Pred(price >= 10000) → acc = {1024..4095}, ranges = [(1024,4096)]
    (seg, schema)
    let left = binop(col_expr("price"), Operator::Lt, lit_i32(1024));
    fn walk(plan: &Arc<dyn ExecutionPlan>, out: &mut MetricsSet) {
        }
            "strategy {:?}: pages_total",
    let factory: EvaluatorFactory = {
    run_all_strategies(0, residual, ROWS_PER_PAGE, 3).await;
    let pred_lt_11k = binop(col_expr("price"), Operator::Lt, lit_i32(11_024));
    let m = aggregate_metrics(&plan);
        collector_leaf(0),               // child 2
async fn complex_deep_nesting_range_propagation_4_levels() {
    let costs: Vec<u32> = children
/// AND─┬─ Pred(price >= 10000)                              keeps pages 1,2,3
        BoolNode::Collector { annotation_id } => out.push(collector_for_tag(*annotation_id as u8)),
        assert_eq!(
    let pred_lt_21k = binop(col_expr("price"), Operator::Lt, lit_i32(21_024));
    let pred_ge_30k = binop(col_expr("price"), Operator::GtEq, lit_i32(30_000));
//! deterministically prune to page 0 only.
//!
    execute_and_collect(seg, schema, factory).await
                &schema,
    // All returned prices should be even (from even doc IDs).
        rg_first_row: 0,
#[test]
///          Pred(>=20k) keeps pages 2,3 → inner_acc = {2048..4095}
async fn run_all_strategies(
    };
        for child in plan.children() {
    let p3 = binop(col_expr("price"), Operator::GtEq, lit_i32(30_000));
    // child 1: Pred(<31k)  keeps ALL pages (max of page 3 = 31023 < 31024) → 1000
//! |-----|-------------------------------|----------------------|
        object_path: object_store::path::Path::from(path.to_string_lossy().as_ref()),
        collector_call_ranges: None,
    let tree = Arc::new(tree);
/// ```text
        .iter()
///   OR subtree:           sum of children costs
    assert!(page1_prices.iter().all(|p| (p - 10_000) % 2 == 0));
    let p0 = binop(col_expr("price"), Operator::Lt, lit_i32(1024));
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
///     │            ├─ Coll(odd_docs)                         odd doc IDs
    // Page 2: odd docs (512) + doc 2048 from first2pp = 513
use crate::indexed_table::stream::{FilterStrategy, RowGroupInfo};
///   Pred(price < 31024):  keeps 3/4 → cost 750
/// Nested AND of two predicates intersects page ranges.
fn cost_ordering_nested_and_branches_selective_first() {
///            returns empty in this range, NOT inverts to universe,
    let (seg, schema) = load_segment(&tmp);
    let (seg, schema) = load_segment(&tmp);
    let pred_ge_10k = binop(col_expr("price"), Operator::GtEq, lit_i32(10_000));
                pruner,
    Arc::new(BinaryExpr::new(l, op, r))
///   Pred(price >= 10000): keeps 3/4 → cost 750
///     └─ Coll(even)                                            even docs
fn collector_leaf(tag: u8) -> BoolNode {
        let tree = Arc::clone(&tree);
///      3b. inner AND₂ (Pred + Coll(odd) + NOT(Coll(page3))):
        query_config: Arc::new(qc),
    let or_cost = costs[2];
        CollectorCallStrategy::FullRange,
        let span = (max_doc - min_doc) as usize;
        pred_node(pred_lt_31k), // pages 0,1,2
    assert_eq!(cost_a, 10_250, "branch_A: Coll + narrow pred");
                std::sync::Arc::new(crate::indexed_table::eval::single_collector::FfmDelegatedBackendCollectorFactory),
        BoolNode::Or(vec![pred_node(left), pred_node(right)]),
        .collect();
        );
    let children = match &resolved {
///
    assert_eq!(p2.len(), 513);
///   Coll(all_docs):       cost 10_000
    let pred_lt_31k = binop(col_expr("price"), Operator::Lt, lit_i32(31_024));
    let tmp = write_fixture();
    assert_eq!(prices.len(), 513 + 513 + 1024);
    assert_eq!(prices.len(), ROWS_PER_PAGE);
    assert!(
    let mut sorted_indices: Vec<usize> = (0..4).collect();
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    RgEvalContext {
///          ranges = intersect([(2048,4096)], [(2048,3072)]) = [(2048,3072)]
///      2d. NOT(Coll(all)):
}
    let resolved = tree.resolve(&per_leaf).unwrap();
    ] {
    // Pred(>=30000): 1/4 pages kept → ceil(1000 * 1 / 4) = 250
        .collect();
    let props = WriterProperties::builder()
///          ranges = intersect([(1024,3072)], [(2048,4096)]) = [(2048,3072)]
/// ```text
    let tmp = write_fixture();
        .build();
        store,
}
    assert_eq!(p1.len(), 513);
        or_cost > costs[3],
/// narrows to surviving page range, PageRangeSplit calls per-range.
        CollectorCallStrategy::FullRange,
async fn complex_cascading_and_with_not_at_depth() {
    ]);
///            Coll(page3) called with [] → no FFM call needed, returns empty
///
    // pages 1+2. The inner AND then narrows to page 2. Final bitmap =
        pred_node(pred_narrow.clone()),  // child 0
    assert_eq!(*prices.first().unwrap(), 0);
        costs[3]
///      (some overlap: first2pp docs 1024,1025 overlap with even page 1;
    // Disjoint collectors AND'd → empty result.
        .iter()
///     ├─ Pred(price < 31024)                                  keeps pages 0,1,2
        let mut out = vec![0u64; span.div_ceil(64)];
        _ => vec![],
/// Final: 512 even docs from page 2.
}
                max_collector_parallelism: 1,
}
            ]),
    assert_eq!(prices.len(), 0);
///     │          subtree cost = 500 + 10_000 + 10_000 = 20_500
    }
///            inner_inner_acc = {3072..4095}
/// tag 0 → all docs, tag 1 → even docs only, tag 2 → first 2 per page,
    let (prices, plan) = run_bitmap_tree(tree).await;
        .set_max_row_group_size(NUM_ROWS)
/// OR(Predicate(price < 1024), Predicate(price >= 30_000)) → pages 0 and 3.
    // Coll(all):     10 * 1000 = 10_000
///     ├─ OR─┬─ AND(Pred(price < 21024), Coll(even))        subtree cost = 750 + 10_000 = 10_750
    let docs: Vec<i32> = match tag {
fn fixture_schema() -> SchemaRef {
/// branch_A (10_250) < branch_B (10_750) → branch_A evaluated first.
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
///           ├─ AND(Coll(page3), Pred(price >= 30000))         page 3, page3 collector
    assert_eq!(sorted[1].1, 1, "Pred(<31k) second (cost {})", sorted[1].0);
    let ctx = fixture_eval_ctx();
///          Coll(page3) called with [(3072,4096)] → all page 3 docs
/// AND─┬─ Pred(price < 1024)       keeps 1/4 pages → cost = ceil(1000*1/4) = 250
                page_pruner: pruner,
        .map(|(i, c)| (i as i32, c))
    let mut exprs = Vec::new();
        6 => (3072..NUM_ROWS as i32).collect(),         // page 3 only
use datafusion::physical_plan::ExecutionPlan;
    // branch_A: Coll(10_000) + Pred(1/4 = 250) = 10_250
        schema: schema.clone(),
///
    let ctx = SessionContext::new();
    assert_eq!(get_counter(&m, "pages_pruned"), 2);
 * SPDX-License-Identifier: Apache-2.0
        .enumerate()
                pred_node(pred_ge_20k),                     // pages 2,3
    // build_pruning_predicate returns None for always-true → no pruning.
        ]),
    ]);
///          inner_acc = {3072..4095}
            })
    residual_expr: Arc<dyn PhysicalExpr>,
    let residual = binop(col_expr("price"), Operator::GtEq, lit_i32(0));
        .iter()
///   3. branch_B's Pred(price < 21024) → bitmap {0..3071}
    let residual = binop(col_expr("price"), Operator::Gt, lit_i32(999_999));
    let tree = BoolNode::And(vec![
            strategy
///
    let (prices, plan) = run_bitmap_tree(tree).await;
        for &doc in &self.docs {
    }
/// ```
        min_doc: i32,
}
    run_all_strategies(0, residual, ROWS_PER_PAGE, 3).await;
struct MockCollector {
        metadata: parquet_meta,
        BoolNode::Or(vec![pred_node(p0), pred_node(p3)]),
            // child 2
    let pred_ge_20k = binop(col_expr("price"), Operator::GtEq, lit_i32(20_000));
///          NOT inverts → empty (universe - all = nothing)
        }
            .collect(),
}
        let residual_pp = residual_pp.clone();
/// propagated to branch_B, so Coll(pages2+3) only scanned 1024 docs instead of 3072.
        CollectorCallStrategy::TightenOuterBounds,
fn pred_node(expr: Arc<dyn PhysicalExpr>) -> BoolNode {
/// 2 of 4 pages pruned.
    let m = aggregate_metrics(&plan);
    let lo = binop(col_expr("price"), Operator::GtEq, lit_i32(10_000));
    assert!(prices.iter().all(|&p| p >= 20_000 && p < 21_024));
    // Extract children of the root AND.
    let mut colls = Vec::new();
            }
    w.write(&batch).unwrap();
        .set_data_page_row_count_limit(ROWS_PER_PAGE)
        .map(|(i, c)| (i as i32, c))
}
    assert_eq!(get_counter(&m, "pages_pruned"), 3);
///     │    (page 3 max=31023 < 31024, so all pages kept)
/// ```
// ═════════════════════════════════════════════════════════════════════
// ═════════════════════════════════════════════════════════════════════
/// Collector intersected with OR of two page ranges → even docs from pages 0,3.
            let resolved = tree.resolve(&per_leaf)?;
    schema: &SchemaRef,
}
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
///
                }
///      2b. AND(Pred(price >= 20000), Pred(price < 21024), Coll(odd)):
///     └─ OR─┬─ AND(Pred(price < 11024), Coll(even))          pages 1 only, even docs
                pred_node(pred_ge_20k),
    let pred_lt_21k = binop(col_expr("price"), Operator::Lt, lit_i32(21_024));
    let p3: Vec<_> = prices
//! Deterministic page-pruning e2e tests.
    )
        crate::indexed_table::bool_tree::ResolvedNode::And(c) => c,
        rg_num_rows: NUM_ROWS as i64,
///          inner_acc &= all → {2048..3071}
    assert_eq!(p0.len(), 0);
use crate::indexed_table::page_pruner::{build_pruning_predicate, PagePruner};
    let brands: Vec<&str> = (0..NUM_PAGES)
        .filter(|&&p| p >= 10_000 && p < 11_024)
///   4. branch_B's Coll(pages2+3) called with ranges [(0,1024)]
use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(sm),
        vec![
        let (prices, _plan) = run_single_collector(0, Arc::clone(&residual), strategy).await;
    let mut colls = Vec::new();
            ]), // odd, page 2
///           └─ AND(Coll(first2pp), Pred(price < 21024))       first 2 per page, pages 0,1,2
    // Page 3: all 1024 docs from page3 collector
            let pruner = Arc::new(PagePruner::new(
/// Residual that matches nothing → all pages pruned, zero rows.
    // Even docs from pages 0 and 3: 512 + 512 = 1024.
// ═════════════════════════════════════════════════════════════════════
    ) -> Result<CollectDocsResult, String> {
