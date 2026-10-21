    #[test]
        let avg_fanout = if total_fanout_count > 0 {
            matches.shuffle(rng);
        PredicateShape::IsNull => gen_is_null_predicate(rng, schema),
            "max depth over 40 trees was {}; expected to reach near {}",
    let node = BoolNode::Predicate(is_null);
    fn max_fanout(n: &BoolNode) -> usize {
                .map(|_| gen_node(rng, schema, num_collectors, depth_remaining - 1, max_fanout))
fn null_scalar_for(dt: &DataType) -> ScalarValue {
            let n = pick_fanout(rng);
//!
            | BoolNode::DelegationPossible { .. } => {}
        ))),
        a.max(b)
                *count += 1;
 * SPDX-License-Identifier: Apache-2.0
    );
/*
        schema.fields().iter().cloned().collect::<Vec<_>>(),
    fn count_fanouts(n: &BoolNode, sum: &mut usize, count: &mut usize) {
    let col_expr: Arc<dyn PhysicalExpr> = Arc::new(Column::new(field.name(), col_idx));
fn gen_binary_predicate(rng: &mut StdRng, schema: &SchemaRef) -> BoolNode {
                .collect();
    if make_collector {
        DataType::Boolean => ScalarValue::Boolean(Some(rng.gen())),
use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
    let negated = rng.gen_bool(0.2);
    let bare_schema = datafusion::arrow::datatypes::Schema::new(
        Operator::LtEq,
    }
use rand::Rng;
    let field = schema.field(col_idx);
    }
fn gen_node(
        // E[fanout] is around 3.5. Demand at least 3.0 so the test
            schema,
    }
            }
                pick_literal_for(rng, field.data_type())
            fo <= corpus.config.tree_max_fanout,
    }
        DataType::Timestamp(datafusion::arrow::datatypes::TimeUnit::Nanosecond, None) => {
    fn depth(n: &BoolNode) -> usize {
        );
        assert!(
        .map(|i| {
        .skip(1) // skip __doc_id
        let c: u32 = rng.gen_range(0..62);
                saw_collector = true;
    let ch: char = {
    // min (0%), 15% above max (100% on <, 0% on >). This catches off-by-
    /// are drawn from `0..corpus.num_rows()` at the configured density.
 * compatible open source license.
) -> BoolNode {
/// Generate a random tree + collector-match sets against the given
                .collect();
        _ => format!("{}", ch),
        0 => format!("{}%", ch),
        }
        let t2 = generate_tree(&mut r2, &corpus);
        let mut r1 = StdRng::seed_from_u64(1);
        }
    // Fanout skew: bias upward. `2..=max` uniform gives mean ≈ (max+2)/2;
            BoolNode::Or(children)
        let corpus = build_corpus(FixtureConfig::small(42));
        DataType::Date32 => {
            avg_fanout >= 3.0,
            let n = pick_fanout(rng);
        DataType::Float64 => ScalarValue::Float64(None),
        assert!(
    // Mix strategy: 70% in-distribution (selects some rows), 15% below
        let mut r2 = StdRng::seed_from_u64(1);
    fn tree_gen_is_deterministic() {
    use rand::SeedableRng;
mod tests {
use rand::seq::SliceRandom;
    depth_remaining: u32,
        match n {
            };
    fn walk(n: &BoolNode, out: &mut Vec<u8>) {
        for s in 0..40u64 {
        }
        );
    };
//! The returned tree uses tagged Collector leaves: `query_bytes = [id]`
/// Peer into a `BoolNode` to collect Collector leaf tags in DFS order.
            max_seen as u32 >= corpus.config.tree_max_depth - 1,
/// Pick a literal value that matches the column's type, within a range
    };
        }
    let pattern: String = match rng.gen_range(0..4) {
        let t1 = generate_tree(&mut r1, &corpus);
            let gt = generate_tree(&mut rng, &corpus);
                })
    fn tree_gen_reaches_high_depth() {
/// What the tree-gen exposes to the harness: the tree itself plus a
/// mix: plenty of simple comparisons, some IN lists, some IS NULL,
    Like,
    let include_null = rng.gen_bool(0.2); // 20% of IN lists include a NULL
    } else if x < 60 + 20 + 10 {
    }
 *
//!
    let op = *ops.choose(rng).unwrap();
    }
    let n = rng.gen_range(1..=4);
            BoolNode::And(cs) | BoolNode::Or(cs) => cs.iter().for_each(|c| walk(c, out)),
fn gen_leaf(rng: &mut StdRng, schema: &SchemaRef, num_collectors: usize) -> BoolNode {
    let pick_fanout = |r: &mut StdRng| -> usize {
        _ => BoolNode::Not(Box::new(gen_node(
            } else {
        );
                }
fn gen_is_null_predicate(rng: &mut StdRng, schema: &SchemaRef) -> BoolNode {
            fo,
        let d = depth(&gt.tree);
                    let c: u32 = rng.gen_range(0..62);
            corpus.config.tree_max_depth
        DataType::Boolean => ScalarValue::Boolean(None),
        // With the skewed pick-larger-of-two scheme and max_fanout=5,
#[cfg(test)]
    // Pre-compute each Collector leaf's matching doc-id set. Density
        for iter in 0..50u64 {
                    match c {
}
        .fields()
            ScalarValue::Float64(Some(v))
            ScalarValue::TimestampNanosecond(None, None)
        }
            format!("{:?}", t1.tree),
        assert!(
        &schema,
            rng,
        .collect();
            BoolNode::Not(c) => max_fanout(c),
//! Random `BoolNode` tree generation for the fuzz suite.
    let negated = rng.gen_bool(0.2);
            matches.truncate(target);
//! harness wires each tagged leaf to a pre-computed doc-id set (via
/// occasional LIKE on string columns.
            BoolNode::Not(c) => count_fanouts(c, sum, count),
        let a = r.gen_range(2..=max_fanout);
        }
        match n {
/// `col IN (lit, lit, ...)` with 1..=4 literals. With some probability,
}
//! `MockCollector`), and the oracle uses the same id-to-set map.
use std::sync::Arc;
) -> GeneratedTree {
            BoolNode::Collector { .. }
            matches.sort_unstable();
    let case_insensitive = false;
    pub collector_matches: Vec<Vec<i32>>,
                        10..=35 => (b'a' + (c as u8 - 10)) as char,
/// `col IS NULL` or `col IS NOT NULL`. Emits `IsNullExpr` wrapped in
            BoolNode::And(cs) | BoolNode::Or(cs) => 1 + cs.iter().map(depth).max().unwrap_or(0),
        other => panic!("null_scalar_for: unsupported type {:?}", other),
        num_collectors,
            if !collect_collector_tags(&gt.tree).is_empty() {
    };
                70..=84 => rng.gen_range(0..1_704_067_200_000_000_000_i64),
            max_seen,
    out
                _ => rng.gen_range(1_735_689_600_000_000_000_i64..i64::MAX),
    pub tree: BoolNode,
    let like = LikeExpr::new(negated, case_insensitive, col_expr, pat_expr);
            | BoolNode::Predicate(_)
            _ => (b'A' + (c as u8 - 36)) as char,
        );
        BoolNode::Not(Box::new(node))
        Operator::Gt,
    match dt {
                break;
    // fanout (simple shapes) while emphasizing wider nodes.
    /// `collector_matches[leaf_id] = Vec<doc_id>`. The matching doc ids
    let field = schema.field(col_idx);
            "depth {} exceeds bound {}",
        PredicateShape::Binary => gen_binary_predicate(rng, schema),
/// NOT for the negated form — so the oracle can keep its
    }
            total_fanout_sum as f64 / total_fanout_count as f64
            | BoolNode::Predicate(_)
    let mut out = Vec::new();
                70..=84 => rng.gen_range(-1e9..0.0),
use datafusion::physical_expr::PhysicalExpr;
        DataType::Int32 => ScalarValue::Int32(None),
            BoolNode::Collector { .. }
/// sides (oracle + mock collector).
                70..=84 => rng.gen_range(i32::MIN..0), // below typical
        node
use datafusion::common::ScalarValue;
    if depth_remaining == 0 {
                _ => rng.gen_range(1000..i32::MAX),    // above typical
                0..=69 => rng.gen_range(0.0..100.0),
    let field = schema.field(col_idx);
        corpus.config.tree_max_fanout.max(2),
    let tree = gen_node(
    let pat_expr: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Utf8(Some(pattern))));
                0..=69 => rng.gen_range(18_262..20_454),
    GeneratedTree {
        DataType::Utf8 => ScalarValue::Utf8(None),
            let children: Vec<BoolNode> = (0..n)
use datafusion::logical_expr::Operator;
}
            }
    corpus: &Corpus,
            corpus.config.tree_max_fanout
            ScalarValue::Utf8(Some(s))
    };
    // 35% collector, 65% predicate — predicates are cheaper to evaluate
    } else {
    if x < 60 {
        assert!(
    }
    #[test]
    BoolNode::Predicate(Arc::new(in_list))
    }
                cs.len().max(cs.iter().map(max_fanout).max().unwrap_or(0))
    #[test]
    use super::*;
    // Pattern: single char + '%', or '%' + char, or just a char.
        .collect();
                0..=69 => rng.gen_range(0..10_000),
            | BoolNode::DelegationPossible { .. } => 0,
fn _keep_imports(_: &CellValue, _: &Corpus) {}
    }
                _ => rng.gen_range(20_454..i32::MAX),
        .iter()
/// Pick which predicate shape to emit. Weights approximate real-world
/// Typed NULL literal matching the given column's datatype.
    let schema = corpus.schema.clone();
/// actually select a meaningful slice of rows).
}
        let id = rng.gen_range(0..num_collectors) as u8;
    Binary,
    }
            BoolNode::And(cs) | BoolNode::Or(cs) => {
//! where `id` is a distinct u8 in `[0, num_collector_leaves)`. The
        // catches a regression to uniform 2..=max (E ≈ 3.5 anyway,
                cs.iter().for_each(|c| count_fanouts(c, sum, count));
            let mut rng = StdRng::seed_from_u64(iter);
            ScalarValue::TimestampNanosecond(Some(v), None)
        let corpus = build_corpus(FixtureConfig::small(7));
    let string_col_idxs: Vec<usize> = schema
            let null_here = include_null && i == 0;
        }
            let v = match strategy {
/// Harness uses this to wire the same tag → doc-set mapping on both
    match rng.gen_range(0..3u32) {
    // With Alphanumeric corpus, these hit somewhere.
    let col_expr: Arc<dyn PhysicalExpr> = Arc::new(Column::new(field.name(), col_idx));
    // without flattening to a single hot value. Keeps a chance of low
        .collect();
fn gen_like_predicate(rng: &mut StdRng, schema: &SchemaRef) -> BoolNode {
/// at interior depths.
    use crate::indexed_table::tests_e2e::fuzz::{build_corpus, FixtureConfig};
use rand::rngs::StdRng;
// Silence warnings: CellValue/Corpus used only via tree-gen callers.
        let mut total_fanout_count = 0usize;
}
        tree,
        let fo = max_fanout(&gt.tree);
    // and we want more of them for coverage, but we still want Collector
        }
            num_collectors,
            let mut rng = StdRng::seed_from_u64(s);
            BoolNode::And(children)
        DataType::Date32 => ScalarValue::Date32(None),
            let mut matches: Vec<i32> = (0..corpus.num_rows() as i32).collect();
        DataType::Timestamp(datafusion::arrow::datatypes::TimeUnit::Nanosecond, None) => {
    }
    if !rng.gen_bool(connective_prob) {
            d <= corpus.config.tree_max_depth as usize + 1,
    let has_string_col = schema
        }
        PredicateShape::InList => gen_in_list_predicate(rng, schema),
        1 => format!("%{}", ch),
    if rng.gen_bool(0.5) {
    let x = rng.gen_range(0..total);
    // Choose a random Utf8 column (guaranteed to exist by caller).
pub(in crate::indexed_table::tests_e2e) fn generate_tree(
fn pick_literal_for(rng: &mut StdRng, dt: &DataType) -> ScalarValue {
        }
    /// producing shallower trees than requested.
        PredicateShape::Binary
use super::corpus::{CellValue, Corpus};
            BoolNode::DelegationPossible { .. } => {}
            let lit = if null_here {
pub(in crate::indexed_table::tests_e2e) struct GeneratedTree {
                .map(|_| {
        .skip(1)
        .any(|f| matches!(f.data_type(), DataType::Utf8));
        // but with pick_larger we push it higher).
            let children: Vec<BoolNode> = (0..n)
 */
fn pick_predicate_shape(rng: &mut StdRng, has_string_col: bool) -> PredicateShape {
            };
use crate::indexed_table::bool_tree::BoolNode;
        let mut total_fanout_sum = 0usize;
/// that overlaps the corpus's value distribution (so predicates
            format!("{:?}", t2.tree),
    }
            let v: i64 = match strategy {
    let make_collector = num_collectors > 0 && rng.gen_bool(0.35);
        .fields()
    let total = 60 + 20 + 10 + w_like;
    // one and empty-result short-circuit bugs.
    let list: Vec<Arc<dyn PhysicalExpr>> = (0..n)
        let mut saw_collector = false;
pub(in crate::indexed_table::tests_e2e) fn collect_collector_tags(tree: &BoolNode) -> Vec<u8> {
}
    ];
    }
        assert_eq!(t1.collector_matches, t2.collector_matches);
        Operator::Lt,
            | BoolNode::Predicate(_)
            max_seen = max_seen.max(depth(&gt.tree));
            d,
        DataType::Int64 => {
        .filter_map(|(i, f)| matches!(f.data_type(), DataType::Utf8).then_some(i))
            avg_fanout
        Operator::GtEq,
    let col_idx = rng.gen_range(1..schema.fields().len());
    rng: &mut StdRng,
        );
            let v = match strategy {
}
        rng,
    }
            0..=9 => (b'0' + c as u8) as char,
fn gen_in_list_predicate(rng: &mut StdRng, schema: &SchemaRef) -> BoolNode {
}
            BoolNode::Predicate(_) => {}
            };
    InList,
        .enumerate()
        Operator::NotEq,
        let corpus = build_corpus(FixtureConfig::small(42));
}
        return gen_leaf(rng, schema, num_collectors);
        }
            BoolNode::Collector { annotation_id } => {
            let s: String = (0..rng.gen_range(1..=6))
            annotation_id: id as i32,
    let strategy = rng.gen_range(0..100u32);
                *sum += cs.len();
    BoolNode::Predicate(Arc::new(BinaryExpr::new(col_expr, op, lit_expr)))
        2 => format!("%{}%", ch),
                .collect();
    /// reach the configured max depth. Otherwise tree-gen is quietly
        assert_eq!(
/// Build a `Predicate(Arc<dyn PhysicalExpr>)`. Dispatches to the chosen
            // Place the NULL at a random position in the list if asked.
            10..=35 => (b'a' + (c as u8 - 10)) as char,
 * The OpenSearch Contributors require contributions made to
    fn tree_gen_respects_depth_and_fanout() {
//! produces a random tree bounded by `tree_max_depth` and
use datafusion::arrow::datatypes::{DataType, SchemaRef};
    } else {
    // Without a string column, LIKE would always pick a non-string and
            depth_remaining - 1,
                0..=69 => rng.gen_range(0..1000),      // in typical range
    );
            // the distinct pool, which is fine (tests eq/neq at 0%).
    }
    // = fraction of total rows. A "match" is just a randomly picked
    let col_idx = *string_col_idxs.choose(rng).unwrap();
/// corpus. Deterministic given the rng state.
            BoolNode::Collector { .. }
/// shape builder.
    match dt {
        .expect("InListExpr try_new should succeed with schema-typed inputs");
 * this file be licensed under the Apache-2.0 license or a
}
        let mut rng = StdRng::seed_from_u64(7);
    match pick_predicate_shape(rng, has_string_col) {
    BoolNode::Predicate(Arc::new(like))
        2 => 0.75,
    // fail at evaluate time. Skip it in that case.
                    rng.gen_range(1_704_067_200_000_000_000_i64..1_735_689_600_000_000_000_i64)
                out.push(*annotation_id as u8);
        match n {
            corpus.config.tree_max_depth,
/// one literal is NULL — exercises 3VL semantics for `IN` lists.
            matches
            };
#[allow(dead_code)]
    let in_list = InListExpr::try_new(col_expr, list, negated, &bare_schema)
/// `BoolNode::Not(Predicate(IsNull))` shape.
        }
            let gt = generate_tree(&mut rng, &corpus);
    let field = schema.field(col_idx);
    use datafusion::physical_expr::expressions::LikeExpr;
        };
    use datafusion::physical_expr::expressions::IsNullExpr;
    // we pick two candidates and take the larger, which pulls the mean up
        DataType::Int32 => {
        BoolNode::Collector {
        corpus.config.tree_max_depth,
    let density = corpus.config.collector_density.clamp(0.0, 1.0);
    let num_collectors = corpus.config.num_collector_leaves;
    use datafusion::physical_expr::expressions::InListExpr;
    let is_null: Arc<dyn PhysicalExpr> = Arc::new(IsNullExpr::new(col_expr));
        other => panic!("tree_gen: unsupported schema type {:?}", other),
enum PredicateShape {
                0..=69 => {
            let v = match strategy {
        1 => {
    let literal = pick_literal_for(rng, field.data_type());
    schema: &SchemaRef,
        d if d >= 3 => 0.90,
        return gen_leaf(rng, schema, num_collectors);
            ScalarValue::Int32(Some(v))
    // leaves to show up in every tree.
}
//! Given a schema + a Collector-leaf id space (0..num_collector_leaves),
        })
            }
        collector_matches: per_leaf_matches,
    let ops = [
        } else {
    let per_leaf_matches: Vec<Vec<i32>> = (0..num_collectors)
    let col_expr: Arc<dyn PhysicalExpr> = Arc::new(Column::new(field.name(), col_idx));
        PredicateShape::InList
            let v = match strategy {
        DataType::Int64 => ScalarValue::Int64(None),
            "same seed must yield same tree"
            Arc::new(Literal::new(lit)) as Arc<dyn PhysicalExpr>
        }
            "fanout {} exceeds bound {}",
    fn tree_gen_produces_collector_leaves_sometimes() {
    num_collectors: usize,
                        0..=9 => (b'0' + c as u8) as char,
    let w_like: u32 = if has_string_col { 10 } else { 0 };
        let mut max_seen = 0usize;
        _ => 0.50,
        PredicateShape::Like
            BoolNode::Not(c) => walk(c, out),
        let corpus = build_corpus(FixtureConfig::small(11));
    let col_idx = rng.gen_range(1..schema.fields().len());
            }
//! `tree_max_fanout`. Every AND/OR/NOT/Collector/Predicate shape gets
        })
        }
}
/// leaf. Picks AND/OR/NOT/Collector/Predicate with roughly equal weight
        Operator::Eq,
    IsNull,
                    }
    // Strongly favor connectives so trees actually reach `tree_max_depth`.
            count_fanouts(&gt.tree, &mut total_fanout_sum, &mut total_fanout_count);
    // row id — the oracle uses these sets verbatim.
            ScalarValue::Int64(Some(v))
    walk(tree, &mut out);
        match n {
                _ => rng.gen_range(10_000..i64::MAX),
            max_fanout,
        PredicateShape::IsNull
                null_scalar_for(field.data_type())
        }
/// matching doc ids the oracle and mock collector will replay.
        }
                _ => rng.gen_range(100.0..1e9),
    let lit_expr: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(literal));
            // Random alphanumeric — mostly doesn't match exactly with
            };
        match c {
}
            BoolNode::Not(c) => 1 + depth(c),
    /// Sanity: over many seeds, at least some trees should actually
    let col_expr: Arc<dyn PhysicalExpr> = Arc::new(Column::new(field.name(), col_idx));
            ScalarValue::Date32(Some(v))
    rng: &mut StdRng,
        .iter()
    #[test]
    } else if x < 60 + 20 {
    } else {
        let b = r.gen_range(2..=max_fanout);
            0.0
            "avg fanout {:.2} < 3.0 over 40 trees; tree-gen too narrow",
        assert!(saw_collector, "50 trees and not one Collector leaf");
    let connective_prob = match depth_remaining {
            };
}
        DataType::Float64 => {
//! exercised.
    // Previously the 70/40 split stopped most trees around depth 1–2.
/// `col LIKE 'pat'` on a Utf8 column. Picks a small wildcard pattern.
    }
        PredicateShape::Like => gen_like_predicate(rng, schema),
}
        0 => {
/// side-table mapping each Collector leaf id (u8) to the set of
                        _ => (b'A' + (c as u8 - 36)) as char,
        }
                70..=84 => rng.gen_range(0..18_262),
    let col_idx = rng.gen_range(1..schema.fields().len());
fn gen_predicate_leaf(rng: &mut StdRng, schema: &SchemaRef) -> BoolNode {
        gen_predicate_leaf(rng, schema)
            let target = ((corpus.num_rows() as f64) * density) as usize;
            | BoolNode::DelegationPossible { .. } => 0,
        DataType::Utf8 => {
            BoolNode::And(cs) | BoolNode::Or(cs) => {
        let gt = generate_tree(&mut rng, &corpus);
                .map(|_| gen_node(rng, schema, num_collectors, depth_remaining - 1, max_fanout))
        .map(|_| {
    }
                70..=84 => rng.gen_range(i64::MIN..0),
    max_fanout: usize,
/// Recursive tree builder. Depth-bounded; at depth 0 always returns a
