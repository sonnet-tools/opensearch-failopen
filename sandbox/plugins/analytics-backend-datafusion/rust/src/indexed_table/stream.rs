        };
            call_count: AtomicUsize::new(0),
use std::sync::Arc;
    /// we handed to parquet.
            _rg_first_row: i64,
                    // evaluator's `on_batch_mask` will look up positions
    current_stream: Option<SendableRecordBatchStream>,
                current
use datafusion::physical_plan::coalesce::{LimitedBatchCoalescer, PushBatchStatus};
                        // page-level pruning). `rg.num_rows - matched`.
        match result.unwrap() {
            }
        store_url: datafusion::execution::object_store::ObjectStoreUrl,
                    Err(e) => return Poll::Ready(Err(DataFusionError::External(e.into()))),
                base: self.global_base + self.current_rg_first_row as u64,
                    // there's no safety net if pushdown misbehaves on a
use futures::{Future, Stream};
        }
    /// will arrive; drain remaining completed batches."
                        }
                self.current_mask.as_ref(),
        let t_proj = Instant::now();
                    // understanding per-query memory profiles.
                            Ok(b) => b,
    pub index: usize,
            Self::fetch_row_group(
        row_groups: Vec<RowGroupInfo>,
use super::row_selection::{build_mask, build_row_selection_with_min_skip_run, PositionMap};
            None => {
            }
        store: Arc<dyn object_store::ObjectStore>,
        self.schema.clone()
    impl RowGroupBitsetSource for SpinningEvaluator {
                            // only if the evaluator consumes it.
        object_path: object_store::path::Path,
    dynamic_prune_ctx: Option<super::dynamic_filter::RgPruningContext>,
        // ANALYZE, separate from `index_time` / `parquet_time` which
            return Err("query cancelled".to_string());
        write!(
        );
                    let t_plan = Instant::now();
            self.query_config.min_skip_run_selectivity_threshold,
//!
                            }
                            c.add(1);
        let result = tokio::time::timeout(Duration::from_millis(500), handle).await;
                };
                        self.pick_min_skip_run(candidates.len() as usize, rg.num_rows as usize);
    async fn test_panic_in_prefetch_returns_error_not_hang() {
                );
                            ))));
        index_reader: IndexReader,
        result
        let mut min_doc = rg.first_row as i32;
                if let Some(result) = poll_result {
                    Poll::Ready(Ok(result)) => {
                return Ok(PrefetchOutcome::Pruned);
        let row_id_ctx = if self.row_id_output_index.is_some() {
                    }
    /// Count of RGs skipped at prefetch time (before the Lucene eval).
                            Ok(PushBatchStatus::Continue) => continue,
    fn schema(&self) -> SchemaRef {
    /// `next_completed_batch`.
            //    coalescer yet, finish it so it flushes its final buffered
        let cancelled_err = Arc::new(AtomicBool::new(false));
            self.query_config.batch_size,
                    if let Some(ref counter) = self.metrics.rows_matched {
            if let Some(result) = self.cached_result.take() {
//! Unified streaming execution for indexed parquet reads.
    /// polled (and returned Pending). Used to attribute wait time when
                        return Poll::Pending;
/*
            push_predicate,
    /// Force row-granular selection (`min_skip_run = 1`).
                        t.add_duration(t_filter.elapsed());
    current_mask: Option<BooleanArray>,
        dynamic_filter_rg_pruned_at_prefetch: Option<datafusion::physical_plan::metrics::Count>,
    pending_since: Option<Instant>,
            // Produce a non-empty candidate set so the RG is "Fetched".
            &self,
    fn poll_next(mut self: Pin<&mut Self>, cx: &mut Context<'_>) -> Poll<Option<Self::Item>> {
                    "[scf-segment-done] file={} row_groups={} elapsed={:?}",
            }
                return Poll::Ready(Some(Ok(batch)));
            PositionMap::from_selection(&RowSelection::from(Vec::<RowSelector>::new()));
                        self.current_rg_context = None;
            }
//!
                            // violation). Propagate immediately — retrying would
                    self.current_rg_context = Some(prefetched.prefetched.context);
        tokio::time::sleep(Duration::from_millis(250)).await;
                                        // through PositionMap.
            _max_doc: i32,
                    return;
                        counter.add(candidates.len() as usize);
    }
                        // The spawn_blocking task failed to complete.
            candidates.insert_range(0..rg.num_rows as u32);
                token.as_ref(),
            &self,
                                        );
    /// Per-RG map from delivered batch-row index to RG-relative position.
                    // OFF; the evaluator applies the residual
        evaluator: &Arc<dyn RowGroupBitsetSource>,
                        let pruner = self.dynamic_rg_pruner.as_mut().unwrap();
        if !self.initialized {
        if let Some(ref t) = self.metrics.elapsed_compute {
            self.stream_metrics.prefetch_wait_time.clone(),
    }
        let selectivity = num_candidates as f64 / rg_num_rows as f64;
                "invariant violation: DelegationPossible reached subtree_cost. \
                mask_offset_before,
        let rg_state: &dyn std::any::Any = match &self.current_rg_context {
                    let rg = prefetched.rg;
    /// than `min_skip_run_default` (block-granular).
            full_schema,
            selection,
                        }
            file_size,
            self.object_path.clone(),
                    match &r {
                        self.cached_result = Some(result);
                let filtered = filter_record_batch(&batch, &mask)
                            t.add_duration(t0.elapsed());
        }
                            }
        Self {
    use std::sync::atomic::{AtomicBool, AtomicUsize, Ordering};
                        }
    /// receiver — idle wall-clock attributable to slow Lucene.
            _batch: &RecordBatch,
            "expected early termination, but all row groups were evaluated ({})",
            metrics,
                            self.current_stream = Some(stream);
                        // Task was cancelled (runtime shutting down) — retry once
                            // loop forever and hang the calling Java thread.
                    }
            }
            })
            // Lucene eval) using the filter's tightening so far.
                batch_len,
        //
    /// Take one parquet-delivered batch, apply candidate + refinement
    pub(crate) dynamic_filter: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
                    // alignment/forbid checks below.
    /// Time the poll thread spent in `Poll::Pending` on the prefetch
    /// counting how many row groups it actually evaluated.
    /// cloned from the stream's `PartitionMetrics`.
        emit_row_ids: bool,
                .await;
    // async tasks at `.await` points. The tests below verify that the cancellation
        _context: Arc<datafusion::execution::TaskContext>,
                rg,
                // Upstream fully consumed; let the coalescer flush.
            global_base,
                    "[scf-segment-done] file={} row_groups={} elapsed={:?}",
                    // with the decode. Delivered rows = candidate ∧
    /// masks, strip predicate columns to match output schema, and return
    batch_coalescer: LimitedBatchCoalescer,
                        cancelled_err_drv.store(true, Ordering::SeqCst);
                }
                            self.current_inner_plan = Some(plan);
        // reader terminated via the cancellation Err path.
        "IndexedExec"
use super::metrics::StreamMetrics;
            vec![rg_info],
        selection: RowSelection,
                // Yield to let spawn_blocking complete
        let mut reader = IndexReader::new(
    struct SpinningEvaluator {
            _rg_first_row: i64,
                                    t.add_duration(t_build.elapsed());
                        self.pending_prefetch = None;
            // 1. Drain any completed batch from the coalescer first.
    mask_offset: usize,
                    let position_map = PositionMap::from_candidates_with_selection(
        }
        let driver = tokio::spawn(async move {
                    t.add_duration(t_filter.elapsed());
                }
    /// When true, the `___row_id` column is computed from position.
    ) -> Poll<std::result::Result<Option<PrefetchedRowGroup>, DataFusionError>> {
        }
                    // `with_predicate` applies the residual in lockstep
            first_row: 0,
            Arc::clone(&self.metadata),
            }
            }
    /// prefetch-phase prune counter rather than `rg_skipped`.
                    // `current_mask` over delivered rows, or the
                    self.current_rg_first_row = rg.first_row;
                // Unreachable in practice — step 1 already drained or
                        min_skip_run,
                    let mask_slice = mask_slice
            self.doc_range,
                    if let Some(ref counter) = self.metrics.rg_processed {
    fn metrics(&self) -> Option<MetricsSet> {
    /// batches (matching FilterExec's behaviour). Post-filter batches
    /// Index in the output schema where computed `___row_id` is inserted.
                    // landed in. Useful for tuning min_skip_run and
    }
            self.query_config.min_skip_run_default,
            predicate: self.predicate.clone(),
    #[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    pub(crate) store: Arc<dyn object_store::ObjectStore>,
    rg: RowGroupInfo,
//! `filter_record_batch`. If it returns `None` (single-collector path:
    }
                    );
            if ctx.rg_provably_excluded(metadata, rg.index) {
}
                        continue;
    /// RG excluded by the dynamic filter at prefetch time, before the Lucene
                    self.object_path.filename().unwrap_or("?"),
                continue;
                    Poll::Ready(Ok(None)) => Poll::Ready(true),
                    let min_skip_run =
            Some(super::row_id_injection::RowIdContext {
pub enum FilterStrategy {
impl IndexReader {
            // If coalescer is finished but wasn't drained in step 1, the
    pub(crate) projection: Option<Vec<usize>>,
        // cancelled after this blocking job was queued but before it started.
    ) -> Result<(SendableRecordBatchStream, Arc<dyn ExecutionPlan>)> {
        metadata: Arc<ParquetMetaData>,
                                } else {
                            continue;
    min_skip_run_selectivity_threshold: f64,
                                .or_else(|| payload.downcast_ref::<&str>().map(|s| s.to_string()))
                        }
                        // RG excluded by the dynamic filter before the Lucene
                    Poll::Pending => Poll::Ready(false),
        prefetch_wait_time: Option<datafusion::physical_plan::metrics::Time>,
    /// When true, the `___row_id` column is computed from position instead of read.
    ) -> std::result::Result<PrefetchOutcome, String> {
        // Sanity: it did NOT run all 8 row groups.
                    Poll::Pending => return Poll::Pending,
    }
                std::hint::spin_loop();
            _position_map: &PositionMap,
use std::task::{Context, Poll};
        if selectivity < self.min_skip_run_selectivity_threshold {
                &ctx,
    pub(crate) metrics: ExecutionPlanMetricsSet,
                    self.index_reader.row_groups.len(),
}
        schema: SchemaRef,
        };
                    let t_filter = Instant::now();
                        &selection,
                    counter.add(1);
        target_batch_size: usize,
        let evaluator = {
        let index_reader = IndexReader::new(
    /// Otherwise the choice is selectivity-driven: at low selectivity every gap
                    vec![],
    /// Upstream delivered `None` (all RGs consumed). We still need to
            t.add_duration(t_on_batch.elapsed());
        if rg_idx >= self.row_groups.len() {
                }
        }
            self.projection.clone(),
            store_url,
        RowGroupStreamConfig {
        };
        }
            None,
    impl RowGroupBitsetSource for PanickingEvaluator {
            index_reader,
        if let Some(ref t) = self.metrics.on_batch_mask_time {
        let cancelled_err_drv = cancelled_err.clone();
            // prefetch tasks, so the next prefetch can prune (skipping the
                                    }
                        }
    fn properties(&self) -> &Arc<PlanProperties> {
            // top-of-loop `is_empty` check ends it on the next turn.
                    "query cancelled".to_string(),
//!
            }
            )?
                                        // delivered row i == RG position i. Wrap
                    let alignment_risk = min_skip_run != 1 && self.evaluator.needs_row_mask();
/// Streams RGs one at a time with prefetch overlap.
};
                ))));
    /// Parquet metadata for this segment — needed to evaluate a dynamic-filter
type PrefetchHandle = JoinHandle<PrefetchResult>;
    /// Query-scoped tunables. Shared by Arc across IndexedExec instances
            })),
    }
        indexed_pushdown_filters: bool,
                log_debug!(
                            }
            // Poll current stream
                    let r = reader.poll_next_row_group(cx);
        Ok(Box::pin(IndexedStream::new(
                position_map,
                    }
            result.is_ok(),
                prune,
    /// eval ran. Attributed to `dynamic_filter_rg_pruned_at_prefetch`.
        _children: Vec<Arc<dyn ExecutionPlan>>,
        let batch_coalescer = LimitedBatchCoalescer::new(schema.clone(), target_batch_size, None);
                self.batch_offset += batch_len;
    /// Per-RG `min_skip_run` decision.
    type Item = Result<RecordBatch>;
            total_evaluated
    last_poll_end: Option<Instant>,
        }
            None,
                    if let Some(ref t) = self.metrics.mask_slice_time {
    /// only path in production; tests may pin it via `force_strategy`).
    prefetched: PrefetchedRg,
    /// Output coalescer — combines small post-filter batches up to
                                    self.coalescer_finished = true;
            store: Arc::clone(&self.store),
        ) -> Result<Option<PrefetchedRg>, String> {
struct IndexedStream {
            self.full_schema.clone(),
    }
                        self.current_position_map = None;
    doc_range: Option<(i32, i32)>,
        let rgs_evaluated = Arc::new(AtomicUsize::new(0));
    pub(crate) predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        // Inject computed __row_id__, or reorder/strip columns to match output schema.
            if self.coalescer_finished {
                    // BitmapTreeEvaluator because its `on_batch_mask`
                    if let Some(ref t) = self.metrics.filter_record_batch_time {
                        if let Some(ref t) = self.metrics.coalesce_time {
            self.emit_row_ids,
            if self.finished {
#[derive(Debug, Clone)]
                        std::task::Poll::Ready(v) => std::task::Poll::Ready(Some(
                    self.stream_start.unwrap().elapsed()
//! - While that's running, `IndexedStream` polls the current RG's parquet
    #[tokio::test(flavor = "multi_thread", worker_threads = 4)]
            Some(FilterStrategy::RowSelection) => return 1,
        let evaluator = Arc::clone(&index_reader.evaluator);
        fn prefetch_rg(
                    &datafusion::arrow::record_batch::RecordBatchOptions::new()
use datafusion::parquet::arrow::arrow_reader::{RowSelection, RowSelector};
        let rg_info = RowGroupInfo {
    /// Node-wide default from the `datafusion.indexed.pushdown_filters`
        doc_range: Option<(i32, i32)>,
                        self.start_prefetch(self.current_rg_idx);
                    // uses PositionMap on Collector leaves regardless of
                                        build_mask(&candidates, &position_map)
                    // `forbid_parquet_pushdown()` is a blanket opt-out
        assert!(
                    // have tightened further since this RG was prefetched (~1 RG
                    Poll::Ready(Some(Ok(batch))) if batch.num_rows() > 0 => {
        }
                self.batch_offset += batch_len;
        }
        });
                return Poll::Ready(None);
use native_bridge_common::log_debug;
            return;
                                        // runs, so delivered rows don't map 1:1
        // Manual timer for `elapsed_compute`: total wall time spent
                    // Node-wide `indexed_pushdown_filters` setting, gated by
                        self.pending_since = None;
            if self.index_reader.is_cancelled() {
            &self.bridge_config(),
            None => Ok(PrefetchOutcome::Empty),
        cancellation_token: Option<tokio_util::sync::CancellationToken>,
                tokio::time::sleep(Duration::from_millis(10)).await;
                        }
                    // Carried through to finalize_batch so the multi-filter
    ) -> Poll<Option<Result<RecordBatch>>> {
    global_base: u64,
            }
        predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
            if self.is_cancelled() {
            }
        min_skip_run_selectivity_threshold: f64,
                output.project(&indices)?
/// Backed by the `datafusion.indexed.force_strategy` cluster setting (wire
                    // Metrics: track which regime we landed in, using the
            _rg_state: &dyn std::any::Any,
    evaluator: Arc<dyn RowGroupBitsetSource>,
                .await;
    /// cluster setting.
        }
            index: 0,
}
                return Ok(PrefetchOutcome::Empty);
    /// Verifies that when `prefetch_rg` panics (simulating the subtree_cost
                    }
                                    if let Err(e) = self.batch_coalescer.finish() {
            let mask_offset_before = self.mask_offset.saturating_sub(batch_len);
    /// path to access per-leaf bitmaps keyed by `Arc::as_ptr` identity).
    force_strategy: Option<FilterStrategy>,
                            c.add(1);
            prefetch_wait_count,
            _min_doc: i32,
        cx: &mut Context<'_>,
        rgs_evaluated: Arc<AtomicUsize>,
// ── IndexedExec ──────────────────────────────────────────────────────
                    // row-granular regime) and build_mask without cloning
    dynamic_rg_pruner: Option<super::dynamic_filter::DynamicRgPruner>,
    pub(crate) metadata: Arc<ParquetMetaData>,
    #[inline]
            .evaluator
    row_id_output_index: Option<usize>,
                                c.add(1);
            _batch_offset: usize,
    fn poll_next_row_group(
    /// calling it twice (assert panic) and to signal "no more input
    ) -> Result<SendableRecordBatchStream> {
            )
            guard
                }
                            Err(e) => return Poll::Ready(Some(Err(e))),
    initialized: bool,
                    // UDF-containing predicate.
            self.seg_arrow_schema.clone(),
        self: Arc<Self>,
            metadata,
    }
                    // stays comparable.
                    .map(|f| output.schema().index_of(f.name()).unwrap_or(0))
            let gap = poll_start.saturating_duration_since(prev_end);
                // step 2 already returned. Defensive.
    /// Per-query cancellation token. Checked before each row group is dispatched
            match self.index_reader.poll_next_row_group(cx) {
                    // ahead). Re-check against the latest snapshot; skip the
            }
    fn finalize_batch(&mut self, batch: RecordBatch) -> Result<RecordBatch> {
        if rg_idx >= row_groups.len() {
            mask_offset: 0,
                .ok_or_else(|| DataFusionError::Internal("evaluator already consumed".into()))?
    /// `None` disables cancellation checks.
            None
    pub(crate) evaluator: std::sync::Mutex<Option<Arc<dyn RowGroupBitsetSource>>>,
                        }
    evaluator: Arc<dyn RowGroupBitsetSource>,
            row_groups,
            dynamic_rg_pruner,
                    Poll::Ready(None) => {
        tokio::time::timeout(Duration::from_secs(10), driver)
                        && !self.evaluator.forbid_parquet_pushdown();
                            // so the mask would be all-true — skip building
                                None
                    }
        let result = self.as_mut().poll_inner(cx);
    indexed_pushdown_filters: bool,
        cx: &mut Context<'_>,
            // Refresh the dynamic-filter snapshot the IndexReader hands to its
            Ok(Ok(_)) => panic!("Stream should return Err when prefetch panics, got Ok"),
        //   (B) `on_batch_mask` returns None (single-collector path). Use
                                continue;
            if let Some(ref mut pruner) = self.dynamic_rg_pruner {
                self.current_rg_idx += 1;
    pub(crate) cancellation_token: Option<tokio_util::sync::CancellationToken>,
        // Drive the reader exactly like IndexedStream does. Records whether the
            if let Some(ref mut stream) = self.current_stream {
    store: Arc<dyn object_store::ObjectStore>,
                let current = if let Some(ref mask) = self.current_mask {
        let evaluator = Arc::new(SpinningEvaluator {
                    if min_skip_run == 1 {
                                let m = if let Some(buf) = prefetch_mask_buffer.as_ref() {
                        }
    /// parquet statistics cannot satisfy the (tightening) predicate. `None`
        //       answer — apply `m` exclusively. Any `current_mask` from
                                        // Block-granular: RowSelection has skip
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
    cached_result: Option<PrefetchResult>,
            let ctx = row_id_ctx.unwrap();
            min_doc = min_doc.max(range_min);
}
                        };
                }
    current_rg_first_row: i64,
                            self.pending_since = Some(Instant::now());
                )?
    min_skip_run_default: usize,
                    let filtered = filter_record_batch(&batch, mask_slice)
                        }
                if let Some(ref counter) = self.metrics.output_rows {
    /// was pushed. Owns its own snapshot generation tracking, so it must NOT be
            _rg_state: &dyn std::any::Any,
        self.pending_prefetch = Some(handle);
//! the batch as-is.
    metrics: StreamMetrics,
        row_id_output_index: Option<usize>,
    fn create_row_selection_stream(
        )))
                    .fields()
    pub(crate) query_config: Arc<DatafusionQueryConfig>,
                        .with_row_count(Some(output.num_rows())),
            .map_err(|e| DataFusionError::External(e.into()))?;
                );
    }
        //       pushdown if that's None too).
            //    batch. Loop to drain via next_completed_batch().
            None,
                            }
                        self.current_mask = None;
 * The OpenSearch Contributors require contributions made to
            self.predicate.is_some(),
        // complete after cancel; all others must be skipped by the checkpoint.
        let token = tokio_util::sync::CancellationToken::new();
                        if let Some(ref c) = self.rg_skipped {
    /// call `finish()` on the coalescer and drain it before returning
            .on_batch_mask(
    /// shared across sibling segment streams.
                        if let Some(started) = self.pending_since.take() {
                batch_offset: self.batch_offset,
        let handle = tokio::task::spawn_blocking(move || {
                batch_len,
                tokio::time::sleep(Duration::from_millis(50)).await;
                        .expect("BooleanArray.slice must remain BooleanArray");
            projection,
                        if filtered.num_rows() == 0 {
                    // parquet decode if now provably excluded. Conservative:
            }
            if let Some(ref mut rx) = self.pending_prefetch {
    /// cluster setting) it pins the choice to either extreme (`RowSelection` → 1,
                        // JoinError distinguishes panic from cancellation.
            if let Some(batch) = self.batch_coalescer.next_completed_batch() {
            schema,
        self.last_poll_end = Some(t0);
                    }
                    self.mask_offset += batch_len;
        // We need to yield between polls because start_prefetch returns Pending
            _ => None,
            // 4. Pull the next filtered batch from upstream (parquet stream
            self.file_size,
impl DisplayAs for IndexedExec {
                        return Poll::Pending;
                    );
    fn pick_min_skip_run(&self, num_candidates: usize, rg_num_rows: usize) -> usize {
                            let panic_msg = payload
    dynamic_filter_rg_pruned_at_prefetch: Option<datafusion::physical_plan::metrics::Count>,
    pub(crate) schema: SchemaRef,
    pub(crate) file_size: u64,
        // Let a couple of row groups start evaluating, then cancel.
        self.start_prefetch(0);
                    // Pushdown decision:
                let poll_result = Pin::new(stream).poll_next(cx);
            current_rg_first_row: 0,
            Some(FilterStrategy::BooleanMask) => return rg_num_rows + 1,
                            counter.add(1);
            self.predicate.clone(),
    /// Counted once per RG whose prefetch returned `None` (candidate
    ) -> Self {
                    }
    prefetch_wait_time: Option<datafusion::physical_plan::metrics::Time>,
                                .cloned()
                        // dropped (either via Collector intersection or
            }
                    }
                Poll::Ready(Err(e)) => return Poll::Ready(Some(Err(e))),
                }
    pending_prefetch: Option<PrefetchHandle>,
        });
        let batch_len = batch.num_rows();
        row_groups: &[RowGroupInfo],
        // differ from the table schema order (e.g. when infer_schema sorted alphabetically).
                                c.add(1);
                .clone()
                self.coalescer_finished = true;
                        &candidates,
                                        // the pre-built packed bits as BooleanArray
        cancellation_token: Option<&tokio_util::sync::CancellationToken>,
                    // per-RG state.
        min_skip_run_default: usize,
                            // Under row-granular (min_skip_run == 1) every
                if let Err(e) = self.batch_coalescer.finish() {
                    self.finished = true;
use super::parquet_bridge::{self, RowGroupStreamConfig};
            _min_doc: i32,
                t.add_duration(t0.elapsed());
    pub(crate) row_id_output_index: Option<usize>,
                        let filtered = match self.as_mut().finalize_batch(batch) {
                            }
    /// noisy short gaps would explode the selector Vec, so absorb anything shorter
        Self {
                                "prefetch for row group {} panicked: {}",
        }
                        }
                            } else if self.evaluator.needs_row_mask() {
        }
    store_url: datafusion::execution::object_store::ObjectStoreUrl,
                        // Stream finished — collect inner parquet metrics
                                self.upstream_done = true;
                            // it. Under block/full regimes, build the mask
            // Stop draining on cancellation; surfaces as a query-level error (no partial results).
struct IndexReader {
            t.add_duration(t0.saturating_duration_since(poll_start));
use datafusion::arrow::record_batch::RecordBatch;
    }
        }
        if let Some((range_min, range_max)) = doc_range {
    /// `Ready(None)` ourselves.
    /// Wall-clock timestamp when the current pending prefetch was first
                prefetched,
            //    + evaluator), push into coalescer, loop.
            None,
            )
                    }
        }
                Poll::Ready(Ok(Some(prefetched))) => {
                            if let Some(ref c) = self.metrics.position_map_runs {
    fn new(
 * compatible open source license.
                                t.add_duration(started.elapsed());
    Fetched(PrefetchedRowGroup),
                    self.object_path.filename().unwrap_or("?"),
        if let Some(ref c) = self.metrics.poll_count {
                            if let Some(ref c) = self.metrics.position_map_identity {
                                c.add(1);
        fn on_batch_mask(
pub struct IndexedExec {
        });
            current_position_map: None,
                return Poll::Ready(Some(Err(DataFusionError::Execution(
    /// are fed in via `push_batch`; completed batches are drained via
                            }
                return Poll::Ready(Ok(None));
//! If `evaluator.on_batch_mask()` returns `Some(mask)`, we apply it via
            let n = self.schema.fields().len();
                                c.add(1);
            projection: self.projection.clone(),
        });
    /// Baseline `min_skip_run` used when selectivity drives the choice (the
    /// Per-query cancellation token. When cancelled, `IndexReader` stops
    }
    struct PanickingEvaluator {
            self.start_prefetch(self.current_rg_idx);
                    Ok(PrefetchOutcome::Fetched(p)) => return Poll::Ready(Ok(Some(p))),
    /// Index in the OUTPUT schema where computed `___row_id` should be inserted.
                    // Decide min_skip_run for this RG (see `pick_min_skip_run`).
    /// push_batch). Advances per-batch offsets (mask/batch) in lockstep.
                        Ok((stream, plan)) => {
            dynamic_prune_ctx: None,
                self.current_rg_first_row,
use datafusion::physical_plan::metrics::{ExecutionPlanMetricsSet, MetricsSet};
                    //
        // With the fix: should complete (not timeout) with an error
            file_size: self.file_size,
            None => {}
    /// Cancelling mid-scan stops `poll_next_row_group` from dispatching further
    current_rg_context: Option<Box<dyn Any + Send + Sync>>,
    /// and before the evaluator runs in a queued blocking job. `None` disables cancellation.
                }
                    }
            None,
        match evaluator.prefetch_rg(&rg, min_doc, max_doc)? {
        Ok(output)
            1
    /// local `usize`.
                    match &position_map {
            self.index_reader.init_prefetch();
                    let candidates = prefetched.prefetched.candidates;
// ── Prefetched Row Group ─────────────────────────────────────────────
                let t_poll = Instant::now();
                                            rg.num_rows as usize,
            Some(token.clone()),
impl RecordBatchStream for IndexedStream {
            file_path: self.object_path.to_string(),
            store_url: self.store_url.clone(),
                }
    use std::time::Duration;
        let output = match eval_mask {
    fn schema(&self) -> SchemaRef {
impl IndexedStream {
impl IndexedStream {
            prefetch_wait_time,
            "Stream should complete with error, not hang (timeout)"
        &mut self,
        // The parquet reader delivers columns in the file's physical order which may
                        if let Some(ref c) = self.metrics.parquet_batches_received {
                    }
        seg_arrow_schema: SchemaRef,
                position_map: self.current_position_map.as_ref().cloned(),
    /// Count of times we hit `Poll::Pending` on the prefetch receiver.
        );
        force_strategy: Option<FilterStrategy>,
            batch_offset: 0,
            panic!(
                        Poll::Ready(true)
            // 2. If upstream is done and coalescer has drained, we're done.
        };
    /// page pruning and dynamic filter to avoid repeated `parquet_to_arrow_schema`.
                                c.add(1);
                .io_stats
                            // Deterministic failure (e.g. subtree_cost invariant
        // without waking (the oneshot receiver isn't polled until next call).
            let deadline = Instant::now() + self.spin;
    ///
            (Some(ctx), Some(md)) => Some((ctx, Arc::clone(md))),
    #[allow(clippy::too_many_arguments)]
                        if self.pending_since.is_none() {
        //       the candidate stage is a superset; the refinement mask is
            unreachable!()
                num_rows: 100,
    /// is worth skipping (`min_skip_run = 1`, row-granular); at higher selectivity
    fn bridge_config(&self) -> RowGroupStreamConfig {
//! `Arc<dyn RowGroupBitsetSource>`; the streaming loop is identical regardless
        let poll_start = Instant::now();
            .as_ref()
            }
pub struct RowGroupInfo {
            current_stream: None,
                            self.mask_offset = 0;
    }
                    .map_err(|e| DataFusionError::ArrowError(Box::new(e), None))?;
            t.add_duration(t_proj.elapsed());
        if let Some(ref t) = self.metrics.projection_fixup_time {
            row_id_output_index,
            min_skip_run_selectivity_threshold,
            object_path,
                row_id_idx,
                        continue;
    /// pushdown, referencing the sort columns. Used to prune row groups whose
        let t0 = Instant::now();
use tokio::task::JoinHandle;
                        std::task::Poll::Pending => std::task::Poll::Ready(None),
                                        // Fast path: full-scan regime (no skips),
            None,
    fn init_prefetch(&mut self) {
            Ok(None)
                        let metadata = Arc::clone(&self.metadata);
    /// Per-stream runtime dynamic-filter pruner. `None` when no dynamic filter
                    // strategy, and because the outer FilterExec is
    /// Snapshot of the runtime dynamic filter (refreshed by the stream before
            initialized: false,
                    }
                        }
        projection: Option<Vec<usize>>,
    finished: bool,
        });
            None,
        // Lucene/FFM eval. Conservative — only skips on proof; the threshold
            total_rows,
                        }
            pending_prefetch: None,
            None,
    use super::*;
        } else {
    fn new(
    fn poll_inner(
    /// retry the same row group, causing an infinite loop. Now it returns
}
                    }
                                if let Some(ref t) = self.metrics.build_mask_time {
            finished: false,
                }
//! One `IndexedExec` and `IndexedStream` for all paths. Parameterized by
    /// `BooleanMask` → whole-RG select), bypassing the heuristic.
            self.min_skip_run_default
    /// RG had no candidates (empty bitmap) or fell outside the doc range —
                    let prefetch_mask_buffer = prefetched.prefetched.mask_buffer;
    /// Cumulative row offset for this segment within the shard.
        &self.properties
    }
                    // only skips on proof (see dynamic_filter::DynamicRgPruner).
            if self.coalescer_finished && self.batch_coalescer.is_empty() {
            self.global_base,
            self.stream_metrics.rg_skipped.clone(),
    pub(crate) row_groups: Vec<RowGroupInfo>,
    /// Evaluator whose `prefetch_rg` busy-spins (no `.await`/sleep — genuine
            rg: &RowGroupInfo,
                RecordBatch::try_new_with_options(
    /// Optional override for the per-RG `min_skip_run` choice, backed by the
    }
            predicate,
                                        return Poll::Ready(Some(Err(e)));
            batch_coalescer,
use datafusion::physical_plan::{
    metadata: Option<Arc<ParquetMetaData>>,
    /// Pluggable bitset source (SingleCollector or RustTree).
    /// skipped without a parquet read. Attributed to `rg_skipped`.
    /// non-yielding CPU work like a real Lucene/Arrow scan) for a fixed duration,
                    }
        // Bail before the expensive evaluator.prefetch_rg if the query was
    /// Used by `on_batch_mask` to translate the batch-coordinate under
                    counter.add(batch.num_rows());
        // this RG's parquet stats cannot match, skip BEFORE the (expensive)
use datafusion::execution::SendableRecordBatchStream;
                            self.current_mask = if min_skip_run == 1 {
                        Err(e) => return Poll::Ready(Some(Err(e))),
    pub(crate) emit_row_ids: bool,
}
        } else {
                })
            current_rg_idx: 0,
            &self,
        if cancellation_token.is_some_and(|t| t.is_cancelled()) {
                                if let Some(ref acc) = self.metrics.inner_parquet_metrics {
            let mut guard = self.evaluator.lock().unwrap();
            rg_skipped,
//! - `IndexReader` runs `evaluator.prefetch_rg(rg)` in a background task.
        );
            dynamic_filter,
        let mut reader = IndexReader::new(
    /// when no dynamic filter was pushed to this query.
                    filtered
                    if self.dynamic_rg_pruner.is_some() {
                            }
    /// snapshot against an RG's statistics before kicking off its Lucene eval.
    /// Extracted once from `DatafusionQueryConfig` so the hot path reads a
                    .iter()
            cancelled_err.load(Ordering::SeqCst),
    batch_offset: usize,
        loop {
                                        // with zero per-RG allocation.
        let evaluator = Arc::clone(&self.evaluator);
                    // that overrides the row-granular path too — used by
}
    /// may still complete; total evaluated is bounded to `evaluated_at_cancel + 1`.
 * this file be licensed under the Apache-2.0 license or a
                Poll::Pending => return Poll::Pending,
        prune: Option<(
#[cfg(test)]
                    // already narrowed to candidate rows; parquet's
use std::pin::Pin;
            spin: Duration::from_millis(200),
    fn fmt_as(&self, _t: DisplayFormatType, f: &mut fmt::Formatter) -> fmt::Result {
                Poll::Ready(Ok(None)) => {
                        let pruned =
                &evaluator,
                            if let Some(inner_metrics) = inner_plan.metrics() {
        &self,
    /// (row-granular selection). Same hot-path discipline as above.
                    "query cancelled".to_string(),
            .expect("driver task panicked");
                    // Row-granular (min_skip_run == 1): RowSelection
            f,
    RowSelection,
    coalescer_finished: bool,
        };
                                    if let Ok(mut vec) = acc.lock() {
                    match self.create_row_selection_stream(&rg, selection, push) {
            _rg: &RowGroupInfo,
                    let t_slice = Instant::now();
                                    if matches!(position_map, PositionMap::Identity { .. }) {
impl Stream for IndexedStream {
                        self.mask_offset = 0;
                                .unwrap_or_else(|| "unknown panic".into());
type PrefetchResult = std::result::Result<PrefetchOutcome, String>;
    /// bitmap empty → RG skipped without a parquet read). Handle is
        }
                        .downcast_ref::<BooleanArray>()
}
//! # Per-RG streaming with prefetch overlap
    /// `IndexedStream` so the hot path never touches the Arc.
 */
                        }
                self.batch_offset,
            self.stream_metrics.prefetch_wait_count.clone(),
                        if pruner.should_prune_rg(&metadata, rg.index) {
    fn with_new_children(
        assert!(
            Arc::clone(&self.store),
        //       misaligned indices. Ignore `current_mask`.
            num_rows: 100,
use std::any::Any;
    }
                        }
                    if let Some(ref timer) = self.metrics.index_time {
    cancellation_token: Option<tokio_util::sync::CancellationToken>,
                }
                    Poll::Ready(Err(_)) => {
                self.index_reader.dynamic_prune_ctx = pruner.current_pruning_predicate();
                        let status = self.batch_coalescer.push_batch(filtered);
            metadata: Arc::clone(&self.metadata),
        )
            total_evaluated
        rg_skipped: Option<datafusion::physical_plan::metrics::Count>,
                                        BooleanArray::new(bb, None)
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
    #[allow(clippy::too_many_arguments)]
                            Err(e) => return Poll::Ready(Some(Err(e))),
            io_stats: self
    /// Below this candidate selectivity, pin `min_skip_run = 1`
                    // Metric: record which PositionMap variant this RG
                        // start the wait-clock.
            current_rg_context: None,
                    return Poll::Ready(Some(Err(e)));
    full_schema: SchemaRef,
        push_predicate: bool,
                if let Some(ref t) = self.metrics.filter_record_batch_time {
    async fn cancel_stops_row_group_dispatch() {
/// Outcome of one prefetch task.
                            // delivered row is by construction a candidate,
            }
                    // mid-decode and misalign those indices. Pushdown
            }
    /// Per-RG state carried from `PrefetchedRg.context` so `on_batch_mask`
                    self.batch_offset = 0;
    }
                            if let Some(ref timer) = self.metrics.parquet_time {
                                        vec.push(inner_metrics);
    ) -> Result<Arc<dyn ExecutionPlan>> {
            let mut candidates = RoaringBitmap::new();
    /// `None` when `emit_row_ids=false` or `___row_id` is not in projection.
        }
        assert!(
//!   next-RG bitset is ready (or we wait briefly for it).
                self.upstream_done = true;
                    // same counters as before so `EXPLAIN ANALYZE` output
    current_position_map: Option<PositionMap>,
            // 3. If upstream signalled done and we haven't finished the
                        let t0 = Instant::now();
                        // First time we see Pending for this prefetch →
                    // via PositionMap, pushdown would drop rows
    }
            total_evaluated <= evaluated_at_cancel + 1,
        Some(self.metrics.clone_inner())
                            (rg.num_rows as usize).saturating_sub(candidates.len() as usize);
                return Poll::Ready(None);
            doc_range_str,
                            return Poll::Ready(Err(DataFusionError::Execution(format!(
                    }
        // batch. With BooleanMask strategy, the batch contains all RG rows
        // for this chunk, so batch_offset is row-index-within-RG and the
                    t.add_duration(t_poll.elapsed());
            row_groups,
        global_base: u64,
            evaluated_at_cancel,
                }
    /// a DataFusionError so the Java search thread unblocks.
    Pruned,
        );
use std::time::{Duration, Instant};
    /// `None` only in unit tests that don't exercise dynamic-filter pruning.
                doc_range,
            None => String::new(),
        fn on_batch_mask(
            .field("row_groups", &self.row_groups.len())
    fn execute(
    /// Cumulative row offset for this segment within the shard.
                        // elapsed wall-clock as prefetch_wait_time.
            }
impl ExecutionPlan for IndexedExec {
/// Override for the per-RG `min_skip_run` selectivity heuristic. `IndexedStream`
use datafusion_common::DataFusionError;
/// `force_strategy` to one of these variants pins the choice node-wide.
                first_row: (i as i64) * 100,
        let output = if let Some(row_id_idx) = self.row_id_output_index {
        dynamic_filter: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
    /// Result of a prefetch task. `Pruned` is distinct from `Ok(None)`
    ///
                        if let Some(ref c) = self.dynamic_filter_rg_pruned_at_prefetch {
                match poll_result {
        evaluator: Arc<dyn RowGroupBitsetSource>,
        let prune = match (self.dynamic_prune_ctx.clone(), self.metadata.as_ref()) {
use std::fmt;
        vec![]
            let t0 = Instant::now();
                            if let Some(ref c) = self.prefetch_wait_count {
use datafusion::arrow::compute::filter_record_batch;
        //       the exact result, and applying both would double-filter with
            }
        // Prefetch-phase dynamic-filter prune: if the snapshot-so-far proves
                self.mask_offset += batch_len;
                    Ok(PrefetchOutcome::Pruned) => {
            current_mask: None,
//! DataFusion's own predicate pushdown filtered during decode), we emit
    index_reader: IndexReader,
    /// against the target RG's stats and skips the Lucene eval if the RG is
                                        let bb = datafusion::arrow::buffer::BooleanBuffer::new(
        let mut max_doc = (rg.first_row + rg.num_rows) as i32;
                            self.current_position_map = Some(position_map);
                        )),
                .dynamic_filter_rg_pruned_at_prefetch
            current_inner_plan: None,
            _position_map: &PositionMap,
            evaluator,
        // Two cases:
            max_doc = max_doc.min(range_max);
            Some((min, max)) => format!(", doc_range=[{}, {})", min, max),
        // prefetch-phase prune runs off the poll thread.
                    Poll::Ready(Ok(Some(_))) => Poll::Ready(false),
        let t_on_batch = Instant::now();
            self.schema.clone(),
                        // eval ran — the prefetch-phase win.
    fn children(&self) -> Vec<&Arc<dyn ExecutionPlan>> {
            last_poll_end: None,
        static UNIT: () = ();
                    }
            }
            None,
        }
            full_schema: self.full_schema.clone(),
        } else if output.schema().as_ref() == self.schema.as_ref() {
    }
                                Some(m)
            loop {
    file_size: u64,
    pub(crate) object_path: object_store::path::Path,
                rg_idx,
            self.cancellation_token.clone(),
    /// `target_batch_size` so downstream operators see fewer, larger
                index: i,
        if let Some((ctx, metadata)) = prune.as_ref() {
            evaluator,
            Ok(Some(PrefetchedRg::without_context(candidates, 0)))
                        // Rows in this RG that the candidate stage
                self.start_prefetch(self.current_rg_idx);
/// Execution plan for a single segment chunk (1+ row groups from one segment).
                                }
        // Snapshot-so-far + metadata, moved into the blocking task so the
                    // residual = exact output. Pushdown is ON.
            coalescer_finished: false,
                                };
            self.stream_start = Some(Instant::now());
            _batch: &RecordBatch,
        doc_range: Option<(i32, i32)>,
                        min_skip_run,
            self.row_groups.clone(),
                        match status {
            .await
/// `-1` = `None` = let selectivity decide).
            self.call_count.fetch_add(1, Ordering::SeqCst);
                                if !self.coalescer_finished {
    /// batch if no rows survived (callers filter those out before
        metadata: Option<Arc<ParquetMetaData>>,
                    //
        }
        }
                return Poll::Ready(Err(DataFusionError::Execution(
    }
}
                        // Push into coalescer under a timer.
        );
                if let Some(ref t) = self.metrics.parquet_poll_time {
    }
            }
        }
        ) -> Result<Option<PrefetchedRg>, String> {
    }
//!
        };
                    let push = self.indexed_pushdown_filters
                                let t_build = Instant::now();
                        PositionMap::Bitmap { .. } => {
        match self.force_strategy {
        //   (A) `on_batch_mask` returns Some(m). The evaluator owns the final
        }
                    Poll::Pending => {
                            if let Some(ref c) = self.metrics.dynamic_filter_rg_pruned_at_poll {
    /// `finish()` has been called on the coalescer. Used to prevent
                        timer.add_duration(Duration::from_nanos(prefetched.prefetched.eval_nanos));
                            continue;
                } else {
                                }
        f.debug_struct("IndexedExec")
            evaluator.clone(),
    }
            super::dynamic_filter::RgPruningContext,
                        self.pending_prefetch = None;
        rg_idx: usize,
        let empty_pos_map =
            _max_doc: i32,
 *
            None,
            );
                    // Share the bitmap between PositionMap (under
    /// atomic load); `None` token (untracked/test) is never cancelled.
                                        // to RG positions. Must build the mask
    BooleanMask,
            pending_since: None,
 * SPDX-License-Identifier: Apache-2.0
                            c.add(1);
}
                            if let Some(ref c) = self.metrics.position_map_bitmap {
                            } else {
                                    build_mask(&candidates, &position_map)
                    // dropped (supports_filters_pushdown = Exact) so
    }
            output
    pub(crate) doc_range: Option<(i32, i32)>,
            Err(e) => panic!("Tokio JoinError: {}", e),
            }
                    // Poll-phase dynamic-filter prune (backstop): the filter may
use datafusion::arrow::array::{Array, BooleanArray, UInt64Array};
    use roaring::RoaringBitmap;
    /// When `force_strategy` is set (via the `datafusion.indexed.force_strategy`
}
        // Capture position info BEFORE mask is consumed (needed for row ID computation).
            evaluator,
                    msg
                    let candidates = Arc::new(candidates);
                            };
    pub first_row: i64,
                    let mask_slice = mask.slice(self.mask_offset, batch_len);
                        t.add_duration(t_slice.elapsed());
                continue;
            Some(prefetched) => Ok(PrefetchOutcome::Fetched(PrefetchedRowGroup {
    /// `datafusion.indexed.force_strategy` cluster setting — see `pick_min_skip_run`.
                    .schema
                if done {
                                            0,
                    }
/// normally picks `min_skip_run` from candidate selectivity; setting
    /// `subtree_cost` panic when DelegationPossible reaches the Tree evaluator.
        parquet_bridge::create_row_selection_stream(
mod tests {
                assert!(
        let eval_mask = self
                        counter.add(pruned);
    row_groups: Vec<RowGroupInfo>,
                let done = futures::future::poll_fn(|cx| match reader.poll_next_row_group(cx) {
use datafusion::parquet::file::metadata::ParquetMetaData;
    /// from the same query; read once per RG into local fields inside
            .expect("reader should terminate promptly after cancel")
            &self,
    projection: Option<Vec<usize>>,
//! - When the parquet stream for the current RG finishes, the prefetched
        call_count: AtomicUsize,
        metrics: StreamMetrics,
            self.query_config.force_strategy,
        // only tightens, so an RG excluded here stays excluded.
    /// Before the fix, `Poll::Ready(Err(_))` on the oneshot receiver would
            Some(ctx) => ctx.as_ref(),
                    Poll::Ready(Some(Err(e))) => return Poll::Ready(Some(Err(e))),
            None => &UNIT,
        let row_groups: Vec<RowGroupInfo> = (0..8)
            self.row_id_output_index,
    use std::sync::Arc;
                            c.add(1);
                        PositionMap::Runs { .. } => {
                    self.index_reader.row_groups.len(),
                    batch
            cancellation_token,
    /// Whether to ask parquet to apply residual predicates during decode.
///
    pub(crate) seg_arrow_schema: SchemaRef,
    /// A mock evaluator that panics on prefetch_rg, simulating the
}
                    Poll::Ready(Err(join_error)) => {
                        Arc::clone(&candidates),
    /// the receiver eventually resolves.
//!
        full_schema: SchemaRef,
                .take()
    }
struct PrefetchedRowGroup {
    ) -> Self {
        };
            Arc<ParquetMetaData>,
        let rg = row_groups[rg_idx].clone();
                        self.current_stream = None;
            .map(|i| RowGroupInfo {
            self.query_config.indexed_pushdown_filters,
        let evaluated_at_cancel = rgs_evaluated.load(Ordering::SeqCst);
    /// Cached per-segment arrow schema derived from parquet footer. Used by
                                self.current_rg_idx, panic_msg
                    self.stream_start.unwrap().elapsed()
            cached_result: None,
        )>,
    /// dispatching further row groups and `IndexedStream` stops draining.
                );
    fn fetch_row_group(
                                    }
        prefetch_wait_count: Option<datafusion::physical_plan::metrics::Count>,
    pub(crate) global_base: u64,
            Some(mask) => {
                        }
        let total_evaluated = rgs_evaluated.load(Ordering::SeqCst);
                .unwrap_or_else(|| Arc::new(super::parquet_bridge::ReadIoStats::default())),
                    // Block-granular (min_skip_run > 1): RowSelection
                        if let Some(inner_plan) = self.current_inner_plan.take() {
            self.stream_metrics.clone(),
                        // If we had parked on this receiver, account the
        } else {
            force_strategy,
                        self.batch_offset = 0;
    }
                t.add_duration(gap);
        fn prefetch_rg(
enum PrefetchOutcome {
// ── IndexReader (drives the evaluator RG-by-RG with prefetch overlap) ──
}
    fn start_prefetch(&mut self, rg_idx: usize) {
            None,
        token.cancel();
            // Poll for next row group
            None,
            stream_start: None,
                            Ok(PushBatchStatus::LimitReached) => {
                log_debug!(
#[derive(Debug, Clone, Copy, PartialEq)]
    }
//!   stream for record batches.
                            }
            min_skip_run_default,
    fn is_cancelled(&self) -> bool {
                    }
    /// (empty candidate set): it means the dynamic filter excluded the RG
    /// True when this query's task has been cancelled. Cheap (one relaxed
    Empty,
                    .collect();
            doc_range,
        let token = self.cancellation_token.clone();
                        rg.num_rows as usize,
        let handle = tokio::spawn(async move {
        Ok(self)
        rg: &RowGroupInfo,
                                None
                    // tree path's on_batch_mask can reach into candidate-stage
                    msg.contains("panicked"),
                            if let Some(ref t) = self.prefetch_wait_time {
                        if let Some(ref c) = self.metrics.batches_pre_coalesce {
            return Poll::Pending;
                        .as_any()
            self.row_groups.len(),
            evaluator,
                    return result;
                    // is coalesced. If the stream will build
            return Ok(PrefetchOutcome::Empty);
            Ok(Err(msg)) => {
            if min_doc >= max_doc {
                        && !alignment_risk
//! of which evaluator produces the bitset.
}
                    // post-decode.
    /// panic), the IndexReader propagates an error instead of hanging forever.
            _batch_offset: usize,
        };
}
    /// Optional runtime dynamic filter (TopK / join) accepted via physical
            if n == 0 {
        _partition: usize,
            metadata,
                    if let Some(ref counter) = self.metrics.rows_pruned {
        &self,
            .field("has_predicate", &self.predicate.is_some())
            self.rgs_evaluated.fetch_add(1, Ordering::SeqCst);
        )
        ) -> Result<Option<BooleanArray>, String> {
use crate::datafusion_query_config::DatafusionQueryConfig;
    /// each `poll_next_row_group`). When present, `start_prefetch` checks it
    pub num_rows: i64,
    ///
            upstream_done: false,
        // Poll the reader — should complete with an error within the timeout.
                        .map_err(|e| DataFusionError::ArrowError(Box::new(e), None))?;
        mut self: Pin<&mut Self>,
        spin: Duration,
}
                        if join_error.is_panic() {
    /// block-granular `RowSelection`. Rebuilt each RG from the selection
        // Ask the evaluator for a refinement-stage mask on the UNFILTERED
                                }
        // refinement mask aligns one-to-one with the batch rows.
            rg.index,
    metadata: Arc<ParquetMetaData>,
                &self.schema,
                                timer.add_duration(t_plan.elapsed());
            dynamic_filter_rg_pruned_at_prefetch,
                        // parquet read. Count for EXPLAIN ANALYZE.
            while Instant::now() < deadline {
    pub(crate) full_schema: SchemaRef,
    DisplayAs, DisplayFormatType, ExecutionPlan, PlanProperties, RecordBatchStream,
    /// before the Lucene eval ran, so it must be attributed to the
        );
                let indices: Vec<usize> = self
            self.initialized = true;
use datafusion::common::Result;
    current_inner_plan: Option<Arc<dyn ExecutionPlan>>,
    emit_row_ids: bool,
                        continue;
                            v.as_ref().map(|_| ()).map_err(|e| e.to_string()),
                        // RG had no candidates — skipped without a
                                .downcast_ref::<String>()
    object_path: object_store::path::Path,
                rg_state,
    /// RG fetched with a non-empty candidate set.
        let position_map = self.current_position_map.as_ref().unwrap_or(&empty_pos_map);
                    "Error should mention panic, got: {}",
            seg_arrow_schema,
        };
    // `spawn_blocking` jobs cannot be aborted — tokio's task abort only cancels
            // Bail before dispatching the next row group if the query is cancelled.
            self.stream_metrics
                        counter.add(1);
        let row_groups = self.row_groups.clone();
                        counter.add(1);
                    self.upstream_done = true;
                match Pin::new(rx).poll(cx) {
    /// the filtered batch ready for the coalescer. Returns a zero-row
    prefetch_wait_count: Option<datafusion::physical_plan::metrics::Count>,
// Indexed streams - Per segment stream
                        }
                .clone(),
    schema: SchemaRef,
        }
        let doc_range_str = match self.doc_range {
    pub(crate) stream_metrics: StreamMetrics,
            .is_some_and(|t| t.is_cancelled())
        let total_rows: i64 = self.row_groups.iter().map(|rg| rg.num_rows).sum();
                    }
            store,
                    Ok(PrefetchOutcome::Empty) => {
        assert!(
            None,
    rg_skipped: Option<datafusion::physical_plan::metrics::Count>,
            })
                    let selection = build_row_selection_with_min_skip_run(
            c.add(1);
                })
    }
            }
            emit_row_ids,
    fn name(&self) -> &str {
            Some(Arc::clone(&self.metadata)),
                    //
                                    }
                &row_groups,
        let evaluator = Arc::new(PanickingEvaluator {
                )));
use super::eval::{PrefetchedRg, RowGroupBitsetSource};
                eval_mask: eval_mask.clone(),
    current_rg_idx: usize,
            "cancelled reader kept evaluating row groups: evaluated_at_cancel={}, total_evaluated={}",
            indexed_pushdown_filters,
            _batch_len: usize,
                    Poll::Ready(Some(Ok(_))) => continue,
            } else {
    }
//! # Post-decode mask (multi-filter tree path only)
            full_schema.clone(),
            }
impl fmt::Debug for IndexedExec {
                            }
            _batch_len: usize,
                let t_filter = Instant::now();
    /// provably excluded. `None` when no dynamic filter was pushed.
    predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        if let Some(prev_end) = self.last_poll_end {
                                    } else {
    stream_start: Option<std::time::Instant>,
                &batch,
        // inside this poll. Attributed to the operator for EXPLAIN
        loop {
    /// Force a single whole-RG select (`min_skip_run > rg_num_rows`).
            index_reader,
        self.cancellation_token
        self.schema.clone()
                }
    // token checkpoint stops new row groups from being dispatched.
                    continue;
                    // the underlying data.
            if let Some(ref t) = self.metrics.inter_poll_gap {
    pub(crate) store_url: datafusion::execution::object_store::ObjectStoreUrl,
        // At most one already-in-flight spawn_blocking job (non-abortable) can
    /// can reach into it during refinement (used by the multi-filter tree
            "IndexedExec: rg={}, total_rows={}, predicate={}{}",
        );
            if self.upstream_done && !self.coalescer_finished {
                let poll_result = futures::future::poll_fn(|cx| {
            total_evaluated < 8,
            if let Some(ref t) = self.metrics.init_prefetch_time {
    upstream_done: bool,
                 Planner must drop performance peers under OR/NOT before fragment conversion."
    /// row groups. At most one already-in-flight `spawn_blocking` job (non-abortable)
            rgs_evaluated: rgs_evaluated.clone(),
            .finish()
                    self.schema.clone(),
                .metrics
            .collect();
        file_size: u64,
            // Non-yielding busy work — mirrors a synchronous scan/decode poll.
            if self.current_rg_idx >= self.row_groups.len() {
                                            buf.clone(),
    }
                            let payload = join_error.into_panic();
                        PositionMap::Identity { .. } => {
            self.store_url.clone(),
        );
        // time downstream work.
            }
                        if let Some(ref counter) = self.metrics.min_skip_run_row_granular {
                    } else if let Some(ref counter) = self.metrics.min_skip_run_block_granular {
    pub(crate) properties: Arc<PlanProperties>,
                if let Some(ref counter) = self.metrics.batches_produced {
                &output,
                filtered
            super::row_id_injection::inject_row_ids(
        }
            "reader should terminate via the cancellation Err path"
/// Row group metadata.
        let dynamic_rg_pruner = super::dynamic_filter::DynamicRgPruner::new(
        // 8 row groups × 200ms spin each = ~1.6s of work if cancellation is ignored.
        let doc_range = self.doc_range;
            loop {
        ) -> Result<Option<BooleanArray>, String> {
                match result {
                        }
            self.dynamic_filter.clone(),
        //       `current_mask` from the candidate stage (or DataFusion
