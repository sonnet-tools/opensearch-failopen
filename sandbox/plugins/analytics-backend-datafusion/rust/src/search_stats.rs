}
        self.filter_record_batch_time_ms
        assert_eq!(stats.rg_skipped, 1);
 * SPDX-License-Identifier: Apache-2.0
    #[test]
use crate::stats::SearchStatsRepr;
    parquet_scan_total_time_ms: AtomicI64,
    let mut total = 0u64;
        self.rg_processed
                .fetch_add((t.value() / 1_000_000) as i64, Ordering::Relaxed);
    rg_skipped: AtomicI64,
            self.rg_processed
                .fetch_add(c.value() as i64, Ordering::Relaxed);
            rg_processed: self.rg_processed.load(Ordering::Relaxed),
        if let Some(ref t) = m.on_batch_mask_time {
        assert_eq!(stats.prefetch_wait_count, 2);
            listing_table_scan: self.listing_table_scan.load(Ordering::Relaxed),
        io_stats: &ReadIoStats,
    use super::*;
    GLOBAL.inc_listing_table_scan();
        if let Some(ref t) = m.elapsed_compute {
        }
        let time_ms = |name: &str| -> i64 {
                .find(|m| m.value().name() == name)
    filter_record_batch_time_ms: AtomicI64,
    }
    /// concurrent `accumulate` (cargo runs test functions on parallel threads in one process, and
        }
                .fetch_add((t.value() / 1_000_000) as i64, Ordering::Relaxed);
        self.object_store_read_time_ms.fetch_add(
        pm.row_groups_skipped.add(1);
            self.prefetch_wait_time_ms
    /// `indexed_table::tests_e2e`'s queries fold through `accumulate_from_exec`) landed inside the
    fn empty_stream_metrics_is_safe() {
            parquet_processing_time_ms: self.parquet_processing_time_ms.load(Ordering::Relaxed),
        .join()
            on_batch_mask_time_ms: AtomicI64::new(0),
    fn counters_are_isolated_from_concurrent_global_activity() {
                .fetch_add(c.value() as i64, Ordering::Relaxed);
        }
            parquet_scan_until_data_time_ms: AtomicI64::new(0),
    }
            rg_skipped: self.rg_skipped.load(Ordering::Relaxed),
        let metrics_set = ExecutionPlanMetricsSet::new();
            parquet_processing_time_ms: AtomicI64::new(0),
    inner_parquet_metrics: &Arc<Mutex<Vec<MetricsSet>>>,
    }
            elapsed_compute_ms: AtomicI64::new(0),
        pm.prefetch_wait_count.add(2);
        if let Some(ref stats) = m.io_stats {
            delegation_calls: AtomicI64::new(0),
    }
            self.prefetch_wait_count
        self.single_collector_scan.fetch_add(1, Ordering::Relaxed);
            }
        self.listing_table_scan.fetch_add(1, Ordering::Relaxed);
    io_stats: &ReadIoStats,
    prefetch_wait_count: AtomicI64,
            delegation_calls: self.delegation_calls.load(Ordering::Relaxed),
    }
    parquet_scan_until_data_time_ms: AtomicI64,
            }
                (stats.total_ns.load(Ordering::Relaxed) / 1_000_000) as i64,
}
        }
        let pm = PartitionMetrics::new(&metrics_set, 0);
        assert!(stats.prefetch_wait_time_ms >= 10);
    fn path_counters_increment() {
            .fetch_add(time_ms("prefetch_wait_time"), Ordering::Relaxed);
        assert_eq!(counters.snapshot().delegation_calls, 3);
            rg_processed: AtomicI64::new(0),
                .fetch_add((t.value() / 1_000_000) as i64, Ordering::Relaxed);
    for set in sets {
    pub const fn new() -> Self {
            let other_pm = PartitionMetrics::new(&other_set, 0);
    bitmap_tree_scan: AtomicI64,
        self.prefetch_wait_count
use datafusion::physical_plan::metrics::{ExecutionPlanMetricsSet, MetricsSet};
                .unwrap_or(0)
        counters.accumulate(&pm.into_stream_metrics(None));
            parquet_scan_until_data_time_ms: self
            .fetch_add(count("ffm_collector_calls"), Ordering::Relaxed);
            self.elapsed_compute_ms
        counters.inc_single_collector_scan();
        pm.prefetch_wait_time
            .add_duration(std::time::Duration::from_millis(50));
}
        self.parquet_processing_time_ms.fetch_add(
    delegation_calls: AtomicI64,
        Self::new()
        assert_eq!(stats.bitmap_tree_scan, 1);
/// `GLOBAL`; tests instantiate their own so they stay isolated from concurrently
    pub fn snapshot(&self) -> SearchStatsRepr {
    }
        }
        let pm = PartitionMetrics::new(&metrics_set, 0);
        self.bitmap_tree_scan.fetch_add(1, Ordering::Relaxed);
        let counters = SearchStatsCounters::new();
    build_mask_time_ms: AtomicI64,
            self.accumulate_inner_parquet_metrics(&sets);
            .add_duration(std::time::Duration::from_millis(10));
            other_pm.ffm_collector_calls.add(5);
            filter_record_batch_time_ms: self.filter_record_batch_time_ms.load(Ordering::Relaxed),
            self.build_mask_time_ms
                self.accumulate_inner_parquet_metrics(&sets);
    pub fn inc_listing_table_scan(&self) {
            (io_stats.total_ns.load(Ordering::Relaxed) / 1_000_000) as i64,
        );
    GLOBAL.inc_bitmap_tree_scan();
        std::thread::spawn(|| {
    }
            bitmap_tree_scan: AtomicI64::new(0),
pub struct SearchStatsCounters {
        pm.elapsed_compute
    #[test]
 */
                .unwrap_or(0)
        }
        SearchStatsRepr {
/// running queries.
            (sum_inner_metric_ns(sets, "time_elapsed_scanning_until_data") / 1_000_000) as i64,
            (sum_inner_metric_ns(sets, "time_elapsed_scanning_total") / 1_000_000) as i64,
impl Default for SearchStatsCounters {
            aggregated
        );
}
    GLOBAL.accumulate(m);
            parquet_bytes_scanned: self.parquet_bytes_scanned.load(Ordering::Relaxed),
        if let Some(ref t) = m.build_mask_time {
        total += best as u64;
//! Cumulative search execution counters exposed via `df_stats()`.
            sum_inner_metric_ns(sets, "bytes_scanned") as i64,
    elapsed_compute_ms: AtomicI64,
            .fetch_add(time_ms("elapsed_compute"), Ordering::Relaxed);
        );
            Ordering::Relaxed,
mod tests {
            .fetch_add(time_ms("on_batch_mask_time"), Ordering::Relaxed);
            object_store_read_time_ms: AtomicI64::new(0),
        assert_eq!(counters.snapshot().delegation_calls, 0);
    pub fn accumulate_from_exec(
        self.build_mask_time_ms
            filter_record_batch_time_ms: AtomicI64::new(0),
            rg_skipped: AtomicI64::new(0),
        let metrics_set = ExecutionPlanMetricsSet::new();
    }
                .iter()
        self.parquet_scan_total_time_ms.fetch_add(
                best = best.max(metric.value().as_usize());
            .fetch_add(count("row_groups_skipped"), Ordering::Relaxed);
                .fetch_add(c.value() as i64, Ordering::Relaxed);
        inner_parquet_metrics: &Arc<Mutex<Vec<MetricsSet>>>,
        metrics: &ExecutionPlanMetricsSet,
                .map(|m| (m.value().as_usize() / 1_000_000) as i64)
use std::sync::atomic::{AtomicI64, Ordering};
        self.parquet_bytes_scanned.fetch_add(
pub fn accumulate(m: &StreamMetrics) {
        let aggregated = metrics.clone_inner().aggregate_by_name();
            single_collector_scan: self.single_collector_scan.load(Ordering::Relaxed),
        // Stand in for any other query folding its metrics into the process-wide counters.
            prefetch_wait_time_ms: AtomicI64::new(0),
            self.on_batch_mask_time_ms
    #[test]
    rg_processed: AtomicI64,
                .map(|m| m.value().as_usize() as i64)
        Self {
    }
        }
        .unwrap();
        assert_eq!(stats.listing_table_scan, 1);
    }
        }
}
}
                .fetch_add((t.value() / 1_000_000) as i64, Ordering::Relaxed);
    /// measurement window and inflated it — `8 != 3`.
                .fetch_add((t.value() / 1_000_000) as i64, Ordering::Relaxed);
            build_mask_time_ms: self.build_mask_time_ms.load(Ordering::Relaxed),
        &self,
            Ordering::Relaxed,
            listing_table_scan: AtomicI64::new(0),
        let stats = counters.snapshot();
            self.rg_skipped
        }
use std::sync::{Arc, Mutex};
        assert_eq!(stats.rg_processed, 2);
            .fetch_add(count("prefetch_wait_count"), Ordering::Relaxed);
    fn accumulate_inner_parquet_metrics(&self, sets: &[MetricsSet]) {
            parquet_bytes_scanned: AtomicI64::new(0),
    use crate::indexed_table::metrics::PartitionMetrics;
            if let Ok(sets) = acc.lock() {
            Ordering::Relaxed,
        let count = |name: &str| -> i64 {
    use datafusion::physical_plan::metrics::ExecutionPlanMetricsSet;
 * this file be licensed under the Apache-2.0 license or a
            self.object_store_read_time_ms.fetch_add(
        }
        counters.inc_listing_table_scan();
pub fn accumulate_from_exec(
        }
    fn default() -> Self {
        pm.ffm_collector_calls.add(3);
        if let Some(ref t) = m.filter_record_batch_time {
use crate::indexed_table::metrics::StreamMetrics;
    metrics: &ExecutionPlanMetricsSet,
            single_collector_scan: AtomicI64::new(0),
        if let Some(ref c) = m.rg_skipped {
            elapsed_compute_ms: self.elapsed_compute_ms.load(Ordering::Relaxed),
    fn accumulate_folds_partition_metrics() {
            self.delegation_calls
            prefetch_wait_count: self.prefetch_wait_count.load(Ordering::Relaxed),
        counters.inc_single_collector_scan();
        self.on_batch_mask_time_ms
        };
use crate::indexed_table::parquet_bridge::ReadIoStats;
/*
/// Monotonic counters folded from per-query metrics. The process-wide instance is
pub fn inc_listing_table_scan() {
    #[test]
            .fetch_add(time_ms("build_mask_time"), Ordering::Relaxed);
        counters.accumulate(&pm.into_stream_metrics(None));
    prefetch_wait_time_ms: AtomicI64,
        if let Some(ref c) = m.ffm_collector_calls {
            self.filter_record_batch_time_ms
}
        }
        );
            bitmap_tree_scan: self.bitmap_tree_scan.load(Ordering::Relaxed),
        self.prefetch_wait_time_ms
    }
        })
/// Accumulate from a `QueryShardExec`'s aggregated metrics at query completion.
                .load(Ordering::Relaxed),
        if let Some(ref acc) = m.inner_parquet_metrics {
    pub fn inc_bitmap_tree_scan(&self) {
                .fetch_add(c.value() as i64, Ordering::Relaxed);
        if let Some(ref c) = m.rg_processed {
            parquet_scan_total_time_ms: self.parquet_scan_total_time_ms.load(Ordering::Relaxed),
    listing_table_scan: AtomicI64,
pub fn sum_inner_metric_ns(sets: &[MetricsSet], name: &str) -> u64 {
pub fn inc_single_collector_scan() {
impl SearchStatsCounters {
    pub fn accumulate(&self, m: &StreamMetrics) {
            aggregated
            prefetch_wait_count: AtomicI64::new(0),
        self.elapsed_compute_ms
    GLOBAL.inc_single_collector_scan();
        counters.accumulate(&StreamMetrics::empty());
pub fn snapshot() -> SearchStatsRepr {
                Ordering::Relaxed,
    GLOBAL.snapshot()
        self.parquet_scan_until_data_time_ms.fetch_add(
}
    on_batch_mask_time_ms: AtomicI64,
    parquet_processing_time_ms: AtomicI64,
        pm.row_groups_processed.add(2);
}
        let counters = SearchStatsCounters::new();
                .find(|m| m.value().name() == name)
#[derive(Debug)]
 *
}
    object_store_read_time_ms: AtomicI64,
            (sum_inner_metric_ns(sets, "time_elapsed_processing") / 1_000_000) as i64,
    /// A counter set folds exactly what it was given, no matter what the rest of the process does to
    parquet_bytes_scanned: AtomicI64,
            Ordering::Relaxed,
 * The OpenSearch Contributors require contributions made to
        if let Some(ref c) = m.prefetch_wait_count {
 * compatible open source license.
}
    single_collector_scan: AtomicI64,
        }
    total
            prefetch_wait_time_ms: self.prefetch_wait_time_ms.load(Ordering::Relaxed),
        if let Some(ref t) = m.prefetch_wait_time {
    pub fn inc_single_collector_scan(&self) {
        assert_eq!(stats.single_collector_scan, 2);
        self.rg_skipped
                .iter()
            accumulate(&other_pm.into_stream_metrics(None));
static GLOBAL: SearchStatsCounters = SearchStatsCounters::new();
) {
            );
        let stats = counters.snapshot();
        }
            .fetch_add(time_ms("filter_record_batch_time"), Ordering::Relaxed);
            build_mask_time_ms: AtomicI64::new(0),
        counters.inc_bitmap_tree_scan();
        if let Ok(sets) = inner_parquet_metrics.lock() {
    }
            Ordering::Relaxed,
            let other_set = ExecutionPlanMetricsSet::new();
        pm.ffm_collector_calls.add(3);
        assert_eq!(stats.delegation_calls, 3);
    }
        self.delegation_calls
        let mut best = 0usize;
        for metric in set.iter() {
    /// Accumulate from a `QueryShardExec`'s aggregated metrics at query completion.
        };
    GLOBAL.accumulate_from_exec(metrics, inner_parquet_metrics, io_stats);
    ) {
            if metric.value().name() == name {
                .parquet_scan_until_data_time_ms
            object_store_read_time_ms: self.object_store_read_time_ms.load(Ordering::Relaxed),
        }
    /// the global counters at the same time. Regression test for the flake this file used to produce:
            on_batch_mask_time_ms: self.on_batch_mask_time_ms.load(Ordering::Relaxed),
            .fetch_add(count("row_groups_processed"), Ordering::Relaxed);
        let counters = SearchStatsCounters::new();
    }
        let counters = SearchStatsCounters::new();
    /// the counters were process-global and these tests measured a before/after delta, so a
        );
            parquet_scan_total_time_ms: AtomicI64::new(0),
pub fn inc_bitmap_tree_scan() {
#[cfg(test)]
