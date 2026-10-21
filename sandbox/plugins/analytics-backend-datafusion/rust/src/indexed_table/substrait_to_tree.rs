    fn literal_op_column_works() {
// ════════════════════════════════════════════════════════════════════════════
    fn classify_no_collectors_is_none() {
) -> Result<ExtractionResult, String> {
        let udf = Arc::new(create_index_filter_udf());
            datafusion::physical_expr::expressions::BinaryExpr::new(left, Operator::Eq, right),
                ])],
use super::bool_tree::BoolNode;
        }
/// NamedScan table name, but the parquet schema has bare column names.
    }
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state());
    /// Multiple `index_filter` calls, or OR/NOT mixing them with predicates.
        let expr = Expr::Not(Box::new(col("active").eq(lit(true))));
    ScalarUDF::new_from_impl(IndexFilterUdf::new())
        ))
        _ => false,
            vec![lit(ScalarValue::Int32(Some(42)))],
    }
    }
    match plan {
    }
    fn classify_nested_and_with_or_predicate_is_single() {
        // `price + 10` on its own is Int32, not Boolean → must error.
            // Args: (originalPredicate: Boolean, annotationId: Int32).
//!   factory at query-resolve time to create a provider.
    }
impl std::hash::Hash for IndexFilterUdf {
    fn eq(&self, other: &Self) -> bool {
            _ => false,
            Box::new(or_branch),
        let tree = BoolNode::Or(vec![collector(10), dummy_predicate()]);
    #[test]
    /// Exactly one `index_filter`, AND'd with parquet-native predicates.
/// is identified by arg 1 (used by the evaluator to call back into Java when
        // when it works correctly, DataFusion never evaluates the UDF as a
                    BoolNode::And(vec![collector(2), dummy_predicate()]),
    schema: &SchemaRef,
/// annotation id for opportunistic peer consultation in the evaluator.
        );
///
    Tree,
use datafusion::physical_expr::PhysicalExpr;
        // delegation_possible wrapper. On the indexed path, expr_to_bool_tree should
    /// Path B — `SingleCollectorEvaluator`, DataFusion handles residual via
        // comparison kernel rejects mixed types).
        let schema = test_schema();
    }
    fn signature(&self) -> &Signature {
        // `SessionState::create_physical_expr`, which runs the analyzer
    fn classify_nested_and_or_containing_collector_is_tree() {
                .map_err(|e| format!("data_type: {}", e))?;
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
pub const DELEGATION_POSSIBLE_FUNCTION_NAME: &str = "delegation_possible";
    #[test]
    // ── expr_to_bool_tree ────────────────────────────────────────────
    use datafusion::logical_expr::{col, lit};
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
                Some(filter.predicate.clone())
    fn classify_and_with_two_collectors_is_single() {
/// [`BoolNode::demote_delegation_possible`] for the rationale and trade-offs.
    }
        let tree = BoolNode::And(vec![
}
        )
    } else {
pub struct ExtractionResult {
    }
pub fn create_index_filter_udf() -> ScalarUDF {
/// - anything else (OR / NOT above a collector) → `FilterClass::Tree`
use datafusion::arrow::datatypes::{DataType, Schema, SchemaRef};
            BoolNode::And(vec![
/// Its presence signals the executor to emit computed row IDs (query phase).
        assert!(matches!(*r.tree, BoolNode::Predicate(_)));
// ════════════════════════════════════════════════════════════════════════════
//! expression is a tree of `Expr` nodes. This module walks that tree and
    #[test]
            .iter()
pub fn classify_filter(tree: &BoolNode) -> FilterClass {
    signature: Signature,
    use datafusion::arrow::datatypes::{Field, Schema};
    }
            .inputs()
}
        ));
    }
        self.name().hash(state);
    /// predicate pushdown.
}
        args.args.into_iter().next().ok_or_else(|| {
//!   DataFusion's `create_physical_expr`, wrapped in
        // AND(collector(annotationId), OR(price > 100, qty < 50))
            let left = convert_expr(&bin.left, schema, df_schema, state)?;
    None,
            Ok(BoolNode::Or(vec![left, right]))
                udf,
                assert_eq!(annotation_id, 42);
/// `delegated_predicate(annotationId)` — a single `Int32` literal arg.
        Ok(DataType::Boolean)
        annotation_id,
                .data_type(schema)
        // 100 < price — valid boolean expression, lowered as-is.
        let left: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new("price", col_idx));
            Field::new("price", DataType::Int32, false),
                Volatility::Immutable,
        let collector_expr =
/// - any AND-only tree (no OR/NOT above collectors) with ≥1 collector
    #[test]
        let expr = col("price") + lit(10i32);
    }
        }
        self.name().hash(state);
pub fn expr_to_bool_tree(
    fn hash<H: std::hash::Hasher>(&self, state: &mut H) {
            "delegation_possible UDF evaluated at runtime — expected only on \
            }
            if let Expr::Column(col) = &e {
fn convert_expr(
        SessionContext::new().state()
    }
/// ever executes, because a production execution of the body would silently
    Signature, TypeSignature, Volatility,
        DFSchema::try_from(schema.as_ref().clone()).map_err(|e| format!("DFSchema: {}", e))?;
        DELEGATION_POSSIBLE_FUNCTION_NAME
            } else {
                dummy_predicate(),
    }
        BoolNode::Predicate(Arc::new(
    /// Default session for tests that don't depend on session-scoped state.
/// Returns true when every collector in `tree` is reachable only
    }
/// short-circuit to the original predicate's value, masking a routing bug).
    }
//! Substrait → boolean tree conversion.
/// `Predicate` so the bitmap-tree evaluator (which has `unimplemented!()`
        })
    #[test]
    // DelegationPossible-only AND-shaped trees (e.g. `verb='GET' AND status=200` where both
}
        // analyzer and would produce mismatched-type kernels (e.g. parquet's
/// for the substrait consumer; `expr_to_bool_tree` recognizes the function by
        // Expected on the prepare_partial_plan path where FilterExec retains the
/// Strip table qualifiers from `Column` references in an `Expr` tree.
        let tree = BoolNode::And(vec![
//!   literal argument → `BoolNode::Collector { annotation_id }`. The ID
        // Anything else — comparison, IS NULL, IN, BETWEEN, arithmetic,
    })
            None
            ]),
        ));
        })
        );
        // not expression contents. Build a minimal boolean PhysicalExpr.
    fn return_type(&self, _: &[DataType]) -> datafusion::common::Result<DataType> {
            convert_delegation_possible_function(&func.args, schema, df_schema, state)
        | BoolNode::Predicate(_)
    fn simple_predicate() {
//! - `AND` / `OR` / `NOT` → `BoolNode::And` / `Or` / `Not`
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
        &self,
    fn not_predicate() {
            let right = convert_expr(&bin.right, schema, df_schema, state)?;
    }
/// `Arc<dyn PhysicalExpr>` via `create_physical_expr`. The expression at
            FilterClass::SingleCollector
        ]);
    #[test]
/// filters that sit above Aggregate or Window nodes (those reference derived
/// This UDF exists solely as a marker for `classify_filter` / `expr_to_bool_tree`.
                    "indexed-query expression must be boolean-valued, got {:?}: {:?}",
            Ok(BoolNode::Predicate(phys))
 */
            ))
        | LogicalPlan::Join(_)
        | LogicalPlan::Union(_) => true,
                        Expr::Column(datafusion::common::Column::new_unqualified(&col.name)),
        let expr = Expr::BinaryExpr(datafusion::logical_expr::BinaryExpr::new(
        // BETWEEN may desugar into And internally or stay as-is; either
///
                    return Some(expr);
    }
                DELEGATION_POSSIBLE_FUNCTION_NAME, e
}
/// in the shape), every `DelegationPossible` leaf is demoted to a plain
    }
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
/// Extract the scan-level filter from a logical plan, skipping HAVING/window
//!
fn extract_int32_literal(expr: &Expr) -> Result<i32, String> {
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
            dummy_predicate(),
/// DF's own pruning isn't selective enough for a row group).
        return FilterClass::None;
pub fn extract_filter_expr(plan: &LogicalPlan) -> Option<Expr> {
    // No Collector AND no DelegationPossible → no peer-backend involvement at all.
            let left = convert_expr(&bin.left, schema, df_schema, state)?;
//! `IndexFilterTree`; it rewrites `column = 'value'` on indexed columns to
    fn between_expression_is_accepted() {
    }
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
    fn hash<H: std::hash::Hasher>(&self, state: &mut H) {
    let original_expr = state
///   collectors + predicates are accepted; `single_collector_bytes`
    }
            let right = convert_expr(&bin.right, schema, df_schema, state)?;
                BoolNode::Not(Box::new(collector(11))),
    fn return_type(&self, _: &[DataType]) -> datafusion::common::Result<DataType> {
impl Eq for IndexFilterUdf {}
        BoolNode::Collector { annotation_id: id }
        }),
/// collector leaf). Predicates, ANDs, and collector leaves are fine;
        ]);
    args: &[Expr],
    #[test]
        assert!(matches!(*r.tree, BoolNode::Predicate(_)));
///   strips them to produce the predicate residual.
/// produce all-true results and mask a routing bug in the dispatcher.
                    DataType::Int32,
        tree
fn convert_delegation_possible_function(
    fn classify_nested_and_collector_plus_predicate_is_single() {
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
//!
    #[test]
//! **The substrait plan is the wire format.** Java never serializes an
#[cfg(test)]
        ]);
                vec![TypeSignature::Exact(vec![DataType::Int32])],
        // AND(C₁, AND(NOT(C₂), P)) — NOT above C₂ → Tree.
        // For DelegationPossible under OR/NOT specifically, Tree path currently
/// now that `Predicate` leaves carry `Arc<dyn PhysicalExpr>` directly.
    }
        Expr::ScalarFunction(func) if func.name() == DELEGATION_POSSIBLE_FUNCTION_NAME => {
    #[test]
            collector(10),
        let expr = col("price").in_list(vec![lit(5i32), lit(10i32), lit(15i32)], false);
        assert_eq!(classify_filter(&tree), FilterClass::Tree);
        let tree = BoolNode::Not(Box::new(collector(10)));
        // AND(C, NOT(P)) — NOT wraps a predicate, not a collector.
        LogicalPlan::Filter(filter) => {
    }
/// name and never lets DataFusion evaluate its body. The body returns a hard
/// - bare collector → `FilterClass::SingleCollector`
        // A stand-in Predicate leaf — classify only cares about shape,
struct DelegationPossibleUdf {
            "{} UDF body invoked — classify_filter did not recognize the marker; \
        let right: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(0))));
    match expr {
}
        .create_physical_expr(unqualified, df_schema)
        BoolNode::And(children) => children.iter().all(is_and_only_collector_tree),
            if return_type != DataType::Boolean {
    if tree.collector_leaf_count() == 0 && tree.delegation_possible_leaf_count() == 0 {
            ),
//! - `ScalarFunction` named `COLLECTOR_FUNCTION_NAME` with one `Binary`
        Arc::new(Schema::new(vec![
            ]),
    let df_schema =
}
            BoolNode::And(vec![
    })
    SingleCollector,
 * SPDX-License-Identifier: Apache-2.0
    use std::sync::Arc;
        // Leaves are trivially fine (no Collector or DelegationPossible below them).
    }
};
                Volatility::Immutable,
        }
            ),
            }
        assert!(matches!(*r.tree, BoolNode::Not(_)));
        LogicalPlan::Sort(s) => has_aggregate_or_window_below(&s.input),
        BoolNode::Or(_) | BoolNode::Not(_) => {
}
impl DelegationPossibleUdf {
        // AND(C, C, P) — all collectors under AND-only path → SingleCollector.
    }
        assert!(r.is_err());
fn convert_collector_function(args: &[Expr]) -> Result<BoolNode, String> {
}
                if col.relation.is_some() {
    fn new() -> Self {
/// Like `create_index_filter_udf`, this exists solely as a name-resolution stub
/// `schema` is used to lower non-combinator subexpressions to
            datafusion::common::DataFusionError::Internal(format!(
        return Err(format!(
            for child in plan.inputs() {
impl ScalarUDFImpl for IndexFilterUdf {
    if args.len() != 1 {
    }
        })?;
        // This body must never execute in production. `classify_filter`
    // ── classify_filter ──────────────────────────────────────────────
 * compatible open source license.
    Ok(BoolNode::Collector { annotation_id })
            Operator::And,
use std::sync::Arc;
        // AND(AND(C₁, C₂), AND(C₃, C₄)) — nested AND of only collectors.
        // producing wrong results. Fail loudly instead.
    fn non_boolean_expression_is_rejected() {
        .data
        // OR/NOT containing any Collector OR any DelegationPossible → Tree path.
        Err(datafusion::common::DataFusionError::Internal(format!(
    /// every `expr_to_bool_tree` call site repeats it.
        match *r.tree {
    // ── Nested AND shapes → SingleCollector ──────────────────────────
//! and that survives the substrait round-trip. Rust just reads it back out
                collector(0),
        // AND(P, AND(C₁, AND(C₂, AND(C₃, P)))) — depth 4, all AND.
        Self {
            if has_aggregate_or_window_below(&filter.input) {
            _ => panic!("expected Collector"),
        | BoolNode::DelegationPossible { .. } => true,
        log::warn!(
    }
        self.name() == other.name()
            let unqualified = strip_column_qualifiers(other);
    let tree = if classify_filter(&tree) == FilterClass::Tree {
    if is_and_only_collector_tree(tree) {
/// through AND nodes (no OR or NOT on the path from root to any
    }
            args.len()
        let expr = Expr::BinaryExpr(datafusion::logical_expr::BinaryExpr::new(
    fn new() -> Self {
        );
        let expr = col("price").gt(lit(100i32));
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
        match *r.tree {
        let tree = BoolNode::And(vec![
    fn and_of_predicates() {
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
        // pipeline (TypeCoercion, function rewrites) before lowering. The
            ]),
    fn classify_and_with_nested_collector_is_tree() {
        LogicalPlan::Limit(l) => has_aggregate_or_window_below(&l.input),
            BoolNode::And(vec![collector(0), collector(1)]),
}
    #[test]
    }
        // AND(C, AND(P, OR(P, P))) — OR contains only predicates, no collectors.
    fn classify_or_containing_collector_is_tree() {
pub fn plan_requests_row_ids(plan: &LogicalPlan) -> bool {
/// arms for `DelegationPossible`) doesn't crash. See
pub enum FilterClass {
        }
            Box::new(collector_expr),
    }
}
            DELEGATION_POSSIBLE_FUNCTION_NAME, return_type
        ]);
            collector(10),
    match plan {
/// Result of `expr_to_bool_tree` — just the tree. No sidecar list needed
            Box::new(lit(100i32)),
        let tree = BoolNode::And(vec![
use datafusion::logical_expr::{
        // freestanding `physical_expr::create_physical_expr` skips the
    }
//!   are the serialized backend query payload; they're handed to a Java
        // unwrap the marker before execution — log a warning if we reach here
        Expr::Not(inner) => {
    #[test]
/// columns that `expr_to_bool_tree` cannot resolve against the base schema).
///
fn has_aggregate_or_window_below(plan: &LogicalPlan) -> bool {
    fn invoke_with_args(
            collector(10),
        assert_eq!(
            BoolNode::And(vec![collector(2), collector(3)]),
}
    }
                ]),
        // `Utf8View` column compared against an `Utf8` literal — Arrow's
            BoolNode::Collector { annotation_id } => {
    #[test]
    };
        Ok(DataType::Boolean)
    #[test]
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
            BoolNode::Or(vec![collector(10), dummy_predicate()]),
 * this file be licensed under the Apache-2.0 license or a
    fn name(&self) -> &str {
        _ => Err(format!(
) -> Result<BoolNode, String> {
    }
            args.len()
            "{} expects 2 args (originalPredicate, annotationId), got {}",
    state: &SessionState,
    if args.len() != 2 {
/// Form: `delegation_possible(originalPredicate, annotationId)` — the original
    let tree = convert_expr(expr, schema, &df_schema, state)?;
                BoolNode::Or(vec![collector(11), dummy_predicate()]),
        let expr = Expr::ScalarFunction(datafusion::logical_expr::expr::ScalarFunction::new_udf(
    fn classify_and_of_collector_and_predicates_is_single() {
    fn classify_bare_collector_is_single() {
    schema: &Schema,
    }
    fn test_schema() -> SchemaRef {
//!
        _args: ScalarFunctionArgs,
    let annotation_id = extract_int32_literal(&args[1])?;
/// Walk the logical plan looking for `__row_id__` column in a projection.
//! After Substrait is decoded into a DataFusion `LogicalPlan`, the filter
        }
/// the UDF.
    if matches!(tree, BoolNode::Collector { .. }) {
    Ok(BoolNode::DelegationPossible {
        ));
impl IndexFilterUdf {
            COLLECTOR_FUNCTION_NAME, expr
/// Register in a `SessionContext` before decoding substrait plans that contain
/// `delegation_possible(originalPredicate, annotationId)` — preserve the original
        LogicalPlan::Aggregate(_)
        ]);
        assert!(matches!(*r.tree, BoolNode::Predicate(_)));
        FilterClass::SingleCollector
            udf,
}
        format!(
                "{} UDF invoked with no arguments",
//!   is accepted.
    state: &SessionState,
    fn dummy_predicate() -> BoolNode {
    }
        }
    match tree {
        }
    }
        assert_eq!(classify_filter(&tree), FilterClass::Tree);
        // (price + 10) > 100 — our old converter would reject this.
            let child = convert_expr(inner, schema, df_schema, state)?;
    #[test]
        ]);
    })?;
            )
                    DataType::Boolean,
            signature: Signature::one_of(
}
            collector(10),
    #[test]
                return Err(format!(
    expr: &Expr,
        COLLECTOR_FUNCTION_NAME
    #[test]
 *
        assert_eq!(classify_filter(&tree), FilterClass::Tree);
    #[test]
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
    fn classify_nested_and_with_not_predicate_is_single() {
        // CAST, UDF — gets lowered to a DataFusion PhysicalExpr via
        let expr = (col("price") + lit(10i32)).gt(lit(100i32));
                if let Some(expr) = extract_filter_expr(child) {
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
impl Eq for DelegationPossibleUdf {}
        let tree = BoolNode::And(vec![
    use datafusion::physical_expr::expressions::{Column as PhysColumn, Literal};
        )))
    fn mixed_tree() {
    }
    }
                vec![lit(ScalarValue::Int32(Some(0)))],
        &self.signature
            signature: Signature::one_of(
        assert!(e.contains("boolean"), "got: {}", e);
    }
    use super::*;
                vec![TypeSignature::Exact(vec![
    }
        }
    #[test]
                dummy_predicate(),
        FilterClass::Tree
use datafusion::common::{DFSchema, ScalarValue};
            convert_collector_function(&func.args)
    df_schema: &DFSchema,
#[derive(Debug)]
    let unqualified = strip_column_qualifiers(&args[0]);
        Expr::Literal(ScalarValue::Int32(Some(v)), _) => Ok(*v),
        ));
    df_schema: &DFSchema,
///
        ]);
        _ => {
    pub tree: Arc<BoolNode>,
    fn name(&self) -> &str {
        return Err(format!(
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
    fn test_state() -> datafusion::execution::SessionState {
            Ok(BoolNode::Not(Box::new(child)))
            DELEGATION_POSSIBLE_FUNCTION_NAME, e
//! of the decoded `LogicalPlan`.
    /// Inline-equivalent to `SessionContext::new().state()` — extracted because
            let return_type = phys
            }
                "create_physical_expr for {} arg 0: {}",
#[derive(Debug)]
 * The OpenSearch Contributors require contributions made to
        args: ScalarFunctionArgs,
            Expr::Column(col) => col.name() == crate::ROW_ID_COLUMN_NAME,
                 treat as a serious correctness bug",
                }
///   merges the collectors and `extract_single_collector_residual`
    fn classify_deeply_nested_and_is_single() {
fn strip_column_qualifiers(expr: &Expr) -> Expr {
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
            ref other => panic!("expected Predicate or And, got {:?}", other),
#[derive(Debug)]
/// Create the `delegation_possible(originalPredicate, annotationId) → Boolean` UDF.
/// If the resulting tree classifies as `FilterClass::Tree` (any OR/NOT
        &self,
            Ok(BoolNode::And(vec![left, right]))
}
/// Convert a DataFusion filter `Expr` to a `BoolNode` tree.
            BoolNode::Not(Box::new(dummy_predicate())),
            Operator::Lt,
        LogicalPlan::SubqueryAlias(s) => has_aggregate_or_window_below(&s.input),
            Field::new("qty", DataType::Int32, false),
            BoolNode::Predicate(_) | BoolNode::And(_) => {}
                    collector(1),
    fn classify_nested_and_not_containing_collector_is_tree() {
            }
        Self {
    #[test]
        }
        BoolNode::Collector { .. }
    }
    state: &SessionState,
                extract_filter_expr(&filter.input)
        Expr::BinaryExpr(bin) if bin.op == Operator::And => {
//!   arithmetic, casts, UDFs — any boolean-valued DataFusion expression
//! - **Anything else** → lowered to [`Arc<dyn PhysicalExpr>`] via
    }
                ));
            .any(|child| plan_requests_row_ids(child)),
    } else {
    #[test]
            Field::new("active", DataType::Boolean, false),
    }
/// The UDF name Calcite emits for opportunistic peer-delegation markers.
    }
            collector(10),
    ) -> datafusion::common::Result<ColumnarValue> {
mod tests {
    // are dual-viable) classify as SingleCollector — the evaluator handles the optional
}
        // over silently misrouting to SingleCollector.
            ]),
            DELEGATION_POSSIBLE_FUNCTION_NAME,
        assert!(matches!(*r.tree, BoolNode::Predicate(_)));
/// OR or NOT containing a collector disqualifies.
        _ => plan
        Expr::ScalarFunction(func) if func.name() == COLLECTOR_FUNCTION_NAME => {
        return FilterClass::SingleCollector;
///   → `FilterClass::SingleCollector`. Nested ANDs with mixed
            dummy_predicate(),
                }
    match expr {
    fn in_list_expression_is_accepted() {
/// `DataFusionError` to fail loud if it ever runs (would otherwise silently
        // Pass-through: evaluate the original predicate (first arg) directly.
    }
        assert_eq!(classify_filter(&dummy_predicate()), FilterClass::None);
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
    expr: &Expr,
                DELEGATION_POSSIBLE_FUNCTION_NAME
/// Create the `delegated_predicate(annotationId) → Boolean` UDF.
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
    match plan {
        // unexpectedly so correctness issues surface in logs without crashing.
        let tree = BoolNode::And(vec![
///
        }
) -> Result<BoolNode, String> {
    }
            BoolNode::And(vec![
        Expr::BinaryExpr(bin) if bin.op == Operator::Or => {
    fn arithmetic_comparison_is_accepted() {
        assert!(matches!(*r.tree, BoolNode::Predicate(_)));
        let udf = Arc::new(create_index_filter_udf());
/// - 0 collector leaves → `FilterClass::None`
            let phys = state
}
struct IndexFilterUdf {
            BoolNode::And(vec![collector(11), dummy_predicate()]),
impl ScalarUDFImpl for DelegationPossibleUdf {
        let col_idx = schema.index_of("price").unwrap();
        LogicalPlan::Projection(p) => has_aggregate_or_window_below(&p.input),
        ));
//! classifies each node:
            Expr::ScalarFunction(datafusion::logical_expr::expr::ScalarFunction::new_udf(
/// predicate is preserved as arg 0 (DF evaluates it natively); the peer query
        other => {
    let annotation_id = extract_int32_literal(&args[0])?;
            FilterClass::None
            "{} arg 0 must be boolean-valued, got {:?}",
            Ok(datafusion::common::tree_node::Transformed::no(e))
                .create_physical_expr(unqualified.clone(), df_schema)
        // function. If we reach here, classification missed the marker and
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
use datafusion::common::tree_node::TreeNode;
        let tree = BoolNode::And(vec![collector(10), dummy_predicate(), dummy_predicate()]);
    // peer consultation. OR/NOT containing DelegationPossible falls through to Tree, which
        assert!(matches!(*r.tree, BoolNode::And(_)));
//! `delegated_predicate(annotationId)` UDF calls during the Calcite marking phase,
        // AND(C₁, AND(OR(C₂, P), P)) — OR above C₂ → Tree.
    }
    #[test]
/// Classify a filter tree to decide which execution path to take.
/*
        ));
/// Its body is deliberately wired to return a hard `DataFusionError` if it
            BoolNode::And(vec![
            "{} expects 1 arg (annotationId), got {}",
    #[test]
    fn eq(&self, other: &Self) -> bool {
        )),
/// Register in a `SessionContext` before decoding substrait plans that
}
    ScalarUDF::new_from_impl(DelegationPossibleUdf::new())
    signature: Signature,
/// The UDF name Calcite emits for indexed-column filter markers.
}
impl PartialEq for DelegationPossibleUdf {
                    ));
        }
        | LogicalPlan::Window(_)
}
        .map_err(|e| {
use datafusion::execution::SessionState;
        let tree = BoolNode::And(vec![
            Box::new(col("price")),
impl std::hash::Hash for DelegationPossibleUdf {
    fn classify_not_of_collector_is_tree() {
    #[test]
//!   [`BoolNode::Predicate`]. Comparisons, `IS NULL`, `IN`, `BETWEEN`,
             expr_to_bool_tree may have missed the marker"
        assert_eq!(classify_filter(&tree), FilterClass::Tree);
    ) -> datafusion::common::Result<ColumnarValue> {
            "data_type for {} arg 0: {}",
}
}
        ]))
        // shape is accepted so long as the result is boolean-valued.
        let tree = BoolNode::And(vec![collector(10), collector(11), dummy_predicate()]);
#[cfg(test)]
        }
        assert!(matches!(*r.tree, BoolNode::And(_)));
            tree.collector_leaf_count() == 0 && tree.delegation_possible_leaf_count() == 0
             prepare_partial_plan path; if this appears on a data-node indexed query, \
    if return_type != DataType::Boolean {
        let tree = BoolNode::And(vec![
        LogicalPlan::Projection(proj) => proj.expr.iter().any(|e| match e {
fn is_and_only_collector_tree(tree: &BoolNode) -> bool {
    }
    fn classify_nested_and_only_collectors_is_single() {
        &self.signature
    expr.clone()
/// those leaves must be boolean-valued; anything else is rejected.
pub const COLLECTOR_FUNCTION_NAME: &str = "delegated_predicate";
        // price BETWEEN 10 AND 50
    fn is_null_expression_is_accepted() {
        let or_branch = col("price").gt(lit(100i32)).or(col("qty").lt(lit(50i32)));
        let e = r.unwrap_err();
            classify_filter(&BoolNode::And(vec![dummy_predicate(), dummy_predicate()])),
}
        // AND(C₁, AND(C₂, P)) — nested AND, all collectors under AND-only path.
        self.name() == other.name()
impl PartialEq for IndexFilterUdf {
            }
        .unwrap()
    // currently routes to the Phase 3/7 unimplemented stubs (fail loud).
    fn collector(id: i32) -> BoolNode {
            format!(
                BoolNode::And(vec![
    /// Zero `index_filter` calls. Path A — regular DataFusion `ListingTable`,
                BoolNode::Or(vec![dummy_predicate(), dummy_predicate()]),
        let expr = col("price").between(lit(10i32), lit(50i32));
}
}
    fn signature(&self) -> &Signature {
    let return_type = original_expr.data_type(schema).map_err(|e| {
    /// no `IndexedTableProvider` involvement.
// Tests
}
        ]);
        let expr = Expr::IsNull(Box::new(col("price")));
    fn invoke_with_args(
/// predicate as a `PhysicalExpr` (DF evaluates it natively) and stash the
                dummy_predicate(),
        // would otherwise silently return all-true, masking the bug and
pub fn create_delegation_possible_udf() -> ScalarUDF {
        // routes to the Phase 3/7 unimplemented stubs — failing loud is preferred
    }
            classify_filter(&collector(10)),
    #[test]
    }
    use datafusion::execution::context::SessionContext;
                .map_err(|e| format!("create_physical_expr for {:?}: {}", unqualified, e))?;
                    return Ok(datafusion::common::tree_node::Transformed::yes(
            COLLECTOR_FUNCTION_NAME
    ColumnarValue, Expr, LogicalPlan, Operator, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl,
            "{} arg must be an Int32 literal, got {:?}",
/// Classification of a query's filter expression — drives the evaluator choice.
/// contain the UDF.
        tree.demote_delegation_possible()
    }
        original_expr,
            COLLECTOR_FUNCTION_NAME,
    }
    #[test]
        .transform(|e| {
    }
        assert_eq!(classify_filter(&tree), FilterClass::Tree);
                    return_type, other
    schema: &Schema,
    }
        assert_eq!(
        let expr = col("price").gt(lit(100i32)).and(col("qty").lt(lit(50i32)));
    fn collector_function() {
        tree: Arc::new(tree),
    }
    Ok(ExtractionResult {
        return Err(format!(
    /// Path C — `BitmapTreeEvaluator` two-phase evaluation.
    }
        }
/// DataFusion's substrait consumer qualifies field references with the
            ));
        // recognizes the UDF by name and routes to the indexed evaluator;
