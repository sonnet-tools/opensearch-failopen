    let identity = get_counter(&m, "position_map_identity");
use datafusion::physical_plan::ExecutionPlan;
 */
    let (rows, plan) = run_tree_and_plan(tree).await;
        ffm,
    // rows_matched = candidates per RG; rows_pruned = (rg rows -
    );
        received,
        produced
    assert_eq!(
    );
/// `StreamMetrics`, but we only need to inspect `QueryShardExec` itself
    let bitmap = get_counter(&m, "position_map_bitmap");
        .sum(|metric| metric.value().name() == "elapsed_compute")
    set
    // RGs the candidate stage yielded non-empty candidates for.
        rg_processed,
/// to read them back out.
    // exactly one PositionMap variant count. The sum across the three
    // Every apple row is returned — 5 of them (rows 4,5,6,7,13).
        matched,
async fn metrics_rows_pruned_plus_rows_matched_upper_bounded() {
        rg_processed
/// not present. Filters to `DEV`-type metrics to exclude inner parquet
        .unwrap_or(0)
    let pruned = get_counter(&m, "rows_pruned_by_page_index");
    let rg_processed = get_counter(&m, "row_groups_processed");
fn get_counter(set: &MetricsSet, name: &str) -> usize {
    let tree = BoolNode::And(vec![index_leaf(1)]);
async fn metrics_row_groups_processed_counts_rgs_with_matches() {
///
    let (rows, plan) = run_tree_and_plan(tree).await;
    let runs = get_counter(&m, "position_map_runs");
    assert_eq!(get_counter(&m, "output_rows"), rows.len());
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        get_counter(&m, "row_groups_processed") >= 1,
    assert!(received > 0, "expected at least one input batch");
    set.sum(|m| m.value().name() == name && m.metric_type() == MetricType::Dev)
    let (_, plan) = run_tree_and_plan(tree).await;
    assert!(
    assert!(matched >= 5, "at least 5 apple rows should match");
    // variants equals `row_groups_processed`.
async fn metrics_min_skip_run_bucket_consistency() {
    // Each processed RG lands in exactly one of the two min_skip_run
    let m = aggregate_metrics(&plan);
    let m = aggregate_metrics(&plan);
 *
        "expected at least 1 RG processed for apple query"
async fn metrics_position_map_variants_sum_to_rgs_processed() {
    let m = aggregate_metrics(&plan);
//! (restored existing counters) and Tier-3 (new diagnostic counters)
async fn metrics_elapsed_compute_is_nonzero_when_query_runs() {
    // counted as skipped (candidate set was empty for each).
async fn metrics_empty_result_still_touches_rgs() {
                for metric in m.iter() {
    let (_, plan) = run_tree_and_plan(tree).await;
    let m = aggregate_metrics(&plan);
 * The OpenSearch Contributors require contributions made to
    // per RG before any page-pruning).
    assert_eq!(rows.len(), 0, "contradictory tree → zero rows");
        pruned
 * this file be licensed under the Apache-2.0 license or a
    let ffm = get_counter(&m, "ffm_collector_calls");
/// Walk the physical plan tree and merge metrics from our operators.
        .map(|v| v.as_usize())
        index_leaf(1), // apple
}
/// `SUMMARY` counters (e.g. `output_rows` from the inner
            if let Some(m) = plan.metrics() {
    assert_eq!(
    let (_, plan) = run_tree_and_plan(tree).await;
    // A collector that matches nothing: no output, but RGs are still
        rg_processed + rg_skipped,
        "empty-result query should register pruning or RG-skipping activity"
    let m = aggregate_metrics(&plan);
/// `QueryShardExec::execute` and aren't part of the plan tree — their
}
        row_granular + block_granular,
    let tree = BoolNode::And(vec![index_leaf(1)]);
    let (_, plan) = run_tree_and_plan(tree).await;
    );
        BoolNode::Not(Box::new(index_leaf(1))),
}
    let tree = BoolNode::And(vec![index_leaf(1)]);
        for child in plan.children() {
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    assert!(
    assert_eq!(
    // `parquet_batches_received >= batches_produced` because empty-batch
        .unwrap_or(0);
        "identity+bitmap+runs ({}+{}+{}={}) should equal rg_processed ({})",
/// metrics propagate up via the shared counter handles passed through
    let (_, plan) = run_tree_and_plan(tree).await;
        "ffm_collector_calls ({}) should equal total RGs touched ({}+{}={})",
        identity,
        received >= produced,
        rg_processed + rg_skipped
async fn metrics_batches_counters_relate() {
    fn walk(plan: &Arc<dyn ExecutionPlan>, out: &mut MetricsSet) {
    let block_granular = get_counter(&m, "min_skip_run_block_granular");
    // Fixture has 4 row groups of 4 rows each; apple appears in RG1 and RG3.
        rg_skipped,
    let tree = BoolNode::And(vec![index_leaf(1)]);
    // (and is bounded by the fixture size, 16).
    let rg_processed = get_counter(&m, "row_groups_processed");
async fn metrics_output_rows_matches_returned_row_count() {
    let tree = BoolNode::And(vec![
                    out.push(Arc::clone(metric));
        }
    );
    let tree = BoolNode::And(vec![index_leaf(1)]);
    // Single-collector path: one FFM call per processed RG. Sum should
    let (_, plan) = run_tree_and_plan(tree).await;
    let tree = BoolNode::And(vec![index_leaf(1)]);
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    let (_, plan) = run_tree_and_plan(tree).await;
        rg_processed,
    walk(plan, &mut set);
        bitmap,
        identity + bitmap + runs,
    let m = aggregate_metrics(&plan);
        pruned > 0 || rg_skipped > 0,
    let elapsed_ns = m
        ffm,
        "matched ({}) + pruned ({}) should be ≤ 16 fixture rows",
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        }
    let m = aggregate_metrics(&plan);
    assert!(
}
fn aggregate_metrics(plan: &Arc<dyn ExecutionPlan>) -> MetricsSet {
            walk(child, out);
    // Every RG that was processed (non-empty candidate set) produces
    // output is dropped in finalize_batch (mask rejects every row).
/// (see `PartitionMetrics::new(&self.metrics, ...)` in
async fn metrics_ffm_collector_calls_equal_rgs_processed() {
}
    // equal `row_groups_processed` (Collector is always called once
        .map(|v| v.as_usize())
        runs,
    assert!(
 * compatible open source license.
//! Tests asserting the metrics wired in [`crate::indexed_table::metrics`]
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    let rg_skipped = get_counter(&m, "row_groups_skipped");
    let m = aggregate_metrics(&plan);
    assert!(elapsed_ns > 0, "elapsed_compute should be nonzero");
}
        "parquet_batches_received ({}) should be >= batches_produced ({})",
use super::*;
}
    let pruned = get_counter(&m, "rows_pruned_by_page_index");
/// `DataSourceExec` which counts pre-mask rows).
        matched + pruned <= 16,
    assert_eq!(rows.len(), 5);
    );
//! actually get incremented during query execution. Covers both Tier-1
    let received = get_counter(&m, "parquet_batches_received");
    let matched = get_counter(&m, "rows_matched");
    let tree = BoolNode::And(vec![index_leaf(1)]);
 * SPDX-License-Identifier: Apache-2.0
    // Time metrics are nanoseconds; `elapsed_compute` should be >0 for
/// Look up a named counter in an aggregated `MetricsSet`. Returns 0 if
    // candidates) per RG. Their sum equals total rows in processed RGs
    // buckets. Sum equals row_groups_processed.
use datafusion::physical_plan::metrics::MetricsSet;
/// Our counters live on `QueryShardExec`'s `ExecutionPlanMetricsSet`
    let tree = BoolNode::And(vec![index_leaf(1)]);
//! metrics.
        "row_granular+block_granular should equal rg_processed"
                }
    }
    let mut set = MetricsSet::new();
    );
    assert!(produced > 0, "expected at least one output batch");
            }
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        identity + bitmap + runs,
        if plan.name() == "QueryShardExec" {
    let produced = get_counter(&m, "batches_produced");
    ]);
/*
}
}
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
/// `table_provider.rs`). `IndexedExec` instances are built inside
    );
    // Either rows_pruned accounts for everything, or every RG was skipped.
}
    let rg_skipped = get_counter(&m, "row_groups_skipped");
        rg_processed,
use std::sync::Arc;
    let row_granular = get_counter(&m, "min_skip_run_row_granular");
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    let rg_processed = get_counter(&m, "row_groups_processed");
    let m = aggregate_metrics(&plan);
    // any non-trivial query.
    use datafusion::physical_plan::metrics::MetricType;
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
}
