);
/// Reference-evaluator's view of a Predicate — plain data for direct
///   category == "electronics"
                && STATUSES[r] == status.as_str()
    commutative_and_ab,
        l(BrandApple),
reference_test!(
            LeafId::StatusEq(v) => ReferencePred::Str("status", Operator::Eq, v),
        l(StatusArchived),
            }
    ]);
reference_test!(
    got.sort();
            and_(vec![l(BrandAmazon), l(PriceGt100)]),
        ]),
);
        l(LeafId::PriceEq(200)),
// Batch 1 — single leaves + basic combinators.
    not_(or_(vec![
            LeafId::PriceGt100 => PRICES[row] > 100,
// Every primitive leaf appearing at least once.
reference_test!(
async fn bare_not_returns_complement() {
    and_(vec![
    ])
                    })
    T::And(xs)
    not_or_of_nots_equivalent_to_and,
    assert_eq!(
            }),
            offset: 10,
    mixed_and_of_or_branches,
                let in_expr = datafusion::physical_expr::expressions::in_list(
    ]))
        }
reference_test!(
        }
/// **The complex e2e tree.** Three index-backed collectors, two parquet
    and_(vec![l(PriceLt50), l(PriceGt100)])
    and_(vec![l(BrandApple), l(PriceLt100)])
    and_(vec![
    or_collector_with_nested_multi_column_or,
    and_(vec![l(PriceLt100), l(BrandApple)])
reference_test!(
    or_(vec![
    /// `price + offset > threshold`.
            LeafId::CategoryElectronics => {
// ══════════════════════════════════════════════════════════════════════
        and_(vec![l(BrandAmazon), l(StatusArchived)]),
    assoc_or_left,
///     — but we fake "status == active" as: NOT(status == "archived")
        ]),
);
        l(CategoryElectronics),
    and_(vec![l(BrandAmazon), l(StatusArchived)])
/// each time.
        let schema = build_fixture_schema();
        ]),
    and_partial_overlap_collectors,
    not_around_mixed_and,
    not_(and_(vec![l(BrandAmazon), l(PriceLt100)]))
                let literals: Vec<Arc<dyn PhysicalExpr>> = list
            };
    ])
);
        l(CategoryElectronics),
            _ => return None,
    ])
    let mut got: Vec<(String, i32)> = rows.iter().map(|r| (r.0.clone(), r.1)).collect();
// brand=amazon OR price > 190 — Collector OR'd with predicate.
// Simple NOT of a leaf — exercises push_not_down for each leaf type.
reference_test!(leaf_status_archived, l(StatusArchived));
);
    or_(vec![
// ─────────────────────────────────────────────────────────────────────
            l(LeafId::PriceIn(&[60, 200])),
);
reference_test!(
            }
// Partially overlapping: archived ∩ amazon.
);
        ]),
    three_way_and_mixed_new_operators,
    fn as_bool_node(self) -> BoolNode {
/// NOT around a collector:
// AND of two non-overlapping collectors → empty.
            BoolNode::And(vec![
            not_(l(BrandAmazon)),
        l(BrandAmazon),
// ──────────────────────────────────────────────────────────────────────
        ("apple".into(), 95),
        threshold: 100
        ]),
impl LeafId {
                l(LeafId::PriceLt(50)),
/// Simple sanity: single collector + single predicate AND'd.
///   (brand == "amazon") AND (status == "active")
        offset: 10,
);
    or_(vec![l(BrandApple), l(LeafId::PriceIn(&[30, 40, 300]))])
        let electronics = CATEGORIES[i] == "electronics";
            offset: 10,
);
        l(StatusArchived)
        l(LeafId::PriceGt(40)),
// ══════════════════════════════════════════════════════════════════════
            LeafId::BrandApple => 1,
    and_(vec![
        not_(l(StatusArchived)),
    expected_sorted.sort();
    let mut prices: Vec<i32> = rows.iter().map(|r| r.1).collect();
/// gets its own MockCollector instance (they're built in DFS order). The
        and_(vec![l(BrandAmazon), l(LeafId::PriceGt(100))]),
    ])
);
// Pairs via AND / OR — smallest compound shapes.
    // Tree: AND(apple, price > 80)
//
        assert!(
    let mut got: Vec<i32> = rows.iter().map(|r| r.1).collect();
            LeafId::PriceLt100 => PRICES[row] < 100,
reference_test!(double_not_predicate, not_(not_(l(CategoryElectronics))));
reference_test!(
    let mut expected: Vec<(String, i32)> = vec![
        l(LeafId::PriceEq(50)),
            BRANDS[r] == brand.as_str()
        l(CategoryElectronics),
);
        l(CategoryElectronics),
        ]),
        T::And(children) => BoolNode::And(children.iter().map(to_engine_tree).collect()),
        l(LeafId::PriceIn(&[50, 90, 200])),
    ])
// AND of A and NOT A: empty.
        }),
    or_(vec![
        T::Not(inner) => !reference_evaluator(inner, row),
// NOT(NOT(price > 100))  ≡  price > 100  — double negation cancels.
);
);
        T::Leaf(l) => l.matches(row),
    or_(vec![l(BrandAmazon), not_(l(BrandApple))])
        vec![
// This harness lets us write a tree expression and get a correctness check
// at refinement time. Reference evaluator still correct.
            l(BrandAmazon),
        l(BrandApple),
    // 16 docs, 5 are amazon → 11 expected.
// framework so expected rows are computed row-by-row, not hand-crafted.
reference_test!(
    T::Or(xs)
// 5-level deep: OR(AND(NOT(OR(A,B)), NOT(C)), AND(D, E)).
        let _ = price;
        not_(or_(vec![
);
            name,
            l(LeafId::PricePlusGt {
// Richer operators — DataFusion PhysicalExpr refinement handles these
);
    and_(vec![
reference_test!(
/*
    or_(vec![
    assert_eq!(
                    price, literals, &false, &schema,
}
                or_(vec![l(PriceLt50), l(BrandAmazon)]),
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    ]))
// 4-level deep: AND(NOT(OR(AND(A,B),C)), D).
            and_(vec![
        l(BrandApple),
            LeafId::PriceEq(v) => PRICES[row] == v,
            ]),
);
 */
);
    empty_subtree_gates_entire_and,
        "[{}] engine rows {:?} != reference_evaluator rows {:?}",
    not_(or_(vec![l(BrandAmazon), l(BrandApple), l(StatusArchived)]))
// ══════════════════════════════════════════════════════════════════
enum T {
    assoc_and_left,
// ──────────────────────────────────────────────────────────────────────
                        l
            and_(vec![l(LeafId::PriceGt(100)), l(LeafId::StatusEq("active"))]),
        ("amazon".into(), 50),
reference_test!(
///   brand == "amazon" OR (brand == "apple" AND price < 100)
// ─────────────────────────────────────────────────────────────────────
reference_test!(
    fn as_reference_predicate(self) -> Option<ReferencePred> {
                and_(vec![not_(l(StatusArchived)), not_(l(PriceGe150))]),
    ])
reference_test!(
    or_collector_or_predicate,
    ])
            LeafId::BrandApple => BRANDS[row] == "apple",
        })
}
    StatusEq(&'static str),
    ])
            LeafId::PriceIn(list) => {
            and_(vec![
    let rows = run_tree(tree).await;
);
    /// reference evaluator (separate from engine-tree lowering). Engine
    ])
                    l(BrandApple),
    // Parameterized comparison leaves — cover arbitrary thresholds.
    exp.sort();
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        T::Leaf(l) => l.as_bool_node(),
    ])
reference_test!(
        and_(vec![l(BrandApple), l(LeafId::PriceGt(150))]),
    Leaf(LeafId),
        and_(vec![l(BrandAmazon), not_(l(PriceLt100))]),
reference_test!(
#[derive(Debug, Clone)]
    Str(&'static str, Operator, &'static str),
reference_test!(
    fn matches(self, row: usize) -> bool {
    not_around_collectors_only_and,
enum LeafId {
reference_test!(
    collector_or_in_list,
async fn complex_tree_3_levels_3_collectors_2_predicates() {
reference_test!(
    };
// apple OR price IN (40, 300) — IN standalone under OR.
    assert_eq!(rows.len(), 14);
// Combined range covers all prices in fixture (30..300).
            ("apple".into(), 95),
    }
reference_test!(not_category_books, not_(l(CategoryBooks)));
reference_test!(leaf_category_electronics, l(CategoryElectronics));
    not_(and_(vec![l(LeafId::PriceGt(40)), l(LeafId::PriceLt(100))]))
    let mut got: Vec<i32> = rows.iter().map(|r| r.1).collect();
// Deep NOT-OR-NOT-AND sandwich exercising push_not_down.
// brand=apple AND (price > 150 OR status=archived)
    );
// ─────────────────────────────────────────────────────────────────────
// Each test is named for its shape; reference_evaluator catches mismatches.
        let found = (0..16).find(|&r| {
        and_(vec![l(BrandAmazon), l(PriceLt100)]),
);
        }
// Disjoint AND paths joined by OR — no collector overlap between branches.
        l(LeafId::PricePlusGt {
        ("apple".into(), 45),
//   - the NotExpr wrapper fallback for non-invertible shapes (IN,
reference_test!(leaf_price_gt_100, l(PriceGt100));
    wide_or_5_children,
);
    for r in &rows {
        l(StatusArchived),
);
}
// ──────────────────────────────────────────────────────────────────────
        and_(vec![l(BrandAmazon), l(LeafId::PriceIn(&[30, 50]))]),
    },
            l(CategoryBooks),
    let mut got: Vec<(String, i32)> = rows.iter().map(|r| (r.0.clone(), r.1)).collect();
// Batch 3 — identity and bound edges.
    ])
    assoc_and_right,
// NOT over a mixed tree — OR of (AND with Collector) and IN-list.
    and_(vec![
);
);
// Tree that has an always-empty subtree AND'd with a large universe.
    and_(vec![
    ])
}
    not_over_wide_or_of_collectors,
);
);
reference_test!(leaf_price_lt_100, l(PriceLt100));
        not_(l(BrandAmazon)),
    or_with_arithmetic_branch,
// Pathological: deeply right-skewed AND tree (5 levels right-leaning).
//! associativity, double-negation, bound edges, deep nesting, wide
        ]),
    and_(vec![l(CategoryElectronics), not_(l(CategoryElectronics))])
);
// Collector AND (NOT string-predicate OR comparison).
        or_(vec![
//   - De Morgan push-down through AND/OR (in BoolNode::push_not_down);
    not_(and_(vec![l(BrandAmazon), l(StatusArchived)]))
                            Arc::new(Literal::new(ScalarValue::Int32(Some(*v))));
reference_test!(
    for i in 0..16 {
            LeafId::PricePlusGt { offset, threshold } => PRICES[row] + offset > threshold,
        index_leaf(2), // archived
        and_(vec![l(CategoryElectronics), l(PriceGt100)]),
    or_of_narrow_branches,
// Batch 2 — Boolean algebra laws. Each case states a known equivalence;
reference_test!(
/// by `push_not_down`, and still produce correct results.
reference_test!(
                let off: Arc<dyn PhysicalExpr> =
// Primitive leaves identified by a stable `LeafId`. The reference_evaluator evaluates the
            ]),
    and_(vec![
        l(PriceGe150),
        // Collector leaves first.
// Batch 6 — commutativity, cost-order stability, stress shapes.
// ──────────────────────────────────────────────────────────────────────
        }),
// puts Predicates first, then Collectors).
        got,
reference_test!(leaf_brand_amazon, l(BrandAmazon));
        not_(l(BrandAmazon)),
}
    and_(vec![l(BrandAmazon), l(BrandApple)])
// brand=apple OR (price < 40 OR status=archived)
                && !actual.contains(&r)
            LeafId::CategoryBooks => CATEGORIES[row] == "books",
    let expected = expected_for_complex_tree();
        if let Some(rp) = self.as_reference_predicate() {
    }
        or_(vec![l(LeafId::PriceLt(60)), l(LeafId::PriceGt(190))]),
use super::*;
    // Expected: apple rows with price > 80: rows 4,5,6 → prices 90,95,200
        and_(vec![l(BrandAmazon), l(PriceLt100)]),
);
 * SPDX-License-Identifier: Apache-2.0
    and_(vec![l(BrandAmazon), l(StatusArchived)])
        l(PriceEq150),
    distributive_or_over_and,
        or_(vec![
        l(CategoryBooks),
reference_test!(
    and_(vec![
    ])
    PriceLt100,
// Idempotence: A AND A == A ; A OR A == A
                    Arc::new(BinaryExpr::new(price, Operator::Plus, off));
);
                not_(l(StatusArchived)),
    ($name:ident, $tree:expr) => {
    or_(vec![
reference_test!(
 * this file be licensed under the Apache-2.0 license or a
);
    PriceIn(&'static [i32]),
// types and column orderings; verify DFS leaf ordering is stable across
reference_test!(
    and_(vec![
// Same set in different child orders must give identical results.
// Every test is self-verifying via reference_test!.
    and_(vec![l(BrandAmazon), l(CategoryBooks), l(PriceLt50)])
    and_of_contradictory_predicates,
            LeafId::PriceIn(list) => list.contains(&PRICES[row]),
reference_test!(commutative_or_ab, or_(vec![l(BrandAmazon), l(BrandApple)]));
            ("apple".into(), 200),
    stress_mixed_6_levels,
// De Morgan's laws.
// AND of three new-operator types: IN, arithmetic, status predicate.
///     equiv
// Chain of NOTs + ANDs.
            LeafId::CategoryElectronics => CATEGORIES[row] == "electronics",
    and_(vec![
/// predicates, AND/OR/NOT combined, three levels deep:
        }
// OR of two AND-branches, each mixing Collector + different predicate shapes.
        ]),
//! Boolean-algebra correctness on a 16-row hand-authored fixture:
    let tree = BoolNode::And(vec![
    de_morgan_not_and_two_collectors,
        l(BrandApple),
);
    or_of_a_and_not_a,
                threshold: 200
            or_(vec![
    or_of_predicates_covering_universe,
    ])
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
#[derive(Debug, Clone, Copy)]
reference_test!(
    or_non_overlapping_collectors,
    PriceGt100,
    ])
    or_(vec![l(StatusArchived), l(PriceLt50)])
        not_(l(StatusArchived)),
/// Also exercise De Morgan's: NOT(AND(a,b)) must get rewritten to OR(NOT(a),NOT(b))
    // Richer operators — exercise expressions our old converter rejected.
    ])));
    for (_, price, _, _) in &rows {
// OR coverage — chained ORs, both-narrow ORs, Collector OR predicate.
    ])
// AND coverage — multi-way AND across columns, mixed operator shapes.
        or_(vec![
/// Reference evaluator: row-by-row boolean evaluation.
            threshold: 100
// ──────────────────────────────────────────────────────────────────────
// ─────────────────────────────────────────────────────────────────────
        or_(vec![
reference_test!(
    /// `BoolNode::Predicate(PhysicalExpr)` directly.
// AND with contradictory branch: (brand=apple) AND (NOT(category=electronics) AND category=books)
        l(PriceLt100),
    // Parquet predicate leaves — reference_evaluator applies directly.
reference_test!(
reference_test!(not_not_cancels, not_(not_(l(LeafId::PriceGt(100)))));
    Or(Vec<T>),
        l(PriceGt100),
/// the complement set.
// ─────────────────────────────────────────────────────────────────────
        l(BrandAmazon),
            assert_engine_matches_reference(stringify!($name), $tree).await;
                BoolNode::Predicate(in_expr)
    alternating_collectors_and_predicates,
// NOT(status = "archived") — NOT over string predicate (not the Collector
    and_(vec![
        ]),
);
    //   all other 14 rows pass
/// OR branch with predicate hanging off one side:
// apple AND NOT (price IN (95, 200))
                pred_int("price", Operator::Lt, 100), // price < 100
    absorption_and,
        ("amazon".into(), 80),
}
// NOT(A AND B) == NOT(A) OR NOT(B)
// price > 40 AND (price < 60 OR price > 190)  — same-column OR.
        BoolNode::Not(Box::new(index_leaf(2))),
fn or_(xs: Vec<T>) -> T {
    ];
    or_(vec![l(CategoryElectronics), not_(l(CategoryElectronics))])
reference_test!(
        }),
// Triple-level alternation: AND(OR(AND, OR), NOT).
}
    and_collector_with_many_predicate_siblings,
        // Simple comparison leaves via ReferencePred.
reference_test!(
    and_two_collectors,
// tree row-by-row directly on the fixture arrays; the engine runs the full
reference_test!(
reference_test!(not_of_status_eq, not_(l(LeafId::StatusEq("archived"))));
        or_(vec![
);
    and_of_a_and_not_a,
// Wide OR fan-out (5 children).
    match tree {
    ])
reference_test!(leaf_brand_apple, l(BrandApple));
    ])
            }
reference_test!(
            offset: 10,
async fn or_with_nested_and() {
            LeafId::CategoryBooks => ReferencePred::Str("category", Operator::Eq, "books"),
// apple AND (price IN (60, 200) OR (price + 10) > 200) — mixed.
            LeafId::PriceLt(v) => ReferencePred::Int("price", Operator::Lt, v),
        l(BrandApple),
        or_(vec![
    //   amazon AND archived: rows 1,12 → exclude these
reference_test!(
    And(Vec<T>),
        l(BrandApple),
);
    and_(vec![l(PriceLt50), l(CategoryBooks)])
    let tree = BoolNode::And(vec![
// Short aliases used by all reference_evaluator tests.
        or_(vec![l(PriceLt100), l(PriceGe150), l(PriceEq150)]),
        l(BrandApple),
    deep_not_over_compound,
fn not_(x: T) -> T {
reference_test!(
            l(PriceLt50),
// Full subtree means result == universe.
        l(CategoryElectronics),
//
    or_(vec![
// OR where one side is always-true selector: cat=electronics OR NOT(cat=electronics)
    not_(and_(vec![l(BrandAmazon), l(StatusArchived)]))
        l(PriceLt50),
            or_(vec![l(BrandApple), l(CategoryBooks)]),
);
    or_(vec![
            l(LeafId::PriceGt(150)),
            LeafId::PriceGt100 => ReferencePred::Int("price", Operator::Gt, 100),
// ─────────────────────────────────────────────────────────────────────
);
fn to_engine_tree(tree: &T) -> BoolNode {
        and_(vec![l(BrandApple), l(PriceGe150)]),
/// AND(
    not_(or_(vec![l(LeafId::PriceEq(50)), l(LeafId::PriceEq(95))]))
);
            l(LeafId::StatusEq("archived"))
            LeafId::PriceLt(v) => PRICES[row] < v,
        // So (price + 10) < 50 doesn't exist as a single LeafId; this is
/// Collector used twice in the tree (same provider_id). Each occurrence
reference_test!(
fn l(id: LeafId) -> T {
    }
}
reference_test!(
    let rows = run_tree(tree).await;
    de_morgan_not_or_two_collectors,
        BoolNode::Not(Box::new(index_leaf(2))), // NOT archived
        ("amazon".into(), 30),
///
        l(LeafId::PriceGt(40)),
);
#[derive(Debug, Clone, Copy)]
    and_non_overlapping_collectors,
        l(BrandApple),
async fn not_collector_with_predicate() {
                let thr: Arc<dyn PhysicalExpr> =
// ─────────────────────────────────────────────────────────────────────
                && PRICES[r] == *price
/// Matchers the reference_evaluator uses.
                    and_(vec![l(PriceLt100), l(CategoryElectronics)]),
    not_(or_(vec![l(StatusArchived), l(PriceGe150)]))
///     AND(brand == "apple", price < 100)
    let rows = run_tree(tree).await;
    // Map returned rows back to fixture row indices by matching (brand,price,status,category).
    and_(vec![
    not_(or_(vec![l(BrandAmazon), l(BrandApple)]))
reference_test!(
    ])
        or_(vec![l(BrandAmazon), l(BrandApple)]),
// NOT around a mixed AND (has Predicate) → universe-fallback exercised.
);
    let expected: Vec<usize> = (0..16).filter(|&r| reference_evaluator(&tree, r)).collect();
// Batch 4 — deep nesting and wide fan-out.
    not_(or_(vec![
);
/// Sanity: pure-NOT around a single collector (no other filters) returns
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    got.sort();
            ]),
        l(BrandAmazon),
//   - the `try_negate_cmp_expr` op-flip fast-path for simple comparisons;
reference_test!(
        async fn $name() {
    and_(vec![
// StatusEq as predicate leaf (not the backend collector).
        not_(l(StatusArchived)),
// OR of two non-overlapping collectors.
);
///   NOT(status == "archived"),
        or_(vec![
reference_test!(
reference_test!(double_not_collector, not_(not_(l(BrandApple))));
    alternating_nesting,
    let mut exp = expected;
/// ```
///   brand != "amazon" OR status != "archived"
///   NOT(brand == "amazon" AND status == "archived")
// ─────────────────────────────────────────────────────────────────────
            l(PriceLt100),
    multi_column_and,
/// comparison against fixture rows, no PhysicalExpr machinery.
reference_test!(
// occurrence separately; collector_idx wiring gives them different
);
///     brand == "amazon",
        and_(vec![l(BrandAmazon), l(CategoryBooks)]),
            LeafId::PriceLt100 => ReferencePred::Int("price", Operator::Lt, 100),
            LeafId::PriceGt(v) => ReferencePred::Int("price", Operator::Gt, v),
    arithmetic_predicate_under_collector,
            l(LeafId::PriceGt(150)),
);
    and_(vec![
// NOT over a wide OR of collectors (De Morgan → AND of NOTs).
    T::Not(Box::new(x))
    or_(vec![
    // apple AND price<100: 4 (90), 5 (95), 7 (60), 13 (45) → 4
reference_test!(
enum ReferencePred {
    BrandApple,     // provider_id = 1
        ]),
    and_(vec![l(BrandApple), not_(l(LeafId::PriceIn(&[95, 200]))),])
    PriceLt50,
    }
reference_test!(
        ("apple".into(), 60),
// Predicate that matches nothing: price < 50 AND price > 100 (vacuous).
// ─────────────────────────────────────────────────────────────────────
        // Other rows' prices may equal these too (e.g. row 11 is 150), so
reference_test!(not_of_in_list, not_(l(LeafId::PriceIn(&[50, 95]))));
reference_test!(
// ──────────────────────────────────────────────────────────────────────
    or_(vec![
reference_test!(
// price > 100 OR (price + 10) < 50  — OR with arithmetic branch.
            l(LeafId::StatusEq("archived"))
    let mut actual: Vec<usize> = Vec::with_capacity(rows.len());
);
    and_(vec![
            price,
    let bool_tree = to_engine_tree(&tree);
                BoolNode::Predicate(Arc::new(BinaryExpr::new(sum, Operator::Gt, thr)))
    ]);
reference_test!(
fn and_(xs: Vec<T>) -> T {
    and_(vec![l(BrandApple), l(LeafId::PriceIn(&[50, 95, 200]))])
    deeply_nested_and_or_with_mixed_columns,
    mixed_in_list_and_arithmetic_under_collector,
    commutative_and_collector_first,
    PricePlusGt {
        and_(vec![l(BrandAmazon), l(PriceLt100)]),
                ReferencePred::Str("category", Operator::Eq, "electronics")
    ])
            brand,
/// Independent reference implementation of the complex-tree predicate.
        and_(vec![l(PriceLt100), l(CategoryElectronics)]),
    assoc_or_right,
    // All rows NOT (amazon AND archived):
    PriceLt(i32),
    three_way_and_mixed_cols,
    empty_via_predicate_combination,
    ]);
            threshold: 50
    ])
// price > 200 OR status = "nope" — both branches narrow/empty.
            not_(l(StatusArchived)),
/// Lower `T` to `BoolNode`. `Predicate` leaves are materialized to
                offset: 10,
    not_of_and_same_col_de_morgan,
    in_list_under_collector,
        ]
    );
    nested_4_levels_a,
        not_(l(PriceGe150)),
// apple AND price IN (50, 95, 200)
async fn negated_leaf_intersected_with_positive_leaf() {
        l(StatusArchived),
// (provider,idx) pairs even though they query the same backend side.
);
    ])
                    Arc::new(Literal::new(ScalarValue::Int32(Some(offset))));
    and_(vec![
        or_(vec![
    not_(and_(vec![l(BrandApple), l(PriceLt100)]))
reference_test!(
reference_test!(
        index_leaf(0),                          // amazon
    or_(vec![
    assert_eq!(got, exp, "complex tree result mismatch");
reference_test!(
    and_(vec![l(PriceGt100), l(CategoryElectronics)])
);
/// Run `tree` through the engine and compare to the reference_evaluator over all 16 rows.
        let is_amazon = BRANDS[i] == "amazon";
        l(PriceGt100),
    or_(vec![l(PriceLt100), l(PriceGe150)])
            return match rp {
    let mut expected_sorted = expected.clone();
// ──────────────────────────────────────────────────────────────────────
    and_(vec![l(StatusArchived), l(BrandAmazon)])
        use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
// No row has `price < 50 AND category=books` in fixture → empty.
}
);
            LeafId::StatusEq(v) => STATUSES[row] == v,
        l(CategoryElectronics),
        }
// ──────────────────────────────────────────────────────────────────────
            l(PriceEq150),
        or_(vec![l(BrandAmazon), l(BrandApple)]),
fn expected_for_complex_tree() -> Vec<i32> {
reference_test!(
);
    let tree = BoolNode::And(vec![
            found.is_some(),
);
// Collector AND IN AND NOT IN — same column, both polarities.
    assert_eq!(rows.len(), 11);
        if let Some(provider_id) = self.as_collector_provider_id() {
);
// apple AND ((price>100 AND status=active) OR (price<50 OR status=archived))
        Some(match self {
reference_test!(
    and_(vec![
    ])
    or_of_predicates_different_columns,
// Distributivity: A AND (B OR C) == (A AND B) OR (A AND C)
// NOT(price = 50 OR price = 95)  ≡  price != 50 AND price != 95.
 * The OpenSearch Contributors require contributions made to
        });
    ])
reference_test!(or_two_collectors, or_(vec![l(BrandAmazon), l(BrandApple)]));
        and_(vec![
);
// Whole result should be empty regardless of the other branch.
// shapes that the old six-op whitelist rejected.
    let rows = run_tree(tree).await;
        l(BrandAmazon),
        not_(l(LeafId::PriceIn(&[90, 95]))),        // exclude two
            LeafId::PriceEq(v) => ReferencePred::Int("price", Operator::Eq, v),
// A OR (B AND C) == (A OR B) AND (A OR C)
reference_test!(
/// )
    }
);
///
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    T::Leaf(id)
/// A compact tree representation for the reference_evaluator; mirrored to `BoolNode` for
);
);
// NOT(price > 40 AND price < 100)  ≡  price <= 40 OR price >= 100.
 * compatible open source license.
        and_(vec![l(PriceLt100), l(CategoryBooks)])
            l(LeafId::PriceGt(100)),
                )
// Single-row targeting: price = 150 AND category = books → row 11.
        l(BrandAmazon),
/// A "primitive" leaf in our test trees, mapped both to a `BoolNode` the
    or_(vec![
reference_test!(
    nested_5_levels,
reference_test!(
}
        name, actual, expected_sorted
    de_morgan_not_or_mixed,
            };
            l(LeafId::PriceLt(40)),
// cheaply.
            l(LeafId::StatusEq("archived"))
    PriceEq(i32),
        // we only check that we have 14 unique inputs, not distinct prices.
                ReferencePred::Int(col, op, v) => pred_int(col, op, v),
    collector_and_or_of_not_and_cmp,
            LeafId::PriceLt50 => ReferencePred::Int("price", Operator::Lt, 50),
                annotation_id: provider_id as i32,
    for (brand, price, status, cat) in &rows {
    and_(vec![l(PriceEq150), l(CategoryBooks)])
        or_(vec![l(BrandAmazon), l(BrandApple)])
                    .iter()
// Predicate that matches everything: price < 100 OR price >= 150.
}
}
    StatusArchived, // provider_id = 2
reference_test!(
        and_(vec![l(BrandAmazon), l(PriceLt50)]),
    PriceGt(i32),
        not_(l(BrandApple)),
    and_(vec![
            l(LeafId::PriceLt(70)),
    not_of_arithmetic,
);
}
        not_(l(BrandAmazon)),
        l(BrandApple),
    /// Structured description of a Predicate leaf, used only by the
// Collector + predicate + collector + predicate alternation.
        BoolNode::And(vec![index_leaf(1), pred_int("price", Operator::Lt, 100)]),
reference_test!(
    // Compute expected in Rust — straightforward boolean eval over the data
    or_(vec![
reference_test!(
}
    ])
        not_(l(BrandApple)),
        ]),
);
reference_test!(not_of_gt_flips_to_lte, not_(l(LeafId::PriceGt(100))));
///   category == "electronics" AND NOT (status == "archived")
    assert_eq!(got, expected);
);
        })
    or_(vec![
                .unwrap();
    ]))
reference_test!(
    ])
    or_(vec![l(BrandAmazon), l(BrandApple)])
// Empty-like collector scope: brand=amazon AND category=books AND price<50
);
    wide_and_5_children,
            and_(vec![l(BrandAmazon), l(StatusArchived)]),
    or_(vec![
reference_test!(
reference_test!(
reference_test!(
    expected.sort();
// Many-child OR with one Predicate + many Collector siblings (OR cost-sort
 *
        or_(vec![l(BrandAmazon), l(BrandApple), l(StatusArchived),]),
);
);
);
    full_subtree_gates_entire_or,
// Test cases
    ])
// cost must not change the result set.
    or_(vec![
            LeafId::PriceGe150 => ReferencePred::Int("price", Operator::GtEq, 150),
        and_(vec![not_(l(CategoryElectronics)), l(CategoryBooks)]),
    mixed_or_of_and_branches,
    commutative_and_ba,
///   brand == "apple" AND price > 80
);
// NOT(price > 100)  ≡  price <= 100  — fast-path op-flip.
            LeafId::StatusArchived => 2,
    or_(vec![
/// engine understands and to a row-level predicate the reference_evaluator uses.
);
reference_test!(
reference_test!(
/// ```
        T::Or(children) => children.iter().any(|c| reference_evaluator(c, row)),
        l(BrandAmazon),
            index_leaf(0), // brand=amazon
    assert_eq!(got, vec![40, 50, 55, 60, 70, 90, 99, 120]);
    }
        and_(vec![l(PriceLt50), l(PriceGe150)]), // contradictory → empty
    // total 9 distinct rows
macro_rules! reference_test {
            threshold: 50
        l(PriceGe150),
    let rows = run_tree(tree).await;
);
//     arithmetic, string equality).
reference_test!(
    and_(vec![l(BrandAmazon), l(StatusArchived)])
        l(BrandAmazon),
);
    or_of_and_branches_with_multi_column_filters,
    and_collector_or_of_different_columns,
        not_(l(PriceGe150)),
            LeafId::PriceGt(v) => PRICES[row] > v,
);
    empty_result_via_three_way_and,
            ]),
reference_test!(
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        match self {
        or_(vec![l(BrandAmazon), l(BrandApple)]),
    PriceGe150,
);
    wide_or_6_children,
// care which one the tree was built as.
    or_(vec![
        and_(vec![
    let rows = run_tree(tree).await;
            _ => return None,
    and_with_subtree_selecting_subset,
    // amazon AND active: rows 0,2,3
reference_test!(
                    .collect();
        l(LeafId::PriceLt(100)),
        or_(vec![l(PriceLt50), l(PriceEq150)]),
    let rows = run_tree(bool_tree).await;
    or_predicate_with_many_collector_siblings,
                index_leaf(1),                        // brand=apple
        not_(and_(vec![l(PriceGe150), l(CategoryBooks)])),
reference_test!(
        pred_str("category", Operator::Eq, "electronics"),
// Reference evaluator-driven exhaustive tests
        and_(vec![l(BrandAmazon), l(StatusArchived)]),
        ("apple".into(), 90),
    and_(vec![
            l(BrandApple),
        l(LeafId::PriceGt(100)),
reference_test!(
//   (apple AND price > 100) OR (amazon AND price IN (30, 50))
// Same collector leaf used in both branches of OR. DFS visits each
reference_test!(not_brand_amazon, not_(l(BrandAmazon)));
// These stress the tree walkers, DFS ordering, and cost-sort stability.
// short-circuit when a Collector is under NOT.
    }))
    and_(vec![
        BoolNode::Not(Box::new(index_leaf(2))), // NOT status=archived
reference_test!(not_price_lt_100, not_(l(PriceLt100)));
    got.sort();
reference_test!(
    ])
    PriceEq150,
// NOT around a Collector-only AND → exact inversion taken.
use LeafId::*;
    not_collector_inside_or_siblings,
    ])
// brand = apple OR price IN (30, 40, 300) — Collector OR'd with IN.
            cat
// (PruningPredicate expands this into a union of three stats checks).
                l(LeafId::StatusEq("archived"))
    ])
            LeafId::BrandAmazon => 0,
    not_over_mixed_tree,
        );
    in_list_or_with_collector,
);
}
        l(PriceLt50),
    ]);
        index_leaf(0),
        l(PriceEq150),
// ──────────────────────────────────────────────────────────────────────
            LeafId::StatusArchived => STATUSES[row] == "archived",
);
// Tree with always-full subtree OR'd with a narrow branch.
);
    distributive_and_over_or,
// Expected: row 12 has amazon, electronics, 30 → category≠books → 0 rows.
            not_(or_(vec![l(BrandAmazon), l(BrandApple)])),
// mixing columns.
reference_test!(
//! fan-out, stress shapes. Built around an reference_evaluator that evaluates trees
        l(BrandApple),
}
// Heavy mixed: 6 levels, every operator, crosses columns.
        l(PriceLt50),
    same_provider_id_used_twice,
    and_(vec![l(BrandApple), l(PriceLt100)])
// ─────────────────────────────────────────────────────────────────────
    or_(vec![l(PriceLt50), l(CategoryBooks), l(BrandApple)])
    ])
            return BoolNode::Collector {
// AND cost-sort that puts Predicates first).
    not_and_not_chain,
            l(PriceGe150),
        and_(vec![
    ])
    and_(vec![
);
// to AND of the inner items.
reference_test!(
// ──────────────────────────────────────────────────────────────────────
    or_(vec![l(BrandAmazon), l(LeafId::PriceGt(190))])
    and_(vec![
        and_(vec![l(BrandApple), l(StatusArchived)]),
    ])
    // index-backed collector leaves (provider_id 0/1/2 per `wire_collector_indices`)
        match self {
    not_of_in_list_under_collector,
            LeafId::PricePlusGt { offset, threshold } => {
    let tree = BoolNode::Not(Box::new(index_leaf(0))); // NOT amazon
reference_test!(
        // Note: PricePlusGt { offset, threshold } means price+offset > threshold.
            LeafId::PriceEq150 => PRICES[row] == 150,
reference_test!(idempotent_or, or_(vec![l(PriceLt100), l(PriceLt100)]));
    ])
        T::Or(children) => BoolNode::Or(children.iter().map(to_engine_tree).collect()),
reference_test!(
                && CATEGORIES[r] == cat.as_str()
    or_(vec![l(LeafId::PriceGt(200)), l(LeafId::StatusEq("nope"))])
}
            LeafId::PriceEq150 => ReferencePred::Int("price", Operator::Eq, 150),
        if (is_amazon || is_apple_cheap) && not_archived && electronics {
reference_test!(
    and_(vec![
// (apple AND price<70 AND status=active) OR (amazon AND price>=100)
);
        l(CategoryBooks),
// ══════════════════════════════════════════════════════════════════
            LeafId::PriceGe150 => PRICES[row] >= 150,
    or_of_many_same_column_predicates,
                l(CategoryBooks),
    or_of_predicates_same_column,
    or_of_collector_and_branches_mixed_shapes,
// NOT(price IN (50, 95)) — non-invertible leaf; goes through NotExpr wrapper
            l(StatusArchived),
    Not(Box<T>),
        l(BrandApple),
        not_(l(CategoryElectronics)),
        l(LeafId::StatusEq("active")),
        l(LeafId::PricePlusGt {
);
        ])),
        ("amazon".into(), 150),
    and_(vec![
    prices.sort();
    ])
// Many-child AND with one Collector + many Predicate siblings (exercise
    let mut out = Vec::new();
    not_of_or_same_col_de_morgan,
    BrandAmazon,    // provider_id = 0
);
                ReferencePred::Str(col, op, v) => pred_str(col, op, v),
// one). Reference walks STATUSES row-by-row.
reference_test!(
// the reference_evaluator doesn't care about the equivalence, it just checks that the
    }
    fn as_collector_provider_id(self) -> Option<u8> {
            ("apple".into(), 90),
    }
            out.push(PRICES[i]);
        index_leaf(0), // amazon
async fn simple_and_of_collector_and_predicate() {
    not_(l(LeafId::PricePlusGt {
    stress_all_leaves_in_tree,
);
);
                    Arc::new(Literal::new(ScalarValue::Int32(Some(threshold))));
        }
            LeafId::PriceLt50 => PRICES[row] < 50,
        l(PriceLt100),
// Commutativity: AND(A, B) == AND(B, A). Engine's leader-follower sort by
async fn not_and_de_morgan() {
                ]),
    ])
    let tree = BoolNode::Not(Box::new(BoolNode::And(vec![
    or_(vec![l(BrandApple), l(LeafId::PriceIn(&[40, 300]))])
    ])
);
// ⇒ universe. All 16 rows.
    /// lowering uses [`as_bool_node`] which produces a
        let is_apple_cheap = BRANDS[i] == "apple" && PRICES[i] < 100;
// Batch 5 — cross-column combinations. Exercise multiple parquet predicate
    actual.sort();
        l(PriceEq150),
        // (price > 100) OR (price + 10 > 50) instead. Still a valid tree.
    let rows = run_tree(tree).await;
// price = 50 OR price = 95 OR price = 200 — chained same-column OR
        l(LeafId::PriceEq(95)),
    ])
        l(CategoryBooks),
        l(PriceEq150),
            _ => unreachable!("handled above"),
// Cases where one branch of AND/OR collapses the result to empty or universe.
                    .map(|v| {
/// the engine. Doesn't need to roundtrip — we build both from the same DSL
    and_two_predicates,
);
    and_(vec![
// Wide AND fan-out (5 children).
        BoolNode::Or(vec![
    /// Engine-tree leaf for this LeafId.
        ]),
);
reference_test!(
// Associativity: A AND (B AND C) vs (A AND B) AND C — engine must not
        ]),
    disjoint_branches_or,
    or_of_collector_and_predicate,
// ──────────────────────────────────────────────────────────────────────
///   ),
// Absorption: A AND (A OR B) == A ; A OR (A AND B) == A
        not_(l(StatusArchived)),
        let price: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new("price", price_idx));
// OR of Collector + predicate, OR of AND-branches. All via the reference
        Some(match self {
        T::And(children) => children.iter().all(|c| reference_evaluator(c, row)),
    multi_column_or,
// OR-heavy trees — OR inside AND with predicates on different columns,
        and_(vec![l(BrandApple), l(PriceLt100)]),
reference_test!(
                or_(vec![
);
            "[{}] engine returned row not in fixture: ({}, {}, {}, {})",
        and_(vec![l(CategoryBooks), l(PriceGe150)]),
// brand=apple AND (price > 100 OR status=archived) — multi-column OR,
reference_test!(commutative_or_ba, or_(vec![l(BrandApple), l(BrandAmazon)]));
    // amazon rows: 0,1,2,3,12 (5)
    chained_same_col_or,
// without hand-computing expected rows — covers many boolean combinations
    collector_and_in_and_not_in,
        threshold: i32,
// ──────────────────────────────────────────────────────────────────────
    or_(vec![
// NOT((price + 10) > 100) — NOT over arithmetic; NotExpr wrapper path.
// Pathological: deeply left-skewed OR tree.
    out
        ("amazon".into(), 120),
    commutative_and_predicate_first,
        T::Not(inner) => BoolNode::Not(Box::new(to_engine_tree(inner))),
/// tree evaluator should handle this correctly.
// Nested NOT(OR(NOT ...)) — double negation through De Morgan equivalent
    de_morgan_not_and_mixed,
        // Richer operators built directly as PhysicalExpr.
    ])
// Collector excluded via NOT in OR sibling. Tests per-leaf cache after OR
    single_row_match,
// ── Stress shapes ────────────────────────────────────────────────────
        and_(vec![l(StatusArchived), l(CategoryBooks)]),
//   NOT((apple AND price > 150) OR price IN (30, 50))
reference_test!(
reference_test!(
        l(CategoryElectronics),
reference_test!(
        or_(vec![l(PriceEq150), l(CategoryBooks)]),
        or_(vec![l(PriceLt100), l(CategoryBooks)]),
    assert_eq!(prices, vec![50, 80, 120]);
    absorption_or,
reference_test!(
);
//   apple AND (price > 150 OR NOT status = "active")
);
    right_skewed_and,
}
        or_(vec![
);
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
                let sum: Arc<dyn PhysicalExpr> =
    match tree {
        actual.push(found.unwrap());
reference_test!(
// Single predicate across 5 OR clauses (redundant but valid).
        l(LeafId::PriceIn(&[30, 50])),
        l(CategoryElectronics),
        l(CategoryElectronics),
    ])
        let not_archived = STATUSES[i] != "archived";
            l(LeafId::StatusEq("active")),
            not_(l(LeafId::StatusEq("active"))),
        offset: i32,
// engine returns exactly the docs the tree selects.
/// `BoolNode::Predicate(PhysicalExpr)` directly via [`LeafId::as_bool_node`].
    // electronics AND not archived: rows 0,3,4,7,8,10,14,15
);
    and_(vec![
reference_test!(
reference_test!(
        actual, expected_sorted,
reference_test!(
    ])
///   OR(
    left_skewed_or,
// NOT(A OR B) == NOT(A) AND NOT(B)
reference_test!(idempotent_and, and_(vec![l(BrandAmazon), l(BrandAmazon)]));
reference_test!(leaf_price_eq_150, l(PriceEq150));
    /// Evaluated as a parquet predicate (not via Collector bitset).
reference_test!(or_two_predicates, or_(vec![l(PriceLt50), l(PriceGe150)]));
        l(StatusArchived),
// 6 children — exceeds typical small-arena bounds.
            status,
        l(BrandApple),
    not_(or_(vec![
);
        not_(l(PriceLt50)),
    CategoryElectronics,
// ─────────────────────────────────────────────────────────────────────
//! row-by-row directly on the fixture arrays, so each test is one line.
// Cross-operator combos — union of different tree shapes.
}
            LeafId::BrandAmazon => BRANDS[row] == "amazon",
        l(PriceGt100),
// Double negation: NOT(NOT A) == A
// ─────────────────────────────────────────────────────────────────────
        and_(vec![l(BrandApple), l(LeafId::PriceGt(100))]),
                not_(l(BrandApple)),
            ]),
        // sanity: the 2 excluded rows have prices 150 (row 1) and 30 (row 12).
        or_(vec![l(CategoryElectronics), l(CategoryBooks)]),
                        let l: Arc<dyn PhysicalExpr> =
    ])
// Phase 1/2 pipeline. `assert_engine_matches_reference` runs both and compares.
    ])
        l(LeafId::PriceIn(&[45, 60, 90, 95, 200])), // all apple prices
    and_collector_and_predicate,
    Int(&'static str, Operator, i32),
    let tree = BoolNode::Or(vec![
// Apple rows are all electronics OR books. Books apple: row 6.
        l(LeafId::PricePlusGt {
reference_test!(
    }
    or_(vec![
reference_test!(
            or_(vec![
    ])
);
//! idempotence, De Morgan, absorption, distributivity, commutativity,
// Single-leaf tests.
            l(PriceGt100),
    and_(vec![
async fn assert_engine_matches_reference(name: &str, tree: T) {
// 3-way AND: price > 40 AND price < 100 AND category = electronics.
    }
}
reference_test!(
    ])
        assert_ne!(r.0, "amazon");
        or_(vec![
        use datafusion::physical_expr::PhysicalExpr;
///
        let price_idx = schema.index_of("price").unwrap();
    ])
    CategoryBooks,
// NOT coverage across operator types. Exercises:
    got.sort();
// apple AND (price + 10) > 100 — arithmetic the old converter rejected.
        ]),
        pred_str("category", Operator::Eq, "electronics"), // category=electronics
    let tree = BoolNode::And(vec![index_leaf(1), pred_int("price", Operator::Gt, 80)]);
fn reference_evaluator(tree: &T, row: usize) -> bool {
        #[tokio::test(flavor = "multi_thread", worker_threads = 2)]
