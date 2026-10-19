    schema: &arrow::datatypes::SchemaRef,
        ) as Arc<dyn ExecutionPlan>;
            )
                .with_physical_optimizer_rules(physical_optimizer_rules_without_combine())
                let new_schema = &new_child.schema();
            }
}
}
        let stripped = strip_redundant_shuffle_repartition(Arc::clone(&hash_repart)).unwrap();
                datafusion::physical_expr::Partitioning::Hash(
        assert!(
    }
        assert!(
use datafusion::physical_plan::expressions::Column;
        // repartition; data is already hash-partitioned by our M3 shuffle.
        assert!(
            if old_child.schema() != new_child.schema() {
        }
//! Aggregate mode stripping for distributed partial/final execution.
    async fn test_strip_final_over_scan() {
/// a hash-distributable aggregate, it picks `FinalPartitioned` rather than `Final`. Treating
                .with_physical_optimizer_rules(physical_optimizer_rules_without_combine())
    plan: &Arc<dyn ExecutionPlan>,
            plan_string(&result)
    has_topk: bool,
    }
        df.create_physical_plan().await.unwrap()
            // If optimizer collapsed it, just verify Mode::Partial works
        let new_child = force_aggregate_mode(old_child.clone(), target, has_topk)?;
        // Final(Partial(memtable)) → strip to Final only (Partial removed)
        let old_child = Arc::clone(plan.children()[0]);
        let ctx = SessionContext::new_with_state(
use datafusion_common::Result;
/// `EnforceDistribution` inserts that repartition because `StreamingTableExec` declares
                        agg.filter_expr().to_vec(),
        }
        let hash_repart = Arc::new(
                    vec![Arc::new(
        assert!(
/// Used by `derive_schema_from_partial_plan` where we only need types, not an executable plan.
        let result_modes = find_agg_modes(&result);
        let result = apply_aggregate_mode(plan, Mode::Partial, true).unwrap();
        // Hash-RepartitionExec sitting directly on a StreamingTableExec — exactly the shape
        let plan = make_agg_plan().await;
    }
///
                arrow::datatypes::Schema::new(vec![arrow::datatypes::Field::new(
            )));
    let fallback = expr.clone();
        );
        ctx.register_batch("t", batch).unwrap();
                // Current node is Partial; skip it, return its child
    }
        let plan = make_agg_plan().await;
        // Non-Partial aggregate (Final/FinalPartitioned) — look into its input for Partial
            "Should contain Partial: {}",
        let ctx = SessionContext::new_with_state(
        // Round-robin Repartition over a StreamingTableExec is a different shape (e.g. for
                .with_default_features()
    matches!(
    plan: Arc<dyn ExecutionPlan>,
            "expected Partial in plan"
    plan.with_new_children(new_children)
        }
        .collect();
        assert!(
                    false,
        let mut modes = Vec::new();
/// Whether `mode` is the same logical half as `target`. `Final` matches both `Final` and
        config.options_mut().execution.target_partitions = 4;
        );
}
fn force_aggregate_mode(
            display_before.contains("AggregateExec: mode=Final"),
                    return Ok(Arc::new(AggregateExec::try_new(
    /// When has_topk=true and the input has multiple partitions (CSS), Final/FinalPartitioned
/// the two as the same logical "final" half keeps the strip correct in both shapes.
/// Returns the output schema of the Partial aggregate without rebuilding the plan tree.
) -> Result<Arc<dyn ExecutionPlan>> {
        let child_is_streaming = child.downcast_ref::<StreamingTableExec>().is_some();
                    )],
            let result_modes = find_agg_modes(&result);
    fn test_preserve_hash_repartition_over_non_streaming_input() {
            plan_string(&result)
        ]));
        }
        assert!(
                let child = agg.children()[0];
    )
}
        );
            // Keep this node, recurse into children
        )
            plan_string(&plan)
            plan_string(&stripped)
/// repartition is therefore a no-op (rows are already in the right partition) but costs one
                        datafusion::physical_expr::expressions::Column::new("x", 0),
        let result_modes = find_agg_modes(&result);
        // load balancing pre-Final) — the strip must NOT touch it.
                        agg.group_expr().clone(),
    } else {
    Final,
        assert!(
                    .map(|pe| (remap_column(pe.expr.clone(), new_schema), pe.alias.clone()))
    async fn test_apply_partial_with_topk_produces_partial_reduce() {
                )]),
            "has_topk=true with multi-partition input must produce PartialReduce, got modes: {modes:?}"
        .into_iter()
        }
        assert!(
        let result = apply_aggregate_mode(plan, Mode::Final, false).unwrap();
        if *agg.mode() == AggregateMode::Partial {
}
            "CombinePartialFinalAggregate should be filtered out"
    target: AggregateMode,
use datafusion::physical_plan::{ExecutionPlan, ExecutionPlanProperties};
        let result_modes = find_agg_modes(&result);
                // Current node is Final/FinalPartitioned.
    if let Some(col) = expr.downcast_ref::<Column>() {
        let df = ctx.sql("SELECT x, SUM(x) FROM t GROUP BY x").await.unwrap();
use datafusion::physical_plan::coalesce_partitions::CoalescePartitionsExec;
        .filter(|r| r.name() != combine_name)
        );
        let rr_repart = Arc::new(
    use datafusion::physical_plan::displayable;
            "Should NOT contain Final after strip: {}\nOriginal: {}",
        return find_partial_input(Arc::clone(children[0]));
}
        // Final → Repartition/Coalesce → Partial → scan; strip to Partial
    if mode == target {
            "Should contain Final: {}",
    fn contains_node(plan: &Arc<dyn ExecutionPlan>, name: &str) -> bool {
        // Final → CoalescePartitions → Partial → scan; strip to Final
            "RepartitionExec(Hash) over StreamingTableExec must be stripped to the leaf, got: {}",
        );
        .map(|c| strip_redundant_shuffle_repartition(Arc::clone(c)))
                .map(|c| force_aggregate_mode(Arc::clone(c), target, has_topk))
///
        let schema = Arc::new(arrow::datatypes::Schema::new(vec![
            AggregateMode::Partial => {
                datafusion::physical_expr::Partitioning::RoundRobinBatch(4),
                .into_iter()
                .collect::<Result<_>>()?;
    /// for engine-native-merge (dc/HLL) queries.
        if is_hash && child_is_streaming {
            modes.contains(&AggregateMode::Final) || modes.contains(&AggregateMode::Partial),
                        agg.input_schema(),
        let modes = find_agg_modes(&result);
        if modes.len() < 2 {
    }
            "Final should be stripped"
    #[tokio::test]
        );
 * The OpenSearch Contributors require contributions made to
/*
                    arrow::datatypes::DataType::Int64,
    /// Helper: create a plan with Repartition between Final and Partial.
            AggregateMode::Final => {
    }
    }
            datafusion::execution::SessionStateBuilder::new()
/// `Partitioning::UnknownPartitioning(N)` — it has no way to advertise that our M3 shuffle
        let display_before = plan_string(&plan);
    #[test]
) -> Option<arrow::datatypes::SchemaRef> {
            plan_string(&result)
    }
            modes.push(*agg.mode());
/// `FinalPartitioned` (per-partition merge over hash-distributed input). This matters for
/// Removes a `RepartitionExec(Hash)` that sits directly above a `StreamingTableExec`.
    async fn make_agg_plan_with_repartition() -> Arc<dyn ExecutionPlan> {
                if has_topk && agg.input().output_partitioning().partition_count() > 1 {
            "Plan should have aggregate nodes: {}",
mod tests {
    let combine_name = CombinePartialFinalAggregate::new().name().to_string();
    /// Verifies apply_aggregate_mode(Partial) strips the Final aggregate and keeps
            !modes.contains(&AggregateMode::Final)
    /// must be replaced with PartialReduce rather than stripped, so the coordinator receives
        displayable(plan.as_ref()).indent(true).to_string()
        );
        .children()
        assert!(
            "Round-robin Repartition over StreamingTable must be preserved, got: {}",
            "Final/FinalPartitioned must not remain after stripping"
            "Should NOT contain Final: {}",
        plan.children().iter().any(|c| contains_node(c, name))
/// Applies aggregate mode stripping to a physical plan.
    }
        ) as Arc<dyn ExecutionPlan>;
        return find_partial_input(Arc::clone(agg.input()));
        );
/// Updates Column expression names to match the given schema (by index). Recurses into children.
    /// correctly merged partial state instead of per-partition-truncated results.
pub(crate) fn partial_aggregate_schema(
        assert!(
        );
        // With target_partitions=4 and GROUP BY, DF produces FinalPartitioned.
            "Should contain Final: {}",
                Ok(Arc::clone(agg.input()))
}
    #[tokio::test]
                arrow::datatypes::Field::new("x", arrow::datatypes::DataType::Int64, false),
            datafusion::execution::SessionStateBuilder::new()
        }
            return true;
fn remap_column(
                        datafusion::physical_expr::expressions::Column::new("x", 0),
        if mode_matches_target(*agg.mode(), target) {
            RepartitionExec::try_new(
            assert!(!result_modes.contains(&AggregateMode::Final));
        assert!(
        let (_tx, rx) = crate::partition_stream::channel(Arc::clone(&schema));
        // DataFusion's ProjectionMapping::try_new asserts col.name() == input_schema.field(i).name();
        let display_before = plan_string(&plan);
        // `Final` for scalar / un-partitioned ones. Both are the FINAL half of the Partial/Final
    if let Some(agg) = plan.downcast_ref::<AggregateExec>() {
            plan_string(&stripped)
    /// — fine for plan-shape assertions that don't actually execute.
    /// only the Partial subtree — the core behavior the indexed executor relies on
            .unwrap(),
        );
) -> Vec<Arc<dyn PhysicalOptimizerRule + Send + Sync>> {
    use datafusion::prelude::*;
    }
            }
                // group key before TopK truncation. Skip when input_partitions=1 — PartialReduce
        assert!(
            !rules.iter().any(|r| r.name() == combine_name),
        (AggregateMode::Final, AggregateMode::FinalPartitioned)
        let plan = make_agg_plan_with_repartition().await;
                    return Ok(partial_subtree);
        );
        // `FinalPartitioned` for grouped aggregates that consume hash-partitioned input and
        return Arc::new(Column::new(schema.field(col.index()).name(), col.index()));
        // GROUP BY forces repartition with multiple target partitions
/// CoalescePartitionsExec / ProjectionExec / etc.) to find an
        plan.with_new_children(vec![new_child])
    } else if plan.children().len() == 1 {
            Arc::new(datafusion::physical_plan::empty::EmptyExec::new(Arc::new(
        );
    }
        );
    use super::*;
                // (the Final above will keep itself)
    }
        // Leaf or multi-input node — return as-is
        assert!(!rules.is_empty(), "Should have other optimizer rules");
        .unwrap();
                    vec![Arc::new(
    /// Helper: create a SessionContext with CombinePartialFinalAggregate disabled,
    }
/// is `Hash(...)` AND whose immediate child is a `StreamingTableExec`. Other RepartitionExec
/// hash + one buffer per batch on the worker. Stripping it is correctness-preserving.
                    .iter()
        df.create_physical_plan().await.unwrap()
        // Final(Partial(memtable)) → strip to Partial only
use datafusion::physical_plan::projection::ProjectionExec;
        let is_hash = matches!(repart.partitioning(), Partitioning::Hash(_, _));
        );
        let child = repart.children()[0];
    #[tokio::test]
/// `AggregateMode::Final` matches both `Final` (single-partition merge) and
                        agg.aggr_expr().to_vec(),
            .unwrap(),
pub(crate) enum Mode {
use datafusion::physical_plan::streaming::StreamingTableExec;
            return Some(plan);
        let leaf = streaming_table_leaf();
        );
            display_after.contains("mode=Partial"),
/// shapes (round-robin coalescing, hash for a non-shuffle child) are left alone.
        assert!(
        }
    find_partial_input(Arc::clone(plan)).map(|p| p.schema())
                // with PartialReduce instead of stripping. PartialReduce keeps agg.input()
 * this file be licensed under the Apache-2.0 license or a
        );
/// Returns the default physical optimizer rules with `CombinePartialFinalAggregate` removed.
        let stripped = strip_redundant_shuffle_repartition(Arc::clone(&rr_repart)).unwrap();
            "Should NOT contain Partial: {}",
        let result = apply_aggregate_mode(plan, Mode::Partial, false).unwrap();
    }
        let modes = find_agg_modes(&plan);
        }
                .build(),
    /// drop-in plan leaf. The channel is closed immediately so the stream is empty
                    "x",
        // EnforceDistribution synthesizes when the FINAL aggregate demands hash partitioning
        let plan_str = plan_string(&plan);
        )
            return plan.with_new_children(new_children);
    if new_children.is_empty() {
        let plan = make_agg_plan_with_repartition().await;
            let result = apply_aggregate_mode(plan, Mode::Partial, false).unwrap();
    fn find_agg_modes(plan: &Arc<dyn ExecutionPlan>) -> Vec<AggregateMode> {
    fn plan_string(plan: &Arc<dyn ExecutionPlan>) -> String {
        let hash_repart = Arc::new(
                // (RepartitionExec(Hash) → Partial(×N)) so CSS partitions are merged by
                .with_config(config)
                return Ok(Arc::new(ProjectionExec::try_new(remapped, new_child)?));
    expr.with_new_children(new_children).unwrap_or(fallback)
/// AggregateExec(Partial) and returns the entire Partial subtree (the
        // stripped — the rows aren't already hash-partitioned by an upstream shuffle.
        // pair we strip.
) -> Arc<dyn PhysicalExpr> {
        );
    }
                let remapped: Vec<(Arc<dyn PhysicalExpr>, String)> = proj
                Arc::clone(&leaf),
}
    if children.is_empty() {
        )
        return expr;
    fn streaming_table_leaf() -> Arc<dyn ExecutionPlan> {
            ])),
    #[tokio::test]
        modes
        .into_iter()
            }
    fn test_strip_redundant_hash_repartition_over_streaming_table() {
    async fn test_strip_partial_past_repartition() {
                    4,
            plan_string(&result)
        }
        let batch = arrow_array::RecordBatch::try_new(
            plan_string(&result)
        Mode::Partial => force_aggregate_mode(plan, AggregateMode::Partial, has_topk),
                .with_default_features()
    PhysicalOptimizer::new()
/// AggregateExec node itself, not just its input).
    #[test]
            plan_string(&stripped)
        let combine_name = CombinePartialFinalAggregate::new().name().to_string();
    plan: Arc<dyn ExecutionPlan>,
        let batch = arrow_array::RecordBatch::try_new(
    None
use datafusion::physical_plan::repartition::RepartitionExec;
/// `FinalPartitioned` (same merge half, different child distribution). All other pairings
    if let Some(agg) = plan.downcast_ref::<AggregateExec>() {
    #[tokio::test]
        let modes = find_agg_modes(&plan);
                .build(),
    }
        return true;
        Mode::Default => Ok(plan),
            return Ok(Arc::clone(child));
            plan_str
 * compatible open source license.
    }
use datafusion::physical_expr::{Partitioning, PhysicalExpr};
            !result_modes.contains(&AggregateMode::Final),
    fn test_preserve_round_robin_repartition_over_streaming_table() {
        // but StreamingTableExec advertises UnknownPartitioning. The strip must remove the
        .unwrap();
                force_aggregate_mode(Arc::clone(child), target, false)
        let result = apply_aggregate_mode(plan, Mode::Final, false).unwrap();
    let children = expr.children();
        if let Some(proj) = plan.downcast_ref::<ProjectionExec>() {
            "Hash-Repartition over non-streaming input must be preserved, got: {}",
        let stripped = apply_aggregate_mode(plan, Mode::Partial, false).unwrap();
            let stripped = force_aggregate_mode(plan, AggregateMode::Final, false)?;
    }
        assert!(
    let new_children: Vec<_> = children
                    .expr()
                if let Some(partial_subtree) = find_partial_input(Arc::clone(agg.input())) {
fn mode_matches_target(mode: AggregateMode, target: AggregateMode) -> bool {
        );
            plan_string(&result)
            let new_children: Vec<Arc<dyn ExecutionPlan>> = agg
    fn test_combine_rule_absent() {
use datafusion::physical_plan::aggregates::{AggregateExec, AggregateMode};
fn strip_redundant_shuffle_repartition(
        Arc::new(
                || display_before.contains("mode=Final"),
        // Verify the plan has the expected structure
            !display_after.contains("mode=Final"),
                    )],
        // Single-input wrapper — recurse transparently.
///
/// PartialReduce so CSS partitions are merged by group key before the TopK sort truncates.
    async fn test_strip_partial_over_scan() {
        if plan.name().contains(name) {
        let df = ctx.sql("SELECT SUM(x) FROM t").await.unwrap();
        .map(|c| remap_column(c.clone(), schema))
        // RepartitionExec(Hash) over an EmptyExec (or any non-streaming leaf) should NOT be
        assert!(
        let rules = physical_optimizer_rules_without_combine();
    let new_children: Vec<Arc<dyn ExecutionPlan>> = plan
            arrow::datatypes::Field::new("x", arrow::datatypes::DataType::Int64, false),
/// require an exact mode match.
            !result_modes.contains(&AggregateMode::Partial),
        .collect::<Result<_>>()?;
    }
        let partition: Arc<dyn datafusion::physical_plan::streaming::PartitionStream> =
        // with_new_children triggers it. Remap columns to the post-strip schema so it passes.
                .with_config(SessionConfig::new())
#[cfg(test)]
        return Ok(plan);
    let children = plan.children();
    /// register a memtable, and produce a physical plan for `SELECT SUM(x) FROM t`.
    if children.len() == 1 {
        let leaf: Arc<dyn ExecutionPlan> =
    mode: Mode,
            strip_redundant_shuffle_repartition(stripped)
                && !modes.contains(&AggregateMode::FinalPartitioned),
        assert!(
) -> Result<Arc<dyn ExecutionPlan>> {
            ])),
        );
        assert!(
                    4,
        let plan = make_agg_plan().await;
        );
            !result_modes.contains(&AggregateMode::Partial),
/// The strip is intentionally narrow: we only remove a `RepartitionExec` whose partitioning
        (target, mode),
                ),
        Ok(plan)
            modes.contains(&AggregateMode::PartialReduce),
        ) as Arc<dyn ExecutionPlan>;
            plan_string(&result),
    #[test]
                // over a single partition is redundant and adds unnecessary overhead.
    async fn test_apply_partial_strips_final() {
) -> Result<Arc<dyn ExecutionPlan>> {
            stripped.downcast_ref::<StreamingTableExec>().is_some(),
                ),
            !result_modes.contains(&AggregateMode::Final),
            Arc::new(arrow::datatypes::Schema::new(vec![
    async fn make_agg_plan() -> Arc<dyn ExecutionPlan> {
        if let Some(agg) = plan.downcast_ref::<AggregateExec>() {
        assert!(
    has_topk: bool,
            result_modes.contains(&AggregateMode::Final),
                    .collect();
            Arc::new(arrow::datatypes::Schema::new(vec![
                // When TopK is active and the input has multiple partitions (CSS), replace
                // Normal path: strip Final, return Partial subtree
 */
    }
/// Walks the plan tree and strips the half that doesn't match `target`.
pub(crate) fn apply_aggregate_mode(
 *
        .collect()
            "Should NOT contain Partial after strip: {}",
                Arc::clone(&leaf),
                .children()
    plan: Arc<dyn ExecutionPlan>,
            "Partial should remain"
            )
        for child in plan.children() {
            RepartitionExec::try_new(
use datafusion::physical_optimizer::combine_partial_final_agg::CombinePartialFinalAggregate;
            vec![Arc::new(arrow_array::Int64Array::from(vec![1, 2, 3]))],
            result_modes.contains(&AggregateMode::Final),
    }
            result_modes.contains(&AggregateMode::Partial),
            display_before.contains("mode=FinalPartitioned")
            modes.extend(find_agg_modes(child));
        assert!(
        Mode::Final => {
    expr: Arc<dyn PhysicalExpr>,
            "expected Final in plan"
            )
                }
        let mut config = SessionConfig::new();
/// the M3 worker-side path: when `EnforceDistribution` sees a multi-partition input feeding
            .unwrap(),
    #[tokio::test]
            return;
            _ => Ok(plan),
        let result_modes = find_agg_modes(&result);
use datafusion::physical_optimizer::optimizer::{PhysicalOptimizer, PhysicalOptimizerRule};
        // Treat `FinalPartitioned` as `Final` (see mode_matches_target): DataFusion picks
/// `has_topk`: when true and stripping to Partial, replaces Final/FinalPartitioned with
    }
        let result = apply_aggregate_mode(plan, Mode::Partial, false).unwrap();
        // The simple plan has CoalescePartitions between Final and Partial
pub(crate) fn physical_optimizer_rules_without_combine(
            StreamingTableExec::try_new(schema, vec![partition], None, None, false, None).unwrap(),
        let leaf = streaming_table_leaf();
    if let Some(repart) = plan.downcast_ref::<RepartitionExec>() {
                        Arc::clone(agg.input()),
        );
                arrow::datatypes::Field::new("x", arrow::datatypes::DataType::Int64, false),
    /// Builds a 1-partition StreamingTableExec over a closed channel for use as a
        let plan = make_agg_plan().await;
}
#[derive(Clone, Copy, Debug, PartialEq)]
        .rules
                datafusion::physical_expr::Partitioning::Hash(
                Arc::clone(&leaf),
/// already hash-partitioned the rows by the same keys with the same partition count. The
use std::sync::Arc;
        match target {
            stripped.downcast_ref::<RepartitionExec>().is_some(),
    }
    match mode {
        ctx.register_batch("t", batch).unwrap();
                }
            stripped.downcast_ref::<RepartitionExec>().is_some(),
            vec![Arc::new(arrow_array::Int64Array::from(vec![1, 2, 3]))],
        // Mode mismatch — strip this node
        .into_iter()
    Partial,
    #[test]
fn find_partial_input(plan: Arc<dyn ExecutionPlan>) -> Option<Arc<dyn ExecutionPlan>> {
 * SPDX-License-Identifier: Apache-2.0
            RepartitionExec::try_new(
            "expected Final/FinalPartitioned in multi-partition plan, got:\n{display_before}"
        let stripped = strip_redundant_shuffle_repartition(Arc::clone(&hash_repart)).unwrap();
    Default,
            display_before.contains("AggregateExec: mode=Partial"),
                        AggregateMode::PartialReduce,
}
            Arc::new(crate::partition_stream::SingleReceiverPartition::new(rx));
    }
    }
/// Walks down through any single-input wrapper (RelabelExec / RepartitionExec /
        }
                    )?));
        let display_after = plan_string(&stripped);
    async fn test_strip_final_past_coalesce() {
