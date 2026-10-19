            0,
            Some(collector),
    ///   Combined with the Collector-bitmap `RowSelection`, parquet
    }
                    // Advance only forward — the iterator position is monotonic; guard
            first_row: 0,
            None,
        // (if built) handles Collector narrowing.
        let pf = eval.prefetch_rg(&rg2, 16, 24).unwrap();
    use super::*;
    fn _use(_: &dyn fmt::Debug) {}
            mask_buffer: Some(mask_buffer),
        doc_min: i32,
                    state.mask_buffer.clone(),
        };
        let collector = Arc::new(StubCollector {
            0,
                last_next,
                c.add(1);
                // Performance-only query. Seed candidates with the page-pruned universe
            index: 1,
        let rg = RowGroupInfo {
            ffm_collector_calls,
    /// mode (min_skip_run == 1) the stream ignores this flag's
        );
            first_row: 8,
                    .expect("create_provider FFM upcall failed")
            Some(collector),
    ///
    fn minimal_page_pruner() -> Arc<PagePruner> {
            Arc::new(HashMap::new()),
            Some(collector),
    }
            }
            0,
            doc_min,
        provider_key: i32,
        // RG-level early-exit: precomputed from column stats at construction.
            pruner,
                for (r_min, r_max) in &call_ranges {
            stats_prune_tree,
            0,
                let words = batch_len.div_ceil(64);
        let got: Vec<u32> = prefetched.candidates.iter().collect();
    pub object_path: object_store::path::Path,
/// can't help, so consult.
    /// - **Block-granular** (`min_skip_run > 1`): pushdown is OFF
    }
        // `BooleanBuffer::new(buf.clone(), bit_offset, bit_len)`.
        let rg = RowGroupInfo {
            index: 0,
    }
/// (peer call would be wasted work).
            context_id,
/// the classifier (reserved for a future `OR(Collector, predicates)`
            None,
        let got: Vec<u32> = prefetched.candidates.iter().collect();
        // candidate. (Contrast with the old BitsetMode::Or path, which
    /// stream's `PartitionMetrics` at evaluator construction.
        rg: &RowGroupInfo,
        // Collector has doc at position 5. next_doc=5 means the iterator
                );
        let combined = datafusion::arrow::compute::kernels::boolean::and_kleene(
            // underlying Buffer. The returned BooleanArray points into
                    CollectorCallStrategy::PageRangeSplit => match &page_ranges {
    page_pruner: Arc<PagePruner>,
    /// Collector path always performs one FFM round-trip to Java.
        let collector = Arc::new(StubCollector { docs: vec![0] }) as Arc<dyn RowGroupDocsCollector>;
    ///   stashed on `IndexedTableConfig.pushdown_predicate` and handed
        // `Buffer` is a refcounted view into `state.mask_buffer` —
                    bitset[idx / 64] |= 1u64 << (idx % 64);
        writer_generation: i64,
            };
                    native_bridge_common::log_debug!(
        position_map: &PositionMap,
) -> bool {
        // Build a 1-row-group parquet with no filters — page pruner becomes a no-op
            num_rows: 8,
                    let mut chunk = RoaringBitmap::from_lsb0_bytes(offset, bytes);
    pub bloom_filter_eval_time: Option<datafusion::physical_plan::metrics::Time>,
/// Always AND-intersects the collector bitmap with page pruning. The
            let span = (max_doc - min_doc) as usize;
            pruner,
                // already advanced to, not the stale pre-loop value.
        let last_next = self
    /// stream does. The stream guards this via its
            //     rg.index, self.writer_generation, candidates_before, peer_card, candidates.len()
                datafusion::parquet::arrow::arrow_reader::RowSelector,
                        std::slice::from_raw_parts(
    page_prune_metrics: Option<PagePruneMetrics>,
        // IndexedStream must build current_mask from candidate offsets
                1, 2, 3,
/// `page_ranges == None` means there's no usable PruningPredicate for the
            candidates &= peer_bm;
            .load(std::sync::atomic::Ordering::Acquire);
        // RG0 [0,8): collector returns next_doc=20 (beyond RG1's max_doc=16)
            CollectorCallStrategy::FullRange,
            let mut peer_bm = RoaringBitmap::from_lsb0_bytes(offset, bytes);
    fn prefetch_rg(
            num_rows: 4,
                    .block_on(crate::indexed_table::bloom_pruner::bloom_prune_rg(
        assert_eq!(got, vec![0u32, 3, 7]);
        let collector = Arc::new(NextDocCollector {
            Arc::new(FfmDelegatedBackendCollectorFactory),
                        )
            None,
    #[test]
            0,
            native_bridge_common::log_debug!(
            let annotation_id = *self
            0,
    ) -> Self {
            None,
    use std::fmt;
                        Some(r) => vec![(r.first().unwrap().0, r.last().unwrap().1)],
            HashMap::from([(0, 0)]),
            None,
            num_rows: 8,
/// extension) and has been removed; an OR-between-Collector-and-predicates
        }
        // Build Collector mask over delivered rows via PositionMap.
        let pf1 = eval
            HashMap::new(),
        );
            .on_batch_mask(&(), 0, &pm, 0, 3, &batch)
                    bm |= chunk;
            ))],
            None,
                .performance_provider_locks
/// Replaced by a cluster setting plumbed through `WireConfigSnapshot` and
            // Per-RG debug log — see note above on `format!` cost. Re-enable locally for debugging.
                bm
                // For FullRange and TightenOuterBounds, AND with page bitmap
        };
                    if hit {
        pruning_predicate: Option<Arc<PruningPredicate>>,
            //     rg.index, self.writer_generation, min_doc, max_doc, annotation_id
    }
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int32, false)]));
            num_rows: 8,
            index: 0,
/// Re-exported from parent module for backward compatibility.
            None,
            // Runs: gather per-row bit from the shared mask_buffer into
const HARDCODED_SELECTIVITY_THRESHOLD: f64 = 0.05;
                create_provider(context_id, annotation_id)
                        max_doc,
                            rg_pos += s.row_count as i64;
//!    post-filtering is needed.
            HashMap::from([(0, 0)]),
            ),
            Some(collector),
            None,
        };
            None,
                    },
        // RG1 [4,8): doc 5 matches, effective_min tightened to 5
        docs: Vec<i32>,
//! residual predicates.
            .last_next_doc
            pruner,
        }
use datafusion::parquet::file::metadata::ParquetMetaData;
            CollectorCallStrategy::FullRange,
        };
            docs: vec![1, 5],
            None,
            // log_debug!(
            .unwrap()
 * this file be licensed under the Apache-2.0 license or a
                return Ok(None);
            let context_id = self.context_id;
                            allowed.insert_range(lo..hi);
            None,
            None,
        assert!(eval.prefetch_rg(&rg1, 8, 16).unwrap().is_none());
                    let rg_pos = position_map.rg_position(delivered_idx).ok_or_else(|| {
    /// Writer generation identifying the segment this evaluator was bound to at
            Arc::new(HashMap::new()),
            None,
                    );
            meta.metadata().clone(),
            Some(collector),
        let mask_len = rg.num_rows as usize;
                    ranges
                })?;
                    }
            }
            None,
            .is_none());
                for i in 0..batch_len {
            index: 0,
    /// **row-granular mode** (`min_skip_run == 1`), pushdown is safe
                    None => {
    /// and desirable: parquet applies the residual in lockstep with
        let packed_bits = bitmap_to_packed_bits(&candidates, mask_len as u32);
                    CollectorCallStrategy::FullRange => vec![(min_doc, max_doc)],
}
            None,
        let pruner = minimal_page_pruner();
///
        let eval = SingleCollectorEvaluator::new(
        let prefetched = eval.prefetch_rg(&rg, 0, 8).unwrap().expect("has matches");
/// MORE than `threshold` of the RG (page pruning wasn't selective enough — peer
            None,
        };
            pruner,
                mask_len,
            docs: vec![0, 3, 7],
            pruner,
        None => rg.num_rows as i64,
            0,
            first_row: 0,
            Arc::new(FfmDelegatedBackendCollectorFactory),
    }
            Arc::new(FfmDelegatedBackendCollectorFactory),
            index: 1,
    impl RowGroupDocsCollector for NextDocCollector {
        page_prune_metrics: Option<PagePruneMetrics>,
                    let idx = (doc - min_doc) as usize;
        // skipping the FFM round-trip when DF was already selective. Lazy: lock the
            num_rows: 8,
                    let offset = (effective_min as i64 - rg.first_row) as u32;
            >::new()),
                        )
            HashMap::new(),
        let mask_buffer = datafusion::arrow::buffer::Buffer::from_vec(packed_bits);
 */
            // a new packed Vec<u64> (small — bounded by batch_len/64).
        if let Some(ref ranges) = page_ranges {
    }
        let collector = Arc::new(StubCollector { docs: vec![] }) as Arc<dyn RowGroupDocsCollector>;
                    .io_handle
        // RG0: has doc 2
            0,
                })
        };
                    c.add(1);
    fn next_doc_at_rg_boundary_is_not_dropped() {
            docs: vec![0],
            }
        let pruner = minimal_page_pruner();
                            "SingleCollectorEvaluator: delivered_idx {} out of range",
            Arc::new(FfmDelegatedBackendCollectorFactory),
            page_pruner,
        let pruner = minimal_page_pruner();
            provider_key,
            num_rows: 8,
                vec![0i32; 8],
            rg_can_match: vec![true],
    ) -> Result<Arc<dyn RowGroupDocsCollector>, String>;
    #[test]
                // residual at decode time.
        let pf = eval.prefetch_rg(&rg0, 0, 4).unwrap().expect("has match");
            first_row: 0,
    stats_prune_tree: Option<Arc<StatsPruneTree>>,
            Arc::new(HashMap::new()),
                    }
        assert_eq!(pf.candidates.iter().collect::<Vec<_>>(), vec![2u32]);
        let eval = SingleCollectorEvaluator::new(
    /// AND, converted to a single `PhysicalExpr`).
                    let delivered_idx = batch_offset + i;
            first_row: 0,
/// Resources needed for per-RG bloom filter pruning.
        let collector =
                        pp.as_ref(),
            next_doc: 5,
                BooleanArray::new(bb, None)
fn should_consult_lucene(
            rg_index_to_pos,
        // Bloom filter pruning: runs after page pruning (free) but before
            num_rows: 8,
                        None => vec![(min_doc, max_doc)],
        };
                        for (r_min, r_max) in ranges {
        fn collect_packed_u64_bitset(
    #[test]
                    let idx = (doc - min_doc) as usize;
            vec![Arc::new(datafusion::arrow::array::Int32Array::from(vec![
                if self.call_strategy != CollectorCallStrategy::PageRangeSplit {
    /// Bloom filter pruning config. None = disabled.
                        "delegated-backend collector.collect_packed_u64_bitset(rg={}, [{}, {})): {}",
        assert!(eval.prefetch_rg(&rg, 0, 8).unwrap().is_none());
                if doc >= min_doc && doc < max_doc {
        batch: &RecordBatch,
        // map only if the gate fires; create the provider only once per query × leaf.
    #[test]
        let eval = SingleCollectorEvaluator::new(
        let got: Vec<u32> = prefetched.candidates.iter().collect();
                        rg.index,
        assert_eq!(pf0.candidates.iter().collect::<Vec<_>>(), vec![5u32]);
        );
            None,
                        chunk.remove_range(upper..);
                // to remove rows in dead pages that the collector scanned.
        let collector = Arc::new(StubCollector {
            0,
            0,
        context_id: i64,
            0,
                .keys()
            Arc::new(FfmDelegatedBackendCollectorFactory),
        let rg0 = RowGroupInfo {
        // max_doc is exclusive, so nextDoc == max_doc also means "no match in this RG".
 *
        assert_eq!(got, vec![1u32, 5]);
    surviving_fraction > threshold
            0,
    }
    /// Used in two modes:
        let eval = SingleCollectorEvaluator::new(
            None,
            Arc::new(HashMap::new()),
            None,
            let num_docs = (max_doc - min_doc) as u32;
            None,
use roaring::RoaringBitmap;
    bitmap_to_packed_bits, packed_bits_to_boolean_array, row_selection_to_bitmap, PositionMap,
            //     "[scf-rust] peer bitset intersected rg={} writer_generation={} candidates_before={} peer_cardinality={} candidates_after={}",
        let pruner = minimal_page_pruner();
/// and nothing is needed here. In block-granular mode we need the
        &self,
            children: vec![],
            .expect("should have matches");
        let pruner = minimal_page_pruner();
        );
                    CollectorCallStrategy::TightenOuterBounds => match &page_ranges {
    /// Lazy `ProviderHandle` cache, one per performance-delegated annotation_id.
    ) -> Result<Arc<dyn RowGroupDocsCollector>, String> {
            num_rows: 4,
    fn create(
            pruner,
        }) as Arc<dyn RowGroupDocsCollector>;
                    }
                // below may narrow further; otherwise DF's pushdown filter handles the
            collector,
        Ok(Some(combined))
    #[allow(dead_code)]
                packed_bits_to_boolean_array(out, batch_len)
    pub io_handle: tokio::runtime::Handle,
    pub fn new(
///
            }
                }
            if pruned {
                log_debug!(
                candidates,
    /// `alignment_risk = min_skip_run != 1 && needs_row_mask()`
            }
    fn next_doc_skips_subsequent_rg() {
            let mut bitset = vec![0u64; (span + 63) / 64];
                }
        performance_provider_locks: Arc<HashMap<i32, Arc<OnceLock<ProviderHandle>>>>,
        // in Arrow's native LSB-first layout. This is the ONLY
            index: 0,
            HashMap::new(),
            None,
//! 1. Call the single collector → bitset.
            0,
    }
            let provider = lock.get_or_init(|| {
                .performance_provider_locks
        _rg_first_row: i64,
    /// Per-query context identifier passed through every FFM upcall so Java can route
    #[test]
/// shape routes to the multi-filter tree path today.
/// layout, wrapped as a refcounted `Buffer`. Sharing an `Arc<Buffer>` lets
            first_row: 0,
            }
                    for s in sel.iter() {
    ///   (alignment risk with coalesced selection). `on_batch_mask`
                    Some(r) if r.is_empty() => return Ok(None),
                            delivered_idx
            Some(Arc::new(spt)),
            None,
            first_row: 8,
    #[test]
        };
        let pf0 = eval
    /// (legacy path for SingleCollector without a residual wasn't
                // Sub-ranges are ascending; carry the freshest next_doc forward so
            call_strategy,
            Arc::new(HashMap::new()),
    }
        assert!(eval
    }
            // log_debug!(
                }
    /// for an RG. Drop releases the Lucene Weight via `releaseProvider`.
/// wraps `FfmSegmentCollector::create` (Java/Lucene round-trip); fuzz tests inject a
    /// wires `FfmDelegatedBackendCollectorFactory`; fuzz tests inject a mock that
    /// replays a pre-computed bitset without an FFM call.
                            bm.insert_range(lo..hi);
    ///
                .get(&annotation_id)
                    }
            Some(collector),
            Arc::new(FfmDelegatedBackendCollectorFactory),
                        bm.insert_range(0..rg.num_rows as u32);
        if candidates.is_empty() {
        let eval = SingleCollectorEvaluator::new(
                        }
            docs: vec![5, 8],
            CollectorCallStrategy::FullRange,
                            format!(
        // docs: 5 (in RG0) and 8 (start of RG1, == RG0's max_doc=8).
            CollectorCallStrategy::FullRange,
                .create(context_id, provider.key(), self.writer_generation, min_doc, max_doc)
            meta.schema().clone(),
            None,
/// can route each callback to the correct per-query handle and tracker.
                "SingleCollectorEvaluator: rg_state is not SingleCollectorState".to_string()
            index: 0,
                            result.words.len() * 8,
                    "[scf-rust] lazy provider initialized context_id={} annotation_id={} provider_key={}",
struct SingleCollectorState {
            &residual_mask,
        });
    }
            delegated_backend_collector_factory,
            None,
}
    performance_provider_locks: Arc<HashMap<i32, Arc<OnceLock<ProviderHandle>>>>,
        let rg1 = RowGroupInfo {
        // RG1 [8,16): next_doc=8 == min_doc, NOT skipped. Doc 8 must be collected.
        );
impl RowGroupBitsetSource for SingleCollectorEvaluator {
            candidates: candidates.clone(),
                    let upper = offset.saturating_add(num_docs);
        delegated_backend_collector_factory: Arc<dyn DelegatedBackendCollectorFactory>,
                        min_doc,
                    let mut ranges = Vec::new();
            None,
    }
        context_id: i64,
    }
    fn empty_pruning_predicates_leave_collector_unchanged() {
                return Ok(None);
/// Production factory: delegates to `FfmSegmentCollector::create`, which round-trips
                bloom
    }
                    if let Some(ref c) = self.ffm_collector_calls {
        let pruner = PagePruner::new(
    let surviving_rows = match page_ranges {
        batch_offset: usize,
            .ok_or_else(|| {
        // No residual → no post-decode work. Stream's current_mask
            .expect("RG0 has doc 5");
                // Dispatch collector call strategy.
    use std::sync::Arc;
    use tempfile::NamedTempFile;
                    result.words.as_ptr() as *const u8,
            let bytes: &[u8] = unsafe {
            index: 1,
        }) as Arc<dyn RowGroupDocsCollector>;
    use datafusion::parquet::arrow::arrow_reader::ArrowReaderMetadata;
    }
        };
                        bm &= allowed;
        let collector = Arc::new(StubCollector { docs: vec![0] }) as Arc<dyn RowGroupDocsCollector>;
        }) as Arc<dyn RowGroupDocsCollector>;
                    let num_docs = (*r_max - effective_min) as u32;
    bloom_config: Option<BloomConfig>,
        // RG1: skipped (next_doc=MAX > any max_doc)
        writer_generation: i64,
    /// Stub collector: returns a pre-defined set of doc IDs, encoded into
    /// top-level AND, translated to a `PruningPredicate`. `None` means
    }
    use datafusion::parquet::arrow::arrow_reader::ArrowReaderOptions;
            num_rows: 8,
        let spt = StatsPruneTree {
                    result.words.len() * 8,
            0,
            None,
        );
            // );
            })?;
                        } else {
        fn collect_packed_u64_bitset(
    /// upfront — see `performance_provider_locks`).
            }
                        context_id,
    /// no residual predicate applies (nothing to prune with).
            children: vec![],
            writer_generation,
        // the RuntimeManager to drive the async object-store read.
        next_doc: i32,
            num_rows: 8,
use std::collections::HashMap;
    mask_buffer: datafusion::arrow::buffer::Buffer,
use crate::indexed_table::stream::RowGroupInfo;
    /// pushdown impact and pushes anyway (which is what we want:
            None,
///
                mask_buffer: mask_buffer.clone(),
/// Collector candidate bitmap to build a post-decode mask.
    fn forbid_parquet_pushdown(&self) -> bool {
                        }
            return Ok(None);
        let rg1 = RowGroupInfo {
        ffm_collector_calls: Option<datafusion::physical_plan::metrics::Count>,
            context: Box::new(SingleCollectorState {
            None,
                let bb = datafusion::arrow::buffer::BooleanBuffer::new(
        };
        };
            residual_expr,
    /// Mock collector that returns specific docs AND a configurable next_doc.
        &self,
            if ranges.is_empty() {
        );
        assert!(pf.is_some());
        let rg2 = RowGroupInfo {
    /// The HashMap is **query-scoped** (shared across all per-(segment×chunk)
/// mock that replays a pre-computed bitset without an FFM call.
                    let effective_min = next_doc_out.max(*r_min);
            let span = (max_doc - min_doc) as usize;
    /// parquet applies residual during decode of already-narrowed
        let pruner = minimal_page_pruner();
        let collector = Arc::new(NextDocCollector {
            CollectorCallStrategy::FullRange,
                let call_ranges: Vec<(i32, i32)> = match self.call_strategy {
        // AND with kleene semantics (NULL → exclude).
            &self,
        Self {
        // when DF page-pruning kept more than the configured fraction of the RG —
            Arc::new(FfmDelegatedBackendCollectorFactory),
    /// and rely on `needs_row_mask = true` (default when residual is
        doc_min: i32,
            next_doc: i32::MAX,
/// upstream — that asymmetry should go once we have more than one delegated backend
    #[test]
            pruner,
                            ranges.push((abs_min, abs_max));
            HashMap::new(),
            }),
    // Keep the `fmt` import used
            PositionMap::Runs { .. } => {
                    let hit = rg_pos < state.mask_len
            next_doc: 20,
            pruner,
    };
        }
        let batch = datafusion::arrow::record_batch::RecordBatch::try_new(
        )
#[derive(Debug)]
use crate::indexed_table::row_selection::{
            None,
///
            None,
        // RG0: has doc 0
            None,
        // All pages pruned by stats → skip bloom + collector entirely.
                        for (r_min, r_max) in r {
        if last_next >= max_doc {
    /// `should_consult_lucene` decides DF's own pruning wasn't selective enough
        let eval = SingleCollectorEvaluator::new(
                max_doc
/// `DatafusionQueryConfig` in the very last phase, after Phase 7 OR/NOT support and
}
                        .map_err(|e| {
        .unwrap();
            None,
            None,
            &datafusion::parquet::arrow::arrow_reader::RowSelection::from(Vec::<
/// (DSL, vector, etc.) and the executor wants a single place to plug them in.
            // );
    if rg.num_rows == 0 {
    ///   delivers exact `Collector ∧ residual` rows. `on_batch_mask`
        }
            None,
            HashMap::new(),
    /// exact. But the evaluator doesn't know min_skip_run — the
            writer.write(&batch).unwrap();
            if let Some(&pos) = self.rg_index_to_pos.get(&rg.index) {
/// page-pruning kept more than 5% of an RG.
                            let hi = (*r_max as i64 - rg.first_row) as u32;
        // RG2 [16,24): next_doc=20 < 24, should NOT be skipped (doc 20 is in range)
            Ok(CollectDocsResult {
            None,
    /// factory time. Captured so `prefetch_rg` can build a per-call
    /// each callback to the correct per-query `FilterDelegationHandle` and tracker.
            }
            Some(collector),
}
            if upper < u32::MAX {
    /// `current_mask` from Collector bitmap to narrow post-decode
impl SingleCollectorEvaluator {
//! 3. Hand the bitset offsets to `IndexedStream` as a RowSelection.
            meta.schema(),
    fn create(
                // Call collector for each range, merge into one RG-relative bitmap.
    ) -> Result<Option<PrefetchedRg>, String> {
                words,
    ///   to parquet's `with_predicate` for decode-time filtering.
            first_row: 16,
        &self,
    fn needs_row_mask(&self) -> bool {
                    return Ok(None);
    fn next_doc_tightens_min_doc() {
        // Skip RG if the previous collectDocs told us the next match is beyond this RG.
    rg: &RowGroupInfo,
            Arc::new(HashMap::new()),
        // is at doc 5 after RG0. For RG1 [4,8), effective_min should be
 * compatible open source license.
            None,
                // (or the full RG if no PruningPredicate). The opportunistic peer branch
            .expect("RG1 has boundary doc 8");
        let batch = datafusion::arrow::record_batch::RecordBatch::try_new(
        // Vec<u64> for Runs.
use native_bridge_common::log_debug;
    fn on_batch_mask(
/// everything else. Until then, performance-delegated leaves consult the peer when DF
    use datafusion::parquet::arrow::ArrowWriter;
            let mut just_initialized = false;
        }
        let pf = eval.prefetch_rg(&rg0, 0, 8).unwrap().expect("has match");
            first_row: 0,
use datafusion::arrow::array::BooleanArray;
        let eval = SingleCollectorEvaluator::new(
        rg_index_to_pos: HashMap<usize, usize>,
/// `mask_buffer` is the candidate bitmap in Arrow's native LSB-first bit
pub use super::CollectorCallStrategy;
                            result.words.as_ptr() as *const u8,
mod tests {
            schema,
            Some(collector),
            // BooleanBuffer::new adjusts bit_offset without copying the
                }
        let Some(ref residual) = self.residual_expr else {
        assert_eq!(got, vec![0u32, 3, 7]);
/// residual at all (e.g. text-column predicate with no parquet stats) — DF
    /// Residual pruning predicate: the non-Collector portion of the
                datafusion::arrow::buffer::BooleanBuffer::new_set(batch_len),
    /// - **Row-granular** (`min_skip_run = 1`): the same expression is
/// Pure function. Inputs: post-page-prune surviving ranges, RG row count, and the
            max_doc: i32,
    /// mode; in row-granular mode that guard is inactive and
            // state.mask_buffer; lifecycle is Arc-managed.
        assert!(eval.needs_row_mask());
            //     "[scf-rust] consulting peer for performance leaf rg={} writer_generation={} range=[{},{}) annotation_id={}",
        )?;
            first_row: 0,
        // single-call demo. Multi-leaf intersection is part of D3 follow-up.
                    format!(
    residual_expr: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
            None,
    /// Counters recorded by `page_pruner.prune_rg`. Built from the
}
        let rg0 = RowGroupInfo {
            rg_can_match: vec![false],
            }
        let rg1 = RowGroupInfo {
/// configured selectivity threshold. The function says "consult" when DF kept
            pruner,
            None,
        // RG0 [0,8): doc 5 matches, next_doc=8 (boundary).
            0,
            self.page_pruner
            vec![Arc::new(datafusion::arrow::array::Int32Array::from(
            None,
    ) -> Result<Option<BooleanArray>, String> {
        Arc::new(pruner)
            Arc::new(HashMap::new()),
    fn path_b_and_mode_collects_docs_and_returns_offsets() {
/// TODO: extend this factory to also build the *correctness* collector currently passed
        true
        let rg = RowGroupInfo {
        if let (Some(bloom), Some(pp)) = (&self.bloom_config, &self.pruning_predicate) {
            let mut writer =
            docs: vec![2, 20],
            &self,
        let state = rg_state
            0,
        let residual_mask = super::eval_helpers::evaluate_residual(residual, batch, batch_len)?;
            );
        let spt = StatsPruneTree {
            performance_provider_locks,
    candidates: RoaringBitmap,
                "SingleCollector: skipping RG {} — nextDoc={} >= maxDoc={}",
                if let Some(&false) = spt.rg_can_match.get(pos) {
            // Every delivered row is by construction a candidate — mask is all-true.
            None,
            None,
                }
/// views via `BooleanBuffer::new(buf.clone(), bit_offset, bit_len)`.
            HashMap::new(),
    collector: Option<Arc<dyn RowGroupDocsCollector>>,
        // zero allocation for Identity, at most one small packed
        // Page-prune to discover which row ranges survive.
                }
                    )
                }
    /// the RG can be skipped without an FFM call. Initialized to i32::MIN (no skip info).
    call_strategy: CollectorCallStrategy,
    ///   exact result.
        doc_max: i32,
            PositionMap::Identity { .. } => {
            Arc::new(FfmDelegatedBackendCollectorFactory),
        assert!(eval.prefetch_rg(&rg1, 8, 16).unwrap().is_none());
        }) as Arc<dyn RowGroupDocsCollector>;
            if just_initialized {
    fn next_doc_max_value_skips_all_remaining() {
        // Materialise the final RG-relative bitmap as an Arrow `Buffer`
        // next_doc = i32::MAX means scorer exhausted — all subsequent RGs skipped
        &self,
use datafusion::arrow::record_batch::RecordBatch;
            .prefetch_rg(&rg1, 8, 16)
            .downcast_ref::<SingleCollectorState>()
    /// pushdown proceeds.
                            let lo = (*r_min as i64 - rg.first_row) as u32;
    ///   AND-combines with the Collector bitmap mask to produce the
                    },
            None,
            Arc::new(FfmDelegatedBackendCollectorFactory),
//! Single-collector evaluator — one backend collector plus DataFusion for
        assert_eq!(pf.candidates.iter().collect::<Vec<_>>(), vec![1u32]);
            index: 1,
        let collector = Arc::new(NextDocCollector {
    #[derive(Debug)]
    fn stats_prune_tree_skips_rg_when_false() {
        // Build candidates either from the always-call correctness collector OR, when
            HashMap::new(),
            HashMap::new(),
                    let bytes: &[u8] = unsafe {
            None,
            None,
    /// Precomputed per-RG/subtree match status from RG-level column stats.
    ///
            None,
    mask_len: usize,
    fn empty_match_returns_none() {
            docs: vec![0, 3, 7],
                    context_id, annotation_id, provider.key()
                                rg.index, r_min, r_max, e
                let mut out = vec![0u64; words];
        stats_prune_tree: Option<Arc<StatsPruneTree>>,
            Arc::new(StubCollector { docs: vec![1, 5] }) as Arc<dyn RowGroupDocsCollector>;
    }
    pub store: Arc<dyn object_store::ObjectStore>,
    /// check plus `forbid_parquet_pushdown`. We return `false` here
    /// When we have a residual to apply in `on_batch_mask`, pushdown
        docs: Vec<i32>,
                            let abs_min = min_doc + rg_pos as i32;
                let src_bytes = state.mask_buffer.as_slice();
    pruning_predicate: Option<Arc<PruningPredicate>>,
            None,
        let eval = SingleCollectorEvaluator::new(
        // TODO(d3): consult ALL performance leaves whose gate fires and AND their
            None,
            pruner,
                self.last_next_doc
        }) as Arc<dyn RowGroupDocsCollector>;
            // (the level filter happens on the Java side). Commented out to avoid
 * SPDX-License-Identifier: Apache-2.0
                ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), None).unwrap();
                    Some(r) => {
                        continue;
        ) -> Result<CollectDocsResult, String> {
        };
        // the query is performance-only (no Collector leaves), from the page-pruned
        // representation the hot paths (`on_batch_mask`, `build_mask`)
                        "DelegatedBackendCollectorFactory::create(context_id={}, provider={}, writer_generation={}, doc_range=[{},{})): {}",
        };
            // let candidates_before = candidates.len();
 * The OpenSearch Contributors require contributions made to
/// TODO(phase-99): hardcoded selectivity threshold for opportunistic peer consultation.
        if let Some(ref spt) = self.stats_prune_tree {
        // RG1 [8,16): should be skipped entirely
            });
    /// Without residual, we return `true` too — stream builds
/// Evaluator holding one collector and applying per-RG page pruning.
        let rg0 = RowGroupInfo {
            Arc::new(HashMap::new()),
        let pruner = minimal_page_pruner();
            None,
            }
    /// decoding, `on_batch_mask` returns `None`, and output is
                            let hi = (*r_max as i64 - rg.first_row) as u32;
        }) as Arc<dyn RowGroupDocsCollector>;
        }
        ) -> Result<CollectDocsResult, String> {
    ///   evaluates this expression against the decoded batch and
//!
        let collector = FfmSegmentCollector::create(
    /// used in production but kept for defensive correctness).
use std::sync::OnceLock;
                        if s.skip {
            docs: vec![0, 3, 7],
        };
        {
    }
            eval_nanos: t.elapsed().as_nanos() as u64,
    /// Always-call collector for correctness-delegated predicates. `None` when
    /// rowset, on_batch_mask returns None below).
        // Regression for the exclusive-boundary bug: a match sitting exactly at
    last_next_doc: std::sync::atomic::AtomicI32,
            context_id,
            .unwrap()
    context_id: i64,
        writer_generation: i64,
        };
        if !self.performance_provider_locks.is_empty()
            first_row: 4,
}
                    next_doc_out = next_doc_out.max(result.next_doc);
}
        let pruner = minimal_page_pruner();
    #[test]
            Arc::new(FfmDelegatedBackendCollectorFactory),
            0,
        // RG1: skipped (next_doc=20 > max_doc=16)
                .min()
/// Builds delegated-backend collectors for performance-delegated leaves. Production impl
    /// evaluators of a single query via `Arc::clone`), so threads racing to fill
            // Avoids the Vec/sort allocation in the common single-leaf case.
        assert_eq!(got, vec![0u32, 3, 7]);
        page_pruner: Arc<PagePruner>,
        residual_expr: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
                    format!(
                    batch_len,
        // the expensive FFM collector call. Uses the IO runtime handle from
    /// rowset — pushdown would drop rows and misalign. In
//! runs. Per RG:
    /// Empty when the query has no performance-delegated leaves. Populated by
        min_doc: i32,
    }
                .map(|sel| {
        let got: Vec<u32> = prefetched.candidates.iter().collect();
                }
    /// Builds the per-RG delegated-backend collector when the gate fires. Production
            &collector_mask,
                };
        let eval = SingleCollectorEvaluator::new(
//!
        }
    pub metadata: Arc<ParquetMetaData>,
                        })?;
            0,
            Some(collector),
        let eval = SingleCollectorEvaluator::new(
        assert!(eval.prefetch_rg(&rg0, 0, 8).unwrap().is_some());
            first_row: 8,
            let mut words = vec![0u64; (span + 63) / 64];
            docs: vec![0, 3, 7],
            CollectorCallStrategy::FullRange,
        let rg = RowGroupInfo {
        };
    ///   returns `None` (nothing left to do).
            HashMap::new(),
        // With no pruning predicates, the evaluator is a pass-through for
        let collector = Arc::new(StubCollector {
            Arc::new(FfmDelegatedBackendCollectorFactory),
    /// present) to trigger the stream's alignment guard in block
            ]))],
        );
                just_initialized = true;
//! 4. `on_batch_mask` returns `None` — DataFusion's
        max_doc: i32,
            // let peer_card = peer_bm.len();
    #[test]
            PositionMap::Bitmap { .. } => BooleanArray::new(
    pub rg_bloom_pruned: Option<datafusion::physical_plan::metrics::Count>,
            let result = collector
/// Per-RG state the evaluator keeps for refinement. In row-granular
        // an RG's start (== previous RG's exclusive max_doc) must NOT be dropped.
                if let Some(ref c) = bloom.rg_bloom_pruned {
                        && (src_bytes[rg_pos >> 3] >> (rg_pos & 7)) & 1 == 1;
        let prefetched = eval
/// `on_batch_mask` and `build_mask` build zero-copy `BooleanBuffer`
//!    residual predicates during decode, so indices stay aligned and no
            .unwrap()
    /// flips the stream's `alignment_risk` computation which
            pruner,
                        &bloom.object_path,
            page_prune_metrics,
            min_doc: i32,
        );
//!    `with_predicate(residual).with_pushdown_filters(true)` applies the
            None,
            None,
                peer_bm.remove_range(upper..);
            None,
        let prefetched = eval
            min_doc: i32,
            let upper = offset.saturating_add(num_docs);
            .expect("should have matches");
        let file = tmp.reopen().unwrap();
        let rg1 = RowGroupInfo {
        let t = Instant::now();
            num_rows: 8,
/// Length of the underlying buffer covers `mask_len` bits (= rg_num_rows).
        assert!(eval.prefetch_rg(&rg, 0, 8).unwrap().is_none());
    /// the bitset the trait contract requires.
        Ok(Some(PrefetchedRg {
        let collector_mask: BooleanArray = match position_map {
            last_next_doc: std::sync::atomic::AtomicI32::new(i32::MIN),
                    batch_offset,
            Arc::new(FfmDelegatedBackendCollectorFactory),
    /// must be OFF in **block-granular mode** because we use
/// to Java via FFM to build a Lucene-backed collector.
        };
    impl RowGroupDocsCollector for StubCollector {
            && should_consult_lucene(&page_ranges, rg, HARDCODED_SELECTIVITY_THRESHOLD)
/// collectors are built inside this evaluator while correctness collectors are built
            0,
            index: 0,
                        out[i >> 6] |= 1u64 << (i & 63);
        // (it's the only post-decode filter we have on this path).
                // a later sub-range skips/tightens on the position the iterator has
//! When the filter has exactly one `index_filter(...)` call AND'd with
                        Some(r) if r.is_empty() => return Ok(None),
                        e
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int32, false)]));
pub struct SingleCollectorEvaluator {
    ///
        let pm = PositionMap::from_selection(
                        Some(r) => r.clone(),
                        &bloom.arrow_schema,
            0,
            return Ok(None);
                    // against a stale/sentinel next_doc dragging it backward.
                .expect("performance_provider_locks is non-empty (just checked)");
        };
pub trait DelegatedBackendCollectorFactory: Send + Sync + std::fmt::Debug {
    #[test]
            None,
        assert_eq!(pf1.candidates.iter().collect::<Vec<_>>(), vec![0u32]); // doc 8 at RG-relative pos 0
use std::sync::Arc;
    writer_generation: i64,
            first_row: 0,
            .prefetch_rg(&rg, 0, 8)
            None,
                    ));
            0,
                        rg.index
    /// Next matching docId from the last collectDocs call. When next_doc >= rg.max_doc,
            index: 0,
            Some(collector),
            None,
use crate::indexed_table::ffm_callbacks::{create_provider, FfmSegmentCollector, ProviderHandle};
        }
            let lock = self
            CollectorCallStrategy::FullRange,
    }
            0,
/// mode parquet narrowed fully via `with_predicate` + `RowSelection`
        // Empty position map is fine; SingleCollectorEvaluator ignores it.
        let eval = SingleCollectorEvaluator::new(
            num_rows: 8,
        let rg = RowGroupInfo {
            CollectorCallStrategy::FullRange,
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
                        format!(
    /// the query has only performance-delegated leaves (no peer call required
            Some(Arc::new(spt)),
        // All paths produce a `BooleanArray` whose underlying
                std::slice::from_raw_parts(
        let prefetched = eval.prefetch_rg(&rg, 0, 8).unwrap().expect("has matches");
        // the collector bitmap: every doc the collector returns remains a
                    }
        let pf = eval.prefetch_rg(&rg1, 4, 8).unwrap().expect("has match");
            for &doc in &self.docs {
            return Ok(None);
                                "collector.collect_packed_u64_bitset(rg={}, [{}, {})): {}",
                    };
/// `context_id` is the per-query identifier passed through to every FFM upcall so Java
        let options = ArrowReaderOptions::new().with_page_index(true);
                next_doc: self.next_doc,
    #[test]
            Ok(bitset.into())
            None,
        false
    /// the factory at query setup; lookups + `OnceLock` init happen ONLY when
        let pruner = minimal_page_pruner();
            doc_max,
                .map_err(|e| {
        // would have unioned with page-pruner-derived "anything-allowed"
        bloom_config: Option<BloomConfig>,
            None,
            0,
        let pruner = minimal_page_pruner();
        provider_key: i32,
                    let mut rg_pos: i64 = 0;
            index: 0,
                        &bloom.metadata,
            None,
        Some(ranges) => ranges.iter().map(|(lo, hi)| (hi - lo) as i64).sum::<i64>(),
        );
    struct NextDocCollector {
            }
        rg_state: &dyn std::any::Any,
    /// Reverse map: absolute RG index → position in `rg_can_match` vectors.
                        .collect_packed_u64_bitset(effective_min, *r_max)
///
        }
        );
    /// a slot do so once per (query × annotation_id) — not per chunk.
            .prefetch_rg(&rg, 0, 8)
            CollectorCallStrategy::FullRange,
        let page_ranges: Option<Vec<(i32, i32)>> = self.pruning_predicate.as_ref().and_then(|pp| {
                        &*bloom.store,
            for &doc in &self.docs {
            writer.close().unwrap();
        let collector = Arc::new(StubCollector {
            None,
            .prefetch_rg(&rg0, 0, 8)
/// in pre-built by `indexed_executor.rs`. Today delegated-backend (perf-delegated)
            max_doc: i32,
use datafusion::physical_optimizer::pruning::PruningPredicate;
            // Per-RG debug log — `format!` runs unconditionally regardless of log level
    }
            writer_generation,
        let pruner = minimal_page_pruner();
            num_rows: 8,
        return false;
//! 2. Apply page pruning (AND/OR mode depending on how the query combined them).
    /// Stream's `current_mask` construction consults this. When
            // Identity: delivered row i == rg_position (batch_offset + i).
            bloom_config,
pub struct FfmDelegatedBackendCollectorFactory;
}
                        "SingleCollector: skipping RG {} — pruned by RG-level stats",
                    words[idx / 64] |= 1u64 << (idx % 64);
            Some(collector),
    fn stats_prune_tree_none_does_not_prune() {
                let mut next_doc_out = last_next;
    /// suppresses pushdown in block-granular mode. In row-granular
        );
        context_id: i64,
        let rg = RowGroupInfo {
            None,
    fn stats_prune_tree_allows_rg_when_true() {
        let mut candidates = match self.collector.as_ref() {
    rg_index_to_pos: HashMap<usize, usize>,
                if doc >= min_doc && doc < max_doc {
        let rg0 = RowGroupInfo {
            pruner,
    /// residual is set, we return `true` so the stream knows our
            first_row: 0,
    delegated_backend_collector_factory: Arc<dyn DelegatedBackendCollectorFactory>,
use super::{PrefetchedRg, RowGroupBitsetSource};
                    // Read bit rg_pos from the packed buffer (LSB-first).
            None,
    /// `RowGroupInfo` (which doesn't carry it).
            None,
            index: 2,
                .prune_rg(pp, rg.index, self.page_prune_metrics.as_ref())
            CollectorCallStrategy::FullRange,
            pruning_predicate,
    /// `PositionMap` to look up RG positions over the full delivered
        // Evaluate residual against the batch.
            let collector = self
        );
            Arc::new(HashMap::new()),
        let collector = Arc::new(NextDocCollector {
            None,
        }))
        assert_eq!(pf.candidates.iter().collect::<Vec<_>>(), vec![1u32]); // doc 5 is at RG-relative pos 1
            // per-RG allocation. Re-enable locally for debugging.
            HashMap::new(),
        }
            num_rows: 8,
                    .store(next_doc_out, std::sync::atomic::Ordering::Release);
/// might narrow further); "skip" when DF already squeezed it below threshold
            0,
            None,
    /// `on_batch_mask` uses PositionMap (alignment risk) — this flag
        )
                let mut bm = RoaringBitmap::new();
            Arc::new(HashMap::new()),
        collector: Option<Arc<dyn RowGroupDocsCollector>>,
}
                            rg_pos += s.row_count as i64;
            .unwrap()
                            )
    #[test]
            Some(collector),
        // need; they construct zero-copy `BooleanBuffer` views via
                    let result = collector
                None,
            })
        // universe. Performance leaves are AND'd in below if the selectivity gate fires.
    ffm_collector_calls: Option<datafusion::physical_plan::metrics::Count>,
pub struct BloomConfig {
                        }
    struct StubCollector {
                        None => vec![(min_doc, max_doc)],
            Arc::new(HashMap::new()),
        // RG2: NOT skipped (next_doc=20 < max_doc=24)
                let mut bm = RoaringBitmap::new();
            // Pick the smallest annotation_id deterministically so logs/tests are stable.
                bm
    }
                    )
                        provider.key(),
            None => {
    #[derive(Debug)]
                        Some(r) if r.is_empty() => return Ok(None),
            if let Some(ref c) = self.ffm_collector_calls {
    /// `FfmSegmentCollector` lazily without re-deriving the segment from
//! (possibly zero, one, or many) parquet-native predicates, this evaluator
    /// Raw residual expression (non-Collector children of the top-level
};
                        rg.index, min_doc, max_doc, e
    threshold: f64,
        // row IDs — semantics that were never wired up in production.)
                match &page_ranges {
        .map_err(|e| format!("SingleCollectorEvaluator: and_kleene: {}", e))?;
                );
            .unwrap()
                        let mut allowed = RoaringBitmap::new();
                        c.add(1);
                })?;
            let pruned =
        }) as Arc<dyn RowGroupDocsCollector>;
        {
        batch_len: usize,
                    if upper < u32::MAX {
        call_strategy: CollectorCallStrategy,
    }
                    })?;
        doc_max: i32,
        };
    pub arrow_schema: Arc<datafusion::arrow::datatypes::Schema>,
#[cfg(test)]
impl DelegatedBackendCollectorFactory for FfmDelegatedBackendCollectorFactory {
                    }
        // max(5, 4) = 5, not 4.
        )
                rg.index,
        let eval = SingleCollectorEvaluator::new(
    fn on_batch_mask_returns_none_for_path_b() {
        Ok(Arc::new(collector) as Arc<dyn RowGroupDocsCollector>)
    page_ranges: &Option<Vec<(i32, i32)>>,
/// `BitsetMode::Or` branch that previously existed was never emitted by
            CollectorCallStrategy::FullRange,
        // SingleCollectorEvaluator returns None from on_batch_mask, so
                .map_err(|e| {
use std::time::Instant;
    let surviving_fraction = surviving_rows as f64 / rg.num_rows as f64;
        // RG0 [0,4): doc 1 matches
                .expect("annotation_id was just pulled from the map's keys");
            num_rows: 8,
/*
            first_row: 0,
            index: 0,
            None,
/// Per-RG decision: should we consult the peer backend?
        // Opportunistic peer consultation for performance-delegated leaves. Only fires
    ///
            None,
            schema.clone(),
                    }
                    if next_doc_out >= *r_max {
            None,
            None,
    fn single_collector_needs_row_mask() {
        let meta = ArrowReaderMetadata::load(&file, options).unwrap();
        // (filter_row_ids returns input, candidate_row_ids returns [first_row, first_row+num_rows)).
            None,
    /// Incremented once per `prefetch_rg` call (once per RG) — the
        };
                    }
                    if let Some(ref ranges) = page_ranges {
            let _timer = bloom.bloom_filter_eval_time.as_ref().map(|t| t.timer());
            next_doc: 8,
                .delegated_backend_collector_factory
        let pruner = minimal_page_pruner();
                )
                            let abs_max = min_doc + rg_pos as i32 + s.row_count as i32;
///
            Some(collector) => {
                .collect_packed_u64_bitset(min_doc, max_doc)
            None,
            index: 0,
        .unwrap();
            Arc::new(HashMap::new()),
        let tmp = NamedTempFile::new().unwrap();
use crate::indexed_table::index::{CollectDocsResult, RowGroupDocsCollector};
        // bitsets. Today we consult the first leaf only — sufficient for AND-only
            let offset = (min_doc as i64 - rg.first_row) as u32;
            None,
        );
                        self.writer_generation,
                            let lo = (*r_min as i64 - rg.first_row) as u32;
use crate::indexed_table::page_pruner::{PagePruneMetrics, PagePruner, StatsPruneTree};
            CollectorCallStrategy::FullRange,
            }
        }) as Arc<dyn RowGroupDocsCollector>;
