    }
/// `col IN (lit, lit, ...)` with 1..=4 literals. With some probability,
    // leaves to show up in every tree.
        _ => 0.50,
#[allow(dead_code)]
    // Mix strategy: 70% in-distribution (selects some rows), 15% below
        assert!(
            let mut rng = StdRng::seed_from_u64(s);
        for iter in 0..50u64 {
        return gen_leaf(rng, schema, num_collectors);
            }
        DataType::Timestamp(datafusion::arrow::datatypes::TimeUnit::Nanosecond, None) => {
    }
        }
        corpus.config.tree_max_depth,
    if depth_remaining == 0 {
            avg_fanout >= 3.0,
        return gen_leaf(rng, schema, num_collectors);
        })
    BoolNode::Predicate(Arc::new(in_list))
        PredicateShape::Like
        0 => format!("{}%", ch),
                .collect();
        schema.fields().iter().cloned().collect::<Vec<_>>(),
            let v = match strategy {
            ScalarValue::Float64(Some(v))
            let v: i64 = match strategy {
        .iter()
        }
    );
    pub collector_matches: Vec<Vec<i32>>,
        Operator::LtEq,
        let avg_fanout = if total_fanout_count > 0 {
    let col_idx = rng.gen_range(1..schema.fields().len());
            let n = pick_fanout(rng);
use rand::rngs::StdRng;
    // Without a string column, LIKE would always pick a non-string and
    num_collectors: usize,
            avg_fanout
        PredicateShape::Binary
fn _keep_imports(_: &CellValue, _: &Corpus) {}
        2 => format!("%{}%", ch),
/// Harness uses this to wire the same tag → doc-set mapping on both
    // without flattening to a single hot value. Keeps a chance of low
    let col_expr: Arc<dyn PhysicalExpr> = Arc::new(Column::new(field.name(), col_idx));
    if x < 60 {
}
            10..=35 => (b'a' + (c as u8 - 10)) as char,
// Silence warnings: CellValue/Corpus used only via tree-gen callers.
    } else if x < 60 + 20 {
    match pick_predicate_shape(rng, has_string_col) {
                0..=69 => rng.gen_range(0..10_000),
            };
                _ => rng.gen_range(20_454..i32::MAX),
/// Recursive tree builder. Depth-bounded; at depth 0 always returns a
        let mut max_seen = 0usize;
            let lit = if null_here {
    let density = corpus.config.collector_density.clamp(0.0, 1.0);
    }
    BoolNode::Predicate(Arc::new(like))
fn gen_binary_predicate(rng: &mut StdRng, schema: &SchemaRef) -> BoolNode {
    let total = 60 + 20 + 10 + w_like;
    pub tree: BoolNode,
}
    rng: &mut StdRng,
                cs.len().max(cs.iter().map(max_fanout).max().unwrap_or(0))
        match n {
        1 => format!("%{}", ch),
        0 => {
            };
    let col_expr: Arc<dyn PhysicalExpr> = Arc::new(Column::new(field.name(), col_idx));
            total_fanout_sum as f64 / total_fanout_count as f64
//!
    if !rng.gen_bool(connective_prob) {
            d <= corpus.config.tree_max_depth as usize + 1,
            BoolNode::And(cs) | BoolNode::Or(cs) => 1 + cs.iter().map(depth).max().unwrap_or(0),
        PredicateShape::Binary => gen_binary_predicate(rng, schema),
                })
            "max depth over 40 trees was {}; expected to reach near {}",
        num_collectors,
            let gt = generate_tree(&mut rng, &corpus);
        }
    }
                .map(|_| gen_node(rng, schema, num_collectors, depth_remaining - 1, max_fanout))
            matches
            BoolNode::Collector { .. }
        d if d >= 3 => 0.90,
/// matching doc ids the oracle and mock collector will replay.
        }
        .fields()
            "avg fanout {:.2} < 3.0 over 40 trees; tree-gen too narrow",
fn gen_is_null_predicate(rng: &mut StdRng, schema: &SchemaRef) -> BoolNode {
            BoolNode::Collector { .. }
    let w_like: u32 = if has_string_col { 10 } else { 0 };
            };
                }
                .collect();
        ))),
        let a = r.gen_range(2..=max_fanout);
        Operator::Lt,
}
        DataType::Utf8 => ScalarValue::Utf8(None),
            format!("{:?}", t1.tree),
            | BoolNode::Predicate(_)
            BoolNode::Not(c) => count_fanouts(c, sum, count),
                70..=84 => rng.gen_range(0..1_704_067_200_000_000_000_i64),
            let mut rng = StdRng::seed_from_u64(iter);
    // Strongly favor connectives so trees actually reach `tree_max_depth`.
fn gen_in_list_predicate(rng: &mut StdRng, schema: &SchemaRef) -> BoolNode {
    let literal = pick_literal_for(rng, field.data_type());
}
    let field = schema.field(col_idx);
            ScalarValue::Date32(Some(v))
        gen_predicate_leaf(rng, schema)
    };
        }
    ];
        }
                0..=69 => {
            | BoolNode::DelegationPossible { .. } => 0,
    let strategy = rng.gen_range(0..100u32);
            | BoolNode::Predicate(_)
    } else {
use rand::Rng;
    let col_idx = *string_col_idxs.choose(rng).unwrap();
 */
/// one literal is NULL — exercises 3VL semantics for `IN` lists.
/// at interior depths.
    } else {
            // Random alphanumeric — mostly doesn't match exactly with
        DataType::Timestamp(datafusion::arrow::datatypes::TimeUnit::Nanosecond, None) => {
                saw_collector = true;
    let pick_fanout = |r: &mut StdRng| -> usize {
            _ => (b'A' + (c as u8 - 36)) as char,
                70..=84 => rng.gen_range(-1e9..0.0),
            // Place the NULL at a random position in the list if asked.
    } else {
        );
            BoolNode::Predicate(_) => {}
        match n {
            let gt = generate_tree(&mut rng, &corpus);
            ScalarValue::TimestampNanosecond(None, None)
}
        .fields()
mod tests {
    let field = schema.field(col_idx);
                0..=69 => rng.gen_range(0..1000),      // in typical range
    }
            BoolNode::Not(c) => walk(c, out),
        }
            };
        DataType::Int32 => ScalarValue::Int32(None),
        DataType::Date32 => {
            ScalarValue::Utf8(Some(s))
    }
        );
                _ => rng.gen_range(10_000..i64::MAX),
    let negated = rng.gen_bool(0.2);
        match c {
    fn tree_gen_respects_depth_and_fanout() {
            fo <= corpus.config.tree_max_fanout,
    // min (0%), 15% above max (100% on <, 0% on >). This catches off-by-
        DataType::Utf8 => {
        }
            corpus.config.tree_max_fanout
                0..=69 => rng.gen_range(18_262..20_454),
    use datafusion::physical_expr::expressions::LikeExpr;
            let n = pick_fanout(rng);
    let x = rng.gen_range(0..total);
fn pick_literal_for(rng: &mut StdRng, dt: &DataType) -> ScalarValue {
        };
        let t1 = generate_tree(&mut r1, &corpus);
}
        .collect();
            }
    match rng.gen_range(0..3u32) {
    // and we want more of them for coverage, but we still want Collector
        let mut total_fanout_sum = 0usize;
    depth_remaining: u32,
            let v = match strategy {
        Operator::GtEq,
        collector_matches: per_leaf_matches,
            "fanout {} exceeds bound {}",
                *sum += cs.len();
        _ => BoolNode::Not(Box::new(gen_node(
use rand::seq::SliceRandom;
            BoolNode::And(cs) | BoolNode::Or(cs) => {
            format!("{:?}", t2.tree),
        BoolNode::Not(Box::new(node))
    /// are drawn from `0..corpus.num_rows()` at the configured density.
        corpus.config.tree_max_fanout.max(2),
}
                    match c {
    match dt {
    let negated = rng.gen_bool(0.2);
/// `col LIKE 'pat'` on a Utf8 column. Picks a small wildcard pattern.
        .iter()
/// mix: plenty of simple comparisons, some IN lists, some IS NULL,
    // Previously the 70/40 split stopped most trees around depth 1–2.
    #[test]
        _ => format!("{}", ch),
        let corpus = build_corpus(FixtureConfig::small(7));
        match n {
    out
use datafusion::logical_expr::Operator;
        for s in 0..40u64 {
    use crate::indexed_table::tests_e2e::fuzz::{build_corpus, FixtureConfig};
    walk(tree, &mut out);
    /// Sanity: over many seeds, at least some trees should actually
    let pattern: String = match rng.gen_range(0..4) {
    let col_idx = rng.gen_range(1..schema.fields().len());
        );
        } else {
/// shape builder.
        );
            let mut matches: Vec<i32> = (0..corpus.num_rows() as i32).collect();
        PredicateShape::Like => gen_like_predicate(rng, schema),
            };
        let corpus = build_corpus(FixtureConfig::small(42));
    }
    let field = schema.field(col_idx);
    fn tree_gen_produces_collector_leaves_sometimes() {
fn gen_predicate_leaf(rng: &mut StdRng, schema: &SchemaRef) -> BoolNode {
        .collect();
            num_collectors,
    use rand::SeedableRng;
    // With Alphanumeric corpus, these hit somewhere.
            BoolNode::And(cs) | BoolNode::Or(cs) => {
    let col_expr: Arc<dyn PhysicalExpr> = Arc::new(Column::new(field.name(), col_idx));
enum PredicateShape {
            BoolNode::Collector { annotation_id } => {
        }
            count_fanouts(&gt.tree, &mut total_fanout_sum, &mut total_fanout_count);
        assert!(
    fn walk(n: &BoolNode, out: &mut Vec<u8>) {
        .enumerate()
            d,
fn null_scalar_for(dt: &DataType) -> ScalarValue {
    }
    fn count_fanouts(n: &BoolNode, sum: &mut usize, count: &mut usize) {
        DataType::Int64 => {
/// NOT for the negated form — so the oracle can keep its
 * this file be licensed under the Apache-2.0 license or a
        DataType::Int32 => {
        .skip(1) // skip __doc_id
    GeneratedTree {
        other => panic!("null_scalar_for: unsupported type {:?}", other),
            BoolNode::Collector { .. }
    // we pick two candidates and take the larger, which pulls the mean up
/// Typed NULL literal matching the given column's datatype.
//! where `id` is a distinct u8 in `[0, num_collector_leaves)`. The
        }
        let c: u32 = rng.gen_range(0..62);
    let col_expr: Arc<dyn PhysicalExpr> = Arc::new(Column::new(field.name(), col_idx));
}
    schema: &SchemaRef,
                .map(|_| gen_node(rng, schema, num_collectors, depth_remaining - 1, max_fanout))
            | BoolNode::DelegationPossible { .. } => {}
    Like,
    // = fraction of total rows. A "match" is just a randomly picked
 * The OpenSearch Contributors require contributions made to
                null_scalar_for(field.data_type())
    // Choose a random Utf8 column (guaranteed to exist by caller).
            }
    }
            let s: String = (0..rng.gen_range(1..=6))
    // Pre-compute each Collector leaf's matching doc-id set. Density
}
        let b = r.gen_range(2..=max_fanout);
/// Pick which predicate shape to emit. Weights approximate real-world
        Operator::NotEq,
                .collect();
    let schema = corpus.schema.clone();
                        0..=9 => (b'0' + c as u8) as char,
/// corpus. Deterministic given the rng state.
        .filter_map(|(i, f)| matches!(f.data_type(), DataType::Utf8).then_some(i))
            matches.sort_unstable();
            max_fanout,
        assert!(
        let t2 = generate_tree(&mut r2, &corpus);
                        10..=35 => (b'a' + (c as u8 - 10)) as char,
        }
 * SPDX-License-Identifier: Apache-2.0
    let case_insensitive = false;
/// Build a `Predicate(Arc<dyn PhysicalExpr>)`. Dispatches to the chosen
        // With the skewed pick-larger-of-two scheme and max_fanout=5,
    let is_null: Arc<dyn PhysicalExpr> = Arc::new(IsNullExpr::new(col_expr));
    }
        // but with pick_larger we push it higher).
                _ => rng.gen_range(1_735_689_600_000_000_000_i64..i64::MAX),
use crate::indexed_table::bool_tree::BoolNode;
        let corpus = build_corpus(FixtureConfig::small(42));
        })
    let make_collector = num_collectors > 0 && rng.gen_bool(0.35);
use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
    match dt {
            let target = ((corpus.num_rows() as f64) * density) as usize;
            fo,
            if !collect_collector_tags(&gt.tree).is_empty() {
            BoolNode::DelegationPossible { .. } => {}
/// sides (oracle + mock collector).
                        _ => (b'A' + (c as u8 - 36)) as char,
fn gen_like_predicate(rng: &mut StdRng, schema: &SchemaRef) -> BoolNode {
    let like = LikeExpr::new(negated, case_insensitive, col_expr, pat_expr);
    /// reach the configured max depth. Otherwise tree-gen is quietly
//!
pub(in crate::indexed_table::tests_e2e) fn generate_tree(
    /// `collector_matches[leaf_id] = Vec<doc_id>`. The matching doc ids
        DataType::Date32 => ScalarValue::Date32(None),
    }
fn gen_leaf(rng: &mut StdRng, schema: &SchemaRef, num_collectors: usize) -> BoolNode {
    #[test]
        PredicateShape::IsNull => gen_is_null_predicate(rng, schema),
        assert!(saw_collector, "50 trees and not one Collector leaf");
}
            0..=9 => (b'0' + c as u8) as char,
/// side-table mapping each Collector leaf id (u8) to the set of
    #[test]
        // E[fanout] is around 3.5. Demand at least 3.0 so the test
    BoolNode::Predicate(Arc::new(BinaryExpr::new(col_expr, op, lit_expr)))
            corpus.config.tree_max_depth,
/// occasional LIKE on string columns.
                out.push(*annotation_id as u8);
//! produces a random tree bounded by `tree_max_depth` and
                .map(|_| {
    };
    let per_leaf_matches: Vec<Vec<i32>> = (0..num_collectors)
    corpus: &Corpus,
        match n {
}
            max_seen,
pub(in crate::indexed_table::tests_e2e) struct GeneratedTree {
    let mut out = Vec::new();
    let col_idx = rng.gen_range(1..schema.fields().len());
                    rng.gen_range(1_704_067_200_000_000_000_i64..1_735_689_600_000_000_000_i64)
    // 35% collector, 65% predicate — predicates are cheaper to evaluate
            BoolNode::Or(children)
    fn max_fanout(n: &BoolNode) -> usize {
    }
    /// producing shallower trees than requested.
/// actually select a meaningful slice of rows).
            ScalarValue::TimestampNanosecond(Some(v), None)
) -> GeneratedTree {
        }
    InList,
        a.max(b)
            matches.truncate(target);
        }
            annotation_id: id as i32,
        .collect();
    let in_list = InListExpr::try_new(col_expr, list, negated, &bare_schema)
            Arc::new(Literal::new(lit)) as Arc<dyn PhysicalExpr>
    if rng.gen_bool(0.5) {
/// Generate a random tree + collector-match sets against the given
/*
//! Given a schema + a Collector-leaf id space (0..num_collector_leaves),
    }
    // row id — the oracle uses these sets verbatim.
            "same seed must yield same tree"
    // fail at evaluate time. Skip it in that case.
        }
                cs.iter().for_each(|c| count_fanouts(c, sum, count));
        .map(|_| {
    }
        .skip(1)
        Operator::Gt,
    IsNull,
        BoolNode::Collector {
        assert_eq!(t1.collector_matches, t2.collector_matches);
        let mut total_fanout_count = 0usize;
    let num_collectors = corpus.config.num_collector_leaves;
                70..=84 => rng.gen_range(i32::MIN..0), // below typical
//! exercised.
/// What the tree-gen exposes to the harness: the tree itself plus a
        2 => 0.75,
    Binary,
        .expect("InListExpr try_new should succeed with schema-typed inputs");
//! `MockCollector`), and the oracle uses the same id-to-set map.
    let bare_schema = datafusion::arrow::datatypes::Schema::new(
        .any(|f| matches!(f.data_type(), DataType::Utf8));
                    }
    let include_null = rng.gen_bool(0.2); // 20% of IN lists include a NULL
use datafusion::physical_expr::PhysicalExpr;
}
        1 => {
}
 *
    let ops = [
        let mut r2 = StdRng::seed_from_u64(1);
/// `BoolNode::Not(Predicate(IsNull))` shape.
            }
}
            } else {
    }
        rng,
    }
        assert_eq!(
            let v = match strategy {
            | BoolNode::DelegationPossible { .. } => 0,
            schema,
        let mut r1 = StdRng::seed_from_u64(1);
        let gt = generate_tree(&mut rng, &corpus);
        let mut saw_collector = false;
            let v = match strategy {
        tree,
fn pick_predicate_shape(rng: &mut StdRng, has_string_col: bool) -> PredicateShape {
) -> BoolNode {
    }
    let string_col_idxs: Vec<usize> = schema
    let n = rng.gen_range(1..=4);
                70..=84 => rng.gen_range(i64::MIN..0),
/// `col IS NULL` or `col IS NOT NULL`. Emits `IsNullExpr` wrapped in
    // Pattern: single char + '%', or '%' + char, or just a char.
        assert!(
            max_seen = max_seen.max(depth(&gt.tree));
    let field = schema.field(col_idx);
/// leaf. Picks AND/OR/NOT/Collector/Predicate with roughly equal weight
            "depth {} exceeds bound {}",
            BoolNode::Not(c) => max_fanout(c),
                    let c: u32 = rng.gen_range(0..62);
    // Fanout skew: bias upward. `2..=max` uniform gives mean ≈ (max+2)/2;
            BoolNode::And(cs) | BoolNode::Or(cs) => cs.iter().for_each(|c| walk(c, out)),
}
    if make_collector {
use datafusion::common::ScalarValue;
        PredicateShape::IsNull
                break;
        node
/// that overlaps the corpus's value distribution (so predicates
#[cfg(test)]
        }
        }
//! harness wires each tagged leaf to a pre-computed doc-id set (via
use datafusion::arrow::datatypes::{DataType, SchemaRef};
            ScalarValue::Int32(Some(v))
    };
    fn depth(n: &BoolNode) -> usize {
            let null_here = include_null && i == 0;
//! Random `BoolNode` tree generation for the fuzz suite.
            ScalarValue::Int64(Some(v))
            | BoolNode::Predicate(_)
    // fanout (simple shapes) while emphasizing wider nodes.
        let mut rng = StdRng::seed_from_u64(7);
    }
    rng: &mut StdRng,
pub(in crate::indexed_table::tests_e2e) fn collect_collector_tags(tree: &BoolNode) -> Vec<u8> {
        Operator::Eq,
        .map(|i| {
        let d = depth(&gt.tree);
            corpus.config.tree_max_depth
            // the distinct pool, which is fine (tests eq/neq at 0%).
                0..=69 => rng.gen_range(0.0..100.0),
//! `tree_max_fanout`. Every AND/OR/NOT/Collector/Predicate shape gets
    use super::*;
            rng,
    let pat_expr: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Utf8(Some(pattern))));
        let corpus = build_corpus(FixtureConfig::small(11));
        let fo = max_fanout(&gt.tree);
        let id = rng.gen_range(0..num_collectors) as u8;
/// Pick a literal value that matches the column's type, within a range
                *count += 1;
use std::sync::Arc;
            let children: Vec<BoolNode> = (0..n)
fn gen_node(
/// Peer into a `BoolNode` to collect Collector leaf tags in DFS order.
            BoolNode::Not(c) => 1 + depth(c),
        DataType::Boolean => ScalarValue::Boolean(None),
        }
                _ => rng.gen_range(100.0..1e9),
        DataType::Float64 => {
        // catches a regression to uniform 2..=max (E ≈ 3.5 anyway,
    use datafusion::physical_expr::expressions::InListExpr;
    // one and empty-result short-circuit bugs.
    fn tree_gen_reaches_high_depth() {
                70..=84 => rng.gen_range(0..18_262),
    let lit_expr: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(literal));
            };
        );
    fn tree_gen_is_deterministic() {
    let node = BoolNode::Predicate(is_null);
    let tree = gen_node(
    };
    use datafusion::physical_expr::expressions::IsNullExpr;
            depth_remaining - 1,
    let has_string_col = schema
        PredicateShape::InList => gen_in_list_predicate(rng, schema),
 * compatible open source license.
//! The returned tree uses tagged Collector leaves: `query_bytes = [id]`
    } else if x < 60 + 20 + 10 {
use super::corpus::{CellValue, Corpus};
        DataType::Int64 => ScalarValue::Int64(None),
        DataType::Boolean => ScalarValue::Boolean(Some(rng.gen())),
    let list: Vec<Arc<dyn PhysicalExpr>> = (0..n)
    let connective_prob = match depth_remaining {
            max_seen as u32 >= corpus.config.tree_max_depth - 1,
        PredicateShape::InList
                pick_literal_for(rng, field.data_type())
    );
    let ch: char = {
            matches.shuffle(rng);
        &schema,
                _ => rng.gen_range(1000..i32::MAX),    // above typical
        other => panic!("tree_gen: unsupported schema type {:?}", other),
            0.0
            let children: Vec<BoolNode> = (0..n)
            BoolNode::And(children)
        DataType::Float64 => ScalarValue::Float64(None),
    max_fanout: usize,
    let op = *ops.choose(rng).unwrap();
    #[test]
