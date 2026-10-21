        Field::new("brand", DataType::Utf8, true),
//! `IndexedExec`/`QueryShardExec`: if the filter never reaches our leaf, the
    }
            let mut is_dynamic = false;
    /// Whether at least one arriving filter was a DynamicFilterPhysicalExpr.
    /// filter, it arrives here as `parent_filters`. Record what we see and
impl fmt::Debug for RecordingLeaf {
                .apply(|e| {
    assert!(
        "expected a DynamicFilterPhysicalExpr to reach the leaf; arrived filters = {:?}",
        let mut statuses = Vec::new();
    // value: we must downcast + walk the children to find the sort column.
    saw_dynamic: bool,
/// What a leaf observed in `handle_child_pushdown_result`. Shared out-of-band
    }
        obs.arrived.len(),
 * SPDX-License-Identifier: Apache-2.0
#[test]
        Field::new("ts", DataType::Int64, false),
}
        write!(f, "RecordingLeaf")
use datafusion::execution::{SendableRecordBatchStream, TaskContext};
/// post-optimization FilterPushdown rule. Assert a dynamic filter arrived.
        obs.arrived[0].contains("DynamicFilter"),
        write!(f, "RecordingLeaf")
use datafusion::physical_plan::filter_pushdown::{
        options: datafusion::arrow::compute::SortOptions {
    };
#[derive(Clone)]
        .optimize(sort, &config)
    }
use std::sync::{Arc, Mutex};
 * this file be licensed under the Apache-2.0 license or a
//! the test is hermetic and fast.
        Ok(self)
}
struct Observed {
        let mut obs = self.observed.lock().unwrap();
        &self.props
use datafusion::common::tree_node::{TreeNode, TreeNodeRecursion};
    config.optimizer.enable_dynamic_filter_pushdown = true;
 *
    }
    ]))
            Partitioning::UnknownPartitioning(1),
    fn name(&self) -> &str {
            f.filter
use datafusion::common::Result;
        Arc::new(RecordingLeaf::new(schema.clone(), Arc::clone(&observed)));
    fn schema(&self) -> SchemaRef {
    /// Stringified filters that arrived as parent_filters.
/// must accept a Post-phase dynamic filter.
    let observed = Arc::new(Mutex::new(Observed::default()));
use datafusion::physical_plan::execution_plan::{Boundedness, EmissionType};
    fn children(&self) -> Vec<&Arc<dyn ExecutionPlan>> {
//! (TopK) sits above it.
        _partition: usize,
    ) -> Result<SendableRecordBatchStream> {
    fn properties(&self) -> &Arc<PlanProperties> {
use datafusion::physical_expr::PhysicalExpr;
    ChildPushdownResult, FilterPushdownPhase, FilterPushdownPropagation, PushedDown,
    fn fmt_as(&self, _t: DisplayFormatType, f: &mut fmt::Formatter) -> fmt::Result {
//! whole feature is moot. We model our scan with a minimal recording leaf so
    }
    assert!(
    arrived: Vec<String>,
    // This is *why* acceptance keys on the referenced columns, not the printed
/// Minimal leaf scan that records the filters pushed to it. Mirrors the role of
impl RecordingLeaf {
use datafusion::physical_plan::sorts::sort::SortExec;
        }
    }
    Arc::new(Schema::new(vec![
    fn with_new_children(
        Ok(FilterPushdownPropagation::with_parent_pushdown_result(
/// SortExec(ts DESC, fetch=Some(k)) over RecordingLeaf, then run the
            EmissionType::Incremental,
//! This is the make-or-break prerequisite for wiring dynamic filters into
    fn handle_child_pushdown_result(
    }
    let _optimized = rule
        .expect("post-optimization filter pushdown should not error");
    );
            statuses,
        },
    props: Arc<PlanProperties>,
}
            Boundedness::Bounded,
    config.optimizer.enable_topk_dynamic_filter_pushdown = true;
                    Ok(TreeNodeRecursion::Continue)
use datafusion::physical_expr::{EquivalenceProperties, LexOrdering, PhysicalSortExpr};
    // Defaults are already true, but be explicit — this is the switch.
    let schema = test_schema();
    let ordering = LexOrdering::new(vec![sort_expr]).unwrap();
}
    /// claim support so the optimizer is happy.
 * compatible open source license.
#[derive(Default)]
};
            // Detect a DynamicFilterPhysicalExpr anywhere in the expr tree.
};
    let leaf: Arc<dyn ExecutionPlan> =
        child_pushdown_result: ChildPushdownResult,
            observed,
        _config: &ConfigOptions,
                })
        obs.saw_dynamic,
        self.schema.clone()
    observed: Arc<Mutex<Observed>>,
impl ExecutionPlan for RecordingLeaf {
use datafusion::physical_optimizer::PhysicalOptimizerRule;
        expr: col("ts", &schema).unwrap(),
/// `QueryShardExec` for the purpose of this probe — a leaf with no children that
        _children: Vec<Arc<dyn ExecutionPlan>>,
use datafusion::physical_plan::{
        "RecordingLeaf"
/*
/// (the optimizer clones/rebuilds nodes, so we can't read it back off the plan).
        vec![]
    let sort = Arc::new(SortExec::new(ordering, leaf).with_fetch(Some(10)));
//! Probe test (no production code): confirms that DataFusion's post-optimization
    /// The behaviour under test: when the TopK above us pushes its dynamic
fn test_schema() -> SchemaRef {
#![cfg(test)]
        self: Arc<Self>,
        _context: Arc<TaskContext>,
        1,
    // time is the opaque `DynamicFilter [ empty ]` placeholder (the concrete
    let obs = observed.lock().unwrap();
//! `FilterPushdown` rule actually delivers a `DynamicFilterPhysicalExpr` to a
    fn execute(
fn dynamic_filter_reaches_leaf_under_topk() {
        }
                    }
    schema: SchemaRef,
}
                .ok();
            obs.arrived.push(format!("{}", f.filter));
        unreachable!("probe test never executes the plan")
}
    fn new(schema: SchemaRef, observed: Arc<Mutex<Observed>>) -> Self {
            statuses.push(PushedDown::Yes);
        ));
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
use std::fmt;
        _phase: FilterPushdownPhase,
        obs.arrived
struct RecordingLeaf {
    // ORDER BY ts DESC LIMIT 10
        "arrived filter should be the dynamic placeholder; got {:?}",
        let props = Arc::new(PlanProperties::new(
            props,
use datafusion::physical_expr::expressions::{col, DynamicFilterPhysicalExpr};
        &self,
    }
        obs.arrived
//! **leaf** scan's `handle_child_pushdown_result` when a `SortExec { fetch }`
    // Exactly one filter arrives — the TopK self-filter. Its `Display` at plan
    let mut config = ConfigOptions::default();
            descending: true,
    let rule = FilterPushdown::new_post_optimization();
            obs.saw_dynamic |= is_dynamic;
            schema,
    // `ts > <threshold>` value materializes only at runtime via snapshot()).
//!
    }
use datafusion::physical_optimizer::filter_pushdown::FilterPushdown;
            nulls_first: false,
}
    assert_eq!(
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
    ) -> Result<FilterPushdownPropagation<Arc<dyn ExecutionPlan>>> {
impl DisplayAs for RecordingLeaf {
    }
                        is_dynamic = true;
use datafusion::common::config::ConfigOptions;
            EquivalenceProperties::new(schema.clone()),
        "expected exactly the TopK self-filter"
 */
        Self {
    );
}
    );
        ))
    ) -> Result<Arc<dyn ExecutionPlan>> {
        &self,
 * The OpenSearch Contributors require contributions made to
    let sort_expr = PhysicalSortExpr {
                    if e.downcast_ref::<DynamicFilterPhysicalExpr>().is_some() {
        for f in &child_pushdown_result.parent_filters {
    DisplayAs, DisplayFormatType, ExecutionPlan, Partitioning, PlanProperties,
