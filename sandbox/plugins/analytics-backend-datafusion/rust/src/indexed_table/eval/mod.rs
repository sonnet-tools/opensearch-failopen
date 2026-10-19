use datafusion::arrow::buffer::Buffer;
        pruning_predicates: &HashMap<usize, Arc<PruningPredicate>>,
        // per-leaf intermediate results.
            context: Box::new(()),
    let mut seen = HashSet::new();
/// Candidate-stage output of a `TreeEvaluator`. `candidates` is a superset
    out: &mut Vec<(usize, &'a ResolvedNode)>,
    pub rg_idx: usize,
    // an empty cache (evaluator will use the fallback synchronously).
                }
//!    This is extensible to different implementations.
    fn prefetch_rg(
        }
    /// Controls how the AND evaluator narrows collector doc ranges.
    use datafusion::arrow::array::Int32Array;
                        c.add(num_pages);
            evaluator: Arc::new(NoopTreeEvaluator),
                // inflate counts. We compute final page-level metrics below
                    }
mod tests {
                None,
            meta.schema(),
    /// the refinement mask is the exact per-row answer. `finalize_batch`
 * this file be licensed under the Apache-2.0 license or a
    use datafusion::parquet::arrow::ArrowWriter;
    }
//!
    /// AND evaluator from the accumulator bitmap after earlier children
            _tree: &ResolvedNode,
        ResolvedNode::Collector { collector, .. } => {
    /// (if any reached us via `scan(filters)`) could contain the
            }
}
        min_doc: i32,
    use datafusion::arrow::record_batch::RecordBatch;
            // fragment conversion, so DelegationPossible should never reach the
        batch_len: usize,
}
        for h in handles {
                    if rg_candidates.range(row_offset..page_end).next().is_none() {
    /// Produce exact per-batch `BooleanArray` mask for refinement-stage [post-scan]
    }
                    if let Some(ref c) = m.pages_pruned {
    use crate::indexed_table::bool_tree::ResolvedNode;
            _tree: &ResolvedNode,
    }
    /// `Some(ranges)` = call collector once per range.
        batch_offset: usize,
        let mut handles = Vec::with_capacity(parallel);
        // bitmap. A page is "pruned" if zero candidate bits fall within
            ) -> Result<CollectDocsResult, String> {
///
                candidates: roaring::RoaringBitmap::new(),
    map: HashMap<usize, RoaringBitmap>,
            let key = Arc::as_ptr(collector) as *const () as usize;
    collect_unique_collector_nodes(tree, &mut collectors, &mut seen);
        // RG-level early-exit: precomputed from column stats at construction.
        .unwrap();
    }
 * compatible open source license.
/// residual eval and the BitmapTree predicate eval-via-DF path need this —
/// On error, returns the first error encountered.
    /// Leaf source that returns empty bitmaps — enough to compose a
/// };
/// ```ignore
                    Some(_) if v == run_end + 1 => {
    /// savings). Higher values trade short-circuit savings for latency
            cost_collector: self.cost_collector,
    }
                    let (_key, node) = collectors_ref[i];
        rg_first_row: i64,
//! Swapping impls requires only passing different `Arc`s at construction.
                per_leaf: Vec::new(),
/// on the current `RecordBatch`. Every column referenced by a
        #[derive(Debug)]
    /// Counters recorded by `page_pruner.prune_rg` at each Predicate
pub enum CollectorCallStrategy {
    fn on_batch_mask(
//!
        batch: &RecordBatch,
        }
    ctx: &RgEvalContext,
            batch_len: usize,
            rg_idx: rg.index,
                }
        return Ok(PrecomputedLeafCache {
//! The trait methods operate on one RG. There is no `prefetch_shard` or
                    // use it for lookup (keys by Arc::as_ptr), so any
                &ctx,
/// accumulator results. Shared by both the single-collector and
    // leaf_bitmap, writes result into a shared Vec<Option<Result<...>>>
/// SELECT list. In production, substrait plans emitted by the planner project
    pub cost_collector: u32,
/// columns must explicitly expand the SELECT to include predicate columns.
    pub max_doc: i32,
        if let ResolvedNode::Collector { collector, .. } = tree {
    PageRangeSplit,
            handles.push(scope.spawn(move || {
    fn prefetch_rg(
//! - Memory stays bounded regardless of shard size.
        tree: &ResolvedNode,
    /// `on_batch_mask` over the full delivered batch (using `PositionMap`
        }
/// Duplicates (same Arc pointing at the same collector instance) are
        batch_offset: usize,
        // anchor = (min_doc - rg.first_row) shifts each relative bit.
    pub pruning_predicates: Arc<HashMap<usize, Arc<PruningPredicate>>>,
            map: HashMap::new(),
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int32, false)]));
use super::bool_tree::ResolvedNode;
    /// Plumbed from `DatafusionQueryConfig`; read on the hot path.
                    }
    expr: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
    let mut map = HashMap::with_capacity(n);
            _leaves: &dyn LeafBitmapSource,
        // AND child already emptied the accumulator). Governed by
            fallback: leaves,
#[derive(Debug, Clone)]
        self.fallback.leaf_bitmap(tree, leaf_dfs_index, ctx)
        ctx: &RgEvalContext,
    fn empty_pruner() -> Arc<PagePruner> {
/// `ResolvedNode::Predicate` in the tree **must be present in the batch**
    pub eval_nanos: u64,
}
impl<'a> LeafBitmapSource for PrecomputedLeafCache<'a> {
            )
            leaves: Arc::new(NoopLeaves),
    /// Controls how the AND evaluator narrows collector ranges from the
            let _ = h.join();
}
    /// `PartitionMetrics` at dispatch time.
    /// Max number of Collector leaves whose bitmaps are produced in
                collector: Arc::new(Dummy),
    match node {
        let leaves_ref: &dyn LeafBitmapSource = match &precomputed {
//! `evaluate_full_filter` method. Even when tree evaluation eventually moves
                    native_bridge_common::log_debug!(
    pub collector_strategy: CollectorCallStrategy,
            &self,
    /// - `position_map` translates delivered batch-row indices to RG-relative
    /// a circular dependency with the bitmap_tree module's own tests).
            let ctx_ref = ctx;
    /// Whether `IndexedStream` should build a post-decode `current_mask` from
        state: &TreePrefetch,
//! 1. **Tree evaluation strategy** ([`TreeEvaluator`]) — the algorithm that
    pub max_collector_parallelism: usize,
    /// `PositionMap` for Collector lookups. If parquet's pushdown
            if let Some(&pos) = self.rg_index_to_pos.get(&rg.index) {
            let mut rg_candidates = RoaringBitmap::new();
    FullRange,
            state,
    pub tree: Arc<ResolvedNode>,
    /// dispatch time by the caller. Empty = page-level predicate pruning
        ctx: &RgEvalContext,
        let t = Instant::now();
    // Zero or one collector → no benefit from parallelism, fall back to
    pub leaves: Arc<dyn LeafBitmapSource>,
    for (i, slot) in results.into_iter().enumerate() {
            cost_collector: 10,
) {
    /// candidates are the only per-row filter available post-decode).
//! 2. **Leaf bitmap source** ([`LeafBitmapSource`]) — given a `Collector`
            max_collector_parallelism: 1,
/// Composes a `TreeEvaluator` + `LeafBitmapSource` + `PagePruner` + resolved
                    c.add(num_pages);
            tree: Arc::new(ResolvedNode::Collector {
    leaves: &'a dyn LeafBitmapSource,
    pub cost_predicate: u32,
        tree: &ResolvedNode,
        // Use the precomputed cache as the LeafBitmapSource if present;
    /// back to "every row is a candidate" (safe, identity for the
    Ok(PrecomputedLeafCache {
            meta.metadata().clone(),
        }
    /// Candidate-stage leaf-reorder cost for `ResolvedNode::Collector`.
/// Rewrite Column indices in a PhysicalExpr to match the delivered batch's
        leaves: &dyn LeafBitmapSource,
/// satisfied. Test harnesses that bypass substrait and select only output
    /// shrink the candidate set.
        )
                "invariant violation: DelegationPossible reached \
    fn on_batch(
                    }
        let tmp = tempfile::NamedTempFile::new().unwrap();
        leaf_dfs_index: usize,
            &tmp.reopen().unwrap(),
    pub per_leaf: Vec<(usize, RoaringBitmap)>,
 *
    let next_idx = std::sync::atomic::AtomicUsize::new(0);
        rg_first_row: i64,
            mask_buffer: None,
        }))
            Some(precompute_collector_leaves(
                    let num_pages = page_row_counts.len();
            page_prune_metrics: None,
    // Bounded parallelism via std::thread::scope + a work queue Mutex.
        fn leaf_bitmap(
    /// Time spent producing the bitset (nanoseconds). For metrics.
    impl LeafBitmapSource for NoopLeaves {
/// # Batch projection requirement
        // `TreeBitsetSource::on_batch_mask` returns `Some(refinement_mask)`.
    }
    ) -> Result<Option<PrefetchedRg>, String>;
            schema.clone(),
    /// `Some`, `IndexedStream::build_mask` wraps a `BooleanBuffer` view
                        rg.index
                return Ok(bm.clone());
    /// `FullRange` disables narrowing. `PageRangeSplit` is not
        let state = rg_state.downcast_ref::<TreePrefetch>().ok_or_else(|| {
//! - Bitsets stay small (~512 bytes per RG).
        };
        let rg_candidates = if anchor == 0 {
        // short-circuit savings (all collectors run even if an earlier
/// The refinement stage evaluates `Predicate` leaves via Arrow cmp kernels
            eval_nanos,
            pruning_predicates: std::sync::Arc::new(HashMap::new()),
            slot.ok_or_else(|| format!("precompute: worker did not populate slot {}", i))??;
        leaf_dfs_index: usize,
    /// `index_filter(...)` UDF marker whose body panics.
    /// - `rg_state` is the `context` returned by the last `prefetch_rg` for
use super::page_pruner::PagePruneMetrics;
                if shifted < 0 || shifted > u32::MAX as i64 {
            }
            &self,
    /// accumulator bitmap.
    fallback: &'a dyn LeafBitmapSource,
                    let result = leaves_ref.leaf_bitmap(node, i, ctx_ref);
/// bitmap-tree evaluator paths.
                }
        Ok(Some(mask))
                    }
    /// ignore `current_mask` anyway). Default `true` keeps the current
        rg_state: &dyn Any,
            _ctx: &RgEvalContext,
            page_pruner: empty_pruner(),
        min_doc: i32,
    let mut results: Vec<Option<Result<RoaringBitmap, String>>> = (0..n).map(|_| None).collect();
                if let Some(page_row_counts) = self.page_pruner.page_row_counts(rg.index) {
            rg_num_rows: rg.num_rows,
                    return Ok(None);
        });
                provider_key: 0,
        batch_offset: usize,
            context: Box::new(prefetch),
        if let Some(ref ann) = self.stats_prune_tree {
//! `LeafBitmapSource` and exposes the composite as a `RowGroupBitsetSource`.
    /// filtering.
    /// Optional: pre-built Arrow `Buffer` holding `candidates` in
        rg: &RowGroupInfo,
        let batch = RecordBatch::try_new(
                // edge case at u32::MAX via saturating add (roaring
        })?;
        // page-level decision after AND/OR/NOT combination, not the
            .map_err(|e| format!("TreeBitsetSource::prefetch_rg(rg={}): {}", rg.index, e))?;
/// identity (implementation-defined — pointer or index) to that leaf's
/// Produces per-leaf bitmaps for one row group.
        }
/// same leaf.
    }
//!    leaf, produce its RoaringBitmap for this RG. Today: backend-backed
}
            batch,
                    let page_end = row_offset + count as u32;
        page_prune_metrics: Option<&PagePruneMetrics>,
use super::page_pruner::StatsPruneTree;
    TightenOuterBounds,
///
                    let mut guard = results_mutex_ref.lock().unwrap();
        }
/// `Arc::as_ptr(collector)`. Falls back to the inner source for leaves
}
        page_pruner: &PagePruner,
            candidates: rg_candidates,
        writer.write(&batch).unwrap();
//!
    pub context: Box<dyn Any + Send + Sync>,
    });
    /// record batch, consuming the candidate-stage `state` for the RG this
                &self.tree,
    })
        };
    // at the collector's index.
        for _worker in 0..parallel {
) -> Result<Arc<dyn datafusion::physical_expr::PhysicalExpr>, String> {
        &self,
/// Uses an `Arc<AtomicUsize>`-driven round-robin over pre-spawned worker
        assert!(!source.needs_row_mask());
            if seen.insert(key) {
            .prefetch(
    struct NoopLeaves;
}
                // after the bitmap tree is fully resolved.
//!
    /// candidate offsets on the full-scan strategy. `true` for evaluators
                _: i32,
                }
    /// position (identity under full-scan; non-trivial under block-granular
            rg_candidates
            collector_strategy: self.collector_strategy,
/// deduplicated by `Arc::as_ptr` so we don't call Lucene twice for the
//! [`IndexedStream`](crate::indexed_table::stream::IndexedStream) only depends
    struct NoopTreeEvaluator;
                    }
            rg_first_row: rg.first_row,
                }
                &ctx,
    /// Candidate doc-id bitmap, RG-relative (bit 0 = first row of the RG
    /// RowSelection). `batch_offset` is the delivered-row index of the
}
}
use datafusion::arrow::record_batch::RecordBatch;
                min_doc: 0,
                &self.page_pruner,
        // otherwise delegate directly to the original source (sequential).
    use crate::indexed_table::page_pruner::PagePruner;
/// at eval time, i.e. the physical plan's projection must include
    /// needs_row_mask test (we don't import BitmapTreeEvaluator here to avoid
            let results_mutex_ref = &results_mutex;
                collect_unique_collector_nodes(c, out, seen);
                    if let Some(ref c) = m.pages_total {
//! elsewhere:
        stats_prune_tree: Option<&StatsPruneTree>,
use datafusion::arrow::array::BooleanArray;
    /// Tighten to `[first_surviving, last_surviving)` before calling.
            }),
                flush(&mut rg_candidates, s, run_end);
                Ok(vec![].into())
                        flush(&mut rg_candidates, s, run_end);
    /// over this buffer (zero-copy) instead of rematerialising from the
        //
                }
                        run_end = v;
    /// superset RoaringBitmap of candidate doc IDs plus the per-leaf
///
        // Scope ensures all threads complete before returning.
        struct Dummy;
        let prefetch = self
        map.insert(collectors[i].0, bm);
use std::any::Any;
        batch_len: usize,
    use datafusion::physical_expr::expressions::Column;
}
    pub collector_call_ranges: Option<Vec<(i32, i32)>>,
    use crate::indexed_table::index::CollectDocsResult;
    /// `TreeBitsetSource` always returns `Some(mask)` from `on_batch_mask` —
                // Don't pass metrics here — per-leaf prune_rg calls would
/// `LeafBitmapSource::leaf_bitmap` calls in parallel via `std::thread::scope`,
            // All candidates pruned — record that every page was pruned.
    /// different size than the PositionMap expects, causing
        Self {
/// Pluggable tree-evaluation strategy. The algorithm that walks the tree,
    ///
            let leaves_ref = leaves;
            // Tree-path evaluator. Reaching this is a planner-contract violation.
pub mod predicate_evaluator;
                &self,
                    let i = next_idx_ref.fetch_add(1, std::sync::atomic::Ordering::Relaxed);
        let ctx = RgEvalContext {
        true
            for rel in prefetch.candidates.iter() {
            if let Some(col) = e.downcast_ref::<Column>() {
        )?;
    /// Anchor doc ID (same as `ctx.min_doc` at prefetch time) so the
        // `IndexedStream` should skip building it.
                 under OR/NOT before fragment conversion."
    /// packed bits internally (e.g. `SingleCollectorEvaluator`).
            _rg_first_row: i64,
//!
        ResolvedNode::Not(c) => collect_unique_collector_nodes(c, out, seen),
        writer.close().unwrap();
        rg_state: &dyn Any,
    pub stats_prune_tree: Option<Arc<StatsPruneTree>>,
    }
    expr.clone()
pub trait RowGroupBitsetSource: Send + Sync {
                let mut row_offset = 0u32;
        true
            }
                    row_offset = page_end;
        .unwrap();
                    }
 */
            batch_offset,
/// table schema; the delivered batch is projected (only predicate-referenced
    /// One FFM call, simple.
use super::stream::RowGroupInfo;
        if prefetch.candidates.is_empty() {
            let mut run_end: u32 = 0; // inclusive
            if let Some(page_row_counts) = self.page_pruner.page_row_counts(rg.index) {
                    // stable value works.
    /// `TightenOuterBounds` (default) uses a single `[min, max)` range.
pub struct TreeBitsetSource {
}
            let next_idx_ref = &next_idx;
        ResolvedNode::Predicate(_) => {}
            .evaluator
use std::time::Instant;
                        c.add(num_pages);
    /// map = no page-level predicate pruning; each Predicate leaf falls
                out.push((key, node));
                // Range API is half-open; end_inclusive+1 handles the
            rg_first_row,
    /// Refinement stage: produce the exact per-row `BooleanArray` for one
        fn on_batch(
///     leaves: Arc::new(CollectorLeafBitmaps::without_metrics()),           // or ParquetStatsLeaves
    max_parallel: usize,
}
    ///
    pub collector_strategy: CollectorCallStrategy,
    ) -> Result<RoaringBitmap, String>;
                        run_start = Some(v);
        position_map: &PositionMap,
    /// Call collector once for the full `[min_doc, max_doc)` range.
 * The OpenSearch Contributors require contributions made to
    }
        Ok(Some(PrefetchedRg {
                        run_end = v;
        fallback: leaves,
    fn needs_row_mask(&self) -> bool {
pub trait TreeEvaluator: Send + Sync {
        let mut writer = ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), None).unwrap();
/// schema by name. Substrait-decoded predicates carry indices into the full
        &self,
        ))
            Ok(BooleanArray::from(vec![false; batch_len]))
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
    batch: &RecordBatch,
        // `finalize_batch` ignores `current_mask` in that branch, so
    }
    pub page_pruner: Arc<PagePruner>,
    /// back to "every row is a candidate").
            }));
    pub candidates: RoaringBitmap,
    ///   this RG — evaluators downcast it to their own per-RG state type.
    /// scanned per call but more FFM calls. Best when the collector is
    /// So: always forbid parquet pushdown for BitmapTree. Phase 2
/// Identified by DFS index in `tree`. Bitmap domain is `[ctx.min_doc, ctx.max_doc)`.
            vec![Arc::new(Int32Array::from(vec![0i32; 4]))],
/// batch.
        &self,
        // coalesce consecutive bits into `insert_range` calls so we
        // Optional: materialise all Collector leaves in parallel before
            return Ok(None);
    }
    fn prefetch(
    /// RowSelection-delivered rowset (e.g.
        &self,
    }
 * SPDX-License-Identifier: Apache-2.0
    pub page_prune_metrics: Option<PagePruneMetrics>,
    /// mask (e.g. `TreeBitsetSource` — refinement is authoritative and would
    /// to be OFF. `true` when the evaluator applies its own refinement in
        // Fast path: if `anchor == 0`, clone directly — no shift
            let mut flush = |bm: &mut RoaringBitmap, start: u32, end_inclusive: u32| {
                if let Some(ref c) = m.pages_pruned {
    #[test]
                        run_start = Some(v);
    ///
    /// `min_skip_run` and keeps the matching `PositionMap` alongside for
            )?)
    ) -> Result<Option<BooleanArray>, String>;
        let precomputed = if self.max_collector_parallelism > 1 {
            }
        rg_index_to_pos: &HashMap<usize, usize>,
                }
    pub rg_first_row: i64,
            _batch_offset: usize,
                }
        // `PrefetchedRg.candidates` is in RG-relative space [0, rg.num_rows).
/*
                let end = end_inclusive.saturating_add(1);
                        run_end = v;
        }
                    guard[i] = Some(result);
        }
/// predicate columns, not just the final
//!    exact per-batch mask. Today: [`bitmap_tree::BitmapTreeEvaluator`].
                let mut pruned = 0usize;
    /// `pruning_predicates` maps each `Predicate(expr)` leaf (keyed by
    use crate::indexed_table::index::RowGroupDocsCollector;
///     tree: Arc::new(resolved),
                _: i32,
impl RowGroupBitsetSource for TreeBitsetSource {
        false
            let mut run_start: Option<u32> = None;
            None => &*self.leaves,
//! # Invariant — row-group-at-a-time
        position_map: &PositionMap,
///
    pub cost_predicate: u32,
        }
    /// `None` = no narrowing (use full `[min_doc, max_doc)`).
            batch_len,
    impl TreeEvaluator for NoopTreeEvaluator {
    let n = collectors.len();
}
    /// recommended here — multiple FFM calls per collector per RG can
        tree: &ResolvedNode,
    pub min_doc: i32,
    fn leaf_bitmap(
        };
                let v = shifted as u32;
    pub min_doc: i32,
            meta.schema().clone(),
        Arc::new(PagePruner::new(
pub mod single_collector;
    fn needs_row_mask(&self) -> bool {
    /// refinement stage can convert batch offsets to doc IDs.
                self.stats_prune_tree.as_deref(),
            }
        }
            }
use roaring::RoaringBitmap;
        rg: &RowGroupInfo,
        }
/// Multi-filter tree path: pluggable tree evaluator + leaf bitmap source
            &self.tree,
        batch_len: usize,
//!
    /// bitmap side-table that the refinement stage will read.
/// threads so we never exceed `max_parallel` concurrent Lucene calls.
    /// reduction on multi-collector trees; bounded by caller's config.
            collector_call_ranges: None,
        ) -> Result<TreePrefetch, String> {
        };
        false
    /// `on_batch_mask`, or `TreeBitsetSource` which always refines).
                    c.add(pruned);
        &self,
    }
    pub cost_collector: u32,
        if let Some(ref m) = self.page_prune_metrics {
    ) -> Result<BooleanArray, String>;
        ) -> Result<BooleanArray, String> {
/// Walk the resolved tree and collect (key, collector-node-reference)
pub mod bitmap_tree;
            cost_predicate: self.cost_predicate,
        ) -> Result<roaring::RoaringBitmap, String> {
//! # Pluggable tree evaluation (multi-filter tree path)
                for &count in &page_row_counts {
    ///   stage's RowSelection is authoritative).
    use super::*;
    /// time so `prefetch_rg` doesn't need an `Arc` deref on the hot path.
            None
    /// is wasted work.
    /// `Arc::as_ptr` identity) to a pre-built `PruningPredicate`. Empty
    if collectors.len() <= 1 {
    /// candidate stage).
    /// dropped rows mid-decode, our delivered batch would have a
            _idx: usize,
            min_doc,
            _stats_prune_tree: Option<&StatsPruneTree>,
//! on [`RowGroupBitsetSource`]. The source of the bitset is abstracted.
//!
            position_map,
        .map_err(|e| format!("remap_expr_to_batch: {}", e))
//! [`TreeBitsetSource`] composes any `TreeEvaluator` with any
    /// misalign indices.
    use datafusion::common::tree_node::TreeNode;
    /// misaligned Collector lookups. Plus, the pushdown predicate
/// columns) so the indices need to be reseated. Both the SingleCollector
    /// post-decode alignment.
    /// Precomputed per-subtree RG match vectors. Built once at construction.
            stats_prune_tree: None,
pub(super) fn remap_expr_to_batch(
        &self,
        // needed. Otherwise walk the source in sorted order and
        max_doc: i32,
/// bounded by `max_parallel`. Returns a cache keyed by `Arc::as_ptr(collector)`.
    /// expensive and pruning is heavy.
                }
/// Context for evaluating a tree against one row group.
            _state: &TreePrefetch,
        batch: &RecordBatch,
/// predicate columns as part of the filter node, so this is naturally
    fn on_batch_mask(
        // Compute final page-level pruning metrics from the resolved
    ) -> Result<RoaringBitmap, String> {
                        return Ok(datafusion::common::tree_node::Transformed::yes(remapped));
            })
    /// leaf in the tree walk. Populated from the stream's
            // Invariant: planner drops performance peers under OR/NOT before
                if let Some(ref c) = m.pages_total {
    /// TreeBitsetSource purely for testing its `needs_row_mask` override.
    /// path, which doesn't do refinement [post-scan]).
        let source = TreeBitsetSource {
                            as Arc<dyn datafusion::physical_expr::PhysicalExpr>;
fn collect_unique_collector_nodes<'a>(
    /// `SingleCollectorEvaluator` when it owns the residual filter in
    ///   block-granular RowSelection).
            _ctx: &RgEvalContext,
            };
    /// disabled (the tree path still works, each Predicate leaf falls
        max_doc: i32,
                        break;
        map,
///     page_pruner: Arc::new(pruner),
                self.max_collector_parallelism,
struct PrecomputedLeafCache<'a> {
    ) -> Result<TreePrefetch, String>;
    /// Build candidate[pre-scan] bitset for this RG. `None` = skip RG entirely.
            Some(c) => c,
    /// Whether this evaluator requires parquet's `with_predicate` pushdown
/// Materialise all Collector leaves of `tree` by running their
            }
    /// Evaluator that mirrors the shape of BitmapTreeEvaluator for the trait
    /// Helper for evaluators with no per-RG state (e.g. the single-collector
                &self.rg_index_to_pos,
//!
                    continue;
                // clamps at u32::MAX internally).
                    if new_idx != col.index() {
                    );
    /// Opaque per-RG state threaded to `on_batch_mask` via `rg_state: &dyn Any`.
            _batch: &RecordBatch,
}
///     evaluator: Arc::new(BitmapTreeEvaluator),        // or JavaTreeEvaluator
/// pairs for every Collector leaf, in DFS order (matching the
        let mask = self.evaluator.on_batch(
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
                 collect_unique_collector_nodes. Planner must drop performance peers \
    /// `Arc::as_ptr(resolved_predicate) as usize`. Built once per query at
        } else {
//!    walks the tree, combines bitmaps, produces superset candidates +
    seen: &mut HashSet<usize>,
impl PrefetchedRg {
    pub rg_num_rows: i64,
pub trait LeafBitmapSource: Send + Sync {
            candidates,
    /// first row in this batch.
    /// doc range). `IndexedStream` converts this to a `RowSelection` using
use datafusion::physical_optimizer::pruning::PruningPredicate;
        let anchor = (min_doc as i64) - rg.first_row;
        &self,
    }
        } else {
use std::collections::{HashMap, HashSet};
            }
    pub candidates: RoaringBitmap,
        impl RowGroupDocsCollector for Dummy {
    node: &'a ResolvedNode,
        // running the tree walk. Preserves correctness; sacrifices AND/OR
}
pub struct PrefetchedRg {
//! - Prefetch overlaps the next RG's bitset with the current RG's parquet read.
#[cfg(test)]
    /// its
        batch: &RecordBatch,
    /// Arrow's native LSB-first bit layout, length = rg_num_rows. When
    let results_mutex = std::sync::Mutex::new(&mut results);
    tree: &'a ResolvedNode,
                let shifted = rel as i64 + anchor;
    /// `RoaringBitmap`. Set by evaluators that already produced the
    /// Candidate-stage leaf-reorder cost for `ResolvedNode::Predicate`.
) -> Result<PrecomputedLeafCache<'a>, String> {
        // `max_collector_parallelism`: 1 = sequential (today).
    ) -> Result<Option<PrefetchedRg>, String> {
            _page_pruner: &PagePruner,
/// combines per-leaf bitmaps, produces candidates + per-batch masks.
/// Per-row-group bitset producer. Plugs into `IndexedStream`.
/// bitmap in the same domain, which the refinement stage looks up per
///
        ResolvedNode::DelegationPossible { .. } => {
                bm.insert_range(start..end);
            ArrowReaderOptions::new().with_page_index(true),
    fn leaf_bitmap(
/// Usage:
pub mod eval_helpers;
    fn tree_bitset_source_does_not_need_row_mask() {
        // `prefetch.candidates` is in min_doc-relative space [0, max_doc - min_doc).
/// not in the map (shouldn't happen in practice — we populate the map
//!    (FFM upcall + bitset expansion).
    // Assemble results. Fail fast on the first error.
    /// Overridden to `true` by evaluators that must see the complete
                loop {
            _pruning_predicates: &HashMap<usize, Arc<PruningPredicate>>,
    /// whose `on_batch_mask` returns `None` (e.g. `SingleCollectorEvaluator` —
    /// - `None` = no refinement mask needed (e.g. `SingleCollectorEvaluator`
                &self.pruning_predicates,
pub struct RgEvalContext {
        }
    fn forbid_parquet_pushdown(&self) -> bool {
///
                &self.tree,
pub struct TreePrefetch {
        tree: &ResolvedNode,
        }
        fn prefetch(
//! boolean tree evaluation happens.
            )
        // get one O(log n) call per run instead of O(1) per bit.
//! For tree queries, evaluation has two orthogonal concerns:
/// ```
        let bm =
/// How a collector's doc-range is narrowed relative to page-pruning or
fn precompute_collector_leaves<'a>(
    /// Reverse map: absolute RG index → position in `rg_can_match` vectors.
use super::row_selection::PositionMap;
                leaves_ref,
    // Each worker pulls the next collector to evaluate, calls
    /// BitmapTree walks the BoolNode in `on_batch_mask` using
            }
        };
    /// `false` for evaluators whose `on_batch_mask` returns an exact refinement
            unimplemented!(
    /// Skips leading/trailing dead ranges. One FFM call, never regresses.
            max_doc,
    }
use std::sync::Arc;
                        let remapped = Arc::new(Column::new(col.name(), new_idx))
    /// Narrowed doc-id ranges for Collector FFM calls. Computed by the
                    // Use i as the leaf_dfs_index — the cache doesn't
        .transform(|e| {
            Ok(roaring::RoaringBitmap::new())
/// shared here to avoid duplication.
    let parallel = max_parallel.min(n).max(1);
            fn collect_packed_u64_bitset(
//! Row-group-level bitset sources — the pluggability seam for where
        // its row range; "kept" otherwise. This reflects the actual
/// bitmap of doc IDs relative to `ctx.min_doc`; `per_leaf` maps leaf
            if let Some(ref m) = self.page_prune_metrics {
}
    pub fn without_context(candidates: RoaringBitmap, eval_nanos: u64) -> Self {
        ResolvedNode::And(children) | ResolvedNode::Or(children) => {
    /// Pre-extracted from `DatafusionQueryConfig` at source-construction
                if let Ok(new_idx) = batch.schema().index_of(col.name()) {
            eval_nanos: t.elapsed().as_nanos() as u64,
        ctx: &RgEvalContext,
            prefetch.candidates.clone()
    ///
    /// ignores `current_mask` in that branch, so building it from candidates
/// LeafBitmapSource that serves from a pre-populated map keyed by
    ///
            _position_map: &PositionMap,
/// let source = TreeBitsetSource {
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
    /// for Collector lookups) — pushdown would drop rows mid-decode and
    /// behaviour for any future evaluator that forgets to override.
    /// `position_map` translates delivered batch-row index to RG-relative
    fn forbid_parquet_pushdown(&self) -> bool {
            }
            if let Some(s) = run_start {
    pub rg_index_to_pos: HashMap<usize, usize>,
            rg_index_to_pos: HashMap::new(),
            _page_prune_metrics: Option<&PagePruneMetrics>,
    let mut collectors: Vec<(usize, &ResolvedNode)> = Vec::new();
                    }
    pub evaluator: Arc<dyn TreeEvaluator>,
            &self,
    ///   positions (identity under full-scan; non-trivial under
            let key = Arc::as_ptr(collector) as *const () as usize;
            "TreeBitsetSource::on_batch_mask: rg_state is not TreePrefetch".to_string()
    /// parallel per RG prefetch. 1 = sequential (preserves short-circuit
        let meta = ArrowReaderMetadata::load(
/// with every Collector leaf in the tree before invoking the evaluator).
        position_map: &PositionMap,
            mask_buffer: None,
        }
    /// Candidate stage: walk the tree for one row group and produce a
    /// will do the actual filter and produce filtered values.
                match run_start {
                        "BitmapTree: skipping RG {} — pruned by RG-level stats",
    /// Default `false`: pushdown decided by the stream's base policy.
/// tree into a `RowGroupBitsetSource`.
        )
            collector_strategy: CollectorCallStrategy::TightenOuterBounds,
                &*self.leaves,
/// evaluator's walk order — we don't care about order beyond determinism).
                    None => {
            Ok(TreePrefetch {
                    if i >= collectors_ref.len() {
                        pruned += 1;
use super::page_pruner::PagePruner;
            _rg_index_to_pos: &HashMap<usize, usize>,
            Ok(datafusion::common::tree_node::Transformed::no(e))
    /// be expensive in multi-collector trees.
    /// Evaluators downcast to their own concrete type.
    /// Per-predicate `PruningPredicate` cache, keyed by
            _tree: &ResolvedNode,
            if let Some(bm) = self.map.get(&key) {
    std::thread::scope(|scope| {
            let collectors_ref = &collectors;
            cost_predicate: 1,
    /// Call collector once per contiguous surviving range. Fewer docs
    ) -> Result<Option<BooleanArray>, String> {
        &self,
/// Output of `prefetch_rg`.
        rg_first_row: i64,
        .map(|t| t.data)
                let num_pages = page_row_counts.len();
                    }
    pub mask_buffer: Option<Buffer>,
                if let Some(&false) = ann.rg_can_match.get(pos) {
            for c in children {
    ///   relies on DataFusion's own predicate pushdown, so the candidate
    /// batch belongs to.
                    Some(s) => {
        })
