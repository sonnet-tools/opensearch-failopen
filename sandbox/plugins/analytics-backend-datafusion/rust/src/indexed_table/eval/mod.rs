pub trait RowGroupBitsetSource: Send + Sync {
    ///   block-granular RowSelection).
        false
            prefetch.candidates.clone()
        let precomputed = if self.max_collector_parallelism > 1 {
    /// So: always forbid parquet pushdown for BitmapTree. Phase 2
/// ```
use datafusion::arrow::array::BooleanArray;
                }
            pruning_predicates: std::sync::Arc::new(HashMap::new()),
    ) -> Result<TreePrefetch, String>;
    /// candidates are the only per-row filter available post-decode).
            rg_candidates
                    if i >= collectors_ref.len() {
/// pairs for every Collector leaf, in DFS order (matching the
    }
/// ```ignore
    /// Precomputed per-subtree RG match vectors. Built once at construction.
/// Usage:
    impl TreeEvaluator for NoopTreeEvaluator {
) -> Result<Arc<dyn datafusion::physical_expr::PhysicalExpr>, String> {
/// Produces per-leaf bitmaps for one row group.
        // bitmap. A page is "pruned" if zero candidate bits fall within
                if let Some(&false) = ann.rg_can_match.get(pos) {
    leaves: &'a dyn LeafBitmapSource,
        let batch = RecordBatch::try_new(
//! # Pluggable tree evaluation (multi-filter tree path)
///     tree: Arc::new(resolved),
                out.push((key, node));
                for &count in &page_row_counts {
/// Pluggable tree-evaluation strategy. The algorithm that walks the tree,
                match run_start {
                    }
        &self,
            &tmp.reopen().unwrap(),
/// columns must explicitly expand the SELECT to include predicate columns.
    pub stats_prune_tree: Option<Arc<StatsPruneTree>>,
    /// `None` = no narrowing (use full `[min_doc, max_doc)`).
        let anchor = (min_doc as i64) - rg.first_row;
                }
    /// dropped rows mid-decode, our delivered batch would have a
            return Ok(None);
    /// behaviour for any future evaluator that forgets to override.
    /// refinement stage can convert batch offsets to doc IDs.
    PageRangeSplit,
    /// Whether `IndexedStream` should build a post-decode `current_mask` from
}
/*
            _position_map: &PositionMap,
    });
            }
/// # Batch projection requirement
        tree: &ResolvedNode,
                    let (_key, node) = collectors_ref[i];
impl RowGroupBitsetSource for TreeBitsetSource {
        // otherwise delegate directly to the original source (sequential).
            "TreeBitsetSource::on_batch_mask: rg_state is not TreePrefetch".to_string()
    collect_unique_collector_nodes(tree, &mut collectors, &mut seen);
    }
pub trait TreeEvaluator: Send + Sync {
            let leaves_ref = leaves;
            meta.metadata().clone(),
        rg_state: &dyn Any,
                // after the bitmap tree is fully resolved.
    fn on_batch_mask(
            if let Some(s) = run_start {
    use crate::indexed_table::page_pruner::PagePruner;
    /// `Some(ranges)` = call collector once per range.
    let mut results: Vec<Option<Result<RoaringBitmap, String>>> = (0..n).map(|_| None).collect();
                candidates: roaring::RoaringBitmap::new(),
    // Assemble results. Fail fast on the first error.
pub trait LeafBitmapSource: Send + Sync {
    /// expensive and pruning is heavy.
        fn leaf_bitmap(
                bm.insert_range(start..end);
        if let Some(ref m) = self.page_prune_metrics {
        rg_index_to_pos: &HashMap<usize, usize>,
            _leaves: &dyn LeafBitmapSource,
    // an empty cache (evaluator will use the fallback synchronously).
pub mod predicate_evaluator;
    /// RowSelection). `batch_offset` is the delivered-row index of the
            }
/// LeafBitmapSource that serves from a pre-populated map keyed by
    /// to be OFF. `true` when the evaluator applies its own refinement in
    pub page_pruner: Arc<PagePruner>,
    let mut seen = HashSet::new();
    /// Call collector once per contiguous surviving range. Fewer docs
    fn prefetch_rg(
    ///
fn collect_unique_collector_nodes<'a>(
        let bm =
    /// Evaluator that mirrors the shape of BitmapTreeEvaluator for the trait
    use crate::indexed_table::bool_tree::ResolvedNode;
//! `evaluate_full_filter` method. Even when tree evaluation eventually moves
            // All candidates pruned — record that every page was pruned.
    /// Candidate-stage leaf-reorder cost for `ResolvedNode::Predicate`.
///
/// residual eval and the BitmapTree predicate eval-via-DF path need this —
        ))
                // Don't pass metrics here — per-leaf prune_rg calls would
    /// Helper for evaluators with no per-RG state (e.g. the single-collector
    /// `Arc::as_ptr` identity) to a pre-built `PruningPredicate`. Empty
            fn collect_packed_u64_bitset(
        }
        // get one O(log n) call per run instead of O(1) per bit.
            _rg_index_to_pos: &HashMap<usize, usize>,
            batch_offset,
pub(super) fn remap_expr_to_batch(
                let shifted = rel as i64 + anchor;
    #[test]
//!
#[cfg(test)]
        fn prefetch(
use std::collections::{HashMap, HashSet};
        batch: &RecordBatch,
    ///   relies on DataFusion's own predicate pushdown, so the candidate
            _tree: &ResolvedNode,
        let state = rg_state.downcast_ref::<TreePrefetch>().ok_or_else(|| {
            cost_collector: 10,
            collector_call_ranges: None,
    pub min_doc: i32,
                    if rg_candidates.range(row_offset..page_end).next().is_none() {
    /// `false` for evaluators whose `on_batch_mask` returns an exact refinement
mod tests {
            )
    let mut map = HashMap::with_capacity(n);
    /// `FullRange` disables narrowing. `PageRangeSplit` is not
            rg_first_row,
    /// leaf in the tree walk. Populated from the stream's
            }
/// accumulator results. Shared by both the single-collector and
//! The trait methods operate on one RG. There is no `prefetch_shard` or
            let mut rg_candidates = RoaringBitmap::new();
/// predicate columns as part of the filter node, so this is naturally
            rg_first_row: rg.first_row,
//!    walks the tree, combines bitmaps, produces superset candidates +
        // `IndexedStream` should skip building it.
        batch_offset: usize,
    /// Leaf source that returns empty bitmaps — enough to compose a
            if seen.insert(key) {
            candidates: rg_candidates,
use datafusion::arrow::buffer::Buffer;
        writer.close().unwrap();
        impl RowGroupDocsCollector for Dummy {
    }
                None,
                        c.add(num_pages);
//!    leaf, produce its RoaringBitmap for this RG. Today: backend-backed
}
    expr: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
    fn on_batch(
/// Identified by DFS index in `tree`. Bitmap domain is `[ctx.min_doc, ctx.max_doc)`.
                let mut row_offset = 0u32;
use super::bool_tree::ResolvedNode;
/// on the current `RecordBatch`. Every column referenced by a
        .unwrap();
                    }
            handles.push(scope.spawn(move || {
                        rg.index
    }
    pub cost_collector: u32,
    /// filtering.
/// Duplicates (same Arc pointing at the same collector instance) are
            unimplemented!(
    fn leaf_bitmap(
}
            let key = Arc::as_ptr(collector) as *const () as usize;
/// threads so we never exceed `max_parallel` concurrent Lucene calls.
            rg_num_rows: rg.num_rows,
        )
        fallback: leaves,
                    }
                    continue;
        &self,
            _pruning_predicates: &HashMap<usize, Arc<PruningPredicate>>,
    /// misalign indices.
    /// Opaque per-RG state threaded to `on_batch_mask` via `rg_state: &dyn Any`.
                // edge case at u32::MAX via saturating add (roaring
pub mod bitmap_tree;
                }
    pub collector_strategy: CollectorCallStrategy,
    /// savings). Higher values trade short-circuit savings for latency
        Ok(Some(mask))
            cost_predicate: 1,
}
        &self,
        // `prefetch.candidates` is in min_doc-relative space [0, max_doc - min_doc).
            meta.schema().clone(),
                }
            _stats_prune_tree: Option<&StatsPruneTree>,
            min_doc,
            }
            schema.clone(),
                    c.add(num_pages);
    // Each worker pulls the next collector to evaluate, calls
        ResolvedNode::Predicate(_) => {}
        for _worker in 0..parallel {
            batch,
                }
        for h in handles {
                    }
            state,
    fn leaf_bitmap(
/// Candidate-stage output of a `TreeEvaluator`. `candidates` is a superset
                self.max_collector_parallelism,
//! boolean tree evaluation happens.
 *
//! elsewhere:
pub struct TreeBitsetSource {
    use crate::indexed_table::index::RowGroupDocsCollector;
            Ok(datafusion::common::tree_node::Transformed::no(e))
        struct Dummy;
use super::page_pruner::PagePruneMetrics;
                    }
    pub candidates: RoaringBitmap,
    let parallel = max_parallel.min(n).max(1);
        false
    /// over this buffer (zero-copy) instead of rematerialising from the
    /// ignores `current_mask` in that branch, so building it from candidates
    }
                    guard[i] = Some(result);
    /// One FFM call, simple.
                if shifted < 0 || shifted > u32::MAX as i64 {
                        break;
}
                flush(&mut rg_candidates, s, run_end);
            None => &*self.leaves,
}
    let next_idx = std::sync::atomic::AtomicUsize::new(0);
//! Swapping impls requires only passing different `Arc`s at construction.
pub mod single_collector;
                if let Some(page_row_counts) = self.page_pruner.page_row_counts(rg.index) {
    /// needs_row_mask test (we don't import BitmapTreeEvaluator here to avoid
        } else {
    max_parallel: usize,
                // clamps at u32::MAX internally).
    /// Build candidate[pre-scan] bitset for this RG. `None` = skip RG entirely.
    /// RowSelection-delivered rowset (e.g.
        // Fast path: if `anchor == 0`, clone directly — no shift
    /// Plumbed from `DatafusionQueryConfig`; read on the hot path.
        // RG-level early-exit: precomputed from column stats at construction.
    fn empty_pruner() -> Arc<PagePruner> {
                            as Arc<dyn datafusion::physical_expr::PhysicalExpr>;
 * this file be licensed under the Apache-2.0 license or a
//!
    /// batch belongs to.
    let mut collectors: Vec<(usize, &ResolvedNode)> = Vec::new();
    }
    /// Reverse map: absolute RG index → position in `rg_can_match` vectors.
            _idx: usize,
            if let Some(bm) = self.map.get(&key) {
    // at the collector's index.
/// with every Collector leaf in the tree before invoking the evaluator).
            _page_prune_metrics: Option<&PagePruneMetrics>,
    // leaf_bitmap, writes result into a shared Vec<Option<Result<...>>>
use super::page_pruner::StatsPruneTree;
    pub max_doc: i32,
        // `finalize_batch` ignores `current_mask` in that branch, so
    tree: &'a ResolvedNode,
            cost_predicate: self.cost_predicate,
    /// Controls how the AND evaluator narrows collector doc ranges.
}
            rg_idx: rg.index,
    /// Time spent producing the bitset (nanoseconds). For metrics.
                return Ok(bm.clone());
    /// Max number of Collector leaves whose bitmaps are produced in
        let mut handles = Vec::with_capacity(parallel);
                let num_pages = page_row_counts.len();
use super::row_selection::PositionMap;
    use datafusion::arrow::array::Int32Array;
/// satisfied. Test harnesses that bypass substrait and select only output
    /// post-decode alignment.
            }),
    seen: &mut HashSet<usize>,
        position_map: &PositionMap,
/// batch.
            batch_len,
    /// different size than the PositionMap expects, causing
    }
        state: &TreePrefetch,
/// The refinement stage evaluates `Predicate` leaves via Arrow cmp kernels
                }
 * The OpenSearch Contributors require contributions made to
        batch_len: usize,
            Some(precompute_collector_leaves(
    pub rg_num_rows: i64,
                    let i = next_idx_ref.fetch_add(1, std::sync::atomic::Ordering::Relaxed);
        ctx: &RgEvalContext,
            &self,
    fn prefetch(
    use crate::indexed_table::index::CollectDocsResult;
        }
            _batch: &RecordBatch,
/// };
        rg: &RowGroupInfo,
        // needed. Otherwise walk the source in sorted order and
            // Tree-path evaluator. Reaching this is a planner-contract violation.
            max_doc,
    /// Pre-extracted from `DatafusionQueryConfig` at source-construction
/// predicate columns, not just the final
        return Ok(PrecomputedLeafCache {
        })?;
    pub evaluator: Arc<dyn TreeEvaluator>,
/// Rewrite Column indices in a PhysicalExpr to match the delivered batch's
/// Walk the resolved tree and collect (key, collector-node-reference)
                }
    pub rg_index_to_pos: HashMap<usize, usize>,
    /// Skips leading/trailing dead ranges. One FFM call, never regresses.
        // anchor = (min_doc - rg.first_row) shifts each relative bit.
            let collectors_ref = &collectors;
    /// Anchor doc ID (same as `ctx.min_doc` at prefetch time) so the
    ) -> Result<Option<PrefetchedRg>, String> {
                    row_offset = page_end;
    ) -> Result<Option<BooleanArray>, String> {
/// identity (implementation-defined — pointer or index) to that leaf's
            Some(c) => c,
            eval_nanos: t.elapsed().as_nanos() as u64,
            Ok(BooleanArray::from(vec![false; batch_len]))
            context: Box::new(()),
        true
            };
            let mut run_end: u32 = 0; // inclusive
        leaf_dfs_index: usize,
        }
            _batch_offset: usize,
/// Multi-filter tree path: pluggable tree evaluator + leaf bitmap source
        }
    /// the refinement mask is the exact per-row answer. `finalize_batch`
    batch: &RecordBatch,
            }
    /// be expensive in multi-collector trees.
        ctx: &RgEvalContext,
//! on [`RowGroupBitsetSource`]. The source of the bitset is abstracted.
    /// Produce exact per-batch `BooleanArray` mask for refinement-stage [post-scan]
    /// Candidate stage: walk the tree for one row group and produce a
    /// packed bits internally (e.g. `SingleCollectorEvaluator`).
            eval_nanos,
            let next_idx_ref = &next_idx;
    /// Arrow's native LSB-first bit layout, length = rg_num_rows. When
            )
                leaves_ref,
    ///   stage's RowSelection is authoritative).
                 under OR/NOT before fragment conversion."
    if collectors.len() <= 1 {
    }
    /// superset RoaringBitmap of candidate doc IDs plus the per-leaf
    /// `Some`, `IndexedStream::build_mask` wraps a `BooleanBuffer` view
    /// candidate stage).
        };
            &self.tree,
use super::stream::RowGroupInfo;
            &self,
//! 1. **Tree evaluation strategy** ([`TreeEvaluator`]) — the algorithm that
    ) -> Result<RoaringBitmap, String> {
            context: Box::new(prefetch),
                        flush(&mut rg_candidates, s, run_end);
/// evaluator's walk order — we don't care about order beyond determinism).
            candidates,
    /// `SingleCollectorEvaluator` when it owns the residual filter in
) {
pub struct PrefetchedRg {
                    Some(_) if v == run_end + 1 => {
        pruning_predicates: &HashMap<usize, Arc<PruningPredicate>>,
/// How a collector's doc-range is narrowed relative to page-pruning or
        writer.write(&batch).unwrap();
        &self,
        &self,
    fn needs_row_mask(&self) -> bool {
    /// path, which doesn't do refinement [post-scan]).
            _ctx: &RgEvalContext,
/// shared here to avoid duplication.
//! [`IndexedStream`](crate::indexed_table::stream::IndexedStream) only depends
use datafusion::arrow::record_batch::RecordBatch;
    pub rg_idx: usize,
        } else {
                    return Ok(None);
    /// whose `on_batch_mask` returns `None` (e.g. `SingleCollectorEvaluator` —
                        pruned += 1;
                &self.tree,
        // `PrefetchedRg.candidates` is in RG-relative space [0, rg.num_rows).
/// table schema; the delivered batch is projected (only predicate-referenced
        tree: &ResolvedNode,
    let n = collectors.len();
            }
            }
        let source = TreeBitsetSource {
    /// will do the actual filter and produce filtered values.
        rg_first_row: i64,
//! - Prefetch overlaps the next RG's bitset with the current RG's parquet read.
                &self,
    ///
            page_prune_metrics: None,
///
                        run_end = v;
                    c.add(pruned);
                        c.add(num_pages);
    /// dispatch time by the caller. Empty = page-level predicate pruning
        Arc::new(PagePruner::new(
///
    /// scanned per call but more FFM calls. Best when the collector is
            )?)
}
        // Compute final page-level pruning metrics from the resolved
    /// `on_batch_mask`, or `TreeBitsetSource` which always refines).
    }
use std::time::Instant;
    /// a circular dependency with the bitmap_tree module's own tests).
            if let Some(ref m) = self.page_prune_metrics {
                _: i32,
    /// Call collector once for the full `[min_doc, max_doc)` range.
}
    node: &'a ResolvedNode,
        // Scope ensures all threads complete before returning.
    pub collector_call_ranges: Option<Vec<(i32, i32)>>,
/// combines per-leaf bitmaps, produces candidates + per-batch masks.
        leaf_dfs_index: usize,
    })
        let prefetch = self
    /// - `rg_state` is the `context` returned by the last `prefetch_rg` for
        if let Some(ref ann) = self.stats_prune_tree {
            _ctx: &RgEvalContext,
            .map_err(|e| format!("TreeBitsetSource::prefetch_rg(rg={}): {}", rg.index, e))?;
    }
    ///
            _rg_first_row: i64,
    /// recommended here — multiple FFM calls per collector per RG can
/// let source = TreeBitsetSource {
        let tmp = tempfile::NamedTempFile::new().unwrap();
            _tree: &ResolvedNode,
                let mut pruned = 0usize;
    TightenOuterBounds,
    fn forbid_parquet_pushdown(&self) -> bool {
/// schema by name. Substrait-decoded predicates carry indices into the full
        }
        rg: &RowGroupInfo,
/// Context for evaluating a tree against one row group.
                    native_bridge_common::log_debug!(
        let mut writer = ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), None).unwrap();
/// bitmap of doc IDs relative to `ctx.min_doc`; `per_leaf` maps leaf
        ResolvedNode::DelegationPossible { .. } => {
    /// Tighten to `[first_surviving, last_surviving)` before calling.
                &self.page_pruner,
            _state: &TreePrefetch,
    pub candidates: RoaringBitmap,
            leaves: Arc::new(NoopLeaves),
            _tree: &ResolvedNode,
            mask_buffer: None,
        let mask = self.evaluator.on_batch(
    /// `position_map` translates delivered batch-row index to RG-relative
    /// Counters recorded by `page_pruner.prune_rg` at each Predicate
        position_map: &PositionMap,
    struct NoopTreeEvaluator;
            max_collector_parallelism: 1,
    /// back to "every row is a candidate").
        stats_prune_tree: Option<&StatsPruneTree>,
                    Some(s) => {
//! For tree queries, evaluation has two orthogonal concerns:
            collector_strategy: CollectorCallStrategy::TightenOuterBounds,
        ) -> Result<BooleanArray, String> {
            }
    pub context: Box<dyn Any + Send + Sync>,
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int32, false)]));
        rg_first_row: i64,
                    }
impl<'a> LeafBitmapSource for PrecomputedLeafCache<'a> {
        // `max_collector_parallelism`: 1 = sequential (today).
                provider_key: 0,
        })
                    // stable value works.
        };
        });
//! `LeafBitmapSource` and exposes the composite as a `RowGroupBitsetSource`.
        }
//!
    pub pruning_predicates: Arc<HashMap<usize, Arc<PruningPredicate>>>,
        rg_first_row: i64,
    /// `pruning_predicates` maps each `Predicate(expr)` leaf (keyed by
/// On error, returns the first error encountered.
    use datafusion::common::tree_node::TreeNode;
pub struct TreePrefetch {
 * compatible open source license.
            let mut flush = |bm: &mut RoaringBitmap, start: u32, end_inclusive: u32| {
                // inflate counts. We compute final page-level metrics below
        batch_offset: usize,
    pub mask_buffer: Option<Buffer>,
pub struct RgEvalContext {
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
    ///
        batch: &RecordBatch,
}
    pub rg_first_row: i64,
}
        }
    expr.clone()
    /// doc range). `IndexedStream` converts this to a `RowSelection` using
        let ctx = RgEvalContext {
        rg_state: &dyn Any,
    pub min_doc: i32,
                let end = end_inclusive.saturating_add(1);
    /// Evaluators downcast to their own concrete type.
        ctx: &RgEvalContext,
    pub tree: Arc<ResolvedNode>,
            }
        )
///     evaluator: Arc::new(BitmapTreeEvaluator),        // or JavaTreeEvaluator
            Ok(roaring::RoaringBitmap::new())
    /// parallel per RG prefetch. 1 = sequential (preserves short-circuit
    /// misaligned Collector lookups. Plus, the pushdown predicate
                        "BitmapTree: skipping RG {} — pruned by RG-level stats",
/// `LeafBitmapSource::leaf_bitmap` calls in parallel via `std::thread::scope`,
/// bitmap-tree evaluator paths.
pub enum CollectorCallStrategy {
    /// for Collector lookups) — pushdown would drop rows mid-decode and
//!
            stats_prune_tree: None,
                min_doc: 0,
    fallback: &'a dyn LeafBitmapSource,
            cost_collector: self.cost_collector,
        if prefetch.candidates.is_empty() {
        batch_len: usize,
/// columns) so the indices need to be reseated. Both the SingleCollector
    /// ignore `current_mask` anyway). Default `true` keeps the current
    pub cost_predicate: u32,
//!    (FFM upcall + bitset expansion).
                    let num_pages = page_row_counts.len();
                }
        }))
    /// `index_filter(...)` UDF marker whose body panics.
                if let Some(ref c) = m.pages_total {
                    if let Some(ref c) = m.pages_pruned {
    use super::*;
        page_prune_metrics: Option<&PagePruneMetrics>,
/// SELECT list. In production, substrait plans emitted by the planner project
        // running the tree walk. Preserves correctness; sacrifices AND/OR
        min_doc: i32,
    /// `TreeBitsetSource` always returns `Some(mask)` from `on_batch_mask` —
    use datafusion::parquet::arrow::ArrowWriter;
    ) -> Result<BooleanArray, String>;
        }
            let ctx_ref = ctx;
//! - Bitsets stay small (~512 bytes per RG).
                    // Use i as the leaf_dfs_index — the cache doesn't
    /// first row in this batch.
        }
            map: HashMap::new(),
        ) -> Result<roaring::RoaringBitmap, String> {
    out: &mut Vec<(usize, &'a ResolvedNode)>,
        // Use the precomputed cache as the LeafBitmapSource if present;
            if let Some(&pos) = self.rg_index_to_pos.get(&rg.index) {
                    }
        };
        true
    /// shrink the candidate set.
        map.insert(collectors[i].0, bm);
        Ok(Some(PrefetchedRg {
use datafusion::physical_optimizer::pruning::PruningPredicate;
        }
        )?;
struct PrecomputedLeafCache<'a> {
    /// `TightenOuterBounds` (default) uses a single `[min, max)` range.
        };
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
                    );
        batch_offset: usize,
            let key = Arc::as_ptr(collector) as *const () as usize;
            ) -> Result<CollectDocsResult, String> {
    /// - `position_map` translates delivered batch-row indices to RG-relative
        if let ResolvedNode::Collector { collector, .. } = tree {
            meta.schema(),
                &self.pruning_predicates,
            batch_len: usize,
        // page-level decision after AND/OR/NOT combination, not the
    /// Candidate doc-id bitmap, RG-relative (bit 0 = first row of the RG
                 collect_unique_collector_nodes. Planner must drop performance peers \
/// Uses an `Arc<AtomicUsize>`-driven round-robin over pre-spawned worker
//!    exact per-batch mask. Today: [`bitmap_tree::BitmapTreeEvaluator`].
            vec![Arc::new(Int32Array::from(vec![0i32; 4]))],
                &self.rg_index_to_pos,
    /// `min_skip_run` and keeps the matching `PositionMap` alongside for
use super::page_pruner::PagePruner;
                    let result = leaves_ref.leaf_bitmap(node, i, ctx_ref);
/// same leaf.
                collect_unique_collector_nodes(c, out, seen);
            mask_buffer: None,
            Ok(TreePrefetch {
}
    pub per_leaf: Vec<(usize, RoaringBitmap)>,
    /// back to "every row is a candidate" (safe, identity for the
            _page_pruner: &PagePruner,
    let results_mutex = std::sync::Mutex::new(&mut results);
            }
                        run_end = v;
        ResolvedNode::And(children) | ResolvedNode::Or(children) => {
                    let page_end = row_offset + count as u32;
            page_pruner: empty_pruner(),
        // per-leaf intermediate results.
    map: HashMap<usize, RoaringBitmap>,
        assert!(!source.needs_row_mask());
        leaves: &dyn LeafBitmapSource,
    /// Whether this evaluator requires parquet's `with_predicate` pushdown
    /// Refinement stage: produce the exact per-row `BooleanArray` for one
            position_map,
    pub leaves: Arc<dyn LeafBitmapSource>,
    match node {
    pub max_collector_parallelism: usize,
 * SPDX-License-Identifier: Apache-2.0
        ResolvedNode::Not(c) => collect_unique_collector_nodes(c, out, seen),
            })
        &self,
        fn on_batch(
                collector: Arc::new(Dummy),
            evaluator: Arc::new(NoopTreeEvaluator),
                        return Ok(datafusion::common::tree_node::Transformed::yes(remapped));
    /// bitmap side-table that the refinement stage will read.
    struct NoopLeaves;
            slot.ok_or_else(|| format!("precompute: worker did not populate slot {}", i))??;
        max_doc: i32,
        };
use std::sync::Arc;
    fn needs_row_mask(&self) -> bool {
                per_leaf: Vec::new(),
/// bitmap in the same domain, which the refinement stage looks up per
                    let mut guard = results_mutex_ref.lock().unwrap();
                if let Ok(new_idx) = batch.schema().index_of(col.name()) {
    /// `RoaringBitmap`. Set by evaluators that already produced the
///     page_pruner: Arc::new(pruner),
        .map_err(|e| format!("remap_expr_to_batch: {}", e))
    pub cost_collector: u32,
    FullRange,
}
            let mut run_start: Option<u32> = None;
        .map(|t| t.data)
        &self,
    pub eval_nanos: u64,
    ///
        &self,
        }
    /// Overridden to `true` by evaluators that must see the complete
//!
    pub fn without_context(candidates: RoaringBitmap, eval_nanos: u64) -> Self {
use std::any::Any;
    ctx: &RgEvalContext,
//!
//! [`TreeBitsetSource`] composes any `TreeEvaluator` with any
        ) -> Result<TreePrefetch, String> {
                        run_start = Some(v);
    fn forbid_parquet_pushdown(&self) -> bool {
/// `Arc::as_ptr(collector)`. Falls back to the inner source for leaves
            collector_strategy: self.collector_strategy,
//! Row-group-level bitset sources — the pluggability seam for where
        .transform(|e| {
    // Bounded parallelism via std::thread::scope + a work queue Mutex.
                &ctx,
//! - Memory stays bounded regardless of shard size.
/// Output of `prefetch_rg`.
    /// Controls how the AND evaluator narrows collector ranges from the
    std::thread::scope(|scope| {
    /// TreeBitsetSource purely for testing its `needs_row_mask` override.
            }));
}
        self.fallback.leaf_bitmap(tree, leaf_dfs_index, ctx)
    /// Candidate-stage leaf-reorder cost for `ResolvedNode::Collector`.
///     leaves: Arc::new(CollectorLeafBitmaps::without_metrics()),           // or ParquetStatsLeaves
    /// its
                }
        // `TreeBitsetSource::on_batch_mask` returns `Some(refinement_mask)`.
        let leaves_ref: &dyn LeafBitmapSource = match &precomputed {
                    if let Some(ref c) = m.pages_total {
        }
    /// is wasted work.
                Ok(vec![].into())
            for rel in prefetch.candidates.iter() {
            ArrowReaderOptions::new().with_page_index(true),
    Ok(PrecomputedLeafCache {
    /// position (identity under full-scan; non-trivial under block-granular
    /// map = no page-level predicate pruning; each Predicate leaf falls
    /// `PositionMap` for Collector lookups. If parquet's pushdown
    pub collector_strategy: CollectorCallStrategy,
        Self {
    /// `PartitionMetrics` at dispatch time.
                &ctx,
    /// (if any reached us via `scan(filters)`) could contain the
///
    /// Narrowed doc-id ranges for Collector FFM calls. Computed by the
            .prefetch(
        let rg_candidates = if anchor == 0 {
/// at eval time, i.e. the physical plan's projection must include
pub mod eval_helpers;
            if let Some(page_row_counts) = self.page_pruner.page_row_counts(rg.index) {
        tree: &ResolvedNode,
 */
        let meta = ArrowReaderMetadata::load(
        page_pruner: &PagePruner,
#[derive(Debug, Clone)]
    }
                self.stats_prune_tree.as_deref(),
        // AND child already emptied the accumulator). Governed by
/// Composes a `TreeEvaluator` + `LeafBitmapSource` + `PagePruner` + resolved
    /// BitmapTree walks the BoolNode in `on_batch_mask` using
        batch: &RecordBatch,
    ) -> Result<Option<PrefetchedRg>, String>;
            None
    fn prefetch_rg(
                &*self.leaves,
///
                let v = shifted as u32;
}
    /// time so `prefetch_rg` doesn't need an `Arc` deref on the hot path.
    /// reduction on multi-collector trees; bounded by caller's config.
//! # Invariant — row-group-at-a-time
        max_doc: i32,
            &self,
    /// mask (e.g. `TreeBitsetSource` — refinement is authoritative and would
        tree: &ResolvedNode,
/// Materialise all Collector leaves of `tree` by running their
                loop {
    use datafusion::arrow::record_batch::RecordBatch;
    /// Per-predicate `PruningPredicate` cache, keyed by
) -> Result<PrecomputedLeafCache<'a>, String> {
    ///   positions (identity under full-scan; non-trivial under
impl PrefetchedRg {
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
    use datafusion::physical_expr::expressions::Column;
            let _ = h.join();
            let results_mutex_ref = &results_mutex;
    pub cost_predicate: u32,
            // Invariant: planner drops performance peers under OR/NOT before
    }
        // coalesce consecutive bits into `insert_range` calls so we
/// tree into a `RowGroupBitsetSource`.
/// Per-row-group bitset producer. Plugs into `IndexedStream`.
    /// disabled (the tree path still works, each Predicate leaf falls
    /// record batch, consuming the candidate-stage `state` for the RG this
    /// `on_batch_mask` over the full delivered batch (using `PositionMap`
        batch_len: usize,
//!
    }
//!    This is extensible to different implementations.
        }
                if let Some(ref c) = m.pages_pruned {
//! 2. **Leaf bitmap source** ([`LeafBitmapSource`]) — given a `Collector`
        #[derive(Debug)]
            .evaluator
                    }
                _: i32,
    ) -> Result<Option<BooleanArray>, String>;
            if let Some(col) = e.downcast_ref::<Column>() {
                    // use it for lookup (keys by Arc::as_ptr), so any
        // Optional: materialise all Collector leaves in parallel before
    pub page_prune_metrics: Option<PagePruneMetrics>,
    // Zero or one collector → no benefit from parallelism, fall back to
            // fragment conversion, so DelegationPossible should never reach the
            fallback: leaves,
fn precompute_collector_leaves<'a>(
            for c in children {
                    None => {
//!
                    if new_idx != col.index() {
    /// AND evaluator from the accumulator bitmap after earlier children
/// `ResolvedNode::Predicate` in the tree **must be present in the batch**
        let t = Instant::now();
    fn on_batch_mask(
                // Range API is half-open; end_inclusive+1 handles the
    ///   this RG — evaluators downcast it to their own per-RG state type.
    fn tree_bitset_source_does_not_need_row_mask() {
    }
/// deduplicated by `Arc::as_ptr` so we don't call Lucene twice for the
                        run_start = Some(v);
                "invariant violation: DelegationPossible reached \
        //
    ) -> Result<RoaringBitmap, String>;
    /// Optional: pre-built Arrow `Buffer` holding `candidates` in
        ResolvedNode::Collector { collector, .. } => {
                        run_end = v;
    /// `Arc::as_ptr(resolved_predicate) as usize`. Built once per query at
        map,
        min_doc: i32,
                        let remapped = Arc::new(Column::new(col.name(), new_idx))
/// not in the map (shouldn't happen in practice — we populate the map
    /// candidate offsets on the full-scan strategy. `true` for evaluators
        .unwrap();
    }
///
                &self.tree,
    /// - `None` = no refinement mask needed (e.g. `SingleCollectorEvaluator`
}
/// bounded by `max_parallel`. Returns a cache keyed by `Arc::as_ptr(collector)`.
    /// Default `false`: pushdown decided by the stream's base policy.
    impl LeafBitmapSource for NoopLeaves {
    for (i, slot) in results.into_iter().enumerate() {
            rg_index_to_pos: HashMap::new(),
        position_map: &PositionMap,
use roaring::RoaringBitmap;
    /// accumulator bitmap.
        }
        // its row range; "kept" otherwise. This reflects the actual
            tree: Arc::new(ResolvedNode::Collector {
        // short-circuit savings (all collectors run even if an earlier
