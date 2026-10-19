    let rg_skipped = get_counter(&m, "row_groups_skipped");
/// `DataSourceExec` which counts pre-mask rows).
    let m = aggregate_metrics(&plan);
            }
    // Every RG that was processed (non-empty candidate set) produces
}
async fn metrics_row_groups_processed_counts_rgs_with_matches() {
 * The OpenSearch Contributors require contributions made to
        if plan.name() == "QueryShardExec" {
        matched + pruned <= 16,
    assert_eq!(
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        bitmap,
async fn metrics_rows_pruned_plus_rows_matched_upper_bounded() {
        identity,
        rg_processed + rg_skipped,
    // counted as skipped (candidate set was empty for each).
        .sum(|metric| metric.value().name() == "elapsed_compute")
        }
    assert!(elapsed_ns > 0, "elapsed_compute should be nonzero");
    fn walk(plan: &Arc<dyn ExecutionPlan>, out: &mut MetricsSet) {
}
    let row_granular = get_counter(&m, "min_skip_run_row_granular");
    // output is dropped in finalize_batch (mask rejects every row).
///
    let (_, plan) = run_tree_and_plan(tree).await;
        "matched ({}) + pruned ({}) should be ≤ 16 fixture rows",
    // Each processed RG lands in exactly one of the two min_skip_run
/// metrics propagate up via the shared counter handles passed through
    walk(plan, &mut set);
    let tree = BoolNode::And(vec![index_leaf(1)]);
    // Single-collector path: one FFM call per processed RG. Sum should
    let mut set = MetricsSet::new();
//! actually get incremented during query execution. Covers both Tier-1
        "row_granular+block_granular should equal rg_processed"
        rg_skipped,
async fn metrics_min_skip_run_bucket_consistency() {
    // Every apple row is returned — 5 of them (rows 4,5,6,7,13).
    let identity = get_counter(&m, "position_map_identity");
        row_granular + block_granular,
}
//! metrics.
/// `table_provider.rs`). `IndexedExec` instances are built inside
        .map(|v| v.as_usize())
}
 */
async fn metrics_batches_counters_relate() {
/// `StreamMetrics`, but we only need to inspect `QueryShardExec` itself
    );
}
    let tree = BoolNode::And(vec![index_leaf(1)]);
        for child in plan.children() {
/*
    // `parquet_batches_received >= batches_produced` because empty-batch
        rg_processed + rg_skipped
    let ffm = get_counter(&m, "ffm_collector_calls");
async fn metrics_elapsed_compute_is_nonzero_when_query_runs() {
    // variants equals `row_groups_processed`.
        matched,
        rg_processed,
    // any non-trivial query.
    let m = aggregate_metrics(&plan);
/// `SUMMARY` counters (e.g. `output_rows` from the inner
use std::sync::Arc;
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    assert_eq!(
    // A collector that matches nothing: no output, but RGs are still
    let tree = BoolNode::And(vec![index_leaf(1)]);
    assert!(
/// to read them back out.
    // Fixture has 4 row groups of 4 rows each; apple appears in RG1 and RG3.
        "identity+bitmap+runs ({}+{}+{}={}) should equal rg_processed ({})",
    let tree = BoolNode::And(vec![index_leaf(1)]);
    let block_granular = get_counter(&m, "min_skip_run_block_granular");
    // (and is bounded by the fixture size, 16).
            if let Some(m) = plan.metrics() {
    assert!(
    assert!(produced > 0, "expected at least one output batch");
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
}
    let tree = BoolNode::And(vec![index_leaf(1)]);
    );
    // Either rows_pruned accounts for everything, or every RG was skipped.
/// Look up a named counter in an aggregated `MetricsSet`. Returns 0 if
    let (_, plan) = run_tree_and_plan(tree).await;
    let m = aggregate_metrics(&plan);
    assert!(matched >= 5, "at least 5 apple rows should match");
    assert_eq!(rows.len(), 5);
    assert!(received > 0, "expected at least one input batch");
use datafusion::physical_plan::ExecutionPlan;
        rg_processed,
    assert_eq!(rows.len(), 0, "contradictory tree → zero rows");
    use datafusion::physical_plan::metrics::MetricType;
    let tree = BoolNode::And(vec![index_leaf(1)]);
                    out.push(Arc::clone(metric));
    let m = aggregate_metrics(&plan);
    assert_eq!(get_counter(&m, "output_rows"), rows.len());
        pruned
        }
    assert!(
    }
    let bitmap = get_counter(&m, "position_map_bitmap");
use super::*;
    // Time metrics are nanoseconds; `elapsed_compute` should be >0 for
    set.sum(|m| m.value().name() == name && m.metric_type() == MetricType::Dev)
/// `QueryShardExec::execute` and aren't part of the plan tree — their
    // buckets. Sum equals row_groups_processed.
        received,
    let tree = BoolNode::And(vec![
 *
    // candidates) per RG. Their sum equals total rows in processed RGs
}
        .map(|v| v.as_usize())
    // rows_matched = candidates per RG; rows_pruned = (rg rows -
    let m = aggregate_metrics(&plan);
use datafusion::physical_plan::metrics::MetricsSet;
    );
//! (restored existing counters) and Tier-3 (new diagnostic counters)
}
    let rg_skipped = get_counter(&m, "row_groups_skipped");
            walk(child, out);
//! Tests asserting the metrics wired in [`crate::indexed_table::metrics`]
    );
    let (_, plan) = run_tree_and_plan(tree).await;
    // exactly one PositionMap variant count. The sum across the three
    );
    let (_, plan) = run_tree_and_plan(tree).await;
    ]);
        "expected at least 1 RG processed for apple query"
async fn metrics_ffm_collector_calls_equal_rgs_processed() {
}
fn get_counter(set: &MetricsSet, name: &str) -> usize {
        BoolNode::Not(Box::new(index_leaf(1))),
    let m = aggregate_metrics(&plan);
        "ffm_collector_calls ({}) should equal total RGs touched ({}+{}={})",
    // per RG before any page-pruning).
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    let matched = get_counter(&m, "rows_matched");
async fn metrics_output_rows_matches_returned_row_count() {
    let pruned = get_counter(&m, "rows_pruned_by_page_index");
    let elapsed_ns = m
    assert_eq!(
        "parquet_batches_received ({}) should be >= batches_produced ({})",
        identity + bitmap + runs,
        rg_processed
 * this file be licensed under the Apache-2.0 license or a
    let received = get_counter(&m, "parquet_batches_received");
    let (_, plan) = run_tree_and_plan(tree).await;
async fn metrics_empty_result_still_touches_rgs() {
    let tree = BoolNode::And(vec![index_leaf(1)]);
    // equal `row_groups_processed` (Collector is always called once
        "empty-result query should register pruning or RG-skipping activity"
        get_counter(&m, "row_groups_processed") >= 1,
                for metric in m.iter() {
        ffm,
        runs,
}
        rg_processed,
}
    // RGs the candidate stage yielded non-empty candidates for.
        pruned > 0 || rg_skipped > 0,
        ffm,
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    );
    let rg_processed = get_counter(&m, "row_groups_processed");
    let rg_processed = get_counter(&m, "row_groups_processed");
    let tree = BoolNode::And(vec![index_leaf(1)]);
async fn metrics_position_map_variants_sum_to_rgs_processed() {
    let m = aggregate_metrics(&plan);
    assert!(
        .unwrap_or(0)
    let rg_processed = get_counter(&m, "row_groups_processed");
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
/// not present. Filters to `DEV`-type metrics to exclude inner parquet
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    let (_, plan) = run_tree_and_plan(tree).await;
    let m = aggregate_metrics(&plan);
        produced
    set
        .unwrap_or(0);
/// (see `PartitionMetrics::new(&self.metrics, ...)` in
    let m = aggregate_metrics(&plan);
/// Our counters live on `QueryShardExec`'s `ExecutionPlanMetricsSet`
    );
        identity + bitmap + runs,
        index_leaf(1), // apple
/// Walk the physical plan tree and merge metrics from our operators.
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    let produced = get_counter(&m, "batches_produced");
    let (rows, plan) = run_tree_and_plan(tree).await;
        received >= produced,
    let pruned = get_counter(&m, "rows_pruned_by_page_index");
    let (_, plan) = run_tree_and_plan(tree).await;
                }
    let runs = get_counter(&m, "position_map_runs");
    let (rows, plan) = run_tree_and_plan(tree).await;
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
fn aggregate_metrics(plan: &Arc<dyn ExecutionPlan>) -> MetricsSet {
