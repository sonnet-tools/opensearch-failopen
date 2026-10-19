    }
            parquet_poll_time: None,
    pub min_skip_run_row_granular: Count,
    /// Time spent in the initial `init_prefetch()` call (first poll only).
    }
            build_mask_time: Some(self.build_mask_time),
        Self {
            index_time: MetricBuilder::new(metrics).subset_time("index_query_time", partition),
            projection_fixup_time: Some(self.projection_fixup_time),
            prefetch_wait_count: None,
                .subset_time("init_prefetch_time", partition),
    pub fn into_stream_metrics(
    pub index_time: Time,
            dynamic_filter_rg_pruned_at_prefetch: counter("dynamic_filter_rg_pruned_at_prefetch"),
            ffm_collector_calls: counter("ffm_collector_calls"),
///
    pub mask_slice_time: Option<Time>,
use datafusion::physical_plan::metrics::{
                .subset_time("parquet_poll_time", partition),
    /// Cumulative wall-clock spent parked between consecutive `poll_next` calls.
    /// Time spent in `build_mask` (once per RG — builds RG-sized
    pub batches_produced: Option<Count>,
    /// within this partition.
    /// Inner `DataSourceExec` parquet metrics for this partition: one
    pub rows_matched: Option<Count>,
    pub on_batch_mask_time: Option<Time>,
    pub min_skip_run_row_granular: Option<Count>,
    /// Divergence from `parquet_batches_received` indicates refinement
            bloom_filter_eval_time: None,
    /// component, useful for tuning backend query shapes.
            poll_count: Some(self.poll_count),
            dynamic_filter_rg_pruned_at_poll: None,
            rows_pruned_by_page_index: counter("rows_pruned_by_page_index"),
//! - [`PartitionMetrics`] — registered against the parent `ExecutionPlanMetricsSet`,
    /// Count of batches fed into the coalescer (before combining).
    pub rows_pruned_by_page_index: Count,
            prefetch_wait_time: MetricBuilder::new(metrics)
    pub pages_total: Count,
            index_time: None,
        self,
    /// Cumulative count of `poll_next` invocations across all chunk streams.
            pages_pruned: Some(self.pages_pruned),
            prefetch_wait_count: counter("prefetch_wait_count"),
            parquet_batches_received: counter("parquet_batches_received"),
        StreamMetrics {
    /// accumulated into this metric at the start of each poll.
    pub position_map_identity: Count,
    /// RGs where `min_skip_run == 1` — row-granular RowSelection.
    /// (whole-RG selected, no skips).
    pub batches_pre_coalesce: Count,
 * compatible open source license.
    /// Count of row groups skipped by the runtime dynamic-filter pruner at the
            row_groups_processed: counter("row_groups_processed"),
    /// RGs where `min_skip_run > 1` — block-granular (coarser) RowSelection.
            parquet_batches_received: Some(self.parquet_batches_received),
    pub poll_count: Count,
};
            projection_fixup_time: None,
    /// Number of RGs whose `PositionMap` was the `Runs` variant
    /// Time spent slicing + downcasting the current_mask per input
            rows_pruned: Some(self.rows_pruned_by_page_index),
    pub pages_pruned: Count,
    pub parquet_poll_time: Option<Time>,
            position_map_identity: Some(self.position_map_identity),
            page_pruning_unavailable: counter("page_pruning_unavailable"),
    /// expression). Diagnostic: high values mean pruning isn't happening.
    pub index_time: Option<Time>,
    pub parquet_time: Time,
    pub filter_record_batch_time: Option<Time>,
    /// Time spent polling the inner parquet stream (pull decoded
    pub build_mask_time: Time,
            position_map_runs: None,
            filter_record_batch_time: Some(self.filter_record_batch_time),
    pub position_map_runs: Option<Count>,
    /// RGs that became prunable only after the filter tightened further between
            build_mask_time: None,
            filter_record_batch_time: MetricBuilder::new(metrics)
            rg_bloom_pruned: Some(self.rg_bloom_pruned),
    pub inner_parquet_metrics: Option<Arc<std::sync::Mutex<Vec<MetricsSet>>>>,
 * The OpenSearch Contributors require contributions made to
    /// Count of parquet pages the page-level pruner eliminated across
        Self {
            on_batch_mask_time: None,
            init_prefetch_time: MetricBuilder::new(metrics)
    /// the poll thread had to park waiting for Lucene).
//!   visible in `EXPLAIN ANALYZE`.
            dynamic_filter_rg_pruned_at_poll: Some(self.dynamic_filter_rg_pruned_at_poll),
    /// `next_completed_batch`. Helps isolate coalescing overhead.
            min_skip_run_block_granular: counter("min_skip_run_block_granular"),
            parquet_time: None,
    pub prefetch_wait_count: Option<Count>,
            rg_skipped: None,
    pub dynamic_filter_rg_pruned_at_prefetch: Count,
    /// batch.
            io_stats: None,
            init_prefetch_time: Some(self.init_prefetch_time),
    pub dynamic_filter_rg_pruned_at_poll: Count,
    pub parquet_time: Option<Time>,
impl PartitionMetrics {
    pub elapsed_compute: Time,
    pub build_mask_time: Option<Time>,
            inter_poll_gap: Some(self.inter_poll_gap),
            row_groups_skipped: counter("row_groups_skipped"),
    /// batch), isolating decode from our own processing.
    pub rg_bloom_pruned: Option<Count>,
            pages_pruned: counter("pages_pruned"),
    /// Count of `prune_rg` calls that couldn't apply pruning (no page
    /// index, column missing, or `PruningPredicate` rejected the
/*
            mask_slice_time: None,
            prefetch_wait_time: Some(self.prefetch_wait_time),
            position_map_runs: Some(self.position_map_runs),
                .subset_time("on_batch_mask_time", partition),
            poll_count: counter("poll_count"),
            mask_slice_time: Some(self.mask_slice_time),
            rows_matched: counter("rows_matched"),
    /// PREFETCH phase — before the Lucene/FFM eval ran. This saves both the
    pub rows_matched: Count,
        let counter = |name: &'static str| MetricBuilder::new(metrics).counter(name, partition);
    pub dynamic_filter_rg_pruned_at_poll: Option<Count>,
    /// visible here).
    /// FFM round-trips into the Java backend collector. Once per
    /// Convert into `StreamMetrics` for passing to the streaming loop.
    /// Number of RGs whose `PositionMap` was the `Identity` variant
            min_skip_run_row_granular: counter("min_skip_run_row_granular"),
            position_map_identity: counter("position_map_identity"),
pub struct StreamMetrics {
            inner_parquet_metrics: None,
    /// Time spent in bloom filter IO + evaluation across all RGs.
}
    pub ffm_collector_calls: Option<Count>,
            io_stats: Some(Arc::new(ReadIoStats::default())),
/// under a multi-segment parent) have no shared parent metrics to update.
    /// Wall-clock time spent inside `LimitedBatchCoalescer::push_batch` +
    }
            rows_pruned: None,
/// Per-partition metrics registered against the parent `ExecutionPlanMetricsSet`.
    /// Count of output `RecordBatch`es emitted from `poll_next`.
            on_batch_mask_time: MetricBuilder::new(metrics)
    /// Row groups pruned by bloom filter (value proven absent).
            position_map_bitmap: None,
    pub pages_total: Option<Count>,
    /// prefetch (which runs ~1 RG ahead) and processing.
    /// BooleanArray from candidate RoaringBitmap via PositionMap).
        inner_parquet_metrics: Option<Arc<std::sync::Mutex<Vec<MetricsSet>>>>,
            rg_processed: Some(self.row_groups_processed),
        }
            dynamic_filter_rg_pruned_at_poll: counter("dynamic_filter_rg_pruned_at_poll"),
            poll_count: None,
            build_mask_time: MetricBuilder::new(metrics).subset_time("build_mask_time", partition),
    /// with upstream work; non-zero indicates idle time.
            min_skip_run_block_granular: Some(self.min_skip_run_block_granular),
    /// index eval and the parquet decode. Zero when no dynamic filter was pushed.
    /// Count of row groups skipped by the runtime dynamic-filter pruner at the
            pages_total: Some(self.pages_total),
            coalesce_time: None,
            batches_produced: Some(self.batches_produced),
    pub fn empty() -> Self {
            batches_pre_coalesce: counter("batches_pre_coalesce"),
            prefetch_wait_time: None,
pub struct PartitionMetrics {
impl StreamMetrics {
    /// Count of `Poll::Pending` returns from the prefetch receiver (times
            position_map_runs: counter("position_map_runs"),
    pub init_prefetch_time: Time,
    pub coalesce_time: Time,
/// All fields are `Option` because standalone uses of `IndexedExec` (i.e. not
    pub projection_fixup_time: Time,
    pub inter_poll_gap: Time,
            batches_produced: counter("batches_produced"),
    pub batches_produced: Count,
            on_batch_mask_time: Some(self.on_batch_mask_time),
    pub parquet_poll_time: Time,
    pub dynamic_filter_rg_pruned_at_prefetch: Option<Count>,
    pub inter_poll_gap: Option<Time>,
            prefetch_wait_count: Some(self.prefetch_wait_count),
    pub rg_bloom_pruned: Count,
    pub batches_pre_coalesce: Option<Count>,
    /// No-op metrics for standalone execution.
 */
    pub pages_pruned: Option<Count>,
    /// The task returned `Poll::Pending` or was not re-polled immediately;
            page_pruning_unavailable: Some(self.page_pruning_unavailable),
    pub row_groups_processed: Count,
            rg_skipped: Some(self.row_groups_skipped),
            parquet_time: Some(self.parquet_time),
            ffm_collector_calls: Some(self.ffm_collector_calls),
 *
            rg_processed: None,
    /// (row-granular; row-to-rg-pos via `RoaringBitmap::select`).
 * this file be licensed under the Apache-2.0 license or a
    pub init_prefetch_time: Option<Time>,
    pub rg_skipped: Option<Count>,
    /// `pages_pruned / pages_total` gives pruning effectiveness.
/// Lightweight metric handles passed from `IndexedExec` to the streaming loop.
    pub ffm_collector_calls: Count,
    pub parquet_batches_received: Option<Count>,
            parquet_poll_time: Some(self.parquet_poll_time),
            rows_matched: None,
    ) -> StreamMetrics {
            rows_matched: Some(self.rows_matched),
            ffm_collector_calls: None,
            pages_total: None,
}
    pub elapsed_compute: Option<Time>,
            projection_fixup_time: MetricBuilder::new(metrics)
    pub row_groups_skipped: Count,
    pub io_stats: Option<Arc<ReadIoStats>>,
    pub filter_record_batch_time: Time,
            elapsed_compute: Some(self.elapsed_compute),
    /// receiver for a pending prefetch. Zero if prefetch fully overlapped
                .subset_time("projection_fixup_time", partition),
    pub parquet_batches_received: Count,
    /// stage filtering (empty batches dropped).
                .subset_time("prefetch_wait_time", partition),
    /// `MetricsSet` per chunk (row-group set) the partition scans.
    pub on_batch_mask_time: Time,
            inner_parquet_metrics,
            position_map_bitmap: Some(self.position_map_bitmap),
            batches_produced: None,
            init_prefetch_time: None,
            rg_bloom_pruned: None,
            pages_pruned: None,
    /// Count of `RecordBatch`es received from the inner parquet stream,
}
    /// Total parquet pages considered by the page-level pruner. Ratio
        }
            output_rows: MetricBuilder::new(metrics).output_rows(partition),
            mask_slice_time: MetricBuilder::new(metrics).subset_time("mask_slice_time", partition),
    pub output_rows: Count,
    /// `finalize_batch` (strip predicate columns).
    pub rg_processed: Option<Count>,
    /// all RGs in this partition.
    pub bloom_filter_eval_time: Option<Time>,
    pub prefetch_wait_time: Option<Time>,
        }
    /// Time spent in the projection fix-up at the bottom of
    /// Time spent in evaluator's `on_batch_mask` per input batch
}
            output_rows: None,
            bloom_filter_eval_time: Some(self.bloom_filter_eval_time),
            position_map_identity: None,
            position_map_bitmap: counter("position_map_bitmap"),
    pub output_rows: Option<Count>,
    pub min_skip_run_block_granular: Option<Count>,
            index_time: Some(self.index_time),
            coalesce_time: Some(self.coalesce_time),
                .subset_time("bloom_filter_eval_time", partition),
    /// Object-store read wall-time accumulator, shared across all RG readers
                .subset_time("filter_record_batch_time", partition),
    /// Time spent in `filter_record_batch` per input batch.
 * SPDX-License-Identifier: Apache-2.0
            elapsed_compute: None,
    /// Collector leaf per RG. This is the highest per-query cost
            dynamic_filter_rg_pruned_at_prefetch: None,
    pub coalesce_time: Option<Time>,
            coalesce_time: MetricBuilder::new(metrics).subset_time("coalesce_time", partition),
            parquet_poll_time: MetricBuilder::new(metrics)
    /// before mask filtering.
    pub page_pruning_unavailable: Count,
    pub min_skip_run_block_granular: Count,
    pub mask_slice_time: Time,
            batches_pre_coalesce: Some(self.batches_pre_coalesce),
            page_pruning_unavailable: None,
            batches_pre_coalesce: None,
    pub prefetch_wait_time: Time,
    pub position_map_runs: Count,
            pages_total: counter("pages_total"),
            parquet_time: MetricBuilder::new(metrics).subset_time("parquet_read_time", partition),
    pub bloom_filter_eval_time: Time,
    /// Number of RGs whose `PositionMap` was the `Bitmap` variant
    pub rows_pruned: Option<Count>,
            bloom_filter_eval_time: MetricBuilder::new(metrics)
    pub fn new(metrics: &ExecutionPlanMetricsSet, partition: usize) -> Self {
    /// (block-granular; explicit run table).
    /// (returns None on pure-collector paths; cost of dispatch is
    pub position_map_bitmap: Count,
    pub prefetch_wait_count: Count,
    pub projection_fixup_time: Option<Time>,
use std::sync::Arc;
#[derive(Clone)]
//! - [`StreamMetrics`] — lightweight handles passed to each RG stream for recording.
    /// Wall-clock time the poll thread spent blocked on the oneshot
            min_skip_run_row_granular: Some(self.min_skip_run_row_granular),
            parquet_batches_received: None,
    pub poll_count: Option<Count>,
            elapsed_compute: MetricBuilder::new(metrics).elapsed_compute(partition),
            min_skip_run_block_granular: None,
            inter_poll_gap: MetricBuilder::new(metrics).subset_time("inter_poll_gap", partition),
            dynamic_filter_rg_pruned_at_prefetch: Some(self.dynamic_filter_rg_pruned_at_prefetch),
//! Metrics for indexed search execution plans.
            inter_poll_gap: None,
    pub position_map_bitmap: Option<Count>,
    /// POLL phase — after the Lucene/FFM eval but before parquet decode. Catches
            output_rows: Some(self.output_rows),
            rg_bloom_pruned: counter("rg_bloom_pruned"),
    pub position_map_identity: Option<Count>,
    pub page_pruning_unavailable: Option<Count>,
//!
            min_skip_run_row_granular: None,
            filter_record_batch_time: None,
    Count, ExecutionPlanMetricsSet, MetricBuilder, MetricsSet, Time,
use crate::indexed_table::parquet_bridge::ReadIoStats;
