        Operator::LtEq => ord != Ordering::Greater,
    // Segment 0 has rg.first_row==0; segments 1..N have first_row != 0. If the offset
                })
    Sloppy,
    }
        Operator::GtEq => ord != Ordering::Less,
    let mut provider_locks: HashMap<i32, Arc<OnceLock<ProviderHandle>>> = HashMap::new();
/// One iteration. `behavior` decides whether the delegated backend lies (sloppy)
/// 4. Stash the residual (AND of all `original_expr`s) as `pushdown_predicate` so
        }
        Ok(Arc::new(StaticBitsetCollector { matching }) as Arc<dyn RowGroupDocsCollector>)
                schema.clone(),
                _ => rng.gen_range(1_735_689_600_000_000_000_i64..i64::MAX),
    matches.truncate(target);
    let factory = Arc::new(MockDelegatedBackendCollectorFactory { match_sets })
            .column(idx)
    let df = ctx.sql("SELECT * FROM t").await.unwrap();
            ScalarValue::Int64(Some(v))
    let correctness: Arc<dyn RowGroupDocsCollector> = Arc::new(StaticBitsetCollector {
                .unwrap_or_else(|| "len".to_string()),
                Some(Arc::clone(&correctness)),
        let residual_physical = Arc::clone(&residual_physical);
        None => return false,
}
/// `tree` is the full BoolNode; `original_exprs` lets the harness compute peer
        datafusion::physical_plan::execute_stream(Arc::clone(&plan), task_ctx).unwrap();
                    rng.gen_range(1_704_067_200_000_000_000_i64..1_735_689_600_000_000_000_i64)
        }
        };
/// 1. Pre-seed `performance_provider_locks` with `OnceLock`s that hold a
        }
        let factory = Arc::clone(&factory);
    let lit_expr: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(literal));
        .right()
        ($x:expr) => {
#[derive(Debug)]
        schema: loaded.schema.clone(),
    behavior: DelegatedBackendBehavior,
        ));
    for (_, expr) in &dt.original_exprs {
                rows.push(r);
    // ── Always-call correctness collector ──
}
    let target = ((corpus.num_rows() as f64) * density) as usize;
/// match-sets per annotation_id without re-walking the tree.
            let pruner = Arc::new(PagePruner::new(
    ) -> Result<Arc<dyn RowGroupDocsCollector>, String> {
    dt: &DelegationTree,
        let annotation_id = (i + 1) as i32;
                Some(v) => v,
        (CellValue::Boolean(c), ScalarValue::Boolean(l)) => {
            {
fn build_match_sets(
            }
        .indexed_pushdown_filters(true)
        return Err(format!(
                None,
        use datafusion::common::tree_node::TreeNode;
            let v: i64 = match strategy {
/// Mock delegated-backend factory: looks up a per-`provider_key` match-set built
            expected
impl RowGroupDocsCollector for StaticBitsetCollector {
        let schema = loaded.schema.clone();
        let _ = residual_physical.apply(|node| {
        .downcast_ref::<Column>()
) -> Result<(), String> {
use datafusion::common::ScalarValue;
    }
            let v = match strategy {
    // ── Mock delegated-backend factory + provider locks ──
/// `BinaryExpr(Column op Literal)`, which is the only shape `gen_binary_predicate_expr`
        }
            ScalarValue::Float64(Some(v))
        DataType::Float64 => {
    for (_, e) in iter {
//! evaluator consults a delegated-backend (Lucene) collector and AND-intersects its
        cancellation_token: None,
        matching: dt.collector_match_set.clone(),
    };
    let mut rng = StdRng::seed_from_u64(corpus.config.seed.wrapping_add(0xD3EE));
    rng: &mut StdRng,
            Some(bail_unknown!(c).cmp(bail_unknown!(l)))
    for i in 0..num_delegation {
                None,
        let mut indices = std::collections::BTreeSet::new();
use datafusion::execution::context::SessionContext;
                0..=69 => rng.gen_range(0.0..100.0),
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
            },
            ));
        &self,
        Operator::Eq,
/// produce the canonical (correctness ∩ predicates) result.
        .expect("delegation fuzz: original_expr must be BinaryExpr");
//!   narrowing hint.
use crate::indexed_table::page_pruner::PagePruner;
            )
//! Two test scenarios:
            let v = match strategy {
    behavior: DelegatedBackendBehavior,
        let correctness = Arc::clone(&correctness);
        segments: loaded.segments.clone(),
struct MockDelegatedBackendCollectorFactory {
                pruner,
        .expect("delegation fuzz: BinaryExpr lhs must be Column");
            let extras = corpus.num_rows() / 3; // ~33%
    //    it on decoded rows — that's what enforces correctness regardless of how
        _writer_generation: i64,
        (CellValue::Int64(c), ScalarValue::Int64(l)) => {
    behavior: DelegatedBackendBehavior,
    }
    corpus: &Corpus,
            let c = bail_unknown!(c);
//! - **Passthrough**: the mock delegated-backend collector returns *exactly* the
}
    // ── Execute. Same shape as `run_single_collector_query`: SELECT * FROM t,
                segment.writer_generation,
            let l = bail_unknown!(l);
    }
        other => panic!("delegation fuzz: unsupported operator {:?}", other),
    fn create(
    //    pushdown_predicate carries the residual, FilterExec is built by the planner.
}
    let mut iter = original_exprs.iter();
    pub collector_match_set: Vec<i32>,
//! `DelegationPossible` leaves and DF page-pruning isn't selective enough, the
        .batch_size(1024)
use std::sync::{Arc, OnceLock};
            Some(bail_unknown!(c).cmp(bail_unknown!(l)))
        original_exprs,
                _ => rng.gen_range(20_454..i32::MAX),
        if compare_cell_lit_true(cell, *bin.op(), lit.value()) {
            };
    let residual_physical: Arc<dyn PhysicalExpr> = and_all(&dt.original_exprs);
            Some(bail_unknown!(c).cmp(bail_unknown!(l)))
    let mut children: Vec<BoolNode> = Vec::with_capacity(num_delegation + 1);
        acc = acc.intersection(&m).copied().collect();
//! bitset into the candidate set. Regardless of how the delegated backend responds,
                0..=69 => {
        Operator::Lt => ord == Ordering::Less,
        let mut rows = rows_matching_predicate(corpus, expr);
//!
                "MockDelegatedBackend: no match-set for provider_key={}",
    //    the delegated backend responded.
    //
    assert!(!original_exprs.is_empty(), "and_all: empty exprs");
    num_delegation: usize,
                    let c: u32 = rng.gen_range(0..62);
    let mut matches: Vec<i32> = (0..corpus.num_rows() as i32).collect();
        let mut out = vec![0u64; span.div_ceil(64)];
/// Compute the expected result by intersecting:
    };
            "delegation mismatch (behavior={:?}):\n  expected.len={} actual.len={}\n  first_mismatch_at_idx={}\n",
    let plan = df.create_physical_plan().await.unwrap();
    /// `original_exprs` and `collector_match_set` directly.
        for &doc in &self.matching {
            };
/// emits — all `original_expr`s in delegation trees pass through that fn.
        store,
use super::harness::LoadedSegment;
                out[rel / 64] |= 1u64 << (rel % 64);
    let mut out = Vec::new();
    match op {
    loaded: &LoadedSegment,
        Operator::Gt => ord == Ordering::Greater,
    ) -> Result<CollectDocsResult, String> {
///   `AND(Collector{tag=0}, DelegationPossible{id=1, expr1}, ..., DelegationPossible{id=N, exprN})`.
    for (annotation_id, expr) in original_exprs {
                HashMap::new(),
    };
pub(in crate::indexed_table::tests_e2e) enum DelegatedBackendBehavior {
        Arc::new(move |segment, _chunk, stream_metrics, _stats_prune_tree| {
    doc_ids.sort_unstable();
    out
/// corpus. Reuses the same 3VL semantics as the oracle for parity. Only handles
/// or replays exactly (passthrough). Either way, the residual FilterExec must
    /// `provider_key` → set of doc-ids the collector pretends to match.
    macro_rules! bail_unknown {
            Ok(datafusion::common::tree_node::TreeNodeRecursion::Continue)
) -> Vec<i32> {
    // Pre-compute the always-call correctness collector's match-set.
                DelegatedBackendBehavior::Sloppy => "sloppy",
}
use crate::indexed_table::bool_tree::BoolNode;
                let r = rng.gen_range(0..corpus.num_rows() as i32);
    /// Collector returns the TRUE rows plus a random ~30% extra rows. Residual
pub(in crate::indexed_table::tests_e2e) fn generate_delegation_tree(
    let mut stream =
        max_doc: i32,
    /// Collector returns exactly the rows where `original_expr` is TRUE.
    /// `[(annotation_id, original_expr)]` for every DelegationPossible leaf in DFS order.
                provider_key
        }
use crate::indexed_table::eval::RowGroupBitsetSource;
/// `harness::MockCollector` but private to this module so we don't widen visibility.
/// One generated delegation-shape tree:
use datafusion::arrow::array::Array;
};
        tree: BoolNode::And(children),
                70..=84 => rng.gen_range(i32::MIN..0),
    let provider_locks = Arc::new(provider_locks);
///    `ProviderHandle::new_for_test(annotation_id)` — `provider_key == annotation_id`.
    let match_sets = build_match_sets(corpus, &mut rng, &dt.original_exprs, behavior);
        DataType::Timestamp(TimeUnit::Nanosecond, None) => {
use crate::indexed_table::index::RowGroupDocsCollector;
        provider_key: i32,
        pushdown_predicate: Some(Arc::clone(&residual_physical)),
    fn collect_packed_u64_bitset(
                Some(Arc::clone(&residual_physical)),
use rand::SeedableRng;
};
        }
}
        let arr = b
                .position(|(a, b)| a != b)
    while let Some(batch) = stream.next().await {
    use std::cmp::Ordering;
    let eval_factory: EvaluatorFactory = {
    let density = corpus.config.collector_density.clamp(0.0, 1.0);
        for i in 0..arr.len() {
    // ── Residual: AND of all original_exprs. DataFusion's FilterExec re-applies
    let mut out = HashMap::with_capacity(original_exprs.len());
        let schema = b.schema();
                .map(|_| {
) -> Arc<dyn PhysicalExpr> {
        lock.set(ProviderHandle::new_for_test(*annotation_id))
        other => panic!("delegation fuzz: unsupported schema type {:?}", other),
#[derive(Clone, Copy)]
                .iter()
                .collect();
use std::collections::HashMap;
}
 * this file be licensed under the Apache-2.0 license or a
    let field = schema.field(col_idx);
}
    // arithmetic were wrong we'd silently corrupt results on any segment after the first.
        .build();
    ];
pub(in crate::indexed_table::tests_e2e) async fn execute_delegation_tree(
        min_doc: i32,
    corpus: &Corpus,
//!   correctness; result must match the oracle.
    pub original_exprs: Vec<(i32, Arc<dyn PhysicalExpr>)>,
    schema: &datafusion::arrow::datatypes::SchemaRef,
/// `provider_key == annotation_id` in this test (we control both ends).
    }
            }
            }
    }
fn and_all(original_exprs: &[(i32, Arc<dyn PhysicalExpr>)]) -> Arc<dyn PhysicalExpr> {
/// Build `expr0 AND expr1 AND ... AND exprN` as a single PhysicalExpr.
            c.partial_cmp(l)
            expected.len(),
                Arc::clone(&factory),
#[derive(Debug)]
                    }
        DataType::Boolean => ScalarValue::Boolean(Some(rng.gen())),
    let col = bin
use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
    rng: &mut StdRng,
/// uses (private there, inlined here so we don't need to widen its visibility).
        let idx = schema.index_of("__doc_id").expect("__doc_id in batch");
                _ => rng.gen_range(100.0..1e9),
    for (annotation_id, _) in &dt.original_exprs {
    match_sets: HashMap<i32, Vec<i32>>,
                let rel = (doc - min_doc) as usize;
/// - Sloppy: TRUE-rows + ~30% additional random doc-ids (still in [0, num_rows)).
/// - Passthrough: TRUE-rows of `original_expr`.
            Ok(eval)
        }
fn compare_cell_lit_true(cell: &CellValue, op: Operator, lit: &ScalarValue) -> bool {
        DataType::Utf8 => {
    matching: Vec<i32>,
        Operator::NotEq => ord != Ordering::Equal,
            ScalarValue::Utf8(Some(s))
//!   random extras. The extras are filtered out by `FilterExec`'s residual on
            Some(bail_unknown!(c).as_str().cmp(bail_unknown!(l).as_str()))
use futures::StreamExt;
    let op = *ops.choose(rng).unwrap();
        .left()
            };
    out
    // partitions — `EvaluatorFactory` closure then runs once per (partition × segment)
            ));
/// from `original_expr` evaluation (passthrough) or from TRUE-rows + extras (sloppy).
            format!(
                .map(|i| i.to_string())
            Some((*bail_unknown!(c) as i32).cmp(&(*bail_unknown!(l) as i32)))
            if c.is_nan() || l.is_nan() {
        }
) -> HashMap<i32, Vec<i32>> {
        Arc::new(object_store::local::LocalFileSystem::new());
    pub tree: BoolNode,
    }
/// Build per-(annotation_id) match-sets for the mock delegated backend.
                70..=84 => rng.gen_range(0..18_262),
            ScalarValue::Int32(Some(v))
    use datafusion::arrow::datatypes::DataType;
        .downcast_ref::<Literal>()
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(SingleCollectorEvaluator::new(
            .expect("OnceLock set");
        DataType::Int32 => {
            Some(bail_unknown!(c).cmp(bail_unknown!(l)))
 * SPDX-License-Identifier: Apache-2.0
    matches.sort_unstable();
    }
                0..=69 => rng.gen_range(0..10_000),
    EvaluatorFactory, IndexedTableConfig, IndexedTableProvider,
    CollectorCallStrategy, DelegatedBackendCollectorFactory, SingleCollectorEvaluator,
        DataType::Int64 => {
            annotation_id,
        .downcast_ref::<BinaryExpr>()
        store_url,
    let literal = pick_literal_for(rng, field.data_type());
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    let lit = bin
fn pick_literal_for(rng: &mut StdRng, dt: &datafusion::arrow::datatypes::DataType) -> ScalarValue {
/// 3. Wire those into `SingleCollectorEvaluator` via the new factory parameter.
            rows.dedup();
                DelegatedBackendBehavior::Passthrough => "passthrough",
        acc = Arc::new(BinaryExpr::new(acc, Operator::And, Arc::clone(e))) as Arc<dyn PhysicalExpr>;
    match dt {
//! Production behavior under test: when a SingleCollector tree has
/// Build a `Column op Literal` PhysicalExpr — same shape `tree_gen::gen_binary_predicate`
    #[allow(dead_code)]
//!   rows where `original_expr` is TRUE. AND-intersection is a no-op for
    let store: Arc<dyn object_store::ObjectStore> =
use rand::seq::SliceRandom;
        let matching = self.match_sets.get(&provider_key).cloned().ok_or_else(|| {
/// Decides the bitset shape returned by the mock delegated-backend collector.
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        Ok(out.into())
//!   delegated-backend bitset isn't trusted for correctness; it's a candidate
///   correctness collector match-set ∩ {rows where every original_expr is TRUE}
        original_exprs.push((annotation_id, original_expr));
    // Build N DelegationPossible leaves wrapping random binary predicates.
    DelegationTree {
        }
        }
            if let Some(col) = node.downcast_ref::<datafusion::physical_expr::expressions::Column>()
                stream_metrics.ffm_collector_calls.clone(),
        indices.into_iter().collect()
    let mut acc: BTreeSet<i32> = dt.collector_match_set.iter().copied().collect();
            match $x {
 *
    /// FilterExec must filter those out.
                0,
        _doc_min: i32,
        (CellValue::TimestampNanos(c), ScalarValue::TimestampNanosecond(l, _)) => {
    let mut original_exprs: Vec<(i32, Arc<dyn PhysicalExpr>)> = Vec::with_capacity(num_delegation);
            }
                .zip(actual.iter())
        _ => panic!("delegation fuzz: cell/lit type mismatch"),
//!
            original_expr: Arc::clone(&original_expr),
struct StaticBitsetCollector {
    for row in 0..corpus.num_rows() {
        provider_locks.insert(*annotation_id, lock);
    }
        let provider_locks = Arc::clone(&provider_locks);
                0..=69 => rng.gen_range(0..1000),
                None,
        let lock = Arc::new(OnceLock::new());
pub(in crate::indexed_table::tests_e2e) async fn run_delegation_iteration(
    let col_idx = *corpus
        Some(o) => o,
            if doc >= min_doc && doc < max_doc {
        children.push(BoolNode::DelegationPossible {
}
/// End-to-end execution of a delegation tree.
        sort_orders: vec![],
        Operator::NotEq,
//!
    rng: &mut StdRng,
    let pred_cols: Vec<usize> = {
    let ctx = SessionContext::new();
    }
            };
        (CellValue::Date32(c), ScalarValue::Date32(l)) => {
use crate::indexed_table::ffm_callbacks::ProviderHandle;
    children.push(BoolNode::Collector { annotation_id: 0 });
            let s: String = (0..rng.gen_range(1..=6))
        &self,
        DataType::Date32 => {
            doc_ids.push(arr.value(i));
        Operator::Eq => ord == Ordering::Equal,
    }
}
    //   peer_bm offset = (min_doc as i64 - rg.first_row) as u32
        if matches!(behavior, DelegatedBackendBehavior::Sloppy) {
        })?;
    let ops = [
}
}
        let cell = &corpus.cells[col_idx][row];
                Arc::clone(&provider_locks),
    let mut acc = Arc::clone(&iter.next().unwrap().1);
pub(in crate::indexed_table::tests_e2e) struct DelegationTree {
                        _ => (b'A' + (c as u8 - 36)) as char,
        predicate_columns: pred_cols,
impl DelegatedBackendCollectorFactory for MockDelegatedBackendCollectorFactory {
/// Compute the doc-ids where `original_expr` evaluates TRUE, row-by-row over the
            actual.len(),
            for _ in 0..extras {
fn expected_doc_ids(corpus: &Corpus, dt: &DelegationTree) -> Vec<i32> {
                &schema,
    let col_idx = rng.gen_range(1..schema.fields().len());
/// Mock collector whose match set is fixed at construction. Same shape as
use super::corpus::{CellValue, Corpus};
            out.push(row as i32);
        collector_match_set: matches,
        }
            let v = match strategy {
                        10..=35 => (b'a' + (c as u8 - 10)) as char,
        evaluator_factory: eval_factory,
fn gen_binary_predicate_expr(
            .downcast_ref::<datafusion::arrow::array::Int32Array>()
/*
/// Generate a SingleCollector-shape tree with `num_delegation` delegation leaves.
    let mut doc_ids: Vec<i32> = Vec::new();
        Operator::Lt,
    /// Kept for diagnostics / panic messages even though execution drives off
    }
        })
    use datafusion::arrow::datatypes::{DataType, TimeUnit};
    // and exercises the multi-segment offset math:
            rows.sort_unstable();
    acc
///
    acc.into_iter().collect()
        });
                _ => rng.gen_range(10_000..i64::MAX),
        let original_expr = gen_binary_predicate_expr(rng, &corpus.schema);
/// Returns true iff `cell op lit` is TRUE under SQL 3VL (UNKNOWN / NULL → false,
    let strategy = rng.gen_range(0..100u32);
            }
///    DataFusion's FilterExec re-applies it on decoded batches.
    let ord = match ord {
        let b = batch.unwrap();
    ctx.register_table("t", provider).unwrap();
    matches.shuffle(rng);
        _context_id: i64,
//!   `original_expr`. Final result still matches the oracle. This proves the
        }
 */
                        0..=9 => (b'0' + c as u8) as char,
//! final result must equal `Predicate(original_expr)` evaluated row-by-row.
use datafusion::logical_expr::Operator;
        Operator::LtEq,
        (CellValue::Int32(c), ScalarValue::Int32(l)) => {
        }
    //
            .expect("__doc_id is Int32");
    }));
            match behavior {
}
use crate::indexed_table::index::CollectDocsResult;
                70..=84 => rng.gen_range(0..1_704_067_200_000_000_000_i64),
//! Fuzz coverage for performance-delegated leaves (`BoolNode::DelegationPossible`).
                CollectorCallStrategy::FullRange,
    corpus: &Corpus,
        .col_idx
    Passthrough,
fn rows_matching_predicate(corpus: &Corpus, expr: &Arc<dyn PhysicalExpr>) -> Vec<i32> {
use crate::indexed_table::eval::single_collector::{
/// matching `oracle::compare_cell_lit`'s top-level "row matches iff Tri::True" rule).
    });
        let m: BTreeSet<i32> = rows_matching_predicate(corpus, expr).into_iter().collect();
                indices.insert(col.index());
        });
    Arc::new(BinaryExpr::new(col_expr, op, lit_expr))
            .as_any()
            };
    if expected != actual {
        out.insert(*annotation_id, rows);
            ScalarValue::TimestampNanosecond(Some(v), None)
    loaded: &LoadedSegment,
                0..=69 => rng.gen_range(18_262..20_454),
        }
    let actual = execute_delegation_tree(corpus, loaded, dt, behavior).await;
}
/// The Collector tag is always 0; delegation annotation ids are 1..=num_delegation.
 * The OpenSearch Contributors require contributions made to
        query_config: Arc::new(qc),
        .get(col.name())
}
    Ok(())
        // provider_key == annotation_id by construction.
                70..=84 => rng.gen_range(-1e9..0.0),
//! the residual `original_expr` is re-applied by DataFusion's `FilterExec` — so the
use datafusion::physical_expr::PhysicalExpr;
        }
        .expect("delegation fuzz: BinaryExpr rhs must be Literal");
        emit_row_ids: false,
        .target_partitions(corpus.config.target_partitions.max(1))
use crate::indexed_table::table_provider::{
        as Arc<dyn DelegatedBackendCollectorFactory>;
) -> DelegationTree {
    corpus: &Corpus,
    }
                }
}
    use std::collections::BTreeSet;
        (CellValue::Utf8(c), ScalarValue::Utf8(l)) => {
    dt: &DelegationTree,
    }
    };
        _doc_max: i32,
        Operator::GtEq,
        prune_tree_config: None,
                None,
                    match c {
    let ord: Option<Ordering> = match (cell, lit) {
        }
            ScalarValue::Date32(Some(v))
                None => return false,
    let bin = expr
                _ => rng.gen_range(1000..i32::MAX),
    /// Doc-id set the always-call correctness collector returns.
        (CellValue::Float64(c), ScalarValue::Float64(l)) => {
    // Honor the corpus's target_partitions so multi-segment fixtures fan out across
        let span = (max_doc - min_doc) as usize;
                Arc::clone(&segment.metadata),
use rand::rngs::StdRng;
            assert!(arr.is_valid(i), "__doc_id is non-null");
        Operator::Gt,
//! - **Sloppy delegated backend**: the mock returns a *superset* — TRUE rows plus
    let task_ctx = ctx.task_ctx();
    doc_ids
    let col_expr: Arc<dyn PhysicalExpr> = Arc::new(Column::new(field.name(), col_idx));
        sort_fields: vec![],
    let expected = expected_doc_ids(corpus, dt);
 * compatible open source license.
use rand::Rng;
            let v = match strategy {
        }
        .unwrap_or_else(|| panic!("column {:?} not in corpus", col.name()));
                return false;
                70..=84 => rng.gen_range(i64::MIN..0),
    original_exprs: &[(i32, Arc<dyn PhysicalExpr>)],
/// 2. Build `MockDelegatedBackendCollectorFactory` from `match_sets`.
