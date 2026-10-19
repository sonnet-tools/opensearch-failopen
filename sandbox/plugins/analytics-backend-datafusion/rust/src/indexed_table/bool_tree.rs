            BoolNode::Not(child) => child.delegation_possible_leaf_count(),
    };
fn push_not_into(child: BoolNode) -> BoolNode {
        let mut out = Vec::new();
        ])));
//! serialized, never crosses the FFM boundary.
                    },
        ]);
/// If `expr` is a `BinaryExpr(col, cmp, literal)` with an invertible
    match child {
                            provider_key: p1, ..
        Operator::NotEq => Operator::Eq,
            }
                        )))),
    /// shape.
        match demoted {
            }
    /// `inject_live_docs_collector`). Coverage is decided over this executor's
}
    ///
                }
            BoolNode::Or(children) => {
                // and one universe subtraction per RG in the candidate
    }
            let mut iter = children.iter();
            }
//! expression (see [`crate::indexed_table::substrait_to_tree`]), never
                        c
    },
            BoolNode::Or(children) => {
                        other => out.push(other),
            let mut acc = residual_bool_to_physical_expr(iter.next().unwrap())?;
    #[test]
                        },
    #[test]
        match self {
        let leaves = tree.collector_leaves();
        self.resolve_rec(collectors, &mut next)
    fn nested_not_recurses_through_and_or() {
    }
    fn collector(id: i32) -> BoolNode {
            }
        }
                Ok(ResolvedNode::And(resolved?))
    let flipped = match *bin.op() {
}
    }
                assert_eq!(children.len(), 2);
pub enum BoolNode {
    fn predicate(col: &str, op: Operator, v: i32) -> BoolNode {
//!   comparisons, IN, IS NULL, arithmetic, whatever produces a boolean.
        // residual — the driving backend evaluates them natively. Optional peer
//!   `BoolNode::resolve(collectors)` — `Collector` leaves get turned
        let tree = BoolNode::Not(Box::new(BoolNode::And(vec![
            BoolNode::And(children) | BoolNode::Or(children) => {
    /// Performance-delegated predicate — both the driving backend AND a peer can
    }
        use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
    use datafusion::logical_expr::Operator;
        // tree. This is the documented v1 trade-off.
                }
    fn collect_leaves(&self, out: &mut Vec<i32>) {
                    }
            delegation_possible(0, "verb", Operator::Eq, 0),
            BoolNode::Or(outer) => {
fn try_negate_cmp_expr(
                assert!(matches!(*inner, ResolvedNode::Collector { .. }));
    use crate::indexed_table::index::CollectDocsResult;
        let resolved = tree.resolve(&[(1, c)]).unwrap();
                assert_eq!(children.len(), 2);
    #[test]
                    .iter()
            BoolNode::Not(child) => child.collect_leaves(out),
    }
    }
                let mut out = Vec::with_capacity(children.len());
        BoolNode::Or(children) => {
        BoolNode::Predicate(Arc::new(BinaryExpr::new(left, op, right)))
                    );
    /// a provider at resolve time (provider creation is lazy in the evaluator).
    /// Caller uses this to issue one `createProvider(bytes)` upcall per leaf.
        let tree = BoolNode::Or(vec![
                    .into_iter()
                let child = residual_bool_to_physical_expr(c)?;
    /// At query-resolve time, the indexed executor upcalls into Java with this ID
        BoolNode::DelegationPossible { original_expr, .. } => Some(Arc::clone(original_expr)),
        match tree.push_not_down() {
                    BoolNode::Collector { annotation_id: 7 }
        }
//!
        }
            predicate("b", Operator::Eq, 2),
    /// Idempotent and semantic-preserving.
                    .collect(),
    /// right, recurse into Not, then yield leaves. The positional pairing in
        match tree.flatten() {
}
        let mut next = 0usize;
            }
/// `SingleCollector`-classified tree, or any subtree guaranteed to
            }
            collector(0),
                        ResolvedNode::Collector {
            BoolNode::And(children) => {
    },
/// Used by `BoolNode::resolve_rec` to fold `Not(Predicate(cmp))` into a
            BoolNode::Or(vec![collector(0), collector(1)]),
        // demote uniformly, even tag which sits under all-AND ancestors within the
        ]);
    /// - `Collector` leaf: covered — its bitmap is live-docs-filtered on the
            let tree = BoolNode::Not(Box::new(predicate("x", orig, 0)));
            BoolNode::Or(children) => {
                acc = Arc::new(BinaryExpr::new(acc, Operator::And, child));
//!
        let tree = BoolNode::And(vec![
        Operator::Gt => Operator::LtEq,
 * The OpenSearch Contributors require contributions made to
                    .iter()
    /// collector-to-leaf matching will silently become wrong.
        let tree = BoolNode::Not(Box::new(BoolNode::Not(Box::new(collector(10)))));
    fn flatten_descends_into_not() {
                            Arc::clone(expr),
        use datafusion::common::ScalarValue;
/// single flipped `Predicate` so the refinement stage doesn't have to
        let n = tree.push_not_down();
            other => panic!("expected Not, got {:?}", other),
    /// change one traversal you MUST change the other in lockstep, or
        }
            },
                return None;
            BoolNode::DelegationPossible {
                    provider_key: *provider_key,
    }
                }
    /// Return `(annotation_id, original_expr)` for each `DelegationPossible`
// ════════════════════════════════════════════════════════════════════════════
            other => panic!("expected Or, got {:?}", other),
    /// correctness `Collector`, so deleted docs are already excluded and no
            }
    /// own page-stat pruning and pushdown; at per-RG time it MAY consult the peer
            delegation_possible(0, "tag", Operator::Eq, 0),
                    .expect("expected BinaryExpr leaf");
    /// `resolve` (via the `*next` index) relies on this invariant; if you
        match self {
                delegation_possible(2, "value", Operator::Gt, 100),
                annotation_id,
    )))
    #[test]
        assert_eq!(leaves[2], 12);
use super::index::RowGroupDocsCollector;
            } => {
        next: &mut usize,
    pub fn collector_leaves(&self) -> Vec<i32> {
                    .collect();
                assert_eq!(children.len(), 3);
            predicate("a", Operator::Eq, 1),
                BoolNode::And(children.into_iter().map(|c| c.push_not_down()).collect())
        match tree.push_not_down() {
            BoolNode::Predicate(_) => {}
    /// per chunk.
            }
                }
        leaf => BoolNode::Not(Box::new(leaf)),
    node: &BoolNode,
pub fn residual_bool_to_physical_expr(
    /// # Ordering invariant
    /// Substrait decodes N-ary AND/OR as left-deep binary trees. Flattening
    }
    expr: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
    fn not_collector_stays_wrapped() {
/// have no `Collector` leaves) into a single
    /// De Morgan's NOT push-down normalization.
        let n = tree.push_not_down();
            BoolNode::Or(vec![collector(1), collector(2)]),
                children
 *
        ])));
        let tree = BoolNode::And(vec![
            }
            BoolNode::Not(inner) => match *inner {
                }
        match self {
        collectors: &[(i32, Arc<dyn RowGroupDocsCollector>)],
        let tree = BoolNode::Not(Box::new(collector(10)));
            other => panic!("expected And, got {:?}", other),
    ) -> Result<ResolvedNode, String> {
            collector(7),
                .iter()
                BoolNode::And(children) => assert_eq!(children.len(), 3),
/// A node in the boolean query tree (unresolved).
            BoolNode::Not(child) => BoolNode::Not(Box::new(child.demote_delegation_possible())),
 * compatible open source license.
        ]);
    #[test]
        }
// ════════════════════════════════════════════════════════════════════════════
        ];
                assert!(matches!(&children[2], BoolNode::Predicate(_)));
            (Operator::Gt, Operator::LtEq),
                original_expr: Arc::clone(original_expr),
            let inner = residual_bool_to_physical_expr(child)?;
        assert_eq!(leaves.len(), 3);
        }
        let left: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new(col, col_idx));
    }
/// Resolved tree. `Collector` leaves carry the provider-key returned by the
    ///
            collector(2),
            for c in iter {
///
    /// the DFS order produced by [`Self::collector_leaves`]. See that method
    #[test]
        assert_eq!(demoted.delegation_possible_leaf_count(), 0);
    }
                // kleene-`not()` kernel per batch in the refinement stage
    let bin = expr.downcast_ref::<BinaryExpr>()?;
    ///   `NOT(Collector)` re-admits the deleted docs the collector had excluded.
                delegation_possible(1, "verb", Operator::Eq, 0),
                    match c.flatten() {
            BoolNode::And(vec![collector(0), collector(1)]),
            other => panic!("expected And with 4 children, got {:?}", other),
                children.iter().map(|c| c.collector_leaf_count()).sum()
/*
            BoolNode::Predicate(_) => 0,
    /// time, `expr.evaluate(batch)` produces the per-row mask; at page-
                BoolNode::And(out)
            BoolNode::Or(vec![
        out
                annotation_id,
    fn flatten_collapses_nested_or() {
    }
    /// - `Not`: never covered — a `NOT` inverts against the RG universe, so a
    /// `provider_key`, then `createCollector(provider_key, seg, min, max)`
                    .map(|c| c.resolve_rec(collectors, next))
                Ok(ResolvedNode::Or(resolved?))
 */
                    assert!(
                    .map(|c| c.resolve_rec(collectors, next))
        let right: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(v))));
impl BoolNode {
        }
                // Performance leaves do not participate in eager provider/collector
        }
                    _ => panic!("expected Collector pair"),
            BoolNode::And(children) => {
        assert!(matches!(n, BoolNode::Collector { .. }));
    /// `(column, op, value)`.
                        other => out.push(other),
    fn de_morgan_not_and_to_or() {
        let b: Arc<dyn RowGroupDocsCollector> = Arc::new(StubCollector(2));
        ]);
            BoolNode::Or(vec![collector(11), collector(12)]),
        BoolNode::Collector { annotation_id: id }
                BoolNode::Predicate(original_expr)
            (Operator::Eq, Operator::NotEq),
        match self {
            BoolNode::And(vec![collector(3), collector(4)]),
        match node {
    use crate::indexed_table::index::RowGroupDocsCollector;
    use datafusion::physical_expr::expressions::BinaryExpr;
    /// creation is lazy — done by the evaluator on first consult, not at resolve
                        matches!(c, BoolNode::Predicate(_)),
        collector: Arc<dyn RowGroupDocsCollector>,
                    .collect(),
            }
                for c in children {
    use datafusion::physical_expr::expressions::{BinaryExpr, NotExpr};
                    assert!(matches!(c, BoolNode::Not(_)));
            ResolvedNode::And(children) => {
    ///
                assert!(matches!(outer[1], BoolNode::Not(_)));
        let resolved = tree.resolve(&[]).unwrap();
    }
                    .ok_or_else(|| format!("collector index {} out of range", *next))?;
            BoolNode::And(children) | BoolNode::Or(children) => children
    fn resolve_not_predicate_flips_op() {
    // ── Not(Predicate) op-flip during resolve ─────────────────────────
                other => panic!("expected And under Not, got {:?}", other),
        _ => return None,
            BoolNode::Or(children) => {
        assert!(err.contains("out of range"), "got: {}", err);
        collectors: &[(i32, Arc<dyn RowGroupDocsCollector>)],
                // isn't a recognizable comparison.
    }
        flipped,
    /// Demote every `DelegationPossible` leaf to a plain native `Predicate`. Called for
    /// [`Self::collector_leaves`]) and expanding `Predicate` IDs into
    }
    },
/// negated. Otherwise `None`.
            BoolNode::DelegationPossible { .. } | BoolNode::Predicate(_) => false,
        }
// Tests
            BoolNode::Or(children) => assert_eq!(children.len(), 4),
            other => panic!("expected Predicate, got {:?}", other),
            }
            leaf @ (BoolNode::Collector { .. } | BoolNode::Predicate(_)) => leaf,
    /// cuts evaluator recursion depth and lets Path C allocate one Phase 1
        // No DelegationPossible should remain anywhere.
/// `Arc<dyn PhysicalExpr>` as [`BoolNode::Predicate`].
    /// Correctness-delegated predicate — only the peer backend can evaluate it.
            BoolNode::Or(children) => BoolNode::Or(
    #[test]
    }
//!
    /// leaf in DFS order. Caller pairs these positionally with a parallel
            }
        let tree = BoolNode::Not(Box::new(BoolNode::Or(vec![
        // consultation is handled in the evaluator, not in the residual.
        // tag (under root AND) + (verb OR value): all DelegationPossible leaves
        match tree.flatten() {
            original_expr,
//! **No wire format.** The tree is built from the Substrait plan's filter
                out.push((*annotation_id, Arc::clone(original_expr)));
    /// in a tree that still has a surviving OR/NOT (e.g. `tag=a AND (dual OR native)`); demoting
            other => panic!("expected Or, got {:?}", other),
            } => Ok(ResolvedNode::DelegationPossible {
    }
            BoolNode::Not(child) => child.collect_delegation_possible_leaves(out),
) -> Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>> {
    /// time. See {@code FragmentConversionDriver}'s performance branch for emit
            other => panic!("expected Or, got {:?}", other),
//!   `Collector` leaves carry the annotation ID identifying the delegated predicate
/// call `not_kleene()` per batch.
        // De Morgan's: NOT(OR(a, b, ...)) → AND(NOT(a), NOT(b), ...)
                BoolNode::Or(vec![collector(2), collector(3)]),
        fn collect_packed_u64_bitset(&self, _: i32, _: i32) -> Result<CollectDocsResult, String> {
/// Java factory plus the concrete collector reference; `DelegationPossible`
            BoolNode::And(children) => BoolNode::And(
                let child = residual_bool_to_physical_expr(c)?;
            BoolNode::DelegationPossible { .. } => 1,
    use super::*;
    fn leaf_count_counts_only_collectors() {
            BoolNode::Collector { .. } => {
/// comparison operator, return the same expression with the operator
        let tree = predicate("status", Operator::Eq, 1);
            BoolNode::And(children.into_iter().map(push_not_into).collect()).push_not_down()
    ///   Java side (`collectDocs` applies the segment's liveDocs).
    Or(Vec<BoolNode>),
            collector(2),
/// leaves carry the unresolved annotation ID + original expression (provider
        match tree.flatten() {
                            provider_key: p2, ..
        }
    pub fn demote_delegation_possible(self) -> BoolNode {
) -> Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>> {
                let resolved_child = child.resolve_rec(collectors, next)?;
            BoolNode::And(children) => {
        let tree = BoolNode::And(vec![
    }
                }
        let err = tree.resolve(&[]).unwrap_err();
        match self {
        let tree = BoolNode::Or(vec![
            BoolNode::And(children) => {
        let resolved = tree.resolve(&[(10, a), (20, b)]).unwrap();
    /// Resolve the tree: walk in DFS order, consuming pre-built `(provider_key,
    /// - `And`: covered if ANY child is covered (intersection with a live-only
    impl RowGroupDocsCollector for StubCollector {
                // pairing — the evaluator creates providers lazily per-RG.
            BoolNode::Collector { .. } => 1,
    fn resolve_replaces_collector_bytes_with_refs() {
    }
        let resolved = tree.resolve(&[]).unwrap();
        let a: Arc<dyn RowGroupDocsCollector> = Arc::new(StubCollector(1));
        BoolNode::Predicate(expr) => Some(Arc::clone(expr)),
        let tree = BoolNode::And(vec![
    Collector {
            (Operator::GtEq, Operator::Lt),
            Some(acc)
        assert_eq!(tree.collector_leaf_count(), 2);
        ]);
    use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
        BoolNode::DelegationPossible {
#[cfg(test)]
                        },
    fn demote_uniform_includes_under_and_within_tree() {
//!   caller; Predicate leaves pass through unchanged. This is what the
                match resolved_child {
            if children.is_empty() {
        self.collect_leaves(&mut out);
    /// The `collectors` slice is consumed positionally; its order must match
    /// contains deleted docs:
                let resolved: Result<Vec<_>, _> = children
        // NOT(Collector) / NOT(Predicate) — stay wrapped; evaluator handles the negation
    fn resolve_rec(
    #[test]
            other => panic!("expected flat Or with 4 children, got {:?}", other),
    #[derive(Debug)]
        // Not(Predicate(price > 10)).
            BoolNode::Not(child) => BoolNode::Not(Box::new(child.flatten())),
    fn flatten_preserves_mixed_connectives() {
        provider_key: i32,
    use datafusion::physical_expr::PhysicalExpr;
    Not(Box<ResolvedNode>),
    /// collector)` pairs (one per `Collector` leaf, same DFS order as
    }
                BoolNode::Or(children.into_iter().map(|c| c.push_not_down()).collect())
    /// the Tree-path evaluator.
            BoolNode::Or(vec![collector(1), predicate("x", Operator::Eq, 1)]),
            BoolNode::And(children) | BoolNode::Or(children) => {
    ///   set removes deleted docs regardless of the other operands).
    /// it to native keeps results correct, just skipping the opportunistic peer consult.
        }
    ///
/// - This helper assumes no Collectors are present (appropriate for
        }
/// NOT handling: emits `NotExpr`. Callers that need De Morgan
pub enum ResolvedNode {
    /// - `Or`: covered only if ALL children are covered (the union re-admits
            leaf => leaf,
}
            }
    struct StubCollector(u8);
            }
    DelegationPossible {
/// Contrast with `page_pruner::bool_tree_to_pruning_expr`:
            BoolNode::Or(vec![
    #[test]
    /// `delegation_possible` that reaches a Tree plan; then this method goes away and the
            BoolNode::Collector { annotation_id } => {
                children
    #[test]
            }
        // De Morgan's: NOT(AND(a, b, ...)) → OR(NOT(a), NOT(b), ...)
            delegation_possible(1, "v", Operator::Gt, 10),
                original_expr,
    /// Performance-delegated leaf carried unresolved through `BoolNode::resolve`.
    /// Return the serialized query bytes for each `Collector` leaf in DFS order.
        let tree = BoolNode::Or(vec![
    }
                for c in &children {
    }
                acc = Arc::new(BinaryExpr::new(acc, Operator::Or, child));
    match node {
        let tree = collector(10);
    }
    fn de_morgan_not_or_to_and() {
    /// Count `Collector` leaf occurrences in the tree (DFS).
/// Convert a Collector-free `BoolNode` (the residual of a
            let resolved = tree.resolve(&[]).unwrap();
            }
//!   into `(provider_key, Arc<dyn RowGroupDocsCollector>)` pairs by the
        }
                    .get(*next)
    /// `BinaryExpr(col, op, literal)`. Panics otherwise.
    fn flatten_collapses_nested_and() {
    #[test]
    }
    And(Vec<BoolNode>),
        assert!(matches!(n, BoolNode::Not(b) if matches!(*b, BoolNode::Collector { .. })));
                assert_eq!(outer.len(), 2);
    #[test]
    Collector {
        let original_expr: Arc<dyn PhysicalExpr> = Arc::new(BinaryExpr::new(left, op, right));
        let demoted = tree.demote_delegation_possible();
    }
                    collector: Arc::clone(collector),
            annotation_id,
                // stage. Falls back to wrapping `Not` when the child
    use datafusion::common::ScalarValue;
    /// Used by `classify_filter` to disqualify trees where a Performance leaf
            }
/// pushdown or DataFusion's `Expr::evaluate(batch)`.
    And(Vec<ResolvedNode>),
                annotation_id: *annotation_id,
    /// `And(And(x, y), z)` → `And(x, y, z)`, similarly for `Or`.
///   a SingleCollector residual). Returns `None` if a Collector is
//! Boolean query tree representation.
        BoolNode::Collector { .. } => None,
                return None;
                    match c.flatten() {
    pub fn delegation_possible_leaves(&self) -> Vec<(i32, Arc<dyn PhysicalExpr>)> {
    /// yet (Phase 7 fast-follow).
            }
    fn leaves_dfs_order() {
            other => panic!("expected flat And with 3 children, got {:?}", other),
            BoolNode::Not(child) => {
                out.push(*annotation_id);
        let tree = BoolNode::And(vec![collector(0), collector(1)]);
                        "expected Predicate, got {:?}",
        self.collect_delegation_possible_leaves(&mut out);
                for c in children {
        let col_idx = schema.index_of(col).unwrap();
                    .map(|c| c.demote_delegation_possible())
                        assert_eq!(*p1, 10);
            BoolNode::Or(children) => {
    }
    #[test]
            delegation_possible(1, "value", Operator::Gt, 100),
                    (
    /// - `DelegationPossible` / `Predicate` leaf: not covered — evaluated by the
            ResolvedNode::Not(inner) => {
    fn resolve_not_collector_still_wraps() {
    /// sits under OR/NOT — those need Tree-path support which isn't implemented
    fn resolve_passes_predicate_expr_through() {
    Not(Box<BoolNode>),
                *bin.op()
            }
                assert!(matches!(
    fn resolve_not_predicate_flip_table() {
    #[test]
        }
            Ok(vec![self.0 as u64].into())
            }),
                        BoolNode::And(inner) => out.extend(inner),
        // Double negation
            BoolNode::DelegationPossible { original_expr, .. } => {
            BoolNode::And(children) | BoolNode::Or(children) => {
        match tree.push_not_down() {
                    assert!(matches!(c, BoolNode::Not(_)));
        BoolNode::Not(child) => {
    /// Arbitrary boolean-valued DataFusion expression. At refinement
            (Operator::NotEq, Operator::Eq),
///
            predicate("p", Operator::Eq, 5),
    fn demote_under_or_replaces_with_predicate() {
///
                    .collect();
    /// to get a `provider_key`, then creates per-segment collectors. The annotation
                        Some(flipped) => Ok(ResolvedNode::Predicate(flipped)),
                    .downcast_ref::<BinaryExpr>()
        let demoted = tree.demote_delegation_possible();
                collector(1),
                        BoolNode::Or(inner) => out.extend(inner),
    }
    #[test]
    /// prune time, the expression is handed to DataFusion's
        }
        let tree = BoolNode::Not(Box::new(predicate("price", Operator::Gt, 10)));
                    .into_iter()
        annotation_id: i32,
        Arc::clone(bin.right()),
    #[test]
    /// as a Predicate.
    ///   deleted docs through any uncovered branch).
            BoolNode::And(children) => {
                    }
    ///   Coverage is only recovered by a covered sibling under an enclosing AND.
            BoolNode::Not(_) => false,
                    ) => {
        ]);
    pub fn is_covered_by_live_docs(&self) -> bool {
    /// upcalling Java `createProvider(annotation_id)` per leaf to get a
            BoolNode::Predicate(expr) => Ok(ResolvedNode::Predicate(Arc::clone(expr))),
        annotation_id: i32,
        match self {
                assert!(matches!(children[1], BoolNode::Or(_)));
        match self {
            other => panic!("expected And, got {:?}", other),
    #[test]
        let tree = BoolNode::Not(Box::new(BoolNode::And(vec![collector(0), collector(1)])));
                        assert_eq!(*p2, 20);
        let schema = Schema::new(vec![Field::new(col, DataType::Int32, false)]);
                assert!(matches!(&children[1], BoolNode::Predicate(_)));
                    assert!(matches!(c, BoolNode::Collector { .. }));
                })
        Operator::GtEq => Operator::Lt,
    pub fn delegation_possible_leaf_count(&self) -> usize {
            }
}
        ]);
    /// Extract `(op)` from a `ResolvedNode::Predicate` whose child is a
        match demoted {
        BoolNode::Or(children) => {
            }
 * this file be licensed under the Apache-2.0 license or a
/// normalization should `push_not_down` first.
        use datafusion::physical_expr::expressions::BinaryExpr;
                BoolNode::Or(out)
    /// bitmap-composition model, where the per-RG candidate universe still
                        None => Ok(ResolvedNode::Not(Box::new(ResolvedNode::Predicate(
        original_expr: Arc<dyn PhysicalExpr>,
                    }
}
            BoolNode::DelegationPossible {
        let tree = BoolNode::And(vec![
    }
    use datafusion::logical_expr::Operator;
            collector(0),
mod tests {
        }
    /// FIXME: move this Tree-classification awareness into the coordinator so it never emits a
                    c.collect_leaves(out);
    pub fn push_not_down(self) -> BoolNode {
            BoolNode::Not(child) => push_not_into(*child),
    Predicate(Arc<dyn PhysicalExpr>),
                assert_eq!(children.len(), 2);
        match self {
        }
        Operator::LtEq => Operator::Gt,
            ]),
/// creation is deferred to the evaluator); `Predicate` leaves carry the same
    fn delegation_possible(annotation_id: i32, col: &str, op: Operator, v: i32) -> BoolNode {
use datafusion::physical_expr::PhysicalExpr;
    /// peer-backend consultation in the evaluator.
            BoolNode::Or(children) => children.iter().all(|c| c.is_covered_by_live_docs()),
        let c: Arc<dyn RowGroupDocsCollector> = Arc::new(StubCollector(0));
    }
        let tree = BoolNode::Not(Box::new(BoolNode::And(vec![
        ]);
        Arc::clone(bin.left()),
///   the result can feed DataFusion's `PruningPredicate` rewriter
            Some(Arc::new(NotExpr::new(inner)))
    // ── resolve ────────────────────────────────────────────────────────
    #[test]
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
    // ── collector_leaf_count / collector_leaves ───────────────────────
        &self,
    /// ID maps to a pre-compiled query on the Java side (via FilterDelegationHandle).
        // Performance-delegated leaves contribute their original expression to the
                    .map(|c| c.demote_delegation_possible())
    /// `FilterClass::Tree` plans (any OR/NOT), whose evaluator can't run `DelegationPossible`.
    }
    /// `Vec<Arc<OnceLock<ProviderHandle>>>` (one lock per leaf) to drive lazy
    /// synthetic live-docs Collector needs to be injected (see
    /// # Ordering invariant
            BoolNode::Predicate(_) => 0,
    pub fn resolve(
    // ── flatten ───────────────────────────────────────────────────────
    /// bitmap per conceptual child instead of one per binary split.
    /// After this, `Not` only appears directly above `Collector` or `Predicate` leaves.
    }
        BoolNode::Not(inner) => inner.push_not_down(),
    ///
        }
    fn resolve_out_of_range_errors() {
        for (orig, expected) in cases {
    /// This method MUST walk children in the same order as
    /// (via `annotation_id`) when its own pruning isn't selective enough. Provider
                assert!(matches!(outer[0], BoolNode::And(_)));
        }
            Some(acc)
                .sum(),
            ResolvedNode::Predicate(expr) => {
            collector(0),
    }
    /// expression carried in `original_expr` is what the demotion should produce
        // Not(price > 10) should resolve to price <= 10, not
                *next += 1;
    // ── push_not_down (De Morgan) ─────────────────────────────────────
/// `Arc<dyn PhysicalExpr>` suitable for parquet's `with_predicate`
                }
            }
    }
            BoolNode::Collector { .. } => true,
 * SPDX-License-Identifier: Apache-2.0
            }
        let left: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new(col, col_idx));
    fn demote_preserves_collectors_and_predicates() {
    /// evaluate it. The driving backend evaluates `original_expr` natively for its
                    c.collect_delegation_possible_leaves(out);
            }
        assert_eq!(leaves[1], 11);
            if children.is_empty() {
    /// Collapse nested same-kind connectives:
        let tree = BoolNode::Not(Box::new(collector(10)));
        BoolNode::And(children) => {
///   encountered (shouldn't happen for a well-formed residual).
//! Two flavors:
            other => panic!("expected Not(Collector), got {:?}", other),
    use datafusion::logical_expr::Operator;
                    other => Ok(ResolvedNode::Not(Box::new(other))),
//! - [`BoolNode`] — unresolved. Produced by `expr_to_bool_tree`.
        }
                for c in children {
    #[test]
    /// for the traversal contract. A mismatch causes collector-to-leaf
            BoolNode::Collector { .. } => 0,
                .map(|c| c.delegation_possible_leaf_count())
            leaf => leaf,
use crate::indexed_table::index::CollectDocsResult;
//!   (as extracted from the `index_filter(bytes)` UDF call);
                // Fast-path: NOT over a `Predicate(col op literal)` folds
        let mut out = Vec::new();
                assert_eq!(children.len(), 3);
    DelegationPossible {
    /// [`Self::resolve`] consumes them. Both visit And/Or children left-to-
            BoolNode::Not(child) => child.collector_leaf_count(),
        let schema = Schema::new(vec![Field::new(col, DataType::Int32, false)]);
            BoolNode::And(children) => {
    }
        &self,
    ///   driving backend over a universe that still includes deleted docs.
#[derive(Debug, Clone)]
        Operator::Lt => Operator::GtEq,
    },
    }
        }
    }
        Operator::Eq => Operator::NotEq,
            let mut acc = residual_bool_to_physical_expr(iter.next().unwrap())?;
///   (which evaluates only against per-page stats, not cell values).
//!   `Predicate` leaves carry an arbitrary DataFusion
    /// misalignment with no runtime error — wrong data, silent.
    }
        match self {
    fn collect_delegation_possible_leaves(&self, out: &mut Vec<(i32, Arc<dyn PhysicalExpr>)>) {
            other => panic!("expected Or with two Predicates, got {:?}", other),
//!   evaluator walks.
                for c in children {
/// - That helper replaces `Collector` leaves with `Literal(true)` so
    #[test]
        }
        let demoted = tree.demote_delegation_possible();
    /// evaluator arms can throw. Pairs with implementing performance delegation under OR/NOT in
            BoolNode::Collector { .. } | BoolNode::Predicate(_) => {}
    pub fn flatten(self) -> BoolNode {
                assert_eq!(children.len(), 2);
            (Operator::LtEq, Operator::Gt),
            BoolNode::DelegationPossible { .. } => 0,
                        ResolvedNode::Collector {
                }
        let col_idx = schema.index_of(col).unwrap();
            collector(10),
        }
            }
            BoolNode::DelegationPossible { .. } => {
            collector(2),
                assert_eq!(children.len(), 4);
                // into `Predicate(col flipped_op literal)`. Saves one
        let right: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(v))));
            BoolNode::Or(children.into_iter().map(push_not_into).collect()).push_not_down()
                Ok(ResolvedNode::Collector {
    fn double_negation_cancels() {
    Predicate(Arc<dyn PhysicalExpr>),
    Some(Arc::new(BinaryExpr::new(
        out
        }
                    &children[0],
        annotation_id: i32,
    }
        assert!(matches!(resolved, ResolvedNode::Predicate(_)));
        assert_eq!(predicate_op(&resolved), Operator::LtEq);
            (Operator::Lt, Operator::GtEq),
        }
    /// Caller is responsible for creating the collectors — typically by
                let mut out = Vec::with_capacity(children.len());
        original_expr: Arc<dyn PhysicalExpr>,
        match tree.flatten() {
            }
    /// Count `DelegationPossible` (performance-delegated) leaves in the tree (DFS).
    /// Whether every row this tree can emit is guaranteed to pass through a
            BoolNode::And(children) => children.iter().any(|c| c.is_covered_by_live_docs()),
            }
                for c in &children {
    ) -> Result<ResolvedNode, String> {
    }
            }
        let cases = [
        assert_eq!(leaves[0], 10);
                let (provider_key, collector) = collectors
                let resolved: Result<Vec<_>, _> = children
                let bin = expr
    /// The coordinator never puts perf directly under OR/NOT, but an AND-side perf leaf can ride
//! - [`ResolvedNode`] — resolved. Produced by
use std::sync::Arc;
#[derive(Debug)]
                }
        }
    fn predicate_op(node: &ResolvedNode) -> Operator {
        }
    pub fn collector_leaf_count(&self) -> usize {
                for c in &children {
        BoolNode::And(children) => {
    /// creation happens lazily on first consult via {@code OnceLock}.
            }
                ));
//!   [`PhysicalExpr`](datafusion::physical_expr::PhysicalExpr) —
}
            assert_eq!(predicate_op(&resolved), expected, "flipping {:?}", orig);
            predicate("y", Operator::Eq, 2),
    ///
        }
        match resolved {
        use datafusion::physical_expr::PhysicalExpr;
    /// `DelegationPossible` leaves are NOT counted — they don't pair with
    ///
        }
                for c in &children {
                }
            ),
        match resolved {
            for c in iter {
    /// The evaluator decides per-RG whether to consult the peer; provider
                    ResolvedNode::Predicate(ref expr) => match try_negate_cmp_expr(expr) {
        use datafusion::arrow::datatypes::{DataType, Field, Schema};
    /// Build a DelegationPossible leaf wrapping a comparison expression. The
                original_expr,
    }
            ]),
            BoolNode::Or(children) => {
                match (&children[0], &children[1]) {
    Or(Vec<ResolvedNode>),
    /// `PruningPredicate` directly.
            BoolNode::And(vec![collector(0), collector(1)]),
            ),
        ])));
    // ── demote_delegation_possible ────────────────────────────────────
            let mut iter = children.iter();
