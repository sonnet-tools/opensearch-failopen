            0,
        )
            Some(collector),
        max_doc: i32,
            residual_expr,
            next_doc: 8,
            Arc::new(FfmDelegatedBackendCollectorFactory),
                        .collect_packed_u64_bitset(effective_min, *r_max)
                bloom
    /// top-level AND, translated to a `PruningPredicate`. `None` means
            None,
        let combined = datafusion::arrow::compute::kernels::boolean::and_kleene(
            page_prune_metrics,
        let meta = ArrowReaderMetadata::load(&file, options).unwrap();
///
        // representation the hot paths (`on_batch_mask`, `build_mask`)
    impl RowGroupDocsCollector for NextDocCollector {
                }
        );
    performance_provider_locks: Arc<HashMap<i32, Arc<OnceLock<ProviderHandle>>>>,
                    let mut ranges = Vec::new();
                    words[idx / 64] |= 1u64 << (idx % 64);
    fn create(
            None,
    fn stats_prune_tree_skips_rg_when_false() {
            // state.mask_buffer; lifecycle is Arc-managed.
            None,
            .unwrap()
        // when DF page-pruning kept more than the configured fraction of the RG —
        // docs: 5 (in RG0) and 8 (start of RG1, == RG0's max_doc=8).
/// `on_batch_mask` and `build_mask` build zero-copy `BooleanBuffer`
                create_provider(context_id, annotation_id)
            num_rows: 4,
            CollectorCallStrategy::FullRange,
                    let effective_min = next_doc_out.max(*r_min);
        assert_eq!(pf.candidates.iter().collect::<Vec<_>>(), vec![1u32]); // doc 5 is at RG-relative pos 1
        let collector_mask: BooleanArray = match position_map {
            let mut bitset = vec![0u64; (span + 63) / 64];
    #[test]
            num_rows: 8,
    /// replays a pre-computed bitset without an FFM call.
            schema.clone(),
                    bitset[idx / 64] |= 1u64 << (idx % 64);
    }
        doc_max: i32,
            0,
    ///   delivers exact `Collector ∧ residual` rows. `on_batch_mask`
                        })?;
            None,
    rg: &RowGroupInfo,
            &residual_mask,
                        std::slice::from_raw_parts(
            None,
    fn next_doc_max_value_skips_all_remaining() {
            provider_key,
            0,
            None,
            .on_batch_mask(&(), 0, &pm, 0, 3, &batch)
            let offset = (min_doc as i64 - rg.first_row) as u32;
        provider_key: i32,
            first_row: 0,
        assert!(pf.is_some());
                                "collector.collect_packed_u64_bitset(rg={}, [{}, {})): {}",
        docs: Vec<i32>,
            if upper < u32::MAX {
            ),
            None,
        assert_eq!(pf.candidates.iter().collect::<Vec<_>>(), vec![2u32]);
    /// pushdown proceeds.
        let collector = Arc::new(NextDocCollector {
            Some(collector),
            // (the level filter happens on the Java side). Commented out to avoid
            first_row: 4,
        if last_next >= max_doc {
        // Build a 1-row-group parquet with no filters — page pruner becomes a no-op
use std::collections::HashMap;
                    .store(next_doc_out, std::sync::atomic::Ordering::Release);
        let pf0 = eval
                let mut bm = RoaringBitmap::new();
        let pruner = minimal_page_pruner();
        let eval = SingleCollectorEvaluator::new(
    /// Mock collector that returns specific docs AND a configurable next_doc.
                .get(&annotation_id)
        let got: Vec<u32> = prefetched.candidates.iter().collect();
        batch_offset: usize,
        }))
        // Materialise the final RG-relative bitmap as an Arrow `Buffer`
                // Call collector for each range, merge into one RG-relative bitmap.
//!
}
        assert_eq!(got, vec![0u32, 3, 7]);
                    // Advance only forward — the iterator position is monotonic; guard
        provider_key: i32,
        };
            // Pick the smallest annotation_id deterministically so logs/tests are stable.
        }
            HashMap::new(),
            0,
            return Ok(None);
    if rg.num_rows == 0 {
            Some(collector),
            //     "[scf-rust] consulting peer for performance leaf rg={} writer_generation={} range=[{},{}) annotation_id={}",
            delegated_backend_collector_factory,
        // RG1 [8,16): next_doc=8 == min_doc, NOT skipped. Doc 8 must be collected.
            first_row: 0,
        let rg1 = RowGroupInfo {
        collector: Option<Arc<dyn RowGroupDocsCollector>>,
/// Production factory: delegates to `FfmSegmentCollector::create`, which round-trips
}
use datafusion::physical_optimizer::pruning::PruningPredicate;
            let num_docs = (max_doc - min_doc) as u32;
            None,
                .collect_packed_u64_bitset(min_doc, max_doc)
    }
        pruning_predicate: Option<Arc<PruningPredicate>>,
        assert_eq!(pf.candidates.iter().collect::<Vec<_>>(), vec![1u32]);
            None,
                            rg_pos += s.row_count as i64;
        let collector = Arc::new(StubCollector { docs: vec![0] }) as Arc<dyn RowGroupDocsCollector>;
        {
            num_rows: 8,
        let page_ranges: Option<Vec<(i32, i32)>> = self.pruning_predicate.as_ref().and_then(|pp| {
            candidates &= peer_bm;
        // Skip RG if the previous collectDocs told us the next match is beyond this RG.
                        out[i >> 6] |= 1u64 << (i & 63);
            }
        let eval = SingleCollectorEvaluator::new(
            CollectorCallStrategy::FullRange,
            Arc::new(HashMap::new()),
/// Evaluator holding one collector and applying per-RG page pruning.
            None,
            let context_id = self.context_id;
            // Per-RG debug log — `format!` runs unconditionally regardless of log level
            }
            })
            let pruned =
            min_doc: i32,
        }) as Arc<dyn RowGroupDocsCollector>;
        let pruner = minimal_page_pruner();
    }
            Arc::new(HashMap::new()),
                        continue;
                        if s.skip {
        }
//! residual predicates.
        );
/// Length of the underlying buffer covers `mask_len` bits (= rg_num_rows).
    };
    pub metadata: Arc<ParquetMetaData>,
/// `context_id` is the per-query identifier passed through to every FFM upcall so Java
    pruning_predicate: Option<Arc<PruningPredicate>>,
                // (or the full RG if no PruningPredicate). The opportunistic peer branch
    ///   returns `None` (nothing left to do).
                ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), None).unwrap();
        let pruner = minimal_page_pruner();
    /// and desirable: parquet applies the residual in lockstep with
                        for (r_min, r_max) in r {
    /// - **Row-granular** (`min_skip_run = 1`): the same expression is
                // to remove rows in dead pages that the collector scanned.
                        && (src_bytes[rg_pos >> 3] >> (rg_pos & 7)) & 1 == 1;
                    let result = collector
            .load(std::sync::atomic::Ordering::Acquire);
            Arc::new(HashMap::new()),
            num_rows: 8,
            docs: vec![0, 3, 7],
            0,
            children: vec![],
            // log_debug!(
    fn minimal_page_pruner() -> Arc<PagePruner> {
            None,
            num_rows: 8,
        // (if built) handles Collector narrowing.
use datafusion::arrow::array::BooleanArray;
    /// Raw residual expression (non-Collector children of the top-level
use std::time::Instant;
    fn on_batch_mask_returns_none_for_path_b() {
        ffm_collector_calls: Option<datafusion::physical_plan::metrics::Count>,
        let got: Vec<u32> = prefetched.candidates.iter().collect();
                };
    surviving_fraction > threshold
                        rg.index
            HashMap::from([(0, 0)]),
            None,
            collector,
    fn stats_prune_tree_none_does_not_prune() {
            // per-RG allocation. Re-enable locally for debugging.
/// views via `BooleanBuffer::new(buf.clone(), bit_offset, bit_len)`.
    }
                .prune_rg(pp, rg.index, self.page_prune_metrics.as_ref())
///
                    }
        let tmp = NamedTempFile::new().unwrap();
        let rg = RowGroupInfo {
                    next_doc_out = next_doc_out.max(result.next_doc);
    #[test]
/// configured selectivity threshold. The function says "consult" when DF kept
    /// parquet applies residual during decode of already-narrowed
            context: Box::new(SingleCollectorState {
            pruner,
        // RG-level early-exit: precomputed from column stats at construction.
            None,
                            result.words.as_ptr() as *const u8,
                mask_buffer: mask_buffer.clone(),
            Some(Arc::new(spt)),
                        None => vec![(min_doc, max_doc)],
    #[test]
            }
                        "SingleCollector: skipping RG {} — pruned by RG-level stats",
    residual_expr: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
            Arc::new(FfmDelegatedBackendCollectorFactory),
use super::{PrefetchedRg, RowGroupBitsetSource};
    /// no residual predicate applies (nothing to prune with).
        // next_doc = i32::MAX means scorer exhausted — all subsequent RGs skipped
            0,
        return false;
            PositionMap::Bitmap { .. } => BooleanArray::new(
            Some(collector),
            Some(collector),
    candidates: RoaringBitmap,
    writer_generation: i64,
            //     "[scf-rust] peer bitset intersected rg={} writer_generation={} candidates_before={} peer_cardinality={} candidates_after={}",
/*
                next_doc: self.next_doc,
    }
            pruner,
            None,
        let pf = eval.prefetch_rg(&rg0, 0, 8).unwrap().expect("has match");
    fn single_collector_needs_row_mask() {
            // Every delivered row is by construction a candidate — mask is all-true.
        };
            meta.metadata().clone(),
    use tempfile::NamedTempFile;
                        }
            index: 0,
    ///   evaluates this expression against the decoded batch and
                "SingleCollectorEvaluator: rg_state is not SingleCollectorState".to_string()
        assert!(eval.needs_row_mask());
                }
                        }
            });
/// the classifier (reserved for a future `OR(Collector, predicates)`
    /// Stream's `current_mask` construction consults this. When
            Ok(CollectDocsResult {
    }
            None,
    /// When we have a residual to apply in `on_batch_mask`, pushdown
            HashMap::new(),
            if let Some(ref c) = self.ffm_collector_calls {
            None,
                let words = batch_len.div_ceil(64);
            next_doc: i32::MAX,
        // would have unioned with page-pruner-derived "anything-allowed"
        let mut candidates = match self.collector.as_ref() {
        let last_next = self
/// `BitsetMode::Or` branch that previously existed was never emitted by
        writer_generation: i64,
    /// Per-query context identifier passed through every FFM upcall so Java can route
                                rg.index, r_min, r_max, e
    struct NextDocCollector {
                1, 2, 3,
        bloom_config: Option<BloomConfig>,
        let got: Vec<u32> = prefetched.candidates.iter().collect();
            None,
        let pf = eval.prefetch_rg(&rg1, 4, 8).unwrap().expect("has match");
        batch: &RecordBatch,
        );
            0,
                bm
        // RG2 [16,24): next_doc=20 < 24, should NOT be skipped (doc 20 is in range)
        let pruner = minimal_page_pruner();
            0,
        }
            HashMap::new(),
    /// Precomputed per-RG/subtree match status from RG-level column stats.
        // RG0: has doc 0
            HashMap::new(),
            None,
                })?;
            Arc::new(FfmDelegatedBackendCollectorFactory),
            CollectorCallStrategy::FullRange,
    /// Collector path always performs one FFM round-trip to Java.
                packed_bits_to_boolean_array(out, batch_len)
            eval_nanos: t.elapsed().as_nanos() as u64,
/// TODO(phase-99): hardcoded selectivity threshold for opportunistic peer consultation.
//! 3. Hand the bitset offsets to `IndexedStream` as a RowSelection.
    /// `RowGroupInfo` (which doesn't carry it).
                    ));
            .is_none());
        let eval = SingleCollectorEvaluator::new(
            CollectorCallStrategy::FullRange,
    /// Builds the per-RG delegated-backend collector when the gate fires. Production
            None,
        let eval = SingleCollectorEvaluator::new(
}
                        rg.index, min_doc, max_doc, e
            Arc::new(HashMap::new()),
    /// upfront — see `performance_provider_locks`).
}
                }
            0,
        let eval = SingleCollectorEvaluator::new(
                    }
            next_doc: 5,
            Some(Arc::new(spt)),
        Ok(Some(combined))
        .unwrap();
    pub object_path: object_store::path::Path,
    rg_index_to_pos: HashMap<usize, usize>,
            }
        };
            index: 2,
                }
pub trait DelegatedBackendCollectorFactory: Send + Sync + std::fmt::Debug {
    use super::*;
        };
                            bm.insert_range(lo..hi);
                            format!(
            num_rows: 8,
            CollectorCallStrategy::FullRange,
            index: 0,
            0,
                std::slice::from_raw_parts(
        batch_len: usize,
        // Vec<u64> for Runs.
        );
                    if hit {
            CollectorCallStrategy::FullRange,
            writer.close().unwrap();
        let spt = StatsPruneTree {
                        self.writer_generation,
        let collector = Arc::new(StubCollector {
            Some(collector),
    pub rg_bloom_pruned: Option<datafusion::physical_plan::metrics::Count>,
            None,
    #[test]
            vec![Arc::new(datafusion::arrow::array::Int32Array::from(
        }) as Arc<dyn RowGroupDocsCollector>;
        let pf = eval.prefetch_rg(&rg2, 16, 24).unwrap();
                        Some(r) => r.clone(),
    ///   exact result.
        );
        None => rg.num_rows as i64,
            None,
            Arc::new(HashMap::new()),
                    c.add(1);
                        format!(
        call_strategy: CollectorCallStrategy,
            page_pruner,
/// Resources needed for per-RG bloom filter pruning.
                // Dispatch collector call strategy.
//!    `with_predicate(residual).with_pushdown_filters(true)` applies the
    /// Residual pruning predicate: the non-Collector portion of the
    /// wires `FfmDelegatedBackendCollectorFactory`; fuzz tests inject a mock that
 * SPDX-License-Identifier: Apache-2.0
        }
use std::sync::OnceLock;
                candidates,
        let collector = Arc::new(NextDocCollector {
                            rg_pos += s.row_count as i64;
    ///
            children: vec![],
//!
        // zero allocation for Identity, at most one small packed
                    return Ok(None);
        };
        // `Buffer` is a refcounted view into `state.mask_buffer` —
        let rg2 = RowGroupInfo {
                    if let Some(ref c) = self.ffm_collector_calls {
                for (r_min, r_max) in &call_ranges {
            last_next_doc: std::sync::atomic::AtomicI32::new(i32::MIN),
        let pf = eval.prefetch_rg(&rg0, 0, 4).unwrap().expect("has match");
        let pruner = minimal_page_pruner();
            CollectorCallStrategy::FullRange,
        context_id: i64,
        // map only if the gate fires; create the provider only once per query × leaf.
    #[derive(Debug)]
        &self,
        // Regression for the exclusive-boundary bug: a match sitting exactly at
        let prefetched = eval.prefetch_rg(&rg, 0, 8).unwrap().expect("has matches");
            None,
        let batch = datafusion::arrow::record_batch::RecordBatch::try_new(
    fn empty_pruning_predicates_leave_collector_unchanged() {
            .expect("RG1 has boundary doc 8");
                if doc >= min_doc && doc < max_doc {
            Arc::new(HashMap::new()),
    #[test]
            first_row: 16,
                            let hi = (*r_max as i64 - rg.first_row) as u32;
                    context_id, annotation_id, provider.key()
            self.page_pruner
            Some(collector) => {
        };
            let mut writer =
        let collector = Arc::new(StubCollector {
                .expect("performance_provider_locks is non-empty (just checked)");
        let rg0 = RowGroupInfo {
                // residual at decode time.
                just_initialized = true;
        let eval = SingleCollectorEvaluator::new(
            first_row: 0,
                peer_bm.remove_range(upper..);
    #[test]
            ))],
            None,
    bitmap_to_packed_bits, packed_bits_to_boolean_array, row_selection_to_bitmap, PositionMap,
        // the query is performance-only (no Collector leaves), from the page-pruned
                            ranges.push((abs_min, abs_max));
            .last_next_doc
        // With no pruning predicates, the evaluator is a pass-through for
                    let mut chunk = RoaringBitmap::from_lsb0_bytes(offset, bytes);
use crate::indexed_table::ffm_callbacks::{create_provider, FfmSegmentCollector, ProviderHandle};
        stats_prune_tree: Option<Arc<StatsPruneTree>>,
/// in pre-built by `indexed_executor.rs`. Today delegated-backend (perf-delegated)
    delegated_backend_collector_factory: Arc<dyn DelegatedBackendCollectorFactory>,
            );
        }
                );
                if let Some(&false) = spt.rg_can_match.get(pos) {
            .unwrap()
                .keys()
        }
        let pruner = minimal_page_pruner();
            first_row: 0,
    }
                        min_doc,
            // Avoids the Vec/sort allocation in the common single-leaf case.
                    batch_len,
/// TODO: extend this factory to also build the *correctness* collector currently passed
        );
            .prefetch_rg(&rg1, 8, 16)
    /// Used in two modes:
            writer.write(&batch).unwrap();
                        let mut allowed = RoaringBitmap::new();
    /// - **Block-granular** (`min_skip_run > 1`): pushdown is OFF
        )
                let mut next_doc_out = last_next;
};
            // a new packed Vec<u64> (small — bounded by batch_len/64).
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int32, false)]));
        };
    }
            HashMap::new(),
    }
    /// and rely on `needs_row_mask = true` (default when residual is
        assert_eq!(got, vec![0u32, 3, 7]);
                // Performance-only query. Seed candidates with the page-pruned universe
                );
    use datafusion::parquet::arrow::ArrowWriter;
    ///   to parquet's `with_predicate` for decode-time filtering.
            docs: vec![0, 3, 7],
            };
            native_bridge_common::log_debug!(
            CollectorCallStrategy::FullRange,
            None,
            Some(collector),
    /// pushdown impact and pushes anyway (which is what we want:
                            allowed.insert_range(lo..hi);
        if let Some(ref spt) = self.stats_prune_tree {
            .downcast_ref::<SingleCollectorState>()
        // need; they construct zero-copy `BooleanBuffer` views via
        rg: &RowGroupInfo,
            None,
            None,
            next_doc: 20,
/// can't help, so consult.
                    let delivered_idx = batch_offset + i;
            None,
        Ok(Arc::new(collector) as Arc<dyn RowGroupDocsCollector>)
        let pruner = minimal_page_pruner();
        let packed_bits = bitmap_to_packed_bits(&candidates, mask_len as u32);
    page_ranges: &Option<Vec<(i32, i32)>>,
//! When the filter has exactly one `index_filter(...)` call AND'd with
                for i in 0..batch_len {
    pub io_handle: tokio::runtime::Handle,
    fn stats_prune_tree_allows_rg_when_true() {
/// Re-exported from parent module for backward compatibility.
        // `BooleanBuffer::new(buf.clone(), bit_offset, bit_len)`.
            // underlying Buffer. The returned BooleanArray points into
            Some(collector),
impl SingleCollectorEvaluator {
            PositionMap::Identity { .. } => {
        );
        let rg1 = RowGroupInfo {
                .map(|sel| {
                })?;
                            )
                    None => {
            0,
                None,
            return Ok(None);
            docs: vec![0, 3, 7],
/// to Java via FFM to build a Lucene-backed collector.
/// (peer call would be wasted work).
        )?;
                datafusion::parquet::arrow::arrow_reader::RowSelector,
        );
        let eval = SingleCollectorEvaluator::new(
            let mut peer_bm = RoaringBitmap::from_lsb0_bytes(offset, bytes);
        );
            rg_index_to_pos,
            CollectorCallStrategy::FullRange,
/// extension) and has been removed; an OR-between-Collector-and-predicates
        // Collector has doc at position 5. next_doc=5 means the iterator
            None,
        // TODO(d3): consult ALL performance leaves whose gate fires and AND their
    /// Stub collector: returns a pre-defined set of doc IDs, encoded into
                    CollectorCallStrategy::FullRange => vec![(min_doc, max_doc)],
            first_row: 0,
fn should_consult_lucene(
                // a later sub-range skips/tightens on the position the iterator has
        let rg1 = RowGroupInfo {
        ) -> Result<CollectDocsResult, String> {
            index: 0,
            Some(collector),
                }
/// can route each callback to the correct per-query handle and tracker.
                rg.index,
            num_rows: 8,
    use std::fmt;
            // let peer_card = peer_bm.len();
    /// suppresses pushdown in block-granular mode. In row-granular
            doc_max,
    fn on_batch_mask(
///
        Some(ranges) => ranges.iter().map(|(lo, hi)| (hi - lo) as i64).sum::<i64>(),
    /// Lazy `ProviderHandle` cache, one per performance-delegated annotation_id.
    }
                self.last_next_doc
        // single-call demo. Multi-leaf intersection is part of D3 follow-up.
        };
            Arc::new(HashMap::new()),
                    format!(
        assert_eq!(pf1.candidates.iter().collect::<Vec<_>>(), vec![0u32]); // doc 8 at RG-relative pos 0
                let bb = datafusion::arrow::buffer::BooleanBuffer::new(
                .performance_provider_locks
 * compatible open source license.
            ffm_collector_calls,
        let collector = Arc::new(StubCollector {
                }
    /// stream's `PartitionMetrics` at evaluator construction.
                        bm.insert_range(0..rg.num_rows as u32);
            return Ok(None);
    /// **row-granular mode** (`min_skip_run == 1`), pushdown is safe
    /// present) to trigger the stream's alignment guard in block
            None,
    /// `FfmSegmentCollector` lazily without re-deriving the segment from
        assert_eq!(got, vec![0u32, 3, 7]);
            index: 0,
    // Keep the `fmt` import used
                    let offset = (effective_min as i64 - rg.first_row) as u32;
        rg_index_to_pos: HashMap<usize, usize>,
            0,
    }
        let rg1 = RowGroupInfo {
        let got: Vec<u32> = prefetched.candidates.iter().collect();
/// Collector candidate bitmap to build a post-decode mask.
        // max_doc is exclusive, so nextDoc == max_doc also means "no match in this RG".
                    }
                    native_bridge_common::log_debug!(
        // RG0: has doc 2
                    let num_docs = (*r_max - effective_min) as u32;
use crate::indexed_table::page_pruner::{PagePruneMetrics, PagePruner, StatsPruneTree};
            None,
    }
                    };
/// Pure function. Inputs: post-page-prune surviving ranges, RG row count, and the
        let state = rg_state
            0,
}
        // skipping the FFM round-trip when DF was already selective. Lazy: lock the
        context_id: i64,
        }
            None,
            }
            None,
    /// used in production but kept for defensive correctness).
    /// for an RG. Drop releases the Lucene Weight via `releaseProvider`.
            Arc::new(HashMap::new()),
            index: 0,
            HashMap::new(),
            None,
            Ok(bitset.into())
/// might narrow further); "skip" when DF already squeezed it below threshold
                    ranges
        if !self.performance_provider_locks.is_empty()
            None,
            &datafusion::parquet::arrow::arrow_reader::RowSelection::from(Vec::<
        // Evaluate residual against the batch.
                    state.mask_buffer.clone(),
        };
            let result = collector
            let mut just_initialized = false;
/// residual at all (e.g. text-column predicate with no parquet stats) — DF
                // For FullRange and TightenOuterBounds, AND with page bitmap
        let eval = SingleCollectorEvaluator::new(
        // Bloom filter pruning: runs after page pruning (free) but before
        // candidate. (Contrast with the old BitsetMode::Or path, which
        }) as Arc<dyn RowGroupDocsCollector>;
            first_row: 0,
        let rg = RowGroupInfo {
        // RG1 [8,16): should be skipped entirely
/// layout, wrapped as a refcounted `Buffer`. Sharing an `Arc<Buffer>` lets
        };
}
            docs: vec![5, 8],
            PositionMap::Runs { .. } => {
pub struct FfmDelegatedBackendCollectorFactory;
                        max_doc,
        )
            })?;
    /// residual is set, we return `true` so the stream knows our
            &collector_mask,
    ///   (alignment risk with coalesced selection). `on_batch_mask`
            None => {
        // is at doc 5 after RG0. For RG1 [4,8), effective_min should be
    /// Incremented once per `prefetch_rg` call (once per RG) — the
/// `page_ranges == None` means there's no usable PruningPredicate for the
        };
        let pruner = minimal_page_pruner();
        // All paths produce a `BooleanArray` whose underlying
            if just_initialized {
                let call_ranges: Vec<(i32, i32)> = match self.call_strategy {
            None,
use datafusion::arrow::record_batch::RecordBatch;
            CollectorCallStrategy::FullRange,
            schema,
///
            .unwrap()
                    .io_handle
            None,
            num_rows: 8,
                .min()
    /// Reverse map: absolute RG index → position in `rg_can_match` vectors.
            context_id,
    /// the query has only performance-delegated leaves (no peer call required
    /// must be OFF in **block-granular mode** because we use
            Arc::new(FfmDelegatedBackendCollectorFactory),
                    .expect("create_provider FFM upcall failed")
/// mode parquet narrowed fully via `with_predicate` + `RowSelection`
    threshold: f64,
        // row IDs — semantics that were never wired up in production.)
//! 4. `on_batch_mask` returns `None` — DataFusion's
            None,
                    .block_on(crate::indexed_table::bloom_pruner::bloom_prune_rg(
        let t = Instant::now();
struct SingleCollectorState {
            if pruned {
            for &doc in &self.docs {
        let residual_mask = super::eval_helpers::evaluate_residual(residual, batch, batch_len)?;
                    // Read bit rg_pos from the packed buffer (LSB-first).
            first_row: 0,
            pruner,
    ///
                        Some(r) if r.is_empty() => return Ok(None),
        }) as Arc<dyn RowGroupDocsCollector>;
    fn next_doc_tightens_min_doc() {
                "SingleCollector: skipping RG {} — nextDoc={} >= maxDoc={}",
    let surviving_rows = match page_ranges {
    call_strategy: CollectorCallStrategy,
    }
    let surviving_fraction = surviving_rows as f64 / rg.num_rows as f64;
    }
                    format!(
                    }
/// mock that replays a pre-computed bitset without an FFM call.
    use std::sync::Arc;
            index: 0,
            None,
            let bytes: &[u8] = unsafe {
        delegated_backend_collector_factory: Arc<dyn DelegatedBackendCollectorFactory>,
                        Some(r) if r.is_empty() => return Ok(None),
        doc_min: i32,
            pruning_predicate,
            first_row: 8,
            call_strategy,
            // let candidates_before = candidates.len();
        // Empty position map is fine; SingleCollectorEvaluator ignores it.
            candidates: candidates.clone(),
    /// evaluators of a single query via `Arc::clone`), so threads racing to fill
    fn forbid_parquet_pushdown(&self) -> bool {
        {
        let rg = RowGroupInfo {
    ffm_collector_calls: Option<datafusion::physical_plan::metrics::Count>,
    /// `should_consult_lucene` decides DF's own pruning wasn't selective enough
            mask_buffer: Some(mask_buffer),
        fn collect_packed_u64_bitset(
            None,
    }
                )
/// and nothing is needed here. In block-granular mode we need the
            }
            pruner,
        }) as Arc<dyn RowGroupDocsCollector>;
    #[test]
        let prefetched = eval
        }
            Arc::new(FfmDelegatedBackendCollectorFactory),
            writer_generation,
            num_rows: 8,
            None,
                    let upper = offset.saturating_add(num_docs);
                            result.words.len() * 8,
    ) -> Result<Option<BooleanArray>, String> {
        assert!(eval
                        c.add(1);
            rg_can_match: vec![false],
            None,
        );
    pub store: Arc<dyn object_store::ObjectStore>,
    /// the factory at query setup; lookups + `OnceLock` init happen ONLY when
/// Builds delegated-backend collectors for performance-delegated leaves. Production impl
        docs: Vec<i32>,
    /// flips the stream's `alignment_risk` computation which
            }
 *
    /// the bitset the trait contract requires.
    /// `PositionMap` to look up RG positions over the full delivered
                            let abs_min = min_doc + rg_pos as i32;
    fn next_doc_skips_subsequent_rg() {
                        &bloom.arrow_schema,
            writer_generation,
        }
        let prefetched = eval.prefetch_rg(&rg, 0, 8).unwrap().expect("has matches");
                words,
    /// rowset — pushdown would drop rows and misalign. In
                .map_err(|e| {
    mask_len: usize,
    pub arrow_schema: Arc<datafusion::arrow::datatypes::Schema>,
        let rg = RowGroupInfo {
                    let rg_pos = position_map.rg_position(delivered_idx).ok_or_else(|| {
    #[test]
            None,
    /// Without residual, we return `true` too — stream builds
                BooleanArray::new(bb, None)
        // an RG's start (== previous RG's exclusive max_doc) must NOT be dropped.
        doc_min: i32,
                return Ok(None);
                        &bloom.object_path,
            .ok_or_else(|| {
    /// Empty when the query has no performance-delegated leaves. Populated by
        // SingleCollectorEvaluator returns None from on_batch_mask, so
        rg_state: &dyn std::any::Any,
        let rg = RowGroupInfo {
                        None => vec![(min_doc, max_doc)],
        position_map: &PositionMap,
                    for s in sel.iter() {
        // the RuntimeManager to drive the async object-store read.
mod tests {
        fn collect_packed_u64_bitset(
                    );
            if let Some(&pos) = self.rg_index_to_pos.get(&rg.index) {
                    Some(r) => {
        let options = ArrowReaderOptions::new().with_page_index(true);
            .unwrap()
    /// check plus `forbid_parquet_pushdown`. We return `false` here
            ]))],
                let mut out = vec![0u64; words];
        let eval = SingleCollectorEvaluator::new(
                        for (r_min, r_max) in ranges {
        // No residual → no post-decode work. Stream's current_mask
        context_id: i64,
            let upper = offset.saturating_add(num_docs);
            Arc::new(HashMap::new()),
 * The OpenSearch Contributors require contributions made to
            Some(collector),
            HashMap::new(),
    collector: Option<Arc<dyn RowGroupDocsCollector>>,
    #[allow(dead_code)]
        let batch = datafusion::arrow::record_batch::RecordBatch::try_new(
}
                    // against a stale/sentinel next_doc dragging it backward.
    /// stream does. The stream guards this via its
    use datafusion::parquet::arrow::arrow_reader::ArrowReaderOptions;
            pruner,
                    let hit = rg_pos < state.mask_len
///
                        &*bloom.store,
            index: 1,
    pub bloom_filter_eval_time: Option<datafusion::physical_plan::metrics::Time>,
            None,
                    let idx = (doc - min_doc) as usize;
        let rg = RowGroupInfo {
                match &page_ranges {
                if let Some(ref c) = bloom.rg_bloom_pruned {
    /// mode (min_skip_run == 1) the stream ignores this flag's
            first_row: 8,
            index: 1,
                            let abs_max = min_doc + rg_pos as i32 + s.row_count as i32;
                c.add(1);
    }
        performance_provider_locks: Arc<HashMap<i32, Arc<OnceLock<ProviderHandle>>>>,
        // All pages pruned by stats → skip bloom + collector entirely.
    fn next_doc_at_rg_boundary_is_not_dropped() {
    ) -> Self {
            let provider = lock.get_or_init(|| {
                .create(context_id, provider.key(), self.writer_generation, min_doc, max_doc)
    use datafusion::parquet::arrow::arrow_reader::ArrowReaderMetadata;
            Arc::new(FfmDelegatedBackendCollectorFactory),
        });
    /// `on_batch_mask` uses PositionMap (alignment risk) — this flag
        // RG2: NOT skipped (next_doc=20 < max_doc=24)
            //     rg.index, self.writer_generation, candidates_before, peer_card, candidates.len()
                .performance_provider_locks
    /// (legacy path for SingleCollector without a residual wasn't
            Arc::new(HashMap::new()),
//! runs. Per RG:
        // Build candidates either from the always-call correctness collector OR, when
                        "DelegatedBackendCollectorFactory::create(context_id={}, provider={}, writer_generation={}, doc_range=[{},{})): {}",
            >::new()),
            .prefetch_rg(&rg, 0, 8)
        let collector = Arc::new(NextDocCollector {
        if let Some(ref ranges) = page_ranges {
            0,
        &self,
    mask_buffer: datafusion::arrow::buffer::Buffer,
    /// `current_mask` from Collector bitmap to narrow post-decode
        let collector = Arc::new(StubCollector {
        };
    context_id: i64,
        // bitsets. Today we consult the first leaf only — sufficient for AND-only
                return Ok(None);
        assert!(eval.prefetch_rg(&rg1, 8, 16).unwrap().is_none());
                    if next_doc_out >= *r_max {
            None,
            HashMap::new(),
    /// Writer generation identifying the segment this evaluator was bound to at
            HashMap::new(),
                    )
    /// each callback to the correct per-query `FilterDelegationHandle` and tracker.
    ///   stashed on `IndexedTableConfig.pushdown_predicate` and handed
        let pruner = minimal_page_pruner();
        }) as Arc<dyn RowGroupDocsCollector>;
    ///   Combined with the Collector-bitmap `RowSelection`, parquet
        let rg0 = RowGroupInfo {
        // universe. Performance leaves are AND'd in below if the selectivity gate fires.
            None,
            if ranges.is_empty() {
        let pf1 = eval
    fn prefetch_rg(
            0,
                            delivered_idx
                        Some(r) => vec![(r.first().unwrap().0, r.last().unwrap().1)],
            None,
            first_row: 0,
    pub fn new(
        );
            let collector = self
        residual_expr: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        .map_err(|e| format!("SingleCollectorEvaluator: and_kleene: {}", e))?;
    fn path_b_and_mode_collects_docs_and_returns_offsets() {
    #[test]
            }
                log_debug!(
    fn needs_row_mask(&self) -> bool {
    }
            None,
        page_prune_metrics: Option<PagePruneMetrics>,
            min_doc: i32,
//!    post-filtering is needed.
/// MORE than `threshold` of the RG (page pruning wasn't selective enough — peer
        // in Arrow's native LSB-first layout. This is the ONLY
            docs: vec![0, 3, 7],
/// Always AND-intersects the collector bitmap with page pruning. The
            max_doc: i32,
/// page-pruning kept more than 5% of an RG.
pub use super::CollectorCallStrategy;
                // Sub-ranges are ascending; carry the freshest next_doc forward so
        let eval = SingleCollectorEvaluator::new(
                        rg.index,
            // Identity: delivered row i == rg_position (batch_offset + i).
                let src_bytes = state.mask_buffer.as_slice();
        doc_max: i32,
    ) -> Result<Arc<dyn RowGroupDocsCollector>, String> {
        // Build Collector mask over delivered rows via PositionMap.
                vec![0i32; 8],
            None,
            0,
    #[test]
                        &bloom.metadata,
            0,
            index: 0,
use crate::indexed_table::stream::RowGroupInfo;
        assert_eq!(pf0.candidates.iter().collect::<Vec<_>>(), vec![5u32]);
                // already advanced to, not the stale pre-loop value.
        }) as Arc<dyn RowGroupDocsCollector>;
        false
 * this file be licensed under the Apache-2.0 license or a
                    CollectorCallStrategy::PageRangeSplit => match &page_ranges {
use datafusion::parquet::file::metadata::ParquetMetaData;
/// upstream — that asymmetry should go once we have more than one delegated backend
}
            None,
                    }
    }
                    result.words.as_ptr() as *const u8,
    #[test]
    #[test]
                            "SingleCollectorEvaluator: delivered_idx {} out of range",
            0,
        &self,
        if candidates.is_empty() {
            None,
//!    residual predicates during decode, so indices stay aligned and no
                .delegated_backend_collector_factory
pub struct SingleCollectorEvaluator {
        let prefetched = eval
    fn empty_match_returns_none() {
        assert_eq!(got, vec![1u32, 5]);
            CollectorCallStrategy::FullRange,
}
                    let bytes: &[u8] = unsafe {
            docs: vec![0],
    ///
            None,
///
                .expect("annotation_id was just pulled from the map's keys");
//! 1. Call the single collector → bitset.
            Some(collector),
                        chunk.remove_range(upper..);
            max_doc: i32,
        // the expensive FFM collector call. Uses the IO runtime handle from
                max_doc
        let mask_buffer = datafusion::arrow::buffer::Buffer::from_vec(packed_bits);
    }
            .expect("should have matches");
            vec![Arc::new(datafusion::arrow::array::Int32Array::from(vec![
/// Per-RG decision: should we consult the peer backend?
                        }
 */
        };
            &self,
    }
    }
            pruner,
    /// The HashMap is **query-scoped** (shared across all per-(segment×chunk)
        // Opportunistic peer consultation for performance-delegated leaves. Only fires
/// wraps `FfmSegmentCollector::create` (Java/Lucene round-trip); fuzz tests inject a
            performance_provider_locks,
            num_rows: 8,
        let Some(ref residual) = self.residual_expr else {
            num_rows: 8,
                bm
                    }
            let span = (max_doc - min_doc) as usize;
    ) -> Result<Option<PrefetchedRg>, String> {
                        )
    /// factory time. Captured so `prefetch_rg` can build a per-call
    /// decoding, `on_batch_mask` returns `None`, and output is
                    },
        let file = tmp.reopen().unwrap();
                            let lo = (*r_min as i64 - rg.first_row) as u32;
    last_next_doc: std::sync::atomic::AtomicI32,
            meta.schema(),
                    let idx = (doc - min_doc) as usize;
        let eval = SingleCollectorEvaluator::new(
            None,
        let pm = PositionMap::from_selection(
            num_rows: 8,
            pruner,
    struct StubCollector {
                mask_len,
    impl RowGroupDocsCollector for StubCollector {
            None,
    /// Bloom filter pruning config. None = disabled.
            index: 1,
            meta.schema().clone(),
            None,
        assert!(eval.prefetch_rg(&rg, 0, 8).unwrap().is_none());
        writer_generation: i64,
        _rg_first_row: i64,
        Ok(Some(PrefetchedRg {
            HashMap::from([(0, 0)]),
            index: 0,
        ) -> Result<CollectDocsResult, String> {
) -> bool {
        Self {
            None,
            0,
                })
                        )
                }
            Arc::new(StubCollector { docs: vec![1, 5] }) as Arc<dyn RowGroupDocsCollector>;
                    let mut rg_pos: i64 = 0;
/// shape routes to the multi-filter tree path today.
        let rg0 = RowGroupInfo {
            .prefetch_rg(&rg0, 0, 8)
//! (possibly zero, one, or many) parquet-native predicates, this evaluator
                    }
/// collectors are built inside this evaluator while correctness collectors are built
            Arc::new(FfmDelegatedBackendCollectorFactory),
                        "delegated-backend collector.collect_packed_u64_bitset(rg={}, [{}, {})): {}",
        // max(5, 4) = 5, not 4.
        .unwrap();
        // the collector bitmap: every doc the collector returns remains a
        page_pruner: Arc<PagePruner>,
            }
        let pruner = minimal_page_pruner();
#[derive(Debug)]
            // );
            let _timer = bloom.bloom_filter_eval_time.as_ref().map(|t| t.timer());
            Arc::new(FfmDelegatedBackendCollectorFactory),
            Arc::new(FfmDelegatedBackendCollectorFactory),
            Some(collector),
        Arc::new(pruner)
                // below may narrow further; otherwise DF's pushdown filter handles the
            None,
            HashMap::new(),
        // RG0 [0,4): doc 1 matches
//! 2. Apply page pruning (AND/OR mode depending on how the query combined them).
        // RG0 [0,8): doc 5 matches, next_doc=8 (boundary).
            .expect("should have matches");
        // AND with kleene semantics (NULL → exclude).
            num_rows: 8,
            && should_consult_lucene(&page_ranges, rg, HARDCODED_SELECTIVITY_THRESHOLD)
        &self,
                .map_err(|e| {
                        bm &= allowed;
                            let lo = (*r_min as i64 - rg.first_row) as u32;
    page_prune_metrics: Option<PagePruneMetrics>,
                    )
        let collector = Arc::new(NextDocCollector {
/// `DatafusionQueryConfig` in the very last phase, after Phase 7 OR/NOT support and
    /// `alignment_risk = min_skip_run != 1 && needs_row_mask()`
            None,
            pruner,
            None,
        // RG1 [4,8): doc 5 matches, effective_min tightened to 5
            docs: vec![1, 5],
            index: 0,
            stats_prune_tree,
        writer_generation: i64,
use crate::indexed_table::index::{CollectDocsResult, RowGroupDocsCollector};
    bloom_config: Option<BloomConfig>,
        let collector = Arc::new(StubCollector { docs: vec![0] }) as Arc<dyn RowGroupDocsCollector>;
        }
pub struct BloomConfig {
                    if let Some(ref ranges) = page_ranges {
                }
    }
    /// a slot do so once per (query × annotation_id) — not per chunk.
        let pruner = minimal_page_pruner();
    stats_prune_tree: Option<Arc<StatsPruneTree>>,
        next_doc: i32,
            None,
            }
    page_pruner: Arc<PagePruner>,
            index: 0,
            num_rows: 8,
            .prefetch_rg(&rg, 0, 8)
            for &doc in &self.docs {
        };
/// (DSL, vector, etc.) and the executor wants a single place to plug them in.
                    }
        };
            docs: vec![2, 20],
#[cfg(test)]
        let pruner = minimal_page_pruner();
            first_row: 0,
        let collector = Arc::new(StubCollector { docs: vec![] }) as Arc<dyn RowGroupDocsCollector>;
/// everything else. Until then, performance-delegated leaves consult the peer when DF
            // Per-RG debug log — see note above on `format!` cost. Re-enable locally for debugging.
            pruner,
            .expect("RG0 has doc 5");
            None,
                        context_id,
            context_id,
            None,
        );
            None,
            None,
        assert!(eval.prefetch_rg(&rg, 0, 8).unwrap().is_none());
        if let (Some(bloom), Some(pp)) = (&self.bloom_config, &self.pruning_predicate) {
            // );
            CollectorCallStrategy::FullRange,
use crate::indexed_table::row_selection::{
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
            pruner,
            //     rg.index, self.writer_generation, min_doc, max_doc, annotation_id
            0,
            rg_can_match: vec![true],
                datafusion::arrow::buffer::BooleanBuffer::new_set(batch_len),
    ///
            .unwrap()
                    "[scf-rust] lazy provider initialized context_id={} annotation_id={} provider_key={}",
            pruner,
const HARDCODED_SELECTIVITY_THRESHOLD: f64 = 0.05;
        };
        let mask_len = rg.num_rows as usize;
    /// mode; in row-granular mode that guard is inactive and
        // Page-prune to discover which row ranges survive.
//! Single-collector evaluator — one backend collector plus DataFusion for
                let mut bm = RoaringBitmap::new();
    ) -> Result<Arc<dyn RowGroupDocsCollector>, String>;
            bloom_config,
        true
            0,
    #[derive(Debug)]
    ///   AND-combines with the Collector bitmap mask to produce the
            }
                    if upper < u32::MAX {
            // Runs: gather per-row bit from the shared mask_buffer into
                        provider.key(),
        let pruner = PagePruner::new(
        };
        // RG0 [0,8): collector returns next_doc=20 (beyond RG1's max_doc=16)
    }
        let collector = FfmSegmentCollector::create(
                    Some(r) if r.is_empty() => return Ok(None),
            // BooleanBuffer::new adjusts bit_offset without copying the
/// Per-RG state the evaluator keeps for refinement. In row-granular
                            let hi = (*r_max as i64 - rg.first_row) as u32;
            let span = (max_doc - min_doc) as usize;
            let annotation_id = *self
            0,
        let collector =
            Arc::new(HashMap::new()),
        };
    /// Always-call collector for correctness-delegated predicates. `None` when
                    result.words.len() * 8,
/// Replaced by a cluster setting plumbed through `WireConfigSnapshot` and
            Arc::new(FfmDelegatedBackendCollectorFactory),
            let lock = self
            let mut words = vec![0u64; (span + 63) / 64];
        // RG1: skipped (next_doc=MAX > any max_doc)
                if doc >= min_doc && doc < max_doc {
    /// rowset, on_batch_mask returns None below).
                    CollectorCallStrategy::TightenOuterBounds => match &page_ranges {
        // (it's the only post-decode filter we have on this path).
            0,
    /// the RG can be skipped without an FFM call. Initialized to i32::MIN (no skip info).
    /// Counters recorded by `page_pruner.prune_rg`. Built from the
            Arc::new(FfmDelegatedBackendCollectorFactory),
            None,
        let spt = StatsPruneTree {
        );
        assert!(eval.prefetch_rg(&rg1, 8, 16).unwrap().is_none());
            None,
        assert!(eval.prefetch_rg(&rg0, 0, 8).unwrap().is_some());
        min_doc: i32,
        let eval = SingleCollectorEvaluator::new(
    }
            num_rows: 4,
                last_next,
/// `mask_buffer` is the candidate bitmap in Arrow's native LSB-first bit
        let rg0 = RowGroupInfo {
        // (filter_row_ids returns input, candidate_row_ids returns [first_row, first_row+num_rows)).
                    },
            // log_debug!(
                if self.call_strategy != CollectorCallStrategy::PageRangeSplit {
            None,
            None,
    /// exact. But the evaluator doesn't know min_skip_run — the
            }
            &self,
            }),
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int32, false)]));
            doc_min,
impl DelegatedBackendCollectorFactory for FfmDelegatedBackendCollectorFactory {
impl RowGroupBitsetSource for SingleCollectorEvaluator {
    ///
    /// Next matching docId from the last collectDocs call. When next_doc >= rg.max_doc,
                    bm |= chunk;
        };
            pruner,
    fn create(
use native_bridge_common::log_debug;
                        e
        // RG1: skipped (next_doc=20 > max_doc=16)
                        } else {
            None,
            first_row: 0,
                        pp.as_ref(),
    /// AND, converted to a single `PhysicalExpr`).
use std::sync::Arc;
            index: 1,
        };
        }) as Arc<dyn RowGroupDocsCollector>;
            None,
        );
use roaring::RoaringBitmap;
                    })?;
        // IndexedStream must build current_mask from candidate offsets
            0,
            None,
                    batch_offset,
            Arc::new(HashMap::new()),
                        .map_err(|e| {
            first_row: 8,
    fn _use(_: &dyn fmt::Debug) {}
            Arc::new(FfmDelegatedBackendCollectorFactory),
