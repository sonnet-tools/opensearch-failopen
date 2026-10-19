    ])
    ])
// NOT(A OR B) == NOT(A) AND NOT(B)
        })
        or_(vec![
async fn simple_and_of_collector_and_predicate() {
    for (_, price, _, _) in &rows {
reference_test!(
// Pathological: deeply right-skewed AND tree (5 levels right-leaning).
);
    commutative_and_collector_first,
        T::And(children) => BoolNode::And(children.iter().map(to_engine_tree).collect()),
reference_test!(
    deeply_nested_and_or_with_mixed_columns,
                l(LeafId::PriceLt(50)),
);
        // we only check that we have 14 unique inputs, not distinct prices.
);
    or_(vec![l(CategoryElectronics), not_(l(CategoryElectronics))])
// Many-child AND with one Collector + many Predicate siblings (exercise
// Batch 6 — commutativity, cost-order stability, stress shapes.
            l(LeafId::PriceGt(100)),
    and_(vec![
        ]),
    let rows = run_tree(tree).await;
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
            l(LeafId::StatusEq("archived"))
        l(CategoryElectronics),
    PriceLt100,
);
);
    not_around_collectors_only_and,
    assoc_and_right,
    ])
}
);
reference_test!(
            }),
    and_(vec![l(PriceLt50), l(CategoryBooks)])
);
        and_(vec![l(PriceLt50), l(PriceGe150)]), // contradictory → empty
                        l
    or_(vec![
// Chain of NOTs + ANDs.
// Single-leaf tests.
);
    ])
        ]
    or_collector_with_nested_multi_column_or,
// price = 50 OR price = 95 OR price = 200 — chained same-column OR
//! idempotence, De Morgan, absorption, distributivity, commutativity,
            l(PriceLt100),
            LeafId::StatusArchived => STATUSES[row] == "archived",
// framework so expected rows are computed row-by-row, not hand-crafted.
            cat
);
    and_of_contradictory_predicates,
        l(LeafId::PriceGt(40)),
reference_test!(
// ─────────────────────────────────────────────────────────────────────
// Collector excluded via NOT in OR sibling. Tests per-leaf cache after OR
    distributive_and_over_or,
    and_(vec![
);
/// Lower `T` to `BoolNode`. `Predicate` leaves are materialized to
            and_(vec![
    ])
// (provider,idx) pairs even though they query the same backend side.
                    .iter()
// Nested NOT(OR(NOT ...)) — double negation through De Morgan equivalent
    }
        l(PriceLt50),
    for (brand, price, status, cat) in &rows {
// NOT(status = "archived") — NOT over string predicate (not the Collector
    let tree = BoolNode::Or(vec![
    de_morgan_not_and_mixed,
);
                let literals: Vec<Arc<dyn PhysicalExpr>> = list
    alternating_collectors_and_predicates,
            LeafId::PriceEq150 => PRICES[row] == 150,
}
    ($name:ident, $tree:expr) => {
    let rows = run_tree(tree).await;
    or_of_collector_and_branches_mixed_shapes,
// Same set in different child orders must give identical results.
/// ```
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    ])
                let sum: Arc<dyn PhysicalExpr> =
}
);
            found.is_some(),
    ])
//! row-by-row directly on the fixture arrays, so each test is one line.
    de_morgan_not_and_two_collectors,
reference_test!(
    or_(vec![l(BrandAmazon), not_(l(BrandApple))])
);
// Predicate that matches nothing: price < 50 AND price > 100 (vacuous).
);
reference_test!(
        l(CategoryBooks),
    or_(vec![
        l(LeafId::PricePlusGt {
        l(BrandAmazon),
 * The OpenSearch Contributors require contributions made to
);
        l(CategoryElectronics),
    fn as_collector_provider_id(self) -> Option<u8> {
///   (brand == "amazon") AND (status == "active")
reference_test!(
        l(BrandApple),
reference_test!(not_of_in_list, not_(l(LeafId::PriceIn(&[50, 95]))));
    same_provider_id_used_twice,
reference_test!(
);
        if let Some(provider_id) = self.as_collector_provider_id() {
    // Richer operators — exercise expressions our old converter rejected.
    ])
    empty_via_predicate_combination,
            threshold: 50
///     equiv
        l(BrandAmazon),
        ]),
);
            l(LeafId::StatusEq("archived"))
        BoolNode::Or(vec![
    ]);
    and_(vec![l(PriceLt100), l(BrandApple)])
    ])
        }
// AND of three new-operator types: IN, arithmetic, status predicate.
fn to_engine_tree(tree: &T) -> BoolNode {
            or_(vec![
    ])
    or_(vec![
        and_(vec![l(BrandAmazon), not_(l(PriceLt100))]),
    ])
    multi_column_or,
    assert_eq!(rows.len(), 11);
);
        l(StatusArchived)
reference_test!(
                or_(vec![
);
    not_over_wide_or_of_collectors,
        Some(match self {
            threshold: 50
    disjoint_branches_or,
                    l(BrandApple),
                && !actual.contains(&r)
                    Arc::new(Literal::new(ScalarValue::Int32(Some(offset))));
reference_test!(
        l(PriceEq150),
                annotation_id: provider_id as i32,
reference_test!(
    BrandAmazon,    // provider_id = 0
    let tree = BoolNode::And(vec![
        l(BrandApple),
        pred_str("category", Operator::Eq, "electronics"),
reference_test!(not_not_cancels, not_(not_(l(LeafId::PriceGt(100)))));
                BoolNode::Predicate(Arc::new(BinaryExpr::new(sum, Operator::Gt, thr)))
            LeafId::PriceGe150 => ReferencePred::Int("price", Operator::GtEq, 150),
reference_test!(
    ]))
    ])
        l(PriceLt100),
            price,
    let mut prices: Vec<i32> = rows.iter().map(|r| r.1).collect();
        or_(vec![l(LeafId::PriceLt(60)), l(LeafId::PriceGt(190))]),
    let tree = BoolNode::Not(Box::new(BoolNode::And(vec![
            LeafId::PriceLt(v) => PRICES[row] < v,
 * SPDX-License-Identifier: Apache-2.0
// NOT((price + 10) > 100) — NOT over arithmetic; NotExpr wrapper path.
}
reference_test!(
// OR where one side is always-true selector: cat=electronics OR NOT(cat=electronics)
    // Map returned rows back to fixture row indices by matching (brand,price,status,category).
        T::Or(children) => children.iter().any(|c| reference_evaluator(c, row)),
    ]);
    }
            LeafId::CategoryBooks => ReferencePred::Str("category", Operator::Eq, "books"),
);
// Associativity: A AND (B AND C) vs (A AND B) AND C — engine must not
);
        actual, expected_sorted,
reference_test!(
    and_(vec![l(PriceLt50), l(PriceGt100)])
    or_(vec![l(BrandApple), l(LeafId::PriceIn(&[40, 300]))])
        }),
/// `BoolNode::Predicate(PhysicalExpr)` directly via [`LeafId::as_bool_node`].
    assert_eq!(prices, vec![50, 80, 120]);
    // apple AND price<100: 4 (90), 5 (95), 7 (60), 13 (45) → 4
 * compatible open source license.
        l(LeafId::PriceIn(&[45, 60, 90, 95, 200])), // all apple prices
            _ => return None,
//
        ("amazon".into(), 80),
reference_test!(
}
// ─────────────────────────────────────────────────────────────────────
    // Expected: apple rows with price > 80: rows 4,5,6 → prices 90,95,200
        actual.push(found.unwrap());
 * this file be licensed under the Apache-2.0 license or a
// Distributivity: A AND (B OR C) == (A AND B) OR (A AND C)
reference_test!(idempotent_and, and_(vec![l(BrandAmazon), l(BrandAmazon)]));
reference_test!(
        or_(vec![
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
reference_test!(
    ])
reference_test!(
    }
                    Arc::new(Literal::new(ScalarValue::Int32(Some(threshold))));
    not_(and_(vec![l(BrandAmazon), l(PriceLt100)]))
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        or_(vec![l(PriceLt100), l(CategoryBooks)]),
// Combined range covers all prices in fixture (30..300).
    and_(vec![l(PriceEq150), l(CategoryBooks)])
}
    ])
    assoc_or_right,
    or_of_predicates_different_columns,
///   OR(
reference_test!(
        or_(vec![l(PriceLt100), l(PriceGe150), l(PriceEq150)]),
    let rows = run_tree(tree).await;
    },
// NOT coverage across operator types. Exercises:
}
    PriceLt(i32),
        let price_idx = schema.index_of("price").unwrap();
reference_test!(leaf_price_lt_100, l(PriceLt100));
        ("apple".into(), 95),
        // (price > 100) OR (price + 10 > 50) instead. Still a valid tree.
    // electronics AND not archived: rows 0,3,4,7,8,10,14,15
);
                    .collect();
    ])
/// Simple sanity: single collector + single predicate AND'd.
            l(LeafId::PriceIn(&[60, 200])),
    T::Not(Box::new(x))
        l(PriceGt100),
        ]),
    exp.sort();
//     arithmetic, string equality).
reference_test!(
// Expected: row 12 has amazon, electronics, 30 → category≠books → 0 rows.
// De Morgan's laws.
// Richer operators — DataFusion PhysicalExpr refinement handles these
    and_non_overlapping_collectors,
reference_test!(
    CategoryElectronics,
reference_test!(commutative_or_ab, or_(vec![l(BrandAmazon), l(BrandApple)]));
        ]),
// ─────────────────────────────────────────────────────────────────────
reference_test!(
    and_(vec![
        not_(l(StatusArchived)),
    let tree = BoolNode::Not(Box::new(index_leaf(0))); // NOT amazon
                and_(vec![not_(l(StatusArchived)), not_(l(PriceGe150))]),
    or_(vec![
    in_list_under_collector,
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
// OR of two AND-branches, each mixing Collector + different predicate shapes.
    or_(vec![
        not_(l(LeafId::PriceIn(&[90, 95]))),        // exclude two
// ──────────────────────────────────────────────────────────────────────
    /// lowering uses [`as_bool_node`] which produces a
        name, actual, expected_sorted
    ])
// Apple rows are all electronics OR books. Books apple: row 6.
    assert_eq!(rows.len(), 14);
    ])
            LeafId::PriceGt(v) => PRICES[row] > v,
    or_of_predicates_same_column,
        or_(vec![l(PriceEq150), l(CategoryBooks)]),
enum LeafId {
);
    /// Evaluated as a parquet predicate (not via Collector bitset).
    and_(vec![l(BrandApple), l(LeafId::PriceIn(&[50, 95, 200]))])
            LeafId::BrandAmazon => 0,
// Many-child OR with one Predicate + many Collector siblings (OR cost-sort
);
async fn not_collector_with_predicate() {
reference_test!(
);
            }
    not_(or_(vec![
    collector_or_in_list,
                pred_int("price", Operator::Lt, 100), // price < 100
    PriceIn(&'static [i32]),
        ]),
reference_test!(
reference_test!(
    or_(vec![
    or_predicate_with_many_collector_siblings,
reference_test!(
            ("apple".into(), 90),
        and_(vec![l(BrandAmazon), l(PriceLt50)]),
        l(LeafId::PriceIn(&[30, 50])),
reference_test!(
//! Boolean-algebra correctness on a 16-row hand-authored fixture:
    and_(vec![
// Wide AND fan-out (5 children).
);
                ReferencePred::Str(col, op, v) => pred_str(col, op, v),
//   - De Morgan push-down through AND/OR (in BoolNode::push_not_down);
    and_(vec![
);
    right_skewed_and,
    or_(vec![
fn reference_evaluator(tree: &T, row: usize) -> bool {
            out.push(PRICES[i]);
);
                            Arc::new(Literal::new(ScalarValue::Int32(Some(*v))));
// These stress the tree walkers, DFS ordering, and cost-sort stability.
            LeafId::PriceEq(v) => PRICES[row] == v,
// ──────────────────────────────────────────────────────────────────────
        #[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    //   amazon AND archived: rows 1,12 → exclude these
// Heavy mixed: 6 levels, every operator, crosses columns.
    not_(or_(vec![l(StatusArchived), l(PriceGe150)]))
    not_of_in_list_under_collector,
    ])
        let found = (0..16).find(|&r| {
            LeafId::StatusEq(v) => ReferencePred::Str("status", Operator::Eq, v),
// ─────────────────────────────────────────────────────────────────────
    assoc_or_left,
    and_(vec![
// to AND of the inner items.
        index_leaf(0),                          // amazon
    and_(vec![
        // Other rows' prices may equal these too (e.g. row 11 is 150), so
                    and_(vec![l(PriceLt100), l(CategoryElectronics)]),
        T::Or(children) => BoolNode::Or(children.iter().map(to_engine_tree).collect()),
// Each test is named for its shape; reference_evaluator catches mismatches.
    fn as_reference_predicate(self) -> Option<ReferencePred> {
async fn negated_leaf_intersected_with_positive_leaf() {
// shapes that the old six-op whitelist rejected.
}
    and_(vec![
#[derive(Debug, Clone, Copy)]
// Pathological: deeply left-skewed OR tree.
        BoolNode::Not(Box::new(index_leaf(2))), // NOT archived
                    .map(|v| {
        l(StatusArchived),
);
// AND cost-sort that puts Predicates first).
            assert_engine_matches_reference(stringify!($name), $tree).await;
);
        or_(vec![l(PriceLt50), l(PriceEq150)]),
        vec![
    for i in 0..16 {
reference_test!(
}
        l(BrandAmazon),
    and_collector_or_of_different_columns,
    not_of_arithmetic,
    and_(vec![
reference_test!(
async fn complex_tree_3_levels_3_collectors_2_predicates() {
    arithmetic_predicate_under_collector,
        ("amazon".into(), 120),
reference_test!(
reference_test!(
    and_(vec![l(BrandAmazon), l(BrandApple)])
        and_(vec![l(PriceLt100), l(CategoryBooks)])
// ──────────────────────────────────────────────────────────────────────
        and_(vec![l(BrandAmazon), l(CategoryBooks)]),
    ])
);
    T::Leaf(id)
);
    and_(vec![
        // So (price + 10) < 50 doesn't exist as a single LeafId; this is
reference_test!(
                or_(vec![l(PriceLt50), l(BrandAmazon)]),
        ("amazon".into(), 30),
            l(LeafId::PricePlusGt {
            LeafId::PriceGt100 => ReferencePred::Int("price", Operator::Gt, 100),
        ("apple".into(), 45),
        and_(vec![not_(l(CategoryElectronics)), l(CategoryBooks)]),
        l(BrandAmazon),
reference_test!(
    and_(vec![
        not_(l(CategoryElectronics)),
    empty_result_via_three_way_and,
            return BoolNode::Collector {
// ══════════════════════════════════════════════════════════════════════
    ])
reference_test!(
            or_(vec![
    // amazon AND active: rows 0,2,3
// Collector AND IN AND NOT IN — same column, both polarities.
reference_test!(
    }
}
        l(BrandApple),
);
    ])
        l(PriceEq150),
fn expected_for_complex_tree() -> Vec<i32> {
);
    //   all other 14 rows pass
reference_test!(
        l(BrandApple),
    and_(vec![
    or_of_collector_and_predicate,
        ]),
        threshold: 100
    absorption_or,
            LeafId::PriceLt50 => ReferencePred::Int("price", Operator::Lt, 50),
);
            offset: 10,
    let tree = BoolNode::And(vec![index_leaf(1), pred_int("price", Operator::Gt, 80)]);
    ])
///   brand == "amazon" OR (brand == "apple" AND price < 100)
// Every test is self-verifying via reference_test!.
// ──────────────────────────────────────────────────────────────────────
        not_(l(PriceGe150)),
// Idempotence: A AND A == A ; A OR A == A
    ])
    );
    Leaf(LeafId),
    ]);
    ])
            LeafId::BrandApple => 1,
fn l(id: LeafId) -> T {
        not_(l(BrandAmazon)),
    let mut actual: Vec<usize> = Vec::with_capacity(rows.len());
        l(CategoryElectronics),
    /// Engine-tree leaf for this LeafId.
//! associativity, double-negation, bound edges, deep nesting, wide
        ("apple".into(), 60),
    or_of_many_same_column_predicates,
    Int(&'static str, Operator, i32),
// without hand-computing expected rows — covers many boolean combinations
        // sanity: the 2 excluded rows have prices 150 (row 1) and 30 (row 12).
    not_and_not_chain,
// engine returns exactly the docs the tree selects.
        and_(vec![
    PriceGe150,
// Single predicate across 5 OR clauses (redundant but valid).
        l(CategoryBooks),
// ─────────────────────────────────────────────────────────────────────
        l(LeafId::PricePlusGt {
            l(LeafId::PriceLt(40)),
            l(LeafId::StatusEq("active")),
    /// `BoolNode::Predicate(PhysicalExpr)` directly.
    // Tree: AND(apple, price > 80)
//   - the NotExpr wrapper fallback for non-invertible shapes (IN,
    // 16 docs, 5 are amazon → 11 expected.
);
    // Compute expected in Rust — straightforward boolean eval over the data
reference_test!(
    or_(vec![
);
reference_test!(
reference_test!(leaf_brand_apple, l(BrandApple));
// AND of two non-overlapping collectors → empty.
);
    and_of_a_and_not_a,
        l(PriceLt50),
use super::*;
        }
}
);
        l(BrandApple),
    let rows = run_tree(bool_tree).await;
reference_test!(idempotent_or, or_(vec![l(PriceLt100), l(PriceLt100)]));
    Not(Box<T>),
        l(PriceLt100),
        T::Leaf(l) => l.as_bool_node(),
    nested_5_levels,
            status,
// Collector AND (NOT string-predicate OR comparison).
// Batch 1 — single leaves + basic combinators.
    full_subtree_gates_entire_or,
// 6 children — exceeds typical small-arena bounds.
reference_test!(
    or_(vec![
            LeafId::PriceGe150 => PRICES[row] >= 150,
// ─────────────────────────────────────────────────────────────────────
        Some(match self {
);
        T::Not(inner) => !reference_evaluator(inner, row),
        or_(vec![l(BrandAmazon), l(BrandApple), l(StatusArchived),]),
// ─────────────────────────────────────────────────────────────────────
    let mut out = Vec::new();
    and_(vec![l(BrandApple), not_(l(LeafId::PriceIn(&[95, 200]))),])
    not_(and_(vec![l(LeafId::PriceGt(40)), l(LeafId::PriceLt(100))]))
    three_way_and_mixed_cols,
// Same collector leaf used in both branches of OR. DFS visits each
    assert_eq!(
        or_(vec![
// ⇒ universe. All 16 rows.
}
    or_(vec![
    PriceEq(i32),
            not_(l(LeafId::StatusEq("active"))),
    ])
reference_test!(not_price_lt_100, not_(l(PriceLt100)));
/*
    or_(vec![
enum ReferencePred {
        l(CategoryElectronics),
// ─────────────────────────────────────────────────────────────────────
        or_(vec![
// Batch 5 — cross-column combinations. Exercise multiple parquet predicate
        }
            LeafId::BrandApple => BRANDS[row] == "apple",
        or_(vec![
// ─────────────────────────────────────────────────────────────────────
// the reference_evaluator doesn't care about the equivalence, it just checks that the
///   ),
            l(BrandAmazon),
            ]),
///
    }
    T::And(xs)
/// predicates, AND/OR/NOT combined, three levels deep:
///   brand == "apple" AND price > 80
    mixed_and_of_or_branches,
// types and column orderings; verify DFS leaf ordering is stable across
        assert_ne!(r.0, "amazon");
        and_(vec![l(BrandApple), l(PriceGe150)]),
    or_(vec![l(StatusArchived), l(PriceLt50)])
                offset: 10,
    fn as_bool_node(self) -> BoolNode {
            LeafId::PriceLt100 => PRICES[row] < 100,
        use datafusion::physical_expr::PhysicalExpr;
// Whole result should be empty regardless of the other branch.
        or_(vec![l(CategoryElectronics), l(CategoryBooks)]),
        not_(l(PriceLt50)),
    expected_sorted.sort();
    and_collector_and_predicate,
        l(LeafId::StatusEq("active")),
    let rows = run_tree(tree).await;
        l(CategoryElectronics),
);
}
// brand=apple OR (price < 40 OR status=archived)
        l(LeafId::PriceGt(40)),
    stress_all_leaves_in_tree,
);
    or_of_a_and_not_a,
impl LeafId {
    BrandApple,     // provider_id = 1
    and_collector_with_many_predicate_siblings,
// ─────────────────────────────────────────────────────────────────────
            index_leaf(0), // brand=amazon
    and_(vec![
            l(BrandApple),
        if let Some(rp) = self.as_reference_predicate() {
        l(PriceGe150),
        and_(vec![l(BrandAmazon), l(StatusArchived)]),
);
            l(PriceGt100),
// apple OR price IN (40, 300) — IN standalone under OR.
    and_(vec![
        or_(vec![l(BrandAmazon), l(BrandApple)])
            and_(vec![
            and_(vec![l(BrandAmazon), l(PriceGt100)]),
    not_(or_(vec![
);
);
// apple AND NOT (price IN (95, 200))
fn and_(xs: Vec<T>) -> T {
    let tree = BoolNode::And(vec![
// ── Stress shapes ────────────────────────────────────────────────────
    }
// Phase 1/2 pipeline. `assert_engine_matches_reference` runs both and compares.
// OR coverage — chained ORs, both-narrow ORs, Collector OR predicate.
// Empty-like collector scope: brand=amazon AND category=books AND price<50
/// A "primitive" leaf in our test trees, mapped both to a `BoolNode` the
    // Parameterized comparison leaves — cover arbitrary thresholds.
            "[{}] engine returned row not in fixture: ({}, {}, {}, {})",
// Cross-operator combos — union of different tree shapes.
    ])
        l(LeafId::PriceEq(95)),
reference_test!(
reference_test!(
        }),
// Short aliases used by all reference_evaluator tests.
    ])
    assert_eq!(got, exp, "complex tree result mismatch");
// Single-row targeting: price = 150 AND category = books → row 11.
//! fan-out, stress shapes. Built around an reference_evaluator that evaluates trees
        let is_amazon = BRANDS[i] == "amazon";
    wide_or_5_children,
            LeafId::PricePlusGt { offset, threshold } => {
    not_(or_(vec![l(LeafId::PriceEq(50)), l(LeafId::PriceEq(95))]))
    absorption_and,
    StatusEq(&'static str),
);
            }
    not_collector_inside_or_siblings,
/// tree evaluator should handle this correctly.
    or_(vec![
reference_test!(
            l(PriceLt50),
// (PruningPredicate expands this into a union of three stats checks).
// Tree that has an always-empty subtree AND'd with a large universe.
                threshold: 200
);
reference_test!(
///     — but we fake "status == active" as: NOT(status == "archived")
        l(StatusArchived),
// price > 100 OR (price + 10) < 50  — OR with arithmetic branch.
        l(BrandApple),
// NOT around a Collector-only AND → exact inversion taken.
    let mut expected_sorted = expected.clone();
    and_(vec![
// price > 200 OR status = "nope" — both branches narrow/empty.
    out
    let rows = run_tree(tree).await;
// ─────────────────────────────────────────────────────────────────────
);
        l(LeafId::PriceEq(200)),
reference_test!(
            LeafId::PriceIn(list) => list.contains(&PRICES[row]),
        and_(vec![l(CategoryBooks), l(PriceGe150)]),
    not_(and_(vec![l(BrandApple), l(PriceLt100)]))
);
    and_(vec![l(BrandAmazon), l(StatusArchived)])
        l(BrandApple),
        // Simple comparison leaves via ReferencePred.
            LeafId::StatusArchived => 2,
);
// Cases where one branch of AND/OR collapses the result to empty or universe.
// NOT around a mixed AND (has Predicate) → universe-fallback exercised.
// 5-level deep: OR(AND(NOT(OR(A,B)), NOT(C)), AND(D, E)).
        and_(vec![l(StatusArchived), l(CategoryBooks)]),
    and_partial_overlap_collectors,
        let price: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new("price", price_idx));
        ]),
/// Reference-evaluator's view of a Predicate — plain data for direct
// apple AND price IN (50, 95, 200)
            ("apple".into(), 95),
}
);
/// ```
reference_test!(
        and_(vec![l(BrandAmazon), l(PriceLt100)]),
reference_test!(
///     brand == "amazon",
);
/// OR branch with predicate hanging off one side:
    chained_same_col_or,
reference_test!(
///   category == "electronics"
    and_(vec![l(PriceGt100), l(CategoryElectronics)])
    or_(vec![
        T::Not(inner) => BoolNode::Not(Box::new(to_engine_tree(inner))),
reference_test!(
    }))
                ]),
    or_(vec![l(LeafId::PriceGt(200)), l(LeafId::StatusEq("nope"))])
    assoc_and_left,
);
        l(LeafId::PriceEq(50)),
// ──────────────────────────────────────────────────────────────────────
/// Sanity: pure-NOT around a single collector (no other filters) returns
        not_(or_(vec![
    not_(or_(vec![
);
            l(CategoryBooks),
        ("amazon".into(), 150),
reference_test!(
reference_test!(
            ]),
    ])
    // All rows NOT (amazon AND archived):
        and_(vec![l(BrandAmazon), l(LeafId::PriceGt(100))]),
        if (is_amazon || is_apple_cheap) && not_archived && electronics {
// ──────────────────────────────────────────────────────────────────────
 *
// Batch 3 — identity and bound edges.
            brand,
// brand = apple OR price IN (30, 40, 300) — Collector OR'd with IN.
    Or(Vec<T>),
                        let l: Arc<dyn PhysicalExpr> =
    in_list_or_with_collector,
        l(BrandApple),
//   apple AND (price > 150 OR NOT status = "active")
            LeafId::PriceGt100 => PRICES[row] > 100,
);
/// AND(
    assert_eq!(got, vec![40, 50, 55, 60, 70, 90, 99, 120]);
        and_(vec![
// Predicate that matches everything: price < 100 OR price >= 150.
enum T {
// ──────────────────────────────────────────────────────────────────────
reference_test!(
    and_(vec![
                    price, literals, &false, &schema,
/// the complement set.
            and_(vec![l(BrandAmazon), l(StatusArchived)]),
    ])
///   category == "electronics" AND NOT (status == "archived")
    commutative_and_predicate_first,
        offset: i32,
    or_(vec![
        l(LeafId::PriceGt(100)),
    alternating_nesting,
    }
// Reference evaluator-driven exhaustive tests
/// by `push_not_down`, and still produce correct results.
reference_test!(
async fn or_with_nested_and() {
            LeafId::PriceLt50 => PRICES[row] < 50,
            LeafId::PriceLt(v) => ReferencePred::Int("price", Operator::Lt, v),
        // Collector leaves first.
    not_(and_(vec![l(BrandAmazon), l(StatusArchived)]))
    let mut got: Vec<(String, i32)> = rows.iter().map(|r| (r.0.clone(), r.1)).collect();
    deep_not_over_compound,
        ]),
    let expected: Vec<usize> = (0..16).filter(|&r| reference_evaluator(&tree, r)).collect();
// apple AND (price IN (60, 200) OR (price + 10) > 200) — mixed.
// ══════════════════════════════════════════════════════════════════════
// brand=amazon OR price > 190 — Collector OR'd with predicate.
// Full subtree means result == universe.
                && PRICES[r] == *price
// Test cases
    or_(vec![l(BrandApple), l(LeafId::PriceIn(&[30, 40, 300]))])
// brand=apple AND (price > 150 OR status=archived)
    not_around_mixed_and,
reference_test!(
);
);
    not_of_and_same_col_de_morgan,
                    })
            l(LeafId::PriceGt(150)),
reference_test!(not_brand_amazon, not_(l(BrandAmazon)));
    or_(vec![
/// )
    ])
        not_(l(BrandAmazon)),
        let _ = price;
    and_(vec![
        l(LeafId::PriceLt(100)),
    let tree = BoolNode::And(vec![
// A OR (B AND C) == (A OR B) AND (A OR C)
    expected.sort();
reference_test!(leaf_brand_amazon, l(BrandAmazon));
    and_(vec![
// NOT over a wide OR of collectors (De Morgan → AND of NOTs).
    // Parquet predicate leaves — reference_evaluator applies directly.
/// the engine. Doesn't need to roundtrip — we build both from the same DSL
    not_over_mixed_tree,
/// Run `tree` through the engine and compare to the reference_evaluator over all 16 rows.
    or_(vec![
    left_skewed_or,
        BoolNode::Not(Box::new(index_leaf(2))), // NOT status=archived
);
    assert_eq!(
// Commutativity: AND(A, B) == AND(B, A). Engine's leader-follower sort by
reference_test!(
            not_(or_(vec![l(BrandAmazon), l(BrandApple)])),
    and_(vec![l(BrandAmazon), l(StatusArchived)])
        or_(vec![l(BrandAmazon), l(BrandApple)]),
reference_test!(
                let thr: Arc<dyn PhysicalExpr> =
        "[{}] engine rows {:?} != reference_evaluator rows {:?}",
            l(PriceEq150),
        T::And(children) => children.iter().all(|c| reference_evaluator(c, row)),
}
// Simple NOT of a leaf — exercises push_not_down for each leaf type.
/// Also exercise De Morgan's: NOT(AND(a,b)) must get rewritten to OR(NOT(a),NOT(b))
    or_(vec![l(BrandAmazon), l(BrandApple)])
    not_(or_(vec![l(BrandAmazon), l(BrandApple), l(StatusArchived)]))
        BoolNode::And(vec![index_leaf(1), pred_int("price", Operator::Lt, 100)]),
    /// Structured description of a Predicate leaf, used only by the
    single_row_match,
        not_(l(StatusArchived)),
    let bool_tree = to_engine_tree(&tree);
);
                index_leaf(1),                        // brand=apple
    prices.sort();
        not_(l(BrandApple)),
        let is_apple_cheap = BRANDS[i] == "apple" && PRICES[i] < 100;
reference_test!(
        // Note: PricePlusGt { offset, threshold } means price+offset > threshold.
// NOT over a mixed tree — OR of (AND with Collector) and IN-list.
// brand=apple AND (price > 100 OR status=archived) — multi-column OR,
    PriceGt100,
reference_test!(
        ]),
///     AND(brand == "apple", price < 100)
reference_test!(
        T::Leaf(l) => l.matches(row),
    ])
    ]))
reference_test!(
    or_(vec![
// StatusEq as predicate leaf (not the backend collector).
reference_test!(
    or_of_narrow_branches,
    got.sort();
            LeafId::PriceGt(v) => ReferencePred::Int("price", Operator::Gt, v),
            BoolNode::And(vec![
    de_morgan_not_or_two_collectors,
        l(BrandApple),
        and_(vec![l(BrandApple), l(LeafId::PriceGt(150))]),
    T::Or(xs)
// OR of Collector + predicate, OR of AND-branches. All via the reference
    wide_and_5_children,
        or_(vec![l(BrandAmazon), l(BrandApple)]),
    ])
        and_(vec![l(BrandApple), l(StatusArchived)]),
);
    commutative_and_ab,
reference_test!(
        got,
        l(PriceGt100),
    PriceEq150,
        ]),
async fn assert_engine_matches_reference(name: &str, tree: T) {
);
    nested_4_levels_a,
    and_(vec![l(BrandApple), l(PriceLt100)])
            l(StatusArchived),
//   - the `try_negate_cmp_expr` op-flip fast-path for simple comparisons;
reference_test!(
        l(PriceEq150),
    And(Vec<T>),
);
 */
/// Collector used twice in the tree (same provider_id). Each occurrence
    StatusArchived, // provider_id = 2
// care which one the tree was built as.
);
    actual.sort();
    assert_eq!(got, expected);
                l(CategoryBooks),
// mixing columns.
        and_(vec![l(BrandAmazon), l(StatusArchived)]),
);
///   brand != "amazon" OR status != "archived"
);
    and_(vec![
    );
    and_(vec![l(StatusArchived), l(BrandAmazon)])
        not_(l(BrandApple)),
                .unwrap();
    not_(and_(vec![l(BrandAmazon), l(StatusArchived)]))
// 3-way AND: price > 40 AND price < 100 AND category = electronics.
    ])
/// each time.
    ]))
                )
        }
reference_test!(
    fn matches(self, row: usize) -> bool {
/// A compact tree representation for the reference_evaluator; mirrored to `BoolNode` for
        match self {
        l(CategoryElectronics),
    ]);
reference_test!(leaf_category_electronics, l(CategoryElectronics));
    let mut exp = expected;
    ])
    three_way_and_mixed_new_operators,
    };
            offset: 10,
/// gets its own MockCollector instance (they're built in DFS order). The
reference_test!(
    or_(vec![
reference_test!(
        ("amazon".into(), 50),
// Wide OR fan-out (5 children).
reference_test!(
    or_collector_or_predicate,
        and_(vec![l(CategoryElectronics), l(PriceGt100)]),
    ])
    let rows = run_tree(tree).await;
    got.sort();
            ("apple".into(), 200),
    and_(vec![
            ]),
// NOT(price > 100)  ≡  price <= 100  — fast-path op-flip.
        }
            LeafId::CategoryBooks => CATEGORIES[row] == "books",
        ])),
    and_(vec![
            LeafId::PriceIn(list) => {
reference_test!(
reference_test!(
    PriceLt50,
// ──────────────────────────────────────────────────────────────────────
    multi_column_and,
// puts Predicates first, then Collectors).
        not_(l(BrandAmazon)),
// AND with contradictory branch: (brand=apple) AND (NOT(category=electronics) AND category=books)
    mixed_or_of_and_branches,
/// Matchers the reference_evaluator uses.
    or_(vec![l(BrandAmazon), l(LeafId::PriceGt(190))])
reference_test!(
// Disjoint AND paths joined by OR — no collector overlap between branches.
            }
            LeafId::StatusEq(v) => STATUSES[row] == v,
    or_with_arithmetic_branch,
        l(BrandAmazon),
        }),
    ])
);
    }
        l(BrandAmazon),
    not_of_or_same_col_de_morgan,
        offset: 10,
        l(PriceEq150),
        match self {
}
fn or_(xs: Vec<T>) -> T {
                let off: Arc<dyn PhysicalExpr> =
        l(CategoryElectronics),
            threshold: 100
    let mut expected: Vec<(String, i32)> = vec![
    ])
//
    and_(vec![
    // amazon rows: 0,1,2,3,12 (5)
/// comparison against fixture rows, no PhysicalExpr machinery.
    or_non_overlapping_collectors,
        and_(vec![l(BrandAmazon), l(LeafId::PriceIn(&[30, 50]))]),
                not_(l(BrandApple)),
            or_(vec![l(BrandApple), l(CategoryBooks)]),
            l(LeafId::PriceGt(150)),
/// Reference evaluator: row-by-row boolean evaluation.
    or_of_predicates_covering_universe,
// Absorption: A AND (A OR B) == A ; A OR (A AND B) == A
            not_(l(StatusArchived)),
    match tree {
        and_(vec![l(BrandAmazon), l(PriceLt100)]),
            LeafId::CategoryElectronics => {
);
//   NOT((apple AND price > 150) OR price IN (30, 50))
        pred_str("category", Operator::Eq, "electronics"), // category=electronics
    or_of_and_branches_with_multi_column_filters,
    PriceGt(i32),
        BoolNode::Not(Box::new(index_leaf(2))),
reference_test!(or_two_collectors, or_(vec![l(BrandAmazon), l(BrandApple)]));
    and_with_subtree_selecting_subset,
reference_test!(commutative_or_ba, or_(vec![l(BrandApple), l(BrandAmazon)]));
            LeafId::CategoryElectronics => CATEGORIES[row] == "electronics",
        not_(l(PriceGe150)),
    mixed_in_list_and_arithmetic_under_collector,
    and_(vec![
        l(BrandAmazon),
// Every primitive leaf appearing at least once.
    ])
    ])
// ──────────────────────────────────────────────────────────────────────
// ──────────────────────────────────────────────────────────────────────
///   NOT(status == "archived"),
// NOT(NOT(price > 100))  ≡  price > 100  — double negation cancels.
                let in_expr = datafusion::physical_expr::expressions::in_list(
        or_(vec![
// ══════════════════════════════════════════════════════════════════
        l(StatusArchived),
reference_test!(double_not_predicate, not_(not_(l(CategoryElectronics))));
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
            l(PriceGe150),
    match tree {
    }
//   (apple AND price > 100) OR (amazon AND price IN (30, 50))
        index_leaf(0), // amazon
reference_test!(
// Primitive leaves identified by a stable `LeafId`. The reference_evaluator evaluates the
reference_test!(not_category_books, not_(l(CategoryBooks)));
        not_(l(StatusArchived)),
// AND coverage — multi-way AND across columns, mixed operator shapes.
        }
            };
                l(LeafId::StatusEq("archived"))
        l(BrandApple),
///
            _ => unreachable!("handled above"),
                && CATEGORIES[r] == cat.as_str()
reference_test!(or_two_predicates, or_(vec![l(PriceLt50), l(PriceGe150)]));
        let electronics = CATEGORIES[i] == "electronics";
);
reference_test!(not_of_status_eq, not_(l(LeafId::StatusEq("archived"))));
reference_test!(
        l(LeafId::PriceIn(&[50, 90, 200])),
        or_(vec![
// NOT(A AND B) == NOT(A) OR NOT(B)
// cost must not change the result set.
        l(BrandApple),
// 4-level deep: AND(NOT(OR(AND(A,B),C)), D).
// ──────────────────────────────────────────────────────────────────────
}
        not_(and_(vec![l(PriceGe150), l(CategoryBooks)])),
        index_leaf(2), // archived
        l(StatusArchived),
            ]),
                not_(l(StatusArchived)),
        index_leaf(0),
    not_or_of_nots_equivalent_to_and,
#[derive(Debug, Clone)]
        let not_archived = STATUSES[i] != "archived";
    not_(or_(vec![l(BrandAmazon), l(BrandApple)]))
        ("apple".into(), 90),
            _ => return None,
// Deep NOT-OR-NOT-AND sandwich exercising push_not_down.
            name,
);
);
    got.sort();
///   NOT(brand == "amazon" AND status == "archived")
    and_(vec![
        and_(vec![l(PriceLt100), l(CategoryElectronics)]),
        l(CategoryElectronics),
        ]),
        ]),
    ])
// Double negation: NOT(NOT A) == A
            LeafId::PriceEq150 => ReferencePred::Int("price", Operator::Eq, 150),
            l(LeafId::StatusEq("archived"))
            BRANDS[r] == brand.as_str()
/// NOT around a collector:
            not_(l(BrandAmazon)),
    /// `price + offset > threshold`.
                ReferencePred::Str("category", Operator::Eq, "electronics")
macro_rules! reference_test {
        l(CategoryElectronics),
async fn not_and_de_morgan() {
            ]),
                    Arc::new(BinaryExpr::new(price, Operator::Plus, off));
    commutative_and_ba,
reference_test!(leaf_price_eq_150, l(PriceEq150));
}
// Triple-level alternation: AND(OR(AND, OR), NOT).
);
);
// apple AND (price + 10) > 100 — arithmetic the old converter rejected.
// ─────────────────────────────────────────────────────────────────────
        async fn $name() {
        not_(l(StatusArchived)),
        );
    let expected = expected_for_complex_tree();
reference_test!(
reference_test!(
// NOT(price > 40 AND price < 100)  ≡  price <= 40 OR price >= 100.
        });
    /// reference evaluator (separate from engine-tree lowering). Engine
    and_(vec![l(BrandAmazon), l(StatusArchived)])
            offset: 10,
    ];
    stress_mixed_6_levels,
);
                BoolNode::Predicate(in_expr)
    ])
);
        l(PriceLt50),
}
    and_(vec![l(BrandAmazon), l(CategoryBooks), l(PriceLt50)])
    and_(vec![
    // total 9 distinct rows
// Batch 4 — deep nesting and wide fan-out.
fn not_(x: T) -> T {
// OR-heavy trees — OR inside AND with predicates on different columns,
        // Richer operators built directly as PhysicalExpr.
reference_test!(
    }
// Collector + predicate + collector + predicate alternation.
// cheaply.
reference_test!(
    ])
);
/// engine understands and to a row-level predicate the reference_evaluator uses.
// Batch 2 — Boolean algebra laws. Each case states a known equivalence;
// NOT(price IN (50, 95)) — non-invertible leaf; goes through NotExpr wrapper
}
        and_(vec![
use LeafId::*;
        l(CategoryBooks),
    ])
            LeafId::PricePlusGt { offset, threshold } => PRICES[row] + offset > threshold,
    CategoryBooks,
                && STATUSES[r] == status.as_str()
reference_test!(leaf_price_gt_100, l(PriceGt100));
            };
        or_(vec![
        or_(vec![
    let mut got: Vec<i32> = rows.iter().map(|r| r.1).collect();
reference_test!(
);
        and_(vec![l(BrandApple), l(PriceLt100)]),
);
    and_(vec![l(BrandApple), l(PriceLt100)])
    and_(vec![
);
    and_two_collectors,
#[derive(Debug, Clone, Copy)]
// ──────────────────────────────────────────────────────────────────────
    ])
// at refinement time. Reference evaluator still correct.
        l(PriceGe150),
// short-circuit when a Collector is under NOT.
async fn bare_not_returns_complement() {
        use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
reference_test!(
    de_morgan_not_or_mixed,
);
    PricePlusGt {
// tree row-by-row directly on the fixture arrays; the engine runs the full
// apple AND ((price>100 AND status=active) OR (price<50 OR status=archived))
        ]),
);
    and_(vec![
reference_test!(
        })
    collector_and_or_of_not_and_cmp,
);
// ══════════════════════════════════════════════════════════════════
    let mut got: Vec<i32> = rows.iter().map(|r| r.1).collect();
reference_test!(leaf_status_archived, l(StatusArchived));
// OR of two non-overlapping collectors.
    and_(vec![l(CategoryElectronics), not_(l(CategoryElectronics))])
        assert!(
);
// This harness lets us write a tree expression and get a correctness check
    ])));
reference_test!(
// No row has `price < 50 AND category=books` in fixture → empty.
        let schema = build_fixture_schema();
// NOT(price = 50 OR price = 95)  ≡  price != 50 AND price != 95.
/// Independent reference implementation of the complex-tree predicate.
    empty_subtree_gates_entire_and,
    got.sort();
    ])
    let rows = run_tree(tree).await;
        threshold: i32,
/// **The complex e2e tree.** Three index-backed collectors, two parquet
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
///
        l(PriceGt100),
                ReferencePred::Int(col, op, v) => pred_int(col, op, v),
);
    or_(vec![l(PriceLt100), l(PriceGe150)])
        and_(vec![l(BrandApple), l(LeafId::PriceGt(100))]),
    or_(vec![
reference_test!(
);
    or_(vec![l(PriceLt50), l(CategoryBooks), l(BrandApple)])
    not_(l(LeafId::PricePlusGt {
        l(LeafId::PricePlusGt {
    collector_and_in_and_not_in,
            l(LeafId::PriceLt(70)),
// (apple AND price<70 AND status=active) OR (amazon AND price>=100)
        l(BrandApple),
        or_(vec![l(BrandAmazon), l(BrandApple)]),
reference_test!(not_of_gt_flips_to_lte, not_(l(LeafId::PriceGt(100))));
// AND of A and NOT A: empty.
            LeafId::BrandAmazon => BRANDS[row] == "amazon",
// one). Reference walks STATUSES row-by-row.
reference_test!(double_not_collector, not_(not_(l(BrandApple))));
reference_test!(
reference_test!(
        ]),
// price > 40 AND (price < 60 OR price > 190)  — same-column OR.
    distributive_or_over_and,
// Tree with always-full subtree OR'd with a narrow branch.
            and_(vec![l(LeafId::PriceGt(100)), l(LeafId::StatusEq("active"))]),
// occurrence separately; collector_idx wiring gives them different
    and_two_predicates,
    let mut got: Vec<(String, i32)> = rows.iter().map(|r| (r.0.clone(), r.1)).collect();
reference_test!(
        and_(vec![l(BrandAmazon), l(PriceLt100)]),
        or_(vec![
            return match rp {
    wide_or_6_children,
// Pairs via AND / OR — smallest compound shapes.
            LeafId::PriceEq(v) => ReferencePred::Int("price", Operator::Eq, v),
    ])
            LeafId::PriceLt100 => ReferencePred::Int("price", Operator::Lt, 100),
);
    for r in &rows {
reference_test!(
    Str(&'static str, Operator, &'static str),
    // index-backed collector leaves (provider_id 0/1/2 per `wire_collector_indices`)
// Partially overlapping: archived ∩ amazon.
reference_test!(
