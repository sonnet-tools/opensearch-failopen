    /// coll0 and coll1 must still get empty per_leaf entries.
        let mut dfs_counter = 0usize;
impl LeafBitmapSource for CollectorLeafBitmaps {
        let mock_a = Arc::new(NextDocMockCollector::new(vec![], 500));
            prune_tree_leaf(vec![true, false, true]),
            RowSelector::select(3),
// `prefetch_node` (which sorts children by cost) and `on_batch_node` (which
        rg_index_to_pos: &HashMap<usize, usize>,
        assert_eq!(mock.call_args(), vec![(0, 100)]);
        assert!(bm_b.contains(20));
            batch,
                &tree,
            // delivered row i -> rg_pos = batch_offset + i -> bit = batch_offset + i + anchor.
            collector_leaf(3),
                // Short circuit case
 * compatible open source license.
            result.per_leaf.len(),
    node: &ResolvedNode,
        &self,
    fn phase2_collector_uses_cached_bitmap() {
            ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]),
// the key, not `leaf_dfs_index`. DFS position changes between
        // never aliases another leaf mid-query.
            ]),
        let leaves = PoisonLeafBitmaps { allowed, forbidden };
    struct PoisonLeafBitmaps {
        #[derive(Debug)]
    /// Identity position map over `rg_num_rows`. Delivered index == RG
                    }
    #[test]
        ]);
    /// Realistic tree shape (mirrors a PPL query like
                // Tighten collector call ranges from the accumulator bitmap,
                    page_prune_metrics,
 * SPDX-License-Identifier: Apache-2.0
    }
            b
    batch_len: usize,
        Some(pp) => pp,
                &HashMap::from([(0, 0)]),
//! The tree is evaluated in two stages per row group:
        let mut allowed = HashMap::new();
            RecordBatch::try_new(schema, vec![Arc::new(Int32Array::from(vec![0i32; 4]))]).unwrap();
        bm.insert_range(8..11); // bits 8,9,10
        );
        };
    }
                    let scalar = lit.value().to_scalar().map_err(|e| e.to_string())?;
        assert_eq!(
            if hi > 0 && lo <= u32::MAX as i64 {
    fn next_doc_tighten_effective_min() {
                None,
            return bm;
            prune_tree_leaf(vec![false]),
        // Tree: OR(AND(empty_leaf, other_leaf), standalone_leaf).
            )
    }
        );
            rg_first_row: 100,
    /// many leaves, hence a keyed map.)
            subtree_cost(&nested, &ctx, &pruner, &pp)
    // ── subtree_cost ─────────────────────────────────────────────────
        // [0,20) ∩ [5,10) → [5,10)
        ResolvedNode::Or(children) => {
        };
        let result = BitmapTreeEvaluator
/// result contains only the portions where both lists overlap.
            .prefetch(
                result_bitmap |= &filtered_bitmap;
    ///           OR
        let tree = ResolvedNode::Or(vec![
                    let end_rel = start_rel + s.row_count as i64;
                &test_ctx(),
        let pruner = empty_pruner();
        let leaves = FixedLeafBitmaps {
            let bm = leaves.leaf_bitmap(node, leaf_idx, ctx)?;
        // rg_can_match has 3 positions: [true, false, true]
                Ok(vec![].into())
    impl LeafBitmapSource for FixedLeafBitmaps {
    ) -> Result<TreePrefetch, String> {
        )))
        //   OR sorts: coll2 (cost=10) before AND(Pred+OR) (cost=1+20=21)
    fn bitmap_to_batch_mask_respects_position_map() {
        assert_eq!(got, vec![false, true, false, false]);
    /// coll0 and coll1 inside the pruned AND must still get empty per_leaf
        Ok(TreePrefetch {
            if subtree_has_predicate(child) {
            let mut run_end = first; // inclusive
        rg_first_row: i64,
        // OR(all_true_leaf, poison_leaf). Same setup as AND case but inverted.
                    batch_offset,
            // conservative: every row in scope is a candidate.
/// `batch_offset` is the delivered-row index of the first row in this
                universe.insert_range(0..span);
    /// resulting mask shape with deliberately-wrong siblings.
        //
        ColumnarValue::Array(arr) => {
        //   DFS index 0 = first Collector, DFS index 1 = second.
        // min_doc = 100, bitmap has {1, 5} (min_doc-relative).
                    dfs,
        assert!(
        let result = BitmapTreeEvaluator
    /// When `rg_idx` IS in the reverse map and maps to a position where
            b
            .prefetch(
    }
    // ── Candidate-stage skip of bitmap materialization ────────────────
                } else {
            b.insert(5);
//
                None,
        }
            max_doc: 100,
            &mut dfs_counter,
        Some(sel) => {
        let pruner = empty_pruner();
                if let Some(ref result_bitmap) = optional_result_bitmap {
        let mask = bitmap_to_batch_mask(&bm, 0, 0, &pm, 0, 5);
        let key = Arc::as_ptr(&collector) as *const () as usize;
                stats_prune_tree.and_then(|spt| spt.children.first()),
                }
        None => {
        forbidden: HashSet<usize>,
/// safety check. Used for non-`col OP literal` shapes (IN, IS NULL,
                            let mut page_end = page_counts[0];
        position_map: &PositionMap,
        // Stats: AND subtree = false (Predicate child stats=false), coll2 = true
        let rg_map = HashMap::from([(2usize, 0usize), (3, 1), (4, 2)]);
        assert_eq!(mask.true_count(), 0);
                    rg_first_row,
    pruning_predicates: &HashMap<usize, Arc<PruningPredicate>>,
                &HashMap::new(),
#[cfg(test)]
        let mask = on_batch_node(&tree, &state, &batch, 0, &identity_pm(4), 0, 4)
            rg_idx: 0,
                    ));
            state,
            cost_collector: 10,
    pub ffm_collector_calls: Option<datafusion::physical_plan::metrics::Count>,
        }
    match node {
            ResolvedNode::Or(vec![collector_leaf(0), collector_leaf(1)]),
        let tmp = tempfile::NamedTempFile::new().unwrap();
                batch,
        assert_eq!(calls.len(), 2);
            Ok(result_bitmap.unwrap_or_default())
                    // covers rows inside [min_doc, max_doc).
///
                universe -= &child_bm;
        if batch_schema.index_of(col.name()).is_err() {
            }
            min_doc: 0,
        let single_collector = collector_leaf(0);
            bitmaps: vec![bm(&[1, 3, 5])],
            let total_docs = (ctx.max_doc - ctx.min_doc) as u64;
    }
            *dfs += 1;
    /// entries in `per_leaf`. Otherwise on_batch refinement panics with
    }
        let leaves = FixedLeafBitmaps {
// `BinaryExpr::evaluate` + column/literal dispatch.
/// batch; delivered row `batch_offset + i` maps to RG position
        let left: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> =
        ctx.rg_idx = 3;
                            // selectors, so we walk the selection and map
            test_predicate_node(),
//
impl CollectorLeafBitmaps {
            if let Some(pp) = pruning_predicates.get(&key) {
            prune_tree_or(vec![
                &test_ctx(),
            // (exact bitmaps), inversion is safe.
            let mut iter = bm.iter();
            &tmp.reopen().unwrap(),
    }
            let mut rg_pos: i64 = 0;
            bm.insert_range(0u32..((ctx.max_doc - ctx.min_doc) as u32));
        let pruner = empty_pruner();
            cost_predicate: 1,
                // intersected with inherited ranges so nested ANDs never
                        ..ctx.clone()
                let rg_pos = match position_map.rg_position(batch_offset + i) {
        let candidates = prefetch_node(
                docs,
// kernels. Collector leaves read their cached bitmap from the side-table
        };
            ResolvedNode::Or(vec![
) -> Result<(), String> {
        let mut ctx = test_ctx();
                prune_tree_leaf(vec![true]),
            .unwrap();
    /// Deterministic bitmap source for tests.
    node: &ResolvedNode,
                return Ok(RoaringBitmap::new());
            map.get(&leaf_key).copied().unwrap_or(i32::MIN)
        assert_eq!(intersect_range_lists(&a, &a), vec![(10, 20), (30, 40)]);
    }
                                    }
            got,
            if self.forbidden.contains(&idx) {
            test_predicate_node(),
    #[test]
// the resulting per-row mask. Uses DataFusion's expression evaluator —
                        }
        }
    }
                    // and clamp to [0, span) since the scope bitmap only
        batch_len: usize,
    // correctly and `filter_record_batch` drops the UNKNOWN rows.
    }
    }
                dfs,
            .prefetch(
        }
    }
                &pruner,
        assert_eq!(
            b
    }
        PagePruner::new(
        )
        };
                .find_map(|(i, bm)| if *i == key { Some(bm) } else { None })
    }
    #[derive(Debug)]
                rg_first_row,
            let _ = leaf_idx; // predicate leaves don't need per-leaf storage
                    }
            unimplemented!(
    out: &mut Vec<(usize, RoaringBitmap)>,
        let mut forbidden = HashSet::new();
            _ => vec![(ctx.min_doc, ctx.max_doc)],
//! parquet rows to read at all* — for a selective query over a large RG,
        ResolvedNode::DelegationPossible { .. } => {
}
            batch_offset,
        assert!(
            2,
            // from anything non-exact (Predicate leaves use coarse page
        );
    #[test]
                None,
                &test_ctx(),
    }
                                        page_idx += 1;
        // Inner AND short-circuits on empty_leaf. NOT inverts empty to
                                            page_end += page_counts[page_idx];
                                        }
        }
    //
    #[test]
            .expect("AND should short-circuit on all-false acc, skipping poison leaf");
                        collector_call_ranges: ranges.clone(),
    /// ```
    out: &mut Vec<(usize, RoaringBitmap)>,
    #[test]
        let and_spt = prune_tree_and(vec![
        );
    /// `state.per_leaf` lookup (cached Phase 1 bitmaps), not the
            .unwrap();
                    ranges.push((
        ResolvedNode::Predicate(_) => {
    while i < a.len() && j < b.len() {
    use datafusion::parquet::arrow::arrow_reader::{
        ArrowReaderMetadata, ArrowReaderOptions, RowSelection, RowSelector,
            bm_a.is_empty(),
        page_prune_metrics: Option<&PagePruneMetrics>,
// Runs after parquet has delivered a decoded record batch. Walks the same
        ]);
            unimplemented!(
            ))
                .sort_by_key(|&i| subtree_cost(&children[i], ctx, page_pruner, pruning_predicates));
        let pruner = empty_pruner();
            ctx.cost_collector * COST_SCALE
// Tests
                ctx,
                None,
                ctx.min_doc + run_end as i32 + 1,
            // Enumerate set bits in `bm` within [anchor + batch_offset, anchor + batch_offset + batch_len).
                Some(col_arr) => {
    }
/// Intersect two sorted, non-overlapping range lists. Both inputs are
            prune_tree_leaf(vec![false]),
// definitively-all-false for AND and definitively-all-true for OR
        let bm1 = source.leaf_bitmap(&node, 0, &ctx1).unwrap();
fn evaluate_via_df(
            }
}
    ///
            let mut b = RoaringBitmap::new();
    let key = Arc::as_ptr(expr) as *const () as usize;
/// `Not` passes through to its child; `And`/`Or` sum their children.
            )
        let pm = PositionMap::from_selection(&sel);
        let pm = identity_pm(1);
        ResolvedNode::Collector { collector, .. } => {
            ]),
    #[test]
        // RG1: covers [100, 200). last_next_doc=150, so effective_min=max(150,100)=150.
/// Recursively compute the accumulated cost of a subtree for
use std::collections::HashMap;
        assert_eq!(mask.true_count(), 0);
///   Tune (or make config-driven) if profiling shows it matters.
            cost_predicate: 1,
        assert_eq!(
    fn cached_collector(bm: RoaringBitmap) -> (ResolvedNode, (usize, RoaringBitmap)) {
        let spt = prune_tree_and(vec![
            }
                        a &= &child_bitmap;
            rg_first_row: 0,
) -> Result<BooleanArray, String> {
            for &d in &self.docs {
            .leaf_bitmap(&node, 0, &mk_ctx(1, 100, 100, 200))
use roaring::RoaringBitmap;
            rg_can_match,
        // FullRange ignores the bitmap, returns [min_doc, max_doc)
        let a = vec![(10, 20), (30, 40)];
            Ok(CollectDocsResult {
        let mut allowed = HashMap::new();
                &tree,
            ctx.cost_predicate * COST_SCALE
            cost_predicate: 1,
    #[test]
                if let Some(ref bm) = result_bitmap {
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
    ///          /   \
        let nested = ResolvedNode::And(vec![
                    return Ok(BooleanArray::from(nulls));
    fn stats_prune_under_or_materialises_empty_bitmaps_for_collectors() {
        let ctx0 = RgEvalContext {
                None,
            &mut per_leaf,
            )
fn prefetch_node(
        // DFS order:
    #[test]
        // and we get the zero mask without erroring.
                    if total > 0 {
        // Docs 110, 120 relative to min_doc=100 → bits 10, 20.
                    let hi = end_rel.min(span);
/// - Collector = 10: requires materialising an actual doc-id bitset over
            }
    /// Same scenario but deeper — mirrors a query like:
            .unwrap();
        let mut bm = RoaringBitmap::new();
                "invariant violation: DelegationPossible reached collect_collector_leaves. \
        allowed.insert(0, RoaringBitmap::new()); // triggers short-circuit
                &test_ctx(),
            .map(|c| subtree_cost(c, ctx, page_pruner, pruning_predicates))
                                    } else if page_end <= seg_end {
            )?;
                    }
                    // Selector covers [rg_pos, rg_pos + s.row_count) in
    }
        batch_offset: usize,
                    result.words.len() * 8,
                };
        StatsPruneTree {
                                            page_start = page_end;
            result.per_leaf.len(),
                // Short-circuit: if every row is definitively true
        ResolvedNode::And(children) | ResolvedNode::Or(children) => {
    }
//!
    /// When `rg_idx` is an absolute index not present in the reverse map,
                &self,
            bitmaps: vec![bm(&[1, 2, 3, 4]), bm(&[3, 4, 5])],
///
        // RG1 [100,200): next_doc=200 >= max_doc=200 → skipped, no collect call.
            Operator::Eq,
            }
                None,
        }
        let result = BitmapTreeEvaluator
            let result = collector.collect_packed_u64_bitset(effective_min, *call_max)?;
        );
                &HashMap::new(),
        );
        let pruner = empty_pruner();
        assert!(
        }
    }
        if a[i].1 < b[j].1 {
            bitmaps: vec![
///   queries, slower for wide ones) so "10" is a conservative default.
                    out,
fn ranges_from_bitmap(bm: &RoaringBitmap, ctx: &RgEvalContext) -> Vec<(i32, i32)> {
    use std::collections::{HashMap, HashSet};
        // delivered idx 2 → rg_pos 2
pub struct CollectorLeafBitmaps {
        // coll3 (dfs=0) and coll2 (dfs=1) are real
                    }
    /// `WHERE (GoodEvent=1 AND Income>0 AND (match(T,'x') OR Age>18)) OR (match(S,'buy') AND CounterID>100)`
    struct FixedLeafBitmaps {
        /// The `next_doc` value to return from `collect_packed_u64_bitset`.
    fn next_doc_boundary_doc_not_dropped() {
        let bm2 = source
                bm(&[99]),
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
                None,
    #[test]
        }
    #[test]
// tree again — in original order this time, not cost-sorted — and combines
            min_doc: min,
        let node = collector_node_from_arc(mock.clone());
        assert_eq!(mask, expected);
    #[test]
                 Planner must drop performance peers under OR/NOT before fragment conversion."
                }
        // AND(OR(collector0, collector1), collector2)
                    out,
            &self,
            Arc::new(Literal::new(ScalarValue::Boolean(Some(true))));
                // OR(coll0, coll1)
    /// With `>=`, RG1 is skipped outright and doc 200 survives.
                // still FALSE in SQL 3VL. Safe to stop.
                None,
                }
    #[test]
            // (wrong for candidate stage).
    fn subtree_cost_leaf_nodes() {
        // Cost sort: collector2 (cost=10k) first, OR subtree (cost=20k) second.
        // NOT inverts empty AND → universe.
 * this file be licensed under the Apache-2.0 license or a
            prune_tree_or(vec![
        let calls = mock.call_args();
            .unwrap();
        let ctx = test_ctx();
            b.insert(8);
    }
        ]);
                Err(format!(
        let batch =
        let leaves = FixedLeafBitmaps {
            )
        ResolvedNode::Collector { .. } => false,
        ) -> Result<RoaringBitmap, String> {
                        Operator::Eq => eq(col_arr, &scalar),
    /// Construct a `CollectorLeafBitmaps` with no metrics.
                        ranges = Some(match ranges {
    }
    fn stats_prune_tree_offset_rg_idx_in_map_prunes_correctly() {
    fn not_collector_complements_against_universe() {
        let mut ctx = test_ctx();
        let bm_a = source.leaf_bitmap(&node_a, 0, &ctx1).unwrap();
                &test_ctx(),
            prune_tree_leaf(vec![false]),
            collector: Arc::new(Dummy),
            // Invariant: see prefetch_node arm. Same contract.
        // TightenOuterBounds: [min_doc + bm.min(), min_doc + bm.max() + 1)
/// it — no separate indexing required, so this impl is fully stateless.
                unreachable!("Phase 2 must not call collect")
    ctx: &RgEvalContext,
        let leaves = FixedLeafBitmaps {
        on_batch_node(
            "leaf B collector should be called for RG1"
        }
        //   So: coll2 dfs=0, then AND subtree (pruned): Predicate dfs=1, coll0 dfs=2, coll1 dfs=3
                _: i32,
            .prefetch(
        let pruner = empty_pruner();
                None,
            b
                optional_result_bitmap = Some(match optional_result_bitmap {
    fn bitmap_to_batch_mask_empty_bitmap_produces_all_false() {
            // kept selector covers a contiguous row range; insert it as
    let pruning_predicate = match pruning_predicates.get(&key) {
    }
    // the `LeafBitmapSource` for the remaining Collector leaves' bitmaps.
            )
            b.insert(9);
        assert_eq!(result.per_leaf.len(), 2);
/// Pulls the collector directly off the `ResolvedNode::Collector` passed to
            // The selection is RG-relative. Translate to min_doc-relative
    let result = remapped
            unimplemented!(
        allowed.insert(1, RoaringBitmap::new()); // empty → short-circuit
                if let Some(page_counts) = page_pruner.page_row_counts(ctx.rg_idx) {
            ));
//     empty entries in side-table so refinement doesn't panic.
                &leaves,
            subtree_cost(&test_predicate_node(), &ctx, &pruner, &pp),
            let Some(first) = iter.next() else {
        let tree = ResolvedNode::Not(Box::new(collector_leaf(0)));
    #[test]
            out.push((lo, hi));
        );
        let bm = {
    /// single `AtomicI32` because it tracks exactly one collector; a tree has
                }
                    child,
    ///   RG2 [200,300) match: doc 200 — boundary doc, must be collected
    ///
    // Convert batch-row index -> min-doc-relative bitmap index.
        let spt = prune_tree_and(vec![or_spt, prune_tree_leaf(vec![true])]);
                page_pruner,
        // RG indices [2,3,4] → map: {2→0, 3→1, 4→2}
                        or(&result_bitmap, &child_bitmap).map_err(|e| e.to_string())?
            fn collect_packed_u64_bitset(
        // delivered idx 4 → rg_pos 8
            *dfs += 1;
                Some(&spt),
                let bit = abs_doc - min_doc as i64;
//! expands index-backed `RowGroupDocsCollector` output into RoaringBitmaps.
    }
fn predicate_to_batch_mask(
            rg_num_rows: 100,
            .iter()
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
    BooleanArray::from(vec![false; n])
                let child_bitmap = on_batch_node(
    dfs: &mut usize,
            }
            idx: usize,
            for &i in &indices {
    }
    pruning_predicates: &HashMap<usize, Arc<PruningPredicate>>,
                &pruner,
    /// prefetched sequentially, so no two threads call `leaf_bitmap` on the same
/// panic on missing keys.
    }
        let lo = a[i].0.max(b[j].0);
                }
}
                    Some(mut a) => {
                &pruner,
        if let Some(&pos) = rg_index_to_pos.get(&ctx.rg_idx) {
    fn stats_prune_tree_none_evaluates_normally() {
                    ResolvedNode::Predicate(pred_expr),
    state: &TreePrefetch,
        let pruner = empty_pruner();
            .prefetch(
//!
    /// round-trip to Java per Collector leaf per RG. `None` for tests
        }
        ]);
    }
/// arithmetic, NOT-wrapped, …).
            std::sync::Arc::new(PhysColumn::new("x", 0));
pub(crate) fn subtree_cost(
    /// `poison_child` would `panic!` if evaluated. If the test passes,
        let bm1 = source.leaf_bitmap(&node, 0, &ctx1).unwrap();
            result.per_leaf.len(),
            cost_collector: 10,
        Ok(result_bitmap)
        let pm = identity_pm(16);
                let span = (ctx.max_doc - ctx.min_doc) as u32;
//
            pruning_predicates,
                &test_ctx(),
        let tree = ResolvedNode::Or(vec![collector_leaf(0), collector_leaf(1)]);
    /// Regression: when an AND subtree under an OR is stats-pruned because
            let key = Arc::as_ptr(collector) as *const () as usize;
                &test_ctx(),
            other => Err(format!(
        // delivered idx 0 → rg_pos 0
    #[test]
    /// For Phase 2 specifically, `ResolvedNode::Collector` uses
    /// Incremented once per call to [`Self::leaf_bitmap`] — one FFM
            min_doc: 0,
            })
            Ok(bitmap_to_batch_mask(
        }
                Some(&spt),
            let span = (ctx.max_doc - ctx.min_doc) as i64;
            }
        // [0,10) ∩ [5,15) → [5,10)
            "RG1 should be empty because next_doc > max_doc"
            result.per_leaf[2].1.is_empty(),
        let result = BitmapTreeEvaluator
        let mut per_leaf = Vec::new();
            prune_tree_leaf(vec![false]),
                &pruner,
fn all_false(n: usize) -> BooleanArray {
        assert_eq!(ranges_from_bitmap(&bm, &ctx), vec![]);
        ResolvedNode::And(cs) | ResolvedNode::Or(cs) => cs.iter().any(subtree_has_predicate),
            let key = Arc::as_ptr(collector) as *const () as usize;
    /// Stats prune: AND subtree → false (Predicate child proves no-match).
/// `position_map.rg_position(batch_offset + i)`.
        // Stats: outer AND[coll3=true, OR=true]
        assert_eq!(bm1.len(), 2);
                vec![(ctx.min_doc + lo as i32, ctx.min_doc + hi as i32 + 1)]
            1,
        let got: Vec<bool> = (0..6).map(|i| mask.value(i)).collect();
            }
                &pruner,
        let mut ctx = test_ctx();
            let map = self.leaf_to_next_doc_map.lock().unwrap();
    if let Some(spt) = stats_prune_tree {
    fn prune_tree_or(children: Vec<StatsPruneTree>) -> StatsPruneTree {
            out.push((key, bm));
            let child_bm = prefetch_node(
            )
mod tests {
            )
                &leaves,
        // coll3={5,6,7,8}; OR: inner AND pruned→empty, coll2={6,7,8}; OR={6,7,8}
        let leaves = FixedLeafBitmaps {
            mock.call_args().len(),
                            // Non-comparison op (And/Or/Plus/...) — fall
            bitmaps: vec![bm(&[1, 2, 3]), bm(&[3, 4, 5])],
            ranges
        ]);
    }
        let _ = idx;
                &pruner,
        );
            if max_doc <= min_doc {
    }
            Ok(optional_result_bitmap.unwrap_or_else(|| all_false(batch_len)))
    }
    let mut out = vec![0u64; words];
    use crate::indexed_table::index::CollectDocsResult;
        });
        assert_eq!(intersect_range_lists(&[(0, 20)], &[(5, 10)]), vec![(5, 10)]);
    }
            subtree_cost(&collector_leaf(0), &ctx, &pruner, &pp),
/// by this so integer division preserves meaningful selectivity differences.
//
                                        }
        // rg_first_row = 100, batch starts at offset 0, length 8.
/// a per-batch `BooleanArray`.
///   RoaringBitmap expansion on the Rust side. Relative cost is
        // empty bitmap via skip_dfs_with_empty_bitmaps (no FFM call).
//!        exact match set — this is what decides which parquet rows to read);
                    "BitmapTree: skipping subtree for RG {} — pruned by RG-level stats",
        let mask = on_batch_node(&tree, &state, &batch, 0, &identity_pm(4), 0, 4)
        // delivered idx 3 → rg_pos 7
        let pruner = empty_pruner();
        let leaves = PoisonLeafBitmaps { allowed, forbidden };
            let nulls: Vec<Option<bool>> = (0..batch.num_rows()).map(|_| None).collect();
    fn collector_node_from_arc(collector: Arc<dyn RowGroupDocsCollector>) -> ResolvedNode {
                    if delivered < batch_len {
            collector_call_ranges: None,
        ResolvedNode::Not(child) => collect_collector_leaves(child, ctx, leaves, dfs, out)?,
                    Some(result_bitmap) => {
            max_doc: 16,
    rg_first_row: i64,
            "leaf B should not skip: next_doc=50 < max_doc=200"
            .prefetch(
            candidates: RoaringBitmap::new(),
        let bm = RoaringBitmap::new();
        let bm = {
        calls: std::sync::Mutex<Vec<(i32, i32)>>,
            provider_key: 1,
//                   [ either via filter exec or filter pushdown ] tree walker
}
        }
            b
                let nulls: Vec<Option<bool>> = (0..batch.num_rows()).map(|_| None).collect();
// Evaluate an arbitrary boolean `PhysicalExpr` against a batch; return
            _ => {
            cost_collector: 10,
            _ctx: &RgEvalContext,
        // nextDoc from this leaf's previous collectDocs (i32::MIN = "no info yet").
        struct Dummy;
    #[test]
            candidates: RoaringBitmap::new(),
            for (r, v) in rg_can_match.iter_mut().zip(c.rg_can_match.iter()) {
// Short-circuit contract:
        StatsPruneTree {
            // a range in one call. `RoaringBitmap::insert_range` handles
                &HashMap::new(),
        Self::new(None)
            // Predicate on the Rust side). Reaching this arm means that contract
        let _ = source.leaf_bitmap(&node, 0, &ctx0).unwrap();
/// unavailable (no page index, expression not translatable, etc.).
        let pp = HashMap::new();
            collector_call_ranges: None,
            };
        //   idx 0 = standalone_leaf (evaluated first by cost sort),
                &HashMap::new(),
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
    }
            rg_first_row: first,
                bm(&[6, 7, 8]),
    }
    ///
    ///             /         \
            mock_a.call_args().len(),
        //   idx 2 = other_leaf (AND's second child — skipped).
            cost_collector: 10,
        } else {
    ctx: &RgEvalContext,
            b.insert(0);
                &pruner,
        )
                            // row offsets back to page boundaries.
            // Mirror the real FfmSegmentCollector empty-range shortcut: an empty
        let pruner = empty_pruner();
    /// position — matches the pre-block-granular full-scan behaviour and
            self.calls.lock().unwrap().clone()
    /// ```
        assert_eq!(result.candidates, bm(&[3, 4]));
            // was violated: a planner bug, not an evaluator gap. Fail loud so the
                    }
        ]);
                &tree,
            // Two cases :
            Ok(self.allowed.get(&idx).cloned().unwrap_or_default())
                "invariant violation: DelegationPossible reached subtree_has_predicate. \
        allowed.insert(0, RoaringBitmap::new()); // empty → trigger short-circuit
                "invariant violation: DelegationPossible reached subtree_cost. \
        ColumnarValue::Scalar(sv) => match sv {
            // space (the bitmap the tree evaluator walks over). Each
    use datafusion::parquet::arrow::ArrowWriter;
    /// the (min_doc, max_doc) arguments it was called with.
            // Invariant: see prefetch_node arm. Same contract: planner must
            bin.right().downcast_ref::<Literal>(),
                if result_bitmap.as_ref().unwrap().is_empty() {
                                        page_idx += 1;
        };
            }
        );
        pruning_predicates: &HashMap<usize, Arc<PruningPredicate>>,
        assert_eq!(mask.true_count(), 4);
            prune_tree_leaf(vec![true]),
        ctx.collector_strategy = super::super::CollectorCallStrategy::TightenOuterBounds;
                &HashMap::new(),
            "coll2 should have non-empty bitmap"
    // ── CollectorLeafBitmaps next_doc skip/tighten tests ─────────────
    stats_prune_tree: Option<&StatsPruneTree>,
            .leaf_bitmap(&node, 0, &mk_ctx(2, 200, 200, 300))
    fn ranges_full_range_strategy() {
            right,
        }
        assert_eq!(
    #[test]
    let mut bm = RoaringBitmap::new();
            bitmaps: vec![bm(&[1, 2]), bm(&[2, 3])],
        // coll0 (dfs=2) and coll1 (dfs=3) get empty bitmaps from pruned subtree
        };
        let sel = RowSelection::from(vec![
            } else {
            .clone()
                &HashMap::new(),
use std::sync::Arc;
            bitmaps: vec![bm(&[3, 4, 5]), bm(&[99]), bm(&[3, 4, 5, 6])],
        // AND(coll3, OR(AND(Predicate, OR(coll0, coll1)), coll2))
/// Derive collector call ranges from a bitmap based on the strategy in `ctx`.
            "leaf A should skip: next_doc=500 > max_doc=200"
        }
            // General case — fall back to per-row lookup but use packed-bit
// It's used only to assign a stable `leaf_dfs_index` to each leaf so a
                                    if !s.skip && row_offset < page_end && seg_end > page_start {
    #[test]
        Self {
            _ctx: &RgEvalContext,
        // Leaf B: next_doc=50 < 200 → not skipped, collector called.
    match node {
            let key = Arc::as_ptr(collector) as *const () as usize;
//!
                        }
            unimplemented!(
    ///
        bitmaps: Vec<RoaringBitmap>,
        // Use the narrowed call ranges if available (set by the AND evaluator
                &leaves,
        let got: Vec<bool> = (0..8).map(|i| mask.value(i)).collect();
        // offset = (150 - 100) = 50. doc 160 at bit (160-150)=10 placed at 50+10=60.
                ResolvedNode::Or(vec![collector_leaf(0), collector_leaf(1)]),
            )
        let bm_b = source.leaf_bitmap(&node_b, 1, &ctx1).unwrap();
                &leaves,
    // The symmetric case (AND under OR/NOT) must still materialise.
        );
            // Sub-ranges are ascending; carry the freshest next_doc forward so a
            };
            result_bitmap |= chunk;
        let node = collector_node_from_arc(mock.clone());
                                let seg_end = row_offset + s.row_count;
                &HashMap::from([(0, 0)]),
    // For Identity position map, rg_position(k) == k, so the mapping is
    expr: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
        let or_spt = prune_tree_or(vec![inner_and_spt, prune_tree_leaf(vec![true])]);
            prune_tree_leaf(vec![false]),
        let pruner = empty_pruner();
        // Final AND = {5,6,7,8} ∩ {6,7,8} = {6,7,8}
                            // Count pages with at least one selected row.
    }
            bitmaps: vec![bm(&[10, 11, 12]), bm(&[3, 4])],
    ///        AND    coll2
                let child_bitmap = on_batch_node(
        let pruner = empty_pruner();
        // rel_doc = abs_doc - min_doc = i. bits set at i=1 and i=5.
        assert_eq!(got, vec![false, false, true, false, true, false]);
                &tree,
        bm.insert_range(4..8);
        // skipping [3..7]. Delivered rows = 6 (3 + 3).
// Walks the resolved tree to produce the top-level superset RoaringBitmap
                }
                )
            .unwrap();
                < subtree_cost(&single_collector, &ctx, &pruner, &pp),
    }
        let pruner = empty_pruner();
            children,
        let single_collector = collector_leaf(0);
                        out[delivered >> 6] |= 1u64 << (delivered & 63);
        assert!(result.candidates.is_empty());
        // OR contributes {5} from standalone_leaf → non-empty candidates.
    fn subtree_cost_predicate_heavy_nested_beats_single_collector() {
) -> RoaringBitmap {
        let mock = Arc::new(NextDocMockCollector::new(vec![5, 200], 200));
                        bm.insert_range(lo as u32..hi as u32);
    // ── ranges_from_bitmap unit tests ───────────────────────────────
        use datafusion::common::ScalarValue;
/// short-circuit or stats-prune) — entries ensure refinement doesn't
            b
    /// RG2, i.e. exactly RG1's exclusive max_doc.
            !bm_b.is_empty(),
    page_pruner: &PagePruner,
        //   idx 1 = empty_leaf (AND's first child),
        // The mock returns docs in [0,100) that match — none do, so empty.
        ResolvedNode::And(children) => {
            let num_docs = (*call_max - effective_min) as u32;
            // NOT yield a superset of the true NOT — it yields a subset
            4,
//!
                    run_start = bit;
        });
            prune_tree_leaf(vec![true]),
    /// Helper: build a ResolvedNode::Collector wrapping a given Arc collector.
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
        (node, (key, bm))
            bitmaps: vec![bm(&[1, 2, 3]), bm(&[2, 3, 4])],
            for bit in iter {
        // Register ONLY the false leaf. If short-circuit misfires, Phase 2
        let source = CollectorLeafBitmaps::without_metrics();
        bm.insert_range(4..8);
        // Persist this leaf's advanced position for subsequent row groups.
                skip_dfs_with_empty_bitmaps(node, dfs, out);
                "predicate evaluation produced non-boolean scalar: {:?}",
            rg_first_row: 100,
            rg_num_rows: 100,
            !result.per_leaf[0].1.is_empty(),
    }
    fn stats_prune_tree_offset_rg_idx_not_in_map_does_not_prune() {
                batch_offset,
            ],
                    }
        let leaves = FixedLeafBitmaps {
            collector,
    let words = batch_len.div_ceil(64);
    #[test]
            let mut run_start = first;
            .unwrap();
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
        // AND = {3,4,5} ∩ {3,4,5,6} = {3,4,5}
        }
            .prefetch(
            .prefetch(
        fn call_args(&self) -> Vec<(i32, i32)> {
    fn bitmap_to_batch_mask_handles_batch_offset_within_rg() {
    }
            leaves,
    fn ranges_tighten_outer_bounds_strategy() {
            max_doc: i32,
            .unwrap();
        assert_eq!(result.candidates, bm(&[5, 6, 7]));
        ResolvedNode::And(children) | ResolvedNode::Or(children) => children
            "expected 3 per_leaf entries; got {}",
                .ok_or_else(|| format!("Phase 2: leaf bitmap missing for key {:#x}", key))?;
            // stored next_doc to i32::MAX and drop later matches.
                    let total = page_counts.len() as u32;
            }
            }
    /// The strategy: construct AND(all_false_child, poison_child) where
    }
        // Universe is [0, 16). Minus {0,1,2} = {3..15}
        let ctx = test_ctx();
/// compute the absolute doc id and look it up in `bm`.
            test_predicate_node(),
            // stats), fall back to the full universe and let refinement pick
        // Leaf A: next_doc=500 > 200 (call_max) → skipped, empty bitmap.
//! children in their *original* tree order, which is fine because Arrow
/// General-case evaluator — `expr.evaluate(batch)` with schema-drift
    /// Mock collector that returns configurable docs and next_doc, and records
        ) {
                let lo_u32 = lo as u32;
            !result.per_leaf[1].1.is_empty(),
                    if !bm.is_empty() {
                words,
/// For `Predicate` leaves with a matching `PruningPredicate`, the cost
    fn collector_leaf(idx: usize) -> ResolvedNode {
    }
        let leaf_key = Arc::as_ptr(collector) as *const () as usize;
use super::{LeafBitmapSource, RgEvalContext, TreeEvaluator, TreePrefetch};
            let child_bitmap = on_batch_node(
                &tree,
    fn intersect_one_contains_other() {
    fn or_of_two_collectors_unions_phase1() {
//! stats, external bitmap stores, or anything else implementing the trait.
    // ── Phase 2 short-circuit ─────────────────────────────────────────
                    state,
        let mut map = self.leaf_to_next_doc_map.lock().unwrap();
    // under AND proved no match — collector bitmaps are irrelevant.
        /// Records each (min_doc, max_doc) invocation.
                &leaves,
            j += 1;
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
                .per_leaf
}
        ResolvedNode::Collector { collector, .. } => {
        let mut next_doc_out = last_next_doc;
/// `TreePrefetch` value threaded through `RowGroupBitsetSource`.
                &leaves,
            min_doc: 0,
            // strip performance peers under OR/NOT.
            bitmaps: vec![bm(&[5, 6, 7]), bm(&[99]), bm(&[99]), bm(&[99])],
    fn test_predicate_node() -> ResolvedNode {
        ]);
// Fast-path for `col OP literal` comparisons: skip the expression walk
                &tree,
        ]);
            rg_idx,
                    stats_prune_tree.and_then(|spt| spt.children.get(i)),
        }
    min_doc: i32,
/// candidate stage. Tuning knobs, not a hard contract.
    }
use datafusion::arrow::record_batch::RecordBatch;
use datafusion::arrow::compute::kernels::cmp::{eq, gt, gt_eq, lt, lt_eq, neq};
        batch: &RecordBatch,
    rg_first_row: i64,
            Ok(self.bitmaps[idx].clone())
    let batch_schema = batch.schema();
    }
            result.per_leaf[1].1.is_empty(),
                &leaves,
            )
                &tree,
            rg_index_to_pos,
        impl RowGroupDocsCollector for Poison {
                    child,
/// Falls back to the static `cost_predicate * COST_SCALE` when page stats are
    // row. Return an all-NULL BooleanArray so kleene AND/OR combine
        CollectorCallStrategy::FullRange => vec![(ctx.min_doc, ctx.max_doc)],
//!    come from page-level stats and are inherently coarse (pages are
            for (r, v) in rg_can_match.iter_mut().zip(c.rg_can_match.iter()) {
    ) -> Result<BooleanArray, String> {
        let pred_expr: Arc<dyn datafusion::physical_expr::PhysicalExpr> =
        let pp = HashMap::new();
                rg_index_to_pos,
                            // RowSelection merges adjacent same-decision
    }
            // later sub-range skips/tightens on the position the iterator has
        }
        bm.insert_range(2..5); // bits 2,3,4
                None,
            cost_predicate: 1,
            max_doc: 200,
        ResolvedNode::Collector { .. } => ctx.cost_collector * COST_SCALE,
            .unwrap();
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
            prune_tree_leaf(vec![true]),
    use super::*;
            let leaf_idx = *dfs;
    ///
    ///              Predicate  OR(coll0, coll1)
                &HashMap::from([(0, 0)]),
            .unwrap();
                skip_dfs_with_empty_bitmaps(c, dfs, out);
    /// ```text
        );
///   workload-dependent (Lucene posting iteration is fast for narrow
                page_prune_metrics,
    match result {
                                    } else {
        let spt = prune_tree_and(vec![
        }
        stats_prune_tree: Option<&StatsPruneTree>,
        }
            left,
        assert_eq!(
        let mask = BitmapTreeEvaluator
            leaf_to_next_doc_map: std::sync::Mutex::new(HashMap::new()),
                &HashMap::new(),
                &rg_map,
                Ok(BooleanArray::from(vec![b; batch.num_rows()]))
            out.push((key, RoaringBitmap::new()));
//! Why two stages and not one: Phase 1's bitmap-domain work decides *which
        let source = CollectorLeafBitmaps::without_metrics();
        bm.insert(14); // bit 14
    let selection = page_pruner.prune_rg(pruning_predicate, ctx.rg_idx, page_prune_metrics);
                            for s in sel.iter() {
    // ── intersect_range_lists unit tests ────────────────────────────
//!    Collector leaves ask an external [`LeafBitmapSource`] for their bitmap
    #[test]
        // DFS: coll3=0, coll2=1, Predicate=2, coll0=3, coll1=4
    /// Collector leaves inside the same subtree must still get empty bitmap
// (keyed by `Arc::as_ptr(collector)`, which is stable across the cost-sort
    use datafusion::arrow::array::Int32Array;
            )),
        ]);
        let _ = source.leaf_bitmap(&node_b, 1, &ctx0).unwrap();
                &pruner,
    }
            collector_leaf(2),
        // candidate" — return a full-range bitmap so AND/OR with other
                            None => new,
                page_prune_metrics,
///
        }
            result.per_leaf.len()
    }
    }
            .unwrap();
        },
            per_leaf: vec![true_entry],
    }
    ///         coll3          OR
        for c in &children {
            // the operator's backend and the resolver unwraps it natively (plain
        let bm0 = source.leaf_bitmap(&node, 0, &ctx0).unwrap();
        // delivered idx 1 → rg_pos 1
    fn ranges_page_range_split_empty_bitmap() {
/// are evaluated first in AND nodes, producing tighter ranges for
        let ctx0 = RgEvalContext {
                       // Three contiguous runs → three ranges
    }
}
        let mut ctx = test_ctx();
/// Cost weights used by `subtree_cost` to order AND/OR children in the
/// candidate-stage ordering.
                &tree,
            .collector_call_ranges
        ResolvedNode::Not(child) => skip_dfs_with_empty_bitmaps(child, dfs, out),
                });
            Ok(bm)
                &rg_map,
        &self,
        assert_eq!(
///   FFM — posting-list iteration on the Java side, bitset transport +
                &HashMap::new(),
        ctx.collector_strategy = super::super::CollectorCallStrategy::FullRange;
    }
    pruning_predicates: &HashMap<usize, Arc<PruningPredicate>>,
                &self,
                    batch,
        let mock = Arc::new(NextDocMockCollector::new(vec![160, 170], 150));
        assert_eq!(
            let num_docs = (max_doc - min_doc) as usize;
        }
        }
                            let mut kept_pages = 0u32;
                *r |= v;
                None,
            }
                        a
) {
            bitmaps: vec![bm(&[1, 2, 3, 4]), bm(&[3, 4, 5])],
    ///   Predicate  OR(coll0, coll1)
        let batch = RecordBatch::try_new(
fn collect_collector_leaves(
        let leaves = PoisonLeafBitmaps { allowed, forbidden };
                    dfs,
    /// range sits below this value has no matches for the leaf and is skipped
            for s in sel.iter() {
    let remapped = super::remap_expr_to_batch(expr, batch)?;
        let ctx1 = RgEvalContext {
    #[test]
        }
    node: &ResolvedNode,
        let ctx = test_ctx();
        let mut ctx = test_ctx();
//!    doc IDs for the RG. Works entirely in the RoaringBitmap domain:
        assert!(
        let leaves = FixedLeafBitmaps {
                    rg_index_to_pos,
//!    Predicate leaves re-evaluate the comparison on actual column data.
        forbidden.insert(2); // must NOT be called — AND is dead
    fn intersect_empty_with_anything() {
    }
        let leaves = FixedLeafBitmaps {
        ctx.rg_idx = 5;
        assert_eq!(
        let tree = ResolvedNode::And(vec![false_leaf, poison_leaf]);
        });
        // Both entries present (other_leaf has empty bitmap from skip).
        ResolvedNode::Predicate(std::sync::Arc::new(BinaryExpr::new(
}
//
        let mut forbidden = HashSet::new();
// handles all operators, IN, IS NULL, LIKE, arithmetic, CAST, UDFs etc.
            b.insert(999);
                &leaves,
        },
            }
        let leaves = FixedLeafBitmaps {
        };
        ]);
                if !s.skip {
        // other_leaf (idx 2) gets an empty bitmap from skip_dfs_with_empty_bitmaps
            bm2.contains(0),
    // Schema drift: if the expression references any column not present
fn on_batch_node(
                    // Column absent from batch schema: SQL UNKNOWN.
                &tree,
                other
        };
            Ok(optional_result_bitmap.unwrap_or_else(|| all_true(batch_len)))
                &HashMap::new(),
        );
        assert_eq!(
    // RG-level subtree pruning: if this subtree provably can't match
            }
            rg_first_row,
                &test_ctx(),
            &self,
    let anchor = rg_first_row - min_doc as i64; // rg_pos -> bit: rg_pos + anchor
//! Predicate-dominated nested subtree — short-circuit a whole AND group
            bitmaps: vec![bm(&[1, 2]), bm(&[3, 4]), bm(&[5, 6])],
            ctx,
        assert_eq!(ranges_from_bitmap(&bm, &ctx), vec![(4, 8)]);
// walks in original order), but `Arc` identity is stable across both. See
        ResolvedNode::Predicate(expr) => {
                &leaves,
        // Not pruned — both collectors contribute.
        assert!(
        );
    }
        // get empty bitmaps from skip_dfs_with_empty_bitmaps (no FFM calls).
                &leaves,
    }
// per-row BooleanArrays using Arrow's 3VL-safe `and_kleene`/`or_kleene`/`not`
        // RG0: covers [0, 100). Collector returns next_doc=500.
        let mut rg_can_match = vec![false; children[0].rg_can_match.len()];
                universe.insert_range(0..span);
        // "leaf bitmap missing". If short-circuit fires, poison is skipped
    fn subtree_cost_not_passes_through() {
    #[test]
                let mut universe = RoaringBitmap::new();
        fn leaf_bitmap(
/// Walk a subtree materializing Collector bitmaps without combining into
        let wrapped = ResolvedNode::Not(Box::new(test_predicate_node()));
    batch_offset: usize,
    fn phase2_and_short_circuits_on_all_false() {
                };
            .unwrap();
 * The OpenSearch Contributors require contributions made to
//!    supersets of the rows that actually match the predicate).
                // still TRUE in SQL 3VL. Safe to stop.
                }
            collector,
            rg_idx: 1,
    /// returned by that leaf's last `collectDocs` call. A later RG whose whole
            rg_first_row: 0,
                bm(&[99]),
            .prefetch(
                &HashMap::new(),
/// - `PageRangeSplit`: returns contiguous runs of set bits as absolute ranges.
            prune_tree_leaf(vec![true, true, true]),
                )?;
                &HashMap::new(),
                Some(&spt),
            "pruned coll1 should have empty bitmap"
                        collect_collector_leaves(&children[j], ctx, leaves, dfs, out)?;
        assert_eq!(ranges_from_bitmap(&bm, &ctx), vec![(4, 13)]);
            let mut ranges: Option<Vec<(i32, i32)>> = ctx.collector_call_ranges.clone();
        ResolvedNode::And(children) => {
    /// "leaf bitmap missing for key".
        writer.close().unwrap();
                });
/// A predicate keeping 1/8 pages costs `1000 * 1/8 = 125` vs one keeping
//!    (today that means an FFM upcall to the Java-side index). Predicate
            .prefetch(
        // rg_idx=3 → pos=1 → root rg_can_match[1] = false (from AND) → pruned
//!
        map.insert(leaf_key, next_doc_out);
                prune_tree_leaf(vec![true]),
    fn bitmap_to_batch_mask_anchors_correctly() {
        assert!(!result.candidates.is_empty());
            collector_leaf(2),
//!      - a top-level `RoaringBitmap` of candidate doc IDs (superset of the
    #[test]
    }
            Self {
        let mock = Arc::new(NextDocMockCollector::new(vec![110, 120, 130], 500));
//!    leaves use parquet page statistics via the caller's [`PagePruner`].
                &HashMap::from([(0, 0)]),
        let rg_map = HashMap::from([(0usize, 0usize)]);
                &pruner,
                    }
    // Substrait-decoded predicates carry indices into the full table schema;
            .sum(),
        let nested = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
    node: &ResolvedNode,
        }
        // For each row i: rg_pos = i, abs_doc = 100 + i,
        // Cost sort at root AND: coll3(10) before OR(10+1+20=31)
        );
            .prefetch(
        assert_eq!(mask.len(), 5);
        ResolvedNode::Not(child) => {
                                while page_idx < total as usize {
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int32, false)]));
    /// the subtree must NOT be pruned (conservative: can-match). This
            return Ok(RoaringBitmap::new());
        // Bitmap contains docs 160 and 170 at correct RG-relative positions.
        let got: Vec<bool> = (0..4).map(|i| mask.value(i)).collect();
            prune_tree_leaf(vec![false]), // Predicate
            // The Java planner narrows performance peers off any AnnotatedPredicate
            .prefetch(
                        skip_dfs_with_empty_bitmaps(&children[j], dfs, out);
        // Collector was NOT called for RG1 — still only 1 total call.
/// Internal scale factor for cost computation. All costs are multiplied
    // in this batch's schema, SQL semantics demand UNKNOWN for every
        }
            mock.call_args().len(),
                None,
        let collector: Arc<dyn RowGroupDocsCollector> = Arc::new(Poison);
                ]),
        let bm0 = source.leaf_bitmap(&node, 0, &mk_ctx(0, 0, 0, 100)).unwrap();
    }
            not(&child_bitmap).map_err(|e| e.to_string())
            ctx.cost_predicate * COST_SCALE
}
        }
        assert_eq!(result.candidates, bm(&[6, 7, 8]));
            let mut bm = RoaringBitmap::new();
            children: vec![],
fn all_true(n: usize) -> BooleanArray {
        let spt = prune_tree_or(vec![
                let hi_u32 = hi.min(u32::MAX as i64) as u32;
use datafusion::logical_expr::{ColumnarValue, Operator};
            collector_leaf(0),
        let pruner = empty_pruner();
        if let (Some(col), Some(lit)) = (
    packed_bits_to_boolean_array(out, batch_len)
    fn candidate_and_short_circuit_under_or_skips_ffm() {
                    ctx.clone()
        }
//! `BitmapTreeEvaluator` — the default [`TreeEvaluator`] implementation.
        assert_eq!(intersect_range_lists(&[], &[(0, 10)]), vec![]);
        // upper bound means no match in that range, so we compare with `>=`.
    page_prune_metrics: Option<&PagePruneMetrics>,
) -> Result<BooleanArray, String> {
                                        if page_idx < total as usize {
                &test_ctx(),
            let mut ranges = Vec::new();
        // universe → candidates non-empty → RG read. other_leaf gets an
        }
        let tree = ResolvedNode::And(vec![
/// the parent accumulator. Used at the OR saturation short-circuit: the
            let hi = (batch_offset as i64 + anchor + batch_len as i64).max(0);
        let pruner = empty_pruner();
        };
        };
                "invariant violation: DelegationPossible reached the Tree-path evaluator. \
            *dfs += 1;
            prune_tree_leaf(vec![false]), // Predicate stats=false
            rg_num_rows: 100,
        }
            )
                        Operator::Lt => lt(col_arr, &scalar),
            ]),
        assert!(
        // Expected mask per delivered index: [F,F,T,F,T,F]
            if let Some(ref c) = self.ffm_collector_calls {
    }
        assert!(
                None,
/// - Predicate = 1: page-stats-only, no I/O, a handful of array lookups.
                                        kept_pages += 1;
    /// LeafBitmapSource. So short-circuit observation has to be at the
                pruning_predicates,
        .unwrap();
            vec![(3, 5), (10, 12), (15, 20), (30, 35)]
            datafusion::common::ScalarValue::Boolean(None) => {
    use crate::indexed_table::bool_tree::ResolvedNode;
                None,
                 Planner must drop performance peers under OR/NOT before fragment conversion."
    /// Build a ResolvedNode::Collector whose cached Phase 1 bitmap is `bm`.
        );
            let mut b = RoaringBitmap::new();
}
        let _ = source.leaf_bitmap(&node_a, 0, &ctx0).unwrap();
        };
            indices
        assert_eq!(mock_a.call_args().len(), 1);
        assert!(
            b.insert(1);
        // Docs at 160, 170 — both within the tightened range [150, 200).
    };
            BooleanArray::from(vec![false, true, false, true, false, true, false, false]);
                        Operator::NotEq => neq(col_arr, &scalar),
                let child_bitmap = prefetch_node(
            .on_batch(&tree, &state, &batch, 0, &pm, 0, 8)
        );
        let pp = HashMap::new();
    leaf_to_next_doc_map: std::sync::Mutex<HashMap<usize, i32>>,
        ResolvedNode::Or(children) => {
            cost_collector: 10,
    use crate::indexed_table::index::RowGroupDocsCollector;
    fn stats_prune_tree_and_child_false_short_circuits() {
        };
                    if result_bitmap.null_count() == 0 && result_bitmap.false_count() == 0 {
            match batch.column_by_name(col.name()) {
            let mut indices: Vec<usize> = (0..children.len()).collect();
    // ── StatsPruneTree subtree pruning in prefetch ─────────────────────
            .unwrap();
        let pruner = empty_pruner();
        assert_eq!(result.candidates, bm(&[1, 2, 3]));
                // Short-circuit: if every row is definitively false
        let state = TreePrefetch {
    }
                    batch_len,
        let ctx = test_ctx();
            let mut b = RoaringBitmap::new();
        // after earlier children shrink the candidate set). Each range
/// In-process Rust `TreeEvaluator`. Stateless — all per-RG state lives in the
            // otherwise tighten its lower bound so collectDocs skips the empty prefix.
                    ctx.rg_idx
    }
            schema.clone(),
                        ctx.min_doc + run_end as i32 + 1,
                if let Some(ref result_bitmap) = optional_result_bitmap {
            1,
            _tree: &ResolvedNode,
            *dfs += 1;
//! walking (cheap-first), which lets a narrow Predicate leaf — or a
                &tree,
        let (poison_leaf, _) = cached_collector({
                }
                *r &= v;
    #[test]
        }
        }
    fn candidate_root_and_short_circuit_skips_forbidden_collector() {
        ResolvedNode::Not(child) => {
//!    the tree once, producing:
        allowed: HashMap<usize, RoaringBitmap>,
        let mask = bitmap_to_batch_mask(&bm, 0, 0, &pm, 4, 4);
                    Some(result_bitmap) => {
        let ctx = test_ctx();
        assert!(bm_b.contains(10));
                    let lo = start_rel.max(0);
        collector_node: &ResolvedNode,
                Ok(universe)
        ctx: &RgEvalContext,
        tree: &ResolvedNode,
        });
                &leaves,
        // min_doc = 0, rg_first_row = 0, batch starts at rg offset 4, len 4.
            }
        };
            RowSelector::skip(4),
                &HashMap::new(),
// plus the per-leaf bitmap side-table.
        let bm = RoaringBitmap::new();
    /// that don't care about metrics.
        let mut writer = ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), None).unwrap();
            cost_predicate: 1,
    // Fast-path: detect `col OP literal` and call the kernel directly.
        assert!(result.candidates.is_empty());
            b.insert_range(0..4);
    /// resulting in an empty bitmap for RG1.
        let result = BitmapTreeEvaluator
    position_map: &PositionMap,
            b.insert(5);
        }
fn skip_dfs_with_empty_bitmaps(
    fn intersect_identical() {
                    // since we know all bits are matching.
                        let new = ranges_from_bitmap(bm, ctx);
    /// `Sync`. `RefCell` is `!Sync` and won't compile under that bound; `Mutex`
//!    compact, cheap intersections, O(set-bits) operations. The stage walks
            fn collect_packed_u64_bitset(
                    run_end = bit;
            if let Some(&false) = spt.rg_can_match.get(pos) {
    #[test]
                &pruner,
        // No pruning predicate available (schema mismatch at build time, or
        assert_eq!(mock.call_args().len(), 1);
    batch: &RecordBatch,
            // sort the children by cost to prune children better
    fn ranges_page_range_split_contiguous() {
        let result = BitmapTreeEvaluator
    /// `rg_can_match[pos] == false`, the subtree is correctly pruned.
            cost_predicate: 1,
//!      - a side-table of per-leaf bitmaps, keyed by Collector leaf identity.
                &leaves,
        let mut rg_can_match = vec![true; children[0].rg_can_match.len()];
        // collector2 (dfs=0) → {3,4,5}; OR-child1 (dfs=2) → {3,4,5,6}; OR = {3,4,5,6}
        let schema = Arc::new(Schema::new(vec![Field::new("x", DataType::Int32, false)]));
            test_predicate_node(),
                &ctx,
            // range yields no words and reports the scorer as exhausted. A skip
            }
    /// Leaf A returns next_doc=500, leaf B returns next_doc=50.
            children,
    }
        );
                &HashMap::new(),
            }
            let mut result_bitmap = RoaringBitmap::new();
    ) -> Result<RoaringBitmap, String> {
    /// RG, so it can't take `&mut self`.
            let mut optional_result_bitmap: Option<BooleanArray> = None;
    /// used to observe Phase 2 short-circuit by wrapping predicate leaves as
        assert!(
    page_pruner: &PagePruner,
        }
/// - `FullRange`: returns `[(min_doc, max_doc)]` (no narrowing).
                }
        ctx.collector_strategy = super::super::CollectorCallStrategy::PageRangeSplit;
                        Operator::Gt => gt(col_arr, &scalar),
                Some(&spt),
        // without calling leaf_bitmap (the forbidden set verifies this).
                None,
        };
            bitmaps: vec![bm(&[1, 2, 3]), bm(&[99])],
    // linear: delivered row i -> bit (rg_first_row + batch_offset + i) - min_doc.
                > subtree_cost(&single_collector, &ctx, &pruner, &pp)
                .sort_by_key(|&i| subtree_cost(&children[i], ctx, page_pruner, pruning_predicates));
        let result = BitmapTreeEvaluator
                &tree,
            ) -> Result<CollectDocsResult, String> {
                ctx,
                 Planner must drop performance peers under OR/NOT before fragment conversion."
                &tree,
        let pm = identity_pm(8);
        let tree = ResolvedNode::And(vec![
                            return evaluate_via_df(batch, expr);
            let mut b = RoaringBitmap::new();
///
        forbidden.insert(1); // any call for leaf 1 panics
        ]);
        for c in &children {
            std::sync::Arc::new(Literal::new(ScalarValue::Int32(Some(0))));
                }
                    result.words.as_ptr() as *const u8,
            .unwrap();
            let effective_min = next_doc_out.max(*call_min);
        let (poison_leaf, _poison_entry) = cached_collector({
        };
        assert_eq!(result.candidates, bm(&[3, 4]));
            &self,
        // Whole RG is past the next match → no FFM call needed.
//! (wrong, since predicate stats are supersets).
        // - Leaves are cost-equal, stable-sort preserves input order; so
/// making FFM calls. Used when a subtree is provably dead (AND
                None,
    ///                    /   \
                } else {
        // AND(all_false_leaf, poison_leaf). The poison leaf's bitmap is
        let mask = bitmap_to_batch_mask(&bm, 0, 0, &pm, 0, 6);
                collect_collector_leaves(child, ctx, leaves, dfs, out)?;
                batch_len,
        // All 3 collector leaves have per_leaf entries. The key difference:
            }
    bm
    fn stats_prune_tree_or_skips_false_child() {
        ResolvedNode::DelegationPossible { .. } => {
        // Identity position map over rg_num_rows=16.
        let hi = a[i].1.min(b[j].1);
    #[test]
        let pp = HashMap::new();
    batch_len: usize,
            if arr.data_type() == &datafusion::arrow::datatypes::DataType::Boolean {
        let result = BitmapTreeEvaluator
                Some(&spt),
                    None => continue,
    }
        assert_eq!(
///
    /// We can't directly inspect Phase 2 calls since they go through
                if bit >= 0 && bit <= u32::MAX as i64 && bm.contains(bit as u32) {
                &HashMap::new(),
    for col in &referenced {
            page_prune_metrics,
        assert!(bm1.is_empty(), "RG1 has no matches");
        let pruner = empty_pruner();
        let ctx1 = RgEvalContext {
            max_doc: 200,
        let tree = ResolvedNode::Or(vec![true_leaf, poison_leaf]);
        let or_spt = prune_tree_or(vec![
        assert_eq!(result.candidates.len(), 16);
            )
    fn phase2_or_short_circuits_on_all_true() {
        let state = TreePrefetch {
        let spt = prune_tree_and(vec![
                _: i32,
                None,
            return Ok(BooleanArray::from(nulls));
    /// `on_batch_node` level — we use a custom node tree and assert on the
            // against a stale/sentinel next_doc dragging it backward.
            Arc::new(Literal::new(ScalarValue::Boolean(Some(true))));
                out,
        if last_next_doc >= ctx.max_doc {
        ctx: &RgEvalContext,
//!    Phase 1 bitmap from the side-table and slice it to batch coordinates;
    match node {
fn bitmap_to_batch_mask(
                state.min_doc,
    ///
        // RG0: covers [0, 100). Both leaves are called.
                    leaves,
            // Candidate-stage is a superset. Inverting a superset does
        };
        let leaves = FixedLeafBitmaps {
            meta.schema(),
                // upcalls) so refinement can look them up without panic.
            ]),
        // the entire range is skipped — collector should NOT be called again.
    fn subtree_cost_sums_children() {
        // Verify the collector was called for RG0.
        let leaves = FixedLeafBitmaps {
        let pm = identity_pm(5);
                leaves,
    /// LeafBitmapSource returning bitmaps by DFS index, panicking on forbidden indices.
        }
        let call_ranges = ctx
    // delivered row i -> rg_position(batch_offset + i) -> abs_doc -> bit.
    fn test_ctx() -> RgEvalContext {
            let upper = offset + num_docs;
        &self,
                        Operator::GtEq => gt_eq(col_arr, &scalar),
    #[test]
    use super::CollectorCallStrategy;
        // All 3 collector leaves have per_leaf entries. coll0 and coll1
        // produces one FFM call; results are merged into one bitmap in
            stats_prune_tree,
    fn subtree_cost_collector_heavy_nested_exceeds_single_collector() {
        // will try to look up `poison_entry` and fail with "leaf bitmap missing".
        let result = BitmapTreeEvaluator
                batch_len,
            *dfs += 1;
                    break;
            let mut b = RoaringBitmap::new();
    fn intersect_partial_overlap() {
                next_doc,
        };
                                        // Advance to next page to avoid double-counting.
            result.per_leaf[2].1.is_empty(),
    /// ```text
            subtree_cost(&tree, &ctx, &pruner, &pp),
    match ctx.collector_strategy {
                &HashMap::from([(0, 0)]),
                &HashMap::new(),
// used in the candidate stage). Predicate leaves evaluate the actual
        // Use narrowed call ranges if available (set by AND evaluator).
            "leaf A collector should not be called for RG1"
        PositionMap::from_selection(&RowSelection::from(vec![RowSelector::select(rg_num_rows)]))
            // assembly so we avoid the Vec<bool> + BooleanArray::from copy.
        let bm = {
                c.add(1);
                &HashMap::new(),
    }
    fn prune_tree_leaf(can_match: Vec<bool>) -> StatsPruneTree {
    match position_map {
        let collector = match collector_node {
        let spt = prune_tree_and(vec![prune_tree_leaf(vec![true]), or_spt]);
        let mut bm = RoaringBitmap::new();
            "expected 3 per_leaf entries; got {}",
    /// The inner AND subtree is stats-pruned (Predicate proves no-match).
/// - `TightenOuterBounds`: returns `[(first_set + min_doc, last_set + min_doc + 1)]`.
            let mut indices: Vec<usize> = (0..children.len()).collect();
    fn bitmap_to_batch_mask_zero_length_batch() {
                 Planner must drop performance peers under OR/NOT before fragment conversion."
            rg_idx: 0,
        let ctx1 = RgEvalContext {
}
            // RG-relative offset so bit k maps to absolute doc effective_min + k.
}
use datafusion::physical_optimizer::pruning::PruningPredicate;
                None,
                    pruning_predicates,
        bm.insert_range(4..8);
    #[test]
                let mut universe = RoaringBitmap::new();
                    state,
        ])));
                    // If all values match, then result bitmap length will be
        // delivered idx 5 → rg_pos 9
/// universe subtraction. See the `Not` arm in `prefetch_node` for why.
                    batch_offset,
    if let Some(bin) = expr.downcast_ref::<BinaryExpr>() {
                &HashMap::new(),
    fn on_batch(
                });
    }
        }
    Ok(())
}
        .unwrap();
                    RgEvalContext {
    dfs: &mut usize,
            }
            collector_call_ranges: None,
        for &d in docs {
                    None => child_bitmap,
    // to be empty and the RG will be skipped), the walker does NOT ask
    impl NextDocMockCollector {
        ResolvedNode::Collector {
use datafusion::arrow::array::{Array, AsArray, BooleanArray};
                _: i32,
                panic!("leaf_bitmap called for forbidden leaf {}", idx);
                &tree,
        ]);
    };
        // Single contiguous run → one range
            prune_tree_leaf(vec![false]),
                position_map,
            let mut b = RoaringBitmap::new();
        // b: [3,12), [15,35)
            )
                rg_first_row,
            // which is O(rows_kept) with per-insert overhead.
        .map_err(|e| format!("expr.evaluate: {}", e))?;
    match node {
            "expected 4 per_leaf entries; got {}",
            collector_call_ranges: None,
        };
        let leaves = FixedLeafBitmaps {
            .prefetch(
        ResolvedNode::Collector { collector, .. } => {
            // full-container runs), vs. the naive one-bit-at-a-time loop
    pub fn new(ffm_collector_calls: Option<datafusion::physical_plan::metrics::Count>) -> Self {
            provider_key: 0,
    // delivered batches are projected (only predicate columns), so the
    /// Test 2: Per-leaf tighten.
    /// `WHERE (GoodEvent=1 AND (match(Title,'x') OR Age>18)) OR match(URL,'y')`):
                    &children[val],
        let pp = HashMap::new();
        assert_eq!(intersect_range_lists(&[(0, 10)], &[]), vec![]);
            ))
/// Advance `dfs` and push empty bitmaps for each Collector leaf without
        );
            unimplemented!(
    ///              AND (root)
        }
                    batch_len,
    rg_index_to_pos: &HashMap<usize, usize>,
        ResolvedNode::Not(c) => subtree_has_predicate(c),
        ctx.collector_strategy = super::super::CollectorCallStrategy::PageRangeSplit;
            let rg_offset = (ctx.rg_first_row as i32 - ctx.min_doc) as i64;
                // Short circuit: AND is dead (empty ∩ anything = empty).
                &test_ctx(),
            intersect_range_lists(&a, &b),
        );
                &pruner,
            collector_call_ranges: None,
            candidates,
    /// entries since coll2 survives → candidates non-empty → refinement runs.
        let mut r = RoaringBitmap::new();
    dfs: &mut usize,
    impl RowGroupDocsCollector for NextDocMockCollector {
        ResolvedNode::Not(child) => subtree_cost(child, ctx, page_pruner, pruning_predicates),
    fn next_doc_skip_when_next_doc_exceeds_call_max() {
            "RG1 must be skipped without a collect call (no empty-range poison)"
// ══════════════════════════════════════════════════════════════════════
        assert!(
                    None => child_bitmap,
                    words: Vec::new(),
            "collector should not be called when next_doc > call_max"
        state: &TreePrefetch,
        //   call LeafBitmapSource for the second Collector.
                &test_ctx(),
                    page_pruner,
            prune_tree_leaf(vec![true]),
        assert!(bm1.contains(60), "doc 160 should be at position 60");
                batch_offset,
    /// Test 1: Per-leaf skip.
/// is weighted by page-level selectivity: `cost_predicate * COST_SCALE * (surviving_pages / total_pages)`.
        ResolvedNode::DelegationPossible { .. } => {
                        ctx.min_doc + run_start as i32,
    ///
        ResolvedNode::DelegationPossible { .. } => {
        // Build a minimal PagePruner with no filters — candidate_row_ids_for_filter
            mock_b.call_args().len(),
                &pruner,
            // Advance only forward — the iterator position is monotonic; guard
            .unwrap_or_else(|| vec![(ctx.min_doc, ctx.max_doc)]);
            per_leaf,
            collector_leaf(1),
    ctx: &RgEvalContext,
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int32, false)]));
        assert_eq!(result.candidates, bm(&[3, 4, 5]));
        let tree = collector_leaf(0);
        assert_eq!(intersect_range_lists(&[(0, 5)], &[(10, 15)]), vec![]);
        }
            )
        ]);
    /// effective_min = max(150, 100) = 150. The collector should be called
        let result = BitmapTreeEvaluator
                &tree,
                )?;
    /// Test 3: Multiple leaves are independent.
        assert!(
    fn identity_pm(rg_num_rows: usize) -> PositionMap {
/// Collector bitmaps because Predicate supersets shrink at refinement.
                            return (base * kept_pages + total - 1) / total;
/*
    fn and_of_two_collectors_intersects_phase1() {
//
// comparison against the batch's column data. Short-circuits on
            ranges.push((
                &tree,
            rg_num_rows: 100,
        if lo < hi {
        // Tree: AND(Collector, Collector). Root is AND.
/// which RG-relative position each delivered row came from; from there we
        let pruner = empty_pruner();
            min_doc: 100,
            rg_first_row: 0,
        };
                next_doc: self.next_doc,
//! `Arc::as_ptr`, not DFS position. See [`subtree_cost`].
    }
    // Identity key: same Arc used at build time is the same Arc we see here.
            ResolvedNode::Or(vec![collector_leaf(0), collector_leaf(1)]),
                &pruner,
        assert!(result.candidates.is_empty());
        let bm1 = source
// and the kernel call is 3–5x cheaper than going through
                }
        // Bitmap bits {0, 5, 9} → rows where (4+i) in {0,5,9} → i=1, i=5 (out of range), so only i=1.
        let spt = prune_tree_and(vec![
        let result = BitmapTreeEvaluator
                "invariant violation: DelegationPossible reached on_batch_node. \
            let num_words = num_docs.div_ceil(64);
) -> BooleanArray {
                _: i32,
    #[test]
                                        break;
        // Tree: AND(collector0, collector1) with spt root saying position 0 = false.
    /// Per-leaf iterator position carried across row groups: maps a collector
            rg_idx: 0,
            self.calls.lock().unwrap().push((min_doc, max_doc));
            .unwrap();
                    }
//!    The reason this is a superset, not the exact answer: predicate bitmaps
        let tree = ResolvedNode::Or(vec![collector_leaf(0), collector_leaf(1)]);
                &HashMap::new(),
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
                child,
                Ok(arr.as_boolean().clone())
    }
    evaluate_via_df(batch, expr)
                            let mut row_offset = 0usize;
fn subtree_has_predicate(node: &ResolvedNode) -> bool {
            // 2. Collector : If the child contained only Collector leaves
) -> Result<BooleanArray, String> {
        assert!(bm1.contains(70), "doc 170 should be at position 70");
        let mut bm = RoaringBitmap::new();
    /// a native Predicate leaf proves no-match via column stats, all
        let mut forbidden = HashSet::new();
        ResolvedNode::Predicate(_) => true,
                )?;
    /// Since 500 > 200 (call_max), the sub-range is skipped entirely,
    batch: &RecordBatch,
//!    `BooleanArray` kernels (`and_kleene`, `or_kleene`, `not`, cmp ops) to
//!
    #[test]
        let mut bm = RoaringBitmap::new();
pub(crate) const COST_SCALE: u32 = 1000;
    fn prefetch(
        // DFS order after sort: collector2=0, OR-child0=1(skipped), OR-child1=2.
            "coll2 should have non-empty bitmap"
/// True if `node` contains any `Predicate` leaf (transitively).
            let mut chunk = RoaringBitmap::from_lsb0_bytes(offset, bytes);
        //   OR[inner AND=false (pruned), coll2=true]
                state,
                    let bit = (d - min_doc) as usize;
        let mut allowed = HashMap::new();
        // min_doc-relative coordinates.
    out: &mut Vec<(usize, RoaringBitmap)>,
    /// RG0 returns next_doc=500. RG1 covers [100, 200).
            )
                optional_result_bitmap = Some(match optional_result_bitmap {
            let base = ctx.cost_predicate * COST_SCALE;
                    }
use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
// Candidate stage: Filters the parquet data with candidate superset [ page pruning + lucene bitset ]
            rg_can_match: can_match,
        /// Absolute doc IDs to include in the returned bitset.
        assert_eq!(result.per_leaf.len(), 2);
/// Translate a Collector leaf's bitmap (in min-doc-relative coordinates) to
        let result = BitmapTreeEvaluator
use crate::indexed_table::bool_tree::ResolvedNode;
                None,
            ResolvedNode::And(vec![
    fn candidate_and_short_circuit_under_not_skips_ffm() {
                    &children[i],
    fn next_doc_multiple_leaves_independent() {
        let result = BitmapTreeEvaluator
        );
            .unwrap();
            vec![false, true, false, false, false, true, false, false]
        // leaves combines correctly.
                    rg_index_to_pos,
        let bm = {
        ]);
        );
        // `always_true`): conservative fallback is "every row in scope is a
        // Cost sort at root OR: [standalone_leaf (10), AND (20)].
//!
        let last_next_doc = {
                Some(&spt),
    }
        // `Arc` pointer identity is a stable per-query key: the collector Arc
/// `(start, end)` half-open intervals in absolute doc-id space. The
        // For row i: rg_pos = 4 + i, abs_doc = 4 + i, rel = 4 + i.
    /// RG0 returns next_doc=150. RG1 covers [100, 200).
            rg_num_rows: 100,
use datafusion::arrow::compute::{and_kleene as and, not, or_kleene as or};
                        Operator::LtEq => lt_eq(col_arr, &scalar),
        r
        struct Poison;
            } else {
    // Evaluate page pruning for this single conjunct.
            unimplemented!(
        // All 4 collector leaves have per_leaf entries (coll3, coll2 real;
            )
        fn collect_packed_u64_bitset(
 */
            "pruned coll0 should have empty bitmap"
    /// Evaluator that counts how many times its `leaf_bitmap` was called —
                child,
            meta.schema().clone(),
    /// For RG1 [100, 200): leaf A skips (500 > 200), leaf B does not (50 < 200).
    /// impl is held as `Arc<dyn LeafBitmapSource>`, so the whole struct must be
                &HashMap::from([(0, 0)]),
                    for &j in indices.iter().skip(arr_index + 1) {
        }
            (2 * ctx.cost_predicate + ctx.cost_collector) * COST_SCALE
            max_doc: 200,
/// CollectorLeafBitmaps — default LeafBitmapSource for today's flow
//! kernels don't short-circuit internally and leaf identity is by
//!
    /// Why interior mutability at all: `leaf_bitmap` takes `&self` (the
        );
        let tree = ResolvedNode::Not(Box::new(ResolvedNode::And(vec![
    }
            }
            collector_leaf(2),
        let tree = ResolvedNode::Or(vec![
        impl RowGroupDocsCollector for Dummy {
        let (false_leaf, false_entry) = cached_collector(RoaringBitmap::new());
        assert_eq!(result.candidates, bm(&[2, 3]));
            prune_tree_leaf(vec![false]),
    #[test]
    }
            result.per_leaf[3].1.is_empty(),
        // RG0: covers [0, 100). Returns next_doc=150.
//! # Child ordering
            collector_call_ranges: None,
                let span = (ctx.max_doc - ctx.min_doc) as u32;
                return Ok(CollectDocsResult {
            }
            rg_idx: 0,
                return vec![];
                    // We simply call collectors so that the bitsets are appended to 'out'
        assert_eq!(mock_b.call_args().len(), 1);
                Some(&spt),
//! 1. **Candidate stage** (`prefetch`) — builds a *superset* candidate set of
        // But rg_idx=5 is NOT in the reverse map → should NOT prune.
                &pruner,
        let mut ctx = test_ctx();
    #[test]
            // Invariant: see prefetch_node arm. Same contract.
                &test_ctx(),
    #[test]
                    run_end = bit;
        }
            provider_key: 0,
    #[test]
                result_bitmap = Some(match result_bitmap {
        ) -> Result<CollectDocsResult, String> {
        );
        let tree = ResolvedNode::And(vec![
            }
    }
        ) -> Result<RoaringBitmap, String> {
        assert_eq!(
        // RG2 [200,300): boundary doc 200 must be collected.
        ]);
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
            next_doc_out = next_doc_out.max(result.next_doc);
    position_map: &PositionMap,
        );
                &ctx,
                                        if page_idx < total as usize {
                    return kernel_result.map_err(|e| e.to_string());
    /// concurrent access.
    /// collectors whose bitmaps are the "predicate mask".
                }
    /// Regression for the exclusive-boundary bug (Bharath's scenario):
            b.insert(2);
        CollectorCallStrategy::PageRangeSplit => {
    /// `on_batch_node`, but we can observe them by making Phase 2 evaluation
    /// Why `Mutex` and not `RefCell`: `LeafBitmapSource: Send + Sync` and the
        let inner_and_spt = prune_tree_and(vec![
        // RG1: covers [100, 200). Since last_next_doc=500 > 200 (call_max),
                    leaves,
            min_doc: i32,
            let bytes: &[u8] = unsafe {
                None,
        let source = CollectorLeafBitmaps::without_metrics();
        )?;
        }
            }
                let abs_doc = rg_first_row + rg_pos as i64;
//! filters those rows down to the exact answer. One-stage evaluation would
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
        assert_eq!(ranges_from_bitmap(&bm, &ctx), vec![(0, 16)]);
                Ok(universe)
        fn new(docs: Vec<i32>, next_doc: i32) -> Self {
            indices
        let pm = PositionMap::from_selection(&RowSelection::from(vec![RowSelector::select(8)]));
                bm(&[99]),
    #[test]
            result.per_leaf.len()
            let leaf_idx = *dfs;
            bm1.is_empty(),
            "pruned coll0 should have empty bitmap"
//! The candidate stage sorts AND/OR children by [`subtree_cost`] before
            result.per_leaf.len()
                    break;
            for (arr_index, &val) in indices.iter().enumerate() {
                .iter()
        let node = collector_node_from_arc(mock.clone());
///
///
        assert_eq!(
            ArrowReaderOptions::new().with_page_index(true),
    let (mut i, mut j) = (0, 0);
                page_pruner,
        assert_eq!(
            )
            rg_num_rows: 16,
    leaves: &dyn LeafBitmapSource,
                );
        //     inner AND[Predicate=false, OR(coll0=true, coll1=true)]
                prune_tree_leaf(vec![true]),
            r.insert(d);
        tree: &ResolvedNode,
                )?;
            }
    impl LeafBitmapSource for PoisonLeafBitmaps {
            .unwrap();
            let bitmap = state
                        });
                        return Ok(result_bitmap.clone());
        };
        // the missing entry as all-false.
                native_bridge_common::log_debug!(
    }
        assert!(
            idx: usize,
                    // RG-relative space; shift into scope-relative space
pub struct BitmapTreeEvaluator;
            let mut result_bitmap: Option<RoaringBitmap> = None;
        })
// ══════════════════════════════════════════════════════════════════════
    /// The lock is uncontended in practice: within a partition, row groups are
        let mask = bitmap_to_batch_mask(
            b.insert(0);
            "pruned coll1 should have empty bitmap"
        }
                None,
                    // same as total docs. In that case, we don't have to evaluate predicates
        // The AND short-circuits on idx 1 (empty). skip_dfs advances the
    out
        let or_spt = prune_tree_or(vec![
        // lives inside the resolved tree for the whole query, so its address
        bm.insert(12);
        ResolvedNode::And(children) | ResolvedNode::Or(children) => {
                &HashMap::new(),
        for (call_min, call_max) in &call_ranges {
                    let kernel_result = match *bin.op() {
        ResolvedNode::Predicate(expr) => predicate_to_batch_mask(batch, expr),
    /// short-circuit prevented evaluation of the poison child.
    /// leaf (keyed by its `Arc` pointer identity) to the next matching docId
                None => {
                prune_tree_leaf(vec![true]),
        }
                                            page_end += page_counts[page_idx];
        page_pruner: &PagePruner,
            3,
        let pruner = empty_pruner();
    /// is the simplest `Sync` keyed cell. (`SingleCollectorEvaluator` uses a
        // coll2 (dfs=0) gets real bitmap
                    stats_prune_tree.and_then(|spt| spt.children.get(val)),
        leaves: &dyn LeafBitmapSource,
                });
            for child in children {
            // the exact set.
        };
        // AND subtree pruned → empty; coll2 → {5,6,7}; OR = {5,6,7}
        let node = ResolvedNode::Collector {
    //
/// With block-granular RowSelection the delivered rows are a compacted
            )
                bm(&[5, 6, 7, 8]),
            page_pruner,
    use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
// in production (Predicate leaves are almost always simple comparisons)
            prune_tree_leaf(vec![true]),
        forbidden.insert(1); // must NOT be called — AND is dead
                // (no nulls, zero falses), any further `TRUE OR x` is
        let state = BitmapTreeEvaluator
    batch_offset: usize,
                 Planner must drop performance peers under OR/NOT before fragment conversion."
                &leaves,
            test_predicate_node(),
                    for &j in indices.iter().skip_while(|&&x| x != i).skip(1) {
            tree,
        // OR(AND(Predicate, OR(coll0, coll1)), coll2)
        };
        }
    match node {
                let filtered_bitmap = prefetch_node(
                None,
        ]);
                    &child_ctx,
/// 5/8 pages at `1000 * 5/8 = 625`. Collector cost `10 * 1000 = 10_000`.
        assert!(bm0.is_empty());
//! A different `LeafBitmapSource` could back Collector leaves by parquet
                continue;
        };
/// Expands index-backed `RowGroupDocsCollector` output into RoaringBitmaps.
                &HashMap::new(),
            bin.left().downcast_ref::<PhysColumn>(),
/// candidate superset is already full, but refinement still needs real
    }
                    }
            // bug is visible instead of silently giving wrong-shape candidates.
            .prefetch(
        let batch =
        };
        // Map has {0→0} but ctx.rg_idx=5 → not in map → no pruning.
/// Used to decide if a `Not(child)` Phase 1 result is safe to invert via
        let node_a = collector_node_from_arc(mock_a.clone());
            bm.insert_range(0u32..((ctx.max_doc - ctx.min_doc) as u32));
            rg_num_rows: 100,
            let lo = (batch_offset as i64 + anchor).max(0);
                // Remaining children get empty bitmap entries (no FFM
                    page_pruner,
//! # Two-stage evaluation
    }
        };
        let pruner = empty_pruner();
    #[test]
                    Some(p) => p,
        let meta = ArrowReaderMetadata::load(
        // DFS order by cost-sorted evaluation:
        }
                None,
            }
            ResolvedNode::Collector { collector, .. } => collector,
        assert_eq!(calls[1], (150, 200));
            base
    }
                                row_offset = seg_end;
                // (no nulls, zero trues), any further `FALSE AND x` is
        let mk_ctx = |rg_idx: usize, first: i64, min: i32, max: i32| RgEvalContext {
                        and(&result_bitmap, &child_bitmap).map_err(|e| e.to_string())?
    ///                     AND    coll2
}
) -> Result<RoaringBitmap, String> {
        let tree = ResolvedNode::And(vec![
                    out[i >> 6] |= 1u64 << (i & 63);
            collector_call_ranges: None,
        assert!(
            subtree_cost(&wrapped, &ctx, &pruner, &pp),
        // We need a schema + metadata. Simplest: write a tiny parquet and load it.
            let offset = (effective_min - ctx.min_doc) as u32;
    }
// Note: the stored per-leaf bitmap entries use `Arc::as_ptr(collector)` as
    // the current RG, skip the entire tree walk. Since collectors are
            Ok(result_bitmap)
        // RG has 10 rows; RowSelection selects rows [0..3] and [7..10],
// `LeafBitmapSource` implementation can identify which leaf it's being asked
            max_doc: max,
        assert_eq!(intersect_range_lists(&[], &[]), vec![]);
            for child in children {
                ))
        // Bitmap (min_doc-relative, min_doc = 0, rg_first_row = 0) {2, 8}.
                &pruner,
        let leaves = FixedLeafBitmaps {
//! before any expensive Collector leaf work. The refinement stage walks
            cost_predicate: 1,
    // translate back, instead of per-row `bm.contains()`.
    fn stats_prune_deep_or_under_and_materialises_all_collector_bitmaps() {
    use datafusion::common::ScalarValue;
                        _ => {
                return Err("CollectorLeafBitmaps: non-Collector node passed to leaf_bitmap".into())
    }
            .unwrap();
    }
        let spt = prune_tree_or(vec![and_spt, prune_tree_leaf(vec![true])]);
        assert_eq!(mask.len(), 0);
        );
                &test_ctx(),
    expr: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
        )
                &HashMap::new(),
    fn intersect_non_overlapping() {
            cost_collector: 10,
            .unwrap();
    /// With a `>` check, RG1 would tighten to an empty collect(200,200) → the
            cost_collector: 10,
                            // through to the general evaluator path.
    node: &ResolvedNode,
    ctx: &RgEvalContext,
// not (see the short-circuit branches in AND/OR).
                    position_map,
// about. We advance `dfs` on every leaf whether we actually evaluate it or
                                            page_start = page_end;
    struct NextDocMockCollector {
                    let start_rel = rg_pos + rg_offset;
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
                    if result_bitmap.null_count() == 0 && result_bitmap.true_count() == 0 {
            !result.per_leaf[0].1.is_empty(),
    /// visible via side effect on a counting LeafBitmapSource.
        assert_eq!(result.candidates, expected);
            }
            let bm = leaves.leaf_bitmap(node, leaf_idx, ctx)?;
        assert_eq!(result.candidates, bm(&[3, 4]));
            )?;
                    // delivered index = bit - anchor - batch_offset
        // RG0 [0,100): doc 5 matches, next_doc=200.
    /// keeps the per-test expected values unchanged.
            "coll3 should have non-empty bitmap"
    page_pruner: &PagePruner,
            min_doc: 0,
                    let nulls: Vec<Option<bool>> = (0..batch.num_rows()).map(|_| None).collect();
//!
        // Mainly needed for collectors, predicate expressions are inversed where possible
        assert!(bm0.contains(5), "doc 5 should be collected in RG0");
            min_doc: ctx.min_doc,
    }
    ///
            for c in children {
    fn leaf_bitmap(
                &HashMap::new(),
            rg_num_rows: 100,
    fn prune_tree_and(children: Vec<StatsPruneTree>) -> StatsPruneTree {
    leaves: &dyn LeafBitmapSource,
            .unwrap();
        // absent from `state.per_leaf`, so evaluating it would error with
                &test_ctx(),
    // We iterate the set bits of `bm` within the batch's coverage and
        let pruner = empty_pruner();
                &HashMap::new(),
            1,
                if d >= min_doc && d < max_doc {
            min_doc: 0,
    expr: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
        use datafusion::physical_expr::expressions::Literal;
        )
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
            }
    #[test]
            max_doc: 100,
//   - AND dead branch: `skip_dfs_with_empty_bitmaps` — no FFM upcalls,
        writer.write(&batch).unwrap();
        let expected: RoaringBitmap = (3u32..16).collect();
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
}
                            Some(inherited) => intersect_range_lists(&inherited, &new),
            cost_collector: 10,
        .evaluate(batch)
            // Extract contiguous runs of set bits as absolute doc ranges.
    // Reseat Column indices to the batch's projected schema by name.
        let right: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> =
            )
            _tree: &ResolvedNode,
    BooleanArray::from(vec![true; n])
        ResolvedNode::DelegationPossible { .. } => {
                None,
            .unwrap();
}
                &tree,
                pruning_predicates,
    pub fn without_metrics() -> Self {
        fn leaf_bitmap(
        let node_b = collector_node_from_arc(mock_b.clone());
        );
        RgEvalContext {
            let leaf_idx = *dfs;
            if next_doc_out >= *call_max {
                    }
                &leaves,
    let mut out = Vec::new();
            (Some(lo), Some(hi)) => {
        let expected =
                if result_bitmap.len() >= total_docs {
            min_doc: 100,
    /// without an FFM call.
            per_leaf: vec![false_entry],
                chunk.remove_range(upper..);
            max_doc: 100,
            let key = Arc::as_ptr(collector) as *const () as usize;
        }
        let batch =
    fn ranges_page_range_split_with_gap() {
            &bm, /*min_doc*/ 100, /*rg_first_row*/ 100, &pm, 0, 8,
    #[test]
                        return Ok(result_bitmap.clone());
        let ctx0 = RgEvalContext {
                Some(&spt),
        next_doc: i32,
            b.insert(5);
    fn bm(docs: &[u32]) -> RoaringBitmap {
        // Full-scan position map: delivered index == RG position.
    match node {
        ResolvedNode::Predicate(_) => *dfs += 1,
//! we read only the few pages that could possibly match. Phase 2 then
            cost_predicate: 1,
        ctx.collector_strategy = super::super::CollectorCallStrategy::PageRangeSplit;
        }
                    if lo < hi {
                    ctx,
        let (true_leaf, true_entry) = cached_collector({
            batch_len,
        let pruner = empty_pruner();
                "invariant violation: DelegationPossible reached skip_dfs_with_empty_bitmaps."
            3,
    /// with min_doc=150, not 100.
        }
                    rg_first_row,
    }
                    "predicate evaluation produced non-boolean array: {:?}",
        //   doomed empty and the RG will be skipped. The walker must NOT
                None,
    #[test]
    ///   RG0 [0,100)   match: doc 5,  next_doc=200
    /// instance at once. The `Mutex` satisfies the `Sync` bound, not real
        };
                // widen beyond what the parent already narrowed to.
            for i in 0..batch_len {
                Ok(BooleanArray::from(nulls))
            let mut b = RoaringBitmap::new();
        }
        StatsPruneTree {
//   - OR saturated: `collect_collector_leaves` — real FFM upcalls needed
                &pruner,
            // 1. Predicate : If the child's bitmap was computed
            bitmaps: vec![bm(&[1, 2, 3]), bm(&[2, 3, 4])],
                ctx.min_doc + run_start as i32,
            rg_first_row: 0,
        // Cost sort at OR: coll2(10) before AND(Pred+OR=1+20=21)
    /// 3 RGs of 100 docs each. A match sits at doc 200 — exactly the start of
//! Plus [`CollectorLeafBitmaps`] — the default [`LeafBitmapSource`] impl that
        let source = CollectorLeafBitmaps::without_metrics();
            .prefetch(
            )
        };
                    let delivered = (b as i64 - anchor - batch_offset as i64) as usize;
//! 2. **Refinement stage** (`on_batch`) — runs per record batch, after
            // Invariant: see prefetch_node arm. Same contract.
        let leaves = FixedLeafBitmaps {
    fn intersect_multiple_ranges() {
        // coll0, coll1 empty from skip_dfs_with_empty_bitmaps).
        use datafusion::physical_expr::expressions::Literal;
//     because Predicate supersets shrink at refinement (OR still needs
        _leaf_dfs_index: usize, // This is not used in this implementation
            b
//! either read the whole RG (wasteful) or trust the coarse superset
                for b in bm.range(lo_u32..hi_u32) {
            bitmaps: vec![bm(&[0, 1, 2])],
                    page_prune_metrics,
                rg_pos += s.row_count as i64;
        let a = vec![(0, 5), (10, 20), (30, 40)];
            tree,
            // No pruning applicable (no page index or column missing) —
    #[test]
        docs: Vec<i32>,
            "boundary doc 200 (RG-relative pos 0) must not be dropped"
        // counter for idx 2 without calling leaf_bitmap. Refinement treats
            collector_leaf(2),
    fn empty_pruner() -> PagePruner {
    page_prune_metrics: Option<&PagePruneMetrics>,
    bm: &RoaringBitmap,
//     the real Collector bitmaps for correct results).
            rg_can_match,
                &leaves,
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
    /// mock returns next_doc=i32::MAX → RG2 skipped → doc 200 silently dropped.
                &leaves,
        let always_true_expr: Arc<dyn datafusion::physical_expr::PhysicalExpr> =
        let schema = Arc::new(Schema::new(vec![Field::new("x", DataType::Int32, false)]));
                    batch,
                ResolvedNode::Predicate(always_true_expr),
) -> u32 {
        );
}
                    None => child_bitmap,
    match selection {
// Refinement stage [ Post Decode, where we need the actual decoded values to evaluate ] : tree walker
/// subsequent Collector siblings.
        let result = BitmapTreeEvaluator
            // check that lets an empty (min == max) call through would poison the
        // - First returns empty → AND short-circuits.
                if bit == run_end + 1 {
            // sitting under an OR/NOT ancestor — the leaf becomes single-viable on
    // always-true in the resolution, a false here means a Predicate
        // and wouldn't usually hit this
        #[derive(Debug)]
    }
                    };
    /// exercises the offset RG scenario where a chunk doesn't start at 0.
            )
//!    parquet delivered the decoded rows. Walks the same tree using Arrow
        ]);
                            let mut page_idx = 0usize;
                &HashMap::new(),
        ResolvedNode::DelegationPossible { .. } => {
    /// `LeafBitmapSource` trait signature) but must update this map on every
            Ok(predicate_page_bitmap(
/// More selective predicates (fewer surviving pages) get lower cost and
            if upper < u32::MAX {
        // [0,5) and [10,15) → empty
        };
            .prefetch(
                                }
            min_doc: 0,
}
        // intersections: [3,5), [10,12), [15,20), [30,35)
            RowSelector::select(3),
            let key = Arc::as_ptr(expr) as *const () as usize;
        };
                }
    // The tests below prove that when an AND short-circuits at a point
            ranges_from_bitmap(&bm, &ctx),
                Some(&spt),
        // Verify the collector was called with tightened min_doc=150, not 100.
            .prefetch(
        let result = BitmapTreeEvaluator
    batch: &RecordBatch,
            b.insert(999); // doesn't matter — shouldn't be looked up
        ResolvedNode::Collector { collector, .. } => {
        );
        allowed.insert(0, {
                            }
            RecordBatch::try_new(schema, vec![Arc::new(Int32Array::from(vec![0i32; 8]))]).unwrap();
                    position_map,
        assert!(result.candidates.is_empty());
//!    produce the *exact* per-row answer. Collector leaves look up their
    }
            }
// The `dfs` counter tracks the caller's position in a depth-first traversal.
                ResolvedNode::And(vec![
}
 *
    let referenced = datafusion::physical_expr::utils::collect_columns(expr);
                &pruner,
/// subset of the RG, not a contiguous span. `position_map` lets us recover
            out.push((key, bm.clone()));
                    words[bit / 64] |= 1u64 << (bit % 64);
                bitmap,
    #[test]
        PositionMap::Bitmap { .. } | PositionMap::Runs { .. } => {
fn predicate_page_bitmap(
        // Tree: NOT(AND(empty_leaf, other_leaf)).
            b
                calls: std::sync::Mutex::new(Vec::new()),
    ///                       /   \
                let child_ctx = if ranges != ctx.collector_call_ranges {
                    ResolvedNode::Or(vec![collector_leaf(0), collector_leaf(1)]),
            ) -> Result<CollectDocsResult, String> {
            rg_first_row: 100,
        let spt = prune_tree_and(vec![or_spt, prune_tree_leaf(vec![true])]);
    #[test]
    }
use crate::indexed_table::page_pruner::{PagePruneMetrics, PagePruner, StatsPruneTree};
        }
            position_map,
            RecordBatch::try_new(schema, vec![Arc::new(Int32Array::from(vec![0i32; 4]))]).unwrap();
    }
        ResolvedNode::Predicate(expr) => {
impl TreeEvaluator for BitmapTreeEvaluator {
    }
            meta.metadata().clone(),
        // Ranges are half-open [min, max): a nextDoc at or past a range's exclusive
///
        };
                &leaves,
                    next_doc: i32::MAX,
                &HashMap::new(),
        // RG1: covers [100, 200).
            // Invariant: DelegationPossible must never appear under OR or NOT.
                    }
                collector_leaf(2),
            )
        let pruner = empty_pruner();
            collector_leaf(0),
// (Kleene-safe: both check `null_count == 0` first).
    fn stats_prune_tree_nested_or_under_and() {
            rg_idx: 1,
            vec![(2, 5), (8, 11), (14, 15)]
            collector_call_ranges: None,
        }
                std::slice::from_raw_parts(
            }
        let mask = bitmap_to_batch_mask(&bm, 0, 0, &pm, 0, 0);
        // - Because we're under root-AND, the whole candidate set is
                &test_ctx(),
                &HashMap::from([(0, 0)]),
            .expect("OR should short-circuit on all-true acc, skipping poison leaf");
                position_map,
                    pruning_predicates,
        // a: [0,5), [10,20), [30,40)
// and dispatch directly to the arrow kernel. This is the dominant shape
            vec![Arc::new(Int32Array::from(vec![0i32; 16]))],
            let mut words = vec![0u64; num_words];
            subtree_cost(&nested, &ctx, &pruner, &pp)
            }
        CollectorCallStrategy::TightenOuterBounds => match (bm.min(), bm.max()) {
        // won't be called since we use no Predicate nodes in these tests.
fn intersect_range_lists(a: &[(i32, i32)], b: &[(i32, i32)]) -> Vec<(i32, i32)> {
    fn stats_prune_tree_or_all_children_false() {
use crate::indexed_table::row_selection::{packed_bits_to_boolean_array, PositionMap};
            datafusion::common::ScalarValue::Boolean(Some(b)) => {
            for child in children {
            let mut optional_result_bitmap: Option<BooleanArray> = None;
            // already advanced to. Skip a sub-range entirely below the next match;
        PositionMap::Identity { .. } => {
        // coll0 (dfs=3) and coll1 (dfs=4) are empty from pruned subtree
            // Bitset is relative to effective_min; place it at the matching
        let b = vec![(3, 12), (15, 35)];
            // a full page of rows in O(log n) per container (or O(1) for
    ///   RG1 [100,200) no matches — must be skipped WITHOUT an empty collect call
        assert!(result.candidates.is_empty());
        // Batch covers docs [0, 8). Match bitmap {1,3,5}.
        }
    #[test]
    use datafusion::arrow::record_batch::RecordBatch;
    fn stats_prune_tree_root_and_false_skips_entire_rg() {
    #[test]
            i += 1;
        None => {
            collector_strategy: super::super::CollectorCallStrategy::TightenOuterBounds,
    }
        ResolvedNode::Collector {
        let mock_b = Arc::new(NextDocMockCollector::new(vec![110, 120], 50));
        let mut ctx = test_ctx();
                            let mut page_start = 0usize;
        assert_eq!(
        let result = BitmapTreeEvaluator
            )
    // indices need to be remapped before `evaluate(batch)` reads them.
    #[test]
            ffm_collector_calls,
        assert_eq!(intersect_range_lists(&[(0, 10)], &[(5, 15)]), vec![(5, 10)]);
// the refinement-stage walker for the lookup.
                    arr.data_type()
                        if let Some(sel) = page_pruner.prune_rg(pp, ctx.rg_idx, None) {
    // where every ancestor is AND (so the whole candidate set is doomed
                &tree,
        // Use a no-op collector — LeafBitmapSource supplies bitmaps, not the collector
}
        }
        use datafusion::common::ScalarValue;
            min_doc: 100,
            )
            let mut b = RoaringBitmap::new();
    }
    ///       /   \
            rg_idx: 1,
        let mut result_bitmap = RoaringBitmap::new();
                expr,
