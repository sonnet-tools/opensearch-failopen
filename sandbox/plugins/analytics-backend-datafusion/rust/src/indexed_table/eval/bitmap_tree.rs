        }
            2,
        assert!(
            result.per_leaf.len(),
/// `(start, end)` half-open intervals in absolute doc-id space. The
        let (poison_leaf, _poison_entry) = cached_collector({
    fn intersect_partial_overlap() {
                prune_tree_leaf(vec![true]),
            "expected 3 per_leaf entries; got {}",
        // get empty bitmaps from skip_dfs_with_empty_bitmaps (no FFM calls).
    use datafusion::parquet::arrow::ArrowWriter;
    #[test]
            stats_prune_tree,
        let pruner = empty_pruner();
            )
        // Cost sort at root AND: coll3(10) before OR(10+1+20=31)
        let pruner = empty_pruner();
        allowed.insert(0, RoaringBitmap::new()); // triggers short-circuit
    }
        }
            max_doc: 100,
                        }
        let inner_and_spt = prune_tree_and(vec![
                let child_bitmap = on_batch_node(
        // DFS order after sort: collector2=0, OR-child0=1(skipped), OR-child1=2.
            fn collect_packed_u64_bitset(
        // delivered idx 2 → rg_pos 2
///   queries, slower for wide ones) so "10" is a conservative default.
            // kept selector covers a contiguous row range; insert it as
        );
/// batch; delivered row `batch_offset + i` maps to RG position
                None,
// the refinement-stage walker for the lookup.
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
    ///                     AND    coll2
        fn leaf_bitmap(
fn evaluate_via_df(
    }
            // delivered row i -> rg_pos = batch_offset + i -> bit = batch_offset + i + anchor.
    #[test]
            }
                &test_ctx(),
//   - OR saturated: `collect_collector_leaves` — real FFM upcalls needed
        let pruner = empty_pruner();
            BooleanArray::from(vec![false, true, false, true, false, true, false, false]);
    fn intersect_one_contains_other() {
        let last_next_doc = {
            for (r, v) in rg_can_match.iter_mut().zip(c.rg_can_match.iter()) {
// Evaluate an arbitrary boolean `PhysicalExpr` against a batch; return
    fn subtree_cost_predicate_heavy_nested_beats_single_collector() {
        ResolvedNode::Predicate(_) => true,
                &HashMap::new(),
/// `batch_offset` is the delivered-row index of the first row in this
//!
                &pruner,
        let _ = idx;
    #[test]
        let pm = identity_pm(16);
            next_doc_out = next_doc_out.max(result.next_doc);
        let call_ranges = ctx
        CollectorCallStrategy::FullRange => vec![(ctx.min_doc, ctx.max_doc)],
            .prefetch(
            // Bitset is relative to effective_min; place it at the matching
            "collector should not be called when next_doc > call_max"
    /// RG, so it can't take `&mut self`.
    }
    node: &ResolvedNode,
    }
            .unwrap();
    let mut bm = RoaringBitmap::new();
        // TightenOuterBounds: [min_doc + bm.min(), min_doc + bm.max() + 1)
    expr: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
//! `BitmapTreeEvaluator` — the default [`TreeEvaluator`] implementation.
            ranges
            std::sync::Arc::new(PhysColumn::new("x", 0));
    match node {
//!    produce the *exact* per-row answer. Collector leaves look up their
            _ => {
                Some(&spt),
// in production (Predicate leaves are almost always simple comparisons)
    fn collector_leaf(idx: usize) -> ResolvedNode {
                        _ => {
        let candidates = prefetch_node(
        );
                &HashMap::new(),
        .evaluate(batch)
/// True if `node` contains any `Predicate` leaf (transitively).
    /// coll0 and coll1 inside the pruned AND must still get empty per_leaf
    }
    fn subtree_cost_collector_heavy_nested_exceeds_single_collector() {
                &pruner,
    /// keeps the per-test expected values unchanged.
        // Register ONLY the false leaf. If short-circuit misfires, Phase 2
            min_doc: 100,
//!    doc IDs for the RG. Works entirely in the RoaringBitmap domain:
        }
/// subset of the RG, not a contiguous span. `position_map` lets us recover
        let tree = ResolvedNode::And(vec![
                       // Three contiguous runs → three ranges
        let key = Arc::as_ptr(&collector) as *const () as usize;
                    result.words.as_ptr() as *const u8,
        assert_eq!(
        // Final AND = {5,6,7,8} ∩ {6,7,8} = {6,7,8}
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
            Operator::Eq,
    page_pruner: &PagePruner,
            b
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int32, false)]));
        }
    /// Per-leaf iterator position carried across row groups: maps a collector
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
    ) -> Result<TreePrefetch, String> {
            indices
                    batch_offset,
                page_prune_metrics,
            .unwrap();
            mock.call_args().len(),
                );
//                   [ either via filter exec or filter pushdown ] tree walker
            collector_leaf(2),
        let pruner = empty_pruner();
    }
//! Plus [`CollectorLeafBitmaps`] — the default [`LeafBitmapSource`] impl that
                &test_ctx(),
                return Ok(RoaringBitmap::new());
        )
            for &d in &self.docs {
 * compatible open source license.
        }
                std::slice::from_raw_parts(
            let mut run_end = first; // inclusive
    fn phase2_or_short_circuits_on_all_true() {
    node: &ResolvedNode,
        let pruner = empty_pruner();
            bitmaps: vec![bm(&[5, 6, 7]), bm(&[99]), bm(&[99]), bm(&[99])],
            per_leaf: vec![false_entry],
    /// Regression: when an AND subtree under an OR is stats-pruned because
        stats_prune_tree: Option<&StatsPruneTree>,
            // Invariant: DelegationPossible must never appear under OR or NOT.
            }
        forbidden.insert(1); // any call for leaf 1 panics
            )
        // Leaf A: next_doc=500 > 200 (call_max) → skipped, empty bitmap.
                bm(&[6, 7, 8]),
            got,
) -> u32 {
    fn prune_tree_leaf(can_match: Vec<bool>) -> StatsPruneTree {
        // The mock returns docs in [0,100) that match — none do, so empty.
        // `Arc` pointer identity is a stable per-query key: the collector Arc
        assert_eq!(mock_b.call_args().len(), 1);
                &pruner,
            &tmp.reopen().unwrap(),
                let abs_doc = rg_first_row + rg_pos as i64;
        collector_node: &ResolvedNode,
                    rg_index_to_pos,
fn intersect_range_lists(a: &[(i32, i32)], b: &[(i32, i32)]) -> Vec<(i32, i32)> {
                .iter()
            3,
            .unwrap();
                }
            !result.per_leaf[0].1.is_empty(),
        // collector2 (dfs=0) → {3,4,5}; OR-child1 (dfs=2) → {3,4,5,6}; OR = {3,4,5,6}
                &test_ctx(),
            rg_num_rows: 16,
use crate::indexed_table::row_selection::{packed_bits_to_boolean_array, PositionMap};
            "expected 3 per_leaf entries; got {}",
        PositionMap::from_selection(&RowSelection::from(vec![RowSelector::select(rg_num_rows)]))
    /// the (min_doc, max_doc) arguments it was called with.
        let mut allowed = HashMap::new();
                    out,
        };
        //   call LeafBitmapSource for the second Collector.
                &pruner,
                &leaves,
            map.get(&leaf_key).copied().unwrap_or(i32::MIN)
            let leaf_idx = *dfs;
    /// We can't directly inspect Phase 2 calls since they go through
                    batch_len,
//! A different `LeafBitmapSource` could back Collector leaves by parquet
        }
    fn stats_prune_tree_or_skips_false_child() {
            collector_call_ranges: None,
            }
            batch,
        assert_eq!(intersect_range_lists(&[], &[(0, 10)]), vec![]);
        let rg_map = HashMap::from([(2usize, 0usize), (3, 1), (4, 2)]);
            Ok(bm)
    }
            ffm_collector_calls,
        let mut forbidden = HashSet::new();
    }
        #[derive(Debug)]
            prune_tree_leaf(vec![false]), // Predicate
            let mut rg_pos: i64 = 0;
    use crate::indexed_table::index::CollectDocsResult;
    ///           OR
        &self,
            let key = Arc::as_ptr(collector) as *const () as usize;
///
    fn intersect_identical() {
        }
        assert!(
}
    ///             /         \
                )?;
        struct Poison;
        });
            result_bitmap |= chunk;
    }
        };
            // check that lets an empty (min == max) call through would poison the
            // the operator's backend and the resolver unwraps it natively (plain
        use datafusion::physical_expr::expressions::Literal;
            // (exact bitmaps), inversion is safe.
        let bm = {
// Refinement stage [ Post Decode, where we need the actual decoded values to evaluate ] : tree walker
//!
            ResolvedNode::Or(vec![collector_leaf(0), collector_leaf(1)]),
//! parquet rows to read at all* — for a selective query over a large RG,
        }
                                        kept_pages += 1;
            bm.insert_range(0u32..((ctx.max_doc - ctx.min_doc) as u32));
            1,
        pruning_predicates: &HashMap<usize, Arc<PruningPredicate>>,
        let spt = prune_tree_and(vec![
    #[test]
            leaf_to_next_doc_map: std::sync::Mutex::new(HashMap::new()),
        if lo < hi {
            collector_call_ranges: None,
/// arithmetic, NOT-wrapped, …).
            collector_call_ranges: None,
    fn stats_prune_tree_or_all_children_false() {
    pub fn new(ffm_collector_calls: Option<datafusion::physical_plan::metrics::Count>) -> Self {
            collector_leaf(0),
    #[test]
                    // same as total docs. In that case, we don't have to evaluate predicates
            rg_num_rows: 100,
/// Internal scale factor for cost computation. All costs are multiplied
        let ctx0 = RgEvalContext {
            if max_doc <= min_doc {
                ResolvedNode::And(vec![
            candidates: RoaringBitmap::new(),
    }
    fn ranges_page_range_split_empty_bitmap() {
                &test_ctx(),
    ///
            .unwrap_or_else(|| vec![(ctx.min_doc, ctx.max_doc)]);
        impl RowGroupDocsCollector for Poison {
    #[test]
            test_predicate_node(),
    }
        ColumnarValue::Scalar(sv) => match sv {
    match result {
        //   idx 0 = standalone_leaf (evaluated first by cost sort),
            // Predicate on the Rust side). Reaching this arm means that contract
                &test_ctx(),
                ctx,
            b
        let got: Vec<bool> = (0..6).map(|i| mask.value(i)).collect();
                    dfs,
            rg_num_rows: 100,
        }
            let bm = leaves.leaf_bitmap(node, leaf_idx, ctx)?;
                &HashMap::from([(0, 0)]),
    fn empty_pruner() -> PagePruner {
    #[test]
    fn stats_prune_deep_or_under_and_materialises_all_collector_bitmaps() {
        allowed: HashMap<usize, RoaringBitmap>,
        assert!(
        let result = BitmapTreeEvaluator
//!    supersets of the rows that actually match the predicate).
    // delivered batches are projected (only predicate columns), so the
        let tree = ResolvedNode::Or(vec![
                    pruning_predicates,
            &bm, /*min_doc*/ 100, /*rg_first_row*/ 100, &pm, 0, 8,
            collector,
            bitmaps: vec![bm(&[3, 4, 5]), bm(&[99]), bm(&[3, 4, 5, 6])],
            let mut b = RoaringBitmap::new();
    pruning_predicates: &HashMap<usize, Arc<PruningPredicate>>,
                    words: Vec::new(),
// Walks the resolved tree to produce the top-level superset RoaringBitmap
        assert!(result.candidates.is_empty());
        );
    }
    /// Stats prune: AND subtree → false (Predicate child proves no-match).
                    out[i >> 6] |= 1u64 << (i & 63);
        page_prune_metrics: Option<&PagePruneMetrics>,
            let mut result_bitmap = RoaringBitmap::new();
        let spt = prune_tree_and(vec![or_spt, prune_tree_leaf(vec![true])]);
        );
            rg_first_row: first,
        // RG indices [2,3,4] → map: {2→0, 3→1, 4→2}
    fn ranges_tighten_outer_bounds_strategy() {
        ResolvedNode::DelegationPossible { .. } => {
        ) -> Result<RoaringBitmap, String> {
                    RgEvalContext {
                None,
        let tree = ResolvedNode::And(vec![
            subtree_cost(&nested, &ctx, &pruner, &pp)
                                        // Advance to next page to avoid double-counting.
                    if delivered < batch_len {
        let bm1 = source.leaf_bitmap(&node, 0, &ctx1).unwrap();
        None => {
        assert!(result.candidates.is_empty());
        }
    // ── intersect_range_lists unit tests ────────────────────────────
    }
            vec![(2, 5), (8, 11), (14, 15)]
                    ranges.push((
                &leaves,
        // min_doc-relative coordinates.
        // For each row i: rg_pos = i, abs_doc = 100 + i,
        let mut map = self.leaf_to_next_doc_map.lock().unwrap();
            r.insert(d);
            ) -> Result<CollectDocsResult, String> {
 */
            for (r, v) in rg_can_match.iter_mut().zip(c.rg_can_match.iter()) {
        }
            // Candidate-stage is a superset. Inverting a superset does
        // DFS: coll3=0, coll2=1, Predicate=2, coll0=3, coll1=4
            b
        ]);
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
                pruning_predicates,
    }
                // (no nulls, zero trues), any further `FALSE AND x` is
                universe.insert_range(0..span);
    #[test]
                                        if page_idx < total as usize {
    // delivered row i -> rg_position(batch_offset + i) -> abs_doc -> bit.
                let mut universe = RoaringBitmap::new();
        let leaves = FixedLeafBitmaps {
        ResolvedNode::Collector { collector, .. } => {
            // Advance only forward — the iterator position is monotonic; guard
                    // and clamp to [0, span) since the scope bitmap only
        };
                out,
                &tree,
            batch_offset,
            RowSelector::skip(4),
        let a = vec![(0, 5), (10, 20), (30, 40)];
    ///
    BooleanArray::from(vec![false; n])
            rg_num_rows: 100,
                                            page_end += page_counts[page_idx];
    /// With a `>` check, RG1 would tighten to an empty collect(200,200) → the
            }
    pub fn without_metrics() -> Self {
            let mut b = RoaringBitmap::new();
        ctx.collector_strategy = super::super::CollectorCallStrategy::PageRangeSplit;
    }
    pub ffm_collector_calls: Option<datafusion::physical_plan::metrics::Count>,
        batch: &RecordBatch,
    }
                *r |= v;
                &tree,
fn prefetch_node(
        bm.insert(12);
                    ctx.clone()
        let spt = prune_tree_and(vec![
                docs,
        }
    }
            ]),
        // Bitmap bits {0, 5, 9} → rows where (4+i) in {0,5,9} → i=1, i=5 (out of range), so only i=1.
    /// Regression for the exclusive-boundary bug (Bharath's scenario):
        }
                optional_result_bitmap = Some(match optional_result_bitmap {
                None,
    }
        let expected =
            prune_tree_leaf(vec![true]),
            let mut b = RoaringBitmap::new();
    fn phase2_collector_uses_cached_bitmap() {
                position_map,
// used in the candidate stage). Predicate leaves evaluate the actual
        // "leaf bitmap missing". If short-circuit fires, poison is skipped
        let state = BitmapTreeEvaluator
        // Batch covers docs [0, 8). Match bitmap {1,3,5}.
        assert_eq!(result.candidates, bm(&[3, 4, 5]));
            indices
        };
        let bm0 = source.leaf_bitmap(&node, 0, &ctx0).unwrap();
        // DFS order:
    }
        let tree = ResolvedNode::Not(Box::new(ResolvedNode::And(vec![
    // the current RG, skip the entire tree walk. Since collectors are
            Ok(result_bitmap.unwrap_or_default())
            .unwrap();
            // against a stale/sentinel next_doc dragging it backward.
    /// impl is held as `Arc<dyn LeafBitmapSource>`, so the whole struct must be
        _leaf_dfs_index: usize, // This is not used in this implementation
            // Extract contiguous runs of set bits as absolute doc ranges.
                &HashMap::from([(0, 0)]),
        let leaves = FixedLeafBitmaps {
    /// exercises the offset RG scenario where a chunk doesn't start at 0.
        assert!(bm_b.contains(10));
                            // RowSelection merges adjacent same-decision
                _: i32,
    }
/// candidate stage. Tuning knobs, not a hard contract.
    }
            min_doc: 100,
                    child,
                // still TRUE in SQL 3VL. Safe to stop.
    #[test]
            collector_call_ranges: None,
        let pruner = empty_pruner();
        // Verify the collector was called with tightened min_doc=150, not 100.
    ///        AND    coll2
            meta.metadata().clone(),
        // Cost sort at root OR: [standalone_leaf (10), AND (20)].
        // Full-scan position map: delivered index == RG position.
            max_doc: 100,
            min_doc: min,
                    }
    ctx: &RgEvalContext,
        Self::new(None)
        let node = ResolvedNode::Collector {
                prune_tree_leaf(vec![true]),
                None,
    fn leaf_bitmap(
        let bm = {
        );
    fn next_doc_skip_when_next_doc_exceeds_call_max() {
        if let Some(&pos) = rg_index_to_pos.get(&ctx.rg_idx) {
    }
        use datafusion::common::ScalarValue;
        assert_eq!(
            collector_leaf(3),
//!    compact, cheap intersections, O(set-bits) operations. The stage walks
        )))
/// For `Predicate` leaves with a matching `PruningPredicate`, the cost
                &HashMap::from([(0, 0)]),
        // For row i: rg_pos = 4 + i, abs_doc = 4 + i, rel = 4 + i.
        assert!(bm_b.contains(20));
// `LeafBitmapSource` implementation can identify which leaf it's being asked
        );
    /// mock returns next_doc=i32::MAX → RG2 skipped → doc 200 silently dropped.
impl LeafBitmapSource for CollectorLeafBitmaps {
        assert_eq!(result.candidates, expected);
        let spt = prune_tree_or(vec![and_spt, prune_tree_leaf(vec![true])]);
                )
            prune_tree_leaf(vec![false]),
        let spt = prune_tree_and(vec![or_spt, prune_tree_leaf(vec![true])]);
            rg_first_row: 0,
            }
mod tests {
// It's used only to assign a stable `leaf_dfs_index` to each leaf so a
                for b in bm.range(lo_u32..hi_u32) {
        ResolvedNode::Collector { .. } => false,
            RowSelector::select(3),
// (Kleene-safe: both check `null_count == 0` first).
    }
    match ctx.collector_strategy {
// Tests
/// In-process Rust `TreeEvaluator`. Stateless — all per-RG state lives in the
            )
        // OR(all_true_leaf, poison_leaf). Same setup as AND case but inverted.
        let source = CollectorLeafBitmaps::without_metrics();
            .prefetch(
    /// `poison_child` would `panic!` if evaluated. If the test passes,
                    stats_prune_tree.and_then(|spt| spt.children.get(val)),
        // delivered idx 4 → rg_pos 8
        Ok(TreePrefetch {
            &self,
            }
            // sort the children by cost to prune children better
        // Expected mask per delivered index: [F,F,T,F,T,F]
            // 2. Collector : If the child contained only Collector leaves
            max_doc: 200,
    page_pruner: &PagePruner,
                        and(&result_bitmap, &child_bitmap).map_err(|e| e.to_string())?
        }
                    result.words.len() * 8,
        };
        if batch_schema.index_of(col.name()).is_err() {
    /// prefetched sequentially, so no two threads call `leaf_bitmap` on the same
                &tree,
    batch_len: usize,
    let (mut i, mut j) = (0, 0);
    /// ```
        assert!(bm1.is_empty(), "RG1 has no matches");
    /// Test 2: Per-leaf tighten.
    leaf_to_next_doc_map: std::sync::Mutex<HashMap<usize, i32>>,
                skip_dfs_with_empty_bitmaps(node, dfs, out);
            if hi > 0 && lo <= u32::MAX as i64 {
    }
                _: i32,
        }
        fn new(docs: Vec<i32>, next_doc: i32) -> Self {
    use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
        let sel = RowSelection::from(vec![
//! Why two stages and not one: Phase 1's bitmap-domain work decides *which
        // RG0: covers [0, 100). Collector returns next_doc=500.
                    page_prune_metrics,
) {
        ]);
            )
            min_doc: i32,
}
        #[derive(Debug)]
            )
// The `dfs` counter tracks the caller's position in a depth-first traversal.
            Ok(self.allowed.get(&idx).cloned().unwrap_or_default())
    match node {
            .prefetch(
                    let total = page_counts.len() as u32;
            other => Err(format!(
    /// returned by that leaf's last `collectDocs` call. A later RG whose whole
            datafusion::common::ScalarValue::Boolean(None) => {
    ) -> Result<RoaringBitmap, String> {
            out.push((key, bm));
            for (arr_index, &val) in indices.iter().enumerate() {
                });
use datafusion::arrow::array::{Array, AsArray, BooleanArray};
                    run_end = bit;
        ]);
            bm_a.is_empty(),
            RecordBatch::try_new(schema, vec![Arc::new(Int32Array::from(vec![0i32; 8]))]).unwrap();
    /// Test 3: Multiple leaves are independent.
    /// When `rg_idx` is an absolute index not present in the reverse map,
            return Ok(BooleanArray::from(nulls));
    }
        // Mainly needed for collectors, predicate expressions are inversed where possible
            // No pruning applicable (no page index or column missing) —
        let result = BitmapTreeEvaluator
///
    for col in &referenced {
                    for &j in indices.iter().skip_while(|&&x| x != i).skip(1) {
                        ..ctx.clone()
                &leaves,
        let ctx = test_ctx();
        ArrowReaderMetadata, ArrowReaderOptions, RowSelection, RowSelector,
        let pp = HashMap::new();
        assert_eq!(result.candidates, bm(&[3, 4]));
        let lo = a[i].0.max(b[j].0);
        };
    }
        );
use datafusion::arrow::compute::{and_kleene as and, not, or_kleene as or};
            result.per_leaf[1].1.is_empty(),
            .unwrap();
                    Some(result_bitmap) => {
        let mut allowed = HashMap::new();
        );
            ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]),
        let and_spt = prune_tree_and(vec![
                next_doc,
/// - `FullRange`: returns `[(min_doc, max_doc)]` (no narrowing).
    #[test]
            bin.right().downcast_ref::<Literal>(),
            })
                &HashMap::new(),
                None,
                            // Count pages with at least one selected row.
        let batch =
/// Expands index-backed `RowGroupDocsCollector` output into RoaringBitmaps.
            .unwrap();
        let tree = ResolvedNode::Or(vec![true_leaf, poison_leaf]);
                 Planner must drop performance peers under OR/NOT before fragment conversion."
}
                bm(&[99]),
    fn bitmap_to_batch_mask_anchors_correctly() {
    }
                    break;
            idx: usize,
        let batch =
                &tree,
            }
    #[test]
            prune_tree_leaf(vec![false]),
    #[test]
            left,
                optional_result_bitmap = Some(match optional_result_bitmap {
            cost_collector: 10,
        assert_eq!(result.per_leaf.len(), 2);
            out.push((lo, hi));
impl CollectorLeafBitmaps {
        // will try to look up `poison_entry` and fail with "leaf bitmap missing".
                        Operator::Lt => lt(col_arr, &scalar),
                batch,
                    ResolvedNode::Predicate(pred_expr),
                Some(&spt),
    /// RG0 returns next_doc=150. RG1 covers [100, 200).
            }
                page_pruner,
        let node = collector_node_from_arc(mock.clone());
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
                rg_pos += s.row_count as i64;
        let node_b = collector_node_from_arc(mock_b.clone());
                &test_ctx(),
            .unwrap();
        let leaves = FixedLeafBitmaps {
///   Tune (or make config-driven) if profiling shows it matters.
            rg_first_row: 100,
        RgEvalContext {
        }
                None,
        let bm2 = source
        let node_a = collector_node_from_arc(mock_a.clone());
                &HashMap::new(),
//!
            )
            )
                Err(format!(
        let mut forbidden = HashSet::new();
            min_doc: ctx.min_doc,
    #[test]
                if let Some(page_counts) = page_pruner.page_row_counts(ctx.rg_idx) {
            .prefetch(
                Ok(universe)
                &pruner,
            _tree: &ResolvedNode,
// ══════════════════════════════════════════════════════════════════════
                result_bitmap = Some(match result_bitmap {
    }
            if subtree_has_predicate(child) {
        // without calling leaf_bitmap (the forbidden set verifies this).
                    }
    struct FixedLeafBitmaps {
        bm.insert_range(2..5); // bits 2,3,4
            meta.schema().clone(),
            per_leaf,
                stats_prune_tree.and_then(|spt| spt.children.first()),
                None,
    dfs: &mut usize,
                .sort_by_key(|&i| subtree_cost(&children[i], ctx, page_pruner, pruning_predicates));
                let lo_u32 = lo as u32;
        PagePruner::new(
            std::sync::Arc::new(Literal::new(ScalarValue::Int32(Some(0))));
    #[test]
        let meta = ArrowReaderMetadata::load(
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
        let nested = ResolvedNode::And(vec![
    #[test]
    /// Evaluator that counts how many times its `leaf_bitmap` was called —
                    let nulls: Vec<Option<bool>> = (0..batch.num_rows()).map(|_| None).collect();
            ResolvedNode::Collector { collector, .. } => collector,
        )?;
        // other_leaf (idx 2) gets an empty bitmap from skip_dfs_with_empty_bitmaps
    fn bitmap_to_batch_mask_zero_length_batch() {
        let pruner = empty_pruner();
//!    The reason this is a superset, not the exact answer: predicate bitmaps
                &tree,
    /// LeafBitmapSource returning bitmaps by DFS index, panicking on forbidden indices.
        };
    fn prune_tree_or(children: Vec<StatsPruneTree>) -> StatsPruneTree {
            mock_b.call_args().len(),
        assert!(bm0.contains(5), "doc 5 should be collected in RG0");
    /// coll0 and coll1 must still get empty per_leaf entries.
        let batch = RecordBatch::try_new(
    fn stats_prune_tree_and_child_false_short_circuits() {
            meta.schema(),
            }
//!        exact match set — this is what decides which parquet rows to read);
            // Invariant: see prefetch_node arm. Same contract.
            if self.forbidden.contains(&idx) {
        let node = collector_node_from_arc(mock.clone());
                &HashMap::new(),
        let pm = identity_pm(5);
}
            let nulls: Vec<Option<bool>> = (0..batch.num_rows()).map(|_| None).collect();
            for c in children {
            &mut dfs_counter,
            }
            ResolvedNode::Or(vec![
                &tree,
    position_map: &PositionMap,
    }
        use datafusion::common::ScalarValue;
// per-row BooleanArrays using Arrow's 3VL-safe `and_kleene`/`or_kleene`/`not`
                            for s in sel.iter() {
/// - `PageRangeSplit`: returns contiguous runs of set bits as absolute ranges.
    /// Why interior mutability at all: `leaf_bitmap` takes `&self` (the
/// `Not` passes through to its child; `And`/`Or` sum their children.
use std::sync::Arc;
        // delivered idx 0 → rg_pos 0
        }
        let pruner = empty_pruner();
        let mask = bitmap_to_batch_mask(&bm, 0, 0, &pm, 4, 4);
                    }
        // b: [3,12), [15,35)
        let ctx1 = RgEvalContext {
        ResolvedNode::Not(child) => {
//! # Child ordering
                &rg_map,
        // intersections: [3,5), [10,12), [15,20), [30,35)
        assert!(
            b
        ResolvedNode::Predicate(_) => *dfs += 1,
    let selection = page_pruner.prune_rg(pruning_predicate, ctx.rg_idx, page_prune_metrics);
            }
            b.insert(2);
/// are evaluated first in AND nodes, producing tighter ranges for
                &HashMap::from([(0, 0)]),
                rg_first_row,
        let mock = Arc::new(NextDocMockCollector::new(vec![160, 170], 150));
    /// `WHERE (GoodEvent=1 AND Income>0 AND (match(T,'x') OR Age>18)) OR (match(S,'buy') AND CounterID>100)`
                &pruner,
fn on_batch_node(
            )
            .prefetch(
    #[test]
        assert_eq!(
            // stored next_doc to i32::MAX and drop later matches.
            .unwrap();
        ]);
        };
            let hi = (batch_offset as i64 + anchor + batch_len as i64).max(0);
        let pm = PositionMap::from_selection(&sel);
                if result_bitmap.as_ref().unwrap().is_empty() {
            !bm_b.is_empty(),
                }
        assert!(
        ResolvedNode::And(children) | ResolvedNode::Or(children) => children
            bitmaps: vec![bm(&[1, 2, 3, 4]), bm(&[3, 4, 5])],
            let mut ranges: Option<Vec<(i32, i32)>> = ctx.collector_call_ranges.clone();
    }
        /// Absolute doc IDs to include in the returned bitset.
        };
            )
    /// "leaf bitmap missing for key".
                &pruner,
            j += 1;
            result.per_leaf.len(),
            // Invariant: see prefetch_node arm. Same contract.
                    batch,
            result.per_leaf[3].1.is_empty(),
    fn or_of_two_collectors_unions_phase1() {
        ResolvedNode::DelegationPossible { .. } => {
        });
                rg_first_row,
        let pruner = empty_pruner();
        // Tree: AND(Collector, Collector). Root is AND.
                &HashMap::new(),
/// Collector bitmaps because Predicate supersets shrink at refinement.
        let batch =
/// Advance `dfs` and push empty bitmaps for each Collector leaf without
        let mut ctx = test_ctx();
    }
    // ── StatsPruneTree subtree pruning in prefetch ─────────────────────
        // Map has {0→0} but ctx.rg_idx=5 → not in map → no pruning.
                _: i32,
            min_doc: 0,
///
        assert_eq!(
        let pruner = empty_pruner();
                &leaves,
        //   DFS index 0 = first Collector, DFS index 1 = second.
        ResolvedNode::And(children) | ResolvedNode::Or(children) => {
                ResolvedNode::Or(vec![collector_leaf(0), collector_leaf(1)]),
//!    parquet delivered the decoded rows. Walks the same tree using Arrow
                                    if !s.skip && row_offset < page_end && seg_end > page_start {
            "leaf B collector should be called for RG1"
                &HashMap::new(),
    fn stats_prune_tree_offset_rg_idx_in_map_prunes_correctly() {
        let spt = prune_tree_and(vec![
            test_predicate_node(),
        let ctx0 = RgEvalContext {
    // ── subtree_cost ─────────────────────────────────────────────────
                    run_end = bit;
//
    let mut out = Vec::new();
        let schema = Arc::new(Schema::new(vec![Field::new("x", DataType::Int32, false)]));
// kernels. Collector leaves read their cached bitmap from the side-table
            }
            Ok(optional_result_bitmap.unwrap_or_else(|| all_true(batch_len)))
            }
                }
    // Reseat Column indices to the batch's projected schema by name.
            provider_key: 1,
                    out,
    }
///   FFM — posting-list iteration on the Java side, bitset transport +
        // after earlier children shrink the candidate set). Each range
        let bm_a = source.leaf_bitmap(&node_a, 0, &ctx1).unwrap();
fn subtree_has_predicate(node: &ResolvedNode) -> bool {
    }
                prune_tree_leaf(vec![true]),
        bm.insert_range(8..11); // bits 8,9,10
//     because Predicate supersets shrink at refinement (OR still needs
    fn not_collector_complements_against_universe() {
    /// concurrent access.
//! The tree is evaluated in two stages per row group:
            cost_collector: 10,
        //   OR[inner AND=false (pruned), coll2=true]
    #[test]
    let key = Arc::as_ptr(expr) as *const () as usize;
                collector_leaf(2),
                None,
            let mut result_bitmap: Option<RoaringBitmap> = None;
        for &d in docs {
            bitmaps: vec![
        );
    /// Deterministic bitmap source for tests.
            mock_a.call_args().len(),
        assert_eq!(mask, expected);
    rg_index_to_pos: &HashMap<usize, usize>,
/// short-circuit or stats-prune) — entries ensure refinement doesn't
    #[test]
        ResolvedNode::Collector { collector, .. } => {
            .unwrap();
            .sum(),
                        skip_dfs_with_empty_bitmaps(&children[j], dfs, out);
        let tree = ResolvedNode::Or(vec![
    #[test]
            }
                        return Ok(result_bitmap.clone());
///
                }
    bm
                ctx,
        };
    fn on_batch(
    /// RG2, i.e. exactly RG1's exclusive max_doc.
    /// 3 RGs of 100 docs each. A match sits at doc 200 — exactly the start of
                bm(&[99]),
                            return evaluate_via_df(batch, expr);
            RowSelector::select(3),
        }
            let upper = offset + num_docs;
        let collector = match collector_node {
        let ctx = test_ctx();
        ]);
        assert_eq!(result.candidates, bm(&[1, 2, 3]));
    batch_offset: usize,
                        a &= &child_bitmap;
    // We iterate the set bits of `bm` within the batch's coverage and
            *dfs += 1;
                &self,
                &pruner,
            b.insert(5);
    batch: &RecordBatch,
    #[test]
/// it — no separate indexing required, so this impl is fully stateless.
            collector_call_ranges: None,
        let always_true_expr: Arc<dyn datafusion::physical_expr::PhysicalExpr> =
            // range yields no words and reports the scorer as exhausted. A skip
    #[test]
                    None => child_bitmap,
        assert_eq!(result.per_leaf.len(), 2);
            for s in sel.iter() {
            ResolvedNode::And(vec![
        struct Dummy;
            for child in children {
            b.insert(5);
    }
                &pruner,
            cost_collector: 10,
            rg_first_row: 0,
        let _ = source.leaf_bitmap(&node_b, 1, &ctx0).unwrap();
        ResolvedNode::Collector { collector, .. } => {
// Fast-path for `col OP literal` comparisons: skip the expression walk
                "invariant violation: DelegationPossible reached on_batch_node. \
        };
        assert_eq!(result.candidates, bm(&[3, 4]));
        //   idx 1 = empty_leaf (AND's first child),
        }
            cost_predicate: 1,
            }
            // later sub-range skips/tightens on the position the iterator has
            .prefetch(
                None,
                continue;
/// Translate a Collector leaf's bitmap (in min-doc-relative coordinates) to
        let mask = bitmap_to_batch_mask(
        let bm1 = source.leaf_bitmap(&node, 0, &ctx1).unwrap();
            let mut iter = bm.iter();
//
            cost_collector: 10,
        // and we get the zero mask without erroring.
            Ok(self.bitmaps[idx].clone())
//! walking (cheap-first), which lets a narrow Predicate leaf — or a
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
pub(crate) fn subtree_cost(
        );
            _tree: &ResolvedNode,
        ctx.collector_strategy = super::super::CollectorCallStrategy::TightenOuterBounds;
            &self,
        let state = TreePrefetch {
        let single_collector = collector_leaf(0);
        docs: Vec<i32>,
                Some(&spt),
            Ok(predicate_page_bitmap(
            let key = Arc::as_ptr(collector) as *const () as usize;
                ctx.min_doc + run_end as i32 + 1,
            max_doc: max,
            .unwrap();
    #[derive(Debug)]
                    break;
    }
pub struct BitmapTreeEvaluator;
    // correctly and `filter_record_batch` drops the UNKNOWN rows.
    min_doc: i32,
                if d >= min_doc && d < max_doc {
        // nextDoc from this leaf's previous collectDocs (i32::MIN = "no info yet").
/// General-case evaluator — `expr.evaluate(batch)` with schema-drift
            *dfs += 1;
    // translate back, instead of per-row `bm.contains()`.
    match position_map {
                None,
/// result contains only the portions where both lists overlap.
        let pruner = empty_pruner();
                &leaves,
            let mut ranges = Vec::new();
    }
        //   OR sorts: coll2 (cost=10) before AND(Pred+OR) (cost=1+20=21)
                None => {
            collector_leaf(1),
//!    `BooleanArray` kernels (`and_kleene`, `or_kleene`, `not`, cmp ops) to
            let mut bm = RoaringBitmap::new();
    Ok(())
        let ctx = test_ctx();
        let result = BitmapTreeEvaluator
    /// `WHERE (GoodEvent=1 AND (match(Title,'x') OR Age>18)) OR match(URL,'y')`):
//!    (today that means an FFM upcall to the Java-side index). Predicate
    }
                let nulls: Vec<Option<bool>> = (0..batch.num_rows()).map(|_| None).collect();
        };
        writer.write(&batch).unwrap();
// Short-circuit contract:
        assert_eq!(intersect_range_lists(&[(0, 5)], &[(10, 15)]), vec![]);
        // RG1: covers [100, 200). Since last_next_doc=500 > 200 (call_max),
            unimplemented!(
                } else {
            !result.per_leaf[0].1.is_empty(),
            "pruned coll1 should have empty bitmap"
        );
            self.calls.lock().unwrap().clone()
//! kernels don't short-circuit internally and leaf identity is by
        // Cost sort: collector2 (cost=10k) first, OR subtree (cost=20k) second.
    /// is the simplest `Sync` keyed cell. (`SingleCollectorEvaluator` uses a
                Ok(vec![].into())
            // sitting under an OR/NOT ancestor — the leaf becomes single-viable on
/// universe subtraction. See the `Not` arm in `prefetch_node` for why.
        // rg_can_match has 3 positions: [true, false, true]
///
                let rg_pos = match position_map.rg_position(batch_offset + i) {
    page_pruner: &PagePruner,
        // coll0, coll1 empty from skip_dfs_with_empty_bitmaps).
    fn candidate_and_short_circuit_under_not_skips_ffm() {
        // OR contributes {5} from standalone_leaf → non-empty candidates.
    match node {
 *
    }
            ArrowReaderOptions::new().with_page_index(true),
    ///
        // coll0 (dfs=2) and coll1 (dfs=3) get empty bitmaps from pruned subtree
                        ctx.min_doc + run_start as i32,
                    page_prune_metrics,
        writer.close().unwrap();
        // Tree: AND(collector0, collector1) with spt root saying position 0 = false.
        let source = CollectorLeafBitmaps::without_metrics();
    /// Collector leaves inside the same subtree must still get empty bitmap
    let words = batch_len.div_ceil(64);
///   workload-dependent (Lucene posting iteration is fast for narrow
        let mask = bitmap_to_batch_mask(&bm, 0, 0, &pm, 0, 5);
            match batch.column_by_name(col.name()) {
            rg_index_to_pos,
        }
    use crate::indexed_table::index::RowGroupDocsCollector;
        let pruner = empty_pruner();
    out: &mut Vec<(usize, RoaringBitmap)>,
                    None => child_bitmap,
            not(&child_bitmap).map_err(|e| e.to_string())
            // The Java planner narrows performance peers off any AnnotatedPredicate
        ])));
                Some(&spt),
) -> Result<BooleanArray, String> {
        // Tree: OR(AND(empty_leaf, other_leaf), standalone_leaf).
fn collect_collector_leaves(
) -> Result<RoaringBitmap, String> {
        let ctx0 = RgEvalContext {
    fn subtree_cost_not_passes_through() {
//! before any expensive Collector leaf work. The refinement stage walks
//! children in their *original* tree order, which is fine because Arrow
        // Docs at 160, 170 — both within the tightened range [150, 200).
                    // covers rows inside [min_doc, max_doc).
    }
                            return (base * kept_pages + total - 1) / total;
/// Derive collector call ranges from a bitmap based on the strategy in `ctx`.
        // Stats: outer AND[coll3=true, OR=true]
            // full-container runs), vs. the naive one-bit-at-a-time loop
                &tree,
        &self,
        );
        // AND(all_false_leaf, poison_leaf). The poison leaf's bitmap is
        ResolvedNode::Collector { collector, .. } => {
                &tree,
            // stats), fall back to the full universe and let refinement pick
                                    }
    #[test]
    // where every ancestor is AND (so the whole candidate set is doomed
    }
            vec![Arc::new(Int32Array::from(vec![0i32; 16]))],
//! # Two-stage evaluation
        let mut next_doc_out = last_next_doc;
// Runs after parquet has delivered a decoded record batch. Walks the same
    // Schema drift: if the expression references any column not present
        let bm0 = source.leaf_bitmap(&node, 0, &mk_ctx(0, 0, 0, 100)).unwrap();
        let result = BitmapTreeEvaluator
            }
    impl NextDocMockCollector {
                        Operator::Gt => gt(col_arr, &scalar),
            // from anything non-exact (Predicate leaves use coarse page
                None,
        let single_collector = collector_leaf(0);
                                        page_idx += 1;
                child,
                .find_map(|(i, bm)| if *i == key { Some(bm) } else { None })
    // ── Phase 2 short-circuit ─────────────────────────────────────────
        assert!(
        .map_err(|e| format!("expr.evaluate: {}", e))?;
    ctx: &RgEvalContext,
                &tree,
        ResolvedNode::Not(child) => {
        // RG has 10 rows; RowSelection selects rows [0..3] and [7..10],
        );
            self.calls.lock().unwrap().push((min_doc, max_doc));
            }
                    }
        }
            tree,
                batch_offset,
//!
        ctx.collector_strategy = super::super::CollectorCallStrategy::PageRangeSplit;
            candidates,
                 Planner must drop performance peers under OR/NOT before fragment conversion."
        map.insert(leaf_key, next_doc_out);
            if arr.data_type() == &datafusion::arrow::datatypes::DataType::Boolean {
                None,
        assert_eq!(intersect_range_lists(&a, &a), vec![(10, 20), (30, 40)]);
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
        assert_eq!(intersect_range_lists(&[(0, 20)], &[(5, 10)]), vec![(5, 10)]);
//! The candidate stage sorts AND/OR children by [`subtree_cost`] before
    rg_first_row: i64,
 * The OpenSearch Contributors require contributions made to
            cost_predicate: 1,
            .map(|c| subtree_cost(c, ctx, page_pruner, pruning_predicates))
                next_doc: self.next_doc,
        let mut writer = ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), None).unwrap();
        let pm = PositionMap::from_selection(&RowSelection::from(vec![RowSelector::select(8)]));
            ctx,
    // always-true in the resolution, a false here means a Predicate
        let result = BitmapTreeEvaluator
    fn candidate_and_short_circuit_under_or_skips_ffm() {
            b.insert(9);
            .unwrap();
                position_map,
    }
            let leaf_idx = *dfs;
        // counter for idx 2 without calling leaf_bitmap. Refinement treats
            rg_can_match,
    /// ```
) -> RoaringBitmap {
            4,
            // bug is visible instead of silently giving wrong-shape candidates.
        let left: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> =
            subtree_cost(&nested, &ctx, &pruner, &pp)
                if bit == run_end + 1 {
        // RG1: covers [100, 200).
            collector_call_ranges: None,
            unimplemented!(
            collector: Arc::new(Dummy),
        let leaves = FixedLeafBitmaps {
            _ctx: &RgEvalContext,
                    if result_bitmap.null_count() == 0 && result_bitmap.true_count() == 0 {
//!      - a side-table of per-leaf bitmaps, keyed by Collector leaf identity.
                    batch_len,
            b.insert(8);
        // - Leaves are cost-equal, stable-sort preserves input order; so
                    child,
            "RG1 must be skipped without a collect call (no empty-range poison)"
                    let kernel_result = match *bin.op() {
            Ok(result_bitmap)
            let mut chunk = RoaringBitmap::from_lsb0_bytes(offset, bytes);
            cost_collector: 10,
                batch_len,
        // Identity position map over rg_num_rows=16.
        let leaves = FixedLeafBitmaps {
                    position_map,
            // Sub-ranges are ascending; carry the freshest next_doc forward so a
            *dfs += 1;
        ctx.collector_strategy = super::super::CollectorCallStrategy::PageRangeSplit;
    /// With `>=`, RG1 is skipped outright and doc 200 survives.
                            // row offsets back to page boundaries.
) -> Result<(), String> {
/// Walk a subtree materializing Collector bitmaps without combining into
    state: &TreePrefetch,
            (Some(lo), Some(hi)) => {
    /// `state.per_leaf` lookup (cached Phase 1 bitmaps), not the
    ///   RG2 [200,300) match: doc 200 — boundary doc, must be collected
                    }
                "invariant violation: DelegationPossible reached subtree_cost. \
                &rg_map,
        // empty bitmap via skip_dfs_with_empty_bitmaps (no FFM call).
        let bm = RoaringBitmap::new();
    fn stats_prune_under_or_materialises_empty_bitmaps_for_collectors() {
        }
        // The AND short-circuits on idx 1 (empty). skip_dfs advances the
            bitmaps: vec![bm(&[1, 2, 3]), bm(&[2, 3, 4])],
                };
    /// entries in `per_leaf`. Otherwise on_batch refinement panics with
                    run_start = bit;
        assert_eq!(mock_a.call_args().len(), 1);
        let mut rg_can_match = vec![true; children[0].rg_can_match.len()];
///   RoaringBitmap expansion on the Rust side. Relative cost is
                        });
                    state,
                    batch,
        // But rg_idx=5 is NOT in the reverse map → should NOT prune.
    use super::*;
/// panic on missing keys.
                    Some(mut a) => {
        let leaves = FixedLeafBitmaps {
            page_prune_metrics,
                other
    let pruning_predicate = match pruning_predicates.get(&key) {
pub struct CollectorLeafBitmaps {
        let leaves = FixedLeafBitmaps {
                Ok(arr.as_boolean().clone())
        &self,
        let _ = source.leaf_bitmap(&node, 0, &ctx0).unwrap();
        );
            unimplemented!(
    /// resulting in an empty bitmap for RG1.
        fn call_args(&self) -> Vec<(i32, i32)> {
    /// The strategy: construct AND(all_false_child, poison_child) where
        let mut bm = RoaringBitmap::new();
    }
        batch_len: usize,
    evaluate_via_df(batch, expr)
        );
    use datafusion::arrow::array::Int32Array;
fn skip_dfs_with_empty_bitmaps(
/// Pulls the collector directly off the `ResolvedNode::Collector` passed to
//! stats, external bitmap stores, or anything else implementing the trait.
                        or(&result_bitmap, &child_bitmap).map_err(|e| e.to_string())?
    /// leaf (keyed by its `Arc` pointer identity) to the next matching docId
//     the real Collector bitmaps for correct results).
                                }
                 Planner must drop performance peers under OR/NOT before fragment conversion."
    fn bitmap_to_batch_mask_handles_batch_offset_within_rg() {
/// the parent accumulator. Used at the OR saturation short-circuit: the
    ///
    /// entries since coll2 survives → candidates non-empty → refinement runs.
        // delivered idx 5 → rg_pos 9
use crate::indexed_table::page_pruner::{PagePruneMetrics, PagePruner, StatsPruneTree};
        // won't be called since we use no Predicate nodes in these tests.
        };
        assert_eq!(got, vec![false, false, true, false, true, false]);
            Self {
                // Short circuit case
                Ok(BooleanArray::from(nulls))
                            // Non-comparison op (And/Or/Plus/...) — fall
        //   So: coll2 dfs=0, then AND subtree (pruned): Predicate dfs=1, coll0 dfs=2, coll1 dfs=3
}
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
                &leaves,
    node: &ResolvedNode,
                &HashMap::new(),
        let (false_leaf, false_entry) = cached_collector(RoaringBitmap::new());
            rg_num_rows: 100,
    fn ranges_page_range_split_with_gap() {
    }
            let result = collector.collect_packed_u64_bitset(effective_min, *call_max)?;
    #[test]
            prune_tree_or(vec![
    /// that don't care about metrics.
        assert_eq!(ranges_from_bitmap(&bm, &ctx), vec![(4, 13)]);
            subtree_cost(&test_predicate_node(), &ctx, &pruner, &pp),
            if let Some(pp) = pruning_predicates.get(&key) {
                        collector_call_ranges: ranges.clone(),
            prune_tree_leaf(vec![false]),
    use datafusion::arrow::record_batch::RecordBatch;
//
        let mut r = RoaringBitmap::new();
        // delivered idx 3 → rg_pos 7
                    let scalar = lit.value().to_scalar().map_err(|e| e.to_string())?;
            1,
                &leaves,
            cost_predicate: 1,
                    None => child_bitmap,
        // Verify the collector was called for RG0.
    use std::collections::{HashMap, HashSet};
            let total_docs = (ctx.max_doc - ctx.min_doc) as u64;
        // the missing entry as all-false.
        ctx: &RgEvalContext,
        let pp = HashMap::new();
            bm.insert_range(0u32..((ctx.max_doc - ctx.min_doc) as u32));
            min_doc: 0,
        };
            children,
            .prefetch(
                < subtree_cost(&single_collector, &ctx, &pruner, &pp),
        let tree = ResolvedNode::Or(vec![collector_leaf(0), collector_leaf(1)]);
            prune_tree_leaf(vec![false]),
                &pruner,
            collector_leaf(2),
        let mask = BitmapTreeEvaluator
                "predicate evaluation produced non-boolean scalar: {:?}",
            rg_first_row,
                None,
        forbidden.insert(1); // must NOT be called — AND is dead
// walks in original order), but `Arc` identity is stable across both. See
    match node {
    fn bitmap_to_batch_mask_respects_position_map() {
            ResolvedNode::Or(vec![collector_leaf(0), collector_leaf(1)]),
    /// effective_min = max(150, 100) = 150. The collector should be called
            let key = Arc::as_ptr(collector) as *const () as usize;
        // OR(AND(Predicate, OR(coll0, coll1)), coll2)
/// making FFM calls. Used when a subtree is provably dead (AND
    // ── Candidate-stage skip of bitmap materialization ────────────────
        let tmp = tempfile::NamedTempFile::new().unwrap();
    fn test_predicate_node() -> ResolvedNode {
                ]),
/// 5/8 pages at `1000 * 5/8 = 625`. Collector cost `10 * 1000 = 10_000`.
                if bit >= 0 && bit <= u32::MAX as i64 && bm.contains(bit as u32) {
            bitmaps: vec![bm(&[1, 2]), bm(&[2, 3])],
            children,
        }
///
            &self,
}
        }
            prune_tree_leaf(vec![false]), // Predicate stats=false
        ResolvedNode::Or(children) => {
    batch: &RecordBatch,
        let pp = HashMap::new();
    impl LeafBitmapSource for FixedLeafBitmaps {
        let mask = bitmap_to_batch_mask(&bm, 0, 0, &pm, 0, 0);
        // Bitmap (min_doc-relative, min_doc = 0, rg_first_row = 0) {2, 8}.
            prune_tree_or(vec![
        state: &TreePrefetch,
                &leaves,
                None,
                None,
                &HashMap::from([(0, 0)]),
        // Leaf B: next_doc=50 < 200 → not skipped, collector called.
    #[test]
        ]);
            let bytes: &[u8] = unsafe {
        ctx: &RgEvalContext,
                    ctx,
            )?;
        // skipping [3..7]. Delivered rows = 6 (3 + 3).
    /// Build a ResolvedNode::Collector whose cached Phase 1 bitmap is `bm`.
            i += 1;
                vec![(ctx.min_doc + lo as i32, ctx.min_doc + hi as i32 + 1)]
        );
        // Whole RG is past the next match → no FFM call needed.
            ]),
                let child_bitmap = prefetch_node(
    ///   Predicate  OR(coll0, coll1)
        tree: &ResolvedNode,
//!    Predicate leaves re-evaluate the comparison on actual column data.
                c.add(1);
        forbidden: HashSet<usize>,
        assert_eq!(intersect_range_lists(&[(0, 10)], &[]), vec![]);
        );
        // universe → candidates non-empty → RG read. other_leaf gets an
        // [0,10) ∩ [5,15) → [5,10)
        let result = BitmapTreeEvaluator
            rg_idx: 1,
        assert_eq!(
        // RG0 [0,100): doc 5 matches, next_doc=200.
    }
        let spt = prune_tree_or(vec![
        // delivered idx 1 → rg_pos 1
                // intersected with inherited ranges so nested ANDs never
        let rg_map = HashMap::from([(0usize, 0usize)]);
            let span = (ctx.max_doc - ctx.min_doc) as i64;
    /// with min_doc=150, not 100.
                state,
        ResolvedNode::And(children) => {
        let mut ctx = test_ctx();
    /// RG0 returns next_doc=500. RG1 covers [100, 200).
    #[test]
    /// `rg_can_match[pos] == false`, the subtree is correctly pruned.
    stats_prune_tree: Option<&StatsPruneTree>,
            .prefetch(
    if let Some(spt) = stats_prune_tree {
        ResolvedNode::DelegationPossible { .. } => {
        ) -> Result<RoaringBitmap, String> {
        };
                bm(&[99]),
            ranges_from_bitmap(&bm, &ctx),
/// candidate superset is already full, but refinement still needs real
        assert_eq!(bm1.len(), 2);
                    position_map,
        let mut allowed = HashMap::new();
                            // selectors, so we walk the selection and map
        }
    BooleanArray::from(vec![true; n])
                None,
                chunk.remove_range(upper..);
            min_doc: 0,
    let mut out = vec![0u64; words];
        );
                };
        .unwrap();
        // never aliases another leaf mid-query.
        let pruner = empty_pruner();
        if last_next_doc >= ctx.max_doc {
use datafusion::arrow::record_batch::RecordBatch;
        let tree = ResolvedNode::Not(Box::new(collector_leaf(0)));
                dfs,
            idx: usize,
    match node {
            // which is O(rows_kept) with per-insert overhead.
        let or_spt = prune_tree_or(vec![
        })
        assert_eq!(mock.call_args(), vec![(0, 100)]);
        // All 4 collector leaves have per_leaf entries (coll3, coll2 real;
        let mock_b = Arc::new(NextDocMockCollector::new(vec![110, 120], 50));
                            let mut row_offset = 0usize;
        }
        let tree = ResolvedNode::And(vec![false_leaf, poison_leaf]);
    /// Construct a `CollectorLeafBitmaps` with no metrics.
        // We need a schema + metadata. Simplest: write a tiny parquet and load it.
            min_doc: 0,
            let child_bm = prefetch_node(
        let mk_ctx = |rg_idx: usize, first: i64, min: i32, max: i32| RgEvalContext {
                &tree,
                &test_ctx(),
        } else {
            collector,
        assert_eq!(result.candidates, bm(&[3, 4]));
//!
        }
    out: &mut Vec<(usize, RoaringBitmap)>,
                    "predicate evaluation produced non-boolean array: {:?}",
        allowed.insert(0, {
            result.per_leaf.len()
    ///
                &tree,
                }
        //   doomed empty and the RG will be skipped. The walker must NOT
                    // RG-relative space; shift into scope-relative space
                        ranges = Some(match ranges {
                });
            let effective_min = next_doc_out.max(*call_min);
        bm.insert(14); // bit 14
        let leaf_key = Arc::as_ptr(collector) as *const () as usize;
    /// short-circuit prevented evaluation of the poison child.
                        bm.insert_range(lo as u32..hi as u32);
            let mut b = RoaringBitmap::new();
        /// Records each (min_doc, max_doc) invocation.
        );
//     empty entries in side-table so refinement doesn't panic.
                Ok(universe)
        };
            Ok(bitmap_to_batch_mask(
    #[test]
        assert_eq!(
//!      - a top-level `RoaringBitmap` of candidate doc IDs (superset of the
    /// Test 1: Per-leaf skip.
        ]);
fn bitmap_to_batch_mask(
        let leaves = FixedLeafBitmaps {
            for &i in &indices {
        );
            RecordBatch::try_new(schema, vec![Arc::new(Int32Array::from(vec![0i32; 4]))]).unwrap();
                        Operator::GtEq => gt_eq(col_arr, &scalar),
/// Recursively compute the accumulated cost of a subtree for
                None,
        ResolvedNode::Not(c) => subtree_has_predicate(c),
    #[test]
                // Tighten collector call ranges from the accumulator bitmap,
    // For Identity position map, rg_position(k) == k, so the mapping is
                                while page_idx < total as usize {
                 Planner must drop performance peers under OR/NOT before fragment conversion."
            result.per_leaf.len()
        position_map: &PositionMap,
            mock.call_args().len(),
        assert_eq!(
        assert_eq!(
    // under AND proved no match — collector bitmaps are irrelevant.
    match selection {
        let pred_expr: Arc<dyn datafusion::physical_expr::PhysicalExpr> =
        }
    }
            )?;
        //     inner AND[Predicate=false, OR(coll0=true, coll1=true)]
            bm2.contains(0),
                pruning_predicates,
            prune_tree_leaf(vec![true]),
        ]);
        let leaves = FixedLeafBitmaps {
            Ok(optional_result_bitmap.unwrap_or_else(|| all_false(batch_len)))
#[cfg(test)]
}
            right,
                Some(col_arr) => {
        bm.insert_range(4..8);
        let calls = mock.call_args();
    }
            };
    // Substrait-decoded predicates carry indices into the full table schema;
    }
        rg_first_row: i64,
            b.insert_range(0..4);
use crate::indexed_table::bool_tree::ResolvedNode;
    fn next_doc_boundary_doc_not_dropped() {
        allowed.insert(0, RoaringBitmap::new()); // empty → trigger short-circuit
        assert_eq!(calls.len(), 2);
    /// Since 500 > 200 (call_max), the sub-range is skipped entirely,
        ResolvedNode::Not(child) => skip_dfs_with_empty_bitmaps(child, dfs, out),
        }
    expr: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
            .unwrap();
        }
            b
                &test_ctx(),
        ResolvedNode::DelegationPossible { .. } => {
            // strip performance peers under OR/NOT.
            // assembly so we avoid the Vec<bool> + BooleanArray::from copy.
        // RG1: covers [100, 200). last_next_doc=150, so effective_min=max(150,100)=150.
            let mut optional_result_bitmap: Option<BooleanArray> = None;
}
                &HashMap::new(),
            prune_tree_leaf(vec![true, true, true]),
            max_doc: 200,
                let bit = abs_doc - min_doc as i64;
        assert!(
        ResolvedNode::Predicate(_) => {
            ]),
    /// `LeafBitmapSource` trait signature) but must update this map on every
// and dispatch directly to the arrow kernel. This is the dominant shape
        };
        assert_eq!(intersect_range_lists(&[], &[]), vec![]);
        assert_eq!(calls[1], (150, 200));
    packed_bits_to_boolean_array(out, batch_len)
                &HashMap::new(),
        // `always_true`): conservative fallback is "every row in scope is a
            cost_predicate: 1,
/// `position_map.rg_position(batch_offset + i)`.
}
//!
        let spt = prune_tree_and(vec![
                if result_bitmap.len() >= total_docs {
        }
/// `TreePrefetch` value threaded through `RowGroupBitsetSource`.
            let map = self.leaf_to_next_doc_map.lock().unwrap();
    let batch_schema = batch.schema();
) -> Result<BooleanArray, String> {
    }
pub(crate) const COST_SCALE: u32 = 1000;
        )
        }
        // coll3={5,6,7,8}; OR: inner AND pruned→empty, coll2={6,7,8}; OR={6,7,8}
            b.insert(999); // doesn't matter — shouldn't be looked up
        ResolvedNode::Predicate(expr) => {
        assert!(
            let Some(first) = iter.next() else {
                None,
    fn stats_prune_tree_none_evaluates_normally() {
    }
        assert!(bm1.contains(70), "doc 170 should be at position 70");
                    if result_bitmap.null_count() == 0 && result_bitmap.false_count() == 0 {
//!
/// is weighted by page-level selectivity: `cost_predicate * COST_SCALE * (surviving_pages / total_pages)`.
                    return kernel_result.map_err(|e| e.to_string());
                &HashMap::from([(0, 0)]),
        // Build a minimal PagePruner with no filters — candidate_row_ids_for_filter
                prune_tree_leaf(vec![true]),
            3,
    dfs: &mut usize,
/// which RG-relative position each delivered row came from; from there we
            .expect("AND should short-circuit on all-false acc, skipping poison leaf");
            for bit in iter {
                        if let Some(sel) = page_pruner.prune_rg(pp, ctx.rg_idx, None) {
        let bm_b = source.leaf_bitmap(&node_b, 1, &ctx1).unwrap();
            "RG1 should be empty because next_doc > max_doc"
        // absent from `state.per_leaf`, so evaluating it would error with
        ]);
        };
    /// collectors whose bitmaps are the "predicate mask".
//! 2. **Refinement stage** (`on_batch`) — runs per record batch, after
        // AND subtree pruned → empty; coll2 → {5,6,7}; OR = {5,6,7}
                                row_offset = seg_end;
        assert_eq!(result.candidates, bm(&[5, 6, 7]));
            "pruned coll0 should have empty bitmap"
// ══════════════════════════════════════════════════════════════════════
            subtree_cost(&wrapped, &ctx, &pruner, &pp),
            test_predicate_node(),
            test_predicate_node(),
        }
        let pm = identity_pm(1);
                &leaves,
            fn collect_packed_u64_bitset(
            // conservative: every row in scope is a candidate.
                let child_bitmap = on_batch_node(
            "expected 4 per_leaf entries; got {}",
            // General case — fall back to per-row lookup but use packed-bit
        let result = BitmapTreeEvaluator
    // to be empty and the RG will be skipped), the walker does NOT ask
            }
        // Universe is [0, 16). Minus {0,1,2} = {3..15}
                unreachable!("Phase 2 must not call collect")
        let result = BitmapTreeEvaluator
            collector_call_ranges: None,
            let base = ctx.cost_predicate * COST_SCALE;
}
    }
use roaring::RoaringBitmap;
    pruning_predicates: &HashMap<usize, Arc<PruningPredicate>>,
                    // We simply call collectors so that the bitsets are appended to 'out'
    ctx: &RgEvalContext,
//!    Phase 1 bitmap from the side-table and slice it to batch coordinates;
    use datafusion::parquet::arrow::arrow_reader::{
    /// Realistic tree shape (mirrors a PPL query like
        assert_eq!(intersect_range_lists(&[(0, 10)], &[(5, 15)]), vec![(5, 10)]);
            bitmaps: vec![bm(&[0, 1, 2])],
        assert_eq!(result.candidates, bm(&[6, 7, 8]));
        assert!(
        let result = BitmapTreeEvaluator
                                            page_end += page_counts[page_idx];
        let mock_a = Arc::new(NextDocMockCollector::new(vec![], 500));
                return vec![];
use datafusion::physical_optimizer::pruning::PruningPredicate;
        CollectorCallStrategy::TightenOuterBounds => match (bm.min(), bm.max()) {
            base
                    batch_offset,
    // indices need to be remapped before `evaluate(batch)` reads them.
                    rg_first_row,
            result.per_leaf.len()
            "boundary doc 200 (RG-relative pos 0) must not be dropped"
    #[test]
            page_pruner,
            result.per_leaf.len(),
    ctx: &RgEvalContext,
                *r &= v;
                    }
        let mut ctx = test_ctx();
        assert_eq!(
fn all_true(n: usize) -> BooleanArray {
        }
            .leaf_bitmap(&node, 0, &mk_ctx(1, 100, 100, 200))
        assert_eq!(
        ResolvedNode::Not(child) => subtree_cost(child, ctx, page_pruner, pruning_predicates),
        let mock = Arc::new(NextDocMockCollector::new(vec![5, 200], 200));
        assert_eq!(
        //   idx 2 = other_leaf (AND's second child — skipped).
            .prefetch(
                    leaves,
        // coll2 (dfs=0) gets real bitmap
            prune_tree_leaf(vec![true]),
fn predicate_to_batch_mask(
            let mut b = RoaringBitmap::new();
                None,
    #[test]
        fn leaf_bitmap(
            ))
                }
 * this file be licensed under the Apache-2.0 license or a
    use datafusion::common::ScalarValue;
    }
    /// Identity position map over `rg_num_rows`. Delivered index == RG
    let remapped = super::remap_expr_to_batch(expr, batch)?;
    /// used to observe Phase 2 short-circuit by wrapping predicate leaves as
            )
        use datafusion::physical_expr::expressions::Literal;
            .prefetch(
        assert!(bm0.is_empty());
//! we read only the few pages that could possibly match. Phase 2 then
    fn intersect_multiple_ranges() {
        let mut bm = RoaringBitmap::new();
    ///   RG0 [0,100)   match: doc 5,  next_doc=200
        ColumnarValue::Array(arr) => {
    /// many leaves, hence a keyed map.)
            )
            };
            .iter()
            }
                &test_ctx(),
            ) -> Result<CollectDocsResult, String> {
        let leaves = FixedLeafBitmaps {
            )
    fn identity_pm(rg_num_rows: usize) -> PositionMap {
                state.min_doc,
                            let mut page_end = page_counts[0];
        let schema = Arc::new(Schema::new(vec![Field::new("x", DataType::Int32, false)]));
        Some(pp) => pp,
    fn phase2_and_short_circuits_on_all_false() {
    use crate::indexed_table::bool_tree::ResolvedNode;
                            None => new,
            )
    // linear: delivered row i -> bit (rg_first_row + batch_offset + i) - min_doc.
                )?;
                page_prune_metrics,
                        let new = ranges_from_bitmap(bm, ctx);
        assert_eq!(mask.len(), 0);
        )
        impl RowGroupDocsCollector for Dummy {
        assert_eq!(result.candidates.len(), 16);
    /// Incremented once per call to [`Self::leaf_bitmap`] — one FFM
//!    the tree once, producing:
        Ok(result_bitmap)
        let node = collector_node_from_arc(mock.clone());
                        collect_collector_leaves(&children[j], ctx, leaves, dfs, out)?;
                &leaves,
                } else {
            let mut indices: Vec<usize> = (0..children.len()).collect();
            // Two cases :
                    page_pruner,
    ///   RG1 [100,200) no matches — must be skipped WITHOUT an empty collect call
    }
            ranges.push((
            unimplemented!(
        let result = BitmapTreeEvaluator
                            let mut page_start = 0usize;
            RecordBatch::try_new(schema, vec![Arc::new(Int32Array::from(vec![0i32; 4]))]).unwrap();
            )
        if let (Some(col), Some(lit)) = (
    // RG-level subtree pruning: if this subtree provably can't match
use std::collections::HashMap;
        let mut ctx = test_ctx();
            return bm;
        let pm = identity_pm(8);
}
            cost_predicate: 1,
                    let bit = (d - min_doc) as usize;
                &test_ctx(),
                "invariant violation: DelegationPossible reached skip_dfs_with_empty_bitmaps."
        );
        // RG2 [200,300): boundary doc 200 must be collected.
    fn next_doc_multiple_leaves_independent() {
            cost_predicate: 1,
            batch_len,
    #[test]
        }
    match node {
    fn stats_prune_tree_root_and_false_skips_entire_rg() {
                    ctx.rg_idx
            max_doc: 16,
        // - Because we're under root-AND, the whole candidate set is
            let key = Arc::as_ptr(collector) as *const () as usize;
        // No pruning predicate available (schema mismatch at build time, or
    impl RowGroupDocsCollector for NextDocMockCollector {
        bm.insert_range(4..8);
                        }
            .unwrap();
        page_pruner: &PagePruner,
            rg_can_match: can_match,
        tree: &ResolvedNode,
            "coll3 should have non-empty bitmap"
    ///
            cost_predicate: 1,
    #[test]
        let mut bm = RoaringBitmap::new();
            provider_key: 0,
}
    fn stats_prune_tree_offset_rg_idx_not_in_map_does_not_prune() {
            // RG-relative offset so bit k maps to absolute doc effective_min + k.
                "invariant violation: DelegationPossible reached subtree_has_predicate. \
        //
    fn cached_collector(bm: RoaringBitmap) -> (ResolvedNode, (usize, RoaringBitmap)) {
            b.insert(5);
            leaves,
            let mut b = RoaringBitmap::new();
/// - Collector = 10: requires materialising an actual doc-id bitset over
            1,
/// CollectorLeafBitmaps — default LeafBitmapSource for today's flow
            .leaf_bitmap(&node, 0, &mk_ctx(2, 200, 200, 300))
            bin.left().downcast_ref::<PhysColumn>(),
}
                child,
        assert!(
                // (no nulls, zero falses), any further `TRUE OR x` is
            bitmaps: vec![bm(&[1, 2, 3]), bm(&[3, 4, 5])],
        let pruner = empty_pruner();
        let result = BitmapTreeEvaluator
//
            // 1. Predicate : If the child's bitmap was computed
    };
                expr,
    /// When `rg_idx` IS in the reverse map and maps to a position where
                    &children[i],
        let pp = HashMap::new();
                _: i32,
            cost_collector: 10,
            cost_collector: 10,
                    pruning_predicates,
    }
) -> BooleanArray {
    #[test]
                &leaves,
            rg_idx: 0,
/// candidate-stage ordering.
                Some(&spt),
            "coll2 should have non-empty bitmap"
                    page_pruner,
            position_map,
                // widen beyond what the parent already narrowed to.
    /// `on_batch_node` level — we use a custom node tree and assert on the
            pruning_predicates,
            bm1.is_empty(),
            for child in children {
// handles all operators, IN, IS NULL, LIKE, arithmetic, CAST, UDFs etc.
    while i < a.len() && j < b.len() {
//!    leaves use parquet page statistics via the caller's [`PagePruner`].
    // in this batch's schema, SQL semantics demand UNKNOWN for every
            for i in 0..batch_len {
            }
        assert_eq!(got, vec![false, true, false, false]);
                .sort_by_key(|&i| subtree_cost(&children[i], ctx, page_pruner, pruning_predicates));
        // Stats: AND subtree = false (Predicate child stats=false), coll2 = true
            }
/*
            collector_strategy: super::super::CollectorCallStrategy::FullRange,
                batch_len,
            candidates: RoaringBitmap::new(),
        // AND = {3,4,5} ∩ {3,4,5,6} = {3,4,5}
            unimplemented!(
        (node, (key, bm))
            rg_first_row: 0,
        let source = CollectorLeafBitmaps::without_metrics();
        ResolvedNode::And(children) | ResolvedNode::Or(children) => {
            let mut indices: Vec<usize> = (0..children.len()).collect();
        leaves: &dyn LeafBitmapSource,
    node: &ResolvedNode,
    #[test]
                }
// plus the per-leaf bitmap side-table.
//! (wrong, since predicate stats are supersets).
    /// Why `Mutex` and not `RefCell`: `LeafBitmapSource: Send + Sync` and the
    }
                &HashMap::new(),
        let tree = ResolvedNode::Or(vec![collector_leaf(0), collector_leaf(1)]);
                // Short-circuit: if every row is definitively true
                if let Some(ref bm) = result_bitmap {
        let right: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> =
    }
            bitmaps: vec![bm(&[10, 11, 12]), bm(&[3, 4])],
    ///              AND (root)
            bitmaps: vec![bm(&[1, 2, 3, 4]), bm(&[3, 4, 5])],
        let ctx1 = RgEvalContext {
            !result.per_leaf[1].1.is_empty(),
        /// The `next_doc` value to return from `collect_packed_u64_bitset`.
                    words[bit / 64] |= 1u64 << (bit % 64);
                }
    // ── ranges_from_bitmap unit tests ───────────────────────────────
        // Persist this leaf's advanced position for subsequent row groups.
    }
) -> Result<BooleanArray, String> {
    ///
                ctx.min_doc + run_start as i32,
                &leaves,
        ResolvedNode::Or(children) => {
        if a[i].1 < b[j].1 {
        let (true_leaf, true_entry) = cached_collector({
/// unavailable (no page index, expression not translatable, etc.).
            rg_num_rows: 100,
    }
// and the kernel call is 3–5x cheaper than going through
        // RG0: covers [0, 100). Both leaves are called.
                                        if page_idx < total as usize {
            b.insert(0);
        ResolvedNode::Predicate(std::sync::Arc::new(BinaryExpr::new(
                return Ok(CollectDocsResult {
            let num_words = num_docs.div_ceil(64);
                    return Ok(BooleanArray::from(nulls));
        let bm = {
        // Cost sort at OR: coll2(10) before AND(Pred+OR=1+20=21)
        let pruner = empty_pruner();
        assert_eq!(mock.call_args().len(), 1);
                &ctx,
        // rel_doc = abs_doc - min_doc = i. bits set at i=1 and i=5.
            ]),
        ResolvedNode::And(children) => {
    fn subtree_cost_leaf_nodes() {
use super::{LeafBitmapSource, RgEvalContext, TreeEvaluator, TreePrefetch};
                &HashMap::new(),
/// A predicate keeping 1/8 pages costs `1000 * 1/8 = 125` vs one keeping
                &test_ctx(),
                // OR(coll0, coll1)
        let wrapped = ResolvedNode::Not(Box::new(test_predicate_node()));
                &HashMap::new(),
            bitmaps: vec![bm(&[1, 2]), bm(&[3, 4]), bm(&[5, 6])],
            let mut optional_result_bitmap: Option<BooleanArray> = None;
            } else {
        // Single contiguous run → one range
    leaves: &dyn LeafBitmapSource,
                native_bridge_common::log_debug!(
                    &child_ctx,
/// by this so integer division preserves meaningful selectivity differences.
                let child_ctx = if ranges != ctx.collector_call_ranges {
    }
        bm.insert_range(4..8);
        StatsPruneTree {
        let got: Vec<bool> = (0..4).map(|i| mask.value(i)).collect();
}
            Arc::new(Literal::new(ScalarValue::Boolean(Some(true))));
        // [0,20) ∩ [5,10) → [5,10)
                batch_offset,
                &tree,
}
    /// visible via side effect on a counting LeafBitmapSource.
    // Convert batch-row index -> min-doc-relative bitmap index.
                universe -= &child_bm;
            cost_predicate: 1,
            if next_doc_out >= *call_max {
        }
    out: &mut Vec<(usize, RoaringBitmap)>,
                                    } else {
                                        break;
                &leaves,
// `prefetch_node` (which sorts children by cost) and `on_batch_node` (which
            rg_first_row: 0,
            // (wrong for candidate stage).
//! 1. **Candidate stage** (`prefetch`) — builds a *superset* candidate set of
fn all_false(n: usize) -> BooleanArray {
                    state,
        // upper bound means no match in that range, so we compare with `>=`.
        );
/// safety check. Used for non-`col OP literal` shapes (IN, IS NULL,
    };
    /// Leaf A returns next_doc=500, leaf B returns next_doc=50.
/// Falls back to the static `cost_predicate * COST_SCALE` when page stats are
        }
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int32, false)]));
            b.insert(1);
    leaves: &dyn LeafBitmapSource,
            )
    ) -> Result<BooleanArray, String> {
                                let seg_end = row_offset + s.row_count;
        ctx.rg_idx = 3;
        };
    }
        assert_eq!(mask.true_count(), 0);
                    // If all values match, then result bitmap length will be
        // RG1 [100,200): next_doc=200 >= max_doc=200 → skipped, no collect call.
            .unwrap();
        let nested = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
    }
        }
        // Collector was NOT called for RG1 — still only 1 total call.
        rg_index_to_pos: &HashMap<usize, usize>,
            if let Some(ref c) = self.ffm_collector_calls {
        ResolvedNode::Not(child) => collect_collector_leaves(child, ctx, leaves, dfs, out)?,
                collect_collector_leaves(child, ctx, leaves, dfs, out)?;
            rg_first_row: 100,
            vec![false, true, false, false, false, true, false, false]
                None,
/// Used to decide if a `Not(child)` Phase 1 result is safe to invert via
    // Identity key: same Arc used at build time is the same Arc we see here.
        // DFS order by cost-sorted evaluation:
                let span = (ctx.max_doc - ctx.min_doc) as u32;
        // produces one FFM call; results are merged into one bitmap in
        let mut dfs_counter = 0usize;
                if let Some(ref result_bitmap) = optional_result_bitmap {
    /// the subtree must NOT be pruned (conservative: can-match). This
        let mask = on_batch_node(&tree, &state, &batch, 0, &identity_pm(4), 0, 4)
                None,
        );
                    Some(result_bitmap) => {
            rg_idx: 0,
                &pruner,
// the resulting per-row mask. Uses DataFusion's expression evaluator —
                            let mut page_idx = 0usize;
            b
        };
    }
        }
        assert!(result.candidates.is_empty());
        // min_doc = 0, rg_first_row = 0, batch starts at rg offset 4, len 4.
            // NOT yield a superset of the true NOT — it yields a subset
    }
            children: vec![],
    let referenced = datafusion::physical_expr::utils::collect_columns(expr);
// `BinaryExpr::evaluate` + column/literal dispatch.
                &HashMap::new(),
    }
                });
            )
            // Invariant: see prefetch_node arm. Same contract: planner must
    pruning_predicates: &HashMap<usize, Arc<PruningPredicate>>,
                skip_dfs_with_empty_bitmaps(c, dfs, out);
            b
    /// single `AtomicI32` because it tracks exactly one collector; a tree has
//   - AND dead branch: `skip_dfs_with_empty_bitmaps` — no FFM upcalls,
                    &children[val],
        });
//
            "pruned coll0 should have empty bitmap"
    /// The lock is uncontended in practice: within a partition, row groups are
/// More selective predicates (fewer surviving pages) get lower cost and
                &leaves,
        assert!(
            collector_leaf(0),
    fn prefetch(
        let mock = Arc::new(NextDocMockCollector::new(vec![110, 120, 130], 500));
//!    Collector leaves ask an external [`LeafBitmapSource`] for their bitmap
            let mut run_start = first;
            )
        let mut ctx = test_ctx();
            unimplemented!(
    }
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
            rg_can_match,
    #[test]
    /// For Phase 2 specifically, `ResolvedNode::Collector` uses
        )
    /// without an FFM call.
            min_doc: 0,
// Candidate stage: Filters the parquet data with candidate superset [ page pruning + lucene bitset ]
                Some(&spt),
            }
                                            page_start = page_end;
        let pruner = empty_pruner();
        // min_doc = 100, bitmap has {1, 5} (min_doc-relative).
    }
    }
        // Ranges are half-open [min, max): a nextDoc at or past a range's exclusive
                                    } else if page_end <= seg_end {
        ResolvedNode::Predicate(expr) => predicate_to_batch_mask(batch, expr),
        let result = BitmapTreeEvaluator
            .prefetch(
                rg_index_to_pos,
            let lo = (batch_offset as i64 + anchor).max(0);
            _ => vec![(ctx.min_doc, ctx.max_doc)],
// about. We advance `dfs` on every leaf whether we actually evaluate it or
                &tree,
            schema.clone(),
        for (call_min, call_max) in &call_ranges {
        // Not pruned — both collectors contribute.
//! either read the whole RG (wasteful) or trust the coarse superset
                    if !bm.is_empty() {
///
            per_leaf: vec![true_entry],
            subtree_cost(&tree, &ctx, &pruner, &pp),
            collector_call_ranges: None,
            rg_first_row: 100,
    batch_len: usize,
/// Intersect two sorted, non-overlapping range lists. Both inputs are
    use super::CollectorCallStrategy;
            rg_idx: 1,
        let leaves = FixedLeafBitmaps {
    #[test]
///
    expr: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
        let leaves = FixedLeafBitmaps {
                "invariant violation: DelegationPossible reached collect_collector_leaves. \
    let anchor = rg_first_row - min_doc as i64; // rg_pos -> bit: rg_pos + anchor
            }
            // Enumerate set bits in `bm` within [anchor + batch_offset, anchor + batch_offset + batch_len).
            .prefetch(
            Arc::new(Literal::new(ScalarValue::Boolean(Some(true))));
            collector_leaf(2),
        );
        allowed.insert(1, RoaringBitmap::new()); // empty → short-circuit
        }
                words,
        assert_eq!(
}
                    Some(p) => p,
/// - `TightenOuterBounds`: returns `[(first_set + min_doc, last_set + min_doc + 1)]`.
        let tree = collector_leaf(0);
//! Predicate-dominated nested subtree — short-circuit a whole AND group
        assert_eq!(mask.true_count(), 4);
    fn ranges_page_range_split_contiguous() {
            max_doc: 100,
            rg_num_rows: 100,
            let num_docs = (*call_max - effective_min) as u32;
    /// range sits below this value has no matches for the leaf and is skipped
            bitmaps: vec![bm(&[1, 2, 3]), bm(&[2, 3, 4])],
        // AND(coll3, OR(AND(Predicate, OR(coll0, coll1)), coll2))
    fn bitmap_to_batch_mask_empty_bitmap_produces_all_false() {
            .unwrap();
        let mask = on_batch_node(&tree, &state, &batch, 0, &identity_pm(4), 0, 4)
            )
                        ctx.min_doc + run_end as i32 + 1,
                    ));
//
                    }
            ));
        let spt = prune_tree_and(vec![prune_tree_leaf(vec![true]), or_spt]);
            .prefetch(
                        return Ok(result_bitmap.clone());
                        a
// definitively-all-false for AND and definitively-all-true for OR
        },
        };
            // was violated: a planner bug, not an evaluator gap. Fail loud so the
        let leaves = PoisonLeafBitmaps { allowed, forbidden };
    let result = remapped
    position_map: &PositionMap,
            b.insert(999);
                    }
    dfs: &mut usize,
                    None => continue,
        // RG0: covers [0, 100). Returns next_doc=150.
            prune_tree_leaf(vec![true, false, true]),
        }
        };
            (2 * ctx.cost_predicate + ctx.cost_collector) * COST_SCALE
                ))
        // All 3 collector leaves have per_leaf entries. coll0 and coll1
            let mut b = RoaringBitmap::new();
        ) {
/// a per-batch `BooleanArray`.
        };
        r
                None,
        // rg_idx=3 → pos=1 → root rg_can_match[1] = false (from AND) → pruned
                None,
        let collector: Arc<dyn RowGroupDocsCollector> = Arc::new(Poison);
    }
                universe.insert_range(0..span);
        ResolvedNode::And(cs) | ResolvedNode::Or(cs) => cs.iter().any(subtree_has_predicate),
    /// `on_batch_node`, but we can observe them by making Phase 2 evaluation
        );
        Some(sel) => {
                &ctx,
        },
        }
    ///                    /   \
            }
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
            let child_bitmap = on_batch_node(
                    }
    rg_first_row: i64,
    }
/// Cost weights used by `subtree_cost` to order AND/OR children in the
                    leaves,
    fn bm(docs: &[u32]) -> RoaringBitmap {
                }
                    let end_rel = start_rel + s.row_count as i64;
    }
                        Operator::LtEq => lt_eq(col_arr, &scalar),
            }
                    for &j in indices.iter().skip(arr_index + 1) {
        let a = vec![(10, 20), (30, 40)];
        ]);
}
    fn prune_tree_and(children: Vec<StatsPruneTree>) -> StatsPruneTree {
        let (poison_leaf, _) = cached_collector({
            )),
                &tree,
    /// The inner AND subtree is stats-pruned (Predicate proves no-match).
                            // through to the general evaluator path.
                None,
            "coll2 should have non-empty bitmap"
        assert_eq!(result.candidates, bm(&[2, 3]));
                    }
        let ctx = test_ctx();
            )
                    ResolvedNode::Or(vec![collector_leaf(0), collector_leaf(1)]),
/// With block-granular RowSelection the delivered rows are a compacted
    /// instance at once. The `Mutex` satisfies the `Sync` bound, not real
        ]);
// Note: the stored per-leaf bitmap entries use `Arc::as_ptr(collector)` as
//! expands index-backed `RowGroupDocsCollector` output into RoaringBitmaps.
                &pruner,
                result_bitmap |= &filtered_bitmap;
            rg_num_rows: 100,
                        Operator::Eq => eq(col_arr, &scalar),
                &leaves,
            b.insert(0);
                &HashMap::new(),
            collector_strategy: super::super::CollectorCallStrategy::TightenOuterBounds,
        let mut forbidden = HashSet::new();
        // candidate" — return a full-range bitmap so AND/OR with other
    }
    fn intersect_non_overlapping() {
    /// Mock collector that returns configurable docs and next_doc, and records
                &self,
}
                .ok_or_else(|| format!("Phase 2: leaf bitmap missing for key {:#x}", key))?;
                let span = (ctx.max_doc - ctx.min_doc) as u32;
            let offset = (effective_min - ctx.min_doc) as u32;
            // Invariant: see prefetch_node arm. Same contract.
        ]);
            Ok(CollectDocsResult {
    ///
                &pruner,
        // AND(OR(collector0, collector1), collector2)
    #[test]
fn ranges_from_bitmap(bm: &RoaringBitmap, ctx: &RgEvalContext) -> Vec<(i32, i32)> {
    fn stats_prune_tree_nested_or_under_and() {
                page_pruner,
        assert!(result.candidates.is_empty());
    #[test]
        let ctx1 = RgEvalContext {
            *dfs += 1;
        );
        ResolvedNode::Predicate(expr) => {
                Some(&spt),
            "leaf B should not skip: next_doc=50 < max_doc=200"
        CollectorCallStrategy::PageRangeSplit => {
        ResolvedNode::DelegationPossible { .. } => {
        let mut rg_can_match = vec![false; children[0].rg_can_match.len()];
        // Inner AND short-circuits on empty_leaf. NOT inverts empty to
            _ctx: &RgEvalContext,
        // Bitmap contains docs 160 and 170 at correct RG-relative positions.
        fn collect_packed_u64_bitset(
                // upcalls) so refinement can look them up without panic.
    ///       /   \
            for child in children {
                &HashMap::new(),
        // Tree: NOT(AND(empty_leaf, other_leaf)).
            ctx.cost_predicate * COST_SCALE
            result.per_leaf[2].1.is_empty(),
        assert!(!result.candidates.is_empty());
        ]);
    ///          /   \
    }
        on_batch_node(
                    let lo = start_rel.max(0);
                let mut universe = RoaringBitmap::new();
                Ok(BooleanArray::from(vec![b; batch.num_rows()]))
    bm: &RoaringBitmap,
            out.push((key, RoaringBitmap::new()));
                &HashMap::new(),
        ctx.rg_idx = 5;
    fn candidate_root_and_short_circuit_skips_forbidden_collector() {
//! `Arc::as_ptr`, not DFS position. See [`subtree_cost`].
                &test_ctx(),
                &HashMap::new(),
                    // delivered index = bit - anchor - batch_offset
                    if lo < hi {
            .expect("OR should short-circuit on all-true acc, skipping poison leaf");
    ///              Predicate  OR(coll0, coll1)
        bitmaps: Vec<RoaringBitmap>,
                                        }
            // space (the bitmap the tree evaluator walks over). Each
            )
        }
                &test_ctx(),
            vec![(3, 5), (10, 12), (15, 20), (30, 35)]
            prune_tree_leaf(vec![false]),
        let pruner = empty_pruner();
            max_doc: i32,
    fn collector_node_from_arc(collector: Arc<dyn RowGroupDocsCollector>) -> ResolvedNode {
            collector_leaf(2),
        let or_spt = prune_tree_or(vec![
        // rg_first_row = 100, batch starts at offset 0, length 8.
            prune_tree_leaf(vec![false]),
            state,
            prune_tree_leaf(vec![true]),
        };
    // The tests below prove that when an AND short-circuits at a point
        // the entire range is skipped — collector should NOT be called again.
                &HashMap::new(),
        ) -> Result<CollectDocsResult, String> {
                            let mut kept_pages = 0u32;
        };
        let result = BitmapTreeEvaluator
        let bm1 = source
            "leaf A collector should not be called for RG1"
                )?;
        // Docs 110, 120 relative to min_doc=100 → bits 10, 20.
        let leaves = FixedLeafBitmaps {
/// - Predicate = 1: page-stats-only, no I/O, a handful of array lookups.
    fn subtree_cost_sums_children() {
                .per_leaf
            .unwrap();
            prune_tree_leaf(vec![true]),
        StatsPruneTree {
        assert_eq!(ranges_from_bitmap(&bm, &ctx), vec![(0, 16)]);
        PositionMap::Bitmap { .. } | PositionMap::Runs { .. } => {
        // [0,5) and [10,15) → empty
        // coll0 (dfs=3) and coll1 (dfs=4) are empty from pruned subtree
                    let hi = end_rel.min(span);
    #[test]
            .clone()
            b
                &leaves,
    /// a native Predicate leaf proves no-match via column stats, all
/// subsequent Collector siblings.
                &HashMap::new(),
            )
        }
        let or_spt = prune_tree_or(vec![inner_and_spt, prune_tree_leaf(vec![true])]);
        }
        let source = CollectorLeafBitmaps::without_metrics();
        let tree = ResolvedNode::And(vec![collector_leaf(0), collector_leaf(1)]);
            "pruned coll1 should have empty bitmap"
                calls: std::sync::Mutex::new(Vec::new()),
    #[test]
    #[test]
    // the `LeafBitmapSource` for the remaining Collector leaves' bitmaps.
                    rg_index_to_pos,
                "invariant violation: DelegationPossible reached the Tree-path evaluator. \
        let tree = ResolvedNode::And(vec![
    // Evaluate page pruning for this single conjunct.
            rg_idx,
                bm(&[5, 6, 7, 8]),
        // Use the narrowed call ranges if available (set by the AND evaluator
    // The symmetric case (AND under OR/NOT) must still materialise.
                &tree,
    struct PoisonLeafBitmaps {
            }
    batch: &RecordBatch,
            let leaf_idx = *dfs;
                            Some(inherited) => intersect_range_lists(&inherited, &new),
            return Ok(RoaringBitmap::new());
                    }
// the key, not `leaf_dfs_index`. DFS position changes between
        let bm = {
    #[test]
                &pruner,
            &mut per_leaf,
        forbidden.insert(2); // must NOT be called — AND is dead
use datafusion::arrow::compute::kernels::cmp::{eq, gt, gt_eq, lt, lt_eq, neq};
                }
                }
        let _ = source.leaf_bitmap(&node_a, 0, &ctx0).unwrap();
        }
                )?;
        // a: [0,5), [10,20), [30,40)
                // still FALSE in SQL 3VL. Safe to stop.
            // already advanced to. Skip a sub-range entirely below the next match;
        assert!(bm1.contains(60), "doc 160 should be at position 60");
            // a range in one call. `RoaringBitmap::insert_range` handles
// tree again — in original order this time, not cost-sorted — and combines
        let mut per_leaf = Vec::new();
            .unwrap();
    /// position — matches the pre-block-granular full-scan behaviour and
            min_doc: 0,
        let mut bm = RoaringBitmap::new();
                                        }
            if let Some(&false) = spt.rg_can_match.get(pos) {
            // the exact set.
        // All 3 collector leaves have per_leaf entries. The key difference:
    struct NextDocMockCollector {
            )
    batch_offset: usize,
    /// ```text
            }
            max_doc: 200,
            min_doc: 100,
                    let start_rel = rg_pos + rg_offset;
            let key = Arc::as_ptr(expr) as *const () as usize;
    ///         coll3          OR
            // otherwise tighten its lower bound so collectDocs skips the empty prefix.
        let leaves = FixedLeafBitmaps {
        let mut result_bitmap = RoaringBitmap::new();
    fn ranges_full_range_strategy() {
    /// ```text
    fn intersect_empty_with_anything() {
        batch_offset: usize,
            let _ = leaf_idx; // predicate leaves don't need per-leaf storage
                    // Column absent from batch schema: SQL UNKNOWN.
        let leaves = PoisonLeafBitmaps { allowed, forbidden };
    out
    }
                &HashMap::new(),
            .unwrap();
        ]);
        let got: Vec<bool> = (0..8).map(|i| mask.value(i)).collect();
    }
                }
            "leaf A should skip: next_doc=500 > max_doc=200"
    }
    // row. Return an all-NULL BooleanArray so kleene AND/OR combine
        ]);
        ctx.collector_strategy = super::super::CollectorCallStrategy::FullRange;
    page_prune_metrics: Option<&PagePruneMetrics>,
            .prefetch(
            // a full page of rows in O(log n) per container (or O(1) for
            rg_idx: 0,
        };
                let hi_u32 = hi.min(u32::MAX as i64) as u32;
        let mut ctx = test_ctx();
        let hi = a[i].1.min(b[j].1);
                if let Some(ref result_bitmap) = optional_result_bitmap {
        );
            out.push((key, bm.clone()));
        PositionMap::Identity { .. } => {
                    "BitmapTree: skipping subtree for RG {} — pruned by RG-level stats",
                leaves,
    #[test]
                &tree,
            bitmaps: vec![bm(&[1, 2, 3]), bm(&[99])],
    }
                ResolvedNode::Predicate(always_true_expr),
        ResolvedNode::Collector {
    /// Same scenario but deeper — mirrors a query like:
        });
                &pruner,
        next_doc: i32,
        let mask = bitmap_to_batch_mask(&bm, 0, 0, &pm, 0, 6);
                > subtree_cost(&single_collector, &ctx, &pruner, &pp)
                            }
    ///                       /   \
            } else {
        // FullRange ignores the bitmap, returns [min_doc, max_doc)
        }
                // Short-circuit: if every row is definitively false
                &HashMap::new(),
                 Planner must drop performance peers under OR/NOT before fragment conversion."
use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
//! filters those rows down to the exact answer. One-stage evaluation would
    }
                return Err("CollectorLeafBitmaps: non-Collector node passed to leaf_bitmap".into())
        let result = BitmapTreeEvaluator
/// compute the absolute doc id and look it up in `bm`.
        };
    }
        assert_eq!(ranges_from_bitmap(&bm, &ctx), vec![(4, 8)]);
        for c in &children {
                &HashMap::from([(0, 0)]),
            .prefetch(
            .prefetch(
    /// Helper: build a ResolvedNode::Collector wrapping a given Arc collector.
        let pruner = empty_pruner();
//!    come from page-level stats and are inherently coarse (pages are
            ))
            .unwrap();
                Some(&spt),
        ResolvedNode::Collector {
            let mut words = vec![0u64; num_words];
                bitmap,
    page_prune_metrics: Option<&PagePruneMetrics>,
        // offset = (150 - 100) = 50. doc 160 at bit (160-150)=10 placed at 50+10=60.
            ],
        let pruner = empty_pruner();
        ]);
    //
        ]);
                // Remaining children get empty bitmap entries (no FFM
            test_predicate_node(),
    #[test]
        let b = vec![(3, 12), (15, 35)];
        }
        let expected: RoaringBitmap = (3u32..16).collect();
    /// LeafBitmapSource. So short-circuit observation has to be at the
                    if total > 0 {
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
//!
        // Use narrowed call ranges if available (set by AND evaluator).
        // NOT inverts empty AND → universe.
    }
            let bitmap = state
            )
        };
            .collector_call_ranges
    /// `Sync`. `RefCell` is `!Sync` and won't compile under that bound; `Mutex`
                let filtered_bitmap = prefetch_node(
                    stats_prune_tree.and_then(|spt| spt.children.get(i)),
        ResolvedNode::Collector { .. } => ctx.cost_collector * COST_SCALE,
    /// For RG1 [100, 200): leaf A skips (500 > 200), leaf B does not (50 < 200).
    // Fast-path: detect `col OP literal` and call the kernel directly.
    fn test_ctx() -> RgEvalContext {
impl TreeEvaluator for BitmapTreeEvaluator {
        // Both entries present (other_leaf has empty bitmap from skip).
        assert_eq!(mask.len(), 5);
            *dfs += 1;
        // lives inside the resolved tree for the whole query, so its address
        StatsPruneTree {
                if !s.skip {
        let pruner = empty_pruner();
    }
// (keyed by `Arc::as_ptr(collector)`, which is stable across the cost-sort
                    let delivered = (b as i64 - anchor - batch_offset as i64) as usize;
            prune_tree_leaf(vec![false]),
                        out[delivered >> 6] |= 1u64 << (delivered & 63);
                    next_doc: i32::MAX,
    /// resulting mask shape with deliberately-wrong siblings.
        let tree = ResolvedNode::And(vec![
        assert!(
            ctx.cost_collector * COST_SCALE
            let rg_offset = (ctx.rg_first_row as i32 - ctx.min_doc) as i64;
        .unwrap();
        );
                &HashMap::new(),
        }
                    }
            provider_key: 0,
                    arr.data_type()
            }
                &HashMap::new(),
                &HashMap::new(),
            // Mirror the real FfmSegmentCollector empty-range shortcut: an empty
        let pruner = empty_pruner();
 * SPDX-License-Identifier: Apache-2.0
                    // Selector covers [rg_pos, rg_pos + s.row_count) in
        assert_eq!(ranges_from_bitmap(&bm, &ctx), vec![]);
                        Operator::NotEq => neq(col_arr, &scalar),
        // coll3 (dfs=0) and coll2 (dfs=1) are real
            // The selection is RG-relative. Translate to min_doc-relative
        // leaves combines correctly.
        let mut ctx = test_ctx();
        let pruner = empty_pruner();
                    };
        }
                                            page_start = page_end;
            .prefetch(
                // Short circuit: AND is dead (empty ∩ anything = empty).
            result.per_leaf[2].1.is_empty(),
        let state = TreePrefetch {
            rg_idx: 0,
        let result = BitmapTreeEvaluator
    // ── CollectorLeafBitmaps next_doc skip/tighten tests ─────────────
            let num_docs = (max_doc - min_doc) as usize;
            let mut b = RoaringBitmap::new();
            }
        // - First returns empty → AND short-circuits.
        let ctx = test_ctx();
    fn next_doc_tighten_effective_min() {
            rg_idx: 1,
    }
        let pp = HashMap::new();
            intersect_range_lists(&a, &b),
            bitmaps: vec![bm(&[1, 3, 5])],
                    dfs,
                &tree,
                panic!("leaf_bitmap called for forbidden leaf {}", idx);
                &test_ctx(),
            subtree_cost(&collector_leaf(0), &ctx, &pruner, &pp),
            .unwrap();
        let result = BitmapTreeEvaluator
    node: &ResolvedNode,
            if upper < u32::MAX {
use datafusion::logical_expr::{ColumnarValue, Operator};
        ResolvedNode::DelegationPossible { .. } => {
    if let Some(bin) = expr.downcast_ref::<BinaryExpr>() {
                &leaves,
        calls: std::sync::Mutex<Vec<(i32, i32)>>,
                }
        Self {
                });
        assert_eq!(mask.true_count(), 0);
                                        page_idx += 1;
//!
        assert_eq!(
        };
            }
                &pruner,
                    // since we know all bits are matching.
    /// round-trip to Java per Collector leaf per RG. `None` for tests
    #[test]
            let bm = leaves.leaf_bitmap(node, leaf_idx, ctx)?;
fn predicate_page_bitmap(
                &pruner,
            .on_batch(&tree, &state, &batch, 0, &pm, 0, 8)
        assert_eq!(
    fn and_of_two_collectors_intersects_phase1() {
        // Use a no-op collector — LeafBitmapSource supplies bitmaps, not the collector
    }
}
        assert!(
        let bm = RoaringBitmap::new();
    impl LeafBitmapSource for PoisonLeafBitmaps {
// not (see the short-circuit branches in AND/OR).
        };
        assert!(result.candidates.is_empty());
                &test_ctx(),
    //
            ctx.cost_predicate * COST_SCALE
        for c in &children {
        let leaves = PoisonLeafBitmaps { allowed, forbidden };
            tree,
                Some(&spt),
            cost_collector: 10,
                    rg_first_row,
        // and wouldn't usually hit this
        }
        }
            datafusion::common::ScalarValue::Boolean(Some(b)) => {
                None,
// comparison against the batch's column data. Short-circuits on
        None => {
