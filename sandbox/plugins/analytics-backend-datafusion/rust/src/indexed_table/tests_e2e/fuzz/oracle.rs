    if let Some(is_null) = any.downcast_ref::<IsNullExpr>() {
            cmp_to_tri(c.cmp(l), op)
    use crate::indexed_table::tests_e2e::fuzz::{build_corpus, generate_tree, FixtureConfig};
    match (cell, lit) {
    }
                    Tri::True
    panic!("oracle: unsupported Predicate shape {:?}", expr);
}
    if result {
            let tag = *annotation_id as u8 as usize;
                acc = acc.and(eval_row(c, corpus, row, collector_sets));
            Tri::False => Tri::True,
//! panics on any other shape; if the tree-gen grows new shapes, this
        // set must equal `Predicate(original_expr)`. The oracle treats it that way.
        return base;
            let l = none_unknown!(l);
            let c = none_unknown!(c);
        (cell, lit) => panic!("oracle: type mismatch cell={:?} lit={:?}", cell, lit),
            .right()
        };
}
        BoolNode::DelegationPossible { original_expr, .. } => {
    use rand::SeedableRng;
            .expr()
            let c = none_unknown!(c);
                        .expect("oracle: InList list entry must be Literal");
        let mut saw_non_trivial = false;
        .iter()
    } else {
    }
                saw_non_trivial = true;
    fn or(self, other: Tri) -> Tri {
        other => panic!("oracle: unsupported operator {:?}", other),
            if !out.is_empty() && out.len() < corpus.num_rows() {
    macro_rules! none_unknown {
        for d in &out {
fn cell_null(cell: &CellValue) -> bool {
        }
            Tri::False
            _ => Tri::Unknown,
        };
                break;
            acc
    }
        .map(|v| v.iter().copied().collect())
            cmp_to_tri((*c as i32).cmp(&(*l as i32)), op)
        }
            let mut acc = Tri::False;
        }
            other => panic!("oracle: Like pattern not Utf8: {:?}", other),
            _ => Tri::Unknown,
    for i in 1..=n {
                }
    }
/// Evaluate `tree` row-by-row. Returns the sorted vec of matching doc
        let col = in_list
                    Tri::False
            .expect("oracle: Like target must be Column");
    }
    for row in 0..corpus.num_rows() as i32 {
    Unknown,
/// `_` matches any single char. No escape handling (our patterns never
            }
        CellValue::TimestampNanos(v) => v.is_none(),
    use datafusion::physical_expr::expressions::{InListExpr, IsNullExpr, LikeExpr};
        Operator::NotEq => ord != Equal,
            cmp_to_tri(ord, op)
            (Tri::False, _) | (_, Tri::False) => Tri::False,
}
                '_' => dp[i - 1][j - 1],
        let corpus = build_corpus(FixtureConfig::small(0xb));
        let m = sql_like_match(val_str, pat_str);
            .downcast_ref::<Column>()
                .get(tag)
        (CellValue::Utf8(c), ScalarValue::Utf8(l)) => {
                for lit_expr in in_list.list() {
//! Literal)` — that's the shape `tree_gen` produces. The evaluator
            ScalarValue::Utf8(None) => return Tri::Unknown,
    let n = v.len();
        // Within corpus range.
    match cell {
            }
            .downcast_ref::<Literal>()
        Operator::Eq => ord == Equal,
            .expect("oracle: InList target must be Column");
    }
            for c in children {
    result
        (CellValue::Int64(c), ScalarValue::Int64(l)) => {
    let collector_sets: Vec<HashSet<i32>> = tree
            eval_predicate(original_expr, corpus, row as usize)
        return base;
        .get(col_name)
            let c = none_unknown!(c);
            true => Tri::Unknown,
                Some(v) => v,
            .left()
        match (self, other) {
        let col = is_null
        }
            let tree = generate_tree(&mut rng, &corpus);
                Tri::False
                        }
    for j in 1..=m {
            // we honor that for parity).
    };
        // Ensure we're actually exercising the evaluator: for a handful
    let result = match op {
    dp[n][m]
        if eval_row(&tree.tree, corpus, row, &collector_sets) == Tri::True {
            let l = none_unknown!(l);
        match self {
        .collector_matches
            .downcast_ref::<Column>()
        let cell = get_cell(corpus, col.name(), row);
            cmp_to_tri(c.cmp(l), op)
        .collect();
        // - any (cell == lit) → TRUE
            let l = none_unknown!(l);
 * this file be licensed under the Apache-2.0 license or a
            let l = none_unknown!(l);
        // Contract: a DelegationPossible leaf evaluates identically to its `original_expr`.
 * SPDX-License-Identifier: Apache-2.0
                    return Tri::False;
            let ord = c.partial_cmp(l).expect("checked non-NaN");
    match node {
        assert_eq!(a, b);
        ($x:expr) => {
    if let Some(in_list) = any.downcast_ref::<InListExpr>() {
                None => return Tri::Unknown,
            };
//! Each Predicate leaf is required to be a `BinaryExpr(Column, Op,
            // Only Eq and NotEq are meaningful for booleans (our tree-gen
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
            .pattern()
    fn and(self, other: Tri) -> Tri {
use super::corpus::{CellValue, Corpus};
                return Tri::Unknown;
    let m = p.len();
    if let Some(bin) = any.downcast_ref::<BinaryExpr>() {
        }
        let corpus = build_corpus(FixtureConfig::small(0xa));
mod tests {
                        Tri::False => {}
                    Tri::Unknown
/// - `LikeExpr { Column, pattern: Literal, negated, case_insensitive=false }`
            let mut rng = StdRng::seed_from_u64(s);
use crate::indexed_table::bool_tree::BoolNode;
        let col = bin
/// 3-valued logic: TRUE / FALSE / UNKNOWN (NULL).
        let pat_lit = like
        let base = if m { Tri::True } else { Tri::False };
}
        Operator::LtEq => ord != Greater,
impl Tri {
        return compare_cell_lit(cell, *bin.op(), lit.value());
                    let lit = lit_expr
            // f64 cmp: treat NaN as UNKNOWN (matches SQL semantics).
        let base = match cell_null(cell) {
            cmp_to_tri(c.cmp(l), op)
        .col_idx
}
            return base.not();
    }
}
            let mut acc = Tri::True;
        let val_str = match cell {
//!
/// Minimal SQL LIKE matcher: `%` matches any (possibly empty) substring,
        BoolNode::Or(children) => {
    // Classic DP: dp[i][j] = true iff value[0..i] matches pattern[0..j].
        let a = oracle_evaluate(&tree, &corpus);
        let mut rng = StdRng::seed_from_u64(0xa);
}
            let out = oracle_evaluate(&tree, &corpus);
            } else {
        }
    let p: Vec<char> = pattern.chars().collect();
                } else if seen_unknown {
}
        // Production may consult a peer at runtime to narrow candidates, but the residual
        }
    }
    }
        CellValue::Date32(v) => v.is_none(),
pub(in crate::indexed_table::tests_e2e) fn oracle_evaluate(
/// ids — a row matches iff the tree's Tri result is `True` (SQL
            let l = none_unknown!(l);
        }
            dp[0][j] = dp[0][j - 1];
        let col = like
        (CellValue::Float64(c), ScalarValue::Float64(l)) => {
    dp[0][0] = true;
            .expect("oracle: Like pattern must be Literal");
use datafusion::logical_expr::Operator;
                if acc == Tri::False {
    tree: &GeneratedTree,
        CellValue::Boolean(v) => v.is_none(),
        // SQL 3VL for IN:
        (CellValue::Int32(c), ScalarValue::Int32(l)) => {
        // Sorted.
        if like.negated() {
        let cell = get_cell(corpus, col.name(), row);
 * The OpenSearch Contributors require contributions made to
fn get_cell<'a>(corpus: &'a Corpus, col_name: &str, row: usize) -> &'a CellValue {
            }
/// - `InListExpr { Column, list: Vec<Literal>, negated }`
    &corpus.cells[col_idx][row]
                } else {
        CellValue::Int32(v) => v.is_none(),
            cmp_to_tri(c.as_str().cmp(l.as_str()), op)
//! Ground-truth oracle: evaluate a `BoolNode` tree row-by-row against
    }
        }
    }
                acc = acc.or(eval_row(c, corpus, row, collector_sets));
                    match compare_cell_lit(cell, Operator::Eq, lit.value()) {
    }
                        Tri::Unknown => seen_unknown = true,
        let tree = generate_tree(&mut rng, &corpus);
        }
                    return Tri::True;
    if let Some(like) = any.downcast_ref::<LikeExpr>() {
            dp[i][j] = match p[j - 1] {
            .expect("oracle: BinaryExpr lhs must be Column");
) -> Vec<i32> {
            assert!(w[0] < w[1], "oracle output not strictly sorted");
    }
    fn oracle_not_trivially_empty_or_full() {
        }
        };
                        .downcast_ref::<Literal>()
                let mut seen_unknown = false;
            let c = none_unknown!(c);
        let corpus = build_corpus(FixtureConfig::small(0xc));
        // Then `negated` flips TRUE↔FALSE (UNKNOWN stays).
        let mut rng = StdRng::seed_from_u64(0xb);
//! construction — a simple recursive SQL-3VL evaluator.
            .expr()
    }
            return base.not();
            }
 */
        // of random seeds at least one result is neither empty nor full.
            (Tri::True, Tri::True) => Tri::True,
            if set.contains(&row) {
            .expect("oracle: IsNull target must be Column");
        return if cell_null(cell) {
            .expect("oracle: BinaryExpr rhs must be Literal");
        }
    corpus: &Corpus,
    use std::cmp::Ordering::*;
            }
                }
        Operator::GtEq => ord != Less,
        // FilterExec re-applies `original_expr` on the decoded batch — the final result
        }
            other => panic!("oracle: Like target not Utf8 cell: {:?}", other),
                if found {
            .arg()
    True,
            cmp_to_tri(c.cmp(l), op)
        CellValue::Float64(v) => v.is_none(),
            assert!(*d >= 0 && (*d as usize) < corpus.num_rows());
    False,
        // - cell IS NULL → UNKNOWN
        match (self, other) {
    #[test]
        if p[j - 1] == '%' {
        let pat_str = match pat_lit.value() {
    // Convert pattern to regex-ish DP.
                            found = true;
use datafusion::physical_expr::PhysicalExpr;
/// semantics: NULL doesn't pass WHERE).
            }
fn eval_row(node: &BoolNode, corpus: &Corpus, row: i32, collector_sets: &[HashSet<i32>]) -> Tri {
    fn not(self) -> Tri {
use std::collections::HashSet;
        Operator::Gt => ord == Greater,
            Tri::Unknown => Tri::Unknown,
        BoolNode::Predicate(expr) => eval_predicate(expr, corpus, row as usize),
            Tri::True
/// - `IsNullExpr(Column)`
fn cmp_to_tri(ord: std::cmp::Ordering, op: Operator) -> Tri {
    let v: Vec<char> = value.chars().collect();
        CellValue::Int64(v) => v.is_none(),
            let l = none_unknown!(l);
    #[test]
            CellValue::Utf8(Some(s)) => s.as_str(),
        }
        };
            let c = none_unknown!(c);
        Tri::False
fn eval_predicate(expr: &std::sync::Arc<dyn PhysicalExpr>, corpus: &Corpus, row: usize) -> Tri {
    fn oracle_is_deterministic() {
    let any = expr.as_ref();
            match $x {
            (Tri::True, _) | (_, Tri::True) => Tri::True,
        let tree = generate_tree(&mut rng, &corpus);
        (CellValue::Date32(c), ScalarValue::Date32(l)) => {
fn sql_like_match(value: &str, pattern: &str) -> bool {
                }
use super::tree_gen::GeneratedTree;
        }
    }
}
    let col_idx = *corpus
            ScalarValue::Utf8(Some(s)) => s.as_str(),
                Tri::True
#[cfg(test)]
        };
        BoolNode::Collector { annotation_id } => {
            acc
//! oracle must grow with it.
                c => v[i - 1] == c && dp[i - 1][j - 1],
                    }
            let set = collector_sets
        // - none match, no NULL lit → FALSE
        }
        (CellValue::TimestampNanos(c), ScalarValue::TimestampNanosecond(l, _tz)) => {
        if in_list.negated() {
            for c in children {
fn compare_cell_lit(cell: &CellValue, op: Operator, lit: &ScalarValue) -> Tri {
                        Tri::True => {
            .downcast_ref::<Column>()
        }
        let b = oracle_evaluate(&tree, &corpus);
    fn oracle_produces_sorted_unique_output() {
            result.push(row);
        let lit = bin
        let cell = get_cell(corpus, col.name(), row);
    }
            let l = none_unknown!(l);
            Tri::True => Tri::False,
/// Evaluate a predicate expression at a single row. Supports:
 *
        for s in 0..20u64 {
            CellValue::Utf8(None) => return Tri::Unknown,
}
    use super::*;
        }
                            break;
        CellValue::Utf8(v) => v.is_none(),
        (CellValue::Boolean(c), ScalarValue::Boolean(l)) => {
        assert!(saw_non_trivial, "all 20 trees were trivially empty/full");
        } else {
        Operator::Lt => ord == Less,
}
/*
        }
                }
        BoolNode::Not(child) => eval_row(child, corpus, row, collector_sets).not(),
        // IS NULL returns TRUE/FALSE — never UNKNOWN — per SQL.
        }
//! the raw corpus. Trusted because it's obviously correct by
    }
            .downcast_ref::<Literal>()
                let mut found = false;
    // Any null → UNKNOWN.
            let c = none_unknown!(c);
            let c = none_unknown!(c);
 * compatible open source license.
            .downcast_ref::<Column>()
                if acc == Tri::True {
/// include backslashes).
            // may emit ordering ops but arrow compares false < true so
        .unwrap_or_else(|| panic!("oracle: column {:?} not in corpus", col_name));
        BoolNode::And(children) => {
        // - any lit IS NULL → UNKNOWN (not found yet; keep going looking for match)
/// - `BinaryExpr(Column, cmp_op, Literal)`
        Tri::True
use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
        let out = oracle_evaluate(&tree, &corpus);
        let cell = get_cell(corpus, col.name(), row);
            if c.is_nan() || l.is_nan() {
                '%' => dp[i][j - 1] || dp[i - 1][j],
    #[test]
    }
        for w in out.windows(2) {
    let mut result = Vec::new();
            false => {
            (Tri::False, Tri::False) => Tri::False,
        }
                .unwrap_or_else(|| panic!("oracle: Collector tag {} has no matching set", tag));
        for j in 1..=m {
            }
enum Tri {
use datafusion::common::ScalarValue;
    let mut dp = vec![vec![false; m + 1]; n + 1];
    use rand::rngs::StdRng;
        }
