    /// cluster setting.
        let output = if let Some(row_id_idx) = self.row_id_output_index {
                    }
    fn finalize_batch(&mut self, batch: RecordBatch) -> Result<RecordBatch> {
    ) -> std::result::Result<PrefetchOutcome, String> {
                        }
            total_evaluated < 8,
        let result = tokio::time::timeout(Duration::from_millis(500), handle).await;
                }
    /// call `finish()` on the coalescer and drain it before returning
                    .iter()
        if let Some(prev_end) = self.last_poll_end {
    }
        let t_proj = Instant::now();
                        self.pending_prefetch = None;
    /// row groups. At most one already-in-flight `spawn_blocking` job (non-abortable)
            // 4. Pull the next filtered batch from upstream (parquet stream
                        counter.add(1);
                                        // Fast path: full-scan regime (no skips),
                    self.index_reader.row_groups.len(),
                .clone(),
    /// Parquet metadata for this segment — needed to evaluate a dynamic-filter
    /// RG excluded by the dynamic filter at prefetch time, before the Lucene
                filtered
    pub(crate) emit_row_ids: bool,
            })
            total_evaluated
    batch_coalescer: LimitedBatchCoalescer,
                            let panic_msg = payload
                        if let Some(ref c) = self.metrics.parquet_batches_received {
                    .collect();
///
    prefetch_wait_count: Option<datafusion::physical_plan::metrics::Count>,
    /// Count of RGs skipped at prefetch time (before the Lucene eval).
            emit_row_ids,
                                    }
            unreachable!()
            cancellation_token,
    }
    /// `IndexedStream` so the hot path never touches the Arc.
    /// are fed in via `push_batch`; completed batches are drained via
        }
                    // only skips on proof (see dynamic_filter::DynamicRgPruner).
use std::fmt;
        schema: SchemaRef,
    ) -> Result<Arc<dyn ExecutionPlan>> {
                        if let Some(started) = self.pending_since.take() {
                return Poll::Ready(None);
                            Err(e) => return Poll::Ready(Some(Err(e))),
                        // First time we see Pending for this prefetch →
                                        // delivered row i == RG position i. Wrap
                return Poll::Ready(Some(Ok(batch)));
        index_reader: IndexReader,
            None => {
//!
    /// Take one parquet-delivered batch, apply candidate + refinement
                .unwrap_or_else(|| Arc::new(super::parquet_bridge::ReadIoStats::default())),
                return Poll::Ready(Err(DataFusionError::Execution(
                    // Share the bitmap between PositionMap (under
                            v.as_ref().map(|_| ()).map_err(|e| e.to_string()),
                        min_skip_run,
            }
            PositionMap::from_selection(&RowSelection::from(Vec::<RowSelector>::new()));
                                        // with zero per-RG allocation.
    /// Extracted once from `DatafusionQueryConfig` so the hot path reads a
        );
        };
        prefetch_wait_count: Option<datafusion::physical_plan::metrics::Count>,
    async fn test_panic_in_prefetch_returns_error_not_hang() {
            c.add(1);
            })
                doc_range,
    row_id_output_index: Option<usize>,
                        if let Some(ref counter) = self.metrics.min_skip_run_row_granular {
    ) -> Poll<std::result::Result<Option<PrefetchedRowGroup>, DataFusionError>> {
            row_id_output_index,
                &evaluator,
    fn execute(
                return Ok(PrefetchOutcome::Empty);
        let handle = tokio::spawn(async move {
    pub(crate) object_path: object_store::path::Path,
                    self.stream_start.unwrap().elapsed()
                                        let bb = datafusion::arrow::buffer::BooleanBuffer::new(
        &self,
                    // is coalesced. If the stream will build
                            self.current_inner_plan = Some(plan);
                                self.upstream_done = true;
            }
                .metrics
            }
            evaluator,
        )
            "expected early termination, but all row groups were evaluated ({})",
                self.start_prefetch(self.current_rg_idx);
            io_stats: self
use std::task::{Context, Poll};
    dynamic_prune_ctx: Option<super::dynamic_filter::RgPruningContext>,
    /// Index in the OUTPUT schema where computed `___row_id` should be inserted.
// ── Prefetched Row Group ─────────────────────────────────────────────
            min_skip_run_selectivity_threshold,
                    }
#[cfg(test)]
                            self.current_stream = Some(stream);
        let selectivity = num_candidates as f64 / rg_num_rows as f64;
                        let filtered = match self.as_mut().finalize_batch(batch) {
        // refinement mask aligns one-to-one with the batch rows.
        }
            if min_doc >= max_doc {
    batch_offset: usize,
                            t.add_duration(t0.elapsed());
        let token = self.cancellation_token.clone();
use futures::{Future, Stream};
struct IndexedStream {
    dynamic_filter_rg_pruned_at_prefetch: Option<datafusion::physical_plan::metrics::Count>,
                                };
                        if let Some(inner_plan) = self.current_inner_plan.take() {
use datafusion::parquet::arrow::arrow_reader::{RowSelection, RowSelector};
        _context: Arc<datafusion::execution::TaskContext>,
            _max_doc: i32,
            // Refresh the dynamic-filter snapshot the IndexReader hands to its
                    // via PositionMap, pushdown would drop rows
/// Backed by the `datafusion.indexed.force_strategy` cluster setting (wire
    /// eval ran. Attributed to `dynamic_filter_rg_pruned_at_prefetch`.
    pub(crate) schema: SchemaRef,
            cancelled_err.load(Ordering::SeqCst),
 *
    mask_offset: usize,
    /// Cumulative row offset for this segment within the shard.
            None,
use datafusion::common::Result;
    emit_row_ids: bool,
                    // that overrides the row-granular path too — used by
                        }
            Some(ctx) => ctx.as_ref(),
                return Poll::Ready(None);
            metadata: Arc::clone(&self.metadata),
        if let Some(ref c) = self.metrics.poll_count {
            if let Some(ref mut rx) = self.pending_prefetch {
        if let Some(ref t) = self.metrics.elapsed_compute {
                );
    /// When `force_strategy` is set (via the `datafusion.indexed.force_strategy`
    /// Wall-clock timestamp when the current pending prefetch was first
            1
                    if let Some(ref counter) = self.metrics.rows_matched {
                            }
                            c.add(1);
            Some(FilterStrategy::RowSelection) => return 1,
                            if let Some(ref c) = self.metrics.dynamic_filter_rg_pruned_at_poll {
                    // already narrowed to candidate rows; parquet's
                        let t0 = Instant::now();
            if let Some(batch) = self.batch_coalescer.next_completed_batch() {
                            // delivered row is by construction a candidate,
                }
        // only tightens, so an RG excluded here stays excluded.
        rg: &RowGroupInfo,
                tokio::time::sleep(Duration::from_millis(50)).await;
        });
            self.object_path.clone(),
                        }
            }
        target_batch_size: usize,
        "IndexedExec"
                self.batch_offset += batch_len;
        self.cancellation_token
        &self,
//! - While that's running, `IndexedStream` polls the current RG's parquet
        let rg_info = RowGroupInfo {
    cached_result: Option<PrefetchResult>,
                        self.pick_min_skip_run(candidates.len() as usize, rg.num_rows as usize);
    /// from the same query; read once per RG into local fields inside
                Poll::Ready(Err(e)) => return Poll::Ready(Some(Err(e))),
    use std::sync::atomic::{AtomicBool, AtomicUsize, Ordering};
use std::pin::Pin;
        Ok(Box::pin(IndexedStream::new(
    stream_start: Option<std::time::Instant>,
                ))));
            if self.is_cancelled() {
        row_groups: Vec<RowGroupInfo>,
        &mut self,
        let batch_len = batch.num_rows();
            None => {}
    pub(crate) projection: Option<Vec<usize>>,
                );
            spin: Duration::from_millis(200),
            Some(Arc::clone(&self.metadata)),
                        // parquet read. Count for EXPLAIN ANALYZE.
            .map_err(|e| DataFusionError::External(e.into()))?;
            max_doc = max_doc.min(range_max);
                        .downcast_ref::<BooleanArray>()
        }
    /// was pushed. Owns its own snapshot generation tracking, so it must NOT be
            index_reader,
                    // dropped (supports_filters_pushdown = Exact) so
};
            self.stream_metrics.clone(),
            predicate: self.predicate.clone(),
            current_position_map: None,
//! - When the parquet stream for the current RG finishes, the prefetched
            return Err("query cancelled".to_string());
            _min_doc: i32,
        }
    pub num_rows: i64,
            }
    force_strategy: Option<FilterStrategy>,
    /// RG had no candidates (empty bitmap) or fell outside the doc range —
use super::metrics::StreamMetrics;
                    // per-RG state.
            // Lucene eval) using the filter's tightening so far.
    pub(crate) query_config: Arc<DatafusionQueryConfig>,
                        }
        let rgs_evaluated = Arc::new(AtomicUsize::new(0));
    fn poll_next_row_group(
        )))
            current_stream: None,
    /// and before the evaluator runs in a queued blocking job. `None` disables cancellation.
                        continue;
    }
use super::row_selection::{build_mask, build_row_selection_with_min_skip_run, PositionMap};
    /// noisy short gaps would explode the selector Vec, so absorb anything shorter
    ///
        fn on_batch_mask(
    current_stream: Option<SendableRecordBatchStream>,
            if self.upstream_done && !self.coalescer_finished {
        } else if output.schema().as_ref() == self.schema.as_ref() {
    fn start_prefetch(&mut self, rg_idx: usize) {
                        self.current_position_map = None;
            initialized: false,
// ── IndexedExec ──────────────────────────────────────────────────────
    /// Force a single whole-RG select (`min_skip_run > rg_num_rows`).
                    Ok(PrefetchOutcome::Fetched(p)) => return Poll::Ready(Ok(Some(p))),
        self.start_prefetch(0);
        fn prefetch_rg(
                return Ok(PrefetchOutcome::Pruned);
            push_predicate,
            None,
        metrics: StreamMetrics,
            self.schema.clone(),
        assert!(
                    self.object_path.filename().unwrap_or("?"),
            selection,
            self.emit_row_ids,
                    // evaluator's `on_batch_mask` will look up positions
                num_rows: 100,
    pending_since: Option<Instant>,
            dynamic_prune_ctx: None,
            _batch: &RecordBatch,
                std::hint::spin_loop();
            Some(mask) => {
                        timer.add_duration(Duration::from_nanos(prefetched.prefetched.eval_nanos));
                    //
    #[allow(clippy::too_many_arguments)]
            file_path: self.object_path.to_string(),
                                "prefetch for row group {} panicked: {}",
                        // elapsed wall-clock as prefetch_wait_time.
    fn fetch_row_group(
    DisplayAs, DisplayFormatType, ExecutionPlan, PlanProperties, RecordBatchStream,
                mask_offset_before,
            // Bail before dispatching the next row group if the query is cancelled.
                self.batch_offset,
                        Err(e) => return Poll::Ready(Some(Err(e))),
            }
            t.add_duration(t_proj.elapsed());
        // With the fix: should complete (not timeout) with an error
                    }
            "IndexedExec: rg={}, total_rows={}, predicate={}{}",
                .await;
    /// retry the same row group, causing an infinite loop. Now it returns
                    continue;
                }
                                    }
        full_schema: SchemaRef,
                position_map: self.current_position_map.as_ref().cloned(),
    pub(crate) global_base: u64,
    /// `subtree_cost` panic when DelegationPossible reaches the Tree evaluator.
            cached_result: None,
            upstream_done: false,
                    let push = self.indexed_pushdown_filters
                                        BooleanArray::new(bb, None)
                            counter.add(1);
    /// local `usize`.
                    Poll::Pending => return Poll::Pending,
        ) -> Result<Option<PrefetchedRg>, String> {
    current_inner_plan: Option<Arc<dyn ExecutionPlan>>,
    }
    }
    use roaring::RoaringBitmap;
                    );
                // Yield to let spawn_blocking complete
                        min_skip_run,
    /// Optional override for the per-RG `min_skip_run` choice, backed by the
use tokio::task::JoinHandle;
                        // page-level pruning). `rg.num_rows - matched`.
            store_url: self.store_url.clone(),
    /// Upstream delivered `None` (all RGs consumed). We still need to
            _min_doc: i32,
            _max_doc: i32,
                        }
    /// Per-RG map from delivered batch-row index to RG-relative position.
        let rg = row_groups[rg_idx].clone();
        min_skip_run_selectivity_threshold: f64,
// ── IndexReader (drives the evaluator RG-by-RG with prefetch overlap) ──
                    // mid-decode and misalign those indices. Pushdown
        // inside this poll. Attributed to the operator for EXPLAIN
    metadata: Option<Arc<ParquetMetaData>>,
    /// `datafusion.indexed.force_strategy` cluster setting — see `pick_min_skip_run`.
                                .or_else(|| payload.downcast_ref::<&str>().map(|s| s.to_string()))
            self.cancellation_token.clone(),
        evaluator: &Arc<dyn RowGroupBitsetSource>,
            &self.bridge_config(),
            self.start_prefetch(self.current_rg_idx);
                                t.add_duration(started.elapsed());
    }
                                        // Block-granular: RowSelection has skip
                    // UDF-containing predicate.
            let ctx = row_id_ctx.unwrap();
}
                        if filtered.num_rows() == 0 {
        let total_rows: i64 = self.row_groups.iter().map(|rg| rg.num_rows).sum();
        cx: &mut Context<'_>,
        metadata: Option<Arc<ParquetMetaData>>,
                })
                                if !self.coalescer_finished {
    pub(crate) full_schema: SchemaRef,
    /// batches (matching FilterExec's behaviour). Post-filter batches
                    }
                    let t_filter = Instant::now();
                prefetched,
                    match self.create_row_selection_stream(&rg, selection, push) {
            doc_range,
        );
    /// cluster setting) it pins the choice to either extreme (`RowSelection` → 1,
    projection: Option<Vec<usize>>,
        // cancelled after this blocking job was queued but before it started.
            evaluator,
        let output = match eval_mask {
                            ))));
            Ok(Some(PrefetchedRg::without_context(candidates, 0)))
                &batch,
                rg_state,
            }
    ) -> Result<(SendableRecordBatchStream, Arc<dyn ExecutionPlan>)> {
        Self {
        file_size: u64,
        }
                            } else if self.evaluator.needs_row_mask() {
            if self.index_reader.is_cancelled() {
                    }
use datafusion::arrow::compute::filter_record_batch;
                    &datafusion::arrow::record_batch::RecordBatchOptions::new()
    }
        Ok(output)
    fn with_new_children(
}
    current_mask: Option<BooleanArray>,
        rg_idx: usize,
            // prefetch tasks, so the next prefetch can prune (skipping the
            _batch_offset: usize,
                    .map(|f| output.schema().index_of(f.name()).unwrap_or(0))
            predicate,
            }
    min_skip_run_default: usize,
                );
                    }
                Poll::Pending => return Poll::Pending,
                if let Some(ref t) = self.metrics.parquet_poll_time {
    /// Whether to ask parquet to apply residual predicates during decode.
        };
        } else {
                    // Decide min_skip_run for this RG (see `pick_min_skip_run`).
    /// bitmap empty → RG skipped without a parquet read). Handle is
    pub(crate) metrics: ExecutionPlanMetricsSet,
                    // post-decode.
            } else {
            .field("has_predicate", &self.predicate.is_some())
                    Ok(PrefetchOutcome::Pruned) => {
        // Manual timer for `elapsed_compute`: total wall time spent
#[derive(Debug, Clone)]
        dynamic_filter: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        // Prefetch-phase dynamic-filter prune: if the snapshot-so-far proves
        self.schema.clone()
                    let alignment_risk = min_skip_run != 1 && self.evaluator.needs_row_mask();
                    // `forbid_parquet_pushdown()` is a blanket opt-out
                &ctx,
                        PositionMap::Bitmap { .. } => {
        let mut reader = IndexReader::new(
                    Poll::Ready(Err(join_error)) => {
        );
                    // OFF; the evaluator applies the residual
            index_reader,
    /// `finish()` has been called on the coalescer. Used to prevent
        object_path: object_store::path::Path,
    /// non-yielding CPU work like a real Lucene/Arrow scan) for a fixed duration,
    /// Count of times we hit `Poll::Pending` on the prefetch receiver.
use datafusion::parquet::file::metadata::ParquetMetaData;
                        self.current_mask = None;
}
        // Capture position info BEFORE mask is consumed (needed for row ID computation).
            _rg_first_row: i64,
                    Poll::Ready(Some(Ok(batch))) if batch.num_rows() > 0 => {
            Ok(None)
                            if let Some(ref timer) = self.metrics.parquet_time {
    /// Force row-granular selection (`min_skip_run = 1`).
        } else {
                    if min_skip_run == 1 {
    pub(crate) row_id_output_index: Option<usize>,
    current_rg_context: Option<Box<dyn Any + Send + Sync>>,
//!
    fn new(
        doc_range: Option<(i32, i32)>,
                        // Rows in this RG that the candidate stage
        // We need to yield between polls because start_prefetch returns Pending
 * compatible open source license.
        if let Some((ctx, metadata)) = prune.as_ref() {
}
    // token checkpoint stops new row groups from being dispatched.
            current_rg_first_row: 0,
                                        // the pre-built packed bits as BooleanArray
            min_doc = min_doc.max(range_min);
struct PrefetchedRowGroup {
    /// Otherwise the choice is selectivity-driven: at low selectivity every gap
                            continue;
            self.store_url.clone(),
    /// A mock evaluator that panics on prefetch_rg, simulating the
//!
                    }
            _rg_state: &dyn std::any::Any,
                    // Row-granular (min_skip_run == 1): RowSelection
            force_strategy,
            if let Some(ref mut stream) = self.current_stream {
        // batch. With BooleanMask strategy, the batch contains all RG rows
    /// the filtered batch ready for the coalescer. Returns a zero-row
                        }
        if rg_idx >= row_groups.len() {
                        self.mask_offset = 0;
                        continue;
/// `-1` = `None` = let selectivity decide).
            self.global_base,
                            if let Some(inner_metrics) = inner_plan.metrics() {
                self.current_mask.as_ref(),
        spin: Duration,
    metrics: StreamMetrics,
                    .map_err(|e| DataFusionError::ArrowError(Box::new(e), None))?;
            None => String::new(),
    object_path: object_store::path::Path,
                    "query cancelled".to_string(),
        write!(
    pub(crate) dynamic_filter: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
                        Poll::Ready(true)
use native_bridge_common::log_debug;
                self.batch_offset += batch_len;
    /// panic), the IndexReader propagates an error instead of hanging forever.
        let driver = tokio::spawn(async move {
        // Inject computed __row_id__, or reorder/strip columns to match output schema.
impl IndexedStream {
use datafusion::arrow::record_batch::RecordBatch;
                    //
                    match &position_map {
        fn prefetch_rg(
 * The OpenSearch Contributors require contributions made to
                    let rg = prefetched.rg;
                            self.current_mask = if min_skip_run == 1 {
            None => &UNIT,
    store: Arc<dyn object_store::ObjectStore>,
use datafusion::physical_plan::metrics::{ExecutionPlanMetricsSet, MetricsSet};
            .expect("driver task panicked");
    }
        self.schema.clone()
            if self.coalescer_finished {
                    // there's no safety net if pushdown misbehaves on a
        self.pending_prefetch = Some(handle);
                        .as_any()
                        std::task::Poll::Ready(v) => std::task::Poll::Ready(Some(
    /// Used by `on_batch_mask` to translate the batch-coordinate under
/*
                        )),
            loop {
                log_debug!(
                            }
        };
                }
                    self.current_rg_context = Some(prefetched.prefetched.context);
            index: 0,
    /// Per-query cancellation token. Checked before each row group is dispatched
                    // tree path's on_batch_mask can reach into candidate-stage
            // Poll for next row group
            global_base,
            Some(super::row_id_injection::RowIdContext {
 * SPDX-License-Identifier: Apache-2.0
        let dynamic_rg_pruner = super::dynamic_filter::DynamicRgPruner::new(
                    "query cancelled".to_string(),
                            // only if the evaluator consumes it.
            return Poll::Pending;
                batch_len,
        if selectivity < self.min_skip_run_selectivity_threshold {
                    }
                let done = futures::future::poll_fn(|cx| match reader.poll_next_row_group(cx) {
        prune: Option<(
    }
    }
    /// each `poll_next_row_group`). When present, `start_prefetch` checks it
            rg.index,
        metadata: Arc<ParquetMetaData>,
        tokio::time::sleep(Duration::from_millis(250)).await;
                    }
                    }
    min_skip_run_selectivity_threshold: f64,
                        }
                    let selection = build_row_selection_with_min_skip_run(
                        // If we had parked on this receiver, account the
        };
    }
    evaluator: Arc<dyn RowGroupBitsetSource>,
                    let min_skip_run =
                if let Some(result) = poll_result {
//! # Post-decode mask (multi-filter tree path only)
    fn schema(&self) -> SchemaRef {
                match Pin::new(rx).poll(cx) {
    async fn cancel_stops_row_group_dispatch() {
            current_rg_idx: 0,
    fn poll_next(mut self: Pin<&mut Self>, cx: &mut Context<'_>) -> Poll<Option<Self::Item>> {
            // 1. Drain any completed batch from the coalescer first.
                        match status {
        };
                        cancelled_err_drv.store(true, Ordering::SeqCst);
            // Non-yielding busy work — mirrors a synchronous scan/decode poll.
        );
            output
            .collect();
                rg_idx,
                                let m = if let Some(buf) = prefetch_mask_buffer.as_ref() {
                        &candidates,
                        // Stream finished — collect inner parquet metrics
            seg_arrow_schema,
    use super::*;
                            c.add(1);
            if let Some(ref mut pruner) = self.dynamic_rg_pruner {
    }
            }
    file_size: u64,
        //       pushdown if that's None too).
        RowGroupStreamConfig {
    /// push_batch). Advances per-batch offsets (mask/batch) in lockstep.
            }
    /// prefetch-phase prune counter rather than `rg_skipped`.
            }
        }
        }
        ) -> Result<Option<BooleanArray>, String> {
    fn schema(&self) -> SchemaRef {
                Poll::Ready(Ok(Some(prefetched))) => {
        result
                .await;
            file_size: self.file_size,
                                .downcast_ref::<String>()
            self.min_skip_run_default
            full_schema: self.full_schema.clone(),
        self: Arc<Self>,
                        if let Some(ref t) = self.metrics.coalesce_time {
                            if let Some(ref t) = self.prefetch_wait_time {
            stream_start: None,
            _position_map: &PositionMap,
                }
                                        );
                        }
                        }
                        .map_err(|e| DataFusionError::ArrowError(Box::new(e), None))?;
                            continue;
                                        // through PositionMap.
            }
            _batch_offset: usize,
                            // loop forever and hang the calling Java thread.
            total_evaluated
                let indices: Vec<usize> = self
                        &selection,
                continue;
                .io_stats
                    }
pub struct IndexedExec {
        // this RG's parquet stats cannot match, skip BEFORE the (expensive)
        }
 */
        let evaluator = Arc::new(PanickingEvaluator {
                                        return Poll::Ready(Some(Err(e)));
        cx: &mut Context<'_>,
            self.index_reader.init_prefetch();
                                            0,
            evaluated_at_cancel,
            Err(e) => panic!("Tokio JoinError: {}", e),
        };
                    // landed in. Useful for tuning min_skip_run and
            let t0 = Instant::now();
            _rg: &RowGroupInfo,
        // 8 row groups × 200ms spin each = ~1.6s of work if cancellation is ignored.
                })
                index: i,
//! Unified streaming execution for indexed parquet reads.
use std::time::{Duration, Instant};
    /// page pruning and dynamic filter to avoid repeated `parquet_to_arrow_schema`.
        // Poll the reader — should complete with an error within the timeout.
            // If coalescer is finished but wasn't drained in step 1, the
                            Ok(b) => b,
            finished: false,
        // Lucene/FFM eval. Conservative — only skips on proof; the threshold
impl RecordBatchStream for IndexedStream {
            )?
use crate::datafusion_query_config::DatafusionQueryConfig;
            self.query_config.force_strategy,
                        }
                                    }
            metrics,
    /// snapshot against an RG's statistics before kicking off its Lucene eval.
    // async tasks at `.await` points. The tests below verify that the cancellation
        force_strategy: Option<FilterStrategy>,
        // without waking (the oneshot receiver isn't polled until next call).
            if let Some(result) = self.cached_result.take() {
            }
        // Two cases:
            dynamic_filter,
/// Override for the per-RG `min_skip_run` selectivity heuristic. `IndexedStream`
        match result.unwrap() {
    /// When true, the `___row_id` column is computed from position instead of read.
    /// Evaluator whose `prefetch_rg` busy-spins (no `.await`/sleep — genuine
            loop {
                Poll::Ready(Ok(None)) => {
                        Arc::clone(&candidates),
        if let Some(ref t) = self.metrics.on_batch_mask_time {
use datafusion::physical_plan::{
                                    self.coalescer_finished = true;
        let evaluator = Arc::new(SpinningEvaluator {
    RowSelection,
    /// polled (and returned Pending). Used to attribute wait time when
                        && !alignment_risk
        // The parquet reader delivers columns in the file's physical order which may
            self.full_schema.clone(),
                        self.batch_offset = 0;
                        self.pending_prefetch = None;
    cancellation_token: Option<tokio_util::sync::CancellationToken>,
        }
                                        vec.push(inner_metrics);
                    return;
                    Poll::Ready(Ok(Some(_))) => Poll::Ready(false),
        let cancelled_err_drv = cancelled_err.clone();
                    Poll::Ready(Ok(result)) => {
            Arc<ParquetMetaData>,
        // differ from the table schema order (e.g. when infer_schema sorted alphabetically).
        let handle = tokio::task::spawn_blocking(move || {
                    "[scf-segment-done] file={} row_groups={} elapsed={:?}",
            self.stream_metrics
//! of which evaluator produces the bitset.
                    // Poll-phase dynamic-filter prune (backstop): the filter may
    pub(crate) file_size: u64,
            object_path,
            &self,
            t.add_duration(t_on_batch.elapsed());
                            if let Some(ref c) = self.metrics.position_map_bitmap {
    /// Below this candidate selectivity, pin `min_skip_run = 1`
            .map(|i| RowGroupInfo {
            full_schema.clone(),
                // Unreachable in practice — step 1 already drained or
                    self.object_path.filename().unwrap_or("?"),
                        self.start_prefetch(self.current_rg_idx);
    pub(crate) store: Arc<dyn object_store::ObjectStore>,
            schema,
                match result {
impl Stream for IndexedStream {
            coalescer_finished: false,
            //    + evaluator), push into coalescer, loop.
                return Poll::Ready(Ok(None));
                token.as_ref(),
    }
    }
//! One `IndexedExec` and `IndexedStream` for all paths. Parameterized by
//!   stream for record batches.
    prefetched: PrefetchedRg,
                    .fields()
            row_groups,
    pub(crate) stream_metrics: StreamMetrics,
        let t_on_batch = Instant::now();
                            c.add(1);
    /// when no dynamic filter was pushed to this query.
                    // have tightened further since this RG was prefetched (~1 RG
                                Some(m)
            None,
        doc_range: Option<(i32, i32)>,
    }
                    return Poll::Ready(Some(Err(e)));
        Some(self.metrics.clone_inner())
        Self {
            f,
    /// `BooleanMask` → whole-RG select), bypassing the heuristic.
                    // with the decode. Delivered rows = candidate ∧
        &self.properties
        projection: Option<Vec<usize>>,
        static UNIT: () = ();
                            }
    /// (row-granular selection). Same hot-path discipline as above.
                    }
                    }
                    //
//!
                    let prefetch_mask_buffer = prefetched.prefetched.mask_buffer;
    /// Query-scoped tunables. Shared by Arc across IndexedExec instances
                return Poll::Ready(Some(Err(DataFusionError::Execution(
            }
type PrefetchResult = std::result::Result<PrefetchOutcome, String>;
/// Outcome of one prefetch task.
    /// before the Lucene eval ran, so it must be attributed to the
                    } else if let Some(ref counter) = self.metrics.min_skip_run_block_granular {
}
                if let Some(ref counter) = self.metrics.output_rows {
    }
mod tests {
            projection: self.projection.clone(),
 * this file be licensed under the Apache-2.0 license or a
                    // alignment/forbid checks below.
            // Poll current stream
        }
                    if self.dynamic_rg_pruner.is_some() {
//!   next-RG bitset is ready (or we wait briefly for it).
    pub(crate) properties: Arc<PlanProperties>,
    pub(crate) doc_range: Option<(i32, i32)>,
                        // Task was cancelled (runtime shutting down) — retry once
            total_evaluated <= evaluated_at_cancel + 1,
        // Sanity: it did NOT run all 8 row groups.
        loop {
            None,
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
            .await
            prefetch_wait_time,
            // 2. If upstream is done and coalescer has drained, we're done.
            "reader should terminate via the cancellation Err path"
    initialized: bool,
                    let t_plan = Instant::now();
        ) -> Result<Option<PrefetchedRg>, String> {
    /// `Ready(None)` ourselves.
                        // The spawn_blocking task failed to complete.
                            }
                    self.index_reader.row_groups.len(),
                batch_offset: self.batch_offset,
    /// Index in the output schema where computed `___row_id` is inserted.
            Some(prefetched) => Ok(PrefetchOutcome::Fetched(PrefetchedRowGroup {
            panic!(
        let row_groups: Vec<RowGroupInfo> = (0..8)
        }
                    if let Some(ref counter) = self.metrics.rg_processed {
    /// shared across sibling segment streams.
            )
        // At most one already-in-flight spawn_blocking job (non-abortable) can
                    }
                }
        call_count: AtomicUsize,
                    t.add_duration(t_poll.elapsed());
            if n == 0 {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
                    // parquet decode if now provably excluded. Conservative:
                        // RG had no candidates — skipped without a
            self.predicate.is_some(),
                        counter.add(candidates.len() as usize);
            _ => None,
            rgs_evaluated: rgs_evaluated.clone(),
                row_id_idx,
                        if join_error.is_panic() {
        predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        let eval_mask = self
                    );
impl ExecutionPlan for IndexedExec {
            None,
            Ok(Err(msg)) => {
    /// RG fetched with a non-empty candidate set.
        let empty_pos_map =
                    Poll::Ready(Some(Ok(_))) => continue,
        tokio::time::timeout(Duration::from_secs(10), driver)
    struct SpinningEvaluator {
            "Stream should complete with error, not hang (timeout)"
                        // JoinError distinguishes panic from cancellation.
            self.query_config.min_skip_run_selectivity_threshold,
    index_reader: IndexReader,
            let n = self.schema.fields().len();
    /// than `min_skip_run_default` (block-granular).
            None
                                let t_build = Instant::now();
        }
    /// masks, strip predicate columns to match output schema, and return
        prefetch_wait_time: Option<datafusion::physical_plan::metrics::Time>,
        //       misaligned indices. Ignore `current_mask`.
    ///
                                        build_mask(&candidates, &position_map)
                    Poll::Ready(Some(Err(e))) => return Poll::Ready(Some(Err(e))),
                let t_filter = Instant::now();
                } else {
    predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        )
        rgs_evaluated: Arc<AtomicUsize>,
}
    use std::time::Duration;
                    let candidates = prefetched.prefetched.candidates;
                        self.current_stream = None;
            metadata,
    pub(crate) row_groups: Vec<RowGroupInfo>,
                        .expect("BooleanArray.slice must remain BooleanArray");
        let index_reader = IndexReader::new(
                 Planner must drop performance peers under OR/NOT before fragment conversion."
}
                first_row: (i as i64) * 100,
            self.query_config.min_skip_run_default,
    #[allow(clippy::too_many_arguments)]
        let position_map = self.current_position_map.as_ref().unwrap_or(&empty_pos_map);
    /// against the target RG's stats and skips the Lucene eval if the RG is
                    if let Some(ref t) = self.metrics.mask_slice_time {
        }
        // reader terminated via the cancellation Err path.
        if !self.initialized {
        let evaluator = {
            while Instant::now() < deadline {
                    }
        cancellation_token: Option<tokio_util::sync::CancellationToken>,
    /// Per-query cancellation token. When cancelled, `IndexReader` stops
            None,
                t.add_duration(t0.elapsed());
                                    } else {
        }
        rg_skipped: Option<datafusion::physical_plan::metrics::Count>,
                            // Under row-granular (min_skip_run == 1) every
    impl RowGroupBitsetSource for SpinningEvaluator {
    }
                    // residual = exact output. Pushdown is ON.
}
        let total_evaluated = rgs_evaluated.load(Ordering::SeqCst);
            call_count: AtomicUsize::new(0),
        )>,
        }
                self.index_reader.dynamic_prune_ctx = pruner.current_pruning_predicate();
    /// will arrive; drain remaining completed batches."
    fn new(
    pub(crate) cancellation_token: Option<tokio_util::sync::CancellationToken>,
        let evaluated_at_cancel = rgs_evaluated.load(Ordering::SeqCst);
//! `Arc<dyn RowGroupBitsetSource>`; the streaming loop is identical regardless
        } else {
                        counter.add(pruned);
    /// Before the fix, `Poll::Ready(Err(_))` on the oneshot receiver would
                let t_poll = Instant::now();
            None,
            pending_prefetch: None,
                    vec![],
                self.mask_offset += batch_len;
    ///
                    msg
            self.doc_range,
            }
            .as_ref()
            &self,
            if self.current_rg_idx >= self.row_groups.len() {
            vec![rg_info],
    }
                            Ok(PushBatchStatus::LimitReached) => {
    full_schema: SchemaRef,
use super::eval::{PrefetchedRg, RowGroupBitsetSource};
use datafusion::physical_plan::coalesce::{LimitedBatchCoalescer, PushBatchStatus};
    /// parquet statistics cannot satisfy the (tightening) predicate. `None`
    metadata: Arc<ParquetMetaData>,
    pub(crate) store_url: datafusion::execution::object_store::ObjectStoreUrl,
        //       the candidate stage is a superset; the refinement mask is
                    Poll::Ready(Err(_)) => {
                        return Poll::Pending;
                t.add_duration(gap);
                                        // runs, so delivered rows don't map 1:1
        // Ask the evaluator for a refinement-stage mask on the UNFILTERED
// Indexed streams - Per segment stream
            let mask_offset_before = self.mask_offset.saturating_sub(batch_len);
            min_skip_run_default,
        row_id_output_index: Option<usize>,
                            }
            first_row: 0,
        let mut min_doc = rg.first_row as i32;
    doc_range: Option<(i32, i32)>,
//!
    BooleanMask,
            last_poll_end: None,
    /// Per-stream runtime dynamic-filter pruner. `None` when no dynamic filter
            None,
    /// may still complete; total evaluated is bounded to `evaluated_at_cancel + 1`.
            self.stream_start = Some(Instant::now());
                    // uses PositionMap on Collector leaves regardless of
        };
            (Some(ctx), Some(md)) => Some((ctx, Arc::clone(md))),
            _rg_state: &dyn std::any::Any,
                    // row-granular regime) and build_mask without cloning
                            // it. Under block/full regimes, build the mask
            }
            pending_since: None,
                // Upstream fully consumed; let the coalescer flush.
            //    batch. Loop to drain via next_completed_batch().
            self.file_size,
            rg: &RowGroupInfo,
            Self::fetch_row_group(
                self.coalescer_finished = true;
    #[inline]
        let token = tokio_util::sync::CancellationToken::new();
        match evaluator.prefetch_rg(&rg, min_doc, max_doc)? {
    }
    indexed_pushdown_filters: bool,
    store_url: datafusion::execution::object_store::ObjectStoreUrl,
    /// Baseline `min_skip_run` used when selectivity drives the choice (the
    use std::sync::Arc;
        assert!(
                                timer.add_duration(t_plan.elapsed());
impl fmt::Debug for IndexedExec {
/// Execution plan for a single segment chunk (1+ row groups from one segment).
            guard
struct IndexReader {
        selection: RowSelection,
                        // dropped (either via Collector intersection or
                    self.batch_offset = 0;
                                c.add(1);
                    }
        //       answer — apply `m` exclusively. Any `current_mask` from
        let poll_start = Instant::now();
        //       the exact result, and applying both would double-filter with
    /// receiver — idle wall-clock attributable to slow Lucene.
        let doc_range_str = match self.doc_range {
            self.stream_metrics.rg_skipped.clone(),
            _batch_len: usize,
                        // Push into coalescer under a timer.
                    return result;
    /// Counted once per RG whose prefetch returned `None` (candidate
    ) -> Result<SendableRecordBatchStream> {
            Arc::clone(&self.metadata),
        let batch_coalescer = LimitedBatchCoalescer::new(schema.clone(), target_batch_size, None);
    /// `target_batch_size` so downstream operators see fewer, larger
                    .schema
                let poll_result = Pin::new(stream).poll_next(cx);
    ) -> Self {
        let evaluator = Arc::clone(&index_reader.evaluator);
                                    if matches!(position_map, PositionMap::Identity { .. }) {
            let mut guard = self.evaluator.lock().unwrap();
                            c.add(1);
    rg: RowGroupInfo,
                    counter.add(batch.num_rows());
    pub(crate) seg_arrow_schema: SchemaRef,
            metadata,
                .take()
                let poll_result = futures::future::poll_fn(|cx| {
                        continue;
    /// atomic load); `None` token (untracked/test) is never cancelled.
            if let Some(ref t) = self.metrics.inter_poll_gap {
    /// batch if no rows survived (callers filter those out before
            None,
                                    build_mask(&candidates, &position_map)
            )
                    // ahead). Re-check against the latest snapshot; skip the
impl DisplayAs for IndexedExec {
    // `spawn_blocking` jobs cannot be aborted — tokio's task abort only cancels
                    let candidates = Arc::new(candidates);
            rg_skipped,
                                None
            self.query_config.batch_size,
    /// can reach into it during refinement (used by the multi-filter tree
                }
                        }
            _batch: &RecordBatch,
        let prune = match (self.dynamic_prune_ctx.clone(), self.metadata.as_ref()) {
            store: Arc::clone(&self.store),
            t.add_duration(t0.saturating_duration_since(poll_start));
                        // RG excluded by the dynamic filter before the Lucene
    type Item = Result<RecordBatch>;
            self.dynamic_filter.clone(),
        let evaluator = Arc::clone(&self.evaluator);
                        if let Some(ref c) = self.metrics.batches_pre_coalesce {
                        .with_row_count(Some(output.num_rows())),
                                    if let Ok(mut vec) = acc.lock() {
    #[tokio::test(flavor = "multi_thread", worker_threads = 4)]
                            self.current_position_map = Some(position_map);
            prefetch_wait_count,
                    // the underlying data.
            );
    current_rg_idx: usize,
                    Err(e) => return Poll::Ready(Err(DataFusionError::External(e.into()))),
                }
pub struct RowGroupInfo {
            indexed_pushdown_filters,
                            self.pending_since = Some(Instant::now());
                    // Metric: record which PositionMap variant this RG
            doc_range_str,
}
            Some(token.clone()),
    ) -> Poll<Option<Result<RecordBatch>>> {
                        PositionMap::Runs { .. } => {
            match self.index_reader.poll_next_row_group(cx) {
            // 3. If upstream signalled done and we haven't finished the
                        };
                    "[scf-segment-done] file={} row_groups={} elapsed={:?}",
            // Produce a non-empty candidate set so the RG is "Fetched".
    Pruned,
                            // Deterministic failure (e.g. subtree_cost invariant
                        if let Some(ref c) = self.dynamic_filter_rg_pruned_at_prefetch {
                eval_mask: eval_mask.clone(),
            .is_some_and(|t| t.is_cancelled())
        );
                    msg.contains("panicked"),
                                }
    dynamic_rg_pruner: Option<super::dynamic_filter::DynamicRgPruner>,
    global_base: u64,
            full_schema,
                        }
    pub(crate) evaluator: std::sync::Mutex<Option<Arc<dyn RowGroupBitsetSource>>>,
                        if let Some(ref c) = self.rg_skipped {
type PrefetchHandle = JoinHandle<PrefetchResult>;
    schema: SchemaRef,
                        return Poll::Pending;
            row_groups,
    fn init_prefetch(&mut self) {
        indexed_pushdown_filters: bool,
                            let payload = join_error.into_panic();
                                if let Some(ref acc) = self.metrics.inner_parquet_metrics {
            total_rows,
        });
            self.query_config.indexed_pushdown_filters,
            batch_offset: 0,
        });
                            Err(e) => return Poll::Ready(Some(Err(e))),
//! DataFusion's own predicate pushdown filtered during decode), we emit
                                } else {
            _batch_len: usize,
                    let mask_slice = mask_slice
                    let t_slice = Instant::now();
            self.row_groups.len(),
        row_groups: &[RowGroupInfo],
        // for this chunk, so batch_offset is row-index-within-RG and the
                position_map,
            current_rg_context: None,
    pub(crate) metadata: Arc<ParquetMetaData>,
use std::sync::Arc;
                    "Error should mention panic, got: {}",
                match poll_result {
//! If `evaluator.on_batch_mask()` returns `Some(mask)`, we apply it via
                        self.pending_since = None;
    /// Result of a prefetch task. `Pruned` is distinct from `Ok(None)`
    current_position_map: Option<PositionMap>,
//! # Per-RG streaming with prefetch overlap
            if let Some(ref t) = self.metrics.init_prefetch_time {
            None,
                    Poll::Ready(Ok(None)) => Poll::Ready(true),
        match self.force_strategy {
        }
                                            buf.clone(),
        _children: Vec<Arc<dyn ExecutionPlan>>,
    /// Node-wide default from the `datafusion.indexed.pushdown_filters`
                    Ok(PrefetchOutcome::Empty) => {
        if rg_idx >= self.row_groups.len() {
    last_poll_end: Option<Instant>,
                batch_len,
                log_debug!(
}
            evaluator,
    /// Cached per-segment arrow schema derived from parquet footer. Used by
    /// True when this query's task has been cancelled. Cheap (one relaxed
            let mut candidates = RoaringBitmap::new();
                    filtered
    fn create_row_selection_stream(
        };
        }
        );
}
        token.cancel();
    /// Optional runtime dynamic filter (TopK / join) accepted via physical
                            }
    coalescer_finished: bool,
                            // violation). Propagate immediately — retrying would
            }
    /// Per-RG state carried from `PrefetchedRg.context` so `on_batch_mask`
                        }
    /// `None` disables cancellation checks.
    }
            }
    /// skipped without a parquet read. Attributed to `rg_skipped`.
            result.is_ok(),
    /// is worth skipping (`min_skip_run = 1`, row-granular); at higher selectivity
    rg_skipped: Option<datafusion::physical_plan::metrics::Count>,
    pending_prefetch: Option<PrefetchHandle>,
            }
        store_url: datafusion::execution::object_store::ObjectStoreUrl,
    pub(crate) predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
                            (rg.num_rows as usize).saturating_sub(candidates.len() as usize);
pub enum FilterStrategy {
    }
    fn metrics(&self) -> Option<MetricsSet> {
    /// When true, the `___row_id` column is computed from position.
                        // eval ran — the prefetch-phase win.
                            Ok(PushBatchStatus::Continue) => continue,
                    // Pushdown decision:
            num_rows: 100,
            .evaluator
                                        // to RG positions. Must build the mask
                "invariant violation: DelegationPossible reached subtree_cost. \
                        if self.pending_since.is_none() {
                        std::task::Poll::Pending => std::task::Poll::Ready(None),
                        }
    #[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        let result = self.as_mut().poll_inner(cx);
            let deadline = Instant::now() + self.spin;
/// normally picks `min_skip_run` from candidate selectivity; setting
                            if let Some(ref c) = self.prefetch_wait_count {
    current_rg_first_row: i64,
            if ctx.rg_provably_excluded(metadata, rg.index) {
        });
        }
        }
    fn name(&self) -> &str {
use datafusion_common::DataFusionError;
                    batch
    /// path to access per-leaf bitmaps keyed by `Arc::as_ptr` identity).
                    Poll::Pending => {
        vec![]
                                c.add(1);
        seg_arrow_schema: SchemaRef,
                continue;
                            }
            }
        emit_row_ids: bool,
                                    if let Err(e) = self.batch_coalescer.finish() {
                self.upstream_done = true;
    /// the receiver eventually resolves.
        //
                        let pruned =
            .expect("reader should terminate promptly after cancel")
    fn fmt_as(&self, _t: DisplayFormatType, f: &mut fmt::Formatter) -> fmt::Result {
                if let Some(ref counter) = self.metrics.batches_produced {
                &self.schema,
    /// Per-RG `min_skip_run` decision.
        });
            self.stream_metrics.prefetch_wait_count.clone(),
    fn is_cancelled(&self) -> bool {
                .clone()
            projection,
                    if let Some(ref counter) = self.metrics.rows_pruned {
                                c.add(1);
            Arc::clone(&self.store),
            current_mask: None,
                .ok_or_else(|| DataFusionError::Internal("evaluator already consumed".into()))?
        );
impl IndexReader {
        // Snapshot-so-far + metadata, moved into the blocking task so the
                        // start the wait-clock.
                    let position_map = PositionMap::from_candidates_with_selection(
                            self.mask_offset = 0;
}
            // Stop draining on cancellation; surfaces as a query-level error (no partial results).
                if done {
                    // Carried through to finalize_batch so the multi-filter
            dynamic_filter_rg_pruned_at_prefetch,
                tokio::time::sleep(Duration::from_millis(10)).await;
    }
    evaluator: Arc<dyn RowGroupBitsetSource>,
    /// provably excluded. `None` when no dynamic filter was pushed.
    struct PanickingEvaluator {
        push_predicate: bool,
        min_skip_run_default: usize,
            self.stream_metrics.prefetch_wait_time.clone(),
                        if pruner.should_prune_rg(&metadata, rg.index) {
}
                    let r = reader.poll_next_row_group(cx);
    /// Verifies that when `prefetch_rg` panics (simulating the subtree_cost
            })),
use std::any::Any;
        // prefetch-phase prune runs off the poll thread.
            let gap = poll_start.saturating_duration_since(prev_end);
}
                    Poll::Ready(None) => {
            self.rgs_evaluated.fetch_add(1, Ordering::SeqCst);
    /// block-granular `RowSelection`. Rebuilt each RG from the selection
        let cancelled_err = Arc::new(AtomicBool::new(false));
            None,
        assert!(
    /// Pluggable bitset source (SingleCollector or RustTree).
        // complete after cancel; all others must be skipped by the checkpoint.
        // ANALYZE, separate from `index_time` / `parquet_time` which
                    // stays comparable.
            batch_coalescer,
        }
    /// a DataFusionError so the Java search thread unblocks.
    }
                if let Err(e) = self.batch_coalescer.finish() {
                    self.finished = true;
use datafusion::execution::SendableRecordBatchStream;
                    match &r {
                )?
        _partition: usize,
        }
            .finish()
                    self.upstream_done = true;
            None => Ok(PrefetchOutcome::Empty),
                                self.current_rg_idx, panic_msg
                    // `with_predicate` applies the residual in lockstep
                                if let Some(ref t) = self.metrics.build_mask_time {
                    // strategy, and because the outer FilterExec is
                    }
                    self.schema.clone(),
        global_base: u64,
            self.call_count.fetch_add(1, Ordering::SeqCst);
                    if let Some(ref t) = self.metrics.filter_record_batch_time {
            self.row_id_output_index,
    /// Time the poll thread spent in `Poll::Pending` on the prefetch
        store: Arc<dyn object_store::ObjectStore>,
    row_groups: Vec<RowGroupInfo>,
            evaluator,
use datafusion::arrow::array::{Array, BooleanArray, UInt64Array};
                            return Poll::Ready(Err(DataFusionError::Execution(format!(
                    let filtered = filter_record_batch(&batch, mask_slice)
                        }
            if self.coalescer_finished && self.batch_coalescer.is_empty() {
        if let Some((range_min, range_max)) = doc_range {
            _rg_first_row: i64,
                assert!(
            None,
        //       `current_mask` from the candidate stage (or DataFusion
            Some(FilterStrategy::BooleanMask) => return rg_num_rows + 1,
                            if let Some(ref c) = self.metrics.position_map_identity {
            self.predicate.clone(),
                        PositionMap::Identity { .. } => {
    /// dispatching further row groups and `IndexedStream` stops draining.
            None,
        );
                rg,
}
                    let mask_slice = mask.slice(self.mask_offset, batch_len);
                    t.add_duration(t_filter.elapsed());
    }
    /// we handed to parquet.
            super::row_id_injection::inject_row_ids(
    prefetch_wait_time: Option<datafusion::physical_plan::metrics::Time>,
        let t0 = Instant::now();
impl IndexedStream {
    fn pick_min_skip_run(&self, num_candidates: usize, rg_num_rows: usize) -> usize {
    }
/// Streams RGs one at a time with prefetch overlap.
                let filtered = filter_record_batch(&batch, &mask)
            }
        // Let a couple of row groups start evaluating, then cancel.
            }
                        }
                            }
            self.projection.clone(),
                    self.stream_start.unwrap().elapsed()
    impl RowGroupBitsetSource for PanickingEvaluator {
        let mut max_doc = (rg.first_row + rg.num_rows) as i32;
        }
                    if let Some(ref timer) = self.metrics.index_time {
            mask_offset: 0,
use super::parquet_bridge::{self, RowGroupStreamConfig};
        parquet_bridge::create_row_selection_stream(
    /// cloned from the stream's `PartitionMetrics`.
                    // Node-wide `indexed_pushdown_filters` setting, gated by
            Some((min, max)) => format!(", doc_range=[{}, {})", min, max),
        dynamic_filter_rg_pruned_at_prefetch: Option<datafusion::physical_plan::metrics::Count>,
                    }
                                c.add(1);
        //   (B) `on_batch_mask` returns None (single-collector path). Use
            file_size,
            return Ok(PrefetchOutcome::Empty);
                            // so the mask would be all-true — skip building
                &output,
                        let status = self.batch_coalescer.push_batch(filtered);
                let current = if let Some(ref mask) = self.current_mask {
                    Poll::Pending => Poll::Ready(false),
            self.row_groups.clone(),
            self.seg_arrow_schema.clone(),
                output.project(&indices)?
    pub first_row: i64,
        assert!(
            .field("row_groups", &self.row_groups.len())
                                c.add(1);
            candidates.insert_range(0..rg.num_rows as u32);
        let row_groups = self.row_groups.clone();
        Ok(self)
#[derive(Debug, Clone, Copy, PartialEq)]
                self.current_rg_idx += 1;
                        t.add_duration(t_filter.elapsed());
                }
                                continue;
    pub index: usize,
                        self.cached_result = Some(result);
    }
                                }
        // Bail before the expensive evaluator.prefetch_rg if the query was
                                    t.add_duration(t_build.elapsed());
                }
                                .cloned()
    /// pushdown, referencing the sort columns. Used to prune row groups whose
                        let metadata = Arc::clone(&self.metadata);
        evaluator: Arc<dyn RowGroupBitsetSource>,
                    // Metrics: track which regime we landed in, using the
//! - `IndexReader` runs `evaluator.prefetch_rg(rg)` in a background task.
    fn poll_inner(
                )));
                        t.add_duration(t_slice.elapsed());
        mut self: Pin<&mut Self>,
/// `force_strategy` to one of these variants pins the choice node-wide.
    /// `None` only in unit tests that don't exercise dynamic-filter pruning.
    }
            super::dynamic_filter::RgPruningContext,
                    self.current_rg_first_row = rg.first_row;
                        rg.num_rows as usize,
    /// counting how many row groups it actually evaluated.
                            };
                        && !self.evaluator.forbid_parquet_pushdown();
            current_inner_plan: None,
    /// `next_completed_batch`.
        // time downstream work.
                base: self.global_base + self.current_rg_first_row as u64,
                    // `current_mask` over delivered rows, or the
        loop {
        let rg_state: &dyn std::any::Any = match &self.current_rg_context {
        self.last_poll_end = Some(t0);
                    counter.add(1);
    /// (empty candidate set): it means the dynamic filter excluded the RG
    fn children(&self) -> Vec<&Arc<dyn ExecutionPlan>> {
                            } else {
                self.current_rg_first_row,
}
        let mut reader = IndexReader::new(
        }
            store,
                prune,
    ) -> Self {
            }
    }
    /// calling it twice (assert panic) and to signal "no more input
            self.initialized = true;
//! the batch as-is.
        // Drive the reader exactly like IndexedStream does. Records whether the
                        }
                                }
            store_url,
            return;
    /// Cumulative row offset for this segment within the shard.
/// Row group metadata.
                    // understanding per-query memory profiles.
        let row_id_ctx = if self.row_id_output_index.is_some() {
                current
                    // BitmapTreeEvaluator because its `on_batch_mask`
                if let Some(ref t) = self.metrics.filter_record_batch_time {
                RecordBatch::try_new_with_options(
    finished: bool,
        if let Some(ref t) = self.metrics.projection_fixup_time {
        f.debug_struct("IndexedExec")
                    // Block-granular (min_skip_run > 1): RowSelection
                                .unwrap_or_else(|| "unknown panic".into());
        ) -> Result<Option<BooleanArray>, String> {
                        counter.add(1);
        fn on_batch_mask(
                            if let Some(ref c) = self.metrics.position_map_runs {
    /// only path in production; tests may pin it via `force_strategy`).
enum PrefetchOutcome {
            &self,
            .on_batch_mask(
    fn properties(&self) -> &Arc<PlanProperties> {
                                None
        //   (A) `on_batch_mask` returns Some(m). The evaluator owns the final
                &row_groups,
        let doc_range = self.doc_range;
                };
            //    coalescer yet, finish it so it flushes its final buffered
                .dynamic_filter_rg_pruned_at_prefetch
    upstream_done: bool,
    }
    /// `None` when `emit_row_ids=false` or `___row_id` is not in projection.
            Ok(Ok(_)) => panic!("Stream should return Err when prefetch panics, got Ok"),
            dynamic_rg_pruner,
                    self.mask_offset += batch_len;
    Empty,
    /// Cancelling mid-scan stops `poll_next_row_group` from dispatching further
                    // same counters as before so `EXPLAIN ANALYZE` output
    /// Snapshot of the runtime dynamic filter (refreshed by the stream before
                                            rg.num_rows as usize,
    fn bridge_config(&self) -> RowGroupStreamConfig {
            _position_map: &PositionMap,
                }
                // step 2 already returned. Defensive.
            }
        cancellation_token: Option<&tokio_util::sync::CancellationToken>,
            if self.finished {
    Fetched(PrefetchedRowGroup),
                        Ok((stream, plan)) => {
            // top-of-loop `is_empty` check ends it on the next turn.
                    }
//! `filter_record_batch`. If it returns `None` (single-collector path:
                        let pruner = self.dynamic_rg_pruner.as_mut().unwrap();
            &self,
    /// Output coalescer — combines small post-filter batches up to
            evaluator.clone(),
        if cancellation_token.is_some_and(|t| t.is_cancelled()) {
        };
                            }
                }
            "cancelled reader kept evaluating row groups: evaluated_at_cancel={}, total_evaluated={}",
                        self.current_rg_context = None;
