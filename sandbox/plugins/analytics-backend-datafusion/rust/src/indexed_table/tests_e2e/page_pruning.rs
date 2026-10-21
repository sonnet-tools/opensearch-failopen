    let branch_b = BoolNode::And(vec![collector_leaf(4), pred_node(pred_wide.clone())]);
        object_path: object_store::path::Path::from(path.to_string_lossy().as_ref()),
    let m = aggregate_metrics(&plan);
        .collect();
            Arc::new(StringArray::from(brands)),
        let schema = schema.clone();
    let pred_ge_20k = binop(col_expr("price"), Operator::GtEq, lit_i32(20_000));
            pred_node(pred_ge_20k), // pages 2,3
    assert!(page1_prices.iter().all(|p| (p - 10_000) % 2 == 0));
///          inner_acc &= all → {2048..3071}
            let resolved = tree.resolve(&per_leaf)?;
    // Extract children of the root AND.
///
    let mut sorted: Vec<(u32, usize)> = costs.iter().copied().zip(0..).collect();
///          - NOT(Coll(page3)) called with [(2048,3072)] → page3 collector
            .collect(),
        CollectorCallStrategy::PageRangeSplit,
/// Run a BoolNode tree through the bitmap-tree evaluator, return (prices, plan).
///     ├─ Pred(price < 31024)                                  keeps pages 0,1,2
    let tree = Arc::new(tree);
///          Pred(<21024) keeps pages 0,1,2 → cost lower, evaluated first
    // Disjoint collectors AND'd → empty result.
        min_doc: 0,
        BoolNode::And(vec![collector_leaf(4), pred_node(pred_wide)]),   // branch_B
        .collect();
///
    let tmp = write_fixture();
use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
        query_config: Arc::new(qc),
    let (prices, plan) = run_bitmap_tree(tree).await;
        );
    let tree = BoolNode::And(vec![
        pred_node(pred_lt_31k), // pages 0,1,2
///      root acc &= empty → empty
                schema.clone(),
    assert_eq!(prices.len(), 0);
    assert!(prices.contains(&0));
    Arc::new(Schema::new(vec![
#[test]
    // child 1: Pred(<31k)  keeps ALL pages (max of page 3 = 31023 < 31024) → 1000
struct MockCollector {
    ]);
///
        BoolNode::Or(vec![
    // Verify page 1 prices are all even-indexed (even doc IDs → even prices in page 1)
/// Root AND sort order: [Pred(750), Pred(1000), Coll(10_000), OR(31_250)]
///     │      └─ Coll(all)                                      all docs
        rgs.push(RowGroupInfo {
                Some(Arc::clone(&residual_expr)),
}
        "OR subtree ({}) should be more expensive than single Coll ({})",
    let mut set = MetricsSet::new();
    assert_eq!(sorted[0].1, 0, "Pred(>=10k) first (cost {})", sorted[0].0);
    // Resolve tree to get ResolvedNodes.
    let tree = BoolNode::And(vec![collector_leaf(0), pred_node(expr)]);
//! |  2  | first 2 per page              | sparse (8 docs)      |
    assert_eq!(*prices.first().unwrap(), 0);
///
    let docs: Vec<i32> = match tag {
}
}
        store_url,
 */
                collector_leaf(5),
///
        CollectorCallStrategy::PageRangeSplit,
}
/// Predicate that matches nothing → all 4 pages pruned, zero rows.
    let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), schema, Some(props)).unwrap();
async fn complex_selectivity_ordering_tighter_branch_first() {
    ] {
///     │            └─ NOT── Coll(page3_only)                 excludes page 3 docs
///   2. branch_A's Coll(pages0+1) called with ranges [(0,1024)] → returns docs in page 0
        or_cost > costs[3],
    let ctx = fixture_eval_ctx();
///
    }
    let m = aggregate_metrics(&plan);
        Ok(out.into())
///
///     └─ Pred(price >= 30000)      keeps 1/4 pages → cost = 250
            prices.len(),
}
}
///
///          NOT(empty) = universe {0..4095}
                pred_node(pred_lt_21k.clone()),
//! |  1   | 1024–2047   | 10_000..11_024 | `"beta"`  |
    );
        emit_row_ids: false,
    docs: Vec<i32>,
const NUM_PAGES: usize = 4;
// Complex tree tests — selectivity-aware ordering & range propagation
            Ok(eval)
/// propagated to branch_B, so Coll(pages2+3) only scanned 1024 docs instead of 3072.
/// AND(Collector(even), OR(Predicate(price < 1024), Predicate(price >= 30_000)))
}
            "strategy {:?}: pages_total",
    let pred_ge_20k = binop(col_expr("price"), Operator::GtEq, lit_i32(20_000));
        .collect();
    let tree = tree.push_not_down();
///          Coll(all) called with [(1024,4096)] → all docs in pages 1,2,3
fn wire_collectors_dfs(node: &BoolNode, out: &mut Vec<Arc<dyn RowGroupDocsCollector>>) {
///            Pred(>=30k) keeps page 3 → cost 250, evaluated first
    let pruner = PagePruner::new(&schema, seg.metadata, schema.clone());
        .collect();
    expected_pruned: usize,
    assert_eq!(get_counter(&m, "pages_pruned"), 2);
    // All 4096 rows returned, 0 pruned (pages_total may be 0 since
                pred_node(pred_ge_20k),
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
///            ranges = intersect([(1024,3072)], [(2048,4096)]) = [(2048,3072)]
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
///
//! # Mock collectors
/// Result: 0 rows. The two collectors have disjoint doc sets (pages 0+1 vs 2+3)
    let (prices, plan) = run_bitmap_tree(tree).await;
    };
//! |  1  | 0, 2, 4, …                   | even docs            |
    );
        }
    let pred_wide = binop(col_expr("price"), Operator::Lt, lit_i32(21024)); // keeps pages 0,1,2
            BoolNode::Not(Box::new(BoolNode::And(vec![
        5 => (1..NUM_ROWS as i32).step_by(2).collect(), // odd docs
    let tree = BoolNode::And(vec![collector_leaf(0), pred_node(expr)]);
/// Execution order at root AND (cost-sorted):
        schema.clone(),
        }
//! deterministically prune to page 0 only.
    let tmp = write_fixture();
    strategy: CollectorCallStrategy,
    // from the Coll(even) step that the refinement stage (on_batch_mask)
        collector_leaf(1), // even docs
///          ranges = intersect([(1024,4096)], [(0,2048)]) = [(1024,2048)]
        collector_strategy: CollectorCallStrategy::TightenOuterBounds,
    let pp_map = build_pp_map(&tree, &schema);
    // Even docs from pages 0 and 3: 512 + 512 = 1024.
#[derive(Debug)]
//!
                segment.writer_generation,
    // build_pruning_predicate returns None for always-true → no pruning.
}
    let cost_a = subtree_cost(&children[0], &ctx, &pruner, &pp_map);
    let left = binop(col_expr("price"), Operator::Lt, lit_i32(1024));
/// Build an RgEvalContext for the fixture's single RG.
    op: Operator,
    assert_eq!(page2_prices.len(), 1024);
    // Coll(even) is evaluated before the inner AND (lower cost: 10_000 vs
//! |  0  | all 4096                      | all docs             |
}
use datafusion::physical_plan::ExecutionPlan;
        .collect();
    let props = WriterProperties::builder()
///      (some overlap: first2pp docs 1024,1025 overlap with even page 1;
        .enumerate()
    schema: SchemaRef,
    let tree = BoolNode::And(vec![
    tmp
        parquet_size: size,
    };
        .iter()
        CollectorCallStrategy::TightenOuterBounds,
    for i in 0..parquet_meta.num_row_groups() {
        .enumerate()
                pruner,
    let ctx = fixture_eval_ctx();
    let or_cost = costs[2];
    match node {
///          Result: 4 docs
///   branch_B: Pred keeps 3/4 → cost 750, Coll cost 10_000 → total 10_750
        sort_fields: vec![],
///
//! |  2   | 2048–3071   | 20_000..21_024 | `"gamma"` |
            prices.push(col.value(i));
    }
use crate::indexed_table::stream::{FilterStrategy, RowGroupInfo};
        Arc::new(move |segment, _chunk, sm, _stats_prune_tree| {
        ]),
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = colls
    assert_eq!(get_counter(&m, "pages_pruned"), 1);
        })
};
    assert_eq!(p0.len(), 0);
}
///   1. Pred(price >= 10000): cost 750 (3/4 pages)
                Some(collector_for_tag(collector_tag)),
        let schema = schema.clone();
/// Final: 512 even docs from page 2.
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
    let tree = BoolNode::And(vec![
            strategy
    let tree = BoolNode::And(vec![
/// AND─┬─ branch_A: AND(Coll(pages0+1), Pred(price < 1024))    ← Pred keeps 1/4 pages
    ]);
            collector_leaf(0), // all docs
        .iter()
        Arc::new(object_store::local::LocalFileSystem::new());
        BoolNode::And(cs) | BoolNode::Or(cs) => cs.iter().for_each(|c| collect_pred_exprs(c, out)),
    // branch_A: Coll(10_000) + Pred(1/4 = 250) = 10_250
    let path = tmp.path().to_path_buf();
        let per_leaf = per_leaf.clone();
        schema: schema.clone(),
    CollectorCallStrategy, RgEvalContext, RowGroupBitsetSource, TreeBitsetSource,
            ));
        BoolNode::Predicate(_) => {}
}
    let tree = BoolNode::And(vec![
    let left = binop(col_expr("price"), Operator::GtEq, lit_i32(10_000));
    assert_eq!(prices.len(), 513 + 513 + 1024);
        .enumerate()
                    .map(|pp| (Arc::as_ptr(expr) as *const () as usize, pp))
        cost_a,
        let span = (max_doc - min_doc) as usize;
}
    run_all_strategies(1, residual, ROWS_PER_PAGE / 2, 3).await;
async fn single_collector_even_docs_page3_all_strategies() {
}
/// AND─┬─ Pred(price >= 10000)                                keeps pages 1,2,3
        predicate_columns: vec![],
fn build_pp_map(
            "strategy {:?}: pages_pruned",
    let pred_lt_31k = binop(col_expr("price"), Operator::Lt, lit_i32(31_024));
    let factory: EvaluatorFactory = {
/// Expected sort order by cost: [Pred(<1024), Pred(>=30000), Pred(<21024), Coll(all)]
        .filter(|&&p| p >= 20_000 && p < 21_024)
}
        ]),
    assert_eq!(get_counter(&m, "pages_pruned"), 2);
            Arc::new(Int32Array::from(prices)),
    assert_eq!(costs[2], 10_000, "Coll(all) should cost 10_000");
    // metrics is computed after the tree resolves — pages 0 and 3 are
///     ├─ AND─┬─ Pred(price >= 20000)                          keeps pages 2,3
        _ => panic!("expected AND"),
fn collector_for_tag(tag: u8) -> Arc<dyn RowGroupDocsCollector> {
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        .build();
    (seg, schema)
//! |  3   | 3072–4095   | 30_000..31_024 | `"delta"` |
///   4. root acc &= OR result → docs from pages 1+2 that are in the OR
        rg_idx: 0,
    .unwrap();
        BoolNode::And(vec![
        CollectorCallStrategy::FullRange,
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
                collector_leaf(5),
    ]);
//! 4096 rows, 1 RG, 4 pages of 1024 rows each.
        .into_iter()
                strategy,
        CollectorCallStrategy::FullRange,
        CollectorCallStrategy::TightenOuterBounds,
    // Page 0 has no candidates → 1 pruned
        .collect();
///          Coll(page3) called with [(3072,4096)] → all page 3 docs
///      3a. inner AND₁ (Pred + Coll(even)):
        .copied()
///   3. OR evaluated with inherited ranges [(1024,3072)]:
///
            strategy,
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
    let mut stream =
///     └─ Coll(even)                                            even docs
                page_prune_metrics: Some(
///      acc &= {0..3071} → {1024..3071}, ranges = [(1024,3072)]
    };
        .collect();
        // page 0: price == doc_id, even doc → even price
    ctx.register_table("t", provider).unwrap();
// ═════════════════════════════════════════════════════════════════════
    subtree_cost, BitmapTreeEvaluator, CollectorLeafBitmaps,
///      3b. NOT(AND(Coll(page3), Pred(price >= 30000))):
    assert_eq!(costs[0], 250, "Pred(<1024) should cost 250");
/// The two predicates with equal cost (250) are stable-sorted by original index.
        BoolNode::DelegationPossible { .. } => {}
    // Pred(>=30000): 1/4 pages kept → ceil(1000 * 1 / 4) = 250
    // Coll(all):     10 * 1000 = 10_000
        pred_node(pred_ge_10k), // child 0
            BoolNode::And(vec![collector_leaf(2), pred_node(pred_lt_21k)]), // first2pp, pages 0,1,2
            if doc >= min_doc && doc < max_doc {
    let p3 = binop(col_expr("price"), Operator::GtEq, lit_i32(30_000));
    // Indices 0 and 3 (cost 250) come first, then 1 (750), then 2 (10_000).
//!
    let schema = meta.schema().clone();
///     │      ├─ NOT── AND─┬─ Coll(page3)                      page 3 docs
                &schema,
            get_counter(&m, "pages_total"),
///      2d. NOT(Coll(all)):
/// ```
    let m = aggregate_metrics(&plan);
                0,
    let df = ctx.sql("SELECT price, brand FROM t").await.unwrap();
    assert_eq!(get_counter(&m, "pages_pruned"), 2);
///   2048,2049 — 2048 is even (not in odd set, but first2pp adds it), 2049 is odd (already in odd set).
///     └─ branch_B: AND(Coll(pages2+3), Pred(price < 21024))   ← Pred keeps 3/4 pages
    let tree = tree.push_not_down();
        BoolNode::Or(vec![pred_node(p0), pred_node(p3)]),
    // ~20_750), so the root accumulator after Coll(even) has even docs in
use crate::indexed_table::eval::single_collector::SingleCollectorEvaluator;
///          ranges = intersect([(1024,4096)], [(2048,4096)]) = [(2048,4096)]
    RgEvalContext {
    assert_eq!(costs[3], 250, "Pred(>=30000) should cost 250");
        let n = parquet_meta.row_group(i).num_rows();
            ]),
///   1. branch_A's Pred(price < 1024) → bitmap {0..1023} (page 0 only)
///     │    (page 3 max=31023 < 31024, so all pages kept)
        .map(|(i, c)| (i as i32, c))
}
    assert!(
//! |------|-------------|----------------|-----------|
        max_doc: i32,
        .map(|v| v.as_usize())
///      3a. Pred(price >= 20000): keeps pages 2,3 → cost 500 (2/4)
        .collect();
    let p0 = binop(col_expr("price"), Operator::Lt, lit_i32(1024));
///   2. Pred(price < 31024)  → acc &= {0..3071} → {1024..3071}, ranges = [(1024,3072)]
    fn collect_packed_u64_bitset(
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
    let (prices, plan) = run_bitmap_tree(tree).await;
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(SingleCollectorEvaluator::new(
            ));
                collector_strategy:
///          Coll(first2pp) called with [(1024,3072)] → docs 1024,1025,2048,2049
    let (prices, plan) = run_bitmap_tree(tree).await;
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    execute_and_collect(seg, schema, factory).await
use datafusion::arrow::array::{Int32Array, StringArray};
                pred_node(pred_ge_20k),                     // pages 2,3
}
/// Nested AND of two predicates intersects page ranges.
fn fixture_eval_ctx() -> RgEvalContext {
                let rel = (doc - min_doc) as usize;
        exprs
    let mut colls = Vec::new();
    let resolved = tree.resolve(&per_leaf).unwrap();
    let right = binop(col_expr("price"), Operator::GtEq, lit_i32(30_000));
}
    let children = match &resolved {
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
    let task_ctx = ctx.task_ctx();
///      root acc &= all_docs (no-op since all_docs is everything)
        .filter(|&&p| p >= 10_000 && p < 11_024)
    let mut colls = Vec::new();
 * SPDX-License-Identifier: Apache-2.0
) -> (Vec<i32>, Arc<dyn ExecutionPlan>) {
///          inner_acc = {2048..4095}
/// AND'd together → nothing survives. The key: branch_A's tight range [(0,1024)]
        BoolNode::And(cs) | BoolNode::Or(cs) => cs.iter().for_each(|c| wire_collectors_dfs(c, out)),
        or_cost,
///
///      acc = {1024..4095}, ranges = [(1024,4096)]
///     │      │            └─ Pred(price >= 30000)              keeps page 3
    Arc::new(PhysColumn::new(name, idx))
    // Page 3: all 1024 docs from page3 collector
        rg_first_row: 0,
/// narrows to surviving page range, PageRangeSplit calls per-range.
    let resolved = tree.resolve(&per_leaf).unwrap();
        pred_node(pred_lt_31k), // child 1
    // All 1024 rows from page 0 (prices 0..1024).
///
        .force_strategy(Some(FilterStrategy::BooleanMask))
async fn complex_5_wide_or_mixed_predicates_collectors() {
fn get_counter(set: &MetricsSet, name: &str) -> usize {
            .collect(),
    let expr = binop(col_expr("price"), Operator::Lt, lit_i32(-1));
//!
// ── Segment loader & metrics ────────────────────────────────────────
///          Result: odd docs from page 2 (512 docs)
/// ```
    let schema = fixture_schema();
/// AND─┬─ Pred(price < 1024)       keeps 1/4 pages → cost = ceil(1000*1/4) = 250
                collector_leaf(5),                          // odd docs
        max_doc: NUM_ROWS as i64,
        assert_eq!(
            }
        .iter()
    ) -> Result<CollectDocsResult, String> {
    let pred_ge_20k = binop(col_expr("price"), Operator::GtEq, lit_i32(20_000));
}
            prices.len()
///      returns even docs in page 2 → 512 docs
/// ```text
///   OR subtree:           sum of children costs
    set.sum(|m| m.value().name() == name && m.metric_type() == MetricType::Dev)
    }));
        let b = batch.unwrap();
                collector_leaf(1),      // even docs
async fn complex_cascading_and_with_not_at_depth() {
fn col_expr(name: &str) -> Arc<dyn PhysicalExpr> {
    let pred_narrow = binop(col_expr("price"), Operator::Lt, lit_i32(1024)); // 1/4 pages
///     └─ Coll(all)                                          cost 10_000
    assert_eq!(prices.len(), ROWS_PER_PAGE);
    assert_eq!(costs[1], 750, "Pred(<21024) should cost 750");
        let col = b.column(0).as_any().downcast_ref::<Int32Array>().unwrap();
        collector_leaf(0), // child 3
}
            .flat_map(|p| {
//! |  4  | 2048..4096                    | pages 2+3            |
    };
///      2b. AND(Pred(price >= 20000), Pred(price < 21024), Coll(odd)):
    fn walk(plan: &Arc<dyn ExecutionPlan>, out: &mut MetricsSet) {
//! |  6  | 3072..4096                    | page 3 only          |
        let mut out = vec![0u64; span.div_ceil(64)];
        BoolNode::Not(c) => collect_pred_exprs(c, out),
                max_collector_parallelism: 1,
}
        .indexed_pushdown_filters(false)
    ]);
///     └─ Coll(all_docs)                                      all doc IDs
async fn bitmap_tree_and_predicate_prunes_3_pages() {
    // child 0: Pred(>=10k) keeps pages 1,2,3 (3/4) → ceil(1000*3/4) = 750
        .collect();
    assert_eq!(get_counter(&m, "pages_pruned"), 3);
        BoolNode::Not(c) => wire_collectors_dfs(c, out),
    assert_eq!(get_counter(&m, "pages_pruned"), 2);
    // Verify execution order: Pred(>=10k) first, Pred(<31k) second, Coll third, OR last
            .iter()
    collector_tag: u8,
///          Pred(>=20k) keeps pages 2,3 → inner_acc = {2048..4095}
    assert_eq!(prices.len(), 512);
    sorted_indices.sort_by_key(|&i| costs[i]);
 * this file be licensed under the Apache-2.0 license or a
            walk(child, out);
        &self,
}
/// Residual price >= 30_000 with even-docs collector → even docs from page 3.
///          Pred keeps page 0,1 → inner_acc = {0..2047}
///   2. Pred(price < 31024): cost 750 (3/4 pages)
                Some(crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(sm)),
    assert_eq!(prices.len(), 2 * ROWS_PER_PAGE);
///      2c. AND(Coll(page3), Pred(price >= 30000)):
}
///     └─ OR─┬─ AND(Pred(price < 11024), Coll(even))          pages 1 only, even docs
    let pp_map = build_pp_map(&tree, &schema);
            expected_len,
         (A={}, B={})",
///            ranges = intersect([(2048,3072)], [(3072,4096)]) = [] (empty!)
                cost_predicate: 1,
        BoolNode::Or(vec![
/// Residual price < 1024 with all-docs collector → page 0 only, 3 pruned.
///
const ROWS_PER_PAGE: usize = 1024;
/// AND─┬─ Pred(price >= 10000)                              keeps pages 1,2,3
        let tree = Arc::clone(&tree);
        pred_node(pred_lt_31k), // pages 0,1,2
use datafusion::physical_expr::PhysicalExpr;
    let mut prices = Vec::new();
    let pred_lt_21k = binop(col_expr("price"), Operator::Lt, lit_i32(21_024));
fn fixture_schema() -> SchemaRef {
        Field::new("brand", DataType::Utf8, false),
}
    assert!(prices.iter().all(|&p| p >= 20_000 && p < 21_024));
/// tag 3 → pages 0+1 only (docs 0..2048), tag 4 → pages 2+3 only (docs 2048..4096),
///   1025 is odd → already in page 1 even? No, 1025 is odd doc. But first2pp
//! |-----|-------------------------------|----------------------|
            NUM_PAGES,
    w.close().unwrap();
};
        .set_write_batch_size(ROWS_PER_PAGE)
///
/// Selectivity-aware cost ordering:
/// OR(Predicate(price < 1024), Predicate(price >= 30_000)) → pages 0 and 3.
                build_pruning_predicate(expr, schema.clone())
    let pred_ge_30k = binop(col_expr("price"), Operator::GtEq, lit_i32(30_000));
        BoolNode::Predicate(e) => out.push(Arc::clone(e)),
            BoolNode::And(vec![
fn cost_ordering_complex_tree_predicates_before_or_before_nothing() {
    };
    let seg = SegmentFileInfo {
async fn single_collector_prunes_3_pages_all_strategies() {
    assert_eq!(cost_b, 10_750, "branch_B: Coll + wide pred");
        });
        4 => (2048..NUM_ROWS as i32).collect(),         // pages 2+3
///     │     └─ AND(Pred(price >= 20000), Coll(odd), NOT(Coll(page3)))
                }
                out[rel / 64] |= 1u64 << (rel % 64);
use std::collections::HashMap;
}
///          inner_acc &= universe → unchanged {2048..3071}
    assert_eq!(*prices.last().unwrap(), 21_023);
///     │     └─ AND─┬─ Pred(price >= 20000)                  keeps pages 2,3
    match node {
    let plan = df.create_physical_plan().await.unwrap();
    walk(plan, &mut set);
    ]);
///      inherited ranges = [(1024,3072)]
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
) -> Arc<HashMap<usize, Arc<datafusion::physical_optimizer::pruning::PruningPredicate>>> {
        BoolNode::Collector { annotation_id } => out.push(collector_for_tag(*annotation_id as u8)),
    let p1: Vec<_> = prices
async fn single_collector_page1_only() {
    let m = aggregate_metrics(&plan);
    sorted.sort_by_key(|&(cost, idx)| (cost, idx));
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
async fn bitmap_tree_and_two_predicates_intersect() {
        .filter(|&&p| p >= 30_000 && p < 31_024)
///   = page 1 even (512) + page 2 odd (512) + page 3 (1024) + {1025,2048} extra
///
///   1. Pred(price >= 10000) → acc = {1024..4095}, ranges = [(1024,4096)]
            let pruner = Arc::new(PagePruner::new(
                sm.ffm_collector_calls.clone(),
///          - Pred(price < 21024) → inner_acc = {0..3071}
                std::sync::Arc::new(std::collections::HashMap::new()),
        .collect();
    assert_eq!(get_counter(&m, "pages_pruned"), NUM_PAGES);
    assert!(prices.iter().all(|p| {
///   Total: 512 + 512 + 1024 + 2 = 2050
            BoolNode::And(vec![collector_leaf(6), pred_node(pred_ge_30k)]), // page3 coll, page 3
    let mut rgs = Vec::new();
            BoolNode::And(vec![pred_node(pred_lt_21k), collector_leaf(1)]),
                tree: Arc::new(resolved),
    let meta =
 *
    let pred_ge_10k = binop(col_expr("price"), Operator::GtEq, lit_i32(10_000));
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    let tree = BoolNode::And(vec![
        pred_node(pred_narrow2.clone()), // child 3
fn cost_ordering_predicates_sorted_by_selectivity() {
                ),
    let m = aggregate_metrics(&plan);
///   branch_A: Pred keeps 1/4 → cost 250, Coll cost 10_000 → total 10_250
    set
    }));
    let pred_ge_10k = binop(col_expr("price"), Operator::GtEq, lit_i32(10_000));
/// ```
                page_pruner: pruner,
    // All prices should be in page 2 range
        metadata: parquet_meta,
    let pred_lt_21k = binop(col_expr("price"), Operator::Lt, lit_i32(21_024));
    let tmp = write_fixture();
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
///      3c. Coll(all) called with [(2048,3072)] → all docs in page 2
                Arc::clone(&segment.metadata),
    let residual = binop(lo, Operator::And, hi);
        .map(|(i, c)| (i as i32, c))
        BoolNode::DelegationPossible { .. } => {}
            ));
        let m = aggregate_metrics(&plan);
///          Coll(even) called with [(1024,2048)] → even docs in page 1
    // branch_B: Coll(10_000) + Pred(3/4 = 750) = 10_750
fn binop(
    let prices: Vec<i32> = (0..NUM_PAGES)
    Arc::new(Literal::new(ScalarValue::Int32(Some(v))))
    let residual = binop(col_expr("price"), Operator::GtEq, lit_i32(0));
                cost_collector: 10,
/// Final: even page 1 ∪ odd page 2 ∪ all page 3 ∪ {1024,1025,2048,2049}
    assert!(prices.iter().all(|&p| (p - 20_000) % 2 == 0));
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        .target_partitions(1)
        prune_tree_config: None,
    let pred_lt_31k = binop(col_expr("price"), Operator::Lt, lit_i32(31_024));
            BoolNode::Not(Box::new(collector_leaf(0))),                     // NOT all = empty
        segments: vec![seg],
    // pruning was skipped entirely).
///            returns empty in this range, NOT inverts to universe,
use std::sync::Arc;
        .iter()
        if plan.name() == "QueryShardExec" {
    let pp_map = build_pp_map(&tree, &schema);
    // Page 0: excluded by root Pred(>= 10000)
/// ```
}
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
//!
///     ├─ Pred(price < 31024)                                keeps pages 0,1,2
    // Count by page:
///          Result: page 3 docs (1024 docs)
    let pruner = PagePruner::new(&schema, seg.metadata, schema.clone());
                None,
    // Page 2 (20000..21023): even ∪ odd = all → 1024 rows
///      2e. AND(Coll(first2pp), Pred(price < 21024)):
///      inner ranges = intersect([(0,1024)], [(0,3072)]) = [(0,1024)]
        crate::indexed_table::bool_tree::ResolvedNode::And(c) => c,
            BoolNode::And(vec![
}
//! | page | rows        | price range    | brand     |
fn pred_node(expr: Arc<dyn PhysicalExpr>) -> BoolNode {
    assert_eq!(costs[0], 750, "Pred(>=10k): 3/4 pages");
    Arc::new(MockCollector { docs })
///            inner_inner_acc = {3072..4095}
        Field::new("price", DataType::Int32, false),
    assert_eq!(get_counter(&m, "pages_pruned"), NUM_PAGES);
    let (seg, schema) = load_segment(&tmp);
        pred_node(pred_ge_10k), // pages 1,2,3
    let costs: Vec<u32> = children
    let tmp = write_fixture();
    assert_eq!(sorted_indices[2], 1, "wide pred third");
        }
        .filter(|&&p| p >= 20_000 && p < 21_024)
use crate::indexed_table::index::RowGroupDocsCollector;
            BoolNode::And(vec![
                pred_node(pred_ge_20k),
}
async fn run_single_collector(
fn load_segment(tmp: &NamedTempFile) -> (SegmentFileInfo, SchemaRef) {
        2 => (0..NUM_PAGES)
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
        cost_a < cost_b,
async fn execute_and_collect(
            get_counter(&m, "pages_pruned"),
        store,
async fn bitmap_tree_all_pages_pruned() {
) -> (Vec<i32>, Arc<dyn ExecutionPlan>) {
    }
    let children = match &resolved {
/// ```text
///
    assert_eq!(*prices.last().unwrap(), 1023);
        .enumerate()
 * compatible open source license.
    // Pages 0, 3: excluded by predicate intersection
        annotation_id: tag as i32,
    let pred_ge_10k = binop(col_expr("price"), Operator::GtEq, lit_i32(10_000));
    let tree = BoolNode::And(vec![branch_a, branch_b]);
    let store: Arc<dyn object_store::ObjectStore> =
/// Costs:                        [250,        250,           750,          10_000]
///      root acc = branch_A result (page 0 docs only)
///
            BoolNode::And(vec![pred_node(pred_lt_11k), collector_leaf(1)]), // even, page 1
        assert_eq!(prices.len(), NUM_ROWS, "strategy {:?}", strategy);
// ── Mock collector ──────────────────────────────────────────────────
        sort_min: None,
///          Result: empty
    let pred_lt_21k = binop(col_expr("price"), Operator::Lt, lit_i32(21_024));
use crate::indexed_table::eval::bitmap_tree::{
            run_single_collector(collector_tag, Arc::clone(&residual), strategy).await;
    schema: &SchemaRef,
            expected_pruned,
 * The OpenSearch Contributors require contributions made to
    let pred_wide = binop(col_expr("price"), Operator::Lt, lit_i32(21024));
    let residual = binop(col_expr("price"), Operator::Lt, lit_i32(1024));
///   4. Coll(even): cost 10_000
///
// ═════════════════════════════════════════════════════════════════════
///     └─ branch_B: AND(Coll(pages2+3), Pred(price < 21024))
///
                pred_node(pred_lt_21k), // pages 0,1,2
    let page2_prices: Vec<i32> = prices
use futures::StreamExt;
        writer_generation: 0,
    let pred_wide = binop(col_expr("price"), Operator::Lt, lit_i32(21024)); // 3/4 pages
/// AND(Predicate(price >= 10_000), Predicate(price < 21_024)) → pages 1 and 2.
use crate::indexed_table::eval::{
async fn bitmap_tree_or_predicate_keeps_two_pages() {
fn collector_leaf(tag: u8) -> BoolNode {
///
    // even page 2 (512 rows). However, the candidate bitmap used for
    let pred_ge_30k = binop(col_expr("price"), Operator::GtEq, lit_i32(30_000));
    let mut colls = Vec::new();
async fn run_bitmap_tree(tree: BoolNode) -> (Vec<i32>, Arc<dyn ExecutionPlan>) {
    assert_eq!(sorted[3].1, 2, "OR subtree last (cost {})", sorted[3].0);
///   3. branch_B's Pred(price < 21024) → bitmap {0..3071}
//!
/// Root AND execution (cost-sorted):
///          ← narrowed to page 2 only!
    execute_and_collect(seg, schema, factory).await
///   adds 1024,1025 — 1024 is even (already in even set), 1025 is new.
    // Pred(<21024):  3/4 pages kept → ceil(1000 * 3 / 4) = 750
///           ├─ AND(Coll(page3), Pred(price >= 30000))         page 3, page3 collector
                std::sync::Arc::new(crate::indexed_table::eval::single_collector::FfmDelegatedBackendCollectorFactory),
}
            let pruner = Arc::new(PagePruner::new(
                rg_index_to_pos: HashMap::new(),
/// FullRange calls collector on full [0, 4096), TightenOuterBounds
const NUM_ROWS: usize = ROWS_PER_PAGE * NUM_PAGES; // 4096
        datafusion::physical_plan::execute_stream(Arc::clone(&plan), task_ctx).unwrap();
/// 3 of 4 pages pruned.
}
///      ranges tighten further
    let mut offset = 0i64;
        row_groups: rgs,
///            Coll(page3) called with [] → no FFM call needed, returns empty
    // Page 2: odd docs (512) + doc 2048 from first2pp = 513
        cost_collector: 10,
    tree: &BoolNode,
/// ```text
    let (seg, schema) = load_segment(&tmp);
    ]);
//! |  0   | 0–1023      | 0..1_024       | `"alpha"` |
        let pp_map = Arc::clone(&pp_map);
//!
    let mut colls = Vec::new();
///      Sorted by cost — predicates are cheap, collectors expensive.
        crate::indexed_table::bool_tree::ResolvedNode::And(c) => c,
///
    assert_eq!(prices.len(), 512 + 1024);
use datafusion::physical_plan::metrics::MetricsSet;
        let residual_pp = residual_pp.clone();
    assert_eq!(p1.len(), 513);
    w.write(&batch).unwrap();
        let (prices, _plan) = run_single_collector(0, Arc::clone(&residual), strategy).await;
    // Pred(<1024):   1/4 pages kept → ceil(1000 * 1 / 4) = 250
    prices.sort();
    // Final page-level decision: pages 0 and 3 have candidates, pages 1 and 2 don't.
use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
///          NOT inverts → empty (universe - all = nothing)
    let m = aggregate_metrics(&plan);
    let residual = binop(col_expr("price"), Operator::GtEq, lit_i32(30_000));
        rg_num_rows: NUM_ROWS as i64,
use datafusion::logical_expr::Operator;
    l: Arc<dyn PhysicalExpr>,
///
///     │            ├─ Coll(odd_docs)                         odd doc IDs
        "branch with more selective predicate should be cheaper \
    let m = aggregate_metrics(&plan);
    }
        max_doc: NUM_ROWS as i32,
///          Result: even docs from page 1 (512 docs)
/// → Most selective predicate first, then less selective, then Coll(all)
use datafusion::parquet::arrow::ArrowWriter;
        assert_eq!(
        for &doc in &self.docs {
                evaluator: Arc::new(BitmapTreeEvaluator),
///            inner-inner result = empty
///      OR unions all: 512 + 512 + 1024 + 0 + 4 = 2052 docs
) -> Arc<dyn PhysicalExpr> {
//! Price ranges are non-overlapping so predicates like `price < 1024`
/// unioned = all of page 2 + even of page 1). Total = 1024 (page 2) + 512 (even page 1) = 1536.
    let pred_narrow = binop(col_expr("price"), Operator::Lt, lit_i32(1024)); // keeps page 0
        .iter()
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
    assert!(prices.contains(&30_000));
        pred_node(pred_narrow.clone()),  // child 0
// ═════════════════════════════════════════════════════════════════════
    assert!(!prices.contains(&10_000));
        .build();
        .set_max_row_group_size(NUM_ROWS)
    };
    wire_collectors_dfs(&tree, &mut colls);
// ═════════════════════════════════════════════════════════════════════
                leaves: Arc::new(CollectorLeafBitmaps::new(sm.ffm_collector_calls.clone())),
        _ => vec![],
            num_rows: n,
    let idx = fixture_schema().index_of(name).unwrap();
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
        arrow_schema: schema.clone(),
use crate::indexed_table::page_pruner::{build_pruning_predicate, PagePruner};
    // All returned prices should be even (from even doc IDs).
    let pruner = PagePruner::new(&schema, seg.metadata, schema.clone());
    assert_eq!(costs[1], 1000, "Pred(<31k): all pages kept (31023 < 31024)");
    // child 3: Coll(all) = 10_000
    let residual_pp = build_pruning_predicate(&residual_expr, schema.clone());
        .copied()
    assert_eq!(p3.len(), 1024);
        cost_predicate: 1,
// ── Tree wiring ─────────────────────────────────────────────────────
        pred_node(pred_wide.clone()),    // child 1
    let (seg, schema) = load_segment(&tmp);
///
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
///     │    Pred keeps 1/4 → cost 250, Coll cost 10_000 → subtree 10_250
    collector_tag: u8,
            .filter_map(|expr| {
        );
    BoolNode::Predicate(expr)
/// ```
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
                for metric in m.iter() {
        .set_statistics_enabled(EnabledStatistics::Page)
///   Coll(all_docs):       cost 10_000
    expected_len: usize,
///          ranges = intersect([(2048,4096)], [(2048,3072)]) = [(2048,3072)]
    // All 4 pages pruned in the final bitmap (empty candidates).
    assert_eq!(*prices.first().unwrap(), 10_000);
    let (seg, schema) = load_segment(&tmp);
use tempfile::NamedTempFile;
                vec![base, base + 1]
    }
#[test]
        BoolNode::Or(vec![
/// ```text
    assert_eq!(sorted[1].1, 1, "Pred(<31k) second (cost {})", sorted[1].0);
        sort_max: None,
        crate::indexed_table::bool_tree::ResolvedNode::And(c) => c,
        .flat_map(|p| {
    ] {
        .into_iter()
        ]),
    assert_eq!(sorted_indices[3], 2, "collector last");
///
    residual_expr: Arc<dyn PhysicalExpr>,
// ═════════════════════════════════════════════════════════════════════
    factory: EvaluatorFactory,
/// Root AND execution:
///   1. Pred(price >= 10000) → acc = {1024..4095}, ranges = [(1024,4096)]
    wire_collectors_dfs(&tree, &mut colls);
    run_all_strategies(0, residual, 0, NUM_PAGES).await;
    EvaluatorFactory, IndexedTableConfig, IndexedTableProvider, SegmentFileInfo,
        for i in 0..b.num_rows() {
                Arc::clone(&segment.metadata),
                BoolNode::Not(Box::new(collector_leaf(6))), // NOT page3
            })
///          Coll(odd) called with [(2048,3072)] → odd docs in page 2 only
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    )
    let tree = BoolNode::And(vec![
///           ├─ NOT(Coll(all))                                 complement of all = empty
                collector_leaf(6),      // page3 collector
///      root acc &= even → even docs in page 2
        collector_leaf(1), // even docs
    use datafusion::physical_plan::metrics::MetricType;
///     │          subtree cost = 500 + 10_000 + 10_000 = 20_500
use crate::indexed_table::index::CollectDocsResult;
        BoolNode::And(vec![collector_leaf(3), pred_node(pred_narrow)]), // branch_A
    }
            })
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = colls
    }
    let pred_ge_20k = binop(col_expr("price"), Operator::GtEq, lit_i32(20_000));
    assert_eq!(sorted_indices[0], 0, "most selective pred first");
        offset += n;
///            ← tightened to page 2 only!
        .collect();
    Arc::new(
//! # Fixture layout
        6 => (3072..NUM_ROWS as i32).collect(),         // page 3 only
fn lit_i32(v: i32) -> Arc<dyn PhysicalExpr> {
/// to propagate to branch_B's collector.
        collector_leaf(0),               // child 2
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    let (prices, plan) = run_bitmap_tree(tree).await;
        sort_orders: vec![],
///            inner_acc unchanged
        let residual_expr = Arc::clone(&residual_expr);
    collect_pred_exprs(tree, &mut exprs);
    assert_eq!(costs[3], 10_000, "Coll(all)");
    }
    assert_eq!(page1_prices.len(), 512);
use datafusion::arrow::record_batch::RecordBatch;
    let labels = ["alpha", "beta", "gamma", "delta"];
    // Page 1 (10000..11023): even docs only → 512 rows
    let tree = BoolNode::And(vec![
}
    for strategy in [
            }
    assert_eq!(sorted_indices[1], 3, "second most selective pred second");
///   Pred(price < 31024):  keeps 3/4 → cost 750
///     ├─ Coll(all)                 cost = 10 * 1000 = 10_000
/// ```text
///     ├─ OR─┬─ AND─┬─ Pred(price < 21024)                  keeps pages 0,1,2
}
    let pred_lt_31k = binop(col_expr("price"), Operator::Lt, lit_i32(31_024));
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    let lo = binop(col_expr("price"), Operator::GtEq, lit_i32(10_000));
            "strategy {:?}: expected {} rows, got {}",
///          Pred keeps 3/4 → cost 750, Coll cost 10_000 → subtree 10_750
///      3b. inner AND₂ (Pred + Coll(odd) + NOT(Coll(page3))):
///          Pred(>=30k) keeps page 3 → cost lower, evaluated first
    assert_eq!(cost_a, 10_250, "branch_A: Coll + narrow pred");
}
/// tag 0 → all docs, tag 1 → even docs only, tag 2 → first 2 per page,
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
///
///      Now only pages 1+2 survive in the accumulator.
/// AND(Collector(all), Predicate(price < 1024)) → only page 0 survives.
    let tree = tree.push_not_down();
    let brands: Vec<&str> = (0..NUM_PAGES)
///   with tightened range, then OR last (most expensive).
///     ├─ Pred(price < 31024)                                4/4 pages → cost 1000
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
};
///
/// Execution order:
                stats_prune_tree: None,
            ]),
///
        .iter()
        );
        .map(|c| subtree_cost(c, &ctx, &pruner, &pp_map))
    (prices, plan)
    let costs: Vec<u32> = children
    let parquet_meta = meta.metadata().clone();
// ── Execution harnesses ─────────────────────────────────────────────
    while let Some(batch) = stream.next().await {
                BoolNode::Not(Box::new(collector_leaf(6))),
            (0..ROWS_PER_PAGE as i32).map(move |i| base + i)
}
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
/// branch_A (10_250) < branch_B (10_750) → branch_A evaluated first.
///          inner_acc = {3072..4095}
///
        collector_leaf(0),
    ]))
        3 => (0..2048).collect(),                       // pages 0+1
// ═════════════════════════════════════════════════════════════════════
                schema.clone(),
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = colls
    let page1_prices: Vec<i32> = prices
/// Collector intersected with OR of two page ranges → even docs from pages 0,3.
        pred_node(pred_ge_10k), // pages 1,2,3
        collector_leaf(0), // all docs
                pred_node(pred_ge_30k), // page 3
        0 => (0..NUM_ROWS as i32).collect(),
}
    let resolved = tree.resolve(&per_leaf).unwrap();
///           └─ AND(Coll(first2pp), Pred(price < 21024))       first 2 per page, pages 0,1,2
        for child in plan.children() {
///          inner-inner AND:
    let ctx = fixture_eval_ctx();
        pred_node(pred_ge_10k),
        evaluator_factory: factory,
/// tag 5 → odd docs only, tag 6 → page 3 only (docs 3072..4096).
        .iter()
            if let Some(m) = plan.metrics() {
    assert_eq!(sorted[2].1, 3, "Coll(all) third (cost {})", sorted[2].0);
    let (seg, schema) = load_segment(&tmp);
// ── Expression helpers ──────────────────────────────────────────────
///   5. Coll(all_docs) called with tightened ranges → only scans pages 1+2
///     ├─ Pred(price < 21024)       keeps 3/4 pages → cost = ceil(1000*3/4) = 750
//! | tag | docs                          | description          |
///      Now only pages 1+2 survive.
///          - Pred(price >= 20000) → inner_acc = {2048..4095}
    // Pages 0 and 3 have no candidates → 2 pruned
#[test]
        .set_data_page_row_count_limit(ROWS_PER_PAGE)
// Bitmap tree (multi-filter) page pruning tests
    // Final page-level: pages 1 and 2 have candidates, pages 0 and 3 don't.
    let size = std::fs::metadata(&path).unwrap().len();
                &schema,
/// AND─┬─ Pred(price >= 10000)                              3/4 pages → cost 750
fn aggregate_metrics(plan: &Arc<dyn ExecutionPlan>) -> MetricsSet {
///   2. OR with 5 children, inherited ranges [(1024,4096)]:
///     │     │      └─ Coll(even_docs)                       even doc IDs
    let mut exprs = Vec::new();
/// Residual that matches everything → no pages pruned.
    assert!(
///          Pred(<21024) keeps pages 0,1,2 → inner_acc &= {0..3071} → {2048..3071}
// Execution order tests — assert selectivity-aware cost ordering
async fn bitmap_tree_nested_collector_and_or_predicates() {
    let tree = tree.push_not_down();
}
// ── Fixture builder ─────────────────────────────────────────────────
                    None,
use crate::indexed_table::table_provider::{
    let pred_ge_10k = binop(col_expr("price"), Operator::GtEq, lit_i32(10_000));
) {
    let tree = BoolNode::And(vec![collector_leaf(0), pred_node(left), pred_node(right)]);
/// ```text
        assert_eq!(
            ]), // odd, page 2
            BoolNode::And(vec![
            strategy
///   Net new from first2pp: {1025, 2048} → +2 docs
    let p3: Vec<_> = prices
        ],
    run_all_strategies(0, residual, ROWS_PER_PAGE, 3).await;
    run_all_strategies(0, residual, ROWS_PER_PAGE, 3).await;
        })
    };
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
        ]),
    ]);
///
    let p2: Vec<_> = prices
    let cost_b = subtree_cost(&children[1], &ctx, &pruner, &pp_map);
        collector_call_ranges: None,
//! |  3  | 0..2048                       | pages 0+1            |
        .unwrap_or(0)
/*
    let file = std::fs::File::open(&path).unwrap();
    }
        Arc::new(move |segment, _chunk, sm, _stats_prune_tree| {
        BoolNode::Collector { .. } => {}
        .flat_map(|p| std::iter::repeat(labels[p]).take(ROWS_PER_PAGE))
    residual: Arc<dyn PhysicalExpr>,
    assert_eq!(get_counter(&m, "pages_total"), NUM_PAGES);
    // Page 1: even docs (512) + doc 1025 from first2pp = 513
    let pred_narrow = binop(col_expr("price"), Operator::Lt, lit_i32(1024));
    assert_eq!(get_counter(&m, "pages_pruned"), 2);
fn collect_pred_exprs(node: &BoolNode, out: &mut Vec<Arc<dyn PhysicalExpr>>) {
///      root ranges tighten to [(0,1024)]
    assert_eq!(prices.len(), ROWS_PER_PAGE);
        BoolNode::Or(vec![pred_node(left), pred_node(right)]),
///       doc 2049 overlaps with odd page 2. Union deduplicates.)
    let right = binop(col_expr("price"), Operator::Lt, lit_i32(21_024));
            ]))),
async fn complex_deep_nesting_range_propagation_4_levels() {
}
    let batch = RecordBatch::try_new(
///   3. inner AND (Pred + NOT(AND) + Coll): cost = 250 + 10_000 + 10_000 = 20_250
// ═════════════════════════════════════════════════════════════════════
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        .collect();
        pushdown_predicate: None,
// Single collector page pruning tests — all three CollectorCallStrategy
async fn run_all_strategies(
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
    let (prices, plan) = run_bitmap_tree(tree).await;
        let (prices, plan) =
async fn single_collector_no_pruning_all_strategies() {
    // Even docs in page 3: 512 rows.
fn write_fixture() -> NamedTempFile {
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
            index: i,
            // child 2
        .map(|(i, c)| (i as i32, c))
            Ok(eval)
///           ├─ AND(Pred(price >= 20000), Pred(price < 21024), Coll(odd))  page 2, odd
    r: Arc<dyn PhysicalExpr>,
    let pred_narrow2 = binop(col_expr("price"), Operator::GtEq, lit_i32(30_000)); // 1/4 pages
///      → returns empty (pages2+3 collector has no docs in page 0)
    assert_eq!(prices.len(), 0);
    wire_collectors_dfs(&tree, &mut colls);
    let mut sorted_indices: Vec<usize> = (0..4).collect();
    let hi = binop(col_expr("price"), Operator::Lt, lit_i32(11_024));
/// ```
/// Run a single-collector query with a given strategy, return (prices, plan).
//! |  5  | 1, 3, 5, …                   | odd docs             |
        .collect();
            expected_len,
    // All should be even-indexed within page 2
                let base = (p * ROWS_PER_PAGE) as i32;
    // pages 1+2. The inner AND then narrows to page 2. Final bitmap =
        min_doc: i32,
///   Pred(price >= 10000): keeps 3/4 → cost 750
        cancellation_token: None,
///      called with ranges from root acc (page 2 only after step 3)
                    out.push(Arc::clone(metric));
        .map(|c| subtree_cost(c, &ctx, &pruner, &pp_map))
    let tmp = write_fixture();
    for strategy in [
    wire_collectors_dfs(&tree, &mut colls);
        .into_iter()
        .map(|(i, c)| (i as i32, c))
    let tmp = NamedTempFile::new().unwrap();
    let pred_lt_11k = binop(col_expr("price"), Operator::Lt, lit_i32(11_024));
        global_base: 0,
}
///   4. branch_B's Coll(pages2+3) called with ranges [(0,1024)]
            });
            ]),
///          inner_acc = {0..3071}
        .into_iter()
/// Final result: all docs from pages 1+2 (even from pages 1+2, odd from page 2,
                pruning_predicates: Arc::clone(&pp_map),
/// The more selective predicate's branch wins, causing its tight range
    let residual = binop(col_expr("price"), Operator::Gt, lit_i32(999_999));
///   → branch_A evaluated first (more selective predicate)
    let (prices, plan) = run_bitmap_tree(tree).await;
///
}
            let base = (p as i32) * 10_000;
#![cfg(test)]
    seg: SegmentFileInfo,
    let expr = binop(col_expr("price"), Operator::Lt, lit_i32(1024));
        _ => panic!("expected AND"),
/// ```text
/// Residual that matches nothing → all pages pruned, zero rows.
        costs[3]
                residual_pp.clone(),
///          ranges = intersect([(1024,4096)], [(0,3072)]) = [(1024,3072)]
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = colls
    // child 2: OR subtree (sum of inner costs)
    Arc::new(BinaryExpr::new(l, op, r))
    assert_eq!(p2.len(), 513);
    // Verify all of page 2 is present
                    std::collections::HashMap::new(),
    assert_eq!(prices.len(), 2 * ROWS_PER_PAGE);
    // Verify sort order: [250, 250, 750, 10_000]
use datafusion::common::ScalarValue;
///          ranges = intersect([(1024,4096)], [(3072,4096)]) = [(3072,4096)]
/// Helper: run the same residual across all three strategies, assert identical results.
    // will filter out, but the candidate-stage bitmap still has them.
///          ranges = intersect([(1024,3072)], [(2048,4096)]) = [(2048,3072)]
// ═════════════════════════════════════════════════════════════════════
        // page 3: price = 30000 + (doc_id - 3072), even doc → even offset
        _ => panic!("expected AND"),
    let branch_a = BoolNode::And(vec![collector_leaf(3), pred_node(pred_narrow.clone())]);
use crate::indexed_table::bool_tree::BoolNode;
    let (prices, plan) = run_bitmap_tree(tree).await;
//! Deterministic page-pruning e2e tests.
    )
/// ```
/// Pred(<1024) is index 0, Pred(>=30000) is index 3 → Pred(<1024) first.
///          - Coll(even) called with [(1024,3072)] → even docs in pages 1+2
use datafusion::execution::context::SessionContext;
///      OR unions: even docs from pages 1+2 ∪ odd docs from page 2
    // pruned (no candidates). Page 1 has residual even-doc candidates
/// 2 of 4 pages pruned.
    let ctx = SessionContext::new();
        }
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(sm),
    let (prices, plan) = run_bitmap_tree(tree).await;
    ]);
    BoolNode::Collector {
    // Only page 2 survives, even docs only → 512 rows
    let m = aggregate_metrics(&plan);
        cost_b
/// Step-by-step:
        vec![
async fn single_collector_all_pruned_all_strategies() {
    let m = aggregate_metrics(&plan);
///            ranges = intersect([(1024,3072)], [(0,3072)]) = [(1024,3072)]
        1 => (0..NUM_ROWS as i32).step_by(2).collect(),
///   Root acc = {1024..4095} & OR_result
    let factory: EvaluatorFactory = {
/// AND─┬─ branch_A: AND(Coll(pages0+1), Pred(price < 1024))
    let children = match &resolved {
///      2a. AND(Pred(price < 11024), Coll(even)):
/// All produce the same rows for price in [10_000, 11_024).
        .filter(|&&p| p >= 10_000 && p < 11_024)
impl RowGroupDocsCollector for MockCollector {
///          - Coll(odd) called with [(2048,3072)] → odd docs in page 2 only
///     ├─ OR─┬─ AND(Pred(price < 21024), Coll(even))        subtree cost = 750 + 10_000 = 10_750
    }
    let pp_map = build_pp_map(&tree, &schema);
            first_row: offset,
        })
    let p0: Vec<_> = prices.iter().filter(|&&p| p < 1_024).collect();
        *p < 1024 || *p >= 30_000
fn cost_ordering_nested_and_branches_selective_first() {
/// AND─┬─ Pred(price >= 10000)                                keeps pages 1,2,3
    // Final page-level: pages 0 and 3 have candidates, pages 1 and 2 pruned.
