        .expect("post-optimization filter pushdown should not error");
    /// Whether at least one arriving filter was a DynamicFilterPhysicalExpr.
    );
    // Defaults are already true, but be explicit — this is the switch.
            props,
use datafusion::physical_expr::{EquivalenceProperties, LexOrdering, PhysicalSortExpr};
        ));
        write!(f, "RecordingLeaf")
 * SPDX-License-Identifier: Apache-2.0
    config.optimizer.enable_topk_dynamic_filter_pushdown = true;
        Ok(self)
        write!(f, "RecordingLeaf")
        "arrived filter should be the dynamic placeholder; got {:?}",
        "expected a DynamicFilterPhysicalExpr to reach the leaf; arrived filters = {:?}",
            Boundedness::Bounded,
//! `IndexedExec`/`QueryShardExec`: if the filter never reaches our leaf, the
#[derive(Default)]
//! **leaf** scan's `handle_child_pushdown_result` when a `SortExec { fetch }`
use datafusion::physical_plan::sorts::sort::SortExec;
            EquivalenceProperties::new(schema.clone()),
    /// claim support so the optimizer is happy.
        let mut statuses = Vec::new();
        1,
            observed,
    }
}
use datafusion::physical_optimizer::PhysicalOptimizerRule;
    fn schema(&self) -> SchemaRef {
        let mut obs = self.observed.lock().unwrap();
    let _optimized = rule
    fn new(schema: SchemaRef, observed: Arc<Mutex<Observed>>) -> Self {
    schema: SchemaRef,
            EmissionType::Incremental,
    // Exactly one filter arrives — the TopK self-filter. Its `Display` at plan
/// SortExec(ts DESC, fetch=Some(k)) over RecordingLeaf, then run the
            schema,
            f.filter
                    }
use datafusion::common::tree_node::{TreeNode, TreeNodeRecursion};
#![cfg(test)]
            statuses,
/// post-optimization FilterPushdown rule. Assert a dynamic filter arrived.
        options: datafusion::arrow::compute::SortOptions {
#[test]
    let schema = test_schema();
struct RecordingLeaf {
impl ExecutionPlan for RecordingLeaf {
    ) -> Result<FilterPushdownPropagation<Arc<dyn ExecutionPlan>>> {
        }
    assert!(
        _partition: usize,
                })
        Self {
    }
    ChildPushdownResult, FilterPushdownPhase, FilterPushdownPropagation, PushedDown,
    let sort_expr = PhysicalSortExpr {
        self.schema.clone()
//! the test is hermetic and fast.
    // value: we must downcast + walk the children to find the sort column.
        obs.arrived
                .apply(|e| {
        &self.props
        _phase: FilterPushdownPhase,
use datafusion::common::Result;
        expr: col("ts", &schema).unwrap(),
        ))
#[derive(Clone)]
//! `FilterPushdown` rule actually delivers a `DynamicFilterPhysicalExpr` to a
    }
    };
use datafusion::execution::{SendableRecordBatchStream, TaskContext};
        },
            obs.saw_dynamic |= is_dynamic;
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
}
    fn with_new_children(
        "RecordingLeaf"
    let obs = observed.lock().unwrap();
use datafusion::physical_expr::PhysicalExpr;
 *
            obs.arrived.push(format!("{}", f.filter));
        "expected exactly the TopK self-filter"
//! (TopK) sits above it.
    ) -> Result<SendableRecordBatchStream> {
/// `QueryShardExec` for the purpose of this probe — a leaf with no children that
    }
}
    }
    );
};
    /// filter, it arrives here as `parent_filters`. Record what we see and
    }
    let sort = Arc::new(SortExec::new(ordering, leaf).with_fetch(Some(10)));
    );
            nulls_first: false,
        Arc::new(RecordingLeaf::new(schema.clone(), Arc::clone(&observed)));
/// What a leaf observed in `handle_child_pushdown_result`. Shared out-of-band
    let mut config = ConfigOptions::default();
//! whole feature is moot. We model our scan with a minimal recording leaf so
        obs.arrived.len(),
}
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
fn test_schema() -> SchemaRef {
    DisplayAs, DisplayFormatType, ExecutionPlan, Partitioning, PlanProperties,
impl fmt::Debug for RecordingLeaf {
        Field::new("brand", DataType::Utf8, true),
    fn fmt_as(&self, _t: DisplayFormatType, f: &mut fmt::Formatter) -> fmt::Result {
impl DisplayAs for RecordingLeaf {
    let leaf: Arc<dyn ExecutionPlan> =
        _context: Arc<TaskContext>,
    // `ts > <threshold>` value materializes only at runtime via snapshot()).
            descending: true,
/// Minimal leaf scan that records the filters pushed to it. Mirrors the role of
        }
        obs.saw_dynamic,
                    if e.downcast_ref::<DynamicFilterPhysicalExpr>().is_some() {
    let ordering = LexOrdering::new(vec![sort_expr]).unwrap();
/// (the optimizer clones/rebuilds nodes, so we can't read it back off the plan).
    observed: Arc<Mutex<Observed>>,
                        is_dynamic = true;
        unreachable!("probe test never executes the plan")
    }
}
        Field::new("ts", DataType::Int64, false),
use datafusion::physical_optimizer::filter_pushdown::FilterPushdown;
    fn handle_child_pushdown_result(
    Arc::new(Schema::new(vec![
        obs.arrived[0].contains("DynamicFilter"),
            // Detect a DynamicFilterPhysicalExpr anywhere in the expr tree.
    assert_eq!(
        vec![]
    saw_dynamic: bool,
use datafusion::physical_plan::execution_plan::{Boundedness, EmissionType};
    let rule = FilterPushdown::new_post_optimization();
}
//! This is the make-or-break prerequisite for wiring dynamic filters into
        .optimize(sort, &config)
        child_pushdown_result: ChildPushdownResult,
//!
            Partitioning::UnknownPartitioning(1),
        self: Arc<Self>,
    }
    assert!(
use datafusion::physical_plan::filter_pushdown::{
        let props = Arc::new(PlanProperties::new(
/*
            statuses.push(PushedDown::Yes);
    ]))
    props: Arc<PlanProperties>,
use datafusion::physical_plan::{
    /// The behaviour under test: when the TopK above us pushes its dynamic
    fn children(&self) -> Vec<&Arc<dyn ExecutionPlan>> {
    // ORDER BY ts DESC LIMIT 10
use std::fmt;
 * this file be licensed under the Apache-2.0 license or a
    }
        obs.arrived
        &self,
use std::sync::{Arc, Mutex};
use datafusion::common::config::ConfigOptions;
            let mut is_dynamic = false;
};
    fn execute(
    fn properties(&self) -> &Arc<PlanProperties> {
    }
        &self,
    let observed = Arc::new(Mutex::new(Observed::default()));
fn dynamic_filter_reaches_leaf_under_topk() {
impl RecordingLeaf {
 * The OpenSearch Contributors require contributions made to
struct Observed {
                    Ok(TreeNodeRecursion::Continue)
    ) -> Result<Arc<dyn ExecutionPlan>> {
        for f in &child_pushdown_result.parent_filters {
    // time is the opaque `DynamicFilter [ empty ]` placeholder (the concrete
    config.optimizer.enable_dynamic_filter_pushdown = true;
 * compatible open source license.
/// must accept a Post-phase dynamic filter.
        Ok(FilterPushdownPropagation::with_parent_pushdown_result(
    /// Stringified filters that arrived as parent_filters.
    // This is *why* acceptance keys on the referenced columns, not the printed
                .ok();
use datafusion::physical_expr::expressions::{col, DynamicFilterPhysicalExpr};
}
    arrived: Vec<String>,
    fn name(&self) -> &str {
        _children: Vec<Arc<dyn ExecutionPlan>>,
//! Probe test (no production code): confirms that DataFusion's post-optimization
        _config: &ConfigOptions,
 */
}
