    signature: Signature,
//! Substrait → boolean tree conversion.
fn strip_column_qualifiers(expr: &Expr) -> Expr {
            BoolNode::And(vec![
    }
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
    }
    })
    }
        let or_branch = col("price").gt(lit(100i32)).or(col("qty").lt(lit(50i32)));
        LogicalPlan::Limit(l) => has_aggregate_or_window_below(&l.input),
            BoolNode::Collector { annotation_id } => {
    #[test]
    }
        // over silently misrouting to SingleCollector.
//!   DataFusion's `create_physical_expr`, wrapped in
    fn name(&self) -> &str {
    }
            collector(10),
    #[test]
        // would otherwise silently return all-true, masking the bug and
    }
pub enum FilterClass {
        Expr::BinaryExpr(bin) if bin.op == Operator::And => {
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
            None
}
    }
        let expr = Expr::BinaryExpr(datafusion::logical_expr::BinaryExpr::new(
            format!(
        match *r.tree {
        &self,
    #[test]
                dummy_predicate(),
impl ScalarUDFImpl for DelegationPossibleUdf {
}
        let udf = Arc::new(create_index_filter_udf());
    if args.len() != 1 {
 * this file be licensed under the Apache-2.0 license or a
    if args.len() != 2 {
    Ok(BoolNode::DelegationPossible {
            Field::new("active", DataType::Boolean, false),
//!   arithmetic, casts, UDFs — any boolean-valued DataFusion expression
            // Args: (originalPredicate: Boolean, annotationId: Int32).
    fn name(&self) -> &str {
    fn classify_nested_and_with_or_predicate_is_single() {
//!   is accepted.
    /// Default session for tests that don't depend on session-scoped state.
struct IndexFilterUdf {
                ));
    #[test]
    fn simple_predicate() {
        let tree = BoolNode::And(vec![
        // Leaves are trivially fine (no Collector or DelegationPossible below them).
        let e = r.unwrap_err();
        assert_eq!(
                    return_type, other
                    DataType::Int32,
            dummy_predicate(),
impl PartialEq for IndexFilterUdf {
};
        | LogicalPlan::Union(_) => true,
            udf,
impl PartialEq for DelegationPossibleUdf {
    fn return_type(&self, _: &[DataType]) -> datafusion::common::Result<DataType> {
/// `delegation_possible(originalPredicate, annotationId)` — preserve the original
}
    }
//!   are the serialized backend query payload; they're handed to a Java
        // not expression contents. Build a minimal boolean PhysicalExpr.
    fn hash<H: std::hash::Hasher>(&self, state: &mut H) {
/// Returns true when every collector in `tree` is reachable only
        // function. If we reach here, classification missed the marker and
    }
            ref other => panic!("expected Predicate or And, got {:?}", other),
/// Its body is deliberately wired to return a hard `DataFusionError` if it
    fn invoke_with_args(
        assert_eq!(classify_filter(&tree), FilterClass::Tree);
        assert_eq!(classify_filter(&tree), FilterClass::Tree);
                    ));
        // CAST, UDF — gets lowered to a DataFusion PhysicalExpr via
    fn classify_nested_and_not_containing_collector_is_tree() {
//!   literal argument → `BoolNode::Collector { annotation_id }`. The ID
        _ => Err(format!(
    fn collector_function() {
//! **The substrait plan is the wire format.** Java never serializes an
/// - 0 collector leaves → `FilterClass::None`
}
    fn in_list_expression_is_accepted() {
}
impl Eq for DelegationPossibleUdf {}
        let tree = BoolNode::And(vec![
/// Convert a DataFusion filter `Expr` to a `BoolNode` tree.
    #[test]
        let expr = col("price").in_list(vec![lit(5i32), lit(10i32), lit(15i32)], false);
        ));
        _args: ScalarFunctionArgs,
        // AND(C₁, AND(NOT(C₂), P)) — NOT above C₂ → Tree.
        log::warn!(
    }
            BoolNode::And(vec![collector(0), collector(1)]),
    }
        }
        }
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
            let phys = state
            ]),
pub const COLLECTOR_FUNCTION_NAME: &str = "delegated_predicate";
    state: &SessionState,
) -> Result<BoolNode, String> {
        .map_err(|e| {
                 treat as a serious correctness bug",
    }
        // comparison kernel rejects mixed types).
            let left = convert_expr(&bin.left, schema, df_schema, state)?;
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
            BoolNode::And(vec![collector(11), dummy_predicate()]),
            ),
            ))
            _ => panic!("expected Collector"),
            "{} arg 0 must be boolean-valued, got {:?}",
            BoolNode::And(vec![
        // routes to the Phase 3/7 unimplemented stubs — failing loud is preferred
    #[test]
///
    match plan {
            }
//! After Substrait is decoded into a DataFusion `LogicalPlan`, the filter
        Err(datafusion::common::DataFusionError::Internal(format!(
///
            }
/// `delegated_predicate(annotationId)` — a single `Int32` literal arg.
        Ok(DataType::Boolean)
            DELEGATION_POSSIBLE_FUNCTION_NAME, return_type
            COLLECTOR_FUNCTION_NAME,
        ]);
    }
        let tree = BoolNode::And(vec![
        // `SessionState::create_physical_expr`, which runs the analyzer
        FilterClass::SingleCollector
        assert!(matches!(*r.tree, BoolNode::Predicate(_)));
        assert_eq!(classify_filter(&tree), FilterClass::Tree);
            "{} expects 2 args (originalPredicate, annotationId), got {}",
        assert_eq!(classify_filter(&dummy_predicate()), FilterClass::None);
    args: &[Expr],
        // delegation_possible wrapper. On the indexed path, expr_to_bool_tree should
            signature: Signature::one_of(
}
}
            signature: Signature::one_of(
//!   [`BoolNode::Predicate`]. Comparisons, `IS NULL`, `IN`, `BETWEEN`,
        let tree = BoolNode::And(vec![collector(10), collector(11), dummy_predicate()]);
        let expr = Expr::ScalarFunction(datafusion::logical_expr::expr::ScalarFunction::new_udf(
    #[test]
        }
///   → `FilterClass::SingleCollector`. Nested ANDs with mixed
                }
        // freestanding `physical_expr::create_physical_expr` skips the
    #[test]
        let expr = Expr::BinaryExpr(datafusion::logical_expr::BinaryExpr::new(
    /// Multiple `index_filter` calls, or OR/NOT mixing them with predicates.
                Volatility::Immutable,
            if let Expr::Column(col) = &e {
        other => {
    }
    None,
    let tree = if classify_filter(&tree) == FilterClass::Tree {
                Volatility::Immutable,
        self.name() == other.name()
/// Classification of a query's filter expression — drives the evaluator choice.
fn is_and_only_collector_tree(tree: &BoolNode) -> bool {
    /// Inline-equivalent to `SessionContext::new().state()` — extracted because
        Ok(DataType::Boolean)
fn has_aggregate_or_window_below(plan: &LogicalPlan) -> bool {
    /// Exactly one `index_filter`, AND'd with parquet-native predicates.
            collector(10),
///
                "create_physical_expr for {} arg 0: {}",
//! of the decoded `LogicalPlan`.
    fn is_null_expression_is_accepted() {
    ScalarUDF::new_from_impl(IndexFilterUdf::new())
#[derive(Debug)]
            Ok(BoolNode::Not(Box::new(child)))
        args: ScalarFunctionArgs,
//!
            ]),
        );
//!
    // No Collector AND no DelegationPossible → no peer-backend involvement at all.
impl DelegationPossibleUdf {
        // recognizes the UDF by name and routes to the indexed evaluator;
        let tree = BoolNode::Or(vec![collector(10), dummy_predicate()]);
    let return_type = original_expr.data_type(schema).map_err(|e| {
}
    // ── Nested AND shapes → SingleCollector ──────────────────────────
    // ── classify_filter ──────────────────────────────────────────────
            }
        self.name() == other.name()
    #[test]
 * The OpenSearch Contributors require contributions made to
                assert_eq!(annotation_id, 42);
            let child = convert_expr(inner, schema, df_schema, state)?;
            collector(10),
    schema: &Schema,
        ))
    // ── expr_to_bool_tree ────────────────────────────────────────────
            .any(|child| plan_requests_row_ids(child)),
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
/// now that `Predicate` leaves carry `Arc<dyn PhysicalExpr>` directly.
    /// Zero `index_filter` calls. Path A — regular DataFusion `ListingTable`,
    fn collector(id: i32) -> BoolNode {
    #[test]
//! `delegated_predicate(annotationId)` UDF calls during the Calcite marking phase,
        &self,
        .data
        // `Utf8View` column compared against an `Utf8` literal — Arrow's
            let right = convert_expr(&bin.right, schema, df_schema, state)?;
    }
        // 100 < price — valid boolean expression, lowered as-is.
                dummy_predicate(),
        // when it works correctly, DataFusion never evaluates the UDF as a
        // AND(collector(annotationId), OR(price > 100, qty < 50))
        COLLECTOR_FUNCTION_NAME
        ]);
            "{} expects 1 arg (annotationId), got {}",
                BoolNode::Not(Box::new(collector(11))),
        // AND(AND(C₁, C₂), AND(C₃, C₄)) — nested AND of only collectors.
    let tree = convert_expr(expr, schema, &df_schema, state)?;
    }
        return Err(format!(
        // (price + 10) > 100 — our old converter would reject this.
    fn classify_or_containing_collector_is_tree() {
//! `IndexFilterTree`; it rewrites `column = 'value'` on indexed columns to
    signature: Signature,
pub fn expr_to_bool_tree(
/*
//!   factory at query-resolve time to create a provider.
    }
    }
        ]);
            let unqualified = strip_column_qualifiers(other);
    let annotation_id = extract_int32_literal(&args[1])?;
    }
        let left: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new("price", col_idx));
    fn classify_nested_and_or_containing_collector_is_tree() {
    fn literal_op_column_works() {
    })
    match tree {
    #[test]
    }
/// produce all-true results and mask a routing bug in the dispatcher.
/// Register in a `SessionContext` before decoding substrait plans that contain
}
impl IndexFilterUdf {
            ));
    #[test]
        LogicalPlan::Sort(s) => has_aggregate_or_window_below(&s.input),
        // AND(C, AND(P, OR(P, P))) — OR contains only predicates, no collectors.
            classify_filter(&collector(10)),
    }
    Ok(ExtractionResult {
    if return_type != DataType::Boolean {
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
    SingleCollector,
/// through AND nodes (no OR or NOT on the path from root to any
}
    // DelegationPossible-only AND-shaped trees (e.g. `verb='GET' AND status=200` where both
}
/// - any AND-only tree (no OR/NOT above collectors) with ≥1 collector
    }
            if return_type != DataType::Boolean {
        ));
        // AND(C, C, P) — all collectors under AND-only path → SingleCollector.
        let col_idx = schema.index_of("price").unwrap();
        | BoolNode::DelegationPossible { .. } => true,
    }
            BoolNode::Predicate(_) | BoolNode::And(_) => {}
use datafusion::common::tree_node::TreeNode;
        // AND(C₁, AND(OR(C₂, P), P)) — OR above C₂ → Tree.
}
                if col.relation.is_some() {
use datafusion::arrow::datatypes::{DataType, Schema, SchemaRef};
            .iter()
    }
                ])],
/// predicate as a `PhysicalExpr` (DF evaluates it natively) and stash the
            ),
///   collectors + predicates are accepted; `single_collector_bytes`
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
            let left = convert_expr(&bin.left, schema, df_schema, state)?;
        let tree = BoolNode::And(vec![
            Expr::ScalarFunction(datafusion::logical_expr::expr::ScalarFunction::new_udf(
// ════════════════════════════════════════════════════════════════════════════
            datafusion::common::DataFusionError::Internal(format!(
    if is_and_only_collector_tree(tree) {
        Expr::Literal(ScalarValue::Int32(Some(v)), _) => Ok(*v),
    /// predicate pushdown.
        assert!(matches!(*r.tree, BoolNode::Predicate(_)));
            Ok(BoolNode::Or(vec![left, right]))
    }
    #[test]
        })?;
    fn classify_bare_collector_is_single() {
/// OR or NOT containing a collector disqualifies.
}
        assert!(r.is_err());
///   strips them to produce the predicate residual.
            collector(10),
        }
/// Register in a `SessionContext` before decoding substrait plans that
        )
            }
                vec![lit(ScalarValue::Int32(Some(0)))],
        let tree = BoolNode::And(vec![
            BoolNode::And(vec![
//! - `ScalarFunction` named `COLLECTOR_FUNCTION_NAME` with one `Binary`
/// Create the `delegation_possible(originalPredicate, annotationId) → Boolean` UDF.
            Expr::Column(col) => col.name() == crate::ROW_ID_COLUMN_NAME,
use super::bool_tree::BoolNode;
        return FilterClass::SingleCollector;
    }
fn extract_int32_literal(expr: &Expr) -> Result<i32, String> {
            Ok(BoolNode::Predicate(phys))
    }
/// `DataFusionError` to fail loud if it ever runs (would otherwise silently
/// Walk the logical plan looking for `__row_id__` column in a projection.
/// for the substrait consumer; `expr_to_bool_tree` recognizes the function by
//! - `AND` / `OR` / `NOT` → `BoolNode::And` / `Or` / `Not`
        let tree = BoolNode::And(vec![
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
        tree
 * compatible open source license.
        }
    fn between_expression_is_accepted() {
    fn classify_and_with_two_collectors_is_single() {
        let expr = col("price").gt(lit(100i32));
        // A stand-in Predicate leaf — classify only cares about shape,
        Self {
/// those leaves must be boolean-valued; anything else is rejected.
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
                }
        let expr = (col("price") + lit(10i32)).gt(lit(100i32));
                if let Some(expr) = extract_filter_expr(child) {
        // Expected on the prepare_partial_plan path where FilterExec retains the
    ScalarUDF::new_from_impl(DelegationPossibleUdf::new())
                        Expr::Column(datafusion::common::Column::new_unqualified(&col.name)),
                    BoolNode::And(vec![collector(2), dummy_predicate()]),
    #[test]
        BoolNode::And(children) => children.iter().all(is_and_only_collector_tree),
    }
        ));
    }
///
            BoolNode::And(vec![
    fn dummy_predicate() -> BoolNode {
/// in the shape), every `DelegationPossible` leaf is demoted to a plain
}
        LogicalPlan::Projection(p) => has_aggregate_or_window_below(&p.input),
        DFSchema::try_from(schema.as_ref().clone()).map_err(|e| format!("DFSchema: {}", e))?;
            _ => false,
        Expr::ScalarFunction(func) if func.name() == COLLECTOR_FUNCTION_NAME => {
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
fn convert_delegation_possible_function(
    use datafusion::physical_expr::expressions::{Column as PhysColumn, Literal};
        self.name().hash(state);
        match *r.tree {
    fn return_type(&self, _: &[DataType]) -> datafusion::common::Result<DataType> {
    df_schema: &DFSchema,
//! - **Anything else** → lowered to [`Arc<dyn PhysicalExpr>`] via
            dummy_predicate(),
/// DataFusion's substrait consumer qualifies field references with the
        }
        // producing wrong results. Fail loudly instead.
//!
}
/// NamedScan table name, but the parquet schema has bare column names.
}
            DELEGATION_POSSIBLE_FUNCTION_NAME, e
/// This UDF exists solely as a marker for `classify_filter` / `expr_to_bool_tree`.
        // pipeline (TypeCoercion, function rewrites) before lowering. The
/// The UDF name Calcite emits for opportunistic peer-delegation markers.
    state: &SessionState,
/// predicate is preserved as arg 0 (DF evaluates it natively); the peer query
    }
    #[test]
    /// Path C — `BitmapTreeEvaluator` two-phase evaluation.
/// Create the `delegated_predicate(annotationId) → Boolean` UDF.
        ]);
    state: &SessionState,
                .data_type(schema)
/// contain the UDF.
 */
        }
                "{} UDF invoked with no arguments",
    #[test]
            FilterClass::SingleCollector
                    return Ok(datafusion::common::tree_node::Transformed::yes(
        | BoolNode::Predicate(_)
                return Err(format!(
        let expr = col("price").gt(lit(100i32)).and(col("qty").lt(lit(50i32)));
    fn classify_nested_and_collector_plus_predicate_is_single() {
    Tree,
    fn new() -> Self {
                BoolNode::Or(vec![collector(11), dummy_predicate()]),
        Arc::new(Schema::new(vec![
        SessionContext::new().state()
                DELEGATION_POSSIBLE_FUNCTION_NAME, e
            Box::new(col("price")),
        assert!(e.contains("boolean"), "got: {}", e);
            let return_type = phys
    schema: &Schema,
///   merges the collectors and `extract_single_collector_residual`
                udf,
#[cfg(test)]
        _ => {
                    collector(1),
            BoolNode::And(vec![collector(2), collector(3)]),
    match expr {
#[cfg(test)]
            Box::new(collector_expr),
        // For DelegationPossible under OR/NOT specifically, Tree path currently
            Operator::And,
            classify_filter(&BoolNode::And(vec![dummy_predicate(), dummy_predicate()])),
mod tests {
        let tree = BoolNode::And(vec![
                vec![TypeSignature::Exact(vec![
/// Its presence signals the executor to emit computed row IDs (query phase).
        // Pass-through: evaluate the original predicate (first arg) directly.
            args.len()
/// is identified by arg 1 (used by the evaluator to call back into Java when
/// [`BoolNode::demote_delegation_possible`] for the rationale and trade-offs.
        ));
        let tree = BoolNode::Not(Box::new(collector(10)));
use std::sync::Arc;
            Field::new("qty", DataType::Int32, false),
    } else {
    }
    fn hash<H: std::hash::Hasher>(&self, state: &mut H) {
use datafusion::logical_expr::{
}
//! expression is a tree of `Expr` nodes. This module walks that tree and
/// - anything else (OR / NOT above a collector) → `FilterClass::Tree`
        );
        assert!(matches!(*r.tree, BoolNode::Predicate(_)));
        &self.signature
        )),
                BoolNode::Or(vec![dummy_predicate(), dummy_predicate()]),
    }
        // AND(C₁, AND(C₂, P)) — nested AND, all collectors under AND-only path.
        assert!(matches!(*r.tree, BoolNode::Predicate(_)));
        // unexpectedly so correctness issues surface in logs without crashing.
        assert!(matches!(*r.tree, BoolNode::And(_)));
    if matches!(tree, BoolNode::Collector { .. }) {
    ) -> datafusion::common::Result<ColumnarValue> {
    ColumnarValue, Expr, LogicalPlan, Operator, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl,
/// ever executes, because a production execution of the body would silently
/// name and never lets DataFusion evaluate its body. The body returns a hard
            ]),
use datafusion::execution::SessionState;
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
        // shape is accepted so long as the result is boolean-valued.
    // peer consultation. OR/NOT containing DelegationPossible falls through to Tree, which
    fn test_state() -> datafusion::execution::SessionState {
    #[test]
/// Like `create_index_filter_udf`, this exists solely as a name-resolution stub
                collector(0),
    use datafusion::logical_expr::{col, lit};
pub fn extract_filter_expr(plan: &LogicalPlan) -> Option<Expr> {
}
    fn mixed_tree() {
        ]))
/// The UDF name Calcite emits for indexed-column filter markers.
    // are dual-viable) classify as SingleCollector — the evaluator handles the optional
    ) -> datafusion::common::Result<ColumnarValue> {
    Ok(BoolNode::Collector { annotation_id })
    use std::sync::Arc;
    if tree.collector_leaf_count() == 0 && tree.delegation_possible_leaf_count() == 0 {
#[derive(Debug)]
            BoolNode::Not(Box::new(dummy_predicate())),
    let unqualified = strip_column_qualifiers(&args[0]);
        assert!(matches!(*r.tree, BoolNode::Predicate(_)));
use datafusion::common::{DFSchema, ScalarValue};
        .create_physical_expr(unqualified, df_schema)
/// filters that sit above Aggregate or Window nodes (those reference derived
    let original_expr = state
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
    })?;
/// annotation id for opportunistic peer consultation in the evaluator.
            for child in plan.inputs() {
    }
        // This body must never execute in production. `classify_filter`
    let df_schema =
        let expr = col("price").between(lit(10i32), lit(50i32));
            COLLECTOR_FUNCTION_NAME, expr
    #[test]
        LogicalPlan::SubqueryAlias(s) => has_aggregate_or_window_below(&s.input),
}
        BoolNode::Or(_) | BoolNode::Not(_) => {
    fn non_boolean_expression_is_rejected() {
        // AND(C, NOT(P)) — NOT wraps a predicate, not a collector.
            if has_aggregate_or_window_below(&filter.input) {
            collector(10),
        let expr = col("price") + lit(10i32);
    use datafusion::execution::context::SessionContext;
 *
        assert!(matches!(*r.tree, BoolNode::Not(_)));
    };
            let right = convert_expr(&bin.right, schema, df_schema, state)?;
    #[test]
        assert_eq!(
        ));
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
        }
        BoolNode::Collector { annotation_id: id }
        self.name().hash(state);
        let udf = Arc::new(create_index_filter_udf());
    expr: &Expr,
             expr_to_bool_tree may have missed the marker"
        .transform(|e| {
    }
    }
    #[test]
impl ScalarUDFImpl for IndexFilterUdf {
             prepare_partial_plan path; if this appears on a data-node indexed query, \
    }
    }
                    "indexed-query expression must be boolean-valued, got {:?}: {:?}",
        )))
/// Strip table qualifiers from `Column` references in an `Expr` tree.
/// columns that `expr_to_bool_tree` cannot resolve against the base schema).
                BoolNode::And(vec![
            FilterClass::None
                ]),
//! classifies each node:
pub fn plan_requests_row_ids(plan: &LogicalPlan) -> bool {
    use super::*;
    }
pub fn create_delegation_possible_udf() -> ScalarUDF {
    use datafusion::arrow::datatypes::{Field, Schema};
    schema: &SchemaRef,
        let schema = test_schema();
/// `Arc<dyn PhysicalExpr>` via `create_physical_expr`. The expression at
                dummy_predicate(),
            Operator::Lt,
        }
fn convert_expr(
            "{} arg must be an Int32 literal, got {:?}",
        let right: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(0))));
    }
}
        FilterClass::Tree
    fn classify_not_of_collector_is_tree() {
    match plan {
            "data_type for {} arg 0: {}",
    fn classify_no_collectors_is_none() {
        _ => false,
            datafusion::physical_expr::expressions::BinaryExpr::new(left, Operator::Eq, right),
/// Form: `delegation_possible(originalPredicate, annotationId)` — the original
        })
    }
        annotation_id,
}
            ]),
}
                    return Some(expr);
///
    fn invoke_with_args(
/// arms for `DelegationPossible`) doesn't crash. See
        BoolNode::Predicate(Arc::new(
        // analyzer and would produce mismatched-type kernels (e.g. parquet's
            DELEGATION_POSSIBLE_FUNCTION_NAME,
    expr.clone()
            Ok(datafusion::common::tree_node::Transformed::no(e))
    fn classify_and_of_collector_and_predicates_is_single() {
    // currently routes to the Phase 3/7 unimplemented stubs (fail loud).
        // AND(P, AND(C₁, AND(C₂, AND(C₃, P)))) — depth 4, all AND.
        return FilterClass::None;
    fn new() -> Self {
            "{} UDF body invoked — classify_filter did not recognize the marker; \
        return Err(format!(
        // BETWEEN may desugar into And internally or stay as-is; either
        Expr::Not(inner) => {
/// `schema` is used to lower non-combinator subexpressions to
    #[test]
        assert_eq!(classify_filter(&tree), FilterClass::Tree);
            "delegation_possible UDF evaluated at runtime — expected only on \
        ]);
/// `Predicate` so the bitmap-tree evaluator (which has `unimplemented!()`
    }
    Signature, TypeSignature, Volatility,
#[derive(Debug)]
    /// every `expr_to_bool_tree` call site repeats it.
        // `price + 10` on its own is Int32, not Boolean → must error.
    }
/// collector leaf). Predicates, ANDs, and collector leaves are fine;
    #[test]
pub fn classify_filter(tree: &BoolNode) -> FilterClass {
fn convert_collector_function(args: &[Expr]) -> Result<BoolNode, String> {
pub struct ExtractionResult {
    pub tree: Arc<BoolNode>,
pub fn create_index_filter_udf() -> ScalarUDF {
impl std::hash::Hash for DelegationPossibleUdf {
    }
            COLLECTOR_FUNCTION_NAME
impl Eq for IndexFilterUdf {}
/// If the resulting tree classifies as `FilterClass::Tree` (any OR/NOT
        &self.signature
        format!(
    fn eq(&self, other: &Self) -> bool {
    }
                .map_err(|e| format!("create_physical_expr for {:?}: {}", unqualified, e))?;
        DELEGATION_POSSIBLE_FUNCTION_NAME
        tree.demote_delegation_possible()
        }
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state()).unwrap();
    #[test]
    }
                .map_err(|e| format!("data_type: {}", e))?;
        let expr = Expr::IsNull(Box::new(col("price")));
    }
    fn not_predicate() {
/// the UDF.
                vec![TypeSignature::Exact(vec![DataType::Int32])],
/// Result of `expr_to_bool_tree` — just the tree. No sidecar list needed
    }
        }
// Tests
        ]);
        BoolNode::Collector { .. }
        let collector_expr =
    }
            tree.collector_leaf_count() == 0 && tree.delegation_possible_leaf_count() == 0
}
            }
// ════════════════════════════════════════════════════════════════════════════
        assert_eq!(classify_filter(&tree), FilterClass::Tree);
    }
            vec![lit(ScalarValue::Int32(Some(42)))],
    expr: &Expr,
/// short-circuit to the original predicate's value, masking a routing bug).
        | LogicalPlan::Window(_)
            Ok(BoolNode::And(vec![left, right]))
) -> Result<ExtractionResult, String> {
        // unwrap the marker before execution — log a warning if we reach here
    fn test_schema() -> SchemaRef {
    fn eq(&self, other: &Self) -> bool {
        ]);
            Box::new(lit(100i32)),
            convert_collector_function(&func.args)
        assert!(matches!(*r.tree, BoolNode::And(_)));
/// - bare collector → `FilterClass::SingleCollector`
    fn classify_deeply_nested_and_is_single() {
    }
/// Classify a filter tree to decide which execution path to take.
                    DataType::Boolean,
            Field::new("price", DataType::Int32, false),
            convert_delegation_possible_function(&func.args, schema, df_schema, state)
            .inputs()
                DELEGATION_POSSIBLE_FUNCTION_NAME
use datafusion::physical_expr::PhysicalExpr;
    }
        let r = expr_to_bool_tree(&expr, &test_schema(), &test_state());
/// DF's own pruning isn't selective enough for a row group).
    fn classify_nested_and_only_collectors_is_single() {
    #[test]
impl std::hash::Hash for IndexFilterUdf {
 * SPDX-License-Identifier: Apache-2.0
        | LogicalPlan::Join(_)
                .create_physical_expr(unqualified.clone(), df_schema)
    }
    fn signature(&self) -> &Signature {
            )
            Box::new(or_branch),
        LogicalPlan::Projection(proj) => proj.expr.iter().any(|e| match e {
            args.len()
}
        return Err(format!(
                extract_filter_expr(&filter.input)
        })
        args.args.into_iter().next().ok_or_else(|| {
        assert_eq!(classify_filter(&tree), FilterClass::SingleCollector);
        // price BETWEEN 10 AND 50
    let annotation_id = extract_int32_literal(&args[0])?;
    } else {
            BoolNode::Or(vec![collector(10), dummy_predicate()]),
        Expr::ScalarFunction(func) if func.name() == DELEGATION_POSSIBLE_FUNCTION_NAME => {
        let tree = BoolNode::And(vec![
                Some(filter.predicate.clone())
        );
        LogicalPlan::Aggregate(_)
}
        Self {
    }
        }
    /// no `IndexedTableProvider` involvement.
    fn signature(&self) -> &Signature {
        // OR/NOT containing any Collector OR any DelegationPossible → Tree path.
    #[test]
        }
    match plan {
    fn classify_nested_and_with_not_predicate_is_single() {
    /// Path B — `SingleCollectorEvaluator`, DataFusion handles residual via
        ]);
            } else {
struct DelegationPossibleUdf {
    }
/// Extract the scan-level filter from a logical plan, skipping HAVING/window
        Expr::BinaryExpr(bin) if bin.op == Operator::Or => {
//! and that survives the substrait round-trip. Rust just reads it back out
        .unwrap()
    fn arithmetic_comparison_is_accepted() {
    }
pub const DELEGATION_POSSIBLE_FUNCTION_NAME: &str = "delegation_possible";
    fn classify_and_with_nested_collector_is_tree() {
        original_expr,
) -> Result<BoolNode, String> {
        }),
    match expr {
        tree: Arc::new(tree),
    df_schema: &DFSchema,
        _ => plan
        // Anything else — comparison, IS NULL, IN, BETWEEN, arithmetic,
        let tree = BoolNode::And(vec![collector(10), dummy_predicate(), dummy_predicate()]);
        ));
        let expr = Expr::Not(Box::new(col("active").eq(lit(true))));
    fn and_of_predicates() {
}
        LogicalPlan::Filter(filter) => {
