                    match compare_cell_lit(cell, Operator::Eq, lit.value()) {
                c => v[i - 1] == c && dp[i - 1][j - 1],
            cmp_to_tri(c.cmp(l), op)
                }
}
        CellValue::Int64(v) => v.is_none(),
        };
                        Tri::False => {}
fn get_cell<'a>(corpus: &'a Corpus, col_name: &str, row: usize) -> &'a CellValue {
            let tag = *annotation_id as u8 as usize;
            return base.not();
        }
/// - `BinaryExpr(Column, cmp_op, Literal)`
    fn oracle_not_trivially_empty_or_full() {
        assert!(saw_non_trivial, "all 20 trees were trivially empty/full");
/// Minimal SQL LIKE matcher: `%` matches any (possibly empty) substring,
            CellValue::Utf8(None) => return Tri::Unknown,
                } else if seen_unknown {
        let cell = get_cell(corpus, col.name(), row);
    }
                Tri::False
            let l = none_unknown!(l);
            }
                acc = acc.and(eval_row(c, corpus, row, collector_sets));
            _ => Tri::Unknown,
    }
        let b = oracle_evaluate(&tree, &corpus);
        (cell, lit) => panic!("oracle: type mismatch cell={:?} lit={:?}", cell, lit),
        match (self, other) {
            cmp_to_tri(c.cmp(l), op)
}
fn compare_cell_lit(cell: &CellValue, op: Operator, lit: &ScalarValue) -> Tri {
            .expect("oracle: BinaryExpr rhs must be Literal");
        }
    }
            (Tri::False, _) | (_, Tri::False) => Tri::False,
    // Convert pattern to regex-ish DP.
        match self {
            .expect("oracle: IsNull target must be Column");
        if like.negated() {
        BoolNode::Predicate(expr) => eval_predicate(expr, corpus, row as usize),
                '_' => dp[i - 1][j - 1],
            true => Tri::Unknown,
    dp[n][m]
//! Each Predicate leaf is required to be a `BinaryExpr(Column, Op,
            .downcast_ref::<Literal>()
        };
                        Tri::Unknown => seen_unknown = true,
        }
            let l = none_unknown!(l);
}
            .expr()
/// include backslashes).
        // Ensure we're actually exercising the evaluator: for a handful
use datafusion::logical_expr::Operator;
                        }
    macro_rules! none_unknown {
        // - any lit IS NULL → UNKNOWN (not found yet; keep going looking for match)
            let mut acc = Tri::False;
                let mut seen_unknown = false;
            let c = none_unknown!(c);
            let mut acc = Tri::True;
            Tri::False
            cmp_to_tri((*c as i32).cmp(&(*l as i32)), op)
}
        }
    fn oracle_is_deterministic() {
        (CellValue::TimestampNanos(c), ScalarValue::TimestampNanosecond(l, _tz)) => {
            let l = none_unknown!(l);
            return base.not();
                if found {
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
            let l = none_unknown!(l);
                    Tri::False
            // Only Eq and NotEq are meaningful for booleans (our tree-gen
        for d in &out {
        }
pub(in crate::indexed_table::tests_e2e) fn oracle_evaluate(
    panic!("oracle: unsupported Predicate shape {:?}", expr);
        let mut rng = StdRng::seed_from_u64(0xa);
    }
/// Evaluate a predicate expression at a single row. Supports:
        let tree = generate_tree(&mut rng, &corpus);
            }
            }
        .get(col_name)
        CellValue::TimestampNanos(v) => v.is_none(),
        BoolNode::Not(child) => eval_row(child, corpus, row, collector_sets).not(),
    let p: Vec<char> = pattern.chars().collect();
    }
        };
    let mut result = Vec::new();
}
    }
        .iter()
impl Tri {
/// semantics: NULL doesn't pass WHERE).
use crate::indexed_table::bool_tree::BoolNode;
        // of random seeds at least one result is neither empty nor full.
        .unwrap_or_else(|| panic!("oracle: column {:?} not in corpus", col_name));
    result
    }
}
use datafusion::physical_expr::PhysicalExpr;
            CellValue::Utf8(Some(s)) => s.as_str(),
    True,
            .pattern()
        }
 * compatible open source license.
                    Tri::Unknown
    }
        Operator::NotEq => ord != Equal,
        return base;
            (Tri::True, _) | (_, Tri::True) => Tri::True,
mod tests {
            .downcast_ref::<Column>()
    match (cell, lit) {
            let l = none_unknown!(l);
                Tri::True
/// Evaluate `tree` row-by-row. Returns the sorted vec of matching doc
                break;
            .expect("oracle: Like pattern must be Literal");
 * this file be licensed under the Apache-2.0 license or a
        return base;
    &corpus.cells[col_idx][row]
    }
        let m = sql_like_match(val_str, pat_str);
        Tri::True
            let ord = c.partial_cmp(l).expect("checked non-NaN");
                for lit_expr in in_list.list() {
            .expect("oracle: InList target must be Column");
            let out = oracle_evaluate(&tree, &corpus);
        if eval_row(&tree.tree, corpus, row, &collector_sets) == Tri::True {
        // Then `negated` flips TRUE↔FALSE (UNKNOWN stays).
    if let Some(like) = any.downcast_ref::<LikeExpr>() {
        for j in 1..=m {
                            break;
            ScalarValue::Utf8(Some(s)) => s.as_str(),
    }
            dp[0][j] = dp[0][j - 1];
        Operator::Eq => ord == Equal,
        (CellValue::Date32(c), ScalarValue::Date32(l)) => {
/*
}
/// - `InListExpr { Column, list: Vec<Literal>, negated }`
        // FilterExec re-applies `original_expr` on the decoded batch — the final result
        // SQL 3VL for IN:
            (Tri::True, Tri::True) => Tri::True,
                if acc == Tri::False {
            cmp_to_tri(c.as_str().cmp(l.as_str()), op)
    }
    corpus: &Corpus,
            let c = none_unknown!(c);
        (CellValue::Int32(c), ScalarValue::Int32(l)) => {
        let col = in_list
                }
            cmp_to_tri(c.cmp(l), op)
        // set must equal `Predicate(original_expr)`. The oracle treats it that way.
        CellValue::Boolean(v) => v.is_none(),
#[cfg(test)]
                Some(v) => v,
    use std::cmp::Ordering::*;
            .downcast_ref::<Column>()
        let col = bin
            ScalarValue::Utf8(None) => return Tri::Unknown,
    let mut dp = vec![vec![false; m + 1]; n + 1];
        }
        }
        };
            .right()
    False,
    #[test]
        Operator::Lt => ord == Less,
            }
            .arg()
}
//! panics on any other shape; if the tree-gen grows new shapes, this
        let cell = get_cell(corpus, col.name(), row);
            // f64 cmp: treat NaN as UNKNOWN (matches SQL semantics).
            result.push(row);
    use super::*;
    } else {
        (CellValue::Utf8(c), ScalarValue::Utf8(l)) => {
        (CellValue::Int64(c), ScalarValue::Int64(l)) => {
        }
    let n = v.len();
        CellValue::Float64(v) => v.is_none(),
        let pat_lit = like
            let c = none_unknown!(c);
    let any = expr.as_ref();
                            found = true;
                    let lit = lit_expr
        // Contract: a DelegationPossible leaf evaluates identically to its `original_expr`.
        for w in out.windows(2) {
    #[test]
    };
    #[test]
        let corpus = build_corpus(FixtureConfig::small(0xc));
        (CellValue::Boolean(c), ScalarValue::Boolean(l)) => {
    match cell {
    tree: &GeneratedTree,
            Tri::True => Tri::False,
                        .expect("oracle: InList list entry must be Literal");
            other => panic!("oracle: Like pattern not Utf8: {:?}", other),
            cmp_to_tri(c.cmp(l), op)
        }
        BoolNode::Collector { annotation_id } => {
                '%' => dp[i][j - 1] || dp[i - 1][j],
            let c = none_unknown!(c);
        // - none match, no NULL lit → FALSE
        }
            // may emit ordering ops but arrow compares false < true so
        }
        let cell = get_cell(corpus, col.name(), row);
    let collector_sets: Vec<HashSet<i32>> = tree
        match (self, other) {
//! Literal)` — that's the shape `tree_gen` produces. The evaluator
    }
use datafusion::common::ScalarValue;
        if in_list.negated() {
        // - any (cell == lit) → TRUE
fn eval_row(node: &BoolNode, corpus: &Corpus, row: i32, collector_sets: &[HashSet<i32>]) -> Tri {
            acc
        }
    for i in 1..=n {
//!
        }
    fn or(self, other: Tri) -> Tri {
        }
enum Tri {
            };
        }
        let base = if m { Tri::True } else { Tri::False };
            let c = none_unknown!(c);
use super::tree_gen::GeneratedTree;
/// ids — a row matches iff the tree's Tri result is `True` (SQL
//! oracle must grow with it.
    for j in 1..=m {
        // Within corpus range.
            Tri::Unknown => Tri::Unknown,
            if c.is_nan() || l.is_nan() {
                        .downcast_ref::<Literal>()
    fn not(self) -> Tri {
        CellValue::Utf8(v) => v.is_none(),
            .expect("oracle: BinaryExpr lhs must be Column");
/// - `IsNullExpr(Column)`
}
            acc
            (Tri::False, Tri::False) => Tri::False,
        Operator::LtEq => ord != Greater,
            for c in children {
        CellValue::Date32(v) => v.is_none(),
 * The OpenSearch Contributors require contributions made to
        Operator::GtEq => ord != Less,
            .downcast_ref::<Column>()
        return if cell_null(cell) {
            assert!(*d >= 0 && (*d as usize) < corpus.num_rows());
        }
            let l = none_unknown!(l);
            }
                }
            }
        BoolNode::Or(children) => {
        let lit = bin
 *
        (CellValue::Float64(c), ScalarValue::Float64(l)) => {
            let mut rng = StdRng::seed_from_u64(s);
use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
    fn oracle_produces_sorted_unique_output() {
        let corpus = build_corpus(FixtureConfig::small(0xb));
        other => panic!("oracle: unsupported operator {:?}", other),
            for c in children {
    fn and(self, other: Tri) -> Tri {
                        Tri::True => {
    }
            .expect("oracle: Like target must be Column");
            let l = none_unknown!(l);
        // Production may consult a peer at runtime to narrow candidates, but the residual
fn cell_null(cell: &CellValue) -> bool {
            false => {
        // IS NULL returns TRUE/FALSE — never UNKNOWN — per SQL.
    }
        .collector_matches
        // - cell IS NULL → UNKNOWN
    let col_idx = *corpus
        let mut saw_non_trivial = false;
        let val_str = match cell {
//! the raw corpus. Trusted because it's obviously correct by
/// `_` matches any single char. No escape handling (our patterns never
            if !out.is_empty() && out.len() < corpus.num_rows() {
        let col = like
        Operator::Gt => ord == Greater,
    match node {
            let set = collector_sets
    if let Some(in_list) = any.downcast_ref::<InListExpr>() {
        } else {
            cmp_to_tri(ord, op)
    let m = p.len();
            .left()
                .get(tag)
    let result = match op {
fn eval_predicate(expr: &std::sync::Arc<dyn PhysicalExpr>, corpus: &Corpus, row: usize) -> Tri {
        let a = oracle_evaluate(&tree, &corpus);
                acc = acc.or(eval_row(c, corpus, row, collector_sets));
        let base = match cell_null(cell) {
    }
        let cell = get_cell(corpus, col.name(), row);
                    return Tri::False;
            dp[i][j] = match p[j - 1] {
        }
    Unknown,
        CellValue::Int32(v) => v.is_none(),
//! Ground-truth oracle: evaluate a `BoolNode` tree row-by-row against
        .col_idx
                    Tri::True
use super::corpus::{CellValue, Corpus};
        }
            other => panic!("oracle: Like target not Utf8 cell: {:?}", other),
    for row in 0..corpus.num_rows() as i32 {
    }
    // Any null → UNKNOWN.
            let c = none_unknown!(c);
            // we honor that for parity).
    use rand::rngs::StdRng;
        }
    dp[0][0] = true;
                    }
                } else {
                    return Tri::True;
        }
        if p[j - 1] == '%' {
        let corpus = build_corpus(FixtureConfig::small(0xa));
        let pat_str = match pat_lit.value() {
        ($x:expr) => {
    }
) -> Vec<i32> {
                None => return Tri::Unknown,
//! construction — a simple recursive SQL-3VL evaluator.
}
fn sql_like_match(value: &str, pattern: &str) -> bool {
        for s in 0..20u64 {
            let c = none_unknown!(c);
    if result {
/// 3-valued logic: TRUE / FALSE / UNKNOWN (NULL).
    }
        assert_eq!(a, b);
        let tree = generate_tree(&mut rng, &corpus);
        };
        let mut rng = StdRng::seed_from_u64(0xb);
            match $x {
        let col = is_null
        Tri::False
        .map(|v| v.iter().copied().collect())
        let out = oracle_evaluate(&tree, &corpus);
        BoolNode::And(children) => {
            if set.contains(&row) {
            _ => Tri::Unknown,
 * SPDX-License-Identifier: Apache-2.0
fn cmp_to_tri(ord: std::cmp::Ordering, op: Operator) -> Tri {
        // Sorted.
            .downcast_ref::<Literal>()
}
    let v: Vec<char> = value.chars().collect();
    if let Some(bin) = any.downcast_ref::<BinaryExpr>() {
            .expr()
/// - `LikeExpr { Column, pattern: Literal, negated, case_insensitive=false }`
            Tri::True
        BoolNode::DelegationPossible { original_expr, .. } => {
        .collect();
                if acc == Tri::True {
            let tree = generate_tree(&mut rng, &corpus);
                saw_non_trivial = true;
    if let Some(is_null) = any.downcast_ref::<IsNullExpr>() {
            assert!(w[0] < w[1], "oracle output not strictly sorted");
    use rand::SeedableRng;
            eval_predicate(original_expr, corpus, row as usize)
            Tri::False => Tri::True,
                let mut found = false;
use std::collections::HashSet;
            .downcast_ref::<Column>()
    use crate::indexed_table::tests_e2e::fuzz::{build_corpus, generate_tree, FixtureConfig};
    use datafusion::physical_expr::expressions::{InListExpr, IsNullExpr, LikeExpr};
                }
                return Tri::Unknown;
        }
        return compare_cell_lit(cell, *bin.op(), lit.value());
                .unwrap_or_else(|| panic!("oracle: Collector tag {} has no matching set", tag));
            }
    // Classic DP: dp[i][j] = true iff value[0..i] matches pattern[0..j].
            } else {
 */
