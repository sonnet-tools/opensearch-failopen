                .parquet_scan_until_data_time_ms
}
    #[test]
        self.delegation_calls
    total
    fn counters_are_isolated_from_concurrent_global_activity() {
    pub fn accumulate(&self, m: &StreamMetrics) {
            Ordering::Relaxed,
/// `GLOBAL`; tests instantiate their own so they stay isolated from concurrently
        pm.row_groups_skipped.add(1);
            elapsed_compute_ms: AtomicI64::new(0),
                .find(|m| m.value().name() == name)
pub fn inc_single_collector_scan() {
            prefetch_wait_count: AtomicI64::new(0),
    /// Accumulate from a `QueryShardExec`'s aggregated metrics at query completion.
            single_collector_scan: self.single_collector_scan.load(Ordering::Relaxed),
    bitmap_tree_scan: AtomicI64,
    build_mask_time_ms: AtomicI64,
        }
    #[test]
        total += best as u64;
/// Monotonic counters folded from per-query metrics. The process-wide instance is
    /// the counters were process-global and these tests measured a before/after delta, so a
            (sum_inner_metric_ns(sets, "time_elapsed_processing") / 1_000_000) as i64,
                .fetch_add(c.value() as i64, Ordering::Relaxed);
                .load(Ordering::Relaxed),
                .find(|m| m.value().name() == name)
    }
        if let Some(ref t) = m.elapsed_compute {
        pm.prefetch_wait_time
    fn default() -> Self {
    fn accumulate_inner_parquet_metrics(&self, sets: &[MetricsSet]) {
        if let Some(ref stats) = m.io_stats {
        self.parquet_bytes_scanned.fetch_add(
    GLOBAL.inc_listing_table_scan();
        std::thread::spawn(|| {
            }
        .unwrap();
    pub fn accumulate_from_exec(
            parquet_bytes_scanned: self.parquet_bytes_scanned.load(Ordering::Relaxed),
    parquet_scan_until_data_time_ms: AtomicI64,
    pub fn inc_listing_table_scan(&self) {
            parquet_scan_total_time_ms: self.parquet_scan_total_time_ms.load(Ordering::Relaxed),
                .iter()
        assert_eq!(stats.rg_skipped, 1);
    filter_record_batch_time_ms: AtomicI64,
    }
        if let Ok(sets) = inner_parquet_metrics.lock() {
            self.object_store_read_time_ms.fetch_add(
    GLOBAL.accumulate(m);
    rg_skipped: AtomicI64,
            build_mask_time_ms: AtomicI64::new(0),
            .fetch_add(count("prefetch_wait_count"), Ordering::Relaxed);
    rg_processed: AtomicI64,
        for metric in set.iter() {
pub fn snapshot() -> SearchStatsRepr {
        if let Some(ref c) = m.rg_skipped {
                .unwrap_or(0)
        self.parquet_processing_time_ms.fetch_add(
            listing_table_scan: self.listing_table_scan.load(Ordering::Relaxed),
                .fetch_add(c.value() as i64, Ordering::Relaxed);
        };
        let counters = SearchStatsCounters::new();
    fn path_counters_increment() {
        if let Some(ref t) = m.prefetch_wait_time {
        }
            object_store_read_time_ms: self.object_store_read_time_ms.load(Ordering::Relaxed),
            let other_pm = PartitionMetrics::new(&other_set, 0);
    pub fn inc_single_collector_scan(&self) {
impl Default for SearchStatsCounters {
    pub fn inc_bitmap_tree_scan(&self) {
pub fn sum_inner_metric_ns(sets: &[MetricsSet], name: &str) -> u64 {
            );
            single_collector_scan: AtomicI64::new(0),
    prefetch_wait_time_ms: AtomicI64,
        self.filter_record_batch_time_ms
    }
        })
        if let Some(ref acc) = m.inner_parquet_metrics {
            self.rg_skipped
        counters.inc_single_collector_scan();
        self.listing_table_scan.fetch_add(1, Ordering::Relaxed);
        if let Some(ref t) = m.filter_record_batch_time {
}
}
use std::sync::{Arc, Mutex};
    }
    }
                best = best.max(metric.value().as_usize());
        pm.ffm_collector_calls.add(3);
        self.rg_processed
    listing_table_scan: AtomicI64,
        counters.accumulate(&pm.into_stream_metrics(None));
            filter_record_batch_time_ms: AtomicI64::new(0),
    metrics: &ExecutionPlanMetricsSet,
        pm.prefetch_wait_count.add(2);
/// running queries.
    }
                .fetch_add(c.value() as i64, Ordering::Relaxed);
            self.on_batch_mask_time_ms
        let metrics_set = ExecutionPlanMetricsSet::new();
            prefetch_wait_count: self.prefetch_wait_count.load(Ordering::Relaxed),
        counters.accumulate(&StreamMetrics::empty());
            .fetch_add(count("ffm_collector_calls"), Ordering::Relaxed);
 * this file be licensed under the Apache-2.0 license or a
            filter_record_batch_time_ms: self.filter_record_batch_time_ms.load(Ordering::Relaxed),
            parquet_processing_time_ms: AtomicI64::new(0),
            Ordering::Relaxed,
        &self,
        assert_eq!(stats.listing_table_scan, 1);
use std::sync::atomic::{AtomicI64, Ordering};
    io_stats: &ReadIoStats,
        }
        let stats = counters.snapshot();
        self.parquet_scan_until_data_time_ms.fetch_add(
    use super::*;
            .fetch_add(count("row_groups_skipped"), Ordering::Relaxed);
use datafusion::physical_plan::metrics::{ExecutionPlanMetricsSet, MetricsSet};
            bitmap_tree_scan: AtomicI64::new(0),
        counters.accumulate(&pm.into_stream_metrics(None));
                .fetch_add((t.value() / 1_000_000) as i64, Ordering::Relaxed);
            elapsed_compute_ms: self.elapsed_compute_ms.load(Ordering::Relaxed),
        if let Some(ref c) = m.prefetch_wait_count {
        }
}
        let stats = counters.snapshot();
            sum_inner_metric_ns(sets, "bytes_scanned") as i64,
        self.elapsed_compute_ms
            Ordering::Relaxed,
        if let Some(ref c) = m.ffm_collector_calls {
    #[test]
            self.filter_record_batch_time_ms
}
        let pm = PartitionMetrics::new(&metrics_set, 0);
    use crate::indexed_table::metrics::PartitionMetrics;
        }
/// Accumulate from a `QueryShardExec`'s aggregated metrics at query completion.
                .fetch_add((t.value() / 1_000_000) as i64, Ordering::Relaxed);
            delegation_calls: self.delegation_calls.load(Ordering::Relaxed),
    }
                .iter()
            self.delegation_calls
            (sum_inner_metric_ns(sets, "time_elapsed_scanning_until_data") / 1_000_000) as i64,
            rg_processed: self.rg_processed.load(Ordering::Relaxed),
        }
    GLOBAL.accumulate_from_exec(metrics, inner_parquet_metrics, io_stats);
    }
            prefetch_wait_time_ms: AtomicI64::new(0),
        counters.inc_bitmap_tree_scan();
        .join()
            self.prefetch_wait_time_ms
                Ordering::Relaxed,
        self.rg_skipped
    }
    GLOBAL.inc_bitmap_tree_scan();
        assert_eq!(stats.bitmap_tree_scan, 1);
            .fetch_add(time_ms("filter_record_batch_time"), Ordering::Relaxed);
        assert!(stats.prefetch_wait_time_ms >= 10);
            (io_stats.total_ns.load(Ordering::Relaxed) / 1_000_000) as i64,
}
            .add_duration(std::time::Duration::from_millis(10));
        let counters = SearchStatsCounters::new();
    #[test]
        assert_eq!(stats.single_collector_scan, 2);
        self.build_mask_time_ms
    pub fn snapshot(&self) -> SearchStatsRepr {
    /// `indexed_table::tests_e2e`'s queries fold through `accumulate_from_exec`) landed inside the
}
        self.prefetch_wait_time_ms
            on_batch_mask_time_ms: AtomicI64::new(0),
            listing_table_scan: AtomicI64::new(0),
            parquet_scan_until_data_time_ms: AtomicI64::new(0),
            parquet_scan_until_data_time_ms: self
        let pm = PartitionMetrics::new(&metrics_set, 0);
            build_mask_time_ms: self.build_mask_time_ms.load(Ordering::Relaxed),
//! Cumulative search execution counters exposed via `df_stats()`.
            self.build_mask_time_ms
}
        let counters = SearchStatsCounters::new();
        let count = |name: &str| -> i64 {
        if let Some(ref c) = m.rg_processed {
            .fetch_add(time_ms("prefetch_wait_time"), Ordering::Relaxed);
    /// the global counters at the same time. Regression test for the flake this file used to produce:
    use datafusion::physical_plan::metrics::ExecutionPlanMetricsSet;
        }
pub fn accumulate(m: &StreamMetrics) {
            parquet_bytes_scanned: AtomicI64::new(0),
        Self::new()
        Self {
 */
 *
    delegation_calls: AtomicI64,
    }
    fn empty_stream_metrics_is_safe() {
            .fetch_add(time_ms("build_mask_time"), Ordering::Relaxed);
        }
    parquet_processing_time_ms: AtomicI64,
        pm.ffm_collector_calls.add(3);
        let counters = SearchStatsCounters::new();
        // Stand in for any other query folding its metrics into the process-wide counters.
                .unwrap_or(0)
#[derive(Debug)]
use crate::indexed_table::parquet_bridge::ReadIoStats;
        self.bitmap_tree_scan.fetch_add(1, Ordering::Relaxed);
            accumulate(&other_pm.into_stream_metrics(None));
        inner_parquet_metrics: &Arc<Mutex<Vec<MetricsSet>>>,
        if let Some(ref t) = m.build_mask_time {
        );
            (sum_inner_metric_ns(sets, "time_elapsed_scanning_total") / 1_000_000) as i64,
        }
        }
                self.accumulate_inner_parquet_metrics(&sets);
                (stats.total_ns.load(Ordering::Relaxed) / 1_000_000) as i64,
    parquet_bytes_scanned: AtomicI64,
        self.parquet_scan_total_time_ms.fetch_add(
    /// A counter set folds exactly what it was given, no matter what the rest of the process does to
            rg_skipped: self.rg_skipped.load(Ordering::Relaxed),
) {
                .map(|m| m.value().as_usize() as i64)
    }
    parquet_scan_total_time_ms: AtomicI64,
        io_stats: &ReadIoStats,
        pm.row_groups_processed.add(2);
                .fetch_add((t.value() / 1_000_000) as i64, Ordering::Relaxed);
mod tests {
use crate::indexed_table::metrics::StreamMetrics;
    }
            delegation_calls: AtomicI64::new(0),
    on_batch_mask_time_ms: AtomicI64,
                .fetch_add(c.value() as i64, Ordering::Relaxed);
        self.prefetch_wait_count
                .fetch_add((t.value() / 1_000_000) as i64, Ordering::Relaxed);
            rg_processed: AtomicI64::new(0),
    pub const fn new() -> Self {
    /// concurrent `accumulate` (cargo runs test functions on parallel threads in one process, and
        SearchStatsRepr {
        assert_eq!(counters.snapshot().delegation_calls, 0);
        let time_ms = |name: &str| -> i64 {
            prefetch_wait_time_ms: self.prefetch_wait_time_ms.load(Ordering::Relaxed),
}
    ) {
        self.single_collector_scan.fetch_add(1, Ordering::Relaxed);
        let mut best = 0usize;
            }
        };
            if let Ok(sets) = acc.lock() {
            .add_duration(std::time::Duration::from_millis(50));
        }
        counters.inc_single_collector_scan();
    }
            aggregated
            .fetch_add(time_ms("on_batch_mask_time"), Ordering::Relaxed);
        }
    /// measurement window and inflated it — `8 != 3`.
 * SPDX-License-Identifier: Apache-2.0
static GLOBAL: SearchStatsCounters = SearchStatsCounters::new();
impl SearchStatsCounters {
            aggregated
 * compatible open source license.
pub fn inc_bitmap_tree_scan() {
            Ordering::Relaxed,
            parquet_scan_total_time_ms: AtomicI64::new(0),
        let metrics_set = ExecutionPlanMetricsSet::new();
            object_store_read_time_ms: AtomicI64::new(0),
            self.accumulate_inner_parquet_metrics(&sets);
        );
use crate::stats::SearchStatsRepr;
            bitmap_tree_scan: self.bitmap_tree_scan.load(Ordering::Relaxed),
        counters.inc_listing_table_scan();
            let other_set = ExecutionPlanMetricsSet::new();
    fn accumulate_folds_partition_metrics() {
#[cfg(test)]
        );
    prefetch_wait_count: AtomicI64,
        self.on_batch_mask_time_ms
            rg_skipped: AtomicI64::new(0),
            .fetch_add(time_ms("elapsed_compute"), Ordering::Relaxed);
            other_pm.ffm_collector_calls.add(5);
        }
pub fn accumulate_from_exec(
            if metric.value().name() == name {
    GLOBAL.snapshot()
        metrics: &ExecutionPlanMetricsSet,
    for set in sets {
    GLOBAL.inc_single_collector_scan();
    }
        }
}
        if let Some(ref t) = m.on_batch_mask_time {
    let mut total = 0u64;
            self.rg_processed
        assert_eq!(counters.snapshot().delegation_calls, 3);
pub fn inc_listing_table_scan() {
        );
    object_store_read_time_ms: AtomicI64,
    single_collector_scan: AtomicI64,
        assert_eq!(stats.prefetch_wait_count, 2);
        assert_eq!(stats.rg_processed, 2);
        self.object_store_read_time_ms.fetch_add(
        pm.elapsed_compute
                .fetch_add((t.value() / 1_000_000) as i64, Ordering::Relaxed);
/*
            self.elapsed_compute_ms
            parquet_processing_time_ms: self.parquet_processing_time_ms.load(Ordering::Relaxed),
pub struct SearchStatsCounters {
            Ordering::Relaxed,
    inner_parquet_metrics: &Arc<Mutex<Vec<MetricsSet>>>,
        );
            .fetch_add(count("row_groups_processed"), Ordering::Relaxed);
                .map(|m| (m.value().as_usize() / 1_000_000) as i64)
    elapsed_compute_ms: AtomicI64,
            self.prefetch_wait_count
}
        let aggregated = metrics.clone_inner().aggregate_by_name();
            on_batch_mask_time_ms: self.on_batch_mask_time_ms.load(Ordering::Relaxed),
 * The OpenSearch Contributors require contributions made to
        }
        assert_eq!(stats.delegation_calls, 3);
