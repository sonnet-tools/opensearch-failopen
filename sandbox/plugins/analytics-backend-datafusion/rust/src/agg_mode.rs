        let mut modes = Vec::new();
        assert!(
                // (the Final above will keep itself)
}
            plan_string(&result)
    #[tokio::test]
            !result_modes.contains(&AggregateMode::Partial),
            "expected Final/FinalPartitioned in multi-partition plan, got:\n{display_before}"
    plan: Arc<dyn ExecutionPlan>,
            !result_modes.contains(&AggregateMode::Partial),
            modes.contains(&AggregateMode::PartialReduce),
    async fn make_agg_plan_with_repartition() -> Arc<dyn ExecutionPlan> {
                .with_physical_optimizer_rules(physical_optimizer_rules_without_combine())
        let result = apply_aggregate_mode(plan, Mode::Partial, true).unwrap();
    #[test]
        let plan_str = plan_string(&plan);
            let result = apply_aggregate_mode(plan, Mode::Partial, false).unwrap();
        Mode::Partial => force_aggregate_mode(plan, AggregateMode::Partial, has_topk),
        }
            plan_string(&result)
                .with_default_features()
/// the M3 worker-side path: when `EnforceDistribution` sees a multi-partition input feeding
/// Walks the plan tree and strips the half that doesn't match `target`.
/// Returns the output schema of the Partial aggregate without rebuilding the plan tree.
        );
        Mode::Default => Ok(plan),
                    .iter()
/// already hash-partitioned the rows by the same keys with the same partition count. The
            display_before.contains("mode=FinalPartitioned")
    if let Some(agg) = plan.downcast_ref::<AggregateExec>() {
 * SPDX-License-Identifier: Apache-2.0
    }
/// repartition is therefore a no-op (rows are already in the right partition) but costs one
        );
            result_modes.contains(&AggregateMode::Final),
    } else if plan.children().len() == 1 {
        // With target_partitions=4 and GROUP BY, DF produces FinalPartitioned.
/// hash + one buffer per batch on the worker. Stripping it is correctness-preserving.
            display_after.contains("mode=Partial"),
        assert!(
                .collect::<Result<_>>()?;
fn mode_matches_target(mode: AggregateMode, target: AggregateMode) -> bool {
                )]),
//! Aggregate mode stripping for distributed partial/final execution.
                .with_config(config)
            )
        // Treat `FinalPartitioned` as `Final` (see mode_matches_target): DataFusion picks
                let remapped: Vec<(Arc<dyn PhysicalExpr>, String)> = proj
    expr.with_new_children(new_children).unwrap_or(fallback)
            "Round-robin Repartition over StreamingTable must be preserved, got: {}",
            datafusion::execution::SessionStateBuilder::new()
/// Returns the default physical optimizer rules with `CombinePartialFinalAggregate` removed.
        assert!(
        assert!(
        assert!(
        for child in plan.children() {
        );
        let child = repart.children()[0];
        let plan = make_agg_plan().await;
                // group key before TopK truncation. Skip when input_partitions=1 — PartialReduce
/*
                        Arc::clone(agg.input()),
/// shapes (round-robin coalescing, hash for a non-shuffle child) are left alone.
            modes.extend(find_agg_modes(child));
        // Leaf or multi-input node — return as-is
        assert!(
    async fn test_strip_partial_past_repartition() {
            ])),
            stripped.downcast_ref::<RepartitionExec>().is_some(),
        let result_modes = find_agg_modes(&result);
            arrow::datatypes::Field::new("x", arrow::datatypes::DataType::Int64, false),
/// Removes a `RepartitionExec(Hash)` that sits directly above a `StreamingTableExec`.
    Partial,
        let modes = find_agg_modes(&plan);
///
        let ctx = SessionContext::new_with_state(
            vec![Arc::new(arrow_array::Int64Array::from(vec![1, 2, 3]))],
            }
        if let Some(proj) = plan.downcast_ref::<ProjectionExec>() {
                .with_default_features()
        );
    use datafusion::prelude::*;
        );
    #[test]
    }
        match target {
    }
    }
                Arc::clone(&leaf),
        let stripped = strip_redundant_shuffle_repartition(Arc::clone(&hash_repart)).unwrap();
        if *agg.mode() == AggregateMode::Partial {
    if new_children.is_empty() {
    Default,
            )
                    false,
            display_before.contains("AggregateExec: mode=Partial"),
    #[test]
                        datafusion::physical_expr::expressions::Column::new("x", 0),
    #[tokio::test]
        let stripped = strip_redundant_shuffle_repartition(Arc::clone(&rr_repart)).unwrap();
    use datafusion::physical_plan::displayable;
        let result = apply_aggregate_mode(plan, Mode::Final, false).unwrap();
                    return Ok(partial_subtree);
    has_topk: bool,
    }
        ctx.register_batch("t", batch).unwrap();
                    )],
/// `AggregateMode::Final` matches both `Final` (single-partition merge) and
        return Ok(plan);
            "CombinePartialFinalAggregate should be filtered out"
        let schema = Arc::new(arrow::datatypes::Schema::new(vec![
        // DataFusion's ProjectionMapping::try_new asserts col.name() == input_schema.field(i).name();
        .collect();
            "Should NOT contain Final: {}",
        );
        // Hash-RepartitionExec sitting directly on a StreamingTableExec — exactly the shape
        .into_iter()
            RepartitionExec::try_new(
            _ => Ok(plan),
        assert!(
    async fn test_strip_partial_over_scan() {
    }
        let stripped = apply_aggregate_mode(plan, Mode::Partial, false).unwrap();
        Arc::new(
    fn plan_string(plan: &Arc<dyn ExecutionPlan>) -> String {
        }
        ) as Arc<dyn ExecutionPlan>;
                // When TopK is active and the input has multiple partitions (CSS), replace
    let children = plan.children();
            Arc::new(datafusion::physical_plan::empty::EmptyExec::new(Arc::new(
            AggregateMode::Final => {
                        agg.filter_expr().to_vec(),
pub(crate) fn apply_aggregate_mode(
) -> Vec<Arc<dyn PhysicalOptimizerRule + Send + Sync>> {
    fn test_preserve_hash_repartition_over_non_streaming_input() {
                        AggregateMode::PartialReduce,
/// require an exact mode match.
    }
            stripped.downcast_ref::<RepartitionExec>().is_some(),
    Final,
                        agg.input_schema(),
        }
    if let Some(agg) = plan.downcast_ref::<AggregateExec>() {
    }
                .children()
    fn find_agg_modes(plan: &Arc<dyn ExecutionPlan>) -> Vec<AggregateMode> {
use datafusion_common::Result;
        }
        return true;
        config.options_mut().execution.target_partitions = 4;
            plan_string(&stripped)
        assert!(
        let hash_repart = Arc::new(
        .filter(|r| r.name() != combine_name)
            "RepartitionExec(Hash) over StreamingTableExec must be stripped to the leaf, got: {}",
    has_topk: bool,
    }
            "has_topk=true with multi-partition input must produce PartialReduce, got modes: {modes:?}"
                // Normal path: strip Final, return Partial subtree
    }
        let df = ctx.sql("SELECT SUM(x) FROM t").await.unwrap();
        df.create_physical_plan().await.unwrap()
                force_aggregate_mode(Arc::clone(child), target, false)
            )
        let display_before = plan_string(&plan);
        )
                arrow::datatypes::Schema::new(vec![arrow::datatypes::Field::new(
    plan.with_new_children(new_children)
pub(crate) fn partial_aggregate_schema(
    #[tokio::test]
        if mode_matches_target(*agg.mode(), target) {
        // stripped — the rows aren't already hash-partitioned by an upstream shuffle.
    /// — fine for plan-shape assertions that don't actually execute.
        // The simple plan has CoalescePartitions between Final and Partial
        .into_iter()
            plan_string(&result)
        assert!(
        }
            // Keep this node, recurse into children
        // GROUP BY forces repartition with multiple target partitions
                arrow::datatypes::Field::new("x", arrow::datatypes::DataType::Int64, false),
        // Non-Partial aggregate (Final/FinalPartitioned) — look into its input for Partial
        let rr_repart = Arc::new(
        ctx.register_batch("t", batch).unwrap();
            strip_redundant_shuffle_repartition(stripped)
    plan: Arc<dyn ExecutionPlan>,
        if is_hash && child_is_streaming {
        .collect()
                        agg.aggr_expr().to_vec(),
) -> Option<arrow::datatypes::SchemaRef> {
/// Used by `derive_schema_from_partial_plan` where we only need types, not an executable plan.
/// `EnforceDistribution` inserts that repartition because `StreamingTableExec` declares
        Mode::Final => {
        )
    expr: Arc<dyn PhysicalExpr>,
) -> Result<Arc<dyn ExecutionPlan>> {
/// `FinalPartitioned` (same merge half, different child distribution). All other pairings
            .unwrap(),
            StreamingTableExec::try_new(schema, vec![partition], None, None, false, None).unwrap(),
        }
            "Should contain Partial: {}",
                Arc::clone(&leaf),
    plan: &Arc<dyn ExecutionPlan>,
        let df = ctx.sql("SELECT x, SUM(x) FROM t GROUP BY x").await.unwrap();
            assert!(!result_modes.contains(&AggregateMode::Final));
                    vec![Arc::new(
        .map(|c| remap_column(c.clone(), schema))
                if let Some(partial_subtree) = find_partial_input(Arc::clone(agg.input())) {
#[cfg(test)]
                    )?));
        return find_partial_input(Arc::clone(agg.input()));
            plan_string(&plan)
    /// drop-in plan leaf. The channel is closed immediately so the stream is empty
    /// register a memtable, and produce a physical plan for `SELECT SUM(x) FROM t`.
        // Verify the plan has the expected structure
                let child = agg.children()[0];
                ),
        }
        );
            AggregateMode::Partial => {
fn strip_redundant_shuffle_repartition(
    async fn test_apply_partial_strips_final() {
                    )],
pub(crate) fn physical_optimizer_rules_without_combine(
}
/// AggregateExec node itself, not just its input).
        let old_child = Arc::clone(plan.children()[0]);
    fn test_strip_redundant_hash_repartition_over_streaming_table() {
                if has_topk && agg.input().output_partitioning().partition_count() > 1 {
    } else {
        let leaf = streaming_table_leaf();
        // Single-input wrapper — recurse transparently.
        // Final → CoalescePartitions → Partial → scan; strip to Final
            "Final/FinalPartitioned must not remain after stripping"
        return find_partial_input(Arc::clone(children[0]));
        let child_is_streaming = child.downcast_ref::<StreamingTableExec>().is_some();
            let new_children: Vec<Arc<dyn ExecutionPlan>> = agg
/// Whether `mode` is the same logical half as `target`. `Final` matches both `Final` and
    }
    let children = expr.children();
    async fn test_strip_final_over_scan() {
                ),
            "Partial should remain"
            // If optimizer collapsed it, just verify Mode::Partial works
    #[tokio::test]
                    4,
            "expected Final in plan"
            result_modes.contains(&AggregateMode::Final),
    PhysicalOptimizer::new()
        if plan.name().contains(name) {
        // repartition; data is already hash-partitioned by our M3 shuffle.
    /// Builds a 1-partition StreamingTableExec over a closed channel for use as a
        let plan = make_agg_plan_with_repartition().await;
    }
    let fallback = expr.clone();
            Arc::new(arrow::datatypes::Schema::new(vec![
/// Applies aggregate mode stripping to a physical plan.
        let batch = arrow_array::RecordBatch::try_new(
        }
        let plan = make_agg_plan_with_repartition().await;
/// the two as the same logical "final" half keeps the strip correct in both shapes.
                // with PartialReduce instead of stripping. PartialReduce keeps agg.input()
fn find_partial_input(plan: Arc<dyn ExecutionPlan>) -> Option<Arc<dyn ExecutionPlan>> {
        // load balancing pre-Final) — the strip must NOT touch it.
use datafusion::physical_expr::{Partitioning, PhysicalExpr};
        assert!(
    use super::*;
            "Should contain Final: {}",
    find_partial_input(Arc::clone(plan)).map(|p| p.schema())
            plan_string(&stripped)
        let rules = physical_optimizer_rules_without_combine();
    match mode {
    }
) -> Result<Arc<dyn ExecutionPlan>> {
        .unwrap();
}
        let result_modes = find_agg_modes(&result);
                    .collect();
            return true;
    schema: &arrow::datatypes::SchemaRef,
        let (_tx, rx) = crate::partition_stream::channel(Arc::clone(&schema));
    async fn test_strip_final_past_coalesce() {
        assert!(
            RepartitionExec::try_new(
        .children()
                .into_iter()
}
        let mut config = SessionConfig::new();
            "Hash-Repartition over non-streaming input must be preserved, got: {}",
                    "x",
fn force_aggregate_mode(
                arrow::datatypes::Field::new("x", arrow::datatypes::DataType::Int64, false),
        assert!(
/// CoalescePartitionsExec / ProjectionExec / etc.) to find an
            Arc::new(crate::partition_stream::SingleReceiverPartition::new(rx));
        );
        );
    #[test]
                .build(),
            }
        );
                    arrow::datatypes::DataType::Int64,
        );
    }
                        datafusion::physical_expr::expressions::Column::new("x", 0),
            !result_modes.contains(&AggregateMode::Final),
        );
        modes
            let result_modes = find_agg_modes(&result);
        // `Final` for scalar / un-partitioned ones. Both are the FINAL half of the Partial/Final
///
                .build(),
        let batch = arrow_array::RecordBatch::try_new(
use datafusion::physical_plan::repartition::RepartitionExec;
            result_modes.contains(&AggregateMode::Partial),
        let leaf = streaming_table_leaf();
/// `FinalPartitioned` (per-partition merge over hash-distributed input). This matters for
            plan_string(&result),
            plan_string(&result)
            modes.push(*agg.mode());
            plan_string(&stripped)
        );
use datafusion::physical_plan::streaming::StreamingTableExec;
 *
                .map(|c| force_aggregate_mode(Arc::clone(c), target, has_topk))
        let stripped = strip_redundant_shuffle_repartition(Arc::clone(&hash_repart)).unwrap();
 */
    if let Some(col) = expr.downcast_ref::<Column>() {
        assert!(!rules.is_empty(), "Should have other optimizer rules");
    #[tokio::test]
        // Mode mismatch — strip this node
            Arc::new(arrow::datatypes::Schema::new(vec![
use datafusion::physical_plan::projection::ProjectionExec;
        df.create_physical_plan().await.unwrap()
}
    fn contains_node(plan: &Arc<dyn ExecutionPlan>, name: &str) -> bool {
        let partition: Arc<dyn datafusion::physical_plan::streaming::PartitionStream> =
            return plan.with_new_children(new_children);
        assert!(
    async fn test_apply_partial_with_topk_produces_partial_reduce() {
        if let Some(agg) = plan.downcast_ref::<AggregateExec>() {
    let combine_name = CombinePartialFinalAggregate::new().name().to_string();
                        agg.group_expr().clone(),
    fn streaming_table_leaf() -> Arc<dyn ExecutionPlan> {
}
        ) as Arc<dyn ExecutionPlan>;
    if mode == target {
            "Should NOT contain Partial: {}",
        let result_modes = find_agg_modes(&result);
                    .map(|pe| (remap_column(pe.expr.clone(), new_schema), pe.alias.clone()))
    }
    }
        return expr;
        ) as Arc<dyn ExecutionPlan>;
    plan: Arc<dyn ExecutionPlan>,
        plan.children().iter().any(|c| contains_node(c, name))
    }
        let plan = make_agg_plan().await;
    /// Helper: create a plan with Repartition between Final and Partial.
    /// only the Partial subtree — the core behavior the indexed executor relies on
        assert!(
                // over a single partition is redundant and adds unnecessary overhead.
            if old_child.schema() != new_child.schema() {
    fn test_combine_rule_absent() {
            "Final should be stripped"
#[derive(Clone, Copy, Debug, PartialEq)]
        (AggregateMode::Final, AggregateMode::FinalPartitioned)
        let leaf: Arc<dyn ExecutionPlan> =
    let new_children: Vec<_> = children
 * The OpenSearch Contributors require contributions made to
use datafusion::physical_plan::expressions::Column;
    #[tokio::test]
            }
        let ctx = SessionContext::new_with_state(
        assert!(
        let result = apply_aggregate_mode(plan, Mode::Final, false).unwrap();
    /// must be replaced with PartialReduce rather than stripped, so the coordinator receives
            "Plan should have aggregate nodes: {}",
        .unwrap();
                datafusion::physical_expr::Partitioning::Hash(
    mode: Mode,
        )
        assert!(
            !modes.contains(&AggregateMode::Final)
    }
        }
        );
) -> Result<Arc<dyn ExecutionPlan>> {
        // Round-robin Repartition over a StreamingTableExec is a different shape (e.g. for
    }
        let result_modes = find_agg_modes(&result);
        );
            RepartitionExec::try_new(
    }
use datafusion::physical_plan::aggregates::{AggregateExec, AggregateMode};
    }
        // Final → Repartition/Coalesce → Partial → scan; strip to Partial
                // Current node is Partial; skip it, return its child
use datafusion::physical_optimizer::optimizer::{PhysicalOptimizer, PhysicalOptimizerRule};
                    return Ok(Arc::new(AggregateExec::try_new(
        assert!(
        let combine_name = CombinePartialFinalAggregate::new().name().to_string();
        .collect::<Result<_>>()?;
}
            return Some(plan);
        let plan = make_agg_plan().await;
                // Current node is Final/FinalPartitioned.
            "expected Partial in plan"
        return Arc::new(Column::new(schema.field(col.index()).name(), col.index()));
    if let Some(repart) = plan.downcast_ref::<RepartitionExec>() {
        );
            datafusion::execution::SessionStateBuilder::new()
///
    /// When has_topk=true and the input has multiple partitions (CSS), Final/FinalPartitioned
    if children.len() == 1 {
        // but StreamingTableExec advertises UnknownPartitioning. The strip must remove the
}
                    4,
            return Ok(Arc::clone(child));
            vec![Arc::new(arrow_array::Int64Array::from(vec![1, 2, 3]))],
        );
        let plan = make_agg_plan().await;
use datafusion::physical_optimizer::combine_partial_final_agg::CombinePartialFinalAggregate;
 * compatible open source license.
            plan_string(&result)
    }
            "Should NOT contain Partial after strip: {}",
            modes.contains(&AggregateMode::Final) || modes.contains(&AggregateMode::Partial),
            plan_str
                .with_physical_optimizer_rules(physical_optimizer_rules_without_combine())
                && !modes.contains(&AggregateMode::FinalPartitioned),
                Arc::clone(&leaf),
    /// Verifies apply_aggregate_mode(Partial) strips the Final aggregate and keeps
            ])),
mod tests {
            .unwrap(),
    }
            "Should NOT contain Final after strip: {}\nOriginal: {}",
    }
    }
/// PartialReduce so CSS partitions are merged by group key before the TopK sort truncates.
    )
/// Updates Column expression names to match the given schema (by index). Recurses into children.
            .unwrap(),
    /// correctly merged partial state instead of per-partition-truncated results.
            !result_modes.contains(&AggregateMode::Final),
        .rules
            plan_string(&result)
/// `has_topk`: when true and stripping to Partial, replaces Final/FinalPartitioned with
use std::sync::Arc;
        );
        .map(|c| strip_redundant_shuffle_repartition(Arc::clone(c)))
    /// for engine-native-merge (dc/HLL) queries.
                }
            !display_after.contains("mode=Final"),
        assert!(
/// The strip is intentionally narrow: we only remove a `RepartitionExec` whose partitioning
use datafusion::physical_plan::{ExecutionPlan, ExecutionPlanProperties};
/// Walks down through any single-input wrapper (RelabelExec / RepartitionExec /
        // EnforceDistribution synthesizes when the FINAL aggregate demands hash partitioning
    fn test_preserve_round_robin_repartition_over_streaming_table() {
        (target, mode),
        );
/// is `Hash(...)` AND whose immediate child is a `StreamingTableExec`. Other RepartitionExec
                let new_schema = &new_child.schema();
                datafusion::physical_expr::Partitioning::Hash(
        ]));
        let display_before = plan_string(&plan);
        // pair we strip.
        // Final(Partial(memtable)) → strip to Partial only
            display_before.contains("AggregateExec: mode=Final"),
                return Ok(Arc::new(ProjectionExec::try_new(remapped, new_child)?));
    target: AggregateMode,
/// `Partitioning::UnknownPartitioning(N)` — it has no way to advertise that our M3 shuffle
            stripped.downcast_ref::<StreamingTableExec>().is_some(),
        // Final(Partial(memtable)) → strip to Final only (Partial removed)
        let new_child = force_aggregate_mode(old_child.clone(), target, has_topk)?;
                .with_config(SessionConfig::new())
/// a hash-distributable aggregate, it picks `FinalPartitioned` rather than `Final`. Treating
/// AggregateExec(Partial) and returns the entire Partial subtree (the
        );
    let new_children: Vec<Arc<dyn ExecutionPlan>> = plan
 * this file be licensed under the Apache-2.0 license or a
        let modes = find_agg_modes(&result);
        let hash_repart = Arc::new(
            let stripped = force_aggregate_mode(plan, AggregateMode::Final, false)?;
        // RepartitionExec(Hash) over an EmptyExec (or any non-streaming leaf) should NOT be
                Ok(Arc::clone(agg.input()))
        let is_hash = matches!(repart.partitioning(), Partitioning::Hash(_, _));
        }
        let modes = find_agg_modes(&plan);
                // (RepartitionExec(Hash) → Partial(×N)) so CSS partitions are merged by
                datafusion::physical_expr::Partitioning::RoundRobinBatch(4),
    matches!(
                    .expr()
        if modes.len() < 2 {
        let result = apply_aggregate_mode(plan, Mode::Partial, false).unwrap();
        assert!(
        // `FinalPartitioned` for grouped aggregates that consume hash-partitioned input and
                    vec![Arc::new(
            )));
fn remap_column(
    async fn make_agg_plan() -> Arc<dyn ExecutionPlan> {
        );
}
) -> Arc<dyn PhysicalExpr> {
        let result = apply_aggregate_mode(plan, Mode::Partial, false).unwrap();
}
        plan.with_new_children(vec![new_child])
        displayable(plan.as_ref()).indent(true).to_string()
    if children.is_empty() {
        Ok(plan)
        .into_iter()
            return;
pub(crate) enum Mode {
use datafusion::physical_plan::coalesce_partitions::CoalescePartitionsExec;
            "Should contain Final: {}",
                || display_before.contains("mode=Final"),
        // with_new_children triggers it. Remap columns to the post-strip schema so it passes.
                }
    None
        let display_after = plan_string(&stripped);
    /// Helper: create a SessionContext with CombinePartialFinalAggregate disabled,
            !rules.iter().any(|r| r.name() == combine_name),
