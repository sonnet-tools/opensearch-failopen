}
            batches_produced: counter("batches_produced"),
    pub fn new(metrics: &ExecutionPlanMetricsSet, partition: usize) -> Self {
    pub rows_pruned_by_page_index: Count,
    pub projection_fixup_time: Time,
    pub index_time: Option<Time>,
 * The OpenSearch Contributors require contributions made to
    pub mask_slice_time: Option<Time>,
    /// before mask filtering.
            inter_poll_gap: MetricBuilder::new(metrics).subset_time("inter_poll_gap", partition),
/// Per-partition metrics registered against the parent `ExecutionPlanMetricsSet`.
            parquet_poll_time: None,
    Count, ExecutionPlanMetricsSet, MetricBuilder, MetricsSet, Time,
    pub rg_bloom_pruned: Count,
//! Metrics for indexed search execution plans.
    pub position_map_bitmap: Option<Count>,
pub struct PartitionMetrics {
            position_map_identity: Some(self.position_map_identity),
            batches_produced: None,
    pub filter_record_batch_time: Option<Time>,
    pub rows_pruned: Option<Count>,
        StreamMetrics {
            inner_parquet_metrics,
    pub rg_skipped: Option<Count>,
            page_pruning_unavailable: None,
#[derive(Clone)]
    pub dynamic_filter_rg_pruned_at_prefetch: Option<Count>,
            rg_bloom_pruned: counter("rg_bloom_pruned"),
            prefetch_wait_count: None,
    /// batch.
            parquet_time: None,
    /// Wall-clock time the poll thread spent blocked on the oneshot
    pub io_stats: Option<Arc<ReadIoStats>>,
            parquet_batches_received: Some(self.parquet_batches_received),
            pages_total: counter("pages_total"),
    /// Number of RGs whose `PositionMap` was the `Runs` variant
            rows_matched: counter("rows_matched"),
    pub index_time: Time,
            mask_slice_time: None,
/*
            parquet_time: MetricBuilder::new(metrics).subset_time("parquet_read_time", partition),
            coalesce_time: Some(self.coalesce_time),
                .subset_time("prefetch_wait_time", partition),
            init_prefetch_time: MetricBuilder::new(metrics)
    /// Time spent slicing + downcasting the current_mask per input
    pub output_rows: Count,
    pub bloom_filter_eval_time: Option<Time>,
            on_batch_mask_time: None,
/// under a multi-segment parent) have no shared parent metrics to update.
    /// Cumulative count of `poll_next` invocations across all chunk streams.
    /// Row groups pruned by bloom filter (value proven absent).
            page_pruning_unavailable: Some(self.page_pruning_unavailable),
            init_prefetch_time: None,
    pub min_skip_run_block_granular: Option<Count>,
    pub position_map_bitmap: Count,
 * SPDX-License-Identifier: Apache-2.0
    pub inter_poll_gap: Time,
    /// (row-granular; row-to-rg-pos via `RoaringBitmap::select`).
    pub dynamic_filter_rg_pruned_at_poll: Option<Count>,
                .subset_time("on_batch_mask_time", partition),
            position_map_runs: counter("position_map_runs"),
            parquet_poll_time: MetricBuilder::new(metrics)
    pub fn into_stream_metrics(
            rg_processed: Some(self.row_groups_processed),
            output_rows: MetricBuilder::new(metrics).output_rows(partition),
    /// Total parquet pages considered by the page-level pruner. Ratio
            output_rows: None,
    pub rg_bloom_pruned: Option<Count>,
            ffm_collector_calls: counter("ffm_collector_calls"),
impl StreamMetrics {
    pub position_map_identity: Option<Count>,
            poll_count: Some(self.poll_count),
//! - [`StreamMetrics`] — lightweight handles passed to each RG stream for recording.
    /// `next_completed_batch`. Helps isolate coalescing overhead.
    pub build_mask_time: Option<Time>,
    /// Time spent in `build_mask` (once per RG — builds RG-sized
            io_stats: Some(Arc::new(ReadIoStats::default())),
 *
    /// The task returned `Poll::Pending` or was not re-polled immediately;
    ) -> StreamMetrics {
    pub dynamic_filter_rg_pruned_at_poll: Count,
    pub row_groups_processed: Count,
    /// Divergence from `parquet_batches_received` indicates refinement
            index_time: MetricBuilder::new(metrics).subset_time("index_query_time", partition),
    /// (whole-RG selected, no skips).
    pub min_skip_run_row_granular: Option<Count>,
            position_map_identity: counter("position_map_identity"),
            parquet_poll_time: Some(self.parquet_poll_time),
                .subset_time("projection_fixup_time", partition),
            projection_fixup_time: None,
            rows_matched: None,
    pub row_groups_skipped: Count,
            elapsed_compute: MetricBuilder::new(metrics).elapsed_compute(partition),
    /// Time spent in `filter_record_batch` per input batch.
            coalesce_time: MetricBuilder::new(metrics).subset_time("coalesce_time", partition),
    pub output_rows: Option<Count>,
};
            filter_record_batch_time: Some(self.filter_record_batch_time),
            parquet_batches_received: counter("parquet_batches_received"),
    /// Count of `RecordBatch`es received from the inner parquet stream,
    pub batches_produced: Count,
    /// `MetricsSet` per chunk (row-group set) the partition scans.
    /// Convert into `StreamMetrics` for passing to the streaming loop.
        inner_parquet_metrics: Option<Arc<std::sync::Mutex<Vec<MetricsSet>>>>,
    /// Count of batches fed into the coalescer (before combining).
            rg_bloom_pruned: None,
        }
            build_mask_time: MetricBuilder::new(metrics).subset_time("build_mask_time", partition),
            position_map_runs: None,
            inter_poll_gap: Some(self.inter_poll_gap),
    /// PREFETCH phase — before the Lucene/FFM eval ran. This saves both the
            row_groups_processed: counter("row_groups_processed"),
    pub prefetch_wait_count: Count,
    /// Cumulative wall-clock spent parked between consecutive `poll_next` calls.
}
            batches_produced: Some(self.batches_produced),
    pub projection_fixup_time: Option<Time>,
    pub ffm_collector_calls: Option<Count>,
            bloom_filter_eval_time: Some(self.bloom_filter_eval_time),
            bloom_filter_eval_time: MetricBuilder::new(metrics)
            min_skip_run_row_granular: None,
pub struct StreamMetrics {
    /// Time spent in the projection fix-up at the bottom of
    /// prefetch (which runs ~1 RG ahead) and processing.
}
            index_time: None,
            index_time: Some(self.index_time),
            io_stats: None,
    pub poll_count: Option<Count>,
    /// Count of parquet pages the page-level pruner eliminated across
            dynamic_filter_rg_pruned_at_poll: Some(self.dynamic_filter_rg_pruned_at_poll),
    /// with upstream work; non-zero indicates idle time.
            rg_processed: None,
    /// Count of `Poll::Pending` returns from the prefetch receiver (times
                .subset_time("parquet_poll_time", partition),
    /// Time spent in the initial `init_prefetch()` call (first poll only).
            rows_matched: Some(self.rows_matched),
    pub pages_pruned: Count,
    pub rows_matched: Option<Count>,
    pub parquet_time: Option<Time>,
    pub inter_poll_gap: Option<Time>,
            page_pruning_unavailable: counter("page_pruning_unavailable"),
            prefetch_wait_time: Some(self.prefetch_wait_time),
                .subset_time("filter_record_batch_time", partition),
    pub position_map_identity: Count,
    /// Count of row groups skipped by the runtime dynamic-filter pruner at the
            ffm_collector_calls: Some(self.ffm_collector_calls),
    pub init_prefetch_time: Option<Time>,
    pub min_skip_run_block_granular: Count,
    /// batch), isolating decode from our own processing.
            coalesce_time: None,
    pub parquet_batches_received: Option<Count>,
    /// Time spent in bloom filter IO + evaluation across all RGs.
    /// visible here).
    /// Wall-clock time spent inside `LimitedBatchCoalescer::push_batch` +
    pub rows_matched: Count,
    /// Count of output `RecordBatch`es emitted from `poll_next`.
    /// `finalize_batch` (strip predicate columns).
            batches_pre_coalesce: None,
    /// BooleanArray from candidate RoaringBitmap via PositionMap).
    /// Count of `prune_rg` calls that couldn't apply pruning (no page
    pub page_pruning_unavailable: Count,
    pub batches_pre_coalesce: Count,
            pages_total: Some(self.pages_total),
    /// `pages_pruned / pages_total` gives pruning effectiveness.
//! - [`PartitionMetrics`] — registered against the parent `ExecutionPlanMetricsSet`,
            build_mask_time: Some(self.build_mask_time),
            build_mask_time: None,
    pub on_batch_mask_time: Option<Time>,
            inner_parquet_metrics: None,
///
            output_rows: Some(self.output_rows),
            min_skip_run_block_granular: counter("min_skip_run_block_granular"),
            pages_total: None,
    pub poll_count: Count,
            inter_poll_gap: None,
            dynamic_filter_rg_pruned_at_prefetch: counter("dynamic_filter_rg_pruned_at_prefetch"),
    /// stage filtering (empty batches dropped).
    /// (returns None on pure-collector paths; cost of dispatch is
    pub elapsed_compute: Time,
    pub dynamic_filter_rg_pruned_at_prefetch: Count,
}
    pub position_map_runs: Option<Count>,
            rows_pruned_by_page_index: counter("rows_pruned_by_page_index"),
        Self {
            batches_pre_coalesce: counter("batches_pre_coalesce"),
    /// RGs where `min_skip_run == 1` — row-granular RowSelection.
            rg_bloom_pruned: Some(self.rg_bloom_pruned),
    pub init_prefetch_time: Time,
 * this file be licensed under the Apache-2.0 license or a
    pub position_map_runs: Count,
    pub coalesce_time: Time,
    pub batches_produced: Option<Count>,
use crate::indexed_table::parquet_bridge::ReadIoStats;
            min_skip_run_block_granular: Some(self.min_skip_run_block_granular),
            position_map_runs: Some(self.position_map_runs),
    /// all RGs in this partition.
    /// Object-store read wall-time accumulator, shared across all RG readers
            mask_slice_time: MetricBuilder::new(metrics).subset_time("mask_slice_time", partition),
    /// expression). Diagnostic: high values mean pruning isn't happening.
    }
    pub on_batch_mask_time: Time,
//!   visible in `EXPLAIN ANALYZE`.
    pub min_skip_run_row_granular: Count,
            elapsed_compute: Some(self.elapsed_compute),
use datafusion::physical_plan::metrics::{
            poll_count: counter("poll_count"),
        let counter = |name: &'static str| MetricBuilder::new(metrics).counter(name, partition);
    pub pages_pruned: Option<Count>,
    /// Time spent polling the inner parquet stream (pull decoded
    pub pages_total: Count,
            pages_pruned: Some(self.pages_pruned),
    /// Collector leaf per RG. This is the highest per-query cost
            poll_count: None,
            pages_pruned: None,
            position_map_bitmap: Some(self.position_map_bitmap),
            on_batch_mask_time: Some(self.on_batch_mask_time),
    pub parquet_time: Time,
        }
            mask_slice_time: Some(self.mask_slice_time),
            filter_record_batch_time: MetricBuilder::new(metrics)
            position_map_bitmap: None,
//!
    pub rg_processed: Option<Count>,
/// Lightweight metric handles passed from `IndexedExec` to the streaming loop.
    /// Number of RGs whose `PositionMap` was the `Identity` variant
            prefetch_wait_time: None,
            on_batch_mask_time: MetricBuilder::new(metrics)
            dynamic_filter_rg_pruned_at_poll: None,
    /// FFM round-trips into the Java backend collector. Once per
        Self {
            position_map_bitmap: counter("position_map_bitmap"),
 */
            rg_skipped: None,
    /// (block-granular; explicit run table).
    }
    pub page_pruning_unavailable: Option<Count>,
    /// RGs where `min_skip_run > 1` — block-granular (coarser) RowSelection.
            bloom_filter_eval_time: None,
    /// within this partition.
    pub fn empty() -> Self {
            prefetch_wait_count: counter("prefetch_wait_count"),
            prefetch_wait_time: MetricBuilder::new(metrics)
    pub bloom_filter_eval_time: Time,
    pub elapsed_compute: Option<Time>,
    pub parquet_poll_time: Time,
            ffm_collector_calls: None,
            rows_pruned: None,
            parquet_batches_received: None,
    pub pages_total: Option<Count>,
            row_groups_skipped: counter("row_groups_skipped"),
    /// receiver for a pending prefetch. Zero if prefetch fully overlapped
            filter_record_batch_time: None,
    /// RGs that became prunable only after the filter tightened further between
    /// accumulated into this metric at the start of each poll.
    pub parquet_poll_time: Option<Time>,
            parquet_time: Some(self.parquet_time),
    pub prefetch_wait_time: Time,
            rows_pruned: Some(self.rows_pruned_by_page_index),
            dynamic_filter_rg_pruned_at_poll: counter("dynamic_filter_rg_pruned_at_poll"),
            init_prefetch_time: Some(self.init_prefetch_time),
            min_skip_run_row_granular: Some(self.min_skip_run_row_granular),
/// All fields are `Option` because standalone uses of `IndexedExec` (i.e. not
 * compatible open source license.
    pub inner_parquet_metrics: Option<Arc<std::sync::Mutex<Vec<MetricsSet>>>>,
    /// Count of row groups skipped by the runtime dynamic-filter pruner at the
            dynamic_filter_rg_pruned_at_prefetch: None,
    pub parquet_batches_received: Count,
impl PartitionMetrics {
            elapsed_compute: None,
    /// index, column missing, or `PruningPredicate` rejected the
            dynamic_filter_rg_pruned_at_prefetch: Some(self.dynamic_filter_rg_pruned_at_prefetch),
    pub mask_slice_time: Time,
            pages_pruned: counter("pages_pruned"),
    /// component, useful for tuning backend query shapes.
    pub build_mask_time: Time,
            projection_fixup_time: Some(self.projection_fixup_time),
    /// the poll thread had to park waiting for Lucene).
    /// index eval and the parquet decode. Zero when no dynamic filter was pushed.
            position_map_identity: None,
    pub batches_pre_coalesce: Option<Count>,
use std::sync::Arc;
    pub ffm_collector_calls: Count,
    /// No-op metrics for standalone execution.
                .subset_time("init_prefetch_time", partition),
            min_skip_run_block_granular: None,
            prefetch_wait_count: Some(self.prefetch_wait_count),
    /// Time spent in evaluator's `on_batch_mask` per input batch
    /// POLL phase — after the Lucene/FFM eval but before parquet decode. Catches
        self,
    pub prefetch_wait_time: Option<Time>,
    pub prefetch_wait_count: Option<Count>,
            min_skip_run_row_granular: counter("min_skip_run_row_granular"),
    pub coalesce_time: Option<Time>,
            batches_pre_coalesce: Some(self.batches_pre_coalesce),
    pub filter_record_batch_time: Time,
            rg_skipped: Some(self.row_groups_skipped),
    /// Inner `DataSourceExec` parquet metrics for this partition: one
                .subset_time("bloom_filter_eval_time", partition),
    /// Number of RGs whose `PositionMap` was the `Bitmap` variant
        }
    }
            projection_fixup_time: MetricBuilder::new(metrics)
