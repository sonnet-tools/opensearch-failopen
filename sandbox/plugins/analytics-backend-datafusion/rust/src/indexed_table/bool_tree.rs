    fn collect_leaves(&self, out: &mut Vec<i32>) {
        }
            }
    pub fn delegation_possible_leaf_count(&self) -> usize {
            assert_eq!(predicate_op(&resolved), expected, "flipping {:?}", orig);
    }
        // No DelegationPossible should remain anywhere.
                assert_eq!(children.len(), 4);
    fn flatten_collapses_nested_and() {
            BoolNode::Not(child) => child.collect_delegation_possible_leaves(out),
///
            BoolNode::Not(child) => {
        match self {
    And(Vec<BoolNode>),
                    .expect("expected BinaryExpr leaf");
    }
                // kleene-`not()` kernel per batch in the refinement stage
        use datafusion::arrow::datatypes::{DataType, Field, Schema};
                    .map(|c| c.demote_delegation_possible())
                // and one universe subtraction per RG in the candidate
    And(Vec<ResolvedNode>),
                    provider_key: *provider_key,
        Operator::NotEq => Operator::Eq,
) -> Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>> {
            }
        let right: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(v))));
        annotation_id: i32,
    /// - `DelegationPossible` / `Predicate` leaf: not covered — evaluated by the
                collector(1),
    Not(Box<BoolNode>),
    }
                delegation_possible(1, "verb", Operator::Eq, 0),
    /// the Tree-path evaluator.
        assert!(matches!(n, BoolNode::Collector { .. }));
    /// Collapse nested same-kind connectives:
//!   [`PhysicalExpr`](datafusion::physical_expr::PhysicalExpr) —
            (Operator::Eq, Operator::NotEq),
                // into `Predicate(col flipped_op literal)`. Saves one
    match node {
    let flipped = match *bin.op() {
    /// leaf in DFS order. Caller pairs these positionally with a parallel
                *bin.op()
    /// `Vec<Arc<OnceLock<ProviderHandle>>>` (one lock per leaf) to drive lazy
    use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
        match tree.flatten() {
/// Resolved tree. `Collector` leaves carry the provider-key returned by the
            BoolNode::And(children) => {
    ) -> Result<ResolvedNode, String> {
mod tests {
        use datafusion::common::ScalarValue;
    ///   deleted docs through any uncovered branch).
        match resolved {
            BoolNode::DelegationPossible { .. } => {
    ///
/// call `not_kleene()` per batch.
    pub fn collector_leaves(&self) -> Vec<i32> {
            }
                    assert!(matches!(c, BoolNode::Not(_)));
    },
    /// The `collectors` slice is consumed positionally; its order must match
    /// per chunk.
    #[test]
        let tree = BoolNode::Not(Box::new(BoolNode::Not(Box::new(collector(10)))));
        }
                        },
            BoolNode::Not(_) => false,
        BoolNode::Not(child) => {
                for c in children {
    DelegationPossible {
        // tag (under root AND) + (verb OR value): all DelegationPossible leaves
        let schema = Schema::new(vec![Field::new(col, DataType::Int32, false)]);
                annotation_id,
    fn demote_uniform_includes_under_and_within_tree() {
            other => panic!("expected And with 4 children, got {:?}", other),
                assert_eq!(children.len(), 3);
            delegation_possible(1, "value", Operator::Gt, 100),
        let tree = BoolNode::Not(Box::new(BoolNode::And(vec![
    pub fn push_not_down(self) -> BoolNode {
        assert_eq!(predicate_op(&resolved), Operator::LtEq);
            }
        BoolNode::DelegationPossible {
                    },
                    .collect(),
    /// `BinaryExpr(col, op, literal)`. Panics otherwise.
    impl RowGroupDocsCollector for StubCollector {
                }
                assert!(matches!(children[1], BoolNode::Or(_)));
        }
            BoolNode::Collector { .. } => 0,
        }
        }
                assert_eq!(children.len(), 3);
            delegation_possible(1, "v", Operator::Gt, 10),
    }
//! Two flavors:
    ///   driving backend over a universe that still includes deleted docs.
    fn resolve_not_collector_still_wraps() {
                assert!(matches!(outer[1], BoolNode::Not(_)));
        BoolNode::Predicate(Arc::new(BinaryExpr::new(left, op, right)))
        match tree.push_not_down() {
    }
                let resolved: Result<Vec<_>, _> = children
                assert_eq!(children.len(), 2);
        let resolved = tree.resolve(&[]).unwrap();
            BoolNode::Collector { .. } => true,
            original_expr,
            }
        collector: Arc<dyn RowGroupDocsCollector>,
pub fn residual_bool_to_physical_expr(
    }
            for c in iter {
            (Operator::Gt, Operator::LtEq),
    /// ID maps to a pre-compiled query on the Java side (via FilterDelegationHandle).
//! - [`ResolvedNode`] — resolved. Produced by
                annotation_id: *annotation_id,
                out.push(*annotation_id);
    /// Performance-delegated leaf carried unresolved through `BoolNode::resolve`.
    /// peer-backend consultation in the evaluator.
            collector(2),
                    }
        assert_eq!(leaves[2], 12);
 */
        match self {
use datafusion::physical_expr::PhysicalExpr;
//!   comparisons, IN, IS NULL, arithmetic, whatever produces a boolean.
        let n = tree.push_not_down();
    /// it to native keeps results correct, just skipping the opportunistic peer consult.
            }
    /// bitmap per conceptual child instead of one per binary split.
            Ok(vec![self.0 as u64].into())
        collectors: &[(i32, Arc<dyn RowGroupDocsCollector>)],
            BoolNode::DelegationPossible {
        let b: Arc<dyn RowGroupDocsCollector> = Arc::new(StubCollector(2));
                    c.collect_leaves(out);
            }
            BoolNode::Not(inner) => match *inner {
            let mut iter = children.iter();
            other => panic!("expected Predicate, got {:?}", other),
            BoolNode::Or(children.into_iter().map(push_not_into).collect()).push_not_down()
                    .into_iter()
    pub fn resolve(
                .iter()
    }
        let err = tree.resolve(&[]).unwrap_err();
                BoolNode::And(out)
/// - That helper replaces `Collector` leaves with `Literal(true)` so
            ResolvedNode::Predicate(expr) => {
                    collector: Arc::clone(collector),
        assert!(err.contains("out of range"), "got: {}", err);
            BoolNode::Not(child) => BoolNode::Not(Box::new(child.demote_delegation_possible())),
//!   caller; Predicate leaves pass through unchanged. This is what the
    /// The coordinator never puts perf directly under OR/NOT, but an AND-side perf leaf can ride
        match tree.flatten() {
        }
            predicate("b", Operator::Eq, 2),
            BoolNode::Or(children) => {
            let inner = residual_bool_to_physical_expr(child)?;
        match tree.flatten() {
            BoolNode::Or(children) => assert_eq!(children.len(), 4),
    #[test]
                // Performance leaves do not participate in eager provider/collector
            leaf => leaf,
                            provider_key: p1, ..
            }
            other => panic!("expected And, got {:?}", other),
    #[test]
        let left: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new(col, col_idx));
        match demoted {
//!
        let tree = BoolNode::And(vec![collector(0), collector(1)]);
                    (
            BoolNode::Predicate(_) => 0,
        fn collect_packed_u64_bitset(&self, _: i32, _: i32) -> Result<CollectDocsResult, String> {
    // ── resolve ────────────────────────────────────────────────────────
        }
        let leaves = tree.collector_leaves();
    /// Build a DelegationPossible leaf wrapping a comparison expression. The
            }
    }
        let tree = BoolNode::Or(vec![
    /// expression carried in `original_expr` is what the demotion should produce
    /// time. See {@code FragmentConversionDriver}'s performance branch for emit
            (Operator::GtEq, Operator::Lt),
    /// The evaluator decides per-RG whether to consult the peer; provider
        Arc::clone(bin.left()),
    use datafusion::logical_expr::Operator;
    fn resolve_passes_predicate_expr_through() {
        }
            for c in iter {
        }
}
    #[test]
        }
            (Operator::Lt, Operator::GtEq),
            if children.is_empty() {
        }
    }
    /// evaluate it. The driving backend evaluates `original_expr` natively for its
                    .map(|c| c.resolve_rec(collectors, next))
    pub fn collector_leaf_count(&self) -> usize {
            }
    }
            collector(0),
        let tree = BoolNode::And(vec![
    /// collector-to-leaf matching will silently become wrong.
        let left: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new(col, col_idx));
            }
            ),
            BoolNode::Collector { .. } => 1,
            }
    match child {
                        None => Ok(ResolvedNode::Not(Box::new(ResolvedNode::Predicate(
            ]),
        let tree = BoolNode::And(vec![
    ///   `NOT(Collector)` re-admits the deleted docs the collector had excluded.
                match (&children[0], &children[1]) {
//!   `Predicate` leaves carry an arbitrary DataFusion
    /// for the traversal contract. A mismatch causes collector-to-leaf
    /// `PruningPredicate` directly.
}
    Predicate(Arc<dyn PhysicalExpr>),
 * compatible open source license.
    // ── Not(Predicate) op-flip during resolve ─────────────────────────
// ════════════════════════════════════════════════════════════════════════════
    /// `resolve` (via the `*next` index) relies on this invariant; if you
    fn predicate_op(node: &ResolvedNode) -> Operator {
    fn demote_preserves_collectors_and_predicates() {
        ]);
            if children.is_empty() {
    /// Count `DelegationPossible` (performance-delegated) leaves in the tree (DFS).
            let mut acc = residual_bool_to_physical_expr(iter.next().unwrap())?;
        ];
    Or(Vec<ResolvedNode>),
        }
            BoolNode::Predicate(_) => {}
        // De Morgan's: NOT(OR(a, b, ...)) → AND(NOT(a), NOT(b), ...)
    #[test]
        ]);
pub enum BoolNode {
                // isn't a recognizable comparison.
    // ── collector_leaf_count / collector_leaves ───────────────────────
    use datafusion::physical_expr::PhysicalExpr;
    )))
use crate::indexed_table::index::CollectDocsResult;
        let schema = Schema::new(vec![Field::new(col, DataType::Int32, false)]);
        ]);
    /// - `And`: covered if ANY child is covered (intersection with a live-only
    pub fn flatten(self) -> BoolNode {
                annotation_id,
        assert_eq!(leaves.len(), 3);
            delegation_possible(0, "tag", Operator::Eq, 0),
        let resolved = tree.resolve(&[]).unwrap();
    }
                for c in &children {
        assert!(matches!(n, BoolNode::Not(b) if matches!(*b, BoolNode::Collector { .. })));
        match tree.flatten() {
                return None;
        // NOT(Collector) / NOT(Predicate) — stay wrapped; evaluator handles the negation
            other => panic!("expected Or, got {:?}", other),
    },
        }
    ///   set removes deleted docs regardless of the other operands).
    /// change one traversal you MUST change the other in lockstep, or
            }
    }
                ));
    }
}
        let resolved = tree.resolve(&[(10, a), (20, b)]).unwrap();
    /// Return `(annotation_id, original_expr)` for each `DelegationPossible`
                for c in &children {
                BoolNode::Or(children.into_iter().map(|c| c.push_not_down()).collect())
            (Operator::LtEq, Operator::Gt),
    }
) -> Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>> {
                    BoolNode::Collector { annotation_id: 7 }
        assert_eq!(demoted.delegation_possible_leaf_count(), 0);
            leaf => leaf,
    pub fn is_covered_by_live_docs(&self) -> bool {
            collector(0),
            BoolNode::And(children) => children.iter().any(|c| c.is_covered_by_live_docs()),
                    .iter()
    /// `delegation_possible` that reaches a Tree plan; then this method goes away and the
        let c: Arc<dyn RowGroupDocsCollector> = Arc::new(StubCollector(0));
        let tree = BoolNode::Not(Box::new(BoolNode::Or(vec![
/// NOT handling: emits `NotExpr`. Callers that need De Morgan
    /// prune time, the expression is handed to DataFusion's
        let cases = [
        Operator::LtEq => Operator::Gt,
    /// bitmap-composition model, where the per-RG candidate universe still
    }
            BoolNode::Predicate(expr) => Ok(ResolvedNode::Predicate(Arc::clone(expr))),
                        )))),
        match self {
        }
        self.collect_leaves(&mut out);
    /// This method MUST walk children in the same order as
    /// creation happens lazily on first consult via {@code OnceLock}.
    #[test]
                assert_eq!(outer.len(), 2);
        leaf => BoolNode::Not(Box::new(leaf)),
            BoolNode::And(children) | BoolNode::Or(children) => {
use super::index::RowGroupDocsCollector;
        match tree.push_not_down() {
            BoolNode::And(children) => BoolNode::And(
        &self,
    fn nested_not_recurses_through_and_or() {
                    ResolvedNode::Predicate(ref expr) => match try_negate_cmp_expr(expr) {
        provider_key: i32,
    /// evaluator arms can throw. Pairs with implementing performance delegation under OR/NOT in
            }
/// - This helper assumes no Collectors are present (appropriate for
        _ => return None,
            BoolNode::Or(vec![
            BoolNode::DelegationPossible { .. } => 1,
        original_expr: Arc<dyn PhysicalExpr>,
            }
            }
            }
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
            }
                }
    // ── demote_delegation_possible ────────────────────────────────────
                BoolNode::And(children.into_iter().map(|c| c.push_not_down()).collect())
                }
/// A node in the boolean query tree (unresolved).
            BoolNode::And(vec![collector(3), collector(4)]),
                        assert_eq!(*p1, 10);
                return None;
    Or(Vec<BoolNode>),
        let mut out = Vec::new();
                        other => out.push(other),
                })
    ///
                children.iter().map(|c| c.collector_leaf_count()).sum()
                    .downcast_ref::<BinaryExpr>()
                    .get(*next)
            }
//!   evaluator walks.
            let mut acc = residual_bool_to_physical_expr(iter.next().unwrap())?;
    /// FIXME: move this Tree-classification awareness into the coordinator so it never emits a
///
// Tests
                    .map(|c| c.resolve_rec(collectors, next))
                    .collect(),
        let mut out = Vec::new();
        let mut next = 0usize;
/// `SingleCollector`-classified tree, or any subtree guaranteed to
                .sum(),
        let tree = BoolNode::And(vec![
    }
        self.collect_delegation_possible_leaves(&mut out);
                    .map(|c| c.demote_delegation_possible())
        self.resolve_rec(collectors, &mut next)
    /// After this, `Not` only appears directly above `Collector` or `Predicate` leaves.
        let col_idx = schema.index_of(col).unwrap();
                // stage. Falls back to wrapping `Not` when the child
//! Boolean query tree representation.
                .map(|c| c.delegation_possible_leaf_count())
        }
    /// upcalling Java `createProvider(annotation_id)` per leaf to get a
            } => {
//!   `BoolNode::resolve(collectors)` — `Collector` leaves get turned
                        BoolNode::And(inner) => out.extend(inner),
    Predicate(Arc<dyn PhysicalExpr>),
            other => panic!("expected And, got {:?}", other),
    /// Correctness-delegated predicate — only the peer backend can evaluate it.
 * this file be licensed under the Apache-2.0 license or a
                }
///   the result can feed DataFusion's `PruningPredicate` rewriter
    /// shape.
                for c in children {
pub enum ResolvedNode {
        let tree = BoolNode::Not(Box::new(collector(10)));
    fn de_morgan_not_and_to_or() {
            other => panic!("expected Or with two Predicates, got {:?}", other),
    use super::*;
    /// # Ordering invariant
                    );
    /// a provider at resolve time (provider creation is lazy in the evaluator).
    }
//!   (as extracted from the `index_filter(bytes)` UDF call);
/// Contrast with `page_pruner::bool_tree_to_pruning_expr`:
        let demoted = tree.demote_delegation_possible();
    /// `(column, op, value)`.
            collector(10),
        // residual — the driving backend evaluates them natively. Optional peer
    // ── push_not_down (De Morgan) ─────────────────────────────────────
    fn collector(id: i32) -> BoolNode {
    expr: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
        ])));
                    assert!(
        let demoted = tree.demote_delegation_possible();
        match self {
    #[test]
        // Not(Predicate(price > 10)).
    ///
            BoolNode::And(children) | BoolNode::Or(children) => children
            }
            Some(acc)
            collector(2),
    /// time, `expr.evaluate(batch)` produces the per-row mask; at page-
                assert_eq!(children.len(), 2);
        let a: Arc<dyn RowGroupDocsCollector> = Arc::new(StubCollector(1));
        Operator::Eq => Operator::NotEq,
/// leaves carry the unresolved annotation ID + original expression (provider
//! **No wire format.** The tree is built from the Substrait plan's filter
            BoolNode::DelegationPossible { .. } | BoolNode::Predicate(_) => false,
    /// Performance-delegated predicate — both the driving backend AND a peer can
        collectors: &[(i32, Arc<dyn RowGroupDocsCollector>)],
        assert!(matches!(resolved, ResolvedNode::Predicate(_)));
/// have no `Collector` leaves) into a single
    }
        BoolNode::And(children) => {
        // Not(price > 10) should resolve to price <= 10, not
    #[test]
            other => panic!("expected Not, got {:?}", other),
            BoolNode::DelegationPossible {
            BoolNode::And(children.into_iter().map(push_not_into).collect()).push_not_down()
                        ResolvedNode::Collector {
        let tree = collector(10);
                other => panic!("expected And under Not, got {:?}", other),
        BoolNode::Not(inner) => inner.push_not_down(),
                assert_eq!(children.len(), 2);
                out.push((*annotation_id, Arc::clone(original_expr)));
///   (which evaluates only against per-page stats, not cell values).
                    ) => {
    /// synthetic live-docs Collector needs to be injected (see
    fn resolve_out_of_range_errors() {
//!   into `(provider_key, Arc<dyn RowGroupDocsCollector>)` pairs by the
    /// Arbitrary boolean-valued DataFusion expression. At refinement
        }
        match self {
/// `Arc<dyn PhysicalExpr>` as [`BoolNode::Predicate`].
//! - [`BoolNode`] — unresolved. Produced by `expr_to_bool_tree`.
            BoolNode::Collector { annotation_id } => {
            }
                    }
            BoolNode::And(children) | BoolNode::Or(children) => {
        ]);
                acc = Arc::new(BinaryExpr::new(acc, Operator::And, child));
            BoolNode::And(children) => {
                match resolved_child {
    /// Demote every `DelegationPossible` leaf to a plain native `Predicate`. Called for
                let bin = expr
            BoolNode::And(vec![collector(0), collector(1)]),
    /// Whether every row this tree can emit is guaranteed to pass through a
        let tree = BoolNode::Not(Box::new(BoolNode::And(vec![collector(0), collector(1)])));
    /// correctness `Collector`, so deleted docs are already excluded and no
            let resolved = tree.resolve(&[]).unwrap();
                }
    /// Substrait decodes N-ary AND/OR as left-deep binary trees. Flattening
    fn resolve_not_predicate_flip_table() {
            }
    }
        BoolNode::Or(children) => {
        // consultation is handled in the evaluator, not in the residual.
        ]);
        let tree = predicate("status", Operator::Eq, 1);
/// comparison operator, return the same expression with the operator
        }
            BoolNode::Not(child) => child.collector_leaf_count(),
            }),
    }
        match self {
    /// right, recurse into Not, then yield leaves. The positional pairing in
            predicate("a", Operator::Eq, 1),
                original_expr,
                        BoolNode::Or(inner) => out.extend(inner),
                }
        match node {
                    assert!(matches!(c, BoolNode::Collector { .. }));
                    &children[0],
    #[test]
#[cfg(test)]
                    }
    /// Resolve the tree: walk in DFS order, consuming pre-built `(provider_key,
                let mut out = Vec::with_capacity(children.len());
            }
        use datafusion::physical_expr::expressions::BinaryExpr;
    Some(Arc::new(BinaryExpr::new(
        annotation_id: i32,
    fn collect_delegation_possible_leaves(&self, out: &mut Vec<(i32, Arc<dyn PhysicalExpr>)>) {
    /// sits under OR/NOT — those need Tree-path support which isn't implemented
            BoolNode::Or(children) => {
    ) -> Result<ResolvedNode, String> {
                original_expr,
                        other => out.push(other),
    fn resolve_not_predicate_flips_op() {
                Ok(ResolvedNode::Or(resolved?))
            BoolNode::And(children) | BoolNode::Or(children) => {
    /// At query-resolve time, the indexed executor upcalls into Java with this ID
//!
        match resolved {
        use datafusion::physical_expr::PhysicalExpr;
    ///
        out
    fn double_negation_cancels() {
    use datafusion::physical_expr::expressions::BinaryExpr;
        }
        }
    },
        next: &mut usize,
                children
        let tree = BoolNode::And(vec![
/*
                }
    /// `And(And(x, y), z)` → `And(x, y, z)`, similarly for `Or`.
                        Some(flipped) => Ok(ResolvedNode::Predicate(flipped)),
    /// in a tree that still has a surviving OR/NOT (e.g. `tag=a AND (dual OR native)`); demoting
/// single flipped `Predicate` so the refinement stage doesn't have to
                BoolNode::Or(vec![collector(2), collector(3)]),
                children
    /// Idempotent and semantic-preserving.
            BoolNode::And(children) => {
#[derive(Debug)]
    }
            collector(2),
    }
fn push_not_into(child: BoolNode) -> BoolNode {
///   a SingleCollector residual). Returns `None` if a Collector is
            predicate("p", Operator::Eq, 5),
    ///
            BoolNode::Collector { .. } | BoolNode::Predicate(_) => {}
                let child = residual_bool_to_physical_expr(c)?;
    #[derive(Debug)]
            other => panic!("expected Or, got {:?}", other),
}
        }
    }
                    _ => panic!("expected Collector pair"),
    fn demote_under_or_replaces_with_predicate() {
    /// misalignment with no runtime error — wrong data, silent.
        ])));
        match self {
                assert!(matches!(*inner, ResolvedNode::Collector { .. }));
            (Operator::NotEq, Operator::Eq),
    }
    /// # Ordering invariant
/// Java factory plus the concrete collector reference; `DelegationPossible`
            BoolNode::And(vec![collector(0), collector(1)]),
        let col_idx = schema.index_of(col).unwrap();
        Operator::Gt => Operator::LtEq,
        BoolNode::DelegationPossible { original_expr, .. } => Some(Arc::clone(original_expr)),
            BoolNode::Or(children) => BoolNode::Or(
            }
            BoolNode::Or(children) => {
            }
        match tree.push_not_down() {
                let resolved: Result<Vec<_>, _> = children
    },
    ///   Coverage is only recovered by a covered sibling under an enclosing AND.
/// Used by `BoolNode::resolve_rec` to fold `Not(Predicate(cmp))` into a
        ]);
    /// Extract `(op)` from a `ResolvedNode::Predicate` whose child is a
            BoolNode::Not(child) => BoolNode::Not(Box::new(child.flatten())),
                // pairing — the evaluator creates providers lazily per-RG.
    }
                }
            ]),
    /// `DelegationPossible` leaves are NOT counted — they don't pair with
    }
        BoolNode::Collector { annotation_id: id }
        }
    use datafusion::logical_expr::Operator;
    #[test]
        out
        let tree = BoolNode::Or(vec![
                original_expr: Arc::clone(original_expr),
#[derive(Debug, Clone)]
            annotation_id,
    /// the DFS order produced by [`Self::collector_leaves`]. See that method
    /// contains deleted docs:
                *next += 1;
    }
}
        let tree = BoolNode::And(vec![
/// `Arc<dyn PhysicalExpr>` suitable for parquet's `with_predicate`
            }
                    .iter()
                    .into_iter()
            BoolNode::Not(child) => child.collect_leaves(out),
                BoolNode::Predicate(original_expr)
                let child = residual_bool_to_physical_expr(c)?;
    fn leaves_dfs_order() {
                assert!(matches!(&children[2], BoolNode::Predicate(_)));
 *
    }
                    .collect();
    fn flatten_preserves_mixed_connectives() {
    /// to get a `provider_key`, then creates per-segment collectors. The annotation
}
            BoolNode::And(children) => {
    }
}
    /// creation is lazy — done by the evaluator on first consult, not at resolve
            other => panic!("expected Or, got {:?}", other),
            BoolNode::Predicate(_) => 0,
            BoolNode::And(children) => {
            BoolNode::DelegationPossible { original_expr, .. } => {
            ResolvedNode::And(children) => {
    use datafusion::physical_expr::expressions::{BinaryExpr, NotExpr};
            other => panic!("expected flat Or with 4 children, got {:?}", other),
//!   `Collector` leaves carry the annotation ID identifying the delegated predicate
    #[test]
                assert!(matches!(
        }
    }
    /// `inject_live_docs_collector`). Coverage is decided over this executor's
            BoolNode::Or(outer) => {
                for c in children {
        let resolved = tree.resolve(&[(1, c)]).unwrap();
            BoolNode::Or(children) => children.iter().all(|c| c.is_covered_by_live_docs()),
        let tree = BoolNode::Not(Box::new(predicate("price", Operator::Gt, 10)));
    Not(Box<ResolvedNode>),
            } => Ok(ResolvedNode::DelegationPossible {
            BoolNode::Or(vec![collector(0), collector(1)]),
                for c in children {
        }
                Ok(ResolvedNode::And(resolved?))
/// pushdown or DataFusion's `Expr::evaluate(batch)`.
    ///
    }
                let mut out = Vec::with_capacity(children.len());
//! serialized, never crosses the FFM boundary.
        Operator::GtEq => Operator::Lt,
        let n = tree.push_not_down();
    }
    #[test]
        ])));
    /// - `Not`: never covered — a `NOT` inverts against the RG universe, so a
    /// [`Self::resolve`] consumes them. Both visit And/Or children left-to-
            BoolNode::And(children) => {
/// If `expr` is a `BinaryExpr(col, cmp, literal)` with an invertible
                        },
    DelegationPossible {
            let tree = BoolNode::Not(Box::new(predicate("x", orig, 0)));
        use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
//! expression (see [`crate::indexed_table::substrait_to_tree`]), never
            BoolNode::Or(children) => {
                        ResolvedNode::Collector {
                acc = Arc::new(BinaryExpr::new(acc, Operator::Or, child));
        annotation_id: i32,
///
    fn leaf_count_counts_only_collectors() {
    /// as a Predicate.
/// normalization should `push_not_down` first.
    #[test]
            other => panic!("expected Not(Collector), got {:?}", other),
                            Arc::clone(expr),
fn try_negate_cmp_expr(
            ResolvedNode::Not(inner) => {
        }
    fn not_collector_stays_wrapped() {
        let tree = BoolNode::Or(vec![
                    .ok_or_else(|| format!("collector index {} out of range", *next))?;
    Collector {
    /// yet (Phase 7 fast-follow).
use std::sync::Arc;
        original_expr: Arc<dyn PhysicalExpr>,
        assert_eq!(tree.collector_leaf_count(), 2);
    /// Used by `classify_filter` to disqualify trees where a Performance leaf
    // ── flatten ───────────────────────────────────────────────────────
        let original_expr: Arc<dyn PhysicalExpr> = Arc::new(BinaryExpr::new(left, op, right));
    /// `provider_key`, then `createCollector(provider_key, seg, min, max)`
    use datafusion::common::ScalarValue;
                    other => Ok(ResolvedNode::Not(Box::new(other))),
                    c.collect_delegation_possible_leaves(out);
        // tree. This is the documented v1 trade-off.
        BoolNode::And(children) => {
            ),
        Operator::Lt => Operator::GtEq,
        BoolNode::Collector { .. } => None,
                for c in &children {
// ════════════════════════════════════════════════════════════════════════════
    }
        ]);
            let mut iter = children.iter();
    /// `FilterClass::Tree` plans (any OR/NOT), whose evaluator can't run `DelegationPossible`.
    pub fn delegation_possible_leaves(&self) -> Vec<(i32, Arc<dyn PhysicalExpr>)> {
            BoolNode::Collector { .. } => {
        let right: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(v))));
                BoolNode::And(children) => assert_eq!(children.len(), 3),
    ///
    #[test]
/// creation is deferred to the evaluator); `Predicate` leaves carry the same
    node: &BoolNode,
        }
            BoolNode::Not(child) => push_not_into(*child),
    let bin = expr.downcast_ref::<BinaryExpr>()?;
    /// - `Collector` leaf: covered — its bitmap is live-docs-filtered on the
        let tree = BoolNode::Not(Box::new(collector(10)));
    fn delegation_possible(annotation_id: i32, col: &str, op: Operator, v: i32) -> BoolNode {
    /// Caller is responsible for creating the collectors — typically by
        for (orig, expected) in cases {
        }
    ///   Java side (`collectDocs` applies the segment's liveDocs).
            collector(7),
    }
impl BoolNode {
    /// cuts evaluator recursion depth and lets Path C allocate one Phase 1
///   encountered (shouldn't happen for a well-formed residual).
                for c in &children {
    use crate::indexed_table::index::CollectDocsResult;
            other => panic!("expected flat And with 3 children, got {:?}", other),
        }
            },
                let (provider_key, collector) = collectors
        BoolNode::Or(children) => {
                        matches!(c, BoolNode::Predicate(_)),
    use datafusion::logical_expr::Operator;
            BoolNode::Or(vec![collector(11), collector(12)]),
                            provider_key: p2, ..
        match self {
        match self {
    /// (via `annotation_id`) when its own pruning isn't selective enough. Provider
            BoolNode::Not(child) => child.delegation_possible_leaf_count(),
            predicate("y", Operator::Eq, 2),
    }
    fn flatten_collapses_nested_or() {
    /// - `Or`: covered only if ALL children are covered (the union re-admits
    pub fn demote_delegation_possible(self) -> BoolNode {
    use crate::indexed_table::index::RowGroupDocsCollector;
                Ok(ResolvedNode::Collector {
    #[test]
                let resolved_child = child.resolve_rec(collectors, next)?;
 * The OpenSearch Contributors require contributions made to
    }
    fn predicate(col: &str, op: Operator, v: i32) -> BoolNode {
        assert_eq!(leaves[1], 11);
    fn flatten_descends_into_not() {
                assert!(matches!(outer[0], BoolNode::And(_)));
    /// Count `Collector` leaf occurrences in the tree (DFS).
        // De Morgan's: NOT(AND(a, b, ...)) → OR(NOT(a), NOT(b), ...)
                        c
/// negated. Otherwise `None`.
        let tree = BoolNode::Not(Box::new(BoolNode::And(vec![
            BoolNode::Or(children) => {
        match demoted {
        // Double negation
        // Performance-delegated leaves contribute their original expression to the
                // Fast-path: NOT over a `Predicate(col op literal)` folds
//!
            BoolNode::Or(vec![collector(1), collector(2)]),
    Collector {
 * SPDX-License-Identifier: Apache-2.0
    #[test]
    /// De Morgan's NOT push-down normalization.
                    match c.flatten() {
    }
    fn de_morgan_not_or_to_and() {
        BoolNode::Predicate(expr) => Some(Arc::clone(expr)),
        }
    /// collector)` pairs (one per `Collector` leaf, same DFS order as
            Some(Arc::new(NotExpr::new(inner)))
    }
    #[test]
    };
            }
    /// Caller uses this to issue one `createProvider(bytes)` upcall per leaf.
        ]);
        // demote uniformly, even tag which sits under all-AND ancestors within the
    /// [`Self::collector_leaves`]) and expanding `Predicate` IDs into
/// Convert a Collector-free `BoolNode` (the residual of a
    fn resolve_replaces_collector_bytes_with_refs() {
    }
                BoolNode::Or(out)
    #[test]
                        "expected Predicate, got {:?}",
            BoolNode::Or(vec![
            delegation_possible(0, "verb", Operator::Eq, 0),
                assert!(matches!(&children[1], BoolNode::Predicate(_)));
    fn resolve_rec(
                assert_eq!(children.len(), 2);
            leaf @ (BoolNode::Collector { .. } | BoolNode::Predicate(_)) => leaf,
        let demoted = tree.demote_delegation_possible();
                    match c.flatten() {
    #[test]
        assert_eq!(leaves[0], 10);
                }
                }
            BoolNode::Or(children) => {
        }
            collector(0),
        Arc::clone(bin.right()),
    struct StubCollector(u8);
                    assert!(matches!(c, BoolNode::Not(_)));
                        assert_eq!(*p2, 20);
            BoolNode::DelegationPossible { .. } => 0,
            Some(acc)
    /// Return the serialized query bytes for each `Collector` leaf in DFS order.
            BoolNode::Or(vec![collector(1), predicate("x", Operator::Eq, 1)]),
            }
    #[test]
        flipped,
        &self,
    /// own page-stat pruning and pushdown; at per-RG time it MAY consult the peer
                delegation_possible(2, "value", Operator::Gt, 100),
            }
                    .collect();
